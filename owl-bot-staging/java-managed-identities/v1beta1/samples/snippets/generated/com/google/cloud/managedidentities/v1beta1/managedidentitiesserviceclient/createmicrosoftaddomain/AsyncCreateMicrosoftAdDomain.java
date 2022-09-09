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

package com.google.cloud.managedidentities.v1beta1.samples;

// [START managedidentities_v1beta1_generated_managedidentitiesserviceclient_createmicrosoftaddomain_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.managedidentities.v1beta1.CreateMicrosoftAdDomainRequest;
import com.google.cloud.managedidentities.v1beta1.Domain;
import com.google.cloud.managedidentities.v1beta1.LocationName;
import com.google.cloud.managedidentities.v1beta1.ManagedIdentitiesServiceClient;
import com.google.longrunning.Operation;

public class AsyncCreateMicrosoftAdDomain {

  public static void main(String[] args) throws Exception {
    asyncCreateMicrosoftAdDomain();
  }

  public static void asyncCreateMicrosoftAdDomain() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (ManagedIdentitiesServiceClient managedIdentitiesServiceClient =
        ManagedIdentitiesServiceClient.create()) {
      CreateMicrosoftAdDomainRequest request =
          CreateMicrosoftAdDomainRequest.newBuilder()
              .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
              .setDomainName("domainName-1244085905")
              .setDomain(Domain.newBuilder().build())
              .build();
      ApiFuture<Operation> future =
          managedIdentitiesServiceClient.createMicrosoftAdDomainCallable().futureCall(request);
      // Do something.
      Operation response = future.get();
    }
  }
}
// [END managedidentities_v1beta1_generated_managedidentitiesserviceclient_createmicrosoftaddomain_async]
