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

import static com.google.cloud.gkemulticloud.v1.AwsClustersClient.ListAwsClustersPagedResponse;
import static com.google.cloud.gkemulticloud.v1.AwsClustersClient.ListAwsNodePoolsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.gkemulticloud.v1.stub.HttpJsonAwsClustersStub;
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
public class AwsClustersClientHttpJsonTest {
  private static MockHttpService mockService;
  private static AwsClustersClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonAwsClustersStub.getMethodDescriptors(),
            AwsClustersSettings.getDefaultEndpoint());
    AwsClustersSettings settings =
        AwsClustersSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                AwsClustersSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = AwsClustersClient.create(settings);
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
  public void createAwsClusterTest() throws Exception {
    AwsCluster expectedResponse =
        AwsCluster.newBuilder()
            .setName(AwsClusterName.of("[PROJECT]", "[LOCATION]", "[AWS_CLUSTER]").toString())
            .setDescription("description-1724546052")
            .setNetworking(AwsClusterNetworking.newBuilder().build())
            .setAwsRegion("awsRegion-860644271")
            .setControlPlane(AwsControlPlane.newBuilder().build())
            .setAuthorization(AwsAuthorization.newBuilder().build())
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
            .setLoggingConfig(LoggingConfig.newBuilder().build())
            .addAllErrors(new ArrayList<AwsClusterError>())
            .setMonitoringConfig(MonitoringConfig.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createAwsClusterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    AwsCluster awsCluster = AwsCluster.newBuilder().build();
    String awsClusterId = "awsClusterId1988965944";

    AwsCluster actualResponse =
        client.createAwsClusterAsync(parent, awsCluster, awsClusterId).get();
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
  public void createAwsClusterExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      AwsCluster awsCluster = AwsCluster.newBuilder().build();
      String awsClusterId = "awsClusterId1988965944";
      client.createAwsClusterAsync(parent, awsCluster, awsClusterId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createAwsClusterTest2() throws Exception {
    AwsCluster expectedResponse =
        AwsCluster.newBuilder()
            .setName(AwsClusterName.of("[PROJECT]", "[LOCATION]", "[AWS_CLUSTER]").toString())
            .setDescription("description-1724546052")
            .setNetworking(AwsClusterNetworking.newBuilder().build())
            .setAwsRegion("awsRegion-860644271")
            .setControlPlane(AwsControlPlane.newBuilder().build())
            .setAuthorization(AwsAuthorization.newBuilder().build())
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
            .setLoggingConfig(LoggingConfig.newBuilder().build())
            .addAllErrors(new ArrayList<AwsClusterError>())
            .setMonitoringConfig(MonitoringConfig.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createAwsClusterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5833/locations/location-5833";
    AwsCluster awsCluster = AwsCluster.newBuilder().build();
    String awsClusterId = "awsClusterId1988965944";

    AwsCluster actualResponse =
        client.createAwsClusterAsync(parent, awsCluster, awsClusterId).get();
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
  public void createAwsClusterExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      AwsCluster awsCluster = AwsCluster.newBuilder().build();
      String awsClusterId = "awsClusterId1988965944";
      client.createAwsClusterAsync(parent, awsCluster, awsClusterId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void updateAwsClusterTest() throws Exception {
    AwsCluster expectedResponse =
        AwsCluster.newBuilder()
            .setName(AwsClusterName.of("[PROJECT]", "[LOCATION]", "[AWS_CLUSTER]").toString())
            .setDescription("description-1724546052")
            .setNetworking(AwsClusterNetworking.newBuilder().build())
            .setAwsRegion("awsRegion-860644271")
            .setControlPlane(AwsControlPlane.newBuilder().build())
            .setAuthorization(AwsAuthorization.newBuilder().build())
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
            .setLoggingConfig(LoggingConfig.newBuilder().build())
            .addAllErrors(new ArrayList<AwsClusterError>())
            .setMonitoringConfig(MonitoringConfig.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateAwsClusterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    AwsCluster awsCluster =
        AwsCluster.newBuilder()
            .setName(AwsClusterName.of("[PROJECT]", "[LOCATION]", "[AWS_CLUSTER]").toString())
            .setDescription("description-1724546052")
            .setNetworking(AwsClusterNetworking.newBuilder().build())
            .setAwsRegion("awsRegion-860644271")
            .setControlPlane(AwsControlPlane.newBuilder().build())
            .setAuthorization(AwsAuthorization.newBuilder().build())
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
            .setLoggingConfig(LoggingConfig.newBuilder().build())
            .addAllErrors(new ArrayList<AwsClusterError>())
            .setMonitoringConfig(MonitoringConfig.newBuilder().build())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    AwsCluster actualResponse = client.updateAwsClusterAsync(awsCluster, updateMask).get();
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
  public void updateAwsClusterExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AwsCluster awsCluster =
          AwsCluster.newBuilder()
              .setName(AwsClusterName.of("[PROJECT]", "[LOCATION]", "[AWS_CLUSTER]").toString())
              .setDescription("description-1724546052")
              .setNetworking(AwsClusterNetworking.newBuilder().build())
              .setAwsRegion("awsRegion-860644271")
              .setControlPlane(AwsControlPlane.newBuilder().build())
              .setAuthorization(AwsAuthorization.newBuilder().build())
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
              .setLoggingConfig(LoggingConfig.newBuilder().build())
              .addAllErrors(new ArrayList<AwsClusterError>())
              .setMonitoringConfig(MonitoringConfig.newBuilder().build())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateAwsClusterAsync(awsCluster, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void getAwsClusterTest() throws Exception {
    AwsCluster expectedResponse =
        AwsCluster.newBuilder()
            .setName(AwsClusterName.of("[PROJECT]", "[LOCATION]", "[AWS_CLUSTER]").toString())
            .setDescription("description-1724546052")
            .setNetworking(AwsClusterNetworking.newBuilder().build())
            .setAwsRegion("awsRegion-860644271")
            .setControlPlane(AwsControlPlane.newBuilder().build())
            .setAuthorization(AwsAuthorization.newBuilder().build())
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
            .setLoggingConfig(LoggingConfig.newBuilder().build())
            .addAllErrors(new ArrayList<AwsClusterError>())
            .setMonitoringConfig(MonitoringConfig.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    AwsClusterName name = AwsClusterName.of("[PROJECT]", "[LOCATION]", "[AWS_CLUSTER]");

    AwsCluster actualResponse = client.getAwsCluster(name);
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
  public void getAwsClusterExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AwsClusterName name = AwsClusterName.of("[PROJECT]", "[LOCATION]", "[AWS_CLUSTER]");
      client.getAwsCluster(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAwsClusterTest2() throws Exception {
    AwsCluster expectedResponse =
        AwsCluster.newBuilder()
            .setName(AwsClusterName.of("[PROJECT]", "[LOCATION]", "[AWS_CLUSTER]").toString())
            .setDescription("description-1724546052")
            .setNetworking(AwsClusterNetworking.newBuilder().build())
            .setAwsRegion("awsRegion-860644271")
            .setControlPlane(AwsControlPlane.newBuilder().build())
            .setAuthorization(AwsAuthorization.newBuilder().build())
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
            .setLoggingConfig(LoggingConfig.newBuilder().build())
            .addAllErrors(new ArrayList<AwsClusterError>())
            .setMonitoringConfig(MonitoringConfig.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-1220/locations/location-1220/awsClusters/awsCluster-1220";

    AwsCluster actualResponse = client.getAwsCluster(name);
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
  public void getAwsClusterExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-1220/locations/location-1220/awsClusters/awsCluster-1220";
      client.getAwsCluster(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAwsClustersTest() throws Exception {
    AwsCluster responsesElement = AwsCluster.newBuilder().build();
    ListAwsClustersResponse expectedResponse =
        ListAwsClustersResponse.newBuilder()
            .setNextPageToken("")
            .addAllAwsClusters(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListAwsClustersPagedResponse pagedListResponse = client.listAwsClusters(parent);

    List<AwsCluster> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAwsClustersList().get(0), resources.get(0));

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
  public void listAwsClustersExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listAwsClusters(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAwsClustersTest2() throws Exception {
    AwsCluster responsesElement = AwsCluster.newBuilder().build();
    ListAwsClustersResponse expectedResponse =
        ListAwsClustersResponse.newBuilder()
            .setNextPageToken("")
            .addAllAwsClusters(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListAwsClustersPagedResponse pagedListResponse = client.listAwsClusters(parent);

    List<AwsCluster> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAwsClustersList().get(0), resources.get(0));

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
  public void listAwsClustersExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listAwsClusters(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteAwsClusterTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteAwsClusterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    AwsClusterName name = AwsClusterName.of("[PROJECT]", "[LOCATION]", "[AWS_CLUSTER]");

    client.deleteAwsClusterAsync(name).get();

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
  public void deleteAwsClusterExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AwsClusterName name = AwsClusterName.of("[PROJECT]", "[LOCATION]", "[AWS_CLUSTER]");
      client.deleteAwsClusterAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteAwsClusterTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteAwsClusterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name = "projects/project-1220/locations/location-1220/awsClusters/awsCluster-1220";

    client.deleteAwsClusterAsync(name).get();

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
  public void deleteAwsClusterExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-1220/locations/location-1220/awsClusters/awsCluster-1220";
      client.deleteAwsClusterAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void generateAwsAccessTokenTest() throws Exception {
    GenerateAwsAccessTokenResponse expectedResponse =
        GenerateAwsAccessTokenResponse.newBuilder()
            .setAccessToken("accessToken-1042689291")
            .setExpirationTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    GenerateAwsAccessTokenRequest request =
        GenerateAwsAccessTokenRequest.newBuilder()
            .setAwsCluster(AwsClusterName.of("[PROJECT]", "[LOCATION]", "[AWS_CLUSTER]").toString())
            .build();

    GenerateAwsAccessTokenResponse actualResponse = client.generateAwsAccessToken(request);
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
  public void generateAwsAccessTokenExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GenerateAwsAccessTokenRequest request =
          GenerateAwsAccessTokenRequest.newBuilder()
              .setAwsCluster(
                  AwsClusterName.of("[PROJECT]", "[LOCATION]", "[AWS_CLUSTER]").toString())
              .build();
      client.generateAwsAccessToken(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createAwsNodePoolTest() throws Exception {
    AwsNodePool expectedResponse =
        AwsNodePool.newBuilder()
            .setName(
                AwsNodePoolName.of("[PROJECT]", "[LOCATION]", "[AWS_CLUSTER]", "[AWS_NODE_POOL]")
                    .toString())
            .setVersion("version351608024")
            .setConfig(AwsNodeConfig.newBuilder().build())
            .setAutoscaling(AwsNodePoolAutoscaling.newBuilder().build())
            .setSubnetId("subnetId-2066159272")
            .setUid("uid115792")
            .setReconciling(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .putAllAnnotations(new HashMap<String, String>())
            .setMaxPodsConstraint(MaxPodsConstraint.newBuilder().build())
            .addAllErrors(new ArrayList<AwsNodePoolError>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createAwsNodePoolTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    AwsClusterName parent = AwsClusterName.of("[PROJECT]", "[LOCATION]", "[AWS_CLUSTER]");
    AwsNodePool awsNodePool = AwsNodePool.newBuilder().build();
    String awsNodePoolId = "awsNodePoolId-1885267498";

    AwsNodePool actualResponse =
        client.createAwsNodePoolAsync(parent, awsNodePool, awsNodePoolId).get();
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
  public void createAwsNodePoolExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AwsClusterName parent = AwsClusterName.of("[PROJECT]", "[LOCATION]", "[AWS_CLUSTER]");
      AwsNodePool awsNodePool = AwsNodePool.newBuilder().build();
      String awsNodePoolId = "awsNodePoolId-1885267498";
      client.createAwsNodePoolAsync(parent, awsNodePool, awsNodePoolId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createAwsNodePoolTest2() throws Exception {
    AwsNodePool expectedResponse =
        AwsNodePool.newBuilder()
            .setName(
                AwsNodePoolName.of("[PROJECT]", "[LOCATION]", "[AWS_CLUSTER]", "[AWS_NODE_POOL]")
                    .toString())
            .setVersion("version351608024")
            .setConfig(AwsNodeConfig.newBuilder().build())
            .setAutoscaling(AwsNodePoolAutoscaling.newBuilder().build())
            .setSubnetId("subnetId-2066159272")
            .setUid("uid115792")
            .setReconciling(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .putAllAnnotations(new HashMap<String, String>())
            .setMaxPodsConstraint(MaxPodsConstraint.newBuilder().build())
            .addAllErrors(new ArrayList<AwsNodePoolError>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createAwsNodePoolTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-2069/locations/location-2069/awsClusters/awsCluster-2069";
    AwsNodePool awsNodePool = AwsNodePool.newBuilder().build();
    String awsNodePoolId = "awsNodePoolId-1885267498";

    AwsNodePool actualResponse =
        client.createAwsNodePoolAsync(parent, awsNodePool, awsNodePoolId).get();
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
  public void createAwsNodePoolExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-2069/locations/location-2069/awsClusters/awsCluster-2069";
      AwsNodePool awsNodePool = AwsNodePool.newBuilder().build();
      String awsNodePoolId = "awsNodePoolId-1885267498";
      client.createAwsNodePoolAsync(parent, awsNodePool, awsNodePoolId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void updateAwsNodePoolTest() throws Exception {
    AwsNodePool expectedResponse =
        AwsNodePool.newBuilder()
            .setName(
                AwsNodePoolName.of("[PROJECT]", "[LOCATION]", "[AWS_CLUSTER]", "[AWS_NODE_POOL]")
                    .toString())
            .setVersion("version351608024")
            .setConfig(AwsNodeConfig.newBuilder().build())
            .setAutoscaling(AwsNodePoolAutoscaling.newBuilder().build())
            .setSubnetId("subnetId-2066159272")
            .setUid("uid115792")
            .setReconciling(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .putAllAnnotations(new HashMap<String, String>())
            .setMaxPodsConstraint(MaxPodsConstraint.newBuilder().build())
            .addAllErrors(new ArrayList<AwsNodePoolError>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateAwsNodePoolTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    AwsNodePool awsNodePool =
        AwsNodePool.newBuilder()
            .setName(
                AwsNodePoolName.of("[PROJECT]", "[LOCATION]", "[AWS_CLUSTER]", "[AWS_NODE_POOL]")
                    .toString())
            .setVersion("version351608024")
            .setConfig(AwsNodeConfig.newBuilder().build())
            .setAutoscaling(AwsNodePoolAutoscaling.newBuilder().build())
            .setSubnetId("subnetId-2066159272")
            .setUid("uid115792")
            .setReconciling(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .putAllAnnotations(new HashMap<String, String>())
            .setMaxPodsConstraint(MaxPodsConstraint.newBuilder().build())
            .addAllErrors(new ArrayList<AwsNodePoolError>())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    AwsNodePool actualResponse = client.updateAwsNodePoolAsync(awsNodePool, updateMask).get();
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
  public void updateAwsNodePoolExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AwsNodePool awsNodePool =
          AwsNodePool.newBuilder()
              .setName(
                  AwsNodePoolName.of("[PROJECT]", "[LOCATION]", "[AWS_CLUSTER]", "[AWS_NODE_POOL]")
                      .toString())
              .setVersion("version351608024")
              .setConfig(AwsNodeConfig.newBuilder().build())
              .setAutoscaling(AwsNodePoolAutoscaling.newBuilder().build())
              .setSubnetId("subnetId-2066159272")
              .setUid("uid115792")
              .setReconciling(true)
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .setEtag("etag3123477")
              .putAllAnnotations(new HashMap<String, String>())
              .setMaxPodsConstraint(MaxPodsConstraint.newBuilder().build())
              .addAllErrors(new ArrayList<AwsNodePoolError>())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateAwsNodePoolAsync(awsNodePool, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void getAwsNodePoolTest() throws Exception {
    AwsNodePool expectedResponse =
        AwsNodePool.newBuilder()
            .setName(
                AwsNodePoolName.of("[PROJECT]", "[LOCATION]", "[AWS_CLUSTER]", "[AWS_NODE_POOL]")
                    .toString())
            .setVersion("version351608024")
            .setConfig(AwsNodeConfig.newBuilder().build())
            .setAutoscaling(AwsNodePoolAutoscaling.newBuilder().build())
            .setSubnetId("subnetId-2066159272")
            .setUid("uid115792")
            .setReconciling(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .putAllAnnotations(new HashMap<String, String>())
            .setMaxPodsConstraint(MaxPodsConstraint.newBuilder().build())
            .addAllErrors(new ArrayList<AwsNodePoolError>())
            .build();
    mockService.addResponse(expectedResponse);

    AwsNodePoolName name =
        AwsNodePoolName.of("[PROJECT]", "[LOCATION]", "[AWS_CLUSTER]", "[AWS_NODE_POOL]");

    AwsNodePool actualResponse = client.getAwsNodePool(name);
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
  public void getAwsNodePoolExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AwsNodePoolName name =
          AwsNodePoolName.of("[PROJECT]", "[LOCATION]", "[AWS_CLUSTER]", "[AWS_NODE_POOL]");
      client.getAwsNodePool(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAwsNodePoolTest2() throws Exception {
    AwsNodePool expectedResponse =
        AwsNodePool.newBuilder()
            .setName(
                AwsNodePoolName.of("[PROJECT]", "[LOCATION]", "[AWS_CLUSTER]", "[AWS_NODE_POOL]")
                    .toString())
            .setVersion("version351608024")
            .setConfig(AwsNodeConfig.newBuilder().build())
            .setAutoscaling(AwsNodePoolAutoscaling.newBuilder().build())
            .setSubnetId("subnetId-2066159272")
            .setUid("uid115792")
            .setReconciling(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .putAllAnnotations(new HashMap<String, String>())
            .setMaxPodsConstraint(MaxPodsConstraint.newBuilder().build())
            .addAllErrors(new ArrayList<AwsNodePoolError>())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-9334/locations/location-9334/awsClusters/awsCluster-9334/awsNodePools/awsNodePool-9334";

    AwsNodePool actualResponse = client.getAwsNodePool(name);
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
  public void getAwsNodePoolExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-9334/locations/location-9334/awsClusters/awsCluster-9334/awsNodePools/awsNodePool-9334";
      client.getAwsNodePool(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAwsNodePoolsTest() throws Exception {
    AwsNodePool responsesElement = AwsNodePool.newBuilder().build();
    ListAwsNodePoolsResponse expectedResponse =
        ListAwsNodePoolsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAwsNodePools(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    AwsClusterName parent = AwsClusterName.of("[PROJECT]", "[LOCATION]", "[AWS_CLUSTER]");

    ListAwsNodePoolsPagedResponse pagedListResponse = client.listAwsNodePools(parent);

    List<AwsNodePool> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAwsNodePoolsList().get(0), resources.get(0));

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
  public void listAwsNodePoolsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AwsClusterName parent = AwsClusterName.of("[PROJECT]", "[LOCATION]", "[AWS_CLUSTER]");
      client.listAwsNodePools(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAwsNodePoolsTest2() throws Exception {
    AwsNodePool responsesElement = AwsNodePool.newBuilder().build();
    ListAwsNodePoolsResponse expectedResponse =
        ListAwsNodePoolsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAwsNodePools(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-2069/locations/location-2069/awsClusters/awsCluster-2069";

    ListAwsNodePoolsPagedResponse pagedListResponse = client.listAwsNodePools(parent);

    List<AwsNodePool> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAwsNodePoolsList().get(0), resources.get(0));

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
  public void listAwsNodePoolsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-2069/locations/location-2069/awsClusters/awsCluster-2069";
      client.listAwsNodePools(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteAwsNodePoolTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteAwsNodePoolTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    AwsNodePoolName name =
        AwsNodePoolName.of("[PROJECT]", "[LOCATION]", "[AWS_CLUSTER]", "[AWS_NODE_POOL]");

    client.deleteAwsNodePoolAsync(name).get();

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
  public void deleteAwsNodePoolExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AwsNodePoolName name =
          AwsNodePoolName.of("[PROJECT]", "[LOCATION]", "[AWS_CLUSTER]", "[AWS_NODE_POOL]");
      client.deleteAwsNodePoolAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteAwsNodePoolTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteAwsNodePoolTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name =
        "projects/project-9334/locations/location-9334/awsClusters/awsCluster-9334/awsNodePools/awsNodePool-9334";

    client.deleteAwsNodePoolAsync(name).get();

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
  public void deleteAwsNodePoolExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-9334/locations/location-9334/awsClusters/awsCluster-9334/awsNodePools/awsNodePool-9334";
      client.deleteAwsNodePoolAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void getAwsServerConfigTest() throws Exception {
    AwsServerConfig expectedResponse =
        AwsServerConfig.newBuilder()
            .setName(AwsServerConfigName.of("[PROJECT]", "[LOCATION]").toString())
            .addAllValidVersions(new ArrayList<AwsK8sVersionInfo>())
            .addAllSupportedAwsRegions(new ArrayList<String>())
            .build();
    mockService.addResponse(expectedResponse);

    AwsServerConfigName name = AwsServerConfigName.of("[PROJECT]", "[LOCATION]");

    AwsServerConfig actualResponse = client.getAwsServerConfig(name);
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
  public void getAwsServerConfigExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AwsServerConfigName name = AwsServerConfigName.of("[PROJECT]", "[LOCATION]");
      client.getAwsServerConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAwsServerConfigTest2() throws Exception {
    AwsServerConfig expectedResponse =
        AwsServerConfig.newBuilder()
            .setName(AwsServerConfigName.of("[PROJECT]", "[LOCATION]").toString())
            .addAllValidVersions(new ArrayList<AwsK8sVersionInfo>())
            .addAllSupportedAwsRegions(new ArrayList<String>())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-5245/locations/location-5245/awsServerConfig";

    AwsServerConfig actualResponse = client.getAwsServerConfig(name);
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
  public void getAwsServerConfigExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-5245/locations/location-5245/awsServerConfig";
      client.getAwsServerConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
