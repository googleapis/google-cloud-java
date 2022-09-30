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

// [START securitycenter_get_bigquery_export]

import com.google.cloud.securitycenter.v1.BigQueryExport;
import com.google.cloud.securitycenter.v1.GetBigQueryExportRequest;
import com.google.cloud.securitycenter.v1.SecurityCenterClient;
import java.io.IOException;

public class GetBigQueryExport {

  public static void main(String[] args) throws IOException {
    // TODO(Developer): Modify the following variable values.

    // parent: Use any one of the following resource paths:
    //              - organizations/{organization_id}
    //              - folders/{folder_id}
    //              - projects/{project_id}
    String parent = String.format("projects/%s", "your-google-cloud-project-id");

    // bigQueryExportId: Unique identifier that is used to identify the export.
    String bigQueryExportId = "export-id";

    getBigQueryExport(parent, bigQueryExportId);
  }

  // Retrieve an existing BigQuery export.
  public static void getBigQueryExport(String parent, String bigQueryExportId) throws IOException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (SecurityCenterClient client = SecurityCenterClient.create()) {

      GetBigQueryExportRequest bigQueryExportRequest =
          GetBigQueryExportRequest.newBuilder()
              .setName(String.format("%s/bigQueryExports/%s", parent, bigQueryExportId))
              .build();

      BigQueryExport response = client.getBigQueryExport(bigQueryExportRequest);
      System.out.printf("Retrieved the BigQuery export: %s", response.getName());
    }
  }
}
// [END securitycenter_get_bigquery_export]
