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

package com.google.cloud.networkconnectivity.v1;

import static com.google.cloud.networkconnectivity.v1.PolicyBasedRoutingServiceClient.ListPolicyBasedRoutesPagedResponse;

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
import com.google.cloud.networkconnectivity.v1.stub.PolicyBasedRoutingServiceStubSettings;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link PolicyBasedRoutingServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (networkconnectivity.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getPolicyBasedRoute to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * PolicyBasedRoutingServiceSettings.Builder policyBasedRoutingServiceSettingsBuilder =
 *     PolicyBasedRoutingServiceSettings.newBuilder();
 * policyBasedRoutingServiceSettingsBuilder
 *     .getPolicyBasedRouteSettings()
 *     .setRetrySettings(
 *         policyBasedRoutingServiceSettingsBuilder
 *             .getPolicyBasedRouteSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * PolicyBasedRoutingServiceSettings policyBasedRoutingServiceSettings =
 *     policyBasedRoutingServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class PolicyBasedRoutingServiceSettings
    extends ClientSettings<PolicyBasedRoutingServiceSettings> {

  /** Returns the object with the settings used for calls to listPolicyBasedRoutes. */
  public PagedCallSettings<
          ListPolicyBasedRoutesRequest,
          ListPolicyBasedRoutesResponse,
          ListPolicyBasedRoutesPagedResponse>
      listPolicyBasedRoutesSettings() {
    return ((PolicyBasedRoutingServiceStubSettings) getStubSettings())
        .listPolicyBasedRoutesSettings();
  }

  /** Returns the object with the settings used for calls to getPolicyBasedRoute. */
  public UnaryCallSettings<GetPolicyBasedRouteRequest, PolicyBasedRoute>
      getPolicyBasedRouteSettings() {
    return ((PolicyBasedRoutingServiceStubSettings) getStubSettings())
        .getPolicyBasedRouteSettings();
  }

  /** Returns the object with the settings used for calls to createPolicyBasedRoute. */
  public UnaryCallSettings<CreatePolicyBasedRouteRequest, Operation>
      createPolicyBasedRouteSettings() {
    return ((PolicyBasedRoutingServiceStubSettings) getStubSettings())
        .createPolicyBasedRouteSettings();
  }

  /** Returns the object with the settings used for calls to createPolicyBasedRoute. */
  public OperationCallSettings<CreatePolicyBasedRouteRequest, PolicyBasedRoute, OperationMetadata>
      createPolicyBasedRouteOperationSettings() {
    return ((PolicyBasedRoutingServiceStubSettings) getStubSettings())
        .createPolicyBasedRouteOperationSettings();
  }

  /** Returns the object with the settings used for calls to deletePolicyBasedRoute. */
  public UnaryCallSettings<DeletePolicyBasedRouteRequest, Operation>
      deletePolicyBasedRouteSettings() {
    return ((PolicyBasedRoutingServiceStubSettings) getStubSettings())
        .deletePolicyBasedRouteSettings();
  }

  /** Returns the object with the settings used for calls to deletePolicyBasedRoute. */
  public OperationCallSettings<DeletePolicyBasedRouteRequest, Empty, OperationMetadata>
      deletePolicyBasedRouteOperationSettings() {
    return ((PolicyBasedRoutingServiceStubSettings) getStubSettings())
        .deletePolicyBasedRouteOperationSettings();
  }

  public static final PolicyBasedRoutingServiceSettings create(
      PolicyBasedRoutingServiceStubSettings stub) throws IOException {
    return new PolicyBasedRoutingServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return PolicyBasedRoutingServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return PolicyBasedRoutingServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return PolicyBasedRoutingServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return PolicyBasedRoutingServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return PolicyBasedRoutingServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return PolicyBasedRoutingServiceStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return PolicyBasedRoutingServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected PolicyBasedRoutingServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for PolicyBasedRoutingServiceSettings. */
  public static class Builder
      extends ClientSettings.Builder<PolicyBasedRoutingServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(PolicyBasedRoutingServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(PolicyBasedRoutingServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(PolicyBasedRoutingServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(PolicyBasedRoutingServiceStubSettings.newBuilder());
    }

    public PolicyBasedRoutingServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((PolicyBasedRoutingServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to listPolicyBasedRoutes. */
    public PagedCallSettings.Builder<
            ListPolicyBasedRoutesRequest,
            ListPolicyBasedRoutesResponse,
            ListPolicyBasedRoutesPagedResponse>
        listPolicyBasedRoutesSettings() {
      return getStubSettingsBuilder().listPolicyBasedRoutesSettings();
    }

    /** Returns the builder for the settings used for calls to getPolicyBasedRoute. */
    public UnaryCallSettings.Builder<GetPolicyBasedRouteRequest, PolicyBasedRoute>
        getPolicyBasedRouteSettings() {
      return getStubSettingsBuilder().getPolicyBasedRouteSettings();
    }

    /** Returns the builder for the settings used for calls to createPolicyBasedRoute. */
    public UnaryCallSettings.Builder<CreatePolicyBasedRouteRequest, Operation>
        createPolicyBasedRouteSettings() {
      return getStubSettingsBuilder().createPolicyBasedRouteSettings();
    }

    /** Returns the builder for the settings used for calls to createPolicyBasedRoute. */
    public OperationCallSettings.Builder<
            CreatePolicyBasedRouteRequest, PolicyBasedRoute, OperationMetadata>
        createPolicyBasedRouteOperationSettings() {
      return getStubSettingsBuilder().createPolicyBasedRouteOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deletePolicyBasedRoute. */
    public UnaryCallSettings.Builder<DeletePolicyBasedRouteRequest, Operation>
        deletePolicyBasedRouteSettings() {
      return getStubSettingsBuilder().deletePolicyBasedRouteSettings();
    }

    /** Returns the builder for the settings used for calls to deletePolicyBasedRoute. */
    public OperationCallSettings.Builder<DeletePolicyBasedRouteRequest, Empty, OperationMetadata>
        deletePolicyBasedRouteOperationSettings() {
      return getStubSettingsBuilder().deletePolicyBasedRouteOperationSettings();
    }

    @Override
    public PolicyBasedRoutingServiceSettings build() throws IOException {
      return new PolicyBasedRoutingServiceSettings(this);
    }
  }
}
