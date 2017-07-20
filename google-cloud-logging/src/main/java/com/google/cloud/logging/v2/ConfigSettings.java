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
package com.google.cloud.logging.v2;

import static com.google.cloud.logging.v2.PagedResponseWrappers.ListSinksPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.CredentialsProvider;
import com.google.api.gax.core.ExecutorProvider;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.core.PropertiesProvider;
import com.google.api.gax.grpc.GrpcStatusCode;
import com.google.api.gax.grpc.GrpcTransport;
import com.google.api.gax.grpc.GrpcTransportProvider;
import com.google.api.gax.grpc.InstantiatingChannelProvider;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.PagedListDescriptor;
import com.google.api.gax.rpc.PagedListResponseFactory;
import com.google.api.gax.rpc.SimpleCallSettings;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.TransportProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.logging.v2.stub.ConfigServiceV2Stub;
import com.google.cloud.logging.v2.stub.GrpcConfigServiceV2Stub;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.logging.v2.CreateSinkRequest;
import com.google.logging.v2.DeleteSinkRequest;
import com.google.logging.v2.GetSinkRequest;
import com.google.logging.v2.ListSinksRequest;
import com.google.logging.v2.ListSinksResponse;
import com.google.logging.v2.LogSink;
import com.google.logging.v2.UpdateSinkRequest;
import com.google.protobuf.Empty;
import io.grpc.Status;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Settings class to configure an instance of {@link ConfigClient}.
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
 * example, to set the total timeout of getSink to 30 seconds:
 *
 * <pre>
 * <code>
 * ConfigSettings.Builder configSettingsBuilder =
 *     ConfigSettings.defaultBuilder();
 * configSettingsBuilder.getSinkSettings().getRetrySettingsBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * ConfigSettings configSettings = configSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by GAPIC v0.0.5")
@BetaApi
public class ConfigSettings extends ClientSettings {
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

  private static final String PROPERTIES_FILE = "/com/google/cloud/logging/project.properties";
  private static final String META_VERSION_KEY = "artifact.version";

  private static String gapicVersion;

  private final PagedCallSettings<ListSinksRequest, ListSinksResponse, ListSinksPagedResponse>
      listSinksSettings;
  private final SimpleCallSettings<GetSinkRequest, LogSink> getSinkSettings;
  private final SimpleCallSettings<CreateSinkRequest, LogSink> createSinkSettings;
  private final SimpleCallSettings<UpdateSinkRequest, LogSink> updateSinkSettings;
  private final SimpleCallSettings<DeleteSinkRequest, Empty> deleteSinkSettings;

  /** Returns the object with the settings used for calls to listSinks. */
  public PagedCallSettings<ListSinksRequest, ListSinksResponse, ListSinksPagedResponse>
      listSinksSettings() {
    return listSinksSettings;
  }

  /** Returns the object with the settings used for calls to getSink. */
  public SimpleCallSettings<GetSinkRequest, LogSink> getSinkSettings() {
    return getSinkSettings;
  }

  /** Returns the object with the settings used for calls to createSink. */
  public SimpleCallSettings<CreateSinkRequest, LogSink> createSinkSettings() {
    return createSinkSettings;
  }

  /** Returns the object with the settings used for calls to updateSink. */
  public SimpleCallSettings<UpdateSinkRequest, LogSink> updateSinkSettings() {
    return updateSinkSettings;
  }

  /** Returns the object with the settings used for calls to deleteSink. */
  public SimpleCallSettings<DeleteSinkRequest, Empty> deleteSinkSettings() {
    return deleteSinkSettings;
  }

  public ConfigServiceV2Stub createStub() throws IOException {
    if (getTransportProvider().getTransportName().equals(GrpcTransport.getGrpcTransportName())) {
      return GrpcConfigServiceV2Stub.create(this);
    } else {
      throw new UnsupportedOperationException(
          "Transport not supported: " + getTransportProvider().getTransportName());
    }
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "logging.googleapis.com:443";
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return DEFAULT_SERVICE_SCOPES;
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return GoogleCredentialsProvider.newBuilder().setScopesToApply(DEFAULT_SERVICE_SCOPES);
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingChannelProvider.Builder defaultGrpcChannelProviderBuilder() {
    return InstantiatingChannelProvider.newBuilder()
        .setEndpoint(getDefaultEndpoint())
        .setGeneratorHeader(DEFAULT_GAPIC_NAME, getGapicVersion());
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static GrpcTransportProvider.Builder defaultGrpcTransportProviderBuilder() {
    return GrpcTransportProvider.newBuilder()
        .setChannelProvider(defaultGrpcChannelProviderBuilder().build());
  }

  public static TransportProvider defaultTransportProvider() {
    return defaultGrpcTransportProviderBuilder().build();
  }

  private static String getGapicVersion() {
    if (gapicVersion == null) {
      gapicVersion =
          PropertiesProvider.loadProperty(ConfigSettings.class, PROPERTIES_FILE, META_VERSION_KEY);
      gapicVersion = gapicVersion == null ? DEFAULT_GAPIC_VERSION : gapicVersion;
    }
    return gapicVersion;
  }

  /** Returns a builder for this class with recommended defaults. */
  public static Builder defaultBuilder() {
    return Builder.createDefault();
  }

  /**
   * Returns a builder for this class with recommended defaults for API methods, and the given
   * ClientContext used for executor/transport/credentials.
   */
  public static Builder defaultBuilder(ClientContext clientContext) {
    return new Builder(clientContext);
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder() {
    return new Builder();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder(ClientContext clientContext) {
    return new Builder(clientContext);
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  private ConfigSettings(Builder settingsBuilder) throws IOException {
    super(
        settingsBuilder.getExecutorProvider(),
        settingsBuilder.getTransportProvider(),
        settingsBuilder.getCredentialsProvider(),
        settingsBuilder.getClock());

    listSinksSettings = settingsBuilder.listSinksSettings().build();
    getSinkSettings = settingsBuilder.getSinkSettings().build();
    createSinkSettings = settingsBuilder.createSinkSettings().build();
    updateSinkSettings = settingsBuilder.updateSinkSettings().build();
    deleteSinkSettings = settingsBuilder.deleteSinkSettings().build();
  }

  private static final PagedListDescriptor<ListSinksRequest, ListSinksResponse, LogSink>
      LIST_SINKS_PAGE_STR_DESC =
          new PagedListDescriptor<ListSinksRequest, ListSinksResponse, LogSink>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListSinksRequest injectToken(ListSinksRequest payload, String token) {
              return ListSinksRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListSinksRequest injectPageSize(ListSinksRequest payload, int pageSize) {
              return ListSinksRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListSinksRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListSinksResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<LogSink> extractResources(ListSinksResponse payload) {
              return payload.getSinksList();
            }
          };

  private static final PagedListResponseFactory<
          ListSinksRequest, ListSinksResponse, ListSinksPagedResponse>
      LIST_SINKS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListSinksRequest, ListSinksResponse, ListSinksPagedResponse>() {
            @Override
            public ApiFuture<ListSinksPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListSinksRequest, ListSinksResponse> callable,
                ListSinksRequest request,
                ApiCallContext context,
                ApiFuture<ListSinksResponse> futureResponse) {
              PageContext<ListSinksRequest, ListSinksResponse, LogSink> pageContext =
                  PageContext.create(callable, LIST_SINKS_PAGE_STR_DESC, request, context);
              return ListSinksPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Builder for ConfigSettings. */
  public static class Builder extends ClientSettings.Builder {
    private final ImmutableList<UnaryCallSettings.Builder> unaryMethodSettingsBuilders;

    private final PagedCallSettings.Builder<
            ListSinksRequest, ListSinksResponse, ListSinksPagedResponse>
        listSinksSettings;
    private final SimpleCallSettings.Builder<GetSinkRequest, LogSink> getSinkSettings;
    private final SimpleCallSettings.Builder<CreateSinkRequest, LogSink> createSinkSettings;
    private final SimpleCallSettings.Builder<UpdateSinkRequest, LogSink> updateSinkSettings;
    private final SimpleCallSettings.Builder<DeleteSinkRequest, Empty> deleteSinkSettings;

    private static final ImmutableMap<String, ImmutableSet<StatusCode>> RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode>> definitions = ImmutableMap.builder();
      definitions.put(
          "idempotent",
          ImmutableSet.copyOf(
              Lists.<StatusCode>newArrayList(
                  GrpcStatusCode.of(Status.Code.DEADLINE_EXCEEDED),
                  GrpcStatusCode.of(Status.Code.INTERNAL),
                  GrpcStatusCode.of(Status.Code.UNAVAILABLE))));
      definitions.put("non_idempotent", ImmutableSet.copyOf(Lists.<StatusCode>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.ofMillis(100L))
              .setRetryDelayMultiplier(1.2)
              .setMaxRetryDelay(Duration.ofMillis(1000L))
              .setInitialRpcTimeout(Duration.ofMillis(2000L))
              .setRpcTimeoutMultiplier(1.5)
              .setMaxRpcTimeout(Duration.ofMillis(30000L))
              .setTotalTimeout(Duration.ofMillis(45000L))
              .build();
      definitions.put("default", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    private Builder() {
      this((ClientContext) null);
    }

    private Builder(ClientContext clientContext) {
      super(clientContext);

      listSinksSettings = PagedCallSettings.newBuilder(LIST_SINKS_PAGE_STR_FACT);

      getSinkSettings = SimpleCallSettings.newBuilder();

      createSinkSettings = SimpleCallSettings.newBuilder();

      updateSinkSettings = SimpleCallSettings.newBuilder();

      deleteSinkSettings = SimpleCallSettings.newBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder>of(
              listSinksSettings,
              getSinkSettings,
              createSinkSettings,
              updateSinkSettings,
              deleteSinkSettings);

      initDefaults(this);
    }

    private static Builder createDefault() {
      Builder builder = new Builder((ClientContext) null);
      builder.setTransportProvider(defaultTransportProvider());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {

      builder
          .listSinksSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .getSinkSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .createSinkSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .updateSinkSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .deleteSinkSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      return builder;
    }

    private Builder(ConfigSettings settings) {
      super(settings);

      listSinksSettings = settings.listSinksSettings.toBuilder();
      getSinkSettings = settings.getSinkSettings.toBuilder();
      createSinkSettings = settings.createSinkSettings.toBuilder();
      updateSinkSettings = settings.updateSinkSettings.toBuilder();
      deleteSinkSettings = settings.deleteSinkSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder>of(
              listSinksSettings,
              getSinkSettings,
              createSinkSettings,
              updateSinkSettings,
              deleteSinkSettings);
    }

    @Override
    public Builder setExecutorProvider(ExecutorProvider executorProvider) {
      super.setExecutorProvider(executorProvider);
      return this;
    }

    @Override
    public Builder setTransportProvider(TransportProvider transportProvider) {
      super.setTransportProvider(transportProvider);
      return this;
    }

    @Override
    public Builder setCredentialsProvider(CredentialsProvider credentialsProvider) {
      super.setCredentialsProvider(credentialsProvider);
      return this;
    }

    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder, Void> settingsUpdater) throws Exception {
      super.applyToAllUnaryMethods(unaryMethodSettingsBuilders, settingsUpdater);
      return this;
    }

    /** Returns the builder for the settings used for calls to listSinks. */
    public PagedCallSettings.Builder<ListSinksRequest, ListSinksResponse, ListSinksPagedResponse>
        listSinksSettings() {
      return listSinksSettings;
    }

    /** Returns the builder for the settings used for calls to getSink. */
    public SimpleCallSettings.Builder<GetSinkRequest, LogSink> getSinkSettings() {
      return getSinkSettings;
    }

    /** Returns the builder for the settings used for calls to createSink. */
    public SimpleCallSettings.Builder<CreateSinkRequest, LogSink> createSinkSettings() {
      return createSinkSettings;
    }

    /** Returns the builder for the settings used for calls to updateSink. */
    public SimpleCallSettings.Builder<UpdateSinkRequest, LogSink> updateSinkSettings() {
      return updateSinkSettings;
    }

    /** Returns the builder for the settings used for calls to deleteSink. */
    public SimpleCallSettings.Builder<DeleteSinkRequest, Empty> deleteSinkSettings() {
      return deleteSinkSettings;
    }

    @Override
    public ConfigSettings build() throws IOException {
      return new ConfigSettings(this);
    }
  }
}
