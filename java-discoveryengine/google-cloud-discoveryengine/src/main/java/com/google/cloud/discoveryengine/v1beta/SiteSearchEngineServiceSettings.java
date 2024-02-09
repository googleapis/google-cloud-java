/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.discoveryengine.v1beta;

import static com.google.cloud.discoveryengine.v1beta.SiteSearchEngineServiceClient.FetchDomainVerificationStatusPagedResponse;
import static com.google.cloud.discoveryengine.v1beta.SiteSearchEngineServiceClient.ListTargetSitesPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.discoveryengine.v1beta.stub.SiteSearchEngineServiceStubSettings;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link SiteSearchEngineServiceClient}.
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
 * SiteSearchEngineServiceSettings.Builder siteSearchEngineServiceSettingsBuilder =
 *     SiteSearchEngineServiceSettings.newBuilder();
 * siteSearchEngineServiceSettingsBuilder
 *     .getSiteSearchEngineSettings()
 *     .setRetrySettings(
 *         siteSearchEngineServiceSettingsBuilder
 *             .getSiteSearchEngineSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * SiteSearchEngineServiceSettings siteSearchEngineServiceSettings =
 *     siteSearchEngineServiceSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class SiteSearchEngineServiceSettings
    extends ClientSettings<SiteSearchEngineServiceSettings> {

  /** Returns the object with the settings used for calls to getSiteSearchEngine. */
  public UnaryCallSettings<GetSiteSearchEngineRequest, SiteSearchEngine>
      getSiteSearchEngineSettings() {
    return ((SiteSearchEngineServiceStubSettings) getStubSettings()).getSiteSearchEngineSettings();
  }

  /** Returns the object with the settings used for calls to createTargetSite. */
  public UnaryCallSettings<CreateTargetSiteRequest, Operation> createTargetSiteSettings() {
    return ((SiteSearchEngineServiceStubSettings) getStubSettings()).createTargetSiteSettings();
  }

  /** Returns the object with the settings used for calls to createTargetSite. */
  public OperationCallSettings<CreateTargetSiteRequest, TargetSite, CreateTargetSiteMetadata>
      createTargetSiteOperationSettings() {
    return ((SiteSearchEngineServiceStubSettings) getStubSettings())
        .createTargetSiteOperationSettings();
  }

  /** Returns the object with the settings used for calls to batchCreateTargetSites. */
  public UnaryCallSettings<BatchCreateTargetSitesRequest, Operation>
      batchCreateTargetSitesSettings() {
    return ((SiteSearchEngineServiceStubSettings) getStubSettings())
        .batchCreateTargetSitesSettings();
  }

  /** Returns the object with the settings used for calls to batchCreateTargetSites. */
  public OperationCallSettings<
          BatchCreateTargetSitesRequest,
          BatchCreateTargetSitesResponse,
          BatchCreateTargetSiteMetadata>
      batchCreateTargetSitesOperationSettings() {
    return ((SiteSearchEngineServiceStubSettings) getStubSettings())
        .batchCreateTargetSitesOperationSettings();
  }

  /** Returns the object with the settings used for calls to getTargetSite. */
  public UnaryCallSettings<GetTargetSiteRequest, TargetSite> getTargetSiteSettings() {
    return ((SiteSearchEngineServiceStubSettings) getStubSettings()).getTargetSiteSettings();
  }

  /** Returns the object with the settings used for calls to updateTargetSite. */
  public UnaryCallSettings<UpdateTargetSiteRequest, Operation> updateTargetSiteSettings() {
    return ((SiteSearchEngineServiceStubSettings) getStubSettings()).updateTargetSiteSettings();
  }

  /** Returns the object with the settings used for calls to updateTargetSite. */
  public OperationCallSettings<UpdateTargetSiteRequest, TargetSite, UpdateTargetSiteMetadata>
      updateTargetSiteOperationSettings() {
    return ((SiteSearchEngineServiceStubSettings) getStubSettings())
        .updateTargetSiteOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteTargetSite. */
  public UnaryCallSettings<DeleteTargetSiteRequest, Operation> deleteTargetSiteSettings() {
    return ((SiteSearchEngineServiceStubSettings) getStubSettings()).deleteTargetSiteSettings();
  }

  /** Returns the object with the settings used for calls to deleteTargetSite. */
  public OperationCallSettings<DeleteTargetSiteRequest, Empty, DeleteTargetSiteMetadata>
      deleteTargetSiteOperationSettings() {
    return ((SiteSearchEngineServiceStubSettings) getStubSettings())
        .deleteTargetSiteOperationSettings();
  }

  /** Returns the object with the settings used for calls to listTargetSites. */
  public PagedCallSettings<
          ListTargetSitesRequest, ListTargetSitesResponse, ListTargetSitesPagedResponse>
      listTargetSitesSettings() {
    return ((SiteSearchEngineServiceStubSettings) getStubSettings()).listTargetSitesSettings();
  }

  /** Returns the object with the settings used for calls to enableAdvancedSiteSearch. */
  public UnaryCallSettings<EnableAdvancedSiteSearchRequest, Operation>
      enableAdvancedSiteSearchSettings() {
    return ((SiteSearchEngineServiceStubSettings) getStubSettings())
        .enableAdvancedSiteSearchSettings();
  }

  /** Returns the object with the settings used for calls to enableAdvancedSiteSearch. */
  public OperationCallSettings<
          EnableAdvancedSiteSearchRequest,
          EnableAdvancedSiteSearchResponse,
          EnableAdvancedSiteSearchMetadata>
      enableAdvancedSiteSearchOperationSettings() {
    return ((SiteSearchEngineServiceStubSettings) getStubSettings())
        .enableAdvancedSiteSearchOperationSettings();
  }

  /** Returns the object with the settings used for calls to disableAdvancedSiteSearch. */
  public UnaryCallSettings<DisableAdvancedSiteSearchRequest, Operation>
      disableAdvancedSiteSearchSettings() {
    return ((SiteSearchEngineServiceStubSettings) getStubSettings())
        .disableAdvancedSiteSearchSettings();
  }

  /** Returns the object with the settings used for calls to disableAdvancedSiteSearch. */
  public OperationCallSettings<
          DisableAdvancedSiteSearchRequest,
          DisableAdvancedSiteSearchResponse,
          DisableAdvancedSiteSearchMetadata>
      disableAdvancedSiteSearchOperationSettings() {
    return ((SiteSearchEngineServiceStubSettings) getStubSettings())
        .disableAdvancedSiteSearchOperationSettings();
  }

  /** Returns the object with the settings used for calls to recrawlUris. */
  public UnaryCallSettings<RecrawlUrisRequest, Operation> recrawlUrisSettings() {
    return ((SiteSearchEngineServiceStubSettings) getStubSettings()).recrawlUrisSettings();
  }

  /** Returns the object with the settings used for calls to recrawlUris. */
  public OperationCallSettings<RecrawlUrisRequest, RecrawlUrisResponse, RecrawlUrisMetadata>
      recrawlUrisOperationSettings() {
    return ((SiteSearchEngineServiceStubSettings) getStubSettings()).recrawlUrisOperationSettings();
  }

  /** Returns the object with the settings used for calls to batchVerifyTargetSites. */
  public UnaryCallSettings<BatchVerifyTargetSitesRequest, Operation>
      batchVerifyTargetSitesSettings() {
    return ((SiteSearchEngineServiceStubSettings) getStubSettings())
        .batchVerifyTargetSitesSettings();
  }

  /** Returns the object with the settings used for calls to batchVerifyTargetSites. */
  public OperationCallSettings<
          BatchVerifyTargetSitesRequest,
          BatchVerifyTargetSitesResponse,
          BatchVerifyTargetSitesMetadata>
      batchVerifyTargetSitesOperationSettings() {
    return ((SiteSearchEngineServiceStubSettings) getStubSettings())
        .batchVerifyTargetSitesOperationSettings();
  }

  /** Returns the object with the settings used for calls to fetchDomainVerificationStatus. */
  public PagedCallSettings<
          FetchDomainVerificationStatusRequest,
          FetchDomainVerificationStatusResponse,
          FetchDomainVerificationStatusPagedResponse>
      fetchDomainVerificationStatusSettings() {
    return ((SiteSearchEngineServiceStubSettings) getStubSettings())
        .fetchDomainVerificationStatusSettings();
  }

  public static final SiteSearchEngineServiceSettings create(
      SiteSearchEngineServiceStubSettings stub) throws IOException {
    return new SiteSearchEngineServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return SiteSearchEngineServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return SiteSearchEngineServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return SiteSearchEngineServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return SiteSearchEngineServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return SiteSearchEngineServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return SiteSearchEngineServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return SiteSearchEngineServiceStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return SiteSearchEngineServiceStubSettings.defaultApiClientHeaderProviderBuilder();
  }

  /** Returns a new gRPC builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new REST builder for this class. */
  @BetaApi
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

  protected SiteSearchEngineServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for SiteSearchEngineServiceSettings. */
  public static class Builder
      extends ClientSettings.Builder<SiteSearchEngineServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(SiteSearchEngineServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(SiteSearchEngineServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(SiteSearchEngineServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(SiteSearchEngineServiceStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(SiteSearchEngineServiceStubSettings.newHttpJsonBuilder());
    }

    public SiteSearchEngineServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((SiteSearchEngineServiceStubSettings.Builder) getStubSettings());
    }

    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) {
      super.applyToAllUnaryMethods(
          getStubSettingsBuilder().unaryMethodSettingsBuilders(), settingsUpdater);
      return this;
    }

    /** Returns the builder for the settings used for calls to getSiteSearchEngine. */
    public UnaryCallSettings.Builder<GetSiteSearchEngineRequest, SiteSearchEngine>
        getSiteSearchEngineSettings() {
      return getStubSettingsBuilder().getSiteSearchEngineSettings();
    }

    /** Returns the builder for the settings used for calls to createTargetSite. */
    public UnaryCallSettings.Builder<CreateTargetSiteRequest, Operation>
        createTargetSiteSettings() {
      return getStubSettingsBuilder().createTargetSiteSettings();
    }

    /** Returns the builder for the settings used for calls to createTargetSite. */
    public OperationCallSettings.Builder<
            CreateTargetSiteRequest, TargetSite, CreateTargetSiteMetadata>
        createTargetSiteOperationSettings() {
      return getStubSettingsBuilder().createTargetSiteOperationSettings();
    }

    /** Returns the builder for the settings used for calls to batchCreateTargetSites. */
    public UnaryCallSettings.Builder<BatchCreateTargetSitesRequest, Operation>
        batchCreateTargetSitesSettings() {
      return getStubSettingsBuilder().batchCreateTargetSitesSettings();
    }

    /** Returns the builder for the settings used for calls to batchCreateTargetSites. */
    public OperationCallSettings.Builder<
            BatchCreateTargetSitesRequest,
            BatchCreateTargetSitesResponse,
            BatchCreateTargetSiteMetadata>
        batchCreateTargetSitesOperationSettings() {
      return getStubSettingsBuilder().batchCreateTargetSitesOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getTargetSite. */
    public UnaryCallSettings.Builder<GetTargetSiteRequest, TargetSite> getTargetSiteSettings() {
      return getStubSettingsBuilder().getTargetSiteSettings();
    }

    /** Returns the builder for the settings used for calls to updateTargetSite. */
    public UnaryCallSettings.Builder<UpdateTargetSiteRequest, Operation>
        updateTargetSiteSettings() {
      return getStubSettingsBuilder().updateTargetSiteSettings();
    }

    /** Returns the builder for the settings used for calls to updateTargetSite. */
    public OperationCallSettings.Builder<
            UpdateTargetSiteRequest, TargetSite, UpdateTargetSiteMetadata>
        updateTargetSiteOperationSettings() {
      return getStubSettingsBuilder().updateTargetSiteOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteTargetSite. */
    public UnaryCallSettings.Builder<DeleteTargetSiteRequest, Operation>
        deleteTargetSiteSettings() {
      return getStubSettingsBuilder().deleteTargetSiteSettings();
    }

    /** Returns the builder for the settings used for calls to deleteTargetSite. */
    public OperationCallSettings.Builder<DeleteTargetSiteRequest, Empty, DeleteTargetSiteMetadata>
        deleteTargetSiteOperationSettings() {
      return getStubSettingsBuilder().deleteTargetSiteOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listTargetSites. */
    public PagedCallSettings.Builder<
            ListTargetSitesRequest, ListTargetSitesResponse, ListTargetSitesPagedResponse>
        listTargetSitesSettings() {
      return getStubSettingsBuilder().listTargetSitesSettings();
    }

    /** Returns the builder for the settings used for calls to enableAdvancedSiteSearch. */
    public UnaryCallSettings.Builder<EnableAdvancedSiteSearchRequest, Operation>
        enableAdvancedSiteSearchSettings() {
      return getStubSettingsBuilder().enableAdvancedSiteSearchSettings();
    }

    /** Returns the builder for the settings used for calls to enableAdvancedSiteSearch. */
    public OperationCallSettings.Builder<
            EnableAdvancedSiteSearchRequest,
            EnableAdvancedSiteSearchResponse,
            EnableAdvancedSiteSearchMetadata>
        enableAdvancedSiteSearchOperationSettings() {
      return getStubSettingsBuilder().enableAdvancedSiteSearchOperationSettings();
    }

    /** Returns the builder for the settings used for calls to disableAdvancedSiteSearch. */
    public UnaryCallSettings.Builder<DisableAdvancedSiteSearchRequest, Operation>
        disableAdvancedSiteSearchSettings() {
      return getStubSettingsBuilder().disableAdvancedSiteSearchSettings();
    }

    /** Returns the builder for the settings used for calls to disableAdvancedSiteSearch. */
    public OperationCallSettings.Builder<
            DisableAdvancedSiteSearchRequest,
            DisableAdvancedSiteSearchResponse,
            DisableAdvancedSiteSearchMetadata>
        disableAdvancedSiteSearchOperationSettings() {
      return getStubSettingsBuilder().disableAdvancedSiteSearchOperationSettings();
    }

    /** Returns the builder for the settings used for calls to recrawlUris. */
    public UnaryCallSettings.Builder<RecrawlUrisRequest, Operation> recrawlUrisSettings() {
      return getStubSettingsBuilder().recrawlUrisSettings();
    }

    /** Returns the builder for the settings used for calls to recrawlUris. */
    public OperationCallSettings.Builder<
            RecrawlUrisRequest, RecrawlUrisResponse, RecrawlUrisMetadata>
        recrawlUrisOperationSettings() {
      return getStubSettingsBuilder().recrawlUrisOperationSettings();
    }

    /** Returns the builder for the settings used for calls to batchVerifyTargetSites. */
    public UnaryCallSettings.Builder<BatchVerifyTargetSitesRequest, Operation>
        batchVerifyTargetSitesSettings() {
      return getStubSettingsBuilder().batchVerifyTargetSitesSettings();
    }

    /** Returns the builder for the settings used for calls to batchVerifyTargetSites. */
    public OperationCallSettings.Builder<
            BatchVerifyTargetSitesRequest,
            BatchVerifyTargetSitesResponse,
            BatchVerifyTargetSitesMetadata>
        batchVerifyTargetSitesOperationSettings() {
      return getStubSettingsBuilder().batchVerifyTargetSitesOperationSettings();
    }

    /** Returns the builder for the settings used for calls to fetchDomainVerificationStatus. */
    public PagedCallSettings.Builder<
            FetchDomainVerificationStatusRequest,
            FetchDomainVerificationStatusResponse,
            FetchDomainVerificationStatusPagedResponse>
        fetchDomainVerificationStatusSettings() {
      return getStubSettingsBuilder().fetchDomainVerificationStatusSettings();
    }

    @Override
    public SiteSearchEngineServiceSettings build() throws IOException {
      return new SiteSearchEngineServiceSettings(this);
    }
  }
}
