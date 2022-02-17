/*
 * Copyright 2021 Google LLC
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

package com.google.cloud.dataplex.v1;

import static com.google.cloud.dataplex.v1.ContentServiceClient.ListContentPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.common.collect.Lists;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
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
public class ContentServiceClientTest {
  private static MockContentService mockContentService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private ContentServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockContentService = new MockContentService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockContentService));
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
    ContentServiceSettings settings =
        ContentServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ContentServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createContentTest() throws Exception {
    Content expectedResponse =
        Content.newBuilder()
            .setName(ContentName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[CONTENT]").toString())
            .setUid("uid115792")
            .setPath("path3433509")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .build();
    mockContentService.addResponse(expectedResponse);

    LakeName parent = LakeName.of("[PROJECT]", "[LOCATION]", "[LAKE]");
    Content content = Content.newBuilder().build();

    Content actualResponse = client.createContent(parent, content);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockContentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateContentRequest actualRequest = ((CreateContentRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(content, actualRequest.getContent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createContentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContentService.addException(exception);

    try {
      LakeName parent = LakeName.of("[PROJECT]", "[LOCATION]", "[LAKE]");
      Content content = Content.newBuilder().build();
      client.createContent(parent, content);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createContentTest2() throws Exception {
    Content expectedResponse =
        Content.newBuilder()
            .setName(ContentName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[CONTENT]").toString())
            .setUid("uid115792")
            .setPath("path3433509")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .build();
    mockContentService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Content content = Content.newBuilder().build();

    Content actualResponse = client.createContent(parent, content);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockContentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateContentRequest actualRequest = ((CreateContentRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(content, actualRequest.getContent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createContentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContentService.addException(exception);

    try {
      String parent = "parent-995424086";
      Content content = Content.newBuilder().build();
      client.createContent(parent, content);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateContentTest() throws Exception {
    Content expectedResponse =
        Content.newBuilder()
            .setName(ContentName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[CONTENT]").toString())
            .setUid("uid115792")
            .setPath("path3433509")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .build();
    mockContentService.addResponse(expectedResponse);

    Content content = Content.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Content actualResponse = client.updateContent(content, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockContentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateContentRequest actualRequest = ((UpdateContentRequest) actualRequests.get(0));

    Assert.assertEquals(content, actualRequest.getContent());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateContentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContentService.addException(exception);

    try {
      Content content = Content.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateContent(content, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteContentTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockContentService.addResponse(expectedResponse);

    ContentName name = ContentName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[CONTENT]");

    client.deleteContent(name);

    List<AbstractMessage> actualRequests = mockContentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteContentRequest actualRequest = ((DeleteContentRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteContentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContentService.addException(exception);

    try {
      ContentName name = ContentName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[CONTENT]");
      client.deleteContent(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteContentTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockContentService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteContent(name);

    List<AbstractMessage> actualRequests = mockContentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteContentRequest actualRequest = ((DeleteContentRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteContentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContentService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteContent(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getContentTest() throws Exception {
    Content expectedResponse =
        Content.newBuilder()
            .setName(ContentName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[CONTENT]").toString())
            .setUid("uid115792")
            .setPath("path3433509")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .build();
    mockContentService.addResponse(expectedResponse);

    ContentName name = ContentName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[CONTENT]");

    Content actualResponse = client.getContent(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockContentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetContentRequest actualRequest = ((GetContentRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getContentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContentService.addException(exception);

    try {
      ContentName name = ContentName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[CONTENT]");
      client.getContent(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getContentTest2() throws Exception {
    Content expectedResponse =
        Content.newBuilder()
            .setName(ContentName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[CONTENT]").toString())
            .setUid("uid115792")
            .setPath("path3433509")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .build();
    mockContentService.addResponse(expectedResponse);

    String name = "name3373707";

    Content actualResponse = client.getContent(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockContentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetContentRequest actualRequest = ((GetContentRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getContentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContentService.addException(exception);

    try {
      String name = "name3373707";
      client.getContent(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listContentTest() throws Exception {
    Content responsesElement = Content.newBuilder().build();
    ListContentResponse expectedResponse =
        ListContentResponse.newBuilder()
            .setNextPageToken("")
            .addAllContent(Arrays.asList(responsesElement))
            .build();
    mockContentService.addResponse(expectedResponse);

    LakeName parent = LakeName.of("[PROJECT]", "[LOCATION]", "[LAKE]");

    ListContentPagedResponse pagedListResponse = client.listContent(parent);

    List<Content> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getContentList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockContentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListContentRequest actualRequest = ((ListContentRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listContentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContentService.addException(exception);

    try {
      LakeName parent = LakeName.of("[PROJECT]", "[LOCATION]", "[LAKE]");
      client.listContent(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listContentTest2() throws Exception {
    Content responsesElement = Content.newBuilder().build();
    ListContentResponse expectedResponse =
        ListContentResponse.newBuilder()
            .setNextPageToken("")
            .addAllContent(Arrays.asList(responsesElement))
            .build();
    mockContentService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListContentPagedResponse pagedListResponse = client.listContent(parent);

    List<Content> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getContentList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockContentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListContentRequest actualRequest = ((ListContentRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listContentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContentService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listContent(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
