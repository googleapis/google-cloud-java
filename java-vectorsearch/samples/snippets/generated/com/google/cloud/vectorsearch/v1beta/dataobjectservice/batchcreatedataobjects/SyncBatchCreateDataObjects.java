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

package com.google.cloud.vectorsearch.v1beta.samples;

// [START vectorsearch_v1beta_generated_DataObjectService_BatchCreateDataObjects_sync]
import com.google.cloud.vectorsearch.v1beta.BatchCreateDataObjectsRequest;
import com.google.cloud.vectorsearch.v1beta.BatchCreateDataObjectsResponse;
import com.google.cloud.vectorsearch.v1beta.CollectionName;
import com.google.cloud.vectorsearch.v1beta.CreateDataObjectRequest;
import com.google.cloud.vectorsearch.v1beta.DataObjectServiceClient;
import java.util.ArrayList;

public class SyncBatchCreateDataObjects {

  public static void main(String[] args) throws Exception {
    syncBatchCreateDataObjects();
  }

  public static void syncBatchCreateDataObjects() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (DataObjectServiceClient dataObjectServiceClient = DataObjectServiceClient.create()) {
      BatchCreateDataObjectsRequest request =
          BatchCreateDataObjectsRequest.newBuilder()
              .setParent(CollectionName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]").toString())
              .addAllRequests(new ArrayList<CreateDataObjectRequest>())
              .build();
      BatchCreateDataObjectsResponse response =
          dataObjectServiceClient.batchCreateDataObjects(request);
    }
  }
}
// [END vectorsearch_v1beta_generated_DataObjectService_BatchCreateDataObjects_sync]
