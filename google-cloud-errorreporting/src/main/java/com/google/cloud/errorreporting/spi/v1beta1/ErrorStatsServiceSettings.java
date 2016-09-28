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
package com.google.cloud.errorreporting.spi.v1beta1;

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
import com.google.devtools.clouderrorreporting.v1beta1.DeleteEventsRequest;
import com.google.devtools.clouderrorreporting.v1beta1.DeleteEventsResponse;
import com.google.devtools.clouderrorreporting.v1beta1.ErrorEvent;
import com.google.devtools.clouderrorreporting.v1beta1.ErrorGroupStats;
import com.google.devtools.clouderrorreporting.v1beta1.ErrorStatsServiceGrpc;
import com.google.devtools.clouderrorreporting.v1beta1.ListEventsRequest;
import com.google.devtools.clouderrorreporting.v1beta1.ListEventsResponse;
import com.google.devtools.clouderrorreporting.v1beta1.ListGroupStatsRequest;
import com.google.devtools.clouderrorreporting.v1beta1.ListGroupStatsResponse;
import io.grpc.ManagedChannel;
import io.grpc.Status;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import org.joda.time.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Settings class to configure an instance of {@link ErrorStatsServiceApi}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 * <li>The default service address (clouderrorreporting.googleapis.com) and default port (443)
 * are used.
 * <li>Credentials are acquired automatically through Application Default Credentials.
 * <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders.
 * When build() is called, the tree of builders is called to create the complete settings
 * object. For example, to set the total timeout of deleteEvents to 30 seconds:
 *
 * <pre>
 * <code>
 * ErrorStatsServiceSettings.Builder errorStatsServiceSettingsBuilder =
 *     ErrorStatsServiceSettings.defaultBuilder();
 * errorStatsServiceSettingsBuilder.deleteEventsSettings().getRetrySettingsBuilder()
 *     .setTotalTimeout(Duration.standardSeconds(30));
 * ErrorStatsServiceSettings errorStatsServiceSettings = errorStatsServiceSettingsBuilder.build();
 * </code>
 * </pre>
 */
@javax.annotation.Generated("by GAPIC")
public class ErrorStatsServiceSettings extends ServiceApiSettings {
  /**
   * The default address of the service.
   */
  private static final String DEFAULT_SERVICE_ADDRESS = "clouderrorreporting.googleapis.com";

  /**
   * The default port of the service.
   */
  private static final int DEFAULT_SERVICE_PORT = 443;

  /**
   * The default scopes of the service.
   */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

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
          ListGroupStatsRequest, ListGroupStatsResponse, ErrorGroupStats>
      listGroupStatsSettings;
  private final PageStreamingCallSettings<ListEventsRequest, ListEventsResponse, ErrorEvent>
      listEventsSettings;
  private final SimpleCallSettings<DeleteEventsRequest, DeleteEventsResponse> deleteEventsSettings;

  /**
   * Returns the object with the settings used for calls to listGroupStats.
   */
  public PageStreamingCallSettings<ListGroupStatsRequest, ListGroupStatsResponse, ErrorGroupStats>
      listGroupStatsSettings() {
    return listGroupStatsSettings;
  }

  /**
   * Returns the object with the settings used for calls to listEvents.
   */
  public PageStreamingCallSettings<ListEventsRequest, ListEventsResponse, ErrorEvent>
      listEventsSettings() {
    return listEventsSettings;
  }

  /**
   * Returns the object with the settings used for calls to deleteEvents.
   */
  public SimpleCallSettings<DeleteEventsRequest, DeleteEventsResponse> deleteEventsSettings() {
    return deleteEventsSettings;
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

  private ErrorStatsServiceSettings(Builder settingsBuilder) throws IOException {
    super(
        settingsBuilder.getChannelProvider(),
        settingsBuilder.getExecutorProvider(),
        settingsBuilder.getGeneratorName(),
        settingsBuilder.getGeneratorVersion(),
        settingsBuilder.getClientLibName(),
        settingsBuilder.getClientLibVersion());

    listGroupStatsSettings = settingsBuilder.listGroupStatsSettings().build();
    listEventsSettings = settingsBuilder.listEventsSettings().build();
    deleteEventsSettings = settingsBuilder.deleteEventsSettings().build();
  }

  private static PageStreamingDescriptor<
          ListGroupStatsRequest, ListGroupStatsResponse, ErrorGroupStats>
      LIST_GROUP_STATS_PAGE_STR_DESC =
          new PageStreamingDescriptor<
              ListGroupStatsRequest, ListGroupStatsResponse, ErrorGroupStats>() {
            @Override
            public Object emptyToken() {
              return "";
            }

            @Override
            public ListGroupStatsRequest injectToken(ListGroupStatsRequest payload, Object token) {
              return ListGroupStatsRequest.newBuilder(payload).setPageToken((String) token).build();
            }

            @Override
            public ListGroupStatsRequest injectPageSize(
                ListGroupStatsRequest payload, int pageSize) {
              return ListGroupStatsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListGroupStatsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public Object extractNextToken(ListGroupStatsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<ErrorGroupStats> extractResources(ListGroupStatsResponse payload) {
              return payload.getErrorGroupStatsList();
            }
          };

  private static PageStreamingDescriptor<ListEventsRequest, ListEventsResponse, ErrorEvent>
      LIST_EVENTS_PAGE_STR_DESC =
          new PageStreamingDescriptor<ListEventsRequest, ListEventsResponse, ErrorEvent>() {
            @Override
            public Object emptyToken() {
              return "";
            }

            @Override
            public ListEventsRequest injectToken(ListEventsRequest payload, Object token) {
              return ListEventsRequest.newBuilder(payload).setPageToken((String) token).build();
            }

            @Override
            public ListEventsRequest injectPageSize(ListEventsRequest payload, int pageSize) {
              return ListEventsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListEventsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public Object extractNextToken(ListEventsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<ErrorEvent> extractResources(ListEventsResponse payload) {
              return payload.getErrorEventsList();
            }
          };

  /**
   * Builder for ErrorStatsServiceSettings.
   */
  public static class Builder extends ServiceApiSettings.Builder {
    private final ImmutableList<ApiCallSettings.Builder> methodSettingsBuilders;

    private PageStreamingCallSettings.Builder<
            ListGroupStatsRequest, ListGroupStatsResponse, ErrorGroupStats>
        listGroupStatsSettings;
    private PageStreamingCallSettings.Builder<ListEventsRequest, ListEventsResponse, ErrorEvent>
        listEventsSettings;
    private SimpleCallSettings.Builder<DeleteEventsRequest, DeleteEventsResponse>
        deleteEventsSettings;

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

      listGroupStatsSettings =
          PageStreamingCallSettings.newBuilder(
              ErrorStatsServiceGrpc.METHOD_LIST_GROUP_STATS, LIST_GROUP_STATS_PAGE_STR_DESC);

      listEventsSettings =
          PageStreamingCallSettings.newBuilder(
              ErrorStatsServiceGrpc.METHOD_LIST_EVENTS, LIST_EVENTS_PAGE_STR_DESC);

      deleteEventsSettings =
          SimpleCallSettings.newBuilder(ErrorStatsServiceGrpc.METHOD_DELETE_EVENTS);

      methodSettingsBuilders =
          ImmutableList.<ApiCallSettings.Builder>of(
              listGroupStatsSettings, listEventsSettings, deleteEventsSettings);
    }

    private static Builder createDefault() {
      Builder builder = new Builder();

      builder
          .listGroupStatsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettingsBuilder(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .listEventsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettingsBuilder(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .deleteEventsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettingsBuilder(RETRY_PARAM_DEFINITIONS.get("default"));

      return builder;
    }

    private Builder(ErrorStatsServiceSettings settings) {
      super(settings);

      listGroupStatsSettings = settings.listGroupStatsSettings.toBuilder();
      listEventsSettings = settings.listEventsSettings.toBuilder();
      deleteEventsSettings = settings.deleteEventsSettings.toBuilder();

      methodSettingsBuilders =
          ImmutableList.<ApiCallSettings.Builder>of(
              listGroupStatsSettings, listEventsSettings, deleteEventsSettings);
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
     * Returns the builder for the settings used for calls to listGroupStats.
     */
    public PageStreamingCallSettings.Builder<
            ListGroupStatsRequest, ListGroupStatsResponse, ErrorGroupStats>
        listGroupStatsSettings() {
      return listGroupStatsSettings;
    }

    /**
     * Returns the builder for the settings used for calls to listEvents.
     */
    public PageStreamingCallSettings.Builder<ListEventsRequest, ListEventsResponse, ErrorEvent>
        listEventsSettings() {
      return listEventsSettings;
    }

    /**
     * Returns the builder for the settings used for calls to deleteEvents.
     */
    public SimpleCallSettings.Builder<DeleteEventsRequest, DeleteEventsResponse>
        deleteEventsSettings() {
      return deleteEventsSettings;
    }

    @Override
    public ErrorStatsServiceSettings build() throws IOException {
      return new ErrorStatsServiceSettings(this);
    }
  }
}
