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

import static com.google.cloud.compute.v1.RegionDisksClient.ListPagedResponse;

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
import com.google.cloud.compute.v1.stub.RegionDisksStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link RegionDisksClient}.
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
 * RegionDisksSettings.Builder regionDisksSettingsBuilder = RegionDisksSettings.newBuilder();
 * regionDisksSettingsBuilder
 *     .getSettings()
 *     .setRetrySettings(
 *         regionDisksSettingsBuilder.getSettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * RegionDisksSettings regionDisksSettings = regionDisksSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class RegionDisksSettings extends ClientSettings<RegionDisksSettings> {

  /** Returns the object with the settings used for calls to addResourcePolicies. */
  public UnaryCallSettings<AddResourcePoliciesRegionDiskRequest, Operation>
      addResourcePoliciesSettings() {
    return ((RegionDisksStubSettings) getStubSettings()).addResourcePoliciesSettings();
  }

  /** Returns the object with the settings used for calls to addResourcePolicies. */
  public OperationCallSettings<AddResourcePoliciesRegionDiskRequest, Operation, Operation>
      addResourcePoliciesOperationSettings() {
    return ((RegionDisksStubSettings) getStubSettings()).addResourcePoliciesOperationSettings();
  }

  /** Returns the object with the settings used for calls to createSnapshot. */
  public UnaryCallSettings<CreateSnapshotRegionDiskRequest, Operation> createSnapshotSettings() {
    return ((RegionDisksStubSettings) getStubSettings()).createSnapshotSettings();
  }

  /** Returns the object with the settings used for calls to createSnapshot. */
  public OperationCallSettings<CreateSnapshotRegionDiskRequest, Operation, Operation>
      createSnapshotOperationSettings() {
    return ((RegionDisksStubSettings) getStubSettings()).createSnapshotOperationSettings();
  }

  /** Returns the object with the settings used for calls to delete. */
  public UnaryCallSettings<DeleteRegionDiskRequest, Operation> deleteSettings() {
    return ((RegionDisksStubSettings) getStubSettings()).deleteSettings();
  }

  /** Returns the object with the settings used for calls to delete. */
  public OperationCallSettings<DeleteRegionDiskRequest, Operation, Operation>
      deleteOperationSettings() {
    return ((RegionDisksStubSettings) getStubSettings()).deleteOperationSettings();
  }

  /** Returns the object with the settings used for calls to get. */
  public UnaryCallSettings<GetRegionDiskRequest, Disk> getSettings() {
    return ((RegionDisksStubSettings) getStubSettings()).getSettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRegionDiskRequest, Policy> getIamPolicySettings() {
    return ((RegionDisksStubSettings) getStubSettings()).getIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to insert. */
  public UnaryCallSettings<InsertRegionDiskRequest, Operation> insertSettings() {
    return ((RegionDisksStubSettings) getStubSettings()).insertSettings();
  }

  /** Returns the object with the settings used for calls to insert. */
  public OperationCallSettings<InsertRegionDiskRequest, Operation, Operation>
      insertOperationSettings() {
    return ((RegionDisksStubSettings) getStubSettings()).insertOperationSettings();
  }

  /** Returns the object with the settings used for calls to list. */
  public PagedCallSettings<ListRegionDisksRequest, DiskList, ListPagedResponse> listSettings() {
    return ((RegionDisksStubSettings) getStubSettings()).listSettings();
  }

  /** Returns the object with the settings used for calls to removeResourcePolicies. */
  public UnaryCallSettings<RemoveResourcePoliciesRegionDiskRequest, Operation>
      removeResourcePoliciesSettings() {
    return ((RegionDisksStubSettings) getStubSettings()).removeResourcePoliciesSettings();
  }

  /** Returns the object with the settings used for calls to removeResourcePolicies. */
  public OperationCallSettings<RemoveResourcePoliciesRegionDiskRequest, Operation, Operation>
      removeResourcePoliciesOperationSettings() {
    return ((RegionDisksStubSettings) getStubSettings()).removeResourcePoliciesOperationSettings();
  }

  /** Returns the object with the settings used for calls to resize. */
  public UnaryCallSettings<ResizeRegionDiskRequest, Operation> resizeSettings() {
    return ((RegionDisksStubSettings) getStubSettings()).resizeSettings();
  }

  /** Returns the object with the settings used for calls to resize. */
  public OperationCallSettings<ResizeRegionDiskRequest, Operation, Operation>
      resizeOperationSettings() {
    return ((RegionDisksStubSettings) getStubSettings()).resizeOperationSettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRegionDiskRequest, Policy> setIamPolicySettings() {
    return ((RegionDisksStubSettings) getStubSettings()).setIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to setLabels. */
  public UnaryCallSettings<SetLabelsRegionDiskRequest, Operation> setLabelsSettings() {
    return ((RegionDisksStubSettings) getStubSettings()).setLabelsSettings();
  }

  /** Returns the object with the settings used for calls to setLabels. */
  public OperationCallSettings<SetLabelsRegionDiskRequest, Operation, Operation>
      setLabelsOperationSettings() {
    return ((RegionDisksStubSettings) getStubSettings()).setLabelsOperationSettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRegionDiskRequest, TestPermissionsResponse>
      testIamPermissionsSettings() {
    return ((RegionDisksStubSettings) getStubSettings()).testIamPermissionsSettings();
  }

  public static final RegionDisksSettings create(RegionDisksStubSettings stub) throws IOException {
    return new RegionDisksSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return RegionDisksStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return RegionDisksStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return RegionDisksStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return RegionDisksStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return RegionDisksStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return RegionDisksStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return RegionDisksStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected RegionDisksSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for RegionDisksSettings. */
  public static class Builder extends ClientSettings.Builder<RegionDisksSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(RegionDisksStubSettings.newBuilder(clientContext));
    }

    protected Builder(RegionDisksSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(RegionDisksStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(RegionDisksStubSettings.newBuilder());
    }

    public RegionDisksStubSettings.Builder getStubSettingsBuilder() {
      return ((RegionDisksStubSettings.Builder) getStubSettings());
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
    public UnaryCallSettings.Builder<AddResourcePoliciesRegionDiskRequest, Operation>
        addResourcePoliciesSettings() {
      return getStubSettingsBuilder().addResourcePoliciesSettings();
    }

    /** Returns the builder for the settings used for calls to addResourcePolicies. */
    public OperationCallSettings.Builder<AddResourcePoliciesRegionDiskRequest, Operation, Operation>
        addResourcePoliciesOperationSettings() {
      return getStubSettingsBuilder().addResourcePoliciesOperationSettings();
    }

    /** Returns the builder for the settings used for calls to createSnapshot. */
    public UnaryCallSettings.Builder<CreateSnapshotRegionDiskRequest, Operation>
        createSnapshotSettings() {
      return getStubSettingsBuilder().createSnapshotSettings();
    }

    /** Returns the builder for the settings used for calls to createSnapshot. */
    public OperationCallSettings.Builder<CreateSnapshotRegionDiskRequest, Operation, Operation>
        createSnapshotOperationSettings() {
      return getStubSettingsBuilder().createSnapshotOperationSettings();
    }

    /** Returns the builder for the settings used for calls to delete. */
    public UnaryCallSettings.Builder<DeleteRegionDiskRequest, Operation> deleteSettings() {
      return getStubSettingsBuilder().deleteSettings();
    }

    /** Returns the builder for the settings used for calls to delete. */
    public OperationCallSettings.Builder<DeleteRegionDiskRequest, Operation, Operation>
        deleteOperationSettings() {
      return getStubSettingsBuilder().deleteOperationSettings();
    }

    /** Returns the builder for the settings used for calls to get. */
    public UnaryCallSettings.Builder<GetRegionDiskRequest, Disk> getSettings() {
      return getStubSettingsBuilder().getSettings();
    }

    /** Returns the builder for the settings used for calls to getIamPolicy. */
    public UnaryCallSettings.Builder<GetIamPolicyRegionDiskRequest, Policy> getIamPolicySettings() {
      return getStubSettingsBuilder().getIamPolicySettings();
    }

    /** Returns the builder for the settings used for calls to insert. */
    public UnaryCallSettings.Builder<InsertRegionDiskRequest, Operation> insertSettings() {
      return getStubSettingsBuilder().insertSettings();
    }

    /** Returns the builder for the settings used for calls to insert. */
    public OperationCallSettings.Builder<InsertRegionDiskRequest, Operation, Operation>
        insertOperationSettings() {
      return getStubSettingsBuilder().insertOperationSettings();
    }

    /** Returns the builder for the settings used for calls to list. */
    public PagedCallSettings.Builder<ListRegionDisksRequest, DiskList, ListPagedResponse>
        listSettings() {
      return getStubSettingsBuilder().listSettings();
    }

    /** Returns the builder for the settings used for calls to removeResourcePolicies. */
    public UnaryCallSettings.Builder<RemoveResourcePoliciesRegionDiskRequest, Operation>
        removeResourcePoliciesSettings() {
      return getStubSettingsBuilder().removeResourcePoliciesSettings();
    }

    /** Returns the builder for the settings used for calls to removeResourcePolicies. */
    public OperationCallSettings.Builder<
            RemoveResourcePoliciesRegionDiskRequest, Operation, Operation>
        removeResourcePoliciesOperationSettings() {
      return getStubSettingsBuilder().removeResourcePoliciesOperationSettings();
    }

    /** Returns the builder for the settings used for calls to resize. */
    public UnaryCallSettings.Builder<ResizeRegionDiskRequest, Operation> resizeSettings() {
      return getStubSettingsBuilder().resizeSettings();
    }

    /** Returns the builder for the settings used for calls to resize. */
    public OperationCallSettings.Builder<ResizeRegionDiskRequest, Operation, Operation>
        resizeOperationSettings() {
      return getStubSettingsBuilder().resizeOperationSettings();
    }

    /** Returns the builder for the settings used for calls to setIamPolicy. */
    public UnaryCallSettings.Builder<SetIamPolicyRegionDiskRequest, Policy> setIamPolicySettings() {
      return getStubSettingsBuilder().setIamPolicySettings();
    }

    /** Returns the builder for the settings used for calls to setLabels. */
    public UnaryCallSettings.Builder<SetLabelsRegionDiskRequest, Operation> setLabelsSettings() {
      return getStubSettingsBuilder().setLabelsSettings();
    }

    /** Returns the builder for the settings used for calls to setLabels. */
    public OperationCallSettings.Builder<SetLabelsRegionDiskRequest, Operation, Operation>
        setLabelsOperationSettings() {
      return getStubSettingsBuilder().setLabelsOperationSettings();
    }

    /** Returns the builder for the settings used for calls to testIamPermissions. */
    public UnaryCallSettings.Builder<TestIamPermissionsRegionDiskRequest, TestPermissionsResponse>
        testIamPermissionsSettings() {
      return getStubSettingsBuilder().testIamPermissionsSettings();
    }

    @Override
    public RegionDisksSettings build() throws IOException {
      return new RegionDisksSettings(this);
    }
  }
}
