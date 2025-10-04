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

import static com.google.cloud.cloudsecuritycompliance.v1.ConfigClient.ListCloudControlsPagedResponse;
import static com.google.cloud.cloudsecuritycompliance.v1.ConfigClient.ListFrameworksPagedResponse;
import static com.google.cloud.cloudsecuritycompliance.v1.ConfigClient.ListLocationsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.cloudsecuritycompliance.v1.stub.HttpJsonConfigStub;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.Lists;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
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
public class ConfigClientHttpJsonTest {
  private static MockHttpService mockService;
  private static ConfigClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonConfigStub.getMethodDescriptors(), ConfigSettings.getDefaultEndpoint());
    ConfigSettings settings =
        ConfigSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                ConfigSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ConfigClient.create(settings);
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
  public void listFrameworksTest() throws Exception {
    Framework responsesElement = Framework.newBuilder().build();
    ListFrameworksResponse expectedResponse =
        ListFrameworksResponse.newBuilder()
            .setNextPageToken("")
            .addAllFrameworks(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");

    ListFrameworksPagedResponse pagedListResponse = client.listFrameworks(parent);

    List<Framework> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getFrameworksList().get(0), resources.get(0));

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
  public void listFrameworksExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
      client.listFrameworks(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listFrameworksTest2() throws Exception {
    Framework responsesElement = Framework.newBuilder().build();
    ListFrameworksResponse expectedResponse =
        ListFrameworksResponse.newBuilder()
            .setNextPageToken("")
            .addAllFrameworks(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "organizations/organization-9365/locations/location-9365";

    ListFrameworksPagedResponse pagedListResponse = client.listFrameworks(parent);

    List<Framework> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getFrameworksList().get(0), resources.get(0));

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
  public void listFrameworksExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "organizations/organization-9365/locations/location-9365";
      client.listFrameworks(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getFrameworkTest() throws Exception {
    Framework expectedResponse =
        Framework.newBuilder()
            .setName(FrameworkName.of("[ORGANIZATION]", "[LOCATION]", "[FRAMEWORK]").toString())
            .setMajorRevisionId(612576889)
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllCloudControlDetails(new ArrayList<CloudControlDetails>())
            .addAllCategory(new ArrayList<FrameworkCategory>())
            .addAllSupportedCloudProviders(new ArrayList<CloudProvider>())
            .addAllSupportedTargetResourceTypes(new ArrayList<TargetResourceType>())
            .addAllSupportedEnforcementModes(new ArrayList<EnforcementMode>())
            .build();
    mockService.addResponse(expectedResponse);

    FrameworkName name = FrameworkName.of("[ORGANIZATION]", "[LOCATION]", "[FRAMEWORK]");

    Framework actualResponse = client.getFramework(name);
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
  public void getFrameworkExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      FrameworkName name = FrameworkName.of("[ORGANIZATION]", "[LOCATION]", "[FRAMEWORK]");
      client.getFramework(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getFrameworkTest2() throws Exception {
    Framework expectedResponse =
        Framework.newBuilder()
            .setName(FrameworkName.of("[ORGANIZATION]", "[LOCATION]", "[FRAMEWORK]").toString())
            .setMajorRevisionId(612576889)
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllCloudControlDetails(new ArrayList<CloudControlDetails>())
            .addAllCategory(new ArrayList<FrameworkCategory>())
            .addAllSupportedCloudProviders(new ArrayList<CloudProvider>())
            .addAllSupportedTargetResourceTypes(new ArrayList<TargetResourceType>())
            .addAllSupportedEnforcementModes(new ArrayList<EnforcementMode>())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "organizations/organization-501/locations/location-501/frameworks/framework-501";

    Framework actualResponse = client.getFramework(name);
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
  public void getFrameworkExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "organizations/organization-501/locations/location-501/frameworks/framework-501";
      client.getFramework(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createFrameworkTest() throws Exception {
    Framework expectedResponse =
        Framework.newBuilder()
            .setName(FrameworkName.of("[ORGANIZATION]", "[LOCATION]", "[FRAMEWORK]").toString())
            .setMajorRevisionId(612576889)
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllCloudControlDetails(new ArrayList<CloudControlDetails>())
            .addAllCategory(new ArrayList<FrameworkCategory>())
            .addAllSupportedCloudProviders(new ArrayList<CloudProvider>())
            .addAllSupportedTargetResourceTypes(new ArrayList<TargetResourceType>())
            .addAllSupportedEnforcementModes(new ArrayList<EnforcementMode>())
            .build();
    mockService.addResponse(expectedResponse);

    OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
    Framework framework = Framework.newBuilder().build();
    String frameworkId = "frameworkId886666169";

    Framework actualResponse = client.createFramework(parent, framework, frameworkId);
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
  public void createFrameworkExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
      Framework framework = Framework.newBuilder().build();
      String frameworkId = "frameworkId886666169";
      client.createFramework(parent, framework, frameworkId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createFrameworkTest2() throws Exception {
    Framework expectedResponse =
        Framework.newBuilder()
            .setName(FrameworkName.of("[ORGANIZATION]", "[LOCATION]", "[FRAMEWORK]").toString())
            .setMajorRevisionId(612576889)
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllCloudControlDetails(new ArrayList<CloudControlDetails>())
            .addAllCategory(new ArrayList<FrameworkCategory>())
            .addAllSupportedCloudProviders(new ArrayList<CloudProvider>())
            .addAllSupportedTargetResourceTypes(new ArrayList<TargetResourceType>())
            .addAllSupportedEnforcementModes(new ArrayList<EnforcementMode>())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "organizations/organization-9365/locations/location-9365";
    Framework framework = Framework.newBuilder().build();
    String frameworkId = "frameworkId886666169";

    Framework actualResponse = client.createFramework(parent, framework, frameworkId);
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
  public void createFrameworkExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "organizations/organization-9365/locations/location-9365";
      Framework framework = Framework.newBuilder().build();
      String frameworkId = "frameworkId886666169";
      client.createFramework(parent, framework, frameworkId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateFrameworkTest() throws Exception {
    Framework expectedResponse =
        Framework.newBuilder()
            .setName(FrameworkName.of("[ORGANIZATION]", "[LOCATION]", "[FRAMEWORK]").toString())
            .setMajorRevisionId(612576889)
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllCloudControlDetails(new ArrayList<CloudControlDetails>())
            .addAllCategory(new ArrayList<FrameworkCategory>())
            .addAllSupportedCloudProviders(new ArrayList<CloudProvider>())
            .addAllSupportedTargetResourceTypes(new ArrayList<TargetResourceType>())
            .addAllSupportedEnforcementModes(new ArrayList<EnforcementMode>())
            .build();
    mockService.addResponse(expectedResponse);

    Framework framework =
        Framework.newBuilder()
            .setName(FrameworkName.of("[ORGANIZATION]", "[LOCATION]", "[FRAMEWORK]").toString())
            .setMajorRevisionId(612576889)
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllCloudControlDetails(new ArrayList<CloudControlDetails>())
            .addAllCategory(new ArrayList<FrameworkCategory>())
            .addAllSupportedCloudProviders(new ArrayList<CloudProvider>())
            .addAllSupportedTargetResourceTypes(new ArrayList<TargetResourceType>())
            .addAllSupportedEnforcementModes(new ArrayList<EnforcementMode>())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Framework actualResponse = client.updateFramework(framework, updateMask);
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
  public void updateFrameworkExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Framework framework =
          Framework.newBuilder()
              .setName(FrameworkName.of("[ORGANIZATION]", "[LOCATION]", "[FRAMEWORK]").toString())
              .setMajorRevisionId(612576889)
              .setDisplayName("displayName1714148973")
              .setDescription("description-1724546052")
              .addAllCloudControlDetails(new ArrayList<CloudControlDetails>())
              .addAllCategory(new ArrayList<FrameworkCategory>())
              .addAllSupportedCloudProviders(new ArrayList<CloudProvider>())
              .addAllSupportedTargetResourceTypes(new ArrayList<TargetResourceType>())
              .addAllSupportedEnforcementModes(new ArrayList<EnforcementMode>())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateFramework(framework, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteFrameworkTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    FrameworkName name = FrameworkName.of("[ORGANIZATION]", "[LOCATION]", "[FRAMEWORK]");

    client.deleteFramework(name);

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
  public void deleteFrameworkExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      FrameworkName name = FrameworkName.of("[ORGANIZATION]", "[LOCATION]", "[FRAMEWORK]");
      client.deleteFramework(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteFrameworkTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name = "organizations/organization-501/locations/location-501/frameworks/framework-501";

    client.deleteFramework(name);

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
  public void deleteFrameworkExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "organizations/organization-501/locations/location-501/frameworks/framework-501";
      client.deleteFramework(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listCloudControlsTest() throws Exception {
    CloudControl responsesElement = CloudControl.newBuilder().build();
    ListCloudControlsResponse expectedResponse =
        ListCloudControlsResponse.newBuilder()
            .setNextPageToken("")
            .addAllCloudControls(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");

    ListCloudControlsPagedResponse pagedListResponse = client.listCloudControls(parent);

    List<CloudControl> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCloudControlsList().get(0), resources.get(0));

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
  public void listCloudControlsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
      client.listCloudControls(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listCloudControlsTest2() throws Exception {
    CloudControl responsesElement = CloudControl.newBuilder().build();
    ListCloudControlsResponse expectedResponse =
        ListCloudControlsResponse.newBuilder()
            .setNextPageToken("")
            .addAllCloudControls(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "organizations/organization-9365/locations/location-9365";

    ListCloudControlsPagedResponse pagedListResponse = client.listCloudControls(parent);

    List<CloudControl> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCloudControlsList().get(0), resources.get(0));

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
  public void listCloudControlsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "organizations/organization-9365/locations/location-9365";
      client.listCloudControls(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getCloudControlTest() throws Exception {
    CloudControl expectedResponse =
        CloudControl.newBuilder()
            .setName(
                CloudControlName.of("[ORGANIZATION]", "[LOCATION]", "[CLOUD_CONTROL]").toString())
            .setMajorRevisionId(612576889)
            .setDescription("description-1724546052")
            .setDisplayName("displayName1714148973")
            .addAllSupportedEnforcementModes(new ArrayList<EnforcementMode>())
            .addAllParameterSpec(new ArrayList<ParameterSpec>())
            .addAllRules(new ArrayList<Rule>())
            .setSeverity(Severity.forNumber(0))
            .setFindingCategory("findingCategory-1495850073")
            .addAllSupportedCloudProviders(new ArrayList<CloudProvider>())
            .addAllRelatedFrameworks(new ArrayList<String>())
            .setRemediationSteps("remediationSteps1230652930")
            .addAllCategories(new ArrayList<CloudControlCategory>())
            .setCreateTime(Timestamp.newBuilder().build())
            .addAllSupportedTargetResourceTypes(new ArrayList<TargetResourceType>())
            .build();
    mockService.addResponse(expectedResponse);

    CloudControlName name = CloudControlName.of("[ORGANIZATION]", "[LOCATION]", "[CLOUD_CONTROL]");

    CloudControl actualResponse = client.getCloudControl(name);
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
  public void getCloudControlExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CloudControlName name =
          CloudControlName.of("[ORGANIZATION]", "[LOCATION]", "[CLOUD_CONTROL]");
      client.getCloudControl(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getCloudControlTest2() throws Exception {
    CloudControl expectedResponse =
        CloudControl.newBuilder()
            .setName(
                CloudControlName.of("[ORGANIZATION]", "[LOCATION]", "[CLOUD_CONTROL]").toString())
            .setMajorRevisionId(612576889)
            .setDescription("description-1724546052")
            .setDisplayName("displayName1714148973")
            .addAllSupportedEnforcementModes(new ArrayList<EnforcementMode>())
            .addAllParameterSpec(new ArrayList<ParameterSpec>())
            .addAllRules(new ArrayList<Rule>())
            .setSeverity(Severity.forNumber(0))
            .setFindingCategory("findingCategory-1495850073")
            .addAllSupportedCloudProviders(new ArrayList<CloudProvider>())
            .addAllRelatedFrameworks(new ArrayList<String>())
            .setRemediationSteps("remediationSteps1230652930")
            .addAllCategories(new ArrayList<CloudControlCategory>())
            .setCreateTime(Timestamp.newBuilder().build())
            .addAllSupportedTargetResourceTypes(new ArrayList<TargetResourceType>())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "organizations/organization-9311/locations/location-9311/cloudControls/cloudControl-9311";

    CloudControl actualResponse = client.getCloudControl(name);
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
  public void getCloudControlExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "organizations/organization-9311/locations/location-9311/cloudControls/cloudControl-9311";
      client.getCloudControl(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createCloudControlTest() throws Exception {
    CloudControl expectedResponse =
        CloudControl.newBuilder()
            .setName(
                CloudControlName.of("[ORGANIZATION]", "[LOCATION]", "[CLOUD_CONTROL]").toString())
            .setMajorRevisionId(612576889)
            .setDescription("description-1724546052")
            .setDisplayName("displayName1714148973")
            .addAllSupportedEnforcementModes(new ArrayList<EnforcementMode>())
            .addAllParameterSpec(new ArrayList<ParameterSpec>())
            .addAllRules(new ArrayList<Rule>())
            .setSeverity(Severity.forNumber(0))
            .setFindingCategory("findingCategory-1495850073")
            .addAllSupportedCloudProviders(new ArrayList<CloudProvider>())
            .addAllRelatedFrameworks(new ArrayList<String>())
            .setRemediationSteps("remediationSteps1230652930")
            .addAllCategories(new ArrayList<CloudControlCategory>())
            .setCreateTime(Timestamp.newBuilder().build())
            .addAllSupportedTargetResourceTypes(new ArrayList<TargetResourceType>())
            .build();
    mockService.addResponse(expectedResponse);

    OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
    CloudControl cloudControl = CloudControl.newBuilder().build();
    String cloudControlId = "cloudControlId657324195";

    CloudControl actualResponse = client.createCloudControl(parent, cloudControl, cloudControlId);
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
  public void createCloudControlExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
      CloudControl cloudControl = CloudControl.newBuilder().build();
      String cloudControlId = "cloudControlId657324195";
      client.createCloudControl(parent, cloudControl, cloudControlId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createCloudControlTest2() throws Exception {
    CloudControl expectedResponse =
        CloudControl.newBuilder()
            .setName(
                CloudControlName.of("[ORGANIZATION]", "[LOCATION]", "[CLOUD_CONTROL]").toString())
            .setMajorRevisionId(612576889)
            .setDescription("description-1724546052")
            .setDisplayName("displayName1714148973")
            .addAllSupportedEnforcementModes(new ArrayList<EnforcementMode>())
            .addAllParameterSpec(new ArrayList<ParameterSpec>())
            .addAllRules(new ArrayList<Rule>())
            .setSeverity(Severity.forNumber(0))
            .setFindingCategory("findingCategory-1495850073")
            .addAllSupportedCloudProviders(new ArrayList<CloudProvider>())
            .addAllRelatedFrameworks(new ArrayList<String>())
            .setRemediationSteps("remediationSteps1230652930")
            .addAllCategories(new ArrayList<CloudControlCategory>())
            .setCreateTime(Timestamp.newBuilder().build())
            .addAllSupportedTargetResourceTypes(new ArrayList<TargetResourceType>())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "organizations/organization-9365/locations/location-9365";
    CloudControl cloudControl = CloudControl.newBuilder().build();
    String cloudControlId = "cloudControlId657324195";

    CloudControl actualResponse = client.createCloudControl(parent, cloudControl, cloudControlId);
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
  public void createCloudControlExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "organizations/organization-9365/locations/location-9365";
      CloudControl cloudControl = CloudControl.newBuilder().build();
      String cloudControlId = "cloudControlId657324195";
      client.createCloudControl(parent, cloudControl, cloudControlId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateCloudControlTest() throws Exception {
    CloudControl expectedResponse =
        CloudControl.newBuilder()
            .setName(
                CloudControlName.of("[ORGANIZATION]", "[LOCATION]", "[CLOUD_CONTROL]").toString())
            .setMajorRevisionId(612576889)
            .setDescription("description-1724546052")
            .setDisplayName("displayName1714148973")
            .addAllSupportedEnforcementModes(new ArrayList<EnforcementMode>())
            .addAllParameterSpec(new ArrayList<ParameterSpec>())
            .addAllRules(new ArrayList<Rule>())
            .setSeverity(Severity.forNumber(0))
            .setFindingCategory("findingCategory-1495850073")
            .addAllSupportedCloudProviders(new ArrayList<CloudProvider>())
            .addAllRelatedFrameworks(new ArrayList<String>())
            .setRemediationSteps("remediationSteps1230652930")
            .addAllCategories(new ArrayList<CloudControlCategory>())
            .setCreateTime(Timestamp.newBuilder().build())
            .addAllSupportedTargetResourceTypes(new ArrayList<TargetResourceType>())
            .build();
    mockService.addResponse(expectedResponse);

    CloudControl cloudControl =
        CloudControl.newBuilder()
            .setName(
                CloudControlName.of("[ORGANIZATION]", "[LOCATION]", "[CLOUD_CONTROL]").toString())
            .setMajorRevisionId(612576889)
            .setDescription("description-1724546052")
            .setDisplayName("displayName1714148973")
            .addAllSupportedEnforcementModes(new ArrayList<EnforcementMode>())
            .addAllParameterSpec(new ArrayList<ParameterSpec>())
            .addAllRules(new ArrayList<Rule>())
            .setSeverity(Severity.forNumber(0))
            .setFindingCategory("findingCategory-1495850073")
            .addAllSupportedCloudProviders(new ArrayList<CloudProvider>())
            .addAllRelatedFrameworks(new ArrayList<String>())
            .setRemediationSteps("remediationSteps1230652930")
            .addAllCategories(new ArrayList<CloudControlCategory>())
            .setCreateTime(Timestamp.newBuilder().build())
            .addAllSupportedTargetResourceTypes(new ArrayList<TargetResourceType>())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    CloudControl actualResponse = client.updateCloudControl(cloudControl, updateMask);
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
  public void updateCloudControlExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CloudControl cloudControl =
          CloudControl.newBuilder()
              .setName(
                  CloudControlName.of("[ORGANIZATION]", "[LOCATION]", "[CLOUD_CONTROL]").toString())
              .setMajorRevisionId(612576889)
              .setDescription("description-1724546052")
              .setDisplayName("displayName1714148973")
              .addAllSupportedEnforcementModes(new ArrayList<EnforcementMode>())
              .addAllParameterSpec(new ArrayList<ParameterSpec>())
              .addAllRules(new ArrayList<Rule>())
              .setSeverity(Severity.forNumber(0))
              .setFindingCategory("findingCategory-1495850073")
              .addAllSupportedCloudProviders(new ArrayList<CloudProvider>())
              .addAllRelatedFrameworks(new ArrayList<String>())
              .setRemediationSteps("remediationSteps1230652930")
              .addAllCategories(new ArrayList<CloudControlCategory>())
              .setCreateTime(Timestamp.newBuilder().build())
              .addAllSupportedTargetResourceTypes(new ArrayList<TargetResourceType>())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateCloudControl(cloudControl, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteCloudControlTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    CloudControlName name = CloudControlName.of("[ORGANIZATION]", "[LOCATION]", "[CLOUD_CONTROL]");

    client.deleteCloudControl(name);

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
  public void deleteCloudControlExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CloudControlName name =
          CloudControlName.of("[ORGANIZATION]", "[LOCATION]", "[CLOUD_CONTROL]");
      client.deleteCloudControl(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteCloudControlTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name =
        "organizations/organization-9311/locations/location-9311/cloudControls/cloudControl-9311";

    client.deleteCloudControl(name);

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
  public void deleteCloudControlExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "organizations/organization-9311/locations/location-9311/cloudControls/cloudControl-9311";
      client.deleteCloudControl(name);
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
