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

package com.google.cloud.dlp.v2;

import static com.google.cloud.dlp.v2.DlpServiceClient.ListDeidentifyTemplatesPagedResponse;
import static com.google.cloud.dlp.v2.DlpServiceClient.ListDlpJobsPagedResponse;
import static com.google.cloud.dlp.v2.DlpServiceClient.ListInspectTemplatesPagedResponse;
import static com.google.cloud.dlp.v2.DlpServiceClient.ListJobTriggersPagedResponse;
import static com.google.cloud.dlp.v2.DlpServiceClient.ListStoredInfoTypesPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.dlp.v2.stub.HttpJsonDlpServiceStub;
import com.google.common.collect.Lists;
import com.google.privacy.dlp.v2.ActivateJobTriggerRequest;
import com.google.privacy.dlp.v2.ByteContentItem;
import com.google.privacy.dlp.v2.CancelDlpJobRequest;
import com.google.privacy.dlp.v2.ContentItem;
import com.google.privacy.dlp.v2.DeidentifyConfig;
import com.google.privacy.dlp.v2.DeidentifyContentRequest;
import com.google.privacy.dlp.v2.DeidentifyContentResponse;
import com.google.privacy.dlp.v2.DeidentifyTemplate;
import com.google.privacy.dlp.v2.DeidentifyTemplateName;
import com.google.privacy.dlp.v2.DlpJob;
import com.google.privacy.dlp.v2.DlpJobName;
import com.google.privacy.dlp.v2.DlpJobType;
import com.google.privacy.dlp.v2.Error;
import com.google.privacy.dlp.v2.FinishDlpJobRequest;
import com.google.privacy.dlp.v2.HybridInspectResponse;
import com.google.privacy.dlp.v2.InfoTypeDescription;
import com.google.privacy.dlp.v2.InspectConfig;
import com.google.privacy.dlp.v2.InspectContentRequest;
import com.google.privacy.dlp.v2.InspectContentResponse;
import com.google.privacy.dlp.v2.InspectJobConfig;
import com.google.privacy.dlp.v2.InspectResult;
import com.google.privacy.dlp.v2.InspectTemplate;
import com.google.privacy.dlp.v2.InspectTemplateName;
import com.google.privacy.dlp.v2.JobTrigger;
import com.google.privacy.dlp.v2.JobTriggerName;
import com.google.privacy.dlp.v2.ListDeidentifyTemplatesResponse;
import com.google.privacy.dlp.v2.ListDlpJobsResponse;
import com.google.privacy.dlp.v2.ListInfoTypesResponse;
import com.google.privacy.dlp.v2.ListInspectTemplatesResponse;
import com.google.privacy.dlp.v2.ListJobTriggersResponse;
import com.google.privacy.dlp.v2.ListStoredInfoTypesResponse;
import com.google.privacy.dlp.v2.LocationName;
import com.google.privacy.dlp.v2.OrganizationLocationName;
import com.google.privacy.dlp.v2.OrganizationName;
import com.google.privacy.dlp.v2.ProjectName;
import com.google.privacy.dlp.v2.RedactImageRequest;
import com.google.privacy.dlp.v2.RedactImageResponse;
import com.google.privacy.dlp.v2.ReidentifyContentRequest;
import com.google.privacy.dlp.v2.ReidentifyContentResponse;
import com.google.privacy.dlp.v2.RiskAnalysisJobConfig;
import com.google.privacy.dlp.v2.StoredInfoType;
import com.google.privacy.dlp.v2.StoredInfoTypeConfig;
import com.google.privacy.dlp.v2.StoredInfoTypeName;
import com.google.privacy.dlp.v2.StoredInfoTypeVersion;
import com.google.privacy.dlp.v2.TransformationOverview;
import com.google.protobuf.ByteString;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class DlpServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static DlpServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonDlpServiceStub.getMethodDescriptors(), DlpServiceSettings.getDefaultEndpoint());
    DlpServiceSettings settings =
        DlpServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                DlpServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = DlpServiceClient.create(settings);
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
  public void inspectContentTest() throws Exception {
    InspectContentResponse expectedResponse =
        InspectContentResponse.newBuilder().setResult(InspectResult.newBuilder().build()).build();
    mockService.addResponse(expectedResponse);

    InspectContentRequest request =
        InspectContentRequest.newBuilder()
            .setParent(ProjectName.of("[PROJECT]").toString())
            .setInspectConfig(InspectConfig.newBuilder().build())
            .setItem(ContentItem.newBuilder().build())
            .setInspectTemplateName("inspectTemplateName1828857433")
            .setLocationId("locationId1541836720")
            .build();

    InspectContentResponse actualResponse = client.inspectContent(request);
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
  public void inspectContentExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      InspectContentRequest request =
          InspectContentRequest.newBuilder()
              .setParent(ProjectName.of("[PROJECT]").toString())
              .setInspectConfig(InspectConfig.newBuilder().build())
              .setItem(ContentItem.newBuilder().build())
              .setInspectTemplateName("inspectTemplateName1828857433")
              .setLocationId("locationId1541836720")
              .build();
      client.inspectContent(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void redactImageTest() throws Exception {
    RedactImageResponse expectedResponse =
        RedactImageResponse.newBuilder()
            .setRedactedImage(ByteString.EMPTY)
            .setExtractedText("extractedText-106686931")
            .setInspectResult(InspectResult.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    RedactImageRequest request =
        RedactImageRequest.newBuilder()
            .setParent(ProjectName.of("[PROJECT]").toString())
            .setLocationId("locationId1541836720")
            .setInspectConfig(InspectConfig.newBuilder().build())
            .addAllImageRedactionConfigs(new ArrayList<RedactImageRequest.ImageRedactionConfig>())
            .setIncludeFindings(true)
            .setByteItem(ByteContentItem.newBuilder().build())
            .build();

    RedactImageResponse actualResponse = client.redactImage(request);
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
  public void redactImageExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      RedactImageRequest request =
          RedactImageRequest.newBuilder()
              .setParent(ProjectName.of("[PROJECT]").toString())
              .setLocationId("locationId1541836720")
              .setInspectConfig(InspectConfig.newBuilder().build())
              .addAllImageRedactionConfigs(new ArrayList<RedactImageRequest.ImageRedactionConfig>())
              .setIncludeFindings(true)
              .setByteItem(ByteContentItem.newBuilder().build())
              .build();
      client.redactImage(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deidentifyContentTest() throws Exception {
    DeidentifyContentResponse expectedResponse =
        DeidentifyContentResponse.newBuilder()
            .setItem(ContentItem.newBuilder().build())
            .setOverview(TransformationOverview.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    DeidentifyContentRequest request =
        DeidentifyContentRequest.newBuilder()
            .setParent(ProjectName.of("[PROJECT]").toString())
            .setDeidentifyConfig(DeidentifyConfig.newBuilder().build())
            .setInspectConfig(InspectConfig.newBuilder().build())
            .setItem(ContentItem.newBuilder().build())
            .setInspectTemplateName("inspectTemplateName1828857433")
            .setDeidentifyTemplateName("deidentifyTemplateName-1374666414")
            .setLocationId("locationId1541836720")
            .build();

    DeidentifyContentResponse actualResponse = client.deidentifyContent(request);
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
  public void deidentifyContentExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DeidentifyContentRequest request =
          DeidentifyContentRequest.newBuilder()
              .setParent(ProjectName.of("[PROJECT]").toString())
              .setDeidentifyConfig(DeidentifyConfig.newBuilder().build())
              .setInspectConfig(InspectConfig.newBuilder().build())
              .setItem(ContentItem.newBuilder().build())
              .setInspectTemplateName("inspectTemplateName1828857433")
              .setDeidentifyTemplateName("deidentifyTemplateName-1374666414")
              .setLocationId("locationId1541836720")
              .build();
      client.deidentifyContent(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void reidentifyContentTest() throws Exception {
    ReidentifyContentResponse expectedResponse =
        ReidentifyContentResponse.newBuilder()
            .setItem(ContentItem.newBuilder().build())
            .setOverview(TransformationOverview.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    ReidentifyContentRequest request =
        ReidentifyContentRequest.newBuilder()
            .setParent(ProjectName.of("[PROJECT]").toString())
            .setReidentifyConfig(DeidentifyConfig.newBuilder().build())
            .setInspectConfig(InspectConfig.newBuilder().build())
            .setItem(ContentItem.newBuilder().build())
            .setInspectTemplateName("inspectTemplateName1828857433")
            .setReidentifyTemplateName("reidentifyTemplateName157316612")
            .setLocationId("locationId1541836720")
            .build();

    ReidentifyContentResponse actualResponse = client.reidentifyContent(request);
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
  public void reidentifyContentExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ReidentifyContentRequest request =
          ReidentifyContentRequest.newBuilder()
              .setParent(ProjectName.of("[PROJECT]").toString())
              .setReidentifyConfig(DeidentifyConfig.newBuilder().build())
              .setInspectConfig(InspectConfig.newBuilder().build())
              .setItem(ContentItem.newBuilder().build())
              .setInspectTemplateName("inspectTemplateName1828857433")
              .setReidentifyTemplateName("reidentifyTemplateName157316612")
              .setLocationId("locationId1541836720")
              .build();
      client.reidentifyContent(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listInfoTypesTest() throws Exception {
    ListInfoTypesResponse expectedResponse =
        ListInfoTypesResponse.newBuilder()
            .addAllInfoTypes(new ArrayList<InfoTypeDescription>())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListInfoTypesResponse actualResponse = client.listInfoTypes(parent);
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
  public void listInfoTypesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listInfoTypes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createInspectTemplateTest() throws Exception {
    InspectTemplate expectedResponse =
        InspectTemplate.newBuilder()
            .setName(
                InspectTemplateName.ofOrganizationInspectTemplateName(
                        "[ORGANIZATION]", "[INSPECT_TEMPLATE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setInspectConfig(InspectConfig.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    InspectTemplate inspectTemplate = InspectTemplate.newBuilder().build();

    InspectTemplate actualResponse = client.createInspectTemplate(parent, inspectTemplate);
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
  public void createInspectTemplateExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      InspectTemplate inspectTemplate = InspectTemplate.newBuilder().build();
      client.createInspectTemplate(parent, inspectTemplate);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createInspectTemplateTest2() throws Exception {
    InspectTemplate expectedResponse =
        InspectTemplate.newBuilder()
            .setName(
                InspectTemplateName.ofOrganizationInspectTemplateName(
                        "[ORGANIZATION]", "[INSPECT_TEMPLATE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setInspectConfig(InspectConfig.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
    InspectTemplate inspectTemplate = InspectTemplate.newBuilder().build();

    InspectTemplate actualResponse = client.createInspectTemplate(parent, inspectTemplate);
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
  public void createInspectTemplateExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
      InspectTemplate inspectTemplate = InspectTemplate.newBuilder().build();
      client.createInspectTemplate(parent, inspectTemplate);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createInspectTemplateTest3() throws Exception {
    InspectTemplate expectedResponse =
        InspectTemplate.newBuilder()
            .setName(
                InspectTemplateName.ofOrganizationInspectTemplateName(
                        "[ORGANIZATION]", "[INSPECT_TEMPLATE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setInspectConfig(InspectConfig.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
    InspectTemplate inspectTemplate = InspectTemplate.newBuilder().build();

    InspectTemplate actualResponse = client.createInspectTemplate(parent, inspectTemplate);
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
  public void createInspectTemplateExceptionTest3() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
      InspectTemplate inspectTemplate = InspectTemplate.newBuilder().build();
      client.createInspectTemplate(parent, inspectTemplate);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createInspectTemplateTest4() throws Exception {
    InspectTemplate expectedResponse =
        InspectTemplate.newBuilder()
            .setName(
                InspectTemplateName.ofOrganizationInspectTemplateName(
                        "[ORGANIZATION]", "[INSPECT_TEMPLATE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setInspectConfig(InspectConfig.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");
    InspectTemplate inspectTemplate = InspectTemplate.newBuilder().build();

    InspectTemplate actualResponse = client.createInspectTemplate(parent, inspectTemplate);
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
  public void createInspectTemplateExceptionTest4() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      InspectTemplate inspectTemplate = InspectTemplate.newBuilder().build();
      client.createInspectTemplate(parent, inspectTemplate);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createInspectTemplateTest5() throws Exception {
    InspectTemplate expectedResponse =
        InspectTemplate.newBuilder()
            .setName(
                InspectTemplateName.ofOrganizationInspectTemplateName(
                        "[ORGANIZATION]", "[INSPECT_TEMPLATE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setInspectConfig(InspectConfig.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "organizations/organization-8287";
    InspectTemplate inspectTemplate = InspectTemplate.newBuilder().build();

    InspectTemplate actualResponse = client.createInspectTemplate(parent, inspectTemplate);
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
  public void createInspectTemplateExceptionTest5() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "organizations/organization-8287";
      InspectTemplate inspectTemplate = InspectTemplate.newBuilder().build();
      client.createInspectTemplate(parent, inspectTemplate);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateInspectTemplateTest() throws Exception {
    InspectTemplate expectedResponse =
        InspectTemplate.newBuilder()
            .setName(
                InspectTemplateName.ofOrganizationInspectTemplateName(
                        "[ORGANIZATION]", "[INSPECT_TEMPLATE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setInspectConfig(InspectConfig.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    InspectTemplateName name =
        InspectTemplateName.ofOrganizationInspectTemplateName(
            "[ORGANIZATION]", "[INSPECT_TEMPLATE]");
    InspectTemplate inspectTemplate = InspectTemplate.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    InspectTemplate actualResponse =
        client.updateInspectTemplate(name, inspectTemplate, updateMask);
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
  public void updateInspectTemplateExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      InspectTemplateName name =
          InspectTemplateName.ofOrganizationInspectTemplateName(
              "[ORGANIZATION]", "[INSPECT_TEMPLATE]");
      InspectTemplate inspectTemplate = InspectTemplate.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateInspectTemplate(name, inspectTemplate, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateInspectTemplateTest2() throws Exception {
    InspectTemplate expectedResponse =
        InspectTemplate.newBuilder()
            .setName(
                InspectTemplateName.ofOrganizationInspectTemplateName(
                        "[ORGANIZATION]", "[INSPECT_TEMPLATE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setInspectConfig(InspectConfig.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "organizations/organization-353/inspectTemplates/inspectTemplate-353";
    InspectTemplate inspectTemplate = InspectTemplate.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    InspectTemplate actualResponse =
        client.updateInspectTemplate(name, inspectTemplate, updateMask);
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
  public void updateInspectTemplateExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "organizations/organization-353/inspectTemplates/inspectTemplate-353";
      InspectTemplate inspectTemplate = InspectTemplate.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateInspectTemplate(name, inspectTemplate, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getInspectTemplateTest() throws Exception {
    InspectTemplate expectedResponse =
        InspectTemplate.newBuilder()
            .setName(
                InspectTemplateName.ofOrganizationInspectTemplateName(
                        "[ORGANIZATION]", "[INSPECT_TEMPLATE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setInspectConfig(InspectConfig.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    InspectTemplateName name =
        InspectTemplateName.ofOrganizationInspectTemplateName(
            "[ORGANIZATION]", "[INSPECT_TEMPLATE]");

    InspectTemplate actualResponse = client.getInspectTemplate(name);
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
  public void getInspectTemplateExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      InspectTemplateName name =
          InspectTemplateName.ofOrganizationInspectTemplateName(
              "[ORGANIZATION]", "[INSPECT_TEMPLATE]");
      client.getInspectTemplate(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getInspectTemplateTest2() throws Exception {
    InspectTemplate expectedResponse =
        InspectTemplate.newBuilder()
            .setName(
                InspectTemplateName.ofOrganizationInspectTemplateName(
                        "[ORGANIZATION]", "[INSPECT_TEMPLATE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setInspectConfig(InspectConfig.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "organizations/organization-353/inspectTemplates/inspectTemplate-353";

    InspectTemplate actualResponse = client.getInspectTemplate(name);
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
  public void getInspectTemplateExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "organizations/organization-353/inspectTemplates/inspectTemplate-353";
      client.getInspectTemplate(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listInspectTemplatesTest() throws Exception {
    InspectTemplate responsesElement = InspectTemplate.newBuilder().build();
    ListInspectTemplatesResponse expectedResponse =
        ListInspectTemplatesResponse.newBuilder()
            .setNextPageToken("")
            .addAllInspectTemplates(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListInspectTemplatesPagedResponse pagedListResponse = client.listInspectTemplates(parent);

    List<InspectTemplate> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getInspectTemplatesList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listInspectTemplatesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listInspectTemplates(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listInspectTemplatesTest2() throws Exception {
    InspectTemplate responsesElement = InspectTemplate.newBuilder().build();
    ListInspectTemplatesResponse expectedResponse =
        ListInspectTemplatesResponse.newBuilder()
            .setNextPageToken("")
            .addAllInspectTemplates(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");

    ListInspectTemplatesPagedResponse pagedListResponse = client.listInspectTemplates(parent);

    List<InspectTemplate> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getInspectTemplatesList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listInspectTemplatesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
      client.listInspectTemplates(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listInspectTemplatesTest3() throws Exception {
    InspectTemplate responsesElement = InspectTemplate.newBuilder().build();
    ListInspectTemplatesResponse expectedResponse =
        ListInspectTemplatesResponse.newBuilder()
            .setNextPageToken("")
            .addAllInspectTemplates(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    OrganizationName parent = OrganizationName.of("[ORGANIZATION]");

    ListInspectTemplatesPagedResponse pagedListResponse = client.listInspectTemplates(parent);

    List<InspectTemplate> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getInspectTemplatesList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listInspectTemplatesExceptionTest3() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
      client.listInspectTemplates(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listInspectTemplatesTest4() throws Exception {
    InspectTemplate responsesElement = InspectTemplate.newBuilder().build();
    ListInspectTemplatesResponse expectedResponse =
        ListInspectTemplatesResponse.newBuilder()
            .setNextPageToken("")
            .addAllInspectTemplates(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");

    ListInspectTemplatesPagedResponse pagedListResponse = client.listInspectTemplates(parent);

    List<InspectTemplate> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getInspectTemplatesList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listInspectTemplatesExceptionTest4() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      client.listInspectTemplates(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listInspectTemplatesTest5() throws Exception {
    InspectTemplate responsesElement = InspectTemplate.newBuilder().build();
    ListInspectTemplatesResponse expectedResponse =
        ListInspectTemplatesResponse.newBuilder()
            .setNextPageToken("")
            .addAllInspectTemplates(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "organizations/organization-8287";

    ListInspectTemplatesPagedResponse pagedListResponse = client.listInspectTemplates(parent);

    List<InspectTemplate> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getInspectTemplatesList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listInspectTemplatesExceptionTest5() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "organizations/organization-8287";
      client.listInspectTemplates(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteInspectTemplateTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    InspectTemplateName name =
        InspectTemplateName.ofOrganizationInspectTemplateName(
            "[ORGANIZATION]", "[INSPECT_TEMPLATE]");

    client.deleteInspectTemplate(name);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteInspectTemplateExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      InspectTemplateName name =
          InspectTemplateName.ofOrganizationInspectTemplateName(
              "[ORGANIZATION]", "[INSPECT_TEMPLATE]");
      client.deleteInspectTemplate(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteInspectTemplateTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name = "organizations/organization-353/inspectTemplates/inspectTemplate-353";

    client.deleteInspectTemplate(name);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteInspectTemplateExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "organizations/organization-353/inspectTemplates/inspectTemplate-353";
      client.deleteInspectTemplate(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createDeidentifyTemplateTest() throws Exception {
    DeidentifyTemplate expectedResponse =
        DeidentifyTemplate.newBuilder()
            .setName(
                DeidentifyTemplateName.ofOrganizationDeidentifyTemplateName(
                        "[ORGANIZATION]", "[DEIDENTIFY_TEMPLATE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeidentifyConfig(DeidentifyConfig.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    DeidentifyTemplate deidentifyTemplate = DeidentifyTemplate.newBuilder().build();

    DeidentifyTemplate actualResponse = client.createDeidentifyTemplate(parent, deidentifyTemplate);
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
  public void createDeidentifyTemplateExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      DeidentifyTemplate deidentifyTemplate = DeidentifyTemplate.newBuilder().build();
      client.createDeidentifyTemplate(parent, deidentifyTemplate);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createDeidentifyTemplateTest2() throws Exception {
    DeidentifyTemplate expectedResponse =
        DeidentifyTemplate.newBuilder()
            .setName(
                DeidentifyTemplateName.ofOrganizationDeidentifyTemplateName(
                        "[ORGANIZATION]", "[DEIDENTIFY_TEMPLATE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeidentifyConfig(DeidentifyConfig.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
    DeidentifyTemplate deidentifyTemplate = DeidentifyTemplate.newBuilder().build();

    DeidentifyTemplate actualResponse = client.createDeidentifyTemplate(parent, deidentifyTemplate);
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
  public void createDeidentifyTemplateExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
      DeidentifyTemplate deidentifyTemplate = DeidentifyTemplate.newBuilder().build();
      client.createDeidentifyTemplate(parent, deidentifyTemplate);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createDeidentifyTemplateTest3() throws Exception {
    DeidentifyTemplate expectedResponse =
        DeidentifyTemplate.newBuilder()
            .setName(
                DeidentifyTemplateName.ofOrganizationDeidentifyTemplateName(
                        "[ORGANIZATION]", "[DEIDENTIFY_TEMPLATE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeidentifyConfig(DeidentifyConfig.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
    DeidentifyTemplate deidentifyTemplate = DeidentifyTemplate.newBuilder().build();

    DeidentifyTemplate actualResponse = client.createDeidentifyTemplate(parent, deidentifyTemplate);
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
  public void createDeidentifyTemplateExceptionTest3() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
      DeidentifyTemplate deidentifyTemplate = DeidentifyTemplate.newBuilder().build();
      client.createDeidentifyTemplate(parent, deidentifyTemplate);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createDeidentifyTemplateTest4() throws Exception {
    DeidentifyTemplate expectedResponse =
        DeidentifyTemplate.newBuilder()
            .setName(
                DeidentifyTemplateName.ofOrganizationDeidentifyTemplateName(
                        "[ORGANIZATION]", "[DEIDENTIFY_TEMPLATE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeidentifyConfig(DeidentifyConfig.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");
    DeidentifyTemplate deidentifyTemplate = DeidentifyTemplate.newBuilder().build();

    DeidentifyTemplate actualResponse = client.createDeidentifyTemplate(parent, deidentifyTemplate);
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
  public void createDeidentifyTemplateExceptionTest4() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      DeidentifyTemplate deidentifyTemplate = DeidentifyTemplate.newBuilder().build();
      client.createDeidentifyTemplate(parent, deidentifyTemplate);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createDeidentifyTemplateTest5() throws Exception {
    DeidentifyTemplate expectedResponse =
        DeidentifyTemplate.newBuilder()
            .setName(
                DeidentifyTemplateName.ofOrganizationDeidentifyTemplateName(
                        "[ORGANIZATION]", "[DEIDENTIFY_TEMPLATE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeidentifyConfig(DeidentifyConfig.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "organizations/organization-8287";
    DeidentifyTemplate deidentifyTemplate = DeidentifyTemplate.newBuilder().build();

    DeidentifyTemplate actualResponse = client.createDeidentifyTemplate(parent, deidentifyTemplate);
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
  public void createDeidentifyTemplateExceptionTest5() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "organizations/organization-8287";
      DeidentifyTemplate deidentifyTemplate = DeidentifyTemplate.newBuilder().build();
      client.createDeidentifyTemplate(parent, deidentifyTemplate);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateDeidentifyTemplateTest() throws Exception {
    DeidentifyTemplate expectedResponse =
        DeidentifyTemplate.newBuilder()
            .setName(
                DeidentifyTemplateName.ofOrganizationDeidentifyTemplateName(
                        "[ORGANIZATION]", "[DEIDENTIFY_TEMPLATE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeidentifyConfig(DeidentifyConfig.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    DeidentifyTemplateName name =
        DeidentifyTemplateName.ofOrganizationDeidentifyTemplateName(
            "[ORGANIZATION]", "[DEIDENTIFY_TEMPLATE]");
    DeidentifyTemplate deidentifyTemplate = DeidentifyTemplate.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    DeidentifyTemplate actualResponse =
        client.updateDeidentifyTemplate(name, deidentifyTemplate, updateMask);
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
  public void updateDeidentifyTemplateExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DeidentifyTemplateName name =
          DeidentifyTemplateName.ofOrganizationDeidentifyTemplateName(
              "[ORGANIZATION]", "[DEIDENTIFY_TEMPLATE]");
      DeidentifyTemplate deidentifyTemplate = DeidentifyTemplate.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateDeidentifyTemplate(name, deidentifyTemplate, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateDeidentifyTemplateTest2() throws Exception {
    DeidentifyTemplate expectedResponse =
        DeidentifyTemplate.newBuilder()
            .setName(
                DeidentifyTemplateName.ofOrganizationDeidentifyTemplateName(
                        "[ORGANIZATION]", "[DEIDENTIFY_TEMPLATE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeidentifyConfig(DeidentifyConfig.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "organizations/organization-136/deidentifyTemplates/deidentifyTemplate-136";
    DeidentifyTemplate deidentifyTemplate = DeidentifyTemplate.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    DeidentifyTemplate actualResponse =
        client.updateDeidentifyTemplate(name, deidentifyTemplate, updateMask);
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
  public void updateDeidentifyTemplateExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "organizations/organization-136/deidentifyTemplates/deidentifyTemplate-136";
      DeidentifyTemplate deidentifyTemplate = DeidentifyTemplate.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateDeidentifyTemplate(name, deidentifyTemplate, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDeidentifyTemplateTest() throws Exception {
    DeidentifyTemplate expectedResponse =
        DeidentifyTemplate.newBuilder()
            .setName(
                DeidentifyTemplateName.ofOrganizationDeidentifyTemplateName(
                        "[ORGANIZATION]", "[DEIDENTIFY_TEMPLATE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeidentifyConfig(DeidentifyConfig.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    DeidentifyTemplateName name =
        DeidentifyTemplateName.ofOrganizationDeidentifyTemplateName(
            "[ORGANIZATION]", "[DEIDENTIFY_TEMPLATE]");

    DeidentifyTemplate actualResponse = client.getDeidentifyTemplate(name);
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
  public void getDeidentifyTemplateExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DeidentifyTemplateName name =
          DeidentifyTemplateName.ofOrganizationDeidentifyTemplateName(
              "[ORGANIZATION]", "[DEIDENTIFY_TEMPLATE]");
      client.getDeidentifyTemplate(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDeidentifyTemplateTest2() throws Exception {
    DeidentifyTemplate expectedResponse =
        DeidentifyTemplate.newBuilder()
            .setName(
                DeidentifyTemplateName.ofOrganizationDeidentifyTemplateName(
                        "[ORGANIZATION]", "[DEIDENTIFY_TEMPLATE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeidentifyConfig(DeidentifyConfig.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "organizations/organization-136/deidentifyTemplates/deidentifyTemplate-136";

    DeidentifyTemplate actualResponse = client.getDeidentifyTemplate(name);
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
  public void getDeidentifyTemplateExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "organizations/organization-136/deidentifyTemplates/deidentifyTemplate-136";
      client.getDeidentifyTemplate(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDeidentifyTemplatesTest() throws Exception {
    DeidentifyTemplate responsesElement = DeidentifyTemplate.newBuilder().build();
    ListDeidentifyTemplatesResponse expectedResponse =
        ListDeidentifyTemplatesResponse.newBuilder()
            .setNextPageToken("")
            .addAllDeidentifyTemplates(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListDeidentifyTemplatesPagedResponse pagedListResponse = client.listDeidentifyTemplates(parent);

    List<DeidentifyTemplate> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDeidentifyTemplatesList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listDeidentifyTemplatesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listDeidentifyTemplates(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDeidentifyTemplatesTest2() throws Exception {
    DeidentifyTemplate responsesElement = DeidentifyTemplate.newBuilder().build();
    ListDeidentifyTemplatesResponse expectedResponse =
        ListDeidentifyTemplatesResponse.newBuilder()
            .setNextPageToken("")
            .addAllDeidentifyTemplates(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");

    ListDeidentifyTemplatesPagedResponse pagedListResponse = client.listDeidentifyTemplates(parent);

    List<DeidentifyTemplate> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDeidentifyTemplatesList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listDeidentifyTemplatesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
      client.listDeidentifyTemplates(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDeidentifyTemplatesTest3() throws Exception {
    DeidentifyTemplate responsesElement = DeidentifyTemplate.newBuilder().build();
    ListDeidentifyTemplatesResponse expectedResponse =
        ListDeidentifyTemplatesResponse.newBuilder()
            .setNextPageToken("")
            .addAllDeidentifyTemplates(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    OrganizationName parent = OrganizationName.of("[ORGANIZATION]");

    ListDeidentifyTemplatesPagedResponse pagedListResponse = client.listDeidentifyTemplates(parent);

    List<DeidentifyTemplate> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDeidentifyTemplatesList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listDeidentifyTemplatesExceptionTest3() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
      client.listDeidentifyTemplates(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDeidentifyTemplatesTest4() throws Exception {
    DeidentifyTemplate responsesElement = DeidentifyTemplate.newBuilder().build();
    ListDeidentifyTemplatesResponse expectedResponse =
        ListDeidentifyTemplatesResponse.newBuilder()
            .setNextPageToken("")
            .addAllDeidentifyTemplates(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");

    ListDeidentifyTemplatesPagedResponse pagedListResponse = client.listDeidentifyTemplates(parent);

    List<DeidentifyTemplate> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDeidentifyTemplatesList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listDeidentifyTemplatesExceptionTest4() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      client.listDeidentifyTemplates(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDeidentifyTemplatesTest5() throws Exception {
    DeidentifyTemplate responsesElement = DeidentifyTemplate.newBuilder().build();
    ListDeidentifyTemplatesResponse expectedResponse =
        ListDeidentifyTemplatesResponse.newBuilder()
            .setNextPageToken("")
            .addAllDeidentifyTemplates(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "organizations/organization-8287";

    ListDeidentifyTemplatesPagedResponse pagedListResponse = client.listDeidentifyTemplates(parent);

    List<DeidentifyTemplate> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDeidentifyTemplatesList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listDeidentifyTemplatesExceptionTest5() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "organizations/organization-8287";
      client.listDeidentifyTemplates(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteDeidentifyTemplateTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    DeidentifyTemplateName name =
        DeidentifyTemplateName.ofOrganizationDeidentifyTemplateName(
            "[ORGANIZATION]", "[DEIDENTIFY_TEMPLATE]");

    client.deleteDeidentifyTemplate(name);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteDeidentifyTemplateExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DeidentifyTemplateName name =
          DeidentifyTemplateName.ofOrganizationDeidentifyTemplateName(
              "[ORGANIZATION]", "[DEIDENTIFY_TEMPLATE]");
      client.deleteDeidentifyTemplate(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteDeidentifyTemplateTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name = "organizations/organization-136/deidentifyTemplates/deidentifyTemplate-136";

    client.deleteDeidentifyTemplate(name);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteDeidentifyTemplateExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "organizations/organization-136/deidentifyTemplates/deidentifyTemplate-136";
      client.deleteDeidentifyTemplate(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createJobTriggerTest() throws Exception {
    JobTrigger expectedResponse =
        JobTrigger.newBuilder()
            .setName(
                JobTriggerName.ofProjectJobTriggerName("[PROJECT]", "[JOB_TRIGGER]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllTriggers(new ArrayList<JobTrigger.Trigger>())
            .addAllErrors(new ArrayList<Error>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setLastRunTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    JobTrigger jobTrigger = JobTrigger.newBuilder().build();

    JobTrigger actualResponse = client.createJobTrigger(parent, jobTrigger);
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
  public void createJobTriggerExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      JobTrigger jobTrigger = JobTrigger.newBuilder().build();
      client.createJobTrigger(parent, jobTrigger);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createJobTriggerTest2() throws Exception {
    JobTrigger expectedResponse =
        JobTrigger.newBuilder()
            .setName(
                JobTriggerName.ofProjectJobTriggerName("[PROJECT]", "[JOB_TRIGGER]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllTriggers(new ArrayList<JobTrigger.Trigger>())
            .addAllErrors(new ArrayList<Error>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setLastRunTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");
    JobTrigger jobTrigger = JobTrigger.newBuilder().build();

    JobTrigger actualResponse = client.createJobTrigger(parent, jobTrigger);
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
  public void createJobTriggerExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      JobTrigger jobTrigger = JobTrigger.newBuilder().build();
      client.createJobTrigger(parent, jobTrigger);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createJobTriggerTest3() throws Exception {
    JobTrigger expectedResponse =
        JobTrigger.newBuilder()
            .setName(
                JobTriggerName.ofProjectJobTriggerName("[PROJECT]", "[JOB_TRIGGER]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllTriggers(new ArrayList<JobTrigger.Trigger>())
            .addAllErrors(new ArrayList<Error>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setLastRunTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-2353";
    JobTrigger jobTrigger = JobTrigger.newBuilder().build();

    JobTrigger actualResponse = client.createJobTrigger(parent, jobTrigger);
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
  public void createJobTriggerExceptionTest3() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-2353";
      JobTrigger jobTrigger = JobTrigger.newBuilder().build();
      client.createJobTrigger(parent, jobTrigger);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateJobTriggerTest() throws Exception {
    JobTrigger expectedResponse =
        JobTrigger.newBuilder()
            .setName(
                JobTriggerName.ofProjectJobTriggerName("[PROJECT]", "[JOB_TRIGGER]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllTriggers(new ArrayList<JobTrigger.Trigger>())
            .addAllErrors(new ArrayList<Error>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setLastRunTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    JobTriggerName name = JobTriggerName.ofProjectJobTriggerName("[PROJECT]", "[JOB_TRIGGER]");
    JobTrigger jobTrigger = JobTrigger.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    JobTrigger actualResponse = client.updateJobTrigger(name, jobTrigger, updateMask);
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
  public void updateJobTriggerExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      JobTriggerName name = JobTriggerName.ofProjectJobTriggerName("[PROJECT]", "[JOB_TRIGGER]");
      JobTrigger jobTrigger = JobTrigger.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateJobTrigger(name, jobTrigger, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateJobTriggerTest2() throws Exception {
    JobTrigger expectedResponse =
        JobTrigger.newBuilder()
            .setName(
                JobTriggerName.ofProjectJobTriggerName("[PROJECT]", "[JOB_TRIGGER]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllTriggers(new ArrayList<JobTrigger.Trigger>())
            .addAllErrors(new ArrayList<Error>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setLastRunTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-2172/jobTriggers/jobTrigger-2172";
    JobTrigger jobTrigger = JobTrigger.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    JobTrigger actualResponse = client.updateJobTrigger(name, jobTrigger, updateMask);
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
  public void updateJobTriggerExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-2172/jobTriggers/jobTrigger-2172";
      JobTrigger jobTrigger = JobTrigger.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateJobTrigger(name, jobTrigger, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void hybridInspectJobTriggerTest() throws Exception {
    HybridInspectResponse expectedResponse = HybridInspectResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    JobTriggerName name =
        JobTriggerName.ofProjectLocationJobTriggerName("[PROJECT]", "[LOCATION]", "[JOB_TRIGGER]");

    HybridInspectResponse actualResponse = client.hybridInspectJobTrigger(name);
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
  public void hybridInspectJobTriggerExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      JobTriggerName name =
          JobTriggerName.ofProjectLocationJobTriggerName(
              "[PROJECT]", "[LOCATION]", "[JOB_TRIGGER]");
      client.hybridInspectJobTrigger(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void hybridInspectJobTriggerTest2() throws Exception {
    HybridInspectResponse expectedResponse = HybridInspectResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-6030/locations/location-6030/jobTriggers/jobTrigger-6030";

    HybridInspectResponse actualResponse = client.hybridInspectJobTrigger(name);
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
  public void hybridInspectJobTriggerExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-6030/locations/location-6030/jobTriggers/jobTrigger-6030";
      client.hybridInspectJobTrigger(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getJobTriggerTest() throws Exception {
    JobTrigger expectedResponse =
        JobTrigger.newBuilder()
            .setName(
                JobTriggerName.ofProjectJobTriggerName("[PROJECT]", "[JOB_TRIGGER]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllTriggers(new ArrayList<JobTrigger.Trigger>())
            .addAllErrors(new ArrayList<Error>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setLastRunTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    JobTriggerName name = JobTriggerName.ofProjectJobTriggerName("[PROJECT]", "[JOB_TRIGGER]");

    JobTrigger actualResponse = client.getJobTrigger(name);
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
  public void getJobTriggerExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      JobTriggerName name = JobTriggerName.ofProjectJobTriggerName("[PROJECT]", "[JOB_TRIGGER]");
      client.getJobTrigger(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getJobTriggerTest2() throws Exception {
    JobTrigger expectedResponse =
        JobTrigger.newBuilder()
            .setName(
                JobTriggerName.ofProjectJobTriggerName("[PROJECT]", "[JOB_TRIGGER]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllTriggers(new ArrayList<JobTrigger.Trigger>())
            .addAllErrors(new ArrayList<Error>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setLastRunTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-2172/jobTriggers/jobTrigger-2172";

    JobTrigger actualResponse = client.getJobTrigger(name);
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
  public void getJobTriggerExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-2172/jobTriggers/jobTrigger-2172";
      client.getJobTrigger(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listJobTriggersTest() throws Exception {
    JobTrigger responsesElement = JobTrigger.newBuilder().build();
    ListJobTriggersResponse expectedResponse =
        ListJobTriggersResponse.newBuilder()
            .setNextPageToken("")
            .addAllJobTriggers(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListJobTriggersPagedResponse pagedListResponse = client.listJobTriggers(parent);

    List<JobTrigger> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getJobTriggersList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listJobTriggersExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listJobTriggers(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listJobTriggersTest2() throws Exception {
    JobTrigger responsesElement = JobTrigger.newBuilder().build();
    ListJobTriggersResponse expectedResponse =
        ListJobTriggersResponse.newBuilder()
            .setNextPageToken("")
            .addAllJobTriggers(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");

    ListJobTriggersPagedResponse pagedListResponse = client.listJobTriggers(parent);

    List<JobTrigger> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getJobTriggersList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listJobTriggersExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      client.listJobTriggers(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listJobTriggersTest3() throws Exception {
    JobTrigger responsesElement = JobTrigger.newBuilder().build();
    ListJobTriggersResponse expectedResponse =
        ListJobTriggersResponse.newBuilder()
            .setNextPageToken("")
            .addAllJobTriggers(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-2353";

    ListJobTriggersPagedResponse pagedListResponse = client.listJobTriggers(parent);

    List<JobTrigger> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getJobTriggersList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listJobTriggersExceptionTest3() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-2353";
      client.listJobTriggers(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteJobTriggerTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    JobTriggerName name = JobTriggerName.ofProjectJobTriggerName("[PROJECT]", "[JOB_TRIGGER]");

    client.deleteJobTrigger(name);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteJobTriggerExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      JobTriggerName name = JobTriggerName.ofProjectJobTriggerName("[PROJECT]", "[JOB_TRIGGER]");
      client.deleteJobTrigger(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteJobTriggerTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-2172/jobTriggers/jobTrigger-2172";

    client.deleteJobTrigger(name);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteJobTriggerExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-2172/jobTriggers/jobTrigger-2172";
      client.deleteJobTrigger(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void activateJobTriggerTest() throws Exception {
    DlpJob expectedResponse =
        DlpJob.newBuilder()
            .setName(DlpJobName.ofProjectDlpJobName("[PROJECT]", "[DLP_JOB]").toString())
            .setType(DlpJobType.forNumber(0))
            .setCreateTime(Timestamp.newBuilder().build())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setJobTriggerName("jobTriggerName494333030")
            .addAllErrors(new ArrayList<Error>())
            .build();
    mockService.addResponse(expectedResponse);

    ActivateJobTriggerRequest request =
        ActivateJobTriggerRequest.newBuilder()
            .setName(
                JobTriggerName.ofProjectJobTriggerName("[PROJECT]", "[JOB_TRIGGER]").toString())
            .build();

    DlpJob actualResponse = client.activateJobTrigger(request);
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
  public void activateJobTriggerExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ActivateJobTriggerRequest request =
          ActivateJobTriggerRequest.newBuilder()
              .setName(
                  JobTriggerName.ofProjectJobTriggerName("[PROJECT]", "[JOB_TRIGGER]").toString())
              .build();
      client.activateJobTrigger(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createDlpJobTest() throws Exception {
    DlpJob expectedResponse =
        DlpJob.newBuilder()
            .setName(DlpJobName.ofProjectDlpJobName("[PROJECT]", "[DLP_JOB]").toString())
            .setType(DlpJobType.forNumber(0))
            .setCreateTime(Timestamp.newBuilder().build())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setJobTriggerName("jobTriggerName494333030")
            .addAllErrors(new ArrayList<Error>())
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    InspectJobConfig inspectJob = InspectJobConfig.newBuilder().build();

    DlpJob actualResponse = client.createDlpJob(parent, inspectJob);
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
  public void createDlpJobExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      InspectJobConfig inspectJob = InspectJobConfig.newBuilder().build();
      client.createDlpJob(parent, inspectJob);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createDlpJobTest2() throws Exception {
    DlpJob expectedResponse =
        DlpJob.newBuilder()
            .setName(DlpJobName.ofProjectDlpJobName("[PROJECT]", "[DLP_JOB]").toString())
            .setType(DlpJobType.forNumber(0))
            .setCreateTime(Timestamp.newBuilder().build())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setJobTriggerName("jobTriggerName494333030")
            .addAllErrors(new ArrayList<Error>())
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    RiskAnalysisJobConfig riskJob = RiskAnalysisJobConfig.newBuilder().build();

    DlpJob actualResponse = client.createDlpJob(parent, riskJob);
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
  public void createDlpJobExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      RiskAnalysisJobConfig riskJob = RiskAnalysisJobConfig.newBuilder().build();
      client.createDlpJob(parent, riskJob);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createDlpJobTest3() throws Exception {
    DlpJob expectedResponse =
        DlpJob.newBuilder()
            .setName(DlpJobName.ofProjectDlpJobName("[PROJECT]", "[DLP_JOB]").toString())
            .setType(DlpJobType.forNumber(0))
            .setCreateTime(Timestamp.newBuilder().build())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setJobTriggerName("jobTriggerName494333030")
            .addAllErrors(new ArrayList<Error>())
            .build();
    mockService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");
    InspectJobConfig inspectJob = InspectJobConfig.newBuilder().build();

    DlpJob actualResponse = client.createDlpJob(parent, inspectJob);
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
  public void createDlpJobExceptionTest3() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      InspectJobConfig inspectJob = InspectJobConfig.newBuilder().build();
      client.createDlpJob(parent, inspectJob);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createDlpJobTest4() throws Exception {
    DlpJob expectedResponse =
        DlpJob.newBuilder()
            .setName(DlpJobName.ofProjectDlpJobName("[PROJECT]", "[DLP_JOB]").toString())
            .setType(DlpJobType.forNumber(0))
            .setCreateTime(Timestamp.newBuilder().build())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setJobTriggerName("jobTriggerName494333030")
            .addAllErrors(new ArrayList<Error>())
            .build();
    mockService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");
    RiskAnalysisJobConfig riskJob = RiskAnalysisJobConfig.newBuilder().build();

    DlpJob actualResponse = client.createDlpJob(parent, riskJob);
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
  public void createDlpJobExceptionTest4() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      RiskAnalysisJobConfig riskJob = RiskAnalysisJobConfig.newBuilder().build();
      client.createDlpJob(parent, riskJob);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createDlpJobTest5() throws Exception {
    DlpJob expectedResponse =
        DlpJob.newBuilder()
            .setName(DlpJobName.ofProjectDlpJobName("[PROJECT]", "[DLP_JOB]").toString())
            .setType(DlpJobType.forNumber(0))
            .setCreateTime(Timestamp.newBuilder().build())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setJobTriggerName("jobTriggerName494333030")
            .addAllErrors(new ArrayList<Error>())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-2353";
    InspectJobConfig inspectJob = InspectJobConfig.newBuilder().build();

    DlpJob actualResponse = client.createDlpJob(parent, inspectJob);
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
  public void createDlpJobExceptionTest5() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-2353";
      InspectJobConfig inspectJob = InspectJobConfig.newBuilder().build();
      client.createDlpJob(parent, inspectJob);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createDlpJobTest6() throws Exception {
    DlpJob expectedResponse =
        DlpJob.newBuilder()
            .setName(DlpJobName.ofProjectDlpJobName("[PROJECT]", "[DLP_JOB]").toString())
            .setType(DlpJobType.forNumber(0))
            .setCreateTime(Timestamp.newBuilder().build())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setJobTriggerName("jobTriggerName494333030")
            .addAllErrors(new ArrayList<Error>())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-2353";
    RiskAnalysisJobConfig riskJob = RiskAnalysisJobConfig.newBuilder().build();

    DlpJob actualResponse = client.createDlpJob(parent, riskJob);
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
  public void createDlpJobExceptionTest6() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-2353";
      RiskAnalysisJobConfig riskJob = RiskAnalysisJobConfig.newBuilder().build();
      client.createDlpJob(parent, riskJob);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDlpJobsTest() throws Exception {
    DlpJob responsesElement = DlpJob.newBuilder().build();
    ListDlpJobsResponse expectedResponse =
        ListDlpJobsResponse.newBuilder()
            .setNextPageToken("")
            .addAllJobs(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListDlpJobsPagedResponse pagedListResponse = client.listDlpJobs(parent);

    List<DlpJob> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getJobsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listDlpJobsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listDlpJobs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDlpJobsTest2() throws Exception {
    DlpJob responsesElement = DlpJob.newBuilder().build();
    ListDlpJobsResponse expectedResponse =
        ListDlpJobsResponse.newBuilder()
            .setNextPageToken("")
            .addAllJobs(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");

    ListDlpJobsPagedResponse pagedListResponse = client.listDlpJobs(parent);

    List<DlpJob> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getJobsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listDlpJobsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      client.listDlpJobs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDlpJobsTest3() throws Exception {
    DlpJob responsesElement = DlpJob.newBuilder().build();
    ListDlpJobsResponse expectedResponse =
        ListDlpJobsResponse.newBuilder()
            .setNextPageToken("")
            .addAllJobs(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-2353";

    ListDlpJobsPagedResponse pagedListResponse = client.listDlpJobs(parent);

    List<DlpJob> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getJobsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listDlpJobsExceptionTest3() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-2353";
      client.listDlpJobs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDlpJobTest() throws Exception {
    DlpJob expectedResponse =
        DlpJob.newBuilder()
            .setName(DlpJobName.ofProjectDlpJobName("[PROJECT]", "[DLP_JOB]").toString())
            .setType(DlpJobType.forNumber(0))
            .setCreateTime(Timestamp.newBuilder().build())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setJobTriggerName("jobTriggerName494333030")
            .addAllErrors(new ArrayList<Error>())
            .build();
    mockService.addResponse(expectedResponse);

    DlpJobName name = DlpJobName.ofProjectDlpJobName("[PROJECT]", "[DLP_JOB]");

    DlpJob actualResponse = client.getDlpJob(name);
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
  public void getDlpJobExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DlpJobName name = DlpJobName.ofProjectDlpJobName("[PROJECT]", "[DLP_JOB]");
      client.getDlpJob(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDlpJobTest2() throws Exception {
    DlpJob expectedResponse =
        DlpJob.newBuilder()
            .setName(DlpJobName.ofProjectDlpJobName("[PROJECT]", "[DLP_JOB]").toString())
            .setType(DlpJobType.forNumber(0))
            .setCreateTime(Timestamp.newBuilder().build())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setJobTriggerName("jobTriggerName494333030")
            .addAllErrors(new ArrayList<Error>())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-2726/dlpJobs/dlpJob-2726";

    DlpJob actualResponse = client.getDlpJob(name);
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
  public void getDlpJobExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-2726/dlpJobs/dlpJob-2726";
      client.getDlpJob(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteDlpJobTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    DlpJobName name = DlpJobName.ofProjectDlpJobName("[PROJECT]", "[DLP_JOB]");

    client.deleteDlpJob(name);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteDlpJobExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DlpJobName name = DlpJobName.ofProjectDlpJobName("[PROJECT]", "[DLP_JOB]");
      client.deleteDlpJob(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteDlpJobTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-2726/dlpJobs/dlpJob-2726";

    client.deleteDlpJob(name);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteDlpJobExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-2726/dlpJobs/dlpJob-2726";
      client.deleteDlpJob(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void cancelDlpJobTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    CancelDlpJobRequest request =
        CancelDlpJobRequest.newBuilder()
            .setName(DlpJobName.ofProjectDlpJobName("[PROJECT]", "[DLP_JOB]").toString())
            .build();

    client.cancelDlpJob(request);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void cancelDlpJobExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CancelDlpJobRequest request =
          CancelDlpJobRequest.newBuilder()
              .setName(DlpJobName.ofProjectDlpJobName("[PROJECT]", "[DLP_JOB]").toString())
              .build();
      client.cancelDlpJob(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createStoredInfoTypeTest() throws Exception {
    StoredInfoType expectedResponse =
        StoredInfoType.newBuilder()
            .setName(
                StoredInfoTypeName.ofOrganizationStoredInfoTypeName(
                        "[ORGANIZATION]", "[STORED_INFO_TYPE]")
                    .toString())
            .setCurrentVersion(StoredInfoTypeVersion.newBuilder().build())
            .addAllPendingVersions(new ArrayList<StoredInfoTypeVersion>())
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    StoredInfoTypeConfig config = StoredInfoTypeConfig.newBuilder().build();

    StoredInfoType actualResponse = client.createStoredInfoType(parent, config);
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
  public void createStoredInfoTypeExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      StoredInfoTypeConfig config = StoredInfoTypeConfig.newBuilder().build();
      client.createStoredInfoType(parent, config);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createStoredInfoTypeTest2() throws Exception {
    StoredInfoType expectedResponse =
        StoredInfoType.newBuilder()
            .setName(
                StoredInfoTypeName.ofOrganizationStoredInfoTypeName(
                        "[ORGANIZATION]", "[STORED_INFO_TYPE]")
                    .toString())
            .setCurrentVersion(StoredInfoTypeVersion.newBuilder().build())
            .addAllPendingVersions(new ArrayList<StoredInfoTypeVersion>())
            .build();
    mockService.addResponse(expectedResponse);

    OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
    StoredInfoTypeConfig config = StoredInfoTypeConfig.newBuilder().build();

    StoredInfoType actualResponse = client.createStoredInfoType(parent, config);
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
  public void createStoredInfoTypeExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
      StoredInfoTypeConfig config = StoredInfoTypeConfig.newBuilder().build();
      client.createStoredInfoType(parent, config);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createStoredInfoTypeTest3() throws Exception {
    StoredInfoType expectedResponse =
        StoredInfoType.newBuilder()
            .setName(
                StoredInfoTypeName.ofOrganizationStoredInfoTypeName(
                        "[ORGANIZATION]", "[STORED_INFO_TYPE]")
                    .toString())
            .setCurrentVersion(StoredInfoTypeVersion.newBuilder().build())
            .addAllPendingVersions(new ArrayList<StoredInfoTypeVersion>())
            .build();
    mockService.addResponse(expectedResponse);

    OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
    StoredInfoTypeConfig config = StoredInfoTypeConfig.newBuilder().build();

    StoredInfoType actualResponse = client.createStoredInfoType(parent, config);
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
  public void createStoredInfoTypeExceptionTest3() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
      StoredInfoTypeConfig config = StoredInfoTypeConfig.newBuilder().build();
      client.createStoredInfoType(parent, config);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createStoredInfoTypeTest4() throws Exception {
    StoredInfoType expectedResponse =
        StoredInfoType.newBuilder()
            .setName(
                StoredInfoTypeName.ofOrganizationStoredInfoTypeName(
                        "[ORGANIZATION]", "[STORED_INFO_TYPE]")
                    .toString())
            .setCurrentVersion(StoredInfoTypeVersion.newBuilder().build())
            .addAllPendingVersions(new ArrayList<StoredInfoTypeVersion>())
            .build();
    mockService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");
    StoredInfoTypeConfig config = StoredInfoTypeConfig.newBuilder().build();

    StoredInfoType actualResponse = client.createStoredInfoType(parent, config);
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
  public void createStoredInfoTypeExceptionTest4() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      StoredInfoTypeConfig config = StoredInfoTypeConfig.newBuilder().build();
      client.createStoredInfoType(parent, config);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createStoredInfoTypeTest5() throws Exception {
    StoredInfoType expectedResponse =
        StoredInfoType.newBuilder()
            .setName(
                StoredInfoTypeName.ofOrganizationStoredInfoTypeName(
                        "[ORGANIZATION]", "[STORED_INFO_TYPE]")
                    .toString())
            .setCurrentVersion(StoredInfoTypeVersion.newBuilder().build())
            .addAllPendingVersions(new ArrayList<StoredInfoTypeVersion>())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "organizations/organization-8287";
    StoredInfoTypeConfig config = StoredInfoTypeConfig.newBuilder().build();

    StoredInfoType actualResponse = client.createStoredInfoType(parent, config);
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
  public void createStoredInfoTypeExceptionTest5() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "organizations/organization-8287";
      StoredInfoTypeConfig config = StoredInfoTypeConfig.newBuilder().build();
      client.createStoredInfoType(parent, config);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateStoredInfoTypeTest() throws Exception {
    StoredInfoType expectedResponse =
        StoredInfoType.newBuilder()
            .setName(
                StoredInfoTypeName.ofOrganizationStoredInfoTypeName(
                        "[ORGANIZATION]", "[STORED_INFO_TYPE]")
                    .toString())
            .setCurrentVersion(StoredInfoTypeVersion.newBuilder().build())
            .addAllPendingVersions(new ArrayList<StoredInfoTypeVersion>())
            .build();
    mockService.addResponse(expectedResponse);

    StoredInfoTypeName name =
        StoredInfoTypeName.ofOrganizationStoredInfoTypeName("[ORGANIZATION]", "[STORED_INFO_TYPE]");
    StoredInfoTypeConfig config = StoredInfoTypeConfig.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    StoredInfoType actualResponse = client.updateStoredInfoType(name, config, updateMask);
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
  public void updateStoredInfoTypeExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      StoredInfoTypeName name =
          StoredInfoTypeName.ofOrganizationStoredInfoTypeName(
              "[ORGANIZATION]", "[STORED_INFO_TYPE]");
      StoredInfoTypeConfig config = StoredInfoTypeConfig.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateStoredInfoType(name, config, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateStoredInfoTypeTest2() throws Exception {
    StoredInfoType expectedResponse =
        StoredInfoType.newBuilder()
            .setName(
                StoredInfoTypeName.ofOrganizationStoredInfoTypeName(
                        "[ORGANIZATION]", "[STORED_INFO_TYPE]")
                    .toString())
            .setCurrentVersion(StoredInfoTypeVersion.newBuilder().build())
            .addAllPendingVersions(new ArrayList<StoredInfoTypeVersion>())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "organizations/organization-6364/storedInfoTypes/storedInfoType-6364";
    StoredInfoTypeConfig config = StoredInfoTypeConfig.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    StoredInfoType actualResponse = client.updateStoredInfoType(name, config, updateMask);
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
  public void updateStoredInfoTypeExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "organizations/organization-6364/storedInfoTypes/storedInfoType-6364";
      StoredInfoTypeConfig config = StoredInfoTypeConfig.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateStoredInfoType(name, config, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getStoredInfoTypeTest() throws Exception {
    StoredInfoType expectedResponse =
        StoredInfoType.newBuilder()
            .setName(
                StoredInfoTypeName.ofOrganizationStoredInfoTypeName(
                        "[ORGANIZATION]", "[STORED_INFO_TYPE]")
                    .toString())
            .setCurrentVersion(StoredInfoTypeVersion.newBuilder().build())
            .addAllPendingVersions(new ArrayList<StoredInfoTypeVersion>())
            .build();
    mockService.addResponse(expectedResponse);

    StoredInfoTypeName name =
        StoredInfoTypeName.ofOrganizationStoredInfoTypeName("[ORGANIZATION]", "[STORED_INFO_TYPE]");

    StoredInfoType actualResponse = client.getStoredInfoType(name);
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
  public void getStoredInfoTypeExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      StoredInfoTypeName name =
          StoredInfoTypeName.ofOrganizationStoredInfoTypeName(
              "[ORGANIZATION]", "[STORED_INFO_TYPE]");
      client.getStoredInfoType(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getStoredInfoTypeTest2() throws Exception {
    StoredInfoType expectedResponse =
        StoredInfoType.newBuilder()
            .setName(
                StoredInfoTypeName.ofOrganizationStoredInfoTypeName(
                        "[ORGANIZATION]", "[STORED_INFO_TYPE]")
                    .toString())
            .setCurrentVersion(StoredInfoTypeVersion.newBuilder().build())
            .addAllPendingVersions(new ArrayList<StoredInfoTypeVersion>())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "organizations/organization-6364/storedInfoTypes/storedInfoType-6364";

    StoredInfoType actualResponse = client.getStoredInfoType(name);
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
  public void getStoredInfoTypeExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "organizations/organization-6364/storedInfoTypes/storedInfoType-6364";
      client.getStoredInfoType(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listStoredInfoTypesTest() throws Exception {
    StoredInfoType responsesElement = StoredInfoType.newBuilder().build();
    ListStoredInfoTypesResponse expectedResponse =
        ListStoredInfoTypesResponse.newBuilder()
            .setNextPageToken("")
            .addAllStoredInfoTypes(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListStoredInfoTypesPagedResponse pagedListResponse = client.listStoredInfoTypes(parent);

    List<StoredInfoType> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getStoredInfoTypesList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listStoredInfoTypesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listStoredInfoTypes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listStoredInfoTypesTest2() throws Exception {
    StoredInfoType responsesElement = StoredInfoType.newBuilder().build();
    ListStoredInfoTypesResponse expectedResponse =
        ListStoredInfoTypesResponse.newBuilder()
            .setNextPageToken("")
            .addAllStoredInfoTypes(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");

    ListStoredInfoTypesPagedResponse pagedListResponse = client.listStoredInfoTypes(parent);

    List<StoredInfoType> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getStoredInfoTypesList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listStoredInfoTypesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
      client.listStoredInfoTypes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listStoredInfoTypesTest3() throws Exception {
    StoredInfoType responsesElement = StoredInfoType.newBuilder().build();
    ListStoredInfoTypesResponse expectedResponse =
        ListStoredInfoTypesResponse.newBuilder()
            .setNextPageToken("")
            .addAllStoredInfoTypes(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    OrganizationName parent = OrganizationName.of("[ORGANIZATION]");

    ListStoredInfoTypesPagedResponse pagedListResponse = client.listStoredInfoTypes(parent);

    List<StoredInfoType> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getStoredInfoTypesList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listStoredInfoTypesExceptionTest3() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
      client.listStoredInfoTypes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listStoredInfoTypesTest4() throws Exception {
    StoredInfoType responsesElement = StoredInfoType.newBuilder().build();
    ListStoredInfoTypesResponse expectedResponse =
        ListStoredInfoTypesResponse.newBuilder()
            .setNextPageToken("")
            .addAllStoredInfoTypes(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");

    ListStoredInfoTypesPagedResponse pagedListResponse = client.listStoredInfoTypes(parent);

    List<StoredInfoType> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getStoredInfoTypesList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listStoredInfoTypesExceptionTest4() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      client.listStoredInfoTypes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listStoredInfoTypesTest5() throws Exception {
    StoredInfoType responsesElement = StoredInfoType.newBuilder().build();
    ListStoredInfoTypesResponse expectedResponse =
        ListStoredInfoTypesResponse.newBuilder()
            .setNextPageToken("")
            .addAllStoredInfoTypes(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "organizations/organization-8287";

    ListStoredInfoTypesPagedResponse pagedListResponse = client.listStoredInfoTypes(parent);

    List<StoredInfoType> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getStoredInfoTypesList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listStoredInfoTypesExceptionTest5() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "organizations/organization-8287";
      client.listStoredInfoTypes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteStoredInfoTypeTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    StoredInfoTypeName name =
        StoredInfoTypeName.ofOrganizationStoredInfoTypeName("[ORGANIZATION]", "[STORED_INFO_TYPE]");

    client.deleteStoredInfoType(name);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteStoredInfoTypeExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      StoredInfoTypeName name =
          StoredInfoTypeName.ofOrganizationStoredInfoTypeName(
              "[ORGANIZATION]", "[STORED_INFO_TYPE]");
      client.deleteStoredInfoType(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteStoredInfoTypeTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name = "organizations/organization-6364/storedInfoTypes/storedInfoType-6364";

    client.deleteStoredInfoType(name);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteStoredInfoTypeExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "organizations/organization-6364/storedInfoTypes/storedInfoType-6364";
      client.deleteStoredInfoType(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void hybridInspectDlpJobTest() throws Exception {
    HybridInspectResponse expectedResponse = HybridInspectResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    DlpJobName name =
        DlpJobName.ofProjectLocationDlpJobName("[PROJECT]", "[LOCATION]", "[DLP_JOB]");

    HybridInspectResponse actualResponse = client.hybridInspectDlpJob(name);
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
  public void hybridInspectDlpJobExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DlpJobName name =
          DlpJobName.ofProjectLocationDlpJobName("[PROJECT]", "[LOCATION]", "[DLP_JOB]");
      client.hybridInspectDlpJob(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void hybridInspectDlpJobTest2() throws Exception {
    HybridInspectResponse expectedResponse = HybridInspectResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-7036/locations/location-7036/dlpJobs/dlpJob-7036";

    HybridInspectResponse actualResponse = client.hybridInspectDlpJob(name);
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
  public void hybridInspectDlpJobExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-7036/locations/location-7036/dlpJobs/dlpJob-7036";
      client.hybridInspectDlpJob(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void finishDlpJobTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    FinishDlpJobRequest request =
        FinishDlpJobRequest.newBuilder()
            .setName(
                DlpJobName.ofProjectLocationDlpJobName("[PROJECT]", "[LOCATION]", "[DLP_JOB]")
                    .toString())
            .build();

    client.finishDlpJob(request);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void finishDlpJobExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      FinishDlpJobRequest request =
          FinishDlpJobRequest.newBuilder()
              .setName(
                  DlpJobName.ofProjectLocationDlpJobName("[PROJECT]", "[LOCATION]", "[DLP_JOB]")
                      .toString())
              .build();
      client.finishDlpJob(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
