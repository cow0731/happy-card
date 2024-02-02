package com.group.happycard.service;

import com.group.happycard.domain.CardRepository;
import com.group.happycard.domain.WriteCard;
import com.group.happycard.domain.WriteCardRepository;
import com.group.happycard.dto.response.CardResponse;
import com.group.happycard.dto.response.WriteCardResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
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

    public Long register(Long cardId ,String writeContents){
        WriteCard writeCard = new WriteCard();
        writeCard.setCardId(cardId);
        writeCard.setWriteContents(writeContents);
        return writeCardRepository.save(writeCard).getWriteCardId();
    }

    public WriteCard getWriteCard(Long writeCardId){
        Optional<WriteCard> result = writeCardRepository.findById(writeCardId);
        return result.orElseThrow();
    }
}
