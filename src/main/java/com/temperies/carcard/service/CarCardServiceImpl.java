package com.temperies.carcard.service;

import com.temperies.carcard.dto.CarCardDTO;
import com.temperies.carcard.dto.CarCardRequestDTO;
import com.temperies.carcard.exception.ResourceNotFoundException;
import com.temperies.carcard.model.CarCard;
import com.temperies.carcard.model.Company;
import com.temperies.carcard.repository.CardRepository;
import com.temperies.carcard.repository.CompanyRepository;
import com.temperies.carcard.utils.ListMapper;
import com.temperies.carcard.dto.CarCardResponseDTO;
import org.apache.tomcat.util.codec.binary.Base64;
import org.modelmapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class CarCardServiceImpl implements ICarCardService {

    CardRepository cardRepository;
    CompanyRepository companyRepository;
    ModelMapper modelMapper;
    ListMapper listMapper;

    @Autowired
    CarCardServiceImpl(
            CardRepository cardRepository,
            CompanyRepository companyRepository,
            ModelMapper modelMapper,
            ListMapper listMapper) {
        this.cardRepository = cardRepository;
        this.companyRepository = companyRepository;
        this.listMapper = listMapper;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<CarCardResponseDTO> getAllCards() {
        List<CarCard> cards = cardRepository.findAll();
        return listMapper.mapList(cards, CarCardResponseDTO.class);
    }

    @Override
    public List<CarCardResponseDTO> getPageCards(Integer page) {
        Pageable p = PageRequest.of(page, 3);
        Page<CarCard> cards = cardRepository.findAll(p);
        return listMapper.mapList(cards.toList(), CarCardResponseDTO.class);
    }

    @Override
    public CarCardResponseDTO createCard(
            CarCardRequestDTO carCardRequestDTO) throws IOException {

        CarCard card = modelMapper.map(carCardRequestDTO, CarCard.class);

        Long companyId = carCardRequestDTO.getCompanyId();

        Company company = companyRepository
                .findById( companyId )
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "company",
                                "company_id",
                                companyId));

        card.setCompany( company );
        card.setImage(Base64.decodeBase64(carCardRequestDTO.getImage()));

        CarCard cardReq = cardRepository.save(card);

        CarCardResponseDTO response = modelMapper.map(cardReq, CarCardResponseDTO.class);
        response.setImage(carCardRequestDTO.getImage());
        return response;
    }

    @Override
    public CarCardResponseDTO getCardById(
            Long cardId) throws IOException {

        CarCard card = cardRepository.findById(cardId)
                .orElseThrow(() -> new ResourceNotFoundException("card", "id", cardId));

        CarCardResponseDTO cardResponseDTO = modelMapper.map(card, CarCardResponseDTO.class);

        cardResponseDTO.setImage( Base64.encodeBase64String( card.getImage() ) );

        return cardResponseDTO;
    }

    @Override
    public CarCardResponseDTO updateCard(
            Long cardId,
            CarCardDTO carCardDTO) {

        CarCard uCard = modelMapper.map(carCardDTO, CarCard.class);
        CarCard card = cardRepository.findById(cardId)
                .orElseThrow(() -> new ResourceNotFoundException("card", "id", cardId));

        card.setModel(carCardDTO.getModel());
        card.setImage(uCard.getImage());

        CarCard cardUpdated = cardRepository.save(card);
        return modelMapper.map(cardUpdated, CarCardResponseDTO.class);
    }

    @Override
    public void deleteCard(
            Long cardId) {
        CarCard card = cardRepository.findById(cardId)
                .orElseThrow(() -> new ResourceNotFoundException("card", "id", cardId));

        cardRepository.delete(card);
    }

}


