/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.migrationcenter.v1.samples;

// [START migrationcenter_v1_generated_MigrationCenter_BatchDeleteAssets_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.migrationcenter.v1.BatchDeleteAssetsRequest;
import com.google.cloud.migrationcenter.v1.LocationName;
import com.google.cloud.migrationcenter.v1.MigrationCenterClient;
import com.google.protobuf.Empty;
import java.util.ArrayList;

public class AsyncBatchDeleteAssets {

  public static void main(String[] args) throws Exception {
    asyncBatchDeleteAssets();
  }

  public static void asyncBatchDeleteAssets() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
      BatchDeleteAssetsRequest request =
          BatchDeleteAssetsRequest.newBuilder()
              .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
              .addAllNames(new ArrayList<String>())
              .setAllowMissing(true)
              .build();
      ApiFuture<Empty> future =
          migrationCenterClient.batchDeleteAssetsCallable().futureCall(request);
      // Do something.
      future.get();
    }
  }
}
// [END migrationcenter_v1_generated_MigrationCenter_BatchDeleteAssets_async]
