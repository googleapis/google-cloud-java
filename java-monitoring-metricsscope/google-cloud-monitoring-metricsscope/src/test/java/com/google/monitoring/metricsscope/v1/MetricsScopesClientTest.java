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

package com.google.monitoring.metricsscope.v1;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.protobuf.Timestamp;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
public class MetricsScopesClientTest {
  private static MockMetricsScopes mockMetricsScopes;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private MetricsScopesClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockMetricsScopes = new MockMetricsScopes();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockMetricsScopes));
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
    MetricsScopesSettings settings =
        MetricsScopesSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = MetricsScopesClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void getMetricsScopeTest() throws Exception {
    MetricsScope expectedResponse =
        MetricsScope.newBuilder()
            .setName(MetricsScopeName.of("[METRICS_SCOPE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllMonitoredProjects(new ArrayList<MonitoredProject>())
            .build();
    mockMetricsScopes.addResponse(expectedResponse);

    MetricsScopeName name = MetricsScopeName.of("[METRICS_SCOPE]");

    MetricsScope actualResponse = client.getMetricsScope(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMetricsScopes.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetMetricsScopeRequest actualRequest = ((GetMetricsScopeRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getMetricsScopeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetricsScopes.addException(exception);

    try {
      MetricsScopeName name = MetricsScopeName.of("[METRICS_SCOPE]");
      client.getMetricsScope(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getMetricsScopeTest2() throws Exception {
    MetricsScope expectedResponse =
        MetricsScope.newBuilder()
            .setName(MetricsScopeName.of("[METRICS_SCOPE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllMonitoredProjects(new ArrayList<MonitoredProject>())
            .build();
    mockMetricsScopes.addResponse(expectedResponse);

    String name = "name3373707";

    MetricsScope actualResponse = client.getMetricsScope(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMetricsScopes.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetMetricsScopeRequest actualRequest = ((GetMetricsScopeRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getMetricsScopeExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetricsScopes.addException(exception);

    try {
      String name = "name3373707";
      client.getMetricsScope(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listMetricsScopesByMonitoredProjectTest() throws Exception {
    ListMetricsScopesByMonitoredProjectResponse expectedResponse =
        ListMetricsScopesByMonitoredProjectResponse.newBuilder()
            .addAllMetricsScopes(new ArrayList<MetricsScope>())
            .build();
    mockMetricsScopes.addResponse(expectedResponse);

    ListMetricsScopesByMonitoredProjectRequest request =
        ListMetricsScopesByMonitoredProjectRequest.newBuilder()
            .setMonitoredResourceContainer("monitoredResourceContainer884669850")
            .build();

    ListMetricsScopesByMonitoredProjectResponse actualResponse =
        client.listMetricsScopesByMonitoredProject(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMetricsScopes.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListMetricsScopesByMonitoredProjectRequest actualRequest =
        ((ListMetricsScopesByMonitoredProjectRequest) actualRequests.get(0));

    Assert.assertEquals(
        request.getMonitoredResourceContainer(), actualRequest.getMonitoredResourceContainer());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listMetricsScopesByMonitoredProjectExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetricsScopes.addException(exception);

    try {
      ListMetricsScopesByMonitoredProjectRequest request =
          ListMetricsScopesByMonitoredProjectRequest.newBuilder()
              .setMonitoredResourceContainer("monitoredResourceContainer884669850")
              .build();
      client.listMetricsScopesByMonitoredProject(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createMonitoredProjectTest() throws Exception {
    MonitoredProject expectedResponse =
        MonitoredProject.newBuilder()
            .setName(MonitoredProjectName.of("[METRICS_SCOPE]", "[PROJECT]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createMonitoredProjectTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockMetricsScopes.addResponse(resultOperation);

    MetricsScopeName parent = MetricsScopeName.of("[METRICS_SCOPE]");
    MonitoredProject monitoredProject = MonitoredProject.newBuilder().build();

    MonitoredProject actualResponse =
        client.createMonitoredProjectAsync(parent, monitoredProject).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMetricsScopes.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateMonitoredProjectRequest actualRequest =
        ((CreateMonitoredProjectRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(monitoredProject, actualRequest.getMonitoredProject());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createMonitoredProjectExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetricsScopes.addException(exception);

    try {
      MetricsScopeName parent = MetricsScopeName.of("[METRICS_SCOPE]");
      MonitoredProject monitoredProject = MonitoredProject.newBuilder().build();
      client.createMonitoredProjectAsync(parent, monitoredProject).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createMonitoredProjectTest2() throws Exception {
    MonitoredProject expectedResponse =
        MonitoredProject.newBuilder()
            .setName(MonitoredProjectName.of("[METRICS_SCOPE]", "[PROJECT]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createMonitoredProjectTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockMetricsScopes.addResponse(resultOperation);

    String parent = "parent-995424086";
    MonitoredProject monitoredProject = MonitoredProject.newBuilder().build();

    MonitoredProject actualResponse =
        client.createMonitoredProjectAsync(parent, monitoredProject).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockMetricsScopes.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateMonitoredProjectRequest actualRequest =
        ((CreateMonitoredProjectRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(monitoredProject, actualRequest.getMonitoredProject());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createMonitoredProjectExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetricsScopes.addException(exception);

    try {
      String parent = "parent-995424086";
      MonitoredProject monitoredProject = MonitoredProject.newBuilder().build();
      client.createMonitoredProjectAsync(parent, monitoredProject).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteMonitoredProjectTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteMonitoredProjectTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockMetricsScopes.addResponse(resultOperation);

    MonitoredProjectName name = MonitoredProjectName.of("[METRICS_SCOPE]", "[PROJECT]");

    client.deleteMonitoredProjectAsync(name).get();

    List<AbstractMessage> actualRequests = mockMetricsScopes.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteMonitoredProjectRequest actualRequest =
        ((DeleteMonitoredProjectRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteMonitoredProjectExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetricsScopes.addException(exception);

    try {
      MonitoredProjectName name = MonitoredProjectName.of("[METRICS_SCOPE]", "[PROJECT]");
      client.deleteMonitoredProjectAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteMonitoredProjectTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteMonitoredProjectTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockMetricsScopes.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteMonitoredProjectAsync(name).get();

    List<AbstractMessage> actualRequests = mockMetricsScopes.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteMonitoredProjectRequest actualRequest =
        ((DeleteMonitoredProjectRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteMonitoredProjectExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMetricsScopes.addException(exception);

    try {
      String name = "name3373707";
      client.deleteMonitoredProjectAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }
}
