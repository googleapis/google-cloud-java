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
 * Update entity type. See
 * https://cloud.google.com/vertex-ai/docs/featurestore/setup before running
 * the code snippet
 */

package aiplatform;

// [START aiplatform_update_entity_type_monitoring_sample]

import com.google.cloud.aiplatform.v1.EntityType;
import com.google.cloud.aiplatform.v1.EntityTypeName;
import com.google.cloud.aiplatform.v1.FeaturestoreMonitoringConfig;
import com.google.cloud.aiplatform.v1.FeaturestoreMonitoringConfig.SnapshotAnalysis;
import com.google.cloud.aiplatform.v1.FeaturestoreServiceClient;
import com.google.cloud.aiplatform.v1.FeaturestoreServiceSettings;
import com.google.cloud.aiplatform.v1.UpdateEntityTypeRequest;
import java.io.IOException;

public class UpdateEntityTypeMonitoringSample {

  public static void main(String[] args) throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String project = "YOUR_PROJECT_ID";
    String featurestoreId = "YOUR_FEATURESTORE_ID";
    String entityTypeId = "YOUR_ENTITY_TYPE_ID";
    int monitoringIntervalDays = 1;
    String location = "us-central1";
    String endpoint = "us-central1-aiplatform.googleapis.com:443";
    updateEntityTypeMonitoringSample(
        project, featurestoreId, entityTypeId, monitoringIntervalDays, location, endpoint);
  }

  static void updateEntityTypeMonitoringSample(
      String project,
      String featurestoreId,
      String entityTypeId,
      int monitoringIntervalDays,
      String location,
      String endpoint)
      throws IOException {

    FeaturestoreServiceSettings featurestoreServiceSettings =
        FeaturestoreServiceSettings.newBuilder().setEndpoint(endpoint).build();

    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (FeaturestoreServiceClient featurestoreServiceClient =
        FeaturestoreServiceClient.create(featurestoreServiceSettings)) {
      FeaturestoreMonitoringConfig featurestoreMonitoringConfig =
          FeaturestoreMonitoringConfig.newBuilder()
              .setSnapshotAnalysis(
                  SnapshotAnalysis.newBuilder().setMonitoringIntervalDays(monitoringIntervalDays))
              .build();
      EntityType entityType =
          EntityType.newBuilder()
              .setName(
                  EntityTypeName.of(project, location, featurestoreId, entityTypeId).toString())
              .setMonitoringConfig(featurestoreMonitoringConfig)
              .build();

      UpdateEntityTypeRequest updateEntityTypeRequest =
          UpdateEntityTypeRequest.newBuilder().setEntityType(entityType).build();
      EntityType entityTypeResponse =
          featurestoreServiceClient.updateEntityType(updateEntityTypeRequest);
      System.out.println("Update Entity Type Monitoring Response");
      System.out.println(entityTypeResponse);
    }
  }
}
// [END aiplatform_update_entity_type_monitoring_sample]
