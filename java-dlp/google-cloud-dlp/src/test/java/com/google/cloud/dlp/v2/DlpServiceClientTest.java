/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
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
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.common.collect.Lists;
import com.google.privacy.dlp.v2.CancelDlpJobRequest;
import com.google.privacy.dlp.v2.CreateDeidentifyTemplateRequest;
import com.google.privacy.dlp.v2.CreateDlpJobRequest;
import com.google.privacy.dlp.v2.CreateInspectTemplateRequest;
import com.google.privacy.dlp.v2.CreateJobTriggerRequest;
import com.google.privacy.dlp.v2.CreateStoredInfoTypeRequest;
import com.google.privacy.dlp.v2.DeidentifyContentRequest;
import com.google.privacy.dlp.v2.DeidentifyContentResponse;
import com.google.privacy.dlp.v2.DeidentifyTemplate;
import com.google.privacy.dlp.v2.DeidentifyTemplateName;
import com.google.privacy.dlp.v2.DeleteDeidentifyTemplateRequest;
import com.google.privacy.dlp.v2.DeleteDlpJobRequest;
import com.google.privacy.dlp.v2.DeleteInspectTemplateRequest;
import com.google.privacy.dlp.v2.DeleteJobTriggerRequest;
import com.google.privacy.dlp.v2.DeleteStoredInfoTypeRequest;
import com.google.privacy.dlp.v2.DlpJob;
import com.google.privacy.dlp.v2.DlpJobName;
import com.google.privacy.dlp.v2.FinishDlpJobRequest;
import com.google.privacy.dlp.v2.GetDeidentifyTemplateRequest;
import com.google.privacy.dlp.v2.GetDlpJobRequest;
import com.google.privacy.dlp.v2.GetInspectTemplateRequest;
import com.google.privacy.dlp.v2.GetJobTriggerRequest;
import com.google.privacy.dlp.v2.GetStoredInfoTypeRequest;
import com.google.privacy.dlp.v2.HybridInspectDlpJobRequest;
import com.google.privacy.dlp.v2.HybridInspectJobTriggerRequest;
import com.google.privacy.dlp.v2.HybridInspectResponse;
import com.google.privacy.dlp.v2.InspectContentRequest;
import com.google.privacy.dlp.v2.InspectContentResponse;
import com.google.privacy.dlp.v2.InspectJobConfig;
import com.google.privacy.dlp.v2.InspectTemplate;
import com.google.privacy.dlp.v2.InspectTemplateName;
import com.google.privacy.dlp.v2.JobTrigger;
import com.google.privacy.dlp.v2.JobTriggerName;
import com.google.privacy.dlp.v2.ListDeidentifyTemplatesRequest;
import com.google.privacy.dlp.v2.ListDeidentifyTemplatesResponse;
import com.google.privacy.dlp.v2.ListDlpJobsRequest;
import com.google.privacy.dlp.v2.ListDlpJobsResponse;
import com.google.privacy.dlp.v2.ListInfoTypesRequest;
import com.google.privacy.dlp.v2.ListInfoTypesResponse;
import com.google.privacy.dlp.v2.ListInspectTemplatesRequest;
import com.google.privacy.dlp.v2.ListInspectTemplatesResponse;
import com.google.privacy.dlp.v2.ListJobTriggersRequest;
import com.google.privacy.dlp.v2.ListJobTriggersResponse;
import com.google.privacy.dlp.v2.ListStoredInfoTypesRequest;
import com.google.privacy.dlp.v2.ListStoredInfoTypesResponse;
import com.google.privacy.dlp.v2.OrganizationLocationName;
import com.google.privacy.dlp.v2.ProjectName;
import com.google.privacy.dlp.v2.RedactImageRequest;
import com.google.privacy.dlp.v2.RedactImageResponse;
import com.google.privacy.dlp.v2.ReidentifyContentRequest;
import com.google.privacy.dlp.v2.ReidentifyContentResponse;
import com.google.privacy.dlp.v2.RiskAnalysisJobConfig;
import com.google.privacy.dlp.v2.StoredInfoType;
import com.google.privacy.dlp.v2.StoredInfoTypeConfig;
import com.google.privacy.dlp.v2.StoredInfoTypeName;
import com.google.privacy.dlp.v2.UpdateDeidentifyTemplateRequest;
import com.google.privacy.dlp.v2.UpdateInspectTemplateRequest;
import com.google.privacy.dlp.v2.UpdateJobTriggerRequest;
import com.google.privacy.dlp.v2.UpdateStoredInfoTypeRequest;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.ByteString;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@javax.annotation.Generated("by GAPIC")
public class DlpServiceClientTest {
  private static MockDlpService mockDlpService;
  private static MockServiceHelper serviceHelper;
  private DlpServiceClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockDlpService = new MockDlpService();
    serviceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockDlpService));
    serviceHelper.start();
  }

  @AfterClass
  public static void stopServer() {
    serviceHelper.stop();
  }

  @Before
  public void setUp() throws IOException {
    serviceHelper.reset();
    channelProvider = serviceHelper.createChannelProvider();
    DlpServiceSettings settings =
        DlpServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = DlpServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void inspectContentTest() {
    InspectContentResponse expectedResponse = InspectContentResponse.newBuilder().build();
    mockDlpService.addResponse(expectedResponse);

    InspectContentRequest request = InspectContentRequest.newBuilder().build();

    InspectContentResponse actualResponse = client.inspectContent(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDlpService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    InspectContentRequest actualRequest = (InspectContentRequest) actualRequests.get(0);

    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void inspectContentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDlpService.addException(exception);

    try {
      InspectContentRequest request = InspectContentRequest.newBuilder().build();

      client.inspectContent(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void redactImageTest() {
    ByteString redactedImage = ByteString.copyFromUtf8("28");
    String extractedText = "extractedText998260012";
    RedactImageResponse expectedResponse =
        RedactImageResponse.newBuilder()
            .setRedactedImage(redactedImage)
            .setExtractedText(extractedText)
            .build();
    mockDlpService.addResponse(expectedResponse);

    RedactImageRequest request = RedactImageRequest.newBuilder().build();

    RedactImageResponse actualResponse = client.redactImage(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDlpService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RedactImageRequest actualRequest = (RedactImageRequest) actualRequests.get(0);

    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void redactImageExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDlpService.addException(exception);

    try {
      RedactImageRequest request = RedactImageRequest.newBuilder().build();

      client.redactImage(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deidentifyContentTest() {
    DeidentifyContentResponse expectedResponse = DeidentifyContentResponse.newBuilder().build();
    mockDlpService.addResponse(expectedResponse);

    DeidentifyContentRequest request = DeidentifyContentRequest.newBuilder().build();

    DeidentifyContentResponse actualResponse = client.deidentifyContent(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDlpService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeidentifyContentRequest actualRequest = (DeidentifyContentRequest) actualRequests.get(0);

    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void deidentifyContentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDlpService.addException(exception);

    try {
      DeidentifyContentRequest request = DeidentifyContentRequest.newBuilder().build();

      client.deidentifyContent(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void reidentifyContentTest() {
    ReidentifyContentResponse expectedResponse = ReidentifyContentResponse.newBuilder().build();
    mockDlpService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");
    ReidentifyContentRequest request =
        ReidentifyContentRequest.newBuilder().setParent(parent.toString()).build();

    ReidentifyContentResponse actualResponse = client.reidentifyContent(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDlpService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ReidentifyContentRequest actualRequest = (ReidentifyContentRequest) actualRequests.get(0);

    Assert.assertEquals(parent, ProjectName.parse(actualRequest.getParent()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void reidentifyContentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDlpService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      ReidentifyContentRequest request =
          ReidentifyContentRequest.newBuilder().setParent(parent.toString()).build();

      client.reidentifyContent(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listInfoTypesTest() {
    ListInfoTypesResponse expectedResponse = ListInfoTypesResponse.newBuilder().build();
    mockDlpService.addResponse(expectedResponse);

    String locationId = "locationId552319461";

    ListInfoTypesResponse actualResponse = client.listInfoTypes(locationId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDlpService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListInfoTypesRequest actualRequest = (ListInfoTypesRequest) actualRequests.get(0);

    Assert.assertEquals(locationId, actualRequest.getLocationId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listInfoTypesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDlpService.addException(exception);

    try {
      String locationId = "locationId552319461";

      client.listInfoTypes(locationId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createInspectTemplateTest() {
    InspectTemplateName name =
        InspectTemplateName.ofOrganizationInspectTemplateName(
            "[ORGANIZATION]", "[INSPECT_TEMPLATE]");
    String displayName = "displayName1615086568";
    String description = "description-1724546052";
    InspectTemplate expectedResponse =
        InspectTemplate.newBuilder()
            .setName(name.toString())
            .setDisplayName(displayName)
            .setDescription(description)
            .build();
    mockDlpService.addResponse(expectedResponse);

    OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
    InspectTemplate inspectTemplate = InspectTemplate.newBuilder().build();

    InspectTemplate actualResponse = client.createInspectTemplate(parent, inspectTemplate);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDlpService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateInspectTemplateRequest actualRequest =
        (CreateInspectTemplateRequest) actualRequests.get(0);

    Assert.assertEquals(parent, OrganizationLocationName.parse(actualRequest.getParent()));
    Assert.assertEquals(inspectTemplate, actualRequest.getInspectTemplate());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createInspectTemplateExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDlpService.addException(exception);

    try {
      OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
      InspectTemplate inspectTemplate = InspectTemplate.newBuilder().build();

      client.createInspectTemplate(parent, inspectTemplate);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createInspectTemplateTest2() {
    InspectTemplateName name =
        InspectTemplateName.ofOrganizationInspectTemplateName(
            "[ORGANIZATION]", "[INSPECT_TEMPLATE]");
    String displayName = "displayName1615086568";
    String description = "description-1724546052";
    InspectTemplate expectedResponse =
        InspectTemplate.newBuilder()
            .setName(name.toString())
            .setDisplayName(displayName)
            .setDescription(description)
            .build();
    mockDlpService.addResponse(expectedResponse);

    OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
    InspectTemplate inspectTemplate = InspectTemplate.newBuilder().build();
    String locationId = "locationId552319461";

    InspectTemplate actualResponse =
        client.createInspectTemplate(parent, inspectTemplate, locationId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDlpService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateInspectTemplateRequest actualRequest =
        (CreateInspectTemplateRequest) actualRequests.get(0);

    Assert.assertEquals(parent, OrganizationLocationName.parse(actualRequest.getParent()));
    Assert.assertEquals(inspectTemplate, actualRequest.getInspectTemplate());
    Assert.assertEquals(locationId, actualRequest.getLocationId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createInspectTemplateExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDlpService.addException(exception);

    try {
      OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
      InspectTemplate inspectTemplate = InspectTemplate.newBuilder().build();
      String locationId = "locationId552319461";

      client.createInspectTemplate(parent, inspectTemplate, locationId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateInspectTemplateTest() {
    InspectTemplateName name2 =
        InspectTemplateName.ofOrganizationInspectTemplateName(
            "[ORGANIZATION]", "[INSPECT_TEMPLATE]");
    String displayName = "displayName1615086568";
    String description = "description-1724546052";
    InspectTemplate expectedResponse =
        InspectTemplate.newBuilder()
            .setName(name2.toString())
            .setDisplayName(displayName)
            .setDescription(description)
            .build();
    mockDlpService.addResponse(expectedResponse);

    InspectTemplateName name =
        InspectTemplateName.ofOrganizationInspectTemplateName(
            "[ORGANIZATION]", "[INSPECT_TEMPLATE]");
    InspectTemplate inspectTemplate = InspectTemplate.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    InspectTemplate actualResponse =
        client.updateInspectTemplate(name, inspectTemplate, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDlpService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateInspectTemplateRequest actualRequest =
        (UpdateInspectTemplateRequest) actualRequests.get(0);

    Assert.assertEquals(name, InspectTemplateName.parse(actualRequest.getName()));
    Assert.assertEquals(inspectTemplate, actualRequest.getInspectTemplate());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void updateInspectTemplateExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDlpService.addException(exception);

    try {
      InspectTemplateName name =
          InspectTemplateName.ofOrganizationInspectTemplateName(
              "[ORGANIZATION]", "[INSPECT_TEMPLATE]");
      InspectTemplate inspectTemplate = InspectTemplate.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();

      client.updateInspectTemplate(name, inspectTemplate, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getInspectTemplateTest() {
    InspectTemplateName name2 =
        InspectTemplateName.ofOrganizationInspectTemplateName(
            "[ORGANIZATION]", "[INSPECT_TEMPLATE]");
    String displayName = "displayName1615086568";
    String description = "description-1724546052";
    InspectTemplate expectedResponse =
        InspectTemplate.newBuilder()
            .setName(name2.toString())
            .setDisplayName(displayName)
            .setDescription(description)
            .build();
    mockDlpService.addResponse(expectedResponse);

    InspectTemplateName name =
        InspectTemplateName.ofOrganizationInspectTemplateName(
            "[ORGANIZATION]", "[INSPECT_TEMPLATE]");

    InspectTemplate actualResponse = client.getInspectTemplate(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDlpService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetInspectTemplateRequest actualRequest = (GetInspectTemplateRequest) actualRequests.get(0);

    Assert.assertEquals(name, InspectTemplateName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getInspectTemplateExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDlpService.addException(exception);

    try {
      InspectTemplateName name =
          InspectTemplateName.ofOrganizationInspectTemplateName(
              "[ORGANIZATION]", "[INSPECT_TEMPLATE]");

      client.getInspectTemplate(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listInspectTemplatesTest() {
    String nextPageToken = "";
    InspectTemplate inspectTemplatesElement = InspectTemplate.newBuilder().build();
    List<InspectTemplate> inspectTemplates = Arrays.asList(inspectTemplatesElement);
    ListInspectTemplatesResponse expectedResponse =
        ListInspectTemplatesResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllInspectTemplates(inspectTemplates)
            .build();
    mockDlpService.addResponse(expectedResponse);

    OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");

    ListInspectTemplatesPagedResponse pagedListResponse = client.listInspectTemplates(parent);

    List<InspectTemplate> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getInspectTemplatesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDlpService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListInspectTemplatesRequest actualRequest = (ListInspectTemplatesRequest) actualRequests.get(0);

    Assert.assertEquals(parent, OrganizationLocationName.parse(actualRequest.getParent()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listInspectTemplatesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDlpService.addException(exception);

    try {
      OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");

      client.listInspectTemplates(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deleteInspectTemplateTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    mockDlpService.addResponse(expectedResponse);

    InspectTemplateName name =
        InspectTemplateName.ofOrganizationInspectTemplateName(
            "[ORGANIZATION]", "[INSPECT_TEMPLATE]");

    client.deleteInspectTemplate(name);

    List<AbstractMessage> actualRequests = mockDlpService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteInspectTemplateRequest actualRequest =
        (DeleteInspectTemplateRequest) actualRequests.get(0);

    Assert.assertEquals(name, InspectTemplateName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void deleteInspectTemplateExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDlpService.addException(exception);

    try {
      InspectTemplateName name =
          InspectTemplateName.ofOrganizationInspectTemplateName(
              "[ORGANIZATION]", "[INSPECT_TEMPLATE]");

      client.deleteInspectTemplate(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createDeidentifyTemplateTest() {
    DeidentifyTemplateName name =
        DeidentifyTemplateName.ofOrganizationDeidentifyTemplateName(
            "[ORGANIZATION]", "[DEIDENTIFY_TEMPLATE]");
    String displayName = "displayName1615086568";
    String description = "description-1724546052";
    DeidentifyTemplate expectedResponse =
        DeidentifyTemplate.newBuilder()
            .setName(name.toString())
            .setDisplayName(displayName)
            .setDescription(description)
            .build();
    mockDlpService.addResponse(expectedResponse);

    OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
    DeidentifyTemplate deidentifyTemplate = DeidentifyTemplate.newBuilder().build();

    DeidentifyTemplate actualResponse = client.createDeidentifyTemplate(parent, deidentifyTemplate);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDlpService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateDeidentifyTemplateRequest actualRequest =
        (CreateDeidentifyTemplateRequest) actualRequests.get(0);

    Assert.assertEquals(parent, OrganizationLocationName.parse(actualRequest.getParent()));
    Assert.assertEquals(deidentifyTemplate, actualRequest.getDeidentifyTemplate());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createDeidentifyTemplateExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDlpService.addException(exception);

    try {
      OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
      DeidentifyTemplate deidentifyTemplate = DeidentifyTemplate.newBuilder().build();

      client.createDeidentifyTemplate(parent, deidentifyTemplate);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createDeidentifyTemplateTest2() {
    DeidentifyTemplateName name =
        DeidentifyTemplateName.ofOrganizationDeidentifyTemplateName(
            "[ORGANIZATION]", "[DEIDENTIFY_TEMPLATE]");
    String displayName = "displayName1615086568";
    String description = "description-1724546052";
    DeidentifyTemplate expectedResponse =
        DeidentifyTemplate.newBuilder()
            .setName(name.toString())
            .setDisplayName(displayName)
            .setDescription(description)
            .build();
    mockDlpService.addResponse(expectedResponse);

    OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
    DeidentifyTemplate deidentifyTemplate = DeidentifyTemplate.newBuilder().build();
    String locationId = "locationId552319461";

    DeidentifyTemplate actualResponse =
        client.createDeidentifyTemplate(parent, deidentifyTemplate, locationId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDlpService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateDeidentifyTemplateRequest actualRequest =
        (CreateDeidentifyTemplateRequest) actualRequests.get(0);

    Assert.assertEquals(parent, OrganizationLocationName.parse(actualRequest.getParent()));
    Assert.assertEquals(deidentifyTemplate, actualRequest.getDeidentifyTemplate());
    Assert.assertEquals(locationId, actualRequest.getLocationId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createDeidentifyTemplateExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDlpService.addException(exception);

    try {
      OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
      DeidentifyTemplate deidentifyTemplate = DeidentifyTemplate.newBuilder().build();
      String locationId = "locationId552319461";

      client.createDeidentifyTemplate(parent, deidentifyTemplate, locationId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateDeidentifyTemplateTest() {
    DeidentifyTemplateName name2 =
        DeidentifyTemplateName.ofOrganizationDeidentifyTemplateName(
            "[ORGANIZATION]", "[DEIDENTIFY_TEMPLATE]");
    String displayName = "displayName1615086568";
    String description = "description-1724546052";
    DeidentifyTemplate expectedResponse =
        DeidentifyTemplate.newBuilder()
            .setName(name2.toString())
            .setDisplayName(displayName)
            .setDescription(description)
            .build();
    mockDlpService.addResponse(expectedResponse);

    DeidentifyTemplateName name =
        DeidentifyTemplateName.ofOrganizationDeidentifyTemplateName(
            "[ORGANIZATION]", "[DEIDENTIFY_TEMPLATE]");
    DeidentifyTemplate deidentifyTemplate = DeidentifyTemplate.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    DeidentifyTemplate actualResponse =
        client.updateDeidentifyTemplate(name, deidentifyTemplate, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDlpService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateDeidentifyTemplateRequest actualRequest =
        (UpdateDeidentifyTemplateRequest) actualRequests.get(0);

    Assert.assertEquals(name, DeidentifyTemplateName.parse(actualRequest.getName()));
    Assert.assertEquals(deidentifyTemplate, actualRequest.getDeidentifyTemplate());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void updateDeidentifyTemplateExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDlpService.addException(exception);

    try {
      DeidentifyTemplateName name =
          DeidentifyTemplateName.ofOrganizationDeidentifyTemplateName(
              "[ORGANIZATION]", "[DEIDENTIFY_TEMPLATE]");
      DeidentifyTemplate deidentifyTemplate = DeidentifyTemplate.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();

      client.updateDeidentifyTemplate(name, deidentifyTemplate, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getDeidentifyTemplateTest() {
    DeidentifyTemplateName name2 =
        DeidentifyTemplateName.ofOrganizationDeidentifyTemplateName(
            "[ORGANIZATION]", "[DEIDENTIFY_TEMPLATE]");
    String displayName = "displayName1615086568";
    String description = "description-1724546052";
    DeidentifyTemplate expectedResponse =
        DeidentifyTemplate.newBuilder()
            .setName(name2.toString())
            .setDisplayName(displayName)
            .setDescription(description)
            .build();
    mockDlpService.addResponse(expectedResponse);

    DeidentifyTemplateName name =
        DeidentifyTemplateName.ofOrganizationDeidentifyTemplateName(
            "[ORGANIZATION]", "[DEIDENTIFY_TEMPLATE]");

    DeidentifyTemplate actualResponse = client.getDeidentifyTemplate(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDlpService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDeidentifyTemplateRequest actualRequest =
        (GetDeidentifyTemplateRequest) actualRequests.get(0);

    Assert.assertEquals(name, DeidentifyTemplateName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getDeidentifyTemplateExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDlpService.addException(exception);

    try {
      DeidentifyTemplateName name =
          DeidentifyTemplateName.ofOrganizationDeidentifyTemplateName(
              "[ORGANIZATION]", "[DEIDENTIFY_TEMPLATE]");

      client.getDeidentifyTemplate(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listDeidentifyTemplatesTest() {
    String nextPageToken = "";
    DeidentifyTemplate deidentifyTemplatesElement = DeidentifyTemplate.newBuilder().build();
    List<DeidentifyTemplate> deidentifyTemplates = Arrays.asList(deidentifyTemplatesElement);
    ListDeidentifyTemplatesResponse expectedResponse =
        ListDeidentifyTemplatesResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllDeidentifyTemplates(deidentifyTemplates)
            .build();
    mockDlpService.addResponse(expectedResponse);

    OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");

    ListDeidentifyTemplatesPagedResponse pagedListResponse = client.listDeidentifyTemplates(parent);

    List<DeidentifyTemplate> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDeidentifyTemplatesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDlpService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDeidentifyTemplatesRequest actualRequest =
        (ListDeidentifyTemplatesRequest) actualRequests.get(0);

    Assert.assertEquals(parent, OrganizationLocationName.parse(actualRequest.getParent()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listDeidentifyTemplatesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDlpService.addException(exception);

    try {
      OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");

      client.listDeidentifyTemplates(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deleteDeidentifyTemplateTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    mockDlpService.addResponse(expectedResponse);

    DeidentifyTemplateName name =
        DeidentifyTemplateName.ofOrganizationDeidentifyTemplateName(
            "[ORGANIZATION]", "[DEIDENTIFY_TEMPLATE]");

    client.deleteDeidentifyTemplate(name);

    List<AbstractMessage> actualRequests = mockDlpService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteDeidentifyTemplateRequest actualRequest =
        (DeleteDeidentifyTemplateRequest) actualRequests.get(0);

    Assert.assertEquals(name, DeidentifyTemplateName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void deleteDeidentifyTemplateExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDlpService.addException(exception);

    try {
      DeidentifyTemplateName name =
          DeidentifyTemplateName.ofOrganizationDeidentifyTemplateName(
              "[ORGANIZATION]", "[DEIDENTIFY_TEMPLATE]");

      client.deleteDeidentifyTemplate(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createJobTriggerTest() {
    JobTriggerName name = JobTriggerName.ofProjectJobTriggerName("[PROJECT]", "[JOB_TRIGGER]");
    String displayName = "displayName1615086568";
    String description = "description-1724546052";
    JobTrigger expectedResponse =
        JobTrigger.newBuilder()
            .setName(name.toString())
            .setDisplayName(displayName)
            .setDescription(description)
            .build();
    mockDlpService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");
    JobTrigger jobTrigger = JobTrigger.newBuilder().build();

    JobTrigger actualResponse = client.createJobTrigger(parent, jobTrigger);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDlpService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateJobTriggerRequest actualRequest = (CreateJobTriggerRequest) actualRequests.get(0);

    Assert.assertEquals(parent, ProjectName.parse(actualRequest.getParent()));
    Assert.assertEquals(jobTrigger, actualRequest.getJobTrigger());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createJobTriggerExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDlpService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      JobTrigger jobTrigger = JobTrigger.newBuilder().build();

      client.createJobTrigger(parent, jobTrigger);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createJobTriggerTest2() {
    JobTriggerName name = JobTriggerName.ofProjectJobTriggerName("[PROJECT]", "[JOB_TRIGGER]");
    String displayName = "displayName1615086568";
    String description = "description-1724546052";
    JobTrigger expectedResponse =
        JobTrigger.newBuilder()
            .setName(name.toString())
            .setDisplayName(displayName)
            .setDescription(description)
            .build();
    mockDlpService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");
    JobTrigger jobTrigger = JobTrigger.newBuilder().build();
    String locationId = "locationId552319461";

    JobTrigger actualResponse = client.createJobTrigger(parent, jobTrigger, locationId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDlpService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateJobTriggerRequest actualRequest = (CreateJobTriggerRequest) actualRequests.get(0);

    Assert.assertEquals(parent, ProjectName.parse(actualRequest.getParent()));
    Assert.assertEquals(jobTrigger, actualRequest.getJobTrigger());
    Assert.assertEquals(locationId, actualRequest.getLocationId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createJobTriggerExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDlpService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      JobTrigger jobTrigger = JobTrigger.newBuilder().build();
      String locationId = "locationId552319461";

      client.createJobTrigger(parent, jobTrigger, locationId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateJobTriggerTest() {
    JobTriggerName name2 = JobTriggerName.ofProjectJobTriggerName("[PROJECT]", "[JOB_TRIGGER]");
    String displayName = "displayName1615086568";
    String description = "description-1724546052";
    JobTrigger expectedResponse =
        JobTrigger.newBuilder()
            .setName(name2.toString())
            .setDisplayName(displayName)
            .setDescription(description)
            .build();
    mockDlpService.addResponse(expectedResponse);

    JobTriggerName name = JobTriggerName.ofProjectJobTriggerName("[PROJECT]", "[JOB_TRIGGER]");
    JobTrigger jobTrigger = JobTrigger.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    JobTrigger actualResponse = client.updateJobTrigger(name, jobTrigger, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDlpService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateJobTriggerRequest actualRequest = (UpdateJobTriggerRequest) actualRequests.get(0);

    Assert.assertEquals(name, JobTriggerName.parse(actualRequest.getName()));
    Assert.assertEquals(jobTrigger, actualRequest.getJobTrigger());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void updateJobTriggerExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDlpService.addException(exception);

    try {
      JobTriggerName name = JobTriggerName.ofProjectJobTriggerName("[PROJECT]", "[JOB_TRIGGER]");
      JobTrigger jobTrigger = JobTrigger.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();

      client.updateJobTrigger(name, jobTrigger, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void hybridInspectJobTriggerTest() {
    HybridInspectResponse expectedResponse = HybridInspectResponse.newBuilder().build();
    mockDlpService.addResponse(expectedResponse);

    JobTriggerName name = JobTriggerName.ofProjectJobTriggerName("[PROJECT]", "[JOB_TRIGGER]");

    HybridInspectResponse actualResponse = client.hybridInspectJobTrigger(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDlpService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    HybridInspectJobTriggerRequest actualRequest =
        (HybridInspectJobTriggerRequest) actualRequests.get(0);

    Assert.assertEquals(name, JobTriggerName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void hybridInspectJobTriggerExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDlpService.addException(exception);

    try {
      JobTriggerName name = JobTriggerName.ofProjectJobTriggerName("[PROJECT]", "[JOB_TRIGGER]");

      client.hybridInspectJobTrigger(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getJobTriggerTest() {
    JobTriggerName name2 = JobTriggerName.ofProjectJobTriggerName("[PROJECT]", "[JOB_TRIGGER]");
    String displayName = "displayName1615086568";
    String description = "description-1724546052";
    JobTrigger expectedResponse =
        JobTrigger.newBuilder()
            .setName(name2.toString())
            .setDisplayName(displayName)
            .setDescription(description)
            .build();
    mockDlpService.addResponse(expectedResponse);

    JobTriggerName name = JobTriggerName.ofProjectJobTriggerName("[PROJECT]", "[JOB_TRIGGER]");

    JobTrigger actualResponse = client.getJobTrigger(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDlpService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetJobTriggerRequest actualRequest = (GetJobTriggerRequest) actualRequests.get(0);

    Assert.assertEquals(name, JobTriggerName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getJobTriggerExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDlpService.addException(exception);

    try {
      JobTriggerName name = JobTriggerName.ofProjectJobTriggerName("[PROJECT]", "[JOB_TRIGGER]");

      client.getJobTrigger(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listJobTriggersTest() {
    String nextPageToken = "";
    JobTrigger jobTriggersElement = JobTrigger.newBuilder().build();
    List<JobTrigger> jobTriggers = Arrays.asList(jobTriggersElement);
    ListJobTriggersResponse expectedResponse =
        ListJobTriggersResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllJobTriggers(jobTriggers)
            .build();
    mockDlpService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");

    ListJobTriggersPagedResponse pagedListResponse = client.listJobTriggers(parent);

    List<JobTrigger> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getJobTriggersList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDlpService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListJobTriggersRequest actualRequest = (ListJobTriggersRequest) actualRequests.get(0);

    Assert.assertEquals(parent, ProjectName.parse(actualRequest.getParent()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listJobTriggersExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDlpService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");

      client.listJobTriggers(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deleteJobTriggerTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    mockDlpService.addResponse(expectedResponse);

    JobTriggerName name = JobTriggerName.ofProjectJobTriggerName("[PROJECT]", "[JOB_TRIGGER]");

    client.deleteJobTrigger(name);

    List<AbstractMessage> actualRequests = mockDlpService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteJobTriggerRequest actualRequest = (DeleteJobTriggerRequest) actualRequests.get(0);

    Assert.assertEquals(name, JobTriggerName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void deleteJobTriggerExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDlpService.addException(exception);

    try {
      JobTriggerName name = JobTriggerName.ofProjectJobTriggerName("[PROJECT]", "[JOB_TRIGGER]");

      client.deleteJobTrigger(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createDlpJobTest() {
    DlpJobName name = DlpJobName.ofProjectDlpJobName("[PROJECT]", "[DLP_JOB]");
    String jobTriggerName = "jobTriggerName1819490804";
    DlpJob expectedResponse =
        DlpJob.newBuilder().setName(name.toString()).setJobTriggerName(jobTriggerName).build();
    mockDlpService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");
    InspectJobConfig inspectJob = InspectJobConfig.newBuilder().build();

    DlpJob actualResponse = client.createDlpJob(parent, inspectJob);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDlpService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateDlpJobRequest actualRequest = (CreateDlpJobRequest) actualRequests.get(0);

    Assert.assertEquals(parent, ProjectName.parse(actualRequest.getParent()));
    Assert.assertEquals(inspectJob, actualRequest.getInspectJob());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createDlpJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDlpService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      InspectJobConfig inspectJob = InspectJobConfig.newBuilder().build();

      client.createDlpJob(parent, inspectJob);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createDlpJobTest2() {
    DlpJobName name = DlpJobName.ofProjectDlpJobName("[PROJECT]", "[DLP_JOB]");
    String jobTriggerName = "jobTriggerName1819490804";
    DlpJob expectedResponse =
        DlpJob.newBuilder().setName(name.toString()).setJobTriggerName(jobTriggerName).build();
    mockDlpService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");
    InspectJobConfig inspectJob = InspectJobConfig.newBuilder().build();
    String locationId = "locationId552319461";

    DlpJob actualResponse = client.createDlpJob(parent, inspectJob, locationId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDlpService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateDlpJobRequest actualRequest = (CreateDlpJobRequest) actualRequests.get(0);

    Assert.assertEquals(parent, ProjectName.parse(actualRequest.getParent()));
    Assert.assertEquals(inspectJob, actualRequest.getInspectJob());
    Assert.assertEquals(locationId, actualRequest.getLocationId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createDlpJobExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDlpService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      InspectJobConfig inspectJob = InspectJobConfig.newBuilder().build();
      String locationId = "locationId552319461";

      client.createDlpJob(parent, inspectJob, locationId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createDlpJobTest3() {
    DlpJobName name = DlpJobName.ofProjectDlpJobName("[PROJECT]", "[DLP_JOB]");
    String jobTriggerName = "jobTriggerName1819490804";
    DlpJob expectedResponse =
        DlpJob.newBuilder().setName(name.toString()).setJobTriggerName(jobTriggerName).build();
    mockDlpService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");
    RiskAnalysisJobConfig riskJob = RiskAnalysisJobConfig.newBuilder().build();

    DlpJob actualResponse = client.createDlpJob(parent, riskJob);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDlpService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateDlpJobRequest actualRequest = (CreateDlpJobRequest) actualRequests.get(0);

    Assert.assertEquals(parent, ProjectName.parse(actualRequest.getParent()));
    Assert.assertEquals(riskJob, actualRequest.getRiskJob());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createDlpJobExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDlpService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      RiskAnalysisJobConfig riskJob = RiskAnalysisJobConfig.newBuilder().build();

      client.createDlpJob(parent, riskJob);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createDlpJobTest4() {
    DlpJobName name = DlpJobName.ofProjectDlpJobName("[PROJECT]", "[DLP_JOB]");
    String jobTriggerName = "jobTriggerName1819490804";
    DlpJob expectedResponse =
        DlpJob.newBuilder().setName(name.toString()).setJobTriggerName(jobTriggerName).build();
    mockDlpService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");
    RiskAnalysisJobConfig riskJob = RiskAnalysisJobConfig.newBuilder().build();
    String locationId = "locationId552319461";

    DlpJob actualResponse = client.createDlpJob(parent, riskJob, locationId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDlpService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateDlpJobRequest actualRequest = (CreateDlpJobRequest) actualRequests.get(0);

    Assert.assertEquals(parent, ProjectName.parse(actualRequest.getParent()));
    Assert.assertEquals(riskJob, actualRequest.getRiskJob());
    Assert.assertEquals(locationId, actualRequest.getLocationId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createDlpJobExceptionTest4() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDlpService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      RiskAnalysisJobConfig riskJob = RiskAnalysisJobConfig.newBuilder().build();
      String locationId = "locationId552319461";

      client.createDlpJob(parent, riskJob, locationId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listDlpJobsTest() {
    String nextPageToken = "";
    DlpJob jobsElement = DlpJob.newBuilder().build();
    List<DlpJob> jobs = Arrays.asList(jobsElement);
    ListDlpJobsResponse expectedResponse =
        ListDlpJobsResponse.newBuilder().setNextPageToken(nextPageToken).addAllJobs(jobs).build();
    mockDlpService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");

    ListDlpJobsPagedResponse pagedListResponse = client.listDlpJobs(parent);

    List<DlpJob> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getJobsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDlpService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDlpJobsRequest actualRequest = (ListDlpJobsRequest) actualRequests.get(0);

    Assert.assertEquals(parent, ProjectName.parse(actualRequest.getParent()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listDlpJobsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDlpService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");

      client.listDlpJobs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getDlpJobTest() {
    DlpJobName name2 = DlpJobName.ofProjectDlpJobName("[PROJECT]", "[DLP_JOB]");
    String jobTriggerName = "jobTriggerName1819490804";
    DlpJob expectedResponse =
        DlpJob.newBuilder().setName(name2.toString()).setJobTriggerName(jobTriggerName).build();
    mockDlpService.addResponse(expectedResponse);

    DlpJobName name = DlpJobName.ofProjectDlpJobName("[PROJECT]", "[DLP_JOB]");

    DlpJob actualResponse = client.getDlpJob(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDlpService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDlpJobRequest actualRequest = (GetDlpJobRequest) actualRequests.get(0);

    Assert.assertEquals(name, DlpJobName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getDlpJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDlpService.addException(exception);

    try {
      DlpJobName name = DlpJobName.ofProjectDlpJobName("[PROJECT]", "[DLP_JOB]");

      client.getDlpJob(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deleteDlpJobTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    mockDlpService.addResponse(expectedResponse);

    DlpJobName name = DlpJobName.ofProjectDlpJobName("[PROJECT]", "[DLP_JOB]");

    client.deleteDlpJob(name);

    List<AbstractMessage> actualRequests = mockDlpService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteDlpJobRequest actualRequest = (DeleteDlpJobRequest) actualRequests.get(0);

    Assert.assertEquals(name, DlpJobName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void deleteDlpJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDlpService.addException(exception);

    try {
      DlpJobName name = DlpJobName.ofProjectDlpJobName("[PROJECT]", "[DLP_JOB]");

      client.deleteDlpJob(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void cancelDlpJobTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    mockDlpService.addResponse(expectedResponse);

    DlpJobName name = DlpJobName.ofProjectDlpJobName("[PROJECT]", "[DLP_JOB]");
    CancelDlpJobRequest request = CancelDlpJobRequest.newBuilder().setName(name.toString()).build();

    client.cancelDlpJob(request);

    List<AbstractMessage> actualRequests = mockDlpService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CancelDlpJobRequest actualRequest = (CancelDlpJobRequest) actualRequests.get(0);

    Assert.assertEquals(name, DlpJobName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void cancelDlpJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDlpService.addException(exception);

    try {
      DlpJobName name = DlpJobName.ofProjectDlpJobName("[PROJECT]", "[DLP_JOB]");
      CancelDlpJobRequest request =
          CancelDlpJobRequest.newBuilder().setName(name.toString()).build();

      client.cancelDlpJob(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createStoredInfoTypeTest() {
    StoredInfoTypeName name =
        StoredInfoTypeName.ofOrganizationStoredInfoTypeName("[ORGANIZATION]", "[STORED_INFO_TYPE]");
    StoredInfoType expectedResponse = StoredInfoType.newBuilder().setName(name.toString()).build();
    mockDlpService.addResponse(expectedResponse);

    OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
    StoredInfoTypeConfig config = StoredInfoTypeConfig.newBuilder().build();

    StoredInfoType actualResponse = client.createStoredInfoType(parent, config);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDlpService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateStoredInfoTypeRequest actualRequest = (CreateStoredInfoTypeRequest) actualRequests.get(0);

    Assert.assertEquals(parent, OrganizationLocationName.parse(actualRequest.getParent()));
    Assert.assertEquals(config, actualRequest.getConfig());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createStoredInfoTypeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDlpService.addException(exception);

    try {
      OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
      StoredInfoTypeConfig config = StoredInfoTypeConfig.newBuilder().build();

      client.createStoredInfoType(parent, config);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createStoredInfoTypeTest2() {
    StoredInfoTypeName name =
        StoredInfoTypeName.ofOrganizationStoredInfoTypeName("[ORGANIZATION]", "[STORED_INFO_TYPE]");
    StoredInfoType expectedResponse = StoredInfoType.newBuilder().setName(name.toString()).build();
    mockDlpService.addResponse(expectedResponse);

    OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
    StoredInfoTypeConfig config = StoredInfoTypeConfig.newBuilder().build();
    String locationId = "locationId552319461";

    StoredInfoType actualResponse = client.createStoredInfoType(parent, config, locationId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDlpService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateStoredInfoTypeRequest actualRequest = (CreateStoredInfoTypeRequest) actualRequests.get(0);

    Assert.assertEquals(parent, OrganizationLocationName.parse(actualRequest.getParent()));
    Assert.assertEquals(config, actualRequest.getConfig());
    Assert.assertEquals(locationId, actualRequest.getLocationId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createStoredInfoTypeExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDlpService.addException(exception);

    try {
      OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
      StoredInfoTypeConfig config = StoredInfoTypeConfig.newBuilder().build();
      String locationId = "locationId552319461";

      client.createStoredInfoType(parent, config, locationId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateStoredInfoTypeTest() {
    StoredInfoTypeName name2 =
        StoredInfoTypeName.ofOrganizationStoredInfoTypeName("[ORGANIZATION]", "[STORED_INFO_TYPE]");
    StoredInfoType expectedResponse = StoredInfoType.newBuilder().setName(name2.toString()).build();
    mockDlpService.addResponse(expectedResponse);

    StoredInfoTypeName name =
        StoredInfoTypeName.ofOrganizationStoredInfoTypeName("[ORGANIZATION]", "[STORED_INFO_TYPE]");
    StoredInfoTypeConfig config = StoredInfoTypeConfig.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    StoredInfoType actualResponse = client.updateStoredInfoType(name, config, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDlpService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateStoredInfoTypeRequest actualRequest = (UpdateStoredInfoTypeRequest) actualRequests.get(0);

    Assert.assertEquals(name, StoredInfoTypeName.parse(actualRequest.getName()));
    Assert.assertEquals(config, actualRequest.getConfig());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void updateStoredInfoTypeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDlpService.addException(exception);

    try {
      StoredInfoTypeName name =
          StoredInfoTypeName.ofOrganizationStoredInfoTypeName(
              "[ORGANIZATION]", "[STORED_INFO_TYPE]");
      StoredInfoTypeConfig config = StoredInfoTypeConfig.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();

      client.updateStoredInfoType(name, config, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getStoredInfoTypeTest() {
    StoredInfoTypeName name2 =
        StoredInfoTypeName.ofOrganizationStoredInfoTypeName("[ORGANIZATION]", "[STORED_INFO_TYPE]");
    StoredInfoType expectedResponse = StoredInfoType.newBuilder().setName(name2.toString()).build();
    mockDlpService.addResponse(expectedResponse);

    StoredInfoTypeName name =
        StoredInfoTypeName.ofOrganizationStoredInfoTypeName("[ORGANIZATION]", "[STORED_INFO_TYPE]");

    StoredInfoType actualResponse = client.getStoredInfoType(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDlpService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetStoredInfoTypeRequest actualRequest = (GetStoredInfoTypeRequest) actualRequests.get(0);

    Assert.assertEquals(name, StoredInfoTypeName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getStoredInfoTypeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDlpService.addException(exception);

    try {
      StoredInfoTypeName name =
          StoredInfoTypeName.ofOrganizationStoredInfoTypeName(
              "[ORGANIZATION]", "[STORED_INFO_TYPE]");

      client.getStoredInfoType(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listStoredInfoTypesTest() {
    String nextPageToken = "";
    StoredInfoType storedInfoTypesElement = StoredInfoType.newBuilder().build();
    List<StoredInfoType> storedInfoTypes = Arrays.asList(storedInfoTypesElement);
    ListStoredInfoTypesResponse expectedResponse =
        ListStoredInfoTypesResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllStoredInfoTypes(storedInfoTypes)
            .build();
    mockDlpService.addResponse(expectedResponse);

    OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");

    ListStoredInfoTypesPagedResponse pagedListResponse = client.listStoredInfoTypes(parent);

    List<StoredInfoType> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getStoredInfoTypesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDlpService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListStoredInfoTypesRequest actualRequest = (ListStoredInfoTypesRequest) actualRequests.get(0);

    Assert.assertEquals(parent, OrganizationLocationName.parse(actualRequest.getParent()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listStoredInfoTypesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDlpService.addException(exception);

    try {
      OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");

      client.listStoredInfoTypes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deleteStoredInfoTypeTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    mockDlpService.addResponse(expectedResponse);

    StoredInfoTypeName name =
        StoredInfoTypeName.ofOrganizationStoredInfoTypeName("[ORGANIZATION]", "[STORED_INFO_TYPE]");

    client.deleteStoredInfoType(name);

    List<AbstractMessage> actualRequests = mockDlpService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteStoredInfoTypeRequest actualRequest = (DeleteStoredInfoTypeRequest) actualRequests.get(0);

    Assert.assertEquals(name, StoredInfoTypeName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void deleteStoredInfoTypeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDlpService.addException(exception);

    try {
      StoredInfoTypeName name =
          StoredInfoTypeName.ofOrganizationStoredInfoTypeName(
              "[ORGANIZATION]", "[STORED_INFO_TYPE]");

      client.deleteStoredInfoType(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void hybridInspectDlpJobTest() {
    HybridInspectResponse expectedResponse = HybridInspectResponse.newBuilder().build();
    mockDlpService.addResponse(expectedResponse);

    DlpJobName name = DlpJobName.ofProjectDlpJobName("[PROJECT]", "[DLP_JOB]");

    HybridInspectResponse actualResponse = client.hybridInspectDlpJob(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDlpService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    HybridInspectDlpJobRequest actualRequest = (HybridInspectDlpJobRequest) actualRequests.get(0);

    Assert.assertEquals(name, DlpJobName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void hybridInspectDlpJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDlpService.addException(exception);

    try {
      DlpJobName name = DlpJobName.ofProjectDlpJobName("[PROJECT]", "[DLP_JOB]");

      client.hybridInspectDlpJob(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void finishDlpJobTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    mockDlpService.addResponse(expectedResponse);

    DlpJobName name = DlpJobName.ofProjectDlpJobName("[PROJECT]", "[DLP_JOB]");
    FinishDlpJobRequest request = FinishDlpJobRequest.newBuilder().setName(name.toString()).build();

    client.finishDlpJob(request);

    List<AbstractMessage> actualRequests = mockDlpService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    FinishDlpJobRequest actualRequest = (FinishDlpJobRequest) actualRequests.get(0);

    Assert.assertEquals(name, DlpJobName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void finishDlpJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDlpService.addException(exception);

    try {
      DlpJobName name = DlpJobName.ofProjectDlpJobName("[PROJECT]", "[DLP_JOB]");
      FinishDlpJobRequest request =
          FinishDlpJobRequest.newBuilder().setName(name.toString()).build();

      client.finishDlpJob(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }
}
