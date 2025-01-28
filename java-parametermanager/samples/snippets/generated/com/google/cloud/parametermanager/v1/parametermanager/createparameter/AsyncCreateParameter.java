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

package com.google.cloud.parametermanager.v1.samples;

// [START parametermanager_v1_generated_ParameterManager_CreateParameter_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.parametermanager.v1.CreateParameterRequest;
import com.google.cloud.parametermanager.v1.LocationName;
import com.google.cloud.parametermanager.v1.Parameter;
import com.google.cloud.parametermanager.v1.ParameterManagerClient;

public class AsyncCreateParameter {

  public static void main(String[] args) throws Exception {
    asyncCreateParameter();
  }

  public static void asyncCreateParameter() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (ParameterManagerClient parameterManagerClient = ParameterManagerClient.create()) {
      CreateParameterRequest request =
          CreateParameterRequest.newBuilder()
              .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
              .setParameterId("parameterId1335916196")
              .setParameter(Parameter.newBuilder().build())
              .setRequestId("requestId693933066")
              .build();
      ApiFuture<Parameter> future =
          parameterManagerClient.createParameterCallable().futureCall(request);
      // Do something.
      Parameter response = future.get();
    }
  }
}
// [END parametermanager_v1_generated_ParameterManager_CreateParameter_async]
