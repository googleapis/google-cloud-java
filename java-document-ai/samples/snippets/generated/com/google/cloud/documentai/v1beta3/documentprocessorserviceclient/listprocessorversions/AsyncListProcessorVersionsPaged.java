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

package com.google.cloud.documentai.v1beta3.samples;

// [START documentai_v1beta3_generated_documentprocessorserviceclient_listprocessorversions_paged_async]
import com.google.cloud.documentai.v1beta3.DocumentProcessorServiceClient;
import com.google.cloud.documentai.v1beta3.ListProcessorVersionsRequest;
import com.google.cloud.documentai.v1beta3.ListProcessorVersionsResponse;
import com.google.cloud.documentai.v1beta3.ProcessorName;
import com.google.cloud.documentai.v1beta3.ProcessorVersion;
import com.google.common.base.Strings;

public class AsyncListProcessorVersionsPaged {

  public static void main(String[] args) throws Exception {
    asyncListProcessorVersionsPaged();
  }

  public static void asyncListProcessorVersionsPaged() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (DocumentProcessorServiceClient documentProcessorServiceClient =
        DocumentProcessorServiceClient.create()) {
      ListProcessorVersionsRequest request =
          ListProcessorVersionsRequest.newBuilder()
              .setParent(ProcessorName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]").toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      while (true) {
        ListProcessorVersionsResponse response =
            documentProcessorServiceClient.listProcessorVersionsCallable().call(request);
        for (ProcessorVersion element : response.getProcessorVersionsList()) {
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
// [END documentai_v1beta3_generated_documentprocessorserviceclient_listprocessorversions_paged_async]
