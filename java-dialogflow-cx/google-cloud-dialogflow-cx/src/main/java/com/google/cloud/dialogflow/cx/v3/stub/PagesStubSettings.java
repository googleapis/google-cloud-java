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

package com.google.cloud.dialogflow.cx.v3.stub;

import static com.google.cloud.dialogflow.cx.v3.PagesClient.ListPagesPagedResponse;

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
import com.google.cloud.dialogflow.cx.v3.CreatePageRequest;
import com.google.cloud.dialogflow.cx.v3.DeletePageRequest;
import com.google.cloud.dialogflow.cx.v3.GetPageRequest;
import com.google.cloud.dialogflow.cx.v3.ListPagesRequest;
import com.google.cloud.dialogflow.cx.v3.ListPagesResponse;
import com.google.cloud.dialogflow.cx.v3.Page;
import com.google.cloud.dialogflow.cx.v3.UpdatePageRequest;
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
 * Settings class to configure an instance of {@link PagesStub}.
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
 * <p>For example, to set the total timeout of getPage to 30 seconds:
 *
 * <pre>{@code
 * PagesStubSettings.Builder pagesSettingsBuilder = PagesStubSettings.newBuilder();
 * pagesSettingsBuilder
 *     .getPageSettings()
 *     .setRetrySettings(
 *         pagesSettingsBuilder
 *             .getPageSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * PagesStubSettings pagesSettings = pagesSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class PagesStubSettings extends StubSettings<PagesStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/cloud-platform")
          .add("https://www.googleapis.com/auth/dialogflow")
          .build();

  private final PagedCallSettings<ListPagesRequest, ListPagesResponse, ListPagesPagedResponse>
      listPagesSettings;
  private final UnaryCallSettings<GetPageRequest, Page> getPageSettings;
  private final UnaryCallSettings<CreatePageRequest, Page> createPageSettings;
  private final UnaryCallSettings<UpdatePageRequest, Page> updatePageSettings;
  private final UnaryCallSettings<DeletePageRequest, Empty> deletePageSettings;

  private static final PagedListDescriptor<ListPagesRequest, ListPagesResponse, Page>
      LIST_PAGES_PAGE_STR_DESC =
          new PagedListDescriptor<ListPagesRequest, ListPagesResponse, Page>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListPagesRequest injectToken(ListPagesRequest payload, String token) {
              return ListPagesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListPagesRequest injectPageSize(ListPagesRequest payload, int pageSize) {
              return ListPagesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListPagesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListPagesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Page> extractResources(ListPagesResponse payload) {
              return payload.getPagesList() == null
                  ? ImmutableList.<Page>of()
                  : payload.getPagesList();
            }
          };

  private static final PagedListResponseFactory<
          ListPagesRequest, ListPagesResponse, ListPagesPagedResponse>
      LIST_PAGES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListPagesRequest, ListPagesResponse, ListPagesPagedResponse>() {
            @Override
            public ApiFuture<ListPagesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListPagesRequest, ListPagesResponse> callable,
                ListPagesRequest request,
                ApiCallContext context,
                ApiFuture<ListPagesResponse> futureResponse) {
              PageContext<ListPagesRequest, ListPagesResponse, Page> pageContext =
                  PageContext.create(callable, LIST_PAGES_PAGE_STR_DESC, request, context);
              return ListPagesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to listPages. */
  public PagedCallSettings<ListPagesRequest, ListPagesResponse, ListPagesPagedResponse>
      listPagesSettings() {
    return listPagesSettings;
  }

  /** Returns the object with the settings used for calls to getPage. */
  public UnaryCallSettings<GetPageRequest, Page> getPageSettings() {
    return getPageSettings;
  }

  /** Returns the object with the settings used for calls to createPage. */
  public UnaryCallSettings<CreatePageRequest, Page> createPageSettings() {
    return createPageSettings;
  }

  /** Returns the object with the settings used for calls to updatePage. */
  public UnaryCallSettings<UpdatePageRequest, Page> updatePageSettings() {
    return updatePageSettings;
  }

  /** Returns the object with the settings used for calls to deletePage. */
  public UnaryCallSettings<DeletePageRequest, Empty> deletePageSettings() {
    return deletePageSettings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public PagesStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcPagesStub.create(this);
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
        .setGeneratedLibToken("gapic", GaxProperties.getLibraryVersion(PagesStubSettings.class))
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

  protected PagesStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listPagesSettings = settingsBuilder.listPagesSettings().build();
    getPageSettings = settingsBuilder.getPageSettings().build();
    createPageSettings = settingsBuilder.createPageSettings().build();
    updatePageSettings = settingsBuilder.updatePageSettings().build();
    deletePageSettings = settingsBuilder.deletePageSettings().build();
  }

  /** Builder for PagesStubSettings. */
  public static class Builder extends StubSettings.Builder<PagesStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListPagesRequest, ListPagesResponse, ListPagesPagedResponse>
        listPagesSettings;
    private final UnaryCallSettings.Builder<GetPageRequest, Page> getPageSettings;
    private final UnaryCallSettings.Builder<CreatePageRequest, Page> createPageSettings;
    private final UnaryCallSettings.Builder<UpdatePageRequest, Page> updatePageSettings;
    private final UnaryCallSettings.Builder<DeletePageRequest, Empty> deletePageSettings;
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

      listPagesSettings = PagedCallSettings.newBuilder(LIST_PAGES_PAGE_STR_FACT);
      getPageSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createPageSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updatePageSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deletePageSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listPagesSettings,
              getPageSettings,
              createPageSettings,
              updatePageSettings,
              deletePageSettings);
      initDefaults(this);
    }

    protected Builder(PagesStubSettings settings) {
      super(settings);

      listPagesSettings = settings.listPagesSettings.toBuilder();
      getPageSettings = settings.getPageSettings.toBuilder();
      createPageSettings = settings.createPageSettings.toBuilder();
      updatePageSettings = settings.updatePageSettings.toBuilder();
      deletePageSettings = settings.deletePageSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listPagesSettings,
              getPageSettings,
              createPageSettings,
              updatePageSettings,
              deletePageSettings);
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
          .listPagesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getPageSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createPageSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updatePageSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deletePageSettings()
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

    /** Returns the builder for the settings used for calls to listPages. */
    public PagedCallSettings.Builder<ListPagesRequest, ListPagesResponse, ListPagesPagedResponse>
        listPagesSettings() {
      return listPagesSettings;
    }

    /** Returns the builder for the settings used for calls to getPage. */
    public UnaryCallSettings.Builder<GetPageRequest, Page> getPageSettings() {
      return getPageSettings;
    }

    /** Returns the builder for the settings used for calls to createPage. */
    public UnaryCallSettings.Builder<CreatePageRequest, Page> createPageSettings() {
      return createPageSettings;
    }

    /** Returns the builder for the settings used for calls to updatePage. */
    public UnaryCallSettings.Builder<UpdatePageRequest, Page> updatePageSettings() {
      return updatePageSettings;
    }

    /** Returns the builder for the settings used for calls to deletePage. */
    public UnaryCallSettings.Builder<DeletePageRequest, Empty> deletePageSettings() {
      return deletePageSettings;
    }

    @Override
    public PagesStubSettings build() throws IOException {
      return new PagesStubSettings(this);
    }
  }
}
