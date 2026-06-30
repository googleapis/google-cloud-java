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

// [START chronicle_v1_generated_DataTableService_BulkReplaceDataTableRows_DatatablenameListcreatedatatablerowrequest_sync]
import com.google.cloud.chronicle.v1.BulkReplaceDataTableRowsResponse;
import com.google.cloud.chronicle.v1.CreateDataTableRowRequest;
import com.google.cloud.chronicle.v1.DataTableName;
import com.google.cloud.chronicle.v1.DataTableServiceClient;
import java.util.ArrayList;
import java.util.List;

public class SyncBulkReplaceDataTableRowsDatatablenameListcreatedatatablerowrequest {

  public static void main(String[] args) throws Exception {
    syncBulkReplaceDataTableRowsDatatablenameListcreatedatatablerowrequest();
  }

  public static void syncBulkReplaceDataTableRowsDatatablenameListcreatedatatablerowrequest()
      throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (DataTableServiceClient dataTableServiceClient = DataTableServiceClient.create()) {
      DataTableName parent =
          DataTableName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_TABLE]");
      List<CreateDataTableRowRequest> requests = new ArrayList<>();
      BulkReplaceDataTableRowsResponse response =
          dataTableServiceClient.bulkReplaceDataTableRows(parent, requests);
    }
  }
}
// [END chronicle_v1_generated_DataTableService_BulkReplaceDataTableRows_DatatablenameListcreatedatatablerowrequest_sync]
