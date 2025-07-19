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

package com.google.cloud.policysimulator.v1;

import static com.google.cloud.policysimulator.v1.OrgPolicyViolationsPreviewServiceClient.ListOrgPolicyViolationsPagedResponse;
import static com.google.cloud.policysimulator.v1.OrgPolicyViolationsPreviewServiceClient.ListOrgPolicyViolationsPreviewsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.protobuf.Timestamp;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
public class OrgPolicyViolationsPreviewServiceClientTest {
  private static MockOrgPolicyViolationsPreviewService mockOrgPolicyViolationsPreviewService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private OrgPolicyViolationsPreviewServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockOrgPolicyViolationsPreviewService = new MockOrgPolicyViolationsPreviewService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockOrgPolicyViolationsPreviewService));
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
    OrgPolicyViolationsPreviewServiceSettings settings =
        OrgPolicyViolationsPreviewServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = OrgPolicyViolationsPreviewServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listOrgPolicyViolationsPreviewsTest() throws Exception {
    OrgPolicyViolationsPreview responsesElement = OrgPolicyViolationsPreview.newBuilder().build();
    ListOrgPolicyViolationsPreviewsResponse expectedResponse =
        ListOrgPolicyViolationsPreviewsResponse.newBuilder()
            .setNextPageToken("")
            .addAllOrgPolicyViolationsPreviews(Arrays.asList(responsesElement))
            .build();
    mockOrgPolicyViolationsPreviewService.addResponse(expectedResponse);

    OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");

    ListOrgPolicyViolationsPreviewsPagedResponse pagedListResponse =
        client.listOrgPolicyViolationsPreviews(parent);

    List<OrgPolicyViolationsPreview> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getOrgPolicyViolationsPreviewsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockOrgPolicyViolationsPreviewService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListOrgPolicyViolationsPreviewsRequest actualRequest =
        ((ListOrgPolicyViolationsPreviewsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listOrgPolicyViolationsPreviewsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOrgPolicyViolationsPreviewService.addException(exception);

    try {
      OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
      client.listOrgPolicyViolationsPreviews(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listOrgPolicyViolationsPreviewsTest2() throws Exception {
    OrgPolicyViolationsPreview responsesElement = OrgPolicyViolationsPreview.newBuilder().build();
    ListOrgPolicyViolationsPreviewsResponse expectedResponse =
        ListOrgPolicyViolationsPreviewsResponse.newBuilder()
            .setNextPageToken("")
            .addAllOrgPolicyViolationsPreviews(Arrays.asList(responsesElement))
            .build();
    mockOrgPolicyViolationsPreviewService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListOrgPolicyViolationsPreviewsPagedResponse pagedListResponse =
        client.listOrgPolicyViolationsPreviews(parent);

    List<OrgPolicyViolationsPreview> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getOrgPolicyViolationsPreviewsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockOrgPolicyViolationsPreviewService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListOrgPolicyViolationsPreviewsRequest actualRequest =
        ((ListOrgPolicyViolationsPreviewsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listOrgPolicyViolationsPreviewsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOrgPolicyViolationsPreviewService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listOrgPolicyViolationsPreviews(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getOrgPolicyViolationsPreviewTest() throws Exception {
    OrgPolicyViolationsPreview expectedResponse =
        OrgPolicyViolationsPreview.newBuilder()
            .setName(
                OrgPolicyViolationsPreviewName.of(
                        "[ORGANIZATION]", "[LOCATION]", "[ORG_POLICY_VIOLATIONS_PREVIEW]")
                    .toString())
            .setState(PreviewState.forNumber(0))
            .setOverlay(OrgPolicyOverlay.newBuilder().build())
            .setViolationsCount(1314508158)
            .setResourceCounts(OrgPolicyViolationsPreview.ResourceCounts.newBuilder().build())
            .addAllCustomConstraints(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    mockOrgPolicyViolationsPreviewService.addResponse(expectedResponse);

    OrgPolicyViolationsPreviewName name =
        OrgPolicyViolationsPreviewName.of(
            "[ORGANIZATION]", "[LOCATION]", "[ORG_POLICY_VIOLATIONS_PREVIEW]");

    OrgPolicyViolationsPreview actualResponse = client.getOrgPolicyViolationsPreview(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOrgPolicyViolationsPreviewService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetOrgPolicyViolationsPreviewRequest actualRequest =
        ((GetOrgPolicyViolationsPreviewRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getOrgPolicyViolationsPreviewExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOrgPolicyViolationsPreviewService.addException(exception);

    try {
      OrgPolicyViolationsPreviewName name =
          OrgPolicyViolationsPreviewName.of(
              "[ORGANIZATION]", "[LOCATION]", "[ORG_POLICY_VIOLATIONS_PREVIEW]");
      client.getOrgPolicyViolationsPreview(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getOrgPolicyViolationsPreviewTest2() throws Exception {
    OrgPolicyViolationsPreview expectedResponse =
        OrgPolicyViolationsPreview.newBuilder()
            .setName(
                OrgPolicyViolationsPreviewName.of(
                        "[ORGANIZATION]", "[LOCATION]", "[ORG_POLICY_VIOLATIONS_PREVIEW]")
                    .toString())
            .setState(PreviewState.forNumber(0))
            .setOverlay(OrgPolicyOverlay.newBuilder().build())
            .setViolationsCount(1314508158)
            .setResourceCounts(OrgPolicyViolationsPreview.ResourceCounts.newBuilder().build())
            .addAllCustomConstraints(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    mockOrgPolicyViolationsPreviewService.addResponse(expectedResponse);

    String name = "name3373707";

    OrgPolicyViolationsPreview actualResponse = client.getOrgPolicyViolationsPreview(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOrgPolicyViolationsPreviewService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetOrgPolicyViolationsPreviewRequest actualRequest =
        ((GetOrgPolicyViolationsPreviewRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getOrgPolicyViolationsPreviewExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOrgPolicyViolationsPreviewService.addException(exception);

    try {
      String name = "name3373707";
      client.getOrgPolicyViolationsPreview(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createOrgPolicyViolationsPreviewTest() throws Exception {
    OrgPolicyViolationsPreview expectedResponse =
        OrgPolicyViolationsPreview.newBuilder()
            .setName(
                OrgPolicyViolationsPreviewName.of(
                        "[ORGANIZATION]", "[LOCATION]", "[ORG_POLICY_VIOLATIONS_PREVIEW]")
                    .toString())
            .setState(PreviewState.forNumber(0))
            .setOverlay(OrgPolicyOverlay.newBuilder().build())
            .setViolationsCount(1314508158)
            .setResourceCounts(OrgPolicyViolationsPreview.ResourceCounts.newBuilder().build())
            .addAllCustomConstraints(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createOrgPolicyViolationsPreviewTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockOrgPolicyViolationsPreviewService.addResponse(resultOperation);

    OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
    OrgPolicyViolationsPreview orgPolicyViolationsPreview =
        OrgPolicyViolationsPreview.newBuilder().build();
    String orgPolicyViolationsPreviewId = "orgPolicyViolationsPreviewId2098912671";

    OrgPolicyViolationsPreview actualResponse =
        client
            .createOrgPolicyViolationsPreviewAsync(
                parent, orgPolicyViolationsPreview, orgPolicyViolationsPreviewId)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOrgPolicyViolationsPreviewService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateOrgPolicyViolationsPreviewRequest actualRequest =
        ((CreateOrgPolicyViolationsPreviewRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(orgPolicyViolationsPreview, actualRequest.getOrgPolicyViolationsPreview());
    Assert.assertEquals(
        orgPolicyViolationsPreviewId, actualRequest.getOrgPolicyViolationsPreviewId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createOrgPolicyViolationsPreviewExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOrgPolicyViolationsPreviewService.addException(exception);

    try {
      OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
      OrgPolicyViolationsPreview orgPolicyViolationsPreview =
          OrgPolicyViolationsPreview.newBuilder().build();
      String orgPolicyViolationsPreviewId = "orgPolicyViolationsPreviewId2098912671";
      client
          .createOrgPolicyViolationsPreviewAsync(
              parent, orgPolicyViolationsPreview, orgPolicyViolationsPreviewId)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createOrgPolicyViolationsPreviewTest2() throws Exception {
    OrgPolicyViolationsPreview expectedResponse =
        OrgPolicyViolationsPreview.newBuilder()
            .setName(
                OrgPolicyViolationsPreviewName.of(
                        "[ORGANIZATION]", "[LOCATION]", "[ORG_POLICY_VIOLATIONS_PREVIEW]")
                    .toString())
            .setState(PreviewState.forNumber(0))
            .setOverlay(OrgPolicyOverlay.newBuilder().build())
            .setViolationsCount(1314508158)
            .setResourceCounts(OrgPolicyViolationsPreview.ResourceCounts.newBuilder().build())
            .addAllCustomConstraints(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createOrgPolicyViolationsPreviewTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockOrgPolicyViolationsPreviewService.addResponse(resultOperation);

    String parent = "parent-995424086";
    OrgPolicyViolationsPreview orgPolicyViolationsPreview =
        OrgPolicyViolationsPreview.newBuilder().build();
    String orgPolicyViolationsPreviewId = "orgPolicyViolationsPreviewId2098912671";

    OrgPolicyViolationsPreview actualResponse =
        client
            .createOrgPolicyViolationsPreviewAsync(
                parent, orgPolicyViolationsPreview, orgPolicyViolationsPreviewId)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOrgPolicyViolationsPreviewService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateOrgPolicyViolationsPreviewRequest actualRequest =
        ((CreateOrgPolicyViolationsPreviewRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(orgPolicyViolationsPreview, actualRequest.getOrgPolicyViolationsPreview());
    Assert.assertEquals(
        orgPolicyViolationsPreviewId, actualRequest.getOrgPolicyViolationsPreviewId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createOrgPolicyViolationsPreviewExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOrgPolicyViolationsPreviewService.addException(exception);

    try {
      String parent = "parent-995424086";
      OrgPolicyViolationsPreview orgPolicyViolationsPreview =
          OrgPolicyViolationsPreview.newBuilder().build();
      String orgPolicyViolationsPreviewId = "orgPolicyViolationsPreviewId2098912671";
      client
          .createOrgPolicyViolationsPreviewAsync(
              parent, orgPolicyViolationsPreview, orgPolicyViolationsPreviewId)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listOrgPolicyViolationsTest() throws Exception {
    OrgPolicyViolation responsesElement = OrgPolicyViolation.newBuilder().build();
    ListOrgPolicyViolationsResponse expectedResponse =
        ListOrgPolicyViolationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllOrgPolicyViolations(Arrays.asList(responsesElement))
            .build();
    mockOrgPolicyViolationsPreviewService.addResponse(expectedResponse);

    OrgPolicyViolationsPreviewName parent =
        OrgPolicyViolationsPreviewName.of(
            "[ORGANIZATION]", "[LOCATION]", "[ORG_POLICY_VIOLATIONS_PREVIEW]");

    ListOrgPolicyViolationsPagedResponse pagedListResponse = client.listOrgPolicyViolations(parent);

    List<OrgPolicyViolation> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getOrgPolicyViolationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockOrgPolicyViolationsPreviewService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListOrgPolicyViolationsRequest actualRequest =
        ((ListOrgPolicyViolationsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listOrgPolicyViolationsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOrgPolicyViolationsPreviewService.addException(exception);

    try {
      OrgPolicyViolationsPreviewName parent =
          OrgPolicyViolationsPreviewName.of(
              "[ORGANIZATION]", "[LOCATION]", "[ORG_POLICY_VIOLATIONS_PREVIEW]");
      client.listOrgPolicyViolations(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listOrgPolicyViolationsTest2() throws Exception {
    OrgPolicyViolation responsesElement = OrgPolicyViolation.newBuilder().build();
    ListOrgPolicyViolationsResponse expectedResponse =
        ListOrgPolicyViolationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllOrgPolicyViolations(Arrays.asList(responsesElement))
            .build();
    mockOrgPolicyViolationsPreviewService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListOrgPolicyViolationsPagedResponse pagedListResponse = client.listOrgPolicyViolations(parent);

    List<OrgPolicyViolation> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getOrgPolicyViolationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockOrgPolicyViolationsPreviewService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListOrgPolicyViolationsRequest actualRequest =
        ((ListOrgPolicyViolationsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listOrgPolicyViolationsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOrgPolicyViolationsPreviewService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listOrgPolicyViolations(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
