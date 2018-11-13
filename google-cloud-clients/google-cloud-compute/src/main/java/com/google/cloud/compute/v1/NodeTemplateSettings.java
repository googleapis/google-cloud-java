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

import static com.google.cloud.compute.v1.NodeTemplateClient.AggregatedListNodeTemplatesPagedResponse;
import static com.google.cloud.compute.v1.NodeTemplateClient.ListNodeTemplatesPagedResponse;

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
import com.google.cloud.compute.v1.stub.NodeTemplateStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Settings class to configure an instance of {@link NodeTemplateClient}.
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
 * example, to set the total timeout of deleteNodeTemplate to 30 seconds:
 *
 * <pre>
 * <code>
 * NodeTemplateSettings.Builder nodeTemplateSettingsBuilder =
 *     NodeTemplateSettings.newBuilder();
 * nodeTemplateSettingsBuilder.deleteNodeTemplateSettings().getRetrySettings().toBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * NodeTemplateSettings nodeTemplateSettings = nodeTemplateSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class NodeTemplateSettings extends ClientSettings<NodeTemplateSettings> {
  /** Returns the object with the settings used for calls to aggregatedListNodeTemplates. */
  public PagedCallSettings<
          AggregatedListNodeTemplatesHttpRequest,
          NodeTemplateAggregatedList,
          AggregatedListNodeTemplatesPagedResponse>
      aggregatedListNodeTemplatesSettings() {
    return ((NodeTemplateStubSettings) getStubSettings()).aggregatedListNodeTemplatesSettings();
  }

  /** Returns the object with the settings used for calls to deleteNodeTemplate. */
  public UnaryCallSettings<DeleteNodeTemplateHttpRequest, Operation> deleteNodeTemplateSettings() {
    return ((NodeTemplateStubSettings) getStubSettings()).deleteNodeTemplateSettings();
  }

  /** Returns the object with the settings used for calls to getNodeTemplate. */
  public UnaryCallSettings<GetNodeTemplateHttpRequest, NodeTemplate> getNodeTemplateSettings() {
    return ((NodeTemplateStubSettings) getStubSettings()).getNodeTemplateSettings();
  }

  /** Returns the object with the settings used for calls to insertNodeTemplate. */
  public UnaryCallSettings<InsertNodeTemplateHttpRequest, Operation> insertNodeTemplateSettings() {
    return ((NodeTemplateStubSettings) getStubSettings()).insertNodeTemplateSettings();
  }

  /** Returns the object with the settings used for calls to listNodeTemplates. */
  public PagedCallSettings<
          ListNodeTemplatesHttpRequest, NodeTemplateList, ListNodeTemplatesPagedResponse>
      listNodeTemplatesSettings() {
    return ((NodeTemplateStubSettings) getStubSettings()).listNodeTemplatesSettings();
  }

  public static final NodeTemplateSettings create(NodeTemplateStubSettings stub)
      throws IOException {
    return new NodeTemplateSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return NodeTemplateStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return NodeTemplateStubSettings.getDefaultEndpoint();
  }
  /** Returns the default service port. */
  public static int getDefaultServicePort() {
    return NodeTemplateStubSettings.getDefaultServicePort();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return NodeTemplateStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return NodeTemplateStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return NodeTemplateStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return NodeTemplateStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return NodeTemplateStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected NodeTemplateSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for NodeTemplateSettings. */
  public static class Builder extends ClientSettings.Builder<NodeTemplateSettings, Builder> {
    protected Builder() throws IOException {
      this((ClientContext) null);
    }

    protected Builder(ClientContext clientContext) {
      super(NodeTemplateStubSettings.newBuilder(clientContext));
    }

    private static Builder createDefault() {
      return new Builder(NodeTemplateStubSettings.newBuilder());
    }

    protected Builder(NodeTemplateSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(NodeTemplateStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    public NodeTemplateStubSettings.Builder getStubSettingsBuilder() {
      return ((NodeTemplateStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to aggregatedListNodeTemplates. */
    public PagedCallSettings.Builder<
            AggregatedListNodeTemplatesHttpRequest,
            NodeTemplateAggregatedList,
            AggregatedListNodeTemplatesPagedResponse>
        aggregatedListNodeTemplatesSettings() {
      return getStubSettingsBuilder().aggregatedListNodeTemplatesSettings();
    }

    /** Returns the builder for the settings used for calls to deleteNodeTemplate. */
    public UnaryCallSettings.Builder<DeleteNodeTemplateHttpRequest, Operation>
        deleteNodeTemplateSettings() {
      return getStubSettingsBuilder().deleteNodeTemplateSettings();
    }

    /** Returns the builder for the settings used for calls to getNodeTemplate. */
    public UnaryCallSettings.Builder<GetNodeTemplateHttpRequest, NodeTemplate>
        getNodeTemplateSettings() {
      return getStubSettingsBuilder().getNodeTemplateSettings();
    }

    /** Returns the builder for the settings used for calls to insertNodeTemplate. */
    public UnaryCallSettings.Builder<InsertNodeTemplateHttpRequest, Operation>
        insertNodeTemplateSettings() {
      return getStubSettingsBuilder().insertNodeTemplateSettings();
    }

    /** Returns the builder for the settings used for calls to listNodeTemplates. */
    public PagedCallSettings.Builder<
            ListNodeTemplatesHttpRequest, NodeTemplateList, ListNodeTemplatesPagedResponse>
        listNodeTemplatesSettings() {
      return getStubSettingsBuilder().listNodeTemplatesSettings();
    }

    @Override
    public NodeTemplateSettings build() throws IOException {
      return new NodeTemplateSettings(this);
    }
  }
}
