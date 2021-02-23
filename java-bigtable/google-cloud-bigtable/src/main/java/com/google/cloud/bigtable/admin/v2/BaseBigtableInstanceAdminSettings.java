/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.bigtable.admin.v2;

import static com.google.cloud.bigtable.admin.v2.BaseBigtableInstanceAdminClient.ListAppProfilesPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.bigtable.admin.v2.AppProfile;
import com.google.bigtable.admin.v2.Cluster;
import com.google.bigtable.admin.v2.CreateAppProfileRequest;
import com.google.bigtable.admin.v2.CreateClusterMetadata;
import com.google.bigtable.admin.v2.CreateClusterRequest;
import com.google.bigtable.admin.v2.CreateInstanceMetadata;
import com.google.bigtable.admin.v2.CreateInstanceRequest;
import com.google.bigtable.admin.v2.DeleteAppProfileRequest;
import com.google.bigtable.admin.v2.DeleteClusterRequest;
import com.google.bigtable.admin.v2.DeleteInstanceRequest;
import com.google.bigtable.admin.v2.GetAppProfileRequest;
import com.google.bigtable.admin.v2.GetClusterRequest;
import com.google.bigtable.admin.v2.GetInstanceRequest;
import com.google.bigtable.admin.v2.Instance;
import com.google.bigtable.admin.v2.ListAppProfilesRequest;
import com.google.bigtable.admin.v2.ListAppProfilesResponse;
import com.google.bigtable.admin.v2.ListClustersRequest;
import com.google.bigtable.admin.v2.ListClustersResponse;
import com.google.bigtable.admin.v2.ListInstancesRequest;
import com.google.bigtable.admin.v2.ListInstancesResponse;
import com.google.bigtable.admin.v2.PartialUpdateInstanceRequest;
import com.google.bigtable.admin.v2.UpdateAppProfileMetadata;
import com.google.bigtable.admin.v2.UpdateAppProfileRequest;
import com.google.bigtable.admin.v2.UpdateClusterMetadata;
import com.google.bigtable.admin.v2.UpdateInstanceMetadata;
import com.google.cloud.bigtable.admin.v2.stub.BigtableInstanceAdminStubSettings;
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
/** For internal use only. */
@Generated("by gapic-generator")
@InternalApi
public class BaseBigtableInstanceAdminSettings
    extends ClientSettings<BaseBigtableInstanceAdminSettings> {

  /** Returns the object with the settings used for calls to createInstance. */
  public UnaryCallSettings<CreateInstanceRequest, Operation> createInstanceSettings() {
    return ((BigtableInstanceAdminStubSettings) getStubSettings()).createInstanceSettings();
  }

  /** Returns the object with the settings used for calls to createInstance. */
  public OperationCallSettings<CreateInstanceRequest, Instance, CreateInstanceMetadata>
      createInstanceOperationSettings() {
    return ((BigtableInstanceAdminStubSettings) getStubSettings())
        .createInstanceOperationSettings();
  }

  /** Returns the object with the settings used for calls to getInstance. */
  public UnaryCallSettings<GetInstanceRequest, Instance> getInstanceSettings() {
    return ((BigtableInstanceAdminStubSettings) getStubSettings()).getInstanceSettings();
  }

  /** Returns the object with the settings used for calls to listInstances. */
  public UnaryCallSettings<ListInstancesRequest, ListInstancesResponse> listInstancesSettings() {
    return ((BigtableInstanceAdminStubSettings) getStubSettings()).listInstancesSettings();
  }

  /** Returns the object with the settings used for calls to partialUpdateInstance. */
  public UnaryCallSettings<PartialUpdateInstanceRequest, Operation>
      partialUpdateInstanceSettings() {
    return ((BigtableInstanceAdminStubSettings) getStubSettings()).partialUpdateInstanceSettings();
  }

  /** Returns the object with the settings used for calls to partialUpdateInstance. */
  public OperationCallSettings<PartialUpdateInstanceRequest, Instance, UpdateInstanceMetadata>
      partialUpdateInstanceOperationSettings() {
    return ((BigtableInstanceAdminStubSettings) getStubSettings())
        .partialUpdateInstanceOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteInstance. */
  public UnaryCallSettings<DeleteInstanceRequest, Empty> deleteInstanceSettings() {
    return ((BigtableInstanceAdminStubSettings) getStubSettings()).deleteInstanceSettings();
  }

  /** Returns the object with the settings used for calls to createCluster. */
  public UnaryCallSettings<CreateClusterRequest, Operation> createClusterSettings() {
    return ((BigtableInstanceAdminStubSettings) getStubSettings()).createClusterSettings();
  }

  /** Returns the object with the settings used for calls to createCluster. */
  public OperationCallSettings<CreateClusterRequest, Cluster, CreateClusterMetadata>
      createClusterOperationSettings() {
    return ((BigtableInstanceAdminStubSettings) getStubSettings()).createClusterOperationSettings();
  }

  /** Returns the object with the settings used for calls to getCluster. */
  public UnaryCallSettings<GetClusterRequest, Cluster> getClusterSettings() {
    return ((BigtableInstanceAdminStubSettings) getStubSettings()).getClusterSettings();
  }

  /** Returns the object with the settings used for calls to listClusters. */
  public UnaryCallSettings<ListClustersRequest, ListClustersResponse> listClustersSettings() {
    return ((BigtableInstanceAdminStubSettings) getStubSettings()).listClustersSettings();
  }

  /** Returns the object with the settings used for calls to updateCluster. */
  public UnaryCallSettings<Cluster, Operation> updateClusterSettings() {
    return ((BigtableInstanceAdminStubSettings) getStubSettings()).updateClusterSettings();
  }

  /** Returns the object with the settings used for calls to updateCluster. */
  public OperationCallSettings<Cluster, Cluster, UpdateClusterMetadata>
      updateClusterOperationSettings() {
    return ((BigtableInstanceAdminStubSettings) getStubSettings()).updateClusterOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteCluster. */
  public UnaryCallSettings<DeleteClusterRequest, Empty> deleteClusterSettings() {
    return ((BigtableInstanceAdminStubSettings) getStubSettings()).deleteClusterSettings();
  }

  /** Returns the object with the settings used for calls to createAppProfile. */
  public UnaryCallSettings<CreateAppProfileRequest, AppProfile> createAppProfileSettings() {
    return ((BigtableInstanceAdminStubSettings) getStubSettings()).createAppProfileSettings();
  }

  /** Returns the object with the settings used for calls to getAppProfile. */
  public UnaryCallSettings<GetAppProfileRequest, AppProfile> getAppProfileSettings() {
    return ((BigtableInstanceAdminStubSettings) getStubSettings()).getAppProfileSettings();
  }

  /** Returns the object with the settings used for calls to listAppProfiles. */
  public PagedCallSettings<
          ListAppProfilesRequest, ListAppProfilesResponse, ListAppProfilesPagedResponse>
      listAppProfilesSettings() {
    return ((BigtableInstanceAdminStubSettings) getStubSettings()).listAppProfilesSettings();
  }

  /** Returns the object with the settings used for calls to updateAppProfile. */
  public UnaryCallSettings<UpdateAppProfileRequest, Operation> updateAppProfileSettings() {
    return ((BigtableInstanceAdminStubSettings) getStubSettings()).updateAppProfileSettings();
  }

  /** Returns the object with the settings used for calls to updateAppProfile. */
  public OperationCallSettings<UpdateAppProfileRequest, AppProfile, UpdateAppProfileMetadata>
      updateAppProfileOperationSettings() {
    return ((BigtableInstanceAdminStubSettings) getStubSettings())
        .updateAppProfileOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteAppProfile. */
  public UnaryCallSettings<DeleteAppProfileRequest, Empty> deleteAppProfileSettings() {
    return ((BigtableInstanceAdminStubSettings) getStubSettings()).deleteAppProfileSettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return ((BigtableInstanceAdminStubSettings) getStubSettings()).getIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return ((BigtableInstanceAdminStubSettings) getStubSettings()).setIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return ((BigtableInstanceAdminStubSettings) getStubSettings()).testIamPermissionsSettings();
  }

  public static final BaseBigtableInstanceAdminSettings create(
      BigtableInstanceAdminStubSettings stub) throws IOException {
    return new BaseBigtableInstanceAdminSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return BigtableInstanceAdminStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return BigtableInstanceAdminStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return BigtableInstanceAdminStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return BigtableInstanceAdminStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return BigtableInstanceAdminStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return BigtableInstanceAdminStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return BigtableInstanceAdminStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected BaseBigtableInstanceAdminSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for BaseBigtableInstanceAdminSettings. */
  public static class Builder
      extends ClientSettings.Builder<BaseBigtableInstanceAdminSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(BigtableInstanceAdminStubSettings.newBuilder(clientContext));
    }

    protected Builder(BaseBigtableInstanceAdminSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(BigtableInstanceAdminStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(BigtableInstanceAdminStubSettings.newBuilder());
    }

    public BigtableInstanceAdminStubSettings.Builder getStubSettingsBuilder() {
      return ((BigtableInstanceAdminStubSettings.Builder) getStubSettings());
    }

    // NEXT_MAJOR_VER: remove 'throws Exception'.
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

    /** Returns the builder for the settings used for calls to createInstance. */
    public UnaryCallSettings.Builder<CreateInstanceRequest, Operation> createInstanceSettings() {
      return getStubSettingsBuilder().createInstanceSettings();
    }

    /** Returns the builder for the settings used for calls to createInstance. */
    public OperationCallSettings.Builder<CreateInstanceRequest, Instance, CreateInstanceMetadata>
        createInstanceOperationSettings() {
      return getStubSettingsBuilder().createInstanceOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getInstance. */
    public UnaryCallSettings.Builder<GetInstanceRequest, Instance> getInstanceSettings() {
      return getStubSettingsBuilder().getInstanceSettings();
    }

    /** Returns the builder for the settings used for calls to listInstances. */
    public UnaryCallSettings.Builder<ListInstancesRequest, ListInstancesResponse>
        listInstancesSettings() {
      return getStubSettingsBuilder().listInstancesSettings();
    }

    /** Returns the builder for the settings used for calls to partialUpdateInstance. */
    public UnaryCallSettings.Builder<PartialUpdateInstanceRequest, Operation>
        partialUpdateInstanceSettings() {
      return getStubSettingsBuilder().partialUpdateInstanceSettings();
    }

    /** Returns the builder for the settings used for calls to partialUpdateInstance. */
    public OperationCallSettings.Builder<
            PartialUpdateInstanceRequest, Instance, UpdateInstanceMetadata>
        partialUpdateInstanceOperationSettings() {
      return getStubSettingsBuilder().partialUpdateInstanceOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteInstance. */
    public UnaryCallSettings.Builder<DeleteInstanceRequest, Empty> deleteInstanceSettings() {
      return getStubSettingsBuilder().deleteInstanceSettings();
    }

    /** Returns the builder for the settings used for calls to createCluster. */
    public UnaryCallSettings.Builder<CreateClusterRequest, Operation> createClusterSettings() {
      return getStubSettingsBuilder().createClusterSettings();
    }

    /** Returns the builder for the settings used for calls to createCluster. */
    public OperationCallSettings.Builder<CreateClusterRequest, Cluster, CreateClusterMetadata>
        createClusterOperationSettings() {
      return getStubSettingsBuilder().createClusterOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getCluster. */
    public UnaryCallSettings.Builder<GetClusterRequest, Cluster> getClusterSettings() {
      return getStubSettingsBuilder().getClusterSettings();
    }

    /** Returns the builder for the settings used for calls to listClusters. */
    public UnaryCallSettings.Builder<ListClustersRequest, ListClustersResponse>
        listClustersSettings() {
      return getStubSettingsBuilder().listClustersSettings();
    }

    /** Returns the builder for the settings used for calls to updateCluster. */
    public UnaryCallSettings.Builder<Cluster, Operation> updateClusterSettings() {
      return getStubSettingsBuilder().updateClusterSettings();
    }

    /** Returns the builder for the settings used for calls to updateCluster. */
    public OperationCallSettings.Builder<Cluster, Cluster, UpdateClusterMetadata>
        updateClusterOperationSettings() {
      return getStubSettingsBuilder().updateClusterOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteCluster. */
    public UnaryCallSettings.Builder<DeleteClusterRequest, Empty> deleteClusterSettings() {
      return getStubSettingsBuilder().deleteClusterSettings();
    }

    /** Returns the builder for the settings used for calls to createAppProfile. */
    public UnaryCallSettings.Builder<CreateAppProfileRequest, AppProfile>
        createAppProfileSettings() {
      return getStubSettingsBuilder().createAppProfileSettings();
    }

    /** Returns the builder for the settings used for calls to getAppProfile. */
    public UnaryCallSettings.Builder<GetAppProfileRequest, AppProfile> getAppProfileSettings() {
      return getStubSettingsBuilder().getAppProfileSettings();
    }

    /** Returns the builder for the settings used for calls to listAppProfiles. */
    public PagedCallSettings.Builder<
            ListAppProfilesRequest, ListAppProfilesResponse, ListAppProfilesPagedResponse>
        listAppProfilesSettings() {
      return getStubSettingsBuilder().listAppProfilesSettings();
    }

    /** Returns the builder for the settings used for calls to updateAppProfile. */
    public UnaryCallSettings.Builder<UpdateAppProfileRequest, Operation>
        updateAppProfileSettings() {
      return getStubSettingsBuilder().updateAppProfileSettings();
    }

    /** Returns the builder for the settings used for calls to updateAppProfile. */
    public OperationCallSettings.Builder<
            UpdateAppProfileRequest, AppProfile, UpdateAppProfileMetadata>
        updateAppProfileOperationSettings() {
      return getStubSettingsBuilder().updateAppProfileOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteAppProfile. */
    public UnaryCallSettings.Builder<DeleteAppProfileRequest, Empty> deleteAppProfileSettings() {
      return getStubSettingsBuilder().deleteAppProfileSettings();
    }

    /** Returns the builder for the settings used for calls to getIamPolicy. */
    public UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings() {
      return getStubSettingsBuilder().getIamPolicySettings();
    }

    /** Returns the builder for the settings used for calls to setIamPolicy. */
    public UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings() {
      return getStubSettingsBuilder().setIamPolicySettings();
    }

    /** Returns the builder for the settings used for calls to testIamPermissions. */
    public UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings() {
      return getStubSettingsBuilder().testIamPermissionsSettings();
    }

    @Override
    public BaseBigtableInstanceAdminSettings build() throws IOException {
      return new BaseBigtableInstanceAdminSettings(this);
    }
  }
}
