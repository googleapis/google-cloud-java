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

package com.google.cloud.memorystore.v1beta.samples;

// [START memorystore_v1beta_generated_Memorystore_DeleteTokenAuthUser_LRO_async]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.memorystore.v1beta.DeleteTokenAuthUserRequest;
import com.google.cloud.memorystore.v1beta.MemorystoreClient;
import com.google.cloud.memorystore.v1beta.OperationMetadata;
import com.google.cloud.memorystore.v1beta.TokenAuthUserName;
import com.google.protobuf.Empty;

public class AsyncDeleteTokenAuthUserLRO {

  public static void main(String[] args) throws Exception {
    asyncDeleteTokenAuthUserLRO();
  }

  public static void asyncDeleteTokenAuthUserLRO() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
      DeleteTokenAuthUserRequest request =
          DeleteTokenAuthUserRequest.newBuilder()
              .setName(
                  TokenAuthUserName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[TOKEN_AUTH_USER]")
                      .toString())
              .setRequestId("requestId693933066")
              .setForce(true)
              .build();
      OperationFuture<Empty, OperationMetadata> future =
          memorystoreClient.deleteTokenAuthUserOperationCallable().futureCall(request);
      // Do something.
      future.get();
    }
  }
}
// [END memorystore_v1beta_generated_Memorystore_DeleteTokenAuthUser_LRO_async]
