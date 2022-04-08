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

package com.example.optimizationai;

// [START cloudoptimization_sync_api]

import com.google.cloud.optimization.v1.FleetRoutingClient;
import com.google.cloud.optimization.v1.OptimizeToursRequest;
import com.google.cloud.optimization.v1.OptimizeToursResponse;
import com.google.protobuf.Duration;
import com.google.protobuf.TextFormat;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * This is an example to send a request to Cloud Fleet Routing synchronous API via Java API Client.
 * A sample sync_request.textproto file can be found in the resources folder.
 */
public class SyncApi {
  public static void callSyncApi() throws Exception {
    // TODO(developer): Replace these variables before running the sample.
    String projectParent = "projects/{YOUR_GCP_PROJECT_ID}";
    String modelPath = "YOUR_MODEL_PATH";
    callSyncApi(projectParent, modelPath);
  }

  public static void callSyncApi(String projectParent, String modelPath) throws Exception {
    int timeoutSeconds = 100;
    InputStream modelInputstream = new FileInputStream(modelPath);
    Reader modelInputStreamReader = new InputStreamReader(modelInputstream);
    OptimizeToursRequest.Builder requestBuilder =
        OptimizeToursRequest.newBuilder()
            .setTimeout(Duration.newBuilder().setSeconds(timeoutSeconds).build())
            .setParent(projectParent);
    TextFormat.getParser().merge(modelInputStreamReader, requestBuilder);
    FleetRoutingClient fleetRoutingClient = FleetRoutingClient.create();
    OptimizeToursResponse response = fleetRoutingClient.optimizeTours(requestBuilder.build());
    System.out.println(response.toString());
  }
}
// [END cloudoptimization_sync_api]
