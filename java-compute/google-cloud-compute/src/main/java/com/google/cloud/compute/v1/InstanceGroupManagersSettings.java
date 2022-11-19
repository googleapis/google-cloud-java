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

package com.google.cloud.compute.v1;

import static com.google.cloud.compute.v1.InstanceGroupManagersClient.AggregatedListPagedResponse;
import static com.google.cloud.compute.v1.InstanceGroupManagersClient.ListErrorsPagedResponse;
import static com.google.cloud.compute.v1.InstanceGroupManagersClient.ListManagedInstancesPagedResponse;
import static com.google.cloud.compute.v1.InstanceGroupManagersClient.ListPagedResponse;
import static com.google.cloud.compute.v1.InstanceGroupManagersClient.ListPerInstanceConfigsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.compute.v1.stub.InstanceGroupManagersStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link InstanceGroupManagersClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (compute.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of get to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * InstanceGroupManagersSettings.Builder instanceGroupManagersSettingsBuilder =
 *     InstanceGroupManagersSettings.newBuilder();
 * instanceGroupManagersSettingsBuilder
 *     .getSettings()
 *     .setRetrySettings(
 *         instanceGroupManagersSettingsBuilder.getSettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * InstanceGroupManagersSettings instanceGroupManagersSettings =
 *     instanceGroupManagersSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class InstanceGroupManagersSettings extends ClientSettings<InstanceGroupManagersSettings> {

  /** Returns the object with the settings used for calls to abandonInstances. */
  public UnaryCallSettings<AbandonInstancesInstanceGroupManagerRequest, Operation>
      abandonInstancesSettings() {
    return ((InstanceGroupManagersStubSettings) getStubSettings()).abandonInstancesSettings();
  }

  /** Returns the object with the settings used for calls to abandonInstances. */
  public OperationCallSettings<AbandonInstancesInstanceGroupManagerRequest, Operation, Operation>
      abandonInstancesOperationSettings() {
    return ((InstanceGroupManagersStubSettings) getStubSettings())
        .abandonInstancesOperationSettings();
  }

  /** Returns the object with the settings used for calls to aggregatedList. */
  public PagedCallSettings<
          AggregatedListInstanceGroupManagersRequest,
          InstanceGroupManagerAggregatedList,
          AggregatedListPagedResponse>
      aggregatedListSettings() {
    return ((InstanceGroupManagersStubSettings) getStubSettings()).aggregatedListSettings();
  }

  /** Returns the object with the settings used for calls to applyUpdatesToInstances. */
  public UnaryCallSettings<ApplyUpdatesToInstancesInstanceGroupManagerRequest, Operation>
      applyUpdatesToInstancesSettings() {
    return ((InstanceGroupManagersStubSettings) getStubSettings())
        .applyUpdatesToInstancesSettings();
  }

  /** Returns the object with the settings used for calls to applyUpdatesToInstances. */
  public OperationCallSettings<
          ApplyUpdatesToInstancesInstanceGroupManagerRequest, Operation, Operation>
      applyUpdatesToInstancesOperationSettings() {
    return ((InstanceGroupManagersStubSettings) getStubSettings())
        .applyUpdatesToInstancesOperationSettings();
  }

  /** Returns the object with the settings used for calls to createInstances. */
  public UnaryCallSettings<CreateInstancesInstanceGroupManagerRequest, Operation>
      createInstancesSettings() {
    return ((InstanceGroupManagersStubSettings) getStubSettings()).createInstancesSettings();
  }

  /** Returns the object with the settings used for calls to createInstances. */
  public OperationCallSettings<CreateInstancesInstanceGroupManagerRequest, Operation, Operation>
      createInstancesOperationSettings() {
    return ((InstanceGroupManagersStubSettings) getStubSettings())
        .createInstancesOperationSettings();
  }

  /** Returns the object with the settings used for calls to delete. */
  public UnaryCallSettings<DeleteInstanceGroupManagerRequest, Operation> deleteSettings() {
    return ((InstanceGroupManagersStubSettings) getStubSettings()).deleteSettings();
  }

  /** Returns the object with the settings used for calls to delete. */
  public OperationCallSettings<DeleteInstanceGroupManagerRequest, Operation, Operation>
      deleteOperationSettings() {
    return ((InstanceGroupManagersStubSettings) getStubSettings()).deleteOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteInstances. */
  public UnaryCallSettings<DeleteInstancesInstanceGroupManagerRequest, Operation>
      deleteInstancesSettings() {
    return ((InstanceGroupManagersStubSettings) getStubSettings()).deleteInstancesSettings();
  }

  /** Returns the object with the settings used for calls to deleteInstances. */
  public OperationCallSettings<DeleteInstancesInstanceGroupManagerRequest, Operation, Operation>
      deleteInstancesOperationSettings() {
    return ((InstanceGroupManagersStubSettings) getStubSettings())
        .deleteInstancesOperationSettings();
  }

  /** Returns the object with the settings used for calls to deletePerInstanceConfigs. */
  public UnaryCallSettings<DeletePerInstanceConfigsInstanceGroupManagerRequest, Operation>
      deletePerInstanceConfigsSettings() {
    return ((InstanceGroupManagersStubSettings) getStubSettings())
        .deletePerInstanceConfigsSettings();
  }

  /** Returns the object with the settings used for calls to deletePerInstanceConfigs. */
  public OperationCallSettings<
          DeletePerInstanceConfigsInstanceGroupManagerRequest, Operation, Operation>
      deletePerInstanceConfigsOperationSettings() {
    return ((InstanceGroupManagersStubSettings) getStubSettings())
        .deletePerInstanceConfigsOperationSettings();
  }

  /** Returns the object with the settings used for calls to get. */
  public UnaryCallSettings<GetInstanceGroupManagerRequest, InstanceGroupManager> getSettings() {
    return ((InstanceGroupManagersStubSettings) getStubSettings()).getSettings();
  }

  /** Returns the object with the settings used for calls to insert. */
  public UnaryCallSettings<InsertInstanceGroupManagerRequest, Operation> insertSettings() {
    return ((InstanceGroupManagersStubSettings) getStubSettings()).insertSettings();
  }

  /** Returns the object with the settings used for calls to insert. */
  public OperationCallSettings<InsertInstanceGroupManagerRequest, Operation, Operation>
      insertOperationSettings() {
    return ((InstanceGroupManagersStubSettings) getStubSettings()).insertOperationSettings();
  }

  /** Returns the object with the settings used for calls to list. */
  public PagedCallSettings<
          ListInstanceGroupManagersRequest, InstanceGroupManagerList, ListPagedResponse>
      listSettings() {
    return ((InstanceGroupManagersStubSettings) getStubSettings()).listSettings();
  }

  /** Returns the object with the settings used for calls to listErrors. */
  public PagedCallSettings<
          ListErrorsInstanceGroupManagersRequest,
          InstanceGroupManagersListErrorsResponse,
          ListErrorsPagedResponse>
      listErrorsSettings() {
    return ((InstanceGroupManagersStubSettings) getStubSettings()).listErrorsSettings();
  }

  /** Returns the object with the settings used for calls to listManagedInstances. */
  public PagedCallSettings<
          ListManagedInstancesInstanceGroupManagersRequest,
          InstanceGroupManagersListManagedInstancesResponse,
          ListManagedInstancesPagedResponse>
      listManagedInstancesSettings() {
    return ((InstanceGroupManagersStubSettings) getStubSettings()).listManagedInstancesSettings();
  }

  /** Returns the object with the settings used for calls to listPerInstanceConfigs. */
  public PagedCallSettings<
          ListPerInstanceConfigsInstanceGroupManagersRequest,
          InstanceGroupManagersListPerInstanceConfigsResp,
          ListPerInstanceConfigsPagedResponse>
      listPerInstanceConfigsSettings() {
    return ((InstanceGroupManagersStubSettings) getStubSettings()).listPerInstanceConfigsSettings();
  }

  /** Returns the object with the settings used for calls to patch. */
  public UnaryCallSettings<PatchInstanceGroupManagerRequest, Operation> patchSettings() {
    return ((InstanceGroupManagersStubSettings) getStubSettings()).patchSettings();
  }

  /** Returns the object with the settings used for calls to patch. */
  public OperationCallSettings<PatchInstanceGroupManagerRequest, Operation, Operation>
      patchOperationSettings() {
    return ((InstanceGroupManagersStubSettings) getStubSettings()).patchOperationSettings();
  }

  /** Returns the object with the settings used for calls to patchPerInstanceConfigs. */
  public UnaryCallSettings<PatchPerInstanceConfigsInstanceGroupManagerRequest, Operation>
      patchPerInstanceConfigsSettings() {
    return ((InstanceGroupManagersStubSettings) getStubSettings())
        .patchPerInstanceConfigsSettings();
  }

  /** Returns the object with the settings used for calls to patchPerInstanceConfigs. */
  public OperationCallSettings<
          PatchPerInstanceConfigsInstanceGroupManagerRequest, Operation, Operation>
      patchPerInstanceConfigsOperationSettings() {
    return ((InstanceGroupManagersStubSettings) getStubSettings())
        .patchPerInstanceConfigsOperationSettings();
  }

  /** Returns the object with the settings used for calls to recreateInstances. */
  public UnaryCallSettings<RecreateInstancesInstanceGroupManagerRequest, Operation>
      recreateInstancesSettings() {
    return ((InstanceGroupManagersStubSettings) getStubSettings()).recreateInstancesSettings();
  }

  /** Returns the object with the settings used for calls to recreateInstances. */
  public OperationCallSettings<RecreateInstancesInstanceGroupManagerRequest, Operation, Operation>
      recreateInstancesOperationSettings() {
    return ((InstanceGroupManagersStubSettings) getStubSettings())
        .recreateInstancesOperationSettings();
  }

  /** Returns the object with the settings used for calls to resize. */
  public UnaryCallSettings<ResizeInstanceGroupManagerRequest, Operation> resizeSettings() {
    return ((InstanceGroupManagersStubSettings) getStubSettings()).resizeSettings();
  }

  /** Returns the object with the settings used for calls to resize. */
  public OperationCallSettings<ResizeInstanceGroupManagerRequest, Operation, Operation>
      resizeOperationSettings() {
    return ((InstanceGroupManagersStubSettings) getStubSettings()).resizeOperationSettings();
  }

  /** Returns the object with the settings used for calls to setInstanceTemplate. */
  public UnaryCallSettings<SetInstanceTemplateInstanceGroupManagerRequest, Operation>
      setInstanceTemplateSettings() {
    return ((InstanceGroupManagersStubSettings) getStubSettings()).setInstanceTemplateSettings();
  }

  /** Returns the object with the settings used for calls to setInstanceTemplate. */
  public OperationCallSettings<SetInstanceTemplateInstanceGroupManagerRequest, Operation, Operation>
      setInstanceTemplateOperationSettings() {
    return ((InstanceGroupManagersStubSettings) getStubSettings())
        .setInstanceTemplateOperationSettings();
  }

  /** Returns the object with the settings used for calls to setTargetPools. */
  public UnaryCallSettings<SetTargetPoolsInstanceGroupManagerRequest, Operation>
      setTargetPoolsSettings() {
    return ((InstanceGroupManagersStubSettings) getStubSettings()).setTargetPoolsSettings();
  }

  /** Returns the object with the settings used for calls to setTargetPools. */
  public OperationCallSettings<SetTargetPoolsInstanceGroupManagerRequest, Operation, Operation>
      setTargetPoolsOperationSettings() {
    return ((InstanceGroupManagersStubSettings) getStubSettings())
        .setTargetPoolsOperationSettings();
  }

  /** Returns the object with the settings used for calls to updatePerInstanceConfigs. */
  public UnaryCallSettings<UpdatePerInstanceConfigsInstanceGroupManagerRequest, Operation>
      updatePerInstanceConfigsSettings() {
    return ((InstanceGroupManagersStubSettings) getStubSettings())
        .updatePerInstanceConfigsSettings();
  }

  /** Returns the object with the settings used for calls to updatePerInstanceConfigs. */
  public OperationCallSettings<
          UpdatePerInstanceConfigsInstanceGroupManagerRequest, Operation, Operation>
      updatePerInstanceConfigsOperationSettings() {
    return ((InstanceGroupManagersStubSettings) getStubSettings())
        .updatePerInstanceConfigsOperationSettings();
  }

  public static final InstanceGroupManagersSettings create(InstanceGroupManagersStubSettings stub)
      throws IOException {
    return new InstanceGroupManagersSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstanceGroupManagersStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return InstanceGroupManagersStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return InstanceGroupManagersStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return InstanceGroupManagersStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return InstanceGroupManagersStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return InstanceGroupManagersStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return InstanceGroupManagersStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected InstanceGroupManagersSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for InstanceGroupManagersSettings. */
  public static class Builder
      extends ClientSettings.Builder<InstanceGroupManagersSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(InstanceGroupManagersStubSettings.newBuilder(clientContext));
    }

    protected Builder(InstanceGroupManagersSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(InstanceGroupManagersStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(InstanceGroupManagersStubSettings.newBuilder());
    }

    public InstanceGroupManagersStubSettings.Builder getStubSettingsBuilder() {
      return ((InstanceGroupManagersStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to abandonInstances. */
    public UnaryCallSettings.Builder<AbandonInstancesInstanceGroupManagerRequest, Operation>
        abandonInstancesSettings() {
      return getStubSettingsBuilder().abandonInstancesSettings();
    }

    /** Returns the builder for the settings used for calls to abandonInstances. */
    public OperationCallSettings.Builder<
            AbandonInstancesInstanceGroupManagerRequest, Operation, Operation>
        abandonInstancesOperationSettings() {
      return getStubSettingsBuilder().abandonInstancesOperationSettings();
    }

    /** Returns the builder for the settings used for calls to aggregatedList. */
    public PagedCallSettings.Builder<
            AggregatedListInstanceGroupManagersRequest,
            InstanceGroupManagerAggregatedList,
            AggregatedListPagedResponse>
        aggregatedListSettings() {
      return getStubSettingsBuilder().aggregatedListSettings();
    }

    /** Returns the builder for the settings used for calls to applyUpdatesToInstances. */
    public UnaryCallSettings.Builder<ApplyUpdatesToInstancesInstanceGroupManagerRequest, Operation>
        applyUpdatesToInstancesSettings() {
      return getStubSettingsBuilder().applyUpdatesToInstancesSettings();
    }

    /** Returns the builder for the settings used for calls to applyUpdatesToInstances. */
    public OperationCallSettings.Builder<
            ApplyUpdatesToInstancesInstanceGroupManagerRequest, Operation, Operation>
        applyUpdatesToInstancesOperationSettings() {
      return getStubSettingsBuilder().applyUpdatesToInstancesOperationSettings();
    }

    /** Returns the builder for the settings used for calls to createInstances. */
    public UnaryCallSettings.Builder<CreateInstancesInstanceGroupManagerRequest, Operation>
        createInstancesSettings() {
      return getStubSettingsBuilder().createInstancesSettings();
    }

    /** Returns the builder for the settings used for calls to createInstances. */
    public OperationCallSettings.Builder<
            CreateInstancesInstanceGroupManagerRequest, Operation, Operation>
        createInstancesOperationSettings() {
      return getStubSettingsBuilder().createInstancesOperationSettings();
    }

    /** Returns the builder for the settings used for calls to delete. */
    public UnaryCallSettings.Builder<DeleteInstanceGroupManagerRequest, Operation>
        deleteSettings() {
      return getStubSettingsBuilder().deleteSettings();
    }

    /** Returns the builder for the settings used for calls to delete. */
    public OperationCallSettings.Builder<DeleteInstanceGroupManagerRequest, Operation, Operation>
        deleteOperationSettings() {
      return getStubSettingsBuilder().deleteOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteInstances. */
    public UnaryCallSettings.Builder<DeleteInstancesInstanceGroupManagerRequest, Operation>
        deleteInstancesSettings() {
      return getStubSettingsBuilder().deleteInstancesSettings();
    }

    /** Returns the builder for the settings used for calls to deleteInstances. */
    public OperationCallSettings.Builder<
            DeleteInstancesInstanceGroupManagerRequest, Operation, Operation>
        deleteInstancesOperationSettings() {
      return getStubSettingsBuilder().deleteInstancesOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deletePerInstanceConfigs. */
    public UnaryCallSettings.Builder<DeletePerInstanceConfigsInstanceGroupManagerRequest, Operation>
        deletePerInstanceConfigsSettings() {
      return getStubSettingsBuilder().deletePerInstanceConfigsSettings();
    }

    /** Returns the builder for the settings used for calls to deletePerInstanceConfigs. */
    public OperationCallSettings.Builder<
            DeletePerInstanceConfigsInstanceGroupManagerRequest, Operation, Operation>
        deletePerInstanceConfigsOperationSettings() {
      return getStubSettingsBuilder().deletePerInstanceConfigsOperationSettings();
    }

    /** Returns the builder for the settings used for calls to get. */
    public UnaryCallSettings.Builder<GetInstanceGroupManagerRequest, InstanceGroupManager>
        getSettings() {
      return getStubSettingsBuilder().getSettings();
    }

    /** Returns the builder for the settings used for calls to insert. */
    public UnaryCallSettings.Builder<InsertInstanceGroupManagerRequest, Operation>
        insertSettings() {
      return getStubSettingsBuilder().insertSettings();
    }

    /** Returns the builder for the settings used for calls to insert. */
    public OperationCallSettings.Builder<InsertInstanceGroupManagerRequest, Operation, Operation>
        insertOperationSettings() {
      return getStubSettingsBuilder().insertOperationSettings();
    }

    /** Returns the builder for the settings used for calls to list. */
    public PagedCallSettings.Builder<
            ListInstanceGroupManagersRequest, InstanceGroupManagerList, ListPagedResponse>
        listSettings() {
      return getStubSettingsBuilder().listSettings();
    }

    /** Returns the builder for the settings used for calls to listErrors. */
    public PagedCallSettings.Builder<
            ListErrorsInstanceGroupManagersRequest,
            InstanceGroupManagersListErrorsResponse,
            ListErrorsPagedResponse>
        listErrorsSettings() {
      return getStubSettingsBuilder().listErrorsSettings();
    }

    /** Returns the builder for the settings used for calls to listManagedInstances. */
    public PagedCallSettings.Builder<
            ListManagedInstancesInstanceGroupManagersRequest,
            InstanceGroupManagersListManagedInstancesResponse,
            ListManagedInstancesPagedResponse>
        listManagedInstancesSettings() {
      return getStubSettingsBuilder().listManagedInstancesSettings();
    }

    /** Returns the builder for the settings used for calls to listPerInstanceConfigs. */
    public PagedCallSettings.Builder<
            ListPerInstanceConfigsInstanceGroupManagersRequest,
            InstanceGroupManagersListPerInstanceConfigsResp,
            ListPerInstanceConfigsPagedResponse>
        listPerInstanceConfigsSettings() {
      return getStubSettingsBuilder().listPerInstanceConfigsSettings();
    }

    /** Returns the builder for the settings used for calls to patch. */
    public UnaryCallSettings.Builder<PatchInstanceGroupManagerRequest, Operation> patchSettings() {
      return getStubSettingsBuilder().patchSettings();
    }

    /** Returns the builder for the settings used for calls to patch. */
    public OperationCallSettings.Builder<PatchInstanceGroupManagerRequest, Operation, Operation>
        patchOperationSettings() {
      return getStubSettingsBuilder().patchOperationSettings();
    }

    /** Returns the builder for the settings used for calls to patchPerInstanceConfigs. */
    public UnaryCallSettings.Builder<PatchPerInstanceConfigsInstanceGroupManagerRequest, Operation>
        patchPerInstanceConfigsSettings() {
      return getStubSettingsBuilder().patchPerInstanceConfigsSettings();
    }

    /** Returns the builder for the settings used for calls to patchPerInstanceConfigs. */
    public OperationCallSettings.Builder<
            PatchPerInstanceConfigsInstanceGroupManagerRequest, Operation, Operation>
        patchPerInstanceConfigsOperationSettings() {
      return getStubSettingsBuilder().patchPerInstanceConfigsOperationSettings();
    }

    /** Returns the builder for the settings used for calls to recreateInstances. */
    public UnaryCallSettings.Builder<RecreateInstancesInstanceGroupManagerRequest, Operation>
        recreateInstancesSettings() {
      return getStubSettingsBuilder().recreateInstancesSettings();
    }

    /** Returns the builder for the settings used for calls to recreateInstances. */
    public OperationCallSettings.Builder<
            RecreateInstancesInstanceGroupManagerRequest, Operation, Operation>
        recreateInstancesOperationSettings() {
      return getStubSettingsBuilder().recreateInstancesOperationSettings();
    }

    /** Returns the builder for the settings used for calls to resize. */
    public UnaryCallSettings.Builder<ResizeInstanceGroupManagerRequest, Operation>
        resizeSettings() {
      return getStubSettingsBuilder().resizeSettings();
    }

    /** Returns the builder for the settings used for calls to resize. */
    public OperationCallSettings.Builder<ResizeInstanceGroupManagerRequest, Operation, Operation>
        resizeOperationSettings() {
      return getStubSettingsBuilder().resizeOperationSettings();
    }

    /** Returns the builder for the settings used for calls to setInstanceTemplate. */
    public UnaryCallSettings.Builder<SetInstanceTemplateInstanceGroupManagerRequest, Operation>
        setInstanceTemplateSettings() {
      return getStubSettingsBuilder().setInstanceTemplateSettings();
    }

    /** Returns the builder for the settings used for calls to setInstanceTemplate. */
    public OperationCallSettings.Builder<
            SetInstanceTemplateInstanceGroupManagerRequest, Operation, Operation>
        setInstanceTemplateOperationSettings() {
      return getStubSettingsBuilder().setInstanceTemplateOperationSettings();
    }

    /** Returns the builder for the settings used for calls to setTargetPools. */
    public UnaryCallSettings.Builder<SetTargetPoolsInstanceGroupManagerRequest, Operation>
        setTargetPoolsSettings() {
      return getStubSettingsBuilder().setTargetPoolsSettings();
    }

    /** Returns the builder for the settings used for calls to setTargetPools. */
    public OperationCallSettings.Builder<
            SetTargetPoolsInstanceGroupManagerRequest, Operation, Operation>
        setTargetPoolsOperationSettings() {
      return getStubSettingsBuilder().setTargetPoolsOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updatePerInstanceConfigs. */
    public UnaryCallSettings.Builder<UpdatePerInstanceConfigsInstanceGroupManagerRequest, Operation>
        updatePerInstanceConfigsSettings() {
      return getStubSettingsBuilder().updatePerInstanceConfigsSettings();
    }

    /** Returns the builder for the settings used for calls to updatePerInstanceConfigs. */
    public OperationCallSettings.Builder<
            UpdatePerInstanceConfigsInstanceGroupManagerRequest, Operation, Operation>
        updatePerInstanceConfigsOperationSettings() {
      return getStubSettingsBuilder().updatePerInstanceConfigsOperationSettings();
    }

    @Override
    public InstanceGroupManagersSettings build() throws IOException {
      return new InstanceGroupManagersSettings(this);
    }
  }
}
