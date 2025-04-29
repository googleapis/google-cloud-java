/*
 * Copyright 2025 Google LLC
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

package com.google.shopping.merchant.issueresolution.v1beta;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.protobuf.AbstractMessage;
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
public class IssueResolutionServiceClientTest {
  private static MockIssueResolutionService mockIssueResolutionService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private IssueResolutionServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockIssueResolutionService = new MockIssueResolutionService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockIssueResolutionService));
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
    IssueResolutionServiceSettings settings =
        IssueResolutionServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = IssueResolutionServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void renderAccountIssuesTest() throws Exception {
    RenderAccountIssuesResponse expectedResponse =
        RenderAccountIssuesResponse.newBuilder()
            .addAllRenderedIssues(new ArrayList<RenderedIssue>())
            .build();
    mockIssueResolutionService.addResponse(expectedResponse);

    AccountName name = AccountName.of("[ACCOUNT]");

    RenderAccountIssuesResponse actualResponse = client.renderAccountIssues(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIssueResolutionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RenderAccountIssuesRequest actualRequest = ((RenderAccountIssuesRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void renderAccountIssuesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIssueResolutionService.addException(exception);

    try {
      AccountName name = AccountName.of("[ACCOUNT]");
      client.renderAccountIssues(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void renderAccountIssuesTest2() throws Exception {
    RenderAccountIssuesResponse expectedResponse =
        RenderAccountIssuesResponse.newBuilder()
            .addAllRenderedIssues(new ArrayList<RenderedIssue>())
            .build();
    mockIssueResolutionService.addResponse(expectedResponse);

    String name = "name3373707";

    RenderAccountIssuesResponse actualResponse = client.renderAccountIssues(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIssueResolutionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RenderAccountIssuesRequest actualRequest = ((RenderAccountIssuesRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void renderAccountIssuesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIssueResolutionService.addException(exception);

    try {
      String name = "name3373707";
      client.renderAccountIssues(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void renderProductIssuesTest() throws Exception {
    RenderProductIssuesResponse expectedResponse =
        RenderProductIssuesResponse.newBuilder()
            .addAllRenderedIssues(new ArrayList<RenderedIssue>())
            .build();
    mockIssueResolutionService.addResponse(expectedResponse);

    ProductName name = ProductName.of("[ACCOUNT]", "[PRODUCT]");

    RenderProductIssuesResponse actualResponse = client.renderProductIssues(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIssueResolutionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RenderProductIssuesRequest actualRequest = ((RenderProductIssuesRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void renderProductIssuesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIssueResolutionService.addException(exception);

    try {
      ProductName name = ProductName.of("[ACCOUNT]", "[PRODUCT]");
      client.renderProductIssues(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void renderProductIssuesTest2() throws Exception {
    RenderProductIssuesResponse expectedResponse =
        RenderProductIssuesResponse.newBuilder()
            .addAllRenderedIssues(new ArrayList<RenderedIssue>())
            .build();
    mockIssueResolutionService.addResponse(expectedResponse);

    String name = "name3373707";

    RenderProductIssuesResponse actualResponse = client.renderProductIssues(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIssueResolutionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RenderProductIssuesRequest actualRequest = ((RenderProductIssuesRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void renderProductIssuesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIssueResolutionService.addException(exception);

    try {
      String name = "name3373707";
      client.renderProductIssues(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void triggerActionTest() throws Exception {
    TriggerActionResponse expectedResponse =
        TriggerActionResponse.newBuilder().setMessage("message954925063").build();
    mockIssueResolutionService.addResponse(expectedResponse);

    AccountName name = AccountName.of("[ACCOUNT]");

    TriggerActionResponse actualResponse = client.triggerAction(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIssueResolutionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    TriggerActionRequest actualRequest = ((TriggerActionRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void triggerActionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIssueResolutionService.addException(exception);

    try {
      AccountName name = AccountName.of("[ACCOUNT]");
      client.triggerAction(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void triggerActionTest2() throws Exception {
    TriggerActionResponse expectedResponse =
        TriggerActionResponse.newBuilder().setMessage("message954925063").build();
    mockIssueResolutionService.addResponse(expectedResponse);

    String name = "name3373707";

    TriggerActionResponse actualResponse = client.triggerAction(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIssueResolutionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    TriggerActionRequest actualRequest = ((TriggerActionRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void triggerActionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIssueResolutionService.addException(exception);

    try {
      String name = "name3373707";
      client.triggerAction(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
