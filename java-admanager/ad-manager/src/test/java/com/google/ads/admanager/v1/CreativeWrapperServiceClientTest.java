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

import static com.google.ads.admanager.v1.CreativeWrapperServiceClient.ListCreativeWrappersPagedResponse;

import com.google.ads.admanager.v1.stub.HttpJsonCreativeWrapperServiceStub;
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
public class CreativeWrapperServiceClientTest {
  private static MockHttpService mockService;
  private static CreativeWrapperServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonCreativeWrapperServiceStub.getMethodDescriptors(),
            CreativeWrapperServiceSettings.getDefaultEndpoint());
    CreativeWrapperServiceSettings settings =
        CreativeWrapperServiceSettings.newBuilder()
            .setTransportChannelProvider(
                CreativeWrapperServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = CreativeWrapperServiceClient.create(settings);
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
  public void getCreativeWrapperTest() throws Exception {
    CreativeWrapper expectedResponse =
        CreativeWrapper.newBuilder()
            .setName(CreativeWrapperName.of("[NETWORK_CODE]", "[CREATIVE_WRAPPER]").toString())
            .setLabel(LabelName.of("[NETWORK_CODE]", "[LABEL]").toString())
            .setHeaderCreative("headerCreative-952116900")
            .setFooterCreative("footerCreative245677674")
            .setHtmlHeader("htmlHeader2037590552")
            .setHtmlFooter("htmlFooter1989999910")
            .setAmpHeader("ampHeader237102449")
            .setAmpFooter("ampFooter189511807")
            .addAllVideoTrackingUrls(new ArrayList<VideoTrackingUrl>())
            .setThirdPartyDataDeclaration(ThirdPartyDataDeclaration.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    CreativeWrapperName name = CreativeWrapperName.of("[NETWORK_CODE]", "[CREATIVE_WRAPPER]");

    CreativeWrapper actualResponse = client.getCreativeWrapper(name);
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
  public void getCreativeWrapperExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CreativeWrapperName name = CreativeWrapperName.of("[NETWORK_CODE]", "[CREATIVE_WRAPPER]");
      client.getCreativeWrapper(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getCreativeWrapperTest2() throws Exception {
    CreativeWrapper expectedResponse =
        CreativeWrapper.newBuilder()
            .setName(CreativeWrapperName.of("[NETWORK_CODE]", "[CREATIVE_WRAPPER]").toString())
            .setLabel(LabelName.of("[NETWORK_CODE]", "[LABEL]").toString())
            .setHeaderCreative("headerCreative-952116900")
            .setFooterCreative("footerCreative245677674")
            .setHtmlHeader("htmlHeader2037590552")
            .setHtmlFooter("htmlFooter1989999910")
            .setAmpHeader("ampHeader237102449")
            .setAmpFooter("ampFooter189511807")
            .addAllVideoTrackingUrls(new ArrayList<VideoTrackingUrl>())
            .setThirdPartyDataDeclaration(ThirdPartyDataDeclaration.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "networks/network-1582/creativeWrappers/creativeWrapper-1582";

    CreativeWrapper actualResponse = client.getCreativeWrapper(name);
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
  public void getCreativeWrapperExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "networks/network-1582/creativeWrappers/creativeWrapper-1582";
      client.getCreativeWrapper(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listCreativeWrappersTest() throws Exception {
    CreativeWrapper responsesElement = CreativeWrapper.newBuilder().build();
    ListCreativeWrappersResponse expectedResponse =
        ListCreativeWrappersResponse.newBuilder()
            .setNextPageToken("")
            .addAllCreativeWrappers(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");

    ListCreativeWrappersPagedResponse pagedListResponse = client.listCreativeWrappers(parent);

    List<CreativeWrapper> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCreativeWrappersList().get(0), resources.get(0));

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
  public void listCreativeWrappersExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      client.listCreativeWrappers(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listCreativeWrappersTest2() throws Exception {
    CreativeWrapper responsesElement = CreativeWrapper.newBuilder().build();
    ListCreativeWrappersResponse expectedResponse =
        ListCreativeWrappersResponse.newBuilder()
            .setNextPageToken("")
            .addAllCreativeWrappers(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";

    ListCreativeWrappersPagedResponse pagedListResponse = client.listCreativeWrappers(parent);

    List<CreativeWrapper> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCreativeWrappersList().get(0), resources.get(0));

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
  public void listCreativeWrappersExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      client.listCreativeWrappers(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createCreativeWrapperTest() throws Exception {
    CreativeWrapper expectedResponse =
        CreativeWrapper.newBuilder()
            .setName(CreativeWrapperName.of("[NETWORK_CODE]", "[CREATIVE_WRAPPER]").toString())
            .setLabel(LabelName.of("[NETWORK_CODE]", "[LABEL]").toString())
            .setHeaderCreative("headerCreative-952116900")
            .setFooterCreative("footerCreative245677674")
            .setHtmlHeader("htmlHeader2037590552")
            .setHtmlFooter("htmlFooter1989999910")
            .setAmpHeader("ampHeader237102449")
            .setAmpFooter("ampFooter189511807")
            .addAllVideoTrackingUrls(new ArrayList<VideoTrackingUrl>())
            .setThirdPartyDataDeclaration(ThirdPartyDataDeclaration.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");
    CreativeWrapper creativeWrapper = CreativeWrapper.newBuilder().build();

    CreativeWrapper actualResponse = client.createCreativeWrapper(parent, creativeWrapper);
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
  public void createCreativeWrapperExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      CreativeWrapper creativeWrapper = CreativeWrapper.newBuilder().build();
      client.createCreativeWrapper(parent, creativeWrapper);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createCreativeWrapperTest2() throws Exception {
    CreativeWrapper expectedResponse =
        CreativeWrapper.newBuilder()
            .setName(CreativeWrapperName.of("[NETWORK_CODE]", "[CREATIVE_WRAPPER]").toString())
            .setLabel(LabelName.of("[NETWORK_CODE]", "[LABEL]").toString())
            .setHeaderCreative("headerCreative-952116900")
            .setFooterCreative("footerCreative245677674")
            .setHtmlHeader("htmlHeader2037590552")
            .setHtmlFooter("htmlFooter1989999910")
            .setAmpHeader("ampHeader237102449")
            .setAmpFooter("ampFooter189511807")
            .addAllVideoTrackingUrls(new ArrayList<VideoTrackingUrl>())
            .setThirdPartyDataDeclaration(ThirdPartyDataDeclaration.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";
    CreativeWrapper creativeWrapper = CreativeWrapper.newBuilder().build();

    CreativeWrapper actualResponse = client.createCreativeWrapper(parent, creativeWrapper);
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
  public void createCreativeWrapperExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      CreativeWrapper creativeWrapper = CreativeWrapper.newBuilder().build();
      client.createCreativeWrapper(parent, creativeWrapper);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchCreateCreativeWrappersTest() throws Exception {
    BatchCreateCreativeWrappersResponse expectedResponse =
        BatchCreateCreativeWrappersResponse.newBuilder()
            .addAllCreativeWrappers(new ArrayList<CreativeWrapper>())
            .build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");
    List<CreateCreativeWrapperRequest> requests = new ArrayList<>();

    BatchCreateCreativeWrappersResponse actualResponse =
        client.batchCreateCreativeWrappers(parent, requests);
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
  public void batchCreateCreativeWrappersExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      List<CreateCreativeWrapperRequest> requests = new ArrayList<>();
      client.batchCreateCreativeWrappers(parent, requests);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchCreateCreativeWrappersTest2() throws Exception {
    BatchCreateCreativeWrappersResponse expectedResponse =
        BatchCreateCreativeWrappersResponse.newBuilder()
            .addAllCreativeWrappers(new ArrayList<CreativeWrapper>())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";
    List<CreateCreativeWrapperRequest> requests = new ArrayList<>();

    BatchCreateCreativeWrappersResponse actualResponse =
        client.batchCreateCreativeWrappers(parent, requests);
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
  public void batchCreateCreativeWrappersExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      List<CreateCreativeWrapperRequest> requests = new ArrayList<>();
      client.batchCreateCreativeWrappers(parent, requests);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateCreativeWrapperTest() throws Exception {
    CreativeWrapper expectedResponse =
        CreativeWrapper.newBuilder()
            .setName(CreativeWrapperName.of("[NETWORK_CODE]", "[CREATIVE_WRAPPER]").toString())
            .setLabel(LabelName.of("[NETWORK_CODE]", "[LABEL]").toString())
            .setHeaderCreative("headerCreative-952116900")
            .setFooterCreative("footerCreative245677674")
            .setHtmlHeader("htmlHeader2037590552")
            .setHtmlFooter("htmlFooter1989999910")
            .setAmpHeader("ampHeader237102449")
            .setAmpFooter("ampFooter189511807")
            .addAllVideoTrackingUrls(new ArrayList<VideoTrackingUrl>())
            .setThirdPartyDataDeclaration(ThirdPartyDataDeclaration.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    CreativeWrapper creativeWrapper =
        CreativeWrapper.newBuilder()
            .setName(CreativeWrapperName.of("[NETWORK_CODE]", "[CREATIVE_WRAPPER]").toString())
            .setLabel(LabelName.of("[NETWORK_CODE]", "[LABEL]").toString())
            .setHeaderCreative("headerCreative-952116900")
            .setFooterCreative("footerCreative245677674")
            .setHtmlHeader("htmlHeader2037590552")
            .setHtmlFooter("htmlFooter1989999910")
            .setAmpHeader("ampHeader237102449")
            .setAmpFooter("ampFooter189511807")
            .addAllVideoTrackingUrls(new ArrayList<VideoTrackingUrl>())
            .setThirdPartyDataDeclaration(ThirdPartyDataDeclaration.newBuilder().build())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    CreativeWrapper actualResponse = client.updateCreativeWrapper(creativeWrapper, updateMask);
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
  public void updateCreativeWrapperExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CreativeWrapper creativeWrapper =
          CreativeWrapper.newBuilder()
              .setName(CreativeWrapperName.of("[NETWORK_CODE]", "[CREATIVE_WRAPPER]").toString())
              .setLabel(LabelName.of("[NETWORK_CODE]", "[LABEL]").toString())
              .setHeaderCreative("headerCreative-952116900")
              .setFooterCreative("footerCreative245677674")
              .setHtmlHeader("htmlHeader2037590552")
              .setHtmlFooter("htmlFooter1989999910")
              .setAmpHeader("ampHeader237102449")
              .setAmpFooter("ampFooter189511807")
              .addAllVideoTrackingUrls(new ArrayList<VideoTrackingUrl>())
              .setThirdPartyDataDeclaration(ThirdPartyDataDeclaration.newBuilder().build())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateCreativeWrapper(creativeWrapper, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchUpdateCreativeWrappersTest() throws Exception {
    BatchUpdateCreativeWrappersResponse expectedResponse =
        BatchUpdateCreativeWrappersResponse.newBuilder()
            .addAllCreativeWrappers(new ArrayList<CreativeWrapper>())
            .build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");
    List<UpdateCreativeWrapperRequest> requests = new ArrayList<>();

    BatchUpdateCreativeWrappersResponse actualResponse =
        client.batchUpdateCreativeWrappers(parent, requests);
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
  public void batchUpdateCreativeWrappersExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      List<UpdateCreativeWrapperRequest> requests = new ArrayList<>();
      client.batchUpdateCreativeWrappers(parent, requests);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchUpdateCreativeWrappersTest2() throws Exception {
    BatchUpdateCreativeWrappersResponse expectedResponse =
        BatchUpdateCreativeWrappersResponse.newBuilder()
            .addAllCreativeWrappers(new ArrayList<CreativeWrapper>())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";
    List<UpdateCreativeWrapperRequest> requests = new ArrayList<>();

    BatchUpdateCreativeWrappersResponse actualResponse =
        client.batchUpdateCreativeWrappers(parent, requests);
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
  public void batchUpdateCreativeWrappersExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      List<UpdateCreativeWrapperRequest> requests = new ArrayList<>();
      client.batchUpdateCreativeWrappers(parent, requests);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchActivateCreativeWrappersTest() throws Exception {
    BatchActivateCreativeWrappersResponse expectedResponse =
        BatchActivateCreativeWrappersResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");
    List<String> names = new ArrayList<>();

    BatchActivateCreativeWrappersResponse actualResponse =
        client.batchActivateCreativeWrappers(parent, names);
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
  public void batchActivateCreativeWrappersExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      List<String> names = new ArrayList<>();
      client.batchActivateCreativeWrappers(parent, names);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchActivateCreativeWrappersTest2() throws Exception {
    BatchActivateCreativeWrappersResponse expectedResponse =
        BatchActivateCreativeWrappersResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";
    List<String> names = new ArrayList<>();

    BatchActivateCreativeWrappersResponse actualResponse =
        client.batchActivateCreativeWrappers(parent, names);
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
  public void batchActivateCreativeWrappersExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      List<String> names = new ArrayList<>();
      client.batchActivateCreativeWrappers(parent, names);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchDeactivateCreativeWrappersTest() throws Exception {
    BatchDeactivateCreativeWrappersResponse expectedResponse =
        BatchDeactivateCreativeWrappersResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");
    List<String> names = new ArrayList<>();

    BatchDeactivateCreativeWrappersResponse actualResponse =
        client.batchDeactivateCreativeWrappers(parent, names);
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
  public void batchDeactivateCreativeWrappersExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      List<String> names = new ArrayList<>();
      client.batchDeactivateCreativeWrappers(parent, names);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchDeactivateCreativeWrappersTest2() throws Exception {
    BatchDeactivateCreativeWrappersResponse expectedResponse =
        BatchDeactivateCreativeWrappersResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";
    List<String> names = new ArrayList<>();

    BatchDeactivateCreativeWrappersResponse actualResponse =
        client.batchDeactivateCreativeWrappers(parent, names);
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
  public void batchDeactivateCreativeWrappersExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      List<String> names = new ArrayList<>();
      client.batchDeactivateCreativeWrappers(parent, names);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
