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

import static com.google.cloud.assuredworkloads.v1.AssuredWorkloadsServiceClient.ListWorkloadsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.assuredworkloads.v1.stub.HttpJsonAssuredWorkloadsServiceStub;
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
public class AssuredWorkloadsServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static AssuredWorkloadsServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonAssuredWorkloadsServiceStub.getMethodDescriptors(),
            AssuredWorkloadsServiceSettings.getDefaultEndpoint());
    AssuredWorkloadsServiceSettings settings =
        AssuredWorkloadsServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                AssuredWorkloadsServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = AssuredWorkloadsServiceClient.create(settings);
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
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createWorkloadTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[ORGANIZATION]", "[LOCATION]");
    Workload workload = Workload.newBuilder().build();

    Workload actualResponse = client.createWorkloadAsync(parent, workload).get();
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
  public void createWorkloadExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[ORGANIZATION]", "[LOCATION]");
      Workload workload = Workload.newBuilder().build();
      client.createWorkloadAsync(parent, workload).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createWorkloadTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "organizations/organization-9365/locations/location-9365";
    Workload workload = Workload.newBuilder().build();

    Workload actualResponse = client.createWorkloadAsync(parent, workload).get();
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
  public void createWorkloadExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "organizations/organization-9365/locations/location-9365";
      Workload workload = Workload.newBuilder().build();
      client.createWorkloadAsync(parent, workload).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
            .build();
    mockService.addResponse(expectedResponse);

    Workload workload =
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
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Workload actualResponse = client.updateWorkload(workload, updateMask);
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
  public void updateWorkloadExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Workload workload =
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
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateWorkload(workload, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteWorkloadTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    WorkloadName name = WorkloadName.of("[ORGANIZATION]", "[LOCATION]", "[WORKLOAD]");

    client.deleteWorkload(name);

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
  public void deleteWorkloadExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name = "organizations/organization-4962/locations/location-4962/workloads/workload-4962";

    client.deleteWorkload(name);

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
  public void deleteWorkloadExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "organizations/organization-4962/locations/location-4962/workloads/workload-4962";
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
            .build();
    mockService.addResponse(expectedResponse);

    WorkloadName name = WorkloadName.of("[ORGANIZATION]", "[LOCATION]", "[WORKLOAD]");

    Workload actualResponse = client.getWorkload(name);
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
  public void getWorkloadExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
            .build();
    mockService.addResponse(expectedResponse);

    String name = "organizations/organization-4962/locations/location-4962/workloads/workload-4962";

    Workload actualResponse = client.getWorkload(name);
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
  public void getWorkloadExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "organizations/organization-4962/locations/location-4962/workloads/workload-4962";
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
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[ORGANIZATION]", "[LOCATION]");

    ListWorkloadsPagedResponse pagedListResponse = client.listWorkloads(parent);

    List<Workload> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getWorkloadsList().get(0), resources.get(0));

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
  public void listWorkloadsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "organizations/organization-9365/locations/location-9365";

    ListWorkloadsPagedResponse pagedListResponse = client.listWorkloads(parent);

    List<Workload> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getWorkloadsList().get(0), resources.get(0));

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
  public void listWorkloadsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "organizations/organization-9365/locations/location-9365";
      client.listWorkloads(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
