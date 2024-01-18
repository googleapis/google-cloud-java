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

package com.google.cloud.enterpriseknowledgegraph.v1.samples;

// [START enterpriseknowledgegraph_v1_generated_EnterpriseKnowledgeGraphService_Search_sync]
import com.google.cloud.enterpriseknowledgegraph.v1.EnterpriseKnowledgeGraphServiceClient;
import com.google.cloud.enterpriseknowledgegraph.v1.LocationName;
import com.google.cloud.enterpriseknowledgegraph.v1.SearchRequest;
import com.google.cloud.enterpriseknowledgegraph.v1.SearchResponse;
import com.google.protobuf.Int32Value;
import java.util.ArrayList;

public class SyncSearch {

  public static void main(String[] args) throws Exception {
    syncSearch();
  }

  public static void syncSearch() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (EnterpriseKnowledgeGraphServiceClient enterpriseKnowledgeGraphServiceClient =
        EnterpriseKnowledgeGraphServiceClient.create()) {
      SearchRequest request =
          SearchRequest.newBuilder()
              .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
              .setQuery("query107944136")
              .addAllLanguages(new ArrayList<String>())
              .addAllTypes(new ArrayList<String>())
              .setLimit(Int32Value.newBuilder().build())
              .build();
      SearchResponse response = enterpriseKnowledgeGraphServiceClient.search(request);
    }
  }
}
// [END enterpriseknowledgegraph_v1_generated_EnterpriseKnowledgeGraphService_Search_sync]
