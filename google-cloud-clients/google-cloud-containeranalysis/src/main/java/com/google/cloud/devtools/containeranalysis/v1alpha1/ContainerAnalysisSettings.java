/*
 * Copyright 2018 Google LLC
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
package com.google.cloud.devtools.containeranalysis.v1alpha1;

import static com.google.cloud.devtools.containeranalysis.v1alpha1.ContainerAnalysisClient.ListNoteOccurrencesPagedResponse;
import static com.google.cloud.devtools.containeranalysis.v1alpha1.ContainerAnalysisClient.ListNotesPagedResponse;
import static com.google.cloud.devtools.containeranalysis.v1alpha1.ContainerAnalysisClient.ListOccurrencesPagedResponse;

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
import com.google.cloud.devtools.containeranalysis.v1alpha1.stub.ContainerAnalysisStubSettings;
import com.google.containeranalysis.v1alpha1.CreateNoteRequest;
import com.google.containeranalysis.v1alpha1.CreateOccurrenceRequest;
import com.google.containeranalysis.v1alpha1.DeleteNoteRequest;
import com.google.containeranalysis.v1alpha1.DeleteOccurrenceRequest;
import com.google.containeranalysis.v1alpha1.GetNoteRequest;
import com.google.containeranalysis.v1alpha1.GetOccurrenceNoteRequest;
import com.google.containeranalysis.v1alpha1.GetOccurrenceRequest;
import com.google.containeranalysis.v1alpha1.GetVulnzOccurrencesSummaryRequest;
import com.google.containeranalysis.v1alpha1.GetVulnzOccurrencesSummaryResponse;
import com.google.containeranalysis.v1alpha1.ListNoteOccurrencesRequest;
import com.google.containeranalysis.v1alpha1.ListNoteOccurrencesResponse;
import com.google.containeranalysis.v1alpha1.ListNotesRequest;
import com.google.containeranalysis.v1alpha1.ListNotesResponse;
import com.google.containeranalysis.v1alpha1.ListOccurrencesRequest;
import com.google.containeranalysis.v1alpha1.ListOccurrencesResponse;
import com.google.containeranalysis.v1alpha1.Note;
import com.google.containeranalysis.v1alpha1.Occurrence;
import com.google.containeranalysis.v1alpha1.UpdateNoteRequest;
import com.google.containeranalysis.v1alpha1.UpdateOccurrenceRequest;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Settings class to configure an instance of {@link ContainerAnalysisClient}.
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
 * build() is called, the tree of builders is called to create the complete settings object. For
 * example, to set the total timeout of getOccurrence to 30 seconds:
 *
 * <pre>
 * <code>
 * ContainerAnalysisSettings.Builder containerAnalysisSettingsBuilder =
 *     ContainerAnalysisSettings.newBuilder();
 * containerAnalysisSettingsBuilder.getOccurrenceSettings().getRetrySettings().toBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * ContainerAnalysisSettings containerAnalysisSettings = containerAnalysisSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class ContainerAnalysisSettings extends ClientSettings<ContainerAnalysisSettings> {
  /** Returns the object with the settings used for calls to getOccurrence. */
  public UnaryCallSettings<GetOccurrenceRequest, Occurrence> getOccurrenceSettings() {
    return ((ContainerAnalysisStubSettings) getStubSettings()).getOccurrenceSettings();
  }

  /** Returns the object with the settings used for calls to listOccurrences. */
  public PagedCallSettings<
          ListOccurrencesRequest, ListOccurrencesResponse, ListOccurrencesPagedResponse>
      listOccurrencesSettings() {
    return ((ContainerAnalysisStubSettings) getStubSettings()).listOccurrencesSettings();
  }

  /** Returns the object with the settings used for calls to deleteOccurrence. */
  public UnaryCallSettings<DeleteOccurrenceRequest, Empty> deleteOccurrenceSettings() {
    return ((ContainerAnalysisStubSettings) getStubSettings()).deleteOccurrenceSettings();
  }

  /** Returns the object with the settings used for calls to createOccurrence. */
  public UnaryCallSettings<CreateOccurrenceRequest, Occurrence> createOccurrenceSettings() {
    return ((ContainerAnalysisStubSettings) getStubSettings()).createOccurrenceSettings();
  }

  /** Returns the object with the settings used for calls to updateOccurrence. */
  public UnaryCallSettings<UpdateOccurrenceRequest, Occurrence> updateOccurrenceSettings() {
    return ((ContainerAnalysisStubSettings) getStubSettings()).updateOccurrenceSettings();
  }

  /** Returns the object with the settings used for calls to getOccurrenceNote. */
  public UnaryCallSettings<GetOccurrenceNoteRequest, Note> getOccurrenceNoteSettings() {
    return ((ContainerAnalysisStubSettings) getStubSettings()).getOccurrenceNoteSettings();
  }

  /** Returns the object with the settings used for calls to getNote. */
  public UnaryCallSettings<GetNoteRequest, Note> getNoteSettings() {
    return ((ContainerAnalysisStubSettings) getStubSettings()).getNoteSettings();
  }

  /** Returns the object with the settings used for calls to listNotes. */
  public PagedCallSettings<ListNotesRequest, ListNotesResponse, ListNotesPagedResponse>
      listNotesSettings() {
    return ((ContainerAnalysisStubSettings) getStubSettings()).listNotesSettings();
  }

  /** Returns the object with the settings used for calls to deleteNote. */
  public UnaryCallSettings<DeleteNoteRequest, Empty> deleteNoteSettings() {
    return ((ContainerAnalysisStubSettings) getStubSettings()).deleteNoteSettings();
  }

  /** Returns the object with the settings used for calls to createNote. */
  public UnaryCallSettings<CreateNoteRequest, Note> createNoteSettings() {
    return ((ContainerAnalysisStubSettings) getStubSettings()).createNoteSettings();
  }

  /** Returns the object with the settings used for calls to updateNote. */
  public UnaryCallSettings<UpdateNoteRequest, Note> updateNoteSettings() {
    return ((ContainerAnalysisStubSettings) getStubSettings()).updateNoteSettings();
  }

  /** Returns the object with the settings used for calls to listNoteOccurrences. */
  public PagedCallSettings<
          ListNoteOccurrencesRequest, ListNoteOccurrencesResponse, ListNoteOccurrencesPagedResponse>
      listNoteOccurrencesSettings() {
    return ((ContainerAnalysisStubSettings) getStubSettings()).listNoteOccurrencesSettings();
  }

  /** Returns the object with the settings used for calls to getVulnzOccurrencesSummary. */
  public UnaryCallSettings<GetVulnzOccurrencesSummaryRequest, GetVulnzOccurrencesSummaryResponse>
      getVulnzOccurrencesSummarySettings() {
    return ((ContainerAnalysisStubSettings) getStubSettings()).getVulnzOccurrencesSummarySettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return ((ContainerAnalysisStubSettings) getStubSettings()).setIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return ((ContainerAnalysisStubSettings) getStubSettings()).getIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return ((ContainerAnalysisStubSettings) getStubSettings()).testIamPermissionsSettings();
  }

  public static final ContainerAnalysisSettings create(ContainerAnalysisStubSettings stub)
      throws IOException {
    return new ContainerAnalysisSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return ContainerAnalysisStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return ContainerAnalysisStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return ContainerAnalysisStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return ContainerAnalysisStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return ContainerAnalysisStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return ContainerAnalysisStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ContainerAnalysisStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected ContainerAnalysisSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for ContainerAnalysisSettings. */
  public static class Builder extends ClientSettings.Builder<ContainerAnalysisSettings, Builder> {
    protected Builder() throws IOException {
      this((ClientContext) null);
    }

    protected Builder(ClientContext clientContext) {
      super(ContainerAnalysisStubSettings.newBuilder(clientContext));
    }

    private static Builder createDefault() {
      return new Builder(ContainerAnalysisStubSettings.newBuilder());
    }

    protected Builder(ContainerAnalysisSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(ContainerAnalysisStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    public ContainerAnalysisStubSettings.Builder getStubSettingsBuilder() {
      return ((ContainerAnalysisStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to updateNote. */
    public UnaryCallSettings.Builder<UpdateNoteRequest, Note> updateNoteSettings() {
      return getStubSettingsBuilder().updateNoteSettings();
    }

    /** Returns the builder for the settings used for calls to listNoteOccurrences. */
    public PagedCallSettings.Builder<
            ListNoteOccurrencesRequest, ListNoteOccurrencesResponse,
            ListNoteOccurrencesPagedResponse>
        listNoteOccurrencesSettings() {
      return getStubSettingsBuilder().listNoteOccurrencesSettings();
    }

    /** Returns the builder for the settings used for calls to getVulnzOccurrencesSummary. */
    public UnaryCallSettings.Builder<
            GetVulnzOccurrencesSummaryRequest, GetVulnzOccurrencesSummaryResponse>
        getVulnzOccurrencesSummarySettings() {
      return getStubSettingsBuilder().getVulnzOccurrencesSummarySettings();
    }

    /** Returns the builder for the settings used for calls to setIamPolicy. */
    public UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings() {
      return getStubSettingsBuilder().setIamPolicySettings();
    }

    /** Returns the builder for the settings used for calls to getIamPolicy. */
    public UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings() {
      return getStubSettingsBuilder().getIamPolicySettings();
    }

    /** Returns the builder for the settings used for calls to testIamPermissions. */
    public UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings() {
      return getStubSettingsBuilder().testIamPermissionsSettings();
    }

    @Override
    public ContainerAnalysisSettings build() throws IOException {
      return new ContainerAnalysisSettings(this);
    }
  }
}
