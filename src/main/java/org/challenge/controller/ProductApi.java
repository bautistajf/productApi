package org.challenge.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.challenge.dto.SimilarProductsDTO;
import org.challenge.exception.ServiceException;
import org.challenge.model.SimilarProducts;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Validated
public interface ProductApi {

    @Operation(summary = "Similar products", description = "")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json", schema = @Schema(implementation = SimilarProducts.class))),
            @ApiResponse(responseCode = "404", description = "Product Not found")})
    @GetMapping(value = "/product/{productId}/similar",
            produces = {"application/json"}
    )
    ResponseEntity<SimilarProductsDTO> getProductSimilar(@Parameter(in = ParameterIn.PATH, description = "", required = true, schema = @Schema()) @PathVariable("productId") String productId) throws ServiceException;

}

