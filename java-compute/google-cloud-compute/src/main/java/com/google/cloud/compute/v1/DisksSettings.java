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

import static com.google.cloud.compute.v1.DisksClient.AggregatedListPagedResponse;
import static com.google.cloud.compute.v1.DisksClient.ListPagedResponse;

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
import com.google.cloud.compute.v1.stub.DisksStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link DisksClient}.
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
 * DisksSettings.Builder disksSettingsBuilder = DisksSettings.newBuilder();
 * disksSettingsBuilder
 *     .getSettings()
 *     .setRetrySettings(
 *         disksSettingsBuilder
 *             .getSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * DisksSettings disksSettings = disksSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class DisksSettings extends ClientSettings<DisksSettings> {

  /** Returns the object with the settings used for calls to addResourcePolicies. */
  public UnaryCallSettings<AddResourcePoliciesDiskRequest, Operation>
      addResourcePoliciesSettings() {
    return ((DisksStubSettings) getStubSettings()).addResourcePoliciesSettings();
  }

  /** Returns the object with the settings used for calls to addResourcePolicies. */
  public OperationCallSettings<AddResourcePoliciesDiskRequest, Operation, Operation>
      addResourcePoliciesOperationSettings() {
    return ((DisksStubSettings) getStubSettings()).addResourcePoliciesOperationSettings();
  }

  /** Returns the object with the settings used for calls to aggregatedList. */
  public PagedCallSettings<
          AggregatedListDisksRequest, DiskAggregatedList, AggregatedListPagedResponse>
      aggregatedListSettings() {
    return ((DisksStubSettings) getStubSettings()).aggregatedListSettings();
  }

  /** Returns the object with the settings used for calls to createSnapshot. */
  public UnaryCallSettings<CreateSnapshotDiskRequest, Operation> createSnapshotSettings() {
    return ((DisksStubSettings) getStubSettings()).createSnapshotSettings();
  }

  /** Returns the object with the settings used for calls to createSnapshot. */
  public OperationCallSettings<CreateSnapshotDiskRequest, Operation, Operation>
      createSnapshotOperationSettings() {
    return ((DisksStubSettings) getStubSettings()).createSnapshotOperationSettings();
  }

  /** Returns the object with the settings used for calls to delete. */
  public UnaryCallSettings<DeleteDiskRequest, Operation> deleteSettings() {
    return ((DisksStubSettings) getStubSettings()).deleteSettings();
  }

  /** Returns the object with the settings used for calls to delete. */
  public OperationCallSettings<DeleteDiskRequest, Operation, Operation> deleteOperationSettings() {
    return ((DisksStubSettings) getStubSettings()).deleteOperationSettings();
  }

  /** Returns the object with the settings used for calls to get. */
  public UnaryCallSettings<GetDiskRequest, Disk> getSettings() {
    return ((DisksStubSettings) getStubSettings()).getSettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyDiskRequest, Policy> getIamPolicySettings() {
    return ((DisksStubSettings) getStubSettings()).getIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to insert. */
  public UnaryCallSettings<InsertDiskRequest, Operation> insertSettings() {
    return ((DisksStubSettings) getStubSettings()).insertSettings();
  }

  /** Returns the object with the settings used for calls to insert. */
  public OperationCallSettings<InsertDiskRequest, Operation, Operation> insertOperationSettings() {
    return ((DisksStubSettings) getStubSettings()).insertOperationSettings();
  }

  /** Returns the object with the settings used for calls to list. */
  public PagedCallSettings<ListDisksRequest, DiskList, ListPagedResponse> listSettings() {
    return ((DisksStubSettings) getStubSettings()).listSettings();
  }

  /** Returns the object with the settings used for calls to removeResourcePolicies. */
  public UnaryCallSettings<RemoveResourcePoliciesDiskRequest, Operation>
      removeResourcePoliciesSettings() {
    return ((DisksStubSettings) getStubSettings()).removeResourcePoliciesSettings();
  }

  /** Returns the object with the settings used for calls to removeResourcePolicies. */
  public OperationCallSettings<RemoveResourcePoliciesDiskRequest, Operation, Operation>
      removeResourcePoliciesOperationSettings() {
    return ((DisksStubSettings) getStubSettings()).removeResourcePoliciesOperationSettings();
  }

  /** Returns the object with the settings used for calls to resize. */
  public UnaryCallSettings<ResizeDiskRequest, Operation> resizeSettings() {
    return ((DisksStubSettings) getStubSettings()).resizeSettings();
  }

  /** Returns the object with the settings used for calls to resize. */
  public OperationCallSettings<ResizeDiskRequest, Operation, Operation> resizeOperationSettings() {
    return ((DisksStubSettings) getStubSettings()).resizeOperationSettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyDiskRequest, Policy> setIamPolicySettings() {
    return ((DisksStubSettings) getStubSettings()).setIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to setLabels. */
  public UnaryCallSettings<SetLabelsDiskRequest, Operation> setLabelsSettings() {
    return ((DisksStubSettings) getStubSettings()).setLabelsSettings();
  }

  /** Returns the object with the settings used for calls to setLabels. */
  public OperationCallSettings<SetLabelsDiskRequest, Operation, Operation>
      setLabelsOperationSettings() {
    return ((DisksStubSettings) getStubSettings()).setLabelsOperationSettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsDiskRequest, TestPermissionsResponse>
      testIamPermissionsSettings() {
    return ((DisksStubSettings) getStubSettings()).testIamPermissionsSettings();
  }

  public static final DisksSettings create(DisksStubSettings stub) throws IOException {
    return new DisksSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return DisksStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return DisksStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return DisksStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return DisksStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return DisksStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return DisksStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return DisksStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected DisksSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for DisksSettings. */
  public static class Builder extends ClientSettings.Builder<DisksSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(DisksStubSettings.newBuilder(clientContext));
    }

    protected Builder(DisksSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(DisksStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(DisksStubSettings.newBuilder());
    }

    public DisksStubSettings.Builder getStubSettingsBuilder() {
      return ((DisksStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to addResourcePolicies. */
    public UnaryCallSettings.Builder<AddResourcePoliciesDiskRequest, Operation>
        addResourcePoliciesSettings() {
      return getStubSettingsBuilder().addResourcePoliciesSettings();
    }

    /** Returns the builder for the settings used for calls to addResourcePolicies. */
    public OperationCallSettings.Builder<AddResourcePoliciesDiskRequest, Operation, Operation>
        addResourcePoliciesOperationSettings() {
      return getStubSettingsBuilder().addResourcePoliciesOperationSettings();
    }

    /** Returns the builder for the settings used for calls to aggregatedList. */
    public PagedCallSettings.Builder<
            AggregatedListDisksRequest, DiskAggregatedList, AggregatedListPagedResponse>
        aggregatedListSettings() {
      return getStubSettingsBuilder().aggregatedListSettings();
    }

    /** Returns the builder for the settings used for calls to createSnapshot. */
    public UnaryCallSettings.Builder<CreateSnapshotDiskRequest, Operation>
        createSnapshotSettings() {
      return getStubSettingsBuilder().createSnapshotSettings();
    }

    /** Returns the builder for the settings used for calls to createSnapshot. */
    public OperationCallSettings.Builder<CreateSnapshotDiskRequest, Operation, Operation>
        createSnapshotOperationSettings() {
      return getStubSettingsBuilder().createSnapshotOperationSettings();
    }

    /** Returns the builder for the settings used for calls to delete. */
    public UnaryCallSettings.Builder<DeleteDiskRequest, Operation> deleteSettings() {
      return getStubSettingsBuilder().deleteSettings();
    }

    /** Returns the builder for the settings used for calls to delete. */
    public OperationCallSettings.Builder<DeleteDiskRequest, Operation, Operation>
        deleteOperationSettings() {
      return getStubSettingsBuilder().deleteOperationSettings();
    }

    /** Returns the builder for the settings used for calls to get. */
    public UnaryCallSettings.Builder<GetDiskRequest, Disk> getSettings() {
      return getStubSettingsBuilder().getSettings();
    }

    /** Returns the builder for the settings used for calls to getIamPolicy. */
    public UnaryCallSettings.Builder<GetIamPolicyDiskRequest, Policy> getIamPolicySettings() {
      return getStubSettingsBuilder().getIamPolicySettings();
    }

    /** Returns the builder for the settings used for calls to insert. */
    public UnaryCallSettings.Builder<InsertDiskRequest, Operation> insertSettings() {
      return getStubSettingsBuilder().insertSettings();
    }

    /** Returns the builder for the settings used for calls to insert. */
    public OperationCallSettings.Builder<InsertDiskRequest, Operation, Operation>
        insertOperationSettings() {
      return getStubSettingsBuilder().insertOperationSettings();
    }

    /** Returns the builder for the settings used for calls to list. */
    public PagedCallSettings.Builder<ListDisksRequest, DiskList, ListPagedResponse> listSettings() {
      return getStubSettingsBuilder().listSettings();
    }

    /** Returns the builder for the settings used for calls to removeResourcePolicies. */
    public UnaryCallSettings.Builder<RemoveResourcePoliciesDiskRequest, Operation>
        removeResourcePoliciesSettings() {
      return getStubSettingsBuilder().removeResourcePoliciesSettings();
    }

    /** Returns the builder for the settings used for calls to removeResourcePolicies. */
    public OperationCallSettings.Builder<RemoveResourcePoliciesDiskRequest, Operation, Operation>
        removeResourcePoliciesOperationSettings() {
      return getStubSettingsBuilder().removeResourcePoliciesOperationSettings();
    }

    /** Returns the builder for the settings used for calls to resize. */
    public UnaryCallSettings.Builder<ResizeDiskRequest, Operation> resizeSettings() {
      return getStubSettingsBuilder().resizeSettings();
    }

    /** Returns the builder for the settings used for calls to resize. */
    public OperationCallSettings.Builder<ResizeDiskRequest, Operation, Operation>
        resizeOperationSettings() {
      return getStubSettingsBuilder().resizeOperationSettings();
    }

    /** Returns the builder for the settings used for calls to setIamPolicy. */
    public UnaryCallSettings.Builder<SetIamPolicyDiskRequest, Policy> setIamPolicySettings() {
      return getStubSettingsBuilder().setIamPolicySettings();
    }

    /** Returns the builder for the settings used for calls to setLabels. */
    public UnaryCallSettings.Builder<SetLabelsDiskRequest, Operation> setLabelsSettings() {
      return getStubSettingsBuilder().setLabelsSettings();
    }

    /** Returns the builder for the settings used for calls to setLabels. */
    public OperationCallSettings.Builder<SetLabelsDiskRequest, Operation, Operation>
        setLabelsOperationSettings() {
      return getStubSettingsBuilder().setLabelsOperationSettings();
    }

    /** Returns the builder for the settings used for calls to testIamPermissions. */
    public UnaryCallSettings.Builder<TestIamPermissionsDiskRequest, TestPermissionsResponse>
        testIamPermissionsSettings() {
      return getStubSettingsBuilder().testIamPermissionsSettings();
    }

    @Override
    public DisksSettings build() throws IOException {
      return new DisksSettings(this);
    }
  }
}
