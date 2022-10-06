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

package com.google.cloud.osconfig.v1;

import static com.google.cloud.osconfig.v1.OsConfigZonalServiceClient.ListInventoriesPagedResponse;
import static com.google.cloud.osconfig.v1.OsConfigZonalServiceClient.ListOSPolicyAssignmentReportsPagedResponse;
import static com.google.cloud.osconfig.v1.OsConfigZonalServiceClient.ListOSPolicyAssignmentRevisionsPagedResponse;
import static com.google.cloud.osconfig.v1.OsConfigZonalServiceClient.ListOSPolicyAssignmentsPagedResponse;
import static com.google.cloud.osconfig.v1.OsConfigZonalServiceClient.ListVulnerabilityReportsPagedResponse;

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
public class OsConfigZonalServiceClientTest {
  private static MockOsConfigZonalService mockOsConfigZonalService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private OsConfigZonalServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockOsConfigZonalService = new MockOsConfigZonalService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockOsConfigZonalService));
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
    OsConfigZonalServiceSettings settings =
        OsConfigZonalServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = OsConfigZonalServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createOSPolicyAssignmentTest() throws Exception {
    OSPolicyAssignment expectedResponse =
        OSPolicyAssignment.newBuilder()
            .setName(
                OSPolicyAssignmentName.of("[PROJECT]", "[LOCATION]", "[OS_POLICY_ASSIGNMENT]")
                    .toString())
            .setDescription("description-1724546052")
            .addAllOsPolicies(new ArrayList<OSPolicy>())
            .setInstanceFilter(OSPolicyAssignment.InstanceFilter.newBuilder().build())
            .setRollout(OSPolicyAssignment.Rollout.newBuilder().build())
            .setRevisionId("revisionId-1507445162")
            .setRevisionCreateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setBaseline(true)
            .setDeleted(true)
            .setReconciling(true)
            .setUid("uid115792")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createOSPolicyAssignmentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockOsConfigZonalService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    OSPolicyAssignment osPolicyAssignment = OSPolicyAssignment.newBuilder().build();
    String osPolicyAssignmentId = "osPolicyAssignmentId-44079074";

    OSPolicyAssignment actualResponse =
        client
            .createOSPolicyAssignmentAsync(parent, osPolicyAssignment, osPolicyAssignmentId)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOsConfigZonalService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateOSPolicyAssignmentRequest actualRequest =
        ((CreateOSPolicyAssignmentRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(osPolicyAssignment, actualRequest.getOsPolicyAssignment());
    Assert.assertEquals(osPolicyAssignmentId, actualRequest.getOsPolicyAssignmentId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createOSPolicyAssignmentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOsConfigZonalService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      OSPolicyAssignment osPolicyAssignment = OSPolicyAssignment.newBuilder().build();
      String osPolicyAssignmentId = "osPolicyAssignmentId-44079074";
      client.createOSPolicyAssignmentAsync(parent, osPolicyAssignment, osPolicyAssignmentId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createOSPolicyAssignmentTest2() throws Exception {
    OSPolicyAssignment expectedResponse =
        OSPolicyAssignment.newBuilder()
            .setName(
                OSPolicyAssignmentName.of("[PROJECT]", "[LOCATION]", "[OS_POLICY_ASSIGNMENT]")
                    .toString())
            .setDescription("description-1724546052")
            .addAllOsPolicies(new ArrayList<OSPolicy>())
            .setInstanceFilter(OSPolicyAssignment.InstanceFilter.newBuilder().build())
            .setRollout(OSPolicyAssignment.Rollout.newBuilder().build())
            .setRevisionId("revisionId-1507445162")
            .setRevisionCreateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setBaseline(true)
            .setDeleted(true)
            .setReconciling(true)
            .setUid("uid115792")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createOSPolicyAssignmentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockOsConfigZonalService.addResponse(resultOperation);

    String parent = "parent-995424086";
    OSPolicyAssignment osPolicyAssignment = OSPolicyAssignment.newBuilder().build();
    String osPolicyAssignmentId = "osPolicyAssignmentId-44079074";

    OSPolicyAssignment actualResponse =
        client
            .createOSPolicyAssignmentAsync(parent, osPolicyAssignment, osPolicyAssignmentId)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOsConfigZonalService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateOSPolicyAssignmentRequest actualRequest =
        ((CreateOSPolicyAssignmentRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(osPolicyAssignment, actualRequest.getOsPolicyAssignment());
    Assert.assertEquals(osPolicyAssignmentId, actualRequest.getOsPolicyAssignmentId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createOSPolicyAssignmentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOsConfigZonalService.addException(exception);

    try {
      String parent = "parent-995424086";
      OSPolicyAssignment osPolicyAssignment = OSPolicyAssignment.newBuilder().build();
      String osPolicyAssignmentId = "osPolicyAssignmentId-44079074";
      client.createOSPolicyAssignmentAsync(parent, osPolicyAssignment, osPolicyAssignmentId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateOSPolicyAssignmentTest() throws Exception {
    OSPolicyAssignment expectedResponse =
        OSPolicyAssignment.newBuilder()
            .setName(
                OSPolicyAssignmentName.of("[PROJECT]", "[LOCATION]", "[OS_POLICY_ASSIGNMENT]")
                    .toString())
            .setDescription("description-1724546052")
            .addAllOsPolicies(new ArrayList<OSPolicy>())
            .setInstanceFilter(OSPolicyAssignment.InstanceFilter.newBuilder().build())
            .setRollout(OSPolicyAssignment.Rollout.newBuilder().build())
            .setRevisionId("revisionId-1507445162")
            .setRevisionCreateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setBaseline(true)
            .setDeleted(true)
            .setReconciling(true)
            .setUid("uid115792")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateOSPolicyAssignmentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockOsConfigZonalService.addResponse(resultOperation);

    OSPolicyAssignment osPolicyAssignment = OSPolicyAssignment.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    OSPolicyAssignment actualResponse =
        client.updateOSPolicyAssignmentAsync(osPolicyAssignment, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOsConfigZonalService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateOSPolicyAssignmentRequest actualRequest =
        ((UpdateOSPolicyAssignmentRequest) actualRequests.get(0));

    Assert.assertEquals(osPolicyAssignment, actualRequest.getOsPolicyAssignment());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateOSPolicyAssignmentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOsConfigZonalService.addException(exception);

    try {
      OSPolicyAssignment osPolicyAssignment = OSPolicyAssignment.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateOSPolicyAssignmentAsync(osPolicyAssignment, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void getOSPolicyAssignmentTest() throws Exception {
    OSPolicyAssignment expectedResponse =
        OSPolicyAssignment.newBuilder()
            .setName(
                OSPolicyAssignmentName.of("[PROJECT]", "[LOCATION]", "[OS_POLICY_ASSIGNMENT]")
                    .toString())
            .setDescription("description-1724546052")
            .addAllOsPolicies(new ArrayList<OSPolicy>())
            .setInstanceFilter(OSPolicyAssignment.InstanceFilter.newBuilder().build())
            .setRollout(OSPolicyAssignment.Rollout.newBuilder().build())
            .setRevisionId("revisionId-1507445162")
            .setRevisionCreateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setBaseline(true)
            .setDeleted(true)
            .setReconciling(true)
            .setUid("uid115792")
            .build();
    mockOsConfigZonalService.addResponse(expectedResponse);

    OSPolicyAssignmentName name =
        OSPolicyAssignmentName.of("[PROJECT]", "[LOCATION]", "[OS_POLICY_ASSIGNMENT]");

    OSPolicyAssignment actualResponse = client.getOSPolicyAssignment(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOsConfigZonalService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetOSPolicyAssignmentRequest actualRequest =
        ((GetOSPolicyAssignmentRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getOSPolicyAssignmentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOsConfigZonalService.addException(exception);

    try {
      OSPolicyAssignmentName name =
          OSPolicyAssignmentName.of("[PROJECT]", "[LOCATION]", "[OS_POLICY_ASSIGNMENT]");
      client.getOSPolicyAssignment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getOSPolicyAssignmentTest2() throws Exception {
    OSPolicyAssignment expectedResponse =
        OSPolicyAssignment.newBuilder()
            .setName(
                OSPolicyAssignmentName.of("[PROJECT]", "[LOCATION]", "[OS_POLICY_ASSIGNMENT]")
                    .toString())
            .setDescription("description-1724546052")
            .addAllOsPolicies(new ArrayList<OSPolicy>())
            .setInstanceFilter(OSPolicyAssignment.InstanceFilter.newBuilder().build())
            .setRollout(OSPolicyAssignment.Rollout.newBuilder().build())
            .setRevisionId("revisionId-1507445162")
            .setRevisionCreateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setBaseline(true)
            .setDeleted(true)
            .setReconciling(true)
            .setUid("uid115792")
            .build();
    mockOsConfigZonalService.addResponse(expectedResponse);

    String name = "name3373707";

    OSPolicyAssignment actualResponse = client.getOSPolicyAssignment(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOsConfigZonalService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetOSPolicyAssignmentRequest actualRequest =
        ((GetOSPolicyAssignmentRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getOSPolicyAssignmentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOsConfigZonalService.addException(exception);

    try {
      String name = "name3373707";
      client.getOSPolicyAssignment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listOSPolicyAssignmentsTest() throws Exception {
    OSPolicyAssignment responsesElement = OSPolicyAssignment.newBuilder().build();
    ListOSPolicyAssignmentsResponse expectedResponse =
        ListOSPolicyAssignmentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllOsPolicyAssignments(Arrays.asList(responsesElement))
            .build();
    mockOsConfigZonalService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListOSPolicyAssignmentsPagedResponse pagedListResponse = client.listOSPolicyAssignments(parent);

    List<OSPolicyAssignment> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getOsPolicyAssignmentsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockOsConfigZonalService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListOSPolicyAssignmentsRequest actualRequest =
        ((ListOSPolicyAssignmentsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listOSPolicyAssignmentsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOsConfigZonalService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listOSPolicyAssignments(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listOSPolicyAssignmentsTest2() throws Exception {
    OSPolicyAssignment responsesElement = OSPolicyAssignment.newBuilder().build();
    ListOSPolicyAssignmentsResponse expectedResponse =
        ListOSPolicyAssignmentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllOsPolicyAssignments(Arrays.asList(responsesElement))
            .build();
    mockOsConfigZonalService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListOSPolicyAssignmentsPagedResponse pagedListResponse = client.listOSPolicyAssignments(parent);

    List<OSPolicyAssignment> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getOsPolicyAssignmentsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockOsConfigZonalService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListOSPolicyAssignmentsRequest actualRequest =
        ((ListOSPolicyAssignmentsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listOSPolicyAssignmentsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOsConfigZonalService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listOSPolicyAssignments(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listOSPolicyAssignmentRevisionsTest() throws Exception {
    OSPolicyAssignment responsesElement = OSPolicyAssignment.newBuilder().build();
    ListOSPolicyAssignmentRevisionsResponse expectedResponse =
        ListOSPolicyAssignmentRevisionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllOsPolicyAssignments(Arrays.asList(responsesElement))
            .build();
    mockOsConfigZonalService.addResponse(expectedResponse);

    OSPolicyAssignmentName name =
        OSPolicyAssignmentName.of("[PROJECT]", "[LOCATION]", "[OS_POLICY_ASSIGNMENT]");

    ListOSPolicyAssignmentRevisionsPagedResponse pagedListResponse =
        client.listOSPolicyAssignmentRevisions(name);

    List<OSPolicyAssignment> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getOsPolicyAssignmentsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockOsConfigZonalService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListOSPolicyAssignmentRevisionsRequest actualRequest =
        ((ListOSPolicyAssignmentRevisionsRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listOSPolicyAssignmentRevisionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOsConfigZonalService.addException(exception);

    try {
      OSPolicyAssignmentName name =
          OSPolicyAssignmentName.of("[PROJECT]", "[LOCATION]", "[OS_POLICY_ASSIGNMENT]");
      client.listOSPolicyAssignmentRevisions(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listOSPolicyAssignmentRevisionsTest2() throws Exception {
    OSPolicyAssignment responsesElement = OSPolicyAssignment.newBuilder().build();
    ListOSPolicyAssignmentRevisionsResponse expectedResponse =
        ListOSPolicyAssignmentRevisionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllOsPolicyAssignments(Arrays.asList(responsesElement))
            .build();
    mockOsConfigZonalService.addResponse(expectedResponse);

    String name = "name3373707";

    ListOSPolicyAssignmentRevisionsPagedResponse pagedListResponse =
        client.listOSPolicyAssignmentRevisions(name);

    List<OSPolicyAssignment> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getOsPolicyAssignmentsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockOsConfigZonalService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListOSPolicyAssignmentRevisionsRequest actualRequest =
        ((ListOSPolicyAssignmentRevisionsRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listOSPolicyAssignmentRevisionsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOsConfigZonalService.addException(exception);

    try {
      String name = "name3373707";
      client.listOSPolicyAssignmentRevisions(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteOSPolicyAssignmentTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteOSPolicyAssignmentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockOsConfigZonalService.addResponse(resultOperation);

    OSPolicyAssignmentName name =
        OSPolicyAssignmentName.of("[PROJECT]", "[LOCATION]", "[OS_POLICY_ASSIGNMENT]");

    client.deleteOSPolicyAssignmentAsync(name).get();

    List<AbstractMessage> actualRequests = mockOsConfigZonalService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteOSPolicyAssignmentRequest actualRequest =
        ((DeleteOSPolicyAssignmentRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteOSPolicyAssignmentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOsConfigZonalService.addException(exception);

    try {
      OSPolicyAssignmentName name =
          OSPolicyAssignmentName.of("[PROJECT]", "[LOCATION]", "[OS_POLICY_ASSIGNMENT]");
      client.deleteOSPolicyAssignmentAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteOSPolicyAssignmentTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteOSPolicyAssignmentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockOsConfigZonalService.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteOSPolicyAssignmentAsync(name).get();

    List<AbstractMessage> actualRequests = mockOsConfigZonalService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteOSPolicyAssignmentRequest actualRequest =
        ((DeleteOSPolicyAssignmentRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteOSPolicyAssignmentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOsConfigZonalService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteOSPolicyAssignmentAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void getOSPolicyAssignmentReportTest() throws Exception {
    OSPolicyAssignmentReport expectedResponse =
        OSPolicyAssignmentReport.newBuilder()
            .setName(
                OSPolicyAssignmentReportName.of(
                        "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[ASSIGNMENT]")
                    .toString())
            .setInstance("instance555127957")
            .setOsPolicyAssignment(
                OSPolicyAssignmentName.of("[PROJECT]", "[LOCATION]", "[OS_POLICY_ASSIGNMENT]")
                    .toString())
            .addAllOsPolicyCompliances(new ArrayList<OSPolicyAssignmentReport.OSPolicyCompliance>())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setLastRunId("lastRunId2001336336")
            .build();
    mockOsConfigZonalService.addResponse(expectedResponse);

    OSPolicyAssignmentReportName name =
        OSPolicyAssignmentReportName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[ASSIGNMENT]");

    OSPolicyAssignmentReport actualResponse = client.getOSPolicyAssignmentReport(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOsConfigZonalService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetOSPolicyAssignmentReportRequest actualRequest =
        ((GetOSPolicyAssignmentReportRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getOSPolicyAssignmentReportExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOsConfigZonalService.addException(exception);

    try {
      OSPolicyAssignmentReportName name =
          OSPolicyAssignmentReportName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[ASSIGNMENT]");
      client.getOSPolicyAssignmentReport(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getOSPolicyAssignmentReportTest2() throws Exception {
    OSPolicyAssignmentReport expectedResponse =
        OSPolicyAssignmentReport.newBuilder()
            .setName(
                OSPolicyAssignmentReportName.of(
                        "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[ASSIGNMENT]")
                    .toString())
            .setInstance("instance555127957")
            .setOsPolicyAssignment(
                OSPolicyAssignmentName.of("[PROJECT]", "[LOCATION]", "[OS_POLICY_ASSIGNMENT]")
                    .toString())
            .addAllOsPolicyCompliances(new ArrayList<OSPolicyAssignmentReport.OSPolicyCompliance>())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setLastRunId("lastRunId2001336336")
            .build();
    mockOsConfigZonalService.addResponse(expectedResponse);

    String name = "name3373707";

    OSPolicyAssignmentReport actualResponse = client.getOSPolicyAssignmentReport(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOsConfigZonalService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetOSPolicyAssignmentReportRequest actualRequest =
        ((GetOSPolicyAssignmentReportRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getOSPolicyAssignmentReportExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOsConfigZonalService.addException(exception);

    try {
      String name = "name3373707";
      client.getOSPolicyAssignmentReport(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listOSPolicyAssignmentReportsTest() throws Exception {
    OSPolicyAssignmentReport responsesElement = OSPolicyAssignmentReport.newBuilder().build();
    ListOSPolicyAssignmentReportsResponse expectedResponse =
        ListOSPolicyAssignmentReportsResponse.newBuilder()
            .setNextPageToken("")
            .addAllOsPolicyAssignmentReports(Arrays.asList(responsesElement))
            .build();
    mockOsConfigZonalService.addResponse(expectedResponse);

    InstanceOSPolicyAssignmentName parent =
        InstanceOSPolicyAssignmentName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[ASSIGNMENT]");

    ListOSPolicyAssignmentReportsPagedResponse pagedListResponse =
        client.listOSPolicyAssignmentReports(parent);

    List<OSPolicyAssignmentReport> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getOsPolicyAssignmentReportsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockOsConfigZonalService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListOSPolicyAssignmentReportsRequest actualRequest =
        ((ListOSPolicyAssignmentReportsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listOSPolicyAssignmentReportsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOsConfigZonalService.addException(exception);

    try {
      InstanceOSPolicyAssignmentName parent =
          InstanceOSPolicyAssignmentName.of(
              "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[ASSIGNMENT]");
      client.listOSPolicyAssignmentReports(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listOSPolicyAssignmentReportsTest2() throws Exception {
    OSPolicyAssignmentReport responsesElement = OSPolicyAssignmentReport.newBuilder().build();
    ListOSPolicyAssignmentReportsResponse expectedResponse =
        ListOSPolicyAssignmentReportsResponse.newBuilder()
            .setNextPageToken("")
            .addAllOsPolicyAssignmentReports(Arrays.asList(responsesElement))
            .build();
    mockOsConfigZonalService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListOSPolicyAssignmentReportsPagedResponse pagedListResponse =
        client.listOSPolicyAssignmentReports(parent);

    List<OSPolicyAssignmentReport> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getOsPolicyAssignmentReportsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockOsConfigZonalService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListOSPolicyAssignmentReportsRequest actualRequest =
        ((ListOSPolicyAssignmentReportsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listOSPolicyAssignmentReportsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOsConfigZonalService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listOSPolicyAssignmentReports(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getInventoryTest() throws Exception {
    Inventory expectedResponse =
        Inventory.newBuilder()
            .setName(InventoryName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
            .setOsInfo(Inventory.OsInfo.newBuilder().build())
            .putAllItems(new HashMap<String, Inventory.Item>())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockOsConfigZonalService.addResponse(expectedResponse);

    InventoryName name = InventoryName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");

    Inventory actualResponse = client.getInventory(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOsConfigZonalService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetInventoryRequest actualRequest = ((GetInventoryRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getInventoryExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOsConfigZonalService.addException(exception);

    try {
      InventoryName name = InventoryName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      client.getInventory(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getInventoryTest2() throws Exception {
    Inventory expectedResponse =
        Inventory.newBuilder()
            .setName(InventoryName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
            .setOsInfo(Inventory.OsInfo.newBuilder().build())
            .putAllItems(new HashMap<String, Inventory.Item>())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockOsConfigZonalService.addResponse(expectedResponse);

    String name = "name3373707";

    Inventory actualResponse = client.getInventory(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOsConfigZonalService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetInventoryRequest actualRequest = ((GetInventoryRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getInventoryExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOsConfigZonalService.addException(exception);

    try {
      String name = "name3373707";
      client.getInventory(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listInventoriesTest() throws Exception {
    Inventory responsesElement = Inventory.newBuilder().build();
    ListInventoriesResponse expectedResponse =
        ListInventoriesResponse.newBuilder()
            .setNextPageToken("")
            .addAllInventories(Arrays.asList(responsesElement))
            .build();
    mockOsConfigZonalService.addResponse(expectedResponse);

    InstanceName parent =
        InstanceName.ofProjectLocationInstanceName("[PROJECT]", "[LOCATION]", "[INSTANCE]");

    ListInventoriesPagedResponse pagedListResponse = client.listInventories(parent);

    List<Inventory> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getInventoriesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockOsConfigZonalService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListInventoriesRequest actualRequest = ((ListInventoriesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listInventoriesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOsConfigZonalService.addException(exception);

    try {
      InstanceName parent =
          InstanceName.ofProjectLocationInstanceName("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      client.listInventories(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listInventoriesTest2() throws Exception {
    Inventory responsesElement = Inventory.newBuilder().build();
    ListInventoriesResponse expectedResponse =
        ListInventoriesResponse.newBuilder()
            .setNextPageToken("")
            .addAllInventories(Arrays.asList(responsesElement))
            .build();
    mockOsConfigZonalService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListInventoriesPagedResponse pagedListResponse = client.listInventories(parent);

    List<Inventory> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getInventoriesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockOsConfigZonalService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListInventoriesRequest actualRequest = ((ListInventoriesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listInventoriesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOsConfigZonalService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listInventories(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getVulnerabilityReportTest() throws Exception {
    VulnerabilityReport expectedResponse =
        VulnerabilityReport.newBuilder()
            .setName(VulnerabilityReportName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
            .addAllVulnerabilities(new ArrayList<VulnerabilityReport.Vulnerability>())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockOsConfigZonalService.addResponse(expectedResponse);

    VulnerabilityReportName name =
        VulnerabilityReportName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");

    VulnerabilityReport actualResponse = client.getVulnerabilityReport(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOsConfigZonalService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetVulnerabilityReportRequest actualRequest =
        ((GetVulnerabilityReportRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getVulnerabilityReportExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOsConfigZonalService.addException(exception);

    try {
      VulnerabilityReportName name =
          VulnerabilityReportName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      client.getVulnerabilityReport(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getVulnerabilityReportTest2() throws Exception {
    VulnerabilityReport expectedResponse =
        VulnerabilityReport.newBuilder()
            .setName(VulnerabilityReportName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
            .addAllVulnerabilities(new ArrayList<VulnerabilityReport.Vulnerability>())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockOsConfigZonalService.addResponse(expectedResponse);

    String name = "name3373707";

    VulnerabilityReport actualResponse = client.getVulnerabilityReport(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOsConfigZonalService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetVulnerabilityReportRequest actualRequest =
        ((GetVulnerabilityReportRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getVulnerabilityReportExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOsConfigZonalService.addException(exception);

    try {
      String name = "name3373707";
      client.getVulnerabilityReport(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listVulnerabilityReportsTest() throws Exception {
    VulnerabilityReport responsesElement = VulnerabilityReport.newBuilder().build();
    ListVulnerabilityReportsResponse expectedResponse =
        ListVulnerabilityReportsResponse.newBuilder()
            .setNextPageToken("")
            .addAllVulnerabilityReports(Arrays.asList(responsesElement))
            .build();
    mockOsConfigZonalService.addResponse(expectedResponse);

    InstanceName parent =
        InstanceName.ofProjectLocationInstanceName("[PROJECT]", "[LOCATION]", "[INSTANCE]");

    ListVulnerabilityReportsPagedResponse pagedListResponse =
        client.listVulnerabilityReports(parent);

    List<VulnerabilityReport> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getVulnerabilityReportsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockOsConfigZonalService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListVulnerabilityReportsRequest actualRequest =
        ((ListVulnerabilityReportsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listVulnerabilityReportsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOsConfigZonalService.addException(exception);

    try {
      InstanceName parent =
          InstanceName.ofProjectLocationInstanceName("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      client.listVulnerabilityReports(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listVulnerabilityReportsTest2() throws Exception {
    VulnerabilityReport responsesElement = VulnerabilityReport.newBuilder().build();
    ListVulnerabilityReportsResponse expectedResponse =
        ListVulnerabilityReportsResponse.newBuilder()
            .setNextPageToken("")
            .addAllVulnerabilityReports(Arrays.asList(responsesElement))
            .build();
    mockOsConfigZonalService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListVulnerabilityReportsPagedResponse pagedListResponse =
        client.listVulnerabilityReports(parent);

    List<VulnerabilityReport> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getVulnerabilityReportsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockOsConfigZonalService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListVulnerabilityReportsRequest actualRequest =
        ((ListVulnerabilityReportsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listVulnerabilityReportsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOsConfigZonalService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listVulnerabilityReports(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
