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

package com.google.cloud.functions.v2.samples;

// [START cloudfunctions_v2_generated_functionserviceclient_deletefunction_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.functions.v2.DeleteFunctionRequest;
import com.google.cloud.functions.v2.FunctionName;
import com.google.cloud.functions.v2.FunctionServiceClient;
import com.google.longrunning.Operation;

public class AsyncDeleteFunction {

  public static void main(String[] args) throws Exception {
    asyncDeleteFunction();
  }

  public static void asyncDeleteFunction() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (FunctionServiceClient functionServiceClient = FunctionServiceClient.create()) {
      DeleteFunctionRequest request =
          DeleteFunctionRequest.newBuilder()
              .setName(FunctionName.of("[PROJECT]", "[LOCATION]", "[FUNCTION]").toString())
              .build();
      ApiFuture<Operation> future =
          functionServiceClient.deleteFunctionCallable().futureCall(request);
      // Do something.
      future.get();
    }
  }
}
// [END cloudfunctions_v2_generated_functionserviceclient_deletefunction_async]
