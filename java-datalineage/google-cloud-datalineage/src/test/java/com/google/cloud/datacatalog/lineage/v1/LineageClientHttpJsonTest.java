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
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.datacatalog.lineage.v1.stub.HttpJsonLineageStub;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Struct;
import com.google.protobuf.Timestamp;
import com.google.protobuf.Value;
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
public class LineageClientHttpJsonTest {
  private static MockHttpService mockService;
  private static LineageClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonLineageStub.getMethodDescriptors(), LineageSettings.getDefaultEndpoint());
    LineageSettings settings =
        LineageSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                LineageSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = LineageClient.create(settings);
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
  public void processOpenLineageRunEventTest() throws Exception {
    ProcessOpenLineageRunEventResponse expectedResponse =
        ProcessOpenLineageRunEventResponse.newBuilder()
            .setProcess(ProcessName.of("[PROJECT]", "[LOCATION]", "[PROCESS]").toString())
            .setRun(RunName.of("[PROJECT]", "[LOCATION]", "[PROCESS]", "[RUN]").toString())
            .addAllLineageEvents(new ArrayList<String>())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";
    Struct openLineage = Struct.newBuilder().build();

    ProcessOpenLineageRunEventResponse actualResponse =
        client.processOpenLineageRunEvent(parent, openLineage);
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
  public void processOpenLineageRunEventExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
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
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Process process = Process.newBuilder().build();

    Process actualResponse = client.createProcess(parent, process);
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
  public void createProcessExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";
    Process process = Process.newBuilder().build();

    Process actualResponse = client.createProcess(parent, process);
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
  public void createProcessExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
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
    mockService.addResponse(expectedResponse);

    Process process =
        Process.newBuilder()
            .setName(ProcessName.of("[PROJECT]", "[LOCATION]", "[PROCESS]").toString())
            .setDisplayName("displayName1714148973")
            .putAllAttributes(new HashMap<String, Value>())
            .setOrigin(Origin.newBuilder().build())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Process actualResponse = client.updateProcess(process, updateMask);
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
  public void updateProcessExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Process process =
          Process.newBuilder()
              .setName(ProcessName.of("[PROJECT]", "[LOCATION]", "[PROCESS]").toString())
              .setDisplayName("displayName1714148973")
              .putAllAttributes(new HashMap<String, Value>())
              .setOrigin(Origin.newBuilder().build())
              .build();
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
    mockService.addResponse(expectedResponse);

    ProcessName name = ProcessName.of("[PROJECT]", "[LOCATION]", "[PROCESS]");

    Process actualResponse = client.getProcess(name);
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
  public void getProcessExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name = "projects/project-4077/locations/location-4077/processes/processe-4077";

    Process actualResponse = client.getProcess(name);
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
  public void getProcessExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-4077/locations/location-4077/processes/processe-4077";
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
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListProcessesPagedResponse pagedListResponse = client.listProcesses(parent);

    List<Process> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getProcessesList().get(0), resources.get(0));

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
  public void listProcessesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListProcessesPagedResponse pagedListResponse = client.listProcesses(parent);

    List<Process> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getProcessesList().get(0), resources.get(0));

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
  public void listProcessesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
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
    mockService.addResponse(resultOperation);

    ProcessName name = ProcessName.of("[PROJECT]", "[LOCATION]", "[PROCESS]");

    client.deleteProcessAsync(name).get();

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
  public void deleteProcessExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ProcessName name = ProcessName.of("[PROJECT]", "[LOCATION]", "[PROCESS]");
      client.deleteProcessAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    String name = "projects/project-4077/locations/location-4077/processes/processe-4077";

    client.deleteProcessAsync(name).get();

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
  public void deleteProcessExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-4077/locations/location-4077/processes/processe-4077";
      client.deleteProcessAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(expectedResponse);

    ProcessName parent = ProcessName.of("[PROJECT]", "[LOCATION]", "[PROCESS]");
    Run run = Run.newBuilder().build();

    Run actualResponse = client.createRun(parent, run);
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
  public void createRunExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-8610/locations/location-8610/processes/processe-8610";
    Run run = Run.newBuilder().build();

    Run actualResponse = client.createRun(parent, run);
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
  public void createRunExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-8610/locations/location-8610/processes/processe-8610";
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
    mockService.addResponse(expectedResponse);

    Run run =
        Run.newBuilder()
            .setName(RunName.of("[PROJECT]", "[LOCATION]", "[PROCESS]", "[RUN]").toString())
            .setDisplayName("displayName1714148973")
            .putAllAttributes(new HashMap<String, Value>())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Run actualResponse = client.updateRun(run, updateMask);
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
  public void updateRunExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Run run =
          Run.newBuilder()
              .setName(RunName.of("[PROJECT]", "[LOCATION]", "[PROCESS]", "[RUN]").toString())
              .setDisplayName("displayName1714148973")
              .putAllAttributes(new HashMap<String, Value>())
              .setStartTime(Timestamp.newBuilder().build())
              .setEndTime(Timestamp.newBuilder().build())
              .build();
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
    mockService.addResponse(expectedResponse);

    RunName name = RunName.of("[PROJECT]", "[LOCATION]", "[PROCESS]", "[RUN]");

    Run actualResponse = client.getRun(name);
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
  public void getRunExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-2865/locations/location-2865/processes/processe-2865/runs/run-2865";

    Run actualResponse = client.getRun(name);
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
  public void getRunExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-2865/locations/location-2865/processes/processe-2865/runs/run-2865";
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
    mockService.addResponse(expectedResponse);

    ProcessName parent = ProcessName.of("[PROJECT]", "[LOCATION]", "[PROCESS]");

    ListRunsPagedResponse pagedListResponse = client.listRuns(parent);

    List<Run> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRunsList().get(0), resources.get(0));

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
  public void listRunsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-8610/locations/location-8610/processes/processe-8610";

    ListRunsPagedResponse pagedListResponse = client.listRuns(parent);

    List<Run> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRunsList().get(0), resources.get(0));

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
  public void listRunsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-8610/locations/location-8610/processes/processe-8610";
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
    mockService.addResponse(resultOperation);

    RunName name = RunName.of("[PROJECT]", "[LOCATION]", "[PROCESS]", "[RUN]");

    client.deleteRunAsync(name).get();

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
  public void deleteRunExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      RunName name = RunName.of("[PROJECT]", "[LOCATION]", "[PROCESS]", "[RUN]");
      client.deleteRunAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    String name =
        "projects/project-2865/locations/location-2865/processes/processe-2865/runs/run-2865";

    client.deleteRunAsync(name).get();

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
  public void deleteRunExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-2865/locations/location-2865/processes/processe-2865/runs/run-2865";
      client.deleteRunAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(expectedResponse);

    RunName parent = RunName.of("[PROJECT]", "[LOCATION]", "[PROCESS]", "[RUN]");
    LineageEvent lineageEvent = LineageEvent.newBuilder().build();

    LineageEvent actualResponse = client.createLineageEvent(parent, lineageEvent);
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
  public void createLineageEventExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent =
        "projects/project-2464/locations/location-2464/processes/processe-2464/runs/run-2464";
    LineageEvent lineageEvent = LineageEvent.newBuilder().build();

    LineageEvent actualResponse = client.createLineageEvent(parent, lineageEvent);
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
  public void createLineageEventExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-2464/locations/location-2464/processes/processe-2464/runs/run-2464";
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
    mockService.addResponse(expectedResponse);

    LineageEventName name =
        LineageEventName.of("[PROJECT]", "[LOCATION]", "[PROCESS]", "[RUN]", "[LINEAGE_EVENT]");

    LineageEvent actualResponse = client.getLineageEvent(name);
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
  public void getLineageEventExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-8417/locations/location-8417/processes/processe-8417/runs/run-8417/lineageEvents/lineageEvent-8417";

    LineageEvent actualResponse = client.getLineageEvent(name);
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
  public void getLineageEventExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-8417/locations/location-8417/processes/processe-8417/runs/run-8417/lineageEvents/lineageEvent-8417";
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
    mockService.addResponse(expectedResponse);

    RunName parent = RunName.of("[PROJECT]", "[LOCATION]", "[PROCESS]", "[RUN]");

    ListLineageEventsPagedResponse pagedListResponse = client.listLineageEvents(parent);

    List<LineageEvent> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLineageEventsList().get(0), resources.get(0));

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
  public void listLineageEventsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent =
        "projects/project-2464/locations/location-2464/processes/processe-2464/runs/run-2464";

    ListLineageEventsPagedResponse pagedListResponse = client.listLineageEvents(parent);

    List<LineageEvent> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLineageEventsList().get(0), resources.get(0));

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
  public void listLineageEventsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-2464/locations/location-2464/processes/processe-2464/runs/run-2464";
      client.listLineageEvents(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteLineageEventTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    LineageEventName name =
        LineageEventName.of("[PROJECT]", "[LOCATION]", "[PROCESS]", "[RUN]", "[LINEAGE_EVENT]");

    client.deleteLineageEvent(name);

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
  public void deleteLineageEventExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-8417/locations/location-8417/processes/processe-8417/runs/run-8417/lineageEvents/lineageEvent-8417";

    client.deleteLineageEvent(name);

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
  public void deleteLineageEventExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-8417/locations/location-8417/processes/processe-8417/runs/run-8417/lineageEvents/lineageEvent-8417";
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
    mockService.addResponse(expectedResponse);

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
  public void searchLinksExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

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
  public void batchSearchLinkProcessesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
