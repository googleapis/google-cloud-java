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
import com.google.protobuf.Empty;
import com.google.shopping.merchant.accounts.v1beta.stub.HttpJsonTermsOfServiceServiceStub;
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
public class TermsOfServiceServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static TermsOfServiceServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonTermsOfServiceServiceStub.getMethodDescriptors(),
            TermsOfServiceServiceSettings.getDefaultEndpoint());
    TermsOfServiceServiceSettings settings =
        TermsOfServiceServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                TermsOfServiceServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = TermsOfServiceServiceClient.create(settings);
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
  public void getTermsOfServiceTest() throws Exception {
    TermsOfService expectedResponse =
        TermsOfService.newBuilder()
            .setName(TermsOfServiceName.of("[VERSION]").toString())
            .setRegionCode("regionCode-1991004415")
            .setKind(TermsOfServiceKind.forNumber(0))
            .setFileUri("fileUri-855009712")
            .setExternal(true)
            .build();
    mockService.addResponse(expectedResponse);

    TermsOfServiceName name = TermsOfServiceName.of("[VERSION]");

    TermsOfService actualResponse = client.getTermsOfService(name);
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
  public void getTermsOfServiceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      TermsOfServiceName name = TermsOfServiceName.of("[VERSION]");
      client.getTermsOfService(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getTermsOfServiceTest2() throws Exception {
    TermsOfService expectedResponse =
        TermsOfService.newBuilder()
            .setName(TermsOfServiceName.of("[VERSION]").toString())
            .setRegionCode("regionCode-1991004415")
            .setKind(TermsOfServiceKind.forNumber(0))
            .setFileUri("fileUri-855009712")
            .setExternal(true)
            .build();
    mockService.addResponse(expectedResponse);

    String name = "termsOfService/termsOfServic-8211";

    TermsOfService actualResponse = client.getTermsOfService(name);
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
  public void getTermsOfServiceExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "termsOfService/termsOfServic-8211";
      client.getTermsOfService(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void retrieveLatestTermsOfServiceTest() throws Exception {
    TermsOfService expectedResponse =
        TermsOfService.newBuilder()
            .setName(TermsOfServiceName.of("[VERSION]").toString())
            .setRegionCode("regionCode-1991004415")
            .setKind(TermsOfServiceKind.forNumber(0))
            .setFileUri("fileUri-855009712")
            .setExternal(true)
            .build();
    mockService.addResponse(expectedResponse);

    RetrieveLatestTermsOfServiceRequest request =
        RetrieveLatestTermsOfServiceRequest.newBuilder()
            .setRegionCode("regionCode-1991004415")
            .setKind(TermsOfServiceKind.forNumber(0))
            .build();

    TermsOfService actualResponse = client.retrieveLatestTermsOfService(request);
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
  public void retrieveLatestTermsOfServiceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      RetrieveLatestTermsOfServiceRequest request =
          RetrieveLatestTermsOfServiceRequest.newBuilder()
              .setRegionCode("regionCode-1991004415")
              .setKind(TermsOfServiceKind.forNumber(0))
              .build();
      client.retrieveLatestTermsOfService(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void acceptTermsOfServiceTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    TermsOfServiceName name = TermsOfServiceName.of("[VERSION]");

    client.acceptTermsOfService(name);

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
  public void acceptTermsOfServiceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      TermsOfServiceName name = TermsOfServiceName.of("[VERSION]");
      client.acceptTermsOfService(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void acceptTermsOfServiceTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name = "termsOfService/termsOfServic-8211";

    client.acceptTermsOfService(name);

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
  public void acceptTermsOfServiceExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "termsOfService/termsOfServic-8211";
      client.acceptTermsOfService(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
