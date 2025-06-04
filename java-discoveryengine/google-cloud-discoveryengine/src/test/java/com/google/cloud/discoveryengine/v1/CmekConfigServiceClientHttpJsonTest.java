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

package com.google.cloud.discoveryengine.v1;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.discoveryengine.v1.stub.HttpJsonCmekConfigServiceStub;
import com.google.longrunning.Operation;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
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
public class CmekConfigServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static CmekConfigServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonCmekConfigServiceStub.getMethodDescriptors(),
            CmekConfigServiceSettings.getDefaultEndpoint());
    CmekConfigServiceSettings settings =
        CmekConfigServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                CmekConfigServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = CmekConfigServiceClient.create(settings);
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
  public void updateCmekConfigTest() throws Exception {
    CmekConfig expectedResponse =
        CmekConfig.newBuilder()
            .setName(CmekConfigName.ofProjectLocationName("[PROJECT]", "[LOCATION]").toString())
            .setKmsKey("kmsKey-1127483058")
            .setKmsKeyVersion("kmsKeyVersion2084784042")
            .setIsDefault(true)
            .setLastRotationTimestampMicros(-1869978704)
            .addAllSingleRegionKeys(new ArrayList<SingleRegionKey>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateCmekConfigTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    CmekConfig config =
        CmekConfig.newBuilder()
            .setName(CmekConfigName.ofProjectLocationName("[PROJECT]", "[LOCATION]").toString())
            .setKmsKey("kmsKey-1127483058")
            .setKmsKeyVersion("kmsKeyVersion2084784042")
            .setIsDefault(true)
            .setLastRotationTimestampMicros(-1869978704)
            .addAllSingleRegionKeys(new ArrayList<SingleRegionKey>())
            .build();

    CmekConfig actualResponse = client.updateCmekConfigAsync(config).get();
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
  public void updateCmekConfigExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CmekConfig config =
          CmekConfig.newBuilder()
              .setName(CmekConfigName.ofProjectLocationName("[PROJECT]", "[LOCATION]").toString())
              .setKmsKey("kmsKey-1127483058")
              .setKmsKeyVersion("kmsKeyVersion2084784042")
              .setIsDefault(true)
              .setLastRotationTimestampMicros(-1869978704)
              .addAllSingleRegionKeys(new ArrayList<SingleRegionKey>())
              .build();
      client.updateCmekConfigAsync(config).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void getCmekConfigTest() throws Exception {
    CmekConfig expectedResponse =
        CmekConfig.newBuilder()
            .setName(CmekConfigName.ofProjectLocationName("[PROJECT]", "[LOCATION]").toString())
            .setKmsKey("kmsKey-1127483058")
            .setKmsKeyVersion("kmsKeyVersion2084784042")
            .setIsDefault(true)
            .setLastRotationTimestampMicros(-1869978704)
            .addAllSingleRegionKeys(new ArrayList<SingleRegionKey>())
            .build();
    mockService.addResponse(expectedResponse);

    CmekConfigName name = CmekConfigName.ofProjectLocationName("[PROJECT]", "[LOCATION]");

    CmekConfig actualResponse = client.getCmekConfig(name);
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
  public void getCmekConfigExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CmekConfigName name = CmekConfigName.ofProjectLocationName("[PROJECT]", "[LOCATION]");
      client.getCmekConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getCmekConfigTest2() throws Exception {
    CmekConfig expectedResponse =
        CmekConfig.newBuilder()
            .setName(CmekConfigName.ofProjectLocationName("[PROJECT]", "[LOCATION]").toString())
            .setKmsKey("kmsKey-1127483058")
            .setKmsKeyVersion("kmsKeyVersion2084784042")
            .setIsDefault(true)
            .setLastRotationTimestampMicros(-1869978704)
            .addAllSingleRegionKeys(new ArrayList<SingleRegionKey>())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-9943/locations/location-9943/cmekConfig";

    CmekConfig actualResponse = client.getCmekConfig(name);
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
  public void getCmekConfigExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-9943/locations/location-9943/cmekConfig";
      client.getCmekConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listCmekConfigsTest() throws Exception {
    ListCmekConfigsResponse expectedResponse =
        ListCmekConfigsResponse.newBuilder().addAllCmekConfigs(new ArrayList<CmekConfig>()).build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListCmekConfigsResponse actualResponse = client.listCmekConfigs(parent);
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
  public void listCmekConfigsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listCmekConfigs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listCmekConfigsTest2() throws Exception {
    ListCmekConfigsResponse expectedResponse =
        ListCmekConfigsResponse.newBuilder().addAllCmekConfigs(new ArrayList<CmekConfig>()).build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListCmekConfigsResponse actualResponse = client.listCmekConfigs(parent);
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
  public void listCmekConfigsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listCmekConfigs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteCmekConfigTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteCmekConfigTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    CmekConfigName name =
        CmekConfigName.ofProjectLocationCmekConfigName("[PROJECT]", "[LOCATION]", "[CMEK_CONFIG]");

    client.deleteCmekConfigAsync(name).get();

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
  public void deleteCmekConfigExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CmekConfigName name =
          CmekConfigName.ofProjectLocationCmekConfigName(
              "[PROJECT]", "[LOCATION]", "[CMEK_CONFIG]");
      client.deleteCmekConfigAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteCmekConfigTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteCmekConfigTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name = "projects/project-1207/locations/location-1207/cmekConfigs/cmekConfig-1207";

    client.deleteCmekConfigAsync(name).get();

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
  public void deleteCmekConfigExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-1207/locations/location-1207/cmekConfigs/cmekConfig-1207";
      client.deleteCmekConfigAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }
}
