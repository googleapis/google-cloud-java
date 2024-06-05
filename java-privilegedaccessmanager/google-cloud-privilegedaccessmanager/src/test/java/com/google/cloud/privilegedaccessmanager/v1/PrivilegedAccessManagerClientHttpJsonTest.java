/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.privilegedaccessmanager.v1;

import static com.google.cloud.privilegedaccessmanager.v1.PrivilegedAccessManagerClient.ListEntitlementsPagedResponse;
import static com.google.cloud.privilegedaccessmanager.v1.PrivilegedAccessManagerClient.ListGrantsPagedResponse;
import static com.google.cloud.privilegedaccessmanager.v1.PrivilegedAccessManagerClient.ListLocationsPagedResponse;
import static com.google.cloud.privilegedaccessmanager.v1.PrivilegedAccessManagerClient.SearchEntitlementsPagedResponse;
import static com.google.cloud.privilegedaccessmanager.v1.PrivilegedAccessManagerClient.SearchGrantsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.privilegedaccessmanager.v1.stub.HttpJsonPrivilegedAccessManagerStub;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Any;
import com.google.protobuf.Duration;
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
public class PrivilegedAccessManagerClientHttpJsonTest {
  private static MockHttpService mockService;
  private static PrivilegedAccessManagerClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonPrivilegedAccessManagerStub.getMethodDescriptors(),
            PrivilegedAccessManagerSettings.getDefaultEndpoint());
    PrivilegedAccessManagerSettings settings =
        PrivilegedAccessManagerSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                PrivilegedAccessManagerSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = PrivilegedAccessManagerClient.create(settings);
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
  public void checkOnboardingStatusTest() throws Exception {
    CheckOnboardingStatusResponse expectedResponse =
        CheckOnboardingStatusResponse.newBuilder()
            .setServiceAccount("serviceAccount1079137720")
            .addAllFindings(new ArrayList<CheckOnboardingStatusResponse.Finding>())
            .build();
    mockService.addResponse(expectedResponse);

    CheckOnboardingStatusRequest request =
        CheckOnboardingStatusRequest.newBuilder()
            .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
            .build();

    CheckOnboardingStatusResponse actualResponse = client.checkOnboardingStatus(request);
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
  public void checkOnboardingStatusExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CheckOnboardingStatusRequest request =
          CheckOnboardingStatusRequest.newBuilder()
              .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
              .build();
      client.checkOnboardingStatus(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listEntitlementsTest() throws Exception {
    Entitlement responsesElement = Entitlement.newBuilder().build();
    ListEntitlementsResponse expectedResponse =
        ListEntitlementsResponse.newBuilder()
            .setNextPageToken("")
            .addAllEntitlements(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    FolderLocationName parent = FolderLocationName.of("[FOLDER]", "[LOCATION]");

    ListEntitlementsPagedResponse pagedListResponse = client.listEntitlements(parent);

    List<Entitlement> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEntitlementsList().get(0), resources.get(0));

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
  public void listEntitlementsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      FolderLocationName parent = FolderLocationName.of("[FOLDER]", "[LOCATION]");
      client.listEntitlements(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listEntitlementsTest2() throws Exception {
    Entitlement responsesElement = Entitlement.newBuilder().build();
    ListEntitlementsResponse expectedResponse =
        ListEntitlementsResponse.newBuilder()
            .setNextPageToken("")
            .addAllEntitlements(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListEntitlementsPagedResponse pagedListResponse = client.listEntitlements(parent);

    List<Entitlement> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEntitlementsList().get(0), resources.get(0));

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
  public void listEntitlementsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listEntitlements(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listEntitlementsTest3() throws Exception {
    Entitlement responsesElement = Entitlement.newBuilder().build();
    ListEntitlementsResponse expectedResponse =
        ListEntitlementsResponse.newBuilder()
            .setNextPageToken("")
            .addAllEntitlements(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");

    ListEntitlementsPagedResponse pagedListResponse = client.listEntitlements(parent);

    List<Entitlement> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEntitlementsList().get(0), resources.get(0));

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
  public void listEntitlementsExceptionTest3() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
      client.listEntitlements(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listEntitlementsTest4() throws Exception {
    Entitlement responsesElement = Entitlement.newBuilder().build();
    ListEntitlementsResponse expectedResponse =
        ListEntitlementsResponse.newBuilder()
            .setNextPageToken("")
            .addAllEntitlements(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListEntitlementsPagedResponse pagedListResponse = client.listEntitlements(parent);

    List<Entitlement> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEntitlementsList().get(0), resources.get(0));

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
  public void listEntitlementsExceptionTest4() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listEntitlements(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void searchEntitlementsTest() throws Exception {
    Entitlement responsesElement = Entitlement.newBuilder().build();
    SearchEntitlementsResponse expectedResponse =
        SearchEntitlementsResponse.newBuilder()
            .setNextPageToken("")
            .addAllEntitlements(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    SearchEntitlementsRequest request =
        SearchEntitlementsRequest.newBuilder()
            .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
            .setFilter("filter-1274492040")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    SearchEntitlementsPagedResponse pagedListResponse = client.searchEntitlements(request);

    List<Entitlement> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEntitlementsList().get(0), resources.get(0));

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
  public void searchEntitlementsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SearchEntitlementsRequest request =
          SearchEntitlementsRequest.newBuilder()
              .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
              .setFilter("filter-1274492040")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      client.searchEntitlements(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getEntitlementTest() throws Exception {
    Entitlement expectedResponse =
        Entitlement.newBuilder()
            .setName(
                EntitlementName.ofProjectLocationEntitlementName(
                        "[PROJECT]", "[LOCATION]", "[ENTITLEMENT]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllEligibleUsers(new ArrayList<AccessControlEntry>())
            .setApprovalWorkflow(ApprovalWorkflow.newBuilder().build())
            .setPrivilegedAccess(PrivilegedAccess.newBuilder().build())
            .setMaxRequestDuration(Duration.newBuilder().build())
            .setRequesterJustificationConfig(
                Entitlement.RequesterJustificationConfig.newBuilder().build())
            .setAdditionalNotificationTargets(
                Entitlement.AdditionalNotificationTargets.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    mockService.addResponse(expectedResponse);

    EntitlementName name =
        EntitlementName.ofProjectLocationEntitlementName(
            "[PROJECT]", "[LOCATION]", "[ENTITLEMENT]");

    Entitlement actualResponse = client.getEntitlement(name);
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
  public void getEntitlementExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      EntitlementName name =
          EntitlementName.ofProjectLocationEntitlementName(
              "[PROJECT]", "[LOCATION]", "[ENTITLEMENT]");
      client.getEntitlement(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getEntitlementTest2() throws Exception {
    Entitlement expectedResponse =
        Entitlement.newBuilder()
            .setName(
                EntitlementName.ofProjectLocationEntitlementName(
                        "[PROJECT]", "[LOCATION]", "[ENTITLEMENT]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllEligibleUsers(new ArrayList<AccessControlEntry>())
            .setApprovalWorkflow(ApprovalWorkflow.newBuilder().build())
            .setPrivilegedAccess(PrivilegedAccess.newBuilder().build())
            .setMaxRequestDuration(Duration.newBuilder().build())
            .setRequesterJustificationConfig(
                Entitlement.RequesterJustificationConfig.newBuilder().build())
            .setAdditionalNotificationTargets(
                Entitlement.AdditionalNotificationTargets.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-1958/locations/location-1958/entitlements/entitlement-1958";

    Entitlement actualResponse = client.getEntitlement(name);
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
  public void getEntitlementExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-1958/locations/location-1958/entitlements/entitlement-1958";
      client.getEntitlement(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createEntitlementTest() throws Exception {
    Entitlement expectedResponse =
        Entitlement.newBuilder()
            .setName(
                EntitlementName.ofProjectLocationEntitlementName(
                        "[PROJECT]", "[LOCATION]", "[ENTITLEMENT]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllEligibleUsers(new ArrayList<AccessControlEntry>())
            .setApprovalWorkflow(ApprovalWorkflow.newBuilder().build())
            .setPrivilegedAccess(PrivilegedAccess.newBuilder().build())
            .setMaxRequestDuration(Duration.newBuilder().build())
            .setRequesterJustificationConfig(
                Entitlement.RequesterJustificationConfig.newBuilder().build())
            .setAdditionalNotificationTargets(
                Entitlement.AdditionalNotificationTargets.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createEntitlementTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    FolderLocationName parent = FolderLocationName.of("[FOLDER]", "[LOCATION]");
    Entitlement entitlement = Entitlement.newBuilder().build();
    String entitlementId = "entitlementId-1302274264";

    Entitlement actualResponse =
        client.createEntitlementAsync(parent, entitlement, entitlementId).get();
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
  public void createEntitlementExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      FolderLocationName parent = FolderLocationName.of("[FOLDER]", "[LOCATION]");
      Entitlement entitlement = Entitlement.newBuilder().build();
      String entitlementId = "entitlementId-1302274264";
      client.createEntitlementAsync(parent, entitlement, entitlementId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createEntitlementTest2() throws Exception {
    Entitlement expectedResponse =
        Entitlement.newBuilder()
            .setName(
                EntitlementName.ofProjectLocationEntitlementName(
                        "[PROJECT]", "[LOCATION]", "[ENTITLEMENT]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllEligibleUsers(new ArrayList<AccessControlEntry>())
            .setApprovalWorkflow(ApprovalWorkflow.newBuilder().build())
            .setPrivilegedAccess(PrivilegedAccess.newBuilder().build())
            .setMaxRequestDuration(Duration.newBuilder().build())
            .setRequesterJustificationConfig(
                Entitlement.RequesterJustificationConfig.newBuilder().build())
            .setAdditionalNotificationTargets(
                Entitlement.AdditionalNotificationTargets.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createEntitlementTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Entitlement entitlement = Entitlement.newBuilder().build();
    String entitlementId = "entitlementId-1302274264";

    Entitlement actualResponse =
        client.createEntitlementAsync(parent, entitlement, entitlementId).get();
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
  public void createEntitlementExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Entitlement entitlement = Entitlement.newBuilder().build();
      String entitlementId = "entitlementId-1302274264";
      client.createEntitlementAsync(parent, entitlement, entitlementId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createEntitlementTest3() throws Exception {
    Entitlement expectedResponse =
        Entitlement.newBuilder()
            .setName(
                EntitlementName.ofProjectLocationEntitlementName(
                        "[PROJECT]", "[LOCATION]", "[ENTITLEMENT]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllEligibleUsers(new ArrayList<AccessControlEntry>())
            .setApprovalWorkflow(ApprovalWorkflow.newBuilder().build())
            .setPrivilegedAccess(PrivilegedAccess.newBuilder().build())
            .setMaxRequestDuration(Duration.newBuilder().build())
            .setRequesterJustificationConfig(
                Entitlement.RequesterJustificationConfig.newBuilder().build())
            .setAdditionalNotificationTargets(
                Entitlement.AdditionalNotificationTargets.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createEntitlementTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
    Entitlement entitlement = Entitlement.newBuilder().build();
    String entitlementId = "entitlementId-1302274264";

    Entitlement actualResponse =
        client.createEntitlementAsync(parent, entitlement, entitlementId).get();
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
  public void createEntitlementExceptionTest3() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
      Entitlement entitlement = Entitlement.newBuilder().build();
      String entitlementId = "entitlementId-1302274264";
      client.createEntitlementAsync(parent, entitlement, entitlementId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createEntitlementTest4() throws Exception {
    Entitlement expectedResponse =
        Entitlement.newBuilder()
            .setName(
                EntitlementName.ofProjectLocationEntitlementName(
                        "[PROJECT]", "[LOCATION]", "[ENTITLEMENT]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllEligibleUsers(new ArrayList<AccessControlEntry>())
            .setApprovalWorkflow(ApprovalWorkflow.newBuilder().build())
            .setPrivilegedAccess(PrivilegedAccess.newBuilder().build())
            .setMaxRequestDuration(Duration.newBuilder().build())
            .setRequesterJustificationConfig(
                Entitlement.RequesterJustificationConfig.newBuilder().build())
            .setAdditionalNotificationTargets(
                Entitlement.AdditionalNotificationTargets.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createEntitlementTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5833/locations/location-5833";
    Entitlement entitlement = Entitlement.newBuilder().build();
    String entitlementId = "entitlementId-1302274264";

    Entitlement actualResponse =
        client.createEntitlementAsync(parent, entitlement, entitlementId).get();
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
  public void createEntitlementExceptionTest4() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      Entitlement entitlement = Entitlement.newBuilder().build();
      String entitlementId = "entitlementId-1302274264";
      client.createEntitlementAsync(parent, entitlement, entitlementId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteEntitlementTest() throws Exception {
    Entitlement expectedResponse =
        Entitlement.newBuilder()
            .setName(
                EntitlementName.ofProjectLocationEntitlementName(
                        "[PROJECT]", "[LOCATION]", "[ENTITLEMENT]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllEligibleUsers(new ArrayList<AccessControlEntry>())
            .setApprovalWorkflow(ApprovalWorkflow.newBuilder().build())
            .setPrivilegedAccess(PrivilegedAccess.newBuilder().build())
            .setMaxRequestDuration(Duration.newBuilder().build())
            .setRequesterJustificationConfig(
                Entitlement.RequesterJustificationConfig.newBuilder().build())
            .setAdditionalNotificationTargets(
                Entitlement.AdditionalNotificationTargets.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteEntitlementTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    EntitlementName name =
        EntitlementName.ofProjectLocationEntitlementName(
            "[PROJECT]", "[LOCATION]", "[ENTITLEMENT]");

    Entitlement actualResponse = client.deleteEntitlementAsync(name).get();
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
  public void deleteEntitlementExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      EntitlementName name =
          EntitlementName.ofProjectLocationEntitlementName(
              "[PROJECT]", "[LOCATION]", "[ENTITLEMENT]");
      client.deleteEntitlementAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteEntitlementTest2() throws Exception {
    Entitlement expectedResponse =
        Entitlement.newBuilder()
            .setName(
                EntitlementName.ofProjectLocationEntitlementName(
                        "[PROJECT]", "[LOCATION]", "[ENTITLEMENT]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllEligibleUsers(new ArrayList<AccessControlEntry>())
            .setApprovalWorkflow(ApprovalWorkflow.newBuilder().build())
            .setPrivilegedAccess(PrivilegedAccess.newBuilder().build())
            .setMaxRequestDuration(Duration.newBuilder().build())
            .setRequesterJustificationConfig(
                Entitlement.RequesterJustificationConfig.newBuilder().build())
            .setAdditionalNotificationTargets(
                Entitlement.AdditionalNotificationTargets.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteEntitlementTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name = "projects/project-1958/locations/location-1958/entitlements/entitlement-1958";

    Entitlement actualResponse = client.deleteEntitlementAsync(name).get();
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
  public void deleteEntitlementExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-1958/locations/location-1958/entitlements/entitlement-1958";
      client.deleteEntitlementAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void updateEntitlementTest() throws Exception {
    Entitlement expectedResponse =
        Entitlement.newBuilder()
            .setName(
                EntitlementName.ofProjectLocationEntitlementName(
                        "[PROJECT]", "[LOCATION]", "[ENTITLEMENT]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllEligibleUsers(new ArrayList<AccessControlEntry>())
            .setApprovalWorkflow(ApprovalWorkflow.newBuilder().build())
            .setPrivilegedAccess(PrivilegedAccess.newBuilder().build())
            .setMaxRequestDuration(Duration.newBuilder().build())
            .setRequesterJustificationConfig(
                Entitlement.RequesterJustificationConfig.newBuilder().build())
            .setAdditionalNotificationTargets(
                Entitlement.AdditionalNotificationTargets.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateEntitlementTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    Entitlement entitlement =
        Entitlement.newBuilder()
            .setName(
                EntitlementName.ofProjectLocationEntitlementName(
                        "[PROJECT]", "[LOCATION]", "[ENTITLEMENT]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllEligibleUsers(new ArrayList<AccessControlEntry>())
            .setApprovalWorkflow(ApprovalWorkflow.newBuilder().build())
            .setPrivilegedAccess(PrivilegedAccess.newBuilder().build())
            .setMaxRequestDuration(Duration.newBuilder().build())
            .setRequesterJustificationConfig(
                Entitlement.RequesterJustificationConfig.newBuilder().build())
            .setAdditionalNotificationTargets(
                Entitlement.AdditionalNotificationTargets.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Entitlement actualResponse = client.updateEntitlementAsync(entitlement, updateMask).get();
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
  public void updateEntitlementExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Entitlement entitlement =
          Entitlement.newBuilder()
              .setName(
                  EntitlementName.ofProjectLocationEntitlementName(
                          "[PROJECT]", "[LOCATION]", "[ENTITLEMENT]")
                      .toString())
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .addAllEligibleUsers(new ArrayList<AccessControlEntry>())
              .setApprovalWorkflow(ApprovalWorkflow.newBuilder().build())
              .setPrivilegedAccess(PrivilegedAccess.newBuilder().build())
              .setMaxRequestDuration(Duration.newBuilder().build())
              .setRequesterJustificationConfig(
                  Entitlement.RequesterJustificationConfig.newBuilder().build())
              .setAdditionalNotificationTargets(
                  Entitlement.AdditionalNotificationTargets.newBuilder().build())
              .setEtag("etag3123477")
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateEntitlementAsync(entitlement, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void listGrantsTest() throws Exception {
    Grant responsesElement = Grant.newBuilder().build();
    ListGrantsResponse expectedResponse =
        ListGrantsResponse.newBuilder()
            .setNextPageToken("")
            .addAllGrants(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    EntitlementName parent =
        EntitlementName.ofProjectLocationEntitlementName(
            "[PROJECT]", "[LOCATION]", "[ENTITLEMENT]");

    ListGrantsPagedResponse pagedListResponse = client.listGrants(parent);

    List<Grant> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getGrantsList().get(0), resources.get(0));

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
  public void listGrantsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      EntitlementName parent =
          EntitlementName.ofProjectLocationEntitlementName(
              "[PROJECT]", "[LOCATION]", "[ENTITLEMENT]");
      client.listGrants(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listGrantsTest2() throws Exception {
    Grant responsesElement = Grant.newBuilder().build();
    ListGrantsResponse expectedResponse =
        ListGrantsResponse.newBuilder()
            .setNextPageToken("")
            .addAllGrants(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-7783/locations/location-7783/entitlements/entitlement-7783";

    ListGrantsPagedResponse pagedListResponse = client.listGrants(parent);

    List<Grant> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getGrantsList().get(0), resources.get(0));

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
  public void listGrantsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-7783/locations/location-7783/entitlements/entitlement-7783";
      client.listGrants(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void searchGrantsTest() throws Exception {
    Grant responsesElement = Grant.newBuilder().build();
    SearchGrantsResponse expectedResponse =
        SearchGrantsResponse.newBuilder()
            .setNextPageToken("")
            .addAllGrants(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    SearchGrantsRequest request =
        SearchGrantsRequest.newBuilder()
            .setParent(
                EntitlementName.ofProjectLocationEntitlementName(
                        "[PROJECT]", "[LOCATION]", "[ENTITLEMENT]")
                    .toString())
            .setFilter("filter-1274492040")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    SearchGrantsPagedResponse pagedListResponse = client.searchGrants(request);

    List<Grant> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getGrantsList().get(0), resources.get(0));

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
  public void searchGrantsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SearchGrantsRequest request =
          SearchGrantsRequest.newBuilder()
              .setParent(
                  EntitlementName.ofProjectLocationEntitlementName(
                          "[PROJECT]", "[LOCATION]", "[ENTITLEMENT]")
                      .toString())
              .setFilter("filter-1274492040")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      client.searchGrants(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getGrantTest() throws Exception {
    Grant expectedResponse =
        Grant.newBuilder()
            .setName(
                GrantName.ofProjectLocationEntitlementGrantName(
                        "[PROJECT]", "[LOCATION]", "[ENTITLEMENT]", "[GRANT]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setRequester("requester693933948")
            .setRequestedDuration(Duration.newBuilder().build())
            .setJustification(Justification.newBuilder().build())
            .setTimeline(Grant.Timeline.newBuilder().build())
            .setPrivilegedAccess(PrivilegedAccess.newBuilder().build())
            .setAuditTrail(Grant.AuditTrail.newBuilder().build())
            .addAllAdditionalEmailRecipients(new ArrayList<String>())
            .setExternallyModified(true)
            .build();
    mockService.addResponse(expectedResponse);

    GrantName name =
        GrantName.ofProjectLocationEntitlementGrantName(
            "[PROJECT]", "[LOCATION]", "[ENTITLEMENT]", "[GRANT]");

    Grant actualResponse = client.getGrant(name);
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
  public void getGrantExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GrantName name =
          GrantName.ofProjectLocationEntitlementGrantName(
              "[PROJECT]", "[LOCATION]", "[ENTITLEMENT]", "[GRANT]");
      client.getGrant(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getGrantTest2() throws Exception {
    Grant expectedResponse =
        Grant.newBuilder()
            .setName(
                GrantName.ofProjectLocationEntitlementGrantName(
                        "[PROJECT]", "[LOCATION]", "[ENTITLEMENT]", "[GRANT]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setRequester("requester693933948")
            .setRequestedDuration(Duration.newBuilder().build())
            .setJustification(Justification.newBuilder().build())
            .setTimeline(Grant.Timeline.newBuilder().build())
            .setPrivilegedAccess(PrivilegedAccess.newBuilder().build())
            .setAuditTrail(Grant.AuditTrail.newBuilder().build())
            .addAllAdditionalEmailRecipients(new ArrayList<String>())
            .setExternallyModified(true)
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-3819/locations/location-3819/entitlements/entitlement-3819/grants/grant-3819";

    Grant actualResponse = client.getGrant(name);
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
  public void getGrantExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-3819/locations/location-3819/entitlements/entitlement-3819/grants/grant-3819";
      client.getGrant(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createGrantTest() throws Exception {
    Grant expectedResponse =
        Grant.newBuilder()
            .setName(
                GrantName.ofProjectLocationEntitlementGrantName(
                        "[PROJECT]", "[LOCATION]", "[ENTITLEMENT]", "[GRANT]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setRequester("requester693933948")
            .setRequestedDuration(Duration.newBuilder().build())
            .setJustification(Justification.newBuilder().build())
            .setTimeline(Grant.Timeline.newBuilder().build())
            .setPrivilegedAccess(PrivilegedAccess.newBuilder().build())
            .setAuditTrail(Grant.AuditTrail.newBuilder().build())
            .addAllAdditionalEmailRecipients(new ArrayList<String>())
            .setExternallyModified(true)
            .build();
    mockService.addResponse(expectedResponse);

    EntitlementName parent =
        EntitlementName.ofProjectLocationEntitlementName(
            "[PROJECT]", "[LOCATION]", "[ENTITLEMENT]");
    Grant grant = Grant.newBuilder().build();

    Grant actualResponse = client.createGrant(parent, grant);
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
  public void createGrantExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      EntitlementName parent =
          EntitlementName.ofProjectLocationEntitlementName(
              "[PROJECT]", "[LOCATION]", "[ENTITLEMENT]");
      Grant grant = Grant.newBuilder().build();
      client.createGrant(parent, grant);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createGrantTest2() throws Exception {
    Grant expectedResponse =
        Grant.newBuilder()
            .setName(
                GrantName.ofProjectLocationEntitlementGrantName(
                        "[PROJECT]", "[LOCATION]", "[ENTITLEMENT]", "[GRANT]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setRequester("requester693933948")
            .setRequestedDuration(Duration.newBuilder().build())
            .setJustification(Justification.newBuilder().build())
            .setTimeline(Grant.Timeline.newBuilder().build())
            .setPrivilegedAccess(PrivilegedAccess.newBuilder().build())
            .setAuditTrail(Grant.AuditTrail.newBuilder().build())
            .addAllAdditionalEmailRecipients(new ArrayList<String>())
            .setExternallyModified(true)
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-7783/locations/location-7783/entitlements/entitlement-7783";
    Grant grant = Grant.newBuilder().build();

    Grant actualResponse = client.createGrant(parent, grant);
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
  public void createGrantExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-7783/locations/location-7783/entitlements/entitlement-7783";
      Grant grant = Grant.newBuilder().build();
      client.createGrant(parent, grant);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void approveGrantTest() throws Exception {
    Grant expectedResponse =
        Grant.newBuilder()
            .setName(
                GrantName.ofProjectLocationEntitlementGrantName(
                        "[PROJECT]", "[LOCATION]", "[ENTITLEMENT]", "[GRANT]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setRequester("requester693933948")
            .setRequestedDuration(Duration.newBuilder().build())
            .setJustification(Justification.newBuilder().build())
            .setTimeline(Grant.Timeline.newBuilder().build())
            .setPrivilegedAccess(PrivilegedAccess.newBuilder().build())
            .setAuditTrail(Grant.AuditTrail.newBuilder().build())
            .addAllAdditionalEmailRecipients(new ArrayList<String>())
            .setExternallyModified(true)
            .build();
    mockService.addResponse(expectedResponse);

    ApproveGrantRequest request =
        ApproveGrantRequest.newBuilder()
            .setName(
                GrantName.ofProjectLocationEntitlementGrantName(
                        "[PROJECT]", "[LOCATION]", "[ENTITLEMENT]", "[GRANT]")
                    .toString())
            .setReason("reason-934964668")
            .build();

    Grant actualResponse = client.approveGrant(request);
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
  public void approveGrantExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ApproveGrantRequest request =
          ApproveGrantRequest.newBuilder()
              .setName(
                  GrantName.ofProjectLocationEntitlementGrantName(
                          "[PROJECT]", "[LOCATION]", "[ENTITLEMENT]", "[GRANT]")
                      .toString())
              .setReason("reason-934964668")
              .build();
      client.approveGrant(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void denyGrantTest() throws Exception {
    Grant expectedResponse =
        Grant.newBuilder()
            .setName(
                GrantName.ofProjectLocationEntitlementGrantName(
                        "[PROJECT]", "[LOCATION]", "[ENTITLEMENT]", "[GRANT]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setRequester("requester693933948")
            .setRequestedDuration(Duration.newBuilder().build())
            .setJustification(Justification.newBuilder().build())
            .setTimeline(Grant.Timeline.newBuilder().build())
            .setPrivilegedAccess(PrivilegedAccess.newBuilder().build())
            .setAuditTrail(Grant.AuditTrail.newBuilder().build())
            .addAllAdditionalEmailRecipients(new ArrayList<String>())
            .setExternallyModified(true)
            .build();
    mockService.addResponse(expectedResponse);

    DenyGrantRequest request =
        DenyGrantRequest.newBuilder()
            .setName(
                GrantName.ofProjectLocationEntitlementGrantName(
                        "[PROJECT]", "[LOCATION]", "[ENTITLEMENT]", "[GRANT]")
                    .toString())
            .setReason("reason-934964668")
            .build();

    Grant actualResponse = client.denyGrant(request);
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
  public void denyGrantExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DenyGrantRequest request =
          DenyGrantRequest.newBuilder()
              .setName(
                  GrantName.ofProjectLocationEntitlementGrantName(
                          "[PROJECT]", "[LOCATION]", "[ENTITLEMENT]", "[GRANT]")
                      .toString())
              .setReason("reason-934964668")
              .build();
      client.denyGrant(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void revokeGrantTest() throws Exception {
    Grant expectedResponse =
        Grant.newBuilder()
            .setName(
                GrantName.ofProjectLocationEntitlementGrantName(
                        "[PROJECT]", "[LOCATION]", "[ENTITLEMENT]", "[GRANT]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setRequester("requester693933948")
            .setRequestedDuration(Duration.newBuilder().build())
            .setJustification(Justification.newBuilder().build())
            .setTimeline(Grant.Timeline.newBuilder().build())
            .setPrivilegedAccess(PrivilegedAccess.newBuilder().build())
            .setAuditTrail(Grant.AuditTrail.newBuilder().build())
            .addAllAdditionalEmailRecipients(new ArrayList<String>())
            .setExternallyModified(true)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("revokeGrantTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    RevokeGrantRequest request =
        RevokeGrantRequest.newBuilder()
            .setName(
                GrantName.ofProjectLocationEntitlementGrantName(
                        "[PROJECT]", "[LOCATION]", "[ENTITLEMENT]", "[GRANT]")
                    .toString())
            .setReason("reason-934964668")
            .build();

    Grant actualResponse = client.revokeGrantAsync(request).get();
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
  public void revokeGrantExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      RevokeGrantRequest request =
          RevokeGrantRequest.newBuilder()
              .setName(
                  GrantName.ofProjectLocationEntitlementGrantName(
                          "[PROJECT]", "[LOCATION]", "[ENTITLEMENT]", "[GRANT]")
                      .toString())
              .setReason("reason-934964668")
              .build();
      client.revokeGrantAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
}
