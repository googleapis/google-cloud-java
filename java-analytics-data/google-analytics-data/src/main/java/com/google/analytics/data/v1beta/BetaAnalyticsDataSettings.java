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

package com.google.analytics.data.v1beta;

import static com.google.analytics.data.v1beta.BetaAnalyticsDataClient.ListAudienceExportsPagedResponse;

import com.google.analytics.data.v1beta.stub.BetaAnalyticsDataStubSettings;
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
 * Settings class to configure an instance of {@link BetaAnalyticsDataClient}.
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
 * of runReport:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * BetaAnalyticsDataSettings.Builder betaAnalyticsDataSettingsBuilder =
 *     BetaAnalyticsDataSettings.newBuilder();
 * betaAnalyticsDataSettingsBuilder
 *     .runReportSettings()
 *     .setRetrySettings(
 *         betaAnalyticsDataSettingsBuilder
 *             .runReportSettings()
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
 * BetaAnalyticsDataSettings betaAnalyticsDataSettings = betaAnalyticsDataSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for createAudienceExport:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * BetaAnalyticsDataSettings.Builder betaAnalyticsDataSettingsBuilder =
 *     BetaAnalyticsDataSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelay(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * betaAnalyticsDataSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class BetaAnalyticsDataSettings extends ClientSettings<BetaAnalyticsDataSettings> {

  /** Returns the object with the settings used for calls to runReport. */
  public UnaryCallSettings<RunReportRequest, RunReportResponse> runReportSettings() {
    return ((BetaAnalyticsDataStubSettings) getStubSettings()).runReportSettings();
  }

  /** Returns the object with the settings used for calls to runPivotReport. */
  public UnaryCallSettings<RunPivotReportRequest, RunPivotReportResponse> runPivotReportSettings() {
    return ((BetaAnalyticsDataStubSettings) getStubSettings()).runPivotReportSettings();
  }

  /** Returns the object with the settings used for calls to batchRunReports. */
  public UnaryCallSettings<BatchRunReportsRequest, BatchRunReportsResponse>
      batchRunReportsSettings() {
    return ((BetaAnalyticsDataStubSettings) getStubSettings()).batchRunReportsSettings();
  }

  /** Returns the object with the settings used for calls to batchRunPivotReports. */
  public UnaryCallSettings<BatchRunPivotReportsRequest, BatchRunPivotReportsResponse>
      batchRunPivotReportsSettings() {
    return ((BetaAnalyticsDataStubSettings) getStubSettings()).batchRunPivotReportsSettings();
  }

  /** Returns the object with the settings used for calls to getMetadata. */
  public UnaryCallSettings<GetMetadataRequest, Metadata> getMetadataSettings() {
    return ((BetaAnalyticsDataStubSettings) getStubSettings()).getMetadataSettings();
  }

  /** Returns the object with the settings used for calls to runRealtimeReport. */
  public UnaryCallSettings<RunRealtimeReportRequest, RunRealtimeReportResponse>
      runRealtimeReportSettings() {
    return ((BetaAnalyticsDataStubSettings) getStubSettings()).runRealtimeReportSettings();
  }

  /** Returns the object with the settings used for calls to checkCompatibility. */
  public UnaryCallSettings<CheckCompatibilityRequest, CheckCompatibilityResponse>
      checkCompatibilitySettings() {
    return ((BetaAnalyticsDataStubSettings) getStubSettings()).checkCompatibilitySettings();
  }

  /** Returns the object with the settings used for calls to createAudienceExport. */
  public UnaryCallSettings<CreateAudienceExportRequest, Operation> createAudienceExportSettings() {
    return ((BetaAnalyticsDataStubSettings) getStubSettings()).createAudienceExportSettings();
  }

  /** Returns the object with the settings used for calls to createAudienceExport. */
  public OperationCallSettings<CreateAudienceExportRequest, AudienceExport, AudienceExportMetadata>
      createAudienceExportOperationSettings() {
    return ((BetaAnalyticsDataStubSettings) getStubSettings())
        .createAudienceExportOperationSettings();
  }

  /** Returns the object with the settings used for calls to queryAudienceExport. */
  public UnaryCallSettings<QueryAudienceExportRequest, QueryAudienceExportResponse>
      queryAudienceExportSettings() {
    return ((BetaAnalyticsDataStubSettings) getStubSettings()).queryAudienceExportSettings();
  }

  /** Returns the object with the settings used for calls to getAudienceExport. */
  public UnaryCallSettings<GetAudienceExportRequest, AudienceExport> getAudienceExportSettings() {
    return ((BetaAnalyticsDataStubSettings) getStubSettings()).getAudienceExportSettings();
  }

  /** Returns the object with the settings used for calls to listAudienceExports. */
  public PagedCallSettings<
          ListAudienceExportsRequest, ListAudienceExportsResponse, ListAudienceExportsPagedResponse>
      listAudienceExportsSettings() {
    return ((BetaAnalyticsDataStubSettings) getStubSettings()).listAudienceExportsSettings();
  }

  public static final BetaAnalyticsDataSettings create(BetaAnalyticsDataStubSettings stub)
      throws IOException {
    return new BetaAnalyticsDataSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return BetaAnalyticsDataStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return BetaAnalyticsDataStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return BetaAnalyticsDataStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return BetaAnalyticsDataStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return BetaAnalyticsDataStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return BetaAnalyticsDataStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return BetaAnalyticsDataStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return BetaAnalyticsDataStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected BetaAnalyticsDataSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for BetaAnalyticsDataSettings. */
  public static class Builder extends ClientSettings.Builder<BetaAnalyticsDataSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(BetaAnalyticsDataStubSettings.newBuilder(clientContext));
    }

    protected Builder(BetaAnalyticsDataSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(BetaAnalyticsDataStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(BetaAnalyticsDataStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(BetaAnalyticsDataStubSettings.newHttpJsonBuilder());
    }

    public BetaAnalyticsDataStubSettings.Builder getStubSettingsBuilder() {
      return ((BetaAnalyticsDataStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to runReport. */
    public UnaryCallSettings.Builder<RunReportRequest, RunReportResponse> runReportSettings() {
      return getStubSettingsBuilder().runReportSettings();
    }

    /** Returns the builder for the settings used for calls to runPivotReport. */
    public UnaryCallSettings.Builder<RunPivotReportRequest, RunPivotReportResponse>
        runPivotReportSettings() {
      return getStubSettingsBuilder().runPivotReportSettings();
    }

    /** Returns the builder for the settings used for calls to batchRunReports. */
    public UnaryCallSettings.Builder<BatchRunReportsRequest, BatchRunReportsResponse>
        batchRunReportsSettings() {
      return getStubSettingsBuilder().batchRunReportsSettings();
    }

    /** Returns the builder for the settings used for calls to batchRunPivotReports. */
    public UnaryCallSettings.Builder<BatchRunPivotReportsRequest, BatchRunPivotReportsResponse>
        batchRunPivotReportsSettings() {
      return getStubSettingsBuilder().batchRunPivotReportsSettings();
    }

    /** Returns the builder for the settings used for calls to getMetadata. */
    public UnaryCallSettings.Builder<GetMetadataRequest, Metadata> getMetadataSettings() {
      return getStubSettingsBuilder().getMetadataSettings();
    }

    /** Returns the builder for the settings used for calls to runRealtimeReport. */
    public UnaryCallSettings.Builder<RunRealtimeReportRequest, RunRealtimeReportResponse>
        runRealtimeReportSettings() {
      return getStubSettingsBuilder().runRealtimeReportSettings();
    }

    /** Returns the builder for the settings used for calls to checkCompatibility. */
    public UnaryCallSettings.Builder<CheckCompatibilityRequest, CheckCompatibilityResponse>
        checkCompatibilitySettings() {
      return getStubSettingsBuilder().checkCompatibilitySettings();
    }

    /** Returns the builder for the settings used for calls to createAudienceExport. */
    public UnaryCallSettings.Builder<CreateAudienceExportRequest, Operation>
        createAudienceExportSettings() {
      return getStubSettingsBuilder().createAudienceExportSettings();
    }

    /** Returns the builder for the settings used for calls to createAudienceExport. */
    public OperationCallSettings.Builder<
            CreateAudienceExportRequest, AudienceExport, AudienceExportMetadata>
        createAudienceExportOperationSettings() {
      return getStubSettingsBuilder().createAudienceExportOperationSettings();
    }

    /** Returns the builder for the settings used for calls to queryAudienceExport. */
    public UnaryCallSettings.Builder<QueryAudienceExportRequest, QueryAudienceExportResponse>
        queryAudienceExportSettings() {
      return getStubSettingsBuilder().queryAudienceExportSettings();
    }

    /** Returns the builder for the settings used for calls to getAudienceExport. */
    public UnaryCallSettings.Builder<GetAudienceExportRequest, AudienceExport>
        getAudienceExportSettings() {
      return getStubSettingsBuilder().getAudienceExportSettings();
    }

    /** Returns the builder for the settings used for calls to listAudienceExports. */
    public PagedCallSettings.Builder<
            ListAudienceExportsRequest,
            ListAudienceExportsResponse,
            ListAudienceExportsPagedResponse>
        listAudienceExportsSettings() {
      return getStubSettingsBuilder().listAudienceExportsSettings();
    }

    @Override
    public BetaAnalyticsDataSettings build() throws IOException {
      return new BetaAnalyticsDataSettings(this);
    }
  }
}
