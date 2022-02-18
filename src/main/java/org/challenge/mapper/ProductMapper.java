package org.challenge.mapper;


import org.challenge.dto.ProductDetailDTO;
import org.challenge.model.ProductDetail;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDetailDTO toDTOList(ProductDetail source);
}
