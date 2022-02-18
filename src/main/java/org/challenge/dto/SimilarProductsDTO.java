package org.challenge.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@Builder
@NoArgsConstructor
public class SimilarProductsDTO extends ArrayList<ProductDetailDTO> {
}
