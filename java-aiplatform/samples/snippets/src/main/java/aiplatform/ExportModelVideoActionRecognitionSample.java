/*
 * Copyright 2020 Google LLC
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

package aiplatform;

// [START aiplatform_export_model_video_action_recognition_sample]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.aiplatform.v1beta1.ExportModelOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.ExportModelRequest;
import com.google.cloud.aiplatform.v1beta1.ExportModelResponse;
import com.google.cloud.aiplatform.v1beta1.GcsDestination;
import com.google.cloud.aiplatform.v1beta1.ModelName;
import com.google.cloud.aiplatform.v1beta1.ModelServiceClient;
import com.google.cloud.aiplatform.v1beta1.ModelServiceSettings;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class ExportModelVideoActionRecognitionSample {

  public static void main(String[] args)
      throws IOException, ExecutionException, InterruptedException {
    // TODO(developer): Replace these variables before running the sample.
    String project = "PROJECT";
    String modelId = "MODEL_ID";
    String gcsDestinationOutputUriPrefix = "GCS_DESTINATION_OUTPUT_URI_PREFIX";
    String exportFormat = "EXPORT_FORMAT";
    exportModelVideoActionRecognitionSample(
        project, modelId, gcsDestinationOutputUriPrefix, exportFormat);
  }

  static void exportModelVideoActionRecognitionSample(
      String project, String modelId, String gcsDestinationOutputUriPrefix, String exportFormat)
      throws IOException, ExecutionException, InterruptedException {
    ModelServiceSettings settings =
        ModelServiceSettings.newBuilder()
            .setEndpoint("us-central1-aiplatform.googleapis.com:443")
            .build();
    String location = "us-central1";

    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (ModelServiceClient client = ModelServiceClient.create(settings)) {
      GcsDestination gcsDestination =
          GcsDestination.newBuilder().setOutputUriPrefix(gcsDestinationOutputUriPrefix).build();
      ExportModelRequest.OutputConfig outputConfig =
          ExportModelRequest.OutputConfig.newBuilder()
              .setArtifactDestination(gcsDestination)
              .setExportFormatId(exportFormat)
              .build();
      ModelName name = ModelName.of(project, location, modelId);
      OperationFuture<ExportModelResponse, ExportModelOperationMetadata> response =
          client.exportModelAsync(name, outputConfig);

      // You can use OperationFuture.getInitialFuture to get a future representing the initial
      // response to the request, which contains information while the operation is in progress.
      System.out.format("Operation name: %s\n", response.getInitialFuture().get().getName());

      // OperationFuture.get() will block until the operation is finished.
      ExportModelResponse exportModelResponse = response.get();
      System.out.format("exportModelResponse: %s\n", exportModelResponse);
    }
  }
}

// [END aiplatform_export_model_video_action_recognition_sample]
