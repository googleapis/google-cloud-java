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

package com.google.cloud.cloudcontrolspartner.v1;

import static com.google.cloud.cloudcontrolspartner.v1.CloudControlsPartnerMonitoringClient.ListViolationsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.common.collect.Lists;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Timestamp;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.Arrays;
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
public class CloudControlsPartnerMonitoringClientTest {
  private static MockCloudControlsPartnerMonitoring mockCloudControlsPartnerMonitoring;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private CloudControlsPartnerMonitoringClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockCloudControlsPartnerMonitoring = new MockCloudControlsPartnerMonitoring();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockCloudControlsPartnerMonitoring));
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
    CloudControlsPartnerMonitoringSettings settings =
        CloudControlsPartnerMonitoringSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = CloudControlsPartnerMonitoringClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listViolationsTest() throws Exception {
    Violation responsesElement = Violation.newBuilder().build();
    ListViolationsResponse expectedResponse =
        ListViolationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllViolations(Arrays.asList(responsesElement))
            .build();
    mockCloudControlsPartnerMonitoring.addResponse(expectedResponse);

    WorkloadName parent =
        WorkloadName.of("[ORGANIZATION]", "[LOCATION]", "[CUSTOMER]", "[WORKLOAD]");

    ListViolationsPagedResponse pagedListResponse = client.listViolations(parent);

    List<Violation> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getViolationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCloudControlsPartnerMonitoring.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListViolationsRequest actualRequest = ((ListViolationsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listViolationsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudControlsPartnerMonitoring.addException(exception);

    try {
      WorkloadName parent =
          WorkloadName.of("[ORGANIZATION]", "[LOCATION]", "[CUSTOMER]", "[WORKLOAD]");
      client.listViolations(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listViolationsTest2() throws Exception {
    Violation responsesElement = Violation.newBuilder().build();
    ListViolationsResponse expectedResponse =
        ListViolationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllViolations(Arrays.asList(responsesElement))
            .build();
    mockCloudControlsPartnerMonitoring.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListViolationsPagedResponse pagedListResponse = client.listViolations(parent);

    List<Violation> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getViolationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCloudControlsPartnerMonitoring.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListViolationsRequest actualRequest = ((ListViolationsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listViolationsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudControlsPartnerMonitoring.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listViolations(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getViolationTest() throws Exception {
    Violation expectedResponse =
        Violation.newBuilder()
            .setName(
                ViolationName.of(
                        "[ORGANIZATION]", "[LOCATION]", "[CUSTOMER]", "[WORKLOAD]", "[VIOLATION]")
                    .toString())
            .setDescription("description-1724546052")
            .setBeginTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setResolveTime(Timestamp.newBuilder().build())
            .setCategory("category50511102")
            .setNonCompliantOrgPolicy("nonCompliantOrgPolicy-1928466552")
            .setFolderId(527488652)
            .setRemediation(Violation.Remediation.newBuilder().build())
            .build();
    mockCloudControlsPartnerMonitoring.addResponse(expectedResponse);

    ViolationName name =
        ViolationName.of("[ORGANIZATION]", "[LOCATION]", "[CUSTOMER]", "[WORKLOAD]", "[VIOLATION]");

    Violation actualResponse = client.getViolation(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudControlsPartnerMonitoring.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetViolationRequest actualRequest = ((GetViolationRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getViolationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudControlsPartnerMonitoring.addException(exception);

    try {
      ViolationName name =
          ViolationName.of(
              "[ORGANIZATION]", "[LOCATION]", "[CUSTOMER]", "[WORKLOAD]", "[VIOLATION]");
      client.getViolation(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getViolationTest2() throws Exception {
    Violation expectedResponse =
        Violation.newBuilder()
            .setName(
                ViolationName.of(
                        "[ORGANIZATION]", "[LOCATION]", "[CUSTOMER]", "[WORKLOAD]", "[VIOLATION]")
                    .toString())
            .setDescription("description-1724546052")
            .setBeginTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setResolveTime(Timestamp.newBuilder().build())
            .setCategory("category50511102")
            .setNonCompliantOrgPolicy("nonCompliantOrgPolicy-1928466552")
            .setFolderId(527488652)
            .setRemediation(Violation.Remediation.newBuilder().build())
            .build();
    mockCloudControlsPartnerMonitoring.addResponse(expectedResponse);

    String name = "name3373707";

    Violation actualResponse = client.getViolation(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudControlsPartnerMonitoring.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetViolationRequest actualRequest = ((GetViolationRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getViolationExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudControlsPartnerMonitoring.addException(exception);

    try {
      String name = "name3373707";
      client.getViolation(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
