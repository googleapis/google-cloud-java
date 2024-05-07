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

package com.google.cloud.visionai.v1;

import static com.google.cloud.visionai.v1.AppPlatformClient.ListApplicationsPagedResponse;
import static com.google.cloud.visionai.v1.AppPlatformClient.ListDraftsPagedResponse;
import static com.google.cloud.visionai.v1.AppPlatformClient.ListInstancesPagedResponse;
import static com.google.cloud.visionai.v1.AppPlatformClient.ListProcessorsPagedResponse;

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
public class AppPlatformClientTest {
  private static MockAppPlatform mockAppPlatform;
  private static MockIAMPolicy mockIAMPolicy;
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private AppPlatformClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockAppPlatform = new MockAppPlatform();
    mockLocations = new MockLocations();
    mockIAMPolicy = new MockIAMPolicy();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockAppPlatform, mockLocations, mockIAMPolicy));
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
    AppPlatformSettings settings =
        AppPlatformSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = AppPlatformClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listApplicationsTest() throws Exception {
    Application responsesElement = Application.newBuilder().build();
    ListApplicationsResponse expectedResponse =
        ListApplicationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllApplications(Arrays.asList(responsesElement))
            .build();
    mockAppPlatform.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListApplicationsPagedResponse pagedListResponse = client.listApplications(parent);

    List<Application> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getApplicationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAppPlatform.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListApplicationsRequest actualRequest = ((ListApplicationsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listApplicationsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppPlatform.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listApplications(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listApplicationsTest2() throws Exception {
    Application responsesElement = Application.newBuilder().build();
    ListApplicationsResponse expectedResponse =
        ListApplicationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllApplications(Arrays.asList(responsesElement))
            .build();
    mockAppPlatform.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListApplicationsPagedResponse pagedListResponse = client.listApplications(parent);

    List<Application> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getApplicationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAppPlatform.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListApplicationsRequest actualRequest = ((ListApplicationsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listApplicationsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppPlatform.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listApplications(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getApplicationTest() throws Exception {
    Application expectedResponse =
        Application.newBuilder()
            .setName(ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setApplicationConfigs(ApplicationConfigs.newBuilder().build())
            .setRuntimeInfo(Application.ApplicationRuntimeInfo.newBuilder().build())
            .build();
    mockAppPlatform.addResponse(expectedResponse);

    ApplicationName name = ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]");

    Application actualResponse = client.getApplication(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAppPlatform.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetApplicationRequest actualRequest = ((GetApplicationRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getApplicationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppPlatform.addException(exception);

    try {
      ApplicationName name = ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]");
      client.getApplication(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getApplicationTest2() throws Exception {
    Application expectedResponse =
        Application.newBuilder()
            .setName(ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setApplicationConfigs(ApplicationConfigs.newBuilder().build())
            .setRuntimeInfo(Application.ApplicationRuntimeInfo.newBuilder().build())
            .build();
    mockAppPlatform.addResponse(expectedResponse);

    String name = "name3373707";

    Application actualResponse = client.getApplication(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAppPlatform.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetApplicationRequest actualRequest = ((GetApplicationRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getApplicationExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppPlatform.addException(exception);

    try {
      String name = "name3373707";
      client.getApplication(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createApplicationTest() throws Exception {
    Application expectedResponse =
        Application.newBuilder()
            .setName(ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setApplicationConfigs(ApplicationConfigs.newBuilder().build())
            .setRuntimeInfo(Application.ApplicationRuntimeInfo.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createApplicationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAppPlatform.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Application application = Application.newBuilder().build();

    Application actualResponse = client.createApplicationAsync(parent, application).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAppPlatform.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateApplicationRequest actualRequest = ((CreateApplicationRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(application, actualRequest.getApplication());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createApplicationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppPlatform.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Application application = Application.newBuilder().build();
      client.createApplicationAsync(parent, application).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createApplicationTest2() throws Exception {
    Application expectedResponse =
        Application.newBuilder()
            .setName(ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setApplicationConfigs(ApplicationConfigs.newBuilder().build())
            .setRuntimeInfo(Application.ApplicationRuntimeInfo.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createApplicationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAppPlatform.addResponse(resultOperation);

    String parent = "parent-995424086";
    Application application = Application.newBuilder().build();

    Application actualResponse = client.createApplicationAsync(parent, application).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAppPlatform.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateApplicationRequest actualRequest = ((CreateApplicationRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(application, actualRequest.getApplication());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createApplicationExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppPlatform.addException(exception);

    try {
      String parent = "parent-995424086";
      Application application = Application.newBuilder().build();
      client.createApplicationAsync(parent, application).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateApplicationTest() throws Exception {
    Application expectedResponse =
        Application.newBuilder()
            .setName(ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setApplicationConfigs(ApplicationConfigs.newBuilder().build())
            .setRuntimeInfo(Application.ApplicationRuntimeInfo.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateApplicationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAppPlatform.addResponse(resultOperation);

    Application application = Application.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Application actualResponse = client.updateApplicationAsync(application, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAppPlatform.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateApplicationRequest actualRequest = ((UpdateApplicationRequest) actualRequests.get(0));

    Assert.assertEquals(application, actualRequest.getApplication());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateApplicationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppPlatform.addException(exception);

    try {
      Application application = Application.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateApplicationAsync(application, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteApplicationTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteApplicationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAppPlatform.addResponse(resultOperation);

    ApplicationName name = ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]");

    client.deleteApplicationAsync(name).get();

    List<AbstractMessage> actualRequests = mockAppPlatform.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteApplicationRequest actualRequest = ((DeleteApplicationRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteApplicationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppPlatform.addException(exception);

    try {
      ApplicationName name = ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]");
      client.deleteApplicationAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteApplicationTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteApplicationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAppPlatform.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteApplicationAsync(name).get();

    List<AbstractMessage> actualRequests = mockAppPlatform.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteApplicationRequest actualRequest = ((DeleteApplicationRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteApplicationExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppPlatform.addException(exception);

    try {
      String name = "name3373707";
      client.deleteApplicationAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deployApplicationTest() throws Exception {
    DeployApplicationResponse expectedResponse = DeployApplicationResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deployApplicationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAppPlatform.addResponse(resultOperation);

    ApplicationName name = ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]");

    DeployApplicationResponse actualResponse = client.deployApplicationAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAppPlatform.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeployApplicationRequest actualRequest = ((DeployApplicationRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deployApplicationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppPlatform.addException(exception);

    try {
      ApplicationName name = ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]");
      client.deployApplicationAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deployApplicationTest2() throws Exception {
    DeployApplicationResponse expectedResponse = DeployApplicationResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deployApplicationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAppPlatform.addResponse(resultOperation);

    String name = "name3373707";

    DeployApplicationResponse actualResponse = client.deployApplicationAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAppPlatform.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeployApplicationRequest actualRequest = ((DeployApplicationRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deployApplicationExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppPlatform.addException(exception);

    try {
      String name = "name3373707";
      client.deployApplicationAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void undeployApplicationTest() throws Exception {
    UndeployApplicationResponse expectedResponse = UndeployApplicationResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("undeployApplicationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAppPlatform.addResponse(resultOperation);

    ApplicationName name = ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]");

    UndeployApplicationResponse actualResponse = client.undeployApplicationAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAppPlatform.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UndeployApplicationRequest actualRequest = ((UndeployApplicationRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void undeployApplicationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppPlatform.addException(exception);

    try {
      ApplicationName name = ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]");
      client.undeployApplicationAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void undeployApplicationTest2() throws Exception {
    UndeployApplicationResponse expectedResponse = UndeployApplicationResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("undeployApplicationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAppPlatform.addResponse(resultOperation);

    String name = "name3373707";

    UndeployApplicationResponse actualResponse = client.undeployApplicationAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAppPlatform.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UndeployApplicationRequest actualRequest = ((UndeployApplicationRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void undeployApplicationExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppPlatform.addException(exception);

    try {
      String name = "name3373707";
      client.undeployApplicationAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void addApplicationStreamInputTest() throws Exception {
    AddApplicationStreamInputResponse expectedResponse =
        AddApplicationStreamInputResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("addApplicationStreamInputTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAppPlatform.addResponse(resultOperation);

    ApplicationName name = ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]");

    AddApplicationStreamInputResponse actualResponse =
        client.addApplicationStreamInputAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAppPlatform.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    AddApplicationStreamInputRequest actualRequest =
        ((AddApplicationStreamInputRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void addApplicationStreamInputExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppPlatform.addException(exception);

    try {
      ApplicationName name = ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]");
      client.addApplicationStreamInputAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void addApplicationStreamInputTest2() throws Exception {
    AddApplicationStreamInputResponse expectedResponse =
        AddApplicationStreamInputResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("addApplicationStreamInputTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAppPlatform.addResponse(resultOperation);

    String name = "name3373707";

    AddApplicationStreamInputResponse actualResponse =
        client.addApplicationStreamInputAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAppPlatform.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    AddApplicationStreamInputRequest actualRequest =
        ((AddApplicationStreamInputRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void addApplicationStreamInputExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppPlatform.addException(exception);

    try {
      String name = "name3373707";
      client.addApplicationStreamInputAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void removeApplicationStreamInputTest() throws Exception {
    RemoveApplicationStreamInputResponse expectedResponse =
        RemoveApplicationStreamInputResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("removeApplicationStreamInputTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAppPlatform.addResponse(resultOperation);

    ApplicationName name = ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]");

    RemoveApplicationStreamInputResponse actualResponse =
        client.removeApplicationStreamInputAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAppPlatform.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RemoveApplicationStreamInputRequest actualRequest =
        ((RemoveApplicationStreamInputRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void removeApplicationStreamInputExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppPlatform.addException(exception);

    try {
      ApplicationName name = ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]");
      client.removeApplicationStreamInputAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void removeApplicationStreamInputTest2() throws Exception {
    RemoveApplicationStreamInputResponse expectedResponse =
        RemoveApplicationStreamInputResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("removeApplicationStreamInputTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAppPlatform.addResponse(resultOperation);

    String name = "name3373707";

    RemoveApplicationStreamInputResponse actualResponse =
        client.removeApplicationStreamInputAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAppPlatform.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RemoveApplicationStreamInputRequest actualRequest =
        ((RemoveApplicationStreamInputRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void removeApplicationStreamInputExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppPlatform.addException(exception);

    try {
      String name = "name3373707";
      client.removeApplicationStreamInputAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateApplicationStreamInputTest() throws Exception {
    UpdateApplicationStreamInputResponse expectedResponse =
        UpdateApplicationStreamInputResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateApplicationStreamInputTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAppPlatform.addResponse(resultOperation);

    ApplicationName name = ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]");

    UpdateApplicationStreamInputResponse actualResponse =
        client.updateApplicationStreamInputAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAppPlatform.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateApplicationStreamInputRequest actualRequest =
        ((UpdateApplicationStreamInputRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateApplicationStreamInputExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppPlatform.addException(exception);

    try {
      ApplicationName name = ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]");
      client.updateApplicationStreamInputAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateApplicationStreamInputTest2() throws Exception {
    UpdateApplicationStreamInputResponse expectedResponse =
        UpdateApplicationStreamInputResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateApplicationStreamInputTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAppPlatform.addResponse(resultOperation);

    String name = "name3373707";

    UpdateApplicationStreamInputResponse actualResponse =
        client.updateApplicationStreamInputAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAppPlatform.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateApplicationStreamInputRequest actualRequest =
        ((UpdateApplicationStreamInputRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateApplicationStreamInputExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppPlatform.addException(exception);

    try {
      String name = "name3373707";
      client.updateApplicationStreamInputAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listInstancesTest() throws Exception {
    Instance responsesElement = Instance.newBuilder().build();
    ListInstancesResponse expectedResponse =
        ListInstancesResponse.newBuilder()
            .setNextPageToken("")
            .addAllInstances(Arrays.asList(responsesElement))
            .build();
    mockAppPlatform.addResponse(expectedResponse);

    ApplicationName parent = ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]");

    ListInstancesPagedResponse pagedListResponse = client.listInstances(parent);

    List<Instance> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getInstancesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAppPlatform.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListInstancesRequest actualRequest = ((ListInstancesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listInstancesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppPlatform.addException(exception);

    try {
      ApplicationName parent = ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]");
      client.listInstances(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listInstancesTest2() throws Exception {
    Instance responsesElement = Instance.newBuilder().build();
    ListInstancesResponse expectedResponse =
        ListInstancesResponse.newBuilder()
            .setNextPageToken("")
            .addAllInstances(Arrays.asList(responsesElement))
            .build();
    mockAppPlatform.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListInstancesPagedResponse pagedListResponse = client.listInstances(parent);

    List<Instance> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getInstancesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAppPlatform.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListInstancesRequest actualRequest = ((ListInstancesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listInstancesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppPlatform.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listInstances(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getInstanceTest() throws Exception {
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(
                InstanceName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]", "[INSTANCE]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllInputResources(new ArrayList<Instance.InputResource>())
            .addAllOutputResources(new ArrayList<Instance.OutputResource>())
            .build();
    mockAppPlatform.addResponse(expectedResponse);

    InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]", "[INSTANCE]");

    Instance actualResponse = client.getInstance(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAppPlatform.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetInstanceRequest actualRequest = ((GetInstanceRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getInstanceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppPlatform.addException(exception);

    try {
      InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]", "[INSTANCE]");
      client.getInstance(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getInstanceTest2() throws Exception {
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(
                InstanceName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]", "[INSTANCE]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllInputResources(new ArrayList<Instance.InputResource>())
            .addAllOutputResources(new ArrayList<Instance.OutputResource>())
            .build();
    mockAppPlatform.addResponse(expectedResponse);

    String name = "name3373707";

    Instance actualResponse = client.getInstance(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAppPlatform.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetInstanceRequest actualRequest = ((GetInstanceRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getInstanceExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppPlatform.addException(exception);

    try {
      String name = "name3373707";
      client.getInstance(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createApplicationInstancesTest() throws Exception {
    CreateApplicationInstancesResponse expectedResponse =
        CreateApplicationInstancesResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createApplicationInstancesTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAppPlatform.addResponse(resultOperation);

    ApplicationName name = ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]");

    CreateApplicationInstancesResponse actualResponse =
        client.createApplicationInstancesAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAppPlatform.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateApplicationInstancesRequest actualRequest =
        ((CreateApplicationInstancesRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createApplicationInstancesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppPlatform.addException(exception);

    try {
      ApplicationName name = ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]");
      client.createApplicationInstancesAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createApplicationInstancesTest2() throws Exception {
    CreateApplicationInstancesResponse expectedResponse =
        CreateApplicationInstancesResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createApplicationInstancesTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAppPlatform.addResponse(resultOperation);

    String name = "name3373707";

    CreateApplicationInstancesResponse actualResponse =
        client.createApplicationInstancesAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAppPlatform.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateApplicationInstancesRequest actualRequest =
        ((CreateApplicationInstancesRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createApplicationInstancesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppPlatform.addException(exception);

    try {
      String name = "name3373707";
      client.createApplicationInstancesAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteApplicationInstancesTest() throws Exception {
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(
                InstanceName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]", "[INSTANCE]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllInputResources(new ArrayList<Instance.InputResource>())
            .addAllOutputResources(new ArrayList<Instance.OutputResource>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteApplicationInstancesTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAppPlatform.addResponse(resultOperation);

    ApplicationName name = ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]");

    Instance actualResponse = client.deleteApplicationInstancesAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAppPlatform.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteApplicationInstancesRequest actualRequest =
        ((DeleteApplicationInstancesRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteApplicationInstancesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppPlatform.addException(exception);

    try {
      ApplicationName name = ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]");
      client.deleteApplicationInstancesAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteApplicationInstancesTest2() throws Exception {
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(
                InstanceName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]", "[INSTANCE]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllInputResources(new ArrayList<Instance.InputResource>())
            .addAllOutputResources(new ArrayList<Instance.OutputResource>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteApplicationInstancesTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAppPlatform.addResponse(resultOperation);

    String name = "name3373707";

    Instance actualResponse = client.deleteApplicationInstancesAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAppPlatform.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteApplicationInstancesRequest actualRequest =
        ((DeleteApplicationInstancesRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteApplicationInstancesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppPlatform.addException(exception);

    try {
      String name = "name3373707";
      client.deleteApplicationInstancesAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateApplicationInstancesTest() throws Exception {
    UpdateApplicationInstancesResponse expectedResponse =
        UpdateApplicationInstancesResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateApplicationInstancesTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAppPlatform.addResponse(resultOperation);

    ApplicationName name = ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]");
    List<UpdateApplicationInstancesRequest.UpdateApplicationInstance> applicationInstances =
        new ArrayList<>();

    UpdateApplicationInstancesResponse actualResponse =
        client.updateApplicationInstancesAsync(name, applicationInstances).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAppPlatform.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateApplicationInstancesRequest actualRequest =
        ((UpdateApplicationInstancesRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(applicationInstances, actualRequest.getApplicationInstancesList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateApplicationInstancesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppPlatform.addException(exception);

    try {
      ApplicationName name = ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]");
      List<UpdateApplicationInstancesRequest.UpdateApplicationInstance> applicationInstances =
          new ArrayList<>();
      client.updateApplicationInstancesAsync(name, applicationInstances).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateApplicationInstancesTest2() throws Exception {
    UpdateApplicationInstancesResponse expectedResponse =
        UpdateApplicationInstancesResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateApplicationInstancesTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAppPlatform.addResponse(resultOperation);

    String name = "name3373707";
    List<UpdateApplicationInstancesRequest.UpdateApplicationInstance> applicationInstances =
        new ArrayList<>();

    UpdateApplicationInstancesResponse actualResponse =
        client.updateApplicationInstancesAsync(name, applicationInstances).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAppPlatform.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateApplicationInstancesRequest actualRequest =
        ((UpdateApplicationInstancesRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(applicationInstances, actualRequest.getApplicationInstancesList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateApplicationInstancesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppPlatform.addException(exception);

    try {
      String name = "name3373707";
      List<UpdateApplicationInstancesRequest.UpdateApplicationInstance> applicationInstances =
          new ArrayList<>();
      client.updateApplicationInstancesAsync(name, applicationInstances).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listDraftsTest() throws Exception {
    Draft responsesElement = Draft.newBuilder().build();
    ListDraftsResponse expectedResponse =
        ListDraftsResponse.newBuilder()
            .setNextPageToken("")
            .addAllDrafts(Arrays.asList(responsesElement))
            .build();
    mockAppPlatform.addResponse(expectedResponse);

    ApplicationName parent = ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]");

    ListDraftsPagedResponse pagedListResponse = client.listDrafts(parent);

    List<Draft> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDraftsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAppPlatform.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDraftsRequest actualRequest = ((ListDraftsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDraftsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppPlatform.addException(exception);

    try {
      ApplicationName parent = ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]");
      client.listDrafts(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDraftsTest2() throws Exception {
    Draft responsesElement = Draft.newBuilder().build();
    ListDraftsResponse expectedResponse =
        ListDraftsResponse.newBuilder()
            .setNextPageToken("")
            .addAllDrafts(Arrays.asList(responsesElement))
            .build();
    mockAppPlatform.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListDraftsPagedResponse pagedListResponse = client.listDrafts(parent);

    List<Draft> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDraftsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAppPlatform.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDraftsRequest actualRequest = ((ListDraftsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDraftsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppPlatform.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listDrafts(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDraftTest() throws Exception {
    Draft expectedResponse =
        Draft.newBuilder()
            .setName(DraftName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]", "[DRAFT]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setDraftApplicationConfigs(ApplicationConfigs.newBuilder().build())
            .build();
    mockAppPlatform.addResponse(expectedResponse);

    DraftName name = DraftName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]", "[DRAFT]");

    Draft actualResponse = client.getDraft(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAppPlatform.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDraftRequest actualRequest = ((GetDraftRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDraftExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppPlatform.addException(exception);

    try {
      DraftName name = DraftName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]", "[DRAFT]");
      client.getDraft(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDraftTest2() throws Exception {
    Draft expectedResponse =
        Draft.newBuilder()
            .setName(DraftName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]", "[DRAFT]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setDraftApplicationConfigs(ApplicationConfigs.newBuilder().build())
            .build();
    mockAppPlatform.addResponse(expectedResponse);

    String name = "name3373707";

    Draft actualResponse = client.getDraft(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAppPlatform.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDraftRequest actualRequest = ((GetDraftRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDraftExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppPlatform.addException(exception);

    try {
      String name = "name3373707";
      client.getDraft(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createDraftTest() throws Exception {
    Draft expectedResponse =
        Draft.newBuilder()
            .setName(DraftName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]", "[DRAFT]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setDraftApplicationConfigs(ApplicationConfigs.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createDraftTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAppPlatform.addResponse(resultOperation);

    ApplicationName parent = ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]");
    Draft draft = Draft.newBuilder().build();
    String draftId = "draftId1912512156";

    Draft actualResponse = client.createDraftAsync(parent, draft, draftId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAppPlatform.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateDraftRequest actualRequest = ((CreateDraftRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(draft, actualRequest.getDraft());
    Assert.assertEquals(draftId, actualRequest.getDraftId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createDraftExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppPlatform.addException(exception);

    try {
      ApplicationName parent = ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]");
      Draft draft = Draft.newBuilder().build();
      String draftId = "draftId1912512156";
      client.createDraftAsync(parent, draft, draftId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createDraftTest2() throws Exception {
    Draft expectedResponse =
        Draft.newBuilder()
            .setName(DraftName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]", "[DRAFT]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setDraftApplicationConfigs(ApplicationConfigs.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createDraftTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAppPlatform.addResponse(resultOperation);

    String parent = "parent-995424086";
    Draft draft = Draft.newBuilder().build();
    String draftId = "draftId1912512156";

    Draft actualResponse = client.createDraftAsync(parent, draft, draftId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAppPlatform.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateDraftRequest actualRequest = ((CreateDraftRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(draft, actualRequest.getDraft());
    Assert.assertEquals(draftId, actualRequest.getDraftId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createDraftExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppPlatform.addException(exception);

    try {
      String parent = "parent-995424086";
      Draft draft = Draft.newBuilder().build();
      String draftId = "draftId1912512156";
      client.createDraftAsync(parent, draft, draftId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateDraftTest() throws Exception {
    Draft expectedResponse =
        Draft.newBuilder()
            .setName(DraftName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]", "[DRAFT]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setDraftApplicationConfigs(ApplicationConfigs.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateDraftTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAppPlatform.addResponse(resultOperation);

    Draft draft = Draft.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Draft actualResponse = client.updateDraftAsync(draft, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAppPlatform.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateDraftRequest actualRequest = ((UpdateDraftRequest) actualRequests.get(0));

    Assert.assertEquals(draft, actualRequest.getDraft());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateDraftExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppPlatform.addException(exception);

    try {
      Draft draft = Draft.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateDraftAsync(draft, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteDraftTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteDraftTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAppPlatform.addResponse(resultOperation);

    DraftName name = DraftName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]", "[DRAFT]");

    client.deleteDraftAsync(name).get();

    List<AbstractMessage> actualRequests = mockAppPlatform.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteDraftRequest actualRequest = ((DeleteDraftRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteDraftExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppPlatform.addException(exception);

    try {
      DraftName name = DraftName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]", "[DRAFT]");
      client.deleteDraftAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteDraftTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteDraftTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAppPlatform.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteDraftAsync(name).get();

    List<AbstractMessage> actualRequests = mockAppPlatform.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteDraftRequest actualRequest = ((DeleteDraftRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteDraftExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppPlatform.addException(exception);

    try {
      String name = "name3373707";
      client.deleteDraftAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listProcessorsTest() throws Exception {
    Processor responsesElement = Processor.newBuilder().build();
    ListProcessorsResponse expectedResponse =
        ListProcessorsResponse.newBuilder()
            .setNextPageToken("")
            .addAllProcessors(Arrays.asList(responsesElement))
            .build();
    mockAppPlatform.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListProcessorsPagedResponse pagedListResponse = client.listProcessors(parent);

    List<Processor> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getProcessorsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAppPlatform.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListProcessorsRequest actualRequest = ((ListProcessorsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listProcessorsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppPlatform.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listProcessors(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listProcessorsTest2() throws Exception {
    Processor responsesElement = Processor.newBuilder().build();
    ListProcessorsResponse expectedResponse =
        ListProcessorsResponse.newBuilder()
            .setNextPageToken("")
            .addAllProcessors(Arrays.asList(responsesElement))
            .build();
    mockAppPlatform.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListProcessorsPagedResponse pagedListResponse = client.listProcessors(parent);

    List<Processor> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getProcessorsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAppPlatform.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListProcessorsRequest actualRequest = ((ListProcessorsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listProcessorsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppPlatform.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listProcessors(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listPrebuiltProcessorsTest() throws Exception {
    ListPrebuiltProcessorsResponse expectedResponse =
        ListPrebuiltProcessorsResponse.newBuilder()
            .addAllProcessors(new ArrayList<Processor>())
            .build();
    mockAppPlatform.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListPrebuiltProcessorsResponse actualResponse = client.listPrebuiltProcessors(parent);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAppPlatform.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListPrebuiltProcessorsRequest actualRequest =
        ((ListPrebuiltProcessorsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listPrebuiltProcessorsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppPlatform.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listPrebuiltProcessors(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listPrebuiltProcessorsTest2() throws Exception {
    ListPrebuiltProcessorsResponse expectedResponse =
        ListPrebuiltProcessorsResponse.newBuilder()
            .addAllProcessors(new ArrayList<Processor>())
            .build();
    mockAppPlatform.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListPrebuiltProcessorsResponse actualResponse = client.listPrebuiltProcessors(parent);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAppPlatform.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListPrebuiltProcessorsRequest actualRequest =
        ((ListPrebuiltProcessorsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listPrebuiltProcessorsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppPlatform.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listPrebuiltProcessors(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getProcessorTest() throws Exception {
    Processor expectedResponse =
        Processor.newBuilder()
            .setName(ProcessorName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setModelType(ModelType.forNumber(0))
            .setCustomProcessorSourceInfo(CustomProcessorSourceInfo.newBuilder().build())
            .setProcessorIoSpec(ProcessorIOSpec.newBuilder().build())
            .setConfigurationTypeurl("configurationTypeurl679671327")
            .addAllSupportedAnnotationTypes(new ArrayList<StreamAnnotationType>())
            .setSupportsPostProcessing(true)
            .addAllSupportedInstanceTypes(new ArrayList<Instance.InstanceType>())
            .build();
    mockAppPlatform.addResponse(expectedResponse);

    ProcessorName name = ProcessorName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]");

    Processor actualResponse = client.getProcessor(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAppPlatform.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetProcessorRequest actualRequest = ((GetProcessorRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getProcessorExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppPlatform.addException(exception);

    try {
      ProcessorName name = ProcessorName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]");
      client.getProcessor(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getProcessorTest2() throws Exception {
    Processor expectedResponse =
        Processor.newBuilder()
            .setName(ProcessorName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setModelType(ModelType.forNumber(0))
            .setCustomProcessorSourceInfo(CustomProcessorSourceInfo.newBuilder().build())
            .setProcessorIoSpec(ProcessorIOSpec.newBuilder().build())
            .setConfigurationTypeurl("configurationTypeurl679671327")
            .addAllSupportedAnnotationTypes(new ArrayList<StreamAnnotationType>())
            .setSupportsPostProcessing(true)
            .addAllSupportedInstanceTypes(new ArrayList<Instance.InstanceType>())
            .build();
    mockAppPlatform.addResponse(expectedResponse);

    String name = "name3373707";

    Processor actualResponse = client.getProcessor(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAppPlatform.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetProcessorRequest actualRequest = ((GetProcessorRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getProcessorExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppPlatform.addException(exception);

    try {
      String name = "name3373707";
      client.getProcessor(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createProcessorTest() throws Exception {
    Processor expectedResponse =
        Processor.newBuilder()
            .setName(ProcessorName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setModelType(ModelType.forNumber(0))
            .setCustomProcessorSourceInfo(CustomProcessorSourceInfo.newBuilder().build())
            .setProcessorIoSpec(ProcessorIOSpec.newBuilder().build())
            .setConfigurationTypeurl("configurationTypeurl679671327")
            .addAllSupportedAnnotationTypes(new ArrayList<StreamAnnotationType>())
            .setSupportsPostProcessing(true)
            .addAllSupportedInstanceTypes(new ArrayList<Instance.InstanceType>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createProcessorTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAppPlatform.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Processor processor = Processor.newBuilder().build();
    String processorId = "processorId203323725";

    Processor actualResponse = client.createProcessorAsync(parent, processor, processorId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAppPlatform.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateProcessorRequest actualRequest = ((CreateProcessorRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(processor, actualRequest.getProcessor());
    Assert.assertEquals(processorId, actualRequest.getProcessorId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createProcessorExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppPlatform.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Processor processor = Processor.newBuilder().build();
      String processorId = "processorId203323725";
      client.createProcessorAsync(parent, processor, processorId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createProcessorTest2() throws Exception {
    Processor expectedResponse =
        Processor.newBuilder()
            .setName(ProcessorName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setModelType(ModelType.forNumber(0))
            .setCustomProcessorSourceInfo(CustomProcessorSourceInfo.newBuilder().build())
            .setProcessorIoSpec(ProcessorIOSpec.newBuilder().build())
            .setConfigurationTypeurl("configurationTypeurl679671327")
            .addAllSupportedAnnotationTypes(new ArrayList<StreamAnnotationType>())
            .setSupportsPostProcessing(true)
            .addAllSupportedInstanceTypes(new ArrayList<Instance.InstanceType>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createProcessorTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAppPlatform.addResponse(resultOperation);

    String parent = "parent-995424086";
    Processor processor = Processor.newBuilder().build();
    String processorId = "processorId203323725";

    Processor actualResponse = client.createProcessorAsync(parent, processor, processorId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAppPlatform.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateProcessorRequest actualRequest = ((CreateProcessorRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(processor, actualRequest.getProcessor());
    Assert.assertEquals(processorId, actualRequest.getProcessorId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createProcessorExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppPlatform.addException(exception);

    try {
      String parent = "parent-995424086";
      Processor processor = Processor.newBuilder().build();
      String processorId = "processorId203323725";
      client.createProcessorAsync(parent, processor, processorId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateProcessorTest() throws Exception {
    Processor expectedResponse =
        Processor.newBuilder()
            .setName(ProcessorName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setModelType(ModelType.forNumber(0))
            .setCustomProcessorSourceInfo(CustomProcessorSourceInfo.newBuilder().build())
            .setProcessorIoSpec(ProcessorIOSpec.newBuilder().build())
            .setConfigurationTypeurl("configurationTypeurl679671327")
            .addAllSupportedAnnotationTypes(new ArrayList<StreamAnnotationType>())
            .setSupportsPostProcessing(true)
            .addAllSupportedInstanceTypes(new ArrayList<Instance.InstanceType>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateProcessorTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAppPlatform.addResponse(resultOperation);

    Processor processor = Processor.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Processor actualResponse = client.updateProcessorAsync(processor, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAppPlatform.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateProcessorRequest actualRequest = ((UpdateProcessorRequest) actualRequests.get(0));

    Assert.assertEquals(processor, actualRequest.getProcessor());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateProcessorExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppPlatform.addException(exception);

    try {
      Processor processor = Processor.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateProcessorAsync(processor, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteProcessorTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteProcessorTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAppPlatform.addResponse(resultOperation);

    ProcessorName name = ProcessorName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]");

    client.deleteProcessorAsync(name).get();

    List<AbstractMessage> actualRequests = mockAppPlatform.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteProcessorRequest actualRequest = ((DeleteProcessorRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteProcessorExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppPlatform.addException(exception);

    try {
      ProcessorName name = ProcessorName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]");
      client.deleteProcessorAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteProcessorTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteProcessorTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAppPlatform.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteProcessorAsync(name).get();

    List<AbstractMessage> actualRequests = mockAppPlatform.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteProcessorRequest actualRequest = ((DeleteProcessorRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteProcessorExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAppPlatform.addException(exception);

    try {
      String name = "name3373707";
      client.deleteProcessorAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }
}
