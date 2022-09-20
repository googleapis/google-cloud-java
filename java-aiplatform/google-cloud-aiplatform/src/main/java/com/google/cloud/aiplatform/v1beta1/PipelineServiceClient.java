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

package com.google.cloud.aiplatform.v1beta1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.aiplatform.v1beta1.stub.PipelineServiceStub;
import com.google.cloud.aiplatform.v1beta1.stub.PipelineServiceStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.longrunning.OperationsClient;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: A service for creating and managing Vertex AI's pipelines. This includes
 * both `TrainingPipeline` resources (used for AutoML and custom training) and `PipelineJob`
 * resources (used for Vertex AI Pipelines).
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
 * try (PipelineServiceClient pipelineServiceClient = PipelineServiceClient.create()) {
 *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
 *   TrainingPipeline trainingPipeline = TrainingPipeline.newBuilder().build();
 *   TrainingPipeline response =
 *       pipelineServiceClient.createTrainingPipeline(parent, trainingPipeline);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the PipelineServiceClient object to clean up resources
 * such as threads. In the example above, try-with-resources is used, which automatically calls
 * close().
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
 * <p>This class can be customized by passing in a custom instance of PipelineServiceSettings to
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
 * PipelineServiceSettings pipelineServiceSettings =
 *     PipelineServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * PipelineServiceClient pipelineServiceClient =
 *     PipelineServiceClient.create(pipelineServiceSettings);
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
 * PipelineServiceSettings pipelineServiceSettings =
 *     PipelineServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * PipelineServiceClient pipelineServiceClient =
 *     PipelineServiceClient.create(pipelineServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class PipelineServiceClient implements BackgroundResource {
  private final PipelineServiceSettings settings;
  private final PipelineServiceStub stub;
  private final OperationsClient operationsClient;

  /** Constructs an instance of PipelineServiceClient with default settings. */
  public static final PipelineServiceClient create() throws IOException {
    return create(PipelineServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of PipelineServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final PipelineServiceClient create(PipelineServiceSettings settings)
      throws IOException {
    return new PipelineServiceClient(settings);
  }

  /**
   * Constructs an instance of PipelineServiceClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(PipelineServiceSettings).
   */
  public static final PipelineServiceClient create(PipelineServiceStub stub) {
    return new PipelineServiceClient(stub);
  }

  /**
   * Constructs an instance of PipelineServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected PipelineServiceClient(PipelineServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((PipelineServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  protected PipelineServiceClient(PipelineServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  public final PipelineServiceSettings getSettings() {
    return settings;
  }

  public PipelineServiceStub getStub() {
    return stub;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  public final OperationsClient getOperationsClient() {
    return operationsClient;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a TrainingPipeline. A created TrainingPipeline right away will be attempted to be run.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PipelineServiceClient pipelineServiceClient = PipelineServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   TrainingPipeline trainingPipeline = TrainingPipeline.newBuilder().build();
   *   TrainingPipeline response =
   *       pipelineServiceClient.createTrainingPipeline(parent, trainingPipeline);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Location to create the TrainingPipeline in.
   *     Format: `projects/{project}/locations/{location}`
   * @param trainingPipeline Required. The TrainingPipeline to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TrainingPipeline createTrainingPipeline(
      LocationName parent, TrainingPipeline trainingPipeline) {
    CreateTrainingPipelineRequest request =
        CreateTrainingPipelineRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setTrainingPipeline(trainingPipeline)
            .build();
    return createTrainingPipeline(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a TrainingPipeline. A created TrainingPipeline right away will be attempted to be run.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PipelineServiceClient pipelineServiceClient = PipelineServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   TrainingPipeline trainingPipeline = TrainingPipeline.newBuilder().build();
   *   TrainingPipeline response =
   *       pipelineServiceClient.createTrainingPipeline(parent, trainingPipeline);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Location to create the TrainingPipeline in.
   *     Format: `projects/{project}/locations/{location}`
   * @param trainingPipeline Required. The TrainingPipeline to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TrainingPipeline createTrainingPipeline(
      String parent, TrainingPipeline trainingPipeline) {
    CreateTrainingPipelineRequest request =
        CreateTrainingPipelineRequest.newBuilder()
            .setParent(parent)
            .setTrainingPipeline(trainingPipeline)
            .build();
    return createTrainingPipeline(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a TrainingPipeline. A created TrainingPipeline right away will be attempted to be run.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PipelineServiceClient pipelineServiceClient = PipelineServiceClient.create()) {
   *   CreateTrainingPipelineRequest request =
   *       CreateTrainingPipelineRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setTrainingPipeline(TrainingPipeline.newBuilder().build())
   *           .build();
   *   TrainingPipeline response = pipelineServiceClient.createTrainingPipeline(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TrainingPipeline createTrainingPipeline(CreateTrainingPipelineRequest request) {
    return createTrainingPipelineCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a TrainingPipeline. A created TrainingPipeline right away will be attempted to be run.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PipelineServiceClient pipelineServiceClient = PipelineServiceClient.create()) {
   *   CreateTrainingPipelineRequest request =
   *       CreateTrainingPipelineRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setTrainingPipeline(TrainingPipeline.newBuilder().build())
   *           .build();
   *   ApiFuture<TrainingPipeline> future =
   *       pipelineServiceClient.createTrainingPipelineCallable().futureCall(request);
   *   // Do something.
   *   TrainingPipeline response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateTrainingPipelineRequest, TrainingPipeline>
      createTrainingPipelineCallable() {
    return stub.createTrainingPipelineCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a TrainingPipeline.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PipelineServiceClient pipelineServiceClient = PipelineServiceClient.create()) {
   *   TrainingPipelineName name =
   *       TrainingPipelineName.of("[PROJECT]", "[LOCATION]", "[TRAINING_PIPELINE]");
   *   TrainingPipeline response = pipelineServiceClient.getTrainingPipeline(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the TrainingPipeline resource. Format:
   *     `projects/{project}/locations/{location}/trainingPipelines/{training_pipeline}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TrainingPipeline getTrainingPipeline(TrainingPipelineName name) {
    GetTrainingPipelineRequest request =
        GetTrainingPipelineRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getTrainingPipeline(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a TrainingPipeline.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PipelineServiceClient pipelineServiceClient = PipelineServiceClient.create()) {
   *   String name =
   *       TrainingPipelineName.of("[PROJECT]", "[LOCATION]", "[TRAINING_PIPELINE]").toString();
   *   TrainingPipeline response = pipelineServiceClient.getTrainingPipeline(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the TrainingPipeline resource. Format:
   *     `projects/{project}/locations/{location}/trainingPipelines/{training_pipeline}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TrainingPipeline getTrainingPipeline(String name) {
    GetTrainingPipelineRequest request =
        GetTrainingPipelineRequest.newBuilder().setName(name).build();
    return getTrainingPipeline(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a TrainingPipeline.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PipelineServiceClient pipelineServiceClient = PipelineServiceClient.create()) {
   *   GetTrainingPipelineRequest request =
   *       GetTrainingPipelineRequest.newBuilder()
   *           .setName(
   *               TrainingPipelineName.of("[PROJECT]", "[LOCATION]", "[TRAINING_PIPELINE]")
   *                   .toString())
   *           .build();
   *   TrainingPipeline response = pipelineServiceClient.getTrainingPipeline(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TrainingPipeline getTrainingPipeline(GetTrainingPipelineRequest request) {
    return getTrainingPipelineCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a TrainingPipeline.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PipelineServiceClient pipelineServiceClient = PipelineServiceClient.create()) {
   *   GetTrainingPipelineRequest request =
   *       GetTrainingPipelineRequest.newBuilder()
   *           .setName(
   *               TrainingPipelineName.of("[PROJECT]", "[LOCATION]", "[TRAINING_PIPELINE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<TrainingPipeline> future =
   *       pipelineServiceClient.getTrainingPipelineCallable().futureCall(request);
   *   // Do something.
   *   TrainingPipeline response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetTrainingPipelineRequest, TrainingPipeline>
      getTrainingPipelineCallable() {
    return stub.getTrainingPipelineCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists TrainingPipelines in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PipelineServiceClient pipelineServiceClient = PipelineServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (TrainingPipeline element :
   *       pipelineServiceClient.listTrainingPipelines(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Location to list the TrainingPipelines from.
   *     Format: `projects/{project}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTrainingPipelinesPagedResponse listTrainingPipelines(LocationName parent) {
    ListTrainingPipelinesRequest request =
        ListTrainingPipelinesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listTrainingPipelines(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists TrainingPipelines in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PipelineServiceClient pipelineServiceClient = PipelineServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (TrainingPipeline element :
   *       pipelineServiceClient.listTrainingPipelines(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Location to list the TrainingPipelines from.
   *     Format: `projects/{project}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTrainingPipelinesPagedResponse listTrainingPipelines(String parent) {
    ListTrainingPipelinesRequest request =
        ListTrainingPipelinesRequest.newBuilder().setParent(parent).build();
    return listTrainingPipelines(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists TrainingPipelines in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PipelineServiceClient pipelineServiceClient = PipelineServiceClient.create()) {
   *   ListTrainingPipelinesRequest request =
   *       ListTrainingPipelinesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .build();
   *   for (TrainingPipeline element :
   *       pipelineServiceClient.listTrainingPipelines(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTrainingPipelinesPagedResponse listTrainingPipelines(
      ListTrainingPipelinesRequest request) {
    return listTrainingPipelinesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists TrainingPipelines in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PipelineServiceClient pipelineServiceClient = PipelineServiceClient.create()) {
   *   ListTrainingPipelinesRequest request =
   *       ListTrainingPipelinesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<TrainingPipeline> future =
   *       pipelineServiceClient.listTrainingPipelinesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (TrainingPipeline element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListTrainingPipelinesRequest, ListTrainingPipelinesPagedResponse>
      listTrainingPipelinesPagedCallable() {
    return stub.listTrainingPipelinesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists TrainingPipelines in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PipelineServiceClient pipelineServiceClient = PipelineServiceClient.create()) {
   *   ListTrainingPipelinesRequest request =
   *       ListTrainingPipelinesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .build();
   *   while (true) {
   *     ListTrainingPipelinesResponse response =
   *         pipelineServiceClient.listTrainingPipelinesCallable().call(request);
   *     for (TrainingPipeline element : response.getTrainingPipelinesList()) {
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
  public final UnaryCallable<ListTrainingPipelinesRequest, ListTrainingPipelinesResponse>
      listTrainingPipelinesCallable() {
    return stub.listTrainingPipelinesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a TrainingPipeline.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PipelineServiceClient pipelineServiceClient = PipelineServiceClient.create()) {
   *   TrainingPipelineName name =
   *       TrainingPipelineName.of("[PROJECT]", "[LOCATION]", "[TRAINING_PIPELINE]");
   *   pipelineServiceClient.deleteTrainingPipelineAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the TrainingPipeline resource to be deleted. Format:
   *     `projects/{project}/locations/{location}/trainingPipelines/{training_pipeline}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteTrainingPipelineAsync(
      TrainingPipelineName name) {
    DeleteTrainingPipelineRequest request =
        DeleteTrainingPipelineRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteTrainingPipelineAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a TrainingPipeline.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PipelineServiceClient pipelineServiceClient = PipelineServiceClient.create()) {
   *   String name =
   *       TrainingPipelineName.of("[PROJECT]", "[LOCATION]", "[TRAINING_PIPELINE]").toString();
   *   pipelineServiceClient.deleteTrainingPipelineAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the TrainingPipeline resource to be deleted. Format:
   *     `projects/{project}/locations/{location}/trainingPipelines/{training_pipeline}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteTrainingPipelineAsync(
      String name) {
    DeleteTrainingPipelineRequest request =
        DeleteTrainingPipelineRequest.newBuilder().setName(name).build();
    return deleteTrainingPipelineAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a TrainingPipeline.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PipelineServiceClient pipelineServiceClient = PipelineServiceClient.create()) {
   *   DeleteTrainingPipelineRequest request =
   *       DeleteTrainingPipelineRequest.newBuilder()
   *           .setName(
   *               TrainingPipelineName.of("[PROJECT]", "[LOCATION]", "[TRAINING_PIPELINE]")
   *                   .toString())
   *           .build();
   *   pipelineServiceClient.deleteTrainingPipelineAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteTrainingPipelineAsync(
      DeleteTrainingPipelineRequest request) {
    return deleteTrainingPipelineOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a TrainingPipeline.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PipelineServiceClient pipelineServiceClient = PipelineServiceClient.create()) {
   *   DeleteTrainingPipelineRequest request =
   *       DeleteTrainingPipelineRequest.newBuilder()
   *           .setName(
   *               TrainingPipelineName.of("[PROJECT]", "[LOCATION]", "[TRAINING_PIPELINE]")
   *                   .toString())
   *           .build();
   *   OperationFuture<Empty, DeleteOperationMetadata> future =
   *       pipelineServiceClient.deleteTrainingPipelineOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteTrainingPipelineRequest, Empty, DeleteOperationMetadata>
      deleteTrainingPipelineOperationCallable() {
    return stub.deleteTrainingPipelineOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a TrainingPipeline.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PipelineServiceClient pipelineServiceClient = PipelineServiceClient.create()) {
   *   DeleteTrainingPipelineRequest request =
   *       DeleteTrainingPipelineRequest.newBuilder()
   *           .setName(
   *               TrainingPipelineName.of("[PROJECT]", "[LOCATION]", "[TRAINING_PIPELINE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       pipelineServiceClient.deleteTrainingPipelineCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteTrainingPipelineRequest, Operation>
      deleteTrainingPipelineCallable() {
    return stub.deleteTrainingPipelineCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Cancels a TrainingPipeline. Starts asynchronous cancellation on the TrainingPipeline. The
   * server makes a best effort to cancel the pipeline, but success is not guaranteed. Clients can
   * use
   * [PipelineService.GetTrainingPipeline][google.cloud.aiplatform.v1beta1.PipelineService.GetTrainingPipeline]
   * or other methods to check whether the cancellation succeeded or whether the pipeline completed
   * despite cancellation. On successful cancellation, the TrainingPipeline is not deleted; instead
   * it becomes a pipeline with a
   * [TrainingPipeline.error][google.cloud.aiplatform.v1beta1.TrainingPipeline.error] value with a
   * [google.rpc.Status.code][google.rpc.Status.code] of 1, corresponding to `Code.CANCELLED`, and
   * [TrainingPipeline.state][google.cloud.aiplatform.v1beta1.TrainingPipeline.state] is set to
   * `CANCELLED`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PipelineServiceClient pipelineServiceClient = PipelineServiceClient.create()) {
   *   TrainingPipelineName name =
   *       TrainingPipelineName.of("[PROJECT]", "[LOCATION]", "[TRAINING_PIPELINE]");
   *   pipelineServiceClient.cancelTrainingPipeline(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the TrainingPipeline to cancel. Format:
   *     `projects/{project}/locations/{location}/trainingPipelines/{training_pipeline}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void cancelTrainingPipeline(TrainingPipelineName name) {
    CancelTrainingPipelineRequest request =
        CancelTrainingPipelineRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    cancelTrainingPipeline(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Cancels a TrainingPipeline. Starts asynchronous cancellation on the TrainingPipeline. The
   * server makes a best effort to cancel the pipeline, but success is not guaranteed. Clients can
   * use
   * [PipelineService.GetTrainingPipeline][google.cloud.aiplatform.v1beta1.PipelineService.GetTrainingPipeline]
   * or other methods to check whether the cancellation succeeded or whether the pipeline completed
   * despite cancellation. On successful cancellation, the TrainingPipeline is not deleted; instead
   * it becomes a pipeline with a
   * [TrainingPipeline.error][google.cloud.aiplatform.v1beta1.TrainingPipeline.error] value with a
   * [google.rpc.Status.code][google.rpc.Status.code] of 1, corresponding to `Code.CANCELLED`, and
   * [TrainingPipeline.state][google.cloud.aiplatform.v1beta1.TrainingPipeline.state] is set to
   * `CANCELLED`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PipelineServiceClient pipelineServiceClient = PipelineServiceClient.create()) {
   *   String name =
   *       TrainingPipelineName.of("[PROJECT]", "[LOCATION]", "[TRAINING_PIPELINE]").toString();
   *   pipelineServiceClient.cancelTrainingPipeline(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the TrainingPipeline to cancel. Format:
   *     `projects/{project}/locations/{location}/trainingPipelines/{training_pipeline}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void cancelTrainingPipeline(String name) {
    CancelTrainingPipelineRequest request =
        CancelTrainingPipelineRequest.newBuilder().setName(name).build();
    cancelTrainingPipeline(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Cancels a TrainingPipeline. Starts asynchronous cancellation on the TrainingPipeline. The
   * server makes a best effort to cancel the pipeline, but success is not guaranteed. Clients can
   * use
   * [PipelineService.GetTrainingPipeline][google.cloud.aiplatform.v1beta1.PipelineService.GetTrainingPipeline]
   * or other methods to check whether the cancellation succeeded or whether the pipeline completed
   * despite cancellation. On successful cancellation, the TrainingPipeline is not deleted; instead
   * it becomes a pipeline with a
   * [TrainingPipeline.error][google.cloud.aiplatform.v1beta1.TrainingPipeline.error] value with a
   * [google.rpc.Status.code][google.rpc.Status.code] of 1, corresponding to `Code.CANCELLED`, and
   * [TrainingPipeline.state][google.cloud.aiplatform.v1beta1.TrainingPipeline.state] is set to
   * `CANCELLED`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PipelineServiceClient pipelineServiceClient = PipelineServiceClient.create()) {
   *   CancelTrainingPipelineRequest request =
   *       CancelTrainingPipelineRequest.newBuilder()
   *           .setName(
   *               TrainingPipelineName.of("[PROJECT]", "[LOCATION]", "[TRAINING_PIPELINE]")
   *                   .toString())
   *           .build();
   *   pipelineServiceClient.cancelTrainingPipeline(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void cancelTrainingPipeline(CancelTrainingPipelineRequest request) {
    cancelTrainingPipelineCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Cancels a TrainingPipeline. Starts asynchronous cancellation on the TrainingPipeline. The
   * server makes a best effort to cancel the pipeline, but success is not guaranteed. Clients can
   * use
   * [PipelineService.GetTrainingPipeline][google.cloud.aiplatform.v1beta1.PipelineService.GetTrainingPipeline]
   * or other methods to check whether the cancellation succeeded or whether the pipeline completed
   * despite cancellation. On successful cancellation, the TrainingPipeline is not deleted; instead
   * it becomes a pipeline with a
   * [TrainingPipeline.error][google.cloud.aiplatform.v1beta1.TrainingPipeline.error] value with a
   * [google.rpc.Status.code][google.rpc.Status.code] of 1, corresponding to `Code.CANCELLED`, and
   * [TrainingPipeline.state][google.cloud.aiplatform.v1beta1.TrainingPipeline.state] is set to
   * `CANCELLED`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PipelineServiceClient pipelineServiceClient = PipelineServiceClient.create()) {
   *   CancelTrainingPipelineRequest request =
   *       CancelTrainingPipelineRequest.newBuilder()
   *           .setName(
   *               TrainingPipelineName.of("[PROJECT]", "[LOCATION]", "[TRAINING_PIPELINE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       pipelineServiceClient.cancelTrainingPipelineCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CancelTrainingPipelineRequest, Empty>
      cancelTrainingPipelineCallable() {
    return stub.cancelTrainingPipelineCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a PipelineJob. A PipelineJob will run immediately when created.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PipelineServiceClient pipelineServiceClient = PipelineServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   PipelineJob pipelineJob = PipelineJob.newBuilder().build();
   *   String pipelineJobId = "pipelineJobId-1711315914";
   *   PipelineJob response =
   *       pipelineServiceClient.createPipelineJob(parent, pipelineJob, pipelineJobId);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Location to create the PipelineJob in. Format:
   *     `projects/{project}/locations/{location}`
   * @param pipelineJob Required. The PipelineJob to create.
   * @param pipelineJobId The ID to use for the PipelineJob, which will become the final component
   *     of the PipelineJob name. If not provided, an ID will be automatically generated.
   *     <p>This value should be less than 128 characters, and valid characters are /[a-z][0-9]-/.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PipelineJob createPipelineJob(
      LocationName parent, PipelineJob pipelineJob, String pipelineJobId) {
    CreatePipelineJobRequest request =
        CreatePipelineJobRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setPipelineJob(pipelineJob)
            .setPipelineJobId(pipelineJobId)
            .build();
    return createPipelineJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a PipelineJob. A PipelineJob will run immediately when created.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PipelineServiceClient pipelineServiceClient = PipelineServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   PipelineJob pipelineJob = PipelineJob.newBuilder().build();
   *   String pipelineJobId = "pipelineJobId-1711315914";
   *   PipelineJob response =
   *       pipelineServiceClient.createPipelineJob(parent, pipelineJob, pipelineJobId);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Location to create the PipelineJob in. Format:
   *     `projects/{project}/locations/{location}`
   * @param pipelineJob Required. The PipelineJob to create.
   * @param pipelineJobId The ID to use for the PipelineJob, which will become the final component
   *     of the PipelineJob name. If not provided, an ID will be automatically generated.
   *     <p>This value should be less than 128 characters, and valid characters are /[a-z][0-9]-/.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PipelineJob createPipelineJob(
      String parent, PipelineJob pipelineJob, String pipelineJobId) {
    CreatePipelineJobRequest request =
        CreatePipelineJobRequest.newBuilder()
            .setParent(parent)
            .setPipelineJob(pipelineJob)
            .setPipelineJobId(pipelineJobId)
            .build();
    return createPipelineJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a PipelineJob. A PipelineJob will run immediately when created.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PipelineServiceClient pipelineServiceClient = PipelineServiceClient.create()) {
   *   CreatePipelineJobRequest request =
   *       CreatePipelineJobRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPipelineJob(PipelineJob.newBuilder().build())
   *           .setPipelineJobId("pipelineJobId-1711315914")
   *           .build();
   *   PipelineJob response = pipelineServiceClient.createPipelineJob(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PipelineJob createPipelineJob(CreatePipelineJobRequest request) {
    return createPipelineJobCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a PipelineJob. A PipelineJob will run immediately when created.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PipelineServiceClient pipelineServiceClient = PipelineServiceClient.create()) {
   *   CreatePipelineJobRequest request =
   *       CreatePipelineJobRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPipelineJob(PipelineJob.newBuilder().build())
   *           .setPipelineJobId("pipelineJobId-1711315914")
   *           .build();
   *   ApiFuture<PipelineJob> future =
   *       pipelineServiceClient.createPipelineJobCallable().futureCall(request);
   *   // Do something.
   *   PipelineJob response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreatePipelineJobRequest, PipelineJob> createPipelineJobCallable() {
    return stub.createPipelineJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a PipelineJob.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PipelineServiceClient pipelineServiceClient = PipelineServiceClient.create()) {
   *   PipelineJobName name = PipelineJobName.of("[PROJECT]", "[LOCATION]", "[PIPELINE_JOB]");
   *   PipelineJob response = pipelineServiceClient.getPipelineJob(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the PipelineJob resource. Format:
   *     `projects/{project}/locations/{location}/pipelineJobs/{pipeline_job}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PipelineJob getPipelineJob(PipelineJobName name) {
    GetPipelineJobRequest request =
        GetPipelineJobRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getPipelineJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a PipelineJob.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PipelineServiceClient pipelineServiceClient = PipelineServiceClient.create()) {
   *   String name = PipelineJobName.of("[PROJECT]", "[LOCATION]", "[PIPELINE_JOB]").toString();
   *   PipelineJob response = pipelineServiceClient.getPipelineJob(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the PipelineJob resource. Format:
   *     `projects/{project}/locations/{location}/pipelineJobs/{pipeline_job}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PipelineJob getPipelineJob(String name) {
    GetPipelineJobRequest request = GetPipelineJobRequest.newBuilder().setName(name).build();
    return getPipelineJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a PipelineJob.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PipelineServiceClient pipelineServiceClient = PipelineServiceClient.create()) {
   *   GetPipelineJobRequest request =
   *       GetPipelineJobRequest.newBuilder()
   *           .setName(PipelineJobName.of("[PROJECT]", "[LOCATION]", "[PIPELINE_JOB]").toString())
   *           .build();
   *   PipelineJob response = pipelineServiceClient.getPipelineJob(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PipelineJob getPipelineJob(GetPipelineJobRequest request) {
    return getPipelineJobCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a PipelineJob.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PipelineServiceClient pipelineServiceClient = PipelineServiceClient.create()) {
   *   GetPipelineJobRequest request =
   *       GetPipelineJobRequest.newBuilder()
   *           .setName(PipelineJobName.of("[PROJECT]", "[LOCATION]", "[PIPELINE_JOB]").toString())
   *           .build();
   *   ApiFuture<PipelineJob> future =
   *       pipelineServiceClient.getPipelineJobCallable().futureCall(request);
   *   // Do something.
   *   PipelineJob response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetPipelineJobRequest, PipelineJob> getPipelineJobCallable() {
    return stub.getPipelineJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists PipelineJobs in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PipelineServiceClient pipelineServiceClient = PipelineServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (PipelineJob element : pipelineServiceClient.listPipelineJobs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Location to list the PipelineJobs from.
   *     Format: `projects/{project}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPipelineJobsPagedResponse listPipelineJobs(LocationName parent) {
    ListPipelineJobsRequest request =
        ListPipelineJobsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listPipelineJobs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists PipelineJobs in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PipelineServiceClient pipelineServiceClient = PipelineServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (PipelineJob element : pipelineServiceClient.listPipelineJobs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Location to list the PipelineJobs from.
   *     Format: `projects/{project}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPipelineJobsPagedResponse listPipelineJobs(String parent) {
    ListPipelineJobsRequest request =
        ListPipelineJobsRequest.newBuilder().setParent(parent).build();
    return listPipelineJobs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists PipelineJobs in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PipelineServiceClient pipelineServiceClient = PipelineServiceClient.create()) {
   *   ListPipelineJobsRequest request =
   *       ListPipelineJobsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .build();
   *   for (PipelineJob element : pipelineServiceClient.listPipelineJobs(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPipelineJobsPagedResponse listPipelineJobs(ListPipelineJobsRequest request) {
    return listPipelineJobsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists PipelineJobs in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PipelineServiceClient pipelineServiceClient = PipelineServiceClient.create()) {
   *   ListPipelineJobsRequest request =
   *       ListPipelineJobsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<PipelineJob> future =
   *       pipelineServiceClient.listPipelineJobsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (PipelineJob element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListPipelineJobsRequest, ListPipelineJobsPagedResponse>
      listPipelineJobsPagedCallable() {
    return stub.listPipelineJobsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists PipelineJobs in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PipelineServiceClient pipelineServiceClient = PipelineServiceClient.create()) {
   *   ListPipelineJobsRequest request =
   *       ListPipelineJobsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .build();
   *   while (true) {
   *     ListPipelineJobsResponse response =
   *         pipelineServiceClient.listPipelineJobsCallable().call(request);
   *     for (PipelineJob element : response.getPipelineJobsList()) {
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
  public final UnaryCallable<ListPipelineJobsRequest, ListPipelineJobsResponse>
      listPipelineJobsCallable() {
    return stub.listPipelineJobsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a PipelineJob.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PipelineServiceClient pipelineServiceClient = PipelineServiceClient.create()) {
   *   PipelineJobName name = PipelineJobName.of("[PROJECT]", "[LOCATION]", "[PIPELINE_JOB]");
   *   pipelineServiceClient.deletePipelineJobAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the PipelineJob resource to be deleted. Format:
   *     `projects/{project}/locations/{location}/pipelineJobs/{pipeline_job}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deletePipelineJobAsync(
      PipelineJobName name) {
    DeletePipelineJobRequest request =
        DeletePipelineJobRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deletePipelineJobAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a PipelineJob.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PipelineServiceClient pipelineServiceClient = PipelineServiceClient.create()) {
   *   String name = PipelineJobName.of("[PROJECT]", "[LOCATION]", "[PIPELINE_JOB]").toString();
   *   pipelineServiceClient.deletePipelineJobAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the PipelineJob resource to be deleted. Format:
   *     `projects/{project}/locations/{location}/pipelineJobs/{pipeline_job}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deletePipelineJobAsync(String name) {
    DeletePipelineJobRequest request = DeletePipelineJobRequest.newBuilder().setName(name).build();
    return deletePipelineJobAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a PipelineJob.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PipelineServiceClient pipelineServiceClient = PipelineServiceClient.create()) {
   *   DeletePipelineJobRequest request =
   *       DeletePipelineJobRequest.newBuilder()
   *           .setName(PipelineJobName.of("[PROJECT]", "[LOCATION]", "[PIPELINE_JOB]").toString())
   *           .build();
   *   pipelineServiceClient.deletePipelineJobAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deletePipelineJobAsync(
      DeletePipelineJobRequest request) {
    return deletePipelineJobOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a PipelineJob.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PipelineServiceClient pipelineServiceClient = PipelineServiceClient.create()) {
   *   DeletePipelineJobRequest request =
   *       DeletePipelineJobRequest.newBuilder()
   *           .setName(PipelineJobName.of("[PROJECT]", "[LOCATION]", "[PIPELINE_JOB]").toString())
   *           .build();
   *   OperationFuture<Empty, DeleteOperationMetadata> future =
   *       pipelineServiceClient.deletePipelineJobOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeletePipelineJobRequest, Empty, DeleteOperationMetadata>
      deletePipelineJobOperationCallable() {
    return stub.deletePipelineJobOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a PipelineJob.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PipelineServiceClient pipelineServiceClient = PipelineServiceClient.create()) {
   *   DeletePipelineJobRequest request =
   *       DeletePipelineJobRequest.newBuilder()
   *           .setName(PipelineJobName.of("[PROJECT]", "[LOCATION]", "[PIPELINE_JOB]").toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       pipelineServiceClient.deletePipelineJobCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeletePipelineJobRequest, Operation> deletePipelineJobCallable() {
    return stub.deletePipelineJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Cancels a PipelineJob. Starts asynchronous cancellation on the PipelineJob. The server makes a
   * best effort to cancel the pipeline, but success is not guaranteed. Clients can use
   * [PipelineService.GetPipelineJob][google.cloud.aiplatform.v1beta1.PipelineService.GetPipelineJob]
   * or other methods to check whether the cancellation succeeded or whether the pipeline completed
   * despite cancellation. On successful cancellation, the PipelineJob is not deleted; instead it
   * becomes a pipeline with a
   * [PipelineJob.error][google.cloud.aiplatform.v1beta1.PipelineJob.error] value with a
   * [google.rpc.Status.code][google.rpc.Status.code] of 1, corresponding to `Code.CANCELLED`, and
   * [PipelineJob.state][google.cloud.aiplatform.v1beta1.PipelineJob.state] is set to `CANCELLED`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PipelineServiceClient pipelineServiceClient = PipelineServiceClient.create()) {
   *   PipelineJobName name = PipelineJobName.of("[PROJECT]", "[LOCATION]", "[PIPELINE_JOB]");
   *   pipelineServiceClient.cancelPipelineJob(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the PipelineJob to cancel. Format:
   *     `projects/{project}/locations/{location}/pipelineJobs/{pipeline_job}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void cancelPipelineJob(PipelineJobName name) {
    CancelPipelineJobRequest request =
        CancelPipelineJobRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    cancelPipelineJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Cancels a PipelineJob. Starts asynchronous cancellation on the PipelineJob. The server makes a
   * best effort to cancel the pipeline, but success is not guaranteed. Clients can use
   * [PipelineService.GetPipelineJob][google.cloud.aiplatform.v1beta1.PipelineService.GetPipelineJob]
   * or other methods to check whether the cancellation succeeded or whether the pipeline completed
   * despite cancellation. On successful cancellation, the PipelineJob is not deleted; instead it
   * becomes a pipeline with a
   * [PipelineJob.error][google.cloud.aiplatform.v1beta1.PipelineJob.error] value with a
   * [google.rpc.Status.code][google.rpc.Status.code] of 1, corresponding to `Code.CANCELLED`, and
   * [PipelineJob.state][google.cloud.aiplatform.v1beta1.PipelineJob.state] is set to `CANCELLED`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PipelineServiceClient pipelineServiceClient = PipelineServiceClient.create()) {
   *   String name = PipelineJobName.of("[PROJECT]", "[LOCATION]", "[PIPELINE_JOB]").toString();
   *   pipelineServiceClient.cancelPipelineJob(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the PipelineJob to cancel. Format:
   *     `projects/{project}/locations/{location}/pipelineJobs/{pipeline_job}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void cancelPipelineJob(String name) {
    CancelPipelineJobRequest request = CancelPipelineJobRequest.newBuilder().setName(name).build();
    cancelPipelineJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Cancels a PipelineJob. Starts asynchronous cancellation on the PipelineJob. The server makes a
   * best effort to cancel the pipeline, but success is not guaranteed. Clients can use
   * [PipelineService.GetPipelineJob][google.cloud.aiplatform.v1beta1.PipelineService.GetPipelineJob]
   * or other methods to check whether the cancellation succeeded or whether the pipeline completed
   * despite cancellation. On successful cancellation, the PipelineJob is not deleted; instead it
   * becomes a pipeline with a
   * [PipelineJob.error][google.cloud.aiplatform.v1beta1.PipelineJob.error] value with a
   * [google.rpc.Status.code][google.rpc.Status.code] of 1, corresponding to `Code.CANCELLED`, and
   * [PipelineJob.state][google.cloud.aiplatform.v1beta1.PipelineJob.state] is set to `CANCELLED`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PipelineServiceClient pipelineServiceClient = PipelineServiceClient.create()) {
   *   CancelPipelineJobRequest request =
   *       CancelPipelineJobRequest.newBuilder()
   *           .setName(PipelineJobName.of("[PROJECT]", "[LOCATION]", "[PIPELINE_JOB]").toString())
   *           .build();
   *   pipelineServiceClient.cancelPipelineJob(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void cancelPipelineJob(CancelPipelineJobRequest request) {
    cancelPipelineJobCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Cancels a PipelineJob. Starts asynchronous cancellation on the PipelineJob. The server makes a
   * best effort to cancel the pipeline, but success is not guaranteed. Clients can use
   * [PipelineService.GetPipelineJob][google.cloud.aiplatform.v1beta1.PipelineService.GetPipelineJob]
   * or other methods to check whether the cancellation succeeded or whether the pipeline completed
   * despite cancellation. On successful cancellation, the PipelineJob is not deleted; instead it
   * becomes a pipeline with a
   * [PipelineJob.error][google.cloud.aiplatform.v1beta1.PipelineJob.error] value with a
   * [google.rpc.Status.code][google.rpc.Status.code] of 1, corresponding to `Code.CANCELLED`, and
   * [PipelineJob.state][google.cloud.aiplatform.v1beta1.PipelineJob.state] is set to `CANCELLED`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PipelineServiceClient pipelineServiceClient = PipelineServiceClient.create()) {
   *   CancelPipelineJobRequest request =
   *       CancelPipelineJobRequest.newBuilder()
   *           .setName(PipelineJobName.of("[PROJECT]", "[LOCATION]", "[PIPELINE_JOB]").toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       pipelineServiceClient.cancelPipelineJobCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CancelPipelineJobRequest, Empty> cancelPipelineJobCallable() {
    return stub.cancelPipelineJobCallable();
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
   * try (PipelineServiceClient pipelineServiceClient = PipelineServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : pipelineServiceClient.listLocations(request).iterateAll()) {
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
   * try (PipelineServiceClient pipelineServiceClient = PipelineServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       pipelineServiceClient.listLocationsPagedCallable().futureCall(request);
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
   * try (PipelineServiceClient pipelineServiceClient = PipelineServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response =
   *         pipelineServiceClient.listLocationsCallable().call(request);
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
   * try (PipelineServiceClient pipelineServiceClient = PipelineServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = pipelineServiceClient.getLocation(request);
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
   * try (PipelineServiceClient pipelineServiceClient = PipelineServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future = pipelineServiceClient.getLocationCallable().futureCall(request);
   *   // Do something.
   *   Location response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    return stub.getLocationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the access control policy on the specified resource. Replacesany existing policy.
   *
   * <p>Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED`errors.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PipelineServiceClient pipelineServiceClient = PipelineServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               EntityTypeName.of("[PROJECT]", "[LOCATION]", "[FEATURESTORE]", "[ENTITY_TYPE]")
   *                   .toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Policy response = pipelineServiceClient.setIamPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(SetIamPolicyRequest request) {
    return setIamPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the access control policy on the specified resource. Replacesany existing policy.
   *
   * <p>Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED`errors.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PipelineServiceClient pipelineServiceClient = PipelineServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               EntityTypeName.of("[PROJECT]", "[LOCATION]", "[FEATURESTORE]", "[ENTITY_TYPE]")
   *                   .toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = pipelineServiceClient.setIamPolicyCallable().futureCall(request);
   *   // Do something.
   *   Policy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    return stub.setIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the access control policy for a resource. Returns an empty policyif the resource exists
   * and does not have a policy set.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PipelineServiceClient pipelineServiceClient = PipelineServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               EntityTypeName.of("[PROJECT]", "[LOCATION]", "[FEATURESTORE]", "[ENTITY_TYPE]")
   *                   .toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   Policy response = pipelineServiceClient.getIamPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(GetIamPolicyRequest request) {
    return getIamPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the access control policy for a resource. Returns an empty policyif the resource exists
   * and does not have a policy set.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PipelineServiceClient pipelineServiceClient = PipelineServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               EntityTypeName.of("[PROJECT]", "[LOCATION]", "[FEATURESTORE]", "[ENTITY_TYPE]")
   *                   .toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = pipelineServiceClient.getIamPolicyCallable().futureCall(request);
   *   // Do something.
   *   Policy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    return stub.getIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns permissions that a caller has on the specified resource. If theresource does not exist,
   * this will return an empty set ofpermissions, not a `NOT_FOUND` error.
   *
   * <p>Note: This operation is designed to be used for buildingpermission-aware UIs and
   * command-line tools, not for authorizationchecking. This operation may "fail open" without
   * warning.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PipelineServiceClient pipelineServiceClient = PipelineServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               EntityTypeName.of("[PROJECT]", "[LOCATION]", "[FEATURESTORE]", "[ENTITY_TYPE]")
   *                   .toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   TestIamPermissionsResponse response = pipelineServiceClient.testIamPermissions(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestIamPermissionsResponse testIamPermissions(TestIamPermissionsRequest request) {
    return testIamPermissionsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns permissions that a caller has on the specified resource. If theresource does not exist,
   * this will return an empty set ofpermissions, not a `NOT_FOUND` error.
   *
   * <p>Note: This operation is designed to be used for buildingpermission-aware UIs and
   * command-line tools, not for authorizationchecking. This operation may "fail open" without
   * warning.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PipelineServiceClient pipelineServiceClient = PipelineServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               EntityTypeName.of("[PROJECT]", "[LOCATION]", "[FEATURESTORE]", "[ENTITY_TYPE]")
   *                   .toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   ApiFuture<TestIamPermissionsResponse> future =
   *       pipelineServiceClient.testIamPermissionsCallable().futureCall(request);
   *   // Do something.
   *   TestIamPermissionsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    return stub.testIamPermissionsCallable();
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

  public static class ListTrainingPipelinesPagedResponse
      extends AbstractPagedListResponse<
          ListTrainingPipelinesRequest,
          ListTrainingPipelinesResponse,
          TrainingPipeline,
          ListTrainingPipelinesPage,
          ListTrainingPipelinesFixedSizeCollection> {

    public static ApiFuture<ListTrainingPipelinesPagedResponse> createAsync(
        PageContext<ListTrainingPipelinesRequest, ListTrainingPipelinesResponse, TrainingPipeline>
            context,
        ApiFuture<ListTrainingPipelinesResponse> futureResponse) {
      ApiFuture<ListTrainingPipelinesPage> futurePage =
          ListTrainingPipelinesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListTrainingPipelinesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListTrainingPipelinesPagedResponse(ListTrainingPipelinesPage page) {
      super(page, ListTrainingPipelinesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListTrainingPipelinesPage
      extends AbstractPage<
          ListTrainingPipelinesRequest,
          ListTrainingPipelinesResponse,
          TrainingPipeline,
          ListTrainingPipelinesPage> {

    private ListTrainingPipelinesPage(
        PageContext<ListTrainingPipelinesRequest, ListTrainingPipelinesResponse, TrainingPipeline>
            context,
        ListTrainingPipelinesResponse response) {
      super(context, response);
    }

    private static ListTrainingPipelinesPage createEmptyPage() {
      return new ListTrainingPipelinesPage(null, null);
    }

    @Override
    protected ListTrainingPipelinesPage createPage(
        PageContext<ListTrainingPipelinesRequest, ListTrainingPipelinesResponse, TrainingPipeline>
            context,
        ListTrainingPipelinesResponse response) {
      return new ListTrainingPipelinesPage(context, response);
    }

    @Override
    public ApiFuture<ListTrainingPipelinesPage> createPageAsync(
        PageContext<ListTrainingPipelinesRequest, ListTrainingPipelinesResponse, TrainingPipeline>
            context,
        ApiFuture<ListTrainingPipelinesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListTrainingPipelinesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListTrainingPipelinesRequest,
          ListTrainingPipelinesResponse,
          TrainingPipeline,
          ListTrainingPipelinesPage,
          ListTrainingPipelinesFixedSizeCollection> {

    private ListTrainingPipelinesFixedSizeCollection(
        List<ListTrainingPipelinesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListTrainingPipelinesFixedSizeCollection createEmptyCollection() {
      return new ListTrainingPipelinesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListTrainingPipelinesFixedSizeCollection createCollection(
        List<ListTrainingPipelinesPage> pages, int collectionSize) {
      return new ListTrainingPipelinesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListPipelineJobsPagedResponse
      extends AbstractPagedListResponse<
          ListPipelineJobsRequest,
          ListPipelineJobsResponse,
          PipelineJob,
          ListPipelineJobsPage,
          ListPipelineJobsFixedSizeCollection> {

    public static ApiFuture<ListPipelineJobsPagedResponse> createAsync(
        PageContext<ListPipelineJobsRequest, ListPipelineJobsResponse, PipelineJob> context,
        ApiFuture<ListPipelineJobsResponse> futureResponse) {
      ApiFuture<ListPipelineJobsPage> futurePage =
          ListPipelineJobsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListPipelineJobsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListPipelineJobsPagedResponse(ListPipelineJobsPage page) {
      super(page, ListPipelineJobsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListPipelineJobsPage
      extends AbstractPage<
          ListPipelineJobsRequest, ListPipelineJobsResponse, PipelineJob, ListPipelineJobsPage> {

    private ListPipelineJobsPage(
        PageContext<ListPipelineJobsRequest, ListPipelineJobsResponse, PipelineJob> context,
        ListPipelineJobsResponse response) {
      super(context, response);
    }

    private static ListPipelineJobsPage createEmptyPage() {
      return new ListPipelineJobsPage(null, null);
    }

    @Override
    protected ListPipelineJobsPage createPage(
        PageContext<ListPipelineJobsRequest, ListPipelineJobsResponse, PipelineJob> context,
        ListPipelineJobsResponse response) {
      return new ListPipelineJobsPage(context, response);
    }

    @Override
    public ApiFuture<ListPipelineJobsPage> createPageAsync(
        PageContext<ListPipelineJobsRequest, ListPipelineJobsResponse, PipelineJob> context,
        ApiFuture<ListPipelineJobsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListPipelineJobsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListPipelineJobsRequest,
          ListPipelineJobsResponse,
          PipelineJob,
          ListPipelineJobsPage,
          ListPipelineJobsFixedSizeCollection> {

    private ListPipelineJobsFixedSizeCollection(
        List<ListPipelineJobsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListPipelineJobsFixedSizeCollection createEmptyCollection() {
      return new ListPipelineJobsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListPipelineJobsFixedSizeCollection createCollection(
        List<ListPipelineJobsPage> pages, int collectionSize) {
      return new ListPipelineJobsFixedSizeCollection(pages, collectionSize);
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
