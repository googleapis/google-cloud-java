/*
 * Copyright 2017 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.bigtable.admin.v2;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.bigtable.admin.v2.Cluster;
import com.google.bigtable.admin.v2.ClusterName;
import com.google.bigtable.admin.v2.CreateClusterRequest;
import com.google.bigtable.admin.v2.CreateInstanceRequest;
import com.google.bigtable.admin.v2.DeleteClusterRequest;
import com.google.bigtable.admin.v2.DeleteInstanceRequest;
import com.google.bigtable.admin.v2.GetClusterRequest;
import com.google.bigtable.admin.v2.GetInstanceRequest;
import com.google.bigtable.admin.v2.Instance;
import com.google.bigtable.admin.v2.Instance.Type;
import com.google.bigtable.admin.v2.InstanceName;
import com.google.bigtable.admin.v2.ListClustersRequest;
import com.google.bigtable.admin.v2.ListClustersResponse;
import com.google.bigtable.admin.v2.ListInstancesRequest;
import com.google.bigtable.admin.v2.ListInstancesResponse;
import com.google.bigtable.admin.v2.LocationName;
import com.google.bigtable.admin.v2.ProjectName;
import com.google.bigtable.admin.v2.StorageType;
import com.google.longrunning.Operation;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.protobuf.GeneratedMessageV3;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@javax.annotation.Generated("by GAPIC")
public class BigtableInstanceAdminClientTest {
  private static MockBigtableInstanceAdmin mockBigtableInstanceAdmin;
  private static MockBigtableTableAdmin mockBigtableTableAdmin;
  private static MockServiceHelper serviceHelper;
  private BigtableInstanceAdminClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockBigtableInstanceAdmin = new MockBigtableInstanceAdmin();
    mockBigtableTableAdmin = new MockBigtableTableAdmin();
    serviceHelper =
        new MockServiceHelper(
            "in-process-1",
            Arrays.<MockGrpcService>asList(mockBigtableInstanceAdmin, mockBigtableTableAdmin));
    serviceHelper.start();
  }

  @AfterClass
  public static void stopServer() {
    serviceHelper.stop();
  }

  @Before
  public void setUp() throws IOException {
    serviceHelper.reset();
    BigtableInstanceAdminSettings settings =
        BigtableInstanceAdminSettings.newBuilder()
            .setTransportChannelProvider(serviceHelper.createChannelProvider())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = BigtableInstanceAdminClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void createInstanceTest() throws Exception {
    InstanceName name = InstanceName.of("[PROJECT]", "[INSTANCE]");
    String displayName = "displayName1615086568";
    Instance expectedResponse =
        Instance.newBuilder().setNameWithInstanceName(name).setDisplayName(displayName).build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createInstanceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockBigtableInstanceAdmin.addResponse(resultOperation);

    ProjectName parent = ProjectName.of("[PROJECT]");
    String instanceId = "instanceId-2101995259";
    Instance instance = Instance.newBuilder().build();
    Map<String, Cluster> clusters = new HashMap<>();

    Instance actualResponse =
        client.createInstanceAsync(parent, instanceId, instance, clusters).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockBigtableInstanceAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateInstanceRequest actualRequest = (CreateInstanceRequest) actualRequests.get(0);

    Assert.assertEquals(parent, actualRequest.getParentAsProjectName());
    Assert.assertEquals(instanceId, actualRequest.getInstanceId());
    Assert.assertEquals(instance, actualRequest.getInstance());
    Assert.assertEquals(clusters, actualRequest.getClustersMap());
  }

  @Test
  @SuppressWarnings("all")
  public void createInstanceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockBigtableInstanceAdmin.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      String instanceId = "instanceId-2101995259";
      Instance instance = Instance.newBuilder().build();
      Map<String, Cluster> clusters = new HashMap<>();

      client.createInstanceAsync(parent, instanceId, instance, clusters).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getInstanceTest() {
    InstanceName name2 = InstanceName.of("[PROJECT]", "[INSTANCE]");
    String displayName = "displayName1615086568";
    Instance expectedResponse =
        Instance.newBuilder().setNameWithInstanceName(name2).setDisplayName(displayName).build();
    mockBigtableInstanceAdmin.addResponse(expectedResponse);

    InstanceName name = InstanceName.of("[PROJECT]", "[INSTANCE]");

    Instance actualResponse = client.getInstance(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockBigtableInstanceAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetInstanceRequest actualRequest = (GetInstanceRequest) actualRequests.get(0);

    Assert.assertEquals(name, actualRequest.getNameAsInstanceName());
  }

  @Test
  @SuppressWarnings("all")
  public void getInstanceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockBigtableInstanceAdmin.addException(exception);

    try {
      InstanceName name = InstanceName.of("[PROJECT]", "[INSTANCE]");

      client.getInstance(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listInstancesTest() {
    String nextPageToken = "nextPageToken-1530815211";
    ListInstancesResponse expectedResponse =
        ListInstancesResponse.newBuilder().setNextPageToken(nextPageToken).build();
    mockBigtableInstanceAdmin.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");

    ListInstancesResponse actualResponse = client.listInstances(parent);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockBigtableInstanceAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListInstancesRequest actualRequest = (ListInstancesRequest) actualRequests.get(0);

    Assert.assertEquals(parent, actualRequest.getParentAsProjectName());
  }

  @Test
  @SuppressWarnings("all")
  public void listInstancesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockBigtableInstanceAdmin.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");

      client.listInstances(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateInstanceTest() {
    InstanceName name2 = InstanceName.of("[PROJECT]", "[INSTANCE]");
    String displayName2 = "displayName21615000987";
    Instance expectedResponse =
        Instance.newBuilder().setNameWithInstanceName(name2).setDisplayName(displayName2).build();
    mockBigtableInstanceAdmin.addResponse(expectedResponse);

    InstanceName name = InstanceName.of("[PROJECT]", "[INSTANCE]");
    String displayName = "displayName1615086568";
    Instance.Type type = Instance.Type.TYPE_UNSPECIFIED;

    Instance actualResponse = client.updateInstance(name, displayName, type);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockBigtableInstanceAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    Instance actualRequest = (Instance) actualRequests.get(0);

    Assert.assertEquals(name, actualRequest.getNameAsInstanceName());
    Assert.assertEquals(displayName, actualRequest.getDisplayName());
    Assert.assertEquals(type, actualRequest.getType());
  }

  @Test
  @SuppressWarnings("all")
  public void updateInstanceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockBigtableInstanceAdmin.addException(exception);

    try {
      InstanceName name = InstanceName.of("[PROJECT]", "[INSTANCE]");
      String displayName = "displayName1615086568";
      Instance.Type type = Instance.Type.TYPE_UNSPECIFIED;

      client.updateInstance(name, displayName, type);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deleteInstanceTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    mockBigtableInstanceAdmin.addResponse(expectedResponse);

    InstanceName name = InstanceName.of("[PROJECT]", "[INSTANCE]");

    client.deleteInstance(name);

    List<GeneratedMessageV3> actualRequests = mockBigtableInstanceAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteInstanceRequest actualRequest = (DeleteInstanceRequest) actualRequests.get(0);

    Assert.assertEquals(name, actualRequest.getNameAsInstanceName());
  }

  @Test
  @SuppressWarnings("all")
  public void deleteInstanceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockBigtableInstanceAdmin.addException(exception);

    try {
      InstanceName name = InstanceName.of("[PROJECT]", "[INSTANCE]");

      client.deleteInstance(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createClusterTest() throws Exception {
    ClusterName name = ClusterName.of("[PROJECT]", "[INSTANCE]", "[CLUSTER]");
    LocationName location = LocationName.of("[PROJECT]", "[LOCATION]");
    int serveNodes = -1288838783;
    Cluster expectedResponse =
        Cluster.newBuilder()
            .setNameWithClusterName(name)
            .setLocationWithLocationName(location)
            .setServeNodes(serveNodes)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createClusterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockBigtableInstanceAdmin.addResponse(resultOperation);

    InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");
    String clusterId = "clusterId240280960";
    Cluster cluster = Cluster.newBuilder().build();

    Cluster actualResponse = client.createClusterAsync(parent, clusterId, cluster).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockBigtableInstanceAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateClusterRequest actualRequest = (CreateClusterRequest) actualRequests.get(0);

    Assert.assertEquals(parent, actualRequest.getParentAsInstanceName());
    Assert.assertEquals(clusterId, actualRequest.getClusterId());
    Assert.assertEquals(cluster, actualRequest.getCluster());
  }

  @Test
  @SuppressWarnings("all")
  public void createClusterExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockBigtableInstanceAdmin.addException(exception);

    try {
      InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");
      String clusterId = "clusterId240280960";
      Cluster cluster = Cluster.newBuilder().build();

      client.createClusterAsync(parent, clusterId, cluster).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getClusterTest() {
    ClusterName name2 = ClusterName.of("[PROJECT]", "[INSTANCE]", "[CLUSTER]");
    LocationName location = LocationName.of("[PROJECT]", "[LOCATION]");
    int serveNodes = -1288838783;
    Cluster expectedResponse =
        Cluster.newBuilder()
            .setNameWithClusterName(name2)
            .setLocationWithLocationName(location)
            .setServeNodes(serveNodes)
            .build();
    mockBigtableInstanceAdmin.addResponse(expectedResponse);

    ClusterName name = ClusterName.of("[PROJECT]", "[INSTANCE]", "[CLUSTER]");

    Cluster actualResponse = client.getCluster(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockBigtableInstanceAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetClusterRequest actualRequest = (GetClusterRequest) actualRequests.get(0);

    Assert.assertEquals(name, actualRequest.getNameAsClusterName());
  }

  @Test
  @SuppressWarnings("all")
  public void getClusterExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockBigtableInstanceAdmin.addException(exception);

    try {
      ClusterName name = ClusterName.of("[PROJECT]", "[INSTANCE]", "[CLUSTER]");

      client.getCluster(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listClustersTest() {
    String nextPageToken = "nextPageToken-1530815211";
    ListClustersResponse expectedResponse =
        ListClustersResponse.newBuilder().setNextPageToken(nextPageToken).build();
    mockBigtableInstanceAdmin.addResponse(expectedResponse);

    InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");

    ListClustersResponse actualResponse = client.listClusters(parent);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockBigtableInstanceAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListClustersRequest actualRequest = (ListClustersRequest) actualRequests.get(0);

    Assert.assertEquals(parent, actualRequest.getParentAsInstanceName());
  }

  @Test
  @SuppressWarnings("all")
  public void listClustersExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockBigtableInstanceAdmin.addException(exception);

    try {
      InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");

      client.listClusters(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateClusterTest() throws Exception {
    ClusterName name2 = ClusterName.of("[PROJECT]", "[INSTANCE]", "[CLUSTER]");
    LocationName location2 = LocationName.of("[PROJECT]", "[LOCATION]");
    int serveNodes2 = -1623486220;
    Cluster expectedResponse =
        Cluster.newBuilder()
            .setNameWithClusterName(name2)
            .setLocationWithLocationName(location2)
            .setServeNodes(serveNodes2)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateClusterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockBigtableInstanceAdmin.addResponse(resultOperation);

    ClusterName name = ClusterName.of("[PROJECT]", "[INSTANCE]", "[CLUSTER]");
    LocationName location = LocationName.of("[PROJECT]", "[LOCATION]");
    int serveNodes = -1288838783;
    StorageType defaultStorageType = StorageType.STORAGE_TYPE_UNSPECIFIED;

    Cluster actualResponse =
        client.updateClusterAsync(name, location, serveNodes, defaultStorageType).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockBigtableInstanceAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    Cluster actualRequest = (Cluster) actualRequests.get(0);

    Assert.assertEquals(name, actualRequest.getNameAsClusterName());
    Assert.assertEquals(location, actualRequest.getLocationAsLocationName());
    Assert.assertEquals(serveNodes, actualRequest.getServeNodes());
    Assert.assertEquals(defaultStorageType, actualRequest.getDefaultStorageType());
  }

  @Test
  @SuppressWarnings("all")
  public void updateClusterExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockBigtableInstanceAdmin.addException(exception);

    try {
      ClusterName name = ClusterName.of("[PROJECT]", "[INSTANCE]", "[CLUSTER]");
      LocationName location = LocationName.of("[PROJECT]", "[LOCATION]");
      int serveNodes = -1288838783;
      StorageType defaultStorageType = StorageType.STORAGE_TYPE_UNSPECIFIED;

      client.updateClusterAsync(name, location, serveNodes, defaultStorageType).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deleteClusterTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    mockBigtableInstanceAdmin.addResponse(expectedResponse);

    ClusterName name = ClusterName.of("[PROJECT]", "[INSTANCE]", "[CLUSTER]");

    client.deleteCluster(name);

    List<GeneratedMessageV3> actualRequests = mockBigtableInstanceAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteClusterRequest actualRequest = (DeleteClusterRequest) actualRequests.get(0);

    Assert.assertEquals(name, actualRequest.getNameAsClusterName());
  }

  @Test
  @SuppressWarnings("all")
  public void deleteClusterExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockBigtableInstanceAdmin.addException(exception);

    try {
      ClusterName name = ClusterName.of("[PROJECT]", "[INSTANCE]", "[CLUSTER]");

      client.deleteCluster(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }
}
