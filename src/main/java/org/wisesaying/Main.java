package org.wisesaying;

import java.util.Scanner;

public class Main {
    public static void printMenu() {
        System.out.println("====== 명언 앱 ======");
        System.out.println(">> 1. 종료");
        System.out.println(">> 2. 등록");
        System.out.println(">> 3. 전체 목록");
        System.out.print  ("입력 : ");
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        App app = new App();

        while(true) {
            printMenu();
            String cmd = sc.nextLine();

            // 1. 종료 메뉴
            if(cmd.equals("종료") || cmd.equals("1")) {
                System.out.println("> 앱이 종료되었습니다.\n");
                break;
            }

            // 2. 등록 메뉴
            if(cmd.equals("등록") || cmd.equals("2")) {
                System.out.println("▶▶ 등록 ◀◀");
                System.out.println("> 등록할 명언과 작가를 입력하세요.");
                app.addWiseSaying(app.inputWiseSayingData());
            }

            // 3. 전체 조회 메뉴
            if(cmd.equals("전체 목록") || cmd.equals("3")) {
                System.out.println("▶▶ 명언 목록 ◀◀");
                app.printAllWiseSaying();
            }

        }

        sc.close();
    }
}