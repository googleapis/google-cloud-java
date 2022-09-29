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

package com.google.cloud.dialogflow.v2.samples;

// [START dialogflow_v2_generated_entitytypesclient_batchdeleteentities_sync]
import com.google.cloud.dialogflow.v2.BatchDeleteEntitiesRequest;
import com.google.cloud.dialogflow.v2.EntityTypeName;
import com.google.cloud.dialogflow.v2.EntityTypesClient;
import com.google.protobuf.Empty;
import java.util.ArrayList;

public class SyncBatchDeleteEntities {

  public static void main(String[] args) throws Exception {
    syncBatchDeleteEntities();
  }

  public static void syncBatchDeleteEntities() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (EntityTypesClient entityTypesClient = EntityTypesClient.create()) {
      BatchDeleteEntitiesRequest request =
          BatchDeleteEntitiesRequest.newBuilder()
              .setParent(
                  EntityTypeName.ofProjectEntityTypeName("[PROJECT]", "[ENTITY_TYPE]").toString())
              .addAllEntityValues(new ArrayList<String>())
              .setLanguageCode("languageCode-2092349083")
              .build();
      entityTypesClient.batchDeleteEntitiesAsync(request).get();
    }
  }
}
// [END dialogflow_v2_generated_entitytypesclient_batchdeleteentities_sync]
