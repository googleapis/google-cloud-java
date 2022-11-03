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

package com.google.cloud.servicedirectory.v1;

import static com.google.cloud.servicedirectory.v1.RegistrationServiceClient.ListEndpointsPagedResponse;
import static com.google.cloud.servicedirectory.v1.RegistrationServiceClient.ListNamespacesPagedResponse;
import static com.google.cloud.servicedirectory.v1.RegistrationServiceClient.ListServicesPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.servicedirectory.v1.stub.HttpJsonRegistrationServiceStub;
import com.google.common.collect.Lists;
import com.google.iam.v1.AuditConfig;
import com.google.iam.v1.Binding;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.GetPolicyOptions;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.ByteString;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class RegistrationServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static RegistrationServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonRegistrationServiceStub.getMethodDescriptors(),
            RegistrationServiceSettings.getDefaultEndpoint());
    RegistrationServiceSettings settings =
        RegistrationServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                RegistrationServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = RegistrationServiceClient.create(settings);
  }

  @AfterClass
  public static void stopServer() {
    client.close();
  }

  @Before
  public void setUp() {}

  @After
  public void tearDown() throws Exception {
    mockService.reset();
  }

  @Test
  public void createNamespaceTest() throws Exception {
    Namespace expectedResponse =
        Namespace.newBuilder()
            .setName(NamespaceName.of("[PROJECT]", "[LOCATION]", "[NAMESPACE]").toString())
            .putAllLabels(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Namespace namespace = Namespace.newBuilder().build();
    String namespaceId = "namespaceId790852566";

    Namespace actualResponse = client.createNamespace(parent, namespace, namespaceId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createNamespaceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Namespace namespace = Namespace.newBuilder().build();
      String namespaceId = "namespaceId790852566";
      client.createNamespace(parent, namespace, namespaceId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createNamespaceTest2() throws Exception {
    Namespace expectedResponse =
        Namespace.newBuilder()
            .setName(NamespaceName.of("[PROJECT]", "[LOCATION]", "[NAMESPACE]").toString())
            .putAllLabels(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";
    Namespace namespace = Namespace.newBuilder().build();
    String namespaceId = "namespaceId790852566";

    Namespace actualResponse = client.createNamespace(parent, namespace, namespaceId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createNamespaceExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      Namespace namespace = Namespace.newBuilder().build();
      String namespaceId = "namespaceId790852566";
      client.createNamespace(parent, namespace, namespaceId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listNamespacesTest() throws Exception {
    Namespace responsesElement = Namespace.newBuilder().build();
    ListNamespacesResponse expectedResponse =
        ListNamespacesResponse.newBuilder()
            .setNextPageToken("")
            .addAllNamespaces(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListNamespacesPagedResponse pagedListResponse = client.listNamespaces(parent);

    List<Namespace> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getNamespacesList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listNamespacesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listNamespaces(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listNamespacesTest2() throws Exception {
    Namespace responsesElement = Namespace.newBuilder().build();
    ListNamespacesResponse expectedResponse =
        ListNamespacesResponse.newBuilder()
            .setNextPageToken("")
            .addAllNamespaces(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListNamespacesPagedResponse pagedListResponse = client.listNamespaces(parent);

    List<Namespace> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getNamespacesList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listNamespacesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listNamespaces(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getNamespaceTest() throws Exception {
    Namespace expectedResponse =
        Namespace.newBuilder()
            .setName(NamespaceName.of("[PROJECT]", "[LOCATION]", "[NAMESPACE]").toString())
            .putAllLabels(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    NamespaceName name = NamespaceName.of("[PROJECT]", "[LOCATION]", "[NAMESPACE]");

    Namespace actualResponse = client.getNamespace(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getNamespaceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NamespaceName name = NamespaceName.of("[PROJECT]", "[LOCATION]", "[NAMESPACE]");
      client.getNamespace(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getNamespaceTest2() throws Exception {
    Namespace expectedResponse =
        Namespace.newBuilder()
            .setName(NamespaceName.of("[PROJECT]", "[LOCATION]", "[NAMESPACE]").toString())
            .putAllLabels(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-9720/locations/location-9720/namespaces/namespace-9720";

    Namespace actualResponse = client.getNamespace(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getNamespaceExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-9720/locations/location-9720/namespaces/namespace-9720";
      client.getNamespace(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateNamespaceTest() throws Exception {
    Namespace expectedResponse =
        Namespace.newBuilder()
            .setName(NamespaceName.of("[PROJECT]", "[LOCATION]", "[NAMESPACE]").toString())
            .putAllLabels(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    Namespace namespace =
        Namespace.newBuilder()
            .setName(NamespaceName.of("[PROJECT]", "[LOCATION]", "[NAMESPACE]").toString())
            .putAllLabels(new HashMap<String, String>())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Namespace actualResponse = client.updateNamespace(namespace, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void updateNamespaceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Namespace namespace =
          Namespace.newBuilder()
              .setName(NamespaceName.of("[PROJECT]", "[LOCATION]", "[NAMESPACE]").toString())
              .putAllLabels(new HashMap<String, String>())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateNamespace(namespace, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteNamespaceTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    NamespaceName name = NamespaceName.of("[PROJECT]", "[LOCATION]", "[NAMESPACE]");

    client.deleteNamespace(name);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteNamespaceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NamespaceName name = NamespaceName.of("[PROJECT]", "[LOCATION]", "[NAMESPACE]");
      client.deleteNamespace(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteNamespaceTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-9720/locations/location-9720/namespaces/namespace-9720";

    client.deleteNamespace(name);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteNamespaceExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-9720/locations/location-9720/namespaces/namespace-9720";
      client.deleteNamespace(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createServiceTest() throws Exception {
    Service expectedResponse =
        Service.newBuilder()
            .setName(
                ServiceName.of("[PROJECT]", "[LOCATION]", "[NAMESPACE]", "[SERVICE]").toString())
            .putAllAnnotations(new HashMap<String, String>())
            .addAllEndpoints(new ArrayList<Endpoint>())
            .build();
    mockService.addResponse(expectedResponse);

    NamespaceName parent = NamespaceName.of("[PROJECT]", "[LOCATION]", "[NAMESPACE]");
    Service service = Service.newBuilder().build();
    String serviceId = "serviceId-194185552";

    Service actualResponse = client.createService(parent, service, serviceId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createServiceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NamespaceName parent = NamespaceName.of("[PROJECT]", "[LOCATION]", "[NAMESPACE]");
      Service service = Service.newBuilder().build();
      String serviceId = "serviceId-194185552";
      client.createService(parent, service, serviceId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createServiceTest2() throws Exception {
    Service expectedResponse =
        Service.newBuilder()
            .setName(
                ServiceName.of("[PROJECT]", "[LOCATION]", "[NAMESPACE]", "[SERVICE]").toString())
            .putAllAnnotations(new HashMap<String, String>())
            .addAllEndpoints(new ArrayList<Endpoint>())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-1689/locations/location-1689/namespaces/namespace-1689";
    Service service = Service.newBuilder().build();
    String serviceId = "serviceId-194185552";

    Service actualResponse = client.createService(parent, service, serviceId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createServiceExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-1689/locations/location-1689/namespaces/namespace-1689";
      Service service = Service.newBuilder().build();
      String serviceId = "serviceId-194185552";
      client.createService(parent, service, serviceId);
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
    mockService.addResponse(expectedResponse);

    NamespaceName parent = NamespaceName.of("[PROJECT]", "[LOCATION]", "[NAMESPACE]");

    ListServicesPagedResponse pagedListResponse = client.listServices(parent);

    List<Service> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getServicesList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listServicesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NamespaceName parent = NamespaceName.of("[PROJECT]", "[LOCATION]", "[NAMESPACE]");
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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-1689/locations/location-1689/namespaces/namespace-1689";

    ListServicesPagedResponse pagedListResponse = client.listServices(parent);

    List<Service> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getServicesList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listServicesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-1689/locations/location-1689/namespaces/namespace-1689";
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
            .setName(
                ServiceName.of("[PROJECT]", "[LOCATION]", "[NAMESPACE]", "[SERVICE]").toString())
            .putAllAnnotations(new HashMap<String, String>())
            .addAllEndpoints(new ArrayList<Endpoint>())
            .build();
    mockService.addResponse(expectedResponse);

    ServiceName name = ServiceName.of("[PROJECT]", "[LOCATION]", "[NAMESPACE]", "[SERVICE]");

    Service actualResponse = client.getService(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getServiceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ServiceName name = ServiceName.of("[PROJECT]", "[LOCATION]", "[NAMESPACE]", "[SERVICE]");
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
            .setName(
                ServiceName.of("[PROJECT]", "[LOCATION]", "[NAMESPACE]", "[SERVICE]").toString())
            .putAllAnnotations(new HashMap<String, String>())
            .addAllEndpoints(new ArrayList<Endpoint>())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-160/locations/location-160/namespaces/namespace-160/services/service-160";

    Service actualResponse = client.getService(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getServiceExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-160/locations/location-160/namespaces/namespace-160/services/service-160";
      client.getService(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateServiceTest() throws Exception {
    Service expectedResponse =
        Service.newBuilder()
            .setName(
                ServiceName.of("[PROJECT]", "[LOCATION]", "[NAMESPACE]", "[SERVICE]").toString())
            .putAllAnnotations(new HashMap<String, String>())
            .addAllEndpoints(new ArrayList<Endpoint>())
            .build();
    mockService.addResponse(expectedResponse);

    Service service =
        Service.newBuilder()
            .setName(
                ServiceName.of("[PROJECT]", "[LOCATION]", "[NAMESPACE]", "[SERVICE]").toString())
            .putAllAnnotations(new HashMap<String, String>())
            .addAllEndpoints(new ArrayList<Endpoint>())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Service actualResponse = client.updateService(service, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void updateServiceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Service service =
          Service.newBuilder()
              .setName(
                  ServiceName.of("[PROJECT]", "[LOCATION]", "[NAMESPACE]", "[SERVICE]").toString())
              .putAllAnnotations(new HashMap<String, String>())
              .addAllEndpoints(new ArrayList<Endpoint>())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateService(service, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteServiceTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    ServiceName name = ServiceName.of("[PROJECT]", "[LOCATION]", "[NAMESPACE]", "[SERVICE]");

    client.deleteService(name);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteServiceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ServiceName name = ServiceName.of("[PROJECT]", "[LOCATION]", "[NAMESPACE]", "[SERVICE]");
      client.deleteService(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteServiceTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-160/locations/location-160/namespaces/namespace-160/services/service-160";

    client.deleteService(name);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteServiceExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-160/locations/location-160/namespaces/namespace-160/services/service-160";
      client.deleteService(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createEndpointTest() throws Exception {
    Endpoint expectedResponse =
        Endpoint.newBuilder()
            .setName(
                EndpointName.of("[PROJECT]", "[LOCATION]", "[NAMESPACE]", "[SERVICE]", "[ENDPOINT]")
                    .toString())
            .setAddress("address-1147692044")
            .setPort(3446913)
            .putAllAnnotations(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    ServiceName parent = ServiceName.of("[PROJECT]", "[LOCATION]", "[NAMESPACE]", "[SERVICE]");
    Endpoint endpoint = Endpoint.newBuilder().build();
    String endpointId = "endpointId-1837754992";

    Endpoint actualResponse = client.createEndpoint(parent, endpoint, endpointId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createEndpointExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ServiceName parent = ServiceName.of("[PROJECT]", "[LOCATION]", "[NAMESPACE]", "[SERVICE]");
      Endpoint endpoint = Endpoint.newBuilder().build();
      String endpointId = "endpointId-1837754992";
      client.createEndpoint(parent, endpoint, endpointId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createEndpointTest2() throws Exception {
    Endpoint expectedResponse =
        Endpoint.newBuilder()
            .setName(
                EndpointName.of("[PROJECT]", "[LOCATION]", "[NAMESPACE]", "[SERVICE]", "[ENDPOINT]")
                    .toString())
            .setAddress("address-1147692044")
            .setPort(3446913)
            .putAllAnnotations(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    String parent =
        "projects/project-4575/locations/location-4575/namespaces/namespace-4575/services/service-4575";
    Endpoint endpoint = Endpoint.newBuilder().build();
    String endpointId = "endpointId-1837754992";

    Endpoint actualResponse = client.createEndpoint(parent, endpoint, endpointId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createEndpointExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-4575/locations/location-4575/namespaces/namespace-4575/services/service-4575";
      Endpoint endpoint = Endpoint.newBuilder().build();
      String endpointId = "endpointId-1837754992";
      client.createEndpoint(parent, endpoint, endpointId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listEndpointsTest() throws Exception {
    Endpoint responsesElement = Endpoint.newBuilder().build();
    ListEndpointsResponse expectedResponse =
        ListEndpointsResponse.newBuilder()
            .setNextPageToken("")
            .addAllEndpoints(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    ServiceName parent = ServiceName.of("[PROJECT]", "[LOCATION]", "[NAMESPACE]", "[SERVICE]");

    ListEndpointsPagedResponse pagedListResponse = client.listEndpoints(parent);

    List<Endpoint> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEndpointsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listEndpointsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ServiceName parent = ServiceName.of("[PROJECT]", "[LOCATION]", "[NAMESPACE]", "[SERVICE]");
      client.listEndpoints(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listEndpointsTest2() throws Exception {
    Endpoint responsesElement = Endpoint.newBuilder().build();
    ListEndpointsResponse expectedResponse =
        ListEndpointsResponse.newBuilder()
            .setNextPageToken("")
            .addAllEndpoints(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent =
        "projects/project-4575/locations/location-4575/namespaces/namespace-4575/services/service-4575";

    ListEndpointsPagedResponse pagedListResponse = client.listEndpoints(parent);

    List<Endpoint> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEndpointsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listEndpointsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-4575/locations/location-4575/namespaces/namespace-4575/services/service-4575";
      client.listEndpoints(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getEndpointTest() throws Exception {
    Endpoint expectedResponse =
        Endpoint.newBuilder()
            .setName(
                EndpointName.of("[PROJECT]", "[LOCATION]", "[NAMESPACE]", "[SERVICE]", "[ENDPOINT]")
                    .toString())
            .setAddress("address-1147692044")
            .setPort(3446913)
            .putAllAnnotations(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    EndpointName name =
        EndpointName.of("[PROJECT]", "[LOCATION]", "[NAMESPACE]", "[SERVICE]", "[ENDPOINT]");

    Endpoint actualResponse = client.getEndpoint(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getEndpointExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      EndpointName name =
          EndpointName.of("[PROJECT]", "[LOCATION]", "[NAMESPACE]", "[SERVICE]", "[ENDPOINT]");
      client.getEndpoint(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getEndpointTest2() throws Exception {
    Endpoint expectedResponse =
        Endpoint.newBuilder()
            .setName(
                EndpointName.of("[PROJECT]", "[LOCATION]", "[NAMESPACE]", "[SERVICE]", "[ENDPOINT]")
                    .toString())
            .setAddress("address-1147692044")
            .setPort(3446913)
            .putAllAnnotations(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-9594/locations/location-9594/namespaces/namespace-9594/services/service-9594/endpoints/endpoint-9594";

    Endpoint actualResponse = client.getEndpoint(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getEndpointExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-9594/locations/location-9594/namespaces/namespace-9594/services/service-9594/endpoints/endpoint-9594";
      client.getEndpoint(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateEndpointTest() throws Exception {
    Endpoint expectedResponse =
        Endpoint.newBuilder()
            .setName(
                EndpointName.of("[PROJECT]", "[LOCATION]", "[NAMESPACE]", "[SERVICE]", "[ENDPOINT]")
                    .toString())
            .setAddress("address-1147692044")
            .setPort(3446913)
            .putAllAnnotations(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    Endpoint endpoint =
        Endpoint.newBuilder()
            .setName(
                EndpointName.of("[PROJECT]", "[LOCATION]", "[NAMESPACE]", "[SERVICE]", "[ENDPOINT]")
                    .toString())
            .setAddress("address-1147692044")
            .setPort(3446913)
            .putAllAnnotations(new HashMap<String, String>())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Endpoint actualResponse = client.updateEndpoint(endpoint, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void updateEndpointExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Endpoint endpoint =
          Endpoint.newBuilder()
              .setName(
                  EndpointName.of(
                          "[PROJECT]", "[LOCATION]", "[NAMESPACE]", "[SERVICE]", "[ENDPOINT]")
                      .toString())
              .setAddress("address-1147692044")
              .setPort(3446913)
              .putAllAnnotations(new HashMap<String, String>())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateEndpoint(endpoint, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteEndpointTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    EndpointName name =
        EndpointName.of("[PROJECT]", "[LOCATION]", "[NAMESPACE]", "[SERVICE]", "[ENDPOINT]");

    client.deleteEndpoint(name);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteEndpointExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      EndpointName name =
          EndpointName.of("[PROJECT]", "[LOCATION]", "[NAMESPACE]", "[SERVICE]", "[ENDPOINT]");
      client.deleteEndpoint(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteEndpointTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-9594/locations/location-9594/namespaces/namespace-9594/services/service-9594/endpoints/endpoint-9594";

    client.deleteEndpoint(name);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteEndpointExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-9594/locations/location-9594/namespaces/namespace-9594/services/service-9594/endpoints/endpoint-9594";
      client.deleteEndpoint(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getIamPolicyTest() throws Exception {
    Policy expectedResponse =
        Policy.newBuilder()
            .setVersion(351608024)
            .addAllBindings(new ArrayList<Binding>())
            .addAllAuditConfigs(new ArrayList<AuditConfig>())
            .setEtag(ByteString.EMPTY)
            .build();
    mockService.addResponse(expectedResponse);

    GetIamPolicyRequest request =
        GetIamPolicyRequest.newBuilder()
            .setResource(NamespaceName.of("[PROJECT]", "[LOCATION]", "[NAMESPACE]").toString())
            .setOptions(GetPolicyOptions.newBuilder().build())
            .build();

    Policy actualResponse = client.getIamPolicy(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getIamPolicyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GetIamPolicyRequest request =
          GetIamPolicyRequest.newBuilder()
              .setResource(NamespaceName.of("[PROJECT]", "[LOCATION]", "[NAMESPACE]").toString())
              .setOptions(GetPolicyOptions.newBuilder().build())
              .build();
      client.getIamPolicy(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void setIamPolicyTest() throws Exception {
    Policy expectedResponse =
        Policy.newBuilder()
            .setVersion(351608024)
            .addAllBindings(new ArrayList<Binding>())
            .addAllAuditConfigs(new ArrayList<AuditConfig>())
            .setEtag(ByteString.EMPTY)
            .build();
    mockService.addResponse(expectedResponse);

    SetIamPolicyRequest request =
        SetIamPolicyRequest.newBuilder()
            .setResource(NamespaceName.of("[PROJECT]", "[LOCATION]", "[NAMESPACE]").toString())
            .setPolicy(Policy.newBuilder().build())
            .setUpdateMask(FieldMask.newBuilder().build())
            .build();

    Policy actualResponse = client.setIamPolicy(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void setIamPolicyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SetIamPolicyRequest request =
          SetIamPolicyRequest.newBuilder()
              .setResource(NamespaceName.of("[PROJECT]", "[LOCATION]", "[NAMESPACE]").toString())
              .setPolicy(Policy.newBuilder().build())
              .setUpdateMask(FieldMask.newBuilder().build())
              .build();
      client.setIamPolicy(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void testIamPermissionsTest() throws Exception {
    TestIamPermissionsResponse expectedResponse =
        TestIamPermissionsResponse.newBuilder().addAllPermissions(new ArrayList<String>()).build();
    mockService.addResponse(expectedResponse);

    TestIamPermissionsRequest request =
        TestIamPermissionsRequest.newBuilder()
            .setResource(NamespaceName.of("[PROJECT]", "[LOCATION]", "[NAMESPACE]").toString())
            .addAllPermissions(new ArrayList<String>())
            .build();

    TestIamPermissionsResponse actualResponse = client.testIamPermissions(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void testIamPermissionsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      TestIamPermissionsRequest request =
          TestIamPermissionsRequest.newBuilder()
              .setResource(NamespaceName.of("[PROJECT]", "[LOCATION]", "[NAMESPACE]").toString())
              .addAllPermissions(new ArrayList<String>())
              .build();
      client.testIamPermissions(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
