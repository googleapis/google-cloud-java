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

package com.google.cloud.alloydb.v1;

import static com.google.cloud.alloydb.v1.AlloyDBCSQLAdminClient.ListLocationsPagedResponse;

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
import com.google.protobuf.Timestamp;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
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
public class AlloyDBCSQLAdminClientTest {
  private static MockAlloyDBCSQLAdmin mockAlloyDBCSQLAdmin;
  private static MockIAMPolicy mockIAMPolicy;
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private AlloyDBCSQLAdminClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockAlloyDBCSQLAdmin = new MockAlloyDBCSQLAdmin();
    mockLocations = new MockLocations();
    mockIAMPolicy = new MockIAMPolicy();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockAlloyDBCSQLAdmin, mockLocations, mockIAMPolicy));
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
    AlloyDBCSQLAdminSettings settings =
        AlloyDBCSQLAdminSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = AlloyDBCSQLAdminClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void restoreFromCloudSQLTest() throws Exception {
    Cluster expectedResponse =
        Cluster.newBuilder()
            .setName(ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString())
            .setDisplayName("displayName1714148973")
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDatabaseVersion(DatabaseVersion.forNumber(0))
            .setNetworkConfig(Cluster.NetworkConfig.newBuilder().build())
            .setNetwork("network1843485230")
            .setEtag("etag3123477")
            .putAllAnnotations(new HashMap<String, String>())
            .setReconciling(true)
            .setInitialUser(UserPassword.newBuilder().build())
            .setAutomatedBackupPolicy(AutomatedBackupPolicy.newBuilder().build())
            .setSslConfig(SslConfig.newBuilder().build())
            .setEncryptionConfig(EncryptionConfig.newBuilder().build())
            .setEncryptionInfo(EncryptionInfo.newBuilder().build())
            .setContinuousBackupConfig(ContinuousBackupConfig.newBuilder().build())
            .setContinuousBackupInfo(ContinuousBackupInfo.newBuilder().build())
            .setSecondaryConfig(Cluster.SecondaryConfig.newBuilder().build())
            .setPrimaryConfig(Cluster.PrimaryConfig.newBuilder().build())
            .setSatisfiesPzs(true)
            .setPscConfig(Cluster.PscConfig.newBuilder().build())
            .setMaintenanceUpdatePolicy(MaintenanceUpdatePolicy.newBuilder().build())
            .setMaintenanceSchedule(MaintenanceSchedule.newBuilder().build())
            .setSubscriptionType(SubscriptionType.forNumber(0))
            .setTrialMetadata(Cluster.TrialMetadata.newBuilder().build())
            .putAllTags(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("restoreFromCloudSQLTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAlloyDBCSQLAdmin.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    String clusterId = "clusterId561939637";

    Cluster actualResponse = client.restoreFromCloudSQLAsync(parent, clusterId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAlloyDBCSQLAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RestoreFromCloudSQLRequest actualRequest = ((RestoreFromCloudSQLRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(clusterId, actualRequest.getClusterId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void restoreFromCloudSQLExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAlloyDBCSQLAdmin.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      String clusterId = "clusterId561939637";
      client.restoreFromCloudSQLAsync(parent, clusterId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void restoreFromCloudSQLTest2() throws Exception {
    Cluster expectedResponse =
        Cluster.newBuilder()
            .setName(ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString())
            .setDisplayName("displayName1714148973")
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDatabaseVersion(DatabaseVersion.forNumber(0))
            .setNetworkConfig(Cluster.NetworkConfig.newBuilder().build())
            .setNetwork("network1843485230")
            .setEtag("etag3123477")
            .putAllAnnotations(new HashMap<String, String>())
            .setReconciling(true)
            .setInitialUser(UserPassword.newBuilder().build())
            .setAutomatedBackupPolicy(AutomatedBackupPolicy.newBuilder().build())
            .setSslConfig(SslConfig.newBuilder().build())
            .setEncryptionConfig(EncryptionConfig.newBuilder().build())
            .setEncryptionInfo(EncryptionInfo.newBuilder().build())
            .setContinuousBackupConfig(ContinuousBackupConfig.newBuilder().build())
            .setContinuousBackupInfo(ContinuousBackupInfo.newBuilder().build())
            .setSecondaryConfig(Cluster.SecondaryConfig.newBuilder().build())
            .setPrimaryConfig(Cluster.PrimaryConfig.newBuilder().build())
            .setSatisfiesPzs(true)
            .setPscConfig(Cluster.PscConfig.newBuilder().build())
            .setMaintenanceUpdatePolicy(MaintenanceUpdatePolicy.newBuilder().build())
            .setMaintenanceSchedule(MaintenanceSchedule.newBuilder().build())
            .setSubscriptionType(SubscriptionType.forNumber(0))
            .setTrialMetadata(Cluster.TrialMetadata.newBuilder().build())
            .putAllTags(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("restoreFromCloudSQLTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAlloyDBCSQLAdmin.addResponse(resultOperation);

    String parent = "parent-995424086";
    String clusterId = "clusterId561939637";

    Cluster actualResponse = client.restoreFromCloudSQLAsync(parent, clusterId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAlloyDBCSQLAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RestoreFromCloudSQLRequest actualRequest = ((RestoreFromCloudSQLRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(clusterId, actualRequest.getClusterId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void restoreFromCloudSQLExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAlloyDBCSQLAdmin.addException(exception);

    try {
      String parent = "parent-995424086";
      String clusterId = "clusterId561939637";
      client.restoreFromCloudSQLAsync(parent, clusterId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
