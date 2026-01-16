/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.run.v2;

import static com.google.cloud.run.v2.InstancesClient.ListInstancesPagedResponse;

import com.google.api.LaunchStage;
import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.run.v2.stub.HttpJsonInstancesStub;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Any;
import com.google.protobuf.Duration;
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
public class InstancesClientHttpJsonTest {
  private static MockHttpService mockService;
  private static InstancesClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonInstancesStub.getMethodDescriptors(), InstancesSettings.getDefaultEndpoint());
    InstancesSettings settings =
        InstancesSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                InstancesSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = InstancesClient.create(settings);
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
  public void createInstanceTest() throws Exception {
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
            .setDescription("description-1724546052")
            .setUid("uid115792")
            .setGeneration(305703192)
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .setCreator("creator1028554796")
            .setLastModifier("lastModifier1959003021")
            .setClient("client-1357712437")
            .setClientVersion("clientVersion771880589")
            .setLaunchStage(LaunchStage.forNumber(0))
            .setBinaryAuthorization(BinaryAuthorization.newBuilder().build())
            .setVpcAccess(VpcAccess.newBuilder().build())
            .setServiceAccount("serviceAccount1079137720")
            .addAllContainers(new ArrayList<Container>())
            .addAllVolumes(new ArrayList<Volume>())
            .setEncryptionKey("encryptionKey-36224036")
            .setEncryptionKeyRevocationAction(EncryptionKeyRevocationAction.forNumber(0))
            .setEncryptionKeyShutdownDuration(Duration.newBuilder().build())
            .setNodeSelector(NodeSelector.newBuilder().build())
            .setGpuZonalRedundancyDisabled(true)
            .setIngress(IngressTraffic.forNumber(0))
            .setInvokerIamDisabled(true)
            .setIapEnabled(true)
            .setObservedGeneration(900833007)
            .setLogUri("logUri-1097354360")
            .setTerminalCondition(Condition.newBuilder().build())
            .addAllConditions(new ArrayList<Condition>())
            .addAllContainerStatuses(new ArrayList<ContainerStatus>())
            .setSatisfiesPzs(true)
            .addAllUrls(new ArrayList<String>())
            .setReconciling(true)
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createInstanceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Instance instance = Instance.newBuilder().build();

    Instance actualResponse = client.createInstanceAsync(parent, instance).get();
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
  public void createInstanceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Instance instance = Instance.newBuilder().build();
      client.createInstanceAsync(parent, instance).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createInstanceTest2() throws Exception {
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
            .setDescription("description-1724546052")
            .setUid("uid115792")
            .setGeneration(305703192)
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .setCreator("creator1028554796")
            .setLastModifier("lastModifier1959003021")
            .setClient("client-1357712437")
            .setClientVersion("clientVersion771880589")
            .setLaunchStage(LaunchStage.forNumber(0))
            .setBinaryAuthorization(BinaryAuthorization.newBuilder().build())
            .setVpcAccess(VpcAccess.newBuilder().build())
            .setServiceAccount("serviceAccount1079137720")
            .addAllContainers(new ArrayList<Container>())
            .addAllVolumes(new ArrayList<Volume>())
            .setEncryptionKey("encryptionKey-36224036")
            .setEncryptionKeyRevocationAction(EncryptionKeyRevocationAction.forNumber(0))
            .setEncryptionKeyShutdownDuration(Duration.newBuilder().build())
            .setNodeSelector(NodeSelector.newBuilder().build())
            .setGpuZonalRedundancyDisabled(true)
            .setIngress(IngressTraffic.forNumber(0))
            .setInvokerIamDisabled(true)
            .setIapEnabled(true)
            .setObservedGeneration(900833007)
            .setLogUri("logUri-1097354360")
            .setTerminalCondition(Condition.newBuilder().build())
            .addAllConditions(new ArrayList<Condition>())
            .addAllContainerStatuses(new ArrayList<ContainerStatus>())
            .setSatisfiesPzs(true)
            .addAllUrls(new ArrayList<String>())
            .setReconciling(true)
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createInstanceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5833/locations/location-5833";
    Instance instance = Instance.newBuilder().build();

    Instance actualResponse = client.createInstanceAsync(parent, instance).get();
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
  public void createInstanceExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      Instance instance = Instance.newBuilder().build();
      client.createInstanceAsync(parent, instance).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteInstanceTest() throws Exception {
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
            .setDescription("description-1724546052")
            .setUid("uid115792")
            .setGeneration(305703192)
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .setCreator("creator1028554796")
            .setLastModifier("lastModifier1959003021")
            .setClient("client-1357712437")
            .setClientVersion("clientVersion771880589")
            .setLaunchStage(LaunchStage.forNumber(0))
            .setBinaryAuthorization(BinaryAuthorization.newBuilder().build())
            .setVpcAccess(VpcAccess.newBuilder().build())
            .setServiceAccount("serviceAccount1079137720")
            .addAllContainers(new ArrayList<Container>())
            .addAllVolumes(new ArrayList<Volume>())
            .setEncryptionKey("encryptionKey-36224036")
            .setEncryptionKeyRevocationAction(EncryptionKeyRevocationAction.forNumber(0))
            .setEncryptionKeyShutdownDuration(Duration.newBuilder().build())
            .setNodeSelector(NodeSelector.newBuilder().build())
            .setGpuZonalRedundancyDisabled(true)
            .setIngress(IngressTraffic.forNumber(0))
            .setInvokerIamDisabled(true)
            .setIapEnabled(true)
            .setObservedGeneration(900833007)
            .setLogUri("logUri-1097354360")
            .setTerminalCondition(Condition.newBuilder().build())
            .addAllConditions(new ArrayList<Condition>())
            .addAllContainerStatuses(new ArrayList<ContainerStatus>())
            .setSatisfiesPzs(true)
            .addAllUrls(new ArrayList<String>())
            .setReconciling(true)
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteInstanceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");

    Instance actualResponse = client.deleteInstanceAsync(name).get();
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
  public void deleteInstanceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      client.deleteInstanceAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteInstanceTest2() throws Exception {
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
            .setDescription("description-1724546052")
            .setUid("uid115792")
            .setGeneration(305703192)
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .setCreator("creator1028554796")
            .setLastModifier("lastModifier1959003021")
            .setClient("client-1357712437")
            .setClientVersion("clientVersion771880589")
            .setLaunchStage(LaunchStage.forNumber(0))
            .setBinaryAuthorization(BinaryAuthorization.newBuilder().build())
            .setVpcAccess(VpcAccess.newBuilder().build())
            .setServiceAccount("serviceAccount1079137720")
            .addAllContainers(new ArrayList<Container>())
            .addAllVolumes(new ArrayList<Volume>())
            .setEncryptionKey("encryptionKey-36224036")
            .setEncryptionKeyRevocationAction(EncryptionKeyRevocationAction.forNumber(0))
            .setEncryptionKeyShutdownDuration(Duration.newBuilder().build())
            .setNodeSelector(NodeSelector.newBuilder().build())
            .setGpuZonalRedundancyDisabled(true)
            .setIngress(IngressTraffic.forNumber(0))
            .setInvokerIamDisabled(true)
            .setIapEnabled(true)
            .setObservedGeneration(900833007)
            .setLogUri("logUri-1097354360")
            .setTerminalCondition(Condition.newBuilder().build())
            .addAllConditions(new ArrayList<Condition>())
            .addAllContainerStatuses(new ArrayList<ContainerStatus>())
            .setSatisfiesPzs(true)
            .addAllUrls(new ArrayList<String>())
            .setReconciling(true)
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteInstanceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name = "projects/project-9412/locations/location-9412/instances/instance-9412";

    Instance actualResponse = client.deleteInstanceAsync(name).get();
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
  public void deleteInstanceExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-9412/locations/location-9412/instances/instance-9412";
      client.deleteInstanceAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void getInstanceTest() throws Exception {
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
            .setDescription("description-1724546052")
            .setUid("uid115792")
            .setGeneration(305703192)
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .setCreator("creator1028554796")
            .setLastModifier("lastModifier1959003021")
            .setClient("client-1357712437")
            .setClientVersion("clientVersion771880589")
            .setLaunchStage(LaunchStage.forNumber(0))
            .setBinaryAuthorization(BinaryAuthorization.newBuilder().build())
            .setVpcAccess(VpcAccess.newBuilder().build())
            .setServiceAccount("serviceAccount1079137720")
            .addAllContainers(new ArrayList<Container>())
            .addAllVolumes(new ArrayList<Volume>())
            .setEncryptionKey("encryptionKey-36224036")
            .setEncryptionKeyRevocationAction(EncryptionKeyRevocationAction.forNumber(0))
            .setEncryptionKeyShutdownDuration(Duration.newBuilder().build())
            .setNodeSelector(NodeSelector.newBuilder().build())
            .setGpuZonalRedundancyDisabled(true)
            .setIngress(IngressTraffic.forNumber(0))
            .setInvokerIamDisabled(true)
            .setIapEnabled(true)
            .setObservedGeneration(900833007)
            .setLogUri("logUri-1097354360")
            .setTerminalCondition(Condition.newBuilder().build())
            .addAllConditions(new ArrayList<Condition>())
            .addAllContainerStatuses(new ArrayList<ContainerStatus>())
            .setSatisfiesPzs(true)
            .addAllUrls(new ArrayList<String>())
            .setReconciling(true)
            .setEtag("etag3123477")
            .build();
    mockService.addResponse(expectedResponse);

    InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");

    Instance actualResponse = client.getInstance(name);
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
  public void getInstanceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      client.getInstance(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getInstanceTest2() throws Exception {
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
            .setDescription("description-1724546052")
            .setUid("uid115792")
            .setGeneration(305703192)
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .setCreator("creator1028554796")
            .setLastModifier("lastModifier1959003021")
            .setClient("client-1357712437")
            .setClientVersion("clientVersion771880589")
            .setLaunchStage(LaunchStage.forNumber(0))
            .setBinaryAuthorization(BinaryAuthorization.newBuilder().build())
            .setVpcAccess(VpcAccess.newBuilder().build())
            .setServiceAccount("serviceAccount1079137720")
            .addAllContainers(new ArrayList<Container>())
            .addAllVolumes(new ArrayList<Volume>())
            .setEncryptionKey("encryptionKey-36224036")
            .setEncryptionKeyRevocationAction(EncryptionKeyRevocationAction.forNumber(0))
            .setEncryptionKeyShutdownDuration(Duration.newBuilder().build())
            .setNodeSelector(NodeSelector.newBuilder().build())
            .setGpuZonalRedundancyDisabled(true)
            .setIngress(IngressTraffic.forNumber(0))
            .setInvokerIamDisabled(true)
            .setIapEnabled(true)
            .setObservedGeneration(900833007)
            .setLogUri("logUri-1097354360")
            .setTerminalCondition(Condition.newBuilder().build())
            .addAllConditions(new ArrayList<Condition>())
            .addAllContainerStatuses(new ArrayList<ContainerStatus>())
            .setSatisfiesPzs(true)
            .addAllUrls(new ArrayList<String>())
            .setReconciling(true)
            .setEtag("etag3123477")
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-9412/locations/location-9412/instances/instance-9412";

    Instance actualResponse = client.getInstance(name);
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
  public void getInstanceExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-9412/locations/location-9412/instances/instance-9412";
      client.getInstance(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listInstancesTest() throws Exception {
    Instance responsesElement = Instance.newBuilder().build();
    ListInstancesResponse expectedResponse =
        ListInstancesResponse.newBuilder()
            .setNextPageToken("")
            .addAllInstances(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListInstancesPagedResponse pagedListResponse = client.listInstances(parent);

    List<Instance> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getInstancesList().get(0), resources.get(0));

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
  public void listInstancesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listInstances(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listInstancesTest2() throws Exception {
    Instance responsesElement = Instance.newBuilder().build();
    ListInstancesResponse expectedResponse =
        ListInstancesResponse.newBuilder()
            .setNextPageToken("")
            .addAllInstances(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListInstancesPagedResponse pagedListResponse = client.listInstances(parent);

    List<Instance> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getInstancesList().get(0), resources.get(0));

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
  public void listInstancesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listInstances(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void stopInstanceTest() throws Exception {
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
            .setDescription("description-1724546052")
            .setUid("uid115792")
            .setGeneration(305703192)
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .setCreator("creator1028554796")
            .setLastModifier("lastModifier1959003021")
            .setClient("client-1357712437")
            .setClientVersion("clientVersion771880589")
            .setLaunchStage(LaunchStage.forNumber(0))
            .setBinaryAuthorization(BinaryAuthorization.newBuilder().build())
            .setVpcAccess(VpcAccess.newBuilder().build())
            .setServiceAccount("serviceAccount1079137720")
            .addAllContainers(new ArrayList<Container>())
            .addAllVolumes(new ArrayList<Volume>())
            .setEncryptionKey("encryptionKey-36224036")
            .setEncryptionKeyRevocationAction(EncryptionKeyRevocationAction.forNumber(0))
            .setEncryptionKeyShutdownDuration(Duration.newBuilder().build())
            .setNodeSelector(NodeSelector.newBuilder().build())
            .setGpuZonalRedundancyDisabled(true)
            .setIngress(IngressTraffic.forNumber(0))
            .setInvokerIamDisabled(true)
            .setIapEnabled(true)
            .setObservedGeneration(900833007)
            .setLogUri("logUri-1097354360")
            .setTerminalCondition(Condition.newBuilder().build())
            .addAllConditions(new ArrayList<Condition>())
            .addAllContainerStatuses(new ArrayList<ContainerStatus>())
            .setSatisfiesPzs(true)
            .addAllUrls(new ArrayList<String>())
            .setReconciling(true)
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("stopInstanceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");

    Instance actualResponse = client.stopInstanceAsync(name).get();
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
  public void stopInstanceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      client.stopInstanceAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void stopInstanceTest2() throws Exception {
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
            .setDescription("description-1724546052")
            .setUid("uid115792")
            .setGeneration(305703192)
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .setCreator("creator1028554796")
            .setLastModifier("lastModifier1959003021")
            .setClient("client-1357712437")
            .setClientVersion("clientVersion771880589")
            .setLaunchStage(LaunchStage.forNumber(0))
            .setBinaryAuthorization(BinaryAuthorization.newBuilder().build())
            .setVpcAccess(VpcAccess.newBuilder().build())
            .setServiceAccount("serviceAccount1079137720")
            .addAllContainers(new ArrayList<Container>())
            .addAllVolumes(new ArrayList<Volume>())
            .setEncryptionKey("encryptionKey-36224036")
            .setEncryptionKeyRevocationAction(EncryptionKeyRevocationAction.forNumber(0))
            .setEncryptionKeyShutdownDuration(Duration.newBuilder().build())
            .setNodeSelector(NodeSelector.newBuilder().build())
            .setGpuZonalRedundancyDisabled(true)
            .setIngress(IngressTraffic.forNumber(0))
            .setInvokerIamDisabled(true)
            .setIapEnabled(true)
            .setObservedGeneration(900833007)
            .setLogUri("logUri-1097354360")
            .setTerminalCondition(Condition.newBuilder().build())
            .addAllConditions(new ArrayList<Condition>())
            .addAllContainerStatuses(new ArrayList<ContainerStatus>())
            .setSatisfiesPzs(true)
            .addAllUrls(new ArrayList<String>())
            .setReconciling(true)
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("stopInstanceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name = "projects/project-9412/locations/location-9412/instances/instance-9412";

    Instance actualResponse = client.stopInstanceAsync(name).get();
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
  public void stopInstanceExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-9412/locations/location-9412/instances/instance-9412";
      client.stopInstanceAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void startInstanceTest() throws Exception {
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
            .setDescription("description-1724546052")
            .setUid("uid115792")
            .setGeneration(305703192)
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .setCreator("creator1028554796")
            .setLastModifier("lastModifier1959003021")
            .setClient("client-1357712437")
            .setClientVersion("clientVersion771880589")
            .setLaunchStage(LaunchStage.forNumber(0))
            .setBinaryAuthorization(BinaryAuthorization.newBuilder().build())
            .setVpcAccess(VpcAccess.newBuilder().build())
            .setServiceAccount("serviceAccount1079137720")
            .addAllContainers(new ArrayList<Container>())
            .addAllVolumes(new ArrayList<Volume>())
            .setEncryptionKey("encryptionKey-36224036")
            .setEncryptionKeyRevocationAction(EncryptionKeyRevocationAction.forNumber(0))
            .setEncryptionKeyShutdownDuration(Duration.newBuilder().build())
            .setNodeSelector(NodeSelector.newBuilder().build())
            .setGpuZonalRedundancyDisabled(true)
            .setIngress(IngressTraffic.forNumber(0))
            .setInvokerIamDisabled(true)
            .setIapEnabled(true)
            .setObservedGeneration(900833007)
            .setLogUri("logUri-1097354360")
            .setTerminalCondition(Condition.newBuilder().build())
            .addAllConditions(new ArrayList<Condition>())
            .addAllContainerStatuses(new ArrayList<ContainerStatus>())
            .setSatisfiesPzs(true)
            .addAllUrls(new ArrayList<String>())
            .setReconciling(true)
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("startInstanceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");

    Instance actualResponse = client.startInstanceAsync(name).get();
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
  public void startInstanceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      client.startInstanceAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void startInstanceTest2() throws Exception {
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
            .setDescription("description-1724546052")
            .setUid("uid115792")
            .setGeneration(305703192)
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .setCreator("creator1028554796")
            .setLastModifier("lastModifier1959003021")
            .setClient("client-1357712437")
            .setClientVersion("clientVersion771880589")
            .setLaunchStage(LaunchStage.forNumber(0))
            .setBinaryAuthorization(BinaryAuthorization.newBuilder().build())
            .setVpcAccess(VpcAccess.newBuilder().build())
            .setServiceAccount("serviceAccount1079137720")
            .addAllContainers(new ArrayList<Container>())
            .addAllVolumes(new ArrayList<Volume>())
            .setEncryptionKey("encryptionKey-36224036")
            .setEncryptionKeyRevocationAction(EncryptionKeyRevocationAction.forNumber(0))
            .setEncryptionKeyShutdownDuration(Duration.newBuilder().build())
            .setNodeSelector(NodeSelector.newBuilder().build())
            .setGpuZonalRedundancyDisabled(true)
            .setIngress(IngressTraffic.forNumber(0))
            .setInvokerIamDisabled(true)
            .setIapEnabled(true)
            .setObservedGeneration(900833007)
            .setLogUri("logUri-1097354360")
            .setTerminalCondition(Condition.newBuilder().build())
            .addAllConditions(new ArrayList<Condition>())
            .addAllContainerStatuses(new ArrayList<ContainerStatus>())
            .setSatisfiesPzs(true)
            .addAllUrls(new ArrayList<String>())
            .setReconciling(true)
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("startInstanceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name = "projects/project-9412/locations/location-9412/instances/instance-9412";

    Instance actualResponse = client.startInstanceAsync(name).get();
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
  public void startInstanceExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-9412/locations/location-9412/instances/instance-9412";
      client.startInstanceAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }
}
