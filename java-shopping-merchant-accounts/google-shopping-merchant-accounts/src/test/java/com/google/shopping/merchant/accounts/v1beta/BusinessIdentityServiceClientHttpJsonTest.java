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
import com.google.shopping.merchant.accounts.v1beta.stub.HttpJsonBusinessIdentityServiceStub;
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
public class BusinessIdentityServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static BusinessIdentityServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonBusinessIdentityServiceStub.getMethodDescriptors(),
            BusinessIdentityServiceSettings.getDefaultEndpoint());
    BusinessIdentityServiceSettings settings =
        BusinessIdentityServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                BusinessIdentityServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = BusinessIdentityServiceClient.create(settings);
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
  public void getBusinessIdentityTest() throws Exception {
    BusinessIdentity expectedResponse =
        BusinessIdentity.newBuilder()
            .setName(BusinessIdentityName.of("[ACCOUNT]").toString())
            .setBlackOwned(BusinessIdentity.IdentityAttribute.newBuilder().build())
            .setWomenOwned(BusinessIdentity.IdentityAttribute.newBuilder().build())
            .setVeteranOwned(BusinessIdentity.IdentityAttribute.newBuilder().build())
            .setLatinoOwned(BusinessIdentity.IdentityAttribute.newBuilder().build())
            .setSmallBusiness(BusinessIdentity.IdentityAttribute.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    BusinessIdentityName name = BusinessIdentityName.of("[ACCOUNT]");

    BusinessIdentity actualResponse = client.getBusinessIdentity(name);
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
  public void getBusinessIdentityExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      BusinessIdentityName name = BusinessIdentityName.of("[ACCOUNT]");
      client.getBusinessIdentity(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getBusinessIdentityTest2() throws Exception {
    BusinessIdentity expectedResponse =
        BusinessIdentity.newBuilder()
            .setName(BusinessIdentityName.of("[ACCOUNT]").toString())
            .setBlackOwned(BusinessIdentity.IdentityAttribute.newBuilder().build())
            .setWomenOwned(BusinessIdentity.IdentityAttribute.newBuilder().build())
            .setVeteranOwned(BusinessIdentity.IdentityAttribute.newBuilder().build())
            .setLatinoOwned(BusinessIdentity.IdentityAttribute.newBuilder().build())
            .setSmallBusiness(BusinessIdentity.IdentityAttribute.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "accounts/account-2369/businessIdentity";

    BusinessIdentity actualResponse = client.getBusinessIdentity(name);
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
  public void getBusinessIdentityExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "accounts/account-2369/businessIdentity";
      client.getBusinessIdentity(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateBusinessIdentityTest() throws Exception {
    BusinessIdentity expectedResponse =
        BusinessIdentity.newBuilder()
            .setName(BusinessIdentityName.of("[ACCOUNT]").toString())
            .setBlackOwned(BusinessIdentity.IdentityAttribute.newBuilder().build())
            .setWomenOwned(BusinessIdentity.IdentityAttribute.newBuilder().build())
            .setVeteranOwned(BusinessIdentity.IdentityAttribute.newBuilder().build())
            .setLatinoOwned(BusinessIdentity.IdentityAttribute.newBuilder().build())
            .setSmallBusiness(BusinessIdentity.IdentityAttribute.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    BusinessIdentity businessIdentity =
        BusinessIdentity.newBuilder()
            .setName(BusinessIdentityName.of("[ACCOUNT]").toString())
            .setBlackOwned(BusinessIdentity.IdentityAttribute.newBuilder().build())
            .setWomenOwned(BusinessIdentity.IdentityAttribute.newBuilder().build())
            .setVeteranOwned(BusinessIdentity.IdentityAttribute.newBuilder().build())
            .setLatinoOwned(BusinessIdentity.IdentityAttribute.newBuilder().build())
            .setSmallBusiness(BusinessIdentity.IdentityAttribute.newBuilder().build())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    BusinessIdentity actualResponse = client.updateBusinessIdentity(businessIdentity, updateMask);
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
  public void updateBusinessIdentityExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      BusinessIdentity businessIdentity =
          BusinessIdentity.newBuilder()
              .setName(BusinessIdentityName.of("[ACCOUNT]").toString())
              .setBlackOwned(BusinessIdentity.IdentityAttribute.newBuilder().build())
              .setWomenOwned(BusinessIdentity.IdentityAttribute.newBuilder().build())
              .setVeteranOwned(BusinessIdentity.IdentityAttribute.newBuilder().build())
              .setLatinoOwned(BusinessIdentity.IdentityAttribute.newBuilder().build())
              .setSmallBusiness(BusinessIdentity.IdentityAttribute.newBuilder().build())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateBusinessIdentity(businessIdentity, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
