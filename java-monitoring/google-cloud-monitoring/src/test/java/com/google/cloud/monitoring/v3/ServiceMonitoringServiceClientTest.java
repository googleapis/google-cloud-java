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
import com.google.monitoring.v3.FolderName;
import com.google.monitoring.v3.GetServiceLevelObjectiveRequest;
import com.google.monitoring.v3.GetServiceRequest;
import com.google.monitoring.v3.ListServiceLevelObjectivesRequest;
import com.google.monitoring.v3.ListServiceLevelObjectivesResponse;
import com.google.monitoring.v3.ListServicesRequest;
import com.google.monitoring.v3.ListServicesResponse;
import com.google.monitoring.v3.OrganizationName;
import com.google.monitoring.v3.ProjectName;
import com.google.monitoring.v3.Service;
import com.google.monitoring.v3.ServiceLevelIndicator;
import com.google.monitoring.v3.ServiceLevelObjective;
import com.google.monitoring.v3.ServiceLevelObjectiveName;
import com.google.monitoring.v3.ServiceName;
import com.google.monitoring.v3.UpdateServiceLevelObjectiveRequest;
import com.google.monitoring.v3.UpdateServiceRequest;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Empty;
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
public class ServiceMonitoringServiceClientTest {
  private static MockServiceHelper mockServiceHelper;
  private static MockServiceMonitoringService mockServiceMonitoringService;
  private ServiceMonitoringServiceClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockServiceMonitoringService = new MockServiceMonitoringService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockServiceMonitoringService));
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
  public void createServiceTest() throws Exception {
    Service expectedResponse =
        Service.newBuilder()
            .setName(ServiceName.ofProjectServiceName("[PROJECT]", "[SERVICE]").toString())
            .setDisplayName("displayName1714148973")
            .setTelemetry(Service.Telemetry.newBuilder().build())
            .build();
    mockServiceMonitoringService.addResponse(expectedResponse);

    FolderName parent = FolderName.of("[FOLDER]");
    Service service = Service.newBuilder().build();

    Service actualResponse = client.createService(parent, service);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockServiceMonitoringService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateServiceRequest actualRequest = ((CreateServiceRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(service, actualRequest.getService());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createServiceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockServiceMonitoringService.addException(exception);

    try {
      FolderName parent = FolderName.of("[FOLDER]");
      Service service = Service.newBuilder().build();
      client.createService(parent, service);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createServiceTest2() throws Exception {
    Service expectedResponse =
        Service.newBuilder()
            .setName(ServiceName.ofProjectServiceName("[PROJECT]", "[SERVICE]").toString())
            .setDisplayName("displayName1714148973")
            .setTelemetry(Service.Telemetry.newBuilder().build())
            .build();
    mockServiceMonitoringService.addResponse(expectedResponse);

    OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
    Service service = Service.newBuilder().build();

    Service actualResponse = client.createService(parent, service);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockServiceMonitoringService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateServiceRequest actualRequest = ((CreateServiceRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(service, actualRequest.getService());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createServiceExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockServiceMonitoringService.addException(exception);

    try {
      OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
      Service service = Service.newBuilder().build();
      client.createService(parent, service);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createServiceTest3() throws Exception {
    Service expectedResponse =
        Service.newBuilder()
            .setName(ServiceName.ofProjectServiceName("[PROJECT]", "[SERVICE]").toString())
            .setDisplayName("displayName1714148973")
            .setTelemetry(Service.Telemetry.newBuilder().build())
            .build();
    mockServiceMonitoringService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");
    Service service = Service.newBuilder().build();

    Service actualResponse = client.createService(parent, service);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockServiceMonitoringService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateServiceRequest actualRequest = ((CreateServiceRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(service, actualRequest.getService());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createServiceExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockServiceMonitoringService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      Service service = Service.newBuilder().build();
      client.createService(parent, service);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createServiceTest4() throws Exception {
    Service expectedResponse =
        Service.newBuilder()
            .setName(ServiceName.ofProjectServiceName("[PROJECT]", "[SERVICE]").toString())
            .setDisplayName("displayName1714148973")
            .setTelemetry(Service.Telemetry.newBuilder().build())
            .build();
    mockServiceMonitoringService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Service service = Service.newBuilder().build();

    Service actualResponse = client.createService(parent, service);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockServiceMonitoringService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateServiceRequest actualRequest = ((CreateServiceRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(service, actualRequest.getService());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createServiceExceptionTest4() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockServiceMonitoringService.addException(exception);

    try {
      String parent = "parent-995424086";
      Service service = Service.newBuilder().build();
      client.createService(parent, service);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getServiceTest() throws Exception {
    Service expectedResponse =
        Service.newBuilder()
            .setName(ServiceName.ofProjectServiceName("[PROJECT]", "[SERVICE]").toString())
            .setDisplayName("displayName1714148973")
            .setTelemetry(Service.Telemetry.newBuilder().build())
            .build();
    mockServiceMonitoringService.addResponse(expectedResponse);

    ServiceName name = ServiceName.ofProjectServiceName("[PROJECT]", "[SERVICE]");

    Service actualResponse = client.getService(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockServiceMonitoringService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetServiceRequest actualRequest = ((GetServiceRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getServiceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockServiceMonitoringService.addException(exception);

    try {
      ServiceName name = ServiceName.ofProjectServiceName("[PROJECT]", "[SERVICE]");
      client.getService(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getServiceTest2() throws Exception {
    Service expectedResponse =
        Service.newBuilder()
            .setName(ServiceName.ofProjectServiceName("[PROJECT]", "[SERVICE]").toString())
            .setDisplayName("displayName1714148973")
            .setTelemetry(Service.Telemetry.newBuilder().build())
            .build();
    mockServiceMonitoringService.addResponse(expectedResponse);

    String name = "name3373707";

    Service actualResponse = client.getService(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockServiceMonitoringService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetServiceRequest actualRequest = ((GetServiceRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getServiceExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockServiceMonitoringService.addException(exception);

    try {
      String name = "name3373707";
      client.getService(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listServicesTest() throws Exception {
    Service responsesElement = Service.newBuilder().build();
    ListServicesResponse expectedResponse =
        ListServicesResponse.newBuilder()
            .setNextPageToken("")
            .addAllServices(Arrays.asList(responsesElement))
            .build();
    mockServiceMonitoringService.addResponse(expectedResponse);

    FolderName parent = FolderName.of("[FOLDER]");

    ListServicesPagedResponse pagedListResponse = client.listServices(parent);

    List<Service> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getServicesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockServiceMonitoringService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListServicesRequest actualRequest = ((ListServicesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listServicesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockServiceMonitoringService.addException(exception);

    try {
      FolderName parent = FolderName.of("[FOLDER]");
      client.listServices(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listServicesTest2() throws Exception {
    Service responsesElement = Service.newBuilder().build();
    ListServicesResponse expectedResponse =
        ListServicesResponse.newBuilder()
            .setNextPageToken("")
            .addAllServices(Arrays.asList(responsesElement))
            .build();
    mockServiceMonitoringService.addResponse(expectedResponse);

    OrganizationName parent = OrganizationName.of("[ORGANIZATION]");

    ListServicesPagedResponse pagedListResponse = client.listServices(parent);

    List<Service> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getServicesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockServiceMonitoringService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListServicesRequest actualRequest = ((ListServicesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listServicesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockServiceMonitoringService.addException(exception);

    try {
      OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
      client.listServices(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listServicesTest3() throws Exception {
    Service responsesElement = Service.newBuilder().build();
    ListServicesResponse expectedResponse =
        ListServicesResponse.newBuilder()
            .setNextPageToken("")
            .addAllServices(Arrays.asList(responsesElement))
            .build();
    mockServiceMonitoringService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");

    ListServicesPagedResponse pagedListResponse = client.listServices(parent);

    List<Service> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getServicesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockServiceMonitoringService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListServicesRequest actualRequest = ((ListServicesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listServicesExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockServiceMonitoringService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      client.listServices(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listServicesTest4() throws Exception {
    Service responsesElement = Service.newBuilder().build();
    ListServicesResponse expectedResponse =
        ListServicesResponse.newBuilder()
            .setNextPageToken("")
            .addAllServices(Arrays.asList(responsesElement))
            .build();
    mockServiceMonitoringService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListServicesPagedResponse pagedListResponse = client.listServices(parent);

    List<Service> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getServicesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockServiceMonitoringService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListServicesRequest actualRequest = ((ListServicesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listServicesExceptionTest4() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockServiceMonitoringService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listServices(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateServiceTest() throws Exception {
    Service expectedResponse =
        Service.newBuilder()
            .setName(ServiceName.ofProjectServiceName("[PROJECT]", "[SERVICE]").toString())
            .setDisplayName("displayName1714148973")
            .setTelemetry(Service.Telemetry.newBuilder().build())
            .build();
    mockServiceMonitoringService.addResponse(expectedResponse);

    Service service = Service.newBuilder().build();

    Service actualResponse = client.updateService(service);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockServiceMonitoringService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateServiceRequest actualRequest = ((UpdateServiceRequest) actualRequests.get(0));

    Assert.assertEquals(service, actualRequest.getService());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateServiceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockServiceMonitoringService.addException(exception);

    try {
      Service service = Service.newBuilder().build();
      client.updateService(service);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteServiceTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockServiceMonitoringService.addResponse(expectedResponse);

    ServiceName name = ServiceName.ofProjectServiceName("[PROJECT]", "[SERVICE]");

    client.deleteService(name);

    List<AbstractMessage> actualRequests = mockServiceMonitoringService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteServiceRequest actualRequest = ((DeleteServiceRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteServiceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockServiceMonitoringService.addException(exception);

    try {
      ServiceName name = ServiceName.ofProjectServiceName("[PROJECT]", "[SERVICE]");
      client.deleteService(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteServiceTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockServiceMonitoringService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteService(name);

    List<AbstractMessage> actualRequests = mockServiceMonitoringService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteServiceRequest actualRequest = ((DeleteServiceRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteServiceExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockServiceMonitoringService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteService(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createServiceLevelObjectiveTest() throws Exception {
    ServiceLevelObjective expectedResponse =
        ServiceLevelObjective.newBuilder()
            .setName(
                ServiceLevelObjectiveName.ofProjectServiceServiceLevelObjectiveName(
                        "[PROJECT]", "[SERVICE]", "[SERVICE_LEVEL_OBJECTIVE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setServiceLevelIndicator(ServiceLevelIndicator.newBuilder().build())
            .setGoal(3178259)
            .build();
    mockServiceMonitoringService.addResponse(expectedResponse);

    ServiceName parent = ServiceName.ofProjectServiceName("[PROJECT]", "[SERVICE]");
    ServiceLevelObjective serviceLevelObjective = ServiceLevelObjective.newBuilder().build();

    ServiceLevelObjective actualResponse =
        client.createServiceLevelObjective(parent, serviceLevelObjective);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockServiceMonitoringService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateServiceLevelObjectiveRequest actualRequest =
        ((CreateServiceLevelObjectiveRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(serviceLevelObjective, actualRequest.getServiceLevelObjective());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createServiceLevelObjectiveExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockServiceMonitoringService.addException(exception);

    try {
      ServiceName parent = ServiceName.ofProjectServiceName("[PROJECT]", "[SERVICE]");
      ServiceLevelObjective serviceLevelObjective = ServiceLevelObjective.newBuilder().build();
      client.createServiceLevelObjective(parent, serviceLevelObjective);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createServiceLevelObjectiveTest2() throws Exception {
    ServiceLevelObjective expectedResponse =
        ServiceLevelObjective.newBuilder()
            .setName(
                ServiceLevelObjectiveName.ofProjectServiceServiceLevelObjectiveName(
                        "[PROJECT]", "[SERVICE]", "[SERVICE_LEVEL_OBJECTIVE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setServiceLevelIndicator(ServiceLevelIndicator.newBuilder().build())
            .setGoal(3178259)
            .build();
    mockServiceMonitoringService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    ServiceLevelObjective serviceLevelObjective = ServiceLevelObjective.newBuilder().build();

    ServiceLevelObjective actualResponse =
        client.createServiceLevelObjective(parent, serviceLevelObjective);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockServiceMonitoringService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateServiceLevelObjectiveRequest actualRequest =
        ((CreateServiceLevelObjectiveRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(serviceLevelObjective, actualRequest.getServiceLevelObjective());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createServiceLevelObjectiveExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockServiceMonitoringService.addException(exception);

    try {
      String parent = "parent-995424086";
      ServiceLevelObjective serviceLevelObjective = ServiceLevelObjective.newBuilder().build();
      client.createServiceLevelObjective(parent, serviceLevelObjective);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getServiceLevelObjectiveTest() throws Exception {
    ServiceLevelObjective expectedResponse =
        ServiceLevelObjective.newBuilder()
            .setName(
                ServiceLevelObjectiveName.ofProjectServiceServiceLevelObjectiveName(
                        "[PROJECT]", "[SERVICE]", "[SERVICE_LEVEL_OBJECTIVE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setServiceLevelIndicator(ServiceLevelIndicator.newBuilder().build())
            .setGoal(3178259)
            .build();
    mockServiceMonitoringService.addResponse(expectedResponse);

    ServiceLevelObjectiveName name =
        ServiceLevelObjectiveName.ofProjectServiceServiceLevelObjectiveName(
            "[PROJECT]", "[SERVICE]", "[SERVICE_LEVEL_OBJECTIVE]");

    ServiceLevelObjective actualResponse = client.getServiceLevelObjective(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockServiceMonitoringService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetServiceLevelObjectiveRequest actualRequest =
        ((GetServiceLevelObjectiveRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getServiceLevelObjectiveExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockServiceMonitoringService.addException(exception);

    try {
      ServiceLevelObjectiveName name =
          ServiceLevelObjectiveName.ofProjectServiceServiceLevelObjectiveName(
              "[PROJECT]", "[SERVICE]", "[SERVICE_LEVEL_OBJECTIVE]");
      client.getServiceLevelObjective(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getServiceLevelObjectiveTest2() throws Exception {
    ServiceLevelObjective expectedResponse =
        ServiceLevelObjective.newBuilder()
            .setName(
                ServiceLevelObjectiveName.ofProjectServiceServiceLevelObjectiveName(
                        "[PROJECT]", "[SERVICE]", "[SERVICE_LEVEL_OBJECTIVE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setServiceLevelIndicator(ServiceLevelIndicator.newBuilder().build())
            .setGoal(3178259)
            .build();
    mockServiceMonitoringService.addResponse(expectedResponse);

    String name = "name3373707";

    ServiceLevelObjective actualResponse = client.getServiceLevelObjective(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockServiceMonitoringService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetServiceLevelObjectiveRequest actualRequest =
        ((GetServiceLevelObjectiveRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getServiceLevelObjectiveExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockServiceMonitoringService.addException(exception);

    try {
      String name = "name3373707";
      client.getServiceLevelObjective(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listServiceLevelObjectivesTest() throws Exception {
    ServiceLevelObjective responsesElement = ServiceLevelObjective.newBuilder().build();
    ListServiceLevelObjectivesResponse expectedResponse =
        ListServiceLevelObjectivesResponse.newBuilder()
            .setNextPageToken("")
            .addAllServiceLevelObjectives(Arrays.asList(responsesElement))
            .build();
    mockServiceMonitoringService.addResponse(expectedResponse);

    ServiceName parent = ServiceName.ofProjectServiceName("[PROJECT]", "[SERVICE]");

    ListServiceLevelObjectivesPagedResponse pagedListResponse =
        client.listServiceLevelObjectives(parent);

    List<ServiceLevelObjective> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getServiceLevelObjectivesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockServiceMonitoringService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListServiceLevelObjectivesRequest actualRequest =
        ((ListServiceLevelObjectivesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listServiceLevelObjectivesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockServiceMonitoringService.addException(exception);

    try {
      ServiceName parent = ServiceName.ofProjectServiceName("[PROJECT]", "[SERVICE]");
      client.listServiceLevelObjectives(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listServiceLevelObjectivesTest2() throws Exception {
    ServiceLevelObjective responsesElement = ServiceLevelObjective.newBuilder().build();
    ListServiceLevelObjectivesResponse expectedResponse =
        ListServiceLevelObjectivesResponse.newBuilder()
            .setNextPageToken("")
            .addAllServiceLevelObjectives(Arrays.asList(responsesElement))
            .build();
    mockServiceMonitoringService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListServiceLevelObjectivesPagedResponse pagedListResponse =
        client.listServiceLevelObjectives(parent);

    List<ServiceLevelObjective> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getServiceLevelObjectivesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockServiceMonitoringService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListServiceLevelObjectivesRequest actualRequest =
        ((ListServiceLevelObjectivesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listServiceLevelObjectivesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockServiceMonitoringService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listServiceLevelObjectives(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateServiceLevelObjectiveTest() throws Exception {
    ServiceLevelObjective expectedResponse =
        ServiceLevelObjective.newBuilder()
            .setName(
                ServiceLevelObjectiveName.ofProjectServiceServiceLevelObjectiveName(
                        "[PROJECT]", "[SERVICE]", "[SERVICE_LEVEL_OBJECTIVE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setServiceLevelIndicator(ServiceLevelIndicator.newBuilder().build())
            .setGoal(3178259)
            .build();
    mockServiceMonitoringService.addResponse(expectedResponse);

    ServiceLevelObjective serviceLevelObjective = ServiceLevelObjective.newBuilder().build();

    ServiceLevelObjective actualResponse =
        client.updateServiceLevelObjective(serviceLevelObjective);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockServiceMonitoringService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateServiceLevelObjectiveRequest actualRequest =
        ((UpdateServiceLevelObjectiveRequest) actualRequests.get(0));

    Assert.assertEquals(serviceLevelObjective, actualRequest.getServiceLevelObjective());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateServiceLevelObjectiveExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockServiceMonitoringService.addException(exception);

    try {
      ServiceLevelObjective serviceLevelObjective = ServiceLevelObjective.newBuilder().build();
      client.updateServiceLevelObjective(serviceLevelObjective);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteServiceLevelObjectiveTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockServiceMonitoringService.addResponse(expectedResponse);

    ServiceLevelObjectiveName name =
        ServiceLevelObjectiveName.ofProjectServiceServiceLevelObjectiveName(
            "[PROJECT]", "[SERVICE]", "[SERVICE_LEVEL_OBJECTIVE]");

    client.deleteServiceLevelObjective(name);

    List<AbstractMessage> actualRequests = mockServiceMonitoringService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteServiceLevelObjectiveRequest actualRequest =
        ((DeleteServiceLevelObjectiveRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteServiceLevelObjectiveExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockServiceMonitoringService.addException(exception);

    try {
      ServiceLevelObjectiveName name =
          ServiceLevelObjectiveName.ofProjectServiceServiceLevelObjectiveName(
              "[PROJECT]", "[SERVICE]", "[SERVICE_LEVEL_OBJECTIVE]");
      client.deleteServiceLevelObjective(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteServiceLevelObjectiveTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockServiceMonitoringService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteServiceLevelObjective(name);

    List<AbstractMessage> actualRequests = mockServiceMonitoringService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteServiceLevelObjectiveRequest actualRequest =
        ((DeleteServiceLevelObjectiveRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteServiceLevelObjectiveExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockServiceMonitoringService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteServiceLevelObjective(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
