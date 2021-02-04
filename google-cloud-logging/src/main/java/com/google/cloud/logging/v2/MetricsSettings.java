/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.logging.v2;

import static com.google.cloud.logging.v2.MetricsClient.ListLogMetricsPagedResponse;

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
import com.google.cloud.logging.v2.stub.MetricsServiceV2StubSettings;
import com.google.logging.v2.CreateLogMetricRequest;
import com.google.logging.v2.DeleteLogMetricRequest;
import com.google.logging.v2.GetLogMetricRequest;
import com.google.logging.v2.ListLogMetricsRequest;
import com.google.logging.v2.ListLogMetricsResponse;
import com.google.logging.v2.LogMetric;
import com.google.logging.v2.UpdateLogMetricRequest;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link MetricsClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (logging.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getLogMetric to 30 seconds:
 *
 * <pre>{@code
 * MetricsSettings.Builder metricsSettingsBuilder = MetricsSettings.newBuilder();
 * metricsSettingsBuilder
 *     .getLogMetricSettings()
 *     .setRetrySettings(
 *         metricsSettingsBuilder
 *             .getLogMetricSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * MetricsSettings metricsSettings = metricsSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class MetricsSettings extends ClientSettings<MetricsSettings> {

  /** Returns the object with the settings used for calls to listLogMetrics. */
  public PagedCallSettings<
          ListLogMetricsRequest, ListLogMetricsResponse, ListLogMetricsPagedResponse>
      listLogMetricsSettings() {
    return ((MetricsServiceV2StubSettings) getStubSettings()).listLogMetricsSettings();
  }

  /** Returns the object with the settings used for calls to getLogMetric. */
  public UnaryCallSettings<GetLogMetricRequest, LogMetric> getLogMetricSettings() {
    return ((MetricsServiceV2StubSettings) getStubSettings()).getLogMetricSettings();
  }

  /** Returns the object with the settings used for calls to createLogMetric. */
  public UnaryCallSettings<CreateLogMetricRequest, LogMetric> createLogMetricSettings() {
    return ((MetricsServiceV2StubSettings) getStubSettings()).createLogMetricSettings();
  }

  /** Returns the object with the settings used for calls to updateLogMetric. */
  public UnaryCallSettings<UpdateLogMetricRequest, LogMetric> updateLogMetricSettings() {
    return ((MetricsServiceV2StubSettings) getStubSettings()).updateLogMetricSettings();
  }

  /** Returns the object with the settings used for calls to deleteLogMetric. */
  public UnaryCallSettings<DeleteLogMetricRequest, Empty> deleteLogMetricSettings() {
    return ((MetricsServiceV2StubSettings) getStubSettings()).deleteLogMetricSettings();
  }

  public static final MetricsSettings create(MetricsServiceV2StubSettings stub) throws IOException {
    return new MetricsSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return MetricsServiceV2StubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return MetricsServiceV2StubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return MetricsServiceV2StubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return MetricsServiceV2StubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return MetricsServiceV2StubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return MetricsServiceV2StubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return MetricsServiceV2StubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected MetricsSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for MetricsSettings. */
  public static class Builder extends ClientSettings.Builder<MetricsSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(MetricsServiceV2StubSettings.newBuilder(clientContext));
    }

    protected Builder(MetricsSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(MetricsServiceV2StubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(MetricsServiceV2StubSettings.newBuilder());
    }

    public MetricsServiceV2StubSettings.Builder getStubSettingsBuilder() {
      return ((MetricsServiceV2StubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to listLogMetrics. */
    public PagedCallSettings.Builder<
            ListLogMetricsRequest, ListLogMetricsResponse, ListLogMetricsPagedResponse>
        listLogMetricsSettings() {
      return getStubSettingsBuilder().listLogMetricsSettings();
    }

    /** Returns the builder for the settings used for calls to getLogMetric. */
    public UnaryCallSettings.Builder<GetLogMetricRequest, LogMetric> getLogMetricSettings() {
      return getStubSettingsBuilder().getLogMetricSettings();
    }

    /** Returns the builder for the settings used for calls to createLogMetric. */
    public UnaryCallSettings.Builder<CreateLogMetricRequest, LogMetric> createLogMetricSettings() {
      return getStubSettingsBuilder().createLogMetricSettings();
    }

    /** Returns the builder for the settings used for calls to updateLogMetric. */
    public UnaryCallSettings.Builder<UpdateLogMetricRequest, LogMetric> updateLogMetricSettings() {
      return getStubSettingsBuilder().updateLogMetricSettings();
    }

    /** Returns the builder for the settings used for calls to deleteLogMetric. */
    public UnaryCallSettings.Builder<DeleteLogMetricRequest, Empty> deleteLogMetricSettings() {
      return getStubSettingsBuilder().deleteLogMetricSettings();
    }

    @Override
    public MetricsSettings build() throws IOException {
      return new MetricsSettings(this);
    }
  }
}
