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

package com.google.cloud.managedidentities.v1beta1.samples;

// [START managedidentities_v1beta1_generated_managedidentitiesserviceclient_createmicrosoftaddomain_stringstringdomain_sync]
import com.google.cloud.managedidentities.v1beta1.Domain;
import com.google.cloud.managedidentities.v1beta1.LocationName;
import com.google.cloud.managedidentities.v1beta1.ManagedIdentitiesServiceClient;

public class SyncCreateMicrosoftAdDomainStringStringDomain {

  public static void main(String[] args) throws Exception {
    syncCreateMicrosoftAdDomainStringStringDomain();
  }

  public static void syncCreateMicrosoftAdDomainStringStringDomain() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    try (ManagedIdentitiesServiceClient managedIdentitiesServiceClient =
        ManagedIdentitiesServiceClient.create()) {
      String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
      String domainName = "domainName-1244085905";
      Domain domain = Domain.newBuilder().build();
      Domain response =
          managedIdentitiesServiceClient
              .createMicrosoftAdDomainAsync(parent, domainName, domain)
              .get();
    }
  }
}
// [END managedidentities_v1beta1_generated_managedidentitiesserviceclient_createmicrosoftaddomain_stringstringdomain_sync]
