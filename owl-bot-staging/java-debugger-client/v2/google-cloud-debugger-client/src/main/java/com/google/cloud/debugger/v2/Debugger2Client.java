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
import com.google.cloud.debugger.v2.stub.Debugger2Stub;
import com.google.cloud.debugger.v2.stub.Debugger2StubSettings;
import com.google.devtools.clouddebugger.v2.Breakpoint;
import com.google.devtools.clouddebugger.v2.DeleteBreakpointRequest;
import com.google.devtools.clouddebugger.v2.GetBreakpointRequest;
import com.google.devtools.clouddebugger.v2.GetBreakpointResponse;
import com.google.devtools.clouddebugger.v2.ListBreakpointsRequest;
import com.google.devtools.clouddebugger.v2.ListBreakpointsResponse;
import com.google.devtools.clouddebugger.v2.ListDebuggeesRequest;
import com.google.devtools.clouddebugger.v2.ListDebuggeesResponse;
import com.google.devtools.clouddebugger.v2.SetBreakpointRequest;
import com.google.devtools.clouddebugger.v2.SetBreakpointResponse;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The Debugger service provides the API that allows users to collect run-time
 * information from a running application, without stopping or slowing it down and without modifying
 * its state. An application may include one or more replicated processes performing the same work.
 *
 * <p>A debugged application is represented using the Debuggee concept. The Debugger service
 * provides a way to query for available debuggees, but does not provide a way to create one. A
 * debuggee is created using the Controller service, usually by running a debugger agent with the
 * application.
 *
 * <p>The Debugger service enables the client to set one or more Breakpoints on a Debuggee and
 * collect the results of the set Breakpoints.
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
 * try (Debugger2Client debugger2Client = Debugger2Client.create()) {
 *   String debuggeeId = "debuggeeId-1833285553";
 *   Breakpoint breakpoint = Breakpoint.newBuilder().build();
 *   String clientVersion = "clientVersion771880589";
 *   SetBreakpointResponse response =
 *       debugger2Client.setBreakpoint(debuggeeId, breakpoint, clientVersion);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the Debugger2Client object to clean up resources such as
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
 * <p>This class can be customized by passing in a custom instance of Debugger2Settings to create().
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
 * Debugger2Settings debugger2Settings =
 *     Debugger2Settings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * Debugger2Client debugger2Client = Debugger2Client.create(debugger2Settings);
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
 * Debugger2Settings debugger2Settings =
 *     Debugger2Settings.newBuilder().setEndpoint(myEndpoint).build();
 * Debugger2Client debugger2Client = Debugger2Client.create(debugger2Settings);
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
 * Debugger2Settings debugger2Settings = Debugger2Settings.newHttpJsonBuilder().build();
 * Debugger2Client debugger2Client = Debugger2Client.create(debugger2Settings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class Debugger2Client implements BackgroundResource {
  private final Debugger2Settings settings;
  private final Debugger2Stub stub;

  /** Constructs an instance of Debugger2Client with default settings. */
  public static final Debugger2Client create() throws IOException {
    return create(Debugger2Settings.newBuilder().build());
  }

  /**
   * Constructs an instance of Debugger2Client, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final Debugger2Client create(Debugger2Settings settings) throws IOException {
    return new Debugger2Client(settings);
  }

  /**
   * Constructs an instance of Debugger2Client, using the given stub for making calls. This is for
   * advanced usage - prefer using create(Debugger2Settings).
   */
  public static final Debugger2Client create(Debugger2Stub stub) {
    return new Debugger2Client(stub);
  }

  /**
   * Constructs an instance of Debugger2Client, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected Debugger2Client(Debugger2Settings settings) throws IOException {
    this.settings = settings;
    this.stub = ((Debugger2StubSettings) settings.getStubSettings()).createStub();
  }

  protected Debugger2Client(Debugger2Stub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final Debugger2Settings getSettings() {
    return settings;
  }

  public Debugger2Stub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the breakpoint to the debuggee.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (Debugger2Client debugger2Client = Debugger2Client.create()) {
   *   String debuggeeId = "debuggeeId-1833285553";
   *   Breakpoint breakpoint = Breakpoint.newBuilder().build();
   *   String clientVersion = "clientVersion771880589";
   *   SetBreakpointResponse response =
   *       debugger2Client.setBreakpoint(debuggeeId, breakpoint, clientVersion);
   * }
   * }</pre>
   *
   * @param debuggeeId Required. ID of the debuggee where the breakpoint is to be set.
   * @param breakpoint Required. Breakpoint specification to set. The field `location` of the
   *     breakpoint must be set.
   * @param clientVersion Required. The client version making the call. Schema:
   *     `domain/type/version` (e.g., `google.com/intellij/v1`).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SetBreakpointResponse setBreakpoint(
      String debuggeeId, Breakpoint breakpoint, String clientVersion) {
    SetBreakpointRequest request =
        SetBreakpointRequest.newBuilder()
            .setDebuggeeId(debuggeeId)
            .setBreakpoint(breakpoint)
            .setClientVersion(clientVersion)
            .build();
    return setBreakpoint(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the breakpoint to the debuggee.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (Debugger2Client debugger2Client = Debugger2Client.create()) {
   *   SetBreakpointRequest request =
   *       SetBreakpointRequest.newBuilder()
   *           .setDebuggeeId("debuggeeId-1833285553")
   *           .setBreakpoint(Breakpoint.newBuilder().build())
   *           .setClientVersion("clientVersion771880589")
   *           .build();
   *   SetBreakpointResponse response = debugger2Client.setBreakpoint(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SetBreakpointResponse setBreakpoint(SetBreakpointRequest request) {
    return setBreakpointCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the breakpoint to the debuggee.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (Debugger2Client debugger2Client = Debugger2Client.create()) {
   *   SetBreakpointRequest request =
   *       SetBreakpointRequest.newBuilder()
   *           .setDebuggeeId("debuggeeId-1833285553")
   *           .setBreakpoint(Breakpoint.newBuilder().build())
   *           .setClientVersion("clientVersion771880589")
   *           .build();
   *   ApiFuture<SetBreakpointResponse> future =
   *       debugger2Client.setBreakpointCallable().futureCall(request);
   *   // Do something.
   *   SetBreakpointResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SetBreakpointRequest, SetBreakpointResponse> setBreakpointCallable() {
    return stub.setBreakpointCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets breakpoint information.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (Debugger2Client debugger2Client = Debugger2Client.create()) {
   *   String debuggeeId = "debuggeeId-1833285553";
   *   String breakpointId = "breakpointId570266860";
   *   String clientVersion = "clientVersion771880589";
   *   GetBreakpointResponse response =
   *       debugger2Client.getBreakpoint(debuggeeId, breakpointId, clientVersion);
   * }
   * }</pre>
   *
   * @param debuggeeId Required. ID of the debuggee whose breakpoint to get.
   * @param breakpointId Required. ID of the breakpoint to get.
   * @param clientVersion Required. The client version making the call. Schema:
   *     `domain/type/version` (e.g., `google.com/intellij/v1`).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GetBreakpointResponse getBreakpoint(
      String debuggeeId, String breakpointId, String clientVersion) {
    GetBreakpointRequest request =
        GetBreakpointRequest.newBuilder()
            .setDebuggeeId(debuggeeId)
            .setBreakpointId(breakpointId)
            .setClientVersion(clientVersion)
            .build();
    return getBreakpoint(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets breakpoint information.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (Debugger2Client debugger2Client = Debugger2Client.create()) {
   *   GetBreakpointRequest request =
   *       GetBreakpointRequest.newBuilder()
   *           .setDebuggeeId("debuggeeId-1833285553")
   *           .setBreakpointId("breakpointId570266860")
   *           .setClientVersion("clientVersion771880589")
   *           .build();
   *   GetBreakpointResponse response = debugger2Client.getBreakpoint(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GetBreakpointResponse getBreakpoint(GetBreakpointRequest request) {
    return getBreakpointCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets breakpoint information.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (Debugger2Client debugger2Client = Debugger2Client.create()) {
   *   GetBreakpointRequest request =
   *       GetBreakpointRequest.newBuilder()
   *           .setDebuggeeId("debuggeeId-1833285553")
   *           .setBreakpointId("breakpointId570266860")
   *           .setClientVersion("clientVersion771880589")
   *           .build();
   *   ApiFuture<GetBreakpointResponse> future =
   *       debugger2Client.getBreakpointCallable().futureCall(request);
   *   // Do something.
   *   GetBreakpointResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetBreakpointRequest, GetBreakpointResponse> getBreakpointCallable() {
    return stub.getBreakpointCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the breakpoint from the debuggee.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (Debugger2Client debugger2Client = Debugger2Client.create()) {
   *   String debuggeeId = "debuggeeId-1833285553";
   *   String breakpointId = "breakpointId570266860";
   *   String clientVersion = "clientVersion771880589";
   *   debugger2Client.deleteBreakpoint(debuggeeId, breakpointId, clientVersion);
   * }
   * }</pre>
   *
   * @param debuggeeId Required. ID of the debuggee whose breakpoint to delete.
   * @param breakpointId Required. ID of the breakpoint to delete.
   * @param clientVersion Required. The client version making the call. Schema:
   *     `domain/type/version` (e.g., `google.com/intellij/v1`).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteBreakpoint(String debuggeeId, String breakpointId, String clientVersion) {
    DeleteBreakpointRequest request =
        DeleteBreakpointRequest.newBuilder()
            .setDebuggeeId(debuggeeId)
            .setBreakpointId(breakpointId)
            .setClientVersion(clientVersion)
            .build();
    deleteBreakpoint(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the breakpoint from the debuggee.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (Debugger2Client debugger2Client = Debugger2Client.create()) {
   *   DeleteBreakpointRequest request =
   *       DeleteBreakpointRequest.newBuilder()
   *           .setDebuggeeId("debuggeeId-1833285553")
   *           .setBreakpointId("breakpointId570266860")
   *           .setClientVersion("clientVersion771880589")
   *           .build();
   *   debugger2Client.deleteBreakpoint(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteBreakpoint(DeleteBreakpointRequest request) {
    deleteBreakpointCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the breakpoint from the debuggee.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (Debugger2Client debugger2Client = Debugger2Client.create()) {
   *   DeleteBreakpointRequest request =
   *       DeleteBreakpointRequest.newBuilder()
   *           .setDebuggeeId("debuggeeId-1833285553")
   *           .setBreakpointId("breakpointId570266860")
   *           .setClientVersion("clientVersion771880589")
   *           .build();
   *   ApiFuture<Empty> future = debugger2Client.deleteBreakpointCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteBreakpointRequest, Empty> deleteBreakpointCallable() {
    return stub.deleteBreakpointCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all breakpoints for the debuggee.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (Debugger2Client debugger2Client = Debugger2Client.create()) {
   *   String debuggeeId = "debuggeeId-1833285553";
   *   String clientVersion = "clientVersion771880589";
   *   ListBreakpointsResponse response = debugger2Client.listBreakpoints(debuggeeId, clientVersion);
   * }
   * }</pre>
   *
   * @param debuggeeId Required. ID of the debuggee whose breakpoints to list.
   * @param clientVersion Required. The client version making the call. Schema:
   *     `domain/type/version` (e.g., `google.com/intellij/v1`).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBreakpointsResponse listBreakpoints(String debuggeeId, String clientVersion) {
    ListBreakpointsRequest request =
        ListBreakpointsRequest.newBuilder()
            .setDebuggeeId(debuggeeId)
            .setClientVersion(clientVersion)
            .build();
    return listBreakpoints(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all breakpoints for the debuggee.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (Debugger2Client debugger2Client = Debugger2Client.create()) {
   *   ListBreakpointsRequest request =
   *       ListBreakpointsRequest.newBuilder()
   *           .setDebuggeeId("debuggeeId-1833285553")
   *           .setIncludeAllUsers(true)
   *           .setIncludeInactive(true)
   *           .setAction(ListBreakpointsRequest.BreakpointActionValue.newBuilder().build())
   *           .setStripResults(true)
   *           .setWaitToken("waitToken-984229500")
   *           .setClientVersion("clientVersion771880589")
   *           .build();
   *   ListBreakpointsResponse response = debugger2Client.listBreakpoints(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBreakpointsResponse listBreakpoints(ListBreakpointsRequest request) {
    return listBreakpointsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all breakpoints for the debuggee.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (Debugger2Client debugger2Client = Debugger2Client.create()) {
   *   ListBreakpointsRequest request =
   *       ListBreakpointsRequest.newBuilder()
   *           .setDebuggeeId("debuggeeId-1833285553")
   *           .setIncludeAllUsers(true)
   *           .setIncludeInactive(true)
   *           .setAction(ListBreakpointsRequest.BreakpointActionValue.newBuilder().build())
   *           .setStripResults(true)
   *           .setWaitToken("waitToken-984229500")
   *           .setClientVersion("clientVersion771880589")
   *           .build();
   *   ApiFuture<ListBreakpointsResponse> future =
   *       debugger2Client.listBreakpointsCallable().futureCall(request);
   *   // Do something.
   *   ListBreakpointsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ListBreakpointsRequest, ListBreakpointsResponse>
      listBreakpointsCallable() {
    return stub.listBreakpointsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the debuggees that the user has access to.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (Debugger2Client debugger2Client = Debugger2Client.create()) {
   *   String project = "project-309310695";
   *   String clientVersion = "clientVersion771880589";
   *   ListDebuggeesResponse response = debugger2Client.listDebuggees(project, clientVersion);
   * }
   * }</pre>
   *
   * @param project Required. Project number of a Google Cloud project whose debuggees to list.
   * @param clientVersion Required. The client version making the call. Schema:
   *     `domain/type/version` (e.g., `google.com/intellij/v1`).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDebuggeesResponse listDebuggees(String project, String clientVersion) {
    ListDebuggeesRequest request =
        ListDebuggeesRequest.newBuilder()
            .setProject(project)
            .setClientVersion(clientVersion)
            .build();
    return listDebuggees(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the debuggees that the user has access to.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (Debugger2Client debugger2Client = Debugger2Client.create()) {
   *   ListDebuggeesRequest request =
   *       ListDebuggeesRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setIncludeInactive(true)
   *           .setClientVersion("clientVersion771880589")
   *           .build();
   *   ListDebuggeesResponse response = debugger2Client.listDebuggees(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDebuggeesResponse listDebuggees(ListDebuggeesRequest request) {
    return listDebuggeesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the debuggees that the user has access to.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (Debugger2Client debugger2Client = Debugger2Client.create()) {
   *   ListDebuggeesRequest request =
   *       ListDebuggeesRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setIncludeInactive(true)
   *           .setClientVersion("clientVersion771880589")
   *           .build();
   *   ApiFuture<ListDebuggeesResponse> future =
   *       debugger2Client.listDebuggeesCallable().futureCall(request);
   *   // Do something.
   *   ListDebuggeesResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ListDebuggeesRequest, ListDebuggeesResponse> listDebuggeesCallable() {
    return stub.listDebuggeesCallable();
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
