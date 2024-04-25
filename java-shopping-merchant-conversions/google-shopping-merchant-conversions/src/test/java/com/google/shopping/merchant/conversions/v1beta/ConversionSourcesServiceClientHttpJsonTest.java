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

package com.google.shopping.merchant.conversions.v1beta;

import static com.google.shopping.merchant.conversions.v1beta.ConversionSourcesServiceClient.ListConversionSourcesPagedResponse;

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
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import com.google.shopping.merchant.conversions.v1beta.stub.HttpJsonConversionSourcesServiceStub;
import java.io.IOException;
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
public class ConversionSourcesServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static ConversionSourcesServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonConversionSourcesServiceStub.getMethodDescriptors(),
            ConversionSourcesServiceSettings.getDefaultEndpoint());
    ConversionSourcesServiceSettings settings =
        ConversionSourcesServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                ConversionSourcesServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ConversionSourcesServiceClient.create(settings);
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
  public void createConversionSourceTest() throws Exception {
    ConversionSource expectedResponse =
        ConversionSource.newBuilder()
            .setName(ConversionSourceName.of("[ACCOUNT]", "[CONVERSION_SOURCE]").toString())
            .setExpireTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    AccountName parent = AccountName.of("[ACCOUNT]");
    ConversionSource conversionSource = ConversionSource.newBuilder().build();

    ConversionSource actualResponse = client.createConversionSource(parent, conversionSource);
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
  public void createConversionSourceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AccountName parent = AccountName.of("[ACCOUNT]");
      ConversionSource conversionSource = ConversionSource.newBuilder().build();
      client.createConversionSource(parent, conversionSource);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createConversionSourceTest2() throws Exception {
    ConversionSource expectedResponse =
        ConversionSource.newBuilder()
            .setName(ConversionSourceName.of("[ACCOUNT]", "[CONVERSION_SOURCE]").toString())
            .setExpireTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "accounts/account-4811";
    ConversionSource conversionSource = ConversionSource.newBuilder().build();

    ConversionSource actualResponse = client.createConversionSource(parent, conversionSource);
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
  public void createConversionSourceExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "accounts/account-4811";
      ConversionSource conversionSource = ConversionSource.newBuilder().build();
      client.createConversionSource(parent, conversionSource);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateConversionSourceTest() throws Exception {
    ConversionSource expectedResponse =
        ConversionSource.newBuilder()
            .setName(ConversionSourceName.of("[ACCOUNT]", "[CONVERSION_SOURCE]").toString())
            .setExpireTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    ConversionSource conversionSource =
        ConversionSource.newBuilder()
            .setName(ConversionSourceName.of("[ACCOUNT]", "[CONVERSION_SOURCE]").toString())
            .setExpireTime(Timestamp.newBuilder().build())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    ConversionSource actualResponse = client.updateConversionSource(conversionSource, updateMask);
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
  public void updateConversionSourceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ConversionSource conversionSource =
          ConversionSource.newBuilder()
              .setName(ConversionSourceName.of("[ACCOUNT]", "[CONVERSION_SOURCE]").toString())
              .setExpireTime(Timestamp.newBuilder().build())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateConversionSource(conversionSource, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteConversionSourceTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    ConversionSourceName name = ConversionSourceName.of("[ACCOUNT]", "[CONVERSION_SOURCE]");

    client.deleteConversionSource(name);

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
  public void deleteConversionSourceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ConversionSourceName name = ConversionSourceName.of("[ACCOUNT]", "[CONVERSION_SOURCE]");
      client.deleteConversionSource(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteConversionSourceTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name = "accounts/account-8890/conversionSources/conversionSource-8890";

    client.deleteConversionSource(name);

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
  public void deleteConversionSourceExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "accounts/account-8890/conversionSources/conversionSource-8890";
      client.deleteConversionSource(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void undeleteConversionSourceTest() throws Exception {
    ConversionSource expectedResponse =
        ConversionSource.newBuilder()
            .setName(ConversionSourceName.of("[ACCOUNT]", "[CONVERSION_SOURCE]").toString())
            .setExpireTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    UndeleteConversionSourceRequest request =
        UndeleteConversionSourceRequest.newBuilder()
            .setName(ConversionSourceName.of("[ACCOUNT]", "[CONVERSION_SOURCE]").toString())
            .build();

    ConversionSource actualResponse = client.undeleteConversionSource(request);
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
  public void undeleteConversionSourceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      UndeleteConversionSourceRequest request =
          UndeleteConversionSourceRequest.newBuilder()
              .setName(ConversionSourceName.of("[ACCOUNT]", "[CONVERSION_SOURCE]").toString())
              .build();
      client.undeleteConversionSource(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getConversionSourceTest() throws Exception {
    ConversionSource expectedResponse =
        ConversionSource.newBuilder()
            .setName(ConversionSourceName.of("[ACCOUNT]", "[CONVERSION_SOURCE]").toString())
            .setExpireTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    ConversionSourceName name = ConversionSourceName.of("[ACCOUNT]", "[CONVERSION_SOURCE]");

    ConversionSource actualResponse = client.getConversionSource(name);
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
  public void getConversionSourceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ConversionSourceName name = ConversionSourceName.of("[ACCOUNT]", "[CONVERSION_SOURCE]");
      client.getConversionSource(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getConversionSourceTest2() throws Exception {
    ConversionSource expectedResponse =
        ConversionSource.newBuilder()
            .setName(ConversionSourceName.of("[ACCOUNT]", "[CONVERSION_SOURCE]").toString())
            .setExpireTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "accounts/account-8890/conversionSources/conversionSource-8890";

    ConversionSource actualResponse = client.getConversionSource(name);
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
  public void getConversionSourceExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "accounts/account-8890/conversionSources/conversionSource-8890";
      client.getConversionSource(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listConversionSourcesTest() throws Exception {
    ConversionSource responsesElement = ConversionSource.newBuilder().build();
    ListConversionSourcesResponse expectedResponse =
        ListConversionSourcesResponse.newBuilder()
            .setNextPageToken("")
            .addAllConversionSources(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    AccountName parent = AccountName.of("[ACCOUNT]");

    ListConversionSourcesPagedResponse pagedListResponse = client.listConversionSources(parent);

    List<ConversionSource> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getConversionSourcesList().get(0), resources.get(0));

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
  public void listConversionSourcesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AccountName parent = AccountName.of("[ACCOUNT]");
      client.listConversionSources(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listConversionSourcesTest2() throws Exception {
    ConversionSource responsesElement = ConversionSource.newBuilder().build();
    ListConversionSourcesResponse expectedResponse =
        ListConversionSourcesResponse.newBuilder()
            .setNextPageToken("")
            .addAllConversionSources(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "accounts/account-4811";

    ListConversionSourcesPagedResponse pagedListResponse = client.listConversionSources(parent);

    List<ConversionSource> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getConversionSourcesList().get(0), resources.get(0));

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
  public void listConversionSourcesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "accounts/account-4811";
      client.listConversionSources(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
