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

package com.google.cloud.networksecurity.v1;

import static com.google.cloud.networksecurity.v1.NetworkSecurityClient.ListAuthorizationPoliciesPagedResponse;
import static com.google.cloud.networksecurity.v1.NetworkSecurityClient.ListClientTlsPoliciesPagedResponse;
import static com.google.cloud.networksecurity.v1.NetworkSecurityClient.ListServerTlsPoliciesPagedResponse;

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
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.networksecurity.v1.stub.NetworkSecurityStubSettings;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link NetworkSecurityClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (networksecurity.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getAuthorizationPolicy to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * NetworkSecuritySettings.Builder networkSecuritySettingsBuilder =
 *     NetworkSecuritySettings.newBuilder();
 * networkSecuritySettingsBuilder
 *     .getAuthorizationPolicySettings()
 *     .setRetrySettings(
 *         networkSecuritySettingsBuilder
 *             .getAuthorizationPolicySettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * NetworkSecuritySettings networkSecuritySettings = networkSecuritySettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class NetworkSecuritySettings extends ClientSettings<NetworkSecuritySettings> {

  /** Returns the object with the settings used for calls to listAuthorizationPolicies. */
  public PagedCallSettings<
          ListAuthorizationPoliciesRequest,
          ListAuthorizationPoliciesResponse,
          ListAuthorizationPoliciesPagedResponse>
      listAuthorizationPoliciesSettings() {
    return ((NetworkSecurityStubSettings) getStubSettings()).listAuthorizationPoliciesSettings();
  }

  /** Returns the object with the settings used for calls to getAuthorizationPolicy. */
  public UnaryCallSettings<GetAuthorizationPolicyRequest, AuthorizationPolicy>
      getAuthorizationPolicySettings() {
    return ((NetworkSecurityStubSettings) getStubSettings()).getAuthorizationPolicySettings();
  }

  /** Returns the object with the settings used for calls to createAuthorizationPolicy. */
  public UnaryCallSettings<CreateAuthorizationPolicyRequest, Operation>
      createAuthorizationPolicySettings() {
    return ((NetworkSecurityStubSettings) getStubSettings()).createAuthorizationPolicySettings();
  }

  /** Returns the object with the settings used for calls to createAuthorizationPolicy. */
  public OperationCallSettings<
          CreateAuthorizationPolicyRequest, AuthorizationPolicy, OperationMetadata>
      createAuthorizationPolicyOperationSettings() {
    return ((NetworkSecurityStubSettings) getStubSettings())
        .createAuthorizationPolicyOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateAuthorizationPolicy. */
  public UnaryCallSettings<UpdateAuthorizationPolicyRequest, Operation>
      updateAuthorizationPolicySettings() {
    return ((NetworkSecurityStubSettings) getStubSettings()).updateAuthorizationPolicySettings();
  }

  /** Returns the object with the settings used for calls to updateAuthorizationPolicy. */
  public OperationCallSettings<
          UpdateAuthorizationPolicyRequest, AuthorizationPolicy, OperationMetadata>
      updateAuthorizationPolicyOperationSettings() {
    return ((NetworkSecurityStubSettings) getStubSettings())
        .updateAuthorizationPolicyOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteAuthorizationPolicy. */
  public UnaryCallSettings<DeleteAuthorizationPolicyRequest, Operation>
      deleteAuthorizationPolicySettings() {
    return ((NetworkSecurityStubSettings) getStubSettings()).deleteAuthorizationPolicySettings();
  }

  /** Returns the object with the settings used for calls to deleteAuthorizationPolicy. */
  public OperationCallSettings<DeleteAuthorizationPolicyRequest, Empty, OperationMetadata>
      deleteAuthorizationPolicyOperationSettings() {
    return ((NetworkSecurityStubSettings) getStubSettings())
        .deleteAuthorizationPolicyOperationSettings();
  }

  /** Returns the object with the settings used for calls to listServerTlsPolicies. */
  public PagedCallSettings<
          ListServerTlsPoliciesRequest,
          ListServerTlsPoliciesResponse,
          ListServerTlsPoliciesPagedResponse>
      listServerTlsPoliciesSettings() {
    return ((NetworkSecurityStubSettings) getStubSettings()).listServerTlsPoliciesSettings();
  }

  /** Returns the object with the settings used for calls to getServerTlsPolicy. */
  public UnaryCallSettings<GetServerTlsPolicyRequest, ServerTlsPolicy>
      getServerTlsPolicySettings() {
    return ((NetworkSecurityStubSettings) getStubSettings()).getServerTlsPolicySettings();
  }

  /** Returns the object with the settings used for calls to createServerTlsPolicy. */
  public UnaryCallSettings<CreateServerTlsPolicyRequest, Operation>
      createServerTlsPolicySettings() {
    return ((NetworkSecurityStubSettings) getStubSettings()).createServerTlsPolicySettings();
  }

  /** Returns the object with the settings used for calls to createServerTlsPolicy. */
  public OperationCallSettings<CreateServerTlsPolicyRequest, ServerTlsPolicy, OperationMetadata>
      createServerTlsPolicyOperationSettings() {
    return ((NetworkSecurityStubSettings) getStubSettings())
        .createServerTlsPolicyOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateServerTlsPolicy. */
  public UnaryCallSettings<UpdateServerTlsPolicyRequest, Operation>
      updateServerTlsPolicySettings() {
    return ((NetworkSecurityStubSettings) getStubSettings()).updateServerTlsPolicySettings();
  }

  /** Returns the object with the settings used for calls to updateServerTlsPolicy. */
  public OperationCallSettings<UpdateServerTlsPolicyRequest, ServerTlsPolicy, OperationMetadata>
      updateServerTlsPolicyOperationSettings() {
    return ((NetworkSecurityStubSettings) getStubSettings())
        .updateServerTlsPolicyOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteServerTlsPolicy. */
  public UnaryCallSettings<DeleteServerTlsPolicyRequest, Operation>
      deleteServerTlsPolicySettings() {
    return ((NetworkSecurityStubSettings) getStubSettings()).deleteServerTlsPolicySettings();
  }

  /** Returns the object with the settings used for calls to deleteServerTlsPolicy. */
  public OperationCallSettings<DeleteServerTlsPolicyRequest, Empty, OperationMetadata>
      deleteServerTlsPolicyOperationSettings() {
    return ((NetworkSecurityStubSettings) getStubSettings())
        .deleteServerTlsPolicyOperationSettings();
  }

  /** Returns the object with the settings used for calls to listClientTlsPolicies. */
  public PagedCallSettings<
          ListClientTlsPoliciesRequest,
          ListClientTlsPoliciesResponse,
          ListClientTlsPoliciesPagedResponse>
      listClientTlsPoliciesSettings() {
    return ((NetworkSecurityStubSettings) getStubSettings()).listClientTlsPoliciesSettings();
  }

  /** Returns the object with the settings used for calls to getClientTlsPolicy. */
  public UnaryCallSettings<GetClientTlsPolicyRequest, ClientTlsPolicy>
      getClientTlsPolicySettings() {
    return ((NetworkSecurityStubSettings) getStubSettings()).getClientTlsPolicySettings();
  }

  /** Returns the object with the settings used for calls to createClientTlsPolicy. */
  public UnaryCallSettings<CreateClientTlsPolicyRequest, Operation>
      createClientTlsPolicySettings() {
    return ((NetworkSecurityStubSettings) getStubSettings()).createClientTlsPolicySettings();
  }

  /** Returns the object with the settings used for calls to createClientTlsPolicy. */
  public OperationCallSettings<CreateClientTlsPolicyRequest, ClientTlsPolicy, OperationMetadata>
      createClientTlsPolicyOperationSettings() {
    return ((NetworkSecurityStubSettings) getStubSettings())
        .createClientTlsPolicyOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateClientTlsPolicy. */
  public UnaryCallSettings<UpdateClientTlsPolicyRequest, Operation>
      updateClientTlsPolicySettings() {
    return ((NetworkSecurityStubSettings) getStubSettings()).updateClientTlsPolicySettings();
  }

  /** Returns the object with the settings used for calls to updateClientTlsPolicy. */
  public OperationCallSettings<UpdateClientTlsPolicyRequest, ClientTlsPolicy, OperationMetadata>
      updateClientTlsPolicyOperationSettings() {
    return ((NetworkSecurityStubSettings) getStubSettings())
        .updateClientTlsPolicyOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteClientTlsPolicy. */
  public UnaryCallSettings<DeleteClientTlsPolicyRequest, Operation>
      deleteClientTlsPolicySettings() {
    return ((NetworkSecurityStubSettings) getStubSettings()).deleteClientTlsPolicySettings();
  }

  /** Returns the object with the settings used for calls to deleteClientTlsPolicy. */
  public OperationCallSettings<DeleteClientTlsPolicyRequest, Empty, OperationMetadata>
      deleteClientTlsPolicyOperationSettings() {
    return ((NetworkSecurityStubSettings) getStubSettings())
        .deleteClientTlsPolicyOperationSettings();
  }

  public static final NetworkSecuritySettings create(NetworkSecurityStubSettings stub)
      throws IOException {
    return new NetworkSecuritySettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return NetworkSecurityStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return NetworkSecurityStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return NetworkSecurityStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return NetworkSecurityStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return NetworkSecurityStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return NetworkSecurityStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return NetworkSecurityStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected NetworkSecuritySettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for NetworkSecuritySettings. */
  public static class Builder extends ClientSettings.Builder<NetworkSecuritySettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(NetworkSecurityStubSettings.newBuilder(clientContext));
    }

    protected Builder(NetworkSecuritySettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(NetworkSecurityStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(NetworkSecurityStubSettings.newBuilder());
    }

    public NetworkSecurityStubSettings.Builder getStubSettingsBuilder() {
      return ((NetworkSecurityStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to listAuthorizationPolicies. */
    public PagedCallSettings.Builder<
            ListAuthorizationPoliciesRequest,
            ListAuthorizationPoliciesResponse,
            ListAuthorizationPoliciesPagedResponse>
        listAuthorizationPoliciesSettings() {
      return getStubSettingsBuilder().listAuthorizationPoliciesSettings();
    }

    /** Returns the builder for the settings used for calls to getAuthorizationPolicy. */
    public UnaryCallSettings.Builder<GetAuthorizationPolicyRequest, AuthorizationPolicy>
        getAuthorizationPolicySettings() {
      return getStubSettingsBuilder().getAuthorizationPolicySettings();
    }

    /** Returns the builder for the settings used for calls to createAuthorizationPolicy. */
    public UnaryCallSettings.Builder<CreateAuthorizationPolicyRequest, Operation>
        createAuthorizationPolicySettings() {
      return getStubSettingsBuilder().createAuthorizationPolicySettings();
    }

    /** Returns the builder for the settings used for calls to createAuthorizationPolicy. */
    public OperationCallSettings.Builder<
            CreateAuthorizationPolicyRequest, AuthorizationPolicy, OperationMetadata>
        createAuthorizationPolicyOperationSettings() {
      return getStubSettingsBuilder().createAuthorizationPolicyOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateAuthorizationPolicy. */
    public UnaryCallSettings.Builder<UpdateAuthorizationPolicyRequest, Operation>
        updateAuthorizationPolicySettings() {
      return getStubSettingsBuilder().updateAuthorizationPolicySettings();
    }

    /** Returns the builder for the settings used for calls to updateAuthorizationPolicy. */
    public OperationCallSettings.Builder<
            UpdateAuthorizationPolicyRequest, AuthorizationPolicy, OperationMetadata>
        updateAuthorizationPolicyOperationSettings() {
      return getStubSettingsBuilder().updateAuthorizationPolicyOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteAuthorizationPolicy. */
    public UnaryCallSettings.Builder<DeleteAuthorizationPolicyRequest, Operation>
        deleteAuthorizationPolicySettings() {
      return getStubSettingsBuilder().deleteAuthorizationPolicySettings();
    }

    /** Returns the builder for the settings used for calls to deleteAuthorizationPolicy. */
    public OperationCallSettings.Builder<DeleteAuthorizationPolicyRequest, Empty, OperationMetadata>
        deleteAuthorizationPolicyOperationSettings() {
      return getStubSettingsBuilder().deleteAuthorizationPolicyOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listServerTlsPolicies. */
    public PagedCallSettings.Builder<
            ListServerTlsPoliciesRequest,
            ListServerTlsPoliciesResponse,
            ListServerTlsPoliciesPagedResponse>
        listServerTlsPoliciesSettings() {
      return getStubSettingsBuilder().listServerTlsPoliciesSettings();
    }

    /** Returns the builder for the settings used for calls to getServerTlsPolicy. */
    public UnaryCallSettings.Builder<GetServerTlsPolicyRequest, ServerTlsPolicy>
        getServerTlsPolicySettings() {
      return getStubSettingsBuilder().getServerTlsPolicySettings();
    }

    /** Returns the builder for the settings used for calls to createServerTlsPolicy. */
    public UnaryCallSettings.Builder<CreateServerTlsPolicyRequest, Operation>
        createServerTlsPolicySettings() {
      return getStubSettingsBuilder().createServerTlsPolicySettings();
    }

    /** Returns the builder for the settings used for calls to createServerTlsPolicy. */
    public OperationCallSettings.Builder<
            CreateServerTlsPolicyRequest, ServerTlsPolicy, OperationMetadata>
        createServerTlsPolicyOperationSettings() {
      return getStubSettingsBuilder().createServerTlsPolicyOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateServerTlsPolicy. */
    public UnaryCallSettings.Builder<UpdateServerTlsPolicyRequest, Operation>
        updateServerTlsPolicySettings() {
      return getStubSettingsBuilder().updateServerTlsPolicySettings();
    }

    /** Returns the builder for the settings used for calls to updateServerTlsPolicy. */
    public OperationCallSettings.Builder<
            UpdateServerTlsPolicyRequest, ServerTlsPolicy, OperationMetadata>
        updateServerTlsPolicyOperationSettings() {
      return getStubSettingsBuilder().updateServerTlsPolicyOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteServerTlsPolicy. */
    public UnaryCallSettings.Builder<DeleteServerTlsPolicyRequest, Operation>
        deleteServerTlsPolicySettings() {
      return getStubSettingsBuilder().deleteServerTlsPolicySettings();
    }

    /** Returns the builder for the settings used for calls to deleteServerTlsPolicy. */
    public OperationCallSettings.Builder<DeleteServerTlsPolicyRequest, Empty, OperationMetadata>
        deleteServerTlsPolicyOperationSettings() {
      return getStubSettingsBuilder().deleteServerTlsPolicyOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listClientTlsPolicies. */
    public PagedCallSettings.Builder<
            ListClientTlsPoliciesRequest,
            ListClientTlsPoliciesResponse,
            ListClientTlsPoliciesPagedResponse>
        listClientTlsPoliciesSettings() {
      return getStubSettingsBuilder().listClientTlsPoliciesSettings();
    }

    /** Returns the builder for the settings used for calls to getClientTlsPolicy. */
    public UnaryCallSettings.Builder<GetClientTlsPolicyRequest, ClientTlsPolicy>
        getClientTlsPolicySettings() {
      return getStubSettingsBuilder().getClientTlsPolicySettings();
    }

    /** Returns the builder for the settings used for calls to createClientTlsPolicy. */
    public UnaryCallSettings.Builder<CreateClientTlsPolicyRequest, Operation>
        createClientTlsPolicySettings() {
      return getStubSettingsBuilder().createClientTlsPolicySettings();
    }

    /** Returns the builder for the settings used for calls to createClientTlsPolicy. */
    public OperationCallSettings.Builder<
            CreateClientTlsPolicyRequest, ClientTlsPolicy, OperationMetadata>
        createClientTlsPolicyOperationSettings() {
      return getStubSettingsBuilder().createClientTlsPolicyOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateClientTlsPolicy. */
    public UnaryCallSettings.Builder<UpdateClientTlsPolicyRequest, Operation>
        updateClientTlsPolicySettings() {
      return getStubSettingsBuilder().updateClientTlsPolicySettings();
    }

    /** Returns the builder for the settings used for calls to updateClientTlsPolicy. */
    public OperationCallSettings.Builder<
            UpdateClientTlsPolicyRequest, ClientTlsPolicy, OperationMetadata>
        updateClientTlsPolicyOperationSettings() {
      return getStubSettingsBuilder().updateClientTlsPolicyOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteClientTlsPolicy. */
    public UnaryCallSettings.Builder<DeleteClientTlsPolicyRequest, Operation>
        deleteClientTlsPolicySettings() {
      return getStubSettingsBuilder().deleteClientTlsPolicySettings();
    }

    /** Returns the builder for the settings used for calls to deleteClientTlsPolicy. */
    public OperationCallSettings.Builder<DeleteClientTlsPolicyRequest, Empty, OperationMetadata>
        deleteClientTlsPolicyOperationSettings() {
      return getStubSettingsBuilder().deleteClientTlsPolicyOperationSettings();
    }

    @Override
    public NetworkSecuritySettings build() throws IOException {
      return new NetworkSecuritySettings(this);
    }
  }
}
