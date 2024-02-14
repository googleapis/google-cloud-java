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

package com.google.cloud.bigquery.datatransfer.v1.samples;

// [START bigquerydatatransfer_v1_generated_DataTransferService_ListTransferRuns_Paged_async]
import com.google.cloud.bigquery.datatransfer.v1.DataTransferServiceClient;
import com.google.cloud.bigquery.datatransfer.v1.ListTransferRunsRequest;
import com.google.cloud.bigquery.datatransfer.v1.ListTransferRunsResponse;
import com.google.cloud.bigquery.datatransfer.v1.TransferConfigName;
import com.google.cloud.bigquery.datatransfer.v1.TransferRun;
import com.google.cloud.bigquery.datatransfer.v1.TransferState;
import com.google.common.base.Strings;
import java.util.ArrayList;

public class AsyncListTransferRunsPaged {

  public static void main(String[] args) throws Exception {
    asyncListTransferRunsPaged();
  }

  public static void asyncListTransferRunsPaged() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
      ListTransferRunsRequest request =
          ListTransferRunsRequest.newBuilder()
              .setParent(
                  TransferConfigName.ofProjectLocationTransferConfigName(
                          "[PROJECT]", "[LOCATION]", "[TRANSFER_CONFIG]")
                      .toString())
              .addAllStates(new ArrayList<TransferState>())
              .setPageToken("pageToken873572522")
              .setPageSize(883849137)
              .build();
      while (true) {
        ListTransferRunsResponse response =
            dataTransferServiceClient.listTransferRunsCallable().call(request);
        for (TransferRun element : response.getTransferRunsList()) {
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
// [END bigquerydatatransfer_v1_generated_DataTransferService_ListTransferRuns_Paged_async]
