package org.challenge.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;

/**
 * List of similar products to a given one ordered by similarity
 */
@Schema(description = "List of similar products to a given one ordered by similarity")
@Validated
@Data
@Builder
public class SimilarProducts extends ArrayList<ProductDetail> {

}
