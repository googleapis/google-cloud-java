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

package com.google.cloud.iam.credentials.v1.samples;

// [START iamcredentials_v1_generated_IAMCredentials_SignBlob_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.iam.credentials.v1.IamCredentialsClient;
import com.google.cloud.iam.credentials.v1.ServiceAccountName;
import com.google.cloud.iam.credentials.v1.SignBlobRequest;
import com.google.cloud.iam.credentials.v1.SignBlobResponse;
import com.google.protobuf.ByteString;
import java.util.ArrayList;

public class AsyncSignBlob {

  public static void main(String[] args) throws Exception {
    asyncSignBlob();
  }

  public static void asyncSignBlob() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (IamCredentialsClient iamCredentialsClient = IamCredentialsClient.create()) {
      SignBlobRequest request =
          SignBlobRequest.newBuilder()
              .setName(ServiceAccountName.of("[PROJECT]", "[SERVICE_ACCOUNT]").toString())
              .addAllDelegates(new ArrayList<String>())
              .setPayload(ByteString.EMPTY)
              .build();
      ApiFuture<SignBlobResponse> future =
          iamCredentialsClient.signBlobCallable().futureCall(request);
      // Do something.
      SignBlobResponse response = future.get();
    }
  }
}
// [END iamcredentials_v1_generated_IAMCredentials_SignBlob_async]
