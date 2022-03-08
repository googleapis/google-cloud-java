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

// [START retail_create_product]

/*
 * Create product in a catalog using Retail API
 */

package product;

import static setup.SetupCleanup.deleteProduct;

import com.google.cloud.retail.v2.CreateProductRequest;
import com.google.cloud.retail.v2.PriceInfo;
import com.google.cloud.retail.v2.Product;
import com.google.cloud.retail.v2.Product.Availability;
import com.google.cloud.retail.v2.Product.Type;
import com.google.cloud.retail.v2.ProductServiceClient;
import java.io.IOException;
import java.util.UUID;

public class CreateProduct {

  public static void main(String[] args) throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = System.getenv("PROJECT_ID");
    String defaultBranchName =
        String.format(
            "projects/%s/locations/global/catalogs/default_catalog/" + "branches/default_branch",
            projectId);
    String generatedProductId = UUID.randomUUID().toString();

    Product createdProduct = createProduct(generatedProductId, defaultBranchName);
    deleteProduct(createdProduct.getName());
  }

  // call the Retail API to create product
  public static Product createProduct(String productId, String defaultBranchName)
      throws IOException {
    CreateProductRequest createProductRequest =
        CreateProductRequest.newBuilder()
            .setProduct(generateProduct())
            .setProductId(productId)
            .setParent(defaultBranchName)
            .build();
    System.out.printf("Create product request: %s%n", createProductRequest);

    Product createdProduct = ProductServiceClient.create().createProduct(createProductRequest);
    System.out.printf("Created product: %s%n", createdProduct);

    return createdProduct;
  }

  // generate product for create
  public static Product generateProduct() {
    float price = 30.0f;
    float originalPrice = 35.5f;

    PriceInfo priceInfo =
        PriceInfo.newBuilder()
            .setPrice(price)
            .setOriginalPrice(originalPrice)
            .setCurrencyCode("USD")
            .build();

    return Product.newBuilder()
        .setTitle("Nest Mini")
        .setType(Type.PRIMARY)
        .addCategories("Speakers and displays")
        .addBrands("Google")
        .setPriceInfo(priceInfo)
        .setAvailability(Availability.IN_STOCK)
        .build();
  }
}

// [END retail_create_product]
