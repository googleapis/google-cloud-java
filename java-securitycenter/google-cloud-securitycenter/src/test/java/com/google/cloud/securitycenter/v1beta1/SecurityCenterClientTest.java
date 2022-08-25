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

package com.google.cloud.securitycenter.v1beta1;

import static com.google.cloud.securitycenter.v1beta1.SecurityCenterClient.GroupAssetsPagedResponse;
import static com.google.cloud.securitycenter.v1beta1.SecurityCenterClient.GroupFindingsPagedResponse;
import static com.google.cloud.securitycenter.v1beta1.SecurityCenterClient.ListAssetsPagedResponse;
import static com.google.cloud.securitycenter.v1beta1.SecurityCenterClient.ListFindingsPagedResponse;
import static com.google.cloud.securitycenter.v1beta1.SecurityCenterClient.ListSourcesPagedResponse;

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
import com.google.iam.v1.AuditConfig;
import com.google.iam.v1.Binding;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.protobuf.ByteString;
import com.google.protobuf.Duration;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import com.google.protobuf.Value;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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
public class SecurityCenterClientTest {
  private static MockSecurityCenter mockSecurityCenter;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private SecurityCenterClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockSecurityCenter = new MockSecurityCenter();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockSecurityCenter));
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
  public void createSourceTest() throws Exception {
    Source expectedResponse =
        Source.newBuilder()
            .setName(SourceName.of("[ORGANIZATION]", "[SOURCE]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .build();
    mockSecurityCenter.addResponse(expectedResponse);

    OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
    Source source = Source.newBuilder().build();

    Source actualResponse = client.createSource(parent, source);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateSourceRequest actualRequest = ((CreateSourceRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(source, actualRequest.getSource());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createSourceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
      Source source = Source.newBuilder().build();
      client.createSource(parent, source);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createSourceTest2() throws Exception {
    Source expectedResponse =
        Source.newBuilder()
            .setName(SourceName.of("[ORGANIZATION]", "[SOURCE]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .build();
    mockSecurityCenter.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Source source = Source.newBuilder().build();

    Source actualResponse = client.createSource(parent, source);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateSourceRequest actualRequest = ((CreateSourceRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(source, actualRequest.getSource());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createSourceExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      String parent = "parent-995424086";
      Source source = Source.newBuilder().build();
      client.createSource(parent, source);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createFindingTest() throws Exception {
    Finding expectedResponse =
        Finding.newBuilder()
            .setName(FindingName.of("[ORGANIZATION]", "[SOURCE]", "[FINDING]").toString())
            .setParent("parent-995424086")
            .setResourceName("resourceName-384566343")
            .setCategory("category50511102")
            .setExternalUri("externalUri-1153085023")
            .putAllSourceProperties(new HashMap<String, Value>())
            .setSecurityMarks(SecurityMarks.newBuilder().build())
            .setEventTime(Timestamp.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    mockSecurityCenter.addResponse(expectedResponse);

    SourceName parent = SourceName.of("[ORGANIZATION]", "[SOURCE]");
    String findingId = "findingId439150212";
    Finding finding = Finding.newBuilder().build();

    Finding actualResponse = client.createFinding(parent, findingId, finding);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateFindingRequest actualRequest = ((CreateFindingRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(findingId, actualRequest.getFindingId());
    Assert.assertEquals(finding, actualRequest.getFinding());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createFindingExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      SourceName parent = SourceName.of("[ORGANIZATION]", "[SOURCE]");
      String findingId = "findingId439150212";
      Finding finding = Finding.newBuilder().build();
      client.createFinding(parent, findingId, finding);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createFindingTest2() throws Exception {
    Finding expectedResponse =
        Finding.newBuilder()
            .setName(FindingName.of("[ORGANIZATION]", "[SOURCE]", "[FINDING]").toString())
            .setParent("parent-995424086")
            .setResourceName("resourceName-384566343")
            .setCategory("category50511102")
            .setExternalUri("externalUri-1153085023")
            .putAllSourceProperties(new HashMap<String, Value>())
            .setSecurityMarks(SecurityMarks.newBuilder().build())
            .setEventTime(Timestamp.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    mockSecurityCenter.addResponse(expectedResponse);

    String parent = "parent-995424086";
    String findingId = "findingId439150212";
    Finding finding = Finding.newBuilder().build();

    Finding actualResponse = client.createFinding(parent, findingId, finding);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateFindingRequest actualRequest = ((CreateFindingRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(findingId, actualRequest.getFindingId());
    Assert.assertEquals(finding, actualRequest.getFinding());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createFindingExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      String parent = "parent-995424086";
      String findingId = "findingId439150212";
      Finding finding = Finding.newBuilder().build();
      client.createFinding(parent, findingId, finding);
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
    mockSecurityCenter.addResponse(expectedResponse);

    ResourceName resource = SourceName.of("[ORGANIZATION]", "[SOURCE]");

    Policy actualResponse = client.getIamPolicy(resource);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetIamPolicyRequest actualRequest = ((GetIamPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(resource.toString(), actualRequest.getResource());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getIamPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      ResourceName resource = SourceName.of("[ORGANIZATION]", "[SOURCE]");
      client.getIamPolicy(resource);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getIamPolicyTest2() throws Exception {
    Policy expectedResponse =
        Policy.newBuilder()
            .setVersion(351608024)
            .addAllBindings(new ArrayList<Binding>())
            .addAllAuditConfigs(new ArrayList<AuditConfig>())
            .setEtag(ByteString.EMPTY)
            .build();
    mockSecurityCenter.addResponse(expectedResponse);

    String resource = "resource-341064690";

    Policy actualResponse = client.getIamPolicy(resource);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetIamPolicyRequest actualRequest = ((GetIamPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(resource, actualRequest.getResource());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getIamPolicyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      String resource = "resource-341064690";
      client.getIamPolicy(resource);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getOrganizationSettingsTest() throws Exception {
    OrganizationSettings expectedResponse =
        OrganizationSettings.newBuilder()
            .setName(OrganizationSettingsName.of("[ORGANIZATION]").toString())
            .setEnableAssetDiscovery(true)
            .setAssetDiscoveryConfig(OrganizationSettings.AssetDiscoveryConfig.newBuilder().build())
            .build();
    mockSecurityCenter.addResponse(expectedResponse);

    OrganizationSettingsName name = OrganizationSettingsName.of("[ORGANIZATION]");

    OrganizationSettings actualResponse = client.getOrganizationSettings(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetOrganizationSettingsRequest actualRequest =
        ((GetOrganizationSettingsRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getOrganizationSettingsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      OrganizationSettingsName name = OrganizationSettingsName.of("[ORGANIZATION]");
      client.getOrganizationSettings(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getOrganizationSettingsTest2() throws Exception {
    OrganizationSettings expectedResponse =
        OrganizationSettings.newBuilder()
            .setName(OrganizationSettingsName.of("[ORGANIZATION]").toString())
            .setEnableAssetDiscovery(true)
            .setAssetDiscoveryConfig(OrganizationSettings.AssetDiscoveryConfig.newBuilder().build())
            .build();
    mockSecurityCenter.addResponse(expectedResponse);

    String name = "name3373707";

    OrganizationSettings actualResponse = client.getOrganizationSettings(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetOrganizationSettingsRequest actualRequest =
        ((GetOrganizationSettingsRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getOrganizationSettingsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      String name = "name3373707";
      client.getOrganizationSettings(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSourceTest() throws Exception {
    Source expectedResponse =
        Source.newBuilder()
            .setName(SourceName.of("[ORGANIZATION]", "[SOURCE]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .build();
    mockSecurityCenter.addResponse(expectedResponse);

    SourceName name = SourceName.of("[ORGANIZATION]", "[SOURCE]");

    Source actualResponse = client.getSource(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSourceRequest actualRequest = ((GetSourceRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getSourceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      SourceName name = SourceName.of("[ORGANIZATION]", "[SOURCE]");
      client.getSource(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSourceTest2() throws Exception {
    Source expectedResponse =
        Source.newBuilder()
            .setName(SourceName.of("[ORGANIZATION]", "[SOURCE]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .build();
    mockSecurityCenter.addResponse(expectedResponse);

    String name = "name3373707";

    Source actualResponse = client.getSource(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSourceRequest actualRequest = ((GetSourceRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getSourceExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      String name = "name3373707";
      client.getSource(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void groupAssetsTest() throws Exception {
    GroupResult responsesElement = GroupResult.newBuilder().build();
    GroupAssetsResponse expectedResponse =
        GroupAssetsResponse.newBuilder()
            .setNextPageToken("")
            .addAllGroupByResults(Arrays.asList(responsesElement))
            .build();
    mockSecurityCenter.addResponse(expectedResponse);

    GroupAssetsRequest request =
        GroupAssetsRequest.newBuilder()
            .setParent(OrganizationName.of("[ORGANIZATION]").toString())
            .setFilter("filter-1274492040")
            .setGroupBy("groupBy293428022")
            .setCompareDuration(Duration.newBuilder().build())
            .setReadTime(Timestamp.newBuilder().build())
            .setPageToken("pageToken873572522")
            .setPageSize(883849137)
            .build();

    GroupAssetsPagedResponse pagedListResponse = client.groupAssets(request);

    List<GroupResult> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getGroupByResultsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GroupAssetsRequest actualRequest = ((GroupAssetsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getFilter(), actualRequest.getFilter());
    Assert.assertEquals(request.getGroupBy(), actualRequest.getGroupBy());
    Assert.assertEquals(request.getCompareDuration(), actualRequest.getCompareDuration());
    Assert.assertEquals(request.getReadTime(), actualRequest.getReadTime());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void groupAssetsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      GroupAssetsRequest request =
          GroupAssetsRequest.newBuilder()
              .setParent(OrganizationName.of("[ORGANIZATION]").toString())
              .setFilter("filter-1274492040")
              .setGroupBy("groupBy293428022")
              .setCompareDuration(Duration.newBuilder().build())
              .setReadTime(Timestamp.newBuilder().build())
              .setPageToken("pageToken873572522")
              .setPageSize(883849137)
              .build();
      client.groupAssets(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void groupFindingsTest() throws Exception {
    GroupResult responsesElement = GroupResult.newBuilder().build();
    GroupFindingsResponse expectedResponse =
        GroupFindingsResponse.newBuilder()
            .setNextPageToken("")
            .addAllGroupByResults(Arrays.asList(responsesElement))
            .build();
    mockSecurityCenter.addResponse(expectedResponse);

    SourceName parent = SourceName.of("[ORGANIZATION]", "[SOURCE]");
    String groupBy = "groupBy293428022";

    GroupFindingsPagedResponse pagedListResponse = client.groupFindings(parent, groupBy);

    List<GroupResult> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getGroupByResultsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GroupFindingsRequest actualRequest = ((GroupFindingsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(groupBy, actualRequest.getGroupBy());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void groupFindingsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      SourceName parent = SourceName.of("[ORGANIZATION]", "[SOURCE]");
      String groupBy = "groupBy293428022";
      client.groupFindings(parent, groupBy);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void groupFindingsTest2() throws Exception {
    GroupResult responsesElement = GroupResult.newBuilder().build();
    GroupFindingsResponse expectedResponse =
        GroupFindingsResponse.newBuilder()
            .setNextPageToken("")
            .addAllGroupByResults(Arrays.asList(responsesElement))
            .build();
    mockSecurityCenter.addResponse(expectedResponse);

    String parent = "parent-995424086";
    String groupBy = "groupBy293428022";

    GroupFindingsPagedResponse pagedListResponse = client.groupFindings(parent, groupBy);

    List<GroupResult> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getGroupByResultsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GroupFindingsRequest actualRequest = ((GroupFindingsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(groupBy, actualRequest.getGroupBy());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void groupFindingsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      String parent = "parent-995424086";
      String groupBy = "groupBy293428022";
      client.groupFindings(parent, groupBy);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAssetsTest() throws Exception {
    ListAssetsResponse.ListAssetsResult responsesElement =
        ListAssetsResponse.ListAssetsResult.newBuilder().build();
    ListAssetsResponse expectedResponse =
        ListAssetsResponse.newBuilder()
            .setNextPageToken("")
            .addAllListAssetsResults(Arrays.asList(responsesElement))
            .build();
    mockSecurityCenter.addResponse(expectedResponse);

    ListAssetsRequest request =
        ListAssetsRequest.newBuilder()
            .setParent(OrganizationName.of("[ORGANIZATION]").toString())
            .setFilter("filter-1274492040")
            .setOrderBy("orderBy-1207110587")
            .setReadTime(Timestamp.newBuilder().build())
            .setCompareDuration(Duration.newBuilder().build())
            .setFieldMask(FieldMask.newBuilder().build())
            .setPageToken("pageToken873572522")
            .setPageSize(883849137)
            .build();

    ListAssetsPagedResponse pagedListResponse = client.listAssets(request);

    List<ListAssetsResponse.ListAssetsResult> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getListAssetsResultsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAssetsRequest actualRequest = ((ListAssetsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getFilter(), actualRequest.getFilter());
    Assert.assertEquals(request.getOrderBy(), actualRequest.getOrderBy());
    Assert.assertEquals(request.getReadTime(), actualRequest.getReadTime());
    Assert.assertEquals(request.getCompareDuration(), actualRequest.getCompareDuration());
    Assert.assertEquals(request.getFieldMask(), actualRequest.getFieldMask());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAssetsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      ListAssetsRequest request =
          ListAssetsRequest.newBuilder()
              .setParent(OrganizationName.of("[ORGANIZATION]").toString())
              .setFilter("filter-1274492040")
              .setOrderBy("orderBy-1207110587")
              .setReadTime(Timestamp.newBuilder().build())
              .setCompareDuration(Duration.newBuilder().build())
              .setFieldMask(FieldMask.newBuilder().build())
              .setPageToken("pageToken873572522")
              .setPageSize(883849137)
              .build();
      client.listAssets(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listFindingsTest() throws Exception {
    Finding responsesElement = Finding.newBuilder().build();
    ListFindingsResponse expectedResponse =
        ListFindingsResponse.newBuilder()
            .setNextPageToken("")
            .addAllFindings(Arrays.asList(responsesElement))
            .build();
    mockSecurityCenter.addResponse(expectedResponse);

    ListFindingsRequest request =
        ListFindingsRequest.newBuilder()
            .setParent(SourceName.of("[ORGANIZATION]", "[SOURCE]").toString())
            .setFilter("filter-1274492040")
            .setOrderBy("orderBy-1207110587")
            .setReadTime(Timestamp.newBuilder().build())
            .setFieldMask(FieldMask.newBuilder().build())
            .setPageToken("pageToken873572522")
            .setPageSize(883849137)
            .build();

    ListFindingsPagedResponse pagedListResponse = client.listFindings(request);

    List<Finding> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getFindingsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListFindingsRequest actualRequest = ((ListFindingsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getFilter(), actualRequest.getFilter());
    Assert.assertEquals(request.getOrderBy(), actualRequest.getOrderBy());
    Assert.assertEquals(request.getReadTime(), actualRequest.getReadTime());
    Assert.assertEquals(request.getFieldMask(), actualRequest.getFieldMask());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listFindingsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      ListFindingsRequest request =
          ListFindingsRequest.newBuilder()
              .setParent(SourceName.of("[ORGANIZATION]", "[SOURCE]").toString())
              .setFilter("filter-1274492040")
              .setOrderBy("orderBy-1207110587")
              .setReadTime(Timestamp.newBuilder().build())
              .setFieldMask(FieldMask.newBuilder().build())
              .setPageToken("pageToken873572522")
              .setPageSize(883849137)
              .build();
      client.listFindings(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSourcesTest() throws Exception {
    Source responsesElement = Source.newBuilder().build();
    ListSourcesResponse expectedResponse =
        ListSourcesResponse.newBuilder()
            .setNextPageToken("")
            .addAllSources(Arrays.asList(responsesElement))
            .build();
    mockSecurityCenter.addResponse(expectedResponse);

    OrganizationName parent = OrganizationName.of("[ORGANIZATION]");

    ListSourcesPagedResponse pagedListResponse = client.listSources(parent);

    List<Source> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSourcesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListSourcesRequest actualRequest = ((ListSourcesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listSourcesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
      client.listSources(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSourcesTest2() throws Exception {
    Source responsesElement = Source.newBuilder().build();
    ListSourcesResponse expectedResponse =
        ListSourcesResponse.newBuilder()
            .setNextPageToken("")
            .addAllSources(Arrays.asList(responsesElement))
            .build();
    mockSecurityCenter.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListSourcesPagedResponse pagedListResponse = client.listSources(parent);

    List<Source> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSourcesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListSourcesRequest actualRequest = ((ListSourcesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listSourcesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listSources(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void runAssetDiscoveryTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("runAssetDiscoveryTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockSecurityCenter.addResponse(resultOperation);

    OrganizationName parent = OrganizationName.of("[ORGANIZATION]");

    client.runAssetDiscoveryAsync(parent).get();

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RunAssetDiscoveryRequest actualRequest = ((RunAssetDiscoveryRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void runAssetDiscoveryExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
      client.runAssetDiscoveryAsync(parent).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void runAssetDiscoveryTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("runAssetDiscoveryTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockSecurityCenter.addResponse(resultOperation);

    String parent = "parent-995424086";

    client.runAssetDiscoveryAsync(parent).get();

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RunAssetDiscoveryRequest actualRequest = ((RunAssetDiscoveryRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void runAssetDiscoveryExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      String parent = "parent-995424086";
      client.runAssetDiscoveryAsync(parent).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void setFindingStateTest() throws Exception {
    Finding expectedResponse =
        Finding.newBuilder()
            .setName(FindingName.of("[ORGANIZATION]", "[SOURCE]", "[FINDING]").toString())
            .setParent("parent-995424086")
            .setResourceName("resourceName-384566343")
            .setCategory("category50511102")
            .setExternalUri("externalUri-1153085023")
            .putAllSourceProperties(new HashMap<String, Value>())
            .setSecurityMarks(SecurityMarks.newBuilder().build())
            .setEventTime(Timestamp.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    mockSecurityCenter.addResponse(expectedResponse);

    FindingName name = FindingName.of("[ORGANIZATION]", "[SOURCE]", "[FINDING]");
    Finding.State state = Finding.State.forNumber(0);
    Timestamp startTime = Timestamp.newBuilder().build();

    Finding actualResponse = client.setFindingState(name, state, startTime);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SetFindingStateRequest actualRequest = ((SetFindingStateRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(state, actualRequest.getState());
    Assert.assertEquals(startTime, actualRequest.getStartTime());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void setFindingStateExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      FindingName name = FindingName.of("[ORGANIZATION]", "[SOURCE]", "[FINDING]");
      Finding.State state = Finding.State.forNumber(0);
      Timestamp startTime = Timestamp.newBuilder().build();
      client.setFindingState(name, state, startTime);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void setFindingStateTest2() throws Exception {
    Finding expectedResponse =
        Finding.newBuilder()
            .setName(FindingName.of("[ORGANIZATION]", "[SOURCE]", "[FINDING]").toString())
            .setParent("parent-995424086")
            .setResourceName("resourceName-384566343")
            .setCategory("category50511102")
            .setExternalUri("externalUri-1153085023")
            .putAllSourceProperties(new HashMap<String, Value>())
            .setSecurityMarks(SecurityMarks.newBuilder().build())
            .setEventTime(Timestamp.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    mockSecurityCenter.addResponse(expectedResponse);

    String name = "name3373707";
    Finding.State state = Finding.State.forNumber(0);
    Timestamp startTime = Timestamp.newBuilder().build();

    Finding actualResponse = client.setFindingState(name, state, startTime);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SetFindingStateRequest actualRequest = ((SetFindingStateRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(state, actualRequest.getState());
    Assert.assertEquals(startTime, actualRequest.getStartTime());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void setFindingStateExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      String name = "name3373707";
      Finding.State state = Finding.State.forNumber(0);
      Timestamp startTime = Timestamp.newBuilder().build();
      client.setFindingState(name, state, startTime);
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
    mockSecurityCenter.addResponse(expectedResponse);

    ResourceName resource = SourceName.of("[ORGANIZATION]", "[SOURCE]");
    Policy policy = Policy.newBuilder().build();

    Policy actualResponse = client.setIamPolicy(resource, policy);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SetIamPolicyRequest actualRequest = ((SetIamPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(resource.toString(), actualRequest.getResource());
    Assert.assertEquals(policy, actualRequest.getPolicy());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void setIamPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      ResourceName resource = SourceName.of("[ORGANIZATION]", "[SOURCE]");
      Policy policy = Policy.newBuilder().build();
      client.setIamPolicy(resource, policy);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void setIamPolicyTest2() throws Exception {
    Policy expectedResponse =
        Policy.newBuilder()
            .setVersion(351608024)
            .addAllBindings(new ArrayList<Binding>())
            .addAllAuditConfigs(new ArrayList<AuditConfig>())
            .setEtag(ByteString.EMPTY)
            .build();
    mockSecurityCenter.addResponse(expectedResponse);

    String resource = "resource-341064690";
    Policy policy = Policy.newBuilder().build();

    Policy actualResponse = client.setIamPolicy(resource, policy);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SetIamPolicyRequest actualRequest = ((SetIamPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(resource, actualRequest.getResource());
    Assert.assertEquals(policy, actualRequest.getPolicy());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void setIamPolicyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      String resource = "resource-341064690";
      Policy policy = Policy.newBuilder().build();
      client.setIamPolicy(resource, policy);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void testIamPermissionsTest() throws Exception {
    TestIamPermissionsResponse expectedResponse =
        TestIamPermissionsResponse.newBuilder().addAllPermissions(new ArrayList<String>()).build();
    mockSecurityCenter.addResponse(expectedResponse);

    ResourceName resource = SourceName.of("[ORGANIZATION]", "[SOURCE]");
    List<String> permissions = new ArrayList<>();

    TestIamPermissionsResponse actualResponse = client.testIamPermissions(resource, permissions);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    TestIamPermissionsRequest actualRequest = ((TestIamPermissionsRequest) actualRequests.get(0));

    Assert.assertEquals(resource.toString(), actualRequest.getResource());
    Assert.assertEquals(permissions, actualRequest.getPermissionsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void testIamPermissionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      ResourceName resource = SourceName.of("[ORGANIZATION]", "[SOURCE]");
      List<String> permissions = new ArrayList<>();
      client.testIamPermissions(resource, permissions);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void testIamPermissionsTest2() throws Exception {
    TestIamPermissionsResponse expectedResponse =
        TestIamPermissionsResponse.newBuilder().addAllPermissions(new ArrayList<String>()).build();
    mockSecurityCenter.addResponse(expectedResponse);

    String resource = "resource-341064690";
    List<String> permissions = new ArrayList<>();

    TestIamPermissionsResponse actualResponse = client.testIamPermissions(resource, permissions);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    TestIamPermissionsRequest actualRequest = ((TestIamPermissionsRequest) actualRequests.get(0));

    Assert.assertEquals(resource, actualRequest.getResource());
    Assert.assertEquals(permissions, actualRequest.getPermissionsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void testIamPermissionsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      String resource = "resource-341064690";
      List<String> permissions = new ArrayList<>();
      client.testIamPermissions(resource, permissions);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateFindingTest() throws Exception {
    Finding expectedResponse =
        Finding.newBuilder()
            .setName(FindingName.of("[ORGANIZATION]", "[SOURCE]", "[FINDING]").toString())
            .setParent("parent-995424086")
            .setResourceName("resourceName-384566343")
            .setCategory("category50511102")
            .setExternalUri("externalUri-1153085023")
            .putAllSourceProperties(new HashMap<String, Value>())
            .setSecurityMarks(SecurityMarks.newBuilder().build())
            .setEventTime(Timestamp.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    mockSecurityCenter.addResponse(expectedResponse);

    Finding finding = Finding.newBuilder().build();

    Finding actualResponse = client.updateFinding(finding);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateFindingRequest actualRequest = ((UpdateFindingRequest) actualRequests.get(0));

    Assert.assertEquals(finding, actualRequest.getFinding());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateFindingExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      Finding finding = Finding.newBuilder().build();
      client.updateFinding(finding);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateOrganizationSettingsTest() throws Exception {
    OrganizationSettings expectedResponse =
        OrganizationSettings.newBuilder()
            .setName(OrganizationSettingsName.of("[ORGANIZATION]").toString())
            .setEnableAssetDiscovery(true)
            .setAssetDiscoveryConfig(OrganizationSettings.AssetDiscoveryConfig.newBuilder().build())
            .build();
    mockSecurityCenter.addResponse(expectedResponse);

    OrganizationSettings organizationSettings = OrganizationSettings.newBuilder().build();

    OrganizationSettings actualResponse = client.updateOrganizationSettings(organizationSettings);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateOrganizationSettingsRequest actualRequest =
        ((UpdateOrganizationSettingsRequest) actualRequests.get(0));

    Assert.assertEquals(organizationSettings, actualRequest.getOrganizationSettings());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateOrganizationSettingsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      OrganizationSettings organizationSettings = OrganizationSettings.newBuilder().build();
      client.updateOrganizationSettings(organizationSettings);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateSourceTest() throws Exception {
    Source expectedResponse =
        Source.newBuilder()
            .setName(SourceName.of("[ORGANIZATION]", "[SOURCE]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .build();
    mockSecurityCenter.addResponse(expectedResponse);

    Source source = Source.newBuilder().build();

    Source actualResponse = client.updateSource(source);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateSourceRequest actualRequest = ((UpdateSourceRequest) actualRequests.get(0));

    Assert.assertEquals(source, actualRequest.getSource());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateSourceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      Source source = Source.newBuilder().build();
      client.updateSource(source);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateSecurityMarksTest() throws Exception {
    SecurityMarks expectedResponse =
        SecurityMarks.newBuilder()
            .setName("name3373707")
            .putAllMarks(new HashMap<String, String>())
            .build();
    mockSecurityCenter.addResponse(expectedResponse);

    SecurityMarks securityMarks = SecurityMarks.newBuilder().build();

    SecurityMarks actualResponse = client.updateSecurityMarks(securityMarks);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateSecurityMarksRequest actualRequest = ((UpdateSecurityMarksRequest) actualRequests.get(0));

    Assert.assertEquals(securityMarks, actualRequest.getSecurityMarks());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateSecurityMarksExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      SecurityMarks securityMarks = SecurityMarks.newBuilder().build();
      client.updateSecurityMarks(securityMarks);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
