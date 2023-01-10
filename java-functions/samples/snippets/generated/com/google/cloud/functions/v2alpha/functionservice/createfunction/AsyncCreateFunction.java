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

package com.google.cloud.functions.v2alpha.samples;

// [START cloudfunctions_v2alpha_generated_FunctionService_CreateFunction_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.functions.v2alpha.CreateFunctionRequest;
import com.google.cloud.functions.v2alpha.Function;
import com.google.cloud.functions.v2alpha.FunctionServiceClient;
import com.google.cloud.functions.v2alpha.LocationName;
import com.google.longrunning.Operation;

public class AsyncCreateFunction {

  public static void main(String[] args) throws Exception {
    asyncCreateFunction();
  }

  public static void asyncCreateFunction() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (FunctionServiceClient functionServiceClient = FunctionServiceClient.create()) {
      CreateFunctionRequest request =
          CreateFunctionRequest.newBuilder()
              .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
              .setFunction(Function.newBuilder().build())
              .setFunctionId("functionId-62789869")
              .build();
      ApiFuture<Operation> future =
          functionServiceClient.createFunctionCallable().futureCall(request);
      // Do something.
      Operation response = future.get();
    }
  }
}
// [END cloudfunctions_v2alpha_generated_FunctionService_CreateFunction_async]
