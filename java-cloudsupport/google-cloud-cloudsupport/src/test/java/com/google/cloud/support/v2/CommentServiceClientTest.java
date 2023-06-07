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
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.common.collect.Lists;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Timestamp;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class CommentServiceClientTest {
  private static MockCommentService mockCommentService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private CommentServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockCommentService = new MockCommentService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockCommentService));
    mockServiceHelper.start();
  }

  @AfterClass
  public static void stopServer() {
    mockServiceHelper.stop();
  }

  @Before
  public void setUp() throws IOException {
    mockServiceHelper.reset();
    channelProvider = mockServiceHelper.createChannelProvider();
    CommentServiceSettings settings =
        CommentServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = CommentServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listCommentsTest() throws Exception {
    Comment responsesElement = Comment.newBuilder().build();
    ListCommentsResponse expectedResponse =
        ListCommentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllComments(Arrays.asList(responsesElement))
            .build();
    mockCommentService.addResponse(expectedResponse);

    CaseName parent = CaseName.ofProjectCaseName("[PROJECT]", "[CASE]");

    ListCommentsPagedResponse pagedListResponse = client.listComments(parent);

    List<Comment> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCommentsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCommentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListCommentsRequest actualRequest = ((ListCommentsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listCommentsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCommentService.addException(exception);

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
    mockCommentService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListCommentsPagedResponse pagedListResponse = client.listComments(parent);

    List<Comment> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCommentsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCommentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListCommentsRequest actualRequest = ((ListCommentsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listCommentsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCommentService.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockCommentService.addResponse(expectedResponse);

    CaseName parent = CaseName.ofProjectCaseName("[PROJECT]", "[CASE]");
    Comment comment = Comment.newBuilder().build();

    Comment actualResponse = client.createComment(parent, comment);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCommentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateCommentRequest actualRequest = ((CreateCommentRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(comment, actualRequest.getComment());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createCommentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCommentService.addException(exception);

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
    mockCommentService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Comment comment = Comment.newBuilder().build();

    Comment actualResponse = client.createComment(parent, comment);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCommentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateCommentRequest actualRequest = ((CreateCommentRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(comment, actualRequest.getComment());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createCommentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCommentService.addException(exception);

    try {
      String parent = "parent-995424086";
      Comment comment = Comment.newBuilder().build();
      client.createComment(parent, comment);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
