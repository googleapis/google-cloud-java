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
import static com.google.cloud.agentregistry.v1.AgentRegistryClient.ListAiApplicationAgentsPagedResponse;
import static com.google.cloud.agentregistry.v1.AgentRegistryClient.ListAiApplicationEndpointsPagedResponse;
import static com.google.cloud.agentregistry.v1.AgentRegistryClient.ListAiApplicationMcpServersPagedResponse;
import static com.google.cloud.agentregistry.v1.AgentRegistryClient.ListAiApplicationsPagedResponse;
import static com.google.cloud.agentregistry.v1.AgentRegistryClient.ListBindingsPagedResponse;
import static com.google.cloud.agentregistry.v1.AgentRegistryClient.ListEndpointsPagedResponse;
import static com.google.cloud.agentregistry.v1.AgentRegistryClient.ListFindingsPagedResponse;
import static com.google.cloud.agentregistry.v1.AgentRegistryClient.ListLocationsPagedResponse;
import static com.google.cloud.agentregistry.v1.AgentRegistryClient.ListMcpServersPagedResponse;
import static com.google.cloud.agentregistry.v1.AgentRegistryClient.ListPublishersPagedResponse;
import static com.google.cloud.agentregistry.v1.AgentRegistryClient.ListServicesPagedResponse;
import static com.google.cloud.agentregistry.v1.AgentRegistryClient.ListSkillRevisionsPagedResponse;
import static com.google.cloud.agentregistry.v1.AgentRegistryClient.ListSkillsPagedResponse;
import static com.google.cloud.agentregistry.v1.AgentRegistryClient.SearchAgentsPagedResponse;
import static com.google.cloud.agentregistry.v1.AgentRegistryClient.SearchMcpServersPagedResponse;
import static com.google.cloud.agentregistry.v1.AgentRegistryClient.SearchSkillsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.agentregistry.v1.stub.HttpJsonAgentRegistryStub;
import com.google.cloud.apphub.v1.ApplicationProperties;
import com.google.cloud.apphub.v1.Attributes;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Struct;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class AgentRegistryClientHttpJsonTest {
  private static MockHttpService mockService;
  private static AgentRegistryClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonAgentRegistryStub.getMethodDescriptors(),
            AgentRegistrySettings.getDefaultEndpoint());
    AgentRegistrySettings settings =
        AgentRegistrySettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                AgentRegistrySettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = AgentRegistryClient.create(settings);
  }

  @AfterClass
  public static void stopServer() {
    client.close();
  }

  @Before
  public void setUp() {}

  @After
  public void tearDown() throws Exception {
    mockService.reset();
  }

  @Test
  public void listAgentsTest() throws Exception {
    Agent responsesElement = Agent.newBuilder().build();
    ListAgentsResponse expectedResponse =
        ListAgentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAgents(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListAgentsPagedResponse pagedListResponse = client.listAgents(parent);

    List<Agent> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAgentsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listAgentsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListAgentsPagedResponse pagedListResponse = client.listAgents(parent);

    List<Agent> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAgentsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listAgentsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
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
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    SearchAgentsPagedResponse pagedListResponse = client.searchAgents(parent);

    List<Agent> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAgentsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void searchAgentsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    SearchAgentsPagedResponse pagedListResponse = client.searchAgents(parent);

    List<Agent> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAgentsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void searchAgentsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
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
            .setName(
                AgentName.ofProjectLocationAgentName("[PROJECT]", "[LOCATION]", "[AGENT]")
                    .toString())
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
    mockService.addResponse(expectedResponse);

    AgentName name = AgentName.ofProjectLocationAgentName("[PROJECT]", "[LOCATION]", "[AGENT]");

    Agent actualResponse = client.getAgent(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getAgentExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AgentName name = AgentName.ofProjectLocationAgentName("[PROJECT]", "[LOCATION]", "[AGENT]");
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
            .setName(
                AgentName.ofProjectLocationAgentName("[PROJECT]", "[LOCATION]", "[AGENT]")
                    .toString())
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
    mockService.addResponse(expectedResponse);

    String name = "projects/project-2930/locations/location-2930/agents/agent-2930";

    Agent actualResponse = client.getAgent(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getAgentExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-2930/locations/location-2930/agents/agent-2930";
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
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListEndpointsPagedResponse pagedListResponse = client.listEndpoints(parent);

    List<Endpoint> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEndpointsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listEndpointsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListEndpointsPagedResponse pagedListResponse = client.listEndpoints(parent);

    List<Endpoint> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEndpointsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listEndpointsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
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
            .setName(
                EndpointName.ofProjectLocationEndpointName("[PROJECT]", "[LOCATION]", "[ENDPOINT]")
                    .toString())
            .setEndpointId("endpointId-1837754992")
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllInterfaces(new ArrayList<Interface>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllAttributes(new HashMap<String, Struct>())
            .build();
    mockService.addResponse(expectedResponse);

    EndpointName name =
        EndpointName.ofProjectLocationEndpointName("[PROJECT]", "[LOCATION]", "[ENDPOINT]");

    Endpoint actualResponse = client.getEndpoint(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getEndpointExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      EndpointName name =
          EndpointName.ofProjectLocationEndpointName("[PROJECT]", "[LOCATION]", "[ENDPOINT]");
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
            .setName(
                EndpointName.ofProjectLocationEndpointName("[PROJECT]", "[LOCATION]", "[ENDPOINT]")
                    .toString())
            .setEndpointId("endpointId-1837754992")
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllInterfaces(new ArrayList<Interface>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllAttributes(new HashMap<String, Struct>())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-6164/locations/location-6164/endpoints/endpoint-6164";

    Endpoint actualResponse = client.getEndpoint(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getEndpointExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-6164/locations/location-6164/endpoints/endpoint-6164";
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
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListMcpServersPagedResponse pagedListResponse = client.listMcpServers(parent);

    List<McpServer> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMcpServersList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listMcpServersExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListMcpServersPagedResponse pagedListResponse = client.listMcpServers(parent);

    List<McpServer> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMcpServersList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listMcpServersExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
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
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    SearchMcpServersPagedResponse pagedListResponse = client.searchMcpServers(parent);

    List<McpServer> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMcpServersList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void searchMcpServersExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    SearchMcpServersPagedResponse pagedListResponse = client.searchMcpServers(parent);

    List<McpServer> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMcpServersList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void searchMcpServersExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
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
            .setName(
                McpServerName.ofProjectLocationMcpServerName(
                        "[PROJECT]", "[LOCATION]", "[MCP_SERVER]")
                    .toString())
            .setMcpServerId("mcpServerId298140536")
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllInterfaces(new ArrayList<Interface>())
            .addAllTools(new ArrayList<McpServer.Tool>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllAttributes(new HashMap<String, Struct>())
            .build();
    mockService.addResponse(expectedResponse);

    McpServerName name =
        McpServerName.ofProjectLocationMcpServerName("[PROJECT]", "[LOCATION]", "[MCP_SERVER]");

    McpServer actualResponse = client.getMcpServer(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getMcpServerExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
            .setMcpServerId("mcpServerId298140536")
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllInterfaces(new ArrayList<Interface>())
            .addAllTools(new ArrayList<McpServer.Tool>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllAttributes(new HashMap<String, Struct>())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-5974/locations/location-5974/mcpServers/mcpServer-5974";

    McpServer actualResponse = client.getMcpServer(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getMcpServerExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-5974/locations/location-5974/mcpServers/mcpServer-5974";
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
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListServicesPagedResponse pagedListResponse = client.listServices(parent);

    List<Service> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getServicesList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listServicesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListServicesPagedResponse pagedListResponse = client.listServices(parent);

    List<Service> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getServicesList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listServicesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
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
    mockService.addResponse(expectedResponse);

    ServiceName name = ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]");

    Service actualResponse = client.getService(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getServiceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name = "projects/project-7842/locations/location-7842/services/service-7842";

    Service actualResponse = client.getService(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getServiceExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-7842/locations/location-7842/services/service-7842";
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
    mockService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Service service = Service.newBuilder().build();
    String serviceId = "serviceId-194185552";

    Service actualResponse = client.createServiceAsync(parent, service, serviceId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createServiceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Service service = Service.newBuilder().build();
      String serviceId = "serviceId-194185552";
      client.createServiceAsync(parent, service, serviceId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5833/locations/location-5833";
    Service service = Service.newBuilder().build();
    String serviceId = "serviceId-194185552";

    Service actualResponse = client.createServiceAsync(parent, service, serviceId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createServiceExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      Service service = Service.newBuilder().build();
      String serviceId = "serviceId-194185552";
      client.createServiceAsync(parent, service, serviceId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    Service service =
        Service.newBuilder()
            .setName(ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllInterfaces(new ArrayList<Interface>())
            .setRegistryResource("registryResource1400949611")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Service actualResponse = client.updateServiceAsync(service, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void updateServiceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Service service =
          Service.newBuilder()
              .setName(ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]").toString())
              .setDisplayName("displayName1714148973")
              .setDescription("description-1724546052")
              .addAllInterfaces(new ArrayList<Interface>())
              .setRegistryResource("registryResource1400949611")
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateServiceAsync(service, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    ServiceName name = ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]");

    client.deleteServiceAsync(name).get();

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteServiceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ServiceName name = ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]");
      client.deleteServiceAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    String name = "projects/project-7842/locations/location-7842/services/service-7842";

    client.deleteServiceAsync(name).get();

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteServiceExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-7842/locations/location-7842/services/service-7842";
      client.deleteServiceAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListBindingsPagedResponse pagedListResponse = client.listBindings(parent);

    List<Binding> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBindingsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listBindingsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListBindingsPagedResponse pagedListResponse = client.listBindings(parent);

    List<Binding> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBindingsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listBindingsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
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
    mockService.addResponse(expectedResponse);

    BindingName name = BindingName.of("[PROJECT]", "[LOCATION]", "[BINDING]");

    Binding actualResponse = client.getBinding(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getBindingExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name = "projects/project-5678/locations/location-5678/bindings/binding-5678";

    Binding actualResponse = client.getBinding(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getBindingExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-5678/locations/location-5678/bindings/binding-5678";
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
    mockService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Binding binding = Binding.newBuilder().build();
    String bindingId = "bindingId-920966528";

    Binding actualResponse = client.createBindingAsync(parent, binding, bindingId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createBindingExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Binding binding = Binding.newBuilder().build();
      String bindingId = "bindingId-920966528";
      client.createBindingAsync(parent, binding, bindingId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5833/locations/location-5833";
    Binding binding = Binding.newBuilder().build();
    String bindingId = "bindingId-920966528";

    Binding actualResponse = client.createBindingAsync(parent, binding, bindingId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createBindingExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      Binding binding = Binding.newBuilder().build();
      String bindingId = "bindingId-920966528";
      client.createBindingAsync(parent, binding, bindingId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    Binding binding =
        Binding.newBuilder()
            .setName(BindingName.of("[PROJECT]", "[LOCATION]", "[BINDING]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setSource(Binding.Source.newBuilder().build())
            .setTarget(Binding.Target.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Binding actualResponse = client.updateBindingAsync(binding, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void updateBindingExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Binding binding =
          Binding.newBuilder()
              .setName(BindingName.of("[PROJECT]", "[LOCATION]", "[BINDING]").toString())
              .setDisplayName("displayName1714148973")
              .setDescription("description-1724546052")
              .setSource(Binding.Source.newBuilder().build())
              .setTarget(Binding.Target.newBuilder().build())
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateBindingAsync(binding, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    BindingName name = BindingName.of("[PROJECT]", "[LOCATION]", "[BINDING]");

    client.deleteBindingAsync(name).get();

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteBindingExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      BindingName name = BindingName.of("[PROJECT]", "[LOCATION]", "[BINDING]");
      client.deleteBindingAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    String name = "projects/project-5678/locations/location-5678/bindings/binding-5678";

    client.deleteBindingAsync(name).get();

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteBindingExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-5678/locations/location-5678/bindings/binding-5678";
      client.deleteBindingAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    FetchAvailableBindingsPagedResponse pagedListResponse = client.fetchAvailableBindings(parent);

    List<Binding> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBindingsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void fetchAvailableBindingsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    FetchAvailableBindingsPagedResponse pagedListResponse = client.fetchAvailableBindings(parent);

    List<Binding> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBindingsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void fetchAvailableBindingsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.fetchAvailableBindings(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createSkillTest() throws Exception {
    Skill expectedResponse =
        Skill.newBuilder()
            .setName(SkillName.of("[PROJECT]", "[LOCATION]", "[SKILL]").toString())
            .setUid("uid115792")
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setDefaultRevision(
                SkillRevisionName.of("[PROJECT]", "[LOCATION]", "[SKILL]", "[REVISION]").toString())
            .setFrontmatter(Frontmatter.newBuilder().build())
            .setSkillId("skillId2147320652")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setPublisher(PublisherName.of("[PROJECT]", "[LOCATION]", "[PUBLISHER]").toString())
            .setInitialRevision(SkillRevision.newBuilder().build())
            .setScanningConfig(ScanningConfig.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createSkillTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Skill skill = Skill.newBuilder().build();
    String skillId = "skillId2147320652";

    Skill actualResponse = client.createSkillAsync(parent, skill, skillId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createSkillExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Skill skill = Skill.newBuilder().build();
      String skillId = "skillId2147320652";
      client.createSkillAsync(parent, skill, skillId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createSkillTest2() throws Exception {
    Skill expectedResponse =
        Skill.newBuilder()
            .setName(SkillName.of("[PROJECT]", "[LOCATION]", "[SKILL]").toString())
            .setUid("uid115792")
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setDefaultRevision(
                SkillRevisionName.of("[PROJECT]", "[LOCATION]", "[SKILL]", "[REVISION]").toString())
            .setFrontmatter(Frontmatter.newBuilder().build())
            .setSkillId("skillId2147320652")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setPublisher(PublisherName.of("[PROJECT]", "[LOCATION]", "[PUBLISHER]").toString())
            .setInitialRevision(SkillRevision.newBuilder().build())
            .setScanningConfig(ScanningConfig.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createSkillTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5833/locations/location-5833";
    Skill skill = Skill.newBuilder().build();
    String skillId = "skillId2147320652";

    Skill actualResponse = client.createSkillAsync(parent, skill, skillId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createSkillExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      Skill skill = Skill.newBuilder().build();
      String skillId = "skillId2147320652";
      client.createSkillAsync(parent, skill, skillId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void getSkillTest() throws Exception {
    Skill expectedResponse =
        Skill.newBuilder()
            .setName(SkillName.of("[PROJECT]", "[LOCATION]", "[SKILL]").toString())
            .setUid("uid115792")
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setDefaultRevision(
                SkillRevisionName.of("[PROJECT]", "[LOCATION]", "[SKILL]", "[REVISION]").toString())
            .setFrontmatter(Frontmatter.newBuilder().build())
            .setSkillId("skillId2147320652")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setPublisher(PublisherName.of("[PROJECT]", "[LOCATION]", "[PUBLISHER]").toString())
            .setInitialRevision(SkillRevision.newBuilder().build())
            .setScanningConfig(ScanningConfig.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    SkillName name = SkillName.of("[PROJECT]", "[LOCATION]", "[SKILL]");

    Skill actualResponse = client.getSkill(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getSkillExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SkillName name = SkillName.of("[PROJECT]", "[LOCATION]", "[SKILL]");
      client.getSkill(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSkillTest2() throws Exception {
    Skill expectedResponse =
        Skill.newBuilder()
            .setName(SkillName.of("[PROJECT]", "[LOCATION]", "[SKILL]").toString())
            .setUid("uid115792")
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setDefaultRevision(
                SkillRevisionName.of("[PROJECT]", "[LOCATION]", "[SKILL]", "[REVISION]").toString())
            .setFrontmatter(Frontmatter.newBuilder().build())
            .setSkillId("skillId2147320652")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setPublisher(PublisherName.of("[PROJECT]", "[LOCATION]", "[PUBLISHER]").toString())
            .setInitialRevision(SkillRevision.newBuilder().build())
            .setScanningConfig(ScanningConfig.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-9310/locations/location-9310/skills/skill-9310";

    Skill actualResponse = client.getSkill(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getSkillExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-9310/locations/location-9310/skills/skill-9310";
      client.getSkill(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateSkillTest() throws Exception {
    Skill expectedResponse =
        Skill.newBuilder()
            .setName(SkillName.of("[PROJECT]", "[LOCATION]", "[SKILL]").toString())
            .setUid("uid115792")
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setDefaultRevision(
                SkillRevisionName.of("[PROJECT]", "[LOCATION]", "[SKILL]", "[REVISION]").toString())
            .setFrontmatter(Frontmatter.newBuilder().build())
            .setSkillId("skillId2147320652")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setPublisher(PublisherName.of("[PROJECT]", "[LOCATION]", "[PUBLISHER]").toString())
            .setInitialRevision(SkillRevision.newBuilder().build())
            .setScanningConfig(ScanningConfig.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateSkillTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    Skill skill =
        Skill.newBuilder()
            .setName(SkillName.of("[PROJECT]", "[LOCATION]", "[SKILL]").toString())
            .setUid("uid115792")
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setDefaultRevision(
                SkillRevisionName.of("[PROJECT]", "[LOCATION]", "[SKILL]", "[REVISION]").toString())
            .setFrontmatter(Frontmatter.newBuilder().build())
            .setSkillId("skillId2147320652")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setPublisher(PublisherName.of("[PROJECT]", "[LOCATION]", "[PUBLISHER]").toString())
            .setInitialRevision(SkillRevision.newBuilder().build())
            .setScanningConfig(ScanningConfig.newBuilder().build())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Skill actualResponse = client.updateSkillAsync(skill, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void updateSkillExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Skill skill =
          Skill.newBuilder()
              .setName(SkillName.of("[PROJECT]", "[LOCATION]", "[SKILL]").toString())
              .setUid("uid115792")
              .setDisplayName("displayName1714148973")
              .setDescription("description-1724546052")
              .setDefaultRevision(
                  SkillRevisionName.of("[PROJECT]", "[LOCATION]", "[SKILL]", "[REVISION]")
                      .toString())
              .setFrontmatter(Frontmatter.newBuilder().build())
              .setSkillId("skillId2147320652")
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .setPublisher(PublisherName.of("[PROJECT]", "[LOCATION]", "[PUBLISHER]").toString())
              .setInitialRevision(SkillRevision.newBuilder().build())
              .setScanningConfig(ScanningConfig.newBuilder().build())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateSkillAsync(skill, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteSkillTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteSkillTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    SkillName name = SkillName.of("[PROJECT]", "[LOCATION]", "[SKILL]");

    client.deleteSkillAsync(name).get();

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteSkillExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SkillName name = SkillName.of("[PROJECT]", "[LOCATION]", "[SKILL]");
      client.deleteSkillAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteSkillTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteSkillTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name = "projects/project-9310/locations/location-9310/skills/skill-9310";

    client.deleteSkillAsync(name).get();

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteSkillExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-9310/locations/location-9310/skills/skill-9310";
      client.deleteSkillAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void listSkillsTest() throws Exception {
    Skill responsesElement = Skill.newBuilder().build();
    ListSkillsResponse expectedResponse =
        ListSkillsResponse.newBuilder()
            .setNextPageToken("")
            .addAllSkills(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListSkillsPagedResponse pagedListResponse = client.listSkills(parent);

    List<Skill> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSkillsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listSkillsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listSkills(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSkillsTest2() throws Exception {
    Skill responsesElement = Skill.newBuilder().build();
    ListSkillsResponse expectedResponse =
        ListSkillsResponse.newBuilder()
            .setNextPageToken("")
            .addAllSkills(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListSkillsPagedResponse pagedListResponse = client.listSkills(parent);

    List<Skill> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSkillsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listSkillsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listSkills(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void searchSkillsTest() throws Exception {
    Skill responsesElement = Skill.newBuilder().build();
    SearchSkillsResponse expectedResponse =
        SearchSkillsResponse.newBuilder()
            .setNextPageToken("")
            .addAllSkills(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    SearchSkillsRequest request =
        SearchSkillsRequest.newBuilder()
            .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
            .setSearchType(SearchType.forNumber(0))
            .setSearchString("searchString120312793")
            .setFilter("filter-1274492040")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    SearchSkillsPagedResponse pagedListResponse = client.searchSkills(request);

    List<Skill> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSkillsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void searchSkillsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SearchSkillsRequest request =
          SearchSkillsRequest.newBuilder()
              .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
              .setSearchType(SearchType.forNumber(0))
              .setSearchString("searchString120312793")
              .setFilter("filter-1274492040")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      client.searchSkills(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createSkillRevisionTest() throws Exception {
    SkillRevision expectedResponse =
        SkillRevision.newBuilder()
            .setName(
                SkillRevisionName.of("[PROJECT]", "[LOCATION]", "[SKILL]", "[REVISION]").toString())
            .setSha256Hash("sha256Hash127958997")
            .setFrontmatter(Frontmatter.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setSizeBytes(-1796325715)
            .setUid("uid115792")
            .setScanResult(SkillRevision.ScanResult.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createSkillRevisionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    SkillName parent = SkillName.of("[PROJECT]", "[LOCATION]", "[SKILL]");
    SkillRevision skillRevision = SkillRevision.newBuilder().build();
    String skillRevisionId = "skillRevisionId-983110777";

    SkillRevision actualResponse =
        client.createSkillRevisionAsync(parent, skillRevision, skillRevisionId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createSkillRevisionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SkillName parent = SkillName.of("[PROJECT]", "[LOCATION]", "[SKILL]");
      SkillRevision skillRevision = SkillRevision.newBuilder().build();
      String skillRevisionId = "skillRevisionId-983110777";
      client.createSkillRevisionAsync(parent, skillRevision, skillRevisionId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createSkillRevisionTest2() throws Exception {
    SkillRevision expectedResponse =
        SkillRevision.newBuilder()
            .setName(
                SkillRevisionName.of("[PROJECT]", "[LOCATION]", "[SKILL]", "[REVISION]").toString())
            .setSha256Hash("sha256Hash127958997")
            .setFrontmatter(Frontmatter.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setSizeBytes(-1796325715)
            .setUid("uid115792")
            .setScanResult(SkillRevision.ScanResult.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createSkillRevisionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-4787/locations/location-4787/skills/skill-4787";
    SkillRevision skillRevision = SkillRevision.newBuilder().build();
    String skillRevisionId = "skillRevisionId-983110777";

    SkillRevision actualResponse =
        client.createSkillRevisionAsync(parent, skillRevision, skillRevisionId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createSkillRevisionExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-4787/locations/location-4787/skills/skill-4787";
      SkillRevision skillRevision = SkillRevision.newBuilder().build();
      String skillRevisionId = "skillRevisionId-983110777";
      client.createSkillRevisionAsync(parent, skillRevision, skillRevisionId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void getSkillRevisionTest() throws Exception {
    SkillRevision expectedResponse =
        SkillRevision.newBuilder()
            .setName(
                SkillRevisionName.of("[PROJECT]", "[LOCATION]", "[SKILL]", "[REVISION]").toString())
            .setSha256Hash("sha256Hash127958997")
            .setFrontmatter(Frontmatter.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setSizeBytes(-1796325715)
            .setUid("uid115792")
            .setScanResult(SkillRevision.ScanResult.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    SkillRevisionName name =
        SkillRevisionName.of("[PROJECT]", "[LOCATION]", "[SKILL]", "[REVISION]");

    SkillRevision actualResponse = client.getSkillRevision(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getSkillRevisionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SkillRevisionName name =
          SkillRevisionName.of("[PROJECT]", "[LOCATION]", "[SKILL]", "[REVISION]");
      client.getSkillRevision(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSkillRevisionTest2() throws Exception {
    SkillRevision expectedResponse =
        SkillRevision.newBuilder()
            .setName(
                SkillRevisionName.of("[PROJECT]", "[LOCATION]", "[SKILL]", "[REVISION]").toString())
            .setSha256Hash("sha256Hash127958997")
            .setFrontmatter(Frontmatter.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setSizeBytes(-1796325715)
            .setUid("uid115792")
            .setScanResult(SkillRevision.ScanResult.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-9446/locations/location-9446/skills/skill-9446/revisions/revision-9446";

    SkillRevision actualResponse = client.getSkillRevision(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getSkillRevisionExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-9446/locations/location-9446/skills/skill-9446/revisions/revision-9446";
      client.getSkillRevision(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteSkillRevisionTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteSkillRevisionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    SkillRevisionName name =
        SkillRevisionName.of("[PROJECT]", "[LOCATION]", "[SKILL]", "[REVISION]");

    client.deleteSkillRevisionAsync(name).get();

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteSkillRevisionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SkillRevisionName name =
          SkillRevisionName.of("[PROJECT]", "[LOCATION]", "[SKILL]", "[REVISION]");
      client.deleteSkillRevisionAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteSkillRevisionTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteSkillRevisionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name =
        "projects/project-9446/locations/location-9446/skills/skill-9446/revisions/revision-9446";

    client.deleteSkillRevisionAsync(name).get();

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteSkillRevisionExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-9446/locations/location-9446/skills/skill-9446/revisions/revision-9446";
      client.deleteSkillRevisionAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void listSkillRevisionsTest() throws Exception {
    SkillRevision responsesElement = SkillRevision.newBuilder().build();
    ListSkillRevisionsResponse expectedResponse =
        ListSkillRevisionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllSkillRevisions(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    SkillName parent = SkillName.of("[PROJECT]", "[LOCATION]", "[SKILL]");

    ListSkillRevisionsPagedResponse pagedListResponse = client.listSkillRevisions(parent);

    List<SkillRevision> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSkillRevisionsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listSkillRevisionsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SkillName parent = SkillName.of("[PROJECT]", "[LOCATION]", "[SKILL]");
      client.listSkillRevisions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSkillRevisionsTest2() throws Exception {
    SkillRevision responsesElement = SkillRevision.newBuilder().build();
    ListSkillRevisionsResponse expectedResponse =
        ListSkillRevisionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllSkillRevisions(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-4787/locations/location-4787/skills/skill-4787";

    ListSkillRevisionsPagedResponse pagedListResponse = client.listSkillRevisions(parent);

    List<SkillRevision> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSkillRevisionsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listSkillRevisionsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-4787/locations/location-4787/skills/skill-4787";
      client.listSkillRevisions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getPublisherTest() throws Exception {
    Publisher expectedResponse =
        Publisher.newBuilder()
            .setName(PublisherName.of("[PROJECT]", "[LOCATION]", "[PUBLISHER]").toString())
            .setVerifiedPrefix("verifiedPrefix250185594")
            .setDisplayName("displayName1714148973")
            .setDocumentationUri("documentationUri-1487620014")
            .setSupportUri("supportUri-613906659")
            .build();
    mockService.addResponse(expectedResponse);

    PublisherName name = PublisherName.of("[PROJECT]", "[LOCATION]", "[PUBLISHER]");

    Publisher actualResponse = client.getPublisher(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getPublisherExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PublisherName name = PublisherName.of("[PROJECT]", "[LOCATION]", "[PUBLISHER]");
      client.getPublisher(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getPublisherTest2() throws Exception {
    Publisher expectedResponse =
        Publisher.newBuilder()
            .setName(PublisherName.of("[PROJECT]", "[LOCATION]", "[PUBLISHER]").toString())
            .setVerifiedPrefix("verifiedPrefix250185594")
            .setDisplayName("displayName1714148973")
            .setDocumentationUri("documentationUri-1487620014")
            .setSupportUri("supportUri-613906659")
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-6489/locations/location-6489/publishers/publisher-6489";

    Publisher actualResponse = client.getPublisher(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getPublisherExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-6489/locations/location-6489/publishers/publisher-6489";
      client.getPublisher(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listPublishersTest() throws Exception {
    Publisher responsesElement = Publisher.newBuilder().build();
    ListPublishersResponse expectedResponse =
        ListPublishersResponse.newBuilder()
            .setNextPageToken("")
            .addAllPublishers(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListPublishersPagedResponse pagedListResponse = client.listPublishers(parent);

    List<Publisher> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPublishersList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listPublishersExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listPublishers(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listPublishersTest2() throws Exception {
    Publisher responsesElement = Publisher.newBuilder().build();
    ListPublishersResponse expectedResponse =
        ListPublishersResponse.newBuilder()
            .setNextPageToken("")
            .addAllPublishers(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListPublishersPagedResponse pagedListResponse = client.listPublishers(parent);

    List<Publisher> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPublishersList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listPublishersExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listPublishers(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAiApplicationTest() throws Exception {
    AiApplication expectedResponse =
        AiApplication.newBuilder()
            .setName(AiApplicationName.of("[PROJECT]", "[LOCATION]", "[AI_APPLICATION]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setAttributes(Attributes.newBuilder().build())
            .setApplicationProperties(ApplicationProperties.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    AiApplicationName name = AiApplicationName.of("[PROJECT]", "[LOCATION]", "[AI_APPLICATION]");

    AiApplication actualResponse = client.getAiApplication(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getAiApplicationExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AiApplicationName name = AiApplicationName.of("[PROJECT]", "[LOCATION]", "[AI_APPLICATION]");
      client.getAiApplication(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAiApplicationTest2() throws Exception {
    AiApplication expectedResponse =
        AiApplication.newBuilder()
            .setName(AiApplicationName.of("[PROJECT]", "[LOCATION]", "[AI_APPLICATION]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setAttributes(Attributes.newBuilder().build())
            .setApplicationProperties(ApplicationProperties.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-8741/locations/location-8741/aiApplications/aiApplication-8741";

    AiApplication actualResponse = client.getAiApplication(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getAiApplicationExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-8741/locations/location-8741/aiApplications/aiApplication-8741";
      client.getAiApplication(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAiApplicationsTest() throws Exception {
    AiApplication responsesElement = AiApplication.newBuilder().build();
    ListAiApplicationsResponse expectedResponse =
        ListAiApplicationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAiApplications(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListAiApplicationsPagedResponse pagedListResponse = client.listAiApplications(parent);

    List<AiApplication> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAiApplicationsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listAiApplicationsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listAiApplications(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAiApplicationsTest2() throws Exception {
    AiApplication responsesElement = AiApplication.newBuilder().build();
    ListAiApplicationsResponse expectedResponse =
        ListAiApplicationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAiApplications(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListAiApplicationsPagedResponse pagedListResponse = client.listAiApplications(parent);

    List<AiApplication> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAiApplicationsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listAiApplicationsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listAiApplications(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAiApplicationAgentTest() throws Exception {
    Agent expectedResponse =
        Agent.newBuilder()
            .setName(
                AgentName.ofProjectLocationAiApplicationAgentName(
                        "[PROJECT]", "[LOCATION]", "[AI_APPLICATION]", "[AGENT]")
                    .toString())
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
    mockService.addResponse(expectedResponse);

    AgentName name =
        AgentName.ofProjectLocationAiApplicationAgentName(
            "[PROJECT]", "[LOCATION]", "[AI_APPLICATION]", "[AGENT]");

    Agent actualResponse = client.getAiApplicationAgent(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getAiApplicationAgentExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AgentName name =
          AgentName.ofProjectLocationAiApplicationAgentName(
              "[PROJECT]", "[LOCATION]", "[AI_APPLICATION]", "[AGENT]");
      client.getAiApplicationAgent(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAiApplicationAgentTest2() throws Exception {
    Agent expectedResponse =
        Agent.newBuilder()
            .setName(
                AgentName.ofProjectLocationAiApplicationAgentName(
                        "[PROJECT]", "[LOCATION]", "[AI_APPLICATION]", "[AGENT]")
                    .toString())
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
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-9267/locations/location-9267/aiApplications/aiApplication-9267/agents/agent-9267";

    Agent actualResponse = client.getAiApplicationAgent(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getAiApplicationAgentExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-9267/locations/location-9267/aiApplications/aiApplication-9267/agents/agent-9267";
      client.getAiApplicationAgent(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAiApplicationAgentsTest() throws Exception {
    Agent responsesElement = Agent.newBuilder().build();
    ListAiApplicationAgentsResponse expectedResponse =
        ListAiApplicationAgentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAgents(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    AiApplicationName parent = AiApplicationName.of("[PROJECT]", "[LOCATION]", "[AI_APPLICATION]");

    ListAiApplicationAgentsPagedResponse pagedListResponse = client.listAiApplicationAgents(parent);

    List<Agent> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAgentsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listAiApplicationAgentsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AiApplicationName parent =
          AiApplicationName.of("[PROJECT]", "[LOCATION]", "[AI_APPLICATION]");
      client.listAiApplicationAgents(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAiApplicationAgentsTest2() throws Exception {
    Agent responsesElement = Agent.newBuilder().build();
    ListAiApplicationAgentsResponse expectedResponse =
        ListAiApplicationAgentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAgents(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent =
        "projects/project-6948/locations/location-6948/aiApplications/aiApplication-6948";

    ListAiApplicationAgentsPagedResponse pagedListResponse = client.listAiApplicationAgents(parent);

    List<Agent> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAgentsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listAiApplicationAgentsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-6948/locations/location-6948/aiApplications/aiApplication-6948";
      client.listAiApplicationAgents(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAiApplicationMcpServerTest() throws Exception {
    McpServer expectedResponse =
        McpServer.newBuilder()
            .setName(
                McpServerName.ofProjectLocationAiApplicationMcpServerName(
                        "[PROJECT]", "[LOCATION]", "[AI_APPLICATION]", "[MCP_SERVER]")
                    .toString())
            .setMcpServerId("mcpServerId298140536")
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllInterfaces(new ArrayList<Interface>())
            .addAllTools(new ArrayList<McpServer.Tool>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllAttributes(new HashMap<String, Struct>())
            .build();
    mockService.addResponse(expectedResponse);

    McpServerName name =
        McpServerName.ofProjectLocationAiApplicationMcpServerName(
            "[PROJECT]", "[LOCATION]", "[AI_APPLICATION]", "[MCP_SERVER]");

    McpServer actualResponse = client.getAiApplicationMcpServer(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getAiApplicationMcpServerExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      McpServerName name =
          McpServerName.ofProjectLocationAiApplicationMcpServerName(
              "[PROJECT]", "[LOCATION]", "[AI_APPLICATION]", "[MCP_SERVER]");
      client.getAiApplicationMcpServer(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAiApplicationMcpServerTest2() throws Exception {
    McpServer expectedResponse =
        McpServer.newBuilder()
            .setName(
                McpServerName.ofProjectLocationAiApplicationMcpServerName(
                        "[PROJECT]", "[LOCATION]", "[AI_APPLICATION]", "[MCP_SERVER]")
                    .toString())
            .setMcpServerId("mcpServerId298140536")
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllInterfaces(new ArrayList<Interface>())
            .addAllTools(new ArrayList<McpServer.Tool>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllAttributes(new HashMap<String, Struct>())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-6507/locations/location-6507/aiApplications/aiApplication-6507/mcpServers/mcpServer-6507";

    McpServer actualResponse = client.getAiApplicationMcpServer(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getAiApplicationMcpServerExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-6507/locations/location-6507/aiApplications/aiApplication-6507/mcpServers/mcpServer-6507";
      client.getAiApplicationMcpServer(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAiApplicationMcpServersTest() throws Exception {
    McpServer responsesElement = McpServer.newBuilder().build();
    ListAiApplicationMcpServersResponse expectedResponse =
        ListAiApplicationMcpServersResponse.newBuilder()
            .setNextPageToken("")
            .addAllMcpServers(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    AiApplicationName parent = AiApplicationName.of("[PROJECT]", "[LOCATION]", "[AI_APPLICATION]");

    ListAiApplicationMcpServersPagedResponse pagedListResponse =
        client.listAiApplicationMcpServers(parent);

    List<McpServer> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMcpServersList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listAiApplicationMcpServersExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AiApplicationName parent =
          AiApplicationName.of("[PROJECT]", "[LOCATION]", "[AI_APPLICATION]");
      client.listAiApplicationMcpServers(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAiApplicationMcpServersTest2() throws Exception {
    McpServer responsesElement = McpServer.newBuilder().build();
    ListAiApplicationMcpServersResponse expectedResponse =
        ListAiApplicationMcpServersResponse.newBuilder()
            .setNextPageToken("")
            .addAllMcpServers(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent =
        "projects/project-6948/locations/location-6948/aiApplications/aiApplication-6948";

    ListAiApplicationMcpServersPagedResponse pagedListResponse =
        client.listAiApplicationMcpServers(parent);

    List<McpServer> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMcpServersList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listAiApplicationMcpServersExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-6948/locations/location-6948/aiApplications/aiApplication-6948";
      client.listAiApplicationMcpServers(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getFindingTest() throws Exception {
    Finding expectedResponse =
        Finding.newBuilder()
            .setName(FindingName.of("[PROJECT]", "[LOCATION]", "[FINDING]").toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setSeverity(Severity.forNumber(0))
            .addAllFiles(new ArrayList<Finding.File>())
            .setDetail("detail-1335224239")
            .setResource("resource-341064690")
            .build();
    mockService.addResponse(expectedResponse);

    FindingName name = FindingName.of("[PROJECT]", "[LOCATION]", "[FINDING]");

    Finding actualResponse = client.getFinding(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getFindingExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      FindingName name = FindingName.of("[PROJECT]", "[LOCATION]", "[FINDING]");
      client.getFinding(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getFindingTest2() throws Exception {
    Finding expectedResponse =
        Finding.newBuilder()
            .setName(FindingName.of("[PROJECT]", "[LOCATION]", "[FINDING]").toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setSeverity(Severity.forNumber(0))
            .addAllFiles(new ArrayList<Finding.File>())
            .setDetail("detail-1335224239")
            .setResource("resource-341064690")
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-1658/locations/location-1658/findings/finding-1658";

    Finding actualResponse = client.getFinding(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getFindingExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-1658/locations/location-1658/findings/finding-1658";
      client.getFinding(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listFindingsTest() throws Exception {
    Finding responsesElement = Finding.newBuilder().build();
    ListFindingsResponse expectedResponse =
        ListFindingsResponse.newBuilder()
            .setNextPageToken("")
            .addAllFindings(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListFindingsPagedResponse pagedListResponse = client.listFindings(parent);

    List<Finding> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getFindingsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listFindingsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listFindings(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listFindingsTest2() throws Exception {
    Finding responsesElement = Finding.newBuilder().build();
    ListFindingsResponse expectedResponse =
        ListFindingsResponse.newBuilder()
            .setNextPageToken("")
            .addAllFindings(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListFindingsPagedResponse pagedListResponse = client.listFindings(parent);

    List<Finding> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getFindingsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listFindingsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listFindings(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAiApplicationEndpointTest() throws Exception {
    Endpoint expectedResponse =
        Endpoint.newBuilder()
            .setName(
                EndpointName.ofProjectLocationAiApplicationEndpointName(
                        "[PROJECT]", "[LOCATION]", "[AI_APPLICATION]", "[ENDPOINT]")
                    .toString())
            .setEndpointId("endpointId-1837754992")
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllInterfaces(new ArrayList<Interface>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllAttributes(new HashMap<String, Struct>())
            .build();
    mockService.addResponse(expectedResponse);

    EndpointName name =
        EndpointName.ofProjectLocationAiApplicationEndpointName(
            "[PROJECT]", "[LOCATION]", "[AI_APPLICATION]", "[ENDPOINT]");

    Endpoint actualResponse = client.getAiApplicationEndpoint(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getAiApplicationEndpointExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      EndpointName name =
          EndpointName.ofProjectLocationAiApplicationEndpointName(
              "[PROJECT]", "[LOCATION]", "[AI_APPLICATION]", "[ENDPOINT]");
      client.getAiApplicationEndpoint(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAiApplicationEndpointTest2() throws Exception {
    Endpoint expectedResponse =
        Endpoint.newBuilder()
            .setName(
                EndpointName.ofProjectLocationAiApplicationEndpointName(
                        "[PROJECT]", "[LOCATION]", "[AI_APPLICATION]", "[ENDPOINT]")
                    .toString())
            .setEndpointId("endpointId-1837754992")
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllInterfaces(new ArrayList<Interface>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllAttributes(new HashMap<String, Struct>())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-5947/locations/location-5947/aiApplications/aiApplication-5947/endpoints/endpoint-5947";

    Endpoint actualResponse = client.getAiApplicationEndpoint(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getAiApplicationEndpointExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-5947/locations/location-5947/aiApplications/aiApplication-5947/endpoints/endpoint-5947";
      client.getAiApplicationEndpoint(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAiApplicationEndpointsTest() throws Exception {
    Endpoint responsesElement = Endpoint.newBuilder().build();
    ListAiApplicationEndpointsResponse expectedResponse =
        ListAiApplicationEndpointsResponse.newBuilder()
            .setNextPageToken("")
            .addAllEndpoints(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    AiApplicationName parent = AiApplicationName.of("[PROJECT]", "[LOCATION]", "[AI_APPLICATION]");

    ListAiApplicationEndpointsPagedResponse pagedListResponse =
        client.listAiApplicationEndpoints(parent);

    List<Endpoint> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEndpointsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listAiApplicationEndpointsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AiApplicationName parent =
          AiApplicationName.of("[PROJECT]", "[LOCATION]", "[AI_APPLICATION]");
      client.listAiApplicationEndpoints(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAiApplicationEndpointsTest2() throws Exception {
    Endpoint responsesElement = Endpoint.newBuilder().build();
    ListAiApplicationEndpointsResponse expectedResponse =
        ListAiApplicationEndpointsResponse.newBuilder()
            .setNextPageToken("")
            .addAllEndpoints(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent =
        "projects/project-6948/locations/location-6948/aiApplications/aiApplication-6948";

    ListAiApplicationEndpointsPagedResponse pagedListResponse =
        client.listAiApplicationEndpoints(parent);

    List<Endpoint> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEndpointsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listAiApplicationEndpointsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-6948/locations/location-6948/aiApplications/aiApplication-6948";
      client.listAiApplicationEndpoints(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSkillEncryptionSpecTest() throws Exception {
    SkillEncryptionSpec expectedResponse =
        SkillEncryptionSpec.newBuilder()
            .setName(SkillEncryptionSpecName.of("[PROJECT]", "[LOCATION]").toString())
            .setCryptoKeyName("cryptoKeyName1447084425")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    SkillEncryptionSpecName name = SkillEncryptionSpecName.of("[PROJECT]", "[LOCATION]");

    SkillEncryptionSpec actualResponse = client.getSkillEncryptionSpec(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getSkillEncryptionSpecExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SkillEncryptionSpecName name = SkillEncryptionSpecName.of("[PROJECT]", "[LOCATION]");
      client.getSkillEncryptionSpec(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSkillEncryptionSpecTest2() throws Exception {
    SkillEncryptionSpec expectedResponse =
        SkillEncryptionSpec.newBuilder()
            .setName(SkillEncryptionSpecName.of("[PROJECT]", "[LOCATION]").toString())
            .setCryptoKeyName("cryptoKeyName1447084425")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-2502/locations/location-2502/skillEncryptionSpec";

    SkillEncryptionSpec actualResponse = client.getSkillEncryptionSpec(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getSkillEncryptionSpecExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-2502/locations/location-2502/skillEncryptionSpec";
      client.getSkillEncryptionSpec(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateSkillEncryptionSpecTest() throws Exception {
    SkillEncryptionSpec expectedResponse =
        SkillEncryptionSpec.newBuilder()
            .setName(SkillEncryptionSpecName.of("[PROJECT]", "[LOCATION]").toString())
            .setCryptoKeyName("cryptoKeyName1447084425")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateSkillEncryptionSpecTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    SkillEncryptionSpec skillEncryptionSpec =
        SkillEncryptionSpec.newBuilder()
            .setName(SkillEncryptionSpecName.of("[PROJECT]", "[LOCATION]").toString())
            .setCryptoKeyName("cryptoKeyName1447084425")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    SkillEncryptionSpec actualResponse =
        client.updateSkillEncryptionSpecAsync(skillEncryptionSpec, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void updateSkillEncryptionSpecExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SkillEncryptionSpec skillEncryptionSpec =
          SkillEncryptionSpec.newBuilder()
              .setName(SkillEncryptionSpecName.of("[PROJECT]", "[LOCATION]").toString())
              .setCryptoKeyName("cryptoKeyName1447084425")
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateSkillEncryptionSpecAsync(skillEncryptionSpec, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(expectedResponse);

    ListLocationsRequest request =
        ListLocationsRequest.newBuilder()
            .setName("projects/project-3664")
            .setFilter("filter-1274492040")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    ListLocationsPagedResponse pagedListResponse = client.listLocations(request);

    List<Location> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLocationsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listLocationsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ListLocationsRequest request =
          ListLocationsRequest.newBuilder()
              .setName("projects/project-3664")
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
    mockService.addResponse(expectedResponse);

    GetLocationRequest request =
        GetLocationRequest.newBuilder()
            .setName("projects/project-9062/locations/location-9062")
            .build();

    Location actualResponse = client.getLocation(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getLocationExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GetLocationRequest request =
          GetLocationRequest.newBuilder()
              .setName("projects/project-9062/locations/location-9062")
              .build();
      client.getLocation(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
