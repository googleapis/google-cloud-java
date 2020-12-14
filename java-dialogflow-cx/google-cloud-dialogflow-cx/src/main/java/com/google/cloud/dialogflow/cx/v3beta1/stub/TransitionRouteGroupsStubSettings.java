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

package com.google.cloud.dialogflow.cx.v3beta1.stub;

import static com.google.cloud.dialogflow.cx.v3beta1.TransitionRouteGroupsClient.ListTransitionRouteGroupsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
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
import com.google.cloud.dialogflow.cx.v3beta1.CreateTransitionRouteGroupRequest;
import com.google.cloud.dialogflow.cx.v3beta1.DeleteTransitionRouteGroupRequest;
import com.google.cloud.dialogflow.cx.v3beta1.GetTransitionRouteGroupRequest;
import com.google.cloud.dialogflow.cx.v3beta1.ListTransitionRouteGroupsRequest;
import com.google.cloud.dialogflow.cx.v3beta1.ListTransitionRouteGroupsResponse;
import com.google.cloud.dialogflow.cx.v3beta1.TransitionRouteGroup;
import com.google.cloud.dialogflow.cx.v3beta1.UpdateTransitionRouteGroupRequest;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link TransitionRouteGroupsStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (dialogflow.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getTransitionRouteGroup to 30 seconds:
 *
 * <pre>{@code
 * TransitionRouteGroupsStubSettings.Builder transitionRouteGroupsSettingsBuilder =
 *     TransitionRouteGroupsStubSettings.newBuilder();
 * transitionRouteGroupsSettingsBuilder
 *     .getTransitionRouteGroupSettings()
 *     .setRetrySettings(
 *         transitionRouteGroupsSettingsBuilder
 *             .getTransitionRouteGroupSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * TransitionRouteGroupsStubSettings transitionRouteGroupsSettings =
 *     transitionRouteGroupsSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class TransitionRouteGroupsStubSettings
    extends StubSettings<TransitionRouteGroupsStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/cloud-platform")
          .add("https://www.googleapis.com/auth/dialogflow")
          .build();

  private final PagedCallSettings<
          ListTransitionRouteGroupsRequest,
          ListTransitionRouteGroupsResponse,
          ListTransitionRouteGroupsPagedResponse>
      listTransitionRouteGroupsSettings;
  private final UnaryCallSettings<GetTransitionRouteGroupRequest, TransitionRouteGroup>
      getTransitionRouteGroupSettings;
  private final UnaryCallSettings<CreateTransitionRouteGroupRequest, TransitionRouteGroup>
      createTransitionRouteGroupSettings;
  private final UnaryCallSettings<UpdateTransitionRouteGroupRequest, TransitionRouteGroup>
      updateTransitionRouteGroupSettings;
  private final UnaryCallSettings<DeleteTransitionRouteGroupRequest, Empty>
      deleteTransitionRouteGroupSettings;

  private static final PagedListDescriptor<
          ListTransitionRouteGroupsRequest, ListTransitionRouteGroupsResponse, TransitionRouteGroup>
      LIST_TRANSITION_ROUTE_GROUPS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListTransitionRouteGroupsRequest,
              ListTransitionRouteGroupsResponse,
              TransitionRouteGroup>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListTransitionRouteGroupsRequest injectToken(
                ListTransitionRouteGroupsRequest payload, String token) {
              return ListTransitionRouteGroupsRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListTransitionRouteGroupsRequest injectPageSize(
                ListTransitionRouteGroupsRequest payload, int pageSize) {
              return ListTransitionRouteGroupsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListTransitionRouteGroupsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListTransitionRouteGroupsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<TransitionRouteGroup> extractResources(
                ListTransitionRouteGroupsResponse payload) {
              return payload.getTransitionRouteGroupsList() == null
                  ? ImmutableList.<TransitionRouteGroup>of()
                  : payload.getTransitionRouteGroupsList();
            }
          };

  private static final PagedListResponseFactory<
          ListTransitionRouteGroupsRequest,
          ListTransitionRouteGroupsResponse,
          ListTransitionRouteGroupsPagedResponse>
      LIST_TRANSITION_ROUTE_GROUPS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListTransitionRouteGroupsRequest,
              ListTransitionRouteGroupsResponse,
              ListTransitionRouteGroupsPagedResponse>() {
            @Override
            public ApiFuture<ListTransitionRouteGroupsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListTransitionRouteGroupsRequest, ListTransitionRouteGroupsResponse>
                    callable,
                ListTransitionRouteGroupsRequest request,
                ApiCallContext context,
                ApiFuture<ListTransitionRouteGroupsResponse> futureResponse) {
              PageContext<
                      ListTransitionRouteGroupsRequest,
                      ListTransitionRouteGroupsResponse,
                      TransitionRouteGroup>
                  pageContext =
                      PageContext.create(
                          callable, LIST_TRANSITION_ROUTE_GROUPS_PAGE_STR_DESC, request, context);
              return ListTransitionRouteGroupsPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to listTransitionRouteGroups. */
  public PagedCallSettings<
          ListTransitionRouteGroupsRequest,
          ListTransitionRouteGroupsResponse,
          ListTransitionRouteGroupsPagedResponse>
      listTransitionRouteGroupsSettings() {
    return listTransitionRouteGroupsSettings;
  }

  /** Returns the object with the settings used for calls to getTransitionRouteGroup. */
  public UnaryCallSettings<GetTransitionRouteGroupRequest, TransitionRouteGroup>
      getTransitionRouteGroupSettings() {
    return getTransitionRouteGroupSettings;
  }

  /** Returns the object with the settings used for calls to createTransitionRouteGroup. */
  public UnaryCallSettings<CreateTransitionRouteGroupRequest, TransitionRouteGroup>
      createTransitionRouteGroupSettings() {
    return createTransitionRouteGroupSettings;
  }

  /** Returns the object with the settings used for calls to updateTransitionRouteGroup. */
  public UnaryCallSettings<UpdateTransitionRouteGroupRequest, TransitionRouteGroup>
      updateTransitionRouteGroupSettings() {
    return updateTransitionRouteGroupSettings;
  }

  /** Returns the object with the settings used for calls to deleteTransitionRouteGroup. */
  public UnaryCallSettings<DeleteTransitionRouteGroupRequest, Empty>
      deleteTransitionRouteGroupSettings() {
    return deleteTransitionRouteGroupSettings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public TransitionRouteGroupsStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcTransitionRouteGroupsStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "dialogflow.googleapis.com:443";
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
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return InstantiatingGrpcChannelProvider.newBuilder()
        .setMaxInboundMessageSize(Integer.MAX_VALUE);
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultGrpcTransportProviderBuilder().build();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(TransitionRouteGroupsStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
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

  protected TransitionRouteGroupsStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listTransitionRouteGroupsSettings = settingsBuilder.listTransitionRouteGroupsSettings().build();
    getTransitionRouteGroupSettings = settingsBuilder.getTransitionRouteGroupSettings().build();
    createTransitionRouteGroupSettings =
        settingsBuilder.createTransitionRouteGroupSettings().build();
    updateTransitionRouteGroupSettings =
        settingsBuilder.updateTransitionRouteGroupSettings().build();
    deleteTransitionRouteGroupSettings =
        settingsBuilder.deleteTransitionRouteGroupSettings().build();
  }

  /** Builder for TransitionRouteGroupsStubSettings. */
  public static class Builder
      extends StubSettings.Builder<TransitionRouteGroupsStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListTransitionRouteGroupsRequest,
            ListTransitionRouteGroupsResponse,
            ListTransitionRouteGroupsPagedResponse>
        listTransitionRouteGroupsSettings;
    private final UnaryCallSettings.Builder<GetTransitionRouteGroupRequest, TransitionRouteGroup>
        getTransitionRouteGroupSettings;
    private final UnaryCallSettings.Builder<CreateTransitionRouteGroupRequest, TransitionRouteGroup>
        createTransitionRouteGroupSettings;
    private final UnaryCallSettings.Builder<UpdateTransitionRouteGroupRequest, TransitionRouteGroup>
        updateTransitionRouteGroupSettings;
    private final UnaryCallSettings.Builder<DeleteTransitionRouteGroupRequest, Empty>
        deleteTransitionRouteGroupSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "retry_policy_0_codes",
          ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList(StatusCode.Code.UNAVAILABLE)));
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
              .setInitialRpcTimeout(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(60000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      listTransitionRouteGroupsSettings =
          PagedCallSettings.newBuilder(LIST_TRANSITION_ROUTE_GROUPS_PAGE_STR_FACT);
      getTransitionRouteGroupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createTransitionRouteGroupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateTransitionRouteGroupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteTransitionRouteGroupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listTransitionRouteGroupsSettings,
              getTransitionRouteGroupSettings,
              createTransitionRouteGroupSettings,
              updateTransitionRouteGroupSettings,
              deleteTransitionRouteGroupSettings);
      initDefaults(this);
    }

    protected Builder(TransitionRouteGroupsStubSettings settings) {
      super(settings);

      listTransitionRouteGroupsSettings = settings.listTransitionRouteGroupsSettings.toBuilder();
      getTransitionRouteGroupSettings = settings.getTransitionRouteGroupSettings.toBuilder();
      createTransitionRouteGroupSettings = settings.createTransitionRouteGroupSettings.toBuilder();
      updateTransitionRouteGroupSettings = settings.updateTransitionRouteGroupSettings.toBuilder();
      deleteTransitionRouteGroupSettings = settings.deleteTransitionRouteGroupSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listTransitionRouteGroupsSettings,
              getTransitionRouteGroupSettings,
              createTransitionRouteGroupSettings,
              updateTransitionRouteGroupSettings,
              deleteTransitionRouteGroupSettings);
    }

    private static Builder createDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultTransportChannelProvider());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultApiClientHeaderProviderBuilder().build());
      builder.setEndpoint(getDefaultEndpoint());

      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {
      builder
          .listTransitionRouteGroupsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getTransitionRouteGroupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createTransitionRouteGroupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateTransitionRouteGroupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteTransitionRouteGroupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      return builder;
    }

    // NEXT_MAJOR_VER: remove 'throws Exception'.
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

    /** Returns the builder for the settings used for calls to listTransitionRouteGroups. */
    public PagedCallSettings.Builder<
            ListTransitionRouteGroupsRequest,
            ListTransitionRouteGroupsResponse,
            ListTransitionRouteGroupsPagedResponse>
        listTransitionRouteGroupsSettings() {
      return listTransitionRouteGroupsSettings;
    }

    /** Returns the builder for the settings used for calls to getTransitionRouteGroup. */
    public UnaryCallSettings.Builder<GetTransitionRouteGroupRequest, TransitionRouteGroup>
        getTransitionRouteGroupSettings() {
      return getTransitionRouteGroupSettings;
    }

    /** Returns the builder for the settings used for calls to createTransitionRouteGroup. */
    public UnaryCallSettings.Builder<CreateTransitionRouteGroupRequest, TransitionRouteGroup>
        createTransitionRouteGroupSettings() {
      return createTransitionRouteGroupSettings;
    }

    /** Returns the builder for the settings used for calls to updateTransitionRouteGroup. */
    public UnaryCallSettings.Builder<UpdateTransitionRouteGroupRequest, TransitionRouteGroup>
        updateTransitionRouteGroupSettings() {
      return updateTransitionRouteGroupSettings;
    }

    /** Returns the builder for the settings used for calls to deleteTransitionRouteGroup. */
    public UnaryCallSettings.Builder<DeleteTransitionRouteGroupRequest, Empty>
        deleteTransitionRouteGroupSettings() {
      return deleteTransitionRouteGroupSettings;
    }

    @Override
    public TransitionRouteGroupsStubSettings build() throws IOException {
      return new TransitionRouteGroupsStubSettings(this);
    }
  }
}
