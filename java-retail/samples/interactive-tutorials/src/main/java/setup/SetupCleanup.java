/*
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package setup;

import com.google.api.gax.rpc.NotFoundException;
import com.google.cloud.retail.v2.CreateProductRequest;
import com.google.cloud.retail.v2.DeleteProductRequest;
import com.google.cloud.retail.v2.FulfillmentInfo;
import com.google.cloud.retail.v2.GetProductRequest;
import com.google.cloud.retail.v2.PriceInfo;
import com.google.cloud.retail.v2.Product;
import com.google.cloud.retail.v2.Product.Availability;
import com.google.cloud.retail.v2.Product.Type;
import com.google.cloud.retail.v2.ProductServiceClient;
import java.io.IOException;
import java.util.Arrays;

public class SetupCleanup {

  private static final String PROJECT_ID = System.getenv("PROJECT_ID");
  private static final String DEFAULT_BRANCH_NAME =
      String.format(
          "projects/%s/locations/global/catalogs/default_catalog/" + "branches/default_branch",
          PROJECT_ID);

  public static Product generateProduct() {
    float price = 30.0f;
    float originalPrice = 35.5f;

    PriceInfo priceInfo =
        PriceInfo.newBuilder()
            .setPrice(price)
            .setOriginalPrice(originalPrice)
            .setCurrencyCode("USD")
            .build();

    FulfillmentInfo fulfillmentInfo =
        FulfillmentInfo.newBuilder()
            .setType("pickup-in-store")
            .addAllPlaceIds(Arrays.asList("store0", "store1"))
            .build();

    return Product.newBuilder()
        .setTitle("Nest Mini")
        .setType(Type.PRIMARY)
        .addCategories("Speakers and displays")
        .addBrands("Google")
        .setPriceInfo(priceInfo)
        .setAvailability(Availability.IN_STOCK)
        .addFulfillmentInfo(fulfillmentInfo)
        .build();
  }

  public static Product createProduct(String productId) throws IOException {
    CreateProductRequest createProductRequest =
        CreateProductRequest.newBuilder()
            .setProduct(generateProduct())
            .setProductId(productId)
            .setParent(DEFAULT_BRANCH_NAME)
            .build();
    System.out.printf("Create product request: %s%n", createProductRequest);

    Product createdProduct = ProductServiceClient.create().createProduct(createProductRequest);
    System.out.printf("Created product: %s%n", createdProduct);

    return createdProduct;
  }

  public static Product getProduct(String productName) throws IOException {
    Product product = Product.newBuilder().build();

    GetProductRequest getProductRequest =
        GetProductRequest.newBuilder().setName(productName).build();

    try {
      product = ProductServiceClient.create().getProduct(getProductRequest);
      System.out.println("Get product response: " + product);
      return product;
    } catch (NotFoundException e) {
      System.out.printf("Product %s not found", productName);
      return product;
    }
  }

  public static void deleteProduct(String productName) throws IOException {
    DeleteProductRequest deleteProductRequest =
        DeleteProductRequest.newBuilder().setName(productName).build();
    System.out.printf("Delete product request %s%n", deleteProductRequest);

    ProductServiceClient.create().deleteProduct(deleteProductRequest);
    System.out.printf("Product %s was deleted.%n", productName);
  }
}
