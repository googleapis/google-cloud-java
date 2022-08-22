/*
 * Copyright 2022 Google LLC
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
 *
 *
 * Bulk export feature values from a featurestore. See
 * https://cloud.google.com/vertex-ai/docs/featurestore/setup before running
 * the code snippet
 */

package aiplatform;

// [START aiplatform_export_feature_values_snapshot_sample]

import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.aiplatform.v1.BigQueryDestination;
import com.google.cloud.aiplatform.v1.EntityTypeName;
import com.google.cloud.aiplatform.v1.ExportFeatureValuesOperationMetadata;
import com.google.cloud.aiplatform.v1.ExportFeatureValuesRequest;
import com.google.cloud.aiplatform.v1.ExportFeatureValuesRequest.SnapshotExport;
import com.google.cloud.aiplatform.v1.ExportFeatureValuesResponse;
import com.google.cloud.aiplatform.v1.FeatureSelector;
import com.google.cloud.aiplatform.v1.FeatureValueDestination;
import com.google.cloud.aiplatform.v1.FeaturestoreServiceClient;
import com.google.cloud.aiplatform.v1.FeaturestoreServiceSettings;
import com.google.cloud.aiplatform.v1.IdMatcher;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ExportFeatureValuesSnapshotSample {

  public static void main(String[] args)
      throws IOException, InterruptedException, ExecutionException, TimeoutException {
    // TODO(developer): Replace these variables before running the sample.
    String project = "YOUR_PROJECT_ID";
    String featurestoreId = "YOUR_FEATURESTORE_ID";
    String entityTypeId = "YOUR_ENTITY_TYPE_ID";
    String destinationTableUri = "YOUR_DESTINATION_TABLE_URI";
    List<String> featureSelectorIds = Arrays.asList("title", "genres", "average_rating");
    String location = "us-central1";
    String endpoint = "us-central1-aiplatform.googleapis.com:443";
    int timeout = 300;
    exportFeatureValuesSnapshotSample(
        project,
        featurestoreId,
        entityTypeId,
        destinationTableUri,
        featureSelectorIds,
        location,
        endpoint,
        timeout);
  }

  static void exportFeatureValuesSnapshotSample(
      String project,
      String featurestoreId,
      String entityTypeId,
      String destinationTableUri,
      List<String> featureSelectorIds,
      String location,
      String endpoint,
      int timeout)
      throws IOException, InterruptedException, ExecutionException, TimeoutException {
    FeaturestoreServiceSettings featurestoreServiceSettings =
        FeaturestoreServiceSettings.newBuilder().setEndpoint(endpoint).build();

    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (FeaturestoreServiceClient featurestoreServiceClient =
        FeaturestoreServiceClient.create(featurestoreServiceSettings)) {

      FeatureSelector featureSelector =
          FeatureSelector.newBuilder()
              .setIdMatcher(IdMatcher.newBuilder().addAllIds(featureSelectorIds).build())
              .build();

      ExportFeatureValuesRequest exportFeatureValuesRequest =
          ExportFeatureValuesRequest.newBuilder()
              .setEntityType(
                  EntityTypeName.of(project, location, featurestoreId, entityTypeId).toString())
              .setDestination(
                  FeatureValueDestination.newBuilder()
                      .setBigqueryDestination(
                          BigQueryDestination.newBuilder().setOutputUri(destinationTableUri)))
              .setFeatureSelector(featureSelector)
              .setSnapshotExport(SnapshotExport.newBuilder())
              .build();

      OperationFuture<ExportFeatureValuesResponse, ExportFeatureValuesOperationMetadata>
          exportFeatureValuesFuture =
              featurestoreServiceClient.exportFeatureValuesAsync(exportFeatureValuesRequest);
      System.out.format(
          "Operation name: %s%n", exportFeatureValuesFuture.getInitialFuture().get().getName());
      System.out.println("Waiting for operation to finish...");
      ExportFeatureValuesResponse exportFeatureValuesResponse =
          exportFeatureValuesFuture.get(timeout, TimeUnit.SECONDS);
      System.out.println("Snapshot Export Feature Values Response");
      System.out.println(exportFeatureValuesResponse);
      featurestoreServiceClient.close();
    }
  }
}
// [END aiplatform_export_feature_values_snapshot_sample]
