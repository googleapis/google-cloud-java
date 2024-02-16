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

package com.google.cloud.metastore.v1beta.samples;

// [START metastore_v1beta_generated_DataprocMetastoreFederation_CreateFederation_sync]
import com.google.cloud.metastore.v1beta.CreateFederationRequest;
import com.google.cloud.metastore.v1beta.DataprocMetastoreFederationClient;
import com.google.cloud.metastore.v1beta.Federation;
import com.google.cloud.metastore.v1beta.LocationName;

public class SyncCreateFederation {

  public static void main(String[] args) throws Exception {
    syncCreateFederation();
  }

  public static void syncCreateFederation() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (DataprocMetastoreFederationClient dataprocMetastoreFederationClient =
        DataprocMetastoreFederationClient.create()) {
      CreateFederationRequest request =
          CreateFederationRequest.newBuilder()
              .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
              .setFederationId("federationId-735921218")
              .setFederation(Federation.newBuilder().build())
              .setRequestId("requestId693933066")
              .build();
      Federation response = dataprocMetastoreFederationClient.createFederationAsync(request).get();
    }
  }
}
// [END metastore_v1beta_generated_DataprocMetastoreFederation_CreateFederation_sync]
