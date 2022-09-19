/*
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.retail.v2.samples;

// [START retail_v2_generated_productserviceclient_removefulfillmentplaces_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.retail.v2.ProductName;
import com.google.cloud.retail.v2.ProductServiceClient;
import com.google.cloud.retail.v2.RemoveFulfillmentPlacesRequest;
import com.google.longrunning.Operation;
import com.google.protobuf.Timestamp;
import java.util.ArrayList;

public class AsyncRemoveFulfillmentPlaces {

  public static void main(String[] args) throws Exception {
    asyncRemoveFulfillmentPlaces();
  }

  public static void asyncRemoveFulfillmentPlaces() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (ProductServiceClient productServiceClient = ProductServiceClient.create()) {
      RemoveFulfillmentPlacesRequest request =
          RemoveFulfillmentPlacesRequest.newBuilder()
              .setProduct(
                  ProductName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[BRANCH]", "[PRODUCT]")
                      .toString())
              .setType("type3575610")
              .addAllPlaceIds(new ArrayList<String>())
              .setRemoveTime(Timestamp.newBuilder().build())
              .setAllowMissing(true)
              .build();
      ApiFuture<Operation> future =
          productServiceClient.removeFulfillmentPlacesCallable().futureCall(request);
      // Do something.
      Operation response = future.get();
    }
  }
}
// [END retail_v2_generated_productserviceclient_removefulfillmentplaces_async]
