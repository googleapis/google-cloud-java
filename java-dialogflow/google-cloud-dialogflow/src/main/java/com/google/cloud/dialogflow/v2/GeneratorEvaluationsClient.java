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

package com.google.cloud.dialogflow.v2;

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
import com.google.cloud.dialogflow.v2.stub.GeneratorEvaluationsStub;
import com.google.cloud.dialogflow.v2.stub.GeneratorEvaluationsStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service for managing generator evaluations.
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
 * try (GeneratorEvaluationsClient generatorEvaluationsClient =
 *     GeneratorEvaluationsClient.create()) {
 *   GeneratorEvaluationName name =
 *       GeneratorEvaluationName.of("[PROJECT]", "[LOCATION]", "[GENERATOR]", "[EVALUATION]");
 *   GeneratorEvaluation response = generatorEvaluationsClient.getGeneratorEvaluation(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the GeneratorEvaluationsClient object to clean up
 * resources such as threads. In the example above, try-with-resources is used, which automatically
 * calls close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> CreateGeneratorEvaluation</td>
 *      <td><p> Creates evaluation of a generator.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createGeneratorEvaluationAsync(CreateGeneratorEvaluationRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createGeneratorEvaluationAsync(GeneratorName parent, GeneratorEvaluation generatorEvaluation)
 *           <li><p> createGeneratorEvaluationAsync(String parent, GeneratorEvaluation generatorEvaluation)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createGeneratorEvaluationOperationCallable()
 *           <li><p> createGeneratorEvaluationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetGeneratorEvaluation</td>
 *      <td><p> Gets an evaluation of generator.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getGeneratorEvaluation(GetGeneratorEvaluationRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getGeneratorEvaluation(GeneratorEvaluationName name)
 *           <li><p> getGeneratorEvaluation(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getGeneratorEvaluationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListGeneratorEvaluations</td>
 *      <td><p> Lists evaluations of generator.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listGeneratorEvaluations(ListGeneratorEvaluationsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listGeneratorEvaluations(GeneratorName parent)
 *           <li><p> listGeneratorEvaluations(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listGeneratorEvaluationsPagedCallable()
 *           <li><p> listGeneratorEvaluationsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteGeneratorEvaluation</td>
 *      <td><p> Deletes an evaluation of generator.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteGeneratorEvaluation(DeleteGeneratorEvaluationRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteGeneratorEvaluation(GeneratorEvaluationName name)
 *           <li><p> deleteGeneratorEvaluation(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteGeneratorEvaluationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListLocations</td>
 *      <td><p> Lists information about the supported locations for this service.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listLocations(ListLocationsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listLocationsPagedCallable()
 *           <li><p> listLocationsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetLocation</td>
 *      <td><p> Gets information about a location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getLocation(GetLocationRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getLocationCallable()
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
 * <p>This class can be customized by passing in a custom instance of GeneratorEvaluationsSettings
 * to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * GeneratorEvaluationsSettings generatorEvaluationsSettings =
 *     GeneratorEvaluationsSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * GeneratorEvaluationsClient generatorEvaluationsClient =
 *     GeneratorEvaluationsClient.create(generatorEvaluationsSettings);
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
 * GeneratorEvaluationsSettings generatorEvaluationsSettings =
 *     GeneratorEvaluationsSettings.newBuilder().setEndpoint(myEndpoint).build();
 * GeneratorEvaluationsClient generatorEvaluationsClient =
 *     GeneratorEvaluationsClient.create(generatorEvaluationsSettings);
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
 * GeneratorEvaluationsSettings generatorEvaluationsSettings =
 *     GeneratorEvaluationsSettings.newHttpJsonBuilder().build();
 * GeneratorEvaluationsClient generatorEvaluationsClient =
 *     GeneratorEvaluationsClient.create(generatorEvaluationsSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class GeneratorEvaluationsClient implements BackgroundResource {
  private final GeneratorEvaluationsSettings settings;
  private final GeneratorEvaluationsStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of GeneratorEvaluationsClient with default settings. */
  public static final GeneratorEvaluationsClient create() throws IOException {
    return create(GeneratorEvaluationsSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of GeneratorEvaluationsClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final GeneratorEvaluationsClient create(GeneratorEvaluationsSettings settings)
      throws IOException {
    return new GeneratorEvaluationsClient(settings);
  }

  /**
   * Constructs an instance of GeneratorEvaluationsClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(GeneratorEvaluationsSettings).
   */
  public static final GeneratorEvaluationsClient create(GeneratorEvaluationsStub stub) {
    return new GeneratorEvaluationsClient(stub);
  }

  /**
   * Constructs an instance of GeneratorEvaluationsClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GeneratorEvaluationsClient(GeneratorEvaluationsSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((GeneratorEvaluationsStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected GeneratorEvaluationsClient(GeneratorEvaluationsStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final GeneratorEvaluationsSettings getSettings() {
    return settings;
  }

  public GeneratorEvaluationsStub getStub() {
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
   * Creates evaluation of a generator.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GeneratorEvaluationsClient generatorEvaluationsClient =
   *     GeneratorEvaluationsClient.create()) {
   *   GeneratorName parent = GeneratorName.of("[PROJECT]", "[LOCATION]", "[GENERATOR]");
   *   GeneratorEvaluation generatorEvaluation = GeneratorEvaluation.newBuilder().build();
   *   GeneratorEvaluation response =
   *       generatorEvaluationsClient
   *           .createGeneratorEvaluationAsync(parent, generatorEvaluation)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The generator resource name. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/generators/&lt;Generator ID&gt;`
   * @param generatorEvaluation Required. The generator evaluation to be created.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<GeneratorEvaluation, GeneratorEvaluationOperationMetadata>
      createGeneratorEvaluationAsync(
          GeneratorName parent, GeneratorEvaluation generatorEvaluation) {
    CreateGeneratorEvaluationRequest request =
        CreateGeneratorEvaluationRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setGeneratorEvaluation(generatorEvaluation)
            .build();
    return createGeneratorEvaluationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates evaluation of a generator.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GeneratorEvaluationsClient generatorEvaluationsClient =
   *     GeneratorEvaluationsClient.create()) {
   *   String parent = GeneratorName.of("[PROJECT]", "[LOCATION]", "[GENERATOR]").toString();
   *   GeneratorEvaluation generatorEvaluation = GeneratorEvaluation.newBuilder().build();
   *   GeneratorEvaluation response =
   *       generatorEvaluationsClient
   *           .createGeneratorEvaluationAsync(parent, generatorEvaluation)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The generator resource name. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/generators/&lt;Generator ID&gt;`
   * @param generatorEvaluation Required. The generator evaluation to be created.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<GeneratorEvaluation, GeneratorEvaluationOperationMetadata>
      createGeneratorEvaluationAsync(String parent, GeneratorEvaluation generatorEvaluation) {
    CreateGeneratorEvaluationRequest request =
        CreateGeneratorEvaluationRequest.newBuilder()
            .setParent(parent)
            .setGeneratorEvaluation(generatorEvaluation)
            .build();
    return createGeneratorEvaluationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates evaluation of a generator.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GeneratorEvaluationsClient generatorEvaluationsClient =
   *     GeneratorEvaluationsClient.create()) {
   *   CreateGeneratorEvaluationRequest request =
   *       CreateGeneratorEvaluationRequest.newBuilder()
   *           .setParent(GeneratorName.of("[PROJECT]", "[LOCATION]", "[GENERATOR]").toString())
   *           .setGeneratorEvaluation(GeneratorEvaluation.newBuilder().build())
   *           .build();
   *   GeneratorEvaluation response =
   *       generatorEvaluationsClient.createGeneratorEvaluationAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<GeneratorEvaluation, GeneratorEvaluationOperationMetadata>
      createGeneratorEvaluationAsync(CreateGeneratorEvaluationRequest request) {
    return createGeneratorEvaluationOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates evaluation of a generator.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GeneratorEvaluationsClient generatorEvaluationsClient =
   *     GeneratorEvaluationsClient.create()) {
   *   CreateGeneratorEvaluationRequest request =
   *       CreateGeneratorEvaluationRequest.newBuilder()
   *           .setParent(GeneratorName.of("[PROJECT]", "[LOCATION]", "[GENERATOR]").toString())
   *           .setGeneratorEvaluation(GeneratorEvaluation.newBuilder().build())
   *           .build();
   *   OperationFuture<GeneratorEvaluation, GeneratorEvaluationOperationMetadata> future =
   *       generatorEvaluationsClient
   *           .createGeneratorEvaluationOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   GeneratorEvaluation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          CreateGeneratorEvaluationRequest,
          GeneratorEvaluation,
          GeneratorEvaluationOperationMetadata>
      createGeneratorEvaluationOperationCallable() {
    return stub.createGeneratorEvaluationOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates evaluation of a generator.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GeneratorEvaluationsClient generatorEvaluationsClient =
   *     GeneratorEvaluationsClient.create()) {
   *   CreateGeneratorEvaluationRequest request =
   *       CreateGeneratorEvaluationRequest.newBuilder()
   *           .setParent(GeneratorName.of("[PROJECT]", "[LOCATION]", "[GENERATOR]").toString())
   *           .setGeneratorEvaluation(GeneratorEvaluation.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       generatorEvaluationsClient.createGeneratorEvaluationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateGeneratorEvaluationRequest, Operation>
      createGeneratorEvaluationCallable() {
    return stub.createGeneratorEvaluationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an evaluation of generator.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GeneratorEvaluationsClient generatorEvaluationsClient =
   *     GeneratorEvaluationsClient.create()) {
   *   GeneratorEvaluationName name =
   *       GeneratorEvaluationName.of("[PROJECT]", "[LOCATION]", "[GENERATOR]", "[EVALUATION]");
   *   GeneratorEvaluation response = generatorEvaluationsClient.getGeneratorEvaluation(name);
   * }
   * }</pre>
   *
   * @param name Required. The generator evaluation resource name. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/generators/&lt;Generator
   *     ID&gt;/evaluations/&lt;Evaluation ID&gt;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GeneratorEvaluation getGeneratorEvaluation(GeneratorEvaluationName name) {
    GetGeneratorEvaluationRequest request =
        GetGeneratorEvaluationRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getGeneratorEvaluation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an evaluation of generator.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GeneratorEvaluationsClient generatorEvaluationsClient =
   *     GeneratorEvaluationsClient.create()) {
   *   String name =
   *       GeneratorEvaluationName.of("[PROJECT]", "[LOCATION]", "[GENERATOR]", "[EVALUATION]")
   *           .toString();
   *   GeneratorEvaluation response = generatorEvaluationsClient.getGeneratorEvaluation(name);
   * }
   * }</pre>
   *
   * @param name Required. The generator evaluation resource name. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/generators/&lt;Generator
   *     ID&gt;/evaluations/&lt;Evaluation ID&gt;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GeneratorEvaluation getGeneratorEvaluation(String name) {
    GetGeneratorEvaluationRequest request =
        GetGeneratorEvaluationRequest.newBuilder().setName(name).build();
    return getGeneratorEvaluation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an evaluation of generator.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GeneratorEvaluationsClient generatorEvaluationsClient =
   *     GeneratorEvaluationsClient.create()) {
   *   GetGeneratorEvaluationRequest request =
   *       GetGeneratorEvaluationRequest.newBuilder()
   *           .setName(
   *               GeneratorEvaluationName.of(
   *                       "[PROJECT]", "[LOCATION]", "[GENERATOR]", "[EVALUATION]")
   *                   .toString())
   *           .build();
   *   GeneratorEvaluation response = generatorEvaluationsClient.getGeneratorEvaluation(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GeneratorEvaluation getGeneratorEvaluation(GetGeneratorEvaluationRequest request) {
    return getGeneratorEvaluationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an evaluation of generator.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GeneratorEvaluationsClient generatorEvaluationsClient =
   *     GeneratorEvaluationsClient.create()) {
   *   GetGeneratorEvaluationRequest request =
   *       GetGeneratorEvaluationRequest.newBuilder()
   *           .setName(
   *               GeneratorEvaluationName.of(
   *                       "[PROJECT]", "[LOCATION]", "[GENERATOR]", "[EVALUATION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<GeneratorEvaluation> future =
   *       generatorEvaluationsClient.getGeneratorEvaluationCallable().futureCall(request);
   *   // Do something.
   *   GeneratorEvaluation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetGeneratorEvaluationRequest, GeneratorEvaluation>
      getGeneratorEvaluationCallable() {
    return stub.getGeneratorEvaluationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists evaluations of generator.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GeneratorEvaluationsClient generatorEvaluationsClient =
   *     GeneratorEvaluationsClient.create()) {
   *   GeneratorName parent = GeneratorName.of("[PROJECT]", "[LOCATION]", "[GENERATOR]");
   *   for (GeneratorEvaluation element :
   *       generatorEvaluationsClient.listGeneratorEvaluations(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The generator resource name. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/generators/&lt;Generator ID&gt;` Wildcard value `-` is
   *     supported on generator_id to list evaluations across all generators under same project.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListGeneratorEvaluationsPagedResponse listGeneratorEvaluations(
      GeneratorName parent) {
    ListGeneratorEvaluationsRequest request =
        ListGeneratorEvaluationsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listGeneratorEvaluations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists evaluations of generator.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GeneratorEvaluationsClient generatorEvaluationsClient =
   *     GeneratorEvaluationsClient.create()) {
   *   String parent = GeneratorName.of("[PROJECT]", "[LOCATION]", "[GENERATOR]").toString();
   *   for (GeneratorEvaluation element :
   *       generatorEvaluationsClient.listGeneratorEvaluations(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The generator resource name. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/generators/&lt;Generator ID&gt;` Wildcard value `-` is
   *     supported on generator_id to list evaluations across all generators under same project.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListGeneratorEvaluationsPagedResponse listGeneratorEvaluations(String parent) {
    ListGeneratorEvaluationsRequest request =
        ListGeneratorEvaluationsRequest.newBuilder().setParent(parent).build();
    return listGeneratorEvaluations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists evaluations of generator.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GeneratorEvaluationsClient generatorEvaluationsClient =
   *     GeneratorEvaluationsClient.create()) {
   *   ListGeneratorEvaluationsRequest request =
   *       ListGeneratorEvaluationsRequest.newBuilder()
   *           .setParent(GeneratorName.of("[PROJECT]", "[LOCATION]", "[GENERATOR]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (GeneratorEvaluation element :
   *       generatorEvaluationsClient.listGeneratorEvaluations(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListGeneratorEvaluationsPagedResponse listGeneratorEvaluations(
      ListGeneratorEvaluationsRequest request) {
    return listGeneratorEvaluationsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists evaluations of generator.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GeneratorEvaluationsClient generatorEvaluationsClient =
   *     GeneratorEvaluationsClient.create()) {
   *   ListGeneratorEvaluationsRequest request =
   *       ListGeneratorEvaluationsRequest.newBuilder()
   *           .setParent(GeneratorName.of("[PROJECT]", "[LOCATION]", "[GENERATOR]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<GeneratorEvaluation> future =
   *       generatorEvaluationsClient.listGeneratorEvaluationsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (GeneratorEvaluation element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListGeneratorEvaluationsRequest, ListGeneratorEvaluationsPagedResponse>
      listGeneratorEvaluationsPagedCallable() {
    return stub.listGeneratorEvaluationsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists evaluations of generator.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GeneratorEvaluationsClient generatorEvaluationsClient =
   *     GeneratorEvaluationsClient.create()) {
   *   ListGeneratorEvaluationsRequest request =
   *       ListGeneratorEvaluationsRequest.newBuilder()
   *           .setParent(GeneratorName.of("[PROJECT]", "[LOCATION]", "[GENERATOR]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListGeneratorEvaluationsResponse response =
   *         generatorEvaluationsClient.listGeneratorEvaluationsCallable().call(request);
   *     for (GeneratorEvaluation element : response.getGeneratorEvaluationsList()) {
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
  public final UnaryCallable<ListGeneratorEvaluationsRequest, ListGeneratorEvaluationsResponse>
      listGeneratorEvaluationsCallable() {
    return stub.listGeneratorEvaluationsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an evaluation of generator.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GeneratorEvaluationsClient generatorEvaluationsClient =
   *     GeneratorEvaluationsClient.create()) {
   *   GeneratorEvaluationName name =
   *       GeneratorEvaluationName.of("[PROJECT]", "[LOCATION]", "[GENERATOR]", "[EVALUATION]");
   *   generatorEvaluationsClient.deleteGeneratorEvaluation(name);
   * }
   * }</pre>
   *
   * @param name Required. The generator evaluation resource name. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/generators/&lt;Generator ID&gt;/
   *     evaluations/&lt;Evaluation ID&gt;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteGeneratorEvaluation(GeneratorEvaluationName name) {
    DeleteGeneratorEvaluationRequest request =
        DeleteGeneratorEvaluationRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteGeneratorEvaluation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an evaluation of generator.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GeneratorEvaluationsClient generatorEvaluationsClient =
   *     GeneratorEvaluationsClient.create()) {
   *   String name =
   *       GeneratorEvaluationName.of("[PROJECT]", "[LOCATION]", "[GENERATOR]", "[EVALUATION]")
   *           .toString();
   *   generatorEvaluationsClient.deleteGeneratorEvaluation(name);
   * }
   * }</pre>
   *
   * @param name Required. The generator evaluation resource name. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/generators/&lt;Generator ID&gt;/
   *     evaluations/&lt;Evaluation ID&gt;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteGeneratorEvaluation(String name) {
    DeleteGeneratorEvaluationRequest request =
        DeleteGeneratorEvaluationRequest.newBuilder().setName(name).build();
    deleteGeneratorEvaluation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an evaluation of generator.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GeneratorEvaluationsClient generatorEvaluationsClient =
   *     GeneratorEvaluationsClient.create()) {
   *   DeleteGeneratorEvaluationRequest request =
   *       DeleteGeneratorEvaluationRequest.newBuilder()
   *           .setName(
   *               GeneratorEvaluationName.of(
   *                       "[PROJECT]", "[LOCATION]", "[GENERATOR]", "[EVALUATION]")
   *                   .toString())
   *           .build();
   *   generatorEvaluationsClient.deleteGeneratorEvaluation(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteGeneratorEvaluation(DeleteGeneratorEvaluationRequest request) {
    deleteGeneratorEvaluationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an evaluation of generator.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GeneratorEvaluationsClient generatorEvaluationsClient =
   *     GeneratorEvaluationsClient.create()) {
   *   DeleteGeneratorEvaluationRequest request =
   *       DeleteGeneratorEvaluationRequest.newBuilder()
   *           .setName(
   *               GeneratorEvaluationName.of(
   *                       "[PROJECT]", "[LOCATION]", "[GENERATOR]", "[EVALUATION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       generatorEvaluationsClient.deleteGeneratorEvaluationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteGeneratorEvaluationRequest, Empty>
      deleteGeneratorEvaluationCallable() {
    return stub.deleteGeneratorEvaluationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about the supported locations for this service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GeneratorEvaluationsClient generatorEvaluationsClient =
   *     GeneratorEvaluationsClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : generatorEvaluationsClient.listLocations(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLocationsPagedResponse listLocations(ListLocationsRequest request) {
    return listLocationsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about the supported locations for this service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GeneratorEvaluationsClient generatorEvaluationsClient =
   *     GeneratorEvaluationsClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       generatorEvaluationsClient.listLocationsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Location element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    return stub.listLocationsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about the supported locations for this service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GeneratorEvaluationsClient generatorEvaluationsClient =
   *     GeneratorEvaluationsClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response =
   *         generatorEvaluationsClient.listLocationsCallable().call(request);
   *     for (Location element : response.getLocationsList()) {
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
  public final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    return stub.listLocationsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GeneratorEvaluationsClient generatorEvaluationsClient =
   *     GeneratorEvaluationsClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = generatorEvaluationsClient.getLocation(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Location getLocation(GetLocationRequest request) {
    return getLocationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GeneratorEvaluationsClient generatorEvaluationsClient =
   *     GeneratorEvaluationsClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future =
   *       generatorEvaluationsClient.getLocationCallable().futureCall(request);
   *   // Do something.
   *   Location response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    return stub.getLocationCallable();
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

  public static class ListGeneratorEvaluationsPagedResponse
      extends AbstractPagedListResponse<
          ListGeneratorEvaluationsRequest,
          ListGeneratorEvaluationsResponse,
          GeneratorEvaluation,
          ListGeneratorEvaluationsPage,
          ListGeneratorEvaluationsFixedSizeCollection> {

    public static ApiFuture<ListGeneratorEvaluationsPagedResponse> createAsync(
        PageContext<
                ListGeneratorEvaluationsRequest,
                ListGeneratorEvaluationsResponse,
                GeneratorEvaluation>
            context,
        ApiFuture<ListGeneratorEvaluationsResponse> futureResponse) {
      ApiFuture<ListGeneratorEvaluationsPage> futurePage =
          ListGeneratorEvaluationsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListGeneratorEvaluationsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListGeneratorEvaluationsPagedResponse(ListGeneratorEvaluationsPage page) {
      super(page, ListGeneratorEvaluationsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListGeneratorEvaluationsPage
      extends AbstractPage<
          ListGeneratorEvaluationsRequest,
          ListGeneratorEvaluationsResponse,
          GeneratorEvaluation,
          ListGeneratorEvaluationsPage> {

    private ListGeneratorEvaluationsPage(
        PageContext<
                ListGeneratorEvaluationsRequest,
                ListGeneratorEvaluationsResponse,
                GeneratorEvaluation>
            context,
        ListGeneratorEvaluationsResponse response) {
      super(context, response);
    }

    private static ListGeneratorEvaluationsPage createEmptyPage() {
      return new ListGeneratorEvaluationsPage(null, null);
    }

    @Override
    protected ListGeneratorEvaluationsPage createPage(
        PageContext<
                ListGeneratorEvaluationsRequest,
                ListGeneratorEvaluationsResponse,
                GeneratorEvaluation>
            context,
        ListGeneratorEvaluationsResponse response) {
      return new ListGeneratorEvaluationsPage(context, response);
    }

    @Override
    public ApiFuture<ListGeneratorEvaluationsPage> createPageAsync(
        PageContext<
                ListGeneratorEvaluationsRequest,
                ListGeneratorEvaluationsResponse,
                GeneratorEvaluation>
            context,
        ApiFuture<ListGeneratorEvaluationsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListGeneratorEvaluationsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListGeneratorEvaluationsRequest,
          ListGeneratorEvaluationsResponse,
          GeneratorEvaluation,
          ListGeneratorEvaluationsPage,
          ListGeneratorEvaluationsFixedSizeCollection> {

    private ListGeneratorEvaluationsFixedSizeCollection(
        List<ListGeneratorEvaluationsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListGeneratorEvaluationsFixedSizeCollection createEmptyCollection() {
      return new ListGeneratorEvaluationsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListGeneratorEvaluationsFixedSizeCollection createCollection(
        List<ListGeneratorEvaluationsPage> pages, int collectionSize) {
      return new ListGeneratorEvaluationsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListLocationsPagedResponse
      extends AbstractPagedListResponse<
          ListLocationsRequest,
          ListLocationsResponse,
          Location,
          ListLocationsPage,
          ListLocationsFixedSizeCollection> {

    public static ApiFuture<ListLocationsPagedResponse> createAsync(
        PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        ApiFuture<ListLocationsResponse> futureResponse) {
      ApiFuture<ListLocationsPage> futurePage =
          ListLocationsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListLocationsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListLocationsPagedResponse(ListLocationsPage page) {
      super(page, ListLocationsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListLocationsPage
      extends AbstractPage<
          ListLocationsRequest, ListLocationsResponse, Location, ListLocationsPage> {

    private ListLocationsPage(
        PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        ListLocationsResponse response) {
      super(context, response);
    }

    private static ListLocationsPage createEmptyPage() {
      return new ListLocationsPage(null, null);
    }

    @Override
    protected ListLocationsPage createPage(
        PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        ListLocationsResponse response) {
      return new ListLocationsPage(context, response);
    }

    @Override
    public ApiFuture<ListLocationsPage> createPageAsync(
        PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        ApiFuture<ListLocationsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListLocationsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListLocationsRequest,
          ListLocationsResponse,
          Location,
          ListLocationsPage,
          ListLocationsFixedSizeCollection> {

    private ListLocationsFixedSizeCollection(List<ListLocationsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListLocationsFixedSizeCollection createEmptyCollection() {
      return new ListLocationsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListLocationsFixedSizeCollection createCollection(
        List<ListLocationsPage> pages, int collectionSize) {
      return new ListLocationsFixedSizeCollection(pages, collectionSize);
    }
  }
}
