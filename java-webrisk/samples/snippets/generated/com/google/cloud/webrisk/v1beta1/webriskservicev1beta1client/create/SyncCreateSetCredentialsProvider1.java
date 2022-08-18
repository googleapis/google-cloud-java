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

package com.google.cloud.webrisk.v1beta1.samples;

// [START webrisk_v1beta1_generated_webriskservicev1beta1client_create_setcredentialsprovider1_sync]
import com.google.cloud.webrisk.v1beta1.WebRiskServiceV1Beta1Client;
import com.google.cloud.webrisk.v1beta1.WebRiskServiceV1Beta1Settings;

public class SyncCreateSetCredentialsProvider1 {

  public static void main(String[] args) throws Exception {
    syncCreateSetCredentialsProvider1();
  }

  public static void syncCreateSetCredentialsProvider1() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    WebRiskServiceV1Beta1Settings webRiskServiceV1Beta1Settings =
        WebRiskServiceV1Beta1Settings.newBuilder()
            .setTransportChannelProvider(
                WebRiskServiceV1Beta1Settings.defaultHttpJsonTransportProviderBuilder().build())
            .build();
    WebRiskServiceV1Beta1Client webRiskServiceV1Beta1Client =
        WebRiskServiceV1Beta1Client.create(webRiskServiceV1Beta1Settings);
  }
}
// [END webrisk_v1beta1_generated_webriskservicev1beta1client_create_setcredentialsprovider1_sync]
