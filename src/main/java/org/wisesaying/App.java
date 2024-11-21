package org.wisesaying;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {
    ArrayList<WiseSaying> wiseSayings = new ArrayList<>();
    int index = 1; // 마지막으로 저장한 번호
    Scanner cmd; // 스캐너 활성화

    // 등록 데이터 입력
    public WiseSaying inputWiseSaying() {
        String content = checkData("명언"); // 공백확인 후 대입
        String author = checkData("작가");

        return new WiseSaying(index, content, author); // 등록 객체 리턴, index를 id에 삽입
    }

    // 등록(리스트에 삽입)
    public void addWiseSaying(WiseSaying inputWiseSaying) {
        wiseSayings.add(inputWiseSaying);
        System.out.println(">>> " + index + "번 명언이 등록되었습니다.\n");
        index++;
    }

    // 출력
    public void printWiseSaying(WiseSaying outputWiseSaying) {
        System.out.println(outputWiseSaying.getId() + " / "
                         + outputWiseSaying.getContent() + " / "
                         + outputWiseSaying.getAuthor() );
    }

    // 목록 출력
    public void printAllWiseSaying() {
        if (wiseSayings.isEmpty()) {
            System.out.println(">>> 등록된 명언이 없습니다.\n");
        } else {
            System.out.println("==============================================");
            System.out.println("번호 / 명언 / 작가");
            for (int i = wiseSayings.size(); 0 < i; i--) { // 정렬은 최신저장순
                printWiseSaying(wiseSayings.get(i-1));
            }
            System.out.println("==============================================\n");
        }
    }

    // 명언 삭제
    public void deleteWiseSaying(String cmd) {
        int indexbf = cmd.indexOf("=");
        String targetIndex = cmd.substring(indexbf+1);
        int targetIndexNum = Integer.parseInt(targetIndex);
        if(targetIndexNum > index) {
            System.out.println(">>> 존재하지 않는 번호입니다. 다시 입력해주세요.\n");
        } else {
            wiseSayings.remove(targetIndexNum-1);
            System.out.println(">>> " + targetIndexNum + "번 명언이 삭제되었습니다.\n");
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
                System.out.println("> " + dataType + "이(가) 정상 입력되었습니다.");
                return inputData;
            }
        }
    }
}
