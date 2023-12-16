// package com.crio.starter.controller;

// import com.crio.starter.service.ProductService;
// import com.fasterxml.jackson.databind.ObjectMapper;
// import com.crio.starter.exchange.PriceUpdateRequest;
// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
// import org.springframework.boot.test.mock.mockito.MockBean;
// import org.springframework.http.MediaType;
// import org.springframework.test.web.servlet.MockMvc;
// import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
// import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

// import java.math.BigDecimal;

// import static org.mockito.Mockito.doNothing;
// import static org.mockito.Mockito.when;

// @WebMvcTest(ProductController.class)
// public class testController {

//     @Autowired
//     private MockMvc mockMvc;

//     @MockBean
//     private ProductService productService;

//     @Test
//     public void testProcessPriceUpdateSuccess() throws Exception {
//         // Prepare a valid PriceUpdateRequest
//         PriceUpdateRequest priceUpdateRequest = new PriceUpdateRequest();
//         priceUpdateRequest.setProductId("123");
//         priceUpdateRequest.setPrice(BigDecimal.valueOf(19.99));

//         // Mock the service method to succeed
//         doNothing().when(productService).processPriceUpdate(priceUpdateRequest);

//         // Perform the request and assert the response
//         mockMvc.perform(MockMvcRequestBuilders.post("/process-price-update")
//                 .contentType(MediaType.APPLICATION_JSON)
//                 .content(asJsonString(priceUpdateRequest)))
//                 .andExpect(MockMvcResultMatchers.status().isOk())
//                 .andExpect(MockMvcResultMatchers.content().string("Price update processed successfully"));
//     }

//     // Helper method to convert an object to JSON
//     private static String asJsonString(final Object obj) {
//         try {
//             return new ObjectMapper().writeValueAsString(obj);
//         } catch (Exception e) {
//             throw new RuntimeException(e);
//         }
//     }
// }


