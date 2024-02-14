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

// [START contentwarehouse_v1_generated_DocumentLinkService_DeleteDocumentLink_Documentlinkname_sync]
import com.google.cloud.contentwarehouse.v1.DocumentLinkName;
import com.google.cloud.contentwarehouse.v1.DocumentLinkServiceClient;
import com.google.protobuf.Empty;

public class SyncDeleteDocumentLinkDocumentlinkname {

  public static void main(String[] args) throws Exception {
    syncDeleteDocumentLinkDocumentlinkname();
  }

  public static void syncDeleteDocumentLinkDocumentlinkname() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (DocumentLinkServiceClient documentLinkServiceClient = DocumentLinkServiceClient.create()) {
      DocumentLinkName name =
          DocumentLinkName.of("[PROJECT]", "[LOCATION]", "[DOCUMENT]", "[DOCUMENT_LINK]");
      documentLinkServiceClient.deleteDocumentLink(name);
    }
  }
}
// [END contentwarehouse_v1_generated_DocumentLinkService_DeleteDocumentLink_Documentlinkname_sync]
