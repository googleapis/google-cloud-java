/*
 * Copyright 2019 Google LLC
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

package com.example.vision.snippets;

// [START vision_product_search_purge_products_in_product_set]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.vision.v1.BatchOperationMetadata;
import com.google.cloud.vision.v1.LocationName;
import com.google.cloud.vision.v1.ProductSearchClient;
import com.google.cloud.vision.v1.ProductSetPurgeConfig;
import com.google.cloud.vision.v1.PurgeProductsRequest;
import com.google.protobuf.Empty;
import java.util.concurrent.TimeUnit;

public class PurgeProductsInProductSet {

  // Delete all products in a product set.
  public static void purgeProductsInProductSet(
      String projectId, String location, String productSetId) throws Exception {

    // String projectId = "YOUR_PROJECT_ID";
    // String location = "us-central1";
    // String productSetId = "YOUR_PRODUCT_SET_ID";
    // boolean force = true;

    try (ProductSearchClient client = ProductSearchClient.create()) {

      String parent = LocationName.format(projectId, location);
      ProductSetPurgeConfig productSetPurgeConfig =
          ProductSetPurgeConfig.newBuilder().setProductSetId(productSetId).build();

      PurgeProductsRequest request =
          PurgeProductsRequest.newBuilder()
              .setParent(parent)
              .setProductSetPurgeConfig(productSetPurgeConfig)
              // The operation is irreversible and removes multiple products.
              // The user is required to pass in force=True to actually perform the
              // purge.
              // If force is not set to True, the service raises an exception.
              .setForce(true)
              .build();

      OperationFuture<Empty, BatchOperationMetadata> response = client.purgeProductsAsync(request);
      response.getPollingFuture().get(180, TimeUnit.SECONDS);

      System.out.println("Products removed from product set.");
    }
  }
}
// [END vision_product_search_purge_products_in_product_set]
