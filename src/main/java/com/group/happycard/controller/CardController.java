package com.group.happycard.controller;

import com.group.happycard.domain.WriteCard;
import com.group.happycard.dto.response.CardResponse;
import com.group.happycard.service.CardService;
import org.json.JSONArray;
import org.json.JSONObject;
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
        return "pages/write-card";
    }

    @ResponseBody
    @PostMapping("/write-card/{id}")
    public String registerCardMessage(@RequestBody String jsonData, @PathVariable String id) {
        JSONArray jsonArray = new JSONArray(jsonData);
        JSONObject jsonObject = null;
        String cardId = null;
        Long longCardId = null;
        String writeContents = null;
        String writerName = null;

        for (int i = 0; i < jsonArray.length(); i++) {
            jsonObject = jsonArray.getJSONObject(i);
            cardId = String.valueOf(jsonObject.get("id"));
            writeContents = String.valueOf(jsonObject.get("write_content"));
            writerName = String.valueOf(jsonObject.get("writer_name"));
            longCardId = Long.parseLong(cardId);
        }
        System.out.println(longCardId);
        System.out.println(writeContents);
        System.out.println(writerName);
        Long writeCardId = cardService.register(longCardId ,writeContents, writerName);
        System.out.println(writeCardId);

        return String.valueOf(writeCardId);
    }

    @GetMapping("/read-card")
    public String readCardMessage(@RequestParam("writeCardId")Long writeCardId, Model model) {
        WriteCard writeCard = cardService.getWriteCard(writeCardId);
        model.addAttribute("card_id",writeCard.getCardId());
        model.addAttribute("writeContent",writeCard.getWriteContents());
        return "pages/read-card";
    }
}

