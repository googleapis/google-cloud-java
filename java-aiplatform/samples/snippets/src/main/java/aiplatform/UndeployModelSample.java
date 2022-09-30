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

// [START aiplatform_undeploy_model_sample]

import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.aiplatform.v1.EndpointName;
import com.google.cloud.aiplatform.v1.EndpointServiceClient;
import com.google.cloud.aiplatform.v1.EndpointServiceSettings;
import com.google.cloud.aiplatform.v1.ModelName;
import com.google.cloud.aiplatform.v1.UndeployModelOperationMetadata;
import com.google.cloud.aiplatform.v1.UndeployModelResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class UndeployModelSample {

  public static void main(String[] args)
      throws IOException, InterruptedException, ExecutionException, TimeoutException {
    // TODO(developer): Replace these variables before running the sample.
    String project = "YOUR_PROJECT_ID";
    String endpointId = "YOUR_ENDPOINT_ID";
    String modelId = "YOUR_MODEL_ID";
    undeployModelSample(project, endpointId, modelId);
  }

  static void undeployModelSample(String project, String endpointId, String modelId)
      throws IOException, InterruptedException, ExecutionException, TimeoutException {
    EndpointServiceSettings endpointServiceSettings =
        EndpointServiceSettings.newBuilder()
            .setEndpoint("us-central1-aiplatform.googleapis.com:443")
            .build();

    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (EndpointServiceClient endpointServiceClient =
        EndpointServiceClient.create(endpointServiceSettings)) {
      String location = "us-central1";
      EndpointName endpointName = EndpointName.of(project, location, endpointId);
      ModelName modelName = ModelName.of(project, location, modelId);

      // key '0' assigns traffic for the newly deployed model
      // Traffic percentage values must add up to 100
      // Leave dictionary empty if endpoint should not accept any traffic
      Map<String, Integer> trafficSplit = new HashMap<>();
      trafficSplit.put("0", 100);

      OperationFuture<UndeployModelResponse, UndeployModelOperationMetadata> operation =
          endpointServiceClient.undeployModelAsync(
              endpointName.toString(), modelName.toString(), trafficSplit);
      System.out.format("Operation name: %s\n", operation.getInitialFuture().get().getName());
      System.out.println("Waiting for operation to finish...");
      UndeployModelResponse undeployModelResponse = operation.get(180, TimeUnit.SECONDS);

      System.out.format("Undeploy Model Response: %s\n", undeployModelResponse);
    }
  }
}
// [END aiplatform_undeploy_model_sample]
