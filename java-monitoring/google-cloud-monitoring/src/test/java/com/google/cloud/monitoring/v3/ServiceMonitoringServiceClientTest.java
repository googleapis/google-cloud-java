/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.monitoring.v3;

import static com.google.cloud.monitoring.v3.ServiceMonitoringServiceClient.ListServiceLevelObjectivesPagedResponse;
import static com.google.cloud.monitoring.v3.ServiceMonitoringServiceClient.ListServicesPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.common.collect.Lists;
import com.google.monitoring.v3.CreateServiceLevelObjectiveRequest;
import com.google.monitoring.v3.CreateServiceRequest;
import com.google.monitoring.v3.DeleteServiceLevelObjectiveRequest;
import com.google.monitoring.v3.DeleteServiceRequest;
import com.google.monitoring.v3.GetServiceLevelObjectiveRequest;
import com.google.monitoring.v3.GetServiceRequest;
import com.google.monitoring.v3.ListServiceLevelObjectivesRequest;
import com.google.monitoring.v3.ListServiceLevelObjectivesResponse;
import com.google.monitoring.v3.ListServicesRequest;
import com.google.monitoring.v3.ListServicesResponse;
import com.google.monitoring.v3.ProjectName;
import com.google.monitoring.v3.Service;
import com.google.monitoring.v3.ServiceLevelObjective;
import com.google.monitoring.v3.ServiceLevelObjectiveName;
import com.google.monitoring.v3.ServiceName;
import com.google.monitoring.v3.UpdateServiceLevelObjectiveRequest;
import com.google.monitoring.v3.UpdateServiceRequest;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Empty;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@javax.annotation.Generated("by GAPIC")
public class ServiceMonitoringServiceClientTest {
  private static MockAlertPolicyService mockAlertPolicyService;
  private static MockGroupService mockGroupService;
  private static MockMetricService mockMetricService;
  private static MockNotificationChannelService mockNotificationChannelService;
  private static MockServiceMonitoringService mockServiceMonitoringService;
  private static MockUptimeCheckService mockUptimeCheckService;
  private static MockServiceHelper serviceHelper;
  private ServiceMonitoringServiceClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockAlertPolicyService = new MockAlertPolicyService();
    mockGroupService = new MockGroupService();
    mockMetricService = new MockMetricService();
    mockNotificationChannelService = new MockNotificationChannelService();
    mockServiceMonitoringService = new MockServiceMonitoringService();
    mockUptimeCheckService = new MockUptimeCheckService();
    serviceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(
                mockAlertPolicyService,
                mockGroupService,
                mockMetricService,
                mockNotificationChannelService,
                mockServiceMonitoringService,
                mockUptimeCheckService));
    serviceHelper.start();
  }

  @AfterClass
  public static void stopServer() {
    serviceHelper.stop();
  }

  @Before
  public void setUp() throws IOException {
    serviceHelper.reset();
    channelProvider = serviceHelper.createChannelProvider();
    ServiceMonitoringServiceSettings settings =
        ServiceMonitoringServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ServiceMonitoringServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void createServiceTest() {
    ServiceName name = ServiceName.of("[PROJECT]", "[SERVICE]");
    String displayName = "displayName1615086568";
    Service expectedResponse =
        Service.newBuilder().setName(name.toString()).setDisplayName(displayName).build();
    mockServiceMonitoringService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");
    Service service = Service.newBuilder().build();

    Service actualResponse = client.createService(parent, service);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockServiceMonitoringService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateServiceRequest actualRequest = (CreateServiceRequest) actualRequests.get(0);

    Assert.assertEquals(parent, ProjectName.parse(actualRequest.getParent()));
    Assert.assertEquals(service, actualRequest.getService());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createServiceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockServiceMonitoringService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      Service service = Service.newBuilder().build();

      client.createService(parent, service);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getServiceTest() {
    ServiceName name2 = ServiceName.of("[PROJECT]", "[SERVICE]");
    String displayName = "displayName1615086568";
    Service expectedResponse =
        Service.newBuilder().setName(name2.toString()).setDisplayName(displayName).build();
    mockServiceMonitoringService.addResponse(expectedResponse);

    ServiceName name = ServiceName.of("[PROJECT]", "[SERVICE]");

    Service actualResponse = client.getService(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockServiceMonitoringService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetServiceRequest actualRequest = (GetServiceRequest) actualRequests.get(0);

    Assert.assertEquals(name, ServiceName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getServiceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockServiceMonitoringService.addException(exception);

    try {
      ServiceName name = ServiceName.of("[PROJECT]", "[SERVICE]");

      client.getService(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listServicesTest() {
    String nextPageToken = "";
    Service servicesElement = Service.newBuilder().build();
    List<Service> services = Arrays.asList(servicesElement);
    ListServicesResponse expectedResponse =
        ListServicesResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllServices(services)
            .build();
    mockServiceMonitoringService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");

    ListServicesPagedResponse pagedListResponse = client.listServices(parent);

    List<Service> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getServicesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockServiceMonitoringService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListServicesRequest actualRequest = (ListServicesRequest) actualRequests.get(0);

    Assert.assertEquals(parent, ProjectName.parse(actualRequest.getParent()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listServicesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockServiceMonitoringService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");

      client.listServices(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateServiceTest() {
    ServiceName name = ServiceName.of("[PROJECT]", "[SERVICE]");
    String displayName = "displayName1615086568";
    Service expectedResponse =
        Service.newBuilder().setName(name.toString()).setDisplayName(displayName).build();
    mockServiceMonitoringService.addResponse(expectedResponse);

    Service service = Service.newBuilder().build();

    Service actualResponse = client.updateService(service);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockServiceMonitoringService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateServiceRequest actualRequest = (UpdateServiceRequest) actualRequests.get(0);

    Assert.assertEquals(service, actualRequest.getService());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void updateServiceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockServiceMonitoringService.addException(exception);

    try {
      Service service = Service.newBuilder().build();

      client.updateService(service);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deleteServiceTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    mockServiceMonitoringService.addResponse(expectedResponse);

    ServiceName name = ServiceName.of("[PROJECT]", "[SERVICE]");

    client.deleteService(name);

    List<AbstractMessage> actualRequests = mockServiceMonitoringService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteServiceRequest actualRequest = (DeleteServiceRequest) actualRequests.get(0);

    Assert.assertEquals(name, ServiceName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void deleteServiceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockServiceMonitoringService.addException(exception);

    try {
      ServiceName name = ServiceName.of("[PROJECT]", "[SERVICE]");

      client.deleteService(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createServiceLevelObjectiveTest() {
    ServiceLevelObjectiveName name =
        ServiceLevelObjectiveName.of("[PROJECT]", "[SERVICE]", "[SERVICE_LEVEL_OBJECTIVE]");
    String displayName = "displayName1615086568";
    double goal = 317825.0;
    ServiceLevelObjective expectedResponse =
        ServiceLevelObjective.newBuilder()
            .setName(name.toString())
            .setDisplayName(displayName)
            .setGoal(goal)
            .build();
    mockServiceMonitoringService.addResponse(expectedResponse);

    ServiceName parent = ServiceName.of("[PROJECT]", "[SERVICE]");
    ServiceLevelObjective serviceLevelObjective = ServiceLevelObjective.newBuilder().build();

    ServiceLevelObjective actualResponse =
        client.createServiceLevelObjective(parent, serviceLevelObjective);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockServiceMonitoringService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateServiceLevelObjectiveRequest actualRequest =
        (CreateServiceLevelObjectiveRequest) actualRequests.get(0);

    Assert.assertEquals(parent, ServiceName.parse(actualRequest.getParent()));
    Assert.assertEquals(serviceLevelObjective, actualRequest.getServiceLevelObjective());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createServiceLevelObjectiveExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockServiceMonitoringService.addException(exception);

    try {
      ServiceName parent = ServiceName.of("[PROJECT]", "[SERVICE]");
      ServiceLevelObjective serviceLevelObjective = ServiceLevelObjective.newBuilder().build();

      client.createServiceLevelObjective(parent, serviceLevelObjective);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getServiceLevelObjectiveTest() {
    ServiceLevelObjectiveName name2 =
        ServiceLevelObjectiveName.of("[PROJECT]", "[SERVICE]", "[SERVICE_LEVEL_OBJECTIVE]");
    String displayName = "displayName1615086568";
    double goal = 317825.0;
    ServiceLevelObjective expectedResponse =
        ServiceLevelObjective.newBuilder()
            .setName(name2.toString())
            .setDisplayName(displayName)
            .setGoal(goal)
            .build();
    mockServiceMonitoringService.addResponse(expectedResponse);

    ServiceLevelObjectiveName name =
        ServiceLevelObjectiveName.of("[PROJECT]", "[SERVICE]", "[SERVICE_LEVEL_OBJECTIVE]");

    ServiceLevelObjective actualResponse = client.getServiceLevelObjective(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockServiceMonitoringService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetServiceLevelObjectiveRequest actualRequest =
        (GetServiceLevelObjectiveRequest) actualRequests.get(0);

    Assert.assertEquals(name, ServiceLevelObjectiveName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getServiceLevelObjectiveExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockServiceMonitoringService.addException(exception);

    try {
      ServiceLevelObjectiveName name =
          ServiceLevelObjectiveName.of("[PROJECT]", "[SERVICE]", "[SERVICE_LEVEL_OBJECTIVE]");

      client.getServiceLevelObjective(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listServiceLevelObjectivesTest() {
    String nextPageToken = "";
    ServiceLevelObjective serviceLevelObjectivesElement =
        ServiceLevelObjective.newBuilder().build();
    List<ServiceLevelObjective> serviceLevelObjectives =
        Arrays.asList(serviceLevelObjectivesElement);
    ListServiceLevelObjectivesResponse expectedResponse =
        ListServiceLevelObjectivesResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllServiceLevelObjectives(serviceLevelObjectives)
            .build();
    mockServiceMonitoringService.addResponse(expectedResponse);

    ServiceName parent = ServiceName.of("[PROJECT]", "[SERVICE]");

    ListServiceLevelObjectivesPagedResponse pagedListResponse =
        client.listServiceLevelObjectives(parent);

    List<ServiceLevelObjective> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getServiceLevelObjectivesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockServiceMonitoringService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListServiceLevelObjectivesRequest actualRequest =
        (ListServiceLevelObjectivesRequest) actualRequests.get(0);

    Assert.assertEquals(parent, ServiceName.parse(actualRequest.getParent()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listServiceLevelObjectivesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockServiceMonitoringService.addException(exception);

    try {
      ServiceName parent = ServiceName.of("[PROJECT]", "[SERVICE]");

      client.listServiceLevelObjectives(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateServiceLevelObjectiveTest() {
    ServiceLevelObjectiveName name =
        ServiceLevelObjectiveName.of("[PROJECT]", "[SERVICE]", "[SERVICE_LEVEL_OBJECTIVE]");
    String displayName = "displayName1615086568";
    double goal = 317825.0;
    ServiceLevelObjective expectedResponse =
        ServiceLevelObjective.newBuilder()
            .setName(name.toString())
            .setDisplayName(displayName)
            .setGoal(goal)
            .build();
    mockServiceMonitoringService.addResponse(expectedResponse);

    ServiceLevelObjective serviceLevelObjective = ServiceLevelObjective.newBuilder().build();

    ServiceLevelObjective actualResponse =
        client.updateServiceLevelObjective(serviceLevelObjective);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockServiceMonitoringService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateServiceLevelObjectiveRequest actualRequest =
        (UpdateServiceLevelObjectiveRequest) actualRequests.get(0);

    Assert.assertEquals(serviceLevelObjective, actualRequest.getServiceLevelObjective());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void updateServiceLevelObjectiveExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockServiceMonitoringService.addException(exception);

    try {
      ServiceLevelObjective serviceLevelObjective = ServiceLevelObjective.newBuilder().build();

      client.updateServiceLevelObjective(serviceLevelObjective);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deleteServiceLevelObjectiveTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    mockServiceMonitoringService.addResponse(expectedResponse);

    ServiceLevelObjectiveName name =
        ServiceLevelObjectiveName.of("[PROJECT]", "[SERVICE]", "[SERVICE_LEVEL_OBJECTIVE]");

    client.deleteServiceLevelObjective(name);

    List<AbstractMessage> actualRequests = mockServiceMonitoringService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteServiceLevelObjectiveRequest actualRequest =
        (DeleteServiceLevelObjectiveRequest) actualRequests.get(0);

    Assert.assertEquals(name, ServiceLevelObjectiveName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void deleteServiceLevelObjectiveExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockServiceMonitoringService.addException(exception);

    try {
      ServiceLevelObjectiveName name =
          ServiceLevelObjectiveName.of("[PROJECT]", "[SERVICE]", "[SERVICE_LEVEL_OBJECTIVE]");

      client.deleteServiceLevelObjective(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }
}
