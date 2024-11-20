package org.wisesaying;

import java.util.Scanner;

public class App {
    public static void printMenu() {
        System.out.println("====== 명언 앱 ======");
        System.out.println(">> 1. 종료");
        System.out.print  ("입력 : ");
    }

    public void run() {
        Scanner sc = new Scanner(System.in);

        while(true) {
            printMenu();
            String choiceMenu = sc.nextLine();

            // 종료 메뉴
            if(choiceMenu.equals("종료") || choiceMenu.equals("1")) {
                System.out.println("앱이 종료되었습니다.\n");
            }

        }
    }
}
