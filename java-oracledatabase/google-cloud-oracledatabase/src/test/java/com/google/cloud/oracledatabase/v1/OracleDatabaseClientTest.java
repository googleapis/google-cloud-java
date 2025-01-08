/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.oracledatabase.v1;

import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListAutonomousDatabaseBackupsPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListAutonomousDatabaseCharacterSetsPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListAutonomousDatabasesPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListAutonomousDbVersionsPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListCloudExadataInfrastructuresPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListCloudVmClustersPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListDbNodesPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListDbServersPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListDbSystemShapesPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListEntitlementsPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListGiVersionsPagedResponse;
import static com.google.cloud.oracledatabase.v1.OracleDatabaseClient.ListLocationsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.oracledatabase.v1.stub.HttpJsonOracleDatabaseStub;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Any;
import com.google.protobuf.ByteString;
import com.google.protobuf.Empty;
import com.google.protobuf.Timestamp;
import java.io.IOException;
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
public class OracleDatabaseClientTest {
  private static MockHttpService mockService;
  private static OracleDatabaseClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonOracleDatabaseStub.getMethodDescriptors(),
            OracleDatabaseSettings.getDefaultEndpoint());
    OracleDatabaseSettings settings =
        OracleDatabaseSettings.newBuilder()
            .setTransportChannelProvider(
                OracleDatabaseSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = OracleDatabaseClient.create(settings);
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
  public void listCloudExadataInfrastructuresTest() throws Exception {
    CloudExadataInfrastructure responsesElement = CloudExadataInfrastructure.newBuilder().build();
    ListCloudExadataInfrastructuresResponse expectedResponse =
        ListCloudExadataInfrastructuresResponse.newBuilder()
            .setNextPageToken("")
            .addAllCloudExadataInfrastructures(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListCloudExadataInfrastructuresPagedResponse pagedListResponse =
        client.listCloudExadataInfrastructures(parent);

    List<CloudExadataInfrastructure> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getCloudExadataInfrastructuresList().get(0), resources.get(0));

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
  public void listCloudExadataInfrastructuresExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listCloudExadataInfrastructures(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listCloudExadataInfrastructuresTest2() throws Exception {
    CloudExadataInfrastructure responsesElement = CloudExadataInfrastructure.newBuilder().build();
    ListCloudExadataInfrastructuresResponse expectedResponse =
        ListCloudExadataInfrastructuresResponse.newBuilder()
            .setNextPageToken("")
            .addAllCloudExadataInfrastructures(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListCloudExadataInfrastructuresPagedResponse pagedListResponse =
        client.listCloudExadataInfrastructures(parent);

    List<CloudExadataInfrastructure> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getCloudExadataInfrastructuresList().get(0), resources.get(0));

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
  public void listCloudExadataInfrastructuresExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listCloudExadataInfrastructures(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getCloudExadataInfrastructureTest() throws Exception {
    CloudExadataInfrastructure expectedResponse =
        CloudExadataInfrastructure.newBuilder()
            .setName(
                CloudExadataInfrastructureName.of(
                        "[PROJECT]", "[LOCATION]", "[CLOUD_EXADATA_INFRASTRUCTURE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setGcpOracleZone("gcpOracleZone217860222")
            .setEntitlementId("entitlementId-1302274264")
            .setProperties(CloudExadataInfrastructureProperties.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    CloudExadataInfrastructureName name =
        CloudExadataInfrastructureName.of(
            "[PROJECT]", "[LOCATION]", "[CLOUD_EXADATA_INFRASTRUCTURE]");

    CloudExadataInfrastructure actualResponse = client.getCloudExadataInfrastructure(name);
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
  public void getCloudExadataInfrastructureExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CloudExadataInfrastructureName name =
          CloudExadataInfrastructureName.of(
              "[PROJECT]", "[LOCATION]", "[CLOUD_EXADATA_INFRASTRUCTURE]");
      client.getCloudExadataInfrastructure(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getCloudExadataInfrastructureTest2() throws Exception {
    CloudExadataInfrastructure expectedResponse =
        CloudExadataInfrastructure.newBuilder()
            .setName(
                CloudExadataInfrastructureName.of(
                        "[PROJECT]", "[LOCATION]", "[CLOUD_EXADATA_INFRASTRUCTURE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setGcpOracleZone("gcpOracleZone217860222")
            .setEntitlementId("entitlementId-1302274264")
            .setProperties(CloudExadataInfrastructureProperties.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-7549/locations/location-7549/cloudExadataInfrastructures/cloudExadataInfrastructure-7549";

    CloudExadataInfrastructure actualResponse = client.getCloudExadataInfrastructure(name);
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
  public void getCloudExadataInfrastructureExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-7549/locations/location-7549/cloudExadataInfrastructures/cloudExadataInfrastructure-7549";
      client.getCloudExadataInfrastructure(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createCloudExadataInfrastructureTest() throws Exception {
    CloudExadataInfrastructure expectedResponse =
        CloudExadataInfrastructure.newBuilder()
            .setName(
                CloudExadataInfrastructureName.of(
                        "[PROJECT]", "[LOCATION]", "[CLOUD_EXADATA_INFRASTRUCTURE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setGcpOracleZone("gcpOracleZone217860222")
            .setEntitlementId("entitlementId-1302274264")
            .setProperties(CloudExadataInfrastructureProperties.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createCloudExadataInfrastructureTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    CloudExadataInfrastructure cloudExadataInfrastructure =
        CloudExadataInfrastructure.newBuilder().build();
    String cloudExadataInfrastructureId = "cloudExadataInfrastructureId975345409";

    CloudExadataInfrastructure actualResponse =
        client
            .createCloudExadataInfrastructureAsync(
                parent, cloudExadataInfrastructure, cloudExadataInfrastructureId)
            .get();
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
  public void createCloudExadataInfrastructureExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      CloudExadataInfrastructure cloudExadataInfrastructure =
          CloudExadataInfrastructure.newBuilder().build();
      String cloudExadataInfrastructureId = "cloudExadataInfrastructureId975345409";
      client
          .createCloudExadataInfrastructureAsync(
              parent, cloudExadataInfrastructure, cloudExadataInfrastructureId)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createCloudExadataInfrastructureTest2() throws Exception {
    CloudExadataInfrastructure expectedResponse =
        CloudExadataInfrastructure.newBuilder()
            .setName(
                CloudExadataInfrastructureName.of(
                        "[PROJECT]", "[LOCATION]", "[CLOUD_EXADATA_INFRASTRUCTURE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setGcpOracleZone("gcpOracleZone217860222")
            .setEntitlementId("entitlementId-1302274264")
            .setProperties(CloudExadataInfrastructureProperties.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createCloudExadataInfrastructureTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5833/locations/location-5833";
    CloudExadataInfrastructure cloudExadataInfrastructure =
        CloudExadataInfrastructure.newBuilder().build();
    String cloudExadataInfrastructureId = "cloudExadataInfrastructureId975345409";

    CloudExadataInfrastructure actualResponse =
        client
            .createCloudExadataInfrastructureAsync(
                parent, cloudExadataInfrastructure, cloudExadataInfrastructureId)
            .get();
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
  public void createCloudExadataInfrastructureExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      CloudExadataInfrastructure cloudExadataInfrastructure =
          CloudExadataInfrastructure.newBuilder().build();
      String cloudExadataInfrastructureId = "cloudExadataInfrastructureId975345409";
      client
          .createCloudExadataInfrastructureAsync(
              parent, cloudExadataInfrastructure, cloudExadataInfrastructureId)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteCloudExadataInfrastructureTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteCloudExadataInfrastructureTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    CloudExadataInfrastructureName name =
        CloudExadataInfrastructureName.of(
            "[PROJECT]", "[LOCATION]", "[CLOUD_EXADATA_INFRASTRUCTURE]");

    client.deleteCloudExadataInfrastructureAsync(name).get();

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
  public void deleteCloudExadataInfrastructureExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CloudExadataInfrastructureName name =
          CloudExadataInfrastructureName.of(
              "[PROJECT]", "[LOCATION]", "[CLOUD_EXADATA_INFRASTRUCTURE]");
      client.deleteCloudExadataInfrastructureAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteCloudExadataInfrastructureTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteCloudExadataInfrastructureTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name =
        "projects/project-7549/locations/location-7549/cloudExadataInfrastructures/cloudExadataInfrastructure-7549";

    client.deleteCloudExadataInfrastructureAsync(name).get();

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
  public void deleteCloudExadataInfrastructureExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-7549/locations/location-7549/cloudExadataInfrastructures/cloudExadataInfrastructure-7549";
      client.deleteCloudExadataInfrastructureAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void listCloudVmClustersTest() throws Exception {
    CloudVmCluster responsesElement = CloudVmCluster.newBuilder().build();
    ListCloudVmClustersResponse expectedResponse =
        ListCloudVmClustersResponse.newBuilder()
            .setNextPageToken("")
            .addAllCloudVmClusters(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListCloudVmClustersPagedResponse pagedListResponse = client.listCloudVmClusters(parent);

    List<CloudVmCluster> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCloudVmClustersList().get(0), resources.get(0));

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
  public void listCloudVmClustersExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listCloudVmClusters(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listCloudVmClustersTest2() throws Exception {
    CloudVmCluster responsesElement = CloudVmCluster.newBuilder().build();
    ListCloudVmClustersResponse expectedResponse =
        ListCloudVmClustersResponse.newBuilder()
            .setNextPageToken("")
            .addAllCloudVmClusters(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListCloudVmClustersPagedResponse pagedListResponse = client.listCloudVmClusters(parent);

    List<CloudVmCluster> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCloudVmClustersList().get(0), resources.get(0));

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
  public void listCloudVmClustersExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listCloudVmClusters(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getCloudVmClusterTest() throws Exception {
    CloudVmCluster expectedResponse =
        CloudVmCluster.newBuilder()
            .setName(
                CloudVmClusterName.of("[PROJECT]", "[LOCATION]", "[CLOUD_VM_CLUSTER]").toString())
            .setExadataInfrastructure(
                CloudExadataInfrastructureName.of(
                        "[PROJECT]", "[LOCATION]", "[CLOUD_EXADATA_INFRASTRUCTURE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setGcpOracleZone("gcpOracleZone217860222")
            .setProperties(CloudVmClusterProperties.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setCidr("cidr3053428")
            .setBackupSubnetCidr("backupSubnetCidr1087692755")
            .setNetwork("network1843485230")
            .build();
    mockService.addResponse(expectedResponse);

    CloudVmClusterName name =
        CloudVmClusterName.of("[PROJECT]", "[LOCATION]", "[CLOUD_VM_CLUSTER]");

    CloudVmCluster actualResponse = client.getCloudVmCluster(name);
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
  public void getCloudVmClusterExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CloudVmClusterName name =
          CloudVmClusterName.of("[PROJECT]", "[LOCATION]", "[CLOUD_VM_CLUSTER]");
      client.getCloudVmCluster(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getCloudVmClusterTest2() throws Exception {
    CloudVmCluster expectedResponse =
        CloudVmCluster.newBuilder()
            .setName(
                CloudVmClusterName.of("[PROJECT]", "[LOCATION]", "[CLOUD_VM_CLUSTER]").toString())
            .setExadataInfrastructure(
                CloudExadataInfrastructureName.of(
                        "[PROJECT]", "[LOCATION]", "[CLOUD_EXADATA_INFRASTRUCTURE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setGcpOracleZone("gcpOracleZone217860222")
            .setProperties(CloudVmClusterProperties.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setCidr("cidr3053428")
            .setBackupSubnetCidr("backupSubnetCidr1087692755")
            .setNetwork("network1843485230")
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-9637/locations/location-9637/cloudVmClusters/cloudVmCluster-9637";

    CloudVmCluster actualResponse = client.getCloudVmCluster(name);
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
  public void getCloudVmClusterExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-9637/locations/location-9637/cloudVmClusters/cloudVmCluster-9637";
      client.getCloudVmCluster(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createCloudVmClusterTest() throws Exception {
    CloudVmCluster expectedResponse =
        CloudVmCluster.newBuilder()
            .setName(
                CloudVmClusterName.of("[PROJECT]", "[LOCATION]", "[CLOUD_VM_CLUSTER]").toString())
            .setExadataInfrastructure(
                CloudExadataInfrastructureName.of(
                        "[PROJECT]", "[LOCATION]", "[CLOUD_EXADATA_INFRASTRUCTURE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setGcpOracleZone("gcpOracleZone217860222")
            .setProperties(CloudVmClusterProperties.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setCidr("cidr3053428")
            .setBackupSubnetCidr("backupSubnetCidr1087692755")
            .setNetwork("network1843485230")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createCloudVmClusterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    CloudVmCluster cloudVmCluster = CloudVmCluster.newBuilder().build();
    String cloudVmClusterId = "cloudVmClusterId-1217103287";

    CloudVmCluster actualResponse =
        client.createCloudVmClusterAsync(parent, cloudVmCluster, cloudVmClusterId).get();
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
  public void createCloudVmClusterExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      CloudVmCluster cloudVmCluster = CloudVmCluster.newBuilder().build();
      String cloudVmClusterId = "cloudVmClusterId-1217103287";
      client.createCloudVmClusterAsync(parent, cloudVmCluster, cloudVmClusterId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createCloudVmClusterTest2() throws Exception {
    CloudVmCluster expectedResponse =
        CloudVmCluster.newBuilder()
            .setName(
                CloudVmClusterName.of("[PROJECT]", "[LOCATION]", "[CLOUD_VM_CLUSTER]").toString())
            .setExadataInfrastructure(
                CloudExadataInfrastructureName.of(
                        "[PROJECT]", "[LOCATION]", "[CLOUD_EXADATA_INFRASTRUCTURE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setGcpOracleZone("gcpOracleZone217860222")
            .setProperties(CloudVmClusterProperties.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setCidr("cidr3053428")
            .setBackupSubnetCidr("backupSubnetCidr1087692755")
            .setNetwork("network1843485230")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createCloudVmClusterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5833/locations/location-5833";
    CloudVmCluster cloudVmCluster = CloudVmCluster.newBuilder().build();
    String cloudVmClusterId = "cloudVmClusterId-1217103287";

    CloudVmCluster actualResponse =
        client.createCloudVmClusterAsync(parent, cloudVmCluster, cloudVmClusterId).get();
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
  public void createCloudVmClusterExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      CloudVmCluster cloudVmCluster = CloudVmCluster.newBuilder().build();
      String cloudVmClusterId = "cloudVmClusterId-1217103287";
      client.createCloudVmClusterAsync(parent, cloudVmCluster, cloudVmClusterId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteCloudVmClusterTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteCloudVmClusterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    CloudVmClusterName name =
        CloudVmClusterName.of("[PROJECT]", "[LOCATION]", "[CLOUD_VM_CLUSTER]");

    client.deleteCloudVmClusterAsync(name).get();

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
  public void deleteCloudVmClusterExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CloudVmClusterName name =
          CloudVmClusterName.of("[PROJECT]", "[LOCATION]", "[CLOUD_VM_CLUSTER]");
      client.deleteCloudVmClusterAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteCloudVmClusterTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteCloudVmClusterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name =
        "projects/project-9637/locations/location-9637/cloudVmClusters/cloudVmCluster-9637";

    client.deleteCloudVmClusterAsync(name).get();

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
  public void deleteCloudVmClusterExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-9637/locations/location-9637/cloudVmClusters/cloudVmCluster-9637";
      client.deleteCloudVmClusterAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void listEntitlementsTest() throws Exception {
    Entitlement responsesElement = Entitlement.newBuilder().build();
    ListEntitlementsResponse expectedResponse =
        ListEntitlementsResponse.newBuilder()
            .setNextPageToken("")
            .addAllEntitlements(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListEntitlementsPagedResponse pagedListResponse = client.listEntitlements(parent);

    List<Entitlement> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEntitlementsList().get(0), resources.get(0));

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
  public void listEntitlementsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listEntitlements(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listEntitlementsTest2() throws Exception {
    Entitlement responsesElement = Entitlement.newBuilder().build();
    ListEntitlementsResponse expectedResponse =
        ListEntitlementsResponse.newBuilder()
            .setNextPageToken("")
            .addAllEntitlements(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListEntitlementsPagedResponse pagedListResponse = client.listEntitlements(parent);

    List<Entitlement> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEntitlementsList().get(0), resources.get(0));

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
  public void listEntitlementsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listEntitlements(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDbServersTest() throws Exception {
    DbServer responsesElement = DbServer.newBuilder().build();
    ListDbServersResponse expectedResponse =
        ListDbServersResponse.newBuilder()
            .setNextPageToken("")
            .addAllDbServers(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    CloudExadataInfrastructureName parent =
        CloudExadataInfrastructureName.of(
            "[PROJECT]", "[LOCATION]", "[CLOUD_EXADATA_INFRASTRUCTURE]");

    ListDbServersPagedResponse pagedListResponse = client.listDbServers(parent);

    List<DbServer> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDbServersList().get(0), resources.get(0));

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
  public void listDbServersExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CloudExadataInfrastructureName parent =
          CloudExadataInfrastructureName.of(
              "[PROJECT]", "[LOCATION]", "[CLOUD_EXADATA_INFRASTRUCTURE]");
      client.listDbServers(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDbServersTest2() throws Exception {
    DbServer responsesElement = DbServer.newBuilder().build();
    ListDbServersResponse expectedResponse =
        ListDbServersResponse.newBuilder()
            .setNextPageToken("")
            .addAllDbServers(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent =
        "projects/project-3202/locations/location-3202/cloudExadataInfrastructures/cloudExadataInfrastructure-3202";

    ListDbServersPagedResponse pagedListResponse = client.listDbServers(parent);

    List<DbServer> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDbServersList().get(0), resources.get(0));

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
  public void listDbServersExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-3202/locations/location-3202/cloudExadataInfrastructures/cloudExadataInfrastructure-3202";
      client.listDbServers(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDbNodesTest() throws Exception {
    DbNode responsesElement = DbNode.newBuilder().build();
    ListDbNodesResponse expectedResponse =
        ListDbNodesResponse.newBuilder()
            .setNextPageToken("")
            .addAllDbNodes(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    CloudVmClusterName parent =
        CloudVmClusterName.of("[PROJECT]", "[LOCATION]", "[CLOUD_VM_CLUSTER]");

    ListDbNodesPagedResponse pagedListResponse = client.listDbNodes(parent);

    List<DbNode> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDbNodesList().get(0), resources.get(0));

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
  public void listDbNodesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CloudVmClusterName parent =
          CloudVmClusterName.of("[PROJECT]", "[LOCATION]", "[CLOUD_VM_CLUSTER]");
      client.listDbNodes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDbNodesTest2() throws Exception {
    DbNode responsesElement = DbNode.newBuilder().build();
    ListDbNodesResponse expectedResponse =
        ListDbNodesResponse.newBuilder()
            .setNextPageToken("")
            .addAllDbNodes(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent =
        "projects/project-2426/locations/location-2426/cloudVmClusters/cloudVmCluster-2426";

    ListDbNodesPagedResponse pagedListResponse = client.listDbNodes(parent);

    List<DbNode> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDbNodesList().get(0), resources.get(0));

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
  public void listDbNodesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-2426/locations/location-2426/cloudVmClusters/cloudVmCluster-2426";
      client.listDbNodes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listGiVersionsTest() throws Exception {
    GiVersion responsesElement = GiVersion.newBuilder().build();
    ListGiVersionsResponse expectedResponse =
        ListGiVersionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllGiVersions(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListGiVersionsPagedResponse pagedListResponse = client.listGiVersions(parent);

    List<GiVersion> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getGiVersionsList().get(0), resources.get(0));

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
  public void listGiVersionsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listGiVersions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listGiVersionsTest2() throws Exception {
    GiVersion responsesElement = GiVersion.newBuilder().build();
    ListGiVersionsResponse expectedResponse =
        ListGiVersionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllGiVersions(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListGiVersionsPagedResponse pagedListResponse = client.listGiVersions(parent);

    List<GiVersion> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getGiVersionsList().get(0), resources.get(0));

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
  public void listGiVersionsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listGiVersions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDbSystemShapesTest() throws Exception {
    DbSystemShape responsesElement = DbSystemShape.newBuilder().build();
    ListDbSystemShapesResponse expectedResponse =
        ListDbSystemShapesResponse.newBuilder()
            .setNextPageToken("")
            .addAllDbSystemShapes(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListDbSystemShapesPagedResponse pagedListResponse = client.listDbSystemShapes(parent);

    List<DbSystemShape> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDbSystemShapesList().get(0), resources.get(0));

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
  public void listDbSystemShapesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listDbSystemShapes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDbSystemShapesTest2() throws Exception {
    DbSystemShape responsesElement = DbSystemShape.newBuilder().build();
    ListDbSystemShapesResponse expectedResponse =
        ListDbSystemShapesResponse.newBuilder()
            .setNextPageToken("")
            .addAllDbSystemShapes(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListDbSystemShapesPagedResponse pagedListResponse = client.listDbSystemShapes(parent);

    List<DbSystemShape> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDbSystemShapesList().get(0), resources.get(0));

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
  public void listDbSystemShapesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listDbSystemShapes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAutonomousDatabasesTest() throws Exception {
    AutonomousDatabase responsesElement = AutonomousDatabase.newBuilder().build();
    ListAutonomousDatabasesResponse expectedResponse =
        ListAutonomousDatabasesResponse.newBuilder()
            .setNextPageToken("")
            .addAllAutonomousDatabases(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListAutonomousDatabasesPagedResponse pagedListResponse = client.listAutonomousDatabases(parent);

    List<AutonomousDatabase> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAutonomousDatabasesList().get(0), resources.get(0));

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
  public void listAutonomousDatabasesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listAutonomousDatabases(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAutonomousDatabasesTest2() throws Exception {
    AutonomousDatabase responsesElement = AutonomousDatabase.newBuilder().build();
    ListAutonomousDatabasesResponse expectedResponse =
        ListAutonomousDatabasesResponse.newBuilder()
            .setNextPageToken("")
            .addAllAutonomousDatabases(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListAutonomousDatabasesPagedResponse pagedListResponse = client.listAutonomousDatabases(parent);

    List<AutonomousDatabase> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAutonomousDatabasesList().get(0), resources.get(0));

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
  public void listAutonomousDatabasesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listAutonomousDatabases(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAutonomousDatabaseTest() throws Exception {
    AutonomousDatabase expectedResponse =
        AutonomousDatabase.newBuilder()
            .setName(
                AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]")
                    .toString())
            .setDatabase("database1789464955")
            .setDisplayName("displayName1714148973")
            .setEntitlementId("entitlementId-1302274264")
            .setAdminPassword("adminPassword-95067382")
            .setProperties(AutonomousDatabaseProperties.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setNetwork("network1843485230")
            .setCidr("cidr3053428")
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    AutonomousDatabaseName name =
        AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]");

    AutonomousDatabase actualResponse = client.getAutonomousDatabase(name);
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
  public void getAutonomousDatabaseExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AutonomousDatabaseName name =
          AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]");
      client.getAutonomousDatabase(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAutonomousDatabaseTest2() throws Exception {
    AutonomousDatabase expectedResponse =
        AutonomousDatabase.newBuilder()
            .setName(
                AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]")
                    .toString())
            .setDatabase("database1789464955")
            .setDisplayName("displayName1714148973")
            .setEntitlementId("entitlementId-1302274264")
            .setAdminPassword("adminPassword-95067382")
            .setProperties(AutonomousDatabaseProperties.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setNetwork("network1843485230")
            .setCidr("cidr3053428")
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-8766/locations/location-8766/autonomousDatabases/autonomousDatabase-8766";

    AutonomousDatabase actualResponse = client.getAutonomousDatabase(name);
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
  public void getAutonomousDatabaseExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-8766/locations/location-8766/autonomousDatabases/autonomousDatabase-8766";
      client.getAutonomousDatabase(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createAutonomousDatabaseTest() throws Exception {
    AutonomousDatabase expectedResponse =
        AutonomousDatabase.newBuilder()
            .setName(
                AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]")
                    .toString())
            .setDatabase("database1789464955")
            .setDisplayName("displayName1714148973")
            .setEntitlementId("entitlementId-1302274264")
            .setAdminPassword("adminPassword-95067382")
            .setProperties(AutonomousDatabaseProperties.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setNetwork("network1843485230")
            .setCidr("cidr3053428")
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createAutonomousDatabaseTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    AutonomousDatabase autonomousDatabase = AutonomousDatabase.newBuilder().build();
    String autonomousDatabaseId = "autonomousDatabaseId-1972693114";

    AutonomousDatabase actualResponse =
        client
            .createAutonomousDatabaseAsync(parent, autonomousDatabase, autonomousDatabaseId)
            .get();
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
  public void createAutonomousDatabaseExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      AutonomousDatabase autonomousDatabase = AutonomousDatabase.newBuilder().build();
      String autonomousDatabaseId = "autonomousDatabaseId-1972693114";
      client.createAutonomousDatabaseAsync(parent, autonomousDatabase, autonomousDatabaseId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createAutonomousDatabaseTest2() throws Exception {
    AutonomousDatabase expectedResponse =
        AutonomousDatabase.newBuilder()
            .setName(
                AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]")
                    .toString())
            .setDatabase("database1789464955")
            .setDisplayName("displayName1714148973")
            .setEntitlementId("entitlementId-1302274264")
            .setAdminPassword("adminPassword-95067382")
            .setProperties(AutonomousDatabaseProperties.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setNetwork("network1843485230")
            .setCidr("cidr3053428")
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createAutonomousDatabaseTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5833/locations/location-5833";
    AutonomousDatabase autonomousDatabase = AutonomousDatabase.newBuilder().build();
    String autonomousDatabaseId = "autonomousDatabaseId-1972693114";

    AutonomousDatabase actualResponse =
        client
            .createAutonomousDatabaseAsync(parent, autonomousDatabase, autonomousDatabaseId)
            .get();
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
  public void createAutonomousDatabaseExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      AutonomousDatabase autonomousDatabase = AutonomousDatabase.newBuilder().build();
      String autonomousDatabaseId = "autonomousDatabaseId-1972693114";
      client.createAutonomousDatabaseAsync(parent, autonomousDatabase, autonomousDatabaseId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteAutonomousDatabaseTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteAutonomousDatabaseTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    AutonomousDatabaseName name =
        AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]");

    client.deleteAutonomousDatabaseAsync(name).get();

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
  public void deleteAutonomousDatabaseExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AutonomousDatabaseName name =
          AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]");
      client.deleteAutonomousDatabaseAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteAutonomousDatabaseTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteAutonomousDatabaseTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name =
        "projects/project-8766/locations/location-8766/autonomousDatabases/autonomousDatabase-8766";

    client.deleteAutonomousDatabaseAsync(name).get();

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
  public void deleteAutonomousDatabaseExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-8766/locations/location-8766/autonomousDatabases/autonomousDatabase-8766";
      client.deleteAutonomousDatabaseAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void restoreAutonomousDatabaseTest() throws Exception {
    AutonomousDatabase expectedResponse =
        AutonomousDatabase.newBuilder()
            .setName(
                AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]")
                    .toString())
            .setDatabase("database1789464955")
            .setDisplayName("displayName1714148973")
            .setEntitlementId("entitlementId-1302274264")
            .setAdminPassword("adminPassword-95067382")
            .setProperties(AutonomousDatabaseProperties.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setNetwork("network1843485230")
            .setCidr("cidr3053428")
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("restoreAutonomousDatabaseTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    AutonomousDatabaseName name =
        AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]");
    Timestamp restoreTime = Timestamp.newBuilder().build();

    AutonomousDatabase actualResponse =
        client.restoreAutonomousDatabaseAsync(name, restoreTime).get();
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
  public void restoreAutonomousDatabaseExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AutonomousDatabaseName name =
          AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]");
      Timestamp restoreTime = Timestamp.newBuilder().build();
      client.restoreAutonomousDatabaseAsync(name, restoreTime).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void restoreAutonomousDatabaseTest2() throws Exception {
    AutonomousDatabase expectedResponse =
        AutonomousDatabase.newBuilder()
            .setName(
                AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]")
                    .toString())
            .setDatabase("database1789464955")
            .setDisplayName("displayName1714148973")
            .setEntitlementId("entitlementId-1302274264")
            .setAdminPassword("adminPassword-95067382")
            .setProperties(AutonomousDatabaseProperties.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setNetwork("network1843485230")
            .setCidr("cidr3053428")
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("restoreAutonomousDatabaseTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name =
        "projects/project-8766/locations/location-8766/autonomousDatabases/autonomousDatabase-8766";
    Timestamp restoreTime = Timestamp.newBuilder().build();

    AutonomousDatabase actualResponse =
        client.restoreAutonomousDatabaseAsync(name, restoreTime).get();
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
  public void restoreAutonomousDatabaseExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-8766/locations/location-8766/autonomousDatabases/autonomousDatabase-8766";
      Timestamp restoreTime = Timestamp.newBuilder().build();
      client.restoreAutonomousDatabaseAsync(name, restoreTime).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void generateAutonomousDatabaseWalletTest() throws Exception {
    GenerateAutonomousDatabaseWalletResponse expectedResponse =
        GenerateAutonomousDatabaseWalletResponse.newBuilder()
            .setArchiveContent(ByteString.EMPTY)
            .build();
    mockService.addResponse(expectedResponse);

    AutonomousDatabaseName name =
        AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]");
    GenerateType type = GenerateType.forNumber(0);
    boolean isRegional = true;
    String password = "password1216985755";

    GenerateAutonomousDatabaseWalletResponse actualResponse =
        client.generateAutonomousDatabaseWallet(name, type, isRegional, password);
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
  public void generateAutonomousDatabaseWalletExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AutonomousDatabaseName name =
          AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]");
      GenerateType type = GenerateType.forNumber(0);
      boolean isRegional = true;
      String password = "password1216985755";
      client.generateAutonomousDatabaseWallet(name, type, isRegional, password);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void generateAutonomousDatabaseWalletTest2() throws Exception {
    GenerateAutonomousDatabaseWalletResponse expectedResponse =
        GenerateAutonomousDatabaseWalletResponse.newBuilder()
            .setArchiveContent(ByteString.EMPTY)
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-8766/locations/location-8766/autonomousDatabases/autonomousDatabase-8766";
    GenerateType type = GenerateType.forNumber(0);
    boolean isRegional = true;
    String password = "password1216985755";

    GenerateAutonomousDatabaseWalletResponse actualResponse =
        client.generateAutonomousDatabaseWallet(name, type, isRegional, password);
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
  public void generateAutonomousDatabaseWalletExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-8766/locations/location-8766/autonomousDatabases/autonomousDatabase-8766";
      GenerateType type = GenerateType.forNumber(0);
      boolean isRegional = true;
      String password = "password1216985755";
      client.generateAutonomousDatabaseWallet(name, type, isRegional, password);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAutonomousDbVersionsTest() throws Exception {
    AutonomousDbVersion responsesElement = AutonomousDbVersion.newBuilder().build();
    ListAutonomousDbVersionsResponse expectedResponse =
        ListAutonomousDbVersionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAutonomousDbVersions(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListAutonomousDbVersionsPagedResponse pagedListResponse =
        client.listAutonomousDbVersions(parent);

    List<AutonomousDbVersion> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAutonomousDbVersionsList().get(0), resources.get(0));

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
  public void listAutonomousDbVersionsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listAutonomousDbVersions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAutonomousDbVersionsTest2() throws Exception {
    AutonomousDbVersion responsesElement = AutonomousDbVersion.newBuilder().build();
    ListAutonomousDbVersionsResponse expectedResponse =
        ListAutonomousDbVersionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAutonomousDbVersions(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListAutonomousDbVersionsPagedResponse pagedListResponse =
        client.listAutonomousDbVersions(parent);

    List<AutonomousDbVersion> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAutonomousDbVersionsList().get(0), resources.get(0));

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
  public void listAutonomousDbVersionsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listAutonomousDbVersions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAutonomousDatabaseCharacterSetsTest() throws Exception {
    AutonomousDatabaseCharacterSet responsesElement =
        AutonomousDatabaseCharacterSet.newBuilder().build();
    ListAutonomousDatabaseCharacterSetsResponse expectedResponse =
        ListAutonomousDatabaseCharacterSetsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAutonomousDatabaseCharacterSets(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListAutonomousDatabaseCharacterSetsPagedResponse pagedListResponse =
        client.listAutonomousDatabaseCharacterSets(parent);

    List<AutonomousDatabaseCharacterSet> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getAutonomousDatabaseCharacterSetsList().get(0), resources.get(0));

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
  public void listAutonomousDatabaseCharacterSetsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listAutonomousDatabaseCharacterSets(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAutonomousDatabaseCharacterSetsTest2() throws Exception {
    AutonomousDatabaseCharacterSet responsesElement =
        AutonomousDatabaseCharacterSet.newBuilder().build();
    ListAutonomousDatabaseCharacterSetsResponse expectedResponse =
        ListAutonomousDatabaseCharacterSetsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAutonomousDatabaseCharacterSets(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListAutonomousDatabaseCharacterSetsPagedResponse pagedListResponse =
        client.listAutonomousDatabaseCharacterSets(parent);

    List<AutonomousDatabaseCharacterSet> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getAutonomousDatabaseCharacterSetsList().get(0), resources.get(0));

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
  public void listAutonomousDatabaseCharacterSetsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listAutonomousDatabaseCharacterSets(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAutonomousDatabaseBackupsTest() throws Exception {
    AutonomousDatabaseBackup responsesElement = AutonomousDatabaseBackup.newBuilder().build();
    ListAutonomousDatabaseBackupsResponse expectedResponse =
        ListAutonomousDatabaseBackupsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAutonomousDatabaseBackups(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListAutonomousDatabaseBackupsPagedResponse pagedListResponse =
        client.listAutonomousDatabaseBackups(parent);

    List<AutonomousDatabaseBackup> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getAutonomousDatabaseBackupsList().get(0), resources.get(0));

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
  public void listAutonomousDatabaseBackupsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listAutonomousDatabaseBackups(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAutonomousDatabaseBackupsTest2() throws Exception {
    AutonomousDatabaseBackup responsesElement = AutonomousDatabaseBackup.newBuilder().build();
    ListAutonomousDatabaseBackupsResponse expectedResponse =
        ListAutonomousDatabaseBackupsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAutonomousDatabaseBackups(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListAutonomousDatabaseBackupsPagedResponse pagedListResponse =
        client.listAutonomousDatabaseBackups(parent);

    List<AutonomousDatabaseBackup> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getAutonomousDatabaseBackupsList().get(0), resources.get(0));

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
  public void listAutonomousDatabaseBackupsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listAutonomousDatabaseBackups(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listLocationsTest() throws Exception {
    Location responsesElement = Location.newBuilder().build();
    ListLocationsResponse expectedResponse =
        ListLocationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllLocations(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    ListLocationsRequest request =
        ListLocationsRequest.newBuilder()
            .setName("projects/project-3664")
            .setFilter("filter-1274492040")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    ListLocationsPagedResponse pagedListResponse = client.listLocations(request);

    List<Location> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLocationsList().get(0), resources.get(0));

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
  public void listLocationsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ListLocationsRequest request =
          ListLocationsRequest.newBuilder()
              .setName("projects/project-3664")
              .setFilter("filter-1274492040")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      client.listLocations(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getLocationTest() throws Exception {
    Location expectedResponse =
        Location.newBuilder()
            .setName("name3373707")
            .setLocationId("locationId1541836720")
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setMetadata(Any.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    GetLocationRequest request =
        GetLocationRequest.newBuilder()
            .setName("projects/project-9062/locations/location-9062")
            .build();

    Location actualResponse = client.getLocation(request);
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
  public void getLocationExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GetLocationRequest request =
          GetLocationRequest.newBuilder()
              .setName("projects/project-9062/locations/location-9062")
              .build();
      client.getLocation(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
