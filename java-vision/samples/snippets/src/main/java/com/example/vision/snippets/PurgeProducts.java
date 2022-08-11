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

// [START vision_product_search_purge_orphan_products]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.vision.v1.LocationName;
import com.google.cloud.vision.v1.ProductSearchClient;
import com.google.cloud.vision.v1.PurgeProductsRequest;
import java.util.concurrent.TimeUnit;

public class PurgeProducts {

  // Delete the product and all its reference images.
  public static void purgeOrphanProducts(String projectId, String computeRegion) throws Exception {

    // String projectId = "YOUR_PROJECT_ID";
    // String computeRegion = "us-central1";
    // boolean force = true;

    try (ProductSearchClient client = ProductSearchClient.create()) {
      String parent = LocationName.format(projectId, computeRegion);

      // The purge operation is async.
      PurgeProductsRequest request =
          PurgeProductsRequest.newBuilder()
              .setDeleteOrphanProducts(true)
              // The operation is irreversible and removes multiple products.
              // The user is required to pass in force=True to actually perform the
              // purge.
              // If force is not set to True, the service raises an exception.
              .setForce(true)
              .setParent(parent)
              .build();

      OperationFuture response = client.purgeProductsAsync(request);
      response.getPollingFuture().get(180, TimeUnit.SECONDS);

      System.out.println("Orphan products deleted.");
    }
  }
}
// [END vision_product_search_purge_orphan_products]
