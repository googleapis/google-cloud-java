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

package com.google.cloud.dialogflow.v2;

import static com.google.cloud.dialogflow.v2.AgentsClient.ListLocationsPagedResponse;
import static com.google.cloud.dialogflow.v2.AgentsClient.SearchAgentsPagedResponse;

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
public class AgentsClientTest {
  private static MockAgents mockAgents;
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private AgentsClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockAgents = new MockAgents();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockAgents, mockLocations));
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
    AgentsSettings settings =
        AgentsSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = AgentsClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void getAgentTest() throws Exception {
    Agent expectedResponse =
        Agent.newBuilder()
            .setParent(ProjectName.of("[PROJECT]").toString())
            .setDisplayName("displayName1714148973")
            .setDefaultLanguageCode("defaultLanguageCode2069633606")
            .addAllSupportedLanguageCodes(new ArrayList<String>())
            .setTimeZone("timeZone-2077180903")
            .setDescription("description-1724546052")
            .setAvatarUri("avatarUri-428646061")
            .setEnableLogging(true)
            .setClassificationThreshold(1115810642)
            .build();
    mockAgents.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    Agent actualResponse = client.getAgent(parent);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgents.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAgentRequest actualRequest = ((GetAgentRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAgentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgents.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.getAgent(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAgentTest2() throws Exception {
    Agent expectedResponse =
        Agent.newBuilder()
            .setParent(ProjectName.of("[PROJECT]").toString())
            .setDisplayName("displayName1714148973")
            .setDefaultLanguageCode("defaultLanguageCode2069633606")
            .addAllSupportedLanguageCodes(new ArrayList<String>())
            .setTimeZone("timeZone-2077180903")
            .setDescription("description-1724546052")
            .setAvatarUri("avatarUri-428646061")
            .setEnableLogging(true)
            .setClassificationThreshold(1115810642)
            .build();
    mockAgents.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");

    Agent actualResponse = client.getAgent(parent);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgents.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAgentRequest actualRequest = ((GetAgentRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAgentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgents.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      client.getAgent(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAgentTest3() throws Exception {
    Agent expectedResponse =
        Agent.newBuilder()
            .setParent(ProjectName.of("[PROJECT]").toString())
            .setDisplayName("displayName1714148973")
            .setDefaultLanguageCode("defaultLanguageCode2069633606")
            .addAllSupportedLanguageCodes(new ArrayList<String>())
            .setTimeZone("timeZone-2077180903")
            .setDescription("description-1724546052")
            .setAvatarUri("avatarUri-428646061")
            .setEnableLogging(true)
            .setClassificationThreshold(1115810642)
            .build();
    mockAgents.addResponse(expectedResponse);

    String parent = "parent-995424086";

    Agent actualResponse = client.getAgent(parent);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgents.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAgentRequest actualRequest = ((GetAgentRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAgentExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgents.addException(exception);

    try {
      String parent = "parent-995424086";
      client.getAgent(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void setAgentTest() throws Exception {
    Agent expectedResponse =
        Agent.newBuilder()
            .setParent(ProjectName.of("[PROJECT]").toString())
            .setDisplayName("displayName1714148973")
            .setDefaultLanguageCode("defaultLanguageCode2069633606")
            .addAllSupportedLanguageCodes(new ArrayList<String>())
            .setTimeZone("timeZone-2077180903")
            .setDescription("description-1724546052")
            .setAvatarUri("avatarUri-428646061")
            .setEnableLogging(true)
            .setClassificationThreshold(1115810642)
            .build();
    mockAgents.addResponse(expectedResponse);

    Agent agent = Agent.newBuilder().build();

    Agent actualResponse = client.setAgent(agent);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgents.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SetAgentRequest actualRequest = ((SetAgentRequest) actualRequests.get(0));

    Assert.assertEquals(agent, actualRequest.getAgent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void setAgentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgents.addException(exception);

    try {
      Agent agent = Agent.newBuilder().build();
      client.setAgent(agent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteAgentTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockAgents.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    client.deleteAgent(parent);

    List<AbstractMessage> actualRequests = mockAgents.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteAgentRequest actualRequest = ((DeleteAgentRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteAgentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgents.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.deleteAgent(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteAgentTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockAgents.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");

    client.deleteAgent(parent);

    List<AbstractMessage> actualRequests = mockAgents.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteAgentRequest actualRequest = ((DeleteAgentRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteAgentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgents.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      client.deleteAgent(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteAgentTest3() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockAgents.addResponse(expectedResponse);

    String parent = "parent-995424086";

    client.deleteAgent(parent);

    List<AbstractMessage> actualRequests = mockAgents.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteAgentRequest actualRequest = ((DeleteAgentRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteAgentExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgents.addException(exception);

    try {
      String parent = "parent-995424086";
      client.deleteAgent(parent);
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
    mockAgents.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    SearchAgentsPagedResponse pagedListResponse = client.searchAgents(parent);

    List<Agent> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAgentsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAgents.getRequests();
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
    mockAgents.addException(exception);

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
    mockAgents.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");

    SearchAgentsPagedResponse pagedListResponse = client.searchAgents(parent);

    List<Agent> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAgentsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAgents.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SearchAgentsRequest actualRequest = ((SearchAgentsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void searchAgentsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgents.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      client.searchAgents(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void searchAgentsTest3() throws Exception {
    Agent responsesElement = Agent.newBuilder().build();
    SearchAgentsResponse expectedResponse =
        SearchAgentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAgents(Arrays.asList(responsesElement))
            .build();
    mockAgents.addResponse(expectedResponse);

    String parent = "parent-995424086";

    SearchAgentsPagedResponse pagedListResponse = client.searchAgents(parent);

    List<Agent> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAgentsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAgents.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SearchAgentsRequest actualRequest = ((SearchAgentsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void searchAgentsExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgents.addException(exception);

    try {
      String parent = "parent-995424086";
      client.searchAgents(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void trainAgentTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("trainAgentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAgents.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    client.trainAgentAsync(parent).get();

    List<AbstractMessage> actualRequests = mockAgents.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    TrainAgentRequest actualRequest = ((TrainAgentRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void trainAgentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgents.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.trainAgentAsync(parent).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void trainAgentTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("trainAgentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAgents.addResponse(resultOperation);

    ProjectName parent = ProjectName.of("[PROJECT]");

    client.trainAgentAsync(parent).get();

    List<AbstractMessage> actualRequests = mockAgents.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    TrainAgentRequest actualRequest = ((TrainAgentRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void trainAgentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgents.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      client.trainAgentAsync(parent).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void trainAgentTest3() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("trainAgentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAgents.addResponse(resultOperation);

    String parent = "parent-995424086";

    client.trainAgentAsync(parent).get();

    List<AbstractMessage> actualRequests = mockAgents.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    TrainAgentRequest actualRequest = ((TrainAgentRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void trainAgentExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgents.addException(exception);

    try {
      String parent = "parent-995424086";
      client.trainAgentAsync(parent).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void exportAgentTest() throws Exception {
    ExportAgentResponse expectedResponse = ExportAgentResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("exportAgentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAgents.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ExportAgentResponse actualResponse = client.exportAgentAsync(parent).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgents.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ExportAgentRequest actualRequest = ((ExportAgentRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void exportAgentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgents.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.exportAgentAsync(parent).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void exportAgentTest2() throws Exception {
    ExportAgentResponse expectedResponse = ExportAgentResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("exportAgentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAgents.addResponse(resultOperation);

    ProjectName parent = ProjectName.of("[PROJECT]");

    ExportAgentResponse actualResponse = client.exportAgentAsync(parent).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgents.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ExportAgentRequest actualRequest = ((ExportAgentRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void exportAgentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgents.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      client.exportAgentAsync(parent).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void exportAgentTest3() throws Exception {
    ExportAgentResponse expectedResponse = ExportAgentResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("exportAgentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAgents.addResponse(resultOperation);

    String parent = "parent-995424086";

    ExportAgentResponse actualResponse = client.exportAgentAsync(parent).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgents.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ExportAgentRequest actualRequest = ((ExportAgentRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void exportAgentExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgents.addException(exception);

    try {
      String parent = "parent-995424086";
      client.exportAgentAsync(parent).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void importAgentTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("importAgentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAgents.addResponse(resultOperation);

    ImportAgentRequest request =
        ImportAgentRequest.newBuilder().setParent(ProjectName.of("[PROJECT]").toString()).build();

    client.importAgentAsync(request).get();

    List<AbstractMessage> actualRequests = mockAgents.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ImportAgentRequest actualRequest = ((ImportAgentRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getAgentUri(), actualRequest.getAgentUri());
    Assert.assertEquals(request.getAgentContent(), actualRequest.getAgentContent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void importAgentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgents.addException(exception);

    try {
      ImportAgentRequest request =
          ImportAgentRequest.newBuilder().setParent(ProjectName.of("[PROJECT]").toString()).build();
      client.importAgentAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void restoreAgentTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("restoreAgentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAgents.addResponse(resultOperation);

    RestoreAgentRequest request =
        RestoreAgentRequest.newBuilder().setParent(ProjectName.of("[PROJECT]").toString()).build();

    client.restoreAgentAsync(request).get();

    List<AbstractMessage> actualRequests = mockAgents.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RestoreAgentRequest actualRequest = ((RestoreAgentRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getAgentUri(), actualRequest.getAgentUri());
    Assert.assertEquals(request.getAgentContent(), actualRequest.getAgentContent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void restoreAgentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgents.addException(exception);

    try {
      RestoreAgentRequest request =
          RestoreAgentRequest.newBuilder()
              .setParent(ProjectName.of("[PROJECT]").toString())
              .build();
      client.restoreAgentAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void getValidationResultTest() throws Exception {
    ValidationResult expectedResponse =
        ValidationResult.newBuilder()
            .addAllValidationErrors(new ArrayList<ValidationError>())
            .build();
    mockAgents.addResponse(expectedResponse);

    GetValidationResultRequest request =
        GetValidationResultRequest.newBuilder()
            .setParent(ProjectName.of("[PROJECT]").toString())
            .setLanguageCode("languageCode-2092349083")
            .build();

    ValidationResult actualResponse = client.getValidationResult(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgents.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetValidationResultRequest actualRequest = ((GetValidationResultRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getLanguageCode(), actualRequest.getLanguageCode());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getValidationResultExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgents.addException(exception);

    try {
      GetValidationResultRequest request =
          GetValidationResultRequest.newBuilder()
              .setParent(ProjectName.of("[PROJECT]").toString())
              .setLanguageCode("languageCode-2092349083")
              .build();
      client.getValidationResult(request);
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
