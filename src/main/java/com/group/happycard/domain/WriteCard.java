package com.group.happycard.domain;

import jakarta.persistence.*;

@Entity
public class WriteCard {
    @Id
    @Column(name = "write_card_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long write_card_id = null;

    @Column(name = "card_id")
    public long card_id;

    @Column(name = "write_contents")
    public String write_contents;

    public WriteCard(long card_id, String write_contents){
        this.card_id = card_id;
        this.write_contents = write_contents;
    }
    public WriteCard(){

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

    public void setCard_id(long card_id) {
        this.card_id = card_id;
    }

    public void setWrite_contents(String write_contents) {
        this.write_contents = write_contents;
    }
}
