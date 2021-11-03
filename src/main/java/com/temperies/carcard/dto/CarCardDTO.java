package com.temperies.carcard.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Column;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import java.sql.Blob;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@AllArgsConstructor
@NoArgsConstructor
public class CarCardDTO {

    @NotEmpty
    @Length(max = 40)
    protected String model;

    @Max(350)
    @Min(50)
    protected Float maxKmh;

    @Max(1000)
    @Min(5)
    protected Float cv;

    @Positive
    protected Float tMin;

    @Positive
    protected Float cc;

    @Max(40)
    @Min(2)
    protected Integer cantCilindros;

    @Positive
    protected Float peso;

    protected String image;

}
