/*
 * Copyright 2021 Google LLC
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

package com.google.cloud.dialogflow.v2beta1;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dialogflow.v2beta1.stub.ConversationsStub;
import com.google.cloud.dialogflow.v2beta1.stub.ConversationsStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service for managing
 * [Conversations][google.cloud.dialogflow.v2beta1.Conversation].
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>{@code
 * try (ConversationsClient conversationsClient = ConversationsClient.create()) {
 *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
 *   Conversation conversation = Conversation.newBuilder().build();
 *   Conversation response = conversationsClient.createConversation(parent, conversation);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the ConversationsClient object to clean up resources such
 * as threads. In the example above, try-with-resources is used, which automatically calls close().
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
 * <p>This class can be customized by passing in a custom instance of ConversationsSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * ConversationsSettings conversationsSettings =
 *     ConversationsSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ConversationsClient conversationsClient = ConversationsClient.create(conversationsSettings);
 * }</pre>
 *
 * <p>To customize the endpoint:
 *
 * <pre>{@code
 * ConversationsSettings conversationsSettings =
 *     ConversationsSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ConversationsClient conversationsClient = ConversationsClient.create(conversationsSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class ConversationsClient implements BackgroundResource {
  private final ConversationsSettings settings;
  private final ConversationsStub stub;

  /** Constructs an instance of ConversationsClient with default settings. */
  public static final ConversationsClient create() throws IOException {
    return create(ConversationsSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ConversationsClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ConversationsClient create(ConversationsSettings settings)
      throws IOException {
    return new ConversationsClient(settings);
  }

  /**
   * Constructs an instance of ConversationsClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(ConversationsSettings).
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final ConversationsClient create(ConversationsStub stub) {
    return new ConversationsClient(stub);
  }

  /**
   * Constructs an instance of ConversationsClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected ConversationsClient(ConversationsSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((ConversationsStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected ConversationsClient(ConversationsStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final ConversationsSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public ConversationsStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new conversation. Conversations are auto-completed after 24 hours.
   *
   * <p>Conversation Lifecycle: There are two stages during a conversation: Automated Agent Stage
   * and Assist Stage.
   *
   * <p>For Automated Agent Stage, there will be a dialogflow agent responding to user queries.
   *
   * <p>For Assist Stage, there's no dialogflow agent responding to user queries. But we will
   * provide suggestions which are generated from conversation.
   *
   * <p>If
   * [Conversation.conversation_profile][google.cloud.dialogflow.v2beta1.Conversation.conversation_profile]
   * is configured for a dialogflow agent, conversation will start from `Automated Agent Stage`,
   * otherwise, it will start from `Assist Stage`. And during `Automated Agent Stage`, once an
   * [Intent][google.cloud.dialogflow.v2beta1.Intent] with
   * [Intent.live_agent_handoff][google.cloud.dialogflow.v2beta1.Intent.live_agent_handoff] is
   * triggered, conversation will transfer to Assist Stage.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ConversationsClient conversationsClient = ConversationsClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Conversation conversation = Conversation.newBuilder().build();
   *   Conversation response = conversationsClient.createConversation(parent, conversation);
   * }
   * }</pre>
   *
   * @param parent Required. Resource identifier of the project creating the conversation. Format:
   *     `projects/&lt;Project ID&gt;/locations/&lt;Location ID&gt;`.
   * @param conversation Required. The conversation to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Conversation createConversation(LocationName parent, Conversation conversation) {
    CreateConversationRequest request =
        CreateConversationRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setConversation(conversation)
            .build();
    return createConversation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new conversation. Conversations are auto-completed after 24 hours.
   *
   * <p>Conversation Lifecycle: There are two stages during a conversation: Automated Agent Stage
   * and Assist Stage.
   *
   * <p>For Automated Agent Stage, there will be a dialogflow agent responding to user queries.
   *
   * <p>For Assist Stage, there's no dialogflow agent responding to user queries. But we will
   * provide suggestions which are generated from conversation.
   *
   * <p>If
   * [Conversation.conversation_profile][google.cloud.dialogflow.v2beta1.Conversation.conversation_profile]
   * is configured for a dialogflow agent, conversation will start from `Automated Agent Stage`,
   * otherwise, it will start from `Assist Stage`. And during `Automated Agent Stage`, once an
   * [Intent][google.cloud.dialogflow.v2beta1.Intent] with
   * [Intent.live_agent_handoff][google.cloud.dialogflow.v2beta1.Intent.live_agent_handoff] is
   * triggered, conversation will transfer to Assist Stage.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ConversationsClient conversationsClient = ConversationsClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   Conversation conversation = Conversation.newBuilder().build();
   *   Conversation response = conversationsClient.createConversation(parent, conversation);
   * }
   * }</pre>
   *
   * @param parent Required. Resource identifier of the project creating the conversation. Format:
   *     `projects/&lt;Project ID&gt;/locations/&lt;Location ID&gt;`.
   * @param conversation Required. The conversation to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Conversation createConversation(ProjectName parent, Conversation conversation) {
    CreateConversationRequest request =
        CreateConversationRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setConversation(conversation)
            .build();
    return createConversation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new conversation. Conversations are auto-completed after 24 hours.
   *
   * <p>Conversation Lifecycle: There are two stages during a conversation: Automated Agent Stage
   * and Assist Stage.
   *
   * <p>For Automated Agent Stage, there will be a dialogflow agent responding to user queries.
   *
   * <p>For Assist Stage, there's no dialogflow agent responding to user queries. But we will
   * provide suggestions which are generated from conversation.
   *
   * <p>If
   * [Conversation.conversation_profile][google.cloud.dialogflow.v2beta1.Conversation.conversation_profile]
   * is configured for a dialogflow agent, conversation will start from `Automated Agent Stage`,
   * otherwise, it will start from `Assist Stage`. And during `Automated Agent Stage`, once an
   * [Intent][google.cloud.dialogflow.v2beta1.Intent] with
   * [Intent.live_agent_handoff][google.cloud.dialogflow.v2beta1.Intent.live_agent_handoff] is
   * triggered, conversation will transfer to Assist Stage.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ConversationsClient conversationsClient = ConversationsClient.create()) {
   *   String parent =
   *       ConversationName.ofProjectConversationName("[PROJECT]", "[CONVERSATION]").toString();
   *   Conversation conversation = Conversation.newBuilder().build();
   *   Conversation response = conversationsClient.createConversation(parent, conversation);
   * }
   * }</pre>
   *
   * @param parent Required. Resource identifier of the project creating the conversation. Format:
   *     `projects/&lt;Project ID&gt;/locations/&lt;Location ID&gt;`.
   * @param conversation Required. The conversation to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Conversation createConversation(String parent, Conversation conversation) {
    CreateConversationRequest request =
        CreateConversationRequest.newBuilder()
            .setParent(parent)
            .setConversation(conversation)
            .build();
    return createConversation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new conversation. Conversations are auto-completed after 24 hours.
   *
   * <p>Conversation Lifecycle: There are two stages during a conversation: Automated Agent Stage
   * and Assist Stage.
   *
   * <p>For Automated Agent Stage, there will be a dialogflow agent responding to user queries.
   *
   * <p>For Assist Stage, there's no dialogflow agent responding to user queries. But we will
   * provide suggestions which are generated from conversation.
   *
   * <p>If
   * [Conversation.conversation_profile][google.cloud.dialogflow.v2beta1.Conversation.conversation_profile]
   * is configured for a dialogflow agent, conversation will start from `Automated Agent Stage`,
   * otherwise, it will start from `Assist Stage`. And during `Automated Agent Stage`, once an
   * [Intent][google.cloud.dialogflow.v2beta1.Intent] with
   * [Intent.live_agent_handoff][google.cloud.dialogflow.v2beta1.Intent.live_agent_handoff] is
   * triggered, conversation will transfer to Assist Stage.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ConversationsClient conversationsClient = ConversationsClient.create()) {
   *   CreateConversationRequest request =
   *       CreateConversationRequest.newBuilder()
   *           .setParent(
   *               ConversationName.ofProjectConversationName("[PROJECT]", "[CONVERSATION]")
   *                   .toString())
   *           .setConversation(Conversation.newBuilder().build())
   *           .setConversationId("conversationId-1676095234")
   *           .build();
   *   Conversation response = conversationsClient.createConversation(request);
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
   * Creates a new conversation. Conversations are auto-completed after 24 hours.
   *
   * <p>Conversation Lifecycle: There are two stages during a conversation: Automated Agent Stage
   * and Assist Stage.
   *
   * <p>For Automated Agent Stage, there will be a dialogflow agent responding to user queries.
   *
   * <p>For Assist Stage, there's no dialogflow agent responding to user queries. But we will
   * provide suggestions which are generated from conversation.
   *
   * <p>If
   * [Conversation.conversation_profile][google.cloud.dialogflow.v2beta1.Conversation.conversation_profile]
   * is configured for a dialogflow agent, conversation will start from `Automated Agent Stage`,
   * otherwise, it will start from `Assist Stage`. And during `Automated Agent Stage`, once an
   * [Intent][google.cloud.dialogflow.v2beta1.Intent] with
   * [Intent.live_agent_handoff][google.cloud.dialogflow.v2beta1.Intent.live_agent_handoff] is
   * triggered, conversation will transfer to Assist Stage.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ConversationsClient conversationsClient = ConversationsClient.create()) {
   *   CreateConversationRequest request =
   *       CreateConversationRequest.newBuilder()
   *           .setParent(
   *               ConversationName.ofProjectConversationName("[PROJECT]", "[CONVERSATION]")
   *                   .toString())
   *           .setConversation(Conversation.newBuilder().build())
   *           .setConversationId("conversationId-1676095234")
   *           .build();
   *   ApiFuture<Conversation> future =
   *       conversationsClient.createConversationCallable().futureCall(request);
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
   * Returns the list of all conversations in the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ConversationsClient conversationsClient = ConversationsClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Conversation element : conversationsClient.listConversations(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project from which to list all conversation. Format:
   *     `projects/&lt;Project ID&gt;/locations/&lt;Location ID&gt;`.
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
   * Returns the list of all conversations in the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ConversationsClient conversationsClient = ConversationsClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   for (Conversation element : conversationsClient.listConversations(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project from which to list all conversation. Format:
   *     `projects/&lt;Project ID&gt;/locations/&lt;Location ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListConversationsPagedResponse listConversations(ProjectName parent) {
    ListConversationsRequest request =
        ListConversationsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listConversations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of all conversations in the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ConversationsClient conversationsClient = ConversationsClient.create()) {
   *   String parent =
   *       ConversationName.ofProjectConversationName("[PROJECT]", "[CONVERSATION]").toString();
   *   for (Conversation element : conversationsClient.listConversations(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project from which to list all conversation. Format:
   *     `projects/&lt;Project ID&gt;/locations/&lt;Location ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListConversationsPagedResponse listConversations(String parent) {
    ListConversationsRequest request =
        ListConversationsRequest.newBuilder().setParent(parent).build();
    return listConversations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of all conversations in the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ConversationsClient conversationsClient = ConversationsClient.create()) {
   *   ListConversationsRequest request =
   *       ListConversationsRequest.newBuilder()
   *           .setParent(
   *               ConversationName.ofProjectConversationName("[PROJECT]", "[CONVERSATION]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (Conversation element : conversationsClient.listConversations(request).iterateAll()) {
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
   * Returns the list of all conversations in the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ConversationsClient conversationsClient = ConversationsClient.create()) {
   *   ListConversationsRequest request =
   *       ListConversationsRequest.newBuilder()
   *           .setParent(
   *               ConversationName.ofProjectConversationName("[PROJECT]", "[CONVERSATION]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<Conversation> future =
   *       conversationsClient.listConversationsPagedCallable().futureCall(request);
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
   * Returns the list of all conversations in the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ConversationsClient conversationsClient = ConversationsClient.create()) {
   *   while (true) {
   *     ListConversationsResponse response =
   *         conversationsClient.listConversationsCallable().call(request);
   *     for (Conversation element : response.getResponsesList()) {
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
   * Retrieves the specific conversation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ConversationsClient conversationsClient = ConversationsClient.create()) {
   *   ConversationName name =
   *       ConversationName.ofProjectConversationName("[PROJECT]", "[CONVERSATION]");
   *   Conversation response = conversationsClient.getConversation(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the conversation. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/conversations/&lt;Conversation ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Conversation getConversation(ConversationName name) {
    GetConversationRequest request =
        GetConversationRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getConversation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the specific conversation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ConversationsClient conversationsClient = ConversationsClient.create()) {
   *   String name =
   *       ConversationName.ofProjectConversationName("[PROJECT]", "[CONVERSATION]").toString();
   *   Conversation response = conversationsClient.getConversation(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the conversation. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/conversations/&lt;Conversation ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Conversation getConversation(String name) {
    GetConversationRequest request = GetConversationRequest.newBuilder().setName(name).build();
    return getConversation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the specific conversation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ConversationsClient conversationsClient = ConversationsClient.create()) {
   *   GetConversationRequest request =
   *       GetConversationRequest.newBuilder()
   *           .setName(
   *               ConversationName.ofProjectConversationName("[PROJECT]", "[CONVERSATION]")
   *                   .toString())
   *           .build();
   *   Conversation response = conversationsClient.getConversation(request);
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
   * Retrieves the specific conversation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ConversationsClient conversationsClient = ConversationsClient.create()) {
   *   GetConversationRequest request =
   *       GetConversationRequest.newBuilder()
   *           .setName(
   *               ConversationName.ofProjectConversationName("[PROJECT]", "[CONVERSATION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Conversation> future =
   *       conversationsClient.getConversationCallable().futureCall(request);
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
   * Completes the specified conversation. Finished conversations are purged from the database after
   * 30 days.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ConversationsClient conversationsClient = ConversationsClient.create()) {
   *   ConversationName name =
   *       ConversationName.ofProjectConversationName("[PROJECT]", "[CONVERSATION]");
   *   Conversation response = conversationsClient.completeConversation(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource identifier of the conversation to close. Format:
   *     `projects/&lt;Project ID&gt;/locations/&lt;Location ID&gt;/conversations/&lt;Conversation
   *     ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Conversation completeConversation(ConversationName name) {
    CompleteConversationRequest request =
        CompleteConversationRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return completeConversation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Completes the specified conversation. Finished conversations are purged from the database after
   * 30 days.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ConversationsClient conversationsClient = ConversationsClient.create()) {
   *   String name =
   *       ConversationName.ofProjectConversationName("[PROJECT]", "[CONVERSATION]").toString();
   *   Conversation response = conversationsClient.completeConversation(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource identifier of the conversation to close. Format:
   *     `projects/&lt;Project ID&gt;/locations/&lt;Location ID&gt;/conversations/&lt;Conversation
   *     ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Conversation completeConversation(String name) {
    CompleteConversationRequest request =
        CompleteConversationRequest.newBuilder().setName(name).build();
    return completeConversation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Completes the specified conversation. Finished conversations are purged from the database after
   * 30 days.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ConversationsClient conversationsClient = ConversationsClient.create()) {
   *   CompleteConversationRequest request =
   *       CompleteConversationRequest.newBuilder()
   *           .setName(
   *               ConversationName.ofProjectConversationName("[PROJECT]", "[CONVERSATION]")
   *                   .toString())
   *           .build();
   *   Conversation response = conversationsClient.completeConversation(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Conversation completeConversation(CompleteConversationRequest request) {
    return completeConversationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Completes the specified conversation. Finished conversations are purged from the database after
   * 30 days.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ConversationsClient conversationsClient = ConversationsClient.create()) {
   *   CompleteConversationRequest request =
   *       CompleteConversationRequest.newBuilder()
   *           .setName(
   *               ConversationName.ofProjectConversationName("[PROJECT]", "[CONVERSATION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Conversation> future =
   *       conversationsClient.completeConversationCallable().futureCall(request);
   *   // Do something.
   *   Conversation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CompleteConversationRequest, Conversation>
      completeConversationCallable() {
    return stub.completeConversationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a call matcher that links incoming SIP calls to the specified conversation if they
   * fulfill specified criteria.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ConversationsClient conversationsClient = ConversationsClient.create()) {
   *   ConversationName parent =
   *       ConversationName.ofProjectConversationName("[PROJECT]", "[CONVERSATION]");
   *   CallMatcher callMatcher = CallMatcher.newBuilder().build();
   *   CallMatcher response = conversationsClient.createCallMatcher(parent, callMatcher);
   * }
   * }</pre>
   *
   * @param parent Required. Resource identifier of the conversation adding the call matcher.
   *     Format: `projects/&lt;Project ID&gt;/locations/&lt;Location
   *     ID&gt;/conversations/&lt;Conversation ID&gt;`.
   * @param callMatcher Required. The call matcher to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CallMatcher createCallMatcher(ConversationName parent, CallMatcher callMatcher) {
    CreateCallMatcherRequest request =
        CreateCallMatcherRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setCallMatcher(callMatcher)
            .build();
    return createCallMatcher(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a call matcher that links incoming SIP calls to the specified conversation if they
   * fulfill specified criteria.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ConversationsClient conversationsClient = ConversationsClient.create()) {
   *   String parent =
   *       CallMatcherName.ofProjectConversationCallMatcherName(
   *               "[PROJECT]", "[CONVERSATION]", "[CALL_MATCHER]")
   *           .toString();
   *   CallMatcher callMatcher = CallMatcher.newBuilder().build();
   *   CallMatcher response = conversationsClient.createCallMatcher(parent, callMatcher);
   * }
   * }</pre>
   *
   * @param parent Required. Resource identifier of the conversation adding the call matcher.
   *     Format: `projects/&lt;Project ID&gt;/locations/&lt;Location
   *     ID&gt;/conversations/&lt;Conversation ID&gt;`.
   * @param callMatcher Required. The call matcher to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CallMatcher createCallMatcher(String parent, CallMatcher callMatcher) {
    CreateCallMatcherRequest request =
        CreateCallMatcherRequest.newBuilder().setParent(parent).setCallMatcher(callMatcher).build();
    return createCallMatcher(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a call matcher that links incoming SIP calls to the specified conversation if they
   * fulfill specified criteria.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ConversationsClient conversationsClient = ConversationsClient.create()) {
   *   CreateCallMatcherRequest request =
   *       CreateCallMatcherRequest.newBuilder()
   *           .setParent(
   *               CallMatcherName.ofProjectConversationCallMatcherName(
   *                       "[PROJECT]", "[CONVERSATION]", "[CALL_MATCHER]")
   *                   .toString())
   *           .setCallMatcher(CallMatcher.newBuilder().build())
   *           .build();
   *   CallMatcher response = conversationsClient.createCallMatcher(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CallMatcher createCallMatcher(CreateCallMatcherRequest request) {
    return createCallMatcherCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a call matcher that links incoming SIP calls to the specified conversation if they
   * fulfill specified criteria.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ConversationsClient conversationsClient = ConversationsClient.create()) {
   *   CreateCallMatcherRequest request =
   *       CreateCallMatcherRequest.newBuilder()
   *           .setParent(
   *               CallMatcherName.ofProjectConversationCallMatcherName(
   *                       "[PROJECT]", "[CONVERSATION]", "[CALL_MATCHER]")
   *                   .toString())
   *           .setCallMatcher(CallMatcher.newBuilder().build())
   *           .build();
   *   ApiFuture<CallMatcher> future =
   *       conversationsClient.createCallMatcherCallable().futureCall(request);
   *   // Do something.
   *   CallMatcher response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateCallMatcherRequest, CallMatcher> createCallMatcherCallable() {
    return stub.createCallMatcherCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of all call matchers in the specified conversation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ConversationsClient conversationsClient = ConversationsClient.create()) {
   *   ConversationName parent =
   *       ConversationName.ofProjectConversationName("[PROJECT]", "[CONVERSATION]");
   *   for (CallMatcher element : conversationsClient.listCallMatchers(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The conversation to list all call matchers from. Format:
   *     `projects/&lt;Project ID&gt;/locations/&lt;Location ID&gt;/conversations/&lt;Conversation
   *     ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCallMatchersPagedResponse listCallMatchers(ConversationName parent) {
    ListCallMatchersRequest request =
        ListCallMatchersRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listCallMatchers(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of all call matchers in the specified conversation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ConversationsClient conversationsClient = ConversationsClient.create()) {
   *   String parent =
   *       CallMatcherName.ofProjectConversationCallMatcherName(
   *               "[PROJECT]", "[CONVERSATION]", "[CALL_MATCHER]")
   *           .toString();
   *   for (CallMatcher element : conversationsClient.listCallMatchers(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The conversation to list all call matchers from. Format:
   *     `projects/&lt;Project ID&gt;/locations/&lt;Location ID&gt;/conversations/&lt;Conversation
   *     ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCallMatchersPagedResponse listCallMatchers(String parent) {
    ListCallMatchersRequest request =
        ListCallMatchersRequest.newBuilder().setParent(parent).build();
    return listCallMatchers(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of all call matchers in the specified conversation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ConversationsClient conversationsClient = ConversationsClient.create()) {
   *   ListCallMatchersRequest request =
   *       ListCallMatchersRequest.newBuilder()
   *           .setParent(
   *               CallMatcherName.ofProjectConversationCallMatcherName(
   *                       "[PROJECT]", "[CONVERSATION]", "[CALL_MATCHER]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (CallMatcher element : conversationsClient.listCallMatchers(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCallMatchersPagedResponse listCallMatchers(ListCallMatchersRequest request) {
    return listCallMatchersPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of all call matchers in the specified conversation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ConversationsClient conversationsClient = ConversationsClient.create()) {
   *   ListCallMatchersRequest request =
   *       ListCallMatchersRequest.newBuilder()
   *           .setParent(
   *               CallMatcherName.ofProjectConversationCallMatcherName(
   *                       "[PROJECT]", "[CONVERSATION]", "[CALL_MATCHER]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<CallMatcher> future =
   *       conversationsClient.listCallMatchersPagedCallable().futureCall(request);
   *   // Do something.
   *   for (CallMatcher element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListCallMatchersRequest, ListCallMatchersPagedResponse>
      listCallMatchersPagedCallable() {
    return stub.listCallMatchersPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of all call matchers in the specified conversation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ConversationsClient conversationsClient = ConversationsClient.create()) {
   *   while (true) {
   *     ListCallMatchersResponse response =
   *         conversationsClient.listCallMatchersCallable().call(request);
   *     for (CallMatcher element : response.getResponsesList()) {
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
  public final UnaryCallable<ListCallMatchersRequest, ListCallMatchersResponse>
      listCallMatchersCallable() {
    return stub.listCallMatchersCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Requests deletion of a call matcher.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ConversationsClient conversationsClient = ConversationsClient.create()) {
   *   CallMatcherName name =
   *       CallMatcherName.ofProjectConversationCallMatcherName(
   *           "[PROJECT]", "[CONVERSATION]", "[CALL_MATCHER]");
   *   conversationsClient.deleteCallMatcher(name);
   * }
   * }</pre>
   *
   * @param name Required. The unique identifier of the
   *     [CallMatcher][google.cloud.dialogflow.v2beta1.CallMatcher] to delete. Format:
   *     `projects/&lt;Project ID&gt;/locations/&lt;Location ID&gt;/conversations/&lt;Conversation
   *     ID&gt;/callMatchers/&lt;CallMatcher ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteCallMatcher(CallMatcherName name) {
    DeleteCallMatcherRequest request =
        DeleteCallMatcherRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteCallMatcher(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Requests deletion of a call matcher.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ConversationsClient conversationsClient = ConversationsClient.create()) {
   *   String name =
   *       CallMatcherName.ofProjectConversationCallMatcherName(
   *               "[PROJECT]", "[CONVERSATION]", "[CALL_MATCHER]")
   *           .toString();
   *   conversationsClient.deleteCallMatcher(name);
   * }
   * }</pre>
   *
   * @param name Required. The unique identifier of the
   *     [CallMatcher][google.cloud.dialogflow.v2beta1.CallMatcher] to delete. Format:
   *     `projects/&lt;Project ID&gt;/locations/&lt;Location ID&gt;/conversations/&lt;Conversation
   *     ID&gt;/callMatchers/&lt;CallMatcher ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteCallMatcher(String name) {
    DeleteCallMatcherRequest request = DeleteCallMatcherRequest.newBuilder().setName(name).build();
    deleteCallMatcher(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Requests deletion of a call matcher.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ConversationsClient conversationsClient = ConversationsClient.create()) {
   *   DeleteCallMatcherRequest request =
   *       DeleteCallMatcherRequest.newBuilder()
   *           .setName(
   *               CallMatcherName.ofProjectConversationCallMatcherName(
   *                       "[PROJECT]", "[CONVERSATION]", "[CALL_MATCHER]")
   *                   .toString())
   *           .build();
   *   conversationsClient.deleteCallMatcher(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteCallMatcher(DeleteCallMatcherRequest request) {
    deleteCallMatcherCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Requests deletion of a call matcher.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ConversationsClient conversationsClient = ConversationsClient.create()) {
   *   DeleteCallMatcherRequest request =
   *       DeleteCallMatcherRequest.newBuilder()
   *           .setName(
   *               CallMatcherName.ofProjectConversationCallMatcherName(
   *                       "[PROJECT]", "[CONVERSATION]", "[CALL_MATCHER]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Empty> future = conversationsClient.deleteCallMatcherCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteCallMatcherRequest, Empty> deleteCallMatcherCallable() {
    return stub.deleteCallMatcherCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch ingests messages to conversation. Customers can use this RPC to ingest historical
   * messages to conversation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ConversationsClient conversationsClient = ConversationsClient.create()) {
   *   ConversationName parent =
   *       ConversationName.ofProjectConversationName("[PROJECT]", "[CONVERSATION]");
   *   BatchCreateMessagesResponse response = conversationsClient.batchCreateMessages(parent);
   * }
   * }</pre>
   *
   * @param parent Required. Resource identifier of the conversation to create message. Format:
   *     `projects/&lt;Project ID&gt;/locations/&lt;Location ID&gt;/conversations/&lt;Conversation
   *     ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreateMessagesResponse batchCreateMessages(ConversationName parent) {
    BatchCreateMessagesRequest request =
        BatchCreateMessagesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return batchCreateMessages(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch ingests messages to conversation. Customers can use this RPC to ingest historical
   * messages to conversation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ConversationsClient conversationsClient = ConversationsClient.create()) {
   *   String parent =
   *       ConversationName.ofProjectConversationName("[PROJECT]", "[CONVERSATION]").toString();
   *   BatchCreateMessagesResponse response = conversationsClient.batchCreateMessages(parent);
   * }
   * }</pre>
   *
   * @param parent Required. Resource identifier of the conversation to create message. Format:
   *     `projects/&lt;Project ID&gt;/locations/&lt;Location ID&gt;/conversations/&lt;Conversation
   *     ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreateMessagesResponse batchCreateMessages(String parent) {
    BatchCreateMessagesRequest request =
        BatchCreateMessagesRequest.newBuilder().setParent(parent).build();
    return batchCreateMessages(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch ingests messages to conversation. Customers can use this RPC to ingest historical
   * messages to conversation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ConversationsClient conversationsClient = ConversationsClient.create()) {
   *   BatchCreateMessagesRequest request =
   *       BatchCreateMessagesRequest.newBuilder()
   *           .setParent(
   *               ConversationName.ofProjectConversationName("[PROJECT]", "[CONVERSATION]")
   *                   .toString())
   *           .addAllRequests(new ArrayList<CreateMessageRequest>())
   *           .build();
   *   BatchCreateMessagesResponse response = conversationsClient.batchCreateMessages(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreateMessagesResponse batchCreateMessages(BatchCreateMessagesRequest request) {
    return batchCreateMessagesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch ingests messages to conversation. Customers can use this RPC to ingest historical
   * messages to conversation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ConversationsClient conversationsClient = ConversationsClient.create()) {
   *   BatchCreateMessagesRequest request =
   *       BatchCreateMessagesRequest.newBuilder()
   *           .setParent(
   *               ConversationName.ofProjectConversationName("[PROJECT]", "[CONVERSATION]")
   *                   .toString())
   *           .addAllRequests(new ArrayList<CreateMessageRequest>())
   *           .build();
   *   ApiFuture<BatchCreateMessagesResponse> future =
   *       conversationsClient.batchCreateMessagesCallable().futureCall(request);
   *   // Do something.
   *   BatchCreateMessagesResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchCreateMessagesRequest, BatchCreateMessagesResponse>
      batchCreateMessagesCallable() {
    return stub.batchCreateMessagesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists messages that belong to a given conversation. `messages` are ordered by `create_time` in
   * descending order. To fetch updates without duplication, send request with filter
   * `create_time_epoch_microseconds &gt; [first item's create_time of previous request]` and empty
   * page_token.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ConversationsClient conversationsClient = ConversationsClient.create()) {
   *   ConversationName parent =
   *       ConversationName.ofProjectConversationName("[PROJECT]", "[CONVERSATION]");
   *   for (Message element : conversationsClient.listMessages(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The name of the conversation to list messages for. Format:
   *     `projects/&lt;Project ID&gt;/locations/&lt;Location ID&gt;/conversations/&lt;Conversation
   *     ID&gt;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMessagesPagedResponse listMessages(ConversationName parent) {
    ListMessagesRequest request =
        ListMessagesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listMessages(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists messages that belong to a given conversation. `messages` are ordered by `create_time` in
   * descending order. To fetch updates without duplication, send request with filter
   * `create_time_epoch_microseconds &gt; [first item's create_time of previous request]` and empty
   * page_token.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ConversationsClient conversationsClient = ConversationsClient.create()) {
   *   String parent =
   *       MessageName.ofProjectConversationMessageName("[PROJECT]", "[CONVERSATION]", "[MESSAGE]")
   *           .toString();
   *   for (Message element : conversationsClient.listMessages(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The name of the conversation to list messages for. Format:
   *     `projects/&lt;Project ID&gt;/locations/&lt;Location ID&gt;/conversations/&lt;Conversation
   *     ID&gt;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMessagesPagedResponse listMessages(String parent) {
    ListMessagesRequest request = ListMessagesRequest.newBuilder().setParent(parent).build();
    return listMessages(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists messages that belong to a given conversation. `messages` are ordered by `create_time` in
   * descending order. To fetch updates without duplication, send request with filter
   * `create_time_epoch_microseconds &gt; [first item's create_time of previous request]` and empty
   * page_token.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ConversationsClient conversationsClient = ConversationsClient.create()) {
   *   ListMessagesRequest request =
   *       ListMessagesRequest.newBuilder()
   *           .setParent(
   *               MessageName.ofProjectConversationMessageName(
   *                       "[PROJECT]", "[CONVERSATION]", "[MESSAGE]")
   *                   .toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Message element : conversationsClient.listMessages(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMessagesPagedResponse listMessages(ListMessagesRequest request) {
    return listMessagesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists messages that belong to a given conversation. `messages` are ordered by `create_time` in
   * descending order. To fetch updates without duplication, send request with filter
   * `create_time_epoch_microseconds &gt; [first item's create_time of previous request]` and empty
   * page_token.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ConversationsClient conversationsClient = ConversationsClient.create()) {
   *   ListMessagesRequest request =
   *       ListMessagesRequest.newBuilder()
   *           .setParent(
   *               MessageName.ofProjectConversationMessageName(
   *                       "[PROJECT]", "[CONVERSATION]", "[MESSAGE]")
   *                   .toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Message> future =
   *       conversationsClient.listMessagesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Message element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListMessagesRequest, ListMessagesPagedResponse>
      listMessagesPagedCallable() {
    return stub.listMessagesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists messages that belong to a given conversation. `messages` are ordered by `create_time` in
   * descending order. To fetch updates without duplication, send request with filter
   * `create_time_epoch_microseconds &gt; [first item's create_time of previous request]` and empty
   * page_token.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ConversationsClient conversationsClient = ConversationsClient.create()) {
   *   while (true) {
   *     ListMessagesResponse response = conversationsClient.listMessagesCallable().call(request);
   *     for (Message element : response.getResponsesList()) {
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
  public final UnaryCallable<ListMessagesRequest, ListMessagesResponse> listMessagesCallable() {
    return stub.listMessagesCallable();
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
          new ApiFunction<ListConversationsPage, ListConversationsPagedResponse>() {
            @Override
            public ListConversationsPagedResponse apply(ListConversationsPage input) {
              return new ListConversationsPagedResponse(input);
            }
          },
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

  public static class ListCallMatchersPagedResponse
      extends AbstractPagedListResponse<
          ListCallMatchersRequest,
          ListCallMatchersResponse,
          CallMatcher,
          ListCallMatchersPage,
          ListCallMatchersFixedSizeCollection> {

    public static ApiFuture<ListCallMatchersPagedResponse> createAsync(
        PageContext<ListCallMatchersRequest, ListCallMatchersResponse, CallMatcher> context,
        ApiFuture<ListCallMatchersResponse> futureResponse) {
      ApiFuture<ListCallMatchersPage> futurePage =
          ListCallMatchersPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListCallMatchersPage, ListCallMatchersPagedResponse>() {
            @Override
            public ListCallMatchersPagedResponse apply(ListCallMatchersPage input) {
              return new ListCallMatchersPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListCallMatchersPagedResponse(ListCallMatchersPage page) {
      super(page, ListCallMatchersFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListCallMatchersPage
      extends AbstractPage<
          ListCallMatchersRequest, ListCallMatchersResponse, CallMatcher, ListCallMatchersPage> {

    private ListCallMatchersPage(
        PageContext<ListCallMatchersRequest, ListCallMatchersResponse, CallMatcher> context,
        ListCallMatchersResponse response) {
      super(context, response);
    }

    private static ListCallMatchersPage createEmptyPage() {
      return new ListCallMatchersPage(null, null);
    }

    @Override
    protected ListCallMatchersPage createPage(
        PageContext<ListCallMatchersRequest, ListCallMatchersResponse, CallMatcher> context,
        ListCallMatchersResponse response) {
      return new ListCallMatchersPage(context, response);
    }

    @Override
    public ApiFuture<ListCallMatchersPage> createPageAsync(
        PageContext<ListCallMatchersRequest, ListCallMatchersResponse, CallMatcher> context,
        ApiFuture<ListCallMatchersResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListCallMatchersFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListCallMatchersRequest,
          ListCallMatchersResponse,
          CallMatcher,
          ListCallMatchersPage,
          ListCallMatchersFixedSizeCollection> {

    private ListCallMatchersFixedSizeCollection(
        List<ListCallMatchersPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListCallMatchersFixedSizeCollection createEmptyCollection() {
      return new ListCallMatchersFixedSizeCollection(null, 0);
    }

    @Override
    protected ListCallMatchersFixedSizeCollection createCollection(
        List<ListCallMatchersPage> pages, int collectionSize) {
      return new ListCallMatchersFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListMessagesPagedResponse
      extends AbstractPagedListResponse<
          ListMessagesRequest,
          ListMessagesResponse,
          Message,
          ListMessagesPage,
          ListMessagesFixedSizeCollection> {

    public static ApiFuture<ListMessagesPagedResponse> createAsync(
        PageContext<ListMessagesRequest, ListMessagesResponse, Message> context,
        ApiFuture<ListMessagesResponse> futureResponse) {
      ApiFuture<ListMessagesPage> futurePage =
          ListMessagesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListMessagesPage, ListMessagesPagedResponse>() {
            @Override
            public ListMessagesPagedResponse apply(ListMessagesPage input) {
              return new ListMessagesPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListMessagesPagedResponse(ListMessagesPage page) {
      super(page, ListMessagesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListMessagesPage
      extends AbstractPage<ListMessagesRequest, ListMessagesResponse, Message, ListMessagesPage> {

    private ListMessagesPage(
        PageContext<ListMessagesRequest, ListMessagesResponse, Message> context,
        ListMessagesResponse response) {
      super(context, response);
    }

    private static ListMessagesPage createEmptyPage() {
      return new ListMessagesPage(null, null);
    }

    @Override
    protected ListMessagesPage createPage(
        PageContext<ListMessagesRequest, ListMessagesResponse, Message> context,
        ListMessagesResponse response) {
      return new ListMessagesPage(context, response);
    }

    @Override
    public ApiFuture<ListMessagesPage> createPageAsync(
        PageContext<ListMessagesRequest, ListMessagesResponse, Message> context,
        ApiFuture<ListMessagesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListMessagesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListMessagesRequest,
          ListMessagesResponse,
          Message,
          ListMessagesPage,
          ListMessagesFixedSizeCollection> {

    private ListMessagesFixedSizeCollection(List<ListMessagesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListMessagesFixedSizeCollection createEmptyCollection() {
      return new ListMessagesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListMessagesFixedSizeCollection createCollection(
        List<ListMessagesPage> pages, int collectionSize) {
      return new ListMessagesFixedSizeCollection(pages, collectionSize);
    }
  }
}
