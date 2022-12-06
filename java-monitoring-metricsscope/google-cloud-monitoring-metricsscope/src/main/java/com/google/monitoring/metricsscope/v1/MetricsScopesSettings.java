/*
 * Copyright 2022 Google LLC
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

package com.google.monitoring.metricsscope.v1;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.longrunning.Operation;
import com.google.monitoring.metricsscope.v1.stub.MetricsScopesStubSettings;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link MetricsScopesClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (monitoring.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getMetricsScope to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * MetricsScopesSettings.Builder metricsScopesSettingsBuilder = MetricsScopesSettings.newBuilder();
 * metricsScopesSettingsBuilder
 *     .getMetricsScopeSettings()
 *     .setRetrySettings(
 *         metricsScopesSettingsBuilder.getMetricsScopeSettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * MetricsScopesSettings metricsScopesSettings = metricsScopesSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class MetricsScopesSettings extends ClientSettings<MetricsScopesSettings> {

  /** Returns the object with the settings used for calls to getMetricsScope. */
  public UnaryCallSettings<GetMetricsScopeRequest, MetricsScope> getMetricsScopeSettings() {
    return ((MetricsScopesStubSettings) getStubSettings()).getMetricsScopeSettings();
  }

  /** Returns the object with the settings used for calls to listMetricsScopesByMonitoredProject. */
  public UnaryCallSettings<
          ListMetricsScopesByMonitoredProjectRequest, ListMetricsScopesByMonitoredProjectResponse>
      listMetricsScopesByMonitoredProjectSettings() {
    return ((MetricsScopesStubSettings) getStubSettings())
        .listMetricsScopesByMonitoredProjectSettings();
  }

  /** Returns the object with the settings used for calls to createMonitoredProject. */
  public UnaryCallSettings<CreateMonitoredProjectRequest, Operation>
      createMonitoredProjectSettings() {
    return ((MetricsScopesStubSettings) getStubSettings()).createMonitoredProjectSettings();
  }

  /** Returns the object with the settings used for calls to createMonitoredProject. */
  public OperationCallSettings<CreateMonitoredProjectRequest, MonitoredProject, OperationMetadata>
      createMonitoredProjectOperationSettings() {
    return ((MetricsScopesStubSettings) getStubSettings())
        .createMonitoredProjectOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteMonitoredProject. */
  public UnaryCallSettings<DeleteMonitoredProjectRequest, Operation>
      deleteMonitoredProjectSettings() {
    return ((MetricsScopesStubSettings) getStubSettings()).deleteMonitoredProjectSettings();
  }

  /** Returns the object with the settings used for calls to deleteMonitoredProject. */
  public OperationCallSettings<DeleteMonitoredProjectRequest, Empty, OperationMetadata>
      deleteMonitoredProjectOperationSettings() {
    return ((MetricsScopesStubSettings) getStubSettings())
        .deleteMonitoredProjectOperationSettings();
  }

  public static final MetricsScopesSettings create(MetricsScopesStubSettings stub)
      throws IOException {
    return new MetricsScopesSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return MetricsScopesStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return MetricsScopesStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return MetricsScopesStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return MetricsScopesStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return MetricsScopesStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return MetricsScopesStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return MetricsScopesStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected MetricsScopesSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for MetricsScopesSettings. */
  public static class Builder extends ClientSettings.Builder<MetricsScopesSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(MetricsScopesStubSettings.newBuilder(clientContext));
    }

    protected Builder(MetricsScopesSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(MetricsScopesStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(MetricsScopesStubSettings.newBuilder());
    }

    public MetricsScopesStubSettings.Builder getStubSettingsBuilder() {
      return ((MetricsScopesStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to getMetricsScope. */
    public UnaryCallSettings.Builder<GetMetricsScopeRequest, MetricsScope>
        getMetricsScopeSettings() {
      return getStubSettingsBuilder().getMetricsScopeSettings();
    }

    /**
     * Returns the builder for the settings used for calls to listMetricsScopesByMonitoredProject.
     */
    public UnaryCallSettings.Builder<
            ListMetricsScopesByMonitoredProjectRequest, ListMetricsScopesByMonitoredProjectResponse>
        listMetricsScopesByMonitoredProjectSettings() {
      return getStubSettingsBuilder().listMetricsScopesByMonitoredProjectSettings();
    }

    /** Returns the builder for the settings used for calls to createMonitoredProject. */
    public UnaryCallSettings.Builder<CreateMonitoredProjectRequest, Operation>
        createMonitoredProjectSettings() {
      return getStubSettingsBuilder().createMonitoredProjectSettings();
    }

    /** Returns the builder for the settings used for calls to createMonitoredProject. */
    public OperationCallSettings.Builder<
            CreateMonitoredProjectRequest, MonitoredProject, OperationMetadata>
        createMonitoredProjectOperationSettings() {
      return getStubSettingsBuilder().createMonitoredProjectOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteMonitoredProject. */
    public UnaryCallSettings.Builder<DeleteMonitoredProjectRequest, Operation>
        deleteMonitoredProjectSettings() {
      return getStubSettingsBuilder().deleteMonitoredProjectSettings();
    }

    /** Returns the builder for the settings used for calls to deleteMonitoredProject. */
    public OperationCallSettings.Builder<DeleteMonitoredProjectRequest, Empty, OperationMetadata>
        deleteMonitoredProjectOperationSettings() {
      return getStubSettingsBuilder().deleteMonitoredProjectOperationSettings();
    }

    @Override
    public MetricsScopesSettings build() throws IOException {
      return new MetricsScopesSettings(this);
    }
  }
}
