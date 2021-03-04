/*
 * Copyright 2021 Google LLC
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

import static com.google.analytics.data.v1beta.BetaAnalyticsDataClient.RunReportPagedResponse;

import com.google.analytics.data.v1beta.stub.BetaAnalyticsDataStubSettings;
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
 * <p>For example, to set the total timeout of runPivotReport to 30 seconds:
 *
 * <pre>{@code
 * BetaAnalyticsDataSettings.Builder betaAnalyticsDataSettingsBuilder =
 *     BetaAnalyticsDataSettings.newBuilder();
 * betaAnalyticsDataSettingsBuilder
 *     .runPivotReportSettings()
 *     .setRetrySettings(
 *         betaAnalyticsDataSettingsBuilder
 *             .runPivotReportSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * BetaAnalyticsDataSettings betaAnalyticsDataSettings = betaAnalyticsDataSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class BetaAnalyticsDataSettings extends ClientSettings<BetaAnalyticsDataSettings> {

  /** Returns the object with the settings used for calls to runReport. */
  public PagedCallSettings<RunReportRequest, RunReportResponse, RunReportPagedResponse>
      runReportSettings() {
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

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return BetaAnalyticsDataStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return BetaAnalyticsDataStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return BetaAnalyticsDataStubSettings.defaultApiClientHeaderProviderBuilder();
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

    public BetaAnalyticsDataStubSettings.Builder getStubSettingsBuilder() {
      return ((BetaAnalyticsDataStubSettings.Builder) getStubSettings());
    }

    // NEXT_MAJOR_VER: remove 'throws Exception'.
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

    /** Returns the builder for the settings used for calls to runReport. */
    public PagedCallSettings.Builder<RunReportRequest, RunReportResponse, RunReportPagedResponse>
        runReportSettings() {
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

    @Override
    public BetaAnalyticsDataSettings build() throws IOException {
      return new BetaAnalyticsDataSettings(this);
    }
  }
}
