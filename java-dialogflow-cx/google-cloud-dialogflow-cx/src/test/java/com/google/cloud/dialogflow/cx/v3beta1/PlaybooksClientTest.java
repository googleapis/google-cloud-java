/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.dialogflow.cx.v3beta1;

import static com.google.cloud.dialogflow.cx.v3beta1.PlaybooksClient.ListLocationsPagedResponse;
import static com.google.cloud.dialogflow.cx.v3beta1.PlaybooksClient.ListPlaybookVersionsPagedResponse;
import static com.google.cloud.dialogflow.cx.v3beta1.PlaybooksClient.ListPlaybooksPagedResponse;

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
public class PlaybooksClientTest {
  private static MockLocations mockLocations;
  private static MockPlaybooks mockPlaybooks;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private PlaybooksClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockPlaybooks = new MockPlaybooks();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockPlaybooks, mockLocations));
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
    PlaybooksSettings settings =
        PlaybooksSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = PlaybooksClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createPlaybookTest() throws Exception {
    Playbook expectedResponse =
        Playbook.newBuilder()
            .setName(PlaybookName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[PLAYBOOK]").toString())
            .setDisplayName("displayName1714148973")
            .setGoal("goal3178259")
            .addAllInputParameterDefinitions(new ArrayList<ParameterDefinition>())
            .addAllOutputParameterDefinitions(new ArrayList<ParameterDefinition>())
            .addAllSteps(new ArrayList<Playbook.Step>())
            .setTokenCount(-1164226743)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllReferencedPlaybooks(new ArrayList<String>())
            .addAllReferencedFlows(new ArrayList<String>())
            .addAllReferencedTools(new ArrayList<String>())
            .setLlmModelSettings(LlmModelSettings.newBuilder().build())
            .build();
    mockPlaybooks.addResponse(expectedResponse);

    AgentName parent = AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]");
    Playbook playbook = Playbook.newBuilder().build();

    Playbook actualResponse = client.createPlaybook(parent, playbook);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPlaybooks.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreatePlaybookRequest actualRequest = ((CreatePlaybookRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(playbook, actualRequest.getPlaybook());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createPlaybookExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPlaybooks.addException(exception);

    try {
      AgentName parent = AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]");
      Playbook playbook = Playbook.newBuilder().build();
      client.createPlaybook(parent, playbook);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createPlaybookTest2() throws Exception {
    Playbook expectedResponse =
        Playbook.newBuilder()
            .setName(PlaybookName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[PLAYBOOK]").toString())
            .setDisplayName("displayName1714148973")
            .setGoal("goal3178259")
            .addAllInputParameterDefinitions(new ArrayList<ParameterDefinition>())
            .addAllOutputParameterDefinitions(new ArrayList<ParameterDefinition>())
            .addAllSteps(new ArrayList<Playbook.Step>())
            .setTokenCount(-1164226743)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllReferencedPlaybooks(new ArrayList<String>())
            .addAllReferencedFlows(new ArrayList<String>())
            .addAllReferencedTools(new ArrayList<String>())
            .setLlmModelSettings(LlmModelSettings.newBuilder().build())
            .build();
    mockPlaybooks.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Playbook playbook = Playbook.newBuilder().build();

    Playbook actualResponse = client.createPlaybook(parent, playbook);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPlaybooks.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreatePlaybookRequest actualRequest = ((CreatePlaybookRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(playbook, actualRequest.getPlaybook());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createPlaybookExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPlaybooks.addException(exception);

    try {
      String parent = "parent-995424086";
      Playbook playbook = Playbook.newBuilder().build();
      client.createPlaybook(parent, playbook);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deletePlaybookTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockPlaybooks.addResponse(expectedResponse);

    PlaybookName name = PlaybookName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[PLAYBOOK]");

    client.deletePlaybook(name);

    List<AbstractMessage> actualRequests = mockPlaybooks.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeletePlaybookRequest actualRequest = ((DeletePlaybookRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deletePlaybookExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPlaybooks.addException(exception);

    try {
      PlaybookName name = PlaybookName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[PLAYBOOK]");
      client.deletePlaybook(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deletePlaybookTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockPlaybooks.addResponse(expectedResponse);

    String name = "name3373707";

    client.deletePlaybook(name);

    List<AbstractMessage> actualRequests = mockPlaybooks.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeletePlaybookRequest actualRequest = ((DeletePlaybookRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deletePlaybookExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPlaybooks.addException(exception);

    try {
      String name = "name3373707";
      client.deletePlaybook(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listPlaybooksTest() throws Exception {
    Playbook responsesElement = Playbook.newBuilder().build();
    ListPlaybooksResponse expectedResponse =
        ListPlaybooksResponse.newBuilder()
            .setNextPageToken("")
            .addAllPlaybooks(Arrays.asList(responsesElement))
            .build();
    mockPlaybooks.addResponse(expectedResponse);

    AgentName parent = AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]");

    ListPlaybooksPagedResponse pagedListResponse = client.listPlaybooks(parent);

    List<Playbook> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPlaybooksList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockPlaybooks.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListPlaybooksRequest actualRequest = ((ListPlaybooksRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listPlaybooksExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPlaybooks.addException(exception);

    try {
      AgentName parent = AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]");
      client.listPlaybooks(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listPlaybooksTest2() throws Exception {
    Playbook responsesElement = Playbook.newBuilder().build();
    ListPlaybooksResponse expectedResponse =
        ListPlaybooksResponse.newBuilder()
            .setNextPageToken("")
            .addAllPlaybooks(Arrays.asList(responsesElement))
            .build();
    mockPlaybooks.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListPlaybooksPagedResponse pagedListResponse = client.listPlaybooks(parent);

    List<Playbook> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPlaybooksList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockPlaybooks.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListPlaybooksRequest actualRequest = ((ListPlaybooksRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listPlaybooksExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPlaybooks.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listPlaybooks(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getPlaybookTest() throws Exception {
    Playbook expectedResponse =
        Playbook.newBuilder()
            .setName(PlaybookName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[PLAYBOOK]").toString())
            .setDisplayName("displayName1714148973")
            .setGoal("goal3178259")
            .addAllInputParameterDefinitions(new ArrayList<ParameterDefinition>())
            .addAllOutputParameterDefinitions(new ArrayList<ParameterDefinition>())
            .addAllSteps(new ArrayList<Playbook.Step>())
            .setTokenCount(-1164226743)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllReferencedPlaybooks(new ArrayList<String>())
            .addAllReferencedFlows(new ArrayList<String>())
            .addAllReferencedTools(new ArrayList<String>())
            .setLlmModelSettings(LlmModelSettings.newBuilder().build())
            .build();
    mockPlaybooks.addResponse(expectedResponse);

    PlaybookName name = PlaybookName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[PLAYBOOK]");

    Playbook actualResponse = client.getPlaybook(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPlaybooks.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetPlaybookRequest actualRequest = ((GetPlaybookRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getPlaybookExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPlaybooks.addException(exception);

    try {
      PlaybookName name = PlaybookName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[PLAYBOOK]");
      client.getPlaybook(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getPlaybookTest2() throws Exception {
    Playbook expectedResponse =
        Playbook.newBuilder()
            .setName(PlaybookName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[PLAYBOOK]").toString())
            .setDisplayName("displayName1714148973")
            .setGoal("goal3178259")
            .addAllInputParameterDefinitions(new ArrayList<ParameterDefinition>())
            .addAllOutputParameterDefinitions(new ArrayList<ParameterDefinition>())
            .addAllSteps(new ArrayList<Playbook.Step>())
            .setTokenCount(-1164226743)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllReferencedPlaybooks(new ArrayList<String>())
            .addAllReferencedFlows(new ArrayList<String>())
            .addAllReferencedTools(new ArrayList<String>())
            .setLlmModelSettings(LlmModelSettings.newBuilder().build())
            .build();
    mockPlaybooks.addResponse(expectedResponse);

    String name = "name3373707";

    Playbook actualResponse = client.getPlaybook(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPlaybooks.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetPlaybookRequest actualRequest = ((GetPlaybookRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getPlaybookExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPlaybooks.addException(exception);

    try {
      String name = "name3373707";
      client.getPlaybook(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updatePlaybookTest() throws Exception {
    Playbook expectedResponse =
        Playbook.newBuilder()
            .setName(PlaybookName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[PLAYBOOK]").toString())
            .setDisplayName("displayName1714148973")
            .setGoal("goal3178259")
            .addAllInputParameterDefinitions(new ArrayList<ParameterDefinition>())
            .addAllOutputParameterDefinitions(new ArrayList<ParameterDefinition>())
            .addAllSteps(new ArrayList<Playbook.Step>())
            .setTokenCount(-1164226743)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllReferencedPlaybooks(new ArrayList<String>())
            .addAllReferencedFlows(new ArrayList<String>())
            .addAllReferencedTools(new ArrayList<String>())
            .setLlmModelSettings(LlmModelSettings.newBuilder().build())
            .build();
    mockPlaybooks.addResponse(expectedResponse);

    Playbook playbook = Playbook.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Playbook actualResponse = client.updatePlaybook(playbook, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPlaybooks.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdatePlaybookRequest actualRequest = ((UpdatePlaybookRequest) actualRequests.get(0));

    Assert.assertEquals(playbook, actualRequest.getPlaybook());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updatePlaybookExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPlaybooks.addException(exception);

    try {
      Playbook playbook = Playbook.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updatePlaybook(playbook, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createPlaybookVersionTest() throws Exception {
    PlaybookVersion expectedResponse =
        PlaybookVersion.newBuilder()
            .setName(
                PlaybookVersionName.of(
                        "[PROJECT]", "[LOCATION]", "[AGENT]", "[PLAYBOOK]", "[VERSION]")
                    .toString())
            .setDescription("description-1724546052")
            .setPlaybook(Playbook.newBuilder().build())
            .addAllExamples(new ArrayList<Example>())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockPlaybooks.addResponse(expectedResponse);

    PlaybookName parent = PlaybookName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[PLAYBOOK]");
    PlaybookVersion playbookVersion = PlaybookVersion.newBuilder().build();

    PlaybookVersion actualResponse = client.createPlaybookVersion(parent, playbookVersion);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPlaybooks.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreatePlaybookVersionRequest actualRequest =
        ((CreatePlaybookVersionRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(playbookVersion, actualRequest.getPlaybookVersion());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createPlaybookVersionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPlaybooks.addException(exception);

    try {
      PlaybookName parent = PlaybookName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[PLAYBOOK]");
      PlaybookVersion playbookVersion = PlaybookVersion.newBuilder().build();
      client.createPlaybookVersion(parent, playbookVersion);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createPlaybookVersionTest2() throws Exception {
    PlaybookVersion expectedResponse =
        PlaybookVersion.newBuilder()
            .setName(
                PlaybookVersionName.of(
                        "[PROJECT]", "[LOCATION]", "[AGENT]", "[PLAYBOOK]", "[VERSION]")
                    .toString())
            .setDescription("description-1724546052")
            .setPlaybook(Playbook.newBuilder().build())
            .addAllExamples(new ArrayList<Example>())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockPlaybooks.addResponse(expectedResponse);

    String parent = "parent-995424086";
    PlaybookVersion playbookVersion = PlaybookVersion.newBuilder().build();

    PlaybookVersion actualResponse = client.createPlaybookVersion(parent, playbookVersion);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPlaybooks.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreatePlaybookVersionRequest actualRequest =
        ((CreatePlaybookVersionRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(playbookVersion, actualRequest.getPlaybookVersion());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createPlaybookVersionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPlaybooks.addException(exception);

    try {
      String parent = "parent-995424086";
      PlaybookVersion playbookVersion = PlaybookVersion.newBuilder().build();
      client.createPlaybookVersion(parent, playbookVersion);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getPlaybookVersionTest() throws Exception {
    PlaybookVersion expectedResponse =
        PlaybookVersion.newBuilder()
            .setName(
                PlaybookVersionName.of(
                        "[PROJECT]", "[LOCATION]", "[AGENT]", "[PLAYBOOK]", "[VERSION]")
                    .toString())
            .setDescription("description-1724546052")
            .setPlaybook(Playbook.newBuilder().build())
            .addAllExamples(new ArrayList<Example>())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockPlaybooks.addResponse(expectedResponse);

    PlaybookVersionName name =
        PlaybookVersionName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[PLAYBOOK]", "[VERSION]");

    PlaybookVersion actualResponse = client.getPlaybookVersion(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPlaybooks.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetPlaybookVersionRequest actualRequest = ((GetPlaybookVersionRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getPlaybookVersionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPlaybooks.addException(exception);

    try {
      PlaybookVersionName name =
          PlaybookVersionName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[PLAYBOOK]", "[VERSION]");
      client.getPlaybookVersion(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getPlaybookVersionTest2() throws Exception {
    PlaybookVersion expectedResponse =
        PlaybookVersion.newBuilder()
            .setName(
                PlaybookVersionName.of(
                        "[PROJECT]", "[LOCATION]", "[AGENT]", "[PLAYBOOK]", "[VERSION]")
                    .toString())
            .setDescription("description-1724546052")
            .setPlaybook(Playbook.newBuilder().build())
            .addAllExamples(new ArrayList<Example>())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockPlaybooks.addResponse(expectedResponse);

    String name = "name3373707";

    PlaybookVersion actualResponse = client.getPlaybookVersion(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPlaybooks.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetPlaybookVersionRequest actualRequest = ((GetPlaybookVersionRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getPlaybookVersionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPlaybooks.addException(exception);

    try {
      String name = "name3373707";
      client.getPlaybookVersion(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listPlaybookVersionsTest() throws Exception {
    PlaybookVersion responsesElement = PlaybookVersion.newBuilder().build();
    ListPlaybookVersionsResponse expectedResponse =
        ListPlaybookVersionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllPlaybookVersions(Arrays.asList(responsesElement))
            .build();
    mockPlaybooks.addResponse(expectedResponse);

    PlaybookName parent = PlaybookName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[PLAYBOOK]");

    ListPlaybookVersionsPagedResponse pagedListResponse = client.listPlaybookVersions(parent);

    List<PlaybookVersion> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPlaybookVersionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockPlaybooks.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListPlaybookVersionsRequest actualRequest =
        ((ListPlaybookVersionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listPlaybookVersionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPlaybooks.addException(exception);

    try {
      PlaybookName parent = PlaybookName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[PLAYBOOK]");
      client.listPlaybookVersions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listPlaybookVersionsTest2() throws Exception {
    PlaybookVersion responsesElement = PlaybookVersion.newBuilder().build();
    ListPlaybookVersionsResponse expectedResponse =
        ListPlaybookVersionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllPlaybookVersions(Arrays.asList(responsesElement))
            .build();
    mockPlaybooks.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListPlaybookVersionsPagedResponse pagedListResponse = client.listPlaybookVersions(parent);

    List<PlaybookVersion> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPlaybookVersionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockPlaybooks.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListPlaybookVersionsRequest actualRequest =
        ((ListPlaybookVersionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listPlaybookVersionsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPlaybooks.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listPlaybookVersions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deletePlaybookVersionTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockPlaybooks.addResponse(expectedResponse);

    PlaybookVersionName name =
        PlaybookVersionName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[PLAYBOOK]", "[VERSION]");

    client.deletePlaybookVersion(name);

    List<AbstractMessage> actualRequests = mockPlaybooks.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeletePlaybookVersionRequest actualRequest =
        ((DeletePlaybookVersionRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deletePlaybookVersionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPlaybooks.addException(exception);

    try {
      PlaybookVersionName name =
          PlaybookVersionName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[PLAYBOOK]", "[VERSION]");
      client.deletePlaybookVersion(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deletePlaybookVersionTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockPlaybooks.addResponse(expectedResponse);

    String name = "name3373707";

    client.deletePlaybookVersion(name);

    List<AbstractMessage> actualRequests = mockPlaybooks.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeletePlaybookVersionRequest actualRequest =
        ((DeletePlaybookVersionRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deletePlaybookVersionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPlaybooks.addException(exception);

    try {
      String name = "name3373707";
      client.deletePlaybookVersion(name);
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
