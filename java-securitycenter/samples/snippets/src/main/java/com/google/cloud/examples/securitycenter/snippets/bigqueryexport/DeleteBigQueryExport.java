/*
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.examples.securitycenter.snippets.bigqueryexport;

// [START securitycenter_delete_bigquery_export]

import com.google.cloud.securitycenter.v1.DeleteBigQueryExportRequest;
import com.google.cloud.securitycenter.v1.SecurityCenterClient;
import java.io.IOException;

public class DeleteBigQueryExport {

  public static void main(String[] args) throws IOException {
    // TODO(Developer): Modify the following variable values.

    // parent: Use any one of the following resource paths:
    //              - organizations/{organization_id}
    //              - folders/{folder_id}
    //              - projects/{project_id}
    String parent = String.format("projects/%s", "your-google-cloud-project-id");

    // bigQueryExportId: Unique identifier that is used to identify the export.
    String bigQueryExportId = "export-id";

    deleteBigQueryExport(parent, bigQueryExportId);
  }

  // Delete an existing BigQuery export.
  public static void deleteBigQueryExport(String parent, String bigQueryExportId)
      throws IOException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (SecurityCenterClient client = SecurityCenterClient.create()) {

      DeleteBigQueryExportRequest bigQueryExportRequest =
          DeleteBigQueryExportRequest.newBuilder()
              .setName(String.format("%s/bigQueryExports/%s", parent, bigQueryExportId))
              .build();

      client.deleteBigQueryExport(bigQueryExportRequest);
      System.out.printf("BigQuery export request deleted successfully: %s", bigQueryExportId);
    }
  }
}
// [END securitycenter_delete_bigquery_export]
