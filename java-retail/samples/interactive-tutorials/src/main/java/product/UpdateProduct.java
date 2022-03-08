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

// [START retail_update_product]

/*
 * Update product in a catalog using Retail API
 */

package product;

import static setup.SetupCleanup.createProduct;
import static setup.SetupCleanup.deleteProduct;

import com.google.cloud.retail.v2.PriceInfo;
import com.google.cloud.retail.v2.Product;
import com.google.cloud.retail.v2.Product.Availability;
import com.google.cloud.retail.v2.Product.Type;
import com.google.cloud.retail.v2.ProductServiceClient;
import com.google.cloud.retail.v2.UpdateProductRequest;
import java.io.IOException;
import java.util.UUID;

public class UpdateProduct {

  public static void main(String[] args) throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = System.getenv("PROJECT_ID");
    String defaultBranchName =
        String.format(
            "projects/%s/locations/global/catalogs/default_catalog/" + "branches/default_branch",
            projectId);
    String generatedProductId = UUID.randomUUID().toString();

    Product createdProduct = createProduct(generatedProductId);
    updateProduct(createdProduct, defaultBranchName);
    deleteProduct(createdProduct.getName());
  }

  // generate product for update
  public static Product generateProductForUpdate(String productId, String defaultBranchName) {
    final float price = 20.0f;
    final float originalPrice = 25.5f;

    PriceInfo priceInfo =
        PriceInfo.newBuilder()
            .setPrice(price)
            .setOriginalPrice(originalPrice)
            .setCurrencyCode("EUR")
            .build();

    return Product.newBuilder()
        .setId(productId)
        .setName(defaultBranchName + "/products/" + productId)
        .setTitle("Updated Nest Mini")
        .setType(Type.PRIMARY)
        .addCategories("Updated Speakers and displays")
        .addBrands("Updated Google")
        .setAvailability(Availability.OUT_OF_STOCK)
        .setPriceInfo(priceInfo)
        .build();
  }

  // get update product request
  public static UpdateProductRequest getUpdateProductRequest(Product productToUpdate) {
    UpdateProductRequest updateProductRequest =
        UpdateProductRequest.newBuilder().setProduct(productToUpdate).setAllowMissing(true).build();
    System.out.printf("Update product request: %s%n", updateProductRequest);

    return updateProductRequest;
  }

  // call the Retail API to update product
  public static void updateProduct(Product originalProduct, String defaultBranchName)
      throws IOException {
    Product updatedProduct =
        ProductServiceClient.create()
            .updateProduct(
                getUpdateProductRequest(
                    generateProductForUpdate(originalProduct.getId(), defaultBranchName)));
    System.out.printf("Updated product: %s%n", updatedProduct);
  }
}

// [END retail_update_product]
