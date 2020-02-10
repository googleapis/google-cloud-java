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
import com.google.privacy.dlp.v2.DeidentifyTemplateNames;
import com.google.privacy.dlp.v2.DeleteDeidentifyTemplateRequest;
import com.google.privacy.dlp.v2.DeleteDlpJobRequest;
import com.google.privacy.dlp.v2.DeleteInspectTemplateRequest;
import com.google.privacy.dlp.v2.DeleteJobTriggerRequest;
import com.google.privacy.dlp.v2.DeleteStoredInfoTypeRequest;
import com.google.privacy.dlp.v2.DlpJob;
import com.google.privacy.dlp.v2.DlpJobName;
import com.google.privacy.dlp.v2.GetDeidentifyTemplateRequest;
import com.google.privacy.dlp.v2.GetDlpJobRequest;
import com.google.privacy.dlp.v2.GetInspectTemplateRequest;
import com.google.privacy.dlp.v2.GetJobTriggerRequest;
import com.google.privacy.dlp.v2.GetStoredInfoTypeRequest;
import com.google.privacy.dlp.v2.InspectContentRequest;
import com.google.privacy.dlp.v2.InspectContentResponse;
import com.google.privacy.dlp.v2.InspectTemplate;
import com.google.privacy.dlp.v2.InspectTemplateName;
import com.google.privacy.dlp.v2.InspectTemplateNames;
import com.google.privacy.dlp.v2.JobTrigger;
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
import com.google.privacy.dlp.v2.OrganizationDeidentifyTemplateName;
import com.google.privacy.dlp.v2.OrganizationInspectTemplateName;
import com.google.privacy.dlp.v2.OrganizationName;
import com.google.privacy.dlp.v2.OrganizationStoredInfoTypeName;
import com.google.privacy.dlp.v2.ProjectJobTriggerName;
import com.google.privacy.dlp.v2.ProjectName;
import com.google.privacy.dlp.v2.RedactImageRequest;
import com.google.privacy.dlp.v2.RedactImageResponse;
import com.google.privacy.dlp.v2.ReidentifyContentRequest;
import com.google.privacy.dlp.v2.ReidentifyContentResponse;
import com.google.privacy.dlp.v2.StoredInfoType;
import com.google.privacy.dlp.v2.StoredInfoTypeName;
import com.google.privacy.dlp.v2.StoredInfoTypeNames;
import com.google.privacy.dlp.v2.UpdateDeidentifyTemplateRequest;
import com.google.privacy.dlp.v2.UpdateInspectTemplateRequest;
import com.google.privacy.dlp.v2.UpdateJobTriggerRequest;
import com.google.privacy.dlp.v2.UpdateStoredInfoTypeRequest;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.ByteString;
import com.google.protobuf.Empty;
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

    ProjectName parent = ProjectName.of("[PROJECT]");
    InspectContentRequest request =
        InspectContentRequest.newBuilder().setParent(parent.toString()).build();

    InspectContentResponse actualResponse = client.inspectContent(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDlpService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    InspectContentRequest actualRequest = (InspectContentRequest) actualRequests.get(0);

    Assert.assertEquals(parent, ProjectName.parse(actualRequest.getParent()));
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
      ProjectName parent = ProjectName.of("[PROJECT]");
      InspectContentRequest request =
          InspectContentRequest.newBuilder().setParent(parent.toString()).build();

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

    ProjectName parent = ProjectName.of("[PROJECT]");
    RedactImageRequest request =
        RedactImageRequest.newBuilder().setParent(parent.toString()).build();

    RedactImageResponse actualResponse = client.redactImage(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDlpService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RedactImageRequest actualRequest = (RedactImageRequest) actualRequests.get(0);

    Assert.assertEquals(parent, ProjectName.parse(actualRequest.getParent()));
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
      ProjectName parent = ProjectName.of("[PROJECT]");
      RedactImageRequest request =
          RedactImageRequest.newBuilder().setParent(parent.toString()).build();

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

    ProjectName parent = ProjectName.of("[PROJECT]");
    DeidentifyContentRequest request =
        DeidentifyContentRequest.newBuilder().setParent(parent.toString()).build();

    DeidentifyContentResponse actualResponse = client.deidentifyContent(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDlpService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeidentifyContentRequest actualRequest = (DeidentifyContentRequest) actualRequests.get(0);

    Assert.assertEquals(parent, ProjectName.parse(actualRequest.getParent()));
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
      ProjectName parent = ProjectName.of("[PROJECT]");
      DeidentifyContentRequest request =
          DeidentifyContentRequest.newBuilder().setParent(parent.toString()).build();

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

    ListInfoTypesRequest request = ListInfoTypesRequest.newBuilder().build();

    ListInfoTypesResponse actualResponse = client.listInfoTypes(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDlpService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListInfoTypesRequest actualRequest = (ListInfoTypesRequest) actualRequests.get(0);

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
      ListInfoTypesRequest request = ListInfoTypesRequest.newBuilder().build();

      client.listInfoTypes(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createInspectTemplateTest() {
    String name = "name3373707";
    String displayName = "displayName1615086568";
    String description = "description-1724546052";
    InspectTemplate expectedResponse =
        InspectTemplate.newBuilder()
            .setName(name)
            .setDisplayName(displayName)
            .setDescription(description)
            .build();
    mockDlpService.addResponse(expectedResponse);

    OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
    CreateInspectTemplateRequest request =
        CreateInspectTemplateRequest.newBuilder().setParent(parent.toString()).build();

    InspectTemplate actualResponse = client.createInspectTemplate(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDlpService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateInspectTemplateRequest actualRequest =
        (CreateInspectTemplateRequest) actualRequests.get(0);

    Assert.assertEquals(parent, OrganizationName.parse(actualRequest.getParent()));
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
      OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
      CreateInspectTemplateRequest request =
          CreateInspectTemplateRequest.newBuilder().setParent(parent.toString()).build();

      client.createInspectTemplate(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateInspectTemplateTest() {
    String name2 = "name2-1052831874";
    String displayName = "displayName1615086568";
    String description = "description-1724546052";
    InspectTemplate expectedResponse =
        InspectTemplate.newBuilder()
            .setName(name2)
            .setDisplayName(displayName)
            .setDescription(description)
            .build();
    mockDlpService.addResponse(expectedResponse);

    InspectTemplateName name =
        OrganizationInspectTemplateName.of("[ORGANIZATION]", "[INSPECT_TEMPLATE]");
    UpdateInspectTemplateRequest request =
        UpdateInspectTemplateRequest.newBuilder().setName(name.toString()).build();

    InspectTemplate actualResponse = client.updateInspectTemplate(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDlpService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateInspectTemplateRequest actualRequest =
        (UpdateInspectTemplateRequest) actualRequests.get(0);

    Assert.assertEquals(name, InspectTemplateNames.parse(actualRequest.getName()));
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
          OrganizationInspectTemplateName.of("[ORGANIZATION]", "[INSPECT_TEMPLATE]");
      UpdateInspectTemplateRequest request =
          UpdateInspectTemplateRequest.newBuilder().setName(name.toString()).build();

      client.updateInspectTemplate(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getInspectTemplateTest() {
    String name = "name3373707";
    String displayName = "displayName1615086568";
    String description = "description-1724546052";
    InspectTemplate expectedResponse =
        InspectTemplate.newBuilder()
            .setName(name)
            .setDisplayName(displayName)
            .setDescription(description)
            .build();
    mockDlpService.addResponse(expectedResponse);

    GetInspectTemplateRequest request = GetInspectTemplateRequest.newBuilder().build();

    InspectTemplate actualResponse = client.getInspectTemplate(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDlpService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetInspectTemplateRequest actualRequest = (GetInspectTemplateRequest) actualRequests.get(0);

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
      GetInspectTemplateRequest request = GetInspectTemplateRequest.newBuilder().build();

      client.getInspectTemplate(request);
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

    OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
    ListInspectTemplatesRequest request =
        ListInspectTemplatesRequest.newBuilder().setParent(parent.toString()).build();

    ListInspectTemplatesPagedResponse pagedListResponse = client.listInspectTemplates(request);

    List<InspectTemplate> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getInspectTemplatesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDlpService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListInspectTemplatesRequest actualRequest = (ListInspectTemplatesRequest) actualRequests.get(0);

    Assert.assertEquals(parent, OrganizationName.parse(actualRequest.getParent()));
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
      OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
      ListInspectTemplatesRequest request =
          ListInspectTemplatesRequest.newBuilder().setParent(parent.toString()).build();

      client.listInspectTemplates(request);
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
        OrganizationInspectTemplateName.of("[ORGANIZATION]", "[INSPECT_TEMPLATE]");
    DeleteInspectTemplateRequest request =
        DeleteInspectTemplateRequest.newBuilder().setName(name.toString()).build();

    client.deleteInspectTemplate(request);

    List<AbstractMessage> actualRequests = mockDlpService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteInspectTemplateRequest actualRequest =
        (DeleteInspectTemplateRequest) actualRequests.get(0);

    Assert.assertEquals(name, InspectTemplateNames.parse(actualRequest.getName()));
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
          OrganizationInspectTemplateName.of("[ORGANIZATION]", "[INSPECT_TEMPLATE]");
      DeleteInspectTemplateRequest request =
          DeleteInspectTemplateRequest.newBuilder().setName(name.toString()).build();

      client.deleteInspectTemplate(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createDeidentifyTemplateTest() {
    String name = "name3373707";
    String displayName = "displayName1615086568";
    String description = "description-1724546052";
    DeidentifyTemplate expectedResponse =
        DeidentifyTemplate.newBuilder()
            .setName(name)
            .setDisplayName(displayName)
            .setDescription(description)
            .build();
    mockDlpService.addResponse(expectedResponse);

    OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
    CreateDeidentifyTemplateRequest request =
        CreateDeidentifyTemplateRequest.newBuilder().setParent(parent.toString()).build();

    DeidentifyTemplate actualResponse = client.createDeidentifyTemplate(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDlpService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateDeidentifyTemplateRequest actualRequest =
        (CreateDeidentifyTemplateRequest) actualRequests.get(0);

    Assert.assertEquals(parent, OrganizationName.parse(actualRequest.getParent()));
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
      OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
      CreateDeidentifyTemplateRequest request =
          CreateDeidentifyTemplateRequest.newBuilder().setParent(parent.toString()).build();

      client.createDeidentifyTemplate(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateDeidentifyTemplateTest() {
    String name2 = "name2-1052831874";
    String displayName = "displayName1615086568";
    String description = "description-1724546052";
    DeidentifyTemplate expectedResponse =
        DeidentifyTemplate.newBuilder()
            .setName(name2)
            .setDisplayName(displayName)
            .setDescription(description)
            .build();
    mockDlpService.addResponse(expectedResponse);

    DeidentifyTemplateName name =
        OrganizationDeidentifyTemplateName.of("[ORGANIZATION]", "[DEIDENTIFY_TEMPLATE]");
    UpdateDeidentifyTemplateRequest request =
        UpdateDeidentifyTemplateRequest.newBuilder().setName(name.toString()).build();

    DeidentifyTemplate actualResponse = client.updateDeidentifyTemplate(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDlpService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateDeidentifyTemplateRequest actualRequest =
        (UpdateDeidentifyTemplateRequest) actualRequests.get(0);

    Assert.assertEquals(name, DeidentifyTemplateNames.parse(actualRequest.getName()));
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
          OrganizationDeidentifyTemplateName.of("[ORGANIZATION]", "[DEIDENTIFY_TEMPLATE]");
      UpdateDeidentifyTemplateRequest request =
          UpdateDeidentifyTemplateRequest.newBuilder().setName(name.toString()).build();

      client.updateDeidentifyTemplate(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getDeidentifyTemplateTest() {
    String name2 = "name2-1052831874";
    String displayName = "displayName1615086568";
    String description = "description-1724546052";
    DeidentifyTemplate expectedResponse =
        DeidentifyTemplate.newBuilder()
            .setName(name2)
            .setDisplayName(displayName)
            .setDescription(description)
            .build();
    mockDlpService.addResponse(expectedResponse);

    DeidentifyTemplateName name =
        OrganizationDeidentifyTemplateName.of("[ORGANIZATION]", "[DEIDENTIFY_TEMPLATE]");
    GetDeidentifyTemplateRequest request =
        GetDeidentifyTemplateRequest.newBuilder().setName(name.toString()).build();

    DeidentifyTemplate actualResponse = client.getDeidentifyTemplate(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDlpService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDeidentifyTemplateRequest actualRequest =
        (GetDeidentifyTemplateRequest) actualRequests.get(0);

    Assert.assertEquals(name, DeidentifyTemplateNames.parse(actualRequest.getName()));
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
          OrganizationDeidentifyTemplateName.of("[ORGANIZATION]", "[DEIDENTIFY_TEMPLATE]");
      GetDeidentifyTemplateRequest request =
          GetDeidentifyTemplateRequest.newBuilder().setName(name.toString()).build();

      client.getDeidentifyTemplate(request);
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

    OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
    ListDeidentifyTemplatesRequest request =
        ListDeidentifyTemplatesRequest.newBuilder().setParent(parent.toString()).build();

    ListDeidentifyTemplatesPagedResponse pagedListResponse =
        client.listDeidentifyTemplates(request);

    List<DeidentifyTemplate> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDeidentifyTemplatesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDlpService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDeidentifyTemplatesRequest actualRequest =
        (ListDeidentifyTemplatesRequest) actualRequests.get(0);

    Assert.assertEquals(parent, OrganizationName.parse(actualRequest.getParent()));
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
      OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
      ListDeidentifyTemplatesRequest request =
          ListDeidentifyTemplatesRequest.newBuilder().setParent(parent.toString()).build();

      client.listDeidentifyTemplates(request);
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
        OrganizationDeidentifyTemplateName.of("[ORGANIZATION]", "[DEIDENTIFY_TEMPLATE]");
    DeleteDeidentifyTemplateRequest request =
        DeleteDeidentifyTemplateRequest.newBuilder().setName(name.toString()).build();

    client.deleteDeidentifyTemplate(request);

    List<AbstractMessage> actualRequests = mockDlpService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteDeidentifyTemplateRequest actualRequest =
        (DeleteDeidentifyTemplateRequest) actualRequests.get(0);

    Assert.assertEquals(name, DeidentifyTemplateNames.parse(actualRequest.getName()));
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
          OrganizationDeidentifyTemplateName.of("[ORGANIZATION]", "[DEIDENTIFY_TEMPLATE]");
      DeleteDeidentifyTemplateRequest request =
          DeleteDeidentifyTemplateRequest.newBuilder().setName(name.toString()).build();

      client.deleteDeidentifyTemplate(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createDlpJobTest() {
    String name = "name3373707";
    String jobTriggerName = "jobTriggerName1819490804";
    DlpJob expectedResponse =
        DlpJob.newBuilder().setName(name).setJobTriggerName(jobTriggerName).build();
    mockDlpService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");
    CreateDlpJobRequest request =
        CreateDlpJobRequest.newBuilder().setParent(parent.toString()).build();

    DlpJob actualResponse = client.createDlpJob(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDlpService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateDlpJobRequest actualRequest = (CreateDlpJobRequest) actualRequests.get(0);

    Assert.assertEquals(parent, ProjectName.parse(actualRequest.getParent()));
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
      CreateDlpJobRequest request =
          CreateDlpJobRequest.newBuilder().setParent(parent.toString()).build();

      client.createDlpJob(request);
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
    ListDlpJobsRequest request =
        ListDlpJobsRequest.newBuilder().setParent(parent.toString()).build();

    ListDlpJobsPagedResponse pagedListResponse = client.listDlpJobs(request);

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
      ListDlpJobsRequest request =
          ListDlpJobsRequest.newBuilder().setParent(parent.toString()).build();

      client.listDlpJobs(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getDlpJobTest() {
    String name2 = "name2-1052831874";
    String jobTriggerName = "jobTriggerName1819490804";
    DlpJob expectedResponse =
        DlpJob.newBuilder().setName(name2).setJobTriggerName(jobTriggerName).build();
    mockDlpService.addResponse(expectedResponse);

    DlpJobName name = DlpJobName.of("[PROJECT]", "[DLP_JOB]");
    GetDlpJobRequest request = GetDlpJobRequest.newBuilder().setName(name.toString()).build();

    DlpJob actualResponse = client.getDlpJob(request);
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
      DlpJobName name = DlpJobName.of("[PROJECT]", "[DLP_JOB]");
      GetDlpJobRequest request = GetDlpJobRequest.newBuilder().setName(name.toString()).build();

      client.getDlpJob(request);
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

    DlpJobName name = DlpJobName.of("[PROJECT]", "[DLP_JOB]");
    DeleteDlpJobRequest request = DeleteDlpJobRequest.newBuilder().setName(name.toString()).build();

    client.deleteDlpJob(request);

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
      DlpJobName name = DlpJobName.of("[PROJECT]", "[DLP_JOB]");
      DeleteDlpJobRequest request =
          DeleteDlpJobRequest.newBuilder().setName(name.toString()).build();

      client.deleteDlpJob(request);
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

    DlpJobName name = DlpJobName.of("[PROJECT]", "[DLP_JOB]");
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
      DlpJobName name = DlpJobName.of("[PROJECT]", "[DLP_JOB]");
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
    ListJobTriggersRequest request =
        ListJobTriggersRequest.newBuilder().setParent(parent.toString()).build();

    ListJobTriggersPagedResponse pagedListResponse = client.listJobTriggers(request);

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
      ListJobTriggersRequest request =
          ListJobTriggersRequest.newBuilder().setParent(parent.toString()).build();

      client.listJobTriggers(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getJobTriggerTest() {
    String name2 = "name2-1052831874";
    String displayName = "displayName1615086568";
    String description = "description-1724546052";
    JobTrigger expectedResponse =
        JobTrigger.newBuilder()
            .setName(name2)
            .setDisplayName(displayName)
            .setDescription(description)
            .build();
    mockDlpService.addResponse(expectedResponse);

    ProjectJobTriggerName name = ProjectJobTriggerName.of("[PROJECT]", "[JOB_TRIGGER]");
    GetJobTriggerRequest request =
        GetJobTriggerRequest.newBuilder().setName(name.toString()).build();

    JobTrigger actualResponse = client.getJobTrigger(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDlpService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetJobTriggerRequest actualRequest = (GetJobTriggerRequest) actualRequests.get(0);

    Assert.assertEquals(name, ProjectJobTriggerName.parse(actualRequest.getName()));
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
      ProjectJobTriggerName name = ProjectJobTriggerName.of("[PROJECT]", "[JOB_TRIGGER]");
      GetJobTriggerRequest request =
          GetJobTriggerRequest.newBuilder().setName(name.toString()).build();

      client.getJobTrigger(request);
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

    ProjectJobTriggerName name = ProjectJobTriggerName.of("[PROJECT]", "[JOB_TRIGGER]");
    DeleteJobTriggerRequest request =
        DeleteJobTriggerRequest.newBuilder().setName(name.toString()).build();

    client.deleteJobTrigger(request);

    List<AbstractMessage> actualRequests = mockDlpService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteJobTriggerRequest actualRequest = (DeleteJobTriggerRequest) actualRequests.get(0);

    Assert.assertEquals(name, ProjectJobTriggerName.parse(actualRequest.getName()));
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
      ProjectJobTriggerName name = ProjectJobTriggerName.of("[PROJECT]", "[JOB_TRIGGER]");
      DeleteJobTriggerRequest request =
          DeleteJobTriggerRequest.newBuilder().setName(name.toString()).build();

      client.deleteJobTrigger(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateJobTriggerTest() {
    String name2 = "name2-1052831874";
    String displayName = "displayName1615086568";
    String description = "description-1724546052";
    JobTrigger expectedResponse =
        JobTrigger.newBuilder()
            .setName(name2)
            .setDisplayName(displayName)
            .setDescription(description)
            .build();
    mockDlpService.addResponse(expectedResponse);

    ProjectJobTriggerName name = ProjectJobTriggerName.of("[PROJECT]", "[JOB_TRIGGER]");
    UpdateJobTriggerRequest request =
        UpdateJobTriggerRequest.newBuilder().setName(name.toString()).build();

    JobTrigger actualResponse = client.updateJobTrigger(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDlpService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateJobTriggerRequest actualRequest = (UpdateJobTriggerRequest) actualRequests.get(0);

    Assert.assertEquals(name, ProjectJobTriggerName.parse(actualRequest.getName()));
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
      ProjectJobTriggerName name = ProjectJobTriggerName.of("[PROJECT]", "[JOB_TRIGGER]");
      UpdateJobTriggerRequest request =
          UpdateJobTriggerRequest.newBuilder().setName(name.toString()).build();

      client.updateJobTrigger(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createJobTriggerTest() {
    String name = "name3373707";
    String displayName = "displayName1615086568";
    String description = "description-1724546052";
    JobTrigger expectedResponse =
        JobTrigger.newBuilder()
            .setName(name)
            .setDisplayName(displayName)
            .setDescription(description)
            .build();
    mockDlpService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");
    CreateJobTriggerRequest request =
        CreateJobTriggerRequest.newBuilder().setParent(parent.toString()).build();

    JobTrigger actualResponse = client.createJobTrigger(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDlpService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateJobTriggerRequest actualRequest = (CreateJobTriggerRequest) actualRequests.get(0);

    Assert.assertEquals(parent, ProjectName.parse(actualRequest.getParent()));
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
      CreateJobTriggerRequest request =
          CreateJobTriggerRequest.newBuilder().setParent(parent.toString()).build();

      client.createJobTrigger(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createStoredInfoTypeTest() {
    String name = "name3373707";
    StoredInfoType expectedResponse = StoredInfoType.newBuilder().setName(name).build();
    mockDlpService.addResponse(expectedResponse);

    OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
    CreateStoredInfoTypeRequest request =
        CreateStoredInfoTypeRequest.newBuilder().setParent(parent.toString()).build();

    StoredInfoType actualResponse = client.createStoredInfoType(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDlpService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateStoredInfoTypeRequest actualRequest = (CreateStoredInfoTypeRequest) actualRequests.get(0);

    Assert.assertEquals(parent, OrganizationName.parse(actualRequest.getParent()));
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
      OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
      CreateStoredInfoTypeRequest request =
          CreateStoredInfoTypeRequest.newBuilder().setParent(parent.toString()).build();

      client.createStoredInfoType(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateStoredInfoTypeTest() {
    String name2 = "name2-1052831874";
    StoredInfoType expectedResponse = StoredInfoType.newBuilder().setName(name2).build();
    mockDlpService.addResponse(expectedResponse);

    StoredInfoTypeName name =
        OrganizationStoredInfoTypeName.of("[ORGANIZATION]", "[STORED_INFO_TYPE]");
    UpdateStoredInfoTypeRequest request =
        UpdateStoredInfoTypeRequest.newBuilder().setName(name.toString()).build();

    StoredInfoType actualResponse = client.updateStoredInfoType(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDlpService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateStoredInfoTypeRequest actualRequest = (UpdateStoredInfoTypeRequest) actualRequests.get(0);

    Assert.assertEquals(name, StoredInfoTypeNames.parse(actualRequest.getName()));
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
          OrganizationStoredInfoTypeName.of("[ORGANIZATION]", "[STORED_INFO_TYPE]");
      UpdateStoredInfoTypeRequest request =
          UpdateStoredInfoTypeRequest.newBuilder().setName(name.toString()).build();

      client.updateStoredInfoType(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getStoredInfoTypeTest() {
    String name2 = "name2-1052831874";
    StoredInfoType expectedResponse = StoredInfoType.newBuilder().setName(name2).build();
    mockDlpService.addResponse(expectedResponse);

    StoredInfoTypeName name =
        OrganizationStoredInfoTypeName.of("[ORGANIZATION]", "[STORED_INFO_TYPE]");
    GetStoredInfoTypeRequest request =
        GetStoredInfoTypeRequest.newBuilder().setName(name.toString()).build();

    StoredInfoType actualResponse = client.getStoredInfoType(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDlpService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetStoredInfoTypeRequest actualRequest = (GetStoredInfoTypeRequest) actualRequests.get(0);

    Assert.assertEquals(name, StoredInfoTypeNames.parse(actualRequest.getName()));
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
          OrganizationStoredInfoTypeName.of("[ORGANIZATION]", "[STORED_INFO_TYPE]");
      GetStoredInfoTypeRequest request =
          GetStoredInfoTypeRequest.newBuilder().setName(name.toString()).build();

      client.getStoredInfoType(request);
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

    OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
    ListStoredInfoTypesRequest request =
        ListStoredInfoTypesRequest.newBuilder().setParent(parent.toString()).build();

    ListStoredInfoTypesPagedResponse pagedListResponse = client.listStoredInfoTypes(request);

    List<StoredInfoType> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getStoredInfoTypesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDlpService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListStoredInfoTypesRequest actualRequest = (ListStoredInfoTypesRequest) actualRequests.get(0);

    Assert.assertEquals(parent, OrganizationName.parse(actualRequest.getParent()));
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
      OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
      ListStoredInfoTypesRequest request =
          ListStoredInfoTypesRequest.newBuilder().setParent(parent.toString()).build();

      client.listStoredInfoTypes(request);
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
        OrganizationStoredInfoTypeName.of("[ORGANIZATION]", "[STORED_INFO_TYPE]");
    DeleteStoredInfoTypeRequest request =
        DeleteStoredInfoTypeRequest.newBuilder().setName(name.toString()).build();

    client.deleteStoredInfoType(request);

    List<AbstractMessage> actualRequests = mockDlpService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteStoredInfoTypeRequest actualRequest = (DeleteStoredInfoTypeRequest) actualRequests.get(0);

    Assert.assertEquals(name, StoredInfoTypeNames.parse(actualRequest.getName()));
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
          OrganizationStoredInfoTypeName.of("[ORGANIZATION]", "[STORED_INFO_TYPE]");
      DeleteStoredInfoTypeRequest request =
          DeleteStoredInfoTypeRequest.newBuilder().setName(name.toString()).build();

      client.deleteStoredInfoType(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }
}
