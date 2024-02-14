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

package com.google.cloud.bigquery.datatransfer.v1.samples;

// [START bigquerydatatransfer_v1_generated_DataTransferService_UnenrollDataSources_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.bigquery.datatransfer.v1.DataTransferServiceClient;
import com.google.cloud.bigquery.datatransfer.v1.UnenrollDataSourcesRequest;
import com.google.protobuf.Empty;
import java.util.ArrayList;

public class AsyncUnenrollDataSources {

  public static void main(String[] args) throws Exception {
    asyncUnenrollDataSources();
  }

  public static void asyncUnenrollDataSources() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
      UnenrollDataSourcesRequest request =
          UnenrollDataSourcesRequest.newBuilder()
              .setName("name3373707")
              .addAllDataSourceIds(new ArrayList<String>())
              .build();
      ApiFuture<Empty> future =
          dataTransferServiceClient.unenrollDataSourcesCallable().futureCall(request);
      // Do something.
      future.get();
    }
  }
}
// [END bigquerydatatransfer_v1_generated_DataTransferService_UnenrollDataSources_async]
