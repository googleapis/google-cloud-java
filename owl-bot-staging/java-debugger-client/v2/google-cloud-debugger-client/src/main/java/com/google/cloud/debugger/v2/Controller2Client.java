/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.debugger.v2;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.debugger.v2.stub.Controller2Stub;
import com.google.cloud.debugger.v2.stub.Controller2StubSettings;
import com.google.devtools.clouddebugger.v2.Breakpoint;
import com.google.devtools.clouddebugger.v2.Debuggee;
import com.google.devtools.clouddebugger.v2.ListActiveBreakpointsRequest;
import com.google.devtools.clouddebugger.v2.ListActiveBreakpointsResponse;
import com.google.devtools.clouddebugger.v2.RegisterDebuggeeRequest;
import com.google.devtools.clouddebugger.v2.RegisterDebuggeeResponse;
import com.google.devtools.clouddebugger.v2.UpdateActiveBreakpointRequest;
import com.google.devtools.clouddebugger.v2.UpdateActiveBreakpointResponse;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The Controller service provides the API for orchestrating a collection of
 * debugger agents to perform debugging tasks. These agents are each attached to a process of an
 * application which may include one or more replicas.
 *
 * <p>The debugger agents register with the Controller to identify the application being debugged,
 * the Debuggee. All agents that register with the same data, represent the same Debuggee, and are
 * assigned the same `debuggee_id`.
 *
 * <p>The debugger agents call the Controller to retrieve the list of active Breakpoints. Agents
 * with the same `debuggee_id` get the same breakpoints list. An agent that can fulfill the
 * breakpoint request updates the Controller with the breakpoint result. The controller selects the
 * first result received and discards the rest of the results. Agents that poll again for active
 * breakpoints will no longer have the completed breakpoint in the list and should remove that
 * breakpoint from their attached process.
 *
 * <p>The Controller service does not provide a way to retrieve the results of a completed
 * breakpoint. This functionality is available using the Debugger service.
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
 * try (Controller2Client controller2Client = Controller2Client.create()) {
 *   Debuggee debuggee = Debuggee.newBuilder().build();
 *   RegisterDebuggeeResponse response = controller2Client.registerDebuggee(debuggee);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the Controller2Client object to clean up resources such as
 * threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <p>The surface of this class includes several types of Java methods for each of the API's
 * methods:
 *
 * <ol>
 *   <li>A "flattened" method. With this type of method, the fields of the request type have been
 *       converted into function parameters. It may be the case that not all fields are available as
 *       parameters, and not every API method will have a flattened method entry point.
 *   <li>A "request object" method. This type of method only takes one parameter, a request object,
 *       which must be constructed before the call. Not every API method will have a request object
 *       method.
 *   <li>A "callable" method. This type of method takes no parameters and returns an immutable API
 *       callable object, which can be used to initiate calls to the service.
 * </ol>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist with
 * these names, this class includes a format method for each type of name, and additionally a parse
 * method to extract the individual identifiers contained within names that are returned.
 *
 * <p>This class can be customized by passing in a custom instance of Controller2Settings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * Controller2Settings controller2Settings =
 *     Controller2Settings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * Controller2Client controller2Client = Controller2Client.create(controller2Settings);
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
 * Controller2Settings controller2Settings =
 *     Controller2Settings.newBuilder().setEndpoint(myEndpoint).build();
 * Controller2Client controller2Client = Controller2Client.create(controller2Settings);
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
 * Controller2Settings controller2Settings = Controller2Settings.newHttpJsonBuilder().build();
 * Controller2Client controller2Client = Controller2Client.create(controller2Settings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class Controller2Client implements BackgroundResource {
  private final Controller2Settings settings;
  private final Controller2Stub stub;

  /** Constructs an instance of Controller2Client with default settings. */
  public static final Controller2Client create() throws IOException {
    return create(Controller2Settings.newBuilder().build());
  }

  /**
   * Constructs an instance of Controller2Client, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final Controller2Client create(Controller2Settings settings) throws IOException {
    return new Controller2Client(settings);
  }

  /**
   * Constructs an instance of Controller2Client, using the given stub for making calls. This is for
   * advanced usage - prefer using create(Controller2Settings).
   */
  public static final Controller2Client create(Controller2Stub stub) {
    return new Controller2Client(stub);
  }

  /**
   * Constructs an instance of Controller2Client, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected Controller2Client(Controller2Settings settings) throws IOException {
    this.settings = settings;
    this.stub = ((Controller2StubSettings) settings.getStubSettings()).createStub();
  }

  protected Controller2Client(Controller2Stub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final Controller2Settings getSettings() {
    return settings;
  }

  public Controller2Stub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Registers the debuggee with the controller service.
   *
   * <p>All agents attached to the same application must call this method with exactly the same
   * request content to get back the same stable `debuggee_id`. Agents should call this method again
   * whenever `google.rpc.Code.NOT_FOUND` is returned from any controller method.
   *
   * <p>This protocol allows the controller service to disable debuggees, recover from data loss, or
   * change the `debuggee_id` format. Agents must handle `debuggee_id` value changing upon
   * re-registration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (Controller2Client controller2Client = Controller2Client.create()) {
   *   Debuggee debuggee = Debuggee.newBuilder().build();
   *   RegisterDebuggeeResponse response = controller2Client.registerDebuggee(debuggee);
   * }
   * }</pre>
   *
   * @param debuggee Required. Debuggee information to register. The fields `project`, `uniquifier`,
   *     `description` and `agent_version` of the debuggee must be set.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RegisterDebuggeeResponse registerDebuggee(Debuggee debuggee) {
    RegisterDebuggeeRequest request =
        RegisterDebuggeeRequest.newBuilder().setDebuggee(debuggee).build();
    return registerDebuggee(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Registers the debuggee with the controller service.
   *
   * <p>All agents attached to the same application must call this method with exactly the same
   * request content to get back the same stable `debuggee_id`. Agents should call this method again
   * whenever `google.rpc.Code.NOT_FOUND` is returned from any controller method.
   *
   * <p>This protocol allows the controller service to disable debuggees, recover from data loss, or
   * change the `debuggee_id` format. Agents must handle `debuggee_id` value changing upon
   * re-registration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (Controller2Client controller2Client = Controller2Client.create()) {
   *   RegisterDebuggeeRequest request =
   *       RegisterDebuggeeRequest.newBuilder().setDebuggee(Debuggee.newBuilder().build()).build();
   *   RegisterDebuggeeResponse response = controller2Client.registerDebuggee(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RegisterDebuggeeResponse registerDebuggee(RegisterDebuggeeRequest request) {
    return registerDebuggeeCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Registers the debuggee with the controller service.
   *
   * <p>All agents attached to the same application must call this method with exactly the same
   * request content to get back the same stable `debuggee_id`. Agents should call this method again
   * whenever `google.rpc.Code.NOT_FOUND` is returned from any controller method.
   *
   * <p>This protocol allows the controller service to disable debuggees, recover from data loss, or
   * change the `debuggee_id` format. Agents must handle `debuggee_id` value changing upon
   * re-registration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (Controller2Client controller2Client = Controller2Client.create()) {
   *   RegisterDebuggeeRequest request =
   *       RegisterDebuggeeRequest.newBuilder().setDebuggee(Debuggee.newBuilder().build()).build();
   *   ApiFuture<RegisterDebuggeeResponse> future =
   *       controller2Client.registerDebuggeeCallable().futureCall(request);
   *   // Do something.
   *   RegisterDebuggeeResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RegisterDebuggeeRequest, RegisterDebuggeeResponse>
      registerDebuggeeCallable() {
    return stub.registerDebuggeeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of all active breakpoints for the debuggee.
   *
   * <p>The breakpoint specification (`location`, `condition`, and `expressions` fields) is
   * semantically immutable, although the field values may change. For example, an agent may update
   * the location line number to reflect the actual line where the breakpoint was set, but this
   * doesn't change the breakpoint semantics.
   *
   * <p>This means that an agent does not need to check if a breakpoint has changed when it
   * encounters the same breakpoint on a successive call. Moreover, an agent should remember the
   * breakpoints that are completed until the controller removes them from the active list to avoid
   * setting those breakpoints again.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (Controller2Client controller2Client = Controller2Client.create()) {
   *   String debuggeeId = "debuggeeId-1833285553";
   *   ListActiveBreakpointsResponse response = controller2Client.listActiveBreakpoints(debuggeeId);
   * }
   * }</pre>
   *
   * @param debuggeeId Required. Identifies the debuggee.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListActiveBreakpointsResponse listActiveBreakpoints(String debuggeeId) {
    ListActiveBreakpointsRequest request =
        ListActiveBreakpointsRequest.newBuilder().setDebuggeeId(debuggeeId).build();
    return listActiveBreakpoints(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of all active breakpoints for the debuggee.
   *
   * <p>The breakpoint specification (`location`, `condition`, and `expressions` fields) is
   * semantically immutable, although the field values may change. For example, an agent may update
   * the location line number to reflect the actual line where the breakpoint was set, but this
   * doesn't change the breakpoint semantics.
   *
   * <p>This means that an agent does not need to check if a breakpoint has changed when it
   * encounters the same breakpoint on a successive call. Moreover, an agent should remember the
   * breakpoints that are completed until the controller removes them from the active list to avoid
   * setting those breakpoints again.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (Controller2Client controller2Client = Controller2Client.create()) {
   *   ListActiveBreakpointsRequest request =
   *       ListActiveBreakpointsRequest.newBuilder()
   *           .setDebuggeeId("debuggeeId-1833285553")
   *           .setWaitToken("waitToken-984229500")
   *           .setSuccessOnTimeout(true)
   *           .build();
   *   ListActiveBreakpointsResponse response = controller2Client.listActiveBreakpoints(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListActiveBreakpointsResponse listActiveBreakpoints(
      ListActiveBreakpointsRequest request) {
    return listActiveBreakpointsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of all active breakpoints for the debuggee.
   *
   * <p>The breakpoint specification (`location`, `condition`, and `expressions` fields) is
   * semantically immutable, although the field values may change. For example, an agent may update
   * the location line number to reflect the actual line where the breakpoint was set, but this
   * doesn't change the breakpoint semantics.
   *
   * <p>This means that an agent does not need to check if a breakpoint has changed when it
   * encounters the same breakpoint on a successive call. Moreover, an agent should remember the
   * breakpoints that are completed until the controller removes them from the active list to avoid
   * setting those breakpoints again.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (Controller2Client controller2Client = Controller2Client.create()) {
   *   ListActiveBreakpointsRequest request =
   *       ListActiveBreakpointsRequest.newBuilder()
   *           .setDebuggeeId("debuggeeId-1833285553")
   *           .setWaitToken("waitToken-984229500")
   *           .setSuccessOnTimeout(true)
   *           .build();
   *   ApiFuture<ListActiveBreakpointsResponse> future =
   *       controller2Client.listActiveBreakpointsCallable().futureCall(request);
   *   // Do something.
   *   ListActiveBreakpointsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ListActiveBreakpointsRequest, ListActiveBreakpointsResponse>
      listActiveBreakpointsCallable() {
    return stub.listActiveBreakpointsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the breakpoint state or mutable fields. The entire Breakpoint message must be sent back
   * to the controller service.
   *
   * <p>Updates to active breakpoint fields are only allowed if the new value does not change the
   * breakpoint specification. Updates to the `location`, `condition` and `expressions` fields
   * should not alter the breakpoint semantics. These may only make changes such as canonicalizing a
   * value or snapping the location to the correct line of code.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (Controller2Client controller2Client = Controller2Client.create()) {
   *   String debuggeeId = "debuggeeId-1833285553";
   *   Breakpoint breakpoint = Breakpoint.newBuilder().build();
   *   UpdateActiveBreakpointResponse response =
   *       controller2Client.updateActiveBreakpoint(debuggeeId, breakpoint);
   * }
   * }</pre>
   *
   * @param debuggeeId Required. Identifies the debuggee being debugged.
   * @param breakpoint Required. Updated breakpoint information. The field `id` must be set. The
   *     agent must echo all Breakpoint specification fields in the update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UpdateActiveBreakpointResponse updateActiveBreakpoint(
      String debuggeeId, Breakpoint breakpoint) {
    UpdateActiveBreakpointRequest request =
        UpdateActiveBreakpointRequest.newBuilder()
            .setDebuggeeId(debuggeeId)
            .setBreakpoint(breakpoint)
            .build();
    return updateActiveBreakpoint(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the breakpoint state or mutable fields. The entire Breakpoint message must be sent back
   * to the controller service.
   *
   * <p>Updates to active breakpoint fields are only allowed if the new value does not change the
   * breakpoint specification. Updates to the `location`, `condition` and `expressions` fields
   * should not alter the breakpoint semantics. These may only make changes such as canonicalizing a
   * value or snapping the location to the correct line of code.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (Controller2Client controller2Client = Controller2Client.create()) {
   *   UpdateActiveBreakpointRequest request =
   *       UpdateActiveBreakpointRequest.newBuilder()
   *           .setDebuggeeId("debuggeeId-1833285553")
   *           .setBreakpoint(Breakpoint.newBuilder().build())
   *           .build();
   *   UpdateActiveBreakpointResponse response = controller2Client.updateActiveBreakpoint(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UpdateActiveBreakpointResponse updateActiveBreakpoint(
      UpdateActiveBreakpointRequest request) {
    return updateActiveBreakpointCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the breakpoint state or mutable fields. The entire Breakpoint message must be sent back
   * to the controller service.
   *
   * <p>Updates to active breakpoint fields are only allowed if the new value does not change the
   * breakpoint specification. Updates to the `location`, `condition` and `expressions` fields
   * should not alter the breakpoint semantics. These may only make changes such as canonicalizing a
   * value or snapping the location to the correct line of code.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (Controller2Client controller2Client = Controller2Client.create()) {
   *   UpdateActiveBreakpointRequest request =
   *       UpdateActiveBreakpointRequest.newBuilder()
   *           .setDebuggeeId("debuggeeId-1833285553")
   *           .setBreakpoint(Breakpoint.newBuilder().build())
   *           .build();
   *   ApiFuture<UpdateActiveBreakpointResponse> future =
   *       controller2Client.updateActiveBreakpointCallable().futureCall(request);
   *   // Do something.
   *   UpdateActiveBreakpointResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateActiveBreakpointRequest, UpdateActiveBreakpointResponse>
      updateActiveBreakpointCallable() {
    return stub.updateActiveBreakpointCallable();
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
}
