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

import static com.google.ads.admanager.v1.LineItemTemplateServiceClient.ListLineItemTemplatesPagedResponse;

import com.google.ads.admanager.v1.GetLineItemTemplateRequest;
import com.google.ads.admanager.v1.LineItemTemplate;
import com.google.ads.admanager.v1.ListLineItemTemplatesRequest;
import com.google.ads.admanager.v1.ListLineItemTemplatesResponse;
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
 * Settings class to configure an instance of {@link LineItemTemplateServiceStub}.
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
 * of getLineItemTemplate:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * LineItemTemplateServiceStubSettings.Builder lineItemTemplateServiceSettingsBuilder =
 *     LineItemTemplateServiceStubSettings.newBuilder();
 * lineItemTemplateServiceSettingsBuilder
 *     .getLineItemTemplateSettings()
 *     .setRetrySettings(
 *         lineItemTemplateServiceSettingsBuilder
 *             .getLineItemTemplateSettings()
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
 * LineItemTemplateServiceStubSettings lineItemTemplateServiceSettings =
 *     lineItemTemplateServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 */
@NullMarked
@Generated("by gapic-generator-java")
@SuppressWarnings("CanonicalDuration")
public class LineItemTemplateServiceStubSettings
    extends StubSettings<LineItemTemplateServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/admanager")
          .add("https://www.googleapis.com/auth/admanager.readonly")
          .build();

  private final UnaryCallSettings<GetLineItemTemplateRequest, LineItemTemplate>
      getLineItemTemplateSettings;
  private final PagedCallSettings<
          ListLineItemTemplatesRequest,
          ListLineItemTemplatesResponse,
          ListLineItemTemplatesPagedResponse>
      listLineItemTemplatesSettings;

  private static final PagedListDescriptor<
          ListLineItemTemplatesRequest, ListLineItemTemplatesResponse, LineItemTemplate>
      LIST_LINE_ITEM_TEMPLATES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListLineItemTemplatesRequest, ListLineItemTemplatesResponse, LineItemTemplate>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListLineItemTemplatesRequest injectToken(
                ListLineItemTemplatesRequest payload, String token) {
              return ListLineItemTemplatesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListLineItemTemplatesRequest injectPageSize(
                ListLineItemTemplatesRequest payload, int pageSize) {
              return ListLineItemTemplatesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListLineItemTemplatesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListLineItemTemplatesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<LineItemTemplate> extractResources(
                ListLineItemTemplatesResponse payload) {
              return payload.getLineItemTemplatesList();
            }
          };

  private static final PagedListResponseFactory<
          ListLineItemTemplatesRequest,
          ListLineItemTemplatesResponse,
          ListLineItemTemplatesPagedResponse>
      LIST_LINE_ITEM_TEMPLATES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListLineItemTemplatesRequest,
              ListLineItemTemplatesResponse,
              ListLineItemTemplatesPagedResponse>() {
            @Override
            public ApiFuture<ListLineItemTemplatesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListLineItemTemplatesRequest, ListLineItemTemplatesResponse> callable,
                ListLineItemTemplatesRequest request,
                ApiCallContext context,
                ApiFuture<ListLineItemTemplatesResponse> futureResponse) {
              PageContext<
                      ListLineItemTemplatesRequest, ListLineItemTemplatesResponse, LineItemTemplate>
                  pageContext =
                      PageContext.create(
                          callable, LIST_LINE_ITEM_TEMPLATES_PAGE_STR_DESC, request, context);
              return ListLineItemTemplatesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to getLineItemTemplate. */
  public UnaryCallSettings<GetLineItemTemplateRequest, LineItemTemplate>
      getLineItemTemplateSettings() {
    return getLineItemTemplateSettings;
  }

  /** Returns the object with the settings used for calls to listLineItemTemplates. */
  public PagedCallSettings<
          ListLineItemTemplatesRequest,
          ListLineItemTemplatesResponse,
          ListLineItemTemplatesPagedResponse>
      listLineItemTemplatesSettings() {
    return listLineItemTemplatesSettings;
  }

  public LineItemTemplateServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonLineItemTemplateServiceStub.create(this);
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
            "gapic", GaxProperties.getLibraryVersion(LineItemTemplateServiceStubSettings.class))
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

  protected LineItemTemplateServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    getLineItemTemplateSettings = settingsBuilder.getLineItemTemplateSettings().build();
    listLineItemTemplatesSettings = settingsBuilder.listLineItemTemplatesSettings().build();
  }

  @Override
  protected LibraryMetadata getLibraryMetadata() {
    return LibraryMetadata.newBuilder()
        .setArtifactName("com.google.api-ads:ad-manager")
        .setRepository("googleapis/google-cloud-java")
        .setVersion(Version.VERSION)
        .build();
  }

  /** Builder for LineItemTemplateServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<LineItemTemplateServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<GetLineItemTemplateRequest, LineItemTemplate>
        getLineItemTemplateSettings;
    private final PagedCallSettings.Builder<
            ListLineItemTemplatesRequest,
            ListLineItemTemplatesResponse,
            ListLineItemTemplatesPagedResponse>
        listLineItemTemplatesSettings;
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

      getLineItemTemplateSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listLineItemTemplatesSettings =
          PagedCallSettings.newBuilder(LIST_LINE_ITEM_TEMPLATES_PAGE_STR_FACT);

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getLineItemTemplateSettings, listLineItemTemplatesSettings);
      initDefaults(this);
    }

    protected Builder(LineItemTemplateServiceStubSettings settings) {
      super(settings);

      getLineItemTemplateSettings = settings.getLineItemTemplateSettings.toBuilder();
      listLineItemTemplatesSettings = settings.listLineItemTemplatesSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getLineItemTemplateSettings, listLineItemTemplatesSettings);
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
          .getLineItemTemplateSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listLineItemTemplatesSettings()
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

    /** Returns the builder for the settings used for calls to getLineItemTemplate. */
    public UnaryCallSettings.Builder<GetLineItemTemplateRequest, LineItemTemplate>
        getLineItemTemplateSettings() {
      return getLineItemTemplateSettings;
    }

    /** Returns the builder for the settings used for calls to listLineItemTemplates. */
    public PagedCallSettings.Builder<
            ListLineItemTemplatesRequest,
            ListLineItemTemplatesResponse,
            ListLineItemTemplatesPagedResponse>
        listLineItemTemplatesSettings() {
      return listLineItemTemplatesSettings;
    }

    @Override
    public LineItemTemplateServiceStubSettings build() throws IOException {
      return new LineItemTemplateServiceStubSettings(this);
    }
  }
}
