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

package com.google.cloud.cloudsecuritycompliance.v1;

import static com.google.cloud.cloudsecuritycompliance.v1.DeploymentClient.ListCloudControlDeploymentsPagedResponse;
import static com.google.cloud.cloudsecuritycompliance.v1.DeploymentClient.ListFrameworkDeploymentsPagedResponse;
import static com.google.cloud.cloudsecuritycompliance.v1.DeploymentClient.ListLocationsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.cloudsecuritycompliance.v1.stub.HttpJsonDeploymentStub;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
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
public class DeploymentClientHttpJsonTest {
  private static MockHttpService mockService;
  private static DeploymentClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonDeploymentStub.getMethodDescriptors(), DeploymentSettings.getDefaultEndpoint());
    DeploymentSettings settings =
        DeploymentSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                DeploymentSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = DeploymentClient.create(settings);
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
  public void createFrameworkDeploymentTest() throws Exception {
    FrameworkDeployment expectedResponse =
        FrameworkDeployment.newBuilder()
            .setName(
                FrameworkDeploymentName.of("[ORGANIZATION]", "[LOCATION]", "[FRAMEWORK_DEPLOYMENT]")
                    .toString())
            .setTargetResourceConfig(TargetResourceConfig.newBuilder().build())
            .setComputedTargetResource("computedTargetResource-479139540")
            .setFramework(FrameworkReference.newBuilder().build())
            .setDescription("description-1724546052")
            .addAllCloudControlMetadata(new ArrayList<CloudControlMetadata>())
            .setDeploymentState(DeploymentState.forNumber(0))
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setTargetResourceDisplayName("targetResourceDisplayName-1474402258")
            .addAllCloudControlDeploymentReferences(
                new ArrayList<CloudControlDeploymentReference>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createFrameworkDeploymentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
    FrameworkDeployment frameworkDeployment = FrameworkDeployment.newBuilder().build();
    String frameworkDeploymentId = "frameworkDeploymentId-1244700706";

    FrameworkDeployment actualResponse =
        client
            .createFrameworkDeploymentAsync(parent, frameworkDeployment, frameworkDeploymentId)
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
  public void createFrameworkDeploymentExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
      FrameworkDeployment frameworkDeployment = FrameworkDeployment.newBuilder().build();
      String frameworkDeploymentId = "frameworkDeploymentId-1244700706";
      client
          .createFrameworkDeploymentAsync(parent, frameworkDeployment, frameworkDeploymentId)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createFrameworkDeploymentTest2() throws Exception {
    FrameworkDeployment expectedResponse =
        FrameworkDeployment.newBuilder()
            .setName(
                FrameworkDeploymentName.of("[ORGANIZATION]", "[LOCATION]", "[FRAMEWORK_DEPLOYMENT]")
                    .toString())
            .setTargetResourceConfig(TargetResourceConfig.newBuilder().build())
            .setComputedTargetResource("computedTargetResource-479139540")
            .setFramework(FrameworkReference.newBuilder().build())
            .setDescription("description-1724546052")
            .addAllCloudControlMetadata(new ArrayList<CloudControlMetadata>())
            .setDeploymentState(DeploymentState.forNumber(0))
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setTargetResourceDisplayName("targetResourceDisplayName-1474402258")
            .addAllCloudControlDeploymentReferences(
                new ArrayList<CloudControlDeploymentReference>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createFrameworkDeploymentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "organizations/organization-9365/locations/location-9365";
    FrameworkDeployment frameworkDeployment = FrameworkDeployment.newBuilder().build();
    String frameworkDeploymentId = "frameworkDeploymentId-1244700706";

    FrameworkDeployment actualResponse =
        client
            .createFrameworkDeploymentAsync(parent, frameworkDeployment, frameworkDeploymentId)
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
  public void createFrameworkDeploymentExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "organizations/organization-9365/locations/location-9365";
      FrameworkDeployment frameworkDeployment = FrameworkDeployment.newBuilder().build();
      String frameworkDeploymentId = "frameworkDeploymentId-1244700706";
      client
          .createFrameworkDeploymentAsync(parent, frameworkDeployment, frameworkDeploymentId)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteFrameworkDeploymentTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteFrameworkDeploymentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    FrameworkDeploymentName name =
        FrameworkDeploymentName.of("[ORGANIZATION]", "[LOCATION]", "[FRAMEWORK_DEPLOYMENT]");

    client.deleteFrameworkDeploymentAsync(name).get();

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
  public void deleteFrameworkDeploymentExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      FrameworkDeploymentName name =
          FrameworkDeploymentName.of("[ORGANIZATION]", "[LOCATION]", "[FRAMEWORK_DEPLOYMENT]");
      client.deleteFrameworkDeploymentAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteFrameworkDeploymentTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteFrameworkDeploymentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name =
        "organizations/organization-1440/locations/location-1440/frameworkDeployments/frameworkDeployment-1440";

    client.deleteFrameworkDeploymentAsync(name).get();

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
  public void deleteFrameworkDeploymentExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "organizations/organization-1440/locations/location-1440/frameworkDeployments/frameworkDeployment-1440";
      client.deleteFrameworkDeploymentAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void getFrameworkDeploymentTest() throws Exception {
    FrameworkDeployment expectedResponse =
        FrameworkDeployment.newBuilder()
            .setName(
                FrameworkDeploymentName.of("[ORGANIZATION]", "[LOCATION]", "[FRAMEWORK_DEPLOYMENT]")
                    .toString())
            .setTargetResourceConfig(TargetResourceConfig.newBuilder().build())
            .setComputedTargetResource("computedTargetResource-479139540")
            .setFramework(FrameworkReference.newBuilder().build())
            .setDescription("description-1724546052")
            .addAllCloudControlMetadata(new ArrayList<CloudControlMetadata>())
            .setDeploymentState(DeploymentState.forNumber(0))
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setTargetResourceDisplayName("targetResourceDisplayName-1474402258")
            .addAllCloudControlDeploymentReferences(
                new ArrayList<CloudControlDeploymentReference>())
            .build();
    mockService.addResponse(expectedResponse);

    FrameworkDeploymentName name =
        FrameworkDeploymentName.of("[ORGANIZATION]", "[LOCATION]", "[FRAMEWORK_DEPLOYMENT]");

    FrameworkDeployment actualResponse = client.getFrameworkDeployment(name);
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
  public void getFrameworkDeploymentExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      FrameworkDeploymentName name =
          FrameworkDeploymentName.of("[ORGANIZATION]", "[LOCATION]", "[FRAMEWORK_DEPLOYMENT]");
      client.getFrameworkDeployment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getFrameworkDeploymentTest2() throws Exception {
    FrameworkDeployment expectedResponse =
        FrameworkDeployment.newBuilder()
            .setName(
                FrameworkDeploymentName.of("[ORGANIZATION]", "[LOCATION]", "[FRAMEWORK_DEPLOYMENT]")
                    .toString())
            .setTargetResourceConfig(TargetResourceConfig.newBuilder().build())
            .setComputedTargetResource("computedTargetResource-479139540")
            .setFramework(FrameworkReference.newBuilder().build())
            .setDescription("description-1724546052")
            .addAllCloudControlMetadata(new ArrayList<CloudControlMetadata>())
            .setDeploymentState(DeploymentState.forNumber(0))
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setTargetResourceDisplayName("targetResourceDisplayName-1474402258")
            .addAllCloudControlDeploymentReferences(
                new ArrayList<CloudControlDeploymentReference>())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "organizations/organization-1440/locations/location-1440/frameworkDeployments/frameworkDeployment-1440";

    FrameworkDeployment actualResponse = client.getFrameworkDeployment(name);
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
  public void getFrameworkDeploymentExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "organizations/organization-1440/locations/location-1440/frameworkDeployments/frameworkDeployment-1440";
      client.getFrameworkDeployment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listFrameworkDeploymentsTest() throws Exception {
    FrameworkDeployment responsesElement = FrameworkDeployment.newBuilder().build();
    ListFrameworkDeploymentsResponse expectedResponse =
        ListFrameworkDeploymentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllFrameworkDeployments(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");

    ListFrameworkDeploymentsPagedResponse pagedListResponse =
        client.listFrameworkDeployments(parent);

    List<FrameworkDeployment> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getFrameworkDeploymentsList().get(0), resources.get(0));

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
  public void listFrameworkDeploymentsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
      client.listFrameworkDeployments(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listFrameworkDeploymentsTest2() throws Exception {
    FrameworkDeployment responsesElement = FrameworkDeployment.newBuilder().build();
    ListFrameworkDeploymentsResponse expectedResponse =
        ListFrameworkDeploymentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllFrameworkDeployments(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "organizations/organization-9365/locations/location-9365";

    ListFrameworkDeploymentsPagedResponse pagedListResponse =
        client.listFrameworkDeployments(parent);

    List<FrameworkDeployment> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getFrameworkDeploymentsList().get(0), resources.get(0));

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
  public void listFrameworkDeploymentsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "organizations/organization-9365/locations/location-9365";
      client.listFrameworkDeployments(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getCloudControlDeploymentTest() throws Exception {
    CloudControlDeployment expectedResponse =
        CloudControlDeployment.newBuilder()
            .setName(
                CloudControlDeploymentName.of(
                        "[ORGANIZATION]", "[LOCATION]", "[CLOUD_CONTROL_DEPLOYMENT]")
                    .toString())
            .setTargetResourceConfig(TargetResourceConfig.newBuilder().build())
            .setTargetResource("targetResource-1933150017")
            .setCloudControlMetadata(CloudControlMetadata.newBuilder().build())
            .setDescription("description-1724546052")
            .setDeploymentState(DeploymentState.forNumber(0))
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setParameterSubstitutedCloudControl(CloudControl.newBuilder().build())
            .addAllFrameworkDeploymentReferences(new ArrayList<FrameworkDeploymentReference>())
            .setTargetResourceDisplayName("targetResourceDisplayName-1474402258")
            .build();
    mockService.addResponse(expectedResponse);

    CloudControlDeploymentName name =
        CloudControlDeploymentName.of("[ORGANIZATION]", "[LOCATION]", "[CLOUD_CONTROL_DEPLOYMENT]");

    CloudControlDeployment actualResponse = client.getCloudControlDeployment(name);
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
  public void getCloudControlDeploymentExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CloudControlDeploymentName name =
          CloudControlDeploymentName.of(
              "[ORGANIZATION]", "[LOCATION]", "[CLOUD_CONTROL_DEPLOYMENT]");
      client.getCloudControlDeployment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getCloudControlDeploymentTest2() throws Exception {
    CloudControlDeployment expectedResponse =
        CloudControlDeployment.newBuilder()
            .setName(
                CloudControlDeploymentName.of(
                        "[ORGANIZATION]", "[LOCATION]", "[CLOUD_CONTROL_DEPLOYMENT]")
                    .toString())
            .setTargetResourceConfig(TargetResourceConfig.newBuilder().build())
            .setTargetResource("targetResource-1933150017")
            .setCloudControlMetadata(CloudControlMetadata.newBuilder().build())
            .setDescription("description-1724546052")
            .setDeploymentState(DeploymentState.forNumber(0))
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setParameterSubstitutedCloudControl(CloudControl.newBuilder().build())
            .addAllFrameworkDeploymentReferences(new ArrayList<FrameworkDeploymentReference>())
            .setTargetResourceDisplayName("targetResourceDisplayName-1474402258")
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "organizations/organization-8812/locations/location-8812/cloudControlDeployments/cloudControlDeployment-8812";

    CloudControlDeployment actualResponse = client.getCloudControlDeployment(name);
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
  public void getCloudControlDeploymentExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "organizations/organization-8812/locations/location-8812/cloudControlDeployments/cloudControlDeployment-8812";
      client.getCloudControlDeployment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listCloudControlDeploymentsTest() throws Exception {
    CloudControlDeployment responsesElement = CloudControlDeployment.newBuilder().build();
    ListCloudControlDeploymentsResponse expectedResponse =
        ListCloudControlDeploymentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllCloudControlDeployments(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");

    ListCloudControlDeploymentsPagedResponse pagedListResponse =
        client.listCloudControlDeployments(parent);

    List<CloudControlDeployment> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCloudControlDeploymentsList().get(0), resources.get(0));

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
  public void listCloudControlDeploymentsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
      client.listCloudControlDeployments(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listCloudControlDeploymentsTest2() throws Exception {
    CloudControlDeployment responsesElement = CloudControlDeployment.newBuilder().build();
    ListCloudControlDeploymentsResponse expectedResponse =
        ListCloudControlDeploymentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllCloudControlDeployments(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "organizations/organization-9365/locations/location-9365";

    ListCloudControlDeploymentsPagedResponse pagedListResponse =
        client.listCloudControlDeployments(parent);

    List<CloudControlDeployment> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCloudControlDeploymentsList().get(0), resources.get(0));

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
  public void listCloudControlDeploymentsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "organizations/organization-9365/locations/location-9365";
      client.listCloudControlDeployments(parent);
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
            .setName("organizations/organization-1936")
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
              .setName("organizations/organization-1936")
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
            .setName("organizations/organization-7066/locations/location-7066")
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
              .setName("organizations/organization-7066/locations/location-7066")
              .build();
      client.getLocation(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
