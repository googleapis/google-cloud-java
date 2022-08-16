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

package com.google.cloud.eventarc.publishing.v1;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.eventarc.publishing.v1.stub.HttpJsonPublisherStub;
import com.google.protobuf.Any;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class PublisherClientHttpJsonTest {
  private static MockHttpService mockService;
  private static PublisherClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonPublisherStub.getMethodDescriptors(), PublisherSettings.getDefaultEndpoint());
    PublisherSettings settings =
        PublisherSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                PublisherSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = PublisherClient.create(settings);
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
  public void publishChannelConnectionEventsTest() throws Exception {
    PublishChannelConnectionEventsResponse expectedResponse =
        PublishChannelConnectionEventsResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    PublishChannelConnectionEventsRequest request =
        PublishChannelConnectionEventsRequest.newBuilder()
            .setChannelConnection(
                "projects/project-748/locations/location-748/channelConnections/channelConnection-748")
            .addAllEvents(new ArrayList<Any>())
            .build();

    PublishChannelConnectionEventsResponse actualResponse =
        client.publishChannelConnectionEvents(request);
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
  public void publishChannelConnectionEventsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PublishChannelConnectionEventsRequest request =
          PublishChannelConnectionEventsRequest.newBuilder()
              .setChannelConnection(
                  "projects/project-748/locations/location-748/channelConnections/channelConnection-748")
              .addAllEvents(new ArrayList<Any>())
              .build();
      client.publishChannelConnectionEvents(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void publishEventsTest() throws Exception {
    PublishEventsResponse expectedResponse = PublishEventsResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    PublishEventsRequest request =
        PublishEventsRequest.newBuilder()
            .setChannel("projects/project-2616/locations/location-2616/channels/channel-2616")
            .addAllEvents(new ArrayList<Any>())
            .build();

    PublishEventsResponse actualResponse = client.publishEvents(request);
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
  public void publishEventsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PublishEventsRequest request =
          PublishEventsRequest.newBuilder()
              .setChannel("projects/project-2616/locations/location-2616/channels/channel-2616")
              .addAllEvents(new ArrayList<Any>())
              .build();
      client.publishEvents(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
