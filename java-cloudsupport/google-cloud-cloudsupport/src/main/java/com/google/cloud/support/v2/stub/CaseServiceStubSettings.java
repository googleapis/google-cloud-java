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

package com.google.cloud.support.v2.stub;

import static com.google.cloud.support.v2.CaseServiceClient.ListCasesPagedResponse;
import static com.google.cloud.support.v2.CaseServiceClient.SearchCaseClassificationsPagedResponse;
import static com.google.cloud.support.v2.CaseServiceClient.SearchCasesPagedResponse;

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
import com.google.cloud.support.v2.Case;
import com.google.cloud.support.v2.CaseClassification;
import com.google.cloud.support.v2.CloseCaseRequest;
import com.google.cloud.support.v2.CreateCaseRequest;
import com.google.cloud.support.v2.EscalateCaseRequest;
import com.google.cloud.support.v2.GetCaseRequest;
import com.google.cloud.support.v2.ListCasesRequest;
import com.google.cloud.support.v2.ListCasesResponse;
import com.google.cloud.support.v2.SearchCaseClassificationsRequest;
import com.google.cloud.support.v2.SearchCaseClassificationsResponse;
import com.google.cloud.support.v2.SearchCasesRequest;
import com.google.cloud.support.v2.SearchCasesResponse;
import com.google.cloud.support.v2.UpdateCaseRequest;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link CaseServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (cloudsupport.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getCase to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * CaseServiceStubSettings.Builder caseServiceSettingsBuilder =
 *     CaseServiceStubSettings.newBuilder();
 * caseServiceSettingsBuilder
 *     .getCaseSettings()
 *     .setRetrySettings(
 *         caseServiceSettingsBuilder
 *             .getCaseSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * CaseServiceStubSettings caseServiceSettings = caseServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class CaseServiceStubSettings extends StubSettings<CaseServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<GetCaseRequest, Case> getCaseSettings;
  private final PagedCallSettings<ListCasesRequest, ListCasesResponse, ListCasesPagedResponse>
      listCasesSettings;
  private final PagedCallSettings<SearchCasesRequest, SearchCasesResponse, SearchCasesPagedResponse>
      searchCasesSettings;
  private final UnaryCallSettings<CreateCaseRequest, Case> createCaseSettings;
  private final UnaryCallSettings<UpdateCaseRequest, Case> updateCaseSettings;
  private final UnaryCallSettings<EscalateCaseRequest, Case> escalateCaseSettings;
  private final UnaryCallSettings<CloseCaseRequest, Case> closeCaseSettings;
  private final PagedCallSettings<
          SearchCaseClassificationsRequest,
          SearchCaseClassificationsResponse,
          SearchCaseClassificationsPagedResponse>
      searchCaseClassificationsSettings;

  private static final PagedListDescriptor<ListCasesRequest, ListCasesResponse, Case>
      LIST_CASES_PAGE_STR_DESC =
          new PagedListDescriptor<ListCasesRequest, ListCasesResponse, Case>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListCasesRequest injectToken(ListCasesRequest payload, String token) {
              return ListCasesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListCasesRequest injectPageSize(ListCasesRequest payload, int pageSize) {
              return ListCasesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListCasesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListCasesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Case> extractResources(ListCasesResponse payload) {
              return payload.getCasesList() == null
                  ? ImmutableList.<Case>of()
                  : payload.getCasesList();
            }
          };

  private static final PagedListDescriptor<SearchCasesRequest, SearchCasesResponse, Case>
      SEARCH_CASES_PAGE_STR_DESC =
          new PagedListDescriptor<SearchCasesRequest, SearchCasesResponse, Case>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public SearchCasesRequest injectToken(SearchCasesRequest payload, String token) {
              return SearchCasesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public SearchCasesRequest injectPageSize(SearchCasesRequest payload, int pageSize) {
              return SearchCasesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(SearchCasesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(SearchCasesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Case> extractResources(SearchCasesResponse payload) {
              return payload.getCasesList() == null
                  ? ImmutableList.<Case>of()
                  : payload.getCasesList();
            }
          };

  private static final PagedListDescriptor<
          SearchCaseClassificationsRequest, SearchCaseClassificationsResponse, CaseClassification>
      SEARCH_CASE_CLASSIFICATIONS_PAGE_STR_DESC =
          new PagedListDescriptor<
              SearchCaseClassificationsRequest,
              SearchCaseClassificationsResponse,
              CaseClassification>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public SearchCaseClassificationsRequest injectToken(
                SearchCaseClassificationsRequest payload, String token) {
              return SearchCaseClassificationsRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public SearchCaseClassificationsRequest injectPageSize(
                SearchCaseClassificationsRequest payload, int pageSize) {
              return SearchCaseClassificationsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(SearchCaseClassificationsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(SearchCaseClassificationsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<CaseClassification> extractResources(
                SearchCaseClassificationsResponse payload) {
              return payload.getCaseClassificationsList() == null
                  ? ImmutableList.<CaseClassification>of()
                  : payload.getCaseClassificationsList();
            }
          };

  private static final PagedListResponseFactory<
          ListCasesRequest, ListCasesResponse, ListCasesPagedResponse>
      LIST_CASES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListCasesRequest, ListCasesResponse, ListCasesPagedResponse>() {
            @Override
            public ApiFuture<ListCasesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListCasesRequest, ListCasesResponse> callable,
                ListCasesRequest request,
                ApiCallContext context,
                ApiFuture<ListCasesResponse> futureResponse) {
              PageContext<ListCasesRequest, ListCasesResponse, Case> pageContext =
                  PageContext.create(callable, LIST_CASES_PAGE_STR_DESC, request, context);
              return ListCasesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          SearchCasesRequest, SearchCasesResponse, SearchCasesPagedResponse>
      SEARCH_CASES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              SearchCasesRequest, SearchCasesResponse, SearchCasesPagedResponse>() {
            @Override
            public ApiFuture<SearchCasesPagedResponse> getFuturePagedResponse(
                UnaryCallable<SearchCasesRequest, SearchCasesResponse> callable,
                SearchCasesRequest request,
                ApiCallContext context,
                ApiFuture<SearchCasesResponse> futureResponse) {
              PageContext<SearchCasesRequest, SearchCasesResponse, Case> pageContext =
                  PageContext.create(callable, SEARCH_CASES_PAGE_STR_DESC, request, context);
              return SearchCasesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          SearchCaseClassificationsRequest,
          SearchCaseClassificationsResponse,
          SearchCaseClassificationsPagedResponse>
      SEARCH_CASE_CLASSIFICATIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              SearchCaseClassificationsRequest,
              SearchCaseClassificationsResponse,
              SearchCaseClassificationsPagedResponse>() {
            @Override
            public ApiFuture<SearchCaseClassificationsPagedResponse> getFuturePagedResponse(
                UnaryCallable<SearchCaseClassificationsRequest, SearchCaseClassificationsResponse>
                    callable,
                SearchCaseClassificationsRequest request,
                ApiCallContext context,
                ApiFuture<SearchCaseClassificationsResponse> futureResponse) {
              PageContext<
                      SearchCaseClassificationsRequest,
                      SearchCaseClassificationsResponse,
                      CaseClassification>
                  pageContext =
                      PageContext.create(
                          callable, SEARCH_CASE_CLASSIFICATIONS_PAGE_STR_DESC, request, context);
              return SearchCaseClassificationsPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to getCase. */
  public UnaryCallSettings<GetCaseRequest, Case> getCaseSettings() {
    return getCaseSettings;
  }

  /** Returns the object with the settings used for calls to listCases. */
  public PagedCallSettings<ListCasesRequest, ListCasesResponse, ListCasesPagedResponse>
      listCasesSettings() {
    return listCasesSettings;
  }

  /** Returns the object with the settings used for calls to searchCases. */
  public PagedCallSettings<SearchCasesRequest, SearchCasesResponse, SearchCasesPagedResponse>
      searchCasesSettings() {
    return searchCasesSettings;
  }

  /** Returns the object with the settings used for calls to createCase. */
  public UnaryCallSettings<CreateCaseRequest, Case> createCaseSettings() {
    return createCaseSettings;
  }

  /** Returns the object with the settings used for calls to updateCase. */
  public UnaryCallSettings<UpdateCaseRequest, Case> updateCaseSettings() {
    return updateCaseSettings;
  }

  /** Returns the object with the settings used for calls to escalateCase. */
  public UnaryCallSettings<EscalateCaseRequest, Case> escalateCaseSettings() {
    return escalateCaseSettings;
  }

  /** Returns the object with the settings used for calls to closeCase. */
  public UnaryCallSettings<CloseCaseRequest, Case> closeCaseSettings() {
    return closeCaseSettings;
  }

  /** Returns the object with the settings used for calls to searchCaseClassifications. */
  public PagedCallSettings<
          SearchCaseClassificationsRequest,
          SearchCaseClassificationsResponse,
          SearchCaseClassificationsPagedResponse>
      searchCaseClassificationsSettings() {
    return searchCaseClassificationsSettings;
  }

  public CaseServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcCaseServiceStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonCaseServiceStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "cloudsupport";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "cloudsupport.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "cloudsupport.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(CaseServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(CaseServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return CaseServiceStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected CaseServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    getCaseSettings = settingsBuilder.getCaseSettings().build();
    listCasesSettings = settingsBuilder.listCasesSettings().build();
    searchCasesSettings = settingsBuilder.searchCasesSettings().build();
    createCaseSettings = settingsBuilder.createCaseSettings().build();
    updateCaseSettings = settingsBuilder.updateCaseSettings().build();
    escalateCaseSettings = settingsBuilder.escalateCaseSettings().build();
    closeCaseSettings = settingsBuilder.closeCaseSettings().build();
    searchCaseClassificationsSettings = settingsBuilder.searchCaseClassificationsSettings().build();
  }

  /** Builder for CaseServiceStubSettings. */
  public static class Builder extends StubSettings.Builder<CaseServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<GetCaseRequest, Case> getCaseSettings;
    private final PagedCallSettings.Builder<
            ListCasesRequest, ListCasesResponse, ListCasesPagedResponse>
        listCasesSettings;
    private final PagedCallSettings.Builder<
            SearchCasesRequest, SearchCasesResponse, SearchCasesPagedResponse>
        searchCasesSettings;
    private final UnaryCallSettings.Builder<CreateCaseRequest, Case> createCaseSettings;
    private final UnaryCallSettings.Builder<UpdateCaseRequest, Case> updateCaseSettings;
    private final UnaryCallSettings.Builder<EscalateCaseRequest, Case> escalateCaseSettings;
    private final UnaryCallSettings.Builder<CloseCaseRequest, Case> closeCaseSettings;
    private final PagedCallSettings.Builder<
            SearchCaseClassificationsRequest,
            SearchCaseClassificationsResponse,
            SearchCaseClassificationsPagedResponse>
        searchCaseClassificationsSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "retry_policy_0_codes",
          ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList(StatusCode.Code.UNAVAILABLE)));
      definitions.put(
          "no_retry_1_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
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
              .setInitialRpcTimeout(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(60000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeout(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(60000L))
              .build();
      definitions.put("no_retry_1_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      getCaseSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listCasesSettings = PagedCallSettings.newBuilder(LIST_CASES_PAGE_STR_FACT);
      searchCasesSettings = PagedCallSettings.newBuilder(SEARCH_CASES_PAGE_STR_FACT);
      createCaseSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateCaseSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      escalateCaseSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      closeCaseSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      searchCaseClassificationsSettings =
          PagedCallSettings.newBuilder(SEARCH_CASE_CLASSIFICATIONS_PAGE_STR_FACT);

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getCaseSettings,
              listCasesSettings,
              searchCasesSettings,
              createCaseSettings,
              updateCaseSettings,
              escalateCaseSettings,
              closeCaseSettings,
              searchCaseClassificationsSettings);
      initDefaults(this);
    }

    protected Builder(CaseServiceStubSettings settings) {
      super(settings);

      getCaseSettings = settings.getCaseSettings.toBuilder();
      listCasesSettings = settings.listCasesSettings.toBuilder();
      searchCasesSettings = settings.searchCasesSettings.toBuilder();
      createCaseSettings = settings.createCaseSettings.toBuilder();
      updateCaseSettings = settings.updateCaseSettings.toBuilder();
      escalateCaseSettings = settings.escalateCaseSettings.toBuilder();
      closeCaseSettings = settings.closeCaseSettings.toBuilder();
      searchCaseClassificationsSettings = settings.searchCaseClassificationsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getCaseSettings,
              listCasesSettings,
              searchCasesSettings,
              createCaseSettings,
              updateCaseSettings,
              escalateCaseSettings,
              closeCaseSettings,
              searchCaseClassificationsSettings);
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
          .getCaseSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listCasesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .searchCasesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createCaseSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateCaseSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .escalateCaseSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .closeCaseSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .searchCaseClassificationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

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

    /** Returns the builder for the settings used for calls to getCase. */
    public UnaryCallSettings.Builder<GetCaseRequest, Case> getCaseSettings() {
      return getCaseSettings;
    }

    /** Returns the builder for the settings used for calls to listCases. */
    public PagedCallSettings.Builder<ListCasesRequest, ListCasesResponse, ListCasesPagedResponse>
        listCasesSettings() {
      return listCasesSettings;
    }

    /** Returns the builder for the settings used for calls to searchCases. */
    public PagedCallSettings.Builder<
            SearchCasesRequest, SearchCasesResponse, SearchCasesPagedResponse>
        searchCasesSettings() {
      return searchCasesSettings;
    }

    /** Returns the builder for the settings used for calls to createCase. */
    public UnaryCallSettings.Builder<CreateCaseRequest, Case> createCaseSettings() {
      return createCaseSettings;
    }

    /** Returns the builder for the settings used for calls to updateCase. */
    public UnaryCallSettings.Builder<UpdateCaseRequest, Case> updateCaseSettings() {
      return updateCaseSettings;
    }

    /** Returns the builder for the settings used for calls to escalateCase. */
    public UnaryCallSettings.Builder<EscalateCaseRequest, Case> escalateCaseSettings() {
      return escalateCaseSettings;
    }

    /** Returns the builder for the settings used for calls to closeCase. */
    public UnaryCallSettings.Builder<CloseCaseRequest, Case> closeCaseSettings() {
      return closeCaseSettings;
    }

    /** Returns the builder for the settings used for calls to searchCaseClassifications. */
    public PagedCallSettings.Builder<
            SearchCaseClassificationsRequest,
            SearchCaseClassificationsResponse,
            SearchCaseClassificationsPagedResponse>
        searchCaseClassificationsSettings() {
      return searchCaseClassificationsSettings;
    }

    @Override
    public CaseServiceStubSettings build() throws IOException {
      return new CaseServiceStubSettings(this);
    }
  }
}
