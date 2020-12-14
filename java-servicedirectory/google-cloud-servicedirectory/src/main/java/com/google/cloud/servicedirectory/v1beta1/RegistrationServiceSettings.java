/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.servicedirectory.v1beta1;

import static com.google.cloud.servicedirectory.v1beta1.RegistrationServiceClient.ListEndpointsPagedResponse;
import static com.google.cloud.servicedirectory.v1beta1.RegistrationServiceClient.ListNamespacesPagedResponse;
import static com.google.cloud.servicedirectory.v1beta1.RegistrationServiceClient.ListServicesPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.servicedirectory.v1beta1.stub.RegistrationServiceStubSettings;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link RegistrationServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (servicedirectory.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of createNamespace to 30 seconds:
 *
 * <pre>{@code
 * RegistrationServiceSettings.Builder registrationServiceSettingsBuilder =
 *     RegistrationServiceSettings.newBuilder();
 * registrationServiceSettingsBuilder
 *     .createNamespaceSettings()
 *     .setRetrySettings(
 *         registrationServiceSettingsBuilder
 *             .createNamespaceSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * RegistrationServiceSettings registrationServiceSettings =
 *     registrationServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class RegistrationServiceSettings extends ClientSettings<RegistrationServiceSettings> {

  /** Returns the object with the settings used for calls to createNamespace. */
  public UnaryCallSettings<CreateNamespaceRequest, Namespace> createNamespaceSettings() {
    return ((RegistrationServiceStubSettings) getStubSettings()).createNamespaceSettings();
  }

  /** Returns the object with the settings used for calls to listNamespaces. */
  public PagedCallSettings<
          ListNamespacesRequest, ListNamespacesResponse, ListNamespacesPagedResponse>
      listNamespacesSettings() {
    return ((RegistrationServiceStubSettings) getStubSettings()).listNamespacesSettings();
  }

  /** Returns the object with the settings used for calls to getNamespace. */
  public UnaryCallSettings<GetNamespaceRequest, Namespace> getNamespaceSettings() {
    return ((RegistrationServiceStubSettings) getStubSettings()).getNamespaceSettings();
  }

  /** Returns the object with the settings used for calls to updateNamespace. */
  public UnaryCallSettings<UpdateNamespaceRequest, Namespace> updateNamespaceSettings() {
    return ((RegistrationServiceStubSettings) getStubSettings()).updateNamespaceSettings();
  }

  /** Returns the object with the settings used for calls to deleteNamespace. */
  public UnaryCallSettings<DeleteNamespaceRequest, Empty> deleteNamespaceSettings() {
    return ((RegistrationServiceStubSettings) getStubSettings()).deleteNamespaceSettings();
  }

  /** Returns the object with the settings used for calls to createService. */
  public UnaryCallSettings<CreateServiceRequest, Service> createServiceSettings() {
    return ((RegistrationServiceStubSettings) getStubSettings()).createServiceSettings();
  }

  /** Returns the object with the settings used for calls to listServices. */
  public PagedCallSettings<ListServicesRequest, ListServicesResponse, ListServicesPagedResponse>
      listServicesSettings() {
    return ((RegistrationServiceStubSettings) getStubSettings()).listServicesSettings();
  }

  /** Returns the object with the settings used for calls to getService. */
  public UnaryCallSettings<GetServiceRequest, Service> getServiceSettings() {
    return ((RegistrationServiceStubSettings) getStubSettings()).getServiceSettings();
  }

  /** Returns the object with the settings used for calls to updateService. */
  public UnaryCallSettings<UpdateServiceRequest, Service> updateServiceSettings() {
    return ((RegistrationServiceStubSettings) getStubSettings()).updateServiceSettings();
  }

  /** Returns the object with the settings used for calls to deleteService. */
  public UnaryCallSettings<DeleteServiceRequest, Empty> deleteServiceSettings() {
    return ((RegistrationServiceStubSettings) getStubSettings()).deleteServiceSettings();
  }

  /** Returns the object with the settings used for calls to createEndpoint. */
  public UnaryCallSettings<CreateEndpointRequest, Endpoint> createEndpointSettings() {
    return ((RegistrationServiceStubSettings) getStubSettings()).createEndpointSettings();
  }

  /** Returns the object with the settings used for calls to listEndpoints. */
  public PagedCallSettings<ListEndpointsRequest, ListEndpointsResponse, ListEndpointsPagedResponse>
      listEndpointsSettings() {
    return ((RegistrationServiceStubSettings) getStubSettings()).listEndpointsSettings();
  }

  /** Returns the object with the settings used for calls to getEndpoint. */
  public UnaryCallSettings<GetEndpointRequest, Endpoint> getEndpointSettings() {
    return ((RegistrationServiceStubSettings) getStubSettings()).getEndpointSettings();
  }

  /** Returns the object with the settings used for calls to updateEndpoint. */
  public UnaryCallSettings<UpdateEndpointRequest, Endpoint> updateEndpointSettings() {
    return ((RegistrationServiceStubSettings) getStubSettings()).updateEndpointSettings();
  }

  /** Returns the object with the settings used for calls to deleteEndpoint. */
  public UnaryCallSettings<DeleteEndpointRequest, Empty> deleteEndpointSettings() {
    return ((RegistrationServiceStubSettings) getStubSettings()).deleteEndpointSettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return ((RegistrationServiceStubSettings) getStubSettings()).getIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return ((RegistrationServiceStubSettings) getStubSettings()).setIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return ((RegistrationServiceStubSettings) getStubSettings()).testIamPermissionsSettings();
  }

  public static final RegistrationServiceSettings create(RegistrationServiceStubSettings stub)
      throws IOException {
    return new RegistrationServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return RegistrationServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return RegistrationServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return RegistrationServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return RegistrationServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return RegistrationServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return RegistrationServiceStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return RegistrationServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected RegistrationServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for RegistrationServiceSettings. */
  public static class Builder extends ClientSettings.Builder<RegistrationServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(RegistrationServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(RegistrationServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(RegistrationServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(RegistrationServiceStubSettings.newBuilder());
    }

    public RegistrationServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((RegistrationServiceStubSettings.Builder) getStubSettings());
    }

    // NEXT_MAJOR_VER: remove 'throws Exception'.
    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) throws Exception {
      super.applyToAllUnaryMethods(
          getStubSettingsBuilder().unaryMethodSettingsBuilders(), settingsUpdater);
      return this;
    }

    /** Returns the builder for the settings used for calls to createNamespace. */
    public UnaryCallSettings.Builder<CreateNamespaceRequest, Namespace> createNamespaceSettings() {
      return getStubSettingsBuilder().createNamespaceSettings();
    }

    /** Returns the builder for the settings used for calls to listNamespaces. */
    public PagedCallSettings.Builder<
            ListNamespacesRequest, ListNamespacesResponse, ListNamespacesPagedResponse>
        listNamespacesSettings() {
      return getStubSettingsBuilder().listNamespacesSettings();
    }

    /** Returns the builder for the settings used for calls to getNamespace. */
    public UnaryCallSettings.Builder<GetNamespaceRequest, Namespace> getNamespaceSettings() {
      return getStubSettingsBuilder().getNamespaceSettings();
    }

    /** Returns the builder for the settings used for calls to updateNamespace. */
    public UnaryCallSettings.Builder<UpdateNamespaceRequest, Namespace> updateNamespaceSettings() {
      return getStubSettingsBuilder().updateNamespaceSettings();
    }

    /** Returns the builder for the settings used for calls to deleteNamespace. */
    public UnaryCallSettings.Builder<DeleteNamespaceRequest, Empty> deleteNamespaceSettings() {
      return getStubSettingsBuilder().deleteNamespaceSettings();
    }

    /** Returns the builder for the settings used for calls to createService. */
    public UnaryCallSettings.Builder<CreateServiceRequest, Service> createServiceSettings() {
      return getStubSettingsBuilder().createServiceSettings();
    }

    /** Returns the builder for the settings used for calls to listServices. */
    public PagedCallSettings.Builder<
            ListServicesRequest, ListServicesResponse, ListServicesPagedResponse>
        listServicesSettings() {
      return getStubSettingsBuilder().listServicesSettings();
    }

    /** Returns the builder for the settings used for calls to getService. */
    public UnaryCallSettings.Builder<GetServiceRequest, Service> getServiceSettings() {
      return getStubSettingsBuilder().getServiceSettings();
    }

    /** Returns the builder for the settings used for calls to updateService. */
    public UnaryCallSettings.Builder<UpdateServiceRequest, Service> updateServiceSettings() {
      return getStubSettingsBuilder().updateServiceSettings();
    }

    /** Returns the builder for the settings used for calls to deleteService. */
    public UnaryCallSettings.Builder<DeleteServiceRequest, Empty> deleteServiceSettings() {
      return getStubSettingsBuilder().deleteServiceSettings();
    }

    /** Returns the builder for the settings used for calls to createEndpoint. */
    public UnaryCallSettings.Builder<CreateEndpointRequest, Endpoint> createEndpointSettings() {
      return getStubSettingsBuilder().createEndpointSettings();
    }

    /** Returns the builder for the settings used for calls to listEndpoints. */
    public PagedCallSettings.Builder<
            ListEndpointsRequest, ListEndpointsResponse, ListEndpointsPagedResponse>
        listEndpointsSettings() {
      return getStubSettingsBuilder().listEndpointsSettings();
    }

    /** Returns the builder for the settings used for calls to getEndpoint. */
    public UnaryCallSettings.Builder<GetEndpointRequest, Endpoint> getEndpointSettings() {
      return getStubSettingsBuilder().getEndpointSettings();
    }

    /** Returns the builder for the settings used for calls to updateEndpoint. */
    public UnaryCallSettings.Builder<UpdateEndpointRequest, Endpoint> updateEndpointSettings() {
      return getStubSettingsBuilder().updateEndpointSettings();
    }

    /** Returns the builder for the settings used for calls to deleteEndpoint. */
    public UnaryCallSettings.Builder<DeleteEndpointRequest, Empty> deleteEndpointSettings() {
      return getStubSettingsBuilder().deleteEndpointSettings();
    }

    /** Returns the builder for the settings used for calls to getIamPolicy. */
    public UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings() {
      return getStubSettingsBuilder().getIamPolicySettings();
    }

    /** Returns the builder for the settings used for calls to setIamPolicy. */
    public UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings() {
      return getStubSettingsBuilder().setIamPolicySettings();
    }

    /** Returns the builder for the settings used for calls to testIamPermissions. */
    public UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings() {
      return getStubSettingsBuilder().testIamPermissionsSettings();
    }

    @Override
    public RegistrationServiceSettings build() throws IOException {
      return new RegistrationServiceSettings(this);
    }
  }
}
