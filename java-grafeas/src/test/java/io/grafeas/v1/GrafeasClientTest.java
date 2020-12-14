/*
 * Copyright 2020 Google LLC
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

package io.grafeas.v1;

import static io.grafeas.v1.GrafeasClient.ListNoteOccurrencesPagedResponse;
import static io.grafeas.v1.GrafeasClient.ListNotesPagedResponse;
import static io.grafeas.v1.GrafeasClient.ListOccurrencesPagedResponse;

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
import com.google.protobuf.Timestamp;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class GrafeasClientTest {
  private static MockServiceHelper mockServiceHelper;
  private GrafeasClient client;
  private static MockGrafeas mockGrafeas;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockGrafeas = new MockGrafeas();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockGrafeas));
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
    GrafeasSettings settings =
        GrafeasSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = GrafeasClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void getOccurrenceTest() throws Exception {
    Occurrence expectedResponse =
        Occurrence.newBuilder()
            .setName(OccurrenceName.of("[PROJECT]", "[OCCURRENCE]").toString())
            .setResourceUri("resourceUri1234527870")
            .setNoteName("noteName1580946845")
            .setRemediation("remediation779381797")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockGrafeas.addResponse(expectedResponse);

    OccurrenceName name = OccurrenceName.of("[PROJECT]", "[OCCURRENCE]");

    Occurrence actualResponse = client.getOccurrence(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGrafeas.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetOccurrenceRequest actualRequest = ((GetOccurrenceRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getOccurrenceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGrafeas.addException(exception);

    try {
      OccurrenceName name = OccurrenceName.of("[PROJECT]", "[OCCURRENCE]");
      client.getOccurrence(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getOccurrenceTest2() throws Exception {
    Occurrence expectedResponse =
        Occurrence.newBuilder()
            .setName(OccurrenceName.of("[PROJECT]", "[OCCURRENCE]").toString())
            .setResourceUri("resourceUri1234527870")
            .setNoteName("noteName1580946845")
            .setRemediation("remediation779381797")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockGrafeas.addResponse(expectedResponse);

    String name = "name3373707";

    Occurrence actualResponse = client.getOccurrence(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGrafeas.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetOccurrenceRequest actualRequest = ((GetOccurrenceRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getOccurrenceExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGrafeas.addException(exception);

    try {
      String name = "name3373707";
      client.getOccurrence(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listOccurrencesTest() throws Exception {
    Occurrence responsesElement = Occurrence.newBuilder().build();
    ListOccurrencesResponse expectedResponse =
        ListOccurrencesResponse.newBuilder()
            .setNextPageToken("")
            .addAllOccurrences(Arrays.asList(responsesElement))
            .build();
    mockGrafeas.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");
    String filter = "filter-1274492040";

    ListOccurrencesPagedResponse pagedListResponse = client.listOccurrences(parent, filter);

    List<Occurrence> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getOccurrencesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockGrafeas.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListOccurrencesRequest actualRequest = ((ListOccurrencesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(filter, actualRequest.getFilter());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listOccurrencesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGrafeas.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      String filter = "filter-1274492040";
      client.listOccurrences(parent, filter);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listOccurrencesTest2() throws Exception {
    Occurrence responsesElement = Occurrence.newBuilder().build();
    ListOccurrencesResponse expectedResponse =
        ListOccurrencesResponse.newBuilder()
            .setNextPageToken("")
            .addAllOccurrences(Arrays.asList(responsesElement))
            .build();
    mockGrafeas.addResponse(expectedResponse);

    String parent = "parent-995424086";
    String filter = "filter-1274492040";

    ListOccurrencesPagedResponse pagedListResponse = client.listOccurrences(parent, filter);

    List<Occurrence> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getOccurrencesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockGrafeas.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListOccurrencesRequest actualRequest = ((ListOccurrencesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(filter, actualRequest.getFilter());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listOccurrencesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGrafeas.addException(exception);

    try {
      String parent = "parent-995424086";
      String filter = "filter-1274492040";
      client.listOccurrences(parent, filter);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteOccurrenceTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockGrafeas.addResponse(expectedResponse);

    OccurrenceName name = OccurrenceName.of("[PROJECT]", "[OCCURRENCE]");

    client.deleteOccurrence(name);

    List<AbstractMessage> actualRequests = mockGrafeas.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteOccurrenceRequest actualRequest = ((DeleteOccurrenceRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteOccurrenceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGrafeas.addException(exception);

    try {
      OccurrenceName name = OccurrenceName.of("[PROJECT]", "[OCCURRENCE]");
      client.deleteOccurrence(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteOccurrenceTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockGrafeas.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteOccurrence(name);

    List<AbstractMessage> actualRequests = mockGrafeas.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteOccurrenceRequest actualRequest = ((DeleteOccurrenceRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteOccurrenceExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGrafeas.addException(exception);

    try {
      String name = "name3373707";
      client.deleteOccurrence(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createOccurrenceTest() throws Exception {
    Occurrence expectedResponse =
        Occurrence.newBuilder()
            .setName(OccurrenceName.of("[PROJECT]", "[OCCURRENCE]").toString())
            .setResourceUri("resourceUri1234527870")
            .setNoteName("noteName1580946845")
            .setRemediation("remediation779381797")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockGrafeas.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");
    Occurrence occurrence = Occurrence.newBuilder().build();

    Occurrence actualResponse = client.createOccurrence(parent, occurrence);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGrafeas.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateOccurrenceRequest actualRequest = ((CreateOccurrenceRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(occurrence, actualRequest.getOccurrence());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createOccurrenceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGrafeas.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      Occurrence occurrence = Occurrence.newBuilder().build();
      client.createOccurrence(parent, occurrence);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createOccurrenceTest2() throws Exception {
    Occurrence expectedResponse =
        Occurrence.newBuilder()
            .setName(OccurrenceName.of("[PROJECT]", "[OCCURRENCE]").toString())
            .setResourceUri("resourceUri1234527870")
            .setNoteName("noteName1580946845")
            .setRemediation("remediation779381797")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockGrafeas.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Occurrence occurrence = Occurrence.newBuilder().build();

    Occurrence actualResponse = client.createOccurrence(parent, occurrence);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGrafeas.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateOccurrenceRequest actualRequest = ((CreateOccurrenceRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(occurrence, actualRequest.getOccurrence());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createOccurrenceExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGrafeas.addException(exception);

    try {
      String parent = "parent-995424086";
      Occurrence occurrence = Occurrence.newBuilder().build();
      client.createOccurrence(parent, occurrence);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchCreateOccurrencesTest() throws Exception {
    BatchCreateOccurrencesResponse expectedResponse =
        BatchCreateOccurrencesResponse.newBuilder()
            .addAllOccurrences(new ArrayList<Occurrence>())
            .build();
    mockGrafeas.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");
    List<Occurrence> occurrences = new ArrayList<>();

    BatchCreateOccurrencesResponse actualResponse =
        client.batchCreateOccurrences(parent, occurrences);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGrafeas.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchCreateOccurrencesRequest actualRequest =
        ((BatchCreateOccurrencesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(occurrences, actualRequest.getOccurrencesList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void batchCreateOccurrencesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGrafeas.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      List<Occurrence> occurrences = new ArrayList<>();
      client.batchCreateOccurrences(parent, occurrences);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchCreateOccurrencesTest2() throws Exception {
    BatchCreateOccurrencesResponse expectedResponse =
        BatchCreateOccurrencesResponse.newBuilder()
            .addAllOccurrences(new ArrayList<Occurrence>())
            .build();
    mockGrafeas.addResponse(expectedResponse);

    String parent = "parent-995424086";
    List<Occurrence> occurrences = new ArrayList<>();

    BatchCreateOccurrencesResponse actualResponse =
        client.batchCreateOccurrences(parent, occurrences);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGrafeas.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchCreateOccurrencesRequest actualRequest =
        ((BatchCreateOccurrencesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(occurrences, actualRequest.getOccurrencesList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void batchCreateOccurrencesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGrafeas.addException(exception);

    try {
      String parent = "parent-995424086";
      List<Occurrence> occurrences = new ArrayList<>();
      client.batchCreateOccurrences(parent, occurrences);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateOccurrenceTest() throws Exception {
    Occurrence expectedResponse =
        Occurrence.newBuilder()
            .setName(OccurrenceName.of("[PROJECT]", "[OCCURRENCE]").toString())
            .setResourceUri("resourceUri1234527870")
            .setNoteName("noteName1580946845")
            .setRemediation("remediation779381797")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockGrafeas.addResponse(expectedResponse);

    OccurrenceName name = OccurrenceName.of("[PROJECT]", "[OCCURRENCE]");
    Occurrence occurrence = Occurrence.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Occurrence actualResponse = client.updateOccurrence(name, occurrence, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGrafeas.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateOccurrenceRequest actualRequest = ((UpdateOccurrenceRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(occurrence, actualRequest.getOccurrence());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateOccurrenceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGrafeas.addException(exception);

    try {
      OccurrenceName name = OccurrenceName.of("[PROJECT]", "[OCCURRENCE]");
      Occurrence occurrence = Occurrence.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateOccurrence(name, occurrence, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateOccurrenceTest2() throws Exception {
    Occurrence expectedResponse =
        Occurrence.newBuilder()
            .setName(OccurrenceName.of("[PROJECT]", "[OCCURRENCE]").toString())
            .setResourceUri("resourceUri1234527870")
            .setNoteName("noteName1580946845")
            .setRemediation("remediation779381797")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockGrafeas.addResponse(expectedResponse);

    String name = "name3373707";
    Occurrence occurrence = Occurrence.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Occurrence actualResponse = client.updateOccurrence(name, occurrence, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGrafeas.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateOccurrenceRequest actualRequest = ((UpdateOccurrenceRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(occurrence, actualRequest.getOccurrence());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateOccurrenceExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGrafeas.addException(exception);

    try {
      String name = "name3373707";
      Occurrence occurrence = Occurrence.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateOccurrence(name, occurrence, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getOccurrenceNoteTest() throws Exception {
    Note expectedResponse =
        Note.newBuilder()
            .setName(NoteName.of("[PROJECT]", "[NOTE]").toString())
            .setShortDescription("shortDescription1951089120")
            .setLongDescription("longDescription1763753952")
            .addAllRelatedUrl(new ArrayList<RelatedUrl>())
            .setExpirationTime(Timestamp.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllRelatedNoteNames(new ArrayList<String>())
            .build();
    mockGrafeas.addResponse(expectedResponse);

    OccurrenceName name = OccurrenceName.of("[PROJECT]", "[OCCURRENCE]");

    Note actualResponse = client.getOccurrenceNote(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGrafeas.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetOccurrenceNoteRequest actualRequest = ((GetOccurrenceNoteRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getOccurrenceNoteExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGrafeas.addException(exception);

    try {
      OccurrenceName name = OccurrenceName.of("[PROJECT]", "[OCCURRENCE]");
      client.getOccurrenceNote(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getOccurrenceNoteTest2() throws Exception {
    Note expectedResponse =
        Note.newBuilder()
            .setName(NoteName.of("[PROJECT]", "[NOTE]").toString())
            .setShortDescription("shortDescription1951089120")
            .setLongDescription("longDescription1763753952")
            .addAllRelatedUrl(new ArrayList<RelatedUrl>())
            .setExpirationTime(Timestamp.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllRelatedNoteNames(new ArrayList<String>())
            .build();
    mockGrafeas.addResponse(expectedResponse);

    String name = "name3373707";

    Note actualResponse = client.getOccurrenceNote(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGrafeas.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetOccurrenceNoteRequest actualRequest = ((GetOccurrenceNoteRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getOccurrenceNoteExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGrafeas.addException(exception);

    try {
      String name = "name3373707";
      client.getOccurrenceNote(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getNoteTest() throws Exception {
    Note expectedResponse =
        Note.newBuilder()
            .setName(NoteName.of("[PROJECT]", "[NOTE]").toString())
            .setShortDescription("shortDescription1951089120")
            .setLongDescription("longDescription1763753952")
            .addAllRelatedUrl(new ArrayList<RelatedUrl>())
            .setExpirationTime(Timestamp.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllRelatedNoteNames(new ArrayList<String>())
            .build();
    mockGrafeas.addResponse(expectedResponse);

    NoteName name = NoteName.of("[PROJECT]", "[NOTE]");

    Note actualResponse = client.getNote(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGrafeas.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetNoteRequest actualRequest = ((GetNoteRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getNoteExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGrafeas.addException(exception);

    try {
      NoteName name = NoteName.of("[PROJECT]", "[NOTE]");
      client.getNote(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getNoteTest2() throws Exception {
    Note expectedResponse =
        Note.newBuilder()
            .setName(NoteName.of("[PROJECT]", "[NOTE]").toString())
            .setShortDescription("shortDescription1951089120")
            .setLongDescription("longDescription1763753952")
            .addAllRelatedUrl(new ArrayList<RelatedUrl>())
            .setExpirationTime(Timestamp.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllRelatedNoteNames(new ArrayList<String>())
            .build();
    mockGrafeas.addResponse(expectedResponse);

    String name = "name3373707";

    Note actualResponse = client.getNote(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGrafeas.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetNoteRequest actualRequest = ((GetNoteRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getNoteExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGrafeas.addException(exception);

    try {
      String name = "name3373707";
      client.getNote(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listNotesTest() throws Exception {
    Note responsesElement = Note.newBuilder().build();
    ListNotesResponse expectedResponse =
        ListNotesResponse.newBuilder()
            .setNextPageToken("")
            .addAllNotes(Arrays.asList(responsesElement))
            .build();
    mockGrafeas.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");
    String filter = "filter-1274492040";

    ListNotesPagedResponse pagedListResponse = client.listNotes(parent, filter);

    List<Note> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getNotesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockGrafeas.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListNotesRequest actualRequest = ((ListNotesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(filter, actualRequest.getFilter());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listNotesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGrafeas.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      String filter = "filter-1274492040";
      client.listNotes(parent, filter);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listNotesTest2() throws Exception {
    Note responsesElement = Note.newBuilder().build();
    ListNotesResponse expectedResponse =
        ListNotesResponse.newBuilder()
            .setNextPageToken("")
            .addAllNotes(Arrays.asList(responsesElement))
            .build();
    mockGrafeas.addResponse(expectedResponse);

    String parent = "parent-995424086";
    String filter = "filter-1274492040";

    ListNotesPagedResponse pagedListResponse = client.listNotes(parent, filter);

    List<Note> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getNotesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockGrafeas.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListNotesRequest actualRequest = ((ListNotesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(filter, actualRequest.getFilter());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listNotesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGrafeas.addException(exception);

    try {
      String parent = "parent-995424086";
      String filter = "filter-1274492040";
      client.listNotes(parent, filter);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteNoteTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockGrafeas.addResponse(expectedResponse);

    NoteName name = NoteName.of("[PROJECT]", "[NOTE]");

    client.deleteNote(name);

    List<AbstractMessage> actualRequests = mockGrafeas.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteNoteRequest actualRequest = ((DeleteNoteRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteNoteExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGrafeas.addException(exception);

    try {
      NoteName name = NoteName.of("[PROJECT]", "[NOTE]");
      client.deleteNote(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteNoteTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockGrafeas.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteNote(name);

    List<AbstractMessage> actualRequests = mockGrafeas.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteNoteRequest actualRequest = ((DeleteNoteRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteNoteExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGrafeas.addException(exception);

    try {
      String name = "name3373707";
      client.deleteNote(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createNoteTest() throws Exception {
    Note expectedResponse =
        Note.newBuilder()
            .setName(NoteName.of("[PROJECT]", "[NOTE]").toString())
            .setShortDescription("shortDescription1951089120")
            .setLongDescription("longDescription1763753952")
            .addAllRelatedUrl(new ArrayList<RelatedUrl>())
            .setExpirationTime(Timestamp.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllRelatedNoteNames(new ArrayList<String>())
            .build();
    mockGrafeas.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");
    String noteId = "noteId-1039694675";
    Note note = Note.newBuilder().build();

    Note actualResponse = client.createNote(parent, noteId, note);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGrafeas.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateNoteRequest actualRequest = ((CreateNoteRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(noteId, actualRequest.getNoteId());
    Assert.assertEquals(note, actualRequest.getNote());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createNoteExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGrafeas.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      String noteId = "noteId-1039694675";
      Note note = Note.newBuilder().build();
      client.createNote(parent, noteId, note);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createNoteTest2() throws Exception {
    Note expectedResponse =
        Note.newBuilder()
            .setName(NoteName.of("[PROJECT]", "[NOTE]").toString())
            .setShortDescription("shortDescription1951089120")
            .setLongDescription("longDescription1763753952")
            .addAllRelatedUrl(new ArrayList<RelatedUrl>())
            .setExpirationTime(Timestamp.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllRelatedNoteNames(new ArrayList<String>())
            .build();
    mockGrafeas.addResponse(expectedResponse);

    String parent = "parent-995424086";
    String noteId = "noteId-1039694675";
    Note note = Note.newBuilder().build();

    Note actualResponse = client.createNote(parent, noteId, note);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGrafeas.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateNoteRequest actualRequest = ((CreateNoteRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(noteId, actualRequest.getNoteId());
    Assert.assertEquals(note, actualRequest.getNote());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createNoteExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGrafeas.addException(exception);

    try {
      String parent = "parent-995424086";
      String noteId = "noteId-1039694675";
      Note note = Note.newBuilder().build();
      client.createNote(parent, noteId, note);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchCreateNotesTest() throws Exception {
    BatchCreateNotesResponse expectedResponse =
        BatchCreateNotesResponse.newBuilder().addAllNotes(new ArrayList<Note>()).build();
    mockGrafeas.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");
    Map<String, Note> notes = new HashMap<>();

    BatchCreateNotesResponse actualResponse = client.batchCreateNotes(parent, notes);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGrafeas.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchCreateNotesRequest actualRequest = ((BatchCreateNotesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(notes, actualRequest.getNotesMap());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void batchCreateNotesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGrafeas.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      Map<String, Note> notes = new HashMap<>();
      client.batchCreateNotes(parent, notes);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchCreateNotesTest2() throws Exception {
    BatchCreateNotesResponse expectedResponse =
        BatchCreateNotesResponse.newBuilder().addAllNotes(new ArrayList<Note>()).build();
    mockGrafeas.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Map<String, Note> notes = new HashMap<>();

    BatchCreateNotesResponse actualResponse = client.batchCreateNotes(parent, notes);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGrafeas.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchCreateNotesRequest actualRequest = ((BatchCreateNotesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(notes, actualRequest.getNotesMap());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void batchCreateNotesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGrafeas.addException(exception);

    try {
      String parent = "parent-995424086";
      Map<String, Note> notes = new HashMap<>();
      client.batchCreateNotes(parent, notes);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateNoteTest() throws Exception {
    Note expectedResponse =
        Note.newBuilder()
            .setName(NoteName.of("[PROJECT]", "[NOTE]").toString())
            .setShortDescription("shortDescription1951089120")
            .setLongDescription("longDescription1763753952")
            .addAllRelatedUrl(new ArrayList<RelatedUrl>())
            .setExpirationTime(Timestamp.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllRelatedNoteNames(new ArrayList<String>())
            .build();
    mockGrafeas.addResponse(expectedResponse);

    NoteName name = NoteName.of("[PROJECT]", "[NOTE]");
    Note note = Note.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Note actualResponse = client.updateNote(name, note, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGrafeas.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateNoteRequest actualRequest = ((UpdateNoteRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(note, actualRequest.getNote());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateNoteExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGrafeas.addException(exception);

    try {
      NoteName name = NoteName.of("[PROJECT]", "[NOTE]");
      Note note = Note.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateNote(name, note, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateNoteTest2() throws Exception {
    Note expectedResponse =
        Note.newBuilder()
            .setName(NoteName.of("[PROJECT]", "[NOTE]").toString())
            .setShortDescription("shortDescription1951089120")
            .setLongDescription("longDescription1763753952")
            .addAllRelatedUrl(new ArrayList<RelatedUrl>())
            .setExpirationTime(Timestamp.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllRelatedNoteNames(new ArrayList<String>())
            .build();
    mockGrafeas.addResponse(expectedResponse);

    String name = "name3373707";
    Note note = Note.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Note actualResponse = client.updateNote(name, note, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGrafeas.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateNoteRequest actualRequest = ((UpdateNoteRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(note, actualRequest.getNote());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateNoteExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGrafeas.addException(exception);

    try {
      String name = "name3373707";
      Note note = Note.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateNote(name, note, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listNoteOccurrencesTest() throws Exception {
    Occurrence responsesElement = Occurrence.newBuilder().build();
    ListNoteOccurrencesResponse expectedResponse =
        ListNoteOccurrencesResponse.newBuilder()
            .setNextPageToken("")
            .addAllOccurrences(Arrays.asList(responsesElement))
            .build();
    mockGrafeas.addResponse(expectedResponse);

    NoteName name = NoteName.of("[PROJECT]", "[NOTE]");
    String filter = "filter-1274492040";

    ListNoteOccurrencesPagedResponse pagedListResponse = client.listNoteOccurrences(name, filter);

    List<Occurrence> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getOccurrencesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockGrafeas.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListNoteOccurrencesRequest actualRequest = ((ListNoteOccurrencesRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(filter, actualRequest.getFilter());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listNoteOccurrencesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGrafeas.addException(exception);

    try {
      NoteName name = NoteName.of("[PROJECT]", "[NOTE]");
      String filter = "filter-1274492040";
      client.listNoteOccurrences(name, filter);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listNoteOccurrencesTest2() throws Exception {
    Occurrence responsesElement = Occurrence.newBuilder().build();
    ListNoteOccurrencesResponse expectedResponse =
        ListNoteOccurrencesResponse.newBuilder()
            .setNextPageToken("")
            .addAllOccurrences(Arrays.asList(responsesElement))
            .build();
    mockGrafeas.addResponse(expectedResponse);

    String name = "name3373707";
    String filter = "filter-1274492040";

    ListNoteOccurrencesPagedResponse pagedListResponse = client.listNoteOccurrences(name, filter);

    List<Occurrence> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getOccurrencesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockGrafeas.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListNoteOccurrencesRequest actualRequest = ((ListNoteOccurrencesRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(filter, actualRequest.getFilter());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listNoteOccurrencesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGrafeas.addException(exception);

    try {
      String name = "name3373707";
      String filter = "filter-1274492040";
      client.listNoteOccurrences(name, filter);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
