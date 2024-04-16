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

package com.google.cloud.discoveryengine.v1.samples;

// [START discoveryengine_v1_generated_DocumentService_UpdateDocument_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.discoveryengine.v1.Document;
import com.google.cloud.discoveryengine.v1.DocumentServiceClient;
import com.google.cloud.discoveryengine.v1.UpdateDocumentRequest;
import com.google.protobuf.FieldMask;

public class AsyncUpdateDocument {

  public static void main(String[] args) throws Exception {
    asyncUpdateDocument();
  }

  public static void asyncUpdateDocument() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (DocumentServiceClient documentServiceClient = DocumentServiceClient.create()) {
      UpdateDocumentRequest request =
          UpdateDocumentRequest.newBuilder()
              .setDocument(Document.newBuilder().build())
              .setAllowMissing(true)
              .setUpdateMask(FieldMask.newBuilder().build())
              .build();
      ApiFuture<Document> future =
          documentServiceClient.updateDocumentCallable().futureCall(request);
      // Do something.
      Document response = future.get();
    }
  }
}
// [END discoveryengine_v1_generated_DocumentService_UpdateDocument_async]
