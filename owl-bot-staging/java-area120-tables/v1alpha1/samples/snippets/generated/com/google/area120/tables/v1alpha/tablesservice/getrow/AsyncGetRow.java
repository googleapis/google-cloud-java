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

package com.google.area120.tables.v1alpha.samples;

// [START area120tables_v1alpha1_generated_TablesService_GetRow_async]
import com.google.api.core.ApiFuture;
import com.google.area120.tables.v1alpha.TablesServiceClient;
import com.google.area120.tables.v1alpha1.GetRowRequest;
import com.google.area120.tables.v1alpha1.Row;
import com.google.area120.tables.v1alpha1.RowName;
import com.google.area120.tables.v1alpha1.View;

public class AsyncGetRow {

  public static void main(String[] args) throws Exception {
    asyncGetRow();
  }

  public static void asyncGetRow() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (TablesServiceClient tablesServiceClient = TablesServiceClient.create()) {
      GetRowRequest request =
          GetRowRequest.newBuilder()
              .setName(RowName.of("[TABLE]", "[ROW]").toString())
              .setView(View.forNumber(0))
              .build();
      ApiFuture<Row> future = tablesServiceClient.getRowCallable().futureCall(request);
      // Do something.
      Row response = future.get();
    }
  }
}
// [END area120tables_v1alpha1_generated_TablesService_GetRow_async]
