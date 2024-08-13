package com.example.quotify;

public class model {
    int length;
    String _id,author,authorSlug,content;
    String[] tags;

    public model(int length, String _id, String author, String authorSlug, String content, String[] tags) {
        this.length = length;
        this._id = _id;
        this.author = author;
        this.authorSlug = authorSlug;
        this.content = content;
        this.tags = tags;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthorSlug() {
        return authorSlug;
    }

    public void setAuthorSlug(String authorSlug) {
        this.authorSlug = authorSlug;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }
}
