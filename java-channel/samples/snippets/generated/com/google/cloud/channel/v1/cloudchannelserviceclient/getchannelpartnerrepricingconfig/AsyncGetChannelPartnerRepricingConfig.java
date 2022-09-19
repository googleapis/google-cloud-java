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

// [START channel_v1_generated_cloudchannelserviceclient_getchannelpartnerrepricingconfig_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.channel.v1.ChannelPartnerRepricingConfig;
import com.google.cloud.channel.v1.ChannelPartnerRepricingConfigName;
import com.google.cloud.channel.v1.CloudChannelServiceClient;
import com.google.cloud.channel.v1.GetChannelPartnerRepricingConfigRequest;

public class AsyncGetChannelPartnerRepricingConfig {

  public static void main(String[] args) throws Exception {
    asyncGetChannelPartnerRepricingConfig();
  }

  public static void asyncGetChannelPartnerRepricingConfig() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
      GetChannelPartnerRepricingConfigRequest request =
          GetChannelPartnerRepricingConfigRequest.newBuilder()
              .setName(
                  ChannelPartnerRepricingConfigName.of(
                          "[ACCOUNT]", "[CHANNEL_PARTNER]", "[CHANNEL_PARTNER_REPRICING_CONFIG]")
                      .toString())
              .build();
      ApiFuture<ChannelPartnerRepricingConfig> future =
          cloudChannelServiceClient.getChannelPartnerRepricingConfigCallable().futureCall(request);
      // Do something.
      ChannelPartnerRepricingConfig response = future.get();
    }
  }
}
// [END channel_v1_generated_cloudchannelserviceclient_getchannelpartnerrepricingconfig_async]
