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

package com.google.cloud.monitoring.v3;

import static com.google.cloud.monitoring.v3.MetricServiceClient.ListMetricDescriptorsPagedResponse;
import static com.google.cloud.monitoring.v3.MetricServiceClient.ListMonitoredResourceDescriptorsPagedResponse;
import static com.google.cloud.monitoring.v3.MetricServiceClient.ListTimeSeriesPagedResponse;

import com.google.api.MetricDescriptor;
import com.google.api.MonitoredResourceDescriptor;
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
import com.google.cloud.monitoring.v3.stub.MetricServiceStubSettings;
import com.google.monitoring.v3.CreateMetricDescriptorRequest;
import com.google.monitoring.v3.CreateTimeSeriesRequest;
import com.google.monitoring.v3.DeleteMetricDescriptorRequest;
import com.google.monitoring.v3.GetMetricDescriptorRequest;
import com.google.monitoring.v3.GetMonitoredResourceDescriptorRequest;
import com.google.monitoring.v3.ListMetricDescriptorsRequest;
import com.google.monitoring.v3.ListMetricDescriptorsResponse;
import com.google.monitoring.v3.ListMonitoredResourceDescriptorsRequest;
import com.google.monitoring.v3.ListMonitoredResourceDescriptorsResponse;
import com.google.monitoring.v3.ListTimeSeriesRequest;
import com.google.monitoring.v3.ListTimeSeriesResponse;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link MetricServiceClient}.
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
 * <p>For example, to set the total timeout of getMonitoredResourceDescriptor to 30 seconds:
 *
 * <pre>{@code
 * MetricServiceSettings.Builder metricServiceSettingsBuilder = MetricServiceSettings.newBuilder();
 * metricServiceSettingsBuilder
 *     .getMonitoredResourceDescriptorSettings()
 *     .setRetrySettings(
 *         metricServiceSettingsBuilder
 *             .getMonitoredResourceDescriptorSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * MetricServiceSettings metricServiceSettings = metricServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class MetricServiceSettings extends ClientSettings<MetricServiceSettings> {

  /** Returns the object with the settings used for calls to listMonitoredResourceDescriptors. */
  public PagedCallSettings<
          ListMonitoredResourceDescriptorsRequest,
          ListMonitoredResourceDescriptorsResponse,
          ListMonitoredResourceDescriptorsPagedResponse>
      listMonitoredResourceDescriptorsSettings() {
    return ((MetricServiceStubSettings) getStubSettings())
        .listMonitoredResourceDescriptorsSettings();
  }

  /** Returns the object with the settings used for calls to getMonitoredResourceDescriptor. */
  public UnaryCallSettings<GetMonitoredResourceDescriptorRequest, MonitoredResourceDescriptor>
      getMonitoredResourceDescriptorSettings() {
    return ((MetricServiceStubSettings) getStubSettings()).getMonitoredResourceDescriptorSettings();
  }

  /** Returns the object with the settings used for calls to listMetricDescriptors. */
  public PagedCallSettings<
          ListMetricDescriptorsRequest,
          ListMetricDescriptorsResponse,
          ListMetricDescriptorsPagedResponse>
      listMetricDescriptorsSettings() {
    return ((MetricServiceStubSettings) getStubSettings()).listMetricDescriptorsSettings();
  }

  /** Returns the object with the settings used for calls to getMetricDescriptor. */
  public UnaryCallSettings<GetMetricDescriptorRequest, MetricDescriptor>
      getMetricDescriptorSettings() {
    return ((MetricServiceStubSettings) getStubSettings()).getMetricDescriptorSettings();
  }

  /** Returns the object with the settings used for calls to createMetricDescriptor. */
  public UnaryCallSettings<CreateMetricDescriptorRequest, MetricDescriptor>
      createMetricDescriptorSettings() {
    return ((MetricServiceStubSettings) getStubSettings()).createMetricDescriptorSettings();
  }

  /** Returns the object with the settings used for calls to deleteMetricDescriptor. */
  public UnaryCallSettings<DeleteMetricDescriptorRequest, Empty> deleteMetricDescriptorSettings() {
    return ((MetricServiceStubSettings) getStubSettings()).deleteMetricDescriptorSettings();
  }

  /** Returns the object with the settings used for calls to listTimeSeries. */
  public PagedCallSettings<
          ListTimeSeriesRequest, ListTimeSeriesResponse, ListTimeSeriesPagedResponse>
      listTimeSeriesSettings() {
    return ((MetricServiceStubSettings) getStubSettings()).listTimeSeriesSettings();
  }

  /** Returns the object with the settings used for calls to createTimeSeries. */
  public UnaryCallSettings<CreateTimeSeriesRequest, Empty> createTimeSeriesSettings() {
    return ((MetricServiceStubSettings) getStubSettings()).createTimeSeriesSettings();
  }

  public static final MetricServiceSettings create(MetricServiceStubSettings stub)
      throws IOException {
    return new MetricServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return MetricServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return MetricServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return MetricServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return MetricServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return MetricServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return MetricServiceStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return MetricServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected MetricServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for MetricServiceSettings. */
  public static class Builder extends ClientSettings.Builder<MetricServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(MetricServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(MetricServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(MetricServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(MetricServiceStubSettings.newBuilder());
    }

    public MetricServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((MetricServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to listMonitoredResourceDescriptors. */
    public PagedCallSettings.Builder<
            ListMonitoredResourceDescriptorsRequest,
            ListMonitoredResourceDescriptorsResponse,
            ListMonitoredResourceDescriptorsPagedResponse>
        listMonitoredResourceDescriptorsSettings() {
      return getStubSettingsBuilder().listMonitoredResourceDescriptorsSettings();
    }

    /** Returns the builder for the settings used for calls to getMonitoredResourceDescriptor. */
    public UnaryCallSettings.Builder<
            GetMonitoredResourceDescriptorRequest, MonitoredResourceDescriptor>
        getMonitoredResourceDescriptorSettings() {
      return getStubSettingsBuilder().getMonitoredResourceDescriptorSettings();
    }

    /** Returns the builder for the settings used for calls to listMetricDescriptors. */
    public PagedCallSettings.Builder<
            ListMetricDescriptorsRequest,
            ListMetricDescriptorsResponse,
            ListMetricDescriptorsPagedResponse>
        listMetricDescriptorsSettings() {
      return getStubSettingsBuilder().listMetricDescriptorsSettings();
    }

    /** Returns the builder for the settings used for calls to getMetricDescriptor. */
    public UnaryCallSettings.Builder<GetMetricDescriptorRequest, MetricDescriptor>
        getMetricDescriptorSettings() {
      return getStubSettingsBuilder().getMetricDescriptorSettings();
    }

    /** Returns the builder for the settings used for calls to createMetricDescriptor. */
    public UnaryCallSettings.Builder<CreateMetricDescriptorRequest, MetricDescriptor>
        createMetricDescriptorSettings() {
      return getStubSettingsBuilder().createMetricDescriptorSettings();
    }

    /** Returns the builder for the settings used for calls to deleteMetricDescriptor. */
    public UnaryCallSettings.Builder<DeleteMetricDescriptorRequest, Empty>
        deleteMetricDescriptorSettings() {
      return getStubSettingsBuilder().deleteMetricDescriptorSettings();
    }

    /** Returns the builder for the settings used for calls to listTimeSeries. */
    public PagedCallSettings.Builder<
            ListTimeSeriesRequest, ListTimeSeriesResponse, ListTimeSeriesPagedResponse>
        listTimeSeriesSettings() {
      return getStubSettingsBuilder().listTimeSeriesSettings();
    }

    /** Returns the builder for the settings used for calls to createTimeSeries. */
    public UnaryCallSettings.Builder<CreateTimeSeriesRequest, Empty> createTimeSeriesSettings() {
      return getStubSettingsBuilder().createTimeSeriesSettings();
    }

    @Override
    public MetricServiceSettings build() throws IOException {
      return new MetricServiceSettings(this);
    }
  }
}
