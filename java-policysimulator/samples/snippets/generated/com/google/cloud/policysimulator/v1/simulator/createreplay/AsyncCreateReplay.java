/*
 * Copyright 2023 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.policysimulator.v1.samples;

// [START policysimulator_v1_generated_Simulator_CreateReplay_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.policysimulator.v1.CreateReplayRequest;
import com.google.cloud.policysimulator.v1.Replay;
import com.google.cloud.policysimulator.v1.SimulatorClient;
import com.google.longrunning.Operation;

public class AsyncCreateReplay {

  public static void main(String[] args) throws Exception {
    asyncCreateReplay();
  }

  public static void asyncCreateReplay() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (SimulatorClient simulatorClient = SimulatorClient.create()) {
      CreateReplayRequest request =
          CreateReplayRequest.newBuilder()
              .setParent("parent-995424086")
              .setReplay(Replay.newBuilder().build())
              .build();
      ApiFuture<Operation> future = simulatorClient.createReplayCallable().futureCall(request);
      // Do something.
      Operation response = future.get();
    }
  }
}
// [END policysimulator_v1_generated_Simulator_CreateReplay_async]
