package org.challenge.client.product;

import org.challenge.exception.ServiceException;
import org.challenge.model.ProductDetail;

import java.util.List;

public interface ProductClientService {

    ProductDetail retrieveProductDetail(String id) throws ServiceException;

    List<Long> retrieveProductSimilar(String id) throws ServiceException;
}
