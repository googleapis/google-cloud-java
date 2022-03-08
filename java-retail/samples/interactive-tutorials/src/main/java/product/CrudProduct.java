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

// [START retail_crud_product]

/*
 * Create product in a catalog using Retail API
 */

package product;

import com.google.api.gax.rpc.NotFoundException;
import com.google.cloud.retail.v2.CreateProductRequest;
import com.google.cloud.retail.v2.DeleteProductRequest;
import com.google.cloud.retail.v2.GetProductRequest;
import com.google.cloud.retail.v2.PriceInfo;
import com.google.cloud.retail.v2.Product;
import com.google.cloud.retail.v2.Product.Availability;
import com.google.cloud.retail.v2.Product.Type;
import com.google.cloud.retail.v2.ProductServiceClient;
import com.google.cloud.retail.v2.UpdateProductRequest;
import java.io.IOException;
import java.util.UUID;

public class CrudProduct {

  public static void main(String[] args) throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = System.getenv("PROJECT_ID");
    String generatedProductId = UUID.randomUUID().toString();
    String defaultBranchName =
        String.format(
            "projects/%s/locations/global/catalogs/default_catalog/" + "branches/default_branch",
            projectId);
    String productName = String.format("%s/products/%s", defaultBranchName, generatedProductId);

    Product createdProduct = createProduct(generatedProductId, defaultBranchName);
    getProduct(productName);
    updateProduct(createdProduct, productName);
    deleteProduct(productName);
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

  // generate product for update
  public static Product generateProductForUpdate(String productId, String productName) {
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
        .setName(productName)
        .setTitle("Updated Nest Mini")
        .setType(Type.PRIMARY)
        .addCategories("Updated Speakers and displays")
        .addBrands("Updated Google")
        .setAvailability(Availability.OUT_OF_STOCK)
        .setPriceInfo(priceInfo)
        .build();
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

  // get product
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

  // update product
  public static void updateProduct(Product originalProduct, String productName) throws IOException {
    UpdateProductRequest updateProductRequest =
        UpdateProductRequest.newBuilder()
            .setProduct(generateProductForUpdate(originalProduct.getId(), productName))
            .setAllowMissing(true)
            .build();
    System.out.printf("Update product request: %s%n", updateProductRequest);

    Product updatedProduct = ProductServiceClient.create().updateProduct(updateProductRequest);
    System.out.printf("Updated product: %s%n", updatedProduct);
  }

  // delete product
  public static void deleteProduct(String productName) throws IOException {
    DeleteProductRequest deleteProductRequest =
        DeleteProductRequest.newBuilder().setName(productName).build();
    System.out.printf("Delete product request %s%n", deleteProductRequest);

    ProductServiceClient.create().deleteProduct(deleteProductRequest);
    System.out.printf("Product %s was deleted.%n", productName);
  }
}

// [END retail_crud_product]
