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
package com.google.cloud.servicedirectory.v1beta1;

import static com.google.cloud.servicedirectory.v1beta1.RegistrationServiceClient.ListEndpointsPagedResponse;
import static com.google.cloud.servicedirectory.v1beta1.RegistrationServiceClient.ListNamespacesPagedResponse;
import static com.google.cloud.servicedirectory.v1beta1.RegistrationServiceClient.ListServicesPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.resourcenames.ResourceName;
import com.google.common.collect.Lists;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.ByteString;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@javax.annotation.Generated("by GAPIC")
public class RegistrationServiceClientTest {
  private static MockLookupService mockLookupService;
  private static MockRegistrationService mockRegistrationService;
  private static MockServiceHelper serviceHelper;
  private RegistrationServiceClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockLookupService = new MockLookupService();
    mockRegistrationService = new MockRegistrationService();
    serviceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockLookupService, mockRegistrationService));
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
    RegistrationServiceSettings settings =
        RegistrationServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = RegistrationServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void createNamespaceTest() {
    NamespaceName name = NamespaceName.of("[PROJECT]", "[LOCATION]", "[NAMESPACE]");
    Namespace expectedResponse = Namespace.newBuilder().setName(name.toString()).build();
    mockRegistrationService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Namespace namespace = Namespace.newBuilder().build();
    String namespaceId = "namespaceId-1253352833";

    Namespace actualResponse = client.createNamespace(parent, namespace, namespaceId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRegistrationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateNamespaceRequest actualRequest = (CreateNamespaceRequest) actualRequests.get(0);

    Assert.assertEquals(parent, LocationName.parse(actualRequest.getParent()));
    Assert.assertEquals(namespace, actualRequest.getNamespace());
    Assert.assertEquals(namespaceId, actualRequest.getNamespaceId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createNamespaceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockRegistrationService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Namespace namespace = Namespace.newBuilder().build();
      String namespaceId = "namespaceId-1253352833";

      client.createNamespace(parent, namespace, namespaceId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listNamespacesTest() {
    String nextPageToken = "";
    Namespace namespacesElement = Namespace.newBuilder().build();
    List<Namespace> namespaces = Arrays.asList(namespacesElement);
    ListNamespacesResponse expectedResponse =
        ListNamespacesResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllNamespaces(namespaces)
            .build();
    mockRegistrationService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListNamespacesPagedResponse pagedListResponse = client.listNamespaces(parent);

    List<Namespace> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getNamespacesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockRegistrationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListNamespacesRequest actualRequest = (ListNamespacesRequest) actualRequests.get(0);

    Assert.assertEquals(parent, LocationName.parse(actualRequest.getParent()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listNamespacesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockRegistrationService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

      client.listNamespaces(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getNamespaceTest() {
    NamespaceName name2 = NamespaceName.of("[PROJECT]", "[LOCATION]", "[NAMESPACE]");
    Namespace expectedResponse = Namespace.newBuilder().setName(name2.toString()).build();
    mockRegistrationService.addResponse(expectedResponse);

    NamespaceName name = NamespaceName.of("[PROJECT]", "[LOCATION]", "[NAMESPACE]");

    Namespace actualResponse = client.getNamespace(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRegistrationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetNamespaceRequest actualRequest = (GetNamespaceRequest) actualRequests.get(0);

    Assert.assertEquals(name, NamespaceName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getNamespaceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockRegistrationService.addException(exception);

    try {
      NamespaceName name = NamespaceName.of("[PROJECT]", "[LOCATION]", "[NAMESPACE]");

      client.getNamespace(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateNamespaceTest() {
    NamespaceName name = NamespaceName.of("[PROJECT]", "[LOCATION]", "[NAMESPACE]");
    Namespace expectedResponse = Namespace.newBuilder().setName(name.toString()).build();
    mockRegistrationService.addResponse(expectedResponse);

    Namespace namespace = Namespace.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Namespace actualResponse = client.updateNamespace(namespace, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRegistrationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateNamespaceRequest actualRequest = (UpdateNamespaceRequest) actualRequests.get(0);

    Assert.assertEquals(namespace, actualRequest.getNamespace());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void updateNamespaceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockRegistrationService.addException(exception);

    try {
      Namespace namespace = Namespace.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();

      client.updateNamespace(namespace, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deleteNamespaceTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    mockRegistrationService.addResponse(expectedResponse);

    NamespaceName name = NamespaceName.of("[PROJECT]", "[LOCATION]", "[NAMESPACE]");

    client.deleteNamespace(name);

    List<AbstractMessage> actualRequests = mockRegistrationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteNamespaceRequest actualRequest = (DeleteNamespaceRequest) actualRequests.get(0);

    Assert.assertEquals(name, NamespaceName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void deleteNamespaceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockRegistrationService.addException(exception);

    try {
      NamespaceName name = NamespaceName.of("[PROJECT]", "[LOCATION]", "[NAMESPACE]");

      client.deleteNamespace(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createServiceTest() {
    ServiceName name = ServiceName.of("[PROJECT]", "[LOCATION]", "[NAMESPACE]", "[SERVICE]");
    Service expectedResponse = Service.newBuilder().setName(name.toString()).build();
    mockRegistrationService.addResponse(expectedResponse);

    NamespaceName parent = NamespaceName.of("[PROJECT]", "[LOCATION]", "[NAMESPACE]");
    Service service = Service.newBuilder().build();
    String serviceId = "serviceId-1724763419";

    Service actualResponse = client.createService(parent, service, serviceId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRegistrationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateServiceRequest actualRequest = (CreateServiceRequest) actualRequests.get(0);

    Assert.assertEquals(parent, NamespaceName.parse(actualRequest.getParent()));
    Assert.assertEquals(service, actualRequest.getService());
    Assert.assertEquals(serviceId, actualRequest.getServiceId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createServiceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockRegistrationService.addException(exception);

    try {
      NamespaceName parent = NamespaceName.of("[PROJECT]", "[LOCATION]", "[NAMESPACE]");
      Service service = Service.newBuilder().build();
      String serviceId = "serviceId-1724763419";

      client.createService(parent, service, serviceId);
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
    mockRegistrationService.addResponse(expectedResponse);

    NamespaceName parent = NamespaceName.of("[PROJECT]", "[LOCATION]", "[NAMESPACE]");

    ListServicesPagedResponse pagedListResponse = client.listServices(parent);

    List<Service> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getServicesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockRegistrationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListServicesRequest actualRequest = (ListServicesRequest) actualRequests.get(0);

    Assert.assertEquals(parent, NamespaceName.parse(actualRequest.getParent()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listServicesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockRegistrationService.addException(exception);

    try {
      NamespaceName parent = NamespaceName.of("[PROJECT]", "[LOCATION]", "[NAMESPACE]");

      client.listServices(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getServiceTest() {
    ServiceName name2 = ServiceName.of("[PROJECT]", "[LOCATION]", "[NAMESPACE]", "[SERVICE]");
    Service expectedResponse = Service.newBuilder().setName(name2.toString()).build();
    mockRegistrationService.addResponse(expectedResponse);

    ServiceName name = ServiceName.of("[PROJECT]", "[LOCATION]", "[NAMESPACE]", "[SERVICE]");

    Service actualResponse = client.getService(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRegistrationService.getRequests();
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
    mockRegistrationService.addException(exception);

    try {
      ServiceName name = ServiceName.of("[PROJECT]", "[LOCATION]", "[NAMESPACE]", "[SERVICE]");

      client.getService(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateServiceTest() {
    ServiceName name = ServiceName.of("[PROJECT]", "[LOCATION]", "[NAMESPACE]", "[SERVICE]");
    Service expectedResponse = Service.newBuilder().setName(name.toString()).build();
    mockRegistrationService.addResponse(expectedResponse);

    Service service = Service.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Service actualResponse = client.updateService(service, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRegistrationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateServiceRequest actualRequest = (UpdateServiceRequest) actualRequests.get(0);

    Assert.assertEquals(service, actualRequest.getService());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void updateServiceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockRegistrationService.addException(exception);

    try {
      Service service = Service.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();

      client.updateService(service, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deleteServiceTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    mockRegistrationService.addResponse(expectedResponse);

    ServiceName name = ServiceName.of("[PROJECT]", "[LOCATION]", "[NAMESPACE]", "[SERVICE]");

    client.deleteService(name);

    List<AbstractMessage> actualRequests = mockRegistrationService.getRequests();
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
    mockRegistrationService.addException(exception);

    try {
      ServiceName name = ServiceName.of("[PROJECT]", "[LOCATION]", "[NAMESPACE]", "[SERVICE]");

      client.deleteService(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createEndpointTest() {
    EndpointName name =
        EndpointName.of("[PROJECT]", "[LOCATION]", "[NAMESPACE]", "[SERVICE]", "[ENDPOINT]");
    String address = "address-1147692044";
    int port = 3446913;
    Endpoint expectedResponse =
        Endpoint.newBuilder().setName(name.toString()).setAddress(address).setPort(port).build();
    mockRegistrationService.addResponse(expectedResponse);

    ServiceName parent = ServiceName.of("[PROJECT]", "[LOCATION]", "[NAMESPACE]", "[SERVICE]");
    Endpoint endpoint = Endpoint.newBuilder().build();
    String endpointId = "endpointId-1135808507";

    Endpoint actualResponse = client.createEndpoint(parent, endpoint, endpointId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRegistrationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateEndpointRequest actualRequest = (CreateEndpointRequest) actualRequests.get(0);

    Assert.assertEquals(parent, ServiceName.parse(actualRequest.getParent()));
    Assert.assertEquals(endpoint, actualRequest.getEndpoint());
    Assert.assertEquals(endpointId, actualRequest.getEndpointId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createEndpointExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockRegistrationService.addException(exception);

    try {
      ServiceName parent = ServiceName.of("[PROJECT]", "[LOCATION]", "[NAMESPACE]", "[SERVICE]");
      Endpoint endpoint = Endpoint.newBuilder().build();
      String endpointId = "endpointId-1135808507";

      client.createEndpoint(parent, endpoint, endpointId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listEndpointsTest() {
    String nextPageToken = "";
    Endpoint endpointsElement = Endpoint.newBuilder().build();
    List<Endpoint> endpoints = Arrays.asList(endpointsElement);
    ListEndpointsResponse expectedResponse =
        ListEndpointsResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllEndpoints(endpoints)
            .build();
    mockRegistrationService.addResponse(expectedResponse);

    ServiceName parent = ServiceName.of("[PROJECT]", "[LOCATION]", "[NAMESPACE]", "[SERVICE]");

    ListEndpointsPagedResponse pagedListResponse = client.listEndpoints(parent);

    List<Endpoint> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEndpointsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockRegistrationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListEndpointsRequest actualRequest = (ListEndpointsRequest) actualRequests.get(0);

    Assert.assertEquals(parent, ServiceName.parse(actualRequest.getParent()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listEndpointsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockRegistrationService.addException(exception);

    try {
      ServiceName parent = ServiceName.of("[PROJECT]", "[LOCATION]", "[NAMESPACE]", "[SERVICE]");

      client.listEndpoints(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getEndpointTest() {
    EndpointName name2 =
        EndpointName.of("[PROJECT]", "[LOCATION]", "[NAMESPACE]", "[SERVICE]", "[ENDPOINT]");
    String address = "address-1147692044";
    int port = 3446913;
    Endpoint expectedResponse =
        Endpoint.newBuilder().setName(name2.toString()).setAddress(address).setPort(port).build();
    mockRegistrationService.addResponse(expectedResponse);

    EndpointName name =
        EndpointName.of("[PROJECT]", "[LOCATION]", "[NAMESPACE]", "[SERVICE]", "[ENDPOINT]");

    Endpoint actualResponse = client.getEndpoint(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRegistrationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetEndpointRequest actualRequest = (GetEndpointRequest) actualRequests.get(0);

    Assert.assertEquals(name, EndpointName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getEndpointExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockRegistrationService.addException(exception);

    try {
      EndpointName name =
          EndpointName.of("[PROJECT]", "[LOCATION]", "[NAMESPACE]", "[SERVICE]", "[ENDPOINT]");

      client.getEndpoint(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateEndpointTest() {
    EndpointName name =
        EndpointName.of("[PROJECT]", "[LOCATION]", "[NAMESPACE]", "[SERVICE]", "[ENDPOINT]");
    String address = "address-1147692044";
    int port = 3446913;
    Endpoint expectedResponse =
        Endpoint.newBuilder().setName(name.toString()).setAddress(address).setPort(port).build();
    mockRegistrationService.addResponse(expectedResponse);

    Endpoint endpoint = Endpoint.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Endpoint actualResponse = client.updateEndpoint(endpoint, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRegistrationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateEndpointRequest actualRequest = (UpdateEndpointRequest) actualRequests.get(0);

    Assert.assertEquals(endpoint, actualRequest.getEndpoint());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void updateEndpointExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockRegistrationService.addException(exception);

    try {
      Endpoint endpoint = Endpoint.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();

      client.updateEndpoint(endpoint, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deleteEndpointTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    mockRegistrationService.addResponse(expectedResponse);

    EndpointName name =
        EndpointName.of("[PROJECT]", "[LOCATION]", "[NAMESPACE]", "[SERVICE]", "[ENDPOINT]");

    client.deleteEndpoint(name);

    List<AbstractMessage> actualRequests = mockRegistrationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteEndpointRequest actualRequest = (DeleteEndpointRequest) actualRequests.get(0);

    Assert.assertEquals(name, EndpointName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void deleteEndpointExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockRegistrationService.addException(exception);

    try {
      EndpointName name =
          EndpointName.of("[PROJECT]", "[LOCATION]", "[NAMESPACE]", "[SERVICE]", "[ENDPOINT]");

      client.deleteEndpoint(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getIamPolicyTest() {
    int version = 351608024;
    ByteString etag = ByteString.copyFromUtf8("21");
    Policy expectedResponse = Policy.newBuilder().setVersion(version).setEtag(etag).build();
    mockRegistrationService.addResponse(expectedResponse);

    ResourceName resource =
        EndpointName.of("[PROJECT]", "[LOCATION]", "[NAMESPACE]", "[SERVICE]", "[ENDPOINT]");
    GetIamPolicyRequest request =
        GetIamPolicyRequest.newBuilder().setResource(resource.toString()).build();

    Policy actualResponse = client.getIamPolicy(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRegistrationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetIamPolicyRequest actualRequest = (GetIamPolicyRequest) actualRequests.get(0);

    Assert.assertEquals(Objects.toString(resource), Objects.toString(actualRequest.getResource()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getIamPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockRegistrationService.addException(exception);

    try {
      ResourceName resource =
          EndpointName.of("[PROJECT]", "[LOCATION]", "[NAMESPACE]", "[SERVICE]", "[ENDPOINT]");
      GetIamPolicyRequest request =
          GetIamPolicyRequest.newBuilder().setResource(resource.toString()).build();

      client.getIamPolicy(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void setIamPolicyTest() {
    int version = 351608024;
    ByteString etag = ByteString.copyFromUtf8("21");
    Policy expectedResponse = Policy.newBuilder().setVersion(version).setEtag(etag).build();
    mockRegistrationService.addResponse(expectedResponse);

    ResourceName resource =
        EndpointName.of("[PROJECT]", "[LOCATION]", "[NAMESPACE]", "[SERVICE]", "[ENDPOINT]");
    Policy policy = Policy.newBuilder().build();
    SetIamPolicyRequest request =
        SetIamPolicyRequest.newBuilder().setResource(resource.toString()).setPolicy(policy).build();

    Policy actualResponse = client.setIamPolicy(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRegistrationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SetIamPolicyRequest actualRequest = (SetIamPolicyRequest) actualRequests.get(0);

    Assert.assertEquals(Objects.toString(resource), Objects.toString(actualRequest.getResource()));
    Assert.assertEquals(policy, actualRequest.getPolicy());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void setIamPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockRegistrationService.addException(exception);

    try {
      ResourceName resource =
          EndpointName.of("[PROJECT]", "[LOCATION]", "[NAMESPACE]", "[SERVICE]", "[ENDPOINT]");
      Policy policy = Policy.newBuilder().build();
      SetIamPolicyRequest request =
          SetIamPolicyRequest.newBuilder()
              .setResource(resource.toString())
              .setPolicy(policy)
              .build();

      client.setIamPolicy(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void testIamPermissionsTest() {
    TestIamPermissionsResponse expectedResponse = TestIamPermissionsResponse.newBuilder().build();
    mockRegistrationService.addResponse(expectedResponse);

    ResourceName resource =
        EndpointName.of("[PROJECT]", "[LOCATION]", "[NAMESPACE]", "[SERVICE]", "[ENDPOINT]");
    List<String> permissions = new ArrayList<>();
    TestIamPermissionsRequest request =
        TestIamPermissionsRequest.newBuilder()
            .setResource(resource.toString())
            .addAllPermissions(permissions)
            .build();

    TestIamPermissionsResponse actualResponse = client.testIamPermissions(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRegistrationService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    TestIamPermissionsRequest actualRequest = (TestIamPermissionsRequest) actualRequests.get(0);

    Assert.assertEquals(Objects.toString(resource), Objects.toString(actualRequest.getResource()));
    Assert.assertEquals(permissions, actualRequest.getPermissionsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void testIamPermissionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockRegistrationService.addException(exception);

    try {
      ResourceName resource =
          EndpointName.of("[PROJECT]", "[LOCATION]", "[NAMESPACE]", "[SERVICE]", "[ENDPOINT]");
      List<String> permissions = new ArrayList<>();
      TestIamPermissionsRequest request =
          TestIamPermissionsRequest.newBuilder()
              .setResource(resource.toString())
              .addAllPermissions(permissions)
              .build();

      client.testIamPermissions(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }
}
