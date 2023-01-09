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

package com.google.cloud.api.servicemanagement.v1;

import static com.google.cloud.api.servicemanagement.v1.ServiceManagerClient.ListServiceConfigsPagedResponse;
import static com.google.cloud.api.servicemanagement.v1.ServiceManagerClient.ListServiceRolloutsPagedResponse;
import static com.google.cloud.api.servicemanagement.v1.ServiceManagerClient.ListServicesPagedResponse;

import com.google.api.Service;
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
import com.google.api.servicemanagement.v1.CreateServiceConfigRequest;
import com.google.api.servicemanagement.v1.CreateServiceRequest;
import com.google.api.servicemanagement.v1.CreateServiceRolloutRequest;
import com.google.api.servicemanagement.v1.DeleteServiceRequest;
import com.google.api.servicemanagement.v1.GenerateConfigReportRequest;
import com.google.api.servicemanagement.v1.GenerateConfigReportResponse;
import com.google.api.servicemanagement.v1.GetServiceConfigRequest;
import com.google.api.servicemanagement.v1.GetServiceRequest;
import com.google.api.servicemanagement.v1.GetServiceRolloutRequest;
import com.google.api.servicemanagement.v1.ListServiceConfigsRequest;
import com.google.api.servicemanagement.v1.ListServiceConfigsResponse;
import com.google.api.servicemanagement.v1.ListServiceRolloutsRequest;
import com.google.api.servicemanagement.v1.ListServiceRolloutsResponse;
import com.google.api.servicemanagement.v1.ListServicesRequest;
import com.google.api.servicemanagement.v1.ListServicesResponse;
import com.google.api.servicemanagement.v1.ManagedService;
import com.google.api.servicemanagement.v1.OperationMetadata;
import com.google.api.servicemanagement.v1.Rollout;
import com.google.api.servicemanagement.v1.SubmitConfigSourceRequest;
import com.google.api.servicemanagement.v1.SubmitConfigSourceResponse;
import com.google.api.servicemanagement.v1.UndeleteServiceRequest;
import com.google.api.servicemanagement.v1.UndeleteServiceResponse;
import com.google.cloud.api.servicemanagement.v1.stub.ServiceManagerStubSettings;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link ServiceManagerClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (servicemanagement.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getService to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ServiceManagerSettings.Builder serviceManagerSettingsBuilder =
 *     ServiceManagerSettings.newBuilder();
 * serviceManagerSettingsBuilder
 *     .getServiceSettings()
 *     .setRetrySettings(
 *         serviceManagerSettingsBuilder
 *             .getServiceSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * ServiceManagerSettings serviceManagerSettings = serviceManagerSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class ServiceManagerSettings extends ClientSettings<ServiceManagerSettings> {

  /** Returns the object with the settings used for calls to listServices. */
  public PagedCallSettings<ListServicesRequest, ListServicesResponse, ListServicesPagedResponse>
      listServicesSettings() {
    return ((ServiceManagerStubSettings) getStubSettings()).listServicesSettings();
  }

  /** Returns the object with the settings used for calls to getService. */
  public UnaryCallSettings<GetServiceRequest, ManagedService> getServiceSettings() {
    return ((ServiceManagerStubSettings) getStubSettings()).getServiceSettings();
  }

  /** Returns the object with the settings used for calls to createService. */
  public UnaryCallSettings<CreateServiceRequest, Operation> createServiceSettings() {
    return ((ServiceManagerStubSettings) getStubSettings()).createServiceSettings();
  }

  /** Returns the object with the settings used for calls to createService. */
  public OperationCallSettings<CreateServiceRequest, ManagedService, OperationMetadata>
      createServiceOperationSettings() {
    return ((ServiceManagerStubSettings) getStubSettings()).createServiceOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteService. */
  public UnaryCallSettings<DeleteServiceRequest, Operation> deleteServiceSettings() {
    return ((ServiceManagerStubSettings) getStubSettings()).deleteServiceSettings();
  }

  /** Returns the object with the settings used for calls to deleteService. */
  public OperationCallSettings<DeleteServiceRequest, Empty, OperationMetadata>
      deleteServiceOperationSettings() {
    return ((ServiceManagerStubSettings) getStubSettings()).deleteServiceOperationSettings();
  }

  /** Returns the object with the settings used for calls to undeleteService. */
  public UnaryCallSettings<UndeleteServiceRequest, Operation> undeleteServiceSettings() {
    return ((ServiceManagerStubSettings) getStubSettings()).undeleteServiceSettings();
  }

  /** Returns the object with the settings used for calls to undeleteService. */
  public OperationCallSettings<UndeleteServiceRequest, UndeleteServiceResponse, OperationMetadata>
      undeleteServiceOperationSettings() {
    return ((ServiceManagerStubSettings) getStubSettings()).undeleteServiceOperationSettings();
  }

  /** Returns the object with the settings used for calls to listServiceConfigs. */
  public PagedCallSettings<
          ListServiceConfigsRequest, ListServiceConfigsResponse, ListServiceConfigsPagedResponse>
      listServiceConfigsSettings() {
    return ((ServiceManagerStubSettings) getStubSettings()).listServiceConfigsSettings();
  }

  /** Returns the object with the settings used for calls to getServiceConfig. */
  public UnaryCallSettings<GetServiceConfigRequest, Service> getServiceConfigSettings() {
    return ((ServiceManagerStubSettings) getStubSettings()).getServiceConfigSettings();
  }

  /** Returns the object with the settings used for calls to createServiceConfig. */
  public UnaryCallSettings<CreateServiceConfigRequest, Service> createServiceConfigSettings() {
    return ((ServiceManagerStubSettings) getStubSettings()).createServiceConfigSettings();
  }

  /** Returns the object with the settings used for calls to submitConfigSource. */
  public UnaryCallSettings<SubmitConfigSourceRequest, Operation> submitConfigSourceSettings() {
    return ((ServiceManagerStubSettings) getStubSettings()).submitConfigSourceSettings();
  }

  /** Returns the object with the settings used for calls to submitConfigSource. */
  public OperationCallSettings<
          SubmitConfigSourceRequest, SubmitConfigSourceResponse, OperationMetadata>
      submitConfigSourceOperationSettings() {
    return ((ServiceManagerStubSettings) getStubSettings()).submitConfigSourceOperationSettings();
  }

  /** Returns the object with the settings used for calls to listServiceRollouts. */
  public PagedCallSettings<
          ListServiceRolloutsRequest, ListServiceRolloutsResponse, ListServiceRolloutsPagedResponse>
      listServiceRolloutsSettings() {
    return ((ServiceManagerStubSettings) getStubSettings()).listServiceRolloutsSettings();
  }

  /** Returns the object with the settings used for calls to getServiceRollout. */
  public UnaryCallSettings<GetServiceRolloutRequest, Rollout> getServiceRolloutSettings() {
    return ((ServiceManagerStubSettings) getStubSettings()).getServiceRolloutSettings();
  }

  /** Returns the object with the settings used for calls to createServiceRollout. */
  public UnaryCallSettings<CreateServiceRolloutRequest, Operation> createServiceRolloutSettings() {
    return ((ServiceManagerStubSettings) getStubSettings()).createServiceRolloutSettings();
  }

  /** Returns the object with the settings used for calls to createServiceRollout. */
  public OperationCallSettings<CreateServiceRolloutRequest, Rollout, OperationMetadata>
      createServiceRolloutOperationSettings() {
    return ((ServiceManagerStubSettings) getStubSettings()).createServiceRolloutOperationSettings();
  }

  /** Returns the object with the settings used for calls to generateConfigReport. */
  public UnaryCallSettings<GenerateConfigReportRequest, GenerateConfigReportResponse>
      generateConfigReportSettings() {
    return ((ServiceManagerStubSettings) getStubSettings()).generateConfigReportSettings();
  }

  public static final ServiceManagerSettings create(ServiceManagerStubSettings stub)
      throws IOException {
    return new ServiceManagerSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return ServiceManagerStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return ServiceManagerStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return ServiceManagerStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return ServiceManagerStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return ServiceManagerStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return ServiceManagerStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return ServiceManagerStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ServiceManagerStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected ServiceManagerSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for ServiceManagerSettings. */
  public static class Builder extends ClientSettings.Builder<ServiceManagerSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(ServiceManagerStubSettings.newBuilder(clientContext));
    }

    protected Builder(ServiceManagerSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(ServiceManagerStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(ServiceManagerStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(ServiceManagerStubSettings.newHttpJsonBuilder());
    }

    public ServiceManagerStubSettings.Builder getStubSettingsBuilder() {
      return ((ServiceManagerStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to listServices. */
    public PagedCallSettings.Builder<
            ListServicesRequest, ListServicesResponse, ListServicesPagedResponse>
        listServicesSettings() {
      return getStubSettingsBuilder().listServicesSettings();
    }

    /** Returns the builder for the settings used for calls to getService. */
    public UnaryCallSettings.Builder<GetServiceRequest, ManagedService> getServiceSettings() {
      return getStubSettingsBuilder().getServiceSettings();
    }

    /** Returns the builder for the settings used for calls to createService. */
    public UnaryCallSettings.Builder<CreateServiceRequest, Operation> createServiceSettings() {
      return getStubSettingsBuilder().createServiceSettings();
    }

    /** Returns the builder for the settings used for calls to createService. */
    public OperationCallSettings.Builder<CreateServiceRequest, ManagedService, OperationMetadata>
        createServiceOperationSettings() {
      return getStubSettingsBuilder().createServiceOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteService. */
    public UnaryCallSettings.Builder<DeleteServiceRequest, Operation> deleteServiceSettings() {
      return getStubSettingsBuilder().deleteServiceSettings();
    }

    /** Returns the builder for the settings used for calls to deleteService. */
    public OperationCallSettings.Builder<DeleteServiceRequest, Empty, OperationMetadata>
        deleteServiceOperationSettings() {
      return getStubSettingsBuilder().deleteServiceOperationSettings();
    }

    /** Returns the builder for the settings used for calls to undeleteService. */
    public UnaryCallSettings.Builder<UndeleteServiceRequest, Operation> undeleteServiceSettings() {
      return getStubSettingsBuilder().undeleteServiceSettings();
    }

    /** Returns the builder for the settings used for calls to undeleteService. */
    public OperationCallSettings.Builder<
            UndeleteServiceRequest, UndeleteServiceResponse, OperationMetadata>
        undeleteServiceOperationSettings() {
      return getStubSettingsBuilder().undeleteServiceOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listServiceConfigs. */
    public PagedCallSettings.Builder<
            ListServiceConfigsRequest, ListServiceConfigsResponse, ListServiceConfigsPagedResponse>
        listServiceConfigsSettings() {
      return getStubSettingsBuilder().listServiceConfigsSettings();
    }

    /** Returns the builder for the settings used for calls to getServiceConfig. */
    public UnaryCallSettings.Builder<GetServiceConfigRequest, Service> getServiceConfigSettings() {
      return getStubSettingsBuilder().getServiceConfigSettings();
    }

    /** Returns the builder for the settings used for calls to createServiceConfig. */
    public UnaryCallSettings.Builder<CreateServiceConfigRequest, Service>
        createServiceConfigSettings() {
      return getStubSettingsBuilder().createServiceConfigSettings();
    }

    /** Returns the builder for the settings used for calls to submitConfigSource. */
    public UnaryCallSettings.Builder<SubmitConfigSourceRequest, Operation>
        submitConfigSourceSettings() {
      return getStubSettingsBuilder().submitConfigSourceSettings();
    }

    /** Returns the builder for the settings used for calls to submitConfigSource. */
    public OperationCallSettings.Builder<
            SubmitConfigSourceRequest, SubmitConfigSourceResponse, OperationMetadata>
        submitConfigSourceOperationSettings() {
      return getStubSettingsBuilder().submitConfigSourceOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listServiceRollouts. */
    public PagedCallSettings.Builder<
            ListServiceRolloutsRequest,
            ListServiceRolloutsResponse,
            ListServiceRolloutsPagedResponse>
        listServiceRolloutsSettings() {
      return getStubSettingsBuilder().listServiceRolloutsSettings();
    }

    /** Returns the builder for the settings used for calls to getServiceRollout. */
    public UnaryCallSettings.Builder<GetServiceRolloutRequest, Rollout>
        getServiceRolloutSettings() {
      return getStubSettingsBuilder().getServiceRolloutSettings();
    }

    /** Returns the builder for the settings used for calls to createServiceRollout. */
    public UnaryCallSettings.Builder<CreateServiceRolloutRequest, Operation>
        createServiceRolloutSettings() {
      return getStubSettingsBuilder().createServiceRolloutSettings();
    }

    /** Returns the builder for the settings used for calls to createServiceRollout. */
    public OperationCallSettings.Builder<CreateServiceRolloutRequest, Rollout, OperationMetadata>
        createServiceRolloutOperationSettings() {
      return getStubSettingsBuilder().createServiceRolloutOperationSettings();
    }

    /** Returns the builder for the settings used for calls to generateConfigReport. */
    public UnaryCallSettings.Builder<GenerateConfigReportRequest, GenerateConfigReportResponse>
        generateConfigReportSettings() {
      return getStubSettingsBuilder().generateConfigReportSettings();
    }

    @Override
    public ServiceManagerSettings build() throws IOException {
      return new ServiceManagerSettings(this);
    }
  }
}
