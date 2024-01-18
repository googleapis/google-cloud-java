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

package com.google.cloud.bigquery.datapolicies.v1.samples;

// [START bigquerydatapolicy_v1_generated_DataPolicyService_RenameDataPolicy_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.bigquery.datapolicies.v1.DataPolicy;
import com.google.cloud.bigquery.datapolicies.v1.DataPolicyServiceClient;
import com.google.cloud.bigquery.datapolicies.v1.RenameDataPolicyRequest;

public class AsyncRenameDataPolicy {

  public static void main(String[] args) throws Exception {
    asyncRenameDataPolicy();
  }

  public static void asyncRenameDataPolicy() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (DataPolicyServiceClient dataPolicyServiceClient = DataPolicyServiceClient.create()) {
      RenameDataPolicyRequest request =
          RenameDataPolicyRequest.newBuilder()
              .setName("name3373707")
              .setNewDataPolicyId("newDataPolicyId288407927")
              .build();
      ApiFuture<DataPolicy> future =
          dataPolicyServiceClient.renameDataPolicyCallable().futureCall(request);
      // Do something.
      DataPolicy response = future.get();
    }
  }
}
// [END bigquerydatapolicy_v1_generated_DataPolicyService_RenameDataPolicy_async]
