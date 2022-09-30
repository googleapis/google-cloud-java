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

package com.google.appengine.v1;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.appengine.v1.stub.HttpJsonApplicationsStub;
import com.google.longrunning.Operation;
import com.google.protobuf.Any;
import com.google.protobuf.Duration;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class ApplicationsClientHttpJsonTest {
  private static MockHttpService mockService;
  private static ApplicationsClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonApplicationsStub.getMethodDescriptors(),
            ApplicationsSettings.getDefaultEndpoint());
    ApplicationsSettings settings =
        ApplicationsSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                ApplicationsSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ApplicationsClient.create(settings);
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
  public void getApplicationTest() throws Exception {
    Application expectedResponse =
        Application.newBuilder()
            .setName("name3373707")
            .setId("id3355")
            .addAllDispatchRules(new ArrayList<UrlDispatchRule>())
            .setAuthDomain("authDomain1560526988")
            .setLocationId("locationId1541836720")
            .setCodeBucket("codeBucket-1407386057")
            .setDefaultCookieExpiration(Duration.newBuilder().build())
            .setDefaultHostname("defaultHostname1698284948")
            .setDefaultBucket("defaultBucket487561099")
            .setServiceAccount("serviceAccount1079137720")
            .setIap(Application.IdentityAwareProxy.newBuilder().build())
            .setGcrDomain("gcrDomain-595843206")
            .setFeatureSettings(Application.FeatureSettings.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "apps/app-5480";

    Application actualResponse = client.getApplication(name);
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
  public void getApplicationExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "apps/app-5480";
      client.getApplication(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createApplicationTest() throws Exception {
    Application expectedResponse =
        Application.newBuilder()
            .setName("name3373707")
            .setId("id3355")
            .addAllDispatchRules(new ArrayList<UrlDispatchRule>())
            .setAuthDomain("authDomain1560526988")
            .setLocationId("locationId1541836720")
            .setCodeBucket("codeBucket-1407386057")
            .setDefaultCookieExpiration(Duration.newBuilder().build())
            .setDefaultHostname("defaultHostname1698284948")
            .setDefaultBucket("defaultBucket487561099")
            .setServiceAccount("serviceAccount1079137720")
            .setIap(Application.IdentityAwareProxy.newBuilder().build())
            .setGcrDomain("gcrDomain-595843206")
            .setFeatureSettings(Application.FeatureSettings.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createApplicationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    CreateApplicationRequest request =
        CreateApplicationRequest.newBuilder()
            .setApplication(Application.newBuilder().build())
            .build();

    Application actualResponse = client.createApplicationAsync(request).get();
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
  public void createApplicationExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CreateApplicationRequest request =
          CreateApplicationRequest.newBuilder()
              .setApplication(Application.newBuilder().build())
              .build();
      client.createApplicationAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void updateApplicationTest() throws Exception {
    Application expectedResponse =
        Application.newBuilder()
            .setName("name3373707")
            .setId("id3355")
            .addAllDispatchRules(new ArrayList<UrlDispatchRule>())
            .setAuthDomain("authDomain1560526988")
            .setLocationId("locationId1541836720")
            .setCodeBucket("codeBucket-1407386057")
            .setDefaultCookieExpiration(Duration.newBuilder().build())
            .setDefaultHostname("defaultHostname1698284948")
            .setDefaultBucket("defaultBucket487561099")
            .setServiceAccount("serviceAccount1079137720")
            .setIap(Application.IdentityAwareProxy.newBuilder().build())
            .setGcrDomain("gcrDomain-595843206")
            .setFeatureSettings(Application.FeatureSettings.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateApplicationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    UpdateApplicationRequest request =
        UpdateApplicationRequest.newBuilder()
            .setName("apps/app-5480")
            .setApplication(Application.newBuilder().build())
            .setUpdateMask(FieldMask.newBuilder().build())
            .build();

    Application actualResponse = client.updateApplicationAsync(request).get();
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
  public void updateApplicationExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      UpdateApplicationRequest request =
          UpdateApplicationRequest.newBuilder()
              .setName("apps/app-5480")
              .setApplication(Application.newBuilder().build())
              .setUpdateMask(FieldMask.newBuilder().build())
              .build();
      client.updateApplicationAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void repairApplicationTest() throws Exception {
    Application expectedResponse =
        Application.newBuilder()
            .setName("name3373707")
            .setId("id3355")
            .addAllDispatchRules(new ArrayList<UrlDispatchRule>())
            .setAuthDomain("authDomain1560526988")
            .setLocationId("locationId1541836720")
            .setCodeBucket("codeBucket-1407386057")
            .setDefaultCookieExpiration(Duration.newBuilder().build())
            .setDefaultHostname("defaultHostname1698284948")
            .setDefaultBucket("defaultBucket487561099")
            .setServiceAccount("serviceAccount1079137720")
            .setIap(Application.IdentityAwareProxy.newBuilder().build())
            .setGcrDomain("gcrDomain-595843206")
            .setFeatureSettings(Application.FeatureSettings.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("repairApplicationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    RepairApplicationRequest request =
        RepairApplicationRequest.newBuilder().setName("apps/app-5480").build();

    Application actualResponse = client.repairApplicationAsync(request).get();
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
  public void repairApplicationExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      RepairApplicationRequest request =
          RepairApplicationRequest.newBuilder().setName("apps/app-5480").build();
      client.repairApplicationAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }
}
