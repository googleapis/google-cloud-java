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

package com.google.cloud.servicedirectory.v1beta1.samples;

// [START servicedirectory_v1beta1_generated_lookupserviceclient_create_setcredentialsprovider_sync]
import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.cloud.servicedirectory.v1beta1.LookupServiceClient;
import com.google.cloud.servicedirectory.v1beta1.LookupServiceSettings;
import com.google.cloud.servicedirectory.v1beta1.myCredentials;

public class SyncCreateSetCredentialsProvider {

  public static void main(String[] args) throws Exception {
    syncCreateSetCredentialsProvider();
  }

  public static void syncCreateSetCredentialsProvider() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    LookupServiceSettings lookupServiceSettings =
        LookupServiceSettings.newBuilder()
            .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
            .build();
    LookupServiceClient lookupServiceClient = LookupServiceClient.create(lookupServiceSettings);
  }
}
// [END servicedirectory_v1beta1_generated_lookupserviceclient_create_setcredentialsprovider_sync]
