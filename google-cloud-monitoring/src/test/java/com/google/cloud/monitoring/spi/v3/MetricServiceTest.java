/*
 * Copyright 2016 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.google.cloud.monitoring.spi.v3;

import com.google.api.MetricDescriptor;
import com.google.api.MonitoredResourceDescriptor;
import com.google.api.gax.core.PagedListResponse;
import com.google.api.gax.testing.MockGrpcService;
import com.google.api.gax.testing.MockServiceHelper;
import com.google.common.collect.Lists;
import com.google.monitoring.v3.CreateMetricDescriptorRequest;
import com.google.monitoring.v3.CreateTimeSeriesRequest;
import com.google.monitoring.v3.DeleteMetricDescriptorRequest;
import com.google.monitoring.v3.GetMetricDescriptorRequest;
import com.google.monitoring.v3.GetMonitoredResourceDescriptorRequest;
import com.google.monitoring.v3.ListMetricDescriptorsRequest;
import com.google.monitoring.v3.ListMetricDescriptorsResponse;
import com.google.monitoring.v3.ListMonitoredResourceDescriptorsRequest;
import com.google.monitoring.v3.ListMonitoredResourceDescriptorsResponse;
import com.google.monitoring.v3.TimeSeries;
import com.google.protobuf.Empty;
import com.google.protobuf.GeneratedMessageV3;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@javax.annotation.Generated("by GAPIC")
public class MetricServiceTest {
  private static MockGroupService mockGroupService;
  private static MockMetricService mockMetricService;
  private static MockAgentTranslationService mockAgentTranslationService;
  private static MockServiceHelper serviceHelper;
  private MetricServiceApi api;

  @BeforeClass
  public static void startStaticServer() {
    mockGroupService = new MockGroupService();
    mockMetricService = new MockMetricService();
    mockAgentTranslationService = new MockAgentTranslationService();
    serviceHelper =
        new MockServiceHelper(
            "in-process-1",
            Arrays.<MockGrpcService>asList(
                mockGroupService, mockMetricService, mockAgentTranslationService));
    serviceHelper.start();
  }

  @AfterClass
  public static void stopServer() {
    serviceHelper.stop();
  }

  @Before
  public void setUp() throws IOException {
    serviceHelper.reset();
    MetricServiceSettings settings =
        MetricServiceSettings.defaultBuilder()
            .provideChannelWith(serviceHelper.createChannel(), true)
            .build();
    api = MetricServiceApi.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    api.close();
  }

  @Test
  @SuppressWarnings("all")
  public void listMonitoredResourceDescriptorsTest() {
    String nextPageToken = "";
    MonitoredResourceDescriptor resourceDescriptorsElement =
        MonitoredResourceDescriptor.newBuilder().build();
    List<MonitoredResourceDescriptor> resourceDescriptors =
        Arrays.asList(resourceDescriptorsElement);
    ListMonitoredResourceDescriptorsResponse expectedResponse =
        ListMonitoredResourceDescriptorsResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllResourceDescriptors(resourceDescriptors)
            .build();
    List<GeneratedMessageV3> expectedResponses = new ArrayList<>();
    expectedResponses.add(expectedResponse);
    mockMetricService.setResponses(expectedResponses);

    String formattedName = MetricServiceApi.formatProjectName("[PROJECT]");
    String filter = "filter-1274492040";

    PagedListResponse<
            ListMonitoredResourceDescriptorsRequest, ListMonitoredResourceDescriptorsResponse,
            MonitoredResourceDescriptor>
        pagedListResponse = api.listMonitoredResourceDescriptors(formattedName, filter);

    List<MonitoredResourceDescriptor> resources =
        Lists.newArrayList(pagedListResponse.iterateAllElements());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getResourceDescriptorsList().get(0), resources.get(0));

    List<GeneratedMessageV3> actualRequests = mockMetricService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListMonitoredResourceDescriptorsRequest actualRequest =
        (ListMonitoredResourceDescriptorsRequest) actualRequests.get(0);

    Assert.assertEquals(formattedName, actualRequest.getName());
    Assert.assertEquals(filter, actualRequest.getFilter());
  }

  @Test
  @SuppressWarnings("all")
  public void getMonitoredResourceDescriptorTest() {
    String formattedName2 =
        MetricServiceApi.formatMonitoredResourceDescriptorName(
            "[PROJECT]", "[MONITORED_RESOURCE_DESCRIPTOR]");
    String type = "type3575610";
    String displayName = "displayName1615086568";
    String description = "description-1724546052";
    MonitoredResourceDescriptor expectedResponse =
        MonitoredResourceDescriptor.newBuilder()
            .setName(formattedName2)
            .setType(type)
            .setDisplayName(displayName)
            .setDescription(description)
            .build();
    List<GeneratedMessageV3> expectedResponses = new ArrayList<>();
    expectedResponses.add(expectedResponse);
    mockMetricService.setResponses(expectedResponses);

    String formattedName =
        MetricServiceApi.formatMonitoredResourceDescriptorName(
            "[PROJECT]", "[MONITORED_RESOURCE_DESCRIPTOR]");

    MonitoredResourceDescriptor actualResponse = api.getMonitoredResourceDescriptor(formattedName);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockMetricService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetMonitoredResourceDescriptorRequest actualRequest =
        (GetMonitoredResourceDescriptorRequest) actualRequests.get(0);

    Assert.assertEquals(formattedName, actualRequest.getName());
  }

  @Test
  @SuppressWarnings("all")
  public void listMetricDescriptorsTest() {
    String nextPageToken = "";
    MetricDescriptor metricDescriptorsElement = MetricDescriptor.newBuilder().build();
    List<MetricDescriptor> metricDescriptors = Arrays.asList(metricDescriptorsElement);
    ListMetricDescriptorsResponse expectedResponse =
        ListMetricDescriptorsResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllMetricDescriptors(metricDescriptors)
            .build();
    List<GeneratedMessageV3> expectedResponses = new ArrayList<>();
    expectedResponses.add(expectedResponse);
    mockMetricService.setResponses(expectedResponses);

    String formattedName = MetricServiceApi.formatProjectName("[PROJECT]");
    String filter = "filter-1274492040";

    PagedListResponse<ListMetricDescriptorsRequest, ListMetricDescriptorsResponse, MetricDescriptor>
        pagedListResponse = api.listMetricDescriptors(formattedName, filter);

    List<MetricDescriptor> resources = Lists.newArrayList(pagedListResponse.iterateAllElements());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMetricDescriptorsList().get(0), resources.get(0));

    List<GeneratedMessageV3> actualRequests = mockMetricService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListMetricDescriptorsRequest actualRequest =
        (ListMetricDescriptorsRequest) actualRequests.get(0);

    Assert.assertEquals(formattedName, actualRequest.getName());
    Assert.assertEquals(filter, actualRequest.getFilter());
  }

  @Test
  @SuppressWarnings("all")
  public void getMetricDescriptorTest() {
    String formattedName2 =
        MetricServiceApi.formatMetricDescriptorPathName("[PROJECT]", "[METRIC_DESCRIPTOR_PATH]");
    String type = "type3575610";
    String unit = "unit3594628";
    String description = "description-1724546052";
    String displayName = "displayName1615086568";
    MetricDescriptor expectedResponse =
        MetricDescriptor.newBuilder()
            .setName(formattedName2)
            .setType(type)
            .setUnit(unit)
            .setDescription(description)
            .setDisplayName(displayName)
            .build();
    List<GeneratedMessageV3> expectedResponses = new ArrayList<>();
    expectedResponses.add(expectedResponse);
    mockMetricService.setResponses(expectedResponses);

    String formattedName =
        MetricServiceApi.formatMetricDescriptorPathName("[PROJECT]", "[METRIC_DESCRIPTOR_PATH]");

    MetricDescriptor actualResponse = api.getMetricDescriptor(formattedName);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockMetricService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetMetricDescriptorRequest actualRequest = (GetMetricDescriptorRequest) actualRequests.get(0);

    Assert.assertEquals(formattedName, actualRequest.getName());
  }

  @Test
  @SuppressWarnings("all")
  public void createMetricDescriptorTest() {
    String formattedName2 = MetricServiceApi.formatProjectName("[PROJECT]");
    String type = "type3575610";
    String unit = "unit3594628";
    String description = "description-1724546052";
    String displayName = "displayName1615086568";
    MetricDescriptor expectedResponse =
        MetricDescriptor.newBuilder()
            .setName(formattedName2)
            .setType(type)
            .setUnit(unit)
            .setDescription(description)
            .setDisplayName(displayName)
            .build();
    List<GeneratedMessageV3> expectedResponses = new ArrayList<>();
    expectedResponses.add(expectedResponse);
    mockMetricService.setResponses(expectedResponses);

    String formattedName = MetricServiceApi.formatProjectName("[PROJECT]");
    MetricDescriptor metricDescriptor = MetricDescriptor.newBuilder().build();

    MetricDescriptor actualResponse = api.createMetricDescriptor(formattedName, metricDescriptor);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockMetricService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateMetricDescriptorRequest actualRequest =
        (CreateMetricDescriptorRequest) actualRequests.get(0);

    Assert.assertEquals(formattedName, actualRequest.getName());
    Assert.assertEquals(metricDescriptor, actualRequest.getMetricDescriptor());
  }

  @Test
  @SuppressWarnings("all")
  public void deleteMetricDescriptorTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    List<GeneratedMessageV3> expectedResponses = new ArrayList<>();
    expectedResponses.add(expectedResponse);
    mockMetricService.setResponses(expectedResponses);

    String formattedName =
        MetricServiceApi.formatMetricDescriptorPathName("[PROJECT]", "[METRIC_DESCRIPTOR_PATH]");

    api.deleteMetricDescriptor(formattedName);

    List<GeneratedMessageV3> actualRequests = mockMetricService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteMetricDescriptorRequest actualRequest =
        (DeleteMetricDescriptorRequest) actualRequests.get(0);

    Assert.assertEquals(formattedName, actualRequest.getName());
  }

  @Test
  @SuppressWarnings("all")
  public void createTimeSeriesTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    List<GeneratedMessageV3> expectedResponses = new ArrayList<>();
    expectedResponses.add(expectedResponse);
    mockMetricService.setResponses(expectedResponses);

    String formattedName = MetricServiceApi.formatProjectName("[PROJECT]");
    List<TimeSeries> timeSeries = new ArrayList<>();

    api.createTimeSeries(formattedName, timeSeries);

    List<GeneratedMessageV3> actualRequests = mockMetricService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateTimeSeriesRequest actualRequest = (CreateTimeSeriesRequest) actualRequests.get(0);

    Assert.assertEquals(formattedName, actualRequest.getName());
    Assert.assertEquals(timeSeries, actualRequest.getTimeSeriesList());
  }
}
