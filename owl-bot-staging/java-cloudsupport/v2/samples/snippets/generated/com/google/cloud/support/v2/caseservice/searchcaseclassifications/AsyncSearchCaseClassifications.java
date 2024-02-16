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

package com.google.cloud.support.v2.samples;

// [START cloudsupport_v2_generated_CaseService_SearchCaseClassifications_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.support.v2.CaseClassification;
import com.google.cloud.support.v2.CaseServiceClient;
import com.google.cloud.support.v2.SearchCaseClassificationsRequest;

public class AsyncSearchCaseClassifications {

  public static void main(String[] args) throws Exception {
    asyncSearchCaseClassifications();
  }

  public static void asyncSearchCaseClassifications() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (CaseServiceClient caseServiceClient = CaseServiceClient.create()) {
      SearchCaseClassificationsRequest request =
          SearchCaseClassificationsRequest.newBuilder()
              .setQuery("query107944136")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      ApiFuture<CaseClassification> future =
          caseServiceClient.searchCaseClassificationsPagedCallable().futureCall(request);
      // Do something.
      for (CaseClassification element : future.get().iterateAll()) {
        // doThingsWith(element);
      }
    }
  }
}
// [END cloudsupport_v2_generated_CaseService_SearchCaseClassifications_async]
