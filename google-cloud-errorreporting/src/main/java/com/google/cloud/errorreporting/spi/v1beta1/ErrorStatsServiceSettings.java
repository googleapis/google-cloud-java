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
package com.google.cloud.errorreporting.spi.v1beta1;

import static com.google.cloud.errorreporting.spi.v1beta1.PagedResponseWrappers.ListEventsPagedResponse;
import static com.google.cloud.errorreporting.spi.v1beta1.PagedResponseWrappers.ListGroupStatsPagedResponse;

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
import com.google.devtools.clouderrorreporting.v1beta1.DeleteEventsRequest;
import com.google.devtools.clouderrorreporting.v1beta1.DeleteEventsResponse;
import com.google.devtools.clouderrorreporting.v1beta1.ErrorEvent;
import com.google.devtools.clouderrorreporting.v1beta1.ErrorGroupStats;
import com.google.devtools.clouderrorreporting.v1beta1.ErrorStatsServiceGrpc;
import com.google.devtools.clouderrorreporting.v1beta1.ListEventsRequest;
import com.google.devtools.clouderrorreporting.v1beta1.ListEventsResponse;
import com.google.devtools.clouderrorreporting.v1beta1.ListGroupStatsRequest;
import com.google.devtools.clouderrorreporting.v1beta1.ListGroupStatsResponse;
import com.google.protobuf.ExperimentalApi;
import io.grpc.Status;
import java.io.IOException;
import javax.annotation.Generated;
import org.joda.time.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Settings class to configure an instance of {@link ErrorStatsServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (clouderrorreporting.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object. For
 * example, to set the total timeout of deleteEvents to 30 seconds:
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
@Generated("by GAPIC v0.0.5")
@ExperimentalApi
public class ErrorStatsServiceSettings extends ClientSettings {
  /** The default address of the service. */
  private static final String DEFAULT_SERVICE_ADDRESS = "clouderrorreporting.googleapis.com";

  /** The default port of the service. */
  private static final int DEFAULT_SERVICE_PORT = 443;

  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private static final String DEFAULT_GAPIC_NAME = "gapic";
  private static final String DEFAULT_GAPIC_VERSION = "";

  private static final String PROPERTIES_FILE = "/project.properties";
  private static final String META_VERSION_KEY = "artifact.version";

  private static String gapicVersion;

  private final PagedCallSettings<
          ListGroupStatsRequest, ListGroupStatsResponse, ListGroupStatsPagedResponse>
      listGroupStatsSettings;
  private final PagedCallSettings<ListEventsRequest, ListEventsResponse, ListEventsPagedResponse>
      listEventsSettings;
  private final SimpleCallSettings<DeleteEventsRequest, DeleteEventsResponse> deleteEventsSettings;

  /** Returns the object with the settings used for calls to listGroupStats. */
  public PagedCallSettings<
          ListGroupStatsRequest, ListGroupStatsResponse, ListGroupStatsPagedResponse>
      listGroupStatsSettings() {
    return listGroupStatsSettings;
  }

  /** Returns the object with the settings used for calls to listEvents. */
  public PagedCallSettings<ListEventsRequest, ListEventsResponse, ListEventsPagedResponse>
      listEventsSettings() {
    return listEventsSettings;
  }

  /** Returns the object with the settings used for calls to deleteEvents. */
  public SimpleCallSettings<DeleteEventsRequest, DeleteEventsResponse> deleteEventsSettings() {
    return deleteEventsSettings;
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
              ErrorStatsServiceSettings.class, PROPERTIES_FILE, META_VERSION_KEY);
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

  private ErrorStatsServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder.getExecutorProvider(), settingsBuilder.getChannelProvider());

    listGroupStatsSettings = settingsBuilder.listGroupStatsSettings().build();
    listEventsSettings = settingsBuilder.listEventsSettings().build();
    deleteEventsSettings = settingsBuilder.deleteEventsSettings().build();
  }

  private static final PagedListDescriptor<
          ListGroupStatsRequest, ListGroupStatsResponse, ErrorGroupStats>
      LIST_GROUP_STATS_PAGE_STR_DESC =
          new PagedListDescriptor<
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

  private static final PagedListDescriptor<ListEventsRequest, ListEventsResponse, ErrorEvent>
      LIST_EVENTS_PAGE_STR_DESC =
          new PagedListDescriptor<ListEventsRequest, ListEventsResponse, ErrorEvent>() {
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

  private static final PagedListResponseFactory<
          ListGroupStatsRequest, ListGroupStatsResponse, ListGroupStatsPagedResponse>
      LIST_GROUP_STATS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListGroupStatsRequest, ListGroupStatsResponse, ListGroupStatsPagedResponse>() {
            @Override
            public ListGroupStatsPagedResponse createPagedListResponse(
                UnaryCallable<ListGroupStatsRequest, ListGroupStatsResponse> callable,
                ListGroupStatsRequest request,
                CallContext context) {
              return new ListGroupStatsPagedResponse(
                  callable, LIST_GROUP_STATS_PAGE_STR_DESC, request, context);
            }
          };

  private static final PagedListResponseFactory<
          ListEventsRequest, ListEventsResponse, ListEventsPagedResponse>
      LIST_EVENTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListEventsRequest, ListEventsResponse, ListEventsPagedResponse>() {
            @Override
            public ListEventsPagedResponse createPagedListResponse(
                UnaryCallable<ListEventsRequest, ListEventsResponse> callable,
                ListEventsRequest request,
                CallContext context) {
              return new ListEventsPagedResponse(
                  callable, LIST_EVENTS_PAGE_STR_DESC, request, context);
            }
          };

  /** Builder for ErrorStatsServiceSettings. */
  public static class Builder extends ClientSettings.Builder {
    private final ImmutableList<UnaryCallSettings.Builder> unaryMethodSettingsBuilders;

    private final PagedCallSettings.Builder<
            ListGroupStatsRequest, ListGroupStatsResponse, ListGroupStatsPagedResponse>
        listGroupStatsSettings;
    private final PagedCallSettings.Builder<
            ListEventsRequest, ListEventsResponse, ListEventsPagedResponse>
        listEventsSettings;
    private final SimpleCallSettings.Builder<DeleteEventsRequest, DeleteEventsResponse>
        deleteEventsSettings;

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

      listGroupStatsSettings =
          PagedCallSettings.newBuilder(
              ErrorStatsServiceGrpc.METHOD_LIST_GROUP_STATS, LIST_GROUP_STATS_PAGE_STR_FACT);

      listEventsSettings =
          PagedCallSettings.newBuilder(
              ErrorStatsServiceGrpc.METHOD_LIST_EVENTS, LIST_EVENTS_PAGE_STR_FACT);

      deleteEventsSettings =
          SimpleCallSettings.newBuilder(ErrorStatsServiceGrpc.METHOD_DELETE_EVENTS);

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder>of(
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

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder>of(
              listGroupStatsSettings, listEventsSettings, deleteEventsSettings);
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

    /** Returns the builder for the settings used for calls to listGroupStats. */
    public PagedCallSettings.Builder<
            ListGroupStatsRequest, ListGroupStatsResponse, ListGroupStatsPagedResponse>
        listGroupStatsSettings() {
      return listGroupStatsSettings;
    }

    /** Returns the builder for the settings used for calls to listEvents. */
    public PagedCallSettings.Builder<ListEventsRequest, ListEventsResponse, ListEventsPagedResponse>
        listEventsSettings() {
      return listEventsSettings;
    }

    /** Returns the builder for the settings used for calls to deleteEvents. */
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
