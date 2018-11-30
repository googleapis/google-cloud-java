/*
 * Copyright 2018 Google LLC
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

import static com.google.cloud.compute.v1.RegionInstanceGroupManagerClient.ListRegionInstanceGroupManagersPagedResponse;

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
import com.google.cloud.compute.v1.stub.RegionInstanceGroupManagerStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Settings class to configure an instance of {@link RegionInstanceGroupManagerClient}.
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
 * example, to set the total timeout of abandonInstancesRegionInstanceGroupManager to 30 seconds:
 *
 * <pre>
 * <code>
 * RegionInstanceGroupManagerSettings.Builder regionInstanceGroupManagerSettingsBuilder =
 *     RegionInstanceGroupManagerSettings.newBuilder();
 * regionInstanceGroupManagerSettingsBuilder.abandonInstancesRegionInstanceGroupManagerSettings().getRetrySettings().toBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * RegionInstanceGroupManagerSettings regionInstanceGroupManagerSettings = regionInstanceGroupManagerSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class RegionInstanceGroupManagerSettings
    extends ClientSettings<RegionInstanceGroupManagerSettings> {
  /**
   * Returns the object with the settings used for calls to
   * abandonInstancesRegionInstanceGroupManager.
   */
  public UnaryCallSettings<AbandonInstancesRegionInstanceGroupManagerHttpRequest, Operation>
      abandonInstancesRegionInstanceGroupManagerSettings() {
    return ((RegionInstanceGroupManagerStubSettings) getStubSettings())
        .abandonInstancesRegionInstanceGroupManagerSettings();
  }

  /** Returns the object with the settings used for calls to deleteRegionInstanceGroupManager. */
  public UnaryCallSettings<DeleteRegionInstanceGroupManagerHttpRequest, Operation>
      deleteRegionInstanceGroupManagerSettings() {
    return ((RegionInstanceGroupManagerStubSettings) getStubSettings())
        .deleteRegionInstanceGroupManagerSettings();
  }

  /**
   * Returns the object with the settings used for calls to
   * deleteInstancesRegionInstanceGroupManager.
   */
  public UnaryCallSettings<DeleteInstancesRegionInstanceGroupManagerHttpRequest, Operation>
      deleteInstancesRegionInstanceGroupManagerSettings() {
    return ((RegionInstanceGroupManagerStubSettings) getStubSettings())
        .deleteInstancesRegionInstanceGroupManagerSettings();
  }

  /** Returns the object with the settings used for calls to getRegionInstanceGroupManager. */
  public UnaryCallSettings<GetRegionInstanceGroupManagerHttpRequest, InstanceGroupManager>
      getRegionInstanceGroupManagerSettings() {
    return ((RegionInstanceGroupManagerStubSettings) getStubSettings())
        .getRegionInstanceGroupManagerSettings();
  }

  /** Returns the object with the settings used for calls to insertRegionInstanceGroupManager. */
  public UnaryCallSettings<InsertRegionInstanceGroupManagerHttpRequest, Operation>
      insertRegionInstanceGroupManagerSettings() {
    return ((RegionInstanceGroupManagerStubSettings) getStubSettings())
        .insertRegionInstanceGroupManagerSettings();
  }

  /** Returns the object with the settings used for calls to listRegionInstanceGroupManagers. */
  public PagedCallSettings<
          ListRegionInstanceGroupManagersHttpRequest,
          RegionInstanceGroupManagerList,
          ListRegionInstanceGroupManagersPagedResponse>
      listRegionInstanceGroupManagersSettings() {
    return ((RegionInstanceGroupManagerStubSettings) getStubSettings())
        .listRegionInstanceGroupManagersSettings();
  }

  /**
   * Returns the object with the settings used for calls to
   * listManagedInstancesRegionInstanceGroupManagers.
   */
  public UnaryCallSettings<
          ListManagedInstancesRegionInstanceGroupManagersHttpRequest,
          RegionInstanceGroupManagersListInstancesResponse>
      listManagedInstancesRegionInstanceGroupManagersSettings() {
    return ((RegionInstanceGroupManagerStubSettings) getStubSettings())
        .listManagedInstancesRegionInstanceGroupManagersSettings();
  }

  /**
   * Returns the object with the settings used for calls to
   * recreateInstancesRegionInstanceGroupManager.
   */
  public UnaryCallSettings<RecreateInstancesRegionInstanceGroupManagerHttpRequest, Operation>
      recreateInstancesRegionInstanceGroupManagerSettings() {
    return ((RegionInstanceGroupManagerStubSettings) getStubSettings())
        .recreateInstancesRegionInstanceGroupManagerSettings();
  }

  /** Returns the object with the settings used for calls to resizeRegionInstanceGroupManager. */
  public UnaryCallSettings<ResizeRegionInstanceGroupManagerHttpRequest, Operation>
      resizeRegionInstanceGroupManagerSettings() {
    return ((RegionInstanceGroupManagerStubSettings) getStubSettings())
        .resizeRegionInstanceGroupManagerSettings();
  }

  /**
   * Returns the object with the settings used for calls to
   * setInstanceTemplateRegionInstanceGroupManager.
   */
  public UnaryCallSettings<SetInstanceTemplateRegionInstanceGroupManagerHttpRequest, Operation>
      setInstanceTemplateRegionInstanceGroupManagerSettings() {
    return ((RegionInstanceGroupManagerStubSettings) getStubSettings())
        .setInstanceTemplateRegionInstanceGroupManagerSettings();
  }

  /**
   * Returns the object with the settings used for calls to
   * setTargetPoolsRegionInstanceGroupManager.
   */
  public UnaryCallSettings<SetTargetPoolsRegionInstanceGroupManagerHttpRequest, Operation>
      setTargetPoolsRegionInstanceGroupManagerSettings() {
    return ((RegionInstanceGroupManagerStubSettings) getStubSettings())
        .setTargetPoolsRegionInstanceGroupManagerSettings();
  }

  public static final RegionInstanceGroupManagerSettings create(
      RegionInstanceGroupManagerStubSettings stub) throws IOException {
    return new RegionInstanceGroupManagerSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return RegionInstanceGroupManagerStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return RegionInstanceGroupManagerStubSettings.getDefaultEndpoint();
  }
  /** Returns the default service port. */
  public static int getDefaultServicePort() {
    return RegionInstanceGroupManagerStubSettings.getDefaultServicePort();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return RegionInstanceGroupManagerStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return RegionInstanceGroupManagerStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return RegionInstanceGroupManagerStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return RegionInstanceGroupManagerStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return RegionInstanceGroupManagerStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected RegionInstanceGroupManagerSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for RegionInstanceGroupManagerSettings. */
  public static class Builder
      extends ClientSettings.Builder<RegionInstanceGroupManagerSettings, Builder> {
    protected Builder() throws IOException {
      this((ClientContext) null);
    }

    protected Builder(ClientContext clientContext) {
      super(RegionInstanceGroupManagerStubSettings.newBuilder(clientContext));
    }

    private static Builder createDefault() {
      return new Builder(RegionInstanceGroupManagerStubSettings.newBuilder());
    }

    protected Builder(RegionInstanceGroupManagerSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(RegionInstanceGroupManagerStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    public RegionInstanceGroupManagerStubSettings.Builder getStubSettingsBuilder() {
      return ((RegionInstanceGroupManagerStubSettings.Builder) getStubSettings());
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

    /**
     * Returns the builder for the settings used for calls to
     * abandonInstancesRegionInstanceGroupManager.
     */
    public UnaryCallSettings.Builder<
            AbandonInstancesRegionInstanceGroupManagerHttpRequest, Operation>
        abandonInstancesRegionInstanceGroupManagerSettings() {
      return getStubSettingsBuilder().abandonInstancesRegionInstanceGroupManagerSettings();
    }

    /** Returns the builder for the settings used for calls to deleteRegionInstanceGroupManager. */
    public UnaryCallSettings.Builder<DeleteRegionInstanceGroupManagerHttpRequest, Operation>
        deleteRegionInstanceGroupManagerSettings() {
      return getStubSettingsBuilder().deleteRegionInstanceGroupManagerSettings();
    }

    /**
     * Returns the builder for the settings used for calls to
     * deleteInstancesRegionInstanceGroupManager.
     */
    public UnaryCallSettings.Builder<
            DeleteInstancesRegionInstanceGroupManagerHttpRequest, Operation>
        deleteInstancesRegionInstanceGroupManagerSettings() {
      return getStubSettingsBuilder().deleteInstancesRegionInstanceGroupManagerSettings();
    }

    /** Returns the builder for the settings used for calls to getRegionInstanceGroupManager. */
    public UnaryCallSettings.Builder<GetRegionInstanceGroupManagerHttpRequest, InstanceGroupManager>
        getRegionInstanceGroupManagerSettings() {
      return getStubSettingsBuilder().getRegionInstanceGroupManagerSettings();
    }

    /** Returns the builder for the settings used for calls to insertRegionInstanceGroupManager. */
    public UnaryCallSettings.Builder<InsertRegionInstanceGroupManagerHttpRequest, Operation>
        insertRegionInstanceGroupManagerSettings() {
      return getStubSettingsBuilder().insertRegionInstanceGroupManagerSettings();
    }

    /** Returns the builder for the settings used for calls to listRegionInstanceGroupManagers. */
    public PagedCallSettings.Builder<
            ListRegionInstanceGroupManagersHttpRequest,
            RegionInstanceGroupManagerList,
            ListRegionInstanceGroupManagersPagedResponse>
        listRegionInstanceGroupManagersSettings() {
      return getStubSettingsBuilder().listRegionInstanceGroupManagersSettings();
    }

    /**
     * Returns the builder for the settings used for calls to
     * listManagedInstancesRegionInstanceGroupManagers.
     */
    public UnaryCallSettings.Builder<
            ListManagedInstancesRegionInstanceGroupManagersHttpRequest,
            RegionInstanceGroupManagersListInstancesResponse>
        listManagedInstancesRegionInstanceGroupManagersSettings() {
      return getStubSettingsBuilder().listManagedInstancesRegionInstanceGroupManagersSettings();
    }

    /**
     * Returns the builder for the settings used for calls to
     * recreateInstancesRegionInstanceGroupManager.
     */
    public UnaryCallSettings.Builder<
            RecreateInstancesRegionInstanceGroupManagerHttpRequest, Operation>
        recreateInstancesRegionInstanceGroupManagerSettings() {
      return getStubSettingsBuilder().recreateInstancesRegionInstanceGroupManagerSettings();
    }

    /** Returns the builder for the settings used for calls to resizeRegionInstanceGroupManager. */
    public UnaryCallSettings.Builder<ResizeRegionInstanceGroupManagerHttpRequest, Operation>
        resizeRegionInstanceGroupManagerSettings() {
      return getStubSettingsBuilder().resizeRegionInstanceGroupManagerSettings();
    }

    /**
     * Returns the builder for the settings used for calls to
     * setInstanceTemplateRegionInstanceGroupManager.
     */
    public UnaryCallSettings.Builder<
            SetInstanceTemplateRegionInstanceGroupManagerHttpRequest, Operation>
        setInstanceTemplateRegionInstanceGroupManagerSettings() {
      return getStubSettingsBuilder().setInstanceTemplateRegionInstanceGroupManagerSettings();
    }

    /**
     * Returns the builder for the settings used for calls to
     * setTargetPoolsRegionInstanceGroupManager.
     */
    public UnaryCallSettings.Builder<SetTargetPoolsRegionInstanceGroupManagerHttpRequest, Operation>
        setTargetPoolsRegionInstanceGroupManagerSettings() {
      return getStubSettingsBuilder().setTargetPoolsRegionInstanceGroupManagerSettings();
    }

    @Override
    public RegionInstanceGroupManagerSettings build() throws IOException {
      return new RegionInstanceGroupManagerSettings(this);
    }
  }
}
