package com.group.happycard.service;

import com.group.happycard.domain.Write_Card;
import com.group.happycard.domain.Write_CardRepository;
import org.springframework.transaction.annotation.Transactional;

public class WriteCardService {

    private final Write_CardRepository writeCardRepository;
    public WriteCardService(Write_CardRepository writeCardRepository){
        this.writeCardRepository =writeCardRepository;
    }



}
