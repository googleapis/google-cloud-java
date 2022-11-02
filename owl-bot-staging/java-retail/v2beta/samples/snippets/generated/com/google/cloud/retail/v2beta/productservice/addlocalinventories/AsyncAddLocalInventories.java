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

package com.google.cloud.retail.v2beta.samples;

// [START retail_v2beta_generated_ProductService_AddLocalInventories_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.retail.v2beta.AddLocalInventoriesRequest;
import com.google.cloud.retail.v2beta.LocalInventory;
import com.google.cloud.retail.v2beta.ProductName;
import com.google.cloud.retail.v2beta.ProductServiceClient;
import com.google.longrunning.Operation;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import java.util.ArrayList;

public class AsyncAddLocalInventories {

  public static void main(String[] args) throws Exception {
    asyncAddLocalInventories();
  }

  public static void asyncAddLocalInventories() throws Exception {
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
      ApiFuture<Operation> future =
          productServiceClient.addLocalInventoriesCallable().futureCall(request);
      // Do something.
      Operation response = future.get();
    }
  }
}
// [END retail_v2beta_generated_ProductService_AddLocalInventories_async]
