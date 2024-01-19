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

package com.google.cloud.policysimulator.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.httpjson.longrunning.OperationsClient;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.policysimulator.v1.stub.SimulatorStub;
import com.google.cloud.policysimulator.v1.stub.SimulatorStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.longrunning.Operation;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Policy Simulator API service.
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
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
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
 *
 * <p>Note: close() needs to be called on the SimulatorClient object to clean up resources such as
 * threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> GetReplay</td>
 *      <td><p> Gets the specified [Replay][google.cloud.policysimulator.v1.Replay]. Each `Replay` is available for at least 7 days.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getReplay(GetReplayRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getReplay(ReplayName name)
 *           <li><p> getReplay(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getReplayCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateReplay</td>
 *      <td><p> Creates and starts a [Replay][google.cloud.policysimulator.v1.Replay] using the given [ReplayConfig][google.cloud.policysimulator.v1.ReplayConfig].</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createReplayAsync(CreateReplayRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createReplayAsync(String parent, Replay replay)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createReplayOperationCallable()
 *           <li><p> createReplayCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListReplayResults</td>
 *      <td><p> Lists the results of running a [Replay][google.cloud.policysimulator.v1.Replay].</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listReplayResults(ListReplayResultsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listReplayResults(ReplayName parent)
 *           <li><p> listReplayResults(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listReplayResultsPagedCallable()
 *           <li><p> listReplayResultsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *  </table>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist with
 * these names, this class includes a format method for each type of name, and additionally a parse
 * method to extract the individual identifiers contained within names that are returned.
 *
 * <p>This class can be customized by passing in a custom instance of SimulatorSettings to create().
 * For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * SimulatorSettings simulatorSettings =
 *     SimulatorSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * SimulatorClient simulatorClient = SimulatorClient.create(simulatorSettings);
 * }</pre>
 *
 * <p>To customize the endpoint:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * SimulatorSettings simulatorSettings =
 *     SimulatorSettings.newBuilder().setEndpoint(myEndpoint).build();
 * SimulatorClient simulatorClient = SimulatorClient.create(simulatorSettings);
 * }</pre>
 *
 * <p>To use REST (HTTP1.1/JSON) transport (instead of gRPC) for sending and receiving requests over
 * the wire:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * SimulatorSettings simulatorSettings = SimulatorSettings.newHttpJsonBuilder().build();
 * SimulatorClient simulatorClient = SimulatorClient.create(simulatorSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class SimulatorClient implements BackgroundResource {
  private final SimulatorSettings settings;
  private final SimulatorStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of SimulatorClient with default settings. */
  public static final SimulatorClient create() throws IOException {
    return create(SimulatorSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of SimulatorClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final SimulatorClient create(SimulatorSettings settings) throws IOException {
    return new SimulatorClient(settings);
  }

  /**
   * Constructs an instance of SimulatorClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(SimulatorSettings).
   */
  public static final SimulatorClient create(SimulatorStub stub) {
    return new SimulatorClient(stub);
  }

  /**
   * Constructs an instance of SimulatorClient, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected SimulatorClient(SimulatorSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((SimulatorStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected SimulatorClient(SimulatorStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final SimulatorSettings getSettings() {
    return settings;
  }

  public SimulatorStub getStub() {
    return stub;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  public final com.google.longrunning.OperationsClient getOperationsClient() {
    return operationsClient;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  @BetaApi
  public final OperationsClient getHttpJsonOperationsClient() {
    return httpJsonOperationsClient;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the specified [Replay][google.cloud.policysimulator.v1.Replay]. Each `Replay` is available
   * for at least 7 days.
   *
   * <p>Sample code:
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
   *
   * @param name Required. The name of the [Replay][google.cloud.policysimulator.v1.Replay] to
   *     retrieve, in the following format:
   *     <p>`{projects|folders|organizations}/{resource-id}/locations/global/replays/{replay-id}`,
   *     where `{resource-id}` is the ID of the project, folder, or organization that owns the
   *     `Replay`.
   *     <p>Example:
   *     `projects/my-example-project/locations/global/replays/506a5f7f-38ce-4d7d-8e03-479ce1833c36`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Replay getReplay(ReplayName name) {
    GetReplayRequest request =
        GetReplayRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getReplay(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the specified [Replay][google.cloud.policysimulator.v1.Replay]. Each `Replay` is available
   * for at least 7 days.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SimulatorClient simulatorClient = SimulatorClient.create()) {
   *   String name =
   *       ReplayName.ofProjectLocationReplayName("[PROJECT]", "[LOCATION]", "[REPLAY]").toString();
   *   Replay response = simulatorClient.getReplay(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the [Replay][google.cloud.policysimulator.v1.Replay] to
   *     retrieve, in the following format:
   *     <p>`{projects|folders|organizations}/{resource-id}/locations/global/replays/{replay-id}`,
   *     where `{resource-id}` is the ID of the project, folder, or organization that owns the
   *     `Replay`.
   *     <p>Example:
   *     `projects/my-example-project/locations/global/replays/506a5f7f-38ce-4d7d-8e03-479ce1833c36`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Replay getReplay(String name) {
    GetReplayRequest request = GetReplayRequest.newBuilder().setName(name).build();
    return getReplay(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the specified [Replay][google.cloud.policysimulator.v1.Replay]. Each `Replay` is available
   * for at least 7 days.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SimulatorClient simulatorClient = SimulatorClient.create()) {
   *   GetReplayRequest request =
   *       GetReplayRequest.newBuilder()
   *           .setName(
   *               ReplayName.ofProjectLocationReplayName("[PROJECT]", "[LOCATION]", "[REPLAY]")
   *                   .toString())
   *           .build();
   *   Replay response = simulatorClient.getReplay(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Replay getReplay(GetReplayRequest request) {
    return getReplayCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the specified [Replay][google.cloud.policysimulator.v1.Replay]. Each `Replay` is available
   * for at least 7 days.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SimulatorClient simulatorClient = SimulatorClient.create()) {
   *   GetReplayRequest request =
   *       GetReplayRequest.newBuilder()
   *           .setName(
   *               ReplayName.ofProjectLocationReplayName("[PROJECT]", "[LOCATION]", "[REPLAY]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Replay> future = simulatorClient.getReplayCallable().futureCall(request);
   *   // Do something.
   *   Replay response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetReplayRequest, Replay> getReplayCallable() {
    return stub.getReplayCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates and starts a [Replay][google.cloud.policysimulator.v1.Replay] using the given
   * [ReplayConfig][google.cloud.policysimulator.v1.ReplayConfig].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SimulatorClient simulatorClient = SimulatorClient.create()) {
   *   String parent = "parent-995424086";
   *   Replay replay = Replay.newBuilder().build();
   *   Replay response = simulatorClient.createReplayAsync(parent, replay).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this
   *     [Replay][google.cloud.policysimulator.v1.Replay] will be created. This resource must be a
   *     project, folder, or organization with a location.
   *     <p>Example: `projects/my-example-project/locations/global`
   * @param replay Required. The [Replay][google.cloud.policysimulator.v1.Replay] to create. Set
   *     `Replay.ReplayConfig` to configure the replay.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Replay, ReplayOperationMetadata> createReplayAsync(
      String parent, Replay replay) {
    CreateReplayRequest request =
        CreateReplayRequest.newBuilder().setParent(parent).setReplay(replay).build();
    return createReplayAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates and starts a [Replay][google.cloud.policysimulator.v1.Replay] using the given
   * [ReplayConfig][google.cloud.policysimulator.v1.ReplayConfig].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SimulatorClient simulatorClient = SimulatorClient.create()) {
   *   CreateReplayRequest request =
   *       CreateReplayRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setReplay(Replay.newBuilder().build())
   *           .build();
   *   Replay response = simulatorClient.createReplayAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Replay, ReplayOperationMetadata> createReplayAsync(
      CreateReplayRequest request) {
    return createReplayOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates and starts a [Replay][google.cloud.policysimulator.v1.Replay] using the given
   * [ReplayConfig][google.cloud.policysimulator.v1.ReplayConfig].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SimulatorClient simulatorClient = SimulatorClient.create()) {
   *   CreateReplayRequest request =
   *       CreateReplayRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setReplay(Replay.newBuilder().build())
   *           .build();
   *   OperationFuture<Replay, ReplayOperationMetadata> future =
   *       simulatorClient.createReplayOperationCallable().futureCall(request);
   *   // Do something.
   *   Replay response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateReplayRequest, Replay, ReplayOperationMetadata>
      createReplayOperationCallable() {
    return stub.createReplayOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates and starts a [Replay][google.cloud.policysimulator.v1.Replay] using the given
   * [ReplayConfig][google.cloud.policysimulator.v1.ReplayConfig].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SimulatorClient simulatorClient = SimulatorClient.create()) {
   *   CreateReplayRequest request =
   *       CreateReplayRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setReplay(Replay.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = simulatorClient.createReplayCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateReplayRequest, Operation> createReplayCallable() {
    return stub.createReplayCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the results of running a [Replay][google.cloud.policysimulator.v1.Replay].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SimulatorClient simulatorClient = SimulatorClient.create()) {
   *   ReplayName parent =
   *       ReplayName.ofProjectLocationReplayName("[PROJECT]", "[LOCATION]", "[REPLAY]");
   *   for (ReplayResult element : simulatorClient.listReplayResults(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The [Replay][google.cloud.policysimulator.v1.Replay] whose results are
   *     listed, in the following format:
   *     <p>`{projects|folders|organizations}/{resource-id}/locations/global/replays/{replay-id}`
   *     <p>Example:
   *     `projects/my-project/locations/global/replays/506a5f7f-38ce-4d7d-8e03-479ce1833c36`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListReplayResultsPagedResponse listReplayResults(ReplayName parent) {
    ListReplayResultsRequest request =
        ListReplayResultsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listReplayResults(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the results of running a [Replay][google.cloud.policysimulator.v1.Replay].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SimulatorClient simulatorClient = SimulatorClient.create()) {
   *   String parent =
   *       ReplayName.ofProjectLocationReplayName("[PROJECT]", "[LOCATION]", "[REPLAY]").toString();
   *   for (ReplayResult element : simulatorClient.listReplayResults(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The [Replay][google.cloud.policysimulator.v1.Replay] whose results are
   *     listed, in the following format:
   *     <p>`{projects|folders|organizations}/{resource-id}/locations/global/replays/{replay-id}`
   *     <p>Example:
   *     `projects/my-project/locations/global/replays/506a5f7f-38ce-4d7d-8e03-479ce1833c36`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListReplayResultsPagedResponse listReplayResults(String parent) {
    ListReplayResultsRequest request =
        ListReplayResultsRequest.newBuilder().setParent(parent).build();
    return listReplayResults(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the results of running a [Replay][google.cloud.policysimulator.v1.Replay].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SimulatorClient simulatorClient = SimulatorClient.create()) {
   *   ListReplayResultsRequest request =
   *       ListReplayResultsRequest.newBuilder()
   *           .setParent(
   *               ReplayName.ofProjectLocationReplayName("[PROJECT]", "[LOCATION]", "[REPLAY]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (ReplayResult element : simulatorClient.listReplayResults(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListReplayResultsPagedResponse listReplayResults(ListReplayResultsRequest request) {
    return listReplayResultsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the results of running a [Replay][google.cloud.policysimulator.v1.Replay].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SimulatorClient simulatorClient = SimulatorClient.create()) {
   *   ListReplayResultsRequest request =
   *       ListReplayResultsRequest.newBuilder()
   *           .setParent(
   *               ReplayName.ofProjectLocationReplayName("[PROJECT]", "[LOCATION]", "[REPLAY]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<ReplayResult> future =
   *       simulatorClient.listReplayResultsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (ReplayResult element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListReplayResultsRequest, ListReplayResultsPagedResponse>
      listReplayResultsPagedCallable() {
    return stub.listReplayResultsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the results of running a [Replay][google.cloud.policysimulator.v1.Replay].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SimulatorClient simulatorClient = SimulatorClient.create()) {
   *   ListReplayResultsRequest request =
   *       ListReplayResultsRequest.newBuilder()
   *           .setParent(
   *               ReplayName.ofProjectLocationReplayName("[PROJECT]", "[LOCATION]", "[REPLAY]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListReplayResultsResponse response =
   *         simulatorClient.listReplayResultsCallable().call(request);
   *     for (ReplayResult element : response.getReplayResultsList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListReplayResultsRequest, ListReplayResultsResponse>
      listReplayResultsCallable() {
    return stub.listReplayResultsCallable();
  }

  @Override
  public final void close() {
    stub.close();
  }

  @Override
  public void shutdown() {
    stub.shutdown();
  }

  @Override
  public boolean isShutdown() {
    return stub.isShutdown();
  }

  @Override
  public boolean isTerminated() {
    return stub.isTerminated();
  }

  @Override
  public void shutdownNow() {
    stub.shutdownNow();
  }

  @Override
  public boolean awaitTermination(long duration, TimeUnit unit) throws InterruptedException {
    return stub.awaitTermination(duration, unit);
  }

  public static class ListReplayResultsPagedResponse
      extends AbstractPagedListResponse<
          ListReplayResultsRequest,
          ListReplayResultsResponse,
          ReplayResult,
          ListReplayResultsPage,
          ListReplayResultsFixedSizeCollection> {

    public static ApiFuture<ListReplayResultsPagedResponse> createAsync(
        PageContext<ListReplayResultsRequest, ListReplayResultsResponse, ReplayResult> context,
        ApiFuture<ListReplayResultsResponse> futureResponse) {
      ApiFuture<ListReplayResultsPage> futurePage =
          ListReplayResultsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListReplayResultsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListReplayResultsPagedResponse(ListReplayResultsPage page) {
      super(page, ListReplayResultsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListReplayResultsPage
      extends AbstractPage<
          ListReplayResultsRequest,
          ListReplayResultsResponse,
          ReplayResult,
          ListReplayResultsPage> {

    private ListReplayResultsPage(
        PageContext<ListReplayResultsRequest, ListReplayResultsResponse, ReplayResult> context,
        ListReplayResultsResponse response) {
      super(context, response);
    }

    private static ListReplayResultsPage createEmptyPage() {
      return new ListReplayResultsPage(null, null);
    }

    @Override
    protected ListReplayResultsPage createPage(
        PageContext<ListReplayResultsRequest, ListReplayResultsResponse, ReplayResult> context,
        ListReplayResultsResponse response) {
      return new ListReplayResultsPage(context, response);
    }

    @Override
    public ApiFuture<ListReplayResultsPage> createPageAsync(
        PageContext<ListReplayResultsRequest, ListReplayResultsResponse, ReplayResult> context,
        ApiFuture<ListReplayResultsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListReplayResultsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListReplayResultsRequest,
          ListReplayResultsResponse,
          ReplayResult,
          ListReplayResultsPage,
          ListReplayResultsFixedSizeCollection> {

    private ListReplayResultsFixedSizeCollection(
        List<ListReplayResultsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListReplayResultsFixedSizeCollection createEmptyCollection() {
      return new ListReplayResultsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListReplayResultsFixedSizeCollection createCollection(
        List<ListReplayResultsPage> pages, int collectionSize) {
      return new ListReplayResultsFixedSizeCollection(pages, collectionSize);
    }
  }
}
