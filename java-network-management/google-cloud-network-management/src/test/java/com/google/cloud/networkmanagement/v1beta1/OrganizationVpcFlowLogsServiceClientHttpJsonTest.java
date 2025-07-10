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

package com.google.cloud.networkmanagement.v1beta1;

import static com.google.cloud.networkmanagement.v1beta1.OrganizationVpcFlowLogsServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.networkmanagement.v1beta1.OrganizationVpcFlowLogsServiceClient.ListVpcFlowLogsConfigsPagedResponse;

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
import com.google.cloud.networkmanagement.v1beta1.stub.HttpJsonOrganizationVpcFlowLogsServiceStub;
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
public class OrganizationVpcFlowLogsServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static OrganizationVpcFlowLogsServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonOrganizationVpcFlowLogsServiceStub.getMethodDescriptors(),
            OrganizationVpcFlowLogsServiceSettings.getDefaultEndpoint());
    OrganizationVpcFlowLogsServiceSettings settings =
        OrganizationVpcFlowLogsServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                OrganizationVpcFlowLogsServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = OrganizationVpcFlowLogsServiceClient.create(settings);
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

  @Ignore("See: https://github.com/googleapis/sdk-platform-java/issues/1839")
  @Test
  public void listVpcFlowLogsConfigsTest() throws Exception {
    VpcFlowLogsConfig responsesElement = VpcFlowLogsConfig.newBuilder().build();
    ListVpcFlowLogsConfigsResponse expectedResponse =
        ListVpcFlowLogsConfigsResponse.newBuilder()
            .setNextPageToken("")
            .addAllVpcFlowLogsConfigs(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListVpcFlowLogsConfigsPagedResponse pagedListResponse = client.listVpcFlowLogsConfigs(parent);

    List<VpcFlowLogsConfig> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getVpcFlowLogsConfigsList().get(0), resources.get(0));

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
  public void listVpcFlowLogsConfigsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listVpcFlowLogsConfigs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listVpcFlowLogsConfigsTest2() throws Exception {
    VpcFlowLogsConfig responsesElement = VpcFlowLogsConfig.newBuilder().build();
    ListVpcFlowLogsConfigsResponse expectedResponse =
        ListVpcFlowLogsConfigsResponse.newBuilder()
            .setNextPageToken("")
            .addAllVpcFlowLogsConfigs(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");

    ListVpcFlowLogsConfigsPagedResponse pagedListResponse = client.listVpcFlowLogsConfigs(parent);

    List<VpcFlowLogsConfig> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getVpcFlowLogsConfigsList().get(0), resources.get(0));

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
  public void listVpcFlowLogsConfigsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
      client.listVpcFlowLogsConfigs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listVpcFlowLogsConfigsTest3() throws Exception {
    VpcFlowLogsConfig responsesElement = VpcFlowLogsConfig.newBuilder().build();
    ListVpcFlowLogsConfigsResponse expectedResponse =
        ListVpcFlowLogsConfigsResponse.newBuilder()
            .setNextPageToken("")
            .addAllVpcFlowLogsConfigs(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "organizations/organization-9365/locations/location-9365";

    ListVpcFlowLogsConfigsPagedResponse pagedListResponse = client.listVpcFlowLogsConfigs(parent);

    List<VpcFlowLogsConfig> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getVpcFlowLogsConfigsList().get(0), resources.get(0));

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
  public void listVpcFlowLogsConfigsExceptionTest3() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "organizations/organization-9365/locations/location-9365";
      client.listVpcFlowLogsConfigs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getVpcFlowLogsConfigTest() throws Exception {
    VpcFlowLogsConfig expectedResponse =
        VpcFlowLogsConfig.newBuilder()
            .setName(
                VpcFlowLogsConfigName.ofOrganizationLocationVpcFlowLogsConfigName(
                        "[ORGANIZATION]", "[LOCATION]", "[VPC_FLOW_LOGS_CONFIG]")
                    .toString())
            .setDescription("description-1724546052")
            .setFlowSampling(-543591464)
            .addAllMetadataFields(new ArrayList<String>())
            .setFilterExpr("filterExpr-1553498739")
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    VpcFlowLogsConfigName name =
        VpcFlowLogsConfigName.ofOrganizationLocationVpcFlowLogsConfigName(
            "[ORGANIZATION]", "[LOCATION]", "[VPC_FLOW_LOGS_CONFIG]");

    VpcFlowLogsConfig actualResponse = client.getVpcFlowLogsConfig(name);
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
  public void getVpcFlowLogsConfigExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      VpcFlowLogsConfigName name =
          VpcFlowLogsConfigName.ofOrganizationLocationVpcFlowLogsConfigName(
              "[ORGANIZATION]", "[LOCATION]", "[VPC_FLOW_LOGS_CONFIG]");
      client.getVpcFlowLogsConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getVpcFlowLogsConfigTest2() throws Exception {
    VpcFlowLogsConfig expectedResponse =
        VpcFlowLogsConfig.newBuilder()
            .setName(
                VpcFlowLogsConfigName.ofOrganizationLocationVpcFlowLogsConfigName(
                        "[ORGANIZATION]", "[LOCATION]", "[VPC_FLOW_LOGS_CONFIG]")
                    .toString())
            .setDescription("description-1724546052")
            .setFlowSampling(-543591464)
            .addAllMetadataFields(new ArrayList<String>())
            .setFilterExpr("filterExpr-1553498739")
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "organizations/organization-7429/locations/location-7429/vpcFlowLogsConfigs/vpcFlowLogsConfig-7429";

    VpcFlowLogsConfig actualResponse = client.getVpcFlowLogsConfig(name);
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
  public void getVpcFlowLogsConfigExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "organizations/organization-7429/locations/location-7429/vpcFlowLogsConfigs/vpcFlowLogsConfig-7429";
      client.getVpcFlowLogsConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Ignore("See: https://github.com/googleapis/sdk-platform-java/issues/1839")
  @Test
  public void createVpcFlowLogsConfigTest() throws Exception {
    VpcFlowLogsConfig expectedResponse =
        VpcFlowLogsConfig.newBuilder()
            .setName(
                VpcFlowLogsConfigName.ofProjectLocationVpcFlowLogsConfigName(
                        "[PROJECT]", "[LOCATION]", "[VPC_FLOW_LOGS_CONFIG]")
                    .toString())
            .setDescription("description-1724546052")
            .setFlowSampling(-543591464)
            .addAllMetadataFields(new ArrayList<String>())
            .setFilterExpr("filterExpr-1553498739")
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createVpcFlowLogsConfigTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    VpcFlowLogsConfig vpcFlowLogsConfig = VpcFlowLogsConfig.newBuilder().build();
    VpcFlowLogsConfigName vpcFlowLogsConfigId =
        VpcFlowLogsConfigName.ofProjectLocationVpcFlowLogsConfigName(
            "[PROJECT]", "[LOCATION]", "[VPC_FLOW_LOGS_CONFIG]");

    VpcFlowLogsConfig actualResponse =
        client.createVpcFlowLogsConfigAsync(parent, vpcFlowLogsConfig, vpcFlowLogsConfigId).get();
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
  public void createVpcFlowLogsConfigExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      VpcFlowLogsConfig vpcFlowLogsConfig = VpcFlowLogsConfig.newBuilder().build();
      VpcFlowLogsConfigName vpcFlowLogsConfigId =
          VpcFlowLogsConfigName.ofProjectLocationVpcFlowLogsConfigName(
              "[PROJECT]", "[LOCATION]", "[VPC_FLOW_LOGS_CONFIG]");
      client.createVpcFlowLogsConfigAsync(parent, vpcFlowLogsConfig, vpcFlowLogsConfigId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Ignore("See: https://github.com/googleapis/sdk-platform-java/issues/1839")
  @Test
  public void createVpcFlowLogsConfigTest2() throws Exception {
    VpcFlowLogsConfig expectedResponse =
        VpcFlowLogsConfig.newBuilder()
            .setName(
                VpcFlowLogsConfigName.ofProjectLocationVpcFlowLogsConfigName(
                        "[PROJECT]", "[LOCATION]", "[VPC_FLOW_LOGS_CONFIG]")
                    .toString())
            .setDescription("description-1724546052")
            .setFlowSampling(-543591464)
            .addAllMetadataFields(new ArrayList<String>())
            .setFilterExpr("filterExpr-1553498739")
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createVpcFlowLogsConfigTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    VpcFlowLogsConfig vpcFlowLogsConfig = VpcFlowLogsConfig.newBuilder().build();
    String vpcFlowLogsConfigId = "vpcFlowLogsConfigId649763";

    VpcFlowLogsConfig actualResponse =
        client.createVpcFlowLogsConfigAsync(parent, vpcFlowLogsConfig, vpcFlowLogsConfigId).get();
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
  public void createVpcFlowLogsConfigExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      VpcFlowLogsConfig vpcFlowLogsConfig = VpcFlowLogsConfig.newBuilder().build();
      String vpcFlowLogsConfigId = "vpcFlowLogsConfigId649763";
      client.createVpcFlowLogsConfigAsync(parent, vpcFlowLogsConfig, vpcFlowLogsConfigId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createVpcFlowLogsConfigTest3() throws Exception {
    VpcFlowLogsConfig expectedResponse =
        VpcFlowLogsConfig.newBuilder()
            .setName(
                VpcFlowLogsConfigName.ofProjectLocationVpcFlowLogsConfigName(
                        "[PROJECT]", "[LOCATION]", "[VPC_FLOW_LOGS_CONFIG]")
                    .toString())
            .setDescription("description-1724546052")
            .setFlowSampling(-543591464)
            .addAllMetadataFields(new ArrayList<String>())
            .setFilterExpr("filterExpr-1553498739")
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createVpcFlowLogsConfigTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
    VpcFlowLogsConfig vpcFlowLogsConfig = VpcFlowLogsConfig.newBuilder().build();
    VpcFlowLogsConfigName vpcFlowLogsConfigId =
        VpcFlowLogsConfigName.ofProjectLocationVpcFlowLogsConfigName(
            "[PROJECT]", "[LOCATION]", "[VPC_FLOW_LOGS_CONFIG]");

    VpcFlowLogsConfig actualResponse =
        client.createVpcFlowLogsConfigAsync(parent, vpcFlowLogsConfig, vpcFlowLogsConfigId).get();
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
  public void createVpcFlowLogsConfigExceptionTest3() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
      VpcFlowLogsConfig vpcFlowLogsConfig = VpcFlowLogsConfig.newBuilder().build();
      VpcFlowLogsConfigName vpcFlowLogsConfigId =
          VpcFlowLogsConfigName.ofProjectLocationVpcFlowLogsConfigName(
              "[PROJECT]", "[LOCATION]", "[VPC_FLOW_LOGS_CONFIG]");
      client.createVpcFlowLogsConfigAsync(parent, vpcFlowLogsConfig, vpcFlowLogsConfigId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createVpcFlowLogsConfigTest4() throws Exception {
    VpcFlowLogsConfig expectedResponse =
        VpcFlowLogsConfig.newBuilder()
            .setName(
                VpcFlowLogsConfigName.ofProjectLocationVpcFlowLogsConfigName(
                        "[PROJECT]", "[LOCATION]", "[VPC_FLOW_LOGS_CONFIG]")
                    .toString())
            .setDescription("description-1724546052")
            .setFlowSampling(-543591464)
            .addAllMetadataFields(new ArrayList<String>())
            .setFilterExpr("filterExpr-1553498739")
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createVpcFlowLogsConfigTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
    VpcFlowLogsConfig vpcFlowLogsConfig = VpcFlowLogsConfig.newBuilder().build();
    String vpcFlowLogsConfigId = "vpcFlowLogsConfigId649763";

    VpcFlowLogsConfig actualResponse =
        client.createVpcFlowLogsConfigAsync(parent, vpcFlowLogsConfig, vpcFlowLogsConfigId).get();
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
  public void createVpcFlowLogsConfigExceptionTest4() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
      VpcFlowLogsConfig vpcFlowLogsConfig = VpcFlowLogsConfig.newBuilder().build();
      String vpcFlowLogsConfigId = "vpcFlowLogsConfigId649763";
      client.createVpcFlowLogsConfigAsync(parent, vpcFlowLogsConfig, vpcFlowLogsConfigId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createVpcFlowLogsConfigTest5() throws Exception {
    VpcFlowLogsConfig expectedResponse =
        VpcFlowLogsConfig.newBuilder()
            .setName(
                VpcFlowLogsConfigName.ofProjectLocationVpcFlowLogsConfigName(
                        "[PROJECT]", "[LOCATION]", "[VPC_FLOW_LOGS_CONFIG]")
                    .toString())
            .setDescription("description-1724546052")
            .setFlowSampling(-543591464)
            .addAllMetadataFields(new ArrayList<String>())
            .setFilterExpr("filterExpr-1553498739")
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createVpcFlowLogsConfigTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "organizations/organization-9365/locations/location-9365";
    VpcFlowLogsConfig vpcFlowLogsConfig = VpcFlowLogsConfig.newBuilder().build();
    VpcFlowLogsConfigName vpcFlowLogsConfigId =
        VpcFlowLogsConfigName.ofProjectLocationVpcFlowLogsConfigName(
            "[PROJECT]", "[LOCATION]", "[VPC_FLOW_LOGS_CONFIG]");

    VpcFlowLogsConfig actualResponse =
        client.createVpcFlowLogsConfigAsync(parent, vpcFlowLogsConfig, vpcFlowLogsConfigId).get();
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
  public void createVpcFlowLogsConfigExceptionTest5() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "organizations/organization-9365/locations/location-9365";
      VpcFlowLogsConfig vpcFlowLogsConfig = VpcFlowLogsConfig.newBuilder().build();
      VpcFlowLogsConfigName vpcFlowLogsConfigId =
          VpcFlowLogsConfigName.ofProjectLocationVpcFlowLogsConfigName(
              "[PROJECT]", "[LOCATION]", "[VPC_FLOW_LOGS_CONFIG]");
      client.createVpcFlowLogsConfigAsync(parent, vpcFlowLogsConfig, vpcFlowLogsConfigId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createVpcFlowLogsConfigTest6() throws Exception {
    VpcFlowLogsConfig expectedResponse =
        VpcFlowLogsConfig.newBuilder()
            .setName(
                VpcFlowLogsConfigName.ofProjectLocationVpcFlowLogsConfigName(
                        "[PROJECT]", "[LOCATION]", "[VPC_FLOW_LOGS_CONFIG]")
                    .toString())
            .setDescription("description-1724546052")
            .setFlowSampling(-543591464)
            .addAllMetadataFields(new ArrayList<String>())
            .setFilterExpr("filterExpr-1553498739")
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createVpcFlowLogsConfigTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "organizations/organization-9365/locations/location-9365";
    VpcFlowLogsConfig vpcFlowLogsConfig = VpcFlowLogsConfig.newBuilder().build();
    String vpcFlowLogsConfigId = "vpcFlowLogsConfigId649763";

    VpcFlowLogsConfig actualResponse =
        client.createVpcFlowLogsConfigAsync(parent, vpcFlowLogsConfig, vpcFlowLogsConfigId).get();
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
  public void createVpcFlowLogsConfigExceptionTest6() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "organizations/organization-9365/locations/location-9365";
      VpcFlowLogsConfig vpcFlowLogsConfig = VpcFlowLogsConfig.newBuilder().build();
      String vpcFlowLogsConfigId = "vpcFlowLogsConfigId649763";
      client.createVpcFlowLogsConfigAsync(parent, vpcFlowLogsConfig, vpcFlowLogsConfigId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void updateVpcFlowLogsConfigTest() throws Exception {
    VpcFlowLogsConfig expectedResponse =
        VpcFlowLogsConfig.newBuilder()
            .setName(
                VpcFlowLogsConfigName.ofOrganizationLocationVpcFlowLogsConfigName(
                        "[ORGANIZATION]", "[LOCATION]", "[VPC_FLOW_LOGS_CONFIG]")
                    .toString())
            .setDescription("description-1724546052")
            .setFlowSampling(-543591464)
            .addAllMetadataFields(new ArrayList<String>())
            .setFilterExpr("filterExpr-1553498739")
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateVpcFlowLogsConfigTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    VpcFlowLogsConfig vpcFlowLogsConfig =
        VpcFlowLogsConfig.newBuilder()
            .setName(
                VpcFlowLogsConfigName.ofOrganizationLocationVpcFlowLogsConfigName(
                        "[ORGANIZATION]", "[LOCATION]", "[VPC_FLOW_LOGS_CONFIG]")
                    .toString())
            .setDescription("description-1724546052")
            .setFlowSampling(-543591464)
            .addAllMetadataFields(new ArrayList<String>())
            .setFilterExpr("filterExpr-1553498739")
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    VpcFlowLogsConfig actualResponse =
        client.updateVpcFlowLogsConfigAsync(vpcFlowLogsConfig, updateMask).get();
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
  public void updateVpcFlowLogsConfigExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      VpcFlowLogsConfig vpcFlowLogsConfig =
          VpcFlowLogsConfig.newBuilder()
              .setName(
                  VpcFlowLogsConfigName.ofOrganizationLocationVpcFlowLogsConfigName(
                          "[ORGANIZATION]", "[LOCATION]", "[VPC_FLOW_LOGS_CONFIG]")
                      .toString())
              .setDescription("description-1724546052")
              .setFlowSampling(-543591464)
              .addAllMetadataFields(new ArrayList<String>())
              .setFilterExpr("filterExpr-1553498739")
              .putAllLabels(new HashMap<String, String>())
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateVpcFlowLogsConfigAsync(vpcFlowLogsConfig, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteVpcFlowLogsConfigTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteVpcFlowLogsConfigTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    VpcFlowLogsConfigName name =
        VpcFlowLogsConfigName.ofOrganizationLocationVpcFlowLogsConfigName(
            "[ORGANIZATION]", "[LOCATION]", "[VPC_FLOW_LOGS_CONFIG]");

    client.deleteVpcFlowLogsConfigAsync(name).get();

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
  public void deleteVpcFlowLogsConfigExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      VpcFlowLogsConfigName name =
          VpcFlowLogsConfigName.ofOrganizationLocationVpcFlowLogsConfigName(
              "[ORGANIZATION]", "[LOCATION]", "[VPC_FLOW_LOGS_CONFIG]");
      client.deleteVpcFlowLogsConfigAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteVpcFlowLogsConfigTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteVpcFlowLogsConfigTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name =
        "organizations/organization-7429/locations/location-7429/vpcFlowLogsConfigs/vpcFlowLogsConfig-7429";

    client.deleteVpcFlowLogsConfigAsync(name).get();

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
  public void deleteVpcFlowLogsConfigExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "organizations/organization-7429/locations/location-7429/vpcFlowLogsConfigs/vpcFlowLogsConfig-7429";
      client.deleteVpcFlowLogsConfigAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
            .setResource(ConnectivityTestName.of("[PROJECT]", "[TEST]").toString())
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
              .setResource(ConnectivityTestName.of("[PROJECT]", "[TEST]").toString())
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
            .setResource(ConnectivityTestName.of("[PROJECT]", "[TEST]").toString())
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
              .setResource(ConnectivityTestName.of("[PROJECT]", "[TEST]").toString())
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
            .setResource(ConnectivityTestName.of("[PROJECT]", "[TEST]").toString())
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
              .setResource(ConnectivityTestName.of("[PROJECT]", "[TEST]").toString())
              .addAllPermissions(new ArrayList<String>())
              .build();
      client.testIamPermissions(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
