/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.apihub.v1;

import static com.google.cloud.apihub.v1.ApiHubPluginClient.ListLocationsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.Lists;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
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
public class ApiHubPluginClientTest {
  private static MockApiHubPlugin mockApiHubPlugin;
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private ApiHubPluginClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockApiHubPlugin = new MockApiHubPlugin();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockApiHubPlugin, mockLocations));
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
    ApiHubPluginSettings settings =
        ApiHubPluginSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ApiHubPluginClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void getPluginTest() throws Exception {
    Plugin expectedResponse =
        Plugin.newBuilder()
            .setName(PluginName.of("[PROJECT]", "[LOCATION]", "[PLUGIN]").toString())
            .setDisplayName("displayName1714148973")
            .setType(AttributeValues.newBuilder().build())
            .setDescription("description-1724546052")
            .build();
    mockApiHubPlugin.addResponse(expectedResponse);

    PluginName name = PluginName.of("[PROJECT]", "[LOCATION]", "[PLUGIN]");

    Plugin actualResponse = client.getPlugin(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockApiHubPlugin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetPluginRequest actualRequest = ((GetPluginRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getPluginExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockApiHubPlugin.addException(exception);

    try {
      PluginName name = PluginName.of("[PROJECT]", "[LOCATION]", "[PLUGIN]");
      client.getPlugin(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getPluginTest2() throws Exception {
    Plugin expectedResponse =
        Plugin.newBuilder()
            .setName(PluginName.of("[PROJECT]", "[LOCATION]", "[PLUGIN]").toString())
            .setDisplayName("displayName1714148973")
            .setType(AttributeValues.newBuilder().build())
            .setDescription("description-1724546052")
            .build();
    mockApiHubPlugin.addResponse(expectedResponse);

    String name = "name3373707";

    Plugin actualResponse = client.getPlugin(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockApiHubPlugin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetPluginRequest actualRequest = ((GetPluginRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getPluginExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockApiHubPlugin.addException(exception);

    try {
      String name = "name3373707";
      client.getPlugin(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void enablePluginTest() throws Exception {
    Plugin expectedResponse =
        Plugin.newBuilder()
            .setName(PluginName.of("[PROJECT]", "[LOCATION]", "[PLUGIN]").toString())
            .setDisplayName("displayName1714148973")
            .setType(AttributeValues.newBuilder().build())
            .setDescription("description-1724546052")
            .build();
    mockApiHubPlugin.addResponse(expectedResponse);

    PluginName name = PluginName.of("[PROJECT]", "[LOCATION]", "[PLUGIN]");

    Plugin actualResponse = client.enablePlugin(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockApiHubPlugin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    EnablePluginRequest actualRequest = ((EnablePluginRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void enablePluginExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockApiHubPlugin.addException(exception);

    try {
      PluginName name = PluginName.of("[PROJECT]", "[LOCATION]", "[PLUGIN]");
      client.enablePlugin(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void enablePluginTest2() throws Exception {
    Plugin expectedResponse =
        Plugin.newBuilder()
            .setName(PluginName.of("[PROJECT]", "[LOCATION]", "[PLUGIN]").toString())
            .setDisplayName("displayName1714148973")
            .setType(AttributeValues.newBuilder().build())
            .setDescription("description-1724546052")
            .build();
    mockApiHubPlugin.addResponse(expectedResponse);

    String name = "name3373707";

    Plugin actualResponse = client.enablePlugin(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockApiHubPlugin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    EnablePluginRequest actualRequest = ((EnablePluginRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void enablePluginExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockApiHubPlugin.addException(exception);

    try {
      String name = "name3373707";
      client.enablePlugin(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void disablePluginTest() throws Exception {
    Plugin expectedResponse =
        Plugin.newBuilder()
            .setName(PluginName.of("[PROJECT]", "[LOCATION]", "[PLUGIN]").toString())
            .setDisplayName("displayName1714148973")
            .setType(AttributeValues.newBuilder().build())
            .setDescription("description-1724546052")
            .build();
    mockApiHubPlugin.addResponse(expectedResponse);

    PluginName name = PluginName.of("[PROJECT]", "[LOCATION]", "[PLUGIN]");

    Plugin actualResponse = client.disablePlugin(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockApiHubPlugin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DisablePluginRequest actualRequest = ((DisablePluginRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void disablePluginExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockApiHubPlugin.addException(exception);

    try {
      PluginName name = PluginName.of("[PROJECT]", "[LOCATION]", "[PLUGIN]");
      client.disablePlugin(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void disablePluginTest2() throws Exception {
    Plugin expectedResponse =
        Plugin.newBuilder()
            .setName(PluginName.of("[PROJECT]", "[LOCATION]", "[PLUGIN]").toString())
            .setDisplayName("displayName1714148973")
            .setType(AttributeValues.newBuilder().build())
            .setDescription("description-1724546052")
            .build();
    mockApiHubPlugin.addResponse(expectedResponse);

    String name = "name3373707";

    Plugin actualResponse = client.disablePlugin(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockApiHubPlugin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DisablePluginRequest actualRequest = ((DisablePluginRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void disablePluginExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockApiHubPlugin.addException(exception);

    try {
      String name = "name3373707";
      client.disablePlugin(name);
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
