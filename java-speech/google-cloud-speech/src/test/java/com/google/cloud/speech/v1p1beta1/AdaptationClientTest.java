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

package com.google.cloud.speech.v1p1beta1;

import static com.google.cloud.speech.v1p1beta1.AdaptationClient.ListCustomClassesPagedResponse;
import static com.google.cloud.speech.v1p1beta1.AdaptationClient.ListPhraseSetPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.common.collect.Lists;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class AdaptationClientTest {
  private static MockAdaptation mockAdaptation;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private AdaptationClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockAdaptation = new MockAdaptation();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockAdaptation));
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
    AdaptationSettings settings =
        AdaptationSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = AdaptationClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createPhraseSetTest() throws Exception {
    PhraseSet expectedResponse =
        PhraseSet.newBuilder()
            .setName(PhraseSetName.of("[PROJECT]", "[LOCATION]", "[PHRASE_SET]").toString())
            .addAllPhrases(new ArrayList<PhraseSet.Phrase>())
            .setBoost(93922211)
            .build();
    mockAdaptation.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    PhraseSet phraseSet = PhraseSet.newBuilder().build();
    String phraseSetId = "phraseSetId959902180";

    PhraseSet actualResponse = client.createPhraseSet(parent, phraseSet, phraseSetId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAdaptation.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreatePhraseSetRequest actualRequest = ((CreatePhraseSetRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(phraseSet, actualRequest.getPhraseSet());
    Assert.assertEquals(phraseSetId, actualRequest.getPhraseSetId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createPhraseSetExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAdaptation.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      PhraseSet phraseSet = PhraseSet.newBuilder().build();
      String phraseSetId = "phraseSetId959902180";
      client.createPhraseSet(parent, phraseSet, phraseSetId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createPhraseSetTest2() throws Exception {
    PhraseSet expectedResponse =
        PhraseSet.newBuilder()
            .setName(PhraseSetName.of("[PROJECT]", "[LOCATION]", "[PHRASE_SET]").toString())
            .addAllPhrases(new ArrayList<PhraseSet.Phrase>())
            .setBoost(93922211)
            .build();
    mockAdaptation.addResponse(expectedResponse);

    String parent = "parent-995424086";
    PhraseSet phraseSet = PhraseSet.newBuilder().build();
    String phraseSetId = "phraseSetId959902180";

    PhraseSet actualResponse = client.createPhraseSet(parent, phraseSet, phraseSetId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAdaptation.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreatePhraseSetRequest actualRequest = ((CreatePhraseSetRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(phraseSet, actualRequest.getPhraseSet());
    Assert.assertEquals(phraseSetId, actualRequest.getPhraseSetId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createPhraseSetExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAdaptation.addException(exception);

    try {
      String parent = "parent-995424086";
      PhraseSet phraseSet = PhraseSet.newBuilder().build();
      String phraseSetId = "phraseSetId959902180";
      client.createPhraseSet(parent, phraseSet, phraseSetId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getPhraseSetTest() throws Exception {
    PhraseSet expectedResponse =
        PhraseSet.newBuilder()
            .setName(PhraseSetName.of("[PROJECT]", "[LOCATION]", "[PHRASE_SET]").toString())
            .addAllPhrases(new ArrayList<PhraseSet.Phrase>())
            .setBoost(93922211)
            .build();
    mockAdaptation.addResponse(expectedResponse);

    PhraseSetName name = PhraseSetName.of("[PROJECT]", "[LOCATION]", "[PHRASE_SET]");

    PhraseSet actualResponse = client.getPhraseSet(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAdaptation.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetPhraseSetRequest actualRequest = ((GetPhraseSetRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getPhraseSetExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAdaptation.addException(exception);

    try {
      PhraseSetName name = PhraseSetName.of("[PROJECT]", "[LOCATION]", "[PHRASE_SET]");
      client.getPhraseSet(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getPhraseSetTest2() throws Exception {
    PhraseSet expectedResponse =
        PhraseSet.newBuilder()
            .setName(PhraseSetName.of("[PROJECT]", "[LOCATION]", "[PHRASE_SET]").toString())
            .addAllPhrases(new ArrayList<PhraseSet.Phrase>())
            .setBoost(93922211)
            .build();
    mockAdaptation.addResponse(expectedResponse);

    String name = "name3373707";

    PhraseSet actualResponse = client.getPhraseSet(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAdaptation.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetPhraseSetRequest actualRequest = ((GetPhraseSetRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getPhraseSetExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAdaptation.addException(exception);

    try {
      String name = "name3373707";
      client.getPhraseSet(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listPhraseSetTest() throws Exception {
    PhraseSet responsesElement = PhraseSet.newBuilder().build();
    ListPhraseSetResponse expectedResponse =
        ListPhraseSetResponse.newBuilder()
            .setNextPageToken("")
            .addAllPhraseSets(Arrays.asList(responsesElement))
            .build();
    mockAdaptation.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListPhraseSetPagedResponse pagedListResponse = client.listPhraseSet(parent);

    List<PhraseSet> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPhraseSetsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAdaptation.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListPhraseSetRequest actualRequest = ((ListPhraseSetRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listPhraseSetExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAdaptation.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listPhraseSet(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listPhraseSetTest2() throws Exception {
    PhraseSet responsesElement = PhraseSet.newBuilder().build();
    ListPhraseSetResponse expectedResponse =
        ListPhraseSetResponse.newBuilder()
            .setNextPageToken("")
            .addAllPhraseSets(Arrays.asList(responsesElement))
            .build();
    mockAdaptation.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListPhraseSetPagedResponse pagedListResponse = client.listPhraseSet(parent);

    List<PhraseSet> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPhraseSetsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAdaptation.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListPhraseSetRequest actualRequest = ((ListPhraseSetRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listPhraseSetExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAdaptation.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listPhraseSet(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updatePhraseSetTest() throws Exception {
    PhraseSet expectedResponse =
        PhraseSet.newBuilder()
            .setName(PhraseSetName.of("[PROJECT]", "[LOCATION]", "[PHRASE_SET]").toString())
            .addAllPhrases(new ArrayList<PhraseSet.Phrase>())
            .setBoost(93922211)
            .build();
    mockAdaptation.addResponse(expectedResponse);

    PhraseSet phraseSet = PhraseSet.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    PhraseSet actualResponse = client.updatePhraseSet(phraseSet, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAdaptation.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdatePhraseSetRequest actualRequest = ((UpdatePhraseSetRequest) actualRequests.get(0));

    Assert.assertEquals(phraseSet, actualRequest.getPhraseSet());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updatePhraseSetExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAdaptation.addException(exception);

    try {
      PhraseSet phraseSet = PhraseSet.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updatePhraseSet(phraseSet, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deletePhraseSetTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockAdaptation.addResponse(expectedResponse);

    PhraseSetName name = PhraseSetName.of("[PROJECT]", "[LOCATION]", "[PHRASE_SET]");

    client.deletePhraseSet(name);

    List<AbstractMessage> actualRequests = mockAdaptation.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeletePhraseSetRequest actualRequest = ((DeletePhraseSetRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deletePhraseSetExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAdaptation.addException(exception);

    try {
      PhraseSetName name = PhraseSetName.of("[PROJECT]", "[LOCATION]", "[PHRASE_SET]");
      client.deletePhraseSet(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deletePhraseSetTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockAdaptation.addResponse(expectedResponse);

    String name = "name3373707";

    client.deletePhraseSet(name);

    List<AbstractMessage> actualRequests = mockAdaptation.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeletePhraseSetRequest actualRequest = ((DeletePhraseSetRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deletePhraseSetExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAdaptation.addException(exception);

    try {
      String name = "name3373707";
      client.deletePhraseSet(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createCustomClassTest() throws Exception {
    CustomClass expectedResponse =
        CustomClass.newBuilder()
            .setName(CustomClassName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_CLASS]").toString())
            .setCustomClassId("customClassId1871032322")
            .addAllItems(new ArrayList<CustomClass.ClassItem>())
            .build();
    mockAdaptation.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    CustomClass customClass = CustomClass.newBuilder().build();
    String customClassId = "customClassId1871032322";

    CustomClass actualResponse = client.createCustomClass(parent, customClass, customClassId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAdaptation.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateCustomClassRequest actualRequest = ((CreateCustomClassRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(customClass, actualRequest.getCustomClass());
    Assert.assertEquals(customClassId, actualRequest.getCustomClassId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createCustomClassExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAdaptation.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      CustomClass customClass = CustomClass.newBuilder().build();
      String customClassId = "customClassId1871032322";
      client.createCustomClass(parent, customClass, customClassId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createCustomClassTest2() throws Exception {
    CustomClass expectedResponse =
        CustomClass.newBuilder()
            .setName(CustomClassName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_CLASS]").toString())
            .setCustomClassId("customClassId1871032322")
            .addAllItems(new ArrayList<CustomClass.ClassItem>())
            .build();
    mockAdaptation.addResponse(expectedResponse);

    String parent = "parent-995424086";
    CustomClass customClass = CustomClass.newBuilder().build();
    String customClassId = "customClassId1871032322";

    CustomClass actualResponse = client.createCustomClass(parent, customClass, customClassId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAdaptation.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateCustomClassRequest actualRequest = ((CreateCustomClassRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(customClass, actualRequest.getCustomClass());
    Assert.assertEquals(customClassId, actualRequest.getCustomClassId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createCustomClassExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAdaptation.addException(exception);

    try {
      String parent = "parent-995424086";
      CustomClass customClass = CustomClass.newBuilder().build();
      String customClassId = "customClassId1871032322";
      client.createCustomClass(parent, customClass, customClassId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getCustomClassTest() throws Exception {
    CustomClass expectedResponse =
        CustomClass.newBuilder()
            .setName(CustomClassName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_CLASS]").toString())
            .setCustomClassId("customClassId1871032322")
            .addAllItems(new ArrayList<CustomClass.ClassItem>())
            .build();
    mockAdaptation.addResponse(expectedResponse);

    CustomClassName name = CustomClassName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_CLASS]");

    CustomClass actualResponse = client.getCustomClass(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAdaptation.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetCustomClassRequest actualRequest = ((GetCustomClassRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getCustomClassExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAdaptation.addException(exception);

    try {
      CustomClassName name = CustomClassName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_CLASS]");
      client.getCustomClass(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getCustomClassTest2() throws Exception {
    CustomClass expectedResponse =
        CustomClass.newBuilder()
            .setName(CustomClassName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_CLASS]").toString())
            .setCustomClassId("customClassId1871032322")
            .addAllItems(new ArrayList<CustomClass.ClassItem>())
            .build();
    mockAdaptation.addResponse(expectedResponse);

    String name = "name3373707";

    CustomClass actualResponse = client.getCustomClass(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAdaptation.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetCustomClassRequest actualRequest = ((GetCustomClassRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getCustomClassExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAdaptation.addException(exception);

    try {
      String name = "name3373707";
      client.getCustomClass(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listCustomClassesTest() throws Exception {
    CustomClass responsesElement = CustomClass.newBuilder().build();
    ListCustomClassesResponse expectedResponse =
        ListCustomClassesResponse.newBuilder()
            .setNextPageToken("")
            .addAllCustomClasses(Arrays.asList(responsesElement))
            .build();
    mockAdaptation.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListCustomClassesPagedResponse pagedListResponse = client.listCustomClasses(parent);

    List<CustomClass> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCustomClassesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAdaptation.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListCustomClassesRequest actualRequest = ((ListCustomClassesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listCustomClassesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAdaptation.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listCustomClasses(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listCustomClassesTest2() throws Exception {
    CustomClass responsesElement = CustomClass.newBuilder().build();
    ListCustomClassesResponse expectedResponse =
        ListCustomClassesResponse.newBuilder()
            .setNextPageToken("")
            .addAllCustomClasses(Arrays.asList(responsesElement))
            .build();
    mockAdaptation.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListCustomClassesPagedResponse pagedListResponse = client.listCustomClasses(parent);

    List<CustomClass> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCustomClassesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAdaptation.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListCustomClassesRequest actualRequest = ((ListCustomClassesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listCustomClassesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAdaptation.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listCustomClasses(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateCustomClassTest() throws Exception {
    CustomClass expectedResponse =
        CustomClass.newBuilder()
            .setName(CustomClassName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_CLASS]").toString())
            .setCustomClassId("customClassId1871032322")
            .addAllItems(new ArrayList<CustomClass.ClassItem>())
            .build();
    mockAdaptation.addResponse(expectedResponse);

    CustomClass customClass = CustomClass.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    CustomClass actualResponse = client.updateCustomClass(customClass, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAdaptation.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateCustomClassRequest actualRequest = ((UpdateCustomClassRequest) actualRequests.get(0));

    Assert.assertEquals(customClass, actualRequest.getCustomClass());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateCustomClassExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAdaptation.addException(exception);

    try {
      CustomClass customClass = CustomClass.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateCustomClass(customClass, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteCustomClassTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockAdaptation.addResponse(expectedResponse);

    CustomClassName name = CustomClassName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_CLASS]");

    client.deleteCustomClass(name);

    List<AbstractMessage> actualRequests = mockAdaptation.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteCustomClassRequest actualRequest = ((DeleteCustomClassRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteCustomClassExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAdaptation.addException(exception);

    try {
      CustomClassName name = CustomClassName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_CLASS]");
      client.deleteCustomClass(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteCustomClassTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockAdaptation.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteCustomClass(name);

    List<AbstractMessage> actualRequests = mockAdaptation.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteCustomClassRequest actualRequest = ((DeleteCustomClassRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteCustomClassExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAdaptation.addException(exception);

    try {
      String name = "name3373707";
      client.deleteCustomClass(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
