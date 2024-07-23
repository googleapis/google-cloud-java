/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.discoveryengine.v1alpha.stub;

import static com.google.cloud.discoveryengine.v1alpha.SampleQuerySetServiceClient.ListSampleQuerySetsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
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
import com.google.cloud.discoveryengine.v1alpha.CreateSampleQuerySetRequest;
import com.google.cloud.discoveryengine.v1alpha.DeleteSampleQuerySetRequest;
import com.google.cloud.discoveryengine.v1alpha.GetSampleQuerySetRequest;
import com.google.cloud.discoveryengine.v1alpha.ListSampleQuerySetsRequest;
import com.google.cloud.discoveryengine.v1alpha.ListSampleQuerySetsResponse;
import com.google.cloud.discoveryengine.v1alpha.SampleQuerySet;
import com.google.cloud.discoveryengine.v1alpha.UpdateSampleQuerySetRequest;
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
 * Settings class to configure an instance of {@link SampleQuerySetServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (discoveryengine.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getSampleQuerySet to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * SampleQuerySetServiceStubSettings.Builder sampleQuerySetServiceSettingsBuilder =
 *     SampleQuerySetServiceStubSettings.newBuilder();
 * sampleQuerySetServiceSettingsBuilder
 *     .getSampleQuerySetSettings()
 *     .setRetrySettings(
 *         sampleQuerySetServiceSettingsBuilder
 *             .getSampleQuerySetSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * SampleQuerySetServiceStubSettings sampleQuerySetServiceSettings =
 *     sampleQuerySetServiceSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class SampleQuerySetServiceStubSettings
    extends StubSettings<SampleQuerySetServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<GetSampleQuerySetRequest, SampleQuerySet>
      getSampleQuerySetSettings;
  private final PagedCallSettings<
          ListSampleQuerySetsRequest, ListSampleQuerySetsResponse, ListSampleQuerySetsPagedResponse>
      listSampleQuerySetsSettings;
  private final UnaryCallSettings<CreateSampleQuerySetRequest, SampleQuerySet>
      createSampleQuerySetSettings;
  private final UnaryCallSettings<UpdateSampleQuerySetRequest, SampleQuerySet>
      updateSampleQuerySetSettings;
  private final UnaryCallSettings<DeleteSampleQuerySetRequest, Empty> deleteSampleQuerySetSettings;

  private static final PagedListDescriptor<
          ListSampleQuerySetsRequest, ListSampleQuerySetsResponse, SampleQuerySet>
      LIST_SAMPLE_QUERY_SETS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListSampleQuerySetsRequest, ListSampleQuerySetsResponse, SampleQuerySet>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListSampleQuerySetsRequest injectToken(
                ListSampleQuerySetsRequest payload, String token) {
              return ListSampleQuerySetsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListSampleQuerySetsRequest injectPageSize(
                ListSampleQuerySetsRequest payload, int pageSize) {
              return ListSampleQuerySetsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListSampleQuerySetsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListSampleQuerySetsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<SampleQuerySet> extractResources(ListSampleQuerySetsResponse payload) {
              return payload.getSampleQuerySetsList() == null
                  ? ImmutableList.<SampleQuerySet>of()
                  : payload.getSampleQuerySetsList();
            }
          };

  private static final PagedListResponseFactory<
          ListSampleQuerySetsRequest, ListSampleQuerySetsResponse, ListSampleQuerySetsPagedResponse>
      LIST_SAMPLE_QUERY_SETS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListSampleQuerySetsRequest,
              ListSampleQuerySetsResponse,
              ListSampleQuerySetsPagedResponse>() {
            @Override
            public ApiFuture<ListSampleQuerySetsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListSampleQuerySetsRequest, ListSampleQuerySetsResponse> callable,
                ListSampleQuerySetsRequest request,
                ApiCallContext context,
                ApiFuture<ListSampleQuerySetsResponse> futureResponse) {
              PageContext<ListSampleQuerySetsRequest, ListSampleQuerySetsResponse, SampleQuerySet>
                  pageContext =
                      PageContext.create(
                          callable, LIST_SAMPLE_QUERY_SETS_PAGE_STR_DESC, request, context);
              return ListSampleQuerySetsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to getSampleQuerySet. */
  public UnaryCallSettings<GetSampleQuerySetRequest, SampleQuerySet> getSampleQuerySetSettings() {
    return getSampleQuerySetSettings;
  }

  /** Returns the object with the settings used for calls to listSampleQuerySets. */
  public PagedCallSettings<
          ListSampleQuerySetsRequest, ListSampleQuerySetsResponse, ListSampleQuerySetsPagedResponse>
      listSampleQuerySetsSettings() {
    return listSampleQuerySetsSettings;
  }

  /** Returns the object with the settings used for calls to createSampleQuerySet. */
  public UnaryCallSettings<CreateSampleQuerySetRequest, SampleQuerySet>
      createSampleQuerySetSettings() {
    return createSampleQuerySetSettings;
  }

  /** Returns the object with the settings used for calls to updateSampleQuerySet. */
  public UnaryCallSettings<UpdateSampleQuerySetRequest, SampleQuerySet>
      updateSampleQuerySetSettings() {
    return updateSampleQuerySetSettings;
  }

  /** Returns the object with the settings used for calls to deleteSampleQuerySet. */
  public UnaryCallSettings<DeleteSampleQuerySetRequest, Empty> deleteSampleQuerySetSettings() {
    return deleteSampleQuerySetSettings;
  }

  public SampleQuerySetServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcSampleQuerySetServiceStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonSampleQuerySetServiceStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "discoveryengine";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "discoveryengine.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "discoveryengine.mtls.googleapis.com:443";
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

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return InstantiatingGrpcChannelProvider.newBuilder()
        .setMaxInboundMessageSize(Integer.MAX_VALUE);
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return InstantiatingHttpJsonChannelProvider.newBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultGrpcTransportProviderBuilder().build();
  }

  public static ApiClientHeaderProvider.Builder defaultGrpcApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(SampleQuerySetServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(SampleQuerySetServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return SampleQuerySetServiceStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
  }

  /** Returns a new gRPC builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new REST builder for this class. */
  public static Builder newHttpJsonBuilder() {
    return Builder.createHttpJsonDefault();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder(ClientContext clientContext) {
    return new Builder(clientContext);
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  protected SampleQuerySetServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    getSampleQuerySetSettings = settingsBuilder.getSampleQuerySetSettings().build();
    listSampleQuerySetsSettings = settingsBuilder.listSampleQuerySetsSettings().build();
    createSampleQuerySetSettings = settingsBuilder.createSampleQuerySetSettings().build();
    updateSampleQuerySetSettings = settingsBuilder.updateSampleQuerySetSettings().build();
    deleteSampleQuerySetSettings = settingsBuilder.deleteSampleQuerySetSettings().build();
  }

  /** Builder for SampleQuerySetServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<SampleQuerySetServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<GetSampleQuerySetRequest, SampleQuerySet>
        getSampleQuerySetSettings;
    private final PagedCallSettings.Builder<
            ListSampleQuerySetsRequest,
            ListSampleQuerySetsResponse,
            ListSampleQuerySetsPagedResponse>
        listSampleQuerySetsSettings;
    private final UnaryCallSettings.Builder<CreateSampleQuerySetRequest, SampleQuerySet>
        createSampleQuerySetSettings;
    private final UnaryCallSettings.Builder<UpdateSampleQuerySetRequest, SampleQuerySet>
        updateSampleQuerySetSettings;
    private final UnaryCallSettings.Builder<DeleteSampleQuerySetRequest, Empty>
        deleteSampleQuerySetSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "retry_policy_1_codes",
          ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList(StatusCode.Code.UNAVAILABLE)));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.ofMillis(1000L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.ofMillis(10000L))
              .setInitialRpcTimeout(Duration.ofMillis(30000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(30000L))
              .setTotalTimeout(Duration.ofMillis(30000L))
              .build();
      definitions.put("retry_policy_1_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      getSampleQuerySetSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listSampleQuerySetsSettings =
          PagedCallSettings.newBuilder(LIST_SAMPLE_QUERY_SETS_PAGE_STR_FACT);
      createSampleQuerySetSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateSampleQuerySetSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteSampleQuerySetSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getSampleQuerySetSettings,
              listSampleQuerySetsSettings,
              createSampleQuerySetSettings,
              updateSampleQuerySetSettings,
              deleteSampleQuerySetSettings);
      initDefaults(this);
    }

    protected Builder(SampleQuerySetServiceStubSettings settings) {
      super(settings);

      getSampleQuerySetSettings = settings.getSampleQuerySetSettings.toBuilder();
      listSampleQuerySetsSettings = settings.listSampleQuerySetsSettings.toBuilder();
      createSampleQuerySetSettings = settings.createSampleQuerySetSettings.toBuilder();
      updateSampleQuerySetSettings = settings.updateSampleQuerySetSettings.toBuilder();
      deleteSampleQuerySetSettings = settings.deleteSampleQuerySetSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getSampleQuerySetSettings,
              listSampleQuerySetsSettings,
              createSampleQuerySetSettings,
              updateSampleQuerySetSettings,
              deleteSampleQuerySetSettings);
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

    private static Builder createHttpJsonDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultHttpJsonTransportProviderBuilder().build());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultHttpJsonApiClientHeaderProviderBuilder().build());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {
      builder
          .getSampleQuerySetSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .listSampleQuerySetsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .createSampleQuerySetSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .updateSampleQuerySetSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .deleteSampleQuerySetSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

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

    /** Returns the builder for the settings used for calls to getSampleQuerySet. */
    public UnaryCallSettings.Builder<GetSampleQuerySetRequest, SampleQuerySet>
        getSampleQuerySetSettings() {
      return getSampleQuerySetSettings;
    }

    /** Returns the builder for the settings used for calls to listSampleQuerySets. */
    public PagedCallSettings.Builder<
            ListSampleQuerySetsRequest,
            ListSampleQuerySetsResponse,
            ListSampleQuerySetsPagedResponse>
        listSampleQuerySetsSettings() {
      return listSampleQuerySetsSettings;
    }

    /** Returns the builder for the settings used for calls to createSampleQuerySet. */
    public UnaryCallSettings.Builder<CreateSampleQuerySetRequest, SampleQuerySet>
        createSampleQuerySetSettings() {
      return createSampleQuerySetSettings;
    }

    /** Returns the builder for the settings used for calls to updateSampleQuerySet. */
    public UnaryCallSettings.Builder<UpdateSampleQuerySetRequest, SampleQuerySet>
        updateSampleQuerySetSettings() {
      return updateSampleQuerySetSettings;
    }

    /** Returns the builder for the settings used for calls to deleteSampleQuerySet. */
    public UnaryCallSettings.Builder<DeleteSampleQuerySetRequest, Empty>
        deleteSampleQuerySetSettings() {
      return deleteSampleQuerySetSettings;
    }

    @Override
    public SampleQuerySetServiceStubSettings build() throws IOException {
      return new SampleQuerySetServiceStubSettings(this);
    }
  }
}
