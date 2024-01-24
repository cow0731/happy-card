package com.group.happycard.domain;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class Card {

    @Id
    @Column(name = "card_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;

    @Column(length = 50, name = "card_name")
    private String name;

    @Column(nullable = false, name = "card_url")
    private String url;

    @Column(name = "card_date")
    private Date date;

    @Column(nullable = false, name = "card_valid")
    private Boolean valid;

    protected Card() {

    }

    public Card(String name, String url, Date date, Boolean valid) {
        this.name = name;
        this.url = url;
        this.date = date;
        this.valid = valid;
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
