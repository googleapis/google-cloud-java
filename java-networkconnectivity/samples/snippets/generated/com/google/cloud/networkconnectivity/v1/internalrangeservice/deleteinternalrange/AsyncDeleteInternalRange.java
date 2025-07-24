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

package com.google.cloud.networkconnectivity.v1.samples;

// [START networkconnectivity_v1_generated_InternalRangeService_DeleteInternalRange_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.networkconnectivity.v1.DeleteInternalRangeRequest;
import com.google.cloud.networkconnectivity.v1.InternalRangeName;
import com.google.cloud.networkconnectivity.v1.InternalRangeServiceClient;
import com.google.longrunning.Operation;

public class AsyncDeleteInternalRange {

  public static void main(String[] args) throws Exception {
    asyncDeleteInternalRange();
  }

  public static void asyncDeleteInternalRange() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (InternalRangeServiceClient internalRangeServiceClient =
        InternalRangeServiceClient.create()) {
      DeleteInternalRangeRequest request =
          DeleteInternalRangeRequest.newBuilder()
              .setName(
                  InternalRangeName.of("[PROJECT]", "[LOCATION]", "[INTERNAL_RANGE]").toString())
              .setRequestId("requestId693933066")
              .build();
      ApiFuture<Operation> future =
          internalRangeServiceClient.deleteInternalRangeCallable().futureCall(request);
      // Do something.
      future.get();
    }
  }
}
// [END networkconnectivity_v1_generated_InternalRangeService_DeleteInternalRange_async]
