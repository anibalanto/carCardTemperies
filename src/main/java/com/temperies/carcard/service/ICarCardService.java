package com.temperies.carcard.service;

import com.temperies.carcard.dto.CarCardDTO;
import com.temperies.carcard.dto.CarCardRequestDTO;
import com.temperies.carcard.dto.CarCardResponseDTO;

import java.io.IOException;
import java.util.List;

public interface ICarCardService {

    List<CarCardResponseDTO> getAllCards();

    List<CarCardResponseDTO> getPageCards(Integer page);

    CarCardResponseDTO createCard(CarCardRequestDTO noteRequestDTO) throws IOException;

    CarCardResponseDTO getCardById(Long noteId) throws IOException;

    CarCardResponseDTO updateCard(Long noteId, CarCardDTO carCardDTO);

    void deleteCard(Long noteId);

}