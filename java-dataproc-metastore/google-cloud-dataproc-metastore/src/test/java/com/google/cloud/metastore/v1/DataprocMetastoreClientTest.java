/*
 * Copyright 2021 Google LLC
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

package com.google.cloud.metastore.v1;

import static com.google.cloud.metastore.v1.DataprocMetastoreClient.ListMetadataImportsPagedResponse;
import static com.google.cloud.metastore.v1.DataprocMetastoreClient.ListServicesPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
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
public class DataprocMetastoreClientTest {
  private static MockDataprocMetastore mockDataprocMetastore;
  private static MockServiceHelper mockServiceHelper;
  private DataprocMetastoreClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockDataprocMetastore = new MockDataprocMetastore();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockDataprocMetastore));
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
    DataprocMetastoreSettings settings =
        DataprocMetastoreSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = DataprocMetastoreClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listServicesTest() throws Exception {
    Service responsesElement = Service.newBuilder().build();
    ListServicesResponse expectedResponse =
        ListServicesResponse.newBuilder()
            .setNextPageToken("")
            .addAllServices(Arrays.asList(responsesElement))
            .build();
    mockDataprocMetastore.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListServicesPagedResponse pagedListResponse = client.listServices(parent);

    List<Service> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getServicesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataprocMetastore.getRequests();
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
    mockDataprocMetastore.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
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
    mockDataprocMetastore.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListServicesPagedResponse pagedListResponse = client.listServices(parent);

    List<Service> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getServicesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataprocMetastore.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListServicesRequest actualRequest = ((ListServicesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listServicesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataprocMetastore.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listServices(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getServiceTest() throws Exception {
    Service expectedResponse =
        Service.newBuilder()
            .setName(ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setNetwork(NetworkName.of("[PROJECT]", "[NETWORK]").toString())
            .setEndpointUri("endpointUri-1135817833")
            .setPort(3446913)
            .setStateMessage("stateMessage1128185398")
            .setArtifactGcsUri("artifactGcsUri-2145935545")
            .setMaintenanceWindow(MaintenanceWindow.newBuilder().build())
            .setUid("uid115792")
            .setMetadataManagementActivity(MetadataManagementActivity.newBuilder().build())
            .build();
    mockDataprocMetastore.addResponse(expectedResponse);

    ServiceName name = ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]");

    Service actualResponse = client.getService(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataprocMetastore.getRequests();
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
    mockDataprocMetastore.addException(exception);

    try {
      ServiceName name = ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]");
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
            .setName(ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setNetwork(NetworkName.of("[PROJECT]", "[NETWORK]").toString())
            .setEndpointUri("endpointUri-1135817833")
            .setPort(3446913)
            .setStateMessage("stateMessage1128185398")
            .setArtifactGcsUri("artifactGcsUri-2145935545")
            .setMaintenanceWindow(MaintenanceWindow.newBuilder().build())
            .setUid("uid115792")
            .setMetadataManagementActivity(MetadataManagementActivity.newBuilder().build())
            .build();
    mockDataprocMetastore.addResponse(expectedResponse);

    String name = "name3373707";

    Service actualResponse = client.getService(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataprocMetastore.getRequests();
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
    mockDataprocMetastore.addException(exception);

    try {
      String name = "name3373707";
      client.getService(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createServiceTest() throws Exception {
    Service expectedResponse =
        Service.newBuilder()
            .setName(ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setNetwork(NetworkName.of("[PROJECT]", "[NETWORK]").toString())
            .setEndpointUri("endpointUri-1135817833")
            .setPort(3446913)
            .setStateMessage("stateMessage1128185398")
            .setArtifactGcsUri("artifactGcsUri-2145935545")
            .setMaintenanceWindow(MaintenanceWindow.newBuilder().build())
            .setUid("uid115792")
            .setMetadataManagementActivity(MetadataManagementActivity.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createServiceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataprocMetastore.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Service service = Service.newBuilder().build();
    String serviceId = "serviceId-194185552";

    Service actualResponse = client.createServiceAsync(parent, service, serviceId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataprocMetastore.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateServiceRequest actualRequest = ((CreateServiceRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(service, actualRequest.getService());
    Assert.assertEquals(serviceId, actualRequest.getServiceId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createServiceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataprocMetastore.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Service service = Service.newBuilder().build();
      String serviceId = "serviceId-194185552";
      client.createServiceAsync(parent, service, serviceId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createServiceTest2() throws Exception {
    Service expectedResponse =
        Service.newBuilder()
            .setName(ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setNetwork(NetworkName.of("[PROJECT]", "[NETWORK]").toString())
            .setEndpointUri("endpointUri-1135817833")
            .setPort(3446913)
            .setStateMessage("stateMessage1128185398")
            .setArtifactGcsUri("artifactGcsUri-2145935545")
            .setMaintenanceWindow(MaintenanceWindow.newBuilder().build())
            .setUid("uid115792")
            .setMetadataManagementActivity(MetadataManagementActivity.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createServiceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataprocMetastore.addResponse(resultOperation);

    String parent = "parent-995424086";
    Service service = Service.newBuilder().build();
    String serviceId = "serviceId-194185552";

    Service actualResponse = client.createServiceAsync(parent, service, serviceId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataprocMetastore.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateServiceRequest actualRequest = ((CreateServiceRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(service, actualRequest.getService());
    Assert.assertEquals(serviceId, actualRequest.getServiceId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createServiceExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataprocMetastore.addException(exception);

    try {
      String parent = "parent-995424086";
      Service service = Service.newBuilder().build();
      String serviceId = "serviceId-194185552";
      client.createServiceAsync(parent, service, serviceId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateServiceTest() throws Exception {
    Service expectedResponse =
        Service.newBuilder()
            .setName(ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setNetwork(NetworkName.of("[PROJECT]", "[NETWORK]").toString())
            .setEndpointUri("endpointUri-1135817833")
            .setPort(3446913)
            .setStateMessage("stateMessage1128185398")
            .setArtifactGcsUri("artifactGcsUri-2145935545")
            .setMaintenanceWindow(MaintenanceWindow.newBuilder().build())
            .setUid("uid115792")
            .setMetadataManagementActivity(MetadataManagementActivity.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateServiceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataprocMetastore.addResponse(resultOperation);

    Service service = Service.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Service actualResponse = client.updateServiceAsync(service, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataprocMetastore.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateServiceRequest actualRequest = ((UpdateServiceRequest) actualRequests.get(0));

    Assert.assertEquals(service, actualRequest.getService());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateServiceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataprocMetastore.addException(exception);

    try {
      Service service = Service.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateServiceAsync(service, updateMask).get();
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
    mockDataprocMetastore.addResponse(resultOperation);

    ServiceName name = ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]");

    client.deleteServiceAsync(name).get();

    List<AbstractMessage> actualRequests = mockDataprocMetastore.getRequests();
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
    mockDataprocMetastore.addException(exception);

    try {
      ServiceName name = ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]");
      client.deleteServiceAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteServiceTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteServiceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataprocMetastore.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteServiceAsync(name).get();

    List<AbstractMessage> actualRequests = mockDataprocMetastore.getRequests();
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
    mockDataprocMetastore.addException(exception);

    try {
      String name = "name3373707";
      client.deleteServiceAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listMetadataImportsTest() throws Exception {
    MetadataImport responsesElement = MetadataImport.newBuilder().build();
    ListMetadataImportsResponse expectedResponse =
        ListMetadataImportsResponse.newBuilder()
            .setNextPageToken("")
            .addAllMetadataImports(Arrays.asList(responsesElement))
            .build();
    mockDataprocMetastore.addResponse(expectedResponse);

    ServiceName parent = ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]");

    ListMetadataImportsPagedResponse pagedListResponse = client.listMetadataImports(parent);

    List<MetadataImport> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMetadataImportsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataprocMetastore.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListMetadataImportsRequest actualRequest = ((ListMetadataImportsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listMetadataImportsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataprocMetastore.addException(exception);

    try {
      ServiceName parent = ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]");
      client.listMetadataImports(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listMetadataImportsTest2() throws Exception {
    MetadataImport responsesElement = MetadataImport.newBuilder().build();
    ListMetadataImportsResponse expectedResponse =
        ListMetadataImportsResponse.newBuilder()
            .setNextPageToken("")
            .addAllMetadataImports(Arrays.asList(responsesElement))
            .build();
    mockDataprocMetastore.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListMetadataImportsPagedResponse pagedListResponse = client.listMetadataImports(parent);

    List<MetadataImport> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMetadataImportsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataprocMetastore.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListMetadataImportsRequest actualRequest = ((ListMetadataImportsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listMetadataImportsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataprocMetastore.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listMetadataImports(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getMetadataImportTest() throws Exception {
    MetadataImport expectedResponse =
        MetadataImport.newBuilder()
            .setName(
                MetadataImportName.of("[PROJECT]", "[LOCATION]", "[SERVICE]", "[METADATA_IMPORT]")
                    .toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockDataprocMetastore.addResponse(expectedResponse);

    MetadataImportName name =
        MetadataImportName.of("[PROJECT]", "[LOCATION]", "[SERVICE]", "[METADATA_IMPORT]");

    MetadataImport actualResponse = client.getMetadataImport(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataprocMetastore.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetMetadataImportRequest actualRequest = ((GetMetadataImportRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getMetadataImportExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataprocMetastore.addException(exception);

    try {
      MetadataImportName name =
          MetadataImportName.of("[PROJECT]", "[LOCATION]", "[SERVICE]", "[METADATA_IMPORT]");
      client.getMetadataImport(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getMetadataImportTest2() throws Exception {
    MetadataImport expectedResponse =
        MetadataImport.newBuilder()
            .setName(
                MetadataImportName.of("[PROJECT]", "[LOCATION]", "[SERVICE]", "[METADATA_IMPORT]")
                    .toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockDataprocMetastore.addResponse(expectedResponse);

    String name = "name3373707";

    MetadataImport actualResponse = client.getMetadataImport(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataprocMetastore.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetMetadataImportRequest actualRequest = ((GetMetadataImportRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getMetadataImportExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataprocMetastore.addException(exception);

    try {
      String name = "name3373707";
      client.getMetadataImport(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createMetadataImportTest() throws Exception {
    MetadataImport expectedResponse =
        MetadataImport.newBuilder()
            .setName(
                MetadataImportName.of("[PROJECT]", "[LOCATION]", "[SERVICE]", "[METADATA_IMPORT]")
                    .toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createMetadataImportTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataprocMetastore.addResponse(resultOperation);

    ServiceName parent = ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]");
    MetadataImport metadataImport = MetadataImport.newBuilder().build();
    String metadataImportId = "metadataImportId1824548847";

    MetadataImport actualResponse =
        client.createMetadataImportAsync(parent, metadataImport, metadataImportId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataprocMetastore.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateMetadataImportRequest actualRequest =
        ((CreateMetadataImportRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(metadataImport, actualRequest.getMetadataImport());
    Assert.assertEquals(metadataImportId, actualRequest.getMetadataImportId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createMetadataImportExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataprocMetastore.addException(exception);

    try {
      ServiceName parent = ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]");
      MetadataImport metadataImport = MetadataImport.newBuilder().build();
      String metadataImportId = "metadataImportId1824548847";
      client.createMetadataImportAsync(parent, metadataImport, metadataImportId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createMetadataImportTest2() throws Exception {
    MetadataImport expectedResponse =
        MetadataImport.newBuilder()
            .setName(
                MetadataImportName.of("[PROJECT]", "[LOCATION]", "[SERVICE]", "[METADATA_IMPORT]")
                    .toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createMetadataImportTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataprocMetastore.addResponse(resultOperation);

    String parent = "parent-995424086";
    MetadataImport metadataImport = MetadataImport.newBuilder().build();
    String metadataImportId = "metadataImportId1824548847";

    MetadataImport actualResponse =
        client.createMetadataImportAsync(parent, metadataImport, metadataImportId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataprocMetastore.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateMetadataImportRequest actualRequest =
        ((CreateMetadataImportRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(metadataImport, actualRequest.getMetadataImport());
    Assert.assertEquals(metadataImportId, actualRequest.getMetadataImportId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createMetadataImportExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataprocMetastore.addException(exception);

    try {
      String parent = "parent-995424086";
      MetadataImport metadataImport = MetadataImport.newBuilder().build();
      String metadataImportId = "metadataImportId1824548847";
      client.createMetadataImportAsync(parent, metadataImport, metadataImportId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateMetadataImportTest() throws Exception {
    MetadataImport expectedResponse =
        MetadataImport.newBuilder()
            .setName(
                MetadataImportName.of("[PROJECT]", "[LOCATION]", "[SERVICE]", "[METADATA_IMPORT]")
                    .toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateMetadataImportTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataprocMetastore.addResponse(resultOperation);

    MetadataImport metadataImport = MetadataImport.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    MetadataImport actualResponse =
        client.updateMetadataImportAsync(metadataImport, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataprocMetastore.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateMetadataImportRequest actualRequest =
        ((UpdateMetadataImportRequest) actualRequests.get(0));

    Assert.assertEquals(metadataImport, actualRequest.getMetadataImport());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateMetadataImportExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataprocMetastore.addException(exception);

    try {
      MetadataImport metadataImport = MetadataImport.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateMetadataImportAsync(metadataImport, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void exportMetadataTest() throws Exception {
    MetadataExport expectedResponse =
        MetadataExport.newBuilder()
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("exportMetadataTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataprocMetastore.addResponse(resultOperation);

    ExportMetadataRequest request =
        ExportMetadataRequest.newBuilder()
            .setService(ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]").toString())
            .setRequestId("requestId693933066")
            .build();

    MetadataExport actualResponse = client.exportMetadataAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataprocMetastore.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ExportMetadataRequest actualRequest = ((ExportMetadataRequest) actualRequests.get(0));

    Assert.assertEquals(request.getDestinationGcsFolder(), actualRequest.getDestinationGcsFolder());
    Assert.assertEquals(request.getService(), actualRequest.getService());
    Assert.assertEquals(request.getRequestId(), actualRequest.getRequestId());
    Assert.assertEquals(request.getDatabaseDumpType(), actualRequest.getDatabaseDumpType());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void exportMetadataExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataprocMetastore.addException(exception);

    try {
      ExportMetadataRequest request =
          ExportMetadataRequest.newBuilder()
              .setService(ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]").toString())
              .setRequestId("requestId693933066")
              .build();
      client.exportMetadataAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }
}
