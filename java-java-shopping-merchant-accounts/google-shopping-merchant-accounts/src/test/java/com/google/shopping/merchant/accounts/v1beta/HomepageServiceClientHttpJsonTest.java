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
import com.google.protobuf.FieldMask;
import com.google.shopping.merchant.accounts.v1beta.stub.HttpJsonHomepageServiceStub;
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
public class HomepageServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static HomepageServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonHomepageServiceStub.getMethodDescriptors(),
            HomepageServiceSettings.getDefaultEndpoint());
    HomepageServiceSettings settings =
        HomepageServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                HomepageServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = HomepageServiceClient.create(settings);
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
  public void getHomepageTest() throws Exception {
    Homepage expectedResponse =
        Homepage.newBuilder()
            .setName(HomepageName.of("[ACCOUNT]").toString())
            .setUri("uri116076")
            .setClaimed(true)
            .build();
    mockService.addResponse(expectedResponse);

    HomepageName name = HomepageName.of("[ACCOUNT]");

    Homepage actualResponse = client.getHomepage(name);
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
  public void getHomepageExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      HomepageName name = HomepageName.of("[ACCOUNT]");
      client.getHomepage(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getHomepageTest2() throws Exception {
    Homepage expectedResponse =
        Homepage.newBuilder()
            .setName(HomepageName.of("[ACCOUNT]").toString())
            .setUri("uri116076")
            .setClaimed(true)
            .build();
    mockService.addResponse(expectedResponse);

    String name = "accounts/account-639/homepage";

    Homepage actualResponse = client.getHomepage(name);
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
  public void getHomepageExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "accounts/account-639/homepage";
      client.getHomepage(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateHomepageTest() throws Exception {
    Homepage expectedResponse =
        Homepage.newBuilder()
            .setName(HomepageName.of("[ACCOUNT]").toString())
            .setUri("uri116076")
            .setClaimed(true)
            .build();
    mockService.addResponse(expectedResponse);

    Homepage homepage =
        Homepage.newBuilder()
            .setName(HomepageName.of("[ACCOUNT]").toString())
            .setUri("uri116076")
            .setClaimed(true)
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Homepage actualResponse = client.updateHomepage(homepage, updateMask);
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
  public void updateHomepageExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Homepage homepage =
          Homepage.newBuilder()
              .setName(HomepageName.of("[ACCOUNT]").toString())
              .setUri("uri116076")
              .setClaimed(true)
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateHomepage(homepage, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void claimHomepageTest() throws Exception {
    Homepage expectedResponse =
        Homepage.newBuilder()
            .setName(HomepageName.of("[ACCOUNT]").toString())
            .setUri("uri116076")
            .setClaimed(true)
            .build();
    mockService.addResponse(expectedResponse);

    ClaimHomepageRequest request =
        ClaimHomepageRequest.newBuilder().setName(HomepageName.of("[ACCOUNT]").toString()).build();

    Homepage actualResponse = client.claimHomepage(request);
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
  public void claimHomepageExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ClaimHomepageRequest request =
          ClaimHomepageRequest.newBuilder()
              .setName(HomepageName.of("[ACCOUNT]").toString())
              .build();
      client.claimHomepage(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void unclaimHomepageTest() throws Exception {
    Homepage expectedResponse =
        Homepage.newBuilder()
            .setName(HomepageName.of("[ACCOUNT]").toString())
            .setUri("uri116076")
            .setClaimed(true)
            .build();
    mockService.addResponse(expectedResponse);

    UnclaimHomepageRequest request =
        UnclaimHomepageRequest.newBuilder()
            .setName(HomepageName.of("[ACCOUNT]").toString())
            .build();

    Homepage actualResponse = client.unclaimHomepage(request);
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
  public void unclaimHomepageExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      UnclaimHomepageRequest request =
          UnclaimHomepageRequest.newBuilder()
              .setName(HomepageName.of("[ACCOUNT]").toString())
              .build();
      client.unclaimHomepage(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
