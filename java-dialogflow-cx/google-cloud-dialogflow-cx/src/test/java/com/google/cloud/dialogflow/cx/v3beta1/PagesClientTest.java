/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.dialogflow.cx.v3beta1;

import static com.google.cloud.dialogflow.cx.v3beta1.PagesClient.ListPagesPagedResponse;

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
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
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
public class PagesClientTest {
  private static MockPages mockPages;
  private static MockServiceHelper mockServiceHelper;
  private PagesClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockPages = new MockPages();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockPages));
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
    PagesSettings settings =
        PagesSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = PagesClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listPagesTest() throws Exception {
    Page responsesElement = Page.newBuilder().build();
    ListPagesResponse expectedResponse =
        ListPagesResponse.newBuilder()
            .setNextPageToken("")
            .addAllPages(Arrays.asList(responsesElement))
            .build();
    mockPages.addResponse(expectedResponse);

    FlowName parent = FlowName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[FLOW]");

    ListPagesPagedResponse pagedListResponse = client.listPages(parent);

    List<Page> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPagesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockPages.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListPagesRequest actualRequest = ((ListPagesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listPagesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPages.addException(exception);

    try {
      FlowName parent = FlowName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[FLOW]");
      client.listPages(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listPagesTest2() throws Exception {
    Page responsesElement = Page.newBuilder().build();
    ListPagesResponse expectedResponse =
        ListPagesResponse.newBuilder()
            .setNextPageToken("")
            .addAllPages(Arrays.asList(responsesElement))
            .build();
    mockPages.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListPagesPagedResponse pagedListResponse = client.listPages(parent);

    List<Page> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPagesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockPages.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListPagesRequest actualRequest = ((ListPagesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listPagesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPages.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listPages(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getPageTest() throws Exception {
    Page expectedResponse =
        Page.newBuilder()
            .setName(
                PageName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[FLOW]", "[PAGE]").toString())
            .setDisplayName("displayName1714148973")
            .setEntryFulfillment(Fulfillment.newBuilder().build())
            .setForm(Form.newBuilder().build())
            .addAllTransitionRouteGroups(new ArrayList<String>())
            .addAllTransitionRoutes(new ArrayList<TransitionRoute>())
            .addAllEventHandlers(new ArrayList<EventHandler>())
            .build();
    mockPages.addResponse(expectedResponse);

    PageName name = PageName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[FLOW]", "[PAGE]");

    Page actualResponse = client.getPage(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPages.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetPageRequest actualRequest = ((GetPageRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getPageExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPages.addException(exception);

    try {
      PageName name = PageName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[FLOW]", "[PAGE]");
      client.getPage(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getPageTest2() throws Exception {
    Page expectedResponse =
        Page.newBuilder()
            .setName(
                PageName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[FLOW]", "[PAGE]").toString())
            .setDisplayName("displayName1714148973")
            .setEntryFulfillment(Fulfillment.newBuilder().build())
            .setForm(Form.newBuilder().build())
            .addAllTransitionRouteGroups(new ArrayList<String>())
            .addAllTransitionRoutes(new ArrayList<TransitionRoute>())
            .addAllEventHandlers(new ArrayList<EventHandler>())
            .build();
    mockPages.addResponse(expectedResponse);

    String name = "name3373707";

    Page actualResponse = client.getPage(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPages.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetPageRequest actualRequest = ((GetPageRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getPageExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPages.addException(exception);

    try {
      String name = "name3373707";
      client.getPage(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createPageTest() throws Exception {
    Page expectedResponse =
        Page.newBuilder()
            .setName(
                PageName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[FLOW]", "[PAGE]").toString())
            .setDisplayName("displayName1714148973")
            .setEntryFulfillment(Fulfillment.newBuilder().build())
            .setForm(Form.newBuilder().build())
            .addAllTransitionRouteGroups(new ArrayList<String>())
            .addAllTransitionRoutes(new ArrayList<TransitionRoute>())
            .addAllEventHandlers(new ArrayList<EventHandler>())
            .build();
    mockPages.addResponse(expectedResponse);

    FlowName parent = FlowName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[FLOW]");
    Page page = Page.newBuilder().build();

    Page actualResponse = client.createPage(parent, page);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPages.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreatePageRequest actualRequest = ((CreatePageRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(page, actualRequest.getPage());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createPageExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPages.addException(exception);

    try {
      FlowName parent = FlowName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[FLOW]");
      Page page = Page.newBuilder().build();
      client.createPage(parent, page);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createPageTest2() throws Exception {
    Page expectedResponse =
        Page.newBuilder()
            .setName(
                PageName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[FLOW]", "[PAGE]").toString())
            .setDisplayName("displayName1714148973")
            .setEntryFulfillment(Fulfillment.newBuilder().build())
            .setForm(Form.newBuilder().build())
            .addAllTransitionRouteGroups(new ArrayList<String>())
            .addAllTransitionRoutes(new ArrayList<TransitionRoute>())
            .addAllEventHandlers(new ArrayList<EventHandler>())
            .build();
    mockPages.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Page page = Page.newBuilder().build();

    Page actualResponse = client.createPage(parent, page);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPages.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreatePageRequest actualRequest = ((CreatePageRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(page, actualRequest.getPage());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createPageExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPages.addException(exception);

    try {
      String parent = "parent-995424086";
      Page page = Page.newBuilder().build();
      client.createPage(parent, page);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updatePageTest() throws Exception {
    Page expectedResponse =
        Page.newBuilder()
            .setName(
                PageName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[FLOW]", "[PAGE]").toString())
            .setDisplayName("displayName1714148973")
            .setEntryFulfillment(Fulfillment.newBuilder().build())
            .setForm(Form.newBuilder().build())
            .addAllTransitionRouteGroups(new ArrayList<String>())
            .addAllTransitionRoutes(new ArrayList<TransitionRoute>())
            .addAllEventHandlers(new ArrayList<EventHandler>())
            .build();
    mockPages.addResponse(expectedResponse);

    Page page = Page.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Page actualResponse = client.updatePage(page, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPages.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdatePageRequest actualRequest = ((UpdatePageRequest) actualRequests.get(0));

    Assert.assertEquals(page, actualRequest.getPage());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updatePageExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPages.addException(exception);

    try {
      Page page = Page.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updatePage(page, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deletePageTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockPages.addResponse(expectedResponse);

    PageName name = PageName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[FLOW]", "[PAGE]");

    client.deletePage(name);

    List<AbstractMessage> actualRequests = mockPages.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeletePageRequest actualRequest = ((DeletePageRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deletePageExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPages.addException(exception);

    try {
      PageName name = PageName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[FLOW]", "[PAGE]");
      client.deletePage(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deletePageTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockPages.addResponse(expectedResponse);

    String name = "name3373707";

    client.deletePage(name);

    List<AbstractMessage> actualRequests = mockPages.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeletePageRequest actualRequest = ((DeletePageRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deletePageExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPages.addException(exception);

    try {
      String name = "name3373707";
      client.deletePage(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
