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

package com.google.cloud.monitoring.v3;

import static com.google.cloud.monitoring.v3.ServiceMonitoringServiceClient.ListServiceLevelObjectivesPagedResponse;
import static com.google.cloud.monitoring.v3.ServiceMonitoringServiceClient.ListServicesPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.monitoring.v3.stub.ServiceMonitoringServiceStubSettings;
import com.google.monitoring.v3.CreateServiceLevelObjectiveRequest;
import com.google.monitoring.v3.CreateServiceRequest;
import com.google.monitoring.v3.DeleteServiceLevelObjectiveRequest;
import com.google.monitoring.v3.DeleteServiceRequest;
import com.google.monitoring.v3.GetServiceLevelObjectiveRequest;
import com.google.monitoring.v3.GetServiceRequest;
import com.google.monitoring.v3.ListServiceLevelObjectivesRequest;
import com.google.monitoring.v3.ListServiceLevelObjectivesResponse;
import com.google.monitoring.v3.ListServicesRequest;
import com.google.monitoring.v3.ListServicesResponse;
import com.google.monitoring.v3.Service;
import com.google.monitoring.v3.ServiceLevelObjective;
import com.google.monitoring.v3.UpdateServiceLevelObjectiveRequest;
import com.google.monitoring.v3.UpdateServiceRequest;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link ServiceMonitoringServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (monitoring.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of createService to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ServiceMonitoringServiceSettings.Builder serviceMonitoringServiceSettingsBuilder =
 *     ServiceMonitoringServiceSettings.newBuilder();
 * serviceMonitoringServiceSettingsBuilder
 *     .createServiceSettings()
 *     .setRetrySettings(
 *         serviceMonitoringServiceSettingsBuilder
 *             .createServiceSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * ServiceMonitoringServiceSettings serviceMonitoringServiceSettings =
 *     serviceMonitoringServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class ServiceMonitoringServiceSettings
    extends ClientSettings<ServiceMonitoringServiceSettings> {

  /** Returns the object with the settings used for calls to createService. */
  public UnaryCallSettings<CreateServiceRequest, Service> createServiceSettings() {
    return ((ServiceMonitoringServiceStubSettings) getStubSettings()).createServiceSettings();
  }

  /** Returns the object with the settings used for calls to getService. */
  public UnaryCallSettings<GetServiceRequest, Service> getServiceSettings() {
    return ((ServiceMonitoringServiceStubSettings) getStubSettings()).getServiceSettings();
  }

  /** Returns the object with the settings used for calls to listServices. */
  public PagedCallSettings<ListServicesRequest, ListServicesResponse, ListServicesPagedResponse>
      listServicesSettings() {
    return ((ServiceMonitoringServiceStubSettings) getStubSettings()).listServicesSettings();
  }

  /** Returns the object with the settings used for calls to updateService. */
  public UnaryCallSettings<UpdateServiceRequest, Service> updateServiceSettings() {
    return ((ServiceMonitoringServiceStubSettings) getStubSettings()).updateServiceSettings();
  }

  /** Returns the object with the settings used for calls to deleteService. */
  public UnaryCallSettings<DeleteServiceRequest, Empty> deleteServiceSettings() {
    return ((ServiceMonitoringServiceStubSettings) getStubSettings()).deleteServiceSettings();
  }

  /** Returns the object with the settings used for calls to createServiceLevelObjective. */
  public UnaryCallSettings<CreateServiceLevelObjectiveRequest, ServiceLevelObjective>
      createServiceLevelObjectiveSettings() {
    return ((ServiceMonitoringServiceStubSettings) getStubSettings())
        .createServiceLevelObjectiveSettings();
  }

  /** Returns the object with the settings used for calls to getServiceLevelObjective. */
  public UnaryCallSettings<GetServiceLevelObjectiveRequest, ServiceLevelObjective>
      getServiceLevelObjectiveSettings() {
    return ((ServiceMonitoringServiceStubSettings) getStubSettings())
        .getServiceLevelObjectiveSettings();
  }

  /** Returns the object with the settings used for calls to listServiceLevelObjectives. */
  public PagedCallSettings<
          ListServiceLevelObjectivesRequest,
          ListServiceLevelObjectivesResponse,
          ListServiceLevelObjectivesPagedResponse>
      listServiceLevelObjectivesSettings() {
    return ((ServiceMonitoringServiceStubSettings) getStubSettings())
        .listServiceLevelObjectivesSettings();
  }

  /** Returns the object with the settings used for calls to updateServiceLevelObjective. */
  public UnaryCallSettings<UpdateServiceLevelObjectiveRequest, ServiceLevelObjective>
      updateServiceLevelObjectiveSettings() {
    return ((ServiceMonitoringServiceStubSettings) getStubSettings())
        .updateServiceLevelObjectiveSettings();
  }

  /** Returns the object with the settings used for calls to deleteServiceLevelObjective. */
  public UnaryCallSettings<DeleteServiceLevelObjectiveRequest, Empty>
      deleteServiceLevelObjectiveSettings() {
    return ((ServiceMonitoringServiceStubSettings) getStubSettings())
        .deleteServiceLevelObjectiveSettings();
  }

  public static final ServiceMonitoringServiceSettings create(
      ServiceMonitoringServiceStubSettings stub) throws IOException {
    return new ServiceMonitoringServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return ServiceMonitoringServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return ServiceMonitoringServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return ServiceMonitoringServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return ServiceMonitoringServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return ServiceMonitoringServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return ServiceMonitoringServiceStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ServiceMonitoringServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected ServiceMonitoringServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for ServiceMonitoringServiceSettings. */
  public static class Builder
      extends ClientSettings.Builder<ServiceMonitoringServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(ServiceMonitoringServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(ServiceMonitoringServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(ServiceMonitoringServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(ServiceMonitoringServiceStubSettings.newBuilder());
    }

    public ServiceMonitoringServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((ServiceMonitoringServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to createService. */
    public UnaryCallSettings.Builder<CreateServiceRequest, Service> createServiceSettings() {
      return getStubSettingsBuilder().createServiceSettings();
    }

    /** Returns the builder for the settings used for calls to getService. */
    public UnaryCallSettings.Builder<GetServiceRequest, Service> getServiceSettings() {
      return getStubSettingsBuilder().getServiceSettings();
    }

    /** Returns the builder for the settings used for calls to listServices. */
    public PagedCallSettings.Builder<
            ListServicesRequest, ListServicesResponse, ListServicesPagedResponse>
        listServicesSettings() {
      return getStubSettingsBuilder().listServicesSettings();
    }

    /** Returns the builder for the settings used for calls to updateService. */
    public UnaryCallSettings.Builder<UpdateServiceRequest, Service> updateServiceSettings() {
      return getStubSettingsBuilder().updateServiceSettings();
    }

    /** Returns the builder for the settings used for calls to deleteService. */
    public UnaryCallSettings.Builder<DeleteServiceRequest, Empty> deleteServiceSettings() {
      return getStubSettingsBuilder().deleteServiceSettings();
    }

    /** Returns the builder for the settings used for calls to createServiceLevelObjective. */
    public UnaryCallSettings.Builder<CreateServiceLevelObjectiveRequest, ServiceLevelObjective>
        createServiceLevelObjectiveSettings() {
      return getStubSettingsBuilder().createServiceLevelObjectiveSettings();
    }

    /** Returns the builder for the settings used for calls to getServiceLevelObjective. */
    public UnaryCallSettings.Builder<GetServiceLevelObjectiveRequest, ServiceLevelObjective>
        getServiceLevelObjectiveSettings() {
      return getStubSettingsBuilder().getServiceLevelObjectiveSettings();
    }

    /** Returns the builder for the settings used for calls to listServiceLevelObjectives. */
    public PagedCallSettings.Builder<
            ListServiceLevelObjectivesRequest,
            ListServiceLevelObjectivesResponse,
            ListServiceLevelObjectivesPagedResponse>
        listServiceLevelObjectivesSettings() {
      return getStubSettingsBuilder().listServiceLevelObjectivesSettings();
    }

    /** Returns the builder for the settings used for calls to updateServiceLevelObjective. */
    public UnaryCallSettings.Builder<UpdateServiceLevelObjectiveRequest, ServiceLevelObjective>
        updateServiceLevelObjectiveSettings() {
      return getStubSettingsBuilder().updateServiceLevelObjectiveSettings();
    }

    /** Returns the builder for the settings used for calls to deleteServiceLevelObjective. */
    public UnaryCallSettings.Builder<DeleteServiceLevelObjectiveRequest, Empty>
        deleteServiceLevelObjectiveSettings() {
      return getStubSettingsBuilder().deleteServiceLevelObjectiveSettings();
    }

    @Override
    public ServiceMonitoringServiceSettings build() throws IOException {
      return new ServiceMonitoringServiceSettings(this);
    }
  }
}
