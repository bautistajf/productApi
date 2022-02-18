package org.challenge.service.impl;

import lombok.RequiredArgsConstructor;
import org.challenge.client.product.ProductClientService;
import org.challenge.dto.SimilarProductsDTO;
import org.challenge.exception.ServiceException;
import org.challenge.mapper.ProductMapper;
import org.challenge.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductClientService productService;
    private final ProductMapper mapper;

    @Override
    public SimilarProductsDTO retrieveProducts(String id) throws ServiceException {
        final List<Long> productIds = productService.retrieveProductSimilar(id);
        final SimilarProductsDTO similarProductsDTO = new SimilarProductsDTO();
        for (Long productId : productIds) {
            similarProductsDTO.add(mapper.toDTOList(productService.retrieveProductDetail(id)));
        }
        return similarProductsDTO;
    }

}
