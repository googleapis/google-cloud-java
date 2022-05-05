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

package com.google.cloud.networkmanagement.v1;

import static com.google.cloud.networkmanagement.v1.ReachabilityServiceClient.ListConnectivityTestsPagedResponse;

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
public class ReachabilityServiceClientTest {
  private static MockReachabilityService mockReachabilityService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private ReachabilityServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockReachabilityService = new MockReachabilityService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockReachabilityService));
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
    ReachabilityServiceSettings settings =
        ReachabilityServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ReachabilityServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listConnectivityTestsTest() throws Exception {
    ConnectivityTest responsesElement = ConnectivityTest.newBuilder().build();
    ListConnectivityTestsResponse expectedResponse =
        ListConnectivityTestsResponse.newBuilder()
            .setNextPageToken("")
            .addAllResources(Arrays.asList(responsesElement))
            .build();
    mockReachabilityService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListConnectivityTestsPagedResponse pagedListResponse = client.listConnectivityTests(parent);

    List<ConnectivityTest> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getResourcesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockReachabilityService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListConnectivityTestsRequest actualRequest =
        ((ListConnectivityTestsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listConnectivityTestsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockReachabilityService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listConnectivityTests(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getConnectivityTestTest() throws Exception {
    ConnectivityTest expectedResponse =
        ConnectivityTest.newBuilder()
            .setName("name3373707")
            .setDescription("description-1724546052")
            .setSource(Endpoint.newBuilder().build())
            .setDestination(Endpoint.newBuilder().build())
            .setProtocol("protocol-989163880")
            .addAllRelatedProjects(new ArrayList<String>())
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setReachabilityDetails(ReachabilityDetails.newBuilder().build())
            .build();
    mockReachabilityService.addResponse(expectedResponse);

    String name = "name3373707";

    ConnectivityTest actualResponse = client.getConnectivityTest(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockReachabilityService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetConnectivityTestRequest actualRequest = ((GetConnectivityTestRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getConnectivityTestExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockReachabilityService.addException(exception);

    try {
      String name = "name3373707";
      client.getConnectivityTest(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createConnectivityTestTest() throws Exception {
    ConnectivityTest expectedResponse =
        ConnectivityTest.newBuilder()
            .setName("name3373707")
            .setDescription("description-1724546052")
            .setSource(Endpoint.newBuilder().build())
            .setDestination(Endpoint.newBuilder().build())
            .setProtocol("protocol-989163880")
            .addAllRelatedProjects(new ArrayList<String>())
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setReachabilityDetails(ReachabilityDetails.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createConnectivityTestTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockReachabilityService.addResponse(resultOperation);

    String parent = "parent-995424086";
    String testId = "testId-877170355";
    ConnectivityTest resource = ConnectivityTest.newBuilder().build();

    ConnectivityTest actualResponse =
        client.createConnectivityTestAsync(parent, testId, resource).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockReachabilityService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateConnectivityTestRequest actualRequest =
        ((CreateConnectivityTestRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(testId, actualRequest.getTestId());
    Assert.assertEquals(resource, actualRequest.getResource());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createConnectivityTestExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockReachabilityService.addException(exception);

    try {
      String parent = "parent-995424086";
      String testId = "testId-877170355";
      ConnectivityTest resource = ConnectivityTest.newBuilder().build();
      client.createConnectivityTestAsync(parent, testId, resource).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateConnectivityTestTest() throws Exception {
    ConnectivityTest expectedResponse =
        ConnectivityTest.newBuilder()
            .setName("name3373707")
            .setDescription("description-1724546052")
            .setSource(Endpoint.newBuilder().build())
            .setDestination(Endpoint.newBuilder().build())
            .setProtocol("protocol-989163880")
            .addAllRelatedProjects(new ArrayList<String>())
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setReachabilityDetails(ReachabilityDetails.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateConnectivityTestTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockReachabilityService.addResponse(resultOperation);

    FieldMask updateMask = FieldMask.newBuilder().build();
    ConnectivityTest resource = ConnectivityTest.newBuilder().build();

    ConnectivityTest actualResponse =
        client.updateConnectivityTestAsync(updateMask, resource).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockReachabilityService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateConnectivityTestRequest actualRequest =
        ((UpdateConnectivityTestRequest) actualRequests.get(0));

    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertEquals(resource, actualRequest.getResource());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateConnectivityTestExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockReachabilityService.addException(exception);

    try {
      FieldMask updateMask = FieldMask.newBuilder().build();
      ConnectivityTest resource = ConnectivityTest.newBuilder().build();
      client.updateConnectivityTestAsync(updateMask, resource).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void rerunConnectivityTestTest() throws Exception {
    ConnectivityTest expectedResponse =
        ConnectivityTest.newBuilder()
            .setName("name3373707")
            .setDescription("description-1724546052")
            .setSource(Endpoint.newBuilder().build())
            .setDestination(Endpoint.newBuilder().build())
            .setProtocol("protocol-989163880")
            .addAllRelatedProjects(new ArrayList<String>())
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setReachabilityDetails(ReachabilityDetails.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("rerunConnectivityTestTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockReachabilityService.addResponse(resultOperation);

    RerunConnectivityTestRequest request =
        RerunConnectivityTestRequest.newBuilder().setName("name3373707").build();

    ConnectivityTest actualResponse = client.rerunConnectivityTestAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockReachabilityService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RerunConnectivityTestRequest actualRequest =
        ((RerunConnectivityTestRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void rerunConnectivityTestExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockReachabilityService.addException(exception);

    try {
      RerunConnectivityTestRequest request =
          RerunConnectivityTestRequest.newBuilder().setName("name3373707").build();
      client.rerunConnectivityTestAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteConnectivityTestTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteConnectivityTestTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockReachabilityService.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteConnectivityTestAsync(name).get();

    List<AbstractMessage> actualRequests = mockReachabilityService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteConnectivityTestRequest actualRequest =
        ((DeleteConnectivityTestRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteConnectivityTestExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockReachabilityService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteConnectivityTestAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }
}
