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

// [START retail_delete_product]

/*
 * Delete product from a catalog using Retail API
 */

package product;

import static setup.SetupCleanup.createProduct;

import com.google.cloud.retail.v2.DeleteProductRequest;
import com.google.cloud.retail.v2.ProductServiceClient;
import java.io.IOException;
import java.util.UUID;

public class DeleteProduct {

  public static void main(String[] args) throws IOException {
    String generatedProductId = UUID.randomUUID().toString();

    String createdProductName = createProduct(generatedProductId).getName();
    deleteProduct(createdProductName);
  }

  // call the Retail API to delete product
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

// [END retail_delete_product]
