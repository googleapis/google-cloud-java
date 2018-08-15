/*
 * Copyright 2018 Google LLC
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
package com.google.cloud.devtools.containeranalysis.v1beta1;

import static com.google.cloud.devtools.containeranalysis.v1beta1.ContainerAnalysisV1Beta1Client.ListScanConfigsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.common.collect.Lists;
import com.google.containeranalysis.v1beta1.GetScanConfigRequest;
import com.google.containeranalysis.v1beta1.ListScanConfigsRequest;
import com.google.containeranalysis.v1beta1.ListScanConfigsResponse;
import com.google.containeranalysis.v1beta1.ScanConfig;
import com.google.containeranalysis.v1beta1.UpdateScanConfigRequest;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageV3;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@javax.annotation.Generated("by GAPIC")
public class ContainerAnalysisV1Beta1ClientTest {
  private static MockContainerAnalysisV1Beta1 mockContainerAnalysisV1Beta1;
  private static MockGrafeasV1Beta1 mockGrafeasV1Beta1;
  private static MockServiceHelper serviceHelper;
  private ContainerAnalysisV1Beta1Client client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockContainerAnalysisV1Beta1 = new MockContainerAnalysisV1Beta1();
    mockGrafeasV1Beta1 = new MockGrafeasV1Beta1();
    serviceHelper =
        new MockServiceHelper(
            "in-process-1",
            Arrays.<MockGrpcService>asList(mockContainerAnalysisV1Beta1, mockGrafeasV1Beta1));
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
    ContainerAnalysisV1Beta1Settings settings =
        ContainerAnalysisV1Beta1Settings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ContainerAnalysisV1Beta1Client.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void setIamPolicyTest() {
    int version = 351608024;
    ByteString etag = ByteString.copyFromUtf8("21");
    Policy expectedResponse = Policy.newBuilder().setVersion(version).setEtag(etag).build();
    mockContainerAnalysisV1Beta1.addResponse(expectedResponse);

    String formattedResource = ContainerAnalysisV1Beta1Client.formatNoteName("[PROJECT]", "[NOTE]");
    Policy policy = Policy.newBuilder().build();

    Policy actualResponse = client.setIamPolicy(formattedResource, policy);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockContainerAnalysisV1Beta1.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SetIamPolicyRequest actualRequest = (SetIamPolicyRequest) actualRequests.get(0);

    Assert.assertEquals(formattedResource, actualRequest.getResource());
    Assert.assertEquals(policy, actualRequest.getPolicy());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void setIamPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockContainerAnalysisV1Beta1.addException(exception);

    try {
      String formattedResource =
          ContainerAnalysisV1Beta1Client.formatNoteName("[PROJECT]", "[NOTE]");
      Policy policy = Policy.newBuilder().build();

      client.setIamPolicy(formattedResource, policy);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getIamPolicyTest() {
    int version = 351608024;
    ByteString etag = ByteString.copyFromUtf8("21");
    Policy expectedResponse = Policy.newBuilder().setVersion(version).setEtag(etag).build();
    mockContainerAnalysisV1Beta1.addResponse(expectedResponse);

    String formattedResource = ContainerAnalysisV1Beta1Client.formatNoteName("[PROJECT]", "[NOTE]");

    Policy actualResponse = client.getIamPolicy(formattedResource);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockContainerAnalysisV1Beta1.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetIamPolicyRequest actualRequest = (GetIamPolicyRequest) actualRequests.get(0);

    Assert.assertEquals(formattedResource, actualRequest.getResource());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getIamPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockContainerAnalysisV1Beta1.addException(exception);

    try {
      String formattedResource =
          ContainerAnalysisV1Beta1Client.formatNoteName("[PROJECT]", "[NOTE]");

      client.getIamPolicy(formattedResource);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void testIamPermissionsTest() {
    TestIamPermissionsResponse expectedResponse = TestIamPermissionsResponse.newBuilder().build();
    mockContainerAnalysisV1Beta1.addResponse(expectedResponse);

    String formattedResource = ContainerAnalysisV1Beta1Client.formatNoteName("[PROJECT]", "[NOTE]");
    List<String> permissions = new ArrayList<>();

    TestIamPermissionsResponse actualResponse =
        client.testIamPermissions(formattedResource, permissions);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockContainerAnalysisV1Beta1.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    TestIamPermissionsRequest actualRequest = (TestIamPermissionsRequest) actualRequests.get(0);

    Assert.assertEquals(formattedResource, actualRequest.getResource());
    Assert.assertEquals(permissions, actualRequest.getPermissionsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void testIamPermissionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockContainerAnalysisV1Beta1.addException(exception);

    try {
      String formattedResource =
          ContainerAnalysisV1Beta1Client.formatNoteName("[PROJECT]", "[NOTE]");
      List<String> permissions = new ArrayList<>();

      client.testIamPermissions(formattedResource, permissions);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getScanConfigTest() {
    String name2 = "name2-1052831874";
    String description = "description-1724546052";
    boolean enabled = false;
    ScanConfig expectedResponse =
        ScanConfig.newBuilder()
            .setName(name2)
            .setDescription(description)
            .setEnabled(enabled)
            .build();
    mockContainerAnalysisV1Beta1.addResponse(expectedResponse);

    String formattedName =
        ContainerAnalysisV1Beta1Client.formatScanConfigName("[PROJECT]", "[SCAN_CONFIG]");

    ScanConfig actualResponse = client.getScanConfig(formattedName);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockContainerAnalysisV1Beta1.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetScanConfigRequest actualRequest = (GetScanConfigRequest) actualRequests.get(0);

    Assert.assertEquals(formattedName, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getScanConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockContainerAnalysisV1Beta1.addException(exception);

    try {
      String formattedName =
          ContainerAnalysisV1Beta1Client.formatScanConfigName("[PROJECT]", "[SCAN_CONFIG]");

      client.getScanConfig(formattedName);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listScanConfigsTest() {
    String nextPageToken = "";
    ScanConfig scanConfigsElement = ScanConfig.newBuilder().build();
    List<ScanConfig> scanConfigs = Arrays.asList(scanConfigsElement);
    ListScanConfigsResponse expectedResponse =
        ListScanConfigsResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllScanConfigs(scanConfigs)
            .build();
    mockContainerAnalysisV1Beta1.addResponse(expectedResponse);

    String formattedParent = ContainerAnalysisV1Beta1Client.formatProjectName("[PROJECT]");
    String filter = "filter-1274492040";

    ListScanConfigsPagedResponse pagedListResponse =
        client.listScanConfigs(formattedParent, filter);

    List<ScanConfig> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getScanConfigsList().get(0), resources.get(0));

    List<GeneratedMessageV3> actualRequests = mockContainerAnalysisV1Beta1.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListScanConfigsRequest actualRequest = (ListScanConfigsRequest) actualRequests.get(0);

    Assert.assertEquals(formattedParent, actualRequest.getParent());
    Assert.assertEquals(filter, actualRequest.getFilter());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listScanConfigsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockContainerAnalysisV1Beta1.addException(exception);

    try {
      String formattedParent = ContainerAnalysisV1Beta1Client.formatProjectName("[PROJECT]");
      String filter = "filter-1274492040";

      client.listScanConfigs(formattedParent, filter);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateScanConfigTest() {
    String name2 = "name2-1052831874";
    String description = "description-1724546052";
    boolean enabled = false;
    ScanConfig expectedResponse =
        ScanConfig.newBuilder()
            .setName(name2)
            .setDescription(description)
            .setEnabled(enabled)
            .build();
    mockContainerAnalysisV1Beta1.addResponse(expectedResponse);

    String formattedName =
        ContainerAnalysisV1Beta1Client.formatScanConfigName("[PROJECT]", "[SCAN_CONFIG]");
    ScanConfig scanConfig = ScanConfig.newBuilder().build();

    ScanConfig actualResponse = client.updateScanConfig(formattedName, scanConfig);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockContainerAnalysisV1Beta1.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateScanConfigRequest actualRequest = (UpdateScanConfigRequest) actualRequests.get(0);

    Assert.assertEquals(formattedName, actualRequest.getName());
    Assert.assertEquals(scanConfig, actualRequest.getScanConfig());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void updateScanConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockContainerAnalysisV1Beta1.addException(exception);

    try {
      String formattedName =
          ContainerAnalysisV1Beta1Client.formatScanConfigName("[PROJECT]", "[SCAN_CONFIG]");
      ScanConfig scanConfig = ScanConfig.newBuilder().build();

      client.updateScanConfig(formattedName, scanConfig);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }
}
