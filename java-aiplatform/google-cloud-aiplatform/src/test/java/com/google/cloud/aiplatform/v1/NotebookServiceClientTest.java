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

package com.google.cloud.aiplatform.v1;

import static com.google.cloud.aiplatform.v1.NotebookServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.aiplatform.v1.NotebookServiceClient.ListNotebookRuntimeTemplatesPagedResponse;
import static com.google.cloud.aiplatform.v1.NotebookServiceClient.ListNotebookRuntimesPagedResponse;

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
import com.google.iam.v1.AuditConfig;
import com.google.iam.v1.Binding;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.GetPolicyOptions;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.protobuf.ByteString;
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
public class NotebookServiceClientTest {
  private static MockIAMPolicy mockIAMPolicy;
  private static MockLocations mockLocations;
  private static MockNotebookService mockNotebookService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private NotebookServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockNotebookService = new MockNotebookService();
    mockLocations = new MockLocations();
    mockIAMPolicy = new MockIAMPolicy();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockNotebookService, mockLocations, mockIAMPolicy));
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
    NotebookServiceSettings settings =
        NotebookServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = NotebookServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createNotebookRuntimeTemplateTest() throws Exception {
    NotebookRuntimeTemplate expectedResponse =
        NotebookRuntimeTemplate.newBuilder()
            .setName(
                NotebookRuntimeTemplateName.of(
                        "[PROJECT]", "[LOCATION]", "[NOTEBOOK_RUNTIME_TEMPLATE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setIsDefault(true)
            .setMachineSpec(MachineSpec.newBuilder().build())
            .setDataPersistentDiskSpec(PersistentDiskSpec.newBuilder().build())
            .setNetworkSpec(NetworkSpec.newBuilder().build())
            .setServiceAccount("serviceAccount1079137720")
            .setEtag("etag3123477")
            .putAllLabels(new HashMap<String, String>())
            .setIdleShutdownConfig(NotebookIdleShutdownConfig.newBuilder().build())
            .setEucConfig(NotebookEucConfig.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setNotebookRuntimeType(NotebookRuntimeType.forNumber(0))
            .setShieldedVmConfig(ShieldedVmConfig.newBuilder().build())
            .addAllNetworkTags(new ArrayList<String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createNotebookRuntimeTemplateTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNotebookService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    NotebookRuntimeTemplate notebookRuntimeTemplate = NotebookRuntimeTemplate.newBuilder().build();
    String notebookRuntimeTemplateId = "notebookRuntimeTemplateId-633369454";

    NotebookRuntimeTemplate actualResponse =
        client
            .createNotebookRuntimeTemplateAsync(
                parent, notebookRuntimeTemplate, notebookRuntimeTemplateId)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNotebookService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateNotebookRuntimeTemplateRequest actualRequest =
        ((CreateNotebookRuntimeTemplateRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(notebookRuntimeTemplate, actualRequest.getNotebookRuntimeTemplate());
    Assert.assertEquals(notebookRuntimeTemplateId, actualRequest.getNotebookRuntimeTemplateId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createNotebookRuntimeTemplateExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNotebookService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      NotebookRuntimeTemplate notebookRuntimeTemplate =
          NotebookRuntimeTemplate.newBuilder().build();
      String notebookRuntimeTemplateId = "notebookRuntimeTemplateId-633369454";
      client
          .createNotebookRuntimeTemplateAsync(
              parent, notebookRuntimeTemplate, notebookRuntimeTemplateId)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createNotebookRuntimeTemplateTest2() throws Exception {
    NotebookRuntimeTemplate expectedResponse =
        NotebookRuntimeTemplate.newBuilder()
            .setName(
                NotebookRuntimeTemplateName.of(
                        "[PROJECT]", "[LOCATION]", "[NOTEBOOK_RUNTIME_TEMPLATE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setIsDefault(true)
            .setMachineSpec(MachineSpec.newBuilder().build())
            .setDataPersistentDiskSpec(PersistentDiskSpec.newBuilder().build())
            .setNetworkSpec(NetworkSpec.newBuilder().build())
            .setServiceAccount("serviceAccount1079137720")
            .setEtag("etag3123477")
            .putAllLabels(new HashMap<String, String>())
            .setIdleShutdownConfig(NotebookIdleShutdownConfig.newBuilder().build())
            .setEucConfig(NotebookEucConfig.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setNotebookRuntimeType(NotebookRuntimeType.forNumber(0))
            .setShieldedVmConfig(ShieldedVmConfig.newBuilder().build())
            .addAllNetworkTags(new ArrayList<String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createNotebookRuntimeTemplateTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNotebookService.addResponse(resultOperation);

    String parent = "parent-995424086";
    NotebookRuntimeTemplate notebookRuntimeTemplate = NotebookRuntimeTemplate.newBuilder().build();
    String notebookRuntimeTemplateId = "notebookRuntimeTemplateId-633369454";

    NotebookRuntimeTemplate actualResponse =
        client
            .createNotebookRuntimeTemplateAsync(
                parent, notebookRuntimeTemplate, notebookRuntimeTemplateId)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNotebookService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateNotebookRuntimeTemplateRequest actualRequest =
        ((CreateNotebookRuntimeTemplateRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(notebookRuntimeTemplate, actualRequest.getNotebookRuntimeTemplate());
    Assert.assertEquals(notebookRuntimeTemplateId, actualRequest.getNotebookRuntimeTemplateId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createNotebookRuntimeTemplateExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNotebookService.addException(exception);

    try {
      String parent = "parent-995424086";
      NotebookRuntimeTemplate notebookRuntimeTemplate =
          NotebookRuntimeTemplate.newBuilder().build();
      String notebookRuntimeTemplateId = "notebookRuntimeTemplateId-633369454";
      client
          .createNotebookRuntimeTemplateAsync(
              parent, notebookRuntimeTemplate, notebookRuntimeTemplateId)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void getNotebookRuntimeTemplateTest() throws Exception {
    NotebookRuntimeTemplate expectedResponse =
        NotebookRuntimeTemplate.newBuilder()
            .setName(
                NotebookRuntimeTemplateName.of(
                        "[PROJECT]", "[LOCATION]", "[NOTEBOOK_RUNTIME_TEMPLATE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setIsDefault(true)
            .setMachineSpec(MachineSpec.newBuilder().build())
            .setDataPersistentDiskSpec(PersistentDiskSpec.newBuilder().build())
            .setNetworkSpec(NetworkSpec.newBuilder().build())
            .setServiceAccount("serviceAccount1079137720")
            .setEtag("etag3123477")
            .putAllLabels(new HashMap<String, String>())
            .setIdleShutdownConfig(NotebookIdleShutdownConfig.newBuilder().build())
            .setEucConfig(NotebookEucConfig.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setNotebookRuntimeType(NotebookRuntimeType.forNumber(0))
            .setShieldedVmConfig(ShieldedVmConfig.newBuilder().build())
            .addAllNetworkTags(new ArrayList<String>())
            .build();
    mockNotebookService.addResponse(expectedResponse);

    NotebookRuntimeTemplateName name =
        NotebookRuntimeTemplateName.of("[PROJECT]", "[LOCATION]", "[NOTEBOOK_RUNTIME_TEMPLATE]");

    NotebookRuntimeTemplate actualResponse = client.getNotebookRuntimeTemplate(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNotebookService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetNotebookRuntimeTemplateRequest actualRequest =
        ((GetNotebookRuntimeTemplateRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getNotebookRuntimeTemplateExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNotebookService.addException(exception);

    try {
      NotebookRuntimeTemplateName name =
          NotebookRuntimeTemplateName.of("[PROJECT]", "[LOCATION]", "[NOTEBOOK_RUNTIME_TEMPLATE]");
      client.getNotebookRuntimeTemplate(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getNotebookRuntimeTemplateTest2() throws Exception {
    NotebookRuntimeTemplate expectedResponse =
        NotebookRuntimeTemplate.newBuilder()
            .setName(
                NotebookRuntimeTemplateName.of(
                        "[PROJECT]", "[LOCATION]", "[NOTEBOOK_RUNTIME_TEMPLATE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setIsDefault(true)
            .setMachineSpec(MachineSpec.newBuilder().build())
            .setDataPersistentDiskSpec(PersistentDiskSpec.newBuilder().build())
            .setNetworkSpec(NetworkSpec.newBuilder().build())
            .setServiceAccount("serviceAccount1079137720")
            .setEtag("etag3123477")
            .putAllLabels(new HashMap<String, String>())
            .setIdleShutdownConfig(NotebookIdleShutdownConfig.newBuilder().build())
            .setEucConfig(NotebookEucConfig.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setNotebookRuntimeType(NotebookRuntimeType.forNumber(0))
            .setShieldedVmConfig(ShieldedVmConfig.newBuilder().build())
            .addAllNetworkTags(new ArrayList<String>())
            .build();
    mockNotebookService.addResponse(expectedResponse);

    String name = "name3373707";

    NotebookRuntimeTemplate actualResponse = client.getNotebookRuntimeTemplate(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNotebookService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetNotebookRuntimeTemplateRequest actualRequest =
        ((GetNotebookRuntimeTemplateRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getNotebookRuntimeTemplateExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNotebookService.addException(exception);

    try {
      String name = "name3373707";
      client.getNotebookRuntimeTemplate(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listNotebookRuntimeTemplatesTest() throws Exception {
    NotebookRuntimeTemplate responsesElement = NotebookRuntimeTemplate.newBuilder().build();
    ListNotebookRuntimeTemplatesResponse expectedResponse =
        ListNotebookRuntimeTemplatesResponse.newBuilder()
            .setNextPageToken("")
            .addAllNotebookRuntimeTemplates(Arrays.asList(responsesElement))
            .build();
    mockNotebookService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListNotebookRuntimeTemplatesPagedResponse pagedListResponse =
        client.listNotebookRuntimeTemplates(parent);

    List<NotebookRuntimeTemplate> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getNotebookRuntimeTemplatesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockNotebookService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListNotebookRuntimeTemplatesRequest actualRequest =
        ((ListNotebookRuntimeTemplatesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listNotebookRuntimeTemplatesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNotebookService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listNotebookRuntimeTemplates(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listNotebookRuntimeTemplatesTest2() throws Exception {
    NotebookRuntimeTemplate responsesElement = NotebookRuntimeTemplate.newBuilder().build();
    ListNotebookRuntimeTemplatesResponse expectedResponse =
        ListNotebookRuntimeTemplatesResponse.newBuilder()
            .setNextPageToken("")
            .addAllNotebookRuntimeTemplates(Arrays.asList(responsesElement))
            .build();
    mockNotebookService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListNotebookRuntimeTemplatesPagedResponse pagedListResponse =
        client.listNotebookRuntimeTemplates(parent);

    List<NotebookRuntimeTemplate> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getNotebookRuntimeTemplatesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockNotebookService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListNotebookRuntimeTemplatesRequest actualRequest =
        ((ListNotebookRuntimeTemplatesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listNotebookRuntimeTemplatesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNotebookService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listNotebookRuntimeTemplates(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteNotebookRuntimeTemplateTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteNotebookRuntimeTemplateTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNotebookService.addResponse(resultOperation);

    NotebookRuntimeTemplateName name =
        NotebookRuntimeTemplateName.of("[PROJECT]", "[LOCATION]", "[NOTEBOOK_RUNTIME_TEMPLATE]");

    client.deleteNotebookRuntimeTemplateAsync(name).get();

    List<AbstractMessage> actualRequests = mockNotebookService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteNotebookRuntimeTemplateRequest actualRequest =
        ((DeleteNotebookRuntimeTemplateRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteNotebookRuntimeTemplateExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNotebookService.addException(exception);

    try {
      NotebookRuntimeTemplateName name =
          NotebookRuntimeTemplateName.of("[PROJECT]", "[LOCATION]", "[NOTEBOOK_RUNTIME_TEMPLATE]");
      client.deleteNotebookRuntimeTemplateAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteNotebookRuntimeTemplateTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteNotebookRuntimeTemplateTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNotebookService.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteNotebookRuntimeTemplateAsync(name).get();

    List<AbstractMessage> actualRequests = mockNotebookService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteNotebookRuntimeTemplateRequest actualRequest =
        ((DeleteNotebookRuntimeTemplateRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteNotebookRuntimeTemplateExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNotebookService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteNotebookRuntimeTemplateAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void assignNotebookRuntimeTest() throws Exception {
    NotebookRuntime expectedResponse =
        NotebookRuntime.newBuilder()
            .setName(
                NotebookRuntimeName.of("[PROJECT]", "[LOCATION]", "[NOTEBOOK_RUNTIME]").toString())
            .setRuntimeUser("runtimeUser754877379")
            .setNotebookRuntimeTemplateRef(NotebookRuntimeTemplateRef.newBuilder().build())
            .setProxyUri("proxyUri-985185250")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setServiceAccount("serviceAccount1079137720")
            .setIsUpgradable(true)
            .putAllLabels(new HashMap<String, String>())
            .setExpirationTime(Timestamp.newBuilder().build())
            .setVersion("version351608024")
            .setNotebookRuntimeType(NotebookRuntimeType.forNumber(0))
            .addAllNetworkTags(new ArrayList<String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("assignNotebookRuntimeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNotebookService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    NotebookRuntimeTemplateName notebookRuntimeTemplate =
        NotebookRuntimeTemplateName.of("[PROJECT]", "[LOCATION]", "[NOTEBOOK_RUNTIME_TEMPLATE]");
    NotebookRuntime notebookRuntime = NotebookRuntime.newBuilder().build();
    String notebookRuntimeId = "notebookRuntimeId400795512";

    NotebookRuntime actualResponse =
        client
            .assignNotebookRuntimeAsync(
                parent, notebookRuntimeTemplate, notebookRuntime, notebookRuntimeId)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNotebookService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    AssignNotebookRuntimeRequest actualRequest =
        ((AssignNotebookRuntimeRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(
        notebookRuntimeTemplate.toString(), actualRequest.getNotebookRuntimeTemplate());
    Assert.assertEquals(notebookRuntime, actualRequest.getNotebookRuntime());
    Assert.assertEquals(notebookRuntimeId, actualRequest.getNotebookRuntimeId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void assignNotebookRuntimeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNotebookService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      NotebookRuntimeTemplateName notebookRuntimeTemplate =
          NotebookRuntimeTemplateName.of("[PROJECT]", "[LOCATION]", "[NOTEBOOK_RUNTIME_TEMPLATE]");
      NotebookRuntime notebookRuntime = NotebookRuntime.newBuilder().build();
      String notebookRuntimeId = "notebookRuntimeId400795512";
      client
          .assignNotebookRuntimeAsync(
              parent, notebookRuntimeTemplate, notebookRuntime, notebookRuntimeId)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void assignNotebookRuntimeTest2() throws Exception {
    NotebookRuntime expectedResponse =
        NotebookRuntime.newBuilder()
            .setName(
                NotebookRuntimeName.of("[PROJECT]", "[LOCATION]", "[NOTEBOOK_RUNTIME]").toString())
            .setRuntimeUser("runtimeUser754877379")
            .setNotebookRuntimeTemplateRef(NotebookRuntimeTemplateRef.newBuilder().build())
            .setProxyUri("proxyUri-985185250")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setServiceAccount("serviceAccount1079137720")
            .setIsUpgradable(true)
            .putAllLabels(new HashMap<String, String>())
            .setExpirationTime(Timestamp.newBuilder().build())
            .setVersion("version351608024")
            .setNotebookRuntimeType(NotebookRuntimeType.forNumber(0))
            .addAllNetworkTags(new ArrayList<String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("assignNotebookRuntimeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNotebookService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    String notebookRuntimeTemplate = "notebookRuntimeTemplate-903451369";
    NotebookRuntime notebookRuntime = NotebookRuntime.newBuilder().build();
    String notebookRuntimeId = "notebookRuntimeId400795512";

    NotebookRuntime actualResponse =
        client
            .assignNotebookRuntimeAsync(
                parent, notebookRuntimeTemplate, notebookRuntime, notebookRuntimeId)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNotebookService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    AssignNotebookRuntimeRequest actualRequest =
        ((AssignNotebookRuntimeRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(notebookRuntimeTemplate, actualRequest.getNotebookRuntimeTemplate());
    Assert.assertEquals(notebookRuntime, actualRequest.getNotebookRuntime());
    Assert.assertEquals(notebookRuntimeId, actualRequest.getNotebookRuntimeId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void assignNotebookRuntimeExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNotebookService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      String notebookRuntimeTemplate = "notebookRuntimeTemplate-903451369";
      NotebookRuntime notebookRuntime = NotebookRuntime.newBuilder().build();
      String notebookRuntimeId = "notebookRuntimeId400795512";
      client
          .assignNotebookRuntimeAsync(
              parent, notebookRuntimeTemplate, notebookRuntime, notebookRuntimeId)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void assignNotebookRuntimeTest3() throws Exception {
    NotebookRuntime expectedResponse =
        NotebookRuntime.newBuilder()
            .setName(
                NotebookRuntimeName.of("[PROJECT]", "[LOCATION]", "[NOTEBOOK_RUNTIME]").toString())
            .setRuntimeUser("runtimeUser754877379")
            .setNotebookRuntimeTemplateRef(NotebookRuntimeTemplateRef.newBuilder().build())
            .setProxyUri("proxyUri-985185250")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setServiceAccount("serviceAccount1079137720")
            .setIsUpgradable(true)
            .putAllLabels(new HashMap<String, String>())
            .setExpirationTime(Timestamp.newBuilder().build())
            .setVersion("version351608024")
            .setNotebookRuntimeType(NotebookRuntimeType.forNumber(0))
            .addAllNetworkTags(new ArrayList<String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("assignNotebookRuntimeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNotebookService.addResponse(resultOperation);

    String parent = "parent-995424086";
    NotebookRuntimeTemplateName notebookRuntimeTemplate =
        NotebookRuntimeTemplateName.of("[PROJECT]", "[LOCATION]", "[NOTEBOOK_RUNTIME_TEMPLATE]");
    NotebookRuntime notebookRuntime = NotebookRuntime.newBuilder().build();
    String notebookRuntimeId = "notebookRuntimeId400795512";

    NotebookRuntime actualResponse =
        client
            .assignNotebookRuntimeAsync(
                parent, notebookRuntimeTemplate, notebookRuntime, notebookRuntimeId)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNotebookService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    AssignNotebookRuntimeRequest actualRequest =
        ((AssignNotebookRuntimeRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(
        notebookRuntimeTemplate.toString(), actualRequest.getNotebookRuntimeTemplate());
    Assert.assertEquals(notebookRuntime, actualRequest.getNotebookRuntime());
    Assert.assertEquals(notebookRuntimeId, actualRequest.getNotebookRuntimeId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void assignNotebookRuntimeExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNotebookService.addException(exception);

    try {
      String parent = "parent-995424086";
      NotebookRuntimeTemplateName notebookRuntimeTemplate =
          NotebookRuntimeTemplateName.of("[PROJECT]", "[LOCATION]", "[NOTEBOOK_RUNTIME_TEMPLATE]");
      NotebookRuntime notebookRuntime = NotebookRuntime.newBuilder().build();
      String notebookRuntimeId = "notebookRuntimeId400795512";
      client
          .assignNotebookRuntimeAsync(
              parent, notebookRuntimeTemplate, notebookRuntime, notebookRuntimeId)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void assignNotebookRuntimeTest4() throws Exception {
    NotebookRuntime expectedResponse =
        NotebookRuntime.newBuilder()
            .setName(
                NotebookRuntimeName.of("[PROJECT]", "[LOCATION]", "[NOTEBOOK_RUNTIME]").toString())
            .setRuntimeUser("runtimeUser754877379")
            .setNotebookRuntimeTemplateRef(NotebookRuntimeTemplateRef.newBuilder().build())
            .setProxyUri("proxyUri-985185250")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setServiceAccount("serviceAccount1079137720")
            .setIsUpgradable(true)
            .putAllLabels(new HashMap<String, String>())
            .setExpirationTime(Timestamp.newBuilder().build())
            .setVersion("version351608024")
            .setNotebookRuntimeType(NotebookRuntimeType.forNumber(0))
            .addAllNetworkTags(new ArrayList<String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("assignNotebookRuntimeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNotebookService.addResponse(resultOperation);

    String parent = "parent-995424086";
    String notebookRuntimeTemplate = "notebookRuntimeTemplate-903451369";
    NotebookRuntime notebookRuntime = NotebookRuntime.newBuilder().build();
    String notebookRuntimeId = "notebookRuntimeId400795512";

    NotebookRuntime actualResponse =
        client
            .assignNotebookRuntimeAsync(
                parent, notebookRuntimeTemplate, notebookRuntime, notebookRuntimeId)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNotebookService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    AssignNotebookRuntimeRequest actualRequest =
        ((AssignNotebookRuntimeRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(notebookRuntimeTemplate, actualRequest.getNotebookRuntimeTemplate());
    Assert.assertEquals(notebookRuntime, actualRequest.getNotebookRuntime());
    Assert.assertEquals(notebookRuntimeId, actualRequest.getNotebookRuntimeId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void assignNotebookRuntimeExceptionTest4() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNotebookService.addException(exception);

    try {
      String parent = "parent-995424086";
      String notebookRuntimeTemplate = "notebookRuntimeTemplate-903451369";
      NotebookRuntime notebookRuntime = NotebookRuntime.newBuilder().build();
      String notebookRuntimeId = "notebookRuntimeId400795512";
      client
          .assignNotebookRuntimeAsync(
              parent, notebookRuntimeTemplate, notebookRuntime, notebookRuntimeId)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void getNotebookRuntimeTest() throws Exception {
    NotebookRuntime expectedResponse =
        NotebookRuntime.newBuilder()
            .setName(
                NotebookRuntimeName.of("[PROJECT]", "[LOCATION]", "[NOTEBOOK_RUNTIME]").toString())
            .setRuntimeUser("runtimeUser754877379")
            .setNotebookRuntimeTemplateRef(NotebookRuntimeTemplateRef.newBuilder().build())
            .setProxyUri("proxyUri-985185250")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setServiceAccount("serviceAccount1079137720")
            .setIsUpgradable(true)
            .putAllLabels(new HashMap<String, String>())
            .setExpirationTime(Timestamp.newBuilder().build())
            .setVersion("version351608024")
            .setNotebookRuntimeType(NotebookRuntimeType.forNumber(0))
            .addAllNetworkTags(new ArrayList<String>())
            .build();
    mockNotebookService.addResponse(expectedResponse);

    NotebookRuntimeName name =
        NotebookRuntimeName.of("[PROJECT]", "[LOCATION]", "[NOTEBOOK_RUNTIME]");

    NotebookRuntime actualResponse = client.getNotebookRuntime(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNotebookService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetNotebookRuntimeRequest actualRequest = ((GetNotebookRuntimeRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getNotebookRuntimeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNotebookService.addException(exception);

    try {
      NotebookRuntimeName name =
          NotebookRuntimeName.of("[PROJECT]", "[LOCATION]", "[NOTEBOOK_RUNTIME]");
      client.getNotebookRuntime(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getNotebookRuntimeTest2() throws Exception {
    NotebookRuntime expectedResponse =
        NotebookRuntime.newBuilder()
            .setName(
                NotebookRuntimeName.of("[PROJECT]", "[LOCATION]", "[NOTEBOOK_RUNTIME]").toString())
            .setRuntimeUser("runtimeUser754877379")
            .setNotebookRuntimeTemplateRef(NotebookRuntimeTemplateRef.newBuilder().build())
            .setProxyUri("proxyUri-985185250")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setServiceAccount("serviceAccount1079137720")
            .setIsUpgradable(true)
            .putAllLabels(new HashMap<String, String>())
            .setExpirationTime(Timestamp.newBuilder().build())
            .setVersion("version351608024")
            .setNotebookRuntimeType(NotebookRuntimeType.forNumber(0))
            .addAllNetworkTags(new ArrayList<String>())
            .build();
    mockNotebookService.addResponse(expectedResponse);

    String name = "name3373707";

    NotebookRuntime actualResponse = client.getNotebookRuntime(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNotebookService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetNotebookRuntimeRequest actualRequest = ((GetNotebookRuntimeRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getNotebookRuntimeExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNotebookService.addException(exception);

    try {
      String name = "name3373707";
      client.getNotebookRuntime(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listNotebookRuntimesTest() throws Exception {
    NotebookRuntime responsesElement = NotebookRuntime.newBuilder().build();
    ListNotebookRuntimesResponse expectedResponse =
        ListNotebookRuntimesResponse.newBuilder()
            .setNextPageToken("")
            .addAllNotebookRuntimes(Arrays.asList(responsesElement))
            .build();
    mockNotebookService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListNotebookRuntimesPagedResponse pagedListResponse = client.listNotebookRuntimes(parent);

    List<NotebookRuntime> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getNotebookRuntimesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockNotebookService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListNotebookRuntimesRequest actualRequest =
        ((ListNotebookRuntimesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listNotebookRuntimesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNotebookService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listNotebookRuntimes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listNotebookRuntimesTest2() throws Exception {
    NotebookRuntime responsesElement = NotebookRuntime.newBuilder().build();
    ListNotebookRuntimesResponse expectedResponse =
        ListNotebookRuntimesResponse.newBuilder()
            .setNextPageToken("")
            .addAllNotebookRuntimes(Arrays.asList(responsesElement))
            .build();
    mockNotebookService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListNotebookRuntimesPagedResponse pagedListResponse = client.listNotebookRuntimes(parent);

    List<NotebookRuntime> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getNotebookRuntimesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockNotebookService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListNotebookRuntimesRequest actualRequest =
        ((ListNotebookRuntimesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listNotebookRuntimesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNotebookService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listNotebookRuntimes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteNotebookRuntimeTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteNotebookRuntimeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNotebookService.addResponse(resultOperation);

    NotebookRuntimeName name =
        NotebookRuntimeName.of("[PROJECT]", "[LOCATION]", "[NOTEBOOK_RUNTIME]");

    client.deleteNotebookRuntimeAsync(name).get();

    List<AbstractMessage> actualRequests = mockNotebookService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteNotebookRuntimeRequest actualRequest =
        ((DeleteNotebookRuntimeRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteNotebookRuntimeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNotebookService.addException(exception);

    try {
      NotebookRuntimeName name =
          NotebookRuntimeName.of("[PROJECT]", "[LOCATION]", "[NOTEBOOK_RUNTIME]");
      client.deleteNotebookRuntimeAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteNotebookRuntimeTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteNotebookRuntimeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNotebookService.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteNotebookRuntimeAsync(name).get();

    List<AbstractMessage> actualRequests = mockNotebookService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteNotebookRuntimeRequest actualRequest =
        ((DeleteNotebookRuntimeRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteNotebookRuntimeExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNotebookService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteNotebookRuntimeAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void upgradeNotebookRuntimeTest() throws Exception {
    UpgradeNotebookRuntimeResponse expectedResponse =
        UpgradeNotebookRuntimeResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("upgradeNotebookRuntimeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNotebookService.addResponse(resultOperation);

    NotebookRuntimeName name =
        NotebookRuntimeName.of("[PROJECT]", "[LOCATION]", "[NOTEBOOK_RUNTIME]");

    UpgradeNotebookRuntimeResponse actualResponse = client.upgradeNotebookRuntimeAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNotebookService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpgradeNotebookRuntimeRequest actualRequest =
        ((UpgradeNotebookRuntimeRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void upgradeNotebookRuntimeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNotebookService.addException(exception);

    try {
      NotebookRuntimeName name =
          NotebookRuntimeName.of("[PROJECT]", "[LOCATION]", "[NOTEBOOK_RUNTIME]");
      client.upgradeNotebookRuntimeAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void upgradeNotebookRuntimeTest2() throws Exception {
    UpgradeNotebookRuntimeResponse expectedResponse =
        UpgradeNotebookRuntimeResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("upgradeNotebookRuntimeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNotebookService.addResponse(resultOperation);

    String name = "name3373707";

    UpgradeNotebookRuntimeResponse actualResponse = client.upgradeNotebookRuntimeAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNotebookService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpgradeNotebookRuntimeRequest actualRequest =
        ((UpgradeNotebookRuntimeRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void upgradeNotebookRuntimeExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNotebookService.addException(exception);

    try {
      String name = "name3373707";
      client.upgradeNotebookRuntimeAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void startNotebookRuntimeTest() throws Exception {
    StartNotebookRuntimeResponse expectedResponse =
        StartNotebookRuntimeResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("startNotebookRuntimeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNotebookService.addResponse(resultOperation);

    NotebookRuntimeName name =
        NotebookRuntimeName.of("[PROJECT]", "[LOCATION]", "[NOTEBOOK_RUNTIME]");

    StartNotebookRuntimeResponse actualResponse = client.startNotebookRuntimeAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNotebookService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    StartNotebookRuntimeRequest actualRequest =
        ((StartNotebookRuntimeRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void startNotebookRuntimeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNotebookService.addException(exception);

    try {
      NotebookRuntimeName name =
          NotebookRuntimeName.of("[PROJECT]", "[LOCATION]", "[NOTEBOOK_RUNTIME]");
      client.startNotebookRuntimeAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void startNotebookRuntimeTest2() throws Exception {
    StartNotebookRuntimeResponse expectedResponse =
        StartNotebookRuntimeResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("startNotebookRuntimeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockNotebookService.addResponse(resultOperation);

    String name = "name3373707";

    StartNotebookRuntimeResponse actualResponse = client.startNotebookRuntimeAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockNotebookService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    StartNotebookRuntimeRequest actualRequest =
        ((StartNotebookRuntimeRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void startNotebookRuntimeExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockNotebookService.addException(exception);

    try {
      String name = "name3373707";
      client.startNotebookRuntimeAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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

  @Test
  public void setIamPolicyTest() throws Exception {
    Policy expectedResponse =
        Policy.newBuilder()
            .setVersion(351608024)
            .addAllBindings(new ArrayList<Binding>())
            .addAllAuditConfigs(new ArrayList<AuditConfig>())
            .setEtag(ByteString.EMPTY)
            .build();
    mockIAMPolicy.addResponse(expectedResponse);

    SetIamPolicyRequest request =
        SetIamPolicyRequest.newBuilder()
            .setResource(
                EndpointName.ofProjectLocationEndpointName("[PROJECT]", "[LOCATION]", "[ENDPOINT]")
                    .toString())
            .setPolicy(Policy.newBuilder().build())
            .setUpdateMask(FieldMask.newBuilder().build())
            .build();

    Policy actualResponse = client.setIamPolicy(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIAMPolicy.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SetIamPolicyRequest actualRequest = ((SetIamPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(request.getResource(), actualRequest.getResource());
    Assert.assertEquals(request.getPolicy(), actualRequest.getPolicy());
    Assert.assertEquals(request.getUpdateMask(), actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void setIamPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIAMPolicy.addException(exception);

    try {
      SetIamPolicyRequest request =
          SetIamPolicyRequest.newBuilder()
              .setResource(
                  EndpointName.ofProjectLocationEndpointName(
                          "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
                      .toString())
              .setPolicy(Policy.newBuilder().build())
              .setUpdateMask(FieldMask.newBuilder().build())
              .build();
      client.setIamPolicy(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getIamPolicyTest() throws Exception {
    Policy expectedResponse =
        Policy.newBuilder()
            .setVersion(351608024)
            .addAllBindings(new ArrayList<Binding>())
            .addAllAuditConfigs(new ArrayList<AuditConfig>())
            .setEtag(ByteString.EMPTY)
            .build();
    mockIAMPolicy.addResponse(expectedResponse);

    GetIamPolicyRequest request =
        GetIamPolicyRequest.newBuilder()
            .setResource(
                EndpointName.ofProjectLocationEndpointName("[PROJECT]", "[LOCATION]", "[ENDPOINT]")
                    .toString())
            .setOptions(GetPolicyOptions.newBuilder().build())
            .build();

    Policy actualResponse = client.getIamPolicy(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIAMPolicy.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetIamPolicyRequest actualRequest = ((GetIamPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(request.getResource(), actualRequest.getResource());
    Assert.assertEquals(request.getOptions(), actualRequest.getOptions());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getIamPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIAMPolicy.addException(exception);

    try {
      GetIamPolicyRequest request =
          GetIamPolicyRequest.newBuilder()
              .setResource(
                  EndpointName.ofProjectLocationEndpointName(
                          "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
                      .toString())
              .setOptions(GetPolicyOptions.newBuilder().build())
              .build();
      client.getIamPolicy(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void testIamPermissionsTest() throws Exception {
    TestIamPermissionsResponse expectedResponse =
        TestIamPermissionsResponse.newBuilder().addAllPermissions(new ArrayList<String>()).build();
    mockIAMPolicy.addResponse(expectedResponse);

    TestIamPermissionsRequest request =
        TestIamPermissionsRequest.newBuilder()
            .setResource(
                EndpointName.ofProjectLocationEndpointName("[PROJECT]", "[LOCATION]", "[ENDPOINT]")
                    .toString())
            .addAllPermissions(new ArrayList<String>())
            .build();

    TestIamPermissionsResponse actualResponse = client.testIamPermissions(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIAMPolicy.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    TestIamPermissionsRequest actualRequest = ((TestIamPermissionsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getResource(), actualRequest.getResource());
    Assert.assertEquals(request.getPermissionsList(), actualRequest.getPermissionsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void testIamPermissionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIAMPolicy.addException(exception);

    try {
      TestIamPermissionsRequest request =
          TestIamPermissionsRequest.newBuilder()
              .setResource(
                  EndpointName.ofProjectLocationEndpointName(
                          "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
                      .toString())
              .addAllPermissions(new ArrayList<String>())
              .build();
      client.testIamPermissions(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
