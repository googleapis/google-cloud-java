/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.oracledatabase.v1;

import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListAutonomousDatabaseBackupsPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListAutonomousDatabaseCharacterSetsPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListAutonomousDatabasesPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListAutonomousDbVersionsPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListCloudExadataInfrastructuresPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListCloudVmClustersPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListDbNodesPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListDbServersPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListDbSystemShapesPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListEntitlementsPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListGiVersionsPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListLocationsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.oracledatabase.v1.stub.OracleDatabaseStubSettings;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link OracleDatabaseClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (oracledatabase.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getCloudExadataInfrastructure:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * OracleDatabaseSettings.Builder oracleDatabaseSettingsBuilder =
 *     OracleDatabaseSettings.newBuilder();
 * oracleDatabaseSettingsBuilder
 *     .getCloudExadataInfrastructureSettings()
 *     .setRetrySettings(
 *         oracleDatabaseSettingsBuilder
 *             .getCloudExadataInfrastructureSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofSeconds(1))
 *             .setInitialRpcTimeoutDuration(Duration.ofSeconds(5))
 *             .setMaxAttempts(5)
 *             .setMaxRetryDelayDuration(Duration.ofSeconds(30))
 *             .setMaxRpcTimeoutDuration(Duration.ofSeconds(60))
 *             .setRetryDelayMultiplier(1.3)
 *             .setRpcTimeoutMultiplier(1.5)
 *             .setTotalTimeoutDuration(Duration.ofSeconds(300))
 *             .build());
 * OracleDatabaseSettings oracleDatabaseSettings = oracleDatabaseSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for createCloudExadataInfrastructure:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * OracleDatabaseSettings.Builder oracleDatabaseSettingsBuilder =
 *     OracleDatabaseSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * oracleDatabaseSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class OracleDatabaseSettings extends ClientSettings<OracleDatabaseSettings> {

  /** Returns the object with the settings used for calls to listCloudExadataInfrastructures. */
  public PagedCallSettings<
          ListCloudExadataInfrastructuresRequest,
          ListCloudExadataInfrastructuresResponse,
          ListCloudExadataInfrastructuresPagedResponse>
      listCloudExadataInfrastructuresSettings() {
    return ((OracleDatabaseStubSettings) getStubSettings())
        .listCloudExadataInfrastructuresSettings();
  }

  /** Returns the object with the settings used for calls to getCloudExadataInfrastructure. */
  public UnaryCallSettings<GetCloudExadataInfrastructureRequest, CloudExadataInfrastructure>
      getCloudExadataInfrastructureSettings() {
    return ((OracleDatabaseStubSettings) getStubSettings()).getCloudExadataInfrastructureSettings();
  }

  /** Returns the object with the settings used for calls to createCloudExadataInfrastructure. */
  public UnaryCallSettings<CreateCloudExadataInfrastructureRequest, Operation>
      createCloudExadataInfrastructureSettings() {
    return ((OracleDatabaseStubSettings) getStubSettings())
        .createCloudExadataInfrastructureSettings();
  }

  /** Returns the object with the settings used for calls to createCloudExadataInfrastructure. */
  public OperationCallSettings<
          CreateCloudExadataInfrastructureRequest, CloudExadataInfrastructure, OperationMetadata>
      createCloudExadataInfrastructureOperationSettings() {
    return ((OracleDatabaseStubSettings) getStubSettings())
        .createCloudExadataInfrastructureOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteCloudExadataInfrastructure. */
  public UnaryCallSettings<DeleteCloudExadataInfrastructureRequest, Operation>
      deleteCloudExadataInfrastructureSettings() {
    return ((OracleDatabaseStubSettings) getStubSettings())
        .deleteCloudExadataInfrastructureSettings();
  }

  /** Returns the object with the settings used for calls to deleteCloudExadataInfrastructure. */
  public OperationCallSettings<DeleteCloudExadataInfrastructureRequest, Empty, OperationMetadata>
      deleteCloudExadataInfrastructureOperationSettings() {
    return ((OracleDatabaseStubSettings) getStubSettings())
        .deleteCloudExadataInfrastructureOperationSettings();
  }

  /** Returns the object with the settings used for calls to listCloudVmClusters. */
  public PagedCallSettings<
          ListCloudVmClustersRequest, ListCloudVmClustersResponse, ListCloudVmClustersPagedResponse>
      listCloudVmClustersSettings() {
    return ((OracleDatabaseStubSettings) getStubSettings()).listCloudVmClustersSettings();
  }

  /** Returns the object with the settings used for calls to getCloudVmCluster. */
  public UnaryCallSettings<GetCloudVmClusterRequest, CloudVmCluster> getCloudVmClusterSettings() {
    return ((OracleDatabaseStubSettings) getStubSettings()).getCloudVmClusterSettings();
  }

  /** Returns the object with the settings used for calls to createCloudVmCluster. */
  public UnaryCallSettings<CreateCloudVmClusterRequest, Operation> createCloudVmClusterSettings() {
    return ((OracleDatabaseStubSettings) getStubSettings()).createCloudVmClusterSettings();
  }

  /** Returns the object with the settings used for calls to createCloudVmCluster. */
  public OperationCallSettings<CreateCloudVmClusterRequest, CloudVmCluster, OperationMetadata>
      createCloudVmClusterOperationSettings() {
    return ((OracleDatabaseStubSettings) getStubSettings()).createCloudVmClusterOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteCloudVmCluster. */
  public UnaryCallSettings<DeleteCloudVmClusterRequest, Operation> deleteCloudVmClusterSettings() {
    return ((OracleDatabaseStubSettings) getStubSettings()).deleteCloudVmClusterSettings();
  }

  /** Returns the object with the settings used for calls to deleteCloudVmCluster. */
  public OperationCallSettings<DeleteCloudVmClusterRequest, Empty, OperationMetadata>
      deleteCloudVmClusterOperationSettings() {
    return ((OracleDatabaseStubSettings) getStubSettings()).deleteCloudVmClusterOperationSettings();
  }

  /** Returns the object with the settings used for calls to listEntitlements. */
  public PagedCallSettings<
          ListEntitlementsRequest, ListEntitlementsResponse, ListEntitlementsPagedResponse>
      listEntitlementsSettings() {
    return ((OracleDatabaseStubSettings) getStubSettings()).listEntitlementsSettings();
  }

  /** Returns the object with the settings used for calls to listDbServers. */
  public PagedCallSettings<ListDbServersRequest, ListDbServersResponse, ListDbServersPagedResponse>
      listDbServersSettings() {
    return ((OracleDatabaseStubSettings) getStubSettings()).listDbServersSettings();
  }

  /** Returns the object with the settings used for calls to listDbNodes. */
  public PagedCallSettings<ListDbNodesRequest, ListDbNodesResponse, ListDbNodesPagedResponse>
      listDbNodesSettings() {
    return ((OracleDatabaseStubSettings) getStubSettings()).listDbNodesSettings();
  }

  /** Returns the object with the settings used for calls to listGiVersions. */
  public PagedCallSettings<
          ListGiVersionsRequest, ListGiVersionsResponse, ListGiVersionsPagedResponse>
      listGiVersionsSettings() {
    return ((OracleDatabaseStubSettings) getStubSettings()).listGiVersionsSettings();
  }

  /** Returns the object with the settings used for calls to listDbSystemShapes. */
  public PagedCallSettings<
          ListDbSystemShapesRequest, ListDbSystemShapesResponse, ListDbSystemShapesPagedResponse>
      listDbSystemShapesSettings() {
    return ((OracleDatabaseStubSettings) getStubSettings()).listDbSystemShapesSettings();
  }

  /** Returns the object with the settings used for calls to listAutonomousDatabases. */
  public PagedCallSettings<
          ListAutonomousDatabasesRequest,
          ListAutonomousDatabasesResponse,
          ListAutonomousDatabasesPagedResponse>
      listAutonomousDatabasesSettings() {
    return ((OracleDatabaseStubSettings) getStubSettings()).listAutonomousDatabasesSettings();
  }

  /** Returns the object with the settings used for calls to getAutonomousDatabase. */
  public UnaryCallSettings<GetAutonomousDatabaseRequest, AutonomousDatabase>
      getAutonomousDatabaseSettings() {
    return ((OracleDatabaseStubSettings) getStubSettings()).getAutonomousDatabaseSettings();
  }

  /** Returns the object with the settings used for calls to createAutonomousDatabase. */
  public UnaryCallSettings<CreateAutonomousDatabaseRequest, Operation>
      createAutonomousDatabaseSettings() {
    return ((OracleDatabaseStubSettings) getStubSettings()).createAutonomousDatabaseSettings();
  }

  /** Returns the object with the settings used for calls to createAutonomousDatabase. */
  public OperationCallSettings<
          CreateAutonomousDatabaseRequest, AutonomousDatabase, OperationMetadata>
      createAutonomousDatabaseOperationSettings() {
    return ((OracleDatabaseStubSettings) getStubSettings())
        .createAutonomousDatabaseOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteAutonomousDatabase. */
  public UnaryCallSettings<DeleteAutonomousDatabaseRequest, Operation>
      deleteAutonomousDatabaseSettings() {
    return ((OracleDatabaseStubSettings) getStubSettings()).deleteAutonomousDatabaseSettings();
  }

  /** Returns the object with the settings used for calls to deleteAutonomousDatabase. */
  public OperationCallSettings<DeleteAutonomousDatabaseRequest, Empty, OperationMetadata>
      deleteAutonomousDatabaseOperationSettings() {
    return ((OracleDatabaseStubSettings) getStubSettings())
        .deleteAutonomousDatabaseOperationSettings();
  }

  /** Returns the object with the settings used for calls to restoreAutonomousDatabase. */
  public UnaryCallSettings<RestoreAutonomousDatabaseRequest, Operation>
      restoreAutonomousDatabaseSettings() {
    return ((OracleDatabaseStubSettings) getStubSettings()).restoreAutonomousDatabaseSettings();
  }

  /** Returns the object with the settings used for calls to restoreAutonomousDatabase. */
  public OperationCallSettings<
          RestoreAutonomousDatabaseRequest, AutonomousDatabase, OperationMetadata>
      restoreAutonomousDatabaseOperationSettings() {
    return ((OracleDatabaseStubSettings) getStubSettings())
        .restoreAutonomousDatabaseOperationSettings();
  }

  /** Returns the object with the settings used for calls to generateAutonomousDatabaseWallet. */
  public UnaryCallSettings<
          GenerateAutonomousDatabaseWalletRequest, GenerateAutonomousDatabaseWalletResponse>
      generateAutonomousDatabaseWalletSettings() {
    return ((OracleDatabaseStubSettings) getStubSettings())
        .generateAutonomousDatabaseWalletSettings();
  }

  /** Returns the object with the settings used for calls to listAutonomousDbVersions. */
  public PagedCallSettings<
          ListAutonomousDbVersionsRequest,
          ListAutonomousDbVersionsResponse,
          ListAutonomousDbVersionsPagedResponse>
      listAutonomousDbVersionsSettings() {
    return ((OracleDatabaseStubSettings) getStubSettings()).listAutonomousDbVersionsSettings();
  }

  /** Returns the object with the settings used for calls to listAutonomousDatabaseCharacterSets. */
  public PagedCallSettings<
          ListAutonomousDatabaseCharacterSetsRequest,
          ListAutonomousDatabaseCharacterSetsResponse,
          ListAutonomousDatabaseCharacterSetsPagedResponse>
      listAutonomousDatabaseCharacterSetsSettings() {
    return ((OracleDatabaseStubSettings) getStubSettings())
        .listAutonomousDatabaseCharacterSetsSettings();
  }

  /** Returns the object with the settings used for calls to listAutonomousDatabaseBackups. */
  public PagedCallSettings<
          ListAutonomousDatabaseBackupsRequest,
          ListAutonomousDatabaseBackupsResponse,
          ListAutonomousDatabaseBackupsPagedResponse>
      listAutonomousDatabaseBackupsSettings() {
    return ((OracleDatabaseStubSettings) getStubSettings()).listAutonomousDatabaseBackupsSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((OracleDatabaseStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((OracleDatabaseStubSettings) getStubSettings()).getLocationSettings();
  }

  public static final OracleDatabaseSettings create(OracleDatabaseStubSettings stub)
      throws IOException {
    return new OracleDatabaseSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return OracleDatabaseStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return OracleDatabaseStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return OracleDatabaseStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return OracleDatabaseStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return OracleDatabaseStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return OracleDatabaseStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return OracleDatabaseStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected OracleDatabaseSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for OracleDatabaseSettings. */
  public static class Builder extends ClientSettings.Builder<OracleDatabaseSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(OracleDatabaseStubSettings.newBuilder(clientContext));
    }

    protected Builder(OracleDatabaseSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(OracleDatabaseStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(OracleDatabaseStubSettings.newBuilder());
    }

    public OracleDatabaseStubSettings.Builder getStubSettingsBuilder() {
      return ((OracleDatabaseStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to listCloudExadataInfrastructures. */
    public PagedCallSettings.Builder<
            ListCloudExadataInfrastructuresRequest,
            ListCloudExadataInfrastructuresResponse,
            ListCloudExadataInfrastructuresPagedResponse>
        listCloudExadataInfrastructuresSettings() {
      return getStubSettingsBuilder().listCloudExadataInfrastructuresSettings();
    }

    /** Returns the builder for the settings used for calls to getCloudExadataInfrastructure. */
    public UnaryCallSettings.Builder<
            GetCloudExadataInfrastructureRequest, CloudExadataInfrastructure>
        getCloudExadataInfrastructureSettings() {
      return getStubSettingsBuilder().getCloudExadataInfrastructureSettings();
    }

    /** Returns the builder for the settings used for calls to createCloudExadataInfrastructure. */
    public UnaryCallSettings.Builder<CreateCloudExadataInfrastructureRequest, Operation>
        createCloudExadataInfrastructureSettings() {
      return getStubSettingsBuilder().createCloudExadataInfrastructureSettings();
    }

    /** Returns the builder for the settings used for calls to createCloudExadataInfrastructure. */
    public OperationCallSettings.Builder<
            CreateCloudExadataInfrastructureRequest, CloudExadataInfrastructure, OperationMetadata>
        createCloudExadataInfrastructureOperationSettings() {
      return getStubSettingsBuilder().createCloudExadataInfrastructureOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteCloudExadataInfrastructure. */
    public UnaryCallSettings.Builder<DeleteCloudExadataInfrastructureRequest, Operation>
        deleteCloudExadataInfrastructureSettings() {
      return getStubSettingsBuilder().deleteCloudExadataInfrastructureSettings();
    }

    /** Returns the builder for the settings used for calls to deleteCloudExadataInfrastructure. */
    public OperationCallSettings.Builder<
            DeleteCloudExadataInfrastructureRequest, Empty, OperationMetadata>
        deleteCloudExadataInfrastructureOperationSettings() {
      return getStubSettingsBuilder().deleteCloudExadataInfrastructureOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listCloudVmClusters. */
    public PagedCallSettings.Builder<
            ListCloudVmClustersRequest,
            ListCloudVmClustersResponse,
            ListCloudVmClustersPagedResponse>
        listCloudVmClustersSettings() {
      return getStubSettingsBuilder().listCloudVmClustersSettings();
    }

    /** Returns the builder for the settings used for calls to getCloudVmCluster. */
    public UnaryCallSettings.Builder<GetCloudVmClusterRequest, CloudVmCluster>
        getCloudVmClusterSettings() {
      return getStubSettingsBuilder().getCloudVmClusterSettings();
    }

    /** Returns the builder for the settings used for calls to createCloudVmCluster. */
    public UnaryCallSettings.Builder<CreateCloudVmClusterRequest, Operation>
        createCloudVmClusterSettings() {
      return getStubSettingsBuilder().createCloudVmClusterSettings();
    }

    /** Returns the builder for the settings used for calls to createCloudVmCluster. */
    public OperationCallSettings.Builder<
            CreateCloudVmClusterRequest, CloudVmCluster, OperationMetadata>
        createCloudVmClusterOperationSettings() {
      return getStubSettingsBuilder().createCloudVmClusterOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteCloudVmCluster. */
    public UnaryCallSettings.Builder<DeleteCloudVmClusterRequest, Operation>
        deleteCloudVmClusterSettings() {
      return getStubSettingsBuilder().deleteCloudVmClusterSettings();
    }

    /** Returns the builder for the settings used for calls to deleteCloudVmCluster. */
    public OperationCallSettings.Builder<DeleteCloudVmClusterRequest, Empty, OperationMetadata>
        deleteCloudVmClusterOperationSettings() {
      return getStubSettingsBuilder().deleteCloudVmClusterOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listEntitlements. */
    public PagedCallSettings.Builder<
            ListEntitlementsRequest, ListEntitlementsResponse, ListEntitlementsPagedResponse>
        listEntitlementsSettings() {
      return getStubSettingsBuilder().listEntitlementsSettings();
    }

    /** Returns the builder for the settings used for calls to listDbServers. */
    public PagedCallSettings.Builder<
            ListDbServersRequest, ListDbServersResponse, ListDbServersPagedResponse>
        listDbServersSettings() {
      return getStubSettingsBuilder().listDbServersSettings();
    }

    /** Returns the builder for the settings used for calls to listDbNodes. */
    public PagedCallSettings.Builder<
            ListDbNodesRequest, ListDbNodesResponse, ListDbNodesPagedResponse>
        listDbNodesSettings() {
      return getStubSettingsBuilder().listDbNodesSettings();
    }

    /** Returns the builder for the settings used for calls to listGiVersions. */
    public PagedCallSettings.Builder<
            ListGiVersionsRequest, ListGiVersionsResponse, ListGiVersionsPagedResponse>
        listGiVersionsSettings() {
      return getStubSettingsBuilder().listGiVersionsSettings();
    }

    /** Returns the builder for the settings used for calls to listDbSystemShapes. */
    public PagedCallSettings.Builder<
            ListDbSystemShapesRequest, ListDbSystemShapesResponse, ListDbSystemShapesPagedResponse>
        listDbSystemShapesSettings() {
      return getStubSettingsBuilder().listDbSystemShapesSettings();
    }

    /** Returns the builder for the settings used for calls to listAutonomousDatabases. */
    public PagedCallSettings.Builder<
            ListAutonomousDatabasesRequest,
            ListAutonomousDatabasesResponse,
            ListAutonomousDatabasesPagedResponse>
        listAutonomousDatabasesSettings() {
      return getStubSettingsBuilder().listAutonomousDatabasesSettings();
    }

    /** Returns the builder for the settings used for calls to getAutonomousDatabase. */
    public UnaryCallSettings.Builder<GetAutonomousDatabaseRequest, AutonomousDatabase>
        getAutonomousDatabaseSettings() {
      return getStubSettingsBuilder().getAutonomousDatabaseSettings();
    }

    /** Returns the builder for the settings used for calls to createAutonomousDatabase. */
    public UnaryCallSettings.Builder<CreateAutonomousDatabaseRequest, Operation>
        createAutonomousDatabaseSettings() {
      return getStubSettingsBuilder().createAutonomousDatabaseSettings();
    }

    /** Returns the builder for the settings used for calls to createAutonomousDatabase. */
    public OperationCallSettings.Builder<
            CreateAutonomousDatabaseRequest, AutonomousDatabase, OperationMetadata>
        createAutonomousDatabaseOperationSettings() {
      return getStubSettingsBuilder().createAutonomousDatabaseOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteAutonomousDatabase. */
    public UnaryCallSettings.Builder<DeleteAutonomousDatabaseRequest, Operation>
        deleteAutonomousDatabaseSettings() {
      return getStubSettingsBuilder().deleteAutonomousDatabaseSettings();
    }

    /** Returns the builder for the settings used for calls to deleteAutonomousDatabase. */
    public OperationCallSettings.Builder<DeleteAutonomousDatabaseRequest, Empty, OperationMetadata>
        deleteAutonomousDatabaseOperationSettings() {
      return getStubSettingsBuilder().deleteAutonomousDatabaseOperationSettings();
    }

    /** Returns the builder for the settings used for calls to restoreAutonomousDatabase. */
    public UnaryCallSettings.Builder<RestoreAutonomousDatabaseRequest, Operation>
        restoreAutonomousDatabaseSettings() {
      return getStubSettingsBuilder().restoreAutonomousDatabaseSettings();
    }

    /** Returns the builder for the settings used for calls to restoreAutonomousDatabase. */
    public OperationCallSettings.Builder<
            RestoreAutonomousDatabaseRequest, AutonomousDatabase, OperationMetadata>
        restoreAutonomousDatabaseOperationSettings() {
      return getStubSettingsBuilder().restoreAutonomousDatabaseOperationSettings();
    }

    /** Returns the builder for the settings used for calls to generateAutonomousDatabaseWallet. */
    public UnaryCallSettings.Builder<
            GenerateAutonomousDatabaseWalletRequest, GenerateAutonomousDatabaseWalletResponse>
        generateAutonomousDatabaseWalletSettings() {
      return getStubSettingsBuilder().generateAutonomousDatabaseWalletSettings();
    }

    /** Returns the builder for the settings used for calls to listAutonomousDbVersions. */
    public PagedCallSettings.Builder<
            ListAutonomousDbVersionsRequest,
            ListAutonomousDbVersionsResponse,
            ListAutonomousDbVersionsPagedResponse>
        listAutonomousDbVersionsSettings() {
      return getStubSettingsBuilder().listAutonomousDbVersionsSettings();
    }

    /**
     * Returns the builder for the settings used for calls to listAutonomousDatabaseCharacterSets.
     */
    public PagedCallSettings.Builder<
            ListAutonomousDatabaseCharacterSetsRequest,
            ListAutonomousDatabaseCharacterSetsResponse,
            ListAutonomousDatabaseCharacterSetsPagedResponse>
        listAutonomousDatabaseCharacterSetsSettings() {
      return getStubSettingsBuilder().listAutonomousDatabaseCharacterSetsSettings();
    }

    /** Returns the builder for the settings used for calls to listAutonomousDatabaseBackups. */
    public PagedCallSettings.Builder<
            ListAutonomousDatabaseBackupsRequest,
            ListAutonomousDatabaseBackupsResponse,
            ListAutonomousDatabaseBackupsPagedResponse>
        listAutonomousDatabaseBackupsSettings() {
      return getStubSettingsBuilder().listAutonomousDatabaseBackupsSettings();
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
    public OracleDatabaseSettings build() throws IOException {
      return new OracleDatabaseSettings(this);
    }
  }
}
