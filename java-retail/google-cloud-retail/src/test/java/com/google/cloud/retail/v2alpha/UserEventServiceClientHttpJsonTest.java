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

package com.google.cloud.retail.v2alpha;

import com.google.api.HttpBody;
import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.retail.v2alpha.stub.HttpJsonUserEventServiceStub;
import com.google.longrunning.Operation;
import com.google.protobuf.Any;
import com.google.protobuf.ByteString;
import com.google.protobuf.Timestamp;
import com.google.rpc.Status;
import java.io.IOException;
import java.util.ArrayList;
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
public class UserEventServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static UserEventServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonUserEventServiceStub.getMethodDescriptors(),
            UserEventServiceSettings.getDefaultEndpoint());
    UserEventServiceSettings settings =
        UserEventServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                UserEventServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = UserEventServiceClient.create(settings);
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
  public void writeUserEventTest() throws Exception {
    UserEvent expectedResponse =
        UserEvent.newBuilder()
            .setEventType("eventType31430900")
            .setVisitorId("visitorId1880545833")
            .setSessionId("sessionId607796817")
            .setEventTime(Timestamp.newBuilder().build())
            .addAllExperimentIds(new ArrayList<String>())
            .setAttributionToken("attributionToken104706234")
            .addAllProductDetails(new ArrayList<ProductDetail>())
            .setCompletionDetail(CompletionDetail.newBuilder().build())
            .putAllAttributes(new HashMap<String, CustomAttribute>())
            .setCartId("cartId-1367589797")
            .setPurchaseTransaction(PurchaseTransaction.newBuilder().build())
            .setSearchQuery("searchQuery-552137728")
            .setFilter("filter-1274492040")
            .setOrderBy("orderBy-1207110587")
            .setOffset(-1019779949)
            .addAllPageCategories(new ArrayList<String>())
            .setUserInfo(UserInfo.newBuilder().build())
            .setUri("uri116076")
            .setReferrerUri("referrerUri348088525")
            .setPageViewId("pageViewId1362499087")
            .build();
    mockService.addResponse(expectedResponse);

    WriteUserEventRequest request =
        WriteUserEventRequest.newBuilder()
            .setParent("projects/project-6267/locations/location-6267/catalogs/catalog-6267")
            .setUserEvent(UserEvent.newBuilder().build())
            .setWriteAsync(true)
            .build();

    UserEvent actualResponse = client.writeUserEvent(request);
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
  public void writeUserEventExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      WriteUserEventRequest request =
          WriteUserEventRequest.newBuilder()
              .setParent("projects/project-6267/locations/location-6267/catalogs/catalog-6267")
              .setUserEvent(UserEvent.newBuilder().build())
              .setWriteAsync(true)
              .build();
      client.writeUserEvent(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void collectUserEventTest() throws Exception {
    HttpBody expectedResponse =
        HttpBody.newBuilder()
            .setContentType("contentType-389131437")
            .setData(ByteString.EMPTY)
            .addAllExtensions(new ArrayList<Any>())
            .build();
    mockService.addResponse(expectedResponse);

    CollectUserEventRequest request =
        CollectUserEventRequest.newBuilder()
            .setParent("projects/project-6267/locations/location-6267/catalogs/catalog-6267")
            .setUserEvent("userEvent315571599")
            .setUri("uri116076")
            .setEts(100772)
            .setRawJson("rawJson985449776")
            .build();

    HttpBody actualResponse = client.collectUserEvent(request);
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
  public void collectUserEventExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CollectUserEventRequest request =
          CollectUserEventRequest.newBuilder()
              .setParent("projects/project-6267/locations/location-6267/catalogs/catalog-6267")
              .setUserEvent("userEvent315571599")
              .setUri("uri116076")
              .setEts(100772)
              .setRawJson("rawJson985449776")
              .build();
      client.collectUserEvent(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void purgeUserEventsTest() throws Exception {
    PurgeUserEventsResponse expectedResponse =
        PurgeUserEventsResponse.newBuilder().setPurgedEventsCount(-310774833).build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("purgeUserEventsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    PurgeUserEventsRequest request =
        PurgeUserEventsRequest.newBuilder()
            .setParent(CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString())
            .setFilter("filter-1274492040")
            .setForce(true)
            .build();

    PurgeUserEventsResponse actualResponse = client.purgeUserEventsAsync(request).get();
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
  public void purgeUserEventsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PurgeUserEventsRequest request =
          PurgeUserEventsRequest.newBuilder()
              .setParent(CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString())
              .setFilter("filter-1274492040")
              .setForce(true)
              .build();
      client.purgeUserEventsAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void importUserEventsTest() throws Exception {
    ImportUserEventsResponse expectedResponse =
        ImportUserEventsResponse.newBuilder()
            .addAllErrorSamples(new ArrayList<Status>())
            .setErrorsConfig(ImportErrorsConfig.newBuilder().build())
            .setImportSummary(UserEventImportSummary.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("importUserEventsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    ImportUserEventsRequest request =
        ImportUserEventsRequest.newBuilder()
            .setParent(CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString())
            .setInputConfig(UserEventInputConfig.newBuilder().build())
            .setErrorsConfig(ImportErrorsConfig.newBuilder().build())
            .build();

    ImportUserEventsResponse actualResponse = client.importUserEventsAsync(request).get();
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
  public void importUserEventsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ImportUserEventsRequest request =
          ImportUserEventsRequest.newBuilder()
              .setParent(CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString())
              .setInputConfig(UserEventInputConfig.newBuilder().build())
              .setErrorsConfig(ImportErrorsConfig.newBuilder().build())
              .build();
      client.importUserEventsAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void rejoinUserEventsTest() throws Exception {
    RejoinUserEventsResponse expectedResponse =
        RejoinUserEventsResponse.newBuilder().setRejoinedUserEventsCount(-1152281574).build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("rejoinUserEventsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    RejoinUserEventsRequest request =
        RejoinUserEventsRequest.newBuilder()
            .setParent("projects/project-6267/locations/location-6267/catalogs/catalog-6267")
            .build();

    RejoinUserEventsResponse actualResponse = client.rejoinUserEventsAsync(request).get();
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
  public void rejoinUserEventsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      RejoinUserEventsRequest request =
          RejoinUserEventsRequest.newBuilder()
              .setParent("projects/project-6267/locations/location-6267/catalogs/catalog-6267")
              .build();
      client.rejoinUserEventsAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }
}
