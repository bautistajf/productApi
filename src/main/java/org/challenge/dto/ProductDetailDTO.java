package org.challenge.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

/**
 * Product detail
 */
@Schema(description = "Product detail")
@Validated
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDetailDTO {
    @JsonProperty("id")
    @Schema(required = true, description = "")
    @NotNull
    @Size(min = 1)
    private String id;

    @JsonProperty("name")
    @Schema(required = true, description = "")
    @NotNull
    @Size(min = 1)
    private String name;

    @JsonProperty("price")
    @Schema(required = true, description = "")
    @NotNull
    @Valid
    private BigDecimal price;

    @JsonProperty("availability")
    @Schema(required = true, description = "")
    @NotNull
    private Boolean availability;

}
