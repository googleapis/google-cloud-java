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

package com.google.cloud.ids.v1;

import static com.google.cloud.ids.v1.IDSClient.ListEndpointsPagedResponse;

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
import com.google.protobuf.Timestamp;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
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
public class IDSClientTest {
  private static MockIDS mockIDS;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private IDSClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockIDS = new MockIDS();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockIDS));
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
    IDSSettings settings =
        IDSSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = IDSClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listEndpointsTest() throws Exception {
    Endpoint responsesElement = Endpoint.newBuilder().build();
    ListEndpointsResponse expectedResponse =
        ListEndpointsResponse.newBuilder()
            .setNextPageToken("")
            .addAllEndpoints(Arrays.asList(responsesElement))
            .build();
    mockIDS.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListEndpointsPagedResponse pagedListResponse = client.listEndpoints(parent);

    List<Endpoint> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEndpointsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockIDS.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListEndpointsRequest actualRequest = ((ListEndpointsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listEndpointsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIDS.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listEndpoints(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listEndpointsTest2() throws Exception {
    Endpoint responsesElement = Endpoint.newBuilder().build();
    ListEndpointsResponse expectedResponse =
        ListEndpointsResponse.newBuilder()
            .setNextPageToken("")
            .addAllEndpoints(Arrays.asList(responsesElement))
            .build();
    mockIDS.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListEndpointsPagedResponse pagedListResponse = client.listEndpoints(parent);

    List<Endpoint> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEndpointsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockIDS.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListEndpointsRequest actualRequest = ((ListEndpointsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listEndpointsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIDS.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listEndpoints(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getEndpointTest() throws Exception {
    Endpoint expectedResponse =
        Endpoint.newBuilder()
            .setName(EndpointName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setNetwork("network1843485230")
            .setEndpointForwardingRule("endpointForwardingRule1448974478")
            .setEndpointIp("endpointIp-1837754980")
            .setDescription("description-1724546052")
            .setTrafficLogs(true)
            .build();
    mockIDS.addResponse(expectedResponse);

    EndpointName name = EndpointName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT]");

    Endpoint actualResponse = client.getEndpoint(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIDS.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetEndpointRequest actualRequest = ((GetEndpointRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getEndpointExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIDS.addException(exception);

    try {
      EndpointName name = EndpointName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT]");
      client.getEndpoint(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getEndpointTest2() throws Exception {
    Endpoint expectedResponse =
        Endpoint.newBuilder()
            .setName(EndpointName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setNetwork("network1843485230")
            .setEndpointForwardingRule("endpointForwardingRule1448974478")
            .setEndpointIp("endpointIp-1837754980")
            .setDescription("description-1724546052")
            .setTrafficLogs(true)
            .build();
    mockIDS.addResponse(expectedResponse);

    String name = "name3373707";

    Endpoint actualResponse = client.getEndpoint(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIDS.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetEndpointRequest actualRequest = ((GetEndpointRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getEndpointExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIDS.addException(exception);

    try {
      String name = "name3373707";
      client.getEndpoint(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createEndpointTest() throws Exception {
    Endpoint expectedResponse =
        Endpoint.newBuilder()
            .setName(EndpointName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setNetwork("network1843485230")
            .setEndpointForwardingRule("endpointForwardingRule1448974478")
            .setEndpointIp("endpointIp-1837754980")
            .setDescription("description-1724546052")
            .setTrafficLogs(true)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createEndpointTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockIDS.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Endpoint endpoint = Endpoint.newBuilder().build();
    String endpointId = "endpointId-1837754992";

    Endpoint actualResponse = client.createEndpointAsync(parent, endpoint, endpointId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIDS.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateEndpointRequest actualRequest = ((CreateEndpointRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(endpoint, actualRequest.getEndpoint());
    Assert.assertEquals(endpointId, actualRequest.getEndpointId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createEndpointExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIDS.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Endpoint endpoint = Endpoint.newBuilder().build();
      String endpointId = "endpointId-1837754992";
      client.createEndpointAsync(parent, endpoint, endpointId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createEndpointTest2() throws Exception {
    Endpoint expectedResponse =
        Endpoint.newBuilder()
            .setName(EndpointName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setNetwork("network1843485230")
            .setEndpointForwardingRule("endpointForwardingRule1448974478")
            .setEndpointIp("endpointIp-1837754980")
            .setDescription("description-1724546052")
            .setTrafficLogs(true)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createEndpointTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockIDS.addResponse(resultOperation);

    String parent = "parent-995424086";
    Endpoint endpoint = Endpoint.newBuilder().build();
    String endpointId = "endpointId-1837754992";

    Endpoint actualResponse = client.createEndpointAsync(parent, endpoint, endpointId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIDS.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateEndpointRequest actualRequest = ((CreateEndpointRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(endpoint, actualRequest.getEndpoint());
    Assert.assertEquals(endpointId, actualRequest.getEndpointId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createEndpointExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIDS.addException(exception);

    try {
      String parent = "parent-995424086";
      Endpoint endpoint = Endpoint.newBuilder().build();
      String endpointId = "endpointId-1837754992";
      client.createEndpointAsync(parent, endpoint, endpointId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteEndpointTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteEndpointTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockIDS.addResponse(resultOperation);

    EndpointName name = EndpointName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT]");

    client.deleteEndpointAsync(name).get();

    List<AbstractMessage> actualRequests = mockIDS.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteEndpointRequest actualRequest = ((DeleteEndpointRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteEndpointExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIDS.addException(exception);

    try {
      EndpointName name = EndpointName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT]");
      client.deleteEndpointAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteEndpointTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteEndpointTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockIDS.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteEndpointAsync(name).get();

    List<AbstractMessage> actualRequests = mockIDS.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteEndpointRequest actualRequest = ((DeleteEndpointRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteEndpointExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIDS.addException(exception);

    try {
      String name = "name3373707";
      client.deleteEndpointAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }
}
