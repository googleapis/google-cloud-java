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

package com.google.cloud.dialogflow.v2beta1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dialogflow.v2beta1.stub.SessionsStub;
import com.google.cloud.dialogflow.v2beta1.stub.SessionsStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: A service used for session interactions.
 *
 * <p>For more information, see the [API interactions
 * guide](https://cloud.google.com/dialogflow/docs/api-overview).
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
 * try (SessionsClient sessionsClient = SessionsClient.create()) {
 *   SessionName session = SessionName.ofProjectSessionName("[PROJECT]", "[SESSION]");
 *   QueryInput queryInput = QueryInput.newBuilder().build();
 *   DetectIntentResponse response = sessionsClient.detectIntent(session, queryInput);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the SessionsClient object to clean up resources such as
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
 * <p>This class can be customized by passing in a custom instance of SessionsSettings to create().
 * For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * SessionsSettings sessionsSettings =
 *     SessionsSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * SessionsClient sessionsClient = SessionsClient.create(sessionsSettings);
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
 * SessionsSettings sessionsSettings =
 *     SessionsSettings.newBuilder().setEndpoint(myEndpoint).build();
 * SessionsClient sessionsClient = SessionsClient.create(sessionsSettings);
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
 * SessionsSettings sessionsSettings = SessionsSettings.newHttpJsonBuilder().build();
 * SessionsClient sessionsClient = SessionsClient.create(sessionsSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class SessionsClient implements BackgroundResource {
  private final SessionsSettings settings;
  private final SessionsStub stub;

  /** Constructs an instance of SessionsClient with default settings. */
  public static final SessionsClient create() throws IOException {
    return create(SessionsSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of SessionsClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final SessionsClient create(SessionsSettings settings) throws IOException {
    return new SessionsClient(settings);
  }

  /**
   * Constructs an instance of SessionsClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(SessionsSettings).
   */
  public static final SessionsClient create(SessionsStub stub) {
    return new SessionsClient(stub);
  }

  /**
   * Constructs an instance of SessionsClient, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected SessionsClient(SessionsSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((SessionsStubSettings) settings.getStubSettings()).createStub();
  }

  protected SessionsClient(SessionsStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final SessionsSettings getSettings() {
    return settings;
  }

  public SessionsStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Processes a natural language query and returns structured, actionable data as a result. This
   * method is not idempotent, because it may cause contexts and session entity types to be updated,
   * which in turn might affect results of future queries.
   *
   * <p>If you might use [Agent Assist](https://cloud.google.com/dialogflow/docs/#aa) or other CCAI
   * products now or in the future, consider using
   * [AnalyzeContent][google.cloud.dialogflow.v2beta1.Participants.AnalyzeContent] instead of
   * `DetectIntent`. `AnalyzeContent` has additional functionality for Agent Assist and other CCAI
   * products.
   *
   * <p>Note: Always use agent versions for production traffic. See [Versions and
   * environments](https://cloud.google.com/dialogflow/es/docs/agents-versions).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SessionsClient sessionsClient = SessionsClient.create()) {
   *   SessionName session = SessionName.ofProjectSessionName("[PROJECT]", "[SESSION]");
   *   QueryInput queryInput = QueryInput.newBuilder().build();
   *   DetectIntentResponse response = sessionsClient.detectIntent(session, queryInput);
   * }
   * }</pre>
   *
   * @param session Required. The name of the session this query is sent to. Supported formats: -
   *     `projects/&lt;Project ID&gt;/agent/sessions/&lt;Session ID&gt;, - `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/agent/sessions/&lt;Session ID&gt;`, -
   *     `projects/&lt;Project ID&gt;/agent/environments/&lt;Environment ID&gt;/users/&lt;User
   *     ID&gt;/sessions/&lt;Session ID&gt;`, - `projects/&lt;Project ID&gt;/locations/&lt;Location
   *     ID&gt;/agent/environments/&lt;Environment ID&gt;/users/&lt;User ID&gt;/sessions/&lt;Session
   *     ID&gt;`,
   *     <p>If `Location ID` is not specified we assume default 'us' location. If `Environment ID`
   *     is not specified, we assume default 'draft' environment (`Environment ID` might be referred
   *     to as environment name at some places). If `User ID` is not specified, we are using "-".
   *     It's up to the API caller to choose an appropriate `Session ID` and `User Id`. They can be
   *     a random number or some type of user and session identifiers (preferably hashed). The
   *     length of the `Session ID` and `User ID` must not exceed 36 characters. For more
   *     information, see the [API interactions
   *     guide](https://cloud.google.com/dialogflow/docs/api-overview).
   *     <p>Note: Always use agent versions for production traffic. See [Versions and
   *     environments](https://cloud.google.com/dialogflow/es/docs/agents-versions).
   * @param queryInput Required. The input specification. It can be set to:
   *     <p>1. an audio config which instructs the speech recognizer how to process the speech
   *     audio,
   *     <p>2. a conversational query in the form of text, or
   *     <p>3. an event that specifies which intent to trigger.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DetectIntentResponse detectIntent(SessionName session, QueryInput queryInput) {
    DetectIntentRequest request =
        DetectIntentRequest.newBuilder()
            .setSession(session == null ? null : session.toString())
            .setQueryInput(queryInput)
            .build();
    return detectIntent(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Processes a natural language query and returns structured, actionable data as a result. This
   * method is not idempotent, because it may cause contexts and session entity types to be updated,
   * which in turn might affect results of future queries.
   *
   * <p>If you might use [Agent Assist](https://cloud.google.com/dialogflow/docs/#aa) or other CCAI
   * products now or in the future, consider using
   * [AnalyzeContent][google.cloud.dialogflow.v2beta1.Participants.AnalyzeContent] instead of
   * `DetectIntent`. `AnalyzeContent` has additional functionality for Agent Assist and other CCAI
   * products.
   *
   * <p>Note: Always use agent versions for production traffic. See [Versions and
   * environments](https://cloud.google.com/dialogflow/es/docs/agents-versions).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SessionsClient sessionsClient = SessionsClient.create()) {
   *   String session = SessionName.ofProjectSessionName("[PROJECT]", "[SESSION]").toString();
   *   QueryInput queryInput = QueryInput.newBuilder().build();
   *   DetectIntentResponse response = sessionsClient.detectIntent(session, queryInput);
   * }
   * }</pre>
   *
   * @param session Required. The name of the session this query is sent to. Supported formats: -
   *     `projects/&lt;Project ID&gt;/agent/sessions/&lt;Session ID&gt;, - `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/agent/sessions/&lt;Session ID&gt;`, -
   *     `projects/&lt;Project ID&gt;/agent/environments/&lt;Environment ID&gt;/users/&lt;User
   *     ID&gt;/sessions/&lt;Session ID&gt;`, - `projects/&lt;Project ID&gt;/locations/&lt;Location
   *     ID&gt;/agent/environments/&lt;Environment ID&gt;/users/&lt;User ID&gt;/sessions/&lt;Session
   *     ID&gt;`,
   *     <p>If `Location ID` is not specified we assume default 'us' location. If `Environment ID`
   *     is not specified, we assume default 'draft' environment (`Environment ID` might be referred
   *     to as environment name at some places). If `User ID` is not specified, we are using "-".
   *     It's up to the API caller to choose an appropriate `Session ID` and `User Id`. They can be
   *     a random number or some type of user and session identifiers (preferably hashed). The
   *     length of the `Session ID` and `User ID` must not exceed 36 characters. For more
   *     information, see the [API interactions
   *     guide](https://cloud.google.com/dialogflow/docs/api-overview).
   *     <p>Note: Always use agent versions for production traffic. See [Versions and
   *     environments](https://cloud.google.com/dialogflow/es/docs/agents-versions).
   * @param queryInput Required. The input specification. It can be set to:
   *     <p>1. an audio config which instructs the speech recognizer how to process the speech
   *     audio,
   *     <p>2. a conversational query in the form of text, or
   *     <p>3. an event that specifies which intent to trigger.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DetectIntentResponse detectIntent(String session, QueryInput queryInput) {
    DetectIntentRequest request =
        DetectIntentRequest.newBuilder().setSession(session).setQueryInput(queryInput).build();
    return detectIntent(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Processes a natural language query and returns structured, actionable data as a result. This
   * method is not idempotent, because it may cause contexts and session entity types to be updated,
   * which in turn might affect results of future queries.
   *
   * <p>If you might use [Agent Assist](https://cloud.google.com/dialogflow/docs/#aa) or other CCAI
   * products now or in the future, consider using
   * [AnalyzeContent][google.cloud.dialogflow.v2beta1.Participants.AnalyzeContent] instead of
   * `DetectIntent`. `AnalyzeContent` has additional functionality for Agent Assist and other CCAI
   * products.
   *
   * <p>Note: Always use agent versions for production traffic. See [Versions and
   * environments](https://cloud.google.com/dialogflow/es/docs/agents-versions).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SessionsClient sessionsClient = SessionsClient.create()) {
   *   DetectIntentRequest request =
   *       DetectIntentRequest.newBuilder()
   *           .setSession(SessionName.ofProjectSessionName("[PROJECT]", "[SESSION]").toString())
   *           .setQueryParams(QueryParameters.newBuilder().build())
   *           .setQueryInput(QueryInput.newBuilder().build())
   *           .setOutputAudioConfig(OutputAudioConfig.newBuilder().build())
   *           .setOutputAudioConfigMask(FieldMask.newBuilder().build())
   *           .setInputAudio(ByteString.EMPTY)
   *           .build();
   *   DetectIntentResponse response = sessionsClient.detectIntent(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DetectIntentResponse detectIntent(DetectIntentRequest request) {
    return detectIntentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Processes a natural language query and returns structured, actionable data as a result. This
   * method is not idempotent, because it may cause contexts and session entity types to be updated,
   * which in turn might affect results of future queries.
   *
   * <p>If you might use [Agent Assist](https://cloud.google.com/dialogflow/docs/#aa) or other CCAI
   * products now or in the future, consider using
   * [AnalyzeContent][google.cloud.dialogflow.v2beta1.Participants.AnalyzeContent] instead of
   * `DetectIntent`. `AnalyzeContent` has additional functionality for Agent Assist and other CCAI
   * products.
   *
   * <p>Note: Always use agent versions for production traffic. See [Versions and
   * environments](https://cloud.google.com/dialogflow/es/docs/agents-versions).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SessionsClient sessionsClient = SessionsClient.create()) {
   *   DetectIntentRequest request =
   *       DetectIntentRequest.newBuilder()
   *           .setSession(SessionName.ofProjectSessionName("[PROJECT]", "[SESSION]").toString())
   *           .setQueryParams(QueryParameters.newBuilder().build())
   *           .setQueryInput(QueryInput.newBuilder().build())
   *           .setOutputAudioConfig(OutputAudioConfig.newBuilder().build())
   *           .setOutputAudioConfigMask(FieldMask.newBuilder().build())
   *           .setInputAudio(ByteString.EMPTY)
   *           .build();
   *   ApiFuture<DetectIntentResponse> future =
   *       sessionsClient.detectIntentCallable().futureCall(request);
   *   // Do something.
   *   DetectIntentResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DetectIntentRequest, DetectIntentResponse> detectIntentCallable() {
    return stub.detectIntentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Processes a natural language query in audio format in a streaming fashion and returns
   * structured, actionable data as a result. This method is only available via the gRPC API (not
   * REST).
   *
   * <p>If you might use [Agent Assist](https://cloud.google.com/dialogflow/docs/#aa) or other CCAI
   * products now or in the future, consider using
   * [StreamingAnalyzeContent][google.cloud.dialogflow.v2beta1.Participants.StreamingAnalyzeContent]
   * instead of `StreamingDetectIntent`. `StreamingAnalyzeContent` has additional functionality for
   * Agent Assist and other CCAI products.
   *
   * <p>Note: Always use agent versions for production traffic. See [Versions and
   * environments](https://cloud.google.com/dialogflow/es/docs/agents-versions).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SessionsClient sessionsClient = SessionsClient.create()) {
   *   BidiStream<StreamingDetectIntentRequest, StreamingDetectIntentResponse> bidiStream =
   *       sessionsClient.streamingDetectIntentCallable().call();
   *   StreamingDetectIntentRequest request =
   *       StreamingDetectIntentRequest.newBuilder()
   *           .setSession(SessionName.ofProjectSessionName("[PROJECT]", "[SESSION]").toString())
   *           .setQueryParams(QueryParameters.newBuilder().build())
   *           .setQueryInput(QueryInput.newBuilder().build())
   *           .setSingleUtterance(true)
   *           .setOutputAudioConfig(OutputAudioConfig.newBuilder().build())
   *           .setOutputAudioConfigMask(FieldMask.newBuilder().build())
   *           .setInputAudio(ByteString.EMPTY)
   *           .build();
   *   bidiStream.send(request);
   *   for (StreamingDetectIntentResponse response : bidiStream) {
   *     // Do something when a response is received.
   *   }
   * }
   * }</pre>
   */
  public final BidiStreamingCallable<StreamingDetectIntentRequest, StreamingDetectIntentResponse>
      streamingDetectIntentCallable() {
    return stub.streamingDetectIntentCallable();
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
   * try (SessionsClient sessionsClient = SessionsClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : sessionsClient.listLocations(request).iterateAll()) {
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
   * try (SessionsClient sessionsClient = SessionsClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future = sessionsClient.listLocationsPagedCallable().futureCall(request);
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
   * try (SessionsClient sessionsClient = SessionsClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response = sessionsClient.listLocationsCallable().call(request);
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
   * try (SessionsClient sessionsClient = SessionsClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = sessionsClient.getLocation(request);
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
   * try (SessionsClient sessionsClient = SessionsClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future = sessionsClient.getLocationCallable().futureCall(request);
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
