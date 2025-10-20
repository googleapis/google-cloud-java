/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.capacityplanner.v1beta.samples;

// [START capacityplanner_v1beta_generated_UsageService_Create_SetCredentialsProvider_sync]
import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.cloud.capacityplanner.v1beta.UsageServiceClient;
import com.google.cloud.capacityplanner.v1beta.UsageServiceSettings;
import com.google.cloud.capacityplanner.v1beta.myCredentials;

public class SyncCreateSetCredentialsProvider {

  public static void main(String[] args) throws Exception {
    syncCreateSetCredentialsProvider();
  }

  public static void syncCreateSetCredentialsProvider() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    UsageServiceSettings usageServiceSettings =
        UsageServiceSettings.newBuilder()
            .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
            .build();
    UsageServiceClient usageServiceClient = UsageServiceClient.create(usageServiceSettings);
  }
}
// [END capacityplanner_v1beta_generated_UsageService_Create_SetCredentialsProvider_sync]
