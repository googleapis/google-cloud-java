/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.visionai.v1;

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
import com.google.cloud.visionai.v1.stub.LiveVideoAnalyticsStub;
import com.google.cloud.visionai.v1.stub.LiveVideoAnalyticsStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service describing handlers for resources. The service enables clients to
 * run Live Video Analytics (LVA) on the streaming inputs.
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
 * try (LiveVideoAnalyticsClient liveVideoAnalyticsClient = LiveVideoAnalyticsClient.create()) {
 *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
 *   List<OperatorQuery> queries = new ArrayList<>();
 *   ResolveOperatorInfoResponse response =
 *       liveVideoAnalyticsClient.resolveOperatorInfo(parent, queries);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the LiveVideoAnalyticsClient object to clean up resources
 * such as threads. In the example above, try-with-resources is used, which automatically calls
 * close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> ListPublicOperators</td>
 *      <td><p> ListPublicOperators returns all the operators in public registry.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listPublicOperators(ListPublicOperatorsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listPublicOperators(LocationName parent)
 *           <li><p> listPublicOperators(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listPublicOperatorsPagedCallable()
 *           <li><p> listPublicOperatorsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ResolveOperatorInfo</td>
 *      <td><p> ResolveOperatorInfo returns the operator information based on the request.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> resolveOperatorInfo(ResolveOperatorInfoRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> resolveOperatorInfo(LocationName parent, List&lt;OperatorQuery&gt; queries)
 *           <li><p> resolveOperatorInfo(String parent, List&lt;OperatorQuery&gt; queries)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> resolveOperatorInfoCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListOperators</td>
 *      <td><p> Lists Operators in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listOperators(ListOperatorsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listOperators(LocationName parent)
 *           <li><p> listOperators(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listOperatorsPagedCallable()
 *           <li><p> listOperatorsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetOperator</td>
 *      <td><p> Gets details of a single Operator.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getOperator(GetOperatorRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getOperator(OperatorName name)
 *           <li><p> getOperator(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getOperatorCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateOperator</td>
 *      <td><p> Creates a new Operator in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createOperatorAsync(CreateOperatorRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createOperatorAsync(LocationName parent, Operator operator, String operatorId)
 *           <li><p> createOperatorAsync(String parent, Operator operator, String operatorId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createOperatorOperationCallable()
 *           <li><p> createOperatorCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateOperator</td>
 *      <td><p> Updates the parameters of a single Operator.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateOperatorAsync(UpdateOperatorRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateOperatorAsync(Operator operator, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateOperatorOperationCallable()
 *           <li><p> updateOperatorCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteOperator</td>
 *      <td><p> Deletes a single Operator.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteOperatorAsync(DeleteOperatorRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteOperatorAsync(OperatorName name)
 *           <li><p> deleteOperatorAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteOperatorOperationCallable()
 *           <li><p> deleteOperatorCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListAnalyses</td>
 *      <td><p> Lists Analyses in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listAnalyses(ListAnalysesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listAnalyses(ClusterName parent)
 *           <li><p> listAnalyses(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listAnalysesPagedCallable()
 *           <li><p> listAnalysesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetAnalysis</td>
 *      <td><p> Gets details of a single Analysis.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getAnalysis(GetAnalysisRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getAnalysis(AnalysisName name)
 *           <li><p> getAnalysis(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getAnalysisCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateAnalysis</td>
 *      <td><p> Creates a new Analysis in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createAnalysisAsync(CreateAnalysisRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createAnalysisAsync(ClusterName parent, Analysis analysis, String analysisId)
 *           <li><p> createAnalysisAsync(String parent, Analysis analysis, String analysisId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createAnalysisOperationCallable()
 *           <li><p> createAnalysisCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateAnalysis</td>
 *      <td><p> Updates the parameters of a single Analysis.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateAnalysisAsync(UpdateAnalysisRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateAnalysisAsync(Analysis analysis, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateAnalysisOperationCallable()
 *           <li><p> updateAnalysisCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteAnalysis</td>
 *      <td><p> Deletes a single Analysis.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteAnalysisAsync(DeleteAnalysisRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteAnalysisAsync(AnalysisName name)
 *           <li><p> deleteAnalysisAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteAnalysisOperationCallable()
 *           <li><p> deleteAnalysisCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListProcesses</td>
 *      <td><p> Lists Processes in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listProcesses(ListProcessesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listProcesses(ClusterName parent)
 *           <li><p> listProcesses(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listProcessesPagedCallable()
 *           <li><p> listProcessesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetProcess</td>
 *      <td><p> Gets details of a single Process.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getProcess(GetProcessRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getProcess(ProcessName name)
 *           <li><p> getProcess(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getProcessCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateProcess</td>
 *      <td><p> Creates a new Process in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createProcessAsync(CreateProcessRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createProcessAsync(ClusterName parent, Process process, String processId)
 *           <li><p> createProcessAsync(String parent, Process process, String processId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createProcessOperationCallable()
 *           <li><p> createProcessCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateProcess</td>
 *      <td><p> Updates the parameters of a single Process.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateProcessAsync(UpdateProcessRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateProcessAsync(Process process, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateProcessOperationCallable()
 *           <li><p> updateProcessCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteProcess</td>
 *      <td><p> Deletes a single Process.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteProcessAsync(DeleteProcessRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteProcessAsync(ProcessName name)
 *           <li><p> deleteProcessAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteProcessOperationCallable()
 *           <li><p> deleteProcessCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchRunProcess</td>
 *      <td><p> Run all of the processes to "completion". Max time for each process is the LRO time limit.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchRunProcessAsync(ClusterName parent, List&lt;CreateProcessRequest&gt; requests)
 *           <li><p> batchRunProcessAsync(String parent, List&lt;CreateProcessRequest&gt; requests)
 *           <li><p> batchRunProcessAsync(BatchRunProcessRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchRunProcessOperationCallable()
 *           <li><p> batchRunProcessCallable()
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
 * <p>This class can be customized by passing in a custom instance of LiveVideoAnalyticsSettings to
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
 * LiveVideoAnalyticsSettings liveVideoAnalyticsSettings =
 *     LiveVideoAnalyticsSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * LiveVideoAnalyticsClient liveVideoAnalyticsClient =
 *     LiveVideoAnalyticsClient.create(liveVideoAnalyticsSettings);
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
 * LiveVideoAnalyticsSettings liveVideoAnalyticsSettings =
 *     LiveVideoAnalyticsSettings.newBuilder().setEndpoint(myEndpoint).build();
 * LiveVideoAnalyticsClient liveVideoAnalyticsClient =
 *     LiveVideoAnalyticsClient.create(liveVideoAnalyticsSettings);
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
 * LiveVideoAnalyticsSettings liveVideoAnalyticsSettings =
 *     LiveVideoAnalyticsSettings.newHttpJsonBuilder().build();
 * LiveVideoAnalyticsClient liveVideoAnalyticsClient =
 *     LiveVideoAnalyticsClient.create(liveVideoAnalyticsSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class LiveVideoAnalyticsClient implements BackgroundResource {
  private final LiveVideoAnalyticsSettings settings;
  private final LiveVideoAnalyticsStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of LiveVideoAnalyticsClient with default settings. */
  public static final LiveVideoAnalyticsClient create() throws IOException {
    return create(LiveVideoAnalyticsSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of LiveVideoAnalyticsClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final LiveVideoAnalyticsClient create(LiveVideoAnalyticsSettings settings)
      throws IOException {
    return new LiveVideoAnalyticsClient(settings);
  }

  /**
   * Constructs an instance of LiveVideoAnalyticsClient, using the given stub for making calls. This
   * is for advanced usage - prefer using create(LiveVideoAnalyticsSettings).
   */
  public static final LiveVideoAnalyticsClient create(LiveVideoAnalyticsStub stub) {
    return new LiveVideoAnalyticsClient(stub);
  }

  /**
   * Constructs an instance of LiveVideoAnalyticsClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected LiveVideoAnalyticsClient(LiveVideoAnalyticsSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((LiveVideoAnalyticsStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected LiveVideoAnalyticsClient(LiveVideoAnalyticsStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final LiveVideoAnalyticsSettings getSettings() {
    return settings;
  }

  public LiveVideoAnalyticsStub getStub() {
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
   * ListPublicOperators returns all the operators in public registry.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveVideoAnalyticsClient liveVideoAnalyticsClient = LiveVideoAnalyticsClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Operator element : liveVideoAnalyticsClient.listPublicOperators(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListPublicOperatorsRequest.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPublicOperatorsPagedResponse listPublicOperators(LocationName parent) {
    ListPublicOperatorsRequest request =
        ListPublicOperatorsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listPublicOperators(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * ListPublicOperators returns all the operators in public registry.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveVideoAnalyticsClient liveVideoAnalyticsClient = LiveVideoAnalyticsClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Operator element : liveVideoAnalyticsClient.listPublicOperators(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListPublicOperatorsRequest.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPublicOperatorsPagedResponse listPublicOperators(String parent) {
    ListPublicOperatorsRequest request =
        ListPublicOperatorsRequest.newBuilder().setParent(parent).build();
    return listPublicOperators(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * ListPublicOperators returns all the operators in public registry.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveVideoAnalyticsClient liveVideoAnalyticsClient = LiveVideoAnalyticsClient.create()) {
   *   ListPublicOperatorsRequest request =
   *       ListPublicOperatorsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Operator element : liveVideoAnalyticsClient.listPublicOperators(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPublicOperatorsPagedResponse listPublicOperators(
      ListPublicOperatorsRequest request) {
    return listPublicOperatorsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * ListPublicOperators returns all the operators in public registry.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveVideoAnalyticsClient liveVideoAnalyticsClient = LiveVideoAnalyticsClient.create()) {
   *   ListPublicOperatorsRequest request =
   *       ListPublicOperatorsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Operator> future =
   *       liveVideoAnalyticsClient.listPublicOperatorsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Operator element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListPublicOperatorsRequest, ListPublicOperatorsPagedResponse>
      listPublicOperatorsPagedCallable() {
    return stub.listPublicOperatorsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * ListPublicOperators returns all the operators in public registry.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveVideoAnalyticsClient liveVideoAnalyticsClient = LiveVideoAnalyticsClient.create()) {
   *   ListPublicOperatorsRequest request =
   *       ListPublicOperatorsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListPublicOperatorsResponse response =
   *         liveVideoAnalyticsClient.listPublicOperatorsCallable().call(request);
   *     for (Operator element : response.getOperatorsList()) {
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
  public final UnaryCallable<ListPublicOperatorsRequest, ListPublicOperatorsResponse>
      listPublicOperatorsCallable() {
    return stub.listPublicOperatorsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * ResolveOperatorInfo returns the operator information based on the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveVideoAnalyticsClient liveVideoAnalyticsClient = LiveVideoAnalyticsClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   List<OperatorQuery> queries = new ArrayList<>();
   *   ResolveOperatorInfoResponse response =
   *       liveVideoAnalyticsClient.resolveOperatorInfo(parent, queries);
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ResolveOperatorInfoRequest.
   * @param queries Required. The operator queries.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ResolveOperatorInfoResponse resolveOperatorInfo(
      LocationName parent, List<OperatorQuery> queries) {
    ResolveOperatorInfoRequest request =
        ResolveOperatorInfoRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllQueries(queries)
            .build();
    return resolveOperatorInfo(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * ResolveOperatorInfo returns the operator information based on the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveVideoAnalyticsClient liveVideoAnalyticsClient = LiveVideoAnalyticsClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   List<OperatorQuery> queries = new ArrayList<>();
   *   ResolveOperatorInfoResponse response =
   *       liveVideoAnalyticsClient.resolveOperatorInfo(parent, queries);
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ResolveOperatorInfoRequest.
   * @param queries Required. The operator queries.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ResolveOperatorInfoResponse resolveOperatorInfo(
      String parent, List<OperatorQuery> queries) {
    ResolveOperatorInfoRequest request =
        ResolveOperatorInfoRequest.newBuilder().setParent(parent).addAllQueries(queries).build();
    return resolveOperatorInfo(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * ResolveOperatorInfo returns the operator information based on the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveVideoAnalyticsClient liveVideoAnalyticsClient = LiveVideoAnalyticsClient.create()) {
   *   ResolveOperatorInfoRequest request =
   *       ResolveOperatorInfoRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .addAllQueries(new ArrayList<OperatorQuery>())
   *           .build();
   *   ResolveOperatorInfoResponse response = liveVideoAnalyticsClient.resolveOperatorInfo(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ResolveOperatorInfoResponse resolveOperatorInfo(ResolveOperatorInfoRequest request) {
    return resolveOperatorInfoCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * ResolveOperatorInfo returns the operator information based on the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveVideoAnalyticsClient liveVideoAnalyticsClient = LiveVideoAnalyticsClient.create()) {
   *   ResolveOperatorInfoRequest request =
   *       ResolveOperatorInfoRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .addAllQueries(new ArrayList<OperatorQuery>())
   *           .build();
   *   ApiFuture<ResolveOperatorInfoResponse> future =
   *       liveVideoAnalyticsClient.resolveOperatorInfoCallable().futureCall(request);
   *   // Do something.
   *   ResolveOperatorInfoResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ResolveOperatorInfoRequest, ResolveOperatorInfoResponse>
      resolveOperatorInfoCallable() {
    return stub.resolveOperatorInfoCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Operators in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveVideoAnalyticsClient liveVideoAnalyticsClient = LiveVideoAnalyticsClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Operator element : liveVideoAnalyticsClient.listOperators(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListOperatorsRequest.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListOperatorsPagedResponse listOperators(LocationName parent) {
    ListOperatorsRequest request =
        ListOperatorsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listOperators(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Operators in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveVideoAnalyticsClient liveVideoAnalyticsClient = LiveVideoAnalyticsClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Operator element : liveVideoAnalyticsClient.listOperators(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListOperatorsRequest.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListOperatorsPagedResponse listOperators(String parent) {
    ListOperatorsRequest request = ListOperatorsRequest.newBuilder().setParent(parent).build();
    return listOperators(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Operators in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveVideoAnalyticsClient liveVideoAnalyticsClient = LiveVideoAnalyticsClient.create()) {
   *   ListOperatorsRequest request =
   *       ListOperatorsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Operator element : liveVideoAnalyticsClient.listOperators(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListOperatorsPagedResponse listOperators(ListOperatorsRequest request) {
    return listOperatorsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Operators in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveVideoAnalyticsClient liveVideoAnalyticsClient = LiveVideoAnalyticsClient.create()) {
   *   ListOperatorsRequest request =
   *       ListOperatorsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Operator> future =
   *       liveVideoAnalyticsClient.listOperatorsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Operator element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListOperatorsRequest, ListOperatorsPagedResponse>
      listOperatorsPagedCallable() {
    return stub.listOperatorsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Operators in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveVideoAnalyticsClient liveVideoAnalyticsClient = LiveVideoAnalyticsClient.create()) {
   *   ListOperatorsRequest request =
   *       ListOperatorsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListOperatorsResponse response =
   *         liveVideoAnalyticsClient.listOperatorsCallable().call(request);
   *     for (Operator element : response.getOperatorsList()) {
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
  public final UnaryCallable<ListOperatorsRequest, ListOperatorsResponse> listOperatorsCallable() {
    return stub.listOperatorsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Operator.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveVideoAnalyticsClient liveVideoAnalyticsClient = LiveVideoAnalyticsClient.create()) {
   *   OperatorName name = OperatorName.of("[PROJECT]", "[LOCATION]", "[OPERATOR]");
   *   Operator response = liveVideoAnalyticsClient.getOperator(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operator getOperator(OperatorName name) {
    GetOperatorRequest request =
        GetOperatorRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getOperator(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Operator.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveVideoAnalyticsClient liveVideoAnalyticsClient = LiveVideoAnalyticsClient.create()) {
   *   String name = OperatorName.of("[PROJECT]", "[LOCATION]", "[OPERATOR]").toString();
   *   Operator response = liveVideoAnalyticsClient.getOperator(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operator getOperator(String name) {
    GetOperatorRequest request = GetOperatorRequest.newBuilder().setName(name).build();
    return getOperator(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Operator.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveVideoAnalyticsClient liveVideoAnalyticsClient = LiveVideoAnalyticsClient.create()) {
   *   GetOperatorRequest request =
   *       GetOperatorRequest.newBuilder()
   *           .setName(OperatorName.of("[PROJECT]", "[LOCATION]", "[OPERATOR]").toString())
   *           .build();
   *   Operator response = liveVideoAnalyticsClient.getOperator(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operator getOperator(GetOperatorRequest request) {
    return getOperatorCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Operator.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveVideoAnalyticsClient liveVideoAnalyticsClient = LiveVideoAnalyticsClient.create()) {
   *   GetOperatorRequest request =
   *       GetOperatorRequest.newBuilder()
   *           .setName(OperatorName.of("[PROJECT]", "[LOCATION]", "[OPERATOR]").toString())
   *           .build();
   *   ApiFuture<Operator> future =
   *       liveVideoAnalyticsClient.getOperatorCallable().futureCall(request);
   *   // Do something.
   *   Operator response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetOperatorRequest, Operator> getOperatorCallable() {
    return stub.getOperatorCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Operator in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveVideoAnalyticsClient liveVideoAnalyticsClient = LiveVideoAnalyticsClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Operator operator = Operator.newBuilder().build();
   *   String operatorId = "operatorId4364511";
   *   Operator response =
   *       liveVideoAnalyticsClient.createOperatorAsync(parent, operator, operatorId).get();
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @param operator Required. The resource being created.
   * @param operatorId Required. Id of the requesting object.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operator, OperationMetadata> createOperatorAsync(
      LocationName parent, Operator operator, String operatorId) {
    CreateOperatorRequest request =
        CreateOperatorRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setOperator(operator)
            .setOperatorId(operatorId)
            .build();
    return createOperatorAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Operator in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveVideoAnalyticsClient liveVideoAnalyticsClient = LiveVideoAnalyticsClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Operator operator = Operator.newBuilder().build();
   *   String operatorId = "operatorId4364511";
   *   Operator response =
   *       liveVideoAnalyticsClient.createOperatorAsync(parent, operator, operatorId).get();
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @param operator Required. The resource being created.
   * @param operatorId Required. Id of the requesting object.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operator, OperationMetadata> createOperatorAsync(
      String parent, Operator operator, String operatorId) {
    CreateOperatorRequest request =
        CreateOperatorRequest.newBuilder()
            .setParent(parent)
            .setOperator(operator)
            .setOperatorId(operatorId)
            .build();
    return createOperatorAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Operator in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveVideoAnalyticsClient liveVideoAnalyticsClient = LiveVideoAnalyticsClient.create()) {
   *   CreateOperatorRequest request =
   *       CreateOperatorRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setOperatorId("operatorId4364511")
   *           .setOperator(Operator.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Operator response = liveVideoAnalyticsClient.createOperatorAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operator, OperationMetadata> createOperatorAsync(
      CreateOperatorRequest request) {
    return createOperatorOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Operator in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveVideoAnalyticsClient liveVideoAnalyticsClient = LiveVideoAnalyticsClient.create()) {
   *   CreateOperatorRequest request =
   *       CreateOperatorRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setOperatorId("operatorId4364511")
   *           .setOperator(Operator.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Operator, OperationMetadata> future =
   *       liveVideoAnalyticsClient.createOperatorOperationCallable().futureCall(request);
   *   // Do something.
   *   Operator response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateOperatorRequest, Operator, OperationMetadata>
      createOperatorOperationCallable() {
    return stub.createOperatorOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Operator in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveVideoAnalyticsClient liveVideoAnalyticsClient = LiveVideoAnalyticsClient.create()) {
   *   CreateOperatorRequest request =
   *       CreateOperatorRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setOperatorId("operatorId4364511")
   *           .setOperator(Operator.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       liveVideoAnalyticsClient.createOperatorCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateOperatorRequest, Operation> createOperatorCallable() {
    return stub.createOperatorCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Operator.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveVideoAnalyticsClient liveVideoAnalyticsClient = LiveVideoAnalyticsClient.create()) {
   *   Operator operator = Operator.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Operator response = liveVideoAnalyticsClient.updateOperatorAsync(operator, updateMask).get();
   * }
   * }</pre>
   *
   * @param operator Required. The resource being updated
   * @param updateMask Required. Field mask is used to specify the fields to be overwritten in the
   *     Operator resource by the update. The fields specified in the update_mask are relative to
   *     the resource, not the full request. A field will be overwritten if it is in the mask. If
   *     the user does not provide a mask then all fields will be overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operator, OperationMetadata> updateOperatorAsync(
      Operator operator, FieldMask updateMask) {
    UpdateOperatorRequest request =
        UpdateOperatorRequest.newBuilder().setOperator(operator).setUpdateMask(updateMask).build();
    return updateOperatorAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Operator.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveVideoAnalyticsClient liveVideoAnalyticsClient = LiveVideoAnalyticsClient.create()) {
   *   UpdateOperatorRequest request =
   *       UpdateOperatorRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setOperator(Operator.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Operator response = liveVideoAnalyticsClient.updateOperatorAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operator, OperationMetadata> updateOperatorAsync(
      UpdateOperatorRequest request) {
    return updateOperatorOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Operator.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveVideoAnalyticsClient liveVideoAnalyticsClient = LiveVideoAnalyticsClient.create()) {
   *   UpdateOperatorRequest request =
   *       UpdateOperatorRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setOperator(Operator.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Operator, OperationMetadata> future =
   *       liveVideoAnalyticsClient.updateOperatorOperationCallable().futureCall(request);
   *   // Do something.
   *   Operator response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateOperatorRequest, Operator, OperationMetadata>
      updateOperatorOperationCallable() {
    return stub.updateOperatorOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Operator.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveVideoAnalyticsClient liveVideoAnalyticsClient = LiveVideoAnalyticsClient.create()) {
   *   UpdateOperatorRequest request =
   *       UpdateOperatorRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setOperator(Operator.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       liveVideoAnalyticsClient.updateOperatorCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateOperatorRequest, Operation> updateOperatorCallable() {
    return stub.updateOperatorCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Operator.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveVideoAnalyticsClient liveVideoAnalyticsClient = LiveVideoAnalyticsClient.create()) {
   *   OperatorName name = OperatorName.of("[PROJECT]", "[LOCATION]", "[OPERATOR]");
   *   liveVideoAnalyticsClient.deleteOperatorAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteOperatorAsync(OperatorName name) {
    DeleteOperatorRequest request =
        DeleteOperatorRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteOperatorAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Operator.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveVideoAnalyticsClient liveVideoAnalyticsClient = LiveVideoAnalyticsClient.create()) {
   *   String name = OperatorName.of("[PROJECT]", "[LOCATION]", "[OPERATOR]").toString();
   *   liveVideoAnalyticsClient.deleteOperatorAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteOperatorAsync(String name) {
    DeleteOperatorRequest request = DeleteOperatorRequest.newBuilder().setName(name).build();
    return deleteOperatorAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Operator.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveVideoAnalyticsClient liveVideoAnalyticsClient = LiveVideoAnalyticsClient.create()) {
   *   DeleteOperatorRequest request =
   *       DeleteOperatorRequest.newBuilder()
   *           .setName(OperatorName.of("[PROJECT]", "[LOCATION]", "[OPERATOR]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   liveVideoAnalyticsClient.deleteOperatorAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteOperatorAsync(
      DeleteOperatorRequest request) {
    return deleteOperatorOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Operator.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveVideoAnalyticsClient liveVideoAnalyticsClient = LiveVideoAnalyticsClient.create()) {
   *   DeleteOperatorRequest request =
   *       DeleteOperatorRequest.newBuilder()
   *           .setName(OperatorName.of("[PROJECT]", "[LOCATION]", "[OPERATOR]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       liveVideoAnalyticsClient.deleteOperatorOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteOperatorRequest, Empty, OperationMetadata>
      deleteOperatorOperationCallable() {
    return stub.deleteOperatorOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Operator.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveVideoAnalyticsClient liveVideoAnalyticsClient = LiveVideoAnalyticsClient.create()) {
   *   DeleteOperatorRequest request =
   *       DeleteOperatorRequest.newBuilder()
   *           .setName(OperatorName.of("[PROJECT]", "[LOCATION]", "[OPERATOR]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       liveVideoAnalyticsClient.deleteOperatorCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteOperatorRequest, Operation> deleteOperatorCallable() {
    return stub.deleteOperatorCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Analyses in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveVideoAnalyticsClient liveVideoAnalyticsClient = LiveVideoAnalyticsClient.create()) {
   *   ClusterName parent = ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]");
   *   for (Analysis element : liveVideoAnalyticsClient.listAnalyses(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListAnalysesRequest
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAnalysesPagedResponse listAnalyses(ClusterName parent) {
    ListAnalysesRequest request =
        ListAnalysesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listAnalyses(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Analyses in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveVideoAnalyticsClient liveVideoAnalyticsClient = LiveVideoAnalyticsClient.create()) {
   *   String parent = ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString();
   *   for (Analysis element : liveVideoAnalyticsClient.listAnalyses(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListAnalysesRequest
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAnalysesPagedResponse listAnalyses(String parent) {
    ListAnalysesRequest request = ListAnalysesRequest.newBuilder().setParent(parent).build();
    return listAnalyses(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Analyses in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveVideoAnalyticsClient liveVideoAnalyticsClient = LiveVideoAnalyticsClient.create()) {
   *   ListAnalysesRequest request =
   *       ListAnalysesRequest.newBuilder()
   *           .setParent(ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Analysis element : liveVideoAnalyticsClient.listAnalyses(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAnalysesPagedResponse listAnalyses(ListAnalysesRequest request) {
    return listAnalysesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Analyses in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveVideoAnalyticsClient liveVideoAnalyticsClient = LiveVideoAnalyticsClient.create()) {
   *   ListAnalysesRequest request =
   *       ListAnalysesRequest.newBuilder()
   *           .setParent(ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Analysis> future =
   *       liveVideoAnalyticsClient.listAnalysesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Analysis element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListAnalysesRequest, ListAnalysesPagedResponse>
      listAnalysesPagedCallable() {
    return stub.listAnalysesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Analyses in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveVideoAnalyticsClient liveVideoAnalyticsClient = LiveVideoAnalyticsClient.create()) {
   *   ListAnalysesRequest request =
   *       ListAnalysesRequest.newBuilder()
   *           .setParent(ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListAnalysesResponse response =
   *         liveVideoAnalyticsClient.listAnalysesCallable().call(request);
   *     for (Analysis element : response.getAnalysesList()) {
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
  public final UnaryCallable<ListAnalysesRequest, ListAnalysesResponse> listAnalysesCallable() {
    return stub.listAnalysesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Analysis.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveVideoAnalyticsClient liveVideoAnalyticsClient = LiveVideoAnalyticsClient.create()) {
   *   AnalysisName name = AnalysisName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[ANALYSIS]");
   *   Analysis response = liveVideoAnalyticsClient.getAnalysis(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Analysis getAnalysis(AnalysisName name) {
    GetAnalysisRequest request =
        GetAnalysisRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getAnalysis(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Analysis.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveVideoAnalyticsClient liveVideoAnalyticsClient = LiveVideoAnalyticsClient.create()) {
   *   String name =
   *       AnalysisName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[ANALYSIS]").toString();
   *   Analysis response = liveVideoAnalyticsClient.getAnalysis(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Analysis getAnalysis(String name) {
    GetAnalysisRequest request = GetAnalysisRequest.newBuilder().setName(name).build();
    return getAnalysis(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Analysis.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveVideoAnalyticsClient liveVideoAnalyticsClient = LiveVideoAnalyticsClient.create()) {
   *   GetAnalysisRequest request =
   *       GetAnalysisRequest.newBuilder()
   *           .setName(
   *               AnalysisName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[ANALYSIS]").toString())
   *           .build();
   *   Analysis response = liveVideoAnalyticsClient.getAnalysis(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Analysis getAnalysis(GetAnalysisRequest request) {
    return getAnalysisCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Analysis.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveVideoAnalyticsClient liveVideoAnalyticsClient = LiveVideoAnalyticsClient.create()) {
   *   GetAnalysisRequest request =
   *       GetAnalysisRequest.newBuilder()
   *           .setName(
   *               AnalysisName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[ANALYSIS]").toString())
   *           .build();
   *   ApiFuture<Analysis> future =
   *       liveVideoAnalyticsClient.getAnalysisCallable().futureCall(request);
   *   // Do something.
   *   Analysis response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetAnalysisRequest, Analysis> getAnalysisCallable() {
    return stub.getAnalysisCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Analysis in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveVideoAnalyticsClient liveVideoAnalyticsClient = LiveVideoAnalyticsClient.create()) {
   *   ClusterName parent = ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]");
   *   Analysis analysis = Analysis.newBuilder().build();
   *   String analysisId = "analysisId-944835305";
   *   Analysis response =
   *       liveVideoAnalyticsClient.createAnalysisAsync(parent, analysis, analysisId).get();
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @param analysis Required. The resource being created.
   * @param analysisId Required. Id of the requesting object.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Analysis, OperationMetadata> createAnalysisAsync(
      ClusterName parent, Analysis analysis, String analysisId) {
    CreateAnalysisRequest request =
        CreateAnalysisRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setAnalysis(analysis)
            .setAnalysisId(analysisId)
            .build();
    return createAnalysisAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Analysis in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveVideoAnalyticsClient liveVideoAnalyticsClient = LiveVideoAnalyticsClient.create()) {
   *   String parent = ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString();
   *   Analysis analysis = Analysis.newBuilder().build();
   *   String analysisId = "analysisId-944835305";
   *   Analysis response =
   *       liveVideoAnalyticsClient.createAnalysisAsync(parent, analysis, analysisId).get();
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @param analysis Required. The resource being created.
   * @param analysisId Required. Id of the requesting object.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Analysis, OperationMetadata> createAnalysisAsync(
      String parent, Analysis analysis, String analysisId) {
    CreateAnalysisRequest request =
        CreateAnalysisRequest.newBuilder()
            .setParent(parent)
            .setAnalysis(analysis)
            .setAnalysisId(analysisId)
            .build();
    return createAnalysisAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Analysis in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveVideoAnalyticsClient liveVideoAnalyticsClient = LiveVideoAnalyticsClient.create()) {
   *   CreateAnalysisRequest request =
   *       CreateAnalysisRequest.newBuilder()
   *           .setParent(ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString())
   *           .setAnalysisId("analysisId-944835305")
   *           .setAnalysis(Analysis.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Analysis response = liveVideoAnalyticsClient.createAnalysisAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Analysis, OperationMetadata> createAnalysisAsync(
      CreateAnalysisRequest request) {
    return createAnalysisOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Analysis in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveVideoAnalyticsClient liveVideoAnalyticsClient = LiveVideoAnalyticsClient.create()) {
   *   CreateAnalysisRequest request =
   *       CreateAnalysisRequest.newBuilder()
   *           .setParent(ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString())
   *           .setAnalysisId("analysisId-944835305")
   *           .setAnalysis(Analysis.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Analysis, OperationMetadata> future =
   *       liveVideoAnalyticsClient.createAnalysisOperationCallable().futureCall(request);
   *   // Do something.
   *   Analysis response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateAnalysisRequest, Analysis, OperationMetadata>
      createAnalysisOperationCallable() {
    return stub.createAnalysisOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Analysis in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveVideoAnalyticsClient liveVideoAnalyticsClient = LiveVideoAnalyticsClient.create()) {
   *   CreateAnalysisRequest request =
   *       CreateAnalysisRequest.newBuilder()
   *           .setParent(ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString())
   *           .setAnalysisId("analysisId-944835305")
   *           .setAnalysis(Analysis.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       liveVideoAnalyticsClient.createAnalysisCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateAnalysisRequest, Operation> createAnalysisCallable() {
    return stub.createAnalysisCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Analysis.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveVideoAnalyticsClient liveVideoAnalyticsClient = LiveVideoAnalyticsClient.create()) {
   *   Analysis analysis = Analysis.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Analysis response = liveVideoAnalyticsClient.updateAnalysisAsync(analysis, updateMask).get();
   * }
   * }</pre>
   *
   * @param analysis Required. The resource being updated.
   * @param updateMask Required. Field mask is used to specify the fields to be overwritten in the
   *     Analysis resource by the update. The fields specified in the update_mask are relative to
   *     the resource, not the full request. A field will be overwritten if it is in the mask. If
   *     the user does not provide a mask then all fields will be overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Analysis, OperationMetadata> updateAnalysisAsync(
      Analysis analysis, FieldMask updateMask) {
    UpdateAnalysisRequest request =
        UpdateAnalysisRequest.newBuilder().setAnalysis(analysis).setUpdateMask(updateMask).build();
    return updateAnalysisAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Analysis.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveVideoAnalyticsClient liveVideoAnalyticsClient = LiveVideoAnalyticsClient.create()) {
   *   UpdateAnalysisRequest request =
   *       UpdateAnalysisRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setAnalysis(Analysis.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Analysis response = liveVideoAnalyticsClient.updateAnalysisAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Analysis, OperationMetadata> updateAnalysisAsync(
      UpdateAnalysisRequest request) {
    return updateAnalysisOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Analysis.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveVideoAnalyticsClient liveVideoAnalyticsClient = LiveVideoAnalyticsClient.create()) {
   *   UpdateAnalysisRequest request =
   *       UpdateAnalysisRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setAnalysis(Analysis.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Analysis, OperationMetadata> future =
   *       liveVideoAnalyticsClient.updateAnalysisOperationCallable().futureCall(request);
   *   // Do something.
   *   Analysis response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateAnalysisRequest, Analysis, OperationMetadata>
      updateAnalysisOperationCallable() {
    return stub.updateAnalysisOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Analysis.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveVideoAnalyticsClient liveVideoAnalyticsClient = LiveVideoAnalyticsClient.create()) {
   *   UpdateAnalysisRequest request =
   *       UpdateAnalysisRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setAnalysis(Analysis.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       liveVideoAnalyticsClient.updateAnalysisCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateAnalysisRequest, Operation> updateAnalysisCallable() {
    return stub.updateAnalysisCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Analysis.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveVideoAnalyticsClient liveVideoAnalyticsClient = LiveVideoAnalyticsClient.create()) {
   *   AnalysisName name = AnalysisName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[ANALYSIS]");
   *   liveVideoAnalyticsClient.deleteAnalysisAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteAnalysisAsync(AnalysisName name) {
    DeleteAnalysisRequest request =
        DeleteAnalysisRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteAnalysisAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Analysis.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveVideoAnalyticsClient liveVideoAnalyticsClient = LiveVideoAnalyticsClient.create()) {
   *   String name =
   *       AnalysisName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[ANALYSIS]").toString();
   *   liveVideoAnalyticsClient.deleteAnalysisAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteAnalysisAsync(String name) {
    DeleteAnalysisRequest request = DeleteAnalysisRequest.newBuilder().setName(name).build();
    return deleteAnalysisAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Analysis.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveVideoAnalyticsClient liveVideoAnalyticsClient = LiveVideoAnalyticsClient.create()) {
   *   DeleteAnalysisRequest request =
   *       DeleteAnalysisRequest.newBuilder()
   *           .setName(
   *               AnalysisName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[ANALYSIS]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   liveVideoAnalyticsClient.deleteAnalysisAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteAnalysisAsync(
      DeleteAnalysisRequest request) {
    return deleteAnalysisOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Analysis.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveVideoAnalyticsClient liveVideoAnalyticsClient = LiveVideoAnalyticsClient.create()) {
   *   DeleteAnalysisRequest request =
   *       DeleteAnalysisRequest.newBuilder()
   *           .setName(
   *               AnalysisName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[ANALYSIS]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       liveVideoAnalyticsClient.deleteAnalysisOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteAnalysisRequest, Empty, OperationMetadata>
      deleteAnalysisOperationCallable() {
    return stub.deleteAnalysisOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Analysis.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveVideoAnalyticsClient liveVideoAnalyticsClient = LiveVideoAnalyticsClient.create()) {
   *   DeleteAnalysisRequest request =
   *       DeleteAnalysisRequest.newBuilder()
   *           .setName(
   *               AnalysisName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[ANALYSIS]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       liveVideoAnalyticsClient.deleteAnalysisCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteAnalysisRequest, Operation> deleteAnalysisCallable() {
    return stub.deleteAnalysisCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Processes in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveVideoAnalyticsClient liveVideoAnalyticsClient = LiveVideoAnalyticsClient.create()) {
   *   ClusterName parent = ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]");
   *   for (Process element : liveVideoAnalyticsClient.listProcesses(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListProcessesRequest.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListProcessesPagedResponse listProcesses(ClusterName parent) {
    ListProcessesRequest request =
        ListProcessesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listProcesses(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Processes in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveVideoAnalyticsClient liveVideoAnalyticsClient = LiveVideoAnalyticsClient.create()) {
   *   String parent = ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString();
   *   for (Process element : liveVideoAnalyticsClient.listProcesses(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListProcessesRequest.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListProcessesPagedResponse listProcesses(String parent) {
    ListProcessesRequest request = ListProcessesRequest.newBuilder().setParent(parent).build();
    return listProcesses(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Processes in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveVideoAnalyticsClient liveVideoAnalyticsClient = LiveVideoAnalyticsClient.create()) {
   *   ListProcessesRequest request =
   *       ListProcessesRequest.newBuilder()
   *           .setParent(ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Process element : liveVideoAnalyticsClient.listProcesses(request).iterateAll()) {
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
   * Lists Processes in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveVideoAnalyticsClient liveVideoAnalyticsClient = LiveVideoAnalyticsClient.create()) {
   *   ListProcessesRequest request =
   *       ListProcessesRequest.newBuilder()
   *           .setParent(ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Process> future =
   *       liveVideoAnalyticsClient.listProcessesPagedCallable().futureCall(request);
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
   * Lists Processes in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveVideoAnalyticsClient liveVideoAnalyticsClient = LiveVideoAnalyticsClient.create()) {
   *   ListProcessesRequest request =
   *       ListProcessesRequest.newBuilder()
   *           .setParent(ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListProcessesResponse response =
   *         liveVideoAnalyticsClient.listProcessesCallable().call(request);
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
   * Gets details of a single Process.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveVideoAnalyticsClient liveVideoAnalyticsClient = LiveVideoAnalyticsClient.create()) {
   *   ProcessName name = ProcessName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[PROCESS]");
   *   Process response = liveVideoAnalyticsClient.getProcess(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Process getProcess(ProcessName name) {
    GetProcessRequest request =
        GetProcessRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getProcess(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Process.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveVideoAnalyticsClient liveVideoAnalyticsClient = LiveVideoAnalyticsClient.create()) {
   *   String name = ProcessName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[PROCESS]").toString();
   *   Process response = liveVideoAnalyticsClient.getProcess(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Process getProcess(String name) {
    GetProcessRequest request = GetProcessRequest.newBuilder().setName(name).build();
    return getProcess(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Process.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveVideoAnalyticsClient liveVideoAnalyticsClient = LiveVideoAnalyticsClient.create()) {
   *   GetProcessRequest request =
   *       GetProcessRequest.newBuilder()
   *           .setName(
   *               ProcessName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[PROCESS]").toString())
   *           .build();
   *   Process response = liveVideoAnalyticsClient.getProcess(request);
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
   * Gets details of a single Process.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveVideoAnalyticsClient liveVideoAnalyticsClient = LiveVideoAnalyticsClient.create()) {
   *   GetProcessRequest request =
   *       GetProcessRequest.newBuilder()
   *           .setName(
   *               ProcessName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[PROCESS]").toString())
   *           .build();
   *   ApiFuture<Process> future = liveVideoAnalyticsClient.getProcessCallable().futureCall(request);
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
   * Creates a new Process in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveVideoAnalyticsClient liveVideoAnalyticsClient = LiveVideoAnalyticsClient.create()) {
   *   ClusterName parent = ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]");
   *   Process process = Process.newBuilder().build();
   *   String processId = "processId-1094760470";
   *   Process response =
   *       liveVideoAnalyticsClient.createProcessAsync(parent, process, processId).get();
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @param process Required. The resource being created.
   * @param processId Required. Id of the requesting object.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Process, OperationMetadata> createProcessAsync(
      ClusterName parent, Process process, String processId) {
    CreateProcessRequest request =
        CreateProcessRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setProcess(process)
            .setProcessId(processId)
            .build();
    return createProcessAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Process in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveVideoAnalyticsClient liveVideoAnalyticsClient = LiveVideoAnalyticsClient.create()) {
   *   String parent = ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString();
   *   Process process = Process.newBuilder().build();
   *   String processId = "processId-1094760470";
   *   Process response =
   *       liveVideoAnalyticsClient.createProcessAsync(parent, process, processId).get();
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @param process Required. The resource being created.
   * @param processId Required. Id of the requesting object.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Process, OperationMetadata> createProcessAsync(
      String parent, Process process, String processId) {
    CreateProcessRequest request =
        CreateProcessRequest.newBuilder()
            .setParent(parent)
            .setProcess(process)
            .setProcessId(processId)
            .build();
    return createProcessAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Process in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveVideoAnalyticsClient liveVideoAnalyticsClient = LiveVideoAnalyticsClient.create()) {
   *   CreateProcessRequest request =
   *       CreateProcessRequest.newBuilder()
   *           .setParent(ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString())
   *           .setProcessId("processId-1094760470")
   *           .setProcess(Process.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Process response = liveVideoAnalyticsClient.createProcessAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Process, OperationMetadata> createProcessAsync(
      CreateProcessRequest request) {
    return createProcessOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Process in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveVideoAnalyticsClient liveVideoAnalyticsClient = LiveVideoAnalyticsClient.create()) {
   *   CreateProcessRequest request =
   *       CreateProcessRequest.newBuilder()
   *           .setParent(ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString())
   *           .setProcessId("processId-1094760470")
   *           .setProcess(Process.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Process, OperationMetadata> future =
   *       liveVideoAnalyticsClient.createProcessOperationCallable().futureCall(request);
   *   // Do something.
   *   Process response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateProcessRequest, Process, OperationMetadata>
      createProcessOperationCallable() {
    return stub.createProcessOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Process in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveVideoAnalyticsClient liveVideoAnalyticsClient = LiveVideoAnalyticsClient.create()) {
   *   CreateProcessRequest request =
   *       CreateProcessRequest.newBuilder()
   *           .setParent(ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString())
   *           .setProcessId("processId-1094760470")
   *           .setProcess(Process.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       liveVideoAnalyticsClient.createProcessCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateProcessRequest, Operation> createProcessCallable() {
    return stub.createProcessCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Process.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveVideoAnalyticsClient liveVideoAnalyticsClient = LiveVideoAnalyticsClient.create()) {
   *   Process process = Process.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Process response = liveVideoAnalyticsClient.updateProcessAsync(process, updateMask).get();
   * }
   * }</pre>
   *
   * @param process Required. The resource being updated.
   * @param updateMask Required. Field mask is used to specify the fields to be overwritten in the
   *     Process resource by the update. The fields specified in the update_mask are relative to the
   *     resource, not the full request. A field will be overwritten if it is in the mask. If the
   *     user does not provide a mask then all fields will be overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Process, OperationMetadata> updateProcessAsync(
      Process process, FieldMask updateMask) {
    UpdateProcessRequest request =
        UpdateProcessRequest.newBuilder().setProcess(process).setUpdateMask(updateMask).build();
    return updateProcessAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Process.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveVideoAnalyticsClient liveVideoAnalyticsClient = LiveVideoAnalyticsClient.create()) {
   *   UpdateProcessRequest request =
   *       UpdateProcessRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setProcess(Process.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Process response = liveVideoAnalyticsClient.updateProcessAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Process, OperationMetadata> updateProcessAsync(
      UpdateProcessRequest request) {
    return updateProcessOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Process.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveVideoAnalyticsClient liveVideoAnalyticsClient = LiveVideoAnalyticsClient.create()) {
   *   UpdateProcessRequest request =
   *       UpdateProcessRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setProcess(Process.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Process, OperationMetadata> future =
   *       liveVideoAnalyticsClient.updateProcessOperationCallable().futureCall(request);
   *   // Do something.
   *   Process response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateProcessRequest, Process, OperationMetadata>
      updateProcessOperationCallable() {
    return stub.updateProcessOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Process.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveVideoAnalyticsClient liveVideoAnalyticsClient = LiveVideoAnalyticsClient.create()) {
   *   UpdateProcessRequest request =
   *       UpdateProcessRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setProcess(Process.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       liveVideoAnalyticsClient.updateProcessCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateProcessRequest, Operation> updateProcessCallable() {
    return stub.updateProcessCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Process.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveVideoAnalyticsClient liveVideoAnalyticsClient = LiveVideoAnalyticsClient.create()) {
   *   ProcessName name = ProcessName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[PROCESS]");
   *   liveVideoAnalyticsClient.deleteProcessAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteProcessAsync(ProcessName name) {
    DeleteProcessRequest request =
        DeleteProcessRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteProcessAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Process.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveVideoAnalyticsClient liveVideoAnalyticsClient = LiveVideoAnalyticsClient.create()) {
   *   String name = ProcessName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[PROCESS]").toString();
   *   liveVideoAnalyticsClient.deleteProcessAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteProcessAsync(String name) {
    DeleteProcessRequest request = DeleteProcessRequest.newBuilder().setName(name).build();
    return deleteProcessAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Process.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveVideoAnalyticsClient liveVideoAnalyticsClient = LiveVideoAnalyticsClient.create()) {
   *   DeleteProcessRequest request =
   *       DeleteProcessRequest.newBuilder()
   *           .setName(
   *               ProcessName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[PROCESS]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   liveVideoAnalyticsClient.deleteProcessAsync(request).get();
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
   * Deletes a single Process.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveVideoAnalyticsClient liveVideoAnalyticsClient = LiveVideoAnalyticsClient.create()) {
   *   DeleteProcessRequest request =
   *       DeleteProcessRequest.newBuilder()
   *           .setName(
   *               ProcessName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[PROCESS]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       liveVideoAnalyticsClient.deleteProcessOperationCallable().futureCall(request);
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
   * Deletes a single Process.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveVideoAnalyticsClient liveVideoAnalyticsClient = LiveVideoAnalyticsClient.create()) {
   *   DeleteProcessRequest request =
   *       DeleteProcessRequest.newBuilder()
   *           .setName(
   *               ProcessName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[PROCESS]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       liveVideoAnalyticsClient.deleteProcessCallable().futureCall(request);
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
   * Run all of the processes to "completion". Max time for each process is the LRO time limit.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveVideoAnalyticsClient liveVideoAnalyticsClient = LiveVideoAnalyticsClient.create()) {
   *   ClusterName parent = ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]");
   *   List<CreateProcessRequest> requests = new ArrayList<>();
   *   BatchRunProcessResponse response =
   *       liveVideoAnalyticsClient.batchRunProcessAsync(parent, requests).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource shared by all processes being created.
   * @param requests Required. The create process requests.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<BatchRunProcessResponse, OperationMetadata> batchRunProcessAsync(
      ClusterName parent, List<CreateProcessRequest> requests) {
    BatchRunProcessRequest request =
        BatchRunProcessRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllRequests(requests)
            .build();
    return batchRunProcessAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Run all of the processes to "completion". Max time for each process is the LRO time limit.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveVideoAnalyticsClient liveVideoAnalyticsClient = LiveVideoAnalyticsClient.create()) {
   *   String parent = ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString();
   *   List<CreateProcessRequest> requests = new ArrayList<>();
   *   BatchRunProcessResponse response =
   *       liveVideoAnalyticsClient.batchRunProcessAsync(parent, requests).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource shared by all processes being created.
   * @param requests Required. The create process requests.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<BatchRunProcessResponse, OperationMetadata> batchRunProcessAsync(
      String parent, List<CreateProcessRequest> requests) {
    BatchRunProcessRequest request =
        BatchRunProcessRequest.newBuilder().setParent(parent).addAllRequests(requests).build();
    return batchRunProcessAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Run all of the processes to "completion". Max time for each process is the LRO time limit.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveVideoAnalyticsClient liveVideoAnalyticsClient = LiveVideoAnalyticsClient.create()) {
   *   BatchRunProcessRequest request =
   *       BatchRunProcessRequest.newBuilder()
   *           .setParent(ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString())
   *           .addAllRequests(new ArrayList<CreateProcessRequest>())
   *           .setOptions(BatchRunProcessRequest.BatchRunProcessOptions.newBuilder().build())
   *           .setBatchId("batchId-331744779")
   *           .build();
   *   BatchRunProcessResponse response =
   *       liveVideoAnalyticsClient.batchRunProcessAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<BatchRunProcessResponse, OperationMetadata> batchRunProcessAsync(
      BatchRunProcessRequest request) {
    return batchRunProcessOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Run all of the processes to "completion". Max time for each process is the LRO time limit.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveVideoAnalyticsClient liveVideoAnalyticsClient = LiveVideoAnalyticsClient.create()) {
   *   BatchRunProcessRequest request =
   *       BatchRunProcessRequest.newBuilder()
   *           .setParent(ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString())
   *           .addAllRequests(new ArrayList<CreateProcessRequest>())
   *           .setOptions(BatchRunProcessRequest.BatchRunProcessOptions.newBuilder().build())
   *           .setBatchId("batchId-331744779")
   *           .build();
   *   OperationFuture<BatchRunProcessResponse, OperationMetadata> future =
   *       liveVideoAnalyticsClient.batchRunProcessOperationCallable().futureCall(request);
   *   // Do something.
   *   BatchRunProcessResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<BatchRunProcessRequest, BatchRunProcessResponse, OperationMetadata>
      batchRunProcessOperationCallable() {
    return stub.batchRunProcessOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Run all of the processes to "completion". Max time for each process is the LRO time limit.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveVideoAnalyticsClient liveVideoAnalyticsClient = LiveVideoAnalyticsClient.create()) {
   *   BatchRunProcessRequest request =
   *       BatchRunProcessRequest.newBuilder()
   *           .setParent(ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString())
   *           .addAllRequests(new ArrayList<CreateProcessRequest>())
   *           .setOptions(BatchRunProcessRequest.BatchRunProcessOptions.newBuilder().build())
   *           .setBatchId("batchId-331744779")
   *           .build();
   *   ApiFuture<Operation> future =
   *       liveVideoAnalyticsClient.batchRunProcessCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchRunProcessRequest, Operation> batchRunProcessCallable() {
    return stub.batchRunProcessCallable();
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

  public static class ListPublicOperatorsPagedResponse
      extends AbstractPagedListResponse<
          ListPublicOperatorsRequest,
          ListPublicOperatorsResponse,
          Operator,
          ListPublicOperatorsPage,
          ListPublicOperatorsFixedSizeCollection> {

    public static ApiFuture<ListPublicOperatorsPagedResponse> createAsync(
        PageContext<ListPublicOperatorsRequest, ListPublicOperatorsResponse, Operator> context,
        ApiFuture<ListPublicOperatorsResponse> futureResponse) {
      ApiFuture<ListPublicOperatorsPage> futurePage =
          ListPublicOperatorsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListPublicOperatorsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListPublicOperatorsPagedResponse(ListPublicOperatorsPage page) {
      super(page, ListPublicOperatorsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListPublicOperatorsPage
      extends AbstractPage<
          ListPublicOperatorsRequest,
          ListPublicOperatorsResponse,
          Operator,
          ListPublicOperatorsPage> {

    private ListPublicOperatorsPage(
        PageContext<ListPublicOperatorsRequest, ListPublicOperatorsResponse, Operator> context,
        ListPublicOperatorsResponse response) {
      super(context, response);
    }

    private static ListPublicOperatorsPage createEmptyPage() {
      return new ListPublicOperatorsPage(null, null);
    }

    @Override
    protected ListPublicOperatorsPage createPage(
        PageContext<ListPublicOperatorsRequest, ListPublicOperatorsResponse, Operator> context,
        ListPublicOperatorsResponse response) {
      return new ListPublicOperatorsPage(context, response);
    }

    @Override
    public ApiFuture<ListPublicOperatorsPage> createPageAsync(
        PageContext<ListPublicOperatorsRequest, ListPublicOperatorsResponse, Operator> context,
        ApiFuture<ListPublicOperatorsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListPublicOperatorsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListPublicOperatorsRequest,
          ListPublicOperatorsResponse,
          Operator,
          ListPublicOperatorsPage,
          ListPublicOperatorsFixedSizeCollection> {

    private ListPublicOperatorsFixedSizeCollection(
        List<ListPublicOperatorsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListPublicOperatorsFixedSizeCollection createEmptyCollection() {
      return new ListPublicOperatorsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListPublicOperatorsFixedSizeCollection createCollection(
        List<ListPublicOperatorsPage> pages, int collectionSize) {
      return new ListPublicOperatorsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListOperatorsPagedResponse
      extends AbstractPagedListResponse<
          ListOperatorsRequest,
          ListOperatorsResponse,
          Operator,
          ListOperatorsPage,
          ListOperatorsFixedSizeCollection> {

    public static ApiFuture<ListOperatorsPagedResponse> createAsync(
        PageContext<ListOperatorsRequest, ListOperatorsResponse, Operator> context,
        ApiFuture<ListOperatorsResponse> futureResponse) {
      ApiFuture<ListOperatorsPage> futurePage =
          ListOperatorsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListOperatorsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListOperatorsPagedResponse(ListOperatorsPage page) {
      super(page, ListOperatorsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListOperatorsPage
      extends AbstractPage<
          ListOperatorsRequest, ListOperatorsResponse, Operator, ListOperatorsPage> {

    private ListOperatorsPage(
        PageContext<ListOperatorsRequest, ListOperatorsResponse, Operator> context,
        ListOperatorsResponse response) {
      super(context, response);
    }

    private static ListOperatorsPage createEmptyPage() {
      return new ListOperatorsPage(null, null);
    }

    @Override
    protected ListOperatorsPage createPage(
        PageContext<ListOperatorsRequest, ListOperatorsResponse, Operator> context,
        ListOperatorsResponse response) {
      return new ListOperatorsPage(context, response);
    }

    @Override
    public ApiFuture<ListOperatorsPage> createPageAsync(
        PageContext<ListOperatorsRequest, ListOperatorsResponse, Operator> context,
        ApiFuture<ListOperatorsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListOperatorsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListOperatorsRequest,
          ListOperatorsResponse,
          Operator,
          ListOperatorsPage,
          ListOperatorsFixedSizeCollection> {

    private ListOperatorsFixedSizeCollection(List<ListOperatorsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListOperatorsFixedSizeCollection createEmptyCollection() {
      return new ListOperatorsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListOperatorsFixedSizeCollection createCollection(
        List<ListOperatorsPage> pages, int collectionSize) {
      return new ListOperatorsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListAnalysesPagedResponse
      extends AbstractPagedListResponse<
          ListAnalysesRequest,
          ListAnalysesResponse,
          Analysis,
          ListAnalysesPage,
          ListAnalysesFixedSizeCollection> {

    public static ApiFuture<ListAnalysesPagedResponse> createAsync(
        PageContext<ListAnalysesRequest, ListAnalysesResponse, Analysis> context,
        ApiFuture<ListAnalysesResponse> futureResponse) {
      ApiFuture<ListAnalysesPage> futurePage =
          ListAnalysesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListAnalysesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListAnalysesPagedResponse(ListAnalysesPage page) {
      super(page, ListAnalysesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListAnalysesPage
      extends AbstractPage<ListAnalysesRequest, ListAnalysesResponse, Analysis, ListAnalysesPage> {

    private ListAnalysesPage(
        PageContext<ListAnalysesRequest, ListAnalysesResponse, Analysis> context,
        ListAnalysesResponse response) {
      super(context, response);
    }

    private static ListAnalysesPage createEmptyPage() {
      return new ListAnalysesPage(null, null);
    }

    @Override
    protected ListAnalysesPage createPage(
        PageContext<ListAnalysesRequest, ListAnalysesResponse, Analysis> context,
        ListAnalysesResponse response) {
      return new ListAnalysesPage(context, response);
    }

    @Override
    public ApiFuture<ListAnalysesPage> createPageAsync(
        PageContext<ListAnalysesRequest, ListAnalysesResponse, Analysis> context,
        ApiFuture<ListAnalysesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListAnalysesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListAnalysesRequest,
          ListAnalysesResponse,
          Analysis,
          ListAnalysesPage,
          ListAnalysesFixedSizeCollection> {

    private ListAnalysesFixedSizeCollection(List<ListAnalysesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListAnalysesFixedSizeCollection createEmptyCollection() {
      return new ListAnalysesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListAnalysesFixedSizeCollection createCollection(
        List<ListAnalysesPage> pages, int collectionSize) {
      return new ListAnalysesFixedSizeCollection(pages, collectionSize);
    }
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
}
