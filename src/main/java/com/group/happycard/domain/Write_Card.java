package com.group.happycard.domain;

import jakarta.persistence.*;

@Entity
public class Write_Card {
    @Id
    @Column(name = "write_card_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long write_card_id = null;

    @Column(name = "card_id")
    private long card_id;

    @Column(name = "write_contents")
    private String write_contents;

    public Write_Card(long card_id, String write_contents){
        this.card_id = card_id;
        this.write_contents = write_contents;
    }
    public Write_Card(){

    }

    public Long getWrite_card_id() {
        return write_card_id;
    }

    public long getCard_id() {
        return card_id;
    }

    public String getWrite_contents() {
        return write_contents;
    }

    public void setWrite_card_id(Long write_card_id) {
        this.write_card_id = write_card_id;
    }

    public void setCard_id(long card_id) {
        this.card_id = card_id;
    }

    public void setWrite_contents(String write_contents) {
        this.write_contents = write_contents;
    }
}
