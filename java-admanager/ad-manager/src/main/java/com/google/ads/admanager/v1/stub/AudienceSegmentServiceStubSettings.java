/*
 * Copyright 2025 Google LLC
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

import static com.google.ads.admanager.v1.AudienceSegmentServiceClient.ListAudienceSegmentsPagedResponse;

import com.google.ads.admanager.v1.AudienceSegment;
import com.google.ads.admanager.v1.GetAudienceSegmentRequest;
import com.google.ads.admanager.v1.ListAudienceSegmentsRequest;
import com.google.ads.admanager.v1.ListAudienceSegmentsResponse;
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

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link AudienceSegmentServiceStub}.
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
 * of getAudienceSegment:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * AudienceSegmentServiceStubSettings.Builder audienceSegmentServiceSettingsBuilder =
 *     AudienceSegmentServiceStubSettings.newBuilder();
 * audienceSegmentServiceSettingsBuilder
 *     .getAudienceSegmentSettings()
 *     .setRetrySettings(
 *         audienceSegmentServiceSettingsBuilder
 *             .getAudienceSegmentSettings()
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
 * AudienceSegmentServiceStubSettings audienceSegmentServiceSettings =
 *     audienceSegmentServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 */
@Generated("by gapic-generator-java")
public class AudienceSegmentServiceStubSettings
    extends StubSettings<AudienceSegmentServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/admanager").build();

  private final UnaryCallSettings<GetAudienceSegmentRequest, AudienceSegment>
      getAudienceSegmentSettings;
  private final PagedCallSettings<
          ListAudienceSegmentsRequest,
          ListAudienceSegmentsResponse,
          ListAudienceSegmentsPagedResponse>
      listAudienceSegmentsSettings;

  private static final PagedListDescriptor<
          ListAudienceSegmentsRequest, ListAudienceSegmentsResponse, AudienceSegment>
      LIST_AUDIENCE_SEGMENTS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListAudienceSegmentsRequest, ListAudienceSegmentsResponse, AudienceSegment>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListAudienceSegmentsRequest injectToken(
                ListAudienceSegmentsRequest payload, String token) {
              return ListAudienceSegmentsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListAudienceSegmentsRequest injectPageSize(
                ListAudienceSegmentsRequest payload, int pageSize) {
              return ListAudienceSegmentsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListAudienceSegmentsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListAudienceSegmentsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<AudienceSegment> extractResources(
                ListAudienceSegmentsResponse payload) {
              return payload.getAudienceSegmentsList();
            }
          };

  private static final PagedListResponseFactory<
          ListAudienceSegmentsRequest,
          ListAudienceSegmentsResponse,
          ListAudienceSegmentsPagedResponse>
      LIST_AUDIENCE_SEGMENTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListAudienceSegmentsRequest,
              ListAudienceSegmentsResponse,
              ListAudienceSegmentsPagedResponse>() {
            @Override
            public ApiFuture<ListAudienceSegmentsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListAudienceSegmentsRequest, ListAudienceSegmentsResponse> callable,
                ListAudienceSegmentsRequest request,
                ApiCallContext context,
                ApiFuture<ListAudienceSegmentsResponse> futureResponse) {
              PageContext<
                      ListAudienceSegmentsRequest, ListAudienceSegmentsResponse, AudienceSegment>
                  pageContext =
                      PageContext.create(
                          callable, LIST_AUDIENCE_SEGMENTS_PAGE_STR_DESC, request, context);
              return ListAudienceSegmentsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to getAudienceSegment. */
  public UnaryCallSettings<GetAudienceSegmentRequest, AudienceSegment>
      getAudienceSegmentSettings() {
    return getAudienceSegmentSettings;
  }

  /** Returns the object with the settings used for calls to listAudienceSegments. */
  public PagedCallSettings<
          ListAudienceSegmentsRequest,
          ListAudienceSegmentsResponse,
          ListAudienceSegmentsPagedResponse>
      listAudienceSegmentsSettings() {
    return listAudienceSegmentsSettings;
  }

  public AudienceSegmentServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonAudienceSegmentServiceStub.create(this);
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
            "gapic", GaxProperties.getLibraryVersion(AudienceSegmentServiceStubSettings.class))
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

  protected AudienceSegmentServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    getAudienceSegmentSettings = settingsBuilder.getAudienceSegmentSettings().build();
    listAudienceSegmentsSettings = settingsBuilder.listAudienceSegmentsSettings().build();
  }

  /** Builder for AudienceSegmentServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<AudienceSegmentServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<GetAudienceSegmentRequest, AudienceSegment>
        getAudienceSegmentSettings;
    private final PagedCallSettings.Builder<
            ListAudienceSegmentsRequest,
            ListAudienceSegmentsResponse,
            ListAudienceSegmentsPagedResponse>
        listAudienceSegmentsSettings;
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

      getAudienceSegmentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listAudienceSegmentsSettings =
          PagedCallSettings.newBuilder(LIST_AUDIENCE_SEGMENTS_PAGE_STR_FACT);

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getAudienceSegmentSettings, listAudienceSegmentsSettings);
      initDefaults(this);
    }

    protected Builder(AudienceSegmentServiceStubSettings settings) {
      super(settings);

      getAudienceSegmentSettings = settings.getAudienceSegmentSettings.toBuilder();
      listAudienceSegmentsSettings = settings.listAudienceSegmentsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getAudienceSegmentSettings, listAudienceSegmentsSettings);
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
          .getAudienceSegmentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listAudienceSegmentsSettings()
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

    /** Returns the builder for the settings used for calls to getAudienceSegment. */
    public UnaryCallSettings.Builder<GetAudienceSegmentRequest, AudienceSegment>
        getAudienceSegmentSettings() {
      return getAudienceSegmentSettings;
    }

    /** Returns the builder for the settings used for calls to listAudienceSegments. */
    public PagedCallSettings.Builder<
            ListAudienceSegmentsRequest,
            ListAudienceSegmentsResponse,
            ListAudienceSegmentsPagedResponse>
        listAudienceSegmentsSettings() {
      return listAudienceSegmentsSettings;
    }

    @Override
    public AudienceSegmentServiceStubSettings build() throws IOException {
      return new AudienceSegmentServiceStubSettings(this);
    }
  }
}
