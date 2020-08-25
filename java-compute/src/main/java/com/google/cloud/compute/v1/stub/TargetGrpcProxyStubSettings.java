/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.compute.v1.stub;

import static com.google.cloud.compute.v1.TargetGrpcProxyClient.ListTargetGrpcProxiesPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.HttpJsonTransportChannel;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.PagedListDescriptor;
import com.google.api.gax.rpc.PagedListResponseFactory;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.DeleteTargetGrpcProxyHttpRequest;
import com.google.cloud.compute.v1.GetTargetGrpcProxyHttpRequest;
import com.google.cloud.compute.v1.InsertTargetGrpcProxyHttpRequest;
import com.google.cloud.compute.v1.ListTargetGrpcProxiesHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.PatchTargetGrpcProxyHttpRequest;
import com.google.cloud.compute.v1.TargetGrpcProxy;
import com.google.cloud.compute.v1.TargetGrpcProxyList;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Settings class to configure an instance of {@link TargetGrpcProxyStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (https://compute.googleapis.com/compute/v1/projects/) and
 *       default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of deleteTargetGrpcProxy to 30 seconds:
 *
 * <pre>
 * <code>
 * TargetGrpcProxyStubSettings.Builder targetGrpcProxySettingsBuilder =
 *     TargetGrpcProxyStubSettings.newBuilder();
 * targetGrpcProxySettingsBuilder
 *     .deleteTargetGrpcProxySettings()
 *     .setRetrySettings(
 *         targetGrpcProxySettingsBuilder.deleteTargetGrpcProxySettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * TargetGrpcProxyStubSettings targetGrpcProxySettings = targetGrpcProxySettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class TargetGrpcProxyStubSettings extends StubSettings<TargetGrpcProxyStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/cloud-platform")
          .add("https://www.googleapis.com/auth/compute")
          .add("https://www.googleapis.com/auth/compute.readonly")
          .add("https://www.googleapis.com/auth/devstorage.full_control")
          .add("https://www.googleapis.com/auth/devstorage.read_only")
          .add("https://www.googleapis.com/auth/devstorage.read_write")
          .build();

  private final UnaryCallSettings<DeleteTargetGrpcProxyHttpRequest, Operation>
      deleteTargetGrpcProxySettings;
  private final UnaryCallSettings<GetTargetGrpcProxyHttpRequest, TargetGrpcProxy>
      getTargetGrpcProxySettings;
  private final UnaryCallSettings<InsertTargetGrpcProxyHttpRequest, Operation>
      insertTargetGrpcProxySettings;
  private final PagedCallSettings<
          ListTargetGrpcProxiesHttpRequest, TargetGrpcProxyList, ListTargetGrpcProxiesPagedResponse>
      listTargetGrpcProxiesSettings;
  private final UnaryCallSettings<PatchTargetGrpcProxyHttpRequest, Operation>
      patchTargetGrpcProxySettings;

  /** Returns the object with the settings used for calls to deleteTargetGrpcProxy. */
  public UnaryCallSettings<DeleteTargetGrpcProxyHttpRequest, Operation>
      deleteTargetGrpcProxySettings() {
    return deleteTargetGrpcProxySettings;
  }

  /** Returns the object with the settings used for calls to getTargetGrpcProxy. */
  public UnaryCallSettings<GetTargetGrpcProxyHttpRequest, TargetGrpcProxy>
      getTargetGrpcProxySettings() {
    return getTargetGrpcProxySettings;
  }

  /** Returns the object with the settings used for calls to insertTargetGrpcProxy. */
  public UnaryCallSettings<InsertTargetGrpcProxyHttpRequest, Operation>
      insertTargetGrpcProxySettings() {
    return insertTargetGrpcProxySettings;
  }

  /** Returns the object with the settings used for calls to listTargetGrpcProxies. */
  public PagedCallSettings<
          ListTargetGrpcProxiesHttpRequest, TargetGrpcProxyList, ListTargetGrpcProxiesPagedResponse>
      listTargetGrpcProxiesSettings() {
    return listTargetGrpcProxiesSettings;
  }

  /** Returns the object with the settings used for calls to patchTargetGrpcProxy. */
  public UnaryCallSettings<PatchTargetGrpcProxyHttpRequest, Operation>
      patchTargetGrpcProxySettings() {
    return patchTargetGrpcProxySettings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public TargetGrpcProxyStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonTargetGrpcProxyStub.create(this);
    } else {
      throw new UnsupportedOperationException(
          "Transport not supported: " + getTransportChannelProvider().getTransportName());
    }
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "https://compute.googleapis.com/compute/v1/projects/";
  }

  /** Returns the default service port. */
  public static int getDefaultServicePort() {
    return 443;
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
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return InstantiatingHttpJsonChannelProvider.newBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultHttpJsonTransportProviderBuilder().build();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(TargetGrpcProxyStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
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

  protected TargetGrpcProxyStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    deleteTargetGrpcProxySettings = settingsBuilder.deleteTargetGrpcProxySettings().build();
    getTargetGrpcProxySettings = settingsBuilder.getTargetGrpcProxySettings().build();
    insertTargetGrpcProxySettings = settingsBuilder.insertTargetGrpcProxySettings().build();
    listTargetGrpcProxiesSettings = settingsBuilder.listTargetGrpcProxiesSettings().build();
    patchTargetGrpcProxySettings = settingsBuilder.patchTargetGrpcProxySettings().build();
  }

  private static final PagedListDescriptor<
          ListTargetGrpcProxiesHttpRequest, TargetGrpcProxyList, TargetGrpcProxy>
      LIST_TARGET_GRPC_PROXIES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListTargetGrpcProxiesHttpRequest, TargetGrpcProxyList, TargetGrpcProxy>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListTargetGrpcProxiesHttpRequest injectToken(
                ListTargetGrpcProxiesHttpRequest payload, String token) {
              return ListTargetGrpcProxiesHttpRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListTargetGrpcProxiesHttpRequest injectPageSize(
                ListTargetGrpcProxiesHttpRequest payload, int pageSize) {
              return ListTargetGrpcProxiesHttpRequest.newBuilder(payload)
                  .setMaxResults(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListTargetGrpcProxiesHttpRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(TargetGrpcProxyList payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<TargetGrpcProxy> extractResources(TargetGrpcProxyList payload) {
              return payload.getItemsList() != null
                  ? payload.getItemsList()
                  : ImmutableList.<TargetGrpcProxy>of();
            }
          };

  private static final PagedListResponseFactory<
          ListTargetGrpcProxiesHttpRequest, TargetGrpcProxyList, ListTargetGrpcProxiesPagedResponse>
      LIST_TARGET_GRPC_PROXIES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListTargetGrpcProxiesHttpRequest,
              TargetGrpcProxyList,
              ListTargetGrpcProxiesPagedResponse>() {
            @Override
            public ApiFuture<ListTargetGrpcProxiesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListTargetGrpcProxiesHttpRequest, TargetGrpcProxyList> callable,
                ListTargetGrpcProxiesHttpRequest request,
                ApiCallContext context,
                ApiFuture<TargetGrpcProxyList> futureResponse) {
              PageContext<ListTargetGrpcProxiesHttpRequest, TargetGrpcProxyList, TargetGrpcProxy>
                  pageContext =
                      PageContext.create(
                          callable, LIST_TARGET_GRPC_PROXIES_PAGE_STR_DESC, request, context);
              return ListTargetGrpcProxiesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Builder for TargetGrpcProxyStubSettings. */
  public static class Builder extends StubSettings.Builder<TargetGrpcProxyStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;

    private final UnaryCallSettings.Builder<DeleteTargetGrpcProxyHttpRequest, Operation>
        deleteTargetGrpcProxySettings;
    private final UnaryCallSettings.Builder<GetTargetGrpcProxyHttpRequest, TargetGrpcProxy>
        getTargetGrpcProxySettings;
    private final UnaryCallSettings.Builder<InsertTargetGrpcProxyHttpRequest, Operation>
        insertTargetGrpcProxySettings;
    private final PagedCallSettings.Builder<
            ListTargetGrpcProxiesHttpRequest,
            TargetGrpcProxyList,
            ListTargetGrpcProxiesPagedResponse>
        listTargetGrpcProxiesSettings;
    private final UnaryCallSettings.Builder<PatchTargetGrpcProxyHttpRequest, Operation>
        patchTargetGrpcProxySettings;

    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "idempotent",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.DEADLINE_EXCEEDED, StatusCode.Code.UNAVAILABLE)));
      definitions.put("non_idempotent", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.ofMillis(100L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.ofMillis(60000L))
              .setInitialRpcTimeout(Duration.ofMillis(20000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(20000L))
              .setTotalTimeout(Duration.ofMillis(600000L))
              .build();
      definitions.put("default", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this((ClientContext) null);
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      deleteTargetGrpcProxySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      getTargetGrpcProxySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      insertTargetGrpcProxySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      listTargetGrpcProxiesSettings =
          PagedCallSettings.newBuilder(LIST_TARGET_GRPC_PROXIES_PAGE_STR_FACT);

      patchTargetGrpcProxySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              deleteTargetGrpcProxySettings,
              getTargetGrpcProxySettings,
              insertTargetGrpcProxySettings,
              listTargetGrpcProxiesSettings,
              patchTargetGrpcProxySettings);

      initDefaults(this);
    }

    private static Builder createDefault() {
      Builder builder = new Builder((ClientContext) null);
      builder.setTransportChannelProvider(defaultTransportChannelProvider());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultApiClientHeaderProviderBuilder().build());
      builder.setEndpoint(getDefaultEndpoint());
      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {

      builder
          .deleteTargetGrpcProxySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .getTargetGrpcProxySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .insertTargetGrpcProxySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .listTargetGrpcProxiesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .patchTargetGrpcProxySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      return builder;
    }

    protected Builder(TargetGrpcProxyStubSettings settings) {
      super(settings);

      deleteTargetGrpcProxySettings = settings.deleteTargetGrpcProxySettings.toBuilder();
      getTargetGrpcProxySettings = settings.getTargetGrpcProxySettings.toBuilder();
      insertTargetGrpcProxySettings = settings.insertTargetGrpcProxySettings.toBuilder();
      listTargetGrpcProxiesSettings = settings.listTargetGrpcProxiesSettings.toBuilder();
      patchTargetGrpcProxySettings = settings.patchTargetGrpcProxySettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              deleteTargetGrpcProxySettings,
              getTargetGrpcProxySettings,
              insertTargetGrpcProxySettings,
              listTargetGrpcProxiesSettings,
              patchTargetGrpcProxySettings);
    }

    // NEXT_MAJOR_VER: remove 'throws Exception'
    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) throws Exception {
      super.applyToAllUnaryMethods(unaryMethodSettingsBuilders, settingsUpdater);
      return this;
    }

    public ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders() {
      return unaryMethodSettingsBuilders;
    }

    /** Returns the builder for the settings used for calls to deleteTargetGrpcProxy. */
    public UnaryCallSettings.Builder<DeleteTargetGrpcProxyHttpRequest, Operation>
        deleteTargetGrpcProxySettings() {
      return deleteTargetGrpcProxySettings;
    }

    /** Returns the builder for the settings used for calls to getTargetGrpcProxy. */
    public UnaryCallSettings.Builder<GetTargetGrpcProxyHttpRequest, TargetGrpcProxy>
        getTargetGrpcProxySettings() {
      return getTargetGrpcProxySettings;
    }

    /** Returns the builder for the settings used for calls to insertTargetGrpcProxy. */
    public UnaryCallSettings.Builder<InsertTargetGrpcProxyHttpRequest, Operation>
        insertTargetGrpcProxySettings() {
      return insertTargetGrpcProxySettings;
    }

    /** Returns the builder for the settings used for calls to listTargetGrpcProxies. */
    public PagedCallSettings.Builder<
            ListTargetGrpcProxiesHttpRequest,
            TargetGrpcProxyList,
            ListTargetGrpcProxiesPagedResponse>
        listTargetGrpcProxiesSettings() {
      return listTargetGrpcProxiesSettings;
    }

    /** Returns the builder for the settings used for calls to patchTargetGrpcProxy. */
    public UnaryCallSettings.Builder<PatchTargetGrpcProxyHttpRequest, Operation>
        patchTargetGrpcProxySettings() {
      return patchTargetGrpcProxySettings;
    }

    @Override
    public TargetGrpcProxyStubSettings build() throws IOException {
      return new TargetGrpcProxyStubSettings(this);
    }
  }
}
