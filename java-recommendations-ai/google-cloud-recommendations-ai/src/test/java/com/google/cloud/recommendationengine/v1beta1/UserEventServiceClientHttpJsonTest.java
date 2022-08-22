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

package com.google.cloud.recommendationengine.v1beta1;

import static com.google.cloud.recommendationengine.v1beta1.UserEventServiceClient.ListUserEventsPagedResponse;

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
import com.google.cloud.recommendationengine.v1beta1.stub.HttpJsonUserEventServiceStub;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Any;
import com.google.protobuf.ByteString;
import com.google.protobuf.Timestamp;
import com.google.rpc.Status;
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
            .setUserInfo(UserInfo.newBuilder().build())
            .setEventDetail(EventDetail.newBuilder().build())
            .setProductEventDetail(ProductEventDetail.newBuilder().build())
            .setEventTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    EventStoreName parent =
        EventStoreName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[EVENT_STORE]");
    UserEvent userEvent = UserEvent.newBuilder().build();

    UserEvent actualResponse = client.writeUserEvent(parent, userEvent);
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
      EventStoreName parent =
          EventStoreName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[EVENT_STORE]");
      UserEvent userEvent = UserEvent.newBuilder().build();
      client.writeUserEvent(parent, userEvent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void writeUserEventTest2() throws Exception {
    UserEvent expectedResponse =
        UserEvent.newBuilder()
            .setEventType("eventType31430900")
            .setUserInfo(UserInfo.newBuilder().build())
            .setEventDetail(EventDetail.newBuilder().build())
            .setProductEventDetail(ProductEventDetail.newBuilder().build())
            .setEventTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String parent =
        "projects/project-765/locations/location-765/catalogs/catalog-765/eventStores/eventStore-765";
    UserEvent userEvent = UserEvent.newBuilder().build();

    UserEvent actualResponse = client.writeUserEvent(parent, userEvent);
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
  public void writeUserEventExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-765/locations/location-765/catalogs/catalog-765/eventStores/eventStore-765";
      UserEvent userEvent = UserEvent.newBuilder().build();
      client.writeUserEvent(parent, userEvent);
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

    EventStoreName parent =
        EventStoreName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[EVENT_STORE]");
    String userEvent = "userEvent315571599";
    String uri = "uri116076";
    long ets = 100772;

    HttpBody actualResponse = client.collectUserEvent(parent, userEvent, uri, ets);
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
      EventStoreName parent =
          EventStoreName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[EVENT_STORE]");
      String userEvent = "userEvent315571599";
      String uri = "uri116076";
      long ets = 100772;
      client.collectUserEvent(parent, userEvent, uri, ets);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void collectUserEventTest2() throws Exception {
    HttpBody expectedResponse =
        HttpBody.newBuilder()
            .setContentType("contentType-389131437")
            .setData(ByteString.EMPTY)
            .addAllExtensions(new ArrayList<Any>())
            .build();
    mockService.addResponse(expectedResponse);

    String parent =
        "projects/project-765/locations/location-765/catalogs/catalog-765/eventStores/eventStore-765";
    String userEvent = "userEvent315571599";
    String uri = "uri116076";
    long ets = 100772;

    HttpBody actualResponse = client.collectUserEvent(parent, userEvent, uri, ets);
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
  public void collectUserEventExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-765/locations/location-765/catalogs/catalog-765/eventStores/eventStore-765";
      String userEvent = "userEvent315571599";
      String uri = "uri116076";
      long ets = 100772;
      client.collectUserEvent(parent, userEvent, uri, ets);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listUserEventsTest() throws Exception {
    UserEvent responsesElement = UserEvent.newBuilder().build();
    ListUserEventsResponse expectedResponse =
        ListUserEventsResponse.newBuilder()
            .setNextPageToken("")
            .addAllUserEvents(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    EventStoreName parent =
        EventStoreName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[EVENT_STORE]");
    String filter = "filter-1274492040";

    ListUserEventsPagedResponse pagedListResponse = client.listUserEvents(parent, filter);

    List<UserEvent> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getUserEventsList().get(0), resources.get(0));

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
  public void listUserEventsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      EventStoreName parent =
          EventStoreName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[EVENT_STORE]");
      String filter = "filter-1274492040";
      client.listUserEvents(parent, filter);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listUserEventsTest2() throws Exception {
    UserEvent responsesElement = UserEvent.newBuilder().build();
    ListUserEventsResponse expectedResponse =
        ListUserEventsResponse.newBuilder()
            .setNextPageToken("")
            .addAllUserEvents(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent =
        "projects/project-765/locations/location-765/catalogs/catalog-765/eventStores/eventStore-765";
    String filter = "filter-1274492040";

    ListUserEventsPagedResponse pagedListResponse = client.listUserEvents(parent, filter);

    List<UserEvent> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getUserEventsList().get(0), resources.get(0));

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
  public void listUserEventsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-765/locations/location-765/catalogs/catalog-765/eventStores/eventStore-765";
      String filter = "filter-1274492040";
      client.listUserEvents(parent, filter);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void purgeUserEventsTest() throws Exception {
    PurgeUserEventsResponse expectedResponse =
        PurgeUserEventsResponse.newBuilder()
            .setPurgedEventsCount(-310774833)
            .addAllUserEventsSample(new ArrayList<UserEvent>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("purgeUserEventsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    EventStoreName parent =
        EventStoreName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[EVENT_STORE]");
    String filter = "filter-1274492040";
    boolean force = true;

    PurgeUserEventsResponse actualResponse =
        client.purgeUserEventsAsync(parent, filter, force).get();
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
      EventStoreName parent =
          EventStoreName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[EVENT_STORE]");
      String filter = "filter-1274492040";
      boolean force = true;
      client.purgeUserEventsAsync(parent, filter, force).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void purgeUserEventsTest2() throws Exception {
    PurgeUserEventsResponse expectedResponse =
        PurgeUserEventsResponse.newBuilder()
            .setPurgedEventsCount(-310774833)
            .addAllUserEventsSample(new ArrayList<UserEvent>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("purgeUserEventsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent =
        "projects/project-765/locations/location-765/catalogs/catalog-765/eventStores/eventStore-765";
    String filter = "filter-1274492040";
    boolean force = true;

    PurgeUserEventsResponse actualResponse =
        client.purgeUserEventsAsync(parent, filter, force).get();
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
  public void purgeUserEventsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-765/locations/location-765/catalogs/catalog-765/eventStores/eventStore-765";
      String filter = "filter-1274492040";
      boolean force = true;
      client.purgeUserEventsAsync(parent, filter, force).get();
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

    EventStoreName parent =
        EventStoreName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[EVENT_STORE]");
    String requestId = "requestId693933066";
    InputConfig inputConfig = InputConfig.newBuilder().build();
    ImportErrorsConfig errorsConfig = ImportErrorsConfig.newBuilder().build();

    ImportUserEventsResponse actualResponse =
        client.importUserEventsAsync(parent, requestId, inputConfig, errorsConfig).get();
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
      EventStoreName parent =
          EventStoreName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[EVENT_STORE]");
      String requestId = "requestId693933066";
      InputConfig inputConfig = InputConfig.newBuilder().build();
      ImportErrorsConfig errorsConfig = ImportErrorsConfig.newBuilder().build();
      client.importUserEventsAsync(parent, requestId, inputConfig, errorsConfig).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void importUserEventsTest2() throws Exception {
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

    String parent =
        "projects/project-765/locations/location-765/catalogs/catalog-765/eventStores/eventStore-765";
    String requestId = "requestId693933066";
    InputConfig inputConfig = InputConfig.newBuilder().build();
    ImportErrorsConfig errorsConfig = ImportErrorsConfig.newBuilder().build();

    ImportUserEventsResponse actualResponse =
        client.importUserEventsAsync(parent, requestId, inputConfig, errorsConfig).get();
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
  public void importUserEventsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-765/locations/location-765/catalogs/catalog-765/eventStores/eventStore-765";
      String requestId = "requestId693933066";
      InputConfig inputConfig = InputConfig.newBuilder().build();
      ImportErrorsConfig errorsConfig = ImportErrorsConfig.newBuilder().build();
      client.importUserEventsAsync(parent, requestId, inputConfig, errorsConfig).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }
}
