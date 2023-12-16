package com.crio.starter.data;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "products")
@NoArgsConstructor
public class Products {
  @Id
  private String productId;
  private String productName;
  private String productDescription;
  private BigDecimal price;
  private boolean availabilityStatus;

}
