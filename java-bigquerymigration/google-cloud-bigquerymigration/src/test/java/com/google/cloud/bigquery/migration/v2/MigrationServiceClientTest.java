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

package com.google.cloud.bigquery.migration.v2;

import static com.google.cloud.bigquery.migration.v2.MigrationServiceClient.ListMigrationSubtasksPagedResponse;
import static com.google.cloud.bigquery.migration.v2.MigrationServiceClient.ListMigrationWorkflowsPagedResponse;

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
import com.google.protobuf.Timestamp;
import com.google.rpc.ErrorInfo;
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
public class MigrationServiceClientTest {
  private static MockMigrationService mockMigrationService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private MigrationServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockMigrationService = new MockMigrationService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockMigrationService));
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
    MigrationServiceSettings settings =
        MigrationServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = MigrationServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createMigrationWorkflowTest() throws Exception {
    MigrationWorkflow expectedResponse =
        MigrationWorkflow.newBuilder()
            .setName(MigrationWorkflowName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]").toString())
            .setDisplayName("displayName1714148973")
            .putAllTasks(new HashMap<String, MigrationTask>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setLastUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockMigrationService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    MigrationWorkflow migrationWorkflow = MigrationWorkflow.newBuilder().build();

    MigrationWorkflow actualResponse = client.createMigrationWorkflow(parent, migrationWorkflow);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMigrationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateMigrationWorkflowRequest actualRequest =
        ((CreateMigrationWorkflowRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(migrationWorkflow, actualRequest.getMigrationWorkflow());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createMigrationWorkflowExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMigrationService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      MigrationWorkflow migrationWorkflow = MigrationWorkflow.newBuilder().build();
      client.createMigrationWorkflow(parent, migrationWorkflow);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createMigrationWorkflowTest2() throws Exception {
    MigrationWorkflow expectedResponse =
        MigrationWorkflow.newBuilder()
            .setName(MigrationWorkflowName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]").toString())
            .setDisplayName("displayName1714148973")
            .putAllTasks(new HashMap<String, MigrationTask>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setLastUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockMigrationService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    MigrationWorkflow migrationWorkflow = MigrationWorkflow.newBuilder().build();

    MigrationWorkflow actualResponse = client.createMigrationWorkflow(parent, migrationWorkflow);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMigrationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateMigrationWorkflowRequest actualRequest =
        ((CreateMigrationWorkflowRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(migrationWorkflow, actualRequest.getMigrationWorkflow());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createMigrationWorkflowExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMigrationService.addException(exception);

    try {
      String parent = "parent-995424086";
      MigrationWorkflow migrationWorkflow = MigrationWorkflow.newBuilder().build();
      client.createMigrationWorkflow(parent, migrationWorkflow);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getMigrationWorkflowTest() throws Exception {
    MigrationWorkflow expectedResponse =
        MigrationWorkflow.newBuilder()
            .setName(MigrationWorkflowName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]").toString())
            .setDisplayName("displayName1714148973")
            .putAllTasks(new HashMap<String, MigrationTask>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setLastUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockMigrationService.addResponse(expectedResponse);

    MigrationWorkflowName name = MigrationWorkflowName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]");

    MigrationWorkflow actualResponse = client.getMigrationWorkflow(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMigrationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetMigrationWorkflowRequest actualRequest =
        ((GetMigrationWorkflowRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getMigrationWorkflowExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMigrationService.addException(exception);

    try {
      MigrationWorkflowName name =
          MigrationWorkflowName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]");
      client.getMigrationWorkflow(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getMigrationWorkflowTest2() throws Exception {
    MigrationWorkflow expectedResponse =
        MigrationWorkflow.newBuilder()
            .setName(MigrationWorkflowName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]").toString())
            .setDisplayName("displayName1714148973")
            .putAllTasks(new HashMap<String, MigrationTask>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setLastUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockMigrationService.addResponse(expectedResponse);

    String name = "name3373707";

    MigrationWorkflow actualResponse = client.getMigrationWorkflow(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMigrationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetMigrationWorkflowRequest actualRequest =
        ((GetMigrationWorkflowRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getMigrationWorkflowExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMigrationService.addException(exception);

    try {
      String name = "name3373707";
      client.getMigrationWorkflow(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listMigrationWorkflowsTest() throws Exception {
    MigrationWorkflow responsesElement = MigrationWorkflow.newBuilder().build();
    ListMigrationWorkflowsResponse expectedResponse =
        ListMigrationWorkflowsResponse.newBuilder()
            .setNextPageToken("")
            .addAllMigrationWorkflows(Arrays.asList(responsesElement))
            .build();
    mockMigrationService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListMigrationWorkflowsPagedResponse pagedListResponse = client.listMigrationWorkflows(parent);

    List<MigrationWorkflow> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMigrationWorkflowsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockMigrationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListMigrationWorkflowsRequest actualRequest =
        ((ListMigrationWorkflowsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listMigrationWorkflowsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMigrationService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listMigrationWorkflows(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listMigrationWorkflowsTest2() throws Exception {
    MigrationWorkflow responsesElement = MigrationWorkflow.newBuilder().build();
    ListMigrationWorkflowsResponse expectedResponse =
        ListMigrationWorkflowsResponse.newBuilder()
            .setNextPageToken("")
            .addAllMigrationWorkflows(Arrays.asList(responsesElement))
            .build();
    mockMigrationService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListMigrationWorkflowsPagedResponse pagedListResponse = client.listMigrationWorkflows(parent);

    List<MigrationWorkflow> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMigrationWorkflowsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockMigrationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListMigrationWorkflowsRequest actualRequest =
        ((ListMigrationWorkflowsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listMigrationWorkflowsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMigrationService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listMigrationWorkflows(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteMigrationWorkflowTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockMigrationService.addResponse(expectedResponse);

    MigrationWorkflowName name = MigrationWorkflowName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]");

    client.deleteMigrationWorkflow(name);

    List<AbstractMessage> actualRequests = mockMigrationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteMigrationWorkflowRequest actualRequest =
        ((DeleteMigrationWorkflowRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteMigrationWorkflowExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMigrationService.addException(exception);

    try {
      MigrationWorkflowName name =
          MigrationWorkflowName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]");
      client.deleteMigrationWorkflow(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteMigrationWorkflowTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockMigrationService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteMigrationWorkflow(name);

    List<AbstractMessage> actualRequests = mockMigrationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteMigrationWorkflowRequest actualRequest =
        ((DeleteMigrationWorkflowRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteMigrationWorkflowExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMigrationService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteMigrationWorkflow(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void startMigrationWorkflowTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockMigrationService.addResponse(expectedResponse);

    MigrationWorkflowName name = MigrationWorkflowName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]");

    client.startMigrationWorkflow(name);

    List<AbstractMessage> actualRequests = mockMigrationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    StartMigrationWorkflowRequest actualRequest =
        ((StartMigrationWorkflowRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void startMigrationWorkflowExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMigrationService.addException(exception);

    try {
      MigrationWorkflowName name =
          MigrationWorkflowName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]");
      client.startMigrationWorkflow(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void startMigrationWorkflowTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockMigrationService.addResponse(expectedResponse);

    String name = "name3373707";

    client.startMigrationWorkflow(name);

    List<AbstractMessage> actualRequests = mockMigrationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    StartMigrationWorkflowRequest actualRequest =
        ((StartMigrationWorkflowRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void startMigrationWorkflowExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMigrationService.addException(exception);

    try {
      String name = "name3373707";
      client.startMigrationWorkflow(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getMigrationSubtaskTest() throws Exception {
    MigrationSubtask expectedResponse =
        MigrationSubtask.newBuilder()
            .setName(
                MigrationSubtaskName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]", "[SUBTASK]")
                    .toString())
            .setTaskId("taskId-880873088")
            .setType("type3575610")
            .setProcessingError(ErrorInfo.newBuilder().build())
            .addAllResourceErrorDetails(new ArrayList<ResourceErrorDetail>())
            .setResourceErrorCount(-929997465)
            .setCreateTime(Timestamp.newBuilder().build())
            .setLastUpdateTime(Timestamp.newBuilder().build())
            .addAllMetrics(new ArrayList<TimeSeries>())
            .build();
    mockMigrationService.addResponse(expectedResponse);

    MigrationSubtaskName name =
        MigrationSubtaskName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]", "[SUBTASK]");

    MigrationSubtask actualResponse = client.getMigrationSubtask(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMigrationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetMigrationSubtaskRequest actualRequest = ((GetMigrationSubtaskRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getMigrationSubtaskExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMigrationService.addException(exception);

    try {
      MigrationSubtaskName name =
          MigrationSubtaskName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]", "[SUBTASK]");
      client.getMigrationSubtask(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getMigrationSubtaskTest2() throws Exception {
    MigrationSubtask expectedResponse =
        MigrationSubtask.newBuilder()
            .setName(
                MigrationSubtaskName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]", "[SUBTASK]")
                    .toString())
            .setTaskId("taskId-880873088")
            .setType("type3575610")
            .setProcessingError(ErrorInfo.newBuilder().build())
            .addAllResourceErrorDetails(new ArrayList<ResourceErrorDetail>())
            .setResourceErrorCount(-929997465)
            .setCreateTime(Timestamp.newBuilder().build())
            .setLastUpdateTime(Timestamp.newBuilder().build())
            .addAllMetrics(new ArrayList<TimeSeries>())
            .build();
    mockMigrationService.addResponse(expectedResponse);

    String name = "name3373707";

    MigrationSubtask actualResponse = client.getMigrationSubtask(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMigrationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetMigrationSubtaskRequest actualRequest = ((GetMigrationSubtaskRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getMigrationSubtaskExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMigrationService.addException(exception);

    try {
      String name = "name3373707";
      client.getMigrationSubtask(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listMigrationSubtasksTest() throws Exception {
    MigrationSubtask responsesElement = MigrationSubtask.newBuilder().build();
    ListMigrationSubtasksResponse expectedResponse =
        ListMigrationSubtasksResponse.newBuilder()
            .setNextPageToken("")
            .addAllMigrationSubtasks(Arrays.asList(responsesElement))
            .build();
    mockMigrationService.addResponse(expectedResponse);

    MigrationWorkflowName parent =
        MigrationWorkflowName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]");

    ListMigrationSubtasksPagedResponse pagedListResponse = client.listMigrationSubtasks(parent);

    List<MigrationSubtask> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMigrationSubtasksList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockMigrationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListMigrationSubtasksRequest actualRequest =
        ((ListMigrationSubtasksRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listMigrationSubtasksExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMigrationService.addException(exception);

    try {
      MigrationWorkflowName parent =
          MigrationWorkflowName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]");
      client.listMigrationSubtasks(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listMigrationSubtasksTest2() throws Exception {
    MigrationSubtask responsesElement = MigrationSubtask.newBuilder().build();
    ListMigrationSubtasksResponse expectedResponse =
        ListMigrationSubtasksResponse.newBuilder()
            .setNextPageToken("")
            .addAllMigrationSubtasks(Arrays.asList(responsesElement))
            .build();
    mockMigrationService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListMigrationSubtasksPagedResponse pagedListResponse = client.listMigrationSubtasks(parent);

    List<MigrationSubtask> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMigrationSubtasksList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockMigrationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListMigrationSubtasksRequest actualRequest =
        ((ListMigrationSubtasksRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listMigrationSubtasksExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMigrationService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listMigrationSubtasks(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
