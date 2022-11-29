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

package com.google.cloud.metastore.v1;

import static com.google.cloud.metastore.v1.DataprocMetastoreFederationClient.ListFederationsPagedResponse;

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
public class DataprocMetastoreFederationClientTest {
  private static MockDataprocMetastoreFederation mockDataprocMetastoreFederation;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private DataprocMetastoreFederationClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockDataprocMetastoreFederation = new MockDataprocMetastoreFederation();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockDataprocMetastoreFederation));
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
    DataprocMetastoreFederationSettings settings =
        DataprocMetastoreFederationSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = DataprocMetastoreFederationClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listFederationsTest() throws Exception {
    Federation responsesElement = Federation.newBuilder().build();
    ListFederationsResponse expectedResponse =
        ListFederationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllFederations(Arrays.asList(responsesElement))
            .build();
    mockDataprocMetastoreFederation.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListFederationsPagedResponse pagedListResponse = client.listFederations(parent);

    List<Federation> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getFederationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataprocMetastoreFederation.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListFederationsRequest actualRequest = ((ListFederationsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listFederationsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataprocMetastoreFederation.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listFederations(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listFederationsTest2() throws Exception {
    Federation responsesElement = Federation.newBuilder().build();
    ListFederationsResponse expectedResponse =
        ListFederationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllFederations(Arrays.asList(responsesElement))
            .build();
    mockDataprocMetastoreFederation.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListFederationsPagedResponse pagedListResponse = client.listFederations(parent);

    List<Federation> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getFederationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataprocMetastoreFederation.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListFederationsRequest actualRequest = ((ListFederationsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listFederationsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataprocMetastoreFederation.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listFederations(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getFederationTest() throws Exception {
    Federation expectedResponse =
        Federation.newBuilder()
            .setName(FederationName.of("[PROJECT]", "[LOCATION]", "[FEDERATION]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setVersion("version351608024")
            .putAllBackendMetastores(new HashMap<Integer, BackendMetastore>())
            .setEndpointUri("endpointUri-1135817833")
            .setStateMessage("stateMessage1128185398")
            .setUid("uid115792")
            .build();
    mockDataprocMetastoreFederation.addResponse(expectedResponse);

    FederationName name = FederationName.of("[PROJECT]", "[LOCATION]", "[FEDERATION]");

    Federation actualResponse = client.getFederation(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataprocMetastoreFederation.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetFederationRequest actualRequest = ((GetFederationRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getFederationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataprocMetastoreFederation.addException(exception);

    try {
      FederationName name = FederationName.of("[PROJECT]", "[LOCATION]", "[FEDERATION]");
      client.getFederation(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getFederationTest2() throws Exception {
    Federation expectedResponse =
        Federation.newBuilder()
            .setName(FederationName.of("[PROJECT]", "[LOCATION]", "[FEDERATION]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setVersion("version351608024")
            .putAllBackendMetastores(new HashMap<Integer, BackendMetastore>())
            .setEndpointUri("endpointUri-1135817833")
            .setStateMessage("stateMessage1128185398")
            .setUid("uid115792")
            .build();
    mockDataprocMetastoreFederation.addResponse(expectedResponse);

    String name = "name3373707";

    Federation actualResponse = client.getFederation(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataprocMetastoreFederation.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetFederationRequest actualRequest = ((GetFederationRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getFederationExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataprocMetastoreFederation.addException(exception);

    try {
      String name = "name3373707";
      client.getFederation(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createFederationTest() throws Exception {
    Federation expectedResponse =
        Federation.newBuilder()
            .setName(FederationName.of("[PROJECT]", "[LOCATION]", "[FEDERATION]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setVersion("version351608024")
            .putAllBackendMetastores(new HashMap<Integer, BackendMetastore>())
            .setEndpointUri("endpointUri-1135817833")
            .setStateMessage("stateMessage1128185398")
            .setUid("uid115792")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createFederationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataprocMetastoreFederation.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Federation federation = Federation.newBuilder().build();
    String federationId = "federationId-735921218";

    Federation actualResponse =
        client.createFederationAsync(parent, federation, federationId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataprocMetastoreFederation.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateFederationRequest actualRequest = ((CreateFederationRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(federation, actualRequest.getFederation());
    Assert.assertEquals(federationId, actualRequest.getFederationId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createFederationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataprocMetastoreFederation.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Federation federation = Federation.newBuilder().build();
      String federationId = "federationId-735921218";
      client.createFederationAsync(parent, federation, federationId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createFederationTest2() throws Exception {
    Federation expectedResponse =
        Federation.newBuilder()
            .setName(FederationName.of("[PROJECT]", "[LOCATION]", "[FEDERATION]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setVersion("version351608024")
            .putAllBackendMetastores(new HashMap<Integer, BackendMetastore>())
            .setEndpointUri("endpointUri-1135817833")
            .setStateMessage("stateMessage1128185398")
            .setUid("uid115792")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createFederationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataprocMetastoreFederation.addResponse(resultOperation);

    String parent = "parent-995424086";
    Federation federation = Federation.newBuilder().build();
    String federationId = "federationId-735921218";

    Federation actualResponse =
        client.createFederationAsync(parent, federation, federationId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataprocMetastoreFederation.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateFederationRequest actualRequest = ((CreateFederationRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(federation, actualRequest.getFederation());
    Assert.assertEquals(federationId, actualRequest.getFederationId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createFederationExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataprocMetastoreFederation.addException(exception);

    try {
      String parent = "parent-995424086";
      Federation federation = Federation.newBuilder().build();
      String federationId = "federationId-735921218";
      client.createFederationAsync(parent, federation, federationId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateFederationTest() throws Exception {
    Federation expectedResponse =
        Federation.newBuilder()
            .setName(FederationName.of("[PROJECT]", "[LOCATION]", "[FEDERATION]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setVersion("version351608024")
            .putAllBackendMetastores(new HashMap<Integer, BackendMetastore>())
            .setEndpointUri("endpointUri-1135817833")
            .setStateMessage("stateMessage1128185398")
            .setUid("uid115792")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateFederationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataprocMetastoreFederation.addResponse(resultOperation);

    Federation federation = Federation.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Federation actualResponse = client.updateFederationAsync(federation, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataprocMetastoreFederation.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateFederationRequest actualRequest = ((UpdateFederationRequest) actualRequests.get(0));

    Assert.assertEquals(federation, actualRequest.getFederation());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateFederationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataprocMetastoreFederation.addException(exception);

    try {
      Federation federation = Federation.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateFederationAsync(federation, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteFederationTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteFederationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataprocMetastoreFederation.addResponse(resultOperation);

    FederationName name = FederationName.of("[PROJECT]", "[LOCATION]", "[FEDERATION]");

    client.deleteFederationAsync(name).get();

    List<AbstractMessage> actualRequests = mockDataprocMetastoreFederation.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteFederationRequest actualRequest = ((DeleteFederationRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteFederationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataprocMetastoreFederation.addException(exception);

    try {
      FederationName name = FederationName.of("[PROJECT]", "[LOCATION]", "[FEDERATION]");
      client.deleteFederationAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteFederationTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteFederationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataprocMetastoreFederation.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteFederationAsync(name).get();

    List<AbstractMessage> actualRequests = mockDataprocMetastoreFederation.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteFederationRequest actualRequest = ((DeleteFederationRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteFederationExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataprocMetastoreFederation.addException(exception);

    try {
      String name = "name3373707";
      client.deleteFederationAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }
}
