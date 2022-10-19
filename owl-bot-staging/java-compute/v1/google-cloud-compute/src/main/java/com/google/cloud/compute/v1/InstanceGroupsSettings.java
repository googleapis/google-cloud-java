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

import static com.google.cloud.compute.v1.InstanceGroupsClient.AggregatedListPagedResponse;
import static com.google.cloud.compute.v1.InstanceGroupsClient.ListInstancesPagedResponse;
import static com.google.cloud.compute.v1.InstanceGroupsClient.ListPagedResponse;

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
import com.google.cloud.compute.v1.stub.InstanceGroupsStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link InstanceGroupsClient}.
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
 * InstanceGroupsSettings.Builder instanceGroupsSettingsBuilder =
 *     InstanceGroupsSettings.newBuilder();
 * instanceGroupsSettingsBuilder
 *     .getSettings()
 *     .setRetrySettings(
 *         instanceGroupsSettingsBuilder.getSettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * InstanceGroupsSettings instanceGroupsSettings = instanceGroupsSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class InstanceGroupsSettings extends ClientSettings<InstanceGroupsSettings> {

  /** Returns the object with the settings used for calls to addInstances. */
  public UnaryCallSettings<AddInstancesInstanceGroupRequest, Operation> addInstancesSettings() {
    return ((InstanceGroupsStubSettings) getStubSettings()).addInstancesSettings();
  }

  /** Returns the object with the settings used for calls to addInstances. */
  public OperationCallSettings<AddInstancesInstanceGroupRequest, Operation, Operation>
      addInstancesOperationSettings() {
    return ((InstanceGroupsStubSettings) getStubSettings()).addInstancesOperationSettings();
  }

  /** Returns the object with the settings used for calls to aggregatedList. */
  public PagedCallSettings<
          AggregatedListInstanceGroupsRequest,
          InstanceGroupAggregatedList,
          AggregatedListPagedResponse>
      aggregatedListSettings() {
    return ((InstanceGroupsStubSettings) getStubSettings()).aggregatedListSettings();
  }

  /** Returns the object with the settings used for calls to delete. */
  public UnaryCallSettings<DeleteInstanceGroupRequest, Operation> deleteSettings() {
    return ((InstanceGroupsStubSettings) getStubSettings()).deleteSettings();
  }

  /** Returns the object with the settings used for calls to delete. */
  public OperationCallSettings<DeleteInstanceGroupRequest, Operation, Operation>
      deleteOperationSettings() {
    return ((InstanceGroupsStubSettings) getStubSettings()).deleteOperationSettings();
  }

  /** Returns the object with the settings used for calls to get. */
  public UnaryCallSettings<GetInstanceGroupRequest, InstanceGroup> getSettings() {
    return ((InstanceGroupsStubSettings) getStubSettings()).getSettings();
  }

  /** Returns the object with the settings used for calls to insert. */
  public UnaryCallSettings<InsertInstanceGroupRequest, Operation> insertSettings() {
    return ((InstanceGroupsStubSettings) getStubSettings()).insertSettings();
  }

  /** Returns the object with the settings used for calls to insert. */
  public OperationCallSettings<InsertInstanceGroupRequest, Operation, Operation>
      insertOperationSettings() {
    return ((InstanceGroupsStubSettings) getStubSettings()).insertOperationSettings();
  }

  /** Returns the object with the settings used for calls to list. */
  public PagedCallSettings<ListInstanceGroupsRequest, InstanceGroupList, ListPagedResponse>
      listSettings() {
    return ((InstanceGroupsStubSettings) getStubSettings()).listSettings();
  }

  /** Returns the object with the settings used for calls to listInstances. */
  public PagedCallSettings<
          ListInstancesInstanceGroupsRequest,
          InstanceGroupsListInstances,
          ListInstancesPagedResponse>
      listInstancesSettings() {
    return ((InstanceGroupsStubSettings) getStubSettings()).listInstancesSettings();
  }

  /** Returns the object with the settings used for calls to removeInstances. */
  public UnaryCallSettings<RemoveInstancesInstanceGroupRequest, Operation>
      removeInstancesSettings() {
    return ((InstanceGroupsStubSettings) getStubSettings()).removeInstancesSettings();
  }

  /** Returns the object with the settings used for calls to removeInstances. */
  public OperationCallSettings<RemoveInstancesInstanceGroupRequest, Operation, Operation>
      removeInstancesOperationSettings() {
    return ((InstanceGroupsStubSettings) getStubSettings()).removeInstancesOperationSettings();
  }

  /** Returns the object with the settings used for calls to setNamedPorts. */
  public UnaryCallSettings<SetNamedPortsInstanceGroupRequest, Operation> setNamedPortsSettings() {
    return ((InstanceGroupsStubSettings) getStubSettings()).setNamedPortsSettings();
  }

  /** Returns the object with the settings used for calls to setNamedPorts. */
  public OperationCallSettings<SetNamedPortsInstanceGroupRequest, Operation, Operation>
      setNamedPortsOperationSettings() {
    return ((InstanceGroupsStubSettings) getStubSettings()).setNamedPortsOperationSettings();
  }

  public static final InstanceGroupsSettings create(InstanceGroupsStubSettings stub)
      throws IOException {
    return new InstanceGroupsSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstanceGroupsStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return InstanceGroupsStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return InstanceGroupsStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return InstanceGroupsStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return InstanceGroupsStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return InstanceGroupsStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return InstanceGroupsStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected InstanceGroupsSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for InstanceGroupsSettings. */
  public static class Builder extends ClientSettings.Builder<InstanceGroupsSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(InstanceGroupsStubSettings.newBuilder(clientContext));
    }

    protected Builder(InstanceGroupsSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(InstanceGroupsStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(InstanceGroupsStubSettings.newBuilder());
    }

    public InstanceGroupsStubSettings.Builder getStubSettingsBuilder() {
      return ((InstanceGroupsStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to addInstances. */
    public UnaryCallSettings.Builder<AddInstancesInstanceGroupRequest, Operation>
        addInstancesSettings() {
      return getStubSettingsBuilder().addInstancesSettings();
    }

    /** Returns the builder for the settings used for calls to addInstances. */
    public OperationCallSettings.Builder<AddInstancesInstanceGroupRequest, Operation, Operation>
        addInstancesOperationSettings() {
      return getStubSettingsBuilder().addInstancesOperationSettings();
    }

    /** Returns the builder for the settings used for calls to aggregatedList. */
    public PagedCallSettings.Builder<
            AggregatedListInstanceGroupsRequest,
            InstanceGroupAggregatedList,
            AggregatedListPagedResponse>
        aggregatedListSettings() {
      return getStubSettingsBuilder().aggregatedListSettings();
    }

    /** Returns the builder for the settings used for calls to delete. */
    public UnaryCallSettings.Builder<DeleteInstanceGroupRequest, Operation> deleteSettings() {
      return getStubSettingsBuilder().deleteSettings();
    }

    /** Returns the builder for the settings used for calls to delete. */
    public OperationCallSettings.Builder<DeleteInstanceGroupRequest, Operation, Operation>
        deleteOperationSettings() {
      return getStubSettingsBuilder().deleteOperationSettings();
    }

    /** Returns the builder for the settings used for calls to get. */
    public UnaryCallSettings.Builder<GetInstanceGroupRequest, InstanceGroup> getSettings() {
      return getStubSettingsBuilder().getSettings();
    }

    /** Returns the builder for the settings used for calls to insert. */
    public UnaryCallSettings.Builder<InsertInstanceGroupRequest, Operation> insertSettings() {
      return getStubSettingsBuilder().insertSettings();
    }

    /** Returns the builder for the settings used for calls to insert. */
    public OperationCallSettings.Builder<InsertInstanceGroupRequest, Operation, Operation>
        insertOperationSettings() {
      return getStubSettingsBuilder().insertOperationSettings();
    }

    /** Returns the builder for the settings used for calls to list. */
    public PagedCallSettings.Builder<
            ListInstanceGroupsRequest, InstanceGroupList, ListPagedResponse>
        listSettings() {
      return getStubSettingsBuilder().listSettings();
    }

    /** Returns the builder for the settings used for calls to listInstances. */
    public PagedCallSettings.Builder<
            ListInstancesInstanceGroupsRequest,
            InstanceGroupsListInstances,
            ListInstancesPagedResponse>
        listInstancesSettings() {
      return getStubSettingsBuilder().listInstancesSettings();
    }

    /** Returns the builder for the settings used for calls to removeInstances. */
    public UnaryCallSettings.Builder<RemoveInstancesInstanceGroupRequest, Operation>
        removeInstancesSettings() {
      return getStubSettingsBuilder().removeInstancesSettings();
    }

    /** Returns the builder for the settings used for calls to removeInstances. */
    public OperationCallSettings.Builder<RemoveInstancesInstanceGroupRequest, Operation, Operation>
        removeInstancesOperationSettings() {
      return getStubSettingsBuilder().removeInstancesOperationSettings();
    }

    /** Returns the builder for the settings used for calls to setNamedPorts. */
    public UnaryCallSettings.Builder<SetNamedPortsInstanceGroupRequest, Operation>
        setNamedPortsSettings() {
      return getStubSettingsBuilder().setNamedPortsSettings();
    }

    /** Returns the builder for the settings used for calls to setNamedPorts. */
    public OperationCallSettings.Builder<SetNamedPortsInstanceGroupRequest, Operation, Operation>
        setNamedPortsOperationSettings() {
      return getStubSettingsBuilder().setNamedPortsOperationSettings();
    }

    @Override
    public InstanceGroupsSettings build() throws IOException {
      return new InstanceGroupsSettings(this);
    }
  }
}
