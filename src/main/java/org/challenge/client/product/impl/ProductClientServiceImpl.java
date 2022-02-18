package org.challenge.client.product.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.challenge.client.product.ProductClient;
import org.challenge.client.product.ProductClientService;
import org.challenge.client.product.mapper.ProductClientMapper;
import org.challenge.exception.ServiceException;
import org.challenge.model.ProductDetail;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class ProductClientServiceImpl implements ProductClientService {

    private final ProductClient client;
    private final ProductClientMapper mapper;

    @Override
    public ProductDetail retrieveProductDetail(String id) throws ServiceException {
        return mapper.toModel(client.retrieveProductDetail(id).getBody());
    }

    @Override
    public List<Long> retrieveProductSimilar(String id) throws ServiceException {
        return client.retrieveProductSimilar(id).getBody();
    }
}
