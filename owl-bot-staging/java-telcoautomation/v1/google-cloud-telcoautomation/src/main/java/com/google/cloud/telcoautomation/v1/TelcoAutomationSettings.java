/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.telcoautomation.v1;

import static com.google.cloud.telcoautomation.v1.TelcoAutomationClient.ListBlueprintRevisionsPagedResponse;
import static com.google.cloud.telcoautomation.v1.TelcoAutomationClient.ListBlueprintsPagedResponse;
import static com.google.cloud.telcoautomation.v1.TelcoAutomationClient.ListDeploymentRevisionsPagedResponse;
import static com.google.cloud.telcoautomation.v1.TelcoAutomationClient.ListDeploymentsPagedResponse;
import static com.google.cloud.telcoautomation.v1.TelcoAutomationClient.ListEdgeSlmsPagedResponse;
import static com.google.cloud.telcoautomation.v1.TelcoAutomationClient.ListHydratedDeploymentsPagedResponse;
import static com.google.cloud.telcoautomation.v1.TelcoAutomationClient.ListLocationsPagedResponse;
import static com.google.cloud.telcoautomation.v1.TelcoAutomationClient.ListOrchestrationClustersPagedResponse;
import static com.google.cloud.telcoautomation.v1.TelcoAutomationClient.ListPublicBlueprintsPagedResponse;
import static com.google.cloud.telcoautomation.v1.TelcoAutomationClient.SearchBlueprintRevisionsPagedResponse;
import static com.google.cloud.telcoautomation.v1.TelcoAutomationClient.SearchDeploymentRevisionsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.telcoautomation.v1.stub.TelcoAutomationStubSettings;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link TelcoAutomationClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (telcoautomation.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getOrchestrationCluster to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * TelcoAutomationSettings.Builder telcoAutomationSettingsBuilder =
 *     TelcoAutomationSettings.newBuilder();
 * telcoAutomationSettingsBuilder
 *     .getOrchestrationClusterSettings()
 *     .setRetrySettings(
 *         telcoAutomationSettingsBuilder
 *             .getOrchestrationClusterSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * TelcoAutomationSettings telcoAutomationSettings = telcoAutomationSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class TelcoAutomationSettings extends ClientSettings<TelcoAutomationSettings> {

  /** Returns the object with the settings used for calls to listOrchestrationClusters. */
  public PagedCallSettings<
          ListOrchestrationClustersRequest,
          ListOrchestrationClustersResponse,
          ListOrchestrationClustersPagedResponse>
      listOrchestrationClustersSettings() {
    return ((TelcoAutomationStubSettings) getStubSettings()).listOrchestrationClustersSettings();
  }

  /** Returns the object with the settings used for calls to getOrchestrationCluster. */
  public UnaryCallSettings<GetOrchestrationClusterRequest, OrchestrationCluster>
      getOrchestrationClusterSettings() {
    return ((TelcoAutomationStubSettings) getStubSettings()).getOrchestrationClusterSettings();
  }

  /** Returns the object with the settings used for calls to createOrchestrationCluster. */
  public UnaryCallSettings<CreateOrchestrationClusterRequest, Operation>
      createOrchestrationClusterSettings() {
    return ((TelcoAutomationStubSettings) getStubSettings()).createOrchestrationClusterSettings();
  }

  /** Returns the object with the settings used for calls to createOrchestrationCluster. */
  public OperationCallSettings<
          CreateOrchestrationClusterRequest, OrchestrationCluster, OperationMetadata>
      createOrchestrationClusterOperationSettings() {
    return ((TelcoAutomationStubSettings) getStubSettings())
        .createOrchestrationClusterOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteOrchestrationCluster. */
  public UnaryCallSettings<DeleteOrchestrationClusterRequest, Operation>
      deleteOrchestrationClusterSettings() {
    return ((TelcoAutomationStubSettings) getStubSettings()).deleteOrchestrationClusterSettings();
  }

  /** Returns the object with the settings used for calls to deleteOrchestrationCluster. */
  public OperationCallSettings<DeleteOrchestrationClusterRequest, Empty, OperationMetadata>
      deleteOrchestrationClusterOperationSettings() {
    return ((TelcoAutomationStubSettings) getStubSettings())
        .deleteOrchestrationClusterOperationSettings();
  }

  /** Returns the object with the settings used for calls to listEdgeSlms. */
  public PagedCallSettings<ListEdgeSlmsRequest, ListEdgeSlmsResponse, ListEdgeSlmsPagedResponse>
      listEdgeSlmsSettings() {
    return ((TelcoAutomationStubSettings) getStubSettings()).listEdgeSlmsSettings();
  }

  /** Returns the object with the settings used for calls to getEdgeSlm. */
  public UnaryCallSettings<GetEdgeSlmRequest, EdgeSlm> getEdgeSlmSettings() {
    return ((TelcoAutomationStubSettings) getStubSettings()).getEdgeSlmSettings();
  }

  /** Returns the object with the settings used for calls to createEdgeSlm. */
  public UnaryCallSettings<CreateEdgeSlmRequest, Operation> createEdgeSlmSettings() {
    return ((TelcoAutomationStubSettings) getStubSettings()).createEdgeSlmSettings();
  }

  /** Returns the object with the settings used for calls to createEdgeSlm. */
  public OperationCallSettings<CreateEdgeSlmRequest, EdgeSlm, OperationMetadata>
      createEdgeSlmOperationSettings() {
    return ((TelcoAutomationStubSettings) getStubSettings()).createEdgeSlmOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteEdgeSlm. */
  public UnaryCallSettings<DeleteEdgeSlmRequest, Operation> deleteEdgeSlmSettings() {
    return ((TelcoAutomationStubSettings) getStubSettings()).deleteEdgeSlmSettings();
  }

  /** Returns the object with the settings used for calls to deleteEdgeSlm. */
  public OperationCallSettings<DeleteEdgeSlmRequest, Empty, OperationMetadata>
      deleteEdgeSlmOperationSettings() {
    return ((TelcoAutomationStubSettings) getStubSettings()).deleteEdgeSlmOperationSettings();
  }

  /** Returns the object with the settings used for calls to createBlueprint. */
  public UnaryCallSettings<CreateBlueprintRequest, Blueprint> createBlueprintSettings() {
    return ((TelcoAutomationStubSettings) getStubSettings()).createBlueprintSettings();
  }

  /** Returns the object with the settings used for calls to updateBlueprint. */
  public UnaryCallSettings<UpdateBlueprintRequest, Blueprint> updateBlueprintSettings() {
    return ((TelcoAutomationStubSettings) getStubSettings()).updateBlueprintSettings();
  }

  /** Returns the object with the settings used for calls to getBlueprint. */
  public UnaryCallSettings<GetBlueprintRequest, Blueprint> getBlueprintSettings() {
    return ((TelcoAutomationStubSettings) getStubSettings()).getBlueprintSettings();
  }

  /** Returns the object with the settings used for calls to deleteBlueprint. */
  public UnaryCallSettings<DeleteBlueprintRequest, Empty> deleteBlueprintSettings() {
    return ((TelcoAutomationStubSettings) getStubSettings()).deleteBlueprintSettings();
  }

  /** Returns the object with the settings used for calls to listBlueprints. */
  public PagedCallSettings<
          ListBlueprintsRequest, ListBlueprintsResponse, ListBlueprintsPagedResponse>
      listBlueprintsSettings() {
    return ((TelcoAutomationStubSettings) getStubSettings()).listBlueprintsSettings();
  }

  /** Returns the object with the settings used for calls to approveBlueprint. */
  public UnaryCallSettings<ApproveBlueprintRequest, Blueprint> approveBlueprintSettings() {
    return ((TelcoAutomationStubSettings) getStubSettings()).approveBlueprintSettings();
  }

  /** Returns the object with the settings used for calls to proposeBlueprint. */
  public UnaryCallSettings<ProposeBlueprintRequest, Blueprint> proposeBlueprintSettings() {
    return ((TelcoAutomationStubSettings) getStubSettings()).proposeBlueprintSettings();
  }

  /** Returns the object with the settings used for calls to rejectBlueprint. */
  public UnaryCallSettings<RejectBlueprintRequest, Blueprint> rejectBlueprintSettings() {
    return ((TelcoAutomationStubSettings) getStubSettings()).rejectBlueprintSettings();
  }

  /** Returns the object with the settings used for calls to listBlueprintRevisions. */
  public PagedCallSettings<
          ListBlueprintRevisionsRequest,
          ListBlueprintRevisionsResponse,
          ListBlueprintRevisionsPagedResponse>
      listBlueprintRevisionsSettings() {
    return ((TelcoAutomationStubSettings) getStubSettings()).listBlueprintRevisionsSettings();
  }

  /** Returns the object with the settings used for calls to searchBlueprintRevisions. */
  public PagedCallSettings<
          SearchBlueprintRevisionsRequest,
          SearchBlueprintRevisionsResponse,
          SearchBlueprintRevisionsPagedResponse>
      searchBlueprintRevisionsSettings() {
    return ((TelcoAutomationStubSettings) getStubSettings()).searchBlueprintRevisionsSettings();
  }

  /** Returns the object with the settings used for calls to searchDeploymentRevisions. */
  public PagedCallSettings<
          SearchDeploymentRevisionsRequest,
          SearchDeploymentRevisionsResponse,
          SearchDeploymentRevisionsPagedResponse>
      searchDeploymentRevisionsSettings() {
    return ((TelcoAutomationStubSettings) getStubSettings()).searchDeploymentRevisionsSettings();
  }

  /** Returns the object with the settings used for calls to discardBlueprintChanges. */
  public UnaryCallSettings<DiscardBlueprintChangesRequest, DiscardBlueprintChangesResponse>
      discardBlueprintChangesSettings() {
    return ((TelcoAutomationStubSettings) getStubSettings()).discardBlueprintChangesSettings();
  }

  /** Returns the object with the settings used for calls to listPublicBlueprints. */
  public PagedCallSettings<
          ListPublicBlueprintsRequest,
          ListPublicBlueprintsResponse,
          ListPublicBlueprintsPagedResponse>
      listPublicBlueprintsSettings() {
    return ((TelcoAutomationStubSettings) getStubSettings()).listPublicBlueprintsSettings();
  }

  /** Returns the object with the settings used for calls to getPublicBlueprint. */
  public UnaryCallSettings<GetPublicBlueprintRequest, PublicBlueprint>
      getPublicBlueprintSettings() {
    return ((TelcoAutomationStubSettings) getStubSettings()).getPublicBlueprintSettings();
  }

  /** Returns the object with the settings used for calls to createDeployment. */
  public UnaryCallSettings<CreateDeploymentRequest, Deployment> createDeploymentSettings() {
    return ((TelcoAutomationStubSettings) getStubSettings()).createDeploymentSettings();
  }

  /** Returns the object with the settings used for calls to updateDeployment. */
  public UnaryCallSettings<UpdateDeploymentRequest, Deployment> updateDeploymentSettings() {
    return ((TelcoAutomationStubSettings) getStubSettings()).updateDeploymentSettings();
  }

  /** Returns the object with the settings used for calls to getDeployment. */
  public UnaryCallSettings<GetDeploymentRequest, Deployment> getDeploymentSettings() {
    return ((TelcoAutomationStubSettings) getStubSettings()).getDeploymentSettings();
  }

  /** Returns the object with the settings used for calls to removeDeployment. */
  public UnaryCallSettings<RemoveDeploymentRequest, Empty> removeDeploymentSettings() {
    return ((TelcoAutomationStubSettings) getStubSettings()).removeDeploymentSettings();
  }

  /** Returns the object with the settings used for calls to listDeployments. */
  public PagedCallSettings<
          ListDeploymentsRequest, ListDeploymentsResponse, ListDeploymentsPagedResponse>
      listDeploymentsSettings() {
    return ((TelcoAutomationStubSettings) getStubSettings()).listDeploymentsSettings();
  }

  /** Returns the object with the settings used for calls to listDeploymentRevisions. */
  public PagedCallSettings<
          ListDeploymentRevisionsRequest,
          ListDeploymentRevisionsResponse,
          ListDeploymentRevisionsPagedResponse>
      listDeploymentRevisionsSettings() {
    return ((TelcoAutomationStubSettings) getStubSettings()).listDeploymentRevisionsSettings();
  }

  /** Returns the object with the settings used for calls to discardDeploymentChanges. */
  public UnaryCallSettings<DiscardDeploymentChangesRequest, DiscardDeploymentChangesResponse>
      discardDeploymentChangesSettings() {
    return ((TelcoAutomationStubSettings) getStubSettings()).discardDeploymentChangesSettings();
  }

  /** Returns the object with the settings used for calls to applyDeployment. */
  public UnaryCallSettings<ApplyDeploymentRequest, Deployment> applyDeploymentSettings() {
    return ((TelcoAutomationStubSettings) getStubSettings()).applyDeploymentSettings();
  }

  /** Returns the object with the settings used for calls to computeDeploymentStatus. */
  public UnaryCallSettings<ComputeDeploymentStatusRequest, ComputeDeploymentStatusResponse>
      computeDeploymentStatusSettings() {
    return ((TelcoAutomationStubSettings) getStubSettings()).computeDeploymentStatusSettings();
  }

  /** Returns the object with the settings used for calls to rollbackDeployment. */
  public UnaryCallSettings<RollbackDeploymentRequest, Deployment> rollbackDeploymentSettings() {
    return ((TelcoAutomationStubSettings) getStubSettings()).rollbackDeploymentSettings();
  }

  /** Returns the object with the settings used for calls to getHydratedDeployment. */
  public UnaryCallSettings<GetHydratedDeploymentRequest, HydratedDeployment>
      getHydratedDeploymentSettings() {
    return ((TelcoAutomationStubSettings) getStubSettings()).getHydratedDeploymentSettings();
  }

  /** Returns the object with the settings used for calls to listHydratedDeployments. */
  public PagedCallSettings<
          ListHydratedDeploymentsRequest,
          ListHydratedDeploymentsResponse,
          ListHydratedDeploymentsPagedResponse>
      listHydratedDeploymentsSettings() {
    return ((TelcoAutomationStubSettings) getStubSettings()).listHydratedDeploymentsSettings();
  }

  /** Returns the object with the settings used for calls to updateHydratedDeployment. */
  public UnaryCallSettings<UpdateHydratedDeploymentRequest, HydratedDeployment>
      updateHydratedDeploymentSettings() {
    return ((TelcoAutomationStubSettings) getStubSettings()).updateHydratedDeploymentSettings();
  }

  /** Returns the object with the settings used for calls to applyHydratedDeployment. */
  public UnaryCallSettings<ApplyHydratedDeploymentRequest, HydratedDeployment>
      applyHydratedDeploymentSettings() {
    return ((TelcoAutomationStubSettings) getStubSettings()).applyHydratedDeploymentSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((TelcoAutomationStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((TelcoAutomationStubSettings) getStubSettings()).getLocationSettings();
  }

  public static final TelcoAutomationSettings create(TelcoAutomationStubSettings stub)
      throws IOException {
    return new TelcoAutomationSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return TelcoAutomationStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return TelcoAutomationStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return TelcoAutomationStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return TelcoAutomationStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return TelcoAutomationStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return TelcoAutomationStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return TelcoAutomationStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return TelcoAutomationStubSettings.defaultApiClientHeaderProviderBuilder();
  }

  /** Returns a new gRPC builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new REST builder for this class. */
  @BetaApi
  public static Builder newHttpJsonBuilder() {
    return Builder.createHttpJsonDefault();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder(ClientContext clientContext) {
    return new Builder(clientContext);
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  protected TelcoAutomationSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for TelcoAutomationSettings. */
  public static class Builder extends ClientSettings.Builder<TelcoAutomationSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(TelcoAutomationStubSettings.newBuilder(clientContext));
    }

    protected Builder(TelcoAutomationSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(TelcoAutomationStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(TelcoAutomationStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(TelcoAutomationStubSettings.newHttpJsonBuilder());
    }

    public TelcoAutomationStubSettings.Builder getStubSettingsBuilder() {
      return ((TelcoAutomationStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to listOrchestrationClusters. */
    public PagedCallSettings.Builder<
            ListOrchestrationClustersRequest,
            ListOrchestrationClustersResponse,
            ListOrchestrationClustersPagedResponse>
        listOrchestrationClustersSettings() {
      return getStubSettingsBuilder().listOrchestrationClustersSettings();
    }

    /** Returns the builder for the settings used for calls to getOrchestrationCluster. */
    public UnaryCallSettings.Builder<GetOrchestrationClusterRequest, OrchestrationCluster>
        getOrchestrationClusterSettings() {
      return getStubSettingsBuilder().getOrchestrationClusterSettings();
    }

    /** Returns the builder for the settings used for calls to createOrchestrationCluster. */
    public UnaryCallSettings.Builder<CreateOrchestrationClusterRequest, Operation>
        createOrchestrationClusterSettings() {
      return getStubSettingsBuilder().createOrchestrationClusterSettings();
    }

    /** Returns the builder for the settings used for calls to createOrchestrationCluster. */
    public OperationCallSettings.Builder<
            CreateOrchestrationClusterRequest, OrchestrationCluster, OperationMetadata>
        createOrchestrationClusterOperationSettings() {
      return getStubSettingsBuilder().createOrchestrationClusterOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteOrchestrationCluster. */
    public UnaryCallSettings.Builder<DeleteOrchestrationClusterRequest, Operation>
        deleteOrchestrationClusterSettings() {
      return getStubSettingsBuilder().deleteOrchestrationClusterSettings();
    }

    /** Returns the builder for the settings used for calls to deleteOrchestrationCluster. */
    public OperationCallSettings.Builder<
            DeleteOrchestrationClusterRequest, Empty, OperationMetadata>
        deleteOrchestrationClusterOperationSettings() {
      return getStubSettingsBuilder().deleteOrchestrationClusterOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listEdgeSlms. */
    public PagedCallSettings.Builder<
            ListEdgeSlmsRequest, ListEdgeSlmsResponse, ListEdgeSlmsPagedResponse>
        listEdgeSlmsSettings() {
      return getStubSettingsBuilder().listEdgeSlmsSettings();
    }

    /** Returns the builder for the settings used for calls to getEdgeSlm. */
    public UnaryCallSettings.Builder<GetEdgeSlmRequest, EdgeSlm> getEdgeSlmSettings() {
      return getStubSettingsBuilder().getEdgeSlmSettings();
    }

    /** Returns the builder for the settings used for calls to createEdgeSlm. */
    public UnaryCallSettings.Builder<CreateEdgeSlmRequest, Operation> createEdgeSlmSettings() {
      return getStubSettingsBuilder().createEdgeSlmSettings();
    }

    /** Returns the builder for the settings used for calls to createEdgeSlm. */
    public OperationCallSettings.Builder<CreateEdgeSlmRequest, EdgeSlm, OperationMetadata>
        createEdgeSlmOperationSettings() {
      return getStubSettingsBuilder().createEdgeSlmOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteEdgeSlm. */
    public UnaryCallSettings.Builder<DeleteEdgeSlmRequest, Operation> deleteEdgeSlmSettings() {
      return getStubSettingsBuilder().deleteEdgeSlmSettings();
    }

    /** Returns the builder for the settings used for calls to deleteEdgeSlm. */
    public OperationCallSettings.Builder<DeleteEdgeSlmRequest, Empty, OperationMetadata>
        deleteEdgeSlmOperationSettings() {
      return getStubSettingsBuilder().deleteEdgeSlmOperationSettings();
    }

    /** Returns the builder for the settings used for calls to createBlueprint. */
    public UnaryCallSettings.Builder<CreateBlueprintRequest, Blueprint> createBlueprintSettings() {
      return getStubSettingsBuilder().createBlueprintSettings();
    }

    /** Returns the builder for the settings used for calls to updateBlueprint. */
    public UnaryCallSettings.Builder<UpdateBlueprintRequest, Blueprint> updateBlueprintSettings() {
      return getStubSettingsBuilder().updateBlueprintSettings();
    }

    /** Returns the builder for the settings used for calls to getBlueprint. */
    public UnaryCallSettings.Builder<GetBlueprintRequest, Blueprint> getBlueprintSettings() {
      return getStubSettingsBuilder().getBlueprintSettings();
    }

    /** Returns the builder for the settings used for calls to deleteBlueprint. */
    public UnaryCallSettings.Builder<DeleteBlueprintRequest, Empty> deleteBlueprintSettings() {
      return getStubSettingsBuilder().deleteBlueprintSettings();
    }

    /** Returns the builder for the settings used for calls to listBlueprints. */
    public PagedCallSettings.Builder<
            ListBlueprintsRequest, ListBlueprintsResponse, ListBlueprintsPagedResponse>
        listBlueprintsSettings() {
      return getStubSettingsBuilder().listBlueprintsSettings();
    }

    /** Returns the builder for the settings used for calls to approveBlueprint. */
    public UnaryCallSettings.Builder<ApproveBlueprintRequest, Blueprint>
        approveBlueprintSettings() {
      return getStubSettingsBuilder().approveBlueprintSettings();
    }

    /** Returns the builder for the settings used for calls to proposeBlueprint. */
    public UnaryCallSettings.Builder<ProposeBlueprintRequest, Blueprint>
        proposeBlueprintSettings() {
      return getStubSettingsBuilder().proposeBlueprintSettings();
    }

    /** Returns the builder for the settings used for calls to rejectBlueprint. */
    public UnaryCallSettings.Builder<RejectBlueprintRequest, Blueprint> rejectBlueprintSettings() {
      return getStubSettingsBuilder().rejectBlueprintSettings();
    }

    /** Returns the builder for the settings used for calls to listBlueprintRevisions. */
    public PagedCallSettings.Builder<
            ListBlueprintRevisionsRequest,
            ListBlueprintRevisionsResponse,
            ListBlueprintRevisionsPagedResponse>
        listBlueprintRevisionsSettings() {
      return getStubSettingsBuilder().listBlueprintRevisionsSettings();
    }

    /** Returns the builder for the settings used for calls to searchBlueprintRevisions. */
    public PagedCallSettings.Builder<
            SearchBlueprintRevisionsRequest,
            SearchBlueprintRevisionsResponse,
            SearchBlueprintRevisionsPagedResponse>
        searchBlueprintRevisionsSettings() {
      return getStubSettingsBuilder().searchBlueprintRevisionsSettings();
    }

    /** Returns the builder for the settings used for calls to searchDeploymentRevisions. */
    public PagedCallSettings.Builder<
            SearchDeploymentRevisionsRequest,
            SearchDeploymentRevisionsResponse,
            SearchDeploymentRevisionsPagedResponse>
        searchDeploymentRevisionsSettings() {
      return getStubSettingsBuilder().searchDeploymentRevisionsSettings();
    }

    /** Returns the builder for the settings used for calls to discardBlueprintChanges. */
    public UnaryCallSettings.Builder<
            DiscardBlueprintChangesRequest, DiscardBlueprintChangesResponse>
        discardBlueprintChangesSettings() {
      return getStubSettingsBuilder().discardBlueprintChangesSettings();
    }

    /** Returns the builder for the settings used for calls to listPublicBlueprints. */
    public PagedCallSettings.Builder<
            ListPublicBlueprintsRequest,
            ListPublicBlueprintsResponse,
            ListPublicBlueprintsPagedResponse>
        listPublicBlueprintsSettings() {
      return getStubSettingsBuilder().listPublicBlueprintsSettings();
    }

    /** Returns the builder for the settings used for calls to getPublicBlueprint. */
    public UnaryCallSettings.Builder<GetPublicBlueprintRequest, PublicBlueprint>
        getPublicBlueprintSettings() {
      return getStubSettingsBuilder().getPublicBlueprintSettings();
    }

    /** Returns the builder for the settings used for calls to createDeployment. */
    public UnaryCallSettings.Builder<CreateDeploymentRequest, Deployment>
        createDeploymentSettings() {
      return getStubSettingsBuilder().createDeploymentSettings();
    }

    /** Returns the builder for the settings used for calls to updateDeployment. */
    public UnaryCallSettings.Builder<UpdateDeploymentRequest, Deployment>
        updateDeploymentSettings() {
      return getStubSettingsBuilder().updateDeploymentSettings();
    }

    /** Returns the builder for the settings used for calls to getDeployment. */
    public UnaryCallSettings.Builder<GetDeploymentRequest, Deployment> getDeploymentSettings() {
      return getStubSettingsBuilder().getDeploymentSettings();
    }

    /** Returns the builder for the settings used for calls to removeDeployment. */
    public UnaryCallSettings.Builder<RemoveDeploymentRequest, Empty> removeDeploymentSettings() {
      return getStubSettingsBuilder().removeDeploymentSettings();
    }

    /** Returns the builder for the settings used for calls to listDeployments. */
    public PagedCallSettings.Builder<
            ListDeploymentsRequest, ListDeploymentsResponse, ListDeploymentsPagedResponse>
        listDeploymentsSettings() {
      return getStubSettingsBuilder().listDeploymentsSettings();
    }

    /** Returns the builder for the settings used for calls to listDeploymentRevisions. */
    public PagedCallSettings.Builder<
            ListDeploymentRevisionsRequest,
            ListDeploymentRevisionsResponse,
            ListDeploymentRevisionsPagedResponse>
        listDeploymentRevisionsSettings() {
      return getStubSettingsBuilder().listDeploymentRevisionsSettings();
    }

    /** Returns the builder for the settings used for calls to discardDeploymentChanges. */
    public UnaryCallSettings.Builder<
            DiscardDeploymentChangesRequest, DiscardDeploymentChangesResponse>
        discardDeploymentChangesSettings() {
      return getStubSettingsBuilder().discardDeploymentChangesSettings();
    }

    /** Returns the builder for the settings used for calls to applyDeployment. */
    public UnaryCallSettings.Builder<ApplyDeploymentRequest, Deployment> applyDeploymentSettings() {
      return getStubSettingsBuilder().applyDeploymentSettings();
    }

    /** Returns the builder for the settings used for calls to computeDeploymentStatus. */
    public UnaryCallSettings.Builder<
            ComputeDeploymentStatusRequest, ComputeDeploymentStatusResponse>
        computeDeploymentStatusSettings() {
      return getStubSettingsBuilder().computeDeploymentStatusSettings();
    }

    /** Returns the builder for the settings used for calls to rollbackDeployment. */
    public UnaryCallSettings.Builder<RollbackDeploymentRequest, Deployment>
        rollbackDeploymentSettings() {
      return getStubSettingsBuilder().rollbackDeploymentSettings();
    }

    /** Returns the builder for the settings used for calls to getHydratedDeployment. */
    public UnaryCallSettings.Builder<GetHydratedDeploymentRequest, HydratedDeployment>
        getHydratedDeploymentSettings() {
      return getStubSettingsBuilder().getHydratedDeploymentSettings();
    }

    /** Returns the builder for the settings used for calls to listHydratedDeployments. */
    public PagedCallSettings.Builder<
            ListHydratedDeploymentsRequest,
            ListHydratedDeploymentsResponse,
            ListHydratedDeploymentsPagedResponse>
        listHydratedDeploymentsSettings() {
      return getStubSettingsBuilder().listHydratedDeploymentsSettings();
    }

    /** Returns the builder for the settings used for calls to updateHydratedDeployment. */
    public UnaryCallSettings.Builder<UpdateHydratedDeploymentRequest, HydratedDeployment>
        updateHydratedDeploymentSettings() {
      return getStubSettingsBuilder().updateHydratedDeploymentSettings();
    }

    /** Returns the builder for the settings used for calls to applyHydratedDeployment. */
    public UnaryCallSettings.Builder<ApplyHydratedDeploymentRequest, HydratedDeployment>
        applyHydratedDeploymentSettings() {
      return getStubSettingsBuilder().applyHydratedDeploymentSettings();
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

    @Override
    public TelcoAutomationSettings build() throws IOException {
      return new TelcoAutomationSettings(this);
    }
  }
}
