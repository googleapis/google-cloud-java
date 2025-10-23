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

package com.google.ads.admanager.v1;

import static com.google.ads.admanager.v1.CmsMetadataValueServiceClient.ListCmsMetadataValuesPagedResponse;

import com.google.ads.admanager.v1.stub.HttpJsonCmsMetadataValueServiceStub;
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
public class CmsMetadataValueServiceClientTest {
  private static MockHttpService mockService;
  private static CmsMetadataValueServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonCmsMetadataValueServiceStub.getMethodDescriptors(),
            CmsMetadataValueServiceSettings.getDefaultEndpoint());
    CmsMetadataValueServiceSettings settings =
        CmsMetadataValueServiceSettings.newBuilder()
            .setTransportChannelProvider(
                CmsMetadataValueServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = CmsMetadataValueServiceClient.create(settings);
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
  public void getCmsMetadataValueTest() throws Exception {
    CmsMetadataValue expectedResponse =
        CmsMetadataValue.newBuilder()
            .setName(CmsMetadataValueName.of("[NETWORK_CODE]", "[CMS_METADATA_VALUE]").toString())
            .setDisplayName("displayName1714148973")
            .setKey(CmsMetadataKeyName.of("[NETWORK_CODE]", "[CMS_METADATA_KEY]").toString())
            .build();
    mockService.addResponse(expectedResponse);

    CmsMetadataValueName name = CmsMetadataValueName.of("[NETWORK_CODE]", "[CMS_METADATA_VALUE]");

    CmsMetadataValue actualResponse = client.getCmsMetadataValue(name);
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
  public void getCmsMetadataValueExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CmsMetadataValueName name = CmsMetadataValueName.of("[NETWORK_CODE]", "[CMS_METADATA_VALUE]");
      client.getCmsMetadataValue(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getCmsMetadataValueTest2() throws Exception {
    CmsMetadataValue expectedResponse =
        CmsMetadataValue.newBuilder()
            .setName(CmsMetadataValueName.of("[NETWORK_CODE]", "[CMS_METADATA_VALUE]").toString())
            .setDisplayName("displayName1714148973")
            .setKey(CmsMetadataKeyName.of("[NETWORK_CODE]", "[CMS_METADATA_KEY]").toString())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "networks/network-1839/cmsMetadataValues/cmsMetadataValue-1839";

    CmsMetadataValue actualResponse = client.getCmsMetadataValue(name);
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
  public void getCmsMetadataValueExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "networks/network-1839/cmsMetadataValues/cmsMetadataValue-1839";
      client.getCmsMetadataValue(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listCmsMetadataValuesTest() throws Exception {
    CmsMetadataValue responsesElement = CmsMetadataValue.newBuilder().build();
    ListCmsMetadataValuesResponse expectedResponse =
        ListCmsMetadataValuesResponse.newBuilder()
            .setNextPageToken("")
            .addAllCmsMetadataValues(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");

    ListCmsMetadataValuesPagedResponse pagedListResponse = client.listCmsMetadataValues(parent);

    List<CmsMetadataValue> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCmsMetadataValuesList().get(0), resources.get(0));

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
  public void listCmsMetadataValuesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      client.listCmsMetadataValues(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listCmsMetadataValuesTest2() throws Exception {
    CmsMetadataValue responsesElement = CmsMetadataValue.newBuilder().build();
    ListCmsMetadataValuesResponse expectedResponse =
        ListCmsMetadataValuesResponse.newBuilder()
            .setNextPageToken("")
            .addAllCmsMetadataValues(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";

    ListCmsMetadataValuesPagedResponse pagedListResponse = client.listCmsMetadataValues(parent);

    List<CmsMetadataValue> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCmsMetadataValuesList().get(0), resources.get(0));

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
  public void listCmsMetadataValuesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      client.listCmsMetadataValues(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
