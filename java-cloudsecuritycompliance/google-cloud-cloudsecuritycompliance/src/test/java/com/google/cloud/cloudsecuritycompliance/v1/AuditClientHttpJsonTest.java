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

package com.google.cloud.cloudsecuritycompliance.v1;

import static com.google.cloud.cloudsecuritycompliance.v1.AuditClient.ListFrameworkAuditsPagedResponse;
import static com.google.cloud.cloudsecuritycompliance.v1.AuditClient.ListLocationsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.cloudsecuritycompliance.v1.stub.HttpJsonAuditStub;
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
public class AuditClientHttpJsonTest {
  private static MockHttpService mockService;
  private static AuditClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonAuditStub.getMethodDescriptors(), AuditSettings.getDefaultEndpoint());
    AuditSettings settings =
        AuditSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                AuditSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = AuditClient.create(settings);
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
  public void generateFrameworkAuditScopeReportTest() throws Exception {
    GenerateFrameworkAuditScopeReportResponse expectedResponse =
        GenerateFrameworkAuditScopeReportResponse.newBuilder()
            .setName("name3373707")
            .setComplianceFramework("complianceFramework-1808314333")
            .build();
    mockService.addResponse(expectedResponse);

    String scope = "folders/folder-6714/locations/location-6714";
    GenerateFrameworkAuditScopeReportRequest.Format reportFormat =
        GenerateFrameworkAuditScopeReportRequest.Format.forNumber(0);
    String complianceFramework = "complianceFramework-1808314333";

    GenerateFrameworkAuditScopeReportResponse actualResponse =
        client.generateFrameworkAuditScopeReport(scope, reportFormat, complianceFramework);
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
  public void generateFrameworkAuditScopeReportExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String scope = "folders/folder-6714/locations/location-6714";
      GenerateFrameworkAuditScopeReportRequest.Format reportFormat =
          GenerateFrameworkAuditScopeReportRequest.Format.forNumber(0);
      String complianceFramework = "complianceFramework-1808314333";
      client.generateFrameworkAuditScopeReport(scope, reportFormat, complianceFramework);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createFrameworkAuditTest() throws Exception {
    FrameworkAudit expectedResponse =
        FrameworkAudit.newBuilder()
            .setName(
                FrameworkAuditName.ofProjectLocationFrameworkAuditName(
                        "[PROJECT]", "[LOCATION]", "[FRAMEWORK_AUDIT]")
                    .toString())
            .setFrameworkAuditId("frameworkAuditId-548788616")
            .setComplianceFramework("complianceFramework-1808314333")
            .setScope("scope109264468")
            .setFrameworkAuditDestination(FrameworkAuditDestination.newBuilder().build())
            .setStartTime(Timestamp.newBuilder().build())
            .setFinishTime(Timestamp.newBuilder().build())
            .setComplianceState(ComplianceState.forNumber(0))
            .setReportSummary(ReportSummary.newBuilder().build())
            .addAllCloudControlGroupAuditDetails(new ArrayList<CloudControlGroupAuditDetails>())
            .addAllCloudControlAuditDetails(new ArrayList<CloudControlAuditDetails>())
            .setOperationId("operationId129704162")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createFrameworkAuditTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    FrameworkAudit frameworkAudit = FrameworkAudit.newBuilder().build();
    String frameworkAuditId = "frameworkAuditId-548788616";

    FrameworkAudit actualResponse =
        client.createFrameworkAuditAsync(parent, frameworkAudit, frameworkAuditId).get();
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
  public void createFrameworkAuditExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      FrameworkAudit frameworkAudit = FrameworkAudit.newBuilder().build();
      String frameworkAuditId = "frameworkAuditId-548788616";
      client.createFrameworkAuditAsync(parent, frameworkAudit, frameworkAuditId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createFrameworkAuditTest2() throws Exception {
    FrameworkAudit expectedResponse =
        FrameworkAudit.newBuilder()
            .setName(
                FrameworkAuditName.ofProjectLocationFrameworkAuditName(
                        "[PROJECT]", "[LOCATION]", "[FRAMEWORK_AUDIT]")
                    .toString())
            .setFrameworkAuditId("frameworkAuditId-548788616")
            .setComplianceFramework("complianceFramework-1808314333")
            .setScope("scope109264468")
            .setFrameworkAuditDestination(FrameworkAuditDestination.newBuilder().build())
            .setStartTime(Timestamp.newBuilder().build())
            .setFinishTime(Timestamp.newBuilder().build())
            .setComplianceState(ComplianceState.forNumber(0))
            .setReportSummary(ReportSummary.newBuilder().build())
            .addAllCloudControlGroupAuditDetails(new ArrayList<CloudControlGroupAuditDetails>())
            .addAllCloudControlAuditDetails(new ArrayList<CloudControlAuditDetails>())
            .setOperationId("operationId129704162")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createFrameworkAuditTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
    FrameworkAudit frameworkAudit = FrameworkAudit.newBuilder().build();
    String frameworkAuditId = "frameworkAuditId-548788616";

    FrameworkAudit actualResponse =
        client.createFrameworkAuditAsync(parent, frameworkAudit, frameworkAuditId).get();
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
  public void createFrameworkAuditExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
      FrameworkAudit frameworkAudit = FrameworkAudit.newBuilder().build();
      String frameworkAuditId = "frameworkAuditId-548788616";
      client.createFrameworkAuditAsync(parent, frameworkAudit, frameworkAuditId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createFrameworkAuditTest3() throws Exception {
    FrameworkAudit expectedResponse =
        FrameworkAudit.newBuilder()
            .setName(
                FrameworkAuditName.ofProjectLocationFrameworkAuditName(
                        "[PROJECT]", "[LOCATION]", "[FRAMEWORK_AUDIT]")
                    .toString())
            .setFrameworkAuditId("frameworkAuditId-548788616")
            .setComplianceFramework("complianceFramework-1808314333")
            .setScope("scope109264468")
            .setFrameworkAuditDestination(FrameworkAuditDestination.newBuilder().build())
            .setStartTime(Timestamp.newBuilder().build())
            .setFinishTime(Timestamp.newBuilder().build())
            .setComplianceState(ComplianceState.forNumber(0))
            .setReportSummary(ReportSummary.newBuilder().build())
            .addAllCloudControlGroupAuditDetails(new ArrayList<CloudControlGroupAuditDetails>())
            .addAllCloudControlAuditDetails(new ArrayList<CloudControlAuditDetails>())
            .setOperationId("operationId129704162")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createFrameworkAuditTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "organizations/organization-9365/locations/location-9365";
    FrameworkAudit frameworkAudit = FrameworkAudit.newBuilder().build();
    String frameworkAuditId = "frameworkAuditId-548788616";

    FrameworkAudit actualResponse =
        client.createFrameworkAuditAsync(parent, frameworkAudit, frameworkAuditId).get();
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
  public void createFrameworkAuditExceptionTest3() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "organizations/organization-9365/locations/location-9365";
      FrameworkAudit frameworkAudit = FrameworkAudit.newBuilder().build();
      String frameworkAuditId = "frameworkAuditId-548788616";
      client.createFrameworkAuditAsync(parent, frameworkAudit, frameworkAuditId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void listFrameworkAuditsTest() throws Exception {
    FrameworkAudit responsesElement = FrameworkAudit.newBuilder().build();
    ListFrameworkAuditsResponse expectedResponse =
        ListFrameworkAuditsResponse.newBuilder()
            .setNextPageToken("")
            .addAllFrameworkAudits(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListFrameworkAuditsPagedResponse pagedListResponse = client.listFrameworkAudits(parent);

    List<FrameworkAudit> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getFrameworkAuditsList().get(0), resources.get(0));

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
  public void listFrameworkAuditsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listFrameworkAudits(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listFrameworkAuditsTest2() throws Exception {
    FrameworkAudit responsesElement = FrameworkAudit.newBuilder().build();
    ListFrameworkAuditsResponse expectedResponse =
        ListFrameworkAuditsResponse.newBuilder()
            .setNextPageToken("")
            .addAllFrameworkAudits(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");

    ListFrameworkAuditsPagedResponse pagedListResponse = client.listFrameworkAudits(parent);

    List<FrameworkAudit> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getFrameworkAuditsList().get(0), resources.get(0));

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
  public void listFrameworkAuditsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
      client.listFrameworkAudits(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listFrameworkAuditsTest3() throws Exception {
    FrameworkAudit responsesElement = FrameworkAudit.newBuilder().build();
    ListFrameworkAuditsResponse expectedResponse =
        ListFrameworkAuditsResponse.newBuilder()
            .setNextPageToken("")
            .addAllFrameworkAudits(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "organizations/organization-9365/locations/location-9365";

    ListFrameworkAuditsPagedResponse pagedListResponse = client.listFrameworkAudits(parent);

    List<FrameworkAudit> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getFrameworkAuditsList().get(0), resources.get(0));

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
  public void listFrameworkAuditsExceptionTest3() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "organizations/organization-9365/locations/location-9365";
      client.listFrameworkAudits(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getFrameworkAuditTest() throws Exception {
    FrameworkAudit expectedResponse =
        FrameworkAudit.newBuilder()
            .setName(
                FrameworkAuditName.ofOrganizationLocationFrameworkAuditName(
                        "[ORGANIZATION]", "[LOCATION]", "[FRAMEWORK_AUDIT]")
                    .toString())
            .setFrameworkAuditId("frameworkAuditId-548788616")
            .setComplianceFramework("complianceFramework-1808314333")
            .setScope("scope109264468")
            .setFrameworkAuditDestination(FrameworkAuditDestination.newBuilder().build())
            .setStartTime(Timestamp.newBuilder().build())
            .setFinishTime(Timestamp.newBuilder().build())
            .setComplianceState(ComplianceState.forNumber(0))
            .setReportSummary(ReportSummary.newBuilder().build())
            .addAllCloudControlGroupAuditDetails(new ArrayList<CloudControlGroupAuditDetails>())
            .addAllCloudControlAuditDetails(new ArrayList<CloudControlAuditDetails>())
            .setOperationId("operationId129704162")
            .build();
    mockService.addResponse(expectedResponse);

    FrameworkAuditName name =
        FrameworkAuditName.ofOrganizationLocationFrameworkAuditName(
            "[ORGANIZATION]", "[LOCATION]", "[FRAMEWORK_AUDIT]");

    FrameworkAudit actualResponse = client.getFrameworkAudit(name);
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
  public void getFrameworkAuditExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      FrameworkAuditName name =
          FrameworkAuditName.ofOrganizationLocationFrameworkAuditName(
              "[ORGANIZATION]", "[LOCATION]", "[FRAMEWORK_AUDIT]");
      client.getFrameworkAudit(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getFrameworkAuditTest2() throws Exception {
    FrameworkAudit expectedResponse =
        FrameworkAudit.newBuilder()
            .setName(
                FrameworkAuditName.ofOrganizationLocationFrameworkAuditName(
                        "[ORGANIZATION]", "[LOCATION]", "[FRAMEWORK_AUDIT]")
                    .toString())
            .setFrameworkAuditId("frameworkAuditId-548788616")
            .setComplianceFramework("complianceFramework-1808314333")
            .setScope("scope109264468")
            .setFrameworkAuditDestination(FrameworkAuditDestination.newBuilder().build())
            .setStartTime(Timestamp.newBuilder().build())
            .setFinishTime(Timestamp.newBuilder().build())
            .setComplianceState(ComplianceState.forNumber(0))
            .setReportSummary(ReportSummary.newBuilder().build())
            .addAllCloudControlGroupAuditDetails(new ArrayList<CloudControlGroupAuditDetails>())
            .addAllCloudControlAuditDetails(new ArrayList<CloudControlAuditDetails>())
            .setOperationId("operationId129704162")
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "organizations/organization-7724/locations/location-7724/frameworkAudits/frameworkAudit-7724";

    FrameworkAudit actualResponse = client.getFrameworkAudit(name);
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
  public void getFrameworkAuditExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "organizations/organization-7724/locations/location-7724/frameworkAudits/frameworkAudit-7724";
      client.getFrameworkAudit(name);
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
            .setName("organizations/organization-1936")
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
              .setName("organizations/organization-1936")
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
            .setName("organizations/organization-7066/locations/location-7066")
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
              .setName("organizations/organization-7066/locations/location-7066")
              .build();
      client.getLocation(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
