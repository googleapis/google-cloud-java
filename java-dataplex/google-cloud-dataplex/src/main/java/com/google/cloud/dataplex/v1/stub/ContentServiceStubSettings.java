/*
 * Copyright 2021 Google LLC
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

package com.google.cloud.dataplex.v1.stub;

import static com.google.cloud.dataplex.v1.ContentServiceClient.ListContentPagedResponse;

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
import com.google.cloud.dataplex.v1.Content;
import com.google.cloud.dataplex.v1.CreateContentRequest;
import com.google.cloud.dataplex.v1.DeleteContentRequest;
import com.google.cloud.dataplex.v1.GetContentRequest;
import com.google.cloud.dataplex.v1.ListContentRequest;
import com.google.cloud.dataplex.v1.ListContentResponse;
import com.google.cloud.dataplex.v1.UpdateContentRequest;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link ContentServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (dataplex.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of createContent to 30 seconds:
 *
 * <pre>{@code
 * ContentServiceStubSettings.Builder contentServiceSettingsBuilder =
 *     ContentServiceStubSettings.newBuilder();
 * contentServiceSettingsBuilder
 *     .createContentSettings()
 *     .setRetrySettings(
 *         contentServiceSettingsBuilder
 *             .createContentSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * ContentServiceStubSettings contentServiceSettings = contentServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class ContentServiceStubSettings extends StubSettings<ContentServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<CreateContentRequest, Content> createContentSettings;
  private final UnaryCallSettings<UpdateContentRequest, Content> updateContentSettings;
  private final UnaryCallSettings<DeleteContentRequest, Empty> deleteContentSettings;
  private final UnaryCallSettings<GetContentRequest, Content> getContentSettings;
  private final PagedCallSettings<ListContentRequest, ListContentResponse, ListContentPagedResponse>
      listContentSettings;

  private static final PagedListDescriptor<ListContentRequest, ListContentResponse, Content>
      LIST_CONTENT_PAGE_STR_DESC =
          new PagedListDescriptor<ListContentRequest, ListContentResponse, Content>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListContentRequest injectToken(ListContentRequest payload, String token) {
              return ListContentRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListContentRequest injectPageSize(ListContentRequest payload, int pageSize) {
              return ListContentRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListContentRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListContentResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Content> extractResources(ListContentResponse payload) {
              return payload.getContentList() == null
                  ? ImmutableList.<Content>of()
                  : payload.getContentList();
            }
          };

  private static final PagedListResponseFactory<
          ListContentRequest, ListContentResponse, ListContentPagedResponse>
      LIST_CONTENT_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListContentRequest, ListContentResponse, ListContentPagedResponse>() {
            @Override
            public ApiFuture<ListContentPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListContentRequest, ListContentResponse> callable,
                ListContentRequest request,
                ApiCallContext context,
                ApiFuture<ListContentResponse> futureResponse) {
              PageContext<ListContentRequest, ListContentResponse, Content> pageContext =
                  PageContext.create(callable, LIST_CONTENT_PAGE_STR_DESC, request, context);
              return ListContentPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to createContent. */
  public UnaryCallSettings<CreateContentRequest, Content> createContentSettings() {
    return createContentSettings;
  }

  /** Returns the object with the settings used for calls to updateContent. */
  public UnaryCallSettings<UpdateContentRequest, Content> updateContentSettings() {
    return updateContentSettings;
  }

  /** Returns the object with the settings used for calls to deleteContent. */
  public UnaryCallSettings<DeleteContentRequest, Empty> deleteContentSettings() {
    return deleteContentSettings;
  }

  /** Returns the object with the settings used for calls to getContent. */
  public UnaryCallSettings<GetContentRequest, Content> getContentSettings() {
    return getContentSettings;
  }

  /** Returns the object with the settings used for calls to listContent. */
  public PagedCallSettings<ListContentRequest, ListContentResponse, ListContentPagedResponse>
      listContentSettings() {
    return listContentSettings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public ContentServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcContentServiceStub.create(this);
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
    return "dataplex.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "dataplex.mtls.googleapis.com:443";
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return DEFAULT_SERVICE_SCOPES;
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return GoogleCredentialsProvider.newBuilder()
        .setScopesToApply(DEFAULT_SERVICE_SCOPES)
        .setUseJwtAccessWithScope(true);
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
            "gapic", GaxProperties.getLibraryVersion(ContentServiceStubSettings.class))
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

  protected ContentServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createContentSettings = settingsBuilder.createContentSettings().build();
    updateContentSettings = settingsBuilder.updateContentSettings().build();
    deleteContentSettings = settingsBuilder.deleteContentSettings().build();
    getContentSettings = settingsBuilder.getContentSettings().build();
    listContentSettings = settingsBuilder.listContentSettings().build();
  }

  /** Builder for ContentServiceStubSettings. */
  public static class Builder extends StubSettings.Builder<ContentServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreateContentRequest, Content> createContentSettings;
    private final UnaryCallSettings.Builder<UpdateContentRequest, Content> updateContentSettings;
    private final UnaryCallSettings.Builder<DeleteContentRequest, Empty> deleteContentSettings;
    private final UnaryCallSettings.Builder<GetContentRequest, Content> getContentSettings;
    private final PagedCallSettings.Builder<
            ListContentRequest, ListContentResponse, ListContentPagedResponse>
        listContentSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put("no_retry_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings = RetrySettings.newBuilder().setRpcTimeoutMultiplier(1.0).build();
      definitions.put("no_retry_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      createContentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateContentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteContentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getContentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listContentSettings = PagedCallSettings.newBuilder(LIST_CONTENT_PAGE_STR_FACT);

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createContentSettings,
              updateContentSettings,
              deleteContentSettings,
              getContentSettings,
              listContentSettings);
      initDefaults(this);
    }

    protected Builder(ContentServiceStubSettings settings) {
      super(settings);

      createContentSettings = settings.createContentSettings.toBuilder();
      updateContentSettings = settings.updateContentSettings.toBuilder();
      deleteContentSettings = settings.deleteContentSettings.toBuilder();
      getContentSettings = settings.getContentSettings.toBuilder();
      listContentSettings = settings.listContentSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createContentSettings,
              updateContentSettings,
              deleteContentSettings,
              getContentSettings,
              listContentSettings);
    }

    private static Builder createDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultTransportChannelProvider());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultApiClientHeaderProviderBuilder().build());
      builder.setEndpoint(getDefaultEndpoint());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {
      builder
          .createContentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateContentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteContentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getContentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listContentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      return builder;
    }

    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) {
      super.applyToAllUnaryMethods(unaryMethodSettingsBuilders, settingsUpdater);
      return this;
    }

    public ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders() {
      return unaryMethodSettingsBuilders;
    }

    /** Returns the builder for the settings used for calls to createContent. */
    public UnaryCallSettings.Builder<CreateContentRequest, Content> createContentSettings() {
      return createContentSettings;
    }

    /** Returns the builder for the settings used for calls to updateContent. */
    public UnaryCallSettings.Builder<UpdateContentRequest, Content> updateContentSettings() {
      return updateContentSettings;
    }

    /** Returns the builder for the settings used for calls to deleteContent. */
    public UnaryCallSettings.Builder<DeleteContentRequest, Empty> deleteContentSettings() {
      return deleteContentSettings;
    }

    /** Returns the builder for the settings used for calls to getContent. */
    public UnaryCallSettings.Builder<GetContentRequest, Content> getContentSettings() {
      return getContentSettings;
    }

    /** Returns the builder for the settings used for calls to listContent. */
    public PagedCallSettings.Builder<
            ListContentRequest, ListContentResponse, ListContentPagedResponse>
        listContentSettings() {
      return listContentSettings;
    }

    @Override
    public ContentServiceStubSettings build() throws IOException {
      return new ContentServiceStubSettings(this);
    }
  }
}
