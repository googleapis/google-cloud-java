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

package beta.automl;

// [START automl_cancel_operation_beta]

import com.google.cloud.automl.v1beta1.AutoMlClient;
import io.grpc.StatusRuntimeException;
import java.io.IOException;

class CancelOperation {

  static void cancelOperation() throws IOException, InterruptedException, StatusRuntimeException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "YOUR_PROJECT_ID";
    String location = "us-central1";
    String operationId = "YOUR_OPERATION_ID";
    String operationFullId =
        String.format("projects/%s/locations/%s/operations/%s", projectId, location, operationId);
    cancelOperation(operationFullId);
  }

  static void cancelOperation(String operationFullId)
      throws IOException, InterruptedException, StatusRuntimeException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (AutoMlClient client = AutoMlClient.create()) {
      client.getOperationsClient().cancelOperation(operationFullId);
      System.out.println("Operation cancelled");
    }
  }
}
// [END automl_cancel_operation_beta]
