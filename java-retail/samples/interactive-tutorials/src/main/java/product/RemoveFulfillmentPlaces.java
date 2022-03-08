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
 * [START retail_remove_fulfillment_places]
 */

package product;

import static setup.SetupCleanup.createProduct;
import static setup.SetupCleanup.deleteProduct;
import static setup.SetupCleanup.getProduct;

import com.google.cloud.retail.v2.ProductServiceClient;
import com.google.cloud.retail.v2.RemoveFulfillmentPlacesRequest;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

public class RemoveFulfillmentPlaces {

  public static void main(String[] args) throws IOException, InterruptedException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = System.getenv("PROJECT_ID");
    String generatedProductId = UUID.randomUUID().toString();
    String productName =
        String.format(
            "projects/%s/locations/global/catalogs/default_catalog/branches/"
                + "default_branch/products/%s",
            projectId, generatedProductId);
    Timestamp currentDate =
        Timestamp.newBuilder()
            .setSeconds(Instant.now().getEpochSecond())
            .setNanos(Instant.now().getNano())
            .build();
    /*
     * The time when the fulfillment updates are issued. If set with outdated time
     * (yesterday), the fulfillment information will not updated.
     */
    Timestamp outdatedDate =
        Timestamp.newBuilder()
            .setSeconds(Instant.now().minus(1, ChronoUnit.DAYS).getEpochSecond())
            .setNanos(Instant.now().getNano())
            .build();

    createProduct(generatedProductId);
    System.out.printf("Remove fulfilment places with current date: %s", currentDate);
    removeFulfillmentPlaces(productName, currentDate, "store0");
    getProduct(productName);
    System.out.printf("Remove outdated fulfilment places: %s", outdatedDate);
    removeFulfillmentPlaces(productName, outdatedDate, "store1");
    getProduct(productName);
    deleteProduct(productName);
  }

  // remove fulfillment places to product
  public static void removeFulfillmentPlaces(
      String productName, Timestamp timestamp, String storeId)
      throws IOException, InterruptedException {
    RemoveFulfillmentPlacesRequest removeFulfillmentRequest =
        getRemoveFulfillmentRequest(productName, timestamp, storeId);
    ProductServiceClient.create().removeFulfillmentPlacesAsync(removeFulfillmentRequest);
    /*
    This is a long-running operation and its result is not immediately
    present with get operations,thus we simulate wait with sleep method.
    */
    System.out.println("Remove fulfillment places, wait 30 seconds.");
    Thread.sleep(30_000);
  }

  // remove fulfillment request
  public static RemoveFulfillmentPlacesRequest getRemoveFulfillmentRequest(
      String productName, Timestamp timestamp, String storeId) {
    RemoveFulfillmentPlacesRequest removeFulfillmentRequest =
        RemoveFulfillmentPlacesRequest.newBuilder()
            .setProduct(productName)
            .setType("pickup-in-store")
            .addPlaceIds(storeId)
            .setRemoveTime(timestamp)
            .setAllowMissing(true)
            .build();
    System.out.println("Remove fulfillment request " + removeFulfillmentRequest);

    return removeFulfillmentRequest;
  }
}

// [END retail_remove_fulfillment_places]
