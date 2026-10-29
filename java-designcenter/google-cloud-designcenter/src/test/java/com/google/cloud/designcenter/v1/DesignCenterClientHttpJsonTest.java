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

package com.google.cloud.designcenter.v1;

import static com.google.cloud.designcenter.v1.DesignCenterClient.FetchFrameworksPagedResponse;
import static com.google.cloud.designcenter.v1.DesignCenterClient.ListApplicationTemplateRevisionsPagedResponse;
import static com.google.cloud.designcenter.v1.DesignCenterClient.ListApplicationTemplateSystemRevisionsPagedResponse;
import static com.google.cloud.designcenter.v1.DesignCenterClient.ListApplicationTemplatesPagedResponse;
import static com.google.cloud.designcenter.v1.DesignCenterClient.ListApplicationsPagedResponse;
import static com.google.cloud.designcenter.v1.DesignCenterClient.ListCatalogTemplateRevisionsPagedResponse;
import static com.google.cloud.designcenter.v1.DesignCenterClient.ListCatalogTemplatesPagedResponse;
import static com.google.cloud.designcenter.v1.DesignCenterClient.ListCatalogsPagedResponse;
import static com.google.cloud.designcenter.v1.DesignCenterClient.ListComponentsPagedResponse;
import static com.google.cloud.designcenter.v1.DesignCenterClient.ListConnectionsPagedResponse;
import static com.google.cloud.designcenter.v1.DesignCenterClient.ListLocationsPagedResponse;
import static com.google.cloud.designcenter.v1.DesignCenterClient.ListPoliciesPagedResponse;
import static com.google.cloud.designcenter.v1.DesignCenterClient.ListSharedTemplateRevisionsPagedResponse;
import static com.google.cloud.designcenter.v1.DesignCenterClient.ListSharedTemplatesPagedResponse;
import static com.google.cloud.designcenter.v1.DesignCenterClient.ListSharesPagedResponse;
import static com.google.cloud.designcenter.v1.DesignCenterClient.ListSpacesPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.apphub.v1.Attributes;
import com.google.cloud.apphub.v1.Scope;
import com.google.cloud.config.v1.Deployment;
import com.google.cloud.config.v1.DeploymentGroup;
import com.google.cloud.config.v1.Preview;
import com.google.cloud.designcenter.v1.stub.HttpJsonDesignCenterStub;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
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
public class DesignCenterClientHttpJsonTest {
  private static MockHttpService mockService;
  private static DesignCenterClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonDesignCenterStub.getMethodDescriptors(),
            DesignCenterSettings.getDefaultEndpoint());
    DesignCenterSettings settings =
        DesignCenterSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                DesignCenterSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = DesignCenterClient.create(settings);
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
  public void getSpaceTest() throws Exception {
    Space expectedResponse =
        Space.newBuilder()
            .setName(SpaceName.of("[PROJECT]", "[LOCATION]", "[SPACE]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEnableGcpSharedTemplates(true)
            .setGcsBucket("gcsBucket239654881")
            .putAllTags(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    SpaceName name = SpaceName.of("[PROJECT]", "[LOCATION]", "[SPACE]");

    Space actualResponse = client.getSpace(name);
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
  public void getSpaceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SpaceName name = SpaceName.of("[PROJECT]", "[LOCATION]", "[SPACE]");
      client.getSpace(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSpaceTest2() throws Exception {
    Space expectedResponse =
        Space.newBuilder()
            .setName(SpaceName.of("[PROJECT]", "[LOCATION]", "[SPACE]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEnableGcpSharedTemplates(true)
            .setGcsBucket("gcsBucket239654881")
            .putAllTags(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-1635/locations/location-1635/spaces/space-1635";

    Space actualResponse = client.getSpace(name);
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
  public void getSpaceExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-1635/locations/location-1635/spaces/space-1635";
      client.getSpace(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSpacesTest() throws Exception {
    Space responsesElement = Space.newBuilder().build();
    ListSpacesResponse expectedResponse =
        ListSpacesResponse.newBuilder()
            .setNextPageToken("")
            .addAllSpaces(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListSpacesPagedResponse pagedListResponse = client.listSpaces(parent);

    List<Space> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSpacesList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listSpacesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listSpaces(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSpacesTest2() throws Exception {
    Space responsesElement = Space.newBuilder().build();
    ListSpacesResponse expectedResponse =
        ListSpacesResponse.newBuilder()
            .setNextPageToken("")
            .addAllSpaces(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListSpacesPagedResponse pagedListResponse = client.listSpaces(parent);

    List<Space> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSpacesList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listSpacesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listSpaces(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createSpaceTest() throws Exception {
    Space expectedResponse =
        Space.newBuilder()
            .setName(SpaceName.of("[PROJECT]", "[LOCATION]", "[SPACE]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEnableGcpSharedTemplates(true)
            .setGcsBucket("gcsBucket239654881")
            .putAllTags(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Space space = Space.newBuilder().build();
    String spaceId = "spaceId-2012163903";

    Space actualResponse = client.createSpace(parent, space, spaceId);
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
  public void createSpaceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Space space = Space.newBuilder().build();
      String spaceId = "spaceId-2012163903";
      client.createSpace(parent, space, spaceId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createSpaceTest2() throws Exception {
    Space expectedResponse =
        Space.newBuilder()
            .setName(SpaceName.of("[PROJECT]", "[LOCATION]", "[SPACE]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEnableGcpSharedTemplates(true)
            .setGcsBucket("gcsBucket239654881")
            .putAllTags(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";
    Space space = Space.newBuilder().build();
    String spaceId = "spaceId-2012163903";

    Space actualResponse = client.createSpace(parent, space, spaceId);
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
  public void createSpaceExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      Space space = Space.newBuilder().build();
      String spaceId = "spaceId-2012163903";
      client.createSpace(parent, space, spaceId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateSpaceTest() throws Exception {
    Space expectedResponse =
        Space.newBuilder()
            .setName(SpaceName.of("[PROJECT]", "[LOCATION]", "[SPACE]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEnableGcpSharedTemplates(true)
            .setGcsBucket("gcsBucket239654881")
            .putAllTags(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    Space space =
        Space.newBuilder()
            .setName(SpaceName.of("[PROJECT]", "[LOCATION]", "[SPACE]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEnableGcpSharedTemplates(true)
            .setGcsBucket("gcsBucket239654881")
            .putAllTags(new HashMap<String, String>())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Space actualResponse = client.updateSpace(space, updateMask);
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
  public void updateSpaceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Space space =
          Space.newBuilder()
              .setName(SpaceName.of("[PROJECT]", "[LOCATION]", "[SPACE]").toString())
              .setDisplayName("displayName1714148973")
              .setDescription("description-1724546052")
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .setEnableGcpSharedTemplates(true)
              .setGcsBucket("gcsBucket239654881")
              .putAllTags(new HashMap<String, String>())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateSpace(space, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteSpaceTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    SpaceName name = SpaceName.of("[PROJECT]", "[LOCATION]", "[SPACE]");

    client.deleteSpace(name);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteSpaceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SpaceName name = SpaceName.of("[PROJECT]", "[LOCATION]", "[SPACE]");
      client.deleteSpace(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteSpaceTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-1635/locations/location-1635/spaces/space-1635";

    client.deleteSpace(name);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteSpaceExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-1635/locations/location-1635/spaces/space-1635";
      client.deleteSpace(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getApplicationTemplateTest() throws Exception {
    ApplicationTemplate expectedResponse =
        ApplicationTemplate.newBuilder()
            .setName(
                ApplicationTemplateName.of(
                        "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllApplicationParameters(new ArrayList<Parameter>())
            .setSerializedApplicationTemplate(SerializedApplicationTemplate.newBuilder().build())
            .setLatestRevision("latestRevision-1002490750")
            .setArtifactLocation(ArtifactLocation.newBuilder().build())
            .setCompositionType(ApplicationCompositionType.forNumber(0))
            .addAllRootInputVariables(new ArrayList<ComponentVariable>())
            .addAllRootOutputVariables(new ArrayList<ComponentVariable>())
            .setSaasRuntimeContext(SaaSRuntimeContext.newBuilder().build())
            .setLatestSystemRevisionUri(
                ApplicationTemplateSystemRevisionName.of(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[SPACE]",
                        "[APPLICATION_TEMPLATE]",
                        "[SYSTEM_REVISION]")
                    .toString())
            .setIacSource(IACSource.forNumber(0))
            .setTemplateMetadata(TFBlueprintMetadata.newBuilder().build())
            .setInputsAsRootModuleVariables(true)
            .build();
    mockService.addResponse(expectedResponse);

    ApplicationTemplateName name =
        ApplicationTemplateName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]");

    ApplicationTemplate actualResponse = client.getApplicationTemplate(name);
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
  public void getApplicationTemplateExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ApplicationTemplateName name =
          ApplicationTemplateName.of(
              "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]");
      client.getApplicationTemplate(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getApplicationTemplateTest2() throws Exception {
    ApplicationTemplate expectedResponse =
        ApplicationTemplate.newBuilder()
            .setName(
                ApplicationTemplateName.of(
                        "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllApplicationParameters(new ArrayList<Parameter>())
            .setSerializedApplicationTemplate(SerializedApplicationTemplate.newBuilder().build())
            .setLatestRevision("latestRevision-1002490750")
            .setArtifactLocation(ArtifactLocation.newBuilder().build())
            .setCompositionType(ApplicationCompositionType.forNumber(0))
            .addAllRootInputVariables(new ArrayList<ComponentVariable>())
            .addAllRootOutputVariables(new ArrayList<ComponentVariable>())
            .setSaasRuntimeContext(SaaSRuntimeContext.newBuilder().build())
            .setLatestSystemRevisionUri(
                ApplicationTemplateSystemRevisionName.of(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[SPACE]",
                        "[APPLICATION_TEMPLATE]",
                        "[SYSTEM_REVISION]")
                    .toString())
            .setIacSource(IACSource.forNumber(0))
            .setTemplateMetadata(TFBlueprintMetadata.newBuilder().build())
            .setInputsAsRootModuleVariables(true)
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-2810/locations/location-2810/spaces/space-2810/applicationTemplates/applicationTemplate-2810";

    ApplicationTemplate actualResponse = client.getApplicationTemplate(name);
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
  public void getApplicationTemplateExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-2810/locations/location-2810/spaces/space-2810/applicationTemplates/applicationTemplate-2810";
      client.getApplicationTemplate(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listApplicationTemplatesTest() throws Exception {
    ApplicationTemplate responsesElement = ApplicationTemplate.newBuilder().build();
    ListApplicationTemplatesResponse expectedResponse =
        ListApplicationTemplatesResponse.newBuilder()
            .setNextPageToken("")
            .addAllApplicationTemplates(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    SpaceName parent = SpaceName.of("[PROJECT]", "[LOCATION]", "[SPACE]");

    ListApplicationTemplatesPagedResponse pagedListResponse =
        client.listApplicationTemplates(parent);

    List<ApplicationTemplate> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getApplicationTemplatesList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listApplicationTemplatesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SpaceName parent = SpaceName.of("[PROJECT]", "[LOCATION]", "[SPACE]");
      client.listApplicationTemplates(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listApplicationTemplatesTest2() throws Exception {
    ApplicationTemplate responsesElement = ApplicationTemplate.newBuilder().build();
    ListApplicationTemplatesResponse expectedResponse =
        ListApplicationTemplatesResponse.newBuilder()
            .setNextPageToken("")
            .addAllApplicationTemplates(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-2462/locations/location-2462/spaces/space-2462";

    ListApplicationTemplatesPagedResponse pagedListResponse =
        client.listApplicationTemplates(parent);

    List<ApplicationTemplate> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getApplicationTemplatesList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listApplicationTemplatesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-2462/locations/location-2462/spaces/space-2462";
      client.listApplicationTemplates(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createApplicationTemplateTest() throws Exception {
    ApplicationTemplate expectedResponse =
        ApplicationTemplate.newBuilder()
            .setName(
                ApplicationTemplateName.of(
                        "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllApplicationParameters(new ArrayList<Parameter>())
            .setSerializedApplicationTemplate(SerializedApplicationTemplate.newBuilder().build())
            .setLatestRevision("latestRevision-1002490750")
            .setArtifactLocation(ArtifactLocation.newBuilder().build())
            .setCompositionType(ApplicationCompositionType.forNumber(0))
            .addAllRootInputVariables(new ArrayList<ComponentVariable>())
            .addAllRootOutputVariables(new ArrayList<ComponentVariable>())
            .setSaasRuntimeContext(SaaSRuntimeContext.newBuilder().build())
            .setLatestSystemRevisionUri(
                ApplicationTemplateSystemRevisionName.of(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[SPACE]",
                        "[APPLICATION_TEMPLATE]",
                        "[SYSTEM_REVISION]")
                    .toString())
            .setIacSource(IACSource.forNumber(0))
            .setTemplateMetadata(TFBlueprintMetadata.newBuilder().build())
            .setInputsAsRootModuleVariables(true)
            .build();
    mockService.addResponse(expectedResponse);

    SpaceName parent = SpaceName.of("[PROJECT]", "[LOCATION]", "[SPACE]");
    ApplicationTemplate applicationTemplate = ApplicationTemplate.newBuilder().build();
    String applicationTemplateId = "applicationTemplateId-1557848923";

    ApplicationTemplate actualResponse =
        client.createApplicationTemplate(parent, applicationTemplate, applicationTemplateId);
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
  public void createApplicationTemplateExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SpaceName parent = SpaceName.of("[PROJECT]", "[LOCATION]", "[SPACE]");
      ApplicationTemplate applicationTemplate = ApplicationTemplate.newBuilder().build();
      String applicationTemplateId = "applicationTemplateId-1557848923";
      client.createApplicationTemplate(parent, applicationTemplate, applicationTemplateId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createApplicationTemplateTest2() throws Exception {
    ApplicationTemplate expectedResponse =
        ApplicationTemplate.newBuilder()
            .setName(
                ApplicationTemplateName.of(
                        "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllApplicationParameters(new ArrayList<Parameter>())
            .setSerializedApplicationTemplate(SerializedApplicationTemplate.newBuilder().build())
            .setLatestRevision("latestRevision-1002490750")
            .setArtifactLocation(ArtifactLocation.newBuilder().build())
            .setCompositionType(ApplicationCompositionType.forNumber(0))
            .addAllRootInputVariables(new ArrayList<ComponentVariable>())
            .addAllRootOutputVariables(new ArrayList<ComponentVariable>())
            .setSaasRuntimeContext(SaaSRuntimeContext.newBuilder().build())
            .setLatestSystemRevisionUri(
                ApplicationTemplateSystemRevisionName.of(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[SPACE]",
                        "[APPLICATION_TEMPLATE]",
                        "[SYSTEM_REVISION]")
                    .toString())
            .setIacSource(IACSource.forNumber(0))
            .setTemplateMetadata(TFBlueprintMetadata.newBuilder().build())
            .setInputsAsRootModuleVariables(true)
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-2462/locations/location-2462/spaces/space-2462";
    ApplicationTemplate applicationTemplate = ApplicationTemplate.newBuilder().build();
    String applicationTemplateId = "applicationTemplateId-1557848923";

    ApplicationTemplate actualResponse =
        client.createApplicationTemplate(parent, applicationTemplate, applicationTemplateId);
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
  public void createApplicationTemplateExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-2462/locations/location-2462/spaces/space-2462";
      ApplicationTemplate applicationTemplate = ApplicationTemplate.newBuilder().build();
      String applicationTemplateId = "applicationTemplateId-1557848923";
      client.createApplicationTemplate(parent, applicationTemplate, applicationTemplateId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateApplicationTemplateTest() throws Exception {
    ApplicationTemplate expectedResponse =
        ApplicationTemplate.newBuilder()
            .setName(
                ApplicationTemplateName.of(
                        "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllApplicationParameters(new ArrayList<Parameter>())
            .setSerializedApplicationTemplate(SerializedApplicationTemplate.newBuilder().build())
            .setLatestRevision("latestRevision-1002490750")
            .setArtifactLocation(ArtifactLocation.newBuilder().build())
            .setCompositionType(ApplicationCompositionType.forNumber(0))
            .addAllRootInputVariables(new ArrayList<ComponentVariable>())
            .addAllRootOutputVariables(new ArrayList<ComponentVariable>())
            .setSaasRuntimeContext(SaaSRuntimeContext.newBuilder().build())
            .setLatestSystemRevisionUri(
                ApplicationTemplateSystemRevisionName.of(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[SPACE]",
                        "[APPLICATION_TEMPLATE]",
                        "[SYSTEM_REVISION]")
                    .toString())
            .setIacSource(IACSource.forNumber(0))
            .setTemplateMetadata(TFBlueprintMetadata.newBuilder().build())
            .setInputsAsRootModuleVariables(true)
            .build();
    mockService.addResponse(expectedResponse);

    ApplicationTemplate applicationTemplate =
        ApplicationTemplate.newBuilder()
            .setName(
                ApplicationTemplateName.of(
                        "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllApplicationParameters(new ArrayList<Parameter>())
            .setSerializedApplicationTemplate(SerializedApplicationTemplate.newBuilder().build())
            .setLatestRevision("latestRevision-1002490750")
            .setArtifactLocation(ArtifactLocation.newBuilder().build())
            .setCompositionType(ApplicationCompositionType.forNumber(0))
            .addAllRootInputVariables(new ArrayList<ComponentVariable>())
            .addAllRootOutputVariables(new ArrayList<ComponentVariable>())
            .setSaasRuntimeContext(SaaSRuntimeContext.newBuilder().build())
            .setLatestSystemRevisionUri(
                ApplicationTemplateSystemRevisionName.of(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[SPACE]",
                        "[APPLICATION_TEMPLATE]",
                        "[SYSTEM_REVISION]")
                    .toString())
            .setIacSource(IACSource.forNumber(0))
            .setTemplateMetadata(TFBlueprintMetadata.newBuilder().build())
            .setInputsAsRootModuleVariables(true)
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    ApplicationTemplate actualResponse =
        client.updateApplicationTemplate(applicationTemplate, updateMask);
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
  public void updateApplicationTemplateExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ApplicationTemplate applicationTemplate =
          ApplicationTemplate.newBuilder()
              .setName(
                  ApplicationTemplateName.of(
                          "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]")
                      .toString())
              .setDisplayName("displayName1714148973")
              .setDescription("description-1724546052")
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .addAllApplicationParameters(new ArrayList<Parameter>())
              .setSerializedApplicationTemplate(SerializedApplicationTemplate.newBuilder().build())
              .setLatestRevision("latestRevision-1002490750")
              .setArtifactLocation(ArtifactLocation.newBuilder().build())
              .setCompositionType(ApplicationCompositionType.forNumber(0))
              .addAllRootInputVariables(new ArrayList<ComponentVariable>())
              .addAllRootOutputVariables(new ArrayList<ComponentVariable>())
              .setSaasRuntimeContext(SaaSRuntimeContext.newBuilder().build())
              .setLatestSystemRevisionUri(
                  ApplicationTemplateSystemRevisionName.of(
                          "[PROJECT]",
                          "[LOCATION]",
                          "[SPACE]",
                          "[APPLICATION_TEMPLATE]",
                          "[SYSTEM_REVISION]")
                      .toString())
              .setIacSource(IACSource.forNumber(0))
              .setTemplateMetadata(TFBlueprintMetadata.newBuilder().build())
              .setInputsAsRootModuleVariables(true)
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateApplicationTemplate(applicationTemplate, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void importApplicationTemplateTest() throws Exception {
    ApplicationTemplate expectedResponse =
        ApplicationTemplate.newBuilder()
            .setName(
                ApplicationTemplateName.of(
                        "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllApplicationParameters(new ArrayList<Parameter>())
            .setSerializedApplicationTemplate(SerializedApplicationTemplate.newBuilder().build())
            .setLatestRevision("latestRevision-1002490750")
            .setArtifactLocation(ArtifactLocation.newBuilder().build())
            .setCompositionType(ApplicationCompositionType.forNumber(0))
            .addAllRootInputVariables(new ArrayList<ComponentVariable>())
            .addAllRootOutputVariables(new ArrayList<ComponentVariable>())
            .setSaasRuntimeContext(SaaSRuntimeContext.newBuilder().build())
            .setLatestSystemRevisionUri(
                ApplicationTemplateSystemRevisionName.of(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[SPACE]",
                        "[APPLICATION_TEMPLATE]",
                        "[SYSTEM_REVISION]")
                    .toString())
            .setIacSource(IACSource.forNumber(0))
            .setTemplateMetadata(TFBlueprintMetadata.newBuilder().build())
            .setInputsAsRootModuleVariables(true)
            .build();
    mockService.addResponse(expectedResponse);

    ApplicationTemplateName name =
        ApplicationTemplateName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]");
    ApplicationTemplateRevisionName applicationTemplateRevisionUri =
        ApplicationTemplateRevisionName.of(
            "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]", "[REVISION]");

    ApplicationTemplate actualResponse =
        client.importApplicationTemplate(name, applicationTemplateRevisionUri);
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
  public void importApplicationTemplateExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ApplicationTemplateName name =
          ApplicationTemplateName.of(
              "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]");
      ApplicationTemplateRevisionName applicationTemplateRevisionUri =
          ApplicationTemplateRevisionName.of(
              "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]", "[REVISION]");
      client.importApplicationTemplate(name, applicationTemplateRevisionUri);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void importApplicationTemplateTest2() throws Exception {
    ApplicationTemplate expectedResponse =
        ApplicationTemplate.newBuilder()
            .setName(
                ApplicationTemplateName.of(
                        "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllApplicationParameters(new ArrayList<Parameter>())
            .setSerializedApplicationTemplate(SerializedApplicationTemplate.newBuilder().build())
            .setLatestRevision("latestRevision-1002490750")
            .setArtifactLocation(ArtifactLocation.newBuilder().build())
            .setCompositionType(ApplicationCompositionType.forNumber(0))
            .addAllRootInputVariables(new ArrayList<ComponentVariable>())
            .addAllRootOutputVariables(new ArrayList<ComponentVariable>())
            .setSaasRuntimeContext(SaaSRuntimeContext.newBuilder().build())
            .setLatestSystemRevisionUri(
                ApplicationTemplateSystemRevisionName.of(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[SPACE]",
                        "[APPLICATION_TEMPLATE]",
                        "[SYSTEM_REVISION]")
                    .toString())
            .setIacSource(IACSource.forNumber(0))
            .setTemplateMetadata(TFBlueprintMetadata.newBuilder().build())
            .setInputsAsRootModuleVariables(true)
            .build();
    mockService.addResponse(expectedResponse);

    ApplicationTemplateName name =
        ApplicationTemplateName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]");
    String applicationTemplateRevisionUri = "applicationTemplateRevisionUri844336967";

    ApplicationTemplate actualResponse =
        client.importApplicationTemplate(name, applicationTemplateRevisionUri);
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
  public void importApplicationTemplateExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ApplicationTemplateName name =
          ApplicationTemplateName.of(
              "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]");
      String applicationTemplateRevisionUri = "applicationTemplateRevisionUri844336967";
      client.importApplicationTemplate(name, applicationTemplateRevisionUri);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void importApplicationTemplateTest3() throws Exception {
    ApplicationTemplate expectedResponse =
        ApplicationTemplate.newBuilder()
            .setName(
                ApplicationTemplateName.of(
                        "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllApplicationParameters(new ArrayList<Parameter>())
            .setSerializedApplicationTemplate(SerializedApplicationTemplate.newBuilder().build())
            .setLatestRevision("latestRevision-1002490750")
            .setArtifactLocation(ArtifactLocation.newBuilder().build())
            .setCompositionType(ApplicationCompositionType.forNumber(0))
            .addAllRootInputVariables(new ArrayList<ComponentVariable>())
            .addAllRootOutputVariables(new ArrayList<ComponentVariable>())
            .setSaasRuntimeContext(SaaSRuntimeContext.newBuilder().build())
            .setLatestSystemRevisionUri(
                ApplicationTemplateSystemRevisionName.of(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[SPACE]",
                        "[APPLICATION_TEMPLATE]",
                        "[SYSTEM_REVISION]")
                    .toString())
            .setIacSource(IACSource.forNumber(0))
            .setTemplateMetadata(TFBlueprintMetadata.newBuilder().build())
            .setInputsAsRootModuleVariables(true)
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-2810/locations/location-2810/spaces/space-2810/applicationTemplates/applicationTemplate-2810";
    ApplicationTemplateRevisionName applicationTemplateRevisionUri =
        ApplicationTemplateRevisionName.of(
            "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]", "[REVISION]");

    ApplicationTemplate actualResponse =
        client.importApplicationTemplate(name, applicationTemplateRevisionUri);
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
  public void importApplicationTemplateExceptionTest3() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-2810/locations/location-2810/spaces/space-2810/applicationTemplates/applicationTemplate-2810";
      ApplicationTemplateRevisionName applicationTemplateRevisionUri =
          ApplicationTemplateRevisionName.of(
              "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]", "[REVISION]");
      client.importApplicationTemplate(name, applicationTemplateRevisionUri);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void importApplicationTemplateTest4() throws Exception {
    ApplicationTemplate expectedResponse =
        ApplicationTemplate.newBuilder()
            .setName(
                ApplicationTemplateName.of(
                        "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllApplicationParameters(new ArrayList<Parameter>())
            .setSerializedApplicationTemplate(SerializedApplicationTemplate.newBuilder().build())
            .setLatestRevision("latestRevision-1002490750")
            .setArtifactLocation(ArtifactLocation.newBuilder().build())
            .setCompositionType(ApplicationCompositionType.forNumber(0))
            .addAllRootInputVariables(new ArrayList<ComponentVariable>())
            .addAllRootOutputVariables(new ArrayList<ComponentVariable>())
            .setSaasRuntimeContext(SaaSRuntimeContext.newBuilder().build())
            .setLatestSystemRevisionUri(
                ApplicationTemplateSystemRevisionName.of(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[SPACE]",
                        "[APPLICATION_TEMPLATE]",
                        "[SYSTEM_REVISION]")
                    .toString())
            .setIacSource(IACSource.forNumber(0))
            .setTemplateMetadata(TFBlueprintMetadata.newBuilder().build())
            .setInputsAsRootModuleVariables(true)
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-2810/locations/location-2810/spaces/space-2810/applicationTemplates/applicationTemplate-2810";
    String applicationTemplateRevisionUri = "applicationTemplateRevisionUri844336967";

    ApplicationTemplate actualResponse =
        client.importApplicationTemplate(name, applicationTemplateRevisionUri);
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
  public void importApplicationTemplateExceptionTest4() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-2810/locations/location-2810/spaces/space-2810/applicationTemplates/applicationTemplate-2810";
      String applicationTemplateRevisionUri = "applicationTemplateRevisionUri844336967";
      client.importApplicationTemplate(name, applicationTemplateRevisionUri);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteApplicationTemplateTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    ApplicationTemplateName name =
        ApplicationTemplateName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]");

    client.deleteApplicationTemplate(name);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteApplicationTemplateExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ApplicationTemplateName name =
          ApplicationTemplateName.of(
              "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]");
      client.deleteApplicationTemplate(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteApplicationTemplateTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-2810/locations/location-2810/spaces/space-2810/applicationTemplates/applicationTemplate-2810";

    client.deleteApplicationTemplate(name);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteApplicationTemplateExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-2810/locations/location-2810/spaces/space-2810/applicationTemplates/applicationTemplate-2810";
      client.deleteApplicationTemplate(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void commitApplicationTemplateTest() throws Exception {
    ApplicationTemplateRevision expectedResponse =
        ApplicationTemplateRevision.newBuilder()
            .setName(
                ApplicationTemplateRevisionName.of(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[SPACE]",
                        "[APPLICATION_TEMPLATE]",
                        "[REVISION]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setSnapshot(SerializedApplicationTemplate.newBuilder().build())
            .setArtifactLocation(ArtifactLocation.newBuilder().build())
            .setTemplateMetadata(TFBlueprintMetadata.newBuilder().build())
            .addAllApplicationParameters(new ArrayList<Parameter>())
            .setIacSource(IACSource.forNumber(0))
            .build();
    mockService.addResponse(expectedResponse);

    ApplicationTemplateName name =
        ApplicationTemplateName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]");

    ApplicationTemplateRevision actualResponse = client.commitApplicationTemplate(name);
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
  public void commitApplicationTemplateExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ApplicationTemplateName name =
          ApplicationTemplateName.of(
              "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]");
      client.commitApplicationTemplate(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void commitApplicationTemplateTest2() throws Exception {
    ApplicationTemplateRevision expectedResponse =
        ApplicationTemplateRevision.newBuilder()
            .setName(
                ApplicationTemplateRevisionName.of(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[SPACE]",
                        "[APPLICATION_TEMPLATE]",
                        "[REVISION]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setSnapshot(SerializedApplicationTemplate.newBuilder().build())
            .setArtifactLocation(ArtifactLocation.newBuilder().build())
            .setTemplateMetadata(TFBlueprintMetadata.newBuilder().build())
            .addAllApplicationParameters(new ArrayList<Parameter>())
            .setIacSource(IACSource.forNumber(0))
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-2810/locations/location-2810/spaces/space-2810/applicationTemplates/applicationTemplate-2810";

    ApplicationTemplateRevision actualResponse = client.commitApplicationTemplate(name);
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
  public void commitApplicationTemplateExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-2810/locations/location-2810/spaces/space-2810/applicationTemplates/applicationTemplate-2810";
      client.commitApplicationTemplate(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void snapshotApplicationTemplateTest() throws Exception {
    SnapshotApplicationTemplateResponse expectedResponse =
        SnapshotApplicationTemplateResponse.newBuilder()
            .setApplicationTemplateRevision(ApplicationTemplateRevision.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("snapshotApplicationTemplateTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    ApplicationTemplateName name =
        ApplicationTemplateName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]");

    SnapshotApplicationTemplateResponse actualResponse =
        client.snapshotApplicationTemplateAsync(name).get();
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
  public void snapshotApplicationTemplateExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ApplicationTemplateName name =
          ApplicationTemplateName.of(
              "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]");
      client.snapshotApplicationTemplateAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void snapshotApplicationTemplateTest2() throws Exception {
    SnapshotApplicationTemplateResponse expectedResponse =
        SnapshotApplicationTemplateResponse.newBuilder()
            .setApplicationTemplateRevision(ApplicationTemplateRevision.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("snapshotApplicationTemplateTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name =
        "projects/project-2810/locations/location-2810/spaces/space-2810/applicationTemplates/applicationTemplate-2810";

    SnapshotApplicationTemplateResponse actualResponse =
        client.snapshotApplicationTemplateAsync(name).get();
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
  public void snapshotApplicationTemplateExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-2810/locations/location-2810/spaces/space-2810/applicationTemplates/applicationTemplate-2810";
      client.snapshotApplicationTemplateAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void generateApplicationTemplateIaCTest() throws Exception {
    GenerateApplicationTemplateIaCResponse expectedResponse =
        GenerateApplicationTemplateIaCResponse.newBuilder()
            .setGcsUri("gcsUri-1251224875")
            .setArtifactLocation(ArtifactLocation.newBuilder().build())
            .setRootModulesMetadata(RootModulesMetadata.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    ApplicationTemplateName name =
        ApplicationTemplateName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]");

    GenerateApplicationTemplateIaCResponse actualResponse =
        client.generateApplicationTemplateIaC(name);
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
  public void generateApplicationTemplateIaCExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ApplicationTemplateName name =
          ApplicationTemplateName.of(
              "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]");
      client.generateApplicationTemplateIaC(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void generateApplicationTemplateIaCTest2() throws Exception {
    GenerateApplicationTemplateIaCResponse expectedResponse =
        GenerateApplicationTemplateIaCResponse.newBuilder()
            .setGcsUri("gcsUri-1251224875")
            .setArtifactLocation(ArtifactLocation.newBuilder().build())
            .setRootModulesMetadata(RootModulesMetadata.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-2810/locations/location-2810/spaces/space-2810/applicationTemplates/applicationTemplate-2810";

    GenerateApplicationTemplateIaCResponse actualResponse =
        client.generateApplicationTemplateIaC(name);
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
  public void generateApplicationTemplateIaCExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-2810/locations/location-2810/spaces/space-2810/applicationTemplates/applicationTemplate-2810";
      client.generateApplicationTemplateIaC(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void exportApplicationTemplateIaCTest() throws Exception {
    ExportApplicationTemplateIaCResponse expectedResponse =
        ExportApplicationTemplateIaCResponse.newBuilder()
            .setArtifactLocation(ArtifactLocation.newBuilder().build())
            .setRootModulesMetadata(RootModulesMetadata.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("exportApplicationTemplateIaCTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    ApplicationTemplateName name =
        ApplicationTemplateName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]");

    ExportApplicationTemplateIaCResponse actualResponse =
        client.exportApplicationTemplateIaCAsync(name).get();
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
  public void exportApplicationTemplateIaCExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ApplicationTemplateName name =
          ApplicationTemplateName.of(
              "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]");
      client.exportApplicationTemplateIaCAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void exportApplicationTemplateIaCTest2() throws Exception {
    ExportApplicationTemplateIaCResponse expectedResponse =
        ExportApplicationTemplateIaCResponse.newBuilder()
            .setArtifactLocation(ArtifactLocation.newBuilder().build())
            .setRootModulesMetadata(RootModulesMetadata.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("exportApplicationTemplateIaCTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name =
        "projects/project-2810/locations/location-2810/spaces/space-2810/applicationTemplates/applicationTemplate-2810";

    ExportApplicationTemplateIaCResponse actualResponse =
        client.exportApplicationTemplateIaCAsync(name).get();
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
  public void exportApplicationTemplateIaCExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-2810/locations/location-2810/spaces/space-2810/applicationTemplates/applicationTemplate-2810";
      client.exportApplicationTemplateIaCAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void generateApplicationTemplateRevisionIaCTest() throws Exception {
    GenerateApplicationTemplateRevisionIaCResponse expectedResponse =
        GenerateApplicationTemplateRevisionIaCResponse.newBuilder()
            .setArtifactLocation(ArtifactLocation.newBuilder().build())
            .setRootModulesMetadata(RootModulesMetadata.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    ApplicationTemplateRevisionName name =
        ApplicationTemplateRevisionName.of(
            "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]", "[REVISION]");

    GenerateApplicationTemplateRevisionIaCResponse actualResponse =
        client.generateApplicationTemplateRevisionIaC(name);
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
  public void generateApplicationTemplateRevisionIaCExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ApplicationTemplateRevisionName name =
          ApplicationTemplateRevisionName.of(
              "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]", "[REVISION]");
      client.generateApplicationTemplateRevisionIaC(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void generateApplicationTemplateRevisionIaCTest2() throws Exception {
    GenerateApplicationTemplateRevisionIaCResponse expectedResponse =
        GenerateApplicationTemplateRevisionIaCResponse.newBuilder()
            .setArtifactLocation(ArtifactLocation.newBuilder().build())
            .setRootModulesMetadata(RootModulesMetadata.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-8918/locations/location-8918/spaces/space-8918/applicationTemplates/applicationTemplate-8918/revisions/revision-8918";

    GenerateApplicationTemplateRevisionIaCResponse actualResponse =
        client.generateApplicationTemplateRevisionIaC(name);
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
  public void generateApplicationTemplateRevisionIaCExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-8918/locations/location-8918/spaces/space-8918/applicationTemplates/applicationTemplate-8918/revisions/revision-8918";
      client.generateApplicationTemplateRevisionIaC(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void exportApplicationTemplateRevisionIaCTest() throws Exception {
    ExportApplicationTemplateRevisionIaCResponse expectedResponse =
        ExportApplicationTemplateRevisionIaCResponse.newBuilder()
            .setArtifactLocation(ArtifactLocation.newBuilder().build())
            .setRootModulesMetadata(RootModulesMetadata.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("exportApplicationTemplateRevisionIaCTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    ApplicationTemplateRevisionName name =
        ApplicationTemplateRevisionName.of(
            "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]", "[REVISION]");

    ExportApplicationTemplateRevisionIaCResponse actualResponse =
        client.exportApplicationTemplateRevisionIaCAsync(name).get();
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
  public void exportApplicationTemplateRevisionIaCExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ApplicationTemplateRevisionName name =
          ApplicationTemplateRevisionName.of(
              "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]", "[REVISION]");
      client.exportApplicationTemplateRevisionIaCAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void exportApplicationTemplateRevisionIaCTest2() throws Exception {
    ExportApplicationTemplateRevisionIaCResponse expectedResponse =
        ExportApplicationTemplateRevisionIaCResponse.newBuilder()
            .setArtifactLocation(ArtifactLocation.newBuilder().build())
            .setRootModulesMetadata(RootModulesMetadata.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("exportApplicationTemplateRevisionIaCTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name =
        "projects/project-8918/locations/location-8918/spaces/space-8918/applicationTemplates/applicationTemplate-8918/revisions/revision-8918";

    ExportApplicationTemplateRevisionIaCResponse actualResponse =
        client.exportApplicationTemplateRevisionIaCAsync(name).get();
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
  public void exportApplicationTemplateRevisionIaCExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-8918/locations/location-8918/spaces/space-8918/applicationTemplates/applicationTemplate-8918/revisions/revision-8918";
      client.exportApplicationTemplateRevisionIaCAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void getComponentTest() throws Exception {
    Component expectedResponse =
        Component.newBuilder()
            .setName(
                ComponentName.of(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[SPACE]",
                        "[APPLICATION_TEMPLATE]",
                        "[COMPONENT]")
                    .toString())
            .setSharedTemplateRevisionUri("sharedTemplateRevisionUri1743920658")
            .addAllParameters(new ArrayList<Parameter>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllRoles(new ArrayList<String>())
            .addAllApis(new ArrayList<String>())
            .setDisplayName("displayName1714148973")
            .addAllConnectionsParameters(new ArrayList<ConnectionParameters>())
            .addAllComponentParameterSchema(new ArrayList<ComponentParameterSchema>())
            .setApplicationInfo(ComponentApplicationInfo.newBuilder().build())
            .setUseAsRootModule(true)
            .addAllInputVariableAliases(new ArrayList<InputVariableAlias>())
            .setApplicationTemplateRevisionUri("applicationTemplateRevisionUri844336967")
            .build();
    mockService.addResponse(expectedResponse);

    ComponentName name =
        ComponentName.of(
            "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]", "[COMPONENT]");

    Component actualResponse = client.getComponent(name);
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
  public void getComponentExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ComponentName name =
          ComponentName.of(
              "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]", "[COMPONENT]");
      client.getComponent(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getComponentTest2() throws Exception {
    Component expectedResponse =
        Component.newBuilder()
            .setName(
                ComponentName.of(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[SPACE]",
                        "[APPLICATION_TEMPLATE]",
                        "[COMPONENT]")
                    .toString())
            .setSharedTemplateRevisionUri("sharedTemplateRevisionUri1743920658")
            .addAllParameters(new ArrayList<Parameter>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllRoles(new ArrayList<String>())
            .addAllApis(new ArrayList<String>())
            .setDisplayName("displayName1714148973")
            .addAllConnectionsParameters(new ArrayList<ConnectionParameters>())
            .addAllComponentParameterSchema(new ArrayList<ComponentParameterSchema>())
            .setApplicationInfo(ComponentApplicationInfo.newBuilder().build())
            .setUseAsRootModule(true)
            .addAllInputVariableAliases(new ArrayList<InputVariableAlias>())
            .setApplicationTemplateRevisionUri("applicationTemplateRevisionUri844336967")
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-4394/locations/location-4394/spaces/space-4394/applicationTemplates/applicationTemplate-4394/components/component-4394";

    Component actualResponse = client.getComponent(name);
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
  public void getComponentExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-4394/locations/location-4394/spaces/space-4394/applicationTemplates/applicationTemplate-4394/components/component-4394";
      client.getComponent(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listComponentsTest() throws Exception {
    Component responsesElement = Component.newBuilder().build();
    ListComponentsResponse expectedResponse =
        ListComponentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllComponents(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    ApplicationTemplateName parent =
        ApplicationTemplateName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]");

    ListComponentsPagedResponse pagedListResponse = client.listComponents(parent);

    List<Component> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getComponentsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listComponentsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ApplicationTemplateName parent =
          ApplicationTemplateName.of(
              "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]");
      client.listComponents(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listComponentsTest2() throws Exception {
    Component responsesElement = Component.newBuilder().build();
    ListComponentsResponse expectedResponse =
        ListComponentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllComponents(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent =
        "projects/project-9797/locations/location-9797/spaces/space-9797/applicationTemplates/applicationTemplate-9797";

    ListComponentsPagedResponse pagedListResponse = client.listComponents(parent);

    List<Component> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getComponentsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listComponentsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-9797/locations/location-9797/spaces/space-9797/applicationTemplates/applicationTemplate-9797";
      client.listComponents(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createComponentTest() throws Exception {
    Component expectedResponse =
        Component.newBuilder()
            .setName(
                ComponentName.of(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[SPACE]",
                        "[APPLICATION_TEMPLATE]",
                        "[COMPONENT]")
                    .toString())
            .setSharedTemplateRevisionUri("sharedTemplateRevisionUri1743920658")
            .addAllParameters(new ArrayList<Parameter>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllRoles(new ArrayList<String>())
            .addAllApis(new ArrayList<String>())
            .setDisplayName("displayName1714148973")
            .addAllConnectionsParameters(new ArrayList<ConnectionParameters>())
            .addAllComponentParameterSchema(new ArrayList<ComponentParameterSchema>())
            .setApplicationInfo(ComponentApplicationInfo.newBuilder().build())
            .setUseAsRootModule(true)
            .addAllInputVariableAliases(new ArrayList<InputVariableAlias>())
            .setApplicationTemplateRevisionUri("applicationTemplateRevisionUri844336967")
            .build();
    mockService.addResponse(expectedResponse);

    ApplicationTemplateName parent =
        ApplicationTemplateName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]");
    Component component = Component.newBuilder().build();
    String componentId = "componentId-985933064";

    Component actualResponse = client.createComponent(parent, component, componentId);
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
  public void createComponentExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ApplicationTemplateName parent =
          ApplicationTemplateName.of(
              "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]");
      Component component = Component.newBuilder().build();
      String componentId = "componentId-985933064";
      client.createComponent(parent, component, componentId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createComponentTest2() throws Exception {
    Component expectedResponse =
        Component.newBuilder()
            .setName(
                ComponentName.of(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[SPACE]",
                        "[APPLICATION_TEMPLATE]",
                        "[COMPONENT]")
                    .toString())
            .setSharedTemplateRevisionUri("sharedTemplateRevisionUri1743920658")
            .addAllParameters(new ArrayList<Parameter>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllRoles(new ArrayList<String>())
            .addAllApis(new ArrayList<String>())
            .setDisplayName("displayName1714148973")
            .addAllConnectionsParameters(new ArrayList<ConnectionParameters>())
            .addAllComponentParameterSchema(new ArrayList<ComponentParameterSchema>())
            .setApplicationInfo(ComponentApplicationInfo.newBuilder().build())
            .setUseAsRootModule(true)
            .addAllInputVariableAliases(new ArrayList<InputVariableAlias>())
            .setApplicationTemplateRevisionUri("applicationTemplateRevisionUri844336967")
            .build();
    mockService.addResponse(expectedResponse);

    String parent =
        "projects/project-9797/locations/location-9797/spaces/space-9797/applicationTemplates/applicationTemplate-9797";
    Component component = Component.newBuilder().build();
    String componentId = "componentId-985933064";

    Component actualResponse = client.createComponent(parent, component, componentId);
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
  public void createComponentExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-9797/locations/location-9797/spaces/space-9797/applicationTemplates/applicationTemplate-9797";
      Component component = Component.newBuilder().build();
      String componentId = "componentId-985933064";
      client.createComponent(parent, component, componentId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateComponentTest() throws Exception {
    Component expectedResponse =
        Component.newBuilder()
            .setName(
                ComponentName.of(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[SPACE]",
                        "[APPLICATION_TEMPLATE]",
                        "[COMPONENT]")
                    .toString())
            .setSharedTemplateRevisionUri("sharedTemplateRevisionUri1743920658")
            .addAllParameters(new ArrayList<Parameter>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllRoles(new ArrayList<String>())
            .addAllApis(new ArrayList<String>())
            .setDisplayName("displayName1714148973")
            .addAllConnectionsParameters(new ArrayList<ConnectionParameters>())
            .addAllComponentParameterSchema(new ArrayList<ComponentParameterSchema>())
            .setApplicationInfo(ComponentApplicationInfo.newBuilder().build())
            .setUseAsRootModule(true)
            .addAllInputVariableAliases(new ArrayList<InputVariableAlias>())
            .setApplicationTemplateRevisionUri("applicationTemplateRevisionUri844336967")
            .build();
    mockService.addResponse(expectedResponse);

    Component component =
        Component.newBuilder()
            .setName(
                ComponentName.of(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[SPACE]",
                        "[APPLICATION_TEMPLATE]",
                        "[COMPONENT]")
                    .toString())
            .setSharedTemplateRevisionUri("sharedTemplateRevisionUri1743920658")
            .addAllParameters(new ArrayList<Parameter>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllRoles(new ArrayList<String>())
            .addAllApis(new ArrayList<String>())
            .setDisplayName("displayName1714148973")
            .addAllConnectionsParameters(new ArrayList<ConnectionParameters>())
            .addAllComponentParameterSchema(new ArrayList<ComponentParameterSchema>())
            .setApplicationInfo(ComponentApplicationInfo.newBuilder().build())
            .setUseAsRootModule(true)
            .addAllInputVariableAliases(new ArrayList<InputVariableAlias>())
            .setApplicationTemplateRevisionUri("applicationTemplateRevisionUri844336967")
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Component actualResponse = client.updateComponent(component, updateMask);
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
  public void updateComponentExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Component component =
          Component.newBuilder()
              .setName(
                  ComponentName.of(
                          "[PROJECT]",
                          "[LOCATION]",
                          "[SPACE]",
                          "[APPLICATION_TEMPLATE]",
                          "[COMPONENT]")
                      .toString())
              .setSharedTemplateRevisionUri("sharedTemplateRevisionUri1743920658")
              .addAllParameters(new ArrayList<Parameter>())
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .addAllRoles(new ArrayList<String>())
              .addAllApis(new ArrayList<String>())
              .setDisplayName("displayName1714148973")
              .addAllConnectionsParameters(new ArrayList<ConnectionParameters>())
              .addAllComponentParameterSchema(new ArrayList<ComponentParameterSchema>())
              .setApplicationInfo(ComponentApplicationInfo.newBuilder().build())
              .setUseAsRootModule(true)
              .addAllInputVariableAliases(new ArrayList<InputVariableAlias>())
              .setApplicationTemplateRevisionUri("applicationTemplateRevisionUri844336967")
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateComponent(component, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteComponentTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    ComponentName name =
        ComponentName.of(
            "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]", "[COMPONENT]");

    client.deleteComponent(name);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteComponentExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ComponentName name =
          ComponentName.of(
              "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]", "[COMPONENT]");
      client.deleteComponent(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteComponentTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-4394/locations/location-4394/spaces/space-4394/applicationTemplates/applicationTemplate-4394/components/component-4394";

    client.deleteComponent(name);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteComponentExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-4394/locations/location-4394/spaces/space-4394/applicationTemplates/applicationTemplate-4394/components/component-4394";
      client.deleteComponent(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getConnectionTest() throws Exception {
    Connection expectedResponse =
        Connection.newBuilder()
            .setName(
                ConnectionName.of(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[SPACE]",
                        "[APPLICATION_TEMPLATE]",
                        "[COMPONENT]",
                        "[CONNECTION]")
                    .toString())
            .setDestinationComponentUri(
                ComponentName.of(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[SPACE]",
                        "[APPLICATION_TEMPLATE]",
                        "[COMPONENT]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllSourceComponentParameters(new ArrayList<Parameter>())
            .addAllDestinationComponentParameters(new ArrayList<Parameter>())
            .setDependencyType(ConnectionDependencyType.forNumber(0))
            .build();
    mockService.addResponse(expectedResponse);

    ConnectionName name =
        ConnectionName.of(
            "[PROJECT]",
            "[LOCATION]",
            "[SPACE]",
            "[APPLICATION_TEMPLATE]",
            "[COMPONENT]",
            "[CONNECTION]");

    Connection actualResponse = client.getConnection(name);
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
  public void getConnectionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ConnectionName name =
          ConnectionName.of(
              "[PROJECT]",
              "[LOCATION]",
              "[SPACE]",
              "[APPLICATION_TEMPLATE]",
              "[COMPONENT]",
              "[CONNECTION]");
      client.getConnection(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getConnectionTest2() throws Exception {
    Connection expectedResponse =
        Connection.newBuilder()
            .setName(
                ConnectionName.of(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[SPACE]",
                        "[APPLICATION_TEMPLATE]",
                        "[COMPONENT]",
                        "[CONNECTION]")
                    .toString())
            .setDestinationComponentUri(
                ComponentName.of(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[SPACE]",
                        "[APPLICATION_TEMPLATE]",
                        "[COMPONENT]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllSourceComponentParameters(new ArrayList<Parameter>())
            .addAllDestinationComponentParameters(new ArrayList<Parameter>())
            .setDependencyType(ConnectionDependencyType.forNumber(0))
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-5243/locations/location-5243/spaces/space-5243/applicationTemplates/applicationTemplate-5243/components/component-5243/connections/connection-5243";

    Connection actualResponse = client.getConnection(name);
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
  public void getConnectionExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-5243/locations/location-5243/spaces/space-5243/applicationTemplates/applicationTemplate-5243/components/component-5243/connections/connection-5243";
      client.getConnection(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listConnectionsTest() throws Exception {
    Connection responsesElement = Connection.newBuilder().build();
    ListConnectionsResponse expectedResponse =
        ListConnectionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllConnections(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    ComponentName parent =
        ComponentName.of(
            "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]", "[COMPONENT]");

    ListConnectionsPagedResponse pagedListResponse = client.listConnections(parent);

    List<Connection> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getConnectionsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listConnectionsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ComponentName parent =
          ComponentName.of(
              "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]", "[COMPONENT]");
      client.listConnections(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listConnectionsTest2() throws Exception {
    Connection responsesElement = Connection.newBuilder().build();
    ListConnectionsResponse expectedResponse =
        ListConnectionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllConnections(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent =
        "projects/project-2731/locations/location-2731/spaces/space-2731/applicationTemplates/applicationTemplate-2731/components/component-2731";

    ListConnectionsPagedResponse pagedListResponse = client.listConnections(parent);

    List<Connection> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getConnectionsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listConnectionsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-2731/locations/location-2731/spaces/space-2731/applicationTemplates/applicationTemplate-2731/components/component-2731";
      client.listConnections(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createConnectionTest() throws Exception {
    Connection expectedResponse =
        Connection.newBuilder()
            .setName(
                ConnectionName.of(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[SPACE]",
                        "[APPLICATION_TEMPLATE]",
                        "[COMPONENT]",
                        "[CONNECTION]")
                    .toString())
            .setDestinationComponentUri(
                ComponentName.of(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[SPACE]",
                        "[APPLICATION_TEMPLATE]",
                        "[COMPONENT]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllSourceComponentParameters(new ArrayList<Parameter>())
            .addAllDestinationComponentParameters(new ArrayList<Parameter>())
            .setDependencyType(ConnectionDependencyType.forNumber(0))
            .build();
    mockService.addResponse(expectedResponse);

    ComponentName parent =
        ComponentName.of(
            "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]", "[COMPONENT]");
    Connection connection = Connection.newBuilder().build();
    String connectionId = "connectionId1923106969";

    Connection actualResponse = client.createConnection(parent, connection, connectionId);
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
  public void createConnectionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ComponentName parent =
          ComponentName.of(
              "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]", "[COMPONENT]");
      Connection connection = Connection.newBuilder().build();
      String connectionId = "connectionId1923106969";
      client.createConnection(parent, connection, connectionId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createConnectionTest2() throws Exception {
    Connection expectedResponse =
        Connection.newBuilder()
            .setName(
                ConnectionName.of(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[SPACE]",
                        "[APPLICATION_TEMPLATE]",
                        "[COMPONENT]",
                        "[CONNECTION]")
                    .toString())
            .setDestinationComponentUri(
                ComponentName.of(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[SPACE]",
                        "[APPLICATION_TEMPLATE]",
                        "[COMPONENT]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllSourceComponentParameters(new ArrayList<Parameter>())
            .addAllDestinationComponentParameters(new ArrayList<Parameter>())
            .setDependencyType(ConnectionDependencyType.forNumber(0))
            .build();
    mockService.addResponse(expectedResponse);

    String parent =
        "projects/project-2731/locations/location-2731/spaces/space-2731/applicationTemplates/applicationTemplate-2731/components/component-2731";
    Connection connection = Connection.newBuilder().build();
    String connectionId = "connectionId1923106969";

    Connection actualResponse = client.createConnection(parent, connection, connectionId);
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
  public void createConnectionExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-2731/locations/location-2731/spaces/space-2731/applicationTemplates/applicationTemplate-2731/components/component-2731";
      Connection connection = Connection.newBuilder().build();
      String connectionId = "connectionId1923106969";
      client.createConnection(parent, connection, connectionId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateConnectionTest() throws Exception {
    Connection expectedResponse =
        Connection.newBuilder()
            .setName(
                ConnectionName.of(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[SPACE]",
                        "[APPLICATION_TEMPLATE]",
                        "[COMPONENT]",
                        "[CONNECTION]")
                    .toString())
            .setDestinationComponentUri(
                ComponentName.of(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[SPACE]",
                        "[APPLICATION_TEMPLATE]",
                        "[COMPONENT]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllSourceComponentParameters(new ArrayList<Parameter>())
            .addAllDestinationComponentParameters(new ArrayList<Parameter>())
            .setDependencyType(ConnectionDependencyType.forNumber(0))
            .build();
    mockService.addResponse(expectedResponse);

    Connection connection =
        Connection.newBuilder()
            .setName(
                ConnectionName.of(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[SPACE]",
                        "[APPLICATION_TEMPLATE]",
                        "[COMPONENT]",
                        "[CONNECTION]")
                    .toString())
            .setDestinationComponentUri(
                ComponentName.of(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[SPACE]",
                        "[APPLICATION_TEMPLATE]",
                        "[COMPONENT]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllSourceComponentParameters(new ArrayList<Parameter>())
            .addAllDestinationComponentParameters(new ArrayList<Parameter>())
            .setDependencyType(ConnectionDependencyType.forNumber(0))
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Connection actualResponse = client.updateConnection(connection, updateMask);
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
  public void updateConnectionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Connection connection =
          Connection.newBuilder()
              .setName(
                  ConnectionName.of(
                          "[PROJECT]",
                          "[LOCATION]",
                          "[SPACE]",
                          "[APPLICATION_TEMPLATE]",
                          "[COMPONENT]",
                          "[CONNECTION]")
                      .toString())
              .setDestinationComponentUri(
                  ComponentName.of(
                          "[PROJECT]",
                          "[LOCATION]",
                          "[SPACE]",
                          "[APPLICATION_TEMPLATE]",
                          "[COMPONENT]")
                      .toString())
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .addAllSourceComponentParameters(new ArrayList<Parameter>())
              .addAllDestinationComponentParameters(new ArrayList<Parameter>())
              .setDependencyType(ConnectionDependencyType.forNumber(0))
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateConnection(connection, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteConnectionTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    ConnectionName name =
        ConnectionName.of(
            "[PROJECT]",
            "[LOCATION]",
            "[SPACE]",
            "[APPLICATION_TEMPLATE]",
            "[COMPONENT]",
            "[CONNECTION]");

    client.deleteConnection(name);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteConnectionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ConnectionName name =
          ConnectionName.of(
              "[PROJECT]",
              "[LOCATION]",
              "[SPACE]",
              "[APPLICATION_TEMPLATE]",
              "[COMPONENT]",
              "[CONNECTION]");
      client.deleteConnection(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteConnectionTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-5243/locations/location-5243/spaces/space-5243/applicationTemplates/applicationTemplate-5243/components/component-5243/connections/connection-5243";

    client.deleteConnection(name);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteConnectionExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-5243/locations/location-5243/spaces/space-5243/applicationTemplates/applicationTemplate-5243/components/component-5243/connections/connection-5243";
      client.deleteConnection(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getApplicationTemplateRevisionTest() throws Exception {
    ApplicationTemplateRevision expectedResponse =
        ApplicationTemplateRevision.newBuilder()
            .setName(
                ApplicationTemplateRevisionName.of(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[SPACE]",
                        "[APPLICATION_TEMPLATE]",
                        "[REVISION]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setSnapshot(SerializedApplicationTemplate.newBuilder().build())
            .setArtifactLocation(ArtifactLocation.newBuilder().build())
            .setTemplateMetadata(TFBlueprintMetadata.newBuilder().build())
            .addAllApplicationParameters(new ArrayList<Parameter>())
            .setIacSource(IACSource.forNumber(0))
            .build();
    mockService.addResponse(expectedResponse);

    ApplicationTemplateRevisionName name =
        ApplicationTemplateRevisionName.of(
            "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]", "[REVISION]");

    ApplicationTemplateRevision actualResponse = client.getApplicationTemplateRevision(name);
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
  public void getApplicationTemplateRevisionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ApplicationTemplateRevisionName name =
          ApplicationTemplateRevisionName.of(
              "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]", "[REVISION]");
      client.getApplicationTemplateRevision(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getApplicationTemplateRevisionTest2() throws Exception {
    ApplicationTemplateRevision expectedResponse =
        ApplicationTemplateRevision.newBuilder()
            .setName(
                ApplicationTemplateRevisionName.of(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[SPACE]",
                        "[APPLICATION_TEMPLATE]",
                        "[REVISION]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setSnapshot(SerializedApplicationTemplate.newBuilder().build())
            .setArtifactLocation(ArtifactLocation.newBuilder().build())
            .setTemplateMetadata(TFBlueprintMetadata.newBuilder().build())
            .addAllApplicationParameters(new ArrayList<Parameter>())
            .setIacSource(IACSource.forNumber(0))
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-8918/locations/location-8918/spaces/space-8918/applicationTemplates/applicationTemplate-8918/revisions/revision-8918";

    ApplicationTemplateRevision actualResponse = client.getApplicationTemplateRevision(name);
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
  public void getApplicationTemplateRevisionExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-8918/locations/location-8918/spaces/space-8918/applicationTemplates/applicationTemplate-8918/revisions/revision-8918";
      client.getApplicationTemplateRevision(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listApplicationTemplateRevisionsTest() throws Exception {
    ApplicationTemplateRevision responsesElement = ApplicationTemplateRevision.newBuilder().build();
    ListApplicationTemplateRevisionsResponse expectedResponse =
        ListApplicationTemplateRevisionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllApplicationTemplateRevisions(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    ApplicationTemplateName parent =
        ApplicationTemplateName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]");

    ListApplicationTemplateRevisionsPagedResponse pagedListResponse =
        client.listApplicationTemplateRevisions(parent);

    List<ApplicationTemplateRevision> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getApplicationTemplateRevisionsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listApplicationTemplateRevisionsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ApplicationTemplateName parent =
          ApplicationTemplateName.of(
              "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]");
      client.listApplicationTemplateRevisions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listApplicationTemplateRevisionsTest2() throws Exception {
    ApplicationTemplateRevision responsesElement = ApplicationTemplateRevision.newBuilder().build();
    ListApplicationTemplateRevisionsResponse expectedResponse =
        ListApplicationTemplateRevisionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllApplicationTemplateRevisions(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent =
        "projects/project-9797/locations/location-9797/spaces/space-9797/applicationTemplates/applicationTemplate-9797";

    ListApplicationTemplateRevisionsPagedResponse pagedListResponse =
        client.listApplicationTemplateRevisions(parent);

    List<ApplicationTemplateRevision> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getApplicationTemplateRevisionsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listApplicationTemplateRevisionsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-9797/locations/location-9797/spaces/space-9797/applicationTemplates/applicationTemplate-9797";
      client.listApplicationTemplateRevisions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteApplicationTemplateRevisionTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    ApplicationTemplateRevisionName name =
        ApplicationTemplateRevisionName.of(
            "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]", "[REVISION]");

    client.deleteApplicationTemplateRevision(name);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteApplicationTemplateRevisionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ApplicationTemplateRevisionName name =
          ApplicationTemplateRevisionName.of(
              "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]", "[REVISION]");
      client.deleteApplicationTemplateRevision(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteApplicationTemplateRevisionTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-8918/locations/location-8918/spaces/space-8918/applicationTemplates/applicationTemplate-8918/revisions/revision-8918";

    client.deleteApplicationTemplateRevision(name);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteApplicationTemplateRevisionExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-8918/locations/location-8918/spaces/space-8918/applicationTemplates/applicationTemplate-8918/revisions/revision-8918";
      client.deleteApplicationTemplateRevision(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getCatalogTest() throws Exception {
    Catalog expectedResponse =
        Catalog.newBuilder()
            .setName(CatalogName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[CATALOG]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    CatalogName name = CatalogName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[CATALOG]");

    Catalog actualResponse = client.getCatalog(name);
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
  public void getCatalogExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CatalogName name = CatalogName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[CATALOG]");
      client.getCatalog(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getCatalogTest2() throws Exception {
    Catalog expectedResponse =
        Catalog.newBuilder()
            .setName(CatalogName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[CATALOG]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-201/locations/location-201/spaces/space-201/catalogs/catalog-201";

    Catalog actualResponse = client.getCatalog(name);
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
  public void getCatalogExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-201/locations/location-201/spaces/space-201/catalogs/catalog-201";
      client.getCatalog(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listCatalogsTest() throws Exception {
    Catalog responsesElement = Catalog.newBuilder().build();
    ListCatalogsResponse expectedResponse =
        ListCatalogsResponse.newBuilder()
            .setNextPageToken("")
            .addAllCatalogs(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    SpaceName parent = SpaceName.of("[PROJECT]", "[LOCATION]", "[SPACE]");

    ListCatalogsPagedResponse pagedListResponse = client.listCatalogs(parent);

    List<Catalog> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCatalogsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listCatalogsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SpaceName parent = SpaceName.of("[PROJECT]", "[LOCATION]", "[SPACE]");
      client.listCatalogs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listCatalogsTest2() throws Exception {
    Catalog responsesElement = Catalog.newBuilder().build();
    ListCatalogsResponse expectedResponse =
        ListCatalogsResponse.newBuilder()
            .setNextPageToken("")
            .addAllCatalogs(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-2462/locations/location-2462/spaces/space-2462";

    ListCatalogsPagedResponse pagedListResponse = client.listCatalogs(parent);

    List<Catalog> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCatalogsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listCatalogsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-2462/locations/location-2462/spaces/space-2462";
      client.listCatalogs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createCatalogTest() throws Exception {
    Catalog expectedResponse =
        Catalog.newBuilder()
            .setName(CatalogName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[CATALOG]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    SpaceName parent = SpaceName.of("[PROJECT]", "[LOCATION]", "[SPACE]");
    Catalog catalog = Catalog.newBuilder().build();
    String catalogId = "catalogId1455933204";

    Catalog actualResponse = client.createCatalog(parent, catalog, catalogId);
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
  public void createCatalogExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SpaceName parent = SpaceName.of("[PROJECT]", "[LOCATION]", "[SPACE]");
      Catalog catalog = Catalog.newBuilder().build();
      String catalogId = "catalogId1455933204";
      client.createCatalog(parent, catalog, catalogId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createCatalogTest2() throws Exception {
    Catalog expectedResponse =
        Catalog.newBuilder()
            .setName(CatalogName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[CATALOG]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-2462/locations/location-2462/spaces/space-2462";
    Catalog catalog = Catalog.newBuilder().build();
    String catalogId = "catalogId1455933204";

    Catalog actualResponse = client.createCatalog(parent, catalog, catalogId);
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
  public void createCatalogExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-2462/locations/location-2462/spaces/space-2462";
      Catalog catalog = Catalog.newBuilder().build();
      String catalogId = "catalogId1455933204";
      client.createCatalog(parent, catalog, catalogId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateCatalogTest() throws Exception {
    Catalog expectedResponse =
        Catalog.newBuilder()
            .setName(CatalogName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[CATALOG]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    Catalog catalog =
        Catalog.newBuilder()
            .setName(CatalogName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[CATALOG]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Catalog actualResponse = client.updateCatalog(catalog, updateMask);
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
  public void updateCatalogExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Catalog catalog =
          Catalog.newBuilder()
              .setName(CatalogName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[CATALOG]").toString())
              .setDisplayName("displayName1714148973")
              .setDescription("description-1724546052")
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateCatalog(catalog, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteCatalogTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteCatalogTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    CatalogName name = CatalogName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[CATALOG]");

    client.deleteCatalogAsync(name).get();

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteCatalogExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CatalogName name = CatalogName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[CATALOG]");
      client.deleteCatalogAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteCatalogTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteCatalogTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name =
        "projects/project-201/locations/location-201/spaces/space-201/catalogs/catalog-201";

    client.deleteCatalogAsync(name).get();

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteCatalogExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-201/locations/location-201/spaces/space-201/catalogs/catalog-201";
      client.deleteCatalogAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createCatalogTemplateTest() throws Exception {
    CatalogTemplate expectedResponse =
        CatalogTemplate.newBuilder()
            .setName(
                CatalogTemplateName.of(
                        "[PROJECT]", "[LOCATION]", "[SPACE]", "[CATALOG]", "[CATALOG_TEMPLATE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setUuid("uuid3601339")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setLatestRevisionId("latestRevisionId-1320934083")
            .setTemplateCategory(TemplateCategory.forNumber(0))
            .setType(TemplateType.forNumber(0))
            .build();
    mockService.addResponse(expectedResponse);

    CatalogName parent = CatalogName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[CATALOG]");
    CatalogTemplate catalogTemplate = CatalogTemplate.newBuilder().build();
    String catalogTemplateId = "catalogTemplateId-1740091346";

    CatalogTemplate actualResponse =
        client.createCatalogTemplate(parent, catalogTemplate, catalogTemplateId);
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
  public void createCatalogTemplateExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CatalogName parent = CatalogName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[CATALOG]");
      CatalogTemplate catalogTemplate = CatalogTemplate.newBuilder().build();
      String catalogTemplateId = "catalogTemplateId-1740091346";
      client.createCatalogTemplate(parent, catalogTemplate, catalogTemplateId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createCatalogTemplateTest2() throws Exception {
    CatalogTemplate expectedResponse =
        CatalogTemplate.newBuilder()
            .setName(
                CatalogTemplateName.of(
                        "[PROJECT]", "[LOCATION]", "[SPACE]", "[CATALOG]", "[CATALOG_TEMPLATE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setUuid("uuid3601339")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setLatestRevisionId("latestRevisionId-1320934083")
            .setTemplateCategory(TemplateCategory.forNumber(0))
            .setType(TemplateType.forNumber(0))
            .build();
    mockService.addResponse(expectedResponse);

    String parent =
        "projects/project-7146/locations/location-7146/spaces/space-7146/catalogs/catalog-7146";
    CatalogTemplate catalogTemplate = CatalogTemplate.newBuilder().build();
    String catalogTemplateId = "catalogTemplateId-1740091346";

    CatalogTemplate actualResponse =
        client.createCatalogTemplate(parent, catalogTemplate, catalogTemplateId);
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
  public void createCatalogTemplateExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-7146/locations/location-7146/spaces/space-7146/catalogs/catalog-7146";
      CatalogTemplate catalogTemplate = CatalogTemplate.newBuilder().build();
      String catalogTemplateId = "catalogTemplateId-1740091346";
      client.createCatalogTemplate(parent, catalogTemplate, catalogTemplateId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getCatalogTemplateTest() throws Exception {
    CatalogTemplate expectedResponse =
        CatalogTemplate.newBuilder()
            .setName(
                CatalogTemplateName.of(
                        "[PROJECT]", "[LOCATION]", "[SPACE]", "[CATALOG]", "[CATALOG_TEMPLATE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setUuid("uuid3601339")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setLatestRevisionId("latestRevisionId-1320934083")
            .setTemplateCategory(TemplateCategory.forNumber(0))
            .setType(TemplateType.forNumber(0))
            .build();
    mockService.addResponse(expectedResponse);

    CatalogTemplateName name =
        CatalogTemplateName.of(
            "[PROJECT]", "[LOCATION]", "[SPACE]", "[CATALOG]", "[CATALOG_TEMPLATE]");

    CatalogTemplate actualResponse = client.getCatalogTemplate(name);
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
  public void getCatalogTemplateExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CatalogTemplateName name =
          CatalogTemplateName.of(
              "[PROJECT]", "[LOCATION]", "[SPACE]", "[CATALOG]", "[CATALOG_TEMPLATE]");
      client.getCatalogTemplate(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getCatalogTemplateTest2() throws Exception {
    CatalogTemplate expectedResponse =
        CatalogTemplate.newBuilder()
            .setName(
                CatalogTemplateName.of(
                        "[PROJECT]", "[LOCATION]", "[SPACE]", "[CATALOG]", "[CATALOG_TEMPLATE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setUuid("uuid3601339")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setLatestRevisionId("latestRevisionId-1320934083")
            .setTemplateCategory(TemplateCategory.forNumber(0))
            .setType(TemplateType.forNumber(0))
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-4572/locations/location-4572/spaces/space-4572/catalogs/catalog-4572/templates/template-4572";

    CatalogTemplate actualResponse = client.getCatalogTemplate(name);
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
  public void getCatalogTemplateExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-4572/locations/location-4572/spaces/space-4572/catalogs/catalog-4572/templates/template-4572";
      client.getCatalogTemplate(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listCatalogTemplatesTest() throws Exception {
    CatalogTemplate responsesElement = CatalogTemplate.newBuilder().build();
    ListCatalogTemplatesResponse expectedResponse =
        ListCatalogTemplatesResponse.newBuilder()
            .setNextPageToken("")
            .addAllCatalogTemplates(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    CatalogName parent = CatalogName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[CATALOG]");

    ListCatalogTemplatesPagedResponse pagedListResponse = client.listCatalogTemplates(parent);

    List<CatalogTemplate> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCatalogTemplatesList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listCatalogTemplatesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CatalogName parent = CatalogName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[CATALOG]");
      client.listCatalogTemplates(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listCatalogTemplatesTest2() throws Exception {
    CatalogTemplate responsesElement = CatalogTemplate.newBuilder().build();
    ListCatalogTemplatesResponse expectedResponse =
        ListCatalogTemplatesResponse.newBuilder()
            .setNextPageToken("")
            .addAllCatalogTemplates(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent =
        "projects/project-7146/locations/location-7146/spaces/space-7146/catalogs/catalog-7146";

    ListCatalogTemplatesPagedResponse pagedListResponse = client.listCatalogTemplates(parent);

    List<CatalogTemplate> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCatalogTemplatesList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listCatalogTemplatesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-7146/locations/location-7146/spaces/space-7146/catalogs/catalog-7146";
      client.listCatalogTemplates(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateCatalogTemplateTest() throws Exception {
    CatalogTemplate expectedResponse =
        CatalogTemplate.newBuilder()
            .setName(
                CatalogTemplateName.of(
                        "[PROJECT]", "[LOCATION]", "[SPACE]", "[CATALOG]", "[CATALOG_TEMPLATE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setUuid("uuid3601339")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setLatestRevisionId("latestRevisionId-1320934083")
            .setTemplateCategory(TemplateCategory.forNumber(0))
            .setType(TemplateType.forNumber(0))
            .build();
    mockService.addResponse(expectedResponse);

    CatalogTemplate catalogTemplate =
        CatalogTemplate.newBuilder()
            .setName(
                CatalogTemplateName.of(
                        "[PROJECT]", "[LOCATION]", "[SPACE]", "[CATALOG]", "[CATALOG_TEMPLATE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setUuid("uuid3601339")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setLatestRevisionId("latestRevisionId-1320934083")
            .setTemplateCategory(TemplateCategory.forNumber(0))
            .setType(TemplateType.forNumber(0))
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    CatalogTemplate actualResponse = client.updateCatalogTemplate(catalogTemplate, updateMask);
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
  public void updateCatalogTemplateExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CatalogTemplate catalogTemplate =
          CatalogTemplate.newBuilder()
              .setName(
                  CatalogTemplateName.of(
                          "[PROJECT]", "[LOCATION]", "[SPACE]", "[CATALOG]", "[CATALOG_TEMPLATE]")
                      .toString())
              .setDisplayName("displayName1714148973")
              .setDescription("description-1724546052")
              .setUuid("uuid3601339")
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .setLatestRevisionId("latestRevisionId-1320934083")
              .setTemplateCategory(TemplateCategory.forNumber(0))
              .setType(TemplateType.forNumber(0))
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateCatalogTemplate(catalogTemplate, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteCatalogTemplateTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteCatalogTemplateTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    CatalogTemplateName name =
        CatalogTemplateName.of(
            "[PROJECT]", "[LOCATION]", "[SPACE]", "[CATALOG]", "[CATALOG_TEMPLATE]");

    client.deleteCatalogTemplateAsync(name).get();

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteCatalogTemplateExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CatalogTemplateName name =
          CatalogTemplateName.of(
              "[PROJECT]", "[LOCATION]", "[SPACE]", "[CATALOG]", "[CATALOG_TEMPLATE]");
      client.deleteCatalogTemplateAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteCatalogTemplateTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteCatalogTemplateTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name =
        "projects/project-4572/locations/location-4572/spaces/space-4572/catalogs/catalog-4572/templates/template-4572";

    client.deleteCatalogTemplateAsync(name).get();

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteCatalogTemplateExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-4572/locations/location-4572/spaces/space-4572/catalogs/catalog-4572/templates/template-4572";
      client.deleteCatalogTemplateAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createShareTest() throws Exception {
    Share expectedResponse =
        Share.newBuilder()
            .setName(
                ShareName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[CATALOG]", "[SHARE]")
                    .toString())
            .setDestinationSpace(SpaceName.of("[PROJECT]", "[LOCATION]", "[SPACE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createShareTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    CatalogName parent = CatalogName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[CATALOG]");
    Share share = Share.newBuilder().build();
    String shareId = "shareId2054217050";

    Share actualResponse = client.createShareAsync(parent, share, shareId).get();
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
  public void createShareExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CatalogName parent = CatalogName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[CATALOG]");
      Share share = Share.newBuilder().build();
      String shareId = "shareId2054217050";
      client.createShareAsync(parent, share, shareId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createShareTest2() throws Exception {
    Share expectedResponse =
        Share.newBuilder()
            .setName(
                ShareName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[CATALOG]", "[SHARE]")
                    .toString())
            .setDestinationSpace(SpaceName.of("[PROJECT]", "[LOCATION]", "[SPACE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createShareTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent =
        "projects/project-7146/locations/location-7146/spaces/space-7146/catalogs/catalog-7146";
    Share share = Share.newBuilder().build();
    String shareId = "shareId2054217050";

    Share actualResponse = client.createShareAsync(parent, share, shareId).get();
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
  public void createShareExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-7146/locations/location-7146/spaces/space-7146/catalogs/catalog-7146";
      Share share = Share.newBuilder().build();
      String shareId = "shareId2054217050";
      client.createShareAsync(parent, share, shareId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void listSharesTest() throws Exception {
    Share responsesElement = Share.newBuilder().build();
    ListSharesResponse expectedResponse =
        ListSharesResponse.newBuilder()
            .setNextPageToken("")
            .addAllShares(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    CatalogName parent = CatalogName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[CATALOG]");

    ListSharesPagedResponse pagedListResponse = client.listShares(parent);

    List<Share> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSharesList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listSharesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CatalogName parent = CatalogName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[CATALOG]");
      client.listShares(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSharesTest2() throws Exception {
    Share responsesElement = Share.newBuilder().build();
    ListSharesResponse expectedResponse =
        ListSharesResponse.newBuilder()
            .setNextPageToken("")
            .addAllShares(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent =
        "projects/project-7146/locations/location-7146/spaces/space-7146/catalogs/catalog-7146";

    ListSharesPagedResponse pagedListResponse = client.listShares(parent);

    List<Share> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSharesList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listSharesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-7146/locations/location-7146/spaces/space-7146/catalogs/catalog-7146";
      client.listShares(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getShareTest() throws Exception {
    Share expectedResponse =
        Share.newBuilder()
            .setName(
                ShareName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[CATALOG]", "[SHARE]")
                    .toString())
            .setDestinationSpace(SpaceName.of("[PROJECT]", "[LOCATION]", "[SPACE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    ShareName name = ShareName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[CATALOG]", "[SHARE]");

    Share actualResponse = client.getShare(name);
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
  public void getShareExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ShareName name = ShareName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[CATALOG]", "[SHARE]");
      client.getShare(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getShareTest2() throws Exception {
    Share expectedResponse =
        Share.newBuilder()
            .setName(
                ShareName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[CATALOG]", "[SHARE]")
                    .toString())
            .setDestinationSpace(SpaceName.of("[PROJECT]", "[LOCATION]", "[SPACE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-8569/locations/location-8569/spaces/space-8569/catalogs/catalog-8569/shares/share-8569";

    Share actualResponse = client.getShare(name);
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
  public void getShareExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-8569/locations/location-8569/spaces/space-8569/catalogs/catalog-8569/shares/share-8569";
      client.getShare(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteShareTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteShareTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    ShareName name = ShareName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[CATALOG]", "[SHARE]");

    client.deleteShareAsync(name).get();

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteShareExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ShareName name = ShareName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[CATALOG]", "[SHARE]");
      client.deleteShareAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteShareTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteShareTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name =
        "projects/project-8569/locations/location-8569/spaces/space-8569/catalogs/catalog-8569/shares/share-8569";

    client.deleteShareAsync(name).get();

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteShareExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-8569/locations/location-8569/spaces/space-8569/catalogs/catalog-8569/shares/share-8569";
      client.deleteShareAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void syncShareTest() throws Exception {
    Share expectedResponse =
        Share.newBuilder()
            .setName(
                ShareName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[CATALOG]", "[SHARE]")
                    .toString())
            .setDestinationSpace(SpaceName.of("[PROJECT]", "[LOCATION]", "[SPACE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("syncShareTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    ShareName name = ShareName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[CATALOG]", "[SHARE]");

    Share actualResponse = client.syncShareAsync(name).get();
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
  public void syncShareExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ShareName name = ShareName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[CATALOG]", "[SHARE]");
      client.syncShareAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void syncShareTest2() throws Exception {
    Share expectedResponse =
        Share.newBuilder()
            .setName(
                ShareName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[CATALOG]", "[SHARE]")
                    .toString())
            .setDestinationSpace(SpaceName.of("[PROJECT]", "[LOCATION]", "[SPACE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("syncShareTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name =
        "projects/project-8569/locations/location-8569/spaces/space-8569/catalogs/catalog-8569/shares/share-8569";

    Share actualResponse = client.syncShareAsync(name).get();
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
  public void syncShareExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-8569/locations/location-8569/spaces/space-8569/catalogs/catalog-8569/shares/share-8569";
      client.syncShareAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void getSharedTemplateTest() throws Exception {
    SharedTemplate expectedResponse =
        SharedTemplate.newBuilder()
            .setName(
                SharedTemplateName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[SHARED_TEMPLATE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setOriginTemplate(
                CatalogTemplateName.of(
                        "[PROJECT]", "[LOCATION]", "[SPACE]", "[CATALOG]", "[CATALOG_TEMPLATE]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setLatestRevisionId("latestRevisionId-1320934083")
            .setTemplateCategory(TemplateCategory.forNumber(0))
            .setType(TemplateType.forNumber(0))
            .build();
    mockService.addResponse(expectedResponse);

    SharedTemplateName name =
        SharedTemplateName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[SHARED_TEMPLATE]");

    SharedTemplate actualResponse = client.getSharedTemplate(name);
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
  public void getSharedTemplateExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SharedTemplateName name =
          SharedTemplateName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[SHARED_TEMPLATE]");
      client.getSharedTemplate(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSharedTemplateTest2() throws Exception {
    SharedTemplate expectedResponse =
        SharedTemplate.newBuilder()
            .setName(
                SharedTemplateName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[SHARED_TEMPLATE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setOriginTemplate(
                CatalogTemplateName.of(
                        "[PROJECT]", "[LOCATION]", "[SPACE]", "[CATALOG]", "[CATALOG_TEMPLATE]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setLatestRevisionId("latestRevisionId-1320934083")
            .setTemplateCategory(TemplateCategory.forNumber(0))
            .setType(TemplateType.forNumber(0))
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-6621/locations/location-6621/spaces/space-6621/sharedTemplates/sharedTemplate-6621";

    SharedTemplate actualResponse = client.getSharedTemplate(name);
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
  public void getSharedTemplateExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-6621/locations/location-6621/spaces/space-6621/sharedTemplates/sharedTemplate-6621";
      client.getSharedTemplate(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSharedTemplatesTest() throws Exception {
    SharedTemplate responsesElement = SharedTemplate.newBuilder().build();
    ListSharedTemplatesResponse expectedResponse =
        ListSharedTemplatesResponse.newBuilder()
            .setNextPageToken("")
            .addAllSharedTemplates(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    SpaceName parent = SpaceName.of("[PROJECT]", "[LOCATION]", "[SPACE]");

    ListSharedTemplatesPagedResponse pagedListResponse = client.listSharedTemplates(parent);

    List<SharedTemplate> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSharedTemplatesList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listSharedTemplatesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SpaceName parent = SpaceName.of("[PROJECT]", "[LOCATION]", "[SPACE]");
      client.listSharedTemplates(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSharedTemplatesTest2() throws Exception {
    SharedTemplate responsesElement = SharedTemplate.newBuilder().build();
    ListSharedTemplatesResponse expectedResponse =
        ListSharedTemplatesResponse.newBuilder()
            .setNextPageToken("")
            .addAllSharedTemplates(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-2462/locations/location-2462/spaces/space-2462";

    ListSharedTemplatesPagedResponse pagedListResponse = client.listSharedTemplates(parent);

    List<SharedTemplate> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSharedTemplatesList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listSharedTemplatesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-2462/locations/location-2462/spaces/space-2462";
      client.listSharedTemplates(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSharedTemplateRevisionTest() throws Exception {
    SharedTemplateRevision expectedResponse =
        SharedTemplateRevision.newBuilder()
            .setName(
                SharedTemplateRevisionName.of(
                        "[PROJECT]", "[LOCATION]", "[SPACE]", "[SHARED_TEMPLATE]", "[REVISION]")
                    .toString())
            .setDescription("description-1724546052")
            .setType(TemplateType.forNumber(0))
            .setSharedTemplateMetadata(TFBlueprintMetadata.newBuilder().build())
            .setOriginTemplateRevision(
                CatalogTemplateRevisionName.of(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[SPACE]",
                        "[CATALOG]",
                        "[CATALOG_TEMPLATE]",
                        "[REVISION]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setApplicationTemplateRevision(SerializedApplicationTemplate.newBuilder().build())
            .setHelmChartMetadata(HelmChartMetadata.newBuilder().build())
            .setTemplateCategory(TemplateCategory.forNumber(0))
            .addAllLogicalProducts(new ArrayList<LogicalProduct>())
            .putAllAnnotations(new HashMap<String, String>())
            .setInferredMetadata(InferredMetadata.newBuilder().build())
            .addAllResourceTypes(new ArrayList<ResourceType>())
            .setIacSource(IACSource.forNumber(0))
            .addAllApplicationParameters(new ArrayList<Parameter>())
            .build();
    mockService.addResponse(expectedResponse);

    SharedTemplateRevisionName name =
        SharedTemplateRevisionName.of(
            "[PROJECT]", "[LOCATION]", "[SPACE]", "[SHARED_TEMPLATE]", "[REVISION]");

    SharedTemplateRevision actualResponse = client.getSharedTemplateRevision(name);
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
  public void getSharedTemplateRevisionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SharedTemplateRevisionName name =
          SharedTemplateRevisionName.of(
              "[PROJECT]", "[LOCATION]", "[SPACE]", "[SHARED_TEMPLATE]", "[REVISION]");
      client.getSharedTemplateRevision(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSharedTemplateRevisionTest2() throws Exception {
    SharedTemplateRevision expectedResponse =
        SharedTemplateRevision.newBuilder()
            .setName(
                SharedTemplateRevisionName.of(
                        "[PROJECT]", "[LOCATION]", "[SPACE]", "[SHARED_TEMPLATE]", "[REVISION]")
                    .toString())
            .setDescription("description-1724546052")
            .setType(TemplateType.forNumber(0))
            .setSharedTemplateMetadata(TFBlueprintMetadata.newBuilder().build())
            .setOriginTemplateRevision(
                CatalogTemplateRevisionName.of(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[SPACE]",
                        "[CATALOG]",
                        "[CATALOG_TEMPLATE]",
                        "[REVISION]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setApplicationTemplateRevision(SerializedApplicationTemplate.newBuilder().build())
            .setHelmChartMetadata(HelmChartMetadata.newBuilder().build())
            .setTemplateCategory(TemplateCategory.forNumber(0))
            .addAllLogicalProducts(new ArrayList<LogicalProduct>())
            .putAllAnnotations(new HashMap<String, String>())
            .setInferredMetadata(InferredMetadata.newBuilder().build())
            .addAllResourceTypes(new ArrayList<ResourceType>())
            .setIacSource(IACSource.forNumber(0))
            .addAllApplicationParameters(new ArrayList<Parameter>())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-8735/locations/location-8735/spaces/space-8735/sharedTemplates/sharedTemplate-8735/revisions/revision-8735";

    SharedTemplateRevision actualResponse = client.getSharedTemplateRevision(name);
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
  public void getSharedTemplateRevisionExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-8735/locations/location-8735/spaces/space-8735/sharedTemplates/sharedTemplate-8735/revisions/revision-8735";
      client.getSharedTemplateRevision(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSharedTemplateRevisionsTest() throws Exception {
    SharedTemplateRevision responsesElement = SharedTemplateRevision.newBuilder().build();
    ListSharedTemplateRevisionsResponse expectedResponse =
        ListSharedTemplateRevisionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllSharedTemplateRevisions(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    SharedTemplateName parent =
        SharedTemplateName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[SHARED_TEMPLATE]");

    ListSharedTemplateRevisionsPagedResponse pagedListResponse =
        client.listSharedTemplateRevisions(parent);

    List<SharedTemplateRevision> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSharedTemplateRevisionsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listSharedTemplateRevisionsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SharedTemplateName parent =
          SharedTemplateName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[SHARED_TEMPLATE]");
      client.listSharedTemplateRevisions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSharedTemplateRevisionsTest2() throws Exception {
    SharedTemplateRevision responsesElement = SharedTemplateRevision.newBuilder().build();
    ListSharedTemplateRevisionsResponse expectedResponse =
        ListSharedTemplateRevisionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllSharedTemplateRevisions(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent =
        "projects/project-7150/locations/location-7150/spaces/space-7150/sharedTemplates/sharedTemplate-7150";

    ListSharedTemplateRevisionsPagedResponse pagedListResponse =
        client.listSharedTemplateRevisions(parent);

    List<SharedTemplateRevision> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSharedTemplateRevisionsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listSharedTemplateRevisionsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-7150/locations/location-7150/spaces/space-7150/sharedTemplates/sharedTemplate-7150";
      client.listSharedTemplateRevisions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createCatalogTemplateRevisionTest() throws Exception {
    CatalogTemplateRevision expectedResponse =
        CatalogTemplateRevision.newBuilder()
            .setName(
                CatalogTemplateRevisionName.of(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[SPACE]",
                        "[CATALOG]",
                        "[CATALOG_TEMPLATE]",
                        "[REVISION]")
                    .toString())
            .setDescription("description-1724546052")
            .setType(TemplateType.forNumber(0))
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setTemplateMetadata(TFBlueprintMetadata.newBuilder().build())
            .setApplicationTemplateRevision(SerializedApplicationTemplate.newBuilder().build())
            .setHelmChartMetadata(HelmChartMetadata.newBuilder().build())
            .setUuid("uuid3601339")
            .setMetadataInput(MetadataInput.newBuilder().build())
            .setTemplateCategory(TemplateCategory.forNumber(0))
            .addAllLogicalProducts(new ArrayList<LogicalProduct>())
            .putAllAnnotations(new HashMap<String, String>())
            .setInferredMetadata(InferredMetadata.newBuilder().build())
            .addAllResourceTypes(new ArrayList<ResourceType>())
            .setIacSource(IACSource.forNumber(0))
            .addAllApplicationParameters(new ArrayList<Parameter>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createCatalogTemplateRevisionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    CatalogTemplateName parent =
        CatalogTemplateName.of(
            "[PROJECT]", "[LOCATION]", "[SPACE]", "[CATALOG]", "[CATALOG_TEMPLATE]");
    CatalogTemplateRevision catalogTemplateRevision = CatalogTemplateRevision.newBuilder().build();
    String catalogTemplateRevisionId = "catalogTemplateRevisionId1620031081";

    CatalogTemplateRevision actualResponse =
        client
            .createCatalogTemplateRevisionAsync(
                parent, catalogTemplateRevision, catalogTemplateRevisionId)
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
  public void createCatalogTemplateRevisionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CatalogTemplateName parent =
          CatalogTemplateName.of(
              "[PROJECT]", "[LOCATION]", "[SPACE]", "[CATALOG]", "[CATALOG_TEMPLATE]");
      CatalogTemplateRevision catalogTemplateRevision =
          CatalogTemplateRevision.newBuilder().build();
      String catalogTemplateRevisionId = "catalogTemplateRevisionId1620031081";
      client
          .createCatalogTemplateRevisionAsync(
              parent, catalogTemplateRevision, catalogTemplateRevisionId)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createCatalogTemplateRevisionTest2() throws Exception {
    CatalogTemplateRevision expectedResponse =
        CatalogTemplateRevision.newBuilder()
            .setName(
                CatalogTemplateRevisionName.of(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[SPACE]",
                        "[CATALOG]",
                        "[CATALOG_TEMPLATE]",
                        "[REVISION]")
                    .toString())
            .setDescription("description-1724546052")
            .setType(TemplateType.forNumber(0))
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setTemplateMetadata(TFBlueprintMetadata.newBuilder().build())
            .setApplicationTemplateRevision(SerializedApplicationTemplate.newBuilder().build())
            .setHelmChartMetadata(HelmChartMetadata.newBuilder().build())
            .setUuid("uuid3601339")
            .setMetadataInput(MetadataInput.newBuilder().build())
            .setTemplateCategory(TemplateCategory.forNumber(0))
            .addAllLogicalProducts(new ArrayList<LogicalProduct>())
            .putAllAnnotations(new HashMap<String, String>())
            .setInferredMetadata(InferredMetadata.newBuilder().build())
            .addAllResourceTypes(new ArrayList<ResourceType>())
            .setIacSource(IACSource.forNumber(0))
            .addAllApplicationParameters(new ArrayList<Parameter>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createCatalogTemplateRevisionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent =
        "projects/project-7179/locations/location-7179/spaces/space-7179/catalogs/catalog-7179/templates/template-7179";
    CatalogTemplateRevision catalogTemplateRevision = CatalogTemplateRevision.newBuilder().build();
    String catalogTemplateRevisionId = "catalogTemplateRevisionId1620031081";

    CatalogTemplateRevision actualResponse =
        client
            .createCatalogTemplateRevisionAsync(
                parent, catalogTemplateRevision, catalogTemplateRevisionId)
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
  public void createCatalogTemplateRevisionExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-7179/locations/location-7179/spaces/space-7179/catalogs/catalog-7179/templates/template-7179";
      CatalogTemplateRevision catalogTemplateRevision =
          CatalogTemplateRevision.newBuilder().build();
      String catalogTemplateRevisionId = "catalogTemplateRevisionId1620031081";
      client
          .createCatalogTemplateRevisionAsync(
              parent, catalogTemplateRevision, catalogTemplateRevisionId)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void getCatalogTemplateRevisionTest() throws Exception {
    CatalogTemplateRevision expectedResponse =
        CatalogTemplateRevision.newBuilder()
            .setName(
                CatalogTemplateRevisionName.of(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[SPACE]",
                        "[CATALOG]",
                        "[CATALOG_TEMPLATE]",
                        "[REVISION]")
                    .toString())
            .setDescription("description-1724546052")
            .setType(TemplateType.forNumber(0))
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setTemplateMetadata(TFBlueprintMetadata.newBuilder().build())
            .setApplicationTemplateRevision(SerializedApplicationTemplate.newBuilder().build())
            .setHelmChartMetadata(HelmChartMetadata.newBuilder().build())
            .setUuid("uuid3601339")
            .setMetadataInput(MetadataInput.newBuilder().build())
            .setTemplateCategory(TemplateCategory.forNumber(0))
            .addAllLogicalProducts(new ArrayList<LogicalProduct>())
            .putAllAnnotations(new HashMap<String, String>())
            .setInferredMetadata(InferredMetadata.newBuilder().build())
            .addAllResourceTypes(new ArrayList<ResourceType>())
            .setIacSource(IACSource.forNumber(0))
            .addAllApplicationParameters(new ArrayList<Parameter>())
            .build();
    mockService.addResponse(expectedResponse);

    CatalogTemplateRevisionName name =
        CatalogTemplateRevisionName.of(
            "[PROJECT]", "[LOCATION]", "[SPACE]", "[CATALOG]", "[CATALOG_TEMPLATE]", "[REVISION]");

    CatalogTemplateRevision actualResponse = client.getCatalogTemplateRevision(name);
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
  public void getCatalogTemplateRevisionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CatalogTemplateRevisionName name =
          CatalogTemplateRevisionName.of(
              "[PROJECT]",
              "[LOCATION]",
              "[SPACE]",
              "[CATALOG]",
              "[CATALOG_TEMPLATE]",
              "[REVISION]");
      client.getCatalogTemplateRevision(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getCatalogTemplateRevisionTest2() throws Exception {
    CatalogTemplateRevision expectedResponse =
        CatalogTemplateRevision.newBuilder()
            .setName(
                CatalogTemplateRevisionName.of(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[SPACE]",
                        "[CATALOG]",
                        "[CATALOG_TEMPLATE]",
                        "[REVISION]")
                    .toString())
            .setDescription("description-1724546052")
            .setType(TemplateType.forNumber(0))
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setTemplateMetadata(TFBlueprintMetadata.newBuilder().build())
            .setApplicationTemplateRevision(SerializedApplicationTemplate.newBuilder().build())
            .setHelmChartMetadata(HelmChartMetadata.newBuilder().build())
            .setUuid("uuid3601339")
            .setMetadataInput(MetadataInput.newBuilder().build())
            .setTemplateCategory(TemplateCategory.forNumber(0))
            .addAllLogicalProducts(new ArrayList<LogicalProduct>())
            .putAllAnnotations(new HashMap<String, String>())
            .setInferredMetadata(InferredMetadata.newBuilder().build())
            .addAllResourceTypes(new ArrayList<ResourceType>())
            .setIacSource(IACSource.forNumber(0))
            .addAllApplicationParameters(new ArrayList<Parameter>())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-336/locations/location-336/spaces/space-336/catalogs/catalog-336/templates/template-336/revisions/revision-336";

    CatalogTemplateRevision actualResponse = client.getCatalogTemplateRevision(name);
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
  public void getCatalogTemplateRevisionExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-336/locations/location-336/spaces/space-336/catalogs/catalog-336/templates/template-336/revisions/revision-336";
      client.getCatalogTemplateRevision(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listCatalogTemplateRevisionsTest() throws Exception {
    CatalogTemplateRevision responsesElement = CatalogTemplateRevision.newBuilder().build();
    ListCatalogTemplateRevisionsResponse expectedResponse =
        ListCatalogTemplateRevisionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllCatalogTemplateRevisions(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    CatalogTemplateName parent =
        CatalogTemplateName.of(
            "[PROJECT]", "[LOCATION]", "[SPACE]", "[CATALOG]", "[CATALOG_TEMPLATE]");

    ListCatalogTemplateRevisionsPagedResponse pagedListResponse =
        client.listCatalogTemplateRevisions(parent);

    List<CatalogTemplateRevision> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getCatalogTemplateRevisionsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listCatalogTemplateRevisionsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CatalogTemplateName parent =
          CatalogTemplateName.of(
              "[PROJECT]", "[LOCATION]", "[SPACE]", "[CATALOG]", "[CATALOG_TEMPLATE]");
      client.listCatalogTemplateRevisions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listCatalogTemplateRevisionsTest2() throws Exception {
    CatalogTemplateRevision responsesElement = CatalogTemplateRevision.newBuilder().build();
    ListCatalogTemplateRevisionsResponse expectedResponse =
        ListCatalogTemplateRevisionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllCatalogTemplateRevisions(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent =
        "projects/project-7179/locations/location-7179/spaces/space-7179/catalogs/catalog-7179/templates/template-7179";

    ListCatalogTemplateRevisionsPagedResponse pagedListResponse =
        client.listCatalogTemplateRevisions(parent);

    List<CatalogTemplateRevision> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getCatalogTemplateRevisionsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listCatalogTemplateRevisionsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-7179/locations/location-7179/spaces/space-7179/catalogs/catalog-7179/templates/template-7179";
      client.listCatalogTemplateRevisions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteCatalogTemplateRevisionTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteCatalogTemplateRevisionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    CatalogTemplateRevisionName name =
        CatalogTemplateRevisionName.of(
            "[PROJECT]", "[LOCATION]", "[SPACE]", "[CATALOG]", "[CATALOG_TEMPLATE]", "[REVISION]");

    client.deleteCatalogTemplateRevisionAsync(name).get();

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteCatalogTemplateRevisionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CatalogTemplateRevisionName name =
          CatalogTemplateRevisionName.of(
              "[PROJECT]",
              "[LOCATION]",
              "[SPACE]",
              "[CATALOG]",
              "[CATALOG_TEMPLATE]",
              "[REVISION]");
      client.deleteCatalogTemplateRevisionAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteCatalogTemplateRevisionTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteCatalogTemplateRevisionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name =
        "projects/project-336/locations/location-336/spaces/space-336/catalogs/catalog-336/templates/template-336/revisions/revision-336";

    client.deleteCatalogTemplateRevisionAsync(name).get();

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteCatalogTemplateRevisionExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-336/locations/location-336/spaces/space-336/catalogs/catalog-336/templates/template-336/revisions/revision-336";
      client.deleteCatalogTemplateRevisionAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createApplicationTest() throws Exception {
    Application expectedResponse =
        Application.newBuilder()
            .setName(
                ApplicationName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setSource(DeploymentSource.newBuilder().build())
            .addAllAppParameters(new ArrayList<Parameter>())
            .addAllComponentParameters(new ArrayList<ComponentParameters>())
            .setServiceAccount("serviceAccount1079137720")
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setAttributes(Attributes.newBuilder().build())
            .setScope(Scope.newBuilder().build())
            .setImportExistingResources(true)
            .setPreviewReference("previewReference1962163299")
            .setDeploymentRevision("deploymentRevision-13024832")
            .setApphubApplication("apphubApplication104302972")
            .setSerializedApplicationTemplate(SerializedApplicationTemplate.newBuilder().build())
            .setDeploymentMetadata(DeploymentMetadata.newBuilder().build())
            .addAllProjectParameters(new ArrayList<ProjectParameters>())
            .setDeploymentRegion("deploymentRegion1711269401")
            .setUpdatedTemplateRevision(UpdatedTemplateRevision.newBuilder().build())
            .setDeploymentProject("deploymentProject114323604")
            .addAllConnectionConfigs(new ArrayList<ConnectionConfig>())
            .setArtifactLocation(ArtifactLocation.newBuilder().build())
            .setType(ApplicationType.forNumber(0))
            .setDeploymentTarget(DeploymentTarget.newBuilder().build())
            .setCompositionType(ApplicationCompositionType.forNumber(0))
            .setCompositeApplicationParameters(CompositeApplicationParameters.newBuilder().build())
            .setDeploymentGroupMetadata(DeploymentGroupMetadata.newBuilder().build())
            .addAllRolesApisConfig(new ArrayList<RolesAndApisConfig>())
            .setTemplateMetadata(TFBlueprintMetadata.newBuilder().build())
            .setIacSource(IACSource.forNumber(0))
            .build();
    mockService.addResponse(expectedResponse);

    SpaceName parent = SpaceName.of("[PROJECT]", "[LOCATION]", "[SPACE]");
    Application application = Application.newBuilder().build();
    String applicationId = "applicationId-1011352949";

    Application actualResponse = client.createApplication(parent, application, applicationId);
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
  public void createApplicationExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SpaceName parent = SpaceName.of("[PROJECT]", "[LOCATION]", "[SPACE]");
      Application application = Application.newBuilder().build();
      String applicationId = "applicationId-1011352949";
      client.createApplication(parent, application, applicationId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createApplicationTest2() throws Exception {
    Application expectedResponse =
        Application.newBuilder()
            .setName(
                ApplicationName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setSource(DeploymentSource.newBuilder().build())
            .addAllAppParameters(new ArrayList<Parameter>())
            .addAllComponentParameters(new ArrayList<ComponentParameters>())
            .setServiceAccount("serviceAccount1079137720")
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setAttributes(Attributes.newBuilder().build())
            .setScope(Scope.newBuilder().build())
            .setImportExistingResources(true)
            .setPreviewReference("previewReference1962163299")
            .setDeploymentRevision("deploymentRevision-13024832")
            .setApphubApplication("apphubApplication104302972")
            .setSerializedApplicationTemplate(SerializedApplicationTemplate.newBuilder().build())
            .setDeploymentMetadata(DeploymentMetadata.newBuilder().build())
            .addAllProjectParameters(new ArrayList<ProjectParameters>())
            .setDeploymentRegion("deploymentRegion1711269401")
            .setUpdatedTemplateRevision(UpdatedTemplateRevision.newBuilder().build())
            .setDeploymentProject("deploymentProject114323604")
            .addAllConnectionConfigs(new ArrayList<ConnectionConfig>())
            .setArtifactLocation(ArtifactLocation.newBuilder().build())
            .setType(ApplicationType.forNumber(0))
            .setDeploymentTarget(DeploymentTarget.newBuilder().build())
            .setCompositionType(ApplicationCompositionType.forNumber(0))
            .setCompositeApplicationParameters(CompositeApplicationParameters.newBuilder().build())
            .setDeploymentGroupMetadata(DeploymentGroupMetadata.newBuilder().build())
            .addAllRolesApisConfig(new ArrayList<RolesAndApisConfig>())
            .setTemplateMetadata(TFBlueprintMetadata.newBuilder().build())
            .setIacSource(IACSource.forNumber(0))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-2462/locations/location-2462/spaces/space-2462";
    Application application = Application.newBuilder().build();
    String applicationId = "applicationId-1011352949";

    Application actualResponse = client.createApplication(parent, application, applicationId);
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
  public void createApplicationExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-2462/locations/location-2462/spaces/space-2462";
      Application application = Application.newBuilder().build();
      String applicationId = "applicationId-1011352949";
      client.createApplication(parent, application, applicationId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getApplicationTest() throws Exception {
    Application expectedResponse =
        Application.newBuilder()
            .setName(
                ApplicationName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setSource(DeploymentSource.newBuilder().build())
            .addAllAppParameters(new ArrayList<Parameter>())
            .addAllComponentParameters(new ArrayList<ComponentParameters>())
            .setServiceAccount("serviceAccount1079137720")
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setAttributes(Attributes.newBuilder().build())
            .setScope(Scope.newBuilder().build())
            .setImportExistingResources(true)
            .setPreviewReference("previewReference1962163299")
            .setDeploymentRevision("deploymentRevision-13024832")
            .setApphubApplication("apphubApplication104302972")
            .setSerializedApplicationTemplate(SerializedApplicationTemplate.newBuilder().build())
            .setDeploymentMetadata(DeploymentMetadata.newBuilder().build())
            .addAllProjectParameters(new ArrayList<ProjectParameters>())
            .setDeploymentRegion("deploymentRegion1711269401")
            .setUpdatedTemplateRevision(UpdatedTemplateRevision.newBuilder().build())
            .setDeploymentProject("deploymentProject114323604")
            .addAllConnectionConfigs(new ArrayList<ConnectionConfig>())
            .setArtifactLocation(ArtifactLocation.newBuilder().build())
            .setType(ApplicationType.forNumber(0))
            .setDeploymentTarget(DeploymentTarget.newBuilder().build())
            .setCompositionType(ApplicationCompositionType.forNumber(0))
            .setCompositeApplicationParameters(CompositeApplicationParameters.newBuilder().build())
            .setDeploymentGroupMetadata(DeploymentGroupMetadata.newBuilder().build())
            .addAllRolesApisConfig(new ArrayList<RolesAndApisConfig>())
            .setTemplateMetadata(TFBlueprintMetadata.newBuilder().build())
            .setIacSource(IACSource.forNumber(0))
            .build();
    mockService.addResponse(expectedResponse);

    ApplicationName name =
        ApplicationName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION]");

    Application actualResponse = client.getApplication(name);
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
  public void getApplicationExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ApplicationName name =
          ApplicationName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION]");
      client.getApplication(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getApplicationTest2() throws Exception {
    Application expectedResponse =
        Application.newBuilder()
            .setName(
                ApplicationName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setSource(DeploymentSource.newBuilder().build())
            .addAllAppParameters(new ArrayList<Parameter>())
            .addAllComponentParameters(new ArrayList<ComponentParameters>())
            .setServiceAccount("serviceAccount1079137720")
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setAttributes(Attributes.newBuilder().build())
            .setScope(Scope.newBuilder().build())
            .setImportExistingResources(true)
            .setPreviewReference("previewReference1962163299")
            .setDeploymentRevision("deploymentRevision-13024832")
            .setApphubApplication("apphubApplication104302972")
            .setSerializedApplicationTemplate(SerializedApplicationTemplate.newBuilder().build())
            .setDeploymentMetadata(DeploymentMetadata.newBuilder().build())
            .addAllProjectParameters(new ArrayList<ProjectParameters>())
            .setDeploymentRegion("deploymentRegion1711269401")
            .setUpdatedTemplateRevision(UpdatedTemplateRevision.newBuilder().build())
            .setDeploymentProject("deploymentProject114323604")
            .addAllConnectionConfigs(new ArrayList<ConnectionConfig>())
            .setArtifactLocation(ArtifactLocation.newBuilder().build())
            .setType(ApplicationType.forNumber(0))
            .setDeploymentTarget(DeploymentTarget.newBuilder().build())
            .setCompositionType(ApplicationCompositionType.forNumber(0))
            .setCompositeApplicationParameters(CompositeApplicationParameters.newBuilder().build())
            .setDeploymentGroupMetadata(DeploymentGroupMetadata.newBuilder().build())
            .addAllRolesApisConfig(new ArrayList<RolesAndApisConfig>())
            .setTemplateMetadata(TFBlueprintMetadata.newBuilder().build())
            .setIacSource(IACSource.forNumber(0))
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-4448/locations/location-4448/spaces/space-4448/applications/application-4448";

    Application actualResponse = client.getApplication(name);
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
  public void getApplicationExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-4448/locations/location-4448/spaces/space-4448/applications/application-4448";
      client.getApplication(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listApplicationsTest() throws Exception {
    Application responsesElement = Application.newBuilder().build();
    ListApplicationsResponse expectedResponse =
        ListApplicationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllApplications(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    SpaceName parent = SpaceName.of("[PROJECT]", "[LOCATION]", "[SPACE]");

    ListApplicationsPagedResponse pagedListResponse = client.listApplications(parent);

    List<Application> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getApplicationsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listApplicationsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SpaceName parent = SpaceName.of("[PROJECT]", "[LOCATION]", "[SPACE]");
      client.listApplications(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listApplicationsTest2() throws Exception {
    Application responsesElement = Application.newBuilder().build();
    ListApplicationsResponse expectedResponse =
        ListApplicationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllApplications(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-2462/locations/location-2462/spaces/space-2462";

    ListApplicationsPagedResponse pagedListResponse = client.listApplications(parent);

    List<Application> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getApplicationsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listApplicationsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-2462/locations/location-2462/spaces/space-2462";
      client.listApplications(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateApplicationTest() throws Exception {
    Application expectedResponse =
        Application.newBuilder()
            .setName(
                ApplicationName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setSource(DeploymentSource.newBuilder().build())
            .addAllAppParameters(new ArrayList<Parameter>())
            .addAllComponentParameters(new ArrayList<ComponentParameters>())
            .setServiceAccount("serviceAccount1079137720")
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setAttributes(Attributes.newBuilder().build())
            .setScope(Scope.newBuilder().build())
            .setImportExistingResources(true)
            .setPreviewReference("previewReference1962163299")
            .setDeploymentRevision("deploymentRevision-13024832")
            .setApphubApplication("apphubApplication104302972")
            .setSerializedApplicationTemplate(SerializedApplicationTemplate.newBuilder().build())
            .setDeploymentMetadata(DeploymentMetadata.newBuilder().build())
            .addAllProjectParameters(new ArrayList<ProjectParameters>())
            .setDeploymentRegion("deploymentRegion1711269401")
            .setUpdatedTemplateRevision(UpdatedTemplateRevision.newBuilder().build())
            .setDeploymentProject("deploymentProject114323604")
            .addAllConnectionConfigs(new ArrayList<ConnectionConfig>())
            .setArtifactLocation(ArtifactLocation.newBuilder().build())
            .setType(ApplicationType.forNumber(0))
            .setDeploymentTarget(DeploymentTarget.newBuilder().build())
            .setCompositionType(ApplicationCompositionType.forNumber(0))
            .setCompositeApplicationParameters(CompositeApplicationParameters.newBuilder().build())
            .setDeploymentGroupMetadata(DeploymentGroupMetadata.newBuilder().build())
            .addAllRolesApisConfig(new ArrayList<RolesAndApisConfig>())
            .setTemplateMetadata(TFBlueprintMetadata.newBuilder().build())
            .setIacSource(IACSource.forNumber(0))
            .build();
    mockService.addResponse(expectedResponse);

    Application application =
        Application.newBuilder()
            .setName(
                ApplicationName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setSource(DeploymentSource.newBuilder().build())
            .addAllAppParameters(new ArrayList<Parameter>())
            .addAllComponentParameters(new ArrayList<ComponentParameters>())
            .setServiceAccount("serviceAccount1079137720")
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setAttributes(Attributes.newBuilder().build())
            .setScope(Scope.newBuilder().build())
            .setImportExistingResources(true)
            .setPreviewReference("previewReference1962163299")
            .setDeploymentRevision("deploymentRevision-13024832")
            .setApphubApplication("apphubApplication104302972")
            .setSerializedApplicationTemplate(SerializedApplicationTemplate.newBuilder().build())
            .setDeploymentMetadata(DeploymentMetadata.newBuilder().build())
            .addAllProjectParameters(new ArrayList<ProjectParameters>())
            .setDeploymentRegion("deploymentRegion1711269401")
            .setUpdatedTemplateRevision(UpdatedTemplateRevision.newBuilder().build())
            .setDeploymentProject("deploymentProject114323604")
            .addAllConnectionConfigs(new ArrayList<ConnectionConfig>())
            .setArtifactLocation(ArtifactLocation.newBuilder().build())
            .setType(ApplicationType.forNumber(0))
            .setDeploymentTarget(DeploymentTarget.newBuilder().build())
            .setCompositionType(ApplicationCompositionType.forNumber(0))
            .setCompositeApplicationParameters(CompositeApplicationParameters.newBuilder().build())
            .setDeploymentGroupMetadata(DeploymentGroupMetadata.newBuilder().build())
            .addAllRolesApisConfig(new ArrayList<RolesAndApisConfig>())
            .setTemplateMetadata(TFBlueprintMetadata.newBuilder().build())
            .setIacSource(IACSource.forNumber(0))
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Application actualResponse = client.updateApplication(application, updateMask);
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
  public void updateApplicationExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Application application =
          Application.newBuilder()
              .setName(
                  ApplicationName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION]")
                      .toString())
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .setSource(DeploymentSource.newBuilder().build())
              .addAllAppParameters(new ArrayList<Parameter>())
              .addAllComponentParameters(new ArrayList<ComponentParameters>())
              .setServiceAccount("serviceAccount1079137720")
              .setDisplayName("displayName1714148973")
              .setDescription("description-1724546052")
              .setAttributes(Attributes.newBuilder().build())
              .setScope(Scope.newBuilder().build())
              .setImportExistingResources(true)
              .setPreviewReference("previewReference1962163299")
              .setDeploymentRevision("deploymentRevision-13024832")
              .setApphubApplication("apphubApplication104302972")
              .setSerializedApplicationTemplate(SerializedApplicationTemplate.newBuilder().build())
              .setDeploymentMetadata(DeploymentMetadata.newBuilder().build())
              .addAllProjectParameters(new ArrayList<ProjectParameters>())
              .setDeploymentRegion("deploymentRegion1711269401")
              .setUpdatedTemplateRevision(UpdatedTemplateRevision.newBuilder().build())
              .setDeploymentProject("deploymentProject114323604")
              .addAllConnectionConfigs(new ArrayList<ConnectionConfig>())
              .setArtifactLocation(ArtifactLocation.newBuilder().build())
              .setType(ApplicationType.forNumber(0))
              .setDeploymentTarget(DeploymentTarget.newBuilder().build())
              .setCompositionType(ApplicationCompositionType.forNumber(0))
              .setCompositeApplicationParameters(
                  CompositeApplicationParameters.newBuilder().build())
              .setDeploymentGroupMetadata(DeploymentGroupMetadata.newBuilder().build())
              .addAllRolesApisConfig(new ArrayList<RolesAndApisConfig>())
              .setTemplateMetadata(TFBlueprintMetadata.newBuilder().build())
              .setIacSource(IACSource.forNumber(0))
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateApplication(application, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteApplicationTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteApplicationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    ApplicationName name =
        ApplicationName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION]");

    client.deleteApplicationAsync(name).get();

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteApplicationExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ApplicationName name =
          ApplicationName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION]");
      client.deleteApplicationAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteApplicationTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteApplicationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name =
        "projects/project-4448/locations/location-4448/spaces/space-4448/applications/application-4448";

    client.deleteApplicationAsync(name).get();

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteApplicationExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-4448/locations/location-4448/spaces/space-4448/applications/application-4448";
      client.deleteApplicationAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deployApplicationTest() throws Exception {
    DeployApplicationResponse expectedResponse =
        DeployApplicationResponse.newBuilder()
            .setDeployment(Deployment.newBuilder().build())
            .setBuildId("buildId230943785")
            .setDeploymentGroup(DeploymentGroup.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deployApplicationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    ApplicationName name =
        ApplicationName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION]");

    DeployApplicationResponse actualResponse = client.deployApplicationAsync(name).get();
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
  public void deployApplicationExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ApplicationName name =
          ApplicationName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION]");
      client.deployApplicationAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deployApplicationTest2() throws Exception {
    DeployApplicationResponse expectedResponse =
        DeployApplicationResponse.newBuilder()
            .setDeployment(Deployment.newBuilder().build())
            .setBuildId("buildId230943785")
            .setDeploymentGroup(DeploymentGroup.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deployApplicationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name =
        "projects/project-4448/locations/location-4448/spaces/space-4448/applications/application-4448";

    DeployApplicationResponse actualResponse = client.deployApplicationAsync(name).get();
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
  public void deployApplicationExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-4448/locations/location-4448/spaces/space-4448/applications/application-4448";
      client.deployApplicationAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void previewApplicationTest() throws Exception {
    PreviewApplicationResponse expectedResponse =
        PreviewApplicationResponse.newBuilder()
            .setPreview(Preview.newBuilder().build())
            .setAssessmentReport(AssessmentReport.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("previewApplicationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    ApplicationName name =
        ApplicationName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION]");

    PreviewApplicationResponse actualResponse = client.previewApplicationAsync(name).get();
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
  public void previewApplicationExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ApplicationName name =
          ApplicationName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION]");
      client.previewApplicationAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void previewApplicationTest2() throws Exception {
    PreviewApplicationResponse expectedResponse =
        PreviewApplicationResponse.newBuilder()
            .setPreview(Preview.newBuilder().build())
            .setAssessmentReport(AssessmentReport.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("previewApplicationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name =
        "projects/project-4448/locations/location-4448/spaces/space-4448/applications/application-4448";

    PreviewApplicationResponse actualResponse = client.previewApplicationAsync(name).get();
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
  public void previewApplicationExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-4448/locations/location-4448/spaces/space-4448/applications/application-4448";
      client.previewApplicationAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void fetchApplicationAssessmentReportTest() throws Exception {
    FetchApplicationAssessmentReportResponse expectedResponse =
        FetchApplicationAssessmentReportResponse.newBuilder()
            .setAssessmentReport(AssessmentReport.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    ApplicationName name =
        ApplicationName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION]");

    FetchApplicationAssessmentReportResponse actualResponse =
        client.fetchApplicationAssessmentReport(name);
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
  public void fetchApplicationAssessmentReportExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ApplicationName name =
          ApplicationName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION]");
      client.fetchApplicationAssessmentReport(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void fetchApplicationAssessmentReportTest2() throws Exception {
    FetchApplicationAssessmentReportResponse expectedResponse =
        FetchApplicationAssessmentReportResponse.newBuilder()
            .setAssessmentReport(AssessmentReport.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-4448/locations/location-4448/spaces/space-4448/applications/application-4448";

    FetchApplicationAssessmentReportResponse actualResponse =
        client.fetchApplicationAssessmentReport(name);
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
  public void fetchApplicationAssessmentReportExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-4448/locations/location-4448/spaces/space-4448/applications/application-4448";
      client.fetchApplicationAssessmentReport(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void generateApplicationAssessmentReportTest() throws Exception {
    GenerateApplicationAssessmentReportResponse expectedResponse =
        GenerateApplicationAssessmentReportResponse.newBuilder()
            .setAssessmentReport(AssessmentReport.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("generateApplicationAssessmentReportTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    ApplicationName name =
        ApplicationName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION]");

    GenerateApplicationAssessmentReportResponse actualResponse =
        client.generateApplicationAssessmentReportAsync(name).get();
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
  public void generateApplicationAssessmentReportExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ApplicationName name =
          ApplicationName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION]");
      client.generateApplicationAssessmentReportAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void generateApplicationAssessmentReportTest2() throws Exception {
    GenerateApplicationAssessmentReportResponse expectedResponse =
        GenerateApplicationAssessmentReportResponse.newBuilder()
            .setAssessmentReport(AssessmentReport.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("generateApplicationAssessmentReportTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name =
        "projects/project-4448/locations/location-4448/spaces/space-4448/applications/application-4448";

    GenerateApplicationAssessmentReportResponse actualResponse =
        client.generateApplicationAssessmentReportAsync(name).get();
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
  public void generateApplicationAssessmentReportExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-4448/locations/location-4448/spaces/space-4448/applications/application-4448";
      client.generateApplicationAssessmentReportAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void generateApplicationTemplateAssessmentReportTest() throws Exception {
    GenerateApplicationTemplateAssessmentReportResponse expectedResponse =
        GenerateApplicationTemplateAssessmentReportResponse.newBuilder()
            .setPreview(Preview.newBuilder().build())
            .setAssessmentReport(AssessmentReport.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("generateApplicationTemplateAssessmentReportTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    ApplicationTemplateName name =
        ApplicationTemplateName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]");

    GenerateApplicationTemplateAssessmentReportResponse actualResponse =
        client.generateApplicationTemplateAssessmentReportAsync(name).get();
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
  public void generateApplicationTemplateAssessmentReportExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ApplicationTemplateName name =
          ApplicationTemplateName.of(
              "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]");
      client.generateApplicationTemplateAssessmentReportAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void generateApplicationTemplateAssessmentReportTest2() throws Exception {
    GenerateApplicationTemplateAssessmentReportResponse expectedResponse =
        GenerateApplicationTemplateAssessmentReportResponse.newBuilder()
            .setPreview(Preview.newBuilder().build())
            .setAssessmentReport(AssessmentReport.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("generateApplicationTemplateAssessmentReportTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name =
        "projects/project-2810/locations/location-2810/spaces/space-2810/applicationTemplates/applicationTemplate-2810";

    GenerateApplicationTemplateAssessmentReportResponse actualResponse =
        client.generateApplicationTemplateAssessmentReportAsync(name).get();
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
  public void generateApplicationTemplateAssessmentReportExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-2810/locations/location-2810/spaces/space-2810/applicationTemplates/applicationTemplate-2810";
      client.generateApplicationTemplateAssessmentReportAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void generateAssessmentReportTest() throws Exception {
    GenerateAssessmentReportResponse expectedResponse =
        GenerateAssessmentReportResponse.newBuilder()
            .setAssessmentReport(AssessmentReport.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("generateAssessmentReportTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    SpaceName spaceName = SpaceName.of("[PROJECT]", "[LOCATION]", "[SPACE]");

    GenerateAssessmentReportResponse actualResponse =
        client.generateAssessmentReportAsync(spaceName).get();
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
  public void generateAssessmentReportExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SpaceName spaceName = SpaceName.of("[PROJECT]", "[LOCATION]", "[SPACE]");
      client.generateAssessmentReportAsync(spaceName).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void generateAssessmentReportTest2() throws Exception {
    GenerateAssessmentReportResponse expectedResponse =
        GenerateAssessmentReportResponse.newBuilder()
            .setAssessmentReport(AssessmentReport.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("generateAssessmentReportTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String spaceName = "projects/project-1015/locations/location-1015/spaces/space-1015";

    GenerateAssessmentReportResponse actualResponse =
        client.generateAssessmentReportAsync(spaceName).get();
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
  public void generateAssessmentReportExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String spaceName = "projects/project-1015/locations/location-1015/spaces/space-1015";
      client.generateAssessmentReportAsync(spaceName).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void generateTerraformPlanAssessmentReportTest() throws Exception {
    GenerateTerraformPlanAssessmentReportResponse expectedResponse =
        GenerateTerraformPlanAssessmentReportResponse.newBuilder()
            .setAssessmentReport(AssessmentReport.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("generateTerraformPlanAssessmentReportTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    SpaceName name = SpaceName.of("[PROJECT]", "[LOCATION]", "[SPACE]");
    ByteString terraformPlan = ByteString.EMPTY;

    GenerateTerraformPlanAssessmentReportResponse actualResponse =
        client.generateTerraformPlanAssessmentReportAsync(name, terraformPlan).get();
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
  public void generateTerraformPlanAssessmentReportExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SpaceName name = SpaceName.of("[PROJECT]", "[LOCATION]", "[SPACE]");
      ByteString terraformPlan = ByteString.EMPTY;
      client.generateTerraformPlanAssessmentReportAsync(name, terraformPlan).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void generateTerraformPlanAssessmentReportTest2() throws Exception {
    GenerateTerraformPlanAssessmentReportResponse expectedResponse =
        GenerateTerraformPlanAssessmentReportResponse.newBuilder()
            .setAssessmentReport(AssessmentReport.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("generateTerraformPlanAssessmentReportTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name = "projects/project-1635/locations/location-1635/spaces/space-1635";
    ByteString terraformPlan = ByteString.EMPTY;

    GenerateTerraformPlanAssessmentReportResponse actualResponse =
        client.generateTerraformPlanAssessmentReportAsync(name, terraformPlan).get();
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
  public void generateTerraformPlanAssessmentReportExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-1635/locations/location-1635/spaces/space-1635";
      ByteString terraformPlan = ByteString.EMPTY;
      client.generateTerraformPlanAssessmentReportAsync(name, terraformPlan).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void getPolicyTest() throws Exception {
    com.google.cloud.designcenter.v1.Policy expectedResponse =
        com.google.cloud.designcenter.v1.Policy.newBuilder()
            .setName(
                PolicyName.of(
                        "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]", "[POLICY]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllApplyConditions(new ArrayList<ApplyCondition>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllCloudControlConfigs(new ArrayList<CloudControlConfig>())
            .build();
    mockService.addResponse(expectedResponse);

    PolicyName name =
        PolicyName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]", "[POLICY]");

    com.google.cloud.designcenter.v1.Policy actualResponse = client.getPolicy(name);
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
  public void getPolicyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PolicyName name =
          PolicyName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]", "[POLICY]");
      client.getPolicy(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getPolicyTest2() throws Exception {
    com.google.cloud.designcenter.v1.Policy expectedResponse =
        com.google.cloud.designcenter.v1.Policy.newBuilder()
            .setName(
                PolicyName.of(
                        "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]", "[POLICY]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllApplyConditions(new ArrayList<ApplyCondition>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllCloudControlConfigs(new ArrayList<CloudControlConfig>())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-740/locations/location-740/spaces/space-740/applicationTemplates/applicationTemplate-740/policies/policie-740";

    com.google.cloud.designcenter.v1.Policy actualResponse = client.getPolicy(name);
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
  public void getPolicyExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-740/locations/location-740/spaces/space-740/applicationTemplates/applicationTemplate-740/policies/policie-740";
      client.getPolicy(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listPoliciesTest() throws Exception {
    com.google.cloud.designcenter.v1.Policy responsesElement =
        com.google.cloud.designcenter.v1.Policy.newBuilder().build();
    ListPoliciesResponse expectedResponse =
        ListPoliciesResponse.newBuilder()
            .setNextPageToken("")
            .addAllPolicies(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    ApplicationTemplateName parent =
        ApplicationTemplateName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]");

    ListPoliciesPagedResponse pagedListResponse = client.listPolicies(parent);

    List<com.google.cloud.designcenter.v1.Policy> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPoliciesList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listPoliciesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ApplicationTemplateName parent =
          ApplicationTemplateName.of(
              "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]");
      client.listPolicies(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listPoliciesTest2() throws Exception {
    com.google.cloud.designcenter.v1.Policy responsesElement =
        com.google.cloud.designcenter.v1.Policy.newBuilder().build();
    ListPoliciesResponse expectedResponse =
        ListPoliciesResponse.newBuilder()
            .setNextPageToken("")
            .addAllPolicies(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent =
        "projects/project-9797/locations/location-9797/spaces/space-9797/applicationTemplates/applicationTemplate-9797";

    ListPoliciesPagedResponse pagedListResponse = client.listPolicies(parent);

    List<com.google.cloud.designcenter.v1.Policy> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPoliciesList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listPoliciesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-9797/locations/location-9797/spaces/space-9797/applicationTemplates/applicationTemplate-9797";
      client.listPolicies(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createPolicyTest() throws Exception {
    com.google.cloud.designcenter.v1.Policy expectedResponse =
        com.google.cloud.designcenter.v1.Policy.newBuilder()
            .setName(
                PolicyName.of(
                        "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]", "[POLICY]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllApplyConditions(new ArrayList<ApplyCondition>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllCloudControlConfigs(new ArrayList<CloudControlConfig>())
            .build();
    mockService.addResponse(expectedResponse);

    ApplicationTemplateName parent =
        ApplicationTemplateName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]");
    com.google.cloud.designcenter.v1.Policy policy =
        com.google.cloud.designcenter.v1.Policy.newBuilder().build();
    String policyId = "policyId546908653";

    com.google.cloud.designcenter.v1.Policy actualResponse =
        client.createPolicy(parent, policy, policyId);
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
  public void createPolicyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ApplicationTemplateName parent =
          ApplicationTemplateName.of(
              "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]");
      com.google.cloud.designcenter.v1.Policy policy =
          com.google.cloud.designcenter.v1.Policy.newBuilder().build();
      String policyId = "policyId546908653";
      client.createPolicy(parent, policy, policyId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createPolicyTest2() throws Exception {
    com.google.cloud.designcenter.v1.Policy expectedResponse =
        com.google.cloud.designcenter.v1.Policy.newBuilder()
            .setName(
                PolicyName.of(
                        "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]", "[POLICY]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllApplyConditions(new ArrayList<ApplyCondition>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllCloudControlConfigs(new ArrayList<CloudControlConfig>())
            .build();
    mockService.addResponse(expectedResponse);

    String parent =
        "projects/project-9797/locations/location-9797/spaces/space-9797/applicationTemplates/applicationTemplate-9797";
    com.google.cloud.designcenter.v1.Policy policy =
        com.google.cloud.designcenter.v1.Policy.newBuilder().build();
    String policyId = "policyId546908653";

    com.google.cloud.designcenter.v1.Policy actualResponse =
        client.createPolicy(parent, policy, policyId);
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
  public void createPolicyExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-9797/locations/location-9797/spaces/space-9797/applicationTemplates/applicationTemplate-9797";
      com.google.cloud.designcenter.v1.Policy policy =
          com.google.cloud.designcenter.v1.Policy.newBuilder().build();
      String policyId = "policyId546908653";
      client.createPolicy(parent, policy, policyId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updatePolicyTest() throws Exception {
    com.google.cloud.designcenter.v1.Policy expectedResponse =
        com.google.cloud.designcenter.v1.Policy.newBuilder()
            .setName(
                PolicyName.of(
                        "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]", "[POLICY]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllApplyConditions(new ArrayList<ApplyCondition>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllCloudControlConfigs(new ArrayList<CloudControlConfig>())
            .build();
    mockService.addResponse(expectedResponse);

    com.google.cloud.designcenter.v1.Policy policy =
        com.google.cloud.designcenter.v1.Policy.newBuilder()
            .setName(
                PolicyName.of(
                        "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]", "[POLICY]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllApplyConditions(new ArrayList<ApplyCondition>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllCloudControlConfigs(new ArrayList<CloudControlConfig>())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    com.google.cloud.designcenter.v1.Policy actualResponse =
        client.updatePolicy(policy, updateMask);
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
  public void updatePolicyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      com.google.cloud.designcenter.v1.Policy policy =
          com.google.cloud.designcenter.v1.Policy.newBuilder()
              .setName(
                  PolicyName.of(
                          "[PROJECT]",
                          "[LOCATION]",
                          "[SPACE]",
                          "[APPLICATION_TEMPLATE]",
                          "[POLICY]")
                      .toString())
              .setDisplayName("displayName1714148973")
              .setDescription("description-1724546052")
              .addAllApplyConditions(new ArrayList<ApplyCondition>())
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .addAllCloudControlConfigs(new ArrayList<CloudControlConfig>())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updatePolicy(policy, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deletePolicyTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    PolicyName name =
        PolicyName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]", "[POLICY]");

    client.deletePolicy(name);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deletePolicyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PolicyName name =
          PolicyName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]", "[POLICY]");
      client.deletePolicy(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deletePolicyTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-740/locations/location-740/spaces/space-740/applicationTemplates/applicationTemplate-740/policies/policie-740";

    client.deletePolicy(name);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deletePolicyExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-740/locations/location-740/spaces/space-740/applicationTemplates/applicationTemplate-740/policies/policie-740";
      client.deletePolicy(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void fetchFrameworksTest() throws Exception {
    Framework responsesElement = Framework.newBuilder().build();
    FetchFrameworksResponse expectedResponse =
        FetchFrameworksResponse.newBuilder()
            .setNextPageToken("")
            .addAllFrameworks(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    FetchFrameworksPagedResponse pagedListResponse = client.fetchFrameworks(parent);

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
  public void fetchFrameworksExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.fetchFrameworks(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void generateApplicationIaCTest() throws Exception {
    GenerateApplicationIaCResponse expectedResponse =
        GenerateApplicationIaCResponse.newBuilder()
            .setGcsUri("gcsUri-1251224875")
            .setArtifactLocation(ArtifactLocation.newBuilder().build())
            .setRootModulesMetadata(RootModulesMetadata.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    ApplicationName name =
        ApplicationName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION]");

    GenerateApplicationIaCResponse actualResponse = client.generateApplicationIaC(name);
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
  public void generateApplicationIaCExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ApplicationName name =
          ApplicationName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION]");
      client.generateApplicationIaC(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void generateApplicationIaCTest2() throws Exception {
    GenerateApplicationIaCResponse expectedResponse =
        GenerateApplicationIaCResponse.newBuilder()
            .setGcsUri("gcsUri-1251224875")
            .setArtifactLocation(ArtifactLocation.newBuilder().build())
            .setRootModulesMetadata(RootModulesMetadata.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-4448/locations/location-4448/spaces/space-4448/applications/application-4448";

    GenerateApplicationIaCResponse actualResponse = client.generateApplicationIaC(name);
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
  public void generateApplicationIaCExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-4448/locations/location-4448/spaces/space-4448/applications/application-4448";
      client.generateApplicationIaC(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void exportApplicationIaCTest() throws Exception {
    ExportApplicationIaCResponse expectedResponse =
        ExportApplicationIaCResponse.newBuilder()
            .setArtifactLocation(ArtifactLocation.newBuilder().build())
            .setRootModulesMetadata(RootModulesMetadata.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("exportApplicationIaCTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    ApplicationName name =
        ApplicationName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION]");

    ExportApplicationIaCResponse actualResponse = client.exportApplicationIaCAsync(name).get();
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
  public void exportApplicationIaCExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ApplicationName name =
          ApplicationName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION]");
      client.exportApplicationIaCAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void exportApplicationIaCTest2() throws Exception {
    ExportApplicationIaCResponse expectedResponse =
        ExportApplicationIaCResponse.newBuilder()
            .setArtifactLocation(ArtifactLocation.newBuilder().build())
            .setRootModulesMetadata(RootModulesMetadata.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("exportApplicationIaCTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name =
        "projects/project-4448/locations/location-4448/spaces/space-4448/applications/application-4448";

    ExportApplicationIaCResponse actualResponse = client.exportApplicationIaCAsync(name).get();
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
  public void exportApplicationIaCExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-4448/locations/location-4448/spaces/space-4448/applications/application-4448";
      client.exportApplicationIaCAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void importApplicationTemplateIaCTest() throws Exception {
    ImportApplicationTemplateIaCResponse expectedResponse =
        ImportApplicationTemplateIaCResponse.newBuilder()
            .setApplicationTemplate(ApplicationTemplate.newBuilder().build())
            .addAllErrors(new ArrayList<ImportIaCError>())
            .build();
    mockService.addResponse(expectedResponse);

    ApplicationTemplateName name =
        ApplicationTemplateName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]");

    ImportApplicationTemplateIaCResponse actualResponse = client.importApplicationTemplateIaC(name);
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
  public void importApplicationTemplateIaCExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ApplicationTemplateName name =
          ApplicationTemplateName.of(
              "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]");
      client.importApplicationTemplateIaC(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void importApplicationTemplateIaCTest2() throws Exception {
    ImportApplicationTemplateIaCResponse expectedResponse =
        ImportApplicationTemplateIaCResponse.newBuilder()
            .setApplicationTemplate(ApplicationTemplate.newBuilder().build())
            .addAllErrors(new ArrayList<ImportIaCError>())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-2810/locations/location-2810/spaces/space-2810/applicationTemplates/applicationTemplate-2810";

    ImportApplicationTemplateIaCResponse actualResponse = client.importApplicationTemplateIaC(name);
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
  public void importApplicationTemplateIaCExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-2810/locations/location-2810/spaces/space-2810/applicationTemplates/applicationTemplate-2810";
      client.importApplicationTemplateIaC(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void ingestApplicationTemplateIaCTest() throws Exception {
    IngestApplicationTemplateIaCResponse expectedResponse =
        IngestApplicationTemplateIaCResponse.newBuilder()
            .setApplicationTemplate(ApplicationTemplate.newBuilder().build())
            .addAllErrors(new ArrayList<ImportIaCError>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("ingestApplicationTemplateIaCTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    ApplicationTemplateName name =
        ApplicationTemplateName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]");

    IngestApplicationTemplateIaCResponse actualResponse =
        client.ingestApplicationTemplateIaCAsync(name).get();
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
  public void ingestApplicationTemplateIaCExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ApplicationTemplateName name =
          ApplicationTemplateName.of(
              "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]");
      client.ingestApplicationTemplateIaCAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void ingestApplicationTemplateIaCTest2() throws Exception {
    IngestApplicationTemplateIaCResponse expectedResponse =
        IngestApplicationTemplateIaCResponse.newBuilder()
            .setApplicationTemplate(ApplicationTemplate.newBuilder().build())
            .addAllErrors(new ArrayList<ImportIaCError>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("ingestApplicationTemplateIaCTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name =
        "projects/project-2810/locations/location-2810/spaces/space-2810/applicationTemplates/applicationTemplate-2810";

    IngestApplicationTemplateIaCResponse actualResponse =
        client.ingestApplicationTemplateIaCAsync(name).get();
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
  public void ingestApplicationTemplateIaCExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-2810/locations/location-2810/spaces/space-2810/applicationTemplates/applicationTemplate-2810";
      client.ingestApplicationTemplateIaCAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void importApplicationIaCTest() throws Exception {
    ImportApplicationIaCResponse expectedResponse =
        ImportApplicationIaCResponse.newBuilder()
            .setApplication(Application.newBuilder().build())
            .addAllErrors(new ArrayList<ImportIaCError>())
            .build();
    mockService.addResponse(expectedResponse);

    ApplicationName name =
        ApplicationName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION]");

    ImportApplicationIaCResponse actualResponse = client.importApplicationIaC(name);
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
  public void importApplicationIaCExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ApplicationName name =
          ApplicationName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION]");
      client.importApplicationIaC(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void importApplicationIaCTest2() throws Exception {
    ImportApplicationIaCResponse expectedResponse =
        ImportApplicationIaCResponse.newBuilder()
            .setApplication(Application.newBuilder().build())
            .addAllErrors(new ArrayList<ImportIaCError>())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-4448/locations/location-4448/spaces/space-4448/applications/application-4448";

    ImportApplicationIaCResponse actualResponse = client.importApplicationIaC(name);
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
  public void importApplicationIaCExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-4448/locations/location-4448/spaces/space-4448/applications/application-4448";
      client.importApplicationIaC(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void registerAppHubApplicationResourcesTest() throws Exception {
    RegisterAppHubApplicationResourcesResponse expectedResponse =
        RegisterAppHubApplicationResourcesResponse.newBuilder()
            .setResponse(DeployedResourceResponse.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("registerAppHubApplicationResourcesTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    String apphubApplication = "apphubApplication104302972";
    String tfstateContent = "tfstateContent-1547770342";

    RegisterAppHubApplicationResourcesResponse actualResponse =
        client
            .registerAppHubApplicationResourcesAsync(parent, apphubApplication, tfstateContent)
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
  public void registerAppHubApplicationResourcesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      String apphubApplication = "apphubApplication104302972";
      String tfstateContent = "tfstateContent-1547770342";
      client
          .registerAppHubApplicationResourcesAsync(parent, apphubApplication, tfstateContent)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void registerAppHubApplicationResourcesTest2() throws Exception {
    RegisterAppHubApplicationResourcesResponse expectedResponse =
        RegisterAppHubApplicationResourcesResponse.newBuilder()
            .setResponse(DeployedResourceResponse.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("registerAppHubApplicationResourcesTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5833/locations/location-5833";
    String apphubApplication = "apphubApplication104302972";
    String tfstateContent = "tfstateContent-1547770342";

    RegisterAppHubApplicationResourcesResponse actualResponse =
        client
            .registerAppHubApplicationResourcesAsync(parent, apphubApplication, tfstateContent)
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
  public void registerAppHubApplicationResourcesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      String apphubApplication = "apphubApplication104302972";
      String tfstateContent = "tfstateContent-1547770342";
      client
          .registerAppHubApplicationResourcesAsync(parent, apphubApplication, tfstateContent)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void listApplicationTemplateSystemRevisionsTest() throws Exception {
    ApplicationTemplateSystemRevision responsesElement =
        ApplicationTemplateSystemRevision.newBuilder().build();
    ListApplicationTemplateSystemRevisionsResponse expectedResponse =
        ListApplicationTemplateSystemRevisionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllApplicationTemplateSystemRevisions(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    ApplicationTemplateName parent =
        ApplicationTemplateName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]");

    ListApplicationTemplateSystemRevisionsPagedResponse pagedListResponse =
        client.listApplicationTemplateSystemRevisions(parent);

    List<ApplicationTemplateSystemRevision> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getApplicationTemplateSystemRevisionsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listApplicationTemplateSystemRevisionsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ApplicationTemplateName parent =
          ApplicationTemplateName.of(
              "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]");
      client.listApplicationTemplateSystemRevisions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listApplicationTemplateSystemRevisionsTest2() throws Exception {
    ApplicationTemplateSystemRevision responsesElement =
        ApplicationTemplateSystemRevision.newBuilder().build();
    ListApplicationTemplateSystemRevisionsResponse expectedResponse =
        ListApplicationTemplateSystemRevisionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllApplicationTemplateSystemRevisions(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent =
        "projects/project-9797/locations/location-9797/spaces/space-9797/applicationTemplates/applicationTemplate-9797";

    ListApplicationTemplateSystemRevisionsPagedResponse pagedListResponse =
        client.listApplicationTemplateSystemRevisions(parent);

    List<ApplicationTemplateSystemRevision> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getApplicationTemplateSystemRevisionsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listApplicationTemplateSystemRevisionsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-9797/locations/location-9797/spaces/space-9797/applicationTemplates/applicationTemplate-9797";
      client.listApplicationTemplateSystemRevisions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getApplicationTemplateSystemRevisionTest() throws Exception {
    ApplicationTemplateSystemRevision expectedResponse =
        ApplicationTemplateSystemRevision.newBuilder()
            .setName(
                ApplicationTemplateSystemRevisionName.of(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[SPACE]",
                        "[APPLICATION_TEMPLATE]",
                        "[SYSTEM_REVISION]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .putAllAnnotations(new HashMap<String, String>())
            .setSnapshot(SerializedApplicationTemplate.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    ApplicationTemplateSystemRevisionName name =
        ApplicationTemplateSystemRevisionName.of(
            "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]", "[SYSTEM_REVISION]");

    ApplicationTemplateSystemRevision actualResponse =
        client.getApplicationTemplateSystemRevision(name);
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
  public void getApplicationTemplateSystemRevisionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ApplicationTemplateSystemRevisionName name =
          ApplicationTemplateSystemRevisionName.of(
              "[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION_TEMPLATE]", "[SYSTEM_REVISION]");
      client.getApplicationTemplateSystemRevision(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getApplicationTemplateSystemRevisionTest2() throws Exception {
    ApplicationTemplateSystemRevision expectedResponse =
        ApplicationTemplateSystemRevision.newBuilder()
            .setName(
                ApplicationTemplateSystemRevisionName.of(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[SPACE]",
                        "[APPLICATION_TEMPLATE]",
                        "[SYSTEM_REVISION]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .putAllAnnotations(new HashMap<String, String>())
            .setSnapshot(SerializedApplicationTemplate.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-4133/locations/location-4133/spaces/space-4133/applicationTemplates/applicationTemplate-4133/systemRevisions/systemRevision-4133";

    ApplicationTemplateSystemRevision actualResponse =
        client.getApplicationTemplateSystemRevision(name);
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
  public void getApplicationTemplateSystemRevisionExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-4133/locations/location-4133/spaces/space-4133/applicationTemplates/applicationTemplate-4133/systemRevisions/systemRevision-4133";
      client.getApplicationTemplateSystemRevision(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void recommendIAMRolesTest() throws Exception {
    RecommendIAMRolesResponse expectedResponse =
        RecommendIAMRolesResponse.newBuilder()
            .addAllProjectConfigurations(new ArrayList<RolesAndApisConfig>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("recommendIAMRolesTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    ApplicationName name =
        ApplicationName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION]");

    RecommendIAMRolesResponse actualResponse = client.recommendIAMRolesAsync(name).get();
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
  public void recommendIAMRolesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ApplicationName name =
          ApplicationName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION]");
      client.recommendIAMRolesAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void recommendIAMRolesTest2() throws Exception {
    RecommendIAMRolesResponse expectedResponse =
        RecommendIAMRolesResponse.newBuilder()
            .addAllProjectConfigurations(new ArrayList<RolesAndApisConfig>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("recommendIAMRolesTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name =
        "projects/project-4448/locations/location-4448/spaces/space-4448/applications/application-4448";

    RecommendIAMRolesResponse actualResponse = client.recommendIAMRolesAsync(name).get();
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
  public void recommendIAMRolesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-4448/locations/location-4448/spaces/space-4448/applications/application-4448";
      client.recommendIAMRolesAsync(name).get();
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
            .setResource(SpaceName.of("[PROJECT]", "[LOCATION]", "[SPACE]").toString())
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
              .setResource(SpaceName.of("[PROJECT]", "[LOCATION]", "[SPACE]").toString())
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
            .setResource(SpaceName.of("[PROJECT]", "[LOCATION]", "[SPACE]").toString())
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
              .setResource(SpaceName.of("[PROJECT]", "[LOCATION]", "[SPACE]").toString())
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
            .setResource(SpaceName.of("[PROJECT]", "[LOCATION]", "[SPACE]").toString())
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
              .setResource(SpaceName.of("[PROJECT]", "[LOCATION]", "[SPACE]").toString())
              .addAllPermissions(new ArrayList<String>())
              .build();
      client.testIamPermissions(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
