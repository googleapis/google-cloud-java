/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.geminidataanalytics.v1beta;

import static com.google.cloud.geminidataanalytics.v1beta.DataAgentServiceClient.ListAccessibleDataAgentsPagedResponse;
import static com.google.cloud.geminidataanalytics.v1beta.DataAgentServiceClient.ListDataAgentsPagedResponse;
import static com.google.cloud.geminidataanalytics.v1beta.DataAgentServiceClient.ListLocationsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.resourcenames.ResourceName;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.Lists;
import com.google.iam.v1.AuditConfig;
import com.google.iam.v1.Binding;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
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
public class DataAgentServiceClientTest {
  private static MockDataAgentService mockDataAgentService;
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private DataAgentServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockDataAgentService = new MockDataAgentService();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockDataAgentService, mockLocations));
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
    DataAgentServiceSettings settings =
        DataAgentServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = DataAgentServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listDataAgentsTest() throws Exception {
    DataAgent responsesElement = DataAgent.newBuilder().build();
    ListDataAgentsResponse expectedResponse =
        ListDataAgentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllDataAgents(Arrays.asList(responsesElement))
            .build();
    mockDataAgentService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListDataAgentsPagedResponse pagedListResponse = client.listDataAgents(parent);

    List<DataAgent> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDataAgentsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataAgentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDataAgentsRequest actualRequest = ((ListDataAgentsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDataAgentsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataAgentService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listDataAgents(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDataAgentsTest2() throws Exception {
    DataAgent responsesElement = DataAgent.newBuilder().build();
    ListDataAgentsResponse expectedResponse =
        ListDataAgentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllDataAgents(Arrays.asList(responsesElement))
            .build();
    mockDataAgentService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListDataAgentsPagedResponse pagedListResponse = client.listDataAgents(parent);

    List<DataAgent> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDataAgentsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataAgentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDataAgentsRequest actualRequest = ((ListDataAgentsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDataAgentsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataAgentService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listDataAgents(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAccessibleDataAgentsTest() throws Exception {
    DataAgent responsesElement = DataAgent.newBuilder().build();
    ListAccessibleDataAgentsResponse expectedResponse =
        ListAccessibleDataAgentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllDataAgents(Arrays.asList(responsesElement))
            .build();
    mockDataAgentService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListAccessibleDataAgentsPagedResponse pagedListResponse =
        client.listAccessibleDataAgents(parent);

    List<DataAgent> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDataAgentsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataAgentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAccessibleDataAgentsRequest actualRequest =
        ((ListAccessibleDataAgentsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAccessibleDataAgentsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataAgentService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listAccessibleDataAgents(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAccessibleDataAgentsTest2() throws Exception {
    DataAgent responsesElement = DataAgent.newBuilder().build();
    ListAccessibleDataAgentsResponse expectedResponse =
        ListAccessibleDataAgentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllDataAgents(Arrays.asList(responsesElement))
            .build();
    mockDataAgentService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListAccessibleDataAgentsPagedResponse pagedListResponse =
        client.listAccessibleDataAgents(parent);

    List<DataAgent> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDataAgentsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataAgentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAccessibleDataAgentsRequest actualRequest =
        ((ListAccessibleDataAgentsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAccessibleDataAgentsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataAgentService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listAccessibleDataAgents(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDataAgentTest() throws Exception {
    DataAgent expectedResponse =
        DataAgent.newBuilder()
            .setName(DataAgentName.of("[PROJECT]", "[LOCATION]", "[DATA_AGENT]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setPurgeTime(Timestamp.newBuilder().build())
            .build();
    mockDataAgentService.addResponse(expectedResponse);

    DataAgentName name = DataAgentName.of("[PROJECT]", "[LOCATION]", "[DATA_AGENT]");

    DataAgent actualResponse = client.getDataAgent(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataAgentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDataAgentRequest actualRequest = ((GetDataAgentRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDataAgentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataAgentService.addException(exception);

    try {
      DataAgentName name = DataAgentName.of("[PROJECT]", "[LOCATION]", "[DATA_AGENT]");
      client.getDataAgent(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDataAgentTest2() throws Exception {
    DataAgent expectedResponse =
        DataAgent.newBuilder()
            .setName(DataAgentName.of("[PROJECT]", "[LOCATION]", "[DATA_AGENT]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setPurgeTime(Timestamp.newBuilder().build())
            .build();
    mockDataAgentService.addResponse(expectedResponse);

    String name = "name3373707";

    DataAgent actualResponse = client.getDataAgent(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataAgentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDataAgentRequest actualRequest = ((GetDataAgentRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDataAgentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataAgentService.addException(exception);

    try {
      String name = "name3373707";
      client.getDataAgent(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createDataAgentTest() throws Exception {
    DataAgent expectedResponse =
        DataAgent.newBuilder()
            .setName(DataAgentName.of("[PROJECT]", "[LOCATION]", "[DATA_AGENT]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setPurgeTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createDataAgentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataAgentService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    DataAgent dataAgent = DataAgent.newBuilder().build();
    String dataAgentId = "dataAgentId1752773622";

    DataAgent actualResponse = client.createDataAgentAsync(parent, dataAgent, dataAgentId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataAgentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateDataAgentRequest actualRequest = ((CreateDataAgentRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(dataAgent, actualRequest.getDataAgent());
    Assert.assertEquals(dataAgentId, actualRequest.getDataAgentId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createDataAgentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataAgentService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      DataAgent dataAgent = DataAgent.newBuilder().build();
      String dataAgentId = "dataAgentId1752773622";
      client.createDataAgentAsync(parent, dataAgent, dataAgentId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createDataAgentTest2() throws Exception {
    DataAgent expectedResponse =
        DataAgent.newBuilder()
            .setName(DataAgentName.of("[PROJECT]", "[LOCATION]", "[DATA_AGENT]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setPurgeTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createDataAgentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataAgentService.addResponse(resultOperation);

    String parent = "parent-995424086";
    DataAgent dataAgent = DataAgent.newBuilder().build();
    String dataAgentId = "dataAgentId1752773622";

    DataAgent actualResponse = client.createDataAgentAsync(parent, dataAgent, dataAgentId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataAgentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateDataAgentRequest actualRequest = ((CreateDataAgentRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(dataAgent, actualRequest.getDataAgent());
    Assert.assertEquals(dataAgentId, actualRequest.getDataAgentId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createDataAgentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataAgentService.addException(exception);

    try {
      String parent = "parent-995424086";
      DataAgent dataAgent = DataAgent.newBuilder().build();
      String dataAgentId = "dataAgentId1752773622";
      client.createDataAgentAsync(parent, dataAgent, dataAgentId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateDataAgentTest() throws Exception {
    DataAgent expectedResponse =
        DataAgent.newBuilder()
            .setName(DataAgentName.of("[PROJECT]", "[LOCATION]", "[DATA_AGENT]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setPurgeTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateDataAgentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataAgentService.addResponse(resultOperation);

    DataAgent dataAgent = DataAgent.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    DataAgent actualResponse = client.updateDataAgentAsync(dataAgent, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataAgentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateDataAgentRequest actualRequest = ((UpdateDataAgentRequest) actualRequests.get(0));

    Assert.assertEquals(dataAgent, actualRequest.getDataAgent());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateDataAgentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataAgentService.addException(exception);

    try {
      DataAgent dataAgent = DataAgent.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateDataAgentAsync(dataAgent, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteDataAgentTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteDataAgentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataAgentService.addResponse(resultOperation);

    DataAgentName name = DataAgentName.of("[PROJECT]", "[LOCATION]", "[DATA_AGENT]");

    client.deleteDataAgentAsync(name).get();

    List<AbstractMessage> actualRequests = mockDataAgentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteDataAgentRequest actualRequest = ((DeleteDataAgentRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteDataAgentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataAgentService.addException(exception);

    try {
      DataAgentName name = DataAgentName.of("[PROJECT]", "[LOCATION]", "[DATA_AGENT]");
      client.deleteDataAgentAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteDataAgentTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteDataAgentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataAgentService.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteDataAgentAsync(name).get();

    List<AbstractMessage> actualRequests = mockDataAgentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteDataAgentRequest actualRequest = ((DeleteDataAgentRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteDataAgentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataAgentService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteDataAgentAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockDataAgentService.addResponse(expectedResponse);

    ResourceName resource = DataAgentName.of("[PROJECT]", "[LOCATION]", "[DATA_AGENT]");

    Policy actualResponse = client.getIamPolicy(resource);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataAgentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetIamPolicyRequest actualRequest = ((GetIamPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(resource.toString(), actualRequest.getResource());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getIamPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataAgentService.addException(exception);

    try {
      ResourceName resource = DataAgentName.of("[PROJECT]", "[LOCATION]", "[DATA_AGENT]");
      client.getIamPolicy(resource);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getIamPolicyTest2() throws Exception {
    Policy expectedResponse =
        Policy.newBuilder()
            .setVersion(351608024)
            .addAllBindings(new ArrayList<Binding>())
            .addAllAuditConfigs(new ArrayList<AuditConfig>())
            .setEtag(ByteString.EMPTY)
            .build();
    mockDataAgentService.addResponse(expectedResponse);

    String resource = "resource-341064690";

    Policy actualResponse = client.getIamPolicy(resource);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataAgentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetIamPolicyRequest actualRequest = ((GetIamPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(resource, actualRequest.getResource());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getIamPolicyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataAgentService.addException(exception);

    try {
      String resource = "resource-341064690";
      client.getIamPolicy(resource);
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
    mockDataAgentService.addResponse(expectedResponse);

    ResourceName resource = DataAgentName.of("[PROJECT]", "[LOCATION]", "[DATA_AGENT]");

    Policy actualResponse = client.setIamPolicy(resource);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataAgentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SetIamPolicyRequest actualRequest = ((SetIamPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(resource.toString(), actualRequest.getResource());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void setIamPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataAgentService.addException(exception);

    try {
      ResourceName resource = DataAgentName.of("[PROJECT]", "[LOCATION]", "[DATA_AGENT]");
      client.setIamPolicy(resource);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void setIamPolicyTest2() throws Exception {
    Policy expectedResponse =
        Policy.newBuilder()
            .setVersion(351608024)
            .addAllBindings(new ArrayList<Binding>())
            .addAllAuditConfigs(new ArrayList<AuditConfig>())
            .setEtag(ByteString.EMPTY)
            .build();
    mockDataAgentService.addResponse(expectedResponse);

    String resource = "resource-341064690";

    Policy actualResponse = client.setIamPolicy(resource);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataAgentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SetIamPolicyRequest actualRequest = ((SetIamPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(resource, actualRequest.getResource());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void setIamPolicyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataAgentService.addException(exception);

    try {
      String resource = "resource-341064690";
      client.setIamPolicy(resource);
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
