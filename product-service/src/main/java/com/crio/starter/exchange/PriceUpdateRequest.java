package com.crio.starter.exchange;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
public class PriceUpdateRequest {
  private String productId;
  //private String productName;
  //private String productDescription;
  private BigDecimal price;
  //private boolean availabilityStatus;
  // public String getProductName() {
  //   return productName;
  // }
  // public void setProductName(String productName) {
  //   this.productName = productName;
  // }
  // public String getProductDescription() {
  //   return productDescription;
  // }
  // public void setProductDescription(String productDescription) {
  //   this.productDescription = productDescription;
  // }
  // public Integer getPrice() {
  //   return price;
  // }
  // public void setPrice(Integer price) {
  //   this.price = price;
  // }
  // public boolean isAvailabilityStatus() {
  //   return availabilityStatus;
  // }
  // public void setAvailabilityStatus(boolean availabilityStatus) {
  //   this.availabilityStatus = availabilityStatus;
  // }

  
  
}
