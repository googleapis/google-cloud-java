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

import static com.google.cloud.gkemulticloud.v1.AzureClustersClient.ListAzureClientsPagedResponse;
import static com.google.cloud.gkemulticloud.v1.AzureClustersClient.ListAzureClustersPagedResponse;
import static com.google.cloud.gkemulticloud.v1.AzureClustersClient.ListAzureNodePoolsPagedResponse;

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
public class AzureClustersClientTest {
  private static MockAzureClusters mockAzureClusters;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private AzureClustersClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockAzureClusters = new MockAzureClusters();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockAzureClusters));
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
    AzureClustersSettings settings =
        AzureClustersSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = AzureClustersClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createAzureClientTest() throws Exception {
    AzureClient expectedResponse =
        AzureClient.newBuilder()
            .setName(AzureClientName.of("[PROJECT]", "[LOCATION]", "[AZURE_CLIENT]").toString())
            .setTenantId("tenantId-1306693787")
            .setApplicationId("applicationId-1011352949")
            .putAllAnnotations(new HashMap<String, String>())
            .setPemCertificate("pemCertificate153491807")
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createAzureClientTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAzureClusters.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    AzureClient azureClient = AzureClient.newBuilder().build();
    String azureClientId = "azureClientId-1735934475";

    AzureClient actualResponse =
        client.createAzureClientAsync(parent, azureClient, azureClientId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAzureClusters.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateAzureClientRequest actualRequest = ((CreateAzureClientRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(azureClient, actualRequest.getAzureClient());
    Assert.assertEquals(azureClientId, actualRequest.getAzureClientId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createAzureClientExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAzureClusters.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      AzureClient azureClient = AzureClient.newBuilder().build();
      String azureClientId = "azureClientId-1735934475";
      client.createAzureClientAsync(parent, azureClient, azureClientId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createAzureClientTest2() throws Exception {
    AzureClient expectedResponse =
        AzureClient.newBuilder()
            .setName(AzureClientName.of("[PROJECT]", "[LOCATION]", "[AZURE_CLIENT]").toString())
            .setTenantId("tenantId-1306693787")
            .setApplicationId("applicationId-1011352949")
            .putAllAnnotations(new HashMap<String, String>())
            .setPemCertificate("pemCertificate153491807")
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createAzureClientTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAzureClusters.addResponse(resultOperation);

    String parent = "parent-995424086";
    AzureClient azureClient = AzureClient.newBuilder().build();
    String azureClientId = "azureClientId-1735934475";

    AzureClient actualResponse =
        client.createAzureClientAsync(parent, azureClient, azureClientId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAzureClusters.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateAzureClientRequest actualRequest = ((CreateAzureClientRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(azureClient, actualRequest.getAzureClient());
    Assert.assertEquals(azureClientId, actualRequest.getAzureClientId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createAzureClientExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAzureClusters.addException(exception);

    try {
      String parent = "parent-995424086";
      AzureClient azureClient = AzureClient.newBuilder().build();
      String azureClientId = "azureClientId-1735934475";
      client.createAzureClientAsync(parent, azureClient, azureClientId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void getAzureClientTest() throws Exception {
    AzureClient expectedResponse =
        AzureClient.newBuilder()
            .setName(AzureClientName.of("[PROJECT]", "[LOCATION]", "[AZURE_CLIENT]").toString())
            .setTenantId("tenantId-1306693787")
            .setApplicationId("applicationId-1011352949")
            .putAllAnnotations(new HashMap<String, String>())
            .setPemCertificate("pemCertificate153491807")
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    mockAzureClusters.addResponse(expectedResponse);

    AzureClientName name = AzureClientName.of("[PROJECT]", "[LOCATION]", "[AZURE_CLIENT]");

    AzureClient actualResponse = client.getAzureClient(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAzureClusters.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAzureClientRequest actualRequest = ((GetAzureClientRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAzureClientExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAzureClusters.addException(exception);

    try {
      AzureClientName name = AzureClientName.of("[PROJECT]", "[LOCATION]", "[AZURE_CLIENT]");
      client.getAzureClient(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAzureClientTest2() throws Exception {
    AzureClient expectedResponse =
        AzureClient.newBuilder()
            .setName(AzureClientName.of("[PROJECT]", "[LOCATION]", "[AZURE_CLIENT]").toString())
            .setTenantId("tenantId-1306693787")
            .setApplicationId("applicationId-1011352949")
            .putAllAnnotations(new HashMap<String, String>())
            .setPemCertificate("pemCertificate153491807")
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    mockAzureClusters.addResponse(expectedResponse);

    String name = "name3373707";

    AzureClient actualResponse = client.getAzureClient(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAzureClusters.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAzureClientRequest actualRequest = ((GetAzureClientRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAzureClientExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAzureClusters.addException(exception);

    try {
      String name = "name3373707";
      client.getAzureClient(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAzureClientsTest() throws Exception {
    AzureClient responsesElement = AzureClient.newBuilder().build();
    ListAzureClientsResponse expectedResponse =
        ListAzureClientsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAzureClients(Arrays.asList(responsesElement))
            .build();
    mockAzureClusters.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListAzureClientsPagedResponse pagedListResponse = client.listAzureClients(parent);

    List<AzureClient> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAzureClientsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAzureClusters.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAzureClientsRequest actualRequest = ((ListAzureClientsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAzureClientsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAzureClusters.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listAzureClients(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAzureClientsTest2() throws Exception {
    AzureClient responsesElement = AzureClient.newBuilder().build();
    ListAzureClientsResponse expectedResponse =
        ListAzureClientsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAzureClients(Arrays.asList(responsesElement))
            .build();
    mockAzureClusters.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListAzureClientsPagedResponse pagedListResponse = client.listAzureClients(parent);

    List<AzureClient> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAzureClientsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAzureClusters.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAzureClientsRequest actualRequest = ((ListAzureClientsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAzureClientsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAzureClusters.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listAzureClients(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteAzureClientTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteAzureClientTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAzureClusters.addResponse(resultOperation);

    AzureClientName name = AzureClientName.of("[PROJECT]", "[LOCATION]", "[AZURE_CLIENT]");

    client.deleteAzureClientAsync(name).get();

    List<AbstractMessage> actualRequests = mockAzureClusters.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteAzureClientRequest actualRequest = ((DeleteAzureClientRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteAzureClientExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAzureClusters.addException(exception);

    try {
      AzureClientName name = AzureClientName.of("[PROJECT]", "[LOCATION]", "[AZURE_CLIENT]");
      client.deleteAzureClientAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteAzureClientTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteAzureClientTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAzureClusters.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteAzureClientAsync(name).get();

    List<AbstractMessage> actualRequests = mockAzureClusters.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteAzureClientRequest actualRequest = ((DeleteAzureClientRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteAzureClientExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAzureClusters.addException(exception);

    try {
      String name = "name3373707";
      client.deleteAzureClientAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createAzureClusterTest() throws Exception {
    AzureCluster expectedResponse =
        AzureCluster.newBuilder()
            .setName(AzureClusterName.of("[PROJECT]", "[LOCATION]", "[AZURE_CLUSTER]").toString())
            .setDescription("description-1724546052")
            .setAzureRegion("azureRegion1270271587")
            .setResourceGroupId("resourceGroupId928392204")
            .setAzureClient("azureClient847354682")
            .setNetworking(AzureClusterNetworking.newBuilder().build())
            .setControlPlane(AzureControlPlane.newBuilder().build())
            .setAuthorization(AzureAuthorization.newBuilder().build())
            .setEndpoint("endpoint1741102485")
            .setUid("uid115792")
            .setReconciling(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .putAllAnnotations(new HashMap<String, String>())
            .setWorkloadIdentityConfig(WorkloadIdentityConfig.newBuilder().build())
            .setClusterCaCertificate("clusterCaCertificate-683492737")
            .setFleet(Fleet.newBuilder().build())
            .setManagedResources(AzureClusterResources.newBuilder().build())
            .setLoggingConfig(LoggingConfig.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createAzureClusterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAzureClusters.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    AzureCluster azureCluster = AzureCluster.newBuilder().build();
    String azureClusterId = "azureClusterId191689446";

    AzureCluster actualResponse =
        client.createAzureClusterAsync(parent, azureCluster, azureClusterId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAzureClusters.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateAzureClusterRequest actualRequest = ((CreateAzureClusterRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(azureCluster, actualRequest.getAzureCluster());
    Assert.assertEquals(azureClusterId, actualRequest.getAzureClusterId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createAzureClusterExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAzureClusters.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      AzureCluster azureCluster = AzureCluster.newBuilder().build();
      String azureClusterId = "azureClusterId191689446";
      client.createAzureClusterAsync(parent, azureCluster, azureClusterId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createAzureClusterTest2() throws Exception {
    AzureCluster expectedResponse =
        AzureCluster.newBuilder()
            .setName(AzureClusterName.of("[PROJECT]", "[LOCATION]", "[AZURE_CLUSTER]").toString())
            .setDescription("description-1724546052")
            .setAzureRegion("azureRegion1270271587")
            .setResourceGroupId("resourceGroupId928392204")
            .setAzureClient("azureClient847354682")
            .setNetworking(AzureClusterNetworking.newBuilder().build())
            .setControlPlane(AzureControlPlane.newBuilder().build())
            .setAuthorization(AzureAuthorization.newBuilder().build())
            .setEndpoint("endpoint1741102485")
            .setUid("uid115792")
            .setReconciling(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .putAllAnnotations(new HashMap<String, String>())
            .setWorkloadIdentityConfig(WorkloadIdentityConfig.newBuilder().build())
            .setClusterCaCertificate("clusterCaCertificate-683492737")
            .setFleet(Fleet.newBuilder().build())
            .setManagedResources(AzureClusterResources.newBuilder().build())
            .setLoggingConfig(LoggingConfig.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createAzureClusterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAzureClusters.addResponse(resultOperation);

    String parent = "parent-995424086";
    AzureCluster azureCluster = AzureCluster.newBuilder().build();
    String azureClusterId = "azureClusterId191689446";

    AzureCluster actualResponse =
        client.createAzureClusterAsync(parent, azureCluster, azureClusterId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAzureClusters.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateAzureClusterRequest actualRequest = ((CreateAzureClusterRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(azureCluster, actualRequest.getAzureCluster());
    Assert.assertEquals(azureClusterId, actualRequest.getAzureClusterId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createAzureClusterExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAzureClusters.addException(exception);

    try {
      String parent = "parent-995424086";
      AzureCluster azureCluster = AzureCluster.newBuilder().build();
      String azureClusterId = "azureClusterId191689446";
      client.createAzureClusterAsync(parent, azureCluster, azureClusterId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateAzureClusterTest() throws Exception {
    AzureCluster expectedResponse =
        AzureCluster.newBuilder()
            .setName(AzureClusterName.of("[PROJECT]", "[LOCATION]", "[AZURE_CLUSTER]").toString())
            .setDescription("description-1724546052")
            .setAzureRegion("azureRegion1270271587")
            .setResourceGroupId("resourceGroupId928392204")
            .setAzureClient("azureClient847354682")
            .setNetworking(AzureClusterNetworking.newBuilder().build())
            .setControlPlane(AzureControlPlane.newBuilder().build())
            .setAuthorization(AzureAuthorization.newBuilder().build())
            .setEndpoint("endpoint1741102485")
            .setUid("uid115792")
            .setReconciling(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .putAllAnnotations(new HashMap<String, String>())
            .setWorkloadIdentityConfig(WorkloadIdentityConfig.newBuilder().build())
            .setClusterCaCertificate("clusterCaCertificate-683492737")
            .setFleet(Fleet.newBuilder().build())
            .setManagedResources(AzureClusterResources.newBuilder().build())
            .setLoggingConfig(LoggingConfig.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateAzureClusterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAzureClusters.addResponse(resultOperation);

    AzureCluster azureCluster = AzureCluster.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    AzureCluster actualResponse = client.updateAzureClusterAsync(azureCluster, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAzureClusters.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateAzureClusterRequest actualRequest = ((UpdateAzureClusterRequest) actualRequests.get(0));

    Assert.assertEquals(azureCluster, actualRequest.getAzureCluster());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateAzureClusterExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAzureClusters.addException(exception);

    try {
      AzureCluster azureCluster = AzureCluster.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateAzureClusterAsync(azureCluster, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void getAzureClusterTest() throws Exception {
    AzureCluster expectedResponse =
        AzureCluster.newBuilder()
            .setName(AzureClusterName.of("[PROJECT]", "[LOCATION]", "[AZURE_CLUSTER]").toString())
            .setDescription("description-1724546052")
            .setAzureRegion("azureRegion1270271587")
            .setResourceGroupId("resourceGroupId928392204")
            .setAzureClient("azureClient847354682")
            .setNetworking(AzureClusterNetworking.newBuilder().build())
            .setControlPlane(AzureControlPlane.newBuilder().build())
            .setAuthorization(AzureAuthorization.newBuilder().build())
            .setEndpoint("endpoint1741102485")
            .setUid("uid115792")
            .setReconciling(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .putAllAnnotations(new HashMap<String, String>())
            .setWorkloadIdentityConfig(WorkloadIdentityConfig.newBuilder().build())
            .setClusterCaCertificate("clusterCaCertificate-683492737")
            .setFleet(Fleet.newBuilder().build())
            .setManagedResources(AzureClusterResources.newBuilder().build())
            .setLoggingConfig(LoggingConfig.newBuilder().build())
            .build();
    mockAzureClusters.addResponse(expectedResponse);

    AzureClusterName name = AzureClusterName.of("[PROJECT]", "[LOCATION]", "[AZURE_CLUSTER]");

    AzureCluster actualResponse = client.getAzureCluster(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAzureClusters.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAzureClusterRequest actualRequest = ((GetAzureClusterRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAzureClusterExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAzureClusters.addException(exception);

    try {
      AzureClusterName name = AzureClusterName.of("[PROJECT]", "[LOCATION]", "[AZURE_CLUSTER]");
      client.getAzureCluster(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAzureClusterTest2() throws Exception {
    AzureCluster expectedResponse =
        AzureCluster.newBuilder()
            .setName(AzureClusterName.of("[PROJECT]", "[LOCATION]", "[AZURE_CLUSTER]").toString())
            .setDescription("description-1724546052")
            .setAzureRegion("azureRegion1270271587")
            .setResourceGroupId("resourceGroupId928392204")
            .setAzureClient("azureClient847354682")
            .setNetworking(AzureClusterNetworking.newBuilder().build())
            .setControlPlane(AzureControlPlane.newBuilder().build())
            .setAuthorization(AzureAuthorization.newBuilder().build())
            .setEndpoint("endpoint1741102485")
            .setUid("uid115792")
            .setReconciling(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .putAllAnnotations(new HashMap<String, String>())
            .setWorkloadIdentityConfig(WorkloadIdentityConfig.newBuilder().build())
            .setClusterCaCertificate("clusterCaCertificate-683492737")
            .setFleet(Fleet.newBuilder().build())
            .setManagedResources(AzureClusterResources.newBuilder().build())
            .setLoggingConfig(LoggingConfig.newBuilder().build())
            .build();
    mockAzureClusters.addResponse(expectedResponse);

    String name = "name3373707";

    AzureCluster actualResponse = client.getAzureCluster(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAzureClusters.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAzureClusterRequest actualRequest = ((GetAzureClusterRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAzureClusterExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAzureClusters.addException(exception);

    try {
      String name = "name3373707";
      client.getAzureCluster(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAzureClustersTest() throws Exception {
    AzureCluster responsesElement = AzureCluster.newBuilder().build();
    ListAzureClustersResponse expectedResponse =
        ListAzureClustersResponse.newBuilder()
            .setNextPageToken("")
            .addAllAzureClusters(Arrays.asList(responsesElement))
            .build();
    mockAzureClusters.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListAzureClustersPagedResponse pagedListResponse = client.listAzureClusters(parent);

    List<AzureCluster> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAzureClustersList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAzureClusters.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAzureClustersRequest actualRequest = ((ListAzureClustersRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAzureClustersExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAzureClusters.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listAzureClusters(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAzureClustersTest2() throws Exception {
    AzureCluster responsesElement = AzureCluster.newBuilder().build();
    ListAzureClustersResponse expectedResponse =
        ListAzureClustersResponse.newBuilder()
            .setNextPageToken("")
            .addAllAzureClusters(Arrays.asList(responsesElement))
            .build();
    mockAzureClusters.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListAzureClustersPagedResponse pagedListResponse = client.listAzureClusters(parent);

    List<AzureCluster> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAzureClustersList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAzureClusters.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAzureClustersRequest actualRequest = ((ListAzureClustersRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAzureClustersExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAzureClusters.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listAzureClusters(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteAzureClusterTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteAzureClusterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAzureClusters.addResponse(resultOperation);

    AzureClusterName name = AzureClusterName.of("[PROJECT]", "[LOCATION]", "[AZURE_CLUSTER]");

    client.deleteAzureClusterAsync(name).get();

    List<AbstractMessage> actualRequests = mockAzureClusters.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteAzureClusterRequest actualRequest = ((DeleteAzureClusterRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteAzureClusterExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAzureClusters.addException(exception);

    try {
      AzureClusterName name = AzureClusterName.of("[PROJECT]", "[LOCATION]", "[AZURE_CLUSTER]");
      client.deleteAzureClusterAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteAzureClusterTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteAzureClusterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAzureClusters.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteAzureClusterAsync(name).get();

    List<AbstractMessage> actualRequests = mockAzureClusters.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteAzureClusterRequest actualRequest = ((DeleteAzureClusterRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteAzureClusterExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAzureClusters.addException(exception);

    try {
      String name = "name3373707";
      client.deleteAzureClusterAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void generateAzureAccessTokenTest() throws Exception {
    GenerateAzureAccessTokenResponse expectedResponse =
        GenerateAzureAccessTokenResponse.newBuilder()
            .setAccessToken("accessToken-1042689291")
            .setExpirationTime(Timestamp.newBuilder().build())
            .build();
    mockAzureClusters.addResponse(expectedResponse);

    GenerateAzureAccessTokenRequest request =
        GenerateAzureAccessTokenRequest.newBuilder()
            .setAzureCluster(
                AzureClusterName.of("[PROJECT]", "[LOCATION]", "[AZURE_CLUSTER]").toString())
            .build();

    GenerateAzureAccessTokenResponse actualResponse = client.generateAzureAccessToken(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAzureClusters.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GenerateAzureAccessTokenRequest actualRequest =
        ((GenerateAzureAccessTokenRequest) actualRequests.get(0));

    Assert.assertEquals(request.getAzureCluster(), actualRequest.getAzureCluster());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void generateAzureAccessTokenExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAzureClusters.addException(exception);

    try {
      GenerateAzureAccessTokenRequest request =
          GenerateAzureAccessTokenRequest.newBuilder()
              .setAzureCluster(
                  AzureClusterName.of("[PROJECT]", "[LOCATION]", "[AZURE_CLUSTER]").toString())
              .build();
      client.generateAzureAccessToken(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createAzureNodePoolTest() throws Exception {
    AzureNodePool expectedResponse =
        AzureNodePool.newBuilder()
            .setName(
                AzureNodePoolName.of(
                        "[PROJECT]", "[LOCATION]", "[AZURE_CLUSTER]", "[AZURE_NODE_POOL]")
                    .toString())
            .setVersion("version351608024")
            .setConfig(AzureNodeConfig.newBuilder().build())
            .setSubnetId("subnetId-2066159272")
            .setAutoscaling(AzureNodePoolAutoscaling.newBuilder().build())
            .setUid("uid115792")
            .setReconciling(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .putAllAnnotations(new HashMap<String, String>())
            .setMaxPodsConstraint(MaxPodsConstraint.newBuilder().build())
            .setAzureAvailabilityZone("azureAvailabilityZone-304222122")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createAzureNodePoolTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAzureClusters.addResponse(resultOperation);

    AzureClusterName parent = AzureClusterName.of("[PROJECT]", "[LOCATION]", "[AZURE_CLUSTER]");
    AzureNodePool azureNodePool = AzureNodePool.newBuilder().build();
    String azureNodePoolId = "azureNodePoolId-1766264088";

    AzureNodePool actualResponse =
        client.createAzureNodePoolAsync(parent, azureNodePool, azureNodePoolId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAzureClusters.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateAzureNodePoolRequest actualRequest = ((CreateAzureNodePoolRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(azureNodePool, actualRequest.getAzureNodePool());
    Assert.assertEquals(azureNodePoolId, actualRequest.getAzureNodePoolId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createAzureNodePoolExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAzureClusters.addException(exception);

    try {
      AzureClusterName parent = AzureClusterName.of("[PROJECT]", "[LOCATION]", "[AZURE_CLUSTER]");
      AzureNodePool azureNodePool = AzureNodePool.newBuilder().build();
      String azureNodePoolId = "azureNodePoolId-1766264088";
      client.createAzureNodePoolAsync(parent, azureNodePool, azureNodePoolId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createAzureNodePoolTest2() throws Exception {
    AzureNodePool expectedResponse =
        AzureNodePool.newBuilder()
            .setName(
                AzureNodePoolName.of(
                        "[PROJECT]", "[LOCATION]", "[AZURE_CLUSTER]", "[AZURE_NODE_POOL]")
                    .toString())
            .setVersion("version351608024")
            .setConfig(AzureNodeConfig.newBuilder().build())
            .setSubnetId("subnetId-2066159272")
            .setAutoscaling(AzureNodePoolAutoscaling.newBuilder().build())
            .setUid("uid115792")
            .setReconciling(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .putAllAnnotations(new HashMap<String, String>())
            .setMaxPodsConstraint(MaxPodsConstraint.newBuilder().build())
            .setAzureAvailabilityZone("azureAvailabilityZone-304222122")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createAzureNodePoolTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAzureClusters.addResponse(resultOperation);

    String parent = "parent-995424086";
    AzureNodePool azureNodePool = AzureNodePool.newBuilder().build();
    String azureNodePoolId = "azureNodePoolId-1766264088";

    AzureNodePool actualResponse =
        client.createAzureNodePoolAsync(parent, azureNodePool, azureNodePoolId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAzureClusters.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateAzureNodePoolRequest actualRequest = ((CreateAzureNodePoolRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(azureNodePool, actualRequest.getAzureNodePool());
    Assert.assertEquals(azureNodePoolId, actualRequest.getAzureNodePoolId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createAzureNodePoolExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAzureClusters.addException(exception);

    try {
      String parent = "parent-995424086";
      AzureNodePool azureNodePool = AzureNodePool.newBuilder().build();
      String azureNodePoolId = "azureNodePoolId-1766264088";
      client.createAzureNodePoolAsync(parent, azureNodePool, azureNodePoolId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateAzureNodePoolTest() throws Exception {
    AzureNodePool expectedResponse =
        AzureNodePool.newBuilder()
            .setName(
                AzureNodePoolName.of(
                        "[PROJECT]", "[LOCATION]", "[AZURE_CLUSTER]", "[AZURE_NODE_POOL]")
                    .toString())
            .setVersion("version351608024")
            .setConfig(AzureNodeConfig.newBuilder().build())
            .setSubnetId("subnetId-2066159272")
            .setAutoscaling(AzureNodePoolAutoscaling.newBuilder().build())
            .setUid("uid115792")
            .setReconciling(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .putAllAnnotations(new HashMap<String, String>())
            .setMaxPodsConstraint(MaxPodsConstraint.newBuilder().build())
            .setAzureAvailabilityZone("azureAvailabilityZone-304222122")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateAzureNodePoolTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAzureClusters.addResponse(resultOperation);

    AzureNodePool azureNodePool = AzureNodePool.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    AzureNodePool actualResponse = client.updateAzureNodePoolAsync(azureNodePool, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAzureClusters.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateAzureNodePoolRequest actualRequest = ((UpdateAzureNodePoolRequest) actualRequests.get(0));

    Assert.assertEquals(azureNodePool, actualRequest.getAzureNodePool());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateAzureNodePoolExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAzureClusters.addException(exception);

    try {
      AzureNodePool azureNodePool = AzureNodePool.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateAzureNodePoolAsync(azureNodePool, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void getAzureNodePoolTest() throws Exception {
    AzureNodePool expectedResponse =
        AzureNodePool.newBuilder()
            .setName(
                AzureNodePoolName.of(
                        "[PROJECT]", "[LOCATION]", "[AZURE_CLUSTER]", "[AZURE_NODE_POOL]")
                    .toString())
            .setVersion("version351608024")
            .setConfig(AzureNodeConfig.newBuilder().build())
            .setSubnetId("subnetId-2066159272")
            .setAutoscaling(AzureNodePoolAutoscaling.newBuilder().build())
            .setUid("uid115792")
            .setReconciling(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .putAllAnnotations(new HashMap<String, String>())
            .setMaxPodsConstraint(MaxPodsConstraint.newBuilder().build())
            .setAzureAvailabilityZone("azureAvailabilityZone-304222122")
            .build();
    mockAzureClusters.addResponse(expectedResponse);

    AzureNodePoolName name =
        AzureNodePoolName.of("[PROJECT]", "[LOCATION]", "[AZURE_CLUSTER]", "[AZURE_NODE_POOL]");

    AzureNodePool actualResponse = client.getAzureNodePool(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAzureClusters.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAzureNodePoolRequest actualRequest = ((GetAzureNodePoolRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAzureNodePoolExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAzureClusters.addException(exception);

    try {
      AzureNodePoolName name =
          AzureNodePoolName.of("[PROJECT]", "[LOCATION]", "[AZURE_CLUSTER]", "[AZURE_NODE_POOL]");
      client.getAzureNodePool(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAzureNodePoolTest2() throws Exception {
    AzureNodePool expectedResponse =
        AzureNodePool.newBuilder()
            .setName(
                AzureNodePoolName.of(
                        "[PROJECT]", "[LOCATION]", "[AZURE_CLUSTER]", "[AZURE_NODE_POOL]")
                    .toString())
            .setVersion("version351608024")
            .setConfig(AzureNodeConfig.newBuilder().build())
            .setSubnetId("subnetId-2066159272")
            .setAutoscaling(AzureNodePoolAutoscaling.newBuilder().build())
            .setUid("uid115792")
            .setReconciling(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .putAllAnnotations(new HashMap<String, String>())
            .setMaxPodsConstraint(MaxPodsConstraint.newBuilder().build())
            .setAzureAvailabilityZone("azureAvailabilityZone-304222122")
            .build();
    mockAzureClusters.addResponse(expectedResponse);

    String name = "name3373707";

    AzureNodePool actualResponse = client.getAzureNodePool(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAzureClusters.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAzureNodePoolRequest actualRequest = ((GetAzureNodePoolRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAzureNodePoolExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAzureClusters.addException(exception);

    try {
      String name = "name3373707";
      client.getAzureNodePool(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAzureNodePoolsTest() throws Exception {
    AzureNodePool responsesElement = AzureNodePool.newBuilder().build();
    ListAzureNodePoolsResponse expectedResponse =
        ListAzureNodePoolsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAzureNodePools(Arrays.asList(responsesElement))
            .build();
    mockAzureClusters.addResponse(expectedResponse);

    AzureClusterName parent = AzureClusterName.of("[PROJECT]", "[LOCATION]", "[AZURE_CLUSTER]");

    ListAzureNodePoolsPagedResponse pagedListResponse = client.listAzureNodePools(parent);

    List<AzureNodePool> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAzureNodePoolsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAzureClusters.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAzureNodePoolsRequest actualRequest = ((ListAzureNodePoolsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAzureNodePoolsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAzureClusters.addException(exception);

    try {
      AzureClusterName parent = AzureClusterName.of("[PROJECT]", "[LOCATION]", "[AZURE_CLUSTER]");
      client.listAzureNodePools(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAzureNodePoolsTest2() throws Exception {
    AzureNodePool responsesElement = AzureNodePool.newBuilder().build();
    ListAzureNodePoolsResponse expectedResponse =
        ListAzureNodePoolsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAzureNodePools(Arrays.asList(responsesElement))
            .build();
    mockAzureClusters.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListAzureNodePoolsPagedResponse pagedListResponse = client.listAzureNodePools(parent);

    List<AzureNodePool> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAzureNodePoolsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAzureClusters.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAzureNodePoolsRequest actualRequest = ((ListAzureNodePoolsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAzureNodePoolsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAzureClusters.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listAzureNodePools(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteAzureNodePoolTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteAzureNodePoolTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAzureClusters.addResponse(resultOperation);

    AzureNodePoolName name =
        AzureNodePoolName.of("[PROJECT]", "[LOCATION]", "[AZURE_CLUSTER]", "[AZURE_NODE_POOL]");

    client.deleteAzureNodePoolAsync(name).get();

    List<AbstractMessage> actualRequests = mockAzureClusters.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteAzureNodePoolRequest actualRequest = ((DeleteAzureNodePoolRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteAzureNodePoolExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAzureClusters.addException(exception);

    try {
      AzureNodePoolName name =
          AzureNodePoolName.of("[PROJECT]", "[LOCATION]", "[AZURE_CLUSTER]", "[AZURE_NODE_POOL]");
      client.deleteAzureNodePoolAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteAzureNodePoolTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteAzureNodePoolTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAzureClusters.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteAzureNodePoolAsync(name).get();

    List<AbstractMessage> actualRequests = mockAzureClusters.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteAzureNodePoolRequest actualRequest = ((DeleteAzureNodePoolRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteAzureNodePoolExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAzureClusters.addException(exception);

    try {
      String name = "name3373707";
      client.deleteAzureNodePoolAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void getAzureServerConfigTest() throws Exception {
    AzureServerConfig expectedResponse =
        AzureServerConfig.newBuilder()
            .setName(AzureServerConfigName.of("[PROJECT]", "[LOCATION]").toString())
            .addAllValidVersions(new ArrayList<AzureK8sVersionInfo>())
            .addAllSupportedAzureRegions(new ArrayList<String>())
            .build();
    mockAzureClusters.addResponse(expectedResponse);

    AzureServerConfigName name = AzureServerConfigName.of("[PROJECT]", "[LOCATION]");

    AzureServerConfig actualResponse = client.getAzureServerConfig(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAzureClusters.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAzureServerConfigRequest actualRequest =
        ((GetAzureServerConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAzureServerConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAzureClusters.addException(exception);

    try {
      AzureServerConfigName name = AzureServerConfigName.of("[PROJECT]", "[LOCATION]");
      client.getAzureServerConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAzureServerConfigTest2() throws Exception {
    AzureServerConfig expectedResponse =
        AzureServerConfig.newBuilder()
            .setName(AzureServerConfigName.of("[PROJECT]", "[LOCATION]").toString())
            .addAllValidVersions(new ArrayList<AzureK8sVersionInfo>())
            .addAllSupportedAzureRegions(new ArrayList<String>())
            .build();
    mockAzureClusters.addResponse(expectedResponse);

    String name = "name3373707";

    AzureServerConfig actualResponse = client.getAzureServerConfig(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAzureClusters.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAzureServerConfigRequest actualRequest =
        ((GetAzureServerConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAzureServerConfigExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAzureClusters.addException(exception);

    try {
      String name = "name3373707";
      client.getAzureServerConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
