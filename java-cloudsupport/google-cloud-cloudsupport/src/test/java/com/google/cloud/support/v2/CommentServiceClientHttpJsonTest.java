/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.support.v2;

import static com.google.cloud.support.v2.CommentServiceClient.ListCommentsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.support.v2.stub.HttpJsonCommentServiceStub;
import com.google.common.collect.Lists;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class CommentServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static CommentServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonCommentServiceStub.getMethodDescriptors(),
            CommentServiceSettings.getDefaultEndpoint());
    CommentServiceSettings settings =
        CommentServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                CommentServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = CommentServiceClient.create(settings);
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
  public void listCommentsTest() throws Exception {
    Comment responsesElement = Comment.newBuilder().build();
    ListCommentsResponse expectedResponse =
        ListCommentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllComments(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    CaseName parent = CaseName.ofProjectCaseName("[PROJECT]", "[CASE]");

    ListCommentsPagedResponse pagedListResponse = client.listComments(parent);

    List<Comment> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCommentsList().get(0), resources.get(0));

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
  public void listCommentsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CaseName parent = CaseName.ofProjectCaseName("[PROJECT]", "[CASE]");
      client.listComments(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listCommentsTest2() throws Exception {
    Comment responsesElement = Comment.newBuilder().build();
    ListCommentsResponse expectedResponse =
        ListCommentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllComments(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-2178/cases/case-2178";

    ListCommentsPagedResponse pagedListResponse = client.listComments(parent);

    List<Comment> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCommentsList().get(0), resources.get(0));

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
  public void listCommentsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-2178/cases/case-2178";
      client.listComments(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createCommentTest() throws Exception {
    Comment expectedResponse =
        Comment.newBuilder()
            .setName("name3373707")
            .setCreateTime(Timestamp.newBuilder().build())
            .setCreator(Actor.newBuilder().build())
            .setBody("body3029410")
            .setPlainTextBody("plainTextBody-1301059495")
            .build();
    mockService.addResponse(expectedResponse);

    CaseName parent = CaseName.ofProjectCaseName("[PROJECT]", "[CASE]");
    Comment comment = Comment.newBuilder().build();

    Comment actualResponse = client.createComment(parent, comment);
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
  public void createCommentExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CaseName parent = CaseName.ofProjectCaseName("[PROJECT]", "[CASE]");
      Comment comment = Comment.newBuilder().build();
      client.createComment(parent, comment);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createCommentTest2() throws Exception {
    Comment expectedResponse =
        Comment.newBuilder()
            .setName("name3373707")
            .setCreateTime(Timestamp.newBuilder().build())
            .setCreator(Actor.newBuilder().build())
            .setBody("body3029410")
            .setPlainTextBody("plainTextBody-1301059495")
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-2178/cases/case-2178";
    Comment comment = Comment.newBuilder().build();

    Comment actualResponse = client.createComment(parent, comment);
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
  public void createCommentExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-2178/cases/case-2178";
      Comment comment = Comment.newBuilder().build();
      client.createComment(parent, comment);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
