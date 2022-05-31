/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.jobs;

// [START job_search_autocomplete_job_title]

import com.google.cloud.talent.v4.CompleteQueryRequest;
import com.google.cloud.talent.v4.CompleteQueryResponse;
import com.google.cloud.talent.v4.CompletionClient;
import com.google.cloud.talent.v4.TenantName;
import java.io.IOException;

public class JobSearchAutoCompleteJobTitle {

  public static void completeQuery() throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "your-project-id";
    String tenantId = "your-tenant-id";
    String query = "your-query-for-job-title";
    completeQuery(projectId, tenantId, query);
  }

  // Complete job title given partial text (autocomplete).
  public static void completeQuery(String projectId, String tenantId, String query)
      throws IOException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (CompletionClient completionClient = CompletionClient.create()) {
      TenantName parent = TenantName.of(projectId, tenantId);
      CompleteQueryRequest request =
          CompleteQueryRequest.newBuilder()
              .setTenant(parent.toString())
              .setQuery(query)
              .setPageSize(5) // limit for number of results
              .addLanguageCodes("en-US") // language code
              .build();
      CompleteQueryResponse response = completionClient.completeQuery(request);
      for (CompleteQueryResponse.CompletionResult result : response.getCompletionResultsList()) {
        System.out.format("Suggested title: %s%n", result.getSuggestion());
        // Suggestion type is JOB_TITLE or COMPANY_TITLE
        System.out.format("Suggestion type: %s%n", result.getType());
      }
    }
  }
}
// [END job_search_autocomplete_job_title]
