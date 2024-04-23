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

package com.google.apps.meet.v2.stub;

import static com.google.apps.meet.v2.ConferenceRecordsServiceClient.ListConferenceRecordsPagedResponse;
import static com.google.apps.meet.v2.ConferenceRecordsServiceClient.ListParticipantSessionsPagedResponse;
import static com.google.apps.meet.v2.ConferenceRecordsServiceClient.ListParticipantsPagedResponse;
import static com.google.apps.meet.v2.ConferenceRecordsServiceClient.ListRecordingsPagedResponse;
import static com.google.apps.meet.v2.ConferenceRecordsServiceClient.ListTranscriptEntriesPagedResponse;
import static com.google.apps.meet.v2.ConferenceRecordsServiceClient.ListTranscriptsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.HttpJsonTransportChannel;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.PagedListDescriptor;
import com.google.api.gax.rpc.PagedListResponseFactory;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.apps.meet.v2.ConferenceRecord;
import com.google.apps.meet.v2.GetConferenceRecordRequest;
import com.google.apps.meet.v2.GetParticipantRequest;
import com.google.apps.meet.v2.GetParticipantSessionRequest;
import com.google.apps.meet.v2.GetRecordingRequest;
import com.google.apps.meet.v2.GetTranscriptEntryRequest;
import com.google.apps.meet.v2.GetTranscriptRequest;
import com.google.apps.meet.v2.ListConferenceRecordsRequest;
import com.google.apps.meet.v2.ListConferenceRecordsResponse;
import com.google.apps.meet.v2.ListParticipantSessionsRequest;
import com.google.apps.meet.v2.ListParticipantSessionsResponse;
import com.google.apps.meet.v2.ListParticipantsRequest;
import com.google.apps.meet.v2.ListParticipantsResponse;
import com.google.apps.meet.v2.ListRecordingsRequest;
import com.google.apps.meet.v2.ListRecordingsResponse;
import com.google.apps.meet.v2.ListTranscriptEntriesRequest;
import com.google.apps.meet.v2.ListTranscriptEntriesResponse;
import com.google.apps.meet.v2.ListTranscriptsRequest;
import com.google.apps.meet.v2.ListTranscriptsResponse;
import com.google.apps.meet.v2.Participant;
import com.google.apps.meet.v2.ParticipantSession;
import com.google.apps.meet.v2.Recording;
import com.google.apps.meet.v2.Transcript;
import com.google.apps.meet.v2.TranscriptEntry;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link ConferenceRecordsServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (meet.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getConferenceRecord to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ConferenceRecordsServiceStubSettings.Builder conferenceRecordsServiceSettingsBuilder =
 *     ConferenceRecordsServiceStubSettings.newBuilder();
 * conferenceRecordsServiceSettingsBuilder
 *     .getConferenceRecordSettings()
 *     .setRetrySettings(
 *         conferenceRecordsServiceSettingsBuilder
 *             .getConferenceRecordSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * ConferenceRecordsServiceStubSettings conferenceRecordsServiceSettings =
 *     conferenceRecordsServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class ConferenceRecordsServiceStubSettings
    extends StubSettings<ConferenceRecordsServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/meetings.space.created")
          .add("https://www.googleapis.com/auth/meetings.space.readonly")
          .build();

  private final UnaryCallSettings<GetConferenceRecordRequest, ConferenceRecord>
      getConferenceRecordSettings;
  private final PagedCallSettings<
          ListConferenceRecordsRequest,
          ListConferenceRecordsResponse,
          ListConferenceRecordsPagedResponse>
      listConferenceRecordsSettings;
  private final UnaryCallSettings<GetParticipantRequest, Participant> getParticipantSettings;
  private final PagedCallSettings<
          ListParticipantsRequest, ListParticipantsResponse, ListParticipantsPagedResponse>
      listParticipantsSettings;
  private final UnaryCallSettings<GetParticipantSessionRequest, ParticipantSession>
      getParticipantSessionSettings;
  private final PagedCallSettings<
          ListParticipantSessionsRequest,
          ListParticipantSessionsResponse,
          ListParticipantSessionsPagedResponse>
      listParticipantSessionsSettings;
  private final UnaryCallSettings<GetRecordingRequest, Recording> getRecordingSettings;
  private final PagedCallSettings<
          ListRecordingsRequest, ListRecordingsResponse, ListRecordingsPagedResponse>
      listRecordingsSettings;
  private final UnaryCallSettings<GetTranscriptRequest, Transcript> getTranscriptSettings;
  private final PagedCallSettings<
          ListTranscriptsRequest, ListTranscriptsResponse, ListTranscriptsPagedResponse>
      listTranscriptsSettings;
  private final UnaryCallSettings<GetTranscriptEntryRequest, TranscriptEntry>
      getTranscriptEntrySettings;
  private final PagedCallSettings<
          ListTranscriptEntriesRequest,
          ListTranscriptEntriesResponse,
          ListTranscriptEntriesPagedResponse>
      listTranscriptEntriesSettings;

  private static final PagedListDescriptor<
          ListConferenceRecordsRequest, ListConferenceRecordsResponse, ConferenceRecord>
      LIST_CONFERENCE_RECORDS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListConferenceRecordsRequest, ListConferenceRecordsResponse, ConferenceRecord>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListConferenceRecordsRequest injectToken(
                ListConferenceRecordsRequest payload, String token) {
              return ListConferenceRecordsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListConferenceRecordsRequest injectPageSize(
                ListConferenceRecordsRequest payload, int pageSize) {
              return ListConferenceRecordsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListConferenceRecordsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListConferenceRecordsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<ConferenceRecord> extractResources(
                ListConferenceRecordsResponse payload) {
              return payload.getConferenceRecordsList() == null
                  ? ImmutableList.<ConferenceRecord>of()
                  : payload.getConferenceRecordsList();
            }
          };

  private static final PagedListDescriptor<
          ListParticipantsRequest, ListParticipantsResponse, Participant>
      LIST_PARTICIPANTS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListParticipantsRequest, ListParticipantsResponse, Participant>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListParticipantsRequest injectToken(
                ListParticipantsRequest payload, String token) {
              return ListParticipantsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListParticipantsRequest injectPageSize(
                ListParticipantsRequest payload, int pageSize) {
              return ListParticipantsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListParticipantsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListParticipantsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Participant> extractResources(ListParticipantsResponse payload) {
              return payload.getParticipantsList() == null
                  ? ImmutableList.<Participant>of()
                  : payload.getParticipantsList();
            }
          };

  private static final PagedListDescriptor<
          ListParticipantSessionsRequest, ListParticipantSessionsResponse, ParticipantSession>
      LIST_PARTICIPANT_SESSIONS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListParticipantSessionsRequest,
              ListParticipantSessionsResponse,
              ParticipantSession>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListParticipantSessionsRequest injectToken(
                ListParticipantSessionsRequest payload, String token) {
              return ListParticipantSessionsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListParticipantSessionsRequest injectPageSize(
                ListParticipantSessionsRequest payload, int pageSize) {
              return ListParticipantSessionsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListParticipantSessionsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListParticipantSessionsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<ParticipantSession> extractResources(
                ListParticipantSessionsResponse payload) {
              return payload.getParticipantSessionsList() == null
                  ? ImmutableList.<ParticipantSession>of()
                  : payload.getParticipantSessionsList();
            }
          };

  private static final PagedListDescriptor<ListRecordingsRequest, ListRecordingsResponse, Recording>
      LIST_RECORDINGS_PAGE_STR_DESC =
          new PagedListDescriptor<ListRecordingsRequest, ListRecordingsResponse, Recording>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListRecordingsRequest injectToken(ListRecordingsRequest payload, String token) {
              return ListRecordingsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListRecordingsRequest injectPageSize(
                ListRecordingsRequest payload, int pageSize) {
              return ListRecordingsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListRecordingsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListRecordingsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Recording> extractResources(ListRecordingsResponse payload) {
              return payload.getRecordingsList() == null
                  ? ImmutableList.<Recording>of()
                  : payload.getRecordingsList();
            }
          };

  private static final PagedListDescriptor<
          ListTranscriptsRequest, ListTranscriptsResponse, Transcript>
      LIST_TRANSCRIPTS_PAGE_STR_DESC =
          new PagedListDescriptor<ListTranscriptsRequest, ListTranscriptsResponse, Transcript>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListTranscriptsRequest injectToken(
                ListTranscriptsRequest payload, String token) {
              return ListTranscriptsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListTranscriptsRequest injectPageSize(
                ListTranscriptsRequest payload, int pageSize) {
              return ListTranscriptsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListTranscriptsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListTranscriptsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Transcript> extractResources(ListTranscriptsResponse payload) {
              return payload.getTranscriptsList() == null
                  ? ImmutableList.<Transcript>of()
                  : payload.getTranscriptsList();
            }
          };

  private static final PagedListDescriptor<
          ListTranscriptEntriesRequest, ListTranscriptEntriesResponse, TranscriptEntry>
      LIST_TRANSCRIPT_ENTRIES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListTranscriptEntriesRequest, ListTranscriptEntriesResponse, TranscriptEntry>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListTranscriptEntriesRequest injectToken(
                ListTranscriptEntriesRequest payload, String token) {
              return ListTranscriptEntriesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListTranscriptEntriesRequest injectPageSize(
                ListTranscriptEntriesRequest payload, int pageSize) {
              return ListTranscriptEntriesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListTranscriptEntriesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListTranscriptEntriesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<TranscriptEntry> extractResources(
                ListTranscriptEntriesResponse payload) {
              return payload.getTranscriptEntriesList() == null
                  ? ImmutableList.<TranscriptEntry>of()
                  : payload.getTranscriptEntriesList();
            }
          };

  private static final PagedListResponseFactory<
          ListConferenceRecordsRequest,
          ListConferenceRecordsResponse,
          ListConferenceRecordsPagedResponse>
      LIST_CONFERENCE_RECORDS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListConferenceRecordsRequest,
              ListConferenceRecordsResponse,
              ListConferenceRecordsPagedResponse>() {
            @Override
            public ApiFuture<ListConferenceRecordsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListConferenceRecordsRequest, ListConferenceRecordsResponse> callable,
                ListConferenceRecordsRequest request,
                ApiCallContext context,
                ApiFuture<ListConferenceRecordsResponse> futureResponse) {
              PageContext<
                      ListConferenceRecordsRequest, ListConferenceRecordsResponse, ConferenceRecord>
                  pageContext =
                      PageContext.create(
                          callable, LIST_CONFERENCE_RECORDS_PAGE_STR_DESC, request, context);
              return ListConferenceRecordsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListParticipantsRequest, ListParticipantsResponse, ListParticipantsPagedResponse>
      LIST_PARTICIPANTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListParticipantsRequest, ListParticipantsResponse, ListParticipantsPagedResponse>() {
            @Override
            public ApiFuture<ListParticipantsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListParticipantsRequest, ListParticipantsResponse> callable,
                ListParticipantsRequest request,
                ApiCallContext context,
                ApiFuture<ListParticipantsResponse> futureResponse) {
              PageContext<ListParticipantsRequest, ListParticipantsResponse, Participant>
                  pageContext =
                      PageContext.create(
                          callable, LIST_PARTICIPANTS_PAGE_STR_DESC, request, context);
              return ListParticipantsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListParticipantSessionsRequest,
          ListParticipantSessionsResponse,
          ListParticipantSessionsPagedResponse>
      LIST_PARTICIPANT_SESSIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListParticipantSessionsRequest,
              ListParticipantSessionsResponse,
              ListParticipantSessionsPagedResponse>() {
            @Override
            public ApiFuture<ListParticipantSessionsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListParticipantSessionsRequest, ListParticipantSessionsResponse>
                    callable,
                ListParticipantSessionsRequest request,
                ApiCallContext context,
                ApiFuture<ListParticipantSessionsResponse> futureResponse) {
              PageContext<
                      ListParticipantSessionsRequest,
                      ListParticipantSessionsResponse,
                      ParticipantSession>
                  pageContext =
                      PageContext.create(
                          callable, LIST_PARTICIPANT_SESSIONS_PAGE_STR_DESC, request, context);
              return ListParticipantSessionsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListRecordingsRequest, ListRecordingsResponse, ListRecordingsPagedResponse>
      LIST_RECORDINGS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListRecordingsRequest, ListRecordingsResponse, ListRecordingsPagedResponse>() {
            @Override
            public ApiFuture<ListRecordingsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListRecordingsRequest, ListRecordingsResponse> callable,
                ListRecordingsRequest request,
                ApiCallContext context,
                ApiFuture<ListRecordingsResponse> futureResponse) {
              PageContext<ListRecordingsRequest, ListRecordingsResponse, Recording> pageContext =
                  PageContext.create(callable, LIST_RECORDINGS_PAGE_STR_DESC, request, context);
              return ListRecordingsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListTranscriptsRequest, ListTranscriptsResponse, ListTranscriptsPagedResponse>
      LIST_TRANSCRIPTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListTranscriptsRequest, ListTranscriptsResponse, ListTranscriptsPagedResponse>() {
            @Override
            public ApiFuture<ListTranscriptsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListTranscriptsRequest, ListTranscriptsResponse> callable,
                ListTranscriptsRequest request,
                ApiCallContext context,
                ApiFuture<ListTranscriptsResponse> futureResponse) {
              PageContext<ListTranscriptsRequest, ListTranscriptsResponse, Transcript> pageContext =
                  PageContext.create(callable, LIST_TRANSCRIPTS_PAGE_STR_DESC, request, context);
              return ListTranscriptsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListTranscriptEntriesRequest,
          ListTranscriptEntriesResponse,
          ListTranscriptEntriesPagedResponse>
      LIST_TRANSCRIPT_ENTRIES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListTranscriptEntriesRequest,
              ListTranscriptEntriesResponse,
              ListTranscriptEntriesPagedResponse>() {
            @Override
            public ApiFuture<ListTranscriptEntriesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListTranscriptEntriesRequest, ListTranscriptEntriesResponse> callable,
                ListTranscriptEntriesRequest request,
                ApiCallContext context,
                ApiFuture<ListTranscriptEntriesResponse> futureResponse) {
              PageContext<
                      ListTranscriptEntriesRequest, ListTranscriptEntriesResponse, TranscriptEntry>
                  pageContext =
                      PageContext.create(
                          callable, LIST_TRANSCRIPT_ENTRIES_PAGE_STR_DESC, request, context);
              return ListTranscriptEntriesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to getConferenceRecord. */
  public UnaryCallSettings<GetConferenceRecordRequest, ConferenceRecord>
      getConferenceRecordSettings() {
    return getConferenceRecordSettings;
  }

  /** Returns the object with the settings used for calls to listConferenceRecords. */
  public PagedCallSettings<
          ListConferenceRecordsRequest,
          ListConferenceRecordsResponse,
          ListConferenceRecordsPagedResponse>
      listConferenceRecordsSettings() {
    return listConferenceRecordsSettings;
  }

  /** Returns the object with the settings used for calls to getParticipant. */
  public UnaryCallSettings<GetParticipantRequest, Participant> getParticipantSettings() {
    return getParticipantSettings;
  }

  /** Returns the object with the settings used for calls to listParticipants. */
  public PagedCallSettings<
          ListParticipantsRequest, ListParticipantsResponse, ListParticipantsPagedResponse>
      listParticipantsSettings() {
    return listParticipantsSettings;
  }

  /** Returns the object with the settings used for calls to getParticipantSession. */
  public UnaryCallSettings<GetParticipantSessionRequest, ParticipantSession>
      getParticipantSessionSettings() {
    return getParticipantSessionSettings;
  }

  /** Returns the object with the settings used for calls to listParticipantSessions. */
  public PagedCallSettings<
          ListParticipantSessionsRequest,
          ListParticipantSessionsResponse,
          ListParticipantSessionsPagedResponse>
      listParticipantSessionsSettings() {
    return listParticipantSessionsSettings;
  }

  /** Returns the object with the settings used for calls to getRecording. */
  public UnaryCallSettings<GetRecordingRequest, Recording> getRecordingSettings() {
    return getRecordingSettings;
  }

  /** Returns the object with the settings used for calls to listRecordings. */
  public PagedCallSettings<
          ListRecordingsRequest, ListRecordingsResponse, ListRecordingsPagedResponse>
      listRecordingsSettings() {
    return listRecordingsSettings;
  }

  /** Returns the object with the settings used for calls to getTranscript. */
  public UnaryCallSettings<GetTranscriptRequest, Transcript> getTranscriptSettings() {
    return getTranscriptSettings;
  }

  /** Returns the object with the settings used for calls to listTranscripts. */
  public PagedCallSettings<
          ListTranscriptsRequest, ListTranscriptsResponse, ListTranscriptsPagedResponse>
      listTranscriptsSettings() {
    return listTranscriptsSettings;
  }

  /** Returns the object with the settings used for calls to getTranscriptEntry. */
  public UnaryCallSettings<GetTranscriptEntryRequest, TranscriptEntry>
      getTranscriptEntrySettings() {
    return getTranscriptEntrySettings;
  }

  /** Returns the object with the settings used for calls to listTranscriptEntries. */
  public PagedCallSettings<
          ListTranscriptEntriesRequest,
          ListTranscriptEntriesResponse,
          ListTranscriptEntriesPagedResponse>
      listTranscriptEntriesSettings() {
    return listTranscriptEntriesSettings;
  }

  public ConferenceRecordsServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcConferenceRecordsServiceStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonConferenceRecordsServiceStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "meet";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "meet.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "meet.mtls.googleapis.com:443";
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return DEFAULT_SERVICE_SCOPES;
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return GoogleCredentialsProvider.newBuilder()
        .setScopesToApply(DEFAULT_SERVICE_SCOPES)
        .setUseJwtAccessWithScope(true);
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return InstantiatingGrpcChannelProvider.newBuilder()
        .setMaxInboundMessageSize(Integer.MAX_VALUE);
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return InstantiatingHttpJsonChannelProvider.newBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultGrpcTransportProviderBuilder().build();
  }

  public static ApiClientHeaderProvider.Builder defaultGrpcApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(ConferenceRecordsServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(ConferenceRecordsServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ConferenceRecordsServiceStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
  }

  /** Returns a new gRPC builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new REST builder for this class. */
  public static Builder newHttpJsonBuilder() {
    return Builder.createHttpJsonDefault();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder(ClientContext clientContext) {
    return new Builder(clientContext);
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  protected ConferenceRecordsServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    getConferenceRecordSettings = settingsBuilder.getConferenceRecordSettings().build();
    listConferenceRecordsSettings = settingsBuilder.listConferenceRecordsSettings().build();
    getParticipantSettings = settingsBuilder.getParticipantSettings().build();
    listParticipantsSettings = settingsBuilder.listParticipantsSettings().build();
    getParticipantSessionSettings = settingsBuilder.getParticipantSessionSettings().build();
    listParticipantSessionsSettings = settingsBuilder.listParticipantSessionsSettings().build();
    getRecordingSettings = settingsBuilder.getRecordingSettings().build();
    listRecordingsSettings = settingsBuilder.listRecordingsSettings().build();
    getTranscriptSettings = settingsBuilder.getTranscriptSettings().build();
    listTranscriptsSettings = settingsBuilder.listTranscriptsSettings().build();
    getTranscriptEntrySettings = settingsBuilder.getTranscriptEntrySettings().build();
    listTranscriptEntriesSettings = settingsBuilder.listTranscriptEntriesSettings().build();
  }

  /** Builder for ConferenceRecordsServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<ConferenceRecordsServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<GetConferenceRecordRequest, ConferenceRecord>
        getConferenceRecordSettings;
    private final PagedCallSettings.Builder<
            ListConferenceRecordsRequest,
            ListConferenceRecordsResponse,
            ListConferenceRecordsPagedResponse>
        listConferenceRecordsSettings;
    private final UnaryCallSettings.Builder<GetParticipantRequest, Participant>
        getParticipantSettings;
    private final PagedCallSettings.Builder<
            ListParticipantsRequest, ListParticipantsResponse, ListParticipantsPagedResponse>
        listParticipantsSettings;
    private final UnaryCallSettings.Builder<GetParticipantSessionRequest, ParticipantSession>
        getParticipantSessionSettings;
    private final PagedCallSettings.Builder<
            ListParticipantSessionsRequest,
            ListParticipantSessionsResponse,
            ListParticipantSessionsPagedResponse>
        listParticipantSessionsSettings;
    private final UnaryCallSettings.Builder<GetRecordingRequest, Recording> getRecordingSettings;
    private final PagedCallSettings.Builder<
            ListRecordingsRequest, ListRecordingsResponse, ListRecordingsPagedResponse>
        listRecordingsSettings;
    private final UnaryCallSettings.Builder<GetTranscriptRequest, Transcript> getTranscriptSettings;
    private final PagedCallSettings.Builder<
            ListTranscriptsRequest, ListTranscriptsResponse, ListTranscriptsPagedResponse>
        listTranscriptsSettings;
    private final UnaryCallSettings.Builder<GetTranscriptEntryRequest, TranscriptEntry>
        getTranscriptEntrySettings;
    private final PagedCallSettings.Builder<
            ListTranscriptEntriesRequest,
            ListTranscriptEntriesResponse,
            ListTranscriptEntriesPagedResponse>
        listTranscriptEntriesSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "retry_policy_0_codes",
          ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList(StatusCode.Code.UNAVAILABLE)));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.ofMillis(1000L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.ofMillis(10000L))
              .setInitialRpcTimeout(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(60000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      getConferenceRecordSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listConferenceRecordsSettings =
          PagedCallSettings.newBuilder(LIST_CONFERENCE_RECORDS_PAGE_STR_FACT);
      getParticipantSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listParticipantsSettings = PagedCallSettings.newBuilder(LIST_PARTICIPANTS_PAGE_STR_FACT);
      getParticipantSessionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listParticipantSessionsSettings =
          PagedCallSettings.newBuilder(LIST_PARTICIPANT_SESSIONS_PAGE_STR_FACT);
      getRecordingSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listRecordingsSettings = PagedCallSettings.newBuilder(LIST_RECORDINGS_PAGE_STR_FACT);
      getTranscriptSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listTranscriptsSettings = PagedCallSettings.newBuilder(LIST_TRANSCRIPTS_PAGE_STR_FACT);
      getTranscriptEntrySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listTranscriptEntriesSettings =
          PagedCallSettings.newBuilder(LIST_TRANSCRIPT_ENTRIES_PAGE_STR_FACT);

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getConferenceRecordSettings,
              listConferenceRecordsSettings,
              getParticipantSettings,
              listParticipantsSettings,
              getParticipantSessionSettings,
              listParticipantSessionsSettings,
              getRecordingSettings,
              listRecordingsSettings,
              getTranscriptSettings,
              listTranscriptsSettings,
              getTranscriptEntrySettings,
              listTranscriptEntriesSettings);
      initDefaults(this);
    }

    protected Builder(ConferenceRecordsServiceStubSettings settings) {
      super(settings);

      getConferenceRecordSettings = settings.getConferenceRecordSettings.toBuilder();
      listConferenceRecordsSettings = settings.listConferenceRecordsSettings.toBuilder();
      getParticipantSettings = settings.getParticipantSettings.toBuilder();
      listParticipantsSettings = settings.listParticipantsSettings.toBuilder();
      getParticipantSessionSettings = settings.getParticipantSessionSettings.toBuilder();
      listParticipantSessionsSettings = settings.listParticipantSessionsSettings.toBuilder();
      getRecordingSettings = settings.getRecordingSettings.toBuilder();
      listRecordingsSettings = settings.listRecordingsSettings.toBuilder();
      getTranscriptSettings = settings.getTranscriptSettings.toBuilder();
      listTranscriptsSettings = settings.listTranscriptsSettings.toBuilder();
      getTranscriptEntrySettings = settings.getTranscriptEntrySettings.toBuilder();
      listTranscriptEntriesSettings = settings.listTranscriptEntriesSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getConferenceRecordSettings,
              listConferenceRecordsSettings,
              getParticipantSettings,
              listParticipantsSettings,
              getParticipantSessionSettings,
              listParticipantSessionsSettings,
              getRecordingSettings,
              listRecordingsSettings,
              getTranscriptSettings,
              listTranscriptsSettings,
              getTranscriptEntrySettings,
              listTranscriptEntriesSettings);
    }

    private static Builder createDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultTransportChannelProvider());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultApiClientHeaderProviderBuilder().build());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder createHttpJsonDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultHttpJsonTransportProviderBuilder().build());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultHttpJsonApiClientHeaderProviderBuilder().build());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {
      builder
          .getConferenceRecordSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listConferenceRecordsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getParticipantSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listParticipantsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getParticipantSessionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listParticipantSessionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getRecordingSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listRecordingsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getTranscriptSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listTranscriptsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getTranscriptEntrySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listTranscriptEntriesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      return builder;
    }

    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) {
      super.applyToAllUnaryMethods(unaryMethodSettingsBuilders, settingsUpdater);
      return this;
    }

    public ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders() {
      return unaryMethodSettingsBuilders;
    }

    /** Returns the builder for the settings used for calls to getConferenceRecord. */
    public UnaryCallSettings.Builder<GetConferenceRecordRequest, ConferenceRecord>
        getConferenceRecordSettings() {
      return getConferenceRecordSettings;
    }

    /** Returns the builder for the settings used for calls to listConferenceRecords. */
    public PagedCallSettings.Builder<
            ListConferenceRecordsRequest,
            ListConferenceRecordsResponse,
            ListConferenceRecordsPagedResponse>
        listConferenceRecordsSettings() {
      return listConferenceRecordsSettings;
    }

    /** Returns the builder for the settings used for calls to getParticipant. */
    public UnaryCallSettings.Builder<GetParticipantRequest, Participant> getParticipantSettings() {
      return getParticipantSettings;
    }

    /** Returns the builder for the settings used for calls to listParticipants. */
    public PagedCallSettings.Builder<
            ListParticipantsRequest, ListParticipantsResponse, ListParticipantsPagedResponse>
        listParticipantsSettings() {
      return listParticipantsSettings;
    }

    /** Returns the builder for the settings used for calls to getParticipantSession. */
    public UnaryCallSettings.Builder<GetParticipantSessionRequest, ParticipantSession>
        getParticipantSessionSettings() {
      return getParticipantSessionSettings;
    }

    /** Returns the builder for the settings used for calls to listParticipantSessions. */
    public PagedCallSettings.Builder<
            ListParticipantSessionsRequest,
            ListParticipantSessionsResponse,
            ListParticipantSessionsPagedResponse>
        listParticipantSessionsSettings() {
      return listParticipantSessionsSettings;
    }

    /** Returns the builder for the settings used for calls to getRecording. */
    public UnaryCallSettings.Builder<GetRecordingRequest, Recording> getRecordingSettings() {
      return getRecordingSettings;
    }

    /** Returns the builder for the settings used for calls to listRecordings. */
    public PagedCallSettings.Builder<
            ListRecordingsRequest, ListRecordingsResponse, ListRecordingsPagedResponse>
        listRecordingsSettings() {
      return listRecordingsSettings;
    }

    /** Returns the builder for the settings used for calls to getTranscript. */
    public UnaryCallSettings.Builder<GetTranscriptRequest, Transcript> getTranscriptSettings() {
      return getTranscriptSettings;
    }

    /** Returns the builder for the settings used for calls to listTranscripts. */
    public PagedCallSettings.Builder<
            ListTranscriptsRequest, ListTranscriptsResponse, ListTranscriptsPagedResponse>
        listTranscriptsSettings() {
      return listTranscriptsSettings;
    }

    /** Returns the builder for the settings used for calls to getTranscriptEntry. */
    public UnaryCallSettings.Builder<GetTranscriptEntryRequest, TranscriptEntry>
        getTranscriptEntrySettings() {
      return getTranscriptEntrySettings;
    }

    /** Returns the builder for the settings used for calls to listTranscriptEntries. */
    public PagedCallSettings.Builder<
            ListTranscriptEntriesRequest,
            ListTranscriptEntriesResponse,
            ListTranscriptEntriesPagedResponse>
        listTranscriptEntriesSettings() {
      return listTranscriptEntriesSettings;
    }

    @Override
    public ConferenceRecordsServiceStubSettings build() throws IOException {
      return new ConferenceRecordsServiceStubSettings(this);
    }
  }
}
