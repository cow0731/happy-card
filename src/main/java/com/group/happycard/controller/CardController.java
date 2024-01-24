package com.group.happycard.controller;

import com.group.happycard.dto.response.CardResponse;
import com.group.happycard.service.CardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CardController {

    private final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping("/")
    public String index(Model model) {
        List<CardResponse> cardList = cardService.getCards();
        model.addAttribute("cardList", cardList);
        return "index";
    }
}
