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

package com.google.cloud.monitoring.v3;

import static com.google.cloud.monitoring.v3.AlertPolicyServiceClient.ListAlertPoliciesPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.common.collect.Lists;
import com.google.monitoring.v3.AlertPolicy;
import com.google.monitoring.v3.AlertPolicyName;
import com.google.monitoring.v3.CreateAlertPolicyRequest;
import com.google.monitoring.v3.DeleteAlertPolicyRequest;
import com.google.monitoring.v3.FolderName;
import com.google.monitoring.v3.GetAlertPolicyRequest;
import com.google.monitoring.v3.ListAlertPoliciesRequest;
import com.google.monitoring.v3.ListAlertPoliciesResponse;
import com.google.monitoring.v3.MutationRecord;
import com.google.monitoring.v3.OrganizationName;
import com.google.monitoring.v3.ProjectName;
import com.google.monitoring.v3.UpdateAlertPolicyRequest;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.BoolValue;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.rpc.Status;
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
public class AlertPolicyServiceClientTest {
  private static MockServiceHelper mockServiceHelper;
  private AlertPolicyServiceClient client;
  private static MockAlertPolicyService mockAlertPolicyService;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockAlertPolicyService = new MockAlertPolicyService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockAlertPolicyService));
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
    AlertPolicyServiceSettings settings =
        AlertPolicyServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = AlertPolicyServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listAlertPoliciesTest() throws Exception {
    AlertPolicy responsesElement = AlertPolicy.newBuilder().build();
    ListAlertPoliciesResponse expectedResponse =
        ListAlertPoliciesResponse.newBuilder()
            .setNextPageToken("")
            .addAllAlertPolicies(Arrays.asList(responsesElement))
            .build();
    mockAlertPolicyService.addResponse(expectedResponse);

    FolderName name = FolderName.of("[FOLDER]");

    ListAlertPoliciesPagedResponse pagedListResponse = client.listAlertPolicies(name);

    List<AlertPolicy> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAlertPoliciesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAlertPolicyService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAlertPoliciesRequest actualRequest = ((ListAlertPoliciesRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAlertPoliciesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAlertPolicyService.addException(exception);

    try {
      FolderName name = FolderName.of("[FOLDER]");
      client.listAlertPolicies(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAlertPoliciesTest2() throws Exception {
    AlertPolicy responsesElement = AlertPolicy.newBuilder().build();
    ListAlertPoliciesResponse expectedResponse =
        ListAlertPoliciesResponse.newBuilder()
            .setNextPageToken("")
            .addAllAlertPolicies(Arrays.asList(responsesElement))
            .build();
    mockAlertPolicyService.addResponse(expectedResponse);

    OrganizationName name = OrganizationName.of("[ORGANIZATION]");

    ListAlertPoliciesPagedResponse pagedListResponse = client.listAlertPolicies(name);

    List<AlertPolicy> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAlertPoliciesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAlertPolicyService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAlertPoliciesRequest actualRequest = ((ListAlertPoliciesRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAlertPoliciesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAlertPolicyService.addException(exception);

    try {
      OrganizationName name = OrganizationName.of("[ORGANIZATION]");
      client.listAlertPolicies(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAlertPoliciesTest3() throws Exception {
    AlertPolicy responsesElement = AlertPolicy.newBuilder().build();
    ListAlertPoliciesResponse expectedResponse =
        ListAlertPoliciesResponse.newBuilder()
            .setNextPageToken("")
            .addAllAlertPolicies(Arrays.asList(responsesElement))
            .build();
    mockAlertPolicyService.addResponse(expectedResponse);

    ProjectName name = ProjectName.of("[PROJECT]");

    ListAlertPoliciesPagedResponse pagedListResponse = client.listAlertPolicies(name);

    List<AlertPolicy> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAlertPoliciesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAlertPolicyService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAlertPoliciesRequest actualRequest = ((ListAlertPoliciesRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAlertPoliciesExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAlertPolicyService.addException(exception);

    try {
      ProjectName name = ProjectName.of("[PROJECT]");
      client.listAlertPolicies(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAlertPoliciesTest4() throws Exception {
    AlertPolicy responsesElement = AlertPolicy.newBuilder().build();
    ListAlertPoliciesResponse expectedResponse =
        ListAlertPoliciesResponse.newBuilder()
            .setNextPageToken("")
            .addAllAlertPolicies(Arrays.asList(responsesElement))
            .build();
    mockAlertPolicyService.addResponse(expectedResponse);

    String name = "name3373707";

    ListAlertPoliciesPagedResponse pagedListResponse = client.listAlertPolicies(name);

    List<AlertPolicy> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAlertPoliciesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAlertPolicyService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAlertPoliciesRequest actualRequest = ((ListAlertPoliciesRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAlertPoliciesExceptionTest4() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAlertPolicyService.addException(exception);

    try {
      String name = "name3373707";
      client.listAlertPolicies(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAlertPolicyTest() throws Exception {
    AlertPolicy expectedResponse =
        AlertPolicy.newBuilder()
            .setName(
                AlertPolicyName.ofProjectAlertPolicyName("[PROJECT]", "[ALERT_POLICY]").toString())
            .setDisplayName("displayName1714148973")
            .setDocumentation(AlertPolicy.Documentation.newBuilder().build())
            .putAllUserLabels(new HashMap<String, String>())
            .addAllConditions(new ArrayList<AlertPolicy.Condition>())
            .setEnabled(BoolValue.newBuilder().build())
            .setValidity(Status.newBuilder().build())
            .addAllNotificationChannels(new ArrayList<String>())
            .setCreationRecord(MutationRecord.newBuilder().build())
            .setMutationRecord(MutationRecord.newBuilder().build())
            .build();
    mockAlertPolicyService.addResponse(expectedResponse);

    AlertPolicyName name = AlertPolicyName.ofProjectAlertPolicyName("[PROJECT]", "[ALERT_POLICY]");

    AlertPolicy actualResponse = client.getAlertPolicy(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAlertPolicyService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAlertPolicyRequest actualRequest = ((GetAlertPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAlertPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAlertPolicyService.addException(exception);

    try {
      AlertPolicyName name =
          AlertPolicyName.ofProjectAlertPolicyName("[PROJECT]", "[ALERT_POLICY]");
      client.getAlertPolicy(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAlertPolicyTest2() throws Exception {
    AlertPolicy expectedResponse =
        AlertPolicy.newBuilder()
            .setName(
                AlertPolicyName.ofProjectAlertPolicyName("[PROJECT]", "[ALERT_POLICY]").toString())
            .setDisplayName("displayName1714148973")
            .setDocumentation(AlertPolicy.Documentation.newBuilder().build())
            .putAllUserLabels(new HashMap<String, String>())
            .addAllConditions(new ArrayList<AlertPolicy.Condition>())
            .setEnabled(BoolValue.newBuilder().build())
            .setValidity(Status.newBuilder().build())
            .addAllNotificationChannels(new ArrayList<String>())
            .setCreationRecord(MutationRecord.newBuilder().build())
            .setMutationRecord(MutationRecord.newBuilder().build())
            .build();
    mockAlertPolicyService.addResponse(expectedResponse);

    String name = "name3373707";

    AlertPolicy actualResponse = client.getAlertPolicy(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAlertPolicyService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAlertPolicyRequest actualRequest = ((GetAlertPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAlertPolicyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAlertPolicyService.addException(exception);

    try {
      String name = "name3373707";
      client.getAlertPolicy(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createAlertPolicyTest() throws Exception {
    AlertPolicy expectedResponse =
        AlertPolicy.newBuilder()
            .setName(
                AlertPolicyName.ofProjectAlertPolicyName("[PROJECT]", "[ALERT_POLICY]").toString())
            .setDisplayName("displayName1714148973")
            .setDocumentation(AlertPolicy.Documentation.newBuilder().build())
            .putAllUserLabels(new HashMap<String, String>())
            .addAllConditions(new ArrayList<AlertPolicy.Condition>())
            .setEnabled(BoolValue.newBuilder().build())
            .setValidity(Status.newBuilder().build())
            .addAllNotificationChannels(new ArrayList<String>())
            .setCreationRecord(MutationRecord.newBuilder().build())
            .setMutationRecord(MutationRecord.newBuilder().build())
            .build();
    mockAlertPolicyService.addResponse(expectedResponse);

    FolderName name = FolderName.of("[FOLDER]");
    AlertPolicy alertPolicy = AlertPolicy.newBuilder().build();

    AlertPolicy actualResponse = client.createAlertPolicy(name, alertPolicy);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAlertPolicyService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateAlertPolicyRequest actualRequest = ((CreateAlertPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(alertPolicy, actualRequest.getAlertPolicy());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createAlertPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAlertPolicyService.addException(exception);

    try {
      FolderName name = FolderName.of("[FOLDER]");
      AlertPolicy alertPolicy = AlertPolicy.newBuilder().build();
      client.createAlertPolicy(name, alertPolicy);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createAlertPolicyTest2() throws Exception {
    AlertPolicy expectedResponse =
        AlertPolicy.newBuilder()
            .setName(
                AlertPolicyName.ofProjectAlertPolicyName("[PROJECT]", "[ALERT_POLICY]").toString())
            .setDisplayName("displayName1714148973")
            .setDocumentation(AlertPolicy.Documentation.newBuilder().build())
            .putAllUserLabels(new HashMap<String, String>())
            .addAllConditions(new ArrayList<AlertPolicy.Condition>())
            .setEnabled(BoolValue.newBuilder().build())
            .setValidity(Status.newBuilder().build())
            .addAllNotificationChannels(new ArrayList<String>())
            .setCreationRecord(MutationRecord.newBuilder().build())
            .setMutationRecord(MutationRecord.newBuilder().build())
            .build();
    mockAlertPolicyService.addResponse(expectedResponse);

    OrganizationName name = OrganizationName.of("[ORGANIZATION]");
    AlertPolicy alertPolicy = AlertPolicy.newBuilder().build();

    AlertPolicy actualResponse = client.createAlertPolicy(name, alertPolicy);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAlertPolicyService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateAlertPolicyRequest actualRequest = ((CreateAlertPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(alertPolicy, actualRequest.getAlertPolicy());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createAlertPolicyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAlertPolicyService.addException(exception);

    try {
      OrganizationName name = OrganizationName.of("[ORGANIZATION]");
      AlertPolicy alertPolicy = AlertPolicy.newBuilder().build();
      client.createAlertPolicy(name, alertPolicy);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createAlertPolicyTest3() throws Exception {
    AlertPolicy expectedResponse =
        AlertPolicy.newBuilder()
            .setName(
                AlertPolicyName.ofProjectAlertPolicyName("[PROJECT]", "[ALERT_POLICY]").toString())
            .setDisplayName("displayName1714148973")
            .setDocumentation(AlertPolicy.Documentation.newBuilder().build())
            .putAllUserLabels(new HashMap<String, String>())
            .addAllConditions(new ArrayList<AlertPolicy.Condition>())
            .setEnabled(BoolValue.newBuilder().build())
            .setValidity(Status.newBuilder().build())
            .addAllNotificationChannels(new ArrayList<String>())
            .setCreationRecord(MutationRecord.newBuilder().build())
            .setMutationRecord(MutationRecord.newBuilder().build())
            .build();
    mockAlertPolicyService.addResponse(expectedResponse);

    ProjectName name = ProjectName.of("[PROJECT]");
    AlertPolicy alertPolicy = AlertPolicy.newBuilder().build();

    AlertPolicy actualResponse = client.createAlertPolicy(name, alertPolicy);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAlertPolicyService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateAlertPolicyRequest actualRequest = ((CreateAlertPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(alertPolicy, actualRequest.getAlertPolicy());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createAlertPolicyExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAlertPolicyService.addException(exception);

    try {
      ProjectName name = ProjectName.of("[PROJECT]");
      AlertPolicy alertPolicy = AlertPolicy.newBuilder().build();
      client.createAlertPolicy(name, alertPolicy);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createAlertPolicyTest4() throws Exception {
    AlertPolicy expectedResponse =
        AlertPolicy.newBuilder()
            .setName(
                AlertPolicyName.ofProjectAlertPolicyName("[PROJECT]", "[ALERT_POLICY]").toString())
            .setDisplayName("displayName1714148973")
            .setDocumentation(AlertPolicy.Documentation.newBuilder().build())
            .putAllUserLabels(new HashMap<String, String>())
            .addAllConditions(new ArrayList<AlertPolicy.Condition>())
            .setEnabled(BoolValue.newBuilder().build())
            .setValidity(Status.newBuilder().build())
            .addAllNotificationChannels(new ArrayList<String>())
            .setCreationRecord(MutationRecord.newBuilder().build())
            .setMutationRecord(MutationRecord.newBuilder().build())
            .build();
    mockAlertPolicyService.addResponse(expectedResponse);

    String name = "name3373707";
    AlertPolicy alertPolicy = AlertPolicy.newBuilder().build();

    AlertPolicy actualResponse = client.createAlertPolicy(name, alertPolicy);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAlertPolicyService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateAlertPolicyRequest actualRequest = ((CreateAlertPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(alertPolicy, actualRequest.getAlertPolicy());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createAlertPolicyExceptionTest4() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAlertPolicyService.addException(exception);

    try {
      String name = "name3373707";
      AlertPolicy alertPolicy = AlertPolicy.newBuilder().build();
      client.createAlertPolicy(name, alertPolicy);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteAlertPolicyTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockAlertPolicyService.addResponse(expectedResponse);

    AlertPolicyName name = AlertPolicyName.ofProjectAlertPolicyName("[PROJECT]", "[ALERT_POLICY]");

    client.deleteAlertPolicy(name);

    List<AbstractMessage> actualRequests = mockAlertPolicyService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteAlertPolicyRequest actualRequest = ((DeleteAlertPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteAlertPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAlertPolicyService.addException(exception);

    try {
      AlertPolicyName name =
          AlertPolicyName.ofProjectAlertPolicyName("[PROJECT]", "[ALERT_POLICY]");
      client.deleteAlertPolicy(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteAlertPolicyTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockAlertPolicyService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteAlertPolicy(name);

    List<AbstractMessage> actualRequests = mockAlertPolicyService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteAlertPolicyRequest actualRequest = ((DeleteAlertPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteAlertPolicyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAlertPolicyService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteAlertPolicy(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateAlertPolicyTest() throws Exception {
    AlertPolicy expectedResponse =
        AlertPolicy.newBuilder()
            .setName(
                AlertPolicyName.ofProjectAlertPolicyName("[PROJECT]", "[ALERT_POLICY]").toString())
            .setDisplayName("displayName1714148973")
            .setDocumentation(AlertPolicy.Documentation.newBuilder().build())
            .putAllUserLabels(new HashMap<String, String>())
            .addAllConditions(new ArrayList<AlertPolicy.Condition>())
            .setEnabled(BoolValue.newBuilder().build())
            .setValidity(Status.newBuilder().build())
            .addAllNotificationChannels(new ArrayList<String>())
            .setCreationRecord(MutationRecord.newBuilder().build())
            .setMutationRecord(MutationRecord.newBuilder().build())
            .build();
    mockAlertPolicyService.addResponse(expectedResponse);

    FieldMask updateMask = FieldMask.newBuilder().build();
    AlertPolicy alertPolicy = AlertPolicy.newBuilder().build();

    AlertPolicy actualResponse = client.updateAlertPolicy(updateMask, alertPolicy);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAlertPolicyService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateAlertPolicyRequest actualRequest = ((UpdateAlertPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertEquals(alertPolicy, actualRequest.getAlertPolicy());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateAlertPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAlertPolicyService.addException(exception);

    try {
      FieldMask updateMask = FieldMask.newBuilder().build();
      AlertPolicy alertPolicy = AlertPolicy.newBuilder().build();
      client.updateAlertPolicy(updateMask, alertPolicy);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
