/*
 * Copyright 2025 Google LLC
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
import com.google.shopping.merchant.accounts.v1beta.stub.HttpJsonAutomaticImprovementsServiceStub;
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
public class AutomaticImprovementsServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static AutomaticImprovementsServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonAutomaticImprovementsServiceStub.getMethodDescriptors(),
            AutomaticImprovementsServiceSettings.getDefaultEndpoint());
    AutomaticImprovementsServiceSettings settings =
        AutomaticImprovementsServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                AutomaticImprovementsServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = AutomaticImprovementsServiceClient.create(settings);
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
  public void getAutomaticImprovementsTest() throws Exception {
    AutomaticImprovements expectedResponse =
        AutomaticImprovements.newBuilder()
            .setName(AutomaticImprovementsName.of("[ACCOUNT]").toString())
            .setItemUpdates(AutomaticItemUpdates.newBuilder().build())
            .setImageImprovements(AutomaticImageImprovements.newBuilder().build())
            .setShippingImprovements(AutomaticShippingImprovements.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    AutomaticImprovementsName name = AutomaticImprovementsName.of("[ACCOUNT]");

    AutomaticImprovements actualResponse = client.getAutomaticImprovements(name);
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
  public void getAutomaticImprovementsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AutomaticImprovementsName name = AutomaticImprovementsName.of("[ACCOUNT]");
      client.getAutomaticImprovements(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAutomaticImprovementsTest2() throws Exception {
    AutomaticImprovements expectedResponse =
        AutomaticImprovements.newBuilder()
            .setName(AutomaticImprovementsName.of("[ACCOUNT]").toString())
            .setItemUpdates(AutomaticItemUpdates.newBuilder().build())
            .setImageImprovements(AutomaticImageImprovements.newBuilder().build())
            .setShippingImprovements(AutomaticShippingImprovements.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "accounts/account-2955/automaticImprovements";

    AutomaticImprovements actualResponse = client.getAutomaticImprovements(name);
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
  public void getAutomaticImprovementsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "accounts/account-2955/automaticImprovements";
      client.getAutomaticImprovements(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateAutomaticImprovementsTest() throws Exception {
    AutomaticImprovements expectedResponse =
        AutomaticImprovements.newBuilder()
            .setName(AutomaticImprovementsName.of("[ACCOUNT]").toString())
            .setItemUpdates(AutomaticItemUpdates.newBuilder().build())
            .setImageImprovements(AutomaticImageImprovements.newBuilder().build())
            .setShippingImprovements(AutomaticShippingImprovements.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    AutomaticImprovements automaticImprovements =
        AutomaticImprovements.newBuilder()
            .setName(AutomaticImprovementsName.of("[ACCOUNT]").toString())
            .setItemUpdates(AutomaticItemUpdates.newBuilder().build())
            .setImageImprovements(AutomaticImageImprovements.newBuilder().build())
            .setShippingImprovements(AutomaticShippingImprovements.newBuilder().build())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    AutomaticImprovements actualResponse =
        client.updateAutomaticImprovements(automaticImprovements, updateMask);
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
  public void updateAutomaticImprovementsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AutomaticImprovements automaticImprovements =
          AutomaticImprovements.newBuilder()
              .setName(AutomaticImprovementsName.of("[ACCOUNT]").toString())
              .setItemUpdates(AutomaticItemUpdates.newBuilder().build())
              .setImageImprovements(AutomaticImageImprovements.newBuilder().build())
              .setShippingImprovements(AutomaticShippingImprovements.newBuilder().build())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateAutomaticImprovements(automaticImprovements, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
