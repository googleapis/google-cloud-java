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

package com.google.cloud.api.servicemanagement.v1;

import static com.google.cloud.api.servicemanagement.v1.ServiceManagerClient.ListServiceConfigsPagedResponse;
import static com.google.cloud.api.servicemanagement.v1.ServiceManagerClient.ListServiceRolloutsPagedResponse;
import static com.google.cloud.api.servicemanagement.v1.ServiceManagerClient.ListServicesPagedResponse;

import com.google.api.Authentication;
import com.google.api.Backend;
import com.google.api.Billing;
import com.google.api.Context;
import com.google.api.Control;
import com.google.api.Documentation;
import com.google.api.Endpoint;
import com.google.api.Http;
import com.google.api.LogDescriptor;
import com.google.api.Logging;
import com.google.api.MetricDescriptor;
import com.google.api.MonitoredResourceDescriptor;
import com.google.api.Monitoring;
import com.google.api.Quota;
import com.google.api.Service;
import com.google.api.SourceInfo;
import com.google.api.SystemParameters;
import com.google.api.Usage;
import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.servicemanagement.v1.ChangeReport;
import com.google.api.servicemanagement.v1.ConfigSource;
import com.google.api.servicemanagement.v1.CreateServiceConfigRequest;
import com.google.api.servicemanagement.v1.CreateServiceRequest;
import com.google.api.servicemanagement.v1.CreateServiceRolloutRequest;
import com.google.api.servicemanagement.v1.DeleteServiceRequest;
import com.google.api.servicemanagement.v1.Diagnostic;
import com.google.api.servicemanagement.v1.GenerateConfigReportRequest;
import com.google.api.servicemanagement.v1.GenerateConfigReportResponse;
import com.google.api.servicemanagement.v1.GetServiceConfigRequest;
import com.google.api.servicemanagement.v1.GetServiceRequest;
import com.google.api.servicemanagement.v1.GetServiceRolloutRequest;
import com.google.api.servicemanagement.v1.ListServiceConfigsRequest;
import com.google.api.servicemanagement.v1.ListServiceConfigsResponse;
import com.google.api.servicemanagement.v1.ListServiceRolloutsRequest;
import com.google.api.servicemanagement.v1.ListServiceRolloutsResponse;
import com.google.api.servicemanagement.v1.ListServicesRequest;
import com.google.api.servicemanagement.v1.ListServicesResponse;
import com.google.api.servicemanagement.v1.ManagedService;
import com.google.api.servicemanagement.v1.Rollout;
import com.google.api.servicemanagement.v1.SubmitConfigSourceRequest;
import com.google.api.servicemanagement.v1.SubmitConfigSourceResponse;
import com.google.api.servicemanagement.v1.UndeleteServiceRequest;
import com.google.api.servicemanagement.v1.UndeleteServiceResponse;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.protobuf.Api;
import com.google.protobuf.Empty;
import com.google.protobuf.Enum;
import com.google.protobuf.Timestamp;
import com.google.protobuf.Type;
import com.google.protobuf.UInt32Value;
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
public class ServiceManagerClientTest {
  private static MockServiceHelper mockServiceHelper;
  private static MockServiceManager mockServiceManager;
  private LocalChannelProvider channelProvider;
  private ServiceManagerClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockServiceManager = new MockServiceManager();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockServiceManager));
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
    ServiceManagerSettings settings =
        ServiceManagerSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ServiceManagerClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listServicesTest() throws Exception {
    ManagedService responsesElement = ManagedService.newBuilder().build();
    ListServicesResponse expectedResponse =
        ListServicesResponse.newBuilder()
            .setNextPageToken("")
            .addAllServices(Arrays.asList(responsesElement))
            .build();
    mockServiceManager.addResponse(expectedResponse);

    String producerProjectId = "producerProjectId-1297373534";
    String consumerId = "consumerId-166238287";

    ListServicesPagedResponse pagedListResponse =
        client.listServices(producerProjectId, consumerId);

    List<ManagedService> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getServicesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockServiceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListServicesRequest actualRequest = ((ListServicesRequest) actualRequests.get(0));

    Assert.assertEquals(producerProjectId, actualRequest.getProducerProjectId());
    Assert.assertEquals(consumerId, actualRequest.getConsumerId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listServicesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockServiceManager.addException(exception);

    try {
      String producerProjectId = "producerProjectId-1297373534";
      String consumerId = "consumerId-166238287";
      client.listServices(producerProjectId, consumerId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getServiceTest() throws Exception {
    ManagedService expectedResponse =
        ManagedService.newBuilder()
            .setServiceName("serviceName-1928572192")
            .setProducerProjectId("producerProjectId-1297373534")
            .build();
    mockServiceManager.addResponse(expectedResponse);

    String serviceName = "serviceName-1928572192";

    ManagedService actualResponse = client.getService(serviceName);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockServiceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetServiceRequest actualRequest = ((GetServiceRequest) actualRequests.get(0));

    Assert.assertEquals(serviceName, actualRequest.getServiceName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getServiceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockServiceManager.addException(exception);

    try {
      String serviceName = "serviceName-1928572192";
      client.getService(serviceName);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createServiceTest() throws Exception {
    ManagedService expectedResponse =
        ManagedService.newBuilder()
            .setServiceName("serviceName-1928572192")
            .setProducerProjectId("producerProjectId-1297373534")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createServiceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockServiceManager.addResponse(resultOperation);

    ManagedService service = ManagedService.newBuilder().build();

    ManagedService actualResponse = client.createServiceAsync(service).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockServiceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateServiceRequest actualRequest = ((CreateServiceRequest) actualRequests.get(0));

    Assert.assertEquals(service, actualRequest.getService());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createServiceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockServiceManager.addException(exception);

    try {
      ManagedService service = ManagedService.newBuilder().build();
      client.createServiceAsync(service).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteServiceTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteServiceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockServiceManager.addResponse(resultOperation);

    String serviceName = "serviceName-1928572192";

    client.deleteServiceAsync(serviceName).get();

    List<AbstractMessage> actualRequests = mockServiceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteServiceRequest actualRequest = ((DeleteServiceRequest) actualRequests.get(0));

    Assert.assertEquals(serviceName, actualRequest.getServiceName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteServiceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockServiceManager.addException(exception);

    try {
      String serviceName = "serviceName-1928572192";
      client.deleteServiceAsync(serviceName).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void undeleteServiceTest() throws Exception {
    UndeleteServiceResponse expectedResponse =
        UndeleteServiceResponse.newBuilder()
            .setService(ManagedService.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("undeleteServiceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockServiceManager.addResponse(resultOperation);

    String serviceName = "serviceName-1928572192";

    UndeleteServiceResponse actualResponse = client.undeleteServiceAsync(serviceName).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockServiceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UndeleteServiceRequest actualRequest = ((UndeleteServiceRequest) actualRequests.get(0));

    Assert.assertEquals(serviceName, actualRequest.getServiceName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void undeleteServiceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockServiceManager.addException(exception);

    try {
      String serviceName = "serviceName-1928572192";
      client.undeleteServiceAsync(serviceName).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listServiceConfigsTest() throws Exception {
    Service responsesElement = Service.newBuilder().build();
    ListServiceConfigsResponse expectedResponse =
        ListServiceConfigsResponse.newBuilder()
            .setNextPageToken("")
            .addAllServiceConfigs(Arrays.asList(responsesElement))
            .build();
    mockServiceManager.addResponse(expectedResponse);

    String serviceName = "serviceName-1928572192";

    ListServiceConfigsPagedResponse pagedListResponse = client.listServiceConfigs(serviceName);

    List<Service> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getServiceConfigsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockServiceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListServiceConfigsRequest actualRequest = ((ListServiceConfigsRequest) actualRequests.get(0));

    Assert.assertEquals(serviceName, actualRequest.getServiceName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listServiceConfigsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockServiceManager.addException(exception);

    try {
      String serviceName = "serviceName-1928572192";
      client.listServiceConfigs(serviceName);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getServiceConfigTest() throws Exception {
    Service expectedResponse =
        Service.newBuilder()
            .setName("name3373707")
            .setTitle("title110371416")
            .setProducerProjectId("producerProjectId-1297373534")
            .setId("id3355")
            .addAllApis(new ArrayList<Api>())
            .addAllTypes(new ArrayList<Type>())
            .addAllEnums(new ArrayList<Enum>())
            .setDocumentation(Documentation.newBuilder().build())
            .setBackend(Backend.newBuilder().build())
            .setHttp(Http.newBuilder().build())
            .setQuota(Quota.newBuilder().build())
            .setAuthentication(Authentication.newBuilder().build())
            .setContext(Context.newBuilder().build())
            .setUsage(Usage.newBuilder().build())
            .addAllEndpoints(new ArrayList<Endpoint>())
            .setControl(Control.newBuilder().build())
            .addAllLogs(new ArrayList<LogDescriptor>())
            .addAllMetrics(new ArrayList<MetricDescriptor>())
            .addAllMonitoredResources(new ArrayList<MonitoredResourceDescriptor>())
            .setBilling(Billing.newBuilder().build())
            .setLogging(Logging.newBuilder().build())
            .setMonitoring(Monitoring.newBuilder().build())
            .setSystemParameters(SystemParameters.newBuilder().build())
            .setSourceInfo(SourceInfo.newBuilder().build())
            .setConfigVersion(UInt32Value.newBuilder().build())
            .build();
    mockServiceManager.addResponse(expectedResponse);

    String serviceName = "serviceName-1928572192";
    String configId = "configId-580140035";
    GetServiceConfigRequest.ConfigView view = GetServiceConfigRequest.ConfigView.forNumber(0);

    Service actualResponse = client.getServiceConfig(serviceName, configId, view);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockServiceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetServiceConfigRequest actualRequest = ((GetServiceConfigRequest) actualRequests.get(0));

    Assert.assertEquals(serviceName, actualRequest.getServiceName());
    Assert.assertEquals(configId, actualRequest.getConfigId());
    Assert.assertEquals(view, actualRequest.getView());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getServiceConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockServiceManager.addException(exception);

    try {
      String serviceName = "serviceName-1928572192";
      String configId = "configId-580140035";
      GetServiceConfigRequest.ConfigView view = GetServiceConfigRequest.ConfigView.forNumber(0);
      client.getServiceConfig(serviceName, configId, view);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createServiceConfigTest() throws Exception {
    Service expectedResponse =
        Service.newBuilder()
            .setName("name3373707")
            .setTitle("title110371416")
            .setProducerProjectId("producerProjectId-1297373534")
            .setId("id3355")
            .addAllApis(new ArrayList<Api>())
            .addAllTypes(new ArrayList<Type>())
            .addAllEnums(new ArrayList<Enum>())
            .setDocumentation(Documentation.newBuilder().build())
            .setBackend(Backend.newBuilder().build())
            .setHttp(Http.newBuilder().build())
            .setQuota(Quota.newBuilder().build())
            .setAuthentication(Authentication.newBuilder().build())
            .setContext(Context.newBuilder().build())
            .setUsage(Usage.newBuilder().build())
            .addAllEndpoints(new ArrayList<Endpoint>())
            .setControl(Control.newBuilder().build())
            .addAllLogs(new ArrayList<LogDescriptor>())
            .addAllMetrics(new ArrayList<MetricDescriptor>())
            .addAllMonitoredResources(new ArrayList<MonitoredResourceDescriptor>())
            .setBilling(Billing.newBuilder().build())
            .setLogging(Logging.newBuilder().build())
            .setMonitoring(Monitoring.newBuilder().build())
            .setSystemParameters(SystemParameters.newBuilder().build())
            .setSourceInfo(SourceInfo.newBuilder().build())
            .setConfigVersion(UInt32Value.newBuilder().build())
            .build();
    mockServiceManager.addResponse(expectedResponse);

    String serviceName = "serviceName-1928572192";
    Service serviceConfig = Service.newBuilder().build();

    Service actualResponse = client.createServiceConfig(serviceName, serviceConfig);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockServiceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateServiceConfigRequest actualRequest = ((CreateServiceConfigRequest) actualRequests.get(0));

    Assert.assertEquals(serviceName, actualRequest.getServiceName());
    Assert.assertEquals(serviceConfig, actualRequest.getServiceConfig());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createServiceConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockServiceManager.addException(exception);

    try {
      String serviceName = "serviceName-1928572192";
      Service serviceConfig = Service.newBuilder().build();
      client.createServiceConfig(serviceName, serviceConfig);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void submitConfigSourceTest() throws Exception {
    SubmitConfigSourceResponse expectedResponse =
        SubmitConfigSourceResponse.newBuilder()
            .setServiceConfig(Service.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("submitConfigSourceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockServiceManager.addResponse(resultOperation);

    String serviceName = "serviceName-1928572192";
    ConfigSource configSource = ConfigSource.newBuilder().build();
    boolean validateOnly = true;

    SubmitConfigSourceResponse actualResponse =
        client.submitConfigSourceAsync(serviceName, configSource, validateOnly).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockServiceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SubmitConfigSourceRequest actualRequest = ((SubmitConfigSourceRequest) actualRequests.get(0));

    Assert.assertEquals(serviceName, actualRequest.getServiceName());
    Assert.assertEquals(configSource, actualRequest.getConfigSource());
    Assert.assertEquals(validateOnly, actualRequest.getValidateOnly());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void submitConfigSourceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockServiceManager.addException(exception);

    try {
      String serviceName = "serviceName-1928572192";
      ConfigSource configSource = ConfigSource.newBuilder().build();
      boolean validateOnly = true;
      client.submitConfigSourceAsync(serviceName, configSource, validateOnly).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listServiceRolloutsTest() throws Exception {
    Rollout responsesElement = Rollout.newBuilder().build();
    ListServiceRolloutsResponse expectedResponse =
        ListServiceRolloutsResponse.newBuilder()
            .setNextPageToken("")
            .addAllRollouts(Arrays.asList(responsesElement))
            .build();
    mockServiceManager.addResponse(expectedResponse);

    String serviceName = "serviceName-1928572192";
    String filter = "filter-1274492040";

    ListServiceRolloutsPagedResponse pagedListResponse =
        client.listServiceRollouts(serviceName, filter);

    List<Rollout> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRolloutsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockServiceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListServiceRolloutsRequest actualRequest = ((ListServiceRolloutsRequest) actualRequests.get(0));

    Assert.assertEquals(serviceName, actualRequest.getServiceName());
    Assert.assertEquals(filter, actualRequest.getFilter());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listServiceRolloutsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockServiceManager.addException(exception);

    try {
      String serviceName = "serviceName-1928572192";
      String filter = "filter-1274492040";
      client.listServiceRollouts(serviceName, filter);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getServiceRolloutTest() throws Exception {
    Rollout expectedResponse =
        Rollout.newBuilder()
            .setRolloutId("rolloutId551248556")
            .setCreateTime(Timestamp.newBuilder().build())
            .setCreatedBy("createdBy598371679")
            .setServiceName("serviceName-1928572192")
            .build();
    mockServiceManager.addResponse(expectedResponse);

    String serviceName = "serviceName-1928572192";
    String rolloutId = "rolloutId551248556";

    Rollout actualResponse = client.getServiceRollout(serviceName, rolloutId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockServiceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetServiceRolloutRequest actualRequest = ((GetServiceRolloutRequest) actualRequests.get(0));

    Assert.assertEquals(serviceName, actualRequest.getServiceName());
    Assert.assertEquals(rolloutId, actualRequest.getRolloutId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getServiceRolloutExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockServiceManager.addException(exception);

    try {
      String serviceName = "serviceName-1928572192";
      String rolloutId = "rolloutId551248556";
      client.getServiceRollout(serviceName, rolloutId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createServiceRolloutTest() throws Exception {
    Rollout expectedResponse =
        Rollout.newBuilder()
            .setRolloutId("rolloutId551248556")
            .setCreateTime(Timestamp.newBuilder().build())
            .setCreatedBy("createdBy598371679")
            .setServiceName("serviceName-1928572192")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createServiceRolloutTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockServiceManager.addResponse(resultOperation);

    String serviceName = "serviceName-1928572192";
    Rollout rollout = Rollout.newBuilder().build();

    Rollout actualResponse = client.createServiceRolloutAsync(serviceName, rollout).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockServiceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateServiceRolloutRequest actualRequest =
        ((CreateServiceRolloutRequest) actualRequests.get(0));

    Assert.assertEquals(serviceName, actualRequest.getServiceName());
    Assert.assertEquals(rollout, actualRequest.getRollout());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createServiceRolloutExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockServiceManager.addException(exception);

    try {
      String serviceName = "serviceName-1928572192";
      Rollout rollout = Rollout.newBuilder().build();
      client.createServiceRolloutAsync(serviceName, rollout).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void generateConfigReportTest() throws Exception {
    GenerateConfigReportResponse expectedResponse =
        GenerateConfigReportResponse.newBuilder()
            .setServiceName("serviceName-1928572192")
            .setId("id3355")
            .addAllChangeReports(new ArrayList<ChangeReport>())
            .addAllDiagnostics(new ArrayList<Diagnostic>())
            .build();
    mockServiceManager.addResponse(expectedResponse);

    Any newConfig = Any.newBuilder().build();
    Any oldConfig = Any.newBuilder().build();

    GenerateConfigReportResponse actualResponse = client.generateConfigReport(newConfig, oldConfig);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockServiceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GenerateConfigReportRequest actualRequest =
        ((GenerateConfigReportRequest) actualRequests.get(0));

    Assert.assertEquals(newConfig, actualRequest.getNewConfig());
    Assert.assertEquals(oldConfig, actualRequest.getOldConfig());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void generateConfigReportExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockServiceManager.addException(exception);

    try {
      Any newConfig = Any.newBuilder().build();
      Any oldConfig = Any.newBuilder().build();
      client.generateConfigReport(newConfig, oldConfig);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
