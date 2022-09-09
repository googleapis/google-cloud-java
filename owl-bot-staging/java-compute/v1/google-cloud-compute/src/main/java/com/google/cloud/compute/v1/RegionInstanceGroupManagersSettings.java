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

import static com.google.cloud.compute.v1.RegionInstanceGroupManagersClient.ListErrorsPagedResponse;
import static com.google.cloud.compute.v1.RegionInstanceGroupManagersClient.ListManagedInstancesPagedResponse;
import static com.google.cloud.compute.v1.RegionInstanceGroupManagersClient.ListPagedResponse;
import static com.google.cloud.compute.v1.RegionInstanceGroupManagersClient.ListPerInstanceConfigsPagedResponse;

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
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.compute.v1.stub.RegionInstanceGroupManagersStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link RegionInstanceGroupManagersClient}.
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
 * RegionInstanceGroupManagersSettings.Builder regionInstanceGroupManagersSettingsBuilder =
 *     RegionInstanceGroupManagersSettings.newBuilder();
 * regionInstanceGroupManagersSettingsBuilder
 *     .getSettings()
 *     .setRetrySettings(
 *         regionInstanceGroupManagersSettingsBuilder.getSettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * RegionInstanceGroupManagersSettings regionInstanceGroupManagersSettings =
 *     regionInstanceGroupManagersSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class RegionInstanceGroupManagersSettings
    extends ClientSettings<RegionInstanceGroupManagersSettings> {

  /** Returns the object with the settings used for calls to abandonInstances. */
  public UnaryCallSettings<AbandonInstancesRegionInstanceGroupManagerRequest, Operation>
      abandonInstancesSettings() {
    return ((RegionInstanceGroupManagersStubSettings) getStubSettings()).abandonInstancesSettings();
  }

  /** Returns the object with the settings used for calls to abandonInstances. */
  public OperationCallSettings<
          AbandonInstancesRegionInstanceGroupManagerRequest, Operation, Operation>
      abandonInstancesOperationSettings() {
    return ((RegionInstanceGroupManagersStubSettings) getStubSettings())
        .abandonInstancesOperationSettings();
  }

  /** Returns the object with the settings used for calls to applyUpdatesToInstances. */
  public UnaryCallSettings<ApplyUpdatesToInstancesRegionInstanceGroupManagerRequest, Operation>
      applyUpdatesToInstancesSettings() {
    return ((RegionInstanceGroupManagersStubSettings) getStubSettings())
        .applyUpdatesToInstancesSettings();
  }

  /** Returns the object with the settings used for calls to applyUpdatesToInstances. */
  public OperationCallSettings<
          ApplyUpdatesToInstancesRegionInstanceGroupManagerRequest, Operation, Operation>
      applyUpdatesToInstancesOperationSettings() {
    return ((RegionInstanceGroupManagersStubSettings) getStubSettings())
        .applyUpdatesToInstancesOperationSettings();
  }

  /** Returns the object with the settings used for calls to createInstances. */
  public UnaryCallSettings<CreateInstancesRegionInstanceGroupManagerRequest, Operation>
      createInstancesSettings() {
    return ((RegionInstanceGroupManagersStubSettings) getStubSettings()).createInstancesSettings();
  }

  /** Returns the object with the settings used for calls to createInstances. */
  public OperationCallSettings<
          CreateInstancesRegionInstanceGroupManagerRequest, Operation, Operation>
      createInstancesOperationSettings() {
    return ((RegionInstanceGroupManagersStubSettings) getStubSettings())
        .createInstancesOperationSettings();
  }

  /** Returns the object with the settings used for calls to delete. */
  public UnaryCallSettings<DeleteRegionInstanceGroupManagerRequest, Operation> deleteSettings() {
    return ((RegionInstanceGroupManagersStubSettings) getStubSettings()).deleteSettings();
  }

  /** Returns the object with the settings used for calls to delete. */
  public OperationCallSettings<DeleteRegionInstanceGroupManagerRequest, Operation, Operation>
      deleteOperationSettings() {
    return ((RegionInstanceGroupManagersStubSettings) getStubSettings()).deleteOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteInstances. */
  public UnaryCallSettings<DeleteInstancesRegionInstanceGroupManagerRequest, Operation>
      deleteInstancesSettings() {
    return ((RegionInstanceGroupManagersStubSettings) getStubSettings()).deleteInstancesSettings();
  }

  /** Returns the object with the settings used for calls to deleteInstances. */
  public OperationCallSettings<
          DeleteInstancesRegionInstanceGroupManagerRequest, Operation, Operation>
      deleteInstancesOperationSettings() {
    return ((RegionInstanceGroupManagersStubSettings) getStubSettings())
        .deleteInstancesOperationSettings();
  }

  /** Returns the object with the settings used for calls to deletePerInstanceConfigs. */
  public UnaryCallSettings<DeletePerInstanceConfigsRegionInstanceGroupManagerRequest, Operation>
      deletePerInstanceConfigsSettings() {
    return ((RegionInstanceGroupManagersStubSettings) getStubSettings())
        .deletePerInstanceConfigsSettings();
  }

  /** Returns the object with the settings used for calls to deletePerInstanceConfigs. */
  public OperationCallSettings<
          DeletePerInstanceConfigsRegionInstanceGroupManagerRequest, Operation, Operation>
      deletePerInstanceConfigsOperationSettings() {
    return ((RegionInstanceGroupManagersStubSettings) getStubSettings())
        .deletePerInstanceConfigsOperationSettings();
  }

  /** Returns the object with the settings used for calls to get. */
  public UnaryCallSettings<GetRegionInstanceGroupManagerRequest, InstanceGroupManager>
      getSettings() {
    return ((RegionInstanceGroupManagersStubSettings) getStubSettings()).getSettings();
  }

  /** Returns the object with the settings used for calls to insert. */
  public UnaryCallSettings<InsertRegionInstanceGroupManagerRequest, Operation> insertSettings() {
    return ((RegionInstanceGroupManagersStubSettings) getStubSettings()).insertSettings();
  }

  /** Returns the object with the settings used for calls to insert. */
  public OperationCallSettings<InsertRegionInstanceGroupManagerRequest, Operation, Operation>
      insertOperationSettings() {
    return ((RegionInstanceGroupManagersStubSettings) getStubSettings()).insertOperationSettings();
  }

  /** Returns the object with the settings used for calls to list. */
  public PagedCallSettings<
          ListRegionInstanceGroupManagersRequest, RegionInstanceGroupManagerList, ListPagedResponse>
      listSettings() {
    return ((RegionInstanceGroupManagersStubSettings) getStubSettings()).listSettings();
  }

  /** Returns the object with the settings used for calls to listErrors. */
  public PagedCallSettings<
          ListErrorsRegionInstanceGroupManagersRequest,
          RegionInstanceGroupManagersListErrorsResponse,
          ListErrorsPagedResponse>
      listErrorsSettings() {
    return ((RegionInstanceGroupManagersStubSettings) getStubSettings()).listErrorsSettings();
  }

  /** Returns the object with the settings used for calls to listManagedInstances. */
  public PagedCallSettings<
          ListManagedInstancesRegionInstanceGroupManagersRequest,
          RegionInstanceGroupManagersListInstancesResponse,
          ListManagedInstancesPagedResponse>
      listManagedInstancesSettings() {
    return ((RegionInstanceGroupManagersStubSettings) getStubSettings())
        .listManagedInstancesSettings();
  }

  /** Returns the object with the settings used for calls to listPerInstanceConfigs. */
  public PagedCallSettings<
          ListPerInstanceConfigsRegionInstanceGroupManagersRequest,
          RegionInstanceGroupManagersListInstanceConfigsResp,
          ListPerInstanceConfigsPagedResponse>
      listPerInstanceConfigsSettings() {
    return ((RegionInstanceGroupManagersStubSettings) getStubSettings())
        .listPerInstanceConfigsSettings();
  }

  /** Returns the object with the settings used for calls to patch. */
  public UnaryCallSettings<PatchRegionInstanceGroupManagerRequest, Operation> patchSettings() {
    return ((RegionInstanceGroupManagersStubSettings) getStubSettings()).patchSettings();
  }

  /** Returns the object with the settings used for calls to patch. */
  public OperationCallSettings<PatchRegionInstanceGroupManagerRequest, Operation, Operation>
      patchOperationSettings() {
    return ((RegionInstanceGroupManagersStubSettings) getStubSettings()).patchOperationSettings();
  }

  /** Returns the object with the settings used for calls to patchPerInstanceConfigs. */
  public UnaryCallSettings<PatchPerInstanceConfigsRegionInstanceGroupManagerRequest, Operation>
      patchPerInstanceConfigsSettings() {
    return ((RegionInstanceGroupManagersStubSettings) getStubSettings())
        .patchPerInstanceConfigsSettings();
  }

  /** Returns the object with the settings used for calls to patchPerInstanceConfigs. */
  public OperationCallSettings<
          PatchPerInstanceConfigsRegionInstanceGroupManagerRequest, Operation, Operation>
      patchPerInstanceConfigsOperationSettings() {
    return ((RegionInstanceGroupManagersStubSettings) getStubSettings())
        .patchPerInstanceConfigsOperationSettings();
  }

  /** Returns the object with the settings used for calls to recreateInstances. */
  public UnaryCallSettings<RecreateInstancesRegionInstanceGroupManagerRequest, Operation>
      recreateInstancesSettings() {
    return ((RegionInstanceGroupManagersStubSettings) getStubSettings())
        .recreateInstancesSettings();
  }

  /** Returns the object with the settings used for calls to recreateInstances. */
  public OperationCallSettings<
          RecreateInstancesRegionInstanceGroupManagerRequest, Operation, Operation>
      recreateInstancesOperationSettings() {
    return ((RegionInstanceGroupManagersStubSettings) getStubSettings())
        .recreateInstancesOperationSettings();
  }

  /** Returns the object with the settings used for calls to resize. */
  public UnaryCallSettings<ResizeRegionInstanceGroupManagerRequest, Operation> resizeSettings() {
    return ((RegionInstanceGroupManagersStubSettings) getStubSettings()).resizeSettings();
  }

  /** Returns the object with the settings used for calls to resize. */
  public OperationCallSettings<ResizeRegionInstanceGroupManagerRequest, Operation, Operation>
      resizeOperationSettings() {
    return ((RegionInstanceGroupManagersStubSettings) getStubSettings()).resizeOperationSettings();
  }

  /** Returns the object with the settings used for calls to setInstanceTemplate. */
  public UnaryCallSettings<SetInstanceTemplateRegionInstanceGroupManagerRequest, Operation>
      setInstanceTemplateSettings() {
    return ((RegionInstanceGroupManagersStubSettings) getStubSettings())
        .setInstanceTemplateSettings();
  }

  /** Returns the object with the settings used for calls to setInstanceTemplate. */
  public OperationCallSettings<
          SetInstanceTemplateRegionInstanceGroupManagerRequest, Operation, Operation>
      setInstanceTemplateOperationSettings() {
    return ((RegionInstanceGroupManagersStubSettings) getStubSettings())
        .setInstanceTemplateOperationSettings();
  }

  /** Returns the object with the settings used for calls to setTargetPools. */
  public UnaryCallSettings<SetTargetPoolsRegionInstanceGroupManagerRequest, Operation>
      setTargetPoolsSettings() {
    return ((RegionInstanceGroupManagersStubSettings) getStubSettings()).setTargetPoolsSettings();
  }

  /** Returns the object with the settings used for calls to setTargetPools. */
  public OperationCallSettings<
          SetTargetPoolsRegionInstanceGroupManagerRequest, Operation, Operation>
      setTargetPoolsOperationSettings() {
    return ((RegionInstanceGroupManagersStubSettings) getStubSettings())
        .setTargetPoolsOperationSettings();
  }

  /** Returns the object with the settings used for calls to updatePerInstanceConfigs. */
  public UnaryCallSettings<UpdatePerInstanceConfigsRegionInstanceGroupManagerRequest, Operation>
      updatePerInstanceConfigsSettings() {
    return ((RegionInstanceGroupManagersStubSettings) getStubSettings())
        .updatePerInstanceConfigsSettings();
  }

  /** Returns the object with the settings used for calls to updatePerInstanceConfigs. */
  public OperationCallSettings<
          UpdatePerInstanceConfigsRegionInstanceGroupManagerRequest, Operation, Operation>
      updatePerInstanceConfigsOperationSettings() {
    return ((RegionInstanceGroupManagersStubSettings) getStubSettings())
        .updatePerInstanceConfigsOperationSettings();
  }

  public static final RegionInstanceGroupManagersSettings create(
      RegionInstanceGroupManagersStubSettings stub) throws IOException {
    return new RegionInstanceGroupManagersSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return RegionInstanceGroupManagersStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return RegionInstanceGroupManagersStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return RegionInstanceGroupManagersStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return RegionInstanceGroupManagersStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return RegionInstanceGroupManagersStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return RegionInstanceGroupManagersStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return RegionInstanceGroupManagersStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected RegionInstanceGroupManagersSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for RegionInstanceGroupManagersSettings. */
  public static class Builder
      extends ClientSettings.Builder<RegionInstanceGroupManagersSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(RegionInstanceGroupManagersStubSettings.newBuilder(clientContext));
    }

    protected Builder(RegionInstanceGroupManagersSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(RegionInstanceGroupManagersStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(RegionInstanceGroupManagersStubSettings.newBuilder());
    }

    public RegionInstanceGroupManagersStubSettings.Builder getStubSettingsBuilder() {
      return ((RegionInstanceGroupManagersStubSettings.Builder) getStubSettings());
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
    public UnaryCallSettings.Builder<AbandonInstancesRegionInstanceGroupManagerRequest, Operation>
        abandonInstancesSettings() {
      return getStubSettingsBuilder().abandonInstancesSettings();
    }

    /** Returns the builder for the settings used for calls to abandonInstances. */
    public OperationCallSettings.Builder<
            AbandonInstancesRegionInstanceGroupManagerRequest, Operation, Operation>
        abandonInstancesOperationSettings() {
      return getStubSettingsBuilder().abandonInstancesOperationSettings();
    }

    /** Returns the builder for the settings used for calls to applyUpdatesToInstances. */
    public UnaryCallSettings.Builder<
            ApplyUpdatesToInstancesRegionInstanceGroupManagerRequest, Operation>
        applyUpdatesToInstancesSettings() {
      return getStubSettingsBuilder().applyUpdatesToInstancesSettings();
    }

    /** Returns the builder for the settings used for calls to applyUpdatesToInstances. */
    public OperationCallSettings.Builder<
            ApplyUpdatesToInstancesRegionInstanceGroupManagerRequest, Operation, Operation>
        applyUpdatesToInstancesOperationSettings() {
      return getStubSettingsBuilder().applyUpdatesToInstancesOperationSettings();
    }

    /** Returns the builder for the settings used for calls to createInstances. */
    public UnaryCallSettings.Builder<CreateInstancesRegionInstanceGroupManagerRequest, Operation>
        createInstancesSettings() {
      return getStubSettingsBuilder().createInstancesSettings();
    }

    /** Returns the builder for the settings used for calls to createInstances. */
    public OperationCallSettings.Builder<
            CreateInstancesRegionInstanceGroupManagerRequest, Operation, Operation>
        createInstancesOperationSettings() {
      return getStubSettingsBuilder().createInstancesOperationSettings();
    }

    /** Returns the builder for the settings used for calls to delete. */
    public UnaryCallSettings.Builder<DeleteRegionInstanceGroupManagerRequest, Operation>
        deleteSettings() {
      return getStubSettingsBuilder().deleteSettings();
    }

    /** Returns the builder for the settings used for calls to delete. */
    public OperationCallSettings.Builder<
            DeleteRegionInstanceGroupManagerRequest, Operation, Operation>
        deleteOperationSettings() {
      return getStubSettingsBuilder().deleteOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteInstances. */
    public UnaryCallSettings.Builder<DeleteInstancesRegionInstanceGroupManagerRequest, Operation>
        deleteInstancesSettings() {
      return getStubSettingsBuilder().deleteInstancesSettings();
    }

    /** Returns the builder for the settings used for calls to deleteInstances. */
    public OperationCallSettings.Builder<
            DeleteInstancesRegionInstanceGroupManagerRequest, Operation, Operation>
        deleteInstancesOperationSettings() {
      return getStubSettingsBuilder().deleteInstancesOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deletePerInstanceConfigs. */
    public UnaryCallSettings.Builder<
            DeletePerInstanceConfigsRegionInstanceGroupManagerRequest, Operation>
        deletePerInstanceConfigsSettings() {
      return getStubSettingsBuilder().deletePerInstanceConfigsSettings();
    }

    /** Returns the builder for the settings used for calls to deletePerInstanceConfigs. */
    public OperationCallSettings.Builder<
            DeletePerInstanceConfigsRegionInstanceGroupManagerRequest, Operation, Operation>
        deletePerInstanceConfigsOperationSettings() {
      return getStubSettingsBuilder().deletePerInstanceConfigsOperationSettings();
    }

    /** Returns the builder for the settings used for calls to get. */
    public UnaryCallSettings.Builder<GetRegionInstanceGroupManagerRequest, InstanceGroupManager>
        getSettings() {
      return getStubSettingsBuilder().getSettings();
    }

    /** Returns the builder for the settings used for calls to insert. */
    public UnaryCallSettings.Builder<InsertRegionInstanceGroupManagerRequest, Operation>
        insertSettings() {
      return getStubSettingsBuilder().insertSettings();
    }

    /** Returns the builder for the settings used for calls to insert. */
    public OperationCallSettings.Builder<
            InsertRegionInstanceGroupManagerRequest, Operation, Operation>
        insertOperationSettings() {
      return getStubSettingsBuilder().insertOperationSettings();
    }

    /** Returns the builder for the settings used for calls to list. */
    public PagedCallSettings.Builder<
            ListRegionInstanceGroupManagersRequest,
            RegionInstanceGroupManagerList,
            ListPagedResponse>
        listSettings() {
      return getStubSettingsBuilder().listSettings();
    }

    /** Returns the builder for the settings used for calls to listErrors. */
    public PagedCallSettings.Builder<
            ListErrorsRegionInstanceGroupManagersRequest,
            RegionInstanceGroupManagersListErrorsResponse,
            ListErrorsPagedResponse>
        listErrorsSettings() {
      return getStubSettingsBuilder().listErrorsSettings();
    }

    /** Returns the builder for the settings used for calls to listManagedInstances. */
    public PagedCallSettings.Builder<
            ListManagedInstancesRegionInstanceGroupManagersRequest,
            RegionInstanceGroupManagersListInstancesResponse,
            ListManagedInstancesPagedResponse>
        listManagedInstancesSettings() {
      return getStubSettingsBuilder().listManagedInstancesSettings();
    }

    /** Returns the builder for the settings used for calls to listPerInstanceConfigs. */
    public PagedCallSettings.Builder<
            ListPerInstanceConfigsRegionInstanceGroupManagersRequest,
            RegionInstanceGroupManagersListInstanceConfigsResp,
            ListPerInstanceConfigsPagedResponse>
        listPerInstanceConfigsSettings() {
      return getStubSettingsBuilder().listPerInstanceConfigsSettings();
    }

    /** Returns the builder for the settings used for calls to patch. */
    public UnaryCallSettings.Builder<PatchRegionInstanceGroupManagerRequest, Operation>
        patchSettings() {
      return getStubSettingsBuilder().patchSettings();
    }

    /** Returns the builder for the settings used for calls to patch. */
    public OperationCallSettings.Builder<
            PatchRegionInstanceGroupManagerRequest, Operation, Operation>
        patchOperationSettings() {
      return getStubSettingsBuilder().patchOperationSettings();
    }

    /** Returns the builder for the settings used for calls to patchPerInstanceConfigs. */
    public UnaryCallSettings.Builder<
            PatchPerInstanceConfigsRegionInstanceGroupManagerRequest, Operation>
        patchPerInstanceConfigsSettings() {
      return getStubSettingsBuilder().patchPerInstanceConfigsSettings();
    }

    /** Returns the builder for the settings used for calls to patchPerInstanceConfigs. */
    public OperationCallSettings.Builder<
            PatchPerInstanceConfigsRegionInstanceGroupManagerRequest, Operation, Operation>
        patchPerInstanceConfigsOperationSettings() {
      return getStubSettingsBuilder().patchPerInstanceConfigsOperationSettings();
    }

    /** Returns the builder for the settings used for calls to recreateInstances. */
    public UnaryCallSettings.Builder<RecreateInstancesRegionInstanceGroupManagerRequest, Operation>
        recreateInstancesSettings() {
      return getStubSettingsBuilder().recreateInstancesSettings();
    }

    /** Returns the builder for the settings used for calls to recreateInstances. */
    public OperationCallSettings.Builder<
            RecreateInstancesRegionInstanceGroupManagerRequest, Operation, Operation>
        recreateInstancesOperationSettings() {
      return getStubSettingsBuilder().recreateInstancesOperationSettings();
    }

    /** Returns the builder for the settings used for calls to resize. */
    public UnaryCallSettings.Builder<ResizeRegionInstanceGroupManagerRequest, Operation>
        resizeSettings() {
      return getStubSettingsBuilder().resizeSettings();
    }

    /** Returns the builder for the settings used for calls to resize. */
    public OperationCallSettings.Builder<
            ResizeRegionInstanceGroupManagerRequest, Operation, Operation>
        resizeOperationSettings() {
      return getStubSettingsBuilder().resizeOperationSettings();
    }

    /** Returns the builder for the settings used for calls to setInstanceTemplate. */
    public UnaryCallSettings.Builder<
            SetInstanceTemplateRegionInstanceGroupManagerRequest, Operation>
        setInstanceTemplateSettings() {
      return getStubSettingsBuilder().setInstanceTemplateSettings();
    }

    /** Returns the builder for the settings used for calls to setInstanceTemplate. */
    public OperationCallSettings.Builder<
            SetInstanceTemplateRegionInstanceGroupManagerRequest, Operation, Operation>
        setInstanceTemplateOperationSettings() {
      return getStubSettingsBuilder().setInstanceTemplateOperationSettings();
    }

    /** Returns the builder for the settings used for calls to setTargetPools. */
    public UnaryCallSettings.Builder<SetTargetPoolsRegionInstanceGroupManagerRequest, Operation>
        setTargetPoolsSettings() {
      return getStubSettingsBuilder().setTargetPoolsSettings();
    }

    /** Returns the builder for the settings used for calls to setTargetPools. */
    public OperationCallSettings.Builder<
            SetTargetPoolsRegionInstanceGroupManagerRequest, Operation, Operation>
        setTargetPoolsOperationSettings() {
      return getStubSettingsBuilder().setTargetPoolsOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updatePerInstanceConfigs. */
    public UnaryCallSettings.Builder<
            UpdatePerInstanceConfigsRegionInstanceGroupManagerRequest, Operation>
        updatePerInstanceConfigsSettings() {
      return getStubSettingsBuilder().updatePerInstanceConfigsSettings();
    }

    /** Returns the builder for the settings used for calls to updatePerInstanceConfigs. */
    public OperationCallSettings.Builder<
            UpdatePerInstanceConfigsRegionInstanceGroupManagerRequest, Operation, Operation>
        updatePerInstanceConfigsOperationSettings() {
      return getStubSettingsBuilder().updatePerInstanceConfigsOperationSettings();
    }

    @Override
    public RegionInstanceGroupManagersSettings build() throws IOException {
      return new RegionInstanceGroupManagersSettings(this);
    }
  }
}
