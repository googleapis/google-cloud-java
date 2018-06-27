package com.google.cloud.bigtable.admin.v2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.core.SettableApiFuture;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.bigtable.admin.v2.AppProfileName;
import com.google.bigtable.admin.v2.ClusterName;
import com.google.bigtable.admin.v2.CreateClusterMetadata;
import com.google.bigtable.admin.v2.CreateClusterRequest;
import com.google.bigtable.admin.v2.CreateInstanceMetadata;
import com.google.bigtable.admin.v2.DeleteAppProfileRequest;
import com.google.bigtable.admin.v2.DeleteClusterRequest;
import com.google.bigtable.admin.v2.DeleteInstanceRequest;
import com.google.bigtable.admin.v2.GetAppProfileRequest;
import com.google.bigtable.admin.v2.GetClusterRequest;
import com.google.bigtable.admin.v2.GetInstanceRequest;
import com.google.bigtable.admin.v2.InstanceName;
import com.google.bigtable.admin.v2.ListAppProfilesRequest;
import com.google.bigtable.admin.v2.ListAppProfilesResponse;
import com.google.bigtable.admin.v2.ListClustersRequest;
import com.google.bigtable.admin.v2.ListClustersResponse;
import com.google.bigtable.admin.v2.ListInstancesRequest;
import com.google.bigtable.admin.v2.ListInstancesResponse;
import com.google.bigtable.admin.v2.PartialUpdateInstanceRequest;
import com.google.bigtable.admin.v2.ProjectName;
import com.google.bigtable.admin.v2.UpdateAppProfileMetadata;
import com.google.bigtable.admin.v2.UpdateAppProfileRequest;
import com.google.bigtable.admin.v2.UpdateClusterMetadata;
import com.google.bigtable.admin.v2.UpdateInstanceMetadata;
import com.google.cloud.bigtable.admin.v2.models.InstanceAdminRequests;
import com.google.cloud.bigtable.admin.v2.models.InstanceAdminRequests.AppProfile;
import com.google.cloud.bigtable.admin.v2.models.InstanceAdminRequests.Cluster;
import com.google.cloud.bigtable.admin.v2.models.InstanceAdminRequests.CreateAppProfile;
import com.google.cloud.bigtable.admin.v2.models.InstanceAdminRequests.CreateInstance;
import com.google.cloud.bigtable.admin.v2.models.InstanceAdminRequests.Instance;
import com.google.cloud.bigtable.admin.v2.models.InstanceAdminRequests.Policy;
import com.google.cloud.bigtable.admin.v2.stub.BigtableInstanceAdminStub;
import com.google.cloud.bigtable.admin.v2.stub.BigtableInstanceAdminStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;

@BetaApi
public class InstanceAdminClient implements AutoCloseable {
  private final BigtableInstanceAdminStub stub;

  public static final InstanceAdminClient create() throws IOException {
    return new InstanceAdminClient(BigtableInstanceAdminSettings.newBuilder().build());
  }

  public static final InstanceAdminClient create(BigtableInstanceAdminSettings settings)
      throws IOException {
    return new InstanceAdminClient(settings);
  }

  public static final InstanceAdminClient create(BigtableInstanceAdminStub stub) {
    return new InstanceAdminClient(stub);
  }

  public InstanceAdminClient(BigtableInstanceAdminSettings settings) throws IOException {
    this(((BigtableInstanceAdminStubSettings) settings.getStubSettings()).createStub());
  }

  public InstanceAdminClient(BigtableInstanceAdminStub stub) {
    this.stub = stub;
  }

  @Override
  public void close() throws Exception {
    stub.close();
  }

  /** Discuss: need for CreateInstance wrapper */
  public ApiFuture<Instance> createInstanceAsync(CreateInstance createInstance) {
    final OperationFuture<com.google.bigtable.admin.v2.Instance, CreateInstanceMetadata> future =
        stub.createInstanceOperationCallable().futureCall(createInstance.toProto());

    return transfromOperationFuture(
        future,
        new ApiFunction<com.google.bigtable.admin.v2.Instance, Instance>() {
          @Override
          public Instance apply(com.google.bigtable.admin.v2.Instance input) {
            return InstanceAdminRequests.convertToInstance(input);
          }
        });
  }

  public Instance getInstance(InstanceName instanceName) {
    return InstanceAdminRequests.convertToInstance(
        stub.getInstanceCallable().call(composeGetInstanceRequest(instanceName)));
  }

  public List<Instance> listInstances(ProjectName projectName) {
    return convertToInstances(
        stub.listInstancesCallable().call(composeListInstanceRequest(projectName)));
  }

  public ApiFuture<Instance> updateInstance(Instance updatedInstance) {
    OperationFuture<com.google.bigtable.admin.v2.Instance, UpdateInstanceMetadata> future =
        stub.partialUpdateInstanceOperationCallable()
            .futureCall(composePartialUpdateInstanceCallable(updatedInstance));

    return transfromOperationFuture(
        future,
        new ApiFunction<com.google.bigtable.admin.v2.Instance, Instance>() {
          @Override
          public Instance apply(com.google.bigtable.admin.v2.Instance input) {
            return InstanceAdminRequests.convertToInstance(input);
          }
        });
  }

  public void deleteInstanceRequest(InstanceName instanceName) {
    stub.deleteInstanceCallable().call(composeDeleteInstanceRequest(instanceName));
  }

  public ApiFuture<Cluster> createCluster(InstanceName instanceName, Cluster cluster) {
    OperationFuture<com.google.bigtable.admin.v2.Cluster, CreateClusterMetadata> future =
        stub.createClusterOperationCallable()
            .futureCall(composeCreateClusterRequest(instanceName, cluster));

    return transfromOperationFuture(
        future,
        new ApiFunction<com.google.bigtable.admin.v2.Cluster, Cluster>() {
          @Override
          public Cluster apply(com.google.bigtable.admin.v2.Cluster input) {
            return InstanceAdminRequests.convertToCluster(input);
          }
        });
  }

  public Cluster getCluster(ClusterName clusterName) {
    return InstanceAdminRequests.convertToCluster(
        stub.getClusterCallable().call(composeGetClusterRequest(clusterName)));
  }

  public List<Cluster> listClusters(InstanceName instanceName) {
    return convertToClusters(
        stub.listClustersCallable().call(composeListClustersRequest(instanceName)));
  }

  public ApiFuture<Cluster> updateCluster(Cluster updatedCluster) {
    OperationFuture<com.google.bigtable.admin.v2.Cluster, UpdateClusterMetadata> future =
        stub.updateClusterOperationCallable().futureCall(updatedCluster.toUpdateProto());

    return transfromOperationFuture(
        future,
        new ApiFunction<com.google.bigtable.admin.v2.Cluster, Cluster>() {
          @Override
          public Cluster apply(com.google.bigtable.admin.v2.Cluster input) {
            return InstanceAdminRequests.convertToCluster(input);
          }
        });
  }

  public void deleteCluster(ClusterName clusterName) {
    stub.deleteClusterCallable().call(composeDeleteClusterRequest(clusterName));
  }

  /** Discuss: need for CreateAppProfile wrapper */
  public AppProfile createAppProfile(CreateAppProfile createAppProfile) {
    return InstanceAdminRequests.convertToAppProfile(
        stub.createAppProfileCallable().call(createAppProfile.toProto()));
  }

  public AppProfile getAppProfile(AppProfileName appProfileName) {
    return InstanceAdminRequests.convertToAppProfile(
        stub.getAppProfileCallable().call(composeGetAppProfileRequest(appProfileName)));
  }

  public List<AppProfile> listAppProfiles(InstanceName instanceName) {
    return convertToAppProfiles(
        stub.listAppProfilesCallable().call(composeListAppProfilesRequest(instanceName)));
  }

  public ApiFuture<AppProfile> updateAppProfile(AppProfile appProfile) {
    OperationFuture<com.google.bigtable.admin.v2.AppProfile, UpdateAppProfileMetadata> future =
        stub.updateAppProfileOperationCallable()
            .futureCall(composeUpdateAppProfileRequest(appProfile));

    return transfromOperationFuture(
        future,
        new ApiFunction<com.google.bigtable.admin.v2.AppProfile, AppProfile>() {
          @Override
          public AppProfile apply(com.google.bigtable.admin.v2.AppProfile input) {
            return InstanceAdminRequests.convertToAppProfile(input);
          }
        });
  }

  public void deleteAppProfile(AppProfileName appProfileName, boolean ignoreWarnings) {
    stub.deleteAppProfileCallable()
        .call(composeDeleteAppProfileRequest(appProfileName, ignoreWarnings));
  }

  public Policy getIamPolicy(InstanceName instanceName) {
    return InstanceAdminRequests.convertToPolicy(
        stub.getIamPolicyCallable().call(composeGetIamPolicyRequest(instanceName)));
  }

  public Policy setIamPolicy(InstanceName instanceName, Policy policy) {
    return InstanceAdminRequests.convertToPolicy(
        stub.setIamPolicyCallable().call(composeSetIamPolicyRequest(instanceName, policy)));
  }

  public List<String> testIamPermissions(InstanceName instanceName, List<String> permissions) {
    return stub.testIamPermissionsCallable()
        .call(composeTestIamPermissionsRequest(instanceName, permissions))
        .getPermissionsList();
  }

  /** compose proto request helpers * */
  private static GetInstanceRequest composeGetInstanceRequest(InstanceName instanceName) {
    return GetInstanceRequest.newBuilder().setName(instanceName.toString()).build();
  }

  private static ListInstancesRequest composeListInstanceRequest(ProjectName projectName) {
    return ListInstancesRequest.newBuilder().setParent(projectName.toString()).build();
  }

  private static PartialUpdateInstanceRequest composePartialUpdateInstanceCallable(
      Instance updatedInstance) {
    return PartialUpdateInstanceRequest.newBuilder()
        .setInstance(updatedInstance.toUpdateProto())
        .setUpdateMask(updatedInstance.getPartialUpdateFieldMask())
        .build();
  }

  private static DeleteInstanceRequest composeDeleteInstanceRequest(InstanceName instanceName) {
    return DeleteInstanceRequest.newBuilder().setName(instanceName.toString()).build();
  }

  private static CreateClusterRequest composeCreateClusterRequest(
      InstanceName instanceName, Cluster cluster) {
    return CreateClusterRequest.newBuilder()
        .setParent(instanceName.toString())
        .setClusterId(cluster.getId())
        .setCluster(cluster.toProto())
        .build();
  }

  private static GetClusterRequest composeGetClusterRequest(ClusterName clusterName) {
    return GetClusterRequest.newBuilder().setName(clusterName.toString()).build();
  }

  private static ListClustersRequest composeListClustersRequest(InstanceName instanceName) {
    return ListClustersRequest.newBuilder().setParent(instanceName.toString()).build();
  }

  private static DeleteClusterRequest composeDeleteClusterRequest(ClusterName clusterName) {
    return DeleteClusterRequest.newBuilder().setName(clusterName.toString()).build();
  }

  private static GetAppProfileRequest composeGetAppProfileRequest(AppProfileName appProfileName) {
    return GetAppProfileRequest.newBuilder().setName(appProfileName.toString()).build();
  }

  private static ListAppProfilesRequest composeListAppProfilesRequest(InstanceName instanceName) {
    return ListAppProfilesRequest.newBuilder().setParent(instanceName.toString()).build();
  }

  private static UpdateAppProfileRequest composeUpdateAppProfileRequest(AppProfile appProfile) {
    return UpdateAppProfileRequest.newBuilder()
        .setAppProfile(appProfile.toUpdateProto())
        .setUpdateMask(appProfile.getPartialUpdateFieldMask())
        .build();
  }

  private static DeleteAppProfileRequest composeDeleteAppProfileRequest(
      AppProfileName appProfileName, boolean ignoreWarnings) {
    return DeleteAppProfileRequest.newBuilder()
        .setName(appProfileName.toString())
        .setIgnoreWarnings(ignoreWarnings)
        .build();
  }

  private static GetIamPolicyRequest composeGetIamPolicyRequest(InstanceName instanceName) {
    return GetIamPolicyRequest.newBuilder().setResource(instanceName.toString()).build();
  }

  private static SetIamPolicyRequest composeSetIamPolicyRequest(
      InstanceName instanceName, Policy policy) {
    return SetIamPolicyRequest.newBuilder()
        .setResource(instanceName.toString())
        .setPolicy(policy.toProto())
        .build();
  }

  private static TestIamPermissionsRequest composeTestIamPermissionsRequest(
      InstanceName instanceName, List<String> permissions) {
    return TestIamPermissionsRequest.newBuilder()
        .setResource(instanceName.toString())
        .addAllPermissions(permissions)
        .build();
  }

  private static List<Instance> convertToInstances(ListInstancesResponse listInstancesResponse) {
    List<Instance> instances = new ArrayList<>();

    for (com.google.bigtable.admin.v2.Instance instance :
        listInstancesResponse.getInstancesList()) {
      instances.add(InstanceAdminRequests.convertToInstance(instance));
    }
    // TODO: handle failed_locations
    return instances;
  }

  private static List<Cluster> convertToClusters(ListClustersResponse listClustersResponse) {
    List<Cluster> clusters = new ArrayList<>();

    for (com.google.bigtable.admin.v2.Cluster cluster : listClustersResponse.getClustersList()) {
      clusters.add(InstanceAdminRequests.convertToCluster(cluster));
    }

    // TODO: Trying a simple approach to handle these for now
    for (String failedLocation : listClustersResponse.getFailedLocationsList()) {
      clusters.add(InstanceAdminRequests.convertToFailedCluster(failedLocation));
    }
    return clusters;
  }

  private static List<AppProfile> convertToAppProfiles(
      ListAppProfilesResponse listAppProfilesResponse) {
    List<AppProfile> appProfiles = new ArrayList<>();

    for (com.google.bigtable.admin.v2.AppProfile profile :
        listAppProfilesResponse.getAppProfilesList()) {
      appProfiles.add(InstanceAdminRequests.convertToAppProfile(profile));
    }
    return appProfiles;
  }

  /** Can be removed after https://github.com/googleapis/gax-java/issues/552 is handled */
  private static <V, M, X> ApiFuture<X> transfromOperationFuture(
      final OperationFuture<? extends V, M> future,
      final ApiFunction<? super V, ? extends X> function) {
    final SettableApiFuture<X> result = SettableApiFuture.create();
    future.addListener(
        new Runnable() {
          @Override
          public void run() {
            try {
              result.set(function.apply(future.get()));
            } catch (InterruptedException | ExecutionException e) {
              result.setException(e);
            }
          }
        },
        MoreExecutors.directExecutor());
    return result;
  }
}
