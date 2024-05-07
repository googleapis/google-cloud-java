/*
 * Copyright 2024 Google LLC
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

import static com.google.cloud.dlp.v2.DlpServiceClient.ListColumnDataProfilesPagedResponse;
import static com.google.cloud.dlp.v2.DlpServiceClient.ListConnectionsPagedResponse;
import static com.google.cloud.dlp.v2.DlpServiceClient.ListDeidentifyTemplatesPagedResponse;
import static com.google.cloud.dlp.v2.DlpServiceClient.ListDiscoveryConfigsPagedResponse;
import static com.google.cloud.dlp.v2.DlpServiceClient.ListDlpJobsPagedResponse;
import static com.google.cloud.dlp.v2.DlpServiceClient.ListInspectTemplatesPagedResponse;
import static com.google.cloud.dlp.v2.DlpServiceClient.ListJobTriggersPagedResponse;
import static com.google.cloud.dlp.v2.DlpServiceClient.ListProjectDataProfilesPagedResponse;
import static com.google.cloud.dlp.v2.DlpServiceClient.ListStoredInfoTypesPagedResponse;
import static com.google.cloud.dlp.v2.DlpServiceClient.ListTableDataProfilesPagedResponse;
import static com.google.cloud.dlp.v2.DlpServiceClient.SearchConnectionsPagedResponse;

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
import com.google.privacy.dlp.v2.ActionDetails;
import com.google.privacy.dlp.v2.ActivateJobTriggerRequest;
import com.google.privacy.dlp.v2.ByteContentItem;
import com.google.privacy.dlp.v2.CancelDlpJobRequest;
import com.google.privacy.dlp.v2.ColumnDataProfile;
import com.google.privacy.dlp.v2.ColumnDataProfileName;
import com.google.privacy.dlp.v2.Connection;
import com.google.privacy.dlp.v2.ConnectionName;
import com.google.privacy.dlp.v2.ConnectionState;
import com.google.privacy.dlp.v2.ContentItem;
import com.google.privacy.dlp.v2.DataProfileAction;
import com.google.privacy.dlp.v2.DataProfileConfigSnapshot;
import com.google.privacy.dlp.v2.DataRiskLevel;
import com.google.privacy.dlp.v2.DataSourceType;
import com.google.privacy.dlp.v2.DeidentifyConfig;
import com.google.privacy.dlp.v2.DeidentifyContentRequest;
import com.google.privacy.dlp.v2.DeidentifyContentResponse;
import com.google.privacy.dlp.v2.DeidentifyTemplate;
import com.google.privacy.dlp.v2.DeidentifyTemplateName;
import com.google.privacy.dlp.v2.DiscoveryConfig;
import com.google.privacy.dlp.v2.DiscoveryConfigName;
import com.google.privacy.dlp.v2.DiscoveryTarget;
import com.google.privacy.dlp.v2.DlpJob;
import com.google.privacy.dlp.v2.DlpJobName;
import com.google.privacy.dlp.v2.DlpJobType;
import com.google.privacy.dlp.v2.EncryptionStatus;
import com.google.privacy.dlp.v2.Error;
import com.google.privacy.dlp.v2.FinishDlpJobRequest;
import com.google.privacy.dlp.v2.HybridInspectResponse;
import com.google.privacy.dlp.v2.InfoTypeDescription;
import com.google.privacy.dlp.v2.InfoTypeSummary;
import com.google.privacy.dlp.v2.InspectConfig;
import com.google.privacy.dlp.v2.InspectContentRequest;
import com.google.privacy.dlp.v2.InspectContentResponse;
import com.google.privacy.dlp.v2.InspectJobConfig;
import com.google.privacy.dlp.v2.InspectResult;
import com.google.privacy.dlp.v2.InspectTemplate;
import com.google.privacy.dlp.v2.InspectTemplateName;
import com.google.privacy.dlp.v2.JobTrigger;
import com.google.privacy.dlp.v2.JobTriggerName;
import com.google.privacy.dlp.v2.ListColumnDataProfilesResponse;
import com.google.privacy.dlp.v2.ListConnectionsResponse;
import com.google.privacy.dlp.v2.ListDeidentifyTemplatesResponse;
import com.google.privacy.dlp.v2.ListDiscoveryConfigsResponse;
import com.google.privacy.dlp.v2.ListDlpJobsResponse;
import com.google.privacy.dlp.v2.ListInfoTypesResponse;
import com.google.privacy.dlp.v2.ListInspectTemplatesResponse;
import com.google.privacy.dlp.v2.ListJobTriggersResponse;
import com.google.privacy.dlp.v2.ListProjectDataProfilesResponse;
import com.google.privacy.dlp.v2.ListStoredInfoTypesResponse;
import com.google.privacy.dlp.v2.ListTableDataProfilesResponse;
import com.google.privacy.dlp.v2.LocationName;
import com.google.privacy.dlp.v2.NullPercentageLevel;
import com.google.privacy.dlp.v2.OrganizationLocationName;
import com.google.privacy.dlp.v2.OrganizationName;
import com.google.privacy.dlp.v2.OtherInfoTypeSummary;
import com.google.privacy.dlp.v2.ProfileStatus;
import com.google.privacy.dlp.v2.ProjectDataProfile;
import com.google.privacy.dlp.v2.ProjectDataProfileName;
import com.google.privacy.dlp.v2.ProjectName;
import com.google.privacy.dlp.v2.RedactImageRequest;
import com.google.privacy.dlp.v2.RedactImageResponse;
import com.google.privacy.dlp.v2.ReidentifyContentRequest;
import com.google.privacy.dlp.v2.ReidentifyContentResponse;
import com.google.privacy.dlp.v2.ResourceVisibility;
import com.google.privacy.dlp.v2.RiskAnalysisJobConfig;
import com.google.privacy.dlp.v2.SearchConnectionsResponse;
import com.google.privacy.dlp.v2.SensitivityScore;
import com.google.privacy.dlp.v2.StoredInfoType;
import com.google.privacy.dlp.v2.StoredInfoTypeConfig;
import com.google.privacy.dlp.v2.StoredInfoTypeName;
import com.google.privacy.dlp.v2.StoredInfoTypeVersion;
import com.google.privacy.dlp.v2.TableDataProfile;
import com.google.privacy.dlp.v2.TableDataProfileName;
import com.google.privacy.dlp.v2.TransformationOverview;
import com.google.privacy.dlp.v2.UniquenessScoreLevel;
import com.google.protobuf.ByteString;
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
            .setLastModified(Timestamp.newBuilder().build())
            .setJobTriggerName("jobTriggerName494333030")
            .addAllErrors(new ArrayList<Error>())
            .addAllActionDetails(new ArrayList<ActionDetails>())
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
  public void createDiscoveryConfigTest() throws Exception {
    DiscoveryConfig expectedResponse =
        DiscoveryConfig.newBuilder()
            .setName(
                DiscoveryConfigName.of("[PROJECT]", "[LOCATION]", "[DISCOVERY_CONFIG]").toString())
            .setDisplayName("displayName1714148973")
            .setOrgConfig(DiscoveryConfig.OrgConfig.newBuilder().build())
            .addAllInspectTemplates(new ArrayList<String>())
            .addAllActions(new ArrayList<DataProfileAction>())
            .addAllTargets(new ArrayList<DiscoveryTarget>())
            .addAllErrors(new ArrayList<Error>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setLastRunTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    DiscoveryConfig discoveryConfig = DiscoveryConfig.newBuilder().build();

    DiscoveryConfig actualResponse = client.createDiscoveryConfig(parent, discoveryConfig);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createDiscoveryConfigExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      DiscoveryConfig discoveryConfig = DiscoveryConfig.newBuilder().build();
      client.createDiscoveryConfig(parent, discoveryConfig);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createDiscoveryConfigTest2() throws Exception {
    DiscoveryConfig expectedResponse =
        DiscoveryConfig.newBuilder()
            .setName(
                DiscoveryConfigName.of("[PROJECT]", "[LOCATION]", "[DISCOVERY_CONFIG]").toString())
            .setDisplayName("displayName1714148973")
            .setOrgConfig(DiscoveryConfig.OrgConfig.newBuilder().build())
            .addAllInspectTemplates(new ArrayList<String>())
            .addAllActions(new ArrayList<DataProfileAction>())
            .addAllTargets(new ArrayList<DiscoveryTarget>())
            .addAllErrors(new ArrayList<Error>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setLastRunTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";
    DiscoveryConfig discoveryConfig = DiscoveryConfig.newBuilder().build();

    DiscoveryConfig actualResponse = client.createDiscoveryConfig(parent, discoveryConfig);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createDiscoveryConfigExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      DiscoveryConfig discoveryConfig = DiscoveryConfig.newBuilder().build();
      client.createDiscoveryConfig(parent, discoveryConfig);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateDiscoveryConfigTest() throws Exception {
    DiscoveryConfig expectedResponse =
        DiscoveryConfig.newBuilder()
            .setName(
                DiscoveryConfigName.of("[PROJECT]", "[LOCATION]", "[DISCOVERY_CONFIG]").toString())
            .setDisplayName("displayName1714148973")
            .setOrgConfig(DiscoveryConfig.OrgConfig.newBuilder().build())
            .addAllInspectTemplates(new ArrayList<String>())
            .addAllActions(new ArrayList<DataProfileAction>())
            .addAllTargets(new ArrayList<DiscoveryTarget>())
            .addAllErrors(new ArrayList<Error>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setLastRunTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    DiscoveryConfigName name =
        DiscoveryConfigName.of("[PROJECT]", "[LOCATION]", "[DISCOVERY_CONFIG]");
    DiscoveryConfig discoveryConfig = DiscoveryConfig.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    DiscoveryConfig actualResponse =
        client.updateDiscoveryConfig(name, discoveryConfig, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void updateDiscoveryConfigExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DiscoveryConfigName name =
          DiscoveryConfigName.of("[PROJECT]", "[LOCATION]", "[DISCOVERY_CONFIG]");
      DiscoveryConfig discoveryConfig = DiscoveryConfig.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateDiscoveryConfig(name, discoveryConfig, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateDiscoveryConfigTest2() throws Exception {
    DiscoveryConfig expectedResponse =
        DiscoveryConfig.newBuilder()
            .setName(
                DiscoveryConfigName.of("[PROJECT]", "[LOCATION]", "[DISCOVERY_CONFIG]").toString())
            .setDisplayName("displayName1714148973")
            .setOrgConfig(DiscoveryConfig.OrgConfig.newBuilder().build())
            .addAllInspectTemplates(new ArrayList<String>())
            .addAllActions(new ArrayList<DataProfileAction>())
            .addAllTargets(new ArrayList<DiscoveryTarget>())
            .addAllErrors(new ArrayList<Error>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setLastRunTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-9409/locations/location-9409/discoveryConfigs/discoveryConfig-9409";
    DiscoveryConfig discoveryConfig = DiscoveryConfig.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    DiscoveryConfig actualResponse =
        client.updateDiscoveryConfig(name, discoveryConfig, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void updateDiscoveryConfigExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-9409/locations/location-9409/discoveryConfigs/discoveryConfig-9409";
      DiscoveryConfig discoveryConfig = DiscoveryConfig.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateDiscoveryConfig(name, discoveryConfig, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDiscoveryConfigTest() throws Exception {
    DiscoveryConfig expectedResponse =
        DiscoveryConfig.newBuilder()
            .setName(
                DiscoveryConfigName.of("[PROJECT]", "[LOCATION]", "[DISCOVERY_CONFIG]").toString())
            .setDisplayName("displayName1714148973")
            .setOrgConfig(DiscoveryConfig.OrgConfig.newBuilder().build())
            .addAllInspectTemplates(new ArrayList<String>())
            .addAllActions(new ArrayList<DataProfileAction>())
            .addAllTargets(new ArrayList<DiscoveryTarget>())
            .addAllErrors(new ArrayList<Error>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setLastRunTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    DiscoveryConfigName name =
        DiscoveryConfigName.of("[PROJECT]", "[LOCATION]", "[DISCOVERY_CONFIG]");

    DiscoveryConfig actualResponse = client.getDiscoveryConfig(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getDiscoveryConfigExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DiscoveryConfigName name =
          DiscoveryConfigName.of("[PROJECT]", "[LOCATION]", "[DISCOVERY_CONFIG]");
      client.getDiscoveryConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDiscoveryConfigTest2() throws Exception {
    DiscoveryConfig expectedResponse =
        DiscoveryConfig.newBuilder()
            .setName(
                DiscoveryConfigName.of("[PROJECT]", "[LOCATION]", "[DISCOVERY_CONFIG]").toString())
            .setDisplayName("displayName1714148973")
            .setOrgConfig(DiscoveryConfig.OrgConfig.newBuilder().build())
            .addAllInspectTemplates(new ArrayList<String>())
            .addAllActions(new ArrayList<DataProfileAction>())
            .addAllTargets(new ArrayList<DiscoveryTarget>())
            .addAllErrors(new ArrayList<Error>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setLastRunTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-9409/locations/location-9409/discoveryConfigs/discoveryConfig-9409";

    DiscoveryConfig actualResponse = client.getDiscoveryConfig(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getDiscoveryConfigExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-9409/locations/location-9409/discoveryConfigs/discoveryConfig-9409";
      client.getDiscoveryConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDiscoveryConfigsTest() throws Exception {
    DiscoveryConfig responsesElement = DiscoveryConfig.newBuilder().build();
    ListDiscoveryConfigsResponse expectedResponse =
        ListDiscoveryConfigsResponse.newBuilder()
            .setNextPageToken("")
            .addAllDiscoveryConfigs(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListDiscoveryConfigsPagedResponse pagedListResponse = client.listDiscoveryConfigs(parent);

    List<DiscoveryConfig> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDiscoveryConfigsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listDiscoveryConfigsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listDiscoveryConfigs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDiscoveryConfigsTest2() throws Exception {
    DiscoveryConfig responsesElement = DiscoveryConfig.newBuilder().build();
    ListDiscoveryConfigsResponse expectedResponse =
        ListDiscoveryConfigsResponse.newBuilder()
            .setNextPageToken("")
            .addAllDiscoveryConfigs(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListDiscoveryConfigsPagedResponse pagedListResponse = client.listDiscoveryConfigs(parent);

    List<DiscoveryConfig> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDiscoveryConfigsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listDiscoveryConfigsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listDiscoveryConfigs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteDiscoveryConfigTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    DiscoveryConfigName name =
        DiscoveryConfigName.of("[PROJECT]", "[LOCATION]", "[DISCOVERY_CONFIG]");

    client.deleteDiscoveryConfig(name);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteDiscoveryConfigExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DiscoveryConfigName name =
          DiscoveryConfigName.of("[PROJECT]", "[LOCATION]", "[DISCOVERY_CONFIG]");
      client.deleteDiscoveryConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteDiscoveryConfigTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-9409/locations/location-9409/discoveryConfigs/discoveryConfig-9409";

    client.deleteDiscoveryConfig(name);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteDiscoveryConfigExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-9409/locations/location-9409/discoveryConfigs/discoveryConfig-9409";
      client.deleteDiscoveryConfig(name);
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
            .setLastModified(Timestamp.newBuilder().build())
            .setJobTriggerName("jobTriggerName494333030")
            .addAllErrors(new ArrayList<Error>())
            .addAllActionDetails(new ArrayList<ActionDetails>())
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
            .setLastModified(Timestamp.newBuilder().build())
            .setJobTriggerName("jobTriggerName494333030")
            .addAllErrors(new ArrayList<Error>())
            .addAllActionDetails(new ArrayList<ActionDetails>())
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
            .setLastModified(Timestamp.newBuilder().build())
            .setJobTriggerName("jobTriggerName494333030")
            .addAllErrors(new ArrayList<Error>())
            .addAllActionDetails(new ArrayList<ActionDetails>())
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
            .setLastModified(Timestamp.newBuilder().build())
            .setJobTriggerName("jobTriggerName494333030")
            .addAllErrors(new ArrayList<Error>())
            .addAllActionDetails(new ArrayList<ActionDetails>())
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
            .setLastModified(Timestamp.newBuilder().build())
            .setJobTriggerName("jobTriggerName494333030")
            .addAllErrors(new ArrayList<Error>())
            .addAllActionDetails(new ArrayList<ActionDetails>())
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
            .setLastModified(Timestamp.newBuilder().build())
            .setJobTriggerName("jobTriggerName494333030")
            .addAllErrors(new ArrayList<Error>())
            .addAllActionDetails(new ArrayList<ActionDetails>())
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
            .setLastModified(Timestamp.newBuilder().build())
            .setJobTriggerName("jobTriggerName494333030")
            .addAllErrors(new ArrayList<Error>())
            .addAllActionDetails(new ArrayList<ActionDetails>())
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
            .setLastModified(Timestamp.newBuilder().build())
            .setJobTriggerName("jobTriggerName494333030")
            .addAllErrors(new ArrayList<Error>())
            .addAllActionDetails(new ArrayList<ActionDetails>())
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
  public void listProjectDataProfilesTest() throws Exception {
    ProjectDataProfile responsesElement = ProjectDataProfile.newBuilder().build();
    ListProjectDataProfilesResponse expectedResponse =
        ListProjectDataProfilesResponse.newBuilder()
            .setNextPageToken("")
            .addAllProjectDataProfiles(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListProjectDataProfilesPagedResponse pagedListResponse = client.listProjectDataProfiles(parent);

    List<ProjectDataProfile> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getProjectDataProfilesList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listProjectDataProfilesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listProjectDataProfiles(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listProjectDataProfilesTest2() throws Exception {
    ProjectDataProfile responsesElement = ProjectDataProfile.newBuilder().build();
    ListProjectDataProfilesResponse expectedResponse =
        ListProjectDataProfilesResponse.newBuilder()
            .setNextPageToken("")
            .addAllProjectDataProfiles(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");

    ListProjectDataProfilesPagedResponse pagedListResponse = client.listProjectDataProfiles(parent);

    List<ProjectDataProfile> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getProjectDataProfilesList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listProjectDataProfilesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
      client.listProjectDataProfiles(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listProjectDataProfilesTest3() throws Exception {
    ProjectDataProfile responsesElement = ProjectDataProfile.newBuilder().build();
    ListProjectDataProfilesResponse expectedResponse =
        ListProjectDataProfilesResponse.newBuilder()
            .setNextPageToken("")
            .addAllProjectDataProfiles(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "organizations/organization-9365/locations/location-9365";

    ListProjectDataProfilesPagedResponse pagedListResponse = client.listProjectDataProfiles(parent);

    List<ProjectDataProfile> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getProjectDataProfilesList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listProjectDataProfilesExceptionTest3() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "organizations/organization-9365/locations/location-9365";
      client.listProjectDataProfiles(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listTableDataProfilesTest() throws Exception {
    TableDataProfile responsesElement = TableDataProfile.newBuilder().build();
    ListTableDataProfilesResponse expectedResponse =
        ListTableDataProfilesResponse.newBuilder()
            .setNextPageToken("")
            .addAllTableDataProfiles(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListTableDataProfilesPagedResponse pagedListResponse = client.listTableDataProfiles(parent);

    List<TableDataProfile> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTableDataProfilesList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listTableDataProfilesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listTableDataProfiles(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listTableDataProfilesTest2() throws Exception {
    TableDataProfile responsesElement = TableDataProfile.newBuilder().build();
    ListTableDataProfilesResponse expectedResponse =
        ListTableDataProfilesResponse.newBuilder()
            .setNextPageToken("")
            .addAllTableDataProfiles(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");

    ListTableDataProfilesPagedResponse pagedListResponse = client.listTableDataProfiles(parent);

    List<TableDataProfile> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTableDataProfilesList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listTableDataProfilesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
      client.listTableDataProfiles(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listTableDataProfilesTest3() throws Exception {
    TableDataProfile responsesElement = TableDataProfile.newBuilder().build();
    ListTableDataProfilesResponse expectedResponse =
        ListTableDataProfilesResponse.newBuilder()
            .setNextPageToken("")
            .addAllTableDataProfiles(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "organizations/organization-9365/locations/location-9365";

    ListTableDataProfilesPagedResponse pagedListResponse = client.listTableDataProfiles(parent);

    List<TableDataProfile> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTableDataProfilesList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listTableDataProfilesExceptionTest3() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "organizations/organization-9365/locations/location-9365";
      client.listTableDataProfiles(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listColumnDataProfilesTest() throws Exception {
    ColumnDataProfile responsesElement = ColumnDataProfile.newBuilder().build();
    ListColumnDataProfilesResponse expectedResponse =
        ListColumnDataProfilesResponse.newBuilder()
            .setNextPageToken("")
            .addAllColumnDataProfiles(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListColumnDataProfilesPagedResponse pagedListResponse = client.listColumnDataProfiles(parent);

    List<ColumnDataProfile> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getColumnDataProfilesList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listColumnDataProfilesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listColumnDataProfiles(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listColumnDataProfilesTest2() throws Exception {
    ColumnDataProfile responsesElement = ColumnDataProfile.newBuilder().build();
    ListColumnDataProfilesResponse expectedResponse =
        ListColumnDataProfilesResponse.newBuilder()
            .setNextPageToken("")
            .addAllColumnDataProfiles(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");

    ListColumnDataProfilesPagedResponse pagedListResponse = client.listColumnDataProfiles(parent);

    List<ColumnDataProfile> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getColumnDataProfilesList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listColumnDataProfilesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
      client.listColumnDataProfiles(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listColumnDataProfilesTest3() throws Exception {
    ColumnDataProfile responsesElement = ColumnDataProfile.newBuilder().build();
    ListColumnDataProfilesResponse expectedResponse =
        ListColumnDataProfilesResponse.newBuilder()
            .setNextPageToken("")
            .addAllColumnDataProfiles(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "organizations/organization-9365/locations/location-9365";

    ListColumnDataProfilesPagedResponse pagedListResponse = client.listColumnDataProfiles(parent);

    List<ColumnDataProfile> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getColumnDataProfilesList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listColumnDataProfilesExceptionTest3() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "organizations/organization-9365/locations/location-9365";
      client.listColumnDataProfiles(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getProjectDataProfileTest() throws Exception {
    ProjectDataProfile expectedResponse =
        ProjectDataProfile.newBuilder()
            .setName(
                ProjectDataProfileName.ofOrganizationLocationProjectDataProfileName(
                        "[ORGANIZATION]", "[LOCATION]", "[PROJECT_DATA_PROFILE]")
                    .toString())
            .setProjectId("projectId-894832108")
            .setProfileLastGenerated(Timestamp.newBuilder().build())
            .setSensitivityScore(SensitivityScore.newBuilder().build())
            .setDataRiskLevel(DataRiskLevel.newBuilder().build())
            .setProfileStatus(ProfileStatus.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    ProjectDataProfileName name =
        ProjectDataProfileName.ofOrganizationLocationProjectDataProfileName(
            "[ORGANIZATION]", "[LOCATION]", "[PROJECT_DATA_PROFILE]");

    ProjectDataProfile actualResponse = client.getProjectDataProfile(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getProjectDataProfileExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ProjectDataProfileName name =
          ProjectDataProfileName.ofOrganizationLocationProjectDataProfileName(
              "[ORGANIZATION]", "[LOCATION]", "[PROJECT_DATA_PROFILE]");
      client.getProjectDataProfile(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getProjectDataProfileTest2() throws Exception {
    ProjectDataProfile expectedResponse =
        ProjectDataProfile.newBuilder()
            .setName(
                ProjectDataProfileName.ofOrganizationLocationProjectDataProfileName(
                        "[ORGANIZATION]", "[LOCATION]", "[PROJECT_DATA_PROFILE]")
                    .toString())
            .setProjectId("projectId-894832108")
            .setProfileLastGenerated(Timestamp.newBuilder().build())
            .setSensitivityScore(SensitivityScore.newBuilder().build())
            .setDataRiskLevel(DataRiskLevel.newBuilder().build())
            .setProfileStatus(ProfileStatus.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "organizations/organization-541/locations/location-541/projectDataProfiles/projectDataProfile-541";

    ProjectDataProfile actualResponse = client.getProjectDataProfile(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getProjectDataProfileExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "organizations/organization-541/locations/location-541/projectDataProfiles/projectDataProfile-541";
      client.getProjectDataProfile(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getTableDataProfileTest() throws Exception {
    TableDataProfile expectedResponse =
        TableDataProfile.newBuilder()
            .setName(
                TableDataProfileName.ofOrganizationLocationTableDataProfileName(
                        "[ORGANIZATION]", "[LOCATION]", "[TABLE_DATA_PROFILE]")
                    .toString())
            .setDataSourceType(DataSourceType.newBuilder().build())
            .setProjectDataProfile("projectDataProfile-1125465658")
            .setDatasetProjectId("datasetProjectId128836732")
            .setDatasetLocation("datasetLocation-1806712755")
            .setDatasetId("datasetId-345342029")
            .setTableId("tableId-1552905847")
            .setFullResource("fullResource-1464972355")
            .setProfileStatus(ProfileStatus.newBuilder().build())
            .setSensitivityScore(SensitivityScore.newBuilder().build())
            .setDataRiskLevel(DataRiskLevel.newBuilder().build())
            .addAllPredictedInfoTypes(new ArrayList<InfoTypeSummary>())
            .addAllOtherInfoTypes(new ArrayList<OtherInfoTypeSummary>())
            .setConfigSnapshot(DataProfileConfigSnapshot.newBuilder().build())
            .setLastModifiedTime(Timestamp.newBuilder().build())
            .setExpirationTime(Timestamp.newBuilder().build())
            .setScannedColumnCount(-787756843)
            .setFailedColumnCount(-706572376)
            .setTableSizeBytes(927763390)
            .setRowCount(1340416618)
            .setEncryptionStatus(EncryptionStatus.forNumber(0))
            .setResourceVisibility(ResourceVisibility.forNumber(0))
            .setProfileLastGenerated(Timestamp.newBuilder().build())
            .putAllResourceLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    TableDataProfileName name =
        TableDataProfileName.ofOrganizationLocationTableDataProfileName(
            "[ORGANIZATION]", "[LOCATION]", "[TABLE_DATA_PROFILE]");

    TableDataProfile actualResponse = client.getTableDataProfile(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getTableDataProfileExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      TableDataProfileName name =
          TableDataProfileName.ofOrganizationLocationTableDataProfileName(
              "[ORGANIZATION]", "[LOCATION]", "[TABLE_DATA_PROFILE]");
      client.getTableDataProfile(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getTableDataProfileTest2() throws Exception {
    TableDataProfile expectedResponse =
        TableDataProfile.newBuilder()
            .setName(
                TableDataProfileName.ofOrganizationLocationTableDataProfileName(
                        "[ORGANIZATION]", "[LOCATION]", "[TABLE_DATA_PROFILE]")
                    .toString())
            .setDataSourceType(DataSourceType.newBuilder().build())
            .setProjectDataProfile("projectDataProfile-1125465658")
            .setDatasetProjectId("datasetProjectId128836732")
            .setDatasetLocation("datasetLocation-1806712755")
            .setDatasetId("datasetId-345342029")
            .setTableId("tableId-1552905847")
            .setFullResource("fullResource-1464972355")
            .setProfileStatus(ProfileStatus.newBuilder().build())
            .setSensitivityScore(SensitivityScore.newBuilder().build())
            .setDataRiskLevel(DataRiskLevel.newBuilder().build())
            .addAllPredictedInfoTypes(new ArrayList<InfoTypeSummary>())
            .addAllOtherInfoTypes(new ArrayList<OtherInfoTypeSummary>())
            .setConfigSnapshot(DataProfileConfigSnapshot.newBuilder().build())
            .setLastModifiedTime(Timestamp.newBuilder().build())
            .setExpirationTime(Timestamp.newBuilder().build())
            .setScannedColumnCount(-787756843)
            .setFailedColumnCount(-706572376)
            .setTableSizeBytes(927763390)
            .setRowCount(1340416618)
            .setEncryptionStatus(EncryptionStatus.forNumber(0))
            .setResourceVisibility(ResourceVisibility.forNumber(0))
            .setProfileLastGenerated(Timestamp.newBuilder().build())
            .putAllResourceLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "organizations/organization-2552/locations/location-2552/tableDataProfiles/tableDataProfile-2552";

    TableDataProfile actualResponse = client.getTableDataProfile(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getTableDataProfileExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "organizations/organization-2552/locations/location-2552/tableDataProfiles/tableDataProfile-2552";
      client.getTableDataProfile(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getColumnDataProfileTest() throws Exception {
    ColumnDataProfile expectedResponse =
        ColumnDataProfile.newBuilder()
            .setName(
                ColumnDataProfileName.ofOrganizationLocationColumnDataProfileName(
                        "[ORGANIZATION]", "[LOCATION]", "[COLUMN_DATA_PROFILE]")
                    .toString())
            .setProfileStatus(ProfileStatus.newBuilder().build())
            .setProfileLastGenerated(Timestamp.newBuilder().build())
            .setTableDataProfile("tableDataProfile1513012721")
            .setTableFullResource("tableFullResource-2131192149")
            .setDatasetProjectId("datasetProjectId128836732")
            .setDatasetLocation("datasetLocation-1806712755")
            .setDatasetId("datasetId-345342029")
            .setTableId("tableId-1552905847")
            .setColumn("column-1354837162")
            .setSensitivityScore(SensitivityScore.newBuilder().build())
            .setDataRiskLevel(DataRiskLevel.newBuilder().build())
            .setColumnInfoType(InfoTypeSummary.newBuilder().build())
            .addAllOtherMatches(new ArrayList<OtherInfoTypeSummary>())
            .setEstimatedNullPercentage(NullPercentageLevel.forNumber(0))
            .setEstimatedUniquenessScore(UniquenessScoreLevel.forNumber(0))
            .setFreeTextScore(1218237619)
            .build();
    mockService.addResponse(expectedResponse);

    ColumnDataProfileName name =
        ColumnDataProfileName.ofOrganizationLocationColumnDataProfileName(
            "[ORGANIZATION]", "[LOCATION]", "[COLUMN_DATA_PROFILE]");

    ColumnDataProfile actualResponse = client.getColumnDataProfile(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getColumnDataProfileExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ColumnDataProfileName name =
          ColumnDataProfileName.ofOrganizationLocationColumnDataProfileName(
              "[ORGANIZATION]", "[LOCATION]", "[COLUMN_DATA_PROFILE]");
      client.getColumnDataProfile(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getColumnDataProfileTest2() throws Exception {
    ColumnDataProfile expectedResponse =
        ColumnDataProfile.newBuilder()
            .setName(
                ColumnDataProfileName.ofOrganizationLocationColumnDataProfileName(
                        "[ORGANIZATION]", "[LOCATION]", "[COLUMN_DATA_PROFILE]")
                    .toString())
            .setProfileStatus(ProfileStatus.newBuilder().build())
            .setProfileLastGenerated(Timestamp.newBuilder().build())
            .setTableDataProfile("tableDataProfile1513012721")
            .setTableFullResource("tableFullResource-2131192149")
            .setDatasetProjectId("datasetProjectId128836732")
            .setDatasetLocation("datasetLocation-1806712755")
            .setDatasetId("datasetId-345342029")
            .setTableId("tableId-1552905847")
            .setColumn("column-1354837162")
            .setSensitivityScore(SensitivityScore.newBuilder().build())
            .setDataRiskLevel(DataRiskLevel.newBuilder().build())
            .setColumnInfoType(InfoTypeSummary.newBuilder().build())
            .addAllOtherMatches(new ArrayList<OtherInfoTypeSummary>())
            .setEstimatedNullPercentage(NullPercentageLevel.forNumber(0))
            .setEstimatedUniquenessScore(UniquenessScoreLevel.forNumber(0))
            .setFreeTextScore(1218237619)
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "organizations/organization-902/locations/location-902/columnDataProfiles/columnDataProfile-902";

    ColumnDataProfile actualResponse = client.getColumnDataProfile(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getColumnDataProfileExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "organizations/organization-902/locations/location-902/columnDataProfiles/columnDataProfile-902";
      client.getColumnDataProfile(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteTableDataProfileTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    TableDataProfileName name =
        TableDataProfileName.ofOrganizationLocationTableDataProfileName(
            "[ORGANIZATION]", "[LOCATION]", "[TABLE_DATA_PROFILE]");

    client.deleteTableDataProfile(name);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteTableDataProfileExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      TableDataProfileName name =
          TableDataProfileName.ofOrganizationLocationTableDataProfileName(
              "[ORGANIZATION]", "[LOCATION]", "[TABLE_DATA_PROFILE]");
      client.deleteTableDataProfile(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteTableDataProfileTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name =
        "organizations/organization-2552/locations/location-2552/tableDataProfiles/tableDataProfile-2552";

    client.deleteTableDataProfile(name);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteTableDataProfileExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "organizations/organization-2552/locations/location-2552/tableDataProfiles/tableDataProfile-2552";
      client.deleteTableDataProfile(name);
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

  @Test
  public void createConnectionTest() throws Exception {
    Connection expectedResponse =
        Connection.newBuilder()
            .setName(ConnectionName.of("[PROJECT]", "[LOCATION]", "[CONNECTION]").toString())
            .setState(ConnectionState.forNumber(0))
            .addAllErrors(new ArrayList<Error>())
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Connection connection = Connection.newBuilder().build();

    Connection actualResponse = client.createConnection(parent, connection);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
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
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Connection connection = Connection.newBuilder().build();
      client.createConnection(parent, connection);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createConnectionTest2() throws Exception {
    Connection expectedResponse =
        Connection.newBuilder()
            .setName(ConnectionName.of("[PROJECT]", "[LOCATION]", "[CONNECTION]").toString())
            .setState(ConnectionState.forNumber(0))
            .addAllErrors(new ArrayList<Error>())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";
    Connection connection = Connection.newBuilder().build();

    Connection actualResponse = client.createConnection(parent, connection);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
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
      String parent = "projects/project-5833/locations/location-5833";
      Connection connection = Connection.newBuilder().build();
      client.createConnection(parent, connection);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getConnectionTest() throws Exception {
    Connection expectedResponse =
        Connection.newBuilder()
            .setName(ConnectionName.of("[PROJECT]", "[LOCATION]", "[CONNECTION]").toString())
            .setState(ConnectionState.forNumber(0))
            .addAllErrors(new ArrayList<Error>())
            .build();
    mockService.addResponse(expectedResponse);

    ConnectionName name = ConnectionName.of("[PROJECT]", "[LOCATION]", "[CONNECTION]");

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
      ConnectionName name = ConnectionName.of("[PROJECT]", "[LOCATION]", "[CONNECTION]");
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
            .setName(ConnectionName.of("[PROJECT]", "[LOCATION]", "[CONNECTION]").toString())
            .setState(ConnectionState.forNumber(0))
            .addAllErrors(new ArrayList<Error>())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-7851/locations/location-7851/connections/connection-7851";

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
      String name = "projects/project-7851/locations/location-7851/connections/connection-7851";
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

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

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
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
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

    String parent = "projects/project-5833/locations/location-5833";

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
      String parent = "projects/project-5833/locations/location-5833";
      client.listConnections(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void searchConnectionsTest() throws Exception {
    Connection responsesElement = Connection.newBuilder().build();
    SearchConnectionsResponse expectedResponse =
        SearchConnectionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllConnections(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    SearchConnectionsPagedResponse pagedListResponse = client.searchConnections(parent);

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
  public void searchConnectionsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.searchConnections(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void searchConnectionsTest2() throws Exception {
    Connection responsesElement = Connection.newBuilder().build();
    SearchConnectionsResponse expectedResponse =
        SearchConnectionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllConnections(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    SearchConnectionsPagedResponse pagedListResponse = client.searchConnections(parent);

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
  public void searchConnectionsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.searchConnections(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteConnectionTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    ConnectionName name = ConnectionName.of("[PROJECT]", "[LOCATION]", "[CONNECTION]");

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
      ConnectionName name = ConnectionName.of("[PROJECT]", "[LOCATION]", "[CONNECTION]");
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

    String name = "projects/project-7851/locations/location-7851/connections/connection-7851";

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
      String name = "projects/project-7851/locations/location-7851/connections/connection-7851";
      client.deleteConnection(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateConnectionTest() throws Exception {
    Connection expectedResponse =
        Connection.newBuilder()
            .setName(ConnectionName.of("[PROJECT]", "[LOCATION]", "[CONNECTION]").toString())
            .setState(ConnectionState.forNumber(0))
            .addAllErrors(new ArrayList<Error>())
            .build();
    mockService.addResponse(expectedResponse);

    ConnectionName name = ConnectionName.of("[PROJECT]", "[LOCATION]", "[CONNECTION]");

    Connection actualResponse = client.updateConnection(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
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
      ConnectionName name = ConnectionName.of("[PROJECT]", "[LOCATION]", "[CONNECTION]");
      client.updateConnection(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateConnectionTest2() throws Exception {
    Connection expectedResponse =
        Connection.newBuilder()
            .setName(ConnectionName.of("[PROJECT]", "[LOCATION]", "[CONNECTION]").toString())
            .setState(ConnectionState.forNumber(0))
            .addAllErrors(new ArrayList<Error>())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-7851/locations/location-7851/connections/connection-7851";

    Connection actualResponse = client.updateConnection(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void updateConnectionExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-7851/locations/location-7851/connections/connection-7851";
      client.updateConnection(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
