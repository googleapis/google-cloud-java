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

package com.google.cloud.tpu.v1.samples;

// [START tpu_v1_generated_tpuclient_getacceleratortype_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.tpu.v1.AcceleratorType;
import com.google.cloud.tpu.v1.AcceleratorTypeName;
import com.google.cloud.tpu.v1.GetAcceleratorTypeRequest;
import com.google.cloud.tpu.v1.TpuClient;

public class AsyncGetAcceleratorType {

  public static void main(String[] args) throws Exception {
    asyncGetAcceleratorType();
  }

  public static void asyncGetAcceleratorType() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (TpuClient tpuClient = TpuClient.create()) {
      GetAcceleratorTypeRequest request =
          GetAcceleratorTypeRequest.newBuilder()
              .setName(
                  AcceleratorTypeName.of("[PROJECT]", "[LOCATION]", "[ACCELERATOR_TYPE]")
                      .toString())
              .build();
      ApiFuture<AcceleratorType> future =
          tpuClient.getAcceleratorTypeCallable().futureCall(request);
      // Do something.
      AcceleratorType response = future.get();
    }
  }
}
// [END tpu_v1_generated_tpuclient_getacceleratortype_async]
