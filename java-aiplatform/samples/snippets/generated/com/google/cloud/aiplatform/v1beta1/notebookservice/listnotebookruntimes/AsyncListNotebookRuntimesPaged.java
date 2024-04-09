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

package com.google.cloud.aiplatform.v1beta1.samples;

// [START aiplatform_v1beta1_generated_NotebookService_ListNotebookRuntimes_Paged_async]
import com.google.cloud.aiplatform.v1beta1.ListNotebookRuntimesRequest;
import com.google.cloud.aiplatform.v1beta1.ListNotebookRuntimesResponse;
import com.google.cloud.aiplatform.v1beta1.LocationName;
import com.google.cloud.aiplatform.v1beta1.NotebookRuntime;
import com.google.cloud.aiplatform.v1beta1.NotebookServiceClient;
import com.google.common.base.Strings;
import com.google.protobuf.FieldMask;

public class AsyncListNotebookRuntimesPaged {

  public static void main(String[] args) throws Exception {
    asyncListNotebookRuntimesPaged();
  }

  public static void asyncListNotebookRuntimesPaged() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
      ListNotebookRuntimesRequest request =
          ListNotebookRuntimesRequest.newBuilder()
              .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
              .setFilter("filter-1274492040")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setReadMask(FieldMask.newBuilder().build())
              .setOrderBy("orderBy-1207110587")
              .build();
      while (true) {
        ListNotebookRuntimesResponse response =
            notebookServiceClient.listNotebookRuntimesCallable().call(request);
        for (NotebookRuntime element : response.getNotebookRuntimesList()) {
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
// [END aiplatform_v1beta1_generated_NotebookService_ListNotebookRuntimes_Paged_async]
