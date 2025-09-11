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

package com.google.cloud.dataplex.v1;

import static com.google.cloud.dataplex.v1.BusinessGlossaryServiceClient.ListGlossariesPagedResponse;
import static com.google.cloud.dataplex.v1.BusinessGlossaryServiceClient.ListGlossaryCategoriesPagedResponse;
import static com.google.cloud.dataplex.v1.BusinessGlossaryServiceClient.ListGlossaryTermsPagedResponse;
import static com.google.cloud.dataplex.v1.BusinessGlossaryServiceClient.ListLocationsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
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
public class BusinessGlossaryServiceClientTest {
  private static MockBusinessGlossaryService mockBusinessGlossaryService;
  private static MockIAMPolicy mockIAMPolicy;
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private BusinessGlossaryServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockBusinessGlossaryService = new MockBusinessGlossaryService();
    mockLocations = new MockLocations();
    mockIAMPolicy = new MockIAMPolicy();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(
                mockBusinessGlossaryService, mockLocations, mockIAMPolicy));
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
    BusinessGlossaryServiceSettings settings =
        BusinessGlossaryServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = BusinessGlossaryServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createGlossaryTest() throws Exception {
    Glossary expectedResponse =
        Glossary.newBuilder()
            .setName(GlossaryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]").toString())
            .setUid("uid115792")
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setTermCount(-1604847748)
            .setCategoryCount(1899510414)
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createGlossaryTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockBusinessGlossaryService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Glossary glossary = Glossary.newBuilder().build();
    String glossaryId = "glossaryId1849967577";

    Glossary actualResponse = client.createGlossaryAsync(parent, glossary, glossaryId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBusinessGlossaryService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateGlossaryRequest actualRequest = ((CreateGlossaryRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(glossary, actualRequest.getGlossary());
    Assert.assertEquals(glossaryId, actualRequest.getGlossaryId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createGlossaryExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBusinessGlossaryService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Glossary glossary = Glossary.newBuilder().build();
      String glossaryId = "glossaryId1849967577";
      client.createGlossaryAsync(parent, glossary, glossaryId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createGlossaryTest2() throws Exception {
    Glossary expectedResponse =
        Glossary.newBuilder()
            .setName(GlossaryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]").toString())
            .setUid("uid115792")
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setTermCount(-1604847748)
            .setCategoryCount(1899510414)
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createGlossaryTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockBusinessGlossaryService.addResponse(resultOperation);

    String parent = "parent-995424086";
    Glossary glossary = Glossary.newBuilder().build();
    String glossaryId = "glossaryId1849967577";

    Glossary actualResponse = client.createGlossaryAsync(parent, glossary, glossaryId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBusinessGlossaryService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateGlossaryRequest actualRequest = ((CreateGlossaryRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(glossary, actualRequest.getGlossary());
    Assert.assertEquals(glossaryId, actualRequest.getGlossaryId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createGlossaryExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBusinessGlossaryService.addException(exception);

    try {
      String parent = "parent-995424086";
      Glossary glossary = Glossary.newBuilder().build();
      String glossaryId = "glossaryId1849967577";
      client.createGlossaryAsync(parent, glossary, glossaryId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateGlossaryTest() throws Exception {
    Glossary expectedResponse =
        Glossary.newBuilder()
            .setName(GlossaryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]").toString())
            .setUid("uid115792")
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setTermCount(-1604847748)
            .setCategoryCount(1899510414)
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateGlossaryTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockBusinessGlossaryService.addResponse(resultOperation);

    Glossary glossary = Glossary.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Glossary actualResponse = client.updateGlossaryAsync(glossary, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBusinessGlossaryService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateGlossaryRequest actualRequest = ((UpdateGlossaryRequest) actualRequests.get(0));

    Assert.assertEquals(glossary, actualRequest.getGlossary());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateGlossaryExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBusinessGlossaryService.addException(exception);

    try {
      Glossary glossary = Glossary.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateGlossaryAsync(glossary, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteGlossaryTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteGlossaryTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockBusinessGlossaryService.addResponse(resultOperation);

    GlossaryName name = GlossaryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]");

    client.deleteGlossaryAsync(name).get();

    List<AbstractMessage> actualRequests = mockBusinessGlossaryService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteGlossaryRequest actualRequest = ((DeleteGlossaryRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteGlossaryExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBusinessGlossaryService.addException(exception);

    try {
      GlossaryName name = GlossaryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]");
      client.deleteGlossaryAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteGlossaryTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteGlossaryTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockBusinessGlossaryService.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteGlossaryAsync(name).get();

    List<AbstractMessage> actualRequests = mockBusinessGlossaryService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteGlossaryRequest actualRequest = ((DeleteGlossaryRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteGlossaryExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBusinessGlossaryService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteGlossaryAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void getGlossaryTest() throws Exception {
    Glossary expectedResponse =
        Glossary.newBuilder()
            .setName(GlossaryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]").toString())
            .setUid("uid115792")
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setTermCount(-1604847748)
            .setCategoryCount(1899510414)
            .setEtag("etag3123477")
            .build();
    mockBusinessGlossaryService.addResponse(expectedResponse);

    GlossaryName name = GlossaryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]");

    Glossary actualResponse = client.getGlossary(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBusinessGlossaryService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetGlossaryRequest actualRequest = ((GetGlossaryRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getGlossaryExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBusinessGlossaryService.addException(exception);

    try {
      GlossaryName name = GlossaryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]");
      client.getGlossary(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getGlossaryTest2() throws Exception {
    Glossary expectedResponse =
        Glossary.newBuilder()
            .setName(GlossaryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]").toString())
            .setUid("uid115792")
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setTermCount(-1604847748)
            .setCategoryCount(1899510414)
            .setEtag("etag3123477")
            .build();
    mockBusinessGlossaryService.addResponse(expectedResponse);

    String name = "name3373707";

    Glossary actualResponse = client.getGlossary(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBusinessGlossaryService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetGlossaryRequest actualRequest = ((GetGlossaryRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getGlossaryExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBusinessGlossaryService.addException(exception);

    try {
      String name = "name3373707";
      client.getGlossary(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listGlossariesTest() throws Exception {
    Glossary responsesElement = Glossary.newBuilder().build();
    ListGlossariesResponse expectedResponse =
        ListGlossariesResponse.newBuilder()
            .setNextPageToken("")
            .addAllGlossaries(Arrays.asList(responsesElement))
            .build();
    mockBusinessGlossaryService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListGlossariesPagedResponse pagedListResponse = client.listGlossaries(parent);

    List<Glossary> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getGlossariesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockBusinessGlossaryService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListGlossariesRequest actualRequest = ((ListGlossariesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listGlossariesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBusinessGlossaryService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listGlossaries(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listGlossariesTest2() throws Exception {
    Glossary responsesElement = Glossary.newBuilder().build();
    ListGlossariesResponse expectedResponse =
        ListGlossariesResponse.newBuilder()
            .setNextPageToken("")
            .addAllGlossaries(Arrays.asList(responsesElement))
            .build();
    mockBusinessGlossaryService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListGlossariesPagedResponse pagedListResponse = client.listGlossaries(parent);

    List<Glossary> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getGlossariesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockBusinessGlossaryService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListGlossariesRequest actualRequest = ((ListGlossariesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listGlossariesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBusinessGlossaryService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listGlossaries(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createGlossaryCategoryTest() throws Exception {
    GlossaryCategory expectedResponse =
        GlossaryCategory.newBuilder()
            .setName(
                GlossaryCategoryName.of(
                        "[PROJECT]", "[LOCATION]", "[GLOSSARY]", "[GLOSSARY_CATEGORY]")
                    .toString())
            .setUid("uid115792")
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setParent("parent-995424086")
            .build();
    mockBusinessGlossaryService.addResponse(expectedResponse);

    GlossaryName parent = GlossaryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]");
    GlossaryCategory category = GlossaryCategory.newBuilder().build();
    String categoryId = "categoryId1296531129";

    GlossaryCategory actualResponse = client.createGlossaryCategory(parent, category, categoryId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBusinessGlossaryService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateGlossaryCategoryRequest actualRequest =
        ((CreateGlossaryCategoryRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(category, actualRequest.getCategory());
    Assert.assertEquals(categoryId, actualRequest.getCategoryId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createGlossaryCategoryExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBusinessGlossaryService.addException(exception);

    try {
      GlossaryName parent = GlossaryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]");
      GlossaryCategory category = GlossaryCategory.newBuilder().build();
      String categoryId = "categoryId1296531129";
      client.createGlossaryCategory(parent, category, categoryId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createGlossaryCategoryTest2() throws Exception {
    GlossaryCategory expectedResponse =
        GlossaryCategory.newBuilder()
            .setName(
                GlossaryCategoryName.of(
                        "[PROJECT]", "[LOCATION]", "[GLOSSARY]", "[GLOSSARY_CATEGORY]")
                    .toString())
            .setUid("uid115792")
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setParent("parent-995424086")
            .build();
    mockBusinessGlossaryService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    GlossaryCategory category = GlossaryCategory.newBuilder().build();
    String categoryId = "categoryId1296531129";

    GlossaryCategory actualResponse = client.createGlossaryCategory(parent, category, categoryId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBusinessGlossaryService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateGlossaryCategoryRequest actualRequest =
        ((CreateGlossaryCategoryRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(category, actualRequest.getCategory());
    Assert.assertEquals(categoryId, actualRequest.getCategoryId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createGlossaryCategoryExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBusinessGlossaryService.addException(exception);

    try {
      String parent = "parent-995424086";
      GlossaryCategory category = GlossaryCategory.newBuilder().build();
      String categoryId = "categoryId1296531129";
      client.createGlossaryCategory(parent, category, categoryId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateGlossaryCategoryTest() throws Exception {
    GlossaryCategory expectedResponse =
        GlossaryCategory.newBuilder()
            .setName(
                GlossaryCategoryName.of(
                        "[PROJECT]", "[LOCATION]", "[GLOSSARY]", "[GLOSSARY_CATEGORY]")
                    .toString())
            .setUid("uid115792")
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setParent("parent-995424086")
            .build();
    mockBusinessGlossaryService.addResponse(expectedResponse);

    GlossaryCategory category = GlossaryCategory.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    GlossaryCategory actualResponse = client.updateGlossaryCategory(category, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBusinessGlossaryService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateGlossaryCategoryRequest actualRequest =
        ((UpdateGlossaryCategoryRequest) actualRequests.get(0));

    Assert.assertEquals(category, actualRequest.getCategory());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateGlossaryCategoryExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBusinessGlossaryService.addException(exception);

    try {
      GlossaryCategory category = GlossaryCategory.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateGlossaryCategory(category, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteGlossaryCategoryTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockBusinessGlossaryService.addResponse(expectedResponse);

    GlossaryCategoryName name =
        GlossaryCategoryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]", "[GLOSSARY_CATEGORY]");

    client.deleteGlossaryCategory(name);

    List<AbstractMessage> actualRequests = mockBusinessGlossaryService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteGlossaryCategoryRequest actualRequest =
        ((DeleteGlossaryCategoryRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteGlossaryCategoryExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBusinessGlossaryService.addException(exception);

    try {
      GlossaryCategoryName name =
          GlossaryCategoryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]", "[GLOSSARY_CATEGORY]");
      client.deleteGlossaryCategory(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteGlossaryCategoryTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockBusinessGlossaryService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteGlossaryCategory(name);

    List<AbstractMessage> actualRequests = mockBusinessGlossaryService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteGlossaryCategoryRequest actualRequest =
        ((DeleteGlossaryCategoryRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteGlossaryCategoryExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBusinessGlossaryService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteGlossaryCategory(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getGlossaryCategoryTest() throws Exception {
    GlossaryCategory expectedResponse =
        GlossaryCategory.newBuilder()
            .setName(
                GlossaryCategoryName.of(
                        "[PROJECT]", "[LOCATION]", "[GLOSSARY]", "[GLOSSARY_CATEGORY]")
                    .toString())
            .setUid("uid115792")
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setParent("parent-995424086")
            .build();
    mockBusinessGlossaryService.addResponse(expectedResponse);

    GlossaryCategoryName name =
        GlossaryCategoryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]", "[GLOSSARY_CATEGORY]");

    GlossaryCategory actualResponse = client.getGlossaryCategory(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBusinessGlossaryService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetGlossaryCategoryRequest actualRequest = ((GetGlossaryCategoryRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getGlossaryCategoryExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBusinessGlossaryService.addException(exception);

    try {
      GlossaryCategoryName name =
          GlossaryCategoryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]", "[GLOSSARY_CATEGORY]");
      client.getGlossaryCategory(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getGlossaryCategoryTest2() throws Exception {
    GlossaryCategory expectedResponse =
        GlossaryCategory.newBuilder()
            .setName(
                GlossaryCategoryName.of(
                        "[PROJECT]", "[LOCATION]", "[GLOSSARY]", "[GLOSSARY_CATEGORY]")
                    .toString())
            .setUid("uid115792")
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setParent("parent-995424086")
            .build();
    mockBusinessGlossaryService.addResponse(expectedResponse);

    String name = "name3373707";

    GlossaryCategory actualResponse = client.getGlossaryCategory(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBusinessGlossaryService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetGlossaryCategoryRequest actualRequest = ((GetGlossaryCategoryRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getGlossaryCategoryExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBusinessGlossaryService.addException(exception);

    try {
      String name = "name3373707";
      client.getGlossaryCategory(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listGlossaryCategoriesTest() throws Exception {
    GlossaryCategory responsesElement = GlossaryCategory.newBuilder().build();
    ListGlossaryCategoriesResponse expectedResponse =
        ListGlossaryCategoriesResponse.newBuilder()
            .setNextPageToken("")
            .addAllCategories(Arrays.asList(responsesElement))
            .build();
    mockBusinessGlossaryService.addResponse(expectedResponse);

    GlossaryName parent = GlossaryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]");

    ListGlossaryCategoriesPagedResponse pagedListResponse = client.listGlossaryCategories(parent);

    List<GlossaryCategory> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCategoriesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockBusinessGlossaryService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListGlossaryCategoriesRequest actualRequest =
        ((ListGlossaryCategoriesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listGlossaryCategoriesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBusinessGlossaryService.addException(exception);

    try {
      GlossaryName parent = GlossaryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]");
      client.listGlossaryCategories(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listGlossaryCategoriesTest2() throws Exception {
    GlossaryCategory responsesElement = GlossaryCategory.newBuilder().build();
    ListGlossaryCategoriesResponse expectedResponse =
        ListGlossaryCategoriesResponse.newBuilder()
            .setNextPageToken("")
            .addAllCategories(Arrays.asList(responsesElement))
            .build();
    mockBusinessGlossaryService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListGlossaryCategoriesPagedResponse pagedListResponse = client.listGlossaryCategories(parent);

    List<GlossaryCategory> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCategoriesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockBusinessGlossaryService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListGlossaryCategoriesRequest actualRequest =
        ((ListGlossaryCategoriesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listGlossaryCategoriesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBusinessGlossaryService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listGlossaryCategories(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createGlossaryTermTest() throws Exception {
    GlossaryTerm expectedResponse =
        GlossaryTerm.newBuilder()
            .setName(
                GlossaryTermName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]", "[GLOSSARY_TERM]")
                    .toString())
            .setUid("uid115792")
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setParent(GlossaryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]").toString())
            .build();
    mockBusinessGlossaryService.addResponse(expectedResponse);

    GlossaryName parent = GlossaryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]");
    GlossaryTerm term = GlossaryTerm.newBuilder().build();
    String termId = "termId-877206873";

    GlossaryTerm actualResponse = client.createGlossaryTerm(parent, term, termId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBusinessGlossaryService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateGlossaryTermRequest actualRequest = ((CreateGlossaryTermRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(term, actualRequest.getTerm());
    Assert.assertEquals(termId, actualRequest.getTermId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createGlossaryTermExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBusinessGlossaryService.addException(exception);

    try {
      GlossaryName parent = GlossaryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]");
      GlossaryTerm term = GlossaryTerm.newBuilder().build();
      String termId = "termId-877206873";
      client.createGlossaryTerm(parent, term, termId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createGlossaryTermTest2() throws Exception {
    GlossaryTerm expectedResponse =
        GlossaryTerm.newBuilder()
            .setName(
                GlossaryTermName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]", "[GLOSSARY_TERM]")
                    .toString())
            .setUid("uid115792")
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setParent(GlossaryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]").toString())
            .build();
    mockBusinessGlossaryService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    GlossaryTerm term = GlossaryTerm.newBuilder().build();
    String termId = "termId-877206873";

    GlossaryTerm actualResponse = client.createGlossaryTerm(parent, term, termId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBusinessGlossaryService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateGlossaryTermRequest actualRequest = ((CreateGlossaryTermRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(term, actualRequest.getTerm());
    Assert.assertEquals(termId, actualRequest.getTermId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createGlossaryTermExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBusinessGlossaryService.addException(exception);

    try {
      String parent = "parent-995424086";
      GlossaryTerm term = GlossaryTerm.newBuilder().build();
      String termId = "termId-877206873";
      client.createGlossaryTerm(parent, term, termId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateGlossaryTermTest() throws Exception {
    GlossaryTerm expectedResponse =
        GlossaryTerm.newBuilder()
            .setName(
                GlossaryTermName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]", "[GLOSSARY_TERM]")
                    .toString())
            .setUid("uid115792")
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setParent(GlossaryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]").toString())
            .build();
    mockBusinessGlossaryService.addResponse(expectedResponse);

    GlossaryTerm term = GlossaryTerm.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    GlossaryTerm actualResponse = client.updateGlossaryTerm(term, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBusinessGlossaryService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateGlossaryTermRequest actualRequest = ((UpdateGlossaryTermRequest) actualRequests.get(0));

    Assert.assertEquals(term, actualRequest.getTerm());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateGlossaryTermExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBusinessGlossaryService.addException(exception);

    try {
      GlossaryTerm term = GlossaryTerm.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateGlossaryTerm(term, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteGlossaryTermTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockBusinessGlossaryService.addResponse(expectedResponse);

    GlossaryTermName name =
        GlossaryTermName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]", "[GLOSSARY_TERM]");

    client.deleteGlossaryTerm(name);

    List<AbstractMessage> actualRequests = mockBusinessGlossaryService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteGlossaryTermRequest actualRequest = ((DeleteGlossaryTermRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteGlossaryTermExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBusinessGlossaryService.addException(exception);

    try {
      GlossaryTermName name =
          GlossaryTermName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]", "[GLOSSARY_TERM]");
      client.deleteGlossaryTerm(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteGlossaryTermTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockBusinessGlossaryService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteGlossaryTerm(name);

    List<AbstractMessage> actualRequests = mockBusinessGlossaryService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteGlossaryTermRequest actualRequest = ((DeleteGlossaryTermRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteGlossaryTermExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBusinessGlossaryService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteGlossaryTerm(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getGlossaryTermTest() throws Exception {
    GlossaryTerm expectedResponse =
        GlossaryTerm.newBuilder()
            .setName(
                GlossaryTermName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]", "[GLOSSARY_TERM]")
                    .toString())
            .setUid("uid115792")
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setParent(GlossaryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]").toString())
            .build();
    mockBusinessGlossaryService.addResponse(expectedResponse);

    GlossaryTermName name =
        GlossaryTermName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]", "[GLOSSARY_TERM]");

    GlossaryTerm actualResponse = client.getGlossaryTerm(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBusinessGlossaryService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetGlossaryTermRequest actualRequest = ((GetGlossaryTermRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getGlossaryTermExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBusinessGlossaryService.addException(exception);

    try {
      GlossaryTermName name =
          GlossaryTermName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]", "[GLOSSARY_TERM]");
      client.getGlossaryTerm(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getGlossaryTermTest2() throws Exception {
    GlossaryTerm expectedResponse =
        GlossaryTerm.newBuilder()
            .setName(
                GlossaryTermName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]", "[GLOSSARY_TERM]")
                    .toString())
            .setUid("uid115792")
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setParent(GlossaryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]").toString())
            .build();
    mockBusinessGlossaryService.addResponse(expectedResponse);

    String name = "name3373707";

    GlossaryTerm actualResponse = client.getGlossaryTerm(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBusinessGlossaryService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetGlossaryTermRequest actualRequest = ((GetGlossaryTermRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getGlossaryTermExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBusinessGlossaryService.addException(exception);

    try {
      String name = "name3373707";
      client.getGlossaryTerm(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listGlossaryTermsTest() throws Exception {
    GlossaryTerm responsesElement = GlossaryTerm.newBuilder().build();
    ListGlossaryTermsResponse expectedResponse =
        ListGlossaryTermsResponse.newBuilder()
            .setNextPageToken("")
            .addAllTerms(Arrays.asList(responsesElement))
            .build();
    mockBusinessGlossaryService.addResponse(expectedResponse);

    GlossaryName parent = GlossaryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]");

    ListGlossaryTermsPagedResponse pagedListResponse = client.listGlossaryTerms(parent);

    List<GlossaryTerm> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTermsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockBusinessGlossaryService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListGlossaryTermsRequest actualRequest = ((ListGlossaryTermsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listGlossaryTermsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBusinessGlossaryService.addException(exception);

    try {
      GlossaryName parent = GlossaryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]");
      client.listGlossaryTerms(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listGlossaryTermsTest2() throws Exception {
    GlossaryTerm responsesElement = GlossaryTerm.newBuilder().build();
    ListGlossaryTermsResponse expectedResponse =
        ListGlossaryTermsResponse.newBuilder()
            .setNextPageToken("")
            .addAllTerms(Arrays.asList(responsesElement))
            .build();
    mockBusinessGlossaryService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListGlossaryTermsPagedResponse pagedListResponse = client.listGlossaryTerms(parent);

    List<GlossaryTerm> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTermsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockBusinessGlossaryService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListGlossaryTermsRequest actualRequest = ((ListGlossaryTermsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listGlossaryTermsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBusinessGlossaryService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listGlossaryTerms(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listLocationsTest() throws Exception {
    Location responsesElement = Location.newBuilder().build();
    ListLocationsResponse expectedResponse =
        ListLocationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllLocations(Arrays.asList(responsesElement))
            .build();
    mockLocations.addResponse(expectedResponse);

    ListLocationsRequest request =
        ListLocationsRequest.newBuilder()
            .setName("name3373707")
            .setFilter("filter-1274492040")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    ListLocationsPagedResponse pagedListResponse = client.listLocations(request);

    List<Location> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLocationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockLocations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListLocationsRequest actualRequest = ((ListLocationsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getFilter(), actualRequest.getFilter());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listLocationsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLocations.addException(exception);

    try {
      ListLocationsRequest request =
          ListLocationsRequest.newBuilder()
              .setName("name3373707")
              .setFilter("filter-1274492040")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      client.listLocations(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getLocationTest() throws Exception {
    Location expectedResponse =
        Location.newBuilder()
            .setName("name3373707")
            .setLocationId("locationId1541836720")
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setMetadata(Any.newBuilder().build())
            .build();
    mockLocations.addResponse(expectedResponse);

    GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();

    Location actualResponse = client.getLocation(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLocations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetLocationRequest actualRequest = ((GetLocationRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getLocationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLocations.addException(exception);

    try {
      GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
      client.getLocation(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
