/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.compute.v1;

import static com.google.cloud.compute.v1.DiskClient.AggregatedListDisksPagedResponse;
import static com.google.cloud.compute.v1.DiskClient.ListDisksPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.compute.v1.stub.DiskStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Settings class to configure an instance of {@link DiskClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (https://www.googleapis.com/compute/v1/projects/) and default
 *       port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of addResourcePoliciesDisk to 30 seconds:
 *
 * <pre>
 * <code>
 * DiskSettings.Builder diskSettingsBuilder =
 *     DiskSettings.newBuilder();
 * diskSettingsBuilder.addResourcePoliciesDiskSettings().getRetrySettings().toBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * DiskSettings diskSettings = diskSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class DiskSettings extends ClientSettings<DiskSettings> {
  /** Returns the object with the settings used for calls to addResourcePoliciesDisk. */
  public UnaryCallSettings<AddResourcePoliciesDiskHttpRequest, Operation>
      addResourcePoliciesDiskSettings() {
    return ((DiskStubSettings) getStubSettings()).addResourcePoliciesDiskSettings();
  }

  /** Returns the object with the settings used for calls to aggregatedListDisks. */
  public PagedCallSettings<
          AggregatedListDisksHttpRequest, DiskAggregatedList, AggregatedListDisksPagedResponse>
      aggregatedListDisksSettings() {
    return ((DiskStubSettings) getStubSettings()).aggregatedListDisksSettings();
  }

  /** Returns the object with the settings used for calls to createSnapshotDisk. */
  public UnaryCallSettings<CreateSnapshotDiskHttpRequest, Operation> createSnapshotDiskSettings() {
    return ((DiskStubSettings) getStubSettings()).createSnapshotDiskSettings();
  }

  /** Returns the object with the settings used for calls to deleteDisk. */
  public UnaryCallSettings<DeleteDiskHttpRequest, Operation> deleteDiskSettings() {
    return ((DiskStubSettings) getStubSettings()).deleteDiskSettings();
  }

  /** Returns the object with the settings used for calls to getDisk. */
  public UnaryCallSettings<GetDiskHttpRequest, Disk> getDiskSettings() {
    return ((DiskStubSettings) getStubSettings()).getDiskSettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicyDisk. */
  public UnaryCallSettings<GetIamPolicyDiskHttpRequest, Policy> getIamPolicyDiskSettings() {
    return ((DiskStubSettings) getStubSettings()).getIamPolicyDiskSettings();
  }

  /** Returns the object with the settings used for calls to insertDisk. */
  public UnaryCallSettings<InsertDiskHttpRequest, Operation> insertDiskSettings() {
    return ((DiskStubSettings) getStubSettings()).insertDiskSettings();
  }

  /** Returns the object with the settings used for calls to listDisks. */
  public PagedCallSettings<ListDisksHttpRequest, DiskList, ListDisksPagedResponse>
      listDisksSettings() {
    return ((DiskStubSettings) getStubSettings()).listDisksSettings();
  }

  /** Returns the object with the settings used for calls to removeResourcePoliciesDisk. */
  public UnaryCallSettings<RemoveResourcePoliciesDiskHttpRequest, Operation>
      removeResourcePoliciesDiskSettings() {
    return ((DiskStubSettings) getStubSettings()).removeResourcePoliciesDiskSettings();
  }

  /** Returns the object with the settings used for calls to resizeDisk. */
  public UnaryCallSettings<ResizeDiskHttpRequest, Operation> resizeDiskSettings() {
    return ((DiskStubSettings) getStubSettings()).resizeDiskSettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicyDisk. */
  public UnaryCallSettings<SetIamPolicyDiskHttpRequest, Policy> setIamPolicyDiskSettings() {
    return ((DiskStubSettings) getStubSettings()).setIamPolicyDiskSettings();
  }

  /** Returns the object with the settings used for calls to setLabelsDisk. */
  public UnaryCallSettings<SetLabelsDiskHttpRequest, Operation> setLabelsDiskSettings() {
    return ((DiskStubSettings) getStubSettings()).setLabelsDiskSettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissionsDisk. */
  public UnaryCallSettings<TestIamPermissionsDiskHttpRequest, TestPermissionsResponse>
      testIamPermissionsDiskSettings() {
    return ((DiskStubSettings) getStubSettings()).testIamPermissionsDiskSettings();
  }

  public static final DiskSettings create(DiskStubSettings stub) throws IOException {
    return new DiskSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return DiskStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return DiskStubSettings.getDefaultEndpoint();
  }
  /** Returns the default service port. */
  public static int getDefaultServicePort() {
    return DiskStubSettings.getDefaultServicePort();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return DiskStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return DiskStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return DiskStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return DiskStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return DiskStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected DiskSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for DiskSettings. */
  public static class Builder extends ClientSettings.Builder<DiskSettings, Builder> {
    protected Builder() throws IOException {
      this((ClientContext) null);
    }

    protected Builder(ClientContext clientContext) {
      super(DiskStubSettings.newBuilder(clientContext));
    }

    private static Builder createDefault() {
      return new Builder(DiskStubSettings.newBuilder());
    }

    protected Builder(DiskSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(DiskStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    public DiskStubSettings.Builder getStubSettingsBuilder() {
      return ((DiskStubSettings.Builder) getStubSettings());
    }

    // NEXT_MAJOR_VER: remove 'throws Exception'
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

    /** Returns the builder for the settings used for calls to addResourcePoliciesDisk. */
    public UnaryCallSettings.Builder<AddResourcePoliciesDiskHttpRequest, Operation>
        addResourcePoliciesDiskSettings() {
      return getStubSettingsBuilder().addResourcePoliciesDiskSettings();
    }

    /** Returns the builder for the settings used for calls to aggregatedListDisks. */
    public PagedCallSettings.Builder<
            AggregatedListDisksHttpRequest, DiskAggregatedList, AggregatedListDisksPagedResponse>
        aggregatedListDisksSettings() {
      return getStubSettingsBuilder().aggregatedListDisksSettings();
    }

    /** Returns the builder for the settings used for calls to createSnapshotDisk. */
    public UnaryCallSettings.Builder<CreateSnapshotDiskHttpRequest, Operation>
        createSnapshotDiskSettings() {
      return getStubSettingsBuilder().createSnapshotDiskSettings();
    }

    /** Returns the builder for the settings used for calls to deleteDisk. */
    public UnaryCallSettings.Builder<DeleteDiskHttpRequest, Operation> deleteDiskSettings() {
      return getStubSettingsBuilder().deleteDiskSettings();
    }

    /** Returns the builder for the settings used for calls to getDisk. */
    public UnaryCallSettings.Builder<GetDiskHttpRequest, Disk> getDiskSettings() {
      return getStubSettingsBuilder().getDiskSettings();
    }

    /** Returns the builder for the settings used for calls to getIamPolicyDisk. */
    public UnaryCallSettings.Builder<GetIamPolicyDiskHttpRequest, Policy>
        getIamPolicyDiskSettings() {
      return getStubSettingsBuilder().getIamPolicyDiskSettings();
    }

    /** Returns the builder for the settings used for calls to insertDisk. */
    public UnaryCallSettings.Builder<InsertDiskHttpRequest, Operation> insertDiskSettings() {
      return getStubSettingsBuilder().insertDiskSettings();
    }

    /** Returns the builder for the settings used for calls to listDisks. */
    public PagedCallSettings.Builder<ListDisksHttpRequest, DiskList, ListDisksPagedResponse>
        listDisksSettings() {
      return getStubSettingsBuilder().listDisksSettings();
    }

    /** Returns the builder for the settings used for calls to removeResourcePoliciesDisk. */
    public UnaryCallSettings.Builder<RemoveResourcePoliciesDiskHttpRequest, Operation>
        removeResourcePoliciesDiskSettings() {
      return getStubSettingsBuilder().removeResourcePoliciesDiskSettings();
    }

    /** Returns the builder for the settings used for calls to resizeDisk. */
    public UnaryCallSettings.Builder<ResizeDiskHttpRequest, Operation> resizeDiskSettings() {
      return getStubSettingsBuilder().resizeDiskSettings();
    }

    /** Returns the builder for the settings used for calls to setIamPolicyDisk. */
    public UnaryCallSettings.Builder<SetIamPolicyDiskHttpRequest, Policy>
        setIamPolicyDiskSettings() {
      return getStubSettingsBuilder().setIamPolicyDiskSettings();
    }

    /** Returns the builder for the settings used for calls to setLabelsDisk. */
    public UnaryCallSettings.Builder<SetLabelsDiskHttpRequest, Operation> setLabelsDiskSettings() {
      return getStubSettingsBuilder().setLabelsDiskSettings();
    }

    /** Returns the builder for the settings used for calls to testIamPermissionsDisk. */
    public UnaryCallSettings.Builder<TestIamPermissionsDiskHttpRequest, TestPermissionsResponse>
        testIamPermissionsDiskSettings() {
      return getStubSettingsBuilder().testIamPermissionsDiskSettings();
    }

    @Override
    public DiskSettings build() throws IOException {
      return new DiskSettings(this);
    }
  }
}
