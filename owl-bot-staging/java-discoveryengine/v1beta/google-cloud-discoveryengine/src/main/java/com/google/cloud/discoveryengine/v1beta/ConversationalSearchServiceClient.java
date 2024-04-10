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

package com.google.cloud.discoveryengine.v1beta;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.discoveryengine.v1beta.stub.ConversationalSearchServiceStub;
import com.google.cloud.discoveryengine.v1beta.stub.ConversationalSearchServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service for conversational search.
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
 * try (ConversationalSearchServiceClient conversationalSearchServiceClient =
 *     ConversationalSearchServiceClient.create()) {
 *   ConversationName name =
 *       ConversationName.ofProjectLocationDataStoreConversationName(
 *           "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[CONVERSATION]");
 *   TextInput query = TextInput.newBuilder().build();
 *   ConverseConversationResponse response =
 *       conversationalSearchServiceClient.converseConversation(name, query);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the ConversationalSearchServiceClient object to clean up
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
 *      <td><p> ConverseConversation</td>
 *      <td><p> Converses a conversation.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> converseConversation(ConverseConversationRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> converseConversation(ConversationName name, TextInput query)
 *           <li><p> converseConversation(String name, TextInput query)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> converseConversationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateConversation</td>
 *      <td><p> Creates a Conversation.
 * <p>  If the [Conversation][google.cloud.discoveryengine.v1beta.Conversation] to create already exists, an ALREADY_EXISTS error is returned.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createConversation(CreateConversationRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createConversation(DataStoreName parent, Conversation conversation)
 *           <li><p> createConversation(String parent, Conversation conversation)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createConversationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteConversation</td>
 *      <td><p> Deletes a Conversation.
 * <p>  If the [Conversation][google.cloud.discoveryengine.v1beta.Conversation] to delete does not exist, a NOT_FOUND error is returned.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteConversation(DeleteConversationRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteConversation(ConversationName name)
 *           <li><p> deleteConversation(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteConversationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateConversation</td>
 *      <td><p> Updates a Conversation.
 * <p>  [Conversation][google.cloud.discoveryengine.v1beta.Conversation] action type cannot be changed. If the [Conversation][google.cloud.discoveryengine.v1beta.Conversation] to update does not exist, a NOT_FOUND error is returned.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateConversation(UpdateConversationRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateConversation(Conversation conversation, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateConversationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetConversation</td>
 *      <td><p> Gets a Conversation.</td>
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
 *      <td><p> ListConversations</td>
 *      <td><p> Lists all Conversations by their parent [DataStore][google.cloud.discoveryengine.v1beta.DataStore].</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listConversations(ListConversationsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listConversations(DataStoreName parent)
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
 *      <td><p> AnswerQuery</td>
 *      <td><p> Answer query method.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> answerQuery(AnswerQueryRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> answerQueryCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetAnswer</td>
 *      <td><p> Gets a Answer.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getAnswer(GetAnswerRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getAnswer(AnswerName name)
 *           <li><p> getAnswer(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getAnswerCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateSession</td>
 *      <td><p> Creates a Session.
 * <p>  If the [Session][google.cloud.discoveryengine.v1beta.Session] to create already exists, an ALREADY_EXISTS error is returned.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createSession(CreateSessionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createSession(DataStoreName parent, Session session)
 *           <li><p> createSession(String parent, Session session)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createSessionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteSession</td>
 *      <td><p> Deletes a Session.
 * <p>  If the [Session][google.cloud.discoveryengine.v1beta.Session] to delete does not exist, a NOT_FOUND error is returned.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteSession(DeleteSessionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteSession(SessionName name)
 *           <li><p> deleteSession(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteSessionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateSession</td>
 *      <td><p> Updates a Session.
 * <p>  [Session][google.cloud.discoveryengine.v1beta.Session] action type cannot be changed. If the [Session][google.cloud.discoveryengine.v1beta.Session] to update does not exist, a NOT_FOUND error is returned.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateSession(UpdateSessionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateSession(Session session, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateSessionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetSession</td>
 *      <td><p> Gets a Session.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getSession(GetSessionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getSession(SessionName name)
 *           <li><p> getSession(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getSessionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListSessions</td>
 *      <td><p> Lists all Sessions by their parent [DataStore][google.cloud.discoveryengine.v1beta.DataStore].</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listSessions(ListSessionsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listSessions(DataStoreName parent)
 *           <li><p> listSessions(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listSessionsPagedCallable()
 *           <li><p> listSessionsCallable()
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
 * <p>This class can be customized by passing in a custom instance of
 * ConversationalSearchServiceSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ConversationalSearchServiceSettings conversationalSearchServiceSettings =
 *     ConversationalSearchServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ConversationalSearchServiceClient conversationalSearchServiceClient =
 *     ConversationalSearchServiceClient.create(conversationalSearchServiceSettings);
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
 * ConversationalSearchServiceSettings conversationalSearchServiceSettings =
 *     ConversationalSearchServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ConversationalSearchServiceClient conversationalSearchServiceClient =
 *     ConversationalSearchServiceClient.create(conversationalSearchServiceSettings);
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
 * ConversationalSearchServiceSettings conversationalSearchServiceSettings =
 *     ConversationalSearchServiceSettings.newHttpJsonBuilder().build();
 * ConversationalSearchServiceClient conversationalSearchServiceClient =
 *     ConversationalSearchServiceClient.create(conversationalSearchServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class ConversationalSearchServiceClient implements BackgroundResource {
  private final ConversationalSearchServiceSettings settings;
  private final ConversationalSearchServiceStub stub;

  /** Constructs an instance of ConversationalSearchServiceClient with default settings. */
  public static final ConversationalSearchServiceClient create() throws IOException {
    return create(ConversationalSearchServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ConversationalSearchServiceClient, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final ConversationalSearchServiceClient create(
      ConversationalSearchServiceSettings settings) throws IOException {
    return new ConversationalSearchServiceClient(settings);
  }

  /**
   * Constructs an instance of ConversationalSearchServiceClient, using the given stub for making
   * calls. This is for advanced usage - prefer using create(ConversationalSearchServiceSettings).
   */
  public static final ConversationalSearchServiceClient create(
      ConversationalSearchServiceStub stub) {
    return new ConversationalSearchServiceClient(stub);
  }

  /**
   * Constructs an instance of ConversationalSearchServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected ConversationalSearchServiceClient(ConversationalSearchServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((ConversationalSearchServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected ConversationalSearchServiceClient(ConversationalSearchServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final ConversationalSearchServiceSettings getSettings() {
    return settings;
  }

  public ConversationalSearchServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Converses a conversation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationalSearchServiceClient conversationalSearchServiceClient =
   *     ConversationalSearchServiceClient.create()) {
   *   ConversationName name =
   *       ConversationName.ofProjectLocationDataStoreConversationName(
   *           "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[CONVERSATION]");
   *   TextInput query = TextInput.newBuilder().build();
   *   ConverseConversationResponse response =
   *       conversationalSearchServiceClient.converseConversation(name, query);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Conversation to get. Format:
   *     `projects/{project_number}/locations/{location_id}/collections/{collection}/dataStores/{data_store_id}/conversations/{conversation_id}`.
   *     Use
   *     `projects/{project_number}/locations/{location_id}/collections/{collection}/dataStores/{data_store_id}/conversations/-`
   *     to activate auto session mode, which automatically creates a new conversation inside a
   *     ConverseConversation session.
   * @param query Required. Current user input.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ConverseConversationResponse converseConversation(
      ConversationName name, TextInput query) {
    ConverseConversationRequest request =
        ConverseConversationRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setQuery(query)
            .build();
    return converseConversation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Converses a conversation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationalSearchServiceClient conversationalSearchServiceClient =
   *     ConversationalSearchServiceClient.create()) {
   *   String name =
   *       ConversationName.ofProjectLocationDataStoreConversationName(
   *               "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[CONVERSATION]")
   *           .toString();
   *   TextInput query = TextInput.newBuilder().build();
   *   ConverseConversationResponse response =
   *       conversationalSearchServiceClient.converseConversation(name, query);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Conversation to get. Format:
   *     `projects/{project_number}/locations/{location_id}/collections/{collection}/dataStores/{data_store_id}/conversations/{conversation_id}`.
   *     Use
   *     `projects/{project_number}/locations/{location_id}/collections/{collection}/dataStores/{data_store_id}/conversations/-`
   *     to activate auto session mode, which automatically creates a new conversation inside a
   *     ConverseConversation session.
   * @param query Required. Current user input.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ConverseConversationResponse converseConversation(String name, TextInput query) {
    ConverseConversationRequest request =
        ConverseConversationRequest.newBuilder().setName(name).setQuery(query).build();
    return converseConversation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Converses a conversation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationalSearchServiceClient conversationalSearchServiceClient =
   *     ConversationalSearchServiceClient.create()) {
   *   ConverseConversationRequest request =
   *       ConverseConversationRequest.newBuilder()
   *           .setName(
   *               ConversationName.ofProjectLocationDataStoreConversationName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[CONVERSATION]")
   *                   .toString())
   *           .setQuery(TextInput.newBuilder().build())
   *           .setServingConfig(
   *               ServingConfigName.ofProjectLocationDataStoreServingConfigName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SERVING_CONFIG]")
   *                   .toString())
   *           .setConversation(Conversation.newBuilder().build())
   *           .setSafeSearch(true)
   *           .putAllUserLabels(new HashMap<String, String>())
   *           .setSummarySpec(SearchRequest.ContentSearchSpec.SummarySpec.newBuilder().build())
   *           .setFilter("filter-1274492040")
   *           .setBoostSpec(SearchRequest.BoostSpec.newBuilder().build())
   *           .build();
   *   ConverseConversationResponse response =
   *       conversationalSearchServiceClient.converseConversation(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ConverseConversationResponse converseConversation(
      ConverseConversationRequest request) {
    return converseConversationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Converses a conversation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationalSearchServiceClient conversationalSearchServiceClient =
   *     ConversationalSearchServiceClient.create()) {
   *   ConverseConversationRequest request =
   *       ConverseConversationRequest.newBuilder()
   *           .setName(
   *               ConversationName.ofProjectLocationDataStoreConversationName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[CONVERSATION]")
   *                   .toString())
   *           .setQuery(TextInput.newBuilder().build())
   *           .setServingConfig(
   *               ServingConfigName.ofProjectLocationDataStoreServingConfigName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SERVING_CONFIG]")
   *                   .toString())
   *           .setConversation(Conversation.newBuilder().build())
   *           .setSafeSearch(true)
   *           .putAllUserLabels(new HashMap<String, String>())
   *           .setSummarySpec(SearchRequest.ContentSearchSpec.SummarySpec.newBuilder().build())
   *           .setFilter("filter-1274492040")
   *           .setBoostSpec(SearchRequest.BoostSpec.newBuilder().build())
   *           .build();
   *   ApiFuture<ConverseConversationResponse> future =
   *       conversationalSearchServiceClient.converseConversationCallable().futureCall(request);
   *   // Do something.
   *   ConverseConversationResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ConverseConversationRequest, ConverseConversationResponse>
      converseConversationCallable() {
    return stub.converseConversationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Conversation.
   *
   * <p>If the [Conversation][google.cloud.discoveryengine.v1beta.Conversation] to create already
   * exists, an ALREADY_EXISTS error is returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationalSearchServiceClient conversationalSearchServiceClient =
   *     ConversationalSearchServiceClient.create()) {
   *   DataStoreName parent =
   *       DataStoreName.ofProjectLocationDataStoreName("[PROJECT]", "[LOCATION]", "[DATA_STORE]");
   *   Conversation conversation = Conversation.newBuilder().build();
   *   Conversation response =
   *       conversationalSearchServiceClient.createConversation(parent, conversation);
   * }
   * }</pre>
   *
   * @param parent Required. Full resource name of parent data store. Format:
   *     `projects/{project_number}/locations/{location_id}/collections/{collection}/dataStores/{data_store_id}`
   * @param conversation Required. The conversation to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Conversation createConversation(DataStoreName parent, Conversation conversation) {
    CreateConversationRequest request =
        CreateConversationRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setConversation(conversation)
            .build();
    return createConversation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Conversation.
   *
   * <p>If the [Conversation][google.cloud.discoveryengine.v1beta.Conversation] to create already
   * exists, an ALREADY_EXISTS error is returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationalSearchServiceClient conversationalSearchServiceClient =
   *     ConversationalSearchServiceClient.create()) {
   *   String parent =
   *       DataStoreName.ofProjectLocationDataStoreName("[PROJECT]", "[LOCATION]", "[DATA_STORE]")
   *           .toString();
   *   Conversation conversation = Conversation.newBuilder().build();
   *   Conversation response =
   *       conversationalSearchServiceClient.createConversation(parent, conversation);
   * }
   * }</pre>
   *
   * @param parent Required. Full resource name of parent data store. Format:
   *     `projects/{project_number}/locations/{location_id}/collections/{collection}/dataStores/{data_store_id}`
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
   * Creates a Conversation.
   *
   * <p>If the [Conversation][google.cloud.discoveryengine.v1beta.Conversation] to create already
   * exists, an ALREADY_EXISTS error is returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationalSearchServiceClient conversationalSearchServiceClient =
   *     ConversationalSearchServiceClient.create()) {
   *   CreateConversationRequest request =
   *       CreateConversationRequest.newBuilder()
   *           .setParent(
   *               DataStoreName.ofProjectLocationDataStoreName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]")
   *                   .toString())
   *           .setConversation(Conversation.newBuilder().build())
   *           .build();
   *   Conversation response = conversationalSearchServiceClient.createConversation(request);
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
   * Creates a Conversation.
   *
   * <p>If the [Conversation][google.cloud.discoveryengine.v1beta.Conversation] to create already
   * exists, an ALREADY_EXISTS error is returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationalSearchServiceClient conversationalSearchServiceClient =
   *     ConversationalSearchServiceClient.create()) {
   *   CreateConversationRequest request =
   *       CreateConversationRequest.newBuilder()
   *           .setParent(
   *               DataStoreName.ofProjectLocationDataStoreName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]")
   *                   .toString())
   *           .setConversation(Conversation.newBuilder().build())
   *           .build();
   *   ApiFuture<Conversation> future =
   *       conversationalSearchServiceClient.createConversationCallable().futureCall(request);
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
   * Deletes a Conversation.
   *
   * <p>If the [Conversation][google.cloud.discoveryengine.v1beta.Conversation] to delete does not
   * exist, a NOT_FOUND error is returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationalSearchServiceClient conversationalSearchServiceClient =
   *     ConversationalSearchServiceClient.create()) {
   *   ConversationName name =
   *       ConversationName.ofProjectLocationDataStoreConversationName(
   *           "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[CONVERSATION]");
   *   conversationalSearchServiceClient.deleteConversation(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Conversation to delete. Format:
   *     `projects/{project_number}/locations/{location_id}/collections/{collection}/dataStores/{data_store_id}/conversations/{conversation_id}`
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
   * Deletes a Conversation.
   *
   * <p>If the [Conversation][google.cloud.discoveryengine.v1beta.Conversation] to delete does not
   * exist, a NOT_FOUND error is returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationalSearchServiceClient conversationalSearchServiceClient =
   *     ConversationalSearchServiceClient.create()) {
   *   String name =
   *       ConversationName.ofProjectLocationDataStoreConversationName(
   *               "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[CONVERSATION]")
   *           .toString();
   *   conversationalSearchServiceClient.deleteConversation(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Conversation to delete. Format:
   *     `projects/{project_number}/locations/{location_id}/collections/{collection}/dataStores/{data_store_id}/conversations/{conversation_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteConversation(String name) {
    DeleteConversationRequest request =
        DeleteConversationRequest.newBuilder().setName(name).build();
    deleteConversation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Conversation.
   *
   * <p>If the [Conversation][google.cloud.discoveryengine.v1beta.Conversation] to delete does not
   * exist, a NOT_FOUND error is returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationalSearchServiceClient conversationalSearchServiceClient =
   *     ConversationalSearchServiceClient.create()) {
   *   DeleteConversationRequest request =
   *       DeleteConversationRequest.newBuilder()
   *           .setName(
   *               ConversationName.ofProjectLocationDataStoreConversationName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[CONVERSATION]")
   *                   .toString())
   *           .build();
   *   conversationalSearchServiceClient.deleteConversation(request);
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
   * Deletes a Conversation.
   *
   * <p>If the [Conversation][google.cloud.discoveryengine.v1beta.Conversation] to delete does not
   * exist, a NOT_FOUND error is returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationalSearchServiceClient conversationalSearchServiceClient =
   *     ConversationalSearchServiceClient.create()) {
   *   DeleteConversationRequest request =
   *       DeleteConversationRequest.newBuilder()
   *           .setName(
   *               ConversationName.ofProjectLocationDataStoreConversationName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[CONVERSATION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       conversationalSearchServiceClient.deleteConversationCallable().futureCall(request);
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
   * Updates a Conversation.
   *
   * <p>[Conversation][google.cloud.discoveryengine.v1beta.Conversation] action type cannot be
   * changed. If the [Conversation][google.cloud.discoveryengine.v1beta.Conversation] to update does
   * not exist, a NOT_FOUND error is returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationalSearchServiceClient conversationalSearchServiceClient =
   *     ConversationalSearchServiceClient.create()) {
   *   Conversation conversation = Conversation.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Conversation response =
   *       conversationalSearchServiceClient.updateConversation(conversation, updateMask);
   * }
   * }</pre>
   *
   * @param conversation Required. The Conversation to update.
   * @param updateMask Indicates which fields in the provided
   *     [Conversation][google.cloud.discoveryengine.v1beta.Conversation] to update. The following
   *     are NOT supported:
   *     <ul>
   *       <li>[Conversation.name][google.cloud.discoveryengine.v1beta.Conversation.name]
   *     </ul>
   *     <p>If not set or empty, all supported fields are updated.
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
   * Updates a Conversation.
   *
   * <p>[Conversation][google.cloud.discoveryengine.v1beta.Conversation] action type cannot be
   * changed. If the [Conversation][google.cloud.discoveryengine.v1beta.Conversation] to update does
   * not exist, a NOT_FOUND error is returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationalSearchServiceClient conversationalSearchServiceClient =
   *     ConversationalSearchServiceClient.create()) {
   *   UpdateConversationRequest request =
   *       UpdateConversationRequest.newBuilder()
   *           .setConversation(Conversation.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Conversation response = conversationalSearchServiceClient.updateConversation(request);
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
   * Updates a Conversation.
   *
   * <p>[Conversation][google.cloud.discoveryengine.v1beta.Conversation] action type cannot be
   * changed. If the [Conversation][google.cloud.discoveryengine.v1beta.Conversation] to update does
   * not exist, a NOT_FOUND error is returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationalSearchServiceClient conversationalSearchServiceClient =
   *     ConversationalSearchServiceClient.create()) {
   *   UpdateConversationRequest request =
   *       UpdateConversationRequest.newBuilder()
   *           .setConversation(Conversation.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Conversation> future =
   *       conversationalSearchServiceClient.updateConversationCallable().futureCall(request);
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
   * Gets a Conversation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationalSearchServiceClient conversationalSearchServiceClient =
   *     ConversationalSearchServiceClient.create()) {
   *   ConversationName name =
   *       ConversationName.ofProjectLocationDataStoreConversationName(
   *           "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[CONVERSATION]");
   *   Conversation response = conversationalSearchServiceClient.getConversation(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Conversation to get. Format:
   *     `projects/{project_number}/locations/{location_id}/collections/{collection}/dataStores/{data_store_id}/conversations/{conversation_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Conversation getConversation(ConversationName name) {
    GetConversationRequest request =
        GetConversationRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getConversation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a Conversation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationalSearchServiceClient conversationalSearchServiceClient =
   *     ConversationalSearchServiceClient.create()) {
   *   String name =
   *       ConversationName.ofProjectLocationDataStoreConversationName(
   *               "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[CONVERSATION]")
   *           .toString();
   *   Conversation response = conversationalSearchServiceClient.getConversation(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Conversation to get. Format:
   *     `projects/{project_number}/locations/{location_id}/collections/{collection}/dataStores/{data_store_id}/conversations/{conversation_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Conversation getConversation(String name) {
    GetConversationRequest request = GetConversationRequest.newBuilder().setName(name).build();
    return getConversation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a Conversation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationalSearchServiceClient conversationalSearchServiceClient =
   *     ConversationalSearchServiceClient.create()) {
   *   GetConversationRequest request =
   *       GetConversationRequest.newBuilder()
   *           .setName(
   *               ConversationName.ofProjectLocationDataStoreConversationName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[CONVERSATION]")
   *                   .toString())
   *           .build();
   *   Conversation response = conversationalSearchServiceClient.getConversation(request);
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
   * Gets a Conversation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationalSearchServiceClient conversationalSearchServiceClient =
   *     ConversationalSearchServiceClient.create()) {
   *   GetConversationRequest request =
   *       GetConversationRequest.newBuilder()
   *           .setName(
   *               ConversationName.ofProjectLocationDataStoreConversationName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[CONVERSATION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Conversation> future =
   *       conversationalSearchServiceClient.getConversationCallable().futureCall(request);
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
   * Lists all Conversations by their parent
   * [DataStore][google.cloud.discoveryengine.v1beta.DataStore].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationalSearchServiceClient conversationalSearchServiceClient =
   *     ConversationalSearchServiceClient.create()) {
   *   DataStoreName parent =
   *       DataStoreName.ofProjectLocationDataStoreName("[PROJECT]", "[LOCATION]", "[DATA_STORE]");
   *   for (Conversation element :
   *       conversationalSearchServiceClient.listConversations(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The data store resource name. Format:
   *     `projects/{project_number}/locations/{location_id}/collections/{collection}/dataStores/{data_store_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListConversationsPagedResponse listConversations(DataStoreName parent) {
    ListConversationsRequest request =
        ListConversationsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listConversations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all Conversations by their parent
   * [DataStore][google.cloud.discoveryengine.v1beta.DataStore].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationalSearchServiceClient conversationalSearchServiceClient =
   *     ConversationalSearchServiceClient.create()) {
   *   String parent =
   *       DataStoreName.ofProjectLocationDataStoreName("[PROJECT]", "[LOCATION]", "[DATA_STORE]")
   *           .toString();
   *   for (Conversation element :
   *       conversationalSearchServiceClient.listConversations(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The data store resource name. Format:
   *     `projects/{project_number}/locations/{location_id}/collections/{collection}/dataStores/{data_store_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListConversationsPagedResponse listConversations(String parent) {
    ListConversationsRequest request =
        ListConversationsRequest.newBuilder().setParent(parent).build();
    return listConversations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all Conversations by their parent
   * [DataStore][google.cloud.discoveryengine.v1beta.DataStore].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationalSearchServiceClient conversationalSearchServiceClient =
   *     ConversationalSearchServiceClient.create()) {
   *   ListConversationsRequest request =
   *       ListConversationsRequest.newBuilder()
   *           .setParent(
   *               DataStoreName.ofProjectLocationDataStoreName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Conversation element :
   *       conversationalSearchServiceClient.listConversations(request).iterateAll()) {
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
   * Lists all Conversations by their parent
   * [DataStore][google.cloud.discoveryengine.v1beta.DataStore].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationalSearchServiceClient conversationalSearchServiceClient =
   *     ConversationalSearchServiceClient.create()) {
   *   ListConversationsRequest request =
   *       ListConversationsRequest.newBuilder()
   *           .setParent(
   *               DataStoreName.ofProjectLocationDataStoreName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Conversation> future =
   *       conversationalSearchServiceClient.listConversationsPagedCallable().futureCall(request);
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
   * Lists all Conversations by their parent
   * [DataStore][google.cloud.discoveryengine.v1beta.DataStore].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationalSearchServiceClient conversationalSearchServiceClient =
   *     ConversationalSearchServiceClient.create()) {
   *   ListConversationsRequest request =
   *       ListConversationsRequest.newBuilder()
   *           .setParent(
   *               DataStoreName.ofProjectLocationDataStoreName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListConversationsResponse response =
   *         conversationalSearchServiceClient.listConversationsCallable().call(request);
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
   * Answer query method.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationalSearchServiceClient conversationalSearchServiceClient =
   *     ConversationalSearchServiceClient.create()) {
   *   AnswerQueryRequest request =
   *       AnswerQueryRequest.newBuilder()
   *           .setServingConfig(
   *               ServingConfigName.ofProjectLocationDataStoreServingConfigName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SERVING_CONFIG]")
   *                   .toString())
   *           .setQuery(Query.newBuilder().build())
   *           .setSession(
   *               SessionName.ofProjectLocationDataStoreSessionName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SESSION]")
   *                   .toString())
   *           .setSafetySpec(AnswerQueryRequest.SafetySpec.newBuilder().build())
   *           .setRelatedQuestionsSpec(AnswerQueryRequest.RelatedQuestionsSpec.newBuilder().build())
   *           .setAnswerGenerationSpec(AnswerQueryRequest.AnswerGenerationSpec.newBuilder().build())
   *           .setSearchSpec(AnswerQueryRequest.SearchSpec.newBuilder().build())
   *           .setQueryUnderstandingSpec(
   *               AnswerQueryRequest.QueryUnderstandingSpec.newBuilder().build())
   *           .setAsynchronousMode(true)
   *           .setUserPseudoId("userPseudoId-1155274652")
   *           .build();
   *   AnswerQueryResponse response = conversationalSearchServiceClient.answerQuery(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AnswerQueryResponse answerQuery(AnswerQueryRequest request) {
    return answerQueryCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Answer query method.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationalSearchServiceClient conversationalSearchServiceClient =
   *     ConversationalSearchServiceClient.create()) {
   *   AnswerQueryRequest request =
   *       AnswerQueryRequest.newBuilder()
   *           .setServingConfig(
   *               ServingConfigName.ofProjectLocationDataStoreServingConfigName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SERVING_CONFIG]")
   *                   .toString())
   *           .setQuery(Query.newBuilder().build())
   *           .setSession(
   *               SessionName.ofProjectLocationDataStoreSessionName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SESSION]")
   *                   .toString())
   *           .setSafetySpec(AnswerQueryRequest.SafetySpec.newBuilder().build())
   *           .setRelatedQuestionsSpec(AnswerQueryRequest.RelatedQuestionsSpec.newBuilder().build())
   *           .setAnswerGenerationSpec(AnswerQueryRequest.AnswerGenerationSpec.newBuilder().build())
   *           .setSearchSpec(AnswerQueryRequest.SearchSpec.newBuilder().build())
   *           .setQueryUnderstandingSpec(
   *               AnswerQueryRequest.QueryUnderstandingSpec.newBuilder().build())
   *           .setAsynchronousMode(true)
   *           .setUserPseudoId("userPseudoId-1155274652")
   *           .build();
   *   ApiFuture<AnswerQueryResponse> future =
   *       conversationalSearchServiceClient.answerQueryCallable().futureCall(request);
   *   // Do something.
   *   AnswerQueryResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<AnswerQueryRequest, AnswerQueryResponse> answerQueryCallable() {
    return stub.answerQueryCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a Answer.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationalSearchServiceClient conversationalSearchServiceClient =
   *     ConversationalSearchServiceClient.create()) {
   *   AnswerName name =
   *       AnswerName.ofProjectLocationDataStoreSessionAnswerName(
   *           "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SESSION]", "[ANSWER]");
   *   Answer response = conversationalSearchServiceClient.getAnswer(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Answer to get. Format:
   *     `projects/{project_number}/locations/{location_id}/collections/{collection}/engines/{engine_id}/sessions/{session_id}/answers/{answer_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Answer getAnswer(AnswerName name) {
    GetAnswerRequest request =
        GetAnswerRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getAnswer(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a Answer.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationalSearchServiceClient conversationalSearchServiceClient =
   *     ConversationalSearchServiceClient.create()) {
   *   String name =
   *       AnswerName.ofProjectLocationDataStoreSessionAnswerName(
   *               "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SESSION]", "[ANSWER]")
   *           .toString();
   *   Answer response = conversationalSearchServiceClient.getAnswer(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Answer to get. Format:
   *     `projects/{project_number}/locations/{location_id}/collections/{collection}/engines/{engine_id}/sessions/{session_id}/answers/{answer_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Answer getAnswer(String name) {
    GetAnswerRequest request = GetAnswerRequest.newBuilder().setName(name).build();
    return getAnswer(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a Answer.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationalSearchServiceClient conversationalSearchServiceClient =
   *     ConversationalSearchServiceClient.create()) {
   *   GetAnswerRequest request =
   *       GetAnswerRequest.newBuilder()
   *           .setName(
   *               AnswerName.ofProjectLocationDataStoreSessionAnswerName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SESSION]", "[ANSWER]")
   *                   .toString())
   *           .build();
   *   Answer response = conversationalSearchServiceClient.getAnswer(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Answer getAnswer(GetAnswerRequest request) {
    return getAnswerCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a Answer.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationalSearchServiceClient conversationalSearchServiceClient =
   *     ConversationalSearchServiceClient.create()) {
   *   GetAnswerRequest request =
   *       GetAnswerRequest.newBuilder()
   *           .setName(
   *               AnswerName.ofProjectLocationDataStoreSessionAnswerName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SESSION]", "[ANSWER]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Answer> future =
   *       conversationalSearchServiceClient.getAnswerCallable().futureCall(request);
   *   // Do something.
   *   Answer response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetAnswerRequest, Answer> getAnswerCallable() {
    return stub.getAnswerCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Session.
   *
   * <p>If the [Session][google.cloud.discoveryengine.v1beta.Session] to create already exists, an
   * ALREADY_EXISTS error is returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationalSearchServiceClient conversationalSearchServiceClient =
   *     ConversationalSearchServiceClient.create()) {
   *   DataStoreName parent =
   *       DataStoreName.ofProjectLocationDataStoreName("[PROJECT]", "[LOCATION]", "[DATA_STORE]");
   *   Session session = Session.newBuilder().build();
   *   Session response = conversationalSearchServiceClient.createSession(parent, session);
   * }
   * }</pre>
   *
   * @param parent Required. Full resource name of parent data store. Format:
   *     `projects/{project_number}/locations/{location_id}/collections/{collection}/dataStores/{data_store_id}`
   * @param session Required. The session to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Session createSession(DataStoreName parent, Session session) {
    CreateSessionRequest request =
        CreateSessionRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setSession(session)
            .build();
    return createSession(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Session.
   *
   * <p>If the [Session][google.cloud.discoveryengine.v1beta.Session] to create already exists, an
   * ALREADY_EXISTS error is returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationalSearchServiceClient conversationalSearchServiceClient =
   *     ConversationalSearchServiceClient.create()) {
   *   String parent =
   *       DataStoreName.ofProjectLocationDataStoreName("[PROJECT]", "[LOCATION]", "[DATA_STORE]")
   *           .toString();
   *   Session session = Session.newBuilder().build();
   *   Session response = conversationalSearchServiceClient.createSession(parent, session);
   * }
   * }</pre>
   *
   * @param parent Required. Full resource name of parent data store. Format:
   *     `projects/{project_number}/locations/{location_id}/collections/{collection}/dataStores/{data_store_id}`
   * @param session Required. The session to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Session createSession(String parent, Session session) {
    CreateSessionRequest request =
        CreateSessionRequest.newBuilder().setParent(parent).setSession(session).build();
    return createSession(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Session.
   *
   * <p>If the [Session][google.cloud.discoveryengine.v1beta.Session] to create already exists, an
   * ALREADY_EXISTS error is returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationalSearchServiceClient conversationalSearchServiceClient =
   *     ConversationalSearchServiceClient.create()) {
   *   CreateSessionRequest request =
   *       CreateSessionRequest.newBuilder()
   *           .setParent(
   *               DataStoreName.ofProjectLocationDataStoreName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]")
   *                   .toString())
   *           .setSession(Session.newBuilder().build())
   *           .build();
   *   Session response = conversationalSearchServiceClient.createSession(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Session createSession(CreateSessionRequest request) {
    return createSessionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Session.
   *
   * <p>If the [Session][google.cloud.discoveryengine.v1beta.Session] to create already exists, an
   * ALREADY_EXISTS error is returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationalSearchServiceClient conversationalSearchServiceClient =
   *     ConversationalSearchServiceClient.create()) {
   *   CreateSessionRequest request =
   *       CreateSessionRequest.newBuilder()
   *           .setParent(
   *               DataStoreName.ofProjectLocationDataStoreName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]")
   *                   .toString())
   *           .setSession(Session.newBuilder().build())
   *           .build();
   *   ApiFuture<Session> future =
   *       conversationalSearchServiceClient.createSessionCallable().futureCall(request);
   *   // Do something.
   *   Session response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateSessionRequest, Session> createSessionCallable() {
    return stub.createSessionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Session.
   *
   * <p>If the [Session][google.cloud.discoveryengine.v1beta.Session] to delete does not exist, a
   * NOT_FOUND error is returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationalSearchServiceClient conversationalSearchServiceClient =
   *     ConversationalSearchServiceClient.create()) {
   *   SessionName name =
   *       SessionName.ofProjectLocationDataStoreSessionName(
   *           "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SESSION]");
   *   conversationalSearchServiceClient.deleteSession(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Session to delete. Format:
   *     `projects/{project_number}/locations/{location_id}/collections/{collection}/dataStores/{data_store_id}/sessions/{session_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteSession(SessionName name) {
    DeleteSessionRequest request =
        DeleteSessionRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteSession(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Session.
   *
   * <p>If the [Session][google.cloud.discoveryengine.v1beta.Session] to delete does not exist, a
   * NOT_FOUND error is returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationalSearchServiceClient conversationalSearchServiceClient =
   *     ConversationalSearchServiceClient.create()) {
   *   String name =
   *       SessionName.ofProjectLocationDataStoreSessionName(
   *               "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SESSION]")
   *           .toString();
   *   conversationalSearchServiceClient.deleteSession(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Session to delete. Format:
   *     `projects/{project_number}/locations/{location_id}/collections/{collection}/dataStores/{data_store_id}/sessions/{session_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteSession(String name) {
    DeleteSessionRequest request = DeleteSessionRequest.newBuilder().setName(name).build();
    deleteSession(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Session.
   *
   * <p>If the [Session][google.cloud.discoveryengine.v1beta.Session] to delete does not exist, a
   * NOT_FOUND error is returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationalSearchServiceClient conversationalSearchServiceClient =
   *     ConversationalSearchServiceClient.create()) {
   *   DeleteSessionRequest request =
   *       DeleteSessionRequest.newBuilder()
   *           .setName(
   *               SessionName.ofProjectLocationDataStoreSessionName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SESSION]")
   *                   .toString())
   *           .build();
   *   conversationalSearchServiceClient.deleteSession(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteSession(DeleteSessionRequest request) {
    deleteSessionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Session.
   *
   * <p>If the [Session][google.cloud.discoveryengine.v1beta.Session] to delete does not exist, a
   * NOT_FOUND error is returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationalSearchServiceClient conversationalSearchServiceClient =
   *     ConversationalSearchServiceClient.create()) {
   *   DeleteSessionRequest request =
   *       DeleteSessionRequest.newBuilder()
   *           .setName(
   *               SessionName.ofProjectLocationDataStoreSessionName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SESSION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       conversationalSearchServiceClient.deleteSessionCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteSessionRequest, Empty> deleteSessionCallable() {
    return stub.deleteSessionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a Session.
   *
   * <p>[Session][google.cloud.discoveryengine.v1beta.Session] action type cannot be changed. If the
   * [Session][google.cloud.discoveryengine.v1beta.Session] to update does not exist, a NOT_FOUND
   * error is returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationalSearchServiceClient conversationalSearchServiceClient =
   *     ConversationalSearchServiceClient.create()) {
   *   Session session = Session.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Session response = conversationalSearchServiceClient.updateSession(session, updateMask);
   * }
   * }</pre>
   *
   * @param session Required. The Session to update.
   * @param updateMask Indicates which fields in the provided
   *     [Session][google.cloud.discoveryengine.v1beta.Session] to update. The following are NOT
   *     supported:
   *     <ul>
   *       <li>[Session.name][google.cloud.discoveryengine.v1beta.Session.name]
   *     </ul>
   *     <p>If not set or empty, all supported fields are updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Session updateSession(Session session, FieldMask updateMask) {
    UpdateSessionRequest request =
        UpdateSessionRequest.newBuilder().setSession(session).setUpdateMask(updateMask).build();
    return updateSession(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a Session.
   *
   * <p>[Session][google.cloud.discoveryengine.v1beta.Session] action type cannot be changed. If the
   * [Session][google.cloud.discoveryengine.v1beta.Session] to update does not exist, a NOT_FOUND
   * error is returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationalSearchServiceClient conversationalSearchServiceClient =
   *     ConversationalSearchServiceClient.create()) {
   *   UpdateSessionRequest request =
   *       UpdateSessionRequest.newBuilder()
   *           .setSession(Session.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Session response = conversationalSearchServiceClient.updateSession(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Session updateSession(UpdateSessionRequest request) {
    return updateSessionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a Session.
   *
   * <p>[Session][google.cloud.discoveryengine.v1beta.Session] action type cannot be changed. If the
   * [Session][google.cloud.discoveryengine.v1beta.Session] to update does not exist, a NOT_FOUND
   * error is returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationalSearchServiceClient conversationalSearchServiceClient =
   *     ConversationalSearchServiceClient.create()) {
   *   UpdateSessionRequest request =
   *       UpdateSessionRequest.newBuilder()
   *           .setSession(Session.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Session> future =
   *       conversationalSearchServiceClient.updateSessionCallable().futureCall(request);
   *   // Do something.
   *   Session response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateSessionRequest, Session> updateSessionCallable() {
    return stub.updateSessionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a Session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationalSearchServiceClient conversationalSearchServiceClient =
   *     ConversationalSearchServiceClient.create()) {
   *   SessionName name =
   *       SessionName.ofProjectLocationDataStoreSessionName(
   *           "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SESSION]");
   *   Session response = conversationalSearchServiceClient.getSession(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Session to get. Format:
   *     `projects/{project_number}/locations/{location_id}/collections/{collection}/dataStores/{data_store_id}/sessions/{session_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Session getSession(SessionName name) {
    GetSessionRequest request =
        GetSessionRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getSession(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a Session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationalSearchServiceClient conversationalSearchServiceClient =
   *     ConversationalSearchServiceClient.create()) {
   *   String name =
   *       SessionName.ofProjectLocationDataStoreSessionName(
   *               "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SESSION]")
   *           .toString();
   *   Session response = conversationalSearchServiceClient.getSession(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Session to get. Format:
   *     `projects/{project_number}/locations/{location_id}/collections/{collection}/dataStores/{data_store_id}/sessions/{session_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Session getSession(String name) {
    GetSessionRequest request = GetSessionRequest.newBuilder().setName(name).build();
    return getSession(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a Session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationalSearchServiceClient conversationalSearchServiceClient =
   *     ConversationalSearchServiceClient.create()) {
   *   GetSessionRequest request =
   *       GetSessionRequest.newBuilder()
   *           .setName(
   *               SessionName.ofProjectLocationDataStoreSessionName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SESSION]")
   *                   .toString())
   *           .build();
   *   Session response = conversationalSearchServiceClient.getSession(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Session getSession(GetSessionRequest request) {
    return getSessionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a Session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationalSearchServiceClient conversationalSearchServiceClient =
   *     ConversationalSearchServiceClient.create()) {
   *   GetSessionRequest request =
   *       GetSessionRequest.newBuilder()
   *           .setName(
   *               SessionName.ofProjectLocationDataStoreSessionName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SESSION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Session> future =
   *       conversationalSearchServiceClient.getSessionCallable().futureCall(request);
   *   // Do something.
   *   Session response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetSessionRequest, Session> getSessionCallable() {
    return stub.getSessionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all Sessions by their parent [DataStore][google.cloud.discoveryengine.v1beta.DataStore].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationalSearchServiceClient conversationalSearchServiceClient =
   *     ConversationalSearchServiceClient.create()) {
   *   DataStoreName parent =
   *       DataStoreName.ofProjectLocationDataStoreName("[PROJECT]", "[LOCATION]", "[DATA_STORE]");
   *   for (Session element : conversationalSearchServiceClient.listSessions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The data store resource name. Format:
   *     `projects/{project_number}/locations/{location_id}/collections/{collection}/dataStores/{data_store_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSessionsPagedResponse listSessions(DataStoreName parent) {
    ListSessionsRequest request =
        ListSessionsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listSessions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all Sessions by their parent [DataStore][google.cloud.discoveryengine.v1beta.DataStore].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationalSearchServiceClient conversationalSearchServiceClient =
   *     ConversationalSearchServiceClient.create()) {
   *   String parent =
   *       DataStoreName.ofProjectLocationDataStoreName("[PROJECT]", "[LOCATION]", "[DATA_STORE]")
   *           .toString();
   *   for (Session element : conversationalSearchServiceClient.listSessions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The data store resource name. Format:
   *     `projects/{project_number}/locations/{location_id}/collections/{collection}/dataStores/{data_store_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSessionsPagedResponse listSessions(String parent) {
    ListSessionsRequest request = ListSessionsRequest.newBuilder().setParent(parent).build();
    return listSessions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all Sessions by their parent [DataStore][google.cloud.discoveryengine.v1beta.DataStore].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationalSearchServiceClient conversationalSearchServiceClient =
   *     ConversationalSearchServiceClient.create()) {
   *   ListSessionsRequest request =
   *       ListSessionsRequest.newBuilder()
   *           .setParent(
   *               DataStoreName.ofProjectLocationDataStoreName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Session element : conversationalSearchServiceClient.listSessions(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSessionsPagedResponse listSessions(ListSessionsRequest request) {
    return listSessionsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all Sessions by their parent [DataStore][google.cloud.discoveryengine.v1beta.DataStore].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationalSearchServiceClient conversationalSearchServiceClient =
   *     ConversationalSearchServiceClient.create()) {
   *   ListSessionsRequest request =
   *       ListSessionsRequest.newBuilder()
   *           .setParent(
   *               DataStoreName.ofProjectLocationDataStoreName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Session> future =
   *       conversationalSearchServiceClient.listSessionsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Session element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListSessionsRequest, ListSessionsPagedResponse>
      listSessionsPagedCallable() {
    return stub.listSessionsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all Sessions by their parent [DataStore][google.cloud.discoveryengine.v1beta.DataStore].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConversationalSearchServiceClient conversationalSearchServiceClient =
   *     ConversationalSearchServiceClient.create()) {
   *   ListSessionsRequest request =
   *       ListSessionsRequest.newBuilder()
   *           .setParent(
   *               DataStoreName.ofProjectLocationDataStoreName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListSessionsResponse response =
   *         conversationalSearchServiceClient.listSessionsCallable().call(request);
   *     for (Session element : response.getSessionsList()) {
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
  public final UnaryCallable<ListSessionsRequest, ListSessionsResponse> listSessionsCallable() {
    return stub.listSessionsCallable();
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

  public static class ListSessionsPagedResponse
      extends AbstractPagedListResponse<
          ListSessionsRequest,
          ListSessionsResponse,
          Session,
          ListSessionsPage,
          ListSessionsFixedSizeCollection> {

    public static ApiFuture<ListSessionsPagedResponse> createAsync(
        PageContext<ListSessionsRequest, ListSessionsResponse, Session> context,
        ApiFuture<ListSessionsResponse> futureResponse) {
      ApiFuture<ListSessionsPage> futurePage =
          ListSessionsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListSessionsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListSessionsPagedResponse(ListSessionsPage page) {
      super(page, ListSessionsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListSessionsPage
      extends AbstractPage<ListSessionsRequest, ListSessionsResponse, Session, ListSessionsPage> {

    private ListSessionsPage(
        PageContext<ListSessionsRequest, ListSessionsResponse, Session> context,
        ListSessionsResponse response) {
      super(context, response);
    }

    private static ListSessionsPage createEmptyPage() {
      return new ListSessionsPage(null, null);
    }

    @Override
    protected ListSessionsPage createPage(
        PageContext<ListSessionsRequest, ListSessionsResponse, Session> context,
        ListSessionsResponse response) {
      return new ListSessionsPage(context, response);
    }

    @Override
    public ApiFuture<ListSessionsPage> createPageAsync(
        PageContext<ListSessionsRequest, ListSessionsResponse, Session> context,
        ApiFuture<ListSessionsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListSessionsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListSessionsRequest,
          ListSessionsResponse,
          Session,
          ListSessionsPage,
          ListSessionsFixedSizeCollection> {

    private ListSessionsFixedSizeCollection(List<ListSessionsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListSessionsFixedSizeCollection createEmptyCollection() {
      return new ListSessionsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListSessionsFixedSizeCollection createCollection(
        List<ListSessionsPage> pages, int collectionSize) {
      return new ListSessionsFixedSizeCollection(pages, collectionSize);
    }
  }
}
