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

import static com.google.appengine.v1.DomainMappingsClient.ListDomainMappingsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.appengine.v1.stub.HttpJsonDomainMappingsStub;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.ArrayList;
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
public class DomainMappingsClientHttpJsonTest {
  private static MockHttpService mockService;
  private static DomainMappingsClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonDomainMappingsStub.getMethodDescriptors(),
            DomainMappingsSettings.getDefaultEndpoint());
    DomainMappingsSettings settings =
        DomainMappingsSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                DomainMappingsSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = DomainMappingsClient.create(settings);
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
  public void listDomainMappingsTest() throws Exception {
    DomainMapping responsesElement = DomainMapping.newBuilder().build();
    ListDomainMappingsResponse expectedResponse =
        ListDomainMappingsResponse.newBuilder()
            .setNextPageToken("")
            .addAllDomainMappings(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    ListDomainMappingsRequest request =
        ListDomainMappingsRequest.newBuilder()
            .setParent("apps/app-3559")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    ListDomainMappingsPagedResponse pagedListResponse = client.listDomainMappings(request);

    List<DomainMapping> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDomainMappingsList().get(0), resources.get(0));

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
  public void listDomainMappingsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ListDomainMappingsRequest request =
          ListDomainMappingsRequest.newBuilder()
              .setParent("apps/app-3559")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      client.listDomainMappings(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDomainMappingTest() throws Exception {
    DomainMapping expectedResponse =
        DomainMapping.newBuilder()
            .setName("name3373707")
            .setId("id3355")
            .setSslSettings(SslSettings.newBuilder().build())
            .addAllResourceRecords(new ArrayList<ResourceRecord>())
            .build();
    mockService.addResponse(expectedResponse);

    GetDomainMappingRequest request =
        GetDomainMappingRequest.newBuilder()
            .setName("apps/app-1227/domainMappings/domainMapping-1227")
            .build();

    DomainMapping actualResponse = client.getDomainMapping(request);
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
  public void getDomainMappingExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GetDomainMappingRequest request =
          GetDomainMappingRequest.newBuilder()
              .setName("apps/app-1227/domainMappings/domainMapping-1227")
              .build();
      client.getDomainMapping(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createDomainMappingTest() throws Exception {
    DomainMapping expectedResponse =
        DomainMapping.newBuilder()
            .setName("name3373707")
            .setId("id3355")
            .setSslSettings(SslSettings.newBuilder().build())
            .addAllResourceRecords(new ArrayList<ResourceRecord>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createDomainMappingTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    CreateDomainMappingRequest request =
        CreateDomainMappingRequest.newBuilder()
            .setParent("apps/app-3559")
            .setDomainMapping(DomainMapping.newBuilder().build())
            .setOverrideStrategy(DomainOverrideStrategy.forNumber(0))
            .build();

    DomainMapping actualResponse = client.createDomainMappingAsync(request).get();
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
  public void createDomainMappingExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CreateDomainMappingRequest request =
          CreateDomainMappingRequest.newBuilder()
              .setParent("apps/app-3559")
              .setDomainMapping(DomainMapping.newBuilder().build())
              .setOverrideStrategy(DomainOverrideStrategy.forNumber(0))
              .build();
      client.createDomainMappingAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void updateDomainMappingTest() throws Exception {
    DomainMapping expectedResponse =
        DomainMapping.newBuilder()
            .setName("name3373707")
            .setId("id3355")
            .setSslSettings(SslSettings.newBuilder().build())
            .addAllResourceRecords(new ArrayList<ResourceRecord>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateDomainMappingTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    UpdateDomainMappingRequest request =
        UpdateDomainMappingRequest.newBuilder()
            .setName("apps/app-1227/domainMappings/domainMapping-1227")
            .setDomainMapping(DomainMapping.newBuilder().build())
            .setUpdateMask(FieldMask.newBuilder().build())
            .build();

    DomainMapping actualResponse = client.updateDomainMappingAsync(request).get();
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
  public void updateDomainMappingExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      UpdateDomainMappingRequest request =
          UpdateDomainMappingRequest.newBuilder()
              .setName("apps/app-1227/domainMappings/domainMapping-1227")
              .setDomainMapping(DomainMapping.newBuilder().build())
              .setUpdateMask(FieldMask.newBuilder().build())
              .build();
      client.updateDomainMappingAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteDomainMappingTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteDomainMappingTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    DeleteDomainMappingRequest request =
        DeleteDomainMappingRequest.newBuilder()
            .setName("apps/app-1227/domainMappings/domainMapping-1227")
            .build();

    client.deleteDomainMappingAsync(request).get();

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
  public void deleteDomainMappingExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DeleteDomainMappingRequest request =
          DeleteDomainMappingRequest.newBuilder()
              .setName("apps/app-1227/domainMappings/domainMapping-1227")
              .build();
      client.deleteDomainMappingAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }
}
