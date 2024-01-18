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

/**
 * A client to Policy Simulator API
 *
 * <p>The interfaces provided are listed below, along with usage samples.
 *
 * <p>======================= SimulatorClient =======================
 *
 * <p>Service Description: Policy Simulator API service.
 *
 * <p>Policy Simulator is a collection of endpoints for creating, running, and viewing a
 * [Replay][google.cloud.policysimulator.v1.Replay]. A
 * [Replay][google.cloud.policysimulator.v1.Replay] is a type of simulation that lets you see how
 * your principals' access to resources might change if you changed your IAM policy.
 *
 * <p>During a [Replay][google.cloud.policysimulator.v1.Replay], Policy Simulator re-evaluates, or
 * replays, past access attempts under both the current policy and your proposed policy, and
 * compares those results to determine how your principals' access might change under the proposed
 * policy.
 *
 * <p>Sample for SimulatorClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (SimulatorClient simulatorClient = SimulatorClient.create()) {
 *   ReplayName name =
 *       ReplayName.ofProjectLocationReplayName("[PROJECT]", "[LOCATION]", "[REPLAY]");
 *   Replay response = simulatorClient.getReplay(name);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.cloud.policysimulator.v1;

import javax.annotation.Generated;
