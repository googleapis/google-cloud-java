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

package com.google.cloud.dataproc.v1;

import static com.google.cloud.dataproc.v1.AutoscalingPolicyServiceClient.ListAutoscalingPoliciesPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.common.collect.Lists;
import com.google.iam.v1.AuditConfig;
import com.google.iam.v1.Binding;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.GetPolicyOptions;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.ByteString;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
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
public class AutoscalingPolicyServiceClientTest {
  private static MockAutoscalingPolicyService mockAutoscalingPolicyService;
  private static MockIAMPolicy mockIAMPolicy;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private AutoscalingPolicyServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockAutoscalingPolicyService = new MockAutoscalingPolicyService();
    mockIAMPolicy = new MockIAMPolicy();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockAutoscalingPolicyService, mockIAMPolicy));
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
            .putAllLabels(new HashMap<String, String>())
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
            .putAllLabels(new HashMap<String, String>())
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
            .putAllLabels(new HashMap<String, String>())
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
            .putAllLabels(new HashMap<String, String>())
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
            .putAllLabels(new HashMap<String, String>())
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
            .putAllLabels(new HashMap<String, String>())
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

  @Test
  public void setIamPolicyTest() throws Exception {
    Policy expectedResponse =
        Policy.newBuilder()
            .setVersion(351608024)
            .addAllBindings(new ArrayList<Binding>())
            .addAllAuditConfigs(new ArrayList<AuditConfig>())
            .setEtag(ByteString.EMPTY)
            .build();
    mockIAMPolicy.addResponse(expectedResponse);

    SetIamPolicyRequest request =
        SetIamPolicyRequest.newBuilder()
            .setResource(
                AutoscalingPolicyName.ofProjectRegionAutoscalingPolicyName(
                        "[PROJECT]", "[REGION]", "[AUTOSCALING_POLICY]")
                    .toString())
            .setPolicy(Policy.newBuilder().build())
            .setUpdateMask(FieldMask.newBuilder().build())
            .build();

    Policy actualResponse = client.setIamPolicy(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIAMPolicy.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SetIamPolicyRequest actualRequest = ((SetIamPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(request.getResource(), actualRequest.getResource());
    Assert.assertEquals(request.getPolicy(), actualRequest.getPolicy());
    Assert.assertEquals(request.getUpdateMask(), actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void setIamPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIAMPolicy.addException(exception);

    try {
      SetIamPolicyRequest request =
          SetIamPolicyRequest.newBuilder()
              .setResource(
                  AutoscalingPolicyName.ofProjectRegionAutoscalingPolicyName(
                          "[PROJECT]", "[REGION]", "[AUTOSCALING_POLICY]")
                      .toString())
              .setPolicy(Policy.newBuilder().build())
              .setUpdateMask(FieldMask.newBuilder().build())
              .build();
      client.setIamPolicy(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getIamPolicyTest() throws Exception {
    Policy expectedResponse =
        Policy.newBuilder()
            .setVersion(351608024)
            .addAllBindings(new ArrayList<Binding>())
            .addAllAuditConfigs(new ArrayList<AuditConfig>())
            .setEtag(ByteString.EMPTY)
            .build();
    mockIAMPolicy.addResponse(expectedResponse);

    GetIamPolicyRequest request =
        GetIamPolicyRequest.newBuilder()
            .setResource(
                AutoscalingPolicyName.ofProjectRegionAutoscalingPolicyName(
                        "[PROJECT]", "[REGION]", "[AUTOSCALING_POLICY]")
                    .toString())
            .setOptions(GetPolicyOptions.newBuilder().build())
            .build();

    Policy actualResponse = client.getIamPolicy(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIAMPolicy.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetIamPolicyRequest actualRequest = ((GetIamPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(request.getResource(), actualRequest.getResource());
    Assert.assertEquals(request.getOptions(), actualRequest.getOptions());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getIamPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIAMPolicy.addException(exception);

    try {
      GetIamPolicyRequest request =
          GetIamPolicyRequest.newBuilder()
              .setResource(
                  AutoscalingPolicyName.ofProjectRegionAutoscalingPolicyName(
                          "[PROJECT]", "[REGION]", "[AUTOSCALING_POLICY]")
                      .toString())
              .setOptions(GetPolicyOptions.newBuilder().build())
              .build();
      client.getIamPolicy(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void testIamPermissionsTest() throws Exception {
    TestIamPermissionsResponse expectedResponse =
        TestIamPermissionsResponse.newBuilder().addAllPermissions(new ArrayList<String>()).build();
    mockIAMPolicy.addResponse(expectedResponse);

    TestIamPermissionsRequest request =
        TestIamPermissionsRequest.newBuilder()
            .setResource(
                AutoscalingPolicyName.ofProjectRegionAutoscalingPolicyName(
                        "[PROJECT]", "[REGION]", "[AUTOSCALING_POLICY]")
                    .toString())
            .addAllPermissions(new ArrayList<String>())
            .build();

    TestIamPermissionsResponse actualResponse = client.testIamPermissions(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIAMPolicy.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    TestIamPermissionsRequest actualRequest = ((TestIamPermissionsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getResource(), actualRequest.getResource());
    Assert.assertEquals(request.getPermissionsList(), actualRequest.getPermissionsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void testIamPermissionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIAMPolicy.addException(exception);

    try {
      TestIamPermissionsRequest request =
          TestIamPermissionsRequest.newBuilder()
              .setResource(
                  AutoscalingPolicyName.ofProjectRegionAutoscalingPolicyName(
                          "[PROJECT]", "[REGION]", "[AUTOSCALING_POLICY]")
                      .toString())
              .addAllPermissions(new ArrayList<String>())
              .build();
      client.testIamPermissions(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
