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

package com.google.cloud.pubsub.v1.samples;

// [START pubsub_v1_generated_SchemaService_ListSchemaRevisions_Paged_async]
import com.google.cloud.pubsub.v1.SchemaServiceClient;
import com.google.common.base.Strings;
import com.google.pubsub.v1.ListSchemaRevisionsRequest;
import com.google.pubsub.v1.ListSchemaRevisionsResponse;
import com.google.pubsub.v1.Schema;
import com.google.pubsub.v1.SchemaName;
import com.google.pubsub.v1.SchemaView;

public class AsyncListSchemaRevisionsPaged {

  public static void main(String[] args) throws Exception {
    asyncListSchemaRevisionsPaged();
  }

  public static void asyncListSchemaRevisionsPaged() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (SchemaServiceClient schemaServiceClient = SchemaServiceClient.create()) {
      ListSchemaRevisionsRequest request =
          ListSchemaRevisionsRequest.newBuilder()
              .setName(SchemaName.of("[PROJECT]", "[SCHEMA]").toString())
              .setView(SchemaView.forNumber(0))
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      while (true) {
        ListSchemaRevisionsResponse response =
            schemaServiceClient.listSchemaRevisionsCallable().call(request);
        for (Schema element : response.getSchemasList()) {
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
// [END pubsub_v1_generated_SchemaService_ListSchemaRevisions_Paged_async]
