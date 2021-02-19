/*
 * Copyright 2020 Google LLC
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

import static com.google.cloud.dialogflow.cx.v3beta1.TestCasesClient.ListTestCaseResultsPagedResponse;
import static com.google.cloud.dialogflow.cx.v3beta1.TestCasesClient.ListTestCasesPagedResponse;

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
import com.google.protobuf.Timestamp;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
public class TestCasesClientTest {
  private static MockServiceHelper mockServiceHelper;
  private TestCasesClient client;
  private static MockTestCases mockTestCases;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockTestCases = new MockTestCases();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockTestCases));
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
    TestCasesSettings settings =
        TestCasesSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = TestCasesClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listTestCasesTest() throws Exception {
    TestCase responsesElement = TestCase.newBuilder().build();
    ListTestCasesResponse expectedResponse =
        ListTestCasesResponse.newBuilder()
            .setNextPageToken("")
            .addAllTestCases(Arrays.asList(responsesElement))
            .build();
    mockTestCases.addResponse(expectedResponse);

    AgentName parent = AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]");

    ListTestCasesPagedResponse pagedListResponse = client.listTestCases(parent);

    List<TestCase> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTestCasesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockTestCases.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListTestCasesRequest actualRequest = ((ListTestCasesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listTestCasesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTestCases.addException(exception);

    try {
      AgentName parent = AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]");
      client.listTestCases(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listTestCasesTest2() throws Exception {
    TestCase responsesElement = TestCase.newBuilder().build();
    ListTestCasesResponse expectedResponse =
        ListTestCasesResponse.newBuilder()
            .setNextPageToken("")
            .addAllTestCases(Arrays.asList(responsesElement))
            .build();
    mockTestCases.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListTestCasesPagedResponse pagedListResponse = client.listTestCases(parent);

    List<TestCase> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTestCasesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockTestCases.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListTestCasesRequest actualRequest = ((ListTestCasesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listTestCasesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTestCases.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listTestCases(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchDeleteTestCasesTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockTestCases.addResponse(expectedResponse);

    AgentName parent = AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]");

    client.batchDeleteTestCases(parent);

    List<AbstractMessage> actualRequests = mockTestCases.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchDeleteTestCasesRequest actualRequest =
        ((BatchDeleteTestCasesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void batchDeleteTestCasesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTestCases.addException(exception);

    try {
      AgentName parent = AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]");
      client.batchDeleteTestCases(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchDeleteTestCasesTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockTestCases.addResponse(expectedResponse);

    String parent = "parent-995424086";

    client.batchDeleteTestCases(parent);

    List<AbstractMessage> actualRequests = mockTestCases.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchDeleteTestCasesRequest actualRequest =
        ((BatchDeleteTestCasesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void batchDeleteTestCasesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTestCases.addException(exception);

    try {
      String parent = "parent-995424086";
      client.batchDeleteTestCases(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getTestCaseTest() throws Exception {
    TestCase expectedResponse =
        TestCase.newBuilder()
            .setName(
                TestCaseName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[TEST_CASE]").toString())
            .addAllTags(new ArrayList<String>())
            .setDisplayName("displayName1714148973")
            .setNotes("notes105008833")
            .setTestConfig(TestConfig.newBuilder().build())
            .addAllTestCaseConversationTurns(new ArrayList<ConversationTurn>())
            .setCreationTime(Timestamp.newBuilder().build())
            .setLastTestResult(TestCaseResult.newBuilder().build())
            .build();
    mockTestCases.addResponse(expectedResponse);

    TestCaseName name = TestCaseName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[TEST_CASE]");

    TestCase actualResponse = client.getTestCase(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTestCases.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetTestCaseRequest actualRequest = ((GetTestCaseRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getTestCaseExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTestCases.addException(exception);

    try {
      TestCaseName name = TestCaseName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[TEST_CASE]");
      client.getTestCase(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getTestCaseTest2() throws Exception {
    TestCase expectedResponse =
        TestCase.newBuilder()
            .setName(
                TestCaseName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[TEST_CASE]").toString())
            .addAllTags(new ArrayList<String>())
            .setDisplayName("displayName1714148973")
            .setNotes("notes105008833")
            .setTestConfig(TestConfig.newBuilder().build())
            .addAllTestCaseConversationTurns(new ArrayList<ConversationTurn>())
            .setCreationTime(Timestamp.newBuilder().build())
            .setLastTestResult(TestCaseResult.newBuilder().build())
            .build();
    mockTestCases.addResponse(expectedResponse);

    String name = "name3373707";

    TestCase actualResponse = client.getTestCase(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTestCases.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetTestCaseRequest actualRequest = ((GetTestCaseRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getTestCaseExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTestCases.addException(exception);

    try {
      String name = "name3373707";
      client.getTestCase(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createTestCaseTest() throws Exception {
    TestCase expectedResponse =
        TestCase.newBuilder()
            .setName(
                TestCaseName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[TEST_CASE]").toString())
            .addAllTags(new ArrayList<String>())
            .setDisplayName("displayName1714148973")
            .setNotes("notes105008833")
            .setTestConfig(TestConfig.newBuilder().build())
            .addAllTestCaseConversationTurns(new ArrayList<ConversationTurn>())
            .setCreationTime(Timestamp.newBuilder().build())
            .setLastTestResult(TestCaseResult.newBuilder().build())
            .build();
    mockTestCases.addResponse(expectedResponse);

    AgentName parent = AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]");
    TestCase testCase = TestCase.newBuilder().build();

    TestCase actualResponse = client.createTestCase(parent, testCase);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTestCases.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateTestCaseRequest actualRequest = ((CreateTestCaseRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(testCase, actualRequest.getTestCase());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createTestCaseExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTestCases.addException(exception);

    try {
      AgentName parent = AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]");
      TestCase testCase = TestCase.newBuilder().build();
      client.createTestCase(parent, testCase);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createTestCaseTest2() throws Exception {
    TestCase expectedResponse =
        TestCase.newBuilder()
            .setName(
                TestCaseName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[TEST_CASE]").toString())
            .addAllTags(new ArrayList<String>())
            .setDisplayName("displayName1714148973")
            .setNotes("notes105008833")
            .setTestConfig(TestConfig.newBuilder().build())
            .addAllTestCaseConversationTurns(new ArrayList<ConversationTurn>())
            .setCreationTime(Timestamp.newBuilder().build())
            .setLastTestResult(TestCaseResult.newBuilder().build())
            .build();
    mockTestCases.addResponse(expectedResponse);

    String parent = "parent-995424086";
    TestCase testCase = TestCase.newBuilder().build();

    TestCase actualResponse = client.createTestCase(parent, testCase);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTestCases.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateTestCaseRequest actualRequest = ((CreateTestCaseRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(testCase, actualRequest.getTestCase());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createTestCaseExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTestCases.addException(exception);

    try {
      String parent = "parent-995424086";
      TestCase testCase = TestCase.newBuilder().build();
      client.createTestCase(parent, testCase);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateTestCaseTest() throws Exception {
    TestCase expectedResponse =
        TestCase.newBuilder()
            .setName(
                TestCaseName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[TEST_CASE]").toString())
            .addAllTags(new ArrayList<String>())
            .setDisplayName("displayName1714148973")
            .setNotes("notes105008833")
            .setTestConfig(TestConfig.newBuilder().build())
            .addAllTestCaseConversationTurns(new ArrayList<ConversationTurn>())
            .setCreationTime(Timestamp.newBuilder().build())
            .setLastTestResult(TestCaseResult.newBuilder().build())
            .build();
    mockTestCases.addResponse(expectedResponse);

    TestCase testCase = TestCase.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    TestCase actualResponse = client.updateTestCase(testCase, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTestCases.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateTestCaseRequest actualRequest = ((UpdateTestCaseRequest) actualRequests.get(0));

    Assert.assertEquals(testCase, actualRequest.getTestCase());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateTestCaseExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTestCases.addException(exception);

    try {
      TestCase testCase = TestCase.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateTestCase(testCase, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void runTestCaseTest() throws Exception {
    RunTestCaseResponse expectedResponse =
        RunTestCaseResponse.newBuilder().setResult(TestCaseResult.newBuilder().build()).build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("runTestCaseTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockTestCases.addResponse(resultOperation);

    RunTestCaseRequest request =
        RunTestCaseRequest.newBuilder()
            .setName(
                TestCaseName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[TEST_CASE]").toString())
            .setEnvironment(
                EnvironmentName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[ENVIRONMENT]")
                    .toString())
            .build();

    RunTestCaseResponse actualResponse = client.runTestCaseAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTestCases.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RunTestCaseRequest actualRequest = ((RunTestCaseRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getEnvironment(), actualRequest.getEnvironment());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void runTestCaseExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTestCases.addException(exception);

    try {
      RunTestCaseRequest request =
          RunTestCaseRequest.newBuilder()
              .setName(
                  TestCaseName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[TEST_CASE]").toString())
              .setEnvironment(
                  EnvironmentName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[ENVIRONMENT]")
                      .toString())
              .build();
      client.runTestCaseAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void batchRunTestCasesTest() throws Exception {
    BatchRunTestCasesResponse expectedResponse =
        BatchRunTestCasesResponse.newBuilder()
            .addAllResults(new ArrayList<TestCaseResult>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("batchRunTestCasesTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockTestCases.addResponse(resultOperation);

    BatchRunTestCasesRequest request =
        BatchRunTestCasesRequest.newBuilder()
            .setParent(
                TestCaseName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[TEST_CASE]").toString())
            .setEnvironment(
                EnvironmentName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[ENVIRONMENT]")
                    .toString())
            .addAllTestCases(new ArrayList<String>())
            .build();

    BatchRunTestCasesResponse actualResponse = client.batchRunTestCasesAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTestCases.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchRunTestCasesRequest actualRequest = ((BatchRunTestCasesRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getEnvironment(), actualRequest.getEnvironment());
    Assert.assertEquals(request.getTestCasesList(), actualRequest.getTestCasesList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void batchRunTestCasesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTestCases.addException(exception);

    try {
      BatchRunTestCasesRequest request =
          BatchRunTestCasesRequest.newBuilder()
              .setParent(
                  TestCaseName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[TEST_CASE]").toString())
              .setEnvironment(
                  EnvironmentName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[ENVIRONMENT]")
                      .toString())
              .addAllTestCases(new ArrayList<String>())
              .build();
      client.batchRunTestCasesAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void calculateCoverageTest() throws Exception {
    CalculateCoverageResponse expectedResponse =
        CalculateCoverageResponse.newBuilder()
            .setAgent(AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]").toString())
            .build();
    mockTestCases.addResponse(expectedResponse);

    CalculateCoverageRequest request =
        CalculateCoverageRequest.newBuilder()
            .setAgent(AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]").toString())
            .build();

    CalculateCoverageResponse actualResponse = client.calculateCoverage(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTestCases.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CalculateCoverageRequest actualRequest = ((CalculateCoverageRequest) actualRequests.get(0));

    Assert.assertEquals(request.getAgent(), actualRequest.getAgent());
    Assert.assertEquals(request.getType(), actualRequest.getType());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void calculateCoverageExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTestCases.addException(exception);

    try {
      CalculateCoverageRequest request =
          CalculateCoverageRequest.newBuilder()
              .setAgent(AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]").toString())
              .build();
      client.calculateCoverage(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void importTestCasesTest() throws Exception {
    ImportTestCasesResponse expectedResponse =
        ImportTestCasesResponse.newBuilder().addAllNames(new ArrayList<String>()).build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("importTestCasesTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockTestCases.addResponse(resultOperation);

    ImportTestCasesRequest request =
        ImportTestCasesRequest.newBuilder()
            .setParent(
                TestCaseName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[TEST_CASE]").toString())
            .build();

    ImportTestCasesResponse actualResponse = client.importTestCasesAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTestCases.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ImportTestCasesRequest actualRequest = ((ImportTestCasesRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getGcsUri(), actualRequest.getGcsUri());
    Assert.assertEquals(request.getContent(), actualRequest.getContent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void importTestCasesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTestCases.addException(exception);

    try {
      ImportTestCasesRequest request =
          ImportTestCasesRequest.newBuilder()
              .setParent(
                  TestCaseName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[TEST_CASE]").toString())
              .build();
      client.importTestCasesAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void exportTestCasesTest() throws Exception {
    ExportTestCasesResponse expectedResponse = ExportTestCasesResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("exportTestCasesTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockTestCases.addResponse(resultOperation);

    ExportTestCasesRequest request =
        ExportTestCasesRequest.newBuilder()
            .setParent(
                TestCaseName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[TEST_CASE]").toString())
            .setFilter("filter-1274492040")
            .build();

    ExportTestCasesResponse actualResponse = client.exportTestCasesAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTestCases.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ExportTestCasesRequest actualRequest = ((ExportTestCasesRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getGcsUri(), actualRequest.getGcsUri());
    Assert.assertEquals(request.getDataFormat(), actualRequest.getDataFormat());
    Assert.assertEquals(request.getFilter(), actualRequest.getFilter());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void exportTestCasesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTestCases.addException(exception);

    try {
      ExportTestCasesRequest request =
          ExportTestCasesRequest.newBuilder()
              .setParent(
                  TestCaseName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[TEST_CASE]").toString())
              .setFilter("filter-1274492040")
              .build();
      client.exportTestCasesAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listTestCaseResultsTest() throws Exception {
    TestCaseResult responsesElement = TestCaseResult.newBuilder().build();
    ListTestCaseResultsResponse expectedResponse =
        ListTestCaseResultsResponse.newBuilder()
            .setNextPageToken("")
            .addAllTestCaseResults(Arrays.asList(responsesElement))
            .build();
    mockTestCases.addResponse(expectedResponse);

    TestCaseName parent = TestCaseName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[TEST_CASE]");

    ListTestCaseResultsPagedResponse pagedListResponse = client.listTestCaseResults(parent);

    List<TestCaseResult> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTestCaseResultsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockTestCases.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListTestCaseResultsRequest actualRequest = ((ListTestCaseResultsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listTestCaseResultsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTestCases.addException(exception);

    try {
      TestCaseName parent = TestCaseName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[TEST_CASE]");
      client.listTestCaseResults(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listTestCaseResultsTest2() throws Exception {
    TestCaseResult responsesElement = TestCaseResult.newBuilder().build();
    ListTestCaseResultsResponse expectedResponse =
        ListTestCaseResultsResponse.newBuilder()
            .setNextPageToken("")
            .addAllTestCaseResults(Arrays.asList(responsesElement))
            .build();
    mockTestCases.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListTestCaseResultsPagedResponse pagedListResponse = client.listTestCaseResults(parent);

    List<TestCaseResult> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTestCaseResultsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockTestCases.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListTestCaseResultsRequest actualRequest = ((ListTestCaseResultsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listTestCaseResultsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTestCases.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listTestCaseResults(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
