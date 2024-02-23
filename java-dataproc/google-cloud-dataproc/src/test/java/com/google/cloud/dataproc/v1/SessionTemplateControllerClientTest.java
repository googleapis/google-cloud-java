/*
 * Copyright 2024 Google LLC
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

import static com.google.cloud.dataproc.v1.SessionTemplateControllerClient.ListSessionTemplatesPagedResponse;

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
import com.google.protobuf.Timestamp;
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
public class SessionTemplateControllerClientTest {
  private static MockIAMPolicy mockIAMPolicy;
  private static MockServiceHelper mockServiceHelper;
  private static MockSessionTemplateController mockSessionTemplateController;
  private LocalChannelProvider channelProvider;
  private SessionTemplateControllerClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockSessionTemplateController = new MockSessionTemplateController();
    mockIAMPolicy = new MockIAMPolicy();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockSessionTemplateController, mockIAMPolicy));
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
    SessionTemplateControllerSettings settings =
        SessionTemplateControllerSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = SessionTemplateControllerClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createSessionTemplateTest() throws Exception {
    SessionTemplate expectedResponse =
        SessionTemplate.newBuilder()
            .setName(SessionTemplateName.of("[PROJECT]", "[LOCATION]", "[TEMPLATE]").toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setCreator("creator1028554796")
            .putAllLabels(new HashMap<String, String>())
            .setRuntimeConfig(RuntimeConfig.newBuilder().build())
            .setEnvironmentConfig(EnvironmentConfig.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setUuid("uuid3601339")
            .build();
    mockSessionTemplateController.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    SessionTemplate sessionTemplate = SessionTemplate.newBuilder().build();

    SessionTemplate actualResponse = client.createSessionTemplate(parent, sessionTemplate);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSessionTemplateController.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateSessionTemplateRequest actualRequest =
        ((CreateSessionTemplateRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(sessionTemplate, actualRequest.getSessionTemplate());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createSessionTemplateExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSessionTemplateController.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      SessionTemplate sessionTemplate = SessionTemplate.newBuilder().build();
      client.createSessionTemplate(parent, sessionTemplate);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createSessionTemplateTest2() throws Exception {
    SessionTemplate expectedResponse =
        SessionTemplate.newBuilder()
            .setName(SessionTemplateName.of("[PROJECT]", "[LOCATION]", "[TEMPLATE]").toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setCreator("creator1028554796")
            .putAllLabels(new HashMap<String, String>())
            .setRuntimeConfig(RuntimeConfig.newBuilder().build())
            .setEnvironmentConfig(EnvironmentConfig.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setUuid("uuid3601339")
            .build();
    mockSessionTemplateController.addResponse(expectedResponse);

    String parent = "parent-995424086";
    SessionTemplate sessionTemplate = SessionTemplate.newBuilder().build();

    SessionTemplate actualResponse = client.createSessionTemplate(parent, sessionTemplate);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSessionTemplateController.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateSessionTemplateRequest actualRequest =
        ((CreateSessionTemplateRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(sessionTemplate, actualRequest.getSessionTemplate());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createSessionTemplateExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSessionTemplateController.addException(exception);

    try {
      String parent = "parent-995424086";
      SessionTemplate sessionTemplate = SessionTemplate.newBuilder().build();
      client.createSessionTemplate(parent, sessionTemplate);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateSessionTemplateTest() throws Exception {
    SessionTemplate expectedResponse =
        SessionTemplate.newBuilder()
            .setName(SessionTemplateName.of("[PROJECT]", "[LOCATION]", "[TEMPLATE]").toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setCreator("creator1028554796")
            .putAllLabels(new HashMap<String, String>())
            .setRuntimeConfig(RuntimeConfig.newBuilder().build())
            .setEnvironmentConfig(EnvironmentConfig.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setUuid("uuid3601339")
            .build();
    mockSessionTemplateController.addResponse(expectedResponse);

    SessionTemplate sessionTemplate = SessionTemplate.newBuilder().build();

    SessionTemplate actualResponse = client.updateSessionTemplate(sessionTemplate);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSessionTemplateController.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateSessionTemplateRequest actualRequest =
        ((UpdateSessionTemplateRequest) actualRequests.get(0));

    Assert.assertEquals(sessionTemplate, actualRequest.getSessionTemplate());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateSessionTemplateExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSessionTemplateController.addException(exception);

    try {
      SessionTemplate sessionTemplate = SessionTemplate.newBuilder().build();
      client.updateSessionTemplate(sessionTemplate);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSessionTemplateTest() throws Exception {
    SessionTemplate expectedResponse =
        SessionTemplate.newBuilder()
            .setName(SessionTemplateName.of("[PROJECT]", "[LOCATION]", "[TEMPLATE]").toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setCreator("creator1028554796")
            .putAllLabels(new HashMap<String, String>())
            .setRuntimeConfig(RuntimeConfig.newBuilder().build())
            .setEnvironmentConfig(EnvironmentConfig.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setUuid("uuid3601339")
            .build();
    mockSessionTemplateController.addResponse(expectedResponse);

    SessionTemplateName name = SessionTemplateName.of("[PROJECT]", "[LOCATION]", "[TEMPLATE]");

    SessionTemplate actualResponse = client.getSessionTemplate(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSessionTemplateController.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSessionTemplateRequest actualRequest = ((GetSessionTemplateRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getSessionTemplateExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSessionTemplateController.addException(exception);

    try {
      SessionTemplateName name = SessionTemplateName.of("[PROJECT]", "[LOCATION]", "[TEMPLATE]");
      client.getSessionTemplate(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSessionTemplateTest2() throws Exception {
    SessionTemplate expectedResponse =
        SessionTemplate.newBuilder()
            .setName(SessionTemplateName.of("[PROJECT]", "[LOCATION]", "[TEMPLATE]").toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setCreator("creator1028554796")
            .putAllLabels(new HashMap<String, String>())
            .setRuntimeConfig(RuntimeConfig.newBuilder().build())
            .setEnvironmentConfig(EnvironmentConfig.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setUuid("uuid3601339")
            .build();
    mockSessionTemplateController.addResponse(expectedResponse);

    String name = "name3373707";

    SessionTemplate actualResponse = client.getSessionTemplate(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSessionTemplateController.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSessionTemplateRequest actualRequest = ((GetSessionTemplateRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getSessionTemplateExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSessionTemplateController.addException(exception);

    try {
      String name = "name3373707";
      client.getSessionTemplate(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSessionTemplatesTest() throws Exception {
    SessionTemplate responsesElement = SessionTemplate.newBuilder().build();
    ListSessionTemplatesResponse expectedResponse =
        ListSessionTemplatesResponse.newBuilder()
            .setNextPageToken("")
            .addAllSessionTemplates(Arrays.asList(responsesElement))
            .build();
    mockSessionTemplateController.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListSessionTemplatesPagedResponse pagedListResponse = client.listSessionTemplates(parent);

    List<SessionTemplate> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSessionTemplatesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSessionTemplateController.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListSessionTemplatesRequest actualRequest =
        ((ListSessionTemplatesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listSessionTemplatesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSessionTemplateController.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listSessionTemplates(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSessionTemplatesTest2() throws Exception {
    SessionTemplate responsesElement = SessionTemplate.newBuilder().build();
    ListSessionTemplatesResponse expectedResponse =
        ListSessionTemplatesResponse.newBuilder()
            .setNextPageToken("")
            .addAllSessionTemplates(Arrays.asList(responsesElement))
            .build();
    mockSessionTemplateController.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListSessionTemplatesPagedResponse pagedListResponse = client.listSessionTemplates(parent);

    List<SessionTemplate> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSessionTemplatesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSessionTemplateController.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListSessionTemplatesRequest actualRequest =
        ((ListSessionTemplatesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listSessionTemplatesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSessionTemplateController.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listSessionTemplates(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteSessionTemplateTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockSessionTemplateController.addResponse(expectedResponse);

    SessionTemplateName name = SessionTemplateName.of("[PROJECT]", "[LOCATION]", "[TEMPLATE]");

    client.deleteSessionTemplate(name);

    List<AbstractMessage> actualRequests = mockSessionTemplateController.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteSessionTemplateRequest actualRequest =
        ((DeleteSessionTemplateRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteSessionTemplateExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSessionTemplateController.addException(exception);

    try {
      SessionTemplateName name = SessionTemplateName.of("[PROJECT]", "[LOCATION]", "[TEMPLATE]");
      client.deleteSessionTemplate(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteSessionTemplateTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockSessionTemplateController.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteSessionTemplate(name);

    List<AbstractMessage> actualRequests = mockSessionTemplateController.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteSessionTemplateRequest actualRequest =
        ((DeleteSessionTemplateRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteSessionTemplateExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSessionTemplateController.addException(exception);

    try {
      String name = "name3373707";
      client.deleteSessionTemplate(name);
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
