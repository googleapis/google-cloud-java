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

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.shopping.merchant.accounts.v1beta.stub.HttpJsonTermsOfServiceAgreementStateServiceStub;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class TermsOfServiceAgreementStateServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static TermsOfServiceAgreementStateServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonTermsOfServiceAgreementStateServiceStub.getMethodDescriptors(),
            TermsOfServiceAgreementStateServiceSettings.getDefaultEndpoint());
    TermsOfServiceAgreementStateServiceSettings settings =
        TermsOfServiceAgreementStateServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                TermsOfServiceAgreementStateServiceSettings
                    .defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = TermsOfServiceAgreementStateServiceClient.create(settings);
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
  public void getTermsOfServiceAgreementStateTest() throws Exception {
    TermsOfServiceAgreementState expectedResponse =
        TermsOfServiceAgreementState.newBuilder()
            .setName(TermsOfServiceAgreementStateName.of("[ACCOUNT]", "[IDENTIFIER]").toString())
            .setRegionCode("regionCode-1991004415")
            .setTermsOfServiceKind(TermsOfServiceKind.forNumber(0))
            .setAccepted(Accepted.newBuilder().build())
            .setRequired(Required.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    TermsOfServiceAgreementStateName name =
        TermsOfServiceAgreementStateName.of("[ACCOUNT]", "[IDENTIFIER]");

    TermsOfServiceAgreementState actualResponse = client.getTermsOfServiceAgreementState(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getTermsOfServiceAgreementStateExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      TermsOfServiceAgreementStateName name =
          TermsOfServiceAgreementStateName.of("[ACCOUNT]", "[IDENTIFIER]");
      client.getTermsOfServiceAgreementState(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getTermsOfServiceAgreementStateTest2() throws Exception {
    TermsOfServiceAgreementState expectedResponse =
        TermsOfServiceAgreementState.newBuilder()
            .setName(TermsOfServiceAgreementStateName.of("[ACCOUNT]", "[IDENTIFIER]").toString())
            .setRegionCode("regionCode-1991004415")
            .setTermsOfServiceKind(TermsOfServiceKind.forNumber(0))
            .setAccepted(Accepted.newBuilder().build())
            .setRequired(Required.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "accounts/account-3027/termsOfServiceAgreementStates/termsOfServiceAgreementState-3027";

    TermsOfServiceAgreementState actualResponse = client.getTermsOfServiceAgreementState(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getTermsOfServiceAgreementStateExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "accounts/account-3027/termsOfServiceAgreementStates/termsOfServiceAgreementState-3027";
      client.getTermsOfServiceAgreementState(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void retrieveForApplicationTermsOfServiceAgreementStateTest() throws Exception {
    TermsOfServiceAgreementState expectedResponse =
        TermsOfServiceAgreementState.newBuilder()
            .setName(TermsOfServiceAgreementStateName.of("[ACCOUNT]", "[IDENTIFIER]").toString())
            .setRegionCode("regionCode-1991004415")
            .setTermsOfServiceKind(TermsOfServiceKind.forNumber(0))
            .setAccepted(Accepted.newBuilder().build())
            .setRequired(Required.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    AccountName parent = AccountName.of("[ACCOUNT]");

    TermsOfServiceAgreementState actualResponse =
        client.retrieveForApplicationTermsOfServiceAgreementState(parent);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void retrieveForApplicationTermsOfServiceAgreementStateExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AccountName parent = AccountName.of("[ACCOUNT]");
      client.retrieveForApplicationTermsOfServiceAgreementState(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void retrieveForApplicationTermsOfServiceAgreementStateTest2() throws Exception {
    TermsOfServiceAgreementState expectedResponse =
        TermsOfServiceAgreementState.newBuilder()
            .setName(TermsOfServiceAgreementStateName.of("[ACCOUNT]", "[IDENTIFIER]").toString())
            .setRegionCode("regionCode-1991004415")
            .setTermsOfServiceKind(TermsOfServiceKind.forNumber(0))
            .setAccepted(Accepted.newBuilder().build())
            .setRequired(Required.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "accounts/account-4811";

    TermsOfServiceAgreementState actualResponse =
        client.retrieveForApplicationTermsOfServiceAgreementState(parent);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void retrieveForApplicationTermsOfServiceAgreementStateExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "accounts/account-4811";
      client.retrieveForApplicationTermsOfServiceAgreementState(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
