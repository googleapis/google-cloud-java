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

package com.google.cloud.resourcemanager.v3;

import static com.google.cloud.resourcemanager.v3.TagBindingsClient.ListTagBindingsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.resourcenames.ResourceName;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
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
public class TagBindingsClientTest {
  private static MockServiceHelper mockServiceHelper;
  private static MockTagBindings mockTagBindings;
  private LocalChannelProvider channelProvider;
  private TagBindingsClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockTagBindings = new MockTagBindings();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockTagBindings));
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
    TagBindingsSettings settings =
        TagBindingsSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = TagBindingsClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listTagBindingsTest() throws Exception {
    TagBinding responsesElement = TagBinding.newBuilder().build();
    ListTagBindingsResponse expectedResponse =
        ListTagBindingsResponse.newBuilder()
            .setNextPageToken("")
            .addAllTagBindings(Arrays.asList(responsesElement))
            .build();
    mockTagBindings.addResponse(expectedResponse);

    ResourceName parent = FolderName.of("[FOLDER]");

    ListTagBindingsPagedResponse pagedListResponse = client.listTagBindings(parent);

    List<TagBinding> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTagBindingsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockTagBindings.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListTagBindingsRequest actualRequest = ((ListTagBindingsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listTagBindingsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTagBindings.addException(exception);

    try {
      ResourceName parent = FolderName.of("[FOLDER]");
      client.listTagBindings(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listTagBindingsTest2() throws Exception {
    TagBinding responsesElement = TagBinding.newBuilder().build();
    ListTagBindingsResponse expectedResponse =
        ListTagBindingsResponse.newBuilder()
            .setNextPageToken("")
            .addAllTagBindings(Arrays.asList(responsesElement))
            .build();
    mockTagBindings.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListTagBindingsPagedResponse pagedListResponse = client.listTagBindings(parent);

    List<TagBinding> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTagBindingsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockTagBindings.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListTagBindingsRequest actualRequest = ((ListTagBindingsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listTagBindingsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTagBindings.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listTagBindings(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createTagBindingTest() throws Exception {
    TagBinding expectedResponse =
        TagBinding.newBuilder()
            .setName(TagBindingName.of("[TAG_BINDING]").toString())
            .setParent("parent-995424086")
            .setTagValue("tagValue-772697609")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createTagBindingTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockTagBindings.addResponse(resultOperation);

    TagBinding tagBinding = TagBinding.newBuilder().build();

    TagBinding actualResponse = client.createTagBindingAsync(tagBinding).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTagBindings.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateTagBindingRequest actualRequest = ((CreateTagBindingRequest) actualRequests.get(0));

    Assert.assertEquals(tagBinding, actualRequest.getTagBinding());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createTagBindingExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTagBindings.addException(exception);

    try {
      TagBinding tagBinding = TagBinding.newBuilder().build();
      client.createTagBindingAsync(tagBinding).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteTagBindingTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteTagBindingTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockTagBindings.addResponse(resultOperation);

    TagBindingName name = TagBindingName.of("[TAG_BINDING]");

    client.deleteTagBindingAsync(name).get();

    List<AbstractMessage> actualRequests = mockTagBindings.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteTagBindingRequest actualRequest = ((DeleteTagBindingRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteTagBindingExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTagBindings.addException(exception);

    try {
      TagBindingName name = TagBindingName.of("[TAG_BINDING]");
      client.deleteTagBindingAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteTagBindingTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteTagBindingTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockTagBindings.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteTagBindingAsync(name).get();

    List<AbstractMessage> actualRequests = mockTagBindings.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteTagBindingRequest actualRequest = ((DeleteTagBindingRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteTagBindingExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTagBindings.addException(exception);

    try {
      String name = "name3373707";
      client.deleteTagBindingAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }
}
