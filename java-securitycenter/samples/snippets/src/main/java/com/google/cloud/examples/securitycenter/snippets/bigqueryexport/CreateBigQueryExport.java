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

// [START securitycenter_create_bigquery_export]

import com.google.cloud.securitycenter.v1.BigQueryExport;
import com.google.cloud.securitycenter.v1.CreateBigQueryExportRequest;
import com.google.cloud.securitycenter.v1.SecurityCenterClient;
import java.io.IOException;
import java.util.UUID;

public class CreateBigQueryExport {

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

    // bigQueryDatasetId: The BigQuery dataset to write findings' updates to.
    String bigQueryDatasetId = "your-bigquery-dataset-id";

    // bigQueryExportId: Unique identifier provided by the client.
    // For more info, see:
    // https://cloud.google.com/security-command-center/docs/how-to-analyze-findings-in-big-query#export_findings_from_to
    String bigQueryExportId = "default-" + UUID.randomUUID().toString().split("-")[0];

    createBigQueryExport(parent, filter, bigQueryDatasetId, bigQueryExportId);
  }

  // Create export configuration to export findings from a project to a BigQuery dataset.
  // Optionally specify filter to export certain findings only.
  public static void createBigQueryExport(
      String parent, String filter, String bigQueryDatasetId, String bigQueryExportId)
      throws IOException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (SecurityCenterClient client = SecurityCenterClient.create()) {

      // Create the BigQuery export configuration.
      BigQueryExport bigQueryExport =
          BigQueryExport.newBuilder()
              .setDescription(
                  "Export low and medium findings if the compute resource "
                      + "has an IAM anomalous grant")
              .setFilter(filter)
              .setDataset(String.format("%s/datasets/%s", parent, bigQueryDatasetId))
              .build();

      CreateBigQueryExportRequest bigQueryExportRequest =
          CreateBigQueryExportRequest.newBuilder()
              .setParent(parent)
              .setBigQueryExport(bigQueryExport)
              .setBigQueryExportId(bigQueryExportId)
              .build();

      // Create the export request.
      BigQueryExport response = client.createBigQueryExport(bigQueryExportRequest);

      System.out.printf("BigQuery export request created successfully: %s\n", response.getName());
    }
  }
}
// [END securitycenter_create_bigquery_export]
