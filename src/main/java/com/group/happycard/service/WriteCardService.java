package com.group.happycard.service;

import com.group.happycard.domain.WriteCardRepository;

public class WriteCardService {

    private final WriteCardRepository writeCardRepository;
    public WriteCardService(WriteCardRepository writeCardRepository){
        this.writeCardRepository =writeCardRepository;
    }



}
