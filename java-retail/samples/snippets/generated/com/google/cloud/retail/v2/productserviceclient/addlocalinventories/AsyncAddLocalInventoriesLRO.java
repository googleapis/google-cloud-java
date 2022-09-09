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

// [START retail_v2_generated_productserviceclient_addlocalinventories_lro_async]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.retail.v2.AddLocalInventoriesMetadata;
import com.google.cloud.retail.v2.AddLocalInventoriesRequest;
import com.google.cloud.retail.v2.AddLocalInventoriesResponse;
import com.google.cloud.retail.v2.LocalInventory;
import com.google.cloud.retail.v2.ProductName;
import com.google.cloud.retail.v2.ProductServiceClient;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import java.util.ArrayList;

public class AsyncAddLocalInventoriesLRO {

  public static void main(String[] args) throws Exception {
    asyncAddLocalInventoriesLRO();
  }

  public static void asyncAddLocalInventoriesLRO() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (ProductServiceClient productServiceClient = ProductServiceClient.create()) {
      AddLocalInventoriesRequest request =
          AddLocalInventoriesRequest.newBuilder()
              .setProduct(
                  ProductName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[BRANCH]", "[PRODUCT]")
                      .toString())
              .addAllLocalInventories(new ArrayList<LocalInventory>())
              .setAddMask(FieldMask.newBuilder().build())
              .setAddTime(Timestamp.newBuilder().build())
              .setAllowMissing(true)
              .build();
      OperationFuture<AddLocalInventoriesResponse, AddLocalInventoriesMetadata> future =
          productServiceClient.addLocalInventoriesOperationCallable().futureCall(request);
      // Do something.
      AddLocalInventoriesResponse response = future.get();
    }
  }
}
// [END retail_v2_generated_productserviceclient_addlocalinventories_lro_async]
