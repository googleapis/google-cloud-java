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
package com.google.cloud.securitycenter.v1;

import static com.google.cloud.securitycenter.v1.SecurityCenterClient.GroupFindingsPagedResponse;
import static com.google.cloud.securitycenter.v1.SecurityCenterClient.ListSourcesPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.common.collect.Lists;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.protobuf.ByteString;
import com.google.protobuf.Timestamp;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@javax.annotation.Generated("by GAPIC")
public class SecurityCenterClientTest {
  private static MockSecurityCenter mockSecurityCenter;
  private static MockServiceHelper serviceHelper;
  private SecurityCenterClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockSecurityCenter = new MockSecurityCenter();
    serviceHelper =
        new MockServiceHelper("in-process-1", Arrays.<MockGrpcService>asList(mockSecurityCenter));
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
    SecurityCenterSettings settings =
        SecurityCenterSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = SecurityCenterClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void createSourceTest() {
    SourceName name = SourceName.of("[ORGANIZATION]", "[SOURCE]");
    String displayName = "displayName1615086568";
    String description = "description-1724546052";
    Source expectedResponse =
        Source.newBuilder()
            .setName(name.toString())
            .setDisplayName(displayName)
            .setDescription(description)
            .build();
    mockSecurityCenter.addResponse(expectedResponse);

    OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
    Source source = Source.newBuilder().build();

    Source actualResponse = client.createSource(parent, source);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateSourceRequest actualRequest = (CreateSourceRequest) actualRequests.get(0);

    Assert.assertEquals(parent, OrganizationName.parse(actualRequest.getParent()));
    Assert.assertEquals(source, actualRequest.getSource());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createSourceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
      Source source = Source.newBuilder().build();

      client.createSource(parent, source);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createFindingTest() {
    FindingName name = FindingName.of("[ORGANIZATION]", "[SOURCE]", "[FINDING]");
    String parent2 = "parent21175163357";
    String resourceName = "resourceName979421212";
    String category = "category50511102";
    String externalUri = "externalUri-1385596168";
    Finding expectedResponse =
        Finding.newBuilder()
            .setName(name.toString())
            .setParent(parent2)
            .setResourceName(resourceName)
            .setCategory(category)
            .setExternalUri(externalUri)
            .build();
    mockSecurityCenter.addResponse(expectedResponse);

    SourceName parent = SourceName.of("[ORGANIZATION]", "[SOURCE]");
    String findingId = "findingId728776081";
    Finding finding = Finding.newBuilder().build();

    Finding actualResponse = client.createFinding(parent, findingId, finding);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateFindingRequest actualRequest = (CreateFindingRequest) actualRequests.get(0);

    Assert.assertEquals(parent, SourceName.parse(actualRequest.getParent()));
    Assert.assertEquals(findingId, actualRequest.getFindingId());
    Assert.assertEquals(finding, actualRequest.getFinding());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createFindingExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      SourceName parent = SourceName.of("[ORGANIZATION]", "[SOURCE]");
      String findingId = "findingId728776081";
      Finding finding = Finding.newBuilder().build();

      client.createFinding(parent, findingId, finding);
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
    mockSecurityCenter.addResponse(expectedResponse);

    SourceName resource = SourceName.of("[ORGANIZATION]", "[SOURCE]");

    Policy actualResponse = client.getIamPolicy(resource);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetIamPolicyRequest actualRequest = (GetIamPolicyRequest) actualRequests.get(0);

    Assert.assertEquals(Objects.toString(resource), Objects.toString(actualRequest.getResource()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getIamPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      SourceName resource = SourceName.of("[ORGANIZATION]", "[SOURCE]");

      client.getIamPolicy(resource);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getOrganizationSettingsTest() {
    String name2 = "name2-1052831874";
    boolean enableAssetDiscovery = false;
    OrganizationSettings expectedResponse =
        OrganizationSettings.newBuilder()
            .setName(name2)
            .setEnableAssetDiscovery(enableAssetDiscovery)
            .build();
    mockSecurityCenter.addResponse(expectedResponse);

    OrganizationSettingsName name = OrganizationSettingsName.of("[ORGANIZATION]");

    OrganizationSettings actualResponse = client.getOrganizationSettings(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetOrganizationSettingsRequest actualRequest =
        (GetOrganizationSettingsRequest) actualRequests.get(0);

    Assert.assertEquals(name, OrganizationSettingsName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getOrganizationSettingsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      OrganizationSettingsName name = OrganizationSettingsName.of("[ORGANIZATION]");

      client.getOrganizationSettings(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getSourceTest() {
    SourceName name2 = SourceName.of("[ORGANIZATION]", "[SOURCE]");
    String displayName = "displayName1615086568";
    String description = "description-1724546052";
    Source expectedResponse =
        Source.newBuilder()
            .setName(name2.toString())
            .setDisplayName(displayName)
            .setDescription(description)
            .build();
    mockSecurityCenter.addResponse(expectedResponse);

    SourceName name = SourceName.of("[ORGANIZATION]", "[SOURCE]");

    Source actualResponse = client.getSource(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSourceRequest actualRequest = (GetSourceRequest) actualRequests.get(0);

    Assert.assertEquals(name, SourceName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getSourceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      SourceName name = SourceName.of("[ORGANIZATION]", "[SOURCE]");

      client.getSource(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void groupFindingsTest() {
    String nextPageToken = "";
    int totalSize = 705419236;
    GroupResult groupByResultsElement = GroupResult.newBuilder().build();
    List<GroupResult> groupByResults = Arrays.asList(groupByResultsElement);
    GroupFindingsResponse expectedResponse =
        GroupFindingsResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .setTotalSize(totalSize)
            .addAllGroupByResults(groupByResults)
            .build();
    mockSecurityCenter.addResponse(expectedResponse);

    SourceName parent = SourceName.of("[ORGANIZATION]", "[SOURCE]");
    String groupBy = "groupBy506361367";

    GroupFindingsPagedResponse pagedListResponse = client.groupFindings(parent, groupBy);

    List<GroupResult> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getGroupByResultsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GroupFindingsRequest actualRequest = (GroupFindingsRequest) actualRequests.get(0);

    Assert.assertEquals(parent, SourceName.parse(actualRequest.getParent()));
    Assert.assertEquals(groupBy, actualRequest.getGroupBy());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void groupFindingsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      SourceName parent = SourceName.of("[ORGANIZATION]", "[SOURCE]");
      String groupBy = "groupBy506361367";

      client.groupFindings(parent, groupBy);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listSourcesTest() {
    String nextPageToken = "";
    Source sourcesElement = Source.newBuilder().build();
    List<Source> sources = Arrays.asList(sourcesElement);
    ListSourcesResponse expectedResponse =
        ListSourcesResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllSources(sources)
            .build();
    mockSecurityCenter.addResponse(expectedResponse);

    OrganizationName parent = OrganizationName.of("[ORGANIZATION]");

    ListSourcesPagedResponse pagedListResponse = client.listSources(parent);

    List<Source> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSourcesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListSourcesRequest actualRequest = (ListSourcesRequest) actualRequests.get(0);

    Assert.assertEquals(parent, OrganizationName.parse(actualRequest.getParent()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listSourcesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      OrganizationName parent = OrganizationName.of("[ORGANIZATION]");

      client.listSources(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void runAssetDiscoveryTest() throws Exception {
    RunAssetDiscoveryResponse expectedResponse = RunAssetDiscoveryResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("runAssetDiscoveryTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockSecurityCenter.addResponse(resultOperation);

    OrganizationName parent = OrganizationName.of("[ORGANIZATION]");

    RunAssetDiscoveryResponse actualResponse = client.runAssetDiscoveryAsync(parent).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RunAssetDiscoveryRequest actualRequest = (RunAssetDiscoveryRequest) actualRequests.get(0);

    Assert.assertEquals(parent, OrganizationName.parse(actualRequest.getParent()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void runAssetDiscoveryExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      OrganizationName parent = OrganizationName.of("[ORGANIZATION]");

      client.runAssetDiscoveryAsync(parent).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void setFindingStateTest() {
    FindingName name2 = FindingName.of("[ORGANIZATION]", "[SOURCE]", "[FINDING]");
    String parent = "parent-995424086";
    String resourceName = "resourceName979421212";
    String category = "category50511102";
    String externalUri = "externalUri-1385596168";
    Finding expectedResponse =
        Finding.newBuilder()
            .setName(name2.toString())
            .setParent(parent)
            .setResourceName(resourceName)
            .setCategory(category)
            .setExternalUri(externalUri)
            .build();
    mockSecurityCenter.addResponse(expectedResponse);

    FindingName name = FindingName.of("[ORGANIZATION]", "[SOURCE]", "[FINDING]");
    Finding.State state = Finding.State.STATE_UNSPECIFIED;
    Timestamp startTime = Timestamp.newBuilder().build();

    Finding actualResponse = client.setFindingState(name, state, startTime);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SetFindingStateRequest actualRequest = (SetFindingStateRequest) actualRequests.get(0);

    Assert.assertEquals(name, FindingName.parse(actualRequest.getName()));
    Assert.assertEquals(state, actualRequest.getState());
    Assert.assertEquals(startTime, actualRequest.getStartTime());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void setFindingStateExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      FindingName name = FindingName.of("[ORGANIZATION]", "[SOURCE]", "[FINDING]");
      Finding.State state = Finding.State.STATE_UNSPECIFIED;
      Timestamp startTime = Timestamp.newBuilder().build();

      client.setFindingState(name, state, startTime);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void setIamPolicyTest() {
    int version = 351608024;
    ByteString etag = ByteString.copyFromUtf8("21");
    Policy expectedResponse = Policy.newBuilder().setVersion(version).setEtag(etag).build();
    mockSecurityCenter.addResponse(expectedResponse);

    SourceName resource = SourceName.of("[ORGANIZATION]", "[SOURCE]");
    Policy policy = Policy.newBuilder().build();

    Policy actualResponse = client.setIamPolicy(resource, policy);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SetIamPolicyRequest actualRequest = (SetIamPolicyRequest) actualRequests.get(0);

    Assert.assertEquals(Objects.toString(resource), Objects.toString(actualRequest.getResource()));
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
    mockSecurityCenter.addException(exception);

    try {
      SourceName resource = SourceName.of("[ORGANIZATION]", "[SOURCE]");
      Policy policy = Policy.newBuilder().build();

      client.setIamPolicy(resource, policy);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void testIamPermissionsTest() {
    TestIamPermissionsResponse expectedResponse = TestIamPermissionsResponse.newBuilder().build();
    mockSecurityCenter.addResponse(expectedResponse);

    SourceName resource = SourceName.of("[ORGANIZATION]", "[SOURCE]");
    List<String> permissions = new ArrayList<>();

    TestIamPermissionsResponse actualResponse = client.testIamPermissions(resource, permissions);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    TestIamPermissionsRequest actualRequest = (TestIamPermissionsRequest) actualRequests.get(0);

    Assert.assertEquals(Objects.toString(resource), Objects.toString(actualRequest.getResource()));
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
    mockSecurityCenter.addException(exception);

    try {
      SourceName resource = SourceName.of("[ORGANIZATION]", "[SOURCE]");
      List<String> permissions = new ArrayList<>();

      client.testIamPermissions(resource, permissions);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateFindingTest() {
    FindingName name = FindingName.of("[ORGANIZATION]", "[SOURCE]", "[FINDING]");
    String parent = "parent-995424086";
    String resourceName = "resourceName979421212";
    String category = "category50511102";
    String externalUri = "externalUri-1385596168";
    Finding expectedResponse =
        Finding.newBuilder()
            .setName(name.toString())
            .setParent(parent)
            .setResourceName(resourceName)
            .setCategory(category)
            .setExternalUri(externalUri)
            .build();
    mockSecurityCenter.addResponse(expectedResponse);

    Finding finding = Finding.newBuilder().build();

    Finding actualResponse = client.updateFinding(finding);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateFindingRequest actualRequest = (UpdateFindingRequest) actualRequests.get(0);

    Assert.assertEquals(finding, actualRequest.getFinding());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void updateFindingExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      Finding finding = Finding.newBuilder().build();

      client.updateFinding(finding);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateOrganizationSettingsTest() {
    String name = "name3373707";
    boolean enableAssetDiscovery = false;
    OrganizationSettings expectedResponse =
        OrganizationSettings.newBuilder()
            .setName(name)
            .setEnableAssetDiscovery(enableAssetDiscovery)
            .build();
    mockSecurityCenter.addResponse(expectedResponse);

    OrganizationSettings organizationSettings = OrganizationSettings.newBuilder().build();

    OrganizationSettings actualResponse = client.updateOrganizationSettings(organizationSettings);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateOrganizationSettingsRequest actualRequest =
        (UpdateOrganizationSettingsRequest) actualRequests.get(0);

    Assert.assertEquals(organizationSettings, actualRequest.getOrganizationSettings());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void updateOrganizationSettingsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      OrganizationSettings organizationSettings = OrganizationSettings.newBuilder().build();

      client.updateOrganizationSettings(organizationSettings);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateSourceTest() {
    SourceName name = SourceName.of("[ORGANIZATION]", "[SOURCE]");
    String displayName = "displayName1615086568";
    String description = "description-1724546052";
    Source expectedResponse =
        Source.newBuilder()
            .setName(name.toString())
            .setDisplayName(displayName)
            .setDescription(description)
            .build();
    mockSecurityCenter.addResponse(expectedResponse);

    Source source = Source.newBuilder().build();

    Source actualResponse = client.updateSource(source);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateSourceRequest actualRequest = (UpdateSourceRequest) actualRequests.get(0);

    Assert.assertEquals(source, actualRequest.getSource());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void updateSourceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      Source source = Source.newBuilder().build();

      client.updateSource(source);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateSecurityMarksTest() {
    String name = "name3373707";
    SecurityMarks expectedResponse = SecurityMarks.newBuilder().setName(name).build();
    mockSecurityCenter.addResponse(expectedResponse);

    SecurityMarks securityMarks = SecurityMarks.newBuilder().build();

    SecurityMarks actualResponse = client.updateSecurityMarks(securityMarks);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateSecurityMarksRequest actualRequest = (UpdateSecurityMarksRequest) actualRequests.get(0);

    Assert.assertEquals(securityMarks, actualRequest.getSecurityMarks());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void updateSecurityMarksExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      SecurityMarks securityMarks = SecurityMarks.newBuilder().build();

      client.updateSecurityMarks(securityMarks);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }
}
