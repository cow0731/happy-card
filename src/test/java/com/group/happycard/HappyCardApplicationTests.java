package com.group.happycard;

import com.group.happycard.domain.WriteCard;
import com.group.happycard.domain.WriteCardRepository;
import com.group.happycard.dto.response.WriteCardResponse;
import com.group.happycard.service.CardService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HappyCardApplicationTests {

	@Autowired
	private WriteCardRepository writeCardRepository;
	@Autowired
	private CardService cardService;

	@Test
	void contextLoads() {
		WriteCard writeCard = new WriteCard();
		writeCard.setWriteContents("test content");
		writeCard.setCardId(1);
		WriteCard result = writeCardRepository.save(writeCard);
		System.out.println(result);
	}

	@Test
	void getWriteCard(){
		WriteCard result = cardService.getWriteCard(3L);
		System.out.println("---------------------------------------------");
		System.out.println(result.getCardId());
		System.out.println(result.getWriteContents());
	}

}
