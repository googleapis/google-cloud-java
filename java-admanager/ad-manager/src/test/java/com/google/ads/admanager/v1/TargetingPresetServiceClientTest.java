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

package com.google.ads.admanager.v1;

import static com.google.ads.admanager.v1.TargetingPresetServiceClient.ListTargetingPresetsPagedResponse;

import com.google.ads.admanager.v1.stub.HttpJsonTargetingPresetServiceStub;
import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class TargetingPresetServiceClientTest {
  private static MockHttpService mockService;
  private static TargetingPresetServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonTargetingPresetServiceStub.getMethodDescriptors(),
            TargetingPresetServiceSettings.getDefaultEndpoint());
    TargetingPresetServiceSettings settings =
        TargetingPresetServiceSettings.newBuilder()
            .setTransportChannelProvider(
                TargetingPresetServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = TargetingPresetServiceClient.create(settings);
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
  public void getTargetingPresetTest() throws Exception {
    TargetingPreset expectedResponse =
        TargetingPreset.newBuilder()
            .setName(TargetingPresetName.of("[NETWORK_CODE]", "[TARGETING_PRESET]").toString())
            .setDisplayName("displayName1714148973")
            .setTargeting(Targeting.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    TargetingPresetName name = TargetingPresetName.of("[NETWORK_CODE]", "[TARGETING_PRESET]");

    TargetingPreset actualResponse = client.getTargetingPreset(name);
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
  public void getTargetingPresetExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      TargetingPresetName name = TargetingPresetName.of("[NETWORK_CODE]", "[TARGETING_PRESET]");
      client.getTargetingPreset(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getTargetingPresetTest2() throws Exception {
    TargetingPreset expectedResponse =
        TargetingPreset.newBuilder()
            .setName(TargetingPresetName.of("[NETWORK_CODE]", "[TARGETING_PRESET]").toString())
            .setDisplayName("displayName1714148973")
            .setTargeting(Targeting.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "networks/network-1166/targetingPresets/targetingPreset-1166";

    TargetingPreset actualResponse = client.getTargetingPreset(name);
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
  public void getTargetingPresetExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "networks/network-1166/targetingPresets/targetingPreset-1166";
      client.getTargetingPreset(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listTargetingPresetsTest() throws Exception {
    TargetingPreset responsesElement = TargetingPreset.newBuilder().build();
    ListTargetingPresetsResponse expectedResponse =
        ListTargetingPresetsResponse.newBuilder()
            .setNextPageToken("")
            .addAllTargetingPresets(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");

    ListTargetingPresetsPagedResponse pagedListResponse = client.listTargetingPresets(parent);

    List<TargetingPreset> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTargetingPresetsList().get(0), resources.get(0));

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
  public void listTargetingPresetsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      client.listTargetingPresets(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listTargetingPresetsTest2() throws Exception {
    TargetingPreset responsesElement = TargetingPreset.newBuilder().build();
    ListTargetingPresetsResponse expectedResponse =
        ListTargetingPresetsResponse.newBuilder()
            .setNextPageToken("")
            .addAllTargetingPresets(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";

    ListTargetingPresetsPagedResponse pagedListResponse = client.listTargetingPresets(parent);

    List<TargetingPreset> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTargetingPresetsList().get(0), resources.get(0));

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
  public void listTargetingPresetsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      client.listTargetingPresets(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createTargetingPresetTest() throws Exception {
    TargetingPreset expectedResponse =
        TargetingPreset.newBuilder()
            .setName(TargetingPresetName.of("[NETWORK_CODE]", "[TARGETING_PRESET]").toString())
            .setDisplayName("displayName1714148973")
            .setTargeting(Targeting.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");
    TargetingPreset targetingPreset = TargetingPreset.newBuilder().build();

    TargetingPreset actualResponse = client.createTargetingPreset(parent, targetingPreset);
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
  public void createTargetingPresetExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      TargetingPreset targetingPreset = TargetingPreset.newBuilder().build();
      client.createTargetingPreset(parent, targetingPreset);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createTargetingPresetTest2() throws Exception {
    TargetingPreset expectedResponse =
        TargetingPreset.newBuilder()
            .setName(TargetingPresetName.of("[NETWORK_CODE]", "[TARGETING_PRESET]").toString())
            .setDisplayName("displayName1714148973")
            .setTargeting(Targeting.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";
    TargetingPreset targetingPreset = TargetingPreset.newBuilder().build();

    TargetingPreset actualResponse = client.createTargetingPreset(parent, targetingPreset);
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
  public void createTargetingPresetExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      TargetingPreset targetingPreset = TargetingPreset.newBuilder().build();
      client.createTargetingPreset(parent, targetingPreset);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchCreateTargetingPresetsTest() throws Exception {
    BatchCreateTargetingPresetsResponse expectedResponse =
        BatchCreateTargetingPresetsResponse.newBuilder()
            .addAllTargetingPresets(new ArrayList<TargetingPreset>())
            .build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");
    List<CreateTargetingPresetRequest> requests = new ArrayList<>();

    BatchCreateTargetingPresetsResponse actualResponse =
        client.batchCreateTargetingPresets(parent, requests);
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
  public void batchCreateTargetingPresetsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      List<CreateTargetingPresetRequest> requests = new ArrayList<>();
      client.batchCreateTargetingPresets(parent, requests);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchCreateTargetingPresetsTest2() throws Exception {
    BatchCreateTargetingPresetsResponse expectedResponse =
        BatchCreateTargetingPresetsResponse.newBuilder()
            .addAllTargetingPresets(new ArrayList<TargetingPreset>())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";
    List<CreateTargetingPresetRequest> requests = new ArrayList<>();

    BatchCreateTargetingPresetsResponse actualResponse =
        client.batchCreateTargetingPresets(parent, requests);
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
  public void batchCreateTargetingPresetsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      List<CreateTargetingPresetRequest> requests = new ArrayList<>();
      client.batchCreateTargetingPresets(parent, requests);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchDeactivateTargetingPresetsTest() throws Exception {
    BatchDeactivateTargetingPresetsResponse expectedResponse =
        BatchDeactivateTargetingPresetsResponse.newBuilder().setChangeCount(235488192).build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");
    List<DeactivateTargetingPresetRequest> requests = new ArrayList<>();

    BatchDeactivateTargetingPresetsResponse actualResponse =
        client.batchDeactivateTargetingPresets(parent, requests);
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
  public void batchDeactivateTargetingPresetsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      List<DeactivateTargetingPresetRequest> requests = new ArrayList<>();
      client.batchDeactivateTargetingPresets(parent, requests);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchDeactivateTargetingPresetsTest2() throws Exception {
    BatchDeactivateTargetingPresetsResponse expectedResponse =
        BatchDeactivateTargetingPresetsResponse.newBuilder().setChangeCount(235488192).build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";
    List<DeactivateTargetingPresetRequest> requests = new ArrayList<>();

    BatchDeactivateTargetingPresetsResponse actualResponse =
        client.batchDeactivateTargetingPresets(parent, requests);
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
  public void batchDeactivateTargetingPresetsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      List<DeactivateTargetingPresetRequest> requests = new ArrayList<>();
      client.batchDeactivateTargetingPresets(parent, requests);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
