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

package com.google.cloud.managedidentities.v1;

import static com.google.cloud.managedidentities.v1.ManagedIdentitiesServiceClient.ListDomainsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.managedidentities.v1.stub.ManagedIdentitiesServiceStubSettings;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link ManagedIdentitiesServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (managedidentities.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of resetAdminPassword to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ManagedIdentitiesServiceSettings.Builder managedIdentitiesServiceSettingsBuilder =
 *     ManagedIdentitiesServiceSettings.newBuilder();
 * managedIdentitiesServiceSettingsBuilder
 *     .resetAdminPasswordSettings()
 *     .setRetrySettings(
 *         managedIdentitiesServiceSettingsBuilder
 *             .resetAdminPasswordSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * ManagedIdentitiesServiceSettings managedIdentitiesServiceSettings =
 *     managedIdentitiesServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class ManagedIdentitiesServiceSettings
    extends ClientSettings<ManagedIdentitiesServiceSettings> {

  /** Returns the object with the settings used for calls to createMicrosoftAdDomain. */
  public UnaryCallSettings<CreateMicrosoftAdDomainRequest, Operation>
      createMicrosoftAdDomainSettings() {
    return ((ManagedIdentitiesServiceStubSettings) getStubSettings())
        .createMicrosoftAdDomainSettings();
  }

  /** Returns the object with the settings used for calls to createMicrosoftAdDomain. */
  public OperationCallSettings<CreateMicrosoftAdDomainRequest, Domain, OpMetadata>
      createMicrosoftAdDomainOperationSettings() {
    return ((ManagedIdentitiesServiceStubSettings) getStubSettings())
        .createMicrosoftAdDomainOperationSettings();
  }

  /** Returns the object with the settings used for calls to resetAdminPassword. */
  public UnaryCallSettings<ResetAdminPasswordRequest, ResetAdminPasswordResponse>
      resetAdminPasswordSettings() {
    return ((ManagedIdentitiesServiceStubSettings) getStubSettings()).resetAdminPasswordSettings();
  }

  /** Returns the object with the settings used for calls to listDomains. */
  public PagedCallSettings<ListDomainsRequest, ListDomainsResponse, ListDomainsPagedResponse>
      listDomainsSettings() {
    return ((ManagedIdentitiesServiceStubSettings) getStubSettings()).listDomainsSettings();
  }

  /** Returns the object with the settings used for calls to getDomain. */
  public UnaryCallSettings<GetDomainRequest, Domain> getDomainSettings() {
    return ((ManagedIdentitiesServiceStubSettings) getStubSettings()).getDomainSettings();
  }

  /** Returns the object with the settings used for calls to updateDomain. */
  public UnaryCallSettings<UpdateDomainRequest, Operation> updateDomainSettings() {
    return ((ManagedIdentitiesServiceStubSettings) getStubSettings()).updateDomainSettings();
  }

  /** Returns the object with the settings used for calls to updateDomain. */
  public OperationCallSettings<UpdateDomainRequest, Domain, OpMetadata>
      updateDomainOperationSettings() {
    return ((ManagedIdentitiesServiceStubSettings) getStubSettings())
        .updateDomainOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteDomain. */
  public UnaryCallSettings<DeleteDomainRequest, Operation> deleteDomainSettings() {
    return ((ManagedIdentitiesServiceStubSettings) getStubSettings()).deleteDomainSettings();
  }

  /** Returns the object with the settings used for calls to deleteDomain. */
  public OperationCallSettings<DeleteDomainRequest, Empty, OpMetadata>
      deleteDomainOperationSettings() {
    return ((ManagedIdentitiesServiceStubSettings) getStubSettings())
        .deleteDomainOperationSettings();
  }

  /** Returns the object with the settings used for calls to attachTrust. */
  public UnaryCallSettings<AttachTrustRequest, Operation> attachTrustSettings() {
    return ((ManagedIdentitiesServiceStubSettings) getStubSettings()).attachTrustSettings();
  }

  /** Returns the object with the settings used for calls to attachTrust. */
  public OperationCallSettings<AttachTrustRequest, Domain, OpMetadata>
      attachTrustOperationSettings() {
    return ((ManagedIdentitiesServiceStubSettings) getStubSettings())
        .attachTrustOperationSettings();
  }

  /** Returns the object with the settings used for calls to reconfigureTrust. */
  public UnaryCallSettings<ReconfigureTrustRequest, Operation> reconfigureTrustSettings() {
    return ((ManagedIdentitiesServiceStubSettings) getStubSettings()).reconfigureTrustSettings();
  }

  /** Returns the object with the settings used for calls to reconfigureTrust. */
  public OperationCallSettings<ReconfigureTrustRequest, Domain, OpMetadata>
      reconfigureTrustOperationSettings() {
    return ((ManagedIdentitiesServiceStubSettings) getStubSettings())
        .reconfigureTrustOperationSettings();
  }

  /** Returns the object with the settings used for calls to detachTrust. */
  public UnaryCallSettings<DetachTrustRequest, Operation> detachTrustSettings() {
    return ((ManagedIdentitiesServiceStubSettings) getStubSettings()).detachTrustSettings();
  }

  /** Returns the object with the settings used for calls to detachTrust. */
  public OperationCallSettings<DetachTrustRequest, Domain, OpMetadata>
      detachTrustOperationSettings() {
    return ((ManagedIdentitiesServiceStubSettings) getStubSettings())
        .detachTrustOperationSettings();
  }

  /** Returns the object with the settings used for calls to validateTrust. */
  public UnaryCallSettings<ValidateTrustRequest, Operation> validateTrustSettings() {
    return ((ManagedIdentitiesServiceStubSettings) getStubSettings()).validateTrustSettings();
  }

  /** Returns the object with the settings used for calls to validateTrust. */
  public OperationCallSettings<ValidateTrustRequest, Domain, OpMetadata>
      validateTrustOperationSettings() {
    return ((ManagedIdentitiesServiceStubSettings) getStubSettings())
        .validateTrustOperationSettings();
  }

  public static final ManagedIdentitiesServiceSettings create(
      ManagedIdentitiesServiceStubSettings stub) throws IOException {
    return new ManagedIdentitiesServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return ManagedIdentitiesServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return ManagedIdentitiesServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return ManagedIdentitiesServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return ManagedIdentitiesServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return ManagedIdentitiesServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return ManagedIdentitiesServiceStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ManagedIdentitiesServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected ManagedIdentitiesServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for ManagedIdentitiesServiceSettings. */
  public static class Builder
      extends ClientSettings.Builder<ManagedIdentitiesServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(ManagedIdentitiesServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(ManagedIdentitiesServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(ManagedIdentitiesServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(ManagedIdentitiesServiceStubSettings.newBuilder());
    }

    public ManagedIdentitiesServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((ManagedIdentitiesServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to createMicrosoftAdDomain. */
    public UnaryCallSettings.Builder<CreateMicrosoftAdDomainRequest, Operation>
        createMicrosoftAdDomainSettings() {
      return getStubSettingsBuilder().createMicrosoftAdDomainSettings();
    }

    /** Returns the builder for the settings used for calls to createMicrosoftAdDomain. */
    public OperationCallSettings.Builder<CreateMicrosoftAdDomainRequest, Domain, OpMetadata>
        createMicrosoftAdDomainOperationSettings() {
      return getStubSettingsBuilder().createMicrosoftAdDomainOperationSettings();
    }

    /** Returns the builder for the settings used for calls to resetAdminPassword. */
    public UnaryCallSettings.Builder<ResetAdminPasswordRequest, ResetAdminPasswordResponse>
        resetAdminPasswordSettings() {
      return getStubSettingsBuilder().resetAdminPasswordSettings();
    }

    /** Returns the builder for the settings used for calls to listDomains. */
    public PagedCallSettings.Builder<
            ListDomainsRequest, ListDomainsResponse, ListDomainsPagedResponse>
        listDomainsSettings() {
      return getStubSettingsBuilder().listDomainsSettings();
    }

    /** Returns the builder for the settings used for calls to getDomain. */
    public UnaryCallSettings.Builder<GetDomainRequest, Domain> getDomainSettings() {
      return getStubSettingsBuilder().getDomainSettings();
    }

    /** Returns the builder for the settings used for calls to updateDomain. */
    public UnaryCallSettings.Builder<UpdateDomainRequest, Operation> updateDomainSettings() {
      return getStubSettingsBuilder().updateDomainSettings();
    }

    /** Returns the builder for the settings used for calls to updateDomain. */
    public OperationCallSettings.Builder<UpdateDomainRequest, Domain, OpMetadata>
        updateDomainOperationSettings() {
      return getStubSettingsBuilder().updateDomainOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteDomain. */
    public UnaryCallSettings.Builder<DeleteDomainRequest, Operation> deleteDomainSettings() {
      return getStubSettingsBuilder().deleteDomainSettings();
    }

    /** Returns the builder for the settings used for calls to deleteDomain. */
    public OperationCallSettings.Builder<DeleteDomainRequest, Empty, OpMetadata>
        deleteDomainOperationSettings() {
      return getStubSettingsBuilder().deleteDomainOperationSettings();
    }

    /** Returns the builder for the settings used for calls to attachTrust. */
    public UnaryCallSettings.Builder<AttachTrustRequest, Operation> attachTrustSettings() {
      return getStubSettingsBuilder().attachTrustSettings();
    }

    /** Returns the builder for the settings used for calls to attachTrust. */
    public OperationCallSettings.Builder<AttachTrustRequest, Domain, OpMetadata>
        attachTrustOperationSettings() {
      return getStubSettingsBuilder().attachTrustOperationSettings();
    }

    /** Returns the builder for the settings used for calls to reconfigureTrust. */
    public UnaryCallSettings.Builder<ReconfigureTrustRequest, Operation>
        reconfigureTrustSettings() {
      return getStubSettingsBuilder().reconfigureTrustSettings();
    }

    /** Returns the builder for the settings used for calls to reconfigureTrust. */
    public OperationCallSettings.Builder<ReconfigureTrustRequest, Domain, OpMetadata>
        reconfigureTrustOperationSettings() {
      return getStubSettingsBuilder().reconfigureTrustOperationSettings();
    }

    /** Returns the builder for the settings used for calls to detachTrust. */
    public UnaryCallSettings.Builder<DetachTrustRequest, Operation> detachTrustSettings() {
      return getStubSettingsBuilder().detachTrustSettings();
    }

    /** Returns the builder for the settings used for calls to detachTrust. */
    public OperationCallSettings.Builder<DetachTrustRequest, Domain, OpMetadata>
        detachTrustOperationSettings() {
      return getStubSettingsBuilder().detachTrustOperationSettings();
    }

    /** Returns the builder for the settings used for calls to validateTrust. */
    public UnaryCallSettings.Builder<ValidateTrustRequest, Operation> validateTrustSettings() {
      return getStubSettingsBuilder().validateTrustSettings();
    }

    /** Returns the builder for the settings used for calls to validateTrust. */
    public OperationCallSettings.Builder<ValidateTrustRequest, Domain, OpMetadata>
        validateTrustOperationSettings() {
      return getStubSettingsBuilder().validateTrustOperationSettings();
    }

    @Override
    public ManagedIdentitiesServiceSettings build() throws IOException {
      return new ManagedIdentitiesServiceSettings(this);
    }
  }
}
