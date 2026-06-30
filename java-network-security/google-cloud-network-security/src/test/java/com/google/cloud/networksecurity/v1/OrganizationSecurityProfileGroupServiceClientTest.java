/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.networksecurity.v1;

import static com.google.cloud.networksecurity.v1.OrganizationSecurityProfileGroupServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.networksecurity.v1.OrganizationSecurityProfileGroupServiceClient.ListSecurityProfileGroupsPagedResponse;
import static com.google.cloud.networksecurity.v1.OrganizationSecurityProfileGroupServiceClient.ListSecurityProfilesPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.Lists;
import com.google.iam.v1.AuditConfig;
import com.google.iam.v1.Binding;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.GetPolicyOptions;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
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
import java.util.concurrent.ExecutionException;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class OrganizationSecurityProfileGroupServiceClientTest {
  private static MockIAMPolicy mockIAMPolicy;
  private static MockLocations mockLocations;
  private static MockOrganizationSecurityProfileGroupService
      mockOrganizationSecurityProfileGroupService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private OrganizationSecurityProfileGroupServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockOrganizationSecurityProfileGroupService = new MockOrganizationSecurityProfileGroupService();
    mockLocations = new MockLocations();
    mockIAMPolicy = new MockIAMPolicy();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(
                mockOrganizationSecurityProfileGroupService, mockLocations, mockIAMPolicy));
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
    OrganizationSecurityProfileGroupServiceSettings settings =
        OrganizationSecurityProfileGroupServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = OrganizationSecurityProfileGroupServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listSecurityProfileGroupsTest() throws Exception {
    SecurityProfileGroup responsesElement = SecurityProfileGroup.newBuilder().build();
    ListSecurityProfileGroupsResponse expectedResponse =
        ListSecurityProfileGroupsResponse.newBuilder()
            .setNextPageToken("")
            .addAllSecurityProfileGroups(Arrays.asList(responsesElement))
            .build();
    mockOrganizationSecurityProfileGroupService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListSecurityProfileGroupsPagedResponse pagedListResponse =
        client.listSecurityProfileGroups(parent);

    List<SecurityProfileGroup> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSecurityProfileGroupsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests =
        mockOrganizationSecurityProfileGroupService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListSecurityProfileGroupsRequest actualRequest =
        ((ListSecurityProfileGroupsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listSecurityProfileGroupsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOrganizationSecurityProfileGroupService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listSecurityProfileGroups(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSecurityProfileGroupsTest2() throws Exception {
    SecurityProfileGroup responsesElement = SecurityProfileGroup.newBuilder().build();
    ListSecurityProfileGroupsResponse expectedResponse =
        ListSecurityProfileGroupsResponse.newBuilder()
            .setNextPageToken("")
            .addAllSecurityProfileGroups(Arrays.asList(responsesElement))
            .build();
    mockOrganizationSecurityProfileGroupService.addResponse(expectedResponse);

    OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");

    ListSecurityProfileGroupsPagedResponse pagedListResponse =
        client.listSecurityProfileGroups(parent);

    List<SecurityProfileGroup> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSecurityProfileGroupsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests =
        mockOrganizationSecurityProfileGroupService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListSecurityProfileGroupsRequest actualRequest =
        ((ListSecurityProfileGroupsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listSecurityProfileGroupsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOrganizationSecurityProfileGroupService.addException(exception);

    try {
      OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
      client.listSecurityProfileGroups(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSecurityProfileGroupsTest3() throws Exception {
    SecurityProfileGroup responsesElement = SecurityProfileGroup.newBuilder().build();
    ListSecurityProfileGroupsResponse expectedResponse =
        ListSecurityProfileGroupsResponse.newBuilder()
            .setNextPageToken("")
            .addAllSecurityProfileGroups(Arrays.asList(responsesElement))
            .build();
    mockOrganizationSecurityProfileGroupService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListSecurityProfileGroupsPagedResponse pagedListResponse =
        client.listSecurityProfileGroups(parent);

    List<SecurityProfileGroup> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSecurityProfileGroupsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests =
        mockOrganizationSecurityProfileGroupService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListSecurityProfileGroupsRequest actualRequest =
        ((ListSecurityProfileGroupsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listSecurityProfileGroupsExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOrganizationSecurityProfileGroupService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listSecurityProfileGroups(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSecurityProfileGroupTest() throws Exception {
    SecurityProfileGroup expectedResponse =
        SecurityProfileGroup.newBuilder()
            .setName(
                SecurityProfileGroupName.ofOrganizationLocationSecurityProfileGroupName(
                        "[ORGANIZATION]", "[LOCATION]", "[SECURITY_PROFILE_GROUP]")
                    .toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setDataPathId(-1465603104)
            .putAllLabels(new HashMap<String, String>())
            .setThreatPreventionProfile(
                SecurityProfileName.ofOrganizationLocationSecurityProfileName(
                        "[ORGANIZATION]", "[LOCATION]", "[SECURITY_PROFILE]")
                    .toString())
            .setCustomMirroringProfile(
                SecurityProfileName.ofOrganizationLocationSecurityProfileName(
                        "[ORGANIZATION]", "[LOCATION]", "[SECURITY_PROFILE]")
                    .toString())
            .setCustomInterceptProfile(
                SecurityProfileName.ofOrganizationLocationSecurityProfileName(
                        "[ORGANIZATION]", "[LOCATION]", "[SECURITY_PROFILE]")
                    .toString())
            .setUrlFilteringProfile(
                SecurityProfileName.ofOrganizationLocationSecurityProfileName(
                        "[ORGANIZATION]", "[LOCATION]", "[SECURITY_PROFILE]")
                    .toString())
            .build();
    mockOrganizationSecurityProfileGroupService.addResponse(expectedResponse);

    SecurityProfileGroupName name =
        SecurityProfileGroupName.ofOrganizationLocationSecurityProfileGroupName(
            "[ORGANIZATION]", "[LOCATION]", "[SECURITY_PROFILE_GROUP]");

    SecurityProfileGroup actualResponse = client.getSecurityProfileGroup(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests =
        mockOrganizationSecurityProfileGroupService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSecurityProfileGroupRequest actualRequest =
        ((GetSecurityProfileGroupRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getSecurityProfileGroupExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOrganizationSecurityProfileGroupService.addException(exception);

    try {
      SecurityProfileGroupName name =
          SecurityProfileGroupName.ofOrganizationLocationSecurityProfileGroupName(
              "[ORGANIZATION]", "[LOCATION]", "[SECURITY_PROFILE_GROUP]");
      client.getSecurityProfileGroup(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSecurityProfileGroupTest2() throws Exception {
    SecurityProfileGroup expectedResponse =
        SecurityProfileGroup.newBuilder()
            .setName(
                SecurityProfileGroupName.ofOrganizationLocationSecurityProfileGroupName(
                        "[ORGANIZATION]", "[LOCATION]", "[SECURITY_PROFILE_GROUP]")
                    .toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setDataPathId(-1465603104)
            .putAllLabels(new HashMap<String, String>())
            .setThreatPreventionProfile(
                SecurityProfileName.ofOrganizationLocationSecurityProfileName(
                        "[ORGANIZATION]", "[LOCATION]", "[SECURITY_PROFILE]")
                    .toString())
            .setCustomMirroringProfile(
                SecurityProfileName.ofOrganizationLocationSecurityProfileName(
                        "[ORGANIZATION]", "[LOCATION]", "[SECURITY_PROFILE]")
                    .toString())
            .setCustomInterceptProfile(
                SecurityProfileName.ofOrganizationLocationSecurityProfileName(
                        "[ORGANIZATION]", "[LOCATION]", "[SECURITY_PROFILE]")
                    .toString())
            .setUrlFilteringProfile(
                SecurityProfileName.ofOrganizationLocationSecurityProfileName(
                        "[ORGANIZATION]", "[LOCATION]", "[SECURITY_PROFILE]")
                    .toString())
            .build();
    mockOrganizationSecurityProfileGroupService.addResponse(expectedResponse);

    String name = "name3373707";

    SecurityProfileGroup actualResponse = client.getSecurityProfileGroup(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests =
        mockOrganizationSecurityProfileGroupService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSecurityProfileGroupRequest actualRequest =
        ((GetSecurityProfileGroupRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getSecurityProfileGroupExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOrganizationSecurityProfileGroupService.addException(exception);

    try {
      String name = "name3373707";
      client.getSecurityProfileGroup(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createSecurityProfileGroupTest() throws Exception {
    SecurityProfileGroup expectedResponse =
        SecurityProfileGroup.newBuilder()
            .setName(
                SecurityProfileGroupName.ofOrganizationLocationSecurityProfileGroupName(
                        "[ORGANIZATION]", "[LOCATION]", "[SECURITY_PROFILE_GROUP]")
                    .toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setDataPathId(-1465603104)
            .putAllLabels(new HashMap<String, String>())
            .setThreatPreventionProfile(
                SecurityProfileName.ofOrganizationLocationSecurityProfileName(
                        "[ORGANIZATION]", "[LOCATION]", "[SECURITY_PROFILE]")
                    .toString())
            .setCustomMirroringProfile(
                SecurityProfileName.ofOrganizationLocationSecurityProfileName(
                        "[ORGANIZATION]", "[LOCATION]", "[SECURITY_PROFILE]")
                    .toString())
            .setCustomInterceptProfile(
                SecurityProfileName.ofOrganizationLocationSecurityProfileName(
                        "[ORGANIZATION]", "[LOCATION]", "[SECURITY_PROFILE]")
                    .toString())
            .setUrlFilteringProfile(
                SecurityProfileName.ofOrganizationLocationSecurityProfileName(
                        "[ORGANIZATION]", "[LOCATION]", "[SECURITY_PROFILE]")
                    .toString())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createSecurityProfileGroupTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockOrganizationSecurityProfileGroupService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    SecurityProfileGroup securityProfileGroup = SecurityProfileGroup.newBuilder().build();
    String securityProfileGroupId = "securityProfileGroupId-357991055";

    SecurityProfileGroup actualResponse =
        client
            .createSecurityProfileGroupAsync(parent, securityProfileGroup, securityProfileGroupId)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests =
        mockOrganizationSecurityProfileGroupService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateSecurityProfileGroupRequest actualRequest =
        ((CreateSecurityProfileGroupRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(securityProfileGroup, actualRequest.getSecurityProfileGroup());
    Assert.assertEquals(securityProfileGroupId, actualRequest.getSecurityProfileGroupId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createSecurityProfileGroupExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOrganizationSecurityProfileGroupService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      SecurityProfileGroup securityProfileGroup = SecurityProfileGroup.newBuilder().build();
      String securityProfileGroupId = "securityProfileGroupId-357991055";
      client
          .createSecurityProfileGroupAsync(parent, securityProfileGroup, securityProfileGroupId)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createSecurityProfileGroupTest2() throws Exception {
    SecurityProfileGroup expectedResponse =
        SecurityProfileGroup.newBuilder()
            .setName(
                SecurityProfileGroupName.ofOrganizationLocationSecurityProfileGroupName(
                        "[ORGANIZATION]", "[LOCATION]", "[SECURITY_PROFILE_GROUP]")
                    .toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setDataPathId(-1465603104)
            .putAllLabels(new HashMap<String, String>())
            .setThreatPreventionProfile(
                SecurityProfileName.ofOrganizationLocationSecurityProfileName(
                        "[ORGANIZATION]", "[LOCATION]", "[SECURITY_PROFILE]")
                    .toString())
            .setCustomMirroringProfile(
                SecurityProfileName.ofOrganizationLocationSecurityProfileName(
                        "[ORGANIZATION]", "[LOCATION]", "[SECURITY_PROFILE]")
                    .toString())
            .setCustomInterceptProfile(
                SecurityProfileName.ofOrganizationLocationSecurityProfileName(
                        "[ORGANIZATION]", "[LOCATION]", "[SECURITY_PROFILE]")
                    .toString())
            .setUrlFilteringProfile(
                SecurityProfileName.ofOrganizationLocationSecurityProfileName(
                        "[ORGANIZATION]", "[LOCATION]", "[SECURITY_PROFILE]")
                    .toString())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createSecurityProfileGroupTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockOrganizationSecurityProfileGroupService.addResponse(resultOperation);

    OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
    SecurityProfileGroup securityProfileGroup = SecurityProfileGroup.newBuilder().build();
    String securityProfileGroupId = "securityProfileGroupId-357991055";

    SecurityProfileGroup actualResponse =
        client
            .createSecurityProfileGroupAsync(parent, securityProfileGroup, securityProfileGroupId)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests =
        mockOrganizationSecurityProfileGroupService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateSecurityProfileGroupRequest actualRequest =
        ((CreateSecurityProfileGroupRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(securityProfileGroup, actualRequest.getSecurityProfileGroup());
    Assert.assertEquals(securityProfileGroupId, actualRequest.getSecurityProfileGroupId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createSecurityProfileGroupExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOrganizationSecurityProfileGroupService.addException(exception);

    try {
      OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
      SecurityProfileGroup securityProfileGroup = SecurityProfileGroup.newBuilder().build();
      String securityProfileGroupId = "securityProfileGroupId-357991055";
      client
          .createSecurityProfileGroupAsync(parent, securityProfileGroup, securityProfileGroupId)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createSecurityProfileGroupTest3() throws Exception {
    SecurityProfileGroup expectedResponse =
        SecurityProfileGroup.newBuilder()
            .setName(
                SecurityProfileGroupName.ofOrganizationLocationSecurityProfileGroupName(
                        "[ORGANIZATION]", "[LOCATION]", "[SECURITY_PROFILE_GROUP]")
                    .toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setDataPathId(-1465603104)
            .putAllLabels(new HashMap<String, String>())
            .setThreatPreventionProfile(
                SecurityProfileName.ofOrganizationLocationSecurityProfileName(
                        "[ORGANIZATION]", "[LOCATION]", "[SECURITY_PROFILE]")
                    .toString())
            .setCustomMirroringProfile(
                SecurityProfileName.ofOrganizationLocationSecurityProfileName(
                        "[ORGANIZATION]", "[LOCATION]", "[SECURITY_PROFILE]")
                    .toString())
            .setCustomInterceptProfile(
                SecurityProfileName.ofOrganizationLocationSecurityProfileName(
                        "[ORGANIZATION]", "[LOCATION]", "[SECURITY_PROFILE]")
                    .toString())
            .setUrlFilteringProfile(
                SecurityProfileName.ofOrganizationLocationSecurityProfileName(
                        "[ORGANIZATION]", "[LOCATION]", "[SECURITY_PROFILE]")
                    .toString())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createSecurityProfileGroupTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockOrganizationSecurityProfileGroupService.addResponse(resultOperation);

    String parent = "parent-995424086";
    SecurityProfileGroup securityProfileGroup = SecurityProfileGroup.newBuilder().build();
    String securityProfileGroupId = "securityProfileGroupId-357991055";

    SecurityProfileGroup actualResponse =
        client
            .createSecurityProfileGroupAsync(parent, securityProfileGroup, securityProfileGroupId)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests =
        mockOrganizationSecurityProfileGroupService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateSecurityProfileGroupRequest actualRequest =
        ((CreateSecurityProfileGroupRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(securityProfileGroup, actualRequest.getSecurityProfileGroup());
    Assert.assertEquals(securityProfileGroupId, actualRequest.getSecurityProfileGroupId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createSecurityProfileGroupExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOrganizationSecurityProfileGroupService.addException(exception);

    try {
      String parent = "parent-995424086";
      SecurityProfileGroup securityProfileGroup = SecurityProfileGroup.newBuilder().build();
      String securityProfileGroupId = "securityProfileGroupId-357991055";
      client
          .createSecurityProfileGroupAsync(parent, securityProfileGroup, securityProfileGroupId)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateSecurityProfileGroupTest() throws Exception {
    SecurityProfileGroup expectedResponse =
        SecurityProfileGroup.newBuilder()
            .setName(
                SecurityProfileGroupName.ofOrganizationLocationSecurityProfileGroupName(
                        "[ORGANIZATION]", "[LOCATION]", "[SECURITY_PROFILE_GROUP]")
                    .toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setDataPathId(-1465603104)
            .putAllLabels(new HashMap<String, String>())
            .setThreatPreventionProfile(
                SecurityProfileName.ofOrganizationLocationSecurityProfileName(
                        "[ORGANIZATION]", "[LOCATION]", "[SECURITY_PROFILE]")
                    .toString())
            .setCustomMirroringProfile(
                SecurityProfileName.ofOrganizationLocationSecurityProfileName(
                        "[ORGANIZATION]", "[LOCATION]", "[SECURITY_PROFILE]")
                    .toString())
            .setCustomInterceptProfile(
                SecurityProfileName.ofOrganizationLocationSecurityProfileName(
                        "[ORGANIZATION]", "[LOCATION]", "[SECURITY_PROFILE]")
                    .toString())
            .setUrlFilteringProfile(
                SecurityProfileName.ofOrganizationLocationSecurityProfileName(
                        "[ORGANIZATION]", "[LOCATION]", "[SECURITY_PROFILE]")
                    .toString())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateSecurityProfileGroupTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockOrganizationSecurityProfileGroupService.addResponse(resultOperation);

    SecurityProfileGroup securityProfileGroup = SecurityProfileGroup.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    SecurityProfileGroup actualResponse =
        client.updateSecurityProfileGroupAsync(securityProfileGroup, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests =
        mockOrganizationSecurityProfileGroupService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateSecurityProfileGroupRequest actualRequest =
        ((UpdateSecurityProfileGroupRequest) actualRequests.get(0));

    Assert.assertEquals(securityProfileGroup, actualRequest.getSecurityProfileGroup());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateSecurityProfileGroupExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOrganizationSecurityProfileGroupService.addException(exception);

    try {
      SecurityProfileGroup securityProfileGroup = SecurityProfileGroup.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateSecurityProfileGroupAsync(securityProfileGroup, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteSecurityProfileGroupTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteSecurityProfileGroupTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockOrganizationSecurityProfileGroupService.addResponse(resultOperation);

    SecurityProfileGroupName name =
        SecurityProfileGroupName.ofOrganizationLocationSecurityProfileGroupName(
            "[ORGANIZATION]", "[LOCATION]", "[SECURITY_PROFILE_GROUP]");

    client.deleteSecurityProfileGroupAsync(name).get();

    List<AbstractMessage> actualRequests =
        mockOrganizationSecurityProfileGroupService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteSecurityProfileGroupRequest actualRequest =
        ((DeleteSecurityProfileGroupRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteSecurityProfileGroupExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOrganizationSecurityProfileGroupService.addException(exception);

    try {
      SecurityProfileGroupName name =
          SecurityProfileGroupName.ofOrganizationLocationSecurityProfileGroupName(
              "[ORGANIZATION]", "[LOCATION]", "[SECURITY_PROFILE_GROUP]");
      client.deleteSecurityProfileGroupAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteSecurityProfileGroupTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteSecurityProfileGroupTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockOrganizationSecurityProfileGroupService.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteSecurityProfileGroupAsync(name).get();

    List<AbstractMessage> actualRequests =
        mockOrganizationSecurityProfileGroupService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteSecurityProfileGroupRequest actualRequest =
        ((DeleteSecurityProfileGroupRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteSecurityProfileGroupExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOrganizationSecurityProfileGroupService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteSecurityProfileGroupAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listSecurityProfilesTest() throws Exception {
    SecurityProfile responsesElement = SecurityProfile.newBuilder().build();
    ListSecurityProfilesResponse expectedResponse =
        ListSecurityProfilesResponse.newBuilder()
            .setNextPageToken("")
            .addAllSecurityProfiles(Arrays.asList(responsesElement))
            .build();
    mockOrganizationSecurityProfileGroupService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListSecurityProfilesPagedResponse pagedListResponse = client.listSecurityProfiles(parent);

    List<SecurityProfile> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSecurityProfilesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests =
        mockOrganizationSecurityProfileGroupService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListSecurityProfilesRequest actualRequest =
        ((ListSecurityProfilesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listSecurityProfilesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOrganizationSecurityProfileGroupService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listSecurityProfiles(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSecurityProfilesTest2() throws Exception {
    SecurityProfile responsesElement = SecurityProfile.newBuilder().build();
    ListSecurityProfilesResponse expectedResponse =
        ListSecurityProfilesResponse.newBuilder()
            .setNextPageToken("")
            .addAllSecurityProfiles(Arrays.asList(responsesElement))
            .build();
    mockOrganizationSecurityProfileGroupService.addResponse(expectedResponse);

    OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");

    ListSecurityProfilesPagedResponse pagedListResponse = client.listSecurityProfiles(parent);

    List<SecurityProfile> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSecurityProfilesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests =
        mockOrganizationSecurityProfileGroupService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListSecurityProfilesRequest actualRequest =
        ((ListSecurityProfilesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listSecurityProfilesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOrganizationSecurityProfileGroupService.addException(exception);

    try {
      OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
      client.listSecurityProfiles(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSecurityProfilesTest3() throws Exception {
    SecurityProfile responsesElement = SecurityProfile.newBuilder().build();
    ListSecurityProfilesResponse expectedResponse =
        ListSecurityProfilesResponse.newBuilder()
            .setNextPageToken("")
            .addAllSecurityProfiles(Arrays.asList(responsesElement))
            .build();
    mockOrganizationSecurityProfileGroupService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListSecurityProfilesPagedResponse pagedListResponse = client.listSecurityProfiles(parent);

    List<SecurityProfile> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSecurityProfilesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests =
        mockOrganizationSecurityProfileGroupService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListSecurityProfilesRequest actualRequest =
        ((ListSecurityProfilesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listSecurityProfilesExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOrganizationSecurityProfileGroupService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listSecurityProfiles(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSecurityProfileTest() throws Exception {
    SecurityProfile expectedResponse =
        SecurityProfile.newBuilder()
            .setName(
                SecurityProfileName.ofOrganizationLocationSecurityProfileName(
                        "[ORGANIZATION]", "[LOCATION]", "[SECURITY_PROFILE]")
                    .toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .putAllLabels(new HashMap<String, String>())
            .build();
    mockOrganizationSecurityProfileGroupService.addResponse(expectedResponse);

    SecurityProfileName name =
        SecurityProfileName.ofOrganizationLocationSecurityProfileName(
            "[ORGANIZATION]", "[LOCATION]", "[SECURITY_PROFILE]");

    SecurityProfile actualResponse = client.getSecurityProfile(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests =
        mockOrganizationSecurityProfileGroupService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSecurityProfileRequest actualRequest = ((GetSecurityProfileRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getSecurityProfileExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOrganizationSecurityProfileGroupService.addException(exception);

    try {
      SecurityProfileName name =
          SecurityProfileName.ofOrganizationLocationSecurityProfileName(
              "[ORGANIZATION]", "[LOCATION]", "[SECURITY_PROFILE]");
      client.getSecurityProfile(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSecurityProfileTest2() throws Exception {
    SecurityProfile expectedResponse =
        SecurityProfile.newBuilder()
            .setName(
                SecurityProfileName.ofOrganizationLocationSecurityProfileName(
                        "[ORGANIZATION]", "[LOCATION]", "[SECURITY_PROFILE]")
                    .toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .putAllLabels(new HashMap<String, String>())
            .build();
    mockOrganizationSecurityProfileGroupService.addResponse(expectedResponse);

    String name = "name3373707";

    SecurityProfile actualResponse = client.getSecurityProfile(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests =
        mockOrganizationSecurityProfileGroupService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSecurityProfileRequest actualRequest = ((GetSecurityProfileRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getSecurityProfileExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOrganizationSecurityProfileGroupService.addException(exception);

    try {
      String name = "name3373707";
      client.getSecurityProfile(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createSecurityProfileTest() throws Exception {
    SecurityProfile expectedResponse =
        SecurityProfile.newBuilder()
            .setName(
                SecurityProfileName.ofOrganizationLocationSecurityProfileName(
                        "[ORGANIZATION]", "[LOCATION]", "[SECURITY_PROFILE]")
                    .toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .putAllLabels(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createSecurityProfileTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockOrganizationSecurityProfileGroupService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    SecurityProfile securityProfile = SecurityProfile.newBuilder().build();
    String securityProfileId = "securityProfileId-1121673916";

    SecurityProfile actualResponse =
        client.createSecurityProfileAsync(parent, securityProfile, securityProfileId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests =
        mockOrganizationSecurityProfileGroupService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateSecurityProfileRequest actualRequest =
        ((CreateSecurityProfileRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(securityProfile, actualRequest.getSecurityProfile());
    Assert.assertEquals(securityProfileId, actualRequest.getSecurityProfileId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createSecurityProfileExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOrganizationSecurityProfileGroupService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      SecurityProfile securityProfile = SecurityProfile.newBuilder().build();
      String securityProfileId = "securityProfileId-1121673916";
      client.createSecurityProfileAsync(parent, securityProfile, securityProfileId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createSecurityProfileTest2() throws Exception {
    SecurityProfile expectedResponse =
        SecurityProfile.newBuilder()
            .setName(
                SecurityProfileName.ofOrganizationLocationSecurityProfileName(
                        "[ORGANIZATION]", "[LOCATION]", "[SECURITY_PROFILE]")
                    .toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .putAllLabels(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createSecurityProfileTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockOrganizationSecurityProfileGroupService.addResponse(resultOperation);

    OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
    SecurityProfile securityProfile = SecurityProfile.newBuilder().build();
    String securityProfileId = "securityProfileId-1121673916";

    SecurityProfile actualResponse =
        client.createSecurityProfileAsync(parent, securityProfile, securityProfileId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests =
        mockOrganizationSecurityProfileGroupService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateSecurityProfileRequest actualRequest =
        ((CreateSecurityProfileRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(securityProfile, actualRequest.getSecurityProfile());
    Assert.assertEquals(securityProfileId, actualRequest.getSecurityProfileId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createSecurityProfileExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOrganizationSecurityProfileGroupService.addException(exception);

    try {
      OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
      SecurityProfile securityProfile = SecurityProfile.newBuilder().build();
      String securityProfileId = "securityProfileId-1121673916";
      client.createSecurityProfileAsync(parent, securityProfile, securityProfileId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createSecurityProfileTest3() throws Exception {
    SecurityProfile expectedResponse =
        SecurityProfile.newBuilder()
            .setName(
                SecurityProfileName.ofOrganizationLocationSecurityProfileName(
                        "[ORGANIZATION]", "[LOCATION]", "[SECURITY_PROFILE]")
                    .toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .putAllLabels(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createSecurityProfileTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockOrganizationSecurityProfileGroupService.addResponse(resultOperation);

    String parent = "parent-995424086";
    SecurityProfile securityProfile = SecurityProfile.newBuilder().build();
    String securityProfileId = "securityProfileId-1121673916";

    SecurityProfile actualResponse =
        client.createSecurityProfileAsync(parent, securityProfile, securityProfileId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests =
        mockOrganizationSecurityProfileGroupService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateSecurityProfileRequest actualRequest =
        ((CreateSecurityProfileRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(securityProfile, actualRequest.getSecurityProfile());
    Assert.assertEquals(securityProfileId, actualRequest.getSecurityProfileId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createSecurityProfileExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOrganizationSecurityProfileGroupService.addException(exception);

    try {
      String parent = "parent-995424086";
      SecurityProfile securityProfile = SecurityProfile.newBuilder().build();
      String securityProfileId = "securityProfileId-1121673916";
      client.createSecurityProfileAsync(parent, securityProfile, securityProfileId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateSecurityProfileTest() throws Exception {
    SecurityProfile expectedResponse =
        SecurityProfile.newBuilder()
            .setName(
                SecurityProfileName.ofOrganizationLocationSecurityProfileName(
                        "[ORGANIZATION]", "[LOCATION]", "[SECURITY_PROFILE]")
                    .toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .putAllLabels(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateSecurityProfileTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockOrganizationSecurityProfileGroupService.addResponse(resultOperation);

    SecurityProfile securityProfile = SecurityProfile.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    SecurityProfile actualResponse =
        client.updateSecurityProfileAsync(securityProfile, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests =
        mockOrganizationSecurityProfileGroupService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateSecurityProfileRequest actualRequest =
        ((UpdateSecurityProfileRequest) actualRequests.get(0));

    Assert.assertEquals(securityProfile, actualRequest.getSecurityProfile());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateSecurityProfileExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOrganizationSecurityProfileGroupService.addException(exception);

    try {
      SecurityProfile securityProfile = SecurityProfile.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateSecurityProfileAsync(securityProfile, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteSecurityProfileTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteSecurityProfileTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockOrganizationSecurityProfileGroupService.addResponse(resultOperation);

    SecurityProfileName name =
        SecurityProfileName.ofOrganizationLocationSecurityProfileName(
            "[ORGANIZATION]", "[LOCATION]", "[SECURITY_PROFILE]");

    client.deleteSecurityProfileAsync(name).get();

    List<AbstractMessage> actualRequests =
        mockOrganizationSecurityProfileGroupService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteSecurityProfileRequest actualRequest =
        ((DeleteSecurityProfileRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteSecurityProfileExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOrganizationSecurityProfileGroupService.addException(exception);

    try {
      SecurityProfileName name =
          SecurityProfileName.ofOrganizationLocationSecurityProfileName(
              "[ORGANIZATION]", "[LOCATION]", "[SECURITY_PROFILE]");
      client.deleteSecurityProfileAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteSecurityProfileTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteSecurityProfileTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockOrganizationSecurityProfileGroupService.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteSecurityProfileAsync(name).get();

    List<AbstractMessage> actualRequests =
        mockOrganizationSecurityProfileGroupService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteSecurityProfileRequest actualRequest =
        ((DeleteSecurityProfileRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteSecurityProfileExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOrganizationSecurityProfileGroupService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteSecurityProfileAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listLocationsTest() throws Exception {
    Location responsesElement = Location.newBuilder().build();
    ListLocationsResponse expectedResponse =
        ListLocationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllLocations(Arrays.asList(responsesElement))
            .build();
    mockLocations.addResponse(expectedResponse);

    ListLocationsRequest request =
        ListLocationsRequest.newBuilder()
            .setName("name3373707")
            .setFilter("filter-1274492040")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    ListLocationsPagedResponse pagedListResponse = client.listLocations(request);

    List<Location> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLocationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockLocations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListLocationsRequest actualRequest = ((ListLocationsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getFilter(), actualRequest.getFilter());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listLocationsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLocations.addException(exception);

    try {
      ListLocationsRequest request =
          ListLocationsRequest.newBuilder()
              .setName("name3373707")
              .setFilter("filter-1274492040")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      client.listLocations(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getLocationTest() throws Exception {
    Location expectedResponse =
        Location.newBuilder()
            .setName("name3373707")
            .setLocationId("locationId1541836720")
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setMetadata(Any.newBuilder().build())
            .build();
    mockLocations.addResponse(expectedResponse);

    GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();

    Location actualResponse = client.getLocation(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLocations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetLocationRequest actualRequest = ((GetLocationRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getLocationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLocations.addException(exception);

    try {
      GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
      client.getLocation(request);
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
                AddressGroupName.ofProjectLocationAddressGroupName(
                        "[PROJECT]", "[LOCATION]", "[ADDRESS_GROUP]")
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
                  AddressGroupName.ofProjectLocationAddressGroupName(
                          "[PROJECT]", "[LOCATION]", "[ADDRESS_GROUP]")
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
                AddressGroupName.ofProjectLocationAddressGroupName(
                        "[PROJECT]", "[LOCATION]", "[ADDRESS_GROUP]")
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
                  AddressGroupName.ofProjectLocationAddressGroupName(
                          "[PROJECT]", "[LOCATION]", "[ADDRESS_GROUP]")
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
                AddressGroupName.ofProjectLocationAddressGroupName(
                        "[PROJECT]", "[LOCATION]", "[ADDRESS_GROUP]")
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
                  AddressGroupName.ofProjectLocationAddressGroupName(
                          "[PROJECT]", "[LOCATION]", "[ADDRESS_GROUP]")
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
