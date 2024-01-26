package com.group.happycard;

import com.group.happycard.domain.Write_Card;
import com.group.happycard.domain.Write_CardRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HappyCardApplicationTests {

	@Autowired
	private Write_CardRepository writeCardRepository;

	@Test
	void contextLoads() {
		Write_Card writeCard = new Write_Card();
		writeCard.setWrite_contents("test content");
		writeCard.setCard_id(1);
		Write_Card result = writeCardRepository.save(writeCard);
		System.out.println(result);
	}

}
