/*
 * Copyright 2024 Google LLC
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

package com.google.apps.meet.v2;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.apps.meet.v2.stub.HttpJsonSpacesServiceStub;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
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
public class SpacesServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static SpacesServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonSpacesServiceStub.getMethodDescriptors(),
            SpacesServiceSettings.getDefaultEndpoint());
    SpacesServiceSettings settings =
        SpacesServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                SpacesServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = SpacesServiceClient.create(settings);
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
  public void createSpaceTest() throws Exception {
    Space expectedResponse =
        Space.newBuilder()
            .setName(SpaceName.of("[SPACE]").toString())
            .setMeetingUri("meetingUri802788657")
            .setMeetingCode("meetingCode-883894584")
            .setConfig(SpaceConfig.newBuilder().build())
            .setActiveConference(ActiveConference.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    Space space = Space.newBuilder().build();

    Space actualResponse = client.createSpace(space);
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
  public void createSpaceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Space space = Space.newBuilder().build();
      client.createSpace(space);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSpaceTest() throws Exception {
    Space expectedResponse =
        Space.newBuilder()
            .setName(SpaceName.of("[SPACE]").toString())
            .setMeetingUri("meetingUri802788657")
            .setMeetingCode("meetingCode-883894584")
            .setConfig(SpaceConfig.newBuilder().build())
            .setActiveConference(ActiveConference.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    SpaceName name = SpaceName.of("[SPACE]");

    Space actualResponse = client.getSpace(name);
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
  public void getSpaceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SpaceName name = SpaceName.of("[SPACE]");
      client.getSpace(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSpaceTest2() throws Exception {
    Space expectedResponse =
        Space.newBuilder()
            .setName(SpaceName.of("[SPACE]").toString())
            .setMeetingUri("meetingUri802788657")
            .setMeetingCode("meetingCode-883894584")
            .setConfig(SpaceConfig.newBuilder().build())
            .setActiveConference(ActiveConference.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "spaces/space-5469";

    Space actualResponse = client.getSpace(name);
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
  public void getSpaceExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "spaces/space-5469";
      client.getSpace(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateSpaceTest() throws Exception {
    Space expectedResponse =
        Space.newBuilder()
            .setName(SpaceName.of("[SPACE]").toString())
            .setMeetingUri("meetingUri802788657")
            .setMeetingCode("meetingCode-883894584")
            .setConfig(SpaceConfig.newBuilder().build())
            .setActiveConference(ActiveConference.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    Space space =
        Space.newBuilder()
            .setName(SpaceName.of("[SPACE]").toString())
            .setMeetingUri("meetingUri802788657")
            .setMeetingCode("meetingCode-883894584")
            .setConfig(SpaceConfig.newBuilder().build())
            .setActiveConference(ActiveConference.newBuilder().build())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Space actualResponse = client.updateSpace(space, updateMask);
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
  public void updateSpaceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Space space =
          Space.newBuilder()
              .setName(SpaceName.of("[SPACE]").toString())
              .setMeetingUri("meetingUri802788657")
              .setMeetingCode("meetingCode-883894584")
              .setConfig(SpaceConfig.newBuilder().build())
              .setActiveConference(ActiveConference.newBuilder().build())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateSpace(space, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void endActiveConferenceTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    SpaceName name = SpaceName.of("[SPACE]");

    client.endActiveConference(name);

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
  public void endActiveConferenceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SpaceName name = SpaceName.of("[SPACE]");
      client.endActiveConference(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void endActiveConferenceTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name = "spaces/space-5469";

    client.endActiveConference(name);

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
  public void endActiveConferenceExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "spaces/space-5469";
      client.endActiveConference(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
