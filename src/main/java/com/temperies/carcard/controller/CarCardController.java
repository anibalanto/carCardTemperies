package com.temperies.carcard.controller;

import com.temperies.carcard.dto.CarCardDTO;
import com.temperies.carcard.dto.CarCardResponseDTO;
import com.temperies.carcard.dto.CarCardRequestDTO;
import com.temperies.carcard.service.ICarCardService;
import org.apache.commons.io.IOUtils;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.support.ServletContextResource;

import javax.servlet.ServletContext;
import javax.validation.Valid;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RestController
@RequestMapping("/api/card")
public class CarCardController {

    ICarCardService carCardService;

    private ServletContext servletContext;


    CarCardController(
            ICarCardService carCardService,
            ServletContext servletContext) {
        this.carCardService = carCardService;
        this.servletContext = servletContext;
    }

    @GetMapping("/all")
    public ResponseEntity< List<CarCardResponseDTO> > getAllCards(
            @RequestParam(required = false) Integer page) {
        return ResponseEntity.ok(
                (page == null) ?
                        carCardService.getAllCards() :
                        carCardService.getPageCards(page) );
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarCardResponseDTO> getCardById(
            @PathVariable(value = "id") Long cardId) throws IOException {
        return ResponseEntity.ok( carCardService.getCardById(cardId) );
    }
    @PostMapping()
    public ResponseEntity<CarCardResponseDTO> createCard(
            @Valid @RequestBody CarCardRequestDTO noteRequestDTO) throws IOException {
        return ResponseEntity.ok( carCardService.createCard(noteRequestDTO) );
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarCardResponseDTO> updateCard(@PathVariable(value = "id") Long cardId, @Valid @RequestBody CarCardDTO carCardDTO) {
        return ResponseEntity.ok( carCardService.updateCard(cardId, carCardDTO) );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long noteId) {
        carCardService.deleteCard(noteId);
        return ResponseEntity.ok().build();
    }



}