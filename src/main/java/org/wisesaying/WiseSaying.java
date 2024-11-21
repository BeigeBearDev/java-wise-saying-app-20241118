package org.wisesaying;

public class WiseSaying {
    // 필드
    private int id;
    private String content;
    private String author;

    // 생성자
    protected WiseSaying(String content, String author) {
        this.content = content;
        this.author = author;
    }

    protected WiseSaying(int id, String content, String author) {
        this.id = id;
        this.content = content;
        this.author = author;
    }

    // 출력
    protected void printInfo() {
        System.out.println("명언: " + content);
        System.out.println("작가: " + author);
    }

    // Get Set
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    // toString
    /*
    @Override
    public static String toString() {
        return this.id + " / " + this.content + " / " + this.author;
        // 번호 / 명언 / 작가
    }
     */

}