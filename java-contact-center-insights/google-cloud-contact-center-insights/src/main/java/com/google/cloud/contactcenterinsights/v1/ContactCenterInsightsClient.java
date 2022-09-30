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

package com.google.cloud.contactcenterinsights.v1;

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
import com.google.cloud.contactcenterinsights.v1.stub.ContactCenterInsightsStub;
import com.google.cloud.contactcenterinsights.v1.stub.ContactCenterInsightsStubSettings;
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
 * Service Description: An API that lets users analyze and explore their business conversation data.
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
 * try (ContactCenterInsightsClient contactCenterInsightsClient =
 *     ContactCenterInsightsClient.create()) {
 *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
 *   Conversation conversation = Conversation.newBuilder().build();
 *   String conversationId = "conversationId-1676095234";
 *   Conversation response =
 *       contactCenterInsightsClient.createConversation(parent, conversation, conversationId);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the ContactCenterInsightsClient object to clean up
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
 * <p>This class can be customized by passing in a custom instance of ContactCenterInsightsSettings
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
 * ContactCenterInsightsSettings contactCenterInsightsSettings =
 *     ContactCenterInsightsSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ContactCenterInsightsClient contactCenterInsightsClient =
 *     ContactCenterInsightsClient.create(contactCenterInsightsSettings);
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
 * ContactCenterInsightsSettings contactCenterInsightsSettings =
 *     ContactCenterInsightsSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ContactCenterInsightsClient contactCenterInsightsClient =
 *     ContactCenterInsightsClient.create(contactCenterInsightsSettings);
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
 * ContactCenterInsightsSettings contactCenterInsightsSettings =
 *     ContactCenterInsightsSettings.newBuilder()
 *         .setTransportChannelProvider(
 *             ContactCenterInsightsSettings.defaultHttpJsonTransportProviderBuilder().build())
 *         .build();
 * ContactCenterInsightsClient contactCenterInsightsClient =
 *     ContactCenterInsightsClient.create(contactCenterInsightsSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class ContactCenterInsightsClient implements BackgroundResource {
  private final ContactCenterInsightsSettings settings;
  private final ContactCenterInsightsStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of ContactCenterInsightsClient with default settings. */
  public static final ContactCenterInsightsClient create() throws IOException {
    return create(ContactCenterInsightsSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ContactCenterInsightsClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ContactCenterInsightsClient create(ContactCenterInsightsSettings settings)
      throws IOException {
    return new ContactCenterInsightsClient(settings);
  }

  /**
   * Constructs an instance of ContactCenterInsightsClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(ContactCenterInsightsSettings).
   */
  public static final ContactCenterInsightsClient create(ContactCenterInsightsStub stub) {
    return new ContactCenterInsightsClient(stub);
  }

  /**
   * Constructs an instance of ContactCenterInsightsClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected ContactCenterInsightsClient(ContactCenterInsightsSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((ContactCenterInsightsStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected ContactCenterInsightsClient(ContactCenterInsightsStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final ContactCenterInsightsSettings getSettings() {
    return settings;
  }

  public ContactCenterInsightsStub getStub() {
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
   * Creates a conversation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Conversation conversation = Conversation.newBuilder().build();
   *   String conversationId = "conversationId-1676095234";
   *   Conversation response =
   *       contactCenterInsightsClient.createConversation(parent, conversation, conversationId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the conversation.
   * @param conversation Required. The conversation resource to create.
   * @param conversationId A unique ID for the new conversation. This ID will become the final
   *     component of the conversation's resource name. If no ID is specified, a server-generated ID
   *     will be used.
   *     <p>This value should be 4-64 characters and must match the regular expression
   *     `^[a-z0-9-]{4,64}$`. Valid characters are `[a-z][0-9]-`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Conversation createConversation(
      LocationName parent, Conversation conversation, String conversationId) {
    CreateConversationRequest request =
        CreateConversationRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setConversation(conversation)
            .setConversationId(conversationId)
            .build();
    return createConversation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a conversation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Conversation conversation = Conversation.newBuilder().build();
   *   String conversationId = "conversationId-1676095234";
   *   Conversation response =
   *       contactCenterInsightsClient.createConversation(parent, conversation, conversationId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the conversation.
   * @param conversation Required. The conversation resource to create.
   * @param conversationId A unique ID for the new conversation. This ID will become the final
   *     component of the conversation's resource name. If no ID is specified, a server-generated ID
   *     will be used.
   *     <p>This value should be 4-64 characters and must match the regular expression
   *     `^[a-z0-9-]{4,64}$`. Valid characters are `[a-z][0-9]-`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Conversation createConversation(
      String parent, Conversation conversation, String conversationId) {
    CreateConversationRequest request =
        CreateConversationRequest.newBuilder()
            .setParent(parent)
            .setConversation(conversation)
            .setConversationId(conversationId)
            .build();
    return createConversation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a conversation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   CreateConversationRequest request =
   *       CreateConversationRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setConversation(Conversation.newBuilder().build())
   *           .setConversationId("conversationId-1676095234")
   *           .build();
   *   Conversation response = contactCenterInsightsClient.createConversation(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Conversation createConversation(CreateConversationRequest request) {
    return createConversationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a conversation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   CreateConversationRequest request =
   *       CreateConversationRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setConversation(Conversation.newBuilder().build())
   *           .setConversationId("conversationId-1676095234")
   *           .build();
   *   ApiFuture<Conversation> future =
   *       contactCenterInsightsClient.createConversationCallable().futureCall(request);
   *   // Do something.
   *   Conversation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateConversationRequest, Conversation> createConversationCallable() {
    return stub.createConversationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a conversation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   Conversation conversation = Conversation.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Conversation response =
   *       contactCenterInsightsClient.updateConversation(conversation, updateMask);
   * }
   * }</pre>
   *
   * @param conversation Required. The new values for the conversation.
   * @param updateMask The list of fields to be updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Conversation updateConversation(Conversation conversation, FieldMask updateMask) {
    UpdateConversationRequest request =
        UpdateConversationRequest.newBuilder()
            .setConversation(conversation)
            .setUpdateMask(updateMask)
            .build();
    return updateConversation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a conversation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   UpdateConversationRequest request =
   *       UpdateConversationRequest.newBuilder()
   *           .setConversation(Conversation.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Conversation response = contactCenterInsightsClient.updateConversation(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Conversation updateConversation(UpdateConversationRequest request) {
    return updateConversationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a conversation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   UpdateConversationRequest request =
   *       UpdateConversationRequest.newBuilder()
   *           .setConversation(Conversation.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Conversation> future =
   *       contactCenterInsightsClient.updateConversationCallable().futureCall(request);
   *   // Do something.
   *   Conversation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateConversationRequest, Conversation> updateConversationCallable() {
    return stub.updateConversationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a conversation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   ConversationName name = ConversationName.of("[PROJECT]", "[LOCATION]", "[CONVERSATION]");
   *   Conversation response = contactCenterInsightsClient.getConversation(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the conversation to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Conversation getConversation(ConversationName name) {
    GetConversationRequest request =
        GetConversationRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getConversation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a conversation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   String name = ConversationName.of("[PROJECT]", "[LOCATION]", "[CONVERSATION]").toString();
   *   Conversation response = contactCenterInsightsClient.getConversation(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the conversation to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Conversation getConversation(String name) {
    GetConversationRequest request = GetConversationRequest.newBuilder().setName(name).build();
    return getConversation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a conversation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   GetConversationRequest request =
   *       GetConversationRequest.newBuilder()
   *           .setName(ConversationName.of("[PROJECT]", "[LOCATION]", "[CONVERSATION]").toString())
   *           .setView(ConversationView.forNumber(0))
   *           .build();
   *   Conversation response = contactCenterInsightsClient.getConversation(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Conversation getConversation(GetConversationRequest request) {
    return getConversationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a conversation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   GetConversationRequest request =
   *       GetConversationRequest.newBuilder()
   *           .setName(ConversationName.of("[PROJECT]", "[LOCATION]", "[CONVERSATION]").toString())
   *           .setView(ConversationView.forNumber(0))
   *           .build();
   *   ApiFuture<Conversation> future =
   *       contactCenterInsightsClient.getConversationCallable().futureCall(request);
   *   // Do something.
   *   Conversation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetConversationRequest, Conversation> getConversationCallable() {
    return stub.getConversationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists conversations.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Conversation element :
   *       contactCenterInsightsClient.listConversations(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the conversation.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListConversationsPagedResponse listConversations(LocationName parent) {
    ListConversationsRequest request =
        ListConversationsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listConversations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists conversations.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Conversation element :
   *       contactCenterInsightsClient.listConversations(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the conversation.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListConversationsPagedResponse listConversations(String parent) {
    ListConversationsRequest request =
        ListConversationsRequest.newBuilder().setParent(parent).build();
    return listConversations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists conversations.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   ListConversationsRequest request =
   *       ListConversationsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setView(ConversationView.forNumber(0))
   *           .build();
   *   for (Conversation element :
   *       contactCenterInsightsClient.listConversations(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListConversationsPagedResponse listConversations(ListConversationsRequest request) {
    return listConversationsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists conversations.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   ListConversationsRequest request =
   *       ListConversationsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setView(ConversationView.forNumber(0))
   *           .build();
   *   ApiFuture<Conversation> future =
   *       contactCenterInsightsClient.listConversationsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Conversation element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListConversationsRequest, ListConversationsPagedResponse>
      listConversationsPagedCallable() {
    return stub.listConversationsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists conversations.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   ListConversationsRequest request =
   *       ListConversationsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setView(ConversationView.forNumber(0))
   *           .build();
   *   while (true) {
   *     ListConversationsResponse response =
   *         contactCenterInsightsClient.listConversationsCallable().call(request);
   *     for (Conversation element : response.getConversationsList()) {
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
  public final UnaryCallable<ListConversationsRequest, ListConversationsResponse>
      listConversationsCallable() {
    return stub.listConversationsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a conversation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   ConversationName name = ConversationName.of("[PROJECT]", "[LOCATION]", "[CONVERSATION]");
   *   contactCenterInsightsClient.deleteConversation(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the conversation to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteConversation(ConversationName name) {
    DeleteConversationRequest request =
        DeleteConversationRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteConversation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a conversation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   String name = ConversationName.of("[PROJECT]", "[LOCATION]", "[CONVERSATION]").toString();
   *   contactCenterInsightsClient.deleteConversation(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the conversation to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteConversation(String name) {
    DeleteConversationRequest request =
        DeleteConversationRequest.newBuilder().setName(name).build();
    deleteConversation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a conversation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   DeleteConversationRequest request =
   *       DeleteConversationRequest.newBuilder()
   *           .setName(ConversationName.of("[PROJECT]", "[LOCATION]", "[CONVERSATION]").toString())
   *           .setForce(true)
   *           .build();
   *   contactCenterInsightsClient.deleteConversation(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteConversation(DeleteConversationRequest request) {
    deleteConversationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a conversation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   DeleteConversationRequest request =
   *       DeleteConversationRequest.newBuilder()
   *           .setName(ConversationName.of("[PROJECT]", "[LOCATION]", "[CONVERSATION]").toString())
   *           .setForce(true)
   *           .build();
   *   ApiFuture<Empty> future =
   *       contactCenterInsightsClient.deleteConversationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteConversationRequest, Empty> deleteConversationCallable() {
    return stub.deleteConversationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an analysis. The long running operation is done when the analysis has completed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   ConversationName parent = ConversationName.of("[PROJECT]", "[LOCATION]", "[CONVERSATION]");
   *   Analysis analysis = Analysis.newBuilder().build();
   *   Analysis response = contactCenterInsightsClient.createAnalysisAsync(parent, analysis).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the analysis.
   * @param analysis Required. The analysis to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Analysis, CreateAnalysisOperationMetadata> createAnalysisAsync(
      ConversationName parent, Analysis analysis) {
    CreateAnalysisRequest request =
        CreateAnalysisRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setAnalysis(analysis)
            .build();
    return createAnalysisAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an analysis. The long running operation is done when the analysis has completed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   String parent = ConversationName.of("[PROJECT]", "[LOCATION]", "[CONVERSATION]").toString();
   *   Analysis analysis = Analysis.newBuilder().build();
   *   Analysis response = contactCenterInsightsClient.createAnalysisAsync(parent, analysis).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the analysis.
   * @param analysis Required. The analysis to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Analysis, CreateAnalysisOperationMetadata> createAnalysisAsync(
      String parent, Analysis analysis) {
    CreateAnalysisRequest request =
        CreateAnalysisRequest.newBuilder().setParent(parent).setAnalysis(analysis).build();
    return createAnalysisAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an analysis. The long running operation is done when the analysis has completed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   CreateAnalysisRequest request =
   *       CreateAnalysisRequest.newBuilder()
   *           .setParent(
   *               ConversationName.of("[PROJECT]", "[LOCATION]", "[CONVERSATION]").toString())
   *           .setAnalysis(Analysis.newBuilder().build())
   *           .build();
   *   Analysis response = contactCenterInsightsClient.createAnalysisAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Analysis, CreateAnalysisOperationMetadata> createAnalysisAsync(
      CreateAnalysisRequest request) {
    return createAnalysisOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an analysis. The long running operation is done when the analysis has completed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   CreateAnalysisRequest request =
   *       CreateAnalysisRequest.newBuilder()
   *           .setParent(
   *               ConversationName.of("[PROJECT]", "[LOCATION]", "[CONVERSATION]").toString())
   *           .setAnalysis(Analysis.newBuilder().build())
   *           .build();
   *   OperationFuture<Analysis, CreateAnalysisOperationMetadata> future =
   *       contactCenterInsightsClient.createAnalysisOperationCallable().futureCall(request);
   *   // Do something.
   *   Analysis response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateAnalysisRequest, Analysis, CreateAnalysisOperationMetadata>
      createAnalysisOperationCallable() {
    return stub.createAnalysisOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an analysis. The long running operation is done when the analysis has completed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   CreateAnalysisRequest request =
   *       CreateAnalysisRequest.newBuilder()
   *           .setParent(
   *               ConversationName.of("[PROJECT]", "[LOCATION]", "[CONVERSATION]").toString())
   *           .setAnalysis(Analysis.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       contactCenterInsightsClient.createAnalysisCallable().futureCall(request);
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
   * Gets an analysis.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   AnalysisName name =
   *       AnalysisName.of("[PROJECT]", "[LOCATION]", "[CONVERSATION]", "[ANALYSIS]");
   *   Analysis response = contactCenterInsightsClient.getAnalysis(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the analysis to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Analysis getAnalysis(AnalysisName name) {
    GetAnalysisRequest request =
        GetAnalysisRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getAnalysis(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an analysis.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   String name =
   *       AnalysisName.of("[PROJECT]", "[LOCATION]", "[CONVERSATION]", "[ANALYSIS]").toString();
   *   Analysis response = contactCenterInsightsClient.getAnalysis(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the analysis to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Analysis getAnalysis(String name) {
    GetAnalysisRequest request = GetAnalysisRequest.newBuilder().setName(name).build();
    return getAnalysis(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an analysis.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   GetAnalysisRequest request =
   *       GetAnalysisRequest.newBuilder()
   *           .setName(
   *               AnalysisName.of("[PROJECT]", "[LOCATION]", "[CONVERSATION]", "[ANALYSIS]")
   *                   .toString())
   *           .build();
   *   Analysis response = contactCenterInsightsClient.getAnalysis(request);
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
   * Gets an analysis.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   GetAnalysisRequest request =
   *       GetAnalysisRequest.newBuilder()
   *           .setName(
   *               AnalysisName.of("[PROJECT]", "[LOCATION]", "[CONVERSATION]", "[ANALYSIS]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Analysis> future =
   *       contactCenterInsightsClient.getAnalysisCallable().futureCall(request);
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
   * Lists analyses.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   ConversationName parent = ConversationName.of("[PROJECT]", "[LOCATION]", "[CONVERSATION]");
   *   for (Analysis element : contactCenterInsightsClient.listAnalyses(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the analyses.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAnalysesPagedResponse listAnalyses(ConversationName parent) {
    ListAnalysesRequest request =
        ListAnalysesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listAnalyses(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists analyses.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   String parent = ConversationName.of("[PROJECT]", "[LOCATION]", "[CONVERSATION]").toString();
   *   for (Analysis element : contactCenterInsightsClient.listAnalyses(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the analyses.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAnalysesPagedResponse listAnalyses(String parent) {
    ListAnalysesRequest request = ListAnalysesRequest.newBuilder().setParent(parent).build();
    return listAnalyses(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists analyses.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   ListAnalysesRequest request =
   *       ListAnalysesRequest.newBuilder()
   *           .setParent(
   *               ConversationName.of("[PROJECT]", "[LOCATION]", "[CONVERSATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (Analysis element : contactCenterInsightsClient.listAnalyses(request).iterateAll()) {
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
   * Lists analyses.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   ListAnalysesRequest request =
   *       ListAnalysesRequest.newBuilder()
   *           .setParent(
   *               ConversationName.of("[PROJECT]", "[LOCATION]", "[CONVERSATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<Analysis> future =
   *       contactCenterInsightsClient.listAnalysesPagedCallable().futureCall(request);
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
   * Lists analyses.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   ListAnalysesRequest request =
   *       ListAnalysesRequest.newBuilder()
   *           .setParent(
   *               ConversationName.of("[PROJECT]", "[LOCATION]", "[CONVERSATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListAnalysesResponse response =
   *         contactCenterInsightsClient.listAnalysesCallable().call(request);
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
   * Deletes an analysis.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   AnalysisName name =
   *       AnalysisName.of("[PROJECT]", "[LOCATION]", "[CONVERSATION]", "[ANALYSIS]");
   *   contactCenterInsightsClient.deleteAnalysis(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the analysis to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteAnalysis(AnalysisName name) {
    DeleteAnalysisRequest request =
        DeleteAnalysisRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteAnalysis(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an analysis.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   String name =
   *       AnalysisName.of("[PROJECT]", "[LOCATION]", "[CONVERSATION]", "[ANALYSIS]").toString();
   *   contactCenterInsightsClient.deleteAnalysis(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the analysis to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteAnalysis(String name) {
    DeleteAnalysisRequest request = DeleteAnalysisRequest.newBuilder().setName(name).build();
    deleteAnalysis(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an analysis.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   DeleteAnalysisRequest request =
   *       DeleteAnalysisRequest.newBuilder()
   *           .setName(
   *               AnalysisName.of("[PROJECT]", "[LOCATION]", "[CONVERSATION]", "[ANALYSIS]")
   *                   .toString())
   *           .build();
   *   contactCenterInsightsClient.deleteAnalysis(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteAnalysis(DeleteAnalysisRequest request) {
    deleteAnalysisCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an analysis.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   DeleteAnalysisRequest request =
   *       DeleteAnalysisRequest.newBuilder()
   *           .setName(
   *               AnalysisName.of("[PROJECT]", "[LOCATION]", "[CONVERSATION]", "[ANALYSIS]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       contactCenterInsightsClient.deleteAnalysisCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteAnalysisRequest, Empty> deleteAnalysisCallable() {
    return stub.deleteAnalysisCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Export insights data to a destination defined in the request body.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   ExportInsightsDataResponse response =
   *       contactCenterInsightsClient.exportInsightsDataAsync(parent).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource to export data from.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ExportInsightsDataResponse, ExportInsightsDataMetadata>
      exportInsightsDataAsync(LocationName parent) {
    ExportInsightsDataRequest request =
        ExportInsightsDataRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return exportInsightsDataAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Export insights data to a destination defined in the request body.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   ExportInsightsDataResponse response =
   *       contactCenterInsightsClient.exportInsightsDataAsync(parent).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource to export data from.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ExportInsightsDataResponse, ExportInsightsDataMetadata>
      exportInsightsDataAsync(String parent) {
    ExportInsightsDataRequest request =
        ExportInsightsDataRequest.newBuilder().setParent(parent).build();
    return exportInsightsDataAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Export insights data to a destination defined in the request body.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   ExportInsightsDataRequest request =
   *       ExportInsightsDataRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setKmsKey("kmsKey-1127483058")
   *           .build();
   *   ExportInsightsDataResponse response =
   *       contactCenterInsightsClient.exportInsightsDataAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ExportInsightsDataResponse, ExportInsightsDataMetadata>
      exportInsightsDataAsync(ExportInsightsDataRequest request) {
    return exportInsightsDataOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Export insights data to a destination defined in the request body.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   ExportInsightsDataRequest request =
   *       ExportInsightsDataRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setKmsKey("kmsKey-1127483058")
   *           .build();
   *   OperationFuture<ExportInsightsDataResponse, ExportInsightsDataMetadata> future =
   *       contactCenterInsightsClient.exportInsightsDataOperationCallable().futureCall(request);
   *   // Do something.
   *   ExportInsightsDataResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          ExportInsightsDataRequest, ExportInsightsDataResponse, ExportInsightsDataMetadata>
      exportInsightsDataOperationCallable() {
    return stub.exportInsightsDataOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Export insights data to a destination defined in the request body.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   ExportInsightsDataRequest request =
   *       ExportInsightsDataRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setKmsKey("kmsKey-1127483058")
   *           .build();
   *   ApiFuture<Operation> future =
   *       contactCenterInsightsClient.exportInsightsDataCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ExportInsightsDataRequest, Operation> exportInsightsDataCallable() {
    return stub.exportInsightsDataCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an issue model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   IssueModel issueModel = IssueModel.newBuilder().build();
   *   IssueModel response =
   *       contactCenterInsightsClient.createIssueModelAsync(parent, issueModel).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the issue model.
   * @param issueModel Required. The issue model to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<IssueModel, CreateIssueModelMetadata> createIssueModelAsync(
      LocationName parent, IssueModel issueModel) {
    CreateIssueModelRequest request =
        CreateIssueModelRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setIssueModel(issueModel)
            .build();
    return createIssueModelAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an issue model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   IssueModel issueModel = IssueModel.newBuilder().build();
   *   IssueModel response =
   *       contactCenterInsightsClient.createIssueModelAsync(parent, issueModel).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the issue model.
   * @param issueModel Required. The issue model to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<IssueModel, CreateIssueModelMetadata> createIssueModelAsync(
      String parent, IssueModel issueModel) {
    CreateIssueModelRequest request =
        CreateIssueModelRequest.newBuilder().setParent(parent).setIssueModel(issueModel).build();
    return createIssueModelAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an issue model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   CreateIssueModelRequest request =
   *       CreateIssueModelRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setIssueModel(IssueModel.newBuilder().build())
   *           .build();
   *   IssueModel response = contactCenterInsightsClient.createIssueModelAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<IssueModel, CreateIssueModelMetadata> createIssueModelAsync(
      CreateIssueModelRequest request) {
    return createIssueModelOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an issue model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   CreateIssueModelRequest request =
   *       CreateIssueModelRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setIssueModel(IssueModel.newBuilder().build())
   *           .build();
   *   OperationFuture<IssueModel, CreateIssueModelMetadata> future =
   *       contactCenterInsightsClient.createIssueModelOperationCallable().futureCall(request);
   *   // Do something.
   *   IssueModel response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateIssueModelRequest, IssueModel, CreateIssueModelMetadata>
      createIssueModelOperationCallable() {
    return stub.createIssueModelOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an issue model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   CreateIssueModelRequest request =
   *       CreateIssueModelRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setIssueModel(IssueModel.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       contactCenterInsightsClient.createIssueModelCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateIssueModelRequest, Operation> createIssueModelCallable() {
    return stub.createIssueModelCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an issue model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   IssueModel issueModel = IssueModel.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   IssueModel response = contactCenterInsightsClient.updateIssueModel(issueModel, updateMask);
   * }
   * }</pre>
   *
   * @param issueModel Required. The new values for the issue model.
   * @param updateMask The list of fields to be updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final IssueModel updateIssueModel(IssueModel issueModel, FieldMask updateMask) {
    UpdateIssueModelRequest request =
        UpdateIssueModelRequest.newBuilder()
            .setIssueModel(issueModel)
            .setUpdateMask(updateMask)
            .build();
    return updateIssueModel(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an issue model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   UpdateIssueModelRequest request =
   *       UpdateIssueModelRequest.newBuilder()
   *           .setIssueModel(IssueModel.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   IssueModel response = contactCenterInsightsClient.updateIssueModel(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final IssueModel updateIssueModel(UpdateIssueModelRequest request) {
    return updateIssueModelCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an issue model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   UpdateIssueModelRequest request =
   *       UpdateIssueModelRequest.newBuilder()
   *           .setIssueModel(IssueModel.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<IssueModel> future =
   *       contactCenterInsightsClient.updateIssueModelCallable().futureCall(request);
   *   // Do something.
   *   IssueModel response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateIssueModelRequest, IssueModel> updateIssueModelCallable() {
    return stub.updateIssueModelCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an issue model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   IssueModelName name = IssueModelName.of("[PROJECT]", "[LOCATION]", "[ISSUE_MODEL]");
   *   IssueModel response = contactCenterInsightsClient.getIssueModel(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the issue model to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final IssueModel getIssueModel(IssueModelName name) {
    GetIssueModelRequest request =
        GetIssueModelRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getIssueModel(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an issue model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   String name = IssueModelName.of("[PROJECT]", "[LOCATION]", "[ISSUE_MODEL]").toString();
   *   IssueModel response = contactCenterInsightsClient.getIssueModel(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the issue model to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final IssueModel getIssueModel(String name) {
    GetIssueModelRequest request = GetIssueModelRequest.newBuilder().setName(name).build();
    return getIssueModel(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an issue model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   GetIssueModelRequest request =
   *       GetIssueModelRequest.newBuilder()
   *           .setName(IssueModelName.of("[PROJECT]", "[LOCATION]", "[ISSUE_MODEL]").toString())
   *           .build();
   *   IssueModel response = contactCenterInsightsClient.getIssueModel(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final IssueModel getIssueModel(GetIssueModelRequest request) {
    return getIssueModelCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an issue model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   GetIssueModelRequest request =
   *       GetIssueModelRequest.newBuilder()
   *           .setName(IssueModelName.of("[PROJECT]", "[LOCATION]", "[ISSUE_MODEL]").toString())
   *           .build();
   *   ApiFuture<IssueModel> future =
   *       contactCenterInsightsClient.getIssueModelCallable().futureCall(request);
   *   // Do something.
   *   IssueModel response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetIssueModelRequest, IssueModel> getIssueModelCallable() {
    return stub.getIssueModelCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists issue models.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   ListIssueModelsResponse response = contactCenterInsightsClient.listIssueModels(parent);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the issue model.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListIssueModelsResponse listIssueModels(LocationName parent) {
    ListIssueModelsRequest request =
        ListIssueModelsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listIssueModels(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists issue models.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   ListIssueModelsResponse response = contactCenterInsightsClient.listIssueModels(parent);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the issue model.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListIssueModelsResponse listIssueModels(String parent) {
    ListIssueModelsRequest request = ListIssueModelsRequest.newBuilder().setParent(parent).build();
    return listIssueModels(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists issue models.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   ListIssueModelsRequest request =
   *       ListIssueModelsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .build();
   *   ListIssueModelsResponse response = contactCenterInsightsClient.listIssueModels(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListIssueModelsResponse listIssueModels(ListIssueModelsRequest request) {
    return listIssueModelsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists issue models.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   ListIssueModelsRequest request =
   *       ListIssueModelsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .build();
   *   ApiFuture<ListIssueModelsResponse> future =
   *       contactCenterInsightsClient.listIssueModelsCallable().futureCall(request);
   *   // Do something.
   *   ListIssueModelsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ListIssueModelsRequest, ListIssueModelsResponse>
      listIssueModelsCallable() {
    return stub.listIssueModelsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an issue model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   IssueModelName name = IssueModelName.of("[PROJECT]", "[LOCATION]", "[ISSUE_MODEL]");
   *   contactCenterInsightsClient.deleteIssueModelAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the issue model to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteIssueModelMetadata> deleteIssueModelAsync(
      IssueModelName name) {
    DeleteIssueModelRequest request =
        DeleteIssueModelRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteIssueModelAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an issue model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   String name = IssueModelName.of("[PROJECT]", "[LOCATION]", "[ISSUE_MODEL]").toString();
   *   contactCenterInsightsClient.deleteIssueModelAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the issue model to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteIssueModelMetadata> deleteIssueModelAsync(String name) {
    DeleteIssueModelRequest request = DeleteIssueModelRequest.newBuilder().setName(name).build();
    return deleteIssueModelAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an issue model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   DeleteIssueModelRequest request =
   *       DeleteIssueModelRequest.newBuilder()
   *           .setName(IssueModelName.of("[PROJECT]", "[LOCATION]", "[ISSUE_MODEL]").toString())
   *           .build();
   *   contactCenterInsightsClient.deleteIssueModelAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteIssueModelMetadata> deleteIssueModelAsync(
      DeleteIssueModelRequest request) {
    return deleteIssueModelOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an issue model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   DeleteIssueModelRequest request =
   *       DeleteIssueModelRequest.newBuilder()
   *           .setName(IssueModelName.of("[PROJECT]", "[LOCATION]", "[ISSUE_MODEL]").toString())
   *           .build();
   *   OperationFuture<Empty, DeleteIssueModelMetadata> future =
   *       contactCenterInsightsClient.deleteIssueModelOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteIssueModelRequest, Empty, DeleteIssueModelMetadata>
      deleteIssueModelOperationCallable() {
    return stub.deleteIssueModelOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an issue model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   DeleteIssueModelRequest request =
   *       DeleteIssueModelRequest.newBuilder()
   *           .setName(IssueModelName.of("[PROJECT]", "[LOCATION]", "[ISSUE_MODEL]").toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       contactCenterInsightsClient.deleteIssueModelCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteIssueModelRequest, Operation> deleteIssueModelCallable() {
    return stub.deleteIssueModelCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deploys an issue model. Returns an error if a model is already deployed. An issue model can
   * only be used in analysis after it has been deployed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   IssueModelName name = IssueModelName.of("[PROJECT]", "[LOCATION]", "[ISSUE_MODEL]");
   *   DeployIssueModelResponse response =
   *       contactCenterInsightsClient.deployIssueModelAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The issue model to deploy.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DeployIssueModelResponse, DeployIssueModelMetadata>
      deployIssueModelAsync(IssueModelName name) {
    DeployIssueModelRequest request =
        DeployIssueModelRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deployIssueModelAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deploys an issue model. Returns an error if a model is already deployed. An issue model can
   * only be used in analysis after it has been deployed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   String name = IssueModelName.of("[PROJECT]", "[LOCATION]", "[ISSUE_MODEL]").toString();
   *   DeployIssueModelResponse response =
   *       contactCenterInsightsClient.deployIssueModelAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The issue model to deploy.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DeployIssueModelResponse, DeployIssueModelMetadata>
      deployIssueModelAsync(String name) {
    DeployIssueModelRequest request = DeployIssueModelRequest.newBuilder().setName(name).build();
    return deployIssueModelAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deploys an issue model. Returns an error if a model is already deployed. An issue model can
   * only be used in analysis after it has been deployed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   DeployIssueModelRequest request =
   *       DeployIssueModelRequest.newBuilder()
   *           .setName(IssueModelName.of("[PROJECT]", "[LOCATION]", "[ISSUE_MODEL]").toString())
   *           .build();
   *   DeployIssueModelResponse response =
   *       contactCenterInsightsClient.deployIssueModelAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DeployIssueModelResponse, DeployIssueModelMetadata>
      deployIssueModelAsync(DeployIssueModelRequest request) {
    return deployIssueModelOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deploys an issue model. Returns an error if a model is already deployed. An issue model can
   * only be used in analysis after it has been deployed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   DeployIssueModelRequest request =
   *       DeployIssueModelRequest.newBuilder()
   *           .setName(IssueModelName.of("[PROJECT]", "[LOCATION]", "[ISSUE_MODEL]").toString())
   *           .build();
   *   OperationFuture<DeployIssueModelResponse, DeployIssueModelMetadata> future =
   *       contactCenterInsightsClient.deployIssueModelOperationCallable().futureCall(request);
   *   // Do something.
   *   DeployIssueModelResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          DeployIssueModelRequest, DeployIssueModelResponse, DeployIssueModelMetadata>
      deployIssueModelOperationCallable() {
    return stub.deployIssueModelOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deploys an issue model. Returns an error if a model is already deployed. An issue model can
   * only be used in analysis after it has been deployed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   DeployIssueModelRequest request =
   *       DeployIssueModelRequest.newBuilder()
   *           .setName(IssueModelName.of("[PROJECT]", "[LOCATION]", "[ISSUE_MODEL]").toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       contactCenterInsightsClient.deployIssueModelCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeployIssueModelRequest, Operation> deployIssueModelCallable() {
    return stub.deployIssueModelCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Undeploys an issue model. An issue model can not be used in analysis after it has been
   * undeployed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   IssueModelName name = IssueModelName.of("[PROJECT]", "[LOCATION]", "[ISSUE_MODEL]");
   *   UndeployIssueModelResponse response =
   *       contactCenterInsightsClient.undeployIssueModelAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The issue model to undeploy.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<UndeployIssueModelResponse, UndeployIssueModelMetadata>
      undeployIssueModelAsync(IssueModelName name) {
    UndeployIssueModelRequest request =
        UndeployIssueModelRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return undeployIssueModelAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Undeploys an issue model. An issue model can not be used in analysis after it has been
   * undeployed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   String name = IssueModelName.of("[PROJECT]", "[LOCATION]", "[ISSUE_MODEL]").toString();
   *   UndeployIssueModelResponse response =
   *       contactCenterInsightsClient.undeployIssueModelAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The issue model to undeploy.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<UndeployIssueModelResponse, UndeployIssueModelMetadata>
      undeployIssueModelAsync(String name) {
    UndeployIssueModelRequest request =
        UndeployIssueModelRequest.newBuilder().setName(name).build();
    return undeployIssueModelAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Undeploys an issue model. An issue model can not be used in analysis after it has been
   * undeployed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   UndeployIssueModelRequest request =
   *       UndeployIssueModelRequest.newBuilder()
   *           .setName(IssueModelName.of("[PROJECT]", "[LOCATION]", "[ISSUE_MODEL]").toString())
   *           .build();
   *   UndeployIssueModelResponse response =
   *       contactCenterInsightsClient.undeployIssueModelAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<UndeployIssueModelResponse, UndeployIssueModelMetadata>
      undeployIssueModelAsync(UndeployIssueModelRequest request) {
    return undeployIssueModelOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Undeploys an issue model. An issue model can not be used in analysis after it has been
   * undeployed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   UndeployIssueModelRequest request =
   *       UndeployIssueModelRequest.newBuilder()
   *           .setName(IssueModelName.of("[PROJECT]", "[LOCATION]", "[ISSUE_MODEL]").toString())
   *           .build();
   *   OperationFuture<UndeployIssueModelResponse, UndeployIssueModelMetadata> future =
   *       contactCenterInsightsClient.undeployIssueModelOperationCallable().futureCall(request);
   *   // Do something.
   *   UndeployIssueModelResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          UndeployIssueModelRequest, UndeployIssueModelResponse, UndeployIssueModelMetadata>
      undeployIssueModelOperationCallable() {
    return stub.undeployIssueModelOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Undeploys an issue model. An issue model can not be used in analysis after it has been
   * undeployed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   UndeployIssueModelRequest request =
   *       UndeployIssueModelRequest.newBuilder()
   *           .setName(IssueModelName.of("[PROJECT]", "[LOCATION]", "[ISSUE_MODEL]").toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       contactCenterInsightsClient.undeployIssueModelCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UndeployIssueModelRequest, Operation> undeployIssueModelCallable() {
    return stub.undeployIssueModelCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an issue.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   IssueName name = IssueName.of("[PROJECT]", "[LOCATION]", "[ISSUE_MODEL]", "[ISSUE]");
   *   Issue response = contactCenterInsightsClient.getIssue(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the issue to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Issue getIssue(IssueName name) {
    GetIssueRequest request =
        GetIssueRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getIssue(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an issue.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   String name = IssueName.of("[PROJECT]", "[LOCATION]", "[ISSUE_MODEL]", "[ISSUE]").toString();
   *   Issue response = contactCenterInsightsClient.getIssue(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the issue to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Issue getIssue(String name) {
    GetIssueRequest request = GetIssueRequest.newBuilder().setName(name).build();
    return getIssue(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an issue.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   GetIssueRequest request =
   *       GetIssueRequest.newBuilder()
   *           .setName(
   *               IssueName.of("[PROJECT]", "[LOCATION]", "[ISSUE_MODEL]", "[ISSUE]").toString())
   *           .build();
   *   Issue response = contactCenterInsightsClient.getIssue(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Issue getIssue(GetIssueRequest request) {
    return getIssueCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an issue.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   GetIssueRequest request =
   *       GetIssueRequest.newBuilder()
   *           .setName(
   *               IssueName.of("[PROJECT]", "[LOCATION]", "[ISSUE_MODEL]", "[ISSUE]").toString())
   *           .build();
   *   ApiFuture<Issue> future = contactCenterInsightsClient.getIssueCallable().futureCall(request);
   *   // Do something.
   *   Issue response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetIssueRequest, Issue> getIssueCallable() {
    return stub.getIssueCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists issues.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   IssueModelName parent = IssueModelName.of("[PROJECT]", "[LOCATION]", "[ISSUE_MODEL]");
   *   ListIssuesResponse response = contactCenterInsightsClient.listIssues(parent);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the issue.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListIssuesResponse listIssues(IssueModelName parent) {
    ListIssuesRequest request =
        ListIssuesRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listIssues(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists issues.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   String parent = IssueModelName.of("[PROJECT]", "[LOCATION]", "[ISSUE_MODEL]").toString();
   *   ListIssuesResponse response = contactCenterInsightsClient.listIssues(parent);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the issue.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListIssuesResponse listIssues(String parent) {
    ListIssuesRequest request = ListIssuesRequest.newBuilder().setParent(parent).build();
    return listIssues(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists issues.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   ListIssuesRequest request =
   *       ListIssuesRequest.newBuilder()
   *           .setParent(IssueModelName.of("[PROJECT]", "[LOCATION]", "[ISSUE_MODEL]").toString())
   *           .build();
   *   ListIssuesResponse response = contactCenterInsightsClient.listIssues(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListIssuesResponse listIssues(ListIssuesRequest request) {
    return listIssuesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists issues.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   ListIssuesRequest request =
   *       ListIssuesRequest.newBuilder()
   *           .setParent(IssueModelName.of("[PROJECT]", "[LOCATION]", "[ISSUE_MODEL]").toString())
   *           .build();
   *   ApiFuture<ListIssuesResponse> future =
   *       contactCenterInsightsClient.listIssuesCallable().futureCall(request);
   *   // Do something.
   *   ListIssuesResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ListIssuesRequest, ListIssuesResponse> listIssuesCallable() {
    return stub.listIssuesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an issue.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   Issue issue = Issue.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Issue response = contactCenterInsightsClient.updateIssue(issue, updateMask);
   * }
   * }</pre>
   *
   * @param issue Required. The new values for the issue.
   * @param updateMask The list of fields to be updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Issue updateIssue(Issue issue, FieldMask updateMask) {
    UpdateIssueRequest request =
        UpdateIssueRequest.newBuilder().setIssue(issue).setUpdateMask(updateMask).build();
    return updateIssue(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an issue.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   UpdateIssueRequest request =
   *       UpdateIssueRequest.newBuilder()
   *           .setIssue(Issue.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Issue response = contactCenterInsightsClient.updateIssue(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Issue updateIssue(UpdateIssueRequest request) {
    return updateIssueCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an issue.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   UpdateIssueRequest request =
   *       UpdateIssueRequest.newBuilder()
   *           .setIssue(Issue.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Issue> future =
   *       contactCenterInsightsClient.updateIssueCallable().futureCall(request);
   *   // Do something.
   *   Issue response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateIssueRequest, Issue> updateIssueCallable() {
    return stub.updateIssueCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an issue model's statistics.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   IssueModelName issueModel = IssueModelName.of("[PROJECT]", "[LOCATION]", "[ISSUE_MODEL]");
   *   CalculateIssueModelStatsResponse response =
   *       contactCenterInsightsClient.calculateIssueModelStats(issueModel);
   * }
   * }</pre>
   *
   * @param issueModel Required. The resource name of the issue model to query against.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CalculateIssueModelStatsResponse calculateIssueModelStats(
      IssueModelName issueModel) {
    CalculateIssueModelStatsRequest request =
        CalculateIssueModelStatsRequest.newBuilder()
            .setIssueModel(issueModel == null ? null : issueModel.toString())
            .build();
    return calculateIssueModelStats(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an issue model's statistics.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   String issueModel = IssueModelName.of("[PROJECT]", "[LOCATION]", "[ISSUE_MODEL]").toString();
   *   CalculateIssueModelStatsResponse response =
   *       contactCenterInsightsClient.calculateIssueModelStats(issueModel);
   * }
   * }</pre>
   *
   * @param issueModel Required. The resource name of the issue model to query against.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CalculateIssueModelStatsResponse calculateIssueModelStats(String issueModel) {
    CalculateIssueModelStatsRequest request =
        CalculateIssueModelStatsRequest.newBuilder().setIssueModel(issueModel).build();
    return calculateIssueModelStats(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an issue model's statistics.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   CalculateIssueModelStatsRequest request =
   *       CalculateIssueModelStatsRequest.newBuilder()
   *           .setIssueModel(
   *               IssueModelName.of("[PROJECT]", "[LOCATION]", "[ISSUE_MODEL]").toString())
   *           .build();
   *   CalculateIssueModelStatsResponse response =
   *       contactCenterInsightsClient.calculateIssueModelStats(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CalculateIssueModelStatsResponse calculateIssueModelStats(
      CalculateIssueModelStatsRequest request) {
    return calculateIssueModelStatsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an issue model's statistics.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   CalculateIssueModelStatsRequest request =
   *       CalculateIssueModelStatsRequest.newBuilder()
   *           .setIssueModel(
   *               IssueModelName.of("[PROJECT]", "[LOCATION]", "[ISSUE_MODEL]").toString())
   *           .build();
   *   ApiFuture<CalculateIssueModelStatsResponse> future =
   *       contactCenterInsightsClient.calculateIssueModelStatsCallable().futureCall(request);
   *   // Do something.
   *   CalculateIssueModelStatsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CalculateIssueModelStatsRequest, CalculateIssueModelStatsResponse>
      calculateIssueModelStatsCallable() {
    return stub.calculateIssueModelStatsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a phrase matcher.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   PhraseMatcher phraseMatcher = PhraseMatcher.newBuilder().build();
   *   PhraseMatcher response =
   *       contactCenterInsightsClient.createPhraseMatcher(parent, phraseMatcher);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the phrase matcher. Required. The location to
   *     create a phrase matcher for. Format: `projects/&lt;Project ID&gt;/locations/&lt;Location
   *     ID&gt;` or `projects/&lt;Project Number&gt;/locations/&lt;Location ID&gt;`
   * @param phraseMatcher Required. The phrase matcher resource to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PhraseMatcher createPhraseMatcher(LocationName parent, PhraseMatcher phraseMatcher) {
    CreatePhraseMatcherRequest request =
        CreatePhraseMatcherRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setPhraseMatcher(phraseMatcher)
            .build();
    return createPhraseMatcher(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a phrase matcher.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   PhraseMatcher phraseMatcher = PhraseMatcher.newBuilder().build();
   *   PhraseMatcher response =
   *       contactCenterInsightsClient.createPhraseMatcher(parent, phraseMatcher);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the phrase matcher. Required. The location to
   *     create a phrase matcher for. Format: `projects/&lt;Project ID&gt;/locations/&lt;Location
   *     ID&gt;` or `projects/&lt;Project Number&gt;/locations/&lt;Location ID&gt;`
   * @param phraseMatcher Required. The phrase matcher resource to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PhraseMatcher createPhraseMatcher(String parent, PhraseMatcher phraseMatcher) {
    CreatePhraseMatcherRequest request =
        CreatePhraseMatcherRequest.newBuilder()
            .setParent(parent)
            .setPhraseMatcher(phraseMatcher)
            .build();
    return createPhraseMatcher(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a phrase matcher.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   CreatePhraseMatcherRequest request =
   *       CreatePhraseMatcherRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPhraseMatcher(PhraseMatcher.newBuilder().build())
   *           .build();
   *   PhraseMatcher response = contactCenterInsightsClient.createPhraseMatcher(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PhraseMatcher createPhraseMatcher(CreatePhraseMatcherRequest request) {
    return createPhraseMatcherCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a phrase matcher.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   CreatePhraseMatcherRequest request =
   *       CreatePhraseMatcherRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPhraseMatcher(PhraseMatcher.newBuilder().build())
   *           .build();
   *   ApiFuture<PhraseMatcher> future =
   *       contactCenterInsightsClient.createPhraseMatcherCallable().futureCall(request);
   *   // Do something.
   *   PhraseMatcher response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreatePhraseMatcherRequest, PhraseMatcher>
      createPhraseMatcherCallable() {
    return stub.createPhraseMatcherCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a phrase matcher.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   PhraseMatcherName name = PhraseMatcherName.of("[PROJECT]", "[LOCATION]", "[PHRASE_MATCHER]");
   *   PhraseMatcher response = contactCenterInsightsClient.getPhraseMatcher(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the phrase matcher to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PhraseMatcher getPhraseMatcher(PhraseMatcherName name) {
    GetPhraseMatcherRequest request =
        GetPhraseMatcherRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getPhraseMatcher(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a phrase matcher.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   String name = PhraseMatcherName.of("[PROJECT]", "[LOCATION]", "[PHRASE_MATCHER]").toString();
   *   PhraseMatcher response = contactCenterInsightsClient.getPhraseMatcher(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the phrase matcher to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PhraseMatcher getPhraseMatcher(String name) {
    GetPhraseMatcherRequest request = GetPhraseMatcherRequest.newBuilder().setName(name).build();
    return getPhraseMatcher(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a phrase matcher.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   GetPhraseMatcherRequest request =
   *       GetPhraseMatcherRequest.newBuilder()
   *           .setName(
   *               PhraseMatcherName.of("[PROJECT]", "[LOCATION]", "[PHRASE_MATCHER]").toString())
   *           .build();
   *   PhraseMatcher response = contactCenterInsightsClient.getPhraseMatcher(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PhraseMatcher getPhraseMatcher(GetPhraseMatcherRequest request) {
    return getPhraseMatcherCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a phrase matcher.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   GetPhraseMatcherRequest request =
   *       GetPhraseMatcherRequest.newBuilder()
   *           .setName(
   *               PhraseMatcherName.of("[PROJECT]", "[LOCATION]", "[PHRASE_MATCHER]").toString())
   *           .build();
   *   ApiFuture<PhraseMatcher> future =
   *       contactCenterInsightsClient.getPhraseMatcherCallable().futureCall(request);
   *   // Do something.
   *   PhraseMatcher response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetPhraseMatcherRequest, PhraseMatcher> getPhraseMatcherCallable() {
    return stub.getPhraseMatcherCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists phrase matchers.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (PhraseMatcher element :
   *       contactCenterInsightsClient.listPhraseMatchers(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the phrase matcher.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPhraseMatchersPagedResponse listPhraseMatchers(LocationName parent) {
    ListPhraseMatchersRequest request =
        ListPhraseMatchersRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listPhraseMatchers(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists phrase matchers.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (PhraseMatcher element :
   *       contactCenterInsightsClient.listPhraseMatchers(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the phrase matcher.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPhraseMatchersPagedResponse listPhraseMatchers(String parent) {
    ListPhraseMatchersRequest request =
        ListPhraseMatchersRequest.newBuilder().setParent(parent).build();
    return listPhraseMatchers(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists phrase matchers.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   ListPhraseMatchersRequest request =
   *       ListPhraseMatchersRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (PhraseMatcher element :
   *       contactCenterInsightsClient.listPhraseMatchers(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPhraseMatchersPagedResponse listPhraseMatchers(
      ListPhraseMatchersRequest request) {
    return listPhraseMatchersPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists phrase matchers.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   ListPhraseMatchersRequest request =
   *       ListPhraseMatchersRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<PhraseMatcher> future =
   *       contactCenterInsightsClient.listPhraseMatchersPagedCallable().futureCall(request);
   *   // Do something.
   *   for (PhraseMatcher element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListPhraseMatchersRequest, ListPhraseMatchersPagedResponse>
      listPhraseMatchersPagedCallable() {
    return stub.listPhraseMatchersPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists phrase matchers.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   ListPhraseMatchersRequest request =
   *       ListPhraseMatchersRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListPhraseMatchersResponse response =
   *         contactCenterInsightsClient.listPhraseMatchersCallable().call(request);
   *     for (PhraseMatcher element : response.getPhraseMatchersList()) {
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
  public final UnaryCallable<ListPhraseMatchersRequest, ListPhraseMatchersResponse>
      listPhraseMatchersCallable() {
    return stub.listPhraseMatchersCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a phrase matcher.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   PhraseMatcherName name = PhraseMatcherName.of("[PROJECT]", "[LOCATION]", "[PHRASE_MATCHER]");
   *   contactCenterInsightsClient.deletePhraseMatcher(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the phrase matcher to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deletePhraseMatcher(PhraseMatcherName name) {
    DeletePhraseMatcherRequest request =
        DeletePhraseMatcherRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deletePhraseMatcher(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a phrase matcher.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   String name = PhraseMatcherName.of("[PROJECT]", "[LOCATION]", "[PHRASE_MATCHER]").toString();
   *   contactCenterInsightsClient.deletePhraseMatcher(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the phrase matcher to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deletePhraseMatcher(String name) {
    DeletePhraseMatcherRequest request =
        DeletePhraseMatcherRequest.newBuilder().setName(name).build();
    deletePhraseMatcher(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a phrase matcher.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   DeletePhraseMatcherRequest request =
   *       DeletePhraseMatcherRequest.newBuilder()
   *           .setName(
   *               PhraseMatcherName.of("[PROJECT]", "[LOCATION]", "[PHRASE_MATCHER]").toString())
   *           .build();
   *   contactCenterInsightsClient.deletePhraseMatcher(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deletePhraseMatcher(DeletePhraseMatcherRequest request) {
    deletePhraseMatcherCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a phrase matcher.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   DeletePhraseMatcherRequest request =
   *       DeletePhraseMatcherRequest.newBuilder()
   *           .setName(
   *               PhraseMatcherName.of("[PROJECT]", "[LOCATION]", "[PHRASE_MATCHER]").toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       contactCenterInsightsClient.deletePhraseMatcherCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeletePhraseMatcherRequest, Empty> deletePhraseMatcherCallable() {
    return stub.deletePhraseMatcherCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a phrase matcher.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   PhraseMatcher phraseMatcher = PhraseMatcher.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   PhraseMatcher response =
   *       contactCenterInsightsClient.updatePhraseMatcher(phraseMatcher, updateMask);
   * }
   * }</pre>
   *
   * @param phraseMatcher Required. The new values for the phrase matcher.
   * @param updateMask The list of fields to be updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PhraseMatcher updatePhraseMatcher(
      PhraseMatcher phraseMatcher, FieldMask updateMask) {
    UpdatePhraseMatcherRequest request =
        UpdatePhraseMatcherRequest.newBuilder()
            .setPhraseMatcher(phraseMatcher)
            .setUpdateMask(updateMask)
            .build();
    return updatePhraseMatcher(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a phrase matcher.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   UpdatePhraseMatcherRequest request =
   *       UpdatePhraseMatcherRequest.newBuilder()
   *           .setPhraseMatcher(PhraseMatcher.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   PhraseMatcher response = contactCenterInsightsClient.updatePhraseMatcher(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PhraseMatcher updatePhraseMatcher(UpdatePhraseMatcherRequest request) {
    return updatePhraseMatcherCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a phrase matcher.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   UpdatePhraseMatcherRequest request =
   *       UpdatePhraseMatcherRequest.newBuilder()
   *           .setPhraseMatcher(PhraseMatcher.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<PhraseMatcher> future =
   *       contactCenterInsightsClient.updatePhraseMatcherCallable().futureCall(request);
   *   // Do something.
   *   PhraseMatcher response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdatePhraseMatcherRequest, PhraseMatcher>
      updatePhraseMatcherCallable() {
    return stub.updatePhraseMatcherCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets conversation statistics.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   LocationName location = LocationName.of("[PROJECT]", "[LOCATION]");
   *   CalculateStatsResponse response = contactCenterInsightsClient.calculateStats(location);
   * }
   * }</pre>
   *
   * @param location Required. The location of the conversations.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CalculateStatsResponse calculateStats(LocationName location) {
    CalculateStatsRequest request =
        CalculateStatsRequest.newBuilder()
            .setLocation(location == null ? null : location.toString())
            .build();
    return calculateStats(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets conversation statistics.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   String location = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   CalculateStatsResponse response = contactCenterInsightsClient.calculateStats(location);
   * }
   * }</pre>
   *
   * @param location Required. The location of the conversations.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CalculateStatsResponse calculateStats(String location) {
    CalculateStatsRequest request =
        CalculateStatsRequest.newBuilder().setLocation(location).build();
    return calculateStats(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets conversation statistics.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   CalculateStatsRequest request =
   *       CalculateStatsRequest.newBuilder()
   *           .setLocation(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .build();
   *   CalculateStatsResponse response = contactCenterInsightsClient.calculateStats(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CalculateStatsResponse calculateStats(CalculateStatsRequest request) {
    return calculateStatsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets conversation statistics.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   CalculateStatsRequest request =
   *       CalculateStatsRequest.newBuilder()
   *           .setLocation(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<CalculateStatsResponse> future =
   *       contactCenterInsightsClient.calculateStatsCallable().futureCall(request);
   *   // Do something.
   *   CalculateStatsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CalculateStatsRequest, CalculateStatsResponse>
      calculateStatsCallable() {
    return stub.calculateStatsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets project-level settings.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   SettingsName name = SettingsName.of("[PROJECT]", "[LOCATION]");
   *   Settings response = contactCenterInsightsClient.getSettings(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the settings resource to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Settings getSettings(SettingsName name) {
    GetSettingsRequest request =
        GetSettingsRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getSettings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets project-level settings.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   String name = SettingsName.of("[PROJECT]", "[LOCATION]").toString();
   *   Settings response = contactCenterInsightsClient.getSettings(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the settings resource to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Settings getSettings(String name) {
    GetSettingsRequest request = GetSettingsRequest.newBuilder().setName(name).build();
    return getSettings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets project-level settings.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   GetSettingsRequest request =
   *       GetSettingsRequest.newBuilder()
   *           .setName(SettingsName.of("[PROJECT]", "[LOCATION]").toString())
   *           .build();
   *   Settings response = contactCenterInsightsClient.getSettings(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Settings getSettings(GetSettingsRequest request) {
    return getSettingsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets project-level settings.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   GetSettingsRequest request =
   *       GetSettingsRequest.newBuilder()
   *           .setName(SettingsName.of("[PROJECT]", "[LOCATION]").toString())
   *           .build();
   *   ApiFuture<Settings> future =
   *       contactCenterInsightsClient.getSettingsCallable().futureCall(request);
   *   // Do something.
   *   Settings response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetSettingsRequest, Settings> getSettingsCallable() {
    return stub.getSettingsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates project-level settings.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   Settings settings = Settings.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Settings response = contactCenterInsightsClient.updateSettings(settings, updateMask);
   * }
   * }</pre>
   *
   * @param settings Required. The new settings values.
   * @param updateMask Required. The list of fields to be updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Settings updateSettings(Settings settings, FieldMask updateMask) {
    UpdateSettingsRequest request =
        UpdateSettingsRequest.newBuilder().setSettings(settings).setUpdateMask(updateMask).build();
    return updateSettings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates project-level settings.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   UpdateSettingsRequest request =
   *       UpdateSettingsRequest.newBuilder()
   *           .setSettings(Settings.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Settings response = contactCenterInsightsClient.updateSettings(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Settings updateSettings(UpdateSettingsRequest request) {
    return updateSettingsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates project-level settings.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   UpdateSettingsRequest request =
   *       UpdateSettingsRequest.newBuilder()
   *           .setSettings(Settings.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Settings> future =
   *       contactCenterInsightsClient.updateSettingsCallable().futureCall(request);
   *   // Do something.
   *   Settings response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateSettingsRequest, Settings> updateSettingsCallable() {
    return stub.updateSettingsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a view.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   View view = View.newBuilder().build();
   *   View response = contactCenterInsightsClient.createView(parent, view);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the view. Required. The location to create a
   *     view for. Format: `projects/&lt;Project ID&gt;/locations/&lt;Location ID&gt;` or
   *     `projects/&lt;Project Number&gt;/locations/&lt;Location ID&gt;`
   * @param view Required. The view resource to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final View createView(LocationName parent, View view) {
    CreateViewRequest request =
        CreateViewRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setView(view)
            .build();
    return createView(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a view.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   View view = View.newBuilder().build();
   *   View response = contactCenterInsightsClient.createView(parent, view);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the view. Required. The location to create a
   *     view for. Format: `projects/&lt;Project ID&gt;/locations/&lt;Location ID&gt;` or
   *     `projects/&lt;Project Number&gt;/locations/&lt;Location ID&gt;`
   * @param view Required. The view resource to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final View createView(String parent, View view) {
    CreateViewRequest request =
        CreateViewRequest.newBuilder().setParent(parent).setView(view).build();
    return createView(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a view.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   CreateViewRequest request =
   *       CreateViewRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setView(View.newBuilder().build())
   *           .build();
   *   View response = contactCenterInsightsClient.createView(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final View createView(CreateViewRequest request) {
    return createViewCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a view.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   CreateViewRequest request =
   *       CreateViewRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setView(View.newBuilder().build())
   *           .build();
   *   ApiFuture<View> future = contactCenterInsightsClient.createViewCallable().futureCall(request);
   *   // Do something.
   *   View response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateViewRequest, View> createViewCallable() {
    return stub.createViewCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a view.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   ViewName name = ViewName.of("[PROJECT]", "[LOCATION]", "[VIEW]");
   *   View response = contactCenterInsightsClient.getView(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the view to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final View getView(ViewName name) {
    GetViewRequest request =
        GetViewRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getView(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a view.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   String name = ViewName.of("[PROJECT]", "[LOCATION]", "[VIEW]").toString();
   *   View response = contactCenterInsightsClient.getView(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the view to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final View getView(String name) {
    GetViewRequest request = GetViewRequest.newBuilder().setName(name).build();
    return getView(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a view.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   GetViewRequest request =
   *       GetViewRequest.newBuilder()
   *           .setName(ViewName.of("[PROJECT]", "[LOCATION]", "[VIEW]").toString())
   *           .build();
   *   View response = contactCenterInsightsClient.getView(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final View getView(GetViewRequest request) {
    return getViewCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a view.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   GetViewRequest request =
   *       GetViewRequest.newBuilder()
   *           .setName(ViewName.of("[PROJECT]", "[LOCATION]", "[VIEW]").toString())
   *           .build();
   *   ApiFuture<View> future = contactCenterInsightsClient.getViewCallable().futureCall(request);
   *   // Do something.
   *   View response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetViewRequest, View> getViewCallable() {
    return stub.getViewCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists views.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (View element : contactCenterInsightsClient.listViews(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the views.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListViewsPagedResponse listViews(LocationName parent) {
    ListViewsRequest request =
        ListViewsRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listViews(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists views.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (View element : contactCenterInsightsClient.listViews(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the views.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListViewsPagedResponse listViews(String parent) {
    ListViewsRequest request = ListViewsRequest.newBuilder().setParent(parent).build();
    return listViews(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists views.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   ListViewsRequest request =
   *       ListViewsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (View element : contactCenterInsightsClient.listViews(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListViewsPagedResponse listViews(ListViewsRequest request) {
    return listViewsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists views.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   ListViewsRequest request =
   *       ListViewsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<View> future =
   *       contactCenterInsightsClient.listViewsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (View element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListViewsRequest, ListViewsPagedResponse> listViewsPagedCallable() {
    return stub.listViewsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists views.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   ListViewsRequest request =
   *       ListViewsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListViewsResponse response = contactCenterInsightsClient.listViewsCallable().call(request);
   *     for (View element : response.getViewsList()) {
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
  public final UnaryCallable<ListViewsRequest, ListViewsResponse> listViewsCallable() {
    return stub.listViewsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a view.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   View view = View.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   View response = contactCenterInsightsClient.updateView(view, updateMask);
   * }
   * }</pre>
   *
   * @param view Required. The new view.
   * @param updateMask The list of fields to be updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final View updateView(View view, FieldMask updateMask) {
    UpdateViewRequest request =
        UpdateViewRequest.newBuilder().setView(view).setUpdateMask(updateMask).build();
    return updateView(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a view.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   UpdateViewRequest request =
   *       UpdateViewRequest.newBuilder()
   *           .setView(View.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   View response = contactCenterInsightsClient.updateView(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final View updateView(UpdateViewRequest request) {
    return updateViewCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a view.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   UpdateViewRequest request =
   *       UpdateViewRequest.newBuilder()
   *           .setView(View.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<View> future = contactCenterInsightsClient.updateViewCallable().futureCall(request);
   *   // Do something.
   *   View response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateViewRequest, View> updateViewCallable() {
    return stub.updateViewCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a view.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   ViewName name = ViewName.of("[PROJECT]", "[LOCATION]", "[VIEW]");
   *   contactCenterInsightsClient.deleteView(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the view to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteView(ViewName name) {
    DeleteViewRequest request =
        DeleteViewRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteView(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a view.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   String name = ViewName.of("[PROJECT]", "[LOCATION]", "[VIEW]").toString();
   *   contactCenterInsightsClient.deleteView(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the view to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteView(String name) {
    DeleteViewRequest request = DeleteViewRequest.newBuilder().setName(name).build();
    deleteView(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a view.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   DeleteViewRequest request =
   *       DeleteViewRequest.newBuilder()
   *           .setName(ViewName.of("[PROJECT]", "[LOCATION]", "[VIEW]").toString())
   *           .build();
   *   contactCenterInsightsClient.deleteView(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteView(DeleteViewRequest request) {
    deleteViewCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a view.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContactCenterInsightsClient contactCenterInsightsClient =
   *     ContactCenterInsightsClient.create()) {
   *   DeleteViewRequest request =
   *       DeleteViewRequest.newBuilder()
   *           .setName(ViewName.of("[PROJECT]", "[LOCATION]", "[VIEW]").toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       contactCenterInsightsClient.deleteViewCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteViewRequest, Empty> deleteViewCallable() {
    return stub.deleteViewCallable();
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

  public static class ListConversationsPagedResponse
      extends AbstractPagedListResponse<
          ListConversationsRequest,
          ListConversationsResponse,
          Conversation,
          ListConversationsPage,
          ListConversationsFixedSizeCollection> {

    public static ApiFuture<ListConversationsPagedResponse> createAsync(
        PageContext<ListConversationsRequest, ListConversationsResponse, Conversation> context,
        ApiFuture<ListConversationsResponse> futureResponse) {
      ApiFuture<ListConversationsPage> futurePage =
          ListConversationsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListConversationsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListConversationsPagedResponse(ListConversationsPage page) {
      super(page, ListConversationsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListConversationsPage
      extends AbstractPage<
          ListConversationsRequest,
          ListConversationsResponse,
          Conversation,
          ListConversationsPage> {

    private ListConversationsPage(
        PageContext<ListConversationsRequest, ListConversationsResponse, Conversation> context,
        ListConversationsResponse response) {
      super(context, response);
    }

    private static ListConversationsPage createEmptyPage() {
      return new ListConversationsPage(null, null);
    }

    @Override
    protected ListConversationsPage createPage(
        PageContext<ListConversationsRequest, ListConversationsResponse, Conversation> context,
        ListConversationsResponse response) {
      return new ListConversationsPage(context, response);
    }

    @Override
    public ApiFuture<ListConversationsPage> createPageAsync(
        PageContext<ListConversationsRequest, ListConversationsResponse, Conversation> context,
        ApiFuture<ListConversationsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListConversationsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListConversationsRequest,
          ListConversationsResponse,
          Conversation,
          ListConversationsPage,
          ListConversationsFixedSizeCollection> {

    private ListConversationsFixedSizeCollection(
        List<ListConversationsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListConversationsFixedSizeCollection createEmptyCollection() {
      return new ListConversationsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListConversationsFixedSizeCollection createCollection(
        List<ListConversationsPage> pages, int collectionSize) {
      return new ListConversationsFixedSizeCollection(pages, collectionSize);
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

  public static class ListPhraseMatchersPagedResponse
      extends AbstractPagedListResponse<
          ListPhraseMatchersRequest,
          ListPhraseMatchersResponse,
          PhraseMatcher,
          ListPhraseMatchersPage,
          ListPhraseMatchersFixedSizeCollection> {

    public static ApiFuture<ListPhraseMatchersPagedResponse> createAsync(
        PageContext<ListPhraseMatchersRequest, ListPhraseMatchersResponse, PhraseMatcher> context,
        ApiFuture<ListPhraseMatchersResponse> futureResponse) {
      ApiFuture<ListPhraseMatchersPage> futurePage =
          ListPhraseMatchersPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListPhraseMatchersPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListPhraseMatchersPagedResponse(ListPhraseMatchersPage page) {
      super(page, ListPhraseMatchersFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListPhraseMatchersPage
      extends AbstractPage<
          ListPhraseMatchersRequest,
          ListPhraseMatchersResponse,
          PhraseMatcher,
          ListPhraseMatchersPage> {

    private ListPhraseMatchersPage(
        PageContext<ListPhraseMatchersRequest, ListPhraseMatchersResponse, PhraseMatcher> context,
        ListPhraseMatchersResponse response) {
      super(context, response);
    }

    private static ListPhraseMatchersPage createEmptyPage() {
      return new ListPhraseMatchersPage(null, null);
    }

    @Override
    protected ListPhraseMatchersPage createPage(
        PageContext<ListPhraseMatchersRequest, ListPhraseMatchersResponse, PhraseMatcher> context,
        ListPhraseMatchersResponse response) {
      return new ListPhraseMatchersPage(context, response);
    }

    @Override
    public ApiFuture<ListPhraseMatchersPage> createPageAsync(
        PageContext<ListPhraseMatchersRequest, ListPhraseMatchersResponse, PhraseMatcher> context,
        ApiFuture<ListPhraseMatchersResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListPhraseMatchersFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListPhraseMatchersRequest,
          ListPhraseMatchersResponse,
          PhraseMatcher,
          ListPhraseMatchersPage,
          ListPhraseMatchersFixedSizeCollection> {

    private ListPhraseMatchersFixedSizeCollection(
        List<ListPhraseMatchersPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListPhraseMatchersFixedSizeCollection createEmptyCollection() {
      return new ListPhraseMatchersFixedSizeCollection(null, 0);
    }

    @Override
    protected ListPhraseMatchersFixedSizeCollection createCollection(
        List<ListPhraseMatchersPage> pages, int collectionSize) {
      return new ListPhraseMatchersFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListViewsPagedResponse
      extends AbstractPagedListResponse<
          ListViewsRequest, ListViewsResponse, View, ListViewsPage, ListViewsFixedSizeCollection> {

    public static ApiFuture<ListViewsPagedResponse> createAsync(
        PageContext<ListViewsRequest, ListViewsResponse, View> context,
        ApiFuture<ListViewsResponse> futureResponse) {
      ApiFuture<ListViewsPage> futurePage =
          ListViewsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListViewsPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListViewsPagedResponse(ListViewsPage page) {
      super(page, ListViewsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListViewsPage
      extends AbstractPage<ListViewsRequest, ListViewsResponse, View, ListViewsPage> {

    private ListViewsPage(
        PageContext<ListViewsRequest, ListViewsResponse, View> context,
        ListViewsResponse response) {
      super(context, response);
    }

    private static ListViewsPage createEmptyPage() {
      return new ListViewsPage(null, null);
    }

    @Override
    protected ListViewsPage createPage(
        PageContext<ListViewsRequest, ListViewsResponse, View> context,
        ListViewsResponse response) {
      return new ListViewsPage(context, response);
    }

    @Override
    public ApiFuture<ListViewsPage> createPageAsync(
        PageContext<ListViewsRequest, ListViewsResponse, View> context,
        ApiFuture<ListViewsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListViewsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListViewsRequest, ListViewsResponse, View, ListViewsPage, ListViewsFixedSizeCollection> {

    private ListViewsFixedSizeCollection(List<ListViewsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListViewsFixedSizeCollection createEmptyCollection() {
      return new ListViewsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListViewsFixedSizeCollection createCollection(
        List<ListViewsPage> pages, int collectionSize) {
      return new ListViewsFixedSizeCollection(pages, collectionSize);
    }
  }
}
