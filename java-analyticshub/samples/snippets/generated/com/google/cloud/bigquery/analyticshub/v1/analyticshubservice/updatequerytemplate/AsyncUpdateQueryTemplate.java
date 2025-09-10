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

package com.google.cloud.bigquery.analyticshub.v1.samples;

// [START analyticshub_v1_generated_AnalyticsHubService_UpdateQueryTemplate_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.bigquery.analyticshub.v1.AnalyticsHubServiceClient;
import com.google.cloud.bigquery.analyticshub.v1.QueryTemplate;
import com.google.cloud.bigquery.analyticshub.v1.UpdateQueryTemplateRequest;
import com.google.protobuf.FieldMask;

public class AsyncUpdateQueryTemplate {

  public static void main(String[] args) throws Exception {
    asyncUpdateQueryTemplate();
  }

  public static void asyncUpdateQueryTemplate() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (AnalyticsHubServiceClient analyticsHubServiceClient = AnalyticsHubServiceClient.create()) {
      UpdateQueryTemplateRequest request =
          UpdateQueryTemplateRequest.newBuilder()
              .setUpdateMask(FieldMask.newBuilder().build())
              .setQueryTemplate(QueryTemplate.newBuilder().build())
              .build();
      ApiFuture<QueryTemplate> future =
          analyticsHubServiceClient.updateQueryTemplateCallable().futureCall(request);
      // Do something.
      QueryTemplate response = future.get();
    }
  }
}
// [END analyticshub_v1_generated_AnalyticsHubService_UpdateQueryTemplate_async]
