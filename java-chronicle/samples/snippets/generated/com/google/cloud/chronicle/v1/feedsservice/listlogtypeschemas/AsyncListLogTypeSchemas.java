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

// [START chronicle_v1_generated_FeedsService_ListLogTypeSchemas_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.chronicle.v1.FeedSourceTypeSchemaName;
import com.google.cloud.chronicle.v1.FeedsServiceClient;
import com.google.cloud.chronicle.v1.ListLogTypeSchemasRequest;
import com.google.cloud.chronicle.v1.LogTypeSchema;

public class AsyncListLogTypeSchemas {

  public static void main(String[] args) throws Exception {
    asyncListLogTypeSchemas();
  }

  public static void asyncListLogTypeSchemas() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (FeedsServiceClient feedsServiceClient = FeedsServiceClient.create()) {
      ListLogTypeSchemasRequest request =
          ListLogTypeSchemasRequest.newBuilder()
              .setParent(
                  FeedSourceTypeSchemaName.of(
                          "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FEED_SOURCE_TYPE]")
                      .toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      ApiFuture<LogTypeSchema> future =
          feedsServiceClient.listLogTypeSchemasPagedCallable().futureCall(request);
      // Do something.
      for (LogTypeSchema element : future.get().iterateAll()) {
        // doThingsWith(element);
      }
    }
  }
}
// [END chronicle_v1_generated_FeedsService_ListLogTypeSchemas_async]
