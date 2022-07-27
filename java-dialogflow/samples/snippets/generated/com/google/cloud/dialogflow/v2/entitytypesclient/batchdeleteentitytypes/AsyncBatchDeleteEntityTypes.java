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

// [START dialogflow_v2_generated_entitytypesclient_batchdeleteentitytypes_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.dialogflow.v2.AgentName;
import com.google.cloud.dialogflow.v2.BatchDeleteEntityTypesRequest;
import com.google.cloud.dialogflow.v2.EntityTypesClient;
import com.google.longrunning.Operation;
import java.util.ArrayList;

public class AsyncBatchDeleteEntityTypes {

  public static void main(String[] args) throws Exception {
    asyncBatchDeleteEntityTypes();
  }

  public static void asyncBatchDeleteEntityTypes() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    try (EntityTypesClient entityTypesClient = EntityTypesClient.create()) {
      BatchDeleteEntityTypesRequest request =
          BatchDeleteEntityTypesRequest.newBuilder()
              .setParent(AgentName.ofProjectName("[PROJECT]").toString())
              .addAllEntityTypeNames(new ArrayList<String>())
              .build();
      ApiFuture<Operation> future =
          entityTypesClient.batchDeleteEntityTypesCallable().futureCall(request);
      // Do something.
      future.get();
    }
  }
}
// [END dialogflow_v2_generated_entitytypesclient_batchdeleteentitytypes_async]
