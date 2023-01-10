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

package com.google.cloud.aiplatform.v1beta1;

import static com.google.cloud.aiplatform.v1beta1.MetadataServiceClient.ListArtifactsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.MetadataServiceClient.ListContextsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.MetadataServiceClient.ListExecutionsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.MetadataServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.MetadataServiceClient.ListMetadataSchemasPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.MetadataServiceClient.ListMetadataStoresPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.aiplatform.v1beta1.stub.MetadataServiceStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link MetadataServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (aiplatform.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getMetadataStore to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * MetadataServiceSettings.Builder metadataServiceSettingsBuilder =
 *     MetadataServiceSettings.newBuilder();
 * metadataServiceSettingsBuilder
 *     .getMetadataStoreSettings()
 *     .setRetrySettings(
 *         metadataServiceSettingsBuilder
 *             .getMetadataStoreSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * MetadataServiceSettings metadataServiceSettings = metadataServiceSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class MetadataServiceSettings extends ClientSettings<MetadataServiceSettings> {

  /** Returns the object with the settings used for calls to createMetadataStore. */
  public UnaryCallSettings<CreateMetadataStoreRequest, Operation> createMetadataStoreSettings() {
    return ((MetadataServiceStubSettings) getStubSettings()).createMetadataStoreSettings();
  }

  /** Returns the object with the settings used for calls to createMetadataStore. */
  public OperationCallSettings<
          CreateMetadataStoreRequest, MetadataStore, CreateMetadataStoreOperationMetadata>
      createMetadataStoreOperationSettings() {
    return ((MetadataServiceStubSettings) getStubSettings()).createMetadataStoreOperationSettings();
  }

  /** Returns the object with the settings used for calls to getMetadataStore. */
  public UnaryCallSettings<GetMetadataStoreRequest, MetadataStore> getMetadataStoreSettings() {
    return ((MetadataServiceStubSettings) getStubSettings()).getMetadataStoreSettings();
  }

  /** Returns the object with the settings used for calls to listMetadataStores. */
  public PagedCallSettings<
          ListMetadataStoresRequest, ListMetadataStoresResponse, ListMetadataStoresPagedResponse>
      listMetadataStoresSettings() {
    return ((MetadataServiceStubSettings) getStubSettings()).listMetadataStoresSettings();
  }

  /** Returns the object with the settings used for calls to deleteMetadataStore. */
  public UnaryCallSettings<DeleteMetadataStoreRequest, Operation> deleteMetadataStoreSettings() {
    return ((MetadataServiceStubSettings) getStubSettings()).deleteMetadataStoreSettings();
  }

  /** Returns the object with the settings used for calls to deleteMetadataStore. */
  public OperationCallSettings<
          DeleteMetadataStoreRequest, Empty, DeleteMetadataStoreOperationMetadata>
      deleteMetadataStoreOperationSettings() {
    return ((MetadataServiceStubSettings) getStubSettings()).deleteMetadataStoreOperationSettings();
  }

  /** Returns the object with the settings used for calls to createArtifact. */
  public UnaryCallSettings<CreateArtifactRequest, Artifact> createArtifactSettings() {
    return ((MetadataServiceStubSettings) getStubSettings()).createArtifactSettings();
  }

  /** Returns the object with the settings used for calls to getArtifact. */
  public UnaryCallSettings<GetArtifactRequest, Artifact> getArtifactSettings() {
    return ((MetadataServiceStubSettings) getStubSettings()).getArtifactSettings();
  }

  /** Returns the object with the settings used for calls to listArtifacts. */
  public PagedCallSettings<ListArtifactsRequest, ListArtifactsResponse, ListArtifactsPagedResponse>
      listArtifactsSettings() {
    return ((MetadataServiceStubSettings) getStubSettings()).listArtifactsSettings();
  }

  /** Returns the object with the settings used for calls to updateArtifact. */
  public UnaryCallSettings<UpdateArtifactRequest, Artifact> updateArtifactSettings() {
    return ((MetadataServiceStubSettings) getStubSettings()).updateArtifactSettings();
  }

  /** Returns the object with the settings used for calls to deleteArtifact. */
  public UnaryCallSettings<DeleteArtifactRequest, Operation> deleteArtifactSettings() {
    return ((MetadataServiceStubSettings) getStubSettings()).deleteArtifactSettings();
  }

  /** Returns the object with the settings used for calls to deleteArtifact. */
  public OperationCallSettings<DeleteArtifactRequest, Empty, DeleteOperationMetadata>
      deleteArtifactOperationSettings() {
    return ((MetadataServiceStubSettings) getStubSettings()).deleteArtifactOperationSettings();
  }

  /** Returns the object with the settings used for calls to purgeArtifacts. */
  public UnaryCallSettings<PurgeArtifactsRequest, Operation> purgeArtifactsSettings() {
    return ((MetadataServiceStubSettings) getStubSettings()).purgeArtifactsSettings();
  }

  /** Returns the object with the settings used for calls to purgeArtifacts. */
  public OperationCallSettings<
          PurgeArtifactsRequest, PurgeArtifactsResponse, PurgeArtifactsMetadata>
      purgeArtifactsOperationSettings() {
    return ((MetadataServiceStubSettings) getStubSettings()).purgeArtifactsOperationSettings();
  }

  /** Returns the object with the settings used for calls to createContext. */
  public UnaryCallSettings<CreateContextRequest, Context> createContextSettings() {
    return ((MetadataServiceStubSettings) getStubSettings()).createContextSettings();
  }

  /** Returns the object with the settings used for calls to getContext. */
  public UnaryCallSettings<GetContextRequest, Context> getContextSettings() {
    return ((MetadataServiceStubSettings) getStubSettings()).getContextSettings();
  }

  /** Returns the object with the settings used for calls to listContexts. */
  public PagedCallSettings<ListContextsRequest, ListContextsResponse, ListContextsPagedResponse>
      listContextsSettings() {
    return ((MetadataServiceStubSettings) getStubSettings()).listContextsSettings();
  }

  /** Returns the object with the settings used for calls to updateContext. */
  public UnaryCallSettings<UpdateContextRequest, Context> updateContextSettings() {
    return ((MetadataServiceStubSettings) getStubSettings()).updateContextSettings();
  }

  /** Returns the object with the settings used for calls to deleteContext. */
  public UnaryCallSettings<DeleteContextRequest, Operation> deleteContextSettings() {
    return ((MetadataServiceStubSettings) getStubSettings()).deleteContextSettings();
  }

  /** Returns the object with the settings used for calls to deleteContext. */
  public OperationCallSettings<DeleteContextRequest, Empty, DeleteOperationMetadata>
      deleteContextOperationSettings() {
    return ((MetadataServiceStubSettings) getStubSettings()).deleteContextOperationSettings();
  }

  /** Returns the object with the settings used for calls to purgeContexts. */
  public UnaryCallSettings<PurgeContextsRequest, Operation> purgeContextsSettings() {
    return ((MetadataServiceStubSettings) getStubSettings()).purgeContextsSettings();
  }

  /** Returns the object with the settings used for calls to purgeContexts. */
  public OperationCallSettings<PurgeContextsRequest, PurgeContextsResponse, PurgeContextsMetadata>
      purgeContextsOperationSettings() {
    return ((MetadataServiceStubSettings) getStubSettings()).purgeContextsOperationSettings();
  }

  /** Returns the object with the settings used for calls to addContextArtifactsAndExecutions. */
  public UnaryCallSettings<
          AddContextArtifactsAndExecutionsRequest, AddContextArtifactsAndExecutionsResponse>
      addContextArtifactsAndExecutionsSettings() {
    return ((MetadataServiceStubSettings) getStubSettings())
        .addContextArtifactsAndExecutionsSettings();
  }

  /** Returns the object with the settings used for calls to addContextChildren. */
  public UnaryCallSettings<AddContextChildrenRequest, AddContextChildrenResponse>
      addContextChildrenSettings() {
    return ((MetadataServiceStubSettings) getStubSettings()).addContextChildrenSettings();
  }

  /** Returns the object with the settings used for calls to removeContextChildren. */
  public UnaryCallSettings<RemoveContextChildrenRequest, RemoveContextChildrenResponse>
      removeContextChildrenSettings() {
    return ((MetadataServiceStubSettings) getStubSettings()).removeContextChildrenSettings();
  }

  /** Returns the object with the settings used for calls to queryContextLineageSubgraph. */
  public UnaryCallSettings<QueryContextLineageSubgraphRequest, LineageSubgraph>
      queryContextLineageSubgraphSettings() {
    return ((MetadataServiceStubSettings) getStubSettings()).queryContextLineageSubgraphSettings();
  }

  /** Returns the object with the settings used for calls to createExecution. */
  public UnaryCallSettings<CreateExecutionRequest, Execution> createExecutionSettings() {
    return ((MetadataServiceStubSettings) getStubSettings()).createExecutionSettings();
  }

  /** Returns the object with the settings used for calls to getExecution. */
  public UnaryCallSettings<GetExecutionRequest, Execution> getExecutionSettings() {
    return ((MetadataServiceStubSettings) getStubSettings()).getExecutionSettings();
  }

  /** Returns the object with the settings used for calls to listExecutions. */
  public PagedCallSettings<
          ListExecutionsRequest, ListExecutionsResponse, ListExecutionsPagedResponse>
      listExecutionsSettings() {
    return ((MetadataServiceStubSettings) getStubSettings()).listExecutionsSettings();
  }

  /** Returns the object with the settings used for calls to updateExecution. */
  public UnaryCallSettings<UpdateExecutionRequest, Execution> updateExecutionSettings() {
    return ((MetadataServiceStubSettings) getStubSettings()).updateExecutionSettings();
  }

  /** Returns the object with the settings used for calls to deleteExecution. */
  public UnaryCallSettings<DeleteExecutionRequest, Operation> deleteExecutionSettings() {
    return ((MetadataServiceStubSettings) getStubSettings()).deleteExecutionSettings();
  }

  /** Returns the object with the settings used for calls to deleteExecution. */
  public OperationCallSettings<DeleteExecutionRequest, Empty, DeleteOperationMetadata>
      deleteExecutionOperationSettings() {
    return ((MetadataServiceStubSettings) getStubSettings()).deleteExecutionOperationSettings();
  }

  /** Returns the object with the settings used for calls to purgeExecutions. */
  public UnaryCallSettings<PurgeExecutionsRequest, Operation> purgeExecutionsSettings() {
    return ((MetadataServiceStubSettings) getStubSettings()).purgeExecutionsSettings();
  }

  /** Returns the object with the settings used for calls to purgeExecutions. */
  public OperationCallSettings<
          PurgeExecutionsRequest, PurgeExecutionsResponse, PurgeExecutionsMetadata>
      purgeExecutionsOperationSettings() {
    return ((MetadataServiceStubSettings) getStubSettings()).purgeExecutionsOperationSettings();
  }

  /** Returns the object with the settings used for calls to addExecutionEvents. */
  public UnaryCallSettings<AddExecutionEventsRequest, AddExecutionEventsResponse>
      addExecutionEventsSettings() {
    return ((MetadataServiceStubSettings) getStubSettings()).addExecutionEventsSettings();
  }

  /** Returns the object with the settings used for calls to queryExecutionInputsAndOutputs. */
  public UnaryCallSettings<QueryExecutionInputsAndOutputsRequest, LineageSubgraph>
      queryExecutionInputsAndOutputsSettings() {
    return ((MetadataServiceStubSettings) getStubSettings())
        .queryExecutionInputsAndOutputsSettings();
  }

  /** Returns the object with the settings used for calls to createMetadataSchema. */
  public UnaryCallSettings<CreateMetadataSchemaRequest, MetadataSchema>
      createMetadataSchemaSettings() {
    return ((MetadataServiceStubSettings) getStubSettings()).createMetadataSchemaSettings();
  }

  /** Returns the object with the settings used for calls to getMetadataSchema. */
  public UnaryCallSettings<GetMetadataSchemaRequest, MetadataSchema> getMetadataSchemaSettings() {
    return ((MetadataServiceStubSettings) getStubSettings()).getMetadataSchemaSettings();
  }

  /** Returns the object with the settings used for calls to listMetadataSchemas. */
  public PagedCallSettings<
          ListMetadataSchemasRequest, ListMetadataSchemasResponse, ListMetadataSchemasPagedResponse>
      listMetadataSchemasSettings() {
    return ((MetadataServiceStubSettings) getStubSettings()).listMetadataSchemasSettings();
  }

  /** Returns the object with the settings used for calls to queryArtifactLineageSubgraph. */
  public UnaryCallSettings<QueryArtifactLineageSubgraphRequest, LineageSubgraph>
      queryArtifactLineageSubgraphSettings() {
    return ((MetadataServiceStubSettings) getStubSettings()).queryArtifactLineageSubgraphSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((MetadataServiceStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((MetadataServiceStubSettings) getStubSettings()).getLocationSettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return ((MetadataServiceStubSettings) getStubSettings()).setIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return ((MetadataServiceStubSettings) getStubSettings()).getIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return ((MetadataServiceStubSettings) getStubSettings()).testIamPermissionsSettings();
  }

  public static final MetadataServiceSettings create(MetadataServiceStubSettings stub)
      throws IOException {
    return new MetadataServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return MetadataServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return MetadataServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return MetadataServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return MetadataServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return MetadataServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return MetadataServiceStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return MetadataServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected MetadataServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for MetadataServiceSettings. */
  public static class Builder extends ClientSettings.Builder<MetadataServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(MetadataServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(MetadataServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(MetadataServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(MetadataServiceStubSettings.newBuilder());
    }

    public MetadataServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((MetadataServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to createMetadataStore. */
    public UnaryCallSettings.Builder<CreateMetadataStoreRequest, Operation>
        createMetadataStoreSettings() {
      return getStubSettingsBuilder().createMetadataStoreSettings();
    }

    /** Returns the builder for the settings used for calls to createMetadataStore. */
    public OperationCallSettings.Builder<
            CreateMetadataStoreRequest, MetadataStore, CreateMetadataStoreOperationMetadata>
        createMetadataStoreOperationSettings() {
      return getStubSettingsBuilder().createMetadataStoreOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getMetadataStore. */
    public UnaryCallSettings.Builder<GetMetadataStoreRequest, MetadataStore>
        getMetadataStoreSettings() {
      return getStubSettingsBuilder().getMetadataStoreSettings();
    }

    /** Returns the builder for the settings used for calls to listMetadataStores. */
    public PagedCallSettings.Builder<
            ListMetadataStoresRequest, ListMetadataStoresResponse, ListMetadataStoresPagedResponse>
        listMetadataStoresSettings() {
      return getStubSettingsBuilder().listMetadataStoresSettings();
    }

    /** Returns the builder for the settings used for calls to deleteMetadataStore. */
    public UnaryCallSettings.Builder<DeleteMetadataStoreRequest, Operation>
        deleteMetadataStoreSettings() {
      return getStubSettingsBuilder().deleteMetadataStoreSettings();
    }

    /** Returns the builder for the settings used for calls to deleteMetadataStore. */
    public OperationCallSettings.Builder<
            DeleteMetadataStoreRequest, Empty, DeleteMetadataStoreOperationMetadata>
        deleteMetadataStoreOperationSettings() {
      return getStubSettingsBuilder().deleteMetadataStoreOperationSettings();
    }

    /** Returns the builder for the settings used for calls to createArtifact. */
    public UnaryCallSettings.Builder<CreateArtifactRequest, Artifact> createArtifactSettings() {
      return getStubSettingsBuilder().createArtifactSettings();
    }

    /** Returns the builder for the settings used for calls to getArtifact. */
    public UnaryCallSettings.Builder<GetArtifactRequest, Artifact> getArtifactSettings() {
      return getStubSettingsBuilder().getArtifactSettings();
    }

    /** Returns the builder for the settings used for calls to listArtifacts. */
    public PagedCallSettings.Builder<
            ListArtifactsRequest, ListArtifactsResponse, ListArtifactsPagedResponse>
        listArtifactsSettings() {
      return getStubSettingsBuilder().listArtifactsSettings();
    }

    /** Returns the builder for the settings used for calls to updateArtifact. */
    public UnaryCallSettings.Builder<UpdateArtifactRequest, Artifact> updateArtifactSettings() {
      return getStubSettingsBuilder().updateArtifactSettings();
    }

    /** Returns the builder for the settings used for calls to deleteArtifact. */
    public UnaryCallSettings.Builder<DeleteArtifactRequest, Operation> deleteArtifactSettings() {
      return getStubSettingsBuilder().deleteArtifactSettings();
    }

    /** Returns the builder for the settings used for calls to deleteArtifact. */
    public OperationCallSettings.Builder<DeleteArtifactRequest, Empty, DeleteOperationMetadata>
        deleteArtifactOperationSettings() {
      return getStubSettingsBuilder().deleteArtifactOperationSettings();
    }

    /** Returns the builder for the settings used for calls to purgeArtifacts. */
    public UnaryCallSettings.Builder<PurgeArtifactsRequest, Operation> purgeArtifactsSettings() {
      return getStubSettingsBuilder().purgeArtifactsSettings();
    }

    /** Returns the builder for the settings used for calls to purgeArtifacts. */
    public OperationCallSettings.Builder<
            PurgeArtifactsRequest, PurgeArtifactsResponse, PurgeArtifactsMetadata>
        purgeArtifactsOperationSettings() {
      return getStubSettingsBuilder().purgeArtifactsOperationSettings();
    }

    /** Returns the builder for the settings used for calls to createContext. */
    public UnaryCallSettings.Builder<CreateContextRequest, Context> createContextSettings() {
      return getStubSettingsBuilder().createContextSettings();
    }

    /** Returns the builder for the settings used for calls to getContext. */
    public UnaryCallSettings.Builder<GetContextRequest, Context> getContextSettings() {
      return getStubSettingsBuilder().getContextSettings();
    }

    /** Returns the builder for the settings used for calls to listContexts. */
    public PagedCallSettings.Builder<
            ListContextsRequest, ListContextsResponse, ListContextsPagedResponse>
        listContextsSettings() {
      return getStubSettingsBuilder().listContextsSettings();
    }

    /** Returns the builder for the settings used for calls to updateContext. */
    public UnaryCallSettings.Builder<UpdateContextRequest, Context> updateContextSettings() {
      return getStubSettingsBuilder().updateContextSettings();
    }

    /** Returns the builder for the settings used for calls to deleteContext. */
    public UnaryCallSettings.Builder<DeleteContextRequest, Operation> deleteContextSettings() {
      return getStubSettingsBuilder().deleteContextSettings();
    }

    /** Returns the builder for the settings used for calls to deleteContext. */
    public OperationCallSettings.Builder<DeleteContextRequest, Empty, DeleteOperationMetadata>
        deleteContextOperationSettings() {
      return getStubSettingsBuilder().deleteContextOperationSettings();
    }

    /** Returns the builder for the settings used for calls to purgeContexts. */
    public UnaryCallSettings.Builder<PurgeContextsRequest, Operation> purgeContextsSettings() {
      return getStubSettingsBuilder().purgeContextsSettings();
    }

    /** Returns the builder for the settings used for calls to purgeContexts. */
    public OperationCallSettings.Builder<
            PurgeContextsRequest, PurgeContextsResponse, PurgeContextsMetadata>
        purgeContextsOperationSettings() {
      return getStubSettingsBuilder().purgeContextsOperationSettings();
    }

    /** Returns the builder for the settings used for calls to addContextArtifactsAndExecutions. */
    public UnaryCallSettings.Builder<
            AddContextArtifactsAndExecutionsRequest, AddContextArtifactsAndExecutionsResponse>
        addContextArtifactsAndExecutionsSettings() {
      return getStubSettingsBuilder().addContextArtifactsAndExecutionsSettings();
    }

    /** Returns the builder for the settings used for calls to addContextChildren. */
    public UnaryCallSettings.Builder<AddContextChildrenRequest, AddContextChildrenResponse>
        addContextChildrenSettings() {
      return getStubSettingsBuilder().addContextChildrenSettings();
    }

    /** Returns the builder for the settings used for calls to removeContextChildren. */
    public UnaryCallSettings.Builder<RemoveContextChildrenRequest, RemoveContextChildrenResponse>
        removeContextChildrenSettings() {
      return getStubSettingsBuilder().removeContextChildrenSettings();
    }

    /** Returns the builder for the settings used for calls to queryContextLineageSubgraph. */
    public UnaryCallSettings.Builder<QueryContextLineageSubgraphRequest, LineageSubgraph>
        queryContextLineageSubgraphSettings() {
      return getStubSettingsBuilder().queryContextLineageSubgraphSettings();
    }

    /** Returns the builder for the settings used for calls to createExecution. */
    public UnaryCallSettings.Builder<CreateExecutionRequest, Execution> createExecutionSettings() {
      return getStubSettingsBuilder().createExecutionSettings();
    }

    /** Returns the builder for the settings used for calls to getExecution. */
    public UnaryCallSettings.Builder<GetExecutionRequest, Execution> getExecutionSettings() {
      return getStubSettingsBuilder().getExecutionSettings();
    }

    /** Returns the builder for the settings used for calls to listExecutions. */
    public PagedCallSettings.Builder<
            ListExecutionsRequest, ListExecutionsResponse, ListExecutionsPagedResponse>
        listExecutionsSettings() {
      return getStubSettingsBuilder().listExecutionsSettings();
    }

    /** Returns the builder for the settings used for calls to updateExecution. */
    public UnaryCallSettings.Builder<UpdateExecutionRequest, Execution> updateExecutionSettings() {
      return getStubSettingsBuilder().updateExecutionSettings();
    }

    /** Returns the builder for the settings used for calls to deleteExecution. */
    public UnaryCallSettings.Builder<DeleteExecutionRequest, Operation> deleteExecutionSettings() {
      return getStubSettingsBuilder().deleteExecutionSettings();
    }

    /** Returns the builder for the settings used for calls to deleteExecution. */
    public OperationCallSettings.Builder<DeleteExecutionRequest, Empty, DeleteOperationMetadata>
        deleteExecutionOperationSettings() {
      return getStubSettingsBuilder().deleteExecutionOperationSettings();
    }

    /** Returns the builder for the settings used for calls to purgeExecutions. */
    public UnaryCallSettings.Builder<PurgeExecutionsRequest, Operation> purgeExecutionsSettings() {
      return getStubSettingsBuilder().purgeExecutionsSettings();
    }

    /** Returns the builder for the settings used for calls to purgeExecutions. */
    public OperationCallSettings.Builder<
            PurgeExecutionsRequest, PurgeExecutionsResponse, PurgeExecutionsMetadata>
        purgeExecutionsOperationSettings() {
      return getStubSettingsBuilder().purgeExecutionsOperationSettings();
    }

    /** Returns the builder for the settings used for calls to addExecutionEvents. */
    public UnaryCallSettings.Builder<AddExecutionEventsRequest, AddExecutionEventsResponse>
        addExecutionEventsSettings() {
      return getStubSettingsBuilder().addExecutionEventsSettings();
    }

    /** Returns the builder for the settings used for calls to queryExecutionInputsAndOutputs. */
    public UnaryCallSettings.Builder<QueryExecutionInputsAndOutputsRequest, LineageSubgraph>
        queryExecutionInputsAndOutputsSettings() {
      return getStubSettingsBuilder().queryExecutionInputsAndOutputsSettings();
    }

    /** Returns the builder for the settings used for calls to createMetadataSchema. */
    public UnaryCallSettings.Builder<CreateMetadataSchemaRequest, MetadataSchema>
        createMetadataSchemaSettings() {
      return getStubSettingsBuilder().createMetadataSchemaSettings();
    }

    /** Returns the builder for the settings used for calls to getMetadataSchema. */
    public UnaryCallSettings.Builder<GetMetadataSchemaRequest, MetadataSchema>
        getMetadataSchemaSettings() {
      return getStubSettingsBuilder().getMetadataSchemaSettings();
    }

    /** Returns the builder for the settings used for calls to listMetadataSchemas. */
    public PagedCallSettings.Builder<
            ListMetadataSchemasRequest,
            ListMetadataSchemasResponse,
            ListMetadataSchemasPagedResponse>
        listMetadataSchemasSettings() {
      return getStubSettingsBuilder().listMetadataSchemasSettings();
    }

    /** Returns the builder for the settings used for calls to queryArtifactLineageSubgraph. */
    public UnaryCallSettings.Builder<QueryArtifactLineageSubgraphRequest, LineageSubgraph>
        queryArtifactLineageSubgraphSettings() {
      return getStubSettingsBuilder().queryArtifactLineageSubgraphSettings();
    }

    /** Returns the builder for the settings used for calls to listLocations. */
    public PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings() {
      return getStubSettingsBuilder().listLocationsSettings();
    }

    /** Returns the builder for the settings used for calls to getLocation. */
    public UnaryCallSettings.Builder<GetLocationRequest, Location> getLocationSettings() {
      return getStubSettingsBuilder().getLocationSettings();
    }

    /** Returns the builder for the settings used for calls to setIamPolicy. */
    public UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings() {
      return getStubSettingsBuilder().setIamPolicySettings();
    }

    /** Returns the builder for the settings used for calls to getIamPolicy. */
    public UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings() {
      return getStubSettingsBuilder().getIamPolicySettings();
    }

    /** Returns the builder for the settings used for calls to testIamPermissions. */
    public UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings() {
      return getStubSettingsBuilder().testIamPermissionsSettings();
    }

    @Override
    public MetadataServiceSettings build() throws IOException {
      return new MetadataServiceSettings(this);
    }
  }
}
