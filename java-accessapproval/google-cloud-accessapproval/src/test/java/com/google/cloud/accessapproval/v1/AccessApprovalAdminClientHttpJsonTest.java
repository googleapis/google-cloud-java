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

package com.google.cloud.accessapproval.v1;

import static com.google.cloud.accessapproval.v1.AccessApprovalAdminClient.ListApprovalRequestsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.accessapproval.v1.stub.HttpJsonAccessApprovalStub;
import com.google.common.collect.Lists;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class AccessApprovalAdminClientHttpJsonTest {
  private static MockHttpService mockService;
  private static AccessApprovalAdminClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonAccessApprovalStub.getMethodDescriptors(),
            AccessApprovalAdminSettings.getDefaultEndpoint());
    AccessApprovalAdminSettings settings =
        AccessApprovalAdminSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                AccessApprovalAdminSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = AccessApprovalAdminClient.create(settings);
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
  public void listApprovalRequestsTest() throws Exception {
    ApprovalRequest responsesElement = ApprovalRequest.newBuilder().build();
    ListApprovalRequestsResponse expectedResponse =
        ListApprovalRequestsResponse.newBuilder()
            .setNextPageToken("")
            .addAllApprovalRequests(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    FolderName parent = FolderName.of("[FOLDER]");

    ListApprovalRequestsPagedResponse pagedListResponse = client.listApprovalRequests(parent);

    List<ApprovalRequest> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getApprovalRequestsList().get(0), resources.get(0));

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
  public void listApprovalRequestsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      FolderName parent = FolderName.of("[FOLDER]");
      client.listApprovalRequests(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listApprovalRequestsTest2() throws Exception {
    ApprovalRequest responsesElement = ApprovalRequest.newBuilder().build();
    ListApprovalRequestsResponse expectedResponse =
        ListApprovalRequestsResponse.newBuilder()
            .setNextPageToken("")
            .addAllApprovalRequests(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    OrganizationName parent = OrganizationName.of("[ORGANIZATION]");

    ListApprovalRequestsPagedResponse pagedListResponse = client.listApprovalRequests(parent);

    List<ApprovalRequest> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getApprovalRequestsList().get(0), resources.get(0));

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
  public void listApprovalRequestsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
      client.listApprovalRequests(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listApprovalRequestsTest3() throws Exception {
    ApprovalRequest responsesElement = ApprovalRequest.newBuilder().build();
    ListApprovalRequestsResponse expectedResponse =
        ListApprovalRequestsResponse.newBuilder()
            .setNextPageToken("")
            .addAllApprovalRequests(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");

    ListApprovalRequestsPagedResponse pagedListResponse = client.listApprovalRequests(parent);

    List<ApprovalRequest> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getApprovalRequestsList().get(0), resources.get(0));

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
  public void listApprovalRequestsExceptionTest3() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      client.listApprovalRequests(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listApprovalRequestsTest4() throws Exception {
    ApprovalRequest responsesElement = ApprovalRequest.newBuilder().build();
    ListApprovalRequestsResponse expectedResponse =
        ListApprovalRequestsResponse.newBuilder()
            .setNextPageToken("")
            .addAllApprovalRequests(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-2353";

    ListApprovalRequestsPagedResponse pagedListResponse = client.listApprovalRequests(parent);

    List<ApprovalRequest> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getApprovalRequestsList().get(0), resources.get(0));

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
  public void listApprovalRequestsExceptionTest4() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-2353";
      client.listApprovalRequests(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getApprovalRequestTest() throws Exception {
    ApprovalRequest expectedResponse =
        ApprovalRequest.newBuilder()
            .setName(
                ApprovalRequestName.ofProjectApprovalRequestName("[PROJECT]", "[APPROVAL_REQUEST]")
                    .toString())
            .setRequestedResourceName("requestedResourceName-1218563513")
            .setRequestedResourceProperties(ResourceProperties.newBuilder().build())
            .setRequestedReason(AccessReason.newBuilder().build())
            .setRequestedLocations(AccessLocations.newBuilder().build())
            .setRequestTime(Timestamp.newBuilder().build())
            .setRequestedExpiration(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    ApprovalRequestName name =
        ApprovalRequestName.ofProjectApprovalRequestName("[PROJECT]", "[APPROVAL_REQUEST]");

    ApprovalRequest actualResponse = client.getApprovalRequest(name);
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
  public void getApprovalRequestExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ApprovalRequestName name =
          ApprovalRequestName.ofProjectApprovalRequestName("[PROJECT]", "[APPROVAL_REQUEST]");
      client.getApprovalRequest(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getApprovalRequestTest2() throws Exception {
    ApprovalRequest expectedResponse =
        ApprovalRequest.newBuilder()
            .setName(
                ApprovalRequestName.ofProjectApprovalRequestName("[PROJECT]", "[APPROVAL_REQUEST]")
                    .toString())
            .setRequestedResourceName("requestedResourceName-1218563513")
            .setRequestedResourceProperties(ResourceProperties.newBuilder().build())
            .setRequestedReason(AccessReason.newBuilder().build())
            .setRequestedLocations(AccessLocations.newBuilder().build())
            .setRequestTime(Timestamp.newBuilder().build())
            .setRequestedExpiration(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-6513/approvalRequests/approvalRequest-6513";

    ApprovalRequest actualResponse = client.getApprovalRequest(name);
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
  public void getApprovalRequestExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-6513/approvalRequests/approvalRequest-6513";
      client.getApprovalRequest(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void approveApprovalRequestTest() throws Exception {
    ApprovalRequest expectedResponse =
        ApprovalRequest.newBuilder()
            .setName(
                ApprovalRequestName.ofProjectApprovalRequestName("[PROJECT]", "[APPROVAL_REQUEST]")
                    .toString())
            .setRequestedResourceName("requestedResourceName-1218563513")
            .setRequestedResourceProperties(ResourceProperties.newBuilder().build())
            .setRequestedReason(AccessReason.newBuilder().build())
            .setRequestedLocations(AccessLocations.newBuilder().build())
            .setRequestTime(Timestamp.newBuilder().build())
            .setRequestedExpiration(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    ApproveApprovalRequestMessage request =
        ApproveApprovalRequestMessage.newBuilder()
            .setName(
                ApprovalRequestName.ofProjectApprovalRequestName("[PROJECT]", "[APPROVAL_REQUEST]")
                    .toString())
            .setExpireTime(Timestamp.newBuilder().build())
            .build();

    ApprovalRequest actualResponse = client.approveApprovalRequest(request);
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
  public void approveApprovalRequestExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ApproveApprovalRequestMessage request =
          ApproveApprovalRequestMessage.newBuilder()
              .setName(
                  ApprovalRequestName.ofProjectApprovalRequestName(
                          "[PROJECT]", "[APPROVAL_REQUEST]")
                      .toString())
              .setExpireTime(Timestamp.newBuilder().build())
              .build();
      client.approveApprovalRequest(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void dismissApprovalRequestTest() throws Exception {
    ApprovalRequest expectedResponse =
        ApprovalRequest.newBuilder()
            .setName(
                ApprovalRequestName.ofProjectApprovalRequestName("[PROJECT]", "[APPROVAL_REQUEST]")
                    .toString())
            .setRequestedResourceName("requestedResourceName-1218563513")
            .setRequestedResourceProperties(ResourceProperties.newBuilder().build())
            .setRequestedReason(AccessReason.newBuilder().build())
            .setRequestedLocations(AccessLocations.newBuilder().build())
            .setRequestTime(Timestamp.newBuilder().build())
            .setRequestedExpiration(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    DismissApprovalRequestMessage request =
        DismissApprovalRequestMessage.newBuilder()
            .setName(
                ApprovalRequestName.ofProjectApprovalRequestName("[PROJECT]", "[APPROVAL_REQUEST]")
                    .toString())
            .build();

    ApprovalRequest actualResponse = client.dismissApprovalRequest(request);
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
  public void dismissApprovalRequestExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DismissApprovalRequestMessage request =
          DismissApprovalRequestMessage.newBuilder()
              .setName(
                  ApprovalRequestName.ofProjectApprovalRequestName(
                          "[PROJECT]", "[APPROVAL_REQUEST]")
                      .toString())
              .build();
      client.dismissApprovalRequest(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void invalidateApprovalRequestTest() throws Exception {
    ApprovalRequest expectedResponse =
        ApprovalRequest.newBuilder()
            .setName(
                ApprovalRequestName.ofProjectApprovalRequestName("[PROJECT]", "[APPROVAL_REQUEST]")
                    .toString())
            .setRequestedResourceName("requestedResourceName-1218563513")
            .setRequestedResourceProperties(ResourceProperties.newBuilder().build())
            .setRequestedReason(AccessReason.newBuilder().build())
            .setRequestedLocations(AccessLocations.newBuilder().build())
            .setRequestTime(Timestamp.newBuilder().build())
            .setRequestedExpiration(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    InvalidateApprovalRequestMessage request =
        InvalidateApprovalRequestMessage.newBuilder()
            .setName(
                ApprovalRequestName.ofProjectApprovalRequestName("[PROJECT]", "[APPROVAL_REQUEST]")
                    .toString())
            .build();

    ApprovalRequest actualResponse = client.invalidateApprovalRequest(request);
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
  public void invalidateApprovalRequestExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      InvalidateApprovalRequestMessage request =
          InvalidateApprovalRequestMessage.newBuilder()
              .setName(
                  ApprovalRequestName.ofProjectApprovalRequestName(
                          "[PROJECT]", "[APPROVAL_REQUEST]")
                      .toString())
              .build();
      client.invalidateApprovalRequest(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAccessApprovalSettingsTest() throws Exception {
    AccessApprovalSettings expectedResponse =
        AccessApprovalSettings.newBuilder()
            .setName(AccessApprovalSettingsName.ofProjectName("[PROJECT]").toString())
            .addAllNotificationEmails(new ArrayList<String>())
            .addAllEnrolledServices(new ArrayList<EnrolledService>())
            .setEnrolledAncestor(true)
            .setActiveKeyVersion("activeKeyVersion1352190239")
            .setAncestorHasActiveKeyVersion(true)
            .setInvalidKeyVersion(true)
            .build();
    mockService.addResponse(expectedResponse);

    AccessApprovalSettingsName name = AccessApprovalSettingsName.ofProjectName("[PROJECT]");

    AccessApprovalSettings actualResponse = client.getAccessApprovalSettings(name);
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
  public void getAccessApprovalSettingsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AccessApprovalSettingsName name = AccessApprovalSettingsName.ofProjectName("[PROJECT]");
      client.getAccessApprovalSettings(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAccessApprovalSettingsTest2() throws Exception {
    AccessApprovalSettings expectedResponse =
        AccessApprovalSettings.newBuilder()
            .setName(AccessApprovalSettingsName.ofProjectName("[PROJECT]").toString())
            .addAllNotificationEmails(new ArrayList<String>())
            .addAllEnrolledServices(new ArrayList<EnrolledService>())
            .setEnrolledAncestor(true)
            .setActiveKeyVersion("activeKeyVersion1352190239")
            .setAncestorHasActiveKeyVersion(true)
            .setInvalidKeyVersion(true)
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-9033/accessApprovalSettings";

    AccessApprovalSettings actualResponse = client.getAccessApprovalSettings(name);
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
  public void getAccessApprovalSettingsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-9033/accessApprovalSettings";
      client.getAccessApprovalSettings(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateAccessApprovalSettingsTest() throws Exception {
    AccessApprovalSettings expectedResponse =
        AccessApprovalSettings.newBuilder()
            .setName(AccessApprovalSettingsName.ofProjectName("[PROJECT]").toString())
            .addAllNotificationEmails(new ArrayList<String>())
            .addAllEnrolledServices(new ArrayList<EnrolledService>())
            .setEnrolledAncestor(true)
            .setActiveKeyVersion("activeKeyVersion1352190239")
            .setAncestorHasActiveKeyVersion(true)
            .setInvalidKeyVersion(true)
            .build();
    mockService.addResponse(expectedResponse);

    AccessApprovalSettings settings =
        AccessApprovalSettings.newBuilder()
            .setName(AccessApprovalSettingsName.ofProjectName("[PROJECT]").toString())
            .addAllNotificationEmails(new ArrayList<String>())
            .addAllEnrolledServices(new ArrayList<EnrolledService>())
            .setEnrolledAncestor(true)
            .setActiveKeyVersion("activeKeyVersion1352190239")
            .setAncestorHasActiveKeyVersion(true)
            .setInvalidKeyVersion(true)
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    AccessApprovalSettings actualResponse =
        client.updateAccessApprovalSettings(settings, updateMask);
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
  public void updateAccessApprovalSettingsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AccessApprovalSettings settings =
          AccessApprovalSettings.newBuilder()
              .setName(AccessApprovalSettingsName.ofProjectName("[PROJECT]").toString())
              .addAllNotificationEmails(new ArrayList<String>())
              .addAllEnrolledServices(new ArrayList<EnrolledService>())
              .setEnrolledAncestor(true)
              .setActiveKeyVersion("activeKeyVersion1352190239")
              .setAncestorHasActiveKeyVersion(true)
              .setInvalidKeyVersion(true)
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateAccessApprovalSettings(settings, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteAccessApprovalSettingsTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    AccessApprovalSettingsName name = AccessApprovalSettingsName.ofProjectName("[PROJECT]");

    client.deleteAccessApprovalSettings(name);

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
  public void deleteAccessApprovalSettingsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AccessApprovalSettingsName name = AccessApprovalSettingsName.ofProjectName("[PROJECT]");
      client.deleteAccessApprovalSettings(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteAccessApprovalSettingsTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-9033/accessApprovalSettings";

    client.deleteAccessApprovalSettings(name);

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
  public void deleteAccessApprovalSettingsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-9033/accessApprovalSettings";
      client.deleteAccessApprovalSettings(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAccessApprovalServiceAccountTest() throws Exception {
    AccessApprovalServiceAccount expectedResponse =
        AccessApprovalServiceAccount.newBuilder()
            .setName("name3373707")
            .setAccountEmail("accountEmail1067197807")
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-9017/serviceAccount";

    AccessApprovalServiceAccount actualResponse = client.getAccessApprovalServiceAccount(name);
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
  public void getAccessApprovalServiceAccountExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-9017/serviceAccount";
      client.getAccessApprovalServiceAccount(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
