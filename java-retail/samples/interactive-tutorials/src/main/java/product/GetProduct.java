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
 * Get product from a catalog using Retail API
 */

package product;

import static setup.SetupCleanup.createProduct;
import static setup.SetupCleanup.deleteProduct;

import com.google.api.gax.rpc.NotFoundException;
import com.google.cloud.retail.v2.GetProductRequest;
import com.google.cloud.retail.v2.Product;
import com.google.cloud.retail.v2.ProductServiceClient;
import java.io.IOException;
import java.util.UUID;

public class GetProduct {

  public static void main(String[] args) throws IOException {
    String generatedProductId = UUID.randomUUID().toString();

    Product createdProduct = createProduct(generatedProductId);
    Product product = getProduct(createdProduct.getName());
    deleteProduct(product.getName());
  }

  // call the Retail API to get product
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
}
