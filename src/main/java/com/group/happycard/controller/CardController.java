package com.group.happycard.controller;

import com.group.happycard.domain.WriteCard;
import com.group.happycard.dto.response.CardResponse;
import com.group.happycard.service.CardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String registCardMessage(@RequestParam("write_content") String write_content, @RequestParam("id") Long id, RedirectAttributes redirectAttributes){
        System.out.println(write_content);
        System.out.println(id);
        Long writeCardId = cardService.register(id,write_content);
        System.out.println(writeCardId);

        redirectAttributes.addAttribute("writeCardId",writeCardId);
        return "redirect:/read-card";
    }

    @GetMapping("/read-card")
    public String readCardMessage(@RequestParam("writeCardId")Long writeCardId, Model model){
        System.out.println("----------------------------------------");
        System.out.println(writeCardId);
        WriteCard writeCard = cardService.getWriteCard(writeCardId);
        System.out.println(writeCard.card_id);
        System.out.println(writeCard.write_contents);
        model.addAttribute("card_id",writeCard.card_id);
        model.addAttribute("writeContent",writeCard.getWrite_contents());

        return "pages/read-card";
    }
}

