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

package com.google.cloud.saasplatform.saasservicemgmt.v1beta1.samples;

// [START saasservicemgmt_v1beta1_generated_SaasDeployments_UpdateUnitKind_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasDeploymentsClient;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UnitKind;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateUnitKindRequest;
import com.google.protobuf.FieldMask;

public class AsyncUpdateUnitKind {

  public static void main(String[] args) throws Exception {
    asyncUpdateUnitKind();
  }

  public static void asyncUpdateUnitKind() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
      UpdateUnitKindRequest request =
          UpdateUnitKindRequest.newBuilder()
              .setUnitKind(UnitKind.newBuilder().build())
              .setValidateOnly(true)
              .setRequestId("requestId693933066")
              .setUpdateMask(FieldMask.newBuilder().build())
              .build();
      ApiFuture<UnitKind> future =
          saasDeploymentsClient.updateUnitKindCallable().futureCall(request);
      // Do something.
      UnitKind response = future.get();
    }
  }
}
// [END saasservicemgmt_v1beta1_generated_SaasDeployments_UpdateUnitKind_async]
