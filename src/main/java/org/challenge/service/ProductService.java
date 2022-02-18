package org.challenge.service;

import org.challenge.dto.SimilarProductsDTO;
import org.challenge.exception.ServiceException;

public interface ProductService {

    SimilarProductsDTO retrieveProducts(String id) throws ServiceException;
}
