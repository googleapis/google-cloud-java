/*
 * Copyright 2026 Google LLC
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

package com.google.storage.v2.samples;

// [START storage_v2_generated_Storage_ComposeObject_async]
import com.google.api.core.ApiFuture;
import com.google.storage.v2.CommonObjectRequestParams;
import com.google.storage.v2.ComposeObjectRequest;
import com.google.storage.v2.CryptoKeyName;
import com.google.storage.v2.Object;
import com.google.storage.v2.ObjectChecksums;
import com.google.storage.v2.StorageClient;
import java.util.ArrayList;

public class AsyncComposeObject {

  public static void main(String[] args) throws Exception {
    asyncComposeObject();
  }

  public static void asyncComposeObject() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (StorageClient storageClient = StorageClient.create()) {
      ComposeObjectRequest request =
          ComposeObjectRequest.newBuilder()
              .setDestination(Object.newBuilder().build())
              .addAllSourceObjects(new ArrayList<ComposeObjectRequest.SourceObject>())
              .setDestinationPredefinedAcl("destinationPredefinedAcl1111125814")
              .setIfGenerationMatch(-1086241088)
              .setIfMetagenerationMatch(1043427781)
              .setKmsKey(
                  CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]")
                      .toString())
              .setCommonObjectRequestParams(CommonObjectRequestParams.newBuilder().build())
              .setObjectChecksums(ObjectChecksums.newBuilder().build())
              .build();
      ApiFuture<Object> future = storageClient.composeObjectCallable().futureCall(request);
      // Do something.
      Object response = future.get();
    }
  }
}
// [END storage_v2_generated_Storage_ComposeObject_async]
