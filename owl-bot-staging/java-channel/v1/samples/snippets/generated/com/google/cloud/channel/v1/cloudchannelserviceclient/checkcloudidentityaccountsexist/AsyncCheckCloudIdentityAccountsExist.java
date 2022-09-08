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

// [START channel_v1_generated_cloudchannelserviceclient_checkcloudidentityaccountsexist_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.channel.v1.CheckCloudIdentityAccountsExistRequest;
import com.google.cloud.channel.v1.CheckCloudIdentityAccountsExistResponse;
import com.google.cloud.channel.v1.CloudChannelServiceClient;

public class AsyncCheckCloudIdentityAccountsExist {

  public static void main(String[] args) throws Exception {
    asyncCheckCloudIdentityAccountsExist();
  }

  public static void asyncCheckCloudIdentityAccountsExist() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
      CheckCloudIdentityAccountsExistRequest request =
          CheckCloudIdentityAccountsExistRequest.newBuilder()
              .setParent("parent-995424086")
              .setDomain("domain-1326197564")
              .build();
      ApiFuture<CheckCloudIdentityAccountsExistResponse> future =
          cloudChannelServiceClient.checkCloudIdentityAccountsExistCallable().futureCall(request);
      // Do something.
      CheckCloudIdentityAccountsExistResponse response = future.get();
    }
  }
}
// [END channel_v1_generated_cloudchannelserviceclient_checkcloudidentityaccountsexist_async]
