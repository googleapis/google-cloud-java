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

package com.google.cloud.discoveryengine.v1beta.samples;

// [START discoveryengine_v1beta_generated_SchemaService_ListSchemas_Paged_async]
import com.google.cloud.discoveryengine.v1beta.DataStoreName;
import com.google.cloud.discoveryengine.v1beta.ListSchemasRequest;
import com.google.cloud.discoveryengine.v1beta.ListSchemasResponse;
import com.google.cloud.discoveryengine.v1beta.Schema;
import com.google.cloud.discoveryengine.v1beta.SchemaServiceClient;
import com.google.common.base.Strings;

public class AsyncListSchemasPaged {

  public static void main(String[] args) throws Exception {
    asyncListSchemasPaged();
  }

  public static void asyncListSchemasPaged() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (SchemaServiceClient schemaServiceClient = SchemaServiceClient.create()) {
      ListSchemasRequest request =
          ListSchemasRequest.newBuilder()
              .setParent(
                  DataStoreName.ofProjectLocationDataStoreName(
                          "[PROJECT]", "[LOCATION]", "[DATA_STORE]")
                      .toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      while (true) {
        ListSchemasResponse response = schemaServiceClient.listSchemasCallable().call(request);
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
// [END discoveryengine_v1beta_generated_SchemaService_ListSchemas_Paged_async]
