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

package com.google.cloud.assuredworkloads.v1;

import static com.google.cloud.assuredworkloads.v1.AssuredWorkloadsServiceClient.ListViolationsPagedResponse;
import static com.google.cloud.assuredworkloads.v1.AssuredWorkloadsServiceClient.ListWorkloadsPagedResponse;

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
public class AssuredWorkloadsServiceClientTest {
  private static MockAssuredWorkloadsService mockAssuredWorkloadsService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private AssuredWorkloadsServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockAssuredWorkloadsService = new MockAssuredWorkloadsService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockAssuredWorkloadsService));
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
    AssuredWorkloadsServiceSettings settings =
        AssuredWorkloadsServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = AssuredWorkloadsServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createWorkloadTest() throws Exception {
    Workload expectedResponse =
        Workload.newBuilder()
            .setName(WorkloadName.of("[ORGANIZATION]", "[LOCATION]", "[WORKLOAD]").toString())
            .setDisplayName("displayName1714148973")
            .addAllResources(new ArrayList<Workload.ResourceInfo>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setBillingAccount("billingAccount708726578")
            .setEtag("etag3123477")
            .putAllLabels(new HashMap<String, String>())
            .setProvisionedResourcesParent("provisionedResourcesParent1733249115")
            .setKmsSettings(Workload.KMSSettings.newBuilder().build())
            .addAllResourceSettings(new ArrayList<Workload.ResourceSettings>())
            .setEnableSovereignControls(true)
            .setSaaEnrollmentResponse(Workload.SaaEnrollmentResponse.newBuilder().build())
            .addAllCompliantButDisallowedServices(new ArrayList<String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createWorkloadTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAssuredWorkloadsService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[ORGANIZATION]", "[LOCATION]");
    Workload workload = Workload.newBuilder().build();

    Workload actualResponse = client.createWorkloadAsync(parent, workload).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAssuredWorkloadsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateWorkloadRequest actualRequest = ((CreateWorkloadRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(workload, actualRequest.getWorkload());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createWorkloadExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAssuredWorkloadsService.addException(exception);

    try {
      LocationName parent = LocationName.of("[ORGANIZATION]", "[LOCATION]");
      Workload workload = Workload.newBuilder().build();
      client.createWorkloadAsync(parent, workload).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createWorkloadTest2() throws Exception {
    Workload expectedResponse =
        Workload.newBuilder()
            .setName(WorkloadName.of("[ORGANIZATION]", "[LOCATION]", "[WORKLOAD]").toString())
            .setDisplayName("displayName1714148973")
            .addAllResources(new ArrayList<Workload.ResourceInfo>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setBillingAccount("billingAccount708726578")
            .setEtag("etag3123477")
            .putAllLabels(new HashMap<String, String>())
            .setProvisionedResourcesParent("provisionedResourcesParent1733249115")
            .setKmsSettings(Workload.KMSSettings.newBuilder().build())
            .addAllResourceSettings(new ArrayList<Workload.ResourceSettings>())
            .setEnableSovereignControls(true)
            .setSaaEnrollmentResponse(Workload.SaaEnrollmentResponse.newBuilder().build())
            .addAllCompliantButDisallowedServices(new ArrayList<String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createWorkloadTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAssuredWorkloadsService.addResponse(resultOperation);

    String parent = "parent-995424086";
    Workload workload = Workload.newBuilder().build();

    Workload actualResponse = client.createWorkloadAsync(parent, workload).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAssuredWorkloadsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateWorkloadRequest actualRequest = ((CreateWorkloadRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(workload, actualRequest.getWorkload());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createWorkloadExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAssuredWorkloadsService.addException(exception);

    try {
      String parent = "parent-995424086";
      Workload workload = Workload.newBuilder().build();
      client.createWorkloadAsync(parent, workload).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateWorkloadTest() throws Exception {
    Workload expectedResponse =
        Workload.newBuilder()
            .setName(WorkloadName.of("[ORGANIZATION]", "[LOCATION]", "[WORKLOAD]").toString())
            .setDisplayName("displayName1714148973")
            .addAllResources(new ArrayList<Workload.ResourceInfo>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setBillingAccount("billingAccount708726578")
            .setEtag("etag3123477")
            .putAllLabels(new HashMap<String, String>())
            .setProvisionedResourcesParent("provisionedResourcesParent1733249115")
            .setKmsSettings(Workload.KMSSettings.newBuilder().build())
            .addAllResourceSettings(new ArrayList<Workload.ResourceSettings>())
            .setEnableSovereignControls(true)
            .setSaaEnrollmentResponse(Workload.SaaEnrollmentResponse.newBuilder().build())
            .addAllCompliantButDisallowedServices(new ArrayList<String>())
            .build();
    mockAssuredWorkloadsService.addResponse(expectedResponse);

    Workload workload = Workload.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Workload actualResponse = client.updateWorkload(workload, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAssuredWorkloadsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateWorkloadRequest actualRequest = ((UpdateWorkloadRequest) actualRequests.get(0));

    Assert.assertEquals(workload, actualRequest.getWorkload());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateWorkloadExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAssuredWorkloadsService.addException(exception);

    try {
      Workload workload = Workload.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateWorkload(workload, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void restrictAllowedResourcesTest() throws Exception {
    RestrictAllowedResourcesResponse expectedResponse =
        RestrictAllowedResourcesResponse.newBuilder().build();
    mockAssuredWorkloadsService.addResponse(expectedResponse);

    RestrictAllowedResourcesRequest request =
        RestrictAllowedResourcesRequest.newBuilder().setName("name3373707").build();

    RestrictAllowedResourcesResponse actualResponse = client.restrictAllowedResources(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAssuredWorkloadsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RestrictAllowedResourcesRequest actualRequest =
        ((RestrictAllowedResourcesRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getRestrictionType(), actualRequest.getRestrictionType());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void restrictAllowedResourcesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAssuredWorkloadsService.addException(exception);

    try {
      RestrictAllowedResourcesRequest request =
          RestrictAllowedResourcesRequest.newBuilder().setName("name3373707").build();
      client.restrictAllowedResources(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteWorkloadTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockAssuredWorkloadsService.addResponse(expectedResponse);

    WorkloadName name = WorkloadName.of("[ORGANIZATION]", "[LOCATION]", "[WORKLOAD]");

    client.deleteWorkload(name);

    List<AbstractMessage> actualRequests = mockAssuredWorkloadsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteWorkloadRequest actualRequest = ((DeleteWorkloadRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteWorkloadExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAssuredWorkloadsService.addException(exception);

    try {
      WorkloadName name = WorkloadName.of("[ORGANIZATION]", "[LOCATION]", "[WORKLOAD]");
      client.deleteWorkload(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteWorkloadTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockAssuredWorkloadsService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteWorkload(name);

    List<AbstractMessage> actualRequests = mockAssuredWorkloadsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteWorkloadRequest actualRequest = ((DeleteWorkloadRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteWorkloadExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAssuredWorkloadsService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteWorkload(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getWorkloadTest() throws Exception {
    Workload expectedResponse =
        Workload.newBuilder()
            .setName(WorkloadName.of("[ORGANIZATION]", "[LOCATION]", "[WORKLOAD]").toString())
            .setDisplayName("displayName1714148973")
            .addAllResources(new ArrayList<Workload.ResourceInfo>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setBillingAccount("billingAccount708726578")
            .setEtag("etag3123477")
            .putAllLabels(new HashMap<String, String>())
            .setProvisionedResourcesParent("provisionedResourcesParent1733249115")
            .setKmsSettings(Workload.KMSSettings.newBuilder().build())
            .addAllResourceSettings(new ArrayList<Workload.ResourceSettings>())
            .setEnableSovereignControls(true)
            .setSaaEnrollmentResponse(Workload.SaaEnrollmentResponse.newBuilder().build())
            .addAllCompliantButDisallowedServices(new ArrayList<String>())
            .build();
    mockAssuredWorkloadsService.addResponse(expectedResponse);

    WorkloadName name = WorkloadName.of("[ORGANIZATION]", "[LOCATION]", "[WORKLOAD]");

    Workload actualResponse = client.getWorkload(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAssuredWorkloadsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetWorkloadRequest actualRequest = ((GetWorkloadRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getWorkloadExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAssuredWorkloadsService.addException(exception);

    try {
      WorkloadName name = WorkloadName.of("[ORGANIZATION]", "[LOCATION]", "[WORKLOAD]");
      client.getWorkload(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getWorkloadTest2() throws Exception {
    Workload expectedResponse =
        Workload.newBuilder()
            .setName(WorkloadName.of("[ORGANIZATION]", "[LOCATION]", "[WORKLOAD]").toString())
            .setDisplayName("displayName1714148973")
            .addAllResources(new ArrayList<Workload.ResourceInfo>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setBillingAccount("billingAccount708726578")
            .setEtag("etag3123477")
            .putAllLabels(new HashMap<String, String>())
            .setProvisionedResourcesParent("provisionedResourcesParent1733249115")
            .setKmsSettings(Workload.KMSSettings.newBuilder().build())
            .addAllResourceSettings(new ArrayList<Workload.ResourceSettings>())
            .setEnableSovereignControls(true)
            .setSaaEnrollmentResponse(Workload.SaaEnrollmentResponse.newBuilder().build())
            .addAllCompliantButDisallowedServices(new ArrayList<String>())
            .build();
    mockAssuredWorkloadsService.addResponse(expectedResponse);

    String name = "name3373707";

    Workload actualResponse = client.getWorkload(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAssuredWorkloadsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetWorkloadRequest actualRequest = ((GetWorkloadRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getWorkloadExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAssuredWorkloadsService.addException(exception);

    try {
      String name = "name3373707";
      client.getWorkload(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listWorkloadsTest() throws Exception {
    Workload responsesElement = Workload.newBuilder().build();
    ListWorkloadsResponse expectedResponse =
        ListWorkloadsResponse.newBuilder()
            .setNextPageToken("")
            .addAllWorkloads(Arrays.asList(responsesElement))
            .build();
    mockAssuredWorkloadsService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[ORGANIZATION]", "[LOCATION]");

    ListWorkloadsPagedResponse pagedListResponse = client.listWorkloads(parent);

    List<Workload> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getWorkloadsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAssuredWorkloadsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListWorkloadsRequest actualRequest = ((ListWorkloadsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listWorkloadsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAssuredWorkloadsService.addException(exception);

    try {
      LocationName parent = LocationName.of("[ORGANIZATION]", "[LOCATION]");
      client.listWorkloads(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listWorkloadsTest2() throws Exception {
    Workload responsesElement = Workload.newBuilder().build();
    ListWorkloadsResponse expectedResponse =
        ListWorkloadsResponse.newBuilder()
            .setNextPageToken("")
            .addAllWorkloads(Arrays.asList(responsesElement))
            .build();
    mockAssuredWorkloadsService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListWorkloadsPagedResponse pagedListResponse = client.listWorkloads(parent);

    List<Workload> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getWorkloadsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAssuredWorkloadsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListWorkloadsRequest actualRequest = ((ListWorkloadsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listWorkloadsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAssuredWorkloadsService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listWorkloads(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listViolationsTest() throws Exception {
    Violation responsesElement = Violation.newBuilder().build();
    ListViolationsResponse expectedResponse =
        ListViolationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllViolations(Arrays.asList(responsesElement))
            .build();
    mockAssuredWorkloadsService.addResponse(expectedResponse);

    WorkloadName parent = WorkloadName.of("[ORGANIZATION]", "[LOCATION]", "[WORKLOAD]");

    ListViolationsPagedResponse pagedListResponse = client.listViolations(parent);

    List<Violation> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getViolationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAssuredWorkloadsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListViolationsRequest actualRequest = ((ListViolationsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listViolationsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAssuredWorkloadsService.addException(exception);

    try {
      WorkloadName parent = WorkloadName.of("[ORGANIZATION]", "[LOCATION]", "[WORKLOAD]");
      client.listViolations(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listViolationsTest2() throws Exception {
    Violation responsesElement = Violation.newBuilder().build();
    ListViolationsResponse expectedResponse =
        ListViolationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllViolations(Arrays.asList(responsesElement))
            .build();
    mockAssuredWorkloadsService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListViolationsPagedResponse pagedListResponse = client.listViolations(parent);

    List<Violation> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getViolationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAssuredWorkloadsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListViolationsRequest actualRequest = ((ListViolationsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listViolationsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAssuredWorkloadsService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listViolations(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getViolationTest() throws Exception {
    Violation expectedResponse =
        Violation.newBuilder()
            .setName(
                ViolationName.of("[ORGANIZATION]", "[LOCATION]", "[WORKLOAD]", "[VIOLATION]")
                    .toString())
            .setDescription("description-1724546052")
            .setBeginTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setResolveTime(Timestamp.newBuilder().build())
            .setCategory("category50511102")
            .setOrgPolicyConstraint("orgPolicyConstraint-2139427917")
            .setAuditLogLink("auditLogLink-1120762621")
            .setNonCompliantOrgPolicy("nonCompliantOrgPolicy-1928466552")
            .setRemediation(Violation.Remediation.newBuilder().build())
            .setAcknowledged(true)
            .setAcknowledgementTime(Timestamp.newBuilder().build())
            .setExceptionAuditLogLink("exceptionAuditLogLink814000882")
            .build();
    mockAssuredWorkloadsService.addResponse(expectedResponse);

    ViolationName name =
        ViolationName.of("[ORGANIZATION]", "[LOCATION]", "[WORKLOAD]", "[VIOLATION]");

    Violation actualResponse = client.getViolation(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAssuredWorkloadsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetViolationRequest actualRequest = ((GetViolationRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getViolationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAssuredWorkloadsService.addException(exception);

    try {
      ViolationName name =
          ViolationName.of("[ORGANIZATION]", "[LOCATION]", "[WORKLOAD]", "[VIOLATION]");
      client.getViolation(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getViolationTest2() throws Exception {
    Violation expectedResponse =
        Violation.newBuilder()
            .setName(
                ViolationName.of("[ORGANIZATION]", "[LOCATION]", "[WORKLOAD]", "[VIOLATION]")
                    .toString())
            .setDescription("description-1724546052")
            .setBeginTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setResolveTime(Timestamp.newBuilder().build())
            .setCategory("category50511102")
            .setOrgPolicyConstraint("orgPolicyConstraint-2139427917")
            .setAuditLogLink("auditLogLink-1120762621")
            .setNonCompliantOrgPolicy("nonCompliantOrgPolicy-1928466552")
            .setRemediation(Violation.Remediation.newBuilder().build())
            .setAcknowledged(true)
            .setAcknowledgementTime(Timestamp.newBuilder().build())
            .setExceptionAuditLogLink("exceptionAuditLogLink814000882")
            .build();
    mockAssuredWorkloadsService.addResponse(expectedResponse);

    String name = "name3373707";

    Violation actualResponse = client.getViolation(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAssuredWorkloadsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetViolationRequest actualRequest = ((GetViolationRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getViolationExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAssuredWorkloadsService.addException(exception);

    try {
      String name = "name3373707";
      client.getViolation(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void acknowledgeViolationTest() throws Exception {
    AcknowledgeViolationResponse expectedResponse =
        AcknowledgeViolationResponse.newBuilder().build();
    mockAssuredWorkloadsService.addResponse(expectedResponse);

    AcknowledgeViolationRequest request =
        AcknowledgeViolationRequest.newBuilder()
            .setName("name3373707")
            .setComment("comment950398559")
            .setNonCompliantOrgPolicy("nonCompliantOrgPolicy-1928466552")
            .build();

    AcknowledgeViolationResponse actualResponse = client.acknowledgeViolation(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAssuredWorkloadsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    AcknowledgeViolationRequest actualRequest =
        ((AcknowledgeViolationRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getComment(), actualRequest.getComment());
    Assert.assertEquals(
        request.getNonCompliantOrgPolicy(), actualRequest.getNonCompliantOrgPolicy());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void acknowledgeViolationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAssuredWorkloadsService.addException(exception);

    try {
      AcknowledgeViolationRequest request =
          AcknowledgeViolationRequest.newBuilder()
              .setName("name3373707")
              .setComment("comment950398559")
              .setNonCompliantOrgPolicy("nonCompliantOrgPolicy-1928466552")
              .build();
      client.acknowledgeViolation(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
