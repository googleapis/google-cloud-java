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

package com.google.cloud.domains.v1alpha2.stub;

import static com.google.cloud.domains.v1alpha2.DomainsClient.ListRegistrationsPagedResponse;

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
import com.google.cloud.domains.v1alpha2.AuthorizationCode;
import com.google.cloud.domains.v1alpha2.ConfigureContactSettingsRequest;
import com.google.cloud.domains.v1alpha2.ConfigureDnsSettingsRequest;
import com.google.cloud.domains.v1alpha2.ConfigureManagementSettingsRequest;
import com.google.cloud.domains.v1alpha2.DeleteRegistrationRequest;
import com.google.cloud.domains.v1alpha2.ExportRegistrationRequest;
import com.google.cloud.domains.v1alpha2.GetRegistrationRequest;
import com.google.cloud.domains.v1alpha2.ListRegistrationsRequest;
import com.google.cloud.domains.v1alpha2.ListRegistrationsResponse;
import com.google.cloud.domains.v1alpha2.OperationMetadata;
import com.google.cloud.domains.v1alpha2.RegisterDomainRequest;
import com.google.cloud.domains.v1alpha2.Registration;
import com.google.cloud.domains.v1alpha2.ResetAuthorizationCodeRequest;
import com.google.cloud.domains.v1alpha2.RetrieveAuthorizationCodeRequest;
import com.google.cloud.domains.v1alpha2.RetrieveRegisterParametersRequest;
import com.google.cloud.domains.v1alpha2.RetrieveRegisterParametersResponse;
import com.google.cloud.domains.v1alpha2.RetrieveTransferParametersRequest;
import com.google.cloud.domains.v1alpha2.RetrieveTransferParametersResponse;
import com.google.cloud.domains.v1alpha2.SearchDomainsRequest;
import com.google.cloud.domains.v1alpha2.SearchDomainsResponse;
import com.google.cloud.domains.v1alpha2.TransferDomainRequest;
import com.google.cloud.domains.v1alpha2.UpdateRegistrationRequest;
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
 * Settings class to configure an instance of {@link DomainsStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (domains.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of searchDomains to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DomainsStubSettings.Builder domainsSettingsBuilder = DomainsStubSettings.newBuilder();
 * domainsSettingsBuilder
 *     .searchDomainsSettings()
 *     .setRetrySettings(
 *         domainsSettingsBuilder
 *             .searchDomainsSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * DomainsStubSettings domainsSettings = domainsSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class DomainsStubSettings extends StubSettings<DomainsStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<SearchDomainsRequest, SearchDomainsResponse>
      searchDomainsSettings;
  private final UnaryCallSettings<
          RetrieveRegisterParametersRequest, RetrieveRegisterParametersResponse>
      retrieveRegisterParametersSettings;
  private final UnaryCallSettings<RegisterDomainRequest, Operation> registerDomainSettings;
  private final OperationCallSettings<RegisterDomainRequest, Registration, OperationMetadata>
      registerDomainOperationSettings;
  private final UnaryCallSettings<
          RetrieveTransferParametersRequest, RetrieveTransferParametersResponse>
      retrieveTransferParametersSettings;
  private final UnaryCallSettings<TransferDomainRequest, Operation> transferDomainSettings;
  private final OperationCallSettings<TransferDomainRequest, Registration, OperationMetadata>
      transferDomainOperationSettings;
  private final PagedCallSettings<
          ListRegistrationsRequest, ListRegistrationsResponse, ListRegistrationsPagedResponse>
      listRegistrationsSettings;
  private final UnaryCallSettings<GetRegistrationRequest, Registration> getRegistrationSettings;
  private final UnaryCallSettings<UpdateRegistrationRequest, Operation> updateRegistrationSettings;
  private final OperationCallSettings<UpdateRegistrationRequest, Registration, OperationMetadata>
      updateRegistrationOperationSettings;
  private final UnaryCallSettings<ConfigureManagementSettingsRequest, Operation>
      configureManagementSettingsSettings;
  private final OperationCallSettings<
          ConfigureManagementSettingsRequest, Registration, OperationMetadata>
      configureManagementSettingsOperationSettings;
  private final UnaryCallSettings<ConfigureDnsSettingsRequest, Operation>
      configureDnsSettingsSettings;
  private final OperationCallSettings<ConfigureDnsSettingsRequest, Registration, OperationMetadata>
      configureDnsSettingsOperationSettings;
  private final UnaryCallSettings<ConfigureContactSettingsRequest, Operation>
      configureContactSettingsSettings;
  private final OperationCallSettings<
          ConfigureContactSettingsRequest, Registration, OperationMetadata>
      configureContactSettingsOperationSettings;
  private final UnaryCallSettings<ExportRegistrationRequest, Operation> exportRegistrationSettings;
  private final OperationCallSettings<ExportRegistrationRequest, Registration, OperationMetadata>
      exportRegistrationOperationSettings;
  private final UnaryCallSettings<DeleteRegistrationRequest, Operation> deleteRegistrationSettings;
  private final OperationCallSettings<DeleteRegistrationRequest, Empty, OperationMetadata>
      deleteRegistrationOperationSettings;
  private final UnaryCallSettings<RetrieveAuthorizationCodeRequest, AuthorizationCode>
      retrieveAuthorizationCodeSettings;
  private final UnaryCallSettings<ResetAuthorizationCodeRequest, AuthorizationCode>
      resetAuthorizationCodeSettings;

  private static final PagedListDescriptor<
          ListRegistrationsRequest, ListRegistrationsResponse, Registration>
      LIST_REGISTRATIONS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListRegistrationsRequest, ListRegistrationsResponse, Registration>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListRegistrationsRequest injectToken(
                ListRegistrationsRequest payload, String token) {
              return ListRegistrationsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListRegistrationsRequest injectPageSize(
                ListRegistrationsRequest payload, int pageSize) {
              return ListRegistrationsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListRegistrationsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListRegistrationsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Registration> extractResources(ListRegistrationsResponse payload) {
              return payload.getRegistrationsList() == null
                  ? ImmutableList.<Registration>of()
                  : payload.getRegistrationsList();
            }
          };

  private static final PagedListResponseFactory<
          ListRegistrationsRequest, ListRegistrationsResponse, ListRegistrationsPagedResponse>
      LIST_REGISTRATIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListRegistrationsRequest,
              ListRegistrationsResponse,
              ListRegistrationsPagedResponse>() {
            @Override
            public ApiFuture<ListRegistrationsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListRegistrationsRequest, ListRegistrationsResponse> callable,
                ListRegistrationsRequest request,
                ApiCallContext context,
                ApiFuture<ListRegistrationsResponse> futureResponse) {
              PageContext<ListRegistrationsRequest, ListRegistrationsResponse, Registration>
                  pageContext =
                      PageContext.create(
                          callable, LIST_REGISTRATIONS_PAGE_STR_DESC, request, context);
              return ListRegistrationsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to searchDomains. */
  public UnaryCallSettings<SearchDomainsRequest, SearchDomainsResponse> searchDomainsSettings() {
    return searchDomainsSettings;
  }

  /** Returns the object with the settings used for calls to retrieveRegisterParameters. */
  public UnaryCallSettings<RetrieveRegisterParametersRequest, RetrieveRegisterParametersResponse>
      retrieveRegisterParametersSettings() {
    return retrieveRegisterParametersSettings;
  }

  /** Returns the object with the settings used for calls to registerDomain. */
  public UnaryCallSettings<RegisterDomainRequest, Operation> registerDomainSettings() {
    return registerDomainSettings;
  }

  /** Returns the object with the settings used for calls to registerDomain. */
  public OperationCallSettings<RegisterDomainRequest, Registration, OperationMetadata>
      registerDomainOperationSettings() {
    return registerDomainOperationSettings;
  }

  /** Returns the object with the settings used for calls to retrieveTransferParameters. */
  public UnaryCallSettings<RetrieveTransferParametersRequest, RetrieveTransferParametersResponse>
      retrieveTransferParametersSettings() {
    return retrieveTransferParametersSettings;
  }

  /** Returns the object with the settings used for calls to transferDomain. */
  public UnaryCallSettings<TransferDomainRequest, Operation> transferDomainSettings() {
    return transferDomainSettings;
  }

  /** Returns the object with the settings used for calls to transferDomain. */
  public OperationCallSettings<TransferDomainRequest, Registration, OperationMetadata>
      transferDomainOperationSettings() {
    return transferDomainOperationSettings;
  }

  /** Returns the object with the settings used for calls to listRegistrations. */
  public PagedCallSettings<
          ListRegistrationsRequest, ListRegistrationsResponse, ListRegistrationsPagedResponse>
      listRegistrationsSettings() {
    return listRegistrationsSettings;
  }

  /** Returns the object with the settings used for calls to getRegistration. */
  public UnaryCallSettings<GetRegistrationRequest, Registration> getRegistrationSettings() {
    return getRegistrationSettings;
  }

  /** Returns the object with the settings used for calls to updateRegistration. */
  public UnaryCallSettings<UpdateRegistrationRequest, Operation> updateRegistrationSettings() {
    return updateRegistrationSettings;
  }

  /** Returns the object with the settings used for calls to updateRegistration. */
  public OperationCallSettings<UpdateRegistrationRequest, Registration, OperationMetadata>
      updateRegistrationOperationSettings() {
    return updateRegistrationOperationSettings;
  }

  /** Returns the object with the settings used for calls to configureManagementSettings. */
  public UnaryCallSettings<ConfigureManagementSettingsRequest, Operation>
      configureManagementSettingsSettings() {
    return configureManagementSettingsSettings;
  }

  /** Returns the object with the settings used for calls to configureManagementSettings. */
  public OperationCallSettings<ConfigureManagementSettingsRequest, Registration, OperationMetadata>
      configureManagementSettingsOperationSettings() {
    return configureManagementSettingsOperationSettings;
  }

  /** Returns the object with the settings used for calls to configureDnsSettings. */
  public UnaryCallSettings<ConfigureDnsSettingsRequest, Operation> configureDnsSettingsSettings() {
    return configureDnsSettingsSettings;
  }

  /** Returns the object with the settings used for calls to configureDnsSettings. */
  public OperationCallSettings<ConfigureDnsSettingsRequest, Registration, OperationMetadata>
      configureDnsSettingsOperationSettings() {
    return configureDnsSettingsOperationSettings;
  }

  /** Returns the object with the settings used for calls to configureContactSettings. */
  public UnaryCallSettings<ConfigureContactSettingsRequest, Operation>
      configureContactSettingsSettings() {
    return configureContactSettingsSettings;
  }

  /** Returns the object with the settings used for calls to configureContactSettings. */
  public OperationCallSettings<ConfigureContactSettingsRequest, Registration, OperationMetadata>
      configureContactSettingsOperationSettings() {
    return configureContactSettingsOperationSettings;
  }

  /** Returns the object with the settings used for calls to exportRegistration. */
  public UnaryCallSettings<ExportRegistrationRequest, Operation> exportRegistrationSettings() {
    return exportRegistrationSettings;
  }

  /** Returns the object with the settings used for calls to exportRegistration. */
  public OperationCallSettings<ExportRegistrationRequest, Registration, OperationMetadata>
      exportRegistrationOperationSettings() {
    return exportRegistrationOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteRegistration. */
  public UnaryCallSettings<DeleteRegistrationRequest, Operation> deleteRegistrationSettings() {
    return deleteRegistrationSettings;
  }

  /** Returns the object with the settings used for calls to deleteRegistration. */
  public OperationCallSettings<DeleteRegistrationRequest, Empty, OperationMetadata>
      deleteRegistrationOperationSettings() {
    return deleteRegistrationOperationSettings;
  }

  /** Returns the object with the settings used for calls to retrieveAuthorizationCode. */
  public UnaryCallSettings<RetrieveAuthorizationCodeRequest, AuthorizationCode>
      retrieveAuthorizationCodeSettings() {
    return retrieveAuthorizationCodeSettings;
  }

  /** Returns the object with the settings used for calls to resetAuthorizationCode. */
  public UnaryCallSettings<ResetAuthorizationCodeRequest, AuthorizationCode>
      resetAuthorizationCodeSettings() {
    return resetAuthorizationCodeSettings;
  }

  public DomainsStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcDomainsStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonDomainsStub.create(this);
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
    return "domains.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "domains.mtls.googleapis.com:443";
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
        .setGeneratedLibToken("gapic", GaxProperties.getLibraryVersion(DomainsStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken("gapic", GaxProperties.getLibraryVersion(DomainsStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return DomainsStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected DomainsStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    searchDomainsSettings = settingsBuilder.searchDomainsSettings().build();
    retrieveRegisterParametersSettings =
        settingsBuilder.retrieveRegisterParametersSettings().build();
    registerDomainSettings = settingsBuilder.registerDomainSettings().build();
    registerDomainOperationSettings = settingsBuilder.registerDomainOperationSettings().build();
    retrieveTransferParametersSettings =
        settingsBuilder.retrieveTransferParametersSettings().build();
    transferDomainSettings = settingsBuilder.transferDomainSettings().build();
    transferDomainOperationSettings = settingsBuilder.transferDomainOperationSettings().build();
    listRegistrationsSettings = settingsBuilder.listRegistrationsSettings().build();
    getRegistrationSettings = settingsBuilder.getRegistrationSettings().build();
    updateRegistrationSettings = settingsBuilder.updateRegistrationSettings().build();
    updateRegistrationOperationSettings =
        settingsBuilder.updateRegistrationOperationSettings().build();
    configureManagementSettingsSettings =
        settingsBuilder.configureManagementSettingsSettings().build();
    configureManagementSettingsOperationSettings =
        settingsBuilder.configureManagementSettingsOperationSettings().build();
    configureDnsSettingsSettings = settingsBuilder.configureDnsSettingsSettings().build();
    configureDnsSettingsOperationSettings =
        settingsBuilder.configureDnsSettingsOperationSettings().build();
    configureContactSettingsSettings = settingsBuilder.configureContactSettingsSettings().build();
    configureContactSettingsOperationSettings =
        settingsBuilder.configureContactSettingsOperationSettings().build();
    exportRegistrationSettings = settingsBuilder.exportRegistrationSettings().build();
    exportRegistrationOperationSettings =
        settingsBuilder.exportRegistrationOperationSettings().build();
    deleteRegistrationSettings = settingsBuilder.deleteRegistrationSettings().build();
    deleteRegistrationOperationSettings =
        settingsBuilder.deleteRegistrationOperationSettings().build();
    retrieveAuthorizationCodeSettings = settingsBuilder.retrieveAuthorizationCodeSettings().build();
    resetAuthorizationCodeSettings = settingsBuilder.resetAuthorizationCodeSettings().build();
  }

  /** Builder for DomainsStubSettings. */
  public static class Builder extends StubSettings.Builder<DomainsStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<SearchDomainsRequest, SearchDomainsResponse>
        searchDomainsSettings;
    private final UnaryCallSettings.Builder<
            RetrieveRegisterParametersRequest, RetrieveRegisterParametersResponse>
        retrieveRegisterParametersSettings;
    private final UnaryCallSettings.Builder<RegisterDomainRequest, Operation>
        registerDomainSettings;
    private final OperationCallSettings.Builder<
            RegisterDomainRequest, Registration, OperationMetadata>
        registerDomainOperationSettings;
    private final UnaryCallSettings.Builder<
            RetrieveTransferParametersRequest, RetrieveTransferParametersResponse>
        retrieveTransferParametersSettings;
    private final UnaryCallSettings.Builder<TransferDomainRequest, Operation>
        transferDomainSettings;
    private final OperationCallSettings.Builder<
            TransferDomainRequest, Registration, OperationMetadata>
        transferDomainOperationSettings;
    private final PagedCallSettings.Builder<
            ListRegistrationsRequest, ListRegistrationsResponse, ListRegistrationsPagedResponse>
        listRegistrationsSettings;
    private final UnaryCallSettings.Builder<GetRegistrationRequest, Registration>
        getRegistrationSettings;
    private final UnaryCallSettings.Builder<UpdateRegistrationRequest, Operation>
        updateRegistrationSettings;
    private final OperationCallSettings.Builder<
            UpdateRegistrationRequest, Registration, OperationMetadata>
        updateRegistrationOperationSettings;
    private final UnaryCallSettings.Builder<ConfigureManagementSettingsRequest, Operation>
        configureManagementSettingsSettings;
    private final OperationCallSettings.Builder<
            ConfigureManagementSettingsRequest, Registration, OperationMetadata>
        configureManagementSettingsOperationSettings;
    private final UnaryCallSettings.Builder<ConfigureDnsSettingsRequest, Operation>
        configureDnsSettingsSettings;
    private final OperationCallSettings.Builder<
            ConfigureDnsSettingsRequest, Registration, OperationMetadata>
        configureDnsSettingsOperationSettings;
    private final UnaryCallSettings.Builder<ConfigureContactSettingsRequest, Operation>
        configureContactSettingsSettings;
    private final OperationCallSettings.Builder<
            ConfigureContactSettingsRequest, Registration, OperationMetadata>
        configureContactSettingsOperationSettings;
    private final UnaryCallSettings.Builder<ExportRegistrationRequest, Operation>
        exportRegistrationSettings;
    private final OperationCallSettings.Builder<
            ExportRegistrationRequest, Registration, OperationMetadata>
        exportRegistrationOperationSettings;
    private final UnaryCallSettings.Builder<DeleteRegistrationRequest, Operation>
        deleteRegistrationSettings;
    private final OperationCallSettings.Builder<DeleteRegistrationRequest, Empty, OperationMetadata>
        deleteRegistrationOperationSettings;
    private final UnaryCallSettings.Builder<RetrieveAuthorizationCodeRequest, AuthorizationCode>
        retrieveAuthorizationCodeSettings;
    private final UnaryCallSettings.Builder<ResetAuthorizationCodeRequest, AuthorizationCode>
        resetAuthorizationCodeSettings;
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

      searchDomainsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      retrieveRegisterParametersSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      registerDomainSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      registerDomainOperationSettings = OperationCallSettings.newBuilder();
      retrieveTransferParametersSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      transferDomainSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      transferDomainOperationSettings = OperationCallSettings.newBuilder();
      listRegistrationsSettings = PagedCallSettings.newBuilder(LIST_REGISTRATIONS_PAGE_STR_FACT);
      getRegistrationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateRegistrationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateRegistrationOperationSettings = OperationCallSettings.newBuilder();
      configureManagementSettingsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      configureManagementSettingsOperationSettings = OperationCallSettings.newBuilder();
      configureDnsSettingsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      configureDnsSettingsOperationSettings = OperationCallSettings.newBuilder();
      configureContactSettingsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      configureContactSettingsOperationSettings = OperationCallSettings.newBuilder();
      exportRegistrationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      exportRegistrationOperationSettings = OperationCallSettings.newBuilder();
      deleteRegistrationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteRegistrationOperationSettings = OperationCallSettings.newBuilder();
      retrieveAuthorizationCodeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      resetAuthorizationCodeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              searchDomainsSettings,
              retrieveRegisterParametersSettings,
              registerDomainSettings,
              retrieveTransferParametersSettings,
              transferDomainSettings,
              listRegistrationsSettings,
              getRegistrationSettings,
              updateRegistrationSettings,
              configureManagementSettingsSettings,
              configureDnsSettingsSettings,
              configureContactSettingsSettings,
              exportRegistrationSettings,
              deleteRegistrationSettings,
              retrieveAuthorizationCodeSettings,
              resetAuthorizationCodeSettings);
      initDefaults(this);
    }

    protected Builder(DomainsStubSettings settings) {
      super(settings);

      searchDomainsSettings = settings.searchDomainsSettings.toBuilder();
      retrieveRegisterParametersSettings = settings.retrieveRegisterParametersSettings.toBuilder();
      registerDomainSettings = settings.registerDomainSettings.toBuilder();
      registerDomainOperationSettings = settings.registerDomainOperationSettings.toBuilder();
      retrieveTransferParametersSettings = settings.retrieveTransferParametersSettings.toBuilder();
      transferDomainSettings = settings.transferDomainSettings.toBuilder();
      transferDomainOperationSettings = settings.transferDomainOperationSettings.toBuilder();
      listRegistrationsSettings = settings.listRegistrationsSettings.toBuilder();
      getRegistrationSettings = settings.getRegistrationSettings.toBuilder();
      updateRegistrationSettings = settings.updateRegistrationSettings.toBuilder();
      updateRegistrationOperationSettings =
          settings.updateRegistrationOperationSettings.toBuilder();
      configureManagementSettingsSettings =
          settings.configureManagementSettingsSettings.toBuilder();
      configureManagementSettingsOperationSettings =
          settings.configureManagementSettingsOperationSettings.toBuilder();
      configureDnsSettingsSettings = settings.configureDnsSettingsSettings.toBuilder();
      configureDnsSettingsOperationSettings =
          settings.configureDnsSettingsOperationSettings.toBuilder();
      configureContactSettingsSettings = settings.configureContactSettingsSettings.toBuilder();
      configureContactSettingsOperationSettings =
          settings.configureContactSettingsOperationSettings.toBuilder();
      exportRegistrationSettings = settings.exportRegistrationSettings.toBuilder();
      exportRegistrationOperationSettings =
          settings.exportRegistrationOperationSettings.toBuilder();
      deleteRegistrationSettings = settings.deleteRegistrationSettings.toBuilder();
      deleteRegistrationOperationSettings =
          settings.deleteRegistrationOperationSettings.toBuilder();
      retrieveAuthorizationCodeSettings = settings.retrieveAuthorizationCodeSettings.toBuilder();
      resetAuthorizationCodeSettings = settings.resetAuthorizationCodeSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              searchDomainsSettings,
              retrieveRegisterParametersSettings,
              registerDomainSettings,
              retrieveTransferParametersSettings,
              transferDomainSettings,
              listRegistrationsSettings,
              getRegistrationSettings,
              updateRegistrationSettings,
              configureManagementSettingsSettings,
              configureDnsSettingsSettings,
              configureContactSettingsSettings,
              exportRegistrationSettings,
              deleteRegistrationSettings,
              retrieveAuthorizationCodeSettings,
              resetAuthorizationCodeSettings);
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
          .searchDomainsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .retrieveRegisterParametersSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .registerDomainSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .retrieveTransferParametersSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .transferDomainSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listRegistrationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getRegistrationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateRegistrationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .configureManagementSettingsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .configureDnsSettingsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .configureContactSettingsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .exportRegistrationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteRegistrationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .retrieveAuthorizationCodeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .resetAuthorizationCodeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .registerDomainOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<RegisterDomainRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Registration.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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
          .transferDomainOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<TransferDomainRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Registration.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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
          .updateRegistrationOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateRegistrationRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Registration.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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
          .configureManagementSettingsOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<ConfigureManagementSettingsRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Registration.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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
          .configureDnsSettingsOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<ConfigureDnsSettingsRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Registration.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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
          .configureContactSettingsOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<ConfigureContactSettingsRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Registration.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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
          .exportRegistrationOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<ExportRegistrationRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Registration.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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
          .deleteRegistrationOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteRegistrationRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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

    /** Returns the builder for the settings used for calls to searchDomains. */
    public UnaryCallSettings.Builder<SearchDomainsRequest, SearchDomainsResponse>
        searchDomainsSettings() {
      return searchDomainsSettings;
    }

    /** Returns the builder for the settings used for calls to retrieveRegisterParameters. */
    public UnaryCallSettings.Builder<
            RetrieveRegisterParametersRequest, RetrieveRegisterParametersResponse>
        retrieveRegisterParametersSettings() {
      return retrieveRegisterParametersSettings;
    }

    /** Returns the builder for the settings used for calls to registerDomain. */
    public UnaryCallSettings.Builder<RegisterDomainRequest, Operation> registerDomainSettings() {
      return registerDomainSettings;
    }

    /** Returns the builder for the settings used for calls to registerDomain. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<RegisterDomainRequest, Registration, OperationMetadata>
        registerDomainOperationSettings() {
      return registerDomainOperationSettings;
    }

    /** Returns the builder for the settings used for calls to retrieveTransferParameters. */
    public UnaryCallSettings.Builder<
            RetrieveTransferParametersRequest, RetrieveTransferParametersResponse>
        retrieveTransferParametersSettings() {
      return retrieveTransferParametersSettings;
    }

    /** Returns the builder for the settings used for calls to transferDomain. */
    public UnaryCallSettings.Builder<TransferDomainRequest, Operation> transferDomainSettings() {
      return transferDomainSettings;
    }

    /** Returns the builder for the settings used for calls to transferDomain. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<TransferDomainRequest, Registration, OperationMetadata>
        transferDomainOperationSettings() {
      return transferDomainOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listRegistrations. */
    public PagedCallSettings.Builder<
            ListRegistrationsRequest, ListRegistrationsResponse, ListRegistrationsPagedResponse>
        listRegistrationsSettings() {
      return listRegistrationsSettings;
    }

    /** Returns the builder for the settings used for calls to getRegistration. */
    public UnaryCallSettings.Builder<GetRegistrationRequest, Registration>
        getRegistrationSettings() {
      return getRegistrationSettings;
    }

    /** Returns the builder for the settings used for calls to updateRegistration. */
    public UnaryCallSettings.Builder<UpdateRegistrationRequest, Operation>
        updateRegistrationSettings() {
      return updateRegistrationSettings;
    }

    /** Returns the builder for the settings used for calls to updateRegistration. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<UpdateRegistrationRequest, Registration, OperationMetadata>
        updateRegistrationOperationSettings() {
      return updateRegistrationOperationSettings;
    }

    /** Returns the builder for the settings used for calls to configureManagementSettings. */
    public UnaryCallSettings.Builder<ConfigureManagementSettingsRequest, Operation>
        configureManagementSettingsSettings() {
      return configureManagementSettingsSettings;
    }

    /** Returns the builder for the settings used for calls to configureManagementSettings. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            ConfigureManagementSettingsRequest, Registration, OperationMetadata>
        configureManagementSettingsOperationSettings() {
      return configureManagementSettingsOperationSettings;
    }

    /** Returns the builder for the settings used for calls to configureDnsSettings. */
    public UnaryCallSettings.Builder<ConfigureDnsSettingsRequest, Operation>
        configureDnsSettingsSettings() {
      return configureDnsSettingsSettings;
    }

    /** Returns the builder for the settings used for calls to configureDnsSettings. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            ConfigureDnsSettingsRequest, Registration, OperationMetadata>
        configureDnsSettingsOperationSettings() {
      return configureDnsSettingsOperationSettings;
    }

    /** Returns the builder for the settings used for calls to configureContactSettings. */
    public UnaryCallSettings.Builder<ConfigureContactSettingsRequest, Operation>
        configureContactSettingsSettings() {
      return configureContactSettingsSettings;
    }

    /** Returns the builder for the settings used for calls to configureContactSettings. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            ConfigureContactSettingsRequest, Registration, OperationMetadata>
        configureContactSettingsOperationSettings() {
      return configureContactSettingsOperationSettings;
    }

    /** Returns the builder for the settings used for calls to exportRegistration. */
    public UnaryCallSettings.Builder<ExportRegistrationRequest, Operation>
        exportRegistrationSettings() {
      return exportRegistrationSettings;
    }

    /** Returns the builder for the settings used for calls to exportRegistration. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<ExportRegistrationRequest, Registration, OperationMetadata>
        exportRegistrationOperationSettings() {
      return exportRegistrationOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteRegistration. */
    public UnaryCallSettings.Builder<DeleteRegistrationRequest, Operation>
        deleteRegistrationSettings() {
      return deleteRegistrationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteRegistration. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<DeleteRegistrationRequest, Empty, OperationMetadata>
        deleteRegistrationOperationSettings() {
      return deleteRegistrationOperationSettings;
    }

    /** Returns the builder for the settings used for calls to retrieveAuthorizationCode. */
    public UnaryCallSettings.Builder<RetrieveAuthorizationCodeRequest, AuthorizationCode>
        retrieveAuthorizationCodeSettings() {
      return retrieveAuthorizationCodeSettings;
    }

    /** Returns the builder for the settings used for calls to resetAuthorizationCode. */
    public UnaryCallSettings.Builder<ResetAuthorizationCodeRequest, AuthorizationCode>
        resetAuthorizationCodeSettings() {
      return resetAuthorizationCodeSettings;
    }

    @Override
    public DomainsStubSettings build() throws IOException {
      return new DomainsStubSettings(this);
    }
  }
}
