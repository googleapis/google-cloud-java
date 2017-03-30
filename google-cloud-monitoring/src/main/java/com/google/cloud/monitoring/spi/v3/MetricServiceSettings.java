/*
 * Copyright 2017, Google Inc. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.monitoring.spi.v3;

import static com.google.cloud.monitoring.spi.v3.PagedResponseWrappers.ListMetricDescriptorsPagedResponse;
import static com.google.cloud.monitoring.spi.v3.PagedResponseWrappers.ListMonitoredResourceDescriptorsPagedResponse;
import static com.google.cloud.monitoring.spi.v3.PagedResponseWrappers.ListTimeSeriesPagedResponse;

import com.google.api.MetricDescriptor;
import com.google.api.MonitoredResourceDescriptor;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.PropertiesProvider;
import com.google.api.gax.core.RetrySettings;
import com.google.api.gax.grpc.CallContext;
import com.google.api.gax.grpc.ChannelProvider;
import com.google.api.gax.grpc.ClientSettings;
import com.google.api.gax.grpc.ExecutorProvider;
import com.google.api.gax.grpc.InstantiatingChannelProvider;
import com.google.api.gax.grpc.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.PagedCallSettings;
import com.google.api.gax.grpc.PagedListDescriptor;
import com.google.api.gax.grpc.PagedListResponseFactory;
import com.google.api.gax.grpc.SimpleCallSettings;
import com.google.api.gax.grpc.UnaryCallSettings;
import com.google.api.gax.grpc.UnaryCallable;
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
import com.google.protobuf.ExperimentalApi;
import io.grpc.Status;
import java.io.IOException;
import javax.annotation.Generated;
import org.joda.time.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS
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
 * build() is called, the tree of builders is called to create the complete settings object. For
 * example, to set the total timeout of getMonitoredResourceDescriptor to 30 seconds:
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
@Generated("by GAPIC v0.0.5")
@ExperimentalApi
public class MetricServiceSettings extends ClientSettings {
  /** The default address of the service. */
  private static final String DEFAULT_SERVICE_ADDRESS = "monitoring.googleapis.com";

  /** The default port of the service. */
  private static final int DEFAULT_SERVICE_PORT = 443;

  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/cloud-platform")
          .add("https://www.googleapis.com/auth/monitoring")
          .add("https://www.googleapis.com/auth/monitoring.read")
          .add("https://www.googleapis.com/auth/monitoring.write")
          .build();

  private static final String DEFAULT_GAPIC_NAME = "gapic";
  private static final String DEFAULT_GAPIC_VERSION = "";

  private static final String PROPERTIES_FILE = "/project.properties";
  private static final String META_VERSION_KEY = "artifact.version";

  private static String gapicVersion;

  private final PagedCallSettings<
          ListMonitoredResourceDescriptorsRequest, ListMonitoredResourceDescriptorsResponse,
          ListMonitoredResourceDescriptorsPagedResponse>
      listMonitoredResourceDescriptorsSettings;
  private final SimpleCallSettings<
          GetMonitoredResourceDescriptorRequest, MonitoredResourceDescriptor>
      getMonitoredResourceDescriptorSettings;
  private final PagedCallSettings<
          ListMetricDescriptorsRequest, ListMetricDescriptorsResponse,
          ListMetricDescriptorsPagedResponse>
      listMetricDescriptorsSettings;
  private final SimpleCallSettings<GetMetricDescriptorRequest, MetricDescriptor>
      getMetricDescriptorSettings;
  private final SimpleCallSettings<CreateMetricDescriptorRequest, MetricDescriptor>
      createMetricDescriptorSettings;
  private final SimpleCallSettings<DeleteMetricDescriptorRequest, Empty>
      deleteMetricDescriptorSettings;
  private final PagedCallSettings<
          ListTimeSeriesRequest, ListTimeSeriesResponse, ListTimeSeriesPagedResponse>
      listTimeSeriesSettings;
  private final SimpleCallSettings<CreateTimeSeriesRequest, Empty> createTimeSeriesSettings;

  /** Returns the object with the settings used for calls to listMonitoredResourceDescriptors. */
  public PagedCallSettings<
          ListMonitoredResourceDescriptorsRequest, ListMonitoredResourceDescriptorsResponse,
          ListMonitoredResourceDescriptorsPagedResponse>
      listMonitoredResourceDescriptorsSettings() {
    return listMonitoredResourceDescriptorsSettings;
  }

  /** Returns the object with the settings used for calls to getMonitoredResourceDescriptor. */
  public SimpleCallSettings<GetMonitoredResourceDescriptorRequest, MonitoredResourceDescriptor>
      getMonitoredResourceDescriptorSettings() {
    return getMonitoredResourceDescriptorSettings;
  }

  /** Returns the object with the settings used for calls to listMetricDescriptors. */
  public PagedCallSettings<
          ListMetricDescriptorsRequest, ListMetricDescriptorsResponse,
          ListMetricDescriptorsPagedResponse>
      listMetricDescriptorsSettings() {
    return listMetricDescriptorsSettings;
  }

  /** Returns the object with the settings used for calls to getMetricDescriptor. */
  public SimpleCallSettings<GetMetricDescriptorRequest, MetricDescriptor>
      getMetricDescriptorSettings() {
    return getMetricDescriptorSettings;
  }

  /** Returns the object with the settings used for calls to createMetricDescriptor. */
  public SimpleCallSettings<CreateMetricDescriptorRequest, MetricDescriptor>
      createMetricDescriptorSettings() {
    return createMetricDescriptorSettings;
  }

  /** Returns the object with the settings used for calls to deleteMetricDescriptor. */
  public SimpleCallSettings<DeleteMetricDescriptorRequest, Empty> deleteMetricDescriptorSettings() {
    return deleteMetricDescriptorSettings;
  }

  /** Returns the object with the settings used for calls to listTimeSeries. */
  public PagedCallSettings<
          ListTimeSeriesRequest, ListTimeSeriesResponse, ListTimeSeriesPagedResponse>
      listTimeSeriesSettings() {
    return listTimeSeriesSettings;
  }

  /** Returns the object with the settings used for calls to createTimeSeries. */
  public SimpleCallSettings<CreateTimeSeriesRequest, Empty> createTimeSeriesSettings() {
    return createTimeSeriesSettings;
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service address. */
  public static String getDefaultServiceAddress() {
    return DEFAULT_SERVICE_ADDRESS;
  }

  /** Returns the default service port. */
  public static int getDefaultServicePort() {
    return DEFAULT_SERVICE_PORT;
  }

  /** Returns the default service scopes. */
  public static ImmutableList<String> getDefaultServiceScopes() {
    return DEFAULT_SERVICE_SCOPES;
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return GoogleCredentialsProvider.newBuilder().setScopesToApply(DEFAULT_SERVICE_SCOPES);
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingChannelProvider.Builder defaultChannelProviderBuilder() {
    return InstantiatingChannelProvider.newBuilder()
        .setServiceAddress(DEFAULT_SERVICE_ADDRESS)
        .setPort(DEFAULT_SERVICE_PORT)
        .setGeneratorHeader(DEFAULT_GAPIC_NAME, getGapicVersion())
        .setCredentialsProvider(defaultCredentialsProviderBuilder().build());
  }

  private static String getGapicVersion() {
    if (gapicVersion == null) {
      gapicVersion =
          PropertiesProvider.loadProperty(
              MetricServiceSettings.class, PROPERTIES_FILE, META_VERSION_KEY);
      gapicVersion = gapicVersion == null ? DEFAULT_GAPIC_VERSION : gapicVersion;
    }
    return gapicVersion;
  }

  /** Returns a builder for this class with recommended defaults. */
  public static Builder defaultBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder() {
    return new Builder();
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  private MetricServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder.getExecutorProvider(), settingsBuilder.getChannelProvider());

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

  private static final PagedListDescriptor<
          ListMonitoredResourceDescriptorsRequest, ListMonitoredResourceDescriptorsResponse,
          MonitoredResourceDescriptor>
      LIST_MONITORED_RESOURCE_DESCRIPTORS_PAGE_STR_DESC =
          new PagedListDescriptor<
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

  private static final PagedListDescriptor<
          ListMetricDescriptorsRequest, ListMetricDescriptorsResponse, MetricDescriptor>
      LIST_METRIC_DESCRIPTORS_PAGE_STR_DESC =
          new PagedListDescriptor<
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

  private static final PagedListDescriptor<
          ListTimeSeriesRequest, ListTimeSeriesResponse, TimeSeries>
      LIST_TIME_SERIES_PAGE_STR_DESC =
          new PagedListDescriptor<ListTimeSeriesRequest, ListTimeSeriesResponse, TimeSeries>() {
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

  private static final PagedListResponseFactory<
          ListMonitoredResourceDescriptorsRequest, ListMonitoredResourceDescriptorsResponse,
          ListMonitoredResourceDescriptorsPagedResponse>
      LIST_MONITORED_RESOURCE_DESCRIPTORS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListMonitoredResourceDescriptorsRequest, ListMonitoredResourceDescriptorsResponse,
              ListMonitoredResourceDescriptorsPagedResponse>() {
            @Override
            public ListMonitoredResourceDescriptorsPagedResponse createPagedListResponse(
                UnaryCallable<
                        ListMonitoredResourceDescriptorsRequest,
                        ListMonitoredResourceDescriptorsResponse>
                    callable,
                ListMonitoredResourceDescriptorsRequest request,
                CallContext context) {
              return new ListMonitoredResourceDescriptorsPagedResponse(
                  callable, LIST_MONITORED_RESOURCE_DESCRIPTORS_PAGE_STR_DESC, request, context);
            }
          };

  private static final PagedListResponseFactory<
          ListMetricDescriptorsRequest, ListMetricDescriptorsResponse,
          ListMetricDescriptorsPagedResponse>
      LIST_METRIC_DESCRIPTORS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListMetricDescriptorsRequest, ListMetricDescriptorsResponse,
              ListMetricDescriptorsPagedResponse>() {
            @Override
            public ListMetricDescriptorsPagedResponse createPagedListResponse(
                UnaryCallable<ListMetricDescriptorsRequest, ListMetricDescriptorsResponse> callable,
                ListMetricDescriptorsRequest request,
                CallContext context) {
              return new ListMetricDescriptorsPagedResponse(
                  callable, LIST_METRIC_DESCRIPTORS_PAGE_STR_DESC, request, context);
            }
          };

  private static final PagedListResponseFactory<
          ListTimeSeriesRequest, ListTimeSeriesResponse, ListTimeSeriesPagedResponse>
      LIST_TIME_SERIES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListTimeSeriesRequest, ListTimeSeriesResponse, ListTimeSeriesPagedResponse>() {
            @Override
            public ListTimeSeriesPagedResponse createPagedListResponse(
                UnaryCallable<ListTimeSeriesRequest, ListTimeSeriesResponse> callable,
                ListTimeSeriesRequest request,
                CallContext context) {
              return new ListTimeSeriesPagedResponse(
                  callable, LIST_TIME_SERIES_PAGE_STR_DESC, request, context);
            }
          };

  /** Builder for MetricServiceSettings. */
  public static class Builder extends ClientSettings.Builder {
    private final ImmutableList<UnaryCallSettings.Builder> unaryMethodSettingsBuilders;

    private final PagedCallSettings.Builder<
            ListMonitoredResourceDescriptorsRequest, ListMonitoredResourceDescriptorsResponse,
            ListMonitoredResourceDescriptorsPagedResponse>
        listMonitoredResourceDescriptorsSettings;
    private final SimpleCallSettings.Builder<
            GetMonitoredResourceDescriptorRequest, MonitoredResourceDescriptor>
        getMonitoredResourceDescriptorSettings;
    private final PagedCallSettings.Builder<
            ListMetricDescriptorsRequest, ListMetricDescriptorsResponse,
            ListMetricDescriptorsPagedResponse>
        listMetricDescriptorsSettings;
    private final SimpleCallSettings.Builder<GetMetricDescriptorRequest, MetricDescriptor>
        getMetricDescriptorSettings;
    private final SimpleCallSettings.Builder<CreateMetricDescriptorRequest, MetricDescriptor>
        createMetricDescriptorSettings;
    private final SimpleCallSettings.Builder<DeleteMetricDescriptorRequest, Empty>
        deleteMetricDescriptorSettings;
    private final PagedCallSettings.Builder<
            ListTimeSeriesRequest, ListTimeSeriesResponse, ListTimeSeriesPagedResponse>
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
      definitions.put(
          "non_idempotent",
          Sets.immutableEnumSet(Lists.<Status.Code>newArrayList(Status.Code.UNAVAILABLE)));
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
      super(defaultChannelProviderBuilder().build());

      listMonitoredResourceDescriptorsSettings =
          PagedCallSettings.newBuilder(
              MetricServiceGrpc.METHOD_LIST_MONITORED_RESOURCE_DESCRIPTORS,
              LIST_MONITORED_RESOURCE_DESCRIPTORS_PAGE_STR_FACT);

      getMonitoredResourceDescriptorSettings =
          SimpleCallSettings.newBuilder(MetricServiceGrpc.METHOD_GET_MONITORED_RESOURCE_DESCRIPTOR);

      listMetricDescriptorsSettings =
          PagedCallSettings.newBuilder(
              MetricServiceGrpc.METHOD_LIST_METRIC_DESCRIPTORS,
              LIST_METRIC_DESCRIPTORS_PAGE_STR_FACT);

      getMetricDescriptorSettings =
          SimpleCallSettings.newBuilder(MetricServiceGrpc.METHOD_GET_METRIC_DESCRIPTOR);

      createMetricDescriptorSettings =
          SimpleCallSettings.newBuilder(MetricServiceGrpc.METHOD_CREATE_METRIC_DESCRIPTOR);

      deleteMetricDescriptorSettings =
          SimpleCallSettings.newBuilder(MetricServiceGrpc.METHOD_DELETE_METRIC_DESCRIPTOR);

      listTimeSeriesSettings =
          PagedCallSettings.newBuilder(
              MetricServiceGrpc.METHOD_LIST_TIME_SERIES, LIST_TIME_SERIES_PAGE_STR_FACT);

      createTimeSeriesSettings =
          SimpleCallSettings.newBuilder(MetricServiceGrpc.METHOD_CREATE_TIME_SERIES);

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder>of(
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

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder>of(
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
    public Builder setExecutorProvider(ExecutorProvider executorProvider) {
      super.setExecutorProvider(executorProvider);
      return this;
    }

    @Override
    public Builder setChannelProvider(ChannelProvider channelProvider) {
      super.setChannelProvider(channelProvider);
      return this;
    }

    /**
     * Applies the given settings to all of the unary API methods in this service. Only values that
     * are non-null will be applied, so this method is not capable of un-setting any values.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(UnaryCallSettings.Builder unaryCallSettings)
        throws Exception {
      super.applyToAllUnaryMethods(unaryMethodSettingsBuilders, unaryCallSettings);
      return this;
    }

    /** Returns the builder for the settings used for calls to listMonitoredResourceDescriptors. */
    public PagedCallSettings.Builder<
            ListMonitoredResourceDescriptorsRequest, ListMonitoredResourceDescriptorsResponse,
            ListMonitoredResourceDescriptorsPagedResponse>
        listMonitoredResourceDescriptorsSettings() {
      return listMonitoredResourceDescriptorsSettings;
    }

    /** Returns the builder for the settings used for calls to getMonitoredResourceDescriptor. */
    public SimpleCallSettings.Builder<
            GetMonitoredResourceDescriptorRequest, MonitoredResourceDescriptor>
        getMonitoredResourceDescriptorSettings() {
      return getMonitoredResourceDescriptorSettings;
    }

    /** Returns the builder for the settings used for calls to listMetricDescriptors. */
    public PagedCallSettings.Builder<
            ListMetricDescriptorsRequest, ListMetricDescriptorsResponse,
            ListMetricDescriptorsPagedResponse>
        listMetricDescriptorsSettings() {
      return listMetricDescriptorsSettings;
    }

    /** Returns the builder for the settings used for calls to getMetricDescriptor. */
    public SimpleCallSettings.Builder<GetMetricDescriptorRequest, MetricDescriptor>
        getMetricDescriptorSettings() {
      return getMetricDescriptorSettings;
    }

    /** Returns the builder for the settings used for calls to createMetricDescriptor. */
    public SimpleCallSettings.Builder<CreateMetricDescriptorRequest, MetricDescriptor>
        createMetricDescriptorSettings() {
      return createMetricDescriptorSettings;
    }

    /** Returns the builder for the settings used for calls to deleteMetricDescriptor. */
    public SimpleCallSettings.Builder<DeleteMetricDescriptorRequest, Empty>
        deleteMetricDescriptorSettings() {
      return deleteMetricDescriptorSettings;
    }

    /** Returns the builder for the settings used for calls to listTimeSeries. */
    public PagedCallSettings.Builder<
            ListTimeSeriesRequest, ListTimeSeriesResponse, ListTimeSeriesPagedResponse>
        listTimeSeriesSettings() {
      return listTimeSeriesSettings;
    }

    /** Returns the builder for the settings used for calls to createTimeSeries. */
    public SimpleCallSettings.Builder<CreateTimeSeriesRequest, Empty> createTimeSeriesSettings() {
      return createTimeSeriesSettings;
    }

    @Override
    public MetricServiceSettings build() throws IOException {
      return new MetricServiceSettings(this);
    }
  }
}
