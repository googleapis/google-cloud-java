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

package com.google.cloud.aiplatform.v1.samples;

// [START aiplatform_v1_generated_DatasetService_SearchDataItems_sync]
import com.google.cloud.aiplatform.v1.DataItemView;
import com.google.cloud.aiplatform.v1.DatasetName;
import com.google.cloud.aiplatform.v1.DatasetServiceClient;
import com.google.cloud.aiplatform.v1.SavedQueryName;
import com.google.cloud.aiplatform.v1.SearchDataItemsRequest;
import com.google.protobuf.FieldMask;
import java.util.ArrayList;

public class SyncSearchDataItems {

  public static void main(String[] args) throws Exception {
    syncSearchDataItems();
  }

  public static void syncSearchDataItems() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (DatasetServiceClient datasetServiceClient = DatasetServiceClient.create()) {
      SearchDataItemsRequest request =
          SearchDataItemsRequest.newBuilder()
              .setDataset(DatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]").toString())
              .setSavedQuery(
                  SavedQueryName.of("[PROJECT]", "[LOCATION]", "[DATASET]", "[SAVED_QUERY]")
                      .toString())
              .setDataLabelingJob("dataLabelingJob951814757")
              .setDataItemFilter("dataItemFilter1487804341")
              .setAnnotationsFilter("annotationsFilter-583841860")
              .addAllAnnotationFilters(new ArrayList<String>())
              .setFieldMask(FieldMask.newBuilder().build())
              .setAnnotationsLimit(134561504)
              .setPageSize(883849137)
              .setOrderBy("orderBy-1207110587")
              .setPageToken("pageToken873572522")
              .build();
      for (DataItemView element : datasetServiceClient.searchDataItems(request).iterateAll()) {
        // doThingsWith(element);
      }
    }
  }
}
// [END aiplatform_v1_generated_DatasetService_SearchDataItems_sync]
