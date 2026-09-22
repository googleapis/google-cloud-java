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

package com.google.cloud.chronicle.v1.samples;

// [START chronicle_v1_generated_FeedsService_ImportPushLogs_sync]
import com.google.api.HttpBody;
import com.google.cloud.chronicle.v1.FeedName;
import com.google.cloud.chronicle.v1.FeedsServiceClient;
import com.google.cloud.chronicle.v1.ImportPushLogsRequest;

public class SyncImportPushLogs {

  public static void main(String[] args) throws Exception {
    syncImportPushLogs();
  }

  public static void syncImportPushLogs() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (FeedsServiceClient feedsServiceClient = FeedsServiceClient.create()) {
      ImportPushLogsRequest request =
          ImportPushLogsRequest.newBuilder()
              .setParent(FeedName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FEED]").toString())
              .setHttpBody(HttpBody.newBuilder().build())
              .setSecret("secret-906277200")
              .build();
      HttpBody response = feedsServiceClient.importPushLogs(request);
    }
  }
}
// [END chronicle_v1_generated_FeedsService_ImportPushLogs_sync]
