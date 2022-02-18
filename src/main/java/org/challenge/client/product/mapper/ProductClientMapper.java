package org.challenge.client.product.mapper;

import org.challenge.client.product.dto.ProductDetailDTO;
import org.challenge.model.ProductDetail;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductClientMapper {

    ProductDetail toModel(ProductDetailDTO source);
}
