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

package com.google.cloud.dialogflow.cx.v3;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dialogflow.cx.v3.stub.ExperimentsStub;
import com.google.cloud.dialogflow.cx.v3.stub.ExperimentsStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service for managing
 * [Experiments][google.cloud.dialogflow.cx.v3.Experiment].
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
 * try (ExperimentsClient experimentsClient = ExperimentsClient.create()) {
 *   ExperimentName name =
 *       ExperimentName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[ENVIRONMENT]", "[EXPERIMENT]");
 *   Experiment response = experimentsClient.getExperiment(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the ExperimentsClient object to clean up resources such as
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
 * <p>This class can be customized by passing in a custom instance of ExperimentsSettings to
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
 * ExperimentsSettings experimentsSettings =
 *     ExperimentsSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ExperimentsClient experimentsClient = ExperimentsClient.create(experimentsSettings);
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
 * ExperimentsSettings experimentsSettings =
 *     ExperimentsSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ExperimentsClient experimentsClient = ExperimentsClient.create(experimentsSettings);
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
 * ExperimentsSettings experimentsSettings =
 *     ExperimentsSettings.newBuilder()
 *         .setTransportChannelProvider(
 *             ExperimentsSettings.defaultHttpJsonTransportProviderBuilder().build())
 *         .build();
 * ExperimentsClient experimentsClient = ExperimentsClient.create(experimentsSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class ExperimentsClient implements BackgroundResource {
  private final ExperimentsSettings settings;
  private final ExperimentsStub stub;

  /** Constructs an instance of ExperimentsClient with default settings. */
  public static final ExperimentsClient create() throws IOException {
    return create(ExperimentsSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ExperimentsClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ExperimentsClient create(ExperimentsSettings settings) throws IOException {
    return new ExperimentsClient(settings);
  }

  /**
   * Constructs an instance of ExperimentsClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(ExperimentsSettings).
   */
  public static final ExperimentsClient create(ExperimentsStub stub) {
    return new ExperimentsClient(stub);
  }

  /**
   * Constructs an instance of ExperimentsClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected ExperimentsClient(ExperimentsSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((ExperimentsStubSettings) settings.getStubSettings()).createStub();
  }

  protected ExperimentsClient(ExperimentsStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final ExperimentsSettings getSettings() {
    return settings;
  }

  public ExperimentsStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of all experiments in the specified
   * [Environment][google.cloud.dialogflow.cx.v3.Environment].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExperimentsClient experimentsClient = ExperimentsClient.create()) {
   *   EnvironmentName parent =
   *       EnvironmentName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[ENVIRONMENT]");
   *   for (Experiment element : experimentsClient.listExperiments(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The [Environment][google.cloud.dialogflow.cx.v3.Environment] to list
   *     all environments for. Format: `projects/&lt;Project ID&gt;/locations/&lt;Location
   *     ID&gt;/agents/&lt;Agent ID&gt;/environments/&lt;Environment ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListExperimentsPagedResponse listExperiments(EnvironmentName parent) {
    ListExperimentsRequest request =
        ListExperimentsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listExperiments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of all experiments in the specified
   * [Environment][google.cloud.dialogflow.cx.v3.Environment].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExperimentsClient experimentsClient = ExperimentsClient.create()) {
   *   String parent =
   *       EnvironmentName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[ENVIRONMENT]").toString();
   *   for (Experiment element : experimentsClient.listExperiments(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The [Environment][google.cloud.dialogflow.cx.v3.Environment] to list
   *     all environments for. Format: `projects/&lt;Project ID&gt;/locations/&lt;Location
   *     ID&gt;/agents/&lt;Agent ID&gt;/environments/&lt;Environment ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListExperimentsPagedResponse listExperiments(String parent) {
    ListExperimentsRequest request = ListExperimentsRequest.newBuilder().setParent(parent).build();
    return listExperiments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of all experiments in the specified
   * [Environment][google.cloud.dialogflow.cx.v3.Environment].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExperimentsClient experimentsClient = ExperimentsClient.create()) {
   *   ListExperimentsRequest request =
   *       ListExperimentsRequest.newBuilder()
   *           .setParent(
   *               EnvironmentName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[ENVIRONMENT]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Experiment element : experimentsClient.listExperiments(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListExperimentsPagedResponse listExperiments(ListExperimentsRequest request) {
    return listExperimentsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of all experiments in the specified
   * [Environment][google.cloud.dialogflow.cx.v3.Environment].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExperimentsClient experimentsClient = ExperimentsClient.create()) {
   *   ListExperimentsRequest request =
   *       ListExperimentsRequest.newBuilder()
   *           .setParent(
   *               EnvironmentName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[ENVIRONMENT]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Experiment> future =
   *       experimentsClient.listExperimentsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Experiment element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListExperimentsRequest, ListExperimentsPagedResponse>
      listExperimentsPagedCallable() {
    return stub.listExperimentsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of all experiments in the specified
   * [Environment][google.cloud.dialogflow.cx.v3.Environment].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExperimentsClient experimentsClient = ExperimentsClient.create()) {
   *   ListExperimentsRequest request =
   *       ListExperimentsRequest.newBuilder()
   *           .setParent(
   *               EnvironmentName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[ENVIRONMENT]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListExperimentsResponse response =
   *         experimentsClient.listExperimentsCallable().call(request);
   *     for (Experiment element : response.getExperimentsList()) {
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
  public final UnaryCallable<ListExperimentsRequest, ListExperimentsResponse>
      listExperimentsCallable() {
    return stub.listExperimentsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the specified [Experiment][google.cloud.dialogflow.cx.v3.Experiment].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExperimentsClient experimentsClient = ExperimentsClient.create()) {
   *   ExperimentName name =
   *       ExperimentName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[ENVIRONMENT]", "[EXPERIMENT]");
   *   Experiment response = experimentsClient.getExperiment(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the [Environment][google.cloud.dialogflow.cx.v3.Environment].
   *     Format: `projects/&lt;Project ID&gt;/locations/&lt;Location ID&gt;/agents/&lt;Agent
   *     ID&gt;/environments/&lt;Environment ID&gt;/experiments/&lt;Experiment ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Experiment getExperiment(ExperimentName name) {
    GetExperimentRequest request =
        GetExperimentRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getExperiment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the specified [Experiment][google.cloud.dialogflow.cx.v3.Experiment].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExperimentsClient experimentsClient = ExperimentsClient.create()) {
   *   String name =
   *       ExperimentName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[ENVIRONMENT]", "[EXPERIMENT]")
   *           .toString();
   *   Experiment response = experimentsClient.getExperiment(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the [Environment][google.cloud.dialogflow.cx.v3.Environment].
   *     Format: `projects/&lt;Project ID&gt;/locations/&lt;Location ID&gt;/agents/&lt;Agent
   *     ID&gt;/environments/&lt;Environment ID&gt;/experiments/&lt;Experiment ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Experiment getExperiment(String name) {
    GetExperimentRequest request = GetExperimentRequest.newBuilder().setName(name).build();
    return getExperiment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the specified [Experiment][google.cloud.dialogflow.cx.v3.Experiment].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExperimentsClient experimentsClient = ExperimentsClient.create()) {
   *   GetExperimentRequest request =
   *       GetExperimentRequest.newBuilder()
   *           .setName(
   *               ExperimentName.of(
   *                       "[PROJECT]", "[LOCATION]", "[AGENT]", "[ENVIRONMENT]", "[EXPERIMENT]")
   *                   .toString())
   *           .build();
   *   Experiment response = experimentsClient.getExperiment(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Experiment getExperiment(GetExperimentRequest request) {
    return getExperimentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the specified [Experiment][google.cloud.dialogflow.cx.v3.Experiment].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExperimentsClient experimentsClient = ExperimentsClient.create()) {
   *   GetExperimentRequest request =
   *       GetExperimentRequest.newBuilder()
   *           .setName(
   *               ExperimentName.of(
   *                       "[PROJECT]", "[LOCATION]", "[AGENT]", "[ENVIRONMENT]", "[EXPERIMENT]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Experiment> future = experimentsClient.getExperimentCallable().futureCall(request);
   *   // Do something.
   *   Experiment response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetExperimentRequest, Experiment> getExperimentCallable() {
    return stub.getExperimentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an [Experiment][google.cloud.dialogflow.cx.v3.Experiment] in the specified
   * [Environment][google.cloud.dialogflow.cx.v3.Environment].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExperimentsClient experimentsClient = ExperimentsClient.create()) {
   *   EnvironmentName parent =
   *       EnvironmentName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[ENVIRONMENT]");
   *   Experiment experiment = Experiment.newBuilder().build();
   *   Experiment response = experimentsClient.createExperiment(parent, experiment);
   * }
   * }</pre>
   *
   * @param parent Required. The [Agent][google.cloud.dialogflow.cx.v3.Agent] to create an
   *     [Environment][google.cloud.dialogflow.cx.v3.Environment] for. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/agents/&lt;Agent ID&gt;/environments/&lt;Environment
   *     ID&gt;`.
   * @param experiment Required. The experiment to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Experiment createExperiment(EnvironmentName parent, Experiment experiment) {
    CreateExperimentRequest request =
        CreateExperimentRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setExperiment(experiment)
            .build();
    return createExperiment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an [Experiment][google.cloud.dialogflow.cx.v3.Experiment] in the specified
   * [Environment][google.cloud.dialogflow.cx.v3.Environment].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExperimentsClient experimentsClient = ExperimentsClient.create()) {
   *   String parent =
   *       EnvironmentName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[ENVIRONMENT]").toString();
   *   Experiment experiment = Experiment.newBuilder().build();
   *   Experiment response = experimentsClient.createExperiment(parent, experiment);
   * }
   * }</pre>
   *
   * @param parent Required. The [Agent][google.cloud.dialogflow.cx.v3.Agent] to create an
   *     [Environment][google.cloud.dialogflow.cx.v3.Environment] for. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/agents/&lt;Agent ID&gt;/environments/&lt;Environment
   *     ID&gt;`.
   * @param experiment Required. The experiment to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Experiment createExperiment(String parent, Experiment experiment) {
    CreateExperimentRequest request =
        CreateExperimentRequest.newBuilder().setParent(parent).setExperiment(experiment).build();
    return createExperiment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an [Experiment][google.cloud.dialogflow.cx.v3.Experiment] in the specified
   * [Environment][google.cloud.dialogflow.cx.v3.Environment].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExperimentsClient experimentsClient = ExperimentsClient.create()) {
   *   CreateExperimentRequest request =
   *       CreateExperimentRequest.newBuilder()
   *           .setParent(
   *               EnvironmentName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[ENVIRONMENT]")
   *                   .toString())
   *           .setExperiment(Experiment.newBuilder().build())
   *           .build();
   *   Experiment response = experimentsClient.createExperiment(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Experiment createExperiment(CreateExperimentRequest request) {
    return createExperimentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an [Experiment][google.cloud.dialogflow.cx.v3.Experiment] in the specified
   * [Environment][google.cloud.dialogflow.cx.v3.Environment].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExperimentsClient experimentsClient = ExperimentsClient.create()) {
   *   CreateExperimentRequest request =
   *       CreateExperimentRequest.newBuilder()
   *           .setParent(
   *               EnvironmentName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[ENVIRONMENT]")
   *                   .toString())
   *           .setExperiment(Experiment.newBuilder().build())
   *           .build();
   *   ApiFuture<Experiment> future =
   *       experimentsClient.createExperimentCallable().futureCall(request);
   *   // Do something.
   *   Experiment response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateExperimentRequest, Experiment> createExperimentCallable() {
    return stub.createExperimentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified [Experiment][google.cloud.dialogflow.cx.v3.Experiment].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExperimentsClient experimentsClient = ExperimentsClient.create()) {
   *   Experiment experiment = Experiment.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Experiment response = experimentsClient.updateExperiment(experiment, updateMask);
   * }
   * }</pre>
   *
   * @param experiment Required. The experiment to update.
   * @param updateMask Required. The mask to control which fields get updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Experiment updateExperiment(Experiment experiment, FieldMask updateMask) {
    UpdateExperimentRequest request =
        UpdateExperimentRequest.newBuilder()
            .setExperiment(experiment)
            .setUpdateMask(updateMask)
            .build();
    return updateExperiment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified [Experiment][google.cloud.dialogflow.cx.v3.Experiment].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExperimentsClient experimentsClient = ExperimentsClient.create()) {
   *   UpdateExperimentRequest request =
   *       UpdateExperimentRequest.newBuilder()
   *           .setExperiment(Experiment.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Experiment response = experimentsClient.updateExperiment(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Experiment updateExperiment(UpdateExperimentRequest request) {
    return updateExperimentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified [Experiment][google.cloud.dialogflow.cx.v3.Experiment].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExperimentsClient experimentsClient = ExperimentsClient.create()) {
   *   UpdateExperimentRequest request =
   *       UpdateExperimentRequest.newBuilder()
   *           .setExperiment(Experiment.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Experiment> future =
   *       experimentsClient.updateExperimentCallable().futureCall(request);
   *   // Do something.
   *   Experiment response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateExperimentRequest, Experiment> updateExperimentCallable() {
    return stub.updateExperimentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified [Experiment][google.cloud.dialogflow.cx.v3.Experiment].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExperimentsClient experimentsClient = ExperimentsClient.create()) {
   *   ExperimentName name =
   *       ExperimentName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[ENVIRONMENT]", "[EXPERIMENT]");
   *   experimentsClient.deleteExperiment(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the [Environment][google.cloud.dialogflow.cx.v3.Environment]
   *     to delete. Format: `projects/&lt;Project ID&gt;/locations/&lt;Location
   *     ID&gt;/agents/&lt;Agent ID&gt;/environments/&lt;Environment
   *     ID&gt;/experiments/&lt;Experiment ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteExperiment(ExperimentName name) {
    DeleteExperimentRequest request =
        DeleteExperimentRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteExperiment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified [Experiment][google.cloud.dialogflow.cx.v3.Experiment].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExperimentsClient experimentsClient = ExperimentsClient.create()) {
   *   String name =
   *       ExperimentName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[ENVIRONMENT]", "[EXPERIMENT]")
   *           .toString();
   *   experimentsClient.deleteExperiment(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the [Environment][google.cloud.dialogflow.cx.v3.Environment]
   *     to delete. Format: `projects/&lt;Project ID&gt;/locations/&lt;Location
   *     ID&gt;/agents/&lt;Agent ID&gt;/environments/&lt;Environment
   *     ID&gt;/experiments/&lt;Experiment ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteExperiment(String name) {
    DeleteExperimentRequest request = DeleteExperimentRequest.newBuilder().setName(name).build();
    deleteExperiment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified [Experiment][google.cloud.dialogflow.cx.v3.Experiment].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExperimentsClient experimentsClient = ExperimentsClient.create()) {
   *   DeleteExperimentRequest request =
   *       DeleteExperimentRequest.newBuilder()
   *           .setName(
   *               ExperimentName.of(
   *                       "[PROJECT]", "[LOCATION]", "[AGENT]", "[ENVIRONMENT]", "[EXPERIMENT]")
   *                   .toString())
   *           .build();
   *   experimentsClient.deleteExperiment(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteExperiment(DeleteExperimentRequest request) {
    deleteExperimentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified [Experiment][google.cloud.dialogflow.cx.v3.Experiment].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExperimentsClient experimentsClient = ExperimentsClient.create()) {
   *   DeleteExperimentRequest request =
   *       DeleteExperimentRequest.newBuilder()
   *           .setName(
   *               ExperimentName.of(
   *                       "[PROJECT]", "[LOCATION]", "[AGENT]", "[ENVIRONMENT]", "[EXPERIMENT]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Empty> future = experimentsClient.deleteExperimentCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteExperimentRequest, Empty> deleteExperimentCallable() {
    return stub.deleteExperimentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts the specified [Experiment][google.cloud.dialogflow.cx.v3.Experiment]. This rpc only
   * changes the state of experiment from PENDING to RUNNING.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExperimentsClient experimentsClient = ExperimentsClient.create()) {
   *   ExperimentName name =
   *       ExperimentName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[ENVIRONMENT]", "[EXPERIMENT]");
   *   Experiment response = experimentsClient.startExperiment(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the experiment to start. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/agents/&lt;Agent ID&gt;/environments/&lt;Environment
   *     ID&gt;/experiments/&lt;Experiment ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Experiment startExperiment(ExperimentName name) {
    StartExperimentRequest request =
        StartExperimentRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return startExperiment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts the specified [Experiment][google.cloud.dialogflow.cx.v3.Experiment]. This rpc only
   * changes the state of experiment from PENDING to RUNNING.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExperimentsClient experimentsClient = ExperimentsClient.create()) {
   *   String name =
   *       ExperimentName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[ENVIRONMENT]", "[EXPERIMENT]")
   *           .toString();
   *   Experiment response = experimentsClient.startExperiment(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the experiment to start. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/agents/&lt;Agent ID&gt;/environments/&lt;Environment
   *     ID&gt;/experiments/&lt;Experiment ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Experiment startExperiment(String name) {
    StartExperimentRequest request = StartExperimentRequest.newBuilder().setName(name).build();
    return startExperiment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts the specified [Experiment][google.cloud.dialogflow.cx.v3.Experiment]. This rpc only
   * changes the state of experiment from PENDING to RUNNING.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExperimentsClient experimentsClient = ExperimentsClient.create()) {
   *   StartExperimentRequest request =
   *       StartExperimentRequest.newBuilder()
   *           .setName(
   *               ExperimentName.of(
   *                       "[PROJECT]", "[LOCATION]", "[AGENT]", "[ENVIRONMENT]", "[EXPERIMENT]")
   *                   .toString())
   *           .build();
   *   Experiment response = experimentsClient.startExperiment(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Experiment startExperiment(StartExperimentRequest request) {
    return startExperimentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts the specified [Experiment][google.cloud.dialogflow.cx.v3.Experiment]. This rpc only
   * changes the state of experiment from PENDING to RUNNING.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExperimentsClient experimentsClient = ExperimentsClient.create()) {
   *   StartExperimentRequest request =
   *       StartExperimentRequest.newBuilder()
   *           .setName(
   *               ExperimentName.of(
   *                       "[PROJECT]", "[LOCATION]", "[AGENT]", "[ENVIRONMENT]", "[EXPERIMENT]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Experiment> future =
   *       experimentsClient.startExperimentCallable().futureCall(request);
   *   // Do something.
   *   Experiment response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<StartExperimentRequest, Experiment> startExperimentCallable() {
    return stub.startExperimentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Stops the specified [Experiment][google.cloud.dialogflow.cx.v3.Experiment]. This rpc only
   * changes the state of experiment from RUNNING to DONE.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExperimentsClient experimentsClient = ExperimentsClient.create()) {
   *   ExperimentName name =
   *       ExperimentName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[ENVIRONMENT]", "[EXPERIMENT]");
   *   Experiment response = experimentsClient.stopExperiment(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the experiment to stop. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/agents/&lt;Agent ID&gt;/environments/&lt;Environment
   *     ID&gt;/experiments/&lt;Experiment ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Experiment stopExperiment(ExperimentName name) {
    StopExperimentRequest request =
        StopExperimentRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return stopExperiment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Stops the specified [Experiment][google.cloud.dialogflow.cx.v3.Experiment]. This rpc only
   * changes the state of experiment from RUNNING to DONE.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExperimentsClient experimentsClient = ExperimentsClient.create()) {
   *   String name =
   *       ExperimentName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[ENVIRONMENT]", "[EXPERIMENT]")
   *           .toString();
   *   Experiment response = experimentsClient.stopExperiment(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the experiment to stop. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/agents/&lt;Agent ID&gt;/environments/&lt;Environment
   *     ID&gt;/experiments/&lt;Experiment ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Experiment stopExperiment(String name) {
    StopExperimentRequest request = StopExperimentRequest.newBuilder().setName(name).build();
    return stopExperiment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Stops the specified [Experiment][google.cloud.dialogflow.cx.v3.Experiment]. This rpc only
   * changes the state of experiment from RUNNING to DONE.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExperimentsClient experimentsClient = ExperimentsClient.create()) {
   *   StopExperimentRequest request =
   *       StopExperimentRequest.newBuilder()
   *           .setName(
   *               ExperimentName.of(
   *                       "[PROJECT]", "[LOCATION]", "[AGENT]", "[ENVIRONMENT]", "[EXPERIMENT]")
   *                   .toString())
   *           .build();
   *   Experiment response = experimentsClient.stopExperiment(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Experiment stopExperiment(StopExperimentRequest request) {
    return stopExperimentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Stops the specified [Experiment][google.cloud.dialogflow.cx.v3.Experiment]. This rpc only
   * changes the state of experiment from RUNNING to DONE.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExperimentsClient experimentsClient = ExperimentsClient.create()) {
   *   StopExperimentRequest request =
   *       StopExperimentRequest.newBuilder()
   *           .setName(
   *               ExperimentName.of(
   *                       "[PROJECT]", "[LOCATION]", "[AGENT]", "[ENVIRONMENT]", "[EXPERIMENT]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Experiment> future = experimentsClient.stopExperimentCallable().futureCall(request);
   *   // Do something.
   *   Experiment response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<StopExperimentRequest, Experiment> stopExperimentCallable() {
    return stub.stopExperimentCallable();
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
   * try (ExperimentsClient experimentsClient = ExperimentsClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : experimentsClient.listLocations(request).iterateAll()) {
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
   * try (ExperimentsClient experimentsClient = ExperimentsClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       experimentsClient.listLocationsPagedCallable().futureCall(request);
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
   * try (ExperimentsClient experimentsClient = ExperimentsClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response = experimentsClient.listLocationsCallable().call(request);
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
   * try (ExperimentsClient experimentsClient = ExperimentsClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = experimentsClient.getLocation(request);
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
   * try (ExperimentsClient experimentsClient = ExperimentsClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future = experimentsClient.getLocationCallable().futureCall(request);
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

  public static class ListExperimentsPagedResponse
      extends AbstractPagedListResponse<
          ListExperimentsRequest,
          ListExperimentsResponse,
          Experiment,
          ListExperimentsPage,
          ListExperimentsFixedSizeCollection> {

    public static ApiFuture<ListExperimentsPagedResponse> createAsync(
        PageContext<ListExperimentsRequest, ListExperimentsResponse, Experiment> context,
        ApiFuture<ListExperimentsResponse> futureResponse) {
      ApiFuture<ListExperimentsPage> futurePage =
          ListExperimentsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListExperimentsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListExperimentsPagedResponse(ListExperimentsPage page) {
      super(page, ListExperimentsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListExperimentsPage
      extends AbstractPage<
          ListExperimentsRequest, ListExperimentsResponse, Experiment, ListExperimentsPage> {

    private ListExperimentsPage(
        PageContext<ListExperimentsRequest, ListExperimentsResponse, Experiment> context,
        ListExperimentsResponse response) {
      super(context, response);
    }

    private static ListExperimentsPage createEmptyPage() {
      return new ListExperimentsPage(null, null);
    }

    @Override
    protected ListExperimentsPage createPage(
        PageContext<ListExperimentsRequest, ListExperimentsResponse, Experiment> context,
        ListExperimentsResponse response) {
      return new ListExperimentsPage(context, response);
    }

    @Override
    public ApiFuture<ListExperimentsPage> createPageAsync(
        PageContext<ListExperimentsRequest, ListExperimentsResponse, Experiment> context,
        ApiFuture<ListExperimentsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListExperimentsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListExperimentsRequest,
          ListExperimentsResponse,
          Experiment,
          ListExperimentsPage,
          ListExperimentsFixedSizeCollection> {

    private ListExperimentsFixedSizeCollection(
        List<ListExperimentsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListExperimentsFixedSizeCollection createEmptyCollection() {
      return new ListExperimentsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListExperimentsFixedSizeCollection createCollection(
        List<ListExperimentsPage> pages, int collectionSize) {
      return new ListExperimentsFixedSizeCollection(pages, collectionSize);
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
