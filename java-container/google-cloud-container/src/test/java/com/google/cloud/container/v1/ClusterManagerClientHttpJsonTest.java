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

package com.google.cloud.container.v1;

import static com.google.cloud.container.v1.ClusterManagerClient.ListUsableSubnetworksPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.container.v1.stub.HttpJsonClusterManagerStub;
import com.google.common.collect.Lists;
import com.google.container.v1.AcceleratorConfig;
import com.google.container.v1.AddonsConfig;
import com.google.container.v1.AnonymousAuthenticationConfig;
import com.google.container.v1.AuthenticatorGroupsConfig;
import com.google.container.v1.Autopilot;
import com.google.container.v1.AutopilotCompatibilityIssue;
import com.google.container.v1.BestEffortProvisioning;
import com.google.container.v1.BinaryAuthorization;
import com.google.container.v1.BootDisk;
import com.google.container.v1.CheckAutopilotCompatibilityRequest;
import com.google.container.v1.CheckAutopilotCompatibilityResponse;
import com.google.container.v1.Cluster;
import com.google.container.v1.ClusterAutoscaling;
import com.google.container.v1.ClusterUpdate;
import com.google.container.v1.ClusterUpgradeInfo;
import com.google.container.v1.CompleteNodePoolUpgradeRequest;
import com.google.container.v1.CompliancePostureConfig;
import com.google.container.v1.ConfidentialNodes;
import com.google.container.v1.ContainerdConfig;
import com.google.container.v1.ControlPlaneEndpointsConfig;
import com.google.container.v1.CostManagementConfig;
import com.google.container.v1.DatabaseEncryption;
import com.google.container.v1.EnterpriseConfig;
import com.google.container.v1.FastSocket;
import com.google.container.v1.Fleet;
import com.google.container.v1.GcfsConfig;
import com.google.container.v1.GetJSONWebKeysRequest;
import com.google.container.v1.GetJSONWebKeysResponse;
import com.google.container.v1.GkeAutoUpgradeConfig;
import com.google.container.v1.IPAllocationPolicy;
import com.google.container.v1.IdentityServiceConfig;
import com.google.container.v1.Jwk;
import com.google.container.v1.K8sBetaAPIConfig;
import com.google.container.v1.LegacyAbac;
import com.google.container.v1.LinuxNodeConfig;
import com.google.container.v1.ListClustersResponse;
import com.google.container.v1.ListNodePoolsResponse;
import com.google.container.v1.ListOperationsResponse;
import com.google.container.v1.ListUsableSubnetworksRequest;
import com.google.container.v1.ListUsableSubnetworksResponse;
import com.google.container.v1.LoggingConfig;
import com.google.container.v1.MaintenancePolicy;
import com.google.container.v1.MasterAuth;
import com.google.container.v1.MasterAuthorizedNetworksConfig;
import com.google.container.v1.MaxPodsConstraint;
import com.google.container.v1.MeshCertificates;
import com.google.container.v1.MonitoringConfig;
import com.google.container.v1.NetworkConfig;
import com.google.container.v1.NetworkPolicy;
import com.google.container.v1.NetworkTags;
import com.google.container.v1.NodeConfig;
import com.google.container.v1.NodeKubeletConfig;
import com.google.container.v1.NodeLabels;
import com.google.container.v1.NodeManagement;
import com.google.container.v1.NodeNetworkConfig;
import com.google.container.v1.NodePool;
import com.google.container.v1.NodePoolAutoConfig;
import com.google.container.v1.NodePoolAutoscaling;
import com.google.container.v1.NodePoolDefaults;
import com.google.container.v1.NodePoolLoggingConfig;
import com.google.container.v1.NodePoolUpgradeInfo;
import com.google.container.v1.NodeTaints;
import com.google.container.v1.NotificationConfig;
import com.google.container.v1.Operation;
import com.google.container.v1.OperationProgress;
import com.google.container.v1.PodAutoscaling;
import com.google.container.v1.PrivateClusterConfig;
import com.google.container.v1.RBACBindingConfig;
import com.google.container.v1.ReleaseChannel;
import com.google.container.v1.ResourceLabels;
import com.google.container.v1.ResourceManagerTags;
import com.google.container.v1.ResourceUsageExportConfig;
import com.google.container.v1.SecretManagerConfig;
import com.google.container.v1.SecurityPostureConfig;
import com.google.container.v1.ServerConfig;
import com.google.container.v1.SetLabelsRequest;
import com.google.container.v1.SetMasterAuthRequest;
import com.google.container.v1.SetNodePoolAutoscalingRequest;
import com.google.container.v1.SetNodePoolManagementRequest;
import com.google.container.v1.SetNodePoolSizeRequest;
import com.google.container.v1.ShieldedNodes;
import com.google.container.v1.StatusCondition;
import com.google.container.v1.UpdateNodePoolRequest;
import com.google.container.v1.UpgradeDetails;
import com.google.container.v1.UsableSubnetwork;
import com.google.container.v1.UserManagedKeysConfig;
import com.google.container.v1.VerticalPodAutoscaling;
import com.google.container.v1.VirtualNIC;
import com.google.container.v1.WindowsNodeConfig;
import com.google.container.v1.WorkloadIdentityConfig;
import com.google.container.v1.WorkloadMetadataConfig;
import com.google.protobuf.Duration;
import com.google.protobuf.Empty;
import com.google.rpc.Status;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class ClusterManagerClientHttpJsonTest {
  private static MockHttpService mockService;
  private static ClusterManagerClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonClusterManagerStub.getMethodDescriptors(),
            ClusterManagerSettings.getDefaultEndpoint());
    ClusterManagerSettings settings =
        ClusterManagerSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                ClusterManagerSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ClusterManagerClient.create(settings);
  }

  @AfterClass
  public static void stopServer() {
    client.close();
  }

  @Before
  public void setUp() {}

  @After
  public void tearDown() throws Exception {
    mockService.reset();
  }

  @Test
  public void listClustersTest() throws Exception {
    ListClustersResponse expectedResponse =
        ListClustersResponse.newBuilder()
            .addAllClusters(new ArrayList<Cluster>())
            .addAllMissingZones(new ArrayList<String>())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListClustersResponse actualResponse = client.listClusters(parent);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listClustersExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listClusters(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listClustersTest2() throws Exception {
    ListClustersResponse expectedResponse =
        ListClustersResponse.newBuilder()
            .addAllClusters(new ArrayList<Cluster>())
            .addAllMissingZones(new ArrayList<String>())
            .build();
    mockService.addResponse(expectedResponse);

    String projectId = "projectId-894832108";
    String zone = "zone3744684";

    ListClustersResponse actualResponse = client.listClusters(projectId, zone);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listClustersExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
            .putAllResourceLabels(new HashMap<String, String>())
            .setLabelFingerprint("labelFingerprint379449680")
            .setLegacyAbac(LegacyAbac.newBuilder().build())
            .setNetworkPolicy(NetworkPolicy.newBuilder().build())
            .setIpAllocationPolicy(IPAllocationPolicy.newBuilder().build())
            .setMasterAuthorizedNetworksConfig(MasterAuthorizedNetworksConfig.newBuilder().build())
            .setMaintenancePolicy(MaintenancePolicy.newBuilder().build())
            .setBinaryAuthorization(BinaryAuthorization.newBuilder().build())
            .setAutoscaling(ClusterAutoscaling.newBuilder().build())
            .setNetworkConfig(NetworkConfig.newBuilder().build())
            .setDefaultMaxPodsConstraint(MaxPodsConstraint.newBuilder().build())
            .setResourceUsageExportConfig(ResourceUsageExportConfig.newBuilder().build())
            .setAuthenticatorGroupsConfig(AuthenticatorGroupsConfig.newBuilder().build())
            .setPrivateClusterConfig(PrivateClusterConfig.newBuilder().build())
            .setDatabaseEncryption(DatabaseEncryption.newBuilder().build())
            .setVerticalPodAutoscaling(VerticalPodAutoscaling.newBuilder().build())
            .setShieldedNodes(ShieldedNodes.newBuilder().build())
            .setReleaseChannel(ReleaseChannel.newBuilder().build())
            .setWorkloadIdentityConfig(WorkloadIdentityConfig.newBuilder().build())
            .setMeshCertificates(MeshCertificates.newBuilder().build())
            .setCostManagementConfig(CostManagementConfig.newBuilder().build())
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
            .addAllConditions(new ArrayList<StatusCondition>())
            .setAutopilot(Autopilot.newBuilder().build())
            .setId("id3355")
            .setNodePoolDefaults(NodePoolDefaults.newBuilder().build())
            .setLoggingConfig(LoggingConfig.newBuilder().build())
            .setMonitoringConfig(MonitoringConfig.newBuilder().build())
            .setNodePoolAutoConfig(NodePoolAutoConfig.newBuilder().build())
            .setPodAutoscaling(PodAutoscaling.newBuilder().build())
            .setEtag("etag3123477")
            .setFleet(Fleet.newBuilder().build())
            .setSecurityPostureConfig(SecurityPostureConfig.newBuilder().build())
            .setControlPlaneEndpointsConfig(ControlPlaneEndpointsConfig.newBuilder().build())
            .setEnableK8SBetaApis(K8sBetaAPIConfig.newBuilder().build())
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
    mockService.addResponse(expectedResponse);

    String name = "projects/project-6537/locations/location-6537/clusters/cluster-6537";

    Cluster actualResponse = client.getCluster(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getClusterExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-6537/locations/location-6537/clusters/cluster-6537";
      client.getCluster(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getClusterTest2() throws Exception {
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
            .putAllResourceLabels(new HashMap<String, String>())
            .setLabelFingerprint("labelFingerprint379449680")
            .setLegacyAbac(LegacyAbac.newBuilder().build())
            .setNetworkPolicy(NetworkPolicy.newBuilder().build())
            .setIpAllocationPolicy(IPAllocationPolicy.newBuilder().build())
            .setMasterAuthorizedNetworksConfig(MasterAuthorizedNetworksConfig.newBuilder().build())
            .setMaintenancePolicy(MaintenancePolicy.newBuilder().build())
            .setBinaryAuthorization(BinaryAuthorization.newBuilder().build())
            .setAutoscaling(ClusterAutoscaling.newBuilder().build())
            .setNetworkConfig(NetworkConfig.newBuilder().build())
            .setDefaultMaxPodsConstraint(MaxPodsConstraint.newBuilder().build())
            .setResourceUsageExportConfig(ResourceUsageExportConfig.newBuilder().build())
            .setAuthenticatorGroupsConfig(AuthenticatorGroupsConfig.newBuilder().build())
            .setPrivateClusterConfig(PrivateClusterConfig.newBuilder().build())
            .setDatabaseEncryption(DatabaseEncryption.newBuilder().build())
            .setVerticalPodAutoscaling(VerticalPodAutoscaling.newBuilder().build())
            .setShieldedNodes(ShieldedNodes.newBuilder().build())
            .setReleaseChannel(ReleaseChannel.newBuilder().build())
            .setWorkloadIdentityConfig(WorkloadIdentityConfig.newBuilder().build())
            .setMeshCertificates(MeshCertificates.newBuilder().build())
            .setCostManagementConfig(CostManagementConfig.newBuilder().build())
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
            .addAllConditions(new ArrayList<StatusCondition>())
            .setAutopilot(Autopilot.newBuilder().build())
            .setId("id3355")
            .setNodePoolDefaults(NodePoolDefaults.newBuilder().build())
            .setLoggingConfig(LoggingConfig.newBuilder().build())
            .setMonitoringConfig(MonitoringConfig.newBuilder().build())
            .setNodePoolAutoConfig(NodePoolAutoConfig.newBuilder().build())
            .setPodAutoscaling(PodAutoscaling.newBuilder().build())
            .setEtag("etag3123477")
            .setFleet(Fleet.newBuilder().build())
            .setSecurityPostureConfig(SecurityPostureConfig.newBuilder().build())
            .setControlPlaneEndpointsConfig(ControlPlaneEndpointsConfig.newBuilder().build())
            .setEnableK8SBetaApis(K8sBetaAPIConfig.newBuilder().build())
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
    mockService.addResponse(expectedResponse);

    String projectId = "projectId-894832108";
    String zone = "zone3744684";
    String clusterId = "clusterId561939637";

    Cluster actualResponse = client.getCluster(projectId, zone, clusterId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getClusterExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";
    Cluster cluster = Cluster.newBuilder().build();

    Operation actualResponse = client.createCluster(parent, cluster);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createClusterExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      Cluster cluster = Cluster.newBuilder().build();
      client.createCluster(parent, cluster);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createClusterTest2() throws Exception {
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
    mockService.addResponse(expectedResponse);

    String projectId = "projectId-894832108";
    String zone = "zone3744684";
    Cluster cluster = Cluster.newBuilder().build();

    Operation actualResponse = client.createCluster(projectId, zone, cluster);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createClusterExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name = "projects/project-6537/locations/location-6537/clusters/cluster-6537";
    ClusterUpdate update = ClusterUpdate.newBuilder().build();

    Operation actualResponse = client.updateCluster(name, update);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void updateClusterExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-6537/locations/location-6537/clusters/cluster-6537";
      ClusterUpdate update = ClusterUpdate.newBuilder().build();
      client.updateCluster(name, update);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateClusterTest2() throws Exception {
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
    mockService.addResponse(expectedResponse);

    String projectId = "projectId-894832108";
    String zone = "zone3744684";
    String clusterId = "clusterId561939637";
    ClusterUpdate update = ClusterUpdate.newBuilder().build();

    Operation actualResponse = client.updateCluster(projectId, zone, clusterId, update);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void updateClusterExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    UpdateNodePoolRequest request =
        UpdateNodePoolRequest.newBuilder()
            .setProjectId("projectId-894832108")
            .setZone("zone3744684")
            .setClusterId("clusterId561939637")
            .setNodePoolId("nodePoolId1121557241")
            .setNodeVersion("nodeVersion1155309686")
            .setImageType("imageType-878147787")
            .setName(
                "projects/project-6330/locations/location-6330/clusters/cluster-6330/nodePools/nodePool-6330")
            .addAllLocations(new ArrayList<String>())
            .setWorkloadMetadataConfig(WorkloadMetadataConfig.newBuilder().build())
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

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void updateNodePoolExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      UpdateNodePoolRequest request =
          UpdateNodePoolRequest.newBuilder()
              .setProjectId("projectId-894832108")
              .setZone("zone3744684")
              .setClusterId("clusterId561939637")
              .setNodePoolId("nodePoolId1121557241")
              .setNodeVersion("nodeVersion1155309686")
              .setImageType("imageType-878147787")
              .setName(
                  "projects/project-6330/locations/location-6330/clusters/cluster-6330/nodePools/nodePool-6330")
              .addAllLocations(new ArrayList<String>())
              .setWorkloadMetadataConfig(WorkloadMetadataConfig.newBuilder().build())
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
    mockService.addResponse(expectedResponse);

    SetNodePoolAutoscalingRequest request =
        SetNodePoolAutoscalingRequest.newBuilder()
            .setProjectId("projectId-894832108")
            .setZone("zone3744684")
            .setClusterId("clusterId561939637")
            .setNodePoolId("nodePoolId1121557241")
            .setAutoscaling(NodePoolAutoscaling.newBuilder().build())
            .setName(
                "projects/project-6330/locations/location-6330/clusters/cluster-6330/nodePools/nodePool-6330")
            .build();

    Operation actualResponse = client.setNodePoolAutoscaling(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void setNodePoolAutoscalingExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SetNodePoolAutoscalingRequest request =
          SetNodePoolAutoscalingRequest.newBuilder()
              .setProjectId("projectId-894832108")
              .setZone("zone3744684")
              .setClusterId("clusterId561939637")
              .setNodePoolId("nodePoolId1121557241")
              .setAutoscaling(NodePoolAutoscaling.newBuilder().build())
              .setName(
                  "projects/project-6330/locations/location-6330/clusters/cluster-6330/nodePools/nodePool-6330")
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
    mockService.addResponse(expectedResponse);

    String name = "projects/project-6537/locations/location-6537/clusters/cluster-6537";
    String loggingService = "loggingService1098570326";

    Operation actualResponse = client.setLoggingService(name, loggingService);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void setLoggingServiceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-6537/locations/location-6537/clusters/cluster-6537";
      String loggingService = "loggingService1098570326";
      client.setLoggingService(name, loggingService);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void setLoggingServiceTest2() throws Exception {
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
    mockService.addResponse(expectedResponse);

    String projectId = "projectId-894832108";
    String zone = "zone3744684";
    String clusterId = "clusterId561939637";
    String loggingService = "loggingService1098570326";

    Operation actualResponse = client.setLoggingService(projectId, zone, clusterId, loggingService);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void setLoggingServiceExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name = "projects/project-6537/locations/location-6537/clusters/cluster-6537";
    String monitoringService = "monitoringService-1431578291";

    Operation actualResponse = client.setMonitoringService(name, monitoringService);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void setMonitoringServiceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-6537/locations/location-6537/clusters/cluster-6537";
      String monitoringService = "monitoringService-1431578291";
      client.setMonitoringService(name, monitoringService);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void setMonitoringServiceTest2() throws Exception {
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
    mockService.addResponse(expectedResponse);

    String projectId = "projectId-894832108";
    String zone = "zone3744684";
    String clusterId = "clusterId561939637";
    String monitoringService = "monitoringService-1431578291";

    Operation actualResponse =
        client.setMonitoringService(projectId, zone, clusterId, monitoringService);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void setMonitoringServiceExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name = "projects/project-6537/locations/location-6537/clusters/cluster-6537";
    AddonsConfig addonsConfig = AddonsConfig.newBuilder().build();

    Operation actualResponse = client.setAddonsConfig(name, addonsConfig);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void setAddonsConfigExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-6537/locations/location-6537/clusters/cluster-6537";
      AddonsConfig addonsConfig = AddonsConfig.newBuilder().build();
      client.setAddonsConfig(name, addonsConfig);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void setAddonsConfigTest2() throws Exception {
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
    mockService.addResponse(expectedResponse);

    String projectId = "projectId-894832108";
    String zone = "zone3744684";
    String clusterId = "clusterId561939637";
    AddonsConfig addonsConfig = AddonsConfig.newBuilder().build();

    Operation actualResponse = client.setAddonsConfig(projectId, zone, clusterId, addonsConfig);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void setAddonsConfigExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name = "projects/project-6537/locations/location-6537/clusters/cluster-6537";
    List<String> locations = new ArrayList<>();

    Operation actualResponse = client.setLocations(name, locations);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void setLocationsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-6537/locations/location-6537/clusters/cluster-6537";
      List<String> locations = new ArrayList<>();
      client.setLocations(name, locations);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void setLocationsTest2() throws Exception {
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
    mockService.addResponse(expectedResponse);

    String projectId = "projectId-894832108";
    String zone = "zone3744684";
    String clusterId = "clusterId561939637";
    List<String> locations = new ArrayList<>();

    Operation actualResponse = client.setLocations(projectId, zone, clusterId, locations);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void setLocationsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name = "projects/project-6537/locations/location-6537/clusters/cluster-6537";
    String masterVersion = "masterVersion1167095830";

    Operation actualResponse = client.updateMaster(name, masterVersion);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void updateMasterExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-6537/locations/location-6537/clusters/cluster-6537";
      String masterVersion = "masterVersion1167095830";
      client.updateMaster(name, masterVersion);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateMasterTest2() throws Exception {
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
    mockService.addResponse(expectedResponse);

    String projectId = "projectId-894832108";
    String zone = "zone3744684";
    String clusterId = "clusterId561939637";
    String masterVersion = "masterVersion1167095830";

    Operation actualResponse = client.updateMaster(projectId, zone, clusterId, masterVersion);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void updateMasterExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    SetMasterAuthRequest request =
        SetMasterAuthRequest.newBuilder()
            .setProjectId("projectId-894832108")
            .setZone("zone3744684")
            .setClusterId("clusterId561939637")
            .setUpdate(MasterAuth.newBuilder().build())
            .setName("projects/project-6537/locations/location-6537/clusters/cluster-6537")
            .build();

    Operation actualResponse = client.setMasterAuth(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void setMasterAuthExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SetMasterAuthRequest request =
          SetMasterAuthRequest.newBuilder()
              .setProjectId("projectId-894832108")
              .setZone("zone3744684")
              .setClusterId("clusterId561939637")
              .setUpdate(MasterAuth.newBuilder().build())
              .setName("projects/project-6537/locations/location-6537/clusters/cluster-6537")
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
    mockService.addResponse(expectedResponse);

    String name = "projects/project-6537/locations/location-6537/clusters/cluster-6537";

    Operation actualResponse = client.deleteCluster(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteClusterExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-6537/locations/location-6537/clusters/cluster-6537";
      client.deleteCluster(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteClusterTest2() throws Exception {
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
    mockService.addResponse(expectedResponse);

    String projectId = "projectId-894832108";
    String zone = "zone3744684";
    String clusterId = "clusterId561939637";

    Operation actualResponse = client.deleteCluster(projectId, zone, clusterId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteClusterExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListOperationsResponse actualResponse = client.listOperations(parent);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listOperationsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listOperations(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listOperationsTest2() throws Exception {
    ListOperationsResponse expectedResponse =
        ListOperationsResponse.newBuilder()
            .addAllOperations(new ArrayList<Operation>())
            .addAllMissingZones(new ArrayList<String>())
            .build();
    mockService.addResponse(expectedResponse);

    String projectId = "projectId-894832108";
    String zone = "zone3744684";

    ListOperationsResponse actualResponse = client.listOperations(projectId, zone);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listOperationsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name = "projects/project-5676/locations/location-5676/operations/operation-5676";

    Operation actualResponse = client.getOperation(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getOperationExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-5676/locations/location-5676/operations/operation-5676";
      client.getOperation(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getOperationTest2() throws Exception {
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
    mockService.addResponse(expectedResponse);

    String projectId = "projectId-894832108";
    String zone = "zone3744684";
    String operationId = "operationId129704162";

    Operation actualResponse = client.getOperation(projectId, zone, operationId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getOperationExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name = "projects/project-5676/locations/location-5676/operations/operation-5676";

    client.cancelOperation(name);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void cancelOperationExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-5676/locations/location-5676/operations/operation-5676";
      client.cancelOperation(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void cancelOperationTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String projectId = "projectId-894832108";
    String zone = "zone3744684";
    String operationId = "operationId129704162";

    client.cancelOperation(projectId, zone, operationId);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void cancelOperationExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-9062/locations/location-9062";

    ServerConfig actualResponse = client.getServerConfig(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getServerConfigExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-9062/locations/location-9062";
      client.getServerConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getServerConfigTest2() throws Exception {
    ServerConfig expectedResponse =
        ServerConfig.newBuilder()
            .setDefaultClusterVersion("defaultClusterVersion-2007666145")
            .addAllValidNodeVersions(new ArrayList<String>())
            .setDefaultImageType("defaultImageType933054964")
            .addAllValidImageTypes(new ArrayList<String>())
            .addAllValidMasterVersions(new ArrayList<String>())
            .addAllChannels(new ArrayList<ServerConfig.ReleaseChannelConfig>())
            .build();
    mockService.addResponse(expectedResponse);

    String projectId = "projectId-894832108";
    String zone = "zone3744684";

    ServerConfig actualResponse = client.getServerConfig(projectId, zone);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getServerConfigExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    GetJSONWebKeysRequest request =
        GetJSONWebKeysRequest.newBuilder()
            .setParent("projects/project-9466/locations/location-9466/clusters/cluster-9466")
            .build();

    GetJSONWebKeysResponse actualResponse = client.getJSONWebKeys(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getJSONWebKeysExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GetJSONWebKeysRequest request =
          GetJSONWebKeysRequest.newBuilder()
              .setParent("projects/project-9466/locations/location-9466/clusters/cluster-9466")
              .build();
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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-9466/locations/location-9466/clusters/cluster-9466";

    ListNodePoolsResponse actualResponse = client.listNodePools(parent);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listNodePoolsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-9466/locations/location-9466/clusters/cluster-9466";
      client.listNodePools(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listNodePoolsTest2() throws Exception {
    ListNodePoolsResponse expectedResponse =
        ListNodePoolsResponse.newBuilder().addAllNodePools(new ArrayList<NodePool>()).build();
    mockService.addResponse(expectedResponse);

    String projectId = "projectId-894832108";
    String zone = "zone3744684";
    String clusterId = "clusterId561939637";

    ListNodePoolsResponse actualResponse = client.listNodePools(projectId, zone, clusterId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listNodePoolsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-6330/locations/location-6330/clusters/cluster-6330/nodePools/nodePool-6330";

    NodePool actualResponse = client.getNodePool(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getNodePoolExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-6330/locations/location-6330/clusters/cluster-6330/nodePools/nodePool-6330";
      client.getNodePool(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getNodePoolTest2() throws Exception {
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
    mockService.addResponse(expectedResponse);

    String projectId = "projectId-894832108";
    String zone = "zone3744684";
    String clusterId = "clusterId561939637";
    String nodePoolId = "nodePoolId1121557241";

    NodePool actualResponse = client.getNodePool(projectId, zone, clusterId, nodePoolId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getNodePoolExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-9466/locations/location-9466/clusters/cluster-9466";
    NodePool nodePool = NodePool.newBuilder().build();

    Operation actualResponse = client.createNodePool(parent, nodePool);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createNodePoolExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-9466/locations/location-9466/clusters/cluster-9466";
      NodePool nodePool = NodePool.newBuilder().build();
      client.createNodePool(parent, nodePool);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createNodePoolTest2() throws Exception {
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
    mockService.addResponse(expectedResponse);

    String projectId = "projectId-894832108";
    String zone = "zone3744684";
    String clusterId = "clusterId561939637";
    NodePool nodePool = NodePool.newBuilder().build();

    Operation actualResponse = client.createNodePool(projectId, zone, clusterId, nodePool);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createNodePoolExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-6330/locations/location-6330/clusters/cluster-6330/nodePools/nodePool-6330";

    Operation actualResponse = client.deleteNodePool(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteNodePoolExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-6330/locations/location-6330/clusters/cluster-6330/nodePools/nodePool-6330";
      client.deleteNodePool(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteNodePoolTest2() throws Exception {
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
    mockService.addResponse(expectedResponse);

    String projectId = "projectId-894832108";
    String zone = "zone3744684";
    String clusterId = "clusterId561939637";
    String nodePoolId = "nodePoolId1121557241";

    Operation actualResponse = client.deleteNodePool(projectId, zone, clusterId, nodePoolId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteNodePoolExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    CompleteNodePoolUpgradeRequest request =
        CompleteNodePoolUpgradeRequest.newBuilder()
            .setName(
                "projects/project-6330/locations/location-6330/clusters/cluster-6330/nodePools/nodePool-6330")
            .build();

    client.completeNodePoolUpgrade(request);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void completeNodePoolUpgradeExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CompleteNodePoolUpgradeRequest request =
          CompleteNodePoolUpgradeRequest.newBuilder()
              .setName(
                  "projects/project-6330/locations/location-6330/clusters/cluster-6330/nodePools/nodePool-6330")
              .build();
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
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-6330/locations/location-6330/clusters/cluster-6330/nodePools/nodePool-6330";

    Operation actualResponse = client.rollbackNodePoolUpgrade(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void rollbackNodePoolUpgradeExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-6330/locations/location-6330/clusters/cluster-6330/nodePools/nodePool-6330";
      client.rollbackNodePoolUpgrade(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void rollbackNodePoolUpgradeTest2() throws Exception {
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
    mockService.addResponse(expectedResponse);

    String projectId = "projectId-894832108";
    String zone = "zone3744684";
    String clusterId = "clusterId561939637";
    String nodePoolId = "nodePoolId1121557241";

    Operation actualResponse =
        client.rollbackNodePoolUpgrade(projectId, zone, clusterId, nodePoolId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void rollbackNodePoolUpgradeExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    SetNodePoolManagementRequest request =
        SetNodePoolManagementRequest.newBuilder()
            .setProjectId("projectId-894832108")
            .setZone("zone3744684")
            .setClusterId("clusterId561939637")
            .setNodePoolId("nodePoolId1121557241")
            .setManagement(NodeManagement.newBuilder().build())
            .setName(
                "projects/project-6330/locations/location-6330/clusters/cluster-6330/nodePools/nodePool-6330")
            .build();

    Operation actualResponse = client.setNodePoolManagement(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void setNodePoolManagementExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SetNodePoolManagementRequest request =
          SetNodePoolManagementRequest.newBuilder()
              .setProjectId("projectId-894832108")
              .setZone("zone3744684")
              .setClusterId("clusterId561939637")
              .setNodePoolId("nodePoolId1121557241")
              .setManagement(NodeManagement.newBuilder().build())
              .setName(
                  "projects/project-6330/locations/location-6330/clusters/cluster-6330/nodePools/nodePool-6330")
              .build();
      client.setNodePoolManagement(request);
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
    mockService.addResponse(expectedResponse);

    SetLabelsRequest request =
        SetLabelsRequest.newBuilder()
            .setProjectId("projectId-894832108")
            .setZone("zone3744684")
            .setClusterId("clusterId561939637")
            .putAllResourceLabels(new HashMap<String, String>())
            .setLabelFingerprint("labelFingerprint379449680")
            .setName("projects/project-6537/locations/location-6537/clusters/cluster-6537")
            .build();

    Operation actualResponse = client.setLabels(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void setLabelsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SetLabelsRequest request =
          SetLabelsRequest.newBuilder()
              .setProjectId("projectId-894832108")
              .setZone("zone3744684")
              .setClusterId("clusterId561939637")
              .putAllResourceLabels(new HashMap<String, String>())
              .setLabelFingerprint("labelFingerprint379449680")
              .setName("projects/project-6537/locations/location-6537/clusters/cluster-6537")
              .build();
      client.setLabels(request);
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
    mockService.addResponse(expectedResponse);

    String name = "projects/project-6537/locations/location-6537/clusters/cluster-6537";
    boolean enabled = true;

    Operation actualResponse = client.setLegacyAbac(name, enabled);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void setLegacyAbacExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-6537/locations/location-6537/clusters/cluster-6537";
      boolean enabled = true;
      client.setLegacyAbac(name, enabled);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void setLegacyAbacTest2() throws Exception {
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
    mockService.addResponse(expectedResponse);

    String projectId = "projectId-894832108";
    String zone = "zone3744684";
    String clusterId = "clusterId561939637";
    boolean enabled = true;

    Operation actualResponse = client.setLegacyAbac(projectId, zone, clusterId, enabled);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void setLegacyAbacExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name = "projects/project-6537/locations/location-6537/clusters/cluster-6537";

    Operation actualResponse = client.startIPRotation(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void startIPRotationExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-6537/locations/location-6537/clusters/cluster-6537";
      client.startIPRotation(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void startIPRotationTest2() throws Exception {
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
    mockService.addResponse(expectedResponse);

    String projectId = "projectId-894832108";
    String zone = "zone3744684";
    String clusterId = "clusterId561939637";

    Operation actualResponse = client.startIPRotation(projectId, zone, clusterId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void startIPRotationExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name = "projects/project-6537/locations/location-6537/clusters/cluster-6537";

    Operation actualResponse = client.completeIPRotation(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void completeIPRotationExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-6537/locations/location-6537/clusters/cluster-6537";
      client.completeIPRotation(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void completeIPRotationTest2() throws Exception {
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
    mockService.addResponse(expectedResponse);

    String projectId = "projectId-894832108";
    String zone = "zone3744684";
    String clusterId = "clusterId561939637";

    Operation actualResponse = client.completeIPRotation(projectId, zone, clusterId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void completeIPRotationExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    SetNodePoolSizeRequest request =
        SetNodePoolSizeRequest.newBuilder()
            .setProjectId("projectId-894832108")
            .setZone("zone3744684")
            .setClusterId("clusterId561939637")
            .setNodePoolId("nodePoolId1121557241")
            .setNodeCount(1539922066)
            .setName(
                "projects/project-6330/locations/location-6330/clusters/cluster-6330/nodePools/nodePool-6330")
            .build();

    Operation actualResponse = client.setNodePoolSize(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void setNodePoolSizeExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SetNodePoolSizeRequest request =
          SetNodePoolSizeRequest.newBuilder()
              .setProjectId("projectId-894832108")
              .setZone("zone3744684")
              .setClusterId("clusterId561939637")
              .setNodePoolId("nodePoolId1121557241")
              .setNodeCount(1539922066)
              .setName(
                  "projects/project-6330/locations/location-6330/clusters/cluster-6330/nodePools/nodePool-6330")
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
    mockService.addResponse(expectedResponse);

    String name = "projects/project-6537/locations/location-6537/clusters/cluster-6537";
    NetworkPolicy networkPolicy = NetworkPolicy.newBuilder().build();

    Operation actualResponse = client.setNetworkPolicy(name, networkPolicy);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void setNetworkPolicyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-6537/locations/location-6537/clusters/cluster-6537";
      NetworkPolicy networkPolicy = NetworkPolicy.newBuilder().build();
      client.setNetworkPolicy(name, networkPolicy);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void setNetworkPolicyTest2() throws Exception {
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
    mockService.addResponse(expectedResponse);

    String projectId = "projectId-894832108";
    String zone = "zone3744684";
    String clusterId = "clusterId561939637";
    NetworkPolicy networkPolicy = NetworkPolicy.newBuilder().build();

    Operation actualResponse = client.setNetworkPolicy(projectId, zone, clusterId, networkPolicy);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void setNetworkPolicyExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name = "projects/project-6537/locations/location-6537/clusters/cluster-6537";
    MaintenancePolicy maintenancePolicy = MaintenancePolicy.newBuilder().build();

    Operation actualResponse = client.setMaintenancePolicy(name, maintenancePolicy);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void setMaintenancePolicyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-6537/locations/location-6537/clusters/cluster-6537";
      MaintenancePolicy maintenancePolicy = MaintenancePolicy.newBuilder().build();
      client.setMaintenancePolicy(name, maintenancePolicy);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void setMaintenancePolicyTest2() throws Exception {
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
    mockService.addResponse(expectedResponse);

    String projectId = "projectId-894832108";
    String zone = "zone3744684";
    String clusterId = "clusterId561939637";
    MaintenancePolicy maintenancePolicy = MaintenancePolicy.newBuilder().build();

    Operation actualResponse =
        client.setMaintenancePolicy(projectId, zone, clusterId, maintenancePolicy);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void setMaintenancePolicyExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    ListUsableSubnetworksRequest request =
        ListUsableSubnetworksRequest.newBuilder()
            .setParent("projects/project-2353")
            .setFilter("filter-1274492040")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    ListUsableSubnetworksPagedResponse pagedListResponse = client.listUsableSubnetworks(request);

    List<UsableSubnetwork> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSubnetworksList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listUsableSubnetworksExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ListUsableSubnetworksRequest request =
          ListUsableSubnetworksRequest.newBuilder()
              .setParent("projects/project-2353")
              .setFilter("filter-1274492040")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      client.listUsableSubnetworks(request);
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
    mockService.addResponse(expectedResponse);

    CheckAutopilotCompatibilityRequest request =
        CheckAutopilotCompatibilityRequest.newBuilder()
            .setName("projects/project-6537/locations/location-6537/clusters/cluster-6537")
            .build();

    CheckAutopilotCompatibilityResponse actualResponse =
        client.checkAutopilotCompatibility(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void checkAutopilotCompatibilityExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CheckAutopilotCompatibilityRequest request =
          CheckAutopilotCompatibilityRequest.newBuilder()
              .setName("projects/project-6537/locations/location-6537/clusters/cluster-6537")
              .build();
      client.checkAutopilotCompatibility(request);
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
    mockService.addResponse(expectedResponse);

    String name = "projects/project-6537/locations/location-6537/clusters/cluster-6537";

    ClusterUpgradeInfo actualResponse = client.fetchClusterUpgradeInfo(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void fetchClusterUpgradeInfoExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-6537/locations/location-6537/clusters/cluster-6537";
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
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-6330/locations/location-6330/clusters/cluster-6330/nodePools/nodePool-6330";

    NodePoolUpgradeInfo actualResponse = client.fetchNodePoolUpgradeInfo(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void fetchNodePoolUpgradeInfoExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-6330/locations/location-6330/clusters/cluster-6330/nodePools/nodePool-6330";
      client.fetchNodePoolUpgradeInfo(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
