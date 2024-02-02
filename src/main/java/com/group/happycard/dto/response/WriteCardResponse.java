package com.group.happycard.dto.response;

import com.group.happycard.domain.WriteCard;

public class WriteCardResponse {

    private Long writeCardId;
    private Long cardId;
    private String writeContents;

    public WriteCardResponse(WriteCard writeCard){
        this.writeCardId = writeCard.getWriteCardId();
        this.cardId = writeCard.getCardId();
        this.writeContents = writeCard.getWriteContents();
    }

    public Long getWriteCardId() {
        return writeCardId;
    }

    public Long getCardId() {
        return cardId;
    }

    public String getWriteContents() {
        return writeContents;
    }
}
