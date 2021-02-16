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

package com.google.cloud.dialogflow.v2beta1.stub;

import static com.google.cloud.dialogflow.v2beta1.ContextsClient.ListContextsPagedResponse;

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
import com.google.cloud.dialogflow.v2beta1.Context;
import com.google.cloud.dialogflow.v2beta1.CreateContextRequest;
import com.google.cloud.dialogflow.v2beta1.DeleteAllContextsRequest;
import com.google.cloud.dialogflow.v2beta1.DeleteContextRequest;
import com.google.cloud.dialogflow.v2beta1.GetContextRequest;
import com.google.cloud.dialogflow.v2beta1.ListContextsRequest;
import com.google.cloud.dialogflow.v2beta1.ListContextsResponse;
import com.google.cloud.dialogflow.v2beta1.UpdateContextRequest;
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
 * Settings class to configure an instance of {@link ContextsStub}.
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
 * <p>For example, to set the total timeout of getContext to 30 seconds:
 *
 * <pre>{@code
 * ContextsStubSettings.Builder contextsSettingsBuilder = ContextsStubSettings.newBuilder();
 * contextsSettingsBuilder
 *     .getContextSettings()
 *     .setRetrySettings(
 *         contextsSettingsBuilder
 *             .getContextSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * ContextsStubSettings contextsSettings = contextsSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class ContextsStubSettings extends StubSettings<ContextsStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/cloud-platform")
          .add("https://www.googleapis.com/auth/dialogflow")
          .build();

  private final PagedCallSettings<
          ListContextsRequest, ListContextsResponse, ListContextsPagedResponse>
      listContextsSettings;
  private final UnaryCallSettings<GetContextRequest, Context> getContextSettings;
  private final UnaryCallSettings<CreateContextRequest, Context> createContextSettings;
  private final UnaryCallSettings<UpdateContextRequest, Context> updateContextSettings;
  private final UnaryCallSettings<DeleteContextRequest, Empty> deleteContextSettings;
  private final UnaryCallSettings<DeleteAllContextsRequest, Empty> deleteAllContextsSettings;

  private static final PagedListDescriptor<ListContextsRequest, ListContextsResponse, Context>
      LIST_CONTEXTS_PAGE_STR_DESC =
          new PagedListDescriptor<ListContextsRequest, ListContextsResponse, Context>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListContextsRequest injectToken(ListContextsRequest payload, String token) {
              return ListContextsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListContextsRequest injectPageSize(ListContextsRequest payload, int pageSize) {
              return ListContextsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListContextsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListContextsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Context> extractResources(ListContextsResponse payload) {
              return payload.getContextsList() == null
                  ? ImmutableList.<Context>of()
                  : payload.getContextsList();
            }
          };

  private static final PagedListResponseFactory<
          ListContextsRequest, ListContextsResponse, ListContextsPagedResponse>
      LIST_CONTEXTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListContextsRequest, ListContextsResponse, ListContextsPagedResponse>() {
            @Override
            public ApiFuture<ListContextsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListContextsRequest, ListContextsResponse> callable,
                ListContextsRequest request,
                ApiCallContext context,
                ApiFuture<ListContextsResponse> futureResponse) {
              PageContext<ListContextsRequest, ListContextsResponse, Context> pageContext =
                  PageContext.create(callable, LIST_CONTEXTS_PAGE_STR_DESC, request, context);
              return ListContextsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to listContexts. */
  public PagedCallSettings<ListContextsRequest, ListContextsResponse, ListContextsPagedResponse>
      listContextsSettings() {
    return listContextsSettings;
  }

  /** Returns the object with the settings used for calls to getContext. */
  public UnaryCallSettings<GetContextRequest, Context> getContextSettings() {
    return getContextSettings;
  }

  /** Returns the object with the settings used for calls to createContext. */
  public UnaryCallSettings<CreateContextRequest, Context> createContextSettings() {
    return createContextSettings;
  }

  /** Returns the object with the settings used for calls to updateContext. */
  public UnaryCallSettings<UpdateContextRequest, Context> updateContextSettings() {
    return updateContextSettings;
  }

  /** Returns the object with the settings used for calls to deleteContext. */
  public UnaryCallSettings<DeleteContextRequest, Empty> deleteContextSettings() {
    return deleteContextSettings;
  }

  /** Returns the object with the settings used for calls to deleteAllContexts. */
  public UnaryCallSettings<DeleteAllContextsRequest, Empty> deleteAllContextsSettings() {
    return deleteAllContextsSettings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public ContextsStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcContextsStub.create(this);
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
        .setGeneratedLibToken("gapic", GaxProperties.getLibraryVersion(ContextsStubSettings.class))
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

  protected ContextsStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listContextsSettings = settingsBuilder.listContextsSettings().build();
    getContextSettings = settingsBuilder.getContextSettings().build();
    createContextSettings = settingsBuilder.createContextSettings().build();
    updateContextSettings = settingsBuilder.updateContextSettings().build();
    deleteContextSettings = settingsBuilder.deleteContextSettings().build();
    deleteAllContextsSettings = settingsBuilder.deleteAllContextsSettings().build();
  }

  /** Builder for ContextsStubSettings. */
  public static class Builder extends StubSettings.Builder<ContextsStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListContextsRequest, ListContextsResponse, ListContextsPagedResponse>
        listContextsSettings;
    private final UnaryCallSettings.Builder<GetContextRequest, Context> getContextSettings;
    private final UnaryCallSettings.Builder<CreateContextRequest, Context> createContextSettings;
    private final UnaryCallSettings.Builder<UpdateContextRequest, Context> updateContextSettings;
    private final UnaryCallSettings.Builder<DeleteContextRequest, Empty> deleteContextSettings;
    private final UnaryCallSettings.Builder<DeleteAllContextsRequest, Empty>
        deleteAllContextsSettings;
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

      listContextsSettings = PagedCallSettings.newBuilder(LIST_CONTEXTS_PAGE_STR_FACT);
      getContextSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createContextSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateContextSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteContextSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteAllContextsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listContextsSettings,
              getContextSettings,
              createContextSettings,
              updateContextSettings,
              deleteContextSettings,
              deleteAllContextsSettings);
      initDefaults(this);
    }

    protected Builder(ContextsStubSettings settings) {
      super(settings);

      listContextsSettings = settings.listContextsSettings.toBuilder();
      getContextSettings = settings.getContextSettings.toBuilder();
      createContextSettings = settings.createContextSettings.toBuilder();
      updateContextSettings = settings.updateContextSettings.toBuilder();
      deleteContextSettings = settings.deleteContextSettings.toBuilder();
      deleteAllContextsSettings = settings.deleteAllContextsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listContextsSettings,
              getContextSettings,
              createContextSettings,
              updateContextSettings,
              deleteContextSettings,
              deleteAllContextsSettings);
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
          .listContextsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getContextSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createContextSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateContextSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteContextSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteAllContextsSettings()
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

    /** Returns the builder for the settings used for calls to listContexts. */
    public PagedCallSettings.Builder<
            ListContextsRequest, ListContextsResponse, ListContextsPagedResponse>
        listContextsSettings() {
      return listContextsSettings;
    }

    /** Returns the builder for the settings used for calls to getContext. */
    public UnaryCallSettings.Builder<GetContextRequest, Context> getContextSettings() {
      return getContextSettings;
    }

    /** Returns the builder for the settings used for calls to createContext. */
    public UnaryCallSettings.Builder<CreateContextRequest, Context> createContextSettings() {
      return createContextSettings;
    }

    /** Returns the builder for the settings used for calls to updateContext. */
    public UnaryCallSettings.Builder<UpdateContextRequest, Context> updateContextSettings() {
      return updateContextSettings;
    }

    /** Returns the builder for the settings used for calls to deleteContext. */
    public UnaryCallSettings.Builder<DeleteContextRequest, Empty> deleteContextSettings() {
      return deleteContextSettings;
    }

    /** Returns the builder for the settings used for calls to deleteAllContexts. */
    public UnaryCallSettings.Builder<DeleteAllContextsRequest, Empty> deleteAllContextsSettings() {
      return deleteAllContextsSettings;
    }

    @Override
    public ContextsStubSettings build() throws IOException {
      return new ContextsStubSettings(this);
    }
  }
}
