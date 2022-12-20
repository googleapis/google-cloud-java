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

import static com.google.cloud.gkemulticloud.v1.AttachedClustersClient.ListAttachedClustersPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.gkemulticloud.v1.stub.HttpJsonAttachedClustersStub;
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
public class AttachedClustersClientHttpJsonTest {
  private static MockHttpService mockService;
  private static AttachedClustersClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonAttachedClustersStub.getMethodDescriptors(),
            AttachedClustersSettings.getDefaultEndpoint());
    AttachedClustersSettings settings =
        AttachedClustersSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                AttachedClustersSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = AttachedClustersClient.create(settings);
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
  public void createAttachedClusterTest() throws Exception {
    AttachedCluster expectedResponse =
        AttachedCluster.newBuilder()
            .setName(
                AttachedClusterName.of("[PROJECT]", "[LOCATION]", "[ATTACHED_CLUSTER]").toString())
            .setDescription("description-1724546052")
            .setOidcConfig(AttachedOidcConfig.newBuilder().build())
            .setPlatformVersion("platformVersion1848800485")
            .setDistribution("distribution-1580708220")
            .setClusterRegion("clusterRegion-1876082290")
            .setFleet(Fleet.newBuilder().build())
            .setUid("uid115792")
            .setReconciling(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setKubernetesVersion("kubernetesVersion-424816974")
            .putAllAnnotations(new HashMap<String, String>())
            .setWorkloadIdentityConfig(WorkloadIdentityConfig.newBuilder().build())
            .setLoggingConfig(LoggingConfig.newBuilder().build())
            .addAllErrors(new ArrayList<AttachedClusterError>())
            .setAuthorization(AttachedClustersAuthorization.newBuilder().build())
            .setMonitoringConfig(MonitoringConfig.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createAttachedClusterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    AttachedCluster attachedCluster = AttachedCluster.newBuilder().build();
    String attachedClusterId = "attachedClusterId865943409";

    AttachedCluster actualResponse =
        client.createAttachedClusterAsync(parent, attachedCluster, attachedClusterId).get();
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
  public void createAttachedClusterExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      AttachedCluster attachedCluster = AttachedCluster.newBuilder().build();
      String attachedClusterId = "attachedClusterId865943409";
      client.createAttachedClusterAsync(parent, attachedCluster, attachedClusterId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createAttachedClusterTest2() throws Exception {
    AttachedCluster expectedResponse =
        AttachedCluster.newBuilder()
            .setName(
                AttachedClusterName.of("[PROJECT]", "[LOCATION]", "[ATTACHED_CLUSTER]").toString())
            .setDescription("description-1724546052")
            .setOidcConfig(AttachedOidcConfig.newBuilder().build())
            .setPlatformVersion("platformVersion1848800485")
            .setDistribution("distribution-1580708220")
            .setClusterRegion("clusterRegion-1876082290")
            .setFleet(Fleet.newBuilder().build())
            .setUid("uid115792")
            .setReconciling(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setKubernetesVersion("kubernetesVersion-424816974")
            .putAllAnnotations(new HashMap<String, String>())
            .setWorkloadIdentityConfig(WorkloadIdentityConfig.newBuilder().build())
            .setLoggingConfig(LoggingConfig.newBuilder().build())
            .addAllErrors(new ArrayList<AttachedClusterError>())
            .setAuthorization(AttachedClustersAuthorization.newBuilder().build())
            .setMonitoringConfig(MonitoringConfig.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createAttachedClusterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5833/locations/location-5833";
    AttachedCluster attachedCluster = AttachedCluster.newBuilder().build();
    String attachedClusterId = "attachedClusterId865943409";

    AttachedCluster actualResponse =
        client.createAttachedClusterAsync(parent, attachedCluster, attachedClusterId).get();
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
  public void createAttachedClusterExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      AttachedCluster attachedCluster = AttachedCluster.newBuilder().build();
      String attachedClusterId = "attachedClusterId865943409";
      client.createAttachedClusterAsync(parent, attachedCluster, attachedClusterId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void updateAttachedClusterTest() throws Exception {
    AttachedCluster expectedResponse =
        AttachedCluster.newBuilder()
            .setName(
                AttachedClusterName.of("[PROJECT]", "[LOCATION]", "[ATTACHED_CLUSTER]").toString())
            .setDescription("description-1724546052")
            .setOidcConfig(AttachedOidcConfig.newBuilder().build())
            .setPlatformVersion("platformVersion1848800485")
            .setDistribution("distribution-1580708220")
            .setClusterRegion("clusterRegion-1876082290")
            .setFleet(Fleet.newBuilder().build())
            .setUid("uid115792")
            .setReconciling(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setKubernetesVersion("kubernetesVersion-424816974")
            .putAllAnnotations(new HashMap<String, String>())
            .setWorkloadIdentityConfig(WorkloadIdentityConfig.newBuilder().build())
            .setLoggingConfig(LoggingConfig.newBuilder().build())
            .addAllErrors(new ArrayList<AttachedClusterError>())
            .setAuthorization(AttachedClustersAuthorization.newBuilder().build())
            .setMonitoringConfig(MonitoringConfig.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateAttachedClusterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    AttachedCluster attachedCluster =
        AttachedCluster.newBuilder()
            .setName(
                AttachedClusterName.of("[PROJECT]", "[LOCATION]", "[ATTACHED_CLUSTER]").toString())
            .setDescription("description-1724546052")
            .setOidcConfig(AttachedOidcConfig.newBuilder().build())
            .setPlatformVersion("platformVersion1848800485")
            .setDistribution("distribution-1580708220")
            .setClusterRegion("clusterRegion-1876082290")
            .setFleet(Fleet.newBuilder().build())
            .setUid("uid115792")
            .setReconciling(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setKubernetesVersion("kubernetesVersion-424816974")
            .putAllAnnotations(new HashMap<String, String>())
            .setWorkloadIdentityConfig(WorkloadIdentityConfig.newBuilder().build())
            .setLoggingConfig(LoggingConfig.newBuilder().build())
            .addAllErrors(new ArrayList<AttachedClusterError>())
            .setAuthorization(AttachedClustersAuthorization.newBuilder().build())
            .setMonitoringConfig(MonitoringConfig.newBuilder().build())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    AttachedCluster actualResponse =
        client.updateAttachedClusterAsync(attachedCluster, updateMask).get();
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
  public void updateAttachedClusterExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AttachedCluster attachedCluster =
          AttachedCluster.newBuilder()
              .setName(
                  AttachedClusterName.of("[PROJECT]", "[LOCATION]", "[ATTACHED_CLUSTER]")
                      .toString())
              .setDescription("description-1724546052")
              .setOidcConfig(AttachedOidcConfig.newBuilder().build())
              .setPlatformVersion("platformVersion1848800485")
              .setDistribution("distribution-1580708220")
              .setClusterRegion("clusterRegion-1876082290")
              .setFleet(Fleet.newBuilder().build())
              .setUid("uid115792")
              .setReconciling(true)
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .setEtag("etag3123477")
              .setKubernetesVersion("kubernetesVersion-424816974")
              .putAllAnnotations(new HashMap<String, String>())
              .setWorkloadIdentityConfig(WorkloadIdentityConfig.newBuilder().build())
              .setLoggingConfig(LoggingConfig.newBuilder().build())
              .addAllErrors(new ArrayList<AttachedClusterError>())
              .setAuthorization(AttachedClustersAuthorization.newBuilder().build())
              .setMonitoringConfig(MonitoringConfig.newBuilder().build())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateAttachedClusterAsync(attachedCluster, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void importAttachedClusterTest() throws Exception {
    AttachedCluster expectedResponse =
        AttachedCluster.newBuilder()
            .setName(
                AttachedClusterName.of("[PROJECT]", "[LOCATION]", "[ATTACHED_CLUSTER]").toString())
            .setDescription("description-1724546052")
            .setOidcConfig(AttachedOidcConfig.newBuilder().build())
            .setPlatformVersion("platformVersion1848800485")
            .setDistribution("distribution-1580708220")
            .setClusterRegion("clusterRegion-1876082290")
            .setFleet(Fleet.newBuilder().build())
            .setUid("uid115792")
            .setReconciling(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setKubernetesVersion("kubernetesVersion-424816974")
            .putAllAnnotations(new HashMap<String, String>())
            .setWorkloadIdentityConfig(WorkloadIdentityConfig.newBuilder().build())
            .setLoggingConfig(LoggingConfig.newBuilder().build())
            .addAllErrors(new ArrayList<AttachedClusterError>())
            .setAuthorization(AttachedClustersAuthorization.newBuilder().build())
            .setMonitoringConfig(MonitoringConfig.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("importAttachedClusterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    String fleetMembership = "fleetMembership-665479228";

    AttachedCluster actualResponse =
        client.importAttachedClusterAsync(parent, fleetMembership).get();
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
  public void importAttachedClusterExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      String fleetMembership = "fleetMembership-665479228";
      client.importAttachedClusterAsync(parent, fleetMembership).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void importAttachedClusterTest2() throws Exception {
    AttachedCluster expectedResponse =
        AttachedCluster.newBuilder()
            .setName(
                AttachedClusterName.of("[PROJECT]", "[LOCATION]", "[ATTACHED_CLUSTER]").toString())
            .setDescription("description-1724546052")
            .setOidcConfig(AttachedOidcConfig.newBuilder().build())
            .setPlatformVersion("platformVersion1848800485")
            .setDistribution("distribution-1580708220")
            .setClusterRegion("clusterRegion-1876082290")
            .setFleet(Fleet.newBuilder().build())
            .setUid("uid115792")
            .setReconciling(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setKubernetesVersion("kubernetesVersion-424816974")
            .putAllAnnotations(new HashMap<String, String>())
            .setWorkloadIdentityConfig(WorkloadIdentityConfig.newBuilder().build())
            .setLoggingConfig(LoggingConfig.newBuilder().build())
            .addAllErrors(new ArrayList<AttachedClusterError>())
            .setAuthorization(AttachedClustersAuthorization.newBuilder().build())
            .setMonitoringConfig(MonitoringConfig.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("importAttachedClusterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5833/locations/location-5833";
    String fleetMembership = "fleetMembership-665479228";

    AttachedCluster actualResponse =
        client.importAttachedClusterAsync(parent, fleetMembership).get();
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
  public void importAttachedClusterExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      String fleetMembership = "fleetMembership-665479228";
      client.importAttachedClusterAsync(parent, fleetMembership).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void getAttachedClusterTest() throws Exception {
    AttachedCluster expectedResponse =
        AttachedCluster.newBuilder()
            .setName(
                AttachedClusterName.of("[PROJECT]", "[LOCATION]", "[ATTACHED_CLUSTER]").toString())
            .setDescription("description-1724546052")
            .setOidcConfig(AttachedOidcConfig.newBuilder().build())
            .setPlatformVersion("platformVersion1848800485")
            .setDistribution("distribution-1580708220")
            .setClusterRegion("clusterRegion-1876082290")
            .setFleet(Fleet.newBuilder().build())
            .setUid("uid115792")
            .setReconciling(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setKubernetesVersion("kubernetesVersion-424816974")
            .putAllAnnotations(new HashMap<String, String>())
            .setWorkloadIdentityConfig(WorkloadIdentityConfig.newBuilder().build())
            .setLoggingConfig(LoggingConfig.newBuilder().build())
            .addAllErrors(new ArrayList<AttachedClusterError>())
            .setAuthorization(AttachedClustersAuthorization.newBuilder().build())
            .setMonitoringConfig(MonitoringConfig.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    AttachedClusterName name =
        AttachedClusterName.of("[PROJECT]", "[LOCATION]", "[ATTACHED_CLUSTER]");

    AttachedCluster actualResponse = client.getAttachedCluster(name);
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
  public void getAttachedClusterExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AttachedClusterName name =
          AttachedClusterName.of("[PROJECT]", "[LOCATION]", "[ATTACHED_CLUSTER]");
      client.getAttachedCluster(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAttachedClusterTest2() throws Exception {
    AttachedCluster expectedResponse =
        AttachedCluster.newBuilder()
            .setName(
                AttachedClusterName.of("[PROJECT]", "[LOCATION]", "[ATTACHED_CLUSTER]").toString())
            .setDescription("description-1724546052")
            .setOidcConfig(AttachedOidcConfig.newBuilder().build())
            .setPlatformVersion("platformVersion1848800485")
            .setDistribution("distribution-1580708220")
            .setClusterRegion("clusterRegion-1876082290")
            .setFleet(Fleet.newBuilder().build())
            .setUid("uid115792")
            .setReconciling(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setKubernetesVersion("kubernetesVersion-424816974")
            .putAllAnnotations(new HashMap<String, String>())
            .setWorkloadIdentityConfig(WorkloadIdentityConfig.newBuilder().build())
            .setLoggingConfig(LoggingConfig.newBuilder().build())
            .addAllErrors(new ArrayList<AttachedClusterError>())
            .setAuthorization(AttachedClustersAuthorization.newBuilder().build())
            .setMonitoringConfig(MonitoringConfig.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-8899/locations/location-8899/attachedClusters/attachedCluster-8899";

    AttachedCluster actualResponse = client.getAttachedCluster(name);
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
  public void getAttachedClusterExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-8899/locations/location-8899/attachedClusters/attachedCluster-8899";
      client.getAttachedCluster(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAttachedClustersTest() throws Exception {
    AttachedCluster responsesElement = AttachedCluster.newBuilder().build();
    ListAttachedClustersResponse expectedResponse =
        ListAttachedClustersResponse.newBuilder()
            .setNextPageToken("")
            .addAllAttachedClusters(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListAttachedClustersPagedResponse pagedListResponse = client.listAttachedClusters(parent);

    List<AttachedCluster> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAttachedClustersList().get(0), resources.get(0));

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
  public void listAttachedClustersExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listAttachedClusters(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAttachedClustersTest2() throws Exception {
    AttachedCluster responsesElement = AttachedCluster.newBuilder().build();
    ListAttachedClustersResponse expectedResponse =
        ListAttachedClustersResponse.newBuilder()
            .setNextPageToken("")
            .addAllAttachedClusters(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListAttachedClustersPagedResponse pagedListResponse = client.listAttachedClusters(parent);

    List<AttachedCluster> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAttachedClustersList().get(0), resources.get(0));

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
  public void listAttachedClustersExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listAttachedClusters(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteAttachedClusterTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteAttachedClusterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    AttachedClusterName name =
        AttachedClusterName.of("[PROJECT]", "[LOCATION]", "[ATTACHED_CLUSTER]");

    client.deleteAttachedClusterAsync(name).get();

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
  public void deleteAttachedClusterExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AttachedClusterName name =
          AttachedClusterName.of("[PROJECT]", "[LOCATION]", "[ATTACHED_CLUSTER]");
      client.deleteAttachedClusterAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteAttachedClusterTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteAttachedClusterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name =
        "projects/project-8899/locations/location-8899/attachedClusters/attachedCluster-8899";

    client.deleteAttachedClusterAsync(name).get();

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
  public void deleteAttachedClusterExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-8899/locations/location-8899/attachedClusters/attachedCluster-8899";
      client.deleteAttachedClusterAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void getAttachedServerConfigTest() throws Exception {
    AttachedServerConfig expectedResponse =
        AttachedServerConfig.newBuilder()
            .setName(AttachedServerConfigName.of("[PROJECT]", "[LOCATION]").toString())
            .addAllValidVersions(new ArrayList<AttachedPlatformVersionInfo>())
            .build();
    mockService.addResponse(expectedResponse);

    AttachedServerConfigName name = AttachedServerConfigName.of("[PROJECT]", "[LOCATION]");

    AttachedServerConfig actualResponse = client.getAttachedServerConfig(name);
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
  public void getAttachedServerConfigExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AttachedServerConfigName name = AttachedServerConfigName.of("[PROJECT]", "[LOCATION]");
      client.getAttachedServerConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAttachedServerConfigTest2() throws Exception {
    AttachedServerConfig expectedResponse =
        AttachedServerConfig.newBuilder()
            .setName(AttachedServerConfigName.of("[PROJECT]", "[LOCATION]").toString())
            .addAllValidVersions(new ArrayList<AttachedPlatformVersionInfo>())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-9678/locations/location-9678/attachedServerConfig";

    AttachedServerConfig actualResponse = client.getAttachedServerConfig(name);
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
  public void getAttachedServerConfigExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-9678/locations/location-9678/attachedServerConfig";
      client.getAttachedServerConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void generateAttachedClusterInstallManifestTest() throws Exception {
    GenerateAttachedClusterInstallManifestResponse expectedResponse =
        GenerateAttachedClusterInstallManifestResponse.newBuilder()
            .setManifest("manifest130625071")
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    String attachedClusterId = "attachedClusterId865943409";

    GenerateAttachedClusterInstallManifestResponse actualResponse =
        client.generateAttachedClusterInstallManifest(parent, attachedClusterId);
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
  public void generateAttachedClusterInstallManifestExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      String attachedClusterId = "attachedClusterId865943409";
      client.generateAttachedClusterInstallManifest(parent, attachedClusterId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void generateAttachedClusterInstallManifestTest2() throws Exception {
    GenerateAttachedClusterInstallManifestResponse expectedResponse =
        GenerateAttachedClusterInstallManifestResponse.newBuilder()
            .setManifest("manifest130625071")
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";
    String attachedClusterId = "attachedClusterId865943409";

    GenerateAttachedClusterInstallManifestResponse actualResponse =
        client.generateAttachedClusterInstallManifest(parent, attachedClusterId);
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
  public void generateAttachedClusterInstallManifestExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      String attachedClusterId = "attachedClusterId865943409";
      client.generateAttachedClusterInstallManifest(parent, attachedClusterId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
