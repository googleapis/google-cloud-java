/*
 * Copyright 2021 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.contactcenterinsights;

// [START contactcenterinsights_export_to_bigquery]

import com.google.api.gax.longrunning.OperationTimedPollAlgorithm;
import com.google.api.gax.retrying.RetrySettings;
import com.google.cloud.contactcenterinsights.v1.ContactCenterInsightsClient;
import com.google.cloud.contactcenterinsights.v1.ContactCenterInsightsSettings;
import com.google.cloud.contactcenterinsights.v1.ExportInsightsDataRequest;
import com.google.cloud.contactcenterinsights.v1.ExportInsightsDataResponse;
import com.google.cloud.contactcenterinsights.v1.LocationName;
import java.io.IOException;
import org.threeten.bp.Duration;

public class ExportToBigquery {

  public static void main(String[] args) throws Exception, IOException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "my_project_id";
    String bigqueryProjectId = "my_bigquery_project_id";
    String bigqueryDataset = "my_bigquery_dataset";
    String bigqueryTable = "my_bigquery_table";

    exportToBigquery(projectId, bigqueryProjectId, bigqueryDataset, bigqueryTable);
  }

  public static void exportToBigquery(
      String projectId, String bigqueryProjectId, String bigqueryDataset, String bigqueryTable)
      throws Exception, IOException {
    // Set the operation total polling timeout to 24 hours instead of the 5-minute default.
    // Other values are copied from the default values of {@link ContactCenterInsightsStubSettings}.
    ContactCenterInsightsSettings.Builder clientSettings =
        ContactCenterInsightsSettings.newBuilder();
    clientSettings
        .exportInsightsDataOperationSettings()
        .setPollingAlgorithm(
            OperationTimedPollAlgorithm.create(
                RetrySettings.newBuilder()
                    .setInitialRetryDelay(Duration.ofMillis(5000L))
                    .setRetryDelayMultiplier(1.5)
                    .setMaxRetryDelay(Duration.ofMillis(45000L))
                    .setInitialRpcTimeout(Duration.ZERO)
                    .setRpcTimeoutMultiplier(1.0)
                    .setMaxRpcTimeout(Duration.ZERO)
                    .setTotalTimeout(Duration.ofHours(24L))
                    .build()));

    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (ContactCenterInsightsClient client =
        ContactCenterInsightsClient.create(clientSettings.build())) {
      // Construct an export request.
      LocationName parent = LocationName.of(projectId, "us-central1");
      ExportInsightsDataRequest request =
          ExportInsightsDataRequest.newBuilder()
              .setParent(parent.toString())
              .setBigQueryDestination(
                  ExportInsightsDataRequest.BigQueryDestination.newBuilder()
                      .setProjectId(bigqueryProjectId)
                      .setDataset(bigqueryDataset)
                      .setTable(bigqueryTable)
                      .build())
              .setFilter("agent_id=\"007\"")
              .build();

      // Call the Insights client to export data to BigQuery.
      ExportInsightsDataResponse response = client.exportInsightsDataAsync(request).get();
      System.out.printf("Exported data to BigQuery");
    }
  }
}

// [END contactcenterinsights_export_to_bigquery]
