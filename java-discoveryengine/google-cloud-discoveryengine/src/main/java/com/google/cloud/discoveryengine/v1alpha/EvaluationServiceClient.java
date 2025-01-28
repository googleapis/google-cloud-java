/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.discoveryengine.v1alpha;

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
import com.google.cloud.discoveryengine.v1alpha.stub.EvaluationServiceStub;
import com.google.cloud.discoveryengine.v1alpha.stub.EvaluationServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.longrunning.Operation;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service for managing
 * [Evaluation][google.cloud.discoveryengine.v1alpha.Evaluation]s,
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
 * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
 *   EvaluationName name = EvaluationName.of("[PROJECT]", "[LOCATION]", "[EVALUATION]");
 *   Evaluation response = evaluationServiceClient.getEvaluation(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the EvaluationServiceClient object to clean up resources
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
 *      <td><p> GetEvaluation</td>
 *      <td><p> Gets a [Evaluation][google.cloud.discoveryengine.v1alpha.Evaluation].</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getEvaluation(GetEvaluationRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getEvaluation(EvaluationName name)
 *           <li><p> getEvaluation(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getEvaluationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListEvaluations</td>
 *      <td><p> Gets a list of [Evaluation][google.cloud.discoveryengine.v1alpha.Evaluation]s.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listEvaluations(ListEvaluationsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listEvaluations(LocationName parent)
 *           <li><p> listEvaluations(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listEvaluationsPagedCallable()
 *           <li><p> listEvaluationsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateEvaluation</td>
 *      <td><p> Creates a [Evaluation][google.cloud.discoveryengine.v1alpha.Evaluation].
 * <p>  Upon creation, the evaluation will be automatically triggered and begin execution.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createEvaluationAsync(CreateEvaluationRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createEvaluationAsync(LocationName parent, Evaluation evaluation)
 *           <li><p> createEvaluationAsync(String parent, Evaluation evaluation)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createEvaluationOperationCallable()
 *           <li><p> createEvaluationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListEvaluationResults</td>
 *      <td><p> Gets a list of results for a given a [Evaluation][google.cloud.discoveryengine.v1alpha.Evaluation].</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listEvaluationResults(ListEvaluationResultsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listEvaluationResults(EvaluationName evaluation)
 *           <li><p> listEvaluationResults(String evaluation)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listEvaluationResultsPagedCallable()
 *           <li><p> listEvaluationResultsCallable()
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
 * <p>This class can be customized by passing in a custom instance of EvaluationServiceSettings to
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
 * EvaluationServiceSettings evaluationServiceSettings =
 *     EvaluationServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * EvaluationServiceClient evaluationServiceClient =
 *     EvaluationServiceClient.create(evaluationServiceSettings);
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
 * EvaluationServiceSettings evaluationServiceSettings =
 *     EvaluationServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * EvaluationServiceClient evaluationServiceClient =
 *     EvaluationServiceClient.create(evaluationServiceSettings);
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
 * EvaluationServiceSettings evaluationServiceSettings =
 *     EvaluationServiceSettings.newHttpJsonBuilder().build();
 * EvaluationServiceClient evaluationServiceClient =
 *     EvaluationServiceClient.create(evaluationServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class EvaluationServiceClient implements BackgroundResource {
  private final EvaluationServiceSettings settings;
  private final EvaluationServiceStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of EvaluationServiceClient with default settings. */
  public static final EvaluationServiceClient create() throws IOException {
    return create(EvaluationServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of EvaluationServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final EvaluationServiceClient create(EvaluationServiceSettings settings)
      throws IOException {
    return new EvaluationServiceClient(settings);
  }

  /**
   * Constructs an instance of EvaluationServiceClient, using the given stub for making calls. This
   * is for advanced usage - prefer using create(EvaluationServiceSettings).
   */
  public static final EvaluationServiceClient create(EvaluationServiceStub stub) {
    return new EvaluationServiceClient(stub);
  }

  /**
   * Constructs an instance of EvaluationServiceClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected EvaluationServiceClient(EvaluationServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((EvaluationServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected EvaluationServiceClient(EvaluationServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final EvaluationServiceSettings getSettings() {
    return settings;
  }

  public EvaluationServiceStub getStub() {
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
   * Gets a [Evaluation][google.cloud.discoveryengine.v1alpha.Evaluation].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   EvaluationName name = EvaluationName.of("[PROJECT]", "[LOCATION]", "[EVALUATION]");
   *   Evaluation response = evaluationServiceClient.getEvaluation(name);
   * }
   * }</pre>
   *
   * @param name Required. Full resource name of
   *     [Evaluation][google.cloud.discoveryengine.v1alpha.Evaluation], such as
   *     `projects/{project}/locations/{location}/evaluations/{evaluation}`.
   *     <p>If the caller does not have permission to access the
   *     [Evaluation][google.cloud.discoveryengine.v1alpha.Evaluation], regardless of whether or not
   *     it exists, a PERMISSION_DENIED error is returned.
   *     <p>If the requested [Evaluation][google.cloud.discoveryengine.v1alpha.Evaluation] does not
   *     exist, a NOT_FOUND error is returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Evaluation getEvaluation(EvaluationName name) {
    GetEvaluationRequest request =
        GetEvaluationRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getEvaluation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a [Evaluation][google.cloud.discoveryengine.v1alpha.Evaluation].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   String name = EvaluationName.of("[PROJECT]", "[LOCATION]", "[EVALUATION]").toString();
   *   Evaluation response = evaluationServiceClient.getEvaluation(name);
   * }
   * }</pre>
   *
   * @param name Required. Full resource name of
   *     [Evaluation][google.cloud.discoveryengine.v1alpha.Evaluation], such as
   *     `projects/{project}/locations/{location}/evaluations/{evaluation}`.
   *     <p>If the caller does not have permission to access the
   *     [Evaluation][google.cloud.discoveryengine.v1alpha.Evaluation], regardless of whether or not
   *     it exists, a PERMISSION_DENIED error is returned.
   *     <p>If the requested [Evaluation][google.cloud.discoveryengine.v1alpha.Evaluation] does not
   *     exist, a NOT_FOUND error is returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Evaluation getEvaluation(String name) {
    GetEvaluationRequest request = GetEvaluationRequest.newBuilder().setName(name).build();
    return getEvaluation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a [Evaluation][google.cloud.discoveryengine.v1alpha.Evaluation].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   GetEvaluationRequest request =
   *       GetEvaluationRequest.newBuilder()
   *           .setName(EvaluationName.of("[PROJECT]", "[LOCATION]", "[EVALUATION]").toString())
   *           .build();
   *   Evaluation response = evaluationServiceClient.getEvaluation(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Evaluation getEvaluation(GetEvaluationRequest request) {
    return getEvaluationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a [Evaluation][google.cloud.discoveryengine.v1alpha.Evaluation].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   GetEvaluationRequest request =
   *       GetEvaluationRequest.newBuilder()
   *           .setName(EvaluationName.of("[PROJECT]", "[LOCATION]", "[EVALUATION]").toString())
   *           .build();
   *   ApiFuture<Evaluation> future =
   *       evaluationServiceClient.getEvaluationCallable().futureCall(request);
   *   // Do something.
   *   Evaluation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetEvaluationRequest, Evaluation> getEvaluationCallable() {
    return stub.getEvaluationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a list of [Evaluation][google.cloud.discoveryengine.v1alpha.Evaluation]s.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Evaluation element : evaluationServiceClient.listEvaluations(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent location resource name, such as
   *     `projects/{project}/locations/{location}`.
   *     <p>If the caller does not have permission to list
   *     [Evaluation][google.cloud.discoveryengine.v1alpha.Evaluation]s under this location,
   *     regardless of whether or not this location exists, a `PERMISSION_DENIED` error is returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEvaluationsPagedResponse listEvaluations(LocationName parent) {
    ListEvaluationsRequest request =
        ListEvaluationsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listEvaluations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a list of [Evaluation][google.cloud.discoveryengine.v1alpha.Evaluation]s.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Evaluation element : evaluationServiceClient.listEvaluations(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent location resource name, such as
   *     `projects/{project}/locations/{location}`.
   *     <p>If the caller does not have permission to list
   *     [Evaluation][google.cloud.discoveryengine.v1alpha.Evaluation]s under this location,
   *     regardless of whether or not this location exists, a `PERMISSION_DENIED` error is returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEvaluationsPagedResponse listEvaluations(String parent) {
    ListEvaluationsRequest request = ListEvaluationsRequest.newBuilder().setParent(parent).build();
    return listEvaluations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a list of [Evaluation][google.cloud.discoveryengine.v1alpha.Evaluation]s.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   ListEvaluationsRequest request =
   *       ListEvaluationsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Evaluation element : evaluationServiceClient.listEvaluations(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEvaluationsPagedResponse listEvaluations(ListEvaluationsRequest request) {
    return listEvaluationsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a list of [Evaluation][google.cloud.discoveryengine.v1alpha.Evaluation]s.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   ListEvaluationsRequest request =
   *       ListEvaluationsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Evaluation> future =
   *       evaluationServiceClient.listEvaluationsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Evaluation element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListEvaluationsRequest, ListEvaluationsPagedResponse>
      listEvaluationsPagedCallable() {
    return stub.listEvaluationsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a list of [Evaluation][google.cloud.discoveryengine.v1alpha.Evaluation]s.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   ListEvaluationsRequest request =
   *       ListEvaluationsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListEvaluationsResponse response =
   *         evaluationServiceClient.listEvaluationsCallable().call(request);
   *     for (Evaluation element : response.getEvaluationsList()) {
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
  public final UnaryCallable<ListEvaluationsRequest, ListEvaluationsResponse>
      listEvaluationsCallable() {
    return stub.listEvaluationsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a [Evaluation][google.cloud.discoveryengine.v1alpha.Evaluation].
   *
   * <p>Upon creation, the evaluation will be automatically triggered and begin execution.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Evaluation evaluation = Evaluation.newBuilder().build();
   *   Evaluation response = evaluationServiceClient.createEvaluationAsync(parent, evaluation).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource name, such as
   *     `projects/{project}/locations/{location}`.
   * @param evaluation Required. The [Evaluation][google.cloud.discoveryengine.v1alpha.Evaluation]
   *     to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Evaluation, CreateEvaluationMetadata> createEvaluationAsync(
      LocationName parent, Evaluation evaluation) {
    CreateEvaluationRequest request =
        CreateEvaluationRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setEvaluation(evaluation)
            .build();
    return createEvaluationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a [Evaluation][google.cloud.discoveryengine.v1alpha.Evaluation].
   *
   * <p>Upon creation, the evaluation will be automatically triggered and begin execution.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Evaluation evaluation = Evaluation.newBuilder().build();
   *   Evaluation response = evaluationServiceClient.createEvaluationAsync(parent, evaluation).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource name, such as
   *     `projects/{project}/locations/{location}`.
   * @param evaluation Required. The [Evaluation][google.cloud.discoveryengine.v1alpha.Evaluation]
   *     to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Evaluation, CreateEvaluationMetadata> createEvaluationAsync(
      String parent, Evaluation evaluation) {
    CreateEvaluationRequest request =
        CreateEvaluationRequest.newBuilder().setParent(parent).setEvaluation(evaluation).build();
    return createEvaluationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a [Evaluation][google.cloud.discoveryengine.v1alpha.Evaluation].
   *
   * <p>Upon creation, the evaluation will be automatically triggered and begin execution.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   CreateEvaluationRequest request =
   *       CreateEvaluationRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setEvaluation(Evaluation.newBuilder().build())
   *           .build();
   *   Evaluation response = evaluationServiceClient.createEvaluationAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Evaluation, CreateEvaluationMetadata> createEvaluationAsync(
      CreateEvaluationRequest request) {
    return createEvaluationOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a [Evaluation][google.cloud.discoveryengine.v1alpha.Evaluation].
   *
   * <p>Upon creation, the evaluation will be automatically triggered and begin execution.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   CreateEvaluationRequest request =
   *       CreateEvaluationRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setEvaluation(Evaluation.newBuilder().build())
   *           .build();
   *   OperationFuture<Evaluation, CreateEvaluationMetadata> future =
   *       evaluationServiceClient.createEvaluationOperationCallable().futureCall(request);
   *   // Do something.
   *   Evaluation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateEvaluationRequest, Evaluation, CreateEvaluationMetadata>
      createEvaluationOperationCallable() {
    return stub.createEvaluationOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a [Evaluation][google.cloud.discoveryengine.v1alpha.Evaluation].
   *
   * <p>Upon creation, the evaluation will be automatically triggered and begin execution.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   CreateEvaluationRequest request =
   *       CreateEvaluationRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setEvaluation(Evaluation.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       evaluationServiceClient.createEvaluationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateEvaluationRequest, Operation> createEvaluationCallable() {
    return stub.createEvaluationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a list of results for a given a
   * [Evaluation][google.cloud.discoveryengine.v1alpha.Evaluation].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   EvaluationName evaluation = EvaluationName.of("[PROJECT]", "[LOCATION]", "[EVALUATION]");
   *   for (ListEvaluationResultsResponse.EvaluationResult element :
   *       evaluationServiceClient.listEvaluationResults(evaluation).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param evaluation Required. The evaluation resource name, such as
   *     `projects/{project}/locations/{location}/evaluations/{evaluation}`.
   *     <p>If the caller does not have permission to list [EvaluationResult][] under this
   *     evaluation, regardless of whether or not this evaluation set exists, a `PERMISSION_DENIED`
   *     error is returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEvaluationResultsPagedResponse listEvaluationResults(EvaluationName evaluation) {
    ListEvaluationResultsRequest request =
        ListEvaluationResultsRequest.newBuilder()
            .setEvaluation(evaluation == null ? null : evaluation.toString())
            .build();
    return listEvaluationResults(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a list of results for a given a
   * [Evaluation][google.cloud.discoveryengine.v1alpha.Evaluation].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   String evaluation = EvaluationName.of("[PROJECT]", "[LOCATION]", "[EVALUATION]").toString();
   *   for (ListEvaluationResultsResponse.EvaluationResult element :
   *       evaluationServiceClient.listEvaluationResults(evaluation).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param evaluation Required. The evaluation resource name, such as
   *     `projects/{project}/locations/{location}/evaluations/{evaluation}`.
   *     <p>If the caller does not have permission to list [EvaluationResult][] under this
   *     evaluation, regardless of whether or not this evaluation set exists, a `PERMISSION_DENIED`
   *     error is returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEvaluationResultsPagedResponse listEvaluationResults(String evaluation) {
    ListEvaluationResultsRequest request =
        ListEvaluationResultsRequest.newBuilder().setEvaluation(evaluation).build();
    return listEvaluationResults(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a list of results for a given a
   * [Evaluation][google.cloud.discoveryengine.v1alpha.Evaluation].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   ListEvaluationResultsRequest request =
   *       ListEvaluationResultsRequest.newBuilder()
   *           .setEvaluation(
   *               EvaluationName.of("[PROJECT]", "[LOCATION]", "[EVALUATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (ListEvaluationResultsResponse.EvaluationResult element :
   *       evaluationServiceClient.listEvaluationResults(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEvaluationResultsPagedResponse listEvaluationResults(
      ListEvaluationResultsRequest request) {
    return listEvaluationResultsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a list of results for a given a
   * [Evaluation][google.cloud.discoveryengine.v1alpha.Evaluation].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   ListEvaluationResultsRequest request =
   *       ListEvaluationResultsRequest.newBuilder()
   *           .setEvaluation(
   *               EvaluationName.of("[PROJECT]", "[LOCATION]", "[EVALUATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<ListEvaluationResultsResponse.EvaluationResult> future =
   *       evaluationServiceClient.listEvaluationResultsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (ListEvaluationResultsResponse.EvaluationResult element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListEvaluationResultsRequest, ListEvaluationResultsPagedResponse>
      listEvaluationResultsPagedCallable() {
    return stub.listEvaluationResultsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a list of results for a given a
   * [Evaluation][google.cloud.discoveryengine.v1alpha.Evaluation].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EvaluationServiceClient evaluationServiceClient = EvaluationServiceClient.create()) {
   *   ListEvaluationResultsRequest request =
   *       ListEvaluationResultsRequest.newBuilder()
   *           .setEvaluation(
   *               EvaluationName.of("[PROJECT]", "[LOCATION]", "[EVALUATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListEvaluationResultsResponse response =
   *         evaluationServiceClient.listEvaluationResultsCallable().call(request);
   *     for (ListEvaluationResultsResponse.EvaluationResult element :
   *         response.getEvaluationResultsList()) {
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
  public final UnaryCallable<ListEvaluationResultsRequest, ListEvaluationResultsResponse>
      listEvaluationResultsCallable() {
    return stub.listEvaluationResultsCallable();
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

  public static class ListEvaluationsPagedResponse
      extends AbstractPagedListResponse<
          ListEvaluationsRequest,
          ListEvaluationsResponse,
          Evaluation,
          ListEvaluationsPage,
          ListEvaluationsFixedSizeCollection> {

    public static ApiFuture<ListEvaluationsPagedResponse> createAsync(
        PageContext<ListEvaluationsRequest, ListEvaluationsResponse, Evaluation> context,
        ApiFuture<ListEvaluationsResponse> futureResponse) {
      ApiFuture<ListEvaluationsPage> futurePage =
          ListEvaluationsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListEvaluationsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListEvaluationsPagedResponse(ListEvaluationsPage page) {
      super(page, ListEvaluationsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListEvaluationsPage
      extends AbstractPage<
          ListEvaluationsRequest, ListEvaluationsResponse, Evaluation, ListEvaluationsPage> {

    private ListEvaluationsPage(
        PageContext<ListEvaluationsRequest, ListEvaluationsResponse, Evaluation> context,
        ListEvaluationsResponse response) {
      super(context, response);
    }

    private static ListEvaluationsPage createEmptyPage() {
      return new ListEvaluationsPage(null, null);
    }

    @Override
    protected ListEvaluationsPage createPage(
        PageContext<ListEvaluationsRequest, ListEvaluationsResponse, Evaluation> context,
        ListEvaluationsResponse response) {
      return new ListEvaluationsPage(context, response);
    }

    @Override
    public ApiFuture<ListEvaluationsPage> createPageAsync(
        PageContext<ListEvaluationsRequest, ListEvaluationsResponse, Evaluation> context,
        ApiFuture<ListEvaluationsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListEvaluationsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListEvaluationsRequest,
          ListEvaluationsResponse,
          Evaluation,
          ListEvaluationsPage,
          ListEvaluationsFixedSizeCollection> {

    private ListEvaluationsFixedSizeCollection(
        List<ListEvaluationsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListEvaluationsFixedSizeCollection createEmptyCollection() {
      return new ListEvaluationsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListEvaluationsFixedSizeCollection createCollection(
        List<ListEvaluationsPage> pages, int collectionSize) {
      return new ListEvaluationsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListEvaluationResultsPagedResponse
      extends AbstractPagedListResponse<
          ListEvaluationResultsRequest,
          ListEvaluationResultsResponse,
          ListEvaluationResultsResponse.EvaluationResult,
          ListEvaluationResultsPage,
          ListEvaluationResultsFixedSizeCollection> {

    public static ApiFuture<ListEvaluationResultsPagedResponse> createAsync(
        PageContext<
                ListEvaluationResultsRequest,
                ListEvaluationResultsResponse,
                ListEvaluationResultsResponse.EvaluationResult>
            context,
        ApiFuture<ListEvaluationResultsResponse> futureResponse) {
      ApiFuture<ListEvaluationResultsPage> futurePage =
          ListEvaluationResultsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListEvaluationResultsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListEvaluationResultsPagedResponse(ListEvaluationResultsPage page) {
      super(page, ListEvaluationResultsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListEvaluationResultsPage
      extends AbstractPage<
          ListEvaluationResultsRequest,
          ListEvaluationResultsResponse,
          ListEvaluationResultsResponse.EvaluationResult,
          ListEvaluationResultsPage> {

    private ListEvaluationResultsPage(
        PageContext<
                ListEvaluationResultsRequest,
                ListEvaluationResultsResponse,
                ListEvaluationResultsResponse.EvaluationResult>
            context,
        ListEvaluationResultsResponse response) {
      super(context, response);
    }

    private static ListEvaluationResultsPage createEmptyPage() {
      return new ListEvaluationResultsPage(null, null);
    }

    @Override
    protected ListEvaluationResultsPage createPage(
        PageContext<
                ListEvaluationResultsRequest,
                ListEvaluationResultsResponse,
                ListEvaluationResultsResponse.EvaluationResult>
            context,
        ListEvaluationResultsResponse response) {
      return new ListEvaluationResultsPage(context, response);
    }

    @Override
    public ApiFuture<ListEvaluationResultsPage> createPageAsync(
        PageContext<
                ListEvaluationResultsRequest,
                ListEvaluationResultsResponse,
                ListEvaluationResultsResponse.EvaluationResult>
            context,
        ApiFuture<ListEvaluationResultsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListEvaluationResultsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListEvaluationResultsRequest,
          ListEvaluationResultsResponse,
          ListEvaluationResultsResponse.EvaluationResult,
          ListEvaluationResultsPage,
          ListEvaluationResultsFixedSizeCollection> {

    private ListEvaluationResultsFixedSizeCollection(
        List<ListEvaluationResultsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListEvaluationResultsFixedSizeCollection createEmptyCollection() {
      return new ListEvaluationResultsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListEvaluationResultsFixedSizeCollection createCollection(
        List<ListEvaluationResultsPage> pages, int collectionSize) {
      return new ListEvaluationResultsFixedSizeCollection(pages, collectionSize);
    }
  }
}
