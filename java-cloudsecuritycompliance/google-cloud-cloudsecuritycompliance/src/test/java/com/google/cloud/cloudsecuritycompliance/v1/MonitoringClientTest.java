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

import static com.google.cloud.cloudsecuritycompliance.v1.MonitoringClient.ListControlComplianceSummariesPagedResponse;
import static com.google.cloud.cloudsecuritycompliance.v1.MonitoringClient.ListFindingSummariesPagedResponse;
import static com.google.cloud.cloudsecuritycompliance.v1.MonitoringClient.ListFrameworkComplianceSummariesPagedResponse;
import static com.google.cloud.cloudsecuritycompliance.v1.MonitoringClient.ListLocationsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.Lists;
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
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class MonitoringClientTest {
  private static MockLocations mockLocations;
  private static MockMonitoring mockMonitoring;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private MonitoringClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockMonitoring = new MockMonitoring();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockMonitoring, mockLocations));
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
    MonitoringSettings settings =
        MonitoringSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = MonitoringClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listFrameworkComplianceSummariesTest() throws Exception {
    FrameworkComplianceSummary responsesElement = FrameworkComplianceSummary.newBuilder().build();
    ListFrameworkComplianceSummariesResponse expectedResponse =
        ListFrameworkComplianceSummariesResponse.newBuilder()
            .setNextPageToken("")
            .addAllFrameworkComplianceSummaries(Arrays.asList(responsesElement))
            .build();
    mockMonitoring.addResponse(expectedResponse);

    FolderLocationName parent = FolderLocationName.of("[FOLDER]", "[LOCATION]");

    ListFrameworkComplianceSummariesPagedResponse pagedListResponse =
        client.listFrameworkComplianceSummaries(parent);

    List<FrameworkComplianceSummary> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getFrameworkComplianceSummariesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockMonitoring.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListFrameworkComplianceSummariesRequest actualRequest =
        ((ListFrameworkComplianceSummariesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listFrameworkComplianceSummariesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMonitoring.addException(exception);

    try {
      FolderLocationName parent = FolderLocationName.of("[FOLDER]", "[LOCATION]");
      client.listFrameworkComplianceSummaries(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listFrameworkComplianceSummariesTest2() throws Exception {
    FrameworkComplianceSummary responsesElement = FrameworkComplianceSummary.newBuilder().build();
    ListFrameworkComplianceSummariesResponse expectedResponse =
        ListFrameworkComplianceSummariesResponse.newBuilder()
            .setNextPageToken("")
            .addAllFrameworkComplianceSummaries(Arrays.asList(responsesElement))
            .build();
    mockMonitoring.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListFrameworkComplianceSummariesPagedResponse pagedListResponse =
        client.listFrameworkComplianceSummaries(parent);

    List<FrameworkComplianceSummary> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getFrameworkComplianceSummariesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockMonitoring.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListFrameworkComplianceSummariesRequest actualRequest =
        ((ListFrameworkComplianceSummariesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listFrameworkComplianceSummariesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMonitoring.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listFrameworkComplianceSummaries(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listFrameworkComplianceSummariesTest3() throws Exception {
    FrameworkComplianceSummary responsesElement = FrameworkComplianceSummary.newBuilder().build();
    ListFrameworkComplianceSummariesResponse expectedResponse =
        ListFrameworkComplianceSummariesResponse.newBuilder()
            .setNextPageToken("")
            .addAllFrameworkComplianceSummaries(Arrays.asList(responsesElement))
            .build();
    mockMonitoring.addResponse(expectedResponse);

    OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");

    ListFrameworkComplianceSummariesPagedResponse pagedListResponse =
        client.listFrameworkComplianceSummaries(parent);

    List<FrameworkComplianceSummary> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getFrameworkComplianceSummariesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockMonitoring.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListFrameworkComplianceSummariesRequest actualRequest =
        ((ListFrameworkComplianceSummariesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listFrameworkComplianceSummariesExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMonitoring.addException(exception);

    try {
      OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
      client.listFrameworkComplianceSummaries(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listFrameworkComplianceSummariesTest4() throws Exception {
    FrameworkComplianceSummary responsesElement = FrameworkComplianceSummary.newBuilder().build();
    ListFrameworkComplianceSummariesResponse expectedResponse =
        ListFrameworkComplianceSummariesResponse.newBuilder()
            .setNextPageToken("")
            .addAllFrameworkComplianceSummaries(Arrays.asList(responsesElement))
            .build();
    mockMonitoring.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListFrameworkComplianceSummariesPagedResponse pagedListResponse =
        client.listFrameworkComplianceSummaries(parent);

    List<FrameworkComplianceSummary> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getFrameworkComplianceSummariesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockMonitoring.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListFrameworkComplianceSummariesRequest actualRequest =
        ((ListFrameworkComplianceSummariesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listFrameworkComplianceSummariesExceptionTest4() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMonitoring.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listFrameworkComplianceSummaries(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listFindingSummariesTest() throws Exception {
    FindingSummary responsesElement = FindingSummary.newBuilder().build();
    ListFindingSummariesResponse expectedResponse =
        ListFindingSummariesResponse.newBuilder()
            .setNextPageToken("")
            .addAllFindingSummaries(Arrays.asList(responsesElement))
            .build();
    mockMonitoring.addResponse(expectedResponse);

    FolderLocationName parent = FolderLocationName.of("[FOLDER]", "[LOCATION]");

    ListFindingSummariesPagedResponse pagedListResponse = client.listFindingSummaries(parent);

    List<FindingSummary> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getFindingSummariesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockMonitoring.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListFindingSummariesRequest actualRequest =
        ((ListFindingSummariesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listFindingSummariesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMonitoring.addException(exception);

    try {
      FolderLocationName parent = FolderLocationName.of("[FOLDER]", "[LOCATION]");
      client.listFindingSummaries(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listFindingSummariesTest2() throws Exception {
    FindingSummary responsesElement = FindingSummary.newBuilder().build();
    ListFindingSummariesResponse expectedResponse =
        ListFindingSummariesResponse.newBuilder()
            .setNextPageToken("")
            .addAllFindingSummaries(Arrays.asList(responsesElement))
            .build();
    mockMonitoring.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListFindingSummariesPagedResponse pagedListResponse = client.listFindingSummaries(parent);

    List<FindingSummary> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getFindingSummariesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockMonitoring.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListFindingSummariesRequest actualRequest =
        ((ListFindingSummariesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listFindingSummariesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMonitoring.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listFindingSummaries(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listFindingSummariesTest3() throws Exception {
    FindingSummary responsesElement = FindingSummary.newBuilder().build();
    ListFindingSummariesResponse expectedResponse =
        ListFindingSummariesResponse.newBuilder()
            .setNextPageToken("")
            .addAllFindingSummaries(Arrays.asList(responsesElement))
            .build();
    mockMonitoring.addResponse(expectedResponse);

    OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");

    ListFindingSummariesPagedResponse pagedListResponse = client.listFindingSummaries(parent);

    List<FindingSummary> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getFindingSummariesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockMonitoring.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListFindingSummariesRequest actualRequest =
        ((ListFindingSummariesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listFindingSummariesExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMonitoring.addException(exception);

    try {
      OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
      client.listFindingSummaries(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listFindingSummariesTest4() throws Exception {
    FindingSummary responsesElement = FindingSummary.newBuilder().build();
    ListFindingSummariesResponse expectedResponse =
        ListFindingSummariesResponse.newBuilder()
            .setNextPageToken("")
            .addAllFindingSummaries(Arrays.asList(responsesElement))
            .build();
    mockMonitoring.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListFindingSummariesPagedResponse pagedListResponse = client.listFindingSummaries(parent);

    List<FindingSummary> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getFindingSummariesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockMonitoring.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListFindingSummariesRequest actualRequest =
        ((ListFindingSummariesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listFindingSummariesExceptionTest4() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMonitoring.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listFindingSummaries(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void fetchFrameworkComplianceReportTest() throws Exception {
    FrameworkComplianceReport expectedResponse =
        FrameworkComplianceReport.newBuilder()
            .setFramework("framework546173438")
            .setFrameworkDescription("frameworkDescription-790450402")
            .setUpdateTime(Timestamp.newBuilder().build())
            .setControlAssessmentDetails(ControlAssessmentDetails.newBuilder().build())
            .addAllSupportedCloudProviders(new ArrayList<CloudProvider>())
            .addAllFrameworkCategories(new ArrayList<FrameworkCategory>())
            .setFrameworkDisplayName("frameworkDisplayName-1646722673")
            .setName(
                FrameworkComplianceReportName.ofOrganizationLocationFrameworkComplianceReportName(
                        "[ORGANIZATION]", "[LOCATION]", "[FRAMEWORK_COMPLIANCE_REPORT]")
                    .toString())
            .setMajorRevisionId(612576889)
            .setMinorRevisionId(-1736456587)
            .addAllTargetResourceDetails(new ArrayList<TargetResourceDetails>())
            .build();
    mockMonitoring.addResponse(expectedResponse);

    FrameworkComplianceReportName name =
        FrameworkComplianceReportName.ofOrganizationLocationFrameworkComplianceReportName(
            "[ORGANIZATION]", "[LOCATION]", "[FRAMEWORK_COMPLIANCE_REPORT]");

    FrameworkComplianceReport actualResponse = client.fetchFrameworkComplianceReport(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMonitoring.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    FetchFrameworkComplianceReportRequest actualRequest =
        ((FetchFrameworkComplianceReportRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void fetchFrameworkComplianceReportExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMonitoring.addException(exception);

    try {
      FrameworkComplianceReportName name =
          FrameworkComplianceReportName.ofOrganizationLocationFrameworkComplianceReportName(
              "[ORGANIZATION]", "[LOCATION]", "[FRAMEWORK_COMPLIANCE_REPORT]");
      client.fetchFrameworkComplianceReport(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void fetchFrameworkComplianceReportTest2() throws Exception {
    FrameworkComplianceReport expectedResponse =
        FrameworkComplianceReport.newBuilder()
            .setFramework("framework546173438")
            .setFrameworkDescription("frameworkDescription-790450402")
            .setUpdateTime(Timestamp.newBuilder().build())
            .setControlAssessmentDetails(ControlAssessmentDetails.newBuilder().build())
            .addAllSupportedCloudProviders(new ArrayList<CloudProvider>())
            .addAllFrameworkCategories(new ArrayList<FrameworkCategory>())
            .setFrameworkDisplayName("frameworkDisplayName-1646722673")
            .setName(
                FrameworkComplianceReportName.ofOrganizationLocationFrameworkComplianceReportName(
                        "[ORGANIZATION]", "[LOCATION]", "[FRAMEWORK_COMPLIANCE_REPORT]")
                    .toString())
            .setMajorRevisionId(612576889)
            .setMinorRevisionId(-1736456587)
            .addAllTargetResourceDetails(new ArrayList<TargetResourceDetails>())
            .build();
    mockMonitoring.addResponse(expectedResponse);

    String name = "name3373707";

    FrameworkComplianceReport actualResponse = client.fetchFrameworkComplianceReport(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMonitoring.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    FetchFrameworkComplianceReportRequest actualRequest =
        ((FetchFrameworkComplianceReportRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void fetchFrameworkComplianceReportExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMonitoring.addException(exception);

    try {
      String name = "name3373707";
      client.fetchFrameworkComplianceReport(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listControlComplianceSummariesTest() throws Exception {
    ControlComplianceSummary responsesElement = ControlComplianceSummary.newBuilder().build();
    ListControlComplianceSummariesResponse expectedResponse =
        ListControlComplianceSummariesResponse.newBuilder()
            .setNextPageToken("")
            .addAllControlComplianceSummaries(Arrays.asList(responsesElement))
            .build();
    mockMonitoring.addResponse(expectedResponse);

    FrameworkComplianceReportName parent =
        FrameworkComplianceReportName.ofOrganizationLocationFrameworkComplianceReportName(
            "[ORGANIZATION]", "[LOCATION]", "[FRAMEWORK_COMPLIANCE_REPORT]");

    ListControlComplianceSummariesPagedResponse pagedListResponse =
        client.listControlComplianceSummaries(parent);

    List<ControlComplianceSummary> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getControlComplianceSummariesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockMonitoring.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListControlComplianceSummariesRequest actualRequest =
        ((ListControlComplianceSummariesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listControlComplianceSummariesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMonitoring.addException(exception);

    try {
      FrameworkComplianceReportName parent =
          FrameworkComplianceReportName.ofOrganizationLocationFrameworkComplianceReportName(
              "[ORGANIZATION]", "[LOCATION]", "[FRAMEWORK_COMPLIANCE_REPORT]");
      client.listControlComplianceSummaries(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listControlComplianceSummariesTest2() throws Exception {
    ControlComplianceSummary responsesElement = ControlComplianceSummary.newBuilder().build();
    ListControlComplianceSummariesResponse expectedResponse =
        ListControlComplianceSummariesResponse.newBuilder()
            .setNextPageToken("")
            .addAllControlComplianceSummaries(Arrays.asList(responsesElement))
            .build();
    mockMonitoring.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListControlComplianceSummariesPagedResponse pagedListResponse =
        client.listControlComplianceSummaries(parent);

    List<ControlComplianceSummary> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getControlComplianceSummariesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockMonitoring.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListControlComplianceSummariesRequest actualRequest =
        ((ListControlComplianceSummariesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listControlComplianceSummariesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMonitoring.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listControlComplianceSummaries(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void aggregateFrameworkComplianceReportTest() throws Exception {
    AggregateFrameworkComplianceReportResponse expectedResponse =
        AggregateFrameworkComplianceReportResponse.newBuilder()
            .addAllAggregatedComplianceReports(new ArrayList<AggregatedComplianceReport>())
            .build();
    mockMonitoring.addResponse(expectedResponse);

    FrameworkComplianceReportName name =
        FrameworkComplianceReportName.ofOrganizationLocationFrameworkComplianceReportName(
            "[ORGANIZATION]", "[LOCATION]", "[FRAMEWORK_COMPLIANCE_REPORT]");

    AggregateFrameworkComplianceReportResponse actualResponse =
        client.aggregateFrameworkComplianceReport(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMonitoring.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    AggregateFrameworkComplianceReportRequest actualRequest =
        ((AggregateFrameworkComplianceReportRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void aggregateFrameworkComplianceReportExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMonitoring.addException(exception);

    try {
      FrameworkComplianceReportName name =
          FrameworkComplianceReportName.ofOrganizationLocationFrameworkComplianceReportName(
              "[ORGANIZATION]", "[LOCATION]", "[FRAMEWORK_COMPLIANCE_REPORT]");
      client.aggregateFrameworkComplianceReport(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void aggregateFrameworkComplianceReportTest2() throws Exception {
    AggregateFrameworkComplianceReportResponse expectedResponse =
        AggregateFrameworkComplianceReportResponse.newBuilder()
            .addAllAggregatedComplianceReports(new ArrayList<AggregatedComplianceReport>())
            .build();
    mockMonitoring.addResponse(expectedResponse);

    String name = "name3373707";

    AggregateFrameworkComplianceReportResponse actualResponse =
        client.aggregateFrameworkComplianceReport(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMonitoring.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    AggregateFrameworkComplianceReportRequest actualRequest =
        ((AggregateFrameworkComplianceReportRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void aggregateFrameworkComplianceReportExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMonitoring.addException(exception);

    try {
      String name = "name3373707";
      client.aggregateFrameworkComplianceReport(name);
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
