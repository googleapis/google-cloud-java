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

import static com.google.appengine.v1.InstancesClient.ListInstancesPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.appengine.v1.stub.HttpJsonInstancesStub;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.util.Arrays;
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
public class InstancesClientHttpJsonTest {
  private static MockHttpService mockService;
  private static InstancesClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonInstancesStub.getMethodDescriptors(), InstancesSettings.getDefaultEndpoint());
    InstancesSettings settings =
        InstancesSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                InstancesSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = InstancesClient.create(settings);
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
  public void listInstancesTest() throws Exception {
    Instance responsesElement = Instance.newBuilder().build();
    ListInstancesResponse expectedResponse =
        ListInstancesResponse.newBuilder()
            .setNextPageToken("")
            .addAllInstances(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    ListInstancesRequest request =
        ListInstancesRequest.newBuilder()
            .setParent("apps/app-8780/services/service-8780/versions/version-8780")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    ListInstancesPagedResponse pagedListResponse = client.listInstances(request);

    List<Instance> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getInstancesList().get(0), resources.get(0));

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
  public void listInstancesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ListInstancesRequest request =
          ListInstancesRequest.newBuilder()
              .setParent("apps/app-8780/services/service-8780/versions/version-8780")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      client.listInstances(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getInstanceTest() throws Exception {
    Instance expectedResponse =
        Instance.newBuilder()
            .setName("name3373707")
            .setId("id3355")
            .setAppEngineRelease("appEngineRelease-1601369404")
            .setVmName("vmName-813643294")
            .setVmZoneName("vmZoneName-245094354")
            .setVmId("vmId3622450")
            .setStartTime(Timestamp.newBuilder().build())
            .setRequests(-393257020)
            .setErrors(-1294635157)
            .setQps(112180)
            .setAverageLatency(1814586588)
            .setMemoryUsage(1034557667)
            .setVmStatus("vmStatus-66804343")
            .setVmDebugEnabled(true)
            .setVmIp("vmIp3622462")
            .build();
    mockService.addResponse(expectedResponse);

    GetInstanceRequest request =
        GetInstanceRequest.newBuilder()
            .setName(
                "apps/app-9649/services/service-9649/versions/version-9649/instances/instance-9649")
            .build();

    Instance actualResponse = client.getInstance(request);
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
  public void getInstanceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GetInstanceRequest request =
          GetInstanceRequest.newBuilder()
              .setName(
                  "apps/app-9649/services/service-9649/versions/version-9649/instances/instance-9649")
              .build();
      client.getInstance(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteInstanceTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteInstanceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    DeleteInstanceRequest request =
        DeleteInstanceRequest.newBuilder()
            .setName(
                "apps/app-9649/services/service-9649/versions/version-9649/instances/instance-9649")
            .build();

    client.deleteInstanceAsync(request).get();

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
  public void deleteInstanceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DeleteInstanceRequest request =
          DeleteInstanceRequest.newBuilder()
              .setName(
                  "apps/app-9649/services/service-9649/versions/version-9649/instances/instance-9649")
              .build();
      client.deleteInstanceAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void debugInstanceTest() throws Exception {
    Instance expectedResponse =
        Instance.newBuilder()
            .setName("name3373707")
            .setId("id3355")
            .setAppEngineRelease("appEngineRelease-1601369404")
            .setVmName("vmName-813643294")
            .setVmZoneName("vmZoneName-245094354")
            .setVmId("vmId3622450")
            .setStartTime(Timestamp.newBuilder().build())
            .setRequests(-393257020)
            .setErrors(-1294635157)
            .setQps(112180)
            .setAverageLatency(1814586588)
            .setMemoryUsage(1034557667)
            .setVmStatus("vmStatus-66804343")
            .setVmDebugEnabled(true)
            .setVmIp("vmIp3622462")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("debugInstanceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    DebugInstanceRequest request =
        DebugInstanceRequest.newBuilder()
            .setName(
                "apps/app-9649/services/service-9649/versions/version-9649/instances/instance-9649")
            .setSshKey("sshKey-893236425")
            .build();

    Instance actualResponse = client.debugInstanceAsync(request).get();
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
  public void debugInstanceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DebugInstanceRequest request =
          DebugInstanceRequest.newBuilder()
              .setName(
                  "apps/app-9649/services/service-9649/versions/version-9649/instances/instance-9649")
              .setSshKey("sshKey-893236425")
              .build();
      client.debugInstanceAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }
}
