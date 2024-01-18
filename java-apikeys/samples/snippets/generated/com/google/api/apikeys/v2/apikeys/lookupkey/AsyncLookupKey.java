/*
 * Copyright 2023 Google LLC
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

package com.google.api.apikeys.v2.samples;

// [START apikeys_v2_generated_ApiKeys_LookupKey_async]
import com.google.api.apikeys.v2.ApiKeysClient;
import com.google.api.apikeys.v2.LookupKeyRequest;
import com.google.api.apikeys.v2.LookupKeyResponse;
import com.google.api.core.ApiFuture;

public class AsyncLookupKey {

  public static void main(String[] args) throws Exception {
    asyncLookupKey();
  }

  public static void asyncLookupKey() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (ApiKeysClient apiKeysClient = ApiKeysClient.create()) {
      LookupKeyRequest request =
          LookupKeyRequest.newBuilder().setKeyString("keyString-1988270256").build();
      ApiFuture<LookupKeyResponse> future = apiKeysClient.lookupKeyCallable().futureCall(request);
      // Do something.
      LookupKeyResponse response = future.get();
    }
  }
}
// [END apikeys_v2_generated_ApiKeys_LookupKey_async]
