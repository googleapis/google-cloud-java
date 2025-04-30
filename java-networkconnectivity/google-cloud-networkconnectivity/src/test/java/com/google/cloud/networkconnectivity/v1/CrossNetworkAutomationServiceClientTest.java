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

package com.google.cloud.networkconnectivity.v1;

import static com.google.cloud.networkconnectivity.v1.CrossNetworkAutomationServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.networkconnectivity.v1.CrossNetworkAutomationServiceClient.ListServiceClassesPagedResponse;
import static com.google.cloud.networkconnectivity.v1.CrossNetworkAutomationServiceClient.ListServiceConnectionMapsPagedResponse;
import static com.google.cloud.networkconnectivity.v1.CrossNetworkAutomationServiceClient.ListServiceConnectionPoliciesPagedResponse;
import static com.google.cloud.networkconnectivity.v1.CrossNetworkAutomationServiceClient.ListServiceConnectionTokensPagedResponse;

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
public class CrossNetworkAutomationServiceClientTest {
  private static MockCrossNetworkAutomationService mockCrossNetworkAutomationService;
  private static MockIAMPolicy mockIAMPolicy;
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private CrossNetworkAutomationServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockCrossNetworkAutomationService = new MockCrossNetworkAutomationService();
    mockLocations = new MockLocations();
    mockIAMPolicy = new MockIAMPolicy();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(
                mockCrossNetworkAutomationService, mockLocations, mockIAMPolicy));
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
    CrossNetworkAutomationServiceSettings settings =
        CrossNetworkAutomationServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = CrossNetworkAutomationServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listServiceConnectionMapsTest() throws Exception {
    ServiceConnectionMap responsesElement = ServiceConnectionMap.newBuilder().build();
    ListServiceConnectionMapsResponse expectedResponse =
        ListServiceConnectionMapsResponse.newBuilder()
            .setNextPageToken("")
            .addAllServiceConnectionMaps(Arrays.asList(responsesElement))
            .build();
    mockCrossNetworkAutomationService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListServiceConnectionMapsPagedResponse pagedListResponse =
        client.listServiceConnectionMaps(parent);

    List<ServiceConnectionMap> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getServiceConnectionMapsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCrossNetworkAutomationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListServiceConnectionMapsRequest actualRequest =
        ((ListServiceConnectionMapsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listServiceConnectionMapsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCrossNetworkAutomationService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listServiceConnectionMaps(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listServiceConnectionMapsTest2() throws Exception {
    ServiceConnectionMap responsesElement = ServiceConnectionMap.newBuilder().build();
    ListServiceConnectionMapsResponse expectedResponse =
        ListServiceConnectionMapsResponse.newBuilder()
            .setNextPageToken("")
            .addAllServiceConnectionMaps(Arrays.asList(responsesElement))
            .build();
    mockCrossNetworkAutomationService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListServiceConnectionMapsPagedResponse pagedListResponse =
        client.listServiceConnectionMaps(parent);

    List<ServiceConnectionMap> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getServiceConnectionMapsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCrossNetworkAutomationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListServiceConnectionMapsRequest actualRequest =
        ((ListServiceConnectionMapsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listServiceConnectionMapsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCrossNetworkAutomationService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listServiceConnectionMaps(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getServiceConnectionMapTest() throws Exception {
    ServiceConnectionMap expectedResponse =
        ServiceConnectionMap.newBuilder()
            .setName(
                ServiceConnectionMapName.of("[PROJECT]", "[LOCATION]", "[SERVICE_CONNECTION_MAP]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .setServiceClass("serviceClass333962179")
            .setServiceClassUri("serviceClassUri1923102377")
            .setInfrastructure(Infrastructure.forNumber(0))
            .addAllProducerPscConfigs(new ArrayList<ServiceConnectionMap.ProducerPscConfig>())
            .addAllConsumerPscConfigs(new ArrayList<ServiceConnectionMap.ConsumerPscConfig>())
            .addAllConsumerPscConnections(
                new ArrayList<ServiceConnectionMap.ConsumerPscConnection>())
            .setToken("token110541305")
            .setEtag("etag3123477")
            .build();
    mockCrossNetworkAutomationService.addResponse(expectedResponse);

    ServiceConnectionMapName name =
        ServiceConnectionMapName.of("[PROJECT]", "[LOCATION]", "[SERVICE_CONNECTION_MAP]");

    ServiceConnectionMap actualResponse = client.getServiceConnectionMap(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCrossNetworkAutomationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetServiceConnectionMapRequest actualRequest =
        ((GetServiceConnectionMapRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getServiceConnectionMapExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCrossNetworkAutomationService.addException(exception);

    try {
      ServiceConnectionMapName name =
          ServiceConnectionMapName.of("[PROJECT]", "[LOCATION]", "[SERVICE_CONNECTION_MAP]");
      client.getServiceConnectionMap(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getServiceConnectionMapTest2() throws Exception {
    ServiceConnectionMap expectedResponse =
        ServiceConnectionMap.newBuilder()
            .setName(
                ServiceConnectionMapName.of("[PROJECT]", "[LOCATION]", "[SERVICE_CONNECTION_MAP]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .setServiceClass("serviceClass333962179")
            .setServiceClassUri("serviceClassUri1923102377")
            .setInfrastructure(Infrastructure.forNumber(0))
            .addAllProducerPscConfigs(new ArrayList<ServiceConnectionMap.ProducerPscConfig>())
            .addAllConsumerPscConfigs(new ArrayList<ServiceConnectionMap.ConsumerPscConfig>())
            .addAllConsumerPscConnections(
                new ArrayList<ServiceConnectionMap.ConsumerPscConnection>())
            .setToken("token110541305")
            .setEtag("etag3123477")
            .build();
    mockCrossNetworkAutomationService.addResponse(expectedResponse);

    String name = "name3373707";

    ServiceConnectionMap actualResponse = client.getServiceConnectionMap(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCrossNetworkAutomationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetServiceConnectionMapRequest actualRequest =
        ((GetServiceConnectionMapRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getServiceConnectionMapExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCrossNetworkAutomationService.addException(exception);

    try {
      String name = "name3373707";
      client.getServiceConnectionMap(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createServiceConnectionMapTest() throws Exception {
    ServiceConnectionMap expectedResponse =
        ServiceConnectionMap.newBuilder()
            .setName(
                ServiceConnectionMapName.of("[PROJECT]", "[LOCATION]", "[SERVICE_CONNECTION_MAP]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .setServiceClass("serviceClass333962179")
            .setServiceClassUri("serviceClassUri1923102377")
            .setInfrastructure(Infrastructure.forNumber(0))
            .addAllProducerPscConfigs(new ArrayList<ServiceConnectionMap.ProducerPscConfig>())
            .addAllConsumerPscConfigs(new ArrayList<ServiceConnectionMap.ConsumerPscConfig>())
            .addAllConsumerPscConnections(
                new ArrayList<ServiceConnectionMap.ConsumerPscConnection>())
            .setToken("token110541305")
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createServiceConnectionMapTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCrossNetworkAutomationService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    ServiceConnectionMap serviceConnectionMap = ServiceConnectionMap.newBuilder().build();
    String serviceConnectionMapId = "serviceConnectionMapId407176164";

    ServiceConnectionMap actualResponse =
        client
            .createServiceConnectionMapAsync(parent, serviceConnectionMap, serviceConnectionMapId)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCrossNetworkAutomationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateServiceConnectionMapRequest actualRequest =
        ((CreateServiceConnectionMapRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(serviceConnectionMap, actualRequest.getServiceConnectionMap());
    Assert.assertEquals(serviceConnectionMapId, actualRequest.getServiceConnectionMapId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createServiceConnectionMapExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCrossNetworkAutomationService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      ServiceConnectionMap serviceConnectionMap = ServiceConnectionMap.newBuilder().build();
      String serviceConnectionMapId = "serviceConnectionMapId407176164";
      client
          .createServiceConnectionMapAsync(parent, serviceConnectionMap, serviceConnectionMapId)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createServiceConnectionMapTest2() throws Exception {
    ServiceConnectionMap expectedResponse =
        ServiceConnectionMap.newBuilder()
            .setName(
                ServiceConnectionMapName.of("[PROJECT]", "[LOCATION]", "[SERVICE_CONNECTION_MAP]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .setServiceClass("serviceClass333962179")
            .setServiceClassUri("serviceClassUri1923102377")
            .setInfrastructure(Infrastructure.forNumber(0))
            .addAllProducerPscConfigs(new ArrayList<ServiceConnectionMap.ProducerPscConfig>())
            .addAllConsumerPscConfigs(new ArrayList<ServiceConnectionMap.ConsumerPscConfig>())
            .addAllConsumerPscConnections(
                new ArrayList<ServiceConnectionMap.ConsumerPscConnection>())
            .setToken("token110541305")
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createServiceConnectionMapTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCrossNetworkAutomationService.addResponse(resultOperation);

    String parent = "parent-995424086";
    ServiceConnectionMap serviceConnectionMap = ServiceConnectionMap.newBuilder().build();
    String serviceConnectionMapId = "serviceConnectionMapId407176164";

    ServiceConnectionMap actualResponse =
        client
            .createServiceConnectionMapAsync(parent, serviceConnectionMap, serviceConnectionMapId)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCrossNetworkAutomationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateServiceConnectionMapRequest actualRequest =
        ((CreateServiceConnectionMapRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(serviceConnectionMap, actualRequest.getServiceConnectionMap());
    Assert.assertEquals(serviceConnectionMapId, actualRequest.getServiceConnectionMapId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createServiceConnectionMapExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCrossNetworkAutomationService.addException(exception);

    try {
      String parent = "parent-995424086";
      ServiceConnectionMap serviceConnectionMap = ServiceConnectionMap.newBuilder().build();
      String serviceConnectionMapId = "serviceConnectionMapId407176164";
      client
          .createServiceConnectionMapAsync(parent, serviceConnectionMap, serviceConnectionMapId)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateServiceConnectionMapTest() throws Exception {
    ServiceConnectionMap expectedResponse =
        ServiceConnectionMap.newBuilder()
            .setName(
                ServiceConnectionMapName.of("[PROJECT]", "[LOCATION]", "[SERVICE_CONNECTION_MAP]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .setServiceClass("serviceClass333962179")
            .setServiceClassUri("serviceClassUri1923102377")
            .setInfrastructure(Infrastructure.forNumber(0))
            .addAllProducerPscConfigs(new ArrayList<ServiceConnectionMap.ProducerPscConfig>())
            .addAllConsumerPscConfigs(new ArrayList<ServiceConnectionMap.ConsumerPscConfig>())
            .addAllConsumerPscConnections(
                new ArrayList<ServiceConnectionMap.ConsumerPscConnection>())
            .setToken("token110541305")
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateServiceConnectionMapTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCrossNetworkAutomationService.addResponse(resultOperation);

    ServiceConnectionMap serviceConnectionMap = ServiceConnectionMap.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    ServiceConnectionMap actualResponse =
        client.updateServiceConnectionMapAsync(serviceConnectionMap, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCrossNetworkAutomationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateServiceConnectionMapRequest actualRequest =
        ((UpdateServiceConnectionMapRequest) actualRequests.get(0));

    Assert.assertEquals(serviceConnectionMap, actualRequest.getServiceConnectionMap());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateServiceConnectionMapExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCrossNetworkAutomationService.addException(exception);

    try {
      ServiceConnectionMap serviceConnectionMap = ServiceConnectionMap.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateServiceConnectionMapAsync(serviceConnectionMap, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteServiceConnectionMapTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteServiceConnectionMapTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCrossNetworkAutomationService.addResponse(resultOperation);

    ServiceConnectionMapName name =
        ServiceConnectionMapName.of("[PROJECT]", "[LOCATION]", "[SERVICE_CONNECTION_MAP]");

    client.deleteServiceConnectionMapAsync(name).get();

    List<AbstractMessage> actualRequests = mockCrossNetworkAutomationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteServiceConnectionMapRequest actualRequest =
        ((DeleteServiceConnectionMapRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteServiceConnectionMapExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCrossNetworkAutomationService.addException(exception);

    try {
      ServiceConnectionMapName name =
          ServiceConnectionMapName.of("[PROJECT]", "[LOCATION]", "[SERVICE_CONNECTION_MAP]");
      client.deleteServiceConnectionMapAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteServiceConnectionMapTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteServiceConnectionMapTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCrossNetworkAutomationService.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteServiceConnectionMapAsync(name).get();

    List<AbstractMessage> actualRequests = mockCrossNetworkAutomationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteServiceConnectionMapRequest actualRequest =
        ((DeleteServiceConnectionMapRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteServiceConnectionMapExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCrossNetworkAutomationService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteServiceConnectionMapAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listServiceConnectionPoliciesTest() throws Exception {
    ServiceConnectionPolicy responsesElement = ServiceConnectionPolicy.newBuilder().build();
    ListServiceConnectionPoliciesResponse expectedResponse =
        ListServiceConnectionPoliciesResponse.newBuilder()
            .setNextPageToken("")
            .addAllServiceConnectionPolicies(Arrays.asList(responsesElement))
            .build();
    mockCrossNetworkAutomationService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListServiceConnectionPoliciesPagedResponse pagedListResponse =
        client.listServiceConnectionPolicies(parent);

    List<ServiceConnectionPolicy> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getServiceConnectionPoliciesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCrossNetworkAutomationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListServiceConnectionPoliciesRequest actualRequest =
        ((ListServiceConnectionPoliciesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listServiceConnectionPoliciesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCrossNetworkAutomationService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listServiceConnectionPolicies(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listServiceConnectionPoliciesTest2() throws Exception {
    ServiceConnectionPolicy responsesElement = ServiceConnectionPolicy.newBuilder().build();
    ListServiceConnectionPoliciesResponse expectedResponse =
        ListServiceConnectionPoliciesResponse.newBuilder()
            .setNextPageToken("")
            .addAllServiceConnectionPolicies(Arrays.asList(responsesElement))
            .build();
    mockCrossNetworkAutomationService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListServiceConnectionPoliciesPagedResponse pagedListResponse =
        client.listServiceConnectionPolicies(parent);

    List<ServiceConnectionPolicy> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getServiceConnectionPoliciesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCrossNetworkAutomationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListServiceConnectionPoliciesRequest actualRequest =
        ((ListServiceConnectionPoliciesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listServiceConnectionPoliciesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCrossNetworkAutomationService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listServiceConnectionPolicies(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getServiceConnectionPolicyTest() throws Exception {
    ServiceConnectionPolicy expectedResponse =
        ServiceConnectionPolicy.newBuilder()
            .setName(
                ServiceConnectionPolicyName.of(
                        "[PROJECT]", "[LOCATION]", "[SERVICE_CONNECTION_POLICY]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .setNetwork("network1843485230")
            .setServiceClass("serviceClass333962179")
            .setInfrastructure(Infrastructure.forNumber(0))
            .setPscConfig(ServiceConnectionPolicy.PscConfig.newBuilder().build())
            .addAllPscConnections(new ArrayList<ServiceConnectionPolicy.PscConnection>())
            .setEtag("etag3123477")
            .build();
    mockCrossNetworkAutomationService.addResponse(expectedResponse);

    ServiceConnectionPolicyName name =
        ServiceConnectionPolicyName.of("[PROJECT]", "[LOCATION]", "[SERVICE_CONNECTION_POLICY]");

    ServiceConnectionPolicy actualResponse = client.getServiceConnectionPolicy(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCrossNetworkAutomationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetServiceConnectionPolicyRequest actualRequest =
        ((GetServiceConnectionPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getServiceConnectionPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCrossNetworkAutomationService.addException(exception);

    try {
      ServiceConnectionPolicyName name =
          ServiceConnectionPolicyName.of("[PROJECT]", "[LOCATION]", "[SERVICE_CONNECTION_POLICY]");
      client.getServiceConnectionPolicy(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getServiceConnectionPolicyTest2() throws Exception {
    ServiceConnectionPolicy expectedResponse =
        ServiceConnectionPolicy.newBuilder()
            .setName(
                ServiceConnectionPolicyName.of(
                        "[PROJECT]", "[LOCATION]", "[SERVICE_CONNECTION_POLICY]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .setNetwork("network1843485230")
            .setServiceClass("serviceClass333962179")
            .setInfrastructure(Infrastructure.forNumber(0))
            .setPscConfig(ServiceConnectionPolicy.PscConfig.newBuilder().build())
            .addAllPscConnections(new ArrayList<ServiceConnectionPolicy.PscConnection>())
            .setEtag("etag3123477")
            .build();
    mockCrossNetworkAutomationService.addResponse(expectedResponse);

    String name = "name3373707";

    ServiceConnectionPolicy actualResponse = client.getServiceConnectionPolicy(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCrossNetworkAutomationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetServiceConnectionPolicyRequest actualRequest =
        ((GetServiceConnectionPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getServiceConnectionPolicyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCrossNetworkAutomationService.addException(exception);

    try {
      String name = "name3373707";
      client.getServiceConnectionPolicy(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createServiceConnectionPolicyTest() throws Exception {
    ServiceConnectionPolicy expectedResponse =
        ServiceConnectionPolicy.newBuilder()
            .setName(
                ServiceConnectionPolicyName.of(
                        "[PROJECT]", "[LOCATION]", "[SERVICE_CONNECTION_POLICY]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .setNetwork("network1843485230")
            .setServiceClass("serviceClass333962179")
            .setInfrastructure(Infrastructure.forNumber(0))
            .setPscConfig(ServiceConnectionPolicy.PscConfig.newBuilder().build())
            .addAllPscConnections(new ArrayList<ServiceConnectionPolicy.PscConnection>())
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createServiceConnectionPolicyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCrossNetworkAutomationService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    ServiceConnectionPolicy serviceConnectionPolicy = ServiceConnectionPolicy.newBuilder().build();
    String serviceConnectionPolicyId = "serviceConnectionPolicyId1586196096";

    ServiceConnectionPolicy actualResponse =
        client
            .createServiceConnectionPolicyAsync(
                parent, serviceConnectionPolicy, serviceConnectionPolicyId)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCrossNetworkAutomationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateServiceConnectionPolicyRequest actualRequest =
        ((CreateServiceConnectionPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(serviceConnectionPolicy, actualRequest.getServiceConnectionPolicy());
    Assert.assertEquals(serviceConnectionPolicyId, actualRequest.getServiceConnectionPolicyId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createServiceConnectionPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCrossNetworkAutomationService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      ServiceConnectionPolicy serviceConnectionPolicy =
          ServiceConnectionPolicy.newBuilder().build();
      String serviceConnectionPolicyId = "serviceConnectionPolicyId1586196096";
      client
          .createServiceConnectionPolicyAsync(
              parent, serviceConnectionPolicy, serviceConnectionPolicyId)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createServiceConnectionPolicyTest2() throws Exception {
    ServiceConnectionPolicy expectedResponse =
        ServiceConnectionPolicy.newBuilder()
            .setName(
                ServiceConnectionPolicyName.of(
                        "[PROJECT]", "[LOCATION]", "[SERVICE_CONNECTION_POLICY]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .setNetwork("network1843485230")
            .setServiceClass("serviceClass333962179")
            .setInfrastructure(Infrastructure.forNumber(0))
            .setPscConfig(ServiceConnectionPolicy.PscConfig.newBuilder().build())
            .addAllPscConnections(new ArrayList<ServiceConnectionPolicy.PscConnection>())
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createServiceConnectionPolicyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCrossNetworkAutomationService.addResponse(resultOperation);

    String parent = "parent-995424086";
    ServiceConnectionPolicy serviceConnectionPolicy = ServiceConnectionPolicy.newBuilder().build();
    String serviceConnectionPolicyId = "serviceConnectionPolicyId1586196096";

    ServiceConnectionPolicy actualResponse =
        client
            .createServiceConnectionPolicyAsync(
                parent, serviceConnectionPolicy, serviceConnectionPolicyId)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCrossNetworkAutomationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateServiceConnectionPolicyRequest actualRequest =
        ((CreateServiceConnectionPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(serviceConnectionPolicy, actualRequest.getServiceConnectionPolicy());
    Assert.assertEquals(serviceConnectionPolicyId, actualRequest.getServiceConnectionPolicyId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createServiceConnectionPolicyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCrossNetworkAutomationService.addException(exception);

    try {
      String parent = "parent-995424086";
      ServiceConnectionPolicy serviceConnectionPolicy =
          ServiceConnectionPolicy.newBuilder().build();
      String serviceConnectionPolicyId = "serviceConnectionPolicyId1586196096";
      client
          .createServiceConnectionPolicyAsync(
              parent, serviceConnectionPolicy, serviceConnectionPolicyId)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateServiceConnectionPolicyTest() throws Exception {
    ServiceConnectionPolicy expectedResponse =
        ServiceConnectionPolicy.newBuilder()
            .setName(
                ServiceConnectionPolicyName.of(
                        "[PROJECT]", "[LOCATION]", "[SERVICE_CONNECTION_POLICY]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .setNetwork("network1843485230")
            .setServiceClass("serviceClass333962179")
            .setInfrastructure(Infrastructure.forNumber(0))
            .setPscConfig(ServiceConnectionPolicy.PscConfig.newBuilder().build())
            .addAllPscConnections(new ArrayList<ServiceConnectionPolicy.PscConnection>())
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateServiceConnectionPolicyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCrossNetworkAutomationService.addResponse(resultOperation);

    ServiceConnectionPolicy serviceConnectionPolicy = ServiceConnectionPolicy.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    ServiceConnectionPolicy actualResponse =
        client.updateServiceConnectionPolicyAsync(serviceConnectionPolicy, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCrossNetworkAutomationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateServiceConnectionPolicyRequest actualRequest =
        ((UpdateServiceConnectionPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(serviceConnectionPolicy, actualRequest.getServiceConnectionPolicy());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateServiceConnectionPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCrossNetworkAutomationService.addException(exception);

    try {
      ServiceConnectionPolicy serviceConnectionPolicy =
          ServiceConnectionPolicy.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateServiceConnectionPolicyAsync(serviceConnectionPolicy, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteServiceConnectionPolicyTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteServiceConnectionPolicyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCrossNetworkAutomationService.addResponse(resultOperation);

    ServiceConnectionPolicyName name =
        ServiceConnectionPolicyName.of("[PROJECT]", "[LOCATION]", "[SERVICE_CONNECTION_POLICY]");

    client.deleteServiceConnectionPolicyAsync(name).get();

    List<AbstractMessage> actualRequests = mockCrossNetworkAutomationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteServiceConnectionPolicyRequest actualRequest =
        ((DeleteServiceConnectionPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteServiceConnectionPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCrossNetworkAutomationService.addException(exception);

    try {
      ServiceConnectionPolicyName name =
          ServiceConnectionPolicyName.of("[PROJECT]", "[LOCATION]", "[SERVICE_CONNECTION_POLICY]");
      client.deleteServiceConnectionPolicyAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteServiceConnectionPolicyTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteServiceConnectionPolicyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCrossNetworkAutomationService.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteServiceConnectionPolicyAsync(name).get();

    List<AbstractMessage> actualRequests = mockCrossNetworkAutomationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteServiceConnectionPolicyRequest actualRequest =
        ((DeleteServiceConnectionPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteServiceConnectionPolicyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCrossNetworkAutomationService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteServiceConnectionPolicyAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listServiceClassesTest() throws Exception {
    ServiceClass responsesElement = ServiceClass.newBuilder().build();
    ListServiceClassesResponse expectedResponse =
        ListServiceClassesResponse.newBuilder()
            .setNextPageToken("")
            .addAllServiceClasses(Arrays.asList(responsesElement))
            .build();
    mockCrossNetworkAutomationService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListServiceClassesPagedResponse pagedListResponse = client.listServiceClasses(parent);

    List<ServiceClass> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getServiceClassesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCrossNetworkAutomationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListServiceClassesRequest actualRequest = ((ListServiceClassesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listServiceClassesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCrossNetworkAutomationService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listServiceClasses(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listServiceClassesTest2() throws Exception {
    ServiceClass responsesElement = ServiceClass.newBuilder().build();
    ListServiceClassesResponse expectedResponse =
        ListServiceClassesResponse.newBuilder()
            .setNextPageToken("")
            .addAllServiceClasses(Arrays.asList(responsesElement))
            .build();
    mockCrossNetworkAutomationService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListServiceClassesPagedResponse pagedListResponse = client.listServiceClasses(parent);

    List<ServiceClass> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getServiceClassesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCrossNetworkAutomationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListServiceClassesRequest actualRequest = ((ListServiceClassesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listServiceClassesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCrossNetworkAutomationService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listServiceClasses(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getServiceClassTest() throws Exception {
    ServiceClass expectedResponse =
        ServiceClass.newBuilder()
            .setName(ServiceClassName.of("[PROJECT]", "[LOCATION]", "[SERVICE_CLASS]").toString())
            .setServiceClass("serviceClass333962179")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .setEtag("etag3123477")
            .build();
    mockCrossNetworkAutomationService.addResponse(expectedResponse);

    ServiceClassName name = ServiceClassName.of("[PROJECT]", "[LOCATION]", "[SERVICE_CLASS]");

    ServiceClass actualResponse = client.getServiceClass(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCrossNetworkAutomationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetServiceClassRequest actualRequest = ((GetServiceClassRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getServiceClassExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCrossNetworkAutomationService.addException(exception);

    try {
      ServiceClassName name = ServiceClassName.of("[PROJECT]", "[LOCATION]", "[SERVICE_CLASS]");
      client.getServiceClass(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getServiceClassTest2() throws Exception {
    ServiceClass expectedResponse =
        ServiceClass.newBuilder()
            .setName(ServiceClassName.of("[PROJECT]", "[LOCATION]", "[SERVICE_CLASS]").toString())
            .setServiceClass("serviceClass333962179")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .setEtag("etag3123477")
            .build();
    mockCrossNetworkAutomationService.addResponse(expectedResponse);

    String name = "name3373707";

    ServiceClass actualResponse = client.getServiceClass(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCrossNetworkAutomationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetServiceClassRequest actualRequest = ((GetServiceClassRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getServiceClassExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCrossNetworkAutomationService.addException(exception);

    try {
      String name = "name3373707";
      client.getServiceClass(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateServiceClassTest() throws Exception {
    ServiceClass expectedResponse =
        ServiceClass.newBuilder()
            .setName(ServiceClassName.of("[PROJECT]", "[LOCATION]", "[SERVICE_CLASS]").toString())
            .setServiceClass("serviceClass333962179")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateServiceClassTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCrossNetworkAutomationService.addResponse(resultOperation);

    ServiceClass serviceClass = ServiceClass.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    ServiceClass actualResponse = client.updateServiceClassAsync(serviceClass, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCrossNetworkAutomationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateServiceClassRequest actualRequest = ((UpdateServiceClassRequest) actualRequests.get(0));

    Assert.assertEquals(serviceClass, actualRequest.getServiceClass());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateServiceClassExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCrossNetworkAutomationService.addException(exception);

    try {
      ServiceClass serviceClass = ServiceClass.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateServiceClassAsync(serviceClass, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteServiceClassTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteServiceClassTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCrossNetworkAutomationService.addResponse(resultOperation);

    ServiceClassName name = ServiceClassName.of("[PROJECT]", "[LOCATION]", "[SERVICE_CLASS]");

    client.deleteServiceClassAsync(name).get();

    List<AbstractMessage> actualRequests = mockCrossNetworkAutomationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteServiceClassRequest actualRequest = ((DeleteServiceClassRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteServiceClassExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCrossNetworkAutomationService.addException(exception);

    try {
      ServiceClassName name = ServiceClassName.of("[PROJECT]", "[LOCATION]", "[SERVICE_CLASS]");
      client.deleteServiceClassAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteServiceClassTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteServiceClassTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCrossNetworkAutomationService.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteServiceClassAsync(name).get();

    List<AbstractMessage> actualRequests = mockCrossNetworkAutomationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteServiceClassRequest actualRequest = ((DeleteServiceClassRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteServiceClassExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCrossNetworkAutomationService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteServiceClassAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void getServiceConnectionTokenTest() throws Exception {
    ServiceConnectionToken expectedResponse =
        ServiceConnectionToken.newBuilder()
            .setName(
                ServiceConnectionTokenName.of(
                        "[PROJECT]", "[LOCATION]", "[SERVICE_CONNECTION_TOKEN]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .setNetwork("network1843485230")
            .setToken("token110541305")
            .setExpireTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    mockCrossNetworkAutomationService.addResponse(expectedResponse);

    ServiceConnectionTokenName name =
        ServiceConnectionTokenName.of("[PROJECT]", "[LOCATION]", "[SERVICE_CONNECTION_TOKEN]");

    ServiceConnectionToken actualResponse = client.getServiceConnectionToken(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCrossNetworkAutomationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetServiceConnectionTokenRequest actualRequest =
        ((GetServiceConnectionTokenRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getServiceConnectionTokenExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCrossNetworkAutomationService.addException(exception);

    try {
      ServiceConnectionTokenName name =
          ServiceConnectionTokenName.of("[PROJECT]", "[LOCATION]", "[SERVICE_CONNECTION_TOKEN]");
      client.getServiceConnectionToken(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getServiceConnectionTokenTest2() throws Exception {
    ServiceConnectionToken expectedResponse =
        ServiceConnectionToken.newBuilder()
            .setName(
                ServiceConnectionTokenName.of(
                        "[PROJECT]", "[LOCATION]", "[SERVICE_CONNECTION_TOKEN]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .setNetwork("network1843485230")
            .setToken("token110541305")
            .setExpireTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    mockCrossNetworkAutomationService.addResponse(expectedResponse);

    String name = "name3373707";

    ServiceConnectionToken actualResponse = client.getServiceConnectionToken(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCrossNetworkAutomationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetServiceConnectionTokenRequest actualRequest =
        ((GetServiceConnectionTokenRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getServiceConnectionTokenExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCrossNetworkAutomationService.addException(exception);

    try {
      String name = "name3373707";
      client.getServiceConnectionToken(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listServiceConnectionTokensTest() throws Exception {
    ServiceConnectionToken responsesElement = ServiceConnectionToken.newBuilder().build();
    ListServiceConnectionTokensResponse expectedResponse =
        ListServiceConnectionTokensResponse.newBuilder()
            .setNextPageToken("")
            .addAllServiceConnectionTokens(Arrays.asList(responsesElement))
            .build();
    mockCrossNetworkAutomationService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListServiceConnectionTokensPagedResponse pagedListResponse =
        client.listServiceConnectionTokens(parent);

    List<ServiceConnectionToken> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getServiceConnectionTokensList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCrossNetworkAutomationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListServiceConnectionTokensRequest actualRequest =
        ((ListServiceConnectionTokensRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listServiceConnectionTokensExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCrossNetworkAutomationService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listServiceConnectionTokens(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listServiceConnectionTokensTest2() throws Exception {
    ServiceConnectionToken responsesElement = ServiceConnectionToken.newBuilder().build();
    ListServiceConnectionTokensResponse expectedResponse =
        ListServiceConnectionTokensResponse.newBuilder()
            .setNextPageToken("")
            .addAllServiceConnectionTokens(Arrays.asList(responsesElement))
            .build();
    mockCrossNetworkAutomationService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListServiceConnectionTokensPagedResponse pagedListResponse =
        client.listServiceConnectionTokens(parent);

    List<ServiceConnectionToken> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getServiceConnectionTokensList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCrossNetworkAutomationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListServiceConnectionTokensRequest actualRequest =
        ((ListServiceConnectionTokensRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listServiceConnectionTokensExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCrossNetworkAutomationService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listServiceConnectionTokens(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createServiceConnectionTokenTest() throws Exception {
    ServiceConnectionToken expectedResponse =
        ServiceConnectionToken.newBuilder()
            .setName(
                ServiceConnectionTokenName.of(
                        "[PROJECT]", "[LOCATION]", "[SERVICE_CONNECTION_TOKEN]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .setNetwork("network1843485230")
            .setToken("token110541305")
            .setExpireTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createServiceConnectionTokenTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCrossNetworkAutomationService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    ServiceConnectionToken serviceConnectionToken = ServiceConnectionToken.newBuilder().build();
    String serviceConnectionTokenId = "serviceConnectionTokenId-1526102527";

    ServiceConnectionToken actualResponse =
        client
            .createServiceConnectionTokenAsync(
                parent, serviceConnectionToken, serviceConnectionTokenId)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCrossNetworkAutomationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateServiceConnectionTokenRequest actualRequest =
        ((CreateServiceConnectionTokenRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(serviceConnectionToken, actualRequest.getServiceConnectionToken());
    Assert.assertEquals(serviceConnectionTokenId, actualRequest.getServiceConnectionTokenId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createServiceConnectionTokenExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCrossNetworkAutomationService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      ServiceConnectionToken serviceConnectionToken = ServiceConnectionToken.newBuilder().build();
      String serviceConnectionTokenId = "serviceConnectionTokenId-1526102527";
      client
          .createServiceConnectionTokenAsync(
              parent, serviceConnectionToken, serviceConnectionTokenId)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createServiceConnectionTokenTest2() throws Exception {
    ServiceConnectionToken expectedResponse =
        ServiceConnectionToken.newBuilder()
            .setName(
                ServiceConnectionTokenName.of(
                        "[PROJECT]", "[LOCATION]", "[SERVICE_CONNECTION_TOKEN]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .setNetwork("network1843485230")
            .setToken("token110541305")
            .setExpireTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createServiceConnectionTokenTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCrossNetworkAutomationService.addResponse(resultOperation);

    String parent = "parent-995424086";
    ServiceConnectionToken serviceConnectionToken = ServiceConnectionToken.newBuilder().build();
    String serviceConnectionTokenId = "serviceConnectionTokenId-1526102527";

    ServiceConnectionToken actualResponse =
        client
            .createServiceConnectionTokenAsync(
                parent, serviceConnectionToken, serviceConnectionTokenId)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCrossNetworkAutomationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateServiceConnectionTokenRequest actualRequest =
        ((CreateServiceConnectionTokenRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(serviceConnectionToken, actualRequest.getServiceConnectionToken());
    Assert.assertEquals(serviceConnectionTokenId, actualRequest.getServiceConnectionTokenId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createServiceConnectionTokenExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCrossNetworkAutomationService.addException(exception);

    try {
      String parent = "parent-995424086";
      ServiceConnectionToken serviceConnectionToken = ServiceConnectionToken.newBuilder().build();
      String serviceConnectionTokenId = "serviceConnectionTokenId-1526102527";
      client
          .createServiceConnectionTokenAsync(
              parent, serviceConnectionToken, serviceConnectionTokenId)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteServiceConnectionTokenTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteServiceConnectionTokenTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCrossNetworkAutomationService.addResponse(resultOperation);

    ServiceConnectionTokenName name =
        ServiceConnectionTokenName.of("[PROJECT]", "[LOCATION]", "[SERVICE_CONNECTION_TOKEN]");

    client.deleteServiceConnectionTokenAsync(name).get();

    List<AbstractMessage> actualRequests = mockCrossNetworkAutomationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteServiceConnectionTokenRequest actualRequest =
        ((DeleteServiceConnectionTokenRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteServiceConnectionTokenExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCrossNetworkAutomationService.addException(exception);

    try {
      ServiceConnectionTokenName name =
          ServiceConnectionTokenName.of("[PROJECT]", "[LOCATION]", "[SERVICE_CONNECTION_TOKEN]");
      client.deleteServiceConnectionTokenAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteServiceConnectionTokenTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteServiceConnectionTokenTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCrossNetworkAutomationService.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteServiceConnectionTokenAsync(name).get();

    List<AbstractMessage> actualRequests = mockCrossNetworkAutomationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteServiceConnectionTokenRequest actualRequest =
        ((DeleteServiceConnectionTokenRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteServiceConnectionTokenExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCrossNetworkAutomationService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteServiceConnectionTokenAsync(name).get();
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
            .setResource(GroupName.of("[PROJECT]", "[HUB]", "[GROUP]").toString())
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
              .setResource(GroupName.of("[PROJECT]", "[HUB]", "[GROUP]").toString())
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
            .setResource(GroupName.of("[PROJECT]", "[HUB]", "[GROUP]").toString())
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
              .setResource(GroupName.of("[PROJECT]", "[HUB]", "[GROUP]").toString())
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
            .setResource(GroupName.of("[PROJECT]", "[HUB]", "[GROUP]").toString())
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
              .setResource(GroupName.of("[PROJECT]", "[HUB]", "[GROUP]").toString())
              .addAllPermissions(new ArrayList<String>())
              .build();
      client.testIamPermissions(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
