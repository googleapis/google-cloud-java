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
 * [START retail_set_inventory]
 */

package product;

import static setup.SetupCleanup.createProduct;
import static setup.SetupCleanup.deleteProduct;
import static setup.SetupCleanup.getProduct;

import com.google.cloud.ServiceOptions;
import com.google.cloud.retail.v2.FulfillmentInfo;
import com.google.cloud.retail.v2.PriceInfo;
import com.google.cloud.retail.v2.Product;
import com.google.cloud.retail.v2.Product.Availability;
import com.google.cloud.retail.v2.ProductServiceClient;
import com.google.cloud.retail.v2.SetInventoryRequest;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Int32Value;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.time.Instant;
import java.util.Arrays;
import java.util.UUID;

public class SetInventory {

  public static void main(String[] args) throws IOException, InterruptedException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = ServiceOptions.getDefaultProjectId();
    String generatedProductId = UUID.randomUUID().toString();
    String productName =
        String.format(
            "projects/%s/locations/global/catalogs/default_catalog/branches/0/products/%s",
            projectId, generatedProductId);

    createProduct(generatedProductId);
    setInventory(productName);
    getProduct(productName);
    deleteProduct(productName);
  }

  public static void setInventory(String productName) throws IOException, InterruptedException {
    SetInventoryRequest setInventoryRequest = getSetInventoryRequest(productName);

    try (ProductServiceClient serviceClient = ProductServiceClient.create()) {
      serviceClient.setInventoryAsync(setInventoryRequest);
    }

    /*
    This is a long-running operation and its result is not immediately
    present with get operations,thus we simulate wait with sleep method.
    */
    System.out.println("Set inventory, wait 30 seconds.");
    Thread.sleep(30_000);
  }

  public static SetInventoryRequest getSetInventoryRequest(String productName) {
    // The request timestamp
    Timestamp requestTime =
        Timestamp.newBuilder()
            .setSeconds(Instant.now().getEpochSecond())
            .setNanos(Instant.now().getNano())
            .build();

    FieldMask setMask =
        FieldMask.newBuilder()
            .addAllPaths(
                Arrays.asList(
                    "price_info", "availability", "fulfillment_info", "available_quantity"))
            .build();

    SetInventoryRequest setInventoryRequest =
        SetInventoryRequest.newBuilder()
            .setInventory(getProductWithInventoryInfo(productName))
            .setSetTime(requestTime)
            .setAllowMissing(true)
            .setSetMask(setMask)
            .build();
    System.out.printf("Set inventory request: %s%n", setInventoryRequest);

    return setInventoryRequest;
  }

  public static Product getProductWithInventoryInfo(String productName) {
    float price = 15.0f;
    float originalPrice = 20.0f;
    float cost = 8.0f;

    PriceInfo priceInfo =
        PriceInfo.newBuilder()
            .setPrice(price)
            .setOriginalPrice(originalPrice)
            .setCost(cost)
            .setCurrencyCode("USD")
            .build();

    FulfillmentInfo fulfillmentInfo =
        FulfillmentInfo.newBuilder()
            .setType("pickup-in-store")
            .addAllPlaceIds(Arrays.asList("store1", "store2"))
            .build();

    return Product.newBuilder()
        .setName(productName)
        .setPriceInfo(priceInfo)
        .addFulfillmentInfo(fulfillmentInfo)
        .setAvailability(Availability.IN_STOCK)
        .setAvailableQuantity(Int32Value.newBuilder().setValue(5).build())
        .build();
  }
}

// [END retail_set_inventory]
