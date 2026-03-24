/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.biglake.hive.v1beta.samples;

// [START biglake_v1beta_generated_HiveMetastoreService_BatchUpdatePartitions_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.biglake.hive.v1beta.BatchUpdatePartitionsRequest;
import com.google.cloud.biglake.hive.v1beta.BatchUpdatePartitionsResponse;
import com.google.cloud.biglake.hive.v1beta.HiveMetastoreServiceClient;
import com.google.cloud.biglake.hive.v1beta.TableName;
import com.google.cloud.biglake.hive.v1beta.UpdatePartitionRequest;
import java.util.ArrayList;

public class AsyncBatchUpdatePartitions {

  public static void main(String[] args) throws Exception {
    asyncBatchUpdatePartitions();
  }

  public static void asyncBatchUpdatePartitions() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (HiveMetastoreServiceClient hiveMetastoreServiceClient =
        HiveMetastoreServiceClient.create()) {
      BatchUpdatePartitionsRequest request =
          BatchUpdatePartitionsRequest.newBuilder()
              .setParent(TableName.of("[PROJECT]", "[CATALOG]", "[DATABASE]", "[TABLE]").toString())
              .addAllRequests(new ArrayList<UpdatePartitionRequest>())
              .build();
      ApiFuture<BatchUpdatePartitionsResponse> future =
          hiveMetastoreServiceClient.batchUpdatePartitionsCallable().futureCall(request);
      // Do something.
      BatchUpdatePartitionsResponse response = future.get();
    }
  }
}
// [END biglake_v1beta_generated_HiveMetastoreService_BatchUpdatePartitions_async]
