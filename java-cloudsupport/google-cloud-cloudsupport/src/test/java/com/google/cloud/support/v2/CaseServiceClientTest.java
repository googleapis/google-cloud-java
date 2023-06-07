/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.support.v2;

import static com.google.cloud.support.v2.CaseServiceClient.ListCasesPagedResponse;
import static com.google.cloud.support.v2.CaseServiceClient.SearchCaseClassificationsPagedResponse;
import static com.google.cloud.support.v2.CaseServiceClient.SearchCasesPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.common.collect.Lists;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class CaseServiceClientTest {
  private static MockCaseService mockCaseService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private CaseServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockCaseService = new MockCaseService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockCaseService));
    mockServiceHelper.start();
  }

  @AfterClass
  public static void stopServer() {
    mockServiceHelper.stop();
  }

  @Before
  public void setUp() throws IOException {
    mockServiceHelper.reset();
    channelProvider = mockServiceHelper.createChannelProvider();
    CaseServiceSettings settings =
        CaseServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = CaseServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void getCaseTest() throws Exception {
    Case expectedResponse =
        Case.newBuilder()
            .setName(CaseName.ofProjectCaseName("[PROJECT]", "[CASE]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setClassification(CaseClassification.newBuilder().build())
            .setTimeZone("timeZone-2077180903")
            .addAllSubscriberEmailAddresses(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setCreator(Actor.newBuilder().build())
            .setContactEmail("contactEmail1253690204")
            .setEscalated(true)
            .setTestCase(true)
            .setLanguageCode("languageCode-2092349083")
            .build();
    mockCaseService.addResponse(expectedResponse);

    CaseName name = CaseName.ofProjectCaseName("[PROJECT]", "[CASE]");

    Case actualResponse = client.getCase(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCaseService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetCaseRequest actualRequest = ((GetCaseRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getCaseExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCaseService.addException(exception);

    try {
      CaseName name = CaseName.ofProjectCaseName("[PROJECT]", "[CASE]");
      client.getCase(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getCaseTest2() throws Exception {
    Case expectedResponse =
        Case.newBuilder()
            .setName(CaseName.ofProjectCaseName("[PROJECT]", "[CASE]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setClassification(CaseClassification.newBuilder().build())
            .setTimeZone("timeZone-2077180903")
            .addAllSubscriberEmailAddresses(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setCreator(Actor.newBuilder().build())
            .setContactEmail("contactEmail1253690204")
            .setEscalated(true)
            .setTestCase(true)
            .setLanguageCode("languageCode-2092349083")
            .build();
    mockCaseService.addResponse(expectedResponse);

    String name = "name3373707";

    Case actualResponse = client.getCase(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCaseService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetCaseRequest actualRequest = ((GetCaseRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getCaseExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCaseService.addException(exception);

    try {
      String name = "name3373707";
      client.getCase(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listCasesTest() throws Exception {
    Case responsesElement = Case.newBuilder().build();
    ListCasesResponse expectedResponse =
        ListCasesResponse.newBuilder()
            .setNextPageToken("")
            .addAllCases(Arrays.asList(responsesElement))
            .build();
    mockCaseService.addResponse(expectedResponse);

    OrganizationName parent = OrganizationName.of("[ORGANIZATION]");

    ListCasesPagedResponse pagedListResponse = client.listCases(parent);

    List<Case> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCasesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCaseService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListCasesRequest actualRequest = ((ListCasesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listCasesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCaseService.addException(exception);

    try {
      OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
      client.listCases(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listCasesTest2() throws Exception {
    Case responsesElement = Case.newBuilder().build();
    ListCasesResponse expectedResponse =
        ListCasesResponse.newBuilder()
            .setNextPageToken("")
            .addAllCases(Arrays.asList(responsesElement))
            .build();
    mockCaseService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");

    ListCasesPagedResponse pagedListResponse = client.listCases(parent);

    List<Case> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCasesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCaseService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListCasesRequest actualRequest = ((ListCasesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listCasesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCaseService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      client.listCases(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listCasesTest3() throws Exception {
    Case responsesElement = Case.newBuilder().build();
    ListCasesResponse expectedResponse =
        ListCasesResponse.newBuilder()
            .setNextPageToken("")
            .addAllCases(Arrays.asList(responsesElement))
            .build();
    mockCaseService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListCasesPagedResponse pagedListResponse = client.listCases(parent);

    List<Case> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCasesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCaseService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListCasesRequest actualRequest = ((ListCasesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listCasesExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCaseService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listCases(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void searchCasesTest() throws Exception {
    Case responsesElement = Case.newBuilder().build();
    SearchCasesResponse expectedResponse =
        SearchCasesResponse.newBuilder()
            .setNextPageToken("")
            .addAllCases(Arrays.asList(responsesElement))
            .build();
    mockCaseService.addResponse(expectedResponse);

    SearchCasesRequest request =
        SearchCasesRequest.newBuilder()
            .setParent("parent-995424086")
            .setQuery("query107944136")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    SearchCasesPagedResponse pagedListResponse = client.searchCases(request);

    List<Case> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCasesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCaseService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SearchCasesRequest actualRequest = ((SearchCasesRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getQuery(), actualRequest.getQuery());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void searchCasesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCaseService.addException(exception);

    try {
      SearchCasesRequest request =
          SearchCasesRequest.newBuilder()
              .setParent("parent-995424086")
              .setQuery("query107944136")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      client.searchCases(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createCaseTest() throws Exception {
    Case expectedResponse =
        Case.newBuilder()
            .setName(CaseName.ofOrganizationCaseName("[ORGANIZATION]", "[CASE]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setClassification(CaseClassification.newBuilder().build())
            .setTimeZone("timeZone-2077180903")
            .addAllSubscriberEmailAddresses(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setCreator(Actor.newBuilder().build())
            .setContactEmail("contactEmail1253690204")
            .setEscalated(true)
            .setTestCase(true)
            .setLanguageCode("languageCode-2092349083")
            .build();
    mockCaseService.addResponse(expectedResponse);

    OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
    Case case_ = Case.newBuilder().build();

    Case actualResponse = client.createCase(parent, case_);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCaseService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateCaseRequest actualRequest = ((CreateCaseRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(case_, actualRequest.getCase());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createCaseExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCaseService.addException(exception);

    try {
      OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
      Case case_ = Case.newBuilder().build();
      client.createCase(parent, case_);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createCaseTest2() throws Exception {
    Case expectedResponse =
        Case.newBuilder()
            .setName(CaseName.ofOrganizationCaseName("[ORGANIZATION]", "[CASE]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setClassification(CaseClassification.newBuilder().build())
            .setTimeZone("timeZone-2077180903")
            .addAllSubscriberEmailAddresses(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setCreator(Actor.newBuilder().build())
            .setContactEmail("contactEmail1253690204")
            .setEscalated(true)
            .setTestCase(true)
            .setLanguageCode("languageCode-2092349083")
            .build();
    mockCaseService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");
    Case case_ = Case.newBuilder().build();

    Case actualResponse = client.createCase(parent, case_);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCaseService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateCaseRequest actualRequest = ((CreateCaseRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(case_, actualRequest.getCase());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createCaseExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCaseService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      Case case_ = Case.newBuilder().build();
      client.createCase(parent, case_);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createCaseTest3() throws Exception {
    Case expectedResponse =
        Case.newBuilder()
            .setName(CaseName.ofOrganizationCaseName("[ORGANIZATION]", "[CASE]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setClassification(CaseClassification.newBuilder().build())
            .setTimeZone("timeZone-2077180903")
            .addAllSubscriberEmailAddresses(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setCreator(Actor.newBuilder().build())
            .setContactEmail("contactEmail1253690204")
            .setEscalated(true)
            .setTestCase(true)
            .setLanguageCode("languageCode-2092349083")
            .build();
    mockCaseService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Case case_ = Case.newBuilder().build();

    Case actualResponse = client.createCase(parent, case_);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCaseService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateCaseRequest actualRequest = ((CreateCaseRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(case_, actualRequest.getCase());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createCaseExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCaseService.addException(exception);

    try {
      String parent = "parent-995424086";
      Case case_ = Case.newBuilder().build();
      client.createCase(parent, case_);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateCaseTest() throws Exception {
    Case expectedResponse =
        Case.newBuilder()
            .setName(CaseName.ofProjectCaseName("[PROJECT]", "[CASE]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setClassification(CaseClassification.newBuilder().build())
            .setTimeZone("timeZone-2077180903")
            .addAllSubscriberEmailAddresses(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setCreator(Actor.newBuilder().build())
            .setContactEmail("contactEmail1253690204")
            .setEscalated(true)
            .setTestCase(true)
            .setLanguageCode("languageCode-2092349083")
            .build();
    mockCaseService.addResponse(expectedResponse);

    Case case_ = Case.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Case actualResponse = client.updateCase(case_, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCaseService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateCaseRequest actualRequest = ((UpdateCaseRequest) actualRequests.get(0));

    Assert.assertEquals(case_, actualRequest.getCase());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateCaseExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCaseService.addException(exception);

    try {
      Case case_ = Case.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateCase(case_, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void escalateCaseTest() throws Exception {
    Case expectedResponse =
        Case.newBuilder()
            .setName(CaseName.ofProjectCaseName("[PROJECT]", "[CASE]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setClassification(CaseClassification.newBuilder().build())
            .setTimeZone("timeZone-2077180903")
            .addAllSubscriberEmailAddresses(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setCreator(Actor.newBuilder().build())
            .setContactEmail("contactEmail1253690204")
            .setEscalated(true)
            .setTestCase(true)
            .setLanguageCode("languageCode-2092349083")
            .build();
    mockCaseService.addResponse(expectedResponse);

    EscalateCaseRequest request =
        EscalateCaseRequest.newBuilder()
            .setName(CaseName.ofProjectCaseName("[PROJECT]", "[CASE]").toString())
            .setEscalation(Escalation.newBuilder().build())
            .build();

    Case actualResponse = client.escalateCase(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCaseService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    EscalateCaseRequest actualRequest = ((EscalateCaseRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getEscalation(), actualRequest.getEscalation());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void escalateCaseExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCaseService.addException(exception);

    try {
      EscalateCaseRequest request =
          EscalateCaseRequest.newBuilder()
              .setName(CaseName.ofProjectCaseName("[PROJECT]", "[CASE]").toString())
              .setEscalation(Escalation.newBuilder().build())
              .build();
      client.escalateCase(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void closeCaseTest() throws Exception {
    Case expectedResponse =
        Case.newBuilder()
            .setName(CaseName.ofProjectCaseName("[PROJECT]", "[CASE]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setClassification(CaseClassification.newBuilder().build())
            .setTimeZone("timeZone-2077180903")
            .addAllSubscriberEmailAddresses(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setCreator(Actor.newBuilder().build())
            .setContactEmail("contactEmail1253690204")
            .setEscalated(true)
            .setTestCase(true)
            .setLanguageCode("languageCode-2092349083")
            .build();
    mockCaseService.addResponse(expectedResponse);

    CloseCaseRequest request =
        CloseCaseRequest.newBuilder()
            .setName(CaseName.ofProjectCaseName("[PROJECT]", "[CASE]").toString())
            .build();

    Case actualResponse = client.closeCase(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCaseService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CloseCaseRequest actualRequest = ((CloseCaseRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void closeCaseExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCaseService.addException(exception);

    try {
      CloseCaseRequest request =
          CloseCaseRequest.newBuilder()
              .setName(CaseName.ofProjectCaseName("[PROJECT]", "[CASE]").toString())
              .build();
      client.closeCase(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void searchCaseClassificationsTest() throws Exception {
    CaseClassification responsesElement = CaseClassification.newBuilder().build();
    SearchCaseClassificationsResponse expectedResponse =
        SearchCaseClassificationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllCaseClassifications(Arrays.asList(responsesElement))
            .build();
    mockCaseService.addResponse(expectedResponse);

    SearchCaseClassificationsRequest request =
        SearchCaseClassificationsRequest.newBuilder()
            .setQuery("query107944136")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    SearchCaseClassificationsPagedResponse pagedListResponse =
        client.searchCaseClassifications(request);

    List<CaseClassification> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCaseClassificationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCaseService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SearchCaseClassificationsRequest actualRequest =
        ((SearchCaseClassificationsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getQuery(), actualRequest.getQuery());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void searchCaseClassificationsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCaseService.addException(exception);

    try {
      SearchCaseClassificationsRequest request =
          SearchCaseClassificationsRequest.newBuilder()
              .setQuery("query107944136")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      client.searchCaseClassifications(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
