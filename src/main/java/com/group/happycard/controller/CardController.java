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
    public String registCardMessage(@RequestBody String jsonData) {
        JSONArray jsonArray = new JSONArray(jsonData);
        JSONObject jsonObject = null;
        String id = null;
        Long longId = null;
        String write_content = null;

        for (int i = 0; i < jsonArray.length(); i++) {
            jsonObject = jsonArray.getJSONObject(i);
            id = String.valueOf(jsonObject.get("id"));
            write_content = String.valueOf(jsonObject.get("write_content"));
            longId = Long.parseLong(id);
        }
        System.out.println(write_content);
        System.out.println(longId);
        Long writeCardId = cardService.register(longId ,write_content);
        System.out.println(writeCardId);

//        redirectAttributes.addAttribute("writeCardId",writeCardId);
//        redirectAttributes.addFlashAttribute("result",writeCardId);
        return String.valueOf(writeCardId);
    }

    @GetMapping("/read-card")
    public String readCardMessage(@RequestParam("writeCardId")Long writeCardId, Model model) {
        WriteCard writeCard = cardService.getWriteCard(writeCardId);
        model.addAttribute("card_id",writeCard.card_id);
        model.addAttribute("writeContent",writeCard.getWrite_contents());
        return "pages/read-card";
    }
}

