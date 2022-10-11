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

package com.google.cloud.gkeconnect.gateway.v1beta1.samples;

// [START gateway_v1beta1_generated_gatewayserviceclient_deleteresource_sync]
import com.google.api.HttpBody;
import com.google.cloud.gkeconnect.gateway.v1beta1.GatewayServiceClient;
import com.google.protobuf.Any;
import com.google.protobuf.ByteString;
import java.util.ArrayList;

public class SyncDeleteResource {

  public static void main(String[] args) throws Exception {
    syncDeleteResource();
  }

  public static void syncDeleteResource() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (GatewayServiceClient gatewayServiceClient = GatewayServiceClient.create()) {
      HttpBody request =
          HttpBody.newBuilder()
              .setContentType("contentType-389131437")
              .setData(ByteString.EMPTY)
              .addAllExtensions(new ArrayList<Any>())
              .build();
      HttpBody response = gatewayServiceClient.deleteResource(request);
    }
  }
}
// [END gateway_v1beta1_generated_gatewayserviceclient_deleteresource_sync]
