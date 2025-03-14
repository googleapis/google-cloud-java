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
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dialogflow.v2.stub.ConversationsStub;
import com.google.cloud.dialogflow.v2.stub.ConversationsStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service for managing
 * [Conversations][google.cloud.dialogflow.v2.Conversation].
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
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> CreateConversation</td>
 *      <td><p> Creates a new conversation. Conversations are auto-completed after 24 hours.
 * <p>  Conversation Lifecycle: There are two stages during a conversation: Automated Agent Stage and Assist Stage.
 * <p>  For Automated Agent Stage, there will be a dialogflow agent responding to user queries.
 * <p>  For Assist Stage, there's no dialogflow agent responding to user queries. But we will provide suggestions which are generated from conversation.
 * <p>  If [Conversation.conversation_profile][google.cloud.dialogflow.v2.Conversation.conversation_profile] is configured for a dialogflow agent, conversation will start from `Automated Agent Stage`, otherwise, it will start from `Assist Stage`. And during `Automated Agent Stage`, once an [Intent][google.cloud.dialogflow.v2.Intent] with [Intent.live_agent_handoff][google.cloud.dialogflow.v2.Intent.live_agent_handoff] is triggered, conversation will transfer to Assist Stage.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createConversation(CreateConversationRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createConversation(LocationName parent, Conversation conversation)
 *           <li><p> createConversation(ProjectName parent, Conversation conversation)
 *           <li><p> createConversation(String parent, Conversation conversation)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createConversationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListConversations</td>
 *      <td><p> Returns the list of all conversations in the specified project.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listConversations(ListConversationsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listConversations(LocationName parent)
 *           <li><p> listConversations(ProjectName parent)
 *           <li><p> listConversations(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listConversationsPagedCallable()
 *           <li><p> listConversationsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetConversation</td>
 *      <td><p> Retrieves the specific conversation.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getConversation(GetConversationRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getConversation(ConversationName name)
 *           <li><p> getConversation(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getConversationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CompleteConversation</td>
 *      <td><p> Completes the specified conversation. Finished conversations are purged from the database after 30 days.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> completeConversation(CompleteConversationRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> completeConversation(ConversationName name)
 *           <li><p> completeConversation(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> completeConversationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> IngestContextReferences</td>
 *      <td><p> Data ingestion API. Ingests context references for an existing conversation.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> ingestContextReferences(IngestContextReferencesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> ingestContextReferences(ConversationName conversation, Map&lt;String, Conversation.ContextReference&gt; contextReferences)
 *           <li><p> ingestContextReferences(String conversation, Map&lt;String, Conversation.ContextReference&gt; contextReferences)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> ingestContextReferencesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListMessages</td>
 *      <td><p> Lists messages that belong to a given conversation. `messages` are ordered by `create_time` in descending order. To fetch updates without duplication, send request with filter `create_time_epoch_microseconds &gt; [first item's create_time of previous request]` and empty page_token.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listMessages(ListMessagesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listMessages(ConversationName parent)
 *           <li><p> listMessages(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listMessagesPagedCallable()
 *           <li><p> listMessagesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> SuggestConversationSummary</td>
 *      <td><p> Suggests summary for a conversation based on specific historical messages. The range of the messages to be used for summary can be specified in the request.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> suggestConversationSummary(SuggestConversationSummaryRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> suggestConversationSummary(ConversationName conversation)
 *           <li><p> suggestConversationSummary(String conversation)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> suggestConversationSummaryCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GenerateStatelessSummary</td>
 *      <td><p> Generates and returns a summary for a conversation that does not have a resource created for it.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> generateStatelessSummary(GenerateStatelessSummaryRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> generateStatelessSummaryCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GenerateStatelessSuggestion</td>
 *      <td><p> Generates and returns a suggestion for a conversation that does not have a resource created for it.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> generateStatelessSuggestion(GenerateStatelessSuggestionRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> generateStatelessSuggestionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> SearchKnowledge</td>
 *      <td><p> Get answers for the given query based on knowledge documents.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> searchKnowledge(SearchKnowledgeRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> searchKnowledgeCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GenerateSuggestions</td>
 *      <td><p> Generates all the suggestions using generators configured in the conversation profile. A generator is used only if its trigger event is matched.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> generateSuggestions(GenerateSuggestionsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> generateSuggestions(ConversationName conversation)
 *           <li><p> generateSuggestions(String conversation)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> generateSuggestionsCallable()
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
 * <p>This class can be customized by passing in a custom instance of ConversationsSettings to
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
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ConversationsSettings conversationsSettings =
 *     ConversationsSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ConversationsClient conversationsClient = ConversationsClient.create(conversationsSettings);
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
 * ConversationsSettings conversationsSettings =
 *     ConversationsSettings.newHttpJsonBuilder().build();
 * ConversationsClient conversationsClient = ConversationsClient.create(conversationsSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
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

  protected ConversationsClient(ConversationsStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final ConversationsSettings getSettings() {
    return settings;
  }

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
   * [Conversation.conversation_profile][google.cloud.dialogflow.v2.Conversation.conversation_profile]
   * is configured for a dialogflow agent, conversation will start from `Automated Agent Stage`,
   * otherwise, it will start from `Assist Stage`. And during `Automated Agent Stage`, once an
   * [Intent][google.cloud.dialogflow.v2.Intent] with
   * [Intent.live_agent_handoff][google.cloud.dialogflow.v2.Intent.live_agent_handoff] is triggered,
   * conversation will transfer to Assist Stage.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
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
   * [Conversation.conversation_profile][google.cloud.dialogflow.v2.Conversation.conversation_profile]
   * is configured for a dialogflow agent, conversation will start from `Automated Agent Stage`,
   * otherwise, it will start from `Assist Stage`. And during `Automated Agent Stage`, once an
   * [Intent][google.cloud.dialogflow.v2.Intent] with
   * [Intent.live_agent_handoff][google.cloud.dialogflow.v2.Intent.live_agent_handoff] is triggered,
   * conversation will transfer to Assist Stage.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
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
   * [Conversation.conversation_profile][google.cloud.dialogflow.v2.Conversation.conversation_profile]
   * is configured for a dialogflow agent, conversation will start from `Automated Agent Stage`,
   * otherwise, it will start from `Assist Stage`. And during `Automated Agent Stage`, once an
   * [Intent][google.cloud.dialogflow.v2.Intent] with
   * [Intent.live_agent_handoff][google.cloud.dialogflow.v2.Intent.live_agent_handoff] is triggered,
   * conversation will transfer to Assist Stage.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationsClient conversationsClient = ConversationsClient.create()) {
   *   String parent = ProjectName.of("[PROJECT]").toString();
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
   * [Conversation.conversation_profile][google.cloud.dialogflow.v2.Conversation.conversation_profile]
   * is configured for a dialogflow agent, conversation will start from `Automated Agent Stage`,
   * otherwise, it will start from `Assist Stage`. And during `Automated Agent Stage`, once an
   * [Intent][google.cloud.dialogflow.v2.Intent] with
   * [Intent.live_agent_handoff][google.cloud.dialogflow.v2.Intent.live_agent_handoff] is triggered,
   * conversation will transfer to Assist Stage.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationsClient conversationsClient = ConversationsClient.create()) {
   *   CreateConversationRequest request =
   *       CreateConversationRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
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
   * [Conversation.conversation_profile][google.cloud.dialogflow.v2.Conversation.conversation_profile]
   * is configured for a dialogflow agent, conversation will start from `Automated Agent Stage`,
   * otherwise, it will start from `Assist Stage`. And during `Automated Agent Stage`, once an
   * [Intent][google.cloud.dialogflow.v2.Intent] with
   * [Intent.live_agent_handoff][google.cloud.dialogflow.v2.Intent.live_agent_handoff] is triggered,
   * conversation will transfer to Assist Stage.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationsClient conversationsClient = ConversationsClient.create()) {
   *   CreateConversationRequest request =
   *       CreateConversationRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
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
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
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
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
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
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationsClient conversationsClient = ConversationsClient.create()) {
   *   String parent = ProjectName.of("[PROJECT]").toString();
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
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationsClient conversationsClient = ConversationsClient.create()) {
   *   ListConversationsRequest request =
   *       ListConversationsRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
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
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationsClient conversationsClient = ConversationsClient.create()) {
   *   ListConversationsRequest request =
   *       ListConversationsRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
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
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationsClient conversationsClient = ConversationsClient.create()) {
   *   ListConversationsRequest request =
   *       ListConversationsRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListConversationsResponse response =
   *         conversationsClient.listConversationsCallable().call(request);
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
   * Retrieves the specific conversation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
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
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
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
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
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
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
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
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
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
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
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
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
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
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
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
   * Data ingestion API. Ingests context references for an existing conversation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationsClient conversationsClient = ConversationsClient.create()) {
   *   ConversationName conversation =
   *       ConversationName.ofProjectLocationConversationName(
   *           "[PROJECT]", "[LOCATION]", "[CONVERSATION]");
   *   Map<String, Conversation.ContextReference> contextReferences = new HashMap<>();
   *   IngestContextReferencesResponse response =
   *       conversationsClient.ingestContextReferences(conversation, contextReferences);
   * }
   * }</pre>
   *
   * @param conversation Required. Resource identifier of the conversation to ingest context
   *     information for. Format: `projects/&lt;Project ID&gt;/locations/&lt;Location
   *     ID&gt;/conversations/&lt;Conversation ID&gt;`.
   * @param contextReferences Required. The context references to ingest. The key is the name of the
   *     context reference and the value contains the contents of the context reference. The key is
   *     used to incorporate ingested context references to enhance the generator.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final IngestContextReferencesResponse ingestContextReferences(
      ConversationName conversation, Map<String, Conversation.ContextReference> contextReferences) {
    IngestContextReferencesRequest request =
        IngestContextReferencesRequest.newBuilder()
            .setConversation(conversation == null ? null : conversation.toString())
            .putAllContextReferences(contextReferences)
            .build();
    return ingestContextReferences(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Data ingestion API. Ingests context references for an existing conversation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationsClient conversationsClient = ConversationsClient.create()) {
   *   String conversation =
   *       ConversationName.ofProjectConversationName("[PROJECT]", "[CONVERSATION]").toString();
   *   Map<String, Conversation.ContextReference> contextReferences = new HashMap<>();
   *   IngestContextReferencesResponse response =
   *       conversationsClient.ingestContextReferences(conversation, contextReferences);
   * }
   * }</pre>
   *
   * @param conversation Required. Resource identifier of the conversation to ingest context
   *     information for. Format: `projects/&lt;Project ID&gt;/locations/&lt;Location
   *     ID&gt;/conversations/&lt;Conversation ID&gt;`.
   * @param contextReferences Required. The context references to ingest. The key is the name of the
   *     context reference and the value contains the contents of the context reference. The key is
   *     used to incorporate ingested context references to enhance the generator.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final IngestContextReferencesResponse ingestContextReferences(
      String conversation, Map<String, Conversation.ContextReference> contextReferences) {
    IngestContextReferencesRequest request =
        IngestContextReferencesRequest.newBuilder()
            .setConversation(conversation)
            .putAllContextReferences(contextReferences)
            .build();
    return ingestContextReferences(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Data ingestion API. Ingests context references for an existing conversation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationsClient conversationsClient = ConversationsClient.create()) {
   *   IngestContextReferencesRequest request =
   *       IngestContextReferencesRequest.newBuilder()
   *           .setConversation(
   *               ConversationName.ofProjectLocationConversationName(
   *                       "[PROJECT]", "[LOCATION]", "[CONVERSATION]")
   *                   .toString())
   *           .putAllContextReferences(new HashMap<String, Conversation.ContextReference>())
   *           .build();
   *   IngestContextReferencesResponse response =
   *       conversationsClient.ingestContextReferences(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final IngestContextReferencesResponse ingestContextReferences(
      IngestContextReferencesRequest request) {
    return ingestContextReferencesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Data ingestion API. Ingests context references for an existing conversation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationsClient conversationsClient = ConversationsClient.create()) {
   *   IngestContextReferencesRequest request =
   *       IngestContextReferencesRequest.newBuilder()
   *           .setConversation(
   *               ConversationName.ofProjectLocationConversationName(
   *                       "[PROJECT]", "[LOCATION]", "[CONVERSATION]")
   *                   .toString())
   *           .putAllContextReferences(new HashMap<String, Conversation.ContextReference>())
   *           .build();
   *   ApiFuture<IngestContextReferencesResponse> future =
   *       conversationsClient.ingestContextReferencesCallable().futureCall(request);
   *   // Do something.
   *   IngestContextReferencesResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<IngestContextReferencesRequest, IngestContextReferencesResponse>
      ingestContextReferencesCallable() {
    return stub.ingestContextReferencesCallable();
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
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
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
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationsClient conversationsClient = ConversationsClient.create()) {
   *   String parent =
   *       ConversationName.ofProjectConversationName("[PROJECT]", "[CONVERSATION]").toString();
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
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationsClient conversationsClient = ConversationsClient.create()) {
   *   ListMessagesRequest request =
   *       ListMessagesRequest.newBuilder()
   *           .setParent(
   *               ConversationName.ofProjectConversationName("[PROJECT]", "[CONVERSATION]")
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
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationsClient conversationsClient = ConversationsClient.create()) {
   *   ListMessagesRequest request =
   *       ListMessagesRequest.newBuilder()
   *           .setParent(
   *               ConversationName.ofProjectConversationName("[PROJECT]", "[CONVERSATION]")
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
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationsClient conversationsClient = ConversationsClient.create()) {
   *   ListMessagesRequest request =
   *       ListMessagesRequest.newBuilder()
   *           .setParent(
   *               ConversationName.ofProjectConversationName("[PROJECT]", "[CONVERSATION]")
   *                   .toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListMessagesResponse response = conversationsClient.listMessagesCallable().call(request);
   *     for (Message element : response.getMessagesList()) {
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Suggests summary for a conversation based on specific historical messages. The range of the
   * messages to be used for summary can be specified in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationsClient conversationsClient = ConversationsClient.create()) {
   *   ConversationName conversation =
   *       ConversationName.ofProjectConversationName("[PROJECT]", "[CONVERSATION]");
   *   SuggestConversationSummaryResponse response =
   *       conversationsClient.suggestConversationSummary(conversation);
   * }
   * }</pre>
   *
   * @param conversation Required. The conversation to fetch suggestion for. Format:
   *     `projects/&lt;Project ID&gt;/locations/&lt;Location ID&gt;/conversations/&lt;Conversation
   *     ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SuggestConversationSummaryResponse suggestConversationSummary(
      ConversationName conversation) {
    SuggestConversationSummaryRequest request =
        SuggestConversationSummaryRequest.newBuilder()
            .setConversation(conversation == null ? null : conversation.toString())
            .build();
    return suggestConversationSummary(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Suggests summary for a conversation based on specific historical messages. The range of the
   * messages to be used for summary can be specified in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationsClient conversationsClient = ConversationsClient.create()) {
   *   String conversation =
   *       ConversationName.ofProjectConversationName("[PROJECT]", "[CONVERSATION]").toString();
   *   SuggestConversationSummaryResponse response =
   *       conversationsClient.suggestConversationSummary(conversation);
   * }
   * }</pre>
   *
   * @param conversation Required. The conversation to fetch suggestion for. Format:
   *     `projects/&lt;Project ID&gt;/locations/&lt;Location ID&gt;/conversations/&lt;Conversation
   *     ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SuggestConversationSummaryResponse suggestConversationSummary(String conversation) {
    SuggestConversationSummaryRequest request =
        SuggestConversationSummaryRequest.newBuilder().setConversation(conversation).build();
    return suggestConversationSummary(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Suggests summary for a conversation based on specific historical messages. The range of the
   * messages to be used for summary can be specified in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationsClient conversationsClient = ConversationsClient.create()) {
   *   SuggestConversationSummaryRequest request =
   *       SuggestConversationSummaryRequest.newBuilder()
   *           .setConversation(
   *               ConversationName.ofProjectConversationName("[PROJECT]", "[CONVERSATION]")
   *                   .toString())
   *           .setLatestMessage(
   *               MessageName.ofProjectConversationMessageName(
   *                       "[PROJECT]", "[CONVERSATION]", "[MESSAGE]")
   *                   .toString())
   *           .setContextSize(1116903569)
   *           .setAssistQueryParams(AssistQueryParameters.newBuilder().build())
   *           .build();
   *   SuggestConversationSummaryResponse response =
   *       conversationsClient.suggestConversationSummary(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SuggestConversationSummaryResponse suggestConversationSummary(
      SuggestConversationSummaryRequest request) {
    return suggestConversationSummaryCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Suggests summary for a conversation based on specific historical messages. The range of the
   * messages to be used for summary can be specified in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationsClient conversationsClient = ConversationsClient.create()) {
   *   SuggestConversationSummaryRequest request =
   *       SuggestConversationSummaryRequest.newBuilder()
   *           .setConversation(
   *               ConversationName.ofProjectConversationName("[PROJECT]", "[CONVERSATION]")
   *                   .toString())
   *           .setLatestMessage(
   *               MessageName.ofProjectConversationMessageName(
   *                       "[PROJECT]", "[CONVERSATION]", "[MESSAGE]")
   *                   .toString())
   *           .setContextSize(1116903569)
   *           .setAssistQueryParams(AssistQueryParameters.newBuilder().build())
   *           .build();
   *   ApiFuture<SuggestConversationSummaryResponse> future =
   *       conversationsClient.suggestConversationSummaryCallable().futureCall(request);
   *   // Do something.
   *   SuggestConversationSummaryResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SuggestConversationSummaryRequest, SuggestConversationSummaryResponse>
      suggestConversationSummaryCallable() {
    return stub.suggestConversationSummaryCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Generates and returns a summary for a conversation that does not have a resource created for
   * it.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationsClient conversationsClient = ConversationsClient.create()) {
   *   GenerateStatelessSummaryRequest request =
   *       GenerateStatelessSummaryRequest.newBuilder()
   *           .setStatelessConversation(
   *               GenerateStatelessSummaryRequest.MinimalConversation.newBuilder().build())
   *           .setConversationProfile(ConversationProfile.newBuilder().build())
   *           .setLatestMessage(
   *               MessageName.ofProjectConversationMessageName(
   *                       "[PROJECT]", "[CONVERSATION]", "[MESSAGE]")
   *                   .toString())
   *           .setMaxContextSize(-1134084212)
   *           .build();
   *   GenerateStatelessSummaryResponse response =
   *       conversationsClient.generateStatelessSummary(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GenerateStatelessSummaryResponse generateStatelessSummary(
      GenerateStatelessSummaryRequest request) {
    return generateStatelessSummaryCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Generates and returns a summary for a conversation that does not have a resource created for
   * it.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationsClient conversationsClient = ConversationsClient.create()) {
   *   GenerateStatelessSummaryRequest request =
   *       GenerateStatelessSummaryRequest.newBuilder()
   *           .setStatelessConversation(
   *               GenerateStatelessSummaryRequest.MinimalConversation.newBuilder().build())
   *           .setConversationProfile(ConversationProfile.newBuilder().build())
   *           .setLatestMessage(
   *               MessageName.ofProjectConversationMessageName(
   *                       "[PROJECT]", "[CONVERSATION]", "[MESSAGE]")
   *                   .toString())
   *           .setMaxContextSize(-1134084212)
   *           .build();
   *   ApiFuture<GenerateStatelessSummaryResponse> future =
   *       conversationsClient.generateStatelessSummaryCallable().futureCall(request);
   *   // Do something.
   *   GenerateStatelessSummaryResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GenerateStatelessSummaryRequest, GenerateStatelessSummaryResponse>
      generateStatelessSummaryCallable() {
    return stub.generateStatelessSummaryCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Generates and returns a suggestion for a conversation that does not have a resource created for
   * it.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationsClient conversationsClient = ConversationsClient.create()) {
   *   GenerateStatelessSuggestionRequest request =
   *       GenerateStatelessSuggestionRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .putAllContextReferences(new HashMap<String, Conversation.ContextReference>())
   *           .setConversationContext(ConversationContext.newBuilder().build())
   *           .addAllTriggerEvents(new ArrayList<TriggerEvent>())
   *           .build();
   *   GenerateStatelessSuggestionResponse response =
   *       conversationsClient.generateStatelessSuggestion(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GenerateStatelessSuggestionResponse generateStatelessSuggestion(
      GenerateStatelessSuggestionRequest request) {
    return generateStatelessSuggestionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Generates and returns a suggestion for a conversation that does not have a resource created for
   * it.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationsClient conversationsClient = ConversationsClient.create()) {
   *   GenerateStatelessSuggestionRequest request =
   *       GenerateStatelessSuggestionRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .putAllContextReferences(new HashMap<String, Conversation.ContextReference>())
   *           .setConversationContext(ConversationContext.newBuilder().build())
   *           .addAllTriggerEvents(new ArrayList<TriggerEvent>())
   *           .build();
   *   ApiFuture<GenerateStatelessSuggestionResponse> future =
   *       conversationsClient.generateStatelessSuggestionCallable().futureCall(request);
   *   // Do something.
   *   GenerateStatelessSuggestionResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          GenerateStatelessSuggestionRequest, GenerateStatelessSuggestionResponse>
      generateStatelessSuggestionCallable() {
    return stub.generateStatelessSuggestionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get answers for the given query based on knowledge documents.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationsClient conversationsClient = ConversationsClient.create()) {
   *   SearchKnowledgeRequest request =
   *       SearchKnowledgeRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setQuery(TextInput.newBuilder().build())
   *           .setConversationProfile(
   *               ConversationProfileName.ofProjectConversationProfileName(
   *                       "[PROJECT]", "[CONVERSATION_PROFILE]")
   *                   .toString())
   *           .setSessionId("sessionId607796817")
   *           .setConversation(
   *               ConversationName.ofProjectConversationName("[PROJECT]", "[CONVERSATION]")
   *                   .toString())
   *           .setLatestMessage(
   *               MessageName.ofProjectConversationMessageName(
   *                       "[PROJECT]", "[CONVERSATION]", "[MESSAGE]")
   *                   .toString())
   *           .setEndUserMetadata(Struct.newBuilder().build())
   *           .setSearchConfig(SearchKnowledgeRequest.SearchConfig.newBuilder().build())
   *           .setExactSearch(true)
   *           .build();
   *   SearchKnowledgeResponse response = conversationsClient.searchKnowledge(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchKnowledgeResponse searchKnowledge(SearchKnowledgeRequest request) {
    return searchKnowledgeCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get answers for the given query based on knowledge documents.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationsClient conversationsClient = ConversationsClient.create()) {
   *   SearchKnowledgeRequest request =
   *       SearchKnowledgeRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setQuery(TextInput.newBuilder().build())
   *           .setConversationProfile(
   *               ConversationProfileName.ofProjectConversationProfileName(
   *                       "[PROJECT]", "[CONVERSATION_PROFILE]")
   *                   .toString())
   *           .setSessionId("sessionId607796817")
   *           .setConversation(
   *               ConversationName.ofProjectConversationName("[PROJECT]", "[CONVERSATION]")
   *                   .toString())
   *           .setLatestMessage(
   *               MessageName.ofProjectConversationMessageName(
   *                       "[PROJECT]", "[CONVERSATION]", "[MESSAGE]")
   *                   .toString())
   *           .setEndUserMetadata(Struct.newBuilder().build())
   *           .setSearchConfig(SearchKnowledgeRequest.SearchConfig.newBuilder().build())
   *           .setExactSearch(true)
   *           .build();
   *   ApiFuture<SearchKnowledgeResponse> future =
   *       conversationsClient.searchKnowledgeCallable().futureCall(request);
   *   // Do something.
   *   SearchKnowledgeResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SearchKnowledgeRequest, SearchKnowledgeResponse>
      searchKnowledgeCallable() {
    return stub.searchKnowledgeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Generates all the suggestions using generators configured in the conversation profile. A
   * generator is used only if its trigger event is matched.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationsClient conversationsClient = ConversationsClient.create()) {
   *   ConversationName conversation =
   *       ConversationName.ofProjectConversationName("[PROJECT]", "[CONVERSATION]");
   *   GenerateSuggestionsResponse response = conversationsClient.generateSuggestions(conversation);
   * }
   * }</pre>
   *
   * @param conversation Required. The conversation for which the suggestions are generated. Format:
   *     `projects/&lt;Project ID&gt;/locations/&lt;Location ID&gt;/conversations/&lt;Conversation
   *     ID&gt;`.
   *     <p>The conversation must be created with a conversation profile which has generators
   *     configured in it to be able to get suggestions.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GenerateSuggestionsResponse generateSuggestions(ConversationName conversation) {
    GenerateSuggestionsRequest request =
        GenerateSuggestionsRequest.newBuilder()
            .setConversation(conversation == null ? null : conversation.toString())
            .build();
    return generateSuggestions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Generates all the suggestions using generators configured in the conversation profile. A
   * generator is used only if its trigger event is matched.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationsClient conversationsClient = ConversationsClient.create()) {
   *   String conversation =
   *       ConversationName.ofProjectConversationName("[PROJECT]", "[CONVERSATION]").toString();
   *   GenerateSuggestionsResponse response = conversationsClient.generateSuggestions(conversation);
   * }
   * }</pre>
   *
   * @param conversation Required. The conversation for which the suggestions are generated. Format:
   *     `projects/&lt;Project ID&gt;/locations/&lt;Location ID&gt;/conversations/&lt;Conversation
   *     ID&gt;`.
   *     <p>The conversation must be created with a conversation profile which has generators
   *     configured in it to be able to get suggestions.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GenerateSuggestionsResponse generateSuggestions(String conversation) {
    GenerateSuggestionsRequest request =
        GenerateSuggestionsRequest.newBuilder().setConversation(conversation).build();
    return generateSuggestions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Generates all the suggestions using generators configured in the conversation profile. A
   * generator is used only if its trigger event is matched.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationsClient conversationsClient = ConversationsClient.create()) {
   *   GenerateSuggestionsRequest request =
   *       GenerateSuggestionsRequest.newBuilder()
   *           .setConversation(
   *               ConversationName.ofProjectConversationName("[PROJECT]", "[CONVERSATION]")
   *                   .toString())
   *           .setLatestMessage(
   *               MessageName.ofProjectConversationMessageName(
   *                       "[PROJECT]", "[CONVERSATION]", "[MESSAGE]")
   *                   .toString())
   *           .addAllTriggerEvents(new ArrayList<TriggerEvent>())
   *           .build();
   *   GenerateSuggestionsResponse response = conversationsClient.generateSuggestions(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GenerateSuggestionsResponse generateSuggestions(GenerateSuggestionsRequest request) {
    return generateSuggestionsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Generates all the suggestions using generators configured in the conversation profile. A
   * generator is used only if its trigger event is matched.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationsClient conversationsClient = ConversationsClient.create()) {
   *   GenerateSuggestionsRequest request =
   *       GenerateSuggestionsRequest.newBuilder()
   *           .setConversation(
   *               ConversationName.ofProjectConversationName("[PROJECT]", "[CONVERSATION]")
   *                   .toString())
   *           .setLatestMessage(
   *               MessageName.ofProjectConversationMessageName(
   *                       "[PROJECT]", "[CONVERSATION]", "[MESSAGE]")
   *                   .toString())
   *           .addAllTriggerEvents(new ArrayList<TriggerEvent>())
   *           .build();
   *   ApiFuture<GenerateSuggestionsResponse> future =
   *       conversationsClient.generateSuggestionsCallable().futureCall(request);
   *   // Do something.
   *   GenerateSuggestionsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GenerateSuggestionsRequest, GenerateSuggestionsResponse>
      generateSuggestionsCallable() {
    return stub.generateSuggestionsCallable();
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
   * try (ConversationsClient conversationsClient = ConversationsClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : conversationsClient.listLocations(request).iterateAll()) {
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
   * try (ConversationsClient conversationsClient = ConversationsClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       conversationsClient.listLocationsPagedCallable().futureCall(request);
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
   * try (ConversationsClient conversationsClient = ConversationsClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response = conversationsClient.listLocationsCallable().call(request);
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
   * try (ConversationsClient conversationsClient = ConversationsClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = conversationsClient.getLocation(request);
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
   * try (ConversationsClient conversationsClient = ConversationsClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future = conversationsClient.getLocationCallable().futureCall(request);
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
          input -> new ListMessagesPagedResponse(input),
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
