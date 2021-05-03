/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package aiplatform;

// [START aiplatform_upload_model_sample]

import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.aiplatform.v1.LocationName;
import com.google.cloud.aiplatform.v1.Model;
import com.google.cloud.aiplatform.v1.ModelContainerSpec;
import com.google.cloud.aiplatform.v1.ModelServiceClient;
import com.google.cloud.aiplatform.v1.ModelServiceSettings;
import com.google.cloud.aiplatform.v1.UploadModelOperationMetadata;
import com.google.cloud.aiplatform.v1.UploadModelResponse;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class UploadModelSample {
  public static void main(String[] args)
      throws InterruptedException, ExecutionException, TimeoutException, IOException {
    // TODO(developer): Replace these variables before running the sample.
    String project = "YOUR_PROJECT_ID";
    String modelDisplayName = "YOUR_MODEL_DISPLAY_NAME";
    String metadataSchemaUri =
        "gs://google-cloud-aiplatform/schema/trainingjob/definition/custom_task_1.0.0.yaml";
    String imageUri = "YOUR_IMAGE_URI";
    String artifactUri = "gs://your-gcs-bucket/artifact_path";
    uploadModel(project, modelDisplayName, metadataSchemaUri, imageUri, artifactUri);
  }

  static void uploadModel(
      String project,
      String modelDisplayName,
      String metadataSchemaUri,
      String imageUri,
      String artifactUri)
      throws IOException, InterruptedException, ExecutionException, TimeoutException {
    ModelServiceSettings modelServiceSettings =
        ModelServiceSettings.newBuilder()
            .setEndpoint("us-central1-aiplatform.googleapis.com:443")
            .build();

    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (ModelServiceClient modelServiceClient = ModelServiceClient.create(modelServiceSettings)) {
      String location = "us-central1";
      LocationName locationName = LocationName.of(project, location);

      ModelContainerSpec modelContainerSpec =
          ModelContainerSpec.newBuilder().setImageUri(imageUri).build();

      Model model =
          Model.newBuilder()
              .setDisplayName(modelDisplayName)
              .setMetadataSchemaUri(metadataSchemaUri)
              .setArtifactUri(artifactUri)
              .setContainerSpec(modelContainerSpec)
              .build();

      OperationFuture<UploadModelResponse, UploadModelOperationMetadata> uploadModelResponseFuture =
          modelServiceClient.uploadModelAsync(locationName, model);
      System.out.format(
          "Operation name: %s\n", uploadModelResponseFuture.getInitialFuture().get().getName());
      System.out.println("Waiting for operation to finish...");
      UploadModelResponse uploadModelResponse = uploadModelResponseFuture.get(5, TimeUnit.MINUTES);

      System.out.println("Upload Model Response");
      System.out.format("Model: %s\n", uploadModelResponse.getModel());
    }
  }
}
// [END aiplatform_upload_model_sample]
