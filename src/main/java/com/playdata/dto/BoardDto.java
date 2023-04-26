package com.playdata.dto;

public class BoardDto {
    private int id;
    private String title;
    private String contents;
    private String author;
    private String created_at;

    public BoardDto(int id, String title, String contents, String author, String created_at) {
        this.id = id;
        this.title = title;
        this.contents = contents;
        this.author = author;
        this.created_at = created_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public static BoardBuilder builder() {
        return new BoardBuilder();
    }

    public static class BoardBuilder{
        private int id;
        private String title;
        private String contents;
        private String author;
        private String created_at;

        public BoardBuilder id(int id) {
            this.id = id;
            return this;
        }

        public BoardBuilder title(String title) {
            this.title = title;
            return this;
        }

        public BoardBuilder contents(String contents) {
            this.contents = contents;
            return this;
        }

        public BoardBuilder author(String author) {
            this.author = author;
            return this;
        }

        public BoardBuilder created_at(String created_at) {
            this.created_at = created_at;
            return this;
        }

        public BoardDto build() {
            return new BoardDto(id, title, contents, author, created_at);
        }
    }
}
