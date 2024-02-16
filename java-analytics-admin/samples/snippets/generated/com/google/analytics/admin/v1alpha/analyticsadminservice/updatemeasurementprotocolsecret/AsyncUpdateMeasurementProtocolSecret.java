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

package com.google.analytics.admin.v1alpha.samples;

// [START analyticsadmin_v1alpha_generated_AnalyticsAdminService_UpdateMeasurementProtocolSecret_async]
import com.google.analytics.admin.v1alpha.AnalyticsAdminServiceClient;
import com.google.analytics.admin.v1alpha.MeasurementProtocolSecret;
import com.google.analytics.admin.v1alpha.UpdateMeasurementProtocolSecretRequest;
import com.google.api.core.ApiFuture;
import com.google.protobuf.FieldMask;

public class AsyncUpdateMeasurementProtocolSecret {

  public static void main(String[] args) throws Exception {
    asyncUpdateMeasurementProtocolSecret();
  }

  public static void asyncUpdateMeasurementProtocolSecret() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (AnalyticsAdminServiceClient analyticsAdminServiceClient =
        AnalyticsAdminServiceClient.create()) {
      UpdateMeasurementProtocolSecretRequest request =
          UpdateMeasurementProtocolSecretRequest.newBuilder()
              .setMeasurementProtocolSecret(MeasurementProtocolSecret.newBuilder().build())
              .setUpdateMask(FieldMask.newBuilder().build())
              .build();
      ApiFuture<MeasurementProtocolSecret> future =
          analyticsAdminServiceClient.updateMeasurementProtocolSecretCallable().futureCall(request);
      // Do something.
      MeasurementProtocolSecret response = future.get();
    }
  }
}
// [END analyticsadmin_v1alpha_generated_AnalyticsAdminService_UpdateMeasurementProtocolSecret_async]
