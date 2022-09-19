/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.speech.v1.stub;

import static com.google.cloud.speech.v1.AdaptationClient.ListCustomClassesPagedResponse;
import static com.google.cloud.speech.v1.AdaptationClient.ListPhraseSetPagedResponse;

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
import com.google.cloud.speech.v1.CreateCustomClassRequest;
import com.google.cloud.speech.v1.CreatePhraseSetRequest;
import com.google.cloud.speech.v1.CustomClass;
import com.google.cloud.speech.v1.DeleteCustomClassRequest;
import com.google.cloud.speech.v1.DeletePhraseSetRequest;
import com.google.cloud.speech.v1.GetCustomClassRequest;
import com.google.cloud.speech.v1.GetPhraseSetRequest;
import com.google.cloud.speech.v1.ListCustomClassesRequest;
import com.google.cloud.speech.v1.ListCustomClassesResponse;
import com.google.cloud.speech.v1.ListPhraseSetRequest;
import com.google.cloud.speech.v1.ListPhraseSetResponse;
import com.google.cloud.speech.v1.PhraseSet;
import com.google.cloud.speech.v1.UpdateCustomClassRequest;
import com.google.cloud.speech.v1.UpdatePhraseSetRequest;
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
 * Settings class to configure an instance of {@link AdaptationStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (speech.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of createPhraseSet to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * AdaptationStubSettings.Builder adaptationSettingsBuilder = AdaptationStubSettings.newBuilder();
 * adaptationSettingsBuilder
 *     .createPhraseSetSettings()
 *     .setRetrySettings(
 *         adaptationSettingsBuilder.createPhraseSetSettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * AdaptationStubSettings adaptationSettings = adaptationSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class AdaptationStubSettings extends StubSettings<AdaptationStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<CreatePhraseSetRequest, PhraseSet> createPhraseSetSettings;
  private final UnaryCallSettings<GetPhraseSetRequest, PhraseSet> getPhraseSetSettings;
  private final PagedCallSettings<
          ListPhraseSetRequest, ListPhraseSetResponse, ListPhraseSetPagedResponse>
      listPhraseSetSettings;
  private final UnaryCallSettings<UpdatePhraseSetRequest, PhraseSet> updatePhraseSetSettings;
  private final UnaryCallSettings<DeletePhraseSetRequest, Empty> deletePhraseSetSettings;
  private final UnaryCallSettings<CreateCustomClassRequest, CustomClass> createCustomClassSettings;
  private final UnaryCallSettings<GetCustomClassRequest, CustomClass> getCustomClassSettings;
  private final PagedCallSettings<
          ListCustomClassesRequest, ListCustomClassesResponse, ListCustomClassesPagedResponse>
      listCustomClassesSettings;
  private final UnaryCallSettings<UpdateCustomClassRequest, CustomClass> updateCustomClassSettings;
  private final UnaryCallSettings<DeleteCustomClassRequest, Empty> deleteCustomClassSettings;

  private static final PagedListDescriptor<ListPhraseSetRequest, ListPhraseSetResponse, PhraseSet>
      LIST_PHRASE_SET_PAGE_STR_DESC =
          new PagedListDescriptor<ListPhraseSetRequest, ListPhraseSetResponse, PhraseSet>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListPhraseSetRequest injectToken(ListPhraseSetRequest payload, String token) {
              return ListPhraseSetRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListPhraseSetRequest injectPageSize(ListPhraseSetRequest payload, int pageSize) {
              return ListPhraseSetRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListPhraseSetRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListPhraseSetResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<PhraseSet> extractResources(ListPhraseSetResponse payload) {
              return payload.getPhraseSetsList() == null
                  ? ImmutableList.<PhraseSet>of()
                  : payload.getPhraseSetsList();
            }
          };

  private static final PagedListDescriptor<
          ListCustomClassesRequest, ListCustomClassesResponse, CustomClass>
      LIST_CUSTOM_CLASSES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListCustomClassesRequest, ListCustomClassesResponse, CustomClass>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListCustomClassesRequest injectToken(
                ListCustomClassesRequest payload, String token) {
              return ListCustomClassesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListCustomClassesRequest injectPageSize(
                ListCustomClassesRequest payload, int pageSize) {
              return ListCustomClassesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListCustomClassesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListCustomClassesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<CustomClass> extractResources(ListCustomClassesResponse payload) {
              return payload.getCustomClassesList() == null
                  ? ImmutableList.<CustomClass>of()
                  : payload.getCustomClassesList();
            }
          };

  private static final PagedListResponseFactory<
          ListPhraseSetRequest, ListPhraseSetResponse, ListPhraseSetPagedResponse>
      LIST_PHRASE_SET_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListPhraseSetRequest, ListPhraseSetResponse, ListPhraseSetPagedResponse>() {
            @Override
            public ApiFuture<ListPhraseSetPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListPhraseSetRequest, ListPhraseSetResponse> callable,
                ListPhraseSetRequest request,
                ApiCallContext context,
                ApiFuture<ListPhraseSetResponse> futureResponse) {
              PageContext<ListPhraseSetRequest, ListPhraseSetResponse, PhraseSet> pageContext =
                  PageContext.create(callable, LIST_PHRASE_SET_PAGE_STR_DESC, request, context);
              return ListPhraseSetPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListCustomClassesRequest, ListCustomClassesResponse, ListCustomClassesPagedResponse>
      LIST_CUSTOM_CLASSES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListCustomClassesRequest,
              ListCustomClassesResponse,
              ListCustomClassesPagedResponse>() {
            @Override
            public ApiFuture<ListCustomClassesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListCustomClassesRequest, ListCustomClassesResponse> callable,
                ListCustomClassesRequest request,
                ApiCallContext context,
                ApiFuture<ListCustomClassesResponse> futureResponse) {
              PageContext<ListCustomClassesRequest, ListCustomClassesResponse, CustomClass>
                  pageContext =
                      PageContext.create(
                          callable, LIST_CUSTOM_CLASSES_PAGE_STR_DESC, request, context);
              return ListCustomClassesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to createPhraseSet. */
  public UnaryCallSettings<CreatePhraseSetRequest, PhraseSet> createPhraseSetSettings() {
    return createPhraseSetSettings;
  }

  /** Returns the object with the settings used for calls to getPhraseSet. */
  public UnaryCallSettings<GetPhraseSetRequest, PhraseSet> getPhraseSetSettings() {
    return getPhraseSetSettings;
  }

  /** Returns the object with the settings used for calls to listPhraseSet. */
  public PagedCallSettings<ListPhraseSetRequest, ListPhraseSetResponse, ListPhraseSetPagedResponse>
      listPhraseSetSettings() {
    return listPhraseSetSettings;
  }

  /** Returns the object with the settings used for calls to updatePhraseSet. */
  public UnaryCallSettings<UpdatePhraseSetRequest, PhraseSet> updatePhraseSetSettings() {
    return updatePhraseSetSettings;
  }

  /** Returns the object with the settings used for calls to deletePhraseSet. */
  public UnaryCallSettings<DeletePhraseSetRequest, Empty> deletePhraseSetSettings() {
    return deletePhraseSetSettings;
  }

  /** Returns the object with the settings used for calls to createCustomClass. */
  public UnaryCallSettings<CreateCustomClassRequest, CustomClass> createCustomClassSettings() {
    return createCustomClassSettings;
  }

  /** Returns the object with the settings used for calls to getCustomClass. */
  public UnaryCallSettings<GetCustomClassRequest, CustomClass> getCustomClassSettings() {
    return getCustomClassSettings;
  }

  /** Returns the object with the settings used for calls to listCustomClasses. */
  public PagedCallSettings<
          ListCustomClassesRequest, ListCustomClassesResponse, ListCustomClassesPagedResponse>
      listCustomClassesSettings() {
    return listCustomClassesSettings;
  }

  /** Returns the object with the settings used for calls to updateCustomClass. */
  public UnaryCallSettings<UpdateCustomClassRequest, CustomClass> updateCustomClassSettings() {
    return updateCustomClassSettings;
  }

  /** Returns the object with the settings used for calls to deleteCustomClass. */
  public UnaryCallSettings<DeleteCustomClassRequest, Empty> deleteCustomClassSettings() {
    return deleteCustomClassSettings;
  }

  public AdaptationStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcAdaptationStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonAdaptationStub.create(this);
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
    return "speech.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "speech.mtls.googleapis.com:443";
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

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultGrpcApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(AdaptationStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(AdaptationStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return AdaptationStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected AdaptationStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createPhraseSetSettings = settingsBuilder.createPhraseSetSettings().build();
    getPhraseSetSettings = settingsBuilder.getPhraseSetSettings().build();
    listPhraseSetSettings = settingsBuilder.listPhraseSetSettings().build();
    updatePhraseSetSettings = settingsBuilder.updatePhraseSetSettings().build();
    deletePhraseSetSettings = settingsBuilder.deletePhraseSetSettings().build();
    createCustomClassSettings = settingsBuilder.createCustomClassSettings().build();
    getCustomClassSettings = settingsBuilder.getCustomClassSettings().build();
    listCustomClassesSettings = settingsBuilder.listCustomClassesSettings().build();
    updateCustomClassSettings = settingsBuilder.updateCustomClassSettings().build();
    deleteCustomClassSettings = settingsBuilder.deleteCustomClassSettings().build();
  }

  /** Builder for AdaptationStubSettings. */
  public static class Builder extends StubSettings.Builder<AdaptationStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreatePhraseSetRequest, PhraseSet>
        createPhraseSetSettings;
    private final UnaryCallSettings.Builder<GetPhraseSetRequest, PhraseSet> getPhraseSetSettings;
    private final PagedCallSettings.Builder<
            ListPhraseSetRequest, ListPhraseSetResponse, ListPhraseSetPagedResponse>
        listPhraseSetSettings;
    private final UnaryCallSettings.Builder<UpdatePhraseSetRequest, PhraseSet>
        updatePhraseSetSettings;
    private final UnaryCallSettings.Builder<DeletePhraseSetRequest, Empty> deletePhraseSetSettings;
    private final UnaryCallSettings.Builder<CreateCustomClassRequest, CustomClass>
        createCustomClassSettings;
    private final UnaryCallSettings.Builder<GetCustomClassRequest, CustomClass>
        getCustomClassSettings;
    private final PagedCallSettings.Builder<
            ListCustomClassesRequest, ListCustomClassesResponse, ListCustomClassesPagedResponse>
        listCustomClassesSettings;
    private final UnaryCallSettings.Builder<UpdateCustomClassRequest, CustomClass>
        updateCustomClassSettings;
    private final UnaryCallSettings.Builder<DeleteCustomClassRequest, Empty>
        deleteCustomClassSettings;
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

      createPhraseSetSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getPhraseSetSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listPhraseSetSettings = PagedCallSettings.newBuilder(LIST_PHRASE_SET_PAGE_STR_FACT);
      updatePhraseSetSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deletePhraseSetSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createCustomClassSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getCustomClassSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listCustomClassesSettings = PagedCallSettings.newBuilder(LIST_CUSTOM_CLASSES_PAGE_STR_FACT);
      updateCustomClassSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteCustomClassSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createPhraseSetSettings,
              getPhraseSetSettings,
              listPhraseSetSettings,
              updatePhraseSetSettings,
              deletePhraseSetSettings,
              createCustomClassSettings,
              getCustomClassSettings,
              listCustomClassesSettings,
              updateCustomClassSettings,
              deleteCustomClassSettings);
      initDefaults(this);
    }

    protected Builder(AdaptationStubSettings settings) {
      super(settings);

      createPhraseSetSettings = settings.createPhraseSetSettings.toBuilder();
      getPhraseSetSettings = settings.getPhraseSetSettings.toBuilder();
      listPhraseSetSettings = settings.listPhraseSetSettings.toBuilder();
      updatePhraseSetSettings = settings.updatePhraseSetSettings.toBuilder();
      deletePhraseSetSettings = settings.deletePhraseSetSettings.toBuilder();
      createCustomClassSettings = settings.createCustomClassSettings.toBuilder();
      getCustomClassSettings = settings.getCustomClassSettings.toBuilder();
      listCustomClassesSettings = settings.listCustomClassesSettings.toBuilder();
      updateCustomClassSettings = settings.updateCustomClassSettings.toBuilder();
      deleteCustomClassSettings = settings.deleteCustomClassSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createPhraseSetSettings,
              getPhraseSetSettings,
              listPhraseSetSettings,
              updatePhraseSetSettings,
              deletePhraseSetSettings,
              createCustomClassSettings,
              getCustomClassSettings,
              listCustomClassesSettings,
              updateCustomClassSettings,
              deleteCustomClassSettings);
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

    private static Builder createHttpJsonDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultHttpJsonTransportProviderBuilder().build());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultHttpJsonApiClientHeaderProviderBuilder().build());
      builder.setEndpoint(getDefaultEndpoint());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {
      builder
          .createPhraseSetSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getPhraseSetSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listPhraseSetSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updatePhraseSetSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deletePhraseSetSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createCustomClassSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getCustomClassSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listCustomClassesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateCustomClassSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteCustomClassSettings()
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

    /** Returns the builder for the settings used for calls to createPhraseSet. */
    public UnaryCallSettings.Builder<CreatePhraseSetRequest, PhraseSet> createPhraseSetSettings() {
      return createPhraseSetSettings;
    }

    /** Returns the builder for the settings used for calls to getPhraseSet. */
    public UnaryCallSettings.Builder<GetPhraseSetRequest, PhraseSet> getPhraseSetSettings() {
      return getPhraseSetSettings;
    }

    /** Returns the builder for the settings used for calls to listPhraseSet. */
    public PagedCallSettings.Builder<
            ListPhraseSetRequest, ListPhraseSetResponse, ListPhraseSetPagedResponse>
        listPhraseSetSettings() {
      return listPhraseSetSettings;
    }

    /** Returns the builder for the settings used for calls to updatePhraseSet. */
    public UnaryCallSettings.Builder<UpdatePhraseSetRequest, PhraseSet> updatePhraseSetSettings() {
      return updatePhraseSetSettings;
    }

    /** Returns the builder for the settings used for calls to deletePhraseSet. */
    public UnaryCallSettings.Builder<DeletePhraseSetRequest, Empty> deletePhraseSetSettings() {
      return deletePhraseSetSettings;
    }

    /** Returns the builder for the settings used for calls to createCustomClass. */
    public UnaryCallSettings.Builder<CreateCustomClassRequest, CustomClass>
        createCustomClassSettings() {
      return createCustomClassSettings;
    }

    /** Returns the builder for the settings used for calls to getCustomClass. */
    public UnaryCallSettings.Builder<GetCustomClassRequest, CustomClass> getCustomClassSettings() {
      return getCustomClassSettings;
    }

    /** Returns the builder for the settings used for calls to listCustomClasses. */
    public PagedCallSettings.Builder<
            ListCustomClassesRequest, ListCustomClassesResponse, ListCustomClassesPagedResponse>
        listCustomClassesSettings() {
      return listCustomClassesSettings;
    }

    /** Returns the builder for the settings used for calls to updateCustomClass. */
    public UnaryCallSettings.Builder<UpdateCustomClassRequest, CustomClass>
        updateCustomClassSettings() {
      return updateCustomClassSettings;
    }

    /** Returns the builder for the settings used for calls to deleteCustomClass. */
    public UnaryCallSettings.Builder<DeleteCustomClassRequest, Empty> deleteCustomClassSettings() {
      return deleteCustomClassSettings;
    }

    @Override
    public AdaptationStubSettings build() throws IOException {
      return new AdaptationStubSettings(this);
    }
  }
}
