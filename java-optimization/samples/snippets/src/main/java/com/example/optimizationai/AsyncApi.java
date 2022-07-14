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
 */

package com.optimizationai;

// [START cloudoptimization_async_api]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.optimization.v1.AsyncModelMetadata;
import com.google.cloud.optimization.v1.BatchOptimizeToursRequest;
import com.google.cloud.optimization.v1.BatchOptimizeToursRequest.AsyncModelConfig;
import com.google.cloud.optimization.v1.BatchOptimizeToursResponse;
import com.google.cloud.optimization.v1.DataFormat;
import com.google.cloud.optimization.v1.FleetRoutingClient;
import com.google.cloud.optimization.v1.GcsDestination;
import com.google.cloud.optimization.v1.GcsSource;
import com.google.cloud.optimization.v1.InputConfig;
import com.google.cloud.optimization.v1.OutputConfig;

/**
 * This is an example to send a request to Cloud Fleet Routing asynchronous API via Java API Client.
 * A sample async_request_java.textproto file and a sample request_model_java.json file can be found
 * in the resources folder.
 */
public class AsyncApi {
  public static void callAsyncApi() throws Exception {
    // TODO(developer): Replace these variables before running the sample.
    String projectParent = "projects/{YOUR_GCP_PROJECT_ID}";
    String inputUri = "gs://YOUR_GCS_PATH";
    String outputUri = "gs://YOUR_SOLUTION_PATH";
    callAsyncApi(projectParent, inputUri, outputUri);
  }

  public static void callAsyncApi(String projectParent, String inputUri, String outputUri)
      throws Exception {
    GcsSource gcsSource = GcsSource.newBuilder().setUri(inputUri).build();
    InputConfig inputConfig =
        InputConfig.newBuilder().setGcsSource(gcsSource).setDataFormat(DataFormat.JSON).build();
    GcsDestination gcsDestination = GcsDestination.newBuilder().setUri(outputUri).build();
    OutputConfig outputConfig =
        OutputConfig.newBuilder()
            .setGcsDestination(gcsDestination)
            .setDataFormat(DataFormat.JSON)
            .build();

    AsyncModelConfig asyncModelConfig =
        AsyncModelConfig.newBuilder()
            .setInputConfig(inputConfig)
            .setOutputConfig(outputConfig)
            .build();
    BatchOptimizeToursRequest request =
        BatchOptimizeToursRequest.newBuilder()
            .setParent(projectParent)
            .addModelConfigs(asyncModelConfig)
            .build();

    FleetRoutingClient fleetRoutingClient = FleetRoutingClient.create();
    OperationFuture<BatchOptimizeToursResponse, AsyncModelMetadata> response =
        fleetRoutingClient.batchOptimizeToursAsync(request);
    System.out.format("the response name: %s\n", response.getInitialFuture().get().getName());

    // Block to wait for the job to finish.
    response.getPollingFuture().get();
    if (response.getMetadata().get().getState() == AsyncModelMetadata.State.SUCCEEDED) {
      // Code to do your stuff
      System.out.println("Job finished successfully.");
    } else {
      System.out.println(
          "Job failed with message:" + response.getPollingFuture().get().getErrorMessage());
    }
  }
}
// [END cloudoptimization_async_api]
