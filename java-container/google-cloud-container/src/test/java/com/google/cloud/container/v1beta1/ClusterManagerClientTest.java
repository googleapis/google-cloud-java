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

package com.google.cloud.container.v1beta1;

import static com.google.cloud.container.v1beta1.ClusterManagerClient.ListUsableSubnetworksPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.common.collect.Lists;
import com.google.container.v1beta1.AcceleratorConfig;
import com.google.container.v1beta1.AddonsConfig;
import com.google.container.v1beta1.AnonymousAuthenticationConfig;
import com.google.container.v1beta1.AuthenticatorGroupsConfig;
import com.google.container.v1beta1.Autopilot;
import com.google.container.v1beta1.AutopilotCompatibilityIssue;
import com.google.container.v1beta1.BestEffortProvisioning;
import com.google.container.v1beta1.BinaryAuthorization;
import com.google.container.v1beta1.BootDisk;
import com.google.container.v1beta1.CancelOperationRequest;
import com.google.container.v1beta1.CheckAutopilotCompatibilityRequest;
import com.google.container.v1beta1.CheckAutopilotCompatibilityResponse;
import com.google.container.v1beta1.Cluster;
import com.google.container.v1beta1.ClusterAutoscaling;
import com.google.container.v1beta1.ClusterTelemetry;
import com.google.container.v1beta1.ClusterUpdate;
import com.google.container.v1beta1.ClusterUpgradeInfo;
import com.google.container.v1beta1.CompleteIPRotationRequest;
import com.google.container.v1beta1.CompleteNodePoolUpgradeRequest;
import com.google.container.v1beta1.CompliancePostureConfig;
import com.google.container.v1beta1.ConfidentialNodes;
import com.google.container.v1beta1.ContainerdConfig;
import com.google.container.v1beta1.ControlPlaneEndpointsConfig;
import com.google.container.v1beta1.CostManagementConfig;
import com.google.container.v1beta1.CreateClusterRequest;
import com.google.container.v1beta1.CreateNodePoolRequest;
import com.google.container.v1beta1.DatabaseEncryption;
import com.google.container.v1beta1.DeleteClusterRequest;
import com.google.container.v1beta1.DeleteNodePoolRequest;
import com.google.container.v1beta1.EnterpriseConfig;
import com.google.container.v1beta1.FastSocket;
import com.google.container.v1beta1.FetchClusterUpgradeInfoRequest;
import com.google.container.v1beta1.FetchNodePoolUpgradeInfoRequest;
import com.google.container.v1beta1.Fleet;
import com.google.container.v1beta1.GcfsConfig;
import com.google.container.v1beta1.GetClusterRequest;
import com.google.container.v1beta1.GetJSONWebKeysRequest;
import com.google.container.v1beta1.GetJSONWebKeysResponse;
import com.google.container.v1beta1.GetNodePoolRequest;
import com.google.container.v1beta1.GetOperationRequest;
import com.google.container.v1beta1.GetServerConfigRequest;
import com.google.container.v1beta1.GkeAutoUpgradeConfig;
import com.google.container.v1beta1.IPAllocationPolicy;
import com.google.container.v1beta1.IdentityServiceConfig;
import com.google.container.v1beta1.Jwk;
import com.google.container.v1beta1.K8sBetaAPIConfig;
import com.google.container.v1beta1.LegacyAbac;
import com.google.container.v1beta1.LinuxNodeConfig;
import com.google.container.v1beta1.ListClustersRequest;
import com.google.container.v1beta1.ListClustersResponse;
import com.google.container.v1beta1.ListLocationsRequest;
import com.google.container.v1beta1.ListLocationsResponse;
import com.google.container.v1beta1.ListNodePoolsRequest;
import com.google.container.v1beta1.ListNodePoolsResponse;
import com.google.container.v1beta1.ListOperationsRequest;
import com.google.container.v1beta1.ListOperationsResponse;
import com.google.container.v1beta1.ListUsableSubnetworksRequest;
import com.google.container.v1beta1.ListUsableSubnetworksResponse;
import com.google.container.v1beta1.Location;
import com.google.container.v1beta1.LoggingConfig;
import com.google.container.v1beta1.MaintenancePolicy;
import com.google.container.v1beta1.Master;
import com.google.container.v1beta1.MasterAuth;
import com.google.container.v1beta1.MasterAuthorizedNetworksConfig;
import com.google.container.v1beta1.MaxPodsConstraint;
import com.google.container.v1beta1.MeshCertificates;
import com.google.container.v1beta1.MonitoringConfig;
import com.google.container.v1beta1.NetworkConfig;
import com.google.container.v1beta1.NetworkPolicy;
import com.google.container.v1beta1.NetworkTags;
import com.google.container.v1beta1.NodeConfig;
import com.google.container.v1beta1.NodeKubeletConfig;
import com.google.container.v1beta1.NodeLabels;
import com.google.container.v1beta1.NodeManagement;
import com.google.container.v1beta1.NodeNetworkConfig;
import com.google.container.v1beta1.NodePool;
import com.google.container.v1beta1.NodePoolAutoConfig;
import com.google.container.v1beta1.NodePoolAutoscaling;
import com.google.container.v1beta1.NodePoolDefaults;
import com.google.container.v1beta1.NodePoolLoggingConfig;
import com.google.container.v1beta1.NodePoolUpgradeInfo;
import com.google.container.v1beta1.NodeTaints;
import com.google.container.v1beta1.NotificationConfig;
import com.google.container.v1beta1.Operation;
import com.google.container.v1beta1.OperationProgress;
import com.google.container.v1beta1.PodAutoscaling;
import com.google.container.v1beta1.PodSecurityPolicyConfig;
import com.google.container.v1beta1.PrivateClusterConfig;
import com.google.container.v1beta1.ProtectConfig;
import com.google.container.v1beta1.RBACBindingConfig;
import com.google.container.v1beta1.ReleaseChannel;
import com.google.container.v1beta1.ResourceLabels;
import com.google.container.v1beta1.ResourceManagerTags;
import com.google.container.v1beta1.ResourceUsageExportConfig;
import com.google.container.v1beta1.RollbackNodePoolUpgradeRequest;
import com.google.container.v1beta1.SecretManagerConfig;
import com.google.container.v1beta1.SecurityPostureConfig;
import com.google.container.v1beta1.ServerConfig;
import com.google.container.v1beta1.SetAddonsConfigRequest;
import com.google.container.v1beta1.SetLabelsRequest;
import com.google.container.v1beta1.SetLegacyAbacRequest;
import com.google.container.v1beta1.SetLocationsRequest;
import com.google.container.v1beta1.SetLoggingServiceRequest;
import com.google.container.v1beta1.SetMaintenancePolicyRequest;
import com.google.container.v1beta1.SetMasterAuthRequest;
import com.google.container.v1beta1.SetMonitoringServiceRequest;
import com.google.container.v1beta1.SetNetworkPolicyRequest;
import com.google.container.v1beta1.SetNodePoolAutoscalingRequest;
import com.google.container.v1beta1.SetNodePoolManagementRequest;
import com.google.container.v1beta1.SetNodePoolSizeRequest;
import com.google.container.v1beta1.ShieldedNodes;
import com.google.container.v1beta1.StartIPRotationRequest;
import com.google.container.v1beta1.StatusCondition;
import com.google.container.v1beta1.TpuConfig;
import com.google.container.v1beta1.UpdateClusterRequest;
import com.google.container.v1beta1.UpdateMasterRequest;
import com.google.container.v1beta1.UpdateNodePoolRequest;
import com.google.container.v1beta1.UpgradeDetails;
import com.google.container.v1beta1.UsableSubnetwork;
import com.google.container.v1beta1.UserManagedKeysConfig;
import com.google.container.v1beta1.VerticalPodAutoscaling;
import com.google.container.v1beta1.VirtualNIC;
import com.google.container.v1beta1.WindowsNodeConfig;
import com.google.container.v1beta1.WindowsVersions;
import com.google.container.v1beta1.WorkloadALTSConfig;
import com.google.container.v1beta1.WorkloadCertificates;
import com.google.container.v1beta1.WorkloadIdentityConfig;
import com.google.container.v1beta1.WorkloadMetadataConfig;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Duration;
import com.google.protobuf.Empty;
import com.google.rpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class ClusterManagerClientTest {
  private static MockClusterManager mockClusterManager;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private ClusterManagerClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockClusterManager = new MockClusterManager();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockClusterManager));
    mockServiceHelper.start();
  }

  @AfterClass
  public static void stopServer() {
    mockServiceHelper.stop();
  }

  @Before
  public void setUp() throws IOException {
    mockServiceHelper.reset();
    channelProvider = mockServiceHelper.createChannelProvider();
    ClusterManagerSettings settings =
        ClusterManagerSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ClusterManagerClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listClustersTest() throws Exception {
    ListClustersResponse expectedResponse =
        ListClustersResponse.newBuilder()
            .addAllClusters(new ArrayList<Cluster>())
            .addAllMissingZones(new ArrayList<String>())
            .build();
    mockClusterManager.addResponse(expectedResponse);

    String projectId = "projectId-894832108";
    String zone = "zone3744684";

    ListClustersResponse actualResponse = client.listClusters(projectId, zone);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockClusterManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListClustersRequest actualRequest = ((ListClustersRequest) actualRequests.get(0));

    Assert.assertEquals(projectId, actualRequest.getProjectId());
    Assert.assertEquals(zone, actualRequest.getZone());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listClustersExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockClusterManager.addException(exception);

    try {
      String projectId = "projectId-894832108";
      String zone = "zone3744684";
      client.listClusters(projectId, zone);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getClusterTest() throws Exception {
    Cluster expectedResponse =
        Cluster.newBuilder()
            .setName("name3373707")
            .setDescription("description-1724546052")
            .setInitialNodeCount(1682564205)
            .setNodeConfig(NodeConfig.newBuilder().build())
            .setMasterAuth(MasterAuth.newBuilder().build())
            .setLoggingService("loggingService1098570326")
            .setMonitoringService("monitoringService-1431578291")
            .setNetwork("network1843485230")
            .setClusterIpv4Cidr("clusterIpv4Cidr-277423341")
            .setAddonsConfig(AddonsConfig.newBuilder().build())
            .setSubnetwork("subnetwork-1302785042")
            .addAllNodePools(new ArrayList<NodePool>())
            .addAllLocations(new ArrayList<String>())
            .setEnableKubernetesAlpha(true)
            .addAllAlphaClusterFeatureGates(new ArrayList<String>())
            .setEnableK8SBetaApis(K8sBetaAPIConfig.newBuilder().build())
            .putAllResourceLabels(new HashMap<String, String>())
            .setLabelFingerprint("labelFingerprint379449680")
            .setLegacyAbac(LegacyAbac.newBuilder().build())
            .setNetworkPolicy(NetworkPolicy.newBuilder().build())
            .setIpAllocationPolicy(IPAllocationPolicy.newBuilder().build())
            .setMasterAuthorizedNetworksConfig(MasterAuthorizedNetworksConfig.newBuilder().build())
            .setMaintenancePolicy(MaintenancePolicy.newBuilder().build())
            .setBinaryAuthorization(BinaryAuthorization.newBuilder().build())
            .setPodSecurityPolicyConfig(PodSecurityPolicyConfig.newBuilder().build())
            .setAutoscaling(ClusterAutoscaling.newBuilder().build())
            .setNetworkConfig(NetworkConfig.newBuilder().build())
            .setPrivateCluster(true)
            .setMasterIpv4CidrBlock("masterIpv4CidrBlock42581458")
            .setDefaultMaxPodsConstraint(MaxPodsConstraint.newBuilder().build())
            .setResourceUsageExportConfig(ResourceUsageExportConfig.newBuilder().build())
            .setAuthenticatorGroupsConfig(AuthenticatorGroupsConfig.newBuilder().build())
            .setPrivateClusterConfig(PrivateClusterConfig.newBuilder().build())
            .setVerticalPodAutoscaling(VerticalPodAutoscaling.newBuilder().build())
            .setShieldedNodes(ShieldedNodes.newBuilder().build())
            .setReleaseChannel(ReleaseChannel.newBuilder().build())
            .setWorkloadIdentityConfig(WorkloadIdentityConfig.newBuilder().build())
            .setWorkloadCertificates(WorkloadCertificates.newBuilder().build())
            .setMeshCertificates(MeshCertificates.newBuilder().build())
            .setWorkloadAltsConfig(WorkloadALTSConfig.newBuilder().build())
            .setCostManagementConfig(CostManagementConfig.newBuilder().build())
            .setClusterTelemetry(ClusterTelemetry.newBuilder().build())
            .setTpuConfig(TpuConfig.newBuilder().build())
            .setNotificationConfig(NotificationConfig.newBuilder().build())
            .setConfidentialNodes(ConfidentialNodes.newBuilder().build())
            .setIdentityServiceConfig(IdentityServiceConfig.newBuilder().build())
            .setSelfLink("selfLink1191800166")
            .setZone("zone3744684")
            .setEndpoint("endpoint1741102485")
            .setInitialClusterVersion("initialClusterVersion-1547734558")
            .setCurrentMasterVersion("currentMasterVersion1871927069")
            .setCurrentNodeVersion("currentNodeVersion373921085")
            .setCreateTime("createTime1369213417")
            .setStatusMessage("statusMessage-958704715")
            .setNodeIpv4CidrSize(1181176815)
            .setServicesIpv4Cidr("servicesIpv4Cidr-1785842313")
            .addAllInstanceGroupUrls(new ArrayList<String>())
            .setCurrentNodeCount(178977560)
            .setExpireTime("expireTime-834724724")
            .setLocation("location1901043637")
            .setEnableTpu(true)
            .setTpuIpv4CidrBlock("tpuIpv4CidrBlock997172251")
            .setDatabaseEncryption(DatabaseEncryption.newBuilder().build())
            .addAllConditions(new ArrayList<StatusCondition>())
            .setMaster(Master.newBuilder().build())
            .setAutopilot(Autopilot.newBuilder().build())
            .setId("id3355")
            .setNodePoolDefaults(NodePoolDefaults.newBuilder().build())
            .setLoggingConfig(LoggingConfig.newBuilder().build())
            .setMonitoringConfig(MonitoringConfig.newBuilder().build())
            .setNodePoolAutoConfig(NodePoolAutoConfig.newBuilder().build())
            .setProtectConfig(ProtectConfig.newBuilder().build())
            .setPodAutoscaling(PodAutoscaling.newBuilder().build())
            .setEtag("etag3123477")
            .setFleet(Fleet.newBuilder().build())
            .setSecurityPostureConfig(SecurityPostureConfig.newBuilder().build())
            .setControlPlaneEndpointsConfig(ControlPlaneEndpointsConfig.newBuilder().build())
            .setEnterpriseConfig(EnterpriseConfig.newBuilder().build())
            .setSecretManagerConfig(SecretManagerConfig.newBuilder().build())
            .setCompliancePostureConfig(CompliancePostureConfig.newBuilder().build())
            .setSatisfiesPzs(true)
            .setSatisfiesPzi(true)
            .setUserManagedKeysConfig(UserManagedKeysConfig.newBuilder().build())
            .setRbacBindingConfig(RBACBindingConfig.newBuilder().build())
            .setGkeAutoUpgradeConfig(GkeAutoUpgradeConfig.newBuilder().build())
            .setAnonymousAuthenticationConfig(AnonymousAuthenticationConfig.newBuilder().build())
            .build();
    mockClusterManager.addResponse(expectedResponse);

    String projectId = "projectId-894832108";
    String zone = "zone3744684";
    String clusterId = "clusterId561939637";

    Cluster actualResponse = client.getCluster(projectId, zone, clusterId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockClusterManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetClusterRequest actualRequest = ((GetClusterRequest) actualRequests.get(0));

    Assert.assertEquals(projectId, actualRequest.getProjectId());
    Assert.assertEquals(zone, actualRequest.getZone());
    Assert.assertEquals(clusterId, actualRequest.getClusterId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getClusterExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockClusterManager.addException(exception);

    try {
      String projectId = "projectId-894832108";
      String zone = "zone3744684";
      String clusterId = "clusterId561939637";
      client.getCluster(projectId, zone, clusterId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createClusterTest() throws Exception {
    Operation expectedResponse =
        Operation.newBuilder()
            .setName("name3373707")
            .setZone("zone3744684")
            .setDetail("detail-1335224239")
            .setStatusMessage("statusMessage-958704715")
            .setSelfLink("selfLink1191800166")
            .setTargetLink("targetLink486368555")
            .setLocation("location1901043637")
            .setStartTime("startTime-2129294769")
            .setEndTime("endTime-1607243192")
            .setProgress(OperationProgress.newBuilder().build())
            .addAllClusterConditions(new ArrayList<StatusCondition>())
            .addAllNodepoolConditions(new ArrayList<StatusCondition>())
            .setError(Status.newBuilder().build())
            .build();
    mockClusterManager.addResponse(expectedResponse);

    String projectId = "projectId-894832108";
    String zone = "zone3744684";
    Cluster cluster = Cluster.newBuilder().build();

    Operation actualResponse = client.createCluster(projectId, zone, cluster);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockClusterManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateClusterRequest actualRequest = ((CreateClusterRequest) actualRequests.get(0));

    Assert.assertEquals(projectId, actualRequest.getProjectId());
    Assert.assertEquals(zone, actualRequest.getZone());
    Assert.assertEquals(cluster, actualRequest.getCluster());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createClusterExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockClusterManager.addException(exception);

    try {
      String projectId = "projectId-894832108";
      String zone = "zone3744684";
      Cluster cluster = Cluster.newBuilder().build();
      client.createCluster(projectId, zone, cluster);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateClusterTest() throws Exception {
    Operation expectedResponse =
        Operation.newBuilder()
            .setName("name3373707")
            .setZone("zone3744684")
            .setDetail("detail-1335224239")
            .setStatusMessage("statusMessage-958704715")
            .setSelfLink("selfLink1191800166")
            .setTargetLink("targetLink486368555")
            .setLocation("location1901043637")
            .setStartTime("startTime-2129294769")
            .setEndTime("endTime-1607243192")
            .setProgress(OperationProgress.newBuilder().build())
            .addAllClusterConditions(new ArrayList<StatusCondition>())
            .addAllNodepoolConditions(new ArrayList<StatusCondition>())
            .setError(Status.newBuilder().build())
            .build();
    mockClusterManager.addResponse(expectedResponse);

    String projectId = "projectId-894832108";
    String zone = "zone3744684";
    String clusterId = "clusterId561939637";
    ClusterUpdate update = ClusterUpdate.newBuilder().build();

    Operation actualResponse = client.updateCluster(projectId, zone, clusterId, update);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockClusterManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateClusterRequest actualRequest = ((UpdateClusterRequest) actualRequests.get(0));

    Assert.assertEquals(projectId, actualRequest.getProjectId());
    Assert.assertEquals(zone, actualRequest.getZone());
    Assert.assertEquals(clusterId, actualRequest.getClusterId());
    Assert.assertEquals(update, actualRequest.getUpdate());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateClusterExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockClusterManager.addException(exception);

    try {
      String projectId = "projectId-894832108";
      String zone = "zone3744684";
      String clusterId = "clusterId561939637";
      ClusterUpdate update = ClusterUpdate.newBuilder().build();
      client.updateCluster(projectId, zone, clusterId, update);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateNodePoolTest() throws Exception {
    Operation expectedResponse =
        Operation.newBuilder()
            .setName("name3373707")
            .setZone("zone3744684")
            .setDetail("detail-1335224239")
            .setStatusMessage("statusMessage-958704715")
            .setSelfLink("selfLink1191800166")
            .setTargetLink("targetLink486368555")
            .setLocation("location1901043637")
            .setStartTime("startTime-2129294769")
            .setEndTime("endTime-1607243192")
            .setProgress(OperationProgress.newBuilder().build())
            .addAllClusterConditions(new ArrayList<StatusCondition>())
            .addAllNodepoolConditions(new ArrayList<StatusCondition>())
            .setError(Status.newBuilder().build())
            .build();
    mockClusterManager.addResponse(expectedResponse);

    UpdateNodePoolRequest request =
        UpdateNodePoolRequest.newBuilder()
            .setProjectId("projectId-894832108")
            .setZone("zone3744684")
            .setClusterId("clusterId561939637")
            .setNodePoolId("nodePoolId1121557241")
            .setNodeVersion("nodeVersion1155309686")
            .setImageType("imageType-878147787")
            .addAllLocations(new ArrayList<String>())
            .setWorkloadMetadataConfig(WorkloadMetadataConfig.newBuilder().build())
            .setName("name3373707")
            .setUpgradeSettings(NodePool.UpgradeSettings.newBuilder().build())
            .setTags(NetworkTags.newBuilder().build())
            .setTaints(NodeTaints.newBuilder().build())
            .setLabels(NodeLabels.newBuilder().build())
            .setLinuxNodeConfig(LinuxNodeConfig.newBuilder().build())
            .setKubeletConfig(NodeKubeletConfig.newBuilder().build())
            .setNodeNetworkConfig(NodeNetworkConfig.newBuilder().build())
            .setGcfsConfig(GcfsConfig.newBuilder().build())
            .setConfidentialNodes(ConfidentialNodes.newBuilder().build())
            .setGvnic(VirtualNIC.newBuilder().build())
            .setEtag("etag3123477")
            .setFastSocket(FastSocket.newBuilder().build())
            .setLoggingConfig(NodePoolLoggingConfig.newBuilder().build())
            .setResourceLabels(ResourceLabels.newBuilder().build())
            .setWindowsNodeConfig(WindowsNodeConfig.newBuilder().build())
            .addAllAccelerators(new ArrayList<AcceleratorConfig>())
            .setMachineType("machineType-218117087")
            .setDiskType("diskType279771767")
            .setDiskSizeGb(-757478089)
            .setResourceManagerTags(ResourceManagerTags.newBuilder().build())
            .setContainerdConfig(ContainerdConfig.newBuilder().build())
            .setQueuedProvisioning(NodePool.QueuedProvisioning.newBuilder().build())
            .addAllStoragePools(new ArrayList<String>())
            .setMaxRunDuration(Duration.newBuilder().build())
            .setFlexStart(true)
            .setBootDisk(BootDisk.newBuilder().build())
            .build();

    Operation actualResponse = client.updateNodePool(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockClusterManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateNodePoolRequest actualRequest = ((UpdateNodePoolRequest) actualRequests.get(0));

    Assert.assertEquals(request.getProjectId(), actualRequest.getProjectId());
    Assert.assertEquals(request.getZone(), actualRequest.getZone());
    Assert.assertEquals(request.getClusterId(), actualRequest.getClusterId());
    Assert.assertEquals(request.getNodePoolId(), actualRequest.getNodePoolId());
    Assert.assertEquals(request.getNodeVersion(), actualRequest.getNodeVersion());
    Assert.assertEquals(request.getImageType(), actualRequest.getImageType());
    Assert.assertEquals(request.getLocationsList(), actualRequest.getLocationsList());
    Assert.assertEquals(
        request.getWorkloadMetadataConfig(), actualRequest.getWorkloadMetadataConfig());
    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getUpgradeSettings(), actualRequest.getUpgradeSettings());
    Assert.assertEquals(request.getTags(), actualRequest.getTags());
    Assert.assertEquals(request.getTaints(), actualRequest.getTaints());
    Assert.assertEquals(request.getLabels(), actualRequest.getLabels());
    Assert.assertEquals(request.getLinuxNodeConfig(), actualRequest.getLinuxNodeConfig());
    Assert.assertEquals(request.getKubeletConfig(), actualRequest.getKubeletConfig());
    Assert.assertEquals(request.getNodeNetworkConfig(), actualRequest.getNodeNetworkConfig());
    Assert.assertEquals(request.getGcfsConfig(), actualRequest.getGcfsConfig());
    Assert.assertEquals(request.getConfidentialNodes(), actualRequest.getConfidentialNodes());
    Assert.assertEquals(request.getGvnic(), actualRequest.getGvnic());
    Assert.assertEquals(request.getEtag(), actualRequest.getEtag());
    Assert.assertEquals(request.getFastSocket(), actualRequest.getFastSocket());
    Assert.assertEquals(request.getLoggingConfig(), actualRequest.getLoggingConfig());
    Assert.assertEquals(request.getResourceLabels(), actualRequest.getResourceLabels());
    Assert.assertEquals(request.getWindowsNodeConfig(), actualRequest.getWindowsNodeConfig());
    Assert.assertEquals(request.getAcceleratorsList(), actualRequest.getAcceleratorsList());
    Assert.assertEquals(request.getMachineType(), actualRequest.getMachineType());
    Assert.assertEquals(request.getDiskType(), actualRequest.getDiskType());
    Assert.assertEquals(request.getDiskSizeGb(), actualRequest.getDiskSizeGb());
    Assert.assertEquals(request.getResourceManagerTags(), actualRequest.getResourceManagerTags());
    Assert.assertEquals(request.getContainerdConfig(), actualRequest.getContainerdConfig());
    Assert.assertEquals(request.getQueuedProvisioning(), actualRequest.getQueuedProvisioning());
    Assert.assertEquals(request.getStoragePoolsList(), actualRequest.getStoragePoolsList());
    Assert.assertEquals(request.getMaxRunDuration(), actualRequest.getMaxRunDuration());
    Assert.assertEquals(request.getFlexStart(), actualRequest.getFlexStart());
    Assert.assertEquals(request.getBootDisk(), actualRequest.getBootDisk());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateNodePoolExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockClusterManager.addException(exception);

    try {
      UpdateNodePoolRequest request =
          UpdateNodePoolRequest.newBuilder()
              .setProjectId("projectId-894832108")
              .setZone("zone3744684")
              .setClusterId("clusterId561939637")
              .setNodePoolId("nodePoolId1121557241")
              .setNodeVersion("nodeVersion1155309686")
              .setImageType("imageType-878147787")
              .addAllLocations(new ArrayList<String>())
              .setWorkloadMetadataConfig(WorkloadMetadataConfig.newBuilder().build())
              .setName("name3373707")
              .setUpgradeSettings(NodePool.UpgradeSettings.newBuilder().build())
              .setTags(NetworkTags.newBuilder().build())
              .setTaints(NodeTaints.newBuilder().build())
              .setLabels(NodeLabels.newBuilder().build())
              .setLinuxNodeConfig(LinuxNodeConfig.newBuilder().build())
              .setKubeletConfig(NodeKubeletConfig.newBuilder().build())
              .setNodeNetworkConfig(NodeNetworkConfig.newBuilder().build())
              .setGcfsConfig(GcfsConfig.newBuilder().build())
              .setConfidentialNodes(ConfidentialNodes.newBuilder().build())
              .setGvnic(VirtualNIC.newBuilder().build())
              .setEtag("etag3123477")
              .setFastSocket(FastSocket.newBuilder().build())
              .setLoggingConfig(NodePoolLoggingConfig.newBuilder().build())
              .setResourceLabels(ResourceLabels.newBuilder().build())
              .setWindowsNodeConfig(WindowsNodeConfig.newBuilder().build())
              .addAllAccelerators(new ArrayList<AcceleratorConfig>())
              .setMachineType("machineType-218117087")
              .setDiskType("diskType279771767")
              .setDiskSizeGb(-757478089)
              .setResourceManagerTags(ResourceManagerTags.newBuilder().build())
              .setContainerdConfig(ContainerdConfig.newBuilder().build())
              .setQueuedProvisioning(NodePool.QueuedProvisioning.newBuilder().build())
              .addAllStoragePools(new ArrayList<String>())
              .setMaxRunDuration(Duration.newBuilder().build())
              .setFlexStart(true)
              .setBootDisk(BootDisk.newBuilder().build())
              .build();
      client.updateNodePool(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void setNodePoolAutoscalingTest() throws Exception {
    Operation expectedResponse =
        Operation.newBuilder()
            .setName("name3373707")
            .setZone("zone3744684")
            .setDetail("detail-1335224239")
            .setStatusMessage("statusMessage-958704715")
            .setSelfLink("selfLink1191800166")
            .setTargetLink("targetLink486368555")
            .setLocation("location1901043637")
            .setStartTime("startTime-2129294769")
            .setEndTime("endTime-1607243192")
            .setProgress(OperationProgress.newBuilder().build())
            .addAllClusterConditions(new ArrayList<StatusCondition>())
            .addAllNodepoolConditions(new ArrayList<StatusCondition>())
            .setError(Status.newBuilder().build())
            .build();
    mockClusterManager.addResponse(expectedResponse);

    SetNodePoolAutoscalingRequest request =
        SetNodePoolAutoscalingRequest.newBuilder()
            .setProjectId("projectId-894832108")
            .setZone("zone3744684")
            .setClusterId("clusterId561939637")
            .setNodePoolId("nodePoolId1121557241")
            .setAutoscaling(NodePoolAutoscaling.newBuilder().build())
            .setName("name3373707")
            .build();

    Operation actualResponse = client.setNodePoolAutoscaling(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockClusterManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SetNodePoolAutoscalingRequest actualRequest =
        ((SetNodePoolAutoscalingRequest) actualRequests.get(0));

    Assert.assertEquals(request.getProjectId(), actualRequest.getProjectId());
    Assert.assertEquals(request.getZone(), actualRequest.getZone());
    Assert.assertEquals(request.getClusterId(), actualRequest.getClusterId());
    Assert.assertEquals(request.getNodePoolId(), actualRequest.getNodePoolId());
    Assert.assertEquals(request.getAutoscaling(), actualRequest.getAutoscaling());
    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void setNodePoolAutoscalingExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockClusterManager.addException(exception);

    try {
      SetNodePoolAutoscalingRequest request =
          SetNodePoolAutoscalingRequest.newBuilder()
              .setProjectId("projectId-894832108")
              .setZone("zone3744684")
              .setClusterId("clusterId561939637")
              .setNodePoolId("nodePoolId1121557241")
              .setAutoscaling(NodePoolAutoscaling.newBuilder().build())
              .setName("name3373707")
              .build();
      client.setNodePoolAutoscaling(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void setLoggingServiceTest() throws Exception {
    Operation expectedResponse =
        Operation.newBuilder()
            .setName("name3373707")
            .setZone("zone3744684")
            .setDetail("detail-1335224239")
            .setStatusMessage("statusMessage-958704715")
            .setSelfLink("selfLink1191800166")
            .setTargetLink("targetLink486368555")
            .setLocation("location1901043637")
            .setStartTime("startTime-2129294769")
            .setEndTime("endTime-1607243192")
            .setProgress(OperationProgress.newBuilder().build())
            .addAllClusterConditions(new ArrayList<StatusCondition>())
            .addAllNodepoolConditions(new ArrayList<StatusCondition>())
            .setError(Status.newBuilder().build())
            .build();
    mockClusterManager.addResponse(expectedResponse);

    String projectId = "projectId-894832108";
    String zone = "zone3744684";
    String clusterId = "clusterId561939637";
    String loggingService = "loggingService1098570326";

    Operation actualResponse = client.setLoggingService(projectId, zone, clusterId, loggingService);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockClusterManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SetLoggingServiceRequest actualRequest = ((SetLoggingServiceRequest) actualRequests.get(0));

    Assert.assertEquals(projectId, actualRequest.getProjectId());
    Assert.assertEquals(zone, actualRequest.getZone());
    Assert.assertEquals(clusterId, actualRequest.getClusterId());
    Assert.assertEquals(loggingService, actualRequest.getLoggingService());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void setLoggingServiceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockClusterManager.addException(exception);

    try {
      String projectId = "projectId-894832108";
      String zone = "zone3744684";
      String clusterId = "clusterId561939637";
      String loggingService = "loggingService1098570326";
      client.setLoggingService(projectId, zone, clusterId, loggingService);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void setMonitoringServiceTest() throws Exception {
    Operation expectedResponse =
        Operation.newBuilder()
            .setName("name3373707")
            .setZone("zone3744684")
            .setDetail("detail-1335224239")
            .setStatusMessage("statusMessage-958704715")
            .setSelfLink("selfLink1191800166")
            .setTargetLink("targetLink486368555")
            .setLocation("location1901043637")
            .setStartTime("startTime-2129294769")
            .setEndTime("endTime-1607243192")
            .setProgress(OperationProgress.newBuilder().build())
            .addAllClusterConditions(new ArrayList<StatusCondition>())
            .addAllNodepoolConditions(new ArrayList<StatusCondition>())
            .setError(Status.newBuilder().build())
            .build();
    mockClusterManager.addResponse(expectedResponse);

    String projectId = "projectId-894832108";
    String zone = "zone3744684";
    String clusterId = "clusterId561939637";
    String monitoringService = "monitoringService-1431578291";

    Operation actualResponse =
        client.setMonitoringService(projectId, zone, clusterId, monitoringService);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockClusterManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SetMonitoringServiceRequest actualRequest =
        ((SetMonitoringServiceRequest) actualRequests.get(0));

    Assert.assertEquals(projectId, actualRequest.getProjectId());
    Assert.assertEquals(zone, actualRequest.getZone());
    Assert.assertEquals(clusterId, actualRequest.getClusterId());
    Assert.assertEquals(monitoringService, actualRequest.getMonitoringService());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void setMonitoringServiceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockClusterManager.addException(exception);

    try {
      String projectId = "projectId-894832108";
      String zone = "zone3744684";
      String clusterId = "clusterId561939637";
      String monitoringService = "monitoringService-1431578291";
      client.setMonitoringService(projectId, zone, clusterId, monitoringService);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void setAddonsConfigTest() throws Exception {
    Operation expectedResponse =
        Operation.newBuilder()
            .setName("name3373707")
            .setZone("zone3744684")
            .setDetail("detail-1335224239")
            .setStatusMessage("statusMessage-958704715")
            .setSelfLink("selfLink1191800166")
            .setTargetLink("targetLink486368555")
            .setLocation("location1901043637")
            .setStartTime("startTime-2129294769")
            .setEndTime("endTime-1607243192")
            .setProgress(OperationProgress.newBuilder().build())
            .addAllClusterConditions(new ArrayList<StatusCondition>())
            .addAllNodepoolConditions(new ArrayList<StatusCondition>())
            .setError(Status.newBuilder().build())
            .build();
    mockClusterManager.addResponse(expectedResponse);

    String projectId = "projectId-894832108";
    String zone = "zone3744684";
    String clusterId = "clusterId561939637";
    AddonsConfig addonsConfig = AddonsConfig.newBuilder().build();

    Operation actualResponse = client.setAddonsConfig(projectId, zone, clusterId, addonsConfig);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockClusterManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SetAddonsConfigRequest actualRequest = ((SetAddonsConfigRequest) actualRequests.get(0));

    Assert.assertEquals(projectId, actualRequest.getProjectId());
    Assert.assertEquals(zone, actualRequest.getZone());
    Assert.assertEquals(clusterId, actualRequest.getClusterId());
    Assert.assertEquals(addonsConfig, actualRequest.getAddonsConfig());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void setAddonsConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockClusterManager.addException(exception);

    try {
      String projectId = "projectId-894832108";
      String zone = "zone3744684";
      String clusterId = "clusterId561939637";
      AddonsConfig addonsConfig = AddonsConfig.newBuilder().build();
      client.setAddonsConfig(projectId, zone, clusterId, addonsConfig);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void setLocationsTest() throws Exception {
    Operation expectedResponse =
        Operation.newBuilder()
            .setName("name3373707")
            .setZone("zone3744684")
            .setDetail("detail-1335224239")
            .setStatusMessage("statusMessage-958704715")
            .setSelfLink("selfLink1191800166")
            .setTargetLink("targetLink486368555")
            .setLocation("location1901043637")
            .setStartTime("startTime-2129294769")
            .setEndTime("endTime-1607243192")
            .setProgress(OperationProgress.newBuilder().build())
            .addAllClusterConditions(new ArrayList<StatusCondition>())
            .addAllNodepoolConditions(new ArrayList<StatusCondition>())
            .setError(Status.newBuilder().build())
            .build();
    mockClusterManager.addResponse(expectedResponse);

    String projectId = "projectId-894832108";
    String zone = "zone3744684";
    String clusterId = "clusterId561939637";
    List<String> locations = new ArrayList<>();

    Operation actualResponse = client.setLocations(projectId, zone, clusterId, locations);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockClusterManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SetLocationsRequest actualRequest = ((SetLocationsRequest) actualRequests.get(0));

    Assert.assertEquals(projectId, actualRequest.getProjectId());
    Assert.assertEquals(zone, actualRequest.getZone());
    Assert.assertEquals(clusterId, actualRequest.getClusterId());
    Assert.assertEquals(locations, actualRequest.getLocationsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void setLocationsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockClusterManager.addException(exception);

    try {
      String projectId = "projectId-894832108";
      String zone = "zone3744684";
      String clusterId = "clusterId561939637";
      List<String> locations = new ArrayList<>();
      client.setLocations(projectId, zone, clusterId, locations);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateMasterTest() throws Exception {
    Operation expectedResponse =
        Operation.newBuilder()
            .setName("name3373707")
            .setZone("zone3744684")
            .setDetail("detail-1335224239")
            .setStatusMessage("statusMessage-958704715")
            .setSelfLink("selfLink1191800166")
            .setTargetLink("targetLink486368555")
            .setLocation("location1901043637")
            .setStartTime("startTime-2129294769")
            .setEndTime("endTime-1607243192")
            .setProgress(OperationProgress.newBuilder().build())
            .addAllClusterConditions(new ArrayList<StatusCondition>())
            .addAllNodepoolConditions(new ArrayList<StatusCondition>())
            .setError(Status.newBuilder().build())
            .build();
    mockClusterManager.addResponse(expectedResponse);

    String projectId = "projectId-894832108";
    String zone = "zone3744684";
    String clusterId = "clusterId561939637";
    String masterVersion = "masterVersion1167095830";

    Operation actualResponse = client.updateMaster(projectId, zone, clusterId, masterVersion);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockClusterManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateMasterRequest actualRequest = ((UpdateMasterRequest) actualRequests.get(0));

    Assert.assertEquals(projectId, actualRequest.getProjectId());
    Assert.assertEquals(zone, actualRequest.getZone());
    Assert.assertEquals(clusterId, actualRequest.getClusterId());
    Assert.assertEquals(masterVersion, actualRequest.getMasterVersion());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateMasterExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockClusterManager.addException(exception);

    try {
      String projectId = "projectId-894832108";
      String zone = "zone3744684";
      String clusterId = "clusterId561939637";
      String masterVersion = "masterVersion1167095830";
      client.updateMaster(projectId, zone, clusterId, masterVersion);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void setMasterAuthTest() throws Exception {
    Operation expectedResponse =
        Operation.newBuilder()
            .setName("name3373707")
            .setZone("zone3744684")
            .setDetail("detail-1335224239")
            .setStatusMessage("statusMessage-958704715")
            .setSelfLink("selfLink1191800166")
            .setTargetLink("targetLink486368555")
            .setLocation("location1901043637")
            .setStartTime("startTime-2129294769")
            .setEndTime("endTime-1607243192")
            .setProgress(OperationProgress.newBuilder().build())
            .addAllClusterConditions(new ArrayList<StatusCondition>())
            .addAllNodepoolConditions(new ArrayList<StatusCondition>())
            .setError(Status.newBuilder().build())
            .build();
    mockClusterManager.addResponse(expectedResponse);

    SetMasterAuthRequest request =
        SetMasterAuthRequest.newBuilder()
            .setProjectId("projectId-894832108")
            .setZone("zone3744684")
            .setClusterId("clusterId561939637")
            .setUpdate(MasterAuth.newBuilder().build())
            .setName("name3373707")
            .build();

    Operation actualResponse = client.setMasterAuth(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockClusterManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SetMasterAuthRequest actualRequest = ((SetMasterAuthRequest) actualRequests.get(0));

    Assert.assertEquals(request.getProjectId(), actualRequest.getProjectId());
    Assert.assertEquals(request.getZone(), actualRequest.getZone());
    Assert.assertEquals(request.getClusterId(), actualRequest.getClusterId());
    Assert.assertEquals(request.getAction(), actualRequest.getAction());
    Assert.assertEquals(request.getUpdate(), actualRequest.getUpdate());
    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void setMasterAuthExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockClusterManager.addException(exception);

    try {
      SetMasterAuthRequest request =
          SetMasterAuthRequest.newBuilder()
              .setProjectId("projectId-894832108")
              .setZone("zone3744684")
              .setClusterId("clusterId561939637")
              .setUpdate(MasterAuth.newBuilder().build())
              .setName("name3373707")
              .build();
      client.setMasterAuth(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteClusterTest() throws Exception {
    Operation expectedResponse =
        Operation.newBuilder()
            .setName("name3373707")
            .setZone("zone3744684")
            .setDetail("detail-1335224239")
            .setStatusMessage("statusMessage-958704715")
            .setSelfLink("selfLink1191800166")
            .setTargetLink("targetLink486368555")
            .setLocation("location1901043637")
            .setStartTime("startTime-2129294769")
            .setEndTime("endTime-1607243192")
            .setProgress(OperationProgress.newBuilder().build())
            .addAllClusterConditions(new ArrayList<StatusCondition>())
            .addAllNodepoolConditions(new ArrayList<StatusCondition>())
            .setError(Status.newBuilder().build())
            .build();
    mockClusterManager.addResponse(expectedResponse);

    String projectId = "projectId-894832108";
    String zone = "zone3744684";
    String clusterId = "clusterId561939637";

    Operation actualResponse = client.deleteCluster(projectId, zone, clusterId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockClusterManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteClusterRequest actualRequest = ((DeleteClusterRequest) actualRequests.get(0));

    Assert.assertEquals(projectId, actualRequest.getProjectId());
    Assert.assertEquals(zone, actualRequest.getZone());
    Assert.assertEquals(clusterId, actualRequest.getClusterId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteClusterExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockClusterManager.addException(exception);

    try {
      String projectId = "projectId-894832108";
      String zone = "zone3744684";
      String clusterId = "clusterId561939637";
      client.deleteCluster(projectId, zone, clusterId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listOperationsTest() throws Exception {
    ListOperationsResponse expectedResponse =
        ListOperationsResponse.newBuilder()
            .addAllOperations(new ArrayList<Operation>())
            .addAllMissingZones(new ArrayList<String>())
            .build();
    mockClusterManager.addResponse(expectedResponse);

    String projectId = "projectId-894832108";
    String zone = "zone3744684";

    ListOperationsResponse actualResponse = client.listOperations(projectId, zone);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockClusterManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListOperationsRequest actualRequest = ((ListOperationsRequest) actualRequests.get(0));

    Assert.assertEquals(projectId, actualRequest.getProjectId());
    Assert.assertEquals(zone, actualRequest.getZone());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listOperationsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockClusterManager.addException(exception);

    try {
      String projectId = "projectId-894832108";
      String zone = "zone3744684";
      client.listOperations(projectId, zone);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getOperationTest() throws Exception {
    Operation expectedResponse =
        Operation.newBuilder()
            .setName("name3373707")
            .setZone("zone3744684")
            .setDetail("detail-1335224239")
            .setStatusMessage("statusMessage-958704715")
            .setSelfLink("selfLink1191800166")
            .setTargetLink("targetLink486368555")
            .setLocation("location1901043637")
            .setStartTime("startTime-2129294769")
            .setEndTime("endTime-1607243192")
            .setProgress(OperationProgress.newBuilder().build())
            .addAllClusterConditions(new ArrayList<StatusCondition>())
            .addAllNodepoolConditions(new ArrayList<StatusCondition>())
            .setError(Status.newBuilder().build())
            .build();
    mockClusterManager.addResponse(expectedResponse);

    String projectId = "projectId-894832108";
    String zone = "zone3744684";
    String operationId = "operationId129704162";

    Operation actualResponse = client.getOperation(projectId, zone, operationId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockClusterManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetOperationRequest actualRequest = ((GetOperationRequest) actualRequests.get(0));

    Assert.assertEquals(projectId, actualRequest.getProjectId());
    Assert.assertEquals(zone, actualRequest.getZone());
    Assert.assertEquals(operationId, actualRequest.getOperationId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getOperationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockClusterManager.addException(exception);

    try {
      String projectId = "projectId-894832108";
      String zone = "zone3744684";
      String operationId = "operationId129704162";
      client.getOperation(projectId, zone, operationId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void cancelOperationTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockClusterManager.addResponse(expectedResponse);

    String projectId = "projectId-894832108";
    String zone = "zone3744684";
    String operationId = "operationId129704162";

    client.cancelOperation(projectId, zone, operationId);

    List<AbstractMessage> actualRequests = mockClusterManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CancelOperationRequest actualRequest = ((CancelOperationRequest) actualRequests.get(0));

    Assert.assertEquals(projectId, actualRequest.getProjectId());
    Assert.assertEquals(zone, actualRequest.getZone());
    Assert.assertEquals(operationId, actualRequest.getOperationId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void cancelOperationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockClusterManager.addException(exception);

    try {
      String projectId = "projectId-894832108";
      String zone = "zone3744684";
      String operationId = "operationId129704162";
      client.cancelOperation(projectId, zone, operationId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getServerConfigTest() throws Exception {
    ServerConfig expectedResponse =
        ServerConfig.newBuilder()
            .setDefaultClusterVersion("defaultClusterVersion-2007666145")
            .addAllValidNodeVersions(new ArrayList<String>())
            .setDefaultImageType("defaultImageType933054964")
            .addAllValidImageTypes(new ArrayList<String>())
            .addAllValidMasterVersions(new ArrayList<String>())
            .addAllChannels(new ArrayList<ServerConfig.ReleaseChannelConfig>())
            .putAllWindowsVersionMaps(new HashMap<String, WindowsVersions>())
            .build();
    mockClusterManager.addResponse(expectedResponse);

    String projectId = "projectId-894832108";
    String zone = "zone3744684";

    ServerConfig actualResponse = client.getServerConfig(projectId, zone);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockClusterManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetServerConfigRequest actualRequest = ((GetServerConfigRequest) actualRequests.get(0));

    Assert.assertEquals(projectId, actualRequest.getProjectId());
    Assert.assertEquals(zone, actualRequest.getZone());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getServerConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockClusterManager.addException(exception);

    try {
      String projectId = "projectId-894832108";
      String zone = "zone3744684";
      client.getServerConfig(projectId, zone);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getJSONWebKeysTest() throws Exception {
    GetJSONWebKeysResponse expectedResponse =
        GetJSONWebKeysResponse.newBuilder().addAllKeys(new ArrayList<Jwk>()).build();
    mockClusterManager.addResponse(expectedResponse);

    GetJSONWebKeysRequest request =
        GetJSONWebKeysRequest.newBuilder().setParent("parent-995424086").build();

    GetJSONWebKeysResponse actualResponse = client.getJSONWebKeys(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockClusterManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetJSONWebKeysRequest actualRequest = ((GetJSONWebKeysRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getJSONWebKeysExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockClusterManager.addException(exception);

    try {
      GetJSONWebKeysRequest request =
          GetJSONWebKeysRequest.newBuilder().setParent("parent-995424086").build();
      client.getJSONWebKeys(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listNodePoolsTest() throws Exception {
    ListNodePoolsResponse expectedResponse =
        ListNodePoolsResponse.newBuilder().addAllNodePools(new ArrayList<NodePool>()).build();
    mockClusterManager.addResponse(expectedResponse);

    String projectId = "projectId-894832108";
    String zone = "zone3744684";
    String clusterId = "clusterId561939637";

    ListNodePoolsResponse actualResponse = client.listNodePools(projectId, zone, clusterId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockClusterManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListNodePoolsRequest actualRequest = ((ListNodePoolsRequest) actualRequests.get(0));

    Assert.assertEquals(projectId, actualRequest.getProjectId());
    Assert.assertEquals(zone, actualRequest.getZone());
    Assert.assertEquals(clusterId, actualRequest.getClusterId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listNodePoolsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockClusterManager.addException(exception);

    try {
      String projectId = "projectId-894832108";
      String zone = "zone3744684";
      String clusterId = "clusterId561939637";
      client.listNodePools(projectId, zone, clusterId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getNodePoolTest() throws Exception {
    NodePool expectedResponse =
        NodePool.newBuilder()
            .setName("name3373707")
            .setConfig(NodeConfig.newBuilder().build())
            .setInitialNodeCount(1682564205)
            .addAllLocations(new ArrayList<String>())
            .setNetworkConfig(NodeNetworkConfig.newBuilder().build())
            .setSelfLink("selfLink1191800166")
            .setVersion("version351608024")
            .addAllInstanceGroupUrls(new ArrayList<String>())
            .setStatusMessage("statusMessage-958704715")
            .setAutoscaling(NodePoolAutoscaling.newBuilder().build())
            .setManagement(NodeManagement.newBuilder().build())
            .setMaxPodsConstraint(MaxPodsConstraint.newBuilder().build())
            .addAllConditions(new ArrayList<StatusCondition>())
            .setPodIpv4CidrSize(1098768716)
            .setUpgradeSettings(NodePool.UpgradeSettings.newBuilder().build())
            .setPlacementPolicy(NodePool.PlacementPolicy.newBuilder().build())
            .setUpdateInfo(NodePool.UpdateInfo.newBuilder().build())
            .setEtag("etag3123477")
            .setQueuedProvisioning(NodePool.QueuedProvisioning.newBuilder().build())
            .setBestEffortProvisioning(BestEffortProvisioning.newBuilder().build())
            .build();
    mockClusterManager.addResponse(expectedResponse);

    String projectId = "projectId-894832108";
    String zone = "zone3744684";
    String clusterId = "clusterId561939637";
    String nodePoolId = "nodePoolId1121557241";

    NodePool actualResponse = client.getNodePool(projectId, zone, clusterId, nodePoolId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockClusterManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetNodePoolRequest actualRequest = ((GetNodePoolRequest) actualRequests.get(0));

    Assert.assertEquals(projectId, actualRequest.getProjectId());
    Assert.assertEquals(zone, actualRequest.getZone());
    Assert.assertEquals(clusterId, actualRequest.getClusterId());
    Assert.assertEquals(nodePoolId, actualRequest.getNodePoolId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getNodePoolExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockClusterManager.addException(exception);

    try {
      String projectId = "projectId-894832108";
      String zone = "zone3744684";
      String clusterId = "clusterId561939637";
      String nodePoolId = "nodePoolId1121557241";
      client.getNodePool(projectId, zone, clusterId, nodePoolId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createNodePoolTest() throws Exception {
    Operation expectedResponse =
        Operation.newBuilder()
            .setName("name3373707")
            .setZone("zone3744684")
            .setDetail("detail-1335224239")
            .setStatusMessage("statusMessage-958704715")
            .setSelfLink("selfLink1191800166")
            .setTargetLink("targetLink486368555")
            .setLocation("location1901043637")
            .setStartTime("startTime-2129294769")
            .setEndTime("endTime-1607243192")
            .setProgress(OperationProgress.newBuilder().build())
            .addAllClusterConditions(new ArrayList<StatusCondition>())
            .addAllNodepoolConditions(new ArrayList<StatusCondition>())
            .setError(Status.newBuilder().build())
            .build();
    mockClusterManager.addResponse(expectedResponse);

    String projectId = "projectId-894832108";
    String zone = "zone3744684";
    String clusterId = "clusterId561939637";
    NodePool nodePool = NodePool.newBuilder().build();

    Operation actualResponse = client.createNodePool(projectId, zone, clusterId, nodePool);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockClusterManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateNodePoolRequest actualRequest = ((CreateNodePoolRequest) actualRequests.get(0));

    Assert.assertEquals(projectId, actualRequest.getProjectId());
    Assert.assertEquals(zone, actualRequest.getZone());
    Assert.assertEquals(clusterId, actualRequest.getClusterId());
    Assert.assertEquals(nodePool, actualRequest.getNodePool());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createNodePoolExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockClusterManager.addException(exception);

    try {
      String projectId = "projectId-894832108";
      String zone = "zone3744684";
      String clusterId = "clusterId561939637";
      NodePool nodePool = NodePool.newBuilder().build();
      client.createNodePool(projectId, zone, clusterId, nodePool);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteNodePoolTest() throws Exception {
    Operation expectedResponse =
        Operation.newBuilder()
            .setName("name3373707")
            .setZone("zone3744684")
            .setDetail("detail-1335224239")
            .setStatusMessage("statusMessage-958704715")
            .setSelfLink("selfLink1191800166")
            .setTargetLink("targetLink486368555")
            .setLocation("location1901043637")
            .setStartTime("startTime-2129294769")
            .setEndTime("endTime-1607243192")
            .setProgress(OperationProgress.newBuilder().build())
            .addAllClusterConditions(new ArrayList<StatusCondition>())
            .addAllNodepoolConditions(new ArrayList<StatusCondition>())
            .setError(Status.newBuilder().build())
            .build();
    mockClusterManager.addResponse(expectedResponse);

    String projectId = "projectId-894832108";
    String zone = "zone3744684";
    String clusterId = "clusterId561939637";
    String nodePoolId = "nodePoolId1121557241";

    Operation actualResponse = client.deleteNodePool(projectId, zone, clusterId, nodePoolId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockClusterManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteNodePoolRequest actualRequest = ((DeleteNodePoolRequest) actualRequests.get(0));

    Assert.assertEquals(projectId, actualRequest.getProjectId());
    Assert.assertEquals(zone, actualRequest.getZone());
    Assert.assertEquals(clusterId, actualRequest.getClusterId());
    Assert.assertEquals(nodePoolId, actualRequest.getNodePoolId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteNodePoolExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockClusterManager.addException(exception);

    try {
      String projectId = "projectId-894832108";
      String zone = "zone3744684";
      String clusterId = "clusterId561939637";
      String nodePoolId = "nodePoolId1121557241";
      client.deleteNodePool(projectId, zone, clusterId, nodePoolId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void completeNodePoolUpgradeTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockClusterManager.addResponse(expectedResponse);

    CompleteNodePoolUpgradeRequest request =
        CompleteNodePoolUpgradeRequest.newBuilder().setName("name3373707").build();

    client.completeNodePoolUpgrade(request);

    List<AbstractMessage> actualRequests = mockClusterManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CompleteNodePoolUpgradeRequest actualRequest =
        ((CompleteNodePoolUpgradeRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void completeNodePoolUpgradeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockClusterManager.addException(exception);

    try {
      CompleteNodePoolUpgradeRequest request =
          CompleteNodePoolUpgradeRequest.newBuilder().setName("name3373707").build();
      client.completeNodePoolUpgrade(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void rollbackNodePoolUpgradeTest() throws Exception {
    Operation expectedResponse =
        Operation.newBuilder()
            .setName("name3373707")
            .setZone("zone3744684")
            .setDetail("detail-1335224239")
            .setStatusMessage("statusMessage-958704715")
            .setSelfLink("selfLink1191800166")
            .setTargetLink("targetLink486368555")
            .setLocation("location1901043637")
            .setStartTime("startTime-2129294769")
            .setEndTime("endTime-1607243192")
            .setProgress(OperationProgress.newBuilder().build())
            .addAllClusterConditions(new ArrayList<StatusCondition>())
            .addAllNodepoolConditions(new ArrayList<StatusCondition>())
            .setError(Status.newBuilder().build())
            .build();
    mockClusterManager.addResponse(expectedResponse);

    String projectId = "projectId-894832108";
    String zone = "zone3744684";
    String clusterId = "clusterId561939637";
    String nodePoolId = "nodePoolId1121557241";

    Operation actualResponse =
        client.rollbackNodePoolUpgrade(projectId, zone, clusterId, nodePoolId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockClusterManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RollbackNodePoolUpgradeRequest actualRequest =
        ((RollbackNodePoolUpgradeRequest) actualRequests.get(0));

    Assert.assertEquals(projectId, actualRequest.getProjectId());
    Assert.assertEquals(zone, actualRequest.getZone());
    Assert.assertEquals(clusterId, actualRequest.getClusterId());
    Assert.assertEquals(nodePoolId, actualRequest.getNodePoolId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void rollbackNodePoolUpgradeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockClusterManager.addException(exception);

    try {
      String projectId = "projectId-894832108";
      String zone = "zone3744684";
      String clusterId = "clusterId561939637";
      String nodePoolId = "nodePoolId1121557241";
      client.rollbackNodePoolUpgrade(projectId, zone, clusterId, nodePoolId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void setNodePoolManagementTest() throws Exception {
    Operation expectedResponse =
        Operation.newBuilder()
            .setName("name3373707")
            .setZone("zone3744684")
            .setDetail("detail-1335224239")
            .setStatusMessage("statusMessage-958704715")
            .setSelfLink("selfLink1191800166")
            .setTargetLink("targetLink486368555")
            .setLocation("location1901043637")
            .setStartTime("startTime-2129294769")
            .setEndTime("endTime-1607243192")
            .setProgress(OperationProgress.newBuilder().build())
            .addAllClusterConditions(new ArrayList<StatusCondition>())
            .addAllNodepoolConditions(new ArrayList<StatusCondition>())
            .setError(Status.newBuilder().build())
            .build();
    mockClusterManager.addResponse(expectedResponse);

    String projectId = "projectId-894832108";
    String zone = "zone3744684";
    String clusterId = "clusterId561939637";
    String nodePoolId = "nodePoolId1121557241";
    NodeManagement management = NodeManagement.newBuilder().build();

    Operation actualResponse =
        client.setNodePoolManagement(projectId, zone, clusterId, nodePoolId, management);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockClusterManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SetNodePoolManagementRequest actualRequest =
        ((SetNodePoolManagementRequest) actualRequests.get(0));

    Assert.assertEquals(projectId, actualRequest.getProjectId());
    Assert.assertEquals(zone, actualRequest.getZone());
    Assert.assertEquals(clusterId, actualRequest.getClusterId());
    Assert.assertEquals(nodePoolId, actualRequest.getNodePoolId());
    Assert.assertEquals(management, actualRequest.getManagement());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void setNodePoolManagementExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockClusterManager.addException(exception);

    try {
      String projectId = "projectId-894832108";
      String zone = "zone3744684";
      String clusterId = "clusterId561939637";
      String nodePoolId = "nodePoolId1121557241";
      NodeManagement management = NodeManagement.newBuilder().build();
      client.setNodePoolManagement(projectId, zone, clusterId, nodePoolId, management);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void setLabelsTest() throws Exception {
    Operation expectedResponse =
        Operation.newBuilder()
            .setName("name3373707")
            .setZone("zone3744684")
            .setDetail("detail-1335224239")
            .setStatusMessage("statusMessage-958704715")
            .setSelfLink("selfLink1191800166")
            .setTargetLink("targetLink486368555")
            .setLocation("location1901043637")
            .setStartTime("startTime-2129294769")
            .setEndTime("endTime-1607243192")
            .setProgress(OperationProgress.newBuilder().build())
            .addAllClusterConditions(new ArrayList<StatusCondition>())
            .addAllNodepoolConditions(new ArrayList<StatusCondition>())
            .setError(Status.newBuilder().build())
            .build();
    mockClusterManager.addResponse(expectedResponse);

    String projectId = "projectId-894832108";
    String zone = "zone3744684";
    String clusterId = "clusterId561939637";
    Map<String, String> resourceLabels = new HashMap<>();
    String labelFingerprint = "labelFingerprint379449680";

    Operation actualResponse =
        client.setLabels(projectId, zone, clusterId, resourceLabels, labelFingerprint);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockClusterManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SetLabelsRequest actualRequest = ((SetLabelsRequest) actualRequests.get(0));

    Assert.assertEquals(projectId, actualRequest.getProjectId());
    Assert.assertEquals(zone, actualRequest.getZone());
    Assert.assertEquals(clusterId, actualRequest.getClusterId());
    Assert.assertEquals(resourceLabels, actualRequest.getResourceLabelsMap());
    Assert.assertEquals(labelFingerprint, actualRequest.getLabelFingerprint());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void setLabelsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockClusterManager.addException(exception);

    try {
      String projectId = "projectId-894832108";
      String zone = "zone3744684";
      String clusterId = "clusterId561939637";
      Map<String, String> resourceLabels = new HashMap<>();
      String labelFingerprint = "labelFingerprint379449680";
      client.setLabels(projectId, zone, clusterId, resourceLabels, labelFingerprint);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void setLegacyAbacTest() throws Exception {
    Operation expectedResponse =
        Operation.newBuilder()
            .setName("name3373707")
            .setZone("zone3744684")
            .setDetail("detail-1335224239")
            .setStatusMessage("statusMessage-958704715")
            .setSelfLink("selfLink1191800166")
            .setTargetLink("targetLink486368555")
            .setLocation("location1901043637")
            .setStartTime("startTime-2129294769")
            .setEndTime("endTime-1607243192")
            .setProgress(OperationProgress.newBuilder().build())
            .addAllClusterConditions(new ArrayList<StatusCondition>())
            .addAllNodepoolConditions(new ArrayList<StatusCondition>())
            .setError(Status.newBuilder().build())
            .build();
    mockClusterManager.addResponse(expectedResponse);

    String projectId = "projectId-894832108";
    String zone = "zone3744684";
    String clusterId = "clusterId561939637";
    boolean enabled = true;

    Operation actualResponse = client.setLegacyAbac(projectId, zone, clusterId, enabled);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockClusterManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SetLegacyAbacRequest actualRequest = ((SetLegacyAbacRequest) actualRequests.get(0));

    Assert.assertEquals(projectId, actualRequest.getProjectId());
    Assert.assertEquals(zone, actualRequest.getZone());
    Assert.assertEquals(clusterId, actualRequest.getClusterId());
    Assert.assertEquals(enabled, actualRequest.getEnabled());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void setLegacyAbacExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockClusterManager.addException(exception);

    try {
      String projectId = "projectId-894832108";
      String zone = "zone3744684";
      String clusterId = "clusterId561939637";
      boolean enabled = true;
      client.setLegacyAbac(projectId, zone, clusterId, enabled);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void startIPRotationTest() throws Exception {
    Operation expectedResponse =
        Operation.newBuilder()
            .setName("name3373707")
            .setZone("zone3744684")
            .setDetail("detail-1335224239")
            .setStatusMessage("statusMessage-958704715")
            .setSelfLink("selfLink1191800166")
            .setTargetLink("targetLink486368555")
            .setLocation("location1901043637")
            .setStartTime("startTime-2129294769")
            .setEndTime("endTime-1607243192")
            .setProgress(OperationProgress.newBuilder().build())
            .addAllClusterConditions(new ArrayList<StatusCondition>())
            .addAllNodepoolConditions(new ArrayList<StatusCondition>())
            .setError(Status.newBuilder().build())
            .build();
    mockClusterManager.addResponse(expectedResponse);

    String projectId = "projectId-894832108";
    String zone = "zone3744684";
    String clusterId = "clusterId561939637";

    Operation actualResponse = client.startIPRotation(projectId, zone, clusterId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockClusterManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    StartIPRotationRequest actualRequest = ((StartIPRotationRequest) actualRequests.get(0));

    Assert.assertEquals(projectId, actualRequest.getProjectId());
    Assert.assertEquals(zone, actualRequest.getZone());
    Assert.assertEquals(clusterId, actualRequest.getClusterId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void startIPRotationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockClusterManager.addException(exception);

    try {
      String projectId = "projectId-894832108";
      String zone = "zone3744684";
      String clusterId = "clusterId561939637";
      client.startIPRotation(projectId, zone, clusterId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void completeIPRotationTest() throws Exception {
    Operation expectedResponse =
        Operation.newBuilder()
            .setName("name3373707")
            .setZone("zone3744684")
            .setDetail("detail-1335224239")
            .setStatusMessage("statusMessage-958704715")
            .setSelfLink("selfLink1191800166")
            .setTargetLink("targetLink486368555")
            .setLocation("location1901043637")
            .setStartTime("startTime-2129294769")
            .setEndTime("endTime-1607243192")
            .setProgress(OperationProgress.newBuilder().build())
            .addAllClusterConditions(new ArrayList<StatusCondition>())
            .addAllNodepoolConditions(new ArrayList<StatusCondition>())
            .setError(Status.newBuilder().build())
            .build();
    mockClusterManager.addResponse(expectedResponse);

    String projectId = "projectId-894832108";
    String zone = "zone3744684";
    String clusterId = "clusterId561939637";

    Operation actualResponse = client.completeIPRotation(projectId, zone, clusterId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockClusterManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CompleteIPRotationRequest actualRequest = ((CompleteIPRotationRequest) actualRequests.get(0));

    Assert.assertEquals(projectId, actualRequest.getProjectId());
    Assert.assertEquals(zone, actualRequest.getZone());
    Assert.assertEquals(clusterId, actualRequest.getClusterId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void completeIPRotationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockClusterManager.addException(exception);

    try {
      String projectId = "projectId-894832108";
      String zone = "zone3744684";
      String clusterId = "clusterId561939637";
      client.completeIPRotation(projectId, zone, clusterId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void setNodePoolSizeTest() throws Exception {
    Operation expectedResponse =
        Operation.newBuilder()
            .setName("name3373707")
            .setZone("zone3744684")
            .setDetail("detail-1335224239")
            .setStatusMessage("statusMessage-958704715")
            .setSelfLink("selfLink1191800166")
            .setTargetLink("targetLink486368555")
            .setLocation("location1901043637")
            .setStartTime("startTime-2129294769")
            .setEndTime("endTime-1607243192")
            .setProgress(OperationProgress.newBuilder().build())
            .addAllClusterConditions(new ArrayList<StatusCondition>())
            .addAllNodepoolConditions(new ArrayList<StatusCondition>())
            .setError(Status.newBuilder().build())
            .build();
    mockClusterManager.addResponse(expectedResponse);

    SetNodePoolSizeRequest request =
        SetNodePoolSizeRequest.newBuilder()
            .setProjectId("projectId-894832108")
            .setZone("zone3744684")
            .setClusterId("clusterId561939637")
            .setNodePoolId("nodePoolId1121557241")
            .setNodeCount(1539922066)
            .setName("name3373707")
            .build();

    Operation actualResponse = client.setNodePoolSize(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockClusterManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SetNodePoolSizeRequest actualRequest = ((SetNodePoolSizeRequest) actualRequests.get(0));

    Assert.assertEquals(request.getProjectId(), actualRequest.getProjectId());
    Assert.assertEquals(request.getZone(), actualRequest.getZone());
    Assert.assertEquals(request.getClusterId(), actualRequest.getClusterId());
    Assert.assertEquals(request.getNodePoolId(), actualRequest.getNodePoolId());
    Assert.assertEquals(request.getNodeCount(), actualRequest.getNodeCount());
    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void setNodePoolSizeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockClusterManager.addException(exception);

    try {
      SetNodePoolSizeRequest request =
          SetNodePoolSizeRequest.newBuilder()
              .setProjectId("projectId-894832108")
              .setZone("zone3744684")
              .setClusterId("clusterId561939637")
              .setNodePoolId("nodePoolId1121557241")
              .setNodeCount(1539922066)
              .setName("name3373707")
              .build();
      client.setNodePoolSize(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void setNetworkPolicyTest() throws Exception {
    Operation expectedResponse =
        Operation.newBuilder()
            .setName("name3373707")
            .setZone("zone3744684")
            .setDetail("detail-1335224239")
            .setStatusMessage("statusMessage-958704715")
            .setSelfLink("selfLink1191800166")
            .setTargetLink("targetLink486368555")
            .setLocation("location1901043637")
            .setStartTime("startTime-2129294769")
            .setEndTime("endTime-1607243192")
            .setProgress(OperationProgress.newBuilder().build())
            .addAllClusterConditions(new ArrayList<StatusCondition>())
            .addAllNodepoolConditions(new ArrayList<StatusCondition>())
            .setError(Status.newBuilder().build())
            .build();
    mockClusterManager.addResponse(expectedResponse);

    String projectId = "projectId-894832108";
    String zone = "zone3744684";
    String clusterId = "clusterId561939637";
    NetworkPolicy networkPolicy = NetworkPolicy.newBuilder().build();

    Operation actualResponse = client.setNetworkPolicy(projectId, zone, clusterId, networkPolicy);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockClusterManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SetNetworkPolicyRequest actualRequest = ((SetNetworkPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(projectId, actualRequest.getProjectId());
    Assert.assertEquals(zone, actualRequest.getZone());
    Assert.assertEquals(clusterId, actualRequest.getClusterId());
    Assert.assertEquals(networkPolicy, actualRequest.getNetworkPolicy());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void setNetworkPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockClusterManager.addException(exception);

    try {
      String projectId = "projectId-894832108";
      String zone = "zone3744684";
      String clusterId = "clusterId561939637";
      NetworkPolicy networkPolicy = NetworkPolicy.newBuilder().build();
      client.setNetworkPolicy(projectId, zone, clusterId, networkPolicy);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void setMaintenancePolicyTest() throws Exception {
    Operation expectedResponse =
        Operation.newBuilder()
            .setName("name3373707")
            .setZone("zone3744684")
            .setDetail("detail-1335224239")
            .setStatusMessage("statusMessage-958704715")
            .setSelfLink("selfLink1191800166")
            .setTargetLink("targetLink486368555")
            .setLocation("location1901043637")
            .setStartTime("startTime-2129294769")
            .setEndTime("endTime-1607243192")
            .setProgress(OperationProgress.newBuilder().build())
            .addAllClusterConditions(new ArrayList<StatusCondition>())
            .addAllNodepoolConditions(new ArrayList<StatusCondition>())
            .setError(Status.newBuilder().build())
            .build();
    mockClusterManager.addResponse(expectedResponse);

    String projectId = "projectId-894832108";
    String zone = "zone3744684";
    String clusterId = "clusterId561939637";
    MaintenancePolicy maintenancePolicy = MaintenancePolicy.newBuilder().build();

    Operation actualResponse =
        client.setMaintenancePolicy(projectId, zone, clusterId, maintenancePolicy);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockClusterManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SetMaintenancePolicyRequest actualRequest =
        ((SetMaintenancePolicyRequest) actualRequests.get(0));

    Assert.assertEquals(projectId, actualRequest.getProjectId());
    Assert.assertEquals(zone, actualRequest.getZone());
    Assert.assertEquals(clusterId, actualRequest.getClusterId());
    Assert.assertEquals(maintenancePolicy, actualRequest.getMaintenancePolicy());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void setMaintenancePolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockClusterManager.addException(exception);

    try {
      String projectId = "projectId-894832108";
      String zone = "zone3744684";
      String clusterId = "clusterId561939637";
      MaintenancePolicy maintenancePolicy = MaintenancePolicy.newBuilder().build();
      client.setMaintenancePolicy(projectId, zone, clusterId, maintenancePolicy);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listUsableSubnetworksTest() throws Exception {
    UsableSubnetwork responsesElement = UsableSubnetwork.newBuilder().build();
    ListUsableSubnetworksResponse expectedResponse =
        ListUsableSubnetworksResponse.newBuilder()
            .setNextPageToken("")
            .addAllSubnetworks(Arrays.asList(responsesElement))
            .build();
    mockClusterManager.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListUsableSubnetworksPagedResponse pagedListResponse = client.listUsableSubnetworks(parent);

    List<UsableSubnetwork> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSubnetworksList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockClusterManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListUsableSubnetworksRequest actualRequest =
        ((ListUsableSubnetworksRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listUsableSubnetworksExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockClusterManager.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listUsableSubnetworks(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void checkAutopilotCompatibilityTest() throws Exception {
    CheckAutopilotCompatibilityResponse expectedResponse =
        CheckAutopilotCompatibilityResponse.newBuilder()
            .addAllIssues(new ArrayList<AutopilotCompatibilityIssue>())
            .setSummary("summary-1857640538")
            .build();
    mockClusterManager.addResponse(expectedResponse);

    CheckAutopilotCompatibilityRequest request =
        CheckAutopilotCompatibilityRequest.newBuilder().setName("name3373707").build();

    CheckAutopilotCompatibilityResponse actualResponse =
        client.checkAutopilotCompatibility(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockClusterManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CheckAutopilotCompatibilityRequest actualRequest =
        ((CheckAutopilotCompatibilityRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void checkAutopilotCompatibilityExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockClusterManager.addException(exception);

    try {
      CheckAutopilotCompatibilityRequest request =
          CheckAutopilotCompatibilityRequest.newBuilder().setName("name3373707").build();
      client.checkAutopilotCompatibility(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listLocationsTest() throws Exception {
    ListLocationsResponse expectedResponse =
        ListLocationsResponse.newBuilder()
            .addAllLocations(new ArrayList<Location>())
            .setNextPageToken("nextPageToken-1386094857")
            .build();
    mockClusterManager.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListLocationsResponse actualResponse = client.listLocations(parent);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockClusterManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListLocationsRequest actualRequest = ((ListLocationsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listLocationsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockClusterManager.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listLocations(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void fetchClusterUpgradeInfoTest() throws Exception {
    ClusterUpgradeInfo expectedResponse =
        ClusterUpgradeInfo.newBuilder()
            .setMinorTargetVersion("minorTargetVersion222643282")
            .setPatchTargetVersion("patchTargetVersion371479199")
            .addAllAutoUpgradeStatus(new ArrayList<ClusterUpgradeInfo.AutoUpgradeStatus>())
            .addAllPausedReason(new ArrayList<ClusterUpgradeInfo.AutoUpgradePausedReason>())
            .addAllUpgradeDetails(new ArrayList<UpgradeDetails>())
            .setEndOfStandardSupportTimestamp("endOfStandardSupportTimestamp-1097416426")
            .setEndOfExtendedSupportTimestamp("endOfExtendedSupportTimestamp599562130")
            .build();
    mockClusterManager.addResponse(expectedResponse);

    String name = "name3373707";

    ClusterUpgradeInfo actualResponse = client.fetchClusterUpgradeInfo(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockClusterManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    FetchClusterUpgradeInfoRequest actualRequest =
        ((FetchClusterUpgradeInfoRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void fetchClusterUpgradeInfoExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockClusterManager.addException(exception);

    try {
      String name = "name3373707";
      client.fetchClusterUpgradeInfo(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void fetchNodePoolUpgradeInfoTest() throws Exception {
    NodePoolUpgradeInfo expectedResponse =
        NodePoolUpgradeInfo.newBuilder()
            .setMinorTargetVersion("minorTargetVersion222643282")
            .setPatchTargetVersion("patchTargetVersion371479199")
            .addAllAutoUpgradeStatus(new ArrayList<NodePoolUpgradeInfo.AutoUpgradeStatus>())
            .addAllPausedReason(new ArrayList<NodePoolUpgradeInfo.AutoUpgradePausedReason>())
            .addAllUpgradeDetails(new ArrayList<UpgradeDetails>())
            .setEndOfStandardSupportTimestamp("endOfStandardSupportTimestamp-1097416426")
            .setEndOfExtendedSupportTimestamp("endOfExtendedSupportTimestamp599562130")
            .build();
    mockClusterManager.addResponse(expectedResponse);

    String name = "name3373707";

    NodePoolUpgradeInfo actualResponse = client.fetchNodePoolUpgradeInfo(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockClusterManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    FetchNodePoolUpgradeInfoRequest actualRequest =
        ((FetchNodePoolUpgradeInfoRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void fetchNodePoolUpgradeInfoExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockClusterManager.addException(exception);

    try {
      String name = "name3373707";
      client.fetchNodePoolUpgradeInfo(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
