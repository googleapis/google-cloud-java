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

package com.google.api.serviceusage.v1beta1;

import static com.google.api.serviceusage.v1beta1.ServiceUsageClient.ListAdminOverridesPagedResponse;
import static com.google.api.serviceusage.v1beta1.ServiceUsageClient.ListConsumerOverridesPagedResponse;
import static com.google.api.serviceusage.v1beta1.ServiceUsageClient.ListConsumerQuotaMetricsPagedResponse;
import static com.google.api.serviceusage.v1beta1.ServiceUsageClient.ListServicesPagedResponse;

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
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("enableServiceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockServiceUsage.addResponse(resultOperation);

    EnableServiceRequest request = EnableServiceRequest.newBuilder().setName("name3373707").build();

    client.enableServiceAsync(request).get();

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
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("disableServiceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockServiceUsage.addResponse(resultOperation);

    DisableServiceRequest request =
        DisableServiceRequest.newBuilder().setName("name3373707").build();

    client.disableServiceAsync(request).get();

    List<AbstractMessage> actualRequests = mockServiceUsage.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DisableServiceRequest actualRequest = ((DisableServiceRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
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
          DisableServiceRequest.newBuilder().setName("name3373707").build();
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
    Empty expectedResponse = Empty.newBuilder().build();
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

    client.batchEnableServicesAsync(request).get();

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
  public void listConsumerQuotaMetricsTest() throws Exception {
    ConsumerQuotaMetric responsesElement = ConsumerQuotaMetric.newBuilder().build();
    ListConsumerQuotaMetricsResponse expectedResponse =
        ListConsumerQuotaMetricsResponse.newBuilder()
            .setNextPageToken("")
            .addAllMetrics(Arrays.asList(responsesElement))
            .build();
    mockServiceUsage.addResponse(expectedResponse);

    ListConsumerQuotaMetricsRequest request =
        ListConsumerQuotaMetricsRequest.newBuilder()
            .setParent("parent-995424086")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .setView(QuotaView.forNumber(0))
            .build();

    ListConsumerQuotaMetricsPagedResponse pagedListResponse =
        client.listConsumerQuotaMetrics(request);

    List<ConsumerQuotaMetric> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMetricsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockServiceUsage.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListConsumerQuotaMetricsRequest actualRequest =
        ((ListConsumerQuotaMetricsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertEquals(request.getView(), actualRequest.getView());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listConsumerQuotaMetricsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockServiceUsage.addException(exception);

    try {
      ListConsumerQuotaMetricsRequest request =
          ListConsumerQuotaMetricsRequest.newBuilder()
              .setParent("parent-995424086")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setView(QuotaView.forNumber(0))
              .build();
      client.listConsumerQuotaMetrics(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getConsumerQuotaMetricTest() throws Exception {
    ConsumerQuotaMetric expectedResponse =
        ConsumerQuotaMetric.newBuilder()
            .setName("name3373707")
            .setMetric("metric-1077545552")
            .setDisplayName("displayName1714148973")
            .addAllConsumerQuotaLimits(new ArrayList<ConsumerQuotaLimit>())
            .addAllDescendantConsumerQuotaLimits(new ArrayList<ConsumerQuotaLimit>())
            .setUnit("unit3594628")
            .build();
    mockServiceUsage.addResponse(expectedResponse);

    GetConsumerQuotaMetricRequest request =
        GetConsumerQuotaMetricRequest.newBuilder()
            .setName("name3373707")
            .setView(QuotaView.forNumber(0))
            .build();

    ConsumerQuotaMetric actualResponse = client.getConsumerQuotaMetric(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockServiceUsage.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetConsumerQuotaMetricRequest actualRequest =
        ((GetConsumerQuotaMetricRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getView(), actualRequest.getView());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getConsumerQuotaMetricExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockServiceUsage.addException(exception);

    try {
      GetConsumerQuotaMetricRequest request =
          GetConsumerQuotaMetricRequest.newBuilder()
              .setName("name3373707")
              .setView(QuotaView.forNumber(0))
              .build();
      client.getConsumerQuotaMetric(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getConsumerQuotaLimitTest() throws Exception {
    ConsumerQuotaLimit expectedResponse =
        ConsumerQuotaLimit.newBuilder()
            .setName("name3373707")
            .setMetric("metric-1077545552")
            .setUnit("unit3594628")
            .setIsPrecise(true)
            .setAllowsAdminOverrides(true)
            .addAllQuotaBuckets(new ArrayList<QuotaBucket>())
            .build();
    mockServiceUsage.addResponse(expectedResponse);

    GetConsumerQuotaLimitRequest request =
        GetConsumerQuotaLimitRequest.newBuilder()
            .setName("name3373707")
            .setView(QuotaView.forNumber(0))
            .build();

    ConsumerQuotaLimit actualResponse = client.getConsumerQuotaLimit(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockServiceUsage.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetConsumerQuotaLimitRequest actualRequest =
        ((GetConsumerQuotaLimitRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getView(), actualRequest.getView());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getConsumerQuotaLimitExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockServiceUsage.addException(exception);

    try {
      GetConsumerQuotaLimitRequest request =
          GetConsumerQuotaLimitRequest.newBuilder()
              .setName("name3373707")
              .setView(QuotaView.forNumber(0))
              .build();
      client.getConsumerQuotaLimit(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createAdminOverrideTest() throws Exception {
    QuotaOverride expectedResponse =
        QuotaOverride.newBuilder()
            .setName("name3373707")
            .setOverrideValue(-355006658)
            .putAllDimensions(new HashMap<String, String>())
            .setMetric("metric-1077545552")
            .setUnit("unit3594628")
            .setAdminOverrideAncestor("adminOverrideAncestor-1443674322")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createAdminOverrideTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockServiceUsage.addResponse(resultOperation);

    CreateAdminOverrideRequest request =
        CreateAdminOverrideRequest.newBuilder()
            .setParent("parent-995424086")
            .setOverride(QuotaOverride.newBuilder().build())
            .setForce(true)
            .addAllForceOnly(new ArrayList<QuotaSafetyCheck>())
            .build();

    QuotaOverride actualResponse = client.createAdminOverrideAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockServiceUsage.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateAdminOverrideRequest actualRequest = ((CreateAdminOverrideRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getOverride(), actualRequest.getOverride());
    Assert.assertEquals(request.getForce(), actualRequest.getForce());
    Assert.assertEquals(request.getForceOnlyList(), actualRequest.getForceOnlyList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createAdminOverrideExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockServiceUsage.addException(exception);

    try {
      CreateAdminOverrideRequest request =
          CreateAdminOverrideRequest.newBuilder()
              .setParent("parent-995424086")
              .setOverride(QuotaOverride.newBuilder().build())
              .setForce(true)
              .addAllForceOnly(new ArrayList<QuotaSafetyCheck>())
              .build();
      client.createAdminOverrideAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateAdminOverrideTest() throws Exception {
    QuotaOverride expectedResponse =
        QuotaOverride.newBuilder()
            .setName("name3373707")
            .setOverrideValue(-355006658)
            .putAllDimensions(new HashMap<String, String>())
            .setMetric("metric-1077545552")
            .setUnit("unit3594628")
            .setAdminOverrideAncestor("adminOverrideAncestor-1443674322")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateAdminOverrideTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockServiceUsage.addResponse(resultOperation);

    UpdateAdminOverrideRequest request =
        UpdateAdminOverrideRequest.newBuilder()
            .setName("name3373707")
            .setOverride(QuotaOverride.newBuilder().build())
            .setForce(true)
            .setUpdateMask(FieldMask.newBuilder().build())
            .addAllForceOnly(new ArrayList<QuotaSafetyCheck>())
            .build();

    QuotaOverride actualResponse = client.updateAdminOverrideAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockServiceUsage.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateAdminOverrideRequest actualRequest = ((UpdateAdminOverrideRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getOverride(), actualRequest.getOverride());
    Assert.assertEquals(request.getForce(), actualRequest.getForce());
    Assert.assertEquals(request.getUpdateMask(), actualRequest.getUpdateMask());
    Assert.assertEquals(request.getForceOnlyList(), actualRequest.getForceOnlyList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateAdminOverrideExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockServiceUsage.addException(exception);

    try {
      UpdateAdminOverrideRequest request =
          UpdateAdminOverrideRequest.newBuilder()
              .setName("name3373707")
              .setOverride(QuotaOverride.newBuilder().build())
              .setForce(true)
              .setUpdateMask(FieldMask.newBuilder().build())
              .addAllForceOnly(new ArrayList<QuotaSafetyCheck>())
              .build();
      client.updateAdminOverrideAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteAdminOverrideTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteAdminOverrideTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockServiceUsage.addResponse(resultOperation);

    DeleteAdminOverrideRequest request =
        DeleteAdminOverrideRequest.newBuilder()
            .setName("name3373707")
            .setForce(true)
            .addAllForceOnly(new ArrayList<QuotaSafetyCheck>())
            .build();

    client.deleteAdminOverrideAsync(request).get();

    List<AbstractMessage> actualRequests = mockServiceUsage.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteAdminOverrideRequest actualRequest = ((DeleteAdminOverrideRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getForce(), actualRequest.getForce());
    Assert.assertEquals(request.getForceOnlyList(), actualRequest.getForceOnlyList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteAdminOverrideExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockServiceUsage.addException(exception);

    try {
      DeleteAdminOverrideRequest request =
          DeleteAdminOverrideRequest.newBuilder()
              .setName("name3373707")
              .setForce(true)
              .addAllForceOnly(new ArrayList<QuotaSafetyCheck>())
              .build();
      client.deleteAdminOverrideAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listAdminOverridesTest() throws Exception {
    QuotaOverride responsesElement = QuotaOverride.newBuilder().build();
    ListAdminOverridesResponse expectedResponse =
        ListAdminOverridesResponse.newBuilder()
            .setNextPageToken("")
            .addAllOverrides(Arrays.asList(responsesElement))
            .build();
    mockServiceUsage.addResponse(expectedResponse);

    ListAdminOverridesRequest request =
        ListAdminOverridesRequest.newBuilder()
            .setParent("parent-995424086")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    ListAdminOverridesPagedResponse pagedListResponse = client.listAdminOverrides(request);

    List<QuotaOverride> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getOverridesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockServiceUsage.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAdminOverridesRequest actualRequest = ((ListAdminOverridesRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAdminOverridesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockServiceUsage.addException(exception);

    try {
      ListAdminOverridesRequest request =
          ListAdminOverridesRequest.newBuilder()
              .setParent("parent-995424086")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      client.listAdminOverrides(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void importAdminOverridesTest() throws Exception {
    ImportAdminOverridesResponse expectedResponse =
        ImportAdminOverridesResponse.newBuilder()
            .addAllOverrides(new ArrayList<QuotaOverride>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("importAdminOverridesTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockServiceUsage.addResponse(resultOperation);

    ImportAdminOverridesRequest request =
        ImportAdminOverridesRequest.newBuilder()
            .setParent("parent-995424086")
            .setForce(true)
            .addAllForceOnly(new ArrayList<QuotaSafetyCheck>())
            .build();

    ImportAdminOverridesResponse actualResponse = client.importAdminOverridesAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockServiceUsage.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ImportAdminOverridesRequest actualRequest =
        ((ImportAdminOverridesRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getInlineSource(), actualRequest.getInlineSource());
    Assert.assertEquals(request.getForce(), actualRequest.getForce());
    Assert.assertEquals(request.getForceOnlyList(), actualRequest.getForceOnlyList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void importAdminOverridesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockServiceUsage.addException(exception);

    try {
      ImportAdminOverridesRequest request =
          ImportAdminOverridesRequest.newBuilder()
              .setParent("parent-995424086")
              .setForce(true)
              .addAllForceOnly(new ArrayList<QuotaSafetyCheck>())
              .build();
      client.importAdminOverridesAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createConsumerOverrideTest() throws Exception {
    QuotaOverride expectedResponse =
        QuotaOverride.newBuilder()
            .setName("name3373707")
            .setOverrideValue(-355006658)
            .putAllDimensions(new HashMap<String, String>())
            .setMetric("metric-1077545552")
            .setUnit("unit3594628")
            .setAdminOverrideAncestor("adminOverrideAncestor-1443674322")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createConsumerOverrideTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockServiceUsage.addResponse(resultOperation);

    CreateConsumerOverrideRequest request =
        CreateConsumerOverrideRequest.newBuilder()
            .setParent("parent-995424086")
            .setOverride(QuotaOverride.newBuilder().build())
            .setForce(true)
            .addAllForceOnly(new ArrayList<QuotaSafetyCheck>())
            .build();

    QuotaOverride actualResponse = client.createConsumerOverrideAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockServiceUsage.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateConsumerOverrideRequest actualRequest =
        ((CreateConsumerOverrideRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getOverride(), actualRequest.getOverride());
    Assert.assertEquals(request.getForce(), actualRequest.getForce());
    Assert.assertEquals(request.getForceOnlyList(), actualRequest.getForceOnlyList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createConsumerOverrideExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockServiceUsage.addException(exception);

    try {
      CreateConsumerOverrideRequest request =
          CreateConsumerOverrideRequest.newBuilder()
              .setParent("parent-995424086")
              .setOverride(QuotaOverride.newBuilder().build())
              .setForce(true)
              .addAllForceOnly(new ArrayList<QuotaSafetyCheck>())
              .build();
      client.createConsumerOverrideAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateConsumerOverrideTest() throws Exception {
    QuotaOverride expectedResponse =
        QuotaOverride.newBuilder()
            .setName("name3373707")
            .setOverrideValue(-355006658)
            .putAllDimensions(new HashMap<String, String>())
            .setMetric("metric-1077545552")
            .setUnit("unit3594628")
            .setAdminOverrideAncestor("adminOverrideAncestor-1443674322")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateConsumerOverrideTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockServiceUsage.addResponse(resultOperation);

    UpdateConsumerOverrideRequest request =
        UpdateConsumerOverrideRequest.newBuilder()
            .setName("name3373707")
            .setOverride(QuotaOverride.newBuilder().build())
            .setForce(true)
            .setUpdateMask(FieldMask.newBuilder().build())
            .addAllForceOnly(new ArrayList<QuotaSafetyCheck>())
            .build();

    QuotaOverride actualResponse = client.updateConsumerOverrideAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockServiceUsage.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateConsumerOverrideRequest actualRequest =
        ((UpdateConsumerOverrideRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getOverride(), actualRequest.getOverride());
    Assert.assertEquals(request.getForce(), actualRequest.getForce());
    Assert.assertEquals(request.getUpdateMask(), actualRequest.getUpdateMask());
    Assert.assertEquals(request.getForceOnlyList(), actualRequest.getForceOnlyList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateConsumerOverrideExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockServiceUsage.addException(exception);

    try {
      UpdateConsumerOverrideRequest request =
          UpdateConsumerOverrideRequest.newBuilder()
              .setName("name3373707")
              .setOverride(QuotaOverride.newBuilder().build())
              .setForce(true)
              .setUpdateMask(FieldMask.newBuilder().build())
              .addAllForceOnly(new ArrayList<QuotaSafetyCheck>())
              .build();
      client.updateConsumerOverrideAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteConsumerOverrideTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteConsumerOverrideTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockServiceUsage.addResponse(resultOperation);

    DeleteConsumerOverrideRequest request =
        DeleteConsumerOverrideRequest.newBuilder()
            .setName("name3373707")
            .setForce(true)
            .addAllForceOnly(new ArrayList<QuotaSafetyCheck>())
            .build();

    client.deleteConsumerOverrideAsync(request).get();

    List<AbstractMessage> actualRequests = mockServiceUsage.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteConsumerOverrideRequest actualRequest =
        ((DeleteConsumerOverrideRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getForce(), actualRequest.getForce());
    Assert.assertEquals(request.getForceOnlyList(), actualRequest.getForceOnlyList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteConsumerOverrideExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockServiceUsage.addException(exception);

    try {
      DeleteConsumerOverrideRequest request =
          DeleteConsumerOverrideRequest.newBuilder()
              .setName("name3373707")
              .setForce(true)
              .addAllForceOnly(new ArrayList<QuotaSafetyCheck>())
              .build();
      client.deleteConsumerOverrideAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listConsumerOverridesTest() throws Exception {
    QuotaOverride responsesElement = QuotaOverride.newBuilder().build();
    ListConsumerOverridesResponse expectedResponse =
        ListConsumerOverridesResponse.newBuilder()
            .setNextPageToken("")
            .addAllOverrides(Arrays.asList(responsesElement))
            .build();
    mockServiceUsage.addResponse(expectedResponse);

    ListConsumerOverridesRequest request =
        ListConsumerOverridesRequest.newBuilder()
            .setParent("parent-995424086")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    ListConsumerOverridesPagedResponse pagedListResponse = client.listConsumerOverrides(request);

    List<QuotaOverride> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getOverridesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockServiceUsage.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListConsumerOverridesRequest actualRequest =
        ((ListConsumerOverridesRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listConsumerOverridesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockServiceUsage.addException(exception);

    try {
      ListConsumerOverridesRequest request =
          ListConsumerOverridesRequest.newBuilder()
              .setParent("parent-995424086")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      client.listConsumerOverrides(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void importConsumerOverridesTest() throws Exception {
    ImportConsumerOverridesResponse expectedResponse =
        ImportConsumerOverridesResponse.newBuilder()
            .addAllOverrides(new ArrayList<QuotaOverride>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("importConsumerOverridesTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockServiceUsage.addResponse(resultOperation);

    ImportConsumerOverridesRequest request =
        ImportConsumerOverridesRequest.newBuilder()
            .setParent("parent-995424086")
            .setForce(true)
            .addAllForceOnly(new ArrayList<QuotaSafetyCheck>())
            .build();

    ImportConsumerOverridesResponse actualResponse =
        client.importConsumerOverridesAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockServiceUsage.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ImportConsumerOverridesRequest actualRequest =
        ((ImportConsumerOverridesRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getInlineSource(), actualRequest.getInlineSource());
    Assert.assertEquals(request.getForce(), actualRequest.getForce());
    Assert.assertEquals(request.getForceOnlyList(), actualRequest.getForceOnlyList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void importConsumerOverridesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockServiceUsage.addException(exception);

    try {
      ImportConsumerOverridesRequest request =
          ImportConsumerOverridesRequest.newBuilder()
              .setParent("parent-995424086")
              .setForce(true)
              .addAllForceOnly(new ArrayList<QuotaSafetyCheck>())
              .build();
      client.importConsumerOverridesAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void generateServiceIdentityTest() throws Exception {
    ServiceIdentity expectedResponse =
        ServiceIdentity.newBuilder()
            .setEmail("email96619420")
            .setUniqueId("uniqueId-294460212")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("generateServiceIdentityTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockServiceUsage.addResponse(resultOperation);

    GenerateServiceIdentityRequest request =
        GenerateServiceIdentityRequest.newBuilder().setParent("parent-995424086").build();

    ServiceIdentity actualResponse = client.generateServiceIdentityAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockServiceUsage.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GenerateServiceIdentityRequest actualRequest =
        ((GenerateServiceIdentityRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void generateServiceIdentityExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockServiceUsage.addException(exception);

    try {
      GenerateServiceIdentityRequest request =
          GenerateServiceIdentityRequest.newBuilder().setParent("parent-995424086").build();
      client.generateServiceIdentityAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }
}
