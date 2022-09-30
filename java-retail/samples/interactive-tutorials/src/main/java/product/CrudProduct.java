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

/*
 * Create, update, get and delete product in a catalog using Retail API.
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
    // TODO(developer): Set projectId to your Google Cloud Platform project ID.
    String projectId = "my-project";
    String generatedProductId = UUID.randomUUID().toString();
    String branchName =
        String.format(
            "projects/%s/locations/global/catalogs/default_catalog/branches/0", projectId);
    String productName = String.format("%s/products/%s", branchName, generatedProductId);

    Product createdProduct = createProduct(generatedProductId, branchName);
    getProduct(productName);
    updateProduct(createdProduct, productName);
    deleteProduct(productName);
  }

  // Generate product for create
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

  // Generate product for update
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

  // Call the Retail API to create product
  public static Product createProduct(String productId, String branchName) throws IOException {
    CreateProductRequest createProductRequest =
        CreateProductRequest.newBuilder()
            .setProduct(generateProduct())
            .setProductId(productId)
            .setParent(branchName)
            .build();
    System.out.printf("Create product request: %s%n", createProductRequest);

    // Initialize client that will be used to send requests. This client only
    // needs to be created once, and can be reused for multiple requests. After
    // completing all of your requests, call the "close" method on the client to
    // safely clean up any remaining background resources.
    try (ProductServiceClient serviceClient = ProductServiceClient.create()) {
      Product createdProduct = serviceClient.createProduct(createProductRequest);
      System.out.printf("Created product: %s%n", createdProduct);
      return createdProduct;
    }
  }

  // Get product
  public static Product getProduct(String productName) throws IOException {
    Product product = Product.newBuilder().build();

    GetProductRequest getProductRequest =
        GetProductRequest.newBuilder().setName(productName).build();

    // Initialize client that will be used to send requests. This client only
    // needs to be created once, and can be reused for multiple requests. After
    // completing all of your requests, call the "close" method on the client to
    // safely clean up any remaining background resources.
    try (ProductServiceClient serviceClient = ProductServiceClient.create()) {
      product = serviceClient.getProduct(getProductRequest);
      System.out.println("Get product response: " + product);
      return product;
    } catch (NotFoundException e) {
      System.out.printf("Product %s not found", productName);
      return product;
    }
  }

  // Update product
  public static void updateProduct(Product originalProduct, String productName) throws IOException {
    UpdateProductRequest updateProductRequest =
        UpdateProductRequest.newBuilder()
            .setProduct(generateProductForUpdate(originalProduct.getId(), productName))
            .setAllowMissing(true)
            .build();
    System.out.printf("Update product request: %s%n", updateProductRequest);

    // Initialize client that will be used to send requests. This client only
    // needs to be created once, and can be reused for multiple requests. After
    // completing all of your requests, call the "close" method on the client to
    // safely clean up any remaining background resources.
    try (ProductServiceClient serviceClient = ProductServiceClient.create()) {
      Product updatedProduct = serviceClient.updateProduct(updateProductRequest);
      System.out.printf("Updated product: %s%n", updatedProduct);
    }
  }

  // Delete product
  public static void deleteProduct(String productName) throws IOException {
    DeleteProductRequest deleteProductRequest =
        DeleteProductRequest.newBuilder().setName(productName).build();
    System.out.printf("Delete product request %s%n", deleteProductRequest);

    // Initialize client that will be used to send requests. This client only
    // needs to be created once, and can be reused for multiple requests. After
    // completing all of your requests, call the "close" method on the client to
    // safely clean up any remaining background resources.
    try (ProductServiceClient serviceClient = ProductServiceClient.create()) {
      serviceClient.deleteProduct(deleteProductRequest);
      System.out.printf("Product %s was deleted.%n", productName);
    }
  }
}
