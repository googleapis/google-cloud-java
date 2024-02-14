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

package com.google.cloud.bigquery.datatransfer.v1.samples;

// [START bigquerydatatransfer_v1_generated_DataTransferService_UpdateTransferConfig_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.bigquery.datatransfer.v1.DataTransferServiceClient;
import com.google.cloud.bigquery.datatransfer.v1.TransferConfig;
import com.google.cloud.bigquery.datatransfer.v1.UpdateTransferConfigRequest;
import com.google.protobuf.FieldMask;

public class AsyncUpdateTransferConfig {

  public static void main(String[] args) throws Exception {
    asyncUpdateTransferConfig();
  }

  public static void asyncUpdateTransferConfig() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
      UpdateTransferConfigRequest request =
          UpdateTransferConfigRequest.newBuilder()
              .setTransferConfig(TransferConfig.newBuilder().build())
              .setAuthorizationCode("authorizationCode742596102")
              .setUpdateMask(FieldMask.newBuilder().build())
              .setVersionInfo("versionInfo688769446")
              .setServiceAccountName("serviceAccountName2137368675")
              .build();
      ApiFuture<TransferConfig> future =
          dataTransferServiceClient.updateTransferConfigCallable().futureCall(request);
      // Do something.
      TransferConfig response = future.get();
    }
  }
}
// [END bigquerydatatransfer_v1_generated_DataTransferService_UpdateTransferConfig_async]
