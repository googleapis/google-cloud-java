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

package com.google.cloud.gkemulticloud.v1;

import static com.google.cloud.gkemulticloud.v1.AttachedClustersClient.ListAttachedClustersPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class AttachedClustersClientTest {
  private static MockAttachedClusters mockAttachedClusters;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private AttachedClustersClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockAttachedClusters = new MockAttachedClusters();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockAttachedClusters));
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
    AttachedClustersSettings settings =
        AttachedClustersSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = AttachedClustersClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createAttachedClusterTest() throws Exception {
    AttachedCluster expectedResponse =
        AttachedCluster.newBuilder()
            .setName(
                AttachedClusterName.of("[PROJECT]", "[LOCATION]", "[ATTACHED_CLUSTER]").toString())
            .setDescription("description-1724546052")
            .setOidcConfig(AttachedOidcConfig.newBuilder().build())
            .setPlatformVersion("platformVersion1848800485")
            .setDistribution("distribution-1580708220")
            .setClusterRegion("clusterRegion-1876082290")
            .setFleet(Fleet.newBuilder().build())
            .setUid("uid115792")
            .setReconciling(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setKubernetesVersion("kubernetesVersion-424816974")
            .putAllAnnotations(new HashMap<String, String>())
            .setWorkloadIdentityConfig(WorkloadIdentityConfig.newBuilder().build())
            .setLoggingConfig(LoggingConfig.newBuilder().build())
            .addAllErrors(new ArrayList<AttachedClusterError>())
            .setAuthorization(AttachedClustersAuthorization.newBuilder().build())
            .setMonitoringConfig(MonitoringConfig.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createAttachedClusterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAttachedClusters.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    AttachedCluster attachedCluster = AttachedCluster.newBuilder().build();
    String attachedClusterId = "attachedClusterId865943409";

    AttachedCluster actualResponse =
        client.createAttachedClusterAsync(parent, attachedCluster, attachedClusterId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAttachedClusters.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateAttachedClusterRequest actualRequest =
        ((CreateAttachedClusterRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(attachedCluster, actualRequest.getAttachedCluster());
    Assert.assertEquals(attachedClusterId, actualRequest.getAttachedClusterId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createAttachedClusterExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAttachedClusters.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      AttachedCluster attachedCluster = AttachedCluster.newBuilder().build();
      String attachedClusterId = "attachedClusterId865943409";
      client.createAttachedClusterAsync(parent, attachedCluster, attachedClusterId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createAttachedClusterTest2() throws Exception {
    AttachedCluster expectedResponse =
        AttachedCluster.newBuilder()
            .setName(
                AttachedClusterName.of("[PROJECT]", "[LOCATION]", "[ATTACHED_CLUSTER]").toString())
            .setDescription("description-1724546052")
            .setOidcConfig(AttachedOidcConfig.newBuilder().build())
            .setPlatformVersion("platformVersion1848800485")
            .setDistribution("distribution-1580708220")
            .setClusterRegion("clusterRegion-1876082290")
            .setFleet(Fleet.newBuilder().build())
            .setUid("uid115792")
            .setReconciling(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setKubernetesVersion("kubernetesVersion-424816974")
            .putAllAnnotations(new HashMap<String, String>())
            .setWorkloadIdentityConfig(WorkloadIdentityConfig.newBuilder().build())
            .setLoggingConfig(LoggingConfig.newBuilder().build())
            .addAllErrors(new ArrayList<AttachedClusterError>())
            .setAuthorization(AttachedClustersAuthorization.newBuilder().build())
            .setMonitoringConfig(MonitoringConfig.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createAttachedClusterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAttachedClusters.addResponse(resultOperation);

    String parent = "parent-995424086";
    AttachedCluster attachedCluster = AttachedCluster.newBuilder().build();
    String attachedClusterId = "attachedClusterId865943409";

    AttachedCluster actualResponse =
        client.createAttachedClusterAsync(parent, attachedCluster, attachedClusterId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAttachedClusters.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateAttachedClusterRequest actualRequest =
        ((CreateAttachedClusterRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(attachedCluster, actualRequest.getAttachedCluster());
    Assert.assertEquals(attachedClusterId, actualRequest.getAttachedClusterId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createAttachedClusterExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAttachedClusters.addException(exception);

    try {
      String parent = "parent-995424086";
      AttachedCluster attachedCluster = AttachedCluster.newBuilder().build();
      String attachedClusterId = "attachedClusterId865943409";
      client.createAttachedClusterAsync(parent, attachedCluster, attachedClusterId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateAttachedClusterTest() throws Exception {
    AttachedCluster expectedResponse =
        AttachedCluster.newBuilder()
            .setName(
                AttachedClusterName.of("[PROJECT]", "[LOCATION]", "[ATTACHED_CLUSTER]").toString())
            .setDescription("description-1724546052")
            .setOidcConfig(AttachedOidcConfig.newBuilder().build())
            .setPlatformVersion("platformVersion1848800485")
            .setDistribution("distribution-1580708220")
            .setClusterRegion("clusterRegion-1876082290")
            .setFleet(Fleet.newBuilder().build())
            .setUid("uid115792")
            .setReconciling(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setKubernetesVersion("kubernetesVersion-424816974")
            .putAllAnnotations(new HashMap<String, String>())
            .setWorkloadIdentityConfig(WorkloadIdentityConfig.newBuilder().build())
            .setLoggingConfig(LoggingConfig.newBuilder().build())
            .addAllErrors(new ArrayList<AttachedClusterError>())
            .setAuthorization(AttachedClustersAuthorization.newBuilder().build())
            .setMonitoringConfig(MonitoringConfig.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateAttachedClusterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAttachedClusters.addResponse(resultOperation);

    AttachedCluster attachedCluster = AttachedCluster.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    AttachedCluster actualResponse =
        client.updateAttachedClusterAsync(attachedCluster, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAttachedClusters.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateAttachedClusterRequest actualRequest =
        ((UpdateAttachedClusterRequest) actualRequests.get(0));

    Assert.assertEquals(attachedCluster, actualRequest.getAttachedCluster());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateAttachedClusterExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAttachedClusters.addException(exception);

    try {
      AttachedCluster attachedCluster = AttachedCluster.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateAttachedClusterAsync(attachedCluster, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void importAttachedClusterTest() throws Exception {
    AttachedCluster expectedResponse =
        AttachedCluster.newBuilder()
            .setName(
                AttachedClusterName.of("[PROJECT]", "[LOCATION]", "[ATTACHED_CLUSTER]").toString())
            .setDescription("description-1724546052")
            .setOidcConfig(AttachedOidcConfig.newBuilder().build())
            .setPlatformVersion("platformVersion1848800485")
            .setDistribution("distribution-1580708220")
            .setClusterRegion("clusterRegion-1876082290")
            .setFleet(Fleet.newBuilder().build())
            .setUid("uid115792")
            .setReconciling(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setKubernetesVersion("kubernetesVersion-424816974")
            .putAllAnnotations(new HashMap<String, String>())
            .setWorkloadIdentityConfig(WorkloadIdentityConfig.newBuilder().build())
            .setLoggingConfig(LoggingConfig.newBuilder().build())
            .addAllErrors(new ArrayList<AttachedClusterError>())
            .setAuthorization(AttachedClustersAuthorization.newBuilder().build())
            .setMonitoringConfig(MonitoringConfig.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("importAttachedClusterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAttachedClusters.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    String fleetMembership = "fleetMembership-665479228";

    AttachedCluster actualResponse =
        client.importAttachedClusterAsync(parent, fleetMembership).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAttachedClusters.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ImportAttachedClusterRequest actualRequest =
        ((ImportAttachedClusterRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(fleetMembership, actualRequest.getFleetMembership());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void importAttachedClusterExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAttachedClusters.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      String fleetMembership = "fleetMembership-665479228";
      client.importAttachedClusterAsync(parent, fleetMembership).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void importAttachedClusterTest2() throws Exception {
    AttachedCluster expectedResponse =
        AttachedCluster.newBuilder()
            .setName(
                AttachedClusterName.of("[PROJECT]", "[LOCATION]", "[ATTACHED_CLUSTER]").toString())
            .setDescription("description-1724546052")
            .setOidcConfig(AttachedOidcConfig.newBuilder().build())
            .setPlatformVersion("platformVersion1848800485")
            .setDistribution("distribution-1580708220")
            .setClusterRegion("clusterRegion-1876082290")
            .setFleet(Fleet.newBuilder().build())
            .setUid("uid115792")
            .setReconciling(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setKubernetesVersion("kubernetesVersion-424816974")
            .putAllAnnotations(new HashMap<String, String>())
            .setWorkloadIdentityConfig(WorkloadIdentityConfig.newBuilder().build())
            .setLoggingConfig(LoggingConfig.newBuilder().build())
            .addAllErrors(new ArrayList<AttachedClusterError>())
            .setAuthorization(AttachedClustersAuthorization.newBuilder().build())
            .setMonitoringConfig(MonitoringConfig.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("importAttachedClusterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAttachedClusters.addResponse(resultOperation);

    String parent = "parent-995424086";
    String fleetMembership = "fleetMembership-665479228";

    AttachedCluster actualResponse =
        client.importAttachedClusterAsync(parent, fleetMembership).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAttachedClusters.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ImportAttachedClusterRequest actualRequest =
        ((ImportAttachedClusterRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(fleetMembership, actualRequest.getFleetMembership());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void importAttachedClusterExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAttachedClusters.addException(exception);

    try {
      String parent = "parent-995424086";
      String fleetMembership = "fleetMembership-665479228";
      client.importAttachedClusterAsync(parent, fleetMembership).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void getAttachedClusterTest() throws Exception {
    AttachedCluster expectedResponse =
        AttachedCluster.newBuilder()
            .setName(
                AttachedClusterName.of("[PROJECT]", "[LOCATION]", "[ATTACHED_CLUSTER]").toString())
            .setDescription("description-1724546052")
            .setOidcConfig(AttachedOidcConfig.newBuilder().build())
            .setPlatformVersion("platformVersion1848800485")
            .setDistribution("distribution-1580708220")
            .setClusterRegion("clusterRegion-1876082290")
            .setFleet(Fleet.newBuilder().build())
            .setUid("uid115792")
            .setReconciling(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setKubernetesVersion("kubernetesVersion-424816974")
            .putAllAnnotations(new HashMap<String, String>())
            .setWorkloadIdentityConfig(WorkloadIdentityConfig.newBuilder().build())
            .setLoggingConfig(LoggingConfig.newBuilder().build())
            .addAllErrors(new ArrayList<AttachedClusterError>())
            .setAuthorization(AttachedClustersAuthorization.newBuilder().build())
            .setMonitoringConfig(MonitoringConfig.newBuilder().build())
            .build();
    mockAttachedClusters.addResponse(expectedResponse);

    AttachedClusterName name =
        AttachedClusterName.of("[PROJECT]", "[LOCATION]", "[ATTACHED_CLUSTER]");

    AttachedCluster actualResponse = client.getAttachedCluster(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAttachedClusters.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAttachedClusterRequest actualRequest = ((GetAttachedClusterRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAttachedClusterExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAttachedClusters.addException(exception);

    try {
      AttachedClusterName name =
          AttachedClusterName.of("[PROJECT]", "[LOCATION]", "[ATTACHED_CLUSTER]");
      client.getAttachedCluster(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAttachedClusterTest2() throws Exception {
    AttachedCluster expectedResponse =
        AttachedCluster.newBuilder()
            .setName(
                AttachedClusterName.of("[PROJECT]", "[LOCATION]", "[ATTACHED_CLUSTER]").toString())
            .setDescription("description-1724546052")
            .setOidcConfig(AttachedOidcConfig.newBuilder().build())
            .setPlatformVersion("platformVersion1848800485")
            .setDistribution("distribution-1580708220")
            .setClusterRegion("clusterRegion-1876082290")
            .setFleet(Fleet.newBuilder().build())
            .setUid("uid115792")
            .setReconciling(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setKubernetesVersion("kubernetesVersion-424816974")
            .putAllAnnotations(new HashMap<String, String>())
            .setWorkloadIdentityConfig(WorkloadIdentityConfig.newBuilder().build())
            .setLoggingConfig(LoggingConfig.newBuilder().build())
            .addAllErrors(new ArrayList<AttachedClusterError>())
            .setAuthorization(AttachedClustersAuthorization.newBuilder().build())
            .setMonitoringConfig(MonitoringConfig.newBuilder().build())
            .build();
    mockAttachedClusters.addResponse(expectedResponse);

    String name = "name3373707";

    AttachedCluster actualResponse = client.getAttachedCluster(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAttachedClusters.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAttachedClusterRequest actualRequest = ((GetAttachedClusterRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAttachedClusterExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAttachedClusters.addException(exception);

    try {
      String name = "name3373707";
      client.getAttachedCluster(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAttachedClustersTest() throws Exception {
    AttachedCluster responsesElement = AttachedCluster.newBuilder().build();
    ListAttachedClustersResponse expectedResponse =
        ListAttachedClustersResponse.newBuilder()
            .setNextPageToken("")
            .addAllAttachedClusters(Arrays.asList(responsesElement))
            .build();
    mockAttachedClusters.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListAttachedClustersPagedResponse pagedListResponse = client.listAttachedClusters(parent);

    List<AttachedCluster> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAttachedClustersList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAttachedClusters.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAttachedClustersRequest actualRequest =
        ((ListAttachedClustersRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAttachedClustersExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAttachedClusters.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listAttachedClusters(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAttachedClustersTest2() throws Exception {
    AttachedCluster responsesElement = AttachedCluster.newBuilder().build();
    ListAttachedClustersResponse expectedResponse =
        ListAttachedClustersResponse.newBuilder()
            .setNextPageToken("")
            .addAllAttachedClusters(Arrays.asList(responsesElement))
            .build();
    mockAttachedClusters.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListAttachedClustersPagedResponse pagedListResponse = client.listAttachedClusters(parent);

    List<AttachedCluster> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAttachedClustersList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAttachedClusters.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAttachedClustersRequest actualRequest =
        ((ListAttachedClustersRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAttachedClustersExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAttachedClusters.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listAttachedClusters(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteAttachedClusterTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteAttachedClusterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAttachedClusters.addResponse(resultOperation);

    AttachedClusterName name =
        AttachedClusterName.of("[PROJECT]", "[LOCATION]", "[ATTACHED_CLUSTER]");

    client.deleteAttachedClusterAsync(name).get();

    List<AbstractMessage> actualRequests = mockAttachedClusters.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteAttachedClusterRequest actualRequest =
        ((DeleteAttachedClusterRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteAttachedClusterExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAttachedClusters.addException(exception);

    try {
      AttachedClusterName name =
          AttachedClusterName.of("[PROJECT]", "[LOCATION]", "[ATTACHED_CLUSTER]");
      client.deleteAttachedClusterAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteAttachedClusterTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteAttachedClusterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAttachedClusters.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteAttachedClusterAsync(name).get();

    List<AbstractMessage> actualRequests = mockAttachedClusters.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteAttachedClusterRequest actualRequest =
        ((DeleteAttachedClusterRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteAttachedClusterExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAttachedClusters.addException(exception);

    try {
      String name = "name3373707";
      client.deleteAttachedClusterAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void getAttachedServerConfigTest() throws Exception {
    AttachedServerConfig expectedResponse =
        AttachedServerConfig.newBuilder()
            .setName(AttachedServerConfigName.of("[PROJECT]", "[LOCATION]").toString())
            .addAllValidVersions(new ArrayList<AttachedPlatformVersionInfo>())
            .build();
    mockAttachedClusters.addResponse(expectedResponse);

    AttachedServerConfigName name = AttachedServerConfigName.of("[PROJECT]", "[LOCATION]");

    AttachedServerConfig actualResponse = client.getAttachedServerConfig(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAttachedClusters.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAttachedServerConfigRequest actualRequest =
        ((GetAttachedServerConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAttachedServerConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAttachedClusters.addException(exception);

    try {
      AttachedServerConfigName name = AttachedServerConfigName.of("[PROJECT]", "[LOCATION]");
      client.getAttachedServerConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAttachedServerConfigTest2() throws Exception {
    AttachedServerConfig expectedResponse =
        AttachedServerConfig.newBuilder()
            .setName(AttachedServerConfigName.of("[PROJECT]", "[LOCATION]").toString())
            .addAllValidVersions(new ArrayList<AttachedPlatformVersionInfo>())
            .build();
    mockAttachedClusters.addResponse(expectedResponse);

    String name = "name3373707";

    AttachedServerConfig actualResponse = client.getAttachedServerConfig(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAttachedClusters.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAttachedServerConfigRequest actualRequest =
        ((GetAttachedServerConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAttachedServerConfigExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAttachedClusters.addException(exception);

    try {
      String name = "name3373707";
      client.getAttachedServerConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void generateAttachedClusterInstallManifestTest() throws Exception {
    GenerateAttachedClusterInstallManifestResponse expectedResponse =
        GenerateAttachedClusterInstallManifestResponse.newBuilder()
            .setManifest("manifest130625071")
            .build();
    mockAttachedClusters.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    String attachedClusterId = "attachedClusterId865943409";

    GenerateAttachedClusterInstallManifestResponse actualResponse =
        client.generateAttachedClusterInstallManifest(parent, attachedClusterId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAttachedClusters.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GenerateAttachedClusterInstallManifestRequest actualRequest =
        ((GenerateAttachedClusterInstallManifestRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(attachedClusterId, actualRequest.getAttachedClusterId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void generateAttachedClusterInstallManifestExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAttachedClusters.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      String attachedClusterId = "attachedClusterId865943409";
      client.generateAttachedClusterInstallManifest(parent, attachedClusterId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void generateAttachedClusterInstallManifestTest2() throws Exception {
    GenerateAttachedClusterInstallManifestResponse expectedResponse =
        GenerateAttachedClusterInstallManifestResponse.newBuilder()
            .setManifest("manifest130625071")
            .build();
    mockAttachedClusters.addResponse(expectedResponse);

    String parent = "parent-995424086";
    String attachedClusterId = "attachedClusterId865943409";

    GenerateAttachedClusterInstallManifestResponse actualResponse =
        client.generateAttachedClusterInstallManifest(parent, attachedClusterId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAttachedClusters.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GenerateAttachedClusterInstallManifestRequest actualRequest =
        ((GenerateAttachedClusterInstallManifestRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(attachedClusterId, actualRequest.getAttachedClusterId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void generateAttachedClusterInstallManifestExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAttachedClusters.addException(exception);

    try {
      String parent = "parent-995424086";
      String attachedClusterId = "attachedClusterId865943409";
      client.generateAttachedClusterInstallManifest(parent, attachedClusterId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
