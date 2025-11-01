/*
 * Copyright 2025 Google LLC
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
public class AuditClientTest {
  private static MockAudit mockAudit;
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private AuditClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockAudit = new MockAudit();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockAudit, mockLocations));
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
    AuditSettings settings =
        AuditSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = AuditClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void generateFrameworkAuditScopeReportTest() throws Exception {
    GenerateFrameworkAuditScopeReportResponse expectedResponse =
        GenerateFrameworkAuditScopeReportResponse.newBuilder()
            .setName("name3373707")
            .setComplianceFramework("complianceFramework-1808314333")
            .build();
    mockAudit.addResponse(expectedResponse);

    String scope = "scope109264468";
    GenerateFrameworkAuditScopeReportRequest.Format reportFormat =
        GenerateFrameworkAuditScopeReportRequest.Format.forNumber(0);
    String complianceFramework = "complianceFramework-1808314333";

    GenerateFrameworkAuditScopeReportResponse actualResponse =
        client.generateFrameworkAuditScopeReport(scope, reportFormat, complianceFramework);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAudit.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GenerateFrameworkAuditScopeReportRequest actualRequest =
        ((GenerateFrameworkAuditScopeReportRequest) actualRequests.get(0));

    Assert.assertEquals(scope, actualRequest.getScope());
    Assert.assertEquals(reportFormat, actualRequest.getReportFormat());
    Assert.assertEquals(complianceFramework, actualRequest.getComplianceFramework());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void generateFrameworkAuditScopeReportExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAudit.addException(exception);

    try {
      String scope = "scope109264468";
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
    mockAudit.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    FrameworkAudit frameworkAudit = FrameworkAudit.newBuilder().build();
    String frameworkAuditId = "frameworkAuditId-548788616";

    FrameworkAudit actualResponse =
        client.createFrameworkAuditAsync(parent, frameworkAudit, frameworkAuditId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAudit.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateFrameworkAuditRequest actualRequest =
        ((CreateFrameworkAuditRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(frameworkAudit, actualRequest.getFrameworkAudit());
    Assert.assertEquals(frameworkAuditId, actualRequest.getFrameworkAuditId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createFrameworkAuditExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAudit.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      FrameworkAudit frameworkAudit = FrameworkAudit.newBuilder().build();
      String frameworkAuditId = "frameworkAuditId-548788616";
      client.createFrameworkAuditAsync(parent, frameworkAudit, frameworkAuditId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockAudit.addResponse(resultOperation);

    OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
    FrameworkAudit frameworkAudit = FrameworkAudit.newBuilder().build();
    String frameworkAuditId = "frameworkAuditId-548788616";

    FrameworkAudit actualResponse =
        client.createFrameworkAuditAsync(parent, frameworkAudit, frameworkAuditId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAudit.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateFrameworkAuditRequest actualRequest =
        ((CreateFrameworkAuditRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(frameworkAudit, actualRequest.getFrameworkAudit());
    Assert.assertEquals(frameworkAuditId, actualRequest.getFrameworkAuditId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createFrameworkAuditExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAudit.addException(exception);

    try {
      OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
      FrameworkAudit frameworkAudit = FrameworkAudit.newBuilder().build();
      String frameworkAuditId = "frameworkAuditId-548788616";
      client.createFrameworkAuditAsync(parent, frameworkAudit, frameworkAuditId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockAudit.addResponse(resultOperation);

    String parent = "parent-995424086";
    FrameworkAudit frameworkAudit = FrameworkAudit.newBuilder().build();
    String frameworkAuditId = "frameworkAuditId-548788616";

    FrameworkAudit actualResponse =
        client.createFrameworkAuditAsync(parent, frameworkAudit, frameworkAuditId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAudit.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateFrameworkAuditRequest actualRequest =
        ((CreateFrameworkAuditRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(frameworkAudit, actualRequest.getFrameworkAudit());
    Assert.assertEquals(frameworkAuditId, actualRequest.getFrameworkAuditId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createFrameworkAuditExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAudit.addException(exception);

    try {
      String parent = "parent-995424086";
      FrameworkAudit frameworkAudit = FrameworkAudit.newBuilder().build();
      String frameworkAuditId = "frameworkAuditId-548788616";
      client.createFrameworkAuditAsync(parent, frameworkAudit, frameworkAuditId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockAudit.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListFrameworkAuditsPagedResponse pagedListResponse = client.listFrameworkAudits(parent);

    List<FrameworkAudit> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getFrameworkAuditsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAudit.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListFrameworkAuditsRequest actualRequest = ((ListFrameworkAuditsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listFrameworkAuditsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAudit.addException(exception);

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
    mockAudit.addResponse(expectedResponse);

    OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");

    ListFrameworkAuditsPagedResponse pagedListResponse = client.listFrameworkAudits(parent);

    List<FrameworkAudit> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getFrameworkAuditsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAudit.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListFrameworkAuditsRequest actualRequest = ((ListFrameworkAuditsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listFrameworkAuditsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAudit.addException(exception);

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
    mockAudit.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListFrameworkAuditsPagedResponse pagedListResponse = client.listFrameworkAudits(parent);

    List<FrameworkAudit> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getFrameworkAuditsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAudit.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListFrameworkAuditsRequest actualRequest = ((ListFrameworkAuditsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listFrameworkAuditsExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAudit.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockAudit.addResponse(expectedResponse);

    FrameworkAuditName name =
        FrameworkAuditName.ofOrganizationLocationFrameworkAuditName(
            "[ORGANIZATION]", "[LOCATION]", "[FRAMEWORK_AUDIT]");

    FrameworkAudit actualResponse = client.getFrameworkAudit(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAudit.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetFrameworkAuditRequest actualRequest = ((GetFrameworkAuditRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getFrameworkAuditExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAudit.addException(exception);

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
    mockAudit.addResponse(expectedResponse);

    String name = "name3373707";

    FrameworkAudit actualResponse = client.getFrameworkAudit(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAudit.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetFrameworkAuditRequest actualRequest = ((GetFrameworkAuditRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getFrameworkAuditExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAudit.addException(exception);

    try {
      String name = "name3373707";
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
