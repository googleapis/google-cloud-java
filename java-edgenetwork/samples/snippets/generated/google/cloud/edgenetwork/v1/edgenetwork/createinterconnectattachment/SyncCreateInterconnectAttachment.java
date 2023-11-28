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

package google.cloud.edgenetwork.v1.samples;

// [START edgenetwork_v1_generated_EdgeNetwork_CreateInterconnectAttachment_sync]
import google.cloud.edgenetwork.v1.CreateInterconnectAttachmentRequest;
import google.cloud.edgenetwork.v1.EdgeNetworkClient;
import google.cloud.edgenetwork.v1.InterconnectAttachment;
import google.cloud.edgenetwork.v1.ZoneName;

public class SyncCreateInterconnectAttachment {

  public static void main(String[] args) throws Exception {
    syncCreateInterconnectAttachment();
  }

  public static void syncCreateInterconnectAttachment() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
      CreateInterconnectAttachmentRequest request =
          CreateInterconnectAttachmentRequest.newBuilder()
              .setParent(ZoneName.of("[PROJECT]", "[LOCATION]", "[ZONE]").toString())
              .setInterconnectAttachmentId("interconnectAttachmentId1053538636")
              .setInterconnectAttachment(InterconnectAttachment.newBuilder().build())
              .setRequestId("requestId693933066")
              .build();
      InterconnectAttachment response =
          edgeNetworkClient.createInterconnectAttachmentAsync(request).get();
    }
  }
}
// [END edgenetwork_v1_generated_EdgeNetwork_CreateInterconnectAttachment_sync]
