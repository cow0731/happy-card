package com.group.happycard.controller;

import com.group.happycard.domain.Write_Card;
import com.group.happycard.dto.response.CardResponse;
import com.group.happycard.service.CardService;
import com.group.happycard.service.WriteCardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/write-card/{id}")
    public String writeCard(Model model, @PathVariable Long id) {
        model.addAttribute("card_id", id);
        System.out.println(id);
        return "/pages/write-card";
    }

    @PostMapping("/write-card/{id}")
    public void registCardMessage(@RequestParam("write_content") String write_content, @RequestParam("id") Long id){
        System.out.println(write_content);
        System.out.println(id);
        Long writecardId = cardService.register(id,write_content);
        System.out.println(writecardId);

    }
}
