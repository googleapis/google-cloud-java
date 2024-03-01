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

package com.google.cloud.workstations.v1beta;

import static com.google.cloud.workstations.v1beta.WorkstationsClient.ListUsableWorkstationConfigsPagedResponse;
import static com.google.cloud.workstations.v1beta.WorkstationsClient.ListUsableWorkstationsPagedResponse;
import static com.google.cloud.workstations.v1beta.WorkstationsClient.ListWorkstationClustersPagedResponse;
import static com.google.cloud.workstations.v1beta.WorkstationsClient.ListWorkstationConfigsPagedResponse;
import static com.google.cloud.workstations.v1beta.WorkstationsClient.ListWorkstationsPagedResponse;

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
import com.google.cloud.workstations.v1beta.stub.WorkstationsStubSettings;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link WorkstationsClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (workstations.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getWorkstationCluster to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * WorkstationsSettings.Builder workstationsSettingsBuilder = WorkstationsSettings.newBuilder();
 * workstationsSettingsBuilder
 *     .getWorkstationClusterSettings()
 *     .setRetrySettings(
 *         workstationsSettingsBuilder
 *             .getWorkstationClusterSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * WorkstationsSettings workstationsSettings = workstationsSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class WorkstationsSettings extends ClientSettings<WorkstationsSettings> {

  /** Returns the object with the settings used for calls to getWorkstationCluster. */
  public UnaryCallSettings<GetWorkstationClusterRequest, WorkstationCluster>
      getWorkstationClusterSettings() {
    return ((WorkstationsStubSettings) getStubSettings()).getWorkstationClusterSettings();
  }

  /** Returns the object with the settings used for calls to listWorkstationClusters. */
  public PagedCallSettings<
          ListWorkstationClustersRequest,
          ListWorkstationClustersResponse,
          ListWorkstationClustersPagedResponse>
      listWorkstationClustersSettings() {
    return ((WorkstationsStubSettings) getStubSettings()).listWorkstationClustersSettings();
  }

  /** Returns the object with the settings used for calls to createWorkstationCluster. */
  public UnaryCallSettings<CreateWorkstationClusterRequest, Operation>
      createWorkstationClusterSettings() {
    return ((WorkstationsStubSettings) getStubSettings()).createWorkstationClusterSettings();
  }

  /** Returns the object with the settings used for calls to createWorkstationCluster. */
  public OperationCallSettings<
          CreateWorkstationClusterRequest, WorkstationCluster, OperationMetadata>
      createWorkstationClusterOperationSettings() {
    return ((WorkstationsStubSettings) getStubSettings())
        .createWorkstationClusterOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateWorkstationCluster. */
  public UnaryCallSettings<UpdateWorkstationClusterRequest, Operation>
      updateWorkstationClusterSettings() {
    return ((WorkstationsStubSettings) getStubSettings()).updateWorkstationClusterSettings();
  }

  /** Returns the object with the settings used for calls to updateWorkstationCluster. */
  public OperationCallSettings<
          UpdateWorkstationClusterRequest, WorkstationCluster, OperationMetadata>
      updateWorkstationClusterOperationSettings() {
    return ((WorkstationsStubSettings) getStubSettings())
        .updateWorkstationClusterOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteWorkstationCluster. */
  public UnaryCallSettings<DeleteWorkstationClusterRequest, Operation>
      deleteWorkstationClusterSettings() {
    return ((WorkstationsStubSettings) getStubSettings()).deleteWorkstationClusterSettings();
  }

  /** Returns the object with the settings used for calls to deleteWorkstationCluster. */
  public OperationCallSettings<
          DeleteWorkstationClusterRequest, WorkstationCluster, OperationMetadata>
      deleteWorkstationClusterOperationSettings() {
    return ((WorkstationsStubSettings) getStubSettings())
        .deleteWorkstationClusterOperationSettings();
  }

  /** Returns the object with the settings used for calls to getWorkstationConfig. */
  public UnaryCallSettings<GetWorkstationConfigRequest, WorkstationConfig>
      getWorkstationConfigSettings() {
    return ((WorkstationsStubSettings) getStubSettings()).getWorkstationConfigSettings();
  }

  /** Returns the object with the settings used for calls to listWorkstationConfigs. */
  public PagedCallSettings<
          ListWorkstationConfigsRequest,
          ListWorkstationConfigsResponse,
          ListWorkstationConfigsPagedResponse>
      listWorkstationConfigsSettings() {
    return ((WorkstationsStubSettings) getStubSettings()).listWorkstationConfigsSettings();
  }

  /** Returns the object with the settings used for calls to listUsableWorkstationConfigs. */
  public PagedCallSettings<
          ListUsableWorkstationConfigsRequest,
          ListUsableWorkstationConfigsResponse,
          ListUsableWorkstationConfigsPagedResponse>
      listUsableWorkstationConfigsSettings() {
    return ((WorkstationsStubSettings) getStubSettings()).listUsableWorkstationConfigsSettings();
  }

  /** Returns the object with the settings used for calls to createWorkstationConfig. */
  public UnaryCallSettings<CreateWorkstationConfigRequest, Operation>
      createWorkstationConfigSettings() {
    return ((WorkstationsStubSettings) getStubSettings()).createWorkstationConfigSettings();
  }

  /** Returns the object with the settings used for calls to createWorkstationConfig. */
  public OperationCallSettings<CreateWorkstationConfigRequest, WorkstationConfig, OperationMetadata>
      createWorkstationConfigOperationSettings() {
    return ((WorkstationsStubSettings) getStubSettings())
        .createWorkstationConfigOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateWorkstationConfig. */
  public UnaryCallSettings<UpdateWorkstationConfigRequest, Operation>
      updateWorkstationConfigSettings() {
    return ((WorkstationsStubSettings) getStubSettings()).updateWorkstationConfigSettings();
  }

  /** Returns the object with the settings used for calls to updateWorkstationConfig. */
  public OperationCallSettings<UpdateWorkstationConfigRequest, WorkstationConfig, OperationMetadata>
      updateWorkstationConfigOperationSettings() {
    return ((WorkstationsStubSettings) getStubSettings())
        .updateWorkstationConfigOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteWorkstationConfig. */
  public UnaryCallSettings<DeleteWorkstationConfigRequest, Operation>
      deleteWorkstationConfigSettings() {
    return ((WorkstationsStubSettings) getStubSettings()).deleteWorkstationConfigSettings();
  }

  /** Returns the object with the settings used for calls to deleteWorkstationConfig. */
  public OperationCallSettings<DeleteWorkstationConfigRequest, WorkstationConfig, OperationMetadata>
      deleteWorkstationConfigOperationSettings() {
    return ((WorkstationsStubSettings) getStubSettings())
        .deleteWorkstationConfigOperationSettings();
  }

  /** Returns the object with the settings used for calls to getWorkstation. */
  public UnaryCallSettings<GetWorkstationRequest, Workstation> getWorkstationSettings() {
    return ((WorkstationsStubSettings) getStubSettings()).getWorkstationSettings();
  }

  /** Returns the object with the settings used for calls to listWorkstations. */
  public PagedCallSettings<
          ListWorkstationsRequest, ListWorkstationsResponse, ListWorkstationsPagedResponse>
      listWorkstationsSettings() {
    return ((WorkstationsStubSettings) getStubSettings()).listWorkstationsSettings();
  }

  /** Returns the object with the settings used for calls to listUsableWorkstations. */
  public PagedCallSettings<
          ListUsableWorkstationsRequest,
          ListUsableWorkstationsResponse,
          ListUsableWorkstationsPagedResponse>
      listUsableWorkstationsSettings() {
    return ((WorkstationsStubSettings) getStubSettings()).listUsableWorkstationsSettings();
  }

  /** Returns the object with the settings used for calls to createWorkstation. */
  public UnaryCallSettings<CreateWorkstationRequest, Operation> createWorkstationSettings() {
    return ((WorkstationsStubSettings) getStubSettings()).createWorkstationSettings();
  }

  /** Returns the object with the settings used for calls to createWorkstation. */
  public OperationCallSettings<CreateWorkstationRequest, Workstation, OperationMetadata>
      createWorkstationOperationSettings() {
    return ((WorkstationsStubSettings) getStubSettings()).createWorkstationOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateWorkstation. */
  public UnaryCallSettings<UpdateWorkstationRequest, Operation> updateWorkstationSettings() {
    return ((WorkstationsStubSettings) getStubSettings()).updateWorkstationSettings();
  }

  /** Returns the object with the settings used for calls to updateWorkstation. */
  public OperationCallSettings<UpdateWorkstationRequest, Workstation, OperationMetadata>
      updateWorkstationOperationSettings() {
    return ((WorkstationsStubSettings) getStubSettings()).updateWorkstationOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteWorkstation. */
  public UnaryCallSettings<DeleteWorkstationRequest, Operation> deleteWorkstationSettings() {
    return ((WorkstationsStubSettings) getStubSettings()).deleteWorkstationSettings();
  }

  /** Returns the object with the settings used for calls to deleteWorkstation. */
  public OperationCallSettings<DeleteWorkstationRequest, Workstation, OperationMetadata>
      deleteWorkstationOperationSettings() {
    return ((WorkstationsStubSettings) getStubSettings()).deleteWorkstationOperationSettings();
  }

  /** Returns the object with the settings used for calls to startWorkstation. */
  public UnaryCallSettings<StartWorkstationRequest, Operation> startWorkstationSettings() {
    return ((WorkstationsStubSettings) getStubSettings()).startWorkstationSettings();
  }

  /** Returns the object with the settings used for calls to startWorkstation. */
  public OperationCallSettings<StartWorkstationRequest, Workstation, OperationMetadata>
      startWorkstationOperationSettings() {
    return ((WorkstationsStubSettings) getStubSettings()).startWorkstationOperationSettings();
  }

  /** Returns the object with the settings used for calls to stopWorkstation. */
  public UnaryCallSettings<StopWorkstationRequest, Operation> stopWorkstationSettings() {
    return ((WorkstationsStubSettings) getStubSettings()).stopWorkstationSettings();
  }

  /** Returns the object with the settings used for calls to stopWorkstation. */
  public OperationCallSettings<StopWorkstationRequest, Workstation, OperationMetadata>
      stopWorkstationOperationSettings() {
    return ((WorkstationsStubSettings) getStubSettings()).stopWorkstationOperationSettings();
  }

  /** Returns the object with the settings used for calls to generateAccessToken. */
  public UnaryCallSettings<GenerateAccessTokenRequest, GenerateAccessTokenResponse>
      generateAccessTokenSettings() {
    return ((WorkstationsStubSettings) getStubSettings()).generateAccessTokenSettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return ((WorkstationsStubSettings) getStubSettings()).setIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return ((WorkstationsStubSettings) getStubSettings()).getIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return ((WorkstationsStubSettings) getStubSettings()).testIamPermissionsSettings();
  }

  public static final WorkstationsSettings create(WorkstationsStubSettings stub)
      throws IOException {
    return new WorkstationsSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return WorkstationsStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return WorkstationsStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return WorkstationsStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return WorkstationsStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return WorkstationsStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return WorkstationsStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return WorkstationsStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return WorkstationsStubSettings.defaultApiClientHeaderProviderBuilder();
  }

  /** Returns a new gRPC builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new REST builder for this class. */
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

  protected WorkstationsSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for WorkstationsSettings. */
  public static class Builder extends ClientSettings.Builder<WorkstationsSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(WorkstationsStubSettings.newBuilder(clientContext));
    }

    protected Builder(WorkstationsSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(WorkstationsStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(WorkstationsStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(WorkstationsStubSettings.newHttpJsonBuilder());
    }

    public WorkstationsStubSettings.Builder getStubSettingsBuilder() {
      return ((WorkstationsStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to getWorkstationCluster. */
    public UnaryCallSettings.Builder<GetWorkstationClusterRequest, WorkstationCluster>
        getWorkstationClusterSettings() {
      return getStubSettingsBuilder().getWorkstationClusterSettings();
    }

    /** Returns the builder for the settings used for calls to listWorkstationClusters. */
    public PagedCallSettings.Builder<
            ListWorkstationClustersRequest,
            ListWorkstationClustersResponse,
            ListWorkstationClustersPagedResponse>
        listWorkstationClustersSettings() {
      return getStubSettingsBuilder().listWorkstationClustersSettings();
    }

    /** Returns the builder for the settings used for calls to createWorkstationCluster. */
    public UnaryCallSettings.Builder<CreateWorkstationClusterRequest, Operation>
        createWorkstationClusterSettings() {
      return getStubSettingsBuilder().createWorkstationClusterSettings();
    }

    /** Returns the builder for the settings used for calls to createWorkstationCluster. */
    public OperationCallSettings.Builder<
            CreateWorkstationClusterRequest, WorkstationCluster, OperationMetadata>
        createWorkstationClusterOperationSettings() {
      return getStubSettingsBuilder().createWorkstationClusterOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateWorkstationCluster. */
    public UnaryCallSettings.Builder<UpdateWorkstationClusterRequest, Operation>
        updateWorkstationClusterSettings() {
      return getStubSettingsBuilder().updateWorkstationClusterSettings();
    }

    /** Returns the builder for the settings used for calls to updateWorkstationCluster. */
    public OperationCallSettings.Builder<
            UpdateWorkstationClusterRequest, WorkstationCluster, OperationMetadata>
        updateWorkstationClusterOperationSettings() {
      return getStubSettingsBuilder().updateWorkstationClusterOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteWorkstationCluster. */
    public UnaryCallSettings.Builder<DeleteWorkstationClusterRequest, Operation>
        deleteWorkstationClusterSettings() {
      return getStubSettingsBuilder().deleteWorkstationClusterSettings();
    }

    /** Returns the builder for the settings used for calls to deleteWorkstationCluster. */
    public OperationCallSettings.Builder<
            DeleteWorkstationClusterRequest, WorkstationCluster, OperationMetadata>
        deleteWorkstationClusterOperationSettings() {
      return getStubSettingsBuilder().deleteWorkstationClusterOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getWorkstationConfig. */
    public UnaryCallSettings.Builder<GetWorkstationConfigRequest, WorkstationConfig>
        getWorkstationConfigSettings() {
      return getStubSettingsBuilder().getWorkstationConfigSettings();
    }

    /** Returns the builder for the settings used for calls to listWorkstationConfigs. */
    public PagedCallSettings.Builder<
            ListWorkstationConfigsRequest,
            ListWorkstationConfigsResponse,
            ListWorkstationConfigsPagedResponse>
        listWorkstationConfigsSettings() {
      return getStubSettingsBuilder().listWorkstationConfigsSettings();
    }

    /** Returns the builder for the settings used for calls to listUsableWorkstationConfigs. */
    public PagedCallSettings.Builder<
            ListUsableWorkstationConfigsRequest,
            ListUsableWorkstationConfigsResponse,
            ListUsableWorkstationConfigsPagedResponse>
        listUsableWorkstationConfigsSettings() {
      return getStubSettingsBuilder().listUsableWorkstationConfigsSettings();
    }

    /** Returns the builder for the settings used for calls to createWorkstationConfig. */
    public UnaryCallSettings.Builder<CreateWorkstationConfigRequest, Operation>
        createWorkstationConfigSettings() {
      return getStubSettingsBuilder().createWorkstationConfigSettings();
    }

    /** Returns the builder for the settings used for calls to createWorkstationConfig. */
    public OperationCallSettings.Builder<
            CreateWorkstationConfigRequest, WorkstationConfig, OperationMetadata>
        createWorkstationConfigOperationSettings() {
      return getStubSettingsBuilder().createWorkstationConfigOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateWorkstationConfig. */
    public UnaryCallSettings.Builder<UpdateWorkstationConfigRequest, Operation>
        updateWorkstationConfigSettings() {
      return getStubSettingsBuilder().updateWorkstationConfigSettings();
    }

    /** Returns the builder for the settings used for calls to updateWorkstationConfig. */
    public OperationCallSettings.Builder<
            UpdateWorkstationConfigRequest, WorkstationConfig, OperationMetadata>
        updateWorkstationConfigOperationSettings() {
      return getStubSettingsBuilder().updateWorkstationConfigOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteWorkstationConfig. */
    public UnaryCallSettings.Builder<DeleteWorkstationConfigRequest, Operation>
        deleteWorkstationConfigSettings() {
      return getStubSettingsBuilder().deleteWorkstationConfigSettings();
    }

    /** Returns the builder for the settings used for calls to deleteWorkstationConfig. */
    public OperationCallSettings.Builder<
            DeleteWorkstationConfigRequest, WorkstationConfig, OperationMetadata>
        deleteWorkstationConfigOperationSettings() {
      return getStubSettingsBuilder().deleteWorkstationConfigOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getWorkstation. */
    public UnaryCallSettings.Builder<GetWorkstationRequest, Workstation> getWorkstationSettings() {
      return getStubSettingsBuilder().getWorkstationSettings();
    }

    /** Returns the builder for the settings used for calls to listWorkstations. */
    public PagedCallSettings.Builder<
            ListWorkstationsRequest, ListWorkstationsResponse, ListWorkstationsPagedResponse>
        listWorkstationsSettings() {
      return getStubSettingsBuilder().listWorkstationsSettings();
    }

    /** Returns the builder for the settings used for calls to listUsableWorkstations. */
    public PagedCallSettings.Builder<
            ListUsableWorkstationsRequest,
            ListUsableWorkstationsResponse,
            ListUsableWorkstationsPagedResponse>
        listUsableWorkstationsSettings() {
      return getStubSettingsBuilder().listUsableWorkstationsSettings();
    }

    /** Returns the builder for the settings used for calls to createWorkstation. */
    public UnaryCallSettings.Builder<CreateWorkstationRequest, Operation>
        createWorkstationSettings() {
      return getStubSettingsBuilder().createWorkstationSettings();
    }

    /** Returns the builder for the settings used for calls to createWorkstation. */
    public OperationCallSettings.Builder<CreateWorkstationRequest, Workstation, OperationMetadata>
        createWorkstationOperationSettings() {
      return getStubSettingsBuilder().createWorkstationOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateWorkstation. */
    public UnaryCallSettings.Builder<UpdateWorkstationRequest, Operation>
        updateWorkstationSettings() {
      return getStubSettingsBuilder().updateWorkstationSettings();
    }

    /** Returns the builder for the settings used for calls to updateWorkstation. */
    public OperationCallSettings.Builder<UpdateWorkstationRequest, Workstation, OperationMetadata>
        updateWorkstationOperationSettings() {
      return getStubSettingsBuilder().updateWorkstationOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteWorkstation. */
    public UnaryCallSettings.Builder<DeleteWorkstationRequest, Operation>
        deleteWorkstationSettings() {
      return getStubSettingsBuilder().deleteWorkstationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteWorkstation. */
    public OperationCallSettings.Builder<DeleteWorkstationRequest, Workstation, OperationMetadata>
        deleteWorkstationOperationSettings() {
      return getStubSettingsBuilder().deleteWorkstationOperationSettings();
    }

    /** Returns the builder for the settings used for calls to startWorkstation. */
    public UnaryCallSettings.Builder<StartWorkstationRequest, Operation>
        startWorkstationSettings() {
      return getStubSettingsBuilder().startWorkstationSettings();
    }

    /** Returns the builder for the settings used for calls to startWorkstation. */
    public OperationCallSettings.Builder<StartWorkstationRequest, Workstation, OperationMetadata>
        startWorkstationOperationSettings() {
      return getStubSettingsBuilder().startWorkstationOperationSettings();
    }

    /** Returns the builder for the settings used for calls to stopWorkstation. */
    public UnaryCallSettings.Builder<StopWorkstationRequest, Operation> stopWorkstationSettings() {
      return getStubSettingsBuilder().stopWorkstationSettings();
    }

    /** Returns the builder for the settings used for calls to stopWorkstation. */
    public OperationCallSettings.Builder<StopWorkstationRequest, Workstation, OperationMetadata>
        stopWorkstationOperationSettings() {
      return getStubSettingsBuilder().stopWorkstationOperationSettings();
    }

    /** Returns the builder for the settings used for calls to generateAccessToken. */
    public UnaryCallSettings.Builder<GenerateAccessTokenRequest, GenerateAccessTokenResponse>
        generateAccessTokenSettings() {
      return getStubSettingsBuilder().generateAccessTokenSettings();
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
    public WorkstationsSettings build() throws IOException {
      return new WorkstationsSettings(this);
    }
  }
}
