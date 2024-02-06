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

package com.google.cloud.datacatalog.lineage.v1;

import static com.google.cloud.datacatalog.lineage.v1.LineageClient.BatchSearchLinkProcessesPagedResponse;
import static com.google.cloud.datacatalog.lineage.v1.LineageClient.ListLineageEventsPagedResponse;
import static com.google.cloud.datacatalog.lineage.v1.LineageClient.ListProcessesPagedResponse;
import static com.google.cloud.datacatalog.lineage.v1.LineageClient.ListRunsPagedResponse;
import static com.google.cloud.datacatalog.lineage.v1.LineageClient.SearchLinksPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.datacatalog.lineage.v1.stub.LineageStubSettings;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link LineageClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (datalineage.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of processOpenLineageRunEvent to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * LineageSettings.Builder lineageSettingsBuilder = LineageSettings.newBuilder();
 * lineageSettingsBuilder
 *     .processOpenLineageRunEventSettings()
 *     .setRetrySettings(
 *         lineageSettingsBuilder
 *             .processOpenLineageRunEventSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * LineageSettings lineageSettings = lineageSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class LineageSettings extends ClientSettings<LineageSettings> {

  /** Returns the object with the settings used for calls to processOpenLineageRunEvent. */
  public UnaryCallSettings<ProcessOpenLineageRunEventRequest, ProcessOpenLineageRunEventResponse>
      processOpenLineageRunEventSettings() {
    return ((LineageStubSettings) getStubSettings()).processOpenLineageRunEventSettings();
  }

  /** Returns the object with the settings used for calls to createProcess. */
  public UnaryCallSettings<CreateProcessRequest, Process> createProcessSettings() {
    return ((LineageStubSettings) getStubSettings()).createProcessSettings();
  }

  /** Returns the object with the settings used for calls to updateProcess. */
  public UnaryCallSettings<UpdateProcessRequest, Process> updateProcessSettings() {
    return ((LineageStubSettings) getStubSettings()).updateProcessSettings();
  }

  /** Returns the object with the settings used for calls to getProcess. */
  public UnaryCallSettings<GetProcessRequest, Process> getProcessSettings() {
    return ((LineageStubSettings) getStubSettings()).getProcessSettings();
  }

  /** Returns the object with the settings used for calls to listProcesses. */
  public PagedCallSettings<ListProcessesRequest, ListProcessesResponse, ListProcessesPagedResponse>
      listProcessesSettings() {
    return ((LineageStubSettings) getStubSettings()).listProcessesSettings();
  }

  /** Returns the object with the settings used for calls to deleteProcess. */
  public UnaryCallSettings<DeleteProcessRequest, Operation> deleteProcessSettings() {
    return ((LineageStubSettings) getStubSettings()).deleteProcessSettings();
  }

  /** Returns the object with the settings used for calls to deleteProcess. */
  public OperationCallSettings<DeleteProcessRequest, Empty, OperationMetadata>
      deleteProcessOperationSettings() {
    return ((LineageStubSettings) getStubSettings()).deleteProcessOperationSettings();
  }

  /** Returns the object with the settings used for calls to createRun. */
  public UnaryCallSettings<CreateRunRequest, Run> createRunSettings() {
    return ((LineageStubSettings) getStubSettings()).createRunSettings();
  }

  /** Returns the object with the settings used for calls to updateRun. */
  public UnaryCallSettings<UpdateRunRequest, Run> updateRunSettings() {
    return ((LineageStubSettings) getStubSettings()).updateRunSettings();
  }

  /** Returns the object with the settings used for calls to getRun. */
  public UnaryCallSettings<GetRunRequest, Run> getRunSettings() {
    return ((LineageStubSettings) getStubSettings()).getRunSettings();
  }

  /** Returns the object with the settings used for calls to listRuns. */
  public PagedCallSettings<ListRunsRequest, ListRunsResponse, ListRunsPagedResponse>
      listRunsSettings() {
    return ((LineageStubSettings) getStubSettings()).listRunsSettings();
  }

  /** Returns the object with the settings used for calls to deleteRun. */
  public UnaryCallSettings<DeleteRunRequest, Operation> deleteRunSettings() {
    return ((LineageStubSettings) getStubSettings()).deleteRunSettings();
  }

  /** Returns the object with the settings used for calls to deleteRun. */
  public OperationCallSettings<DeleteRunRequest, Empty, OperationMetadata>
      deleteRunOperationSettings() {
    return ((LineageStubSettings) getStubSettings()).deleteRunOperationSettings();
  }

  /** Returns the object with the settings used for calls to createLineageEvent. */
  public UnaryCallSettings<CreateLineageEventRequest, LineageEvent> createLineageEventSettings() {
    return ((LineageStubSettings) getStubSettings()).createLineageEventSettings();
  }

  /** Returns the object with the settings used for calls to getLineageEvent. */
  public UnaryCallSettings<GetLineageEventRequest, LineageEvent> getLineageEventSettings() {
    return ((LineageStubSettings) getStubSettings()).getLineageEventSettings();
  }

  /** Returns the object with the settings used for calls to listLineageEvents. */
  public PagedCallSettings<
          ListLineageEventsRequest, ListLineageEventsResponse, ListLineageEventsPagedResponse>
      listLineageEventsSettings() {
    return ((LineageStubSettings) getStubSettings()).listLineageEventsSettings();
  }

  /** Returns the object with the settings used for calls to deleteLineageEvent. */
  public UnaryCallSettings<DeleteLineageEventRequest, Empty> deleteLineageEventSettings() {
    return ((LineageStubSettings) getStubSettings()).deleteLineageEventSettings();
  }

  /** Returns the object with the settings used for calls to searchLinks. */
  public PagedCallSettings<SearchLinksRequest, SearchLinksResponse, SearchLinksPagedResponse>
      searchLinksSettings() {
    return ((LineageStubSettings) getStubSettings()).searchLinksSettings();
  }

  /** Returns the object with the settings used for calls to batchSearchLinkProcesses. */
  public PagedCallSettings<
          BatchSearchLinkProcessesRequest,
          BatchSearchLinkProcessesResponse,
          BatchSearchLinkProcessesPagedResponse>
      batchSearchLinkProcessesSettings() {
    return ((LineageStubSettings) getStubSettings()).batchSearchLinkProcessesSettings();
  }

  public static final LineageSettings create(LineageStubSettings stub) throws IOException {
    return new LineageSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return LineageStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return LineageStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return LineageStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return LineageStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return LineageStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return LineageStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return LineageStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return LineageStubSettings.defaultApiClientHeaderProviderBuilder();
  }

  /** Returns a new gRPC builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new REST builder for this class. */
  @BetaApi
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

  protected LineageSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for LineageSettings. */
  public static class Builder extends ClientSettings.Builder<LineageSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(LineageStubSettings.newBuilder(clientContext));
    }

    protected Builder(LineageSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(LineageStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(LineageStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(LineageStubSettings.newHttpJsonBuilder());
    }

    public LineageStubSettings.Builder getStubSettingsBuilder() {
      return ((LineageStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to processOpenLineageRunEvent. */
    public UnaryCallSettings.Builder<
            ProcessOpenLineageRunEventRequest, ProcessOpenLineageRunEventResponse>
        processOpenLineageRunEventSettings() {
      return getStubSettingsBuilder().processOpenLineageRunEventSettings();
    }

    /** Returns the builder for the settings used for calls to createProcess. */
    public UnaryCallSettings.Builder<CreateProcessRequest, Process> createProcessSettings() {
      return getStubSettingsBuilder().createProcessSettings();
    }

    /** Returns the builder for the settings used for calls to updateProcess. */
    public UnaryCallSettings.Builder<UpdateProcessRequest, Process> updateProcessSettings() {
      return getStubSettingsBuilder().updateProcessSettings();
    }

    /** Returns the builder for the settings used for calls to getProcess. */
    public UnaryCallSettings.Builder<GetProcessRequest, Process> getProcessSettings() {
      return getStubSettingsBuilder().getProcessSettings();
    }

    /** Returns the builder for the settings used for calls to listProcesses. */
    public PagedCallSettings.Builder<
            ListProcessesRequest, ListProcessesResponse, ListProcessesPagedResponse>
        listProcessesSettings() {
      return getStubSettingsBuilder().listProcessesSettings();
    }

    /** Returns the builder for the settings used for calls to deleteProcess. */
    public UnaryCallSettings.Builder<DeleteProcessRequest, Operation> deleteProcessSettings() {
      return getStubSettingsBuilder().deleteProcessSettings();
    }

    /** Returns the builder for the settings used for calls to deleteProcess. */
    public OperationCallSettings.Builder<DeleteProcessRequest, Empty, OperationMetadata>
        deleteProcessOperationSettings() {
      return getStubSettingsBuilder().deleteProcessOperationSettings();
    }

    /** Returns the builder for the settings used for calls to createRun. */
    public UnaryCallSettings.Builder<CreateRunRequest, Run> createRunSettings() {
      return getStubSettingsBuilder().createRunSettings();
    }

    /** Returns the builder for the settings used for calls to updateRun. */
    public UnaryCallSettings.Builder<UpdateRunRequest, Run> updateRunSettings() {
      return getStubSettingsBuilder().updateRunSettings();
    }

    /** Returns the builder for the settings used for calls to getRun. */
    public UnaryCallSettings.Builder<GetRunRequest, Run> getRunSettings() {
      return getStubSettingsBuilder().getRunSettings();
    }

    /** Returns the builder for the settings used for calls to listRuns. */
    public PagedCallSettings.Builder<ListRunsRequest, ListRunsResponse, ListRunsPagedResponse>
        listRunsSettings() {
      return getStubSettingsBuilder().listRunsSettings();
    }

    /** Returns the builder for the settings used for calls to deleteRun. */
    public UnaryCallSettings.Builder<DeleteRunRequest, Operation> deleteRunSettings() {
      return getStubSettingsBuilder().deleteRunSettings();
    }

    /** Returns the builder for the settings used for calls to deleteRun. */
    public OperationCallSettings.Builder<DeleteRunRequest, Empty, OperationMetadata>
        deleteRunOperationSettings() {
      return getStubSettingsBuilder().deleteRunOperationSettings();
    }

    /** Returns the builder for the settings used for calls to createLineageEvent. */
    public UnaryCallSettings.Builder<CreateLineageEventRequest, LineageEvent>
        createLineageEventSettings() {
      return getStubSettingsBuilder().createLineageEventSettings();
    }

    /** Returns the builder for the settings used for calls to getLineageEvent. */
    public UnaryCallSettings.Builder<GetLineageEventRequest, LineageEvent>
        getLineageEventSettings() {
      return getStubSettingsBuilder().getLineageEventSettings();
    }

    /** Returns the builder for the settings used for calls to listLineageEvents. */
    public PagedCallSettings.Builder<
            ListLineageEventsRequest, ListLineageEventsResponse, ListLineageEventsPagedResponse>
        listLineageEventsSettings() {
      return getStubSettingsBuilder().listLineageEventsSettings();
    }

    /** Returns the builder for the settings used for calls to deleteLineageEvent. */
    public UnaryCallSettings.Builder<DeleteLineageEventRequest, Empty>
        deleteLineageEventSettings() {
      return getStubSettingsBuilder().deleteLineageEventSettings();
    }

    /** Returns the builder for the settings used for calls to searchLinks. */
    public PagedCallSettings.Builder<
            SearchLinksRequest, SearchLinksResponse, SearchLinksPagedResponse>
        searchLinksSettings() {
      return getStubSettingsBuilder().searchLinksSettings();
    }

    /** Returns the builder for the settings used for calls to batchSearchLinkProcesses. */
    public PagedCallSettings.Builder<
            BatchSearchLinkProcessesRequest,
            BatchSearchLinkProcessesResponse,
            BatchSearchLinkProcessesPagedResponse>
        batchSearchLinkProcessesSettings() {
      return getStubSettingsBuilder().batchSearchLinkProcessesSettings();
    }

    @Override
    public LineageSettings build() throws IOException {
      return new LineageSettings(this);
    }
  }
}
