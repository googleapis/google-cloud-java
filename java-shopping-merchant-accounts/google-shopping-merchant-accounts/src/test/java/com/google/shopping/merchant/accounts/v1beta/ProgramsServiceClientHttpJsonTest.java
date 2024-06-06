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

package com.google.shopping.merchant.accounts.v1beta;

import static com.google.shopping.merchant.accounts.v1beta.ProgramsServiceClient.ListProgramsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.common.collect.Lists;
import com.google.shopping.merchant.accounts.v1beta.stub.HttpJsonProgramsServiceStub;
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
public class ProgramsServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static ProgramsServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonProgramsServiceStub.getMethodDescriptors(),
            ProgramsServiceSettings.getDefaultEndpoint());
    ProgramsServiceSettings settings =
        ProgramsServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                ProgramsServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ProgramsServiceClient.create(settings);
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
  public void getProgramTest() throws Exception {
    Program expectedResponse =
        Program.newBuilder()
            .setName(ProgramName.of("[ACCOUNT]", "[PROGRAM]").toString())
            .setDocumentationUri("documentationUri-1487620014")
            .addAllActiveRegionCodes(new ArrayList<String>())
            .addAllUnmetRequirements(new ArrayList<Program.Requirement>())
            .build();
    mockService.addResponse(expectedResponse);

    ProgramName name = ProgramName.of("[ACCOUNT]", "[PROGRAM]");

    Program actualResponse = client.getProgram(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getProgramExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ProgramName name = ProgramName.of("[ACCOUNT]", "[PROGRAM]");
      client.getProgram(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getProgramTest2() throws Exception {
    Program expectedResponse =
        Program.newBuilder()
            .setName(ProgramName.of("[ACCOUNT]", "[PROGRAM]").toString())
            .setDocumentationUri("documentationUri-1487620014")
            .addAllActiveRegionCodes(new ArrayList<String>())
            .addAllUnmetRequirements(new ArrayList<Program.Requirement>())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "accounts/account-4445/programs/program-4445";

    Program actualResponse = client.getProgram(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getProgramExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "accounts/account-4445/programs/program-4445";
      client.getProgram(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listProgramsTest() throws Exception {
    Program responsesElement = Program.newBuilder().build();
    ListProgramsResponse expectedResponse =
        ListProgramsResponse.newBuilder()
            .setNextPageToken("")
            .addAllPrograms(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    AccountName parent = AccountName.of("[ACCOUNT]");

    ListProgramsPagedResponse pagedListResponse = client.listPrograms(parent);

    List<Program> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getProgramsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listProgramsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AccountName parent = AccountName.of("[ACCOUNT]");
      client.listPrograms(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listProgramsTest2() throws Exception {
    Program responsesElement = Program.newBuilder().build();
    ListProgramsResponse expectedResponse =
        ListProgramsResponse.newBuilder()
            .setNextPageToken("")
            .addAllPrograms(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "accounts/account-4811";

    ListProgramsPagedResponse pagedListResponse = client.listPrograms(parent);

    List<Program> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getProgramsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listProgramsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "accounts/account-4811";
      client.listPrograms(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void enableProgramTest() throws Exception {
    Program expectedResponse =
        Program.newBuilder()
            .setName(ProgramName.of("[ACCOUNT]", "[PROGRAM]").toString())
            .setDocumentationUri("documentationUri-1487620014")
            .addAllActiveRegionCodes(new ArrayList<String>())
            .addAllUnmetRequirements(new ArrayList<Program.Requirement>())
            .build();
    mockService.addResponse(expectedResponse);

    ProgramName name = ProgramName.of("[ACCOUNT]", "[PROGRAM]");

    Program actualResponse = client.enableProgram(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void enableProgramExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ProgramName name = ProgramName.of("[ACCOUNT]", "[PROGRAM]");
      client.enableProgram(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void enableProgramTest2() throws Exception {
    Program expectedResponse =
        Program.newBuilder()
            .setName(ProgramName.of("[ACCOUNT]", "[PROGRAM]").toString())
            .setDocumentationUri("documentationUri-1487620014")
            .addAllActiveRegionCodes(new ArrayList<String>())
            .addAllUnmetRequirements(new ArrayList<Program.Requirement>())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "accounts/account-4445/programs/program-4445";

    Program actualResponse = client.enableProgram(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void enableProgramExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "accounts/account-4445/programs/program-4445";
      client.enableProgram(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void disableProgramTest() throws Exception {
    Program expectedResponse =
        Program.newBuilder()
            .setName(ProgramName.of("[ACCOUNT]", "[PROGRAM]").toString())
            .setDocumentationUri("documentationUri-1487620014")
            .addAllActiveRegionCodes(new ArrayList<String>())
            .addAllUnmetRequirements(new ArrayList<Program.Requirement>())
            .build();
    mockService.addResponse(expectedResponse);

    ProgramName name = ProgramName.of("[ACCOUNT]", "[PROGRAM]");

    Program actualResponse = client.disableProgram(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void disableProgramExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ProgramName name = ProgramName.of("[ACCOUNT]", "[PROGRAM]");
      client.disableProgram(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void disableProgramTest2() throws Exception {
    Program expectedResponse =
        Program.newBuilder()
            .setName(ProgramName.of("[ACCOUNT]", "[PROGRAM]").toString())
            .setDocumentationUri("documentationUri-1487620014")
            .addAllActiveRegionCodes(new ArrayList<String>())
            .addAllUnmetRequirements(new ArrayList<Program.Requirement>())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "accounts/account-4445/programs/program-4445";

    Program actualResponse = client.disableProgram(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void disableProgramExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "accounts/account-4445/programs/program-4445";
      client.disableProgram(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
