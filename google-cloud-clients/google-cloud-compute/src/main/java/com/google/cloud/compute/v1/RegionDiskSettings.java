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

import static com.google.cloud.compute.v1.RegionDiskClient.ListRegionDisksPagedResponse;

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
import com.google.cloud.compute.v1.stub.RegionDiskStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Settings class to configure an instance of {@link RegionDiskClient}.
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
 * build() is called, the tree of builders is called to create the complete settings object. For
 * example, to set the total timeout of addResourcePoliciesRegionDisk to 30 seconds:
 *
 * <pre>
 * <code>
 * RegionDiskSettings.Builder regionDiskSettingsBuilder =
 *     RegionDiskSettings.newBuilder();
 * regionDiskSettingsBuilder.addResourcePoliciesRegionDiskSettings().getRetrySettings().toBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * RegionDiskSettings regionDiskSettings = regionDiskSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class RegionDiskSettings extends ClientSettings<RegionDiskSettings> {
  /** Returns the object with the settings used for calls to addResourcePoliciesRegionDisk. */
  public UnaryCallSettings<AddResourcePoliciesRegionDiskHttpRequest, Operation>
      addResourcePoliciesRegionDiskSettings() {
    return ((RegionDiskStubSettings) getStubSettings()).addResourcePoliciesRegionDiskSettings();
  }

  /** Returns the object with the settings used for calls to createSnapshotRegionDisk. */
  public UnaryCallSettings<CreateSnapshotRegionDiskHttpRequest, Operation>
      createSnapshotRegionDiskSettings() {
    return ((RegionDiskStubSettings) getStubSettings()).createSnapshotRegionDiskSettings();
  }

  /** Returns the object with the settings used for calls to deleteRegionDisk. */
  public UnaryCallSettings<DeleteRegionDiskHttpRequest, Operation> deleteRegionDiskSettings() {
    return ((RegionDiskStubSettings) getStubSettings()).deleteRegionDiskSettings();
  }

  /** Returns the object with the settings used for calls to getRegionDisk. */
  public UnaryCallSettings<GetRegionDiskHttpRequest, Disk> getRegionDiskSettings() {
    return ((RegionDiskStubSettings) getStubSettings()).getRegionDiskSettings();
  }

  /** Returns the object with the settings used for calls to insertRegionDisk. */
  public UnaryCallSettings<InsertRegionDiskHttpRequest, Operation> insertRegionDiskSettings() {
    return ((RegionDiskStubSettings) getStubSettings()).insertRegionDiskSettings();
  }

  /** Returns the object with the settings used for calls to listRegionDisks. */
  public PagedCallSettings<ListRegionDisksHttpRequest, DiskList, ListRegionDisksPagedResponse>
      listRegionDisksSettings() {
    return ((RegionDiskStubSettings) getStubSettings()).listRegionDisksSettings();
  }

  /** Returns the object with the settings used for calls to removeResourcePoliciesRegionDisk. */
  public UnaryCallSettings<RemoveResourcePoliciesRegionDiskHttpRequest, Operation>
      removeResourcePoliciesRegionDiskSettings() {
    return ((RegionDiskStubSettings) getStubSettings()).removeResourcePoliciesRegionDiskSettings();
  }

  /** Returns the object with the settings used for calls to resizeRegionDisk. */
  public UnaryCallSettings<ResizeRegionDiskHttpRequest, Operation> resizeRegionDiskSettings() {
    return ((RegionDiskStubSettings) getStubSettings()).resizeRegionDiskSettings();
  }

  /** Returns the object with the settings used for calls to setLabelsRegionDisk. */
  public UnaryCallSettings<SetLabelsRegionDiskHttpRequest, Operation>
      setLabelsRegionDiskSettings() {
    return ((RegionDiskStubSettings) getStubSettings()).setLabelsRegionDiskSettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissionsRegionDisk. */
  public UnaryCallSettings<TestIamPermissionsRegionDiskHttpRequest, TestPermissionsResponse>
      testIamPermissionsRegionDiskSettings() {
    return ((RegionDiskStubSettings) getStubSettings()).testIamPermissionsRegionDiskSettings();
  }

  public static final RegionDiskSettings create(RegionDiskStubSettings stub) throws IOException {
    return new RegionDiskSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return RegionDiskStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return RegionDiskStubSettings.getDefaultEndpoint();
  }
  /** Returns the default service port. */
  public static int getDefaultServicePort() {
    return RegionDiskStubSettings.getDefaultServicePort();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return RegionDiskStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return RegionDiskStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return RegionDiskStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return RegionDiskStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return RegionDiskStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected RegionDiskSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for RegionDiskSettings. */
  public static class Builder extends ClientSettings.Builder<RegionDiskSettings, Builder> {
    protected Builder() throws IOException {
      this((ClientContext) null);
    }

    protected Builder(ClientContext clientContext) {
      super(RegionDiskStubSettings.newBuilder(clientContext));
    }

    private static Builder createDefault() {
      return new Builder(RegionDiskStubSettings.newBuilder());
    }

    protected Builder(RegionDiskSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(RegionDiskStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    public RegionDiskStubSettings.Builder getStubSettingsBuilder() {
      return ((RegionDiskStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to addResourcePoliciesRegionDisk. */
    public UnaryCallSettings.Builder<AddResourcePoliciesRegionDiskHttpRequest, Operation>
        addResourcePoliciesRegionDiskSettings() {
      return getStubSettingsBuilder().addResourcePoliciesRegionDiskSettings();
    }

    /** Returns the builder for the settings used for calls to createSnapshotRegionDisk. */
    public UnaryCallSettings.Builder<CreateSnapshotRegionDiskHttpRequest, Operation>
        createSnapshotRegionDiskSettings() {
      return getStubSettingsBuilder().createSnapshotRegionDiskSettings();
    }

    /** Returns the builder for the settings used for calls to deleteRegionDisk. */
    public UnaryCallSettings.Builder<DeleteRegionDiskHttpRequest, Operation>
        deleteRegionDiskSettings() {
      return getStubSettingsBuilder().deleteRegionDiskSettings();
    }

    /** Returns the builder for the settings used for calls to getRegionDisk. */
    public UnaryCallSettings.Builder<GetRegionDiskHttpRequest, Disk> getRegionDiskSettings() {
      return getStubSettingsBuilder().getRegionDiskSettings();
    }

    /** Returns the builder for the settings used for calls to insertRegionDisk. */
    public UnaryCallSettings.Builder<InsertRegionDiskHttpRequest, Operation>
        insertRegionDiskSettings() {
      return getStubSettingsBuilder().insertRegionDiskSettings();
    }

    /** Returns the builder for the settings used for calls to listRegionDisks. */
    public PagedCallSettings.Builder<
            ListRegionDisksHttpRequest, DiskList, ListRegionDisksPagedResponse>
        listRegionDisksSettings() {
      return getStubSettingsBuilder().listRegionDisksSettings();
    }

    /** Returns the builder for the settings used for calls to removeResourcePoliciesRegionDisk. */
    public UnaryCallSettings.Builder<RemoveResourcePoliciesRegionDiskHttpRequest, Operation>
        removeResourcePoliciesRegionDiskSettings() {
      return getStubSettingsBuilder().removeResourcePoliciesRegionDiskSettings();
    }

    /** Returns the builder for the settings used for calls to resizeRegionDisk. */
    public UnaryCallSettings.Builder<ResizeRegionDiskHttpRequest, Operation>
        resizeRegionDiskSettings() {
      return getStubSettingsBuilder().resizeRegionDiskSettings();
    }

    /** Returns the builder for the settings used for calls to setLabelsRegionDisk. */
    public UnaryCallSettings.Builder<SetLabelsRegionDiskHttpRequest, Operation>
        setLabelsRegionDiskSettings() {
      return getStubSettingsBuilder().setLabelsRegionDiskSettings();
    }

    /** Returns the builder for the settings used for calls to testIamPermissionsRegionDisk. */
    public UnaryCallSettings.Builder<
            TestIamPermissionsRegionDiskHttpRequest, TestPermissionsResponse>
        testIamPermissionsRegionDiskSettings() {
      return getStubSettingsBuilder().testIamPermissionsRegionDiskSettings();
    }

    @Override
    public RegionDiskSettings build() throws IOException {
      return new RegionDiskSettings(this);
    }
  }
}
