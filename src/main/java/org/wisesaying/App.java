package org.wisesaying;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {
    private Scanner cmd; // 스캐너 활성화
    private ArrayList<WiseSaying> wiseSayings = new ArrayList<>();
    private int index = 1; // 마지막으로 저장한 번호

    // 등록 데이터 입력 메소드
    public WiseSaying inputWiseSaying() {
        String content = checkData("명언"); // 공백확인 후 대입
        String author = checkData("작가");

        return new WiseSaying(index, content, author); // 등록 객체 리턴, index를 id에 삽입
    }

    // 등록(리스트에 삽입) 메소드
    public void addWiseSaying(WiseSaying inputWiseSaying) {
        wiseSayings.add(inputWiseSaying);
        System.out.println(">>> " + index + "번 명언이 등록되었습니다.\n");
        index++;
    }

    // 목록 출력 메소드
    public void printAllWiseSaying() {
        if (wiseSayings.isEmpty()) {
            System.out.println(">>> 등록된 명언이 없습니다.\n");
        } else {
            System.out.println("==============================================");
            System.out.println("번호 / 명언 / 작가");
            for (int i = wiseSayings.size()-1; i >= 0; i--) { // 정렬은 최신저장순
                printWiseSaying(wiseSayings.get(i));
            }
            System.out.println("==============================================\n");
        }
    }

    // 명언 삭제 메소드 (예외 적용)
    public void deleteWiseSaying(String cmd) {
        WiseSaying targetWiseSaying = findTargetWiseSaying(cmd, "삭제");
        if(targetWiseSaying == null) {
            return; // 유효하지 않음
        }

        wiseSayings.remove(targetWiseSaying);
        System.out.println(">>> " + targetWiseSaying.getId() + "번 명언이 삭제되었습니다.\n");
    }

    // 명언 수정 메소드
    public void updateWiseSaying(String cmd, String newContent, String newAuthor) {
        WiseSaying targetWiseSaying = findTargetWiseSaying(cmd, "수정");
        if (targetWiseSaying == null) {
            return; // 유효하지 않은 명령이므로 종료
        }
        targetWiseSaying.setContent(newContent);
        targetWiseSaying.setAuthor(newAuthor);
        System.out.println(">>> " + targetWiseSaying.getId() + "번 명언이 수정되었습니다.\n");
    }

    // 단일 명언 출력
    public void printWiseSaying(WiseSaying outputWiseSaying) {
        System.out.println(outputWiseSaying); // toString 생략
    }

    // {삭제&수정} 메소드에서 해당 객체 검증
    public WiseSaying findTargetWiseSaying(String cmd, String action) {
        // 명령에서 분리
        System.out.println("디버깅 - cmd: " + cmd + ", action: " + action);

        if (!cmd.startsWith(action + "?id=")) {
            System.out.println(">>> 잘못된 명령 형식입니다. 형식: " + action + "?id={해당번호}\n");
            return null;
        }
        try {
            // {action}?id= 이후의 번호 추출
            String targetIdString = cmd.substring(cmd.indexOf("=") + 1).trim();
            int targetId = Integer.parseInt(targetIdString);

            // targetId로 객체 찾기
            for (WiseSaying wiseSaying : wiseSayings) {
                if (wiseSaying.getId() == targetId) {
                    return wiseSaying;
                }
            }

            // 객체 null여부 확인
            System.out.println(">>> 존재하지 않는 번호입니다. 다시 입력해주세요.\n");
            return null;
            }
        catch (NumberFormatException e) {
            System.out.println(">>> 잘못된 형식입니다. 숫자로 입력해주세요.\n");
            return null;
        }
    }

    // 데이터 공백 및 특수문자 확인
    public String checkData(String dataType) {
        cmd = new Scanner(System.in);

        while (true) {
            //데이터 타입 입력
            System.out.print(dataType + ": ");
            String inputData = cmd.nextLine();

            // 특수문자 확인(알파벳, 숫자, 한글을 제외한 모든문자)
            String regex = "[^a-zA-Z0-9가-힣ㄱ-ㅎㅏ-ㅣ]";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(inputData);

            // 앞뒤공백제거 > 공백 확인
            if(inputData.trim().isEmpty()) {
                System.out.println("> 입력내용 없음, 다시 입력해주세요.");
            // 특수문자 포함 확인
            } else if(matcher.find()) {
                System.out.println("> 특수문자 포함, 다시 입력해주세요.");
            } else {
                // System.out.println("> " + dataType + "이(가) 정상 입력되었습니다.");
                return inputData;
            }
        }
    }
}
