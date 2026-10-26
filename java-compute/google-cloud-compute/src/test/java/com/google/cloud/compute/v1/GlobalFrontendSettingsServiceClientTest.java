/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.compute.v1;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.compute.v1.stub.HttpJsonGlobalFrontendSettingsServiceStub;
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
public class GlobalFrontendSettingsServiceClientTest {
  private static MockHttpService mockService;
  private static GlobalFrontendSettingsServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonGlobalFrontendSettingsServiceStub.getMethodDescriptors(),
            GlobalFrontendSettingsServiceSettings.getDefaultEndpoint());
    GlobalFrontendSettingsServiceSettings settings =
        GlobalFrontendSettingsServiceSettings.newBuilder()
            .setTransportChannelProvider(
                GlobalFrontendSettingsServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = GlobalFrontendSettingsServiceClient.create(settings);
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
  public void getTest() throws Exception {
    GlobalFrontendSettings expectedResponse =
        GlobalFrontendSettings.newBuilder()
            .setBundleType("bundleType1377247964")
            .setCreationTimestamp("creationTimestamp-370203401")
            .setDescription("description-1724546052")
            .setEtag("etag3123477")
            .setId(3355)
            .setName("name3373707")
            .setSelfLink("selfLink1191800166")
            .build();
    mockService.addResponse(expectedResponse);

    String project = "project-6911";

    GlobalFrontendSettings actualResponse = client.get(project);
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
  public void getExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String project = "project-6911";
      client.get(project);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void patchTest() throws Exception {
    GlobalFrontendSettingsPatchResponse expectedResponse =
        GlobalFrontendSettingsPatchResponse.newBuilder()
            .setOperation(Operation.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String project = "project-6911";
    GlobalFrontendSettings globalFrontendSettingsResource =
        GlobalFrontendSettings.newBuilder().build();

    GlobalFrontendSettingsPatchResponse actualResponse =
        client.patch(project, globalFrontendSettingsResource);
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
  public void patchExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String project = "project-6911";
      GlobalFrontendSettings globalFrontendSettingsResource =
          GlobalFrontendSettings.newBuilder().build();
      client.patch(project, globalFrontendSettingsResource);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
