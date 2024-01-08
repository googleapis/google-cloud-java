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

package com.google.cloud.datacatalog.lineage.v1;

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
import com.google.cloud.datacatalog.lineage.v1.stub.LineageStub;
import com.google.cloud.datacatalog.lineage.v1.stub.LineageStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Struct;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Lineage is used to track data flows between assets over time. You can create
 * [LineageEvents][google.cloud.datacatalog.lineage.v1.LineageEvent] to record lineage between
 * multiple sources and a single target, for example, when table data is based on data from multiple
 * tables.
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
 * try (LineageClient lineageClient = LineageClient.create()) {
 *   String parent = "parent-995424086";
 *   Struct openLineage = Struct.newBuilder().build();
 *   ProcessOpenLineageRunEventResponse response =
 *       lineageClient.processOpenLineageRunEvent(parent, openLineage);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the LineageClient object to clean up resources such as
 * threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <table>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    <tr>
 *      <td>ProcessOpenLineageRunEvent</td>
 *      <td><p> Creates new lineage events together with their parents: process and run. Updates the process and run if they already exist. Mapped from Open Lineage specification: https://github.com/OpenLineage/OpenLineage/blob/main/spec/OpenLineage.json.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>processOpenLineageRunEvent(ProcessOpenLineageRunEventRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>processOpenLineageRunEvent(String parent, Struct openLineage)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>processOpenLineageRunEventCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>CreateProcess</td>
 *      <td><p> Creates a new process.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>createProcess(CreateProcessRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>createProcess(LocationName parent, Process process)
 *           <li>createProcess(String parent, Process process)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>createProcessCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>UpdateProcess</td>
 *      <td><p> Updates a process.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>updateProcess(UpdateProcessRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>updateProcess(Process process, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>updateProcessCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>GetProcess</td>
 *      <td><p> Gets the details of the specified process.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>getProcess(GetProcessRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>getProcess(ProcessName name)
 *           <li>getProcess(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>getProcessCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>ListProcesses</td>
 *      <td><p> List processes in the given project and location. List order is descending by insertion time.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>listProcesses(ListProcessesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>listProcesses(LocationName parent)
 *           <li>listProcesses(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>listProcessesPagedCallable()
 *           <li>listProcessesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>DeleteProcess</td>
 *      <td><p> Deletes the process with the specified name.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>deleteProcessAsync(DeleteProcessRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li>deleteProcessAsync(ProcessName name)
 *           <li>deleteProcessAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>deleteProcessOperationCallable()
 *           <li>deleteProcessCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>CreateRun</td>
 *      <td><p> Creates a new run.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>createRun(CreateRunRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>createRun(ProcessName parent, Run run)
 *           <li>createRun(String parent, Run run)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>createRunCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>UpdateRun</td>
 *      <td><p> Updates a run.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>updateRun(UpdateRunRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>updateRun(Run run, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>updateRunCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>GetRun</td>
 *      <td><p> Gets the details of the specified run.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>getRun(GetRunRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>getRun(RunName name)
 *           <li>getRun(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>getRunCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>ListRuns</td>
 *      <td><p> Lists runs in the given project and location. List order is descending by `start_time`.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>listRuns(ListRunsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>listRuns(ProcessName parent)
 *           <li>listRuns(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>listRunsPagedCallable()
 *           <li>listRunsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>DeleteRun</td>
 *      <td><p> Deletes the run with the specified name.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>deleteRunAsync(DeleteRunRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li>deleteRunAsync(RunName name)
 *           <li>deleteRunAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>deleteRunOperationCallable()
 *           <li>deleteRunCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>CreateLineageEvent</td>
 *      <td><p> Creates a new lineage event.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>createLineageEvent(CreateLineageEventRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>createLineageEvent(RunName parent, LineageEvent lineageEvent)
 *           <li>createLineageEvent(String parent, LineageEvent lineageEvent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>createLineageEventCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>GetLineageEvent</td>
 *      <td><p> Gets details of a specified lineage event.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>getLineageEvent(GetLineageEventRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>getLineageEvent(LineageEventName name)
 *           <li>getLineageEvent(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>getLineageEventCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>ListLineageEvents</td>
 *      <td><p> Lists lineage events in the given project and location. The list order is not defined.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>listLineageEvents(ListLineageEventsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>listLineageEvents(RunName parent)
 *           <li>listLineageEvents(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>listLineageEventsPagedCallable()
 *           <li>listLineageEventsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>DeleteLineageEvent</td>
 *      <td><p> Deletes the lineage event with the specified name.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>deleteLineageEvent(DeleteLineageEventRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>deleteLineageEvent(LineageEventName name)
 *           <li>deleteLineageEvent(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>deleteLineageEventCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>SearchLinks</td>
 *      <td><p> Retrieve a list of links connected to a specific asset. Links represent the data flow between &#42;&#42;source&#42;&#42; (upstream) and &#42;&#42;target&#42;&#42; (downstream) assets in transformation pipelines. Links are stored in the same project as the Lineage Events that create them.
 * <p>  You can retrieve links in every project where you have the `datalineage.events.get` permission. The project provided in the URL is used for Billing and Quota.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>searchLinks(SearchLinksRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>searchLinksPagedCallable()
 *           <li>searchLinksCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>BatchSearchLinkProcesses</td>
 *      <td><p> Retrieve information about LineageProcesses associated with specific links. LineageProcesses are transformation pipelines that result in data flowing from &#42;&#42;source&#42;&#42; to &#42;&#42;target&#42;&#42; assets. Links between assets represent this operation.
 * <p>  If you have specific link names, you can use this method to verify which LineageProcesses contribute to creating those links. See the [SearchLinks][google.cloud.datacatalog.lineage.v1.Lineage.SearchLinks] method for more information on how to retrieve link name.
 * <p>  You can retrieve the LineageProcess information in every project where you have the `datalineage.events.get` permission. The project provided in the URL is used for Billing and Quota.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>batchSearchLinkProcesses(BatchSearchLinkProcessesRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>batchSearchLinkProcessesPagedCallable()
 *           <li>batchSearchLinkProcessesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    </tr>
 *  </table>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist with
 * these names, this class includes a format method for each type of name, and additionally a parse
 * method to extract the individual identifiers contained within names that are returned.
 *
 * <p>This class can be customized by passing in a custom instance of LineageSettings to create().
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
 * LineageSettings lineageSettings =
 *     LineageSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * LineageClient lineageClient = LineageClient.create(lineageSettings);
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
 * LineageSettings lineageSettings = LineageSettings.newBuilder().setEndpoint(myEndpoint).build();
 * LineageClient lineageClient = LineageClient.create(lineageSettings);
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
 * LineageSettings lineageSettings = LineageSettings.newHttpJsonBuilder().build();
 * LineageClient lineageClient = LineageClient.create(lineageSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class LineageClient implements BackgroundResource {
  private final LineageSettings settings;
  private final LineageStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of LineageClient with default settings. */
  public static final LineageClient create() throws IOException {
    return create(LineageSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of LineageClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final LineageClient create(LineageSettings settings) throws IOException {
    return new LineageClient(settings);
  }

  /**
   * Constructs an instance of LineageClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(LineageSettings).
   */
  public static final LineageClient create(LineageStub stub) {
    return new LineageClient(stub);
  }

  /**
   * Constructs an instance of LineageClient, using the given settings. This is protected so that it
   * is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected LineageClient(LineageSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((LineageStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected LineageClient(LineageStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final LineageSettings getSettings() {
    return settings;
  }

  public LineageStub getStub() {
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
   * Creates new lineage events together with their parents: process and run. Updates the process
   * and run if they already exist. Mapped from Open Lineage specification:
   * https://github.com/OpenLineage/OpenLineage/blob/main/spec/OpenLineage.json.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineageClient lineageClient = LineageClient.create()) {
   *   String parent = "parent-995424086";
   *   Struct openLineage = Struct.newBuilder().build();
   *   ProcessOpenLineageRunEventResponse response =
   *       lineageClient.processOpenLineageRunEvent(parent, openLineage);
   * }
   * }</pre>
   *
   * @param parent Required. The name of the project and its location that should own the process,
   *     run, and lineage event.
   * @param openLineage Required. OpenLineage message following OpenLineage format:
   *     https://github.com/OpenLineage/OpenLineage/blob/main/spec/OpenLineage.json
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ProcessOpenLineageRunEventResponse processOpenLineageRunEvent(
      String parent, Struct openLineage) {
    ProcessOpenLineageRunEventRequest request =
        ProcessOpenLineageRunEventRequest.newBuilder()
            .setParent(parent)
            .setOpenLineage(openLineage)
            .build();
    return processOpenLineageRunEvent(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates new lineage events together with their parents: process and run. Updates the process
   * and run if they already exist. Mapped from Open Lineage specification:
   * https://github.com/OpenLineage/OpenLineage/blob/main/spec/OpenLineage.json.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineageClient lineageClient = LineageClient.create()) {
   *   ProcessOpenLineageRunEventRequest request =
   *       ProcessOpenLineageRunEventRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setOpenLineage(Struct.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ProcessOpenLineageRunEventResponse response =
   *       lineageClient.processOpenLineageRunEvent(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ProcessOpenLineageRunEventResponse processOpenLineageRunEvent(
      ProcessOpenLineageRunEventRequest request) {
    return processOpenLineageRunEventCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates new lineage events together with their parents: process and run. Updates the process
   * and run if they already exist. Mapped from Open Lineage specification:
   * https://github.com/OpenLineage/OpenLineage/blob/main/spec/OpenLineage.json.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineageClient lineageClient = LineageClient.create()) {
   *   ProcessOpenLineageRunEventRequest request =
   *       ProcessOpenLineageRunEventRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setOpenLineage(Struct.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<ProcessOpenLineageRunEventResponse> future =
   *       lineageClient.processOpenLineageRunEventCallable().futureCall(request);
   *   // Do something.
   *   ProcessOpenLineageRunEventResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ProcessOpenLineageRunEventRequest, ProcessOpenLineageRunEventResponse>
      processOpenLineageRunEventCallable() {
    return stub.processOpenLineageRunEventCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new process.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineageClient lineageClient = LineageClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Process process = Process.newBuilder().build();
   *   Process response = lineageClient.createProcess(parent, process);
   * }
   * }</pre>
   *
   * @param parent Required. The name of the project and its location that should own the process.
   * @param process Required. The process to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Process createProcess(LocationName parent, Process process) {
    CreateProcessRequest request =
        CreateProcessRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setProcess(process)
            .build();
    return createProcess(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new process.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineageClient lineageClient = LineageClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Process process = Process.newBuilder().build();
   *   Process response = lineageClient.createProcess(parent, process);
   * }
   * }</pre>
   *
   * @param parent Required. The name of the project and its location that should own the process.
   * @param process Required. The process to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Process createProcess(String parent, Process process) {
    CreateProcessRequest request =
        CreateProcessRequest.newBuilder().setParent(parent).setProcess(process).build();
    return createProcess(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new process.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineageClient lineageClient = LineageClient.create()) {
   *   CreateProcessRequest request =
   *       CreateProcessRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setProcess(Process.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Process response = lineageClient.createProcess(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Process createProcess(CreateProcessRequest request) {
    return createProcessCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new process.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineageClient lineageClient = LineageClient.create()) {
   *   CreateProcessRequest request =
   *       CreateProcessRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setProcess(Process.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Process> future = lineageClient.createProcessCallable().futureCall(request);
   *   // Do something.
   *   Process response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateProcessRequest, Process> createProcessCallable() {
    return stub.createProcessCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a process.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineageClient lineageClient = LineageClient.create()) {
   *   Process process = Process.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Process response = lineageClient.updateProcess(process, updateMask);
   * }
   * }</pre>
   *
   * @param process Required. The lineage process to update.
   *     <p>The process's `name` field is used to identify the process to update.
   * @param updateMask The list of fields to update. Currently not used. The whole message is
   *     updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Process updateProcess(Process process, FieldMask updateMask) {
    UpdateProcessRequest request =
        UpdateProcessRequest.newBuilder().setProcess(process).setUpdateMask(updateMask).build();
    return updateProcess(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a process.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineageClient lineageClient = LineageClient.create()) {
   *   UpdateProcessRequest request =
   *       UpdateProcessRequest.newBuilder()
   *           .setProcess(Process.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setAllowMissing(true)
   *           .build();
   *   Process response = lineageClient.updateProcess(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Process updateProcess(UpdateProcessRequest request) {
    return updateProcessCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a process.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineageClient lineageClient = LineageClient.create()) {
   *   UpdateProcessRequest request =
   *       UpdateProcessRequest.newBuilder()
   *           .setProcess(Process.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setAllowMissing(true)
   *           .build();
   *   ApiFuture<Process> future = lineageClient.updateProcessCallable().futureCall(request);
   *   // Do something.
   *   Process response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateProcessRequest, Process> updateProcessCallable() {
    return stub.updateProcessCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of the specified process.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineageClient lineageClient = LineageClient.create()) {
   *   ProcessName name = ProcessName.of("[PROJECT]", "[LOCATION]", "[PROCESS]");
   *   Process response = lineageClient.getProcess(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the process to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Process getProcess(ProcessName name) {
    GetProcessRequest request =
        GetProcessRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getProcess(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of the specified process.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineageClient lineageClient = LineageClient.create()) {
   *   String name = ProcessName.of("[PROJECT]", "[LOCATION]", "[PROCESS]").toString();
   *   Process response = lineageClient.getProcess(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the process to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Process getProcess(String name) {
    GetProcessRequest request = GetProcessRequest.newBuilder().setName(name).build();
    return getProcess(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of the specified process.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineageClient lineageClient = LineageClient.create()) {
   *   GetProcessRequest request =
   *       GetProcessRequest.newBuilder()
   *           .setName(ProcessName.of("[PROJECT]", "[LOCATION]", "[PROCESS]").toString())
   *           .build();
   *   Process response = lineageClient.getProcess(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Process getProcess(GetProcessRequest request) {
    return getProcessCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of the specified process.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineageClient lineageClient = LineageClient.create()) {
   *   GetProcessRequest request =
   *       GetProcessRequest.newBuilder()
   *           .setName(ProcessName.of("[PROJECT]", "[LOCATION]", "[PROCESS]").toString())
   *           .build();
   *   ApiFuture<Process> future = lineageClient.getProcessCallable().futureCall(request);
   *   // Do something.
   *   Process response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetProcessRequest, Process> getProcessCallable() {
    return stub.getProcessCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List processes in the given project and location. List order is descending by insertion time.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineageClient lineageClient = LineageClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Process element : lineageClient.listProcesses(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The name of the project and its location that owns this collection of
   *     processes.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListProcessesPagedResponse listProcesses(LocationName parent) {
    ListProcessesRequest request =
        ListProcessesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listProcesses(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List processes in the given project and location. List order is descending by insertion time.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineageClient lineageClient = LineageClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Process element : lineageClient.listProcesses(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The name of the project and its location that owns this collection of
   *     processes.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListProcessesPagedResponse listProcesses(String parent) {
    ListProcessesRequest request = ListProcessesRequest.newBuilder().setParent(parent).build();
    return listProcesses(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List processes in the given project and location. List order is descending by insertion time.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineageClient lineageClient = LineageClient.create()) {
   *   ListProcessesRequest request =
   *       ListProcessesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Process element : lineageClient.listProcesses(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListProcessesPagedResponse listProcesses(ListProcessesRequest request) {
    return listProcessesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List processes in the given project and location. List order is descending by insertion time.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineageClient lineageClient = LineageClient.create()) {
   *   ListProcessesRequest request =
   *       ListProcessesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Process> future = lineageClient.listProcessesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Process element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListProcessesRequest, ListProcessesPagedResponse>
      listProcessesPagedCallable() {
    return stub.listProcessesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List processes in the given project and location. List order is descending by insertion time.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineageClient lineageClient = LineageClient.create()) {
   *   ListProcessesRequest request =
   *       ListProcessesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListProcessesResponse response = lineageClient.listProcessesCallable().call(request);
   *     for (Process element : response.getProcessesList()) {
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
  public final UnaryCallable<ListProcessesRequest, ListProcessesResponse> listProcessesCallable() {
    return stub.listProcessesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the process with the specified name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineageClient lineageClient = LineageClient.create()) {
   *   ProcessName name = ProcessName.of("[PROJECT]", "[LOCATION]", "[PROCESS]");
   *   lineageClient.deleteProcessAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the process to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteProcessAsync(ProcessName name) {
    DeleteProcessRequest request =
        DeleteProcessRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteProcessAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the process with the specified name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineageClient lineageClient = LineageClient.create()) {
   *   String name = ProcessName.of("[PROJECT]", "[LOCATION]", "[PROCESS]").toString();
   *   lineageClient.deleteProcessAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the process to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteProcessAsync(String name) {
    DeleteProcessRequest request = DeleteProcessRequest.newBuilder().setName(name).build();
    return deleteProcessAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the process with the specified name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineageClient lineageClient = LineageClient.create()) {
   *   DeleteProcessRequest request =
   *       DeleteProcessRequest.newBuilder()
   *           .setName(ProcessName.of("[PROJECT]", "[LOCATION]", "[PROCESS]").toString())
   *           .setAllowMissing(true)
   *           .build();
   *   lineageClient.deleteProcessAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteProcessAsync(
      DeleteProcessRequest request) {
    return deleteProcessOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the process with the specified name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineageClient lineageClient = LineageClient.create()) {
   *   DeleteProcessRequest request =
   *       DeleteProcessRequest.newBuilder()
   *           .setName(ProcessName.of("[PROJECT]", "[LOCATION]", "[PROCESS]").toString())
   *           .setAllowMissing(true)
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       lineageClient.deleteProcessOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteProcessRequest, Empty, OperationMetadata>
      deleteProcessOperationCallable() {
    return stub.deleteProcessOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the process with the specified name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineageClient lineageClient = LineageClient.create()) {
   *   DeleteProcessRequest request =
   *       DeleteProcessRequest.newBuilder()
   *           .setName(ProcessName.of("[PROJECT]", "[LOCATION]", "[PROCESS]").toString())
   *           .setAllowMissing(true)
   *           .build();
   *   ApiFuture<Operation> future = lineageClient.deleteProcessCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteProcessRequest, Operation> deleteProcessCallable() {
    return stub.deleteProcessCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new run.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineageClient lineageClient = LineageClient.create()) {
   *   ProcessName parent = ProcessName.of("[PROJECT]", "[LOCATION]", "[PROCESS]");
   *   Run run = Run.newBuilder().build();
   *   Run response = lineageClient.createRun(parent, run);
   * }
   * }</pre>
   *
   * @param parent Required. The name of the process that should own the run.
   * @param run Required. The run to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Run createRun(ProcessName parent, Run run) {
    CreateRunRequest request =
        CreateRunRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setRun(run)
            .build();
    return createRun(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new run.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineageClient lineageClient = LineageClient.create()) {
   *   String parent = ProcessName.of("[PROJECT]", "[LOCATION]", "[PROCESS]").toString();
   *   Run run = Run.newBuilder().build();
   *   Run response = lineageClient.createRun(parent, run);
   * }
   * }</pre>
   *
   * @param parent Required. The name of the process that should own the run.
   * @param run Required. The run to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Run createRun(String parent, Run run) {
    CreateRunRequest request = CreateRunRequest.newBuilder().setParent(parent).setRun(run).build();
    return createRun(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new run.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineageClient lineageClient = LineageClient.create()) {
   *   CreateRunRequest request =
   *       CreateRunRequest.newBuilder()
   *           .setParent(ProcessName.of("[PROJECT]", "[LOCATION]", "[PROCESS]").toString())
   *           .setRun(Run.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Run response = lineageClient.createRun(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Run createRun(CreateRunRequest request) {
    return createRunCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new run.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineageClient lineageClient = LineageClient.create()) {
   *   CreateRunRequest request =
   *       CreateRunRequest.newBuilder()
   *           .setParent(ProcessName.of("[PROJECT]", "[LOCATION]", "[PROCESS]").toString())
   *           .setRun(Run.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Run> future = lineageClient.createRunCallable().futureCall(request);
   *   // Do something.
   *   Run response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateRunRequest, Run> createRunCallable() {
    return stub.createRunCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a run.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineageClient lineageClient = LineageClient.create()) {
   *   Run run = Run.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Run response = lineageClient.updateRun(run, updateMask);
   * }
   * }</pre>
   *
   * @param run Required. The lineage run to update.
   *     <p>The run's `name` field is used to identify the run to update.
   *     <p>Format: `projects/{project}/locations/{location}/processes/{process}/runs/{run}`.
   * @param updateMask The list of fields to update. Currently not used. The whole message is
   *     updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Run updateRun(Run run, FieldMask updateMask) {
    UpdateRunRequest request =
        UpdateRunRequest.newBuilder().setRun(run).setUpdateMask(updateMask).build();
    return updateRun(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a run.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineageClient lineageClient = LineageClient.create()) {
   *   UpdateRunRequest request =
   *       UpdateRunRequest.newBuilder()
   *           .setRun(Run.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setAllowMissing(true)
   *           .build();
   *   Run response = lineageClient.updateRun(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Run updateRun(UpdateRunRequest request) {
    return updateRunCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a run.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineageClient lineageClient = LineageClient.create()) {
   *   UpdateRunRequest request =
   *       UpdateRunRequest.newBuilder()
   *           .setRun(Run.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setAllowMissing(true)
   *           .build();
   *   ApiFuture<Run> future = lineageClient.updateRunCallable().futureCall(request);
   *   // Do something.
   *   Run response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateRunRequest, Run> updateRunCallable() {
    return stub.updateRunCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of the specified run.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineageClient lineageClient = LineageClient.create()) {
   *   RunName name = RunName.of("[PROJECT]", "[LOCATION]", "[PROCESS]", "[RUN]");
   *   Run response = lineageClient.getRun(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the run to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Run getRun(RunName name) {
    GetRunRequest request =
        GetRunRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getRun(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of the specified run.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineageClient lineageClient = LineageClient.create()) {
   *   String name = RunName.of("[PROJECT]", "[LOCATION]", "[PROCESS]", "[RUN]").toString();
   *   Run response = lineageClient.getRun(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the run to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Run getRun(String name) {
    GetRunRequest request = GetRunRequest.newBuilder().setName(name).build();
    return getRun(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of the specified run.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineageClient lineageClient = LineageClient.create()) {
   *   GetRunRequest request =
   *       GetRunRequest.newBuilder()
   *           .setName(RunName.of("[PROJECT]", "[LOCATION]", "[PROCESS]", "[RUN]").toString())
   *           .build();
   *   Run response = lineageClient.getRun(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Run getRun(GetRunRequest request) {
    return getRunCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of the specified run.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineageClient lineageClient = LineageClient.create()) {
   *   GetRunRequest request =
   *       GetRunRequest.newBuilder()
   *           .setName(RunName.of("[PROJECT]", "[LOCATION]", "[PROCESS]", "[RUN]").toString())
   *           .build();
   *   ApiFuture<Run> future = lineageClient.getRunCallable().futureCall(request);
   *   // Do something.
   *   Run response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetRunRequest, Run> getRunCallable() {
    return stub.getRunCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists runs in the given project and location. List order is descending by `start_time`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineageClient lineageClient = LineageClient.create()) {
   *   ProcessName parent = ProcessName.of("[PROJECT]", "[LOCATION]", "[PROCESS]");
   *   for (Run element : lineageClient.listRuns(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The name of process that owns this collection of runs.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRunsPagedResponse listRuns(ProcessName parent) {
    ListRunsRequest request =
        ListRunsRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listRuns(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists runs in the given project and location. List order is descending by `start_time`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineageClient lineageClient = LineageClient.create()) {
   *   String parent = ProcessName.of("[PROJECT]", "[LOCATION]", "[PROCESS]").toString();
   *   for (Run element : lineageClient.listRuns(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The name of process that owns this collection of runs.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRunsPagedResponse listRuns(String parent) {
    ListRunsRequest request = ListRunsRequest.newBuilder().setParent(parent).build();
    return listRuns(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists runs in the given project and location. List order is descending by `start_time`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineageClient lineageClient = LineageClient.create()) {
   *   ListRunsRequest request =
   *       ListRunsRequest.newBuilder()
   *           .setParent(ProcessName.of("[PROJECT]", "[LOCATION]", "[PROCESS]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Run element : lineageClient.listRuns(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRunsPagedResponse listRuns(ListRunsRequest request) {
    return listRunsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists runs in the given project and location. List order is descending by `start_time`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineageClient lineageClient = LineageClient.create()) {
   *   ListRunsRequest request =
   *       ListRunsRequest.newBuilder()
   *           .setParent(ProcessName.of("[PROJECT]", "[LOCATION]", "[PROCESS]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Run> future = lineageClient.listRunsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Run element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListRunsRequest, ListRunsPagedResponse> listRunsPagedCallable() {
    return stub.listRunsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists runs in the given project and location. List order is descending by `start_time`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineageClient lineageClient = LineageClient.create()) {
   *   ListRunsRequest request =
   *       ListRunsRequest.newBuilder()
   *           .setParent(ProcessName.of("[PROJECT]", "[LOCATION]", "[PROCESS]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListRunsResponse response = lineageClient.listRunsCallable().call(request);
   *     for (Run element : response.getRunsList()) {
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
  public final UnaryCallable<ListRunsRequest, ListRunsResponse> listRunsCallable() {
    return stub.listRunsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the run with the specified name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineageClient lineageClient = LineageClient.create()) {
   *   RunName name = RunName.of("[PROJECT]", "[LOCATION]", "[PROCESS]", "[RUN]");
   *   lineageClient.deleteRunAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the run to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteRunAsync(RunName name) {
    DeleteRunRequest request =
        DeleteRunRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteRunAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the run with the specified name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineageClient lineageClient = LineageClient.create()) {
   *   String name = RunName.of("[PROJECT]", "[LOCATION]", "[PROCESS]", "[RUN]").toString();
   *   lineageClient.deleteRunAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the run to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteRunAsync(String name) {
    DeleteRunRequest request = DeleteRunRequest.newBuilder().setName(name).build();
    return deleteRunAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the run with the specified name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineageClient lineageClient = LineageClient.create()) {
   *   DeleteRunRequest request =
   *       DeleteRunRequest.newBuilder()
   *           .setName(RunName.of("[PROJECT]", "[LOCATION]", "[PROCESS]", "[RUN]").toString())
   *           .setAllowMissing(true)
   *           .build();
   *   lineageClient.deleteRunAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteRunAsync(DeleteRunRequest request) {
    return deleteRunOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the run with the specified name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineageClient lineageClient = LineageClient.create()) {
   *   DeleteRunRequest request =
   *       DeleteRunRequest.newBuilder()
   *           .setName(RunName.of("[PROJECT]", "[LOCATION]", "[PROCESS]", "[RUN]").toString())
   *           .setAllowMissing(true)
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       lineageClient.deleteRunOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteRunRequest, Empty, OperationMetadata>
      deleteRunOperationCallable() {
    return stub.deleteRunOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the run with the specified name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineageClient lineageClient = LineageClient.create()) {
   *   DeleteRunRequest request =
   *       DeleteRunRequest.newBuilder()
   *           .setName(RunName.of("[PROJECT]", "[LOCATION]", "[PROCESS]", "[RUN]").toString())
   *           .setAllowMissing(true)
   *           .build();
   *   ApiFuture<Operation> future = lineageClient.deleteRunCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteRunRequest, Operation> deleteRunCallable() {
    return stub.deleteRunCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new lineage event.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineageClient lineageClient = LineageClient.create()) {
   *   RunName parent = RunName.of("[PROJECT]", "[LOCATION]", "[PROCESS]", "[RUN]");
   *   LineageEvent lineageEvent = LineageEvent.newBuilder().build();
   *   LineageEvent response = lineageClient.createLineageEvent(parent, lineageEvent);
   * }
   * }</pre>
   *
   * @param parent Required. The name of the run that should own the lineage event.
   * @param lineageEvent Required. The lineage event to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LineageEvent createLineageEvent(RunName parent, LineageEvent lineageEvent) {
    CreateLineageEventRequest request =
        CreateLineageEventRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setLineageEvent(lineageEvent)
            .build();
    return createLineageEvent(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new lineage event.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineageClient lineageClient = LineageClient.create()) {
   *   String parent = RunName.of("[PROJECT]", "[LOCATION]", "[PROCESS]", "[RUN]").toString();
   *   LineageEvent lineageEvent = LineageEvent.newBuilder().build();
   *   LineageEvent response = lineageClient.createLineageEvent(parent, lineageEvent);
   * }
   * }</pre>
   *
   * @param parent Required. The name of the run that should own the lineage event.
   * @param lineageEvent Required. The lineage event to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LineageEvent createLineageEvent(String parent, LineageEvent lineageEvent) {
    CreateLineageEventRequest request =
        CreateLineageEventRequest.newBuilder()
            .setParent(parent)
            .setLineageEvent(lineageEvent)
            .build();
    return createLineageEvent(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new lineage event.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineageClient lineageClient = LineageClient.create()) {
   *   CreateLineageEventRequest request =
   *       CreateLineageEventRequest.newBuilder()
   *           .setParent(RunName.of("[PROJECT]", "[LOCATION]", "[PROCESS]", "[RUN]").toString())
   *           .setLineageEvent(LineageEvent.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   LineageEvent response = lineageClient.createLineageEvent(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LineageEvent createLineageEvent(CreateLineageEventRequest request) {
    return createLineageEventCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new lineage event.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineageClient lineageClient = LineageClient.create()) {
   *   CreateLineageEventRequest request =
   *       CreateLineageEventRequest.newBuilder()
   *           .setParent(RunName.of("[PROJECT]", "[LOCATION]", "[PROCESS]", "[RUN]").toString())
   *           .setLineageEvent(LineageEvent.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<LineageEvent> future =
   *       lineageClient.createLineageEventCallable().futureCall(request);
   *   // Do something.
   *   LineageEvent response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateLineageEventRequest, LineageEvent> createLineageEventCallable() {
    return stub.createLineageEventCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a specified lineage event.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineageClient lineageClient = LineageClient.create()) {
   *   LineageEventName name =
   *       LineageEventName.of("[PROJECT]", "[LOCATION]", "[PROCESS]", "[RUN]", "[LINEAGE_EVENT]");
   *   LineageEvent response = lineageClient.getLineageEvent(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the lineage event to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LineageEvent getLineageEvent(LineageEventName name) {
    GetLineageEventRequest request =
        GetLineageEventRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getLineageEvent(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a specified lineage event.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineageClient lineageClient = LineageClient.create()) {
   *   String name =
   *       LineageEventName.of("[PROJECT]", "[LOCATION]", "[PROCESS]", "[RUN]", "[LINEAGE_EVENT]")
   *           .toString();
   *   LineageEvent response = lineageClient.getLineageEvent(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the lineage event to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LineageEvent getLineageEvent(String name) {
    GetLineageEventRequest request = GetLineageEventRequest.newBuilder().setName(name).build();
    return getLineageEvent(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a specified lineage event.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineageClient lineageClient = LineageClient.create()) {
   *   GetLineageEventRequest request =
   *       GetLineageEventRequest.newBuilder()
   *           .setName(
   *               LineageEventName.of(
   *                       "[PROJECT]", "[LOCATION]", "[PROCESS]", "[RUN]", "[LINEAGE_EVENT]")
   *                   .toString())
   *           .build();
   *   LineageEvent response = lineageClient.getLineageEvent(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LineageEvent getLineageEvent(GetLineageEventRequest request) {
    return getLineageEventCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a specified lineage event.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineageClient lineageClient = LineageClient.create()) {
   *   GetLineageEventRequest request =
   *       GetLineageEventRequest.newBuilder()
   *           .setName(
   *               LineageEventName.of(
   *                       "[PROJECT]", "[LOCATION]", "[PROCESS]", "[RUN]", "[LINEAGE_EVENT]")
   *                   .toString())
   *           .build();
   *   ApiFuture<LineageEvent> future = lineageClient.getLineageEventCallable().futureCall(request);
   *   // Do something.
   *   LineageEvent response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetLineageEventRequest, LineageEvent> getLineageEventCallable() {
    return stub.getLineageEventCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists lineage events in the given project and location. The list order is not defined.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineageClient lineageClient = LineageClient.create()) {
   *   RunName parent = RunName.of("[PROJECT]", "[LOCATION]", "[PROCESS]", "[RUN]");
   *   for (LineageEvent element : lineageClient.listLineageEvents(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The name of the run that owns the collection of lineage events to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLineageEventsPagedResponse listLineageEvents(RunName parent) {
    ListLineageEventsRequest request =
        ListLineageEventsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listLineageEvents(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists lineage events in the given project and location. The list order is not defined.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineageClient lineageClient = LineageClient.create()) {
   *   String parent = RunName.of("[PROJECT]", "[LOCATION]", "[PROCESS]", "[RUN]").toString();
   *   for (LineageEvent element : lineageClient.listLineageEvents(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The name of the run that owns the collection of lineage events to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLineageEventsPagedResponse listLineageEvents(String parent) {
    ListLineageEventsRequest request =
        ListLineageEventsRequest.newBuilder().setParent(parent).build();
    return listLineageEvents(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists lineage events in the given project and location. The list order is not defined.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineageClient lineageClient = LineageClient.create()) {
   *   ListLineageEventsRequest request =
   *       ListLineageEventsRequest.newBuilder()
   *           .setParent(RunName.of("[PROJECT]", "[LOCATION]", "[PROCESS]", "[RUN]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (LineageEvent element : lineageClient.listLineageEvents(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLineageEventsPagedResponse listLineageEvents(ListLineageEventsRequest request) {
    return listLineageEventsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists lineage events in the given project and location. The list order is not defined.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineageClient lineageClient = LineageClient.create()) {
   *   ListLineageEventsRequest request =
   *       ListLineageEventsRequest.newBuilder()
   *           .setParent(RunName.of("[PROJECT]", "[LOCATION]", "[PROCESS]", "[RUN]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<LineageEvent> future =
   *       lineageClient.listLineageEventsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (LineageEvent element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListLineageEventsRequest, ListLineageEventsPagedResponse>
      listLineageEventsPagedCallable() {
    return stub.listLineageEventsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists lineage events in the given project and location. The list order is not defined.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineageClient lineageClient = LineageClient.create()) {
   *   ListLineageEventsRequest request =
   *       ListLineageEventsRequest.newBuilder()
   *           .setParent(RunName.of("[PROJECT]", "[LOCATION]", "[PROCESS]", "[RUN]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLineageEventsResponse response =
   *         lineageClient.listLineageEventsCallable().call(request);
   *     for (LineageEvent element : response.getLineageEventsList()) {
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
  public final UnaryCallable<ListLineageEventsRequest, ListLineageEventsResponse>
      listLineageEventsCallable() {
    return stub.listLineageEventsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the lineage event with the specified name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineageClient lineageClient = LineageClient.create()) {
   *   LineageEventName name =
   *       LineageEventName.of("[PROJECT]", "[LOCATION]", "[PROCESS]", "[RUN]", "[LINEAGE_EVENT]");
   *   lineageClient.deleteLineageEvent(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the lineage event to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteLineageEvent(LineageEventName name) {
    DeleteLineageEventRequest request =
        DeleteLineageEventRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteLineageEvent(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the lineage event with the specified name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineageClient lineageClient = LineageClient.create()) {
   *   String name =
   *       LineageEventName.of("[PROJECT]", "[LOCATION]", "[PROCESS]", "[RUN]", "[LINEAGE_EVENT]")
   *           .toString();
   *   lineageClient.deleteLineageEvent(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the lineage event to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteLineageEvent(String name) {
    DeleteLineageEventRequest request =
        DeleteLineageEventRequest.newBuilder().setName(name).build();
    deleteLineageEvent(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the lineage event with the specified name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineageClient lineageClient = LineageClient.create()) {
   *   DeleteLineageEventRequest request =
   *       DeleteLineageEventRequest.newBuilder()
   *           .setName(
   *               LineageEventName.of(
   *                       "[PROJECT]", "[LOCATION]", "[PROCESS]", "[RUN]", "[LINEAGE_EVENT]")
   *                   .toString())
   *           .setAllowMissing(true)
   *           .build();
   *   lineageClient.deleteLineageEvent(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteLineageEvent(DeleteLineageEventRequest request) {
    deleteLineageEventCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the lineage event with the specified name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineageClient lineageClient = LineageClient.create()) {
   *   DeleteLineageEventRequest request =
   *       DeleteLineageEventRequest.newBuilder()
   *           .setName(
   *               LineageEventName.of(
   *                       "[PROJECT]", "[LOCATION]", "[PROCESS]", "[RUN]", "[LINEAGE_EVENT]")
   *                   .toString())
   *           .setAllowMissing(true)
   *           .build();
   *   ApiFuture<Empty> future = lineageClient.deleteLineageEventCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteLineageEventRequest, Empty> deleteLineageEventCallable() {
    return stub.deleteLineageEventCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve a list of links connected to a specific asset. Links represent the data flow between
   * &#42;&#42;source&#42;&#42; (upstream) and &#42;&#42;target&#42;&#42; (downstream) assets in
   * transformation pipelines. Links are stored in the same project as the Lineage Events that
   * create them.
   *
   * <p>You can retrieve links in every project where you have the `datalineage.events.get`
   * permission. The project provided in the URL is used for Billing and Quota.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineageClient lineageClient = LineageClient.create()) {
   *   SearchLinksRequest request =
   *       SearchLinksRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Link element : lineageClient.searchLinks(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchLinksPagedResponse searchLinks(SearchLinksRequest request) {
    return searchLinksPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve a list of links connected to a specific asset. Links represent the data flow between
   * &#42;&#42;source&#42;&#42; (upstream) and &#42;&#42;target&#42;&#42; (downstream) assets in
   * transformation pipelines. Links are stored in the same project as the Lineage Events that
   * create them.
   *
   * <p>You can retrieve links in every project where you have the `datalineage.events.get`
   * permission. The project provided in the URL is used for Billing and Quota.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineageClient lineageClient = LineageClient.create()) {
   *   SearchLinksRequest request =
   *       SearchLinksRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Link> future = lineageClient.searchLinksPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Link element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<SearchLinksRequest, SearchLinksPagedResponse>
      searchLinksPagedCallable() {
    return stub.searchLinksPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve a list of links connected to a specific asset. Links represent the data flow between
   * &#42;&#42;source&#42;&#42; (upstream) and &#42;&#42;target&#42;&#42; (downstream) assets in
   * transformation pipelines. Links are stored in the same project as the Lineage Events that
   * create them.
   *
   * <p>You can retrieve links in every project where you have the `datalineage.events.get`
   * permission. The project provided in the URL is used for Billing and Quota.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineageClient lineageClient = LineageClient.create()) {
   *   SearchLinksRequest request =
   *       SearchLinksRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     SearchLinksResponse response = lineageClient.searchLinksCallable().call(request);
   *     for (Link element : response.getLinksList()) {
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
  public final UnaryCallable<SearchLinksRequest, SearchLinksResponse> searchLinksCallable() {
    return stub.searchLinksCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve information about LineageProcesses associated with specific links. LineageProcesses
   * are transformation pipelines that result in data flowing from &#42;&#42;source&#42;&#42; to
   * &#42;&#42;target&#42;&#42; assets. Links between assets represent this operation.
   *
   * <p>If you have specific link names, you can use this method to verify which LineageProcesses
   * contribute to creating those links. See the
   * [SearchLinks][google.cloud.datacatalog.lineage.v1.Lineage.SearchLinks] method for more
   * information on how to retrieve link name.
   *
   * <p>You can retrieve the LineageProcess information in every project where you have the
   * `datalineage.events.get` permission. The project provided in the URL is used for Billing and
   * Quota.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineageClient lineageClient = LineageClient.create()) {
   *   BatchSearchLinkProcessesRequest request =
   *       BatchSearchLinkProcessesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .addAllLinks(new ArrayList<String>())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (ProcessLinks element : lineageClient.batchSearchLinkProcesses(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchSearchLinkProcessesPagedResponse batchSearchLinkProcesses(
      BatchSearchLinkProcessesRequest request) {
    return batchSearchLinkProcessesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve information about LineageProcesses associated with specific links. LineageProcesses
   * are transformation pipelines that result in data flowing from &#42;&#42;source&#42;&#42; to
   * &#42;&#42;target&#42;&#42; assets. Links between assets represent this operation.
   *
   * <p>If you have specific link names, you can use this method to verify which LineageProcesses
   * contribute to creating those links. See the
   * [SearchLinks][google.cloud.datacatalog.lineage.v1.Lineage.SearchLinks] method for more
   * information on how to retrieve link name.
   *
   * <p>You can retrieve the LineageProcess information in every project where you have the
   * `datalineage.events.get` permission. The project provided in the URL is used for Billing and
   * Quota.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineageClient lineageClient = LineageClient.create()) {
   *   BatchSearchLinkProcessesRequest request =
   *       BatchSearchLinkProcessesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .addAllLinks(new ArrayList<String>())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<ProcessLinks> future =
   *       lineageClient.batchSearchLinkProcessesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (ProcessLinks element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchSearchLinkProcessesRequest, BatchSearchLinkProcessesPagedResponse>
      batchSearchLinkProcessesPagedCallable() {
    return stub.batchSearchLinkProcessesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve information about LineageProcesses associated with specific links. LineageProcesses
   * are transformation pipelines that result in data flowing from &#42;&#42;source&#42;&#42; to
   * &#42;&#42;target&#42;&#42; assets. Links between assets represent this operation.
   *
   * <p>If you have specific link names, you can use this method to verify which LineageProcesses
   * contribute to creating those links. See the
   * [SearchLinks][google.cloud.datacatalog.lineage.v1.Lineage.SearchLinks] method for more
   * information on how to retrieve link name.
   *
   * <p>You can retrieve the LineageProcess information in every project where you have the
   * `datalineage.events.get` permission. The project provided in the URL is used for Billing and
   * Quota.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineageClient lineageClient = LineageClient.create()) {
   *   BatchSearchLinkProcessesRequest request =
   *       BatchSearchLinkProcessesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .addAllLinks(new ArrayList<String>())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     BatchSearchLinkProcessesResponse response =
   *         lineageClient.batchSearchLinkProcessesCallable().call(request);
   *     for (ProcessLinks element : response.getProcessLinksList()) {
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
  public final UnaryCallable<BatchSearchLinkProcessesRequest, BatchSearchLinkProcessesResponse>
      batchSearchLinkProcessesCallable() {
    return stub.batchSearchLinkProcessesCallable();
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

  public static class ListProcessesPagedResponse
      extends AbstractPagedListResponse<
          ListProcessesRequest,
          ListProcessesResponse,
          Process,
          ListProcessesPage,
          ListProcessesFixedSizeCollection> {

    public static ApiFuture<ListProcessesPagedResponse> createAsync(
        PageContext<ListProcessesRequest, ListProcessesResponse, Process> context,
        ApiFuture<ListProcessesResponse> futureResponse) {
      ApiFuture<ListProcessesPage> futurePage =
          ListProcessesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListProcessesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListProcessesPagedResponse(ListProcessesPage page) {
      super(page, ListProcessesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListProcessesPage
      extends AbstractPage<
          ListProcessesRequest, ListProcessesResponse, Process, ListProcessesPage> {

    private ListProcessesPage(
        PageContext<ListProcessesRequest, ListProcessesResponse, Process> context,
        ListProcessesResponse response) {
      super(context, response);
    }

    private static ListProcessesPage createEmptyPage() {
      return new ListProcessesPage(null, null);
    }

    @Override
    protected ListProcessesPage createPage(
        PageContext<ListProcessesRequest, ListProcessesResponse, Process> context,
        ListProcessesResponse response) {
      return new ListProcessesPage(context, response);
    }

    @Override
    public ApiFuture<ListProcessesPage> createPageAsync(
        PageContext<ListProcessesRequest, ListProcessesResponse, Process> context,
        ApiFuture<ListProcessesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListProcessesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListProcessesRequest,
          ListProcessesResponse,
          Process,
          ListProcessesPage,
          ListProcessesFixedSizeCollection> {

    private ListProcessesFixedSizeCollection(List<ListProcessesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListProcessesFixedSizeCollection createEmptyCollection() {
      return new ListProcessesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListProcessesFixedSizeCollection createCollection(
        List<ListProcessesPage> pages, int collectionSize) {
      return new ListProcessesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListRunsPagedResponse
      extends AbstractPagedListResponse<
          ListRunsRequest, ListRunsResponse, Run, ListRunsPage, ListRunsFixedSizeCollection> {

    public static ApiFuture<ListRunsPagedResponse> createAsync(
        PageContext<ListRunsRequest, ListRunsResponse, Run> context,
        ApiFuture<ListRunsResponse> futureResponse) {
      ApiFuture<ListRunsPage> futurePage =
          ListRunsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListRunsPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListRunsPagedResponse(ListRunsPage page) {
      super(page, ListRunsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListRunsPage
      extends AbstractPage<ListRunsRequest, ListRunsResponse, Run, ListRunsPage> {

    private ListRunsPage(
        PageContext<ListRunsRequest, ListRunsResponse, Run> context, ListRunsResponse response) {
      super(context, response);
    }

    private static ListRunsPage createEmptyPage() {
      return new ListRunsPage(null, null);
    }

    @Override
    protected ListRunsPage createPage(
        PageContext<ListRunsRequest, ListRunsResponse, Run> context, ListRunsResponse response) {
      return new ListRunsPage(context, response);
    }

    @Override
    public ApiFuture<ListRunsPage> createPageAsync(
        PageContext<ListRunsRequest, ListRunsResponse, Run> context,
        ApiFuture<ListRunsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListRunsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListRunsRequest, ListRunsResponse, Run, ListRunsPage, ListRunsFixedSizeCollection> {

    private ListRunsFixedSizeCollection(List<ListRunsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListRunsFixedSizeCollection createEmptyCollection() {
      return new ListRunsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListRunsFixedSizeCollection createCollection(
        List<ListRunsPage> pages, int collectionSize) {
      return new ListRunsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListLineageEventsPagedResponse
      extends AbstractPagedListResponse<
          ListLineageEventsRequest,
          ListLineageEventsResponse,
          LineageEvent,
          ListLineageEventsPage,
          ListLineageEventsFixedSizeCollection> {

    public static ApiFuture<ListLineageEventsPagedResponse> createAsync(
        PageContext<ListLineageEventsRequest, ListLineageEventsResponse, LineageEvent> context,
        ApiFuture<ListLineageEventsResponse> futureResponse) {
      ApiFuture<ListLineageEventsPage> futurePage =
          ListLineageEventsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListLineageEventsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListLineageEventsPagedResponse(ListLineageEventsPage page) {
      super(page, ListLineageEventsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListLineageEventsPage
      extends AbstractPage<
          ListLineageEventsRequest,
          ListLineageEventsResponse,
          LineageEvent,
          ListLineageEventsPage> {

    private ListLineageEventsPage(
        PageContext<ListLineageEventsRequest, ListLineageEventsResponse, LineageEvent> context,
        ListLineageEventsResponse response) {
      super(context, response);
    }

    private static ListLineageEventsPage createEmptyPage() {
      return new ListLineageEventsPage(null, null);
    }

    @Override
    protected ListLineageEventsPage createPage(
        PageContext<ListLineageEventsRequest, ListLineageEventsResponse, LineageEvent> context,
        ListLineageEventsResponse response) {
      return new ListLineageEventsPage(context, response);
    }

    @Override
    public ApiFuture<ListLineageEventsPage> createPageAsync(
        PageContext<ListLineageEventsRequest, ListLineageEventsResponse, LineageEvent> context,
        ApiFuture<ListLineageEventsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListLineageEventsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListLineageEventsRequest,
          ListLineageEventsResponse,
          LineageEvent,
          ListLineageEventsPage,
          ListLineageEventsFixedSizeCollection> {

    private ListLineageEventsFixedSizeCollection(
        List<ListLineageEventsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListLineageEventsFixedSizeCollection createEmptyCollection() {
      return new ListLineageEventsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListLineageEventsFixedSizeCollection createCollection(
        List<ListLineageEventsPage> pages, int collectionSize) {
      return new ListLineageEventsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class SearchLinksPagedResponse
      extends AbstractPagedListResponse<
          SearchLinksRequest,
          SearchLinksResponse,
          Link,
          SearchLinksPage,
          SearchLinksFixedSizeCollection> {

    public static ApiFuture<SearchLinksPagedResponse> createAsync(
        PageContext<SearchLinksRequest, SearchLinksResponse, Link> context,
        ApiFuture<SearchLinksResponse> futureResponse) {
      ApiFuture<SearchLinksPage> futurePage =
          SearchLinksPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new SearchLinksPagedResponse(input), MoreExecutors.directExecutor());
    }

    private SearchLinksPagedResponse(SearchLinksPage page) {
      super(page, SearchLinksFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class SearchLinksPage
      extends AbstractPage<SearchLinksRequest, SearchLinksResponse, Link, SearchLinksPage> {

    private SearchLinksPage(
        PageContext<SearchLinksRequest, SearchLinksResponse, Link> context,
        SearchLinksResponse response) {
      super(context, response);
    }

    private static SearchLinksPage createEmptyPage() {
      return new SearchLinksPage(null, null);
    }

    @Override
    protected SearchLinksPage createPage(
        PageContext<SearchLinksRequest, SearchLinksResponse, Link> context,
        SearchLinksResponse response) {
      return new SearchLinksPage(context, response);
    }

    @Override
    public ApiFuture<SearchLinksPage> createPageAsync(
        PageContext<SearchLinksRequest, SearchLinksResponse, Link> context,
        ApiFuture<SearchLinksResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class SearchLinksFixedSizeCollection
      extends AbstractFixedSizeCollection<
          SearchLinksRequest,
          SearchLinksResponse,
          Link,
          SearchLinksPage,
          SearchLinksFixedSizeCollection> {

    private SearchLinksFixedSizeCollection(List<SearchLinksPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static SearchLinksFixedSizeCollection createEmptyCollection() {
      return new SearchLinksFixedSizeCollection(null, 0);
    }

    @Override
    protected SearchLinksFixedSizeCollection createCollection(
        List<SearchLinksPage> pages, int collectionSize) {
      return new SearchLinksFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class BatchSearchLinkProcessesPagedResponse
      extends AbstractPagedListResponse<
          BatchSearchLinkProcessesRequest,
          BatchSearchLinkProcessesResponse,
          ProcessLinks,
          BatchSearchLinkProcessesPage,
          BatchSearchLinkProcessesFixedSizeCollection> {

    public static ApiFuture<BatchSearchLinkProcessesPagedResponse> createAsync(
        PageContext<BatchSearchLinkProcessesRequest, BatchSearchLinkProcessesResponse, ProcessLinks>
            context,
        ApiFuture<BatchSearchLinkProcessesResponse> futureResponse) {
      ApiFuture<BatchSearchLinkProcessesPage> futurePage =
          BatchSearchLinkProcessesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new BatchSearchLinkProcessesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private BatchSearchLinkProcessesPagedResponse(BatchSearchLinkProcessesPage page) {
      super(page, BatchSearchLinkProcessesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class BatchSearchLinkProcessesPage
      extends AbstractPage<
          BatchSearchLinkProcessesRequest,
          BatchSearchLinkProcessesResponse,
          ProcessLinks,
          BatchSearchLinkProcessesPage> {

    private BatchSearchLinkProcessesPage(
        PageContext<BatchSearchLinkProcessesRequest, BatchSearchLinkProcessesResponse, ProcessLinks>
            context,
        BatchSearchLinkProcessesResponse response) {
      super(context, response);
    }

    private static BatchSearchLinkProcessesPage createEmptyPage() {
      return new BatchSearchLinkProcessesPage(null, null);
    }

    @Override
    protected BatchSearchLinkProcessesPage createPage(
        PageContext<BatchSearchLinkProcessesRequest, BatchSearchLinkProcessesResponse, ProcessLinks>
            context,
        BatchSearchLinkProcessesResponse response) {
      return new BatchSearchLinkProcessesPage(context, response);
    }

    @Override
    public ApiFuture<BatchSearchLinkProcessesPage> createPageAsync(
        PageContext<BatchSearchLinkProcessesRequest, BatchSearchLinkProcessesResponse, ProcessLinks>
            context,
        ApiFuture<BatchSearchLinkProcessesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class BatchSearchLinkProcessesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          BatchSearchLinkProcessesRequest,
          BatchSearchLinkProcessesResponse,
          ProcessLinks,
          BatchSearchLinkProcessesPage,
          BatchSearchLinkProcessesFixedSizeCollection> {

    private BatchSearchLinkProcessesFixedSizeCollection(
        List<BatchSearchLinkProcessesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static BatchSearchLinkProcessesFixedSizeCollection createEmptyCollection() {
      return new BatchSearchLinkProcessesFixedSizeCollection(null, 0);
    }

    @Override
    protected BatchSearchLinkProcessesFixedSizeCollection createCollection(
        List<BatchSearchLinkProcessesPage> pages, int collectionSize) {
      return new BatchSearchLinkProcessesFixedSizeCollection(pages, collectionSize);
    }
  }
}
