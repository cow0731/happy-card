package com.group.happycard;

import com.group.happycard.domain.WriteCard;
import com.group.happycard.domain.WriteCardRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HappyCardApplicationTests {

	@Autowired
	private WriteCardRepository writeCardRepository;

	@Test
	void contextLoads() {
		WriteCard writeCard = new WriteCard();
		writeCard.setWrite_contents("test content");
		writeCard.setCard_id(1);
		WriteCard result = writeCardRepository.save(writeCard);
		System.out.println(result);
	}

}
