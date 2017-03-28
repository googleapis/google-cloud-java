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
package com.google.cloud.logging.spi.v2;

import static com.google.cloud.logging.spi.v2.PagedResponseWrappers.ListLogMetricsPagedResponse;

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
import com.google.logging.v2.CreateLogMetricRequest;
import com.google.logging.v2.DeleteLogMetricRequest;
import com.google.logging.v2.GetLogMetricRequest;
import com.google.logging.v2.ListLogMetricsRequest;
import com.google.logging.v2.ListLogMetricsResponse;
import com.google.logging.v2.LogMetric;
import com.google.logging.v2.MetricsServiceV2Grpc;
import com.google.logging.v2.UpdateLogMetricRequest;
import com.google.protobuf.Empty;
import com.google.protobuf.ExperimentalApi;
import io.grpc.Status;
import java.io.IOException;
import javax.annotation.Generated;
import org.joda.time.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS
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
 * build() is called, the tree of builders is called to create the complete settings object. For
 * example, to set the total timeout of getLogMetric to 30 seconds:
 *
 * <pre>
 * <code>
 * MetricsSettings.Builder metricsSettingsBuilder =
 *     MetricsSettings.defaultBuilder();
 * metricsSettingsBuilder.getLogMetricSettings().getRetrySettingsBuilder()
 *     .setTotalTimeout(Duration.standardSeconds(30));
 * MetricsSettings metricsSettings = metricsSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by GAPIC v0.0.5")
@ExperimentalApi
public class MetricsSettings extends ClientSettings {
  /** The default address of the service. */
  private static final String DEFAULT_SERVICE_ADDRESS = "logging.googleapis.com";

  /** The default port of the service. */
  private static final int DEFAULT_SERVICE_PORT = 443;

  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/cloud-platform")
          .add("https://www.googleapis.com/auth/cloud-platform.read-only")
          .add("https://www.googleapis.com/auth/logging.admin")
          .add("https://www.googleapis.com/auth/logging.read")
          .add("https://www.googleapis.com/auth/logging.write")
          .build();

  private static final String DEFAULT_GAPIC_NAME = "gapic";
  private static final String DEFAULT_GAPIC_VERSION = "";

  private static final String PROPERTIES_FILE = "/project.properties";
  private static final String META_VERSION_KEY = "artifact.version";

  private static String gapicVersion;

  private final PagedCallSettings<
          ListLogMetricsRequest, ListLogMetricsResponse, ListLogMetricsPagedResponse>
      listLogMetricsSettings;
  private final SimpleCallSettings<GetLogMetricRequest, LogMetric> getLogMetricSettings;
  private final SimpleCallSettings<CreateLogMetricRequest, LogMetric> createLogMetricSettings;
  private final SimpleCallSettings<UpdateLogMetricRequest, LogMetric> updateLogMetricSettings;
  private final SimpleCallSettings<DeleteLogMetricRequest, Empty> deleteLogMetricSettings;

  /** Returns the object with the settings used for calls to listLogMetrics. */
  public PagedCallSettings<
          ListLogMetricsRequest, ListLogMetricsResponse, ListLogMetricsPagedResponse>
      listLogMetricsSettings() {
    return listLogMetricsSettings;
  }

  /** Returns the object with the settings used for calls to getLogMetric. */
  public SimpleCallSettings<GetLogMetricRequest, LogMetric> getLogMetricSettings() {
    return getLogMetricSettings;
  }

  /** Returns the object with the settings used for calls to createLogMetric. */
  public SimpleCallSettings<CreateLogMetricRequest, LogMetric> createLogMetricSettings() {
    return createLogMetricSettings;
  }

  /** Returns the object with the settings used for calls to updateLogMetric. */
  public SimpleCallSettings<UpdateLogMetricRequest, LogMetric> updateLogMetricSettings() {
    return updateLogMetricSettings;
  }

  /** Returns the object with the settings used for calls to deleteLogMetric. */
  public SimpleCallSettings<DeleteLogMetricRequest, Empty> deleteLogMetricSettings() {
    return deleteLogMetricSettings;
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
          PropertiesProvider.loadProperty(MetricsSettings.class, PROPERTIES_FILE, META_VERSION_KEY);
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

  private MetricsSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder.getExecutorProvider(), settingsBuilder.getChannelProvider());

    listLogMetricsSettings = settingsBuilder.listLogMetricsSettings().build();
    getLogMetricSettings = settingsBuilder.getLogMetricSettings().build();
    createLogMetricSettings = settingsBuilder.createLogMetricSettings().build();
    updateLogMetricSettings = settingsBuilder.updateLogMetricSettings().build();
    deleteLogMetricSettings = settingsBuilder.deleteLogMetricSettings().build();
  }

  private static final PagedListDescriptor<ListLogMetricsRequest, ListLogMetricsResponse, LogMetric>
      LIST_LOG_METRICS_PAGE_STR_DESC =
          new PagedListDescriptor<ListLogMetricsRequest, ListLogMetricsResponse, LogMetric>() {
            @Override
            public Object emptyToken() {
              return "";
            }

            @Override
            public ListLogMetricsRequest injectToken(ListLogMetricsRequest payload, Object token) {
              return ListLogMetricsRequest.newBuilder(payload).setPageToken((String) token).build();
            }

            @Override
            public ListLogMetricsRequest injectPageSize(
                ListLogMetricsRequest payload, int pageSize) {
              return ListLogMetricsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListLogMetricsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public Object extractNextToken(ListLogMetricsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<LogMetric> extractResources(ListLogMetricsResponse payload) {
              return payload.getMetricsList();
            }
          };

  private static final PagedListResponseFactory<
          ListLogMetricsRequest, ListLogMetricsResponse, ListLogMetricsPagedResponse>
      LIST_LOG_METRICS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListLogMetricsRequest, ListLogMetricsResponse, ListLogMetricsPagedResponse>() {
            @Override
            public ListLogMetricsPagedResponse createPagedListResponse(
                UnaryCallable<ListLogMetricsRequest, ListLogMetricsResponse> callable,
                ListLogMetricsRequest request,
                CallContext context) {
              return new ListLogMetricsPagedResponse(
                  callable, LIST_LOG_METRICS_PAGE_STR_DESC, request, context);
            }
          };

  /** Builder for MetricsSettings. */
  public static class Builder extends ClientSettings.Builder {
    private final ImmutableList<UnaryCallSettings.Builder> unaryMethodSettingsBuilders;

    private final PagedCallSettings.Builder<
            ListLogMetricsRequest, ListLogMetricsResponse, ListLogMetricsPagedResponse>
        listLogMetricsSettings;
    private final SimpleCallSettings.Builder<GetLogMetricRequest, LogMetric> getLogMetricSettings;
    private final SimpleCallSettings.Builder<CreateLogMetricRequest, LogMetric>
        createLogMetricSettings;
    private final SimpleCallSettings.Builder<UpdateLogMetricRequest, LogMetric>
        updateLogMetricSettings;
    private final SimpleCallSettings.Builder<DeleteLogMetricRequest, Empty> deleteLogMetricSettings;

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
              .setRetryDelayMultiplier(1.2)
              .setMaxRetryDelay(Duration.millis(1000L))
              .setInitialRpcTimeout(Duration.millis(2000L))
              .setRpcTimeoutMultiplier(1.5)
              .setMaxRpcTimeout(Duration.millis(30000L))
              .setTotalTimeout(Duration.millis(45000L));
      definitions.put("default", settingsBuilder);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    private Builder() {
      super(defaultChannelProviderBuilder().build());

      listLogMetricsSettings =
          PagedCallSettings.newBuilder(
              MetricsServiceV2Grpc.METHOD_LIST_LOG_METRICS, LIST_LOG_METRICS_PAGE_STR_FACT);

      getLogMetricSettings =
          SimpleCallSettings.newBuilder(MetricsServiceV2Grpc.METHOD_GET_LOG_METRIC);

      createLogMetricSettings =
          SimpleCallSettings.newBuilder(MetricsServiceV2Grpc.METHOD_CREATE_LOG_METRIC);

      updateLogMetricSettings =
          SimpleCallSettings.newBuilder(MetricsServiceV2Grpc.METHOD_UPDATE_LOG_METRIC);

      deleteLogMetricSettings =
          SimpleCallSettings.newBuilder(MetricsServiceV2Grpc.METHOD_DELETE_LOG_METRIC);

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder>of(
              listLogMetricsSettings,
              getLogMetricSettings,
              createLogMetricSettings,
              updateLogMetricSettings,
              deleteLogMetricSettings);
    }

    private static Builder createDefault() {
      Builder builder = new Builder();

      builder
          .listLogMetricsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettingsBuilder(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .getLogMetricSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettingsBuilder(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .createLogMetricSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettingsBuilder(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .updateLogMetricSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettingsBuilder(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .deleteLogMetricSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettingsBuilder(RETRY_PARAM_DEFINITIONS.get("default"));

      return builder;
    }

    private Builder(MetricsSettings settings) {
      super(settings);

      listLogMetricsSettings = settings.listLogMetricsSettings.toBuilder();
      getLogMetricSettings = settings.getLogMetricSettings.toBuilder();
      createLogMetricSettings = settings.createLogMetricSettings.toBuilder();
      updateLogMetricSettings = settings.updateLogMetricSettings.toBuilder();
      deleteLogMetricSettings = settings.deleteLogMetricSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder>of(
              listLogMetricsSettings,
              getLogMetricSettings,
              createLogMetricSettings,
              updateLogMetricSettings,
              deleteLogMetricSettings);
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

    /** Returns the builder for the settings used for calls to listLogMetrics. */
    public PagedCallSettings.Builder<
            ListLogMetricsRequest, ListLogMetricsResponse, ListLogMetricsPagedResponse>
        listLogMetricsSettings() {
      return listLogMetricsSettings;
    }

    /** Returns the builder for the settings used for calls to getLogMetric. */
    public SimpleCallSettings.Builder<GetLogMetricRequest, LogMetric> getLogMetricSettings() {
      return getLogMetricSettings;
    }

    /** Returns the builder for the settings used for calls to createLogMetric. */
    public SimpleCallSettings.Builder<CreateLogMetricRequest, LogMetric> createLogMetricSettings() {
      return createLogMetricSettings;
    }

    /** Returns the builder for the settings used for calls to updateLogMetric. */
    public SimpleCallSettings.Builder<UpdateLogMetricRequest, LogMetric> updateLogMetricSettings() {
      return updateLogMetricSettings;
    }

    /** Returns the builder for the settings used for calls to deleteLogMetric. */
    public SimpleCallSettings.Builder<DeleteLogMetricRequest, Empty> deleteLogMetricSettings() {
      return deleteLogMetricSettings;
    }

    @Override
    public MetricsSettings build() throws IOException {
      return new MetricsSettings(this);
    }
  }
}
