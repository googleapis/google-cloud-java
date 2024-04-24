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

package com.google.cloud.discoveryengine.v1beta.stub;

import static com.google.cloud.discoveryengine.v1beta.SiteSearchEngineServiceClient.FetchDomainVerificationStatusPagedResponse;
import static com.google.cloud.discoveryengine.v1beta.SiteSearchEngineServiceClient.ListTargetSitesPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.grpc.ProtoOperationTransformers;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.HttpJsonTransportChannel;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.longrunning.OperationSnapshot;
import com.google.api.gax.longrunning.OperationTimedPollAlgorithm;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.PagedListDescriptor;
import com.google.api.gax.rpc.PagedListResponseFactory;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.discoveryengine.v1beta.BatchCreateTargetSiteMetadata;
import com.google.cloud.discoveryengine.v1beta.BatchCreateTargetSitesRequest;
import com.google.cloud.discoveryengine.v1beta.BatchCreateTargetSitesResponse;
import com.google.cloud.discoveryengine.v1beta.BatchVerifyTargetSitesMetadata;
import com.google.cloud.discoveryengine.v1beta.BatchVerifyTargetSitesRequest;
import com.google.cloud.discoveryengine.v1beta.BatchVerifyTargetSitesResponse;
import com.google.cloud.discoveryengine.v1beta.CreateTargetSiteMetadata;
import com.google.cloud.discoveryengine.v1beta.CreateTargetSiteRequest;
import com.google.cloud.discoveryengine.v1beta.DeleteTargetSiteMetadata;
import com.google.cloud.discoveryengine.v1beta.DeleteTargetSiteRequest;
import com.google.cloud.discoveryengine.v1beta.DisableAdvancedSiteSearchMetadata;
import com.google.cloud.discoveryengine.v1beta.DisableAdvancedSiteSearchRequest;
import com.google.cloud.discoveryengine.v1beta.DisableAdvancedSiteSearchResponse;
import com.google.cloud.discoveryengine.v1beta.EnableAdvancedSiteSearchMetadata;
import com.google.cloud.discoveryengine.v1beta.EnableAdvancedSiteSearchRequest;
import com.google.cloud.discoveryengine.v1beta.EnableAdvancedSiteSearchResponse;
import com.google.cloud.discoveryengine.v1beta.FetchDomainVerificationStatusRequest;
import com.google.cloud.discoveryengine.v1beta.FetchDomainVerificationStatusResponse;
import com.google.cloud.discoveryengine.v1beta.GetSiteSearchEngineRequest;
import com.google.cloud.discoveryengine.v1beta.GetTargetSiteRequest;
import com.google.cloud.discoveryengine.v1beta.ListTargetSitesRequest;
import com.google.cloud.discoveryengine.v1beta.ListTargetSitesResponse;
import com.google.cloud.discoveryengine.v1beta.RecrawlUrisMetadata;
import com.google.cloud.discoveryengine.v1beta.RecrawlUrisRequest;
import com.google.cloud.discoveryengine.v1beta.RecrawlUrisResponse;
import com.google.cloud.discoveryengine.v1beta.SiteSearchEngine;
import com.google.cloud.discoveryengine.v1beta.TargetSite;
import com.google.cloud.discoveryengine.v1beta.UpdateTargetSiteMetadata;
import com.google.cloud.discoveryengine.v1beta.UpdateTargetSiteRequest;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link SiteSearchEngineServiceStub}.
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
 * <p>For example, to set the total timeout of getSiteSearchEngine to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * SiteSearchEngineServiceStubSettings.Builder siteSearchEngineServiceSettingsBuilder =
 *     SiteSearchEngineServiceStubSettings.newBuilder();
 * siteSearchEngineServiceSettingsBuilder
 *     .getSiteSearchEngineSettings()
 *     .setRetrySettings(
 *         siteSearchEngineServiceSettingsBuilder
 *             .getSiteSearchEngineSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * SiteSearchEngineServiceStubSettings siteSearchEngineServiceSettings =
 *     siteSearchEngineServiceSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class SiteSearchEngineServiceStubSettings
    extends StubSettings<SiteSearchEngineServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<GetSiteSearchEngineRequest, SiteSearchEngine>
      getSiteSearchEngineSettings;
  private final UnaryCallSettings<CreateTargetSiteRequest, Operation> createTargetSiteSettings;
  private final OperationCallSettings<CreateTargetSiteRequest, TargetSite, CreateTargetSiteMetadata>
      createTargetSiteOperationSettings;
  private final UnaryCallSettings<BatchCreateTargetSitesRequest, Operation>
      batchCreateTargetSitesSettings;
  private final OperationCallSettings<
          BatchCreateTargetSitesRequest,
          BatchCreateTargetSitesResponse,
          BatchCreateTargetSiteMetadata>
      batchCreateTargetSitesOperationSettings;
  private final UnaryCallSettings<GetTargetSiteRequest, TargetSite> getTargetSiteSettings;
  private final UnaryCallSettings<UpdateTargetSiteRequest, Operation> updateTargetSiteSettings;
  private final OperationCallSettings<UpdateTargetSiteRequest, TargetSite, UpdateTargetSiteMetadata>
      updateTargetSiteOperationSettings;
  private final UnaryCallSettings<DeleteTargetSiteRequest, Operation> deleteTargetSiteSettings;
  private final OperationCallSettings<DeleteTargetSiteRequest, Empty, DeleteTargetSiteMetadata>
      deleteTargetSiteOperationSettings;
  private final PagedCallSettings<
          ListTargetSitesRequest, ListTargetSitesResponse, ListTargetSitesPagedResponse>
      listTargetSitesSettings;
  private final UnaryCallSettings<EnableAdvancedSiteSearchRequest, Operation>
      enableAdvancedSiteSearchSettings;
  private final OperationCallSettings<
          EnableAdvancedSiteSearchRequest,
          EnableAdvancedSiteSearchResponse,
          EnableAdvancedSiteSearchMetadata>
      enableAdvancedSiteSearchOperationSettings;
  private final UnaryCallSettings<DisableAdvancedSiteSearchRequest, Operation>
      disableAdvancedSiteSearchSettings;
  private final OperationCallSettings<
          DisableAdvancedSiteSearchRequest,
          DisableAdvancedSiteSearchResponse,
          DisableAdvancedSiteSearchMetadata>
      disableAdvancedSiteSearchOperationSettings;
  private final UnaryCallSettings<RecrawlUrisRequest, Operation> recrawlUrisSettings;
  private final OperationCallSettings<RecrawlUrisRequest, RecrawlUrisResponse, RecrawlUrisMetadata>
      recrawlUrisOperationSettings;
  private final UnaryCallSettings<BatchVerifyTargetSitesRequest, Operation>
      batchVerifyTargetSitesSettings;
  private final OperationCallSettings<
          BatchVerifyTargetSitesRequest,
          BatchVerifyTargetSitesResponse,
          BatchVerifyTargetSitesMetadata>
      batchVerifyTargetSitesOperationSettings;
  private final PagedCallSettings<
          FetchDomainVerificationStatusRequest,
          FetchDomainVerificationStatusResponse,
          FetchDomainVerificationStatusPagedResponse>
      fetchDomainVerificationStatusSettings;

  private static final PagedListDescriptor<
          ListTargetSitesRequest, ListTargetSitesResponse, TargetSite>
      LIST_TARGET_SITES_PAGE_STR_DESC =
          new PagedListDescriptor<ListTargetSitesRequest, ListTargetSitesResponse, TargetSite>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListTargetSitesRequest injectToken(
                ListTargetSitesRequest payload, String token) {
              return ListTargetSitesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListTargetSitesRequest injectPageSize(
                ListTargetSitesRequest payload, int pageSize) {
              return ListTargetSitesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListTargetSitesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListTargetSitesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<TargetSite> extractResources(ListTargetSitesResponse payload) {
              return payload.getTargetSitesList() == null
                  ? ImmutableList.<TargetSite>of()
                  : payload.getTargetSitesList();
            }
          };

  private static final PagedListDescriptor<
          FetchDomainVerificationStatusRequest, FetchDomainVerificationStatusResponse, TargetSite>
      FETCH_DOMAIN_VERIFICATION_STATUS_PAGE_STR_DESC =
          new PagedListDescriptor<
              FetchDomainVerificationStatusRequest,
              FetchDomainVerificationStatusResponse,
              TargetSite>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public FetchDomainVerificationStatusRequest injectToken(
                FetchDomainVerificationStatusRequest payload, String token) {
              return FetchDomainVerificationStatusRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public FetchDomainVerificationStatusRequest injectPageSize(
                FetchDomainVerificationStatusRequest payload, int pageSize) {
              return FetchDomainVerificationStatusRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(FetchDomainVerificationStatusRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(FetchDomainVerificationStatusResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<TargetSite> extractResources(
                FetchDomainVerificationStatusResponse payload) {
              return payload.getTargetSitesList() == null
                  ? ImmutableList.<TargetSite>of()
                  : payload.getTargetSitesList();
            }
          };

  private static final PagedListResponseFactory<
          ListTargetSitesRequest, ListTargetSitesResponse, ListTargetSitesPagedResponse>
      LIST_TARGET_SITES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListTargetSitesRequest, ListTargetSitesResponse, ListTargetSitesPagedResponse>() {
            @Override
            public ApiFuture<ListTargetSitesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListTargetSitesRequest, ListTargetSitesResponse> callable,
                ListTargetSitesRequest request,
                ApiCallContext context,
                ApiFuture<ListTargetSitesResponse> futureResponse) {
              PageContext<ListTargetSitesRequest, ListTargetSitesResponse, TargetSite> pageContext =
                  PageContext.create(callable, LIST_TARGET_SITES_PAGE_STR_DESC, request, context);
              return ListTargetSitesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          FetchDomainVerificationStatusRequest,
          FetchDomainVerificationStatusResponse,
          FetchDomainVerificationStatusPagedResponse>
      FETCH_DOMAIN_VERIFICATION_STATUS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              FetchDomainVerificationStatusRequest,
              FetchDomainVerificationStatusResponse,
              FetchDomainVerificationStatusPagedResponse>() {
            @Override
            public ApiFuture<FetchDomainVerificationStatusPagedResponse> getFuturePagedResponse(
                UnaryCallable<
                        FetchDomainVerificationStatusRequest, FetchDomainVerificationStatusResponse>
                    callable,
                FetchDomainVerificationStatusRequest request,
                ApiCallContext context,
                ApiFuture<FetchDomainVerificationStatusResponse> futureResponse) {
              PageContext<
                      FetchDomainVerificationStatusRequest,
                      FetchDomainVerificationStatusResponse,
                      TargetSite>
                  pageContext =
                      PageContext.create(
                          callable,
                          FETCH_DOMAIN_VERIFICATION_STATUS_PAGE_STR_DESC,
                          request,
                          context);
              return FetchDomainVerificationStatusPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to getSiteSearchEngine. */
  public UnaryCallSettings<GetSiteSearchEngineRequest, SiteSearchEngine>
      getSiteSearchEngineSettings() {
    return getSiteSearchEngineSettings;
  }

  /** Returns the object with the settings used for calls to createTargetSite. */
  public UnaryCallSettings<CreateTargetSiteRequest, Operation> createTargetSiteSettings() {
    return createTargetSiteSettings;
  }

  /** Returns the object with the settings used for calls to createTargetSite. */
  public OperationCallSettings<CreateTargetSiteRequest, TargetSite, CreateTargetSiteMetadata>
      createTargetSiteOperationSettings() {
    return createTargetSiteOperationSettings;
  }

  /** Returns the object with the settings used for calls to batchCreateTargetSites. */
  public UnaryCallSettings<BatchCreateTargetSitesRequest, Operation>
      batchCreateTargetSitesSettings() {
    return batchCreateTargetSitesSettings;
  }

  /** Returns the object with the settings used for calls to batchCreateTargetSites. */
  public OperationCallSettings<
          BatchCreateTargetSitesRequest,
          BatchCreateTargetSitesResponse,
          BatchCreateTargetSiteMetadata>
      batchCreateTargetSitesOperationSettings() {
    return batchCreateTargetSitesOperationSettings;
  }

  /** Returns the object with the settings used for calls to getTargetSite. */
  public UnaryCallSettings<GetTargetSiteRequest, TargetSite> getTargetSiteSettings() {
    return getTargetSiteSettings;
  }

  /** Returns the object with the settings used for calls to updateTargetSite. */
  public UnaryCallSettings<UpdateTargetSiteRequest, Operation> updateTargetSiteSettings() {
    return updateTargetSiteSettings;
  }

  /** Returns the object with the settings used for calls to updateTargetSite. */
  public OperationCallSettings<UpdateTargetSiteRequest, TargetSite, UpdateTargetSiteMetadata>
      updateTargetSiteOperationSettings() {
    return updateTargetSiteOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteTargetSite. */
  public UnaryCallSettings<DeleteTargetSiteRequest, Operation> deleteTargetSiteSettings() {
    return deleteTargetSiteSettings;
  }

  /** Returns the object with the settings used for calls to deleteTargetSite. */
  public OperationCallSettings<DeleteTargetSiteRequest, Empty, DeleteTargetSiteMetadata>
      deleteTargetSiteOperationSettings() {
    return deleteTargetSiteOperationSettings;
  }

  /** Returns the object with the settings used for calls to listTargetSites. */
  public PagedCallSettings<
          ListTargetSitesRequest, ListTargetSitesResponse, ListTargetSitesPagedResponse>
      listTargetSitesSettings() {
    return listTargetSitesSettings;
  }

  /** Returns the object with the settings used for calls to enableAdvancedSiteSearch. */
  public UnaryCallSettings<EnableAdvancedSiteSearchRequest, Operation>
      enableAdvancedSiteSearchSettings() {
    return enableAdvancedSiteSearchSettings;
  }

  /** Returns the object with the settings used for calls to enableAdvancedSiteSearch. */
  public OperationCallSettings<
          EnableAdvancedSiteSearchRequest,
          EnableAdvancedSiteSearchResponse,
          EnableAdvancedSiteSearchMetadata>
      enableAdvancedSiteSearchOperationSettings() {
    return enableAdvancedSiteSearchOperationSettings;
  }

  /** Returns the object with the settings used for calls to disableAdvancedSiteSearch. */
  public UnaryCallSettings<DisableAdvancedSiteSearchRequest, Operation>
      disableAdvancedSiteSearchSettings() {
    return disableAdvancedSiteSearchSettings;
  }

  /** Returns the object with the settings used for calls to disableAdvancedSiteSearch. */
  public OperationCallSettings<
          DisableAdvancedSiteSearchRequest,
          DisableAdvancedSiteSearchResponse,
          DisableAdvancedSiteSearchMetadata>
      disableAdvancedSiteSearchOperationSettings() {
    return disableAdvancedSiteSearchOperationSettings;
  }

  /** Returns the object with the settings used for calls to recrawlUris. */
  public UnaryCallSettings<RecrawlUrisRequest, Operation> recrawlUrisSettings() {
    return recrawlUrisSettings;
  }

  /** Returns the object with the settings used for calls to recrawlUris. */
  public OperationCallSettings<RecrawlUrisRequest, RecrawlUrisResponse, RecrawlUrisMetadata>
      recrawlUrisOperationSettings() {
    return recrawlUrisOperationSettings;
  }

  /** Returns the object with the settings used for calls to batchVerifyTargetSites. */
  public UnaryCallSettings<BatchVerifyTargetSitesRequest, Operation>
      batchVerifyTargetSitesSettings() {
    return batchVerifyTargetSitesSettings;
  }

  /** Returns the object with the settings used for calls to batchVerifyTargetSites. */
  public OperationCallSettings<
          BatchVerifyTargetSitesRequest,
          BatchVerifyTargetSitesResponse,
          BatchVerifyTargetSitesMetadata>
      batchVerifyTargetSitesOperationSettings() {
    return batchVerifyTargetSitesOperationSettings;
  }

  /** Returns the object with the settings used for calls to fetchDomainVerificationStatus. */
  public PagedCallSettings<
          FetchDomainVerificationStatusRequest,
          FetchDomainVerificationStatusResponse,
          FetchDomainVerificationStatusPagedResponse>
      fetchDomainVerificationStatusSettings() {
    return fetchDomainVerificationStatusSettings;
  }

  public SiteSearchEngineServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcSiteSearchEngineServiceStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonSiteSearchEngineServiceStub.create(this);
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
            "gapic", GaxProperties.getLibraryVersion(SiteSearchEngineServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(SiteSearchEngineServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return SiteSearchEngineServiceStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected SiteSearchEngineServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    getSiteSearchEngineSettings = settingsBuilder.getSiteSearchEngineSettings().build();
    createTargetSiteSettings = settingsBuilder.createTargetSiteSettings().build();
    createTargetSiteOperationSettings = settingsBuilder.createTargetSiteOperationSettings().build();
    batchCreateTargetSitesSettings = settingsBuilder.batchCreateTargetSitesSettings().build();
    batchCreateTargetSitesOperationSettings =
        settingsBuilder.batchCreateTargetSitesOperationSettings().build();
    getTargetSiteSettings = settingsBuilder.getTargetSiteSettings().build();
    updateTargetSiteSettings = settingsBuilder.updateTargetSiteSettings().build();
    updateTargetSiteOperationSettings = settingsBuilder.updateTargetSiteOperationSettings().build();
    deleteTargetSiteSettings = settingsBuilder.deleteTargetSiteSettings().build();
    deleteTargetSiteOperationSettings = settingsBuilder.deleteTargetSiteOperationSettings().build();
    listTargetSitesSettings = settingsBuilder.listTargetSitesSettings().build();
    enableAdvancedSiteSearchSettings = settingsBuilder.enableAdvancedSiteSearchSettings().build();
    enableAdvancedSiteSearchOperationSettings =
        settingsBuilder.enableAdvancedSiteSearchOperationSettings().build();
    disableAdvancedSiteSearchSettings = settingsBuilder.disableAdvancedSiteSearchSettings().build();
    disableAdvancedSiteSearchOperationSettings =
        settingsBuilder.disableAdvancedSiteSearchOperationSettings().build();
    recrawlUrisSettings = settingsBuilder.recrawlUrisSettings().build();
    recrawlUrisOperationSettings = settingsBuilder.recrawlUrisOperationSettings().build();
    batchVerifyTargetSitesSettings = settingsBuilder.batchVerifyTargetSitesSettings().build();
    batchVerifyTargetSitesOperationSettings =
        settingsBuilder.batchVerifyTargetSitesOperationSettings().build();
    fetchDomainVerificationStatusSettings =
        settingsBuilder.fetchDomainVerificationStatusSettings().build();
  }

  /** Builder for SiteSearchEngineServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<SiteSearchEngineServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<GetSiteSearchEngineRequest, SiteSearchEngine>
        getSiteSearchEngineSettings;
    private final UnaryCallSettings.Builder<CreateTargetSiteRequest, Operation>
        createTargetSiteSettings;
    private final OperationCallSettings.Builder<
            CreateTargetSiteRequest, TargetSite, CreateTargetSiteMetadata>
        createTargetSiteOperationSettings;
    private final UnaryCallSettings.Builder<BatchCreateTargetSitesRequest, Operation>
        batchCreateTargetSitesSettings;
    private final OperationCallSettings.Builder<
            BatchCreateTargetSitesRequest,
            BatchCreateTargetSitesResponse,
            BatchCreateTargetSiteMetadata>
        batchCreateTargetSitesOperationSettings;
    private final UnaryCallSettings.Builder<GetTargetSiteRequest, TargetSite> getTargetSiteSettings;
    private final UnaryCallSettings.Builder<UpdateTargetSiteRequest, Operation>
        updateTargetSiteSettings;
    private final OperationCallSettings.Builder<
            UpdateTargetSiteRequest, TargetSite, UpdateTargetSiteMetadata>
        updateTargetSiteOperationSettings;
    private final UnaryCallSettings.Builder<DeleteTargetSiteRequest, Operation>
        deleteTargetSiteSettings;
    private final OperationCallSettings.Builder<
            DeleteTargetSiteRequest, Empty, DeleteTargetSiteMetadata>
        deleteTargetSiteOperationSettings;
    private final PagedCallSettings.Builder<
            ListTargetSitesRequest, ListTargetSitesResponse, ListTargetSitesPagedResponse>
        listTargetSitesSettings;
    private final UnaryCallSettings.Builder<EnableAdvancedSiteSearchRequest, Operation>
        enableAdvancedSiteSearchSettings;
    private final OperationCallSettings.Builder<
            EnableAdvancedSiteSearchRequest,
            EnableAdvancedSiteSearchResponse,
            EnableAdvancedSiteSearchMetadata>
        enableAdvancedSiteSearchOperationSettings;
    private final UnaryCallSettings.Builder<DisableAdvancedSiteSearchRequest, Operation>
        disableAdvancedSiteSearchSettings;
    private final OperationCallSettings.Builder<
            DisableAdvancedSiteSearchRequest,
            DisableAdvancedSiteSearchResponse,
            DisableAdvancedSiteSearchMetadata>
        disableAdvancedSiteSearchOperationSettings;
    private final UnaryCallSettings.Builder<RecrawlUrisRequest, Operation> recrawlUrisSettings;
    private final OperationCallSettings.Builder<
            RecrawlUrisRequest, RecrawlUrisResponse, RecrawlUrisMetadata>
        recrawlUrisOperationSettings;
    private final UnaryCallSettings.Builder<BatchVerifyTargetSitesRequest, Operation>
        batchVerifyTargetSitesSettings;
    private final OperationCallSettings.Builder<
            BatchVerifyTargetSitesRequest,
            BatchVerifyTargetSitesResponse,
            BatchVerifyTargetSitesMetadata>
        batchVerifyTargetSitesOperationSettings;
    private final PagedCallSettings.Builder<
            FetchDomainVerificationStatusRequest,
            FetchDomainVerificationStatusResponse,
            FetchDomainVerificationStatusPagedResponse>
        fetchDomainVerificationStatusSettings;
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

      getSiteSearchEngineSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createTargetSiteSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createTargetSiteOperationSettings = OperationCallSettings.newBuilder();
      batchCreateTargetSitesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchCreateTargetSitesOperationSettings = OperationCallSettings.newBuilder();
      getTargetSiteSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateTargetSiteSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateTargetSiteOperationSettings = OperationCallSettings.newBuilder();
      deleteTargetSiteSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteTargetSiteOperationSettings = OperationCallSettings.newBuilder();
      listTargetSitesSettings = PagedCallSettings.newBuilder(LIST_TARGET_SITES_PAGE_STR_FACT);
      enableAdvancedSiteSearchSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      enableAdvancedSiteSearchOperationSettings = OperationCallSettings.newBuilder();
      disableAdvancedSiteSearchSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      disableAdvancedSiteSearchOperationSettings = OperationCallSettings.newBuilder();
      recrawlUrisSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      recrawlUrisOperationSettings = OperationCallSettings.newBuilder();
      batchVerifyTargetSitesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchVerifyTargetSitesOperationSettings = OperationCallSettings.newBuilder();
      fetchDomainVerificationStatusSettings =
          PagedCallSettings.newBuilder(FETCH_DOMAIN_VERIFICATION_STATUS_PAGE_STR_FACT);

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getSiteSearchEngineSettings,
              createTargetSiteSettings,
              batchCreateTargetSitesSettings,
              getTargetSiteSettings,
              updateTargetSiteSettings,
              deleteTargetSiteSettings,
              listTargetSitesSettings,
              enableAdvancedSiteSearchSettings,
              disableAdvancedSiteSearchSettings,
              recrawlUrisSettings,
              batchVerifyTargetSitesSettings,
              fetchDomainVerificationStatusSettings);
      initDefaults(this);
    }

    protected Builder(SiteSearchEngineServiceStubSettings settings) {
      super(settings);

      getSiteSearchEngineSettings = settings.getSiteSearchEngineSettings.toBuilder();
      createTargetSiteSettings = settings.createTargetSiteSettings.toBuilder();
      createTargetSiteOperationSettings = settings.createTargetSiteOperationSettings.toBuilder();
      batchCreateTargetSitesSettings = settings.batchCreateTargetSitesSettings.toBuilder();
      batchCreateTargetSitesOperationSettings =
          settings.batchCreateTargetSitesOperationSettings.toBuilder();
      getTargetSiteSettings = settings.getTargetSiteSettings.toBuilder();
      updateTargetSiteSettings = settings.updateTargetSiteSettings.toBuilder();
      updateTargetSiteOperationSettings = settings.updateTargetSiteOperationSettings.toBuilder();
      deleteTargetSiteSettings = settings.deleteTargetSiteSettings.toBuilder();
      deleteTargetSiteOperationSettings = settings.deleteTargetSiteOperationSettings.toBuilder();
      listTargetSitesSettings = settings.listTargetSitesSettings.toBuilder();
      enableAdvancedSiteSearchSettings = settings.enableAdvancedSiteSearchSettings.toBuilder();
      enableAdvancedSiteSearchOperationSettings =
          settings.enableAdvancedSiteSearchOperationSettings.toBuilder();
      disableAdvancedSiteSearchSettings = settings.disableAdvancedSiteSearchSettings.toBuilder();
      disableAdvancedSiteSearchOperationSettings =
          settings.disableAdvancedSiteSearchOperationSettings.toBuilder();
      recrawlUrisSettings = settings.recrawlUrisSettings.toBuilder();
      recrawlUrisOperationSettings = settings.recrawlUrisOperationSettings.toBuilder();
      batchVerifyTargetSitesSettings = settings.batchVerifyTargetSitesSettings.toBuilder();
      batchVerifyTargetSitesOperationSettings =
          settings.batchVerifyTargetSitesOperationSettings.toBuilder();
      fetchDomainVerificationStatusSettings =
          settings.fetchDomainVerificationStatusSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getSiteSearchEngineSettings,
              createTargetSiteSettings,
              batchCreateTargetSitesSettings,
              getTargetSiteSettings,
              updateTargetSiteSettings,
              deleteTargetSiteSettings,
              listTargetSitesSettings,
              enableAdvancedSiteSearchSettings,
              disableAdvancedSiteSearchSettings,
              recrawlUrisSettings,
              batchVerifyTargetSitesSettings,
              fetchDomainVerificationStatusSettings);
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
          .getSiteSearchEngineSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createTargetSiteSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .batchCreateTargetSitesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getTargetSiteSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateTargetSiteSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteTargetSiteSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listTargetSitesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .enableAdvancedSiteSearchSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .disableAdvancedSiteSearchSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .recrawlUrisSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .batchVerifyTargetSitesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .fetchDomainVerificationStatusSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createTargetSiteOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateTargetSiteRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(TargetSite.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(CreateTargetSiteMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .batchCreateTargetSitesOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<BatchCreateTargetSitesRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  BatchCreateTargetSitesResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  BatchCreateTargetSiteMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .updateTargetSiteOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateTargetSiteRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(TargetSite.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(UpdateTargetSiteMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deleteTargetSiteOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteTargetSiteRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(DeleteTargetSiteMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .enableAdvancedSiteSearchOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<EnableAdvancedSiteSearchRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  EnableAdvancedSiteSearchResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  EnableAdvancedSiteSearchMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .disableAdvancedSiteSearchOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DisableAdvancedSiteSearchRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  DisableAdvancedSiteSearchResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  DisableAdvancedSiteSearchMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .recrawlUrisOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<RecrawlUrisRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(RecrawlUrisResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(RecrawlUrisMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .batchVerifyTargetSitesOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<BatchVerifyTargetSitesRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  BatchVerifyTargetSitesResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  BatchVerifyTargetSitesMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

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

    /** Returns the builder for the settings used for calls to getSiteSearchEngine. */
    public UnaryCallSettings.Builder<GetSiteSearchEngineRequest, SiteSearchEngine>
        getSiteSearchEngineSettings() {
      return getSiteSearchEngineSettings;
    }

    /** Returns the builder for the settings used for calls to createTargetSite. */
    public UnaryCallSettings.Builder<CreateTargetSiteRequest, Operation>
        createTargetSiteSettings() {
      return createTargetSiteSettings;
    }

    /** Returns the builder for the settings used for calls to createTargetSite. */
    public OperationCallSettings.Builder<
            CreateTargetSiteRequest, TargetSite, CreateTargetSiteMetadata>
        createTargetSiteOperationSettings() {
      return createTargetSiteOperationSettings;
    }

    /** Returns the builder for the settings used for calls to batchCreateTargetSites. */
    public UnaryCallSettings.Builder<BatchCreateTargetSitesRequest, Operation>
        batchCreateTargetSitesSettings() {
      return batchCreateTargetSitesSettings;
    }

    /** Returns the builder for the settings used for calls to batchCreateTargetSites. */
    public OperationCallSettings.Builder<
            BatchCreateTargetSitesRequest,
            BatchCreateTargetSitesResponse,
            BatchCreateTargetSiteMetadata>
        batchCreateTargetSitesOperationSettings() {
      return batchCreateTargetSitesOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getTargetSite. */
    public UnaryCallSettings.Builder<GetTargetSiteRequest, TargetSite> getTargetSiteSettings() {
      return getTargetSiteSettings;
    }

    /** Returns the builder for the settings used for calls to updateTargetSite. */
    public UnaryCallSettings.Builder<UpdateTargetSiteRequest, Operation>
        updateTargetSiteSettings() {
      return updateTargetSiteSettings;
    }

    /** Returns the builder for the settings used for calls to updateTargetSite. */
    public OperationCallSettings.Builder<
            UpdateTargetSiteRequest, TargetSite, UpdateTargetSiteMetadata>
        updateTargetSiteOperationSettings() {
      return updateTargetSiteOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteTargetSite. */
    public UnaryCallSettings.Builder<DeleteTargetSiteRequest, Operation>
        deleteTargetSiteSettings() {
      return deleteTargetSiteSettings;
    }

    /** Returns the builder for the settings used for calls to deleteTargetSite. */
    public OperationCallSettings.Builder<DeleteTargetSiteRequest, Empty, DeleteTargetSiteMetadata>
        deleteTargetSiteOperationSettings() {
      return deleteTargetSiteOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listTargetSites. */
    public PagedCallSettings.Builder<
            ListTargetSitesRequest, ListTargetSitesResponse, ListTargetSitesPagedResponse>
        listTargetSitesSettings() {
      return listTargetSitesSettings;
    }

    /** Returns the builder for the settings used for calls to enableAdvancedSiteSearch. */
    public UnaryCallSettings.Builder<EnableAdvancedSiteSearchRequest, Operation>
        enableAdvancedSiteSearchSettings() {
      return enableAdvancedSiteSearchSettings;
    }

    /** Returns the builder for the settings used for calls to enableAdvancedSiteSearch. */
    public OperationCallSettings.Builder<
            EnableAdvancedSiteSearchRequest,
            EnableAdvancedSiteSearchResponse,
            EnableAdvancedSiteSearchMetadata>
        enableAdvancedSiteSearchOperationSettings() {
      return enableAdvancedSiteSearchOperationSettings;
    }

    /** Returns the builder for the settings used for calls to disableAdvancedSiteSearch. */
    public UnaryCallSettings.Builder<DisableAdvancedSiteSearchRequest, Operation>
        disableAdvancedSiteSearchSettings() {
      return disableAdvancedSiteSearchSettings;
    }

    /** Returns the builder for the settings used for calls to disableAdvancedSiteSearch. */
    public OperationCallSettings.Builder<
            DisableAdvancedSiteSearchRequest,
            DisableAdvancedSiteSearchResponse,
            DisableAdvancedSiteSearchMetadata>
        disableAdvancedSiteSearchOperationSettings() {
      return disableAdvancedSiteSearchOperationSettings;
    }

    /** Returns the builder for the settings used for calls to recrawlUris. */
    public UnaryCallSettings.Builder<RecrawlUrisRequest, Operation> recrawlUrisSettings() {
      return recrawlUrisSettings;
    }

    /** Returns the builder for the settings used for calls to recrawlUris. */
    public OperationCallSettings.Builder<
            RecrawlUrisRequest, RecrawlUrisResponse, RecrawlUrisMetadata>
        recrawlUrisOperationSettings() {
      return recrawlUrisOperationSettings;
    }

    /** Returns the builder for the settings used for calls to batchVerifyTargetSites. */
    public UnaryCallSettings.Builder<BatchVerifyTargetSitesRequest, Operation>
        batchVerifyTargetSitesSettings() {
      return batchVerifyTargetSitesSettings;
    }

    /** Returns the builder for the settings used for calls to batchVerifyTargetSites. */
    public OperationCallSettings.Builder<
            BatchVerifyTargetSitesRequest,
            BatchVerifyTargetSitesResponse,
            BatchVerifyTargetSitesMetadata>
        batchVerifyTargetSitesOperationSettings() {
      return batchVerifyTargetSitesOperationSettings;
    }

    /** Returns the builder for the settings used for calls to fetchDomainVerificationStatus. */
    public PagedCallSettings.Builder<
            FetchDomainVerificationStatusRequest,
            FetchDomainVerificationStatusResponse,
            FetchDomainVerificationStatusPagedResponse>
        fetchDomainVerificationStatusSettings() {
      return fetchDomainVerificationStatusSettings;
    }

    @Override
    public SiteSearchEngineServiceStubSettings build() throws IOException {
      return new SiteSearchEngineServiceStubSettings(this);
    }
  }
}
