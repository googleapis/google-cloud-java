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

// [START retail_import_products_from_inline_source]

/*
 * Import products into a catalog from inline source using Retail API
 */

package product;

import com.google.cloud.ServiceOptions;
import com.google.cloud.retail.v2.ColorInfo;
import com.google.cloud.retail.v2.FulfillmentInfo;
import com.google.cloud.retail.v2.ImportMetadata;
import com.google.cloud.retail.v2.ImportProductsRequest;
import com.google.cloud.retail.v2.ImportProductsResponse;
import com.google.cloud.retail.v2.PriceInfo;
import com.google.cloud.retail.v2.Product;
import com.google.cloud.retail.v2.ProductInlineSource;
import com.google.cloud.retail.v2.ProductInputConfig;
import com.google.cloud.retail.v2.ProductServiceClient;
import com.google.longrunning.Operation;
import com.google.longrunning.OperationsClient;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class ImportProductsInlineSource {

  public static void main(String[] args) throws IOException, InterruptedException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = ServiceOptions.getDefaultProjectId();
    String branchName =
        String.format(
            "projects/%s/locations/global/catalogs/default_catalog/branches/0", projectId);

    ImportProductsRequest importRequest = getImportProductsInlineRequest(getProducts(), branchName);
    waitForOperationCompletion(importRequest);
  }

  public static ImportProductsRequest getImportProductsInlineRequest(
      List<Product> productsToImport, String branchName) {
    ProductInlineSource inlineSource =
        ProductInlineSource.newBuilder().addAllProducts(productsToImport).build();

    ProductInputConfig inputConfig =
        ProductInputConfig.newBuilder().setProductInlineSource(inlineSource).build();

    ImportProductsRequest importRequest =
        ImportProductsRequest.newBuilder()
            .setParent(branchName)
            .setInputConfig(inputConfig)
            .build();

    System.out.printf("Import products from inline source request: %s%n", importRequest);

    return importRequest;
  }

  public static List<Product> getProducts() {
    List<Product> products = new ArrayList<>();

    Product product1;
    Product product2;

    float price1 = 16f;
    float originalPrice1 = 45.0f;
    float cost1 = 12.0f;

    PriceInfo priceInfo1 =
        PriceInfo.newBuilder()
            .setPrice(price1)
            .setOriginalPrice(originalPrice1)
            .setCost(cost1)
            .setCurrencyCode("USD")
            .build();

    ColorInfo colorInfo1 =
        ColorInfo.newBuilder()
            .addColorFamilies("Blue")
            .addAllColors(Arrays.asList("Light blue", "Blue", "Dark blue"))
            .build();

    FulfillmentInfo fulfillmentInfo1 =
        FulfillmentInfo.newBuilder()
            .setType("pickup-in-store")
            .addAllPlaceIds(Arrays.asList("store1", "store2"))
            .build();

    FieldMask fieldMask1 =
        FieldMask.newBuilder()
            .addAllPaths(Arrays.asList("title", "categories", "price_info", "color_info"))
            .build();

    // TO CHECK ERROR HANDLING COMMENT OUT THE PRODUCT TITLE HERE:
    product1 =
        Product.newBuilder()
            .setTitle("#IamRemarkable Pen")
            .setId(UUID.randomUUID().toString())
            .addAllCategories(Collections.singletonList("Office"))
            .setUri(
                "https://shop.googlemerchandisestore.com/Google+Redesign/"
                    + "Office/IamRemarkable+Pen")
            .addBrands("#IamRemarkable")
            .setPriceInfo(priceInfo1)
            .setColorInfo(colorInfo1)
            .addFulfillmentInfo(fulfillmentInfo1)
            .setRetrievableFields(fieldMask1)
            .build();

    float price2 = 35f;
    float originalPrice2 = 45.0f;
    float cost2 = 12.0f;

    PriceInfo priceInfo2 =
        PriceInfo.newBuilder()
            .setPrice(price2)
            .setOriginalPrice(originalPrice2)
            .setCost(cost2)
            .setCurrencyCode("USD")
            .build();

    ColorInfo colorInfo2 =
        ColorInfo.newBuilder()
            .addColorFamilies("Blue")
            .addAllColors(Collections.singletonList("Sky blue"))
            .build();

    FulfillmentInfo fulfillmentInfo2 =
        FulfillmentInfo.newBuilder()
            .setType("pickup-in-store")
            .addAllPlaceIds(Arrays.asList("store2", "store3"))
            .build();

    FieldMask fieldMask2 =
        FieldMask.newBuilder()
            .addAllPaths(Arrays.asList("title", "categories", "price_info", "color_info"))
            .build();

    product2 =
        Product.newBuilder()
            .setTitle("Android Embroidered Crewneck Sweater")
            .setId(UUID.randomUUID().toString())
            .addCategories("Apparel")
            .setUri(
                "https://shop.googlemerchandisestore.com/Google+Redesign/"
                    + "Apparel/Android+Embroidered+Crewneck+Sweater")
            .addBrands("Android")
            .setPriceInfo(priceInfo2)
            .setColorInfo(colorInfo2)
            .addFulfillmentInfo(fulfillmentInfo2)
            .setRetrievableFields(fieldMask2)
            .build();

    products.add(product1);
    products.add(product2);

    return products;
  }

  public static void waitForOperationCompletion(ImportProductsRequest importRequest)
      throws IOException, InterruptedException {
    try (ProductServiceClient serviceClient = ProductServiceClient.create()) {
      String operationName = serviceClient.importProductsCallable().call(importRequest).getName();
      System.out.printf("OperationName = %s\n", operationName);

      OperationsClient operationsClient = serviceClient.getOperationsClient();
      Operation operation = operationsClient.getOperation(operationName);

      while (!operation.getDone()) {
        // Keep polling the operation periodically until the import task is done.
        Thread.sleep(30_000);
        operation = operationsClient.getOperation(operationName);
      }

      if (operation.hasMetadata()) {
        ImportMetadata metadata = operation.getMetadata().unpack(ImportMetadata.class);
        System.out.printf(
            "Number of successfully imported products: %s\n", metadata.getSuccessCount());
        System.out.printf(
            "Number of failures during the importing: %s\n", metadata.getFailureCount());
      }

      if (operation.hasResponse()) {
        ImportProductsResponse response =
            operation.getResponse().unpack(ImportProductsResponse.class);
        System.out.printf("Operation result: %s%n", response);
      }
    }
  }
}

// [END retail_import_products_from_inline_source]
