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

package com.google.cloud.auditmanager.v1;

import static com.google.cloud.auditmanager.v1.AuditManagerClient.ListAuditReportsPagedResponse;
import static com.google.cloud.auditmanager.v1.AuditManagerClient.ListControlsPagedResponse;
import static com.google.cloud.auditmanager.v1.AuditManagerClient.ListLocationsPagedResponse;
import static com.google.cloud.auditmanager.v1.AuditManagerClient.ListResourceEnrollmentStatusesPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.auditmanager.v1.stub.HttpJsonAuditManagerStub;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Any;
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
public class AuditManagerClientHttpJsonTest {
  private static MockHttpService mockService;
  private static AuditManagerClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonAuditManagerStub.getMethodDescriptors(),
            AuditManagerSettings.getDefaultEndpoint());
    AuditManagerSettings settings =
        AuditManagerSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                AuditManagerSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = AuditManagerClient.create(settings);
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
  public void enrollResourceTest() throws Exception {
    Enrollment expectedResponse =
        Enrollment.newBuilder()
            .setName("name3373707")
            .addAllDestinationDetails(new ArrayList<DestinationDetails>())
            .build();
    mockService.addResponse(expectedResponse);

    String scope = "folders/folder-6714/locations/location-6714";
    List<EnrollResourceRequest.EligibleDestination> destinations = new ArrayList<>();

    Enrollment actualResponse = client.enrollResource(scope, destinations);
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
  public void enrollResourceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String scope = "folders/folder-6714/locations/location-6714";
      List<EnrollResourceRequest.EligibleDestination> destinations = new ArrayList<>();
      client.enrollResource(scope, destinations);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void generateAuditScopeReportTest() throws Exception {
    AuditScopeReport expectedResponse =
        AuditScopeReport.newBuilder().setName("name3373707").build();
    mockService.addResponse(expectedResponse);

    String scope = "folders/folder-6714/locations/location-6714";
    String complianceStandard = "complianceStandard-1534269448";
    GenerateAuditScopeReportRequest.AuditScopeReportFormat reportFormat =
        GenerateAuditScopeReportRequest.AuditScopeReportFormat.forNumber(0);

    AuditScopeReport actualResponse =
        client.generateAuditScopeReport(scope, complianceStandard, reportFormat);
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
  public void generateAuditScopeReportExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String scope = "folders/folder-6714/locations/location-6714";
      String complianceStandard = "complianceStandard-1534269448";
      GenerateAuditScopeReportRequest.AuditScopeReportFormat reportFormat =
          GenerateAuditScopeReportRequest.AuditScopeReportFormat.forNumber(0);
      client.generateAuditScopeReport(scope, complianceStandard, reportFormat);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void generateAuditReportTest() throws Exception {
    AuditReport expectedResponse =
        AuditReport.newBuilder()
            .setName(
                AuditReportName.ofProjectLocationAuditReportName(
                        "[PROJECT]", "[LOCATION]", "[AUDIT_REPORT]")
                    .toString())
            .setReportSummary(ReportSummary.newBuilder().build())
            .setOperationId("operationId129704162")
            .setDestinationDetails(DestinationDetails.newBuilder().build())
            .setComplianceStandard("complianceStandard-1534269448")
            .setScope("scope109264468")
            .setCreateTime(Timestamp.newBuilder().build())
            .addAllControlDetails(new ArrayList<ControlDetails>())
            .setComplianceFramework("complianceFramework-1808314333")
            .setScopeId("scopeId1923941007")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("generateAuditReportTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String scope = "folders/folder-6714/locations/location-6714";
    String gcsUri = "gcsUri-1251224875";
    String complianceStandard = "complianceStandard-1534269448";
    GenerateAuditReportRequest.AuditReportFormat reportFormat =
        GenerateAuditReportRequest.AuditReportFormat.forNumber(0);

    AuditReport actualResponse =
        client.generateAuditReportAsync(scope, gcsUri, complianceStandard, reportFormat).get();
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
  public void generateAuditReportExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String scope = "folders/folder-6714/locations/location-6714";
      String gcsUri = "gcsUri-1251224875";
      String complianceStandard = "complianceStandard-1534269448";
      GenerateAuditReportRequest.AuditReportFormat reportFormat =
          GenerateAuditReportRequest.AuditReportFormat.forNumber(0);
      client.generateAuditReportAsync(scope, gcsUri, complianceStandard, reportFormat).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void listAuditReportsTest() throws Exception {
    AuditReport responsesElement = AuditReport.newBuilder().build();
    ListAuditReportsResponse expectedResponse =
        ListAuditReportsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAuditReports(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    EnrollmentStatusScopeName parent =
        EnrollmentStatusScopeName.ofOrganizationLocationName("[ORGANIZATION]", "[LOCATION]");

    ListAuditReportsPagedResponse pagedListResponse = client.listAuditReports(parent);

    List<AuditReport> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAuditReportsList().get(0), resources.get(0));

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
  public void listAuditReportsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      EnrollmentStatusScopeName parent =
          EnrollmentStatusScopeName.ofOrganizationLocationName("[ORGANIZATION]", "[LOCATION]");
      client.listAuditReports(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAuditReportsTest2() throws Exception {
    AuditReport responsesElement = AuditReport.newBuilder().build();
    ListAuditReportsResponse expectedResponse =
        ListAuditReportsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAuditReports(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListAuditReportsPagedResponse pagedListResponse = client.listAuditReports(parent);

    List<AuditReport> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAuditReportsList().get(0), resources.get(0));

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
  public void listAuditReportsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listAuditReports(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAuditReportsTest3() throws Exception {
    AuditReport responsesElement = AuditReport.newBuilder().build();
    ListAuditReportsResponse expectedResponse =
        ListAuditReportsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAuditReports(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "organizations/organization-9365/locations/location-9365";

    ListAuditReportsPagedResponse pagedListResponse = client.listAuditReports(parent);

    List<AuditReport> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAuditReportsList().get(0), resources.get(0));

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
  public void listAuditReportsExceptionTest3() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "organizations/organization-9365/locations/location-9365";
      client.listAuditReports(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAuditReportTest() throws Exception {
    AuditReport expectedResponse =
        AuditReport.newBuilder()
            .setName(
                AuditReportName.ofFolderLocationAuditReportName(
                        "[FOLDER]", "[LOCATION]", "[AUDIT_REPORT]")
                    .toString())
            .setReportSummary(ReportSummary.newBuilder().build())
            .setOperationId("operationId129704162")
            .setDestinationDetails(DestinationDetails.newBuilder().build())
            .setComplianceStandard("complianceStandard-1534269448")
            .setScope("scope109264468")
            .setCreateTime(Timestamp.newBuilder().build())
            .addAllControlDetails(new ArrayList<ControlDetails>())
            .setComplianceFramework("complianceFramework-1808314333")
            .setScopeId("scopeId1923941007")
            .build();
    mockService.addResponse(expectedResponse);

    AuditReportName name =
        AuditReportName.ofFolderLocationAuditReportName("[FOLDER]", "[LOCATION]", "[AUDIT_REPORT]");

    AuditReport actualResponse = client.getAuditReport(name);
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
  public void getAuditReportExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AuditReportName name =
          AuditReportName.ofFolderLocationAuditReportName(
              "[FOLDER]", "[LOCATION]", "[AUDIT_REPORT]");
      client.getAuditReport(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAuditReportTest2() throws Exception {
    AuditReport expectedResponse =
        AuditReport.newBuilder()
            .setName(
                AuditReportName.ofFolderLocationAuditReportName(
                        "[FOLDER]", "[LOCATION]", "[AUDIT_REPORT]")
                    .toString())
            .setReportSummary(ReportSummary.newBuilder().build())
            .setOperationId("operationId129704162")
            .setDestinationDetails(DestinationDetails.newBuilder().build())
            .setComplianceStandard("complianceStandard-1534269448")
            .setScope("scope109264468")
            .setCreateTime(Timestamp.newBuilder().build())
            .addAllControlDetails(new ArrayList<ControlDetails>())
            .setComplianceFramework("complianceFramework-1808314333")
            .setScopeId("scopeId1923941007")
            .build();
    mockService.addResponse(expectedResponse);

    String name = "folders/folder-6177/locations/location-6177/auditReports/auditReport-6177";

    AuditReport actualResponse = client.getAuditReport(name);
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
  public void getAuditReportExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "folders/folder-6177/locations/location-6177/auditReports/auditReport-6177";
      client.getAuditReport(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getResourceEnrollmentStatusTest() throws Exception {
    ResourceEnrollmentStatus expectedResponse =
        ResourceEnrollmentStatus.newBuilder()
            .setName(
                ResourceEnrollmentStatusName.ofProjectLocationResourceEnrollmentStatusName(
                        "[PROJECT]", "[LOCATION]", "[RESOURCE_ENROLLMENT_STATUS]")
                    .toString())
            .setEnrollment(Enrollment.newBuilder().build())
            .setEnrolled(true)
            .setDisplayName("displayName1714148973")
            .build();
    mockService.addResponse(expectedResponse);

    ResourceEnrollmentStatusName name =
        ResourceEnrollmentStatusName.ofProjectLocationResourceEnrollmentStatusName(
            "[PROJECT]", "[LOCATION]", "[RESOURCE_ENROLLMENT_STATUS]");

    ResourceEnrollmentStatus actualResponse = client.getResourceEnrollmentStatus(name);
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
  public void getResourceEnrollmentStatusExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ResourceEnrollmentStatusName name =
          ResourceEnrollmentStatusName.ofProjectLocationResourceEnrollmentStatusName(
              "[PROJECT]", "[LOCATION]", "[RESOURCE_ENROLLMENT_STATUS]");
      client.getResourceEnrollmentStatus(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getResourceEnrollmentStatusTest2() throws Exception {
    ResourceEnrollmentStatus expectedResponse =
        ResourceEnrollmentStatus.newBuilder()
            .setName(
                ResourceEnrollmentStatusName.ofProjectLocationResourceEnrollmentStatusName(
                        "[PROJECT]", "[LOCATION]", "[RESOURCE_ENROLLMENT_STATUS]")
                    .toString())
            .setEnrollment(Enrollment.newBuilder().build())
            .setEnrolled(true)
            .setDisplayName("displayName1714148973")
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-3150/locations/location-3150/resourceEnrollmentStatuses/resourceEnrollmentStatuse-3150";

    ResourceEnrollmentStatus actualResponse = client.getResourceEnrollmentStatus(name);
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
  public void getResourceEnrollmentStatusExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-3150/locations/location-3150/resourceEnrollmentStatuses/resourceEnrollmentStatuse-3150";
      client.getResourceEnrollmentStatus(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listResourceEnrollmentStatusesTest() throws Exception {
    ResourceEnrollmentStatus responsesElement = ResourceEnrollmentStatus.newBuilder().build();
    ListResourceEnrollmentStatusesResponse expectedResponse =
        ListResourceEnrollmentStatusesResponse.newBuilder()
            .setNextPageToken("")
            .addAllResourceEnrollmentStatuses(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    EnrollmentStatusScopeName parent =
        EnrollmentStatusScopeName.ofOrganizationLocationName("[ORGANIZATION]", "[LOCATION]");

    ListResourceEnrollmentStatusesPagedResponse pagedListResponse =
        client.listResourceEnrollmentStatuses(parent);

    List<ResourceEnrollmentStatus> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getResourceEnrollmentStatusesList().get(0), resources.get(0));

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
  public void listResourceEnrollmentStatusesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      EnrollmentStatusScopeName parent =
          EnrollmentStatusScopeName.ofOrganizationLocationName("[ORGANIZATION]", "[LOCATION]");
      client.listResourceEnrollmentStatuses(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listResourceEnrollmentStatusesTest2() throws Exception {
    ResourceEnrollmentStatus responsesElement = ResourceEnrollmentStatus.newBuilder().build();
    ListResourceEnrollmentStatusesResponse expectedResponse =
        ListResourceEnrollmentStatusesResponse.newBuilder()
            .setNextPageToken("")
            .addAllResourceEnrollmentStatuses(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "organizations/organization-9365/locations/location-9365";

    ListResourceEnrollmentStatusesPagedResponse pagedListResponse =
        client.listResourceEnrollmentStatuses(parent);

    List<ResourceEnrollmentStatus> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getResourceEnrollmentStatusesList().get(0), resources.get(0));

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
  public void listResourceEnrollmentStatusesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "organizations/organization-9365/locations/location-9365";
      client.listResourceEnrollmentStatuses(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listControlsTest() throws Exception {
    Control responsesElement = Control.newBuilder().build();
    ListControlsResponse expectedResponse =
        ListControlsResponse.newBuilder()
            .setNextPageToken("")
            .addAllControls(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    StandardName parent =
        StandardName.ofOrganizationLocationStandardName(
            "[ORGANIZATION]", "[LOCATION]", "[STANDARD]");

    ListControlsPagedResponse pagedListResponse = client.listControls(parent);

    List<Control> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getControlsList().get(0), resources.get(0));

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
  public void listControlsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      StandardName parent =
          StandardName.ofOrganizationLocationStandardName(
              "[ORGANIZATION]", "[LOCATION]", "[STANDARD]");
      client.listControls(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listControlsTest2() throws Exception {
    Control responsesElement = Control.newBuilder().build();
    ListControlsResponse expectedResponse =
        ListControlsResponse.newBuilder()
            .setNextPageToken("")
            .addAllControls(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent =
        "organizations/organization-4531/locations/location-4531/standards/standard-4531";

    ListControlsPagedResponse pagedListResponse = client.listControls(parent);

    List<Control> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getControlsList().get(0), resources.get(0));

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
  public void listControlsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "organizations/organization-4531/locations/location-4531/standards/standard-4531";
      client.listControls(parent);
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
}
