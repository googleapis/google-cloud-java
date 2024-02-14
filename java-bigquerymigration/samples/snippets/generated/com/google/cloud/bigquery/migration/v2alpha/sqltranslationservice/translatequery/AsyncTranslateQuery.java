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

package com.google.cloud.bigquery.migration.v2alpha.samples;

// [START bigquerymigration_v2alpha_generated_SqlTranslationService_TranslateQuery_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.bigquery.migration.v2alpha.LocationName;
import com.google.cloud.bigquery.migration.v2alpha.SqlTranslationServiceClient;
import com.google.cloud.bigquery.migration.v2alpha.TranslateQueryRequest;
import com.google.cloud.bigquery.migration.v2alpha.TranslateQueryResponse;

public class AsyncTranslateQuery {

  public static void main(String[] args) throws Exception {
    asyncTranslateQuery();
  }

  public static void asyncTranslateQuery() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (SqlTranslationServiceClient sqlTranslationServiceClient =
        SqlTranslationServiceClient.create()) {
      TranslateQueryRequest request =
          TranslateQueryRequest.newBuilder()
              .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
              .setQuery("query107944136")
              .build();
      ApiFuture<TranslateQueryResponse> future =
          sqlTranslationServiceClient.translateQueryCallable().futureCall(request);
      // Do something.
      TranslateQueryResponse response = future.get();
    }
  }
}
// [END bigquerymigration_v2alpha_generated_SqlTranslationService_TranslateQuery_async]
