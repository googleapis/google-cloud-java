/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.dataplex.v1.samples;

// [START dataplex_v1_generated_CatalogService_CreateMetadataJob_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.dataplex.v1.CatalogServiceClient;
import com.google.cloud.dataplex.v1.CreateMetadataJobRequest;
import com.google.cloud.dataplex.v1.LocationName;
import com.google.cloud.dataplex.v1.MetadataJob;
import com.google.longrunning.Operation;

public class AsyncCreateMetadataJob {

  public static void main(String[] args) throws Exception {
    asyncCreateMetadataJob();
  }

  public static void asyncCreateMetadataJob() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
      CreateMetadataJobRequest request =
          CreateMetadataJobRequest.newBuilder()
              .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
              .setMetadataJob(MetadataJob.newBuilder().build())
              .setMetadataJobId("metadataJobId-2021530679")
              .setValidateOnly(true)
              .build();
      ApiFuture<Operation> future =
          catalogServiceClient.createMetadataJobCallable().futureCall(request);
      // Do something.
      Operation response = future.get();
    }
  }
}
// [END dataplex_v1_generated_CatalogService_CreateMetadataJob_async]
