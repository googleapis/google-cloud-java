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

package com.google.cloud.discoveryengine.v1beta;

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
import com.google.cloud.discoveryengine.v1beta.stub.HttpJsonUserEventServiceStub;
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
            .setUserPseudoId("userPseudoId-1155274652")
            .setEventTime(Timestamp.newBuilder().build())
            .setUserInfo(UserInfo.newBuilder().build())
            .setDirectUserRequest(true)
            .setSessionId("sessionId607796817")
            .setPageInfo(PageInfo.newBuilder().build())
            .setAttributionToken("attributionToken104706234")
            .setFilter("filter-1274492040")
            .addAllDocuments(new ArrayList<DocumentInfo>())
            .setPanel(PanelInfo.newBuilder().build())
            .setSearchInfo(SearchInfo.newBuilder().build())
            .setCompletionInfo(CompletionInfo.newBuilder().build())
            .setTransactionInfo(TransactionInfo.newBuilder().build())
            .addAllTagIds(new ArrayList<String>())
            .addAllPromotionIds(new ArrayList<String>())
            .putAllAttributes(new HashMap<String, CustomAttribute>())
            .setMediaInfo(MediaInfo.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    WriteUserEventRequest request =
        WriteUserEventRequest.newBuilder()
            .setParent(DataStoreName.of("[PROJECT]", "[LOCATION]", "[DATA_STORE]").toString())
            .setUserEvent(UserEvent.newBuilder().build())
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
              .setParent(DataStoreName.of("[PROJECT]", "[LOCATION]", "[DATA_STORE]").toString())
              .setUserEvent(UserEvent.newBuilder().build())
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
            .setParent(DataStoreName.of("[PROJECT]", "[LOCATION]", "[DATA_STORE]").toString())
            .setUserEvent("userEvent315571599")
            .setUri("uri116076")
            .setEts(100772)
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
              .setParent(DataStoreName.of("[PROJECT]", "[LOCATION]", "[DATA_STORE]").toString())
              .setUserEvent("userEvent315571599")
              .setUri("uri116076")
              .setEts(100772)
              .build();
      client.collectUserEvent(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void importUserEventsTest() throws Exception {
    ImportUserEventsResponse expectedResponse =
        ImportUserEventsResponse.newBuilder()
            .addAllErrorSamples(new ArrayList<Status>())
            .setErrorConfig(ImportErrorConfig.newBuilder().build())
            .setJoinedEventsCount(-720068705)
            .setUnjoinedEventsCount(512159846)
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
            .setParent(DataStoreName.of("[PROJECT]", "[LOCATION]", "[DATA_STORE]").toString())
            .setErrorConfig(ImportErrorConfig.newBuilder().build())
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
              .setParent(DataStoreName.of("[PROJECT]", "[LOCATION]", "[DATA_STORE]").toString())
              .setErrorConfig(ImportErrorConfig.newBuilder().build())
              .build();
      client.importUserEventsAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }
}
