/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.dataplex.v1.samples;

// [START dataplex_v1_generated_CatalogService_LookupEntry_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.dataplex.v1.CatalogServiceClient;
import com.google.cloud.dataplex.v1.Entry;
import com.google.cloud.dataplex.v1.EntryName;
import com.google.cloud.dataplex.v1.EntryView;
import com.google.cloud.dataplex.v1.LookupEntryRequest;
import java.util.ArrayList;

public class AsyncLookupEntry {

  public static void main(String[] args) throws Exception {
    asyncLookupEntry();
  }

  public static void asyncLookupEntry() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
      LookupEntryRequest request =
          LookupEntryRequest.newBuilder()
              .setName("name3373707")
              .setView(EntryView.forNumber(0))
              .addAllAspectTypes(new ArrayList<String>())
              .addAllPaths(new ArrayList<String>())
              .setEntry(
                  EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]").toString())
              .build();
      ApiFuture<Entry> future = catalogServiceClient.lookupEntryCallable().futureCall(request);
      // Do something.
      Entry response = future.get();
    }
  }
}
// [END dataplex_v1_generated_CatalogService_LookupEntry_async]
