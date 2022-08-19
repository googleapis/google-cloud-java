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

package com.google.cloud.servicedirectory.v1beta1.samples;

// [START servicedirectory_v1beta1_generated_lookupserviceclient_resolveservice_sync]
import com.google.cloud.servicedirectory.v1beta1.LookupServiceClient;
import com.google.cloud.servicedirectory.v1beta1.ResolveServiceRequest;
import com.google.cloud.servicedirectory.v1beta1.ResolveServiceResponse;
import com.google.cloud.servicedirectory.v1beta1.ServiceName;

public class SyncResolveService {

  public static void main(String[] args) throws Exception {
    syncResolveService();
  }

  public static void syncResolveService() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    try (LookupServiceClient lookupServiceClient = LookupServiceClient.create()) {
      ResolveServiceRequest request =
          ResolveServiceRequest.newBuilder()
              .setName(
                  ServiceName.of("[PROJECT]", "[LOCATION]", "[NAMESPACE]", "[SERVICE]").toString())
              .setMaxEndpoints(2074789987)
              .setEndpointFilter("endpointFilter-1834249875")
              .build();
      ResolveServiceResponse response = lookupServiceClient.resolveService(request);
    }
  }
}
// [END servicedirectory_v1beta1_generated_lookupserviceclient_resolveservice_sync]
