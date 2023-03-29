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

package com.google.cloud.channel.v1.samples;

// [START cloudchannel_v1_generated_CloudChannelService_TransferEntitlementsToGoogle_sync]
import com.google.cloud.channel.v1.CloudChannelServiceClient;
import com.google.cloud.channel.v1.Entitlement;
import com.google.cloud.channel.v1.TransferEntitlementsToGoogleRequest;
import com.google.protobuf.Empty;
import java.util.ArrayList;

public class SyncTransferEntitlementsToGoogle {

  public static void main(String[] args) throws Exception {
    syncTransferEntitlementsToGoogle();
  }

  public static void syncTransferEntitlementsToGoogle() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
      TransferEntitlementsToGoogleRequest request =
          TransferEntitlementsToGoogleRequest.newBuilder()
              .setParent("parent-995424086")
              .addAllEntitlements(new ArrayList<Entitlement>())
              .setRequestId("requestId693933066")
              .build();
      cloudChannelServiceClient.transferEntitlementsToGoogleAsync(request).get();
    }
  }
}
// [END cloudchannel_v1_generated_CloudChannelService_TransferEntitlementsToGoogle_sync]
