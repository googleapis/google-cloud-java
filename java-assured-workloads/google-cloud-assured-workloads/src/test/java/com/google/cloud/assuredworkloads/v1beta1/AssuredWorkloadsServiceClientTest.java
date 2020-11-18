/*
 * Copyright 2020 Google LLC
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
package com.google.cloud.assuredworkloads.v1beta1;

import static com.google.cloud.assuredworkloads.v1beta1.AssuredWorkloadsServiceClient.ListWorkloadsPagedResponse;

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
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@javax.annotation.Generated("by GAPIC")
public class AssuredWorkloadsServiceClientTest {
  private static MockAssuredWorkloadsService mockAssuredWorkloadsService;
  private static MockServiceHelper serviceHelper;
  private AssuredWorkloadsServiceClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockAssuredWorkloadsService = new MockAssuredWorkloadsService();
    serviceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockAssuredWorkloadsService));
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
  @SuppressWarnings("all")
  public void createWorkloadTest() throws Exception {
    WorkloadName name = WorkloadName.of("[ORGANIZATION]", "[LOCATION]", "[WORKLOAD]");
    String displayName = "displayName1615086568";
    String billingAccount = "billingAccount-545871767";
    String etag = "etag3123477";
    String provisionedResourcesParent = "provisionedResourcesParent-158134097";
    Workload expectedResponse =
        Workload.newBuilder()
            .setName(name.toString())
            .setDisplayName(displayName)
            .setBillingAccount(billingAccount)
            .setEtag(etag)
            .setProvisionedResourcesParent(provisionedResourcesParent)
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
    CreateWorkloadRequest actualRequest = (CreateWorkloadRequest) actualRequests.get(0);

    Assert.assertEquals(parent, LocationName.parse(actualRequest.getParent()));
    Assert.assertEquals(workload, actualRequest.getWorkload());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createWorkloadExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockAssuredWorkloadsService.addException(exception);

    try {
      LocationName parent = LocationName.of("[ORGANIZATION]", "[LOCATION]");
      Workload workload = Workload.newBuilder().build();

      client.createWorkloadAsync(parent, workload).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateWorkloadTest() {
    WorkloadName name = WorkloadName.of("[ORGANIZATION]", "[LOCATION]", "[WORKLOAD]");
    String displayName = "displayName1615086568";
    String billingAccount = "billingAccount-545871767";
    String etag = "etag3123477";
    String provisionedResourcesParent = "provisionedResourcesParent-158134097";
    Workload expectedResponse =
        Workload.newBuilder()
            .setName(name.toString())
            .setDisplayName(displayName)
            .setBillingAccount(billingAccount)
            .setEtag(etag)
            .setProvisionedResourcesParent(provisionedResourcesParent)
            .build();
    mockAssuredWorkloadsService.addResponse(expectedResponse);

    Workload workload = Workload.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Workload actualResponse = client.updateWorkload(workload, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAssuredWorkloadsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateWorkloadRequest actualRequest = (UpdateWorkloadRequest) actualRequests.get(0);

    Assert.assertEquals(workload, actualRequest.getWorkload());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void updateWorkloadExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockAssuredWorkloadsService.addException(exception);

    try {
      Workload workload = Workload.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();

      client.updateWorkload(workload, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deleteWorkloadTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    mockAssuredWorkloadsService.addResponse(expectedResponse);

    WorkloadName name = WorkloadName.of("[ORGANIZATION]", "[LOCATION]", "[WORKLOAD]");

    client.deleteWorkload(name);

    List<AbstractMessage> actualRequests = mockAssuredWorkloadsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteWorkloadRequest actualRequest = (DeleteWorkloadRequest) actualRequests.get(0);

    Assert.assertEquals(name, WorkloadName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void deleteWorkloadExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockAssuredWorkloadsService.addException(exception);

    try {
      WorkloadName name = WorkloadName.of("[ORGANIZATION]", "[LOCATION]", "[WORKLOAD]");

      client.deleteWorkload(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getWorkloadTest() {
    WorkloadName name2 = WorkloadName.of("[ORGANIZATION]", "[LOCATION]", "[WORKLOAD]");
    String displayName = "displayName1615086568";
    String billingAccount = "billingAccount-545871767";
    String etag = "etag3123477";
    String provisionedResourcesParent = "provisionedResourcesParent-158134097";
    Workload expectedResponse =
        Workload.newBuilder()
            .setName(name2.toString())
            .setDisplayName(displayName)
            .setBillingAccount(billingAccount)
            .setEtag(etag)
            .setProvisionedResourcesParent(provisionedResourcesParent)
            .build();
    mockAssuredWorkloadsService.addResponse(expectedResponse);

    WorkloadName name = WorkloadName.of("[ORGANIZATION]", "[LOCATION]", "[WORKLOAD]");

    Workload actualResponse = client.getWorkload(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAssuredWorkloadsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetWorkloadRequest actualRequest = (GetWorkloadRequest) actualRequests.get(0);

    Assert.assertEquals(name, WorkloadName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getWorkloadExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockAssuredWorkloadsService.addException(exception);

    try {
      WorkloadName name = WorkloadName.of("[ORGANIZATION]", "[LOCATION]", "[WORKLOAD]");

      client.getWorkload(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listWorkloadsTest() {
    String nextPageToken = "";
    Workload workloadsElement = Workload.newBuilder().build();
    List<Workload> workloads = Arrays.asList(workloadsElement);
    ListWorkloadsResponse expectedResponse =
        ListWorkloadsResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllWorkloads(workloads)
            .build();
    mockAssuredWorkloadsService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[ORGANIZATION]", "[LOCATION]");

    ListWorkloadsPagedResponse pagedListResponse = client.listWorkloads(parent);

    List<Workload> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getWorkloadsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAssuredWorkloadsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListWorkloadsRequest actualRequest = (ListWorkloadsRequest) actualRequests.get(0);

    Assert.assertEquals(parent, LocationName.parse(actualRequest.getParent()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listWorkloadsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockAssuredWorkloadsService.addException(exception);

    try {
      LocationName parent = LocationName.of("[ORGANIZATION]", "[LOCATION]");

      client.listWorkloads(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }
}
