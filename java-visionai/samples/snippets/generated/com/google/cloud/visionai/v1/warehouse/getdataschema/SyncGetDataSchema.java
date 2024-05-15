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

package com.google.cloud.visionai.v1.samples;

// [START visionai_v1_generated_Warehouse_GetDataSchema_sync]
import com.google.cloud.visionai.v1.DataSchema;
import com.google.cloud.visionai.v1.DataSchemaName;
import com.google.cloud.visionai.v1.GetDataSchemaRequest;
import com.google.cloud.visionai.v1.WarehouseClient;

public class SyncGetDataSchema {

  public static void main(String[] args) throws Exception {
    syncGetDataSchema();
  }

  public static void syncGetDataSchema() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (WarehouseClient warehouseClient = WarehouseClient.create()) {
      GetDataSchemaRequest request =
          GetDataSchemaRequest.newBuilder()
              .setName(
                  DataSchemaName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[DATA_SCHEMA]")
                      .toString())
              .build();
      DataSchema response = warehouseClient.getDataSchema(request);
    }
  }
}
// [END visionai_v1_generated_Warehouse_GetDataSchema_sync]
