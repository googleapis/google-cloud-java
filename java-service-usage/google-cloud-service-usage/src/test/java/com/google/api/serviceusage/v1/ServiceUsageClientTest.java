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

package com.google.api.serviceusage.v1;

import static com.google.api.serviceusage.v1.ServiceUsageClient.ListServicesPagedResponse;

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
public class ServiceUsageClientTest {
  private static MockServiceHelper mockServiceHelper;
  private static MockServiceUsage mockServiceUsage;
  private LocalChannelProvider channelProvider;
  private ServiceUsageClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockServiceUsage = new MockServiceUsage();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockServiceUsage));
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
    ServiceUsageSettings settings =
        ServiceUsageSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ServiceUsageClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void enableServiceTest() throws Exception {
    EnableServiceResponse expectedResponse =
        EnableServiceResponse.newBuilder().setService(Service.newBuilder().build()).build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("enableServiceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockServiceUsage.addResponse(resultOperation);

    EnableServiceRequest request = EnableServiceRequest.newBuilder().setName("name3373707").build();

    EnableServiceResponse actualResponse = client.enableServiceAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockServiceUsage.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    EnableServiceRequest actualRequest = ((EnableServiceRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void enableServiceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockServiceUsage.addException(exception);

    try {
      EnableServiceRequest request =
          EnableServiceRequest.newBuilder().setName("name3373707").build();
      client.enableServiceAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void disableServiceTest() throws Exception {
    DisableServiceResponse expectedResponse =
        DisableServiceResponse.newBuilder().setService(Service.newBuilder().build()).build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("disableServiceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockServiceUsage.addResponse(resultOperation);

    DisableServiceRequest request =
        DisableServiceRequest.newBuilder()
            .setName("name3373707")
            .setDisableDependentServices(true)
            .build();

    DisableServiceResponse actualResponse = client.disableServiceAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockServiceUsage.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DisableServiceRequest actualRequest = ((DisableServiceRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(
        request.getDisableDependentServices(), actualRequest.getDisableDependentServices());
    Assert.assertEquals(
        request.getCheckIfServiceHasUsage(), actualRequest.getCheckIfServiceHasUsage());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void disableServiceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockServiceUsage.addException(exception);

    try {
      DisableServiceRequest request =
          DisableServiceRequest.newBuilder()
              .setName("name3373707")
              .setDisableDependentServices(true)
              .build();
      client.disableServiceAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void getServiceTest() throws Exception {
    Service expectedResponse =
        Service.newBuilder()
            .setName("name3373707")
            .setParent("parent-995424086")
            .setConfig(ServiceConfig.newBuilder().build())
            .setState(State.forNumber(0))
            .build();
    mockServiceUsage.addResponse(expectedResponse);

    GetServiceRequest request = GetServiceRequest.newBuilder().setName("name3373707").build();

    Service actualResponse = client.getService(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockServiceUsage.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetServiceRequest actualRequest = ((GetServiceRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getServiceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockServiceUsage.addException(exception);

    try {
      GetServiceRequest request = GetServiceRequest.newBuilder().setName("name3373707").build();
      client.getService(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listServicesTest() throws Exception {
    Service responsesElement = Service.newBuilder().build();
    ListServicesResponse expectedResponse =
        ListServicesResponse.newBuilder()
            .setNextPageToken("")
            .addAllServices(Arrays.asList(responsesElement))
            .build();
    mockServiceUsage.addResponse(expectedResponse);

    ListServicesRequest request =
        ListServicesRequest.newBuilder()
            .setParent("parent-995424086")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .setFilter("filter-1274492040")
            .build();

    ListServicesPagedResponse pagedListResponse = client.listServices(request);

    List<Service> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getServicesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockServiceUsage.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListServicesRequest actualRequest = ((ListServicesRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertEquals(request.getFilter(), actualRequest.getFilter());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listServicesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockServiceUsage.addException(exception);

    try {
      ListServicesRequest request =
          ListServicesRequest.newBuilder()
              .setParent("parent-995424086")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setFilter("filter-1274492040")
              .build();
      client.listServices(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchEnableServicesTest() throws Exception {
    BatchEnableServicesResponse expectedResponse =
        BatchEnableServicesResponse.newBuilder()
            .addAllServices(new ArrayList<Service>())
            .addAllFailures(new ArrayList<BatchEnableServicesResponse.EnableFailure>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("batchEnableServicesTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockServiceUsage.addResponse(resultOperation);

    BatchEnableServicesRequest request =
        BatchEnableServicesRequest.newBuilder()
            .setParent("parent-995424086")
            .addAllServiceIds(new ArrayList<String>())
            .build();

    BatchEnableServicesResponse actualResponse = client.batchEnableServicesAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockServiceUsage.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchEnableServicesRequest actualRequest = ((BatchEnableServicesRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getServiceIdsList(), actualRequest.getServiceIdsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void batchEnableServicesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockServiceUsage.addException(exception);

    try {
      BatchEnableServicesRequest request =
          BatchEnableServicesRequest.newBuilder()
              .setParent("parent-995424086")
              .addAllServiceIds(new ArrayList<String>())
              .build();
      client.batchEnableServicesAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void batchGetServicesTest() throws Exception {
    BatchGetServicesResponse expectedResponse =
        BatchGetServicesResponse.newBuilder().addAllServices(new ArrayList<Service>()).build();
    mockServiceUsage.addResponse(expectedResponse);

    BatchGetServicesRequest request =
        BatchGetServicesRequest.newBuilder()
            .setParent("parent-995424086")
            .addAllNames(new ArrayList<String>())
            .build();

    BatchGetServicesResponse actualResponse = client.batchGetServices(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockServiceUsage.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchGetServicesRequest actualRequest = ((BatchGetServicesRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getNamesList(), actualRequest.getNamesList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void batchGetServicesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockServiceUsage.addException(exception);

    try {
      BatchGetServicesRequest request =
          BatchGetServicesRequest.newBuilder()
              .setParent("parent-995424086")
              .addAllNames(new ArrayList<String>())
              .build();
      client.batchGetServices(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
