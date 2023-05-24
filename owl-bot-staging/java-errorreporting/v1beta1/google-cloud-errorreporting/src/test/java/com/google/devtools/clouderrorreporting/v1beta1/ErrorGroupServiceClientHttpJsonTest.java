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

package com.google.devtools.clouderrorreporting.v1beta1;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.devtools.clouderrorreporting.v1beta1.stub.HttpJsonErrorGroupServiceStub;
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
public class ErrorGroupServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static ErrorGroupServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonErrorGroupServiceStub.getMethodDescriptors(),
            ErrorGroupServiceSettings.getDefaultEndpoint());
    ErrorGroupServiceSettings settings =
        ErrorGroupServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                ErrorGroupServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ErrorGroupServiceClient.create(settings);
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
  public void getGroupTest() throws Exception {
    ErrorGroup expectedResponse =
        ErrorGroup.newBuilder()
            .setName(ErrorGroupName.of("[PROJECT]", "[GROUP]").toString())
            .setGroupId("groupId293428218")
            .addAllTrackingIssues(new ArrayList<TrackingIssue>())
            .setResolutionStatus(ResolutionStatus.forNumber(0))
            .build();
    mockService.addResponse(expectedResponse);

    ErrorGroupName groupName = ErrorGroupName.of("[PROJECT]", "[GROUP]");

    ErrorGroup actualResponse = client.getGroup(groupName);
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
  public void getGroupExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ErrorGroupName groupName = ErrorGroupName.of("[PROJECT]", "[GROUP]");
      client.getGroup(groupName);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getGroupTest2() throws Exception {
    ErrorGroup expectedResponse =
        ErrorGroup.newBuilder()
            .setName(ErrorGroupName.of("[PROJECT]", "[GROUP]").toString())
            .setGroupId("groupId293428218")
            .addAllTrackingIssues(new ArrayList<TrackingIssue>())
            .setResolutionStatus(ResolutionStatus.forNumber(0))
            .build();
    mockService.addResponse(expectedResponse);

    String groupName = "projects/project-3535/groups/group-3535";

    ErrorGroup actualResponse = client.getGroup(groupName);
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
  public void getGroupExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String groupName = "projects/project-3535/groups/group-3535";
      client.getGroup(groupName);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateGroupTest() throws Exception {
    ErrorGroup expectedResponse =
        ErrorGroup.newBuilder()
            .setName(ErrorGroupName.of("[PROJECT]", "[GROUP]").toString())
            .setGroupId("groupId293428218")
            .addAllTrackingIssues(new ArrayList<TrackingIssue>())
            .setResolutionStatus(ResolutionStatus.forNumber(0))
            .build();
    mockService.addResponse(expectedResponse);

    ErrorGroup group =
        ErrorGroup.newBuilder()
            .setName(ErrorGroupName.of("[PROJECT]", "[GROUP]").toString())
            .setGroupId("groupId293428218")
            .addAllTrackingIssues(new ArrayList<TrackingIssue>())
            .setResolutionStatus(ResolutionStatus.forNumber(0))
            .build();

    ErrorGroup actualResponse = client.updateGroup(group);
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
  public void updateGroupExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ErrorGroup group =
          ErrorGroup.newBuilder()
              .setName(ErrorGroupName.of("[PROJECT]", "[GROUP]").toString())
              .setGroupId("groupId293428218")
              .addAllTrackingIssues(new ArrayList<TrackingIssue>())
              .setResolutionStatus(ResolutionStatus.forNumber(0))
              .build();
      client.updateGroup(group);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
