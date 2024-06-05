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
import com.google.shopping.merchant.accounts.v1beta.stub.HttpJsonEmailPreferencesServiceStub;
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
public class EmailPreferencesServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static EmailPreferencesServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonEmailPreferencesServiceStub.getMethodDescriptors(),
            EmailPreferencesServiceSettings.getDefaultEndpoint());
    EmailPreferencesServiceSettings settings =
        EmailPreferencesServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                EmailPreferencesServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = EmailPreferencesServiceClient.create(settings);
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
  public void getEmailPreferencesTest() throws Exception {
    EmailPreferences expectedResponse =
        EmailPreferences.newBuilder()
            .setName(EmailPreferencesName.of("[ACCOUNT]", "[EMAIL]").toString())
            .build();
    mockService.addResponse(expectedResponse);

    EmailPreferencesName name = EmailPreferencesName.of("[ACCOUNT]", "[EMAIL]");

    EmailPreferences actualResponse = client.getEmailPreferences(name);
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
  public void getEmailPreferencesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      EmailPreferencesName name = EmailPreferencesName.of("[ACCOUNT]", "[EMAIL]");
      client.getEmailPreferences(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getEmailPreferencesTest2() throws Exception {
    EmailPreferences expectedResponse =
        EmailPreferences.newBuilder()
            .setName(EmailPreferencesName.of("[ACCOUNT]", "[EMAIL]").toString())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "accounts/account-8379/users/user-8379/emailPreferences";

    EmailPreferences actualResponse = client.getEmailPreferences(name);
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
  public void getEmailPreferencesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "accounts/account-8379/users/user-8379/emailPreferences";
      client.getEmailPreferences(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateEmailPreferencesTest() throws Exception {
    EmailPreferences expectedResponse =
        EmailPreferences.newBuilder()
            .setName(EmailPreferencesName.of("[ACCOUNT]", "[EMAIL]").toString())
            .build();
    mockService.addResponse(expectedResponse);

    EmailPreferences emailPreferences =
        EmailPreferences.newBuilder()
            .setName(EmailPreferencesName.of("[ACCOUNT]", "[EMAIL]").toString())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    EmailPreferences actualResponse = client.updateEmailPreferences(emailPreferences, updateMask);
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
  public void updateEmailPreferencesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      EmailPreferences emailPreferences =
          EmailPreferences.newBuilder()
              .setName(EmailPreferencesName.of("[ACCOUNT]", "[EMAIL]").toString())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateEmailPreferences(emailPreferences, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
