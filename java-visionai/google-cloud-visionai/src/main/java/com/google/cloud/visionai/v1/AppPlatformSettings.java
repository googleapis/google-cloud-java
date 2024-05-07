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

package com.google.cloud.visionai.v1;

import static com.google.cloud.visionai.v1.AppPlatformClient.ListApplicationsPagedResponse;
import static com.google.cloud.visionai.v1.AppPlatformClient.ListDraftsPagedResponse;
import static com.google.cloud.visionai.v1.AppPlatformClient.ListInstancesPagedResponse;
import static com.google.cloud.visionai.v1.AppPlatformClient.ListProcessorsPagedResponse;

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
import com.google.cloud.visionai.v1.stub.AppPlatformStubSettings;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link AppPlatformClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (visionai.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getApplication to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * AppPlatformSettings.Builder appPlatformSettingsBuilder = AppPlatformSettings.newBuilder();
 * appPlatformSettingsBuilder
 *     .getApplicationSettings()
 *     .setRetrySettings(
 *         appPlatformSettingsBuilder
 *             .getApplicationSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * AppPlatformSettings appPlatformSettings = appPlatformSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class AppPlatformSettings extends ClientSettings<AppPlatformSettings> {

  /** Returns the object with the settings used for calls to listApplications. */
  public PagedCallSettings<
          ListApplicationsRequest, ListApplicationsResponse, ListApplicationsPagedResponse>
      listApplicationsSettings() {
    return ((AppPlatformStubSettings) getStubSettings()).listApplicationsSettings();
  }

  /** Returns the object with the settings used for calls to getApplication. */
  public UnaryCallSettings<GetApplicationRequest, Application> getApplicationSettings() {
    return ((AppPlatformStubSettings) getStubSettings()).getApplicationSettings();
  }

  /** Returns the object with the settings used for calls to createApplication. */
  public UnaryCallSettings<CreateApplicationRequest, Operation> createApplicationSettings() {
    return ((AppPlatformStubSettings) getStubSettings()).createApplicationSettings();
  }

  /** Returns the object with the settings used for calls to createApplication. */
  public OperationCallSettings<CreateApplicationRequest, Application, OperationMetadata>
      createApplicationOperationSettings() {
    return ((AppPlatformStubSettings) getStubSettings()).createApplicationOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateApplication. */
  public UnaryCallSettings<UpdateApplicationRequest, Operation> updateApplicationSettings() {
    return ((AppPlatformStubSettings) getStubSettings()).updateApplicationSettings();
  }

  /** Returns the object with the settings used for calls to updateApplication. */
  public OperationCallSettings<UpdateApplicationRequest, Application, OperationMetadata>
      updateApplicationOperationSettings() {
    return ((AppPlatformStubSettings) getStubSettings()).updateApplicationOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteApplication. */
  public UnaryCallSettings<DeleteApplicationRequest, Operation> deleteApplicationSettings() {
    return ((AppPlatformStubSettings) getStubSettings()).deleteApplicationSettings();
  }

  /** Returns the object with the settings used for calls to deleteApplication. */
  public OperationCallSettings<DeleteApplicationRequest, Empty, OperationMetadata>
      deleteApplicationOperationSettings() {
    return ((AppPlatformStubSettings) getStubSettings()).deleteApplicationOperationSettings();
  }

  /** Returns the object with the settings used for calls to deployApplication. */
  public UnaryCallSettings<DeployApplicationRequest, Operation> deployApplicationSettings() {
    return ((AppPlatformStubSettings) getStubSettings()).deployApplicationSettings();
  }

  /** Returns the object with the settings used for calls to deployApplication. */
  public OperationCallSettings<
          DeployApplicationRequest, DeployApplicationResponse, OperationMetadata>
      deployApplicationOperationSettings() {
    return ((AppPlatformStubSettings) getStubSettings()).deployApplicationOperationSettings();
  }

  /** Returns the object with the settings used for calls to undeployApplication. */
  public UnaryCallSettings<UndeployApplicationRequest, Operation> undeployApplicationSettings() {
    return ((AppPlatformStubSettings) getStubSettings()).undeployApplicationSettings();
  }

  /** Returns the object with the settings used for calls to undeployApplication. */
  public OperationCallSettings<
          UndeployApplicationRequest, UndeployApplicationResponse, OperationMetadata>
      undeployApplicationOperationSettings() {
    return ((AppPlatformStubSettings) getStubSettings()).undeployApplicationOperationSettings();
  }

  /** Returns the object with the settings used for calls to addApplicationStreamInput. */
  public UnaryCallSettings<AddApplicationStreamInputRequest, Operation>
      addApplicationStreamInputSettings() {
    return ((AppPlatformStubSettings) getStubSettings()).addApplicationStreamInputSettings();
  }

  /** Returns the object with the settings used for calls to addApplicationStreamInput. */
  public OperationCallSettings<
          AddApplicationStreamInputRequest, AddApplicationStreamInputResponse, OperationMetadata>
      addApplicationStreamInputOperationSettings() {
    return ((AppPlatformStubSettings) getStubSettings())
        .addApplicationStreamInputOperationSettings();
  }

  /** Returns the object with the settings used for calls to removeApplicationStreamInput. */
  public UnaryCallSettings<RemoveApplicationStreamInputRequest, Operation>
      removeApplicationStreamInputSettings() {
    return ((AppPlatformStubSettings) getStubSettings()).removeApplicationStreamInputSettings();
  }

  /** Returns the object with the settings used for calls to removeApplicationStreamInput. */
  public OperationCallSettings<
          RemoveApplicationStreamInputRequest,
          RemoveApplicationStreamInputResponse,
          OperationMetadata>
      removeApplicationStreamInputOperationSettings() {
    return ((AppPlatformStubSettings) getStubSettings())
        .removeApplicationStreamInputOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateApplicationStreamInput. */
  public UnaryCallSettings<UpdateApplicationStreamInputRequest, Operation>
      updateApplicationStreamInputSettings() {
    return ((AppPlatformStubSettings) getStubSettings()).updateApplicationStreamInputSettings();
  }

  /** Returns the object with the settings used for calls to updateApplicationStreamInput. */
  public OperationCallSettings<
          UpdateApplicationStreamInputRequest,
          UpdateApplicationStreamInputResponse,
          OperationMetadata>
      updateApplicationStreamInputOperationSettings() {
    return ((AppPlatformStubSettings) getStubSettings())
        .updateApplicationStreamInputOperationSettings();
  }

  /** Returns the object with the settings used for calls to listInstances. */
  public PagedCallSettings<ListInstancesRequest, ListInstancesResponse, ListInstancesPagedResponse>
      listInstancesSettings() {
    return ((AppPlatformStubSettings) getStubSettings()).listInstancesSettings();
  }

  /** Returns the object with the settings used for calls to getInstance. */
  public UnaryCallSettings<GetInstanceRequest, Instance> getInstanceSettings() {
    return ((AppPlatformStubSettings) getStubSettings()).getInstanceSettings();
  }

  /** Returns the object with the settings used for calls to createApplicationInstances. */
  public UnaryCallSettings<CreateApplicationInstancesRequest, Operation>
      createApplicationInstancesSettings() {
    return ((AppPlatformStubSettings) getStubSettings()).createApplicationInstancesSettings();
  }

  /** Returns the object with the settings used for calls to createApplicationInstances. */
  public OperationCallSettings<
          CreateApplicationInstancesRequest, CreateApplicationInstancesResponse, OperationMetadata>
      createApplicationInstancesOperationSettings() {
    return ((AppPlatformStubSettings) getStubSettings())
        .createApplicationInstancesOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteApplicationInstances. */
  public UnaryCallSettings<DeleteApplicationInstancesRequest, Operation>
      deleteApplicationInstancesSettings() {
    return ((AppPlatformStubSettings) getStubSettings()).deleteApplicationInstancesSettings();
  }

  /** Returns the object with the settings used for calls to deleteApplicationInstances. */
  public OperationCallSettings<DeleteApplicationInstancesRequest, Instance, OperationMetadata>
      deleteApplicationInstancesOperationSettings() {
    return ((AppPlatformStubSettings) getStubSettings())
        .deleteApplicationInstancesOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateApplicationInstances. */
  public UnaryCallSettings<UpdateApplicationInstancesRequest, Operation>
      updateApplicationInstancesSettings() {
    return ((AppPlatformStubSettings) getStubSettings()).updateApplicationInstancesSettings();
  }

  /** Returns the object with the settings used for calls to updateApplicationInstances. */
  public OperationCallSettings<
          UpdateApplicationInstancesRequest, UpdateApplicationInstancesResponse, OperationMetadata>
      updateApplicationInstancesOperationSettings() {
    return ((AppPlatformStubSettings) getStubSettings())
        .updateApplicationInstancesOperationSettings();
  }

  /** Returns the object with the settings used for calls to listDrafts. */
  public PagedCallSettings<ListDraftsRequest, ListDraftsResponse, ListDraftsPagedResponse>
      listDraftsSettings() {
    return ((AppPlatformStubSettings) getStubSettings()).listDraftsSettings();
  }

  /** Returns the object with the settings used for calls to getDraft. */
  public UnaryCallSettings<GetDraftRequest, Draft> getDraftSettings() {
    return ((AppPlatformStubSettings) getStubSettings()).getDraftSettings();
  }

  /** Returns the object with the settings used for calls to createDraft. */
  public UnaryCallSettings<CreateDraftRequest, Operation> createDraftSettings() {
    return ((AppPlatformStubSettings) getStubSettings()).createDraftSettings();
  }

  /** Returns the object with the settings used for calls to createDraft. */
  public OperationCallSettings<CreateDraftRequest, Draft, OperationMetadata>
      createDraftOperationSettings() {
    return ((AppPlatformStubSettings) getStubSettings()).createDraftOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateDraft. */
  public UnaryCallSettings<UpdateDraftRequest, Operation> updateDraftSettings() {
    return ((AppPlatformStubSettings) getStubSettings()).updateDraftSettings();
  }

  /** Returns the object with the settings used for calls to updateDraft. */
  public OperationCallSettings<UpdateDraftRequest, Draft, OperationMetadata>
      updateDraftOperationSettings() {
    return ((AppPlatformStubSettings) getStubSettings()).updateDraftOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteDraft. */
  public UnaryCallSettings<DeleteDraftRequest, Operation> deleteDraftSettings() {
    return ((AppPlatformStubSettings) getStubSettings()).deleteDraftSettings();
  }

  /** Returns the object with the settings used for calls to deleteDraft. */
  public OperationCallSettings<DeleteDraftRequest, Empty, OperationMetadata>
      deleteDraftOperationSettings() {
    return ((AppPlatformStubSettings) getStubSettings()).deleteDraftOperationSettings();
  }

  /** Returns the object with the settings used for calls to listProcessors. */
  public PagedCallSettings<
          ListProcessorsRequest, ListProcessorsResponse, ListProcessorsPagedResponse>
      listProcessorsSettings() {
    return ((AppPlatformStubSettings) getStubSettings()).listProcessorsSettings();
  }

  /** Returns the object with the settings used for calls to listPrebuiltProcessors. */
  public UnaryCallSettings<ListPrebuiltProcessorsRequest, ListPrebuiltProcessorsResponse>
      listPrebuiltProcessorsSettings() {
    return ((AppPlatformStubSettings) getStubSettings()).listPrebuiltProcessorsSettings();
  }

  /** Returns the object with the settings used for calls to getProcessor. */
  public UnaryCallSettings<GetProcessorRequest, Processor> getProcessorSettings() {
    return ((AppPlatformStubSettings) getStubSettings()).getProcessorSettings();
  }

  /** Returns the object with the settings used for calls to createProcessor. */
  public UnaryCallSettings<CreateProcessorRequest, Operation> createProcessorSettings() {
    return ((AppPlatformStubSettings) getStubSettings()).createProcessorSettings();
  }

  /** Returns the object with the settings used for calls to createProcessor. */
  public OperationCallSettings<CreateProcessorRequest, Processor, OperationMetadata>
      createProcessorOperationSettings() {
    return ((AppPlatformStubSettings) getStubSettings()).createProcessorOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateProcessor. */
  public UnaryCallSettings<UpdateProcessorRequest, Operation> updateProcessorSettings() {
    return ((AppPlatformStubSettings) getStubSettings()).updateProcessorSettings();
  }

  /** Returns the object with the settings used for calls to updateProcessor. */
  public OperationCallSettings<UpdateProcessorRequest, Processor, OperationMetadata>
      updateProcessorOperationSettings() {
    return ((AppPlatformStubSettings) getStubSettings()).updateProcessorOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteProcessor. */
  public UnaryCallSettings<DeleteProcessorRequest, Operation> deleteProcessorSettings() {
    return ((AppPlatformStubSettings) getStubSettings()).deleteProcessorSettings();
  }

  /** Returns the object with the settings used for calls to deleteProcessor. */
  public OperationCallSettings<DeleteProcessorRequest, Empty, OperationMetadata>
      deleteProcessorOperationSettings() {
    return ((AppPlatformStubSettings) getStubSettings()).deleteProcessorOperationSettings();
  }

  public static final AppPlatformSettings create(AppPlatformStubSettings stub) throws IOException {
    return new AppPlatformSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return AppPlatformStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return AppPlatformStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return AppPlatformStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return AppPlatformStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return AppPlatformStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return AppPlatformStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return AppPlatformStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return AppPlatformStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected AppPlatformSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for AppPlatformSettings. */
  public static class Builder extends ClientSettings.Builder<AppPlatformSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(AppPlatformStubSettings.newBuilder(clientContext));
    }

    protected Builder(AppPlatformSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(AppPlatformStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(AppPlatformStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(AppPlatformStubSettings.newHttpJsonBuilder());
    }

    public AppPlatformStubSettings.Builder getStubSettingsBuilder() {
      return ((AppPlatformStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to listApplications. */
    public PagedCallSettings.Builder<
            ListApplicationsRequest, ListApplicationsResponse, ListApplicationsPagedResponse>
        listApplicationsSettings() {
      return getStubSettingsBuilder().listApplicationsSettings();
    }

    /** Returns the builder for the settings used for calls to getApplication. */
    public UnaryCallSettings.Builder<GetApplicationRequest, Application> getApplicationSettings() {
      return getStubSettingsBuilder().getApplicationSettings();
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

    /** Returns the builder for the settings used for calls to deployApplication. */
    public UnaryCallSettings.Builder<DeployApplicationRequest, Operation>
        deployApplicationSettings() {
      return getStubSettingsBuilder().deployApplicationSettings();
    }

    /** Returns the builder for the settings used for calls to deployApplication. */
    public OperationCallSettings.Builder<
            DeployApplicationRequest, DeployApplicationResponse, OperationMetadata>
        deployApplicationOperationSettings() {
      return getStubSettingsBuilder().deployApplicationOperationSettings();
    }

    /** Returns the builder for the settings used for calls to undeployApplication. */
    public UnaryCallSettings.Builder<UndeployApplicationRequest, Operation>
        undeployApplicationSettings() {
      return getStubSettingsBuilder().undeployApplicationSettings();
    }

    /** Returns the builder for the settings used for calls to undeployApplication. */
    public OperationCallSettings.Builder<
            UndeployApplicationRequest, UndeployApplicationResponse, OperationMetadata>
        undeployApplicationOperationSettings() {
      return getStubSettingsBuilder().undeployApplicationOperationSettings();
    }

    /** Returns the builder for the settings used for calls to addApplicationStreamInput. */
    public UnaryCallSettings.Builder<AddApplicationStreamInputRequest, Operation>
        addApplicationStreamInputSettings() {
      return getStubSettingsBuilder().addApplicationStreamInputSettings();
    }

    /** Returns the builder for the settings used for calls to addApplicationStreamInput. */
    public OperationCallSettings.Builder<
            AddApplicationStreamInputRequest, AddApplicationStreamInputResponse, OperationMetadata>
        addApplicationStreamInputOperationSettings() {
      return getStubSettingsBuilder().addApplicationStreamInputOperationSettings();
    }

    /** Returns the builder for the settings used for calls to removeApplicationStreamInput. */
    public UnaryCallSettings.Builder<RemoveApplicationStreamInputRequest, Operation>
        removeApplicationStreamInputSettings() {
      return getStubSettingsBuilder().removeApplicationStreamInputSettings();
    }

    /** Returns the builder for the settings used for calls to removeApplicationStreamInput. */
    public OperationCallSettings.Builder<
            RemoveApplicationStreamInputRequest,
            RemoveApplicationStreamInputResponse,
            OperationMetadata>
        removeApplicationStreamInputOperationSettings() {
      return getStubSettingsBuilder().removeApplicationStreamInputOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateApplicationStreamInput. */
    public UnaryCallSettings.Builder<UpdateApplicationStreamInputRequest, Operation>
        updateApplicationStreamInputSettings() {
      return getStubSettingsBuilder().updateApplicationStreamInputSettings();
    }

    /** Returns the builder for the settings used for calls to updateApplicationStreamInput. */
    public OperationCallSettings.Builder<
            UpdateApplicationStreamInputRequest,
            UpdateApplicationStreamInputResponse,
            OperationMetadata>
        updateApplicationStreamInputOperationSettings() {
      return getStubSettingsBuilder().updateApplicationStreamInputOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listInstances. */
    public PagedCallSettings.Builder<
            ListInstancesRequest, ListInstancesResponse, ListInstancesPagedResponse>
        listInstancesSettings() {
      return getStubSettingsBuilder().listInstancesSettings();
    }

    /** Returns the builder for the settings used for calls to getInstance. */
    public UnaryCallSettings.Builder<GetInstanceRequest, Instance> getInstanceSettings() {
      return getStubSettingsBuilder().getInstanceSettings();
    }

    /** Returns the builder for the settings used for calls to createApplicationInstances. */
    public UnaryCallSettings.Builder<CreateApplicationInstancesRequest, Operation>
        createApplicationInstancesSettings() {
      return getStubSettingsBuilder().createApplicationInstancesSettings();
    }

    /** Returns the builder for the settings used for calls to createApplicationInstances. */
    public OperationCallSettings.Builder<
            CreateApplicationInstancesRequest,
            CreateApplicationInstancesResponse,
            OperationMetadata>
        createApplicationInstancesOperationSettings() {
      return getStubSettingsBuilder().createApplicationInstancesOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteApplicationInstances. */
    public UnaryCallSettings.Builder<DeleteApplicationInstancesRequest, Operation>
        deleteApplicationInstancesSettings() {
      return getStubSettingsBuilder().deleteApplicationInstancesSettings();
    }

    /** Returns the builder for the settings used for calls to deleteApplicationInstances. */
    public OperationCallSettings.Builder<
            DeleteApplicationInstancesRequest, Instance, OperationMetadata>
        deleteApplicationInstancesOperationSettings() {
      return getStubSettingsBuilder().deleteApplicationInstancesOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateApplicationInstances. */
    public UnaryCallSettings.Builder<UpdateApplicationInstancesRequest, Operation>
        updateApplicationInstancesSettings() {
      return getStubSettingsBuilder().updateApplicationInstancesSettings();
    }

    /** Returns the builder for the settings used for calls to updateApplicationInstances. */
    public OperationCallSettings.Builder<
            UpdateApplicationInstancesRequest,
            UpdateApplicationInstancesResponse,
            OperationMetadata>
        updateApplicationInstancesOperationSettings() {
      return getStubSettingsBuilder().updateApplicationInstancesOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listDrafts. */
    public PagedCallSettings.Builder<ListDraftsRequest, ListDraftsResponse, ListDraftsPagedResponse>
        listDraftsSettings() {
      return getStubSettingsBuilder().listDraftsSettings();
    }

    /** Returns the builder for the settings used for calls to getDraft. */
    public UnaryCallSettings.Builder<GetDraftRequest, Draft> getDraftSettings() {
      return getStubSettingsBuilder().getDraftSettings();
    }

    /** Returns the builder for the settings used for calls to createDraft. */
    public UnaryCallSettings.Builder<CreateDraftRequest, Operation> createDraftSettings() {
      return getStubSettingsBuilder().createDraftSettings();
    }

    /** Returns the builder for the settings used for calls to createDraft. */
    public OperationCallSettings.Builder<CreateDraftRequest, Draft, OperationMetadata>
        createDraftOperationSettings() {
      return getStubSettingsBuilder().createDraftOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateDraft. */
    public UnaryCallSettings.Builder<UpdateDraftRequest, Operation> updateDraftSettings() {
      return getStubSettingsBuilder().updateDraftSettings();
    }

    /** Returns the builder for the settings used for calls to updateDraft. */
    public OperationCallSettings.Builder<UpdateDraftRequest, Draft, OperationMetadata>
        updateDraftOperationSettings() {
      return getStubSettingsBuilder().updateDraftOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteDraft. */
    public UnaryCallSettings.Builder<DeleteDraftRequest, Operation> deleteDraftSettings() {
      return getStubSettingsBuilder().deleteDraftSettings();
    }

    /** Returns the builder for the settings used for calls to deleteDraft. */
    public OperationCallSettings.Builder<DeleteDraftRequest, Empty, OperationMetadata>
        deleteDraftOperationSettings() {
      return getStubSettingsBuilder().deleteDraftOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listProcessors. */
    public PagedCallSettings.Builder<
            ListProcessorsRequest, ListProcessorsResponse, ListProcessorsPagedResponse>
        listProcessorsSettings() {
      return getStubSettingsBuilder().listProcessorsSettings();
    }

    /** Returns the builder for the settings used for calls to listPrebuiltProcessors. */
    public UnaryCallSettings.Builder<ListPrebuiltProcessorsRequest, ListPrebuiltProcessorsResponse>
        listPrebuiltProcessorsSettings() {
      return getStubSettingsBuilder().listPrebuiltProcessorsSettings();
    }

    /** Returns the builder for the settings used for calls to getProcessor. */
    public UnaryCallSettings.Builder<GetProcessorRequest, Processor> getProcessorSettings() {
      return getStubSettingsBuilder().getProcessorSettings();
    }

    /** Returns the builder for the settings used for calls to createProcessor. */
    public UnaryCallSettings.Builder<CreateProcessorRequest, Operation> createProcessorSettings() {
      return getStubSettingsBuilder().createProcessorSettings();
    }

    /** Returns the builder for the settings used for calls to createProcessor. */
    public OperationCallSettings.Builder<CreateProcessorRequest, Processor, OperationMetadata>
        createProcessorOperationSettings() {
      return getStubSettingsBuilder().createProcessorOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateProcessor. */
    public UnaryCallSettings.Builder<UpdateProcessorRequest, Operation> updateProcessorSettings() {
      return getStubSettingsBuilder().updateProcessorSettings();
    }

    /** Returns the builder for the settings used for calls to updateProcessor. */
    public OperationCallSettings.Builder<UpdateProcessorRequest, Processor, OperationMetadata>
        updateProcessorOperationSettings() {
      return getStubSettingsBuilder().updateProcessorOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteProcessor. */
    public UnaryCallSettings.Builder<DeleteProcessorRequest, Operation> deleteProcessorSettings() {
      return getStubSettingsBuilder().deleteProcessorSettings();
    }

    /** Returns the builder for the settings used for calls to deleteProcessor. */
    public OperationCallSettings.Builder<DeleteProcessorRequest, Empty, OperationMetadata>
        deleteProcessorOperationSettings() {
      return getStubSettingsBuilder().deleteProcessorOperationSettings();
    }

    @Override
    public AppPlatformSettings build() throws IOException {
      return new AppPlatformSettings(this);
    }
  }
}
