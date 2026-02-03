/*
 * Copyright 2026 Google LLC
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
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListDatabaseCharacterSetsPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListDatabasesPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListDbNodesPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListDbServersPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListDbSystemInitialStorageSizesPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListDbSystemShapesPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListDbSystemsPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListDbVersionsPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListEntitlementsPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListExadbVmClustersPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListExascaleDbStorageVaultsPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListGiVersionsPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListLocationsPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListMinorVersionsPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListOdbNetworksPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListOdbSubnetsPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListPluggableDatabasesPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.protobuf.ByteString;
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
public class OracleDatabaseClientTest {
  private static MockLocations mockLocations;
  private static MockOracleDatabase mockOracleDatabase;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private OracleDatabaseClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockOracleDatabase = new MockOracleDatabase();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockOracleDatabase, mockLocations));
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
    OracleDatabaseSettings settings =
        OracleDatabaseSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = OracleDatabaseClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listCloudExadataInfrastructuresTest() throws Exception {
    CloudExadataInfrastructure responsesElement = CloudExadataInfrastructure.newBuilder().build();
    ListCloudExadataInfrastructuresResponse expectedResponse =
        ListCloudExadataInfrastructuresResponse.newBuilder()
            .setNextPageToken("")
            .addAllCloudExadataInfrastructures(Arrays.asList(responsesElement))
            .build();
    mockOracleDatabase.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListCloudExadataInfrastructuresPagedResponse pagedListResponse =
        client.listCloudExadataInfrastructures(parent);

    List<CloudExadataInfrastructure> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getCloudExadataInfrastructuresList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListCloudExadataInfrastructuresRequest actualRequest =
        ((ListCloudExadataInfrastructuresRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listCloudExadataInfrastructuresExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listCloudExadataInfrastructures(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listCloudExadataInfrastructuresTest2() throws Exception {
    CloudExadataInfrastructure responsesElement = CloudExadataInfrastructure.newBuilder().build();
    ListCloudExadataInfrastructuresResponse expectedResponse =
        ListCloudExadataInfrastructuresResponse.newBuilder()
            .setNextPageToken("")
            .addAllCloudExadataInfrastructures(Arrays.asList(responsesElement))
            .build();
    mockOracleDatabase.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListCloudExadataInfrastructuresPagedResponse pagedListResponse =
        client.listCloudExadataInfrastructures(parent);

    List<CloudExadataInfrastructure> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getCloudExadataInfrastructuresList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListCloudExadataInfrastructuresRequest actualRequest =
        ((ListCloudExadataInfrastructuresRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listCloudExadataInfrastructuresExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listCloudExadataInfrastructures(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getCloudExadataInfrastructureTest() throws Exception {
    CloudExadataInfrastructure expectedResponse =
        CloudExadataInfrastructure.newBuilder()
            .setName(
                CloudExadataInfrastructureName.of(
                        "[PROJECT]", "[LOCATION]", "[CLOUD_EXADATA_INFRASTRUCTURE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setGcpOracleZone("gcpOracleZone217860222")
            .setEntitlementId("entitlementId-1302274264")
            .setProperties(CloudExadataInfrastructureProperties.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    mockOracleDatabase.addResponse(expectedResponse);

    CloudExadataInfrastructureName name =
        CloudExadataInfrastructureName.of(
            "[PROJECT]", "[LOCATION]", "[CLOUD_EXADATA_INFRASTRUCTURE]");

    CloudExadataInfrastructure actualResponse = client.getCloudExadataInfrastructure(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetCloudExadataInfrastructureRequest actualRequest =
        ((GetCloudExadataInfrastructureRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getCloudExadataInfrastructureExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      CloudExadataInfrastructureName name =
          CloudExadataInfrastructureName.of(
              "[PROJECT]", "[LOCATION]", "[CLOUD_EXADATA_INFRASTRUCTURE]");
      client.getCloudExadataInfrastructure(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getCloudExadataInfrastructureTest2() throws Exception {
    CloudExadataInfrastructure expectedResponse =
        CloudExadataInfrastructure.newBuilder()
            .setName(
                CloudExadataInfrastructureName.of(
                        "[PROJECT]", "[LOCATION]", "[CLOUD_EXADATA_INFRASTRUCTURE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setGcpOracleZone("gcpOracleZone217860222")
            .setEntitlementId("entitlementId-1302274264")
            .setProperties(CloudExadataInfrastructureProperties.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    mockOracleDatabase.addResponse(expectedResponse);

    String name = "name3373707";

    CloudExadataInfrastructure actualResponse = client.getCloudExadataInfrastructure(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetCloudExadataInfrastructureRequest actualRequest =
        ((GetCloudExadataInfrastructureRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getCloudExadataInfrastructureExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      String name = "name3373707";
      client.getCloudExadataInfrastructure(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createCloudExadataInfrastructureTest() throws Exception {
    CloudExadataInfrastructure expectedResponse =
        CloudExadataInfrastructure.newBuilder()
            .setName(
                CloudExadataInfrastructureName.of(
                        "[PROJECT]", "[LOCATION]", "[CLOUD_EXADATA_INFRASTRUCTURE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setGcpOracleZone("gcpOracleZone217860222")
            .setEntitlementId("entitlementId-1302274264")
            .setProperties(CloudExadataInfrastructureProperties.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createCloudExadataInfrastructureTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockOracleDatabase.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    CloudExadataInfrastructure cloudExadataInfrastructure =
        CloudExadataInfrastructure.newBuilder().build();
    String cloudExadataInfrastructureId = "cloudExadataInfrastructureId975345409";

    CloudExadataInfrastructure actualResponse =
        client
            .createCloudExadataInfrastructureAsync(
                parent, cloudExadataInfrastructure, cloudExadataInfrastructureId)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateCloudExadataInfrastructureRequest actualRequest =
        ((CreateCloudExadataInfrastructureRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(cloudExadataInfrastructure, actualRequest.getCloudExadataInfrastructure());
    Assert.assertEquals(
        cloudExadataInfrastructureId, actualRequest.getCloudExadataInfrastructureId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createCloudExadataInfrastructureExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      CloudExadataInfrastructure cloudExadataInfrastructure =
          CloudExadataInfrastructure.newBuilder().build();
      String cloudExadataInfrastructureId = "cloudExadataInfrastructureId975345409";
      client
          .createCloudExadataInfrastructureAsync(
              parent, cloudExadataInfrastructure, cloudExadataInfrastructureId)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createCloudExadataInfrastructureTest2() throws Exception {
    CloudExadataInfrastructure expectedResponse =
        CloudExadataInfrastructure.newBuilder()
            .setName(
                CloudExadataInfrastructureName.of(
                        "[PROJECT]", "[LOCATION]", "[CLOUD_EXADATA_INFRASTRUCTURE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setGcpOracleZone("gcpOracleZone217860222")
            .setEntitlementId("entitlementId-1302274264")
            .setProperties(CloudExadataInfrastructureProperties.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createCloudExadataInfrastructureTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockOracleDatabase.addResponse(resultOperation);

    String parent = "parent-995424086";
    CloudExadataInfrastructure cloudExadataInfrastructure =
        CloudExadataInfrastructure.newBuilder().build();
    String cloudExadataInfrastructureId = "cloudExadataInfrastructureId975345409";

    CloudExadataInfrastructure actualResponse =
        client
            .createCloudExadataInfrastructureAsync(
                parent, cloudExadataInfrastructure, cloudExadataInfrastructureId)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateCloudExadataInfrastructureRequest actualRequest =
        ((CreateCloudExadataInfrastructureRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(cloudExadataInfrastructure, actualRequest.getCloudExadataInfrastructure());
    Assert.assertEquals(
        cloudExadataInfrastructureId, actualRequest.getCloudExadataInfrastructureId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createCloudExadataInfrastructureExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      String parent = "parent-995424086";
      CloudExadataInfrastructure cloudExadataInfrastructure =
          CloudExadataInfrastructure.newBuilder().build();
      String cloudExadataInfrastructureId = "cloudExadataInfrastructureId975345409";
      client
          .createCloudExadataInfrastructureAsync(
              parent, cloudExadataInfrastructure, cloudExadataInfrastructureId)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteCloudExadataInfrastructureTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteCloudExadataInfrastructureTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockOracleDatabase.addResponse(resultOperation);

    CloudExadataInfrastructureName name =
        CloudExadataInfrastructureName.of(
            "[PROJECT]", "[LOCATION]", "[CLOUD_EXADATA_INFRASTRUCTURE]");

    client.deleteCloudExadataInfrastructureAsync(name).get();

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteCloudExadataInfrastructureRequest actualRequest =
        ((DeleteCloudExadataInfrastructureRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteCloudExadataInfrastructureExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      CloudExadataInfrastructureName name =
          CloudExadataInfrastructureName.of(
              "[PROJECT]", "[LOCATION]", "[CLOUD_EXADATA_INFRASTRUCTURE]");
      client.deleteCloudExadataInfrastructureAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteCloudExadataInfrastructureTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteCloudExadataInfrastructureTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockOracleDatabase.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteCloudExadataInfrastructureAsync(name).get();

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteCloudExadataInfrastructureRequest actualRequest =
        ((DeleteCloudExadataInfrastructureRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteCloudExadataInfrastructureExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      String name = "name3373707";
      client.deleteCloudExadataInfrastructureAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listCloudVmClustersTest() throws Exception {
    CloudVmCluster responsesElement = CloudVmCluster.newBuilder().build();
    ListCloudVmClustersResponse expectedResponse =
        ListCloudVmClustersResponse.newBuilder()
            .setNextPageToken("")
            .addAllCloudVmClusters(Arrays.asList(responsesElement))
            .build();
    mockOracleDatabase.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListCloudVmClustersPagedResponse pagedListResponse = client.listCloudVmClusters(parent);

    List<CloudVmCluster> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCloudVmClustersList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListCloudVmClustersRequest actualRequest = ((ListCloudVmClustersRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listCloudVmClustersExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listCloudVmClusters(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listCloudVmClustersTest2() throws Exception {
    CloudVmCluster responsesElement = CloudVmCluster.newBuilder().build();
    ListCloudVmClustersResponse expectedResponse =
        ListCloudVmClustersResponse.newBuilder()
            .setNextPageToken("")
            .addAllCloudVmClusters(Arrays.asList(responsesElement))
            .build();
    mockOracleDatabase.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListCloudVmClustersPagedResponse pagedListResponse = client.listCloudVmClusters(parent);

    List<CloudVmCluster> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCloudVmClustersList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListCloudVmClustersRequest actualRequest = ((ListCloudVmClustersRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listCloudVmClustersExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listCloudVmClusters(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getCloudVmClusterTest() throws Exception {
    CloudVmCluster expectedResponse =
        CloudVmCluster.newBuilder()
            .setName(
                CloudVmClusterName.of("[PROJECT]", "[LOCATION]", "[CLOUD_VM_CLUSTER]").toString())
            .setExadataInfrastructure(
                CloudExadataInfrastructureName.of(
                        "[PROJECT]", "[LOCATION]", "[CLOUD_EXADATA_INFRASTRUCTURE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setProperties(CloudVmClusterProperties.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setCidr("cidr3053428")
            .setBackupSubnetCidr("backupSubnetCidr1087692755")
            .setNetwork("network1843485230")
            .setGcpOracleZone("gcpOracleZone217860222")
            .setOdbNetwork(OdbNetworkName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]").toString())
            .setOdbSubnet(
                OdbSubnetName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]", "[ODB_SUBNET]")
                    .toString())
            .setBackupOdbSubnet(
                OdbSubnetName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]", "[ODB_SUBNET]")
                    .toString())
            .setIdentityConnector(IdentityConnector.newBuilder().build())
            .build();
    mockOracleDatabase.addResponse(expectedResponse);

    CloudVmClusterName name =
        CloudVmClusterName.of("[PROJECT]", "[LOCATION]", "[CLOUD_VM_CLUSTER]");

    CloudVmCluster actualResponse = client.getCloudVmCluster(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetCloudVmClusterRequest actualRequest = ((GetCloudVmClusterRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getCloudVmClusterExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      CloudVmClusterName name =
          CloudVmClusterName.of("[PROJECT]", "[LOCATION]", "[CLOUD_VM_CLUSTER]");
      client.getCloudVmCluster(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getCloudVmClusterTest2() throws Exception {
    CloudVmCluster expectedResponse =
        CloudVmCluster.newBuilder()
            .setName(
                CloudVmClusterName.of("[PROJECT]", "[LOCATION]", "[CLOUD_VM_CLUSTER]").toString())
            .setExadataInfrastructure(
                CloudExadataInfrastructureName.of(
                        "[PROJECT]", "[LOCATION]", "[CLOUD_EXADATA_INFRASTRUCTURE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setProperties(CloudVmClusterProperties.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setCidr("cidr3053428")
            .setBackupSubnetCidr("backupSubnetCidr1087692755")
            .setNetwork("network1843485230")
            .setGcpOracleZone("gcpOracleZone217860222")
            .setOdbNetwork(OdbNetworkName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]").toString())
            .setOdbSubnet(
                OdbSubnetName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]", "[ODB_SUBNET]")
                    .toString())
            .setBackupOdbSubnet(
                OdbSubnetName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]", "[ODB_SUBNET]")
                    .toString())
            .setIdentityConnector(IdentityConnector.newBuilder().build())
            .build();
    mockOracleDatabase.addResponse(expectedResponse);

    String name = "name3373707";

    CloudVmCluster actualResponse = client.getCloudVmCluster(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetCloudVmClusterRequest actualRequest = ((GetCloudVmClusterRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getCloudVmClusterExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      String name = "name3373707";
      client.getCloudVmCluster(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createCloudVmClusterTest() throws Exception {
    CloudVmCluster expectedResponse =
        CloudVmCluster.newBuilder()
            .setName(
                CloudVmClusterName.of("[PROJECT]", "[LOCATION]", "[CLOUD_VM_CLUSTER]").toString())
            .setExadataInfrastructure(
                CloudExadataInfrastructureName.of(
                        "[PROJECT]", "[LOCATION]", "[CLOUD_EXADATA_INFRASTRUCTURE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setProperties(CloudVmClusterProperties.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setCidr("cidr3053428")
            .setBackupSubnetCidr("backupSubnetCidr1087692755")
            .setNetwork("network1843485230")
            .setGcpOracleZone("gcpOracleZone217860222")
            .setOdbNetwork(OdbNetworkName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]").toString())
            .setOdbSubnet(
                OdbSubnetName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]", "[ODB_SUBNET]")
                    .toString())
            .setBackupOdbSubnet(
                OdbSubnetName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]", "[ODB_SUBNET]")
                    .toString())
            .setIdentityConnector(IdentityConnector.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createCloudVmClusterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockOracleDatabase.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    CloudVmCluster cloudVmCluster = CloudVmCluster.newBuilder().build();
    String cloudVmClusterId = "cloudVmClusterId-1217103287";

    CloudVmCluster actualResponse =
        client.createCloudVmClusterAsync(parent, cloudVmCluster, cloudVmClusterId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateCloudVmClusterRequest actualRequest =
        ((CreateCloudVmClusterRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(cloudVmCluster, actualRequest.getCloudVmCluster());
    Assert.assertEquals(cloudVmClusterId, actualRequest.getCloudVmClusterId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createCloudVmClusterExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      CloudVmCluster cloudVmCluster = CloudVmCluster.newBuilder().build();
      String cloudVmClusterId = "cloudVmClusterId-1217103287";
      client.createCloudVmClusterAsync(parent, cloudVmCluster, cloudVmClusterId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createCloudVmClusterTest2() throws Exception {
    CloudVmCluster expectedResponse =
        CloudVmCluster.newBuilder()
            .setName(
                CloudVmClusterName.of("[PROJECT]", "[LOCATION]", "[CLOUD_VM_CLUSTER]").toString())
            .setExadataInfrastructure(
                CloudExadataInfrastructureName.of(
                        "[PROJECT]", "[LOCATION]", "[CLOUD_EXADATA_INFRASTRUCTURE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setProperties(CloudVmClusterProperties.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setCidr("cidr3053428")
            .setBackupSubnetCidr("backupSubnetCidr1087692755")
            .setNetwork("network1843485230")
            .setGcpOracleZone("gcpOracleZone217860222")
            .setOdbNetwork(OdbNetworkName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]").toString())
            .setOdbSubnet(
                OdbSubnetName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]", "[ODB_SUBNET]")
                    .toString())
            .setBackupOdbSubnet(
                OdbSubnetName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]", "[ODB_SUBNET]")
                    .toString())
            .setIdentityConnector(IdentityConnector.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createCloudVmClusterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockOracleDatabase.addResponse(resultOperation);

    String parent = "parent-995424086";
    CloudVmCluster cloudVmCluster = CloudVmCluster.newBuilder().build();
    String cloudVmClusterId = "cloudVmClusterId-1217103287";

    CloudVmCluster actualResponse =
        client.createCloudVmClusterAsync(parent, cloudVmCluster, cloudVmClusterId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateCloudVmClusterRequest actualRequest =
        ((CreateCloudVmClusterRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(cloudVmCluster, actualRequest.getCloudVmCluster());
    Assert.assertEquals(cloudVmClusterId, actualRequest.getCloudVmClusterId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createCloudVmClusterExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      String parent = "parent-995424086";
      CloudVmCluster cloudVmCluster = CloudVmCluster.newBuilder().build();
      String cloudVmClusterId = "cloudVmClusterId-1217103287";
      client.createCloudVmClusterAsync(parent, cloudVmCluster, cloudVmClusterId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteCloudVmClusterTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteCloudVmClusterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockOracleDatabase.addResponse(resultOperation);

    CloudVmClusterName name =
        CloudVmClusterName.of("[PROJECT]", "[LOCATION]", "[CLOUD_VM_CLUSTER]");

    client.deleteCloudVmClusterAsync(name).get();

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteCloudVmClusterRequest actualRequest =
        ((DeleteCloudVmClusterRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteCloudVmClusterExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      CloudVmClusterName name =
          CloudVmClusterName.of("[PROJECT]", "[LOCATION]", "[CLOUD_VM_CLUSTER]");
      client.deleteCloudVmClusterAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteCloudVmClusterTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteCloudVmClusterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockOracleDatabase.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteCloudVmClusterAsync(name).get();

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteCloudVmClusterRequest actualRequest =
        ((DeleteCloudVmClusterRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteCloudVmClusterExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      String name = "name3373707";
      client.deleteCloudVmClusterAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listEntitlementsTest() throws Exception {
    Entitlement responsesElement = Entitlement.newBuilder().build();
    ListEntitlementsResponse expectedResponse =
        ListEntitlementsResponse.newBuilder()
            .setNextPageToken("")
            .addAllEntitlements(Arrays.asList(responsesElement))
            .build();
    mockOracleDatabase.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListEntitlementsPagedResponse pagedListResponse = client.listEntitlements(parent);

    List<Entitlement> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEntitlementsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListEntitlementsRequest actualRequest = ((ListEntitlementsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listEntitlementsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listEntitlements(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listEntitlementsTest2() throws Exception {
    Entitlement responsesElement = Entitlement.newBuilder().build();
    ListEntitlementsResponse expectedResponse =
        ListEntitlementsResponse.newBuilder()
            .setNextPageToken("")
            .addAllEntitlements(Arrays.asList(responsesElement))
            .build();
    mockOracleDatabase.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListEntitlementsPagedResponse pagedListResponse = client.listEntitlements(parent);

    List<Entitlement> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEntitlementsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListEntitlementsRequest actualRequest = ((ListEntitlementsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listEntitlementsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listEntitlements(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDbServersTest() throws Exception {
    DbServer responsesElement = DbServer.newBuilder().build();
    ListDbServersResponse expectedResponse =
        ListDbServersResponse.newBuilder()
            .setNextPageToken("")
            .addAllDbServers(Arrays.asList(responsesElement))
            .build();
    mockOracleDatabase.addResponse(expectedResponse);

    CloudExadataInfrastructureName parent =
        CloudExadataInfrastructureName.of(
            "[PROJECT]", "[LOCATION]", "[CLOUD_EXADATA_INFRASTRUCTURE]");

    ListDbServersPagedResponse pagedListResponse = client.listDbServers(parent);

    List<DbServer> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDbServersList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDbServersRequest actualRequest = ((ListDbServersRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDbServersExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      CloudExadataInfrastructureName parent =
          CloudExadataInfrastructureName.of(
              "[PROJECT]", "[LOCATION]", "[CLOUD_EXADATA_INFRASTRUCTURE]");
      client.listDbServers(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDbServersTest2() throws Exception {
    DbServer responsesElement = DbServer.newBuilder().build();
    ListDbServersResponse expectedResponse =
        ListDbServersResponse.newBuilder()
            .setNextPageToken("")
            .addAllDbServers(Arrays.asList(responsesElement))
            .build();
    mockOracleDatabase.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListDbServersPagedResponse pagedListResponse = client.listDbServers(parent);

    List<DbServer> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDbServersList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDbServersRequest actualRequest = ((ListDbServersRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDbServersExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listDbServers(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDbNodesTest() throws Exception {
    DbNode responsesElement = DbNode.newBuilder().build();
    ListDbNodesResponse expectedResponse =
        ListDbNodesResponse.newBuilder()
            .setNextPageToken("")
            .addAllDbNodes(Arrays.asList(responsesElement))
            .build();
    mockOracleDatabase.addResponse(expectedResponse);

    CloudVmClusterName parent =
        CloudVmClusterName.of("[PROJECT]", "[LOCATION]", "[CLOUD_VM_CLUSTER]");

    ListDbNodesPagedResponse pagedListResponse = client.listDbNodes(parent);

    List<DbNode> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDbNodesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDbNodesRequest actualRequest = ((ListDbNodesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDbNodesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      CloudVmClusterName parent =
          CloudVmClusterName.of("[PROJECT]", "[LOCATION]", "[CLOUD_VM_CLUSTER]");
      client.listDbNodes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDbNodesTest2() throws Exception {
    DbNode responsesElement = DbNode.newBuilder().build();
    ListDbNodesResponse expectedResponse =
        ListDbNodesResponse.newBuilder()
            .setNextPageToken("")
            .addAllDbNodes(Arrays.asList(responsesElement))
            .build();
    mockOracleDatabase.addResponse(expectedResponse);

    ExadbVmClusterName parent =
        ExadbVmClusterName.of("[PROJECT]", "[LOCATION]", "[EXADB_VM_CLUSTER]");

    ListDbNodesPagedResponse pagedListResponse = client.listDbNodes(parent);

    List<DbNode> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDbNodesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDbNodesRequest actualRequest = ((ListDbNodesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDbNodesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      ExadbVmClusterName parent =
          ExadbVmClusterName.of("[PROJECT]", "[LOCATION]", "[EXADB_VM_CLUSTER]");
      client.listDbNodes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDbNodesTest3() throws Exception {
    DbNode responsesElement = DbNode.newBuilder().build();
    ListDbNodesResponse expectedResponse =
        ListDbNodesResponse.newBuilder()
            .setNextPageToken("")
            .addAllDbNodes(Arrays.asList(responsesElement))
            .build();
    mockOracleDatabase.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListDbNodesPagedResponse pagedListResponse = client.listDbNodes(parent);

    List<DbNode> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDbNodesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDbNodesRequest actualRequest = ((ListDbNodesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDbNodesExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listDbNodes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listGiVersionsTest() throws Exception {
    GiVersion responsesElement = GiVersion.newBuilder().build();
    ListGiVersionsResponse expectedResponse =
        ListGiVersionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllGiVersions(Arrays.asList(responsesElement))
            .build();
    mockOracleDatabase.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListGiVersionsPagedResponse pagedListResponse = client.listGiVersions(parent);

    List<GiVersion> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getGiVersionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListGiVersionsRequest actualRequest = ((ListGiVersionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listGiVersionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listGiVersions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listGiVersionsTest2() throws Exception {
    GiVersion responsesElement = GiVersion.newBuilder().build();
    ListGiVersionsResponse expectedResponse =
        ListGiVersionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllGiVersions(Arrays.asList(responsesElement))
            .build();
    mockOracleDatabase.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListGiVersionsPagedResponse pagedListResponse = client.listGiVersions(parent);

    List<GiVersion> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getGiVersionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListGiVersionsRequest actualRequest = ((ListGiVersionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listGiVersionsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listGiVersions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listMinorVersionsTest() throws Exception {
    MinorVersion responsesElement = MinorVersion.newBuilder().build();
    ListMinorVersionsResponse expectedResponse =
        ListMinorVersionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllMinorVersions(Arrays.asList(responsesElement))
            .build();
    mockOracleDatabase.addResponse(expectedResponse);

    GiVersionName parent = GiVersionName.of("[PROJECT]", "[LOCATION]", "[GI_VERSION]");

    ListMinorVersionsPagedResponse pagedListResponse = client.listMinorVersions(parent);

    List<MinorVersion> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMinorVersionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListMinorVersionsRequest actualRequest = ((ListMinorVersionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listMinorVersionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      GiVersionName parent = GiVersionName.of("[PROJECT]", "[LOCATION]", "[GI_VERSION]");
      client.listMinorVersions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listMinorVersionsTest2() throws Exception {
    MinorVersion responsesElement = MinorVersion.newBuilder().build();
    ListMinorVersionsResponse expectedResponse =
        ListMinorVersionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllMinorVersions(Arrays.asList(responsesElement))
            .build();
    mockOracleDatabase.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListMinorVersionsPagedResponse pagedListResponse = client.listMinorVersions(parent);

    List<MinorVersion> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMinorVersionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListMinorVersionsRequest actualRequest = ((ListMinorVersionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listMinorVersionsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listMinorVersions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDbSystemShapesTest() throws Exception {
    DbSystemShape responsesElement = DbSystemShape.newBuilder().build();
    ListDbSystemShapesResponse expectedResponse =
        ListDbSystemShapesResponse.newBuilder()
            .setNextPageToken("")
            .addAllDbSystemShapes(Arrays.asList(responsesElement))
            .build();
    mockOracleDatabase.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListDbSystemShapesPagedResponse pagedListResponse = client.listDbSystemShapes(parent);

    List<DbSystemShape> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDbSystemShapesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDbSystemShapesRequest actualRequest = ((ListDbSystemShapesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDbSystemShapesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listDbSystemShapes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDbSystemShapesTest2() throws Exception {
    DbSystemShape responsesElement = DbSystemShape.newBuilder().build();
    ListDbSystemShapesResponse expectedResponse =
        ListDbSystemShapesResponse.newBuilder()
            .setNextPageToken("")
            .addAllDbSystemShapes(Arrays.asList(responsesElement))
            .build();
    mockOracleDatabase.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListDbSystemShapesPagedResponse pagedListResponse = client.listDbSystemShapes(parent);

    List<DbSystemShape> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDbSystemShapesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDbSystemShapesRequest actualRequest = ((ListDbSystemShapesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDbSystemShapesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listDbSystemShapes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAutonomousDatabasesTest() throws Exception {
    AutonomousDatabase responsesElement = AutonomousDatabase.newBuilder().build();
    ListAutonomousDatabasesResponse expectedResponse =
        ListAutonomousDatabasesResponse.newBuilder()
            .setNextPageToken("")
            .addAllAutonomousDatabases(Arrays.asList(responsesElement))
            .build();
    mockOracleDatabase.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListAutonomousDatabasesPagedResponse pagedListResponse = client.listAutonomousDatabases(parent);

    List<AutonomousDatabase> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAutonomousDatabasesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAutonomousDatabasesRequest actualRequest =
        ((ListAutonomousDatabasesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAutonomousDatabasesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listAutonomousDatabases(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAutonomousDatabasesTest2() throws Exception {
    AutonomousDatabase responsesElement = AutonomousDatabase.newBuilder().build();
    ListAutonomousDatabasesResponse expectedResponse =
        ListAutonomousDatabasesResponse.newBuilder()
            .setNextPageToken("")
            .addAllAutonomousDatabases(Arrays.asList(responsesElement))
            .build();
    mockOracleDatabase.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListAutonomousDatabasesPagedResponse pagedListResponse = client.listAutonomousDatabases(parent);

    List<AutonomousDatabase> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAutonomousDatabasesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAutonomousDatabasesRequest actualRequest =
        ((ListAutonomousDatabasesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAutonomousDatabasesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listAutonomousDatabases(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAutonomousDatabaseTest() throws Exception {
    AutonomousDatabase expectedResponse =
        AutonomousDatabase.newBuilder()
            .setName(
                AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]")
                    .toString())
            .setDatabase("database1789464955")
            .setDisplayName("displayName1714148973")
            .setEntitlementId("entitlementId-1302274264")
            .setAdminPassword("adminPassword-95067382")
            .setProperties(AutonomousDatabaseProperties.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setNetwork("network1843485230")
            .setCidr("cidr3053428")
            .setOdbNetwork(OdbNetworkName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]").toString())
            .setOdbSubnet(
                OdbSubnetName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]", "[ODB_SUBNET]")
                    .toString())
            .setSourceConfig(SourceConfig.newBuilder().build())
            .addAllPeerAutonomousDatabases(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .addAllDisasterRecoverySupportedLocations(new ArrayList<String>())
            .build();
    mockOracleDatabase.addResponse(expectedResponse);

    AutonomousDatabaseName name =
        AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]");

    AutonomousDatabase actualResponse = client.getAutonomousDatabase(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAutonomousDatabaseRequest actualRequest =
        ((GetAutonomousDatabaseRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAutonomousDatabaseExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      AutonomousDatabaseName name =
          AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]");
      client.getAutonomousDatabase(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAutonomousDatabaseTest2() throws Exception {
    AutonomousDatabase expectedResponse =
        AutonomousDatabase.newBuilder()
            .setName(
                AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]")
                    .toString())
            .setDatabase("database1789464955")
            .setDisplayName("displayName1714148973")
            .setEntitlementId("entitlementId-1302274264")
            .setAdminPassword("adminPassword-95067382")
            .setProperties(AutonomousDatabaseProperties.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setNetwork("network1843485230")
            .setCidr("cidr3053428")
            .setOdbNetwork(OdbNetworkName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]").toString())
            .setOdbSubnet(
                OdbSubnetName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]", "[ODB_SUBNET]")
                    .toString())
            .setSourceConfig(SourceConfig.newBuilder().build())
            .addAllPeerAutonomousDatabases(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .addAllDisasterRecoverySupportedLocations(new ArrayList<String>())
            .build();
    mockOracleDatabase.addResponse(expectedResponse);

    String name = "name3373707";

    AutonomousDatabase actualResponse = client.getAutonomousDatabase(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAutonomousDatabaseRequest actualRequest =
        ((GetAutonomousDatabaseRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAutonomousDatabaseExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      String name = "name3373707";
      client.getAutonomousDatabase(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createAutonomousDatabaseTest() throws Exception {
    AutonomousDatabase expectedResponse =
        AutonomousDatabase.newBuilder()
            .setName(
                AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]")
                    .toString())
            .setDatabase("database1789464955")
            .setDisplayName("displayName1714148973")
            .setEntitlementId("entitlementId-1302274264")
            .setAdminPassword("adminPassword-95067382")
            .setProperties(AutonomousDatabaseProperties.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setNetwork("network1843485230")
            .setCidr("cidr3053428")
            .setOdbNetwork(OdbNetworkName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]").toString())
            .setOdbSubnet(
                OdbSubnetName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]", "[ODB_SUBNET]")
                    .toString())
            .setSourceConfig(SourceConfig.newBuilder().build())
            .addAllPeerAutonomousDatabases(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .addAllDisasterRecoverySupportedLocations(new ArrayList<String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createAutonomousDatabaseTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockOracleDatabase.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    AutonomousDatabase autonomousDatabase = AutonomousDatabase.newBuilder().build();
    String autonomousDatabaseId = "autonomousDatabaseId-1972693114";

    AutonomousDatabase actualResponse =
        client
            .createAutonomousDatabaseAsync(parent, autonomousDatabase, autonomousDatabaseId)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateAutonomousDatabaseRequest actualRequest =
        ((CreateAutonomousDatabaseRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(autonomousDatabase, actualRequest.getAutonomousDatabase());
    Assert.assertEquals(autonomousDatabaseId, actualRequest.getAutonomousDatabaseId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createAutonomousDatabaseExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      AutonomousDatabase autonomousDatabase = AutonomousDatabase.newBuilder().build();
      String autonomousDatabaseId = "autonomousDatabaseId-1972693114";
      client.createAutonomousDatabaseAsync(parent, autonomousDatabase, autonomousDatabaseId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createAutonomousDatabaseTest2() throws Exception {
    AutonomousDatabase expectedResponse =
        AutonomousDatabase.newBuilder()
            .setName(
                AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]")
                    .toString())
            .setDatabase("database1789464955")
            .setDisplayName("displayName1714148973")
            .setEntitlementId("entitlementId-1302274264")
            .setAdminPassword("adminPassword-95067382")
            .setProperties(AutonomousDatabaseProperties.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setNetwork("network1843485230")
            .setCidr("cidr3053428")
            .setOdbNetwork(OdbNetworkName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]").toString())
            .setOdbSubnet(
                OdbSubnetName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]", "[ODB_SUBNET]")
                    .toString())
            .setSourceConfig(SourceConfig.newBuilder().build())
            .addAllPeerAutonomousDatabases(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .addAllDisasterRecoverySupportedLocations(new ArrayList<String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createAutonomousDatabaseTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockOracleDatabase.addResponse(resultOperation);

    String parent = "parent-995424086";
    AutonomousDatabase autonomousDatabase = AutonomousDatabase.newBuilder().build();
    String autonomousDatabaseId = "autonomousDatabaseId-1972693114";

    AutonomousDatabase actualResponse =
        client
            .createAutonomousDatabaseAsync(parent, autonomousDatabase, autonomousDatabaseId)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateAutonomousDatabaseRequest actualRequest =
        ((CreateAutonomousDatabaseRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(autonomousDatabase, actualRequest.getAutonomousDatabase());
    Assert.assertEquals(autonomousDatabaseId, actualRequest.getAutonomousDatabaseId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createAutonomousDatabaseExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      String parent = "parent-995424086";
      AutonomousDatabase autonomousDatabase = AutonomousDatabase.newBuilder().build();
      String autonomousDatabaseId = "autonomousDatabaseId-1972693114";
      client.createAutonomousDatabaseAsync(parent, autonomousDatabase, autonomousDatabaseId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateAutonomousDatabaseTest() throws Exception {
    AutonomousDatabase expectedResponse =
        AutonomousDatabase.newBuilder()
            .setName(
                AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]")
                    .toString())
            .setDatabase("database1789464955")
            .setDisplayName("displayName1714148973")
            .setEntitlementId("entitlementId-1302274264")
            .setAdminPassword("adminPassword-95067382")
            .setProperties(AutonomousDatabaseProperties.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setNetwork("network1843485230")
            .setCidr("cidr3053428")
            .setOdbNetwork(OdbNetworkName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]").toString())
            .setOdbSubnet(
                OdbSubnetName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]", "[ODB_SUBNET]")
                    .toString())
            .setSourceConfig(SourceConfig.newBuilder().build())
            .addAllPeerAutonomousDatabases(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .addAllDisasterRecoverySupportedLocations(new ArrayList<String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateAutonomousDatabaseTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockOracleDatabase.addResponse(resultOperation);

    AutonomousDatabase autonomousDatabase = AutonomousDatabase.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    AutonomousDatabase actualResponse =
        client.updateAutonomousDatabaseAsync(autonomousDatabase, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateAutonomousDatabaseRequest actualRequest =
        ((UpdateAutonomousDatabaseRequest) actualRequests.get(0));

    Assert.assertEquals(autonomousDatabase, actualRequest.getAutonomousDatabase());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateAutonomousDatabaseExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      AutonomousDatabase autonomousDatabase = AutonomousDatabase.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateAutonomousDatabaseAsync(autonomousDatabase, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteAutonomousDatabaseTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteAutonomousDatabaseTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockOracleDatabase.addResponse(resultOperation);

    AutonomousDatabaseName name =
        AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]");

    client.deleteAutonomousDatabaseAsync(name).get();

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteAutonomousDatabaseRequest actualRequest =
        ((DeleteAutonomousDatabaseRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteAutonomousDatabaseExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      AutonomousDatabaseName name =
          AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]");
      client.deleteAutonomousDatabaseAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteAutonomousDatabaseTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteAutonomousDatabaseTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockOracleDatabase.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteAutonomousDatabaseAsync(name).get();

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteAutonomousDatabaseRequest actualRequest =
        ((DeleteAutonomousDatabaseRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteAutonomousDatabaseExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      String name = "name3373707";
      client.deleteAutonomousDatabaseAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void restoreAutonomousDatabaseTest() throws Exception {
    AutonomousDatabase expectedResponse =
        AutonomousDatabase.newBuilder()
            .setName(
                AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]")
                    .toString())
            .setDatabase("database1789464955")
            .setDisplayName("displayName1714148973")
            .setEntitlementId("entitlementId-1302274264")
            .setAdminPassword("adminPassword-95067382")
            .setProperties(AutonomousDatabaseProperties.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setNetwork("network1843485230")
            .setCidr("cidr3053428")
            .setOdbNetwork(OdbNetworkName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]").toString())
            .setOdbSubnet(
                OdbSubnetName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]", "[ODB_SUBNET]")
                    .toString())
            .setSourceConfig(SourceConfig.newBuilder().build())
            .addAllPeerAutonomousDatabases(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .addAllDisasterRecoverySupportedLocations(new ArrayList<String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("restoreAutonomousDatabaseTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockOracleDatabase.addResponse(resultOperation);

    AutonomousDatabaseName name =
        AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]");
    Timestamp restoreTime = Timestamp.newBuilder().build();

    AutonomousDatabase actualResponse =
        client.restoreAutonomousDatabaseAsync(name, restoreTime).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RestoreAutonomousDatabaseRequest actualRequest =
        ((RestoreAutonomousDatabaseRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(restoreTime, actualRequest.getRestoreTime());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void restoreAutonomousDatabaseExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      AutonomousDatabaseName name =
          AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]");
      Timestamp restoreTime = Timestamp.newBuilder().build();
      client.restoreAutonomousDatabaseAsync(name, restoreTime).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void restoreAutonomousDatabaseTest2() throws Exception {
    AutonomousDatabase expectedResponse =
        AutonomousDatabase.newBuilder()
            .setName(
                AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]")
                    .toString())
            .setDatabase("database1789464955")
            .setDisplayName("displayName1714148973")
            .setEntitlementId("entitlementId-1302274264")
            .setAdminPassword("adminPassword-95067382")
            .setProperties(AutonomousDatabaseProperties.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setNetwork("network1843485230")
            .setCidr("cidr3053428")
            .setOdbNetwork(OdbNetworkName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]").toString())
            .setOdbSubnet(
                OdbSubnetName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]", "[ODB_SUBNET]")
                    .toString())
            .setSourceConfig(SourceConfig.newBuilder().build())
            .addAllPeerAutonomousDatabases(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .addAllDisasterRecoverySupportedLocations(new ArrayList<String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("restoreAutonomousDatabaseTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockOracleDatabase.addResponse(resultOperation);

    String name = "name3373707";
    Timestamp restoreTime = Timestamp.newBuilder().build();

    AutonomousDatabase actualResponse =
        client.restoreAutonomousDatabaseAsync(name, restoreTime).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RestoreAutonomousDatabaseRequest actualRequest =
        ((RestoreAutonomousDatabaseRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(restoreTime, actualRequest.getRestoreTime());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void restoreAutonomousDatabaseExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      String name = "name3373707";
      Timestamp restoreTime = Timestamp.newBuilder().build();
      client.restoreAutonomousDatabaseAsync(name, restoreTime).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void generateAutonomousDatabaseWalletTest() throws Exception {
    GenerateAutonomousDatabaseWalletResponse expectedResponse =
        GenerateAutonomousDatabaseWalletResponse.newBuilder()
            .setArchiveContent(ByteString.EMPTY)
            .build();
    mockOracleDatabase.addResponse(expectedResponse);

    AutonomousDatabaseName name =
        AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]");
    GenerateType type = GenerateType.forNumber(0);
    boolean isRegional = true;
    String password = "password1216985755";

    GenerateAutonomousDatabaseWalletResponse actualResponse =
        client.generateAutonomousDatabaseWallet(name, type, isRegional, password);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GenerateAutonomousDatabaseWalletRequest actualRequest =
        ((GenerateAutonomousDatabaseWalletRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(type, actualRequest.getType());
    Assert.assertEquals(isRegional, actualRequest.getIsRegional());
    Assert.assertEquals(password, actualRequest.getPassword());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void generateAutonomousDatabaseWalletExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      AutonomousDatabaseName name =
          AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]");
      GenerateType type = GenerateType.forNumber(0);
      boolean isRegional = true;
      String password = "password1216985755";
      client.generateAutonomousDatabaseWallet(name, type, isRegional, password);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void generateAutonomousDatabaseWalletTest2() throws Exception {
    GenerateAutonomousDatabaseWalletResponse expectedResponse =
        GenerateAutonomousDatabaseWalletResponse.newBuilder()
            .setArchiveContent(ByteString.EMPTY)
            .build();
    mockOracleDatabase.addResponse(expectedResponse);

    String name = "name3373707";
    GenerateType type = GenerateType.forNumber(0);
    boolean isRegional = true;
    String password = "password1216985755";

    GenerateAutonomousDatabaseWalletResponse actualResponse =
        client.generateAutonomousDatabaseWallet(name, type, isRegional, password);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GenerateAutonomousDatabaseWalletRequest actualRequest =
        ((GenerateAutonomousDatabaseWalletRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(type, actualRequest.getType());
    Assert.assertEquals(isRegional, actualRequest.getIsRegional());
    Assert.assertEquals(password, actualRequest.getPassword());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void generateAutonomousDatabaseWalletExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      String name = "name3373707";
      GenerateType type = GenerateType.forNumber(0);
      boolean isRegional = true;
      String password = "password1216985755";
      client.generateAutonomousDatabaseWallet(name, type, isRegional, password);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAutonomousDbVersionsTest() throws Exception {
    AutonomousDbVersion responsesElement = AutonomousDbVersion.newBuilder().build();
    ListAutonomousDbVersionsResponse expectedResponse =
        ListAutonomousDbVersionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAutonomousDbVersions(Arrays.asList(responsesElement))
            .build();
    mockOracleDatabase.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListAutonomousDbVersionsPagedResponse pagedListResponse =
        client.listAutonomousDbVersions(parent);

    List<AutonomousDbVersion> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAutonomousDbVersionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAutonomousDbVersionsRequest actualRequest =
        ((ListAutonomousDbVersionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAutonomousDbVersionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listAutonomousDbVersions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAutonomousDbVersionsTest2() throws Exception {
    AutonomousDbVersion responsesElement = AutonomousDbVersion.newBuilder().build();
    ListAutonomousDbVersionsResponse expectedResponse =
        ListAutonomousDbVersionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAutonomousDbVersions(Arrays.asList(responsesElement))
            .build();
    mockOracleDatabase.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListAutonomousDbVersionsPagedResponse pagedListResponse =
        client.listAutonomousDbVersions(parent);

    List<AutonomousDbVersion> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAutonomousDbVersionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAutonomousDbVersionsRequest actualRequest =
        ((ListAutonomousDbVersionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAutonomousDbVersionsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listAutonomousDbVersions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAutonomousDatabaseCharacterSetsTest() throws Exception {
    AutonomousDatabaseCharacterSet responsesElement =
        AutonomousDatabaseCharacterSet.newBuilder().build();
    ListAutonomousDatabaseCharacterSetsResponse expectedResponse =
        ListAutonomousDatabaseCharacterSetsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAutonomousDatabaseCharacterSets(Arrays.asList(responsesElement))
            .build();
    mockOracleDatabase.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListAutonomousDatabaseCharacterSetsPagedResponse pagedListResponse =
        client.listAutonomousDatabaseCharacterSets(parent);

    List<AutonomousDatabaseCharacterSet> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getAutonomousDatabaseCharacterSetsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAutonomousDatabaseCharacterSetsRequest actualRequest =
        ((ListAutonomousDatabaseCharacterSetsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAutonomousDatabaseCharacterSetsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listAutonomousDatabaseCharacterSets(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAutonomousDatabaseCharacterSetsTest2() throws Exception {
    AutonomousDatabaseCharacterSet responsesElement =
        AutonomousDatabaseCharacterSet.newBuilder().build();
    ListAutonomousDatabaseCharacterSetsResponse expectedResponse =
        ListAutonomousDatabaseCharacterSetsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAutonomousDatabaseCharacterSets(Arrays.asList(responsesElement))
            .build();
    mockOracleDatabase.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListAutonomousDatabaseCharacterSetsPagedResponse pagedListResponse =
        client.listAutonomousDatabaseCharacterSets(parent);

    List<AutonomousDatabaseCharacterSet> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getAutonomousDatabaseCharacterSetsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAutonomousDatabaseCharacterSetsRequest actualRequest =
        ((ListAutonomousDatabaseCharacterSetsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAutonomousDatabaseCharacterSetsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listAutonomousDatabaseCharacterSets(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAutonomousDatabaseBackupsTest() throws Exception {
    AutonomousDatabaseBackup responsesElement = AutonomousDatabaseBackup.newBuilder().build();
    ListAutonomousDatabaseBackupsResponse expectedResponse =
        ListAutonomousDatabaseBackupsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAutonomousDatabaseBackups(Arrays.asList(responsesElement))
            .build();
    mockOracleDatabase.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListAutonomousDatabaseBackupsPagedResponse pagedListResponse =
        client.listAutonomousDatabaseBackups(parent);

    List<AutonomousDatabaseBackup> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getAutonomousDatabaseBackupsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAutonomousDatabaseBackupsRequest actualRequest =
        ((ListAutonomousDatabaseBackupsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAutonomousDatabaseBackupsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listAutonomousDatabaseBackups(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAutonomousDatabaseBackupsTest2() throws Exception {
    AutonomousDatabaseBackup responsesElement = AutonomousDatabaseBackup.newBuilder().build();
    ListAutonomousDatabaseBackupsResponse expectedResponse =
        ListAutonomousDatabaseBackupsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAutonomousDatabaseBackups(Arrays.asList(responsesElement))
            .build();
    mockOracleDatabase.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListAutonomousDatabaseBackupsPagedResponse pagedListResponse =
        client.listAutonomousDatabaseBackups(parent);

    List<AutonomousDatabaseBackup> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getAutonomousDatabaseBackupsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAutonomousDatabaseBackupsRequest actualRequest =
        ((ListAutonomousDatabaseBackupsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAutonomousDatabaseBackupsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listAutonomousDatabaseBackups(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void stopAutonomousDatabaseTest() throws Exception {
    AutonomousDatabase expectedResponse =
        AutonomousDatabase.newBuilder()
            .setName(
                AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]")
                    .toString())
            .setDatabase("database1789464955")
            .setDisplayName("displayName1714148973")
            .setEntitlementId("entitlementId-1302274264")
            .setAdminPassword("adminPassword-95067382")
            .setProperties(AutonomousDatabaseProperties.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setNetwork("network1843485230")
            .setCidr("cidr3053428")
            .setOdbNetwork(OdbNetworkName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]").toString())
            .setOdbSubnet(
                OdbSubnetName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]", "[ODB_SUBNET]")
                    .toString())
            .setSourceConfig(SourceConfig.newBuilder().build())
            .addAllPeerAutonomousDatabases(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .addAllDisasterRecoverySupportedLocations(new ArrayList<String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("stopAutonomousDatabaseTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockOracleDatabase.addResponse(resultOperation);

    AutonomousDatabaseName name =
        AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]");

    AutonomousDatabase actualResponse = client.stopAutonomousDatabaseAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    StopAutonomousDatabaseRequest actualRequest =
        ((StopAutonomousDatabaseRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void stopAutonomousDatabaseExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      AutonomousDatabaseName name =
          AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]");
      client.stopAutonomousDatabaseAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void stopAutonomousDatabaseTest2() throws Exception {
    AutonomousDatabase expectedResponse =
        AutonomousDatabase.newBuilder()
            .setName(
                AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]")
                    .toString())
            .setDatabase("database1789464955")
            .setDisplayName("displayName1714148973")
            .setEntitlementId("entitlementId-1302274264")
            .setAdminPassword("adminPassword-95067382")
            .setProperties(AutonomousDatabaseProperties.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setNetwork("network1843485230")
            .setCidr("cidr3053428")
            .setOdbNetwork(OdbNetworkName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]").toString())
            .setOdbSubnet(
                OdbSubnetName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]", "[ODB_SUBNET]")
                    .toString())
            .setSourceConfig(SourceConfig.newBuilder().build())
            .addAllPeerAutonomousDatabases(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .addAllDisasterRecoverySupportedLocations(new ArrayList<String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("stopAutonomousDatabaseTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockOracleDatabase.addResponse(resultOperation);

    String name = "name3373707";

    AutonomousDatabase actualResponse = client.stopAutonomousDatabaseAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    StopAutonomousDatabaseRequest actualRequest =
        ((StopAutonomousDatabaseRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void stopAutonomousDatabaseExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      String name = "name3373707";
      client.stopAutonomousDatabaseAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void startAutonomousDatabaseTest() throws Exception {
    AutonomousDatabase expectedResponse =
        AutonomousDatabase.newBuilder()
            .setName(
                AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]")
                    .toString())
            .setDatabase("database1789464955")
            .setDisplayName("displayName1714148973")
            .setEntitlementId("entitlementId-1302274264")
            .setAdminPassword("adminPassword-95067382")
            .setProperties(AutonomousDatabaseProperties.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setNetwork("network1843485230")
            .setCidr("cidr3053428")
            .setOdbNetwork(OdbNetworkName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]").toString())
            .setOdbSubnet(
                OdbSubnetName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]", "[ODB_SUBNET]")
                    .toString())
            .setSourceConfig(SourceConfig.newBuilder().build())
            .addAllPeerAutonomousDatabases(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .addAllDisasterRecoverySupportedLocations(new ArrayList<String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("startAutonomousDatabaseTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockOracleDatabase.addResponse(resultOperation);

    AutonomousDatabaseName name =
        AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]");

    AutonomousDatabase actualResponse = client.startAutonomousDatabaseAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    StartAutonomousDatabaseRequest actualRequest =
        ((StartAutonomousDatabaseRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void startAutonomousDatabaseExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      AutonomousDatabaseName name =
          AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]");
      client.startAutonomousDatabaseAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void startAutonomousDatabaseTest2() throws Exception {
    AutonomousDatabase expectedResponse =
        AutonomousDatabase.newBuilder()
            .setName(
                AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]")
                    .toString())
            .setDatabase("database1789464955")
            .setDisplayName("displayName1714148973")
            .setEntitlementId("entitlementId-1302274264")
            .setAdminPassword("adminPassword-95067382")
            .setProperties(AutonomousDatabaseProperties.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setNetwork("network1843485230")
            .setCidr("cidr3053428")
            .setOdbNetwork(OdbNetworkName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]").toString())
            .setOdbSubnet(
                OdbSubnetName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]", "[ODB_SUBNET]")
                    .toString())
            .setSourceConfig(SourceConfig.newBuilder().build())
            .addAllPeerAutonomousDatabases(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .addAllDisasterRecoverySupportedLocations(new ArrayList<String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("startAutonomousDatabaseTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockOracleDatabase.addResponse(resultOperation);

    String name = "name3373707";

    AutonomousDatabase actualResponse = client.startAutonomousDatabaseAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    StartAutonomousDatabaseRequest actualRequest =
        ((StartAutonomousDatabaseRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void startAutonomousDatabaseExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      String name = "name3373707";
      client.startAutonomousDatabaseAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void restartAutonomousDatabaseTest() throws Exception {
    AutonomousDatabase expectedResponse =
        AutonomousDatabase.newBuilder()
            .setName(
                AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]")
                    .toString())
            .setDatabase("database1789464955")
            .setDisplayName("displayName1714148973")
            .setEntitlementId("entitlementId-1302274264")
            .setAdminPassword("adminPassword-95067382")
            .setProperties(AutonomousDatabaseProperties.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setNetwork("network1843485230")
            .setCidr("cidr3053428")
            .setOdbNetwork(OdbNetworkName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]").toString())
            .setOdbSubnet(
                OdbSubnetName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]", "[ODB_SUBNET]")
                    .toString())
            .setSourceConfig(SourceConfig.newBuilder().build())
            .addAllPeerAutonomousDatabases(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .addAllDisasterRecoverySupportedLocations(new ArrayList<String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("restartAutonomousDatabaseTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockOracleDatabase.addResponse(resultOperation);

    AutonomousDatabaseName name =
        AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]");

    AutonomousDatabase actualResponse = client.restartAutonomousDatabaseAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RestartAutonomousDatabaseRequest actualRequest =
        ((RestartAutonomousDatabaseRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void restartAutonomousDatabaseExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      AutonomousDatabaseName name =
          AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]");
      client.restartAutonomousDatabaseAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void restartAutonomousDatabaseTest2() throws Exception {
    AutonomousDatabase expectedResponse =
        AutonomousDatabase.newBuilder()
            .setName(
                AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]")
                    .toString())
            .setDatabase("database1789464955")
            .setDisplayName("displayName1714148973")
            .setEntitlementId("entitlementId-1302274264")
            .setAdminPassword("adminPassword-95067382")
            .setProperties(AutonomousDatabaseProperties.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setNetwork("network1843485230")
            .setCidr("cidr3053428")
            .setOdbNetwork(OdbNetworkName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]").toString())
            .setOdbSubnet(
                OdbSubnetName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]", "[ODB_SUBNET]")
                    .toString())
            .setSourceConfig(SourceConfig.newBuilder().build())
            .addAllPeerAutonomousDatabases(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .addAllDisasterRecoverySupportedLocations(new ArrayList<String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("restartAutonomousDatabaseTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockOracleDatabase.addResponse(resultOperation);

    String name = "name3373707";

    AutonomousDatabase actualResponse = client.restartAutonomousDatabaseAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RestartAutonomousDatabaseRequest actualRequest =
        ((RestartAutonomousDatabaseRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void restartAutonomousDatabaseExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      String name = "name3373707";
      client.restartAutonomousDatabaseAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void switchoverAutonomousDatabaseTest() throws Exception {
    AutonomousDatabase expectedResponse =
        AutonomousDatabase.newBuilder()
            .setName(
                AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]")
                    .toString())
            .setDatabase("database1789464955")
            .setDisplayName("displayName1714148973")
            .setEntitlementId("entitlementId-1302274264")
            .setAdminPassword("adminPassword-95067382")
            .setProperties(AutonomousDatabaseProperties.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setNetwork("network1843485230")
            .setCidr("cidr3053428")
            .setOdbNetwork(OdbNetworkName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]").toString())
            .setOdbSubnet(
                OdbSubnetName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]", "[ODB_SUBNET]")
                    .toString())
            .setSourceConfig(SourceConfig.newBuilder().build())
            .addAllPeerAutonomousDatabases(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .addAllDisasterRecoverySupportedLocations(new ArrayList<String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("switchoverAutonomousDatabaseTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockOracleDatabase.addResponse(resultOperation);

    AutonomousDatabaseName name =
        AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]");
    AutonomousDatabaseName peerAutonomousDatabase =
        AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]");

    AutonomousDatabase actualResponse =
        client.switchoverAutonomousDatabaseAsync(name, peerAutonomousDatabase).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SwitchoverAutonomousDatabaseRequest actualRequest =
        ((SwitchoverAutonomousDatabaseRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(
        peerAutonomousDatabase.toString(), actualRequest.getPeerAutonomousDatabase());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void switchoverAutonomousDatabaseExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      AutonomousDatabaseName name =
          AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]");
      AutonomousDatabaseName peerAutonomousDatabase =
          AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]");
      client.switchoverAutonomousDatabaseAsync(name, peerAutonomousDatabase).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void switchoverAutonomousDatabaseTest2() throws Exception {
    AutonomousDatabase expectedResponse =
        AutonomousDatabase.newBuilder()
            .setName(
                AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]")
                    .toString())
            .setDatabase("database1789464955")
            .setDisplayName("displayName1714148973")
            .setEntitlementId("entitlementId-1302274264")
            .setAdminPassword("adminPassword-95067382")
            .setProperties(AutonomousDatabaseProperties.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setNetwork("network1843485230")
            .setCidr("cidr3053428")
            .setOdbNetwork(OdbNetworkName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]").toString())
            .setOdbSubnet(
                OdbSubnetName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]", "[ODB_SUBNET]")
                    .toString())
            .setSourceConfig(SourceConfig.newBuilder().build())
            .addAllPeerAutonomousDatabases(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .addAllDisasterRecoverySupportedLocations(new ArrayList<String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("switchoverAutonomousDatabaseTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockOracleDatabase.addResponse(resultOperation);

    AutonomousDatabaseName name =
        AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]");
    String peerAutonomousDatabase = "peerAutonomousDatabase-1153991155";

    AutonomousDatabase actualResponse =
        client.switchoverAutonomousDatabaseAsync(name, peerAutonomousDatabase).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SwitchoverAutonomousDatabaseRequest actualRequest =
        ((SwitchoverAutonomousDatabaseRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(peerAutonomousDatabase, actualRequest.getPeerAutonomousDatabase());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void switchoverAutonomousDatabaseExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      AutonomousDatabaseName name =
          AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]");
      String peerAutonomousDatabase = "peerAutonomousDatabase-1153991155";
      client.switchoverAutonomousDatabaseAsync(name, peerAutonomousDatabase).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void switchoverAutonomousDatabaseTest3() throws Exception {
    AutonomousDatabase expectedResponse =
        AutonomousDatabase.newBuilder()
            .setName(
                AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]")
                    .toString())
            .setDatabase("database1789464955")
            .setDisplayName("displayName1714148973")
            .setEntitlementId("entitlementId-1302274264")
            .setAdminPassword("adminPassword-95067382")
            .setProperties(AutonomousDatabaseProperties.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setNetwork("network1843485230")
            .setCidr("cidr3053428")
            .setOdbNetwork(OdbNetworkName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]").toString())
            .setOdbSubnet(
                OdbSubnetName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]", "[ODB_SUBNET]")
                    .toString())
            .setSourceConfig(SourceConfig.newBuilder().build())
            .addAllPeerAutonomousDatabases(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .addAllDisasterRecoverySupportedLocations(new ArrayList<String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("switchoverAutonomousDatabaseTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockOracleDatabase.addResponse(resultOperation);

    String name = "name3373707";
    AutonomousDatabaseName peerAutonomousDatabase =
        AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]");

    AutonomousDatabase actualResponse =
        client.switchoverAutonomousDatabaseAsync(name, peerAutonomousDatabase).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SwitchoverAutonomousDatabaseRequest actualRequest =
        ((SwitchoverAutonomousDatabaseRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(
        peerAutonomousDatabase.toString(), actualRequest.getPeerAutonomousDatabase());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void switchoverAutonomousDatabaseExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      String name = "name3373707";
      AutonomousDatabaseName peerAutonomousDatabase =
          AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]");
      client.switchoverAutonomousDatabaseAsync(name, peerAutonomousDatabase).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void switchoverAutonomousDatabaseTest4() throws Exception {
    AutonomousDatabase expectedResponse =
        AutonomousDatabase.newBuilder()
            .setName(
                AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]")
                    .toString())
            .setDatabase("database1789464955")
            .setDisplayName("displayName1714148973")
            .setEntitlementId("entitlementId-1302274264")
            .setAdminPassword("adminPassword-95067382")
            .setProperties(AutonomousDatabaseProperties.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setNetwork("network1843485230")
            .setCidr("cidr3053428")
            .setOdbNetwork(OdbNetworkName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]").toString())
            .setOdbSubnet(
                OdbSubnetName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]", "[ODB_SUBNET]")
                    .toString())
            .setSourceConfig(SourceConfig.newBuilder().build())
            .addAllPeerAutonomousDatabases(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .addAllDisasterRecoverySupportedLocations(new ArrayList<String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("switchoverAutonomousDatabaseTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockOracleDatabase.addResponse(resultOperation);

    String name = "name3373707";
    String peerAutonomousDatabase = "peerAutonomousDatabase-1153991155";

    AutonomousDatabase actualResponse =
        client.switchoverAutonomousDatabaseAsync(name, peerAutonomousDatabase).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SwitchoverAutonomousDatabaseRequest actualRequest =
        ((SwitchoverAutonomousDatabaseRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(peerAutonomousDatabase, actualRequest.getPeerAutonomousDatabase());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void switchoverAutonomousDatabaseExceptionTest4() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      String name = "name3373707";
      String peerAutonomousDatabase = "peerAutonomousDatabase-1153991155";
      client.switchoverAutonomousDatabaseAsync(name, peerAutonomousDatabase).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void failoverAutonomousDatabaseTest() throws Exception {
    AutonomousDatabase expectedResponse =
        AutonomousDatabase.newBuilder()
            .setName(
                AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]")
                    .toString())
            .setDatabase("database1789464955")
            .setDisplayName("displayName1714148973")
            .setEntitlementId("entitlementId-1302274264")
            .setAdminPassword("adminPassword-95067382")
            .setProperties(AutonomousDatabaseProperties.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setNetwork("network1843485230")
            .setCidr("cidr3053428")
            .setOdbNetwork(OdbNetworkName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]").toString())
            .setOdbSubnet(
                OdbSubnetName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]", "[ODB_SUBNET]")
                    .toString())
            .setSourceConfig(SourceConfig.newBuilder().build())
            .addAllPeerAutonomousDatabases(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .addAllDisasterRecoverySupportedLocations(new ArrayList<String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("failoverAutonomousDatabaseTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockOracleDatabase.addResponse(resultOperation);

    AutonomousDatabaseName name =
        AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]");
    AutonomousDatabaseName peerAutonomousDatabase =
        AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]");

    AutonomousDatabase actualResponse =
        client.failoverAutonomousDatabaseAsync(name, peerAutonomousDatabase).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    FailoverAutonomousDatabaseRequest actualRequest =
        ((FailoverAutonomousDatabaseRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(
        peerAutonomousDatabase.toString(), actualRequest.getPeerAutonomousDatabase());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void failoverAutonomousDatabaseExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      AutonomousDatabaseName name =
          AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]");
      AutonomousDatabaseName peerAutonomousDatabase =
          AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]");
      client.failoverAutonomousDatabaseAsync(name, peerAutonomousDatabase).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void failoverAutonomousDatabaseTest2() throws Exception {
    AutonomousDatabase expectedResponse =
        AutonomousDatabase.newBuilder()
            .setName(
                AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]")
                    .toString())
            .setDatabase("database1789464955")
            .setDisplayName("displayName1714148973")
            .setEntitlementId("entitlementId-1302274264")
            .setAdminPassword("adminPassword-95067382")
            .setProperties(AutonomousDatabaseProperties.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setNetwork("network1843485230")
            .setCidr("cidr3053428")
            .setOdbNetwork(OdbNetworkName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]").toString())
            .setOdbSubnet(
                OdbSubnetName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]", "[ODB_SUBNET]")
                    .toString())
            .setSourceConfig(SourceConfig.newBuilder().build())
            .addAllPeerAutonomousDatabases(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .addAllDisasterRecoverySupportedLocations(new ArrayList<String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("failoverAutonomousDatabaseTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockOracleDatabase.addResponse(resultOperation);

    AutonomousDatabaseName name =
        AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]");
    String peerAutonomousDatabase = "peerAutonomousDatabase-1153991155";

    AutonomousDatabase actualResponse =
        client.failoverAutonomousDatabaseAsync(name, peerAutonomousDatabase).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    FailoverAutonomousDatabaseRequest actualRequest =
        ((FailoverAutonomousDatabaseRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(peerAutonomousDatabase, actualRequest.getPeerAutonomousDatabase());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void failoverAutonomousDatabaseExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      AutonomousDatabaseName name =
          AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]");
      String peerAutonomousDatabase = "peerAutonomousDatabase-1153991155";
      client.failoverAutonomousDatabaseAsync(name, peerAutonomousDatabase).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void failoverAutonomousDatabaseTest3() throws Exception {
    AutonomousDatabase expectedResponse =
        AutonomousDatabase.newBuilder()
            .setName(
                AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]")
                    .toString())
            .setDatabase("database1789464955")
            .setDisplayName("displayName1714148973")
            .setEntitlementId("entitlementId-1302274264")
            .setAdminPassword("adminPassword-95067382")
            .setProperties(AutonomousDatabaseProperties.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setNetwork("network1843485230")
            .setCidr("cidr3053428")
            .setOdbNetwork(OdbNetworkName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]").toString())
            .setOdbSubnet(
                OdbSubnetName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]", "[ODB_SUBNET]")
                    .toString())
            .setSourceConfig(SourceConfig.newBuilder().build())
            .addAllPeerAutonomousDatabases(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .addAllDisasterRecoverySupportedLocations(new ArrayList<String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("failoverAutonomousDatabaseTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockOracleDatabase.addResponse(resultOperation);

    String name = "name3373707";
    AutonomousDatabaseName peerAutonomousDatabase =
        AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]");

    AutonomousDatabase actualResponse =
        client.failoverAutonomousDatabaseAsync(name, peerAutonomousDatabase).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    FailoverAutonomousDatabaseRequest actualRequest =
        ((FailoverAutonomousDatabaseRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(
        peerAutonomousDatabase.toString(), actualRequest.getPeerAutonomousDatabase());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void failoverAutonomousDatabaseExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      String name = "name3373707";
      AutonomousDatabaseName peerAutonomousDatabase =
          AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]");
      client.failoverAutonomousDatabaseAsync(name, peerAutonomousDatabase).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void failoverAutonomousDatabaseTest4() throws Exception {
    AutonomousDatabase expectedResponse =
        AutonomousDatabase.newBuilder()
            .setName(
                AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]")
                    .toString())
            .setDatabase("database1789464955")
            .setDisplayName("displayName1714148973")
            .setEntitlementId("entitlementId-1302274264")
            .setAdminPassword("adminPassword-95067382")
            .setProperties(AutonomousDatabaseProperties.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setNetwork("network1843485230")
            .setCidr("cidr3053428")
            .setOdbNetwork(OdbNetworkName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]").toString())
            .setOdbSubnet(
                OdbSubnetName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]", "[ODB_SUBNET]")
                    .toString())
            .setSourceConfig(SourceConfig.newBuilder().build())
            .addAllPeerAutonomousDatabases(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .addAllDisasterRecoverySupportedLocations(new ArrayList<String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("failoverAutonomousDatabaseTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockOracleDatabase.addResponse(resultOperation);

    String name = "name3373707";
    String peerAutonomousDatabase = "peerAutonomousDatabase-1153991155";

    AutonomousDatabase actualResponse =
        client.failoverAutonomousDatabaseAsync(name, peerAutonomousDatabase).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    FailoverAutonomousDatabaseRequest actualRequest =
        ((FailoverAutonomousDatabaseRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(peerAutonomousDatabase, actualRequest.getPeerAutonomousDatabase());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void failoverAutonomousDatabaseExceptionTest4() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      String name = "name3373707";
      String peerAutonomousDatabase = "peerAutonomousDatabase-1153991155";
      client.failoverAutonomousDatabaseAsync(name, peerAutonomousDatabase).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listOdbNetworksTest() throws Exception {
    OdbNetwork responsesElement = OdbNetwork.newBuilder().build();
    ListOdbNetworksResponse expectedResponse =
        ListOdbNetworksResponse.newBuilder()
            .setNextPageToken("")
            .addAllOdbNetworks(Arrays.asList(responsesElement))
            .build();
    mockOracleDatabase.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListOdbNetworksPagedResponse pagedListResponse = client.listOdbNetworks(parent);

    List<OdbNetwork> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getOdbNetworksList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListOdbNetworksRequest actualRequest = ((ListOdbNetworksRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listOdbNetworksExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listOdbNetworks(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listOdbNetworksTest2() throws Exception {
    OdbNetwork responsesElement = OdbNetwork.newBuilder().build();
    ListOdbNetworksResponse expectedResponse =
        ListOdbNetworksResponse.newBuilder()
            .setNextPageToken("")
            .addAllOdbNetworks(Arrays.asList(responsesElement))
            .build();
    mockOracleDatabase.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListOdbNetworksPagedResponse pagedListResponse = client.listOdbNetworks(parent);

    List<OdbNetwork> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getOdbNetworksList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListOdbNetworksRequest actualRequest = ((ListOdbNetworksRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listOdbNetworksExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listOdbNetworks(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getOdbNetworkTest() throws Exception {
    OdbNetwork expectedResponse =
        OdbNetwork.newBuilder()
            .setName(OdbNetworkName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]").toString())
            .setNetwork("network1843485230")
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setEntitlementId("entitlementId-1302274264")
            .setGcpOracleZone("gcpOracleZone217860222")
            .build();
    mockOracleDatabase.addResponse(expectedResponse);

    OdbNetworkName name = OdbNetworkName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]");

    OdbNetwork actualResponse = client.getOdbNetwork(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetOdbNetworkRequest actualRequest = ((GetOdbNetworkRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getOdbNetworkExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      OdbNetworkName name = OdbNetworkName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]");
      client.getOdbNetwork(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getOdbNetworkTest2() throws Exception {
    OdbNetwork expectedResponse =
        OdbNetwork.newBuilder()
            .setName(OdbNetworkName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]").toString())
            .setNetwork("network1843485230")
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setEntitlementId("entitlementId-1302274264")
            .setGcpOracleZone("gcpOracleZone217860222")
            .build();
    mockOracleDatabase.addResponse(expectedResponse);

    String name = "name3373707";

    OdbNetwork actualResponse = client.getOdbNetwork(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetOdbNetworkRequest actualRequest = ((GetOdbNetworkRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getOdbNetworkExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      String name = "name3373707";
      client.getOdbNetwork(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createOdbNetworkTest() throws Exception {
    OdbNetwork expectedResponse =
        OdbNetwork.newBuilder()
            .setName(OdbNetworkName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]").toString())
            .setNetwork("network1843485230")
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setEntitlementId("entitlementId-1302274264")
            .setGcpOracleZone("gcpOracleZone217860222")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createOdbNetworkTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockOracleDatabase.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    OdbNetwork odbNetwork = OdbNetwork.newBuilder().build();
    String odbNetworkId = "odbNetworkId-169900740";

    OdbNetwork actualResponse =
        client.createOdbNetworkAsync(parent, odbNetwork, odbNetworkId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateOdbNetworkRequest actualRequest = ((CreateOdbNetworkRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(odbNetwork, actualRequest.getOdbNetwork());
    Assert.assertEquals(odbNetworkId, actualRequest.getOdbNetworkId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createOdbNetworkExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      OdbNetwork odbNetwork = OdbNetwork.newBuilder().build();
      String odbNetworkId = "odbNetworkId-169900740";
      client.createOdbNetworkAsync(parent, odbNetwork, odbNetworkId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createOdbNetworkTest2() throws Exception {
    OdbNetwork expectedResponse =
        OdbNetwork.newBuilder()
            .setName(OdbNetworkName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]").toString())
            .setNetwork("network1843485230")
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setEntitlementId("entitlementId-1302274264")
            .setGcpOracleZone("gcpOracleZone217860222")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createOdbNetworkTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockOracleDatabase.addResponse(resultOperation);

    String parent = "parent-995424086";
    OdbNetwork odbNetwork = OdbNetwork.newBuilder().build();
    String odbNetworkId = "odbNetworkId-169900740";

    OdbNetwork actualResponse =
        client.createOdbNetworkAsync(parent, odbNetwork, odbNetworkId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateOdbNetworkRequest actualRequest = ((CreateOdbNetworkRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(odbNetwork, actualRequest.getOdbNetwork());
    Assert.assertEquals(odbNetworkId, actualRequest.getOdbNetworkId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createOdbNetworkExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      String parent = "parent-995424086";
      OdbNetwork odbNetwork = OdbNetwork.newBuilder().build();
      String odbNetworkId = "odbNetworkId-169900740";
      client.createOdbNetworkAsync(parent, odbNetwork, odbNetworkId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteOdbNetworkTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteOdbNetworkTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockOracleDatabase.addResponse(resultOperation);

    OdbNetworkName name = OdbNetworkName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]");

    client.deleteOdbNetworkAsync(name).get();

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteOdbNetworkRequest actualRequest = ((DeleteOdbNetworkRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteOdbNetworkExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      OdbNetworkName name = OdbNetworkName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]");
      client.deleteOdbNetworkAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteOdbNetworkTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteOdbNetworkTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockOracleDatabase.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteOdbNetworkAsync(name).get();

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteOdbNetworkRequest actualRequest = ((DeleteOdbNetworkRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteOdbNetworkExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      String name = "name3373707";
      client.deleteOdbNetworkAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listOdbSubnetsTest() throws Exception {
    OdbSubnet responsesElement = OdbSubnet.newBuilder().build();
    ListOdbSubnetsResponse expectedResponse =
        ListOdbSubnetsResponse.newBuilder()
            .setNextPageToken("")
            .addAllOdbSubnets(Arrays.asList(responsesElement))
            .build();
    mockOracleDatabase.addResponse(expectedResponse);

    OdbNetworkName parent = OdbNetworkName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]");

    ListOdbSubnetsPagedResponse pagedListResponse = client.listOdbSubnets(parent);

    List<OdbSubnet> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getOdbSubnetsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListOdbSubnetsRequest actualRequest = ((ListOdbSubnetsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listOdbSubnetsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      OdbNetworkName parent = OdbNetworkName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]");
      client.listOdbSubnets(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listOdbSubnetsTest2() throws Exception {
    OdbSubnet responsesElement = OdbSubnet.newBuilder().build();
    ListOdbSubnetsResponse expectedResponse =
        ListOdbSubnetsResponse.newBuilder()
            .setNextPageToken("")
            .addAllOdbSubnets(Arrays.asList(responsesElement))
            .build();
    mockOracleDatabase.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListOdbSubnetsPagedResponse pagedListResponse = client.listOdbSubnets(parent);

    List<OdbSubnet> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getOdbSubnetsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListOdbSubnetsRequest actualRequest = ((ListOdbSubnetsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listOdbSubnetsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listOdbSubnets(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getOdbSubnetTest() throws Exception {
    OdbSubnet expectedResponse =
        OdbSubnet.newBuilder()
            .setName(
                OdbSubnetName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]", "[ODB_SUBNET]")
                    .toString())
            .setCidrRange("cidrRange1660631593")
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    mockOracleDatabase.addResponse(expectedResponse);

    OdbSubnetName name =
        OdbSubnetName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]", "[ODB_SUBNET]");

    OdbSubnet actualResponse = client.getOdbSubnet(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetOdbSubnetRequest actualRequest = ((GetOdbSubnetRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getOdbSubnetExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      OdbSubnetName name =
          OdbSubnetName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]", "[ODB_SUBNET]");
      client.getOdbSubnet(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getOdbSubnetTest2() throws Exception {
    OdbSubnet expectedResponse =
        OdbSubnet.newBuilder()
            .setName(
                OdbSubnetName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]", "[ODB_SUBNET]")
                    .toString())
            .setCidrRange("cidrRange1660631593")
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    mockOracleDatabase.addResponse(expectedResponse);

    String name = "name3373707";

    OdbSubnet actualResponse = client.getOdbSubnet(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetOdbSubnetRequest actualRequest = ((GetOdbSubnetRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getOdbSubnetExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      String name = "name3373707";
      client.getOdbSubnet(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createOdbSubnetTest() throws Exception {
    OdbSubnet expectedResponse =
        OdbSubnet.newBuilder()
            .setName(
                OdbSubnetName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]", "[ODB_SUBNET]")
                    .toString())
            .setCidrRange("cidrRange1660631593")
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createOdbSubnetTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockOracleDatabase.addResponse(resultOperation);

    OdbNetworkName parent = OdbNetworkName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]");
    OdbSubnet odbSubnet = OdbSubnet.newBuilder().build();
    String odbSubnetId = "odbSubnetId1186954661";

    OdbSubnet actualResponse = client.createOdbSubnetAsync(parent, odbSubnet, odbSubnetId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateOdbSubnetRequest actualRequest = ((CreateOdbSubnetRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(odbSubnet, actualRequest.getOdbSubnet());
    Assert.assertEquals(odbSubnetId, actualRequest.getOdbSubnetId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createOdbSubnetExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      OdbNetworkName parent = OdbNetworkName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]");
      OdbSubnet odbSubnet = OdbSubnet.newBuilder().build();
      String odbSubnetId = "odbSubnetId1186954661";
      client.createOdbSubnetAsync(parent, odbSubnet, odbSubnetId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createOdbSubnetTest2() throws Exception {
    OdbSubnet expectedResponse =
        OdbSubnet.newBuilder()
            .setName(
                OdbSubnetName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]", "[ODB_SUBNET]")
                    .toString())
            .setCidrRange("cidrRange1660631593")
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createOdbSubnetTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockOracleDatabase.addResponse(resultOperation);

    String parent = "parent-995424086";
    OdbSubnet odbSubnet = OdbSubnet.newBuilder().build();
    String odbSubnetId = "odbSubnetId1186954661";

    OdbSubnet actualResponse = client.createOdbSubnetAsync(parent, odbSubnet, odbSubnetId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateOdbSubnetRequest actualRequest = ((CreateOdbSubnetRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(odbSubnet, actualRequest.getOdbSubnet());
    Assert.assertEquals(odbSubnetId, actualRequest.getOdbSubnetId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createOdbSubnetExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      String parent = "parent-995424086";
      OdbSubnet odbSubnet = OdbSubnet.newBuilder().build();
      String odbSubnetId = "odbSubnetId1186954661";
      client.createOdbSubnetAsync(parent, odbSubnet, odbSubnetId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteOdbSubnetTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteOdbSubnetTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockOracleDatabase.addResponse(resultOperation);

    OdbSubnetName name =
        OdbSubnetName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]", "[ODB_SUBNET]");

    client.deleteOdbSubnetAsync(name).get();

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteOdbSubnetRequest actualRequest = ((DeleteOdbSubnetRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteOdbSubnetExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      OdbSubnetName name =
          OdbSubnetName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]", "[ODB_SUBNET]");
      client.deleteOdbSubnetAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteOdbSubnetTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteOdbSubnetTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockOracleDatabase.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteOdbSubnetAsync(name).get();

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteOdbSubnetRequest actualRequest = ((DeleteOdbSubnetRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteOdbSubnetExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      String name = "name3373707";
      client.deleteOdbSubnetAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listExadbVmClustersTest() throws Exception {
    ExadbVmCluster responsesElement = ExadbVmCluster.newBuilder().build();
    ListExadbVmClustersResponse expectedResponse =
        ListExadbVmClustersResponse.newBuilder()
            .setNextPageToken("")
            .addAllExadbVmClusters(Arrays.asList(responsesElement))
            .build();
    mockOracleDatabase.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListExadbVmClustersPagedResponse pagedListResponse = client.listExadbVmClusters(parent);

    List<ExadbVmCluster> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getExadbVmClustersList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListExadbVmClustersRequest actualRequest = ((ListExadbVmClustersRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listExadbVmClustersExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listExadbVmClusters(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listExadbVmClustersTest2() throws Exception {
    ExadbVmCluster responsesElement = ExadbVmCluster.newBuilder().build();
    ListExadbVmClustersResponse expectedResponse =
        ListExadbVmClustersResponse.newBuilder()
            .setNextPageToken("")
            .addAllExadbVmClusters(Arrays.asList(responsesElement))
            .build();
    mockOracleDatabase.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListExadbVmClustersPagedResponse pagedListResponse = client.listExadbVmClusters(parent);

    List<ExadbVmCluster> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getExadbVmClustersList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListExadbVmClustersRequest actualRequest = ((ListExadbVmClustersRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listExadbVmClustersExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listExadbVmClusters(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getExadbVmClusterTest() throws Exception {
    ExadbVmCluster expectedResponse =
        ExadbVmCluster.newBuilder()
            .setName(
                ExadbVmClusterName.of("[PROJECT]", "[LOCATION]", "[EXADB_VM_CLUSTER]").toString())
            .setProperties(ExadbVmClusterProperties.newBuilder().build())
            .setGcpOracleZone("gcpOracleZone217860222")
            .putAllLabels(new HashMap<String, String>())
            .setOdbNetwork(OdbNetworkName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]").toString())
            .setOdbSubnet(
                OdbSubnetName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]", "[ODB_SUBNET]")
                    .toString())
            .setBackupOdbSubnet(
                OdbSubnetName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]", "[ODB_SUBNET]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setEntitlementId("entitlementId-1302274264")
            .build();
    mockOracleDatabase.addResponse(expectedResponse);

    ExadbVmClusterName name =
        ExadbVmClusterName.of("[PROJECT]", "[LOCATION]", "[EXADB_VM_CLUSTER]");

    ExadbVmCluster actualResponse = client.getExadbVmCluster(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetExadbVmClusterRequest actualRequest = ((GetExadbVmClusterRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getExadbVmClusterExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      ExadbVmClusterName name =
          ExadbVmClusterName.of("[PROJECT]", "[LOCATION]", "[EXADB_VM_CLUSTER]");
      client.getExadbVmCluster(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getExadbVmClusterTest2() throws Exception {
    ExadbVmCluster expectedResponse =
        ExadbVmCluster.newBuilder()
            .setName(
                ExadbVmClusterName.of("[PROJECT]", "[LOCATION]", "[EXADB_VM_CLUSTER]").toString())
            .setProperties(ExadbVmClusterProperties.newBuilder().build())
            .setGcpOracleZone("gcpOracleZone217860222")
            .putAllLabels(new HashMap<String, String>())
            .setOdbNetwork(OdbNetworkName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]").toString())
            .setOdbSubnet(
                OdbSubnetName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]", "[ODB_SUBNET]")
                    .toString())
            .setBackupOdbSubnet(
                OdbSubnetName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]", "[ODB_SUBNET]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setEntitlementId("entitlementId-1302274264")
            .build();
    mockOracleDatabase.addResponse(expectedResponse);

    String name = "name3373707";

    ExadbVmCluster actualResponse = client.getExadbVmCluster(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetExadbVmClusterRequest actualRequest = ((GetExadbVmClusterRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getExadbVmClusterExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      String name = "name3373707";
      client.getExadbVmCluster(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createExadbVmClusterTest() throws Exception {
    ExadbVmCluster expectedResponse =
        ExadbVmCluster.newBuilder()
            .setName(
                ExadbVmClusterName.of("[PROJECT]", "[LOCATION]", "[EXADB_VM_CLUSTER]").toString())
            .setProperties(ExadbVmClusterProperties.newBuilder().build())
            .setGcpOracleZone("gcpOracleZone217860222")
            .putAllLabels(new HashMap<String, String>())
            .setOdbNetwork(OdbNetworkName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]").toString())
            .setOdbSubnet(
                OdbSubnetName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]", "[ODB_SUBNET]")
                    .toString())
            .setBackupOdbSubnet(
                OdbSubnetName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]", "[ODB_SUBNET]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setEntitlementId("entitlementId-1302274264")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createExadbVmClusterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockOracleDatabase.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    ExadbVmCluster exadbVmCluster = ExadbVmCluster.newBuilder().build();
    String exadbVmClusterId = "exadbVmClusterId1890152722";

    ExadbVmCluster actualResponse =
        client.createExadbVmClusterAsync(parent, exadbVmCluster, exadbVmClusterId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateExadbVmClusterRequest actualRequest =
        ((CreateExadbVmClusterRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(exadbVmCluster, actualRequest.getExadbVmCluster());
    Assert.assertEquals(exadbVmClusterId, actualRequest.getExadbVmClusterId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createExadbVmClusterExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      ExadbVmCluster exadbVmCluster = ExadbVmCluster.newBuilder().build();
      String exadbVmClusterId = "exadbVmClusterId1890152722";
      client.createExadbVmClusterAsync(parent, exadbVmCluster, exadbVmClusterId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createExadbVmClusterTest2() throws Exception {
    ExadbVmCluster expectedResponse =
        ExadbVmCluster.newBuilder()
            .setName(
                ExadbVmClusterName.of("[PROJECT]", "[LOCATION]", "[EXADB_VM_CLUSTER]").toString())
            .setProperties(ExadbVmClusterProperties.newBuilder().build())
            .setGcpOracleZone("gcpOracleZone217860222")
            .putAllLabels(new HashMap<String, String>())
            .setOdbNetwork(OdbNetworkName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]").toString())
            .setOdbSubnet(
                OdbSubnetName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]", "[ODB_SUBNET]")
                    .toString())
            .setBackupOdbSubnet(
                OdbSubnetName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]", "[ODB_SUBNET]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setEntitlementId("entitlementId-1302274264")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createExadbVmClusterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockOracleDatabase.addResponse(resultOperation);

    String parent = "parent-995424086";
    ExadbVmCluster exadbVmCluster = ExadbVmCluster.newBuilder().build();
    String exadbVmClusterId = "exadbVmClusterId1890152722";

    ExadbVmCluster actualResponse =
        client.createExadbVmClusterAsync(parent, exadbVmCluster, exadbVmClusterId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateExadbVmClusterRequest actualRequest =
        ((CreateExadbVmClusterRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(exadbVmCluster, actualRequest.getExadbVmCluster());
    Assert.assertEquals(exadbVmClusterId, actualRequest.getExadbVmClusterId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createExadbVmClusterExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      String parent = "parent-995424086";
      ExadbVmCluster exadbVmCluster = ExadbVmCluster.newBuilder().build();
      String exadbVmClusterId = "exadbVmClusterId1890152722";
      client.createExadbVmClusterAsync(parent, exadbVmCluster, exadbVmClusterId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteExadbVmClusterTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteExadbVmClusterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockOracleDatabase.addResponse(resultOperation);

    ExadbVmClusterName name =
        ExadbVmClusterName.of("[PROJECT]", "[LOCATION]", "[EXADB_VM_CLUSTER]");

    client.deleteExadbVmClusterAsync(name).get();

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteExadbVmClusterRequest actualRequest =
        ((DeleteExadbVmClusterRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteExadbVmClusterExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      ExadbVmClusterName name =
          ExadbVmClusterName.of("[PROJECT]", "[LOCATION]", "[EXADB_VM_CLUSTER]");
      client.deleteExadbVmClusterAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteExadbVmClusterTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteExadbVmClusterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockOracleDatabase.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteExadbVmClusterAsync(name).get();

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteExadbVmClusterRequest actualRequest =
        ((DeleteExadbVmClusterRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteExadbVmClusterExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      String name = "name3373707";
      client.deleteExadbVmClusterAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateExadbVmClusterTest() throws Exception {
    ExadbVmCluster expectedResponse =
        ExadbVmCluster.newBuilder()
            .setName(
                ExadbVmClusterName.of("[PROJECT]", "[LOCATION]", "[EXADB_VM_CLUSTER]").toString())
            .setProperties(ExadbVmClusterProperties.newBuilder().build())
            .setGcpOracleZone("gcpOracleZone217860222")
            .putAllLabels(new HashMap<String, String>())
            .setOdbNetwork(OdbNetworkName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]").toString())
            .setOdbSubnet(
                OdbSubnetName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]", "[ODB_SUBNET]")
                    .toString())
            .setBackupOdbSubnet(
                OdbSubnetName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]", "[ODB_SUBNET]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setEntitlementId("entitlementId-1302274264")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateExadbVmClusterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockOracleDatabase.addResponse(resultOperation);

    ExadbVmCluster exadbVmCluster = ExadbVmCluster.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    ExadbVmCluster actualResponse =
        client.updateExadbVmClusterAsync(exadbVmCluster, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateExadbVmClusterRequest actualRequest =
        ((UpdateExadbVmClusterRequest) actualRequests.get(0));

    Assert.assertEquals(exadbVmCluster, actualRequest.getExadbVmCluster());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateExadbVmClusterExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      ExadbVmCluster exadbVmCluster = ExadbVmCluster.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateExadbVmClusterAsync(exadbVmCluster, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void removeVirtualMachineExadbVmClusterTest() throws Exception {
    ExadbVmCluster expectedResponse =
        ExadbVmCluster.newBuilder()
            .setName(
                ExadbVmClusterName.of("[PROJECT]", "[LOCATION]", "[EXADB_VM_CLUSTER]").toString())
            .setProperties(ExadbVmClusterProperties.newBuilder().build())
            .setGcpOracleZone("gcpOracleZone217860222")
            .putAllLabels(new HashMap<String, String>())
            .setOdbNetwork(OdbNetworkName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]").toString())
            .setOdbSubnet(
                OdbSubnetName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]", "[ODB_SUBNET]")
                    .toString())
            .setBackupOdbSubnet(
                OdbSubnetName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]", "[ODB_SUBNET]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setEntitlementId("entitlementId-1302274264")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("removeVirtualMachineExadbVmClusterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockOracleDatabase.addResponse(resultOperation);

    ExadbVmClusterName name =
        ExadbVmClusterName.of("[PROJECT]", "[LOCATION]", "[EXADB_VM_CLUSTER]");
    List<String> hostnames = new ArrayList<>();

    ExadbVmCluster actualResponse =
        client.removeVirtualMachineExadbVmClusterAsync(name, hostnames).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RemoveVirtualMachineExadbVmClusterRequest actualRequest =
        ((RemoveVirtualMachineExadbVmClusterRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(hostnames, actualRequest.getHostnamesList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void removeVirtualMachineExadbVmClusterExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      ExadbVmClusterName name =
          ExadbVmClusterName.of("[PROJECT]", "[LOCATION]", "[EXADB_VM_CLUSTER]");
      List<String> hostnames = new ArrayList<>();
      client.removeVirtualMachineExadbVmClusterAsync(name, hostnames).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void removeVirtualMachineExadbVmClusterTest2() throws Exception {
    ExadbVmCluster expectedResponse =
        ExadbVmCluster.newBuilder()
            .setName(
                ExadbVmClusterName.of("[PROJECT]", "[LOCATION]", "[EXADB_VM_CLUSTER]").toString())
            .setProperties(ExadbVmClusterProperties.newBuilder().build())
            .setGcpOracleZone("gcpOracleZone217860222")
            .putAllLabels(new HashMap<String, String>())
            .setOdbNetwork(OdbNetworkName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]").toString())
            .setOdbSubnet(
                OdbSubnetName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]", "[ODB_SUBNET]")
                    .toString())
            .setBackupOdbSubnet(
                OdbSubnetName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]", "[ODB_SUBNET]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setEntitlementId("entitlementId-1302274264")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("removeVirtualMachineExadbVmClusterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockOracleDatabase.addResponse(resultOperation);

    String name = "name3373707";
    List<String> hostnames = new ArrayList<>();

    ExadbVmCluster actualResponse =
        client.removeVirtualMachineExadbVmClusterAsync(name, hostnames).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RemoveVirtualMachineExadbVmClusterRequest actualRequest =
        ((RemoveVirtualMachineExadbVmClusterRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(hostnames, actualRequest.getHostnamesList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void removeVirtualMachineExadbVmClusterExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      String name = "name3373707";
      List<String> hostnames = new ArrayList<>();
      client.removeVirtualMachineExadbVmClusterAsync(name, hostnames).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listExascaleDbStorageVaultsTest() throws Exception {
    ExascaleDbStorageVault responsesElement = ExascaleDbStorageVault.newBuilder().build();
    ListExascaleDbStorageVaultsResponse expectedResponse =
        ListExascaleDbStorageVaultsResponse.newBuilder()
            .setNextPageToken("")
            .addAllExascaleDbStorageVaults(Arrays.asList(responsesElement))
            .build();
    mockOracleDatabase.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListExascaleDbStorageVaultsPagedResponse pagedListResponse =
        client.listExascaleDbStorageVaults(parent);

    List<ExascaleDbStorageVault> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getExascaleDbStorageVaultsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListExascaleDbStorageVaultsRequest actualRequest =
        ((ListExascaleDbStorageVaultsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listExascaleDbStorageVaultsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listExascaleDbStorageVaults(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listExascaleDbStorageVaultsTest2() throws Exception {
    ExascaleDbStorageVault responsesElement = ExascaleDbStorageVault.newBuilder().build();
    ListExascaleDbStorageVaultsResponse expectedResponse =
        ListExascaleDbStorageVaultsResponse.newBuilder()
            .setNextPageToken("")
            .addAllExascaleDbStorageVaults(Arrays.asList(responsesElement))
            .build();
    mockOracleDatabase.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListExascaleDbStorageVaultsPagedResponse pagedListResponse =
        client.listExascaleDbStorageVaults(parent);

    List<ExascaleDbStorageVault> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getExascaleDbStorageVaultsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListExascaleDbStorageVaultsRequest actualRequest =
        ((ListExascaleDbStorageVaultsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listExascaleDbStorageVaultsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listExascaleDbStorageVaults(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getExascaleDbStorageVaultTest() throws Exception {
    ExascaleDbStorageVault expectedResponse =
        ExascaleDbStorageVault.newBuilder()
            .setName(
                ExascaleDbStorageVaultName.of(
                        "[PROJECT]", "[LOCATION]", "[EXASCALE_DB_STORAGE_VAULT]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setGcpOracleZone("gcpOracleZone217860222")
            .setProperties(ExascaleDbStorageVaultProperties.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setEntitlementId("entitlementId-1302274264")
            .putAllLabels(new HashMap<String, String>())
            .build();
    mockOracleDatabase.addResponse(expectedResponse);

    ExascaleDbStorageVaultName name =
        ExascaleDbStorageVaultName.of("[PROJECT]", "[LOCATION]", "[EXASCALE_DB_STORAGE_VAULT]");

    ExascaleDbStorageVault actualResponse = client.getExascaleDbStorageVault(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetExascaleDbStorageVaultRequest actualRequest =
        ((GetExascaleDbStorageVaultRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getExascaleDbStorageVaultExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      ExascaleDbStorageVaultName name =
          ExascaleDbStorageVaultName.of("[PROJECT]", "[LOCATION]", "[EXASCALE_DB_STORAGE_VAULT]");
      client.getExascaleDbStorageVault(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getExascaleDbStorageVaultTest2() throws Exception {
    ExascaleDbStorageVault expectedResponse =
        ExascaleDbStorageVault.newBuilder()
            .setName(
                ExascaleDbStorageVaultName.of(
                        "[PROJECT]", "[LOCATION]", "[EXASCALE_DB_STORAGE_VAULT]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setGcpOracleZone("gcpOracleZone217860222")
            .setProperties(ExascaleDbStorageVaultProperties.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setEntitlementId("entitlementId-1302274264")
            .putAllLabels(new HashMap<String, String>())
            .build();
    mockOracleDatabase.addResponse(expectedResponse);

    String name = "name3373707";

    ExascaleDbStorageVault actualResponse = client.getExascaleDbStorageVault(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetExascaleDbStorageVaultRequest actualRequest =
        ((GetExascaleDbStorageVaultRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getExascaleDbStorageVaultExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      String name = "name3373707";
      client.getExascaleDbStorageVault(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createExascaleDbStorageVaultTest() throws Exception {
    ExascaleDbStorageVault expectedResponse =
        ExascaleDbStorageVault.newBuilder()
            .setName(
                ExascaleDbStorageVaultName.of(
                        "[PROJECT]", "[LOCATION]", "[EXASCALE_DB_STORAGE_VAULT]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setGcpOracleZone("gcpOracleZone217860222")
            .setProperties(ExascaleDbStorageVaultProperties.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setEntitlementId("entitlementId-1302274264")
            .putAllLabels(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createExascaleDbStorageVaultTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockOracleDatabase.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    ExascaleDbStorageVault exascaleDbStorageVault = ExascaleDbStorageVault.newBuilder().build();
    String exascaleDbStorageVaultId = "exascaleDbStorageVaultId-24370132";

    ExascaleDbStorageVault actualResponse =
        client
            .createExascaleDbStorageVaultAsync(
                parent, exascaleDbStorageVault, exascaleDbStorageVaultId)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateExascaleDbStorageVaultRequest actualRequest =
        ((CreateExascaleDbStorageVaultRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(exascaleDbStorageVault, actualRequest.getExascaleDbStorageVault());
    Assert.assertEquals(exascaleDbStorageVaultId, actualRequest.getExascaleDbStorageVaultId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createExascaleDbStorageVaultExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      ExascaleDbStorageVault exascaleDbStorageVault = ExascaleDbStorageVault.newBuilder().build();
      String exascaleDbStorageVaultId = "exascaleDbStorageVaultId-24370132";
      client
          .createExascaleDbStorageVaultAsync(
              parent, exascaleDbStorageVault, exascaleDbStorageVaultId)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createExascaleDbStorageVaultTest2() throws Exception {
    ExascaleDbStorageVault expectedResponse =
        ExascaleDbStorageVault.newBuilder()
            .setName(
                ExascaleDbStorageVaultName.of(
                        "[PROJECT]", "[LOCATION]", "[EXASCALE_DB_STORAGE_VAULT]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setGcpOracleZone("gcpOracleZone217860222")
            .setProperties(ExascaleDbStorageVaultProperties.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setEntitlementId("entitlementId-1302274264")
            .putAllLabels(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createExascaleDbStorageVaultTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockOracleDatabase.addResponse(resultOperation);

    String parent = "parent-995424086";
    ExascaleDbStorageVault exascaleDbStorageVault = ExascaleDbStorageVault.newBuilder().build();
    String exascaleDbStorageVaultId = "exascaleDbStorageVaultId-24370132";

    ExascaleDbStorageVault actualResponse =
        client
            .createExascaleDbStorageVaultAsync(
                parent, exascaleDbStorageVault, exascaleDbStorageVaultId)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateExascaleDbStorageVaultRequest actualRequest =
        ((CreateExascaleDbStorageVaultRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(exascaleDbStorageVault, actualRequest.getExascaleDbStorageVault());
    Assert.assertEquals(exascaleDbStorageVaultId, actualRequest.getExascaleDbStorageVaultId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createExascaleDbStorageVaultExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      String parent = "parent-995424086";
      ExascaleDbStorageVault exascaleDbStorageVault = ExascaleDbStorageVault.newBuilder().build();
      String exascaleDbStorageVaultId = "exascaleDbStorageVaultId-24370132";
      client
          .createExascaleDbStorageVaultAsync(
              parent, exascaleDbStorageVault, exascaleDbStorageVaultId)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteExascaleDbStorageVaultTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteExascaleDbStorageVaultTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockOracleDatabase.addResponse(resultOperation);

    ExascaleDbStorageVaultName name =
        ExascaleDbStorageVaultName.of("[PROJECT]", "[LOCATION]", "[EXASCALE_DB_STORAGE_VAULT]");

    client.deleteExascaleDbStorageVaultAsync(name).get();

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteExascaleDbStorageVaultRequest actualRequest =
        ((DeleteExascaleDbStorageVaultRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteExascaleDbStorageVaultExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      ExascaleDbStorageVaultName name =
          ExascaleDbStorageVaultName.of("[PROJECT]", "[LOCATION]", "[EXASCALE_DB_STORAGE_VAULT]");
      client.deleteExascaleDbStorageVaultAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteExascaleDbStorageVaultTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteExascaleDbStorageVaultTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockOracleDatabase.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteExascaleDbStorageVaultAsync(name).get();

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteExascaleDbStorageVaultRequest actualRequest =
        ((DeleteExascaleDbStorageVaultRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteExascaleDbStorageVaultExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      String name = "name3373707";
      client.deleteExascaleDbStorageVaultAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listDbSystemInitialStorageSizesTest() throws Exception {
    DbSystemInitialStorageSize responsesElement = DbSystemInitialStorageSize.newBuilder().build();
    ListDbSystemInitialStorageSizesResponse expectedResponse =
        ListDbSystemInitialStorageSizesResponse.newBuilder()
            .setNextPageToken("")
            .addAllDbSystemInitialStorageSizes(Arrays.asList(responsesElement))
            .build();
    mockOracleDatabase.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListDbSystemInitialStorageSizesPagedResponse pagedListResponse =
        client.listDbSystemInitialStorageSizes(parent);

    List<DbSystemInitialStorageSize> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getDbSystemInitialStorageSizesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDbSystemInitialStorageSizesRequest actualRequest =
        ((ListDbSystemInitialStorageSizesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDbSystemInitialStorageSizesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listDbSystemInitialStorageSizes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDbSystemInitialStorageSizesTest2() throws Exception {
    DbSystemInitialStorageSize responsesElement = DbSystemInitialStorageSize.newBuilder().build();
    ListDbSystemInitialStorageSizesResponse expectedResponse =
        ListDbSystemInitialStorageSizesResponse.newBuilder()
            .setNextPageToken("")
            .addAllDbSystemInitialStorageSizes(Arrays.asList(responsesElement))
            .build();
    mockOracleDatabase.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListDbSystemInitialStorageSizesPagedResponse pagedListResponse =
        client.listDbSystemInitialStorageSizes(parent);

    List<DbSystemInitialStorageSize> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getDbSystemInitialStorageSizesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDbSystemInitialStorageSizesRequest actualRequest =
        ((ListDbSystemInitialStorageSizesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDbSystemInitialStorageSizesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listDbSystemInitialStorageSizes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDatabasesTest() throws Exception {
    Database responsesElement = Database.newBuilder().build();
    ListDatabasesResponse expectedResponse =
        ListDatabasesResponse.newBuilder()
            .setNextPageToken("")
            .addAllDatabases(Arrays.asList(responsesElement))
            .build();
    mockOracleDatabase.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListDatabasesPagedResponse pagedListResponse = client.listDatabases(parent);

    List<Database> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDatabasesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDatabasesRequest actualRequest = ((ListDatabasesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDatabasesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listDatabases(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDatabasesTest2() throws Exception {
    Database responsesElement = Database.newBuilder().build();
    ListDatabasesResponse expectedResponse =
        ListDatabasesResponse.newBuilder()
            .setNextPageToken("")
            .addAllDatabases(Arrays.asList(responsesElement))
            .build();
    mockOracleDatabase.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListDatabasesPagedResponse pagedListResponse = client.listDatabases(parent);

    List<Database> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDatabasesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDatabasesRequest actualRequest = ((ListDatabasesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDatabasesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listDatabases(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDatabaseTest() throws Exception {
    Database expectedResponse =
        Database.newBuilder()
            .setName(DatabaseName.of("[PROJECT]", "[LOCATION]", "[DATABASE]").toString())
            .setDbName("dbName-1339126743")
            .setDbUniqueName("dbUniqueName-1793979110")
            .setAdminPassword("adminPassword-95067382")
            .setTdeWalletPassword("tdeWalletPassword727082249")
            .setCharacterSet("characterSet-1443214215")
            .setNcharacterSet("ncharacterSet642193383")
            .setOciUrl("ociUrl-1022489574")
            .setCreateTime(Timestamp.newBuilder().build())
            .setProperties(DatabaseProperties.newBuilder().build())
            .setDatabaseId("databaseId1688905718")
            .setDbHomeName("dbHomeName364867240")
            .setGcpOracleZone("gcpOracleZone217860222")
            .build();
    mockOracleDatabase.addResponse(expectedResponse);

    DatabaseName name = DatabaseName.of("[PROJECT]", "[LOCATION]", "[DATABASE]");

    Database actualResponse = client.getDatabase(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDatabaseRequest actualRequest = ((GetDatabaseRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDatabaseExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      DatabaseName name = DatabaseName.of("[PROJECT]", "[LOCATION]", "[DATABASE]");
      client.getDatabase(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDatabaseTest2() throws Exception {
    Database expectedResponse =
        Database.newBuilder()
            .setName(DatabaseName.of("[PROJECT]", "[LOCATION]", "[DATABASE]").toString())
            .setDbName("dbName-1339126743")
            .setDbUniqueName("dbUniqueName-1793979110")
            .setAdminPassword("adminPassword-95067382")
            .setTdeWalletPassword("tdeWalletPassword727082249")
            .setCharacterSet("characterSet-1443214215")
            .setNcharacterSet("ncharacterSet642193383")
            .setOciUrl("ociUrl-1022489574")
            .setCreateTime(Timestamp.newBuilder().build())
            .setProperties(DatabaseProperties.newBuilder().build())
            .setDatabaseId("databaseId1688905718")
            .setDbHomeName("dbHomeName364867240")
            .setGcpOracleZone("gcpOracleZone217860222")
            .build();
    mockOracleDatabase.addResponse(expectedResponse);

    String name = "name3373707";

    Database actualResponse = client.getDatabase(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDatabaseRequest actualRequest = ((GetDatabaseRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDatabaseExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      String name = "name3373707";
      client.getDatabase(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listPluggableDatabasesTest() throws Exception {
    PluggableDatabase responsesElement = PluggableDatabase.newBuilder().build();
    ListPluggableDatabasesResponse expectedResponse =
        ListPluggableDatabasesResponse.newBuilder()
            .setNextPageToken("")
            .addAllPluggableDatabases(Arrays.asList(responsesElement))
            .build();
    mockOracleDatabase.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListPluggableDatabasesPagedResponse pagedListResponse = client.listPluggableDatabases(parent);

    List<PluggableDatabase> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPluggableDatabasesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListPluggableDatabasesRequest actualRequest =
        ((ListPluggableDatabasesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listPluggableDatabasesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listPluggableDatabases(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listPluggableDatabasesTest2() throws Exception {
    PluggableDatabase responsesElement = PluggableDatabase.newBuilder().build();
    ListPluggableDatabasesResponse expectedResponse =
        ListPluggableDatabasesResponse.newBuilder()
            .setNextPageToken("")
            .addAllPluggableDatabases(Arrays.asList(responsesElement))
            .build();
    mockOracleDatabase.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListPluggableDatabasesPagedResponse pagedListResponse = client.listPluggableDatabases(parent);

    List<PluggableDatabase> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPluggableDatabasesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListPluggableDatabasesRequest actualRequest =
        ((ListPluggableDatabasesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listPluggableDatabasesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listPluggableDatabases(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getPluggableDatabaseTest() throws Exception {
    PluggableDatabase expectedResponse =
        PluggableDatabase.newBuilder()
            .setName(
                PluggableDatabaseName.of("[PROJECT]", "[LOCATION]", "[PLUGGABLE_DATABASE]")
                    .toString())
            .setProperties(PluggableDatabaseProperties.newBuilder().build())
            .setOciUrl("ociUrl-1022489574")
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    mockOracleDatabase.addResponse(expectedResponse);

    PluggableDatabaseName name =
        PluggableDatabaseName.of("[PROJECT]", "[LOCATION]", "[PLUGGABLE_DATABASE]");

    PluggableDatabase actualResponse = client.getPluggableDatabase(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetPluggableDatabaseRequest actualRequest =
        ((GetPluggableDatabaseRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getPluggableDatabaseExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      PluggableDatabaseName name =
          PluggableDatabaseName.of("[PROJECT]", "[LOCATION]", "[PLUGGABLE_DATABASE]");
      client.getPluggableDatabase(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getPluggableDatabaseTest2() throws Exception {
    PluggableDatabase expectedResponse =
        PluggableDatabase.newBuilder()
            .setName(
                PluggableDatabaseName.of("[PROJECT]", "[LOCATION]", "[PLUGGABLE_DATABASE]")
                    .toString())
            .setProperties(PluggableDatabaseProperties.newBuilder().build())
            .setOciUrl("ociUrl-1022489574")
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    mockOracleDatabase.addResponse(expectedResponse);

    String name = "name3373707";

    PluggableDatabase actualResponse = client.getPluggableDatabase(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetPluggableDatabaseRequest actualRequest =
        ((GetPluggableDatabaseRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getPluggableDatabaseExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      String name = "name3373707";
      client.getPluggableDatabase(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDbSystemsTest() throws Exception {
    DbSystem responsesElement = DbSystem.newBuilder().build();
    ListDbSystemsResponse expectedResponse =
        ListDbSystemsResponse.newBuilder()
            .setNextPageToken("")
            .addAllDbSystems(Arrays.asList(responsesElement))
            .build();
    mockOracleDatabase.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListDbSystemsPagedResponse pagedListResponse = client.listDbSystems(parent);

    List<DbSystem> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDbSystemsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDbSystemsRequest actualRequest = ((ListDbSystemsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDbSystemsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listDbSystems(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDbSystemsTest2() throws Exception {
    DbSystem responsesElement = DbSystem.newBuilder().build();
    ListDbSystemsResponse expectedResponse =
        ListDbSystemsResponse.newBuilder()
            .setNextPageToken("")
            .addAllDbSystems(Arrays.asList(responsesElement))
            .build();
    mockOracleDatabase.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListDbSystemsPagedResponse pagedListResponse = client.listDbSystems(parent);

    List<DbSystem> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDbSystemsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDbSystemsRequest actualRequest = ((ListDbSystemsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDbSystemsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listDbSystems(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDbSystemTest() throws Exception {
    DbSystem expectedResponse =
        DbSystem.newBuilder()
            .setName(DbSystemName.of("[PROJECT]", "[LOCATION]", "[DB_SYSTEM]").toString())
            .setProperties(DbSystemProperties.newBuilder().build())
            .setGcpOracleZone("gcpOracleZone217860222")
            .putAllLabels(new HashMap<String, String>())
            .setOdbNetwork(OdbNetworkName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]").toString())
            .setOdbSubnet(
                OdbSubnetName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]", "[ODB_SUBNET]")
                    .toString())
            .setEntitlementId("entitlementId-1302274264")
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setOciUrl("ociUrl-1022489574")
            .build();
    mockOracleDatabase.addResponse(expectedResponse);

    DbSystemName name = DbSystemName.of("[PROJECT]", "[LOCATION]", "[DB_SYSTEM]");

    DbSystem actualResponse = client.getDbSystem(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDbSystemRequest actualRequest = ((GetDbSystemRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDbSystemExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      DbSystemName name = DbSystemName.of("[PROJECT]", "[LOCATION]", "[DB_SYSTEM]");
      client.getDbSystem(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDbSystemTest2() throws Exception {
    DbSystem expectedResponse =
        DbSystem.newBuilder()
            .setName(DbSystemName.of("[PROJECT]", "[LOCATION]", "[DB_SYSTEM]").toString())
            .setProperties(DbSystemProperties.newBuilder().build())
            .setGcpOracleZone("gcpOracleZone217860222")
            .putAllLabels(new HashMap<String, String>())
            .setOdbNetwork(OdbNetworkName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]").toString())
            .setOdbSubnet(
                OdbSubnetName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]", "[ODB_SUBNET]")
                    .toString())
            .setEntitlementId("entitlementId-1302274264")
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setOciUrl("ociUrl-1022489574")
            .build();
    mockOracleDatabase.addResponse(expectedResponse);

    String name = "name3373707";

    DbSystem actualResponse = client.getDbSystem(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDbSystemRequest actualRequest = ((GetDbSystemRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDbSystemExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      String name = "name3373707";
      client.getDbSystem(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createDbSystemTest() throws Exception {
    DbSystem expectedResponse =
        DbSystem.newBuilder()
            .setName(DbSystemName.of("[PROJECT]", "[LOCATION]", "[DB_SYSTEM]").toString())
            .setProperties(DbSystemProperties.newBuilder().build())
            .setGcpOracleZone("gcpOracleZone217860222")
            .putAllLabels(new HashMap<String, String>())
            .setOdbNetwork(OdbNetworkName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]").toString())
            .setOdbSubnet(
                OdbSubnetName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]", "[ODB_SUBNET]")
                    .toString())
            .setEntitlementId("entitlementId-1302274264")
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setOciUrl("ociUrl-1022489574")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createDbSystemTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockOracleDatabase.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    DbSystem dbSystem = DbSystem.newBuilder().build();
    String dbSystemId = "dbSystemId-1467630008";

    DbSystem actualResponse = client.createDbSystemAsync(parent, dbSystem, dbSystemId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateDbSystemRequest actualRequest = ((CreateDbSystemRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(dbSystem, actualRequest.getDbSystem());
    Assert.assertEquals(dbSystemId, actualRequest.getDbSystemId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createDbSystemExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      DbSystem dbSystem = DbSystem.newBuilder().build();
      String dbSystemId = "dbSystemId-1467630008";
      client.createDbSystemAsync(parent, dbSystem, dbSystemId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createDbSystemTest2() throws Exception {
    DbSystem expectedResponse =
        DbSystem.newBuilder()
            .setName(DbSystemName.of("[PROJECT]", "[LOCATION]", "[DB_SYSTEM]").toString())
            .setProperties(DbSystemProperties.newBuilder().build())
            .setGcpOracleZone("gcpOracleZone217860222")
            .putAllLabels(new HashMap<String, String>())
            .setOdbNetwork(OdbNetworkName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]").toString())
            .setOdbSubnet(
                OdbSubnetName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]", "[ODB_SUBNET]")
                    .toString())
            .setEntitlementId("entitlementId-1302274264")
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setOciUrl("ociUrl-1022489574")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createDbSystemTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockOracleDatabase.addResponse(resultOperation);

    String parent = "parent-995424086";
    DbSystem dbSystem = DbSystem.newBuilder().build();
    String dbSystemId = "dbSystemId-1467630008";

    DbSystem actualResponse = client.createDbSystemAsync(parent, dbSystem, dbSystemId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateDbSystemRequest actualRequest = ((CreateDbSystemRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(dbSystem, actualRequest.getDbSystem());
    Assert.assertEquals(dbSystemId, actualRequest.getDbSystemId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createDbSystemExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      String parent = "parent-995424086";
      DbSystem dbSystem = DbSystem.newBuilder().build();
      String dbSystemId = "dbSystemId-1467630008";
      client.createDbSystemAsync(parent, dbSystem, dbSystemId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteDbSystemTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteDbSystemTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockOracleDatabase.addResponse(resultOperation);

    DbSystemName name = DbSystemName.of("[PROJECT]", "[LOCATION]", "[DB_SYSTEM]");

    client.deleteDbSystemAsync(name).get();

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteDbSystemRequest actualRequest = ((DeleteDbSystemRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteDbSystemExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      DbSystemName name = DbSystemName.of("[PROJECT]", "[LOCATION]", "[DB_SYSTEM]");
      client.deleteDbSystemAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteDbSystemTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteDbSystemTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockOracleDatabase.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteDbSystemAsync(name).get();

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteDbSystemRequest actualRequest = ((DeleteDbSystemRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteDbSystemExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      String name = "name3373707";
      client.deleteDbSystemAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listDbVersionsTest() throws Exception {
    DbVersion responsesElement = DbVersion.newBuilder().build();
    ListDbVersionsResponse expectedResponse =
        ListDbVersionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllDbVersions(Arrays.asList(responsesElement))
            .build();
    mockOracleDatabase.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListDbVersionsPagedResponse pagedListResponse = client.listDbVersions(parent);

    List<DbVersion> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDbVersionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDbVersionsRequest actualRequest = ((ListDbVersionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDbVersionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listDbVersions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDbVersionsTest2() throws Exception {
    DbVersion responsesElement = DbVersion.newBuilder().build();
    ListDbVersionsResponse expectedResponse =
        ListDbVersionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllDbVersions(Arrays.asList(responsesElement))
            .build();
    mockOracleDatabase.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListDbVersionsPagedResponse pagedListResponse = client.listDbVersions(parent);

    List<DbVersion> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDbVersionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDbVersionsRequest actualRequest = ((ListDbVersionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDbVersionsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listDbVersions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDatabaseCharacterSetsTest() throws Exception {
    DatabaseCharacterSet responsesElement = DatabaseCharacterSet.newBuilder().build();
    ListDatabaseCharacterSetsResponse expectedResponse =
        ListDatabaseCharacterSetsResponse.newBuilder()
            .setNextPageToken("")
            .addAllDatabaseCharacterSets(Arrays.asList(responsesElement))
            .build();
    mockOracleDatabase.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListDatabaseCharacterSetsPagedResponse pagedListResponse =
        client.listDatabaseCharacterSets(parent);

    List<DatabaseCharacterSet> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDatabaseCharacterSetsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDatabaseCharacterSetsRequest actualRequest =
        ((ListDatabaseCharacterSetsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDatabaseCharacterSetsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listDatabaseCharacterSets(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDatabaseCharacterSetsTest2() throws Exception {
    DatabaseCharacterSet responsesElement = DatabaseCharacterSet.newBuilder().build();
    ListDatabaseCharacterSetsResponse expectedResponse =
        ListDatabaseCharacterSetsResponse.newBuilder()
            .setNextPageToken("")
            .addAllDatabaseCharacterSets(Arrays.asList(responsesElement))
            .build();
    mockOracleDatabase.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListDatabaseCharacterSetsPagedResponse pagedListResponse =
        client.listDatabaseCharacterSets(parent);

    List<DatabaseCharacterSet> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDatabaseCharacterSetsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockOracleDatabase.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDatabaseCharacterSetsRequest actualRequest =
        ((ListDatabaseCharacterSetsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDatabaseCharacterSetsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOracleDatabase.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listDatabaseCharacterSets(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listLocationsTest() throws Exception {
    Location responsesElement = Location.newBuilder().build();
    ListLocationsResponse expectedResponse =
        ListLocationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllLocations(Arrays.asList(responsesElement))
            .build();
    mockLocations.addResponse(expectedResponse);

    ListLocationsRequest request =
        ListLocationsRequest.newBuilder()
            .setName("name3373707")
            .setFilter("filter-1274492040")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    ListLocationsPagedResponse pagedListResponse = client.listLocations(request);

    List<Location> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLocationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockLocations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListLocationsRequest actualRequest = ((ListLocationsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getFilter(), actualRequest.getFilter());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listLocationsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLocations.addException(exception);

    try {
      ListLocationsRequest request =
          ListLocationsRequest.newBuilder()
              .setName("name3373707")
              .setFilter("filter-1274492040")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      client.listLocations(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getLocationTest() throws Exception {
    Location expectedResponse =
        Location.newBuilder()
            .setName("name3373707")
            .setLocationId("locationId1541836720")
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setMetadata(Any.newBuilder().build())
            .build();
    mockLocations.addResponse(expectedResponse);

    GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();

    Location actualResponse = client.getLocation(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLocations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetLocationRequest actualRequest = ((GetLocationRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getLocationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLocations.addException(exception);

    try {
      GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
      client.getLocation(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
