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

import static com.google.cloud.compute.v1.InstanceGroupManagerClient.AggregatedListInstanceGroupManagersPagedResponse;
import static com.google.cloud.compute.v1.InstanceGroupManagerClient.ListInstanceGroupManagersPagedResponse;

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
import com.google.cloud.compute.v1.stub.InstanceGroupManagerStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Settings class to configure an instance of {@link InstanceGroupManagerClient}.
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
 * example, to set the total timeout of abandonInstancesInstanceGroupManager to 30 seconds:
 *
 * <pre>
 * <code>
 * InstanceGroupManagerSettings.Builder instanceGroupManagerSettingsBuilder =
 *     InstanceGroupManagerSettings.newBuilder();
 * instanceGroupManagerSettingsBuilder.abandonInstancesInstanceGroupManagerSettings().getRetrySettings().toBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * InstanceGroupManagerSettings instanceGroupManagerSettings = instanceGroupManagerSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class InstanceGroupManagerSettings extends ClientSettings<InstanceGroupManagerSettings> {
  /**
   * Returns the object with the settings used for calls to abandonInstancesInstanceGroupManager.
   */
  public UnaryCallSettings<AbandonInstancesInstanceGroupManagerHttpRequest, Operation>
      abandonInstancesInstanceGroupManagerSettings() {
    return ((InstanceGroupManagerStubSettings) getStubSettings())
        .abandonInstancesInstanceGroupManagerSettings();
  }

  /** Returns the object with the settings used for calls to aggregatedListInstanceGroupManagers. */
  public PagedCallSettings<
          AggregatedListInstanceGroupManagersHttpRequest,
          InstanceGroupManagerAggregatedList,
          AggregatedListInstanceGroupManagersPagedResponse>
      aggregatedListInstanceGroupManagersSettings() {
    return ((InstanceGroupManagerStubSettings) getStubSettings())
        .aggregatedListInstanceGroupManagersSettings();
  }

  /** Returns the object with the settings used for calls to deleteInstanceGroupManager. */
  public UnaryCallSettings<DeleteInstanceGroupManagerHttpRequest, Operation>
      deleteInstanceGroupManagerSettings() {
    return ((InstanceGroupManagerStubSettings) getStubSettings())
        .deleteInstanceGroupManagerSettings();
  }

  /** Returns the object with the settings used for calls to deleteInstancesInstanceGroupManager. */
  public UnaryCallSettings<DeleteInstancesInstanceGroupManagerHttpRequest, Operation>
      deleteInstancesInstanceGroupManagerSettings() {
    return ((InstanceGroupManagerStubSettings) getStubSettings())
        .deleteInstancesInstanceGroupManagerSettings();
  }

  /** Returns the object with the settings used for calls to getInstanceGroupManager. */
  public UnaryCallSettings<GetInstanceGroupManagerHttpRequest, InstanceGroupManager>
      getInstanceGroupManagerSettings() {
    return ((InstanceGroupManagerStubSettings) getStubSettings()).getInstanceGroupManagerSettings();
  }

  /** Returns the object with the settings used for calls to insertInstanceGroupManager. */
  public UnaryCallSettings<InsertInstanceGroupManagerHttpRequest, Operation>
      insertInstanceGroupManagerSettings() {
    return ((InstanceGroupManagerStubSettings) getStubSettings())
        .insertInstanceGroupManagerSettings();
  }

  /** Returns the object with the settings used for calls to listInstanceGroupManagers. */
  public PagedCallSettings<
          ListInstanceGroupManagersHttpRequest,
          InstanceGroupManagerList,
          ListInstanceGroupManagersPagedResponse>
      listInstanceGroupManagersSettings() {
    return ((InstanceGroupManagerStubSettings) getStubSettings())
        .listInstanceGroupManagersSettings();
  }

  /**
   * Returns the object with the settings used for calls to
   * listManagedInstancesInstanceGroupManagers.
   */
  public UnaryCallSettings<
          ListManagedInstancesInstanceGroupManagersHttpRequest,
          InstanceGroupManagersListManagedInstancesResponse>
      listManagedInstancesInstanceGroupManagersSettings() {
    return ((InstanceGroupManagerStubSettings) getStubSettings())
        .listManagedInstancesInstanceGroupManagersSettings();
  }

  /** Returns the object with the settings used for calls to patchInstanceGroupManager. */
  public UnaryCallSettings<PatchInstanceGroupManagerHttpRequest, Operation>
      patchInstanceGroupManagerSettings() {
    return ((InstanceGroupManagerStubSettings) getStubSettings())
        .patchInstanceGroupManagerSettings();
  }

  /**
   * Returns the object with the settings used for calls to recreateInstancesInstanceGroupManager.
   */
  public UnaryCallSettings<RecreateInstancesInstanceGroupManagerHttpRequest, Operation>
      recreateInstancesInstanceGroupManagerSettings() {
    return ((InstanceGroupManagerStubSettings) getStubSettings())
        .recreateInstancesInstanceGroupManagerSettings();
  }

  /** Returns the object with the settings used for calls to resizeInstanceGroupManager. */
  public UnaryCallSettings<ResizeInstanceGroupManagerHttpRequest, Operation>
      resizeInstanceGroupManagerSettings() {
    return ((InstanceGroupManagerStubSettings) getStubSettings())
        .resizeInstanceGroupManagerSettings();
  }

  /**
   * Returns the object with the settings used for calls to setInstanceTemplateInstanceGroupManager.
   */
  public UnaryCallSettings<SetInstanceTemplateInstanceGroupManagerHttpRequest, Operation>
      setInstanceTemplateInstanceGroupManagerSettings() {
    return ((InstanceGroupManagerStubSettings) getStubSettings())
        .setInstanceTemplateInstanceGroupManagerSettings();
  }

  /** Returns the object with the settings used for calls to setTargetPoolsInstanceGroupManager. */
  public UnaryCallSettings<SetTargetPoolsInstanceGroupManagerHttpRequest, Operation>
      setTargetPoolsInstanceGroupManagerSettings() {
    return ((InstanceGroupManagerStubSettings) getStubSettings())
        .setTargetPoolsInstanceGroupManagerSettings();
  }

  public static final InstanceGroupManagerSettings create(InstanceGroupManagerStubSettings stub)
      throws IOException {
    return new InstanceGroupManagerSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstanceGroupManagerStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return InstanceGroupManagerStubSettings.getDefaultEndpoint();
  }
  /** Returns the default service port. */
  public static int getDefaultServicePort() {
    return InstanceGroupManagerStubSettings.getDefaultServicePort();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return InstanceGroupManagerStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return InstanceGroupManagerStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return InstanceGroupManagerStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return InstanceGroupManagerStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return InstanceGroupManagerStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected InstanceGroupManagerSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for InstanceGroupManagerSettings. */
  public static class Builder
      extends ClientSettings.Builder<InstanceGroupManagerSettings, Builder> {
    protected Builder() throws IOException {
      this((ClientContext) null);
    }

    protected Builder(ClientContext clientContext) {
      super(InstanceGroupManagerStubSettings.newBuilder(clientContext));
    }

    private static Builder createDefault() {
      return new Builder(InstanceGroupManagerStubSettings.newBuilder());
    }

    protected Builder(InstanceGroupManagerSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(InstanceGroupManagerStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    public InstanceGroupManagerStubSettings.Builder getStubSettingsBuilder() {
      return ((InstanceGroupManagerStubSettings.Builder) getStubSettings());
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
     * Returns the builder for the settings used for calls to abandonInstancesInstanceGroupManager.
     */
    public UnaryCallSettings.Builder<AbandonInstancesInstanceGroupManagerHttpRequest, Operation>
        abandonInstancesInstanceGroupManagerSettings() {
      return getStubSettingsBuilder().abandonInstancesInstanceGroupManagerSettings();
    }

    /**
     * Returns the builder for the settings used for calls to aggregatedListInstanceGroupManagers.
     */
    public PagedCallSettings.Builder<
            AggregatedListInstanceGroupManagersHttpRequest,
            InstanceGroupManagerAggregatedList,
            AggregatedListInstanceGroupManagersPagedResponse>
        aggregatedListInstanceGroupManagersSettings() {
      return getStubSettingsBuilder().aggregatedListInstanceGroupManagersSettings();
    }

    /** Returns the builder for the settings used for calls to deleteInstanceGroupManager. */
    public UnaryCallSettings.Builder<DeleteInstanceGroupManagerHttpRequest, Operation>
        deleteInstanceGroupManagerSettings() {
      return getStubSettingsBuilder().deleteInstanceGroupManagerSettings();
    }

    /**
     * Returns the builder for the settings used for calls to deleteInstancesInstanceGroupManager.
     */
    public UnaryCallSettings.Builder<DeleteInstancesInstanceGroupManagerHttpRequest, Operation>
        deleteInstancesInstanceGroupManagerSettings() {
      return getStubSettingsBuilder().deleteInstancesInstanceGroupManagerSettings();
    }

    /** Returns the builder for the settings used for calls to getInstanceGroupManager. */
    public UnaryCallSettings.Builder<GetInstanceGroupManagerHttpRequest, InstanceGroupManager>
        getInstanceGroupManagerSettings() {
      return getStubSettingsBuilder().getInstanceGroupManagerSettings();
    }

    /** Returns the builder for the settings used for calls to insertInstanceGroupManager. */
    public UnaryCallSettings.Builder<InsertInstanceGroupManagerHttpRequest, Operation>
        insertInstanceGroupManagerSettings() {
      return getStubSettingsBuilder().insertInstanceGroupManagerSettings();
    }

    /** Returns the builder for the settings used for calls to listInstanceGroupManagers. */
    public PagedCallSettings.Builder<
            ListInstanceGroupManagersHttpRequest,
            InstanceGroupManagerList,
            ListInstanceGroupManagersPagedResponse>
        listInstanceGroupManagersSettings() {
      return getStubSettingsBuilder().listInstanceGroupManagersSettings();
    }

    /**
     * Returns the builder for the settings used for calls to
     * listManagedInstancesInstanceGroupManagers.
     */
    public UnaryCallSettings.Builder<
            ListManagedInstancesInstanceGroupManagersHttpRequest,
            InstanceGroupManagersListManagedInstancesResponse>
        listManagedInstancesInstanceGroupManagersSettings() {
      return getStubSettingsBuilder().listManagedInstancesInstanceGroupManagersSettings();
    }

    /** Returns the builder for the settings used for calls to patchInstanceGroupManager. */
    public UnaryCallSettings.Builder<PatchInstanceGroupManagerHttpRequest, Operation>
        patchInstanceGroupManagerSettings() {
      return getStubSettingsBuilder().patchInstanceGroupManagerSettings();
    }

    /**
     * Returns the builder for the settings used for calls to recreateInstancesInstanceGroupManager.
     */
    public UnaryCallSettings.Builder<RecreateInstancesInstanceGroupManagerHttpRequest, Operation>
        recreateInstancesInstanceGroupManagerSettings() {
      return getStubSettingsBuilder().recreateInstancesInstanceGroupManagerSettings();
    }

    /** Returns the builder for the settings used for calls to resizeInstanceGroupManager. */
    public UnaryCallSettings.Builder<ResizeInstanceGroupManagerHttpRequest, Operation>
        resizeInstanceGroupManagerSettings() {
      return getStubSettingsBuilder().resizeInstanceGroupManagerSettings();
    }

    /**
     * Returns the builder for the settings used for calls to
     * setInstanceTemplateInstanceGroupManager.
     */
    public UnaryCallSettings.Builder<SetInstanceTemplateInstanceGroupManagerHttpRequest, Operation>
        setInstanceTemplateInstanceGroupManagerSettings() {
      return getStubSettingsBuilder().setInstanceTemplateInstanceGroupManagerSettings();
    }

    /**
     * Returns the builder for the settings used for calls to setTargetPoolsInstanceGroupManager.
     */
    public UnaryCallSettings.Builder<SetTargetPoolsInstanceGroupManagerHttpRequest, Operation>
        setTargetPoolsInstanceGroupManagerSettings() {
      return getStubSettingsBuilder().setTargetPoolsInstanceGroupManagerSettings();
    }

    @Override
    public InstanceGroupManagerSettings build() throws IOException {
      return new InstanceGroupManagerSettings(this);
    }
  }
}
