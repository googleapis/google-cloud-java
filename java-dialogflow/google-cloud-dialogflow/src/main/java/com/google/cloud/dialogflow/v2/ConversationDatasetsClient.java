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
import com.google.cloud.dialogflow.v2.stub.ConversationDatasetsStub;
import com.google.cloud.dialogflow.v2.stub.ConversationDatasetsStubSettings;
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
 * Service Description: Conversation datasets.
 *
 * <p>Conversation datasets contain raw conversation files and their customizable metadata that can
 * be used for model training.
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
 * try (ConversationDatasetsClient conversationDatasetsClient =
 *     ConversationDatasetsClient.create()) {
 *   ConversationDatasetName name =
 *       ConversationDatasetName.of("[PROJECT]", "[LOCATION]", "[CONVERSATION_DATASET]");
 *   ConversationDataset response = conversationDatasetsClient.getConversationDataset(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the ConversationDatasetsClient object to clean up
 * resources such as threads. In the example above, try-with-resources is used, which automatically
 * calls close().
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
 * <p>This class can be customized by passing in a custom instance of ConversationDatasetsSettings
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
 * ConversationDatasetsSettings conversationDatasetsSettings =
 *     ConversationDatasetsSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ConversationDatasetsClient conversationDatasetsClient =
 *     ConversationDatasetsClient.create(conversationDatasetsSettings);
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
 * ConversationDatasetsSettings conversationDatasetsSettings =
 *     ConversationDatasetsSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ConversationDatasetsClient conversationDatasetsClient =
 *     ConversationDatasetsClient.create(conversationDatasetsSettings);
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
 * ConversationDatasetsSettings conversationDatasetsSettings =
 *     ConversationDatasetsSettings.newBuilder()
 *         .setTransportChannelProvider(
 *             ConversationDatasetsSettings.defaultHttpJsonTransportProviderBuilder().build())
 *         .build();
 * ConversationDatasetsClient conversationDatasetsClient =
 *     ConversationDatasetsClient.create(conversationDatasetsSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class ConversationDatasetsClient implements BackgroundResource {
  private final ConversationDatasetsSettings settings;
  private final ConversationDatasetsStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of ConversationDatasetsClient with default settings. */
  public static final ConversationDatasetsClient create() throws IOException {
    return create(ConversationDatasetsSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ConversationDatasetsClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ConversationDatasetsClient create(ConversationDatasetsSettings settings)
      throws IOException {
    return new ConversationDatasetsClient(settings);
  }

  /**
   * Constructs an instance of ConversationDatasetsClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(ConversationDatasetsSettings).
   */
  public static final ConversationDatasetsClient create(ConversationDatasetsStub stub) {
    return new ConversationDatasetsClient(stub);
  }

  /**
   * Constructs an instance of ConversationDatasetsClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected ConversationDatasetsClient(ConversationDatasetsSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((ConversationDatasetsStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected ConversationDatasetsClient(ConversationDatasetsStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final ConversationDatasetsSettings getSettings() {
    return settings;
  }

  public ConversationDatasetsStub getStub() {
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
   * Creates a new conversation dataset.
   *
   * <p>This method is a [long-running
   * operation](https://cloud.google.com/dialogflow/es/docs/how/long-running-operations). The
   * returned `Operation` type has the following method-specific fields:
   *
   * <p>- `metadata`:
   * [CreateConversationDatasetOperationMetadata][google.cloud.dialogflow.v2.CreateConversationDatasetOperationMetadata]
   * - `response`: [ConversationDataset][google.cloud.dialogflow.v2.ConversationDataset]
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationDatasetsClient conversationDatasetsClient =
   *     ConversationDatasetsClient.create()) {
   *   String parent = "parent-995424086";
   *   ConversationDataset conversationDataset = ConversationDataset.newBuilder().build();
   *   ConversationDataset response =
   *       conversationDatasetsClient
   *           .createConversationDatasetAsync(parent, conversationDataset)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The project to create conversation dataset for. Format:
   *     `projects/&lt;Project ID&gt;/locations/&lt;Location ID&gt;`
   * @param conversationDataset Required. The conversation dataset to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ConversationDataset, CreateConversationDatasetOperationMetadata>
      createConversationDatasetAsync(String parent, ConversationDataset conversationDataset) {
    CreateConversationDatasetRequest request =
        CreateConversationDatasetRequest.newBuilder()
            .setParent(parent)
            .setConversationDataset(conversationDataset)
            .build();
    return createConversationDatasetAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new conversation dataset.
   *
   * <p>This method is a [long-running
   * operation](https://cloud.google.com/dialogflow/es/docs/how/long-running-operations). The
   * returned `Operation` type has the following method-specific fields:
   *
   * <p>- `metadata`:
   * [CreateConversationDatasetOperationMetadata][google.cloud.dialogflow.v2.CreateConversationDatasetOperationMetadata]
   * - `response`: [ConversationDataset][google.cloud.dialogflow.v2.ConversationDataset]
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationDatasetsClient conversationDatasetsClient =
   *     ConversationDatasetsClient.create()) {
   *   CreateConversationDatasetRequest request =
   *       CreateConversationDatasetRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setConversationDataset(ConversationDataset.newBuilder().build())
   *           .build();
   *   ConversationDataset response =
   *       conversationDatasetsClient.createConversationDatasetAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ConversationDataset, CreateConversationDatasetOperationMetadata>
      createConversationDatasetAsync(CreateConversationDatasetRequest request) {
    return createConversationDatasetOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new conversation dataset.
   *
   * <p>This method is a [long-running
   * operation](https://cloud.google.com/dialogflow/es/docs/how/long-running-operations). The
   * returned `Operation` type has the following method-specific fields:
   *
   * <p>- `metadata`:
   * [CreateConversationDatasetOperationMetadata][google.cloud.dialogflow.v2.CreateConversationDatasetOperationMetadata]
   * - `response`: [ConversationDataset][google.cloud.dialogflow.v2.ConversationDataset]
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationDatasetsClient conversationDatasetsClient =
   *     ConversationDatasetsClient.create()) {
   *   CreateConversationDatasetRequest request =
   *       CreateConversationDatasetRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setConversationDataset(ConversationDataset.newBuilder().build())
   *           .build();
   *   OperationFuture<ConversationDataset, CreateConversationDatasetOperationMetadata> future =
   *       conversationDatasetsClient
   *           .createConversationDatasetOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   ConversationDataset response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          CreateConversationDatasetRequest,
          ConversationDataset,
          CreateConversationDatasetOperationMetadata>
      createConversationDatasetOperationCallable() {
    return stub.createConversationDatasetOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new conversation dataset.
   *
   * <p>This method is a [long-running
   * operation](https://cloud.google.com/dialogflow/es/docs/how/long-running-operations). The
   * returned `Operation` type has the following method-specific fields:
   *
   * <p>- `metadata`:
   * [CreateConversationDatasetOperationMetadata][google.cloud.dialogflow.v2.CreateConversationDatasetOperationMetadata]
   * - `response`: [ConversationDataset][google.cloud.dialogflow.v2.ConversationDataset]
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationDatasetsClient conversationDatasetsClient =
   *     ConversationDatasetsClient.create()) {
   *   CreateConversationDatasetRequest request =
   *       CreateConversationDatasetRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setConversationDataset(ConversationDataset.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       conversationDatasetsClient.createConversationDatasetCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateConversationDatasetRequest, Operation>
      createConversationDatasetCallable() {
    return stub.createConversationDatasetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the specified conversation dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationDatasetsClient conversationDatasetsClient =
   *     ConversationDatasetsClient.create()) {
   *   ConversationDatasetName name =
   *       ConversationDatasetName.of("[PROJECT]", "[LOCATION]", "[CONVERSATION_DATASET]");
   *   ConversationDataset response = conversationDatasetsClient.getConversationDataset(name);
   * }
   * }</pre>
   *
   * @param name Required. The conversation dataset to retrieve. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/conversationDatasets/&lt;Conversation Dataset ID&gt;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ConversationDataset getConversationDataset(ConversationDatasetName name) {
    GetConversationDatasetRequest request =
        GetConversationDatasetRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getConversationDataset(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the specified conversation dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationDatasetsClient conversationDatasetsClient =
   *     ConversationDatasetsClient.create()) {
   *   String name =
   *       ConversationDatasetName.of("[PROJECT]", "[LOCATION]", "[CONVERSATION_DATASET]")
   *           .toString();
   *   ConversationDataset response = conversationDatasetsClient.getConversationDataset(name);
   * }
   * }</pre>
   *
   * @param name Required. The conversation dataset to retrieve. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/conversationDatasets/&lt;Conversation Dataset ID&gt;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ConversationDataset getConversationDataset(String name) {
    GetConversationDatasetRequest request =
        GetConversationDatasetRequest.newBuilder().setName(name).build();
    return getConversationDataset(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the specified conversation dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationDatasetsClient conversationDatasetsClient =
   *     ConversationDatasetsClient.create()) {
   *   GetConversationDatasetRequest request =
   *       GetConversationDatasetRequest.newBuilder()
   *           .setName(
   *               ConversationDatasetName.of("[PROJECT]", "[LOCATION]", "[CONVERSATION_DATASET]")
   *                   .toString())
   *           .build();
   *   ConversationDataset response = conversationDatasetsClient.getConversationDataset(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ConversationDataset getConversationDataset(GetConversationDatasetRequest request) {
    return getConversationDatasetCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the specified conversation dataset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationDatasetsClient conversationDatasetsClient =
   *     ConversationDatasetsClient.create()) {
   *   GetConversationDatasetRequest request =
   *       GetConversationDatasetRequest.newBuilder()
   *           .setName(
   *               ConversationDatasetName.of("[PROJECT]", "[LOCATION]", "[CONVERSATION_DATASET]")
   *                   .toString())
   *           .build();
   *   ApiFuture<ConversationDataset> future =
   *       conversationDatasetsClient.getConversationDatasetCallable().futureCall(request);
   *   // Do something.
   *   ConversationDataset response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetConversationDatasetRequest, ConversationDataset>
      getConversationDatasetCallable() {
    return stub.getConversationDatasetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of all conversation datasets in the specified project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationDatasetsClient conversationDatasetsClient =
   *     ConversationDatasetsClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (ConversationDataset element :
   *       conversationDatasetsClient.listConversationDatasets(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project and location name to list all conversation datasets for.
   *     Format: `projects/&lt;Project ID&gt;/locations/&lt;Location ID&gt;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListConversationDatasetsPagedResponse listConversationDatasets(LocationName parent) {
    ListConversationDatasetsRequest request =
        ListConversationDatasetsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listConversationDatasets(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of all conversation datasets in the specified project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationDatasetsClient conversationDatasetsClient =
   *     ConversationDatasetsClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (ConversationDataset element :
   *       conversationDatasetsClient.listConversationDatasets(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project and location name to list all conversation datasets for.
   *     Format: `projects/&lt;Project ID&gt;/locations/&lt;Location ID&gt;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListConversationDatasetsPagedResponse listConversationDatasets(String parent) {
    ListConversationDatasetsRequest request =
        ListConversationDatasetsRequest.newBuilder().setParent(parent).build();
    return listConversationDatasets(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of all conversation datasets in the specified project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationDatasetsClient conversationDatasetsClient =
   *     ConversationDatasetsClient.create()) {
   *   ListConversationDatasetsRequest request =
   *       ListConversationDatasetsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (ConversationDataset element :
   *       conversationDatasetsClient.listConversationDatasets(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListConversationDatasetsPagedResponse listConversationDatasets(
      ListConversationDatasetsRequest request) {
    return listConversationDatasetsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of all conversation datasets in the specified project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationDatasetsClient conversationDatasetsClient =
   *     ConversationDatasetsClient.create()) {
   *   ListConversationDatasetsRequest request =
   *       ListConversationDatasetsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<ConversationDataset> future =
   *       conversationDatasetsClient.listConversationDatasetsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (ConversationDataset element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListConversationDatasetsRequest, ListConversationDatasetsPagedResponse>
      listConversationDatasetsPagedCallable() {
    return stub.listConversationDatasetsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of all conversation datasets in the specified project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationDatasetsClient conversationDatasetsClient =
   *     ConversationDatasetsClient.create()) {
   *   ListConversationDatasetsRequest request =
   *       ListConversationDatasetsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListConversationDatasetsResponse response =
   *         conversationDatasetsClient.listConversationDatasetsCallable().call(request);
   *     for (ConversationDataset element : response.getConversationDatasetsList()) {
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
  public final UnaryCallable<ListConversationDatasetsRequest, ListConversationDatasetsResponse>
      listConversationDatasetsCallable() {
    return stub.listConversationDatasetsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified conversation dataset.
   *
   * <p>This method is a [long-running
   * operation](https://cloud.google.com/dialogflow/es/docs/how/long-running-operations). The
   * returned `Operation` type has the following method-specific fields:
   *
   * <p>- `metadata`:
   * [DeleteConversationDatasetOperationMetadata][google.cloud.dialogflow.v2.DeleteConversationDatasetOperationMetadata]
   * - `response`: An [Empty
   * message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#empty)
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationDatasetsClient conversationDatasetsClient =
   *     ConversationDatasetsClient.create()) {
   *   ConversationDatasetName name =
   *       ConversationDatasetName.of("[PROJECT]", "[LOCATION]", "[CONVERSATION_DATASET]");
   *   conversationDatasetsClient.deleteConversationDatasetAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The conversation dataset to delete. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/conversationDatasets/&lt;Conversation Dataset ID&gt;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteConversationDatasetOperationMetadata>
      deleteConversationDatasetAsync(ConversationDatasetName name) {
    DeleteConversationDatasetRequest request =
        DeleteConversationDatasetRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteConversationDatasetAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified conversation dataset.
   *
   * <p>This method is a [long-running
   * operation](https://cloud.google.com/dialogflow/es/docs/how/long-running-operations). The
   * returned `Operation` type has the following method-specific fields:
   *
   * <p>- `metadata`:
   * [DeleteConversationDatasetOperationMetadata][google.cloud.dialogflow.v2.DeleteConversationDatasetOperationMetadata]
   * - `response`: An [Empty
   * message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#empty)
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationDatasetsClient conversationDatasetsClient =
   *     ConversationDatasetsClient.create()) {
   *   String name =
   *       ConversationDatasetName.of("[PROJECT]", "[LOCATION]", "[CONVERSATION_DATASET]")
   *           .toString();
   *   conversationDatasetsClient.deleteConversationDatasetAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The conversation dataset to delete. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/conversationDatasets/&lt;Conversation Dataset ID&gt;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteConversationDatasetOperationMetadata>
      deleteConversationDatasetAsync(String name) {
    DeleteConversationDatasetRequest request =
        DeleteConversationDatasetRequest.newBuilder().setName(name).build();
    return deleteConversationDatasetAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified conversation dataset.
   *
   * <p>This method is a [long-running
   * operation](https://cloud.google.com/dialogflow/es/docs/how/long-running-operations). The
   * returned `Operation` type has the following method-specific fields:
   *
   * <p>- `metadata`:
   * [DeleteConversationDatasetOperationMetadata][google.cloud.dialogflow.v2.DeleteConversationDatasetOperationMetadata]
   * - `response`: An [Empty
   * message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#empty)
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationDatasetsClient conversationDatasetsClient =
   *     ConversationDatasetsClient.create()) {
   *   DeleteConversationDatasetRequest request =
   *       DeleteConversationDatasetRequest.newBuilder()
   *           .setName(
   *               ConversationDatasetName.of("[PROJECT]", "[LOCATION]", "[CONVERSATION_DATASET]")
   *                   .toString())
   *           .build();
   *   conversationDatasetsClient.deleteConversationDatasetAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteConversationDatasetOperationMetadata>
      deleteConversationDatasetAsync(DeleteConversationDatasetRequest request) {
    return deleteConversationDatasetOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified conversation dataset.
   *
   * <p>This method is a [long-running
   * operation](https://cloud.google.com/dialogflow/es/docs/how/long-running-operations). The
   * returned `Operation` type has the following method-specific fields:
   *
   * <p>- `metadata`:
   * [DeleteConversationDatasetOperationMetadata][google.cloud.dialogflow.v2.DeleteConversationDatasetOperationMetadata]
   * - `response`: An [Empty
   * message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#empty)
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationDatasetsClient conversationDatasetsClient =
   *     ConversationDatasetsClient.create()) {
   *   DeleteConversationDatasetRequest request =
   *       DeleteConversationDatasetRequest.newBuilder()
   *           .setName(
   *               ConversationDatasetName.of("[PROJECT]", "[LOCATION]", "[CONVERSATION_DATASET]")
   *                   .toString())
   *           .build();
   *   OperationFuture<Empty, DeleteConversationDatasetOperationMetadata> future =
   *       conversationDatasetsClient
   *           .deleteConversationDatasetOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          DeleteConversationDatasetRequest, Empty, DeleteConversationDatasetOperationMetadata>
      deleteConversationDatasetOperationCallable() {
    return stub.deleteConversationDatasetOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified conversation dataset.
   *
   * <p>This method is a [long-running
   * operation](https://cloud.google.com/dialogflow/es/docs/how/long-running-operations). The
   * returned `Operation` type has the following method-specific fields:
   *
   * <p>- `metadata`:
   * [DeleteConversationDatasetOperationMetadata][google.cloud.dialogflow.v2.DeleteConversationDatasetOperationMetadata]
   * - `response`: An [Empty
   * message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#empty)
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationDatasetsClient conversationDatasetsClient =
   *     ConversationDatasetsClient.create()) {
   *   DeleteConversationDatasetRequest request =
   *       DeleteConversationDatasetRequest.newBuilder()
   *           .setName(
   *               ConversationDatasetName.of("[PROJECT]", "[LOCATION]", "[CONVERSATION_DATASET]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       conversationDatasetsClient.deleteConversationDatasetCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteConversationDatasetRequest, Operation>
      deleteConversationDatasetCallable() {
    return stub.deleteConversationDatasetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Import data into the specified conversation dataset. Note that it is not allowed to import data
   * to a conversation dataset that already has data in it.
   *
   * <p>This method is a [long-running
   * operation](https://cloud.google.com/dialogflow/es/docs/how/long-running-operations). The
   * returned `Operation` type has the following method-specific fields:
   *
   * <p>- `metadata`:
   * [ImportConversationDataOperationMetadata][google.cloud.dialogflow.v2.ImportConversationDataOperationMetadata]
   * - `response`:
   * [ImportConversationDataOperationResponse][google.cloud.dialogflow.v2.ImportConversationDataOperationResponse]
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationDatasetsClient conversationDatasetsClient =
   *     ConversationDatasetsClient.create()) {
   *   ImportConversationDataRequest request =
   *       ImportConversationDataRequest.newBuilder()
   *           .setName(
   *               ConversationDatasetName.of("[PROJECT]", "[LOCATION]", "[CONVERSATION_DATASET]")
   *                   .toString())
   *           .setInputConfig(InputConfig.newBuilder().build())
   *           .build();
   *   ImportConversationDataOperationResponse response =
   *       conversationDatasetsClient.importConversationDataAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<
          ImportConversationDataOperationResponse, ImportConversationDataOperationMetadata>
      importConversationDataAsync(ImportConversationDataRequest request) {
    return importConversationDataOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Import data into the specified conversation dataset. Note that it is not allowed to import data
   * to a conversation dataset that already has data in it.
   *
   * <p>This method is a [long-running
   * operation](https://cloud.google.com/dialogflow/es/docs/how/long-running-operations). The
   * returned `Operation` type has the following method-specific fields:
   *
   * <p>- `metadata`:
   * [ImportConversationDataOperationMetadata][google.cloud.dialogflow.v2.ImportConversationDataOperationMetadata]
   * - `response`:
   * [ImportConversationDataOperationResponse][google.cloud.dialogflow.v2.ImportConversationDataOperationResponse]
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationDatasetsClient conversationDatasetsClient =
   *     ConversationDatasetsClient.create()) {
   *   ImportConversationDataRequest request =
   *       ImportConversationDataRequest.newBuilder()
   *           .setName(
   *               ConversationDatasetName.of("[PROJECT]", "[LOCATION]", "[CONVERSATION_DATASET]")
   *                   .toString())
   *           .setInputConfig(InputConfig.newBuilder().build())
   *           .build();
   *   OperationFuture<
   *           ImportConversationDataOperationResponse, ImportConversationDataOperationMetadata>
   *       future =
   *           conversationDatasetsClient
   *               .importConversationDataOperationCallable()
   *               .futureCall(request);
   *   // Do something.
   *   ImportConversationDataOperationResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          ImportConversationDataRequest,
          ImportConversationDataOperationResponse,
          ImportConversationDataOperationMetadata>
      importConversationDataOperationCallable() {
    return stub.importConversationDataOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Import data into the specified conversation dataset. Note that it is not allowed to import data
   * to a conversation dataset that already has data in it.
   *
   * <p>This method is a [long-running
   * operation](https://cloud.google.com/dialogflow/es/docs/how/long-running-operations). The
   * returned `Operation` type has the following method-specific fields:
   *
   * <p>- `metadata`:
   * [ImportConversationDataOperationMetadata][google.cloud.dialogflow.v2.ImportConversationDataOperationMetadata]
   * - `response`:
   * [ImportConversationDataOperationResponse][google.cloud.dialogflow.v2.ImportConversationDataOperationResponse]
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationDatasetsClient conversationDatasetsClient =
   *     ConversationDatasetsClient.create()) {
   *   ImportConversationDataRequest request =
   *       ImportConversationDataRequest.newBuilder()
   *           .setName(
   *               ConversationDatasetName.of("[PROJECT]", "[LOCATION]", "[CONVERSATION_DATASET]")
   *                   .toString())
   *           .setInputConfig(InputConfig.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       conversationDatasetsClient.importConversationDataCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ImportConversationDataRequest, Operation>
      importConversationDataCallable() {
    return stub.importConversationDataCallable();
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
   * try (ConversationDatasetsClient conversationDatasetsClient =
   *     ConversationDatasetsClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : conversationDatasetsClient.listLocations(request).iterateAll()) {
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
   * try (ConversationDatasetsClient conversationDatasetsClient =
   *     ConversationDatasetsClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       conversationDatasetsClient.listLocationsPagedCallable().futureCall(request);
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
   * try (ConversationDatasetsClient conversationDatasetsClient =
   *     ConversationDatasetsClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response =
   *         conversationDatasetsClient.listLocationsCallable().call(request);
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
   * try (ConversationDatasetsClient conversationDatasetsClient =
   *     ConversationDatasetsClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = conversationDatasetsClient.getLocation(request);
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
   * try (ConversationDatasetsClient conversationDatasetsClient =
   *     ConversationDatasetsClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future =
   *       conversationDatasetsClient.getLocationCallable().futureCall(request);
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

  public static class ListConversationDatasetsPagedResponse
      extends AbstractPagedListResponse<
          ListConversationDatasetsRequest,
          ListConversationDatasetsResponse,
          ConversationDataset,
          ListConversationDatasetsPage,
          ListConversationDatasetsFixedSizeCollection> {

    public static ApiFuture<ListConversationDatasetsPagedResponse> createAsync(
        PageContext<
                ListConversationDatasetsRequest,
                ListConversationDatasetsResponse,
                ConversationDataset>
            context,
        ApiFuture<ListConversationDatasetsResponse> futureResponse) {
      ApiFuture<ListConversationDatasetsPage> futurePage =
          ListConversationDatasetsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListConversationDatasetsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListConversationDatasetsPagedResponse(ListConversationDatasetsPage page) {
      super(page, ListConversationDatasetsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListConversationDatasetsPage
      extends AbstractPage<
          ListConversationDatasetsRequest,
          ListConversationDatasetsResponse,
          ConversationDataset,
          ListConversationDatasetsPage> {

    private ListConversationDatasetsPage(
        PageContext<
                ListConversationDatasetsRequest,
                ListConversationDatasetsResponse,
                ConversationDataset>
            context,
        ListConversationDatasetsResponse response) {
      super(context, response);
    }

    private static ListConversationDatasetsPage createEmptyPage() {
      return new ListConversationDatasetsPage(null, null);
    }

    @Override
    protected ListConversationDatasetsPage createPage(
        PageContext<
                ListConversationDatasetsRequest,
                ListConversationDatasetsResponse,
                ConversationDataset>
            context,
        ListConversationDatasetsResponse response) {
      return new ListConversationDatasetsPage(context, response);
    }

    @Override
    public ApiFuture<ListConversationDatasetsPage> createPageAsync(
        PageContext<
                ListConversationDatasetsRequest,
                ListConversationDatasetsResponse,
                ConversationDataset>
            context,
        ApiFuture<ListConversationDatasetsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListConversationDatasetsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListConversationDatasetsRequest,
          ListConversationDatasetsResponse,
          ConversationDataset,
          ListConversationDatasetsPage,
          ListConversationDatasetsFixedSizeCollection> {

    private ListConversationDatasetsFixedSizeCollection(
        List<ListConversationDatasetsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListConversationDatasetsFixedSizeCollection createEmptyCollection() {
      return new ListConversationDatasetsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListConversationDatasetsFixedSizeCollection createCollection(
        List<ListConversationDatasetsPage> pages, int collectionSize) {
      return new ListConversationDatasetsFixedSizeCollection(pages, collectionSize);
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
