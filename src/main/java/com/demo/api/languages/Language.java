package com.demo.api.languages;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "mainLanguages")
public class Language {
    @Id
    private String id;
    private String title;
    private String url;
    private int rank;

    public Language() {
    }

    public Language(String title, String url, int rank) {
        this.title = title;
        this.url = url;
        this.rank = rank;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public int getRank() {
        return rank;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}
