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

import static com.google.cloud.compute.v1.NodeGroupClient.AggregatedListNodeGroupsPagedResponse;
import static com.google.cloud.compute.v1.NodeGroupClient.ListNodeGroupsPagedResponse;
import static com.google.cloud.compute.v1.NodeGroupClient.ListNodesNodeGroupsPagedResponse;

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
import com.google.cloud.compute.v1.stub.NodeGroupStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Settings class to configure an instance of {@link NodeGroupClient}.
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
 * example, to set the total timeout of addNodesNodeGroup to 30 seconds:
 *
 * <pre>
 * <code>
 * NodeGroupSettings.Builder nodeGroupSettingsBuilder =
 *     NodeGroupSettings.newBuilder();
 * nodeGroupSettingsBuilder.addNodesNodeGroupSettings().getRetrySettings().toBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * NodeGroupSettings nodeGroupSettings = nodeGroupSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class NodeGroupSettings extends ClientSettings<NodeGroupSettings> {
  /** Returns the object with the settings used for calls to addNodesNodeGroup. */
  public UnaryCallSettings<AddNodesNodeGroupHttpRequest, Operation> addNodesNodeGroupSettings() {
    return ((NodeGroupStubSettings) getStubSettings()).addNodesNodeGroupSettings();
  }

  /** Returns the object with the settings used for calls to aggregatedListNodeGroups. */
  public PagedCallSettings<
          AggregatedListNodeGroupsHttpRequest,
          NodeGroupAggregatedList,
          AggregatedListNodeGroupsPagedResponse>
      aggregatedListNodeGroupsSettings() {
    return ((NodeGroupStubSettings) getStubSettings()).aggregatedListNodeGroupsSettings();
  }

  /** Returns the object with the settings used for calls to deleteNodeGroup. */
  public UnaryCallSettings<DeleteNodeGroupHttpRequest, Operation> deleteNodeGroupSettings() {
    return ((NodeGroupStubSettings) getStubSettings()).deleteNodeGroupSettings();
  }

  /** Returns the object with the settings used for calls to deleteNodesNodeGroup. */
  public UnaryCallSettings<DeleteNodesNodeGroupHttpRequest, Operation>
      deleteNodesNodeGroupSettings() {
    return ((NodeGroupStubSettings) getStubSettings()).deleteNodesNodeGroupSettings();
  }

  /** Returns the object with the settings used for calls to getNodeGroup. */
  public UnaryCallSettings<GetNodeGroupHttpRequest, NodeGroup> getNodeGroupSettings() {
    return ((NodeGroupStubSettings) getStubSettings()).getNodeGroupSettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicyNodeGroup. */
  public UnaryCallSettings<GetIamPolicyNodeGroupHttpRequest, Policy>
      getIamPolicyNodeGroupSettings() {
    return ((NodeGroupStubSettings) getStubSettings()).getIamPolicyNodeGroupSettings();
  }

  /** Returns the object with the settings used for calls to insertNodeGroup. */
  public UnaryCallSettings<InsertNodeGroupHttpRequest, Operation> insertNodeGroupSettings() {
    return ((NodeGroupStubSettings) getStubSettings()).insertNodeGroupSettings();
  }

  /** Returns the object with the settings used for calls to listNodeGroups. */
  public PagedCallSettings<ListNodeGroupsHttpRequest, NodeGroupList, ListNodeGroupsPagedResponse>
      listNodeGroupsSettings() {
    return ((NodeGroupStubSettings) getStubSettings()).listNodeGroupsSettings();
  }

  /** Returns the object with the settings used for calls to listNodesNodeGroups. */
  public PagedCallSettings<
          ListNodesNodeGroupsHttpRequest, NodeGroupsListNodes, ListNodesNodeGroupsPagedResponse>
      listNodesNodeGroupsSettings() {
    return ((NodeGroupStubSettings) getStubSettings()).listNodesNodeGroupsSettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicyNodeGroup. */
  public UnaryCallSettings<SetIamPolicyNodeGroupHttpRequest, Policy>
      setIamPolicyNodeGroupSettings() {
    return ((NodeGroupStubSettings) getStubSettings()).setIamPolicyNodeGroupSettings();
  }

  /** Returns the object with the settings used for calls to setNodeTemplateNodeGroup. */
  public UnaryCallSettings<SetNodeTemplateNodeGroupHttpRequest, Operation>
      setNodeTemplateNodeGroupSettings() {
    return ((NodeGroupStubSettings) getStubSettings()).setNodeTemplateNodeGroupSettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissionsNodeGroup. */
  public UnaryCallSettings<TestIamPermissionsNodeGroupHttpRequest, TestPermissionsResponse>
      testIamPermissionsNodeGroupSettings() {
    return ((NodeGroupStubSettings) getStubSettings()).testIamPermissionsNodeGroupSettings();
  }

  public static final NodeGroupSettings create(NodeGroupStubSettings stub) throws IOException {
    return new NodeGroupSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return NodeGroupStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return NodeGroupStubSettings.getDefaultEndpoint();
  }
  /** Returns the default service port. */
  public static int getDefaultServicePort() {
    return NodeGroupStubSettings.getDefaultServicePort();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return NodeGroupStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return NodeGroupStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return NodeGroupStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return NodeGroupStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return NodeGroupStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected NodeGroupSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for NodeGroupSettings. */
  public static class Builder extends ClientSettings.Builder<NodeGroupSettings, Builder> {
    protected Builder() throws IOException {
      this((ClientContext) null);
    }

    protected Builder(ClientContext clientContext) {
      super(NodeGroupStubSettings.newBuilder(clientContext));
    }

    private static Builder createDefault() {
      return new Builder(NodeGroupStubSettings.newBuilder());
    }

    protected Builder(NodeGroupSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(NodeGroupStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    public NodeGroupStubSettings.Builder getStubSettingsBuilder() {
      return ((NodeGroupStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to addNodesNodeGroup. */
    public UnaryCallSettings.Builder<AddNodesNodeGroupHttpRequest, Operation>
        addNodesNodeGroupSettings() {
      return getStubSettingsBuilder().addNodesNodeGroupSettings();
    }

    /** Returns the builder for the settings used for calls to aggregatedListNodeGroups. */
    public PagedCallSettings.Builder<
            AggregatedListNodeGroupsHttpRequest,
            NodeGroupAggregatedList,
            AggregatedListNodeGroupsPagedResponse>
        aggregatedListNodeGroupsSettings() {
      return getStubSettingsBuilder().aggregatedListNodeGroupsSettings();
    }

    /** Returns the builder for the settings used for calls to deleteNodeGroup. */
    public UnaryCallSettings.Builder<DeleteNodeGroupHttpRequest, Operation>
        deleteNodeGroupSettings() {
      return getStubSettingsBuilder().deleteNodeGroupSettings();
    }

    /** Returns the builder for the settings used for calls to deleteNodesNodeGroup. */
    public UnaryCallSettings.Builder<DeleteNodesNodeGroupHttpRequest, Operation>
        deleteNodesNodeGroupSettings() {
      return getStubSettingsBuilder().deleteNodesNodeGroupSettings();
    }

    /** Returns the builder for the settings used for calls to getNodeGroup. */
    public UnaryCallSettings.Builder<GetNodeGroupHttpRequest, NodeGroup> getNodeGroupSettings() {
      return getStubSettingsBuilder().getNodeGroupSettings();
    }

    /** Returns the builder for the settings used for calls to getIamPolicyNodeGroup. */
    public UnaryCallSettings.Builder<GetIamPolicyNodeGroupHttpRequest, Policy>
        getIamPolicyNodeGroupSettings() {
      return getStubSettingsBuilder().getIamPolicyNodeGroupSettings();
    }

    /** Returns the builder for the settings used for calls to insertNodeGroup. */
    public UnaryCallSettings.Builder<InsertNodeGroupHttpRequest, Operation>
        insertNodeGroupSettings() {
      return getStubSettingsBuilder().insertNodeGroupSettings();
    }

    /** Returns the builder for the settings used for calls to listNodeGroups. */
    public PagedCallSettings.Builder<
            ListNodeGroupsHttpRequest, NodeGroupList, ListNodeGroupsPagedResponse>
        listNodeGroupsSettings() {
      return getStubSettingsBuilder().listNodeGroupsSettings();
    }

    /** Returns the builder for the settings used for calls to listNodesNodeGroups. */
    public PagedCallSettings.Builder<
            ListNodesNodeGroupsHttpRequest, NodeGroupsListNodes, ListNodesNodeGroupsPagedResponse>
        listNodesNodeGroupsSettings() {
      return getStubSettingsBuilder().listNodesNodeGroupsSettings();
    }

    /** Returns the builder for the settings used for calls to setIamPolicyNodeGroup. */
    public UnaryCallSettings.Builder<SetIamPolicyNodeGroupHttpRequest, Policy>
        setIamPolicyNodeGroupSettings() {
      return getStubSettingsBuilder().setIamPolicyNodeGroupSettings();
    }

    /** Returns the builder for the settings used for calls to setNodeTemplateNodeGroup. */
    public UnaryCallSettings.Builder<SetNodeTemplateNodeGroupHttpRequest, Operation>
        setNodeTemplateNodeGroupSettings() {
      return getStubSettingsBuilder().setNodeTemplateNodeGroupSettings();
    }

    /** Returns the builder for the settings used for calls to testIamPermissionsNodeGroup. */
    public UnaryCallSettings.Builder<
            TestIamPermissionsNodeGroupHttpRequest, TestPermissionsResponse>
        testIamPermissionsNodeGroupSettings() {
      return getStubSettingsBuilder().testIamPermissionsNodeGroupSettings();
    }

    @Override
    public NodeGroupSettings build() throws IOException {
      return new NodeGroupSettings(this);
    }
  }
}
