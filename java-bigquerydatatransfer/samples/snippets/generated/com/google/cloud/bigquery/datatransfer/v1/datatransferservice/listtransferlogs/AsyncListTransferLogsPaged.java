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

package com.google.cloud.bigquery.datatransfer.v1.samples;

// [START bigquerydatatransfer_v1_generated_DataTransferService_ListTransferLogs_Paged_async]
import com.google.cloud.bigquery.datatransfer.v1.DataTransferServiceClient;
import com.google.cloud.bigquery.datatransfer.v1.ListTransferLogsRequest;
import com.google.cloud.bigquery.datatransfer.v1.ListTransferLogsResponse;
import com.google.cloud.bigquery.datatransfer.v1.RunName;
import com.google.cloud.bigquery.datatransfer.v1.TransferMessage;
import com.google.common.base.Strings;
import java.util.ArrayList;

public class AsyncListTransferLogsPaged {

  public static void main(String[] args) throws Exception {
    asyncListTransferLogsPaged();
  }

  public static void asyncListTransferLogsPaged() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
      ListTransferLogsRequest request =
          ListTransferLogsRequest.newBuilder()
              .setParent(
                  RunName.ofProjectLocationTransferConfigRunName(
                          "[PROJECT]", "[LOCATION]", "[TRANSFER_CONFIG]", "[RUN]")
                      .toString())
              .setPageToken("pageToken873572522")
              .setPageSize(883849137)
              .addAllMessageTypes(new ArrayList<TransferMessage.MessageSeverity>())
              .build();
      while (true) {
        ListTransferLogsResponse response =
            dataTransferServiceClient.listTransferLogsCallable().call(request);
        for (TransferMessage element : response.getTransferMessagesList()) {
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
// [END bigquerydatatransfer_v1_generated_DataTransferService_ListTransferLogs_Paged_async]
