/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.apphub.v1;

import static com.google.cloud.apphub.v1.AppHubClient.ListApplicationsPagedResponse;
import static com.google.cloud.apphub.v1.AppHubClient.ListDiscoveredServicesPagedResponse;
import static com.google.cloud.apphub.v1.AppHubClient.ListDiscoveredWorkloadsPagedResponse;
import static com.google.cloud.apphub.v1.AppHubClient.ListLocationsPagedResponse;
import static com.google.cloud.apphub.v1.AppHubClient.ListServiceProjectAttachmentsPagedResponse;
import static com.google.cloud.apphub.v1.AppHubClient.ListServicesPagedResponse;
import static com.google.cloud.apphub.v1.AppHubClient.ListWorkloadsPagedResponse;

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
import com.google.cloud.apphub.v1.stub.AppHubStubSettings;
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
 * Settings class to configure an instance of {@link AppHubClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (apphub.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of lookupServiceProjectAttachment to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * AppHubSettings.Builder appHubSettingsBuilder = AppHubSettings.newBuilder();
 * appHubSettingsBuilder
 *     .lookupServiceProjectAttachmentSettings()
 *     .setRetrySettings(
 *         appHubSettingsBuilder
 *             .lookupServiceProjectAttachmentSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * AppHubSettings appHubSettings = appHubSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class AppHubSettings extends ClientSettings<AppHubSettings> {

  /** Returns the object with the settings used for calls to lookupServiceProjectAttachment. */
  public UnaryCallSettings<
          LookupServiceProjectAttachmentRequest, LookupServiceProjectAttachmentResponse>
      lookupServiceProjectAttachmentSettings() {
    return ((AppHubStubSettings) getStubSettings()).lookupServiceProjectAttachmentSettings();
  }

  /** Returns the object with the settings used for calls to listServiceProjectAttachments. */
  public PagedCallSettings<
          ListServiceProjectAttachmentsRequest,
          ListServiceProjectAttachmentsResponse,
          ListServiceProjectAttachmentsPagedResponse>
      listServiceProjectAttachmentsSettings() {
    return ((AppHubStubSettings) getStubSettings()).listServiceProjectAttachmentsSettings();
  }

  /** Returns the object with the settings used for calls to createServiceProjectAttachment. */
  public UnaryCallSettings<CreateServiceProjectAttachmentRequest, Operation>
      createServiceProjectAttachmentSettings() {
    return ((AppHubStubSettings) getStubSettings()).createServiceProjectAttachmentSettings();
  }

  /** Returns the object with the settings used for calls to createServiceProjectAttachment. */
  public OperationCallSettings<
          CreateServiceProjectAttachmentRequest, ServiceProjectAttachment, OperationMetadata>
      createServiceProjectAttachmentOperationSettings() {
    return ((AppHubStubSettings) getStubSettings())
        .createServiceProjectAttachmentOperationSettings();
  }

  /** Returns the object with the settings used for calls to getServiceProjectAttachment. */
  public UnaryCallSettings<GetServiceProjectAttachmentRequest, ServiceProjectAttachment>
      getServiceProjectAttachmentSettings() {
    return ((AppHubStubSettings) getStubSettings()).getServiceProjectAttachmentSettings();
  }

  /** Returns the object with the settings used for calls to deleteServiceProjectAttachment. */
  public UnaryCallSettings<DeleteServiceProjectAttachmentRequest, Operation>
      deleteServiceProjectAttachmentSettings() {
    return ((AppHubStubSettings) getStubSettings()).deleteServiceProjectAttachmentSettings();
  }

  /** Returns the object with the settings used for calls to deleteServiceProjectAttachment. */
  public OperationCallSettings<DeleteServiceProjectAttachmentRequest, Empty, OperationMetadata>
      deleteServiceProjectAttachmentOperationSettings() {
    return ((AppHubStubSettings) getStubSettings())
        .deleteServiceProjectAttachmentOperationSettings();
  }

  /** Returns the object with the settings used for calls to detachServiceProjectAttachment. */
  public UnaryCallSettings<
          DetachServiceProjectAttachmentRequest, DetachServiceProjectAttachmentResponse>
      detachServiceProjectAttachmentSettings() {
    return ((AppHubStubSettings) getStubSettings()).detachServiceProjectAttachmentSettings();
  }

  /** Returns the object with the settings used for calls to listDiscoveredServices. */
  public PagedCallSettings<
          ListDiscoveredServicesRequest,
          ListDiscoveredServicesResponse,
          ListDiscoveredServicesPagedResponse>
      listDiscoveredServicesSettings() {
    return ((AppHubStubSettings) getStubSettings()).listDiscoveredServicesSettings();
  }

  /** Returns the object with the settings used for calls to getDiscoveredService. */
  public UnaryCallSettings<GetDiscoveredServiceRequest, DiscoveredService>
      getDiscoveredServiceSettings() {
    return ((AppHubStubSettings) getStubSettings()).getDiscoveredServiceSettings();
  }

  /** Returns the object with the settings used for calls to lookupDiscoveredService. */
  public UnaryCallSettings<LookupDiscoveredServiceRequest, LookupDiscoveredServiceResponse>
      lookupDiscoveredServiceSettings() {
    return ((AppHubStubSettings) getStubSettings()).lookupDiscoveredServiceSettings();
  }

  /** Returns the object with the settings used for calls to listServices. */
  public PagedCallSettings<ListServicesRequest, ListServicesResponse, ListServicesPagedResponse>
      listServicesSettings() {
    return ((AppHubStubSettings) getStubSettings()).listServicesSettings();
  }

  /** Returns the object with the settings used for calls to createService. */
  public UnaryCallSettings<CreateServiceRequest, Operation> createServiceSettings() {
    return ((AppHubStubSettings) getStubSettings()).createServiceSettings();
  }

  /** Returns the object with the settings used for calls to createService. */
  public OperationCallSettings<CreateServiceRequest, Service, OperationMetadata>
      createServiceOperationSettings() {
    return ((AppHubStubSettings) getStubSettings()).createServiceOperationSettings();
  }

  /** Returns the object with the settings used for calls to getService. */
  public UnaryCallSettings<GetServiceRequest, Service> getServiceSettings() {
    return ((AppHubStubSettings) getStubSettings()).getServiceSettings();
  }

  /** Returns the object with the settings used for calls to updateService. */
  public UnaryCallSettings<UpdateServiceRequest, Operation> updateServiceSettings() {
    return ((AppHubStubSettings) getStubSettings()).updateServiceSettings();
  }

  /** Returns the object with the settings used for calls to updateService. */
  public OperationCallSettings<UpdateServiceRequest, Service, OperationMetadata>
      updateServiceOperationSettings() {
    return ((AppHubStubSettings) getStubSettings()).updateServiceOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteService. */
  public UnaryCallSettings<DeleteServiceRequest, Operation> deleteServiceSettings() {
    return ((AppHubStubSettings) getStubSettings()).deleteServiceSettings();
  }

  /** Returns the object with the settings used for calls to deleteService. */
  public OperationCallSettings<DeleteServiceRequest, Empty, OperationMetadata>
      deleteServiceOperationSettings() {
    return ((AppHubStubSettings) getStubSettings()).deleteServiceOperationSettings();
  }

  /** Returns the object with the settings used for calls to listDiscoveredWorkloads. */
  public PagedCallSettings<
          ListDiscoveredWorkloadsRequest,
          ListDiscoveredWorkloadsResponse,
          ListDiscoveredWorkloadsPagedResponse>
      listDiscoveredWorkloadsSettings() {
    return ((AppHubStubSettings) getStubSettings()).listDiscoveredWorkloadsSettings();
  }

  /** Returns the object with the settings used for calls to getDiscoveredWorkload. */
  public UnaryCallSettings<GetDiscoveredWorkloadRequest, DiscoveredWorkload>
      getDiscoveredWorkloadSettings() {
    return ((AppHubStubSettings) getStubSettings()).getDiscoveredWorkloadSettings();
  }

  /** Returns the object with the settings used for calls to lookupDiscoveredWorkload. */
  public UnaryCallSettings<LookupDiscoveredWorkloadRequest, LookupDiscoveredWorkloadResponse>
      lookupDiscoveredWorkloadSettings() {
    return ((AppHubStubSettings) getStubSettings()).lookupDiscoveredWorkloadSettings();
  }

  /** Returns the object with the settings used for calls to listWorkloads. */
  public PagedCallSettings<ListWorkloadsRequest, ListWorkloadsResponse, ListWorkloadsPagedResponse>
      listWorkloadsSettings() {
    return ((AppHubStubSettings) getStubSettings()).listWorkloadsSettings();
  }

  /** Returns the object with the settings used for calls to createWorkload. */
  public UnaryCallSettings<CreateWorkloadRequest, Operation> createWorkloadSettings() {
    return ((AppHubStubSettings) getStubSettings()).createWorkloadSettings();
  }

  /** Returns the object with the settings used for calls to createWorkload. */
  public OperationCallSettings<CreateWorkloadRequest, Workload, OperationMetadata>
      createWorkloadOperationSettings() {
    return ((AppHubStubSettings) getStubSettings()).createWorkloadOperationSettings();
  }

  /** Returns the object with the settings used for calls to getWorkload. */
  public UnaryCallSettings<GetWorkloadRequest, Workload> getWorkloadSettings() {
    return ((AppHubStubSettings) getStubSettings()).getWorkloadSettings();
  }

  /** Returns the object with the settings used for calls to updateWorkload. */
  public UnaryCallSettings<UpdateWorkloadRequest, Operation> updateWorkloadSettings() {
    return ((AppHubStubSettings) getStubSettings()).updateWorkloadSettings();
  }

  /** Returns the object with the settings used for calls to updateWorkload. */
  public OperationCallSettings<UpdateWorkloadRequest, Workload, OperationMetadata>
      updateWorkloadOperationSettings() {
    return ((AppHubStubSettings) getStubSettings()).updateWorkloadOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteWorkload. */
  public UnaryCallSettings<DeleteWorkloadRequest, Operation> deleteWorkloadSettings() {
    return ((AppHubStubSettings) getStubSettings()).deleteWorkloadSettings();
  }

  /** Returns the object with the settings used for calls to deleteWorkload. */
  public OperationCallSettings<DeleteWorkloadRequest, Empty, OperationMetadata>
      deleteWorkloadOperationSettings() {
    return ((AppHubStubSettings) getStubSettings()).deleteWorkloadOperationSettings();
  }

  /** Returns the object with the settings used for calls to listApplications. */
  public PagedCallSettings<
          ListApplicationsRequest, ListApplicationsResponse, ListApplicationsPagedResponse>
      listApplicationsSettings() {
    return ((AppHubStubSettings) getStubSettings()).listApplicationsSettings();
  }

  /** Returns the object with the settings used for calls to createApplication. */
  public UnaryCallSettings<CreateApplicationRequest, Operation> createApplicationSettings() {
    return ((AppHubStubSettings) getStubSettings()).createApplicationSettings();
  }

  /** Returns the object with the settings used for calls to createApplication. */
  public OperationCallSettings<CreateApplicationRequest, Application, OperationMetadata>
      createApplicationOperationSettings() {
    return ((AppHubStubSettings) getStubSettings()).createApplicationOperationSettings();
  }

  /** Returns the object with the settings used for calls to getApplication. */
  public UnaryCallSettings<GetApplicationRequest, Application> getApplicationSettings() {
    return ((AppHubStubSettings) getStubSettings()).getApplicationSettings();
  }

  /** Returns the object with the settings used for calls to updateApplication. */
  public UnaryCallSettings<UpdateApplicationRequest, Operation> updateApplicationSettings() {
    return ((AppHubStubSettings) getStubSettings()).updateApplicationSettings();
  }

  /** Returns the object with the settings used for calls to updateApplication. */
  public OperationCallSettings<UpdateApplicationRequest, Application, OperationMetadata>
      updateApplicationOperationSettings() {
    return ((AppHubStubSettings) getStubSettings()).updateApplicationOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteApplication. */
  public UnaryCallSettings<DeleteApplicationRequest, Operation> deleteApplicationSettings() {
    return ((AppHubStubSettings) getStubSettings()).deleteApplicationSettings();
  }

  /** Returns the object with the settings used for calls to deleteApplication. */
  public OperationCallSettings<DeleteApplicationRequest, Empty, OperationMetadata>
      deleteApplicationOperationSettings() {
    return ((AppHubStubSettings) getStubSettings()).deleteApplicationOperationSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((AppHubStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((AppHubStubSettings) getStubSettings()).getLocationSettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return ((AppHubStubSettings) getStubSettings()).setIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return ((AppHubStubSettings) getStubSettings()).getIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return ((AppHubStubSettings) getStubSettings()).testIamPermissionsSettings();
  }

  public static final AppHubSettings create(AppHubStubSettings stub) throws IOException {
    return new AppHubSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return AppHubStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return AppHubStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return AppHubStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return AppHubStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return AppHubStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return AppHubStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return AppHubStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return AppHubStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected AppHubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for AppHubSettings. */
  public static class Builder extends ClientSettings.Builder<AppHubSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(AppHubStubSettings.newBuilder(clientContext));
    }

    protected Builder(AppHubSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(AppHubStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(AppHubStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(AppHubStubSettings.newHttpJsonBuilder());
    }

    public AppHubStubSettings.Builder getStubSettingsBuilder() {
      return ((AppHubStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to lookupServiceProjectAttachment. */
    public UnaryCallSettings.Builder<
            LookupServiceProjectAttachmentRequest, LookupServiceProjectAttachmentResponse>
        lookupServiceProjectAttachmentSettings() {
      return getStubSettingsBuilder().lookupServiceProjectAttachmentSettings();
    }

    /** Returns the builder for the settings used for calls to listServiceProjectAttachments. */
    public PagedCallSettings.Builder<
            ListServiceProjectAttachmentsRequest,
            ListServiceProjectAttachmentsResponse,
            ListServiceProjectAttachmentsPagedResponse>
        listServiceProjectAttachmentsSettings() {
      return getStubSettingsBuilder().listServiceProjectAttachmentsSettings();
    }

    /** Returns the builder for the settings used for calls to createServiceProjectAttachment. */
    public UnaryCallSettings.Builder<CreateServiceProjectAttachmentRequest, Operation>
        createServiceProjectAttachmentSettings() {
      return getStubSettingsBuilder().createServiceProjectAttachmentSettings();
    }

    /** Returns the builder for the settings used for calls to createServiceProjectAttachment. */
    public OperationCallSettings.Builder<
            CreateServiceProjectAttachmentRequest, ServiceProjectAttachment, OperationMetadata>
        createServiceProjectAttachmentOperationSettings() {
      return getStubSettingsBuilder().createServiceProjectAttachmentOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getServiceProjectAttachment. */
    public UnaryCallSettings.Builder<GetServiceProjectAttachmentRequest, ServiceProjectAttachment>
        getServiceProjectAttachmentSettings() {
      return getStubSettingsBuilder().getServiceProjectAttachmentSettings();
    }

    /** Returns the builder for the settings used for calls to deleteServiceProjectAttachment. */
    public UnaryCallSettings.Builder<DeleteServiceProjectAttachmentRequest, Operation>
        deleteServiceProjectAttachmentSettings() {
      return getStubSettingsBuilder().deleteServiceProjectAttachmentSettings();
    }

    /** Returns the builder for the settings used for calls to deleteServiceProjectAttachment. */
    public OperationCallSettings.Builder<
            DeleteServiceProjectAttachmentRequest, Empty, OperationMetadata>
        deleteServiceProjectAttachmentOperationSettings() {
      return getStubSettingsBuilder().deleteServiceProjectAttachmentOperationSettings();
    }

    /** Returns the builder for the settings used for calls to detachServiceProjectAttachment. */
    public UnaryCallSettings.Builder<
            DetachServiceProjectAttachmentRequest, DetachServiceProjectAttachmentResponse>
        detachServiceProjectAttachmentSettings() {
      return getStubSettingsBuilder().detachServiceProjectAttachmentSettings();
    }

    /** Returns the builder for the settings used for calls to listDiscoveredServices. */
    public PagedCallSettings.Builder<
            ListDiscoveredServicesRequest,
            ListDiscoveredServicesResponse,
            ListDiscoveredServicesPagedResponse>
        listDiscoveredServicesSettings() {
      return getStubSettingsBuilder().listDiscoveredServicesSettings();
    }

    /** Returns the builder for the settings used for calls to getDiscoveredService. */
    public UnaryCallSettings.Builder<GetDiscoveredServiceRequest, DiscoveredService>
        getDiscoveredServiceSettings() {
      return getStubSettingsBuilder().getDiscoveredServiceSettings();
    }

    /** Returns the builder for the settings used for calls to lookupDiscoveredService. */
    public UnaryCallSettings.Builder<
            LookupDiscoveredServiceRequest, LookupDiscoveredServiceResponse>
        lookupDiscoveredServiceSettings() {
      return getStubSettingsBuilder().lookupDiscoveredServiceSettings();
    }

    /** Returns the builder for the settings used for calls to listServices. */
    public PagedCallSettings.Builder<
            ListServicesRequest, ListServicesResponse, ListServicesPagedResponse>
        listServicesSettings() {
      return getStubSettingsBuilder().listServicesSettings();
    }

    /** Returns the builder for the settings used for calls to createService. */
    public UnaryCallSettings.Builder<CreateServiceRequest, Operation> createServiceSettings() {
      return getStubSettingsBuilder().createServiceSettings();
    }

    /** Returns the builder for the settings used for calls to createService. */
    public OperationCallSettings.Builder<CreateServiceRequest, Service, OperationMetadata>
        createServiceOperationSettings() {
      return getStubSettingsBuilder().createServiceOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getService. */
    public UnaryCallSettings.Builder<GetServiceRequest, Service> getServiceSettings() {
      return getStubSettingsBuilder().getServiceSettings();
    }

    /** Returns the builder for the settings used for calls to updateService. */
    public UnaryCallSettings.Builder<UpdateServiceRequest, Operation> updateServiceSettings() {
      return getStubSettingsBuilder().updateServiceSettings();
    }

    /** Returns the builder for the settings used for calls to updateService. */
    public OperationCallSettings.Builder<UpdateServiceRequest, Service, OperationMetadata>
        updateServiceOperationSettings() {
      return getStubSettingsBuilder().updateServiceOperationSettings();
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

    /** Returns the builder for the settings used for calls to listDiscoveredWorkloads. */
    public PagedCallSettings.Builder<
            ListDiscoveredWorkloadsRequest,
            ListDiscoveredWorkloadsResponse,
            ListDiscoveredWorkloadsPagedResponse>
        listDiscoveredWorkloadsSettings() {
      return getStubSettingsBuilder().listDiscoveredWorkloadsSettings();
    }

    /** Returns the builder for the settings used for calls to getDiscoveredWorkload. */
    public UnaryCallSettings.Builder<GetDiscoveredWorkloadRequest, DiscoveredWorkload>
        getDiscoveredWorkloadSettings() {
      return getStubSettingsBuilder().getDiscoveredWorkloadSettings();
    }

    /** Returns the builder for the settings used for calls to lookupDiscoveredWorkload. */
    public UnaryCallSettings.Builder<
            LookupDiscoveredWorkloadRequest, LookupDiscoveredWorkloadResponse>
        lookupDiscoveredWorkloadSettings() {
      return getStubSettingsBuilder().lookupDiscoveredWorkloadSettings();
    }

    /** Returns the builder for the settings used for calls to listWorkloads. */
    public PagedCallSettings.Builder<
            ListWorkloadsRequest, ListWorkloadsResponse, ListWorkloadsPagedResponse>
        listWorkloadsSettings() {
      return getStubSettingsBuilder().listWorkloadsSettings();
    }

    /** Returns the builder for the settings used for calls to createWorkload. */
    public UnaryCallSettings.Builder<CreateWorkloadRequest, Operation> createWorkloadSettings() {
      return getStubSettingsBuilder().createWorkloadSettings();
    }

    /** Returns the builder for the settings used for calls to createWorkload. */
    public OperationCallSettings.Builder<CreateWorkloadRequest, Workload, OperationMetadata>
        createWorkloadOperationSettings() {
      return getStubSettingsBuilder().createWorkloadOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getWorkload. */
    public UnaryCallSettings.Builder<GetWorkloadRequest, Workload> getWorkloadSettings() {
      return getStubSettingsBuilder().getWorkloadSettings();
    }

    /** Returns the builder for the settings used for calls to updateWorkload. */
    public UnaryCallSettings.Builder<UpdateWorkloadRequest, Operation> updateWorkloadSettings() {
      return getStubSettingsBuilder().updateWorkloadSettings();
    }

    /** Returns the builder for the settings used for calls to updateWorkload. */
    public OperationCallSettings.Builder<UpdateWorkloadRequest, Workload, OperationMetadata>
        updateWorkloadOperationSettings() {
      return getStubSettingsBuilder().updateWorkloadOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteWorkload. */
    public UnaryCallSettings.Builder<DeleteWorkloadRequest, Operation> deleteWorkloadSettings() {
      return getStubSettingsBuilder().deleteWorkloadSettings();
    }

    /** Returns the builder for the settings used for calls to deleteWorkload. */
    public OperationCallSettings.Builder<DeleteWorkloadRequest, Empty, OperationMetadata>
        deleteWorkloadOperationSettings() {
      return getStubSettingsBuilder().deleteWorkloadOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listApplications. */
    public PagedCallSettings.Builder<
            ListApplicationsRequest, ListApplicationsResponse, ListApplicationsPagedResponse>
        listApplicationsSettings() {
      return getStubSettingsBuilder().listApplicationsSettings();
    }

    /** Returns the builder for the settings used for calls to createApplication. */
    public UnaryCallSettings.Builder<CreateApplicationRequest, Operation>
        createApplicationSettings() {
      return getStubSettingsBuilder().createApplicationSettings();
    }

    /** Returns the builder for the settings used for calls to createApplication. */
    public OperationCallSettings.Builder<CreateApplicationRequest, Application, OperationMetadata>
        createApplicationOperationSettings() {
      return getStubSettingsBuilder().createApplicationOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getApplication. */
    public UnaryCallSettings.Builder<GetApplicationRequest, Application> getApplicationSettings() {
      return getStubSettingsBuilder().getApplicationSettings();
    }

    /** Returns the builder for the settings used for calls to updateApplication. */
    public UnaryCallSettings.Builder<UpdateApplicationRequest, Operation>
        updateApplicationSettings() {
      return getStubSettingsBuilder().updateApplicationSettings();
    }

    /** Returns the builder for the settings used for calls to updateApplication. */
    public OperationCallSettings.Builder<UpdateApplicationRequest, Application, OperationMetadata>
        updateApplicationOperationSettings() {
      return getStubSettingsBuilder().updateApplicationOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteApplication. */
    public UnaryCallSettings.Builder<DeleteApplicationRequest, Operation>
        deleteApplicationSettings() {
      return getStubSettingsBuilder().deleteApplicationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteApplication. */
    public OperationCallSettings.Builder<DeleteApplicationRequest, Empty, OperationMetadata>
        deleteApplicationOperationSettings() {
      return getStubSettingsBuilder().deleteApplicationOperationSettings();
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
    public AppHubSettings build() throws IOException {
      return new AppHubSettings(this);
    }
  }
}
