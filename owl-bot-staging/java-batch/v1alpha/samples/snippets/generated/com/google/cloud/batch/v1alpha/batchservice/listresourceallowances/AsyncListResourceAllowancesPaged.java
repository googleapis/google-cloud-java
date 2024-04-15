/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.batch.v1alpha.samples;

// [START batch_v1alpha_generated_BatchService_ListResourceAllowances_Paged_async]
import com.google.cloud.batch.v1alpha.BatchServiceClient;
import com.google.cloud.batch.v1alpha.ListResourceAllowancesRequest;
import com.google.cloud.batch.v1alpha.ListResourceAllowancesResponse;
import com.google.cloud.batch.v1alpha.LocationName;
import com.google.cloud.batch.v1alpha.ResourceAllowance;
import com.google.common.base.Strings;

public class AsyncListResourceAllowancesPaged {

  public static void main(String[] args) throws Exception {
    asyncListResourceAllowancesPaged();
  }

  public static void asyncListResourceAllowancesPaged() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (BatchServiceClient batchServiceClient = BatchServiceClient.create()) {
      ListResourceAllowancesRequest request =
          ListResourceAllowancesRequest.newBuilder()
              .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      while (true) {
        ListResourceAllowancesResponse response =
            batchServiceClient.listResourceAllowancesCallable().call(request);
        for (ResourceAllowance element : response.getResourceAllowancesList()) {
          // doThingsWith(element);
        }
        String nextPageToken = response.getNextPageToken();
        if (!Strings.isNullOrEmpty(nextPageToken)) {
          request = request.toBuilder().setPageToken(nextPageToken).build();
        } else {
          break;
        }
      }
    }
  }
}
// [END batch_v1alpha_generated_BatchService_ListResourceAllowances_Paged_async]
