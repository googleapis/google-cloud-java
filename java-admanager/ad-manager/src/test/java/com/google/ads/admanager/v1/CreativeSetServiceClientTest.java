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

import static com.google.ads.admanager.v1.CreativeSetServiceClient.ListCreativeSetsPagedResponse;

import com.google.ads.admanager.v1.stub.HttpJsonCreativeSetServiceStub;
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
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
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
public class CreativeSetServiceClientTest {
  private static MockHttpService mockService;
  private static CreativeSetServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonCreativeSetServiceStub.getMethodDescriptors(),
            CreativeSetServiceSettings.getDefaultEndpoint());
    CreativeSetServiceSettings settings =
        CreativeSetServiceSettings.newBuilder()
            .setTransportChannelProvider(
                CreativeSetServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = CreativeSetServiceClient.create(settings);
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
  public void getCreativeSetTest() throws Exception {
    CreativeSet expectedResponse =
        CreativeSet.newBuilder()
            .setName(CreativeSetName.of("[NETWORK_CODE]", "[CREATIVE_SET]").toString())
            .setDisplayName("displayName1714148973")
            .setMasterCreative("masterCreative1330740273")
            .addAllCompanionCreatives(new ArrayList<String>())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    CreativeSetName name = CreativeSetName.of("[NETWORK_CODE]", "[CREATIVE_SET]");

    CreativeSet actualResponse = client.getCreativeSet(name);
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
  public void getCreativeSetExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CreativeSetName name = CreativeSetName.of("[NETWORK_CODE]", "[CREATIVE_SET]");
      client.getCreativeSet(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getCreativeSetTest2() throws Exception {
    CreativeSet expectedResponse =
        CreativeSet.newBuilder()
            .setName(CreativeSetName.of("[NETWORK_CODE]", "[CREATIVE_SET]").toString())
            .setDisplayName("displayName1714148973")
            .setMasterCreative("masterCreative1330740273")
            .addAllCompanionCreatives(new ArrayList<String>())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "networks/network-17/creativeSets/creativeSet-17";

    CreativeSet actualResponse = client.getCreativeSet(name);
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
  public void getCreativeSetExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "networks/network-17/creativeSets/creativeSet-17";
      client.getCreativeSet(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listCreativeSetsTest() throws Exception {
    CreativeSet responsesElement = CreativeSet.newBuilder().build();
    ListCreativeSetsResponse expectedResponse =
        ListCreativeSetsResponse.newBuilder()
            .setNextPageToken("")
            .addAllCreativeSets(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");

    ListCreativeSetsPagedResponse pagedListResponse = client.listCreativeSets(parent);

    List<CreativeSet> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCreativeSetsList().get(0), resources.get(0));

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
  public void listCreativeSetsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      client.listCreativeSets(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listCreativeSetsTest2() throws Exception {
    CreativeSet responsesElement = CreativeSet.newBuilder().build();
    ListCreativeSetsResponse expectedResponse =
        ListCreativeSetsResponse.newBuilder()
            .setNextPageToken("")
            .addAllCreativeSets(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";

    ListCreativeSetsPagedResponse pagedListResponse = client.listCreativeSets(parent);

    List<CreativeSet> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCreativeSetsList().get(0), resources.get(0));

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
  public void listCreativeSetsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      client.listCreativeSets(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createCreativeSetTest() throws Exception {
    CreativeSet expectedResponse =
        CreativeSet.newBuilder()
            .setName(CreativeSetName.of("[NETWORK_CODE]", "[CREATIVE_SET]").toString())
            .setDisplayName("displayName1714148973")
            .setMasterCreative("masterCreative1330740273")
            .addAllCompanionCreatives(new ArrayList<String>())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");
    CreativeSet creativeSet = CreativeSet.newBuilder().build();

    CreativeSet actualResponse = client.createCreativeSet(parent, creativeSet);
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
  public void createCreativeSetExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      CreativeSet creativeSet = CreativeSet.newBuilder().build();
      client.createCreativeSet(parent, creativeSet);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createCreativeSetTest2() throws Exception {
    CreativeSet expectedResponse =
        CreativeSet.newBuilder()
            .setName(CreativeSetName.of("[NETWORK_CODE]", "[CREATIVE_SET]").toString())
            .setDisplayName("displayName1714148973")
            .setMasterCreative("masterCreative1330740273")
            .addAllCompanionCreatives(new ArrayList<String>())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";
    CreativeSet creativeSet = CreativeSet.newBuilder().build();

    CreativeSet actualResponse = client.createCreativeSet(parent, creativeSet);
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
  public void createCreativeSetExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      CreativeSet creativeSet = CreativeSet.newBuilder().build();
      client.createCreativeSet(parent, creativeSet);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateCreativeSetTest() throws Exception {
    CreativeSet expectedResponse =
        CreativeSet.newBuilder()
            .setName(CreativeSetName.of("[NETWORK_CODE]", "[CREATIVE_SET]").toString())
            .setDisplayName("displayName1714148973")
            .setMasterCreative("masterCreative1330740273")
            .addAllCompanionCreatives(new ArrayList<String>())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    CreativeSet creativeSet =
        CreativeSet.newBuilder()
            .setName(CreativeSetName.of("[NETWORK_CODE]", "[CREATIVE_SET]").toString())
            .setDisplayName("displayName1714148973")
            .setMasterCreative("masterCreative1330740273")
            .addAllCompanionCreatives(new ArrayList<String>())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    CreativeSet actualResponse = client.updateCreativeSet(creativeSet, updateMask);
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
  public void updateCreativeSetExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CreativeSet creativeSet =
          CreativeSet.newBuilder()
              .setName(CreativeSetName.of("[NETWORK_CODE]", "[CREATIVE_SET]").toString())
              .setDisplayName("displayName1714148973")
              .setMasterCreative("masterCreative1330740273")
              .addAllCompanionCreatives(new ArrayList<String>())
              .setUpdateTime(Timestamp.newBuilder().build())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateCreativeSet(creativeSet, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
