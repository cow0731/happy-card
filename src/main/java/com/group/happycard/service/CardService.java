package com.group.happycard.service;

import com.group.happycard.domain.CardRepository;
import com.group.happycard.domain.WriteCard;
import com.group.happycard.domain.WriteCardRepository;
import com.group.happycard.dto.response.CardResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CardService {
    private final CardRepository cardRepository;
    private final WriteCardRepository writeCardRepository;

    public CardService(CardRepository cardRepository, WriteCardRepository writeCardRepository) {
        this.cardRepository = cardRepository;
        this.writeCardRepository = writeCardRepository;
    }

    @Transactional(readOnly = true)
    public List<CardResponse> getCards() {
        return cardRepository.findAll().stream()
                .map(CardResponse::new)
                .collect(Collectors.toList());
    }

    public Long register(Long cardId ,String writeContent){
        WriteCard writeCard = new WriteCard();
        writeCard.setCard_id(cardId);
        writeCard.setWrite_contents(writeContent);
        long writecardId = writeCardRepository.save(writeCard).getWrite_card_id();
        return writecardId;
    }
}
