package com.temperies.carcard.exception;

import java.io.IOException;

public class CardImageNotFound extends IOException {
    public CardImageNotFound(Long cardId) {
        super(String.format("Image from card %d not found", cardId));
    }
}
