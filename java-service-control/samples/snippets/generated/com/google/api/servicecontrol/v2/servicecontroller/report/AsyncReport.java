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

package com.google.api.servicecontrol.v2.samples;

// [START servicecontrol_v2_generated_ServiceController_Report_async]
import com.google.api.core.ApiFuture;
import com.google.api.servicecontrol.v2.ReportRequest;
import com.google.api.servicecontrol.v2.ReportResponse;
import com.google.api.servicecontrol.v2.ServiceControllerClient;
import com.google.rpc.context.AttributeContext;
import java.util.ArrayList;

public class AsyncReport {

  public static void main(String[] args) throws Exception {
    asyncReport();
  }

  public static void asyncReport() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (ServiceControllerClient serviceControllerClient = ServiceControllerClient.create()) {
      ReportRequest request =
          ReportRequest.newBuilder()
              .setServiceName("serviceName-1928572192")
              .setServiceConfigId("serviceConfigId650537426")
              .addAllOperations(new ArrayList<AttributeContext>())
              .build();
      ApiFuture<ReportResponse> future =
          serviceControllerClient.reportCallable().futureCall(request);
      // Do something.
      ReportResponse response = future.get();
    }
  }
}
// [END servicecontrol_v2_generated_ServiceController_Report_async]
