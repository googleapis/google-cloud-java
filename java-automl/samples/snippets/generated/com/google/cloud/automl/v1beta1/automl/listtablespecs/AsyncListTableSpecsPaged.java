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

package com.google.cloud.automl.v1beta1.samples;

// [START automl_v1beta1_generated_AutoMl_ListTableSpecs_Paged_async]
import com.google.cloud.automl.v1beta1.AutoMlClient;
import com.google.cloud.automl.v1beta1.DatasetName;
import com.google.cloud.automl.v1beta1.ListTableSpecsRequest;
import com.google.cloud.automl.v1beta1.ListTableSpecsResponse;
import com.google.cloud.automl.v1beta1.TableSpec;
import com.google.common.base.Strings;
import com.google.protobuf.FieldMask;

public class AsyncListTableSpecsPaged {

  public static void main(String[] args) throws Exception {
    asyncListTableSpecsPaged();
  }

  public static void asyncListTableSpecsPaged() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (AutoMlClient autoMlClient = AutoMlClient.create()) {
      ListTableSpecsRequest request =
          ListTableSpecsRequest.newBuilder()
              .setParent(DatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]").toString())
              .setFieldMask(FieldMask.newBuilder().build())
              .setFilter("filter-1274492040")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      while (true) {
        ListTableSpecsResponse response = autoMlClient.listTableSpecsCallable().call(request);
        for (TableSpec element : response.getTableSpecsList()) {
          // doThingsWith(element);
        }
        String nextPageToken = response.getNextPageToken();
        if (!Strings.isNullOrEmpty(nextPageToken)) {
          request = request.toBuilder().setPageToken(nextPageToken).build();
        } else {
          break;
        }
      }
    }
  }
}
// [END automl_v1beta1_generated_AutoMl_ListTableSpecs_Paged_async]
