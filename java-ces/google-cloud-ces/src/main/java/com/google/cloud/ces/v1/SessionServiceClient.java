/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.ces.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.ces.v1.stub.SessionServiceStub;
import com.google.cloud.ces.v1.stub.SessionServiceStubSettings;
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
 * Service Description: Session service provides APIs for interacting with CES agents.
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
 * try (SessionServiceClient sessionServiceClient = SessionServiceClient.create()) {
 *   RunSessionRequest request =
 *       RunSessionRequest.newBuilder()
 *           .setConfig(SessionConfig.newBuilder().build())
 *           .addAllInputs(new ArrayList<SessionInput>())
 *           .build();
 *   RunSessionResponse response = sessionServiceClient.runSession(request);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the SessionServiceClient object to clean up resources such
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
 *      <td><p> RunSession</td>
 *      <td><p> Initiates a single turn interaction with the CES agent within a session.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> runSession(RunSessionRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> runSessionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BidiRunSession</td>
 *      <td><p> Establishes a bidirectional streaming connection with the CES agent. The agent processes continuous multimodal inputs (e.g., text, audio) and generates real-time multimodal output streams.
 * <p>  --- Client Request Stream --- The client streams requests in the following order:
 * <p>  1.  Initialization:     The first message must contain     [SessionConfig][google.cloud.ces.v1.BidiSessionClientMessage.config].     For audio sessions, this should also include     [InputAudioConfig][google.cloud.ces.v1.SessionConfig.input_audio_config]     and     [OutputAudioConfig][google.cloud.ces.v1.SessionConfig.output_audio_config]     to define audio processing and synthesis parameters.
 * <p>  2.  Interaction:     Subsequent messages stream     [SessionInput][google.cloud.ces.v1.BidiSessionClientMessage.realtime_input]     containing real-time user input data.
 * <p>  3.  Termination:     The client should half-close the stream when there is no more user     input. It should also half-close upon receiving     [EndSession][google.cloud.ces.v1.BidiSessionServerMessage.end_session]     or [GoAway][google.cloud.ces.v1.BidiSessionServerMessage.go_away] from     the agent.
 * <p>  --- Server Response Stream --- For each interaction turn, the agent streams messages in the following sequence:
 * <p>  1.  Speech Recognition (First N messages):     Contains     [RecognitionResult][google.cloud.ces.v1.BidiSessionServerMessage.recognition_result]     representing the concatenated user speech segments captured so far.     This is only populated for audio sessions.
 * <p>  2.  Response (Next M messages):     Contains     [SessionOutput][google.cloud.ces.v1.BidiSessionServerMessage.session_output]     delivering the agent's response in various modalities (e.g., text,     audio).
 * <p>  3.  Turn Completion (Final message of the turn):     Contains     [SessionOutput][google.cloud.ces.v1.BidiSessionServerMessage.session_output]     with [turn_completed][google.cloud.ces.v1.SessionOutput.turn_completed]     set to true. This signals the end of the current turn and includes     [DiagnosticInfo][google.cloud.ces.v1.SessionOutput.diagnostic_info]     with execution details.
 * <p>  --- Audio Best Practices --- 1.  Streaming:     Stream [audio data][google.cloud.ces.v1.SessionInput.audio]     &#42;&#42;CONTINUOUSLY&#42;&#42;, even during silence. Recommended chunk size: 40-120ms     (balances latency vs. efficiency).
 * <p>  2.  Playback &amp; Interruption:     Play [audio responses][google.cloud.ces.v1.SessionOutput.audio] upon     receipt. Stop playback immediately if an     [InterruptionSignal][google.cloud.ces.v1.BidiSessionServerMessage.interruption_signal]     is received (e.g., user barge-in or new agent response).</td>
 *      <td>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> bidiRunSessionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListLocations</td>
 *      <td><p> Lists information about the supported locations for this service.This method can be called in two ways:
 * <p> &#42;   &#42;&#42;List all public locations:&#42;&#42; Use the path `GET /v1/locations`.&#42;   &#42;&#42;List project-visible locations:&#42;&#42; Use the path`GET /v1/projects/{project_id}/locations`. This may include publiclocations as well as private or other locations specifically visibleto the project.</td>
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
 * <p>This class can be customized by passing in a custom instance of SessionServiceSettings to
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
 * SessionServiceSettings sessionServiceSettings =
 *     SessionServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * SessionServiceClient sessionServiceClient = SessionServiceClient.create(sessionServiceSettings);
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
 * SessionServiceSettings sessionServiceSettings =
 *     SessionServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * SessionServiceClient sessionServiceClient = SessionServiceClient.create(sessionServiceSettings);
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
 * SessionServiceSettings sessionServiceSettings =
 *     SessionServiceSettings.newHttpJsonBuilder().build();
 * SessionServiceClient sessionServiceClient = SessionServiceClient.create(sessionServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class SessionServiceClient implements BackgroundResource {
  private final SessionServiceSettings settings;
  private final SessionServiceStub stub;

  /** Constructs an instance of SessionServiceClient with default settings. */
  public static final SessionServiceClient create() throws IOException {
    return create(SessionServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of SessionServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final SessionServiceClient create(SessionServiceSettings settings)
      throws IOException {
    return new SessionServiceClient(settings);
  }

  /**
   * Constructs an instance of SessionServiceClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(SessionServiceSettings).
   */
  public static final SessionServiceClient create(SessionServiceStub stub) {
    return new SessionServiceClient(stub);
  }

  /**
   * Constructs an instance of SessionServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected SessionServiceClient(SessionServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((SessionServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected SessionServiceClient(SessionServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final SessionServiceSettings getSettings() {
    return settings;
  }

  public SessionServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Initiates a single turn interaction with the CES agent within a session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SessionServiceClient sessionServiceClient = SessionServiceClient.create()) {
   *   RunSessionRequest request =
   *       RunSessionRequest.newBuilder()
   *           .setConfig(SessionConfig.newBuilder().build())
   *           .addAllInputs(new ArrayList<SessionInput>())
   *           .build();
   *   RunSessionResponse response = sessionServiceClient.runSession(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RunSessionResponse runSession(RunSessionRequest request) {
    return runSessionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Initiates a single turn interaction with the CES agent within a session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SessionServiceClient sessionServiceClient = SessionServiceClient.create()) {
   *   RunSessionRequest request =
   *       RunSessionRequest.newBuilder()
   *           .setConfig(SessionConfig.newBuilder().build())
   *           .addAllInputs(new ArrayList<SessionInput>())
   *           .build();
   *   ApiFuture<RunSessionResponse> future =
   *       sessionServiceClient.runSessionCallable().futureCall(request);
   *   // Do something.
   *   RunSessionResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RunSessionRequest, RunSessionResponse> runSessionCallable() {
    return stub.runSessionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Establishes a bidirectional streaming connection with the CES agent. The agent processes
   * continuous multimodal inputs (e.g., text, audio) and generates real-time multimodal output
   * streams.
   *
   * <p>--- Client Request Stream --- The client streams requests in the following order:
   *
   * <p>1. Initialization: The first message must contain
   * [SessionConfig][google.cloud.ces.v1.BidiSessionClientMessage.config]. For audio sessions, this
   * should also include [InputAudioConfig][google.cloud.ces.v1.SessionConfig.input_audio_config]
   * and [OutputAudioConfig][google.cloud.ces.v1.SessionConfig.output_audio_config] to define audio
   * processing and synthesis parameters.
   *
   * <p>2. Interaction: Subsequent messages stream
   * [SessionInput][google.cloud.ces.v1.BidiSessionClientMessage.realtime_input] containing
   * real-time user input data.
   *
   * <p>3. Termination: The client should half-close the stream when there is no more user input. It
   * should also half-close upon receiving
   * [EndSession][google.cloud.ces.v1.BidiSessionServerMessage.end_session] or
   * [GoAway][google.cloud.ces.v1.BidiSessionServerMessage.go_away] from the agent.
   *
   * <p>--- Server Response Stream --- For each interaction turn, the agent streams messages in the
   * following sequence:
   *
   * <p>1. Speech Recognition (First N messages): Contains
   * [RecognitionResult][google.cloud.ces.v1.BidiSessionServerMessage.recognition_result]
   * representing the concatenated user speech segments captured so far. This is only populated for
   * audio sessions.
   *
   * <p>2. Response (Next M messages): Contains
   * [SessionOutput][google.cloud.ces.v1.BidiSessionServerMessage.session_output] delivering the
   * agent's response in various modalities (e.g., text, audio).
   *
   * <p>3. Turn Completion (Final message of the turn): Contains
   * [SessionOutput][google.cloud.ces.v1.BidiSessionServerMessage.session_output] with
   * [turn_completed][google.cloud.ces.v1.SessionOutput.turn_completed] set to true. This signals
   * the end of the current turn and includes
   * [DiagnosticInfo][google.cloud.ces.v1.SessionOutput.diagnostic_info] with execution details.
   *
   * <p>--- Audio Best Practices --- 1. Streaming: Stream [audio
   * data][google.cloud.ces.v1.SessionInput.audio] &#42;&#42;CONTINUOUSLY&#42;&#42;, even during
   * silence. Recommended chunk size: 40-120ms (balances latency vs. efficiency).
   *
   * <p>2. Playback &amp; Interruption: Play [audio
   * responses][google.cloud.ces.v1.SessionOutput.audio] upon receipt. Stop playback immediately if
   * an [InterruptionSignal][google.cloud.ces.v1.BidiSessionServerMessage.interruption_signal] is
   * received (e.g., user barge-in or new agent response).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SessionServiceClient sessionServiceClient = SessionServiceClient.create()) {
   *   BidiStream<BidiSessionClientMessage, BidiSessionServerMessage> bidiStream =
   *       sessionServiceClient.bidiRunSessionCallable().call();
   *   BidiSessionClientMessage request = BidiSessionClientMessage.newBuilder().build();
   *   bidiStream.send(request);
   *   for (BidiSessionServerMessage response : bidiStream) {
   *     // Do something when a response is received.
   *   }
   * }
   * }</pre>
   */
  public final BidiStreamingCallable<BidiSessionClientMessage, BidiSessionServerMessage>
      bidiRunSessionCallable() {
    return stub.bidiRunSessionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about the supported locations for this service.This method can be called in
   * two ways:
   *
   * <p>&#42; &#42;&#42;List all public locations:&#42;&#42; Use the path `GET /v1/locations`.&#42;
   * &#42;&#42;List project-visible locations:&#42;&#42; Use the path`GET
   * /v1/projects/{project_id}/locations`. This may include publiclocations as well as private or
   * other locations specifically visibleto the project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SessionServiceClient sessionServiceClient = SessionServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : sessionServiceClient.listLocations(request).iterateAll()) {
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
   * Lists information about the supported locations for this service.This method can be called in
   * two ways:
   *
   * <p>&#42; &#42;&#42;List all public locations:&#42;&#42; Use the path `GET /v1/locations`.&#42;
   * &#42;&#42;List project-visible locations:&#42;&#42; Use the path`GET
   * /v1/projects/{project_id}/locations`. This may include publiclocations as well as private or
   * other locations specifically visibleto the project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SessionServiceClient sessionServiceClient = SessionServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       sessionServiceClient.listLocationsPagedCallable().futureCall(request);
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
   * Lists information about the supported locations for this service.This method can be called in
   * two ways:
   *
   * <p>&#42; &#42;&#42;List all public locations:&#42;&#42; Use the path `GET /v1/locations`.&#42;
   * &#42;&#42;List project-visible locations:&#42;&#42; Use the path`GET
   * /v1/projects/{project_id}/locations`. This may include publiclocations as well as private or
   * other locations specifically visibleto the project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SessionServiceClient sessionServiceClient = SessionServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response = sessionServiceClient.listLocationsCallable().call(request);
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
   * try (SessionServiceClient sessionServiceClient = SessionServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = sessionServiceClient.getLocation(request);
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
   * try (SessionServiceClient sessionServiceClient = SessionServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future = sessionServiceClient.getLocationCallable().futureCall(request);
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
