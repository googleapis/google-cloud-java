/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.monitoring.v3;

import static com.google.cloud.monitoring.v3.MetricServiceClient.ListMetricDescriptorsPagedResponse;
import static com.google.cloud.monitoring.v3.MetricServiceClient.ListMonitoredResourceDescriptorsPagedResponse;
import static com.google.cloud.monitoring.v3.MetricServiceClient.ListTimeSeriesPagedResponse;

import com.google.api.LabelDescriptor;
import com.google.api.MetricDescriptor;
import com.google.api.MonitoredResourceDescriptor;
import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.common.collect.Lists;
import com.google.monitoring.v3.CreateMetricDescriptorRequest;
import com.google.monitoring.v3.CreateTimeSeriesRequest;
import com.google.monitoring.v3.DeleteMetricDescriptorRequest;
import com.google.monitoring.v3.FolderName;
import com.google.monitoring.v3.GetMetricDescriptorRequest;
import com.google.monitoring.v3.GetMonitoredResourceDescriptorRequest;
import com.google.monitoring.v3.ListMetricDescriptorsRequest;
import com.google.monitoring.v3.ListMetricDescriptorsResponse;
import com.google.monitoring.v3.ListMonitoredResourceDescriptorsRequest;
import com.google.monitoring.v3.ListMonitoredResourceDescriptorsResponse;
import com.google.monitoring.v3.ListTimeSeriesRequest;
import com.google.monitoring.v3.ListTimeSeriesResponse;
import com.google.monitoring.v3.MetricDescriptorName;
import com.google.monitoring.v3.MonitoredResourceDescriptorName;
import com.google.monitoring.v3.OrganizationName;
import com.google.monitoring.v3.ProjectName;
import com.google.monitoring.v3.TimeInterval;
import com.google.monitoring.v3.TimeSeries;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Empty;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
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
public class MetricServiceClientTest {
  private static MockServiceHelper mockServiceHelper;
  private MetricServiceClient client;
  private static MockMetricService mockMetricService;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockMetricService = new MockMetricService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockMetricService));
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
    MetricServiceSettings settings =
        MetricServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = MetricServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listMonitoredResourceDescriptorsTest() throws Exception {
    MonitoredResourceDescriptor responsesElement = MonitoredResourceDescriptor.newBuilder().build();
    ListMonitoredResourceDescriptorsResponse expectedResponse =
        ListMonitoredResourceDescriptorsResponse.newBuilder()
            .setNextPageToken("")
            .addAllResourceDescriptors(Arrays.asList(responsesElement))
            .build();
    mockMetricService.addResponse(expectedResponse);

    FolderName name = FolderName.of("[FOLDER]");

    ListMonitoredResourceDescriptorsPagedResponse pagedListResponse =
        client.listMonitoredResourceDescriptors(name);

    List<MonitoredResourceDescriptor> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getResourceDescriptorsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockMetricService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListMonitoredResourceDescriptorsRequest actualRequest =
        ((ListMonitoredResourceDescriptorsRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listMonitoredResourceDescriptorsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetricService.addException(exception);

    try {
      FolderName name = FolderName.of("[FOLDER]");
      client.listMonitoredResourceDescriptors(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listMonitoredResourceDescriptorsTest2() throws Exception {
    MonitoredResourceDescriptor responsesElement = MonitoredResourceDescriptor.newBuilder().build();
    ListMonitoredResourceDescriptorsResponse expectedResponse =
        ListMonitoredResourceDescriptorsResponse.newBuilder()
            .setNextPageToken("")
            .addAllResourceDescriptors(Arrays.asList(responsesElement))
            .build();
    mockMetricService.addResponse(expectedResponse);

    OrganizationName name = OrganizationName.of("[ORGANIZATION]");

    ListMonitoredResourceDescriptorsPagedResponse pagedListResponse =
        client.listMonitoredResourceDescriptors(name);

    List<MonitoredResourceDescriptor> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getResourceDescriptorsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockMetricService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListMonitoredResourceDescriptorsRequest actualRequest =
        ((ListMonitoredResourceDescriptorsRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listMonitoredResourceDescriptorsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetricService.addException(exception);

    try {
      OrganizationName name = OrganizationName.of("[ORGANIZATION]");
      client.listMonitoredResourceDescriptors(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listMonitoredResourceDescriptorsTest3() throws Exception {
    MonitoredResourceDescriptor responsesElement = MonitoredResourceDescriptor.newBuilder().build();
    ListMonitoredResourceDescriptorsResponse expectedResponse =
        ListMonitoredResourceDescriptorsResponse.newBuilder()
            .setNextPageToken("")
            .addAllResourceDescriptors(Arrays.asList(responsesElement))
            .build();
    mockMetricService.addResponse(expectedResponse);

    ProjectName name = ProjectName.of("[PROJECT]");

    ListMonitoredResourceDescriptorsPagedResponse pagedListResponse =
        client.listMonitoredResourceDescriptors(name);

    List<MonitoredResourceDescriptor> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getResourceDescriptorsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockMetricService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListMonitoredResourceDescriptorsRequest actualRequest =
        ((ListMonitoredResourceDescriptorsRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listMonitoredResourceDescriptorsExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetricService.addException(exception);

    try {
      ProjectName name = ProjectName.of("[PROJECT]");
      client.listMonitoredResourceDescriptors(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listMonitoredResourceDescriptorsTest4() throws Exception {
    MonitoredResourceDescriptor responsesElement = MonitoredResourceDescriptor.newBuilder().build();
    ListMonitoredResourceDescriptorsResponse expectedResponse =
        ListMonitoredResourceDescriptorsResponse.newBuilder()
            .setNextPageToken("")
            .addAllResourceDescriptors(Arrays.asList(responsesElement))
            .build();
    mockMetricService.addResponse(expectedResponse);

    String name = "name3373707";

    ListMonitoredResourceDescriptorsPagedResponse pagedListResponse =
        client.listMonitoredResourceDescriptors(name);

    List<MonitoredResourceDescriptor> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getResourceDescriptorsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockMetricService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListMonitoredResourceDescriptorsRequest actualRequest =
        ((ListMonitoredResourceDescriptorsRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listMonitoredResourceDescriptorsExceptionTest4() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetricService.addException(exception);

    try {
      String name = "name3373707";
      client.listMonitoredResourceDescriptors(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getMonitoredResourceDescriptorTest() throws Exception {
    MonitoredResourceDescriptor expectedResponse =
        MonitoredResourceDescriptor.newBuilder()
            .setName("name3373707")
            .setType("type3575610")
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllLabels(new ArrayList<LabelDescriptor>())
            .build();
    mockMetricService.addResponse(expectedResponse);

    MonitoredResourceDescriptorName name =
        MonitoredResourceDescriptorName.ofProjectMonitoredResourceDescriptorName(
            "[PROJECT]", "[MONITORED_RESOURCE_DESCRIPTOR]");

    MonitoredResourceDescriptor actualResponse = client.getMonitoredResourceDescriptor(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMetricService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetMonitoredResourceDescriptorRequest actualRequest =
        ((GetMonitoredResourceDescriptorRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getMonitoredResourceDescriptorExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetricService.addException(exception);

    try {
      MonitoredResourceDescriptorName name =
          MonitoredResourceDescriptorName.ofProjectMonitoredResourceDescriptorName(
              "[PROJECT]", "[MONITORED_RESOURCE_DESCRIPTOR]");
      client.getMonitoredResourceDescriptor(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getMonitoredResourceDescriptorTest2() throws Exception {
    MonitoredResourceDescriptor expectedResponse =
        MonitoredResourceDescriptor.newBuilder()
            .setName("name3373707")
            .setType("type3575610")
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllLabels(new ArrayList<LabelDescriptor>())
            .build();
    mockMetricService.addResponse(expectedResponse);

    String name = "name3373707";

    MonitoredResourceDescriptor actualResponse = client.getMonitoredResourceDescriptor(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMetricService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetMonitoredResourceDescriptorRequest actualRequest =
        ((GetMonitoredResourceDescriptorRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getMonitoredResourceDescriptorExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetricService.addException(exception);

    try {
      String name = "name3373707";
      client.getMonitoredResourceDescriptor(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listMetricDescriptorsTest() throws Exception {
    MetricDescriptor responsesElement = MetricDescriptor.newBuilder().build();
    ListMetricDescriptorsResponse expectedResponse =
        ListMetricDescriptorsResponse.newBuilder()
            .setNextPageToken("")
            .addAllMetricDescriptors(Arrays.asList(responsesElement))
            .build();
    mockMetricService.addResponse(expectedResponse);

    FolderName name = FolderName.of("[FOLDER]");

    ListMetricDescriptorsPagedResponse pagedListResponse = client.listMetricDescriptors(name);

    List<MetricDescriptor> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMetricDescriptorsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockMetricService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListMetricDescriptorsRequest actualRequest =
        ((ListMetricDescriptorsRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listMetricDescriptorsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetricService.addException(exception);

    try {
      FolderName name = FolderName.of("[FOLDER]");
      client.listMetricDescriptors(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listMetricDescriptorsTest2() throws Exception {
    MetricDescriptor responsesElement = MetricDescriptor.newBuilder().build();
    ListMetricDescriptorsResponse expectedResponse =
        ListMetricDescriptorsResponse.newBuilder()
            .setNextPageToken("")
            .addAllMetricDescriptors(Arrays.asList(responsesElement))
            .build();
    mockMetricService.addResponse(expectedResponse);

    OrganizationName name = OrganizationName.of("[ORGANIZATION]");

    ListMetricDescriptorsPagedResponse pagedListResponse = client.listMetricDescriptors(name);

    List<MetricDescriptor> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMetricDescriptorsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockMetricService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListMetricDescriptorsRequest actualRequest =
        ((ListMetricDescriptorsRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listMetricDescriptorsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetricService.addException(exception);

    try {
      OrganizationName name = OrganizationName.of("[ORGANIZATION]");
      client.listMetricDescriptors(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listMetricDescriptorsTest3() throws Exception {
    MetricDescriptor responsesElement = MetricDescriptor.newBuilder().build();
    ListMetricDescriptorsResponse expectedResponse =
        ListMetricDescriptorsResponse.newBuilder()
            .setNextPageToken("")
            .addAllMetricDescriptors(Arrays.asList(responsesElement))
            .build();
    mockMetricService.addResponse(expectedResponse);

    ProjectName name = ProjectName.of("[PROJECT]");

    ListMetricDescriptorsPagedResponse pagedListResponse = client.listMetricDescriptors(name);

    List<MetricDescriptor> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMetricDescriptorsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockMetricService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListMetricDescriptorsRequest actualRequest =
        ((ListMetricDescriptorsRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listMetricDescriptorsExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetricService.addException(exception);

    try {
      ProjectName name = ProjectName.of("[PROJECT]");
      client.listMetricDescriptors(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listMetricDescriptorsTest4() throws Exception {
    MetricDescriptor responsesElement = MetricDescriptor.newBuilder().build();
    ListMetricDescriptorsResponse expectedResponse =
        ListMetricDescriptorsResponse.newBuilder()
            .setNextPageToken("")
            .addAllMetricDescriptors(Arrays.asList(responsesElement))
            .build();
    mockMetricService.addResponse(expectedResponse);

    String name = "name3373707";

    ListMetricDescriptorsPagedResponse pagedListResponse = client.listMetricDescriptors(name);

    List<MetricDescriptor> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMetricDescriptorsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockMetricService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListMetricDescriptorsRequest actualRequest =
        ((ListMetricDescriptorsRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listMetricDescriptorsExceptionTest4() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetricService.addException(exception);

    try {
      String name = "name3373707";
      client.listMetricDescriptors(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getMetricDescriptorTest() throws Exception {
    MetricDescriptor expectedResponse =
        MetricDescriptor.newBuilder()
            .setName("name3373707")
            .setType("type3575610")
            .addAllLabels(new ArrayList<LabelDescriptor>())
            .setUnit("unit3594628")
            .setDescription("description-1724546052")
            .setDisplayName("displayName1714148973")
            .addAllMonitoredResourceTypes(new ArrayList<String>())
            .build();
    mockMetricService.addResponse(expectedResponse);

    MetricDescriptorName name =
        MetricDescriptorName.ofProjectMetricDescriptorName("[PROJECT]", "[METRIC_DESCRIPTOR]");

    MetricDescriptor actualResponse = client.getMetricDescriptor(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMetricService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetMetricDescriptorRequest actualRequest = ((GetMetricDescriptorRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getMetricDescriptorExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetricService.addException(exception);

    try {
      MetricDescriptorName name =
          MetricDescriptorName.ofProjectMetricDescriptorName("[PROJECT]", "[METRIC_DESCRIPTOR]");
      client.getMetricDescriptor(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getMetricDescriptorTest2() throws Exception {
    MetricDescriptor expectedResponse =
        MetricDescriptor.newBuilder()
            .setName("name3373707")
            .setType("type3575610")
            .addAllLabels(new ArrayList<LabelDescriptor>())
            .setUnit("unit3594628")
            .setDescription("description-1724546052")
            .setDisplayName("displayName1714148973")
            .addAllMonitoredResourceTypes(new ArrayList<String>())
            .build();
    mockMetricService.addResponse(expectedResponse);

    String name = "name3373707";

    MetricDescriptor actualResponse = client.getMetricDescriptor(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMetricService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetMetricDescriptorRequest actualRequest = ((GetMetricDescriptorRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getMetricDescriptorExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetricService.addException(exception);

    try {
      String name = "name3373707";
      client.getMetricDescriptor(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createMetricDescriptorTest() throws Exception {
    MetricDescriptor expectedResponse =
        MetricDescriptor.newBuilder()
            .setName("name3373707")
            .setType("type3575610")
            .addAllLabels(new ArrayList<LabelDescriptor>())
            .setUnit("unit3594628")
            .setDescription("description-1724546052")
            .setDisplayName("displayName1714148973")
            .addAllMonitoredResourceTypes(new ArrayList<String>())
            .build();
    mockMetricService.addResponse(expectedResponse);

    FolderName name = FolderName.of("[FOLDER]");
    MetricDescriptor metricDescriptor = MetricDescriptor.newBuilder().build();

    MetricDescriptor actualResponse = client.createMetricDescriptor(name, metricDescriptor);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMetricService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateMetricDescriptorRequest actualRequest =
        ((CreateMetricDescriptorRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(metricDescriptor, actualRequest.getMetricDescriptor());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createMetricDescriptorExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetricService.addException(exception);

    try {
      FolderName name = FolderName.of("[FOLDER]");
      MetricDescriptor metricDescriptor = MetricDescriptor.newBuilder().build();
      client.createMetricDescriptor(name, metricDescriptor);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createMetricDescriptorTest2() throws Exception {
    MetricDescriptor expectedResponse =
        MetricDescriptor.newBuilder()
            .setName("name3373707")
            .setType("type3575610")
            .addAllLabels(new ArrayList<LabelDescriptor>())
            .setUnit("unit3594628")
            .setDescription("description-1724546052")
            .setDisplayName("displayName1714148973")
            .addAllMonitoredResourceTypes(new ArrayList<String>())
            .build();
    mockMetricService.addResponse(expectedResponse);

    OrganizationName name = OrganizationName.of("[ORGANIZATION]");
    MetricDescriptor metricDescriptor = MetricDescriptor.newBuilder().build();

    MetricDescriptor actualResponse = client.createMetricDescriptor(name, metricDescriptor);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMetricService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateMetricDescriptorRequest actualRequest =
        ((CreateMetricDescriptorRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(metricDescriptor, actualRequest.getMetricDescriptor());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createMetricDescriptorExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetricService.addException(exception);

    try {
      OrganizationName name = OrganizationName.of("[ORGANIZATION]");
      MetricDescriptor metricDescriptor = MetricDescriptor.newBuilder().build();
      client.createMetricDescriptor(name, metricDescriptor);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createMetricDescriptorTest3() throws Exception {
    MetricDescriptor expectedResponse =
        MetricDescriptor.newBuilder()
            .setName("name3373707")
            .setType("type3575610")
            .addAllLabels(new ArrayList<LabelDescriptor>())
            .setUnit("unit3594628")
            .setDescription("description-1724546052")
            .setDisplayName("displayName1714148973")
            .addAllMonitoredResourceTypes(new ArrayList<String>())
            .build();
    mockMetricService.addResponse(expectedResponse);

    ProjectName name = ProjectName.of("[PROJECT]");
    MetricDescriptor metricDescriptor = MetricDescriptor.newBuilder().build();

    MetricDescriptor actualResponse = client.createMetricDescriptor(name, metricDescriptor);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMetricService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateMetricDescriptorRequest actualRequest =
        ((CreateMetricDescriptorRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(metricDescriptor, actualRequest.getMetricDescriptor());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createMetricDescriptorExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetricService.addException(exception);

    try {
      ProjectName name = ProjectName.of("[PROJECT]");
      MetricDescriptor metricDescriptor = MetricDescriptor.newBuilder().build();
      client.createMetricDescriptor(name, metricDescriptor);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createMetricDescriptorTest4() throws Exception {
    MetricDescriptor expectedResponse =
        MetricDescriptor.newBuilder()
            .setName("name3373707")
            .setType("type3575610")
            .addAllLabels(new ArrayList<LabelDescriptor>())
            .setUnit("unit3594628")
            .setDescription("description-1724546052")
            .setDisplayName("displayName1714148973")
            .addAllMonitoredResourceTypes(new ArrayList<String>())
            .build();
    mockMetricService.addResponse(expectedResponse);

    String name = "name3373707";
    MetricDescriptor metricDescriptor = MetricDescriptor.newBuilder().build();

    MetricDescriptor actualResponse = client.createMetricDescriptor(name, metricDescriptor);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMetricService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateMetricDescriptorRequest actualRequest =
        ((CreateMetricDescriptorRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(metricDescriptor, actualRequest.getMetricDescriptor());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createMetricDescriptorExceptionTest4() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetricService.addException(exception);

    try {
      String name = "name3373707";
      MetricDescriptor metricDescriptor = MetricDescriptor.newBuilder().build();
      client.createMetricDescriptor(name, metricDescriptor);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteMetricDescriptorTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockMetricService.addResponse(expectedResponse);

    MetricDescriptorName name =
        MetricDescriptorName.ofProjectMetricDescriptorName("[PROJECT]", "[METRIC_DESCRIPTOR]");

    client.deleteMetricDescriptor(name);

    List<AbstractMessage> actualRequests = mockMetricService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteMetricDescriptorRequest actualRequest =
        ((DeleteMetricDescriptorRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteMetricDescriptorExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetricService.addException(exception);

    try {
      MetricDescriptorName name =
          MetricDescriptorName.ofProjectMetricDescriptorName("[PROJECT]", "[METRIC_DESCRIPTOR]");
      client.deleteMetricDescriptor(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteMetricDescriptorTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockMetricService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteMetricDescriptor(name);

    List<AbstractMessage> actualRequests = mockMetricService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteMetricDescriptorRequest actualRequest =
        ((DeleteMetricDescriptorRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteMetricDescriptorExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetricService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteMetricDescriptor(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listTimeSeriesTest() throws Exception {
    TimeSeries responsesElement = TimeSeries.newBuilder().build();
    ListTimeSeriesResponse expectedResponse =
        ListTimeSeriesResponse.newBuilder()
            .setNextPageToken("")
            .addAllTimeSeries(Arrays.asList(responsesElement))
            .build();
    mockMetricService.addResponse(expectedResponse);

    ProjectName name = ProjectName.of("[PROJECT]");
    String filter = "filter-1274492040";
    TimeInterval interval = TimeInterval.newBuilder().build();
    ListTimeSeriesRequest.TimeSeriesView view = ListTimeSeriesRequest.TimeSeriesView.forNumber(0);

    ListTimeSeriesPagedResponse pagedListResponse =
        client.listTimeSeries(name, filter, interval, view);

    List<TimeSeries> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTimeSeriesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockMetricService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListTimeSeriesRequest actualRequest = ((ListTimeSeriesRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(filter, actualRequest.getFilter());
    Assert.assertEquals(interval, actualRequest.getInterval());
    Assert.assertEquals(view, actualRequest.getView());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listTimeSeriesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetricService.addException(exception);

    try {
      ProjectName name = ProjectName.of("[PROJECT]");
      String filter = "filter-1274492040";
      TimeInterval interval = TimeInterval.newBuilder().build();
      ListTimeSeriesRequest.TimeSeriesView view = ListTimeSeriesRequest.TimeSeriesView.forNumber(0);
      client.listTimeSeries(name, filter, interval, view);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listTimeSeriesTest2() throws Exception {
    TimeSeries responsesElement = TimeSeries.newBuilder().build();
    ListTimeSeriesResponse expectedResponse =
        ListTimeSeriesResponse.newBuilder()
            .setNextPageToken("")
            .addAllTimeSeries(Arrays.asList(responsesElement))
            .build();
    mockMetricService.addResponse(expectedResponse);

    String name = "name3373707";
    String filter = "filter-1274492040";
    TimeInterval interval = TimeInterval.newBuilder().build();
    ListTimeSeriesRequest.TimeSeriesView view = ListTimeSeriesRequest.TimeSeriesView.forNumber(0);

    ListTimeSeriesPagedResponse pagedListResponse =
        client.listTimeSeries(name, filter, interval, view);

    List<TimeSeries> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTimeSeriesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockMetricService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListTimeSeriesRequest actualRequest = ((ListTimeSeriesRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(filter, actualRequest.getFilter());
    Assert.assertEquals(interval, actualRequest.getInterval());
    Assert.assertEquals(view, actualRequest.getView());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listTimeSeriesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetricService.addException(exception);

    try {
      String name = "name3373707";
      String filter = "filter-1274492040";
      TimeInterval interval = TimeInterval.newBuilder().build();
      ListTimeSeriesRequest.TimeSeriesView view = ListTimeSeriesRequest.TimeSeriesView.forNumber(0);
      client.listTimeSeries(name, filter, interval, view);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createTimeSeriesTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockMetricService.addResponse(expectedResponse);

    ProjectName name = ProjectName.of("[PROJECT]");
    List<TimeSeries> timeSeries = new ArrayList<>();

    client.createTimeSeries(name, timeSeries);

    List<AbstractMessage> actualRequests = mockMetricService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateTimeSeriesRequest actualRequest = ((CreateTimeSeriesRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(timeSeries, actualRequest.getTimeSeriesList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createTimeSeriesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetricService.addException(exception);

    try {
      ProjectName name = ProjectName.of("[PROJECT]");
      List<TimeSeries> timeSeries = new ArrayList<>();
      client.createTimeSeries(name, timeSeries);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createTimeSeriesTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockMetricService.addResponse(expectedResponse);

    String name = "name3373707";
    List<TimeSeries> timeSeries = new ArrayList<>();

    client.createTimeSeries(name, timeSeries);

    List<AbstractMessage> actualRequests = mockMetricService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateTimeSeriesRequest actualRequest = ((CreateTimeSeriesRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(timeSeries, actualRequest.getTimeSeriesList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createTimeSeriesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetricService.addException(exception);

    try {
      String name = "name3373707";
      List<TimeSeries> timeSeries = new ArrayList<>();
      client.createTimeSeries(name, timeSeries);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
