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

package com.google.cloud.contentwarehouse.v1.samples;

// [START contentwarehouse_v1_generated_DocumentService_SearchDocuments_sync]
import com.google.cloud.contentwarehouse.v1.DocumentQuery;
import com.google.cloud.contentwarehouse.v1.DocumentServiceClient;
import com.google.cloud.contentwarehouse.v1.HistogramQuery;
import com.google.cloud.contentwarehouse.v1.LocationName;
import com.google.cloud.contentwarehouse.v1.RequestMetadata;
import com.google.cloud.contentwarehouse.v1.SearchDocumentsRequest;
import com.google.cloud.contentwarehouse.v1.SearchDocumentsResponse;
import java.util.ArrayList;

public class SyncSearchDocuments {

  public static void main(String[] args) throws Exception {
    syncSearchDocuments();
  }

  public static void syncSearchDocuments() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (DocumentServiceClient documentServiceClient = DocumentServiceClient.create()) {
      SearchDocumentsRequest request =
          SearchDocumentsRequest.newBuilder()
              .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
              .setRequestMetadata(RequestMetadata.newBuilder().build())
              .setDocumentQuery(DocumentQuery.newBuilder().build())
              .setOffset(-1019779949)
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setOrderBy("orderBy-1207110587")
              .addAllHistogramQueries(new ArrayList<HistogramQuery>())
              .setRequireTotalSize(true)
              .setQaSizeLimit(142059404)
              .build();
      for (SearchDocumentsResponse.MatchingDocument element :
          documentServiceClient.searchDocuments(request).iterateAll()) {
        // doThingsWith(element);
      }
    }
  }
}
// [END contentwarehouse_v1_generated_DocumentService_SearchDocuments_sync]
