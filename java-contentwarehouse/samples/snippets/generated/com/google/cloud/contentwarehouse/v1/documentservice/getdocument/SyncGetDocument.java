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

package com.google.cloud.contentwarehouse.v1.samples;

// [START contentwarehouse_v1_generated_DocumentService_GetDocument_sync]
import com.google.cloud.contentwarehouse.v1.Document;
import com.google.cloud.contentwarehouse.v1.DocumentName;
import com.google.cloud.contentwarehouse.v1.DocumentServiceClient;
import com.google.cloud.contentwarehouse.v1.GetDocumentRequest;
import com.google.cloud.contentwarehouse.v1.RequestMetadata;

public class SyncGetDocument {

  public static void main(String[] args) throws Exception {
    syncGetDocument();
  }

  public static void syncGetDocument() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (DocumentServiceClient documentServiceClient = DocumentServiceClient.create()) {
      GetDocumentRequest request =
          GetDocumentRequest.newBuilder()
              .setName(
                  DocumentName.ofProjectLocationDocumentName(
                          "[PROJECT]", "[LOCATION]", "[DOCUMENT]")
                      .toString())
              .setRequestMetadata(RequestMetadata.newBuilder().build())
              .build();
      Document response = documentServiceClient.getDocument(request);
    }
  }
}
// [END contentwarehouse_v1_generated_DocumentService_GetDocument_sync]
