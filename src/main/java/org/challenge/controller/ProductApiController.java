package org.challenge.controller;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.challenge.dto.SimilarProductsDTO;
import org.challenge.exception.ServiceException;
import org.challenge.service.ProductService;
import org.challenge.util.ControllerHelper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@Log4j2
@RequiredArgsConstructor
public class ProductApiController implements ProductApi {

    private final ProductService service;

    public ResponseEntity<SimilarProductsDTO> getProductSimilar(
            @Parameter(in = ParameterIn.PATH, description = "", required = true, schema = @Schema())
            @PathVariable("productId") String productId) throws ServiceException {
        final LocalDateTime startTime = LocalDateTime.now();
        final SimilarProductsDTO response = service.retrieveProducts(productId);
        final HttpHeaders httpHeaders = ControllerHelper.buildHeaders(startTime);
        return new ResponseEntity<>(response, httpHeaders, HttpStatus.OK);
    }

}
