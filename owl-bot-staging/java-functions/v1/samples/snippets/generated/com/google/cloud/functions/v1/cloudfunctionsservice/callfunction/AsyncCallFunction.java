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

package com.google.cloud.functions.v1.samples;

// [START cloudfunctions_v1_generated_CloudFunctionsService_CallFunction_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.functions.v1.CallFunctionRequest;
import com.google.cloud.functions.v1.CallFunctionResponse;
import com.google.cloud.functions.v1.CloudFunctionName;
import com.google.cloud.functions.v1.CloudFunctionsServiceClient;

public class AsyncCallFunction {

  public static void main(String[] args) throws Exception {
    asyncCallFunction();
  }

  public static void asyncCallFunction() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (CloudFunctionsServiceClient cloudFunctionsServiceClient =
        CloudFunctionsServiceClient.create()) {
      CallFunctionRequest request =
          CallFunctionRequest.newBuilder()
              .setName(CloudFunctionName.of("[PROJECT]", "[LOCATION]", "[FUNCTION]").toString())
              .setData("data3076010")
              .build();
      ApiFuture<CallFunctionResponse> future =
          cloudFunctionsServiceClient.callFunctionCallable().futureCall(request);
      // Do something.
      CallFunctionResponse response = future.get();
    }
  }
}
// [END cloudfunctions_v1_generated_CloudFunctionsService_CallFunction_async]
