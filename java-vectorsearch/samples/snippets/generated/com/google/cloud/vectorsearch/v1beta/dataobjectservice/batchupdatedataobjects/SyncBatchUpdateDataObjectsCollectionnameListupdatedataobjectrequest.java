/*
 * Copyright 2026 Google LLC
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

// [START vectorsearch_v1beta_generated_DataObjectService_BatchUpdateDataObjects_CollectionnameListupdatedataobjectrequest_sync]
import com.google.cloud.vectorsearch.v1beta.BatchUpdateDataObjectsResponse;
import com.google.cloud.vectorsearch.v1beta.CollectionName;
import com.google.cloud.vectorsearch.v1beta.DataObjectServiceClient;
import com.google.cloud.vectorsearch.v1beta.UpdateDataObjectRequest;
import java.util.ArrayList;
import java.util.List;

public class SyncBatchUpdateDataObjectsCollectionnameListupdatedataobjectrequest {

  public static void main(String[] args) throws Exception {
    syncBatchUpdateDataObjectsCollectionnameListupdatedataobjectrequest();
  }

  public static void syncBatchUpdateDataObjectsCollectionnameListupdatedataobjectrequest()
      throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (DataObjectServiceClient dataObjectServiceClient = DataObjectServiceClient.create()) {
      CollectionName parent = CollectionName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]");
      List<UpdateDataObjectRequest> requests = new ArrayList<>();
      BatchUpdateDataObjectsResponse response =
          dataObjectServiceClient.batchUpdateDataObjects(parent, requests);
    }
  }
}
// [END vectorsearch_v1beta_generated_DataObjectService_BatchUpdateDataObjects_CollectionnameListupdatedataobjectrequest_sync]
