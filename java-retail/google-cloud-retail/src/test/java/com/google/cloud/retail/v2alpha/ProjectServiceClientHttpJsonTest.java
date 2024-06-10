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

package com.google.cloud.retail.v2alpha;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.retail.v2alpha.stub.HttpJsonProjectServiceStub;
import com.google.longrunning.Operation;
import com.google.protobuf.Any;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.ArrayList;
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
            .setName(RetailProjectName.of("[PROJECT]").toString())
            .addAllEnrolledSolutions(new ArrayList<SolutionType>())
            .build();
    mockService.addResponse(expectedResponse);

    RetailProjectName name = RetailProjectName.of("[PROJECT]");

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
      RetailProjectName name = RetailProjectName.of("[PROJECT]");
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
            .setName(RetailProjectName.of("[PROJECT]").toString())
            .addAllEnrolledSolutions(new ArrayList<SolutionType>())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-4503/retailProject";

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
      String name = "projects/project-4503/retailProject";
      client.getProject(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void acceptTermsTest() throws Exception {
    Project expectedResponse =
        Project.newBuilder()
            .setName(RetailProjectName.of("[PROJECT]").toString())
            .addAllEnrolledSolutions(new ArrayList<SolutionType>())
            .build();
    mockService.addResponse(expectedResponse);

    RetailProjectName project = RetailProjectName.of("[PROJECT]");

    Project actualResponse = client.acceptTerms(project);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void acceptTermsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      RetailProjectName project = RetailProjectName.of("[PROJECT]");
      client.acceptTerms(project);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void acceptTermsTest2() throws Exception {
    Project expectedResponse =
        Project.newBuilder()
            .setName(RetailProjectName.of("[PROJECT]").toString())
            .addAllEnrolledSolutions(new ArrayList<SolutionType>())
            .build();
    mockService.addResponse(expectedResponse);

    String project = "projects/project-5109/retailProject";

    Project actualResponse = client.acceptTerms(project);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void acceptTermsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String project = "projects/project-5109/retailProject";
      client.acceptTerms(project);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void enrollSolutionTest() throws Exception {
    EnrollSolutionResponse expectedResponse =
        EnrollSolutionResponse.newBuilder().setEnrolledSolution(SolutionType.forNumber(0)).build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("enrollSolutionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    EnrollSolutionRequest request =
        EnrollSolutionRequest.newBuilder()
            .setProject(ProjectName.of("[PROJECT]").toString())
            .setSolution(SolutionType.forNumber(0))
            .build();

    EnrollSolutionResponse actualResponse = client.enrollSolutionAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void enrollSolutionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      EnrollSolutionRequest request =
          EnrollSolutionRequest.newBuilder()
              .setProject(ProjectName.of("[PROJECT]").toString())
              .setSolution(SolutionType.forNumber(0))
              .build();
      client.enrollSolutionAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void listEnrolledSolutionsTest() throws Exception {
    ListEnrolledSolutionsResponse expectedResponse =
        ListEnrolledSolutionsResponse.newBuilder()
            .addAllEnrolledSolutions(new ArrayList<SolutionType>())
            .build();
    mockService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");

    ListEnrolledSolutionsResponse actualResponse = client.listEnrolledSolutions(parent);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listEnrolledSolutionsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      client.listEnrolledSolutions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listEnrolledSolutionsTest2() throws Exception {
    ListEnrolledSolutionsResponse expectedResponse =
        ListEnrolledSolutionsResponse.newBuilder()
            .addAllEnrolledSolutions(new ArrayList<SolutionType>())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-2353";

    ListEnrolledSolutionsResponse actualResponse = client.listEnrolledSolutions(parent);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listEnrolledSolutionsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-2353";
      client.listEnrolledSolutions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getLoggingConfigTest() throws Exception {
    LoggingConfig expectedResponse =
        LoggingConfig.newBuilder()
            .setName(LoggingConfigName.of("[PROJECT]").toString())
            .setDefaultLogGenerationRule(LoggingConfig.LogGenerationRule.newBuilder().build())
            .addAllServiceLogGenerationRules(
                new ArrayList<LoggingConfig.ServiceLogGenerationRule>())
            .build();
    mockService.addResponse(expectedResponse);

    LoggingConfigName name = LoggingConfigName.of("[PROJECT]");

    LoggingConfig actualResponse = client.getLoggingConfig(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getLoggingConfigExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LoggingConfigName name = LoggingConfigName.of("[PROJECT]");
      client.getLoggingConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getLoggingConfigTest2() throws Exception {
    LoggingConfig expectedResponse =
        LoggingConfig.newBuilder()
            .setName(LoggingConfigName.of("[PROJECT]").toString())
            .setDefaultLogGenerationRule(LoggingConfig.LogGenerationRule.newBuilder().build())
            .addAllServiceLogGenerationRules(
                new ArrayList<LoggingConfig.ServiceLogGenerationRule>())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-1650/loggingConfig";

    LoggingConfig actualResponse = client.getLoggingConfig(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getLoggingConfigExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-1650/loggingConfig";
      client.getLoggingConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateLoggingConfigTest() throws Exception {
    LoggingConfig expectedResponse =
        LoggingConfig.newBuilder()
            .setName(LoggingConfigName.of("[PROJECT]").toString())
            .setDefaultLogGenerationRule(LoggingConfig.LogGenerationRule.newBuilder().build())
            .addAllServiceLogGenerationRules(
                new ArrayList<LoggingConfig.ServiceLogGenerationRule>())
            .build();
    mockService.addResponse(expectedResponse);

    LoggingConfig loggingConfig =
        LoggingConfig.newBuilder()
            .setName(LoggingConfigName.of("[PROJECT]").toString())
            .setDefaultLogGenerationRule(LoggingConfig.LogGenerationRule.newBuilder().build())
            .addAllServiceLogGenerationRules(
                new ArrayList<LoggingConfig.ServiceLogGenerationRule>())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    LoggingConfig actualResponse = client.updateLoggingConfig(loggingConfig, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void updateLoggingConfigExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LoggingConfig loggingConfig =
          LoggingConfig.newBuilder()
              .setName(LoggingConfigName.of("[PROJECT]").toString())
              .setDefaultLogGenerationRule(LoggingConfig.LogGenerationRule.newBuilder().build())
              .addAllServiceLogGenerationRules(
                  new ArrayList<LoggingConfig.ServiceLogGenerationRule>())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateLoggingConfig(loggingConfig, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAlertConfigTest() throws Exception {
    AlertConfig expectedResponse =
        AlertConfig.newBuilder()
            .setName(AlertConfigName.of("[PROJECT]").toString())
            .addAllAlertPolicies(new ArrayList<AlertConfig.AlertPolicy>())
            .build();
    mockService.addResponse(expectedResponse);

    AlertConfigName name = AlertConfigName.of("[PROJECT]");

    AlertConfig actualResponse = client.getAlertConfig(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getAlertConfigExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AlertConfigName name = AlertConfigName.of("[PROJECT]");
      client.getAlertConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAlertConfigTest2() throws Exception {
    AlertConfig expectedResponse =
        AlertConfig.newBuilder()
            .setName(AlertConfigName.of("[PROJECT]").toString())
            .addAllAlertPolicies(new ArrayList<AlertConfig.AlertPolicy>())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-5457/alertConfig";

    AlertConfig actualResponse = client.getAlertConfig(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getAlertConfigExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-5457/alertConfig";
      client.getAlertConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateAlertConfigTest() throws Exception {
    AlertConfig expectedResponse =
        AlertConfig.newBuilder()
            .setName(AlertConfigName.of("[PROJECT]").toString())
            .addAllAlertPolicies(new ArrayList<AlertConfig.AlertPolicy>())
            .build();
    mockService.addResponse(expectedResponse);

    AlertConfig alertConfig =
        AlertConfig.newBuilder()
            .setName(AlertConfigName.of("[PROJECT]").toString())
            .addAllAlertPolicies(new ArrayList<AlertConfig.AlertPolicy>())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    AlertConfig actualResponse = client.updateAlertConfig(alertConfig, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void updateAlertConfigExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AlertConfig alertConfig =
          AlertConfig.newBuilder()
              .setName(AlertConfigName.of("[PROJECT]").toString())
              .addAllAlertPolicies(new ArrayList<AlertConfig.AlertPolicy>())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateAlertConfig(alertConfig, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
