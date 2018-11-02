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
package com.google.cloud.container.v1;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.container.v1.CancelOperationRequest;
import com.google.container.v1.Cluster;
import com.google.container.v1.CompleteIPRotationRequest;
import com.google.container.v1.CreateClusterRequest;
import com.google.container.v1.DeleteClusterRequest;
import com.google.container.v1.GetClusterRequest;
import com.google.container.v1.GetOperationRequest;
import com.google.container.v1.GetServerConfigRequest;
import com.google.container.v1.ListClustersRequest;
import com.google.container.v1.ListClustersResponse;
import com.google.container.v1.ListNodePoolsRequest;
import com.google.container.v1.ListNodePoolsResponse;
import com.google.container.v1.ListOperationsRequest;
import com.google.container.v1.ListOperationsResponse;
import com.google.container.v1.Operation;
import com.google.container.v1.ServerConfig;
import com.google.protobuf.Empty;
import com.google.protobuf.GeneratedMessageV3;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@javax.annotation.Generated("by GAPIC")
public class ClusterManagerClientTest {
  private static MockClusterManager mockClusterManager;
  private static MockServiceHelper serviceHelper;
  private ClusterManagerClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockClusterManager = new MockClusterManager();
    serviceHelper =
        new MockServiceHelper("in-process-1", Arrays.<MockGrpcService>asList(mockClusterManager));
    serviceHelper.start();
  }

  @AfterClass
  public static void stopServer() {
    serviceHelper.stop();
  }

  @Before
  public void setUp() throws IOException {
    serviceHelper.reset();
    channelProvider = serviceHelper.createChannelProvider();
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
  @SuppressWarnings("all")
  public void listClustersTest() {
    ListClustersResponse expectedResponse = ListClustersResponse.newBuilder().build();
    mockClusterManager.addResponse(expectedResponse);

    String formattedParent = ClusterManagerClient.formatLocationName("[PROJECT]", "[LOCATION]");

    ListClustersResponse actualResponse = client.listClusters(formattedParent);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockClusterManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListClustersRequest actualRequest = (ListClustersRequest) actualRequests.get(0);

    Assert.assertEquals(formattedParent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listClustersExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockClusterManager.addException(exception);

    try {
      String formattedParent = ClusterManagerClient.formatLocationName("[PROJECT]", "[LOCATION]");

      client.listClusters(formattedParent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getClusterTest() {
    String name2 = "name2-1052831874";
    String description = "description-1724546052";
    int initialNodeCount = 1682564205;
    String loggingService = "loggingService-1700501035";
    String monitoringService = "monitoringService1469270462";
    String network = "network1843485230";
    String clusterIpv4Cidr = "clusterIpv4Cidr-141875831";
    String subnetwork = "subnetwork-1302785042";
    boolean enableKubernetesAlpha = false;
    String labelFingerprint = "labelFingerprint714995737";
    String selfLink = "selfLink-1691268851";
    String zone = "zone3744684";
    String endpoint = "endpoint1741102485";
    String initialClusterVersion = "initialClusterVersion-276373352";
    String currentMasterVersion = "currentMasterVersion-920953983";
    String currentNodeVersion = "currentNodeVersion-407476063";
    String createTime = "createTime-493574096";
    String statusMessage = "statusMessage-239442758";
    int nodeIpv4CidrSize = 1181176815;
    String servicesIpv4Cidr = "servicesIpv4Cidr1966438125";
    int currentNodeCount = 178977560;
    String expireTime = "expireTime-96179731";
    String location = "location1901043637";
    Cluster expectedResponse =
        Cluster.newBuilder()
            .setName(name2)
            .setDescription(description)
            .setInitialNodeCount(initialNodeCount)
            .setLoggingService(loggingService)
            .setMonitoringService(monitoringService)
            .setNetwork(network)
            .setClusterIpv4Cidr(clusterIpv4Cidr)
            .setSubnetwork(subnetwork)
            .setEnableKubernetesAlpha(enableKubernetesAlpha)
            .setLabelFingerprint(labelFingerprint)
            .setSelfLink(selfLink)
            .setZone(zone)
            .setEndpoint(endpoint)
            .setInitialClusterVersion(initialClusterVersion)
            .setCurrentMasterVersion(currentMasterVersion)
            .setCurrentNodeVersion(currentNodeVersion)
            .setCreateTime(createTime)
            .setStatusMessage(statusMessage)
            .setNodeIpv4CidrSize(nodeIpv4CidrSize)
            .setServicesIpv4Cidr(servicesIpv4Cidr)
            .setCurrentNodeCount(currentNodeCount)
            .setExpireTime(expireTime)
            .setLocation(location)
            .build();
    mockClusterManager.addResponse(expectedResponse);

    String formattedName =
        ClusterManagerClient.formatClusterName("[PROJECT]", "[LOCATION]", "[CLUSTER]");

    Cluster actualResponse = client.getCluster(formattedName);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockClusterManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetClusterRequest actualRequest = (GetClusterRequest) actualRequests.get(0);

    Assert.assertEquals(formattedName, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getClusterExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockClusterManager.addException(exception);

    try {
      String formattedName =
          ClusterManagerClient.formatClusterName("[PROJECT]", "[LOCATION]", "[CLUSTER]");

      client.getCluster(formattedName);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createClusterTest() {
    String name = "name3373707";
    String zone = "zone3744684";
    String detail = "detail-1335224239";
    String statusMessage = "statusMessage-239442758";
    String selfLink = "selfLink-1691268851";
    String targetLink = "targetLink-2084812312";
    String location = "location1901043637";
    String startTime = "startTime-1573145462";
    String endTime = "endTime1725551537";
    Operation expectedResponse =
        Operation.newBuilder()
            .setName(name)
            .setZone(zone)
            .setDetail(detail)
            .setStatusMessage(statusMessage)
            .setSelfLink(selfLink)
            .setTargetLink(targetLink)
            .setLocation(location)
            .setStartTime(startTime)
            .setEndTime(endTime)
            .build();
    mockClusterManager.addResponse(expectedResponse);

    Cluster cluster = Cluster.newBuilder().build();
    String formattedParent = ClusterManagerClient.formatLocationName("[PROJECT]", "[LOCATION]");

    Operation actualResponse = client.createCluster(cluster, formattedParent);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockClusterManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateClusterRequest actualRequest = (CreateClusterRequest) actualRequests.get(0);

    Assert.assertEquals(cluster, actualRequest.getCluster());
    Assert.assertEquals(formattedParent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createClusterExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockClusterManager.addException(exception);

    try {
      Cluster cluster = Cluster.newBuilder().build();
      String formattedParent = ClusterManagerClient.formatLocationName("[PROJECT]", "[LOCATION]");

      client.createCluster(cluster, formattedParent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deleteClusterTest() {
    String name2 = "name2-1052831874";
    String zone = "zone3744684";
    String detail = "detail-1335224239";
    String statusMessage = "statusMessage-239442758";
    String selfLink = "selfLink-1691268851";
    String targetLink = "targetLink-2084812312";
    String location = "location1901043637";
    String startTime = "startTime-1573145462";
    String endTime = "endTime1725551537";
    Operation expectedResponse =
        Operation.newBuilder()
            .setName(name2)
            .setZone(zone)
            .setDetail(detail)
            .setStatusMessage(statusMessage)
            .setSelfLink(selfLink)
            .setTargetLink(targetLink)
            .setLocation(location)
            .setStartTime(startTime)
            .setEndTime(endTime)
            .build();
    mockClusterManager.addResponse(expectedResponse);

    String formattedName =
        ClusterManagerClient.formatClusterName("[PROJECT]", "[LOCATION]", "[CLUSTER]");

    Operation actualResponse = client.deleteCluster(formattedName);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockClusterManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteClusterRequest actualRequest = (DeleteClusterRequest) actualRequests.get(0);

    Assert.assertEquals(formattedName, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void deleteClusterExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockClusterManager.addException(exception);

    try {
      String formattedName =
          ClusterManagerClient.formatClusterName("[PROJECT]", "[LOCATION]", "[CLUSTER]");

      client.deleteCluster(formattedName);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listOperationsTest() {
    ListOperationsResponse expectedResponse = ListOperationsResponse.newBuilder().build();
    mockClusterManager.addResponse(expectedResponse);

    String formattedParent = ClusterManagerClient.formatLocationName("[PROJECT]", "[LOCATION]");

    ListOperationsResponse actualResponse = client.listOperations(formattedParent);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockClusterManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListOperationsRequest actualRequest = (ListOperationsRequest) actualRequests.get(0);

    Assert.assertEquals(formattedParent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listOperationsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockClusterManager.addException(exception);

    try {
      String formattedParent = ClusterManagerClient.formatLocationName("[PROJECT]", "[LOCATION]");

      client.listOperations(formattedParent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getOperationTest() {
    String name2 = "name2-1052831874";
    String zone = "zone3744684";
    String detail = "detail-1335224239";
    String statusMessage = "statusMessage-239442758";
    String selfLink = "selfLink-1691268851";
    String targetLink = "targetLink-2084812312";
    String location = "location1901043637";
    String startTime = "startTime-1573145462";
    String endTime = "endTime1725551537";
    Operation expectedResponse =
        Operation.newBuilder()
            .setName(name2)
            .setZone(zone)
            .setDetail(detail)
            .setStatusMessage(statusMessage)
            .setSelfLink(selfLink)
            .setTargetLink(targetLink)
            .setLocation(location)
            .setStartTime(startTime)
            .setEndTime(endTime)
            .build();
    mockClusterManager.addResponse(expectedResponse);

    String formattedName =
        ClusterManagerClient.formatOperationName("[PROJECT]", "[LOCATION]", "[OPERATION]");

    Operation actualResponse = client.getOperation(formattedName);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockClusterManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetOperationRequest actualRequest = (GetOperationRequest) actualRequests.get(0);

    Assert.assertEquals(formattedName, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getOperationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockClusterManager.addException(exception);

    try {
      String formattedName =
          ClusterManagerClient.formatOperationName("[PROJECT]", "[LOCATION]", "[OPERATION]");

      client.getOperation(formattedName);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void cancelOperationTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    mockClusterManager.addResponse(expectedResponse);

    String formattedName =
        ClusterManagerClient.formatOperationName("[PROJECT]", "[LOCATION]", "[OPERATION]");

    client.cancelOperation(formattedName);

    List<GeneratedMessageV3> actualRequests = mockClusterManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CancelOperationRequest actualRequest = (CancelOperationRequest) actualRequests.get(0);

    Assert.assertEquals(formattedName, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void cancelOperationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockClusterManager.addException(exception);

    try {
      String formattedName =
          ClusterManagerClient.formatOperationName("[PROJECT]", "[LOCATION]", "[OPERATION]");

      client.cancelOperation(formattedName);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getServerConfigTest() {
    String defaultClusterVersion = "defaultClusterVersion111003029";
    String defaultImageType = "defaultImageType-918225828";
    ServerConfig expectedResponse =
        ServerConfig.newBuilder()
            .setDefaultClusterVersion(defaultClusterVersion)
            .setDefaultImageType(defaultImageType)
            .build();
    mockClusterManager.addResponse(expectedResponse);

    String formattedName = ClusterManagerClient.formatLocationName("[PROJECT]", "[LOCATION]");

    ServerConfig actualResponse = client.getServerConfig(formattedName);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockClusterManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetServerConfigRequest actualRequest = (GetServerConfigRequest) actualRequests.get(0);

    Assert.assertEquals(formattedName, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getServerConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockClusterManager.addException(exception);

    try {
      String formattedName = ClusterManagerClient.formatLocationName("[PROJECT]", "[LOCATION]");

      client.getServerConfig(formattedName);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listNodePoolsTest() {
    ListNodePoolsResponse expectedResponse = ListNodePoolsResponse.newBuilder().build();
    mockClusterManager.addResponse(expectedResponse);

    String formattedParent =
        ClusterManagerClient.formatClusterName("[PROJECT]", "[LOCATION]", "[CLUSTER]");

    ListNodePoolsResponse actualResponse = client.listNodePools(formattedParent);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockClusterManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListNodePoolsRequest actualRequest = (ListNodePoolsRequest) actualRequests.get(0);

    Assert.assertEquals(formattedParent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listNodePoolsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockClusterManager.addException(exception);

    try {
      String formattedParent =
          ClusterManagerClient.formatClusterName("[PROJECT]", "[LOCATION]", "[CLUSTER]");

      client.listNodePools(formattedParent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void completeIPRotationTest() {
    String name2 = "name2-1052831874";
    String zone = "zone3744684";
    String detail = "detail-1335224239";
    String statusMessage = "statusMessage-239442758";
    String selfLink = "selfLink-1691268851";
    String targetLink = "targetLink-2084812312";
    String location = "location1901043637";
    String startTime = "startTime-1573145462";
    String endTime = "endTime1725551537";
    Operation expectedResponse =
        Operation.newBuilder()
            .setName(name2)
            .setZone(zone)
            .setDetail(detail)
            .setStatusMessage(statusMessage)
            .setSelfLink(selfLink)
            .setTargetLink(targetLink)
            .setLocation(location)
            .setStartTime(startTime)
            .setEndTime(endTime)
            .build();
    mockClusterManager.addResponse(expectedResponse);

    String formattedName =
        ClusterManagerClient.formatClusterName("[PROJECT]", "[LOCATION]", "[CLUSTER]");

    Operation actualResponse = client.completeIPRotation(formattedName);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockClusterManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CompleteIPRotationRequest actualRequest = (CompleteIPRotationRequest) actualRequests.get(0);

    Assert.assertEquals(formattedName, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void completeIPRotationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockClusterManager.addException(exception);

    try {
      String formattedName =
          ClusterManagerClient.formatClusterName("[PROJECT]", "[LOCATION]", "[CLUSTER]");

      client.completeIPRotation(formattedName);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }
}
