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

// [START edgenetwork_v1_generated_EdgeNetwork_GetInterconnectAttachment_async]
import com.google.api.core.ApiFuture;
import google.cloud.edgenetwork.v1.EdgeNetworkClient;
import google.cloud.edgenetwork.v1.GetInterconnectAttachmentRequest;
import google.cloud.edgenetwork.v1.InterconnectAttachment;
import google.cloud.edgenetwork.v1.InterconnectAttachmentName;

public class AsyncGetInterconnectAttachment {

  public static void main(String[] args) throws Exception {
    asyncGetInterconnectAttachment();
  }

  public static void asyncGetInterconnectAttachment() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
      GetInterconnectAttachmentRequest request =
          GetInterconnectAttachmentRequest.newBuilder()
              .setName(
                  InterconnectAttachmentName.of(
                          "[PROJECT]", "[LOCATION]", "[ZONE]", "[INTERCONNECT_ATTACHMENT]")
                      .toString())
              .build();
      ApiFuture<InterconnectAttachment> future =
          edgeNetworkClient.getInterconnectAttachmentCallable().futureCall(request);
      // Do something.
      InterconnectAttachment response = future.get();
    }
  }
}
// [END edgenetwork_v1_generated_EdgeNetwork_GetInterconnectAttachment_async]
