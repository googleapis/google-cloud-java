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

package com.google.cloud.dialogflow.v2;

import static com.google.cloud.dialogflow.v2.CompanionAgentsClient.ListCompanionAgentsPagedResponse;
import static com.google.cloud.dialogflow.v2.CompanionAgentsClient.ListLocationsPagedResponse;

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
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class CompanionAgentsClientTest {
  private static MockCompanionAgents mockCompanionAgents;
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private CompanionAgentsClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockCompanionAgents = new MockCompanionAgents();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockCompanionAgents, mockLocations));
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
    CompanionAgentsSettings settings =
        CompanionAgentsSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = CompanionAgentsClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createCompanionAgentTest() throws Exception {
    CompanionAgent expectedResponse =
        CompanionAgent.newBuilder()
            .setName(
                CompanionAgentName.of("[PROJECT]", "[LOCATION]", "[COMPANION_AGENT]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllToolsetTools(new ArrayList<ToolsetTool>())
            .addAllCesToolSpecs(new ArrayList<CesToolSpec>())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllSkillConfigs(new ArrayList<CompanionAgent.SkillConfig>())
            .build();
    mockCompanionAgents.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    CompanionAgent companionAgent = CompanionAgent.newBuilder().build();
    String companionAgentId = "companionAgentId-580252076";

    CompanionAgent actualResponse =
        client.createCompanionAgent(parent, companionAgent, companionAgentId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCompanionAgents.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateCompanionAgentRequest actualRequest =
        ((CreateCompanionAgentRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(companionAgent, actualRequest.getCompanionAgent());
    Assert.assertEquals(companionAgentId, actualRequest.getCompanionAgentId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createCompanionAgentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCompanionAgents.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      CompanionAgent companionAgent = CompanionAgent.newBuilder().build();
      String companionAgentId = "companionAgentId-580252076";
      client.createCompanionAgent(parent, companionAgent, companionAgentId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createCompanionAgentTest2() throws Exception {
    CompanionAgent expectedResponse =
        CompanionAgent.newBuilder()
            .setName(
                CompanionAgentName.of("[PROJECT]", "[LOCATION]", "[COMPANION_AGENT]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllToolsetTools(new ArrayList<ToolsetTool>())
            .addAllCesToolSpecs(new ArrayList<CesToolSpec>())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllSkillConfigs(new ArrayList<CompanionAgent.SkillConfig>())
            .build();
    mockCompanionAgents.addResponse(expectedResponse);

    String parent = "parent-995424086";
    CompanionAgent companionAgent = CompanionAgent.newBuilder().build();
    String companionAgentId = "companionAgentId-580252076";

    CompanionAgent actualResponse =
        client.createCompanionAgent(parent, companionAgent, companionAgentId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCompanionAgents.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateCompanionAgentRequest actualRequest =
        ((CreateCompanionAgentRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(companionAgent, actualRequest.getCompanionAgent());
    Assert.assertEquals(companionAgentId, actualRequest.getCompanionAgentId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createCompanionAgentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCompanionAgents.addException(exception);

    try {
      String parent = "parent-995424086";
      CompanionAgent companionAgent = CompanionAgent.newBuilder().build();
      String companionAgentId = "companionAgentId-580252076";
      client.createCompanionAgent(parent, companionAgent, companionAgentId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getCompanionAgentTest() throws Exception {
    CompanionAgent expectedResponse =
        CompanionAgent.newBuilder()
            .setName(
                CompanionAgentName.of("[PROJECT]", "[LOCATION]", "[COMPANION_AGENT]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllToolsetTools(new ArrayList<ToolsetTool>())
            .addAllCesToolSpecs(new ArrayList<CesToolSpec>())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllSkillConfigs(new ArrayList<CompanionAgent.SkillConfig>())
            .build();
    mockCompanionAgents.addResponse(expectedResponse);

    CompanionAgentName name = CompanionAgentName.of("[PROJECT]", "[LOCATION]", "[COMPANION_AGENT]");

    CompanionAgent actualResponse = client.getCompanionAgent(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCompanionAgents.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetCompanionAgentRequest actualRequest = ((GetCompanionAgentRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getCompanionAgentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCompanionAgents.addException(exception);

    try {
      CompanionAgentName name =
          CompanionAgentName.of("[PROJECT]", "[LOCATION]", "[COMPANION_AGENT]");
      client.getCompanionAgent(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getCompanionAgentTest2() throws Exception {
    CompanionAgent expectedResponse =
        CompanionAgent.newBuilder()
            .setName(
                CompanionAgentName.of("[PROJECT]", "[LOCATION]", "[COMPANION_AGENT]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllToolsetTools(new ArrayList<ToolsetTool>())
            .addAllCesToolSpecs(new ArrayList<CesToolSpec>())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllSkillConfigs(new ArrayList<CompanionAgent.SkillConfig>())
            .build();
    mockCompanionAgents.addResponse(expectedResponse);

    String name = "name3373707";

    CompanionAgent actualResponse = client.getCompanionAgent(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCompanionAgents.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetCompanionAgentRequest actualRequest = ((GetCompanionAgentRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getCompanionAgentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCompanionAgents.addException(exception);

    try {
      String name = "name3373707";
      client.getCompanionAgent(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateCompanionAgentTest() throws Exception {
    CompanionAgent expectedResponse =
        CompanionAgent.newBuilder()
            .setName(
                CompanionAgentName.of("[PROJECT]", "[LOCATION]", "[COMPANION_AGENT]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllToolsetTools(new ArrayList<ToolsetTool>())
            .addAllCesToolSpecs(new ArrayList<CesToolSpec>())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllSkillConfigs(new ArrayList<CompanionAgent.SkillConfig>())
            .build();
    mockCompanionAgents.addResponse(expectedResponse);

    CompanionAgent companionAgent = CompanionAgent.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    CompanionAgent actualResponse = client.updateCompanionAgent(companionAgent, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCompanionAgents.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateCompanionAgentRequest actualRequest =
        ((UpdateCompanionAgentRequest) actualRequests.get(0));

    Assert.assertEquals(companionAgent, actualRequest.getCompanionAgent());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateCompanionAgentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCompanionAgents.addException(exception);

    try {
      CompanionAgent companionAgent = CompanionAgent.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateCompanionAgent(companionAgent, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteCompanionAgentTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockCompanionAgents.addResponse(expectedResponse);

    CompanionAgentName name = CompanionAgentName.of("[PROJECT]", "[LOCATION]", "[COMPANION_AGENT]");

    client.deleteCompanionAgent(name);

    List<AbstractMessage> actualRequests = mockCompanionAgents.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteCompanionAgentRequest actualRequest =
        ((DeleteCompanionAgentRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteCompanionAgentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCompanionAgents.addException(exception);

    try {
      CompanionAgentName name =
          CompanionAgentName.of("[PROJECT]", "[LOCATION]", "[COMPANION_AGENT]");
      client.deleteCompanionAgent(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteCompanionAgentTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockCompanionAgents.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteCompanionAgent(name);

    List<AbstractMessage> actualRequests = mockCompanionAgents.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteCompanionAgentRequest actualRequest =
        ((DeleteCompanionAgentRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteCompanionAgentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCompanionAgents.addException(exception);

    try {
      String name = "name3373707";
      client.deleteCompanionAgent(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listCompanionAgentsTest() throws Exception {
    CompanionAgent responsesElement = CompanionAgent.newBuilder().build();
    ListCompanionAgentsResponse expectedResponse =
        ListCompanionAgentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllCompanionAgents(Arrays.asList(responsesElement))
            .build();
    mockCompanionAgents.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListCompanionAgentsPagedResponse pagedListResponse = client.listCompanionAgents(parent);

    List<CompanionAgent> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCompanionAgentsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCompanionAgents.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListCompanionAgentsRequest actualRequest = ((ListCompanionAgentsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listCompanionAgentsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCompanionAgents.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listCompanionAgents(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listCompanionAgentsTest2() throws Exception {
    CompanionAgent responsesElement = CompanionAgent.newBuilder().build();
    ListCompanionAgentsResponse expectedResponse =
        ListCompanionAgentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllCompanionAgents(Arrays.asList(responsesElement))
            .build();
    mockCompanionAgents.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListCompanionAgentsPagedResponse pagedListResponse = client.listCompanionAgents(parent);

    List<CompanionAgent> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCompanionAgentsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCompanionAgents.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListCompanionAgentsRequest actualRequest = ((ListCompanionAgentsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listCompanionAgentsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCompanionAgents.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listCompanionAgents(parent);
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
