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
import com.google.shopping.merchant.accounts.v1beta.stub.HttpJsonBusinessInfoServiceStub;
import com.google.type.PhoneNumber;
import com.google.type.PostalAddress;
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
public class BusinessInfoServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static BusinessInfoServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonBusinessInfoServiceStub.getMethodDescriptors(),
            BusinessInfoServiceSettings.getDefaultEndpoint());
    BusinessInfoServiceSettings settings =
        BusinessInfoServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                BusinessInfoServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = BusinessInfoServiceClient.create(settings);
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
  public void getBusinessInfoTest() throws Exception {
    BusinessInfo expectedResponse =
        BusinessInfo.newBuilder()
            .setName(BusinessInfoName.of("[ACCOUNT]").toString())
            .setAddress(PostalAddress.newBuilder().build())
            .setPhone(PhoneNumber.newBuilder().build())
            .setPhoneVerificationState(PhoneVerificationState.forNumber(0))
            .setCustomerService(CustomerService.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    BusinessInfoName name = BusinessInfoName.of("[ACCOUNT]");

    BusinessInfo actualResponse = client.getBusinessInfo(name);
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
  public void getBusinessInfoExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      BusinessInfoName name = BusinessInfoName.of("[ACCOUNT]");
      client.getBusinessInfo(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getBusinessInfoTest2() throws Exception {
    BusinessInfo expectedResponse =
        BusinessInfo.newBuilder()
            .setName(BusinessInfoName.of("[ACCOUNT]").toString())
            .setAddress(PostalAddress.newBuilder().build())
            .setPhone(PhoneNumber.newBuilder().build())
            .setPhoneVerificationState(PhoneVerificationState.forNumber(0))
            .setCustomerService(CustomerService.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "accounts/account-9377/businessInfo";

    BusinessInfo actualResponse = client.getBusinessInfo(name);
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
  public void getBusinessInfoExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "accounts/account-9377/businessInfo";
      client.getBusinessInfo(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateBusinessInfoTest() throws Exception {
    BusinessInfo expectedResponse =
        BusinessInfo.newBuilder()
            .setName(BusinessInfoName.of("[ACCOUNT]").toString())
            .setAddress(PostalAddress.newBuilder().build())
            .setPhone(PhoneNumber.newBuilder().build())
            .setPhoneVerificationState(PhoneVerificationState.forNumber(0))
            .setCustomerService(CustomerService.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    BusinessInfo businessInfo =
        BusinessInfo.newBuilder()
            .setName(BusinessInfoName.of("[ACCOUNT]").toString())
            .setAddress(PostalAddress.newBuilder().build())
            .setPhone(PhoneNumber.newBuilder().build())
            .setPhoneVerificationState(PhoneVerificationState.forNumber(0))
            .setCustomerService(CustomerService.newBuilder().build())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    BusinessInfo actualResponse = client.updateBusinessInfo(businessInfo, updateMask);
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
  public void updateBusinessInfoExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      BusinessInfo businessInfo =
          BusinessInfo.newBuilder()
              .setName(BusinessInfoName.of("[ACCOUNT]").toString())
              .setAddress(PostalAddress.newBuilder().build())
              .setPhone(PhoneNumber.newBuilder().build())
              .setPhoneVerificationState(PhoneVerificationState.forNumber(0))
              .setCustomerService(CustomerService.newBuilder().build())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateBusinessInfo(businessInfo, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
