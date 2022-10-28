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

package com.google.cloud.talent.v4beta1.samples;

// [START jobs_v4beta1_generated_completionclient_completequery_sync]
import com.google.cloud.talent.v4beta1.CompanyName;
import com.google.cloud.talent.v4beta1.CompleteQueryRequest;
import com.google.cloud.talent.v4beta1.CompleteQueryResponse;
import com.google.cloud.talent.v4beta1.CompletionClient;
import com.google.cloud.talent.v4beta1.TenantName;
import java.util.ArrayList;

public class SyncCompleteQuery {

  public static void main(String[] args) throws Exception {
    syncCompleteQuery();
  }

  public static void syncCompleteQuery() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (CompletionClient completionClient = CompletionClient.create()) {
      CompleteQueryRequest request =
          CompleteQueryRequest.newBuilder()
              .setParent(TenantName.of("[PROJECT]", "[TENANT]").toString())
              .setQuery("query107944136")
              .addAllLanguageCodes(new ArrayList<String>())
              .setPageSize(883849137)
              .setCompany(
                  CompanyName.ofProjectTenantCompanyName("[PROJECT]", "[TENANT]", "[COMPANY]")
                      .toString())
              .build();
      CompleteQueryResponse response = completionClient.completeQuery(request);
    }
  }
}
// [END jobs_v4beta1_generated_completionclient_completequery_sync]
