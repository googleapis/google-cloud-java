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

package com.google.cloud.resourcemanager.v3;

import static com.google.cloud.resourcemanager.v3.TagHoldsClient.ListTagHoldsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.protobuf.Timestamp;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class TagHoldsClientTest {
  private static MockServiceHelper mockServiceHelper;
  private static MockTagHolds mockTagHolds;
  private LocalChannelProvider channelProvider;
  private TagHoldsClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockTagHolds = new MockTagHolds();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockTagHolds));
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
    TagHoldsSettings settings =
        TagHoldsSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = TagHoldsClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createTagHoldTest() throws Exception {
    TagHold expectedResponse =
        TagHold.newBuilder()
            .setName(TagHoldName.of("[TAG_VALUE]", "[TAG_HOLD]").toString())
            .setHolder("holder-1211707988")
            .setOrigin("origin-1008619738")
            .setHelpLink("helpLink-790009125")
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createTagHoldTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockTagHolds.addResponse(resultOperation);

    TagValueName parent = TagValueName.of("[TAG_VALUE]");
    TagHold tagHold = TagHold.newBuilder().build();

    TagHold actualResponse = client.createTagHoldAsync(parent, tagHold).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTagHolds.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateTagHoldRequest actualRequest = ((CreateTagHoldRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(tagHold, actualRequest.getTagHold());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createTagHoldExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTagHolds.addException(exception);

    try {
      TagValueName parent = TagValueName.of("[TAG_VALUE]");
      TagHold tagHold = TagHold.newBuilder().build();
      client.createTagHoldAsync(parent, tagHold).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createTagHoldTest2() throws Exception {
    TagHold expectedResponse =
        TagHold.newBuilder()
            .setName(TagHoldName.of("[TAG_VALUE]", "[TAG_HOLD]").toString())
            .setHolder("holder-1211707988")
            .setOrigin("origin-1008619738")
            .setHelpLink("helpLink-790009125")
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createTagHoldTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockTagHolds.addResponse(resultOperation);

    String parent = "parent-995424086";
    TagHold tagHold = TagHold.newBuilder().build();

    TagHold actualResponse = client.createTagHoldAsync(parent, tagHold).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTagHolds.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateTagHoldRequest actualRequest = ((CreateTagHoldRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(tagHold, actualRequest.getTagHold());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createTagHoldExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTagHolds.addException(exception);

    try {
      String parent = "parent-995424086";
      TagHold tagHold = TagHold.newBuilder().build();
      client.createTagHoldAsync(parent, tagHold).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteTagHoldTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteTagHoldTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockTagHolds.addResponse(resultOperation);

    TagHoldName name = TagHoldName.of("[TAG_VALUE]", "[TAG_HOLD]");

    client.deleteTagHoldAsync(name).get();

    List<AbstractMessage> actualRequests = mockTagHolds.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteTagHoldRequest actualRequest = ((DeleteTagHoldRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteTagHoldExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTagHolds.addException(exception);

    try {
      TagHoldName name = TagHoldName.of("[TAG_VALUE]", "[TAG_HOLD]");
      client.deleteTagHoldAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteTagHoldTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteTagHoldTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockTagHolds.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteTagHoldAsync(name).get();

    List<AbstractMessage> actualRequests = mockTagHolds.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteTagHoldRequest actualRequest = ((DeleteTagHoldRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteTagHoldExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTagHolds.addException(exception);

    try {
      String name = "name3373707";
      client.deleteTagHoldAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listTagHoldsTest() throws Exception {
    TagHold responsesElement = TagHold.newBuilder().build();
    ListTagHoldsResponse expectedResponse =
        ListTagHoldsResponse.newBuilder()
            .setNextPageToken("")
            .addAllTagHolds(Arrays.asList(responsesElement))
            .build();
    mockTagHolds.addResponse(expectedResponse);

    TagValueName parent = TagValueName.of("[TAG_VALUE]");

    ListTagHoldsPagedResponse pagedListResponse = client.listTagHolds(parent);

    List<TagHold> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTagHoldsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockTagHolds.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListTagHoldsRequest actualRequest = ((ListTagHoldsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listTagHoldsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTagHolds.addException(exception);

    try {
      TagValueName parent = TagValueName.of("[TAG_VALUE]");
      client.listTagHolds(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listTagHoldsTest2() throws Exception {
    TagHold responsesElement = TagHold.newBuilder().build();
    ListTagHoldsResponse expectedResponse =
        ListTagHoldsResponse.newBuilder()
            .setNextPageToken("")
            .addAllTagHolds(Arrays.asList(responsesElement))
            .build();
    mockTagHolds.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListTagHoldsPagedResponse pagedListResponse = client.listTagHolds(parent);

    List<TagHold> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTagHoldsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockTagHolds.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListTagHoldsRequest actualRequest = ((ListTagHoldsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listTagHoldsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTagHolds.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listTagHolds(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
