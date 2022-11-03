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

package com.google.cloud.phishingprotection.v1beta1.samples;

// [START phishingprotection_v1beta1_generated_PhishingProtectionServiceV1Beta1_ReportPhishing_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.phishingprotection.v1beta1.PhishingProtectionServiceV1Beta1Client;
import com.google.phishingprotection.v1beta1.ProjectName;
import com.google.phishingprotection.v1beta1.ReportPhishingRequest;
import com.google.phishingprotection.v1beta1.ReportPhishingResponse;

public class AsyncReportPhishing {

  public static void main(String[] args) throws Exception {
    asyncReportPhishing();
  }

  public static void asyncReportPhishing() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (PhishingProtectionServiceV1Beta1Client phishingProtectionServiceV1Beta1Client =
        PhishingProtectionServiceV1Beta1Client.create()) {
      ReportPhishingRequest request =
          ReportPhishingRequest.newBuilder()
              .setParent(ProjectName.of("[PROJECT]").toString())
              .setUri("uri116076")
              .build();
      ApiFuture<ReportPhishingResponse> future =
          phishingProtectionServiceV1Beta1Client.reportPhishingCallable().futureCall(request);
      // Do something.
      ReportPhishingResponse response = future.get();
    }
  }
}
// [END phishingprotection_v1beta1_generated_PhishingProtectionServiceV1Beta1_ReportPhishing_async]
