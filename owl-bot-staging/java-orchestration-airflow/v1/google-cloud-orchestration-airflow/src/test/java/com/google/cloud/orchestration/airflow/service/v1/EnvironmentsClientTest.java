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

package com.google.cloud.orchestration.airflow.service.v1;

import static com.google.cloud.orchestration.airflow.service.v1.EnvironmentsClient.ListEnvironmentsPagedResponse;
import static com.google.cloud.orchestration.airflow.service.v1.EnvironmentsClient.ListUserWorkloadsConfigMapsPagedResponse;
import static com.google.cloud.orchestration.airflow.service.v1.EnvironmentsClient.ListUserWorkloadsSecretsPagedResponse;
import static com.google.cloud.orchestration.airflow.service.v1.EnvironmentsClient.ListWorkloadsPagedResponse;

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
public class EnvironmentsClientTest {
  private static MockEnvironments mockEnvironments;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private EnvironmentsClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockEnvironments = new MockEnvironments();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockEnvironments));
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
    EnvironmentsSettings settings =
        EnvironmentsSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = EnvironmentsClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createEnvironmentTest() throws Exception {
    Environment expectedResponse =
        Environment.newBuilder()
            .setName(EnvironmentName.of("[PROJECT]", "[LOCATION]", "[ENVIRONMENT]").toString())
            .setConfig(EnvironmentConfig.newBuilder().build())
            .setUuid("uuid3601339")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setSatisfiesPzs(true)
            .setStorageConfig(StorageConfig.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createEnvironmentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockEnvironments.addResponse(resultOperation);

    String parent = "parent-995424086";
    Environment environment = Environment.newBuilder().build();

    Environment actualResponse = client.createEnvironmentAsync(parent, environment).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEnvironments.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateEnvironmentRequest actualRequest = ((CreateEnvironmentRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(environment, actualRequest.getEnvironment());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createEnvironmentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEnvironments.addException(exception);

    try {
      String parent = "parent-995424086";
      Environment environment = Environment.newBuilder().build();
      client.createEnvironmentAsync(parent, environment).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void getEnvironmentTest() throws Exception {
    Environment expectedResponse =
        Environment.newBuilder()
            .setName(EnvironmentName.of("[PROJECT]", "[LOCATION]", "[ENVIRONMENT]").toString())
            .setConfig(EnvironmentConfig.newBuilder().build())
            .setUuid("uuid3601339")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setSatisfiesPzs(true)
            .setStorageConfig(StorageConfig.newBuilder().build())
            .build();
    mockEnvironments.addResponse(expectedResponse);

    String name = "name3373707";

    Environment actualResponse = client.getEnvironment(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEnvironments.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetEnvironmentRequest actualRequest = ((GetEnvironmentRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getEnvironmentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEnvironments.addException(exception);

    try {
      String name = "name3373707";
      client.getEnvironment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listEnvironmentsTest() throws Exception {
    Environment responsesElement = Environment.newBuilder().build();
    ListEnvironmentsResponse expectedResponse =
        ListEnvironmentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllEnvironments(Arrays.asList(responsesElement))
            .build();
    mockEnvironments.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListEnvironmentsPagedResponse pagedListResponse = client.listEnvironments(parent);

    List<Environment> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEnvironmentsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockEnvironments.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListEnvironmentsRequest actualRequest = ((ListEnvironmentsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listEnvironmentsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEnvironments.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listEnvironments(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateEnvironmentTest() throws Exception {
    Environment expectedResponse =
        Environment.newBuilder()
            .setName(EnvironmentName.of("[PROJECT]", "[LOCATION]", "[ENVIRONMENT]").toString())
            .setConfig(EnvironmentConfig.newBuilder().build())
            .setUuid("uuid3601339")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setSatisfiesPzs(true)
            .setStorageConfig(StorageConfig.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateEnvironmentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockEnvironments.addResponse(resultOperation);

    String name = "name3373707";
    Environment environment = Environment.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Environment actualResponse = client.updateEnvironmentAsync(name, environment, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEnvironments.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateEnvironmentRequest actualRequest = ((UpdateEnvironmentRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(environment, actualRequest.getEnvironment());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateEnvironmentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEnvironments.addException(exception);

    try {
      String name = "name3373707";
      Environment environment = Environment.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateEnvironmentAsync(name, environment, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteEnvironmentTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteEnvironmentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockEnvironments.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteEnvironmentAsync(name).get();

    List<AbstractMessage> actualRequests = mockEnvironments.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteEnvironmentRequest actualRequest = ((DeleteEnvironmentRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteEnvironmentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEnvironments.addException(exception);

    try {
      String name = "name3373707";
      client.deleteEnvironmentAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void executeAirflowCommandTest() throws Exception {
    ExecuteAirflowCommandResponse expectedResponse =
        ExecuteAirflowCommandResponse.newBuilder()
            .setExecutionId("executionId-454906285")
            .setPod("pod111173")
            .setPodNamespace("podNamespace463962262")
            .setError("error96784904")
            .build();
    mockEnvironments.addResponse(expectedResponse);

    ExecuteAirflowCommandRequest request =
        ExecuteAirflowCommandRequest.newBuilder()
            .setEnvironment("environment-85904877")
            .setCommand("command950394699")
            .setSubcommand("subcommand2099091723")
            .addAllParameters(new ArrayList<String>())
            .build();

    ExecuteAirflowCommandResponse actualResponse = client.executeAirflowCommand(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEnvironments.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ExecuteAirflowCommandRequest actualRequest =
        ((ExecuteAirflowCommandRequest) actualRequests.get(0));

    Assert.assertEquals(request.getEnvironment(), actualRequest.getEnvironment());
    Assert.assertEquals(request.getCommand(), actualRequest.getCommand());
    Assert.assertEquals(request.getSubcommand(), actualRequest.getSubcommand());
    Assert.assertEquals(request.getParametersList(), actualRequest.getParametersList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void executeAirflowCommandExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEnvironments.addException(exception);

    try {
      ExecuteAirflowCommandRequest request =
          ExecuteAirflowCommandRequest.newBuilder()
              .setEnvironment("environment-85904877")
              .setCommand("command950394699")
              .setSubcommand("subcommand2099091723")
              .addAllParameters(new ArrayList<String>())
              .build();
      client.executeAirflowCommand(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void stopAirflowCommandTest() throws Exception {
    StopAirflowCommandResponse expectedResponse =
        StopAirflowCommandResponse.newBuilder()
            .setIsDone(true)
            .addAllOutput(new ArrayList<String>())
            .build();
    mockEnvironments.addResponse(expectedResponse);

    StopAirflowCommandRequest request =
        StopAirflowCommandRequest.newBuilder()
            .setEnvironment("environment-85904877")
            .setExecutionId("executionId-454906285")
            .setPod("pod111173")
            .setPodNamespace("podNamespace463962262")
            .setForce(true)
            .build();

    StopAirflowCommandResponse actualResponse = client.stopAirflowCommand(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEnvironments.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    StopAirflowCommandRequest actualRequest = ((StopAirflowCommandRequest) actualRequests.get(0));

    Assert.assertEquals(request.getEnvironment(), actualRequest.getEnvironment());
    Assert.assertEquals(request.getExecutionId(), actualRequest.getExecutionId());
    Assert.assertEquals(request.getPod(), actualRequest.getPod());
    Assert.assertEquals(request.getPodNamespace(), actualRequest.getPodNamespace());
    Assert.assertEquals(request.getForce(), actualRequest.getForce());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void stopAirflowCommandExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEnvironments.addException(exception);

    try {
      StopAirflowCommandRequest request =
          StopAirflowCommandRequest.newBuilder()
              .setEnvironment("environment-85904877")
              .setExecutionId("executionId-454906285")
              .setPod("pod111173")
              .setPodNamespace("podNamespace463962262")
              .setForce(true)
              .build();
      client.stopAirflowCommand(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void pollAirflowCommandTest() throws Exception {
    PollAirflowCommandResponse expectedResponse =
        PollAirflowCommandResponse.newBuilder()
            .addAllOutput(new ArrayList<PollAirflowCommandResponse.Line>())
            .setOutputEnd(true)
            .setExitInfo(PollAirflowCommandResponse.ExitInfo.newBuilder().build())
            .build();
    mockEnvironments.addResponse(expectedResponse);

    PollAirflowCommandRequest request =
        PollAirflowCommandRequest.newBuilder()
            .setEnvironment("environment-85904877")
            .setExecutionId("executionId-454906285")
            .setPod("pod111173")
            .setPodNamespace("podNamespace463962262")
            .setNextLineNumber(1176642216)
            .build();

    PollAirflowCommandResponse actualResponse = client.pollAirflowCommand(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEnvironments.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    PollAirflowCommandRequest actualRequest = ((PollAirflowCommandRequest) actualRequests.get(0));

    Assert.assertEquals(request.getEnvironment(), actualRequest.getEnvironment());
    Assert.assertEquals(request.getExecutionId(), actualRequest.getExecutionId());
    Assert.assertEquals(request.getPod(), actualRequest.getPod());
    Assert.assertEquals(request.getPodNamespace(), actualRequest.getPodNamespace());
    Assert.assertEquals(request.getNextLineNumber(), actualRequest.getNextLineNumber());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void pollAirflowCommandExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEnvironments.addException(exception);

    try {
      PollAirflowCommandRequest request =
          PollAirflowCommandRequest.newBuilder()
              .setEnvironment("environment-85904877")
              .setExecutionId("executionId-454906285")
              .setPod("pod111173")
              .setPodNamespace("podNamespace463962262")
              .setNextLineNumber(1176642216)
              .build();
      client.pollAirflowCommand(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listWorkloadsTest() throws Exception {
    ListWorkloadsResponse.ComposerWorkload responsesElement =
        ListWorkloadsResponse.ComposerWorkload.newBuilder().build();
    ListWorkloadsResponse expectedResponse =
        ListWorkloadsResponse.newBuilder()
            .setNextPageToken("")
            .addAllWorkloads(Arrays.asList(responsesElement))
            .build();
    mockEnvironments.addResponse(expectedResponse);

    EnvironmentName parent = EnvironmentName.of("[PROJECT]", "[LOCATION]", "[ENVIRONMENT]");

    ListWorkloadsPagedResponse pagedListResponse = client.listWorkloads(parent);

    List<ListWorkloadsResponse.ComposerWorkload> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getWorkloadsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockEnvironments.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListWorkloadsRequest actualRequest = ((ListWorkloadsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listWorkloadsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEnvironments.addException(exception);

    try {
      EnvironmentName parent = EnvironmentName.of("[PROJECT]", "[LOCATION]", "[ENVIRONMENT]");
      client.listWorkloads(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listWorkloadsTest2() throws Exception {
    ListWorkloadsResponse.ComposerWorkload responsesElement =
        ListWorkloadsResponse.ComposerWorkload.newBuilder().build();
    ListWorkloadsResponse expectedResponse =
        ListWorkloadsResponse.newBuilder()
            .setNextPageToken("")
            .addAllWorkloads(Arrays.asList(responsesElement))
            .build();
    mockEnvironments.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListWorkloadsPagedResponse pagedListResponse = client.listWorkloads(parent);

    List<ListWorkloadsResponse.ComposerWorkload> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getWorkloadsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockEnvironments.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListWorkloadsRequest actualRequest = ((ListWorkloadsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listWorkloadsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEnvironments.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listWorkloads(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createUserWorkloadsSecretTest() throws Exception {
    UserWorkloadsSecret expectedResponse =
        UserWorkloadsSecret.newBuilder()
            .setName(
                UserWorkloadsSecretName.of(
                        "[PROJECT]", "[LOCATION]", "[ENVIRONMENT]", "[USER_WORKLOADS_SECRET]")
                    .toString())
            .putAllData(new HashMap<String, String>())
            .build();
    mockEnvironments.addResponse(expectedResponse);

    EnvironmentName parent = EnvironmentName.of("[PROJECT]", "[LOCATION]", "[ENVIRONMENT]");
    UserWorkloadsSecret userWorkloadsSecret = UserWorkloadsSecret.newBuilder().build();

    UserWorkloadsSecret actualResponse =
        client.createUserWorkloadsSecret(parent, userWorkloadsSecret);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEnvironments.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateUserWorkloadsSecretRequest actualRequest =
        ((CreateUserWorkloadsSecretRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(userWorkloadsSecret, actualRequest.getUserWorkloadsSecret());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createUserWorkloadsSecretExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEnvironments.addException(exception);

    try {
      EnvironmentName parent = EnvironmentName.of("[PROJECT]", "[LOCATION]", "[ENVIRONMENT]");
      UserWorkloadsSecret userWorkloadsSecret = UserWorkloadsSecret.newBuilder().build();
      client.createUserWorkloadsSecret(parent, userWorkloadsSecret);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createUserWorkloadsSecretTest2() throws Exception {
    UserWorkloadsSecret expectedResponse =
        UserWorkloadsSecret.newBuilder()
            .setName(
                UserWorkloadsSecretName.of(
                        "[PROJECT]", "[LOCATION]", "[ENVIRONMENT]", "[USER_WORKLOADS_SECRET]")
                    .toString())
            .putAllData(new HashMap<String, String>())
            .build();
    mockEnvironments.addResponse(expectedResponse);

    String parent = "parent-995424086";
    UserWorkloadsSecret userWorkloadsSecret = UserWorkloadsSecret.newBuilder().build();

    UserWorkloadsSecret actualResponse =
        client.createUserWorkloadsSecret(parent, userWorkloadsSecret);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEnvironments.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateUserWorkloadsSecretRequest actualRequest =
        ((CreateUserWorkloadsSecretRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(userWorkloadsSecret, actualRequest.getUserWorkloadsSecret());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createUserWorkloadsSecretExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEnvironments.addException(exception);

    try {
      String parent = "parent-995424086";
      UserWorkloadsSecret userWorkloadsSecret = UserWorkloadsSecret.newBuilder().build();
      client.createUserWorkloadsSecret(parent, userWorkloadsSecret);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getUserWorkloadsSecretTest() throws Exception {
    UserWorkloadsSecret expectedResponse =
        UserWorkloadsSecret.newBuilder()
            .setName(
                UserWorkloadsSecretName.of(
                        "[PROJECT]", "[LOCATION]", "[ENVIRONMENT]", "[USER_WORKLOADS_SECRET]")
                    .toString())
            .putAllData(new HashMap<String, String>())
            .build();
    mockEnvironments.addResponse(expectedResponse);

    UserWorkloadsSecretName name =
        UserWorkloadsSecretName.of(
            "[PROJECT]", "[LOCATION]", "[ENVIRONMENT]", "[USER_WORKLOADS_SECRET]");

    UserWorkloadsSecret actualResponse = client.getUserWorkloadsSecret(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEnvironments.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetUserWorkloadsSecretRequest actualRequest =
        ((GetUserWorkloadsSecretRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getUserWorkloadsSecretExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEnvironments.addException(exception);

    try {
      UserWorkloadsSecretName name =
          UserWorkloadsSecretName.of(
              "[PROJECT]", "[LOCATION]", "[ENVIRONMENT]", "[USER_WORKLOADS_SECRET]");
      client.getUserWorkloadsSecret(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getUserWorkloadsSecretTest2() throws Exception {
    UserWorkloadsSecret expectedResponse =
        UserWorkloadsSecret.newBuilder()
            .setName(
                UserWorkloadsSecretName.of(
                        "[PROJECT]", "[LOCATION]", "[ENVIRONMENT]", "[USER_WORKLOADS_SECRET]")
                    .toString())
            .putAllData(new HashMap<String, String>())
            .build();
    mockEnvironments.addResponse(expectedResponse);

    String name = "name3373707";

    UserWorkloadsSecret actualResponse = client.getUserWorkloadsSecret(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEnvironments.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetUserWorkloadsSecretRequest actualRequest =
        ((GetUserWorkloadsSecretRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getUserWorkloadsSecretExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEnvironments.addException(exception);

    try {
      String name = "name3373707";
      client.getUserWorkloadsSecret(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listUserWorkloadsSecretsTest() throws Exception {
    UserWorkloadsSecret responsesElement = UserWorkloadsSecret.newBuilder().build();
    ListUserWorkloadsSecretsResponse expectedResponse =
        ListUserWorkloadsSecretsResponse.newBuilder()
            .setNextPageToken("")
            .addAllUserWorkloadsSecrets(Arrays.asList(responsesElement))
            .build();
    mockEnvironments.addResponse(expectedResponse);

    EnvironmentName parent = EnvironmentName.of("[PROJECT]", "[LOCATION]", "[ENVIRONMENT]");

    ListUserWorkloadsSecretsPagedResponse pagedListResponse =
        client.listUserWorkloadsSecrets(parent);

    List<UserWorkloadsSecret> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getUserWorkloadsSecretsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockEnvironments.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListUserWorkloadsSecretsRequest actualRequest =
        ((ListUserWorkloadsSecretsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listUserWorkloadsSecretsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEnvironments.addException(exception);

    try {
      EnvironmentName parent = EnvironmentName.of("[PROJECT]", "[LOCATION]", "[ENVIRONMENT]");
      client.listUserWorkloadsSecrets(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listUserWorkloadsSecretsTest2() throws Exception {
    UserWorkloadsSecret responsesElement = UserWorkloadsSecret.newBuilder().build();
    ListUserWorkloadsSecretsResponse expectedResponse =
        ListUserWorkloadsSecretsResponse.newBuilder()
            .setNextPageToken("")
            .addAllUserWorkloadsSecrets(Arrays.asList(responsesElement))
            .build();
    mockEnvironments.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListUserWorkloadsSecretsPagedResponse pagedListResponse =
        client.listUserWorkloadsSecrets(parent);

    List<UserWorkloadsSecret> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getUserWorkloadsSecretsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockEnvironments.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListUserWorkloadsSecretsRequest actualRequest =
        ((ListUserWorkloadsSecretsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listUserWorkloadsSecretsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEnvironments.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listUserWorkloadsSecrets(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateUserWorkloadsSecretTest() throws Exception {
    UserWorkloadsSecret expectedResponse =
        UserWorkloadsSecret.newBuilder()
            .setName(
                UserWorkloadsSecretName.of(
                        "[PROJECT]", "[LOCATION]", "[ENVIRONMENT]", "[USER_WORKLOADS_SECRET]")
                    .toString())
            .putAllData(new HashMap<String, String>())
            .build();
    mockEnvironments.addResponse(expectedResponse);

    UserWorkloadsSecret userWorkloadsSecret = UserWorkloadsSecret.newBuilder().build();

    UserWorkloadsSecret actualResponse = client.updateUserWorkloadsSecret(userWorkloadsSecret);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEnvironments.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateUserWorkloadsSecretRequest actualRequest =
        ((UpdateUserWorkloadsSecretRequest) actualRequests.get(0));

    Assert.assertEquals(userWorkloadsSecret, actualRequest.getUserWorkloadsSecret());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateUserWorkloadsSecretExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEnvironments.addException(exception);

    try {
      UserWorkloadsSecret userWorkloadsSecret = UserWorkloadsSecret.newBuilder().build();
      client.updateUserWorkloadsSecret(userWorkloadsSecret);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteUserWorkloadsSecretTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockEnvironments.addResponse(expectedResponse);

    UserWorkloadsSecretName name =
        UserWorkloadsSecretName.of(
            "[PROJECT]", "[LOCATION]", "[ENVIRONMENT]", "[USER_WORKLOADS_SECRET]");

    client.deleteUserWorkloadsSecret(name);

    List<AbstractMessage> actualRequests = mockEnvironments.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteUserWorkloadsSecretRequest actualRequest =
        ((DeleteUserWorkloadsSecretRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteUserWorkloadsSecretExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEnvironments.addException(exception);

    try {
      UserWorkloadsSecretName name =
          UserWorkloadsSecretName.of(
              "[PROJECT]", "[LOCATION]", "[ENVIRONMENT]", "[USER_WORKLOADS_SECRET]");
      client.deleteUserWorkloadsSecret(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteUserWorkloadsSecretTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockEnvironments.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteUserWorkloadsSecret(name);

    List<AbstractMessage> actualRequests = mockEnvironments.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteUserWorkloadsSecretRequest actualRequest =
        ((DeleteUserWorkloadsSecretRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteUserWorkloadsSecretExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEnvironments.addException(exception);

    try {
      String name = "name3373707";
      client.deleteUserWorkloadsSecret(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createUserWorkloadsConfigMapTest() throws Exception {
    UserWorkloadsConfigMap expectedResponse =
        UserWorkloadsConfigMap.newBuilder()
            .setName(
                UserWorkloadsConfigMapName.of(
                        "[PROJECT]", "[LOCATION]", "[ENVIRONMENT]", "[USER_WORKLOADS_CONFIG_MAP]")
                    .toString())
            .putAllData(new HashMap<String, String>())
            .build();
    mockEnvironments.addResponse(expectedResponse);

    EnvironmentName parent = EnvironmentName.of("[PROJECT]", "[LOCATION]", "[ENVIRONMENT]");
    UserWorkloadsConfigMap userWorkloadsConfigMap = UserWorkloadsConfigMap.newBuilder().build();

    UserWorkloadsConfigMap actualResponse =
        client.createUserWorkloadsConfigMap(parent, userWorkloadsConfigMap);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEnvironments.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateUserWorkloadsConfigMapRequest actualRequest =
        ((CreateUserWorkloadsConfigMapRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(userWorkloadsConfigMap, actualRequest.getUserWorkloadsConfigMap());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createUserWorkloadsConfigMapExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEnvironments.addException(exception);

    try {
      EnvironmentName parent = EnvironmentName.of("[PROJECT]", "[LOCATION]", "[ENVIRONMENT]");
      UserWorkloadsConfigMap userWorkloadsConfigMap = UserWorkloadsConfigMap.newBuilder().build();
      client.createUserWorkloadsConfigMap(parent, userWorkloadsConfigMap);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createUserWorkloadsConfigMapTest2() throws Exception {
    UserWorkloadsConfigMap expectedResponse =
        UserWorkloadsConfigMap.newBuilder()
            .setName(
                UserWorkloadsConfigMapName.of(
                        "[PROJECT]", "[LOCATION]", "[ENVIRONMENT]", "[USER_WORKLOADS_CONFIG_MAP]")
                    .toString())
            .putAllData(new HashMap<String, String>())
            .build();
    mockEnvironments.addResponse(expectedResponse);

    String parent = "parent-995424086";
    UserWorkloadsConfigMap userWorkloadsConfigMap = UserWorkloadsConfigMap.newBuilder().build();

    UserWorkloadsConfigMap actualResponse =
        client.createUserWorkloadsConfigMap(parent, userWorkloadsConfigMap);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEnvironments.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateUserWorkloadsConfigMapRequest actualRequest =
        ((CreateUserWorkloadsConfigMapRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(userWorkloadsConfigMap, actualRequest.getUserWorkloadsConfigMap());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createUserWorkloadsConfigMapExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEnvironments.addException(exception);

    try {
      String parent = "parent-995424086";
      UserWorkloadsConfigMap userWorkloadsConfigMap = UserWorkloadsConfigMap.newBuilder().build();
      client.createUserWorkloadsConfigMap(parent, userWorkloadsConfigMap);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getUserWorkloadsConfigMapTest() throws Exception {
    UserWorkloadsConfigMap expectedResponse =
        UserWorkloadsConfigMap.newBuilder()
            .setName(
                UserWorkloadsConfigMapName.of(
                        "[PROJECT]", "[LOCATION]", "[ENVIRONMENT]", "[USER_WORKLOADS_CONFIG_MAP]")
                    .toString())
            .putAllData(new HashMap<String, String>())
            .build();
    mockEnvironments.addResponse(expectedResponse);

    UserWorkloadsConfigMapName name =
        UserWorkloadsConfigMapName.of(
            "[PROJECT]", "[LOCATION]", "[ENVIRONMENT]", "[USER_WORKLOADS_CONFIG_MAP]");

    UserWorkloadsConfigMap actualResponse = client.getUserWorkloadsConfigMap(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEnvironments.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetUserWorkloadsConfigMapRequest actualRequest =
        ((GetUserWorkloadsConfigMapRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getUserWorkloadsConfigMapExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEnvironments.addException(exception);

    try {
      UserWorkloadsConfigMapName name =
          UserWorkloadsConfigMapName.of(
              "[PROJECT]", "[LOCATION]", "[ENVIRONMENT]", "[USER_WORKLOADS_CONFIG_MAP]");
      client.getUserWorkloadsConfigMap(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getUserWorkloadsConfigMapTest2() throws Exception {
    UserWorkloadsConfigMap expectedResponse =
        UserWorkloadsConfigMap.newBuilder()
            .setName(
                UserWorkloadsConfigMapName.of(
                        "[PROJECT]", "[LOCATION]", "[ENVIRONMENT]", "[USER_WORKLOADS_CONFIG_MAP]")
                    .toString())
            .putAllData(new HashMap<String, String>())
            .build();
    mockEnvironments.addResponse(expectedResponse);

    String name = "name3373707";

    UserWorkloadsConfigMap actualResponse = client.getUserWorkloadsConfigMap(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEnvironments.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetUserWorkloadsConfigMapRequest actualRequest =
        ((GetUserWorkloadsConfigMapRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getUserWorkloadsConfigMapExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEnvironments.addException(exception);

    try {
      String name = "name3373707";
      client.getUserWorkloadsConfigMap(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listUserWorkloadsConfigMapsTest() throws Exception {
    UserWorkloadsConfigMap responsesElement = UserWorkloadsConfigMap.newBuilder().build();
    ListUserWorkloadsConfigMapsResponse expectedResponse =
        ListUserWorkloadsConfigMapsResponse.newBuilder()
            .setNextPageToken("")
            .addAllUserWorkloadsConfigMaps(Arrays.asList(responsesElement))
            .build();
    mockEnvironments.addResponse(expectedResponse);

    EnvironmentName parent = EnvironmentName.of("[PROJECT]", "[LOCATION]", "[ENVIRONMENT]");

    ListUserWorkloadsConfigMapsPagedResponse pagedListResponse =
        client.listUserWorkloadsConfigMaps(parent);

    List<UserWorkloadsConfigMap> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getUserWorkloadsConfigMapsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockEnvironments.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListUserWorkloadsConfigMapsRequest actualRequest =
        ((ListUserWorkloadsConfigMapsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listUserWorkloadsConfigMapsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEnvironments.addException(exception);

    try {
      EnvironmentName parent = EnvironmentName.of("[PROJECT]", "[LOCATION]", "[ENVIRONMENT]");
      client.listUserWorkloadsConfigMaps(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listUserWorkloadsConfigMapsTest2() throws Exception {
    UserWorkloadsConfigMap responsesElement = UserWorkloadsConfigMap.newBuilder().build();
    ListUserWorkloadsConfigMapsResponse expectedResponse =
        ListUserWorkloadsConfigMapsResponse.newBuilder()
            .setNextPageToken("")
            .addAllUserWorkloadsConfigMaps(Arrays.asList(responsesElement))
            .build();
    mockEnvironments.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListUserWorkloadsConfigMapsPagedResponse pagedListResponse =
        client.listUserWorkloadsConfigMaps(parent);

    List<UserWorkloadsConfigMap> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getUserWorkloadsConfigMapsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockEnvironments.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListUserWorkloadsConfigMapsRequest actualRequest =
        ((ListUserWorkloadsConfigMapsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listUserWorkloadsConfigMapsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEnvironments.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listUserWorkloadsConfigMaps(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateUserWorkloadsConfigMapTest() throws Exception {
    UserWorkloadsConfigMap expectedResponse =
        UserWorkloadsConfigMap.newBuilder()
            .setName(
                UserWorkloadsConfigMapName.of(
                        "[PROJECT]", "[LOCATION]", "[ENVIRONMENT]", "[USER_WORKLOADS_CONFIG_MAP]")
                    .toString())
            .putAllData(new HashMap<String, String>())
            .build();
    mockEnvironments.addResponse(expectedResponse);

    UserWorkloadsConfigMap userWorkloadsConfigMap = UserWorkloadsConfigMap.newBuilder().build();

    UserWorkloadsConfigMap actualResponse =
        client.updateUserWorkloadsConfigMap(userWorkloadsConfigMap);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEnvironments.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateUserWorkloadsConfigMapRequest actualRequest =
        ((UpdateUserWorkloadsConfigMapRequest) actualRequests.get(0));

    Assert.assertEquals(userWorkloadsConfigMap, actualRequest.getUserWorkloadsConfigMap());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateUserWorkloadsConfigMapExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEnvironments.addException(exception);

    try {
      UserWorkloadsConfigMap userWorkloadsConfigMap = UserWorkloadsConfigMap.newBuilder().build();
      client.updateUserWorkloadsConfigMap(userWorkloadsConfigMap);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteUserWorkloadsConfigMapTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockEnvironments.addResponse(expectedResponse);

    UserWorkloadsConfigMapName name =
        UserWorkloadsConfigMapName.of(
            "[PROJECT]", "[LOCATION]", "[ENVIRONMENT]", "[USER_WORKLOADS_CONFIG_MAP]");

    client.deleteUserWorkloadsConfigMap(name);

    List<AbstractMessage> actualRequests = mockEnvironments.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteUserWorkloadsConfigMapRequest actualRequest =
        ((DeleteUserWorkloadsConfigMapRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteUserWorkloadsConfigMapExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEnvironments.addException(exception);

    try {
      UserWorkloadsConfigMapName name =
          UserWorkloadsConfigMapName.of(
              "[PROJECT]", "[LOCATION]", "[ENVIRONMENT]", "[USER_WORKLOADS_CONFIG_MAP]");
      client.deleteUserWorkloadsConfigMap(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteUserWorkloadsConfigMapTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockEnvironments.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteUserWorkloadsConfigMap(name);

    List<AbstractMessage> actualRequests = mockEnvironments.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteUserWorkloadsConfigMapRequest actualRequest =
        ((DeleteUserWorkloadsConfigMapRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteUserWorkloadsConfigMapExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEnvironments.addException(exception);

    try {
      String name = "name3373707";
      client.deleteUserWorkloadsConfigMap(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void saveSnapshotTest() throws Exception {
    SaveSnapshotResponse expectedResponse =
        SaveSnapshotResponse.newBuilder().setSnapshotPath("snapshotPath-931648503").build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("saveSnapshotTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockEnvironments.addResponse(resultOperation);

    SaveSnapshotRequest request =
        SaveSnapshotRequest.newBuilder()
            .setEnvironment("environment-85904877")
            .setSnapshotLocation("snapshotLocation1625609625")
            .build();

    SaveSnapshotResponse actualResponse = client.saveSnapshotAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEnvironments.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SaveSnapshotRequest actualRequest = ((SaveSnapshotRequest) actualRequests.get(0));

    Assert.assertEquals(request.getEnvironment(), actualRequest.getEnvironment());
    Assert.assertEquals(request.getSnapshotLocation(), actualRequest.getSnapshotLocation());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void saveSnapshotExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEnvironments.addException(exception);

    try {
      SaveSnapshotRequest request =
          SaveSnapshotRequest.newBuilder()
              .setEnvironment("environment-85904877")
              .setSnapshotLocation("snapshotLocation1625609625")
              .build();
      client.saveSnapshotAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void loadSnapshotTest() throws Exception {
    LoadSnapshotResponse expectedResponse = LoadSnapshotResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("loadSnapshotTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockEnvironments.addResponse(resultOperation);

    LoadSnapshotRequest request =
        LoadSnapshotRequest.newBuilder()
            .setEnvironment("environment-85904877")
            .setSnapshotPath("snapshotPath-931648503")
            .setSkipPypiPackagesInstallation(true)
            .setSkipEnvironmentVariablesSetting(true)
            .setSkipAirflowOverridesSetting(true)
            .setSkipGcsDataCopying(true)
            .build();

    LoadSnapshotResponse actualResponse = client.loadSnapshotAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEnvironments.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    LoadSnapshotRequest actualRequest = ((LoadSnapshotRequest) actualRequests.get(0));

    Assert.assertEquals(request.getEnvironment(), actualRequest.getEnvironment());
    Assert.assertEquals(request.getSnapshotPath(), actualRequest.getSnapshotPath());
    Assert.assertEquals(
        request.getSkipPypiPackagesInstallation(), actualRequest.getSkipPypiPackagesInstallation());
    Assert.assertEquals(
        request.getSkipEnvironmentVariablesSetting(),
        actualRequest.getSkipEnvironmentVariablesSetting());
    Assert.assertEquals(
        request.getSkipAirflowOverridesSetting(), actualRequest.getSkipAirflowOverridesSetting());
    Assert.assertEquals(request.getSkipGcsDataCopying(), actualRequest.getSkipGcsDataCopying());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void loadSnapshotExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEnvironments.addException(exception);

    try {
      LoadSnapshotRequest request =
          LoadSnapshotRequest.newBuilder()
              .setEnvironment("environment-85904877")
              .setSnapshotPath("snapshotPath-931648503")
              .setSkipPypiPackagesInstallation(true)
              .setSkipEnvironmentVariablesSetting(true)
              .setSkipAirflowOverridesSetting(true)
              .setSkipGcsDataCopying(true)
              .build();
      client.loadSnapshotAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void databaseFailoverTest() throws Exception {
    DatabaseFailoverResponse expectedResponse = DatabaseFailoverResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("databaseFailoverTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockEnvironments.addResponse(resultOperation);

    DatabaseFailoverRequest request =
        DatabaseFailoverRequest.newBuilder().setEnvironment("environment-85904877").build();

    DatabaseFailoverResponse actualResponse = client.databaseFailoverAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEnvironments.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DatabaseFailoverRequest actualRequest = ((DatabaseFailoverRequest) actualRequests.get(0));

    Assert.assertEquals(request.getEnvironment(), actualRequest.getEnvironment());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void databaseFailoverExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEnvironments.addException(exception);

    try {
      DatabaseFailoverRequest request =
          DatabaseFailoverRequest.newBuilder().setEnvironment("environment-85904877").build();
      client.databaseFailoverAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void fetchDatabasePropertiesTest() throws Exception {
    FetchDatabasePropertiesResponse expectedResponse =
        FetchDatabasePropertiesResponse.newBuilder()
            .setPrimaryGceZone("primaryGceZone-1629643277")
            .setSecondaryGceZone("secondaryGceZone227989057")
            .setIsFailoverReplicaAvailable(true)
            .build();
    mockEnvironments.addResponse(expectedResponse);

    FetchDatabasePropertiesRequest request =
        FetchDatabasePropertiesRequest.newBuilder()
            .setEnvironment(
                EnvironmentName.of("[PROJECT]", "[LOCATION]", "[ENVIRONMENT]").toString())
            .build();

    FetchDatabasePropertiesResponse actualResponse = client.fetchDatabaseProperties(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEnvironments.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    FetchDatabasePropertiesRequest actualRequest =
        ((FetchDatabasePropertiesRequest) actualRequests.get(0));

    Assert.assertEquals(request.getEnvironment(), actualRequest.getEnvironment());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void fetchDatabasePropertiesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEnvironments.addException(exception);

    try {
      FetchDatabasePropertiesRequest request =
          FetchDatabasePropertiesRequest.newBuilder()
              .setEnvironment(
                  EnvironmentName.of("[PROJECT]", "[LOCATION]", "[ENVIRONMENT]").toString())
              .build();
      client.fetchDatabaseProperties(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
