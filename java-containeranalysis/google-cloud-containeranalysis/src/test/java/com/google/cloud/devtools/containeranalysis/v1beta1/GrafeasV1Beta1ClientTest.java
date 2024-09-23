/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.devtools.containeranalysis.v1beta1;

import static com.google.cloud.devtools.containeranalysis.v1beta1.GrafeasV1Beta1Client.ListNoteOccurrencesPagedResponse;
import static com.google.cloud.devtools.containeranalysis.v1beta1.GrafeasV1Beta1Client.ListNotesPagedResponse;
import static com.google.cloud.devtools.containeranalysis.v1beta1.GrafeasV1Beta1Client.ListOccurrencesPagedResponse;

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
import io.grafeas.v1beta1.BatchCreateNotesRequest;
import io.grafeas.v1beta1.BatchCreateNotesResponse;
import io.grafeas.v1beta1.BatchCreateOccurrencesRequest;
import io.grafeas.v1beta1.BatchCreateOccurrencesResponse;
import io.grafeas.v1beta1.CreateNoteRequest;
import io.grafeas.v1beta1.CreateOccurrenceRequest;
import io.grafeas.v1beta1.DeleteNoteRequest;
import io.grafeas.v1beta1.DeleteOccurrenceRequest;
import io.grafeas.v1beta1.GetNoteRequest;
import io.grafeas.v1beta1.GetOccurrenceNoteRequest;
import io.grafeas.v1beta1.GetOccurrenceRequest;
import io.grafeas.v1beta1.GetVulnerabilityOccurrencesSummaryRequest;
import io.grafeas.v1beta1.ListNoteOccurrencesRequest;
import io.grafeas.v1beta1.ListNoteOccurrencesResponse;
import io.grafeas.v1beta1.ListNotesRequest;
import io.grafeas.v1beta1.ListNotesResponse;
import io.grafeas.v1beta1.ListOccurrencesRequest;
import io.grafeas.v1beta1.ListOccurrencesResponse;
import io.grafeas.v1beta1.Note;
import io.grafeas.v1beta1.Occurrence;
import io.grafeas.v1beta1.Resource;
import io.grafeas.v1beta1.UpdateNoteRequest;
import io.grafeas.v1beta1.UpdateOccurrenceRequest;
import io.grafeas.v1beta1.VulnerabilityOccurrencesSummary;
import io.grafeas.v1beta1.common.NoteKind;
import io.grafeas.v1beta1.common.RelatedUrl;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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
public class GrafeasV1Beta1ClientTest {
  private static MockGrafeasV1Beta1 mockGrafeasV1Beta1;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private GrafeasV1Beta1Client client;

  @BeforeClass
  public static void startStaticServer() {
    mockGrafeasV1Beta1 = new MockGrafeasV1Beta1();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockGrafeasV1Beta1));
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
    GrafeasV1Beta1Settings settings =
        GrafeasV1Beta1Settings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = GrafeasV1Beta1Client.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void getOccurrenceTest() throws Exception {
    Occurrence expectedResponse =
        Occurrence.newBuilder()
            .setName("name3373707")
            .setResource(Resource.newBuilder().build())
            .setNoteName("noteName1580946845")
            .setKind(NoteKind.forNumber(0))
            .setRemediation("remediation779381797")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockGrafeasV1Beta1.addResponse(expectedResponse);

    GetOccurrenceRequest request = GetOccurrenceRequest.newBuilder().setName("name3373707").build();

    Occurrence actualResponse = client.getOccurrence(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGrafeasV1Beta1.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetOccurrenceRequest actualRequest = ((GetOccurrenceRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getOccurrenceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGrafeasV1Beta1.addException(exception);

    try {
      GetOccurrenceRequest request =
          GetOccurrenceRequest.newBuilder().setName("name3373707").build();
      client.getOccurrence(request);
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
    mockGrafeasV1Beta1.addResponse(expectedResponse);

    ListOccurrencesRequest request =
        ListOccurrencesRequest.newBuilder()
            .setParent("parent-995424086")
            .setFilter("filter-1274492040")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    ListOccurrencesPagedResponse pagedListResponse = client.listOccurrences(request);

    List<Occurrence> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getOccurrencesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockGrafeasV1Beta1.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListOccurrencesRequest actualRequest = ((ListOccurrencesRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getFilter(), actualRequest.getFilter());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listOccurrencesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGrafeasV1Beta1.addException(exception);

    try {
      ListOccurrencesRequest request =
          ListOccurrencesRequest.newBuilder()
              .setParent("parent-995424086")
              .setFilter("filter-1274492040")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      client.listOccurrences(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteOccurrenceTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockGrafeasV1Beta1.addResponse(expectedResponse);

    DeleteOccurrenceRequest request =
        DeleteOccurrenceRequest.newBuilder().setName("name3373707").build();

    client.deleteOccurrence(request);

    List<AbstractMessage> actualRequests = mockGrafeasV1Beta1.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteOccurrenceRequest actualRequest = ((DeleteOccurrenceRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteOccurrenceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGrafeasV1Beta1.addException(exception);

    try {
      DeleteOccurrenceRequest request =
          DeleteOccurrenceRequest.newBuilder().setName("name3373707").build();
      client.deleteOccurrence(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createOccurrenceTest() throws Exception {
    Occurrence expectedResponse =
        Occurrence.newBuilder()
            .setName("name3373707")
            .setResource(Resource.newBuilder().build())
            .setNoteName("noteName1580946845")
            .setKind(NoteKind.forNumber(0))
            .setRemediation("remediation779381797")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockGrafeasV1Beta1.addResponse(expectedResponse);

    CreateOccurrenceRequest request =
        CreateOccurrenceRequest.newBuilder()
            .setParent("parent-995424086")
            .setOccurrence(Occurrence.newBuilder().build())
            .build();

    Occurrence actualResponse = client.createOccurrence(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGrafeasV1Beta1.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateOccurrenceRequest actualRequest = ((CreateOccurrenceRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getOccurrence(), actualRequest.getOccurrence());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createOccurrenceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGrafeasV1Beta1.addException(exception);

    try {
      CreateOccurrenceRequest request =
          CreateOccurrenceRequest.newBuilder()
              .setParent("parent-995424086")
              .setOccurrence(Occurrence.newBuilder().build())
              .build();
      client.createOccurrence(request);
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
    mockGrafeasV1Beta1.addResponse(expectedResponse);

    BatchCreateOccurrencesRequest request =
        BatchCreateOccurrencesRequest.newBuilder()
            .setParent("parent-995424086")
            .addAllOccurrences(new ArrayList<Occurrence>())
            .build();

    BatchCreateOccurrencesResponse actualResponse = client.batchCreateOccurrences(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGrafeasV1Beta1.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchCreateOccurrencesRequest actualRequest =
        ((BatchCreateOccurrencesRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getOccurrencesList(), actualRequest.getOccurrencesList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void batchCreateOccurrencesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGrafeasV1Beta1.addException(exception);

    try {
      BatchCreateOccurrencesRequest request =
          BatchCreateOccurrencesRequest.newBuilder()
              .setParent("parent-995424086")
              .addAllOccurrences(new ArrayList<Occurrence>())
              .build();
      client.batchCreateOccurrences(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateOccurrenceTest() throws Exception {
    Occurrence expectedResponse =
        Occurrence.newBuilder()
            .setName("name3373707")
            .setResource(Resource.newBuilder().build())
            .setNoteName("noteName1580946845")
            .setKind(NoteKind.forNumber(0))
            .setRemediation("remediation779381797")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockGrafeasV1Beta1.addResponse(expectedResponse);

    UpdateOccurrenceRequest request =
        UpdateOccurrenceRequest.newBuilder()
            .setName("name3373707")
            .setOccurrence(Occurrence.newBuilder().build())
            .setUpdateMask(FieldMask.newBuilder().build())
            .build();

    Occurrence actualResponse = client.updateOccurrence(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGrafeasV1Beta1.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateOccurrenceRequest actualRequest = ((UpdateOccurrenceRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getOccurrence(), actualRequest.getOccurrence());
    Assert.assertEquals(request.getUpdateMask(), actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateOccurrenceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGrafeasV1Beta1.addException(exception);

    try {
      UpdateOccurrenceRequest request =
          UpdateOccurrenceRequest.newBuilder()
              .setName("name3373707")
              .setOccurrence(Occurrence.newBuilder().build())
              .setUpdateMask(FieldMask.newBuilder().build())
              .build();
      client.updateOccurrence(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getOccurrenceNoteTest() throws Exception {
    Note expectedResponse =
        Note.newBuilder()
            .setName("name3373707")
            .setShortDescription("shortDescription1951089120")
            .setLongDescription("longDescription1763753952")
            .setKind(NoteKind.forNumber(0))
            .addAllRelatedUrl(new ArrayList<RelatedUrl>())
            .setExpirationTime(Timestamp.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllRelatedNoteNames(new ArrayList<String>())
            .build();
    mockGrafeasV1Beta1.addResponse(expectedResponse);

    GetOccurrenceNoteRequest request =
        GetOccurrenceNoteRequest.newBuilder().setName("name3373707").build();

    Note actualResponse = client.getOccurrenceNote(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGrafeasV1Beta1.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetOccurrenceNoteRequest actualRequest = ((GetOccurrenceNoteRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getOccurrenceNoteExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGrafeasV1Beta1.addException(exception);

    try {
      GetOccurrenceNoteRequest request =
          GetOccurrenceNoteRequest.newBuilder().setName("name3373707").build();
      client.getOccurrenceNote(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getNoteTest() throws Exception {
    Note expectedResponse =
        Note.newBuilder()
            .setName("name3373707")
            .setShortDescription("shortDescription1951089120")
            .setLongDescription("longDescription1763753952")
            .setKind(NoteKind.forNumber(0))
            .addAllRelatedUrl(new ArrayList<RelatedUrl>())
            .setExpirationTime(Timestamp.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllRelatedNoteNames(new ArrayList<String>())
            .build();
    mockGrafeasV1Beta1.addResponse(expectedResponse);

    GetNoteRequest request = GetNoteRequest.newBuilder().setName("name3373707").build();

    Note actualResponse = client.getNote(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGrafeasV1Beta1.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetNoteRequest actualRequest = ((GetNoteRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getNoteExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGrafeasV1Beta1.addException(exception);

    try {
      GetNoteRequest request = GetNoteRequest.newBuilder().setName("name3373707").build();
      client.getNote(request);
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
    mockGrafeasV1Beta1.addResponse(expectedResponse);

    ListNotesRequest request =
        ListNotesRequest.newBuilder()
            .setParent("parent-995424086")
            .setFilter("filter-1274492040")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    ListNotesPagedResponse pagedListResponse = client.listNotes(request);

    List<Note> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getNotesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockGrafeasV1Beta1.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListNotesRequest actualRequest = ((ListNotesRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getFilter(), actualRequest.getFilter());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listNotesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGrafeasV1Beta1.addException(exception);

    try {
      ListNotesRequest request =
          ListNotesRequest.newBuilder()
              .setParent("parent-995424086")
              .setFilter("filter-1274492040")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      client.listNotes(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteNoteTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockGrafeasV1Beta1.addResponse(expectedResponse);

    DeleteNoteRequest request = DeleteNoteRequest.newBuilder().setName("name3373707").build();

    client.deleteNote(request);

    List<AbstractMessage> actualRequests = mockGrafeasV1Beta1.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteNoteRequest actualRequest = ((DeleteNoteRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteNoteExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGrafeasV1Beta1.addException(exception);

    try {
      DeleteNoteRequest request = DeleteNoteRequest.newBuilder().setName("name3373707").build();
      client.deleteNote(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createNoteTest() throws Exception {
    Note expectedResponse =
        Note.newBuilder()
            .setName("name3373707")
            .setShortDescription("shortDescription1951089120")
            .setLongDescription("longDescription1763753952")
            .setKind(NoteKind.forNumber(0))
            .addAllRelatedUrl(new ArrayList<RelatedUrl>())
            .setExpirationTime(Timestamp.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllRelatedNoteNames(new ArrayList<String>())
            .build();
    mockGrafeasV1Beta1.addResponse(expectedResponse);

    CreateNoteRequest request =
        CreateNoteRequest.newBuilder()
            .setParent("parent-995424086")
            .setNoteId("noteId-1039694675")
            .setNote(Note.newBuilder().build())
            .build();

    Note actualResponse = client.createNote(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGrafeasV1Beta1.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateNoteRequest actualRequest = ((CreateNoteRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getNoteId(), actualRequest.getNoteId());
    Assert.assertEquals(request.getNote(), actualRequest.getNote());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createNoteExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGrafeasV1Beta1.addException(exception);

    try {
      CreateNoteRequest request =
          CreateNoteRequest.newBuilder()
              .setParent("parent-995424086")
              .setNoteId("noteId-1039694675")
              .setNote(Note.newBuilder().build())
              .build();
      client.createNote(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchCreateNotesTest() throws Exception {
    BatchCreateNotesResponse expectedResponse =
        BatchCreateNotesResponse.newBuilder().addAllNotes(new ArrayList<Note>()).build();
    mockGrafeasV1Beta1.addResponse(expectedResponse);

    BatchCreateNotesRequest request =
        BatchCreateNotesRequest.newBuilder()
            .setParent("parent-995424086")
            .putAllNotes(new HashMap<String, Note>())
            .build();

    BatchCreateNotesResponse actualResponse = client.batchCreateNotes(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGrafeasV1Beta1.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchCreateNotesRequest actualRequest = ((BatchCreateNotesRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getNotesMap(), actualRequest.getNotesMap());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void batchCreateNotesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGrafeasV1Beta1.addException(exception);

    try {
      BatchCreateNotesRequest request =
          BatchCreateNotesRequest.newBuilder()
              .setParent("parent-995424086")
              .putAllNotes(new HashMap<String, Note>())
              .build();
      client.batchCreateNotes(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateNoteTest() throws Exception {
    Note expectedResponse =
        Note.newBuilder()
            .setName("name3373707")
            .setShortDescription("shortDescription1951089120")
            .setLongDescription("longDescription1763753952")
            .setKind(NoteKind.forNumber(0))
            .addAllRelatedUrl(new ArrayList<RelatedUrl>())
            .setExpirationTime(Timestamp.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllRelatedNoteNames(new ArrayList<String>())
            .build();
    mockGrafeasV1Beta1.addResponse(expectedResponse);

    UpdateNoteRequest request =
        UpdateNoteRequest.newBuilder()
            .setName("name3373707")
            .setNote(Note.newBuilder().build())
            .setUpdateMask(FieldMask.newBuilder().build())
            .build();

    Note actualResponse = client.updateNote(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGrafeasV1Beta1.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateNoteRequest actualRequest = ((UpdateNoteRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getNote(), actualRequest.getNote());
    Assert.assertEquals(request.getUpdateMask(), actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateNoteExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGrafeasV1Beta1.addException(exception);

    try {
      UpdateNoteRequest request =
          UpdateNoteRequest.newBuilder()
              .setName("name3373707")
              .setNote(Note.newBuilder().build())
              .setUpdateMask(FieldMask.newBuilder().build())
              .build();
      client.updateNote(request);
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
    mockGrafeasV1Beta1.addResponse(expectedResponse);

    ListNoteOccurrencesRequest request =
        ListNoteOccurrencesRequest.newBuilder()
            .setName("name3373707")
            .setFilter("filter-1274492040")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    ListNoteOccurrencesPagedResponse pagedListResponse = client.listNoteOccurrences(request);

    List<Occurrence> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getOccurrencesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockGrafeasV1Beta1.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListNoteOccurrencesRequest actualRequest = ((ListNoteOccurrencesRequest) actualRequests.get(0));

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
  public void listNoteOccurrencesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGrafeasV1Beta1.addException(exception);

    try {
      ListNoteOccurrencesRequest request =
          ListNoteOccurrencesRequest.newBuilder()
              .setName("name3373707")
              .setFilter("filter-1274492040")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      client.listNoteOccurrences(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getVulnerabilityOccurrencesSummaryTest() throws Exception {
    VulnerabilityOccurrencesSummary expectedResponse =
        VulnerabilityOccurrencesSummary.newBuilder()
            .addAllCounts(new ArrayList<VulnerabilityOccurrencesSummary.FixableTotalByDigest>())
            .build();
    mockGrafeasV1Beta1.addResponse(expectedResponse);

    GetVulnerabilityOccurrencesSummaryRequest request =
        GetVulnerabilityOccurrencesSummaryRequest.newBuilder()
            .setParent("parent-995424086")
            .setFilter("filter-1274492040")
            .build();

    VulnerabilityOccurrencesSummary actualResponse =
        client.getVulnerabilityOccurrencesSummary(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGrafeasV1Beta1.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetVulnerabilityOccurrencesSummaryRequest actualRequest =
        ((GetVulnerabilityOccurrencesSummaryRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getFilter(), actualRequest.getFilter());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getVulnerabilityOccurrencesSummaryExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGrafeasV1Beta1.addException(exception);

    try {
      GetVulnerabilityOccurrencesSummaryRequest request =
          GetVulnerabilityOccurrencesSummaryRequest.newBuilder()
              .setParent("parent-995424086")
              .setFilter("filter-1274492040")
              .build();
      client.getVulnerabilityOccurrencesSummary(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
