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

package com.google.cloud.networkservices.v1;

import static com.google.cloud.networkservices.v1.DepServiceClient.ListLbRouteExtensionsPagedResponse;
import static com.google.cloud.networkservices.v1.DepServiceClient.ListLbTrafficExtensionsPagedResponse;
import static com.google.cloud.networkservices.v1.DepServiceClient.ListLocationsPagedResponse;

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
import com.google.protobuf.Struct;
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
public class DepServiceClientTest {
  private static MockDepService mockDepService;
  private static MockIAMPolicy mockIAMPolicy;
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private DepServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockDepService = new MockDepService();
    mockLocations = new MockLocations();
    mockIAMPolicy = new MockIAMPolicy();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockDepService, mockLocations, mockIAMPolicy));
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
    DepServiceSettings settings =
        DepServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = DepServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listLbTrafficExtensionsTest() throws Exception {
    LbTrafficExtension responsesElement = LbTrafficExtension.newBuilder().build();
    ListLbTrafficExtensionsResponse expectedResponse =
        ListLbTrafficExtensionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllLbTrafficExtensions(Arrays.asList(responsesElement))
            .build();
    mockDepService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListLbTrafficExtensionsPagedResponse pagedListResponse = client.listLbTrafficExtensions(parent);

    List<LbTrafficExtension> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLbTrafficExtensionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDepService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListLbTrafficExtensionsRequest actualRequest =
        ((ListLbTrafficExtensionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listLbTrafficExtensionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDepService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listLbTrafficExtensions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listLbTrafficExtensionsTest2() throws Exception {
    LbTrafficExtension responsesElement = LbTrafficExtension.newBuilder().build();
    ListLbTrafficExtensionsResponse expectedResponse =
        ListLbTrafficExtensionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllLbTrafficExtensions(Arrays.asList(responsesElement))
            .build();
    mockDepService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListLbTrafficExtensionsPagedResponse pagedListResponse = client.listLbTrafficExtensions(parent);

    List<LbTrafficExtension> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLbTrafficExtensionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDepService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListLbTrafficExtensionsRequest actualRequest =
        ((ListLbTrafficExtensionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listLbTrafficExtensionsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDepService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listLbTrafficExtensions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getLbTrafficExtensionTest() throws Exception {
    LbTrafficExtension expectedResponse =
        LbTrafficExtension.newBuilder()
            .setName(
                LbTrafficExtensionName.of("[PROJECT]", "[LOCATION]", "[LB_TRAFFIC_EXTENSION]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .putAllLabels(new HashMap<String, String>())
            .addAllForwardingRules(new ArrayList<String>())
            .addAllExtensionChains(new ArrayList<ExtensionChain>())
            .setLoadBalancingScheme(LoadBalancingScheme.forNumber(0))
            .setMetadata(Struct.newBuilder().build())
            .build();
    mockDepService.addResponse(expectedResponse);

    LbTrafficExtensionName name =
        LbTrafficExtensionName.of("[PROJECT]", "[LOCATION]", "[LB_TRAFFIC_EXTENSION]");

    LbTrafficExtension actualResponse = client.getLbTrafficExtension(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDepService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetLbTrafficExtensionRequest actualRequest =
        ((GetLbTrafficExtensionRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getLbTrafficExtensionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDepService.addException(exception);

    try {
      LbTrafficExtensionName name =
          LbTrafficExtensionName.of("[PROJECT]", "[LOCATION]", "[LB_TRAFFIC_EXTENSION]");
      client.getLbTrafficExtension(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getLbTrafficExtensionTest2() throws Exception {
    LbTrafficExtension expectedResponse =
        LbTrafficExtension.newBuilder()
            .setName(
                LbTrafficExtensionName.of("[PROJECT]", "[LOCATION]", "[LB_TRAFFIC_EXTENSION]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .putAllLabels(new HashMap<String, String>())
            .addAllForwardingRules(new ArrayList<String>())
            .addAllExtensionChains(new ArrayList<ExtensionChain>())
            .setLoadBalancingScheme(LoadBalancingScheme.forNumber(0))
            .setMetadata(Struct.newBuilder().build())
            .build();
    mockDepService.addResponse(expectedResponse);

    String name = "name3373707";

    LbTrafficExtension actualResponse = client.getLbTrafficExtension(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDepService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetLbTrafficExtensionRequest actualRequest =
        ((GetLbTrafficExtensionRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getLbTrafficExtensionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDepService.addException(exception);

    try {
      String name = "name3373707";
      client.getLbTrafficExtension(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createLbTrafficExtensionTest() throws Exception {
    LbTrafficExtension expectedResponse =
        LbTrafficExtension.newBuilder()
            .setName(
                LbTrafficExtensionName.of("[PROJECT]", "[LOCATION]", "[LB_TRAFFIC_EXTENSION]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .putAllLabels(new HashMap<String, String>())
            .addAllForwardingRules(new ArrayList<String>())
            .addAllExtensionChains(new ArrayList<ExtensionChain>())
            .setLoadBalancingScheme(LoadBalancingScheme.forNumber(0))
            .setMetadata(Struct.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createLbTrafficExtensionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDepService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    LbTrafficExtension lbTrafficExtension = LbTrafficExtension.newBuilder().build();
    String lbTrafficExtensionId = "lbTrafficExtensionId1150549907";

    LbTrafficExtension actualResponse =
        client
            .createLbTrafficExtensionAsync(parent, lbTrafficExtension, lbTrafficExtensionId)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDepService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateLbTrafficExtensionRequest actualRequest =
        ((CreateLbTrafficExtensionRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(lbTrafficExtension, actualRequest.getLbTrafficExtension());
    Assert.assertEquals(lbTrafficExtensionId, actualRequest.getLbTrafficExtensionId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createLbTrafficExtensionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDepService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      LbTrafficExtension lbTrafficExtension = LbTrafficExtension.newBuilder().build();
      String lbTrafficExtensionId = "lbTrafficExtensionId1150549907";
      client.createLbTrafficExtensionAsync(parent, lbTrafficExtension, lbTrafficExtensionId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createLbTrafficExtensionTest2() throws Exception {
    LbTrafficExtension expectedResponse =
        LbTrafficExtension.newBuilder()
            .setName(
                LbTrafficExtensionName.of("[PROJECT]", "[LOCATION]", "[LB_TRAFFIC_EXTENSION]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .putAllLabels(new HashMap<String, String>())
            .addAllForwardingRules(new ArrayList<String>())
            .addAllExtensionChains(new ArrayList<ExtensionChain>())
            .setLoadBalancingScheme(LoadBalancingScheme.forNumber(0))
            .setMetadata(Struct.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createLbTrafficExtensionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDepService.addResponse(resultOperation);

    String parent = "parent-995424086";
    LbTrafficExtension lbTrafficExtension = LbTrafficExtension.newBuilder().build();
    String lbTrafficExtensionId = "lbTrafficExtensionId1150549907";

    LbTrafficExtension actualResponse =
        client
            .createLbTrafficExtensionAsync(parent, lbTrafficExtension, lbTrafficExtensionId)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDepService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateLbTrafficExtensionRequest actualRequest =
        ((CreateLbTrafficExtensionRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(lbTrafficExtension, actualRequest.getLbTrafficExtension());
    Assert.assertEquals(lbTrafficExtensionId, actualRequest.getLbTrafficExtensionId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createLbTrafficExtensionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDepService.addException(exception);

    try {
      String parent = "parent-995424086";
      LbTrafficExtension lbTrafficExtension = LbTrafficExtension.newBuilder().build();
      String lbTrafficExtensionId = "lbTrafficExtensionId1150549907";
      client.createLbTrafficExtensionAsync(parent, lbTrafficExtension, lbTrafficExtensionId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateLbTrafficExtensionTest() throws Exception {
    LbTrafficExtension expectedResponse =
        LbTrafficExtension.newBuilder()
            .setName(
                LbTrafficExtensionName.of("[PROJECT]", "[LOCATION]", "[LB_TRAFFIC_EXTENSION]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .putAllLabels(new HashMap<String, String>())
            .addAllForwardingRules(new ArrayList<String>())
            .addAllExtensionChains(new ArrayList<ExtensionChain>())
            .setLoadBalancingScheme(LoadBalancingScheme.forNumber(0))
            .setMetadata(Struct.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateLbTrafficExtensionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDepService.addResponse(resultOperation);

    LbTrafficExtension lbTrafficExtension = LbTrafficExtension.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    LbTrafficExtension actualResponse =
        client.updateLbTrafficExtensionAsync(lbTrafficExtension, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDepService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateLbTrafficExtensionRequest actualRequest =
        ((UpdateLbTrafficExtensionRequest) actualRequests.get(0));

    Assert.assertEquals(lbTrafficExtension, actualRequest.getLbTrafficExtension());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateLbTrafficExtensionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDepService.addException(exception);

    try {
      LbTrafficExtension lbTrafficExtension = LbTrafficExtension.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateLbTrafficExtensionAsync(lbTrafficExtension, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteLbTrafficExtensionTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteLbTrafficExtensionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDepService.addResponse(resultOperation);

    LbTrafficExtensionName name =
        LbTrafficExtensionName.of("[PROJECT]", "[LOCATION]", "[LB_TRAFFIC_EXTENSION]");

    client.deleteLbTrafficExtensionAsync(name).get();

    List<AbstractMessage> actualRequests = mockDepService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteLbTrafficExtensionRequest actualRequest =
        ((DeleteLbTrafficExtensionRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteLbTrafficExtensionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDepService.addException(exception);

    try {
      LbTrafficExtensionName name =
          LbTrafficExtensionName.of("[PROJECT]", "[LOCATION]", "[LB_TRAFFIC_EXTENSION]");
      client.deleteLbTrafficExtensionAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteLbTrafficExtensionTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteLbTrafficExtensionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDepService.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteLbTrafficExtensionAsync(name).get();

    List<AbstractMessage> actualRequests = mockDepService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteLbTrafficExtensionRequest actualRequest =
        ((DeleteLbTrafficExtensionRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteLbTrafficExtensionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDepService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteLbTrafficExtensionAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listLbRouteExtensionsTest() throws Exception {
    LbRouteExtension responsesElement = LbRouteExtension.newBuilder().build();
    ListLbRouteExtensionsResponse expectedResponse =
        ListLbRouteExtensionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllLbRouteExtensions(Arrays.asList(responsesElement))
            .build();
    mockDepService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListLbRouteExtensionsPagedResponse pagedListResponse = client.listLbRouteExtensions(parent);

    List<LbRouteExtension> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLbRouteExtensionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDepService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListLbRouteExtensionsRequest actualRequest =
        ((ListLbRouteExtensionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listLbRouteExtensionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDepService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listLbRouteExtensions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listLbRouteExtensionsTest2() throws Exception {
    LbRouteExtension responsesElement = LbRouteExtension.newBuilder().build();
    ListLbRouteExtensionsResponse expectedResponse =
        ListLbRouteExtensionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllLbRouteExtensions(Arrays.asList(responsesElement))
            .build();
    mockDepService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListLbRouteExtensionsPagedResponse pagedListResponse = client.listLbRouteExtensions(parent);

    List<LbRouteExtension> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLbRouteExtensionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDepService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListLbRouteExtensionsRequest actualRequest =
        ((ListLbRouteExtensionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listLbRouteExtensionsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDepService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listLbRouteExtensions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getLbRouteExtensionTest() throws Exception {
    LbRouteExtension expectedResponse =
        LbRouteExtension.newBuilder()
            .setName(
                LbRouteExtensionName.of("[PROJECT]", "[LOCATION]", "[LB_ROUTE_EXTENSION]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .putAllLabels(new HashMap<String, String>())
            .addAllForwardingRules(new ArrayList<String>())
            .addAllExtensionChains(new ArrayList<ExtensionChain>())
            .setLoadBalancingScheme(LoadBalancingScheme.forNumber(0))
            .setMetadata(Struct.newBuilder().build())
            .build();
    mockDepService.addResponse(expectedResponse);

    LbRouteExtensionName name =
        LbRouteExtensionName.of("[PROJECT]", "[LOCATION]", "[LB_ROUTE_EXTENSION]");

    LbRouteExtension actualResponse = client.getLbRouteExtension(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDepService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetLbRouteExtensionRequest actualRequest = ((GetLbRouteExtensionRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getLbRouteExtensionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDepService.addException(exception);

    try {
      LbRouteExtensionName name =
          LbRouteExtensionName.of("[PROJECT]", "[LOCATION]", "[LB_ROUTE_EXTENSION]");
      client.getLbRouteExtension(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getLbRouteExtensionTest2() throws Exception {
    LbRouteExtension expectedResponse =
        LbRouteExtension.newBuilder()
            .setName(
                LbRouteExtensionName.of("[PROJECT]", "[LOCATION]", "[LB_ROUTE_EXTENSION]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .putAllLabels(new HashMap<String, String>())
            .addAllForwardingRules(new ArrayList<String>())
            .addAllExtensionChains(new ArrayList<ExtensionChain>())
            .setLoadBalancingScheme(LoadBalancingScheme.forNumber(0))
            .setMetadata(Struct.newBuilder().build())
            .build();
    mockDepService.addResponse(expectedResponse);

    String name = "name3373707";

    LbRouteExtension actualResponse = client.getLbRouteExtension(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDepService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetLbRouteExtensionRequest actualRequest = ((GetLbRouteExtensionRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getLbRouteExtensionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDepService.addException(exception);

    try {
      String name = "name3373707";
      client.getLbRouteExtension(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createLbRouteExtensionTest() throws Exception {
    LbRouteExtension expectedResponse =
        LbRouteExtension.newBuilder()
            .setName(
                LbRouteExtensionName.of("[PROJECT]", "[LOCATION]", "[LB_ROUTE_EXTENSION]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .putAllLabels(new HashMap<String, String>())
            .addAllForwardingRules(new ArrayList<String>())
            .addAllExtensionChains(new ArrayList<ExtensionChain>())
            .setLoadBalancingScheme(LoadBalancingScheme.forNumber(0))
            .setMetadata(Struct.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createLbRouteExtensionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDepService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    LbRouteExtension lbRouteExtension = LbRouteExtension.newBuilder().build();
    String lbRouteExtensionId = "lbRouteExtensionId-1336830649";

    LbRouteExtension actualResponse =
        client.createLbRouteExtensionAsync(parent, lbRouteExtension, lbRouteExtensionId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDepService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateLbRouteExtensionRequest actualRequest =
        ((CreateLbRouteExtensionRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(lbRouteExtension, actualRequest.getLbRouteExtension());
    Assert.assertEquals(lbRouteExtensionId, actualRequest.getLbRouteExtensionId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createLbRouteExtensionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDepService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      LbRouteExtension lbRouteExtension = LbRouteExtension.newBuilder().build();
      String lbRouteExtensionId = "lbRouteExtensionId-1336830649";
      client.createLbRouteExtensionAsync(parent, lbRouteExtension, lbRouteExtensionId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createLbRouteExtensionTest2() throws Exception {
    LbRouteExtension expectedResponse =
        LbRouteExtension.newBuilder()
            .setName(
                LbRouteExtensionName.of("[PROJECT]", "[LOCATION]", "[LB_ROUTE_EXTENSION]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .putAllLabels(new HashMap<String, String>())
            .addAllForwardingRules(new ArrayList<String>())
            .addAllExtensionChains(new ArrayList<ExtensionChain>())
            .setLoadBalancingScheme(LoadBalancingScheme.forNumber(0))
            .setMetadata(Struct.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createLbRouteExtensionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDepService.addResponse(resultOperation);

    String parent = "parent-995424086";
    LbRouteExtension lbRouteExtension = LbRouteExtension.newBuilder().build();
    String lbRouteExtensionId = "lbRouteExtensionId-1336830649";

    LbRouteExtension actualResponse =
        client.createLbRouteExtensionAsync(parent, lbRouteExtension, lbRouteExtensionId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDepService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateLbRouteExtensionRequest actualRequest =
        ((CreateLbRouteExtensionRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(lbRouteExtension, actualRequest.getLbRouteExtension());
    Assert.assertEquals(lbRouteExtensionId, actualRequest.getLbRouteExtensionId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createLbRouteExtensionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDepService.addException(exception);

    try {
      String parent = "parent-995424086";
      LbRouteExtension lbRouteExtension = LbRouteExtension.newBuilder().build();
      String lbRouteExtensionId = "lbRouteExtensionId-1336830649";
      client.createLbRouteExtensionAsync(parent, lbRouteExtension, lbRouteExtensionId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateLbRouteExtensionTest() throws Exception {
    LbRouteExtension expectedResponse =
        LbRouteExtension.newBuilder()
            .setName(
                LbRouteExtensionName.of("[PROJECT]", "[LOCATION]", "[LB_ROUTE_EXTENSION]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .putAllLabels(new HashMap<String, String>())
            .addAllForwardingRules(new ArrayList<String>())
            .addAllExtensionChains(new ArrayList<ExtensionChain>())
            .setLoadBalancingScheme(LoadBalancingScheme.forNumber(0))
            .setMetadata(Struct.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateLbRouteExtensionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDepService.addResponse(resultOperation);

    LbRouteExtension lbRouteExtension = LbRouteExtension.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    LbRouteExtension actualResponse =
        client.updateLbRouteExtensionAsync(lbRouteExtension, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDepService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateLbRouteExtensionRequest actualRequest =
        ((UpdateLbRouteExtensionRequest) actualRequests.get(0));

    Assert.assertEquals(lbRouteExtension, actualRequest.getLbRouteExtension());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateLbRouteExtensionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDepService.addException(exception);

    try {
      LbRouteExtension lbRouteExtension = LbRouteExtension.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateLbRouteExtensionAsync(lbRouteExtension, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteLbRouteExtensionTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteLbRouteExtensionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDepService.addResponse(resultOperation);

    LbRouteExtensionName name =
        LbRouteExtensionName.of("[PROJECT]", "[LOCATION]", "[LB_ROUTE_EXTENSION]");

    client.deleteLbRouteExtensionAsync(name).get();

    List<AbstractMessage> actualRequests = mockDepService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteLbRouteExtensionRequest actualRequest =
        ((DeleteLbRouteExtensionRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteLbRouteExtensionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDepService.addException(exception);

    try {
      LbRouteExtensionName name =
          LbRouteExtensionName.of("[PROJECT]", "[LOCATION]", "[LB_ROUTE_EXTENSION]");
      client.deleteLbRouteExtensionAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteLbRouteExtensionTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteLbRouteExtensionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDepService.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteLbRouteExtensionAsync(name).get();

    List<AbstractMessage> actualRequests = mockDepService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteLbRouteExtensionRequest actualRequest =
        ((DeleteLbRouteExtensionRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteLbRouteExtensionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDepService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteLbRouteExtensionAsync(name).get();
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
                EndpointPolicyName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT_POLICY]").toString())
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
                  EndpointPolicyName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT_POLICY]").toString())
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
                EndpointPolicyName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT_POLICY]").toString())
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
                  EndpointPolicyName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT_POLICY]").toString())
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
                EndpointPolicyName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT_POLICY]").toString())
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
                  EndpointPolicyName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT_POLICY]").toString())
              .addAllPermissions(new ArrayList<String>())
              .build();
      client.testIamPermissions(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
