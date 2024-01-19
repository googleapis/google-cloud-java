/*
 * Copyright 2023 Google LLC
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

package com.google.apps.meet.v2beta;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.apps.meet.v2beta.stub.ConferenceRecordsServiceStub;
import com.google.apps.meet.v2beta.stub.ConferenceRecordsServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: REST API for services dealing with conference records.
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
 * try (ConferenceRecordsServiceClient conferenceRecordsServiceClient =
 *     ConferenceRecordsServiceClient.create()) {
 *   ConferenceRecordName name = ConferenceRecordName.of("[CONFERENCE_RECORD]");
 *   ConferenceRecord response = conferenceRecordsServiceClient.getConferenceRecord(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the ConferenceRecordsServiceClient object to clean up
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
 *      <td><p> GetConferenceRecord</td>
 *      <td><p> [Developer Preview](https://developers.google.com/workspace/preview). Gets a conference record by conference ID.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getConferenceRecord(GetConferenceRecordRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getConferenceRecord(ConferenceRecordName name)
 *           <li><p> getConferenceRecord(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getConferenceRecordCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListConferenceRecords</td>
 *      <td><p> [Developer Preview](https://developers.google.com/workspace/preview). Lists the conference records by start time and in descending order.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listConferenceRecords(ListConferenceRecordsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listConferenceRecordsPagedCallable()
 *           <li><p> listConferenceRecordsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetParticipant</td>
 *      <td><p> [Developer Preview](https://developers.google.com/workspace/preview). Gets a participant by participant ID.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getParticipant(GetParticipantRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getParticipant(ParticipantName name)
 *           <li><p> getParticipant(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getParticipantCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListParticipants</td>
 *      <td><p> [Developer Preview](https://developers.google.com/workspace/preview). Lists the participants in a conference record, by default ordered by join time and in descending order. This API supports `fields` as standard parameters like every other API. However, when the `fields` request parameter is omitted, this API defaults to `'participants/&#42;, next_page_token'`.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listParticipants(ListParticipantsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listParticipants(ConferenceRecordName parent)
 *           <li><p> listParticipants(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listParticipantsPagedCallable()
 *           <li><p> listParticipantsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetParticipantSession</td>
 *      <td><p> [Developer Preview](https://developers.google.com/workspace/preview). Gets a participant session by participant session ID.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getParticipantSession(GetParticipantSessionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getParticipantSession(ParticipantSessionName name)
 *           <li><p> getParticipantSession(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getParticipantSessionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListParticipantSessions</td>
 *      <td><p> [Developer Preview](https://developers.google.com/workspace/preview). Lists the participant sessions of a participant in a conference record, by default ordered by join time and in descending order. This API supports `fields` as standard parameters like every other API. However, when the `fields` request parameter is omitted this API defaults to `'participantsessions/&#42;, next_page_token'`.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listParticipantSessions(ListParticipantSessionsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listParticipantSessions(ParticipantName parent)
 *           <li><p> listParticipantSessions(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listParticipantSessionsPagedCallable()
 *           <li><p> listParticipantSessionsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetRecording</td>
 *      <td><p> [Developer Preview](https://developers.google.com/workspace/preview). Gets a recording by recording ID.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getRecording(GetRecordingRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getRecording(RecordingName name)
 *           <li><p> getRecording(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getRecordingCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListRecordings</td>
 *      <td><p> [Developer Preview](https://developers.google.com/workspace/preview). Lists the recording resources from the conference record.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listRecordings(ListRecordingsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listRecordings(ConferenceRecordName parent)
 *           <li><p> listRecordings(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listRecordingsPagedCallable()
 *           <li><p> listRecordingsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetTranscript</td>
 *      <td><p> [Developer Preview](https://developers.google.com/workspace/preview). Gets a transcript by transcript ID.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getTranscript(GetTranscriptRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getTranscript(TranscriptName name)
 *           <li><p> getTranscript(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getTranscriptCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListTranscripts</td>
 *      <td><p> [Developer Preview](https://developers.google.com/workspace/preview). Lists the set of transcripts from the conference record.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listTranscripts(ListTranscriptsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listTranscripts(ConferenceRecordName parent)
 *           <li><p> listTranscripts(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listTranscriptsPagedCallable()
 *           <li><p> listTranscriptsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetTranscriptEntry</td>
 *      <td><p> [Developer Preview](https://developers.google.com/workspace/preview). Gets a `TranscriptEntry` resource by entry ID.
 * <p>  Note: The transcript entries returned by the Google Meet API might not match the transcription found in the Google Docs transcript file. This can occur when the Google Docs transcript file is modified after generation.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getTranscriptEntry(GetTranscriptEntryRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getTranscriptEntry(TranscriptEntryName name)
 *           <li><p> getTranscriptEntry(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getTranscriptEntryCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListTranscriptEntries</td>
 *      <td><p> [Developer Preview](https://developers.google.com/workspace/preview). Lists the structured transcript entries per transcript. By default, ordered by start time and in ascending order.
 * <p>  Note: The transcript entries returned by the Google Meet API might not match the transcription found in the Google Docs transcript file. This can occur when the Google Docs transcript file is modified after generation.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listTranscriptEntries(ListTranscriptEntriesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listTranscriptEntries(TranscriptName parent)
 *           <li><p> listTranscriptEntries(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listTranscriptEntriesPagedCallable()
 *           <li><p> listTranscriptEntriesCallable()
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
 * ConferenceRecordsServiceSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ConferenceRecordsServiceSettings conferenceRecordsServiceSettings =
 *     ConferenceRecordsServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ConferenceRecordsServiceClient conferenceRecordsServiceClient =
 *     ConferenceRecordsServiceClient.create(conferenceRecordsServiceSettings);
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
 * ConferenceRecordsServiceSettings conferenceRecordsServiceSettings =
 *     ConferenceRecordsServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ConferenceRecordsServiceClient conferenceRecordsServiceClient =
 *     ConferenceRecordsServiceClient.create(conferenceRecordsServiceSettings);
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
 * ConferenceRecordsServiceSettings conferenceRecordsServiceSettings =
 *     ConferenceRecordsServiceSettings.newHttpJsonBuilder().build();
 * ConferenceRecordsServiceClient conferenceRecordsServiceClient =
 *     ConferenceRecordsServiceClient.create(conferenceRecordsServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class ConferenceRecordsServiceClient implements BackgroundResource {
  private final ConferenceRecordsServiceSettings settings;
  private final ConferenceRecordsServiceStub stub;

  /** Constructs an instance of ConferenceRecordsServiceClient with default settings. */
  public static final ConferenceRecordsServiceClient create() throws IOException {
    return create(ConferenceRecordsServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ConferenceRecordsServiceClient, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final ConferenceRecordsServiceClient create(
      ConferenceRecordsServiceSettings settings) throws IOException {
    return new ConferenceRecordsServiceClient(settings);
  }

  /**
   * Constructs an instance of ConferenceRecordsServiceClient, using the given stub for making
   * calls. This is for advanced usage - prefer using create(ConferenceRecordsServiceSettings).
   */
  public static final ConferenceRecordsServiceClient create(ConferenceRecordsServiceStub stub) {
    return new ConferenceRecordsServiceClient(stub);
  }

  /**
   * Constructs an instance of ConferenceRecordsServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected ConferenceRecordsServiceClient(ConferenceRecordsServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((ConferenceRecordsServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected ConferenceRecordsServiceClient(ConferenceRecordsServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final ConferenceRecordsServiceSettings getSettings() {
    return settings;
  }

  public ConferenceRecordsServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * [Developer Preview](https://developers.google.com/workspace/preview). Gets a conference record
   * by conference ID.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConferenceRecordsServiceClient conferenceRecordsServiceClient =
   *     ConferenceRecordsServiceClient.create()) {
   *   ConferenceRecordName name = ConferenceRecordName.of("[CONFERENCE_RECORD]");
   *   ConferenceRecord response = conferenceRecordsServiceClient.getConferenceRecord(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the conference.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ConferenceRecord getConferenceRecord(ConferenceRecordName name) {
    GetConferenceRecordRequest request =
        GetConferenceRecordRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getConferenceRecord(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * [Developer Preview](https://developers.google.com/workspace/preview). Gets a conference record
   * by conference ID.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConferenceRecordsServiceClient conferenceRecordsServiceClient =
   *     ConferenceRecordsServiceClient.create()) {
   *   String name = ConferenceRecordName.of("[CONFERENCE_RECORD]").toString();
   *   ConferenceRecord response = conferenceRecordsServiceClient.getConferenceRecord(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the conference.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ConferenceRecord getConferenceRecord(String name) {
    GetConferenceRecordRequest request =
        GetConferenceRecordRequest.newBuilder().setName(name).build();
    return getConferenceRecord(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * [Developer Preview](https://developers.google.com/workspace/preview). Gets a conference record
   * by conference ID.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConferenceRecordsServiceClient conferenceRecordsServiceClient =
   *     ConferenceRecordsServiceClient.create()) {
   *   GetConferenceRecordRequest request =
   *       GetConferenceRecordRequest.newBuilder()
   *           .setName(ConferenceRecordName.of("[CONFERENCE_RECORD]").toString())
   *           .build();
   *   ConferenceRecord response = conferenceRecordsServiceClient.getConferenceRecord(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ConferenceRecord getConferenceRecord(GetConferenceRecordRequest request) {
    return getConferenceRecordCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * [Developer Preview](https://developers.google.com/workspace/preview). Gets a conference record
   * by conference ID.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConferenceRecordsServiceClient conferenceRecordsServiceClient =
   *     ConferenceRecordsServiceClient.create()) {
   *   GetConferenceRecordRequest request =
   *       GetConferenceRecordRequest.newBuilder()
   *           .setName(ConferenceRecordName.of("[CONFERENCE_RECORD]").toString())
   *           .build();
   *   ApiFuture<ConferenceRecord> future =
   *       conferenceRecordsServiceClient.getConferenceRecordCallable().futureCall(request);
   *   // Do something.
   *   ConferenceRecord response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetConferenceRecordRequest, ConferenceRecord>
      getConferenceRecordCallable() {
    return stub.getConferenceRecordCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * [Developer Preview](https://developers.google.com/workspace/preview). Lists the conference
   * records by start time and in descending order.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConferenceRecordsServiceClient conferenceRecordsServiceClient =
   *     ConferenceRecordsServiceClient.create()) {
   *   ListConferenceRecordsRequest request =
   *       ListConferenceRecordsRequest.newBuilder()
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (ConferenceRecord element :
   *       conferenceRecordsServiceClient.listConferenceRecords(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListConferenceRecordsPagedResponse listConferenceRecords(
      ListConferenceRecordsRequest request) {
    return listConferenceRecordsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * [Developer Preview](https://developers.google.com/workspace/preview). Lists the conference
   * records by start time and in descending order.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConferenceRecordsServiceClient conferenceRecordsServiceClient =
   *     ConferenceRecordsServiceClient.create()) {
   *   ListConferenceRecordsRequest request =
   *       ListConferenceRecordsRequest.newBuilder()
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<ConferenceRecord> future =
   *       conferenceRecordsServiceClient.listConferenceRecordsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (ConferenceRecord element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListConferenceRecordsRequest, ListConferenceRecordsPagedResponse>
      listConferenceRecordsPagedCallable() {
    return stub.listConferenceRecordsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * [Developer Preview](https://developers.google.com/workspace/preview). Lists the conference
   * records by start time and in descending order.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConferenceRecordsServiceClient conferenceRecordsServiceClient =
   *     ConferenceRecordsServiceClient.create()) {
   *   ListConferenceRecordsRequest request =
   *       ListConferenceRecordsRequest.newBuilder()
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListConferenceRecordsResponse response =
   *         conferenceRecordsServiceClient.listConferenceRecordsCallable().call(request);
   *     for (ConferenceRecord element : response.getConferenceRecordsList()) {
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
  public final UnaryCallable<ListConferenceRecordsRequest, ListConferenceRecordsResponse>
      listConferenceRecordsCallable() {
    return stub.listConferenceRecordsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * [Developer Preview](https://developers.google.com/workspace/preview). Gets a participant by
   * participant ID.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConferenceRecordsServiceClient conferenceRecordsServiceClient =
   *     ConferenceRecordsServiceClient.create()) {
   *   ParticipantName name = ParticipantName.of("[CONFERENCE_RECORD]", "[PARTICIPANT]");
   *   Participant response = conferenceRecordsServiceClient.getParticipant(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the participant.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Participant getParticipant(ParticipantName name) {
    GetParticipantRequest request =
        GetParticipantRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getParticipant(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * [Developer Preview](https://developers.google.com/workspace/preview). Gets a participant by
   * participant ID.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConferenceRecordsServiceClient conferenceRecordsServiceClient =
   *     ConferenceRecordsServiceClient.create()) {
   *   String name = ParticipantName.of("[CONFERENCE_RECORD]", "[PARTICIPANT]").toString();
   *   Participant response = conferenceRecordsServiceClient.getParticipant(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the participant.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Participant getParticipant(String name) {
    GetParticipantRequest request = GetParticipantRequest.newBuilder().setName(name).build();
    return getParticipant(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * [Developer Preview](https://developers.google.com/workspace/preview). Gets a participant by
   * participant ID.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConferenceRecordsServiceClient conferenceRecordsServiceClient =
   *     ConferenceRecordsServiceClient.create()) {
   *   GetParticipantRequest request =
   *       GetParticipantRequest.newBuilder()
   *           .setName(ParticipantName.of("[CONFERENCE_RECORD]", "[PARTICIPANT]").toString())
   *           .build();
   *   Participant response = conferenceRecordsServiceClient.getParticipant(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Participant getParticipant(GetParticipantRequest request) {
    return getParticipantCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * [Developer Preview](https://developers.google.com/workspace/preview). Gets a participant by
   * participant ID.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConferenceRecordsServiceClient conferenceRecordsServiceClient =
   *     ConferenceRecordsServiceClient.create()) {
   *   GetParticipantRequest request =
   *       GetParticipantRequest.newBuilder()
   *           .setName(ParticipantName.of("[CONFERENCE_RECORD]", "[PARTICIPANT]").toString())
   *           .build();
   *   ApiFuture<Participant> future =
   *       conferenceRecordsServiceClient.getParticipantCallable().futureCall(request);
   *   // Do something.
   *   Participant response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetParticipantRequest, Participant> getParticipantCallable() {
    return stub.getParticipantCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * [Developer Preview](https://developers.google.com/workspace/preview). Lists the participants in
   * a conference record, by default ordered by join time and in descending order. This API supports
   * `fields` as standard parameters like every other API. However, when the `fields` request
   * parameter is omitted, this API defaults to `'participants/&#42;, next_page_token'`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConferenceRecordsServiceClient conferenceRecordsServiceClient =
   *     ConferenceRecordsServiceClient.create()) {
   *   ConferenceRecordName parent = ConferenceRecordName.of("[CONFERENCE_RECORD]");
   *   for (Participant element :
   *       conferenceRecordsServiceClient.listParticipants(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Format: `conferenceRecords/{conference_record}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListParticipantsPagedResponse listParticipants(ConferenceRecordName parent) {
    ListParticipantsRequest request =
        ListParticipantsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listParticipants(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * [Developer Preview](https://developers.google.com/workspace/preview). Lists the participants in
   * a conference record, by default ordered by join time and in descending order. This API supports
   * `fields` as standard parameters like every other API. However, when the `fields` request
   * parameter is omitted, this API defaults to `'participants/&#42;, next_page_token'`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConferenceRecordsServiceClient conferenceRecordsServiceClient =
   *     ConferenceRecordsServiceClient.create()) {
   *   String parent = ConferenceRecordName.of("[CONFERENCE_RECORD]").toString();
   *   for (Participant element :
   *       conferenceRecordsServiceClient.listParticipants(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Format: `conferenceRecords/{conference_record}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListParticipantsPagedResponse listParticipants(String parent) {
    ListParticipantsRequest request =
        ListParticipantsRequest.newBuilder().setParent(parent).build();
    return listParticipants(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * [Developer Preview](https://developers.google.com/workspace/preview). Lists the participants in
   * a conference record, by default ordered by join time and in descending order. This API supports
   * `fields` as standard parameters like every other API. However, when the `fields` request
   * parameter is omitted, this API defaults to `'participants/&#42;, next_page_token'`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConferenceRecordsServiceClient conferenceRecordsServiceClient =
   *     ConferenceRecordsServiceClient.create()) {
   *   ListParticipantsRequest request =
   *       ListParticipantsRequest.newBuilder()
   *           .setParent(ConferenceRecordName.of("[CONFERENCE_RECORD]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (Participant element :
   *       conferenceRecordsServiceClient.listParticipants(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListParticipantsPagedResponse listParticipants(ListParticipantsRequest request) {
    return listParticipantsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * [Developer Preview](https://developers.google.com/workspace/preview). Lists the participants in
   * a conference record, by default ordered by join time and in descending order. This API supports
   * `fields` as standard parameters like every other API. However, when the `fields` request
   * parameter is omitted, this API defaults to `'participants/&#42;, next_page_token'`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConferenceRecordsServiceClient conferenceRecordsServiceClient =
   *     ConferenceRecordsServiceClient.create()) {
   *   ListParticipantsRequest request =
   *       ListParticipantsRequest.newBuilder()
   *           .setParent(ConferenceRecordName.of("[CONFERENCE_RECORD]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<Participant> future =
   *       conferenceRecordsServiceClient.listParticipantsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Participant element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListParticipantsRequest, ListParticipantsPagedResponse>
      listParticipantsPagedCallable() {
    return stub.listParticipantsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * [Developer Preview](https://developers.google.com/workspace/preview). Lists the participants in
   * a conference record, by default ordered by join time and in descending order. This API supports
   * `fields` as standard parameters like every other API. However, when the `fields` request
   * parameter is omitted, this API defaults to `'participants/&#42;, next_page_token'`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConferenceRecordsServiceClient conferenceRecordsServiceClient =
   *     ConferenceRecordsServiceClient.create()) {
   *   ListParticipantsRequest request =
   *       ListParticipantsRequest.newBuilder()
   *           .setParent(ConferenceRecordName.of("[CONFERENCE_RECORD]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListParticipantsResponse response =
   *         conferenceRecordsServiceClient.listParticipantsCallable().call(request);
   *     for (Participant element : response.getParticipantsList()) {
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
  public final UnaryCallable<ListParticipantsRequest, ListParticipantsResponse>
      listParticipantsCallable() {
    return stub.listParticipantsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * [Developer Preview](https://developers.google.com/workspace/preview). Gets a participant
   * session by participant session ID.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConferenceRecordsServiceClient conferenceRecordsServiceClient =
   *     ConferenceRecordsServiceClient.create()) {
   *   ParticipantSessionName name =
   *       ParticipantSessionName.of(
   *           "[CONFERENCE_RECORD]", "[PARTICIPANT]", "[PARTICIPANT_SESSION]");
   *   ParticipantSession response = conferenceRecordsServiceClient.getParticipantSession(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the participant.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ParticipantSession getParticipantSession(ParticipantSessionName name) {
    GetParticipantSessionRequest request =
        GetParticipantSessionRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getParticipantSession(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * [Developer Preview](https://developers.google.com/workspace/preview). Gets a participant
   * session by participant session ID.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConferenceRecordsServiceClient conferenceRecordsServiceClient =
   *     ConferenceRecordsServiceClient.create()) {
   *   String name =
   *       ParticipantSessionName.of("[CONFERENCE_RECORD]", "[PARTICIPANT]", "[PARTICIPANT_SESSION]")
   *           .toString();
   *   ParticipantSession response = conferenceRecordsServiceClient.getParticipantSession(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the participant.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ParticipantSession getParticipantSession(String name) {
    GetParticipantSessionRequest request =
        GetParticipantSessionRequest.newBuilder().setName(name).build();
    return getParticipantSession(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * [Developer Preview](https://developers.google.com/workspace/preview). Gets a participant
   * session by participant session ID.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConferenceRecordsServiceClient conferenceRecordsServiceClient =
   *     ConferenceRecordsServiceClient.create()) {
   *   GetParticipantSessionRequest request =
   *       GetParticipantSessionRequest.newBuilder()
   *           .setName(
   *               ParticipantSessionName.of(
   *                       "[CONFERENCE_RECORD]", "[PARTICIPANT]", "[PARTICIPANT_SESSION]")
   *                   .toString())
   *           .build();
   *   ParticipantSession response = conferenceRecordsServiceClient.getParticipantSession(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ParticipantSession getParticipantSession(GetParticipantSessionRequest request) {
    return getParticipantSessionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * [Developer Preview](https://developers.google.com/workspace/preview). Gets a participant
   * session by participant session ID.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConferenceRecordsServiceClient conferenceRecordsServiceClient =
   *     ConferenceRecordsServiceClient.create()) {
   *   GetParticipantSessionRequest request =
   *       GetParticipantSessionRequest.newBuilder()
   *           .setName(
   *               ParticipantSessionName.of(
   *                       "[CONFERENCE_RECORD]", "[PARTICIPANT]", "[PARTICIPANT_SESSION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<ParticipantSession> future =
   *       conferenceRecordsServiceClient.getParticipantSessionCallable().futureCall(request);
   *   // Do something.
   *   ParticipantSession response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetParticipantSessionRequest, ParticipantSession>
      getParticipantSessionCallable() {
    return stub.getParticipantSessionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * [Developer Preview](https://developers.google.com/workspace/preview). Lists the participant
   * sessions of a participant in a conference record, by default ordered by join time and in
   * descending order. This API supports `fields` as standard parameters like every other API.
   * However, when the `fields` request parameter is omitted this API defaults to
   * `'participantsessions/&#42;, next_page_token'`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConferenceRecordsServiceClient conferenceRecordsServiceClient =
   *     ConferenceRecordsServiceClient.create()) {
   *   ParticipantName parent = ParticipantName.of("[CONFERENCE_RECORD]", "[PARTICIPANT]");
   *   for (ParticipantSession element :
   *       conferenceRecordsServiceClient.listParticipantSessions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Format:
   *     `conferenceRecords/{conference_record}/participants/{participant}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListParticipantSessionsPagedResponse listParticipantSessions(
      ParticipantName parent) {
    ListParticipantSessionsRequest request =
        ListParticipantSessionsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listParticipantSessions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * [Developer Preview](https://developers.google.com/workspace/preview). Lists the participant
   * sessions of a participant in a conference record, by default ordered by join time and in
   * descending order. This API supports `fields` as standard parameters like every other API.
   * However, when the `fields` request parameter is omitted this API defaults to
   * `'participantsessions/&#42;, next_page_token'`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConferenceRecordsServiceClient conferenceRecordsServiceClient =
   *     ConferenceRecordsServiceClient.create()) {
   *   String parent = ParticipantName.of("[CONFERENCE_RECORD]", "[PARTICIPANT]").toString();
   *   for (ParticipantSession element :
   *       conferenceRecordsServiceClient.listParticipantSessions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Format:
   *     `conferenceRecords/{conference_record}/participants/{participant}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListParticipantSessionsPagedResponse listParticipantSessions(String parent) {
    ListParticipantSessionsRequest request =
        ListParticipantSessionsRequest.newBuilder().setParent(parent).build();
    return listParticipantSessions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * [Developer Preview](https://developers.google.com/workspace/preview). Lists the participant
   * sessions of a participant in a conference record, by default ordered by join time and in
   * descending order. This API supports `fields` as standard parameters like every other API.
   * However, when the `fields` request parameter is omitted this API defaults to
   * `'participantsessions/&#42;, next_page_token'`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConferenceRecordsServiceClient conferenceRecordsServiceClient =
   *     ConferenceRecordsServiceClient.create()) {
   *   ListParticipantSessionsRequest request =
   *       ListParticipantSessionsRequest.newBuilder()
   *           .setParent(ParticipantName.of("[CONFERENCE_RECORD]", "[PARTICIPANT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (ParticipantSession element :
   *       conferenceRecordsServiceClient.listParticipantSessions(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListParticipantSessionsPagedResponse listParticipantSessions(
      ListParticipantSessionsRequest request) {
    return listParticipantSessionsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * [Developer Preview](https://developers.google.com/workspace/preview). Lists the participant
   * sessions of a participant in a conference record, by default ordered by join time and in
   * descending order. This API supports `fields` as standard parameters like every other API.
   * However, when the `fields` request parameter is omitted this API defaults to
   * `'participantsessions/&#42;, next_page_token'`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConferenceRecordsServiceClient conferenceRecordsServiceClient =
   *     ConferenceRecordsServiceClient.create()) {
   *   ListParticipantSessionsRequest request =
   *       ListParticipantSessionsRequest.newBuilder()
   *           .setParent(ParticipantName.of("[CONFERENCE_RECORD]", "[PARTICIPANT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<ParticipantSession> future =
   *       conferenceRecordsServiceClient.listParticipantSessionsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (ParticipantSession element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListParticipantSessionsRequest, ListParticipantSessionsPagedResponse>
      listParticipantSessionsPagedCallable() {
    return stub.listParticipantSessionsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * [Developer Preview](https://developers.google.com/workspace/preview). Lists the participant
   * sessions of a participant in a conference record, by default ordered by join time and in
   * descending order. This API supports `fields` as standard parameters like every other API.
   * However, when the `fields` request parameter is omitted this API defaults to
   * `'participantsessions/&#42;, next_page_token'`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConferenceRecordsServiceClient conferenceRecordsServiceClient =
   *     ConferenceRecordsServiceClient.create()) {
   *   ListParticipantSessionsRequest request =
   *       ListParticipantSessionsRequest.newBuilder()
   *           .setParent(ParticipantName.of("[CONFERENCE_RECORD]", "[PARTICIPANT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListParticipantSessionsResponse response =
   *         conferenceRecordsServiceClient.listParticipantSessionsCallable().call(request);
   *     for (ParticipantSession element : response.getParticipantSessionsList()) {
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
  public final UnaryCallable<ListParticipantSessionsRequest, ListParticipantSessionsResponse>
      listParticipantSessionsCallable() {
    return stub.listParticipantSessionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * [Developer Preview](https://developers.google.com/workspace/preview). Gets a recording by
   * recording ID.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConferenceRecordsServiceClient conferenceRecordsServiceClient =
   *     ConferenceRecordsServiceClient.create()) {
   *   RecordingName name = RecordingName.of("[CONFERENCE_RECORD]", "[RECORDING]");
   *   Recording response = conferenceRecordsServiceClient.getRecording(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the recording.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Recording getRecording(RecordingName name) {
    GetRecordingRequest request =
        GetRecordingRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getRecording(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * [Developer Preview](https://developers.google.com/workspace/preview). Gets a recording by
   * recording ID.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConferenceRecordsServiceClient conferenceRecordsServiceClient =
   *     ConferenceRecordsServiceClient.create()) {
   *   String name = RecordingName.of("[CONFERENCE_RECORD]", "[RECORDING]").toString();
   *   Recording response = conferenceRecordsServiceClient.getRecording(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the recording.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Recording getRecording(String name) {
    GetRecordingRequest request = GetRecordingRequest.newBuilder().setName(name).build();
    return getRecording(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * [Developer Preview](https://developers.google.com/workspace/preview). Gets a recording by
   * recording ID.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConferenceRecordsServiceClient conferenceRecordsServiceClient =
   *     ConferenceRecordsServiceClient.create()) {
   *   GetRecordingRequest request =
   *       GetRecordingRequest.newBuilder()
   *           .setName(RecordingName.of("[CONFERENCE_RECORD]", "[RECORDING]").toString())
   *           .build();
   *   Recording response = conferenceRecordsServiceClient.getRecording(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Recording getRecording(GetRecordingRequest request) {
    return getRecordingCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * [Developer Preview](https://developers.google.com/workspace/preview). Gets a recording by
   * recording ID.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConferenceRecordsServiceClient conferenceRecordsServiceClient =
   *     ConferenceRecordsServiceClient.create()) {
   *   GetRecordingRequest request =
   *       GetRecordingRequest.newBuilder()
   *           .setName(RecordingName.of("[CONFERENCE_RECORD]", "[RECORDING]").toString())
   *           .build();
   *   ApiFuture<Recording> future =
   *       conferenceRecordsServiceClient.getRecordingCallable().futureCall(request);
   *   // Do something.
   *   Recording response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetRecordingRequest, Recording> getRecordingCallable() {
    return stub.getRecordingCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * [Developer Preview](https://developers.google.com/workspace/preview). Lists the recording
   * resources from the conference record.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConferenceRecordsServiceClient conferenceRecordsServiceClient =
   *     ConferenceRecordsServiceClient.create()) {
   *   ConferenceRecordName parent = ConferenceRecordName.of("[CONFERENCE_RECORD]");
   *   for (Recording element : conferenceRecordsServiceClient.listRecordings(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Format: `conferenceRecords/{conference_record}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRecordingsPagedResponse listRecordings(ConferenceRecordName parent) {
    ListRecordingsRequest request =
        ListRecordingsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listRecordings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * [Developer Preview](https://developers.google.com/workspace/preview). Lists the recording
   * resources from the conference record.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConferenceRecordsServiceClient conferenceRecordsServiceClient =
   *     ConferenceRecordsServiceClient.create()) {
   *   String parent = ConferenceRecordName.of("[CONFERENCE_RECORD]").toString();
   *   for (Recording element : conferenceRecordsServiceClient.listRecordings(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Format: `conferenceRecords/{conference_record}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRecordingsPagedResponse listRecordings(String parent) {
    ListRecordingsRequest request = ListRecordingsRequest.newBuilder().setParent(parent).build();
    return listRecordings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * [Developer Preview](https://developers.google.com/workspace/preview). Lists the recording
   * resources from the conference record.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConferenceRecordsServiceClient conferenceRecordsServiceClient =
   *     ConferenceRecordsServiceClient.create()) {
   *   ListRecordingsRequest request =
   *       ListRecordingsRequest.newBuilder()
   *           .setParent(ConferenceRecordName.of("[CONFERENCE_RECORD]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Recording element :
   *       conferenceRecordsServiceClient.listRecordings(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRecordingsPagedResponse listRecordings(ListRecordingsRequest request) {
    return listRecordingsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * [Developer Preview](https://developers.google.com/workspace/preview). Lists the recording
   * resources from the conference record.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConferenceRecordsServiceClient conferenceRecordsServiceClient =
   *     ConferenceRecordsServiceClient.create()) {
   *   ListRecordingsRequest request =
   *       ListRecordingsRequest.newBuilder()
   *           .setParent(ConferenceRecordName.of("[CONFERENCE_RECORD]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Recording> future =
   *       conferenceRecordsServiceClient.listRecordingsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Recording element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListRecordingsRequest, ListRecordingsPagedResponse>
      listRecordingsPagedCallable() {
    return stub.listRecordingsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * [Developer Preview](https://developers.google.com/workspace/preview). Lists the recording
   * resources from the conference record.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConferenceRecordsServiceClient conferenceRecordsServiceClient =
   *     ConferenceRecordsServiceClient.create()) {
   *   ListRecordingsRequest request =
   *       ListRecordingsRequest.newBuilder()
   *           .setParent(ConferenceRecordName.of("[CONFERENCE_RECORD]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListRecordingsResponse response =
   *         conferenceRecordsServiceClient.listRecordingsCallable().call(request);
   *     for (Recording element : response.getRecordingsList()) {
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
  public final UnaryCallable<ListRecordingsRequest, ListRecordingsResponse>
      listRecordingsCallable() {
    return stub.listRecordingsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * [Developer Preview](https://developers.google.com/workspace/preview). Gets a transcript by
   * transcript ID.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConferenceRecordsServiceClient conferenceRecordsServiceClient =
   *     ConferenceRecordsServiceClient.create()) {
   *   TranscriptName name = TranscriptName.of("[CONFERENCE_RECORD]", "[TRANSCRIPT]");
   *   Transcript response = conferenceRecordsServiceClient.getTranscript(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the transcript.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Transcript getTranscript(TranscriptName name) {
    GetTranscriptRequest request =
        GetTranscriptRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getTranscript(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * [Developer Preview](https://developers.google.com/workspace/preview). Gets a transcript by
   * transcript ID.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConferenceRecordsServiceClient conferenceRecordsServiceClient =
   *     ConferenceRecordsServiceClient.create()) {
   *   String name = TranscriptName.of("[CONFERENCE_RECORD]", "[TRANSCRIPT]").toString();
   *   Transcript response = conferenceRecordsServiceClient.getTranscript(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the transcript.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Transcript getTranscript(String name) {
    GetTranscriptRequest request = GetTranscriptRequest.newBuilder().setName(name).build();
    return getTranscript(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * [Developer Preview](https://developers.google.com/workspace/preview). Gets a transcript by
   * transcript ID.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConferenceRecordsServiceClient conferenceRecordsServiceClient =
   *     ConferenceRecordsServiceClient.create()) {
   *   GetTranscriptRequest request =
   *       GetTranscriptRequest.newBuilder()
   *           .setName(TranscriptName.of("[CONFERENCE_RECORD]", "[TRANSCRIPT]").toString())
   *           .build();
   *   Transcript response = conferenceRecordsServiceClient.getTranscript(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Transcript getTranscript(GetTranscriptRequest request) {
    return getTranscriptCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * [Developer Preview](https://developers.google.com/workspace/preview). Gets a transcript by
   * transcript ID.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConferenceRecordsServiceClient conferenceRecordsServiceClient =
   *     ConferenceRecordsServiceClient.create()) {
   *   GetTranscriptRequest request =
   *       GetTranscriptRequest.newBuilder()
   *           .setName(TranscriptName.of("[CONFERENCE_RECORD]", "[TRANSCRIPT]").toString())
   *           .build();
   *   ApiFuture<Transcript> future =
   *       conferenceRecordsServiceClient.getTranscriptCallable().futureCall(request);
   *   // Do something.
   *   Transcript response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetTranscriptRequest, Transcript> getTranscriptCallable() {
    return stub.getTranscriptCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * [Developer Preview](https://developers.google.com/workspace/preview). Lists the set of
   * transcripts from the conference record.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConferenceRecordsServiceClient conferenceRecordsServiceClient =
   *     ConferenceRecordsServiceClient.create()) {
   *   ConferenceRecordName parent = ConferenceRecordName.of("[CONFERENCE_RECORD]");
   *   for (Transcript element :
   *       conferenceRecordsServiceClient.listTranscripts(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Format: `conferenceRecords/{conference_record}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTranscriptsPagedResponse listTranscripts(ConferenceRecordName parent) {
    ListTranscriptsRequest request =
        ListTranscriptsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listTranscripts(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * [Developer Preview](https://developers.google.com/workspace/preview). Lists the set of
   * transcripts from the conference record.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConferenceRecordsServiceClient conferenceRecordsServiceClient =
   *     ConferenceRecordsServiceClient.create()) {
   *   String parent = ConferenceRecordName.of("[CONFERENCE_RECORD]").toString();
   *   for (Transcript element :
   *       conferenceRecordsServiceClient.listTranscripts(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Format: `conferenceRecords/{conference_record}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTranscriptsPagedResponse listTranscripts(String parent) {
    ListTranscriptsRequest request = ListTranscriptsRequest.newBuilder().setParent(parent).build();
    return listTranscripts(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * [Developer Preview](https://developers.google.com/workspace/preview). Lists the set of
   * transcripts from the conference record.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConferenceRecordsServiceClient conferenceRecordsServiceClient =
   *     ConferenceRecordsServiceClient.create()) {
   *   ListTranscriptsRequest request =
   *       ListTranscriptsRequest.newBuilder()
   *           .setParent(ConferenceRecordName.of("[CONFERENCE_RECORD]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Transcript element :
   *       conferenceRecordsServiceClient.listTranscripts(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTranscriptsPagedResponse listTranscripts(ListTranscriptsRequest request) {
    return listTranscriptsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * [Developer Preview](https://developers.google.com/workspace/preview). Lists the set of
   * transcripts from the conference record.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConferenceRecordsServiceClient conferenceRecordsServiceClient =
   *     ConferenceRecordsServiceClient.create()) {
   *   ListTranscriptsRequest request =
   *       ListTranscriptsRequest.newBuilder()
   *           .setParent(ConferenceRecordName.of("[CONFERENCE_RECORD]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Transcript> future =
   *       conferenceRecordsServiceClient.listTranscriptsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Transcript element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListTranscriptsRequest, ListTranscriptsPagedResponse>
      listTranscriptsPagedCallable() {
    return stub.listTranscriptsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * [Developer Preview](https://developers.google.com/workspace/preview). Lists the set of
   * transcripts from the conference record.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConferenceRecordsServiceClient conferenceRecordsServiceClient =
   *     ConferenceRecordsServiceClient.create()) {
   *   ListTranscriptsRequest request =
   *       ListTranscriptsRequest.newBuilder()
   *           .setParent(ConferenceRecordName.of("[CONFERENCE_RECORD]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListTranscriptsResponse response =
   *         conferenceRecordsServiceClient.listTranscriptsCallable().call(request);
   *     for (Transcript element : response.getTranscriptsList()) {
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
  public final UnaryCallable<ListTranscriptsRequest, ListTranscriptsResponse>
      listTranscriptsCallable() {
    return stub.listTranscriptsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * [Developer Preview](https://developers.google.com/workspace/preview). Gets a `TranscriptEntry`
   * resource by entry ID.
   *
   * <p>Note: The transcript entries returned by the Google Meet API might not match the
   * transcription found in the Google Docs transcript file. This can occur when the Google Docs
   * transcript file is modified after generation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConferenceRecordsServiceClient conferenceRecordsServiceClient =
   *     ConferenceRecordsServiceClient.create()) {
   *   TranscriptEntryName name =
   *       TranscriptEntryName.of("[CONFERENCE_RECORD]", "[TRANSCRIPT]", "[ENTRY]");
   *   TranscriptEntry response = conferenceRecordsServiceClient.getTranscriptEntry(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the `TranscriptEntry`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TranscriptEntry getTranscriptEntry(TranscriptEntryName name) {
    GetTranscriptEntryRequest request =
        GetTranscriptEntryRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getTranscriptEntry(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * [Developer Preview](https://developers.google.com/workspace/preview). Gets a `TranscriptEntry`
   * resource by entry ID.
   *
   * <p>Note: The transcript entries returned by the Google Meet API might not match the
   * transcription found in the Google Docs transcript file. This can occur when the Google Docs
   * transcript file is modified after generation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConferenceRecordsServiceClient conferenceRecordsServiceClient =
   *     ConferenceRecordsServiceClient.create()) {
   *   String name =
   *       TranscriptEntryName.of("[CONFERENCE_RECORD]", "[TRANSCRIPT]", "[ENTRY]").toString();
   *   TranscriptEntry response = conferenceRecordsServiceClient.getTranscriptEntry(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the `TranscriptEntry`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TranscriptEntry getTranscriptEntry(String name) {
    GetTranscriptEntryRequest request =
        GetTranscriptEntryRequest.newBuilder().setName(name).build();
    return getTranscriptEntry(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * [Developer Preview](https://developers.google.com/workspace/preview). Gets a `TranscriptEntry`
   * resource by entry ID.
   *
   * <p>Note: The transcript entries returned by the Google Meet API might not match the
   * transcription found in the Google Docs transcript file. This can occur when the Google Docs
   * transcript file is modified after generation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConferenceRecordsServiceClient conferenceRecordsServiceClient =
   *     ConferenceRecordsServiceClient.create()) {
   *   GetTranscriptEntryRequest request =
   *       GetTranscriptEntryRequest.newBuilder()
   *           .setName(
   *               TranscriptEntryName.of("[CONFERENCE_RECORD]", "[TRANSCRIPT]", "[ENTRY]")
   *                   .toString())
   *           .build();
   *   TranscriptEntry response = conferenceRecordsServiceClient.getTranscriptEntry(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TranscriptEntry getTranscriptEntry(GetTranscriptEntryRequest request) {
    return getTranscriptEntryCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * [Developer Preview](https://developers.google.com/workspace/preview). Gets a `TranscriptEntry`
   * resource by entry ID.
   *
   * <p>Note: The transcript entries returned by the Google Meet API might not match the
   * transcription found in the Google Docs transcript file. This can occur when the Google Docs
   * transcript file is modified after generation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConferenceRecordsServiceClient conferenceRecordsServiceClient =
   *     ConferenceRecordsServiceClient.create()) {
   *   GetTranscriptEntryRequest request =
   *       GetTranscriptEntryRequest.newBuilder()
   *           .setName(
   *               TranscriptEntryName.of("[CONFERENCE_RECORD]", "[TRANSCRIPT]", "[ENTRY]")
   *                   .toString())
   *           .build();
   *   ApiFuture<TranscriptEntry> future =
   *       conferenceRecordsServiceClient.getTranscriptEntryCallable().futureCall(request);
   *   // Do something.
   *   TranscriptEntry response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetTranscriptEntryRequest, TranscriptEntry>
      getTranscriptEntryCallable() {
    return stub.getTranscriptEntryCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * [Developer Preview](https://developers.google.com/workspace/preview). Lists the structured
   * transcript entries per transcript. By default, ordered by start time and in ascending order.
   *
   * <p>Note: The transcript entries returned by the Google Meet API might not match the
   * transcription found in the Google Docs transcript file. This can occur when the Google Docs
   * transcript file is modified after generation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConferenceRecordsServiceClient conferenceRecordsServiceClient =
   *     ConferenceRecordsServiceClient.create()) {
   *   TranscriptName parent = TranscriptName.of("[CONFERENCE_RECORD]", "[TRANSCRIPT]");
   *   for (TranscriptEntry element :
   *       conferenceRecordsServiceClient.listTranscriptEntries(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Format:
   *     `conferenceRecords/{conference_record}/transcripts/{transcript}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTranscriptEntriesPagedResponse listTranscriptEntries(TranscriptName parent) {
    ListTranscriptEntriesRequest request =
        ListTranscriptEntriesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listTranscriptEntries(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * [Developer Preview](https://developers.google.com/workspace/preview). Lists the structured
   * transcript entries per transcript. By default, ordered by start time and in ascending order.
   *
   * <p>Note: The transcript entries returned by the Google Meet API might not match the
   * transcription found in the Google Docs transcript file. This can occur when the Google Docs
   * transcript file is modified after generation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConferenceRecordsServiceClient conferenceRecordsServiceClient =
   *     ConferenceRecordsServiceClient.create()) {
   *   String parent = TranscriptName.of("[CONFERENCE_RECORD]", "[TRANSCRIPT]").toString();
   *   for (TranscriptEntry element :
   *       conferenceRecordsServiceClient.listTranscriptEntries(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Format:
   *     `conferenceRecords/{conference_record}/transcripts/{transcript}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTranscriptEntriesPagedResponse listTranscriptEntries(String parent) {
    ListTranscriptEntriesRequest request =
        ListTranscriptEntriesRequest.newBuilder().setParent(parent).build();
    return listTranscriptEntries(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * [Developer Preview](https://developers.google.com/workspace/preview). Lists the structured
   * transcript entries per transcript. By default, ordered by start time and in ascending order.
   *
   * <p>Note: The transcript entries returned by the Google Meet API might not match the
   * transcription found in the Google Docs transcript file. This can occur when the Google Docs
   * transcript file is modified after generation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConferenceRecordsServiceClient conferenceRecordsServiceClient =
   *     ConferenceRecordsServiceClient.create()) {
   *   ListTranscriptEntriesRequest request =
   *       ListTranscriptEntriesRequest.newBuilder()
   *           .setParent(TranscriptName.of("[CONFERENCE_RECORD]", "[TRANSCRIPT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (TranscriptEntry element :
   *       conferenceRecordsServiceClient.listTranscriptEntries(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTranscriptEntriesPagedResponse listTranscriptEntries(
      ListTranscriptEntriesRequest request) {
    return listTranscriptEntriesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * [Developer Preview](https://developers.google.com/workspace/preview). Lists the structured
   * transcript entries per transcript. By default, ordered by start time and in ascending order.
   *
   * <p>Note: The transcript entries returned by the Google Meet API might not match the
   * transcription found in the Google Docs transcript file. This can occur when the Google Docs
   * transcript file is modified after generation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConferenceRecordsServiceClient conferenceRecordsServiceClient =
   *     ConferenceRecordsServiceClient.create()) {
   *   ListTranscriptEntriesRequest request =
   *       ListTranscriptEntriesRequest.newBuilder()
   *           .setParent(TranscriptName.of("[CONFERENCE_RECORD]", "[TRANSCRIPT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<TranscriptEntry> future =
   *       conferenceRecordsServiceClient.listTranscriptEntriesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (TranscriptEntry element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListTranscriptEntriesRequest, ListTranscriptEntriesPagedResponse>
      listTranscriptEntriesPagedCallable() {
    return stub.listTranscriptEntriesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * [Developer Preview](https://developers.google.com/workspace/preview). Lists the structured
   * transcript entries per transcript. By default, ordered by start time and in ascending order.
   *
   * <p>Note: The transcript entries returned by the Google Meet API might not match the
   * transcription found in the Google Docs transcript file. This can occur when the Google Docs
   * transcript file is modified after generation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConferenceRecordsServiceClient conferenceRecordsServiceClient =
   *     ConferenceRecordsServiceClient.create()) {
   *   ListTranscriptEntriesRequest request =
   *       ListTranscriptEntriesRequest.newBuilder()
   *           .setParent(TranscriptName.of("[CONFERENCE_RECORD]", "[TRANSCRIPT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListTranscriptEntriesResponse response =
   *         conferenceRecordsServiceClient.listTranscriptEntriesCallable().call(request);
   *     for (TranscriptEntry element : response.getTranscriptEntriesList()) {
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
  public final UnaryCallable<ListTranscriptEntriesRequest, ListTranscriptEntriesResponse>
      listTranscriptEntriesCallable() {
    return stub.listTranscriptEntriesCallable();
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

  public static class ListConferenceRecordsPagedResponse
      extends AbstractPagedListResponse<
          ListConferenceRecordsRequest,
          ListConferenceRecordsResponse,
          ConferenceRecord,
          ListConferenceRecordsPage,
          ListConferenceRecordsFixedSizeCollection> {

    public static ApiFuture<ListConferenceRecordsPagedResponse> createAsync(
        PageContext<ListConferenceRecordsRequest, ListConferenceRecordsResponse, ConferenceRecord>
            context,
        ApiFuture<ListConferenceRecordsResponse> futureResponse) {
      ApiFuture<ListConferenceRecordsPage> futurePage =
          ListConferenceRecordsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListConferenceRecordsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListConferenceRecordsPagedResponse(ListConferenceRecordsPage page) {
      super(page, ListConferenceRecordsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListConferenceRecordsPage
      extends AbstractPage<
          ListConferenceRecordsRequest,
          ListConferenceRecordsResponse,
          ConferenceRecord,
          ListConferenceRecordsPage> {

    private ListConferenceRecordsPage(
        PageContext<ListConferenceRecordsRequest, ListConferenceRecordsResponse, ConferenceRecord>
            context,
        ListConferenceRecordsResponse response) {
      super(context, response);
    }

    private static ListConferenceRecordsPage createEmptyPage() {
      return new ListConferenceRecordsPage(null, null);
    }

    @Override
    protected ListConferenceRecordsPage createPage(
        PageContext<ListConferenceRecordsRequest, ListConferenceRecordsResponse, ConferenceRecord>
            context,
        ListConferenceRecordsResponse response) {
      return new ListConferenceRecordsPage(context, response);
    }

    @Override
    public ApiFuture<ListConferenceRecordsPage> createPageAsync(
        PageContext<ListConferenceRecordsRequest, ListConferenceRecordsResponse, ConferenceRecord>
            context,
        ApiFuture<ListConferenceRecordsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListConferenceRecordsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListConferenceRecordsRequest,
          ListConferenceRecordsResponse,
          ConferenceRecord,
          ListConferenceRecordsPage,
          ListConferenceRecordsFixedSizeCollection> {

    private ListConferenceRecordsFixedSizeCollection(
        List<ListConferenceRecordsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListConferenceRecordsFixedSizeCollection createEmptyCollection() {
      return new ListConferenceRecordsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListConferenceRecordsFixedSizeCollection createCollection(
        List<ListConferenceRecordsPage> pages, int collectionSize) {
      return new ListConferenceRecordsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListParticipantsPagedResponse
      extends AbstractPagedListResponse<
          ListParticipantsRequest,
          ListParticipantsResponse,
          Participant,
          ListParticipantsPage,
          ListParticipantsFixedSizeCollection> {

    public static ApiFuture<ListParticipantsPagedResponse> createAsync(
        PageContext<ListParticipantsRequest, ListParticipantsResponse, Participant> context,
        ApiFuture<ListParticipantsResponse> futureResponse) {
      ApiFuture<ListParticipantsPage> futurePage =
          ListParticipantsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListParticipantsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListParticipantsPagedResponse(ListParticipantsPage page) {
      super(page, ListParticipantsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListParticipantsPage
      extends AbstractPage<
          ListParticipantsRequest, ListParticipantsResponse, Participant, ListParticipantsPage> {

    private ListParticipantsPage(
        PageContext<ListParticipantsRequest, ListParticipantsResponse, Participant> context,
        ListParticipantsResponse response) {
      super(context, response);
    }

    private static ListParticipantsPage createEmptyPage() {
      return new ListParticipantsPage(null, null);
    }

    @Override
    protected ListParticipantsPage createPage(
        PageContext<ListParticipantsRequest, ListParticipantsResponse, Participant> context,
        ListParticipantsResponse response) {
      return new ListParticipantsPage(context, response);
    }

    @Override
    public ApiFuture<ListParticipantsPage> createPageAsync(
        PageContext<ListParticipantsRequest, ListParticipantsResponse, Participant> context,
        ApiFuture<ListParticipantsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListParticipantsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListParticipantsRequest,
          ListParticipantsResponse,
          Participant,
          ListParticipantsPage,
          ListParticipantsFixedSizeCollection> {

    private ListParticipantsFixedSizeCollection(
        List<ListParticipantsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListParticipantsFixedSizeCollection createEmptyCollection() {
      return new ListParticipantsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListParticipantsFixedSizeCollection createCollection(
        List<ListParticipantsPage> pages, int collectionSize) {
      return new ListParticipantsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListParticipantSessionsPagedResponse
      extends AbstractPagedListResponse<
          ListParticipantSessionsRequest,
          ListParticipantSessionsResponse,
          ParticipantSession,
          ListParticipantSessionsPage,
          ListParticipantSessionsFixedSizeCollection> {

    public static ApiFuture<ListParticipantSessionsPagedResponse> createAsync(
        PageContext<
                ListParticipantSessionsRequest, ListParticipantSessionsResponse, ParticipantSession>
            context,
        ApiFuture<ListParticipantSessionsResponse> futureResponse) {
      ApiFuture<ListParticipantSessionsPage> futurePage =
          ListParticipantSessionsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListParticipantSessionsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListParticipantSessionsPagedResponse(ListParticipantSessionsPage page) {
      super(page, ListParticipantSessionsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListParticipantSessionsPage
      extends AbstractPage<
          ListParticipantSessionsRequest,
          ListParticipantSessionsResponse,
          ParticipantSession,
          ListParticipantSessionsPage> {

    private ListParticipantSessionsPage(
        PageContext<
                ListParticipantSessionsRequest, ListParticipantSessionsResponse, ParticipantSession>
            context,
        ListParticipantSessionsResponse response) {
      super(context, response);
    }

    private static ListParticipantSessionsPage createEmptyPage() {
      return new ListParticipantSessionsPage(null, null);
    }

    @Override
    protected ListParticipantSessionsPage createPage(
        PageContext<
                ListParticipantSessionsRequest, ListParticipantSessionsResponse, ParticipantSession>
            context,
        ListParticipantSessionsResponse response) {
      return new ListParticipantSessionsPage(context, response);
    }

    @Override
    public ApiFuture<ListParticipantSessionsPage> createPageAsync(
        PageContext<
                ListParticipantSessionsRequest, ListParticipantSessionsResponse, ParticipantSession>
            context,
        ApiFuture<ListParticipantSessionsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListParticipantSessionsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListParticipantSessionsRequest,
          ListParticipantSessionsResponse,
          ParticipantSession,
          ListParticipantSessionsPage,
          ListParticipantSessionsFixedSizeCollection> {

    private ListParticipantSessionsFixedSizeCollection(
        List<ListParticipantSessionsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListParticipantSessionsFixedSizeCollection createEmptyCollection() {
      return new ListParticipantSessionsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListParticipantSessionsFixedSizeCollection createCollection(
        List<ListParticipantSessionsPage> pages, int collectionSize) {
      return new ListParticipantSessionsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListRecordingsPagedResponse
      extends AbstractPagedListResponse<
          ListRecordingsRequest,
          ListRecordingsResponse,
          Recording,
          ListRecordingsPage,
          ListRecordingsFixedSizeCollection> {

    public static ApiFuture<ListRecordingsPagedResponse> createAsync(
        PageContext<ListRecordingsRequest, ListRecordingsResponse, Recording> context,
        ApiFuture<ListRecordingsResponse> futureResponse) {
      ApiFuture<ListRecordingsPage> futurePage =
          ListRecordingsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListRecordingsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListRecordingsPagedResponse(ListRecordingsPage page) {
      super(page, ListRecordingsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListRecordingsPage
      extends AbstractPage<
          ListRecordingsRequest, ListRecordingsResponse, Recording, ListRecordingsPage> {

    private ListRecordingsPage(
        PageContext<ListRecordingsRequest, ListRecordingsResponse, Recording> context,
        ListRecordingsResponse response) {
      super(context, response);
    }

    private static ListRecordingsPage createEmptyPage() {
      return new ListRecordingsPage(null, null);
    }

    @Override
    protected ListRecordingsPage createPage(
        PageContext<ListRecordingsRequest, ListRecordingsResponse, Recording> context,
        ListRecordingsResponse response) {
      return new ListRecordingsPage(context, response);
    }

    @Override
    public ApiFuture<ListRecordingsPage> createPageAsync(
        PageContext<ListRecordingsRequest, ListRecordingsResponse, Recording> context,
        ApiFuture<ListRecordingsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListRecordingsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListRecordingsRequest,
          ListRecordingsResponse,
          Recording,
          ListRecordingsPage,
          ListRecordingsFixedSizeCollection> {

    private ListRecordingsFixedSizeCollection(List<ListRecordingsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListRecordingsFixedSizeCollection createEmptyCollection() {
      return new ListRecordingsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListRecordingsFixedSizeCollection createCollection(
        List<ListRecordingsPage> pages, int collectionSize) {
      return new ListRecordingsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListTranscriptsPagedResponse
      extends AbstractPagedListResponse<
          ListTranscriptsRequest,
          ListTranscriptsResponse,
          Transcript,
          ListTranscriptsPage,
          ListTranscriptsFixedSizeCollection> {

    public static ApiFuture<ListTranscriptsPagedResponse> createAsync(
        PageContext<ListTranscriptsRequest, ListTranscriptsResponse, Transcript> context,
        ApiFuture<ListTranscriptsResponse> futureResponse) {
      ApiFuture<ListTranscriptsPage> futurePage =
          ListTranscriptsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListTranscriptsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListTranscriptsPagedResponse(ListTranscriptsPage page) {
      super(page, ListTranscriptsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListTranscriptsPage
      extends AbstractPage<
          ListTranscriptsRequest, ListTranscriptsResponse, Transcript, ListTranscriptsPage> {

    private ListTranscriptsPage(
        PageContext<ListTranscriptsRequest, ListTranscriptsResponse, Transcript> context,
        ListTranscriptsResponse response) {
      super(context, response);
    }

    private static ListTranscriptsPage createEmptyPage() {
      return new ListTranscriptsPage(null, null);
    }

    @Override
    protected ListTranscriptsPage createPage(
        PageContext<ListTranscriptsRequest, ListTranscriptsResponse, Transcript> context,
        ListTranscriptsResponse response) {
      return new ListTranscriptsPage(context, response);
    }

    @Override
    public ApiFuture<ListTranscriptsPage> createPageAsync(
        PageContext<ListTranscriptsRequest, ListTranscriptsResponse, Transcript> context,
        ApiFuture<ListTranscriptsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListTranscriptsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListTranscriptsRequest,
          ListTranscriptsResponse,
          Transcript,
          ListTranscriptsPage,
          ListTranscriptsFixedSizeCollection> {

    private ListTranscriptsFixedSizeCollection(
        List<ListTranscriptsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListTranscriptsFixedSizeCollection createEmptyCollection() {
      return new ListTranscriptsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListTranscriptsFixedSizeCollection createCollection(
        List<ListTranscriptsPage> pages, int collectionSize) {
      return new ListTranscriptsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListTranscriptEntriesPagedResponse
      extends AbstractPagedListResponse<
          ListTranscriptEntriesRequest,
          ListTranscriptEntriesResponse,
          TranscriptEntry,
          ListTranscriptEntriesPage,
          ListTranscriptEntriesFixedSizeCollection> {

    public static ApiFuture<ListTranscriptEntriesPagedResponse> createAsync(
        PageContext<ListTranscriptEntriesRequest, ListTranscriptEntriesResponse, TranscriptEntry>
            context,
        ApiFuture<ListTranscriptEntriesResponse> futureResponse) {
      ApiFuture<ListTranscriptEntriesPage> futurePage =
          ListTranscriptEntriesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListTranscriptEntriesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListTranscriptEntriesPagedResponse(ListTranscriptEntriesPage page) {
      super(page, ListTranscriptEntriesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListTranscriptEntriesPage
      extends AbstractPage<
          ListTranscriptEntriesRequest,
          ListTranscriptEntriesResponse,
          TranscriptEntry,
          ListTranscriptEntriesPage> {

    private ListTranscriptEntriesPage(
        PageContext<ListTranscriptEntriesRequest, ListTranscriptEntriesResponse, TranscriptEntry>
            context,
        ListTranscriptEntriesResponse response) {
      super(context, response);
    }

    private static ListTranscriptEntriesPage createEmptyPage() {
      return new ListTranscriptEntriesPage(null, null);
    }

    @Override
    protected ListTranscriptEntriesPage createPage(
        PageContext<ListTranscriptEntriesRequest, ListTranscriptEntriesResponse, TranscriptEntry>
            context,
        ListTranscriptEntriesResponse response) {
      return new ListTranscriptEntriesPage(context, response);
    }

    @Override
    public ApiFuture<ListTranscriptEntriesPage> createPageAsync(
        PageContext<ListTranscriptEntriesRequest, ListTranscriptEntriesResponse, TranscriptEntry>
            context,
        ApiFuture<ListTranscriptEntriesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListTranscriptEntriesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListTranscriptEntriesRequest,
          ListTranscriptEntriesResponse,
          TranscriptEntry,
          ListTranscriptEntriesPage,
          ListTranscriptEntriesFixedSizeCollection> {

    private ListTranscriptEntriesFixedSizeCollection(
        List<ListTranscriptEntriesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListTranscriptEntriesFixedSizeCollection createEmptyCollection() {
      return new ListTranscriptEntriesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListTranscriptEntriesFixedSizeCollection createCollection(
        List<ListTranscriptEntriesPage> pages, int collectionSize) {
      return new ListTranscriptEntriesFixedSizeCollection(pages, collectionSize);
    }
  }
}
