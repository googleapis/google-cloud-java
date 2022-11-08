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

package com.google.cloud.talent.v4;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.talent.v4.stub.HttpJsonEventServiceStub;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class EventServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static EventServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonEventServiceStub.getMethodDescriptors(),
            EventServiceSettings.getDefaultEndpoint());
    EventServiceSettings settings =
        EventServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                EventServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = EventServiceClient.create(settings);
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
  public void createClientEventTest() throws Exception {
    ClientEvent expectedResponse =
        ClientEvent.newBuilder()
            .setRequestId("requestId693933066")
            .setEventId("eventId-1376502443")
            .setCreateTime(Timestamp.newBuilder().build())
            .setEventNotes("eventNotes968522823")
            .build();
    mockService.addResponse(expectedResponse);

    TenantName parent = TenantName.of("[PROJECT]", "[TENANT]");
    ClientEvent clientEvent = ClientEvent.newBuilder().build();

    ClientEvent actualResponse = client.createClientEvent(parent, clientEvent);
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
  public void createClientEventExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      TenantName parent = TenantName.of("[PROJECT]", "[TENANT]");
      ClientEvent clientEvent = ClientEvent.newBuilder().build();
      client.createClientEvent(parent, clientEvent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createClientEventTest2() throws Exception {
    ClientEvent expectedResponse =
        ClientEvent.newBuilder()
            .setRequestId("requestId693933066")
            .setEventId("eventId-1376502443")
            .setCreateTime(Timestamp.newBuilder().build())
            .setEventNotes("eventNotes968522823")
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-8940/tenants/tenant-8940";
    ClientEvent clientEvent = ClientEvent.newBuilder().build();

    ClientEvent actualResponse = client.createClientEvent(parent, clientEvent);
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
  public void createClientEventExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-8940/tenants/tenant-8940";
      ClientEvent clientEvent = ClientEvent.newBuilder().build();
      client.createClientEvent(parent, clientEvent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
