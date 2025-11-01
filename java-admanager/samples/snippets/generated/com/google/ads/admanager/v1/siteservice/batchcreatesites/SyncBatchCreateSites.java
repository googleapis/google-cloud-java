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

package com.google.ads.admanager.v1.samples;

// [START admanager_v1_generated_SiteService_BatchCreateSites_sync]
import com.google.ads.admanager.v1.BatchCreateSitesRequest;
import com.google.ads.admanager.v1.BatchCreateSitesResponse;
import com.google.ads.admanager.v1.CreateSiteRequest;
import com.google.ads.admanager.v1.NetworkName;
import com.google.ads.admanager.v1.SiteServiceClient;
import java.util.ArrayList;

public class SyncBatchCreateSites {

  public static void main(String[] args) throws Exception {
    syncBatchCreateSites();
  }

  public static void syncBatchCreateSites() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (SiteServiceClient siteServiceClient = SiteServiceClient.create()) {
      BatchCreateSitesRequest request =
          BatchCreateSitesRequest.newBuilder()
              .setParent(NetworkName.of("[NETWORK_CODE]").toString())
              .addAllRequests(new ArrayList<CreateSiteRequest>())
              .build();
      BatchCreateSitesResponse response = siteServiceClient.batchCreateSites(request);
    }
  }
}
// [END admanager_v1_generated_SiteService_BatchCreateSites_sync]
