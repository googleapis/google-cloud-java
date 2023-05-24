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

package com.google.cloud.beyondcorp.clientgateways.v1;

import static com.google.cloud.beyondcorp.clientgateways.v1.ClientGatewaysServiceClient.ListClientGatewaysPagedResponse;
import static com.google.cloud.beyondcorp.clientgateways.v1.ClientGatewaysServiceClient.ListLocationsPagedResponse;

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
import com.google.cloud.beyondcorp.clientgateways.v1.stub.ClientGatewaysServiceStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link ClientGatewaysServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (beyondcorp.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getClientGateway to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ClientGatewaysServiceSettings.Builder clientGatewaysServiceSettingsBuilder =
 *     ClientGatewaysServiceSettings.newBuilder();
 * clientGatewaysServiceSettingsBuilder
 *     .getClientGatewaySettings()
 *     .setRetrySettings(
 *         clientGatewaysServiceSettingsBuilder
 *             .getClientGatewaySettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * ClientGatewaysServiceSettings clientGatewaysServiceSettings =
 *     clientGatewaysServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class ClientGatewaysServiceSettings extends ClientSettings<ClientGatewaysServiceSettings> {

  /** Returns the object with the settings used for calls to listClientGateways. */
  public PagedCallSettings<
          ListClientGatewaysRequest, ListClientGatewaysResponse, ListClientGatewaysPagedResponse>
      listClientGatewaysSettings() {
    return ((ClientGatewaysServiceStubSettings) getStubSettings()).listClientGatewaysSettings();
  }

  /** Returns the object with the settings used for calls to getClientGateway. */
  public UnaryCallSettings<GetClientGatewayRequest, ClientGateway> getClientGatewaySettings() {
    return ((ClientGatewaysServiceStubSettings) getStubSettings()).getClientGatewaySettings();
  }

  /** Returns the object with the settings used for calls to createClientGateway. */
  public UnaryCallSettings<CreateClientGatewayRequest, Operation> createClientGatewaySettings() {
    return ((ClientGatewaysServiceStubSettings) getStubSettings()).createClientGatewaySettings();
  }

  /** Returns the object with the settings used for calls to createClientGateway. */
  public OperationCallSettings<
          CreateClientGatewayRequest, ClientGateway, ClientGatewayOperationMetadata>
      createClientGatewayOperationSettings() {
    return ((ClientGatewaysServiceStubSettings) getStubSettings())
        .createClientGatewayOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteClientGateway. */
  public UnaryCallSettings<DeleteClientGatewayRequest, Operation> deleteClientGatewaySettings() {
    return ((ClientGatewaysServiceStubSettings) getStubSettings()).deleteClientGatewaySettings();
  }

  /** Returns the object with the settings used for calls to deleteClientGateway. */
  public OperationCallSettings<DeleteClientGatewayRequest, Empty, ClientGatewayOperationMetadata>
      deleteClientGatewayOperationSettings() {
    return ((ClientGatewaysServiceStubSettings) getStubSettings())
        .deleteClientGatewayOperationSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((ClientGatewaysServiceStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((ClientGatewaysServiceStubSettings) getStubSettings()).getLocationSettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return ((ClientGatewaysServiceStubSettings) getStubSettings()).setIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return ((ClientGatewaysServiceStubSettings) getStubSettings()).getIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return ((ClientGatewaysServiceStubSettings) getStubSettings()).testIamPermissionsSettings();
  }

  public static final ClientGatewaysServiceSettings create(ClientGatewaysServiceStubSettings stub)
      throws IOException {
    return new ClientGatewaysServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return ClientGatewaysServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return ClientGatewaysServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return ClientGatewaysServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return ClientGatewaysServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return ClientGatewaysServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return ClientGatewaysServiceStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ClientGatewaysServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected ClientGatewaysServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for ClientGatewaysServiceSettings. */
  public static class Builder
      extends ClientSettings.Builder<ClientGatewaysServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(ClientGatewaysServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(ClientGatewaysServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(ClientGatewaysServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(ClientGatewaysServiceStubSettings.newBuilder());
    }

    public ClientGatewaysServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((ClientGatewaysServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to listClientGateways. */
    public PagedCallSettings.Builder<
            ListClientGatewaysRequest, ListClientGatewaysResponse, ListClientGatewaysPagedResponse>
        listClientGatewaysSettings() {
      return getStubSettingsBuilder().listClientGatewaysSettings();
    }

    /** Returns the builder for the settings used for calls to getClientGateway. */
    public UnaryCallSettings.Builder<GetClientGatewayRequest, ClientGateway>
        getClientGatewaySettings() {
      return getStubSettingsBuilder().getClientGatewaySettings();
    }

    /** Returns the builder for the settings used for calls to createClientGateway. */
    public UnaryCallSettings.Builder<CreateClientGatewayRequest, Operation>
        createClientGatewaySettings() {
      return getStubSettingsBuilder().createClientGatewaySettings();
    }

    /** Returns the builder for the settings used for calls to createClientGateway. */
    public OperationCallSettings.Builder<
            CreateClientGatewayRequest, ClientGateway, ClientGatewayOperationMetadata>
        createClientGatewayOperationSettings() {
      return getStubSettingsBuilder().createClientGatewayOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteClientGateway. */
    public UnaryCallSettings.Builder<DeleteClientGatewayRequest, Operation>
        deleteClientGatewaySettings() {
      return getStubSettingsBuilder().deleteClientGatewaySettings();
    }

    /** Returns the builder for the settings used for calls to deleteClientGateway. */
    public OperationCallSettings.Builder<
            DeleteClientGatewayRequest, Empty, ClientGatewayOperationMetadata>
        deleteClientGatewayOperationSettings() {
      return getStubSettingsBuilder().deleteClientGatewayOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listLocations. */
    public PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings() {
      return getStubSettingsBuilder().listLocationsSettings();
    }

    /** Returns the builder for the settings used for calls to getLocation. */
    public UnaryCallSettings.Builder<GetLocationRequest, Location> getLocationSettings() {
      return getStubSettingsBuilder().getLocationSettings();
    }

    /** Returns the builder for the settings used for calls to setIamPolicy. */
    public UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings() {
      return getStubSettingsBuilder().setIamPolicySettings();
    }

    /** Returns the builder for the settings used for calls to getIamPolicy. */
    public UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings() {
      return getStubSettingsBuilder().getIamPolicySettings();
    }

    /** Returns the builder for the settings used for calls to testIamPermissions. */
    public UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings() {
      return getStubSettingsBuilder().testIamPermissionsSettings();
    }

    @Override
    public ClientGatewaysServiceSettings build() throws IOException {
      return new ClientGatewaysServiceSettings(this);
    }
  }
}
