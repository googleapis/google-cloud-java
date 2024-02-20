/*
 * Copyright 2024 Google LLC
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

package com.google.api.serviceusage.v1beta1.samples;

// [START serviceusage_v1beta1_generated_ServiceUsage_UpdateAdminOverride_LRO_async]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.serviceusage.v1beta1.OperationMetadata;
import com.google.api.serviceusage.v1beta1.QuotaOverride;
import com.google.api.serviceusage.v1beta1.QuotaSafetyCheck;
import com.google.api.serviceusage.v1beta1.ServiceUsageClient;
import com.google.api.serviceusage.v1beta1.UpdateAdminOverrideRequest;
import com.google.protobuf.FieldMask;
import java.util.ArrayList;

public class AsyncUpdateAdminOverrideLRO {

  public static void main(String[] args) throws Exception {
    asyncUpdateAdminOverrideLRO();
  }

  public static void asyncUpdateAdminOverrideLRO() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (ServiceUsageClient serviceUsageClient = ServiceUsageClient.create()) {
      UpdateAdminOverrideRequest request =
          UpdateAdminOverrideRequest.newBuilder()
              .setName("name3373707")
              .setOverride(QuotaOverride.newBuilder().build())
              .setForce(true)
              .setUpdateMask(FieldMask.newBuilder().build())
              .addAllForceOnly(new ArrayList<QuotaSafetyCheck>())
              .build();
      OperationFuture<QuotaOverride, OperationMetadata> future =
          serviceUsageClient.updateAdminOverrideOperationCallable().futureCall(request);
      // Do something.
      QuotaOverride response = future.get();
    }
  }
}
// [END serviceusage_v1beta1_generated_ServiceUsage_UpdateAdminOverride_LRO_async]
