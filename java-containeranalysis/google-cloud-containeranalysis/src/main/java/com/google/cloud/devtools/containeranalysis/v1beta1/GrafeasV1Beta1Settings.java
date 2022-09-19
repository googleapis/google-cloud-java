/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.devtools.containeranalysis.v1beta1;

import static com.google.cloud.devtools.containeranalysis.v1beta1.GrafeasV1Beta1Client.ListNoteOccurrencesPagedResponse;
import static com.google.cloud.devtools.containeranalysis.v1beta1.GrafeasV1Beta1Client.ListNotesPagedResponse;
import static com.google.cloud.devtools.containeranalysis.v1beta1.GrafeasV1Beta1Client.ListOccurrencesPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.devtools.containeranalysis.v1beta1.stub.GrafeasV1Beta1StubSettings;
import com.google.protobuf.Empty;
import io.grafeas.v1beta1.BatchCreateNotesRequest;
import io.grafeas.v1beta1.BatchCreateNotesResponse;
import io.grafeas.v1beta1.BatchCreateOccurrencesRequest;
import io.grafeas.v1beta1.BatchCreateOccurrencesResponse;
import io.grafeas.v1beta1.CreateNoteRequest;
import io.grafeas.v1beta1.CreateOccurrenceRequest;
import io.grafeas.v1beta1.DeleteNoteRequest;
import io.grafeas.v1beta1.DeleteOccurrenceRequest;
import io.grafeas.v1beta1.GetNoteRequest;
import io.grafeas.v1beta1.GetOccurrenceNoteRequest;
import io.grafeas.v1beta1.GetOccurrenceRequest;
import io.grafeas.v1beta1.GetVulnerabilityOccurrencesSummaryRequest;
import io.grafeas.v1beta1.ListNoteOccurrencesRequest;
import io.grafeas.v1beta1.ListNoteOccurrencesResponse;
import io.grafeas.v1beta1.ListNotesRequest;
import io.grafeas.v1beta1.ListNotesResponse;
import io.grafeas.v1beta1.ListOccurrencesRequest;
import io.grafeas.v1beta1.ListOccurrencesResponse;
import io.grafeas.v1beta1.Note;
import io.grafeas.v1beta1.Occurrence;
import io.grafeas.v1beta1.UpdateNoteRequest;
import io.grafeas.v1beta1.UpdateOccurrenceRequest;
import io.grafeas.v1beta1.VulnerabilityOccurrencesSummary;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Settings class to configure an instance of {@link GrafeasV1Beta1Client}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (containeranalysis.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getOccurrence to 30 seconds:
 *
 * <pre>
 * <code>
 * GrafeasV1Beta1Settings.Builder grafeasV1Beta1SettingsBuilder =
 *     GrafeasV1Beta1Settings.newBuilder();
 * grafeasV1Beta1SettingsBuilder
 *     .getOccurrenceSettings()
 *     .setRetrySettings(
 *         grafeasV1Beta1SettingsBuilder.getOccurrenceSettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * GrafeasV1Beta1Settings grafeasV1Beta1Settings = grafeasV1Beta1SettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class GrafeasV1Beta1Settings extends ClientSettings<GrafeasV1Beta1Settings> {
  /** Returns the object with the settings used for calls to getOccurrence. */
  public UnaryCallSettings<GetOccurrenceRequest, Occurrence> getOccurrenceSettings() {
    return ((GrafeasV1Beta1StubSettings) getStubSettings()).getOccurrenceSettings();
  }

  /** Returns the object with the settings used for calls to listOccurrences. */
  public PagedCallSettings<
          ListOccurrencesRequest, ListOccurrencesResponse, ListOccurrencesPagedResponse>
      listOccurrencesSettings() {
    return ((GrafeasV1Beta1StubSettings) getStubSettings()).listOccurrencesSettings();
  }

  /** Returns the object with the settings used for calls to deleteOccurrence. */
  public UnaryCallSettings<DeleteOccurrenceRequest, Empty> deleteOccurrenceSettings() {
    return ((GrafeasV1Beta1StubSettings) getStubSettings()).deleteOccurrenceSettings();
  }

  /** Returns the object with the settings used for calls to createOccurrence. */
  public UnaryCallSettings<CreateOccurrenceRequest, Occurrence> createOccurrenceSettings() {
    return ((GrafeasV1Beta1StubSettings) getStubSettings()).createOccurrenceSettings();
  }

  /** Returns the object with the settings used for calls to batchCreateOccurrences. */
  public UnaryCallSettings<BatchCreateOccurrencesRequest, BatchCreateOccurrencesResponse>
      batchCreateOccurrencesSettings() {
    return ((GrafeasV1Beta1StubSettings) getStubSettings()).batchCreateOccurrencesSettings();
  }

  /** Returns the object with the settings used for calls to updateOccurrence. */
  public UnaryCallSettings<UpdateOccurrenceRequest, Occurrence> updateOccurrenceSettings() {
    return ((GrafeasV1Beta1StubSettings) getStubSettings()).updateOccurrenceSettings();
  }

  /** Returns the object with the settings used for calls to getOccurrenceNote. */
  public UnaryCallSettings<GetOccurrenceNoteRequest, Note> getOccurrenceNoteSettings() {
    return ((GrafeasV1Beta1StubSettings) getStubSettings()).getOccurrenceNoteSettings();
  }

  /** Returns the object with the settings used for calls to getNote. */
  public UnaryCallSettings<GetNoteRequest, Note> getNoteSettings() {
    return ((GrafeasV1Beta1StubSettings) getStubSettings()).getNoteSettings();
  }

  /** Returns the object with the settings used for calls to listNotes. */
  public PagedCallSettings<ListNotesRequest, ListNotesResponse, ListNotesPagedResponse>
      listNotesSettings() {
    return ((GrafeasV1Beta1StubSettings) getStubSettings()).listNotesSettings();
  }

  /** Returns the object with the settings used for calls to deleteNote. */
  public UnaryCallSettings<DeleteNoteRequest, Empty> deleteNoteSettings() {
    return ((GrafeasV1Beta1StubSettings) getStubSettings()).deleteNoteSettings();
  }

  /** Returns the object with the settings used for calls to createNote. */
  public UnaryCallSettings<CreateNoteRequest, Note> createNoteSettings() {
    return ((GrafeasV1Beta1StubSettings) getStubSettings()).createNoteSettings();
  }

  /** Returns the object with the settings used for calls to batchCreateNotes. */
  public UnaryCallSettings<BatchCreateNotesRequest, BatchCreateNotesResponse>
      batchCreateNotesSettings() {
    return ((GrafeasV1Beta1StubSettings) getStubSettings()).batchCreateNotesSettings();
  }

  /** Returns the object with the settings used for calls to updateNote. */
  public UnaryCallSettings<UpdateNoteRequest, Note> updateNoteSettings() {
    return ((GrafeasV1Beta1StubSettings) getStubSettings()).updateNoteSettings();
  }

  /** Returns the object with the settings used for calls to listNoteOccurrences. */
  public PagedCallSettings<
          ListNoteOccurrencesRequest, ListNoteOccurrencesResponse, ListNoteOccurrencesPagedResponse>
      listNoteOccurrencesSettings() {
    return ((GrafeasV1Beta1StubSettings) getStubSettings()).listNoteOccurrencesSettings();
  }

  /** Returns the object with the settings used for calls to getVulnerabilityOccurrencesSummary. */
  public UnaryCallSettings<
          GetVulnerabilityOccurrencesSummaryRequest, VulnerabilityOccurrencesSummary>
      getVulnerabilityOccurrencesSummarySettings() {
    return ((GrafeasV1Beta1StubSettings) getStubSettings())
        .getVulnerabilityOccurrencesSummarySettings();
  }

  public static final GrafeasV1Beta1Settings create(GrafeasV1Beta1StubSettings stub)
      throws IOException {
    return new GrafeasV1Beta1Settings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return GrafeasV1Beta1StubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return GrafeasV1Beta1StubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return GrafeasV1Beta1StubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return GrafeasV1Beta1StubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return GrafeasV1Beta1StubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return GrafeasV1Beta1StubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return GrafeasV1Beta1StubSettings.defaultApiClientHeaderProviderBuilder();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder(ClientContext clientContext) {
    return new Builder(clientContext);
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  protected GrafeasV1Beta1Settings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for GrafeasV1Beta1Settings. */
  public static class Builder extends ClientSettings.Builder<GrafeasV1Beta1Settings, Builder> {
    protected Builder() throws IOException {
      this((ClientContext) null);
    }

    protected Builder(ClientContext clientContext) {
      super(GrafeasV1Beta1StubSettings.newBuilder(clientContext));
    }

    private static Builder createDefault() {
      return new Builder(GrafeasV1Beta1StubSettings.newBuilder());
    }

    protected Builder(GrafeasV1Beta1Settings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(GrafeasV1Beta1StubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    public GrafeasV1Beta1StubSettings.Builder getStubSettingsBuilder() {
      return ((GrafeasV1Beta1StubSettings.Builder) getStubSettings());
    }

    // NEXT_MAJOR_VER: remove 'throws Exception'
    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) throws Exception {
      super.applyToAllUnaryMethods(
          getStubSettingsBuilder().unaryMethodSettingsBuilders(), settingsUpdater);
      return this;
    }

    /** Returns the builder for the settings used for calls to getOccurrence. */
    public UnaryCallSettings.Builder<GetOccurrenceRequest, Occurrence> getOccurrenceSettings() {
      return getStubSettingsBuilder().getOccurrenceSettings();
    }

    /** Returns the builder for the settings used for calls to listOccurrences. */
    public PagedCallSettings.Builder<
            ListOccurrencesRequest, ListOccurrencesResponse, ListOccurrencesPagedResponse>
        listOccurrencesSettings() {
      return getStubSettingsBuilder().listOccurrencesSettings();
    }

    /** Returns the builder for the settings used for calls to deleteOccurrence. */
    public UnaryCallSettings.Builder<DeleteOccurrenceRequest, Empty> deleteOccurrenceSettings() {
      return getStubSettingsBuilder().deleteOccurrenceSettings();
    }

    /** Returns the builder for the settings used for calls to createOccurrence. */
    public UnaryCallSettings.Builder<CreateOccurrenceRequest, Occurrence>
        createOccurrenceSettings() {
      return getStubSettingsBuilder().createOccurrenceSettings();
    }

    /** Returns the builder for the settings used for calls to batchCreateOccurrences. */
    public UnaryCallSettings.Builder<BatchCreateOccurrencesRequest, BatchCreateOccurrencesResponse>
        batchCreateOccurrencesSettings() {
      return getStubSettingsBuilder().batchCreateOccurrencesSettings();
    }

    /** Returns the builder for the settings used for calls to updateOccurrence. */
    public UnaryCallSettings.Builder<UpdateOccurrenceRequest, Occurrence>
        updateOccurrenceSettings() {
      return getStubSettingsBuilder().updateOccurrenceSettings();
    }

    /** Returns the builder for the settings used for calls to getOccurrenceNote. */
    public UnaryCallSettings.Builder<GetOccurrenceNoteRequest, Note> getOccurrenceNoteSettings() {
      return getStubSettingsBuilder().getOccurrenceNoteSettings();
    }

    /** Returns the builder for the settings used for calls to getNote. */
    public UnaryCallSettings.Builder<GetNoteRequest, Note> getNoteSettings() {
      return getStubSettingsBuilder().getNoteSettings();
    }

    /** Returns the builder for the settings used for calls to listNotes. */
    public PagedCallSettings.Builder<ListNotesRequest, ListNotesResponse, ListNotesPagedResponse>
        listNotesSettings() {
      return getStubSettingsBuilder().listNotesSettings();
    }

    /** Returns the builder for the settings used for calls to deleteNote. */
    public UnaryCallSettings.Builder<DeleteNoteRequest, Empty> deleteNoteSettings() {
      return getStubSettingsBuilder().deleteNoteSettings();
    }

    /** Returns the builder for the settings used for calls to createNote. */
    public UnaryCallSettings.Builder<CreateNoteRequest, Note> createNoteSettings() {
      return getStubSettingsBuilder().createNoteSettings();
    }

    /** Returns the builder for the settings used for calls to batchCreateNotes. */
    public UnaryCallSettings.Builder<BatchCreateNotesRequest, BatchCreateNotesResponse>
        batchCreateNotesSettings() {
      return getStubSettingsBuilder().batchCreateNotesSettings();
    }

    /** Returns the builder for the settings used for calls to updateNote. */
    public UnaryCallSettings.Builder<UpdateNoteRequest, Note> updateNoteSettings() {
      return getStubSettingsBuilder().updateNoteSettings();
    }

    /** Returns the builder for the settings used for calls to listNoteOccurrences. */
    public PagedCallSettings.Builder<
            ListNoteOccurrencesRequest,
            ListNoteOccurrencesResponse,
            ListNoteOccurrencesPagedResponse>
        listNoteOccurrencesSettings() {
      return getStubSettingsBuilder().listNoteOccurrencesSettings();
    }

    /**
     * Returns the builder for the settings used for calls to getVulnerabilityOccurrencesSummary.
     */
    public UnaryCallSettings.Builder<
            GetVulnerabilityOccurrencesSummaryRequest, VulnerabilityOccurrencesSummary>
        getVulnerabilityOccurrencesSummarySettings() {
      return getStubSettingsBuilder().getVulnerabilityOccurrencesSummarySettings();
    }

    @Override
    public GrafeasV1Beta1Settings build() throws IOException {
      return new GrafeasV1Beta1Settings(this);
    }
  }
}
