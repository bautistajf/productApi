package org.challenge.client.product;


import feign.Headers;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import org.challenge.client.product.dto.ProductDetailDTO;
import org.challenge.exception.ServiceException;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(
        name = "${product-srv-feign-client.name}",
        url = "${product-srv-feign-client.url}",
        path = "/product")
@RefreshScope
public interface ProductClient {

    @GetMapping(
            value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    @Headers("Accept: application/json")
    @Bulkhead(name = "products-srv")
    ResponseEntity<ProductDetailDTO> retrieveProductDetail(@PathVariable("id") String id) throws ServiceException;

    @GetMapping(
            value = "/{id}/similarids",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    @Headers("Accept: application/json")
    @Bulkhead(name = "product-srv")
    ResponseEntity<List<Long>> retrieveProductSimilar(@PathVariable("id") String id) throws ServiceException;
}
