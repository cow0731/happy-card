package com.group.happycard.service;

import com.group.happycard.domain.CardRepository;
import com.group.happycard.dto.response.CardResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CardService {
    private final CardRepository cardRepository;

    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Transactional(readOnly = true)
    public List<CardResponse> getCards() {
        return cardRepository.findAll().stream()
                .map(CardResponse::new)
                .collect(Collectors.toList());
    }
}
