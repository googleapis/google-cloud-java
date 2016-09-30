/*
 * Copyright 2016 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.google.cloud.monitoring.spi.v3;

import com.google.api.MetricDescriptor;
import com.google.api.MonitoredResourceDescriptor;
import com.google.api.gax.core.ConnectionSettings;
import com.google.api.gax.core.PagedListResponse;
import com.google.api.gax.core.RetrySettings;
import com.google.api.gax.grpc.ApiCallSettings;
import com.google.api.gax.grpc.PageStreamingCallSettings;
import com.google.api.gax.grpc.PageStreamingDescriptor;
import com.google.api.gax.grpc.ServiceApiSettings;
import com.google.api.gax.grpc.SimpleCallSettings;
import com.google.auth.Credentials;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
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
import com.google.monitoring.v3.MetricServiceGrpc;
import com.google.monitoring.v3.TimeSeries;
import com.google.protobuf.Empty;
import io.grpc.ManagedChannel;
import io.grpc.Status;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import org.joda.time.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Settings class to configure an instance of {@link MetricServiceApi}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 * <li>The default service address (monitoring.googleapis.com) and default port (443)
 * are used.
 * <li>Credentials are acquired automatically through Application Default Credentials.
 * <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders.
 * When build() is called, the tree of builders is called to create the complete settings
 * object. For example, to set the total timeout of getMonitoredResourceDescriptor to 30 seconds:
 *
 * <pre>
 * <code>
 * MetricServiceSettings.Builder metricServiceSettingsBuilder =
 *     MetricServiceSettings.defaultBuilder();
 * metricServiceSettingsBuilder.getMonitoredResourceDescriptorSettings().getRetrySettingsBuilder()
 *     .setTotalTimeout(Duration.standardSeconds(30));
 * MetricServiceSettings metricServiceSettings = metricServiceSettingsBuilder.build();
 * </code>
 * </pre>
 */
@javax.annotation.Generated("by GAPIC")
public class MetricServiceSettings extends ServiceApiSettings {
  /**
   * The default address of the service.
   */
  private static final String DEFAULT_SERVICE_ADDRESS = "monitoring.googleapis.com";

  /**
   * The default port of the service.
   */
  private static final int DEFAULT_SERVICE_PORT = 443;

  /**
   * The default scopes of the service.
   */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().build();

  /**
   * The default connection settings of the service.
   */
  public static final ConnectionSettings DEFAULT_CONNECTION_SETTINGS =
      ConnectionSettings.newBuilder()
          .setServiceAddress(DEFAULT_SERVICE_ADDRESS)
          .setPort(DEFAULT_SERVICE_PORT)
          .provideCredentialsWith(DEFAULT_SERVICE_SCOPES)
          .build();

  private final PageStreamingCallSettings<
          ListMonitoredResourceDescriptorsRequest, ListMonitoredResourceDescriptorsResponse,
          MonitoredResourceDescriptor>
      listMonitoredResourceDescriptorsSettings;
  private final SimpleCallSettings<
          GetMonitoredResourceDescriptorRequest, MonitoredResourceDescriptor>
      getMonitoredResourceDescriptorSettings;
  private final PageStreamingCallSettings<
          ListMetricDescriptorsRequest, ListMetricDescriptorsResponse, MetricDescriptor>
      listMetricDescriptorsSettings;
  private final SimpleCallSettings<GetMetricDescriptorRequest, MetricDescriptor>
      getMetricDescriptorSettings;
  private final SimpleCallSettings<CreateMetricDescriptorRequest, MetricDescriptor>
      createMetricDescriptorSettings;
  private final SimpleCallSettings<DeleteMetricDescriptorRequest, Empty>
      deleteMetricDescriptorSettings;
  private final PageStreamingCallSettings<ListTimeSeriesRequest, ListTimeSeriesResponse, TimeSeries>
      listTimeSeriesSettings;
  private final SimpleCallSettings<CreateTimeSeriesRequest, Empty> createTimeSeriesSettings;

  /**
   * Returns the object with the settings used for calls to listMonitoredResourceDescriptors.
   */
  public PageStreamingCallSettings<
          ListMonitoredResourceDescriptorsRequest, ListMonitoredResourceDescriptorsResponse,
          MonitoredResourceDescriptor>
      listMonitoredResourceDescriptorsSettings() {
    return listMonitoredResourceDescriptorsSettings;
  }

  /**
   * Returns the object with the settings used for calls to getMonitoredResourceDescriptor.
   */
  public SimpleCallSettings<GetMonitoredResourceDescriptorRequest, MonitoredResourceDescriptor>
      getMonitoredResourceDescriptorSettings() {
    return getMonitoredResourceDescriptorSettings;
  }

  /**
   * Returns the object with the settings used for calls to listMetricDescriptors.
   */
  public PageStreamingCallSettings<
          ListMetricDescriptorsRequest, ListMetricDescriptorsResponse, MetricDescriptor>
      listMetricDescriptorsSettings() {
    return listMetricDescriptorsSettings;
  }

  /**
   * Returns the object with the settings used for calls to getMetricDescriptor.
   */
  public SimpleCallSettings<GetMetricDescriptorRequest, MetricDescriptor>
      getMetricDescriptorSettings() {
    return getMetricDescriptorSettings;
  }

  /**
   * Returns the object with the settings used for calls to createMetricDescriptor.
   */
  public SimpleCallSettings<CreateMetricDescriptorRequest, MetricDescriptor>
      createMetricDescriptorSettings() {
    return createMetricDescriptorSettings;
  }

  /**
   * Returns the object with the settings used for calls to deleteMetricDescriptor.
   */
  public SimpleCallSettings<DeleteMetricDescriptorRequest, Empty> deleteMetricDescriptorSettings() {
    return deleteMetricDescriptorSettings;
  }

  /**
   * Returns the object with the settings used for calls to listTimeSeries.
   */
  public PageStreamingCallSettings<ListTimeSeriesRequest, ListTimeSeriesResponse, TimeSeries>
      listTimeSeriesSettings() {
    return listTimeSeriesSettings;
  }

  /**
   * Returns the object with the settings used for calls to createTimeSeries.
   */
  public SimpleCallSettings<CreateTimeSeriesRequest, Empty> createTimeSeriesSettings() {
    return createTimeSeriesSettings;
  }

  /**
   * Returns the default service address.
   */
  public static String getDefaultServiceAddress() {
    return DEFAULT_SERVICE_ADDRESS;
  }

  /**
   * Returns the default service port.
   */
  public static int getDefaultServicePort() {
    return DEFAULT_SERVICE_PORT;
  }

  /**
   * Returns the default service scopes.
   */
  public static ImmutableList<String> getDefaultServiceScopes() {
    return DEFAULT_SERVICE_SCOPES;
  }

  /**
   * Returns a builder for this class with recommended defaults.
   */
  public static Builder defaultBuilder() {
    return Builder.createDefault();
  }

  /**
   * Returns a new builder for this class.
   */
  public static Builder newBuilder() {
    return new Builder();
  }

  /**
   * Returns a builder containing all the values of this settings class.
   */
  public Builder toBuilder() {
    return new Builder(this);
  }

  private MetricServiceSettings(Builder settingsBuilder) throws IOException {
    super(
        settingsBuilder.getChannelProvider(),
        settingsBuilder.getExecutorProvider(),
        settingsBuilder.getGeneratorName(),
        settingsBuilder.getGeneratorVersion(),
        settingsBuilder.getClientLibName(),
        settingsBuilder.getClientLibVersion());

    listMonitoredResourceDescriptorsSettings =
        settingsBuilder.listMonitoredResourceDescriptorsSettings().build();
    getMonitoredResourceDescriptorSettings =
        settingsBuilder.getMonitoredResourceDescriptorSettings().build();
    listMetricDescriptorsSettings = settingsBuilder.listMetricDescriptorsSettings().build();
    getMetricDescriptorSettings = settingsBuilder.getMetricDescriptorSettings().build();
    createMetricDescriptorSettings = settingsBuilder.createMetricDescriptorSettings().build();
    deleteMetricDescriptorSettings = settingsBuilder.deleteMetricDescriptorSettings().build();
    listTimeSeriesSettings = settingsBuilder.listTimeSeriesSettings().build();
    createTimeSeriesSettings = settingsBuilder.createTimeSeriesSettings().build();
  }

  private static final PageStreamingDescriptor<
          ListMonitoredResourceDescriptorsRequest, ListMonitoredResourceDescriptorsResponse,
          MonitoredResourceDescriptor>
      LIST_MONITORED_RESOURCE_DESCRIPTORS_PAGE_STR_DESC =
          new PageStreamingDescriptor<
              ListMonitoredResourceDescriptorsRequest, ListMonitoredResourceDescriptorsResponse,
              MonitoredResourceDescriptor>() {
            @Override
            public Object emptyToken() {
              return "";
            }

            @Override
            public ListMonitoredResourceDescriptorsRequest injectToken(
                ListMonitoredResourceDescriptorsRequest payload, Object token) {
              return ListMonitoredResourceDescriptorsRequest.newBuilder(payload)
                  .setPageToken((String) token)
                  .build();
            }

            @Override
            public ListMonitoredResourceDescriptorsRequest injectPageSize(
                ListMonitoredResourceDescriptorsRequest payload, int pageSize) {
              return ListMonitoredResourceDescriptorsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListMonitoredResourceDescriptorsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public Object extractNextToken(ListMonitoredResourceDescriptorsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<MonitoredResourceDescriptor> extractResources(
                ListMonitoredResourceDescriptorsResponse payload) {
              return payload.getResourceDescriptorsList();
            }
          };

  private static final PageStreamingDescriptor<
          ListMetricDescriptorsRequest, ListMetricDescriptorsResponse, MetricDescriptor>
      LIST_METRIC_DESCRIPTORS_PAGE_STR_DESC =
          new PageStreamingDescriptor<
              ListMetricDescriptorsRequest, ListMetricDescriptorsResponse, MetricDescriptor>() {
            @Override
            public Object emptyToken() {
              return "";
            }

            @Override
            public ListMetricDescriptorsRequest injectToken(
                ListMetricDescriptorsRequest payload, Object token) {
              return ListMetricDescriptorsRequest.newBuilder(payload)
                  .setPageToken((String) token)
                  .build();
            }

            @Override
            public ListMetricDescriptorsRequest injectPageSize(
                ListMetricDescriptorsRequest payload, int pageSize) {
              return ListMetricDescriptorsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListMetricDescriptorsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public Object extractNextToken(ListMetricDescriptorsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<MetricDescriptor> extractResources(
                ListMetricDescriptorsResponse payload) {
              return payload.getMetricDescriptorsList();
            }
          };

  private static final PageStreamingDescriptor<
          ListTimeSeriesRequest, ListTimeSeriesResponse, TimeSeries>
      LIST_TIME_SERIES_PAGE_STR_DESC =
          new PageStreamingDescriptor<ListTimeSeriesRequest, ListTimeSeriesResponse, TimeSeries>() {
            @Override
            public Object emptyToken() {
              return "";
            }

            @Override
            public ListTimeSeriesRequest injectToken(ListTimeSeriesRequest payload, Object token) {
              return ListTimeSeriesRequest.newBuilder(payload).setPageToken((String) token).build();
            }

            @Override
            public ListTimeSeriesRequest injectPageSize(
                ListTimeSeriesRequest payload, int pageSize) {
              return ListTimeSeriesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListTimeSeriesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public Object extractNextToken(ListTimeSeriesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<TimeSeries> extractResources(ListTimeSeriesResponse payload) {
              return payload.getTimeSeriesList();
            }
          };

  /**
   * Builder for MetricServiceSettings.
   */
  public static class Builder extends ServiceApiSettings.Builder {
    private final ImmutableList<ApiCallSettings.Builder> methodSettingsBuilders;

    private final PageStreamingCallSettings.Builder<
            ListMonitoredResourceDescriptorsRequest, ListMonitoredResourceDescriptorsResponse,
            MonitoredResourceDescriptor>
        listMonitoredResourceDescriptorsSettings;
    private final SimpleCallSettings.Builder<
            GetMonitoredResourceDescriptorRequest, MonitoredResourceDescriptor>
        getMonitoredResourceDescriptorSettings;
    private final PageStreamingCallSettings.Builder<
            ListMetricDescriptorsRequest, ListMetricDescriptorsResponse, MetricDescriptor>
        listMetricDescriptorsSettings;
    private final SimpleCallSettings.Builder<GetMetricDescriptorRequest, MetricDescriptor>
        getMetricDescriptorSettings;
    private final SimpleCallSettings.Builder<CreateMetricDescriptorRequest, MetricDescriptor>
        createMetricDescriptorSettings;
    private final SimpleCallSettings.Builder<DeleteMetricDescriptorRequest, Empty>
        deleteMetricDescriptorSettings;
    private final PageStreamingCallSettings.Builder<
            ListTimeSeriesRequest, ListTimeSeriesResponse, TimeSeries>
        listTimeSeriesSettings;
    private final SimpleCallSettings.Builder<CreateTimeSeriesRequest, Empty>
        createTimeSeriesSettings;

    private static final ImmutableMap<String, ImmutableSet<Status.Code>> RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<Status.Code>> definitions = ImmutableMap.builder();
      definitions.put(
          "idempotent",
          Sets.immutableEnumSet(
              Lists.<Status.Code>newArrayList(
                  Status.Code.DEADLINE_EXCEEDED, Status.Code.UNAVAILABLE)));
      definitions.put("non_idempotent", Sets.immutableEnumSet(Lists.<Status.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings.Builder> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings.Builder> definitions = ImmutableMap.builder();
      RetrySettings.Builder settingsBuilder = null;
      settingsBuilder =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.millis(100L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.millis(60000L))
              .setInitialRpcTimeout(Duration.millis(20000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.millis(20000L))
              .setTotalTimeout(Duration.millis(600000L));
      definitions.put("default", settingsBuilder);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    private Builder() {
      super(DEFAULT_CONNECTION_SETTINGS);

      listMonitoredResourceDescriptorsSettings =
          PageStreamingCallSettings.newBuilder(
              MetricServiceGrpc.METHOD_LIST_MONITORED_RESOURCE_DESCRIPTORS,
              LIST_MONITORED_RESOURCE_DESCRIPTORS_PAGE_STR_DESC);

      getMonitoredResourceDescriptorSettings =
          SimpleCallSettings.newBuilder(MetricServiceGrpc.METHOD_GET_MONITORED_RESOURCE_DESCRIPTOR);

      listMetricDescriptorsSettings =
          PageStreamingCallSettings.newBuilder(
              MetricServiceGrpc.METHOD_LIST_METRIC_DESCRIPTORS,
              LIST_METRIC_DESCRIPTORS_PAGE_STR_DESC);

      getMetricDescriptorSettings =
          SimpleCallSettings.newBuilder(MetricServiceGrpc.METHOD_GET_METRIC_DESCRIPTOR);

      createMetricDescriptorSettings =
          SimpleCallSettings.newBuilder(MetricServiceGrpc.METHOD_CREATE_METRIC_DESCRIPTOR);

      deleteMetricDescriptorSettings =
          SimpleCallSettings.newBuilder(MetricServiceGrpc.METHOD_DELETE_METRIC_DESCRIPTOR);

      listTimeSeriesSettings =
          PageStreamingCallSettings.newBuilder(
              MetricServiceGrpc.METHOD_LIST_TIME_SERIES, LIST_TIME_SERIES_PAGE_STR_DESC);

      createTimeSeriesSettings =
          SimpleCallSettings.newBuilder(MetricServiceGrpc.METHOD_CREATE_TIME_SERIES);

      methodSettingsBuilders =
          ImmutableList.<ApiCallSettings.Builder>of(
              listMonitoredResourceDescriptorsSettings,
              getMonitoredResourceDescriptorSettings,
              listMetricDescriptorsSettings,
              getMetricDescriptorSettings,
              createMetricDescriptorSettings,
              deleteMetricDescriptorSettings,
              listTimeSeriesSettings,
              createTimeSeriesSettings);
    }

    private static Builder createDefault() {
      Builder builder = new Builder();

      builder
          .listMonitoredResourceDescriptorsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettingsBuilder(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .getMonitoredResourceDescriptorSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettingsBuilder(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .listMetricDescriptorsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettingsBuilder(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .getMetricDescriptorSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettingsBuilder(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .createMetricDescriptorSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettingsBuilder(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .deleteMetricDescriptorSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettingsBuilder(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .listTimeSeriesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettingsBuilder(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .createTimeSeriesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettingsBuilder(RETRY_PARAM_DEFINITIONS.get("default"));

      return builder;
    }

    private Builder(MetricServiceSettings settings) {
      super(settings);

      listMonitoredResourceDescriptorsSettings =
          settings.listMonitoredResourceDescriptorsSettings.toBuilder();
      getMonitoredResourceDescriptorSettings =
          settings.getMonitoredResourceDescriptorSettings.toBuilder();
      listMetricDescriptorsSettings = settings.listMetricDescriptorsSettings.toBuilder();
      getMetricDescriptorSettings = settings.getMetricDescriptorSettings.toBuilder();
      createMetricDescriptorSettings = settings.createMetricDescriptorSettings.toBuilder();
      deleteMetricDescriptorSettings = settings.deleteMetricDescriptorSettings.toBuilder();
      listTimeSeriesSettings = settings.listTimeSeriesSettings.toBuilder();
      createTimeSeriesSettings = settings.createTimeSeriesSettings.toBuilder();

      methodSettingsBuilders =
          ImmutableList.<ApiCallSettings.Builder>of(
              listMonitoredResourceDescriptorsSettings,
              getMonitoredResourceDescriptorSettings,
              listMetricDescriptorsSettings,
              getMetricDescriptorSettings,
              createMetricDescriptorSettings,
              deleteMetricDescriptorSettings,
              listTimeSeriesSettings,
              createTimeSeriesSettings);
    }

    @Override
    protected ConnectionSettings getDefaultConnectionSettings() {
      return DEFAULT_CONNECTION_SETTINGS;
    }

    @Override
    public Builder provideExecutorWith(ScheduledExecutorService executor, boolean shouldAutoClose) {
      super.provideExecutorWith(executor, shouldAutoClose);
      return this;
    }

    @Override
    public Builder provideChannelWith(ManagedChannel channel, boolean shouldAutoClose) {
      super.provideChannelWith(channel, shouldAutoClose);
      return this;
    }

    @Override
    public Builder provideChannelWith(ConnectionSettings settings) {
      super.provideChannelWith(settings);
      return this;
    }

    @Override
    public Builder provideChannelWith(Credentials credentials) {
      super.provideChannelWith(credentials);
      return this;
    }

    @Override
    public Builder provideChannelWith(List<String> scopes) {
      super.provideChannelWith(scopes);
      return this;
    }

    @Override
    public Builder setGeneratorHeader(String name, String version) {
      super.setGeneratorHeader(name, version);
      return this;
    }

    @Override
    public Builder setClientLibHeader(String name, String version) {
      super.setClientLibHeader(name, version);
      return this;
    }

    /**
     * Applies the given settings to all of the API methods in this service. Only
     * values that are non-null will be applied, so this method is not capable
     * of un-setting any values.
     */
    public Builder applyToAllApiMethods(ApiCallSettings.Builder apiCallSettings) throws Exception {
      super.applyToAllApiMethods(methodSettingsBuilders, apiCallSettings);
      return this;
    }

    /**
     * Returns the builder for the settings used for calls to listMonitoredResourceDescriptors.
     */
    public PageStreamingCallSettings.Builder<
            ListMonitoredResourceDescriptorsRequest, ListMonitoredResourceDescriptorsResponse,
            MonitoredResourceDescriptor>
        listMonitoredResourceDescriptorsSettings() {
      return listMonitoredResourceDescriptorsSettings;
    }

    /**
     * Returns the builder for the settings used for calls to getMonitoredResourceDescriptor.
     */
    public SimpleCallSettings.Builder<
            GetMonitoredResourceDescriptorRequest, MonitoredResourceDescriptor>
        getMonitoredResourceDescriptorSettings() {
      return getMonitoredResourceDescriptorSettings;
    }

    /**
     * Returns the builder for the settings used for calls to listMetricDescriptors.
     */
    public PageStreamingCallSettings.Builder<
            ListMetricDescriptorsRequest, ListMetricDescriptorsResponse, MetricDescriptor>
        listMetricDescriptorsSettings() {
      return listMetricDescriptorsSettings;
    }

    /**
     * Returns the builder for the settings used for calls to getMetricDescriptor.
     */
    public SimpleCallSettings.Builder<GetMetricDescriptorRequest, MetricDescriptor>
        getMetricDescriptorSettings() {
      return getMetricDescriptorSettings;
    }

    /**
     * Returns the builder for the settings used for calls to createMetricDescriptor.
     */
    public SimpleCallSettings.Builder<CreateMetricDescriptorRequest, MetricDescriptor>
        createMetricDescriptorSettings() {
      return createMetricDescriptorSettings;
    }

    /**
     * Returns the builder for the settings used for calls to deleteMetricDescriptor.
     */
    public SimpleCallSettings.Builder<DeleteMetricDescriptorRequest, Empty>
        deleteMetricDescriptorSettings() {
      return deleteMetricDescriptorSettings;
    }

    /**
     * Returns the builder for the settings used for calls to listTimeSeries.
     */
    public PageStreamingCallSettings.Builder<
            ListTimeSeriesRequest, ListTimeSeriesResponse, TimeSeries>
        listTimeSeriesSettings() {
      return listTimeSeriesSettings;
    }

    /**
     * Returns the builder for the settings used for calls to createTimeSeries.
     */
    public SimpleCallSettings.Builder<CreateTimeSeriesRequest, Empty> createTimeSeriesSettings() {
      return createTimeSeriesSettings;
    }

    @Override
    public MetricServiceSettings build() throws IOException {
      return new MetricServiceSettings(this);
    }
  }
}
