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

package com.google.cloud.chronicle.v1;

import static com.google.cloud.chronicle.v1.EntityServiceClient.ListWatchlistsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.common.collect.Lists;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class EntityServiceClientTest {
  private static MockEntityService mockEntityService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private EntityServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockEntityService = new MockEntityService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockEntityService));
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
    EntityServiceSettings settings =
        EntityServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = EntityServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void getWatchlistTest() throws Exception {
    Watchlist expectedResponse =
        Watchlist.newBuilder()
            .setName(
                WatchlistName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[WATCHLIST]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setMultiplyingFactor(355362160)
            .setEntityPopulationMechanism(Watchlist.EntityPopulationMechanism.newBuilder().build())
            .setEntityCount(Watchlist.EntityCount.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setWatchlistUserPreferences(WatchlistUserPreferences.newBuilder().build())
            .build();
    mockEntityService.addResponse(expectedResponse);

    WatchlistName name = WatchlistName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[WATCHLIST]");

    Watchlist actualResponse = client.getWatchlist(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEntityService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetWatchlistRequest actualRequest = ((GetWatchlistRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getWatchlistExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEntityService.addException(exception);

    try {
      WatchlistName name = WatchlistName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[WATCHLIST]");
      client.getWatchlist(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getWatchlistTest2() throws Exception {
    Watchlist expectedResponse =
        Watchlist.newBuilder()
            .setName(
                WatchlistName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[WATCHLIST]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setMultiplyingFactor(355362160)
            .setEntityPopulationMechanism(Watchlist.EntityPopulationMechanism.newBuilder().build())
            .setEntityCount(Watchlist.EntityCount.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setWatchlistUserPreferences(WatchlistUserPreferences.newBuilder().build())
            .build();
    mockEntityService.addResponse(expectedResponse);

    String name = "name3373707";

    Watchlist actualResponse = client.getWatchlist(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEntityService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetWatchlistRequest actualRequest = ((GetWatchlistRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getWatchlistExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEntityService.addException(exception);

    try {
      String name = "name3373707";
      client.getWatchlist(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listWatchlistsTest() throws Exception {
    Watchlist responsesElement = Watchlist.newBuilder().build();
    ListWatchlistsResponse expectedResponse =
        ListWatchlistsResponse.newBuilder()
            .setNextPageToken("")
            .addAllWatchlists(Arrays.asList(responsesElement))
            .build();
    mockEntityService.addResponse(expectedResponse);

    InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");

    ListWatchlistsPagedResponse pagedListResponse = client.listWatchlists(parent);

    List<Watchlist> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getWatchlistsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockEntityService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListWatchlistsRequest actualRequest = ((ListWatchlistsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listWatchlistsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEntityService.addException(exception);

    try {
      InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      client.listWatchlists(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listWatchlistsTest2() throws Exception {
    Watchlist responsesElement = Watchlist.newBuilder().build();
    ListWatchlistsResponse expectedResponse =
        ListWatchlistsResponse.newBuilder()
            .setNextPageToken("")
            .addAllWatchlists(Arrays.asList(responsesElement))
            .build();
    mockEntityService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListWatchlistsPagedResponse pagedListResponse = client.listWatchlists(parent);

    List<Watchlist> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getWatchlistsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockEntityService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListWatchlistsRequest actualRequest = ((ListWatchlistsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listWatchlistsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEntityService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listWatchlists(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createWatchlistTest() throws Exception {
    Watchlist expectedResponse =
        Watchlist.newBuilder()
            .setName(
                WatchlistName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[WATCHLIST]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setMultiplyingFactor(355362160)
            .setEntityPopulationMechanism(Watchlist.EntityPopulationMechanism.newBuilder().build())
            .setEntityCount(Watchlist.EntityCount.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setWatchlistUserPreferences(WatchlistUserPreferences.newBuilder().build())
            .build();
    mockEntityService.addResponse(expectedResponse);

    InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
    Watchlist watchlist = Watchlist.newBuilder().build();
    String watchlistId = "watchlistId1560983528";

    Watchlist actualResponse = client.createWatchlist(parent, watchlist, watchlistId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEntityService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateWatchlistRequest actualRequest = ((CreateWatchlistRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(watchlist, actualRequest.getWatchlist());
    Assert.assertEquals(watchlistId, actualRequest.getWatchlistId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createWatchlistExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEntityService.addException(exception);

    try {
      InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      Watchlist watchlist = Watchlist.newBuilder().build();
      String watchlistId = "watchlistId1560983528";
      client.createWatchlist(parent, watchlist, watchlistId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createWatchlistTest2() throws Exception {
    Watchlist expectedResponse =
        Watchlist.newBuilder()
            .setName(
                WatchlistName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[WATCHLIST]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setMultiplyingFactor(355362160)
            .setEntityPopulationMechanism(Watchlist.EntityPopulationMechanism.newBuilder().build())
            .setEntityCount(Watchlist.EntityCount.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setWatchlistUserPreferences(WatchlistUserPreferences.newBuilder().build())
            .build();
    mockEntityService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Watchlist watchlist = Watchlist.newBuilder().build();
    String watchlistId = "watchlistId1560983528";

    Watchlist actualResponse = client.createWatchlist(parent, watchlist, watchlistId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEntityService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateWatchlistRequest actualRequest = ((CreateWatchlistRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(watchlist, actualRequest.getWatchlist());
    Assert.assertEquals(watchlistId, actualRequest.getWatchlistId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createWatchlistExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEntityService.addException(exception);

    try {
      String parent = "parent-995424086";
      Watchlist watchlist = Watchlist.newBuilder().build();
      String watchlistId = "watchlistId1560983528";
      client.createWatchlist(parent, watchlist, watchlistId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateWatchlistTest() throws Exception {
    Watchlist expectedResponse =
        Watchlist.newBuilder()
            .setName(
                WatchlistName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[WATCHLIST]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setMultiplyingFactor(355362160)
            .setEntityPopulationMechanism(Watchlist.EntityPopulationMechanism.newBuilder().build())
            .setEntityCount(Watchlist.EntityCount.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setWatchlistUserPreferences(WatchlistUserPreferences.newBuilder().build())
            .build();
    mockEntityService.addResponse(expectedResponse);

    Watchlist watchlist = Watchlist.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Watchlist actualResponse = client.updateWatchlist(watchlist, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEntityService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateWatchlistRequest actualRequest = ((UpdateWatchlistRequest) actualRequests.get(0));

    Assert.assertEquals(watchlist, actualRequest.getWatchlist());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateWatchlistExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEntityService.addException(exception);

    try {
      Watchlist watchlist = Watchlist.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateWatchlist(watchlist, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteWatchlistTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockEntityService.addResponse(expectedResponse);

    WatchlistName name = WatchlistName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[WATCHLIST]");
    boolean force = true;

    client.deleteWatchlist(name, force);

    List<AbstractMessage> actualRequests = mockEntityService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteWatchlistRequest actualRequest = ((DeleteWatchlistRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(force, actualRequest.getForce());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteWatchlistExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEntityService.addException(exception);

    try {
      WatchlistName name = WatchlistName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[WATCHLIST]");
      boolean force = true;
      client.deleteWatchlist(name, force);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteWatchlistTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockEntityService.addResponse(expectedResponse);

    String name = "name3373707";
    boolean force = true;

    client.deleteWatchlist(name, force);

    List<AbstractMessage> actualRequests = mockEntityService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteWatchlistRequest actualRequest = ((DeleteWatchlistRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(force, actualRequest.getForce());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteWatchlistExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEntityService.addException(exception);

    try {
      String name = "name3373707";
      boolean force = true;
      client.deleteWatchlist(name, force);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
