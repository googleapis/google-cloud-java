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

package com.google.cloud.domains.v1;

import static com.google.cloud.domains.v1.DomainsClient.ListRegistrationsPagedResponse;

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
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.domains.v1.stub.DomainsStubSettings;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link DomainsClient}.
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
 * DomainsSettings.Builder domainsSettingsBuilder = DomainsSettings.newBuilder();
 * domainsSettingsBuilder
 *     .searchDomainsSettings()
 *     .setRetrySettings(
 *         domainsSettingsBuilder.searchDomainsSettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * DomainsSettings domainsSettings = domainsSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class DomainsSettings extends ClientSettings<DomainsSettings> {

  /** Returns the object with the settings used for calls to searchDomains. */
  public UnaryCallSettings<SearchDomainsRequest, SearchDomainsResponse> searchDomainsSettings() {
    return ((DomainsStubSettings) getStubSettings()).searchDomainsSettings();
  }

  /** Returns the object with the settings used for calls to retrieveRegisterParameters. */
  public UnaryCallSettings<RetrieveRegisterParametersRequest, RetrieveRegisterParametersResponse>
      retrieveRegisterParametersSettings() {
    return ((DomainsStubSettings) getStubSettings()).retrieveRegisterParametersSettings();
  }

  /** Returns the object with the settings used for calls to registerDomain. */
  public UnaryCallSettings<RegisterDomainRequest, Operation> registerDomainSettings() {
    return ((DomainsStubSettings) getStubSettings()).registerDomainSettings();
  }

  /** Returns the object with the settings used for calls to registerDomain. */
  public OperationCallSettings<RegisterDomainRequest, Registration, OperationMetadata>
      registerDomainOperationSettings() {
    return ((DomainsStubSettings) getStubSettings()).registerDomainOperationSettings();
  }

  /** Returns the object with the settings used for calls to retrieveTransferParameters. */
  public UnaryCallSettings<RetrieveTransferParametersRequest, RetrieveTransferParametersResponse>
      retrieveTransferParametersSettings() {
    return ((DomainsStubSettings) getStubSettings()).retrieveTransferParametersSettings();
  }

  /** Returns the object with the settings used for calls to transferDomain. */
  public UnaryCallSettings<TransferDomainRequest, Operation> transferDomainSettings() {
    return ((DomainsStubSettings) getStubSettings()).transferDomainSettings();
  }

  /** Returns the object with the settings used for calls to transferDomain. */
  public OperationCallSettings<TransferDomainRequest, Registration, OperationMetadata>
      transferDomainOperationSettings() {
    return ((DomainsStubSettings) getStubSettings()).transferDomainOperationSettings();
  }

  /** Returns the object with the settings used for calls to listRegistrations. */
  public PagedCallSettings<
          ListRegistrationsRequest, ListRegistrationsResponse, ListRegistrationsPagedResponse>
      listRegistrationsSettings() {
    return ((DomainsStubSettings) getStubSettings()).listRegistrationsSettings();
  }

  /** Returns the object with the settings used for calls to getRegistration. */
  public UnaryCallSettings<GetRegistrationRequest, Registration> getRegistrationSettings() {
    return ((DomainsStubSettings) getStubSettings()).getRegistrationSettings();
  }

  /** Returns the object with the settings used for calls to updateRegistration. */
  public UnaryCallSettings<UpdateRegistrationRequest, Operation> updateRegistrationSettings() {
    return ((DomainsStubSettings) getStubSettings()).updateRegistrationSettings();
  }

  /** Returns the object with the settings used for calls to updateRegistration. */
  public OperationCallSettings<UpdateRegistrationRequest, Registration, OperationMetadata>
      updateRegistrationOperationSettings() {
    return ((DomainsStubSettings) getStubSettings()).updateRegistrationOperationSettings();
  }

  /** Returns the object with the settings used for calls to configureManagementSettings. */
  public UnaryCallSettings<ConfigureManagementSettingsRequest, Operation>
      configureManagementSettingsSettings() {
    return ((DomainsStubSettings) getStubSettings()).configureManagementSettingsSettings();
  }

  /** Returns the object with the settings used for calls to configureManagementSettings. */
  public OperationCallSettings<ConfigureManagementSettingsRequest, Registration, OperationMetadata>
      configureManagementSettingsOperationSettings() {
    return ((DomainsStubSettings) getStubSettings()).configureManagementSettingsOperationSettings();
  }

  /** Returns the object with the settings used for calls to configureDnsSettings. */
  public UnaryCallSettings<ConfigureDnsSettingsRequest, Operation> configureDnsSettingsSettings() {
    return ((DomainsStubSettings) getStubSettings()).configureDnsSettingsSettings();
  }

  /** Returns the object with the settings used for calls to configureDnsSettings. */
  public OperationCallSettings<ConfigureDnsSettingsRequest, Registration, OperationMetadata>
      configureDnsSettingsOperationSettings() {
    return ((DomainsStubSettings) getStubSettings()).configureDnsSettingsOperationSettings();
  }

  /** Returns the object with the settings used for calls to configureContactSettings. */
  public UnaryCallSettings<ConfigureContactSettingsRequest, Operation>
      configureContactSettingsSettings() {
    return ((DomainsStubSettings) getStubSettings()).configureContactSettingsSettings();
  }

  /** Returns the object with the settings used for calls to configureContactSettings. */
  public OperationCallSettings<ConfigureContactSettingsRequest, Registration, OperationMetadata>
      configureContactSettingsOperationSettings() {
    return ((DomainsStubSettings) getStubSettings()).configureContactSettingsOperationSettings();
  }

  /** Returns the object with the settings used for calls to exportRegistration. */
  public UnaryCallSettings<ExportRegistrationRequest, Operation> exportRegistrationSettings() {
    return ((DomainsStubSettings) getStubSettings()).exportRegistrationSettings();
  }

  /** Returns the object with the settings used for calls to exportRegistration. */
  public OperationCallSettings<ExportRegistrationRequest, Registration, OperationMetadata>
      exportRegistrationOperationSettings() {
    return ((DomainsStubSettings) getStubSettings()).exportRegistrationOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteRegistration. */
  public UnaryCallSettings<DeleteRegistrationRequest, Operation> deleteRegistrationSettings() {
    return ((DomainsStubSettings) getStubSettings()).deleteRegistrationSettings();
  }

  /** Returns the object with the settings used for calls to deleteRegistration. */
  public OperationCallSettings<DeleteRegistrationRequest, Empty, OperationMetadata>
      deleteRegistrationOperationSettings() {
    return ((DomainsStubSettings) getStubSettings()).deleteRegistrationOperationSettings();
  }

  /** Returns the object with the settings used for calls to retrieveAuthorizationCode. */
  public UnaryCallSettings<RetrieveAuthorizationCodeRequest, AuthorizationCode>
      retrieveAuthorizationCodeSettings() {
    return ((DomainsStubSettings) getStubSettings()).retrieveAuthorizationCodeSettings();
  }

  /** Returns the object with the settings used for calls to resetAuthorizationCode. */
  public UnaryCallSettings<ResetAuthorizationCodeRequest, AuthorizationCode>
      resetAuthorizationCodeSettings() {
    return ((DomainsStubSettings) getStubSettings()).resetAuthorizationCodeSettings();
  }

  public static final DomainsSettings create(DomainsStubSettings stub) throws IOException {
    return new DomainsSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return DomainsStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return DomainsStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return DomainsStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return DomainsStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return DomainsStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return DomainsStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return DomainsStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return DomainsStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected DomainsSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for DomainsSettings. */
  public static class Builder extends ClientSettings.Builder<DomainsSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(DomainsStubSettings.newBuilder(clientContext));
    }

    protected Builder(DomainsSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(DomainsStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(DomainsStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(DomainsStubSettings.newHttpJsonBuilder());
    }

    public DomainsStubSettings.Builder getStubSettingsBuilder() {
      return ((DomainsStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to searchDomains. */
    public UnaryCallSettings.Builder<SearchDomainsRequest, SearchDomainsResponse>
        searchDomainsSettings() {
      return getStubSettingsBuilder().searchDomainsSettings();
    }

    /** Returns the builder for the settings used for calls to retrieveRegisterParameters. */
    public UnaryCallSettings.Builder<
            RetrieveRegisterParametersRequest, RetrieveRegisterParametersResponse>
        retrieveRegisterParametersSettings() {
      return getStubSettingsBuilder().retrieveRegisterParametersSettings();
    }

    /** Returns the builder for the settings used for calls to registerDomain. */
    public UnaryCallSettings.Builder<RegisterDomainRequest, Operation> registerDomainSettings() {
      return getStubSettingsBuilder().registerDomainSettings();
    }

    /** Returns the builder for the settings used for calls to registerDomain. */
    public OperationCallSettings.Builder<RegisterDomainRequest, Registration, OperationMetadata>
        registerDomainOperationSettings() {
      return getStubSettingsBuilder().registerDomainOperationSettings();
    }

    /** Returns the builder for the settings used for calls to retrieveTransferParameters. */
    public UnaryCallSettings.Builder<
            RetrieveTransferParametersRequest, RetrieveTransferParametersResponse>
        retrieveTransferParametersSettings() {
      return getStubSettingsBuilder().retrieveTransferParametersSettings();
    }

    /** Returns the builder for the settings used for calls to transferDomain. */
    public UnaryCallSettings.Builder<TransferDomainRequest, Operation> transferDomainSettings() {
      return getStubSettingsBuilder().transferDomainSettings();
    }

    /** Returns the builder for the settings used for calls to transferDomain. */
    public OperationCallSettings.Builder<TransferDomainRequest, Registration, OperationMetadata>
        transferDomainOperationSettings() {
      return getStubSettingsBuilder().transferDomainOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listRegistrations. */
    public PagedCallSettings.Builder<
            ListRegistrationsRequest, ListRegistrationsResponse, ListRegistrationsPagedResponse>
        listRegistrationsSettings() {
      return getStubSettingsBuilder().listRegistrationsSettings();
    }

    /** Returns the builder for the settings used for calls to getRegistration. */
    public UnaryCallSettings.Builder<GetRegistrationRequest, Registration>
        getRegistrationSettings() {
      return getStubSettingsBuilder().getRegistrationSettings();
    }

    /** Returns the builder for the settings used for calls to updateRegistration. */
    public UnaryCallSettings.Builder<UpdateRegistrationRequest, Operation>
        updateRegistrationSettings() {
      return getStubSettingsBuilder().updateRegistrationSettings();
    }

    /** Returns the builder for the settings used for calls to updateRegistration. */
    public OperationCallSettings.Builder<UpdateRegistrationRequest, Registration, OperationMetadata>
        updateRegistrationOperationSettings() {
      return getStubSettingsBuilder().updateRegistrationOperationSettings();
    }

    /** Returns the builder for the settings used for calls to configureManagementSettings. */
    public UnaryCallSettings.Builder<ConfigureManagementSettingsRequest, Operation>
        configureManagementSettingsSettings() {
      return getStubSettingsBuilder().configureManagementSettingsSettings();
    }

    /** Returns the builder for the settings used for calls to configureManagementSettings. */
    public OperationCallSettings.Builder<
            ConfigureManagementSettingsRequest, Registration, OperationMetadata>
        configureManagementSettingsOperationSettings() {
      return getStubSettingsBuilder().configureManagementSettingsOperationSettings();
    }

    /** Returns the builder for the settings used for calls to configureDnsSettings. */
    public UnaryCallSettings.Builder<ConfigureDnsSettingsRequest, Operation>
        configureDnsSettingsSettings() {
      return getStubSettingsBuilder().configureDnsSettingsSettings();
    }

    /** Returns the builder for the settings used for calls to configureDnsSettings. */
    public OperationCallSettings.Builder<
            ConfigureDnsSettingsRequest, Registration, OperationMetadata>
        configureDnsSettingsOperationSettings() {
      return getStubSettingsBuilder().configureDnsSettingsOperationSettings();
    }

    /** Returns the builder for the settings used for calls to configureContactSettings. */
    public UnaryCallSettings.Builder<ConfigureContactSettingsRequest, Operation>
        configureContactSettingsSettings() {
      return getStubSettingsBuilder().configureContactSettingsSettings();
    }

    /** Returns the builder for the settings used for calls to configureContactSettings. */
    public OperationCallSettings.Builder<
            ConfigureContactSettingsRequest, Registration, OperationMetadata>
        configureContactSettingsOperationSettings() {
      return getStubSettingsBuilder().configureContactSettingsOperationSettings();
    }

    /** Returns the builder for the settings used for calls to exportRegistration. */
    public UnaryCallSettings.Builder<ExportRegistrationRequest, Operation>
        exportRegistrationSettings() {
      return getStubSettingsBuilder().exportRegistrationSettings();
    }

    /** Returns the builder for the settings used for calls to exportRegistration. */
    public OperationCallSettings.Builder<ExportRegistrationRequest, Registration, OperationMetadata>
        exportRegistrationOperationSettings() {
      return getStubSettingsBuilder().exportRegistrationOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteRegistration. */
    public UnaryCallSettings.Builder<DeleteRegistrationRequest, Operation>
        deleteRegistrationSettings() {
      return getStubSettingsBuilder().deleteRegistrationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteRegistration. */
    public OperationCallSettings.Builder<DeleteRegistrationRequest, Empty, OperationMetadata>
        deleteRegistrationOperationSettings() {
      return getStubSettingsBuilder().deleteRegistrationOperationSettings();
    }

    /** Returns the builder for the settings used for calls to retrieveAuthorizationCode. */
    public UnaryCallSettings.Builder<RetrieveAuthorizationCodeRequest, AuthorizationCode>
        retrieveAuthorizationCodeSettings() {
      return getStubSettingsBuilder().retrieveAuthorizationCodeSettings();
    }

    /** Returns the builder for the settings used for calls to resetAuthorizationCode. */
    public UnaryCallSettings.Builder<ResetAuthorizationCodeRequest, AuthorizationCode>
        resetAuthorizationCodeSettings() {
      return getStubSettingsBuilder().resetAuthorizationCodeSettings();
    }

    @Override
    public DomainsSettings build() throws IOException {
      return new DomainsSettings(this);
    }
  }
}
