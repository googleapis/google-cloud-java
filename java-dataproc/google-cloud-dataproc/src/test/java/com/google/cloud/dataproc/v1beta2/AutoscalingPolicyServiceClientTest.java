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
public class AutoscalingPolicyServiceClientTest {
  private static MockAutoscalingPolicyService mockAutoscalingPolicyService;
  private static MockServiceHelper mockServiceHelper;
  private AutoscalingPolicyServiceClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockAutoscalingPolicyService = new MockAutoscalingPolicyService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockAutoscalingPolicyService));
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
  public void createAutoscalingPolicyTest() throws Exception {
    AutoscalingPolicy expectedResponse =
        AutoscalingPolicy.newBuilder()
            .setId("id3355")
            .setName(
                AutoscalingPolicyName.ofProjectLocationAutoscalingPolicyName(
                        "[PROJECT]", "[LOCATION]", "[AUTOSCALING_POLICY]")
                    .toString())
            .setWorkerConfig(InstanceGroupAutoscalingPolicyConfig.newBuilder().build())
            .setSecondaryWorkerConfig(InstanceGroupAutoscalingPolicyConfig.newBuilder().build())
            .build();
    mockAutoscalingPolicyService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    AutoscalingPolicy policy = AutoscalingPolicy.newBuilder().build();

    AutoscalingPolicy actualResponse = client.createAutoscalingPolicy(parent, policy);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAutoscalingPolicyService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateAutoscalingPolicyRequest actualRequest =
        ((CreateAutoscalingPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(policy, actualRequest.getPolicy());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createAutoscalingPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAutoscalingPolicyService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      AutoscalingPolicy policy = AutoscalingPolicy.newBuilder().build();
      client.createAutoscalingPolicy(parent, policy);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createAutoscalingPolicyTest2() throws Exception {
    AutoscalingPolicy expectedResponse =
        AutoscalingPolicy.newBuilder()
            .setId("id3355")
            .setName(
                AutoscalingPolicyName.ofProjectLocationAutoscalingPolicyName(
                        "[PROJECT]", "[LOCATION]", "[AUTOSCALING_POLICY]")
                    .toString())
            .setWorkerConfig(InstanceGroupAutoscalingPolicyConfig.newBuilder().build())
            .setSecondaryWorkerConfig(InstanceGroupAutoscalingPolicyConfig.newBuilder().build())
            .build();
    mockAutoscalingPolicyService.addResponse(expectedResponse);

    RegionName parent = RegionName.of("[PROJECT]", "[REGION]");
    AutoscalingPolicy policy = AutoscalingPolicy.newBuilder().build();

    AutoscalingPolicy actualResponse = client.createAutoscalingPolicy(parent, policy);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAutoscalingPolicyService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateAutoscalingPolicyRequest actualRequest =
        ((CreateAutoscalingPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(policy, actualRequest.getPolicy());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createAutoscalingPolicyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAutoscalingPolicyService.addException(exception);

    try {
      RegionName parent = RegionName.of("[PROJECT]", "[REGION]");
      AutoscalingPolicy policy = AutoscalingPolicy.newBuilder().build();
      client.createAutoscalingPolicy(parent, policy);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createAutoscalingPolicyTest3() throws Exception {
    AutoscalingPolicy expectedResponse =
        AutoscalingPolicy.newBuilder()
            .setId("id3355")
            .setName(
                AutoscalingPolicyName.ofProjectLocationAutoscalingPolicyName(
                        "[PROJECT]", "[LOCATION]", "[AUTOSCALING_POLICY]")
                    .toString())
            .setWorkerConfig(InstanceGroupAutoscalingPolicyConfig.newBuilder().build())
            .setSecondaryWorkerConfig(InstanceGroupAutoscalingPolicyConfig.newBuilder().build())
            .build();
    mockAutoscalingPolicyService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    AutoscalingPolicy policy = AutoscalingPolicy.newBuilder().build();

    AutoscalingPolicy actualResponse = client.createAutoscalingPolicy(parent, policy);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAutoscalingPolicyService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateAutoscalingPolicyRequest actualRequest =
        ((CreateAutoscalingPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(policy, actualRequest.getPolicy());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createAutoscalingPolicyExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAutoscalingPolicyService.addException(exception);

    try {
      String parent = "parent-995424086";
      AutoscalingPolicy policy = AutoscalingPolicy.newBuilder().build();
      client.createAutoscalingPolicy(parent, policy);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateAutoscalingPolicyTest() throws Exception {
    AutoscalingPolicy expectedResponse =
        AutoscalingPolicy.newBuilder()
            .setId("id3355")
            .setName(
                AutoscalingPolicyName.ofProjectLocationAutoscalingPolicyName(
                        "[PROJECT]", "[LOCATION]", "[AUTOSCALING_POLICY]")
                    .toString())
            .setWorkerConfig(InstanceGroupAutoscalingPolicyConfig.newBuilder().build())
            .setSecondaryWorkerConfig(InstanceGroupAutoscalingPolicyConfig.newBuilder().build())
            .build();
    mockAutoscalingPolicyService.addResponse(expectedResponse);

    AutoscalingPolicy policy = AutoscalingPolicy.newBuilder().build();

    AutoscalingPolicy actualResponse = client.updateAutoscalingPolicy(policy);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAutoscalingPolicyService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateAutoscalingPolicyRequest actualRequest =
        ((UpdateAutoscalingPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(policy, actualRequest.getPolicy());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateAutoscalingPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAutoscalingPolicyService.addException(exception);

    try {
      AutoscalingPolicy policy = AutoscalingPolicy.newBuilder().build();
      client.updateAutoscalingPolicy(policy);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAutoscalingPolicyTest() throws Exception {
    AutoscalingPolicy expectedResponse =
        AutoscalingPolicy.newBuilder()
            .setId("id3355")
            .setName(
                AutoscalingPolicyName.ofProjectLocationAutoscalingPolicyName(
                        "[PROJECT]", "[LOCATION]", "[AUTOSCALING_POLICY]")
                    .toString())
            .setWorkerConfig(InstanceGroupAutoscalingPolicyConfig.newBuilder().build())
            .setSecondaryWorkerConfig(InstanceGroupAutoscalingPolicyConfig.newBuilder().build())
            .build();
    mockAutoscalingPolicyService.addResponse(expectedResponse);

    AutoscalingPolicyName name =
        AutoscalingPolicyName.ofProjectLocationAutoscalingPolicyName(
            "[PROJECT]", "[LOCATION]", "[AUTOSCALING_POLICY]");

    AutoscalingPolicy actualResponse = client.getAutoscalingPolicy(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAutoscalingPolicyService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAutoscalingPolicyRequest actualRequest =
        ((GetAutoscalingPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAutoscalingPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAutoscalingPolicyService.addException(exception);

    try {
      AutoscalingPolicyName name =
          AutoscalingPolicyName.ofProjectLocationAutoscalingPolicyName(
              "[PROJECT]", "[LOCATION]", "[AUTOSCALING_POLICY]");
      client.getAutoscalingPolicy(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAutoscalingPolicyTest2() throws Exception {
    AutoscalingPolicy expectedResponse =
        AutoscalingPolicy.newBuilder()
            .setId("id3355")
            .setName(
                AutoscalingPolicyName.ofProjectLocationAutoscalingPolicyName(
                        "[PROJECT]", "[LOCATION]", "[AUTOSCALING_POLICY]")
                    .toString())
            .setWorkerConfig(InstanceGroupAutoscalingPolicyConfig.newBuilder().build())
            .setSecondaryWorkerConfig(InstanceGroupAutoscalingPolicyConfig.newBuilder().build())
            .build();
    mockAutoscalingPolicyService.addResponse(expectedResponse);

    String name = "name3373707";

    AutoscalingPolicy actualResponse = client.getAutoscalingPolicy(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAutoscalingPolicyService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAutoscalingPolicyRequest actualRequest =
        ((GetAutoscalingPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAutoscalingPolicyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAutoscalingPolicyService.addException(exception);

    try {
      String name = "name3373707";
      client.getAutoscalingPolicy(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAutoscalingPoliciesTest() throws Exception {
    AutoscalingPolicy responsesElement = AutoscalingPolicy.newBuilder().build();
    ListAutoscalingPoliciesResponse expectedResponse =
        ListAutoscalingPoliciesResponse.newBuilder()
            .setNextPageToken("")
            .addAllPolicies(Arrays.asList(responsesElement))
            .build();
    mockAutoscalingPolicyService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListAutoscalingPoliciesPagedResponse pagedListResponse = client.listAutoscalingPolicies(parent);

    List<AutoscalingPolicy> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPoliciesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAutoscalingPolicyService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAutoscalingPoliciesRequest actualRequest =
        ((ListAutoscalingPoliciesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAutoscalingPoliciesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAutoscalingPolicyService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listAutoscalingPolicies(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAutoscalingPoliciesTest2() throws Exception {
    AutoscalingPolicy responsesElement = AutoscalingPolicy.newBuilder().build();
    ListAutoscalingPoliciesResponse expectedResponse =
        ListAutoscalingPoliciesResponse.newBuilder()
            .setNextPageToken("")
            .addAllPolicies(Arrays.asList(responsesElement))
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
        ((ListAutoscalingPoliciesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAutoscalingPoliciesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAutoscalingPolicyService.addException(exception);

    try {
      RegionName parent = RegionName.of("[PROJECT]", "[REGION]");
      client.listAutoscalingPolicies(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAutoscalingPoliciesTest3() throws Exception {
    AutoscalingPolicy responsesElement = AutoscalingPolicy.newBuilder().build();
    ListAutoscalingPoliciesResponse expectedResponse =
        ListAutoscalingPoliciesResponse.newBuilder()
            .setNextPageToken("")
            .addAllPolicies(Arrays.asList(responsesElement))
            .build();
    mockAutoscalingPolicyService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListAutoscalingPoliciesPagedResponse pagedListResponse = client.listAutoscalingPolicies(parent);

    List<AutoscalingPolicy> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPoliciesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAutoscalingPolicyService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAutoscalingPoliciesRequest actualRequest =
        ((ListAutoscalingPoliciesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAutoscalingPoliciesExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAutoscalingPolicyService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listAutoscalingPolicies(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteAutoscalingPolicyTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockAutoscalingPolicyService.addResponse(expectedResponse);

    AutoscalingPolicyName name =
        AutoscalingPolicyName.ofProjectLocationAutoscalingPolicyName(
            "[PROJECT]", "[LOCATION]", "[AUTOSCALING_POLICY]");

    client.deleteAutoscalingPolicy(name);

    List<AbstractMessage> actualRequests = mockAutoscalingPolicyService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteAutoscalingPolicyRequest actualRequest =
        ((DeleteAutoscalingPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteAutoscalingPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAutoscalingPolicyService.addException(exception);

    try {
      AutoscalingPolicyName name =
          AutoscalingPolicyName.ofProjectLocationAutoscalingPolicyName(
              "[PROJECT]", "[LOCATION]", "[AUTOSCALING_POLICY]");
      client.deleteAutoscalingPolicy(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteAutoscalingPolicyTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockAutoscalingPolicyService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteAutoscalingPolicy(name);

    List<AbstractMessage> actualRequests = mockAutoscalingPolicyService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteAutoscalingPolicyRequest actualRequest =
        ((DeleteAutoscalingPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteAutoscalingPolicyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAutoscalingPolicyService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteAutoscalingPolicy(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
