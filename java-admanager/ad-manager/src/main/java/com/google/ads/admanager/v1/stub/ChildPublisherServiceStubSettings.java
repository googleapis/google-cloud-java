/*
 * Copyright 2026 Google LLC
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

package com.google.ads.admanager.v1.stub;

import static com.google.ads.admanager.v1.ChildPublisherServiceClient.ListChildPublishersPagedResponse;

import com.google.ads.admanager.v1.BatchCreateChildPublishersRequest;
import com.google.ads.admanager.v1.BatchCreateChildPublishersResponse;
import com.google.ads.admanager.v1.BatchUpdateChildPublishersRequest;
import com.google.ads.admanager.v1.BatchUpdateChildPublishersResponse;
import com.google.ads.admanager.v1.ChildPublisher;
import com.google.ads.admanager.v1.CreateChildPublisherRequest;
import com.google.ads.admanager.v1.GetChildPublisherRequest;
import com.google.ads.admanager.v1.ListChildPublishersRequest;
import com.google.ads.admanager.v1.ListChildPublishersResponse;
import com.google.ads.admanager.v1.UpdateChildPublisherRequest;
import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ObsoleteApi;
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
import com.google.api.gax.rpc.LibraryMetadata;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.PagedListDescriptor;
import com.google.api.gax.rpc.PagedListResponseFactory;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link ChildPublisherServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (admanager.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getChildPublisher:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ChildPublisherServiceStubSettings.Builder childPublisherServiceSettingsBuilder =
 *     ChildPublisherServiceStubSettings.newBuilder();
 * childPublisherServiceSettingsBuilder
 *     .getChildPublisherSettings()
 *     .setRetrySettings(
 *         childPublisherServiceSettingsBuilder
 *             .getChildPublisherSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofSeconds(1))
 *             .setInitialRpcTimeoutDuration(Duration.ofSeconds(5))
 *             .setMaxAttempts(5)
 *             .setMaxRetryDelayDuration(Duration.ofSeconds(30))
 *             .setMaxRpcTimeoutDuration(Duration.ofSeconds(60))
 *             .setRetryDelayMultiplier(1.3)
 *             .setRpcTimeoutMultiplier(1.5)
 *             .setTotalTimeoutDuration(Duration.ofSeconds(300))
 *             .build());
 * ChildPublisherServiceStubSettings childPublisherServiceSettings =
 *     childPublisherServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 */
@NullMarked
@Generated("by gapic-generator-java")
@SuppressWarnings("CanonicalDuration")
public class ChildPublisherServiceStubSettings
    extends StubSettings<ChildPublisherServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/admanager")
          .add("https://www.googleapis.com/auth/admanager.readonly")
          .build();

  private final UnaryCallSettings<GetChildPublisherRequest, ChildPublisher>
      getChildPublisherSettings;
  private final PagedCallSettings<
          ListChildPublishersRequest, ListChildPublishersResponse, ListChildPublishersPagedResponse>
      listChildPublishersSettings;
  private final UnaryCallSettings<CreateChildPublisherRequest, ChildPublisher>
      createChildPublisherSettings;
  private final UnaryCallSettings<
          BatchCreateChildPublishersRequest, BatchCreateChildPublishersResponse>
      batchCreateChildPublishersSettings;
  private final UnaryCallSettings<UpdateChildPublisherRequest, ChildPublisher>
      updateChildPublisherSettings;
  private final UnaryCallSettings<
          BatchUpdateChildPublishersRequest, BatchUpdateChildPublishersResponse>
      batchUpdateChildPublishersSettings;

  private static final PagedListDescriptor<
          ListChildPublishersRequest, ListChildPublishersResponse, ChildPublisher>
      LIST_CHILD_PUBLISHERS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListChildPublishersRequest, ListChildPublishersResponse, ChildPublisher>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListChildPublishersRequest injectToken(
                ListChildPublishersRequest payload, String token) {
              return ListChildPublishersRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListChildPublishersRequest injectPageSize(
                ListChildPublishersRequest payload, int pageSize) {
              return ListChildPublishersRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListChildPublishersRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListChildPublishersResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<ChildPublisher> extractResources(ListChildPublishersResponse payload) {
              return payload.getChildPublishersList();
            }
          };

  private static final PagedListResponseFactory<
          ListChildPublishersRequest, ListChildPublishersResponse, ListChildPublishersPagedResponse>
      LIST_CHILD_PUBLISHERS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListChildPublishersRequest,
              ListChildPublishersResponse,
              ListChildPublishersPagedResponse>() {
            @Override
            public ApiFuture<ListChildPublishersPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListChildPublishersRequest, ListChildPublishersResponse> callable,
                ListChildPublishersRequest request,
                ApiCallContext context,
                ApiFuture<ListChildPublishersResponse> futureResponse) {
              PageContext<ListChildPublishersRequest, ListChildPublishersResponse, ChildPublisher>
                  pageContext =
                      PageContext.create(
                          callable, LIST_CHILD_PUBLISHERS_PAGE_STR_DESC, request, context);
              return ListChildPublishersPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to getChildPublisher. */
  public UnaryCallSettings<GetChildPublisherRequest, ChildPublisher> getChildPublisherSettings() {
    return getChildPublisherSettings;
  }

  /** Returns the object with the settings used for calls to listChildPublishers. */
  public PagedCallSettings<
          ListChildPublishersRequest, ListChildPublishersResponse, ListChildPublishersPagedResponse>
      listChildPublishersSettings() {
    return listChildPublishersSettings;
  }

  /** Returns the object with the settings used for calls to createChildPublisher. */
  public UnaryCallSettings<CreateChildPublisherRequest, ChildPublisher>
      createChildPublisherSettings() {
    return createChildPublisherSettings;
  }

  /** Returns the object with the settings used for calls to batchCreateChildPublishers. */
  public UnaryCallSettings<BatchCreateChildPublishersRequest, BatchCreateChildPublishersResponse>
      batchCreateChildPublishersSettings() {
    return batchCreateChildPublishersSettings;
  }

  /** Returns the object with the settings used for calls to updateChildPublisher. */
  public UnaryCallSettings<UpdateChildPublisherRequest, ChildPublisher>
      updateChildPublisherSettings() {
    return updateChildPublisherSettings;
  }

  /** Returns the object with the settings used for calls to batchUpdateChildPublishers. */
  public UnaryCallSettings<BatchUpdateChildPublishersRequest, BatchUpdateChildPublishersResponse>
      batchUpdateChildPublishersSettings() {
    return batchUpdateChildPublishersSettings;
  }

  public ChildPublisherServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonChildPublisherServiceStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "admanager";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  @ObsoleteApi("Use getEndpoint() instead")
  public static String getDefaultEndpoint() {
    return "admanager.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "admanager.mtls.googleapis.com:443";
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
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return InstantiatingHttpJsonChannelProvider.newBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultHttpJsonTransportProviderBuilder().build();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(ChildPublisherServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder(@Nullable ClientContext clientContext) {
    return new Builder(clientContext);
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  protected ChildPublisherServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    getChildPublisherSettings = settingsBuilder.getChildPublisherSettings().build();
    listChildPublishersSettings = settingsBuilder.listChildPublishersSettings().build();
    createChildPublisherSettings = settingsBuilder.createChildPublisherSettings().build();
    batchCreateChildPublishersSettings =
        settingsBuilder.batchCreateChildPublishersSettings().build();
    updateChildPublisherSettings = settingsBuilder.updateChildPublisherSettings().build();
    batchUpdateChildPublishersSettings =
        settingsBuilder.batchUpdateChildPublishersSettings().build();
  }

  @Override
  protected LibraryMetadata getLibraryMetadata() {
    return LibraryMetadata.newBuilder()
        .setArtifactName("com.google.api-ads:ad-manager")
        .setRepository("googleapis/google-cloud-java")
        .setVersion(Version.VERSION)
        .build();
  }

  /** Builder for ChildPublisherServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<ChildPublisherServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<GetChildPublisherRequest, ChildPublisher>
        getChildPublisherSettings;
    private final PagedCallSettings.Builder<
            ListChildPublishersRequest,
            ListChildPublishersResponse,
            ListChildPublishersPagedResponse>
        listChildPublishersSettings;
    private final UnaryCallSettings.Builder<CreateChildPublisherRequest, ChildPublisher>
        createChildPublisherSettings;
    private final UnaryCallSettings.Builder<
            BatchCreateChildPublishersRequest, BatchCreateChildPublishersResponse>
        batchCreateChildPublishersSettings;
    private final UnaryCallSettings.Builder<UpdateChildPublisherRequest, ChildPublisher>
        updateChildPublisherSettings;
    private final UnaryCallSettings.Builder<
            BatchUpdateChildPublishersRequest, BatchUpdateChildPublishersResponse>
        batchUpdateChildPublishersSettings;
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

    protected Builder(@Nullable ClientContext clientContext) {
      super(clientContext);

      getChildPublisherSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listChildPublishersSettings =
          PagedCallSettings.newBuilder(LIST_CHILD_PUBLISHERS_PAGE_STR_FACT);
      createChildPublisherSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchCreateChildPublishersSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateChildPublisherSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchUpdateChildPublishersSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getChildPublisherSettings,
              listChildPublishersSettings,
              createChildPublisherSettings,
              batchCreateChildPublishersSettings,
              updateChildPublisherSettings,
              batchUpdateChildPublishersSettings);
      initDefaults(this);
    }

    protected Builder(ChildPublisherServiceStubSettings settings) {
      super(settings);

      getChildPublisherSettings = settings.getChildPublisherSettings.toBuilder();
      listChildPublishersSettings = settings.listChildPublishersSettings.toBuilder();
      createChildPublisherSettings = settings.createChildPublisherSettings.toBuilder();
      batchCreateChildPublishersSettings = settings.batchCreateChildPublishersSettings.toBuilder();
      updateChildPublisherSettings = settings.updateChildPublisherSettings.toBuilder();
      batchUpdateChildPublishersSettings = settings.batchUpdateChildPublishersSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getChildPublisherSettings,
              listChildPublishersSettings,
              createChildPublisherSettings,
              batchCreateChildPublishersSettings,
              updateChildPublisherSettings,
              batchUpdateChildPublishersSettings);
    }

    private static Builder createDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultTransportChannelProvider());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultApiClientHeaderProviderBuilder().build());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {
      builder
          .getChildPublisherSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listChildPublishersSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createChildPublisherSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .batchCreateChildPublishersSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateChildPublisherSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .batchUpdateChildPublishersSettings()
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

    /** Returns the builder for the settings used for calls to getChildPublisher. */
    public UnaryCallSettings.Builder<GetChildPublisherRequest, ChildPublisher>
        getChildPublisherSettings() {
      return getChildPublisherSettings;
    }

    /** Returns the builder for the settings used for calls to listChildPublishers. */
    public PagedCallSettings.Builder<
            ListChildPublishersRequest,
            ListChildPublishersResponse,
            ListChildPublishersPagedResponse>
        listChildPublishersSettings() {
      return listChildPublishersSettings;
    }

    /** Returns the builder for the settings used for calls to createChildPublisher. */
    public UnaryCallSettings.Builder<CreateChildPublisherRequest, ChildPublisher>
        createChildPublisherSettings() {
      return createChildPublisherSettings;
    }

    /** Returns the builder for the settings used for calls to batchCreateChildPublishers. */
    public UnaryCallSettings.Builder<
            BatchCreateChildPublishersRequest, BatchCreateChildPublishersResponse>
        batchCreateChildPublishersSettings() {
      return batchCreateChildPublishersSettings;
    }

    /** Returns the builder for the settings used for calls to updateChildPublisher. */
    public UnaryCallSettings.Builder<UpdateChildPublisherRequest, ChildPublisher>
        updateChildPublisherSettings() {
      return updateChildPublisherSettings;
    }

    /** Returns the builder for the settings used for calls to batchUpdateChildPublishers. */
    public UnaryCallSettings.Builder<
            BatchUpdateChildPublishersRequest, BatchUpdateChildPublishersResponse>
        batchUpdateChildPublishersSettings() {
      return batchUpdateChildPublishersSettings;
    }

    @Override
    public ChildPublisherServiceStubSettings build() throws IOException {
      return new ChildPublisherServiceStubSettings(this);
    }
  }
}
