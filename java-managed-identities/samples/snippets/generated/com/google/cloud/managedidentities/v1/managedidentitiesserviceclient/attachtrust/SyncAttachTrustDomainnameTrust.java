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

package com.google.cloud.managedidentities.v1.samples;

// [START managedidentities_v1_generated_managedidentitiesserviceclient_attachtrust_domainnametrust_sync]
import com.google.cloud.managedidentities.v1.Domain;
import com.google.cloud.managedidentities.v1.DomainName;
import com.google.cloud.managedidentities.v1.ManagedIdentitiesServiceClient;
import com.google.cloud.managedidentities.v1.Trust;

public class SyncAttachTrustDomainnameTrust {

  public static void main(String[] args) throws Exception {
    syncAttachTrustDomainnameTrust();
  }

  public static void syncAttachTrustDomainnameTrust() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    try (ManagedIdentitiesServiceClient managedIdentitiesServiceClient =
        ManagedIdentitiesServiceClient.create()) {
      DomainName name = DomainName.of("[PROJECT]", "[LOCATION]", "[DOMAIN]");
      Trust trust = Trust.newBuilder().build();
      Domain response = managedIdentitiesServiceClient.attachTrustAsync(name, trust).get();
    }
  }
}
// [END managedidentities_v1_generated_managedidentitiesserviceclient_attachtrust_domainnametrust_sync]
