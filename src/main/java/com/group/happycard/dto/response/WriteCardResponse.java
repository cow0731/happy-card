package com.group.happycard.dto.response;

import com.group.happycard.domain.WriteCard;

public class WriteCardResponse {

    private Long write_card_id;
    private Long card_id;
    private String write_contents;

    public WriteCardResponse(WriteCard writeCard){
        this.write_card_id = writeCard.getWrite_card_id();
        this.card_id = writeCard.getCard_id();
        this.write_contents = writeCard.getWrite_contents();
    }


    public Long getCard_id() {
        return card_id;
    }

    public String getWrite_contents() {
        return write_contents;
    }
}
