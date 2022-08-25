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

// [START managedidentities_v1_generated_managedidentitiesserviceclient_listdomains_sync]
import com.google.cloud.managedidentities.v1.Domain;
import com.google.cloud.managedidentities.v1.ListDomainsRequest;
import com.google.cloud.managedidentities.v1.LocationName;
import com.google.cloud.managedidentities.v1.ManagedIdentitiesServiceClient;

public class SyncListDomains {

  public static void main(String[] args) throws Exception {
    syncListDomains();
  }

  public static void syncListDomains() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    try (ManagedIdentitiesServiceClient managedIdentitiesServiceClient =
        ManagedIdentitiesServiceClient.create()) {
      ListDomainsRequest request =
          ListDomainsRequest.newBuilder()
              .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setFilter("filter-1274492040")
              .setOrderBy("orderBy-1207110587")
              .build();
      for (Domain element : managedIdentitiesServiceClient.listDomains(request).iterateAll()) {
        // doThingsWith(element);
      }
    }
  }
}
// [END managedidentities_v1_generated_managedidentitiesserviceclient_listdomains_sync]
