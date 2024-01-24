package com.group.happycard.dto.response;

import com.group.happycard.domain.Card;

import java.sql.Date;

public class CardResponse {

    private Long id;
    private String name;
    private String url;
    private Date date;
    private Boolean valid;

    public CardResponse(Long id, String name, String url, Date date, Boolean valid) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.date = date;
        this.valid = valid;
    }

    public CardResponse(Card card) {
        this.id = card.getId();
        this.name = card.getName();
        this.url = card.getUrl();
        this.date = card.getDate();
        this.valid = card.getValid();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public Date getDate() {
        return date;
    }

    public Boolean getValid() {
        return valid;
    }
}
