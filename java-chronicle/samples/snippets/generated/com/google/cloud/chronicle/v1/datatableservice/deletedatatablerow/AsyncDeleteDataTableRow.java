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

// [START chronicle_v1_generated_DataTableService_DeleteDataTableRow_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.chronicle.v1.DataTableRowName;
import com.google.cloud.chronicle.v1.DataTableServiceClient;
import com.google.cloud.chronicle.v1.DeleteDataTableRowRequest;
import com.google.protobuf.Empty;

public class AsyncDeleteDataTableRow {

  public static void main(String[] args) throws Exception {
    asyncDeleteDataTableRow();
  }

  public static void asyncDeleteDataTableRow() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (DataTableServiceClient dataTableServiceClient = DataTableServiceClient.create()) {
      DeleteDataTableRowRequest request =
          DeleteDataTableRowRequest.newBuilder()
              .setName(
                  DataTableRowName.of(
                          "[PROJECT]",
                          "[LOCATION]",
                          "[INSTANCE]",
                          "[DATA_TABLE]",
                          "[DATA_TABLE_ROW]")
                      .toString())
              .build();
      ApiFuture<Empty> future =
          dataTableServiceClient.deleteDataTableRowCallable().futureCall(request);
      // Do something.
      future.get();
    }
  }
}
// [END chronicle_v1_generated_DataTableService_DeleteDataTableRow_async]
