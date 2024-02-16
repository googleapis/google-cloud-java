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

package com.google.api.cloudquotas.v1.samples;

// [START cloudquotas_v1_generated_CloudQuotas_UpdateQuotaPreference_sync]
import com.google.api.cloudquotas.v1.CloudQuotasClient;
import com.google.api.cloudquotas.v1.QuotaPreference;
import com.google.api.cloudquotas.v1.QuotaSafetyCheck;
import com.google.api.cloudquotas.v1.UpdateQuotaPreferenceRequest;
import com.google.protobuf.FieldMask;
import java.util.ArrayList;

public class SyncUpdateQuotaPreference {

  public static void main(String[] args) throws Exception {
    syncUpdateQuotaPreference();
  }

  public static void syncUpdateQuotaPreference() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (CloudQuotasClient cloudQuotasClient = CloudQuotasClient.create()) {
      UpdateQuotaPreferenceRequest request =
          UpdateQuotaPreferenceRequest.newBuilder()
              .setUpdateMask(FieldMask.newBuilder().build())
              .setQuotaPreference(QuotaPreference.newBuilder().build())
              .setAllowMissing(true)
              .setValidateOnly(true)
              .addAllIgnoreSafetyChecks(new ArrayList<QuotaSafetyCheck>())
              .build();
      QuotaPreference response = cloudQuotasClient.updateQuotaPreference(request);
    }
  }
}
// [END cloudquotas_v1_generated_CloudQuotas_UpdateQuotaPreference_sync]
