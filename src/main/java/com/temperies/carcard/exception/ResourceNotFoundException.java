package com.temperies.carcard.exception;

import com.temperies.carcard.dto.ResourceAttributeDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException
        extends RuntimeException
        implements ExtraibleAdditionalData<ResourceAttributeDTO> {

    @Override
    public ResourceAttributeDTO getAdditionalData() {
        return this.additionalData;
    }



    ResourceAttributeDTO additionalData = new ResourceAttributeDTO();

    public ResourceNotFoundException( String resourceName, String fieldName, Object fieldValue) {
        super(String.format("Resource %s not found finding by %s using value: '%s'",
                resourceName, fieldName, fieldValue));
        this.additionalData.setResourceName(resourceName);
        this.additionalData.setFieldName(fieldName);
        this.additionalData.setFieldValue(fieldValue);
    }

}
