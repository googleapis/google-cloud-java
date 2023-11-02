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

package com.google.cloud.discoveryengine.v1alpha.samples;

// [START discoveryengine_v1alpha_generated_SchemaService_CreateSchema_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.discoveryengine.v1alpha.CreateSchemaRequest;
import com.google.cloud.discoveryengine.v1alpha.DataStoreName;
import com.google.cloud.discoveryengine.v1alpha.Schema;
import com.google.cloud.discoveryengine.v1alpha.SchemaServiceClient;
import com.google.longrunning.Operation;

public class AsyncCreateSchema {

  public static void main(String[] args) throws Exception {
    asyncCreateSchema();
  }

  public static void asyncCreateSchema() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (SchemaServiceClient schemaServiceClient = SchemaServiceClient.create()) {
      CreateSchemaRequest request =
          CreateSchemaRequest.newBuilder()
              .setParent(
                  DataStoreName.ofProjectLocationDataStoreName(
                          "[PROJECT]", "[LOCATION]", "[DATA_STORE]")
                      .toString())
              .setSchema(Schema.newBuilder().build())
              .setSchemaId("schemaId-697673060")
              .build();
      ApiFuture<Operation> future = schemaServiceClient.createSchemaCallable().futureCall(request);
      // Do something.
      Operation response = future.get();
    }
  }
}
// [END discoveryengine_v1alpha_generated_SchemaService_CreateSchema_async]
