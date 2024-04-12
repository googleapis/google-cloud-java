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

package com.google.cloud.discoveryengine.v1alpha;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.discoveryengine.v1alpha.stub.HttpJsonProjectServiceStub;
import com.google.longrunning.Operation;
import com.google.protobuf.Any;
import com.google.protobuf.Timestamp;
import java.io.IOException;
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
public class ProjectServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static ProjectServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonProjectServiceStub.getMethodDescriptors(),
            ProjectServiceSettings.getDefaultEndpoint());
    ProjectServiceSettings settings =
        ProjectServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                ProjectServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ProjectServiceClient.create(settings);
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
  public void getProjectTest() throws Exception {
    Project expectedResponse =
        Project.newBuilder()
            .setName(ProjectName.of("[PROJECT]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setProvisionCompletionTime(Timestamp.newBuilder().build())
            .putAllServiceTermsMap(new HashMap<String, Project.ServiceTerms>())
            .build();
    mockService.addResponse(expectedResponse);

    ProjectName name = ProjectName.of("[PROJECT]");

    Project actualResponse = client.getProject(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getProjectExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ProjectName name = ProjectName.of("[PROJECT]");
      client.getProject(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getProjectTest2() throws Exception {
    Project expectedResponse =
        Project.newBuilder()
            .setName(ProjectName.of("[PROJECT]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setProvisionCompletionTime(Timestamp.newBuilder().build())
            .putAllServiceTermsMap(new HashMap<String, Project.ServiceTerms>())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-3664";

    Project actualResponse = client.getProject(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getProjectExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-3664";
      client.getProject(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void provisionProjectTest() throws Exception {
    Project expectedResponse =
        Project.newBuilder()
            .setName(ProjectName.of("[PROJECT]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setProvisionCompletionTime(Timestamp.newBuilder().build())
            .putAllServiceTermsMap(new HashMap<String, Project.ServiceTerms>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("provisionProjectTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    ProjectName name = ProjectName.of("[PROJECT]");

    Project actualResponse = client.provisionProjectAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void provisionProjectExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ProjectName name = ProjectName.of("[PROJECT]");
      client.provisionProjectAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void provisionProjectTest2() throws Exception {
    Project expectedResponse =
        Project.newBuilder()
            .setName(ProjectName.of("[PROJECT]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setProvisionCompletionTime(Timestamp.newBuilder().build())
            .putAllServiceTermsMap(new HashMap<String, Project.ServiceTerms>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("provisionProjectTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name = "projects/project-3664";

    Project actualResponse = client.provisionProjectAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void provisionProjectExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-3664";
      client.provisionProjectAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void reportConsentChangeTest() throws Exception {
    Project expectedResponse =
        Project.newBuilder()
            .setName(ProjectName.of("[PROJECT]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setProvisionCompletionTime(Timestamp.newBuilder().build())
            .putAllServiceTermsMap(new HashMap<String, Project.ServiceTerms>())
            .build();
    mockService.addResponse(expectedResponse);

    ReportConsentChangeRequest.ConsentChangeAction consentChangeAction =
        ReportConsentChangeRequest.ConsentChangeAction.forNumber(0);
    ProjectName project = ProjectName.of("[PROJECT]");
    String serviceTermId = "serviceTermId-2051343940";
    String serviceTermVersion = "serviceTermVersion-571872041";

    Project actualResponse =
        client.reportConsentChange(consentChangeAction, project, serviceTermId, serviceTermVersion);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void reportConsentChangeExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ReportConsentChangeRequest.ConsentChangeAction consentChangeAction =
          ReportConsentChangeRequest.ConsentChangeAction.forNumber(0);
      ProjectName project = ProjectName.of("[PROJECT]");
      String serviceTermId = "serviceTermId-2051343940";
      String serviceTermVersion = "serviceTermVersion-571872041";
      client.reportConsentChange(consentChangeAction, project, serviceTermId, serviceTermVersion);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void reportConsentChangeTest2() throws Exception {
    Project expectedResponse =
        Project.newBuilder()
            .setName(ProjectName.of("[PROJECT]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setProvisionCompletionTime(Timestamp.newBuilder().build())
            .putAllServiceTermsMap(new HashMap<String, Project.ServiceTerms>())
            .build();
    mockService.addResponse(expectedResponse);

    ReportConsentChangeRequest.ConsentChangeAction consentChangeAction =
        ReportConsentChangeRequest.ConsentChangeAction.forNumber(0);
    String project = "projects/project-7934";
    String serviceTermId = "serviceTermId-2051343940";
    String serviceTermVersion = "serviceTermVersion-571872041";

    Project actualResponse =
        client.reportConsentChange(consentChangeAction, project, serviceTermId, serviceTermVersion);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void reportConsentChangeExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ReportConsentChangeRequest.ConsentChangeAction consentChangeAction =
          ReportConsentChangeRequest.ConsentChangeAction.forNumber(0);
      String project = "projects/project-7934";
      String serviceTermId = "serviceTermId-2051343940";
      String serviceTermVersion = "serviceTermVersion-571872041";
      client.reportConsentChange(consentChangeAction, project, serviceTermId, serviceTermVersion);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
