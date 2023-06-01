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

package com.google.cloud.vmwareengine.v1;

import static com.google.cloud.vmwareengine.v1.VmwareEngineClient.ListClustersPagedResponse;
import static com.google.cloud.vmwareengine.v1.VmwareEngineClient.ListHcxActivationKeysPagedResponse;
import static com.google.cloud.vmwareengine.v1.VmwareEngineClient.ListLocationsPagedResponse;
import static com.google.cloud.vmwareengine.v1.VmwareEngineClient.ListNetworkPoliciesPagedResponse;
import static com.google.cloud.vmwareengine.v1.VmwareEngineClient.ListNodeTypesPagedResponse;
import static com.google.cloud.vmwareengine.v1.VmwareEngineClient.ListPrivateCloudsPagedResponse;
import static com.google.cloud.vmwareengine.v1.VmwareEngineClient.ListSubnetsPagedResponse;
import static com.google.cloud.vmwareengine.v1.VmwareEngineClient.ListVmwareEngineNetworksPagedResponse;

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
import com.google.cloud.vmwareengine.v1.stub.HttpJsonVmwareEngineStub;
import com.google.common.collect.Lists;
import com.google.iam.v1.AuditConfig;
import com.google.iam.v1.Binding;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.GetPolicyOptions;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.protobuf.Any;
import com.google.protobuf.ByteString;
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
public class VmwareEngineClientHttpJsonTest {
  private static MockHttpService mockService;
  private static VmwareEngineClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonVmwareEngineStub.getMethodDescriptors(),
            VmwareEngineSettings.getDefaultEndpoint());
    VmwareEngineSettings settings =
        VmwareEngineSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                VmwareEngineSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = VmwareEngineClient.create(settings);
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
  public void listPrivateCloudsTest() throws Exception {
    PrivateCloud responsesElement = PrivateCloud.newBuilder().build();
    ListPrivateCloudsResponse expectedResponse =
        ListPrivateCloudsResponse.newBuilder()
            .setNextPageToken("")
            .addAllPrivateClouds(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListPrivateCloudsPagedResponse pagedListResponse = client.listPrivateClouds(parent);

    List<PrivateCloud> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPrivateCloudsList().get(0), resources.get(0));

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
  public void listPrivateCloudsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listPrivateClouds(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listPrivateCloudsTest2() throws Exception {
    PrivateCloud responsesElement = PrivateCloud.newBuilder().build();
    ListPrivateCloudsResponse expectedResponse =
        ListPrivateCloudsResponse.newBuilder()
            .setNextPageToken("")
            .addAllPrivateClouds(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListPrivateCloudsPagedResponse pagedListResponse = client.listPrivateClouds(parent);

    List<PrivateCloud> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPrivateCloudsList().get(0), resources.get(0));

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
  public void listPrivateCloudsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listPrivateClouds(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getPrivateCloudTest() throws Exception {
    PrivateCloud expectedResponse =
        PrivateCloud.newBuilder()
            .setName(PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .setNetworkConfig(NetworkConfig.newBuilder().build())
            .setManagementCluster(PrivateCloud.ManagementCluster.newBuilder().build())
            .setDescription("description-1724546052")
            .setHcx(Hcx.newBuilder().build())
            .setNsx(Nsx.newBuilder().build())
            .setVcenter(Vcenter.newBuilder().build())
            .setUid("uid115792")
            .build();
    mockService.addResponse(expectedResponse);

    PrivateCloudName name = PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]");

    PrivateCloud actualResponse = client.getPrivateCloud(name);
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
  public void getPrivateCloudExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PrivateCloudName name = PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]");
      client.getPrivateCloud(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getPrivateCloudTest2() throws Exception {
    PrivateCloud expectedResponse =
        PrivateCloud.newBuilder()
            .setName(PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .setNetworkConfig(NetworkConfig.newBuilder().build())
            .setManagementCluster(PrivateCloud.ManagementCluster.newBuilder().build())
            .setDescription("description-1724546052")
            .setHcx(Hcx.newBuilder().build())
            .setNsx(Nsx.newBuilder().build())
            .setVcenter(Vcenter.newBuilder().build())
            .setUid("uid115792")
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-6537/locations/location-6537/privateClouds/privateCloud-6537";

    PrivateCloud actualResponse = client.getPrivateCloud(name);
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
  public void getPrivateCloudExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-6537/locations/location-6537/privateClouds/privateCloud-6537";
      client.getPrivateCloud(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createPrivateCloudTest() throws Exception {
    PrivateCloud expectedResponse =
        PrivateCloud.newBuilder()
            .setName(PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .setNetworkConfig(NetworkConfig.newBuilder().build())
            .setManagementCluster(PrivateCloud.ManagementCluster.newBuilder().build())
            .setDescription("description-1724546052")
            .setHcx(Hcx.newBuilder().build())
            .setNsx(Nsx.newBuilder().build())
            .setVcenter(Vcenter.newBuilder().build())
            .setUid("uid115792")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createPrivateCloudTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    PrivateCloud privateCloud = PrivateCloud.newBuilder().build();
    String privateCloudId = "privateCloudId573896493";

    PrivateCloud actualResponse =
        client.createPrivateCloudAsync(parent, privateCloud, privateCloudId).get();
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
  public void createPrivateCloudExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      PrivateCloud privateCloud = PrivateCloud.newBuilder().build();
      String privateCloudId = "privateCloudId573896493";
      client.createPrivateCloudAsync(parent, privateCloud, privateCloudId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createPrivateCloudTest2() throws Exception {
    PrivateCloud expectedResponse =
        PrivateCloud.newBuilder()
            .setName(PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .setNetworkConfig(NetworkConfig.newBuilder().build())
            .setManagementCluster(PrivateCloud.ManagementCluster.newBuilder().build())
            .setDescription("description-1724546052")
            .setHcx(Hcx.newBuilder().build())
            .setNsx(Nsx.newBuilder().build())
            .setVcenter(Vcenter.newBuilder().build())
            .setUid("uid115792")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createPrivateCloudTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5833/locations/location-5833";
    PrivateCloud privateCloud = PrivateCloud.newBuilder().build();
    String privateCloudId = "privateCloudId573896493";

    PrivateCloud actualResponse =
        client.createPrivateCloudAsync(parent, privateCloud, privateCloudId).get();
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
  public void createPrivateCloudExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      PrivateCloud privateCloud = PrivateCloud.newBuilder().build();
      String privateCloudId = "privateCloudId573896493";
      client.createPrivateCloudAsync(parent, privateCloud, privateCloudId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void updatePrivateCloudTest() throws Exception {
    PrivateCloud expectedResponse =
        PrivateCloud.newBuilder()
            .setName(PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .setNetworkConfig(NetworkConfig.newBuilder().build())
            .setManagementCluster(PrivateCloud.ManagementCluster.newBuilder().build())
            .setDescription("description-1724546052")
            .setHcx(Hcx.newBuilder().build())
            .setNsx(Nsx.newBuilder().build())
            .setVcenter(Vcenter.newBuilder().build())
            .setUid("uid115792")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updatePrivateCloudTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    PrivateCloud privateCloud =
        PrivateCloud.newBuilder()
            .setName(PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .setNetworkConfig(NetworkConfig.newBuilder().build())
            .setManagementCluster(PrivateCloud.ManagementCluster.newBuilder().build())
            .setDescription("description-1724546052")
            .setHcx(Hcx.newBuilder().build())
            .setNsx(Nsx.newBuilder().build())
            .setVcenter(Vcenter.newBuilder().build())
            .setUid("uid115792")
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    PrivateCloud actualResponse = client.updatePrivateCloudAsync(privateCloud, updateMask).get();
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
  public void updatePrivateCloudExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PrivateCloud privateCloud =
          PrivateCloud.newBuilder()
              .setName(PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString())
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .setDeleteTime(Timestamp.newBuilder().build())
              .setExpireTime(Timestamp.newBuilder().build())
              .setNetworkConfig(NetworkConfig.newBuilder().build())
              .setManagementCluster(PrivateCloud.ManagementCluster.newBuilder().build())
              .setDescription("description-1724546052")
              .setHcx(Hcx.newBuilder().build())
              .setNsx(Nsx.newBuilder().build())
              .setVcenter(Vcenter.newBuilder().build())
              .setUid("uid115792")
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updatePrivateCloudAsync(privateCloud, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deletePrivateCloudTest() throws Exception {
    PrivateCloud expectedResponse =
        PrivateCloud.newBuilder()
            .setName(PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .setNetworkConfig(NetworkConfig.newBuilder().build())
            .setManagementCluster(PrivateCloud.ManagementCluster.newBuilder().build())
            .setDescription("description-1724546052")
            .setHcx(Hcx.newBuilder().build())
            .setNsx(Nsx.newBuilder().build())
            .setVcenter(Vcenter.newBuilder().build())
            .setUid("uid115792")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deletePrivateCloudTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    PrivateCloudName name = PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]");

    PrivateCloud actualResponse = client.deletePrivateCloudAsync(name).get();
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
  public void deletePrivateCloudExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PrivateCloudName name = PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]");
      client.deletePrivateCloudAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deletePrivateCloudTest2() throws Exception {
    PrivateCloud expectedResponse =
        PrivateCloud.newBuilder()
            .setName(PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .setNetworkConfig(NetworkConfig.newBuilder().build())
            .setManagementCluster(PrivateCloud.ManagementCluster.newBuilder().build())
            .setDescription("description-1724546052")
            .setHcx(Hcx.newBuilder().build())
            .setNsx(Nsx.newBuilder().build())
            .setVcenter(Vcenter.newBuilder().build())
            .setUid("uid115792")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deletePrivateCloudTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name = "projects/project-6537/locations/location-6537/privateClouds/privateCloud-6537";

    PrivateCloud actualResponse = client.deletePrivateCloudAsync(name).get();
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
  public void deletePrivateCloudExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-6537/locations/location-6537/privateClouds/privateCloud-6537";
      client.deletePrivateCloudAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void undeletePrivateCloudTest() throws Exception {
    PrivateCloud expectedResponse =
        PrivateCloud.newBuilder()
            .setName(PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .setNetworkConfig(NetworkConfig.newBuilder().build())
            .setManagementCluster(PrivateCloud.ManagementCluster.newBuilder().build())
            .setDescription("description-1724546052")
            .setHcx(Hcx.newBuilder().build())
            .setNsx(Nsx.newBuilder().build())
            .setVcenter(Vcenter.newBuilder().build())
            .setUid("uid115792")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("undeletePrivateCloudTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    PrivateCloudName name = PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]");

    PrivateCloud actualResponse = client.undeletePrivateCloudAsync(name).get();
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
  public void undeletePrivateCloudExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PrivateCloudName name = PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]");
      client.undeletePrivateCloudAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void undeletePrivateCloudTest2() throws Exception {
    PrivateCloud expectedResponse =
        PrivateCloud.newBuilder()
            .setName(PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .setNetworkConfig(NetworkConfig.newBuilder().build())
            .setManagementCluster(PrivateCloud.ManagementCluster.newBuilder().build())
            .setDescription("description-1724546052")
            .setHcx(Hcx.newBuilder().build())
            .setNsx(Nsx.newBuilder().build())
            .setVcenter(Vcenter.newBuilder().build())
            .setUid("uid115792")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("undeletePrivateCloudTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name = "projects/project-6537/locations/location-6537/privateClouds/privateCloud-6537";

    PrivateCloud actualResponse = client.undeletePrivateCloudAsync(name).get();
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
  public void undeletePrivateCloudExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-6537/locations/location-6537/privateClouds/privateCloud-6537";
      client.undeletePrivateCloudAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void listClustersTest() throws Exception {
    Cluster responsesElement = Cluster.newBuilder().build();
    ListClustersResponse expectedResponse =
        ListClustersResponse.newBuilder()
            .setNextPageToken("")
            .addAllClusters(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    PrivateCloudName parent = PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]");

    ListClustersPagedResponse pagedListResponse = client.listClusters(parent);

    List<Cluster> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getClustersList().get(0), resources.get(0));

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
  public void listClustersExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PrivateCloudName parent = PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]");
      client.listClusters(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listClustersTest2() throws Exception {
    Cluster responsesElement = Cluster.newBuilder().build();
    ListClustersResponse expectedResponse =
        ListClustersResponse.newBuilder()
            .setNextPageToken("")
            .addAllClusters(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-4854/locations/location-4854/privateClouds/privateCloud-4854";

    ListClustersPagedResponse pagedListResponse = client.listClusters(parent);

    List<Cluster> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getClustersList().get(0), resources.get(0));

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
  public void listClustersExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-4854/locations/location-4854/privateClouds/privateCloud-4854";
      client.listClusters(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getClusterTest() throws Exception {
    Cluster expectedResponse =
        Cluster.newBuilder()
            .setName(
                ClusterName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[CLUSTER]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setManagement(true)
            .setUid("uid115792")
            .putAllNodeTypeConfigs(new HashMap<String, NodeTypeConfig>())
            .build();
    mockService.addResponse(expectedResponse);

    ClusterName name = ClusterName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[CLUSTER]");

    Cluster actualResponse = client.getCluster(name);
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
  public void getClusterExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ClusterName name = ClusterName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[CLUSTER]");
      client.getCluster(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getClusterTest2() throws Exception {
    Cluster expectedResponse =
        Cluster.newBuilder()
            .setName(
                ClusterName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[CLUSTER]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setManagement(true)
            .setUid("uid115792")
            .putAllNodeTypeConfigs(new HashMap<String, NodeTypeConfig>())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-1428/locations/location-1428/privateClouds/privateCloud-1428/clusters/cluster-1428";

    Cluster actualResponse = client.getCluster(name);
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
  public void getClusterExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-1428/locations/location-1428/privateClouds/privateCloud-1428/clusters/cluster-1428";
      client.getCluster(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createClusterTest() throws Exception {
    Cluster expectedResponse =
        Cluster.newBuilder()
            .setName(
                ClusterName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[CLUSTER]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setManagement(true)
            .setUid("uid115792")
            .putAllNodeTypeConfigs(new HashMap<String, NodeTypeConfig>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createClusterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    PrivateCloudName parent = PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]");
    Cluster cluster = Cluster.newBuilder().build();
    String clusterId = "clusterId561939637";

    Cluster actualResponse = client.createClusterAsync(parent, cluster, clusterId).get();
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
  public void createClusterExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PrivateCloudName parent = PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]");
      Cluster cluster = Cluster.newBuilder().build();
      String clusterId = "clusterId561939637";
      client.createClusterAsync(parent, cluster, clusterId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createClusterTest2() throws Exception {
    Cluster expectedResponse =
        Cluster.newBuilder()
            .setName(
                ClusterName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[CLUSTER]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setManagement(true)
            .setUid("uid115792")
            .putAllNodeTypeConfigs(new HashMap<String, NodeTypeConfig>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createClusterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-4854/locations/location-4854/privateClouds/privateCloud-4854";
    Cluster cluster = Cluster.newBuilder().build();
    String clusterId = "clusterId561939637";

    Cluster actualResponse = client.createClusterAsync(parent, cluster, clusterId).get();
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
  public void createClusterExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-4854/locations/location-4854/privateClouds/privateCloud-4854";
      Cluster cluster = Cluster.newBuilder().build();
      String clusterId = "clusterId561939637";
      client.createClusterAsync(parent, cluster, clusterId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void updateClusterTest() throws Exception {
    Cluster expectedResponse =
        Cluster.newBuilder()
            .setName(
                ClusterName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[CLUSTER]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setManagement(true)
            .setUid("uid115792")
            .putAllNodeTypeConfigs(new HashMap<String, NodeTypeConfig>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateClusterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    Cluster cluster =
        Cluster.newBuilder()
            .setName(
                ClusterName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[CLUSTER]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setManagement(true)
            .setUid("uid115792")
            .putAllNodeTypeConfigs(new HashMap<String, NodeTypeConfig>())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Cluster actualResponse = client.updateClusterAsync(cluster, updateMask).get();
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
  public void updateClusterExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Cluster cluster =
          Cluster.newBuilder()
              .setName(
                  ClusterName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[CLUSTER]")
                      .toString())
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .setManagement(true)
              .setUid("uid115792")
              .putAllNodeTypeConfigs(new HashMap<String, NodeTypeConfig>())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateClusterAsync(cluster, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteClusterTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteClusterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    ClusterName name = ClusterName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[CLUSTER]");

    client.deleteClusterAsync(name).get();

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
  public void deleteClusterExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ClusterName name = ClusterName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[CLUSTER]");
      client.deleteClusterAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteClusterTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteClusterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name =
        "projects/project-1428/locations/location-1428/privateClouds/privateCloud-1428/clusters/cluster-1428";

    client.deleteClusterAsync(name).get();

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
  public void deleteClusterExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-1428/locations/location-1428/privateClouds/privateCloud-1428/clusters/cluster-1428";
      client.deleteClusterAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void listSubnetsTest() throws Exception {
    Subnet responsesElement = Subnet.newBuilder().build();
    ListSubnetsResponse expectedResponse =
        ListSubnetsResponse.newBuilder()
            .setNextPageToken("")
            .addAllSubnets(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    PrivateCloudName parent = PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]");

    ListSubnetsPagedResponse pagedListResponse = client.listSubnets(parent);

    List<Subnet> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSubnetsList().get(0), resources.get(0));

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
  public void listSubnetsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PrivateCloudName parent = PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]");
      client.listSubnets(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSubnetsTest2() throws Exception {
    Subnet responsesElement = Subnet.newBuilder().build();
    ListSubnetsResponse expectedResponse =
        ListSubnetsResponse.newBuilder()
            .setNextPageToken("")
            .addAllSubnets(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-4854/locations/location-4854/privateClouds/privateCloud-4854";

    ListSubnetsPagedResponse pagedListResponse = client.listSubnets(parent);

    List<Subnet> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSubnetsList().get(0), resources.get(0));

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
  public void listSubnetsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-4854/locations/location-4854/privateClouds/privateCloud-4854";
      client.listSubnets(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listNodeTypesTest() throws Exception {
    NodeType responsesElement = NodeType.newBuilder().build();
    ListNodeTypesResponse expectedResponse =
        ListNodeTypesResponse.newBuilder()
            .setNextPageToken("")
            .addAllNodeTypes(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListNodeTypesPagedResponse pagedListResponse = client.listNodeTypes(parent);

    List<NodeType> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getNodeTypesList().get(0), resources.get(0));

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
  public void listNodeTypesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listNodeTypes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listNodeTypesTest2() throws Exception {
    NodeType responsesElement = NodeType.newBuilder().build();
    ListNodeTypesResponse expectedResponse =
        ListNodeTypesResponse.newBuilder()
            .setNextPageToken("")
            .addAllNodeTypes(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListNodeTypesPagedResponse pagedListResponse = client.listNodeTypes(parent);

    List<NodeType> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getNodeTypesList().get(0), resources.get(0));

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
  public void listNodeTypesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listNodeTypes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getNodeTypeTest() throws Exception {
    NodeType expectedResponse =
        NodeType.newBuilder()
            .setName(NodeTypeName.of("[PROJECT]", "[LOCATION]", "[NODE_TYPE]").toString())
            .setNodeTypeId("nodeTypeId1245332119")
            .setDisplayName("displayName1714148973")
            .setVirtualCpuCount(289038212)
            .setTotalCoreCount(-282953654)
            .setMemoryGb(1726613721)
            .setDiskSizeGb(-757478089)
            .addAllAvailableCustomCoreCounts(new ArrayList<Integer>())
            .build();
    mockService.addResponse(expectedResponse);

    NodeTypeName name = NodeTypeName.of("[PROJECT]", "[LOCATION]", "[NODE_TYPE]");

    NodeType actualResponse = client.getNodeType(name);
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
  public void getNodeTypeExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NodeTypeName name = NodeTypeName.of("[PROJECT]", "[LOCATION]", "[NODE_TYPE]");
      client.getNodeType(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getNodeTypeTest2() throws Exception {
    NodeType expectedResponse =
        NodeType.newBuilder()
            .setName(NodeTypeName.of("[PROJECT]", "[LOCATION]", "[NODE_TYPE]").toString())
            .setNodeTypeId("nodeTypeId1245332119")
            .setDisplayName("displayName1714148973")
            .setVirtualCpuCount(289038212)
            .setTotalCoreCount(-282953654)
            .setMemoryGb(1726613721)
            .setDiskSizeGb(-757478089)
            .addAllAvailableCustomCoreCounts(new ArrayList<Integer>())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-1203/locations/location-1203/nodeTypes/nodeType-1203";

    NodeType actualResponse = client.getNodeType(name);
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
  public void getNodeTypeExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-1203/locations/location-1203/nodeTypes/nodeType-1203";
      client.getNodeType(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void showNsxCredentialsTest() throws Exception {
    Credentials expectedResponse =
        Credentials.newBuilder()
            .setUsername("username-265713450")
            .setPassword("password1216985755")
            .build();
    mockService.addResponse(expectedResponse);

    PrivateCloudName privateCloud =
        PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]");

    Credentials actualResponse = client.showNsxCredentials(privateCloud);
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
  public void showNsxCredentialsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PrivateCloudName privateCloud =
          PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]");
      client.showNsxCredentials(privateCloud);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void showNsxCredentialsTest2() throws Exception {
    Credentials expectedResponse =
        Credentials.newBuilder()
            .setUsername("username-265713450")
            .setPassword("password1216985755")
            .build();
    mockService.addResponse(expectedResponse);

    String privateCloud =
        "projects/project-6942/locations/location-6942/privateClouds/privateCloud-6942";

    Credentials actualResponse = client.showNsxCredentials(privateCloud);
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
  public void showNsxCredentialsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String privateCloud =
          "projects/project-6942/locations/location-6942/privateClouds/privateCloud-6942";
      client.showNsxCredentials(privateCloud);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void showVcenterCredentialsTest() throws Exception {
    Credentials expectedResponse =
        Credentials.newBuilder()
            .setUsername("username-265713450")
            .setPassword("password1216985755")
            .build();
    mockService.addResponse(expectedResponse);

    PrivateCloudName privateCloud =
        PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]");

    Credentials actualResponse = client.showVcenterCredentials(privateCloud);
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
  public void showVcenterCredentialsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PrivateCloudName privateCloud =
          PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]");
      client.showVcenterCredentials(privateCloud);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void showVcenterCredentialsTest2() throws Exception {
    Credentials expectedResponse =
        Credentials.newBuilder()
            .setUsername("username-265713450")
            .setPassword("password1216985755")
            .build();
    mockService.addResponse(expectedResponse);

    String privateCloud =
        "projects/project-6942/locations/location-6942/privateClouds/privateCloud-6942";

    Credentials actualResponse = client.showVcenterCredentials(privateCloud);
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
  public void showVcenterCredentialsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String privateCloud =
          "projects/project-6942/locations/location-6942/privateClouds/privateCloud-6942";
      client.showVcenterCredentials(privateCloud);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void resetNsxCredentialsTest() throws Exception {
    PrivateCloud expectedResponse =
        PrivateCloud.newBuilder()
            .setName(PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .setNetworkConfig(NetworkConfig.newBuilder().build())
            .setManagementCluster(PrivateCloud.ManagementCluster.newBuilder().build())
            .setDescription("description-1724546052")
            .setHcx(Hcx.newBuilder().build())
            .setNsx(Nsx.newBuilder().build())
            .setVcenter(Vcenter.newBuilder().build())
            .setUid("uid115792")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("resetNsxCredentialsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    PrivateCloudName privateCloud =
        PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]");

    PrivateCloud actualResponse = client.resetNsxCredentialsAsync(privateCloud).get();
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
  public void resetNsxCredentialsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PrivateCloudName privateCloud =
          PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]");
      client.resetNsxCredentialsAsync(privateCloud).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void resetNsxCredentialsTest2() throws Exception {
    PrivateCloud expectedResponse =
        PrivateCloud.newBuilder()
            .setName(PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .setNetworkConfig(NetworkConfig.newBuilder().build())
            .setManagementCluster(PrivateCloud.ManagementCluster.newBuilder().build())
            .setDescription("description-1724546052")
            .setHcx(Hcx.newBuilder().build())
            .setNsx(Nsx.newBuilder().build())
            .setVcenter(Vcenter.newBuilder().build())
            .setUid("uid115792")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("resetNsxCredentialsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String privateCloud =
        "projects/project-6942/locations/location-6942/privateClouds/privateCloud-6942";

    PrivateCloud actualResponse = client.resetNsxCredentialsAsync(privateCloud).get();
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
  public void resetNsxCredentialsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String privateCloud =
          "projects/project-6942/locations/location-6942/privateClouds/privateCloud-6942";
      client.resetNsxCredentialsAsync(privateCloud).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void resetVcenterCredentialsTest() throws Exception {
    PrivateCloud expectedResponse =
        PrivateCloud.newBuilder()
            .setName(PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .setNetworkConfig(NetworkConfig.newBuilder().build())
            .setManagementCluster(PrivateCloud.ManagementCluster.newBuilder().build())
            .setDescription("description-1724546052")
            .setHcx(Hcx.newBuilder().build())
            .setNsx(Nsx.newBuilder().build())
            .setVcenter(Vcenter.newBuilder().build())
            .setUid("uid115792")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("resetVcenterCredentialsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    PrivateCloudName privateCloud =
        PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]");

    PrivateCloud actualResponse = client.resetVcenterCredentialsAsync(privateCloud).get();
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
  public void resetVcenterCredentialsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PrivateCloudName privateCloud =
          PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]");
      client.resetVcenterCredentialsAsync(privateCloud).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void resetVcenterCredentialsTest2() throws Exception {
    PrivateCloud expectedResponse =
        PrivateCloud.newBuilder()
            .setName(PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .setNetworkConfig(NetworkConfig.newBuilder().build())
            .setManagementCluster(PrivateCloud.ManagementCluster.newBuilder().build())
            .setDescription("description-1724546052")
            .setHcx(Hcx.newBuilder().build())
            .setNsx(Nsx.newBuilder().build())
            .setVcenter(Vcenter.newBuilder().build())
            .setUid("uid115792")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("resetVcenterCredentialsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String privateCloud =
        "projects/project-6942/locations/location-6942/privateClouds/privateCloud-6942";

    PrivateCloud actualResponse = client.resetVcenterCredentialsAsync(privateCloud).get();
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
  public void resetVcenterCredentialsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String privateCloud =
          "projects/project-6942/locations/location-6942/privateClouds/privateCloud-6942";
      client.resetVcenterCredentialsAsync(privateCloud).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createHcxActivationKeyTest() throws Exception {
    HcxActivationKey expectedResponse =
        HcxActivationKey.newBuilder()
            .setName(
                HcxActivationKeyName.of(
                        "[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[HCX_ACTIVATION_KEY]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setActivationKey("activationKey1757742441")
            .setUid("uid115792")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createHcxActivationKeyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    PrivateCloudName parent = PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]");
    HcxActivationKey hcxActivationKey = HcxActivationKey.newBuilder().build();
    String hcxActivationKeyId = "hcxActivationKeyId-645871673";

    HcxActivationKey actualResponse =
        client.createHcxActivationKeyAsync(parent, hcxActivationKey, hcxActivationKeyId).get();
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
  public void createHcxActivationKeyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PrivateCloudName parent = PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]");
      HcxActivationKey hcxActivationKey = HcxActivationKey.newBuilder().build();
      String hcxActivationKeyId = "hcxActivationKeyId-645871673";
      client.createHcxActivationKeyAsync(parent, hcxActivationKey, hcxActivationKeyId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createHcxActivationKeyTest2() throws Exception {
    HcxActivationKey expectedResponse =
        HcxActivationKey.newBuilder()
            .setName(
                HcxActivationKeyName.of(
                        "[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[HCX_ACTIVATION_KEY]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setActivationKey("activationKey1757742441")
            .setUid("uid115792")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createHcxActivationKeyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-4854/locations/location-4854/privateClouds/privateCloud-4854";
    HcxActivationKey hcxActivationKey = HcxActivationKey.newBuilder().build();
    String hcxActivationKeyId = "hcxActivationKeyId-645871673";

    HcxActivationKey actualResponse =
        client.createHcxActivationKeyAsync(parent, hcxActivationKey, hcxActivationKeyId).get();
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
  public void createHcxActivationKeyExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-4854/locations/location-4854/privateClouds/privateCloud-4854";
      HcxActivationKey hcxActivationKey = HcxActivationKey.newBuilder().build();
      String hcxActivationKeyId = "hcxActivationKeyId-645871673";
      client.createHcxActivationKeyAsync(parent, hcxActivationKey, hcxActivationKeyId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void listHcxActivationKeysTest() throws Exception {
    HcxActivationKey responsesElement = HcxActivationKey.newBuilder().build();
    ListHcxActivationKeysResponse expectedResponse =
        ListHcxActivationKeysResponse.newBuilder()
            .setNextPageToken("")
            .addAllHcxActivationKeys(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    PrivateCloudName parent = PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]");

    ListHcxActivationKeysPagedResponse pagedListResponse = client.listHcxActivationKeys(parent);

    List<HcxActivationKey> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getHcxActivationKeysList().get(0), resources.get(0));

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
  public void listHcxActivationKeysExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PrivateCloudName parent = PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]");
      client.listHcxActivationKeys(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listHcxActivationKeysTest2() throws Exception {
    HcxActivationKey responsesElement = HcxActivationKey.newBuilder().build();
    ListHcxActivationKeysResponse expectedResponse =
        ListHcxActivationKeysResponse.newBuilder()
            .setNextPageToken("")
            .addAllHcxActivationKeys(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-4854/locations/location-4854/privateClouds/privateCloud-4854";

    ListHcxActivationKeysPagedResponse pagedListResponse = client.listHcxActivationKeys(parent);

    List<HcxActivationKey> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getHcxActivationKeysList().get(0), resources.get(0));

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
  public void listHcxActivationKeysExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-4854/locations/location-4854/privateClouds/privateCloud-4854";
      client.listHcxActivationKeys(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getHcxActivationKeyTest() throws Exception {
    HcxActivationKey expectedResponse =
        HcxActivationKey.newBuilder()
            .setName(
                HcxActivationKeyName.of(
                        "[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[HCX_ACTIVATION_KEY]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setActivationKey("activationKey1757742441")
            .setUid("uid115792")
            .build();
    mockService.addResponse(expectedResponse);

    HcxActivationKeyName name =
        HcxActivationKeyName.of(
            "[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[HCX_ACTIVATION_KEY]");

    HcxActivationKey actualResponse = client.getHcxActivationKey(name);
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
  public void getHcxActivationKeyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      HcxActivationKeyName name =
          HcxActivationKeyName.of(
              "[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[HCX_ACTIVATION_KEY]");
      client.getHcxActivationKey(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getHcxActivationKeyTest2() throws Exception {
    HcxActivationKey expectedResponse =
        HcxActivationKey.newBuilder()
            .setName(
                HcxActivationKeyName.of(
                        "[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[HCX_ACTIVATION_KEY]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setActivationKey("activationKey1757742441")
            .setUid("uid115792")
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-3178/locations/location-3178/privateClouds/privateCloud-3178/hcxActivationKeys/hcxActivationKey-3178";

    HcxActivationKey actualResponse = client.getHcxActivationKey(name);
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
  public void getHcxActivationKeyExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-3178/locations/location-3178/privateClouds/privateCloud-3178/hcxActivationKeys/hcxActivationKey-3178";
      client.getHcxActivationKey(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getNetworkPolicyTest() throws Exception {
    NetworkPolicy expectedResponse =
        NetworkPolicy.newBuilder()
            .setName(NetworkPolicyName.of("[PROJECT]", "[LOCATION]", "[NETWORK_POLICY]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setInternetAccess(NetworkPolicy.NetworkService.newBuilder().build())
            .setExternalIp(NetworkPolicy.NetworkService.newBuilder().build())
            .setEdgeServicesCidr("edgeServicesCidr846515023")
            .setUid("uid115792")
            .setVmwareEngineNetwork(
                VmwareEngineNetworkName.of("[PROJECT]", "[LOCATION]", "[VMWARE_ENGINE_NETWORK]")
                    .toString())
            .setDescription("description-1724546052")
            .setVmwareEngineNetworkCanonical(
                VmwareEngineNetworkName.of("[PROJECT]", "[LOCATION]", "[VMWARE_ENGINE_NETWORK]")
                    .toString())
            .build();
    mockService.addResponse(expectedResponse);

    NetworkPolicyName name = NetworkPolicyName.of("[PROJECT]", "[LOCATION]", "[NETWORK_POLICY]");

    NetworkPolicy actualResponse = client.getNetworkPolicy(name);
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
  public void getNetworkPolicyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkPolicyName name = NetworkPolicyName.of("[PROJECT]", "[LOCATION]", "[NETWORK_POLICY]");
      client.getNetworkPolicy(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getNetworkPolicyTest2() throws Exception {
    NetworkPolicy expectedResponse =
        NetworkPolicy.newBuilder()
            .setName(NetworkPolicyName.of("[PROJECT]", "[LOCATION]", "[NETWORK_POLICY]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setInternetAccess(NetworkPolicy.NetworkService.newBuilder().build())
            .setExternalIp(NetworkPolicy.NetworkService.newBuilder().build())
            .setEdgeServicesCidr("edgeServicesCidr846515023")
            .setUid("uid115792")
            .setVmwareEngineNetwork(
                VmwareEngineNetworkName.of("[PROJECT]", "[LOCATION]", "[VMWARE_ENGINE_NETWORK]")
                    .toString())
            .setDescription("description-1724546052")
            .setVmwareEngineNetworkCanonical(
                VmwareEngineNetworkName.of("[PROJECT]", "[LOCATION]", "[VMWARE_ENGINE_NETWORK]")
                    .toString())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-6412/locations/location-6412/networkPolicies/networkPolicie-6412";

    NetworkPolicy actualResponse = client.getNetworkPolicy(name);
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
  public void getNetworkPolicyExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-6412/locations/location-6412/networkPolicies/networkPolicie-6412";
      client.getNetworkPolicy(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listNetworkPoliciesTest() throws Exception {
    NetworkPolicy responsesElement = NetworkPolicy.newBuilder().build();
    ListNetworkPoliciesResponse expectedResponse =
        ListNetworkPoliciesResponse.newBuilder()
            .setNextPageToken("")
            .addAllNetworkPolicies(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListNetworkPoliciesPagedResponse pagedListResponse = client.listNetworkPolicies(parent);

    List<NetworkPolicy> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getNetworkPoliciesList().get(0), resources.get(0));

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
  public void listNetworkPoliciesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listNetworkPolicies(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listNetworkPoliciesTest2() throws Exception {
    NetworkPolicy responsesElement = NetworkPolicy.newBuilder().build();
    ListNetworkPoliciesResponse expectedResponse =
        ListNetworkPoliciesResponse.newBuilder()
            .setNextPageToken("")
            .addAllNetworkPolicies(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListNetworkPoliciesPagedResponse pagedListResponse = client.listNetworkPolicies(parent);

    List<NetworkPolicy> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getNetworkPoliciesList().get(0), resources.get(0));

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
  public void listNetworkPoliciesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listNetworkPolicies(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createNetworkPolicyTest() throws Exception {
    NetworkPolicy expectedResponse =
        NetworkPolicy.newBuilder()
            .setName(NetworkPolicyName.of("[PROJECT]", "[LOCATION]", "[NETWORK_POLICY]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setInternetAccess(NetworkPolicy.NetworkService.newBuilder().build())
            .setExternalIp(NetworkPolicy.NetworkService.newBuilder().build())
            .setEdgeServicesCidr("edgeServicesCidr846515023")
            .setUid("uid115792")
            .setVmwareEngineNetwork(
                VmwareEngineNetworkName.of("[PROJECT]", "[LOCATION]", "[VMWARE_ENGINE_NETWORK]")
                    .toString())
            .setDescription("description-1724546052")
            .setVmwareEngineNetworkCanonical(
                VmwareEngineNetworkName.of("[PROJECT]", "[LOCATION]", "[VMWARE_ENGINE_NETWORK]")
                    .toString())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createNetworkPolicyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    NetworkPolicy networkPolicy = NetworkPolicy.newBuilder().build();
    String networkPolicyId = "networkPolicyId-727262661";

    NetworkPolicy actualResponse =
        client.createNetworkPolicyAsync(parent, networkPolicy, networkPolicyId).get();
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
  public void createNetworkPolicyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      NetworkPolicy networkPolicy = NetworkPolicy.newBuilder().build();
      String networkPolicyId = "networkPolicyId-727262661";
      client.createNetworkPolicyAsync(parent, networkPolicy, networkPolicyId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createNetworkPolicyTest2() throws Exception {
    NetworkPolicy expectedResponse =
        NetworkPolicy.newBuilder()
            .setName(NetworkPolicyName.of("[PROJECT]", "[LOCATION]", "[NETWORK_POLICY]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setInternetAccess(NetworkPolicy.NetworkService.newBuilder().build())
            .setExternalIp(NetworkPolicy.NetworkService.newBuilder().build())
            .setEdgeServicesCidr("edgeServicesCidr846515023")
            .setUid("uid115792")
            .setVmwareEngineNetwork(
                VmwareEngineNetworkName.of("[PROJECT]", "[LOCATION]", "[VMWARE_ENGINE_NETWORK]")
                    .toString())
            .setDescription("description-1724546052")
            .setVmwareEngineNetworkCanonical(
                VmwareEngineNetworkName.of("[PROJECT]", "[LOCATION]", "[VMWARE_ENGINE_NETWORK]")
                    .toString())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createNetworkPolicyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5833/locations/location-5833";
    NetworkPolicy networkPolicy = NetworkPolicy.newBuilder().build();
    String networkPolicyId = "networkPolicyId-727262661";

    NetworkPolicy actualResponse =
        client.createNetworkPolicyAsync(parent, networkPolicy, networkPolicyId).get();
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
  public void createNetworkPolicyExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      NetworkPolicy networkPolicy = NetworkPolicy.newBuilder().build();
      String networkPolicyId = "networkPolicyId-727262661";
      client.createNetworkPolicyAsync(parent, networkPolicy, networkPolicyId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void updateNetworkPolicyTest() throws Exception {
    NetworkPolicy expectedResponse =
        NetworkPolicy.newBuilder()
            .setName(NetworkPolicyName.of("[PROJECT]", "[LOCATION]", "[NETWORK_POLICY]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setInternetAccess(NetworkPolicy.NetworkService.newBuilder().build())
            .setExternalIp(NetworkPolicy.NetworkService.newBuilder().build())
            .setEdgeServicesCidr("edgeServicesCidr846515023")
            .setUid("uid115792")
            .setVmwareEngineNetwork(
                VmwareEngineNetworkName.of("[PROJECT]", "[LOCATION]", "[VMWARE_ENGINE_NETWORK]")
                    .toString())
            .setDescription("description-1724546052")
            .setVmwareEngineNetworkCanonical(
                VmwareEngineNetworkName.of("[PROJECT]", "[LOCATION]", "[VMWARE_ENGINE_NETWORK]")
                    .toString())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateNetworkPolicyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    NetworkPolicy networkPolicy =
        NetworkPolicy.newBuilder()
            .setName(NetworkPolicyName.of("[PROJECT]", "[LOCATION]", "[NETWORK_POLICY]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setInternetAccess(NetworkPolicy.NetworkService.newBuilder().build())
            .setExternalIp(NetworkPolicy.NetworkService.newBuilder().build())
            .setEdgeServicesCidr("edgeServicesCidr846515023")
            .setUid("uid115792")
            .setVmwareEngineNetwork(
                VmwareEngineNetworkName.of("[PROJECT]", "[LOCATION]", "[VMWARE_ENGINE_NETWORK]")
                    .toString())
            .setDescription("description-1724546052")
            .setVmwareEngineNetworkCanonical(
                VmwareEngineNetworkName.of("[PROJECT]", "[LOCATION]", "[VMWARE_ENGINE_NETWORK]")
                    .toString())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    NetworkPolicy actualResponse = client.updateNetworkPolicyAsync(networkPolicy, updateMask).get();
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
  public void updateNetworkPolicyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkPolicy networkPolicy =
          NetworkPolicy.newBuilder()
              .setName(
                  NetworkPolicyName.of("[PROJECT]", "[LOCATION]", "[NETWORK_POLICY]").toString())
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .setInternetAccess(NetworkPolicy.NetworkService.newBuilder().build())
              .setExternalIp(NetworkPolicy.NetworkService.newBuilder().build())
              .setEdgeServicesCidr("edgeServicesCidr846515023")
              .setUid("uid115792")
              .setVmwareEngineNetwork(
                  VmwareEngineNetworkName.of("[PROJECT]", "[LOCATION]", "[VMWARE_ENGINE_NETWORK]")
                      .toString())
              .setDescription("description-1724546052")
              .setVmwareEngineNetworkCanonical(
                  VmwareEngineNetworkName.of("[PROJECT]", "[LOCATION]", "[VMWARE_ENGINE_NETWORK]")
                      .toString())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateNetworkPolicyAsync(networkPolicy, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteNetworkPolicyTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteNetworkPolicyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    NetworkPolicyName name = NetworkPolicyName.of("[PROJECT]", "[LOCATION]", "[NETWORK_POLICY]");

    client.deleteNetworkPolicyAsync(name).get();

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
  public void deleteNetworkPolicyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkPolicyName name = NetworkPolicyName.of("[PROJECT]", "[LOCATION]", "[NETWORK_POLICY]");
      client.deleteNetworkPolicyAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteNetworkPolicyTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteNetworkPolicyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name =
        "projects/project-6412/locations/location-6412/networkPolicies/networkPolicie-6412";

    client.deleteNetworkPolicyAsync(name).get();

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
  public void deleteNetworkPolicyExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-6412/locations/location-6412/networkPolicies/networkPolicie-6412";
      client.deleteNetworkPolicyAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createVmwareEngineNetworkTest() throws Exception {
    VmwareEngineNetwork expectedResponse =
        VmwareEngineNetwork.newBuilder()
            .setName(
                VmwareEngineNetworkName.of("[PROJECT]", "[LOCATION]", "[VMWARE_ENGINE_NETWORK]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .addAllVpcNetworks(new ArrayList<VmwareEngineNetwork.VpcNetwork>())
            .setUid("uid115792")
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createVmwareEngineNetworkTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    VmwareEngineNetwork vmwareEngineNetwork = VmwareEngineNetwork.newBuilder().build();
    String vmwareEngineNetworkId = "vmwareEngineNetworkId532532083";

    VmwareEngineNetwork actualResponse =
        client
            .createVmwareEngineNetworkAsync(parent, vmwareEngineNetwork, vmwareEngineNetworkId)
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
  public void createVmwareEngineNetworkExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      VmwareEngineNetwork vmwareEngineNetwork = VmwareEngineNetwork.newBuilder().build();
      String vmwareEngineNetworkId = "vmwareEngineNetworkId532532083";
      client
          .createVmwareEngineNetworkAsync(parent, vmwareEngineNetwork, vmwareEngineNetworkId)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createVmwareEngineNetworkTest2() throws Exception {
    VmwareEngineNetwork expectedResponse =
        VmwareEngineNetwork.newBuilder()
            .setName(
                VmwareEngineNetworkName.of("[PROJECT]", "[LOCATION]", "[VMWARE_ENGINE_NETWORK]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .addAllVpcNetworks(new ArrayList<VmwareEngineNetwork.VpcNetwork>())
            .setUid("uid115792")
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createVmwareEngineNetworkTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5833/locations/location-5833";
    VmwareEngineNetwork vmwareEngineNetwork = VmwareEngineNetwork.newBuilder().build();
    String vmwareEngineNetworkId = "vmwareEngineNetworkId532532083";

    VmwareEngineNetwork actualResponse =
        client
            .createVmwareEngineNetworkAsync(parent, vmwareEngineNetwork, vmwareEngineNetworkId)
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
  public void createVmwareEngineNetworkExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      VmwareEngineNetwork vmwareEngineNetwork = VmwareEngineNetwork.newBuilder().build();
      String vmwareEngineNetworkId = "vmwareEngineNetworkId532532083";
      client
          .createVmwareEngineNetworkAsync(parent, vmwareEngineNetwork, vmwareEngineNetworkId)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void updateVmwareEngineNetworkTest() throws Exception {
    VmwareEngineNetwork expectedResponse =
        VmwareEngineNetwork.newBuilder()
            .setName(
                VmwareEngineNetworkName.of("[PROJECT]", "[LOCATION]", "[VMWARE_ENGINE_NETWORK]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .addAllVpcNetworks(new ArrayList<VmwareEngineNetwork.VpcNetwork>())
            .setUid("uid115792")
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateVmwareEngineNetworkTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    VmwareEngineNetwork vmwareEngineNetwork =
        VmwareEngineNetwork.newBuilder()
            .setName(
                VmwareEngineNetworkName.of("[PROJECT]", "[LOCATION]", "[VMWARE_ENGINE_NETWORK]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .addAllVpcNetworks(new ArrayList<VmwareEngineNetwork.VpcNetwork>())
            .setUid("uid115792")
            .setEtag("etag3123477")
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    VmwareEngineNetwork actualResponse =
        client.updateVmwareEngineNetworkAsync(vmwareEngineNetwork, updateMask).get();
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
  public void updateVmwareEngineNetworkExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      VmwareEngineNetwork vmwareEngineNetwork =
          VmwareEngineNetwork.newBuilder()
              .setName(
                  VmwareEngineNetworkName.of("[PROJECT]", "[LOCATION]", "[VMWARE_ENGINE_NETWORK]")
                      .toString())
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .setDescription("description-1724546052")
              .addAllVpcNetworks(new ArrayList<VmwareEngineNetwork.VpcNetwork>())
              .setUid("uid115792")
              .setEtag("etag3123477")
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateVmwareEngineNetworkAsync(vmwareEngineNetwork, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteVmwareEngineNetworkTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteVmwareEngineNetworkTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    VmwareEngineNetworkName name =
        VmwareEngineNetworkName.of("[PROJECT]", "[LOCATION]", "[VMWARE_ENGINE_NETWORK]");

    client.deleteVmwareEngineNetworkAsync(name).get();

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
  public void deleteVmwareEngineNetworkExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      VmwareEngineNetworkName name =
          VmwareEngineNetworkName.of("[PROJECT]", "[LOCATION]", "[VMWARE_ENGINE_NETWORK]");
      client.deleteVmwareEngineNetworkAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteVmwareEngineNetworkTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteVmwareEngineNetworkTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name =
        "projects/project-9883/locations/location-9883/vmwareEngineNetworks/vmwareEngineNetwork-9883";

    client.deleteVmwareEngineNetworkAsync(name).get();

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
  public void deleteVmwareEngineNetworkExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-9883/locations/location-9883/vmwareEngineNetworks/vmwareEngineNetwork-9883";
      client.deleteVmwareEngineNetworkAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void getVmwareEngineNetworkTest() throws Exception {
    VmwareEngineNetwork expectedResponse =
        VmwareEngineNetwork.newBuilder()
            .setName(
                VmwareEngineNetworkName.of("[PROJECT]", "[LOCATION]", "[VMWARE_ENGINE_NETWORK]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .addAllVpcNetworks(new ArrayList<VmwareEngineNetwork.VpcNetwork>())
            .setUid("uid115792")
            .setEtag("etag3123477")
            .build();
    mockService.addResponse(expectedResponse);

    VmwareEngineNetworkName name =
        VmwareEngineNetworkName.of("[PROJECT]", "[LOCATION]", "[VMWARE_ENGINE_NETWORK]");

    VmwareEngineNetwork actualResponse = client.getVmwareEngineNetwork(name);
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
  public void getVmwareEngineNetworkExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      VmwareEngineNetworkName name =
          VmwareEngineNetworkName.of("[PROJECT]", "[LOCATION]", "[VMWARE_ENGINE_NETWORK]");
      client.getVmwareEngineNetwork(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getVmwareEngineNetworkTest2() throws Exception {
    VmwareEngineNetwork expectedResponse =
        VmwareEngineNetwork.newBuilder()
            .setName(
                VmwareEngineNetworkName.of("[PROJECT]", "[LOCATION]", "[VMWARE_ENGINE_NETWORK]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .addAllVpcNetworks(new ArrayList<VmwareEngineNetwork.VpcNetwork>())
            .setUid("uid115792")
            .setEtag("etag3123477")
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-9883/locations/location-9883/vmwareEngineNetworks/vmwareEngineNetwork-9883";

    VmwareEngineNetwork actualResponse = client.getVmwareEngineNetwork(name);
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
  public void getVmwareEngineNetworkExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-9883/locations/location-9883/vmwareEngineNetworks/vmwareEngineNetwork-9883";
      client.getVmwareEngineNetwork(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listVmwareEngineNetworksTest() throws Exception {
    VmwareEngineNetwork responsesElement = VmwareEngineNetwork.newBuilder().build();
    ListVmwareEngineNetworksResponse expectedResponse =
        ListVmwareEngineNetworksResponse.newBuilder()
            .setNextPageToken("")
            .addAllVmwareEngineNetworks(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListVmwareEngineNetworksPagedResponse pagedListResponse =
        client.listVmwareEngineNetworks(parent);

    List<VmwareEngineNetwork> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getVmwareEngineNetworksList().get(0), resources.get(0));

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
  public void listVmwareEngineNetworksExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listVmwareEngineNetworks(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listVmwareEngineNetworksTest2() throws Exception {
    VmwareEngineNetwork responsesElement = VmwareEngineNetwork.newBuilder().build();
    ListVmwareEngineNetworksResponse expectedResponse =
        ListVmwareEngineNetworksResponse.newBuilder()
            .setNextPageToken("")
            .addAllVmwareEngineNetworks(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListVmwareEngineNetworksPagedResponse pagedListResponse =
        client.listVmwareEngineNetworks(parent);

    List<VmwareEngineNetwork> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getVmwareEngineNetworksList().get(0), resources.get(0));

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
  public void listVmwareEngineNetworksExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listVmwareEngineNetworks(parent);
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
            .setResource(
                ClusterName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[CLUSTER]")
                    .toString())
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
              .setResource(
                  ClusterName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[CLUSTER]")
                      .toString())
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
            .setResource(
                ClusterName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[CLUSTER]")
                    .toString())
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
              .setResource(
                  ClusterName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[CLUSTER]")
                      .toString())
              .setOptions(GetPolicyOptions.newBuilder().build())
              .build();
      client.getIamPolicy(request);
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
            .setResource(
                ClusterName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[CLUSTER]")
                    .toString())
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
              .setResource(
                  ClusterName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[CLUSTER]")
                      .toString())
              .addAllPermissions(new ArrayList<String>())
              .build();
      client.testIamPermissions(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
