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

package com.google.cloud.datacatalog.lineage.v1;

import static com.google.cloud.datacatalog.lineage.v1.LineageClient.BatchSearchLinkProcessesPagedResponse;
import static com.google.cloud.datacatalog.lineage.v1.LineageClient.ListLineageEventsPagedResponse;
import static com.google.cloud.datacatalog.lineage.v1.LineageClient.ListProcessesPagedResponse;
import static com.google.cloud.datacatalog.lineage.v1.LineageClient.ListRunsPagedResponse;
import static com.google.cloud.datacatalog.lineage.v1.LineageClient.SearchLinksPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Struct;
import com.google.protobuf.Timestamp;
import com.google.protobuf.Value;
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
public class LineageClientTest {
  private static MockLineage mockLineage;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private LineageClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockLineage = new MockLineage();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockLineage));
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
    LineageSettings settings =
        LineageSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = LineageClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void processOpenLineageRunEventTest() throws Exception {
    ProcessOpenLineageRunEventResponse expectedResponse =
        ProcessOpenLineageRunEventResponse.newBuilder()
            .setProcess(ProcessName.of("[PROJECT]", "[LOCATION]", "[PROCESS]").toString())
            .setRun(RunName.of("[PROJECT]", "[LOCATION]", "[PROCESS]", "[RUN]").toString())
            .addAllLineageEvents(new ArrayList<String>())
            .build();
    mockLineage.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Struct openLineage = Struct.newBuilder().build();

    ProcessOpenLineageRunEventResponse actualResponse =
        client.processOpenLineageRunEvent(parent, openLineage);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLineage.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ProcessOpenLineageRunEventRequest actualRequest =
        ((ProcessOpenLineageRunEventRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(openLineage, actualRequest.getOpenLineage());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void processOpenLineageRunEventExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLineage.addException(exception);

    try {
      String parent = "parent-995424086";
      Struct openLineage = Struct.newBuilder().build();
      client.processOpenLineageRunEvent(parent, openLineage);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createProcessTest() throws Exception {
    Process expectedResponse =
        Process.newBuilder()
            .setName(ProcessName.of("[PROJECT]", "[LOCATION]", "[PROCESS]").toString())
            .setDisplayName("displayName1714148973")
            .putAllAttributes(new HashMap<String, Value>())
            .setOrigin(Origin.newBuilder().build())
            .build();
    mockLineage.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Process process = Process.newBuilder().build();

    Process actualResponse = client.createProcess(parent, process);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLineage.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateProcessRequest actualRequest = ((CreateProcessRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(process, actualRequest.getProcess());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createProcessExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLineage.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Process process = Process.newBuilder().build();
      client.createProcess(parent, process);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createProcessTest2() throws Exception {
    Process expectedResponse =
        Process.newBuilder()
            .setName(ProcessName.of("[PROJECT]", "[LOCATION]", "[PROCESS]").toString())
            .setDisplayName("displayName1714148973")
            .putAllAttributes(new HashMap<String, Value>())
            .setOrigin(Origin.newBuilder().build())
            .build();
    mockLineage.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Process process = Process.newBuilder().build();

    Process actualResponse = client.createProcess(parent, process);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLineage.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateProcessRequest actualRequest = ((CreateProcessRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(process, actualRequest.getProcess());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createProcessExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLineage.addException(exception);

    try {
      String parent = "parent-995424086";
      Process process = Process.newBuilder().build();
      client.createProcess(parent, process);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateProcessTest() throws Exception {
    Process expectedResponse =
        Process.newBuilder()
            .setName(ProcessName.of("[PROJECT]", "[LOCATION]", "[PROCESS]").toString())
            .setDisplayName("displayName1714148973")
            .putAllAttributes(new HashMap<String, Value>())
            .setOrigin(Origin.newBuilder().build())
            .build();
    mockLineage.addResponse(expectedResponse);

    Process process = Process.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Process actualResponse = client.updateProcess(process, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLineage.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateProcessRequest actualRequest = ((UpdateProcessRequest) actualRequests.get(0));

    Assert.assertEquals(process, actualRequest.getProcess());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateProcessExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLineage.addException(exception);

    try {
      Process process = Process.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateProcess(process, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getProcessTest() throws Exception {
    Process expectedResponse =
        Process.newBuilder()
            .setName(ProcessName.of("[PROJECT]", "[LOCATION]", "[PROCESS]").toString())
            .setDisplayName("displayName1714148973")
            .putAllAttributes(new HashMap<String, Value>())
            .setOrigin(Origin.newBuilder().build())
            .build();
    mockLineage.addResponse(expectedResponse);

    ProcessName name = ProcessName.of("[PROJECT]", "[LOCATION]", "[PROCESS]");

    Process actualResponse = client.getProcess(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLineage.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetProcessRequest actualRequest = ((GetProcessRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getProcessExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLineage.addException(exception);

    try {
      ProcessName name = ProcessName.of("[PROJECT]", "[LOCATION]", "[PROCESS]");
      client.getProcess(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getProcessTest2() throws Exception {
    Process expectedResponse =
        Process.newBuilder()
            .setName(ProcessName.of("[PROJECT]", "[LOCATION]", "[PROCESS]").toString())
            .setDisplayName("displayName1714148973")
            .putAllAttributes(new HashMap<String, Value>())
            .setOrigin(Origin.newBuilder().build())
            .build();
    mockLineage.addResponse(expectedResponse);

    String name = "name3373707";

    Process actualResponse = client.getProcess(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLineage.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetProcessRequest actualRequest = ((GetProcessRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getProcessExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLineage.addException(exception);

    try {
      String name = "name3373707";
      client.getProcess(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listProcessesTest() throws Exception {
    Process responsesElement = Process.newBuilder().build();
    ListProcessesResponse expectedResponse =
        ListProcessesResponse.newBuilder()
            .setNextPageToken("")
            .addAllProcesses(Arrays.asList(responsesElement))
            .build();
    mockLineage.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListProcessesPagedResponse pagedListResponse = client.listProcesses(parent);

    List<Process> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getProcessesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockLineage.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListProcessesRequest actualRequest = ((ListProcessesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listProcessesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLineage.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listProcesses(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listProcessesTest2() throws Exception {
    Process responsesElement = Process.newBuilder().build();
    ListProcessesResponse expectedResponse =
        ListProcessesResponse.newBuilder()
            .setNextPageToken("")
            .addAllProcesses(Arrays.asList(responsesElement))
            .build();
    mockLineage.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListProcessesPagedResponse pagedListResponse = client.listProcesses(parent);

    List<Process> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getProcessesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockLineage.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListProcessesRequest actualRequest = ((ListProcessesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listProcessesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLineage.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listProcesses(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteProcessTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteProcessTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockLineage.addResponse(resultOperation);

    ProcessName name = ProcessName.of("[PROJECT]", "[LOCATION]", "[PROCESS]");

    client.deleteProcessAsync(name).get();

    List<AbstractMessage> actualRequests = mockLineage.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteProcessRequest actualRequest = ((DeleteProcessRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteProcessExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLineage.addException(exception);

    try {
      ProcessName name = ProcessName.of("[PROJECT]", "[LOCATION]", "[PROCESS]");
      client.deleteProcessAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteProcessTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteProcessTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockLineage.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteProcessAsync(name).get();

    List<AbstractMessage> actualRequests = mockLineage.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteProcessRequest actualRequest = ((DeleteProcessRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteProcessExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLineage.addException(exception);

    try {
      String name = "name3373707";
      client.deleteProcessAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createRunTest() throws Exception {
    Run expectedResponse =
        Run.newBuilder()
            .setName(RunName.of("[PROJECT]", "[LOCATION]", "[PROCESS]", "[RUN]").toString())
            .setDisplayName("displayName1714148973")
            .putAllAttributes(new HashMap<String, Value>())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .build();
    mockLineage.addResponse(expectedResponse);

    ProcessName parent = ProcessName.of("[PROJECT]", "[LOCATION]", "[PROCESS]");
    Run run = Run.newBuilder().build();

    Run actualResponse = client.createRun(parent, run);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLineage.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateRunRequest actualRequest = ((CreateRunRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(run, actualRequest.getRun());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createRunExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLineage.addException(exception);

    try {
      ProcessName parent = ProcessName.of("[PROJECT]", "[LOCATION]", "[PROCESS]");
      Run run = Run.newBuilder().build();
      client.createRun(parent, run);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createRunTest2() throws Exception {
    Run expectedResponse =
        Run.newBuilder()
            .setName(RunName.of("[PROJECT]", "[LOCATION]", "[PROCESS]", "[RUN]").toString())
            .setDisplayName("displayName1714148973")
            .putAllAttributes(new HashMap<String, Value>())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .build();
    mockLineage.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Run run = Run.newBuilder().build();

    Run actualResponse = client.createRun(parent, run);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLineage.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateRunRequest actualRequest = ((CreateRunRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(run, actualRequest.getRun());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createRunExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLineage.addException(exception);

    try {
      String parent = "parent-995424086";
      Run run = Run.newBuilder().build();
      client.createRun(parent, run);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateRunTest() throws Exception {
    Run expectedResponse =
        Run.newBuilder()
            .setName(RunName.of("[PROJECT]", "[LOCATION]", "[PROCESS]", "[RUN]").toString())
            .setDisplayName("displayName1714148973")
            .putAllAttributes(new HashMap<String, Value>())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .build();
    mockLineage.addResponse(expectedResponse);

    Run run = Run.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Run actualResponse = client.updateRun(run, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLineage.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateRunRequest actualRequest = ((UpdateRunRequest) actualRequests.get(0));

    Assert.assertEquals(run, actualRequest.getRun());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateRunExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLineage.addException(exception);

    try {
      Run run = Run.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateRun(run, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getRunTest() throws Exception {
    Run expectedResponse =
        Run.newBuilder()
            .setName(RunName.of("[PROJECT]", "[LOCATION]", "[PROCESS]", "[RUN]").toString())
            .setDisplayName("displayName1714148973")
            .putAllAttributes(new HashMap<String, Value>())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .build();
    mockLineage.addResponse(expectedResponse);

    RunName name = RunName.of("[PROJECT]", "[LOCATION]", "[PROCESS]", "[RUN]");

    Run actualResponse = client.getRun(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLineage.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetRunRequest actualRequest = ((GetRunRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getRunExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLineage.addException(exception);

    try {
      RunName name = RunName.of("[PROJECT]", "[LOCATION]", "[PROCESS]", "[RUN]");
      client.getRun(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getRunTest2() throws Exception {
    Run expectedResponse =
        Run.newBuilder()
            .setName(RunName.of("[PROJECT]", "[LOCATION]", "[PROCESS]", "[RUN]").toString())
            .setDisplayName("displayName1714148973")
            .putAllAttributes(new HashMap<String, Value>())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .build();
    mockLineage.addResponse(expectedResponse);

    String name = "name3373707";

    Run actualResponse = client.getRun(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLineage.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetRunRequest actualRequest = ((GetRunRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getRunExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLineage.addException(exception);

    try {
      String name = "name3373707";
      client.getRun(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listRunsTest() throws Exception {
    Run responsesElement = Run.newBuilder().build();
    ListRunsResponse expectedResponse =
        ListRunsResponse.newBuilder()
            .setNextPageToken("")
            .addAllRuns(Arrays.asList(responsesElement))
            .build();
    mockLineage.addResponse(expectedResponse);

    ProcessName parent = ProcessName.of("[PROJECT]", "[LOCATION]", "[PROCESS]");

    ListRunsPagedResponse pagedListResponse = client.listRuns(parent);

    List<Run> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRunsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockLineage.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListRunsRequest actualRequest = ((ListRunsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listRunsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLineage.addException(exception);

    try {
      ProcessName parent = ProcessName.of("[PROJECT]", "[LOCATION]", "[PROCESS]");
      client.listRuns(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listRunsTest2() throws Exception {
    Run responsesElement = Run.newBuilder().build();
    ListRunsResponse expectedResponse =
        ListRunsResponse.newBuilder()
            .setNextPageToken("")
            .addAllRuns(Arrays.asList(responsesElement))
            .build();
    mockLineage.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListRunsPagedResponse pagedListResponse = client.listRuns(parent);

    List<Run> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRunsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockLineage.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListRunsRequest actualRequest = ((ListRunsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listRunsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLineage.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listRuns(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteRunTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteRunTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockLineage.addResponse(resultOperation);

    RunName name = RunName.of("[PROJECT]", "[LOCATION]", "[PROCESS]", "[RUN]");

    client.deleteRunAsync(name).get();

    List<AbstractMessage> actualRequests = mockLineage.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteRunRequest actualRequest = ((DeleteRunRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteRunExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLineage.addException(exception);

    try {
      RunName name = RunName.of("[PROJECT]", "[LOCATION]", "[PROCESS]", "[RUN]");
      client.deleteRunAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteRunTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteRunTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockLineage.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteRunAsync(name).get();

    List<AbstractMessage> actualRequests = mockLineage.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteRunRequest actualRequest = ((DeleteRunRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteRunExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLineage.addException(exception);

    try {
      String name = "name3373707";
      client.deleteRunAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createLineageEventTest() throws Exception {
    LineageEvent expectedResponse =
        LineageEvent.newBuilder()
            .setName(
                LineageEventName.of(
                        "[PROJECT]", "[LOCATION]", "[PROCESS]", "[RUN]", "[LINEAGE_EVENT]")
                    .toString())
            .addAllLinks(new ArrayList<EventLink>())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .build();
    mockLineage.addResponse(expectedResponse);

    RunName parent = RunName.of("[PROJECT]", "[LOCATION]", "[PROCESS]", "[RUN]");
    LineageEvent lineageEvent = LineageEvent.newBuilder().build();

    LineageEvent actualResponse = client.createLineageEvent(parent, lineageEvent);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLineage.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateLineageEventRequest actualRequest = ((CreateLineageEventRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(lineageEvent, actualRequest.getLineageEvent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createLineageEventExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLineage.addException(exception);

    try {
      RunName parent = RunName.of("[PROJECT]", "[LOCATION]", "[PROCESS]", "[RUN]");
      LineageEvent lineageEvent = LineageEvent.newBuilder().build();
      client.createLineageEvent(parent, lineageEvent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createLineageEventTest2() throws Exception {
    LineageEvent expectedResponse =
        LineageEvent.newBuilder()
            .setName(
                LineageEventName.of(
                        "[PROJECT]", "[LOCATION]", "[PROCESS]", "[RUN]", "[LINEAGE_EVENT]")
                    .toString())
            .addAllLinks(new ArrayList<EventLink>())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .build();
    mockLineage.addResponse(expectedResponse);

    String parent = "parent-995424086";
    LineageEvent lineageEvent = LineageEvent.newBuilder().build();

    LineageEvent actualResponse = client.createLineageEvent(parent, lineageEvent);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLineage.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateLineageEventRequest actualRequest = ((CreateLineageEventRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(lineageEvent, actualRequest.getLineageEvent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createLineageEventExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLineage.addException(exception);

    try {
      String parent = "parent-995424086";
      LineageEvent lineageEvent = LineageEvent.newBuilder().build();
      client.createLineageEvent(parent, lineageEvent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getLineageEventTest() throws Exception {
    LineageEvent expectedResponse =
        LineageEvent.newBuilder()
            .setName(
                LineageEventName.of(
                        "[PROJECT]", "[LOCATION]", "[PROCESS]", "[RUN]", "[LINEAGE_EVENT]")
                    .toString())
            .addAllLinks(new ArrayList<EventLink>())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .build();
    mockLineage.addResponse(expectedResponse);

    LineageEventName name =
        LineageEventName.of("[PROJECT]", "[LOCATION]", "[PROCESS]", "[RUN]", "[LINEAGE_EVENT]");

    LineageEvent actualResponse = client.getLineageEvent(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLineage.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetLineageEventRequest actualRequest = ((GetLineageEventRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getLineageEventExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLineage.addException(exception);

    try {
      LineageEventName name =
          LineageEventName.of("[PROJECT]", "[LOCATION]", "[PROCESS]", "[RUN]", "[LINEAGE_EVENT]");
      client.getLineageEvent(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getLineageEventTest2() throws Exception {
    LineageEvent expectedResponse =
        LineageEvent.newBuilder()
            .setName(
                LineageEventName.of(
                        "[PROJECT]", "[LOCATION]", "[PROCESS]", "[RUN]", "[LINEAGE_EVENT]")
                    .toString())
            .addAllLinks(new ArrayList<EventLink>())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .build();
    mockLineage.addResponse(expectedResponse);

    String name = "name3373707";

    LineageEvent actualResponse = client.getLineageEvent(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLineage.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetLineageEventRequest actualRequest = ((GetLineageEventRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getLineageEventExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLineage.addException(exception);

    try {
      String name = "name3373707";
      client.getLineageEvent(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listLineageEventsTest() throws Exception {
    LineageEvent responsesElement = LineageEvent.newBuilder().build();
    ListLineageEventsResponse expectedResponse =
        ListLineageEventsResponse.newBuilder()
            .setNextPageToken("")
            .addAllLineageEvents(Arrays.asList(responsesElement))
            .build();
    mockLineage.addResponse(expectedResponse);

    RunName parent = RunName.of("[PROJECT]", "[LOCATION]", "[PROCESS]", "[RUN]");

    ListLineageEventsPagedResponse pagedListResponse = client.listLineageEvents(parent);

    List<LineageEvent> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLineageEventsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockLineage.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListLineageEventsRequest actualRequest = ((ListLineageEventsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listLineageEventsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLineage.addException(exception);

    try {
      RunName parent = RunName.of("[PROJECT]", "[LOCATION]", "[PROCESS]", "[RUN]");
      client.listLineageEvents(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listLineageEventsTest2() throws Exception {
    LineageEvent responsesElement = LineageEvent.newBuilder().build();
    ListLineageEventsResponse expectedResponse =
        ListLineageEventsResponse.newBuilder()
            .setNextPageToken("")
            .addAllLineageEvents(Arrays.asList(responsesElement))
            .build();
    mockLineage.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListLineageEventsPagedResponse pagedListResponse = client.listLineageEvents(parent);

    List<LineageEvent> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLineageEventsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockLineage.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListLineageEventsRequest actualRequest = ((ListLineageEventsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listLineageEventsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLineage.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listLineageEvents(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteLineageEventTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockLineage.addResponse(expectedResponse);

    LineageEventName name =
        LineageEventName.of("[PROJECT]", "[LOCATION]", "[PROCESS]", "[RUN]", "[LINEAGE_EVENT]");

    client.deleteLineageEvent(name);

    List<AbstractMessage> actualRequests = mockLineage.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteLineageEventRequest actualRequest = ((DeleteLineageEventRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteLineageEventExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLineage.addException(exception);

    try {
      LineageEventName name =
          LineageEventName.of("[PROJECT]", "[LOCATION]", "[PROCESS]", "[RUN]", "[LINEAGE_EVENT]");
      client.deleteLineageEvent(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteLineageEventTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockLineage.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteLineageEvent(name);

    List<AbstractMessage> actualRequests = mockLineage.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteLineageEventRequest actualRequest = ((DeleteLineageEventRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteLineageEventExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLineage.addException(exception);

    try {
      String name = "name3373707";
      client.deleteLineageEvent(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void searchLinksTest() throws Exception {
    Link responsesElement = Link.newBuilder().build();
    SearchLinksResponse expectedResponse =
        SearchLinksResponse.newBuilder()
            .setNextPageToken("")
            .addAllLinks(Arrays.asList(responsesElement))
            .build();
    mockLineage.addResponse(expectedResponse);

    SearchLinksRequest request =
        SearchLinksRequest.newBuilder()
            .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    SearchLinksPagedResponse pagedListResponse = client.searchLinks(request);

    List<Link> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLinksList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockLineage.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SearchLinksRequest actualRequest = ((SearchLinksRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getSource(), actualRequest.getSource());
    Assert.assertEquals(request.getTarget(), actualRequest.getTarget());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void searchLinksExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLineage.addException(exception);

    try {
      SearchLinksRequest request =
          SearchLinksRequest.newBuilder()
              .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      client.searchLinks(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchSearchLinkProcessesTest() throws Exception {
    ProcessLinks responsesElement = ProcessLinks.newBuilder().build();
    BatchSearchLinkProcessesResponse expectedResponse =
        BatchSearchLinkProcessesResponse.newBuilder()
            .setNextPageToken("")
            .addAllProcessLinks(Arrays.asList(responsesElement))
            .build();
    mockLineage.addResponse(expectedResponse);

    BatchSearchLinkProcessesRequest request =
        BatchSearchLinkProcessesRequest.newBuilder()
            .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
            .addAllLinks(new ArrayList<String>())
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    BatchSearchLinkProcessesPagedResponse pagedListResponse =
        client.batchSearchLinkProcesses(request);

    List<ProcessLinks> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getProcessLinksList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockLineage.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchSearchLinkProcessesRequest actualRequest =
        ((BatchSearchLinkProcessesRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getLinksList(), actualRequest.getLinksList());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void batchSearchLinkProcessesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLineage.addException(exception);

    try {
      BatchSearchLinkProcessesRequest request =
          BatchSearchLinkProcessesRequest.newBuilder()
              .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
              .addAllLinks(new ArrayList<String>())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      client.batchSearchLinkProcesses(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
