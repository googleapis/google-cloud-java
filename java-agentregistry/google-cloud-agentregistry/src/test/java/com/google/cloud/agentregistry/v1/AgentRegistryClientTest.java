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

package com.google.cloud.agentregistry.v1;

import static com.google.cloud.agentregistry.v1.AgentRegistryClient.FetchAvailableBindingsPagedResponse;
import static com.google.cloud.agentregistry.v1.AgentRegistryClient.ListAgentsPagedResponse;
import static com.google.cloud.agentregistry.v1.AgentRegistryClient.ListBindingsPagedResponse;
import static com.google.cloud.agentregistry.v1.AgentRegistryClient.ListEndpointsPagedResponse;
import static com.google.cloud.agentregistry.v1.AgentRegistryClient.ListLocationsPagedResponse;
import static com.google.cloud.agentregistry.v1.AgentRegistryClient.ListMcpServersPagedResponse;
import static com.google.cloud.agentregistry.v1.AgentRegistryClient.ListServicesPagedResponse;
import static com.google.cloud.agentregistry.v1.AgentRegistryClient.SearchAgentsPagedResponse;
import static com.google.cloud.agentregistry.v1.AgentRegistryClient.SearchMcpServersPagedResponse;

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
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Struct;
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
public class AgentRegistryClientTest {
  private static MockAgentRegistry mockAgentRegistry;
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private AgentRegistryClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockAgentRegistry = new MockAgentRegistry();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockAgentRegistry, mockLocations));
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
    AgentRegistrySettings settings =
        AgentRegistrySettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = AgentRegistryClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listAgentsTest() throws Exception {
    Agent responsesElement = Agent.newBuilder().build();
    ListAgentsResponse expectedResponse =
        ListAgentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAgents(Arrays.asList(responsesElement))
            .build();
    mockAgentRegistry.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListAgentsPagedResponse pagedListResponse = client.listAgents(parent);

    List<Agent> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAgentsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAgentRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAgentsRequest actualRequest = ((ListAgentsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAgentsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentRegistry.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listAgents(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAgentsTest2() throws Exception {
    Agent responsesElement = Agent.newBuilder().build();
    ListAgentsResponse expectedResponse =
        ListAgentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAgents(Arrays.asList(responsesElement))
            .build();
    mockAgentRegistry.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListAgentsPagedResponse pagedListResponse = client.listAgents(parent);

    List<Agent> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAgentsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAgentRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAgentsRequest actualRequest = ((ListAgentsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAgentsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentRegistry.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listAgents(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void searchAgentsTest() throws Exception {
    Agent responsesElement = Agent.newBuilder().build();
    SearchAgentsResponse expectedResponse =
        SearchAgentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAgents(Arrays.asList(responsesElement))
            .build();
    mockAgentRegistry.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    SearchAgentsPagedResponse pagedListResponse = client.searchAgents(parent);

    List<Agent> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAgentsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAgentRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SearchAgentsRequest actualRequest = ((SearchAgentsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void searchAgentsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentRegistry.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.searchAgents(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void searchAgentsTest2() throws Exception {
    Agent responsesElement = Agent.newBuilder().build();
    SearchAgentsResponse expectedResponse =
        SearchAgentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAgents(Arrays.asList(responsesElement))
            .build();
    mockAgentRegistry.addResponse(expectedResponse);

    String parent = "parent-995424086";

    SearchAgentsPagedResponse pagedListResponse = client.searchAgents(parent);

    List<Agent> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAgentsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAgentRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SearchAgentsRequest actualRequest = ((SearchAgentsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void searchAgentsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentRegistry.addException(exception);

    try {
      String parent = "parent-995424086";
      client.searchAgents(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAgentTest() throws Exception {
    Agent expectedResponse =
        Agent.newBuilder()
            .setName(AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]").toString())
            .setAgentId("agentId-1060987136")
            .setLocation("location1901043637")
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setVersion("version351608024")
            .addAllProtocols(new ArrayList<Agent.Protocol>())
            .addAllSkills(new ArrayList<Agent.Skill>())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllAttributes(new HashMap<String, Struct>())
            .setCard(Agent.Card.newBuilder().build())
            .build();
    mockAgentRegistry.addResponse(expectedResponse);

    AgentName name = AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]");

    Agent actualResponse = client.getAgent(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgentRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAgentRequest actualRequest = ((GetAgentRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAgentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentRegistry.addException(exception);

    try {
      AgentName name = AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]");
      client.getAgent(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAgentTest2() throws Exception {
    Agent expectedResponse =
        Agent.newBuilder()
            .setName(AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]").toString())
            .setAgentId("agentId-1060987136")
            .setLocation("location1901043637")
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setVersion("version351608024")
            .addAllProtocols(new ArrayList<Agent.Protocol>())
            .addAllSkills(new ArrayList<Agent.Skill>())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllAttributes(new HashMap<String, Struct>())
            .setCard(Agent.Card.newBuilder().build())
            .build();
    mockAgentRegistry.addResponse(expectedResponse);

    String name = "name3373707";

    Agent actualResponse = client.getAgent(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgentRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAgentRequest actualRequest = ((GetAgentRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAgentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentRegistry.addException(exception);

    try {
      String name = "name3373707";
      client.getAgent(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listEndpointsTest() throws Exception {
    Endpoint responsesElement = Endpoint.newBuilder().build();
    ListEndpointsResponse expectedResponse =
        ListEndpointsResponse.newBuilder()
            .setNextPageToken("")
            .addAllEndpoints(Arrays.asList(responsesElement))
            .build();
    mockAgentRegistry.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListEndpointsPagedResponse pagedListResponse = client.listEndpoints(parent);

    List<Endpoint> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEndpointsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAgentRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListEndpointsRequest actualRequest = ((ListEndpointsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listEndpointsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentRegistry.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listEndpoints(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listEndpointsTest2() throws Exception {
    Endpoint responsesElement = Endpoint.newBuilder().build();
    ListEndpointsResponse expectedResponse =
        ListEndpointsResponse.newBuilder()
            .setNextPageToken("")
            .addAllEndpoints(Arrays.asList(responsesElement))
            .build();
    mockAgentRegistry.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListEndpointsPagedResponse pagedListResponse = client.listEndpoints(parent);

    List<Endpoint> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEndpointsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAgentRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListEndpointsRequest actualRequest = ((ListEndpointsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listEndpointsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentRegistry.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listEndpoints(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getEndpointTest() throws Exception {
    Endpoint expectedResponse =
        Endpoint.newBuilder()
            .setName(EndpointName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT]").toString())
            .setEndpointId("endpointId-1837754992")
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllInterfaces(new ArrayList<Interface>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllAttributes(new HashMap<String, Struct>())
            .build();
    mockAgentRegistry.addResponse(expectedResponse);

    EndpointName name = EndpointName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT]");

    Endpoint actualResponse = client.getEndpoint(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgentRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetEndpointRequest actualRequest = ((GetEndpointRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getEndpointExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentRegistry.addException(exception);

    try {
      EndpointName name = EndpointName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT]");
      client.getEndpoint(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getEndpointTest2() throws Exception {
    Endpoint expectedResponse =
        Endpoint.newBuilder()
            .setName(EndpointName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT]").toString())
            .setEndpointId("endpointId-1837754992")
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllInterfaces(new ArrayList<Interface>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllAttributes(new HashMap<String, Struct>())
            .build();
    mockAgentRegistry.addResponse(expectedResponse);

    String name = "name3373707";

    Endpoint actualResponse = client.getEndpoint(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgentRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetEndpointRequest actualRequest = ((GetEndpointRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getEndpointExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentRegistry.addException(exception);

    try {
      String name = "name3373707";
      client.getEndpoint(name);
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
    mockAgentRegistry.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListMcpServersPagedResponse pagedListResponse = client.listMcpServers(parent);

    List<McpServer> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMcpServersList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAgentRegistry.getRequests();
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
    mockAgentRegistry.addException(exception);

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
    mockAgentRegistry.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListMcpServersPagedResponse pagedListResponse = client.listMcpServers(parent);

    List<McpServer> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMcpServersList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAgentRegistry.getRequests();
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
    mockAgentRegistry.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listMcpServers(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void searchMcpServersTest() throws Exception {
    McpServer responsesElement = McpServer.newBuilder().build();
    SearchMcpServersResponse expectedResponse =
        SearchMcpServersResponse.newBuilder()
            .setNextPageToken("")
            .addAllMcpServers(Arrays.asList(responsesElement))
            .build();
    mockAgentRegistry.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    SearchMcpServersPagedResponse pagedListResponse = client.searchMcpServers(parent);

    List<McpServer> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMcpServersList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAgentRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SearchMcpServersRequest actualRequest = ((SearchMcpServersRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void searchMcpServersExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentRegistry.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.searchMcpServers(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void searchMcpServersTest2() throws Exception {
    McpServer responsesElement = McpServer.newBuilder().build();
    SearchMcpServersResponse expectedResponse =
        SearchMcpServersResponse.newBuilder()
            .setNextPageToken("")
            .addAllMcpServers(Arrays.asList(responsesElement))
            .build();
    mockAgentRegistry.addResponse(expectedResponse);

    String parent = "parent-995424086";

    SearchMcpServersPagedResponse pagedListResponse = client.searchMcpServers(parent);

    List<McpServer> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMcpServersList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAgentRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SearchMcpServersRequest actualRequest = ((SearchMcpServersRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void searchMcpServersExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentRegistry.addException(exception);

    try {
      String parent = "parent-995424086";
      client.searchMcpServers(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getMcpServerTest() throws Exception {
    McpServer expectedResponse =
        McpServer.newBuilder()
            .setName(McpServerName.of("[PROJECT]", "[LOCATION]", "[MCP_SERVER]").toString())
            .setMcpServerId("mcpServerId298140536")
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllInterfaces(new ArrayList<Interface>())
            .addAllTools(new ArrayList<McpServer.Tool>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllAttributes(new HashMap<String, Struct>())
            .build();
    mockAgentRegistry.addResponse(expectedResponse);

    McpServerName name = McpServerName.of("[PROJECT]", "[LOCATION]", "[MCP_SERVER]");

    McpServer actualResponse = client.getMcpServer(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgentRegistry.getRequests();
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
    mockAgentRegistry.addException(exception);

    try {
      McpServerName name = McpServerName.of("[PROJECT]", "[LOCATION]", "[MCP_SERVER]");
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
            .setName(McpServerName.of("[PROJECT]", "[LOCATION]", "[MCP_SERVER]").toString())
            .setMcpServerId("mcpServerId298140536")
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllInterfaces(new ArrayList<Interface>())
            .addAllTools(new ArrayList<McpServer.Tool>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllAttributes(new HashMap<String, Struct>())
            .build();
    mockAgentRegistry.addResponse(expectedResponse);

    String name = "name3373707";

    McpServer actualResponse = client.getMcpServer(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgentRegistry.getRequests();
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
    mockAgentRegistry.addException(exception);

    try {
      String name = "name3373707";
      client.getMcpServer(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listServicesTest() throws Exception {
    Service responsesElement = Service.newBuilder().build();
    ListServicesResponse expectedResponse =
        ListServicesResponse.newBuilder()
            .setNextPageToken("")
            .addAllServices(Arrays.asList(responsesElement))
            .build();
    mockAgentRegistry.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListServicesPagedResponse pagedListResponse = client.listServices(parent);

    List<Service> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getServicesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAgentRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListServicesRequest actualRequest = ((ListServicesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listServicesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentRegistry.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listServices(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listServicesTest2() throws Exception {
    Service responsesElement = Service.newBuilder().build();
    ListServicesResponse expectedResponse =
        ListServicesResponse.newBuilder()
            .setNextPageToken("")
            .addAllServices(Arrays.asList(responsesElement))
            .build();
    mockAgentRegistry.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListServicesPagedResponse pagedListResponse = client.listServices(parent);

    List<Service> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getServicesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAgentRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListServicesRequest actualRequest = ((ListServicesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listServicesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentRegistry.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listServices(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getServiceTest() throws Exception {
    Service expectedResponse =
        Service.newBuilder()
            .setName(ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllInterfaces(new ArrayList<Interface>())
            .setRegistryResource("registryResource1400949611")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockAgentRegistry.addResponse(expectedResponse);

    ServiceName name = ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]");

    Service actualResponse = client.getService(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgentRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetServiceRequest actualRequest = ((GetServiceRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getServiceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentRegistry.addException(exception);

    try {
      ServiceName name = ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]");
      client.getService(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getServiceTest2() throws Exception {
    Service expectedResponse =
        Service.newBuilder()
            .setName(ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllInterfaces(new ArrayList<Interface>())
            .setRegistryResource("registryResource1400949611")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockAgentRegistry.addResponse(expectedResponse);

    String name = "name3373707";

    Service actualResponse = client.getService(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgentRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetServiceRequest actualRequest = ((GetServiceRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getServiceExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentRegistry.addException(exception);

    try {
      String name = "name3373707";
      client.getService(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createServiceTest() throws Exception {
    Service expectedResponse =
        Service.newBuilder()
            .setName(ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllInterfaces(new ArrayList<Interface>())
            .setRegistryResource("registryResource1400949611")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createServiceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAgentRegistry.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Service service = Service.newBuilder().build();
    String serviceId = "serviceId-194185552";

    Service actualResponse = client.createServiceAsync(parent, service, serviceId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgentRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateServiceRequest actualRequest = ((CreateServiceRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(service, actualRequest.getService());
    Assert.assertEquals(serviceId, actualRequest.getServiceId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createServiceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentRegistry.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Service service = Service.newBuilder().build();
      String serviceId = "serviceId-194185552";
      client.createServiceAsync(parent, service, serviceId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createServiceTest2() throws Exception {
    Service expectedResponse =
        Service.newBuilder()
            .setName(ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllInterfaces(new ArrayList<Interface>())
            .setRegistryResource("registryResource1400949611")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createServiceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAgentRegistry.addResponse(resultOperation);

    String parent = "parent-995424086";
    Service service = Service.newBuilder().build();
    String serviceId = "serviceId-194185552";

    Service actualResponse = client.createServiceAsync(parent, service, serviceId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgentRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateServiceRequest actualRequest = ((CreateServiceRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(service, actualRequest.getService());
    Assert.assertEquals(serviceId, actualRequest.getServiceId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createServiceExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentRegistry.addException(exception);

    try {
      String parent = "parent-995424086";
      Service service = Service.newBuilder().build();
      String serviceId = "serviceId-194185552";
      client.createServiceAsync(parent, service, serviceId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateServiceTest() throws Exception {
    Service expectedResponse =
        Service.newBuilder()
            .setName(ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllInterfaces(new ArrayList<Interface>())
            .setRegistryResource("registryResource1400949611")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateServiceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAgentRegistry.addResponse(resultOperation);

    Service service = Service.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Service actualResponse = client.updateServiceAsync(service, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgentRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateServiceRequest actualRequest = ((UpdateServiceRequest) actualRequests.get(0));

    Assert.assertEquals(service, actualRequest.getService());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateServiceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentRegistry.addException(exception);

    try {
      Service service = Service.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateServiceAsync(service, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteServiceTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteServiceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAgentRegistry.addResponse(resultOperation);

    ServiceName name = ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]");

    client.deleteServiceAsync(name).get();

    List<AbstractMessage> actualRequests = mockAgentRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteServiceRequest actualRequest = ((DeleteServiceRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteServiceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentRegistry.addException(exception);

    try {
      ServiceName name = ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]");
      client.deleteServiceAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteServiceTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteServiceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAgentRegistry.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteServiceAsync(name).get();

    List<AbstractMessage> actualRequests = mockAgentRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteServiceRequest actualRequest = ((DeleteServiceRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteServiceExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentRegistry.addException(exception);

    try {
      String name = "name3373707";
      client.deleteServiceAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listBindingsTest() throws Exception {
    Binding responsesElement = Binding.newBuilder().build();
    ListBindingsResponse expectedResponse =
        ListBindingsResponse.newBuilder()
            .setNextPageToken("")
            .addAllBindings(Arrays.asList(responsesElement))
            .build();
    mockAgentRegistry.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListBindingsPagedResponse pagedListResponse = client.listBindings(parent);

    List<Binding> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBindingsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAgentRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListBindingsRequest actualRequest = ((ListBindingsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listBindingsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentRegistry.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listBindings(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listBindingsTest2() throws Exception {
    Binding responsesElement = Binding.newBuilder().build();
    ListBindingsResponse expectedResponse =
        ListBindingsResponse.newBuilder()
            .setNextPageToken("")
            .addAllBindings(Arrays.asList(responsesElement))
            .build();
    mockAgentRegistry.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListBindingsPagedResponse pagedListResponse = client.listBindings(parent);

    List<Binding> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBindingsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAgentRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListBindingsRequest actualRequest = ((ListBindingsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listBindingsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentRegistry.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listBindings(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getBindingTest() throws Exception {
    Binding expectedResponse =
        Binding.newBuilder()
            .setName(BindingName.of("[PROJECT]", "[LOCATION]", "[BINDING]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setSource(Binding.Source.newBuilder().build())
            .setTarget(Binding.Target.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockAgentRegistry.addResponse(expectedResponse);

    BindingName name = BindingName.of("[PROJECT]", "[LOCATION]", "[BINDING]");

    Binding actualResponse = client.getBinding(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgentRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetBindingRequest actualRequest = ((GetBindingRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getBindingExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentRegistry.addException(exception);

    try {
      BindingName name = BindingName.of("[PROJECT]", "[LOCATION]", "[BINDING]");
      client.getBinding(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getBindingTest2() throws Exception {
    Binding expectedResponse =
        Binding.newBuilder()
            .setName(BindingName.of("[PROJECT]", "[LOCATION]", "[BINDING]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setSource(Binding.Source.newBuilder().build())
            .setTarget(Binding.Target.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockAgentRegistry.addResponse(expectedResponse);

    String name = "name3373707";

    Binding actualResponse = client.getBinding(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgentRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetBindingRequest actualRequest = ((GetBindingRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getBindingExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentRegistry.addException(exception);

    try {
      String name = "name3373707";
      client.getBinding(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createBindingTest() throws Exception {
    Binding expectedResponse =
        Binding.newBuilder()
            .setName(BindingName.of("[PROJECT]", "[LOCATION]", "[BINDING]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setSource(Binding.Source.newBuilder().build())
            .setTarget(Binding.Target.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createBindingTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAgentRegistry.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Binding binding = Binding.newBuilder().build();
    String bindingId = "bindingId-920966528";

    Binding actualResponse = client.createBindingAsync(parent, binding, bindingId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgentRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateBindingRequest actualRequest = ((CreateBindingRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(binding, actualRequest.getBinding());
    Assert.assertEquals(bindingId, actualRequest.getBindingId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createBindingExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentRegistry.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Binding binding = Binding.newBuilder().build();
      String bindingId = "bindingId-920966528";
      client.createBindingAsync(parent, binding, bindingId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createBindingTest2() throws Exception {
    Binding expectedResponse =
        Binding.newBuilder()
            .setName(BindingName.of("[PROJECT]", "[LOCATION]", "[BINDING]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setSource(Binding.Source.newBuilder().build())
            .setTarget(Binding.Target.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createBindingTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAgentRegistry.addResponse(resultOperation);

    String parent = "parent-995424086";
    Binding binding = Binding.newBuilder().build();
    String bindingId = "bindingId-920966528";

    Binding actualResponse = client.createBindingAsync(parent, binding, bindingId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgentRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateBindingRequest actualRequest = ((CreateBindingRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(binding, actualRequest.getBinding());
    Assert.assertEquals(bindingId, actualRequest.getBindingId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createBindingExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentRegistry.addException(exception);

    try {
      String parent = "parent-995424086";
      Binding binding = Binding.newBuilder().build();
      String bindingId = "bindingId-920966528";
      client.createBindingAsync(parent, binding, bindingId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateBindingTest() throws Exception {
    Binding expectedResponse =
        Binding.newBuilder()
            .setName(BindingName.of("[PROJECT]", "[LOCATION]", "[BINDING]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setSource(Binding.Source.newBuilder().build())
            .setTarget(Binding.Target.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateBindingTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAgentRegistry.addResponse(resultOperation);

    Binding binding = Binding.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Binding actualResponse = client.updateBindingAsync(binding, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgentRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateBindingRequest actualRequest = ((UpdateBindingRequest) actualRequests.get(0));

    Assert.assertEquals(binding, actualRequest.getBinding());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateBindingExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentRegistry.addException(exception);

    try {
      Binding binding = Binding.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateBindingAsync(binding, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteBindingTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteBindingTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAgentRegistry.addResponse(resultOperation);

    BindingName name = BindingName.of("[PROJECT]", "[LOCATION]", "[BINDING]");

    client.deleteBindingAsync(name).get();

    List<AbstractMessage> actualRequests = mockAgentRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteBindingRequest actualRequest = ((DeleteBindingRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteBindingExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentRegistry.addException(exception);

    try {
      BindingName name = BindingName.of("[PROJECT]", "[LOCATION]", "[BINDING]");
      client.deleteBindingAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteBindingTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteBindingTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAgentRegistry.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteBindingAsync(name).get();

    List<AbstractMessage> actualRequests = mockAgentRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteBindingRequest actualRequest = ((DeleteBindingRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteBindingExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentRegistry.addException(exception);

    try {
      String name = "name3373707";
      client.deleteBindingAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void fetchAvailableBindingsTest() throws Exception {
    Binding responsesElement = Binding.newBuilder().build();
    FetchAvailableBindingsResponse expectedResponse =
        FetchAvailableBindingsResponse.newBuilder()
            .setNextPageToken("")
            .addAllBindings(Arrays.asList(responsesElement))
            .build();
    mockAgentRegistry.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    FetchAvailableBindingsPagedResponse pagedListResponse = client.fetchAvailableBindings(parent);

    List<Binding> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBindingsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAgentRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    FetchAvailableBindingsRequest actualRequest =
        ((FetchAvailableBindingsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void fetchAvailableBindingsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentRegistry.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.fetchAvailableBindings(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void fetchAvailableBindingsTest2() throws Exception {
    Binding responsesElement = Binding.newBuilder().build();
    FetchAvailableBindingsResponse expectedResponse =
        FetchAvailableBindingsResponse.newBuilder()
            .setNextPageToken("")
            .addAllBindings(Arrays.asList(responsesElement))
            .build();
    mockAgentRegistry.addResponse(expectedResponse);

    String parent = "parent-995424086";

    FetchAvailableBindingsPagedResponse pagedListResponse = client.fetchAvailableBindings(parent);

    List<Binding> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBindingsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAgentRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    FetchAvailableBindingsRequest actualRequest =
        ((FetchAvailableBindingsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void fetchAvailableBindingsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentRegistry.addException(exception);

    try {
      String parent = "parent-995424086";
      client.fetchAvailableBindings(parent);
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
