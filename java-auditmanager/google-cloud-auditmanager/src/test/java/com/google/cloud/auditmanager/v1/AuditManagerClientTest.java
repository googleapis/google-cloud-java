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
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
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
public class AuditManagerClientTest {
  private static MockAuditManager mockAuditManager;
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private AuditManagerClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockAuditManager = new MockAuditManager();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockAuditManager, mockLocations));
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
    AuditManagerSettings settings =
        AuditManagerSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = AuditManagerClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void enrollResourceTest() throws Exception {
    Enrollment expectedResponse =
        Enrollment.newBuilder()
            .setName("name3373707")
            .addAllDestinationDetails(new ArrayList<DestinationDetails>())
            .build();
    mockAuditManager.addResponse(expectedResponse);

    String scope = "scope109264468";
    List<EnrollResourceRequest.EligibleDestination> destinations = new ArrayList<>();

    Enrollment actualResponse = client.enrollResource(scope, destinations);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAuditManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    EnrollResourceRequest actualRequest = ((EnrollResourceRequest) actualRequests.get(0));

    Assert.assertEquals(scope, actualRequest.getScope());
    Assert.assertEquals(destinations, actualRequest.getDestinationsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void enrollResourceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAuditManager.addException(exception);

    try {
      String scope = "scope109264468";
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
    mockAuditManager.addResponse(expectedResponse);

    String scope = "scope109264468";
    String complianceStandard = "complianceStandard-1534269448";
    GenerateAuditScopeReportRequest.AuditScopeReportFormat reportFormat =
        GenerateAuditScopeReportRequest.AuditScopeReportFormat.forNumber(0);

    AuditScopeReport actualResponse =
        client.generateAuditScopeReport(scope, complianceStandard, reportFormat);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAuditManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GenerateAuditScopeReportRequest actualRequest =
        ((GenerateAuditScopeReportRequest) actualRequests.get(0));

    Assert.assertEquals(scope, actualRequest.getScope());
    Assert.assertEquals(complianceStandard, actualRequest.getComplianceStandard());
    Assert.assertEquals(reportFormat, actualRequest.getReportFormat());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void generateAuditScopeReportExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAuditManager.addException(exception);

    try {
      String scope = "scope109264468";
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
    mockAuditManager.addResponse(resultOperation);

    String scope = "scope109264468";
    String gcsUri = "gcsUri-1251224875";
    String complianceStandard = "complianceStandard-1534269448";
    GenerateAuditReportRequest.AuditReportFormat reportFormat =
        GenerateAuditReportRequest.AuditReportFormat.forNumber(0);

    AuditReport actualResponse =
        client.generateAuditReportAsync(scope, gcsUri, complianceStandard, reportFormat).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAuditManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GenerateAuditReportRequest actualRequest = ((GenerateAuditReportRequest) actualRequests.get(0));

    Assert.assertEquals(scope, actualRequest.getScope());
    Assert.assertEquals(gcsUri, actualRequest.getGcsUri());
    Assert.assertEquals(complianceStandard, actualRequest.getComplianceStandard());
    Assert.assertEquals(reportFormat, actualRequest.getReportFormat());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void generateAuditReportExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAuditManager.addException(exception);

    try {
      String scope = "scope109264468";
      String gcsUri = "gcsUri-1251224875";
      String complianceStandard = "complianceStandard-1534269448";
      GenerateAuditReportRequest.AuditReportFormat reportFormat =
          GenerateAuditReportRequest.AuditReportFormat.forNumber(0);
      client.generateAuditReportAsync(scope, gcsUri, complianceStandard, reportFormat).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockAuditManager.addResponse(expectedResponse);

    EnrollmentStatusScopeName parent =
        EnrollmentStatusScopeName.ofOrganizationLocationName("[ORGANIZATION]", "[LOCATION]");

    ListAuditReportsPagedResponse pagedListResponse = client.listAuditReports(parent);

    List<AuditReport> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAuditReportsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAuditManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAuditReportsRequest actualRequest = ((ListAuditReportsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAuditReportsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAuditManager.addException(exception);

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
    mockAuditManager.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListAuditReportsPagedResponse pagedListResponse = client.listAuditReports(parent);

    List<AuditReport> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAuditReportsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAuditManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAuditReportsRequest actualRequest = ((ListAuditReportsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAuditReportsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAuditManager.addException(exception);

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
    mockAuditManager.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListAuditReportsPagedResponse pagedListResponse = client.listAuditReports(parent);

    List<AuditReport> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAuditReportsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAuditManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAuditReportsRequest actualRequest = ((ListAuditReportsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAuditReportsExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAuditManager.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockAuditManager.addResponse(expectedResponse);

    AuditReportName name =
        AuditReportName.ofFolderLocationAuditReportName("[FOLDER]", "[LOCATION]", "[AUDIT_REPORT]");

    AuditReport actualResponse = client.getAuditReport(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAuditManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAuditReportRequest actualRequest = ((GetAuditReportRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAuditReportExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAuditManager.addException(exception);

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
    mockAuditManager.addResponse(expectedResponse);

    String name = "name3373707";

    AuditReport actualResponse = client.getAuditReport(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAuditManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAuditReportRequest actualRequest = ((GetAuditReportRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAuditReportExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAuditManager.addException(exception);

    try {
      String name = "name3373707";
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
    mockAuditManager.addResponse(expectedResponse);

    ResourceEnrollmentStatusName name =
        ResourceEnrollmentStatusName.ofProjectLocationResourceEnrollmentStatusName(
            "[PROJECT]", "[LOCATION]", "[RESOURCE_ENROLLMENT_STATUS]");

    ResourceEnrollmentStatus actualResponse = client.getResourceEnrollmentStatus(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAuditManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetResourceEnrollmentStatusRequest actualRequest =
        ((GetResourceEnrollmentStatusRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getResourceEnrollmentStatusExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAuditManager.addException(exception);

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
    mockAuditManager.addResponse(expectedResponse);

    String name = "name3373707";

    ResourceEnrollmentStatus actualResponse = client.getResourceEnrollmentStatus(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAuditManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetResourceEnrollmentStatusRequest actualRequest =
        ((GetResourceEnrollmentStatusRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getResourceEnrollmentStatusExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAuditManager.addException(exception);

    try {
      String name = "name3373707";
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
    mockAuditManager.addResponse(expectedResponse);

    EnrollmentStatusScopeName parent =
        EnrollmentStatusScopeName.ofOrganizationLocationName("[ORGANIZATION]", "[LOCATION]");

    ListResourceEnrollmentStatusesPagedResponse pagedListResponse =
        client.listResourceEnrollmentStatuses(parent);

    List<ResourceEnrollmentStatus> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getResourceEnrollmentStatusesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAuditManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListResourceEnrollmentStatusesRequest actualRequest =
        ((ListResourceEnrollmentStatusesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listResourceEnrollmentStatusesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAuditManager.addException(exception);

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
    mockAuditManager.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListResourceEnrollmentStatusesPagedResponse pagedListResponse =
        client.listResourceEnrollmentStatuses(parent);

    List<ResourceEnrollmentStatus> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getResourceEnrollmentStatusesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAuditManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListResourceEnrollmentStatusesRequest actualRequest =
        ((ListResourceEnrollmentStatusesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listResourceEnrollmentStatusesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAuditManager.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockAuditManager.addResponse(expectedResponse);

    StandardName parent =
        StandardName.ofOrganizationLocationStandardName(
            "[ORGANIZATION]", "[LOCATION]", "[STANDARD]");

    ListControlsPagedResponse pagedListResponse = client.listControls(parent);

    List<Control> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getControlsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAuditManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListControlsRequest actualRequest = ((ListControlsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listControlsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAuditManager.addException(exception);

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
    mockAuditManager.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListControlsPagedResponse pagedListResponse = client.listControls(parent);

    List<Control> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getControlsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAuditManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListControlsRequest actualRequest = ((ListControlsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listControlsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAuditManager.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockLocations.addResponse(expectedResponse);

    ListLocationsRequest request =
        ListLocationsRequest.newBuilder()
            .setName("name3373707")
            .setFilter("filter-1274492040")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    ListLocationsPagedResponse pagedListResponse = client.listLocations(request);

    List<Location> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLocationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockLocations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListLocationsRequest actualRequest = ((ListLocationsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getFilter(), actualRequest.getFilter());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listLocationsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLocations.addException(exception);

    try {
      ListLocationsRequest request =
          ListLocationsRequest.newBuilder()
              .setName("name3373707")
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
    mockLocations.addResponse(expectedResponse);

    GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();

    Location actualResponse = client.getLocation(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLocations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetLocationRequest actualRequest = ((GetLocationRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getLocationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLocations.addException(exception);

    try {
      GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
      client.getLocation(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
