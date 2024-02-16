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

package com.google.cloud.support.v2;

import static com.google.cloud.support.v2.CaseServiceClient.ListCasesPagedResponse;
import static com.google.cloud.support.v2.CaseServiceClient.SearchCaseClassificationsPagedResponse;
import static com.google.cloud.support.v2.CaseServiceClient.SearchCasesPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.support.v2.stub.HttpJsonCaseServiceStub;
import com.google.common.collect.Lists;
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
public class CaseServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static CaseServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonCaseServiceStub.getMethodDescriptors(),
            CaseServiceSettings.getDefaultEndpoint());
    CaseServiceSettings settings =
        CaseServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                CaseServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = CaseServiceClient.create(settings);
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
    mockService.addResponse(expectedResponse);

    CaseName name = CaseName.ofProjectCaseName("[PROJECT]", "[CASE]");

    Case actualResponse = client.getCase(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getCaseExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name = "projects/project-3807/cases/case-3807";

    Case actualResponse = client.getCase(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getCaseExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-3807/cases/case-3807";
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
    mockService.addResponse(expectedResponse);

    OrganizationName parent = OrganizationName.of("[ORGANIZATION]");

    ListCasesPagedResponse pagedListResponse = client.listCases(parent);

    List<Case> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCasesList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listCasesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");

    ListCasesPagedResponse pagedListResponse = client.listCases(parent);

    List<Case> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCasesList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listCasesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-2353";

    ListCasesPagedResponse pagedListResponse = client.listCases(parent);

    List<Case> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCasesList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listCasesExceptionTest3() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-2353";
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
    mockService.addResponse(expectedResponse);

    SearchCasesRequest request =
        SearchCasesRequest.newBuilder()
            .setParent("projects/project-2353")
            .setQuery("query107944136")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    SearchCasesPagedResponse pagedListResponse = client.searchCases(request);

    List<Case> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCasesList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void searchCasesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SearchCasesRequest request =
          SearchCasesRequest.newBuilder()
              .setParent("projects/project-2353")
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
    mockService.addResponse(expectedResponse);

    OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
    Case case_ = Case.newBuilder().build();

    Case actualResponse = client.createCase(parent, case_);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createCaseExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");
    Case case_ = Case.newBuilder().build();

    Case actualResponse = client.createCase(parent, case_);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createCaseExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-2353";
    Case case_ = Case.newBuilder().build();

    Case actualResponse = client.createCase(parent, case_);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createCaseExceptionTest3() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-2353";
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
    mockService.addResponse(expectedResponse);

    Case case_ =
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
    FieldMask updateMask = FieldMask.newBuilder().build();

    Case actualResponse = client.updateCase(case_, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void updateCaseExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Case case_ =
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
    mockService.addResponse(expectedResponse);

    EscalateCaseRequest request =
        EscalateCaseRequest.newBuilder()
            .setName(CaseName.ofProjectCaseName("[PROJECT]", "[CASE]").toString())
            .setEscalation(Escalation.newBuilder().build())
            .build();

    Case actualResponse = client.escalateCase(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void escalateCaseExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    CloseCaseRequest request =
        CloseCaseRequest.newBuilder()
            .setName(CaseName.ofProjectCaseName("[PROJECT]", "[CASE]").toString())
            .build();

    Case actualResponse = client.closeCase(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void closeCaseExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

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

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void searchCaseClassificationsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
