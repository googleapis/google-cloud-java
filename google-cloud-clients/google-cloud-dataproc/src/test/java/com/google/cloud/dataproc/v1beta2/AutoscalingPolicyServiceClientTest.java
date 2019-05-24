/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.dataproc.v1beta2;

import static com.google.cloud.dataproc.v1beta2.AutoscalingPolicyServiceClient.ListAutoscalingPoliciesPagedResponse;

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
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@javax.annotation.Generated("by GAPIC")
public class AutoscalingPolicyServiceClientTest {
  private static MockAutoscalingPolicyService mockAutoscalingPolicyService;
  private static MockClusterController mockClusterController;
  private static MockJobController mockJobController;
  private static MockWorkflowTemplateService mockWorkflowTemplateService;
  private static MockServiceHelper serviceHelper;
  private AutoscalingPolicyServiceClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockAutoscalingPolicyService = new MockAutoscalingPolicyService();
    mockClusterController = new MockClusterController();
    mockJobController = new MockJobController();
    mockWorkflowTemplateService = new MockWorkflowTemplateService();
    serviceHelper =
        new MockServiceHelper(
            "in-process-1",
            Arrays.<MockGrpcService>asList(
                mockAutoscalingPolicyService,
                mockClusterController,
                mockJobController,
                mockWorkflowTemplateService));
    serviceHelper.start();
  }

  @AfterClass
  public static void stopServer() {
    serviceHelper.stop();
  }

  @Before
  public void setUp() throws IOException {
    serviceHelper.reset();
    channelProvider = serviceHelper.createChannelProvider();
    AutoscalingPolicyServiceSettings settings =
        AutoscalingPolicyServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = AutoscalingPolicyServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void createAutoscalingPolicyTest() {
    String id = "id3355";
    AutoscalingPolicyName name =
        AutoscalingPolicyName.of("[PROJECT]", "[REGION]", "[AUTOSCALING_POLICY]");
    AutoscalingPolicy expectedResponse =
        AutoscalingPolicy.newBuilder().setId(id).setName(name.toString()).build();
    mockAutoscalingPolicyService.addResponse(expectedResponse);

    RegionName parent = RegionName.of("[PROJECT]", "[REGION]");
    AutoscalingPolicy policy = AutoscalingPolicy.newBuilder().build();

    AutoscalingPolicy actualResponse = client.createAutoscalingPolicy(parent, policy);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAutoscalingPolicyService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateAutoscalingPolicyRequest actualRequest =
        (CreateAutoscalingPolicyRequest) actualRequests.get(0);

    Assert.assertEquals(parent, RegionName.parse(actualRequest.getParent()));
    Assert.assertEquals(policy, actualRequest.getPolicy());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createAutoscalingPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockAutoscalingPolicyService.addException(exception);

    try {
      RegionName parent = RegionName.of("[PROJECT]", "[REGION]");
      AutoscalingPolicy policy = AutoscalingPolicy.newBuilder().build();

      client.createAutoscalingPolicy(parent, policy);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateAutoscalingPolicyTest() {
    String id = "id3355";
    AutoscalingPolicyName name =
        AutoscalingPolicyName.of("[PROJECT]", "[REGION]", "[AUTOSCALING_POLICY]");
    AutoscalingPolicy expectedResponse =
        AutoscalingPolicy.newBuilder().setId(id).setName(name.toString()).build();
    mockAutoscalingPolicyService.addResponse(expectedResponse);

    AutoscalingPolicy policy = AutoscalingPolicy.newBuilder().build();

    AutoscalingPolicy actualResponse = client.updateAutoscalingPolicy(policy);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAutoscalingPolicyService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateAutoscalingPolicyRequest actualRequest =
        (UpdateAutoscalingPolicyRequest) actualRequests.get(0);

    Assert.assertEquals(policy, actualRequest.getPolicy());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void updateAutoscalingPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockAutoscalingPolicyService.addException(exception);

    try {
      AutoscalingPolicy policy = AutoscalingPolicy.newBuilder().build();

      client.updateAutoscalingPolicy(policy);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getAutoscalingPolicyTest() {
    String id = "id3355";
    AutoscalingPolicyName name2 =
        AutoscalingPolicyName.of("[PROJECT]", "[REGION]", "[AUTOSCALING_POLICY]");
    AutoscalingPolicy expectedResponse =
        AutoscalingPolicy.newBuilder().setId(id).setName(name2.toString()).build();
    mockAutoscalingPolicyService.addResponse(expectedResponse);

    AutoscalingPolicyName name =
        AutoscalingPolicyName.of("[PROJECT]", "[REGION]", "[AUTOSCALING_POLICY]");

    AutoscalingPolicy actualResponse = client.getAutoscalingPolicy(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAutoscalingPolicyService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAutoscalingPolicyRequest actualRequest = (GetAutoscalingPolicyRequest) actualRequests.get(0);

    Assert.assertEquals(name, AutoscalingPolicyName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getAutoscalingPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockAutoscalingPolicyService.addException(exception);

    try {
      AutoscalingPolicyName name =
          AutoscalingPolicyName.of("[PROJECT]", "[REGION]", "[AUTOSCALING_POLICY]");

      client.getAutoscalingPolicy(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listAutoscalingPoliciesTest() {
    String nextPageToken = "";
    AutoscalingPolicy policiesElement = AutoscalingPolicy.newBuilder().build();
    List<AutoscalingPolicy> policies = Arrays.asList(policiesElement);
    ListAutoscalingPoliciesResponse expectedResponse =
        ListAutoscalingPoliciesResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllPolicies(policies)
            .build();
    mockAutoscalingPolicyService.addResponse(expectedResponse);

    RegionName parent = RegionName.of("[PROJECT]", "[REGION]");

    ListAutoscalingPoliciesPagedResponse pagedListResponse = client.listAutoscalingPolicies(parent);

    List<AutoscalingPolicy> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPoliciesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAutoscalingPolicyService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAutoscalingPoliciesRequest actualRequest =
        (ListAutoscalingPoliciesRequest) actualRequests.get(0);

    Assert.assertEquals(parent, RegionName.parse(actualRequest.getParent()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listAutoscalingPoliciesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockAutoscalingPolicyService.addException(exception);

    try {
      RegionName parent = RegionName.of("[PROJECT]", "[REGION]");

      client.listAutoscalingPolicies(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deleteAutoscalingPolicyTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    mockAutoscalingPolicyService.addResponse(expectedResponse);

    AutoscalingPolicyName name =
        AutoscalingPolicyName.of("[PROJECT]", "[REGION]", "[AUTOSCALING_POLICY]");

    client.deleteAutoscalingPolicy(name);

    List<AbstractMessage> actualRequests = mockAutoscalingPolicyService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteAutoscalingPolicyRequest actualRequest =
        (DeleteAutoscalingPolicyRequest) actualRequests.get(0);

    Assert.assertEquals(name, AutoscalingPolicyName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void deleteAutoscalingPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockAutoscalingPolicyService.addException(exception);

    try {
      AutoscalingPolicyName name =
          AutoscalingPolicyName.of("[PROJECT]", "[REGION]", "[AUTOSCALING_POLICY]");

      client.deleteAutoscalingPolicy(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }
}
