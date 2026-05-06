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

package com.google.cloud.bigtable.data.v2.samples;

// [START bigtable_v2_generated_Bigtable_MutateRows_async]
import com.google.api.gax.rpc.ServerStream;
import com.google.bigtable.v2.MutateRowsRequest;
import com.google.bigtable.v2.MutateRowsResponse;
import com.google.bigtable.v2.TableName;
import com.google.cloud.bigtable.data.v2.BaseBigtableDataClient;
import java.util.ArrayList;

public class AsyncMutateRows {

  public static void main(String[] args) throws Exception {
    asyncMutateRows();
  }

  public static void asyncMutateRows() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (BaseBigtableDataClient baseBigtableDataClient = BaseBigtableDataClient.create()) {
      MutateRowsRequest request =
          MutateRowsRequest.newBuilder()
              .setTableName(TableName.of("[PROJECT]", "[INSTANCE]", "[TABLE]").toString())
              .setAppProfileId("appProfileId704923523")
              .addAllEntries(new ArrayList<MutateRowsRequest.Entry>())
              .build();
      ServerStream<MutateRowsResponse> stream =
          baseBigtableDataClient.mutateRowsCallable().call(request);
      for (MutateRowsResponse response : stream) {
        // Do something when a response is received.
      }
    }
  }
}
// [END bigtable_v2_generated_Bigtable_MutateRows_async]
