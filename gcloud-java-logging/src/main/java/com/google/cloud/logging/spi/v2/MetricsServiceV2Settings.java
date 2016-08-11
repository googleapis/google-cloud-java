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
package com.google.cloud.logging.spi.v2;

import com.google.api.gax.core.ConnectionSettings;
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
import com.google.logging.v2.CreateLogMetricRequest;
import com.google.logging.v2.DeleteLogMetricRequest;
import com.google.logging.v2.GetLogMetricRequest;
import com.google.logging.v2.ListLogMetricsRequest;
import com.google.logging.v2.ListLogMetricsResponse;
import com.google.logging.v2.LogMetric;
import com.google.logging.v2.MetricsServiceV2Grpc;
import com.google.logging.v2.UpdateLogMetricRequest;
import com.google.protobuf.Empty;
import io.grpc.ManagedChannel;
import io.grpc.Status;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import org.joda.time.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Settings class to configure an instance of {@link MetricsServiceV2Api}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 * <li>The default service address (logging.googleapis.com) and default port (443)
 * are used.
 * <li>Credentials are acquired automatically through Application Default Credentials.
 * <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders.
 * When build() is called, the tree of builders is called to create the complete settings
 * object. For example, to set the total timeout of getLogMetric to 30 seconds:
 *
 * <pre>
 * <code>
 * MetricsServiceV2Settings.Builder metricsServiceV2SettingsBuilder =
 *     MetricsServiceV2Settings.defaultBuilder();
 * metricsServiceV2SettingsBuilder.getLogMetricSettings().getRetrySettingsBuilder()
 *     .setTotalTimeout(Duration.standardSeconds(30));
 * MetricsServiceV2Settings metricsServiceV2Settings = metricsServiceV2SettingsBuilder.build();
 * </code>
 * </pre>
 */
@javax.annotation.Generated("by GAPIC")
public class MetricsServiceV2Settings extends ServiceApiSettings {
  /**
   * The default address of the service.
   */
  private static final String DEFAULT_SERVICE_ADDRESS = "logging.googleapis.com";

  /**
   * The default port of the service.
   */
  private static final int DEFAULT_SERVICE_PORT = 443;

  /**
   * The default scopes of the service.
   */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/cloud-platform")
          .add("https://www.googleapis.com/auth/cloud-platform.read-only")
          .add("https://www.googleapis.com/auth/logging.admin")
          .add("https://www.googleapis.com/auth/logging.read")
          .add("https://www.googleapis.com/auth/logging.write")
          .build();

  /**
   * The default connection settings of the service.
   */
  public static final ConnectionSettings DEFAULT_CONNECTION_SETTINGS =
      ConnectionSettings.newBuilder()
          .setServiceAddress(DEFAULT_SERVICE_ADDRESS)
          .setPort(DEFAULT_SERVICE_PORT)
          .provideCredentialsWith(DEFAULT_SERVICE_SCOPES)
          .build();

  private final PageStreamingCallSettings<ListLogMetricsRequest, ListLogMetricsResponse, LogMetric>
      listLogMetricsSettings;
  private final SimpleCallSettings<GetLogMetricRequest, LogMetric> getLogMetricSettings;
  private final SimpleCallSettings<CreateLogMetricRequest, LogMetric> createLogMetricSettings;
  private final SimpleCallSettings<UpdateLogMetricRequest, LogMetric> updateLogMetricSettings;
  private final SimpleCallSettings<DeleteLogMetricRequest, Empty> deleteLogMetricSettings;

  /**
   * Returns the object with the settings used for calls to listLogMetrics.
   */
  public PageStreamingCallSettings<ListLogMetricsRequest, ListLogMetricsResponse, LogMetric>
      listLogMetricsSettings() {
    return listLogMetricsSettings;
  }

  /**
   * Returns the object with the settings used for calls to getLogMetric.
   */
  public SimpleCallSettings<GetLogMetricRequest, LogMetric> getLogMetricSettings() {
    return getLogMetricSettings;
  }

  /**
   * Returns the object with the settings used for calls to createLogMetric.
   */
  public SimpleCallSettings<CreateLogMetricRequest, LogMetric> createLogMetricSettings() {
    return createLogMetricSettings;
  }

  /**
   * Returns the object with the settings used for calls to updateLogMetric.
   */
  public SimpleCallSettings<UpdateLogMetricRequest, LogMetric> updateLogMetricSettings() {
    return updateLogMetricSettings;
  }

  /**
   * Returns the object with the settings used for calls to deleteLogMetric.
   */
  public SimpleCallSettings<DeleteLogMetricRequest, Empty> deleteLogMetricSettings() {
    return deleteLogMetricSettings;
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

  private MetricsServiceV2Settings(Builder settingsBuilder) throws IOException {
    super(
        settingsBuilder.getChannelProvider(),
        settingsBuilder.getExecutorProvider(),
        settingsBuilder.getGeneratorName(),
        settingsBuilder.getGeneratorVersion(),
        settingsBuilder.getClientLibName(),
        settingsBuilder.getClientLibVersion());

    listLogMetricsSettings = settingsBuilder.listLogMetricsSettings().build();
    getLogMetricSettings = settingsBuilder.getLogMetricSettings().build();
    createLogMetricSettings = settingsBuilder.createLogMetricSettings().build();
    updateLogMetricSettings = settingsBuilder.updateLogMetricSettings().build();
    deleteLogMetricSettings = settingsBuilder.deleteLogMetricSettings().build();
  }

  private static PageStreamingDescriptor<ListLogMetricsRequest, ListLogMetricsResponse, LogMetric>
      LIST_LOG_METRICS_PAGE_STR_DESC =
          new PageStreamingDescriptor<ListLogMetricsRequest, ListLogMetricsResponse, LogMetric>() {
            @Override
            public Object emptyToken() {
              return "";
            }

            @Override
            public ListLogMetricsRequest injectToken(ListLogMetricsRequest payload, Object token) {
              return ListLogMetricsRequest.newBuilder(payload).setPageToken((String) token).build();
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

  /**
   * Builder for MetricsServiceV2Settings.
   */
  public static class Builder extends ServiceApiSettings.Builder {
    private final ImmutableList<ApiCallSettings.Builder> methodSettingsBuilders;

    private PageStreamingCallSettings.Builder<
            ListLogMetricsRequest, ListLogMetricsResponse, LogMetric>
        listLogMetricsSettings;
    private SimpleCallSettings.Builder<GetLogMetricRequest, LogMetric> getLogMetricSettings;
    private SimpleCallSettings.Builder<CreateLogMetricRequest, LogMetric> createLogMetricSettings;
    private SimpleCallSettings.Builder<UpdateLogMetricRequest, LogMetric> updateLogMetricSettings;
    private SimpleCallSettings.Builder<DeleteLogMetricRequest, Empty> deleteLogMetricSettings;

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
      super(DEFAULT_CONNECTION_SETTINGS);

      listLogMetricsSettings =
          PageStreamingCallSettings.newBuilder(
              MetricsServiceV2Grpc.METHOD_LIST_LOG_METRICS, LIST_LOG_METRICS_PAGE_STR_DESC);

      getLogMetricSettings =
          SimpleCallSettings.newBuilder(MetricsServiceV2Grpc.METHOD_GET_LOG_METRIC);

      createLogMetricSettings =
          SimpleCallSettings.newBuilder(MetricsServiceV2Grpc.METHOD_CREATE_LOG_METRIC);

      updateLogMetricSettings =
          SimpleCallSettings.newBuilder(MetricsServiceV2Grpc.METHOD_UPDATE_LOG_METRIC);

      deleteLogMetricSettings =
          SimpleCallSettings.newBuilder(MetricsServiceV2Grpc.METHOD_DELETE_LOG_METRIC);

      methodSettingsBuilders =
          ImmutableList.<ApiCallSettings.Builder>of(
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

    private Builder(MetricsServiceV2Settings settings) {
      super(settings);

      listLogMetricsSettings = settings.listLogMetricsSettings.toBuilder();
      getLogMetricSettings = settings.getLogMetricSettings.toBuilder();
      createLogMetricSettings = settings.createLogMetricSettings.toBuilder();
      updateLogMetricSettings = settings.updateLogMetricSettings.toBuilder();
      deleteLogMetricSettings = settings.deleteLogMetricSettings.toBuilder();

      methodSettingsBuilders =
          ImmutableList.<ApiCallSettings.Builder>of(
              listLogMetricsSettings,
              getLogMetricSettings,
              createLogMetricSettings,
              updateLogMetricSettings,
              deleteLogMetricSettings);
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
     * Returns the builder for the settings used for calls to listLogMetrics.
     */
    public PageStreamingCallSettings.Builder<
            ListLogMetricsRequest, ListLogMetricsResponse, LogMetric>
        listLogMetricsSettings() {
      return listLogMetricsSettings;
    }

    /**
     * Returns the builder for the settings used for calls to getLogMetric.
     */
    public SimpleCallSettings.Builder<GetLogMetricRequest, LogMetric> getLogMetricSettings() {
      return getLogMetricSettings;
    }

    /**
     * Returns the builder for the settings used for calls to createLogMetric.
     */
    public SimpleCallSettings.Builder<CreateLogMetricRequest, LogMetric> createLogMetricSettings() {
      return createLogMetricSettings;
    }

    /**
     * Returns the builder for the settings used for calls to updateLogMetric.
     */
    public SimpleCallSettings.Builder<UpdateLogMetricRequest, LogMetric> updateLogMetricSettings() {
      return updateLogMetricSettings;
    }

    /**
     * Returns the builder for the settings used for calls to deleteLogMetric.
     */
    public SimpleCallSettings.Builder<DeleteLogMetricRequest, Empty> deleteLogMetricSettings() {
      return deleteLogMetricSettings;
    }

    @Override
    public MetricsServiceV2Settings build() throws IOException {
      return new MetricsServiceV2Settings(this);
    }
  }
}
