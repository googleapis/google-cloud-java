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

package com.google.cloud.vmwareengine.v1.samples;

// [START vmwareengine_v1_generated_VmwareEngine_DeleteExternalAddress_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.vmwareengine.v1.DeleteExternalAddressRequest;
import com.google.cloud.vmwareengine.v1.ExternalAddressName;
import com.google.cloud.vmwareengine.v1.VmwareEngineClient;
import com.google.longrunning.Operation;

public class AsyncDeleteExternalAddress {

  public static void main(String[] args) throws Exception {
    asyncDeleteExternalAddress();
  }

  public static void asyncDeleteExternalAddress() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
      DeleteExternalAddressRequest request =
          DeleteExternalAddressRequest.newBuilder()
              .setName(
                  ExternalAddressName.of(
                          "[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[EXTERNAL_ADDRESS]")
                      .toString())
              .setRequestId("requestId693933066")
              .build();
      ApiFuture<Operation> future =
          vmwareEngineClient.deleteExternalAddressCallable().futureCall(request);
      // Do something.
      future.get();
    }
  }
}
// [END vmwareengine_v1_generated_VmwareEngine_DeleteExternalAddress_async]
