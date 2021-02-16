/*
 * Copyright 2020 Google LLC
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

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dialogflow.v2beta1.stub.SessionsStub;
import com.google.cloud.dialogflow.v2beta1.stub.SessionsStubSettings;
import java.io.IOException;
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
 * SessionsSettings sessionsSettings =
 *     SessionsSettings.newBuilder().setEndpoint(myEndpoint).build();
 * SessionsClient sessionsClient = SessionsClient.create(sessionsSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator")
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
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
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

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected SessionsClient(SessionsStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final SessionsSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public SessionsStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Processes a natural language query and returns structured, actionable data as a result. This
   * method is not idempotent, because it may cause contexts and session entity types to be updated,
   * which in turn might affect results of future queries.
   *
   * <p>Note: Always use agent versions for production traffic. See [Versions and
   * environments](https://cloud.google.com/dialogflow/es/docs/agents-versions).
   *
   * @param session Required. The name of the session this query is sent to. Supported formats: -
   *     `projects/&lt;Project ID&gt;/agent/sessions/&lt;Session ID&gt;, - `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/agent/sessions/&lt;Session ID&gt;`, -
   *     `projects/&lt;Project ID&gt;/agent/environments/&lt;Environment ID&gt;/users/&lt;User
   *     ID&gt;/sessions/&lt;Session ID&gt;`, - `projects/&lt;Project ID&gt;/locations/&lt;Location
   *     ID&gt;/agent/environments/&lt;Environment ID&gt;/users/&lt;User ID&gt;/sessions/&lt;Session
   *     ID&gt;`,
   *     <p>If `Location ID` is not specified we assume default 'us' location. If `Environment ID`
   *     is not specified, we assume default 'draft' environment. If `User ID` is not specified, we
   *     are using "-". It's up to the API caller to choose an appropriate `Session ID` and `User
   *     Id`. They can be a random number or some type of user and session identifiers (preferably
   *     hashed). The length of the `Session ID` and `User ID` must not exceed 36 characters. For
   *     more information, see the [API interactions
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
   * <p>Note: Always use agent versions for production traffic. See [Versions and
   * environments](https://cloud.google.com/dialogflow/es/docs/agents-versions).
   *
   * @param session Required. The name of the session this query is sent to. Supported formats: -
   *     `projects/&lt;Project ID&gt;/agent/sessions/&lt;Session ID&gt;, - `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/agent/sessions/&lt;Session ID&gt;`, -
   *     `projects/&lt;Project ID&gt;/agent/environments/&lt;Environment ID&gt;/users/&lt;User
   *     ID&gt;/sessions/&lt;Session ID&gt;`, - `projects/&lt;Project ID&gt;/locations/&lt;Location
   *     ID&gt;/agent/environments/&lt;Environment ID&gt;/users/&lt;User ID&gt;/sessions/&lt;Session
   *     ID&gt;`,
   *     <p>If `Location ID` is not specified we assume default 'us' location. If `Environment ID`
   *     is not specified, we assume default 'draft' environment. If `User ID` is not specified, we
   *     are using "-". It's up to the API caller to choose an appropriate `Session ID` and `User
   *     Id`. They can be a random number or some type of user and session identifiers (preferably
   *     hashed). The length of the `Session ID` and `User ID` must not exceed 36 characters. For
   *     more information, see the [API interactions
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
   * <p>Note: Always use agent versions for production traffic. See [Versions and
   * environments](https://cloud.google.com/dialogflow/es/docs/agents-versions).
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
   * <p>Note: Always use agent versions for production traffic. See [Versions and
   * environments](https://cloud.google.com/dialogflow/es/docs/agents-versions).
   *
   * <p>Sample code:
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
   * <p>Note: Always use agent versions for production traffic. See [Versions and
   * environments](https://cloud.google.com/dialogflow/es/docs/agents-versions).
   *
   * <p>Sample code:
   */
  public final BidiStreamingCallable<StreamingDetectIntentRequest, StreamingDetectIntentResponse>
      streamingDetectIntentCallable() {
    return stub.streamingDetectIntentCallable();
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
}
