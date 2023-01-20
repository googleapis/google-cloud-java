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

package com.google.cloud.gkemulticloud.v1;

import static com.google.cloud.gkemulticloud.v1.AzureClustersClient.ListAzureClientsPagedResponse;
import static com.google.cloud.gkemulticloud.v1.AzureClustersClient.ListAzureClustersPagedResponse;
import static com.google.cloud.gkemulticloud.v1.AzureClustersClient.ListAzureNodePoolsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.gkemulticloud.v1.stub.HttpJsonAzureClustersStub;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class AzureClustersClientHttpJsonTest {
  private static MockHttpService mockService;
  private static AzureClustersClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonAzureClustersStub.getMethodDescriptors(),
            AzureClustersSettings.getDefaultEndpoint());
    AzureClustersSettings settings =
        AzureClustersSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                AzureClustersSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = AzureClustersClient.create(settings);
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
  public void createAzureClientTest() throws Exception {
    AzureClient expectedResponse =
        AzureClient.newBuilder()
            .setName(AzureClientName.of("[PROJECT]", "[LOCATION]", "[AZURE_CLIENT]").toString())
            .setTenantId("tenantId-1306693787")
            .setApplicationId("applicationId-1011352949")
            .putAllAnnotations(new HashMap<String, String>())
            .setPemCertificate("pemCertificate153491807")
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createAzureClientTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    AzureClient azureClient = AzureClient.newBuilder().build();
    String azureClientId = "azureClientId-1735934475";

    AzureClient actualResponse =
        client.createAzureClientAsync(parent, azureClient, azureClientId).get();
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
  public void createAzureClientExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      AzureClient azureClient = AzureClient.newBuilder().build();
      String azureClientId = "azureClientId-1735934475";
      client.createAzureClientAsync(parent, azureClient, azureClientId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createAzureClientTest2() throws Exception {
    AzureClient expectedResponse =
        AzureClient.newBuilder()
            .setName(AzureClientName.of("[PROJECT]", "[LOCATION]", "[AZURE_CLIENT]").toString())
            .setTenantId("tenantId-1306693787")
            .setApplicationId("applicationId-1011352949")
            .putAllAnnotations(new HashMap<String, String>())
            .setPemCertificate("pemCertificate153491807")
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createAzureClientTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5833/locations/location-5833";
    AzureClient azureClient = AzureClient.newBuilder().build();
    String azureClientId = "azureClientId-1735934475";

    AzureClient actualResponse =
        client.createAzureClientAsync(parent, azureClient, azureClientId).get();
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
  public void createAzureClientExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      AzureClient azureClient = AzureClient.newBuilder().build();
      String azureClientId = "azureClientId-1735934475";
      client.createAzureClientAsync(parent, azureClient, azureClientId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void getAzureClientTest() throws Exception {
    AzureClient expectedResponse =
        AzureClient.newBuilder()
            .setName(AzureClientName.of("[PROJECT]", "[LOCATION]", "[AZURE_CLIENT]").toString())
            .setTenantId("tenantId-1306693787")
            .setApplicationId("applicationId-1011352949")
            .putAllAnnotations(new HashMap<String, String>())
            .setPemCertificate("pemCertificate153491807")
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    AzureClientName name = AzureClientName.of("[PROJECT]", "[LOCATION]", "[AZURE_CLIENT]");

    AzureClient actualResponse = client.getAzureClient(name);
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
  public void getAzureClientExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AzureClientName name = AzureClientName.of("[PROJECT]", "[LOCATION]", "[AZURE_CLIENT]");
      client.getAzureClient(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAzureClientTest2() throws Exception {
    AzureClient expectedResponse =
        AzureClient.newBuilder()
            .setName(AzureClientName.of("[PROJECT]", "[LOCATION]", "[AZURE_CLIENT]").toString())
            .setTenantId("tenantId-1306693787")
            .setApplicationId("applicationId-1011352949")
            .putAllAnnotations(new HashMap<String, String>())
            .setPemCertificate("pemCertificate153491807")
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-7305/locations/location-7305/azureClients/azureClient-7305";

    AzureClient actualResponse = client.getAzureClient(name);
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
  public void getAzureClientExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-7305/locations/location-7305/azureClients/azureClient-7305";
      client.getAzureClient(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAzureClientsTest() throws Exception {
    AzureClient responsesElement = AzureClient.newBuilder().build();
    ListAzureClientsResponse expectedResponse =
        ListAzureClientsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAzureClients(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListAzureClientsPagedResponse pagedListResponse = client.listAzureClients(parent);

    List<AzureClient> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAzureClientsList().get(0), resources.get(0));

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
  public void listAzureClientsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listAzureClients(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAzureClientsTest2() throws Exception {
    AzureClient responsesElement = AzureClient.newBuilder().build();
    ListAzureClientsResponse expectedResponse =
        ListAzureClientsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAzureClients(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListAzureClientsPagedResponse pagedListResponse = client.listAzureClients(parent);

    List<AzureClient> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAzureClientsList().get(0), resources.get(0));

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
  public void listAzureClientsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listAzureClients(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteAzureClientTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteAzureClientTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    AzureClientName name = AzureClientName.of("[PROJECT]", "[LOCATION]", "[AZURE_CLIENT]");

    client.deleteAzureClientAsync(name).get();

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
  public void deleteAzureClientExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AzureClientName name = AzureClientName.of("[PROJECT]", "[LOCATION]", "[AZURE_CLIENT]");
      client.deleteAzureClientAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteAzureClientTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteAzureClientTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name = "projects/project-7305/locations/location-7305/azureClients/azureClient-7305";

    client.deleteAzureClientAsync(name).get();

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
  public void deleteAzureClientExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-7305/locations/location-7305/azureClients/azureClient-7305";
      client.deleteAzureClientAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createAzureClusterTest() throws Exception {
    AzureCluster expectedResponse =
        AzureCluster.newBuilder()
            .setName(AzureClusterName.of("[PROJECT]", "[LOCATION]", "[AZURE_CLUSTER]").toString())
            .setDescription("description-1724546052")
            .setAzureRegion("azureRegion1270271587")
            .setResourceGroupId("resourceGroupId928392204")
            .setAzureClient("azureClient847354682")
            .setNetworking(AzureClusterNetworking.newBuilder().build())
            .setControlPlane(AzureControlPlane.newBuilder().build())
            .setAuthorization(AzureAuthorization.newBuilder().build())
            .setEndpoint("endpoint1741102485")
            .setUid("uid115792")
            .setReconciling(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .putAllAnnotations(new HashMap<String, String>())
            .setWorkloadIdentityConfig(WorkloadIdentityConfig.newBuilder().build())
            .setClusterCaCertificate("clusterCaCertificate-683492737")
            .setFleet(Fleet.newBuilder().build())
            .setManagedResources(AzureClusterResources.newBuilder().build())
            .setLoggingConfig(LoggingConfig.newBuilder().build())
            .addAllErrors(new ArrayList<AzureClusterError>())
            .setMonitoringConfig(MonitoringConfig.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createAzureClusterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    AzureCluster azureCluster = AzureCluster.newBuilder().build();
    String azureClusterId = "azureClusterId191689446";

    AzureCluster actualResponse =
        client.createAzureClusterAsync(parent, azureCluster, azureClusterId).get();
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
  public void createAzureClusterExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      AzureCluster azureCluster = AzureCluster.newBuilder().build();
      String azureClusterId = "azureClusterId191689446";
      client.createAzureClusterAsync(parent, azureCluster, azureClusterId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createAzureClusterTest2() throws Exception {
    AzureCluster expectedResponse =
        AzureCluster.newBuilder()
            .setName(AzureClusterName.of("[PROJECT]", "[LOCATION]", "[AZURE_CLUSTER]").toString())
            .setDescription("description-1724546052")
            .setAzureRegion("azureRegion1270271587")
            .setResourceGroupId("resourceGroupId928392204")
            .setAzureClient("azureClient847354682")
            .setNetworking(AzureClusterNetworking.newBuilder().build())
            .setControlPlane(AzureControlPlane.newBuilder().build())
            .setAuthorization(AzureAuthorization.newBuilder().build())
            .setEndpoint("endpoint1741102485")
            .setUid("uid115792")
            .setReconciling(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .putAllAnnotations(new HashMap<String, String>())
            .setWorkloadIdentityConfig(WorkloadIdentityConfig.newBuilder().build())
            .setClusterCaCertificate("clusterCaCertificate-683492737")
            .setFleet(Fleet.newBuilder().build())
            .setManagedResources(AzureClusterResources.newBuilder().build())
            .setLoggingConfig(LoggingConfig.newBuilder().build())
            .addAllErrors(new ArrayList<AzureClusterError>())
            .setMonitoringConfig(MonitoringConfig.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createAzureClusterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5833/locations/location-5833";
    AzureCluster azureCluster = AzureCluster.newBuilder().build();
    String azureClusterId = "azureClusterId191689446";

    AzureCluster actualResponse =
        client.createAzureClusterAsync(parent, azureCluster, azureClusterId).get();
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
  public void createAzureClusterExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      AzureCluster azureCluster = AzureCluster.newBuilder().build();
      String azureClusterId = "azureClusterId191689446";
      client.createAzureClusterAsync(parent, azureCluster, azureClusterId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void updateAzureClusterTest() throws Exception {
    AzureCluster expectedResponse =
        AzureCluster.newBuilder()
            .setName(AzureClusterName.of("[PROJECT]", "[LOCATION]", "[AZURE_CLUSTER]").toString())
            .setDescription("description-1724546052")
            .setAzureRegion("azureRegion1270271587")
            .setResourceGroupId("resourceGroupId928392204")
            .setAzureClient("azureClient847354682")
            .setNetworking(AzureClusterNetworking.newBuilder().build())
            .setControlPlane(AzureControlPlane.newBuilder().build())
            .setAuthorization(AzureAuthorization.newBuilder().build())
            .setEndpoint("endpoint1741102485")
            .setUid("uid115792")
            .setReconciling(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .putAllAnnotations(new HashMap<String, String>())
            .setWorkloadIdentityConfig(WorkloadIdentityConfig.newBuilder().build())
            .setClusterCaCertificate("clusterCaCertificate-683492737")
            .setFleet(Fleet.newBuilder().build())
            .setManagedResources(AzureClusterResources.newBuilder().build())
            .setLoggingConfig(LoggingConfig.newBuilder().build())
            .addAllErrors(new ArrayList<AzureClusterError>())
            .setMonitoringConfig(MonitoringConfig.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateAzureClusterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    AzureCluster azureCluster =
        AzureCluster.newBuilder()
            .setName(AzureClusterName.of("[PROJECT]", "[LOCATION]", "[AZURE_CLUSTER]").toString())
            .setDescription("description-1724546052")
            .setAzureRegion("azureRegion1270271587")
            .setResourceGroupId("resourceGroupId928392204")
            .setAzureClient("azureClient847354682")
            .setNetworking(AzureClusterNetworking.newBuilder().build())
            .setControlPlane(AzureControlPlane.newBuilder().build())
            .setAuthorization(AzureAuthorization.newBuilder().build())
            .setEndpoint("endpoint1741102485")
            .setUid("uid115792")
            .setReconciling(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .putAllAnnotations(new HashMap<String, String>())
            .setWorkloadIdentityConfig(WorkloadIdentityConfig.newBuilder().build())
            .setClusterCaCertificate("clusterCaCertificate-683492737")
            .setFleet(Fleet.newBuilder().build())
            .setManagedResources(AzureClusterResources.newBuilder().build())
            .setLoggingConfig(LoggingConfig.newBuilder().build())
            .addAllErrors(new ArrayList<AzureClusterError>())
            .setMonitoringConfig(MonitoringConfig.newBuilder().build())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    AzureCluster actualResponse = client.updateAzureClusterAsync(azureCluster, updateMask).get();
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
  public void updateAzureClusterExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AzureCluster azureCluster =
          AzureCluster.newBuilder()
              .setName(AzureClusterName.of("[PROJECT]", "[LOCATION]", "[AZURE_CLUSTER]").toString())
              .setDescription("description-1724546052")
              .setAzureRegion("azureRegion1270271587")
              .setResourceGroupId("resourceGroupId928392204")
              .setAzureClient("azureClient847354682")
              .setNetworking(AzureClusterNetworking.newBuilder().build())
              .setControlPlane(AzureControlPlane.newBuilder().build())
              .setAuthorization(AzureAuthorization.newBuilder().build())
              .setEndpoint("endpoint1741102485")
              .setUid("uid115792")
              .setReconciling(true)
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .setEtag("etag3123477")
              .putAllAnnotations(new HashMap<String, String>())
              .setWorkloadIdentityConfig(WorkloadIdentityConfig.newBuilder().build())
              .setClusterCaCertificate("clusterCaCertificate-683492737")
              .setFleet(Fleet.newBuilder().build())
              .setManagedResources(AzureClusterResources.newBuilder().build())
              .setLoggingConfig(LoggingConfig.newBuilder().build())
              .addAllErrors(new ArrayList<AzureClusterError>())
              .setMonitoringConfig(MonitoringConfig.newBuilder().build())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateAzureClusterAsync(azureCluster, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void getAzureClusterTest() throws Exception {
    AzureCluster expectedResponse =
        AzureCluster.newBuilder()
            .setName(AzureClusterName.of("[PROJECT]", "[LOCATION]", "[AZURE_CLUSTER]").toString())
            .setDescription("description-1724546052")
            .setAzureRegion("azureRegion1270271587")
            .setResourceGroupId("resourceGroupId928392204")
            .setAzureClient("azureClient847354682")
            .setNetworking(AzureClusterNetworking.newBuilder().build())
            .setControlPlane(AzureControlPlane.newBuilder().build())
            .setAuthorization(AzureAuthorization.newBuilder().build())
            .setEndpoint("endpoint1741102485")
            .setUid("uid115792")
            .setReconciling(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .putAllAnnotations(new HashMap<String, String>())
            .setWorkloadIdentityConfig(WorkloadIdentityConfig.newBuilder().build())
            .setClusterCaCertificate("clusterCaCertificate-683492737")
            .setFleet(Fleet.newBuilder().build())
            .setManagedResources(AzureClusterResources.newBuilder().build())
            .setLoggingConfig(LoggingConfig.newBuilder().build())
            .addAllErrors(new ArrayList<AzureClusterError>())
            .setMonitoringConfig(MonitoringConfig.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    AzureClusterName name = AzureClusterName.of("[PROJECT]", "[LOCATION]", "[AZURE_CLUSTER]");

    AzureCluster actualResponse = client.getAzureCluster(name);
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
  public void getAzureClusterExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AzureClusterName name = AzureClusterName.of("[PROJECT]", "[LOCATION]", "[AZURE_CLUSTER]");
      client.getAzureCluster(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAzureClusterTest2() throws Exception {
    AzureCluster expectedResponse =
        AzureCluster.newBuilder()
            .setName(AzureClusterName.of("[PROJECT]", "[LOCATION]", "[AZURE_CLUSTER]").toString())
            .setDescription("description-1724546052")
            .setAzureRegion("azureRegion1270271587")
            .setResourceGroupId("resourceGroupId928392204")
            .setAzureClient("azureClient847354682")
            .setNetworking(AzureClusterNetworking.newBuilder().build())
            .setControlPlane(AzureControlPlane.newBuilder().build())
            .setAuthorization(AzureAuthorization.newBuilder().build())
            .setEndpoint("endpoint1741102485")
            .setUid("uid115792")
            .setReconciling(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .putAllAnnotations(new HashMap<String, String>())
            .setWorkloadIdentityConfig(WorkloadIdentityConfig.newBuilder().build())
            .setClusterCaCertificate("clusterCaCertificate-683492737")
            .setFleet(Fleet.newBuilder().build())
            .setManagedResources(AzureClusterResources.newBuilder().build())
            .setLoggingConfig(LoggingConfig.newBuilder().build())
            .addAllErrors(new ArrayList<AzureClusterError>())
            .setMonitoringConfig(MonitoringConfig.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-6894/locations/location-6894/azureClusters/azureCluster-6894";

    AzureCluster actualResponse = client.getAzureCluster(name);
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
  public void getAzureClusterExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-6894/locations/location-6894/azureClusters/azureCluster-6894";
      client.getAzureCluster(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAzureClustersTest() throws Exception {
    AzureCluster responsesElement = AzureCluster.newBuilder().build();
    ListAzureClustersResponse expectedResponse =
        ListAzureClustersResponse.newBuilder()
            .setNextPageToken("")
            .addAllAzureClusters(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListAzureClustersPagedResponse pagedListResponse = client.listAzureClusters(parent);

    List<AzureCluster> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAzureClustersList().get(0), resources.get(0));

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
  public void listAzureClustersExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listAzureClusters(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAzureClustersTest2() throws Exception {
    AzureCluster responsesElement = AzureCluster.newBuilder().build();
    ListAzureClustersResponse expectedResponse =
        ListAzureClustersResponse.newBuilder()
            .setNextPageToken("")
            .addAllAzureClusters(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListAzureClustersPagedResponse pagedListResponse = client.listAzureClusters(parent);

    List<AzureCluster> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAzureClustersList().get(0), resources.get(0));

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
  public void listAzureClustersExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listAzureClusters(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteAzureClusterTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteAzureClusterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    AzureClusterName name = AzureClusterName.of("[PROJECT]", "[LOCATION]", "[AZURE_CLUSTER]");

    client.deleteAzureClusterAsync(name).get();

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
  public void deleteAzureClusterExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AzureClusterName name = AzureClusterName.of("[PROJECT]", "[LOCATION]", "[AZURE_CLUSTER]");
      client.deleteAzureClusterAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteAzureClusterTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteAzureClusterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name = "projects/project-6894/locations/location-6894/azureClusters/azureCluster-6894";

    client.deleteAzureClusterAsync(name).get();

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
  public void deleteAzureClusterExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-6894/locations/location-6894/azureClusters/azureCluster-6894";
      client.deleteAzureClusterAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void generateAzureAccessTokenTest() throws Exception {
    GenerateAzureAccessTokenResponse expectedResponse =
        GenerateAzureAccessTokenResponse.newBuilder()
            .setAccessToken("accessToken-1042689291")
            .setExpirationTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    GenerateAzureAccessTokenRequest request =
        GenerateAzureAccessTokenRequest.newBuilder()
            .setAzureCluster(
                AzureClusterName.of("[PROJECT]", "[LOCATION]", "[AZURE_CLUSTER]").toString())
            .build();

    GenerateAzureAccessTokenResponse actualResponse = client.generateAzureAccessToken(request);
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
  public void generateAzureAccessTokenExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GenerateAzureAccessTokenRequest request =
          GenerateAzureAccessTokenRequest.newBuilder()
              .setAzureCluster(
                  AzureClusterName.of("[PROJECT]", "[LOCATION]", "[AZURE_CLUSTER]").toString())
              .build();
      client.generateAzureAccessToken(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createAzureNodePoolTest() throws Exception {
    AzureNodePool expectedResponse =
        AzureNodePool.newBuilder()
            .setName(
                AzureNodePoolName.of(
                        "[PROJECT]", "[LOCATION]", "[AZURE_CLUSTER]", "[AZURE_NODE_POOL]")
                    .toString())
            .setVersion("version351608024")
            .setConfig(AzureNodeConfig.newBuilder().build())
            .setSubnetId("subnetId-2066159272")
            .setAutoscaling(AzureNodePoolAutoscaling.newBuilder().build())
            .setUid("uid115792")
            .setReconciling(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .putAllAnnotations(new HashMap<String, String>())
            .setMaxPodsConstraint(MaxPodsConstraint.newBuilder().build())
            .setAzureAvailabilityZone("azureAvailabilityZone-304222122")
            .addAllErrors(new ArrayList<AzureNodePoolError>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createAzureNodePoolTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    AzureClusterName parent = AzureClusterName.of("[PROJECT]", "[LOCATION]", "[AZURE_CLUSTER]");
    AzureNodePool azureNodePool = AzureNodePool.newBuilder().build();
    String azureNodePoolId = "azureNodePoolId-1766264088";

    AzureNodePool actualResponse =
        client.createAzureNodePoolAsync(parent, azureNodePool, azureNodePoolId).get();
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
  public void createAzureNodePoolExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AzureClusterName parent = AzureClusterName.of("[PROJECT]", "[LOCATION]", "[AZURE_CLUSTER]");
      AzureNodePool azureNodePool = AzureNodePool.newBuilder().build();
      String azureNodePoolId = "azureNodePoolId-1766264088";
      client.createAzureNodePoolAsync(parent, azureNodePool, azureNodePoolId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createAzureNodePoolTest2() throws Exception {
    AzureNodePool expectedResponse =
        AzureNodePool.newBuilder()
            .setName(
                AzureNodePoolName.of(
                        "[PROJECT]", "[LOCATION]", "[AZURE_CLUSTER]", "[AZURE_NODE_POOL]")
                    .toString())
            .setVersion("version351608024")
            .setConfig(AzureNodeConfig.newBuilder().build())
            .setSubnetId("subnetId-2066159272")
            .setAutoscaling(AzureNodePoolAutoscaling.newBuilder().build())
            .setUid("uid115792")
            .setReconciling(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .putAllAnnotations(new HashMap<String, String>())
            .setMaxPodsConstraint(MaxPodsConstraint.newBuilder().build())
            .setAzureAvailabilityZone("azureAvailabilityZone-304222122")
            .addAllErrors(new ArrayList<AzureNodePoolError>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createAzureNodePoolTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-9011/locations/location-9011/azureClusters/azureCluster-9011";
    AzureNodePool azureNodePool = AzureNodePool.newBuilder().build();
    String azureNodePoolId = "azureNodePoolId-1766264088";

    AzureNodePool actualResponse =
        client.createAzureNodePoolAsync(parent, azureNodePool, azureNodePoolId).get();
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
  public void createAzureNodePoolExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-9011/locations/location-9011/azureClusters/azureCluster-9011";
      AzureNodePool azureNodePool = AzureNodePool.newBuilder().build();
      String azureNodePoolId = "azureNodePoolId-1766264088";
      client.createAzureNodePoolAsync(parent, azureNodePool, azureNodePoolId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void updateAzureNodePoolTest() throws Exception {
    AzureNodePool expectedResponse =
        AzureNodePool.newBuilder()
            .setName(
                AzureNodePoolName.of(
                        "[PROJECT]", "[LOCATION]", "[AZURE_CLUSTER]", "[AZURE_NODE_POOL]")
                    .toString())
            .setVersion("version351608024")
            .setConfig(AzureNodeConfig.newBuilder().build())
            .setSubnetId("subnetId-2066159272")
            .setAutoscaling(AzureNodePoolAutoscaling.newBuilder().build())
            .setUid("uid115792")
            .setReconciling(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .putAllAnnotations(new HashMap<String, String>())
            .setMaxPodsConstraint(MaxPodsConstraint.newBuilder().build())
            .setAzureAvailabilityZone("azureAvailabilityZone-304222122")
            .addAllErrors(new ArrayList<AzureNodePoolError>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateAzureNodePoolTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    AzureNodePool azureNodePool =
        AzureNodePool.newBuilder()
            .setName(
                AzureNodePoolName.of(
                        "[PROJECT]", "[LOCATION]", "[AZURE_CLUSTER]", "[AZURE_NODE_POOL]")
                    .toString())
            .setVersion("version351608024")
            .setConfig(AzureNodeConfig.newBuilder().build())
            .setSubnetId("subnetId-2066159272")
            .setAutoscaling(AzureNodePoolAutoscaling.newBuilder().build())
            .setUid("uid115792")
            .setReconciling(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .putAllAnnotations(new HashMap<String, String>())
            .setMaxPodsConstraint(MaxPodsConstraint.newBuilder().build())
            .setAzureAvailabilityZone("azureAvailabilityZone-304222122")
            .addAllErrors(new ArrayList<AzureNodePoolError>())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    AzureNodePool actualResponse = client.updateAzureNodePoolAsync(azureNodePool, updateMask).get();
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
  public void updateAzureNodePoolExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AzureNodePool azureNodePool =
          AzureNodePool.newBuilder()
              .setName(
                  AzureNodePoolName.of(
                          "[PROJECT]", "[LOCATION]", "[AZURE_CLUSTER]", "[AZURE_NODE_POOL]")
                      .toString())
              .setVersion("version351608024")
              .setConfig(AzureNodeConfig.newBuilder().build())
              .setSubnetId("subnetId-2066159272")
              .setAutoscaling(AzureNodePoolAutoscaling.newBuilder().build())
              .setUid("uid115792")
              .setReconciling(true)
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .setEtag("etag3123477")
              .putAllAnnotations(new HashMap<String, String>())
              .setMaxPodsConstraint(MaxPodsConstraint.newBuilder().build())
              .setAzureAvailabilityZone("azureAvailabilityZone-304222122")
              .addAllErrors(new ArrayList<AzureNodePoolError>())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateAzureNodePoolAsync(azureNodePool, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void getAzureNodePoolTest() throws Exception {
    AzureNodePool expectedResponse =
        AzureNodePool.newBuilder()
            .setName(
                AzureNodePoolName.of(
                        "[PROJECT]", "[LOCATION]", "[AZURE_CLUSTER]", "[AZURE_NODE_POOL]")
                    .toString())
            .setVersion("version351608024")
            .setConfig(AzureNodeConfig.newBuilder().build())
            .setSubnetId("subnetId-2066159272")
            .setAutoscaling(AzureNodePoolAutoscaling.newBuilder().build())
            .setUid("uid115792")
            .setReconciling(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .putAllAnnotations(new HashMap<String, String>())
            .setMaxPodsConstraint(MaxPodsConstraint.newBuilder().build())
            .setAzureAvailabilityZone("azureAvailabilityZone-304222122")
            .addAllErrors(new ArrayList<AzureNodePoolError>())
            .build();
    mockService.addResponse(expectedResponse);

    AzureNodePoolName name =
        AzureNodePoolName.of("[PROJECT]", "[LOCATION]", "[AZURE_CLUSTER]", "[AZURE_NODE_POOL]");

    AzureNodePool actualResponse = client.getAzureNodePool(name);
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
  public void getAzureNodePoolExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AzureNodePoolName name =
          AzureNodePoolName.of("[PROJECT]", "[LOCATION]", "[AZURE_CLUSTER]", "[AZURE_NODE_POOL]");
      client.getAzureNodePool(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAzureNodePoolTest2() throws Exception {
    AzureNodePool expectedResponse =
        AzureNodePool.newBuilder()
            .setName(
                AzureNodePoolName.of(
                        "[PROJECT]", "[LOCATION]", "[AZURE_CLUSTER]", "[AZURE_NODE_POOL]")
                    .toString())
            .setVersion("version351608024")
            .setConfig(AzureNodeConfig.newBuilder().build())
            .setSubnetId("subnetId-2066159272")
            .setAutoscaling(AzureNodePoolAutoscaling.newBuilder().build())
            .setUid("uid115792")
            .setReconciling(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .putAllAnnotations(new HashMap<String, String>())
            .setMaxPodsConstraint(MaxPodsConstraint.newBuilder().build())
            .setAzureAvailabilityZone("azureAvailabilityZone-304222122")
            .addAllErrors(new ArrayList<AzureNodePoolError>())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-2382/locations/location-2382/azureClusters/azureCluster-2382/azureNodePools/azureNodePool-2382";

    AzureNodePool actualResponse = client.getAzureNodePool(name);
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
  public void getAzureNodePoolExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-2382/locations/location-2382/azureClusters/azureCluster-2382/azureNodePools/azureNodePool-2382";
      client.getAzureNodePool(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAzureNodePoolsTest() throws Exception {
    AzureNodePool responsesElement = AzureNodePool.newBuilder().build();
    ListAzureNodePoolsResponse expectedResponse =
        ListAzureNodePoolsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAzureNodePools(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    AzureClusterName parent = AzureClusterName.of("[PROJECT]", "[LOCATION]", "[AZURE_CLUSTER]");

    ListAzureNodePoolsPagedResponse pagedListResponse = client.listAzureNodePools(parent);

    List<AzureNodePool> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAzureNodePoolsList().get(0), resources.get(0));

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
  public void listAzureNodePoolsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AzureClusterName parent = AzureClusterName.of("[PROJECT]", "[LOCATION]", "[AZURE_CLUSTER]");
      client.listAzureNodePools(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAzureNodePoolsTest2() throws Exception {
    AzureNodePool responsesElement = AzureNodePool.newBuilder().build();
    ListAzureNodePoolsResponse expectedResponse =
        ListAzureNodePoolsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAzureNodePools(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-9011/locations/location-9011/azureClusters/azureCluster-9011";

    ListAzureNodePoolsPagedResponse pagedListResponse = client.listAzureNodePools(parent);

    List<AzureNodePool> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAzureNodePoolsList().get(0), resources.get(0));

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
  public void listAzureNodePoolsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-9011/locations/location-9011/azureClusters/azureCluster-9011";
      client.listAzureNodePools(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteAzureNodePoolTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteAzureNodePoolTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    AzureNodePoolName name =
        AzureNodePoolName.of("[PROJECT]", "[LOCATION]", "[AZURE_CLUSTER]", "[AZURE_NODE_POOL]");

    client.deleteAzureNodePoolAsync(name).get();

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
  public void deleteAzureNodePoolExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AzureNodePoolName name =
          AzureNodePoolName.of("[PROJECT]", "[LOCATION]", "[AZURE_CLUSTER]", "[AZURE_NODE_POOL]");
      client.deleteAzureNodePoolAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteAzureNodePoolTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteAzureNodePoolTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name =
        "projects/project-2382/locations/location-2382/azureClusters/azureCluster-2382/azureNodePools/azureNodePool-2382";

    client.deleteAzureNodePoolAsync(name).get();

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
  public void deleteAzureNodePoolExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-2382/locations/location-2382/azureClusters/azureCluster-2382/azureNodePools/azureNodePool-2382";
      client.deleteAzureNodePoolAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void getAzureServerConfigTest() throws Exception {
    AzureServerConfig expectedResponse =
        AzureServerConfig.newBuilder()
            .setName(AzureServerConfigName.of("[PROJECT]", "[LOCATION]").toString())
            .addAllValidVersions(new ArrayList<AzureK8sVersionInfo>())
            .addAllSupportedAzureRegions(new ArrayList<String>())
            .build();
    mockService.addResponse(expectedResponse);

    AzureServerConfigName name = AzureServerConfigName.of("[PROJECT]", "[LOCATION]");

    AzureServerConfig actualResponse = client.getAzureServerConfig(name);
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
  public void getAzureServerConfigExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AzureServerConfigName name = AzureServerConfigName.of("[PROJECT]", "[LOCATION]");
      client.getAzureServerConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAzureServerConfigTest2() throws Exception {
    AzureServerConfig expectedResponse =
        AzureServerConfig.newBuilder()
            .setName(AzureServerConfigName.of("[PROJECT]", "[LOCATION]").toString())
            .addAllValidVersions(new ArrayList<AzureK8sVersionInfo>())
            .addAllSupportedAzureRegions(new ArrayList<String>())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-9505/locations/location-9505/azureServerConfig";

    AzureServerConfig actualResponse = client.getAzureServerConfig(name);
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
  public void getAzureServerConfigExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-9505/locations/location-9505/azureServerConfig";
      client.getAzureServerConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
