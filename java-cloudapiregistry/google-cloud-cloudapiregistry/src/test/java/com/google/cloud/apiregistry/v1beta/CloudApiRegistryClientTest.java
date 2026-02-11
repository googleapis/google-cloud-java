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

package com.google.cloud.apiregistry.v1beta;

import static com.google.cloud.apiregistry.v1beta.CloudApiRegistryClient.ListLocationsPagedResponse;
import static com.google.cloud.apiregistry.v1beta.CloudApiRegistryClient.ListMcpServersPagedResponse;
import static com.google.cloud.apiregistry.v1beta.CloudApiRegistryClient.ListMcpToolsPagedResponse;

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
import com.google.protobuf.Struct;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
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
public class CloudApiRegistryClientTest {
  private static MockCloudApiRegistry mockCloudApiRegistry;
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private CloudApiRegistryClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockCloudApiRegistry = new MockCloudApiRegistry();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockCloudApiRegistry, mockLocations));
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
    CloudApiRegistrySettings settings =
        CloudApiRegistrySettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = CloudApiRegistryClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void getMcpServerTest() throws Exception {
    McpServer expectedResponse =
        McpServer.newBuilder()
            .setName(
                McpServerName.ofProjectLocationMcpServerName(
                        "[PROJECT]", "[LOCATION]", "[MCP_SERVER]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllUrls(new ArrayList<String>())
            .setCapabilities(Struct.newBuilder().build())
            .setState(State.forNumber(0))
            .build();
    mockCloudApiRegistry.addResponse(expectedResponse);

    McpServerName name =
        McpServerName.ofProjectLocationMcpServerName("[PROJECT]", "[LOCATION]", "[MCP_SERVER]");

    McpServer actualResponse = client.getMcpServer(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudApiRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetMcpServerRequest actualRequest = ((GetMcpServerRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getMcpServerExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudApiRegistry.addException(exception);

    try {
      McpServerName name =
          McpServerName.ofProjectLocationMcpServerName("[PROJECT]", "[LOCATION]", "[MCP_SERVER]");
      client.getMcpServer(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getMcpServerTest2() throws Exception {
    McpServer expectedResponse =
        McpServer.newBuilder()
            .setName(
                McpServerName.ofProjectLocationMcpServerName(
                        "[PROJECT]", "[LOCATION]", "[MCP_SERVER]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllUrls(new ArrayList<String>())
            .setCapabilities(Struct.newBuilder().build())
            .setState(State.forNumber(0))
            .build();
    mockCloudApiRegistry.addResponse(expectedResponse);

    String name = "name3373707";

    McpServer actualResponse = client.getMcpServer(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudApiRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetMcpServerRequest actualRequest = ((GetMcpServerRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getMcpServerExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudApiRegistry.addException(exception);

    try {
      String name = "name3373707";
      client.getMcpServer(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listMcpServersTest() throws Exception {
    McpServer responsesElement = McpServer.newBuilder().build();
    ListMcpServersResponse expectedResponse =
        ListMcpServersResponse.newBuilder()
            .setNextPageToken("")
            .addAllMcpServers(Arrays.asList(responsesElement))
            .build();
    mockCloudApiRegistry.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListMcpServersPagedResponse pagedListResponse = client.listMcpServers(parent);

    List<McpServer> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMcpServersList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCloudApiRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListMcpServersRequest actualRequest = ((ListMcpServersRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listMcpServersExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudApiRegistry.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listMcpServers(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listMcpServersTest2() throws Exception {
    McpServer responsesElement = McpServer.newBuilder().build();
    ListMcpServersResponse expectedResponse =
        ListMcpServersResponse.newBuilder()
            .setNextPageToken("")
            .addAllMcpServers(Arrays.asList(responsesElement))
            .build();
    mockCloudApiRegistry.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListMcpServersPagedResponse pagedListResponse = client.listMcpServers(parent);

    List<McpServer> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMcpServersList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCloudApiRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListMcpServersRequest actualRequest = ((ListMcpServersRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listMcpServersExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudApiRegistry.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listMcpServers(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getMcpToolTest() throws Exception {
    McpTool expectedResponse =
        McpTool.newBuilder()
            .setName(
                McpToolName.ofProjectLocationMcpServerMcpToolName(
                        "[PROJECT]", "[LOCATION]", "[MCP_SERVER]", "[MCP_TOOL]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllMcpServerUrls(new ArrayList<String>())
            .setInputSchema(Struct.newBuilder().build())
            .setOutputSchema(Struct.newBuilder().build())
            .setAnnotations(Struct.newBuilder().build())
            .build();
    mockCloudApiRegistry.addResponse(expectedResponse);

    McpToolName name =
        McpToolName.ofProjectLocationMcpServerMcpToolName(
            "[PROJECT]", "[LOCATION]", "[MCP_SERVER]", "[MCP_TOOL]");

    McpTool actualResponse = client.getMcpTool(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudApiRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetMcpToolRequest actualRequest = ((GetMcpToolRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getMcpToolExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudApiRegistry.addException(exception);

    try {
      McpToolName name =
          McpToolName.ofProjectLocationMcpServerMcpToolName(
              "[PROJECT]", "[LOCATION]", "[MCP_SERVER]", "[MCP_TOOL]");
      client.getMcpTool(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getMcpToolTest2() throws Exception {
    McpTool expectedResponse =
        McpTool.newBuilder()
            .setName(
                McpToolName.ofProjectLocationMcpServerMcpToolName(
                        "[PROJECT]", "[LOCATION]", "[MCP_SERVER]", "[MCP_TOOL]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllMcpServerUrls(new ArrayList<String>())
            .setInputSchema(Struct.newBuilder().build())
            .setOutputSchema(Struct.newBuilder().build())
            .setAnnotations(Struct.newBuilder().build())
            .build();
    mockCloudApiRegistry.addResponse(expectedResponse);

    String name = "name3373707";

    McpTool actualResponse = client.getMcpTool(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudApiRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetMcpToolRequest actualRequest = ((GetMcpToolRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getMcpToolExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudApiRegistry.addException(exception);

    try {
      String name = "name3373707";
      client.getMcpTool(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listMcpToolsTest() throws Exception {
    McpTool responsesElement = McpTool.newBuilder().build();
    ListMcpToolsResponse expectedResponse =
        ListMcpToolsResponse.newBuilder()
            .setNextPageToken("")
            .addAllMcpTools(Arrays.asList(responsesElement))
            .build();
    mockCloudApiRegistry.addResponse(expectedResponse);

    McpServerName parent =
        McpServerName.ofProjectLocationMcpServerName("[PROJECT]", "[LOCATION]", "[MCP_SERVER]");

    ListMcpToolsPagedResponse pagedListResponse = client.listMcpTools(parent);

    List<McpTool> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMcpToolsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCloudApiRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListMcpToolsRequest actualRequest = ((ListMcpToolsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listMcpToolsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudApiRegistry.addException(exception);

    try {
      McpServerName parent =
          McpServerName.ofProjectLocationMcpServerName("[PROJECT]", "[LOCATION]", "[MCP_SERVER]");
      client.listMcpTools(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listMcpToolsTest2() throws Exception {
    McpTool responsesElement = McpTool.newBuilder().build();
    ListMcpToolsResponse expectedResponse =
        ListMcpToolsResponse.newBuilder()
            .setNextPageToken("")
            .addAllMcpTools(Arrays.asList(responsesElement))
            .build();
    mockCloudApiRegistry.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListMcpToolsPagedResponse pagedListResponse = client.listMcpTools(parent);

    List<McpTool> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMcpToolsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCloudApiRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListMcpToolsRequest actualRequest = ((ListMcpToolsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listMcpToolsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudApiRegistry.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listMcpTools(parent);
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
