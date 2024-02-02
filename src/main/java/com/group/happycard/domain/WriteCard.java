package com.group.happycard.domain;

import jakarta.persistence.*;

@Entity
public class WriteCard {

    @Id
    @Column(name = "write_card_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long writeCardId = null;

    @Column(name = "card_id")
    private long cardId;

    @Column(name = "write_contents")
    private String writeContents;

    @Column(name = "writer_name")
    private String writerName;

    public WriteCard(long cardId, String writeContents){
        this.cardId = cardId;
        this.writeContents = writeContents;
    }

    public WriteCard() {

    }

    public Long getWriteCardId() {
        return writeCardId;
    }

    public long getCardId() {
        return cardId;
    }

    public void setCardId(long cardId) {
        this.cardId = cardId;
    }

    public String getWriteContents() {
        return writeContents;
    }

    public void setWriteContents(String writeContents) {
        this.writeContents = writeContents;
    }

    public String getWriterName() {
        return writerName;
    }

    public void setWriterName(String writerName) {
        this.writerName = writerName;
    }
}
