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
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.api.serviceusage.v1beta1.stub.HttpJsonServiceUsageStub;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class ServiceUsageClientHttpJsonTest {
  private static MockHttpService mockService;
  private static ServiceUsageClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonServiceUsageStub.getMethodDescriptors(),
            ServiceUsageSettings.getDefaultEndpoint());
    ServiceUsageSettings settings =
        ServiceUsageSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                ServiceUsageSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ServiceUsageClient.create(settings);
  }

  @AfterClass
  public static void stopServer() {
    client.close();
  }

  @Before
  public void setUp() {}

  @After
  public void tearDown() throws Exception {
    mockService.reset();
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
    mockService.addResponse(resultOperation);

    EnableServiceRequest request =
        EnableServiceRequest.newBuilder()
            .setName("name-7410/name-7410/services/service-7410")
            .build();

    client.enableServiceAsync(request).get();

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void enableServiceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      EnableServiceRequest request =
          EnableServiceRequest.newBuilder()
              .setName("name-7410/name-7410/services/service-7410")
              .build();
      client.enableServiceAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    DisableServiceRequest request =
        DisableServiceRequest.newBuilder()
            .setName("name-7410/name-7410/services/service-7410")
            .build();

    client.disableServiceAsync(request).get();

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void disableServiceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DisableServiceRequest request =
          DisableServiceRequest.newBuilder()
              .setName("name-7410/name-7410/services/service-7410")
              .build();
      client.disableServiceAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(expectedResponse);

    GetServiceRequest request =
        GetServiceRequest.newBuilder().setName("name-7410/name-7410/services/service-7410").build();

    Service actualResponse = client.getService(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getServiceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GetServiceRequest request =
          GetServiceRequest.newBuilder()
              .setName("name-7410/name-7410/services/service-7410")
              .build();
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
    mockService.addResponse(expectedResponse);

    ListServicesRequest request =
        ListServicesRequest.newBuilder()
            .setParent("parent-4715/parent-4715")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .setFilter("filter-1274492040")
            .build();

    ListServicesPagedResponse pagedListResponse = client.listServices(request);

    List<Service> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getServicesList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listServicesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ListServicesRequest request =
          ListServicesRequest.newBuilder()
              .setParent("parent-4715/parent-4715")
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
    mockService.addResponse(resultOperation);

    BatchEnableServicesRequest request =
        BatchEnableServicesRequest.newBuilder()
            .setParent("parent-4715/parent-4715")
            .addAllServiceIds(new ArrayList<String>())
            .build();

    client.batchEnableServicesAsync(request).get();

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void batchEnableServicesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      BatchEnableServicesRequest request =
          BatchEnableServicesRequest.newBuilder()
              .setParent("parent-4715/parent-4715")
              .addAllServiceIds(new ArrayList<String>())
              .build();
      client.batchEnableServicesAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(expectedResponse);

    ListConsumerQuotaMetricsRequest request =
        ListConsumerQuotaMetricsRequest.newBuilder()
            .setParent("parent-2637/parent-2637/services/service-2637")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .setView(QuotaView.forNumber(0))
            .build();

    ListConsumerQuotaMetricsPagedResponse pagedListResponse =
        client.listConsumerQuotaMetrics(request);

    List<ConsumerQuotaMetric> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMetricsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listConsumerQuotaMetricsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ListConsumerQuotaMetricsRequest request =
          ListConsumerQuotaMetricsRequest.newBuilder()
              .setParent("parent-2637/parent-2637/services/service-2637")
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
    mockService.addResponse(expectedResponse);

    GetConsumerQuotaMetricRequest request =
        GetConsumerQuotaMetricRequest.newBuilder()
            .setName(
                "name-5949/name-5949/services/service-5949/consumerQuotaMetrics/consumerQuotaMetric-5949")
            .setView(QuotaView.forNumber(0))
            .build();

    ConsumerQuotaMetric actualResponse = client.getConsumerQuotaMetric(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getConsumerQuotaMetricExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GetConsumerQuotaMetricRequest request =
          GetConsumerQuotaMetricRequest.newBuilder()
              .setName(
                  "name-5949/name-5949/services/service-5949/consumerQuotaMetrics/consumerQuotaMetric-5949")
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
    mockService.addResponse(expectedResponse);

    GetConsumerQuotaLimitRequest request =
        GetConsumerQuotaLimitRequest.newBuilder()
            .setName(
                "name-6379/name-6379/services/service-6379/consumerQuotaMetrics/consumerQuotaMetric-6379/limits/limit-6379")
            .setView(QuotaView.forNumber(0))
            .build();

    ConsumerQuotaLimit actualResponse = client.getConsumerQuotaLimit(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getConsumerQuotaLimitExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GetConsumerQuotaLimitRequest request =
          GetConsumerQuotaLimitRequest.newBuilder()
              .setName(
                  "name-6379/name-6379/services/service-6379/consumerQuotaMetrics/consumerQuotaMetric-6379/limits/limit-6379")
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
    mockService.addResponse(resultOperation);

    CreateAdminOverrideRequest request =
        CreateAdminOverrideRequest.newBuilder()
            .setParent(
                "parent-8356/parent-8356/services/service-8356/consumerQuotaMetrics/consumerQuotaMetric-8356/limits/limit-8356")
            .setOverride(QuotaOverride.newBuilder().build())
            .setForce(true)
            .addAllForceOnly(new ArrayList<QuotaSafetyCheck>())
            .build();

    QuotaOverride actualResponse = client.createAdminOverrideAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createAdminOverrideExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CreateAdminOverrideRequest request =
          CreateAdminOverrideRequest.newBuilder()
              .setParent(
                  "parent-8356/parent-8356/services/service-8356/consumerQuotaMetrics/consumerQuotaMetric-8356/limits/limit-8356")
              .setOverride(QuotaOverride.newBuilder().build())
              .setForce(true)
              .addAllForceOnly(new ArrayList<QuotaSafetyCheck>())
              .build();
      client.createAdminOverrideAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    UpdateAdminOverrideRequest request =
        UpdateAdminOverrideRequest.newBuilder()
            .setName(
                "name-9389/name-9389/services/service-9389/consumerQuotaMetrics/consumerQuotaMetric-9389/limits/limit-9389/adminOverrides/adminOverride-9389")
            .setOverride(QuotaOverride.newBuilder().build())
            .setForce(true)
            .setUpdateMask(FieldMask.newBuilder().build())
            .addAllForceOnly(new ArrayList<QuotaSafetyCheck>())
            .build();

    QuotaOverride actualResponse = client.updateAdminOverrideAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void updateAdminOverrideExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      UpdateAdminOverrideRequest request =
          UpdateAdminOverrideRequest.newBuilder()
              .setName(
                  "name-9389/name-9389/services/service-9389/consumerQuotaMetrics/consumerQuotaMetric-9389/limits/limit-9389/adminOverrides/adminOverride-9389")
              .setOverride(QuotaOverride.newBuilder().build())
              .setForce(true)
              .setUpdateMask(FieldMask.newBuilder().build())
              .addAllForceOnly(new ArrayList<QuotaSafetyCheck>())
              .build();
      client.updateAdminOverrideAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    DeleteAdminOverrideRequest request =
        DeleteAdminOverrideRequest.newBuilder()
            .setName(
                "name-9389/name-9389/services/service-9389/consumerQuotaMetrics/consumerQuotaMetric-9389/limits/limit-9389/adminOverrides/adminOverride-9389")
            .setForce(true)
            .addAllForceOnly(new ArrayList<QuotaSafetyCheck>())
            .build();

    client.deleteAdminOverrideAsync(request).get();

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteAdminOverrideExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DeleteAdminOverrideRequest request =
          DeleteAdminOverrideRequest.newBuilder()
              .setName(
                  "name-9389/name-9389/services/service-9389/consumerQuotaMetrics/consumerQuotaMetric-9389/limits/limit-9389/adminOverrides/adminOverride-9389")
              .setForce(true)
              .addAllForceOnly(new ArrayList<QuotaSafetyCheck>())
              .build();
      client.deleteAdminOverrideAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(expectedResponse);

    ListAdminOverridesRequest request =
        ListAdminOverridesRequest.newBuilder()
            .setParent(
                "parent-8356/parent-8356/services/service-8356/consumerQuotaMetrics/consumerQuotaMetric-8356/limits/limit-8356")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    ListAdminOverridesPagedResponse pagedListResponse = client.listAdminOverrides(request);

    List<QuotaOverride> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getOverridesList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listAdminOverridesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ListAdminOverridesRequest request =
          ListAdminOverridesRequest.newBuilder()
              .setParent(
                  "parent-8356/parent-8356/services/service-8356/consumerQuotaMetrics/consumerQuotaMetric-8356/limits/limit-8356")
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
    mockService.addResponse(resultOperation);

    ImportAdminOverridesRequest request =
        ImportAdminOverridesRequest.newBuilder()
            .setParent("parent-2637/parent-2637/services/service-2637")
            .setForce(true)
            .addAllForceOnly(new ArrayList<QuotaSafetyCheck>())
            .build();

    ImportAdminOverridesResponse actualResponse = client.importAdminOverridesAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void importAdminOverridesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ImportAdminOverridesRequest request =
          ImportAdminOverridesRequest.newBuilder()
              .setParent("parent-2637/parent-2637/services/service-2637")
              .setForce(true)
              .addAllForceOnly(new ArrayList<QuotaSafetyCheck>())
              .build();
      client.importAdminOverridesAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    CreateConsumerOverrideRequest request =
        CreateConsumerOverrideRequest.newBuilder()
            .setParent(
                "parent-8356/parent-8356/services/service-8356/consumerQuotaMetrics/consumerQuotaMetric-8356/limits/limit-8356")
            .setOverride(QuotaOverride.newBuilder().build())
            .setForce(true)
            .addAllForceOnly(new ArrayList<QuotaSafetyCheck>())
            .build();

    QuotaOverride actualResponse = client.createConsumerOverrideAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createConsumerOverrideExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CreateConsumerOverrideRequest request =
          CreateConsumerOverrideRequest.newBuilder()
              .setParent(
                  "parent-8356/parent-8356/services/service-8356/consumerQuotaMetrics/consumerQuotaMetric-8356/limits/limit-8356")
              .setOverride(QuotaOverride.newBuilder().build())
              .setForce(true)
              .addAllForceOnly(new ArrayList<QuotaSafetyCheck>())
              .build();
      client.createConsumerOverrideAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    UpdateConsumerOverrideRequest request =
        UpdateConsumerOverrideRequest.newBuilder()
            .setName(
                "name-4498/name-4498/services/service-4498/consumerQuotaMetrics/consumerQuotaMetric-4498/limits/limit-4498/consumerOverrides/consumerOverride-4498")
            .setOverride(QuotaOverride.newBuilder().build())
            .setForce(true)
            .setUpdateMask(FieldMask.newBuilder().build())
            .addAllForceOnly(new ArrayList<QuotaSafetyCheck>())
            .build();

    QuotaOverride actualResponse = client.updateConsumerOverrideAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void updateConsumerOverrideExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      UpdateConsumerOverrideRequest request =
          UpdateConsumerOverrideRequest.newBuilder()
              .setName(
                  "name-4498/name-4498/services/service-4498/consumerQuotaMetrics/consumerQuotaMetric-4498/limits/limit-4498/consumerOverrides/consumerOverride-4498")
              .setOverride(QuotaOverride.newBuilder().build())
              .setForce(true)
              .setUpdateMask(FieldMask.newBuilder().build())
              .addAllForceOnly(new ArrayList<QuotaSafetyCheck>())
              .build();
      client.updateConsumerOverrideAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    DeleteConsumerOverrideRequest request =
        DeleteConsumerOverrideRequest.newBuilder()
            .setName(
                "name-4498/name-4498/services/service-4498/consumerQuotaMetrics/consumerQuotaMetric-4498/limits/limit-4498/consumerOverrides/consumerOverride-4498")
            .setForce(true)
            .addAllForceOnly(new ArrayList<QuotaSafetyCheck>())
            .build();

    client.deleteConsumerOverrideAsync(request).get();

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteConsumerOverrideExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DeleteConsumerOverrideRequest request =
          DeleteConsumerOverrideRequest.newBuilder()
              .setName(
                  "name-4498/name-4498/services/service-4498/consumerQuotaMetrics/consumerQuotaMetric-4498/limits/limit-4498/consumerOverrides/consumerOverride-4498")
              .setForce(true)
              .addAllForceOnly(new ArrayList<QuotaSafetyCheck>())
              .build();
      client.deleteConsumerOverrideAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(expectedResponse);

    ListConsumerOverridesRequest request =
        ListConsumerOverridesRequest.newBuilder()
            .setParent(
                "parent-8356/parent-8356/services/service-8356/consumerQuotaMetrics/consumerQuotaMetric-8356/limits/limit-8356")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    ListConsumerOverridesPagedResponse pagedListResponse = client.listConsumerOverrides(request);

    List<QuotaOverride> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getOverridesList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listConsumerOverridesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ListConsumerOverridesRequest request =
          ListConsumerOverridesRequest.newBuilder()
              .setParent(
                  "parent-8356/parent-8356/services/service-8356/consumerQuotaMetrics/consumerQuotaMetric-8356/limits/limit-8356")
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
    mockService.addResponse(resultOperation);

    ImportConsumerOverridesRequest request =
        ImportConsumerOverridesRequest.newBuilder()
            .setParent("parent-2637/parent-2637/services/service-2637")
            .setForce(true)
            .addAllForceOnly(new ArrayList<QuotaSafetyCheck>())
            .build();

    ImportConsumerOverridesResponse actualResponse =
        client.importConsumerOverridesAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void importConsumerOverridesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ImportConsumerOverridesRequest request =
          ImportConsumerOverridesRequest.newBuilder()
              .setParent("parent-2637/parent-2637/services/service-2637")
              .setForce(true)
              .addAllForceOnly(new ArrayList<QuotaSafetyCheck>())
              .build();
      client.importConsumerOverridesAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    GenerateServiceIdentityRequest request =
        GenerateServiceIdentityRequest.newBuilder()
            .setParent("parent-2637/parent-2637/services/service-2637")
            .build();

    ServiceIdentity actualResponse = client.generateServiceIdentityAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void generateServiceIdentityExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GenerateServiceIdentityRequest request =
          GenerateServiceIdentityRequest.newBuilder()
              .setParent("parent-2637/parent-2637/services/service-2637")
              .build();
      client.generateServiceIdentityAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }
}
