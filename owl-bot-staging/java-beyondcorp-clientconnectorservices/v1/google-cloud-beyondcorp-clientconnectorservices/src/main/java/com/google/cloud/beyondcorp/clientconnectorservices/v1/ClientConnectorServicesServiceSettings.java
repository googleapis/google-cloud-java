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

package com.google.cloud.beyondcorp.clientconnectorservices.v1;

import static com.google.cloud.beyondcorp.clientconnectorservices.v1.ClientConnectorServicesServiceClient.ListClientConnectorServicesPagedResponse;
import static com.google.cloud.beyondcorp.clientconnectorservices.v1.ClientConnectorServicesServiceClient.ListLocationsPagedResponse;

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
import com.google.cloud.beyondcorp.clientconnectorservices.v1.stub.ClientConnectorServicesServiceStubSettings;
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
 * Settings class to configure an instance of {@link ClientConnectorServicesServiceClient}.
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
 * <p>For example, to set the total timeout of getClientConnectorService to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ClientConnectorServicesServiceSettings.Builder clientConnectorServicesServiceSettingsBuilder =
 *     ClientConnectorServicesServiceSettings.newBuilder();
 * clientConnectorServicesServiceSettingsBuilder
 *     .getClientConnectorServiceSettings()
 *     .setRetrySettings(
 *         clientConnectorServicesServiceSettingsBuilder
 *             .getClientConnectorServiceSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * ClientConnectorServicesServiceSettings clientConnectorServicesServiceSettings =
 *     clientConnectorServicesServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class ClientConnectorServicesServiceSettings
    extends ClientSettings<ClientConnectorServicesServiceSettings> {

  /** Returns the object with the settings used for calls to listClientConnectorServices. */
  public PagedCallSettings<
          ListClientConnectorServicesRequest,
          ListClientConnectorServicesResponse,
          ListClientConnectorServicesPagedResponse>
      listClientConnectorServicesSettings() {
    return ((ClientConnectorServicesServiceStubSettings) getStubSettings())
        .listClientConnectorServicesSettings();
  }

  /** Returns the object with the settings used for calls to getClientConnectorService. */
  public UnaryCallSettings<GetClientConnectorServiceRequest, ClientConnectorService>
      getClientConnectorServiceSettings() {
    return ((ClientConnectorServicesServiceStubSettings) getStubSettings())
        .getClientConnectorServiceSettings();
  }

  /** Returns the object with the settings used for calls to createClientConnectorService. */
  public UnaryCallSettings<CreateClientConnectorServiceRequest, Operation>
      createClientConnectorServiceSettings() {
    return ((ClientConnectorServicesServiceStubSettings) getStubSettings())
        .createClientConnectorServiceSettings();
  }

  /** Returns the object with the settings used for calls to createClientConnectorService. */
  public OperationCallSettings<
          CreateClientConnectorServiceRequest,
          ClientConnectorService,
          ClientConnectorServiceOperationMetadata>
      createClientConnectorServiceOperationSettings() {
    return ((ClientConnectorServicesServiceStubSettings) getStubSettings())
        .createClientConnectorServiceOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateClientConnectorService. */
  public UnaryCallSettings<UpdateClientConnectorServiceRequest, Operation>
      updateClientConnectorServiceSettings() {
    return ((ClientConnectorServicesServiceStubSettings) getStubSettings())
        .updateClientConnectorServiceSettings();
  }

  /** Returns the object with the settings used for calls to updateClientConnectorService. */
  public OperationCallSettings<
          UpdateClientConnectorServiceRequest,
          ClientConnectorService,
          ClientConnectorServiceOperationMetadata>
      updateClientConnectorServiceOperationSettings() {
    return ((ClientConnectorServicesServiceStubSettings) getStubSettings())
        .updateClientConnectorServiceOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteClientConnectorService. */
  public UnaryCallSettings<DeleteClientConnectorServiceRequest, Operation>
      deleteClientConnectorServiceSettings() {
    return ((ClientConnectorServicesServiceStubSettings) getStubSettings())
        .deleteClientConnectorServiceSettings();
  }

  /** Returns the object with the settings used for calls to deleteClientConnectorService. */
  public OperationCallSettings<
          DeleteClientConnectorServiceRequest, Empty, ClientConnectorServiceOperationMetadata>
      deleteClientConnectorServiceOperationSettings() {
    return ((ClientConnectorServicesServiceStubSettings) getStubSettings())
        .deleteClientConnectorServiceOperationSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((ClientConnectorServicesServiceStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((ClientConnectorServicesServiceStubSettings) getStubSettings()).getLocationSettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return ((ClientConnectorServicesServiceStubSettings) getStubSettings()).setIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return ((ClientConnectorServicesServiceStubSettings) getStubSettings()).getIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return ((ClientConnectorServicesServiceStubSettings) getStubSettings())
        .testIamPermissionsSettings();
  }

  public static final ClientConnectorServicesServiceSettings create(
      ClientConnectorServicesServiceStubSettings stub) throws IOException {
    return new ClientConnectorServicesServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return ClientConnectorServicesServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return ClientConnectorServicesServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return ClientConnectorServicesServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return ClientConnectorServicesServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return ClientConnectorServicesServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return ClientConnectorServicesServiceStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ClientConnectorServicesServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected ClientConnectorServicesServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for ClientConnectorServicesServiceSettings. */
  public static class Builder
      extends ClientSettings.Builder<ClientConnectorServicesServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(ClientConnectorServicesServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(ClientConnectorServicesServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(ClientConnectorServicesServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(ClientConnectorServicesServiceStubSettings.newBuilder());
    }

    public ClientConnectorServicesServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((ClientConnectorServicesServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to listClientConnectorServices. */
    public PagedCallSettings.Builder<
            ListClientConnectorServicesRequest,
            ListClientConnectorServicesResponse,
            ListClientConnectorServicesPagedResponse>
        listClientConnectorServicesSettings() {
      return getStubSettingsBuilder().listClientConnectorServicesSettings();
    }

    /** Returns the builder for the settings used for calls to getClientConnectorService. */
    public UnaryCallSettings.Builder<GetClientConnectorServiceRequest, ClientConnectorService>
        getClientConnectorServiceSettings() {
      return getStubSettingsBuilder().getClientConnectorServiceSettings();
    }

    /** Returns the builder for the settings used for calls to createClientConnectorService. */
    public UnaryCallSettings.Builder<CreateClientConnectorServiceRequest, Operation>
        createClientConnectorServiceSettings() {
      return getStubSettingsBuilder().createClientConnectorServiceSettings();
    }

    /** Returns the builder for the settings used for calls to createClientConnectorService. */
    public OperationCallSettings.Builder<
            CreateClientConnectorServiceRequest,
            ClientConnectorService,
            ClientConnectorServiceOperationMetadata>
        createClientConnectorServiceOperationSettings() {
      return getStubSettingsBuilder().createClientConnectorServiceOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateClientConnectorService. */
    public UnaryCallSettings.Builder<UpdateClientConnectorServiceRequest, Operation>
        updateClientConnectorServiceSettings() {
      return getStubSettingsBuilder().updateClientConnectorServiceSettings();
    }

    /** Returns the builder for the settings used for calls to updateClientConnectorService. */
    public OperationCallSettings.Builder<
            UpdateClientConnectorServiceRequest,
            ClientConnectorService,
            ClientConnectorServiceOperationMetadata>
        updateClientConnectorServiceOperationSettings() {
      return getStubSettingsBuilder().updateClientConnectorServiceOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteClientConnectorService. */
    public UnaryCallSettings.Builder<DeleteClientConnectorServiceRequest, Operation>
        deleteClientConnectorServiceSettings() {
      return getStubSettingsBuilder().deleteClientConnectorServiceSettings();
    }

    /** Returns the builder for the settings used for calls to deleteClientConnectorService. */
    public OperationCallSettings.Builder<
            DeleteClientConnectorServiceRequest, Empty, ClientConnectorServiceOperationMetadata>
        deleteClientConnectorServiceOperationSettings() {
      return getStubSettingsBuilder().deleteClientConnectorServiceOperationSettings();
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
    public ClientConnectorServicesServiceSettings build() throws IOException {
      return new ClientConnectorServicesServiceSettings(this);
    }
  }
}
