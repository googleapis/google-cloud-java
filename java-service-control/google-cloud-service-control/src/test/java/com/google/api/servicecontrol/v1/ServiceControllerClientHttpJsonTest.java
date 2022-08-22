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
import com.google.api.servicecontrol.v1.stub.HttpJsonServiceControllerStub;
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
public class ServiceControllerClientHttpJsonTest {
  private static MockHttpService mockService;
  private static ServiceControllerClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonServiceControllerStub.getMethodDescriptors(),
            ServiceControllerSettings.getDefaultEndpoint());
    ServiceControllerSettings settings =
        ServiceControllerSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                ServiceControllerSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ServiceControllerClient.create(settings);
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
  public void checkTest() throws Exception {
    CheckResponse expectedResponse =
        CheckResponse.newBuilder()
            .setOperationId("operationId129704162")
            .addAllCheckErrors(new ArrayList<CheckError>())
            .setServiceConfigId("serviceConfigId650537426")
            .setServiceRolloutId("serviceRolloutId47544183")
            .setCheckInfo(CheckResponse.CheckInfo.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    CheckRequest request =
        CheckRequest.newBuilder()
            .setServiceName("serviceName-4234")
            .setOperation(Operation.newBuilder().build())
            .setServiceConfigId("serviceConfigId650537426")
            .build();

    CheckResponse actualResponse = client.check(request);
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
  public void checkExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CheckRequest request =
          CheckRequest.newBuilder()
              .setServiceName("serviceName-4234")
              .setOperation(Operation.newBuilder().build())
              .setServiceConfigId("serviceConfigId650537426")
              .build();
      client.check(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void reportTest() throws Exception {
    ReportResponse expectedResponse =
        ReportResponse.newBuilder()
            .addAllReportErrors(new ArrayList<ReportResponse.ReportError>())
            .setServiceConfigId("serviceConfigId650537426")
            .setServiceRolloutId("serviceRolloutId47544183")
            .build();
    mockService.addResponse(expectedResponse);

    ReportRequest request =
        ReportRequest.newBuilder()
            .setServiceName("serviceName-4234")
            .addAllOperations(new ArrayList<Operation>())
            .setServiceConfigId("serviceConfigId650537426")
            .build();

    ReportResponse actualResponse = client.report(request);
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
  public void reportExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ReportRequest request =
          ReportRequest.newBuilder()
              .setServiceName("serviceName-4234")
              .addAllOperations(new ArrayList<Operation>())
              .setServiceConfigId("serviceConfigId650537426")
              .build();
      client.report(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
