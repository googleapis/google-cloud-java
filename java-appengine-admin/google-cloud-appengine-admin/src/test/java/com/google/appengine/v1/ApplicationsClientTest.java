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
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.protobuf.Duration;
import com.google.protobuf.FieldMask;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class ApplicationsClientTest {
  private static MockApplications mockApplications;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private ApplicationsClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockApplications = new MockApplications();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockApplications));
    mockServiceHelper.start();
  }

  @AfterClass
  public static void stopServer() {
    mockServiceHelper.stop();
  }

  @Before
  public void setUp() throws IOException {
    mockServiceHelper.reset();
    channelProvider = mockServiceHelper.createChannelProvider();
    ApplicationsSettings settings =
        ApplicationsSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ApplicationsClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
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
    mockApplications.addResponse(expectedResponse);

    String name = "name3373707";

    Application actualResponse = client.getApplication(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockApplications.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetApplicationRequest actualRequest = ((GetApplicationRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getApplicationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockApplications.addException(exception);

    try {
      String name = "name3373707";
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
    mockApplications.addResponse(resultOperation);

    CreateApplicationRequest request =
        CreateApplicationRequest.newBuilder()
            .setApplication(Application.newBuilder().build())
            .build();

    Application actualResponse = client.createApplicationAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockApplications.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateApplicationRequest actualRequest = ((CreateApplicationRequest) actualRequests.get(0));

    Assert.assertEquals(request.getApplication(), actualRequest.getApplication());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createApplicationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockApplications.addException(exception);

    try {
      CreateApplicationRequest request =
          CreateApplicationRequest.newBuilder()
              .setApplication(Application.newBuilder().build())
              .build();
      client.createApplicationAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockApplications.addResponse(resultOperation);

    UpdateApplicationRequest request =
        UpdateApplicationRequest.newBuilder()
            .setName("name3373707")
            .setApplication(Application.newBuilder().build())
            .setUpdateMask(FieldMask.newBuilder().build())
            .build();

    Application actualResponse = client.updateApplicationAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockApplications.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateApplicationRequest actualRequest = ((UpdateApplicationRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getApplication(), actualRequest.getApplication());
    Assert.assertEquals(request.getUpdateMask(), actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateApplicationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockApplications.addException(exception);

    try {
      UpdateApplicationRequest request =
          UpdateApplicationRequest.newBuilder()
              .setName("name3373707")
              .setApplication(Application.newBuilder().build())
              .setUpdateMask(FieldMask.newBuilder().build())
              .build();
      client.updateApplicationAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockApplications.addResponse(resultOperation);

    RepairApplicationRequest request =
        RepairApplicationRequest.newBuilder().setName("name3373707").build();

    Application actualResponse = client.repairApplicationAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockApplications.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RepairApplicationRequest actualRequest = ((RepairApplicationRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void repairApplicationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockApplications.addException(exception);

    try {
      RepairApplicationRequest request =
          RepairApplicationRequest.newBuilder().setName("name3373707").build();
      client.repairApplicationAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }
}
