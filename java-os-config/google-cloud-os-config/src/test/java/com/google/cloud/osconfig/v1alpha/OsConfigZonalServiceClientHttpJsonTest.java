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

package com.google.cloud.osconfig.v1alpha;

import static com.google.cloud.osconfig.v1alpha.OsConfigZonalServiceClient.ListInstanceOSPoliciesCompliancesPagedResponse;
import static com.google.cloud.osconfig.v1alpha.OsConfigZonalServiceClient.ListInventoriesPagedResponse;
import static com.google.cloud.osconfig.v1alpha.OsConfigZonalServiceClient.ListOSPolicyAssignmentReportsPagedResponse;
import static com.google.cloud.osconfig.v1alpha.OsConfigZonalServiceClient.ListOSPolicyAssignmentRevisionsPagedResponse;
import static com.google.cloud.osconfig.v1alpha.OsConfigZonalServiceClient.ListOSPolicyAssignmentsPagedResponse;
import static com.google.cloud.osconfig.v1alpha.OsConfigZonalServiceClient.ListVulnerabilityReportsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.osconfig.v1alpha.stub.HttpJsonOsConfigZonalServiceStub;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Any;
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
public class OsConfigZonalServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static OsConfigZonalServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonOsConfigZonalServiceStub.getMethodDescriptors(),
            OsConfigZonalServiceSettings.getDefaultEndpoint());
    OsConfigZonalServiceSettings settings =
        OsConfigZonalServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                OsConfigZonalServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = OsConfigZonalServiceClient.create(settings);
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
    mockService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    OSPolicyAssignment osPolicyAssignment = OSPolicyAssignment.newBuilder().build();
    String osPolicyAssignmentId = "osPolicyAssignmentId-44079074";

    OSPolicyAssignment actualResponse =
        client
            .createOSPolicyAssignmentAsync(parent, osPolicyAssignment, osPolicyAssignmentId)
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
  public void createOSPolicyAssignmentExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      OSPolicyAssignment osPolicyAssignment = OSPolicyAssignment.newBuilder().build();
      String osPolicyAssignmentId = "osPolicyAssignmentId-44079074";
      client.createOSPolicyAssignmentAsync(parent, osPolicyAssignment, osPolicyAssignmentId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5833/locations/location-5833";
    OSPolicyAssignment osPolicyAssignment = OSPolicyAssignment.newBuilder().build();
    String osPolicyAssignmentId = "osPolicyAssignmentId-44079074";

    OSPolicyAssignment actualResponse =
        client
            .createOSPolicyAssignmentAsync(parent, osPolicyAssignment, osPolicyAssignmentId)
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
  public void createOSPolicyAssignmentExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      OSPolicyAssignment osPolicyAssignment = OSPolicyAssignment.newBuilder().build();
      String osPolicyAssignmentId = "osPolicyAssignmentId-44079074";
      client.createOSPolicyAssignmentAsync(parent, osPolicyAssignment, osPolicyAssignmentId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    OSPolicyAssignment osPolicyAssignment =
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
    FieldMask updateMask = FieldMask.newBuilder().build();

    OSPolicyAssignment actualResponse =
        client.updateOSPolicyAssignmentAsync(osPolicyAssignment, updateMask).get();
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
  public void updateOSPolicyAssignmentExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      OSPolicyAssignment osPolicyAssignment =
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
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateOSPolicyAssignmentAsync(osPolicyAssignment, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(expectedResponse);

    OSPolicyAssignmentName name =
        OSPolicyAssignmentName.of("[PROJECT]", "[LOCATION]", "[OS_POLICY_ASSIGNMENT]");

    OSPolicyAssignment actualResponse = client.getOSPolicyAssignment(name);
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
  public void getOSPolicyAssignmentExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-1862/locations/location-1862/osPolicyAssignments/osPolicyAssignment-1862";

    OSPolicyAssignment actualResponse = client.getOSPolicyAssignment(name);
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
  public void getOSPolicyAssignmentExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-1862/locations/location-1862/osPolicyAssignments/osPolicyAssignment-1862";
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
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListOSPolicyAssignmentsPagedResponse pagedListResponse = client.listOSPolicyAssignments(parent);

    List<OSPolicyAssignment> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getOsPolicyAssignmentsList().get(0), resources.get(0));

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
  public void listOSPolicyAssignmentsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListOSPolicyAssignmentsPagedResponse pagedListResponse = client.listOSPolicyAssignments(parent);

    List<OSPolicyAssignment> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getOsPolicyAssignmentsList().get(0), resources.get(0));

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
  public void listOSPolicyAssignmentsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
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
    mockService.addResponse(expectedResponse);

    OSPolicyAssignmentName name =
        OSPolicyAssignmentName.of("[PROJECT]", "[LOCATION]", "[OS_POLICY_ASSIGNMENT]");

    ListOSPolicyAssignmentRevisionsPagedResponse pagedListResponse =
        client.listOSPolicyAssignmentRevisions(name);

    List<OSPolicyAssignment> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getOsPolicyAssignmentsList().get(0), resources.get(0));

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
  public void listOSPolicyAssignmentRevisionsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-1862/locations/location-1862/osPolicyAssignments/osPolicyAssignment-1862";

    ListOSPolicyAssignmentRevisionsPagedResponse pagedListResponse =
        client.listOSPolicyAssignmentRevisions(name);

    List<OSPolicyAssignment> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getOsPolicyAssignmentsList().get(0), resources.get(0));

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
  public void listOSPolicyAssignmentRevisionsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-1862/locations/location-1862/osPolicyAssignments/osPolicyAssignment-1862";
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
    mockService.addResponse(resultOperation);

    OSPolicyAssignmentName name =
        OSPolicyAssignmentName.of("[PROJECT]", "[LOCATION]", "[OS_POLICY_ASSIGNMENT]");

    client.deleteOSPolicyAssignmentAsync(name).get();

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
  public void deleteOSPolicyAssignmentExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      OSPolicyAssignmentName name =
          OSPolicyAssignmentName.of("[PROJECT]", "[LOCATION]", "[OS_POLICY_ASSIGNMENT]");
      client.deleteOSPolicyAssignmentAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    String name =
        "projects/project-1862/locations/location-1862/osPolicyAssignments/osPolicyAssignment-1862";

    client.deleteOSPolicyAssignmentAsync(name).get();

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
  public void deleteOSPolicyAssignmentExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-1862/locations/location-1862/osPolicyAssignments/osPolicyAssignment-1862";
      client.deleteOSPolicyAssignmentAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void getInstanceOSPoliciesComplianceTest() throws Exception {
    InstanceOSPoliciesCompliance expectedResponse =
        InstanceOSPoliciesCompliance.newBuilder()
            .setName(
                InstanceOSPoliciesComplianceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]")
                    .toString())
            .setInstance("instance555127957")
            .setState(OSPolicyComplianceState.forNumber(0))
            .setDetailedState("detailedState1829498305")
            .setDetailedStateReason("detailedStateReason-790407323")
            .addAllOsPolicyCompliances(
                new ArrayList<InstanceOSPoliciesCompliance.OSPolicyCompliance>())
            .setLastComplianceCheckTime(Timestamp.newBuilder().build())
            .setLastComplianceRunId("lastComplianceRunId168782901")
            .build();
    mockService.addResponse(expectedResponse);

    InstanceOSPoliciesComplianceName name =
        InstanceOSPoliciesComplianceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");

    InstanceOSPoliciesCompliance actualResponse = client.getInstanceOSPoliciesCompliance(name);
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
  public void getInstanceOSPoliciesComplianceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      InstanceOSPoliciesComplianceName name =
          InstanceOSPoliciesComplianceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      client.getInstanceOSPoliciesCompliance(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getInstanceOSPoliciesComplianceTest2() throws Exception {
    InstanceOSPoliciesCompliance expectedResponse =
        InstanceOSPoliciesCompliance.newBuilder()
            .setName(
                InstanceOSPoliciesComplianceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]")
                    .toString())
            .setInstance("instance555127957")
            .setState(OSPolicyComplianceState.forNumber(0))
            .setDetailedState("detailedState1829498305")
            .setDetailedStateReason("detailedStateReason-790407323")
            .addAllOsPolicyCompliances(
                new ArrayList<InstanceOSPoliciesCompliance.OSPolicyCompliance>())
            .setLastComplianceCheckTime(Timestamp.newBuilder().build())
            .setLastComplianceRunId("lastComplianceRunId168782901")
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-1829/locations/location-1829/instanceOSPoliciesCompliances/instanceOSPoliciesCompliance-1829";

    InstanceOSPoliciesCompliance actualResponse = client.getInstanceOSPoliciesCompliance(name);
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
  public void getInstanceOSPoliciesComplianceExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-1829/locations/location-1829/instanceOSPoliciesCompliances/instanceOSPoliciesCompliance-1829";
      client.getInstanceOSPoliciesCompliance(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listInstanceOSPoliciesCompliancesTest() throws Exception {
    InstanceOSPoliciesCompliance responsesElement =
        InstanceOSPoliciesCompliance.newBuilder().build();
    ListInstanceOSPoliciesCompliancesResponse expectedResponse =
        ListInstanceOSPoliciesCompliancesResponse.newBuilder()
            .setNextPageToken("")
            .addAllInstanceOsPoliciesCompliances(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListInstanceOSPoliciesCompliancesPagedResponse pagedListResponse =
        client.listInstanceOSPoliciesCompliances(parent);

    List<InstanceOSPoliciesCompliance> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getInstanceOsPoliciesCompliancesList().get(0), resources.get(0));

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
  public void listInstanceOSPoliciesCompliancesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listInstanceOSPoliciesCompliances(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listInstanceOSPoliciesCompliancesTest2() throws Exception {
    InstanceOSPoliciesCompliance responsesElement =
        InstanceOSPoliciesCompliance.newBuilder().build();
    ListInstanceOSPoliciesCompliancesResponse expectedResponse =
        ListInstanceOSPoliciesCompliancesResponse.newBuilder()
            .setNextPageToken("")
            .addAllInstanceOsPoliciesCompliances(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListInstanceOSPoliciesCompliancesPagedResponse pagedListResponse =
        client.listInstanceOSPoliciesCompliances(parent);

    List<InstanceOSPoliciesCompliance> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getInstanceOsPoliciesCompliancesList().get(0), resources.get(0));

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
  public void listInstanceOSPoliciesCompliancesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listInstanceOSPoliciesCompliances(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
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
    mockService.addResponse(expectedResponse);

    OSPolicyAssignmentReportName name =
        OSPolicyAssignmentReportName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[ASSIGNMENT]");

    OSPolicyAssignmentReport actualResponse = client.getOSPolicyAssignmentReport(name);
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
  public void getOSPolicyAssignmentReportExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-6771/locations/location-6771/instances/instance-6771/osPolicyAssignments/osPolicyAssignment-6771/report";

    OSPolicyAssignmentReport actualResponse = client.getOSPolicyAssignmentReport(name);
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
  public void getOSPolicyAssignmentReportExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-6771/locations/location-6771/instances/instance-6771/osPolicyAssignments/osPolicyAssignment-6771/report";
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
    mockService.addResponse(expectedResponse);

    InstanceOSPolicyAssignmentName parent =
        InstanceOSPolicyAssignmentName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[ASSIGNMENT]");

    ListOSPolicyAssignmentReportsPagedResponse pagedListResponse =
        client.listOSPolicyAssignmentReports(parent);

    List<OSPolicyAssignmentReport> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getOsPolicyAssignmentReportsList().get(0), resources.get(0));

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
  public void listOSPolicyAssignmentReportsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent =
        "projects/project-6863/locations/location-6863/instances/instance-6863/osPolicyAssignments/osPolicyAssignment-6863";

    ListOSPolicyAssignmentReportsPagedResponse pagedListResponse =
        client.listOSPolicyAssignmentReports(parent);

    List<OSPolicyAssignmentReport> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getOsPolicyAssignmentReportsList().get(0), resources.get(0));

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
  public void listOSPolicyAssignmentReportsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-6863/locations/location-6863/instances/instance-6863/osPolicyAssignments/osPolicyAssignment-6863";
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
    mockService.addResponse(expectedResponse);

    InventoryName name = InventoryName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");

    Inventory actualResponse = client.getInventory(name);
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
  public void getInventoryExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name = "projects/project-943/locations/location-943/instances/instance-943/inventory";

    Inventory actualResponse = client.getInventory(name);
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
  public void getInventoryExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-943/locations/location-943/instances/instance-943/inventory";
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
    mockService.addResponse(expectedResponse);

    InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");

    ListInventoriesPagedResponse pagedListResponse = client.listInventories(parent);

    List<Inventory> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getInventoriesList().get(0), resources.get(0));

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
  public void listInventoriesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5197/locations/location-5197/instances/instance-5197";

    ListInventoriesPagedResponse pagedListResponse = client.listInventories(parent);

    List<Inventory> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getInventoriesList().get(0), resources.get(0));

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
  public void listInventoriesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5197/locations/location-5197/instances/instance-5197";
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
    mockService.addResponse(expectedResponse);

    VulnerabilityReportName name =
        VulnerabilityReportName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");

    VulnerabilityReport actualResponse = client.getVulnerabilityReport(name);
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
  public void getVulnerabilityReportExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-2379/locations/location-2379/instances/instance-2379/vulnerabilityReport";

    VulnerabilityReport actualResponse = client.getVulnerabilityReport(name);
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
  public void getVulnerabilityReportExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-2379/locations/location-2379/instances/instance-2379/vulnerabilityReport";
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
    mockService.addResponse(expectedResponse);

    InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");

    ListVulnerabilityReportsPagedResponse pagedListResponse =
        client.listVulnerabilityReports(parent);

    List<VulnerabilityReport> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getVulnerabilityReportsList().get(0), resources.get(0));

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
  public void listVulnerabilityReportsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5197/locations/location-5197/instances/instance-5197";

    ListVulnerabilityReportsPagedResponse pagedListResponse =
        client.listVulnerabilityReports(parent);

    List<VulnerabilityReport> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getVulnerabilityReportsList().get(0), resources.get(0));

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
  public void listVulnerabilityReportsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5197/locations/location-5197/instances/instance-5197";
      client.listVulnerabilityReports(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
