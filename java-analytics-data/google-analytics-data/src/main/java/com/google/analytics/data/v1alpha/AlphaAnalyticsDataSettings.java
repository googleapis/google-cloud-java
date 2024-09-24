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

package com.google.analytics.data.v1alpha;

import static com.google.analytics.data.v1alpha.AlphaAnalyticsDataClient.ListAudienceListsPagedResponse;
import static com.google.analytics.data.v1alpha.AlphaAnalyticsDataClient.ListRecurringAudienceListsPagedResponse;
import static com.google.analytics.data.v1alpha.AlphaAnalyticsDataClient.ListReportTasksPagedResponse;

import com.google.analytics.data.v1alpha.stub.AlphaAnalyticsDataStubSettings;
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
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.longrunning.Operation;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link AlphaAnalyticsDataClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (analyticsdata.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of runFunnelReport:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * AlphaAnalyticsDataSettings.Builder alphaAnalyticsDataSettingsBuilder =
 *     AlphaAnalyticsDataSettings.newBuilder();
 * alphaAnalyticsDataSettingsBuilder
 *     .runFunnelReportSettings()
 *     .setRetrySettings(
 *         alphaAnalyticsDataSettingsBuilder
 *             .runFunnelReportSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofSeconds(1))
 *             .setInitialRpcTimeoutDuration(Duration.ofSeconds(5))
 *             .setMaxAttempts(5)
 *             .setMaxRetryDelayDuration(Duration.ofSeconds(30))
 *             .setMaxRpcTimeoutDuration(Duration.ofSeconds(60))
 *             .setRetryDelayMultiplier(1.3)
 *             .setRpcTimeoutMultiplier(1.5)
 *             .setTotalTimeoutDuration(Duration.ofSeconds(300))
 *             .build());
 * AlphaAnalyticsDataSettings alphaAnalyticsDataSettings =
 *     alphaAnalyticsDataSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for createAudienceList:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * AlphaAnalyticsDataSettings.Builder alphaAnalyticsDataSettingsBuilder =
 *     AlphaAnalyticsDataSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelay(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * alphaAnalyticsDataSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class AlphaAnalyticsDataSettings extends ClientSettings<AlphaAnalyticsDataSettings> {

  /** Returns the object with the settings used for calls to runFunnelReport. */
  public UnaryCallSettings<RunFunnelReportRequest, RunFunnelReportResponse>
      runFunnelReportSettings() {
    return ((AlphaAnalyticsDataStubSettings) getStubSettings()).runFunnelReportSettings();
  }

  /** Returns the object with the settings used for calls to createAudienceList. */
  public UnaryCallSettings<CreateAudienceListRequest, Operation> createAudienceListSettings() {
    return ((AlphaAnalyticsDataStubSettings) getStubSettings()).createAudienceListSettings();
  }

  /** Returns the object with the settings used for calls to createAudienceList. */
  public OperationCallSettings<CreateAudienceListRequest, AudienceList, AudienceListMetadata>
      createAudienceListOperationSettings() {
    return ((AlphaAnalyticsDataStubSettings) getStubSettings())
        .createAudienceListOperationSettings();
  }

  /** Returns the object with the settings used for calls to queryAudienceList. */
  public UnaryCallSettings<QueryAudienceListRequest, QueryAudienceListResponse>
      queryAudienceListSettings() {
    return ((AlphaAnalyticsDataStubSettings) getStubSettings()).queryAudienceListSettings();
  }

  /** Returns the object with the settings used for calls to sheetExportAudienceList. */
  public UnaryCallSettings<SheetExportAudienceListRequest, SheetExportAudienceListResponse>
      sheetExportAudienceListSettings() {
    return ((AlphaAnalyticsDataStubSettings) getStubSettings()).sheetExportAudienceListSettings();
  }

  /** Returns the object with the settings used for calls to getAudienceList. */
  public UnaryCallSettings<GetAudienceListRequest, AudienceList> getAudienceListSettings() {
    return ((AlphaAnalyticsDataStubSettings) getStubSettings()).getAudienceListSettings();
  }

  /** Returns the object with the settings used for calls to listAudienceLists. */
  public PagedCallSettings<
          ListAudienceListsRequest, ListAudienceListsResponse, ListAudienceListsPagedResponse>
      listAudienceListsSettings() {
    return ((AlphaAnalyticsDataStubSettings) getStubSettings()).listAudienceListsSettings();
  }

  /** Returns the object with the settings used for calls to createRecurringAudienceList. */
  public UnaryCallSettings<CreateRecurringAudienceListRequest, RecurringAudienceList>
      createRecurringAudienceListSettings() {
    return ((AlphaAnalyticsDataStubSettings) getStubSettings())
        .createRecurringAudienceListSettings();
  }

  /** Returns the object with the settings used for calls to getRecurringAudienceList. */
  public UnaryCallSettings<GetRecurringAudienceListRequest, RecurringAudienceList>
      getRecurringAudienceListSettings() {
    return ((AlphaAnalyticsDataStubSettings) getStubSettings()).getRecurringAudienceListSettings();
  }

  /** Returns the object with the settings used for calls to listRecurringAudienceLists. */
  public PagedCallSettings<
          ListRecurringAudienceListsRequest,
          ListRecurringAudienceListsResponse,
          ListRecurringAudienceListsPagedResponse>
      listRecurringAudienceListsSettings() {
    return ((AlphaAnalyticsDataStubSettings) getStubSettings())
        .listRecurringAudienceListsSettings();
  }

  /** Returns the object with the settings used for calls to getPropertyQuotasSnapshot. */
  public UnaryCallSettings<GetPropertyQuotasSnapshotRequest, PropertyQuotasSnapshot>
      getPropertyQuotasSnapshotSettings() {
    return ((AlphaAnalyticsDataStubSettings) getStubSettings()).getPropertyQuotasSnapshotSettings();
  }

  /** Returns the object with the settings used for calls to createReportTask. */
  public UnaryCallSettings<CreateReportTaskRequest, Operation> createReportTaskSettings() {
    return ((AlphaAnalyticsDataStubSettings) getStubSettings()).createReportTaskSettings();
  }

  /** Returns the object with the settings used for calls to createReportTask. */
  public OperationCallSettings<CreateReportTaskRequest, ReportTask, ReportTaskMetadata>
      createReportTaskOperationSettings() {
    return ((AlphaAnalyticsDataStubSettings) getStubSettings()).createReportTaskOperationSettings();
  }

  /** Returns the object with the settings used for calls to queryReportTask. */
  public UnaryCallSettings<QueryReportTaskRequest, QueryReportTaskResponse>
      queryReportTaskSettings() {
    return ((AlphaAnalyticsDataStubSettings) getStubSettings()).queryReportTaskSettings();
  }

  /** Returns the object with the settings used for calls to getReportTask. */
  public UnaryCallSettings<GetReportTaskRequest, ReportTask> getReportTaskSettings() {
    return ((AlphaAnalyticsDataStubSettings) getStubSettings()).getReportTaskSettings();
  }

  /** Returns the object with the settings used for calls to listReportTasks. */
  public PagedCallSettings<
          ListReportTasksRequest, ListReportTasksResponse, ListReportTasksPagedResponse>
      listReportTasksSettings() {
    return ((AlphaAnalyticsDataStubSettings) getStubSettings()).listReportTasksSettings();
  }

  public static final AlphaAnalyticsDataSettings create(AlphaAnalyticsDataStubSettings stub)
      throws IOException {
    return new AlphaAnalyticsDataSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return AlphaAnalyticsDataStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return AlphaAnalyticsDataStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return AlphaAnalyticsDataStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return AlphaAnalyticsDataStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return AlphaAnalyticsDataStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return AlphaAnalyticsDataStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return AlphaAnalyticsDataStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return AlphaAnalyticsDataStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected AlphaAnalyticsDataSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for AlphaAnalyticsDataSettings. */
  public static class Builder extends ClientSettings.Builder<AlphaAnalyticsDataSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(AlphaAnalyticsDataStubSettings.newBuilder(clientContext));
    }

    protected Builder(AlphaAnalyticsDataSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(AlphaAnalyticsDataStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(AlphaAnalyticsDataStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(AlphaAnalyticsDataStubSettings.newHttpJsonBuilder());
    }

    public AlphaAnalyticsDataStubSettings.Builder getStubSettingsBuilder() {
      return ((AlphaAnalyticsDataStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to runFunnelReport. */
    public UnaryCallSettings.Builder<RunFunnelReportRequest, RunFunnelReportResponse>
        runFunnelReportSettings() {
      return getStubSettingsBuilder().runFunnelReportSettings();
    }

    /** Returns the builder for the settings used for calls to createAudienceList. */
    public UnaryCallSettings.Builder<CreateAudienceListRequest, Operation>
        createAudienceListSettings() {
      return getStubSettingsBuilder().createAudienceListSettings();
    }

    /** Returns the builder for the settings used for calls to createAudienceList. */
    public OperationCallSettings.Builder<
            CreateAudienceListRequest, AudienceList, AudienceListMetadata>
        createAudienceListOperationSettings() {
      return getStubSettingsBuilder().createAudienceListOperationSettings();
    }

    /** Returns the builder for the settings used for calls to queryAudienceList. */
    public UnaryCallSettings.Builder<QueryAudienceListRequest, QueryAudienceListResponse>
        queryAudienceListSettings() {
      return getStubSettingsBuilder().queryAudienceListSettings();
    }

    /** Returns the builder for the settings used for calls to sheetExportAudienceList. */
    public UnaryCallSettings.Builder<
            SheetExportAudienceListRequest, SheetExportAudienceListResponse>
        sheetExportAudienceListSettings() {
      return getStubSettingsBuilder().sheetExportAudienceListSettings();
    }

    /** Returns the builder for the settings used for calls to getAudienceList. */
    public UnaryCallSettings.Builder<GetAudienceListRequest, AudienceList>
        getAudienceListSettings() {
      return getStubSettingsBuilder().getAudienceListSettings();
    }

    /** Returns the builder for the settings used for calls to listAudienceLists. */
    public PagedCallSettings.Builder<
            ListAudienceListsRequest, ListAudienceListsResponse, ListAudienceListsPagedResponse>
        listAudienceListsSettings() {
      return getStubSettingsBuilder().listAudienceListsSettings();
    }

    /** Returns the builder for the settings used for calls to createRecurringAudienceList. */
    public UnaryCallSettings.Builder<CreateRecurringAudienceListRequest, RecurringAudienceList>
        createRecurringAudienceListSettings() {
      return getStubSettingsBuilder().createRecurringAudienceListSettings();
    }

    /** Returns the builder for the settings used for calls to getRecurringAudienceList. */
    public UnaryCallSettings.Builder<GetRecurringAudienceListRequest, RecurringAudienceList>
        getRecurringAudienceListSettings() {
      return getStubSettingsBuilder().getRecurringAudienceListSettings();
    }

    /** Returns the builder for the settings used for calls to listRecurringAudienceLists. */
    public PagedCallSettings.Builder<
            ListRecurringAudienceListsRequest,
            ListRecurringAudienceListsResponse,
            ListRecurringAudienceListsPagedResponse>
        listRecurringAudienceListsSettings() {
      return getStubSettingsBuilder().listRecurringAudienceListsSettings();
    }

    /** Returns the builder for the settings used for calls to getPropertyQuotasSnapshot. */
    public UnaryCallSettings.Builder<GetPropertyQuotasSnapshotRequest, PropertyQuotasSnapshot>
        getPropertyQuotasSnapshotSettings() {
      return getStubSettingsBuilder().getPropertyQuotasSnapshotSettings();
    }

    /** Returns the builder for the settings used for calls to createReportTask. */
    public UnaryCallSettings.Builder<CreateReportTaskRequest, Operation>
        createReportTaskSettings() {
      return getStubSettingsBuilder().createReportTaskSettings();
    }

    /** Returns the builder for the settings used for calls to createReportTask. */
    public OperationCallSettings.Builder<CreateReportTaskRequest, ReportTask, ReportTaskMetadata>
        createReportTaskOperationSettings() {
      return getStubSettingsBuilder().createReportTaskOperationSettings();
    }

    /** Returns the builder for the settings used for calls to queryReportTask. */
    public UnaryCallSettings.Builder<QueryReportTaskRequest, QueryReportTaskResponse>
        queryReportTaskSettings() {
      return getStubSettingsBuilder().queryReportTaskSettings();
    }

    /** Returns the builder for the settings used for calls to getReportTask. */
    public UnaryCallSettings.Builder<GetReportTaskRequest, ReportTask> getReportTaskSettings() {
      return getStubSettingsBuilder().getReportTaskSettings();
    }

    /** Returns the builder for the settings used for calls to listReportTasks. */
    public PagedCallSettings.Builder<
            ListReportTasksRequest, ListReportTasksResponse, ListReportTasksPagedResponse>
        listReportTasksSettings() {
      return getStubSettingsBuilder().listReportTasksSettings();
    }

    @Override
    public AlphaAnalyticsDataSettings build() throws IOException {
      return new AlphaAnalyticsDataSettings(this);
    }
  }
}
