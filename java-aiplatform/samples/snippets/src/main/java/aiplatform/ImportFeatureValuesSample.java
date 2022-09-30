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
 * Bulk import values into a featurestore for existing features. See
 * https://cloud.google.com/vertex-ai/docs/featurestore/setup before running
 * the code snippet
 */

package aiplatform;

// [START aiplatform_import_feature_values_sample]

import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.aiplatform.v1.AvroSource;
import com.google.cloud.aiplatform.v1.EntityTypeName;
import com.google.cloud.aiplatform.v1.FeaturestoreServiceClient;
import com.google.cloud.aiplatform.v1.FeaturestoreServiceSettings;
import com.google.cloud.aiplatform.v1.GcsSource;
import com.google.cloud.aiplatform.v1.ImportFeatureValuesOperationMetadata;
import com.google.cloud.aiplatform.v1.ImportFeatureValuesRequest;
import com.google.cloud.aiplatform.v1.ImportFeatureValuesRequest.FeatureSpec;
import com.google.cloud.aiplatform.v1.ImportFeatureValuesResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ImportFeatureValuesSample {

  public static void main(String[] args)
      throws IOException, InterruptedException, ExecutionException, TimeoutException {
    // TODO(developer): Replace these variables before running the sample.
    String project = "YOUR_PROJECT_ID";
    String featurestoreId = "YOUR_FEATURESTORE_ID";
    String entityTypeId = "YOUR_ENTITY_TYPE_ID";
    String entityIdField = "YOUR_ENTITY_FIELD_ID";
    String featureTimeField = "YOUR_FEATURE_TIME_FIELD";
    String gcsSourceUri = "YOUR_GCS_SOURCE_URI";
    int workerCount = 2;
    String location = "us-central1";
    String endpoint = "us-central1-aiplatform.googleapis.com:443";
    int timeout = 300;
    importFeatureValuesSample(
        project,
        featurestoreId,
        entityTypeId,
        gcsSourceUri,
        entityIdField,
        featureTimeField,
        workerCount,
        location,
        endpoint,
        timeout);
  }

  static void importFeatureValuesSample(
      String project,
      String featurestoreId,
      String entityTypeId,
      String gcsSourceUri,
      String entityIdField,
      String featureTimeField,
      int workerCount,
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
      List<FeatureSpec> featureSpecs = new ArrayList<>();

      featureSpecs.add(FeatureSpec.newBuilder().setId("title").build());
      featureSpecs.add(FeatureSpec.newBuilder().setId("genres").build());
      featureSpecs.add(FeatureSpec.newBuilder().setId("average_rating").build());
      ImportFeatureValuesRequest importFeatureValuesRequest =
          ImportFeatureValuesRequest.newBuilder()
              .setEntityType(
                  EntityTypeName.of(project, location, featurestoreId, entityTypeId).toString())
              .setEntityIdField(entityIdField)
              .setFeatureTimeField(featureTimeField)
              .addAllFeatureSpecs(featureSpecs)
              .setWorkerCount(workerCount)
              .setAvroSource(
                  AvroSource.newBuilder()
                      .setGcsSource(GcsSource.newBuilder().addUris(gcsSourceUri)))
              .build();
      OperationFuture<ImportFeatureValuesResponse, ImportFeatureValuesOperationMetadata>
          importFeatureValuesFuture =
              featurestoreServiceClient.importFeatureValuesAsync(importFeatureValuesRequest);
      System.out.format(
          "Operation name: %s%n", importFeatureValuesFuture.getInitialFuture().get().getName());
      System.out.println("Waiting for operation to finish...");
      ImportFeatureValuesResponse importFeatureValuesResponse =
          importFeatureValuesFuture.get(timeout, TimeUnit.SECONDS);
      System.out.println("Import Feature Values Response");
      System.out.println(importFeatureValuesResponse);
      featurestoreServiceClient.close();
    }
  }
}
// [END aiplatform_import_feature_values_sample]
