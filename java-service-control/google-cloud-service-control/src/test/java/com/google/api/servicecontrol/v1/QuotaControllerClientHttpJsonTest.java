/*
 * Copyright 2022 Google LLC
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

package com.google.api.servicecontrol.v1;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.api.servicecontrol.v1.stub.HttpJsonQuotaControllerStub;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class QuotaControllerClientHttpJsonTest {
  private static MockHttpService mockService;
  private static QuotaControllerClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonQuotaControllerStub.getMethodDescriptors(),
            QuotaControllerSettings.getDefaultEndpoint());
    QuotaControllerSettings settings =
        QuotaControllerSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                QuotaControllerSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = QuotaControllerClient.create(settings);
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
  public void allocateQuotaTest() throws Exception {
    AllocateQuotaResponse expectedResponse =
        AllocateQuotaResponse.newBuilder()
            .setOperationId("operationId129704162")
            .addAllAllocateErrors(new ArrayList<QuotaError>())
            .addAllQuotaMetrics(new ArrayList<MetricValueSet>())
            .setServiceConfigId("serviceConfigId650537426")
            .build();
    mockService.addResponse(expectedResponse);

    AllocateQuotaRequest request =
        AllocateQuotaRequest.newBuilder()
            .setServiceName("serviceName-4234")
            .setAllocateOperation(QuotaOperation.newBuilder().build())
            .setServiceConfigId("serviceConfigId650537426")
            .build();

    AllocateQuotaResponse actualResponse = client.allocateQuota(request);
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
  public void allocateQuotaExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AllocateQuotaRequest request =
          AllocateQuotaRequest.newBuilder()
              .setServiceName("serviceName-4234")
              .setAllocateOperation(QuotaOperation.newBuilder().build())
              .setServiceConfigId("serviceConfigId650537426")
              .build();
      client.allocateQuota(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
