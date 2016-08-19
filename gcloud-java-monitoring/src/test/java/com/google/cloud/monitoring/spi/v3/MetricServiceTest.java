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
import com.google.api.gax.core.PageAccessor;
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
import com.google.protobuf.GeneratedMessage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@javax.annotation.Generated("by GAPIC")
public class MetricServiceTest {
  private static MockServiceHelper serviceHelper;
  private MetricServiceApi api;

  @BeforeClass
  public static void startStaticServer() {
    MockMetricService mockService = new MockMetricService();
    serviceHelper = new MockServiceHelper("in-process-1", mockService);
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
    ListMonitoredResourceDescriptorsResponse expectedResponse =
        ListMonitoredResourceDescriptorsResponse.newBuilder().build();
    List<GeneratedMessage> expectedResponses = new ArrayList<>();
    expectedResponses.add(expectedResponse);
    serviceHelper.getService().setResponses(expectedResponses);

    String formattedName = MetricServiceApi.formatProjectName("[PROJECT]");
    String filter = "";
    PageAccessor<MonitoredResourceDescriptor> pageAccessor =
        api.listMonitoredResourceDescriptors(formattedName, filter);

    // PageAccessor will not make actual request until it is being used.
    // Add all the pages here in order to make grpc requests.
    List<MonitoredResourceDescriptor> resources = Lists.newArrayList(pageAccessor.getPageValues());
    Assert.assertEquals(0, resources.size());

    List<GeneratedMessage> actualRequests = serviceHelper.getService().getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListMonitoredResourceDescriptorsRequest actualRequest =
        (ListMonitoredResourceDescriptorsRequest) actualRequests.get(0);

    Assert.assertEquals(actualRequest.getName(), formattedName);
    Assert.assertEquals(actualRequest.getFilter(), filter);
  }

  @Test
  @SuppressWarnings("all")
  public void getMonitoredResourceDescriptorTest() {
    MonitoredResourceDescriptor expectedResponse = MonitoredResourceDescriptor.newBuilder().build();
    List<GeneratedMessage> expectedResponses = new ArrayList<>();
    expectedResponses.add(expectedResponse);
    serviceHelper.getService().setResponses(expectedResponses);

    String formattedName =
        MetricServiceApi.formatMonitoredResourceDescriptorName(
            "[PROJECT]", "[MONITORED_RESOURCE_DESCRIPTOR]");
    MonitoredResourceDescriptor actualResponse = api.getMonitoredResourceDescriptor(formattedName);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessage> actualRequests = serviceHelper.getService().getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetMonitoredResourceDescriptorRequest actualRequest =
        (GetMonitoredResourceDescriptorRequest) actualRequests.get(0);

    Assert.assertEquals(actualRequest.getName(), formattedName);
  }

  @Test
  @SuppressWarnings("all")
  public void listMetricDescriptorsTest() {
    ListMetricDescriptorsResponse expectedResponse =
        ListMetricDescriptorsResponse.newBuilder().build();
    List<GeneratedMessage> expectedResponses = new ArrayList<>();
    expectedResponses.add(expectedResponse);
    serviceHelper.getService().setResponses(expectedResponses);

    String formattedName = MetricServiceApi.formatProjectName("[PROJECT]");
    String filter = "";
    PageAccessor<MetricDescriptor> pageAccessor = api.listMetricDescriptors(formattedName, filter);

    // PageAccessor will not make actual request until it is being used.
    // Add all the pages here in order to make grpc requests.
    List<MetricDescriptor> resources = Lists.newArrayList(pageAccessor.getPageValues());
    Assert.assertEquals(0, resources.size());

    List<GeneratedMessage> actualRequests = serviceHelper.getService().getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListMetricDescriptorsRequest actualRequest =
        (ListMetricDescriptorsRequest) actualRequests.get(0);

    Assert.assertEquals(actualRequest.getName(), formattedName);
    Assert.assertEquals(actualRequest.getFilter(), filter);
  }

  @Test
  @SuppressWarnings("all")
  public void getMetricDescriptorTest() {
    MetricDescriptor expectedResponse = MetricDescriptor.newBuilder().build();
    List<GeneratedMessage> expectedResponses = new ArrayList<>();
    expectedResponses.add(expectedResponse);
    serviceHelper.getService().setResponses(expectedResponses);

    String formattedName =
        MetricServiceApi.formatMetricDescriptorPathName("[PROJECT]", "[METRIC_DESCRIPTOR_PATH]");
    MetricDescriptor actualResponse = api.getMetricDescriptor(formattedName);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessage> actualRequests = serviceHelper.getService().getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetMetricDescriptorRequest actualRequest = (GetMetricDescriptorRequest) actualRequests.get(0);

    Assert.assertEquals(actualRequest.getName(), formattedName);
  }

  @Test
  @SuppressWarnings("all")
  public void createMetricDescriptorTest() {
    MetricDescriptor expectedResponse = MetricDescriptor.newBuilder().build();
    List<GeneratedMessage> expectedResponses = new ArrayList<>();
    expectedResponses.add(expectedResponse);
    serviceHelper.getService().setResponses(expectedResponses);

    String formattedName = MetricServiceApi.formatProjectName("[PROJECT]");
    MetricDescriptor metricDescriptor = MetricDescriptor.newBuilder().build();
    MetricDescriptor actualResponse = api.createMetricDescriptor(formattedName, metricDescriptor);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessage> actualRequests = serviceHelper.getService().getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateMetricDescriptorRequest actualRequest =
        (CreateMetricDescriptorRequest) actualRequests.get(0);

    Assert.assertEquals(actualRequest.getName(), formattedName);
    Assert.assertEquals(actualRequest.getMetricDescriptor(), metricDescriptor);
  }

  @Test
  @SuppressWarnings("all")
  public void deleteMetricDescriptorTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    List<GeneratedMessage> expectedResponses = new ArrayList<>();
    expectedResponses.add(expectedResponse);
    serviceHelper.getService().setResponses(expectedResponses);

    String formattedName =
        MetricServiceApi.formatMetricDescriptorPathName("[PROJECT]", "[METRIC_DESCRIPTOR_PATH]");
    api.deleteMetricDescriptor(formattedName);

    List<GeneratedMessage> actualRequests = serviceHelper.getService().getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteMetricDescriptorRequest actualRequest =
        (DeleteMetricDescriptorRequest) actualRequests.get(0);

    Assert.assertEquals(actualRequest.getName(), formattedName);
  }

  @Test
  @SuppressWarnings("all")
  public void createTimeSeriesTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    List<GeneratedMessage> expectedResponses = new ArrayList<>();
    expectedResponses.add(expectedResponse);
    serviceHelper.getService().setResponses(expectedResponses);

    String formattedName = MetricServiceApi.formatProjectName("[PROJECT]");
    List<TimeSeries> timeSeries = new ArrayList<>();
    api.createTimeSeries(formattedName, timeSeries);

    List<GeneratedMessage> actualRequests = serviceHelper.getService().getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateTimeSeriesRequest actualRequest = (CreateTimeSeriesRequest) actualRequests.get(0);

    Assert.assertEquals(actualRequest.getName(), formattedName);
    Assert.assertEquals(actualRequest.getTimeSeriesList(), timeSeries);
  }
}
