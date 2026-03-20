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

package com.google.cloud.kms.v1;

import static com.google.cloud.kms.v1.HsmManagementClient.ListLocationsPagedResponse;
import static com.google.cloud.kms.v1.HsmManagementClient.ListSingleTenantHsmInstanceProposalsPagedResponse;
import static com.google.cloud.kms.v1.HsmManagementClient.ListSingleTenantHsmInstancesPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.kms.v1.stub.HttpJsonHsmManagementStub;
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
import com.google.protobuf.Any;
import com.google.protobuf.ByteString;
import com.google.protobuf.Duration;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class HsmManagementClientHttpJsonTest {
  private static MockHttpService mockService;
  private static HsmManagementClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonHsmManagementStub.getMethodDescriptors(),
            HsmManagementSettings.getDefaultEndpoint());
    HsmManagementSettings settings =
        HsmManagementSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                HsmManagementSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = HsmManagementClient.create(settings);
  }

  @AfterClass
  public static void stopServer() {
    client.close();
  }

  @Before
  public void setUp() {}

  @After
  public void tearDown() throws Exception {
    mockService.reset();
  }

  @Test
  public void listSingleTenantHsmInstancesTest() throws Exception {
    SingleTenantHsmInstance responsesElement = SingleTenantHsmInstance.newBuilder().build();
    ListSingleTenantHsmInstancesResponse expectedResponse =
        ListSingleTenantHsmInstancesResponse.newBuilder()
            .setNextPageToken("")
            .addAllSingleTenantHsmInstances(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListSingleTenantHsmInstancesPagedResponse pagedListResponse =
        client.listSingleTenantHsmInstances(parent);

    List<SingleTenantHsmInstance> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getSingleTenantHsmInstancesList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listSingleTenantHsmInstancesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listSingleTenantHsmInstances(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSingleTenantHsmInstancesTest2() throws Exception {
    SingleTenantHsmInstance responsesElement = SingleTenantHsmInstance.newBuilder().build();
    ListSingleTenantHsmInstancesResponse expectedResponse =
        ListSingleTenantHsmInstancesResponse.newBuilder()
            .setNextPageToken("")
            .addAllSingleTenantHsmInstances(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListSingleTenantHsmInstancesPagedResponse pagedListResponse =
        client.listSingleTenantHsmInstances(parent);

    List<SingleTenantHsmInstance> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getSingleTenantHsmInstancesList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listSingleTenantHsmInstancesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listSingleTenantHsmInstances(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSingleTenantHsmInstanceTest() throws Exception {
    SingleTenantHsmInstance expectedResponse =
        SingleTenantHsmInstance.newBuilder()
            .setName(
                SingleTenantHsmInstanceName.of(
                        "[PROJECT]", "[LOCATION]", "[SINGLE_TENANT_HSM_INSTANCE]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setQuorumAuth(SingleTenantHsmInstance.QuorumAuth.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setUnrefreshedDurationUntilDisable(Duration.newBuilder().build())
            .setDisableTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    SingleTenantHsmInstanceName name =
        SingleTenantHsmInstanceName.of("[PROJECT]", "[LOCATION]", "[SINGLE_TENANT_HSM_INSTANCE]");

    SingleTenantHsmInstance actualResponse = client.getSingleTenantHsmInstance(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getSingleTenantHsmInstanceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SingleTenantHsmInstanceName name =
          SingleTenantHsmInstanceName.of("[PROJECT]", "[LOCATION]", "[SINGLE_TENANT_HSM_INSTANCE]");
      client.getSingleTenantHsmInstance(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSingleTenantHsmInstanceTest2() throws Exception {
    SingleTenantHsmInstance expectedResponse =
        SingleTenantHsmInstance.newBuilder()
            .setName(
                SingleTenantHsmInstanceName.of(
                        "[PROJECT]", "[LOCATION]", "[SINGLE_TENANT_HSM_INSTANCE]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setQuorumAuth(SingleTenantHsmInstance.QuorumAuth.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setUnrefreshedDurationUntilDisable(Duration.newBuilder().build())
            .setDisableTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-1470/locations/location-1470/singleTenantHsmInstances/singleTenantHsmInstance-1470";

    SingleTenantHsmInstance actualResponse = client.getSingleTenantHsmInstance(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getSingleTenantHsmInstanceExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-1470/locations/location-1470/singleTenantHsmInstances/singleTenantHsmInstance-1470";
      client.getSingleTenantHsmInstance(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createSingleTenantHsmInstanceTest() throws Exception {
    SingleTenantHsmInstance expectedResponse =
        SingleTenantHsmInstance.newBuilder()
            .setName(
                SingleTenantHsmInstanceName.of(
                        "[PROJECT]", "[LOCATION]", "[SINGLE_TENANT_HSM_INSTANCE]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setQuorumAuth(SingleTenantHsmInstance.QuorumAuth.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setUnrefreshedDurationUntilDisable(Duration.newBuilder().build())
            .setDisableTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createSingleTenantHsmInstanceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    SingleTenantHsmInstance singleTenantHsmInstance = SingleTenantHsmInstance.newBuilder().build();
    String singleTenantHsmInstanceId = "singleTenantHsmInstanceId770829568";

    SingleTenantHsmInstance actualResponse =
        client
            .createSingleTenantHsmInstanceAsync(
                parent, singleTenantHsmInstance, singleTenantHsmInstanceId)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createSingleTenantHsmInstanceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      SingleTenantHsmInstance singleTenantHsmInstance =
          SingleTenantHsmInstance.newBuilder().build();
      String singleTenantHsmInstanceId = "singleTenantHsmInstanceId770829568";
      client
          .createSingleTenantHsmInstanceAsync(
              parent, singleTenantHsmInstance, singleTenantHsmInstanceId)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createSingleTenantHsmInstanceTest2() throws Exception {
    SingleTenantHsmInstance expectedResponse =
        SingleTenantHsmInstance.newBuilder()
            .setName(
                SingleTenantHsmInstanceName.of(
                        "[PROJECT]", "[LOCATION]", "[SINGLE_TENANT_HSM_INSTANCE]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setQuorumAuth(SingleTenantHsmInstance.QuorumAuth.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setUnrefreshedDurationUntilDisable(Duration.newBuilder().build())
            .setDisableTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createSingleTenantHsmInstanceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5833/locations/location-5833";
    SingleTenantHsmInstance singleTenantHsmInstance = SingleTenantHsmInstance.newBuilder().build();
    String singleTenantHsmInstanceId = "singleTenantHsmInstanceId770829568";

    SingleTenantHsmInstance actualResponse =
        client
            .createSingleTenantHsmInstanceAsync(
                parent, singleTenantHsmInstance, singleTenantHsmInstanceId)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createSingleTenantHsmInstanceExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      SingleTenantHsmInstance singleTenantHsmInstance =
          SingleTenantHsmInstance.newBuilder().build();
      String singleTenantHsmInstanceId = "singleTenantHsmInstanceId770829568";
      client
          .createSingleTenantHsmInstanceAsync(
              parent, singleTenantHsmInstance, singleTenantHsmInstanceId)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createSingleTenantHsmInstanceProposalTest() throws Exception {
    SingleTenantHsmInstanceProposal expectedResponse =
        SingleTenantHsmInstanceProposal.newBuilder()
            .setName(
                SingleTenantHsmInstanceProposalName.of(
                        "[PROJECT]", "[LOCATION]", "[SINGLE_TENANT_HSM_INSTANCE]", "[PROPOSAL]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setFailureReason("failureReason-1990598546")
            .setDeleteTime(Timestamp.newBuilder().build())
            .setPurgeTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createSingleTenantHsmInstanceProposalTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    SingleTenantHsmInstanceName parent =
        SingleTenantHsmInstanceName.of("[PROJECT]", "[LOCATION]", "[SINGLE_TENANT_HSM_INSTANCE]");
    SingleTenantHsmInstanceProposal singleTenantHsmInstanceProposal =
        SingleTenantHsmInstanceProposal.newBuilder().build();
    String singleTenantHsmInstanceProposalId = "singleTenantHsmInstanceProposalId-994202990";

    SingleTenantHsmInstanceProposal actualResponse =
        client
            .createSingleTenantHsmInstanceProposalAsync(
                parent, singleTenantHsmInstanceProposal, singleTenantHsmInstanceProposalId)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createSingleTenantHsmInstanceProposalExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SingleTenantHsmInstanceName parent =
          SingleTenantHsmInstanceName.of("[PROJECT]", "[LOCATION]", "[SINGLE_TENANT_HSM_INSTANCE]");
      SingleTenantHsmInstanceProposal singleTenantHsmInstanceProposal =
          SingleTenantHsmInstanceProposal.newBuilder().build();
      String singleTenantHsmInstanceProposalId = "singleTenantHsmInstanceProposalId-994202990";
      client
          .createSingleTenantHsmInstanceProposalAsync(
              parent, singleTenantHsmInstanceProposal, singleTenantHsmInstanceProposalId)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createSingleTenantHsmInstanceProposalTest2() throws Exception {
    SingleTenantHsmInstanceProposal expectedResponse =
        SingleTenantHsmInstanceProposal.newBuilder()
            .setName(
                SingleTenantHsmInstanceProposalName.of(
                        "[PROJECT]", "[LOCATION]", "[SINGLE_TENANT_HSM_INSTANCE]", "[PROPOSAL]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setFailureReason("failureReason-1990598546")
            .setDeleteTime(Timestamp.newBuilder().build())
            .setPurgeTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createSingleTenantHsmInstanceProposalTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent =
        "projects/project-5297/locations/location-5297/singleTenantHsmInstances/singleTenantHsmInstance-5297";
    SingleTenantHsmInstanceProposal singleTenantHsmInstanceProposal =
        SingleTenantHsmInstanceProposal.newBuilder().build();
    String singleTenantHsmInstanceProposalId = "singleTenantHsmInstanceProposalId-994202990";

    SingleTenantHsmInstanceProposal actualResponse =
        client
            .createSingleTenantHsmInstanceProposalAsync(
                parent, singleTenantHsmInstanceProposal, singleTenantHsmInstanceProposalId)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createSingleTenantHsmInstanceProposalExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-5297/locations/location-5297/singleTenantHsmInstances/singleTenantHsmInstance-5297";
      SingleTenantHsmInstanceProposal singleTenantHsmInstanceProposal =
          SingleTenantHsmInstanceProposal.newBuilder().build();
      String singleTenantHsmInstanceProposalId = "singleTenantHsmInstanceProposalId-994202990";
      client
          .createSingleTenantHsmInstanceProposalAsync(
              parent, singleTenantHsmInstanceProposal, singleTenantHsmInstanceProposalId)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void approveSingleTenantHsmInstanceProposalTest() throws Exception {
    ApproveSingleTenantHsmInstanceProposalResponse expectedResponse =
        ApproveSingleTenantHsmInstanceProposalResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    SingleTenantHsmInstanceProposalName name =
        SingleTenantHsmInstanceProposalName.of(
            "[PROJECT]", "[LOCATION]", "[SINGLE_TENANT_HSM_INSTANCE]", "[PROPOSAL]");
    ApproveSingleTenantHsmInstanceProposalRequest.QuorumReply quorumReply =
        ApproveSingleTenantHsmInstanceProposalRequest.QuorumReply.newBuilder().build();

    ApproveSingleTenantHsmInstanceProposalResponse actualResponse =
        client.approveSingleTenantHsmInstanceProposal(name, quorumReply);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void approveSingleTenantHsmInstanceProposalExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SingleTenantHsmInstanceProposalName name =
          SingleTenantHsmInstanceProposalName.of(
              "[PROJECT]", "[LOCATION]", "[SINGLE_TENANT_HSM_INSTANCE]", "[PROPOSAL]");
      ApproveSingleTenantHsmInstanceProposalRequest.QuorumReply quorumReply =
          ApproveSingleTenantHsmInstanceProposalRequest.QuorumReply.newBuilder().build();
      client.approveSingleTenantHsmInstanceProposal(name, quorumReply);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void approveSingleTenantHsmInstanceProposalTest2() throws Exception {
    ApproveSingleTenantHsmInstanceProposalResponse expectedResponse =
        ApproveSingleTenantHsmInstanceProposalResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-6043/locations/location-6043/singleTenantHsmInstances/singleTenantHsmInstance-6043/proposals/proposal-6043";
    ApproveSingleTenantHsmInstanceProposalRequest.QuorumReply quorumReply =
        ApproveSingleTenantHsmInstanceProposalRequest.QuorumReply.newBuilder().build();

    ApproveSingleTenantHsmInstanceProposalResponse actualResponse =
        client.approveSingleTenantHsmInstanceProposal(name, quorumReply);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void approveSingleTenantHsmInstanceProposalExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-6043/locations/location-6043/singleTenantHsmInstances/singleTenantHsmInstance-6043/proposals/proposal-6043";
      ApproveSingleTenantHsmInstanceProposalRequest.QuorumReply quorumReply =
          ApproveSingleTenantHsmInstanceProposalRequest.QuorumReply.newBuilder().build();
      client.approveSingleTenantHsmInstanceProposal(name, quorumReply);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void executeSingleTenantHsmInstanceProposalTest() throws Exception {
    ExecuteSingleTenantHsmInstanceProposalResponse expectedResponse =
        ExecuteSingleTenantHsmInstanceProposalResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("executeSingleTenantHsmInstanceProposalTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    SingleTenantHsmInstanceProposalName name =
        SingleTenantHsmInstanceProposalName.of(
            "[PROJECT]", "[LOCATION]", "[SINGLE_TENANT_HSM_INSTANCE]", "[PROPOSAL]");

    ExecuteSingleTenantHsmInstanceProposalResponse actualResponse =
        client.executeSingleTenantHsmInstanceProposalAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void executeSingleTenantHsmInstanceProposalExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SingleTenantHsmInstanceProposalName name =
          SingleTenantHsmInstanceProposalName.of(
              "[PROJECT]", "[LOCATION]", "[SINGLE_TENANT_HSM_INSTANCE]", "[PROPOSAL]");
      client.executeSingleTenantHsmInstanceProposalAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void executeSingleTenantHsmInstanceProposalTest2() throws Exception {
    ExecuteSingleTenantHsmInstanceProposalResponse expectedResponse =
        ExecuteSingleTenantHsmInstanceProposalResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("executeSingleTenantHsmInstanceProposalTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name =
        "projects/project-6043/locations/location-6043/singleTenantHsmInstances/singleTenantHsmInstance-6043/proposals/proposal-6043";

    ExecuteSingleTenantHsmInstanceProposalResponse actualResponse =
        client.executeSingleTenantHsmInstanceProposalAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void executeSingleTenantHsmInstanceProposalExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-6043/locations/location-6043/singleTenantHsmInstances/singleTenantHsmInstance-6043/proposals/proposal-6043";
      client.executeSingleTenantHsmInstanceProposalAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void getSingleTenantHsmInstanceProposalTest() throws Exception {
    SingleTenantHsmInstanceProposal expectedResponse =
        SingleTenantHsmInstanceProposal.newBuilder()
            .setName(
                SingleTenantHsmInstanceProposalName.of(
                        "[PROJECT]", "[LOCATION]", "[SINGLE_TENANT_HSM_INSTANCE]", "[PROPOSAL]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setFailureReason("failureReason-1990598546")
            .setDeleteTime(Timestamp.newBuilder().build())
            .setPurgeTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    SingleTenantHsmInstanceProposalName name =
        SingleTenantHsmInstanceProposalName.of(
            "[PROJECT]", "[LOCATION]", "[SINGLE_TENANT_HSM_INSTANCE]", "[PROPOSAL]");

    SingleTenantHsmInstanceProposal actualResponse =
        client.getSingleTenantHsmInstanceProposal(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getSingleTenantHsmInstanceProposalExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SingleTenantHsmInstanceProposalName name =
          SingleTenantHsmInstanceProposalName.of(
              "[PROJECT]", "[LOCATION]", "[SINGLE_TENANT_HSM_INSTANCE]", "[PROPOSAL]");
      client.getSingleTenantHsmInstanceProposal(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSingleTenantHsmInstanceProposalTest2() throws Exception {
    SingleTenantHsmInstanceProposal expectedResponse =
        SingleTenantHsmInstanceProposal.newBuilder()
            .setName(
                SingleTenantHsmInstanceProposalName.of(
                        "[PROJECT]", "[LOCATION]", "[SINGLE_TENANT_HSM_INSTANCE]", "[PROPOSAL]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setFailureReason("failureReason-1990598546")
            .setDeleteTime(Timestamp.newBuilder().build())
            .setPurgeTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-6043/locations/location-6043/singleTenantHsmInstances/singleTenantHsmInstance-6043/proposals/proposal-6043";

    SingleTenantHsmInstanceProposal actualResponse =
        client.getSingleTenantHsmInstanceProposal(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getSingleTenantHsmInstanceProposalExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-6043/locations/location-6043/singleTenantHsmInstances/singleTenantHsmInstance-6043/proposals/proposal-6043";
      client.getSingleTenantHsmInstanceProposal(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSingleTenantHsmInstanceProposalsTest() throws Exception {
    SingleTenantHsmInstanceProposal responsesElement =
        SingleTenantHsmInstanceProposal.newBuilder().build();
    ListSingleTenantHsmInstanceProposalsResponse expectedResponse =
        ListSingleTenantHsmInstanceProposalsResponse.newBuilder()
            .setNextPageToken("")
            .addAllSingleTenantHsmInstanceProposals(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    SingleTenantHsmInstanceName parent =
        SingleTenantHsmInstanceName.of("[PROJECT]", "[LOCATION]", "[SINGLE_TENANT_HSM_INSTANCE]");

    ListSingleTenantHsmInstanceProposalsPagedResponse pagedListResponse =
        client.listSingleTenantHsmInstanceProposals(parent);

    List<SingleTenantHsmInstanceProposal> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getSingleTenantHsmInstanceProposalsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listSingleTenantHsmInstanceProposalsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SingleTenantHsmInstanceName parent =
          SingleTenantHsmInstanceName.of("[PROJECT]", "[LOCATION]", "[SINGLE_TENANT_HSM_INSTANCE]");
      client.listSingleTenantHsmInstanceProposals(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSingleTenantHsmInstanceProposalsTest2() throws Exception {
    SingleTenantHsmInstanceProposal responsesElement =
        SingleTenantHsmInstanceProposal.newBuilder().build();
    ListSingleTenantHsmInstanceProposalsResponse expectedResponse =
        ListSingleTenantHsmInstanceProposalsResponse.newBuilder()
            .setNextPageToken("")
            .addAllSingleTenantHsmInstanceProposals(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent =
        "projects/project-5297/locations/location-5297/singleTenantHsmInstances/singleTenantHsmInstance-5297";

    ListSingleTenantHsmInstanceProposalsPagedResponse pagedListResponse =
        client.listSingleTenantHsmInstanceProposals(parent);

    List<SingleTenantHsmInstanceProposal> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getSingleTenantHsmInstanceProposalsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listSingleTenantHsmInstanceProposalsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-5297/locations/location-5297/singleTenantHsmInstances/singleTenantHsmInstance-5297";
      client.listSingleTenantHsmInstanceProposals(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteSingleTenantHsmInstanceProposalTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    SingleTenantHsmInstanceProposalName name =
        SingleTenantHsmInstanceProposalName.of(
            "[PROJECT]", "[LOCATION]", "[SINGLE_TENANT_HSM_INSTANCE]", "[PROPOSAL]");

    client.deleteSingleTenantHsmInstanceProposal(name);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteSingleTenantHsmInstanceProposalExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SingleTenantHsmInstanceProposalName name =
          SingleTenantHsmInstanceProposalName.of(
              "[PROJECT]", "[LOCATION]", "[SINGLE_TENANT_HSM_INSTANCE]", "[PROPOSAL]");
      client.deleteSingleTenantHsmInstanceProposal(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteSingleTenantHsmInstanceProposalTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-6043/locations/location-6043/singleTenantHsmInstances/singleTenantHsmInstance-6043/proposals/proposal-6043";

    client.deleteSingleTenantHsmInstanceProposal(name);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteSingleTenantHsmInstanceProposalExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-6043/locations/location-6043/singleTenantHsmInstances/singleTenantHsmInstance-6043/proposals/proposal-6043";
      client.deleteSingleTenantHsmInstanceProposal(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
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
    mockService.addResponse(expectedResponse);

    ListLocationsRequest request =
        ListLocationsRequest.newBuilder()
            .setName("projects/project-3664")
            .setFilter("filter-1274492040")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    ListLocationsPagedResponse pagedListResponse = client.listLocations(request);

    List<Location> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLocationsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listLocationsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ListLocationsRequest request =
          ListLocationsRequest.newBuilder()
              .setName("projects/project-3664")
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
    mockService.addResponse(expectedResponse);

    GetLocationRequest request =
        GetLocationRequest.newBuilder()
            .setName("projects/project-9062/locations/location-9062")
            .build();

    Location actualResponse = client.getLocation(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getLocationExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GetLocationRequest request =
          GetLocationRequest.newBuilder()
              .setName("projects/project-9062/locations/location-9062")
              .build();
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
    mockService.addResponse(expectedResponse);

    SetIamPolicyRequest request =
        SetIamPolicyRequest.newBuilder()
            .setResource(
                CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]")
                    .toString())
            .setPolicy(Policy.newBuilder().build())
            .setUpdateMask(FieldMask.newBuilder().build())
            .build();

    Policy actualResponse = client.setIamPolicy(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void setIamPolicyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SetIamPolicyRequest request =
          SetIamPolicyRequest.newBuilder()
              .setResource(
                  CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]")
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
    mockService.addResponse(expectedResponse);

    GetIamPolicyRequest request =
        GetIamPolicyRequest.newBuilder()
            .setResource(
                CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]")
                    .toString())
            .setOptions(GetPolicyOptions.newBuilder().build())
            .build();

    Policy actualResponse = client.getIamPolicy(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getIamPolicyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GetIamPolicyRequest request =
          GetIamPolicyRequest.newBuilder()
              .setResource(
                  CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]")
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
    mockService.addResponse(expectedResponse);

    TestIamPermissionsRequest request =
        TestIamPermissionsRequest.newBuilder()
            .setResource(
                CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]")
                    .toString())
            .addAllPermissions(new ArrayList<String>())
            .build();

    TestIamPermissionsResponse actualResponse = client.testIamPermissions(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void testIamPermissionsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      TestIamPermissionsRequest request =
          TestIamPermissionsRequest.newBuilder()
              .setResource(
                  CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]")
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
