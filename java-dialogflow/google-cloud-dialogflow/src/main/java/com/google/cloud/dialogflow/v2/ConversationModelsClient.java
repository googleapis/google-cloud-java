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
import com.google.cloud.dialogflow.v2.stub.ConversationModelsStub;
import com.google.cloud.dialogflow.v2.stub.ConversationModelsStubSettings;
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
 * Service Description: Manages a collection of models for human agent assistant.
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
 * try (ConversationModelsClient conversationModelsClient = ConversationModelsClient.create()) {
 *   String name = "name3373707";
 *   ConversationModel response = conversationModelsClient.getConversationModel(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the ConversationModelsClient object to clean up resources
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
 * <p>This class can be customized by passing in a custom instance of ConversationModelsSettings to
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
 * ConversationModelsSettings conversationModelsSettings =
 *     ConversationModelsSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ConversationModelsClient conversationModelsClient =
 *     ConversationModelsClient.create(conversationModelsSettings);
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
 * ConversationModelsSettings conversationModelsSettings =
 *     ConversationModelsSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ConversationModelsClient conversationModelsClient =
 *     ConversationModelsClient.create(conversationModelsSettings);
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
 * ConversationModelsSettings conversationModelsSettings =
 *     ConversationModelsSettings.newBuilder()
 *         .setTransportChannelProvider(
 *             ConversationModelsSettings.defaultHttpJsonTransportProviderBuilder().build())
 *         .build();
 * ConversationModelsClient conversationModelsClient =
 *     ConversationModelsClient.create(conversationModelsSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class ConversationModelsClient implements BackgroundResource {
  private final ConversationModelsSettings settings;
  private final ConversationModelsStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of ConversationModelsClient with default settings. */
  public static final ConversationModelsClient create() throws IOException {
    return create(ConversationModelsSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ConversationModelsClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ConversationModelsClient create(ConversationModelsSettings settings)
      throws IOException {
    return new ConversationModelsClient(settings);
  }

  /**
   * Constructs an instance of ConversationModelsClient, using the given stub for making calls. This
   * is for advanced usage - prefer using create(ConversationModelsSettings).
   */
  public static final ConversationModelsClient create(ConversationModelsStub stub) {
    return new ConversationModelsClient(stub);
  }

  /**
   * Constructs an instance of ConversationModelsClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected ConversationModelsClient(ConversationModelsSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((ConversationModelsStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected ConversationModelsClient(ConversationModelsStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final ConversationModelsSettings getSettings() {
    return settings;
  }

  public ConversationModelsStub getStub() {
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
   * Creates a model.
   *
   * <p>This method is a [long-running
   * operation](https://cloud.google.com/dialogflow/es/docs/how/long-running-operations). The
   * returned `Operation` type has the following method-specific fields:
   *
   * <p>- `metadata`:
   * [CreateConversationModelOperationMetadata][google.cloud.dialogflow.v2.CreateConversationModelOperationMetadata]
   * - `response`: [ConversationModel][google.cloud.dialogflow.v2.ConversationModel]
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationModelsClient conversationModelsClient = ConversationModelsClient.create()) {
   *   String parent = "parent-995424086";
   *   ConversationModel conversationModel = ConversationModel.newBuilder().build();
   *   ConversationModel response =
   *       conversationModelsClient.createConversationModelAsync(parent, conversationModel).get();
   * }
   * }</pre>
   *
   * @param parent The project to create conversation model for. Format: `projects/&lt;Project
   *     ID&gt;`
   * @param conversationModel Required. The conversation model to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ConversationModel, CreateConversationModelOperationMetadata>
      createConversationModelAsync(String parent, ConversationModel conversationModel) {
    CreateConversationModelRequest request =
        CreateConversationModelRequest.newBuilder()
            .setParent(parent)
            .setConversationModel(conversationModel)
            .build();
    return createConversationModelAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a model.
   *
   * <p>This method is a [long-running
   * operation](https://cloud.google.com/dialogflow/es/docs/how/long-running-operations). The
   * returned `Operation` type has the following method-specific fields:
   *
   * <p>- `metadata`:
   * [CreateConversationModelOperationMetadata][google.cloud.dialogflow.v2.CreateConversationModelOperationMetadata]
   * - `response`: [ConversationModel][google.cloud.dialogflow.v2.ConversationModel]
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationModelsClient conversationModelsClient = ConversationModelsClient.create()) {
   *   CreateConversationModelRequest request =
   *       CreateConversationModelRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setConversationModel(ConversationModel.newBuilder().build())
   *           .build();
   *   ConversationModel response =
   *       conversationModelsClient.createConversationModelAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ConversationModel, CreateConversationModelOperationMetadata>
      createConversationModelAsync(CreateConversationModelRequest request) {
    return createConversationModelOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a model.
   *
   * <p>This method is a [long-running
   * operation](https://cloud.google.com/dialogflow/es/docs/how/long-running-operations). The
   * returned `Operation` type has the following method-specific fields:
   *
   * <p>- `metadata`:
   * [CreateConversationModelOperationMetadata][google.cloud.dialogflow.v2.CreateConversationModelOperationMetadata]
   * - `response`: [ConversationModel][google.cloud.dialogflow.v2.ConversationModel]
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationModelsClient conversationModelsClient = ConversationModelsClient.create()) {
   *   CreateConversationModelRequest request =
   *       CreateConversationModelRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setConversationModel(ConversationModel.newBuilder().build())
   *           .build();
   *   OperationFuture<ConversationModel, CreateConversationModelOperationMetadata> future =
   *       conversationModelsClient.createConversationModelOperationCallable().futureCall(request);
   *   // Do something.
   *   ConversationModel response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          CreateConversationModelRequest,
          ConversationModel,
          CreateConversationModelOperationMetadata>
      createConversationModelOperationCallable() {
    return stub.createConversationModelOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a model.
   *
   * <p>This method is a [long-running
   * operation](https://cloud.google.com/dialogflow/es/docs/how/long-running-operations). The
   * returned `Operation` type has the following method-specific fields:
   *
   * <p>- `metadata`:
   * [CreateConversationModelOperationMetadata][google.cloud.dialogflow.v2.CreateConversationModelOperationMetadata]
   * - `response`: [ConversationModel][google.cloud.dialogflow.v2.ConversationModel]
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationModelsClient conversationModelsClient = ConversationModelsClient.create()) {
   *   CreateConversationModelRequest request =
   *       CreateConversationModelRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setConversationModel(ConversationModel.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       conversationModelsClient.createConversationModelCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateConversationModelRequest, Operation>
      createConversationModelCallable() {
    return stub.createConversationModelCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets conversation model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationModelsClient conversationModelsClient = ConversationModelsClient.create()) {
   *   String name = "name3373707";
   *   ConversationModel response = conversationModelsClient.getConversationModel(name);
   * }
   * }</pre>
   *
   * @param name Required. The conversation model to retrieve. Format: `projects/&lt;Project
   *     ID&gt;/conversationModels/&lt;Conversation Model ID&gt;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ConversationModel getConversationModel(String name) {
    GetConversationModelRequest request =
        GetConversationModelRequest.newBuilder().setName(name).build();
    return getConversationModel(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets conversation model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationModelsClient conversationModelsClient = ConversationModelsClient.create()) {
   *   GetConversationModelRequest request =
   *       GetConversationModelRequest.newBuilder().setName("name3373707").build();
   *   ConversationModel response = conversationModelsClient.getConversationModel(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ConversationModel getConversationModel(GetConversationModelRequest request) {
    return getConversationModelCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets conversation model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationModelsClient conversationModelsClient = ConversationModelsClient.create()) {
   *   GetConversationModelRequest request =
   *       GetConversationModelRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<ConversationModel> future =
   *       conversationModelsClient.getConversationModelCallable().futureCall(request);
   *   // Do something.
   *   ConversationModel response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetConversationModelRequest, ConversationModel>
      getConversationModelCallable() {
    return stub.getConversationModelCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists conversation models.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationModelsClient conversationModelsClient = ConversationModelsClient.create()) {
   *   String parent = "parent-995424086";
   *   for (ConversationModel element :
   *       conversationModelsClient.listConversationModels(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project to list all conversation models for. Format:
   *     `projects/&lt;Project ID&gt;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListConversationModelsPagedResponse listConversationModels(String parent) {
    ListConversationModelsRequest request =
        ListConversationModelsRequest.newBuilder().setParent(parent).build();
    return listConversationModels(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists conversation models.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationModelsClient conversationModelsClient = ConversationModelsClient.create()) {
   *   ListConversationModelsRequest request =
   *       ListConversationModelsRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (ConversationModel element :
   *       conversationModelsClient.listConversationModels(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListConversationModelsPagedResponse listConversationModels(
      ListConversationModelsRequest request) {
    return listConversationModelsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists conversation models.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationModelsClient conversationModelsClient = ConversationModelsClient.create()) {
   *   ListConversationModelsRequest request =
   *       ListConversationModelsRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<ConversationModel> future =
   *       conversationModelsClient.listConversationModelsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (ConversationModel element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListConversationModelsRequest, ListConversationModelsPagedResponse>
      listConversationModelsPagedCallable() {
    return stub.listConversationModelsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists conversation models.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationModelsClient conversationModelsClient = ConversationModelsClient.create()) {
   *   ListConversationModelsRequest request =
   *       ListConversationModelsRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListConversationModelsResponse response =
   *         conversationModelsClient.listConversationModelsCallable().call(request);
   *     for (ConversationModel element : response.getConversationModelsList()) {
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
  public final UnaryCallable<ListConversationModelsRequest, ListConversationModelsResponse>
      listConversationModelsCallable() {
    return stub.listConversationModelsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a model.
   *
   * <p>This method is a [long-running
   * operation](https://cloud.google.com/dialogflow/es/docs/how/long-running-operations). The
   * returned `Operation` type has the following method-specific fields:
   *
   * <p>- `metadata`:
   * [DeleteConversationModelOperationMetadata][google.cloud.dialogflow.v2.DeleteConversationModelOperationMetadata]
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
   * try (ConversationModelsClient conversationModelsClient = ConversationModelsClient.create()) {
   *   String name = "name3373707";
   *   conversationModelsClient.deleteConversationModelAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The conversation model to delete. Format: `projects/&lt;Project
   *     ID&gt;/conversationModels/&lt;Conversation Model ID&gt;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteConversationModelOperationMetadata>
      deleteConversationModelAsync(String name) {
    DeleteConversationModelRequest request =
        DeleteConversationModelRequest.newBuilder().setName(name).build();
    return deleteConversationModelAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a model.
   *
   * <p>This method is a [long-running
   * operation](https://cloud.google.com/dialogflow/es/docs/how/long-running-operations). The
   * returned `Operation` type has the following method-specific fields:
   *
   * <p>- `metadata`:
   * [DeleteConversationModelOperationMetadata][google.cloud.dialogflow.v2.DeleteConversationModelOperationMetadata]
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
   * try (ConversationModelsClient conversationModelsClient = ConversationModelsClient.create()) {
   *   DeleteConversationModelRequest request =
   *       DeleteConversationModelRequest.newBuilder().setName("name3373707").build();
   *   conversationModelsClient.deleteConversationModelAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteConversationModelOperationMetadata>
      deleteConversationModelAsync(DeleteConversationModelRequest request) {
    return deleteConversationModelOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a model.
   *
   * <p>This method is a [long-running
   * operation](https://cloud.google.com/dialogflow/es/docs/how/long-running-operations). The
   * returned `Operation` type has the following method-specific fields:
   *
   * <p>- `metadata`:
   * [DeleteConversationModelOperationMetadata][google.cloud.dialogflow.v2.DeleteConversationModelOperationMetadata]
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
   * try (ConversationModelsClient conversationModelsClient = ConversationModelsClient.create()) {
   *   DeleteConversationModelRequest request =
   *       DeleteConversationModelRequest.newBuilder().setName("name3373707").build();
   *   OperationFuture<Empty, DeleteConversationModelOperationMetadata> future =
   *       conversationModelsClient.deleteConversationModelOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          DeleteConversationModelRequest, Empty, DeleteConversationModelOperationMetadata>
      deleteConversationModelOperationCallable() {
    return stub.deleteConversationModelOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a model.
   *
   * <p>This method is a [long-running
   * operation](https://cloud.google.com/dialogflow/es/docs/how/long-running-operations). The
   * returned `Operation` type has the following method-specific fields:
   *
   * <p>- `metadata`:
   * [DeleteConversationModelOperationMetadata][google.cloud.dialogflow.v2.DeleteConversationModelOperationMetadata]
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
   * try (ConversationModelsClient conversationModelsClient = ConversationModelsClient.create()) {
   *   DeleteConversationModelRequest request =
   *       DeleteConversationModelRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Operation> future =
   *       conversationModelsClient.deleteConversationModelCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteConversationModelRequest, Operation>
      deleteConversationModelCallable() {
    return stub.deleteConversationModelCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deploys a model. If a model is already deployed, deploying it has no effect. A model can only
   * serve prediction requests after it gets deployed. For article suggestion, custom model will not
   * be used unless it is deployed.
   *
   * <p>This method is a [long-running
   * operation](https://cloud.google.com/dialogflow/es/docs/how/long-running-operations). The
   * returned `Operation` type has the following method-specific fields:
   *
   * <p>- `metadata`:
   * [DeployConversationModelOperationMetadata][google.cloud.dialogflow.v2.DeployConversationModelOperationMetadata]
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
   * try (ConversationModelsClient conversationModelsClient = ConversationModelsClient.create()) {
   *   DeployConversationModelRequest request =
   *       DeployConversationModelRequest.newBuilder().setName("name3373707").build();
   *   conversationModelsClient.deployConversationModelAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeployConversationModelOperationMetadata>
      deployConversationModelAsync(DeployConversationModelRequest request) {
    return deployConversationModelOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deploys a model. If a model is already deployed, deploying it has no effect. A model can only
   * serve prediction requests after it gets deployed. For article suggestion, custom model will not
   * be used unless it is deployed.
   *
   * <p>This method is a [long-running
   * operation](https://cloud.google.com/dialogflow/es/docs/how/long-running-operations). The
   * returned `Operation` type has the following method-specific fields:
   *
   * <p>- `metadata`:
   * [DeployConversationModelOperationMetadata][google.cloud.dialogflow.v2.DeployConversationModelOperationMetadata]
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
   * try (ConversationModelsClient conversationModelsClient = ConversationModelsClient.create()) {
   *   DeployConversationModelRequest request =
   *       DeployConversationModelRequest.newBuilder().setName("name3373707").build();
   *   OperationFuture<Empty, DeployConversationModelOperationMetadata> future =
   *       conversationModelsClient.deployConversationModelOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          DeployConversationModelRequest, Empty, DeployConversationModelOperationMetadata>
      deployConversationModelOperationCallable() {
    return stub.deployConversationModelOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deploys a model. If a model is already deployed, deploying it has no effect. A model can only
   * serve prediction requests after it gets deployed. For article suggestion, custom model will not
   * be used unless it is deployed.
   *
   * <p>This method is a [long-running
   * operation](https://cloud.google.com/dialogflow/es/docs/how/long-running-operations). The
   * returned `Operation` type has the following method-specific fields:
   *
   * <p>- `metadata`:
   * [DeployConversationModelOperationMetadata][google.cloud.dialogflow.v2.DeployConversationModelOperationMetadata]
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
   * try (ConversationModelsClient conversationModelsClient = ConversationModelsClient.create()) {
   *   DeployConversationModelRequest request =
   *       DeployConversationModelRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Operation> future =
   *       conversationModelsClient.deployConversationModelCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeployConversationModelRequest, Operation>
      deployConversationModelCallable() {
    return stub.deployConversationModelCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Undeploys a model. If the model is not deployed this method has no effect. If the model is
   * currently being used: - For article suggestion, article suggestion will fallback to the default
   * model if model is undeployed.
   *
   * <p>This method is a [long-running
   * operation](https://cloud.google.com/dialogflow/es/docs/how/long-running-operations). The
   * returned `Operation` type has the following method-specific fields:
   *
   * <p>- `metadata`:
   * [UndeployConversationModelOperationMetadata][google.cloud.dialogflow.v2.UndeployConversationModelOperationMetadata]
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
   * try (ConversationModelsClient conversationModelsClient = ConversationModelsClient.create()) {
   *   UndeployConversationModelRequest request =
   *       UndeployConversationModelRequest.newBuilder().setName("name3373707").build();
   *   conversationModelsClient.undeployConversationModelAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, UndeployConversationModelOperationMetadata>
      undeployConversationModelAsync(UndeployConversationModelRequest request) {
    return undeployConversationModelOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Undeploys a model. If the model is not deployed this method has no effect. If the model is
   * currently being used: - For article suggestion, article suggestion will fallback to the default
   * model if model is undeployed.
   *
   * <p>This method is a [long-running
   * operation](https://cloud.google.com/dialogflow/es/docs/how/long-running-operations). The
   * returned `Operation` type has the following method-specific fields:
   *
   * <p>- `metadata`:
   * [UndeployConversationModelOperationMetadata][google.cloud.dialogflow.v2.UndeployConversationModelOperationMetadata]
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
   * try (ConversationModelsClient conversationModelsClient = ConversationModelsClient.create()) {
   *   UndeployConversationModelRequest request =
   *       UndeployConversationModelRequest.newBuilder().setName("name3373707").build();
   *   OperationFuture<Empty, UndeployConversationModelOperationMetadata> future =
   *       conversationModelsClient.undeployConversationModelOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          UndeployConversationModelRequest, Empty, UndeployConversationModelOperationMetadata>
      undeployConversationModelOperationCallable() {
    return stub.undeployConversationModelOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Undeploys a model. If the model is not deployed this method has no effect. If the model is
   * currently being used: - For article suggestion, article suggestion will fallback to the default
   * model if model is undeployed.
   *
   * <p>This method is a [long-running
   * operation](https://cloud.google.com/dialogflow/es/docs/how/long-running-operations). The
   * returned `Operation` type has the following method-specific fields:
   *
   * <p>- `metadata`:
   * [UndeployConversationModelOperationMetadata][google.cloud.dialogflow.v2.UndeployConversationModelOperationMetadata]
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
   * try (ConversationModelsClient conversationModelsClient = ConversationModelsClient.create()) {
   *   UndeployConversationModelRequest request =
   *       UndeployConversationModelRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Operation> future =
   *       conversationModelsClient.undeployConversationModelCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UndeployConversationModelRequest, Operation>
      undeployConversationModelCallable() {
    return stub.undeployConversationModelCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an evaluation of conversation model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationModelsClient conversationModelsClient = ConversationModelsClient.create()) {
   *   String name = "name3373707";
   *   ConversationModelEvaluation response =
   *       conversationModelsClient.getConversationModelEvaluation(name);
   * }
   * }</pre>
   *
   * @param name Required. The conversation model evaluation resource name. Format:
   *     `projects/&lt;Project ID&gt;/conversationModels/&lt;Conversation Model
   *     ID&gt;/evaluations/&lt;Evaluation ID&gt;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ConversationModelEvaluation getConversationModelEvaluation(String name) {
    GetConversationModelEvaluationRequest request =
        GetConversationModelEvaluationRequest.newBuilder().setName(name).build();
    return getConversationModelEvaluation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an evaluation of conversation model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationModelsClient conversationModelsClient = ConversationModelsClient.create()) {
   *   GetConversationModelEvaluationRequest request =
   *       GetConversationModelEvaluationRequest.newBuilder().setName("name3373707").build();
   *   ConversationModelEvaluation response =
   *       conversationModelsClient.getConversationModelEvaluation(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ConversationModelEvaluation getConversationModelEvaluation(
      GetConversationModelEvaluationRequest request) {
    return getConversationModelEvaluationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an evaluation of conversation model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationModelsClient conversationModelsClient = ConversationModelsClient.create()) {
   *   GetConversationModelEvaluationRequest request =
   *       GetConversationModelEvaluationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<ConversationModelEvaluation> future =
   *       conversationModelsClient.getConversationModelEvaluationCallable().futureCall(request);
   *   // Do something.
   *   ConversationModelEvaluation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetConversationModelEvaluationRequest, ConversationModelEvaluation>
      getConversationModelEvaluationCallable() {
    return stub.getConversationModelEvaluationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists evaluations of a conversation model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationModelsClient conversationModelsClient = ConversationModelsClient.create()) {
   *   String parent = "parent-995424086";
   *   for (ConversationModelEvaluation element :
   *       conversationModelsClient.listConversationModelEvaluations(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The conversation model resource name. Format: `projects/&lt;Project
   *     ID&gt;/conversationModels/&lt;Conversation Model ID&gt;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListConversationModelEvaluationsPagedResponse listConversationModelEvaluations(
      String parent) {
    ListConversationModelEvaluationsRequest request =
        ListConversationModelEvaluationsRequest.newBuilder().setParent(parent).build();
    return listConversationModelEvaluations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists evaluations of a conversation model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationModelsClient conversationModelsClient = ConversationModelsClient.create()) {
   *   ListConversationModelEvaluationsRequest request =
   *       ListConversationModelEvaluationsRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (ConversationModelEvaluation element :
   *       conversationModelsClient.listConversationModelEvaluations(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListConversationModelEvaluationsPagedResponse listConversationModelEvaluations(
      ListConversationModelEvaluationsRequest request) {
    return listConversationModelEvaluationsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists evaluations of a conversation model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationModelsClient conversationModelsClient = ConversationModelsClient.create()) {
   *   ListConversationModelEvaluationsRequest request =
   *       ListConversationModelEvaluationsRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<ConversationModelEvaluation> future =
   *       conversationModelsClient
   *           .listConversationModelEvaluationsPagedCallable()
   *           .futureCall(request);
   *   // Do something.
   *   for (ConversationModelEvaluation element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListConversationModelEvaluationsRequest, ListConversationModelEvaluationsPagedResponse>
      listConversationModelEvaluationsPagedCallable() {
    return stub.listConversationModelEvaluationsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists evaluations of a conversation model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationModelsClient conversationModelsClient = ConversationModelsClient.create()) {
   *   ListConversationModelEvaluationsRequest request =
   *       ListConversationModelEvaluationsRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListConversationModelEvaluationsResponse response =
   *         conversationModelsClient.listConversationModelEvaluationsCallable().call(request);
   *     for (ConversationModelEvaluation element : response.getConversationModelEvaluationsList()) {
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
  public final UnaryCallable<
          ListConversationModelEvaluationsRequest, ListConversationModelEvaluationsResponse>
      listConversationModelEvaluationsCallable() {
    return stub.listConversationModelEvaluationsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates evaluation of a conversation model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationModelsClient conversationModelsClient = ConversationModelsClient.create()) {
   *   ConversationModelName parent =
   *       ConversationModelName.ofProjectLocationConversationModelName(
   *           "[PROJECT]", "[LOCATION]", "[CONVERSATION_MODEL]");
   *   ConversationModelEvaluation conversationModelEvaluation =
   *       ConversationModelEvaluation.newBuilder().build();
   *   ConversationModelEvaluation response =
   *       conversationModelsClient
   *           .createConversationModelEvaluationAsync(parent, conversationModelEvaluation)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The conversation model resource name. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/conversationModels/&lt;Conversation Model ID&gt;`
   * @param conversationModelEvaluation Required. The conversation model evaluation to be created.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<
          ConversationModelEvaluation, CreateConversationModelEvaluationOperationMetadata>
      createConversationModelEvaluationAsync(
          ConversationModelName parent, ConversationModelEvaluation conversationModelEvaluation) {
    CreateConversationModelEvaluationRequest request =
        CreateConversationModelEvaluationRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setConversationModelEvaluation(conversationModelEvaluation)
            .build();
    return createConversationModelEvaluationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates evaluation of a conversation model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationModelsClient conversationModelsClient = ConversationModelsClient.create()) {
   *   String parent =
   *       ConversationModelName.ofProjectLocationConversationModelName(
   *               "[PROJECT]", "[LOCATION]", "[CONVERSATION_MODEL]")
   *           .toString();
   *   ConversationModelEvaluation conversationModelEvaluation =
   *       ConversationModelEvaluation.newBuilder().build();
   *   ConversationModelEvaluation response =
   *       conversationModelsClient
   *           .createConversationModelEvaluationAsync(parent, conversationModelEvaluation)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The conversation model resource name. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/conversationModels/&lt;Conversation Model ID&gt;`
   * @param conversationModelEvaluation Required. The conversation model evaluation to be created.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<
          ConversationModelEvaluation, CreateConversationModelEvaluationOperationMetadata>
      createConversationModelEvaluationAsync(
          String parent, ConversationModelEvaluation conversationModelEvaluation) {
    CreateConversationModelEvaluationRequest request =
        CreateConversationModelEvaluationRequest.newBuilder()
            .setParent(parent)
            .setConversationModelEvaluation(conversationModelEvaluation)
            .build();
    return createConversationModelEvaluationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates evaluation of a conversation model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationModelsClient conversationModelsClient = ConversationModelsClient.create()) {
   *   CreateConversationModelEvaluationRequest request =
   *       CreateConversationModelEvaluationRequest.newBuilder()
   *           .setParent(
   *               ConversationModelName.ofProjectLocationConversationModelName(
   *                       "[PROJECT]", "[LOCATION]", "[CONVERSATION_MODEL]")
   *                   .toString())
   *           .setConversationModelEvaluation(ConversationModelEvaluation.newBuilder().build())
   *           .build();
   *   ConversationModelEvaluation response =
   *       conversationModelsClient.createConversationModelEvaluationAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<
          ConversationModelEvaluation, CreateConversationModelEvaluationOperationMetadata>
      createConversationModelEvaluationAsync(CreateConversationModelEvaluationRequest request) {
    return createConversationModelEvaluationOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates evaluation of a conversation model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationModelsClient conversationModelsClient = ConversationModelsClient.create()) {
   *   CreateConversationModelEvaluationRequest request =
   *       CreateConversationModelEvaluationRequest.newBuilder()
   *           .setParent(
   *               ConversationModelName.ofProjectLocationConversationModelName(
   *                       "[PROJECT]", "[LOCATION]", "[CONVERSATION_MODEL]")
   *                   .toString())
   *           .setConversationModelEvaluation(ConversationModelEvaluation.newBuilder().build())
   *           .build();
   *   OperationFuture<
   *           ConversationModelEvaluation, CreateConversationModelEvaluationOperationMetadata>
   *       future =
   *           conversationModelsClient
   *               .createConversationModelEvaluationOperationCallable()
   *               .futureCall(request);
   *   // Do something.
   *   ConversationModelEvaluation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          CreateConversationModelEvaluationRequest,
          ConversationModelEvaluation,
          CreateConversationModelEvaluationOperationMetadata>
      createConversationModelEvaluationOperationCallable() {
    return stub.createConversationModelEvaluationOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates evaluation of a conversation model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationModelsClient conversationModelsClient = ConversationModelsClient.create()) {
   *   CreateConversationModelEvaluationRequest request =
   *       CreateConversationModelEvaluationRequest.newBuilder()
   *           .setParent(
   *               ConversationModelName.ofProjectLocationConversationModelName(
   *                       "[PROJECT]", "[LOCATION]", "[CONVERSATION_MODEL]")
   *                   .toString())
   *           .setConversationModelEvaluation(ConversationModelEvaluation.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       conversationModelsClient.createConversationModelEvaluationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateConversationModelEvaluationRequest, Operation>
      createConversationModelEvaluationCallable() {
    return stub.createConversationModelEvaluationCallable();
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
   * try (ConversationModelsClient conversationModelsClient = ConversationModelsClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : conversationModelsClient.listLocations(request).iterateAll()) {
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
   * try (ConversationModelsClient conversationModelsClient = ConversationModelsClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       conversationModelsClient.listLocationsPagedCallable().futureCall(request);
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
   * try (ConversationModelsClient conversationModelsClient = ConversationModelsClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response =
   *         conversationModelsClient.listLocationsCallable().call(request);
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
   * try (ConversationModelsClient conversationModelsClient = ConversationModelsClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = conversationModelsClient.getLocation(request);
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
   * try (ConversationModelsClient conversationModelsClient = ConversationModelsClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future =
   *       conversationModelsClient.getLocationCallable().futureCall(request);
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

  public static class ListConversationModelsPagedResponse
      extends AbstractPagedListResponse<
          ListConversationModelsRequest,
          ListConversationModelsResponse,
          ConversationModel,
          ListConversationModelsPage,
          ListConversationModelsFixedSizeCollection> {

    public static ApiFuture<ListConversationModelsPagedResponse> createAsync(
        PageContext<
                ListConversationModelsRequest, ListConversationModelsResponse, ConversationModel>
            context,
        ApiFuture<ListConversationModelsResponse> futureResponse) {
      ApiFuture<ListConversationModelsPage> futurePage =
          ListConversationModelsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListConversationModelsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListConversationModelsPagedResponse(ListConversationModelsPage page) {
      super(page, ListConversationModelsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListConversationModelsPage
      extends AbstractPage<
          ListConversationModelsRequest,
          ListConversationModelsResponse,
          ConversationModel,
          ListConversationModelsPage> {

    private ListConversationModelsPage(
        PageContext<
                ListConversationModelsRequest, ListConversationModelsResponse, ConversationModel>
            context,
        ListConversationModelsResponse response) {
      super(context, response);
    }

    private static ListConversationModelsPage createEmptyPage() {
      return new ListConversationModelsPage(null, null);
    }

    @Override
    protected ListConversationModelsPage createPage(
        PageContext<
                ListConversationModelsRequest, ListConversationModelsResponse, ConversationModel>
            context,
        ListConversationModelsResponse response) {
      return new ListConversationModelsPage(context, response);
    }

    @Override
    public ApiFuture<ListConversationModelsPage> createPageAsync(
        PageContext<
                ListConversationModelsRequest, ListConversationModelsResponse, ConversationModel>
            context,
        ApiFuture<ListConversationModelsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListConversationModelsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListConversationModelsRequest,
          ListConversationModelsResponse,
          ConversationModel,
          ListConversationModelsPage,
          ListConversationModelsFixedSizeCollection> {

    private ListConversationModelsFixedSizeCollection(
        List<ListConversationModelsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListConversationModelsFixedSizeCollection createEmptyCollection() {
      return new ListConversationModelsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListConversationModelsFixedSizeCollection createCollection(
        List<ListConversationModelsPage> pages, int collectionSize) {
      return new ListConversationModelsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListConversationModelEvaluationsPagedResponse
      extends AbstractPagedListResponse<
          ListConversationModelEvaluationsRequest,
          ListConversationModelEvaluationsResponse,
          ConversationModelEvaluation,
          ListConversationModelEvaluationsPage,
          ListConversationModelEvaluationsFixedSizeCollection> {

    public static ApiFuture<ListConversationModelEvaluationsPagedResponse> createAsync(
        PageContext<
                ListConversationModelEvaluationsRequest,
                ListConversationModelEvaluationsResponse,
                ConversationModelEvaluation>
            context,
        ApiFuture<ListConversationModelEvaluationsResponse> futureResponse) {
      ApiFuture<ListConversationModelEvaluationsPage> futurePage =
          ListConversationModelEvaluationsPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListConversationModelEvaluationsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListConversationModelEvaluationsPagedResponse(
        ListConversationModelEvaluationsPage page) {
      super(page, ListConversationModelEvaluationsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListConversationModelEvaluationsPage
      extends AbstractPage<
          ListConversationModelEvaluationsRequest,
          ListConversationModelEvaluationsResponse,
          ConversationModelEvaluation,
          ListConversationModelEvaluationsPage> {

    private ListConversationModelEvaluationsPage(
        PageContext<
                ListConversationModelEvaluationsRequest,
                ListConversationModelEvaluationsResponse,
                ConversationModelEvaluation>
            context,
        ListConversationModelEvaluationsResponse response) {
      super(context, response);
    }

    private static ListConversationModelEvaluationsPage createEmptyPage() {
      return new ListConversationModelEvaluationsPage(null, null);
    }

    @Override
    protected ListConversationModelEvaluationsPage createPage(
        PageContext<
                ListConversationModelEvaluationsRequest,
                ListConversationModelEvaluationsResponse,
                ConversationModelEvaluation>
            context,
        ListConversationModelEvaluationsResponse response) {
      return new ListConversationModelEvaluationsPage(context, response);
    }

    @Override
    public ApiFuture<ListConversationModelEvaluationsPage> createPageAsync(
        PageContext<
                ListConversationModelEvaluationsRequest,
                ListConversationModelEvaluationsResponse,
                ConversationModelEvaluation>
            context,
        ApiFuture<ListConversationModelEvaluationsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListConversationModelEvaluationsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListConversationModelEvaluationsRequest,
          ListConversationModelEvaluationsResponse,
          ConversationModelEvaluation,
          ListConversationModelEvaluationsPage,
          ListConversationModelEvaluationsFixedSizeCollection> {

    private ListConversationModelEvaluationsFixedSizeCollection(
        List<ListConversationModelEvaluationsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListConversationModelEvaluationsFixedSizeCollection createEmptyCollection() {
      return new ListConversationModelEvaluationsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListConversationModelEvaluationsFixedSizeCollection createCollection(
        List<ListConversationModelEvaluationsPage> pages, int collectionSize) {
      return new ListConversationModelEvaluationsFixedSizeCollection(pages, collectionSize);
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
