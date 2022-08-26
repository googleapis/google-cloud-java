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

package com.google.cloud.run.v2.samples;

// [START run_v2_generated_servicesclient_updateservice_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.run.v2.Service;
import com.google.cloud.run.v2.ServicesClient;
import com.google.cloud.run.v2.UpdateServiceRequest;
import com.google.longrunning.Operation;

public class AsyncUpdateService {

  public static void main(String[] args) throws Exception {
    asyncUpdateService();
  }

  public static void asyncUpdateService() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    try (ServicesClient servicesClient = ServicesClient.create()) {
      UpdateServiceRequest request =
          UpdateServiceRequest.newBuilder()
              .setService(Service.newBuilder().build())
              .setValidateOnly(true)
              .setAllowMissing(true)
              .build();
      ApiFuture<Operation> future = servicesClient.updateServiceCallable().futureCall(request);
      // Do something.
      Operation response = future.get();
    }
  }
}
// [END run_v2_generated_servicesclient_updateservice_async]
