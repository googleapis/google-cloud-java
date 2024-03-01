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

package com.google.apps.meet.v2beta;

import static com.google.apps.meet.v2beta.ConferenceRecordsServiceClient.ListConferenceRecordsPagedResponse;
import static com.google.apps.meet.v2beta.ConferenceRecordsServiceClient.ListParticipantSessionsPagedResponse;
import static com.google.apps.meet.v2beta.ConferenceRecordsServiceClient.ListParticipantsPagedResponse;
import static com.google.apps.meet.v2beta.ConferenceRecordsServiceClient.ListRecordingsPagedResponse;
import static com.google.apps.meet.v2beta.ConferenceRecordsServiceClient.ListTranscriptEntriesPagedResponse;
import static com.google.apps.meet.v2beta.ConferenceRecordsServiceClient.ListTranscriptsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.apps.meet.v2beta.stub.ConferenceRecordsServiceStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link ConferenceRecordsServiceClient}.
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
 * ConferenceRecordsServiceSettings.Builder conferenceRecordsServiceSettingsBuilder =
 *     ConferenceRecordsServiceSettings.newBuilder();
 * conferenceRecordsServiceSettingsBuilder
 *     .getConferenceRecordSettings()
 *     .setRetrySettings(
 *         conferenceRecordsServiceSettingsBuilder
 *             .getConferenceRecordSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * ConferenceRecordsServiceSettings conferenceRecordsServiceSettings =
 *     conferenceRecordsServiceSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class ConferenceRecordsServiceSettings
    extends ClientSettings<ConferenceRecordsServiceSettings> {

  /** Returns the object with the settings used for calls to getConferenceRecord. */
  public UnaryCallSettings<GetConferenceRecordRequest, ConferenceRecord>
      getConferenceRecordSettings() {
    return ((ConferenceRecordsServiceStubSettings) getStubSettings()).getConferenceRecordSettings();
  }

  /** Returns the object with the settings used for calls to listConferenceRecords. */
  public PagedCallSettings<
          ListConferenceRecordsRequest,
          ListConferenceRecordsResponse,
          ListConferenceRecordsPagedResponse>
      listConferenceRecordsSettings() {
    return ((ConferenceRecordsServiceStubSettings) getStubSettings())
        .listConferenceRecordsSettings();
  }

  /** Returns the object with the settings used for calls to getParticipant. */
  public UnaryCallSettings<GetParticipantRequest, Participant> getParticipantSettings() {
    return ((ConferenceRecordsServiceStubSettings) getStubSettings()).getParticipantSettings();
  }

  /** Returns the object with the settings used for calls to listParticipants. */
  public PagedCallSettings<
          ListParticipantsRequest, ListParticipantsResponse, ListParticipantsPagedResponse>
      listParticipantsSettings() {
    return ((ConferenceRecordsServiceStubSettings) getStubSettings()).listParticipantsSettings();
  }

  /** Returns the object with the settings used for calls to getParticipantSession. */
  public UnaryCallSettings<GetParticipantSessionRequest, ParticipantSession>
      getParticipantSessionSettings() {
    return ((ConferenceRecordsServiceStubSettings) getStubSettings())
        .getParticipantSessionSettings();
  }

  /** Returns the object with the settings used for calls to listParticipantSessions. */
  public PagedCallSettings<
          ListParticipantSessionsRequest,
          ListParticipantSessionsResponse,
          ListParticipantSessionsPagedResponse>
      listParticipantSessionsSettings() {
    return ((ConferenceRecordsServiceStubSettings) getStubSettings())
        .listParticipantSessionsSettings();
  }

  /** Returns the object with the settings used for calls to getRecording. */
  public UnaryCallSettings<GetRecordingRequest, Recording> getRecordingSettings() {
    return ((ConferenceRecordsServiceStubSettings) getStubSettings()).getRecordingSettings();
  }

  /** Returns the object with the settings used for calls to listRecordings. */
  public PagedCallSettings<
          ListRecordingsRequest, ListRecordingsResponse, ListRecordingsPagedResponse>
      listRecordingsSettings() {
    return ((ConferenceRecordsServiceStubSettings) getStubSettings()).listRecordingsSettings();
  }

  /** Returns the object with the settings used for calls to getTranscript. */
  public UnaryCallSettings<GetTranscriptRequest, Transcript> getTranscriptSettings() {
    return ((ConferenceRecordsServiceStubSettings) getStubSettings()).getTranscriptSettings();
  }

  /** Returns the object with the settings used for calls to listTranscripts. */
  public PagedCallSettings<
          ListTranscriptsRequest, ListTranscriptsResponse, ListTranscriptsPagedResponse>
      listTranscriptsSettings() {
    return ((ConferenceRecordsServiceStubSettings) getStubSettings()).listTranscriptsSettings();
  }

  /** Returns the object with the settings used for calls to getTranscriptEntry. */
  public UnaryCallSettings<GetTranscriptEntryRequest, TranscriptEntry>
      getTranscriptEntrySettings() {
    return ((ConferenceRecordsServiceStubSettings) getStubSettings()).getTranscriptEntrySettings();
  }

  /** Returns the object with the settings used for calls to listTranscriptEntries. */
  public PagedCallSettings<
          ListTranscriptEntriesRequest,
          ListTranscriptEntriesResponse,
          ListTranscriptEntriesPagedResponse>
      listTranscriptEntriesSettings() {
    return ((ConferenceRecordsServiceStubSettings) getStubSettings())
        .listTranscriptEntriesSettings();
  }

  public static final ConferenceRecordsServiceSettings create(
      ConferenceRecordsServiceStubSettings stub) throws IOException {
    return new ConferenceRecordsServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return ConferenceRecordsServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return ConferenceRecordsServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return ConferenceRecordsServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return ConferenceRecordsServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return ConferenceRecordsServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return ConferenceRecordsServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return ConferenceRecordsServiceStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ConferenceRecordsServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected ConferenceRecordsServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for ConferenceRecordsServiceSettings. */
  public static class Builder
      extends ClientSettings.Builder<ConferenceRecordsServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(ConferenceRecordsServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(ConferenceRecordsServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(ConferenceRecordsServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(ConferenceRecordsServiceStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(ConferenceRecordsServiceStubSettings.newHttpJsonBuilder());
    }

    public ConferenceRecordsServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((ConferenceRecordsServiceStubSettings.Builder) getStubSettings());
    }

    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) {
      super.applyToAllUnaryMethods(
          getStubSettingsBuilder().unaryMethodSettingsBuilders(), settingsUpdater);
      return this;
    }

    /** Returns the builder for the settings used for calls to getConferenceRecord. */
    public UnaryCallSettings.Builder<GetConferenceRecordRequest, ConferenceRecord>
        getConferenceRecordSettings() {
      return getStubSettingsBuilder().getConferenceRecordSettings();
    }

    /** Returns the builder for the settings used for calls to listConferenceRecords. */
    public PagedCallSettings.Builder<
            ListConferenceRecordsRequest,
            ListConferenceRecordsResponse,
            ListConferenceRecordsPagedResponse>
        listConferenceRecordsSettings() {
      return getStubSettingsBuilder().listConferenceRecordsSettings();
    }

    /** Returns the builder for the settings used for calls to getParticipant. */
    public UnaryCallSettings.Builder<GetParticipantRequest, Participant> getParticipantSettings() {
      return getStubSettingsBuilder().getParticipantSettings();
    }

    /** Returns the builder for the settings used for calls to listParticipants. */
    public PagedCallSettings.Builder<
            ListParticipantsRequest, ListParticipantsResponse, ListParticipantsPagedResponse>
        listParticipantsSettings() {
      return getStubSettingsBuilder().listParticipantsSettings();
    }

    /** Returns the builder for the settings used for calls to getParticipantSession. */
    public UnaryCallSettings.Builder<GetParticipantSessionRequest, ParticipantSession>
        getParticipantSessionSettings() {
      return getStubSettingsBuilder().getParticipantSessionSettings();
    }

    /** Returns the builder for the settings used for calls to listParticipantSessions. */
    public PagedCallSettings.Builder<
            ListParticipantSessionsRequest,
            ListParticipantSessionsResponse,
            ListParticipantSessionsPagedResponse>
        listParticipantSessionsSettings() {
      return getStubSettingsBuilder().listParticipantSessionsSettings();
    }

    /** Returns the builder for the settings used for calls to getRecording. */
    public UnaryCallSettings.Builder<GetRecordingRequest, Recording> getRecordingSettings() {
      return getStubSettingsBuilder().getRecordingSettings();
    }

    /** Returns the builder for the settings used for calls to listRecordings. */
    public PagedCallSettings.Builder<
            ListRecordingsRequest, ListRecordingsResponse, ListRecordingsPagedResponse>
        listRecordingsSettings() {
      return getStubSettingsBuilder().listRecordingsSettings();
    }

    /** Returns the builder for the settings used for calls to getTranscript. */
    public UnaryCallSettings.Builder<GetTranscriptRequest, Transcript> getTranscriptSettings() {
      return getStubSettingsBuilder().getTranscriptSettings();
    }

    /** Returns the builder for the settings used for calls to listTranscripts. */
    public PagedCallSettings.Builder<
            ListTranscriptsRequest, ListTranscriptsResponse, ListTranscriptsPagedResponse>
        listTranscriptsSettings() {
      return getStubSettingsBuilder().listTranscriptsSettings();
    }

    /** Returns the builder for the settings used for calls to getTranscriptEntry. */
    public UnaryCallSettings.Builder<GetTranscriptEntryRequest, TranscriptEntry>
        getTranscriptEntrySettings() {
      return getStubSettingsBuilder().getTranscriptEntrySettings();
    }

    /** Returns the builder for the settings used for calls to listTranscriptEntries. */
    public PagedCallSettings.Builder<
            ListTranscriptEntriesRequest,
            ListTranscriptEntriesResponse,
            ListTranscriptEntriesPagedResponse>
        listTranscriptEntriesSettings() {
      return getStubSettingsBuilder().listTranscriptEntriesSettings();
    }

    @Override
    public ConferenceRecordsServiceSettings build() throws IOException {
      return new ConferenceRecordsServiceSettings(this);
    }
  }
}
