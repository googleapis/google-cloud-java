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
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.api.serviceusage.v1.stub.HttpJsonServiceUsageStub;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Any;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
    EnableServiceResponse expectedResponse =
        EnableServiceResponse.newBuilder().setService(Service.newBuilder().build()).build();
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

    EnableServiceResponse actualResponse = client.enableServiceAsync(request).get();
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
    DisableServiceResponse expectedResponse =
        DisableServiceResponse.newBuilder().setService(Service.newBuilder().build()).build();
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
            .setDisableDependentServices(true)
            .build();

    DisableServiceResponse actualResponse = client.disableServiceAsync(request).get();
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
  public void disableServiceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DisableServiceRequest request =
          DisableServiceRequest.newBuilder()
              .setName("name-7410/name-7410/services/service-7410")
              .setDisableDependentServices(true)
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
    mockService.addResponse(resultOperation);

    BatchEnableServicesRequest request =
        BatchEnableServicesRequest.newBuilder()
            .setParent("parent-4715/parent-4715")
            .addAllServiceIds(new ArrayList<String>())
            .build();

    BatchEnableServicesResponse actualResponse = client.batchEnableServicesAsync(request).get();
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
  public void batchGetServicesTest() throws Exception {
    BatchGetServicesResponse expectedResponse =
        BatchGetServicesResponse.newBuilder().addAllServices(new ArrayList<Service>()).build();
    mockService.addResponse(expectedResponse);

    BatchGetServicesRequest request =
        BatchGetServicesRequest.newBuilder()
            .setParent("parent-4715/parent-4715")
            .addAllNames(new ArrayList<String>())
            .build();

    BatchGetServicesResponse actualResponse = client.batchGetServices(request);
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
  public void batchGetServicesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      BatchGetServicesRequest request =
          BatchGetServicesRequest.newBuilder()
              .setParent("parent-4715/parent-4715")
              .addAllNames(new ArrayList<String>())
              .build();
      client.batchGetServices(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
