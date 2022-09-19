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

package com.google.cloud.billing.v1.samples;

// [START billing_v1_generated_cloudcatalogclient_listskus_sync]
import com.google.cloud.billing.v1.CloudCatalogClient;
import com.google.cloud.billing.v1.ListSkusRequest;
import com.google.cloud.billing.v1.ServiceName;
import com.google.cloud.billing.v1.Sku;
import com.google.protobuf.Timestamp;

public class SyncListSkus {

  public static void main(String[] args) throws Exception {
    syncListSkus();
  }

  public static void syncListSkus() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (CloudCatalogClient cloudCatalogClient = CloudCatalogClient.create()) {
      ListSkusRequest request =
          ListSkusRequest.newBuilder()
              .setParent(ServiceName.of("[SERVICE]").toString())
              .setStartTime(Timestamp.newBuilder().build())
              .setEndTime(Timestamp.newBuilder().build())
              .setCurrencyCode("currencyCode1004773790")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      for (Sku element : cloudCatalogClient.listSkus(request).iterateAll()) {
        // doThingsWith(element);
      }
    }
  }
}
// [END billing_v1_generated_cloudcatalogclient_listskus_sync]
