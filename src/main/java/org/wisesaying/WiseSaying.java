package org.wisesaying;

public class WiseSaying {
    // 필드
    private String wiseSaying;
    private String writer;

    // 생성자
    protected WiseSaying(String wiseSaying, String writer) {
        this.wiseSaying = wiseSaying;
        this.writer = writer;
    }

    // 출력 메소드
    protected void printInfo() {
        System.out.println("명언: " + wiseSaying);
        System.out.println("작가: " + writer);
    }

    // Get Set
    protected String getWiseSaying() {
        return wiseSaying;
    }
    protected void setWiseSaying(String wiseSaying) {
        this.wiseSaying = wiseSaying;
    }
    protected String getWriter() {
        return writer;
    }
    protected void setWriter(String writer) {
        this.writer = writer;
    }
}