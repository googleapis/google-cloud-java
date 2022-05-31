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

// [START securitycenter_update_bigquery_export]

import com.google.cloud.securitycenter.v1.BigQueryExport;
import com.google.cloud.securitycenter.v1.SecurityCenterClient;
import com.google.cloud.securitycenter.v1.UpdateBigQueryExportRequest;
import com.google.protobuf.FieldMask;
import java.io.IOException;

public class UpdateBigQueryExport {

  public static void main(String[] args) throws IOException {
    // TODO(Developer): Modify the following variable values.

    // parent: Use any one of the following resource paths:
    //              - organizations/{organization_id}
    //              - folders/{folder_id}
    //              - projects/{project_id}
    String parent = String.format("projects/%s", "your-google-cloud-project-id");

    // filter: Expression that defines the filter to apply across create/update events of findings.
    String filter =
        "severity=\"LOW\" OR severity=\"MEDIUM\" AND "
            + "category=\"Persistence: IAM Anomalous Grant\" AND "
            + "-resource.type:\"compute\"";

    // bigQueryExportId: Unique identifier provided by the client.
    // For more info, see:
    // https://cloud.google.com/security-command-center/docs/how-to-analyze-findings-in-big-query#export_findings_from_to
    String bigQueryExportId = "big-query-export-id";

    updateBigQueryExport(parent, filter, bigQueryExportId);
  }

  // Updates an existing BigQuery export.
  public static void updateBigQueryExport(String parent, String filter, String bigQueryExportId)
      throws IOException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (SecurityCenterClient client = SecurityCenterClient.create()) {

      //  Set the new values for export configuration.
      BigQueryExport bigQueryExport =
          BigQueryExport.newBuilder()
              .setName(String.format("%s/bigQueryExports/%s", parent, bigQueryExportId))
              .setFilter(filter)
              .build();

      UpdateBigQueryExportRequest request =
          UpdateBigQueryExportRequest.newBuilder()
              .setBigQueryExport(bigQueryExport)
              // Set the update mask to specify which properties should be updated.
              // If empty, all mutable fields will be updated.
              // For more info on constructing field mask path, see the proto or:
              // https://cloud.google.com/java/docs/reference/protobuf/latest/com.google.protobuf.FieldMask
              .setUpdateMask(FieldMask.newBuilder().addPaths("filter").build())
              .build();

      BigQueryExport response = client.updateBigQueryExport(request);
      if (!response.getFilter().equalsIgnoreCase(filter)) {
        System.out.println("Failed to update BigQueryExport!");
        return;
      }
      System.out.println("BigQueryExport updated successfully!");
    }
  }
}
// [END securitycenter_update_bigquery_export]
